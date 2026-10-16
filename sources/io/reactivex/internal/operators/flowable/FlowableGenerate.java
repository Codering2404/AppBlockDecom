package io.reactivex.internal.operators.flowable;

import io.reactivex.Emitter;
import io.reactivex.Flowable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class FlowableGenerate<T, S> extends Flowable<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Callable f135769b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final BiFunction f135770c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final Consumer f135771d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class GeneratorSubscription<T, S> extends AtomicLong implements Emitter<T>, Subscription {
        private static final long serialVersionUID = 7565982551505011832L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Subscriber f135772a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final BiFunction f135773b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final Consumer f135774c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f135775d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        volatile boolean f135776f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        boolean f135777g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        boolean f135778h;

        GeneratorSubscription(Subscriber subscriber, BiFunction biFunction, Consumer consumer, Object obj) {
            this.f135772a = subscriber;
            this.f135773b = biFunction;
            this.f135774c = consumer;
            this.f135775d = obj;
        }

        private void a(Object obj) {
            try {
                this.f135774c.accept(obj);
            } catch (Throwable th) {
                Exceptions.b(th);
                RxJavaPlugins.s(th);
            }
        }

        public void b(Throwable th) {
            if (this.f135777g) {
                RxJavaPlugins.s(th);
                return;
            }
            if (th == null) {
                th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            this.f135777g = true;
            this.f135772a.onError(th);
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (this.f135776f) {
                return;
            }
            this.f135776f = true;
            if (BackpressureHelper.a(this, 1L) == 0) {
                Object obj = this.f135775d;
                this.f135775d = null;
                a(obj);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:28:0x0055, code lost:
        
            r9.f135775d = r0;
            r10 = addAndGet(-r4);
         */
        @Override // org.reactivestreams.Subscription
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void y(long r10) {
            /*
                r9 = this;
                boolean r0 = io.reactivex.internal.subscriptions.SubscriptionHelper.h(r10)
                if (r0 != 0) goto L7
                goto L60
            L7:
                long r0 = io.reactivex.internal.util.BackpressureHelper.a(r9, r10)
                r2 = 0
                int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                if (r0 == 0) goto L12
                goto L60
            L12:
                java.lang.Object r0 = r9.f135775d
                io.reactivex.functions.BiFunction r1 = r9.f135773b
            L16:
                r4 = r2
            L17:
                int r6 = (r4 > r10 ? 1 : (r4 == r10 ? 0 : -1))
                if (r6 == 0) goto L4d
                boolean r6 = r9.f135776f
                r7 = 0
                if (r6 == 0) goto L26
                r9.f135775d = r7
                r9.a(r0)
                return
            L26:
                r6 = 0
                r9.f135778h = r6
                r6 = 1
                java.lang.Object r0 = r1.apply(r0, r9)     // Catch: java.lang.Throwable -> L3e
                boolean r8 = r9.f135777g
                if (r8 == 0) goto L3a
                r9.f135776f = r6
                r9.f135775d = r7
                r9.a(r0)
                return
            L3a:
                r6 = 1
                long r4 = r4 + r6
                goto L17
            L3e:
                r10 = move-exception
                io.reactivex.exceptions.Exceptions.b(r10)
                r9.f135776f = r6
                r9.f135775d = r7
                r9.b(r10)
                r9.a(r0)
                return
            L4d:
                long r10 = r9.get()
                int r6 = (r4 > r10 ? 1 : (r4 == r10 ? 0 : -1))
                if (r6 != 0) goto L17
                r9.f135775d = r0
                long r10 = -r4
                long r10 = r9.addAndGet(r10)
                int r4 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
                if (r4 != 0) goto L16
            L60:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableGenerate.GeneratorSubscription.y(long):void");
        }
    }

    @Override // io.reactivex.Flowable
    public void x(Subscriber subscriber) {
        try {
            subscriber.g(new GeneratorSubscription(subscriber, this.f135770c, this.f135771d, this.f135769b.call()));
        } catch (Throwable th) {
            Exceptions.b(th);
            EmptySubscription.b(th, subscriber);
        }
    }
}
