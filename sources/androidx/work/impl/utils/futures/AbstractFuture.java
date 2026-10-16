package androidx.work.impl.utils.futures;

import androidx.concurrent.futures.a;
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
/* JADX INFO: loaded from: classes4.dex */
public abstract class AbstractFuture<V> implements ListenableFuture<V> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final boolean f55228d = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Logger f55229f = Logger.getLogger(AbstractFuture.class.getName());

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    static final AtomicHelper f55230g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final Object f55231h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    volatile Object f55232a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    volatile Listener f55233b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    volatile Waiter f55234c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static abstract class AtomicHelper {
        private AtomicHelper() {
        }

        abstract boolean a(AbstractFuture abstractFuture, Listener listener, Listener listener2);

        abstract boolean b(AbstractFuture abstractFuture, Object obj, Object obj2);

        abstract boolean c(AbstractFuture abstractFuture, Waiter waiter, Waiter waiter2);

        abstract void d(Waiter waiter, Waiter waiter2);

        abstract void e(Waiter waiter, Thread thread);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class Cancellation {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        static final Cancellation f55235c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        static final Cancellation f55236d;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final boolean f55237a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Throwable f55238b;

        static {
            if (AbstractFuture.f55228d) {
                f55236d = null;
                f55235c = null;
            } else {
                f55236d = new Cancellation(false, null);
                f55235c = new Cancellation(true, null);
            }
        }

        Cancellation(boolean z2, Throwable th) {
            this.f55237a = z2;
            this.f55238b = th;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class Failure {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final Failure f55239b = new Failure(new Throwable("Failure occurred while trying to finish a future.") { // from class: androidx.work.impl.utils.futures.AbstractFuture.Failure.1
            @Override // java.lang.Throwable
            public synchronized Throwable fillInStackTrace() {
                return this;
            }
        });

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Throwable f55240a;

        Failure(Throwable th) {
            this.f55240a = (Throwable) AbstractFuture.d(th);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class Listener {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        static final Listener f55241d = new Listener(null, null);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Runnable f55242a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Executor f55243b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Listener f55244c;

        Listener(Runnable runnable, Executor executor) {
            this.f55242a = runnable;
            this.f55243b = executor;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class SafeAtomicHelper extends AtomicHelper {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final AtomicReferenceFieldUpdater f55245a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final AtomicReferenceFieldUpdater f55246b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final AtomicReferenceFieldUpdater f55247c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final AtomicReferenceFieldUpdater f55248d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final AtomicReferenceFieldUpdater f55249e;

        SafeAtomicHelper(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater5) {
            super();
            this.f55245a = atomicReferenceFieldUpdater;
            this.f55246b = atomicReferenceFieldUpdater2;
            this.f55247c = atomicReferenceFieldUpdater3;
            this.f55248d = atomicReferenceFieldUpdater4;
            this.f55249e = atomicReferenceFieldUpdater5;
        }

        @Override // androidx.work.impl.utils.futures.AbstractFuture.AtomicHelper
        boolean a(AbstractFuture abstractFuture, Listener listener, Listener listener2) {
            return a.a(this.f55248d, abstractFuture, listener, listener2);
        }

        @Override // androidx.work.impl.utils.futures.AbstractFuture.AtomicHelper
        boolean b(AbstractFuture abstractFuture, Object obj, Object obj2) {
            return a.a(this.f55249e, abstractFuture, obj, obj2);
        }

        @Override // androidx.work.impl.utils.futures.AbstractFuture.AtomicHelper
        boolean c(AbstractFuture abstractFuture, Waiter waiter, Waiter waiter2) {
            return a.a(this.f55247c, abstractFuture, waiter, waiter2);
        }

        @Override // androidx.work.impl.utils.futures.AbstractFuture.AtomicHelper
        void d(Waiter waiter, Waiter waiter2) {
            this.f55246b.lazySet(waiter, waiter2);
        }

        @Override // androidx.work.impl.utils.futures.AbstractFuture.AtomicHelper
        void e(Waiter waiter, Thread thread) {
            this.f55245a.lazySet(waiter, thread);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class SetFuture<V> implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final AbstractFuture f55250a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final ListenableFuture f55251b;

        SetFuture(AbstractFuture abstractFuture, ListenableFuture listenableFuture) {
            this.f55250a = abstractFuture;
            this.f55251b = listenableFuture;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f55250a.f55232a != this) {
                return;
            }
            if (AbstractFuture.f55230g.b(this.f55250a, this, AbstractFuture.i(this.f55251b))) {
                AbstractFuture.f(this.f55250a);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class SynchronizedHelper extends AtomicHelper {
        SynchronizedHelper() {
            super();
        }

        @Override // androidx.work.impl.utils.futures.AbstractFuture.AtomicHelper
        boolean a(AbstractFuture abstractFuture, Listener listener, Listener listener2) {
            synchronized (abstractFuture) {
                try {
                    if (abstractFuture.f55233b != listener) {
                        return false;
                    }
                    abstractFuture.f55233b = listener2;
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // androidx.work.impl.utils.futures.AbstractFuture.AtomicHelper
        boolean b(AbstractFuture abstractFuture, Object obj, Object obj2) {
            synchronized (abstractFuture) {
                try {
                    if (abstractFuture.f55232a != obj) {
                        return false;
                    }
                    abstractFuture.f55232a = obj2;
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // androidx.work.impl.utils.futures.AbstractFuture.AtomicHelper
        boolean c(AbstractFuture abstractFuture, Waiter waiter, Waiter waiter2) {
            synchronized (abstractFuture) {
                try {
                    if (abstractFuture.f55234c != waiter) {
                        return false;
                    }
                    abstractFuture.f55234c = waiter2;
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // androidx.work.impl.utils.futures.AbstractFuture.AtomicHelper
        void d(Waiter waiter, Waiter waiter2) {
            waiter.f55254b = waiter2;
        }

        @Override // androidx.work.impl.utils.futures.AbstractFuture.AtomicHelper
        void e(Waiter waiter, Thread thread) {
            waiter.f55253a = thread;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class Waiter {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        static final Waiter f55252c = new Waiter(false);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        volatile Thread f55253a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        volatile Waiter f55254b;

        Waiter(boolean z2) {
        }

        void a(Waiter waiter) {
            AbstractFuture.f55230g.d(this, waiter);
        }

        void b() {
            Thread thread = this.f55253a;
            if (thread != null) {
                this.f55253a = null;
                LockSupport.unpark(thread);
            }
        }

        Waiter() {
            AbstractFuture.f55230g.e(this, Thread.currentThread());
        }
    }

    static {
        AtomicHelper synchronizedHelper;
        try {
            synchronizedHelper = new SafeAtomicHelper(AtomicReferenceFieldUpdater.newUpdater(Waiter.class, Thread.class, "a"), AtomicReferenceFieldUpdater.newUpdater(Waiter.class, Waiter.class, "b"), AtomicReferenceFieldUpdater.newUpdater(AbstractFuture.class, Waiter.class, "c"), AtomicReferenceFieldUpdater.newUpdater(AbstractFuture.class, Listener.class, "b"), AtomicReferenceFieldUpdater.newUpdater(AbstractFuture.class, Object.class, "a"));
            th = null;
        } catch (Throwable th) {
            th = th;
            synchronizedHelper = new SynchronizedHelper();
        }
        f55230g = synchronizedHelper;
        if (th != null) {
            f55229f.log(Level.SEVERE, "SafeAtomicHelper is broken!", th);
        }
        f55231h = new Object();
    }

    protected AbstractFuture() {
    }

    private void a(StringBuilder sb) {
        try {
            Object objJ = j(this);
            sb.append("SUCCESS, result=[");
            sb.append(r(objJ));
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
            listener2 = this.f55233b;
        } while (!f55230g.a(this, listener2, Listener.f55241d));
        Listener listener3 = listener;
        Listener listener4 = listener2;
        while (listener4 != null) {
            Listener listener5 = listener4.f55244c;
            listener4.f55244c = listener3;
            listener3 = listener4;
            listener4 = listener5;
        }
        return listener3;
    }

    static void f(AbstractFuture abstractFuture) {
        Listener listener = null;
        while (true) {
            abstractFuture.m();
            abstractFuture.b();
            Listener listenerE = abstractFuture.e(listener);
            while (listenerE != null) {
                listener = listenerE.f55244c;
                Runnable runnable = listenerE.f55242a;
                if (runnable instanceof SetFuture) {
                    SetFuture setFuture = (SetFuture) runnable;
                    abstractFuture = setFuture.f55250a;
                    if (abstractFuture.f55232a == setFuture) {
                        if (f55230g.b(abstractFuture, setFuture, i(setFuture.f55251b))) {
                            break;
                        }
                    } else {
                        continue;
                    }
                } else {
                    g(runnable, listenerE.f55243b);
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
            f55229f.log(Level.SEVERE, "RuntimeException while executing runnable " + runnable + " with executor " + executor, (Throwable) e3);
        }
    }

    private Object h(Object obj) throws ExecutionException {
        if (obj instanceof Cancellation) {
            throw c("Task was cancelled.", ((Cancellation) obj).f55238b);
        }
        if (obj instanceof Failure) {
            throw new ExecutionException(((Failure) obj).f55240a);
        }
        if (obj == f55231h) {
            return null;
        }
        return obj;
    }

    static Object i(ListenableFuture listenableFuture) {
        if (listenableFuture instanceof AbstractFuture) {
            Object obj = ((AbstractFuture) listenableFuture).f55232a;
            if (!(obj instanceof Cancellation)) {
                return obj;
            }
            Cancellation cancellation = (Cancellation) obj;
            return cancellation.f55237a ? cancellation.f55238b != null ? new Cancellation(false, cancellation.f55238b) : Cancellation.f55236d : obj;
        }
        boolean zIsCancelled = listenableFuture.isCancelled();
        if ((!f55228d) && zIsCancelled) {
            return Cancellation.f55236d;
        }
        try {
            Object objJ = j(listenableFuture);
            return objJ == null ? f55231h : objJ;
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

    private static Object j(Future future) {
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
            waiter = this.f55234c;
        } while (!f55230g.c(this, waiter, Waiter.f55252c));
        while (waiter != null) {
            waiter.b();
            waiter = waiter.f55254b;
        }
    }

    private void n(Waiter waiter) {
        waiter.f55253a = null;
        while (true) {
            Waiter waiter2 = this.f55234c;
            if (waiter2 == Waiter.f55252c) {
                return;
            }
            Waiter waiter3 = null;
            while (waiter2 != null) {
                Waiter waiter4 = waiter2.f55254b;
                if (waiter2.f55253a != null) {
                    waiter3 = waiter2;
                } else if (waiter3 != null) {
                    waiter3.f55254b = waiter4;
                    if (waiter3.f55253a == null) {
                        break;
                    }
                } else if (!f55230g.c(this, waiter2, waiter4)) {
                    break;
                }
                waiter2 = waiter4;
            }
            return;
        }
    }

    private String r(Object obj) {
        return obj == this ? "this future" : String.valueOf(obj);
    }

    @Override // com.google.common.util.concurrent.ListenableFuture
    public final void addListener(Runnable runnable, Executor executor) {
        d(runnable);
        d(executor);
        Listener listener = this.f55233b;
        if (listener != Listener.f55241d) {
            Listener listener2 = new Listener(runnable, executor);
            do {
                listener2.f55244c = listener;
                if (f55230g.a(this, listener, listener2)) {
                    return;
                } else {
                    listener = this.f55233b;
                }
            } while (listener != Listener.f55241d);
        }
        g(runnable, executor);
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z2) {
        Object obj = this.f55232a;
        if (!(obj == null) && !(obj instanceof SetFuture)) {
            return false;
        }
        Cancellation cancellation = f55228d ? new Cancellation(z2, new CancellationException("Future.cancel() was called.")) : z2 ? Cancellation.f55235c : Cancellation.f55236d;
        AbstractFuture<V> abstractFuture = this;
        boolean z3 = false;
        while (true) {
            if (f55230g.b(abstractFuture, obj, cancellation)) {
                if (z2) {
                    abstractFuture.k();
                }
                f(abstractFuture);
                if (!(obj instanceof SetFuture)) {
                    break;
                }
                ListenableFuture listenableFuture = ((SetFuture) obj).f55251b;
                if (!(listenableFuture instanceof AbstractFuture)) {
                    listenableFuture.cancel(z2);
                    break;
                }
                abstractFuture = (AbstractFuture) listenableFuture;
                obj = abstractFuture.f55232a;
                if (!(obj == null) && !(obj instanceof SetFuture)) {
                    break;
                }
                z3 = true;
            } else {
                obj = abstractFuture.f55232a;
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
        Object obj = this.f55232a;
        if ((obj != null) && (!(obj instanceof SetFuture))) {
            return h(obj);
        }
        long jNanoTime = nanos > 0 ? System.nanoTime() + nanos : 0L;
        if (nanos >= 1000) {
            Waiter waiter = this.f55234c;
            if (waiter != Waiter.f55252c) {
                Waiter waiter2 = new Waiter();
                do {
                    waiter2.a(waiter);
                    if (f55230g.c(this, waiter, waiter2)) {
                        do {
                            LockSupport.parkNanos(this, nanos);
                            if (Thread.interrupted()) {
                                n(waiter2);
                                throw new InterruptedException();
                            }
                            Object obj2 = this.f55232a;
                            if ((obj2 != null) && (!(obj2 instanceof SetFuture))) {
                                return h(obj2);
                            }
                            nanos = jNanoTime - System.nanoTime();
                        } while (nanos >= 1000);
                        n(waiter2);
                    } else {
                        waiter = this.f55234c;
                    }
                } while (waiter != Waiter.f55252c);
            }
            return h(this.f55232a);
        }
        while (nanos > 0) {
            Object obj3 = this.f55232a;
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
        return this.f55232a instanceof Cancellation;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return (!(r0 instanceof SetFuture)) & (this.f55232a != null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected String l() {
        Object obj = this.f55232a;
        if (obj instanceof SetFuture) {
            return "setFuture=[" + r(((SetFuture) obj).f55251b) + "]";
        }
        if (!(this instanceof ScheduledFuture)) {
            return null;
        }
        return "remaining delay=[" + ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS) + " ms]";
    }

    protected boolean o(Object obj) {
        if (obj == null) {
            obj = f55231h;
        }
        if (!f55230g.b(this, null, obj)) {
            return false;
        }
        f(this);
        return true;
    }

    protected boolean p(Throwable th) {
        if (!f55230g.b(this, null, new Failure((Throwable) d(th)))) {
            return false;
        }
        f(this);
        return true;
    }

    protected boolean q(ListenableFuture listenableFuture) {
        Failure failure;
        d(listenableFuture);
        Object obj = this.f55232a;
        if (obj == null) {
            if (listenableFuture.isDone()) {
                if (!f55230g.b(this, null, i(listenableFuture))) {
                    return false;
                }
                f(this);
                return true;
            }
            SetFuture setFuture = new SetFuture(this, listenableFuture);
            if (f55230g.b(this, null, setFuture)) {
                try {
                    listenableFuture.addListener(setFuture, DirectExecutor.INSTANCE);
                } catch (Throwable th) {
                    try {
                        failure = new Failure(th);
                    } catch (Throwable unused) {
                        failure = Failure.f55239b;
                    }
                    f55230g.b(this, setFuture, failure);
                }
                return true;
            }
            obj = this.f55232a;
        }
        if (obj instanceof Cancellation) {
            listenableFuture.cancel(((Cancellation) obj).f55237a);
        }
        return false;
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

    protected void b() {
    }

    protected void k() {
    }

    @Override // java.util.concurrent.Future
    public final Object get() throws InterruptedException {
        Object obj;
        if (!Thread.interrupted()) {
            Object obj2 = this.f55232a;
            if ((obj2 != null) & (!(obj2 instanceof SetFuture))) {
                return h(obj2);
            }
            Waiter waiter = this.f55234c;
            if (waiter != Waiter.f55252c) {
                Waiter waiter2 = new Waiter();
                do {
                    waiter2.a(waiter);
                    if (f55230g.c(this, waiter, waiter2)) {
                        do {
                            LockSupport.park(this);
                            if (!Thread.interrupted()) {
                                obj = this.f55232a;
                            } else {
                                n(waiter2);
                                throw new InterruptedException();
                            }
                        } while (!((obj != null) & (!(obj instanceof SetFuture))));
                        return h(obj);
                    }
                    waiter = this.f55234c;
                } while (waiter != Waiter.f55252c);
            }
            return h(this.f55232a);
        }
        throw new InterruptedException();
    }
}
