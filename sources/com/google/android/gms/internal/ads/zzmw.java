package com.google.android.gms.internal.ads;

import android.os.Looper;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzmw {
    private final zzmv zza;
    private final zzmu zzb;
    private final zzbf zzc;
    private int zzd;
    private Object zze;
    private final Looper zzf;
    private final int zzg;
    private boolean zzh;
    private boolean zzi;

    public zzmw(zzmu zzmuVar, zzmv zzmvVar, zzbf zzbfVar, int i3, zzdo zzdoVar, Looper looper) {
        this.zzb = zzmuVar;
        this.zza = zzmvVar;
        this.zzc = zzbfVar;
        this.zzf = looper;
        this.zzg = i3;
    }

    public final zzmv zza() {
        return this.zza;
    }

    public final zzmw zzb(int i3) {
        zzgtj.zzi(!this.zzh);
        this.zzd = i3;
        return this;
    }

    public final int zzc() {
        return this.zzd;
    }

    public final zzmw zzd(Object obj) {
        zzgtj.zzi(!this.zzh);
        this.zze = obj;
        return this;
    }

    public final Object zze() {
        return this.zze;
    }

    public final Looper zzf() {
        return this.zzf;
    }

    public final zzmw zzg() {
        zzgtj.zzi(!this.zzh);
        this.zzh = true;
        this.zzb.zzk(this);
        return this;
    }

    public final synchronized boolean zzh() {
        return false;
    }

    public final synchronized void zzi(boolean z2) {
        this.zzi = z2 | this.zzi;
        notifyAll();
    }
}
