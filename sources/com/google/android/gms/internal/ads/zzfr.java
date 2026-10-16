package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Looper;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzfr {
    private final zzfq zza;
    private final zzdz zzb;
    private final zzdz zzc;
    private boolean zzd;
    private boolean zze;

    public zzfr(Context context, Looper looper, zzdo zzdoVar) {
        this.zza = new zzfq(context.getApplicationContext());
        this.zzb = zzdoVar.zzd(looper, null);
        this.zzc = zzdoVar.zzd(Looper.getMainLooper(), null);
    }

    private final void zzg(final boolean z2, final boolean z3) {
        if (zzh(z2, z3)) {
            this.zzb.zzm(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfn
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zze(z2, z3);
                }
            });
            return;
        }
        final AtomicBoolean atomicBoolean = new AtomicBoolean(true);
        this.zzc.zzn(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfo
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zzc(atomicBoolean);
            }
        }, 1000L);
        this.zzb.zzm(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfm
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zzd(atomicBoolean, z2, z3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean zzh(boolean z2, boolean z3) {
        return z2 && z3;
    }

    public final void zza(boolean z2) {
        if (this.zzd == z2) {
            return;
        }
        this.zzd = z2;
        zzg(z2, this.zze);
    }

    public final void zzb(boolean z2) {
        if (this.zze == z2) {
            return;
        }
        this.zze = z2;
        if (this.zzd) {
            zzg(true, z2);
        }
    }

    final /* synthetic */ void zzc(final AtomicBoolean atomicBoolean) {
        if (atomicBoolean.get()) {
            final zzfq zzfqVar = this.zza;
            new Thread(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfp
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    zzfqVar.zza(atomicBoolean);
                }
            }, "ExoPlayer:WakeLockManager").start();
        }
    }

    final /* synthetic */ void zzd(AtomicBoolean atomicBoolean, boolean z2, boolean z3) {
        atomicBoolean.set(false);
        this.zza.zzb(z2, z3);
    }

    final /* synthetic */ void zze(boolean z2, boolean z3) {
        this.zza.zzb(z2, z3);
    }
}
