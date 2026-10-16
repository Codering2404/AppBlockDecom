package com.google.android.gms.analytics;

import android.util.Log;
import java.lang.Thread;
import java.util.concurrent.FutureTask;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class zzm extends FutureTask {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzn f70913a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzm(zzn zznVar, Runnable runnable, Object obj) {
        super(runnable, obj);
        this.f70913a = zznVar;
    }

    @Override // java.util.concurrent.FutureTask
    protected final void setException(Throwable th) {
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f70913a.f70914a.f70922f;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(Thread.currentThread(), th);
        } else if (Log.isLoggable("GAv4", 6)) {
            Log.e("GAv4", "MeasurementExecutor: job failed with ".concat(String.valueOf(th)));
        }
        super.setException(th);
    }
}
