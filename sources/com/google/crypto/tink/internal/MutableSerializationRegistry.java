package com.google.crypto.tink.internal;

import com.google.crypto.tink.internal.SerializationRegistry;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class MutableSerializationRegistry {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final MutableSerializationRegistry f86257b = new MutableSerializationRegistry();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AtomicReference f86258a = new AtomicReference(new SerializationRegistry.Builder().e());

    public static MutableSerializationRegistry a() {
        return f86257b;
    }

    public synchronized void b(KeyParser keyParser) {
        this.f86258a.set(new SerializationRegistry.Builder((SerializationRegistry) this.f86258a.get()).f(keyParser).e());
    }

    public synchronized void c(KeySerializer keySerializer) {
        this.f86258a.set(new SerializationRegistry.Builder((SerializationRegistry) this.f86258a.get()).g(keySerializer).e());
    }

    public synchronized void d(ParametersParser parametersParser) {
        this.f86258a.set(new SerializationRegistry.Builder((SerializationRegistry) this.f86258a.get()).h(parametersParser).e());
    }

    public synchronized void e(ParametersSerializer parametersSerializer) {
        this.f86258a.set(new SerializationRegistry.Builder((SerializationRegistry) this.f86258a.get()).i(parametersSerializer).e());
    }
}
