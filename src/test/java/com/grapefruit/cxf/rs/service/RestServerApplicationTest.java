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
package com.grapefruit.cxf.rs.service;

import org.apache.cxf.jaxrs.client.WebClient;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;

@SpringBootTest(classes = RestServerApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)
public class RestServerApplicationTest {

    @LocalServerPort
    private int port;

    @Test
    public void testHelloRequest() throws Exception {
        WebClient wc = WebClient.create("http://localhost:" + port + "/services/helloservice");
        wc.accept("text/plain");

        // HelloServiceImpl1
        wc.path("sayHello").path("ApacheCxfUser");
        String greeting = wc.get(String.class);
        System.out.println("greeting:" + greeting);
        //assertEquals("Hello ApacheCxfUser, Welcome to CXF RS Spring Boot World!!!", greeting);

        // Reverse to the starting URI
        wc.back(true);

        // HelloServiceImpl2
        wc.path("sayHello2").path("ApacheCxfUser");
        greeting = wc.get(String.class);
        System.out.println("greeting:" + greeting);
        //assertEquals("Hello2 ApacheCxfUser, Welcome to CXF RS Spring Boot World!!!", greeting);
    }

}
