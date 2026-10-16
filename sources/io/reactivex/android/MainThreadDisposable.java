package io.reactivex.android;

import android.os.Looper;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
public abstract class MainThreadDisposable implements Disposable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AtomicBoolean f134867a;

    protected abstract void a();

    @Override // io.reactivex.disposables.Disposable
    public final void dispose() {
        if (this.f134867a.compareAndSet(false, true)) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                a();
            } else {
                AndroidSchedulers.a().d(new Runnable() { // from class: io.reactivex.android.MainThreadDisposable.1
                    @Override // java.lang.Runnable
                    public void run() {
                        MainThreadDisposable.this.a();
                    }
                });
            }
        }
    }

    @Override // io.reactivex.disposables.Disposable
    public final boolean e() {
        return this.f134867a.get();
    }
}
