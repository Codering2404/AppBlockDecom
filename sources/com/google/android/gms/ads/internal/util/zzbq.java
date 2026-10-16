package com.google.android.gms.ads.internal.util;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.ads.zzgam;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbq {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private HandlerThread f70288a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Handler f70289b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f70290c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Object f70291d = new Object();

    public final Looper a() {
        Looper looper;
        Object obj = this.f70291d;
        synchronized (obj) {
            try {
                if (this.f70290c != 0) {
                    Preconditions.n(this.f70288a, "Invalid state: handlerThread should already been initialized.");
                } else if (this.f70288a == null) {
                    zze.k("Starting the looper thread.");
                    HandlerThread handlerThread = new HandlerThread("LooperProvider");
                    this.f70288a = handlerThread;
                    handlerThread.start();
                    this.f70289b = new zzgam(this.f70288a.getLooper());
                    zze.k("Looper thread started.");
                } else {
                    zze.k("Resuming the looper thread");
                    obj.notifyAll();
                }
                this.f70290c++;
                looper = this.f70288a.getLooper();
            } catch (Throwable th) {
                throw th;
            }
        }
        return looper;
    }

    public final Handler b() {
        return this.f70289b;
    }
}
