package androidx.media3.transformer;

import android.content.Context;
import android.media.MediaCodec;
import android.util.Pair;
import androidx.media3.common.ColorInfo;
import androidx.media3.common.DebugViewProvider;
import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.SurfaceInfo;
import androidx.media3.common.VideoCompositorSettings;
import androidx.media3.common.VideoFrameProcessingException;
import androidx.media3.common.VideoFrameProcessor;
import androidx.media3.common.VideoGraph;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Consumer;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.transformer.Codec;
import androidx.media3.transformer.TransformationRequest;
import androidx.media3.transformer.TransformerMultipleInputVideoGraph;
import androidx.media3.transformer.TransformerSingleInputVideoGraph;
import androidx.media3.transformer.TransformerVideoGraph;
import com.google.common.util.concurrent.MoreExecutors;
import com.revenuecat.purchases.ui.revenuecatui.components.SensibleDefaults;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class VideoSampleExporter extends SampleExporter {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final VideoGraphWrapper f48620e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final EncoderWrapper f48621f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final DecoderInputBuffer f48622g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final long f48623h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private volatile long f48624i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private long f48625j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f48626k;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class EncoderWrapper {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Codec.EncoderFactory f48627a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Format f48628b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final boolean f48629c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final List f48630d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final TransformationRequest f48631e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final FallbackListener f48632f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final String f48633g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final int f48634h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private SurfaceInfo f48635i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private volatile Codec f48636j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private volatile int f48637k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private volatile boolean f48638l;

        public EncoderWrapper(Codec.EncoderFactory encoderFactory, Format format, boolean z2, List list, TransformationRequest transformationRequest, FallbackListener fallbackListener) {
            Assertions.a(format.C != null);
            this.f48627a = encoderFactory;
            this.f48628b = format;
            this.f48629c = z2;
            this.f48630d = list;
            this.f48631e = transformationRequest;
            this.f48632f = fallbackListener;
            Pair pairF = f(format, transformationRequest);
            this.f48633g = (String) pairF.first;
            this.f48634h = ((Integer) pairF.second).intValue();
        }

        private static TransformationRequest a(TransformationRequest transformationRequest, boolean z2, Format format, Format format2, int i3) {
            TransformationRequest.Builder builderA = transformationRequest.a();
            if (transformationRequest.f48473d != i3) {
                builderA.c(i3);
            }
            if (!Objects.equals(format.f40632o, format2.f40632o)) {
                builderA.e(format2.f40632o);
            }
            if (z2) {
                int i4 = format.f40639v;
                int i5 = format2.f40639v;
                if (i4 != i5) {
                    builderA.d(i5);
                }
            } else {
                int i6 = format.f40640w;
                int i7 = format2.f40640w;
                if (i6 != i7) {
                    builderA.d(i7);
                }
            }
            return builderA.a();
        }

        private static Pair f(Format format, TransformationRequest transformationRequest) {
            String str = (String) Assertions.e(format.f40632o);
            String str2 = transformationRequest.f48472c;
            if (str2 != null) {
                str = str2;
            } else if (MimeTypes.o(str)) {
                str = "video/hevc";
            }
            return TransformerUtil.f(transformationRequest.f48473d, str, format.C);
        }

        private ColorInfo g() {
            return (!ColorInfo.l(this.f48628b.C) || this.f48634h == 0) ? ColorInfo.f40547i.equals(this.f48628b.C) ? ColorInfo.f40546h : (ColorInfo) Assertions.e(this.f48628b.C) : ColorInfo.f40546h;
        }

        public int b() {
            return this.f48634h;
        }

        public ByteBuffer c() {
            if (this.f48636j != null) {
                return this.f48636j.j();
            }
            return null;
        }

        public MediaCodec.BufferInfo d() {
            if (this.f48636j != null) {
                return this.f48636j.g();
            }
            return null;
        }

        public Format e() {
            if (this.f48636j == null) {
                return null;
            }
            Format formatC = this.f48636j.c();
            return (formatC == null || this.f48637k == 0) ? formatC : formatC.b().t0(this.f48637k).N();
        }

        public SurfaceInfo h(int i3, int i4) {
            if (this.f48638l) {
                return null;
            }
            SurfaceInfo surfaceInfo = this.f48635i;
            if (surfaceInfo != null) {
                return surfaceInfo;
            }
            if (i3 < i4 && !this.f48629c) {
                this.f48637k = 90;
                i4 = i3;
                i3 = i4;
            }
            if (this.f48628b.f40642y % SensibleDefaults.X_OFFSET == this.f48637k % SensibleDefaults.X_OFFSET) {
                this.f48637k = this.f48628b.f40642y;
            }
            Format formatN = new Format.Builder().B0(i3).d0(i4).t0(0).b0(this.f48628b.f40641x).u0(this.f48633g).T(g()).S(this.f48628b.f40628k).N();
            this.f48636j = this.f48627a.c(formatN.b().u0(SampleExporter.k(formatN, this.f48630d)).N());
            Format formatM = this.f48636j.m();
            this.f48632f.c(a(this.f48631e, this.f48637k != 0, formatN, formatM, this.f48634h));
            this.f48635i = new SurfaceInfo(this.f48636j.a(), formatM.f40639v, formatM.f40640w, this.f48637k, true);
            if (this.f48638l) {
                this.f48636j.release();
            }
            return this.f48635i;
        }

        public boolean i() {
            return this.f48636j != null && this.f48636j.b();
        }

        public void j() {
            if (this.f48636j != null) {
                this.f48636j.release();
            }
            this.f48638l = true;
        }

        public void k(boolean z2) {
            if (this.f48636j != null) {
                this.f48636j.h(z2);
            }
        }

        public void l() {
            if (this.f48636j != null) {
                this.f48636j.i();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private final class VideoGraphWrapper implements TransformerVideoGraph, VideoGraph.Listener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final TransformerVideoGraph f48639a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Consumer f48640b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f48641c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final boolean f48642d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final Object f48643e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f48644f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f48645g;

        public VideoGraphWrapper(Context context, TransformerVideoGraph.Factory factory, ColorInfo colorInfo, Consumer consumer, DebugViewProvider debugViewProvider, VideoCompositorSettings videoCompositorSettings, List list, int i3) {
            this.f48640b = consumer;
            this.f48641c = i3;
            boolean z2 = i3 < 1;
            this.f48642d = z2;
            this.f48643e = new Object();
            this.f48639a = factory.a(context, colorInfo, debugViewProvider, this, MoreExecutors.a(), videoCompositorSettings, list, VideoSampleExporter.this.f48623h, z2);
        }

        private void n() {
            boolean z2;
            int i3;
            synchronized (this.f48643e) {
                try {
                    int i4 = this.f48645g;
                    if (i4 <= 0 || (i3 = this.f48644f) >= this.f48641c) {
                        z2 = false;
                    } else {
                        z2 = true;
                        this.f48644f = i3 + 1;
                        this.f48645g = i4 - 1;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (z2) {
                g();
            }
        }

        @Override // androidx.media3.common.VideoGraph.Listener
        public void a(VideoFrameProcessingException videoFrameProcessingException) {
            this.f48640b.accept(ExportException.f(videoFrameProcessingException));
        }

        @Override // androidx.media3.common.VideoGraph.Listener
        public void c(long j3) {
            if (this.f48642d) {
                return;
            }
            synchronized (this.f48643e) {
                this.f48645g++;
            }
            n();
        }

        @Override // androidx.media3.common.VideoGraph.Listener
        public void d(int i3, int i4) {
            SurfaceInfo surfaceInfoH;
            try {
                surfaceInfoH = VideoSampleExporter.this.f48621f.h(i3, i4);
            } catch (ExportException e3) {
                this.f48640b.accept(e3);
                surfaceInfoH = null;
            }
            f(surfaceInfoH);
        }

        @Override // androidx.media3.common.VideoGraph
        public void f(SurfaceInfo surfaceInfo) {
            this.f48639a.f(surfaceInfo);
        }

        @Override // androidx.media3.transformer.TransformerVideoGraph
        public void g() {
            this.f48639a.g();
        }

        @Override // androidx.media3.transformer.TransformerVideoGraph
        public GraphInput i(int i3) {
            return this.f48639a.i(i3);
        }

        @Override // androidx.media3.common.VideoGraph
        public void initialize() {
            this.f48639a.initialize();
        }

        @Override // androidx.media3.common.VideoGraph
        public boolean j() {
            return this.f48639a.j();
        }

        @Override // androidx.media3.common.VideoGraph.Listener
        public void k(long j3) {
            VideoSampleExporter.this.f48624i = j3;
            try {
                VideoSampleExporter.this.f48621f.l();
            } catch (ExportException e3) {
                this.f48640b.accept(e3);
            }
        }

        public boolean m() {
            boolean z2 = false;
            if (this.f48642d) {
                return false;
            }
            boolean z3 = VideoSampleExporter.this.f48624i != -9223372036854775807L;
            synchronized (this.f48643e) {
                if (this.f48644f == 0 && z3) {
                    z2 = true;
                }
            }
            return z2;
        }

        public void o() {
            if (this.f48642d) {
                return;
            }
            synchronized (this.f48643e) {
                Assertions.g(this.f48644f > 0);
                this.f48644f--;
            }
            n();
        }

        @Override // androidx.media3.common.VideoGraph
        public void release() {
            this.f48639a.release();
        }
    }

    public VideoSampleExporter(Context context, Format format, TransformationRequest transformationRequest, VideoCompositorSettings videoCompositorSettings, List list, VideoFrameProcessor.Factory factory, Codec.EncoderFactory encoderFactory, MuxerWrapper muxerWrapper, Consumer consumer, FallbackListener fallbackListener, DebugViewProvider debugViewProvider, long j3, boolean z2, boolean z3, int i3) throws ExportException {
        super(format, muxerWrapper);
        this.f48623h = j3;
        this.f48624i = -9223372036854775807L;
        this.f48625j = -9223372036854775807L;
        ColorInfo colorInfo = (ColorInfo) Assertions.e(format.C);
        ColorInfo colorInfoA = colorInfo.f40556c == 2 ? Objects.equals(format.f40632o, "image/jpeg_r") ? new ColorInfo.Builder().d(6).e(7).c(1).a() : ColorInfo.f40546h : colorInfo;
        EncoderWrapper encoderWrapper = new EncoderWrapper(encoderFactory, format.b().T(colorInfoA).N(), z3, muxerWrapper.i(2), transformationRequest, fallbackListener);
        this.f48621f = encoderWrapper;
        this.f48622g = new DecoderInputBuffer(0);
        if (encoderWrapper.b() == 2 && ColorInfo.l(colorInfo)) {
            colorInfoA = ColorInfo.f40546h;
        }
        try {
            VideoGraphWrapper videoGraphWrapper = new VideoGraphWrapper(context, z2 ? new TransformerMultipleInputVideoGraph.Factory(factory) : new TransformerSingleInputVideoGraph.Factory(factory), colorInfoA, consumer, debugViewProvider, videoCompositorSettings, list, i3);
            this.f48620e = videoGraphWrapper;
            videoGraphWrapper.initialize();
        } catch (VideoFrameProcessingException e3) {
            throw ExportException.f(e3);
        }
    }

    @Override // androidx.media3.transformer.SampleExporter
    public GraphInput l(EditedMediaItem editedMediaItem, Format format, int i3) throws ExportException {
        try {
            return this.f48620e.i(i3);
        } catch (VideoFrameProcessingException e3) {
            throw ExportException.f(e3);
        }
    }

    @Override // androidx.media3.transformer.SampleExporter
    protected DecoderInputBuffer m() {
        this.f48622g.f42138d = this.f48621f.c();
        if (this.f48622g.f42138d == null) {
            return null;
        }
        MediaCodec.BufferInfo bufferInfo = (MediaCodec.BufferInfo) Assertions.e(this.f48621f.d());
        if (bufferInfo.presentationTimeUs == 0 && this.f48620e.j() == this.f48626k && this.f48624i != -9223372036854775807L && bufferInfo.size > 0) {
            bufferInfo.presentationTimeUs = this.f48624i;
        }
        DecoderInputBuffer decoderInputBuffer = this.f48622g;
        decoderInputBuffer.f42140g = bufferInfo.presentationTimeUs;
        decoderInputBuffer.n(bufferInfo.flags);
        this.f48625j = bufferInfo.presentationTimeUs;
        return this.f48622g;
    }

    @Override // androidx.media3.transformer.SampleExporter
    protected Format n() {
        return this.f48621f.e();
    }

    @Override // androidx.media3.transformer.SampleExporter
    protected boolean o() {
        return this.f48621f.i() || this.f48620e.m();
    }

    @Override // androidx.media3.transformer.SampleExporter
    public void r() {
        this.f48620e.release();
        this.f48621f.j();
    }

    @Override // androidx.media3.transformer.SampleExporter
    protected void s() {
        if (this.f48625j == 0) {
            this.f48626k = true;
        }
        this.f48621f.k(false);
        this.f48620e.o();
    }
}
