package com.google.android.gms.internal.ads;

import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzeqk extends zzcbz {
    final /* synthetic */ zzdfc zza;
    final /* synthetic */ zzdcp zzb;
    final /* synthetic */ zzddy zzc;
    final /* synthetic */ zzdlh zzd;

    zzeqk(zzeql zzeqlVar, zzdfc zzdfcVar, zzdcp zzdcpVar, zzddy zzddyVar, zzdlh zzdlhVar) {
        this.zza = zzdfcVar;
        this.zzb = zzdcpVar;
        this.zzc = zzddyVar;
        this.zzd = zzdlhVar;
        Objects.requireNonNull(zzeqlVar);
    }

    @Override // com.google.android.gms.internal.ads.zzcca
    public final void zzh(IObjectWrapper iObjectWrapper) {
        this.zza.zzh();
    }

    @Override // com.google.android.gms.internal.ads.zzcca
    public final void zzi(IObjectWrapper iObjectWrapper) {
        this.zzd.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzcca
    public final void zzj(IObjectWrapper iObjectWrapper) {
        this.zza.zzdU(4);
    }

    @Override // com.google.android.gms.internal.ads.zzcca
    public final void zzk(IObjectWrapper iObjectWrapper, zzccb zzccbVar) {
        this.zzd.zzb(zzccbVar);
    }

    @Override // com.google.android.gms.internal.ads.zzcca
    public final void zzl(IObjectWrapper iObjectWrapper) {
        this.zzb.onAdClicked();
    }

    @Override // com.google.android.gms.internal.ads.zzcca
    public final void zzn(IObjectWrapper iObjectWrapper) {
        this.zzc.zzb();
    }

    @Override // com.google.android.gms.internal.ads.zzcca
    public final void zzo(IObjectWrapper iObjectWrapper) {
        this.zzc.zzf();
    }

    @Override // com.google.android.gms.internal.ads.zzcca
    public final void zzp(IObjectWrapper iObjectWrapper) {
        this.zzd.zzb(null);
    }

    @Override // com.google.android.gms.internal.ads.zzcca
    public final void zze(IObjectWrapper iObjectWrapper) {
    }

    @Override // com.google.android.gms.internal.ads.zzcca
    public final void zzg(IObjectWrapper iObjectWrapper) {
    }

    @Override // com.google.android.gms.internal.ads.zzcca
    public final void zzf(IObjectWrapper iObjectWrapper, int i3) {
    }

    @Override // com.google.android.gms.internal.ads.zzcca
    public final void zzm(IObjectWrapper iObjectWrapper, int i3) {
    }
}
