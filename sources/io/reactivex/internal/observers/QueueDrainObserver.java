package io.reactivex.internal.observers;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.util.ObservableQueueDrain;
import io.reactivex.internal.util.QueueDrainHelper;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class QueueDrainObserver<T, U, V> extends QueueDrainSubscriberPad2 implements Observer<T>, ObservableQueueDrain<U, V> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final Observer f134997b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final SimplePlainQueue f134998c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected volatile boolean f134999d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected volatile boolean f135000f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected Throwable f135001g;

    public QueueDrainObserver(Observer observer, SimplePlainQueue simplePlainQueue) {
        this.f134997b = observer;
        this.f134998c = simplePlainQueue;
    }

    @Override // io.reactivex.internal.util.ObservableQueueDrain
    public final int b(int i3) {
        return this.f135002a.addAndGet(i3);
    }

    @Override // io.reactivex.internal.util.ObservableQueueDrain
    public final boolean c() {
        return this.f135000f;
    }

    @Override // io.reactivex.internal.util.ObservableQueueDrain
    public final boolean d() {
        return this.f134999d;
    }

    public final boolean g() {
        return this.f135002a.getAndIncrement() == 0;
    }

    public final boolean i() {
        return this.f135002a.get() == 0 && this.f135002a.compareAndSet(0, 1);
    }

    protected final void j(Object obj, boolean z2, Disposable disposable) {
        Observer observer = this.f134997b;
        SimplePlainQueue simplePlainQueue = this.f134998c;
        if (this.f135002a.get() == 0 && this.f135002a.compareAndSet(0, 1)) {
            f(observer, obj);
            if (b(-1) == 0) {
                return;
            }
        } else {
            simplePlainQueue.offer(obj);
            if (!g()) {
                return;
            }
        }
        QueueDrainHelper.d(simplePlainQueue, observer, z2, disposable, this);
    }

    protected final void k(Object obj, boolean z2, Disposable disposable) {
        Observer observer = this.f134997b;
        SimplePlainQueue simplePlainQueue = this.f134998c;
        if (this.f135002a.get() != 0 || !this.f135002a.compareAndSet(0, 1)) {
            simplePlainQueue.offer(obj);
            if (!g()) {
                return;
            }
        } else if (simplePlainQueue.isEmpty()) {
            f(observer, obj);
            if (b(-1) == 0) {
                return;
            }
        } else {
            simplePlainQueue.offer(obj);
        }
        QueueDrainHelper.d(simplePlainQueue, observer, z2, disposable, this);
    }

    @Override // io.reactivex.internal.util.ObservableQueueDrain
    public final Throwable p() {
        return this.f135001g;
    }

    @Override // io.reactivex.internal.util.ObservableQueueDrain
    public void f(Observer observer, Object obj) {
    }
}
