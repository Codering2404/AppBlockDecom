package io.reactivex.schedulers;

import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.Queue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class TestScheduler extends Scheduler {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Queue f139400b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    long f139401c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    volatile long f139402d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    final class TestWorker extends Scheduler.Worker {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        volatile boolean f139403a;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        final class QueueRemove implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final TimedRunnable f139405a;

            QueueRemove(TimedRunnable timedRunnable) {
                this.f139405a = timedRunnable;
            }

            @Override // java.lang.Runnable
            public void run() {
                TestScheduler.this.f139400b.remove(this.f139405a);
            }
        }

        TestWorker() {
        }

        @Override // io.reactivex.Scheduler.Worker
        public long a(TimeUnit timeUnit) {
            return TestScheduler.this.c(timeUnit);
        }

        @Override // io.reactivex.Scheduler.Worker
        public Disposable b(Runnable runnable) {
            if (this.f139403a) {
                return EmptyDisposable.INSTANCE;
            }
            TestScheduler testScheduler = TestScheduler.this;
            long j3 = testScheduler.f139401c;
            testScheduler.f139401c = 1 + j3;
            TimedRunnable timedRunnable = new TimedRunnable(this, 0L, runnable, j3);
            TestScheduler.this.f139400b.add(timedRunnable);
            return Disposables.c(new QueueRemove(timedRunnable));
        }

        @Override // io.reactivex.Scheduler.Worker
        public Disposable c(Runnable runnable, long j3, TimeUnit timeUnit) {
            if (this.f139403a) {
                return EmptyDisposable.INSTANCE;
            }
            long nanos = TestScheduler.this.f139402d + timeUnit.toNanos(j3);
            TestScheduler testScheduler = TestScheduler.this;
            long j4 = testScheduler.f139401c;
            testScheduler.f139401c = 1 + j4;
            TimedRunnable timedRunnable = new TimedRunnable(this, nanos, runnable, j4);
            TestScheduler.this.f139400b.add(timedRunnable);
            return Disposables.c(new QueueRemove(timedRunnable));
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f139403a = true;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return this.f139403a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class TimedRunnable implements Comparable<TimedRunnable> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final long f139407a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Runnable f139408b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final TestWorker f139409c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final long f139410d;

        TimedRunnable(TestWorker testWorker, long j3, Runnable runnable, long j4) {
            this.f139407a = j3;
            this.f139408b = runnable;
            this.f139409c = testWorker;
            this.f139410d = j4;
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(TimedRunnable timedRunnable) {
            long j3 = this.f139407a;
            long j4 = timedRunnable.f139407a;
            return j3 == j4 ? ObjectHelper.b(this.f139410d, timedRunnable.f139410d) : ObjectHelper.b(j3, j4);
        }

        public String toString() {
            return String.format("TimedRunnable(time = %d, run = %s)", Long.valueOf(this.f139407a), this.f139408b.toString());
        }
    }

    @Override // io.reactivex.Scheduler
    public Scheduler.Worker b() {
        return new TestWorker();
    }

    @Override // io.reactivex.Scheduler
    public long c(TimeUnit timeUnit) {
        return timeUnit.convert(this.f139402d, TimeUnit.NANOSECONDS);
    }
}
