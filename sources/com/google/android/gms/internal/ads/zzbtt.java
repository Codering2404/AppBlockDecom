package com.google.android.gms.internal.ads;

import com.facebook.share.HKJ.pnxuebdT;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbtt extends zzcgd {
    private final com.google.android.gms.ads.internal.util.zzbc zzb;
    private final Object zza = new Object();
    private boolean zzc = false;
    private int zzd = 0;

    public zzbtt(com.google.android.gms.ads.internal.util.zzbc zzbcVar) {
        this.zzb = zzbcVar;
    }

    public final zzbto zza() {
        zzbto zzbtoVar = new zzbto(this);
        com.google.android.gms.ads.internal.util.zze.k("createNewReference: Trying to acquire lock");
        synchronized (this.zza) {
            com.google.android.gms.ads.internal.util.zze.k("createNewReference: Lock acquired");
            zze(new zzbtp(this, zzbtoVar), new zzbtq(this, zzbtoVar));
            Preconditions.q(this.zzd >= 0);
            this.zzd++;
        }
        com.google.android.gms.ads.internal.util.zze.k("createNewReference: Lock released");
        return zzbtoVar;
    }

    protected final void zzb() {
        com.google.android.gms.ads.internal.util.zze.k("releaseOneReference: Trying to acquire lock");
        synchronized (this.zza) {
            com.google.android.gms.ads.internal.util.zze.k("releaseOneReference: Lock acquired");
            Preconditions.q(this.zzd > 0);
            com.google.android.gms.ads.internal.util.zze.k("Releasing 1 reference for JS Engine");
            this.zzd--;
            zzd();
        }
        com.google.android.gms.ads.internal.util.zze.k("releaseOneReference: Lock released");
    }

    protected final void zzd() {
        com.google.android.gms.ads.internal.util.zze.k("maybeDestroy: Trying to acquire lock");
        synchronized (this.zza) {
            try {
                com.google.android.gms.ads.internal.util.zze.k("maybeDestroy: Lock acquired");
                Preconditions.q(this.zzd >= 0);
                if (this.zzc && this.zzd == 0) {
                    com.google.android.gms.ads.internal.util.zze.k("No reference is left (including root). Cleaning up engine.");
                    zze(new zzbts(this), new zzcfz());
                } else {
                    com.google.android.gms.ads.internal.util.zze.k("There are still references to the engine. Not destroying.");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        com.google.android.gms.ads.internal.util.zze.k("maybeDestroy: Lock released");
    }

    public final void zzc() {
        com.google.android.gms.ads.internal.util.zze.k("markAsDestroyable: Trying to acquire lock");
        synchronized (this.zza) {
            com.google.android.gms.ads.internal.util.zze.k("markAsDestroyable: Lock acquired");
            Preconditions.q(this.zzd >= 0);
            com.google.android.gms.ads.internal.util.zze.k(pnxuebdT.ITgPNejfHLIu);
            this.zzc = true;
            zzd();
        }
        com.google.android.gms.ads.internal.util.zze.k("markAsDestroyable: Lock released");
    }
}
