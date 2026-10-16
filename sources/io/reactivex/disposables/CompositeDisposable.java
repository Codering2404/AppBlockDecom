package io.reactivex.disposables;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableContainer;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.OpenHashSet;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class CompositeDisposable implements Disposable, DisposableContainer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    OpenHashSet f134888a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    volatile boolean f134889b;

    @Override // io.reactivex.internal.disposables.DisposableContainer
    public boolean a(Disposable disposable) {
        if (!c(disposable)) {
            return false;
        }
        disposable.dispose();
        return true;
    }

    @Override // io.reactivex.internal.disposables.DisposableContainer
    public boolean b(Disposable disposable) {
        ObjectHelper.d(disposable, "d is null");
        if (!this.f134889b) {
            synchronized (this) {
                try {
                    if (!this.f134889b) {
                        OpenHashSet openHashSet = this.f134888a;
                        if (openHashSet == null) {
                            openHashSet = new OpenHashSet();
                            this.f134888a = openHashSet;
                        }
                        openHashSet.a(disposable);
                        return true;
                    }
                } finally {
                }
            }
        }
        disposable.dispose();
        return false;
    }

    @Override // io.reactivex.internal.disposables.DisposableContainer
    public boolean c(Disposable disposable) {
        ObjectHelper.d(disposable, "Disposable item is null");
        if (this.f134889b) {
            return false;
        }
        synchronized (this) {
            try {
                if (this.f134889b) {
                    return false;
                }
                OpenHashSet openHashSet = this.f134888a;
                if (openHashSet != null && openHashSet.e(disposable)) {
                    return true;
                }
                return false;
            } finally {
            }
        }
    }

    public void d() {
        if (this.f134889b) {
            return;
        }
        synchronized (this) {
            try {
                if (this.f134889b) {
                    return;
                }
                OpenHashSet openHashSet = this.f134888a;
                this.f134888a = null;
                f(openHashSet);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        if (this.f134889b) {
            return;
        }
        synchronized (this) {
            try {
                if (this.f134889b) {
                    return;
                }
                this.f134889b = true;
                OpenHashSet openHashSet = this.f134888a;
                this.f134888a = null;
                f(openHashSet);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean e() {
        return this.f134889b;
    }

    void f(OpenHashSet openHashSet) {
        if (openHashSet == null) {
            return;
        }
        ArrayList arrayList = null;
        for (Object obj : openHashSet.b()) {
            if (obj instanceof Disposable) {
                try {
                    ((Disposable) obj).dispose();
                } catch (Throwable th) {
                    Exceptions.b(th);
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(th);
                }
            }
        }
        if (arrayList != null) {
            if (arrayList.size() != 1) {
                throw new CompositeException(arrayList);
            }
            throw ExceptionHelper.e((Throwable) arrayList.get(0));
        }
    }

    public int g() {
        if (this.f134889b) {
            return 0;
        }
        synchronized (this) {
            try {
                if (this.f134889b) {
                    return 0;
                }
                OpenHashSet openHashSet = this.f134888a;
                return openHashSet != null ? openHashSet.g() : 0;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
