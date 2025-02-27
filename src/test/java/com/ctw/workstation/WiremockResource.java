package com.ctw.workstation;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import io.quarkus.test.common.QuarkusTestResourceLifecycleManager;

import java.util.Map;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

public class WiremockResource implements QuarkusTestResourceLifecycleManager {

    WireMockServer wiremockServer;

    @Override
    public Map<String, String> start() {
        wiremockServer = new WireMockServer();
        wiremockServer.start();
        WireMock.configureFor(wiremockServer.port());
        wiremockServer.stubFor(get(urlEqualTo("/external/hello"))
                .willReturn(aResponse()
                        .withStatus(200)));

        wiremockServer.stubFor(post(urlEqualTo("/external/hello"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withBody("Hello Margarida!")));

        return Map.of("external-api.url", wiremockServer.baseUrl());
    }

    @Override
    public void stop() {
        wiremockServer.stop();
    }
}
