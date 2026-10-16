package com.google.android.gms.internal.ads;

import android.os.Handler;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzru {
    private final Handler zza;
    private final zzrv zzb;

    public zzru(Handler handler, zzrv zzrvVar) {
        this.zza = zzrvVar == null ? null : handler;
        this.zzb = zzrvVar;
    }

    final /* synthetic */ void zzA(int i3) {
        String str = zzfl.zza;
        this.zzb.zzx(i3);
    }

    final /* synthetic */ void zzB(zziz zzizVar) {
        String str = zzfl.zza;
        this.zzb.zzy(zzizVar);
    }

    public final void zza(final zzjb zzjbVar) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzrt
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzo(zzjbVar);
                }
            });
        }
    }

    public final void zzb(final String str, final long j3, final long j4) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzrg
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzp(str, j3, j4);
                }
            });
        }
    }

    public final void zzc(final zzv zzvVar, final zzjc zzjcVar) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzrk
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzq(zzvVar, zzjcVar);
                }
            });
        }
    }

    public final void zzd(final long j3) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzrl
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzr(j3);
                }
            });
        }
    }

    public final void zze(final int i3, final long j3, final long j4) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzrm
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzs(i3, j3, j4);
                }
            });
        }
    }

    public final void zzf(final String str) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzrn
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzt(str);
                }
            });
        }
    }

    public final void zzg(final zzjb zzjbVar) {
        zzjbVar.zza();
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzro
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzu(zzjbVar);
                }
            });
        }
    }

    public final void zzh(final boolean z2) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzrp
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzv(z2);
                }
            });
        }
    }

    public final void zzi(final Exception exc) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzrq
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzw(exc);
                }
            });
        }
    }

    public final void zzj(final Exception exc) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzrr
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzx(exc);
                }
            });
        }
    }

    public final void zzk(final zzry zzryVar) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzrs
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzy(zzryVar);
                }
            });
        }
    }

    public final void zzl(final zzry zzryVar) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzrh
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzz(zzryVar);
                }
            });
        }
    }

    public final void zzm(final int i3) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzri
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzA(i3);
                }
            });
        }
    }

    public final void zzn(final zziz zzizVar) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzrj
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzB(zzizVar);
                }
            });
        }
    }

    final /* synthetic */ void zzo(zzjb zzjbVar) {
        String str = zzfl.zza;
        this.zzb.zzl(zzjbVar);
    }

    final /* synthetic */ void zzp(String str, long j3, long j4) {
        String str2 = zzfl.zza;
        this.zzb.zzm(str, j3, j4);
    }

    final /* synthetic */ void zzq(zzv zzvVar, zzjc zzjcVar) {
        String str = zzfl.zza;
        this.zzb.zzn(zzvVar, zzjcVar);
    }

    final /* synthetic */ void zzr(long j3) {
        String str = zzfl.zza;
        this.zzb.zzo(j3);
    }

    final /* synthetic */ void zzs(int i3, long j3, long j4) {
        String str = zzfl.zza;
        this.zzb.zzp(i3, j3, j4);
    }

    final /* synthetic */ void zzt(String str) {
        String str2 = zzfl.zza;
        this.zzb.zzq(str);
    }

    final /* synthetic */ void zzu(zzjb zzjbVar) {
        zzjbVar.zza();
        String str = zzfl.zza;
        this.zzb.zzr(zzjbVar);
    }

    final /* synthetic */ void zzv(boolean z2) {
        String str = zzfl.zza;
        this.zzb.zzs(z2);
    }

    final /* synthetic */ void zzw(Exception exc) {
        String str = zzfl.zza;
        this.zzb.zzt(exc);
    }

    final /* synthetic */ void zzx(Exception exc) {
        String str = zzfl.zza;
        this.zzb.zzu(exc);
    }

    final /* synthetic */ void zzy(zzry zzryVar) {
        String str = zzfl.zza;
        this.zzb.zzv(zzryVar);
    }

    final /* synthetic */ void zzz(zzry zzryVar) {
        String str = zzfl.zza;
        this.zzb.zzw(zzryVar);
    }
}
