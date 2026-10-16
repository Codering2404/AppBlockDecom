package com.google.android.libraries.places.internal;

import com.google.common.base.Preconditions;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzbir {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f76258a;

    private zzbir(String str, Object obj) {
        this.f76258a = str;
    }

    public static zzbir a(String str) {
        Preconditions.u(str, "debugString");
        return new zzbir(str, null);
    }

    public final String toString() {
        return this.f76258a;
    }
}
