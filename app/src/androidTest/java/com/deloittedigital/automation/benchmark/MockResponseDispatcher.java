package com.deloittedigital.automation.benchmark;

import org.jetbrains.annotations.NotNull;

import okhttp3.mockwebserver.Dispatcher;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.RecordedRequest;

class MockResponseDispatcher extends Dispatcher {

    @NotNull
    @Override
    public MockResponse dispatch(@NotNull RecordedRequest recordedRequest) throws InterruptedException {
        return null;
    }

    public MockResponseDispatcher(String s) {
    }
}

