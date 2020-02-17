package com.deloittedigital.automation.benchmark.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static com.deloittedigital.automation.benchmark.annotations.TestNetworkEnvironment.DEFAULT;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface NetworkEnvironment {

  @TestNetworkEnvironment String environment() default DEFAULT;
}
