package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzcqc implements com.google.android.gms.ads.nonagon.signalgeneration.zzw {
    private final zzcox zza;
    private zzdcb zzb;
    private com.google.android.gms.ads.nonagon.signalgeneration.zzat zzc;

    /* synthetic */ zzcqc(zzcox zzcoxVar, byte[] bArr) {
        this.zza = zzcoxVar;
    }

    @Override // com.google.android.gms.ads.nonagon.signalgeneration.zzw
    public final com.google.android.gms.ads.nonagon.signalgeneration.zzx zza() {
        zzinc.zzc(this.zzb, zzdcb.class);
        zzinc.zzc(this.zzc, com.google.android.gms.ads.nonagon.signalgeneration.zzat.class);
        return new zzcqd(this.zza, this.zzc, new zzcyz(), new zzdba(), new zzeaa(), this.zzb, null, null);
    }

    @Override // com.google.android.gms.ads.nonagon.signalgeneration.zzw
    public final /* bridge */ /* synthetic */ com.google.android.gms.ads.nonagon.signalgeneration.zzw zzb(com.google.android.gms.ads.nonagon.signalgeneration.zzat zzatVar) {
        this.zzc = zzatVar;
        return this;
    }

    @Override // com.google.android.gms.ads.nonagon.signalgeneration.zzw
    public final /* bridge */ /* synthetic */ com.google.android.gms.ads.nonagon.signalgeneration.zzw zzc(zzdcb zzdcbVar) {
        this.zzb = zzdcbVar;
        return this;
    }
}
