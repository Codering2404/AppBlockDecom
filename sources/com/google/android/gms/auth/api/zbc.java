package com.google.android.gms.auth.api;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public final class zbc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected Boolean f71265a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected String f71266b;

    public zbc() {
        this.f71265a = Boolean.FALSE;
    }

    public final zbc a(String str) {
        this.f71266b = str;
        return this;
    }

    public zbc(zbd zbdVar) {
        this.f71265a = Boolean.FALSE;
        zbd.b(zbdVar);
        this.f71265a = Boolean.valueOf(zbdVar.f71269b);
        this.f71266b = zbdVar.f71270c;
    }
}
