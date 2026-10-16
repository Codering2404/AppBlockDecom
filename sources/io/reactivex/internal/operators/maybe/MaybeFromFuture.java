package io.reactivex.internal.operators.maybe;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.exceptions.Exceptions;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class MaybeFromFuture<T> extends Maybe<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Future f136903a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final long f136904b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final TimeUnit f136905c;

    @Override // io.reactivex.Maybe
    protected void c(MaybeObserver maybeObserver) {
        Disposable disposableB = Disposables.b();
        maybeObserver.a(disposableB);
        if (disposableB.e()) {
            return;
        }
        try {
            long j3 = this.f136904b;
            Object obj = j3 <= 0 ? this.f136903a.get() : this.f136903a.get(j3, this.f136905c);
            if (disposableB.e()) {
                return;
            }
            if (obj == null) {
                maybeObserver.onComplete();
            } else {
                maybeObserver.onSuccess(obj);
            }
        } catch (Throwable th) {
            th = th;
            if (th instanceof ExecutionException) {
                th = th.getCause();
            }
            Exceptions.b(th);
            if (disposableB.e()) {
                return;
            }
            maybeObserver.onError(th);
        }
    }
}
