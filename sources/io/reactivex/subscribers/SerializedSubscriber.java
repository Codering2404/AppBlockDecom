package io.reactivex.subscribers;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AppendOnlyLinkedArrayList;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class SerializedSubscriber<T> implements FlowableSubscriber<T>, Subscription {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Subscriber f139515a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final boolean f139516b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Subscription f139517c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    boolean f139518d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    AppendOnlyLinkedArrayList f139519f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    volatile boolean f139520g;

    public SerializedSubscriber(Subscriber subscriber) {
        this(subscriber, false);
    }

    void a() {
        AppendOnlyLinkedArrayList appendOnlyLinkedArrayList;
        do {
            synchronized (this) {
                try {
                    appendOnlyLinkedArrayList = this.f139519f;
                    if (appendOnlyLinkedArrayList == null) {
                        this.f139518d = false;
                        return;
                    }
                    this.f139519f = null;
                } catch (Throwable th) {
                    throw th;
                }
            }
        } while (!appendOnlyLinkedArrayList.b(this.f139515a));
    }

    @Override // org.reactivestreams.Subscription
    public void cancel() {
        this.f139517c.cancel();
    }

    @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
    public void g(Subscription subscription) {
        if (SubscriptionHelper.i(this.f139517c, subscription)) {
            this.f139517c = subscription;
            this.f139515a.g(this);
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void h(Object obj) {
        if (this.f139520g) {
            return;
        }
        if (obj == null) {
            this.f139517c.cancel();
            onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            return;
        }
        synchronized (this) {
            try {
                if (this.f139520g) {
                    return;
                }
                if (!this.f139518d) {
                    this.f139518d = true;
                    this.f139515a.h(obj);
                    a();
                } else {
                    AppendOnlyLinkedArrayList appendOnlyLinkedArrayList = this.f139519f;
                    if (appendOnlyLinkedArrayList == null) {
                        appendOnlyLinkedArrayList = new AppendOnlyLinkedArrayList(4);
                        this.f139519f = appendOnlyLinkedArrayList;
                    }
                    appendOnlyLinkedArrayList.c(NotificationLite.l(obj));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        if (this.f139520g) {
            return;
        }
        synchronized (this) {
            try {
                if (this.f139520g) {
                    return;
                }
                if (!this.f139518d) {
                    this.f139520g = true;
                    this.f139518d = true;
                    this.f139515a.onComplete();
                } else {
                    AppendOnlyLinkedArrayList appendOnlyLinkedArrayList = this.f139519f;
                    if (appendOnlyLinkedArrayList == null) {
                        appendOnlyLinkedArrayList = new AppendOnlyLinkedArrayList(4);
                        this.f139519f = appendOnlyLinkedArrayList;
                    }
                    appendOnlyLinkedArrayList.c(NotificationLite.e());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable th) {
        if (this.f139520g) {
            RxJavaPlugins.s(th);
            return;
        }
        synchronized (this) {
            try {
                boolean z2 = true;
                if (!this.f139520g) {
                    if (this.f139518d) {
                        this.f139520g = true;
                        AppendOnlyLinkedArrayList appendOnlyLinkedArrayList = this.f139519f;
                        if (appendOnlyLinkedArrayList == null) {
                            appendOnlyLinkedArrayList = new AppendOnlyLinkedArrayList(4);
                            this.f139519f = appendOnlyLinkedArrayList;
                        }
                        Object objG = NotificationLite.g(th);
                        if (this.f139516b) {
                            appendOnlyLinkedArrayList.c(objG);
                        } else {
                            appendOnlyLinkedArrayList.e(objG);
                        }
                        return;
                    }
                    this.f139520g = true;
                    this.f139518d = true;
                    z2 = false;
                }
                if (z2) {
                    RxJavaPlugins.s(th);
                } else {
                    this.f139515a.onError(th);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // org.reactivestreams.Subscription
    public void y(long j3) {
        this.f139517c.y(j3);
    }

    public SerializedSubscriber(Subscriber subscriber, boolean z2) {
        this.f139515a = subscriber;
        this.f139516b = z2;
    }
}
