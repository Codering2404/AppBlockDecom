package androidx.media3.exoplayer.mediacodec;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.Surface;
import androidx.glance.color.Tq.KqqtdetwHMIO;
import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.TraceUtil;
import androidx.media3.common.util.Util;
import androidx.media3.decoder.CryptoInfo;
import androidx.media3.exoplayer.mediacodec.AsynchronousMediaCodecAdapter;
import androidx.media3.exoplayer.mediacodec.MediaCodecAdapter;
import com.google.common.base.Supplier;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes2.dex */
final class AsynchronousMediaCodecAdapter implements MediaCodecAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MediaCodec f44202a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AsynchronousMediaCodecCallback f44203b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final MediaCodecBufferEnqueuer f44204c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final LoudnessCodecController f44205d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f44206e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f44207f;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes3.dex */
    public static final class Factory implements MediaCodecAdapter.Factory {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Supplier f44208b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Supplier f44209c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f44210d;

        public Factory(final int i3) {
            this(new Supplier() { // from class: androidx.media3.exoplayer.mediacodec.c
                @Override // com.google.common.base.Supplier
                public final Object get() {
                    return AsynchronousMediaCodecAdapter.Factory.d(i3);
                }
            }, new Supplier() { // from class: androidx.media3.exoplayer.mediacodec.d
                @Override // com.google.common.base.Supplier
                public final Object get() {
                    return AsynchronousMediaCodecAdapter.Factory.c(i3);
                }
            });
        }

        public static /* synthetic */ HandlerThread c(int i3) {
            return new HandlerThread(AsynchronousMediaCodecAdapter.v(i3));
        }

        public static /* synthetic */ HandlerThread d(int i3) {
            return new HandlerThread(AsynchronousMediaCodecAdapter.u(i3));
        }

        private static boolean g(Format format) {
            int i3 = Util.f41609a;
            if (i3 < 34) {
                return false;
            }
            return i3 >= 35 || MimeTypes.q(format.f40632o);
        }

        @Override // androidx.media3.exoplayer.mediacodec.MediaCodecAdapter.Factory
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public AsynchronousMediaCodecAdapter b(MediaCodecAdapter.Configuration configuration) throws Exception {
            Exception exc;
            MediaCodec mediaCodecCreateByCodecName;
            MediaCodecBufferEnqueuer asynchronousMediaCodecBufferEnqueuer;
            int i3;
            String str = configuration.f44254a.f44264a;
            AsynchronousMediaCodecAdapter asynchronousMediaCodecAdapter = null;
            try {
                TraceUtil.a("createCodec:" + str);
                mediaCodecCreateByCodecName = MediaCodec.createByCodecName(str);
                try {
                    if (this.f44210d && g(configuration.f44256c)) {
                        asynchronousMediaCodecBufferEnqueuer = new SynchronousMediaCodecBufferEnqueuer(mediaCodecCreateByCodecName);
                        i3 = 4;
                    } else {
                        asynchronousMediaCodecBufferEnqueuer = new AsynchronousMediaCodecBufferEnqueuer(mediaCodecCreateByCodecName, (HandlerThread) this.f44209c.get());
                        i3 = 0;
                    }
                    AsynchronousMediaCodecAdapter asynchronousMediaCodecAdapter2 = new AsynchronousMediaCodecAdapter(mediaCodecCreateByCodecName, (HandlerThread) this.f44208b.get(), asynchronousMediaCodecBufferEnqueuer, configuration.f44259f);
                    try {
                        TraceUtil.b();
                        Surface surface = configuration.f44257d;
                        if (surface == null && configuration.f44254a.f44274k && Util.f41609a >= 35) {
                            i3 |= 8;
                        }
                        asynchronousMediaCodecAdapter2.x(configuration.f44255b, surface, configuration.f44258e, i3);
                        return asynchronousMediaCodecAdapter2;
                    } catch (Exception e3) {
                        exc = e3;
                        asynchronousMediaCodecAdapter = asynchronousMediaCodecAdapter2;
                        if (asynchronousMediaCodecAdapter != null) {
                            asynchronousMediaCodecAdapter.release();
                            throw exc;
                        }
                        if (mediaCodecCreateByCodecName == null) {
                            throw exc;
                        }
                        mediaCodecCreateByCodecName.release();
                        throw exc;
                    }
                } catch (Exception e4) {
                    exc = e4;
                }
            } catch (Exception e5) {
                exc = e5;
                mediaCodecCreateByCodecName = null;
            }
        }

        public void f(boolean z2) {
            this.f44210d = z2;
        }

        public Factory(Supplier supplier, Supplier supplier2) {
            this.f44208b = supplier;
            this.f44209c = supplier2;
            this.f44210d = false;
        }
    }

    public static /* synthetic */ void a(AsynchronousMediaCodecAdapter asynchronousMediaCodecAdapter, MediaCodecAdapter.OnFrameRenderedListener onFrameRenderedListener, MediaCodec mediaCodec, long j3, long j4) {
        asynchronousMediaCodecAdapter.getClass();
        onFrameRenderedListener.a(asynchronousMediaCodecAdapter, j3, j4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String u(int i3) {
        return w(i3, "ExoPlayer:MediaCodecAsyncAdapter:");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String v(int i3) {
        return w(i3, "ExoPlayer:MediaCodecQueueingThread:");
    }

    private static String w(int i3, String str) {
        StringBuilder sb = new StringBuilder(str);
        if (i3 == 1) {
            sb.append("Audio");
        } else if (i3 == 2) {
            sb.append("Video");
        } else {
            sb.append("Unknown(");
            sb.append(i3);
            sb.append(")");
        }
        return sb.toString();
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecAdapter
    public MediaFormat c() {
        return this.f44203b.g();
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecAdapter
    public void d(int i3, int i4, int i5, long j3, int i6) {
        this.f44204c.d(i3, i4, i5, j3, i6);
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecAdapter
    public void e(int i3, int i4, CryptoInfo cryptoInfo, long j3, int i5) {
        this.f44204c.e(i3, i4, cryptoInfo, j3, i5);
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecAdapter
    public void f(Bundle bundle) {
        this.f44204c.f(bundle);
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecAdapter
    public void flush() {
        this.f44204c.flush();
        this.f44202a.flush();
        this.f44203b.e();
        this.f44202a.start();
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecAdapter
    public boolean g(MediaCodecAdapter.OnBufferAvailableListener onBufferAvailableListener) {
        this.f44203b.p(onBufferAvailableListener);
        return true;
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecAdapter
    public void h(final MediaCodecAdapter.OnFrameRenderedListener onFrameRenderedListener, Handler handler) {
        this.f44202a.setOnFrameRenderedListener(new MediaCodec.OnFrameRenderedListener() { // from class: androidx.media3.exoplayer.mediacodec.b
            @Override // android.media.MediaCodec.OnFrameRenderedListener
            public final void onFrameRendered(MediaCodec mediaCodec, long j3, long j4) {
                AsynchronousMediaCodecAdapter.a(this.f44334a, onFrameRenderedListener, mediaCodec, j3, j4);
            }
        }, handler);
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecAdapter
    public void i() {
        this.f44202a.detachOutputSurface();
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecAdapter
    public void j(int i3) {
        this.f44202a.setVideoScalingMode(i3);
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecAdapter
    public ByteBuffer k(int i3) {
        return this.f44202a.getInputBuffer(i3);
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecAdapter
    public void l(Surface surface) {
        this.f44202a.setOutputSurface(surface);
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecAdapter
    public boolean m() {
        return false;
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecAdapter
    public void n(int i3, long j3) {
        this.f44202a.releaseOutputBuffer(i3, j3);
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecAdapter
    public int o() {
        this.f44204c.a();
        return this.f44203b.c();
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecAdapter
    public int p(MediaCodec.BufferInfo bufferInfo) {
        this.f44204c.a();
        return this.f44203b.d(bufferInfo);
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecAdapter
    public void q(int i3, boolean z2) {
        this.f44202a.releaseOutputBuffer(i3, z2);
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecAdapter
    public ByteBuffer r(int i3) {
        return this.f44202a.getOutputBuffer(i3);
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecAdapter
    public void release() {
        LoudnessCodecController loudnessCodecController;
        LoudnessCodecController loudnessCodecController2;
        try {
            if (this.f44207f == 1) {
                this.f44204c.shutdown();
                this.f44203b.q();
            }
            this.f44207f = 2;
            if (this.f44206e) {
                return;
            }
            try {
                int i3 = Util.f41609a;
                if (i3 >= 30 && i3 < 33) {
                    this.f44202a.stop();
                }
                if (i3 >= 35 && (loudnessCodecController2 = this.f44205d) != null) {
                    loudnessCodecController2.d(this.f44202a);
                }
                this.f44202a.release();
                this.f44206e = true;
            } finally {
            }
        } catch (Throwable th) {
            if (!this.f44206e) {
                try {
                    int i4 = Util.f41609a;
                    if (i4 >= 30 && i4 < 33) {
                        this.f44202a.stop();
                    }
                    if (i4 >= 35 && (loudnessCodecController = this.f44205d) != null) {
                        loudnessCodecController.d(this.f44202a);
                    }
                    this.f44202a.release();
                    this.f44206e = true;
                } finally {
                }
            }
            throw th;
        }
    }

    private AsynchronousMediaCodecAdapter(MediaCodec mediaCodec, HandlerThread handlerThread, MediaCodecBufferEnqueuer mediaCodecBufferEnqueuer, LoudnessCodecController loudnessCodecController) {
        this.f44202a = mediaCodec;
        this.f44203b = new AsynchronousMediaCodecCallback(handlerThread);
        this.f44204c = mediaCodecBufferEnqueuer;
        this.f44205d = loudnessCodecController;
        this.f44207f = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(MediaFormat mediaFormat, Surface surface, MediaCrypto mediaCrypto, int i3) {
        LoudnessCodecController loudnessCodecController;
        this.f44203b.h(this.f44202a);
        TraceUtil.a(KqqtdetwHMIO.GDdgWOZaGyK);
        this.f44202a.configure(mediaFormat, surface, mediaCrypto, i3);
        TraceUtil.b();
        this.f44204c.start();
        TraceUtil.a("startCodec");
        this.f44202a.start();
        TraceUtil.b();
        if (Util.f41609a >= 35 && (loudnessCodecController = this.f44205d) != null) {
            loudnessCodecController.b(this.f44202a);
        }
        this.f44207f = 1;
    }
}
