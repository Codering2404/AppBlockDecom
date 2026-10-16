package com.google.common.util.concurrent;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.AbstractOwnableSynchronizer;
import java.util.concurrent.locks.LockSupport;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
abstract class InterruptibleTask<T> extends AtomicReference<Runnable> implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Runnable f85867a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Runnable f85868b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class Blocker extends AbstractOwnableSynchronizer implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final InterruptibleTask f85869a;

        /* JADX INFO: Access modifiers changed from: private */
        public void b(Thread thread) {
            super.setExclusiveOwnerThread(thread);
        }

        public String toString() {
            return this.f85869a.toString();
        }

        private Blocker(InterruptibleTask interruptibleTask) {
            this.f85869a = interruptibleTask;
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    static {
        f85867a = new DoNothingRunnable();
        f85868b = new DoNothingRunnable();
    }

    InterruptibleTask() {
    }

    private void g(Thread thread) {
        Runnable runnable = get();
        Blocker blocker = null;
        boolean z2 = false;
        int i3 = 0;
        while (true) {
            boolean z3 = runnable instanceof Blocker;
            if (!z3 && runnable != f85868b) {
                break;
            }
            if (z3) {
                blocker = (Blocker) runnable;
            }
            i3++;
            if (i3 > 1000) {
                Runnable runnable2 = f85868b;
                if (runnable == runnable2 || compareAndSet(runnable, runnable2)) {
                    z2 = Thread.interrupted() || z2;
                    LockSupport.park(blocker);
                }
            } else {
                Thread.yield();
            }
            runnable = get();
        }
        if (z2) {
            thread.interrupt();
        }
    }

    abstract void a(Throwable th);

    abstract void b(Object obj);

    final void c() {
        Runnable runnable = get();
        if (runnable instanceof Thread) {
            Blocker blocker = new Blocker();
            blocker.b(Thread.currentThread());
            if (compareAndSet(runnable, blocker)) {
                try {
                    ((Thread) runnable).interrupt();
                } finally {
                    if (getAndSet(f85867a) == f85868b) {
                        LockSupport.unpark((Thread) runnable);
                    }
                }
            }
        }
    }

    abstract boolean d();

    abstract Object e();

    abstract String f();

    @Override // java.lang.Runnable
    public final void run() {
        Thread threadCurrentThread = Thread.currentThread();
        Object objE = null;
        if (compareAndSet(null, threadCurrentThread)) {
            boolean zD = d();
            if (!zD) {
                try {
                    objE = e();
                } catch (Throwable th) {
                    try {
                        Platform.b(th);
                        if (!compareAndSet(threadCurrentThread, f85867a)) {
                            g(threadCurrentThread);
                        }
                        if (zD) {
                            return;
                        }
                        a(th);
                        return;
                    } finally {
                        if (!compareAndSet(threadCurrentThread, f85867a)) {
                            g(threadCurrentThread);
                        }
                        if (!zD) {
                            b(NullnessCasts.a(null));
                        }
                    }
                }
            }
        }
    }

    @Override // java.util.concurrent.atomic.AtomicReference
    public final String toString() {
        String str;
        Runnable runnable = get();
        if (runnable == f85867a) {
            str = "running=[DONE]";
        } else if (runnable instanceof Blocker) {
            str = "running=[INTERRUPTED]";
        } else if (runnable instanceof Thread) {
            str = "running=[RUNNING ON " + ((Thread) runnable).getName() + "]";
        } else {
            str = "running=[NOT STARTED YET]";
        }
        return str + ", " + f();
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class DoNothingRunnable implements Runnable {
        private DoNothingRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }
}
