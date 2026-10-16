package androidx.media3.transformer;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.MediaFormat;
import android.os.Handler;
import androidx.media3.common.ColorInfo;
import androidx.media3.common.Format;
import androidx.media3.common.Timeline;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.ConstantRateTimestampIterator;
import androidx.media3.common.util.TimestampIterator;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.ExoPlaybackException;
import androidx.media3.exoplayer.Renderer;
import androidx.media3.exoplayer.RenderersFactory;
import androidx.media3.exoplayer.audio.AudioRendererEventListener;
import androidx.media3.exoplayer.audio.AudioSink;
import androidx.media3.exoplayer.audio.MediaCodecAudioRenderer;
import androidx.media3.exoplayer.image.ImageDecoder;
import androidx.media3.exoplayer.image.ImageOutput;
import androidx.media3.exoplayer.image.ImageRenderer;
import androidx.media3.exoplayer.mediacodec.MediaCodecAdapter;
import androidx.media3.exoplayer.mediacodec.MediaCodecInfo;
import androidx.media3.exoplayer.mediacodec.MediaCodecSelector;
import androidx.media3.exoplayer.metadata.MetadataOutput;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.text.TextOutput;
import androidx.media3.exoplayer.video.MediaCodecVideoRenderer;
import androidx.media3.exoplayer.video.VideoRendererEventListener;
import androidx.media3.exoplayer.video.VideoSink;
import androidx.media3.transformer.SequenceRenderersFactory;
import com.facebook.ads.AdError;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class SequenceRenderersFactory implements RenderersFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f48432a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final EditedMediaItemSequence f48433b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final PlaybackAudioGraphWrapper f48434c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final VideoSink f48435d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ImageDecoder.Factory f48436e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f48437f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f48438g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final boolean f48439h;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class SequenceAudioRenderer extends MediaCodecAudioRenderer {
        private final EditedMediaItemSequence X0;
        private final AudioGraphInputAudioSink Y0;
        private final PlaybackAudioGraphWrapper Z0;

        /* JADX INFO: renamed from: a1, reason: collision with root package name */
        private EditedMediaItem f48440a1;

        /* JADX INFO: renamed from: b1, reason: collision with root package name */
        private long f48441b1;

        public SequenceAudioRenderer(Context context, Handler handler, AudioRendererEventListener audioRendererEventListener, EditedMediaItemSequence editedMediaItemSequence, AudioGraphInputAudioSink audioGraphInputAudioSink, PlaybackAudioGraphWrapper playbackAudioGraphWrapper) {
            super(context, MediaCodecSelector.f44322a, handler, audioRendererEventListener, audioGraphInputAudioSink);
            this.X0 = editedMediaItemSequence;
            this.Y0 = audioGraphInputAudioSink;
            this.Z0 = playbackAudioGraphWrapper;
        }

        private void r2() {
            EditedMediaItem editedMediaItem = (EditedMediaItem) Assertions.i(this.f48440a1);
            this.Y0.C(editedMediaItem, this.f48441b1, SequenceRenderersFactory.j(c0(), this.X0, editedMediaItem));
        }

        @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer, androidx.media3.exoplayer.Renderer
        public void h(long j3, long j4) throws ExoPlaybackException {
            super.h(j3, j4);
            do {
                try {
                } catch (AudioSink.ConfigurationException | AudioSink.InitializationException | AudioSink.WriteException | ExportException e3) {
                    throw S(e3, null, 5002);
                }
            } while (this.Z0.j());
        }

        @Override // androidx.media3.exoplayer.audio.MediaCodecAudioRenderer, androidx.media3.exoplayer.mediacodec.MediaCodecRenderer, androidx.media3.exoplayer.BaseRenderer
        protected void h0(long j3, boolean z2) throws ExoPlaybackException {
            super.h0(j3, z2);
            r2();
        }

        @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer, androidx.media3.exoplayer.BaseRenderer
        protected void n0(Format[] formatArr, long j3, long j4, MediaSource.MediaPeriodId mediaPeriodId) {
            Assertions.g(c0().p() == 1);
            int iB = c0().b(mediaPeriodId.f44754a);
            this.f48440a1 = SequenceRenderersFactory.i(this.X0, iB);
            this.f48441b1 = SequenceRenderersFactory.h(this.X0, iB, j4);
            super.n0(formatArr, j3, j4, mediaPeriodId);
        }

        @Override // androidx.media3.exoplayer.audio.MediaCodecAudioRenderer, androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
        protected void w1() {
            super.w1();
            r2();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private final class SequenceVideoRenderer extends MediaCodecVideoRenderer {
        private final boolean A1;
        private ImmutableList B1;
        private EditedMediaItem C1;
        private long D1;

        /* JADX INFO: renamed from: y1, reason: collision with root package name */
        private final EditedMediaItemSequence f48442y1;

        /* JADX INFO: renamed from: z1, reason: collision with root package name */
        private final BufferingVideoSink f48443z1;

        public SequenceVideoRenderer(Context context, Handler handler, VideoRendererEventListener videoRendererEventListener, EditedMediaItemSequence editedMediaItemSequence, BufferingVideoSink bufferingVideoSink, boolean z2) {
            super(new MediaCodecVideoRenderer.Builder(context).w(MediaCodecSelector.f44322a).r(MediaCodecAdapter.Factory.a(context)).p(5000L).s(false).t(handler).u(videoRendererEventListener).v(50).q(30.0f).x(bufferingVideoSink));
            this.f48442y1 = editedMediaItemSequence;
            this.f48443z1 = bufferingVideoSink;
            this.A1 = z2;
            this.B1 = ImmutableList.y();
            I0();
        }

        private void j3() {
            if (this.f48443z1.P() != null) {
                return;
            }
            VideoSink videoSink = (VideoSink) Assertions.e(SequenceRenderersFactory.this.f48435d);
            this.f48443z1.Q(videoSink);
            MediaCodecAdapter mediaCodecAdapterO0 = O0();
            if (!SequenceRenderersFactory.this.k() || !videoSink.isInitialized() || mediaCodecAdapterO0 == null || j2(((MediaCodecInfo) Assertions.e(Q0())).f44264a)) {
                return;
            }
            U2(mediaCodecAdapterO0, videoSink.a());
        }

        private void k3() {
            if (SequenceRenderersFactory.this.k()) {
                this.f48443z1.Q(null);
                this.f48443z1.M();
                MediaCodecAdapter mediaCodecAdapterO0 = O0();
                if (mediaCodecAdapterO0 == null) {
                    return;
                }
                if (j2(((MediaCodecInfo) Assertions.e(Q0())).f44264a)) {
                    E1();
                } else {
                    U2(mediaCodecAdapterO0, this.f48443z1.a());
                }
            }
        }

        @Override // androidx.media3.exoplayer.video.MediaCodecVideoRenderer, androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
        protected void F1() {
            super.F1();
            if (SequenceRenderersFactory.j(c0(), this.f48442y1, (EditedMediaItem) Assertions.e(this.C1))) {
                this.f48443z1.d();
            }
        }

        @Override // androidx.media3.exoplayer.video.MediaCodecVideoRenderer, androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
        protected boolean R1(MediaCodecInfo mediaCodecInfo) {
            if (SequenceRenderersFactory.this.k() && this.f48443z1.P() == null && j2(mediaCodecInfo.f44264a)) {
                return false;
            }
            return super.R1(mediaCodecInfo);
        }

        @Override // androidx.media3.exoplayer.video.MediaCodecVideoRenderer, androidx.media3.exoplayer.mediacodec.MediaCodecRenderer, androidx.media3.exoplayer.BaseRenderer
        protected void e0() {
            super.e0();
            k3();
        }

        @Override // androidx.media3.exoplayer.video.MediaCodecVideoRenderer, androidx.media3.exoplayer.mediacodec.MediaCodecRenderer, androidx.media3.exoplayer.BaseRenderer
        protected void f0(boolean z2, boolean z3) {
            if (z3) {
                j3();
            }
            super.f0(z2, z3);
        }

        @Override // androidx.media3.exoplayer.video.MediaCodecVideoRenderer
        protected void i2(VideoSink videoSink, int i3, Format format) {
            videoSink.q(i3, format, this.B1);
        }

        @Override // androidx.media3.exoplayer.video.MediaCodecVideoRenderer, androidx.media3.exoplayer.mediacodec.MediaCodecRenderer, androidx.media3.exoplayer.BaseRenderer
        protected void l0() {
            j3();
            super.l0();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.media3.exoplayer.video.MediaCodecVideoRenderer, androidx.media3.exoplayer.mediacodec.MediaCodecRenderer, androidx.media3.exoplayer.BaseRenderer
        protected void n0(Format[] formatArr, long j3, long j4, MediaSource.MediaPeriodId mediaPeriodId) {
            Assertions.g(c0().p() == 1);
            int iB = c0().b(mediaPeriodId.f44754a);
            this.C1 = SequenceRenderersFactory.i(this.f48442y1, iB);
            this.D1 = SequenceRenderersFactory.h(this.f48442y1, iB, j4);
            this.B1 = ((EditedMediaItem) this.f48442y1.f48110a.get(iB)).f48101g.f48127b;
            super.n0(formatArr, j3, j4, mediaPeriodId);
        }

        @Override // androidx.media3.exoplayer.video.MediaCodecVideoRenderer
        protected long o2() {
            return this.D1;
        }

        @Override // androidx.media3.exoplayer.video.MediaCodecVideoRenderer
        protected MediaFormat v2(Format format, String str, MediaCodecVideoRenderer.CodecMaxValues codecMaxValues, float f3, boolean z2, int i3) {
            MediaFormat mediaFormatV2 = super.v2(format, str, codecMaxValues, f3, z2, i3);
            if (this.A1 && Util.f41609a >= 31) {
                mediaFormatV2.setInteger("color-transfer-request", 3);
            }
            return mediaFormatV2;
        }

        @Override // androidx.media3.exoplayer.video.MediaCodecVideoRenderer, androidx.media3.exoplayer.mediacodec.MediaCodecRenderer, androidx.media3.exoplayer.BaseRenderer, androidx.media3.exoplayer.PlayerMessage.Target
        public void w(int i3, Object obj) throws ExoPlaybackException {
            if (i3 == 17) {
                return;
            }
            super.w(i3, obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static long h(EditedMediaItemSequence editedMediaItemSequence, int i3, long j3) {
        long jC = -j3;
        if (i3 == 0) {
            jC -= ((EditedMediaItem) editedMediaItemSequence.f48110a.get(0)).f48095a.f40718f.f40747b;
        }
        for (int i4 = 0; i4 < i3; i4++) {
            jC += i(editedMediaItemSequence, i4).c();
        }
        return jC;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static EditedMediaItem i(EditedMediaItemSequence editedMediaItemSequence, int i3) {
        if (editedMediaItemSequence.f48111b) {
            i3 %= editedMediaItemSequence.f48110a.size();
        }
        return (EditedMediaItem) editedMediaItemSequence.f48110a.get(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean j(Timeline timeline, EditedMediaItemSequence editedMediaItemSequence, EditedMediaItem editedMediaItem) {
        return editedMediaItem == i(editedMediaItemSequence, timeline.i() - 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean k() {
        return this.f48439h && Util.f41609a >= 23;
    }

    @Override // androidx.media3.exoplayer.RenderersFactory
    public Renderer a(Renderer renderer, Handler handler, VideoRendererEventListener videoRendererEventListener, AudioRendererEventListener audioRendererEventListener, TextOutput textOutput, MetadataOutput metadataOutput) {
        if (!k() || !(renderer instanceof SequenceVideoRenderer)) {
            return null;
        }
        Context context = this.f48432a;
        return new SequenceVideoRenderer(context, handler, videoRendererEventListener, this.f48433b, new BufferingVideoSink(context), this.f48438g);
    }

    @Override // androidx.media3.exoplayer.RenderersFactory
    public Renderer[] b(Handler handler, VideoRendererEventListener videoRendererEventListener, AudioRendererEventListener audioRendererEventListener, TextOutput textOutput, MetadataOutput metadataOutput) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new SequenceAudioRenderer(this.f48432a, handler, audioRendererEventListener, this.f48433b, this.f48434c.g(this.f48437f), this.f48434c));
        if (this.f48435d != null) {
            Context context = this.f48432a;
            arrayList.add(new SequenceVideoRenderer(context, handler, videoRendererEventListener, this.f48433b, new BufferingVideoSink(context), this.f48438g));
            arrayList.add(new SequenceImageRenderer(this.f48433b, (ImageDecoder.Factory) Assertions.i(this.f48436e), this.f48435d));
        }
        return (Renderer[]) arrayList.toArray(new Renderer[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class SequenceImageRenderer extends ImageRenderer {
        private final EditedMediaItemSequence M;
        private final VideoSink N;
        private ImmutableList O;
        private ConstantRateTimestampIterator P;
        private EditedMediaItem Q;
        private ExoPlaybackException R;
        private boolean S;
        private long T;
        private boolean U;
        private long V;

        public SequenceImageRenderer(EditedMediaItemSequence editedMediaItemSequence, ImageDecoder.Factory factory, VideoSink videoSink) {
            super(factory, ImageOutput.f44158a);
            this.M = editedMediaItemSequence;
            this.N = videoSink;
            this.O = ImmutableList.y();
            this.T = -9223372036854775807L;
        }

        private ConstantRateTimestampIterator I0(long j3) {
            long jB0 = b0();
            long j4 = this.V + jB0;
            return new ConstantRateTimestampIterator(j4 + (j3 - jB0), j4 + ((EditedMediaItem) Assertions.e(this.Q)).c(), 30.0f);
        }

        @Override // androidx.media3.exoplayer.image.ImageRenderer
        protected boolean B0() throws ExoPlaybackException {
            if (this.N.isInitialized()) {
                return true;
            }
            Format formatN = new Format.Builder().N();
            try {
                return this.N.n(formatN);
            } catch (VideoSink.VideoSinkException e3) {
                throw S(e3, formatN, 7000);
            }
        }

        @Override // androidx.media3.exoplayer.image.ImageRenderer
        protected boolean D0(long j3, long j4, Bitmap bitmap, long j5) {
            if (this.S) {
                Assertions.g(this.T != -9223372036854775807L);
                this.N.i(this.T, this.V);
                this.N.q(2, new Format.Builder().u0("image/raw").B0(bitmap.getWidth()).d0(bitmap.getHeight()).T(ColorInfo.f40547i).b0(30.0f).N(), this.O);
                this.S = false;
            }
            if (!this.N.y(bitmap, (TimestampIterator) Assertions.i(this.P))) {
                return false;
            }
            this.N.c();
            if (SequenceRenderersFactory.j(c0(), this.M, (EditedMediaItem) Assertions.e(this.Q))) {
                this.N.d();
            }
            return true;
        }

        @Override // androidx.media3.exoplayer.image.ImageRenderer, androidx.media3.exoplayer.Renderer
        public boolean b() {
            if (!super.b() || !this.N.b()) {
                return false;
            }
            ConstantRateTimestampIterator constantRateTimestampIterator = this.P;
            return constantRateTimestampIterator == null || !constantRateTimestampIterator.hasNext();
        }

        @Override // androidx.media3.exoplayer.image.ImageRenderer, androidx.media3.exoplayer.BaseRenderer
        protected void e0() {
            super.e0();
            this.N.s();
        }

        @Override // androidx.media3.exoplayer.image.ImageRenderer, androidx.media3.exoplayer.BaseRenderer
        protected void f0(boolean z2, boolean z3) {
            super.f0(z2, z3);
            this.U = z3;
            this.N.o(z3);
            this.N.B(VideoSink.Listener.f45879a, new Executor() { // from class: androidx.media3.transformer.y1
                @Override // java.util.concurrent.Executor
                public final void execute(Runnable runnable) {
                    SequenceRenderersFactory.SequenceImageRenderer.H0(runnable);
                }
            });
        }

        @Override // androidx.media3.exoplayer.image.ImageRenderer, androidx.media3.exoplayer.Renderer
        public void h(long j3, long j4) throws ExoPlaybackException {
            ExoPlaybackException exoPlaybackException = this.R;
            if (exoPlaybackException != null) {
                this.R = null;
                throw exoPlaybackException;
            }
            super.h(j3, j4);
            try {
                this.N.h(j3, j4);
            } catch (VideoSink.VideoSinkException e3) {
                throw S(e3, e3.f45880a, AdError.SHOW_CALLED_BEFORE_LOAD_ERROR_CODE);
            }
        }

        @Override // androidx.media3.exoplayer.image.ImageRenderer, androidx.media3.exoplayer.BaseRenderer
        protected void h0(long j3, boolean z2) {
            if (!z2) {
                this.N.x(true);
                this.P = I0(j3);
            }
            super.h0(j3, z2);
        }

        @Override // androidx.media3.exoplayer.image.ImageRenderer, androidx.media3.exoplayer.Renderer
        public boolean isReady() {
            return this.U ? this.N.m(super.isReady()) : super.isReady();
        }

        @Override // androidx.media3.exoplayer.image.ImageRenderer, androidx.media3.exoplayer.BaseRenderer
        protected void k0() {
            super.k0();
            this.R = null;
        }

        @Override // androidx.media3.exoplayer.BaseRenderer
        protected void l0() {
            super.l0();
            this.N.p();
        }

        @Override // androidx.media3.exoplayer.BaseRenderer
        protected void m0() {
            super.m0();
            this.N.j();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.media3.exoplayer.image.ImageRenderer, androidx.media3.exoplayer.BaseRenderer
        protected void n0(Format[] formatArr, long j3, long j4, MediaSource.MediaPeriodId mediaPeriodId) {
            Assertions.g(c0().p() == 1);
            this.T = j3;
            int iB = c0().b(mediaPeriodId.f44754a);
            this.Q = (EditedMediaItem) this.M.f48110a.get(iB);
            this.V = SequenceRenderersFactory.h(this.M, iB, j4);
            this.P = I0(j3);
            this.O = this.Q.f48101g.f48127b;
            this.S = true;
            super.n0(formatArr, j3, j4, mediaPeriodId);
        }

        @Override // androidx.media3.exoplayer.image.ImageRenderer, androidx.media3.exoplayer.BaseRenderer, androidx.media3.exoplayer.PlayerMessage.Target
        public void w(int i3, Object obj) {
            if (i3 == 11) {
                this.N.k((Renderer.WakeupListener) Assertions.e(obj));
            } else {
                super.w(i3, obj);
            }
        }

        public static /* synthetic */ void H0(Runnable runnable) {
        }
    }
}
