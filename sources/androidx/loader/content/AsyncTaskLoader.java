package androidx.loader.content;

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import androidx.core.os.OperationCanceledException;
import androidx.core.util.TimeUtils;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AsyncTaskLoader<D> extends Loader<D> {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Executor f40274j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    volatile LoadTask f40275k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    volatile LoadTask f40276l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    long f40277m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    long f40278n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    Handler f40279o;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    final class LoadTask extends ModernAsyncTask<Void, Void, D> implements Runnable {

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private final CountDownLatch f40280l = new CountDownLatch(1);

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        boolean f40281m;

        LoadTask() {
        }

        @Override // androidx.loader.content.ModernAsyncTask
        protected void h(Object obj) {
            try {
                AsyncTaskLoader.this.B(this, obj);
            } finally {
                this.f40280l.countDown();
            }
        }

        @Override // androidx.loader.content.ModernAsyncTask
        protected void i(Object obj) {
            try {
                AsyncTaskLoader.this.C(this, obj);
            } finally {
                this.f40280l.countDown();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.loader.content.ModernAsyncTask
        /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
        public Object b(Void... voidArr) {
            try {
                return AsyncTaskLoader.this.H();
            } catch (OperationCanceledException e3) {
                if (f()) {
                    return null;
                }
                throw e3;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f40281m = false;
            AsyncTaskLoader.this.D();
        }
    }

    public AsyncTaskLoader(Context context) {
        this(context, ModernAsyncTask.f40303i);
    }

    void B(LoadTask loadTask, Object obj) {
        G(obj);
        if (this.f40276l == loadTask) {
            v();
            this.f40278n = SystemClock.uptimeMillis();
            this.f40276l = null;
            e();
            D();
        }
    }

    void C(LoadTask loadTask, Object obj) {
        if (this.f40275k != loadTask) {
            B(loadTask, obj);
            return;
        }
        if (j()) {
            G(obj);
            return;
        }
        c();
        this.f40278n = SystemClock.uptimeMillis();
        this.f40275k = null;
        f(obj);
    }

    void D() {
        if (this.f40276l != null || this.f40275k == null) {
            return;
        }
        if (this.f40275k.f40281m) {
            this.f40275k.f40281m = false;
            this.f40279o.removeCallbacks(this.f40275k);
        }
        if (this.f40277m <= 0 || SystemClock.uptimeMillis() >= this.f40278n + this.f40277m) {
            this.f40275k.c(this.f40274j, null);
        } else {
            this.f40275k.f40281m = true;
            this.f40279o.postAtTime(this.f40275k, this.f40278n + this.f40277m);
        }
    }

    public boolean E() {
        return this.f40276l != null;
    }

    public abstract Object F();

    protected Object H() {
        return F();
    }

    @Override // androidx.loader.content.Loader
    public void g(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.g(str, fileDescriptor, printWriter, strArr);
        if (this.f40275k != null) {
            printWriter.print(str);
            printWriter.print("mTask=");
            printWriter.print(this.f40275k);
            printWriter.print(" waiting=");
            printWriter.println(this.f40275k.f40281m);
        }
        if (this.f40276l != null) {
            printWriter.print(str);
            printWriter.print("mCancellingTask=");
            printWriter.print(this.f40276l);
            printWriter.print(" waiting=");
            printWriter.println(this.f40276l.f40281m);
        }
        if (this.f40277m != 0) {
            printWriter.print(str);
            printWriter.print("mUpdateThrottle=");
            TimeUtils.c(this.f40277m, printWriter);
            printWriter.print(" mLastLoadCompleteTime=");
            TimeUtils.b(this.f40278n, SystemClock.uptimeMillis(), printWriter);
            printWriter.println();
        }
    }

    @Override // androidx.loader.content.Loader
    protected boolean n() {
        if (this.f40275k == null) {
            return false;
        }
        if (!this.f40295e) {
            this.f40298h = true;
        }
        if (this.f40276l != null) {
            if (this.f40275k.f40281m) {
                this.f40275k.f40281m = false;
                this.f40279o.removeCallbacks(this.f40275k);
            }
            this.f40275k = null;
            return false;
        }
        if (this.f40275k.f40281m) {
            this.f40275k.f40281m = false;
            this.f40279o.removeCallbacks(this.f40275k);
            this.f40275k = null;
            return false;
        }
        boolean zA = this.f40275k.a(false);
        if (zA) {
            this.f40276l = this.f40275k;
            A();
        }
        this.f40275k = null;
        return zA;
    }

    @Override // androidx.loader.content.Loader
    protected void p() {
        super.p();
        b();
        this.f40275k = new LoadTask();
        D();
    }

    private AsyncTaskLoader(Context context, Executor executor) {
        super(context);
        this.f40278n = -10000L;
        this.f40274j = executor;
    }

    public void A() {
    }

    public void G(Object obj) {
    }
}
