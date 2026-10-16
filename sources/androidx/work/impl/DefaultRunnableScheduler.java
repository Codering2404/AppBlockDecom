package androidx.work.impl;

import android.os.Handler;
import android.os.Looper;
import androidx.core.os.HandlerCompat;
import androidx.work.RunnableScheduler;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class DefaultRunnableScheduler implements RunnableScheduler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Handler f54623a = HandlerCompat.a(Looper.getMainLooper());

    @Override // androidx.work.RunnableScheduler
    public void a(Runnable runnable) {
        this.f54623a.removeCallbacks(runnable);
    }

    @Override // androidx.work.RunnableScheduler
    public void b(long j3, Runnable runnable) {
        this.f54623a.postDelayed(runnable, j3);
    }
}
