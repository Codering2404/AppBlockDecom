package io.reactivex.internal.subscriptions;

import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.util.BackpressureHelper;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public class SubscriptionArbiter extends AtomicInteger implements Subscription {
    private static final long serialVersionUID = -2189523197179400958L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Subscription f139180a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    long f139181b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final AtomicReference f139182c = new AtomicReference();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final AtomicLong f139183d = new AtomicLong();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final AtomicLong f139184f = new AtomicLong();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final boolean f139185g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    volatile boolean f139186h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    protected boolean f139187i;

    public SubscriptionArbiter(boolean z2) {
        this.f139185g = z2;
    }

    final void a() {
        if (getAndIncrement() != 0) {
            return;
        }
        d();
    }

    public void cancel() {
        if (this.f139186h) {
            return;
        }
        this.f139186h = true;
        a();
    }

    final void d() {
        int iAddAndGet = 1;
        long jC = 0;
        Subscription subscription = null;
        do {
            Subscription subscription2 = (Subscription) this.f139182c.get();
            if (subscription2 != null) {
                subscription2 = (Subscription) this.f139182c.getAndSet(null);
            }
            long andSet = this.f139183d.get();
            if (andSet != 0) {
                andSet = this.f139183d.getAndSet(0L);
            }
            long andSet2 = this.f139184f.get();
            if (andSet2 != 0) {
                andSet2 = this.f139184f.getAndSet(0L);
            }
            Subscription subscription3 = this.f139180a;
            if (this.f139186h) {
                if (subscription3 != null) {
                    subscription3.cancel();
                    this.f139180a = null;
                }
                if (subscription2 != null) {
                    subscription2.cancel();
                }
            } else {
                long jC2 = this.f139181b;
                if (jC2 != Long.MAX_VALUE) {
                    jC2 = BackpressureHelper.c(jC2, andSet);
                    if (jC2 != Long.MAX_VALUE) {
                        jC2 -= andSet2;
                        if (jC2 < 0) {
                            SubscriptionHelper.d(jC2);
                            jC2 = 0;
                        }
                    }
                    this.f139181b = jC2;
                }
                if (subscription2 != null) {
                    if (subscription3 != null && this.f139185g) {
                        subscription3.cancel();
                    }
                    this.f139180a = subscription2;
                    if (jC2 != 0) {
                        jC = BackpressureHelper.c(jC, jC2);
                        subscription = subscription2;
                    }
                } else if (subscription3 != null && andSet != 0) {
                    jC = BackpressureHelper.c(jC, andSet);
                    subscription = subscription3;
                }
            }
            iAddAndGet = addAndGet(-iAddAndGet);
        } while (iAddAndGet != 0);
        if (jC != 0) {
            subscription.y(jC);
        }
    }

    public final boolean e() {
        return this.f139186h;
    }

    public final boolean f() {
        return this.f139187i;
    }

    public final void i(long j3) {
        if (this.f139187i) {
            return;
        }
        if (get() != 0 || !compareAndSet(0, 1)) {
            BackpressureHelper.a(this.f139184f, j3);
            a();
            return;
        }
        long j4 = this.f139181b;
        if (j4 != Long.MAX_VALUE) {
            long j5 = j4 - j3;
            if (j5 < 0) {
                SubscriptionHelper.d(j5);
                j5 = 0;
            }
            this.f139181b = j5;
        }
        if (decrementAndGet() == 0) {
            return;
        }
        d();
    }

    public final void j(Subscription subscription) {
        if (this.f139186h) {
            subscription.cancel();
            return;
        }
        ObjectHelper.d(subscription, "s is null");
        if (get() != 0 || !compareAndSet(0, 1)) {
            Subscription subscription2 = (Subscription) this.f139182c.getAndSet(subscription);
            if (subscription2 != null && this.f139185g) {
                subscription2.cancel();
            }
            a();
            return;
        }
        Subscription subscription3 = this.f139180a;
        if (subscription3 != null && this.f139185g) {
            subscription3.cancel();
        }
        this.f139180a = subscription;
        long j3 = this.f139181b;
        if (decrementAndGet() != 0) {
            d();
        }
        if (j3 != 0) {
            subscription.y(j3);
        }
    }

    @Override // org.reactivestreams.Subscription
    public final void y(long j3) {
        if (!SubscriptionHelper.h(j3) || this.f139187i) {
            return;
        }
        if (get() != 0 || !compareAndSet(0, 1)) {
            BackpressureHelper.a(this.f139183d, j3);
            a();
            return;
        }
        long j4 = this.f139181b;
        if (j4 != Long.MAX_VALUE) {
            long jC = BackpressureHelper.c(j4, j3);
            this.f139181b = jC;
            if (jC == Long.MAX_VALUE) {
                this.f139187i = true;
            }
        }
        Subscription subscription = this.f139180a;
        if (decrementAndGet() != 0) {
            d();
        }
        if (subscription != null) {
            subscription.y(j3);
        }
    }
}
