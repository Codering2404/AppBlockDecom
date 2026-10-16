package com.google.android.libraries.places.internal;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzrq {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f78523a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final int f78524b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    zzrq f78525c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final Map f78526d = new HashMap(0);

    zzrq(int i3, int i4, zzrq zzrqVar) {
        if (i3 > i4) {
            throw new IllegalArgumentException();
        }
        this.f78523a = i3;
        this.f78524b = i4;
        this.f78525c = null;
    }

    public final String toString() {
        int iIdentityHashCode = System.identityHashCode(this);
        StringBuilder sb = new StringBuilder(String.valueOf(iIdentityHashCode).length() + 4);
        sb.append("Node");
        sb.append(iIdentityHashCode);
        return sb.toString();
    }
}
