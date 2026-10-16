package androidx.asynclayoutinflater.view;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.util.Pools;
import java.util.concurrent.ArrayBlockingQueue;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
public final class AsyncLayoutInflater {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    LayoutInflater f2388a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Handler f2389b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    InflateThread f2390c;

    /* JADX INFO: renamed from: androidx.asynclayoutinflater.view.AsyncLayoutInflater$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass1 implements Handler.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AsyncLayoutInflater f2391a;

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            InflateRequest inflateRequest = (InflateRequest) message.obj;
            if (inflateRequest.f2396d == null) {
                inflateRequest.f2396d = this.f2391a.f2388a.inflate(inflateRequest.f2395c, inflateRequest.f2394b, false);
            }
            inflateRequest.f2397e.a(inflateRequest.f2396d, inflateRequest.f2395c, inflateRequest.f2394b);
            this.f2391a.f2390c.a(inflateRequest);
            return true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class BasicInflater extends LayoutInflater {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final String[] f2392a = {"android.widget.", "android.webkit.", "android.app."};

        BasicInflater(Context context) {
            super(context);
        }

        @Override // android.view.LayoutInflater
        public LayoutInflater cloneInContext(Context context) {
            return new BasicInflater(context);
        }

        @Override // android.view.LayoutInflater
        protected View onCreateView(String str, AttributeSet attributeSet) {
            View viewCreateView;
            for (String str2 : f2392a) {
                try {
                    viewCreateView = createView(str, str2, attributeSet);
                } catch (ClassNotFoundException unused) {
                }
                if (viewCreateView != null) {
                    return viewCreateView;
                }
            }
            return super.onCreateView(str, attributeSet);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class InflateRequest {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        AsyncLayoutInflater f2393a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        ViewGroup f2394b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f2395c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        View f2396d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        OnInflateFinishedListener f2397e;
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class InflateThread extends Thread {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final InflateThread f2398c;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private ArrayBlockingQueue f2399a = new ArrayBlockingQueue(10);

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Pools.SynchronizedPool f2400b = new Pools.SynchronizedPool(10);

        static {
            InflateThread inflateThread = new InflateThread();
            f2398c = inflateThread;
            inflateThread.start();
        }

        private InflateThread() {
        }

        public void a(InflateRequest inflateRequest) {
            inflateRequest.f2397e = null;
            inflateRequest.f2393a = null;
            inflateRequest.f2394b = null;
            inflateRequest.f2395c = 0;
            inflateRequest.f2396d = null;
            this.f2400b.b(inflateRequest);
        }

        public void b() {
            try {
                InflateRequest inflateRequest = (InflateRequest) this.f2399a.take();
                try {
                    inflateRequest.f2396d = inflateRequest.f2393a.f2388a.inflate(inflateRequest.f2395c, inflateRequest.f2394b, false);
                } catch (RuntimeException e3) {
                    Log.w("AsyncLayoutInflater", "Failed to inflate resource in the background! Retrying on the UI thread", e3);
                }
                Message.obtain(inflateRequest.f2393a.f2389b, 0, inflateRequest).sendToTarget();
            } catch (InterruptedException e4) {
                Log.w("AsyncLayoutInflater", e4);
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            while (true) {
                b();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface OnInflateFinishedListener {
        void a(View view, int i3, ViewGroup viewGroup);
    }
}
