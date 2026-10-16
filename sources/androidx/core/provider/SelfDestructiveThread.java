package androidx.core.provider;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public class SelfDestructiveThread {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f34233a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private HandlerThread f34234b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Handler f34235c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f34236d;

    /* JADX INFO: renamed from: androidx.core.provider.SelfDestructiveThread$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass1 implements Handler.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ SelfDestructiveThread f34237a;

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i3 = message.what;
            if (i3 == 0) {
                this.f34237a.a();
                return true;
            }
            if (i3 != 1) {
                return true;
            }
            this.f34237a.b((Runnable) message.obj);
            return true;
        }
    }

    /* JADX INFO: renamed from: androidx.core.provider.SelfDestructiveThread$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass2 implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Callable f34238a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Handler f34239b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ ReplyCallback f34240c;

        @Override // java.lang.Runnable
        public void run() {
            final Object objCall;
            try {
                objCall = this.f34238a.call();
            } catch (Exception unused) {
                objCall = null;
            }
            this.f34239b.post(new Runnable() { // from class: androidx.core.provider.SelfDestructiveThread.2.1
                @Override // java.lang.Runnable
                public void run() {
                    AnonymousClass2.this.f34240c.a(objCall);
                }
            });
        }
    }

    /* JADX INFO: renamed from: androidx.core.provider.SelfDestructiveThread$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass3 implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AtomicReference f34243a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Callable f34244b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ ReentrantLock f34245c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ AtomicBoolean f34246d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ Condition f34247f;

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f34243a.set(this.f34244b.call());
            } catch (Exception unused) {
            }
            this.f34245c.lock();
            try {
                this.f34246d.set(false);
                this.f34247f.signal();
            } finally {
                this.f34245c.unlock();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface ReplyCallback<T> {
        void a(Object obj);
    }

    void a() {
        synchronized (this.f34233a) {
            try {
                if (this.f34235c.hasMessages(1)) {
                    return;
                }
                this.f34234b.quit();
                this.f34234b = null;
                this.f34235c = null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    void b(Runnable runnable) {
        runnable.run();
        synchronized (this.f34233a) {
            this.f34235c.removeMessages(0);
            Handler handler = this.f34235c;
            handler.sendMessageDelayed(handler.obtainMessage(0), this.f34236d);
        }
    }
}
