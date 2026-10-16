package io.reactivex.internal.disposables;

import androidx.compose.animation.core.h;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.ProtocolViolationException;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public enum DisposableHelper implements Disposable {
    DISPOSED;

    public static boolean a(AtomicReference atomicReference) {
        Disposable disposable;
        Disposable disposable2 = (Disposable) atomicReference.get();
        DisposableHelper disposableHelper = DISPOSED;
        if (disposable2 == disposableHelper || (disposable = (Disposable) atomicReference.getAndSet(disposableHelper)) == disposableHelper) {
            return false;
        }
        if (disposable == null) {
            return true;
        }
        disposable.dispose();
        return true;
    }

    public static boolean b(Disposable disposable) {
        return disposable == DISPOSED;
    }

    public static boolean c(AtomicReference atomicReference, Disposable disposable) {
        Disposable disposable2;
        do {
            disposable2 = (Disposable) atomicReference.get();
            if (disposable2 == DISPOSED) {
                if (disposable == null) {
                    return false;
                }
                disposable.dispose();
                return false;
            }
        } while (!h.a(atomicReference, disposable2, disposable));
        return true;
    }

    public static void d() {
        RxJavaPlugins.s(new ProtocolViolationException("Disposable already set!"));
    }

    public static boolean f(AtomicReference atomicReference, Disposable disposable) {
        Disposable disposable2;
        do {
            disposable2 = (Disposable) atomicReference.get();
            if (disposable2 == DISPOSED) {
                if (disposable == null) {
                    return false;
                }
                disposable.dispose();
                return false;
            }
        } while (!h.a(atomicReference, disposable2, disposable));
        if (disposable2 == null) {
            return true;
        }
        disposable2.dispose();
        return true;
    }

    public static boolean g(AtomicReference atomicReference, Disposable disposable) {
        ObjectHelper.d(disposable, "d is null");
        if (h.a(atomicReference, null, disposable)) {
            return true;
        }
        disposable.dispose();
        if (atomicReference.get() == DISPOSED) {
            return false;
        }
        d();
        return false;
    }

    public static boolean h(AtomicReference atomicReference, Disposable disposable) {
        if (h.a(atomicReference, null, disposable)) {
            return true;
        }
        if (atomicReference.get() != DISPOSED) {
            return false;
        }
        disposable.dispose();
        return false;
    }

    public static boolean i(Disposable disposable, Disposable disposable2) {
        if (disposable2 == null) {
            RxJavaPlugins.s(new NullPointerException("next is null"));
            return false;
        }
        if (disposable == null) {
            return true;
        }
        disposable2.dispose();
        d();
        return false;
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean e() {
        return true;
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
    }
}
