package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzbid implements zzbih {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Object f76234c = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile zzbih f76235a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile Object f76236b = f76234c;

    private zzbid(zzbih zzbihVar) {
        this.f76235a = zzbihVar;
    }

    public static zzbih a(zzbih zzbihVar) {
        return zzbihVar instanceof zzbid ? zzbihVar : new zzbid(zzbihVar);
    }

    private final synchronized Object b() {
        try {
            Object obj = this.f76236b;
            Object obj2 = f76234c;
            if (obj != obj2) {
                return obj;
            }
            Object objZzb = this.f76235a.zzb();
            Object obj3 = this.f76236b;
            if (obj3 != obj2 && obj3 != objZzb) {
                throw new IllegalStateException("Scoped provider was invoked recursively returning different results: " + obj3 + " & " + objZzb + ". This is likely due to a circular dependency.");
            }
            this.f76236b = objZzb;
            this.f76235a = null;
            return objZzb;
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.google.android.libraries.places.internal.zzcez
    public final Object zzb() {
        Object obj = this.f76236b;
        return obj == f76234c ? b() : obj;
    }
}
