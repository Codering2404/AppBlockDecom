package com.google.crypto.tink.internal;

import com.google.crypto.tink.Key;
import com.google.crypto.tink.internal.Serialization;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public abstract class KeySerializer<KeyT extends Key, SerializationT extends Serialization> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Class f86231a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Class f86232b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface KeySerializationFunction<KeyT extends Key, SerializationT extends Serialization> {
    }

    public static KeySerializer a(final KeySerializationFunction keySerializationFunction, Class cls, Class cls2) {
        return new KeySerializer<Key, Serialization>(cls, cls2) { // from class: com.google.crypto.tink.internal.KeySerializer.1
        };
    }

    public Class b() {
        return this.f86231a;
    }

    public Class c() {
        return this.f86232b;
    }

    private KeySerializer(Class cls, Class cls2) {
        this.f86231a = cls;
        this.f86232b = cls2;
    }
}
