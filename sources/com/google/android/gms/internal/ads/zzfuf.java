package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzfuf extends zzcco {
    private zzcci zza;
    private zzfsp zzb;
    private String zzc;

    zzfuf(zzcci zzcciVar, zzfsp zzfspVar, String str) {
        this.zza = zzcciVar;
        this.zzb = zzfspVar;
        this.zzc = str;
    }

    @Override // com.google.android.gms.internal.ads.zzccp
    public final void zze() {
        zzfsp zzfspVar = this.zzb;
        zzcci zzcciVar = this.zza;
        if (zzcciVar == null || zzfspVar == null) {
            return;
        }
        zzfspVar.zza(zzcciVar);
        this.zza = null;
        this.zzb = null;
        this.zzc = null;
    }

    @Override // com.google.android.gms.internal.ads.zzccp
    public final void zzf(int i3) {
        this.zza = null;
        this.zzb = null;
        this.zzc = null;
    }

    @Override // com.google.android.gms.internal.ads.zzccp
    public final void zzg(com.google.android.gms.ads.internal.client.zze zzeVar) {
        zzfsp zzfspVar = this.zzb;
        if (this.zza == null || zzfspVar == null) {
            return;
        }
        String string = zzeVar.N().toString();
        String str = this.zzc;
        StringBuilder sb = new StringBuilder(String.valueOf(string).length() + 51 + String.valueOf(str).length());
        sb.append("Failed to load rewarded ad with error: ");
        sb.append(string);
        sb.append(", adUnitId: ");
        sb.append(str);
        com.google.android.gms.ads.internal.util.client.zzo.f(sb.toString());
        ((zzfto) zzfspVar).zza.zzI(zzeVar);
        this.zza = null;
        this.zzb = null;
        this.zzc = null;
    }
}
