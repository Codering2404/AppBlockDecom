package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzbil implements zzbih {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Object f76242c = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile zzbih f76243a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile Object f76244b = f76242c;

    private zzbil(zzbih zzbihVar) {
        this.f76243a = zzbihVar;
    }

    public static zzbih a(zzbih zzbihVar) {
        return new zzbil(zzbihVar);
    }

    @Override // com.google.android.libraries.places.internal.zzcez
    public final Object zzb() {
        Object obj = this.f76244b;
        if (obj != f76242c) {
            return obj;
        }
        zzbih zzbihVar = this.f76243a;
        if (zzbihVar == null) {
            return this.f76244b;
        }
        Object objZzb = zzbihVar.zzb();
        this.f76244b = objZzb;
        this.f76243a = null;
        return objZzb;
    }
}
