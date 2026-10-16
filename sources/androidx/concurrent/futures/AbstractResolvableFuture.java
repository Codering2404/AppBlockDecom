package androidx.concurrent.futures;

import com.google.android.material.bottomsheet.lKiE.YznnJpHcAmeoW;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractResolvableFuture<V> implements ListenableFuture<V> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final boolean f30296d = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Logger f30297f = Logger.getLogger(AbstractResolvableFuture.class.getName());

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    static final AtomicHelper f30298g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final Object f30299h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    volatile Object f30300a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    volatile Listener f30301b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    volatile Waiter f30302c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes3.dex */
    private static abstract class AtomicHelper {
        private AtomicHelper() {
        }

        abstract boolean a(AbstractResolvableFuture abstractResolvableFuture, Listener listener, Listener listener2);

        abstract boolean b(AbstractResolvableFuture abstractResolvableFuture, Object obj, Object obj2);

        abstract boolean c(AbstractResolvableFuture abstractResolvableFuture, Waiter waiter, Waiter waiter2);

        abstract void d(Waiter waiter, Waiter waiter2);

        abstract void e(Waiter waiter, Thread thread);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes3.dex */
    private static final class Cancellation {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        static final Cancellation f30303c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        static final Cancellation f30304d;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final boolean f30305a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Throwable f30306b;

        static {
            if (AbstractResolvableFuture.f30296d) {
                f30304d = null;
                f30303c = null;
            } else {
                f30304d = new Cancellation(false, null);
                f30303c = new Cancellation(true, null);
            }
        }

        Cancellation(boolean z2, Throwable th) {
            this.f30305a = z2;
            this.f30306b = th;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes3.dex */
    private static final class Failure {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final Failure f30307b = new Failure(new Throwable("Failure occurred while trying to finish a future.") { // from class: androidx.concurrent.futures.AbstractResolvableFuture.Failure.1
            @Override // java.lang.Throwable
            public synchronized Throwable fillInStackTrace() {
                return this;
            }
        });

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Throwable f30308a;

        Failure(Throwable th) {
            this.f30308a = (Throwable) AbstractResolvableFuture.d(th);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes3.dex */
    private static final class Listener {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        static final Listener f30309d = new Listener(null, null);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Runnable f30310a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Executor f30311b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Listener f30312c;

        Listener(Runnable runnable, Executor executor) {
            this.f30310a = runnable;
            this.f30311b = executor;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes3.dex */
    private static final class SafeAtomicHelper extends AtomicHelper {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final AtomicReferenceFieldUpdater f30313a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final AtomicReferenceFieldUpdater f30314b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final AtomicReferenceFieldUpdater f30315c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final AtomicReferenceFieldUpdater f30316d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final AtomicReferenceFieldUpdater f30317e;

        SafeAtomicHelper(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater5) {
            super();
            this.f30313a = atomicReferenceFieldUpdater;
            this.f30314b = atomicReferenceFieldUpdater2;
            this.f30315c = atomicReferenceFieldUpdater3;
            this.f30316d = atomicReferenceFieldUpdater4;
            this.f30317e = atomicReferenceFieldUpdater5;
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.AtomicHelper
        boolean a(AbstractResolvableFuture abstractResolvableFuture, Listener listener, Listener listener2) {
            return a.a(this.f30316d, abstractResolvableFuture, listener, listener2);
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.AtomicHelper
        boolean b(AbstractResolvableFuture abstractResolvableFuture, Object obj, Object obj2) {
            return a.a(this.f30317e, abstractResolvableFuture, obj, obj2);
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.AtomicHelper
        boolean c(AbstractResolvableFuture abstractResolvableFuture, Waiter waiter, Waiter waiter2) {
            return a.a(this.f30315c, abstractResolvableFuture, waiter, waiter2);
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.AtomicHelper
        void d(Waiter waiter, Waiter waiter2) {
            this.f30314b.lazySet(waiter, waiter2);
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.AtomicHelper
        void e(Waiter waiter, Thread thread) {
            this.f30313a.lazySet(waiter, thread);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes3.dex */
    private static final class SetFuture<V> implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final AbstractResolvableFuture f30318a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final ListenableFuture f30319b;

        @Override // java.lang.Runnable
        public void run() {
            if (this.f30318a.f30300a != this) {
                return;
            }
            if (AbstractResolvableFuture.f30298g.b(this.f30318a, this, AbstractResolvableFuture.i(this.f30319b))) {
                AbstractResolvableFuture.f(this.f30318a);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes3.dex */
    private static final class SynchronizedHelper extends AtomicHelper {
        SynchronizedHelper() {
            super();
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.AtomicHelper
        boolean a(AbstractResolvableFuture abstractResolvableFuture, Listener listener, Listener listener2) {
            synchronized (abstractResolvableFuture) {
                try {
                    if (abstractResolvableFuture.f30301b != listener) {
                        return false;
                    }
                    abstractResolvableFuture.f30301b = listener2;
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.AtomicHelper
        boolean b(AbstractResolvableFuture abstractResolvableFuture, Object obj, Object obj2) {
            synchronized (abstractResolvableFuture) {
                try {
                    if (abstractResolvableFuture.f30300a != obj) {
                        return false;
                    }
                    abstractResolvableFuture.f30300a = obj2;
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.AtomicHelper
        boolean c(AbstractResolvableFuture abstractResolvableFuture, Waiter waiter, Waiter waiter2) {
            synchronized (abstractResolvableFuture) {
                try {
                    if (abstractResolvableFuture.f30302c != waiter) {
                        return false;
                    }
                    abstractResolvableFuture.f30302c = waiter2;
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.AtomicHelper
        void d(Waiter waiter, Waiter waiter2) {
            waiter.f30322b = waiter2;
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.AtomicHelper
        void e(Waiter waiter, Thread thread) {
            waiter.f30321a = thread;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes3.dex */
    private static final class Waiter {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        static final Waiter f30320c = new Waiter(false);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        volatile Thread f30321a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        volatile Waiter f30322b;

        Waiter(boolean z2) {
        }

        void a(Waiter waiter) {
            AbstractResolvableFuture.f30298g.d(this, waiter);
        }

        void b() {
            Thread thread = this.f30321a;
            if (thread != null) {
                this.f30321a = null;
                LockSupport.unpark(thread);
            }
        }

        Waiter() {
            AbstractResolvableFuture.f30298g.e(this, Thread.currentThread());
        }
    }

    static {
        AtomicHelper synchronizedHelper;
        try {
            synchronizedHelper = new SafeAtomicHelper(AtomicReferenceFieldUpdater.newUpdater(Waiter.class, Thread.class, "a"), AtomicReferenceFieldUpdater.newUpdater(Waiter.class, Waiter.class, "b"), AtomicReferenceFieldUpdater.newUpdater(AbstractResolvableFuture.class, Waiter.class, "c"), AtomicReferenceFieldUpdater.newUpdater(AbstractResolvableFuture.class, Listener.class, "b"), AtomicReferenceFieldUpdater.newUpdater(AbstractResolvableFuture.class, Object.class, "a"));
            th = null;
        } catch (Throwable th) {
            th = th;
            synchronizedHelper = new SynchronizedHelper();
        }
        f30298g = synchronizedHelper;
        if (th != null) {
            f30297f.log(Level.SEVERE, "SafeAtomicHelper is broken!", th);
        }
        f30299h = new Object();
    }

    protected AbstractResolvableFuture() {
    }

    private void a(StringBuilder sb) {
        try {
            Object objJ = j(this);
            sb.append("SUCCESS, result=[");
            sb.append(q(objJ));
            sb.append("]");
        } catch (CancellationException unused) {
            sb.append("CANCELLED");
        } catch (RuntimeException e3) {
            sb.append("UNKNOWN, cause=[");
            sb.append(e3.getClass());
            sb.append(" thrown from get()]");
        } catch (ExecutionException e4) {
            sb.append("FAILURE, cause=[");
            sb.append(e4.getCause());
            sb.append("]");
        }
    }

    private static CancellationException c(String str, Throwable th) {
        CancellationException cancellationException = new CancellationException(str);
        cancellationException.initCause(th);
        return cancellationException;
    }

    static Object d(Object obj) {
        obj.getClass();
        return obj;
    }

    private Listener e(Listener listener) {
        Listener listener2;
        do {
            listener2 = this.f30301b;
        } while (!f30298g.a(this, listener2, Listener.f30309d));
        Listener listener3 = listener;
        Listener listener4 = listener2;
        while (listener4 != null) {
            Listener listener5 = listener4.f30312c;
            listener4.f30312c = listener3;
            listener3 = listener4;
            listener4 = listener5;
        }
        return listener3;
    }

    static void f(AbstractResolvableFuture abstractResolvableFuture) {
        Listener listener = null;
        while (true) {
            abstractResolvableFuture.m();
            abstractResolvableFuture.b();
            Listener listenerE = abstractResolvableFuture.e(listener);
            while (listenerE != null) {
                listener = listenerE.f30312c;
                Runnable runnable = listenerE.f30310a;
                if (runnable instanceof SetFuture) {
                    SetFuture setFuture = (SetFuture) runnable;
                    abstractResolvableFuture = setFuture.f30318a;
                    if (abstractResolvableFuture.f30300a == setFuture) {
                        if (f30298g.b(abstractResolvableFuture, setFuture, i(setFuture.f30319b))) {
                            break;
                        }
                    } else {
                        continue;
                    }
                } else {
                    g(runnable, listenerE.f30311b);
                }
                listenerE = listener;
            }
            return;
        }
    }

    private static void g(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (RuntimeException e3) {
            f30297f.log(Level.SEVERE, "RuntimeException while executing runnable " + runnable + " with executor " + executor, (Throwable) e3);
        }
    }

    private Object h(Object obj) throws ExecutionException {
        if (obj instanceof Cancellation) {
            throw c("Task was cancelled.", ((Cancellation) obj).f30306b);
        }
        if (obj instanceof Failure) {
            throw new ExecutionException(((Failure) obj).f30308a);
        }
        if (obj == f30299h) {
            return null;
        }
        return obj;
    }

    static Object i(ListenableFuture listenableFuture) {
        if (listenableFuture instanceof AbstractResolvableFuture) {
            Object obj = ((AbstractResolvableFuture) listenableFuture).f30300a;
            if (!(obj instanceof Cancellation)) {
                return obj;
            }
            Cancellation cancellation = (Cancellation) obj;
            return cancellation.f30305a ? cancellation.f30306b != null ? new Cancellation(false, cancellation.f30306b) : Cancellation.f30304d : obj;
        }
        boolean zIsCancelled = listenableFuture.isCancelled();
        if ((!f30296d) && zIsCancelled) {
            return Cancellation.f30304d;
        }
        try {
            Object objJ = j(listenableFuture);
            return objJ == null ? f30299h : objJ;
        } catch (CancellationException e3) {
            if (zIsCancelled) {
                return new Cancellation(false, e3);
            }
            return new Failure(new IllegalArgumentException("get() threw CancellationException, despite reporting isCancelled() == false: " + listenableFuture, e3));
        } catch (ExecutionException e4) {
            return new Failure(e4.getCause());
        } catch (Throwable th) {
            return new Failure(th);
        }
    }

    static Object j(Future future) {
        Object obj;
        boolean z2 = false;
        while (true) {
            try {
                obj = future.get();
                break;
            } catch (InterruptedException unused) {
                z2 = true;
            } catch (Throwable th) {
                if (z2) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z2) {
            Thread.currentThread().interrupt();
        }
        return obj;
    }

    private void m() {
        Waiter waiter;
        do {
            waiter = this.f30302c;
        } while (!f30298g.c(this, waiter, Waiter.f30320c));
        while (waiter != null) {
            waiter.b();
            waiter = waiter.f30322b;
        }
    }

    private void n(Waiter waiter) {
        waiter.f30321a = null;
        while (true) {
            Waiter waiter2 = this.f30302c;
            if (waiter2 == Waiter.f30320c) {
                return;
            }
            Waiter waiter3 = null;
            while (waiter2 != null) {
                Waiter waiter4 = waiter2.f30322b;
                if (waiter2.f30321a != null) {
                    waiter3 = waiter2;
                } else if (waiter3 != null) {
                    waiter3.f30322b = waiter4;
                    if (waiter3.f30321a == null) {
                        break;
                    }
                } else if (!f30298g.c(this, waiter2, waiter4)) {
                    break;
                }
                waiter2 = waiter4;
            }
            return;
        }
    }

    private String q(Object obj) {
        return obj == this ? "this future" : String.valueOf(obj);
    }

    @Override // com.google.common.util.concurrent.ListenableFuture
    public final void addListener(Runnable runnable, Executor executor) {
        d(runnable);
        d(executor);
        Listener listener = this.f30301b;
        if (listener != Listener.f30309d) {
            Listener listener2 = new Listener(runnable, executor);
            do {
                listener2.f30312c = listener;
                if (f30298g.a(this, listener, listener2)) {
                    return;
                } else {
                    listener = this.f30301b;
                }
            } while (listener != Listener.f30309d);
        }
        g(runnable, executor);
    }

    protected void b() {
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z2) {
        Object obj = this.f30300a;
        if (!(obj == null) && !(obj instanceof SetFuture)) {
            return false;
        }
        Cancellation cancellation = f30296d ? new Cancellation(z2, new CancellationException("Future.cancel() was called.")) : z2 ? Cancellation.f30303c : Cancellation.f30304d;
        AbstractResolvableFuture<V> abstractResolvableFuture = this;
        boolean z3 = false;
        while (true) {
            if (f30298g.b(abstractResolvableFuture, obj, cancellation)) {
                if (z2) {
                    abstractResolvableFuture.k();
                }
                f(abstractResolvableFuture);
                if (!(obj instanceof SetFuture)) {
                    break;
                }
                ListenableFuture listenableFuture = ((SetFuture) obj).f30319b;
                if (!(listenableFuture instanceof AbstractResolvableFuture)) {
                    listenableFuture.cancel(z2);
                    break;
                }
                abstractResolvableFuture = (AbstractResolvableFuture) listenableFuture;
                obj = abstractResolvableFuture.f30300a;
                if (!(obj == null) && !(obj instanceof SetFuture)) {
                    break;
                }
                z3 = true;
            } else {
                obj = abstractResolvableFuture.f30300a;
                if (!(obj instanceof SetFuture)) {
                    return z3;
                }
            }
        }
        return true;
    }

    @Override // java.util.concurrent.Future
    public final Object get(long j3, TimeUnit timeUnit) throws InterruptedException, TimeoutException {
        long nanos = timeUnit.toNanos(j3);
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object obj = this.f30300a;
        if ((obj != null) && (!(obj instanceof SetFuture))) {
            return h(obj);
        }
        long jNanoTime = nanos > 0 ? System.nanoTime() + nanos : 0L;
        if (nanos >= 1000) {
            Waiter waiter = this.f30302c;
            if (waiter != Waiter.f30320c) {
                Waiter waiter2 = new Waiter();
                do {
                    waiter2.a(waiter);
                    if (f30298g.c(this, waiter, waiter2)) {
                        do {
                            LockSupport.parkNanos(this, nanos);
                            if (Thread.interrupted()) {
                                n(waiter2);
                                throw new InterruptedException();
                            }
                            Object obj2 = this.f30300a;
                            if ((obj2 != null) && (!(obj2 instanceof SetFuture))) {
                                return h(obj2);
                            }
                            nanos = jNanoTime - System.nanoTime();
                        } while (nanos >= 1000);
                        n(waiter2);
                    } else {
                        waiter = this.f30302c;
                    }
                } while (waiter != Waiter.f30320c);
            }
            return h(this.f30300a);
        }
        while (nanos > 0) {
            Object obj3 = this.f30300a;
            if ((obj3 != null) && (!(obj3 instanceof SetFuture))) {
                return h(obj3);
            }
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            nanos = jNanoTime - System.nanoTime();
        }
        String string = toString();
        String string2 = timeUnit.toString();
        Locale locale = Locale.ROOT;
        String lowerCase = string2.toLowerCase(locale);
        String str = "Waited " + j3 + " " + timeUnit.toString().toLowerCase(locale);
        if (nanos + 1000 < 0) {
            String str2 = str + " (plus ";
            long j4 = -nanos;
            long jConvert = timeUnit.convert(j4, TimeUnit.NANOSECONDS);
            long nanos2 = j4 - timeUnit.toNanos(jConvert);
            boolean z2 = jConvert == 0 || nanos2 > 1000;
            if (jConvert > 0) {
                String str3 = str2 + jConvert + " " + lowerCase;
                if (z2) {
                    str3 = str3 + ",";
                }
                str2 = str3 + " ";
            }
            if (z2) {
                str2 = str2 + nanos2 + " nanoseconds ";
            }
            str = str2 + "delay)";
        }
        if (isDone()) {
            throw new TimeoutException(str + " but future completed as timeout expired");
        }
        throw new TimeoutException(str + " for " + string);
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.f30300a instanceof Cancellation;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return (!(r0 instanceof SetFuture)) & (this.f30300a != null);
    }

    protected void k() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean o(Object obj) {
        if (obj == null) {
            obj = f30299h;
        }
        if (!f30298g.b(this, null, obj)) {
            return false;
        }
        f(this);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean p(Throwable th) {
        if (!f30298g.b(this, null, new Failure((Throwable) d(th)))) {
            return false;
        }
        f(this);
        return true;
    }

    protected final boolean r() {
        Object obj = this.f30300a;
        return (obj instanceof Cancellation) && ((Cancellation) obj).f30305a;
    }

    public String toString() {
        String strL;
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("[status=");
        if (isCancelled()) {
            sb.append("CANCELLED");
        } else if (isDone()) {
            a(sb);
        } else {
            try {
                strL = l();
            } catch (RuntimeException e3) {
                strL = "Exception thrown from implementation: " + e3.getClass();
            }
            if (strL != null && !strL.isEmpty()) {
                sb.append("PENDING, info=[");
                sb.append(strL);
                sb.append("]");
            } else if (isDone()) {
                a(sb);
            } else {
                sb.append("PENDING");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected String l() {
        Object obj = this.f30300a;
        if (obj instanceof SetFuture) {
            return YznnJpHcAmeoW.OnIfANdYf + q(((SetFuture) obj).f30319b) + "]";
        }
        if (!(this instanceof ScheduledFuture)) {
            return null;
        }
        return "remaining delay=[" + ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS) + " ms]";
    }

    @Override // java.util.concurrent.Future
    public final Object get() throws InterruptedException {
        Object obj;
        if (!Thread.interrupted()) {
            Object obj2 = this.f30300a;
            if ((obj2 != null) & (!(obj2 instanceof SetFuture))) {
                return h(obj2);
            }
            Waiter waiter = this.f30302c;
            if (waiter != Waiter.f30320c) {
                Waiter waiter2 = new Waiter();
                do {
                    waiter2.a(waiter);
                    if (f30298g.c(this, waiter, waiter2)) {
                        do {
                            LockSupport.park(this);
                            if (!Thread.interrupted()) {
                                obj = this.f30300a;
                            } else {
                                n(waiter2);
                                throw new InterruptedException();
                            }
                        } while (!((obj != null) & (!(obj instanceof SetFuture))));
                        return h(obj);
                    }
                    waiter = this.f30302c;
                } while (waiter != Waiter.f30320c);
            }
            return h(this.f30300a);
        }
        throw new InterruptedException();
    }
}
