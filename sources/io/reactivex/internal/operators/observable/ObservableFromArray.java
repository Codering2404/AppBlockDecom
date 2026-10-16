package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.observers.BasicQueueDisposable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class ObservableFromArray<T> extends Observable<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Object[] f137731a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class FromArrayDisposable<T> extends BasicQueueDisposable<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Observer f137732a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Object[] f137733b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f137734c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f137735d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        volatile boolean f137736f;

        FromArrayDisposable(Observer observer, Object[] objArr) {
            this.f137732a = observer;
            this.f137733b = objArr;
        }

        void b() {
            Object[] objArr = this.f137733b;
            int length = objArr.length;
            for (int i3 = 0; i3 < length && !e(); i3++) {
                Object obj = objArr[i3];
                if (obj == null) {
                    this.f137732a.onError(new NullPointerException("The " + i3 + "th element is null"));
                    return;
                }
                this.f137732a.h(obj);
            }
            if (e()) {
                return;
            }
            this.f137732a.onComplete();
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public void clear() {
            this.f137734c = this.f137733b.length;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f137736f = true;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return this.f137736f;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public boolean isEmpty() {
            return this.f137734c == this.f137733b.length;
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int l(int i3) {
            if ((i3 & 1) == 0) {
                return 0;
            }
            this.f137735d = true;
            return 1;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public Object poll() {
            int i3 = this.f137734c;
            Object[] objArr = this.f137733b;
            if (i3 == objArr.length) {
                return null;
            }
            this.f137734c = i3 + 1;
            return ObjectHelper.d(objArr[i3], "The array element is null");
        }
    }

    @Override // io.reactivex.Observable
    public void u(Observer observer) {
        FromArrayDisposable fromArrayDisposable = new FromArrayDisposable(observer, this.f137731a);
        observer.a(fromArrayDisposable);
        if (fromArrayDisposable.f137735d) {
            return;
        }
        fromArrayDisposable.b();
    }
}
