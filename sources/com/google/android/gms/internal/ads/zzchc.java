package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.ViewGroup;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzchc {
    private final Context zza;
    private final zzchn zzb;
    private final ViewGroup zzc;
    private final zzdzl zzd;
    private zzchb zze;

    public zzchc(Context context, ViewGroup viewGroup, zzcku zzckuVar, zzdzl zzdzlVar) {
        this.zza = context.getApplicationContext() != null ? context.getApplicationContext() : context;
        this.zzc = viewGroup;
        this.zzb = zzckuVar;
        this.zze = null;
        this.zzd = zzdzlVar;
    }

    public final Integer zza() {
        zzchb zzchbVar = this.zze;
        if (zzchbVar != null) {
            return zzchbVar.zzl();
        }
        return null;
    }

    public final void zzb(int i3, int i4, int i5, int i6) {
        Preconditions.f("The underlay may only be modified from the UI thread.");
        zzchb zzchbVar = this.zze;
        if (zzchbVar != null) {
            zzchbVar.zzn(i3, i4, i5, i6);
        }
    }

    public final void zzc(int i3, int i4, int i5, int i6, int i7, boolean z2, zzchm zzchmVar) {
        if (this.zze != null) {
            return;
        }
        zzchn zzchnVar = this.zzb;
        zzbix.zza(zzchnVar.zzq().zzc(), zzchnVar.zzi(), "vpr2");
        zzchb zzchbVar = new zzchb(this.zza, zzchnVar, i7, z2, zzchnVar.zzq().zzc(), zzchmVar, this.zzd);
        this.zze = zzchbVar;
        this.zzc.addView(zzchbVar, 0, new ViewGroup.LayoutParams(-1, -1));
        this.zze.zzn(i3, i4, i5, i6);
        zzchnVar.zzdn(false);
    }

    public final zzchb zzd() {
        return this.zze;
    }

    public final void zze() {
        Preconditions.f("onPause must be called from the UI thread.");
        zzchb zzchbVar = this.zze;
        if (zzchbVar != null) {
            zzchbVar.zzr();
        }
    }

    public final void zzf() {
        Preconditions.f("onDestroy must be called from the UI thread.");
        zzchb zzchbVar = this.zze;
        if (zzchbVar != null) {
            zzchbVar.zzE();
            this.zzc.removeView(this.zze);
            this.zze = null;
        }
    }

    public final void zzg(int i3) {
        zzchb zzchbVar = this.zze;
        if (zzchbVar != null) {
            zzchbVar.zzm(i3);
        }
    }
}
