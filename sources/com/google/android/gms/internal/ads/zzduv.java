package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzduv implements Callable {
    private final com.google.android.gms.ads.internal.zza zza;
    private final Context zzb;
    private final zzdzl zzc;
    private final zzekg zzd;
    private final Executor zze;
    private final zzbap zzf;
    private final VersionInfoParcel zzg;
    private final zzfsc zzh;
    private final zzekr zzi;
    private final zzflc zzj;

    public zzduv(Context context, Executor executor, zzbap zzbapVar, VersionInfoParcel versionInfoParcel, com.google.android.gms.ads.internal.zza zzaVar, zzclk zzclkVar, zzekg zzekgVar, zzfsc zzfscVar, zzdzl zzdzlVar, zzekr zzekrVar, zzflc zzflcVar) {
        this.zzb = context;
        this.zze = executor;
        this.zzf = zzbapVar;
        this.zzg = versionInfoParcel;
        this.zza = zzaVar;
        this.zzd = zzekgVar;
        this.zzh = zzfscVar;
        this.zzc = zzdzlVar;
        this.zzi = zzekrVar;
        this.zzj = zzflcVar;
    }

    @Override // java.util.concurrent.Callable
    public final /* bridge */ /* synthetic */ Object call() throws Exception {
        zzdux zzduxVar = new zzdux(this);
        zzduxVar.zza();
        return zzduxVar;
    }

    final /* synthetic */ com.google.android.gms.ads.internal.zza zza() {
        return this.zza;
    }

    final /* synthetic */ Context zzb() {
        return this.zzb;
    }

    final /* synthetic */ zzdzl zzc() {
        return this.zzc;
    }

    final /* synthetic */ zzekg zzd() {
        return this.zzd;
    }

    final /* synthetic */ Executor zze() {
        return this.zze;
    }

    final /* synthetic */ zzbap zzf() {
        return this.zzf;
    }

    final /* synthetic */ VersionInfoParcel zzg() {
        return this.zzg;
    }

    final /* synthetic */ zzfsc zzh() {
        return this.zzh;
    }

    final /* synthetic */ zzekr zzi() {
        return this.zzi;
    }

    final /* synthetic */ zzflc zzj() {
        return this.zzj;
    }
}
