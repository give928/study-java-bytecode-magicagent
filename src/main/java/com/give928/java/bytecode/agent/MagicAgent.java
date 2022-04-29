package com.give928.java.bytecode.agent;

import net.bytebuddy.agent.builder.AgentBuilder;
import net.bytebuddy.implementation.FixedValue;
import net.bytebuddy.matcher.ElementMatchers;

import java.lang.instrument.Instrumentation;

import static net.bytebuddy.matcher.ElementMatchers.named;

public class MagicAgent {
    public static void premain(String agentArgs, Instrumentation inst) {
        new AgentBuilder.Default()
                .type(ElementMatchers.any())
                .transform(
                        (builder, typeDescription, classLoader, module) -> builder.method(named("pullOut")).intercept(
                                FixedValue.value("Rabbit by javaagent")))
                .installOn(inst);
    }
}
