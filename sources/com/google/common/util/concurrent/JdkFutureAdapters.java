package com.google.common.util.concurrent;

import com.google.common.util.concurrent.JdkFutureAdapters;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public final class JdkFutureAdapters {

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class ListenableFutureAdapter<V> extends ForwardingFuture<V> implements ListenableFuture<V> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private static final ThreadFactory f85870f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private static final Executor f85871g;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Executor f85872a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ExecutionList f85873b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final AtomicBoolean f85874c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final Future f85875d;

        static {
            ThreadFactory threadFactoryB = new ThreadFactoryBuilder().e(true).f("ListenableFutureAdapter-thread-%d").b();
            f85870f = threadFactoryB;
            f85871g = Executors.newCachedThreadPool(threadFactoryB);
        }

        public static /* synthetic */ void S1(ListenableFutureAdapter listenableFutureAdapter) {
            listenableFutureAdapter.getClass();
            try {
                Uninterruptibles.a(listenableFutureAdapter.f85875d);
            } catch (Throwable unused) {
            }
            listenableFutureAdapter.f85873b.b();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.util.concurrent.ForwardingFuture, com.google.common.collect.ForwardingObject
        /* JADX INFO: renamed from: I1, reason: merged with bridge method [inline-methods] */
        public Future o2() {
            return this.f85875d;
        }

        @Override // com.google.common.util.concurrent.ListenableFuture
        public void addListener(Runnable runnable, Executor executor) {
            this.f85873b.a(runnable, executor);
            if (this.f85874c.compareAndSet(false, true)) {
                if (this.f85875d.isDone()) {
                    this.f85873b.b();
                } else {
                    this.f85872a.execute(new Runnable() { // from class: com.google.common.util.concurrent.g
                        @Override // java.lang.Runnable
                        public final void run() {
                            JdkFutureAdapters.ListenableFutureAdapter.S1(this.f85988a);
                        }
                    });
                }
            }
        }
    }
}
