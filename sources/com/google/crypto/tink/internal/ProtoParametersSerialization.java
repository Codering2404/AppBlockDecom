package com.google.crypto.tink.internal;

import com.google.crypto.tink.proto.KeyTemplate;
import com.google.crypto.tink.util.Bytes;
import com.google.errorprone.annotations.Immutable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@Immutable
public final class ProtoParametersSerialization implements Serialization {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Bytes f86276a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final KeyTemplate f86277b;

    public KeyTemplate a() {
        return this.f86277b;
    }

    public Bytes b() {
        return this.f86276a;
    }
}
