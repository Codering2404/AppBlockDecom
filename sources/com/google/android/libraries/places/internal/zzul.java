package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public enum zzul {
    GENERAL(false, true),
    BOOLEAN(false, false),
    CHARACTER(false, false),
    INTEGRAL(true, false),
    FLOAT(true, true);


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f78657a;

    zzul(boolean z2, boolean z3) {
        this.f78657a = z3;
    }

    final boolean a() {
        return this.f78657a;
    }
}
