package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public final class ExecutionSequencer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ThreadConfinedTaskQueue f85828a;

    /* JADX INFO: renamed from: com.google.common.util.concurrent.ExecutionSequencer$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass1 implements AsyncCallable<Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Callable f85829a;

        @Override // com.google.common.util.concurrent.AsyncCallable
        public ListenableFuture call() {
            return Futures.f(this.f85829a.call());
        }

        public String toString() {
            return this.f85829a.toString();
        }
    }

    /* JADX INFO: renamed from: com.google.common.util.concurrent.ExecutionSequencer$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass2 implements AsyncCallable<Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ TaskNonReentrantExecutor f85830a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ AsyncCallable f85831b;

        @Override // com.google.common.util.concurrent.AsyncCallable
        public ListenableFuture call() {
            return !this.f85830a.b() ? Futures.d() : this.f85831b.call();
        }

        public String toString() {
            return this.f85831b.toString();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    enum RunningState {
        NOT_RUN,
        CANCELLED,
        STARTED
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class TaskNonReentrantExecutor extends AtomicReference<RunningState> implements Executor, Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        ExecutionSequencer f85836a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Executor f85837b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Runnable f85838c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Thread f85839d;

        /* JADX INFO: Access modifiers changed from: private */
        public boolean b() {
            return compareAndSet(RunningState.NOT_RUN, RunningState.STARTED);
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            if (get() == RunningState.CANCELLED) {
                this.f85837b = null;
                this.f85836a = null;
                return;
            }
            this.f85839d = Thread.currentThread();
            try {
                ExecutionSequencer executionSequencer = this.f85836a;
                Objects.requireNonNull(executionSequencer);
                ThreadConfinedTaskQueue threadConfinedTaskQueue = executionSequencer.f85828a;
                if (threadConfinedTaskQueue.f85840a == this.f85839d) {
                    this.f85836a = null;
                    Preconditions.z(threadConfinedTaskQueue.f85841b == null);
                    threadConfinedTaskQueue.f85841b = runnable;
                    Executor executor = this.f85837b;
                    Objects.requireNonNull(executor);
                    threadConfinedTaskQueue.f85842c = executor;
                    this.f85837b = null;
                } else {
                    Executor executor2 = this.f85837b;
                    Objects.requireNonNull(executor2);
                    this.f85837b = null;
                    this.f85838c = runnable;
                    executor2.execute(this);
                }
                this.f85839d = null;
            } catch (Throwable th) {
                this.f85839d = null;
                throw th;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            Executor executor;
            Thread threadCurrentThread = Thread.currentThread();
            Thread thread = null;
            Object[] objArr = 0;
            if (threadCurrentThread != this.f85839d) {
                Runnable runnable = this.f85838c;
                Objects.requireNonNull(runnable);
                this.f85838c = null;
                runnable.run();
                return;
            }
            ThreadConfinedTaskQueue threadConfinedTaskQueue = new ThreadConfinedTaskQueue(objArr == true ? 1 : 0);
            threadConfinedTaskQueue.f85840a = threadCurrentThread;
            ExecutionSequencer executionSequencer = this.f85836a;
            Objects.requireNonNull(executionSequencer);
            executionSequencer.f85828a = threadConfinedTaskQueue;
            this.f85836a = null;
            try {
                Runnable runnable2 = this.f85838c;
                Objects.requireNonNull(runnable2);
                this.f85838c = null;
                runnable2.run();
                while (true) {
                    Runnable runnable3 = threadConfinedTaskQueue.f85841b;
                    if (runnable3 == null || (executor = threadConfinedTaskQueue.f85842c) == null) {
                        break;
                    }
                    threadConfinedTaskQueue.f85841b = null;
                    threadConfinedTaskQueue.f85842c = null;
                    executor.execute(runnable3);
                }
            } finally {
                threadConfinedTaskQueue.f85840a = null;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class ThreadConfinedTaskQueue {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Thread f85840a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Runnable f85841b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Executor f85842c;

        private ThreadConfinedTaskQueue() {
        }

        /* synthetic */ ThreadConfinedTaskQueue(AnonymousClass1 anonymousClass1) {
            this();
        }
    }
}
