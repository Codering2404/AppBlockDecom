package com.google.crypto.tink;

import com.google.errorprone.annotations.Immutable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@Immutable
public final class KeyStatus {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final KeyStatus f86008b = new KeyStatus("ENABLED");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final KeyStatus f86009c = new KeyStatus("DISABLED");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final KeyStatus f86010d = new KeyStatus("DESTROYED");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f86011a;

    private KeyStatus(String str) {
        this.f86011a = str;
    }

    public String toString() {
        return this.f86011a;
    }
}
