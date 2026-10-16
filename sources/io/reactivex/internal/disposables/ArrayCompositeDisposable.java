package io.reactivex.internal.disposables;

import io.reactivex.disposables.Disposable;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class ArrayCompositeDisposable extends AtomicReferenceArray<Disposable> implements Disposable {
    private static final long serialVersionUID = 2746389416410565408L;

    public ArrayCompositeDisposable(int i3) {
        super(i3);
    }

    public boolean a(int i3, Disposable disposable) {
        Disposable disposable2;
        do {
            disposable2 = get(i3);
            if (disposable2 == DisposableHelper.DISPOSED) {
                disposable.dispose();
                return false;
            }
        } while (!compareAndSet(i3, disposable2, disposable));
        if (disposable2 == null) {
            return true;
        }
        disposable2.dispose();
        return true;
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        Disposable andSet;
        if (get(0) != DisposableHelper.DISPOSED) {
            int length = length();
            for (int i3 = 0; i3 < length; i3++) {
                Disposable disposable = get(i3);
                DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
                if (disposable != disposableHelper && (andSet = getAndSet(i3, disposableHelper)) != disposableHelper && andSet != null) {
                    andSet.dispose();
                }
            }
        }
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean e() {
        return get(0) == DisposableHelper.DISPOSED;
    }
}
