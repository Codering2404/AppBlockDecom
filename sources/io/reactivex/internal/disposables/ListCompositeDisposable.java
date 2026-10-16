package io.reactivex.internal.disposables;

import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class ListCompositeDisposable implements Disposable, DisposableContainer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    List f134903a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    volatile boolean f134904b;

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
        if (!this.f134904b) {
            synchronized (this) {
                try {
                    if (!this.f134904b) {
                        List linkedList = this.f134903a;
                        if (linkedList == null) {
                            linkedList = new LinkedList();
                            this.f134903a = linkedList;
                        }
                        linkedList.add(disposable);
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
        if (this.f134904b) {
            return false;
        }
        synchronized (this) {
            try {
                if (this.f134904b) {
                    return false;
                }
                List list = this.f134903a;
                if (list != null && list.remove(disposable)) {
                    return true;
                }
                return false;
            } finally {
            }
        }
    }

    void d(List list) {
        if (list == null) {
            return;
        }
        Iterator it = list.iterator();
        ArrayList arrayList = null;
        while (it.hasNext()) {
            try {
                ((Disposable) it.next()).dispose();
            } catch (Throwable th) {
                Exceptions.b(th);
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(th);
            }
        }
        if (arrayList != null) {
            if (arrayList.size() != 1) {
                throw new CompositeException(arrayList);
            }
            throw ExceptionHelper.e((Throwable) arrayList.get(0));
        }
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        if (this.f134904b) {
            return;
        }
        synchronized (this) {
            try {
                if (this.f134904b) {
                    return;
                }
                this.f134904b = true;
                List list = this.f134903a;
                this.f134903a = null;
                d(list);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean e() {
        return this.f134904b;
    }
}
