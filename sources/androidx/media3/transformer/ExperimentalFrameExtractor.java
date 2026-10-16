package androidx.media3.transformer;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.ColorSpace;
import android.opengl.GLES20;
import android.util.DisplayMetrics;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.media3.common.ColorInfo;
import androidx.media3.common.Effect;
import androidx.media3.common.Format;
import androidx.media3.common.GlObjectsProvider;
import androidx.media3.common.GlTextureInfo;
import androidx.media3.common.PlaybackException;
import androidx.media3.common.VideoFrameProcessingException;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.GlProgram;
import androidx.media3.common.util.GlUtil;
import androidx.media3.common.util.Util;
import androidx.media3.effect.GlEffect;
import androidx.media3.effect.GlShaderProgram;
import androidx.media3.effect.PassthroughShaderProgram;
import androidx.media3.effect.ScaleAndRotateTransformation;
import androidx.media3.exoplayer.DecoderReuseEvaluation;
import androidx.media3.exoplayer.ExoPlaybackException;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.exoplayer.FormatHolder;
import androidx.media3.exoplayer.analytics.AnalyticsListener;
import androidx.media3.exoplayer.mediacodec.MediaCodecAdapter;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.video.MediaCodecVideoRenderer;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class ExperimentalFrameExtractor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ExoPlayer f48173a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AtomicBoolean f48174b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final AtomicReference f48175c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Frame f48176d;

    /* JADX INFO: renamed from: androidx.media3.transformer.ExperimentalFrameExtractor$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass1 implements FutureCallback<Frame> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f48177a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ CallbackToFutureAdapter.Completer f48178b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ ExperimentalFrameExtractor f48179c;

        @Override // com.google.common.util.concurrent.FutureCallback
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(Frame frame) {
            this.f48179c.f48176d = frame;
            this.f48179c.g(this.f48177a, this.f48178b);
        }

        @Override // com.google.common.util.concurrent.FutureCallback
        public void onFailure(Throwable th) {
            this.f48179c.g(this.f48177a, this.f48178b);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Configuration {

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        public static final class Builder {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Frame {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f48180a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Bitmap f48181b;

        /* synthetic */ Frame(long j3, Bitmap bitmap, AnonymousClass1 anonymousClass1) {
            this(j3, bitmap);
        }

        private Frame(long j3, Bitmap bitmap) {
            this.f48180a = j3;
            this.f48181b = bitmap;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private final class FrameExtractorRenderer extends MediaCodecVideoRenderer {
        private List A1;
        private Effect B1;
        final /* synthetic */ ExperimentalFrameExtractor C1;

        /* JADX INFO: renamed from: y1, reason: collision with root package name */
        private final boolean f48182y1;

        /* JADX INFO: renamed from: z1, reason: collision with root package name */
        private boolean f48183z1;

        private void j3() {
            ImmutableList.Builder builder = new ImmutableList.Builder();
            Effect effect = this.B1;
            if (effect != null) {
                builder.a(effect);
            }
            builder.k(this.A1);
            super.V2(builder.m());
        }

        private void k3(Effect effect) {
            this.B1 = effect;
            j3();
        }

        @Override // androidx.media3.exoplayer.video.MediaCodecVideoRenderer, androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
        protected boolean A1(long j3, long j4, MediaCodecAdapter mediaCodecAdapter, ByteBuffer byteBuffer, int i3, int i4, int i5, long j5, boolean z2, boolean z3, Format format) {
            if (this.f48183z1) {
                return false;
            }
            return super.A1(j3, j4, mediaCodecAdapter, byteBuffer, i3, i4, i5, j5, z2, z3, format);
        }

        @Override // androidx.media3.exoplayer.video.MediaCodecVideoRenderer
        protected void Q2(MediaCodecAdapter mediaCodecAdapter, int i3, long j3, long j4) {
            if (this.f48183z1) {
                return;
            }
            this.f48183z1 = true;
            super.Q2(mediaCodecAdapter, i3, j3, j4);
        }

        @Override // androidx.media3.exoplayer.video.MediaCodecVideoRenderer
        public void V2(List list) {
            this.A1 = list;
            j3();
        }

        @Override // androidx.media3.exoplayer.video.MediaCodecVideoRenderer, androidx.media3.exoplayer.mediacodec.MediaCodecRenderer, androidx.media3.exoplayer.Renderer
        public void h(long j3, long j4) throws ExoPlaybackException {
            if (this.f48183z1) {
                return;
            }
            super.h(j3, j4);
        }

        @Override // androidx.media3.exoplayer.video.MediaCodecVideoRenderer, androidx.media3.exoplayer.mediacodec.MediaCodecRenderer, androidx.media3.exoplayer.BaseRenderer
        protected void h0(long j3, boolean z2) throws ExoPlaybackException {
            this.f48183z1 = false;
            this.C1.f48174b.set(true);
            super.h0(j3, z2);
        }

        @Override // androidx.media3.exoplayer.video.MediaCodecVideoRenderer, androidx.media3.exoplayer.mediacodec.MediaCodecRenderer, androidx.media3.exoplayer.Renderer
        public boolean isReady() {
            return this.f48183z1;
        }

        @Override // androidx.media3.exoplayer.video.MediaCodecVideoRenderer, androidx.media3.exoplayer.mediacodec.MediaCodecRenderer, androidx.media3.exoplayer.BaseRenderer
        protected void n0(Format[] formatArr, long j3, long j4, MediaSource.MediaPeriodId mediaPeriodId) {
            super.n0(formatArr, j3, j4, mediaPeriodId);
            this.f48183z1 = false;
            k3(null);
        }

        @Override // androidx.media3.exoplayer.video.MediaCodecVideoRenderer, androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
        protected boolean o1(Format format) {
            if (ColorInfo.l(format.C) && this.f48182y1) {
                format = format.b().T(ColorInfo.f40546h).N();
            }
            return super.o1(format);
        }

        @Override // androidx.media3.exoplayer.video.MediaCodecVideoRenderer, androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
        protected DecoderReuseEvaluation s1(FormatHolder formatHolder) {
            Format format = formatHolder.f43108b;
            if (format != null && format.f40642y != 0) {
                k3(new ScaleAndRotateTransformation.Builder().b(360 - format.f40642y).a());
                formatHolder.f43108b = format.b().t0(0).N();
            }
            return super.s1(formatHolder);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private final class FrameReader implements GlEffect {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ExperimentalFrameExtractor f48184a;

        @Override // androidx.media3.effect.GlEffect
        public GlShaderProgram a(Context context, boolean z2) {
            return this.f48184a.new FrameReadingGlShaderProgram(context, z2);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private final class FrameReadingGlShaderProgram extends PassthroughShaderProgram {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final boolean f48185f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final ImmutableList f48186g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private GlTextureInfo f48187h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private GlProgram f48188i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private ByteBuffer f48189j;

        public FrameReadingGlShaderProgram(Context context, boolean z2) throws VideoFrameProcessingException {
            ImmutableList immutableListC = ImmutableList.C(new float[]{-1.0f, -1.0f, 0.0f, 1.0f}, new float[]{-1.0f, 1.0f, 0.0f, 1.0f}, new float[]{1.0f, 1.0f, 0.0f, 1.0f}, new float[]{1.0f, -1.0f, 0.0f, 1.0f});
            this.f48186g = immutableListC;
            this.f48189j = ByteBuffer.allocateDirect(0);
            this.f48185f = z2;
            if (z2) {
                Assertions.g(Util.f41609a >= 34);
                try {
                    GlProgram glProgram = new GlProgram(context, "shaders/vertex_shader_transformation_es3.glsl", "shaders/fragment_shader_oetf_es3.glsl");
                    this.f48188i = glProgram;
                    glProgram.p("uTexTransformationMatrix", GlUtil.h());
                    this.f48188i.p("uTransformationMatrix", GlUtil.h());
                    this.f48188i.p("uRgbMatrix", GlUtil.h());
                    this.f48188i.r("uOutputColorTransfer", 7);
                    this.f48188i.m("aFramePosition", GlUtil.x(immutableListC), 4);
                } catch (GlUtil.GlException | IOException e3) {
                    throw new VideoFrameProcessingException(e3);
                }
            }
        }

        private void n(GlObjectsProvider glObjectsProvider, int i3, int i4) {
            int i5 = i3 * i4 * 4;
            if (this.f48189j.capacity() != i5) {
                this.f48189j = ByteBuffer.allocateDirect(i5);
            }
            this.f48189j.clear();
            if (this.f48185f) {
                GlTextureInfo glTextureInfo = this.f48187h;
                if (glTextureInfo != null && glTextureInfo.f40693d == i3 && glTextureInfo.f40694e == i4) {
                    return;
                }
                if (glTextureInfo != null) {
                    try {
                        glTextureInfo.a();
                    } catch (GlUtil.GlException e3) {
                        j(e3);
                        return;
                    }
                }
                this.f48187h = glObjectsProvider.b(GlUtil.t(i3, i4), i3, i4);
            }
        }

        @Override // androidx.media3.effect.PassthroughShaderProgram, androidx.media3.effect.GlShaderProgram
        public void d(GlObjectsProvider glObjectsProvider, GlTextureInfo glTextureInfo, long j3) {
            Bitmap bitmapCreateBitmap;
            GlTextureInfo glTextureInfo2;
            n(glObjectsProvider, glTextureInfo.f40693d, glTextureInfo.f40694e);
            if (!this.f48185f) {
                try {
                    GlUtil.H(glTextureInfo.f40691b, glTextureInfo.f40693d, glTextureInfo.f40694e);
                    GlUtil.e();
                    GLES20.glReadPixels(0, 0, glTextureInfo.f40693d, glTextureInfo.f40694e, 6408, 5121, this.f48189j);
                    GlUtil.e();
                    bitmapCreateBitmap = Bitmap.createBitmap(glTextureInfo.f40693d, glTextureInfo.f40694e, Bitmap.Config.ARGB_8888);
                } catch (GlUtil.GlException e3) {
                    j(e3);
                    return;
                }
            } else {
                if (Util.f41609a < 34 || (glTextureInfo2 = this.f48187h) == null) {
                    j(ExoPlaybackException.f(new IllegalArgumentException(), -2));
                    return;
                }
                try {
                    GlUtil.H(glTextureInfo2.f40691b, glTextureInfo2.f40693d, glTextureInfo2.f40694e);
                    GlUtil.e();
                    ((GlProgram) Assertions.e(this.f48188i)).u();
                    this.f48188i.s("uTexSampler", glTextureInfo.f40690a, 0);
                    this.f48188i.e();
                    GLES20.glDrawArrays(6, 0, this.f48186g.size());
                    GlUtil.e();
                    GlTextureInfo glTextureInfo3 = this.f48187h;
                    GLES20.glReadPixels(0, 0, glTextureInfo3.f40693d, glTextureInfo3.f40694e, 6408, 33640, this.f48189j);
                    GlUtil.e();
                    GlTextureInfo glTextureInfo4 = this.f48187h;
                    bitmapCreateBitmap = Bitmap.createBitmap((DisplayMetrics) null, glTextureInfo4.f40693d, glTextureInfo4.f40694e, Bitmap.Config.RGBA_1010102, false, ColorSpace.get(ColorSpace.Named.BT2020_HLG));
                } catch (GlUtil.GlException e4) {
                    j(e4);
                    return;
                }
            }
            bitmapCreateBitmap.copyPixelsFromBuffer(this.f48189j);
            ((CallbackToFutureAdapter.Completer) Assertions.e((CallbackToFutureAdapter.Completer) ExperimentalFrameExtractor.this.f48175c.getAndSet(null))).c(new Frame(Util.t1(j3), bitmapCreateBitmap, null));
            f().e(glTextureInfo);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private final class PlayerListener implements AnalyticsListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ExperimentalFrameExtractor f48191a;

        @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
        public void L(AnalyticsListener.EventTime eventTime, int i3) {
            if (i3 != 3 || this.f48191a.f48174b.get()) {
                return;
            }
            ((CallbackToFutureAdapter.Completer) Assertions.e((CallbackToFutureAdapter.Completer) this.f48191a.f48175c.getAndSet(null))).c((Frame) Assertions.e(this.f48191a.f48176d));
        }

        @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
        public void i(AnalyticsListener.EventTime eventTime, PlaybackException playbackException) {
            CallbackToFutureAdapter.Completer completer = (CallbackToFutureAdapter.Completer) this.f48191a.f48175c.getAndSet(null);
            if (completer != null) {
                completer.f(playbackException);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(long j3, CallbackToFutureAdapter.Completer completer) {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        completer.a(new Runnable() { // from class: androidx.media3.transformer.o1
            @Override // java.lang.Runnable
            public final void run() {
                atomicBoolean.set(true);
            }
        }, MoreExecutors.a());
        if (atomicBoolean.get()) {
            return;
        }
        Throwable playbackException = this.f48173a.F() ? new PlaybackException("The player is already released", null, 1004) : this.f48173a.b();
        if (playbackException != null) {
            completer.f(playbackException);
        } else {
            if (this.f48173a.h() == null) {
                completer.f(new PlaybackException("Player has no current item. Call setMediaItem before getFrame.", null, -108));
                return;
            }
            Assertions.g(androidx.compose.animation.core.h.a(this.f48175c, null, completer));
            this.f48174b.set(false);
            this.f48173a.v(j3);
        }
    }
}
