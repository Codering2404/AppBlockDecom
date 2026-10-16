package io.reactivex.processors;

import io.reactivex.internal.util.AppendOnlyLinkedArrayList;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
final class SerializedProcessor<T> extends FlowableProcessor<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final FlowableProcessor f139375b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    boolean f139376c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    AppendOnlyLinkedArrayList f139377d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    volatile boolean f139378f;

    SerializedProcessor(FlowableProcessor flowableProcessor) {
        this.f139375b = flowableProcessor;
    }

    void B() {
        AppendOnlyLinkedArrayList appendOnlyLinkedArrayList;
        while (true) {
            synchronized (this) {
                try {
                    appendOnlyLinkedArrayList = this.f139377d;
                    if (appendOnlyLinkedArrayList == null) {
                        this.f139376c = false;
                        return;
                    }
                    this.f139377d = null;
                } catch (Throwable th) {
                    throw th;
                }
            }
            appendOnlyLinkedArrayList.b(this.f139375b);
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void g(Subscription subscription) {
        boolean z2 = true;
        if (!this.f139378f) {
            synchronized (this) {
                try {
                    if (!this.f139378f) {
                        if (this.f139376c) {
                            AppendOnlyLinkedArrayList appendOnlyLinkedArrayList = this.f139377d;
                            if (appendOnlyLinkedArrayList == null) {
                                appendOnlyLinkedArrayList = new AppendOnlyLinkedArrayList(4);
                                this.f139377d = appendOnlyLinkedArrayList;
                            }
                            appendOnlyLinkedArrayList.c(NotificationLite.m(subscription));
                            return;
                        }
                        this.f139376c = true;
                        z2 = false;
                    }
                } finally {
                }
            }
        }
        if (z2) {
            subscription.cancel();
        } else {
            this.f139375b.g(subscription);
            B();
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void h(Object obj) {
        if (this.f139378f) {
            return;
        }
        synchronized (this) {
            try {
                if (this.f139378f) {
                    return;
                }
                if (!this.f139376c) {
                    this.f139376c = true;
                    this.f139375b.h(obj);
                    B();
                } else {
                    AppendOnlyLinkedArrayList appendOnlyLinkedArrayList = this.f139377d;
                    if (appendOnlyLinkedArrayList == null) {
                        appendOnlyLinkedArrayList = new AppendOnlyLinkedArrayList(4);
                        this.f139377d = appendOnlyLinkedArrayList;
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
        if (this.f139378f) {
            return;
        }
        synchronized (this) {
            try {
                if (this.f139378f) {
                    return;
                }
                this.f139378f = true;
                if (!this.f139376c) {
                    this.f139376c = true;
                    this.f139375b.onComplete();
                    return;
                }
                AppendOnlyLinkedArrayList appendOnlyLinkedArrayList = this.f139377d;
                if (appendOnlyLinkedArrayList == null) {
                    appendOnlyLinkedArrayList = new AppendOnlyLinkedArrayList(4);
                    this.f139377d = appendOnlyLinkedArrayList;
                }
                appendOnlyLinkedArrayList.c(NotificationLite.e());
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable th) {
        if (this.f139378f) {
            RxJavaPlugins.s(th);
            return;
        }
        synchronized (this) {
            try {
                boolean z2 = true;
                if (!this.f139378f) {
                    this.f139378f = true;
                    if (this.f139376c) {
                        AppendOnlyLinkedArrayList appendOnlyLinkedArrayList = this.f139377d;
                        if (appendOnlyLinkedArrayList == null) {
                            appendOnlyLinkedArrayList = new AppendOnlyLinkedArrayList(4);
                            this.f139377d = appendOnlyLinkedArrayList;
                        }
                        appendOnlyLinkedArrayList.e(NotificationLite.g(th));
                        return;
                    }
                    this.f139376c = true;
                    z2 = false;
                }
                if (z2) {
                    RxJavaPlugins.s(th);
                } else {
                    this.f139375b.onError(th);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // io.reactivex.Flowable
    protected void x(Subscriber subscriber) {
        this.f139375b.i(subscriber);
    }
}
