package meemo.version.controller;

import lombok.extern.slf4j.Slf4j;
import meemo.api.VersionsApi;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
@Slf4j
public class VersionsApiController implements VersionsApi {
}
