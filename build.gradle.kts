import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val spec = "$rootDir/src/main/resources/openapi/api.yaml"
val generatedSourcesDir = "$buildDir/generated/openapi"
val springdocVersion = "1.4.3"

plugins {
	id("org.springframework.boot") version "2.3.2.RELEASE"
	id("io.spring.dependency-management") version "1.0.9.RELEASE"
	id("org.openapi.generator") version "4.2.3"
	id("org.sonarqube") version "3.0"

	kotlin("jvm") version "1.3.72"
	kotlin("plugin.spring") version "1.3.72"
	kotlin("plugin.serialization") version "1.3.72"
	kotlin("plugin.jpa") version "1.3.72"
	kotlin("plugin.allopen") version "1.3.72"

	idea
	jacoco
}

group = "meemo"
version = "1.0.0"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
	mavenCentral()
}

extra["springCloudVersion"] = "Hoxton.SR6"

dependencyManagement {
	imports {
		mavenBom("org.springframework.cloud:spring-cloud-dependencies:${property("springCloudVersion")}")
	}
}

dependencies {
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor")

	// JPA
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	runtimeOnly("com.h2database:h2")

	// Web
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.springframework.boot:spring-boot-starter-webflux")

	// Cloud
	implementation("org.springframework.cloud:spring-cloud-starter-consul-config")
	implementation("org.springframework.cloud:spring-cloud-starter-consul-discovery")

	// Metrics
	implementation("org.springframework.boot:spring-boot-starter-actuator")
	implementation("io.micrometer:micrometer-registry-prometheus")

	// Documentation
	implementation("org.springdoc:springdoc-openapi-webflux-core:$springdocVersion")
	implementation("org.springdoc:springdoc-openapi-webflux-ui:$springdocVersion")
	implementation("org.springdoc:springdoc-openapi-kotlin:$springdocVersion")

	developmentOnly("org.springframework.boot:spring-boot-devtools")

	testImplementation("org.springframework.boot:spring-boot-starter-test") {
		exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
	}
	implementation("io.projectreactor.kotlin:reactor-kotlin-extensions")

	testImplementation("io.projectreactor:reactor-test")
}

tasks.withType<Test> {
	useJUnitPlatform()
	finalizedBy("jacocoTestReport")
}

tasks.withType<KotlinCompile> {
	dependsOn("openApiGenerate")
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "11"
	}
}


tasks.withType<JacocoReport> {
	dependsOn(tasks.test)
	reports {
		xml.isEnabled = true
		csv.isEnabled = false
		html.destination = file("${buildDir}/jacocoHtml")
	}
}

allOpen {
	annotation("javax.persistence.Entity")
	annotation("javax.persistence.Embeddable")
	annotation("javax.persistence.MappedSuperclass")
}

sonarqube {
	properties {
		property("sonar.host.url", "https://sonarcloud.io")
	}
}

springBoot {
	buildInfo()
	mainClassName = "meemo.MeemoServiceApplicationKt"
}

openApiGenerate {
	generatorName.set("kotlin-spring")

	inputSpec.set(spec)
	outputDir.set(generatedSourcesDir)
	ignoreFileOverride.set("$rootDir/src/main/resources/openapi/.openapi-generator-ignore")

	groupId.set("meemo")
	id.set("meemo-service")
	apiPackage.set("meemo.service.api")
	modelPackage.set("meemo.service.api.model")

	configOptions.set(mapOf(
			"dateLibrary" to "java8",
			"reactive" to "true",
			"beanValidations" to "true",
			"serviceInterface" to "true",
			"serviceImplementation" to "false"
	))
}

sourceSets {
	getByName("main") {
		java {
			srcDir("$generatedSourcesDir/src/main/kotlin")
		}
	}
}

idea {
	module {
		sourceDirs.add(file("$buildDir/generated/openapi/src/main/kotlin"))
		generatedSourceDirs.add(file("$buildDir/generated/openapi/src/main/kotlin"))
	}
}