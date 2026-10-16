package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzadi {
    private final Context zza;
    private final zzadu zzb;
    private zzbs zzc;
    private boolean zzd;
    private boolean zzf;
    private long zzg = 15000;
    private final zzadv zzh = new zzadv(1.0f);
    private zzdo zze = zzdo.zza;

    public zzadi(Context context, zzadu zzaduVar) {
        this.zza = context.getApplicationContext();
        this.zzb = zzaduVar;
    }

    public final zzadi zza(boolean z2) {
        this.zzd = true;
        return this;
    }

    public final zzadi zzb(zzdo zzdoVar) {
        this.zze = zzdoVar;
        return this;
    }

    public final zzadi zzc(long j3) {
        this.zzg = j3;
        return this;
    }

    public final zzadq zzd() {
        zzgtj.zzi(!this.zzf);
        if (this.zzc == null) {
            this.zzc = new zzado(false);
        }
        zzadq zzadqVar = new zzadq(this, null);
        this.zzf = true;
        return zzadqVar;
    }

    final /* synthetic */ Context zze() {
        return this.zza;
    }

    final /* synthetic */ zzadu zzf() {
        return this.zzb;
    }

    final /* synthetic */ zzbs zzg() {
        return this.zzc;
    }

    final /* synthetic */ boolean zzh() {
        return this.zzd;
    }

    final /* synthetic */ zzdo zzi() {
        return this.zze;
    }

    final /* synthetic */ long zzj() {
        return this.zzg;
    }

    final /* synthetic */ zzadv zzk() {
        return this.zzh;
    }
}
