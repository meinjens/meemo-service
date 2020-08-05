package meemo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MeemoServiceApplication

fun main(args: Array<String>) {
	runApplication<MeemoServiceApplication>(*args)
}
