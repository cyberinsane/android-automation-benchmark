package com.deloittedigital.automation.benchmark;

import androidx.annotation.NonNull;

import org.junit.rules.ExternalResource;

import java.io.IOException;

import okhttp3.mockwebserver.Dispatcher;
import okhttp3.mockwebserver.MockWebServer;

public class MockWebServerRule extends ExternalResource {

    private final MockWebServer mockWebServer = new MockWebServer();
    private final Dispatcher dispatcher;

    public MockWebServerRule() {
        this(new MockResponseDispatcher(BuildConfig.FLAVOR.toUpperCase()));
    }

    @Deprecated
    public MockWebServerRule(@NonNull String airlineFlavor) {
        this(new MockResponseDispatcher(airlineFlavor.toUpperCase()));
    }

    public MockWebServerRule(Dispatcher dispatcher) {
        this.dispatcher = dispatcher;
    }

    @Override
    protected void before() throws IOException {
        mockWebServer.setDispatcher(dispatcher);
        mockWebServer.start(8080);
    }

    @Override
    protected void after() {
        try {
            mockWebServer.shutdown();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Dispatcher getDispatcher() {
        return dispatcher;
    }

    public MockWebServer getMockWebServer() {
        return mockWebServer;
    }
}

