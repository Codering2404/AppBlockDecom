package com.google.android.play.core.review.internal;

import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public abstract class zzj implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final TaskCompletionSource f83111a;

    zzj() {
        this.f83111a = null;
    }

    protected abstract void a();

    final TaskCompletionSource b() {
        return this.f83111a;
    }

    public final void c(Exception exc) {
        TaskCompletionSource taskCompletionSource = this.f83111a;
        if (taskCompletionSource != null) {
            taskCompletionSource.trySetException(exc);
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            a();
        } catch (Exception e3) {
            c(e3);
        }
    }

    public zzj(TaskCompletionSource taskCompletionSource) {
        this.f83111a = taskCompletionSource;
    }
}
