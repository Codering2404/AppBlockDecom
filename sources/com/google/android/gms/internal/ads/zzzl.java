package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzzl extends zzwy {
    private final zzak zzc;

    private zzzl(zzbf zzbfVar, zzak zzakVar) {
        super(zzbfVar);
        this.zzc = zzakVar;
    }

    public static zzzl zzp(zzbf zzbfVar, zzak zzakVar) {
        return zzbfVar instanceof zzzl ? new zzzl(((zzzl) zzbfVar).zzb, zzakVar) : new zzzl(zzbfVar, zzakVar);
    }

    @Override // com.google.android.gms.internal.ads.zzwy, com.google.android.gms.internal.ads.zzbf
    public final zzbe zzb(int i3, zzbe zzbeVar, long j3) {
        this.zzb.zzb(i3, zzbeVar, j3);
        zzak zzakVar = this.zzc;
        zzbeVar.zzd = zzakVar;
        zzag zzagVar = zzakVar.zzb;
        zzbeVar.zzc = null;
        return zzbeVar;
    }
}
