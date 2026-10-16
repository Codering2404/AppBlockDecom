package androidx.media3.exoplayer.video;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.view.Surface;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.EGLSurfaceTexture;
import androidx.media3.common.util.GlUtil;
import androidx.media3.common.util.Log;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class PlaceholderSurface extends Surface {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static int f45748d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static boolean f45749f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f45750a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final PlaceholderSurfaceThread f45751b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f45752c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class PlaceholderSurfaceThread extends HandlerThread implements Handler.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private EGLSurfaceTexture f45753a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Handler f45754b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Error f45755c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private RuntimeException f45756d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private PlaceholderSurface f45757f;

        public PlaceholderSurfaceThread() {
            super("ExoPlayer:PlaceholderSurface");
        }

        private void b(int i3) throws GlUtil.GlException {
            Assertions.e(this.f45753a);
            this.f45753a.h(i3);
            this.f45757f = new PlaceholderSurface(this, this.f45753a.g(), i3 != 0);
        }

        private void d() {
            Assertions.e(this.f45753a);
            this.f45753a.i();
        }

        public PlaceholderSurface a(int i3) {
            boolean z2;
            start();
            this.f45754b = new Handler(getLooper(), this);
            this.f45753a = new EGLSurfaceTexture(this.f45754b);
            synchronized (this) {
                z2 = false;
                this.f45754b.obtainMessage(1, i3, 0).sendToTarget();
                while (this.f45757f == null && this.f45756d == null && this.f45755c == null) {
                    try {
                        wait();
                    } catch (InterruptedException unused) {
                        z2 = true;
                    }
                }
            }
            if (z2) {
                Thread.currentThread().interrupt();
            }
            RuntimeException runtimeException = this.f45756d;
            if (runtimeException != null) {
                throw runtimeException;
            }
            Error error = this.f45755c;
            if (error == null) {
                return (PlaceholderSurface) Assertions.e(this.f45757f);
            }
            throw error;
        }

        public void c() {
            Assertions.e(this.f45754b);
            this.f45754b.sendEmptyMessage(2);
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i3 = message.what;
            try {
                if (i3 != 1) {
                    if (i3 != 2) {
                        return true;
                    }
                    try {
                        d();
                    } finally {
                        try {
                        } finally {
                        }
                    }
                    return true;
                }
                try {
                    b(message.arg1);
                    synchronized (this) {
                        notify();
                    }
                } catch (GlUtil.GlException e3) {
                    Log.e("PlaceholderSurface", "Failed to initialize placeholder surface", e3);
                    this.f45756d = new IllegalStateException(e3);
                    synchronized (this) {
                        notify();
                    }
                } catch (Error e4) {
                    Log.e("PlaceholderSurface", "Failed to initialize placeholder surface", e4);
                    this.f45755c = e4;
                    synchronized (this) {
                        notify();
                    }
                } catch (RuntimeException e5) {
                    Log.e("PlaceholderSurface", "Failed to initialize placeholder surface", e5);
                    this.f45756d = e5;
                    synchronized (this) {
                        notify();
                    }
                }
                return true;
            } catch (Throwable th) {
                synchronized (this) {
                    notify();
                    throw th;
                }
            }
        }
    }

    private static int a(Context context) {
        if (GlUtil.S(context)) {
            return GlUtil.T() ? 1 : 2;
        }
        return 0;
    }

    public static synchronized boolean c(Context context) {
        try {
            if (!f45749f) {
                f45748d = a(context);
                f45749f = true;
            }
        } catch (Throwable th) {
            throw th;
        }
        return f45748d != 0;
    }

    public static PlaceholderSurface d(Context context, boolean z2) {
        Assertions.g(!z2 || c(context));
        return new PlaceholderSurfaceThread().a(z2 ? f45748d : 0);
    }

    @Override // android.view.Surface
    public void release() {
        super.release();
        synchronized (this.f45751b) {
            try {
                if (!this.f45752c) {
                    this.f45751b.c();
                    this.f45752c = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private PlaceholderSurface(PlaceholderSurfaceThread placeholderSurfaceThread, SurfaceTexture surfaceTexture, boolean z2) {
        super(surfaceTexture);
        this.f45751b = placeholderSurfaceThread;
        this.f45750a = z2;
    }
}
