package androidx.media3.transformer;

import android.content.Context;
import android.os.Looper;
import androidx.media3.common.DebugViewProvider;
import androidx.media3.common.FlagSet;
import androidx.media3.common.Format;
import androidx.media3.common.MediaItem;
import androidx.media3.common.MediaLibraryInfo;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.VideoFrameProcessor;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Clock;
import androidx.media3.common.util.HandlerWrapper;
import androidx.media3.common.util.ListenerSet;
import androidx.media3.common.util.Util;
import androidx.media3.effect.DebugTraceUtil;
import androidx.media3.effect.DefaultVideoFrameProcessor;
import androidx.media3.transformer.AssetLoader;
import androidx.media3.transformer.AudioMixer;
import androidx.media3.transformer.Codec;
import androidx.media3.transformer.Composition;
import androidx.media3.transformer.DefaultAudioMixer;
import androidx.media3.transformer.DefaultDecoderFactory;
import androidx.media3.transformer.DefaultEncoderFactory;
import androidx.media3.transformer.DefaultMuxer;
import androidx.media3.transformer.EditedMediaItemSequence;
import androidx.media3.transformer.EditingMetricsCollector;
import androidx.media3.transformer.ExportResult;
import androidx.media3.transformer.InAppFragmentedMp4Muxer;
import androidx.media3.transformer.InAppMp4Muxer;
import androidx.media3.transformer.Muxer;
import androidx.media3.transformer.MuxerWrapper;
import androidx.media3.transformer.TransformationRequest;
import androidx.media3.transformer.Transformer;
import androidx.media3.transformer.TransformerInternal;
import androidx.media3.transformer.TransmuxTranscodeHelper;
import androidx.media3.transformer.WatchdogTimer;
import com.facebook.ads.AdError;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.File;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class Transformer {
    public static final long L;
    private MuxerWrapper A;
    private Composition B;
    private String C;
    private String D;
    private int E;
    private TransmuxTranscodeHelper.ResumeMetadata F;
    private ListenableFuture G;
    private EditingMetricsCollector H;
    private ListenableFuture I;
    private Mp4Info J;
    private WatchdogTimer K;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f48478a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final TransformationRequest f48479b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ImmutableList f48480c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ImmutableList f48481d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f48482e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f48483f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f48484g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final boolean f48485h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final boolean f48486i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final boolean f48487j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final long f48488k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final int f48489l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final ListenerSet f48490m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final AssetLoader.Factory f48491n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final AudioMixer.Factory f48492o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final VideoFrameProcessor.Factory f48493p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final Codec.EncoderFactory f48494q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final Muxer.Factory f48495r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final Looper f48496s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final DebugViewProvider f48497t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final Clock f48498u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final HandlerWrapper f48499v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final ComponentListener f48500w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final ExportResult.Builder f48501x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final EditingMetricsCollector.MetricsReporter.Factory f48502y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private TransformerInternal f48503z;

    /* JADX INFO: renamed from: androidx.media3.transformer.Transformer$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass1 implements FutureCallback<TransmuxTranscodeHelper.ResumeMetadata> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Transformer f48504a;

        @Override // com.google.common.util.concurrent.FutureCallback
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(TransmuxTranscodeHelper.ResumeMetadata resumeMetadata) {
            long j3 = resumeMetadata.f48594a;
            if (j3 == -9223372036854775807L || j3 == 0) {
                this.f48504a.T();
                return;
            }
            this.f48504a.F = resumeMetadata;
            this.f48504a.A = new MuxerWrapper((String) Assertions.e(this.f48504a.C), this.f48504a.f48495r, this.f48504a.f48500w, 1, false, resumeMetadata.f48596c);
            Transformer transformer = this.f48504a;
            transformer.a0(TransmuxTranscodeHelper.f(transformer.D, resumeMetadata.f48594a), (MuxerWrapper) Assertions.e(this.f48504a.A), this.f48504a.f48500w, 0L, true);
        }

        @Override // com.google.common.util.concurrent.FutureCallback
        public void onFailure(Throwable th) {
            this.f48504a.T();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private final class ComponentListener implements TransformerInternal.Listener, MuxerWrapper.Listener {
        private ComponentListener() {
        }

        @Override // androidx.media3.transformer.MuxerWrapper.Listener
        public void a(int i3, Format format, int i4, int i5) {
            if (i3 == 1) {
                Transformer.this.f48501x.e(format.f40632o).f(i4);
                if (format.E != -1) {
                    Transformer.this.f48501x.h(format.E);
                }
                if (format.F != -1) {
                    Transformer.this.f48501x.o(format.F);
                    return;
                }
                return;
            }
            if (i3 == 2) {
                Transformer.this.f48501x.r(format.f40632o).g(i4).i(format.C).q(i5);
                if (format.f40640w != -1) {
                    Transformer.this.f48501x.m(format.f40640w);
                }
                if (format.f40639v != -1) {
                    Transformer.this.f48501x.s(format.f40639v);
                }
            }
        }

        @Override // androidx.media3.transformer.MuxerWrapper.Listener
        public void b() {
            if (Transformer.this.K != null) {
                Transformer.this.K.b();
            } else {
                Assertions.g(Transformer.this.f48488k == -9223372036854775807L);
            }
        }

        @Override // androidx.media3.transformer.TransformerInternal.Listener
        public void c(ImmutableList immutableList, String str, String str2) {
            Transformer.this.f48501x.a(immutableList);
            if (str != null) {
                Transformer.this.f48501x.d(str);
            }
            if (str2 != null) {
                Transformer.this.f48501x.p(str2);
            }
            Transformer.this.f48503z = null;
            if (Transformer.this.E == 1) {
                Transformer.this.V();
                return;
            }
            if (Transformer.this.E == 2) {
                Transformer.this.A = null;
                Transformer.this.S();
                return;
            }
            if (Transformer.this.E == 3) {
                Transformer.this.H();
                return;
            }
            if (Transformer.this.E == 5) {
                Transformer.this.W();
            } else {
                if (Transformer.this.E != 6) {
                    Transformer.this.R();
                    return;
                }
                Transformer.this.J = null;
                Transformer.this.f48501x.n(1);
                Transformer.this.R();
            }
        }

        @Override // androidx.media3.transformer.TransformerInternal.Listener
        public void d(ImmutableList immutableList, String str, String str2, ExportException exportException) {
            if (exportException.f48193a == 7003 && (Transformer.this.M() || Transformer.this.L())) {
                Transformer.this.A = null;
                Transformer.this.f48503z = null;
                Transformer.this.f48501x.c();
                Transformer.this.f48501x.n(6);
                Transformer.this.T();
                return;
            }
            Transformer.this.f48501x.a(immutableList);
            if (str != null) {
                Transformer.this.f48501x.d(str);
            }
            if (str2 != null) {
                Transformer.this.f48501x.p(str2);
            }
            Transformer.this.f48501x.k(exportException);
            Transformer.this.Q(exportException);
            Transformer.this.f48503z = null;
        }

        @Override // androidx.media3.transformer.MuxerWrapper.Listener
        public void e(long j3, long j4) {
            Transformer.this.f48501x.j(j3).l(j4);
            ((TransformerInternal) Assertions.e(Transformer.this.f48503z)).z();
        }

        /* synthetic */ ComponentListener(Transformer transformer, AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface ProgressState {
    }

    static {
        MediaLibraryInfo.a("media3.transformer");
        L = Util.G0() ? 25000L : 10000L;
    }

    /* synthetic */ Transformer(Context context, TransformationRequest transformationRequest, ImmutableList immutableList, ImmutableList immutableList2, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, long j3, int i3, ListenerSet listenerSet, AssetLoader.Factory factory, AudioMixer.Factory factory2, VideoFrameProcessor.Factory factory3, Codec.EncoderFactory encoderFactory, Muxer.Factory factory4, Looper looper, DebugViewProvider debugViewProvider, Clock clock, EditingMetricsCollector.MetricsReporter.Factory factory5, AnonymousClass1 anonymousClass1) {
        this(context, transformationRequest, immutableList, immutableList2, z2, z3, z4, z5, z6, z7, j3, i3, listenerSet, factory, factory2, factory3, encoderFactory, factory4, looper, debugViewProvider, clock, factory5);
    }

    private boolean F() {
        return Util.f41609a >= 35 && this.f48487j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H() {
        this.E = 4;
        ListenableFuture listenableFutureD = TransmuxTranscodeHelper.d(new File((String) Assertions.e(this.D)), new File((String) Assertions.e(this.C)));
        this.I = listenableFutureD;
        FutureCallback<Void> futureCallback = new FutureCallback<Void>() { // from class: androidx.media3.transformer.Transformer.2
            @Override // com.google.common.util.concurrent.FutureCallback
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(Void r12) {
                Transformer.this.R();
            }

            @Override // com.google.common.util.concurrent.FutureCallback
            public void onFailure(Throwable th) {
                Transformer.this.Q(ExportException.e(new IOException("Copy output task failed for the resumed export", th)));
            }
        };
        HandlerWrapper handlerWrapper = this.f48499v;
        Objects.requireNonNull(handlerWrapper);
        Futures.a(listenableFutureD, futureCallback, new androidx.media3.exoplayer.video.f(handlerWrapper));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private int J(ProgressHolder progressHolder) {
        int iC;
        if (this.J == null) {
            return 1;
        }
        long j3 = ((EditedMediaItem) ((EditedMediaItemSequence) ((Composition) Assertions.e(this.B)).f47968a.get(0)).f48110a.get(0)).f48095a.f40718f.f40747b;
        Mp4Info mp4Info = this.J;
        float f3 = (mp4Info.f48300d - j3) / mp4Info.f48297a;
        if (this.E == 5) {
            TransformerInternal transformerInternal = this.f48503z;
            if (transformerInternal == null || (iC = transformerInternal.C(progressHolder)) == 0 || iC == 1) {
                return 1;
            }
            if (iC == 2) {
                progressHolder.f48349a = Math.round(progressHolder.f48349a * f3);
                return 2;
            }
            if (iC == 3) {
                return 3;
            }
            throw new IllegalStateException();
        }
        float f4 = 100.0f * f3;
        TransformerInternal transformerInternal2 = this.f48503z;
        if (transformerInternal2 == null) {
            progressHolder.f48349a = Math.round(f4);
            return 2;
        }
        int iC2 = transformerInternal2.C(progressHolder);
        if (iC2 == 0 || iC2 == 1) {
            progressHolder.f48349a = Math.round(f4);
            return 2;
        }
        if (iC2 == 2) {
            progressHolder.f48349a = Math.round(f4 + ((1.0f - f3) * progressHolder.f48349a));
            return 2;
        }
        if (iC2 == 3) {
            return 3;
        }
        throw new IllegalStateException();
    }

    private void K(Composition composition, String str) {
        O();
        this.B = composition;
        this.C = str;
        this.f48501x.c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean L() {
        int i3 = this.E;
        return i3 == 1 || i3 == 2 || i3 == 3 || i3 == 4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean M() {
        int i3 = this.E;
        return i3 == 5 || i3 == 6;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean N() {
        return ((Composition) Assertions.e(this.B)).f47968a.size() > 1 || ((EditedMediaItemSequence) this.B.f47968a.get(0)).f48110a.size() > 1;
    }

    private void O() {
        long j3 = this.f48488k;
        if (j3 == -9223372036854775807L) {
            return;
        }
        WatchdogTimer watchdogTimer = new WatchdogTimer(j3, new WatchdogTimer.Listener() { // from class: androidx.media3.transformer.e2
            @Override // androidx.media3.transformer.WatchdogTimer.Listener
            public final void a() {
                Transformer.a(this.f48668a);
            }
        });
        this.K = watchdogTimer;
        watchdogTimer.d();
    }

    private void P() {
        WatchdogTimer watchdogTimer = this.K;
        if (watchdogTimer != null) {
            watchdogTimer.e();
            this.K = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q(final ExportException exportException) {
        P();
        final ExportResult exportResultB = this.f48501x.b();
        this.f48490m.h(-1, new ListenerSet.Event() { // from class: androidx.media3.transformer.c2
            @Override // androidx.media3.common.util.ListenerSet.Event
            public final void invoke(Object obj) {
                Transformer.Listener listener = (Transformer.Listener) obj;
                listener.c((Composition) Assertions.e(this.f48659a.B), exportResultB, exportException);
            }
        });
        this.f48490m.f();
        if (F()) {
            ProgressHolder progressHolder = new ProgressHolder();
            ((EditingMetricsCollector) Assertions.e(this.H)).h(I(progressHolder) == 2 ? progressHolder.f48349a : -1, exportException, exportResultB);
        }
        this.E = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R() {
        P();
        final ExportResult exportResultB = this.f48501x.b();
        this.f48490m.h(-1, new ListenerSet.Event() { // from class: androidx.media3.transformer.d2
            @Override // androidx.media3.common.util.ListenerSet.Event
            public final void invoke(Object obj) {
                Transformer.Listener listener = (Transformer.Listener) obj;
                listener.a((Composition) Assertions.e(this.f48664a.B), exportResultB);
            }
        });
        this.f48490m.f();
        if (F()) {
            ((EditingMetricsCollector) Assertions.e(this.H)).i(exportResultB);
        }
        this.E = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S() {
        this.E = 3;
        a0(TransmuxTranscodeHelper.e((Composition) Assertions.e(this.B), (String) Assertions.e(this.C)), new MuxerWrapper((String) Assertions.e(this.D), this.f48495r, this.f48500w, 0, false, null), this.f48500w, 0L, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T() {
        this.E = 0;
        a0((Composition) Assertions.e(this.B), new MuxerWrapper((String) Assertions.e(this.C), this.f48495r, this.f48500w, 0, false, null), this.f48500w, 0L, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void U() {
        this.E = 5;
        final EditedMediaItem editedMediaItem = (EditedMediaItem) ((EditedMediaItemSequence) ((Composition) Assertions.e(this.B)).f47968a.get(0)).f48110a.get(0);
        MediaItem mediaItem = editedMediaItem.f48095a;
        MediaItem.ClippingConfiguration clippingConfiguration = mediaItem.f40718f;
        final long j3 = clippingConfiguration.f40747b;
        final long j4 = clippingConfiguration.f40749d;
        ListenableFuture listenableFutureH = TransmuxTranscodeHelper.h(this.f48478a, ((MediaItem.LocalConfiguration) Assertions.e(mediaItem.f40714b)).f40810a.toString(), j3);
        FutureCallback<Mp4Info> futureCallback = new FutureCallback<Mp4Info>() { // from class: androidx.media3.transformer.Transformer.3
            @Override // com.google.common.util.concurrent.FutureCallback
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(Mp4Info mp4Info) {
                Format format;
                int i3;
                long j5 = mp4Info.f48300d;
                if (j5 == -9223372036854775807L) {
                    Transformer.this.f48501x.n(4);
                    Transformer.this.T();
                    return;
                }
                if (j5 != Long.MIN_VALUE) {
                    long j6 = j4;
                    if (j6 == Long.MIN_VALUE || j6 >= j5) {
                        Format format2 = mp4Info.f48303g;
                        long jY0 = (format2 == null || (i3 = format2.F) == -1) ? 0L : Util.Y0(1024L, i3);
                        long j7 = mp4Info.f48300d;
                        if (j7 == mp4Info.f48299c) {
                            Transformer transformer = Transformer.this;
                            transformer.B = TransmuxTranscodeHelper.c(transformer.B, j3, j4, mp4Info.f48297a, true, false);
                            Transformer.this.f48501x.n(2);
                            Transformer.this.T();
                            return;
                        }
                        if (j7 - j3 <= jY0 || mp4Info.f48301e) {
                            Transformer transformer2 = Transformer.this;
                            transformer2.B = TransmuxTranscodeHelper.c(transformer2.B, mp4Info.f48300d, j4, mp4Info.f48297a, true, false);
                            Transformer.this.f48501x.n(2);
                            Transformer.this.T();
                            return;
                        }
                        Transformer.this.A = new MuxerWrapper((String) Assertions.e(Transformer.this.C), Transformer.this.f48495r, Transformer.this.f48500w, 1, false, mp4Info.f48302f);
                        if (TransformerUtil.m((Format) Assertions.e(mp4Info.f48302f), Transformer.this.B, 0, Transformer.this.f48479b, Transformer.this.f48494q, Transformer.this.A) || ((format = mp4Info.f48303g) != null && TransformerUtil.l(format, Transformer.this.B, 0, Transformer.this.f48479b, Transformer.this.f48494q, Transformer.this.A))) {
                            Transformer.this.A = null;
                            Transformer.this.f48501x.n(3);
                            Transformer.this.T();
                            return;
                        } else {
                            Transformer.this.J = mp4Info;
                            TransformerUtil.k(Transformer.this.A, editedMediaItem.f48101g.f48127b, (Format) Assertions.e(mp4Info.f48302f));
                            Composition compositionC = TransmuxTranscodeHelper.c(Transformer.this.B, j3, mp4Info.f48300d, mp4Info.f48297a, false, true);
                            Transformer transformer3 = Transformer.this;
                            transformer3.a0(compositionC, (MuxerWrapper) Assertions.e(transformer3.A), Transformer.this.f48500w, 0L, false);
                            return;
                        }
                    }
                }
                Transformer.this.f48501x.n(2);
                Transformer.this.T();
            }

            @Override // com.google.common.util.concurrent.FutureCallback
            public void onFailure(Throwable th) {
                Transformer.this.f48501x.n(5);
                Transformer.this.T();
            }
        };
        HandlerWrapper handlerWrapper = this.f48499v;
        Objects.requireNonNull(handlerWrapper);
        Futures.a(listenableFutureH, futureCallback, new androidx.media3.exoplayer.video.f(handlerWrapper));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V() {
        this.E = 2;
        Composition compositionB = TransmuxTranscodeHelper.b((Composition) Assertions.e(this.B), true, false, this.F);
        Assertions.e(this.A);
        this.A.c();
        a0(compositionB, this.A, this.f48500w, ((TransmuxTranscodeHelper.ResumeMetadata) Assertions.e(this.F)).f48594a, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void W() {
        this.E = 6;
        EditedMediaItem editedMediaItem = (EditedMediaItem) ((EditedMediaItemSequence) ((Composition) Assertions.e(this.B)).f47968a.get(0)).f48110a.get(0);
        Mp4Info mp4Info = (Mp4Info) Assertions.e(this.J);
        MediaItem.ClippingConfiguration clippingConfiguration = editedMediaItem.f48095a.f40718f;
        long j3 = clippingConfiguration.f40747b;
        Composition compositionC = TransmuxTranscodeHelper.c(this.B, mp4Info.f48300d, clippingConfiguration.f40749d, mp4Info.f48297a, true, true);
        Assertions.e(this.A);
        this.A.c();
        a0(compositionC, this.A, this.f48500w, mp4Info.f48300d - j3, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean X() {
        if (N() || ((EditedMediaItem) ((EditedMediaItemSequence) ((Composition) Assertions.e(this.B)).f47968a.get(0)).f48110a.get(0)).f48095a.f40718f.equals(MediaItem.ClippingConfiguration.f40738h)) {
            return false;
        }
        return this.f48484g;
    }

    public static /* synthetic */ void a(Transformer transformer) {
        transformer.getClass();
        ((TransformerInternal) Assertions.e(transformer.f48503z)).A(ExportException.d(new IllegalStateException(Util.J("Abort: no output sample written in the last %d milliseconds. DebugTrace: %s", Long.valueOf(transformer.f48488k), DebugTraceUtil.b())), AdError.LOAD_CALLED_WHILE_SHOWING_AD));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a0(Composition composition, MuxerWrapper muxerWrapper, ComponentListener componentListener, long j3, boolean z2) {
        Assertions.h(this.f48503z == null, "There is already an export in progress.");
        TransformationRequest transformationRequestA = this.f48479b;
        if (composition.f47974g != 0) {
            transformationRequestA = transformationRequestA.a().c(composition.f47974g).a();
        }
        TransformationRequest transformationRequest = transformationRequestA;
        FallbackListener fallbackListener = new FallbackListener(composition, this.f48490m, this.f48499v, transformationRequest);
        AssetLoader.Factory defaultAssetLoaderFactory = this.f48491n;
        if (z2 || defaultAssetLoaderFactory == null) {
            Context context = this.f48478a;
            defaultAssetLoaderFactory = new DefaultAssetLoaderFactory(context, new DefaultDecoderFactory.Builder(context).i(), this.f48498u);
        }
        AssetLoader.Factory factory = defaultAssetLoaderFactory;
        DebugTraceUtil.h();
        if (F()) {
            Muxer.Factory factory2 = this.f48495r;
            String str = "androidx.media3:media3-muxer:1.7.1";
            if (!(factory2 instanceof InAppMp4Muxer.Factory) && !(factory2 instanceof InAppFragmentedMp4Muxer.Factory)) {
                str = factory2 instanceof DefaultMuxer.Factory ? DefaultMuxer.f48092b : null;
            }
            this.H = new EditingMetricsCollector(((EditingMetricsCollector.MetricsReporter.Factory) Assertions.e(this.f48502y)).create(), "androidx.media3:media3-transformer:1.7.1", str);
        }
        TransformerInternal transformerInternal = new TransformerInternal(this.f48478a, composition, transformationRequest, factory, this.f48492o, this.f48493p, this.f48494q, this.f48485h, this.f48489l, muxerWrapper, componentListener, fallbackListener, this.f48499v, this.f48497t, this.f48498u, j3);
        this.f48503z = transformerInternal;
        transformerInternal.F();
    }

    private void b0() {
        if (Looper.myLooper() != this.f48496s) {
            throw new IllegalStateException("Transformer is accessed on the wrong thread.");
        }
    }

    public void G() {
        b0();
        TransformerInternal transformerInternal = this.f48503z;
        if (transformerInternal == null) {
            P();
            return;
        }
        try {
            transformerInternal.v();
            ListenableFuture listenableFuture = this.G;
            if (listenableFuture != null && !listenableFuture.isDone()) {
                this.G.cancel(false);
            }
            ListenableFuture listenableFuture2 = this.I;
            if (listenableFuture2 != null && !listenableFuture2.isDone()) {
                this.I.cancel(false);
            }
            P();
        } finally {
            ProgressHolder progressHolder = new ProgressHolder();
            int I = I(progressHolder);
            this.f48503z = null;
            if (F()) {
                ((EditingMetricsCollector) Assertions.e(this.H)).g(I == 2 ? progressHolder.f48349a : -1);
            }
        }
    }

    public int I(ProgressHolder progressHolder) {
        b0();
        if (L()) {
            return 3;
        }
        if (M()) {
            return J(progressHolder);
        }
        TransformerInternal transformerInternal = this.f48503z;
        if (transformerInternal == null) {
            return 0;
        }
        return transformerInternal.C(progressHolder);
    }

    public void Y(Composition composition, String str) {
        b0();
        K(composition, str);
        if (X()) {
            U();
        } else {
            a0(composition, new MuxerWrapper(str, this.f48495r, this.f48500w, 0, this.f48486i, null), this.f48500w, 0L, false);
        }
    }

    public void Z(EditedMediaItem editedMediaItem, String str) {
        Y(new Composition.Builder(new EditedMediaItemSequence.Builder(editedMediaItem).c(), new EditedMediaItemSequence[0]).a(), str);
    }

    private Transformer(Context context, TransformationRequest transformationRequest, ImmutableList immutableList, ImmutableList immutableList2, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, long j3, int i3, ListenerSet listenerSet, AssetLoader.Factory factory, AudioMixer.Factory factory2, VideoFrameProcessor.Factory factory3, Codec.EncoderFactory encoderFactory, Muxer.Factory factory4, Looper looper, DebugViewProvider debugViewProvider, Clock clock, EditingMetricsCollector.MetricsReporter.Factory factory5) {
        Assertions.h((z2 && z3) ? false : true, "Audio and video cannot both be removed.");
        this.f48478a = context;
        this.f48479b = transformationRequest;
        this.f48480c = immutableList;
        this.f48481d = immutableList2;
        this.f48482e = z2;
        this.f48483f = z3;
        this.f48484g = z4;
        this.f48485h = z5;
        this.f48486i = z6;
        this.f48487j = z7;
        this.f48488k = j3;
        this.f48489l = i3;
        this.f48490m = listenerSet;
        this.f48491n = factory;
        this.f48492o = factory2;
        this.f48493p = factory3;
        this.f48494q = encoderFactory;
        this.f48495r = factory4;
        this.f48496s = looper;
        this.f48497t = debugViewProvider;
        this.f48498u = clock;
        this.f48502y = factory5;
        this.E = 0;
        this.f48499v = clock.d(looper, null);
        this.f48500w = new ComponentListener(this, null);
        this.f48501x = new ExportResult.Builder();
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Context f48510a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f48511b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f48512c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private TransformationRequest f48513d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final ImmutableList f48514e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final ImmutableList f48515f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private boolean f48516g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private boolean f48517h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private boolean f48518i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private boolean f48519j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private boolean f48520k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private boolean f48521l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private long f48522m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private int f48523n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private ListenerSet f48524o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private AssetLoader.Factory f48525p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        private AudioMixer.Factory f48526q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        private VideoFrameProcessor.Factory f48527r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        private Codec.EncoderFactory f48528s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        private Muxer.Factory f48529t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        private Looper f48530u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        private DebugViewProvider f48531v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        private Clock f48532w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        private EditingMetricsCollector.MetricsReporter.Factory f48533x;

        public Builder(Context context) {
            Context applicationContext = context.getApplicationContext();
            this.f48510a = applicationContext;
            this.f48522m = Transformer.L;
            this.f48523n = -1;
            this.f48514e = ImmutableList.y();
            this.f48515f = ImmutableList.y();
            this.f48526q = new DefaultAudioMixer.Factory();
            this.f48527r = new DefaultVideoFrameProcessor.Factory.Builder().build();
            this.f48528s = new DefaultEncoderFactory.Builder(applicationContext).g();
            this.f48529t = new DefaultMuxer.Factory();
            Looper looperY = Util.Y();
            this.f48530u = looperY;
            this.f48531v = DebugViewProvider.f40567a;
            Clock clock = Clock.f41485a;
            this.f48532w = clock;
            this.f48524o = new ListenerSet(looperY, clock, new ListenerSet.IterationFinishedEvent() { // from class: androidx.media3.transformer.f2
                @Override // androidx.media3.common.util.ListenerSet.IterationFinishedEvent
                public final void a(Object obj, FlagSet flagSet) {
                    Transformer.Builder.a((Transformer.Listener) obj, flagSet);
                }
            });
            if (Util.f41609a >= 35) {
                this.f48521l = true;
                this.f48533x = new EditingMetricsCollector.DefaultMetricsReporter.Factory(context);
            }
        }

        private void d(String str) {
            Assertions.h(this.f48529t.b(MimeTypes.k(str)).contains(str), "Unsupported sample MIME type " + str);
        }

        public Builder b(Listener listener) {
            this.f48524o.c(listener);
            return this;
        }

        public Transformer c() {
            TransformationRequest transformationRequest = this.f48513d;
            TransformationRequest.Builder builder = transformationRequest == null ? new TransformationRequest.Builder() : transformationRequest.a();
            String str = this.f48511b;
            if (str != null) {
                builder.b(str);
            }
            String str2 = this.f48512c;
            if (str2 != null) {
                builder.e(str2);
            }
            TransformationRequest transformationRequestA = builder.a();
            this.f48513d = transformationRequestA;
            String str3 = transformationRequestA.f48471b;
            if (str3 != null) {
                d(str3);
            }
            String str4 = this.f48513d.f48472c;
            if (str4 != null) {
                d(str4);
            }
            return new Transformer(this.f48510a, this.f48513d, this.f48514e, this.f48515f, this.f48516g, this.f48517h, this.f48518i, this.f48519j, this.f48520k, this.f48521l, this.f48522m, this.f48523n, this.f48524o, this.f48525p, this.f48526q, this.f48527r, this.f48528s, this.f48529t, this.f48530u, this.f48531v, this.f48532w, this.f48533x, null);
        }

        public Builder e(Codec.EncoderFactory encoderFactory) {
            this.f48528s = encoderFactory;
            return this;
        }

        public Builder f(String str) {
            String strR = MimeTypes.r(str);
            Assertions.b(MimeTypes.q(strR), "Not a video MIME type: " + strR);
            this.f48512c = strR;
            return this;
        }

        public static /* synthetic */ void a(Listener listener, FlagSet flagSet) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface Listener {
        default void a(Composition composition, ExportResult exportResult) {
        }

        default void b(Composition composition, TransformationRequest transformationRequest, TransformationRequest transformationRequest2) {
        }

        default void c(Composition composition, ExportResult exportResult, ExportException exportException) {
        }
    }
}
