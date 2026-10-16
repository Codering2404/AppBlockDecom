package com.google.android.play.integrity.internal;

import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public abstract class t implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final TaskCompletionSource f83188a;

    t() {
        this.f83188a = null;
    }

    public void a(Exception exc) {
        TaskCompletionSource taskCompletionSource = this.f83188a;
        if (taskCompletionSource != null) {
            taskCompletionSource.trySetException(exc);
        }
    }

    protected abstract void b();

    final TaskCompletionSource c() {
        return this.f83188a;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            b();
        } catch (Exception e3) {
            a(e3);
        }
    }

    public t(TaskCompletionSource taskCompletionSource) {
        this.f83188a = taskCompletionSource;
    }
}
