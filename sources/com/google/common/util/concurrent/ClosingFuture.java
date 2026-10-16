package com.google.common.util.concurrent;

import com.facebook.internal.ServerProtocol;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.errorprone.annotations.DoNotMock;
import java.io.Closeable;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@DoNotMock
@ElementTypesAreNonnullByDefault
public final class ClosingFuture<V> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final LazyLogger f85715d = new LazyLogger(ClosingFuture.class);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AtomicReference f85716a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final CloseableList f85717b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final FluentFuture f85718c;

    /* JADX INFO: renamed from: com.google.common.util.concurrent.ClosingFuture$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass1 implements Callable<Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ClosingCallable f85719a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ CloseableList f85720b;

        @Override // java.util.concurrent.Callable
        public Object call() {
            return this.f85719a.a(this.f85720b.f85737a);
        }

        public String toString() {
            return this.f85719a.toString();
        }
    }

    /* JADX INFO: renamed from: com.google.common.util.concurrent.ClosingFuture$10, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass10 implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ValueAndCloserConsumer f85721a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ClosingFuture f85722b;

        @Override // java.lang.Runnable
        public void run() {
            ClosingFuture.p(this.f85721a, this.f85722b);
        }
    }

    /* JADX INFO: renamed from: com.google.common.util.concurrent.ClosingFuture$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass2 implements AsyncCallable<Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AsyncClosingCallable f85723a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ CloseableList f85724b;

        @Override // com.google.common.util.concurrent.AsyncCallable
        public ListenableFuture call() {
            CloseableList closeableList = new CloseableList(null);
            try {
                ClosingFuture closingFutureA = this.f85723a.a(closeableList.f85737a);
                closingFutureA.i(this.f85724b);
                return closingFutureA.f85718c;
            } finally {
                this.f85724b.b(closeableList, MoreExecutors.a());
            }
        }

        public String toString() {
            return this.f85723a.toString();
        }
    }

    /* JADX INFO: renamed from: com.google.common.util.concurrent.ClosingFuture$4, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass4 implements AsyncFunction<Object, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ClosingFunction f85727a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ClosingFuture f85728b;

        @Override // com.google.common.util.concurrent.AsyncFunction
        public ListenableFuture apply(Object obj) {
            return this.f85728b.f85717b.i(this.f85727a, obj);
        }

        public String toString() {
            return this.f85727a.toString();
        }
    }

    /* JADX INFO: renamed from: com.google.common.util.concurrent.ClosingFuture$5, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass5 implements AsyncFunction<Object, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AsyncClosingFunction f85729a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ClosingFuture f85730b;

        @Override // com.google.common.util.concurrent.AsyncFunction
        public ListenableFuture apply(Object obj) {
            return this.f85730b.f85717b.c(this.f85729a, obj);
        }

        public String toString() {
            return this.f85729a.toString();
        }
    }

    /* JADX INFO: renamed from: com.google.common.util.concurrent.ClosingFuture$6, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass6 implements AsyncClosingFunction<Object, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AsyncFunction f85731a;

        @Override // com.google.common.util.concurrent.ClosingFuture.AsyncClosingFunction
        public ClosingFuture a(DeferredCloser deferredCloser, Object obj) {
            return ClosingFuture.o(this.f85731a.apply(obj));
        }
    }

    /* JADX INFO: renamed from: com.google.common.util.concurrent.ClosingFuture$7, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass7 implements AsyncFunction<Throwable, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ClosingFunction f85732a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ClosingFuture f85733b;

        @Override // com.google.common.util.concurrent.AsyncFunction
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ListenableFuture apply(Throwable th) {
            return this.f85733b.f85717b.i(this.f85732a, th);
        }

        public String toString() {
            return this.f85732a.toString();
        }
    }

    /* JADX INFO: renamed from: com.google.common.util.concurrent.ClosingFuture$8, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass8 implements AsyncFunction<Throwable, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AsyncClosingFunction f85734a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ClosingFuture f85735b;

        @Override // com.google.common.util.concurrent.AsyncFunction
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ListenableFuture apply(Throwable th) {
            return this.f85735b.f85717b.c(this.f85734a, th);
        }

        public String toString() {
            return this.f85734a.toString();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface AsyncClosingCallable<V> {
        ClosingFuture a(DeferredCloser deferredCloser);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface AsyncClosingFunction<T, U> {
        ClosingFuture a(DeferredCloser deferredCloser, Object obj);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface ClosingCallable<V> {
        Object a(DeferredCloser deferredCloser);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface ClosingFunction<T, U> {
        Object a(DeferredCloser deferredCloser, Object obj);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @DoNotMock
    public static class Combiner {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final CloseableList f85740a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        protected final ImmutableList f85741b;

        /* JADX INFO: renamed from: com.google.common.util.concurrent.ClosingFuture$Combiner$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        class AnonymousClass1 implements Callable<Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ CombiningCallable f85742a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ Combiner f85743b;

            @Override // java.util.concurrent.Callable
            public Object call() {
                return new Peeker(this.f85743b.f85741b, null).c(this.f85742a, this.f85743b.f85740a);
            }

            public String toString() {
                return this.f85742a.toString();
            }
        }

        /* JADX INFO: renamed from: com.google.common.util.concurrent.ClosingFuture$Combiner$2, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        class AnonymousClass2 implements AsyncCallable<Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ AsyncCombiningCallable f85744a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ Combiner f85745b;

            @Override // com.google.common.util.concurrent.AsyncCallable
            public ListenableFuture call() {
                return new Peeker(this.f85745b.f85741b, null).d(this.f85744a, this.f85745b.f85740a);
            }

            public String toString() {
                return this.f85744a.toString();
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        public interface AsyncCombiningCallable<V> {
            ClosingFuture a(DeferredCloser deferredCloser, Peeker peeker);
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        public interface CombiningCallable<V> {
            Object a(DeferredCloser deferredCloser, Peeker peeker);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Combiner2<V1, V2> extends Combiner {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final ClosingFuture f85746c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final ClosingFuture f85747d;

        /* JADX INFO: renamed from: com.google.common.util.concurrent.ClosingFuture$Combiner2$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        class AnonymousClass1 implements Combiner.CombiningCallable<Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ ClosingFunction2 f85748a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ Combiner2 f85749b;

            @Override // com.google.common.util.concurrent.ClosingFuture.Combiner.CombiningCallable
            public Object a(DeferredCloser deferredCloser, Peeker peeker) {
                return this.f85748a.a(deferredCloser, peeker.e(this.f85749b.f85746c), peeker.e(this.f85749b.f85747d));
            }

            public String toString() {
                return this.f85748a.toString();
            }
        }

        /* JADX INFO: renamed from: com.google.common.util.concurrent.ClosingFuture$Combiner2$2, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        class AnonymousClass2 implements Combiner.AsyncCombiningCallable<Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ AsyncClosingFunction2 f85750a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ Combiner2 f85751b;

            @Override // com.google.common.util.concurrent.ClosingFuture.Combiner.AsyncCombiningCallable
            public ClosingFuture a(DeferredCloser deferredCloser, Peeker peeker) {
                return this.f85750a.a(deferredCloser, peeker.e(this.f85751b.f85746c), peeker.e(this.f85751b.f85747d));
            }

            public String toString() {
                return this.f85750a.toString();
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        public interface AsyncClosingFunction2<V1, V2, U> {
            ClosingFuture a(DeferredCloser deferredCloser, Object obj, Object obj2);
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        public interface ClosingFunction2<V1, V2, U> {
            Object a(DeferredCloser deferredCloser, Object obj, Object obj2);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Combiner3<V1, V2, V3> extends Combiner {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final ClosingFuture f85752c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final ClosingFuture f85753d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final ClosingFuture f85754e;

        /* JADX INFO: renamed from: com.google.common.util.concurrent.ClosingFuture$Combiner3$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        class AnonymousClass1 implements Combiner.CombiningCallable<Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ ClosingFunction3 f85755a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ Combiner3 f85756b;

            @Override // com.google.common.util.concurrent.ClosingFuture.Combiner.CombiningCallable
            public Object a(DeferredCloser deferredCloser, Peeker peeker) {
                return this.f85755a.a(deferredCloser, peeker.e(this.f85756b.f85752c), peeker.e(this.f85756b.f85753d), peeker.e(this.f85756b.f85754e));
            }

            public String toString() {
                return this.f85755a.toString();
            }
        }

        /* JADX INFO: renamed from: com.google.common.util.concurrent.ClosingFuture$Combiner3$2, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        class AnonymousClass2 implements Combiner.AsyncCombiningCallable<Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ AsyncClosingFunction3 f85757a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ Combiner3 f85758b;

            @Override // com.google.common.util.concurrent.ClosingFuture.Combiner.AsyncCombiningCallable
            public ClosingFuture a(DeferredCloser deferredCloser, Peeker peeker) {
                return this.f85757a.a(deferredCloser, peeker.e(this.f85758b.f85752c), peeker.e(this.f85758b.f85753d), peeker.e(this.f85758b.f85754e));
            }

            public String toString() {
                return this.f85757a.toString();
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        public interface AsyncClosingFunction3<V1, V2, V3, U> {
            ClosingFuture a(DeferredCloser deferredCloser, Object obj, Object obj2, Object obj3);
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        public interface ClosingFunction3<V1, V2, V3, U> {
            Object a(DeferredCloser deferredCloser, Object obj, Object obj2, Object obj3);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Combiner4<V1, V2, V3, V4> extends Combiner {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final ClosingFuture f85759c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final ClosingFuture f85760d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final ClosingFuture f85761e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final ClosingFuture f85762f;

        /* JADX INFO: renamed from: com.google.common.util.concurrent.ClosingFuture$Combiner4$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        class AnonymousClass1 implements Combiner.CombiningCallable<Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ ClosingFunction4 f85763a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ Combiner4 f85764b;

            @Override // com.google.common.util.concurrent.ClosingFuture.Combiner.CombiningCallable
            public Object a(DeferredCloser deferredCloser, Peeker peeker) {
                return this.f85763a.a(deferredCloser, peeker.e(this.f85764b.f85759c), peeker.e(this.f85764b.f85760d), peeker.e(this.f85764b.f85761e), peeker.e(this.f85764b.f85762f));
            }

            public String toString() {
                return this.f85763a.toString();
            }
        }

        /* JADX INFO: renamed from: com.google.common.util.concurrent.ClosingFuture$Combiner4$2, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        class AnonymousClass2 implements Combiner.AsyncCombiningCallable<Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ AsyncClosingFunction4 f85765a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ Combiner4 f85766b;

            @Override // com.google.common.util.concurrent.ClosingFuture.Combiner.AsyncCombiningCallable
            public ClosingFuture a(DeferredCloser deferredCloser, Peeker peeker) {
                return this.f85765a.a(deferredCloser, peeker.e(this.f85766b.f85759c), peeker.e(this.f85766b.f85760d), peeker.e(this.f85766b.f85761e), peeker.e(this.f85766b.f85762f));
            }

            public String toString() {
                return this.f85765a.toString();
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        public interface AsyncClosingFunction4<V1, V2, V3, V4, U> {
            ClosingFuture a(DeferredCloser deferredCloser, Object obj, Object obj2, Object obj3, Object obj4);
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        public interface ClosingFunction4<V1, V2, V3, V4, U> {
            Object a(DeferredCloser deferredCloser, Object obj, Object obj2, Object obj3, Object obj4);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Combiner5<V1, V2, V3, V4, V5> extends Combiner {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final ClosingFuture f85767c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final ClosingFuture f85768d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final ClosingFuture f85769e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final ClosingFuture f85770f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final ClosingFuture f85771g;

        /* JADX INFO: renamed from: com.google.common.util.concurrent.ClosingFuture$Combiner5$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        class AnonymousClass1 implements Combiner.CombiningCallable<Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ ClosingFunction5 f85772a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ Combiner5 f85773b;

            @Override // com.google.common.util.concurrent.ClosingFuture.Combiner.CombiningCallable
            public Object a(DeferredCloser deferredCloser, Peeker peeker) {
                return this.f85772a.a(deferredCloser, peeker.e(this.f85773b.f85767c), peeker.e(this.f85773b.f85768d), peeker.e(this.f85773b.f85769e), peeker.e(this.f85773b.f85770f), peeker.e(this.f85773b.f85771g));
            }

            public String toString() {
                return this.f85772a.toString();
            }
        }

        /* JADX INFO: renamed from: com.google.common.util.concurrent.ClosingFuture$Combiner5$2, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        class AnonymousClass2 implements Combiner.AsyncCombiningCallable<Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ AsyncClosingFunction5 f85774a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ Combiner5 f85775b;

            @Override // com.google.common.util.concurrent.ClosingFuture.Combiner.AsyncCombiningCallable
            public ClosingFuture a(DeferredCloser deferredCloser, Peeker peeker) {
                return this.f85774a.a(deferredCloser, peeker.e(this.f85775b.f85767c), peeker.e(this.f85775b.f85768d), peeker.e(this.f85775b.f85769e), peeker.e(this.f85775b.f85770f), peeker.e(this.f85775b.f85771g));
            }

            public String toString() {
                return this.f85774a.toString();
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        public interface AsyncClosingFunction5<V1, V2, V3, V4, V5, U> {
            ClosingFuture a(DeferredCloser deferredCloser, Object obj, Object obj2, Object obj3, Object obj4, Object obj5);
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        public interface ClosingFunction5<V1, V2, V3, V4, V5, U> {
            Object a(DeferredCloser deferredCloser, Object obj, Object obj2, Object obj3, Object obj4, Object obj5);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class DeferredCloser {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final CloseableList f85776a;

        DeferredCloser(CloseableList closeableList) {
            this.f85776a = closeableList;
        }

        public Object a(Object obj, Executor executor) {
            Preconditions.t(executor);
            if (obj != null) {
                this.f85776a.b((AutoCloseable) obj, executor);
            }
            return obj;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Peeker {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ImmutableList f85777a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private volatile boolean f85778b;

        /* synthetic */ Peeker(ImmutableList immutableList, AnonymousClass1 anonymousClass1) {
            this(immutableList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Object c(Combiner.CombiningCallable combiningCallable, CloseableList closeableList) {
            this.f85778b = true;
            CloseableList closeableList2 = new CloseableList(null);
            try {
                return combiningCallable.a(closeableList2.f85737a, this);
            } finally {
                closeableList.b(closeableList2, MoreExecutors.a());
                this.f85778b = false;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public FluentFuture d(Combiner.AsyncCombiningCallable asyncCombiningCallable, CloseableList closeableList) {
            this.f85778b = true;
            CloseableList closeableList2 = new CloseableList(null);
            try {
                ClosingFuture closingFutureA = asyncCombiningCallable.a(closeableList2.f85737a, this);
                closingFutureA.i(closeableList);
                return closingFutureA.f85718c;
            } finally {
                closeableList.b(closeableList2, MoreExecutors.a());
                this.f85778b = false;
            }
        }

        public final Object e(ClosingFuture closingFuture) {
            Preconditions.z(this.f85778b);
            Preconditions.d(this.f85777a.contains(closingFuture));
            return Futures.c(closingFuture.f85718c);
        }

        private Peeker(ImmutableList immutableList) {
            this.f85777a = (ImmutableList) Preconditions.t(immutableList);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    enum State {
        OPEN,
        SUBSUMED,
        WILL_CLOSE,
        CLOSING,
        CLOSED,
        WILL_CREATE_VALUE_AND_CLOSER
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class ValueAndCloser<V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ClosingFuture f85786a;

        ValueAndCloser(ClosingFuture closingFuture) {
            this.f85786a = (ClosingFuture) Preconditions.t(closingFuture);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface ValueAndCloserConsumer<V> {
        void a(ValueAndCloser valueAndCloser);
    }

    private ClosingFuture(ListenableFuture listenableFuture) {
        this(listenableFuture, new CloseableList(null));
    }

    public static /* synthetic */ void a(AutoCloseable autoCloseable) {
        try {
            f.a.a(autoCloseable);
        } catch (Exception e3) {
            Platform.b(e3);
            f85715d.a().log(Level.WARNING, "thrown by close()", (Throwable) e3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(CloseableList closeableList) {
        j(State.OPEN, State.SUBSUMED);
        closeableList.b(this.f85717b, MoreExecutors.a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(State state, State state2) {
        Preconditions.E(m(state, state2), "Expected state to be %s, but it was %s", state, state2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        f85715d.a().log(Level.FINER, "closing {0}", this);
        this.f85717b.close();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void l(final AutoCloseable autoCloseable, Executor executor) {
        if (autoCloseable == null) {
            return;
        }
        try {
            executor.execute(new Runnable() { // from class: com.google.common.util.concurrent.c
                @Override // java.lang.Runnable
                public final void run() {
                    ClosingFuture.a(autoCloseable);
                }
            });
        } catch (RejectedExecutionException e3) {
            LazyLogger lazyLogger = f85715d;
            Logger loggerA = lazyLogger.a();
            Level level = Level.WARNING;
            if (loggerA.isLoggable(level)) {
                lazyLogger.a().log(level, String.format("while submitting close to %s; will close inline", executor), (Throwable) e3);
            }
            l(autoCloseable, MoreExecutors.a());
        }
    }

    private boolean m(State state, State state2) {
        return androidx.compose.animation.core.h.a(this.f85716a, state, state2);
    }

    public static ClosingFuture o(ListenableFuture listenableFuture) {
        return new ClosingFuture(listenableFuture);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void p(ValueAndCloserConsumer valueAndCloserConsumer, ClosingFuture closingFuture) {
        valueAndCloserConsumer.a(new ValueAndCloser(closingFuture));
    }

    protected void finalize() {
        if (((State) this.f85716a.get()).equals(State.OPEN)) {
            f85715d.a().log(Level.SEVERE, "Uh oh! An open ClosingFuture has leaked and will close: {0}", this);
            n();
        }
    }

    public FluentFuture n() {
        if (m(State.OPEN, State.WILL_CLOSE)) {
            f85715d.a().log(Level.FINER, "will close {0}", this);
            this.f85718c.addListener(new Runnable() { // from class: com.google.common.util.concurrent.ClosingFuture.9
                @Override // java.lang.Runnable
                public void run() {
                    ClosingFuture closingFuture = ClosingFuture.this;
                    State state = State.WILL_CLOSE;
                    State state2 = State.CLOSING;
                    closingFuture.j(state, state2);
                    ClosingFuture.this.k();
                    ClosingFuture.this.j(state2, State.CLOSED);
                }
            }, MoreExecutors.a());
        } else {
            int iOrdinal = ((State) this.f85716a.get()).ordinal();
            if (iOrdinal == 0) {
                throw new AssertionError();
            }
            if (iOrdinal == 1) {
                throw new IllegalStateException("Cannot call finishToFuture() after deriving another step");
            }
            if (iOrdinal == 2 || iOrdinal == 3 || iOrdinal == 4) {
                throw new IllegalStateException("Cannot call finishToFuture() twice");
            }
            if (iOrdinal == 5) {
                throw new IllegalStateException("Cannot call finishToFuture() after calling finishToValueAndCloser()");
            }
        }
        return this.f85718c;
    }

    public String toString() {
        return MoreObjects.c(this).d(ServerProtocol.DIALOG_PARAM_STATE, this.f85716a.get()).k(this.f85718c).toString();
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class CloseableList extends IdentityHashMap<AutoCloseable, Executor> implements Closeable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final DeferredCloser f85737a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private volatile boolean f85738b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private volatile CountDownLatch f85739c;

        private CloseableList() {
            this.f85737a = new DeferredCloser(this);
        }

        void b(AutoCloseable autoCloseable, Executor executor) {
            Preconditions.t(executor);
            if (autoCloseable == null) {
                return;
            }
            synchronized (this) {
                try {
                    if (this.f85738b) {
                        ClosingFuture.l(autoCloseable, executor);
                    } else {
                        put(autoCloseable, executor);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        FluentFuture c(AsyncClosingFunction asyncClosingFunction, Object obj) {
            CloseableList closeableList = new CloseableList();
            try {
                ClosingFuture closingFutureA = asyncClosingFunction.a(closeableList.f85737a, obj);
                closingFutureA.i(closeableList);
                return closingFutureA.f85718c;
            } finally {
                b(closeableList, MoreExecutors.a());
            }
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.f85738b) {
                return;
            }
            synchronized (this) {
                try {
                    if (this.f85738b) {
                        return;
                    }
                    this.f85738b = true;
                    for (Map.Entry<AutoCloseable, Executor> entry : entrySet()) {
                        ClosingFuture.l(entry.getKey(), entry.getValue());
                    }
                    clear();
                    if (this.f85739c != null) {
                        this.f85739c.countDown();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        ListenableFuture i(ClosingFunction closingFunction, Object obj) {
            CloseableList closeableList = new CloseableList();
            try {
                return Futures.f(closingFunction.a(closeableList.f85737a, obj));
            } finally {
                b(closeableList, MoreExecutors.a());
            }
        }

        /* synthetic */ CloseableList(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    private ClosingFuture(ListenableFuture listenableFuture, CloseableList closeableList) {
        this.f85716a = new AtomicReference(State.OPEN);
        this.f85718c = FluentFuture.F(listenableFuture);
        this.f85717b = closeableList;
    }

    /* JADX INFO: renamed from: com.google.common.util.concurrent.ClosingFuture$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass3 implements FutureCallback<AutoCloseable> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ClosingFuture f85725a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Executor f85726b;

        @Override // com.google.common.util.concurrent.FutureCallback
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(AutoCloseable autoCloseable) {
            this.f85725a.f85717b.f85737a.a(autoCloseable, this.f85726b);
        }

        @Override // com.google.common.util.concurrent.FutureCallback
        public void onFailure(Throwable th) {
        }
    }
}
