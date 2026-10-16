package com.google.firebase.crashlytics.internal.common;

import android.os.Looper;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class Utils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ExecutorService f88456a = ExecutorUtils.c("awaitEvenIfOnMainThread task continuation executor");

    public static /* synthetic */ Object a(CountDownLatch countDownLatch, Task task) {
        countDownLatch.countDown();
        return null;
    }

    public static Object b(Task task) throws InterruptedException, TimeoutException {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        task.continueWith(f88456a, new Continuation() { // from class: com.google.firebase.crashlytics.internal.common.x
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task2) {
                return Utils.a(countDownLatch, task2);
            }
        });
        if (Looper.getMainLooper() == Looper.myLooper()) {
            countDownLatch.await(3000L, TimeUnit.MILLISECONDS);
        } else {
            countDownLatch.await(4000L, TimeUnit.MILLISECONDS);
        }
        if (task.isSuccessful()) {
            return task.getResult();
        }
        if (task.isCanceled()) {
            throw new CancellationException("Task is already canceled");
        }
        if (task.isComplete()) {
            throw new IllegalStateException(task.getException());
        }
        throw new TimeoutException();
    }

    public static boolean c(CountDownLatch countDownLatch, long j3, TimeUnit timeUnit) {
        boolean z2 = false;
        try {
            long nanos = timeUnit.toNanos(j3);
            while (true) {
                try {
                    break;
                } catch (InterruptedException unused) {
                    z2 = true;
                    nanos = (System.nanoTime() + nanos) - System.nanoTime();
                }
            }
            return countDownLatch.await(nanos, TimeUnit.NANOSECONDS);
        } finally {
            if (z2) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
