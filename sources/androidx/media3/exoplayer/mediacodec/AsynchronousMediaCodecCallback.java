package androidx.media3.exoplayer.mediacodec;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.HandlerThread;
import androidx.collection.CircularIntArray;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.mediacodec.MediaCodecAdapter;
import java.util.ArrayDeque;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class AsynchronousMediaCodecCallback extends MediaCodec.Callback {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final HandlerThread f44227b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Handler f44228c;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private MediaFormat f44233h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private MediaFormat f44234i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private MediaCodec.CodecException f44235j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private MediaCodec.CryptoException f44236k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private long f44237l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f44238m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private IllegalStateException f44239n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private MediaCodecAdapter.OnBufferAvailableListener f44240o;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f44226a = new Object();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final CircularIntArray f44229d = new CircularIntArray();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final CircularIntArray f44230e = new CircularIntArray();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final ArrayDeque f44231f = new ArrayDeque();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final ArrayDeque f44232g = new ArrayDeque();

    AsynchronousMediaCodecCallback(HandlerThread handlerThread) {
        this.f44227b = handlerThread;
    }

    private void b(MediaFormat mediaFormat) {
        this.f44230e.a(-2);
        this.f44232g.add(mediaFormat);
    }

    private void f() {
        if (!this.f44232g.isEmpty()) {
            this.f44234i = (MediaFormat) this.f44232g.getLast();
        }
        this.f44229d.b();
        this.f44230e.b();
        this.f44231f.clear();
        this.f44232g.clear();
    }

    private boolean i() {
        return this.f44237l > 0 || this.f44238m;
    }

    private void j() {
        k();
        m();
        l();
    }

    private void k() {
        IllegalStateException illegalStateException = this.f44239n;
        if (illegalStateException == null) {
            return;
        }
        this.f44239n = null;
        throw illegalStateException;
    }

    private void l() {
        MediaCodec.CryptoException cryptoException = this.f44236k;
        if (cryptoException == null) {
            return;
        }
        this.f44236k = null;
        throw cryptoException;
    }

    private void m() {
        MediaCodec.CodecException codecException = this.f44235j;
        if (codecException == null) {
            return;
        }
        this.f44235j = null;
        throw codecException;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        synchronized (this.f44226a) {
            try {
                if (this.f44238m) {
                    return;
                }
                long j3 = this.f44237l - 1;
                this.f44237l = j3;
                if (j3 > 0) {
                    return;
                }
                if (j3 < 0) {
                    o(new IllegalStateException());
                } else {
                    f();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void o(IllegalStateException illegalStateException) {
        synchronized (this.f44226a) {
            this.f44239n = illegalStateException;
        }
    }

    public int c() {
        synchronized (this.f44226a) {
            try {
                j();
                int iE = -1;
                if (i()) {
                    return -1;
                }
                if (!this.f44229d.d()) {
                    iE = this.f44229d.e();
                }
                return iE;
            } finally {
            }
        }
    }

    public int d(MediaCodec.BufferInfo bufferInfo) {
        synchronized (this.f44226a) {
            try {
                j();
                if (i()) {
                    return -1;
                }
                if (this.f44230e.d()) {
                    return -1;
                }
                int iE = this.f44230e.e();
                if (iE >= 0) {
                    Assertions.i(this.f44233h);
                    MediaCodec.BufferInfo bufferInfo2 = (MediaCodec.BufferInfo) this.f44231f.remove();
                    bufferInfo.set(bufferInfo2.offset, bufferInfo2.size, bufferInfo2.presentationTimeUs, bufferInfo2.flags);
                } else if (iE == -2) {
                    this.f44233h = (MediaFormat) this.f44232g.remove();
                }
                return iE;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void e() {
        synchronized (this.f44226a) {
            this.f44237l++;
            ((Handler) Util.k(this.f44228c)).post(new Runnable() { // from class: androidx.media3.exoplayer.mediacodec.e
                @Override // java.lang.Runnable
                public final void run() {
                    this.f44340a.n();
                }
            });
        }
    }

    public MediaFormat g() {
        MediaFormat mediaFormat;
        synchronized (this.f44226a) {
            try {
                mediaFormat = this.f44233h;
                if (mediaFormat == null) {
                    throw new IllegalStateException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return mediaFormat;
    }

    public void h(MediaCodec mediaCodec) {
        Assertions.g(this.f44228c == null);
        this.f44227b.start();
        Handler handler = new Handler(this.f44227b.getLooper());
        mediaCodec.setCallback(this, handler);
        this.f44228c = handler;
    }

    @Override // android.media.MediaCodec.Callback
    public void onCryptoError(MediaCodec mediaCodec, MediaCodec.CryptoException cryptoException) {
        synchronized (this.f44226a) {
            this.f44236k = cryptoException;
        }
    }

    @Override // android.media.MediaCodec.Callback
    public void onError(MediaCodec mediaCodec, MediaCodec.CodecException codecException) {
        synchronized (this.f44226a) {
            this.f44235j = codecException;
        }
    }

    @Override // android.media.MediaCodec.Callback
    public void onInputBufferAvailable(MediaCodec mediaCodec, int i3) {
        synchronized (this.f44226a) {
            try {
                this.f44229d.a(i3);
                MediaCodecAdapter.OnBufferAvailableListener onBufferAvailableListener = this.f44240o;
                if (onBufferAvailableListener != null) {
                    onBufferAvailableListener.a();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.media.MediaCodec.Callback
    public void onOutputBufferAvailable(MediaCodec mediaCodec, int i3, MediaCodec.BufferInfo bufferInfo) {
        synchronized (this.f44226a) {
            try {
                MediaFormat mediaFormat = this.f44234i;
                if (mediaFormat != null) {
                    b(mediaFormat);
                    this.f44234i = null;
                }
                this.f44230e.a(i3);
                this.f44231f.add(bufferInfo);
                MediaCodecAdapter.OnBufferAvailableListener onBufferAvailableListener = this.f44240o;
                if (onBufferAvailableListener != null) {
                    onBufferAvailableListener.b();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.media.MediaCodec.Callback
    public void onOutputFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat) {
        synchronized (this.f44226a) {
            b(mediaFormat);
            this.f44234i = null;
        }
    }

    public void p(MediaCodecAdapter.OnBufferAvailableListener onBufferAvailableListener) {
        synchronized (this.f44226a) {
            this.f44240o = onBufferAvailableListener;
        }
    }

    public void q() {
        synchronized (this.f44226a) {
            this.f44238m = true;
            this.f44227b.quit();
            f();
        }
    }
}
