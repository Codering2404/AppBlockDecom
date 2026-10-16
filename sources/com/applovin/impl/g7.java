package com.applovin.impl;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.view.Surface;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class g7 extends Surface {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static int f59878d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static boolean f59879f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f59880a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final b f59881b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f59882c;

    private g7(b bVar, SurfaceTexture surfaceTexture, boolean z2) {
        super(surfaceTexture);
        this.f59881b = bVar;
        this.f59880a = z2;
    }

    private static int a(Context context) {
        if (aa.a(context)) {
            return aa.c() ? 1 : 2;
        }
        return 0;
    }

    public static synchronized boolean b(Context context) {
        try {
            if (!f59879f) {
                f59878d = a(context);
                f59879f = true;
            }
        } catch (Throwable th) {
            throw th;
        }
        return f59878d != 0;
    }

    @Override // android.view.Surface
    public void release() {
        super.release();
        synchronized (this.f59881b) {
            try {
                if (!this.f59882c) {
                    this.f59881b.a();
                    this.f59882c = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static g7 a(Context context, boolean z2) {
        b1.b(!z2 || b(context));
        return new b().a(z2 ? f59878d : 0);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class b extends HandlerThread implements Handler.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private m7 f59883a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Handler f59884b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Error f59885c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private RuntimeException f59886d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private g7 f59887f;

        public b() {
            super("ExoPlayer:DummySurface");
        }

        private void b(int i3) {
            b1.a(this.f59883a);
            this.f59883a.a(i3);
            this.f59887f = new g7(this, this.f59883a.c(), i3 != 0);
        }

        public g7 a(int i3) {
            boolean z2;
            start();
            this.f59884b = new Handler(getLooper(), this);
            this.f59883a = new m7(this.f59884b);
            synchronized (this) {
                z2 = false;
                this.f59884b.obtainMessage(1, i3, 0).sendToTarget();
                while (this.f59887f == null && this.f59886d == null && this.f59885c == null) {
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
            RuntimeException runtimeException = this.f59886d;
            if (runtimeException != null) {
                throw runtimeException;
            }
            Error error = this.f59885c;
            if (error == null) {
                return (g7) b1.a(this.f59887f);
            }
            throw error;
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
                        b();
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
                } catch (Error e3) {
                    oc.a("DummySurface", "Failed to initialize dummy surface", e3);
                    this.f59885c = e3;
                    synchronized (this) {
                        notify();
                    }
                } catch (RuntimeException e4) {
                    oc.a("DummySurface", "Failed to initialize dummy surface", e4);
                    this.f59886d = e4;
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

        private void b() {
            b1.a(this.f59883a);
            this.f59883a.d();
        }

        public void a() {
            b1.a(this.f59884b);
            this.f59884b.sendEmptyMessage(2);
        }
    }
}
