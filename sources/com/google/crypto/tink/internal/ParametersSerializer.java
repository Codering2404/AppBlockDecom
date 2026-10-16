package com.google.crypto.tink.internal;

import com.google.crypto.tink.Parameters;
import com.google.crypto.tink.internal.Serialization;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public abstract class ParametersSerializer<ParametersT extends Parameters, SerializationT extends Serialization> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Class f86262a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Class f86263b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface ParametersSerializationFunction<ParametersT extends Parameters, SerializationT extends Serialization> {
    }

    public static ParametersSerializer a(final ParametersSerializationFunction parametersSerializationFunction, Class cls, Class cls2) {
        return new ParametersSerializer<Parameters, Serialization>(cls, cls2) { // from class: com.google.crypto.tink.internal.ParametersSerializer.1
        };
    }

    public Class b() {
        return this.f86262a;
    }

    public Class c() {
        return this.f86263b;
    }

    private ParametersSerializer(Class cls, Class cls2) {
        this.f86262a = cls;
        this.f86263b = cls2;
    }
}
