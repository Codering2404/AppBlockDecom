package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.PowerManager;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzfq {
    private final Context zza;
    private PowerManager.WakeLock zzb;

    public zzfq(Context context) {
        this.zza = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzc, reason: merged with bridge method [inline-methods] */
    public final synchronized void zzb(boolean z2, boolean z3) {
        if (z2) {
            if (this.zzb == null) {
                Context context = this.zza;
                if (context.checkSelfPermission("android.permission.WAKE_LOCK") != 0) {
                    zzeg.zzc("WakeLockManager", "WAKE_LOCK permission not granted, can't acquire wake lock for playback");
                    return;
                }
                PowerManager powerManager = (PowerManager) context.getSystemService("power");
                if (powerManager == null) {
                    zzeg.zzc("WakeLockManager", "PowerManager is null, therefore not creating the WakeLock.");
                    return;
                } else {
                    PowerManager.WakeLock wakeLockNewWakeLock = powerManager.newWakeLock(1, "ExoPlayer:WakeLockManager");
                    this.zzb = wakeLockNewWakeLock;
                    wakeLockNewWakeLock.setReferenceCounted(false);
                }
            }
        }
        PowerManager.WakeLock wakeLock = this.zzb;
        if (wakeLock == null) {
            return;
        }
        if (zzfr.zzh(z2, z3)) {
            wakeLock.acquire();
        } else {
            wakeLock.release();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzd, reason: merged with bridge method [inline-methods] */
    public final synchronized void zza(AtomicBoolean atomicBoolean) {
        PowerManager.WakeLock wakeLock;
        if (!atomicBoolean.get() || (wakeLock = this.zzb) == null) {
            return;
        }
        wakeLock.release();
    }
}
