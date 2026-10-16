package com.google.crypto.tink.internal;

import com.google.crypto.tink.internal.Serialization;
import com.google.crypto.tink.util.Bytes;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public abstract class ParametersParser<SerializationT extends Serialization> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Bytes f86259a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Class f86260b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface ParametersParsingFunction<SerializationT extends Serialization> {
    }

    public static ParametersParser a(final ParametersParsingFunction parametersParsingFunction, Bytes bytes, Class cls) {
        return new ParametersParser<Serialization>(bytes, cls) { // from class: com.google.crypto.tink.internal.ParametersParser.1
        };
    }

    public final Bytes b() {
        return this.f86259a;
    }

    public final Class c() {
        return this.f86260b;
    }

    private ParametersParser(Bytes bytes, Class cls) {
        this.f86259a = bytes;
        this.f86260b = cls;
    }
}
