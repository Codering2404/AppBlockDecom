package io.reactivex.internal.util;

import androidx.compose.animation.core.h;
import io.reactivex.exceptions.CompositeException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class ExceptionHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Throwable f139204a = new Termination();

    public static boolean a(AtomicReference atomicReference, Throwable th) {
        Throwable th2;
        do {
            th2 = (Throwable) atomicReference.get();
            if (th2 == f139204a) {
                return false;
            }
        } while (!h.a(atomicReference, th2, th2 == null ? th : new CompositeException(th2, th)));
        return true;
    }

    public static Throwable b(AtomicReference atomicReference) {
        Throwable th = (Throwable) atomicReference.get();
        Throwable th2 = f139204a;
        return th != th2 ? (Throwable) atomicReference.getAndSet(th2) : th;
    }

    public static Exception c(Throwable th) throws Throwable {
        if (th instanceof Exception) {
            return (Exception) th;
        }
        throw th;
    }

    public static String d(long j3, TimeUnit timeUnit) {
        return "The source did not signal an event for " + j3 + " " + timeUnit.toString().toLowerCase() + " and has been terminated.";
    }

    public static RuntimeException e(Throwable th) {
        if (th instanceof Error) {
            throw ((Error) th);
        }
        return th instanceof RuntimeException ? (RuntimeException) th : new RuntimeException(th);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class Termination extends Throwable {
        private static final long serialVersionUID = -4649703670690200604L;

        Termination() {
            super("No further exceptions");
        }

        @Override // java.lang.Throwable
        public Throwable fillInStackTrace() {
            return this;
        }
    }
}
