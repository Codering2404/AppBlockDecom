package com.applovin.impl;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.HandlerThread;
import java.util.ArrayDeque;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class i1 extends MediaCodec.Callback {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final HandlerThread f60293b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Handler f60294c;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private MediaFormat f60299h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private MediaFormat f60300i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private MediaCodec.CodecException f60301j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private long f60302k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f60303l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private IllegalStateException f60304m;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f60292a = new Object();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final nb f60295d = new nb();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final nb f60296e = new nb();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final ArrayDeque f60297f = new ArrayDeque();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final ArrayDeque f60298g = new ArrayDeque();

    i1(HandlerThread handlerThread) {
        this.f60293b = handlerThread;
    }

    private void b() {
        if (!this.f60298g.isEmpty()) {
            this.f60300i = (MediaFormat) this.f60298g.getLast();
        }
        this.f60295d.a();
        this.f60296e.a();
        this.f60297f.clear();
        this.f60298g.clear();
        this.f60301j = null;
    }

    private boolean d() {
        return this.f60302k > 0 || this.f60303l;
    }

    private void e() {
        f();
        g();
    }

    private void f() {
        IllegalStateException illegalStateException = this.f60304m;
        if (illegalStateException == null) {
            return;
        }
        this.f60304m = null;
        throw illegalStateException;
    }

    private void g() {
        MediaCodec.CodecException codecException = this.f60301j;
        if (codecException == null) {
            return;
        }
        this.f60301j = null;
        throw codecException;
    }

    public MediaFormat c() {
        MediaFormat mediaFormat;
        synchronized (this.f60292a) {
            try {
                mediaFormat = this.f60299h;
                if (mediaFormat == null) {
                    throw new IllegalStateException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return mediaFormat;
    }

    public void h() {
        synchronized (this.f60292a) {
            this.f60303l = true;
            this.f60293b.quit();
            b();
        }
    }

    @Override // android.media.MediaCodec.Callback
    public void onError(MediaCodec mediaCodec, MediaCodec.CodecException codecException) {
        synchronized (this.f60292a) {
            this.f60301j = codecException;
        }
    }

    @Override // android.media.MediaCodec.Callback
    public void onInputBufferAvailable(MediaCodec mediaCodec, int i3) {
        synchronized (this.f60292a) {
            this.f60295d.a(i3);
        }
    }

    @Override // android.media.MediaCodec.Callback
    public void onOutputBufferAvailable(MediaCodec mediaCodec, int i3, MediaCodec.BufferInfo bufferInfo) {
        synchronized (this.f60292a) {
            try {
                MediaFormat mediaFormat = this.f60300i;
                if (mediaFormat != null) {
                    a(mediaFormat);
                    this.f60300i = null;
                }
                this.f60296e.a(i3);
                this.f60297f.add(bufferInfo);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.media.MediaCodec.Callback
    public void onOutputFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat) {
        synchronized (this.f60292a) {
            a(mediaFormat);
            this.f60300i = null;
        }
    }

    private void a(MediaFormat mediaFormat) {
        this.f60296e.a(-2);
        this.f60298g.add(mediaFormat);
    }

    private void d(Runnable runnable) {
        if (this.f60303l) {
            return;
        }
        long j3 = this.f60302k - 1;
        this.f60302k = j3;
        if (j3 > 0) {
            return;
        }
        if (j3 < 0) {
            a(new IllegalStateException());
            return;
        }
        b();
        try {
            runnable.run();
        } catch (IllegalStateException e3) {
            a(e3);
        } catch (Exception e4) {
            a(new IllegalStateException(e4));
        }
    }

    public int a() {
        synchronized (this.f60292a) {
            try {
                int iD = -1;
                if (d()) {
                    return -1;
                }
                e();
                if (!this.f60295d.c()) {
                    iD = this.f60295d.d();
                }
                return iD;
            } finally {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public void b(Runnable runnable) {
        synchronized (this.f60292a) {
            d(runnable);
        }
    }

    public int a(MediaCodec.BufferInfo bufferInfo) {
        synchronized (this.f60292a) {
            try {
                if (d()) {
                    return -1;
                }
                e();
                if (this.f60296e.c()) {
                    return -1;
                }
                int iD = this.f60296e.d();
                if (iD >= 0) {
                    b1.b(this.f60299h);
                    MediaCodec.BufferInfo bufferInfo2 = (MediaCodec.BufferInfo) this.f60297f.remove();
                    bufferInfo.set(bufferInfo2.offset, bufferInfo2.size, bufferInfo2.presentationTimeUs, bufferInfo2.flags);
                } else if (iD == -2) {
                    this.f60299h = (MediaFormat) this.f60298g.remove();
                }
                return iD;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void a(final Runnable runnable) {
        synchronized (this.f60292a) {
            this.f60302k++;
            ((Handler) xp.a(this.f60294c)).post(new Runnable() { // from class: com.applovin.impl.wx
                @Override // java.lang.Runnable
                public final void run() {
                    this.f64748a.b(runnable);
                }
            });
        }
    }

    public void a(MediaCodec mediaCodec) {
        b1.b(this.f60294c == null);
        this.f60293b.start();
        Handler handler = new Handler(this.f60293b.getLooper());
        mediaCodec.setCallback(this, handler);
        this.f60294c = handler;
    }

    private void a(IllegalStateException illegalStateException) {
        synchronized (this.f60292a) {
            this.f60304m = illegalStateException;
        }
    }
}
