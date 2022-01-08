/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package com.grapefruit.cxf.rs.client;

import com.grapefruit.cxf.rs.service.api.HelloService;
import org.apache.cxf.jaxrs.client.WebClient;
import org.apache.cxf.jaxrs.client.spring.EnableJaxRsProxyClient;
import org.apache.cxf.jaxrs.client.spring.EnableJaxRsWebClient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication()
@EnableJaxRsWebClient
@EnableJaxRsProxyClient
public class RestClientApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(RestClientApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);
    }

    @Bean
    CommandLineRunner initWebClientRunner(final WebClient webClient) {
        /*WebClient webClient = WebClient.create("http://127.0.0.1:8080/");*/
        return runArgs -> System.out.println(webClient.path("sayHello/ApacheCxfWebClientUser").get(String.class));
    }

    @Bean
    CommandLineRunner initProxyClientRunner(final HelloService client) {
        return runArgs -> System.out.println(client.sayHello("ApacheCxfProxyUser"));
    }
}

