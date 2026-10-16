package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzfsu extends zzbgl {
    private zzfsp zza;
    private String zzb;

    zzfsu(zzfsp zzfspVar, String str) {
        this.zza = zzfspVar;
        this.zzb = str;
    }

    @Override // com.google.android.gms.internal.ads.zzbgm
    public final void zzb(zzbgj zzbgjVar) {
        zzfsp zzfspVar = this.zza;
        if (zzfspVar == null) {
            return;
        }
        zzfspVar.zza(zzbgjVar);
        this.zza = null;
        this.zzb = null;
    }

    @Override // com.google.android.gms.internal.ads.zzbgm
    public final void zzc(int i3) {
        this.zza = null;
        this.zzb = null;
    }

    @Override // com.google.android.gms.internal.ads.zzbgm
    public final void zzd(com.google.android.gms.ads.internal.client.zze zzeVar) {
        zzfsp zzfspVar = this.zza;
        if (zzfspVar == null) {
            return;
        }
        String string = zzeVar.N().toString();
        String str = this.zzb;
        StringBuilder sb = new StringBuilder(string.length() + 60 + String.valueOf(str).length());
        sb.append("Failed to load app open ad with error parcel: ");
        sb.append(string);
        sb.append(" for ad unit: ");
        sb.append(str);
        com.google.android.gms.ads.internal.util.client.zzo.f(sb.toString());
        ((zzfto) zzfspVar).zza.zzI(zzeVar);
        this.zza = null;
        this.zzb = null;
    }
}
