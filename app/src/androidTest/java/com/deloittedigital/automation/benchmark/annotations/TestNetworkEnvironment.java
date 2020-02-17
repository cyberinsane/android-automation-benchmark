package com.deloittedigital.automation.benchmark.annotations;

import androidx.annotation.StringDef;

import java.lang.annotation.Retention;

import static java.lang.annotation.RetentionPolicy.SOURCE;

@Retention(SOURCE)
@StringDef({TestNetworkEnvironment.DEFAULT, TestNetworkEnvironment.LOCAL_STUB_SERVER, TestNetworkEnvironment.OKHTTP_MOCK_SERVER, TestNetworkEnvironment.UAT_SERVER, TestNetworkEnvironment.DEV_SERVER})
public @interface TestNetworkEnvironment {

    String DEFAULT = "default";
    String LOCAL_STUB_SERVER = "http://localhost:8090/";
    String OKHTTP_MOCK_SERVER = "http://localhost:8080/";
    String UAT_SERVER = "";
    String DEV_SERVER = "";
}
