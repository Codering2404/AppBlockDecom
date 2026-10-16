package com.applovin.impl;

import android.content.Context;
import android.os.PowerManager;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class gr {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final PowerManager f60048a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private PowerManager.WakeLock f60049b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f60050c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f60051d;

    public gr(Context context) {
        this.f60048a = (PowerManager) context.getApplicationContext().getSystemService("power");
    }

    public void a(boolean z2) {
        if (z2 && this.f60049b == null) {
            PowerManager powerManager = this.f60048a;
            if (powerManager == null) {
                oc.d("WakeLockManager", "PowerManager is null, therefore not creating the WakeLock.");
                return;
            } else {
                PowerManager.WakeLock wakeLockNewWakeLock = powerManager.newWakeLock(1, "ExoPlayer:WakeLockManager");
                this.f60049b = wakeLockNewWakeLock;
                wakeLockNewWakeLock.setReferenceCounted(false);
            }
        }
        this.f60050c = z2;
        a();
    }

    public void b(boolean z2) {
        this.f60051d = z2;
        a();
    }

    private void a() {
        PowerManager.WakeLock wakeLock = this.f60049b;
        if (wakeLock == null) {
            return;
        }
        if (this.f60050c && this.f60051d) {
            wakeLock.acquire();
        } else {
            wakeLock.release();
        }
    }
}
