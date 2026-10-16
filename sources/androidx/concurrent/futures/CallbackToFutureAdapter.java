package androidx.concurrent.futures;

import com.google.common.util.concurrent.ListenableFuture;
import java.lang.ref.WeakReference;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class CallbackToFutureAdapter {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Completer<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f30323a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        SafeFuture f30324b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private ResolvableFuture f30325c = ResolvableFuture.s();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f30326d;

        Completer() {
        }

        private void e() {
            this.f30323a = null;
            this.f30324b = null;
            this.f30325c = null;
        }

        public void a(Runnable runnable, Executor executor) {
            ResolvableFuture resolvableFuture = this.f30325c;
            if (resolvableFuture != null) {
                resolvableFuture.addListener(runnable, executor);
            }
        }

        void b() {
            this.f30323a = null;
            this.f30324b = null;
            this.f30325c.o(null);
        }

        public boolean c(Object obj) {
            this.f30326d = true;
            SafeFuture safeFuture = this.f30324b;
            boolean z2 = safeFuture != null && safeFuture.b(obj);
            if (z2) {
                e();
            }
            return z2;
        }

        public boolean d() {
            this.f30326d = true;
            SafeFuture safeFuture = this.f30324b;
            boolean z2 = safeFuture != null && safeFuture.a(true);
            if (z2) {
                e();
            }
            return z2;
        }

        public boolean f(Throwable th) {
            this.f30326d = true;
            SafeFuture safeFuture = this.f30324b;
            boolean z2 = safeFuture != null && safeFuture.c(th);
            if (z2) {
                e();
            }
            return z2;
        }

        protected void finalize() {
            ResolvableFuture resolvableFuture;
            SafeFuture safeFuture = this.f30324b;
            if (safeFuture != null && !safeFuture.isDone()) {
                safeFuture.c(new FutureGarbageCollectedException("The completer object was garbage collected - this future would otherwise never complete. The tag was: " + this.f30323a));
            }
            if (this.f30326d || (resolvableFuture = this.f30325c) == null) {
                return;
            }
            resolvableFuture.o(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class FutureGarbageCollectedException extends Throwable {
        FutureGarbageCollectedException(String str) {
            super(str);
        }

        @Override // java.lang.Throwable
        public synchronized Throwable fillInStackTrace() {
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface Resolver<T> {
        Object attachCompleter(Completer completer);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class SafeFuture<T> implements ListenableFuture<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final WeakReference f30327a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final AbstractResolvableFuture f30328b = new AbstractResolvableFuture<T>() { // from class: androidx.concurrent.futures.CallbackToFutureAdapter.SafeFuture.1
            @Override // androidx.concurrent.futures.AbstractResolvableFuture
            protected String l() {
                Completer completer = (Completer) SafeFuture.this.f30327a.get();
                if (completer == null) {
                    return "Completer object has been garbage collected, future will fail soon";
                }
                return "tag=[" + completer.f30323a + "]";
            }
        };

        SafeFuture(Completer completer) {
            this.f30327a = new WeakReference(completer);
        }

        boolean a(boolean z2) {
            return this.f30328b.cancel(z2);
        }

        @Override // com.google.common.util.concurrent.ListenableFuture
        public void addListener(Runnable runnable, Executor executor) {
            this.f30328b.addListener(runnable, executor);
        }

        boolean b(Object obj) {
            return this.f30328b.o(obj);
        }

        boolean c(Throwable th) {
            return this.f30328b.p(th);
        }

        @Override // java.util.concurrent.Future
        public boolean cancel(boolean z2) {
            Completer completer = (Completer) this.f30327a.get();
            boolean zCancel = this.f30328b.cancel(z2);
            if (zCancel && completer != null) {
                completer.b();
            }
            return zCancel;
        }

        @Override // java.util.concurrent.Future
        public Object get() {
            return this.f30328b.get();
        }

        @Override // java.util.concurrent.Future
        public boolean isCancelled() {
            return this.f30328b.isCancelled();
        }

        @Override // java.util.concurrent.Future
        public boolean isDone() {
            return this.f30328b.isDone();
        }

        public String toString() {
            return this.f30328b.toString();
        }

        @Override // java.util.concurrent.Future
        public Object get(long j3, TimeUnit timeUnit) {
            return this.f30328b.get(j3, timeUnit);
        }
    }

    public static ListenableFuture a(Resolver resolver) {
        Completer completer = new Completer();
        SafeFuture safeFuture = new SafeFuture(completer);
        completer.f30324b = safeFuture;
        completer.f30323a = resolver.getClass();
        try {
            Object objAttachCompleter = resolver.attachCompleter(completer);
            if (objAttachCompleter == null) {
                return safeFuture;
            }
            completer.f30323a = objAttachCompleter;
            return safeFuture;
        } catch (Exception e3) {
            safeFuture.c(e3);
            return safeFuture;
        }
    }
}
