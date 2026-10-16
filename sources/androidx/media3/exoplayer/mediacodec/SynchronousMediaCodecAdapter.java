package androidx.media3.exoplayer.mediacodec;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.view.Surface;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.TraceUtil;
import androidx.media3.common.util.Util;
import androidx.media3.decoder.CryptoInfo;
import androidx.media3.exoplayer.mediacodec.MediaCodecAdapter;
import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class SynchronousMediaCodecAdapter implements MediaCodecAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MediaCodec f44331a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final LoudnessCodecController f44332b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class Factory implements MediaCodecAdapter.Factory {
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:22:0x0045  */
        /* JADX WARN: Type inference failed for: r0v0, types: [androidx.media3.exoplayer.mediacodec.SynchronousMediaCodecAdapter$1] */
        /* JADX WARN: Type inference failed for: r0v2 */
        /* JADX WARN: Type inference failed for: r0v3 */
        @Override // androidx.media3.exoplayer.mediacodec.MediaCodecAdapter.Factory
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public androidx.media3.exoplayer.mediacodec.MediaCodecAdapter b(androidx.media3.exoplayer.mediacodec.MediaCodecAdapter.Configuration r7) throws java.lang.Throwable {
            /*
                r6 = this;
                r0 = 0
                android.media.MediaCodec r1 = r6.c(r7)     // Catch: java.lang.RuntimeException -> L40 java.io.IOException -> L42
                java.lang.String r2 = "configureCodec"
                androidx.media3.common.util.TraceUtil.a(r2)     // Catch: java.lang.RuntimeException -> L1d java.io.IOException -> L20
                android.view.Surface r2 = r7.f44257d     // Catch: java.lang.RuntimeException -> L1d java.io.IOException -> L20
                if (r2 != 0) goto L22
                androidx.media3.exoplayer.mediacodec.MediaCodecInfo r3 = r7.f44254a     // Catch: java.lang.RuntimeException -> L1d java.io.IOException -> L20
                boolean r3 = r3.f44274k     // Catch: java.lang.RuntimeException -> L1d java.io.IOException -> L20
                if (r3 == 0) goto L22
                int r3 = androidx.media3.common.util.Util.f41609a     // Catch: java.lang.RuntimeException -> L1d java.io.IOException -> L20
                r4 = 35
                if (r3 < r4) goto L22
                r3 = 8
                goto L23
            L1d:
                r7 = move-exception
            L1e:
                r0 = r1
                goto L43
            L20:
                r7 = move-exception
                goto L1e
            L22:
                r3 = 0
            L23:
                android.media.MediaFormat r4 = r7.f44255b     // Catch: java.lang.RuntimeException -> L1d java.io.IOException -> L20
                android.media.MediaCrypto r5 = r7.f44258e     // Catch: java.lang.RuntimeException -> L1d java.io.IOException -> L20
                r1.configure(r4, r2, r5, r3)     // Catch: java.lang.RuntimeException -> L1d java.io.IOException -> L20
                androidx.media3.common.util.TraceUtil.b()     // Catch: java.lang.RuntimeException -> L1d java.io.IOException -> L20
                java.lang.String r2 = "startCodec"
                androidx.media3.common.util.TraceUtil.a(r2)     // Catch: java.lang.RuntimeException -> L1d java.io.IOException -> L20
                r1.start()     // Catch: java.lang.RuntimeException -> L1d java.io.IOException -> L20
                androidx.media3.common.util.TraceUtil.b()     // Catch: java.lang.RuntimeException -> L1d java.io.IOException -> L20
                androidx.media3.exoplayer.mediacodec.SynchronousMediaCodecAdapter r2 = new androidx.media3.exoplayer.mediacodec.SynchronousMediaCodecAdapter     // Catch: java.lang.RuntimeException -> L1d java.io.IOException -> L20
                androidx.media3.exoplayer.mediacodec.LoudnessCodecController r7 = r7.f44259f     // Catch: java.lang.RuntimeException -> L1d java.io.IOException -> L20
                r2.<init>(r1, r7)     // Catch: java.lang.RuntimeException -> L1d java.io.IOException -> L20
                return r2
            L40:
                r7 = move-exception
                goto L43
            L42:
                r7 = move-exception
            L43:
                if (r0 == 0) goto L48
                r0.release()
            L48:
                throw r7
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.mediacodec.SynchronousMediaCodecAdapter.Factory.b(androidx.media3.exoplayer.mediacodec.MediaCodecAdapter$Configuration):androidx.media3.exoplayer.mediacodec.MediaCodecAdapter");
        }

        protected MediaCodec c(MediaCodecAdapter.Configuration configuration) throws IOException {
            Assertions.e(configuration.f44254a);
            String str = configuration.f44254a.f44264a;
            TraceUtil.a("createCodec:" + str);
            MediaCodec mediaCodecCreateByCodecName = MediaCodec.createByCodecName(str);
            TraceUtil.b();
            return mediaCodecCreateByCodecName;
        }
    }

    public static /* synthetic */ void a(SynchronousMediaCodecAdapter synchronousMediaCodecAdapter, MediaCodecAdapter.OnFrameRenderedListener onFrameRenderedListener, MediaCodec mediaCodec, long j3, long j4) {
        synchronousMediaCodecAdapter.getClass();
        onFrameRenderedListener.a(synchronousMediaCodecAdapter, j3, j4);
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecAdapter
    public MediaFormat c() {
        return this.f44331a.getOutputFormat();
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecAdapter
    public void d(int i3, int i4, int i5, long j3, int i6) {
        this.f44331a.queueInputBuffer(i3, i4, i5, j3, i6);
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecAdapter
    public void e(int i3, int i4, CryptoInfo cryptoInfo, long j3, int i5) {
        this.f44331a.queueSecureInputBuffer(i3, i4, cryptoInfo.a(), j3, i5);
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecAdapter
    public void f(Bundle bundle) {
        this.f44331a.setParameters(bundle);
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecAdapter
    public void flush() {
        this.f44331a.flush();
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecAdapter
    public void h(final MediaCodecAdapter.OnFrameRenderedListener onFrameRenderedListener, Handler handler) {
        this.f44331a.setOnFrameRenderedListener(new MediaCodec.OnFrameRenderedListener() { // from class: androidx.media3.exoplayer.mediacodec.b0
            @Override // android.media.MediaCodec.OnFrameRenderedListener
            public final void onFrameRendered(MediaCodec mediaCodec, long j3, long j4) {
                SynchronousMediaCodecAdapter.a(this.f44336a, onFrameRenderedListener, mediaCodec, j3, j4);
            }
        }, handler);
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecAdapter
    public void i() {
        this.f44331a.detachOutputSurface();
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecAdapter
    public void j(int i3) {
        this.f44331a.setVideoScalingMode(i3);
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecAdapter
    public ByteBuffer k(int i3) {
        return this.f44331a.getInputBuffer(i3);
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecAdapter
    public void l(Surface surface) {
        this.f44331a.setOutputSurface(surface);
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecAdapter
    public boolean m() {
        return false;
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecAdapter
    public void n(int i3, long j3) {
        this.f44331a.releaseOutputBuffer(i3, j3);
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecAdapter
    public int o() {
        return this.f44331a.dequeueInputBuffer(0L);
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecAdapter
    public int p(MediaCodec.BufferInfo bufferInfo) {
        int iDequeueOutputBuffer;
        do {
            iDequeueOutputBuffer = this.f44331a.dequeueOutputBuffer(bufferInfo, 0L);
        } while (iDequeueOutputBuffer == -3);
        return iDequeueOutputBuffer;
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecAdapter
    public void q(int i3, boolean z2) {
        this.f44331a.releaseOutputBuffer(i3, z2);
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecAdapter
    public ByteBuffer r(int i3) {
        return this.f44331a.getOutputBuffer(i3);
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecAdapter
    public void release() {
        LoudnessCodecController loudnessCodecController;
        LoudnessCodecController loudnessCodecController2;
        try {
            int i3 = Util.f41609a;
            if (i3 >= 30 && i3 < 33) {
                this.f44331a.stop();
            }
            if (i3 >= 35 && (loudnessCodecController2 = this.f44332b) != null) {
                loudnessCodecController2.d(this.f44331a);
            }
            this.f44331a.release();
        } catch (Throwable th) {
            if (Util.f41609a >= 35 && (loudnessCodecController = this.f44332b) != null) {
                loudnessCodecController.d(this.f44331a);
            }
            this.f44331a.release();
            throw th;
        }
    }

    private SynchronousMediaCodecAdapter(MediaCodec mediaCodec, LoudnessCodecController loudnessCodecController) {
        this.f44331a = mediaCodec;
        this.f44332b = loudnessCodecController;
        if (Util.f41609a < 35 || loudnessCodecController == null) {
            return;
        }
        loudnessCodecController.b(mediaCodec);
    }
}
