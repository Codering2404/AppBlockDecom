package com.google.android.gms.common.util.concurrent;

import android.os.Process;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class zza implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Runnable f72302a;

    public zza(Runnable runnable, int i3) {
        this.f72302a = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Process.setThreadPriority(0);
        this.f72302a.run();
    }
}
