package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.SystemClock;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzaeo {
    private final Handler zza;
    private final zzaep zzb;

    public zzaeo(Handler handler, zzaep zzaepVar) {
        if (zzaepVar != null) {
            handler.getClass();
        } else {
            handler = null;
        }
        this.zza = handler;
        this.zzb = zzaepVar;
    }

    public final void zza(final zzjb zzjbVar) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzaen
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzl(zzjbVar);
                }
            });
        }
    }

    public final void zzb(final String str, final long j3, final long j4) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzaed
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzm(str, j3, j4);
                }
            });
        }
    }

    public final void zzc(final zzv zzvVar, final zzjc zzjcVar) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzaee
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzn(zzvVar, zzjcVar);
                }
            });
        }
    }

    public final void zzd(final int i3, final long j3) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzaef
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzo(i3, j3);
                }
            });
        }
    }

    public final void zze(final long j3, final int i3) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzaeg
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzp(j3, i3);
                }
            });
        }
    }

    public final void zzf(final zzbv zzbvVar) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzaeh
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzq(zzbvVar);
                }
            });
        }
    }

    public final void zzg(final Object obj) {
        Handler handler = this.zza;
        if (handler != null) {
            final long jElapsedRealtime = SystemClock.elapsedRealtime();
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzaei
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzr(obj, jElapsedRealtime);
                }
            });
        }
    }

    public final void zzh(final String str) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzaej
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzs(str);
                }
            });
        }
    }

    public final void zzi(final zzjb zzjbVar) {
        zzjbVar.zza();
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzaek
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzt(zzjbVar);
                }
            });
        }
    }

    public final void zzj(final Exception exc) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzael
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzu(exc);
                }
            });
        }
    }

    public final void zzk(final zziz zzizVar) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzaem
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzv(zzizVar);
                }
            });
        }
    }

    final /* synthetic */ void zzl(zzjb zzjbVar) {
        String str = zzfl.zza;
        this.zzb.zzb(zzjbVar);
    }

    final /* synthetic */ void zzm(String str, long j3, long j4) {
        String str2 = zzfl.zza;
        this.zzb.zzc(str, j3, j4);
    }

    final /* synthetic */ void zzn(zzv zzvVar, zzjc zzjcVar) {
        String str = zzfl.zza;
        this.zzb.zzd(zzvVar, zzjcVar);
    }

    final /* synthetic */ void zzo(int i3, long j3) {
        String str = zzfl.zza;
        this.zzb.zze(i3, j3);
    }

    final /* synthetic */ void zzp(long j3, int i3) {
        String str = zzfl.zza;
        this.zzb.zzj(j3, i3);
    }

    final /* synthetic */ void zzq(zzbv zzbvVar) {
        String str = zzfl.zza;
        this.zzb.zzf(zzbvVar);
    }

    final /* synthetic */ void zzr(Object obj, long j3) {
        String str = zzfl.zza;
        this.zzb.zzg(obj, j3);
    }

    final /* synthetic */ void zzs(String str) {
        String str2 = zzfl.zza;
        this.zzb.zzh(str);
    }

    final /* synthetic */ void zzt(zzjb zzjbVar) {
        zzjbVar.zza();
        String str = zzfl.zza;
        this.zzb.zzi(zzjbVar);
    }

    final /* synthetic */ void zzu(Exception exc) {
        String str = zzfl.zza;
        this.zzb.zzk(exc);
    }

    final /* synthetic */ void zzv(zziz zzizVar) {
        String str = zzfl.zza;
        this.zzb.zzz(zzizVar);
    }
}
