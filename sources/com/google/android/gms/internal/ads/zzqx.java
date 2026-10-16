package com.google.android.gms.internal.ads;

import android.media.AudioDeviceInfo;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzqx {
    private final zzv zza;
    private AudioDeviceInfo zzc;
    private zzd zzb = zzd.zza;
    private int zzd = 0;
    private int zze = -1;
    private int zzf = -1;

    public zzqx(zzv zzvVar) {
        this.zza = zzvVar;
    }

    public final zzqx zza(zzd zzdVar) {
        this.zzb = zzdVar;
        return this;
    }

    public final zzqx zzb(AudioDeviceInfo audioDeviceInfo) {
        this.zzc = audioDeviceInfo;
        return this;
    }

    public final zzqx zzc(int i3) {
        this.zzd = i3;
        return this;
    }

    public final zzqx zzd(int i3) {
        this.zze = i3;
        return this;
    }

    public final zzqx zze(int i3) {
        this.zzf = -1;
        return this;
    }

    final /* synthetic */ zzv zzf() {
        return this.zza;
    }

    final /* synthetic */ zzd zzg() {
        return this.zzb;
    }

    final /* synthetic */ AudioDeviceInfo zzh() {
        return this.zzc;
    }

    final /* synthetic */ int zzi() {
        return this.zzd;
    }

    final /* synthetic */ int zzj() {
        return this.zze;
    }

    final /* synthetic */ int zzk() {
        return this.zzf;
    }
}
