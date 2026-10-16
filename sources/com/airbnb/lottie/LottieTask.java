package com.airbnb.lottie;

import android.os.Handler;
import android.os.Looper;
import com.airbnb.lottie.utils.Logger;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class LottieTask<T> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static Executor f56385e = Executors.newCachedThreadPool();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Set f56386a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Set f56387b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Handler f56388c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile LottieResult f56389d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class LottieFutureTask extends FutureTask<LottieResult<T>> {
        LottieFutureTask(Callable callable) {
            super(callable);
        }

        @Override // java.util.concurrent.FutureTask
        protected void done() {
            if (isCancelled()) {
                return;
            }
            try {
                LottieTask.this.j(get());
            } catch (InterruptedException | ExecutionException e3) {
                LottieTask.this.j(new LottieResult(e3));
            }
        }
    }

    public LottieTask(Callable callable) {
        this(callable, false);
    }

    public static /* synthetic */ void a(LottieTask lottieTask) {
        LottieResult lottieResult = lottieTask.f56389d;
        if (lottieResult == null) {
            return;
        }
        if (lottieResult.b() != null) {
            lottieTask.g(lottieResult.b());
        } else {
            lottieTask.e(lottieResult.a());
        }
    }

    private synchronized void e(Throwable th) {
        ArrayList arrayList = new ArrayList(this.f56387b);
        if (arrayList.isEmpty()) {
            Logger.d("Lottie encountered an error but no failure listener was added:", th);
            return;
        }
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            ((LottieListener) obj).onResult(th);
        }
    }

    private void f() {
        this.f56388c.post(new Runnable() { // from class: com.airbnb.lottie.z
            @Override // java.lang.Runnable
            public final void run() {
                LottieTask.a(this.f57149a);
            }
        });
    }

    private synchronized void g(Object obj) {
        ArrayList arrayList = new ArrayList(this.f56386a);
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj2 = arrayList.get(i3);
            i3++;
            ((LottieListener) obj2).onResult(obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(LottieResult lottieResult) {
        if (this.f56389d != null) {
            throw new IllegalStateException("A task may only be set once.");
        }
        this.f56389d = lottieResult;
        f();
    }

    public synchronized LottieTask c(LottieListener lottieListener) {
        try {
            LottieResult lottieResult = this.f56389d;
            if (lottieResult != null && lottieResult.a() != null) {
                lottieListener.onResult(lottieResult.a());
            }
            this.f56387b.add(lottieListener);
        } catch (Throwable th) {
            throw th;
        }
        return this;
    }

    public synchronized LottieTask d(LottieListener lottieListener) {
        try {
            LottieResult lottieResult = this.f56389d;
            if (lottieResult != null && lottieResult.b() != null) {
                lottieListener.onResult(lottieResult.b());
            }
            this.f56386a.add(lottieListener);
        } catch (Throwable th) {
            throw th;
        }
        return this;
    }

    public synchronized LottieTask h(LottieListener lottieListener) {
        this.f56387b.remove(lottieListener);
        return this;
    }

    public synchronized LottieTask i(LottieListener lottieListener) {
        this.f56386a.remove(lottieListener);
        return this;
    }

    LottieTask(Callable callable, boolean z2) {
        this.f56386a = new LinkedHashSet(1);
        this.f56387b = new LinkedHashSet(1);
        this.f56388c = new Handler(Looper.getMainLooper());
        this.f56389d = null;
        if (!z2) {
            f56385e.execute(new LottieFutureTask(callable));
            return;
        }
        try {
            j((LottieResult) callable.call());
        } catch (Throwable th) {
            j(new LottieResult(th));
        }
    }
}
