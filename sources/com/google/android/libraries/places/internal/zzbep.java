package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzbep implements zzbfm {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final zzbev f76117b = new zzben();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zzbev f76118a;

    public zzbep() {
        zzbdj zzbdjVarA = zzbdj.a();
        int i3 = zzbcc.f75986a;
        zzbeo zzbeoVar = new zzbeo(zzbdjVarA, f76117b);
        byte[] bArr = zzbeb.f76092b;
        this.f76118a = zzbeoVar;
    }

    @Override // com.google.android.libraries.places.internal.zzbfm
    public final zzbfl zza(Class cls) {
        int i3 = zzbfn.f76155b;
        if (!zzbdq.class.isAssignableFrom(cls)) {
            int i4 = zzbcc.f75986a;
        }
        zzbeu zzbeuVarZzc = this.f76118a.zzc(cls);
        if (zzbeuVarZzc.zza()) {
            int i5 = zzbcc.f75986a;
            return zzbfb.c(zzbfn.b(), zzbde.a(), zzbeuVarZzc.zzb());
        }
        int i6 = zzbcc.f75986a;
        return zzbfa.r(cls, zzbeuVarZzc, zzbfe.a(), zzbel.a(), zzbfn.b(), zzbeuVarZzc.zzc() + (-1) != 1 ? zzbde.a() : null, zzbet.a());
    }
}
