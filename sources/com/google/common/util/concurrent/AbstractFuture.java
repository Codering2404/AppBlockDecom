package com.google.common.util.concurrent;

import com.google.android.gms.internal.ads.v;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.util.concurrent.internal.InternalFutureFailureAccess;
import com.google.common.util.concurrent.internal.InternalFutures;
import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.util.Locale;
import java.util.Objects;
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
import kotlinx.serialization.json.internal.OBeo.vgWWUoTKYyuC;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public abstract class AbstractFuture<V> extends InternalFutureFailureAccess implements ListenableFuture<V> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final boolean f85620d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final LazyLogger f85621f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final AtomicHelper f85622g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final Object f85623h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile Object f85624a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile Listener f85625b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile Waiter f85626c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static abstract class AtomicHelper {
        private AtomicHelper() {
        }

        abstract boolean a(AbstractFuture abstractFuture, Listener listener, Listener listener2);

        abstract boolean b(AbstractFuture abstractFuture, Object obj, Object obj2);

        abstract boolean c(AbstractFuture abstractFuture, Waiter waiter, Waiter waiter2);

        abstract Listener d(AbstractFuture abstractFuture, Listener listener);

        abstract Waiter e(AbstractFuture abstractFuture, Waiter waiter);

        abstract void f(Waiter waiter, Waiter waiter2);

        abstract void g(Waiter waiter, Thread thread);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class Cancellation {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        static final Cancellation f85627c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        static final Cancellation f85628d;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final boolean f85629a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Throwable f85630b;

        static {
            if (AbstractFuture.f85620d) {
                f85628d = null;
                f85627c = null;
            } else {
                f85628d = new Cancellation(false, null);
                f85627c = new Cancellation(true, null);
            }
        }

        Cancellation(boolean z2, Throwable th) {
            this.f85629a = z2;
            this.f85630b = th;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class Failure {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final Failure f85631b = new Failure(new Throwable("Failure occurred while trying to finish a future.") { // from class: com.google.common.util.concurrent.AbstractFuture.Failure.1
            @Override // java.lang.Throwable
            public synchronized Throwable fillInStackTrace() {
                return this;
            }
        });

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Throwable f85632a;

        Failure(Throwable th) {
            this.f85632a = (Throwable) Preconditions.t(th);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class SafeAtomicHelper extends AtomicHelper {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final AtomicReferenceFieldUpdater f85637a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final AtomicReferenceFieldUpdater f85638b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final AtomicReferenceFieldUpdater f85639c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final AtomicReferenceFieldUpdater f85640d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final AtomicReferenceFieldUpdater f85641e;

        SafeAtomicHelper(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater5) {
            super();
            this.f85637a = atomicReferenceFieldUpdater;
            this.f85638b = atomicReferenceFieldUpdater2;
            this.f85639c = atomicReferenceFieldUpdater3;
            this.f85640d = atomicReferenceFieldUpdater4;
            this.f85641e = atomicReferenceFieldUpdater5;
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.AtomicHelper
        boolean a(AbstractFuture abstractFuture, Listener listener, Listener listener2) {
            return androidx.concurrent.futures.a.a(this.f85640d, abstractFuture, listener, listener2);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.AtomicHelper
        boolean b(AbstractFuture abstractFuture, Object obj, Object obj2) {
            return androidx.concurrent.futures.a.a(this.f85641e, abstractFuture, obj, obj2);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.AtomicHelper
        boolean c(AbstractFuture abstractFuture, Waiter waiter, Waiter waiter2) {
            return androidx.concurrent.futures.a.a(this.f85639c, abstractFuture, waiter, waiter2);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.AtomicHelper
        Listener d(AbstractFuture abstractFuture, Listener listener) {
            return (Listener) this.f85640d.getAndSet(abstractFuture, listener);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.AtomicHelper
        Waiter e(AbstractFuture abstractFuture, Waiter waiter) {
            return (Waiter) this.f85639c.getAndSet(abstractFuture, waiter);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.AtomicHelper
        void f(Waiter waiter, Waiter waiter2) {
            this.f85638b.lazySet(waiter, waiter2);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.AtomicHelper
        void g(Waiter waiter, Thread thread) {
            this.f85637a.lazySet(waiter, thread);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class SetFuture<V> implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final AbstractFuture f85642a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final ListenableFuture f85643b;

        SetFuture(AbstractFuture abstractFuture, ListenableFuture listenableFuture) {
            this.f85642a = abstractFuture;
            this.f85643b = listenableFuture;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f85642a.f85624a != this) {
                return;
            }
            if (AbstractFuture.f85622g.b(this.f85642a, this, AbstractFuture.u(this.f85643b))) {
                AbstractFuture.r(this.f85642a, false);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class SynchronizedHelper extends AtomicHelper {
        private SynchronizedHelper() {
            super();
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.AtomicHelper
        boolean a(AbstractFuture abstractFuture, Listener listener, Listener listener2) {
            synchronized (abstractFuture) {
                try {
                    if (abstractFuture.f85625b != listener) {
                        return false;
                    }
                    abstractFuture.f85625b = listener2;
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.AtomicHelper
        boolean b(AbstractFuture abstractFuture, Object obj, Object obj2) {
            synchronized (abstractFuture) {
                try {
                    if (abstractFuture.f85624a != obj) {
                        return false;
                    }
                    abstractFuture.f85624a = obj2;
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.AtomicHelper
        boolean c(AbstractFuture abstractFuture, Waiter waiter, Waiter waiter2) {
            synchronized (abstractFuture) {
                try {
                    if (abstractFuture.f85626c != waiter) {
                        return false;
                    }
                    abstractFuture.f85626c = waiter2;
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.AtomicHelper
        Listener d(AbstractFuture abstractFuture, Listener listener) {
            Listener listener2;
            synchronized (abstractFuture) {
                try {
                    listener2 = abstractFuture.f85625b;
                    if (listener2 != listener) {
                        abstractFuture.f85625b = listener;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return listener2;
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.AtomicHelper
        Waiter e(AbstractFuture abstractFuture, Waiter waiter) {
            Waiter waiter2;
            synchronized (abstractFuture) {
                try {
                    waiter2 = abstractFuture.f85626c;
                    if (waiter2 != waiter) {
                        abstractFuture.f85626c = waiter;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return waiter2;
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.AtomicHelper
        void f(Waiter waiter, Waiter waiter2) {
            waiter.f85652b = waiter2;
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.AtomicHelper
        void g(Waiter waiter, Thread thread) {
            waiter.f85651a = thread;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    interface Trusted<V> extends ListenableFuture<V> {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static abstract class TrustedFuture<V> extends AbstractFuture<V> implements Trusted<V> {
        TrustedFuture() {
        }

        @Override // com.google.common.util.concurrent.AbstractFuture, com.google.common.util.concurrent.ListenableFuture
        public void addListener(Runnable runnable, Executor executor) {
            super.addListener(runnable, executor);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
        public boolean cancel(boolean z2) {
            return super.cancel(z2);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
        public Object get() {
            return super.get();
        }

        @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
        public boolean isCancelled() {
            return super.isCancelled();
        }

        @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
        public boolean isDone() {
            return super.isDone();
        }

        @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
        public Object get(long j3, TimeUnit timeUnit) {
            return super.get(j3, timeUnit);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class UnsafeAtomicHelper extends AtomicHelper {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final Unsafe f85644a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final long f85645b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        static final long f85646c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        static final long f85647d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        static final long f85648e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        static final long f85649f;

        static {
            Unsafe unsafe;
            try {
                try {
                    unsafe = Unsafe.getUnsafe();
                } catch (PrivilegedActionException e3) {
                    throw new RuntimeException("Could not initialize intrinsics", e3.getCause());
                }
            } catch (SecurityException unused) {
                unsafe = (Unsafe) AccessController.doPrivileged(new PrivilegedExceptionAction<Unsafe>() { // from class: com.google.common.util.concurrent.AbstractFuture.UnsafeAtomicHelper.1
                    @Override // java.security.PrivilegedExceptionAction
                    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                    public Unsafe run() throws IllegalAccessException {
                        for (Field field : Unsafe.class.getDeclaredFields()) {
                            field.setAccessible(true);
                            Object obj = field.get(null);
                            if (Unsafe.class.isInstance(obj)) {
                                return (Unsafe) Unsafe.class.cast(obj);
                            }
                        }
                        throw new NoSuchFieldError("the Unsafe");
                    }
                });
            }
            try {
                f85646c = unsafe.objectFieldOffset(AbstractFuture.class.getDeclaredField("c"));
                f85645b = unsafe.objectFieldOffset(AbstractFuture.class.getDeclaredField("b"));
                f85647d = unsafe.objectFieldOffset(AbstractFuture.class.getDeclaredField("a"));
                f85648e = unsafe.objectFieldOffset(Waiter.class.getDeclaredField("a"));
                f85649f = unsafe.objectFieldOffset(Waiter.class.getDeclaredField("b"));
                f85644a = unsafe;
            } catch (NoSuchFieldException e4) {
                throw new RuntimeException(e4);
            }
        }

        private UnsafeAtomicHelper() {
            super();
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.AtomicHelper
        boolean a(AbstractFuture abstractFuture, Listener listener, Listener listener2) {
            return v.a(f85644a, abstractFuture, f85645b, listener, listener2);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.AtomicHelper
        boolean b(AbstractFuture abstractFuture, Object obj, Object obj2) {
            return v.a(f85644a, abstractFuture, f85647d, obj, obj2);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.AtomicHelper
        boolean c(AbstractFuture abstractFuture, Waiter waiter, Waiter waiter2) {
            return v.a(f85644a, abstractFuture, f85646c, waiter, waiter2);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.AtomicHelper
        Listener d(AbstractFuture abstractFuture, Listener listener) {
            Listener listener2;
            do {
                listener2 = abstractFuture.f85625b;
                if (listener == listener2) {
                    break;
                }
            } while (!a(abstractFuture, listener2, listener));
            return listener2;
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.AtomicHelper
        Waiter e(AbstractFuture abstractFuture, Waiter waiter) {
            Waiter waiter2;
            do {
                waiter2 = abstractFuture.f85626c;
                if (waiter == waiter2) {
                    break;
                }
            } while (!c(abstractFuture, waiter2, waiter));
            return waiter2;
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.AtomicHelper
        void f(Waiter waiter, Waiter waiter2) {
            f85644a.putObject(waiter, f85649f, waiter2);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.AtomicHelper
        void g(Waiter waiter, Thread thread) {
            f85644a.putObject(waiter, f85648e, thread);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class Waiter {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        static final Waiter f85650c = new Waiter(false);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        volatile Thread f85651a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        volatile Waiter f85652b;

        Waiter(boolean z2) {
        }

        void a(Waiter waiter) {
            AbstractFuture.f85622g.f(this, waiter);
        }

        void b() {
            Thread thread = this.f85651a;
            if (thread != null) {
                this.f85651a = null;
                LockSupport.unpark(thread);
            }
        }

        Waiter() {
            AbstractFuture.f85622g.g(this, Thread.currentThread());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v14, types: [java.util.logging.Logger] */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.lang.Error] */
    /* JADX WARN: Type inference failed for: r5v0, types: [com.google.common.util.concurrent.AbstractFuture$1] */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v2, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r5v3 */
    static {
        boolean z2;
        Throwable th;
        AtomicHelper safeAtomicHelper;
        try {
            z2 = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));
        } catch (SecurityException unused) {
            z2 = false;
        }
        f85620d = z2;
        f85621f = new LazyLogger(AbstractFuture.class);
        ?? r5 = 0;
        r5 = 0;
        try {
            safeAtomicHelper = new UnsafeAtomicHelper();
            th = null;
        } catch (Error | Exception e3) {
            th = e3;
            try {
                safeAtomicHelper = new SafeAtomicHelper(AtomicReferenceFieldUpdater.newUpdater(Waiter.class, Thread.class, "a"), AtomicReferenceFieldUpdater.newUpdater(Waiter.class, Waiter.class, "b"), AtomicReferenceFieldUpdater.newUpdater(AbstractFuture.class, Waiter.class, "c"), AtomicReferenceFieldUpdater.newUpdater(AbstractFuture.class, Listener.class, "b"), AtomicReferenceFieldUpdater.newUpdater(AbstractFuture.class, Object.class, "a"));
            } catch (Error | Exception e4) {
                SynchronizedHelper synchronizedHelper = new SynchronizedHelper();
                r5 = e4;
                safeAtomicHelper = synchronizedHelper;
            }
        }
        f85622g = safeAtomicHelper;
        if (r5 != 0) {
            LazyLogger lazyLogger = f85621f;
            Logger loggerA = lazyLogger.a();
            Level level = Level.SEVERE;
            loggerA.log(level, "UnsafeAtomicHelper is broken!", th);
            lazyLogger.a().log(level, "SafeAtomicHelper is broken!", r5);
        }
        f85623h = new Object();
    }

    protected AbstractFuture() {
    }

    private void A(Waiter waiter) {
        waiter.f85651a = null;
        while (true) {
            Waiter waiter2 = this.f85626c;
            if (waiter2 == Waiter.f85650c) {
                return;
            }
            Waiter waiter3 = null;
            while (waiter2 != null) {
                Waiter waiter4 = waiter2.f85652b;
                if (waiter2.f85651a != null) {
                    waiter3 = waiter2;
                } else if (waiter3 != null) {
                    waiter3.f85652b = waiter4;
                    if (waiter3.f85651a == null) {
                        break;
                    }
                } else if (!f85622g.c(this, waiter2, waiter4)) {
                    break;
                }
                waiter2 = waiter4;
            }
            return;
        }
    }

    private void k(StringBuilder sb) {
        try {
            Object objV = v(this);
            sb.append("SUCCESS, result=[");
            n(sb, objV);
            sb.append("]");
        } catch (CancellationException unused) {
            sb.append("CANCELLED");
        } catch (ExecutionException e3) {
            sb.append("FAILURE, cause=[");
            sb.append(e3.getCause());
            sb.append("]");
        } catch (Exception e4) {
            sb.append("UNKNOWN, cause=[");
            sb.append(e4.getClass());
            sb.append(" thrown from get()]");
        }
    }

    private void l(StringBuilder sb) {
        String strA;
        int length = sb.length();
        sb.append("PENDING");
        Object obj = this.f85624a;
        if (obj instanceof SetFuture) {
            sb.append(", setFuture=[");
            o(sb, ((SetFuture) obj).f85643b);
            sb.append("]");
        } else {
            try {
                strA = Strings.a(y());
            } catch (Exception | StackOverflowError e3) {
                strA = "Exception thrown from implementation: " + e3.getClass();
            }
            if (strA != null) {
                sb.append(", info=[");
                sb.append(strA);
                sb.append("]");
            }
        }
        if (isDone()) {
            sb.delete(length, sb.length());
            k(sb);
        }
    }

    private void n(StringBuilder sb, Object obj) {
        if (obj == null) {
            sb.append("null");
        } else {
            if (obj == this) {
                sb.append("this future");
                return;
            }
            sb.append(obj.getClass().getName());
            sb.append("@");
            sb.append(Integer.toHexString(System.identityHashCode(obj)));
        }
    }

    private void o(StringBuilder sb, Object obj) {
        try {
            if (obj == this) {
                sb.append("this future");
            } else {
                sb.append(obj);
            }
        } catch (Exception e3) {
            e = e3;
            sb.append("Exception thrown from implementation: ");
            sb.append(e.getClass());
        } catch (StackOverflowError e4) {
            e = e4;
            sb.append("Exception thrown from implementation: ");
            sb.append(e.getClass());
        }
    }

    private static CancellationException p(String str, Throwable th) {
        CancellationException cancellationException = new CancellationException(str);
        cancellationException.initCause(th);
        return cancellationException;
    }

    private Listener q(Listener listener) {
        Listener listener2 = listener;
        Listener listenerD = f85622g.d(this, Listener.f85633d);
        while (listenerD != null) {
            Listener listener3 = listenerD.f85636c;
            listenerD.f85636c = listener2;
            listener2 = listenerD;
            listenerD = listener3;
        }
        return listener2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void r(AbstractFuture abstractFuture, boolean z2) {
        Listener listener = null;
        while (true) {
            abstractFuture.z();
            if (z2) {
                abstractFuture.w();
                z2 = false;
            }
            abstractFuture.m();
            Listener listenerQ = abstractFuture.q(listener);
            while (listenerQ != null) {
                listener = listenerQ.f85636c;
                Runnable runnable = listenerQ.f85634a;
                Objects.requireNonNull(runnable);
                Runnable runnable2 = runnable;
                if (runnable2 instanceof SetFuture) {
                    SetFuture setFuture = (SetFuture) runnable2;
                    abstractFuture = setFuture.f85642a;
                    if (abstractFuture.f85624a == setFuture) {
                        if (f85622g.b(abstractFuture, setFuture, u(setFuture.f85643b))) {
                            break;
                        }
                    } else {
                        continue;
                    }
                } else {
                    Executor executor = listenerQ.f85635b;
                    Objects.requireNonNull(executor);
                    s(runnable2, executor);
                }
                listenerQ = listener;
            }
            return;
        }
    }

    private static void s(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (Exception e3) {
            f85621f.a().log(Level.SEVERE, "RuntimeException while executing runnable " + runnable + " with executor " + executor, (Throwable) e3);
        }
    }

    private Object t(Object obj) throws ExecutionException {
        if (obj instanceof Cancellation) {
            throw p("Task was cancelled.", ((Cancellation) obj).f85630b);
        }
        if (obj instanceof Failure) {
            throw new ExecutionException(((Failure) obj).f85632a);
        }
        return obj == f85623h ? NullnessCasts.b() : obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static Object u(ListenableFuture listenableFuture) {
        Throwable thA;
        if (listenableFuture instanceof Trusted) {
            Object cancellation = ((AbstractFuture) listenableFuture).f85624a;
            if (cancellation instanceof Cancellation) {
                Cancellation cancellation2 = (Cancellation) cancellation;
                if (cancellation2.f85629a) {
                    cancellation = cancellation2.f85630b != null ? new Cancellation(false, cancellation2.f85630b) : Cancellation.f85628d;
                }
            }
            Objects.requireNonNull(cancellation);
            return cancellation;
        }
        if ((listenableFuture instanceof InternalFutureFailureAccess) && (thA = InternalFutures.a((InternalFutureFailureAccess) listenableFuture)) != null) {
            return new Failure(thA);
        }
        boolean zIsCancelled = listenableFuture.isCancelled();
        if ((!f85620d) && zIsCancelled) {
            Cancellation cancellation3 = Cancellation.f85628d;
            Objects.requireNonNull(cancellation3);
            return cancellation3;
        }
        try {
            Object objV = v(listenableFuture);
            if (!zIsCancelled) {
                return objV == null ? f85623h : objV;
            }
            return new Cancellation(false, new IllegalArgumentException("get() did not throw CancellationException, despite reporting isCancelled() == true: " + listenableFuture));
        } catch (Error | Exception e3) {
            return new Failure(e3);
        } catch (CancellationException e4) {
            if (zIsCancelled) {
                return new Cancellation(false, e4);
            }
            return new Failure(new IllegalArgumentException("get() threw CancellationException, despite reporting isCancelled() == false: " + listenableFuture, e4));
        } catch (ExecutionException e5) {
            if (!zIsCancelled) {
                return new Failure(e5.getCause());
            }
            return new Cancellation(false, new IllegalArgumentException("get() did not throw CancellationException, despite reporting isCancelled() == true: " + listenableFuture, e5));
        }
    }

    private static Object v(Future future) {
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

    private void z() {
        for (Waiter waiterE = f85622g.e(this, Waiter.f85650c); waiterE != null; waiterE = waiterE.f85652b) {
            waiterE.b();
        }
    }

    protected boolean B(Object obj) {
        if (obj == null) {
            obj = f85623h;
        }
        if (!f85622g.b(this, null, obj)) {
            return false;
        }
        r(this, false);
        return true;
    }

    protected boolean C(Throwable th) {
        if (!f85622g.b(this, null, new Failure((Throwable) Preconditions.t(th)))) {
            return false;
        }
        r(this, false);
        return true;
    }

    protected boolean D(ListenableFuture listenableFuture) {
        Failure failure;
        Preconditions.t(listenableFuture);
        Object obj = this.f85624a;
        if (obj == null) {
            if (listenableFuture.isDone()) {
                if (!f85622g.b(this, null, u(listenableFuture))) {
                    return false;
                }
                r(this, false);
                return true;
            }
            SetFuture setFuture = new SetFuture(this, listenableFuture);
            if (f85622g.b(this, null, setFuture)) {
                try {
                    listenableFuture.addListener(setFuture, DirectExecutor.INSTANCE);
                } catch (Throwable th) {
                    try {
                        failure = new Failure(th);
                    } catch (Error | Exception unused) {
                        failure = Failure.f85631b;
                    }
                    f85622g.b(this, setFuture, failure);
                }
                return true;
            }
            obj = this.f85624a;
        }
        if (obj instanceof Cancellation) {
            listenableFuture.cancel(((Cancellation) obj).f85629a);
        }
        return false;
    }

    protected final boolean E() {
        Object obj = this.f85624a;
        return (obj instanceof Cancellation) && ((Cancellation) obj).f85629a;
    }

    @Override // com.google.common.util.concurrent.internal.InternalFutureFailureAccess
    protected final Throwable a() {
        if (!(this instanceof Trusted)) {
            return null;
        }
        Object obj = this.f85624a;
        if (obj instanceof Failure) {
            return ((Failure) obj).f85632a;
        }
        return null;
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z2) {
        Cancellation cancellation;
        Object obj = this.f85624a;
        if (!(obj == null) && !(obj instanceof SetFuture)) {
            return false;
        }
        if (f85620d) {
            cancellation = new Cancellation(z2, new CancellationException("Future.cancel() was called."));
        } else {
            cancellation = z2 ? Cancellation.f85627c : Cancellation.f85628d;
            Objects.requireNonNull(cancellation);
        }
        AbstractFuture<V> abstractFuture = this;
        boolean z3 = false;
        while (true) {
            if (f85622g.b(abstractFuture, obj, cancellation)) {
                r(abstractFuture, z2);
                if (!(obj instanceof SetFuture)) {
                    break;
                }
                ListenableFuture listenableFuture = ((SetFuture) obj).f85643b;
                if (!(listenableFuture instanceof Trusted)) {
                    listenableFuture.cancel(z2);
                    break;
                }
                abstractFuture = (AbstractFuture) listenableFuture;
                obj = abstractFuture.f85624a;
                if (!(obj == null) && !(obj instanceof SetFuture)) {
                    break;
                }
                z3 = true;
            } else {
                obj = abstractFuture.f85624a;
                if (!(obj instanceof SetFuture)) {
                    return z3;
                }
            }
        }
        return true;
    }

    @Override // java.util.concurrent.Future
    public Object get(long j3, TimeUnit timeUnit) throws InterruptedException, TimeoutException {
        long nanos = timeUnit.toNanos(j3);
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object obj = this.f85624a;
        if ((obj != null) && (!(obj instanceof SetFuture))) {
            return t(obj);
        }
        long jNanoTime = nanos > 0 ? System.nanoTime() + nanos : 0L;
        if (nanos >= 1000) {
            Waiter waiter = this.f85626c;
            if (waiter != Waiter.f85650c) {
                Waiter waiter2 = new Waiter();
                do {
                    waiter2.a(waiter);
                    if (f85622g.c(this, waiter, waiter2)) {
                        do {
                            OverflowAvoidingLockSupport.a(this, nanos);
                            if (Thread.interrupted()) {
                                A(waiter2);
                                throw new InterruptedException();
                            }
                            Object obj2 = this.f85624a;
                            if ((obj2 != null) && (!(obj2 instanceof SetFuture))) {
                                return t(obj2);
                            }
                            nanos = jNanoTime - System.nanoTime();
                        } while (nanos >= 1000);
                        A(waiter2);
                    } else {
                        waiter = this.f85626c;
                    }
                } while (waiter != Waiter.f85650c);
            }
            Object obj3 = this.f85624a;
            Objects.requireNonNull(obj3);
            return t(obj3);
        }
        while (nanos > 0) {
            Object obj4 = this.f85624a;
            if ((obj4 != null) && (!(obj4 instanceof SetFuture))) {
                return t(obj4);
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
    public boolean isCancelled() {
        return this.f85624a instanceof Cancellation;
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return (!(r0 instanceof SetFuture)) & (this.f85624a != null);
    }

    protected void m() {
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (getClass().getName().startsWith("com.google.common.util.concurrent.")) {
            sb.append(getClass().getSimpleName());
        } else {
            sb.append(getClass().getName());
        }
        sb.append('@');
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("[status=");
        if (isCancelled()) {
            sb.append("CANCELLED");
        } else if (isDone()) {
            k(sb);
        } else {
            l(sb);
        }
        sb.append("]");
        return sb.toString();
    }

    protected void w() {
    }

    final void x(Future future) {
        if ((future != null) && isCancelled()) {
            future.cancel(E());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected String y() {
        if (!(this instanceof ScheduledFuture)) {
            return null;
        }
        return "remaining delay=[" + ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS) + " ms]";
    }

    @Override // com.google.common.util.concurrent.ListenableFuture
    public void addListener(Runnable runnable, Executor executor) {
        Listener listener;
        Preconditions.u(runnable, vgWWUoTKYyuC.kxyqV);
        Preconditions.u(executor, "Executor was null.");
        if (!isDone() && (listener = this.f85625b) != Listener.f85633d) {
            Listener listener2 = new Listener(runnable, executor);
            do {
                listener2.f85636c = listener;
                if (f85622g.a(this, listener, listener2)) {
                    return;
                } else {
                    listener = this.f85625b;
                }
            } while (listener != Listener.f85633d);
        }
        s(runnable, executor);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class Listener {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        static final Listener f85633d = new Listener();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Runnable f85634a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Executor f85635b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Listener f85636c;

        Listener(Runnable runnable, Executor executor) {
            this.f85634a = runnable;
            this.f85635b = executor;
        }

        Listener() {
            this.f85634a = null;
            this.f85635b = null;
        }
    }

    @Override // java.util.concurrent.Future
    public Object get() throws InterruptedException {
        Object obj;
        if (!Thread.interrupted()) {
            Object obj2 = this.f85624a;
            if ((obj2 != null) & (!(obj2 instanceof SetFuture))) {
                return t(obj2);
            }
            Waiter waiter = this.f85626c;
            if (waiter != Waiter.f85650c) {
                Waiter waiter2 = new Waiter();
                do {
                    waiter2.a(waiter);
                    if (f85622g.c(this, waiter, waiter2)) {
                        do {
                            LockSupport.park(this);
                            if (!Thread.interrupted()) {
                                obj = this.f85624a;
                            } else {
                                A(waiter2);
                                throw new InterruptedException();
                            }
                        } while (!((obj != null) & (!(obj instanceof SetFuture))));
                        return t(obj);
                    }
                    waiter = this.f85626c;
                } while (waiter != Waiter.f85650c);
            }
            Object obj3 = this.f85624a;
            Objects.requireNonNull(obj3);
            return t(obj3);
        }
        throw new InterruptedException();
    }
}
