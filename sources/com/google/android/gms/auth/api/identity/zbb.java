package com.google.android.gms.auth.api.identity;

import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zbb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f71154a;

    private zbb() {
    }

    public static final zbb c(zbc zbcVar) {
        String strB = zbcVar.b();
        zbb zbbVar = new zbb();
        if (strB != null) {
            zbbVar.f71154a = Preconditions.g(strB);
        }
        return zbbVar;
    }

    public final zbb a(String str) {
        this.f71154a = Preconditions.g(str);
        return this;
    }

    public final zbc b() {
        return new zbc(this.f71154a);
    }
}
