package com.aiceltech.devassignment;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/api")
public class TestController {

    @RequestMapping(value = "/test", method = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.PATCH, RequestMethod.DELETE})
    public void test() {
        log.info("test call");
    }

    @RequestMapping(value = "/testParam", method = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.PATCH, RequestMethod.DELETE})
    public void testParam(@RequestParam String param) {
        log.info("testParam call, param = {}", param);
    }

    @RequestMapping(value = "/testBody", method = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.PATCH, RequestMethod.DELETE})
    public void testBody(@RequestBody TestRequest testRequest) {
        log.info("testParam call, testRequest = {}", testRequest);
    }

    public static class TestRequest {
        public String id;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        @Override
        public String toString() {
            final StringBuffer sb = new StringBuffer("TestRequest{");
            sb.append("id='").append(id).append('\'');
            sb.append('}');
            return sb.toString();
        }
    }

}
