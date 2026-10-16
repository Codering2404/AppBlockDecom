package io.reactivex.android.schedulers;

import android.os.Handler;
import android.os.Message;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
final class HandlerScheduler extends Scheduler {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Handler f134873b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f134874c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class HandlerWorker extends Scheduler.Worker {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Handler f134875a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f134876b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private volatile boolean f134877c;

        HandlerWorker(Handler handler, boolean z2) {
            this.f134875a = handler;
            this.f134876b = z2;
        }

        @Override // io.reactivex.Scheduler.Worker
        public Disposable c(Runnable runnable, long j3, TimeUnit timeUnit) {
            if (runnable == null) {
                throw new NullPointerException("run == null");
            }
            if (timeUnit == null) {
                throw new NullPointerException("unit == null");
            }
            if (this.f134877c) {
                return Disposables.a();
            }
            ScheduledRunnable scheduledRunnable = new ScheduledRunnable(this.f134875a, RxJavaPlugins.u(runnable));
            Message messageObtain = Message.obtain(this.f134875a, scheduledRunnable);
            messageObtain.obj = this;
            if (this.f134876b) {
                messageObtain.setAsynchronous(true);
            }
            this.f134875a.sendMessageDelayed(messageObtain, timeUnit.toMillis(j3));
            if (!this.f134877c) {
                return scheduledRunnable;
            }
            this.f134875a.removeCallbacks(scheduledRunnable);
            return Disposables.a();
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f134877c = true;
            this.f134875a.removeCallbacksAndMessages(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return this.f134877c;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class ScheduledRunnable implements Runnable, Disposable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Handler f134878a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Runnable f134879b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private volatile boolean f134880c;

        ScheduledRunnable(Handler handler, Runnable runnable) {
            this.f134878a = handler;
            this.f134879b = runnable;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f134878a.removeCallbacks(this);
            this.f134880c = true;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return this.f134880c;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f134879b.run();
            } catch (Throwable th) {
                RxJavaPlugins.s(th);
            }
        }
    }

    HandlerScheduler(Handler handler, boolean z2) {
        this.f134873b = handler;
        this.f134874c = z2;
    }

    @Override // io.reactivex.Scheduler
    public Scheduler.Worker b() {
        return new HandlerWorker(this.f134873b, this.f134874c);
    }

    @Override // io.reactivex.Scheduler
    public Disposable f(Runnable runnable, long j3, TimeUnit timeUnit) {
        if (runnable == null) {
            throw new NullPointerException("run == null");
        }
        if (timeUnit == null) {
            throw new NullPointerException("unit == null");
        }
        ScheduledRunnable scheduledRunnable = new ScheduledRunnable(this.f134873b, RxJavaPlugins.u(runnable));
        Message messageObtain = Message.obtain(this.f134873b, scheduledRunnable);
        if (this.f134874c) {
            messageObtain.setAsynchronous(true);
        }
        this.f134873b.sendMessageDelayed(messageObtain, timeUnit.toMillis(j3));
        return scheduledRunnable;
    }
}
