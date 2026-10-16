package com.singular.sdk.internal;

import android.os.Handler;
import android.os.HandlerThread;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public class SingularWorkerThread extends HandlerThread {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Handler f92740a;

    public SingularWorkerThread(String str) {
        super(str);
    }

    private synchronized void a() {
        if (this.f92740a == null) {
            this.f92740a = new Handler(getLooper());
        }
    }

    Handler b() {
        a();
        return this.f92740a;
    }

    public void c(Runnable runnable) {
        b().post(runnable);
    }

    public void d(Runnable runnable) {
        b().postAtFrontOfQueue(runnable);
    }

    public void e(Runnable runnable, int i3) {
        b().postDelayed(runnable, i3);
    }
}
