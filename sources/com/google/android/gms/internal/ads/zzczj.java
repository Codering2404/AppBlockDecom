package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.ads.zzbhv;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzczj implements zzdef, com.google.android.gms.ads.internal.client.zza, zzdfx, zzddl, zzdcr, zzdii {
    private final Clock zza;
    private final zzcex zzb;

    public zzczj(Clock clock, zzcex zzcexVar) {
        this.zza = clock;
        this.zzb = zzcexVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zza
    public final void onAdClicked() {
        this.zzb.zzf();
    }

    @Override // com.google.android.gms.internal.ads.zzdfx
    public final void zzdQ(zzfkq zzfkqVar) {
        this.zzb.zzd(this.zza.a());
    }

    @Override // com.google.android.gms.internal.ads.zzddl
    public final void zzdr() {
        this.zzb.zze();
    }

    @Override // com.google.android.gms.internal.ads.zzdcr
    public final void zzds() {
        this.zzb.zzg();
    }

    @Override // com.google.android.gms.internal.ads.zzdef
    public final void zzg() {
        this.zzb.zzh(true);
    }

    public final void zzi(com.google.android.gms.ads.internal.client.zzm zzmVar) {
        this.zzb.zza(zzmVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdii
    public final void zzj(zzbhv.zzb zzbVar) {
        this.zzb.zzb();
    }

    @Override // com.google.android.gms.internal.ads.zzdii
    public final void zzl(zzbhv.zzb zzbVar) {
        this.zzb.zzc();
    }

    public final String zzp() {
        return this.zzb.zzj();
    }

    @Override // com.google.android.gms.internal.ads.zzdcr
    public final void zzdK() {
    }

    @Override // com.google.android.gms.internal.ads.zzdcr
    public final void zzdt() {
    }

    @Override // com.google.android.gms.internal.ads.zzdcr
    public final void zze() {
    }

    @Override // com.google.android.gms.internal.ads.zzdcr
    public final void zzf() {
    }

    @Override // com.google.android.gms.internal.ads.zzdii
    public final void zzo() {
    }

    @Override // com.google.android.gms.internal.ads.zzdfx
    public final void zzdP(zzcbd zzcbdVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzdii
    public final void zzk(zzbhv.zzb zzbVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzdii
    public final void zzm(boolean z2) {
    }

    @Override // com.google.android.gms.internal.ads.zzdii
    public final void zzn(boolean z2) {
    }

    @Override // com.google.android.gms.internal.ads.zzdcr
    public final void zzd(zzcbp zzcbpVar, String str, String str2) {
    }
}
