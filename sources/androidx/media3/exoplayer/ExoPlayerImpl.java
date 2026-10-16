package androidx.media3.exoplayer;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.Looper;
import android.util.Pair;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.TextureView;
import androidx.media3.common.AudioAttributes;
import androidx.media3.common.BasePlayer;
import androidx.media3.common.DeviceInfo;
import androidx.media3.common.FlagSet;
import androidx.media3.common.Format;
import androidx.media3.common.MediaItem;
import androidx.media3.common.MediaLibraryInfo;
import androidx.media3.common.MediaMetadata;
import androidx.media3.common.Metadata;
import androidx.media3.common.PlaybackParameters;
import androidx.media3.common.Player;
import androidx.media3.common.PriorityTaskManager;
import androidx.media3.common.Timeline;
import androidx.media3.common.TrackSelectionParameters;
import androidx.media3.common.Tracks;
import androidx.media3.common.VideoSize;
import androidx.media3.common.text.CueGroup;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.BackgroundThreadStateHandler;
import androidx.media3.common.util.Clock;
import androidx.media3.common.util.ConditionVariable;
import androidx.media3.common.util.HandlerWrapper;
import androidx.media3.common.util.ListenerSet;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Size;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.AudioBecomingNoisyManager;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.exoplayer.ExoPlayerImpl;
import androidx.media3.exoplayer.ExoPlayerImplInternal;
import androidx.media3.exoplayer.MediaSourceList;
import androidx.media3.exoplayer.PlayerMessage;
import androidx.media3.exoplayer.StreamVolumeManager;
import androidx.media3.exoplayer.SuitableOutputChecker;
import androidx.media3.exoplayer.analytics.AnalyticsCollector;
import androidx.media3.exoplayer.analytics.AnalyticsListener;
import androidx.media3.exoplayer.analytics.MediaMetricsListener;
import androidx.media3.exoplayer.analytics.PlayerId;
import androidx.media3.exoplayer.audio.AudioRendererEventListener;
import androidx.media3.exoplayer.audio.AudioSink;
import androidx.media3.exoplayer.metadata.MetadataOutput;
import androidx.media3.exoplayer.source.MaskingMediaSource;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.source.ShuffleOrder;
import androidx.media3.exoplayer.source.TrackGroupArray;
import androidx.media3.exoplayer.text.TextOutput;
import androidx.media3.exoplayer.trackselection.ExoTrackSelection;
import androidx.media3.exoplayer.trackselection.TrackSelector;
import androidx.media3.exoplayer.trackselection.TrackSelectorResult;
import androidx.media3.exoplayer.upstream.BandwidthMeter;
import androidx.media3.exoplayer.video.VideoFrameMetadataListener;
import androidx.media3.exoplayer.video.VideoRendererEventListener;
import androidx.media3.exoplayer.video.spherical.CameraMotionListener;
import androidx.media3.exoplayer.video.spherical.SphericalGLSurfaceView;
import com.google.common.collect.ImmutableList;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class ExoPlayerImpl extends BasePlayer implements ExoPlayer {
    private final ComponentListener A;
    private final FrameMetadataListener B;
    private final AudioBecomingNoisyManager C;
    private final StreamVolumeManager D;
    private final WakeLockManager E;
    private final WifiLockManager F;
    private final long G;
    private final SuitableOutputChecker H;
    private final BackgroundThreadStateHandler I;
    private int J;
    private boolean K;
    private int L;
    private int M;
    private boolean N;
    private SeekParameters O;
    private ShuffleOrder P;
    private ExoPlayer.PreloadConfiguration Q;
    private boolean R;
    private Player.Commands S;
    private MediaMetadata T;
    private MediaMetadata U;
    private Format V;
    private Format W;
    private Object X;
    private Surface Y;
    private SurfaceHolder Z;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    private SphericalGLSurfaceView f42991a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final TrackSelectorResult f42992b;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    private boolean f42993b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Player.Commands f42994c;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    private TextureView f42995c0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ConditionVariable f42996d = new ConditionVariable();

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    private int f42997d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    private int f42998e0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Context f42999f;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    private Size f43000f0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Player f43001g;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    private DecoderCounters f43002g0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Renderer[] f43003h;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    private DecoderCounters f43004h0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Renderer[] f43005i;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    private AudioAttributes f43006i0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final TrackSelector f43007j;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    private float f43008j0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final HandlerWrapper f43009k;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    private boolean f43010k0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final ExoPlayerImplInternal.PlaybackInfoUpdateListener f43011l;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    private CueGroup f43012l0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final ExoPlayerImplInternal f43013m;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    private boolean f43014m0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final ListenerSet f43015n;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    private boolean f43016n0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final CopyOnWriteArraySet f43017o;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    private int f43018o0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final Timeline.Period f43019p;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    private PriorityTaskManager f43020p0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final List f43021q;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    private boolean f43022q0;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final boolean f43023r;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    private boolean f43024r0;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final MediaSource.Factory f43025s;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    private DeviceInfo f43026s0;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final AnalyticsCollector f43027t;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    private VideoSize f43028t0;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final Looper f43029u;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    private MediaMetadata f43030u0;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final BandwidthMeter f43031v;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    private PlaybackInfo f43032v0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final long f43033w;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    private int f43034w0;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final long f43035x;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    private int f43036x0;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final long f43037y;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    private long f43038y0;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private final Clock f43039z;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class Api31 {
        public static /* synthetic */ void a(Context context, boolean z2, ExoPlayerImpl exoPlayerImpl, PlayerId playerId) {
            MediaMetricsListener mediaMetricsListenerJ0 = MediaMetricsListener.J0(context);
            if (mediaMetricsListenerJ0 == null) {
                Log.i("ExoPlayerImpl", "MediaMetricsService unavailable.");
                return;
            }
            if (z2) {
                exoPlayerImpl.A1(mediaMetricsListenerJ0);
            }
            playerId.b(mediaMetricsListenerJ0.Q0());
        }

        public static void b(final Context context, final ExoPlayerImpl exoPlayerImpl, final boolean z2, final PlayerId playerId) {
            exoPlayerImpl.L1().d(exoPlayerImpl.P1(), null).j(new Runnable() { // from class: androidx.media3.exoplayer.m1
                @Override // java.lang.Runnable
                public final void run() {
                    ExoPlayerImpl.Api31.a(context, z2, exoPlayerImpl, playerId);
                }
            });
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class FrameMetadataListener implements VideoFrameMetadataListener, CameraMotionListener, PlayerMessage.Target {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private VideoFrameMetadataListener f43041a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private CameraMotionListener f43042b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private VideoFrameMetadataListener f43043c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private CameraMotionListener f43044d;

        private FrameMetadataListener() {
        }

        @Override // androidx.media3.exoplayer.video.spherical.CameraMotionListener
        public void a(long j3, float[] fArr) {
            CameraMotionListener cameraMotionListener = this.f43044d;
            if (cameraMotionListener != null) {
                cameraMotionListener.a(j3, fArr);
            }
            CameraMotionListener cameraMotionListener2 = this.f43042b;
            if (cameraMotionListener2 != null) {
                cameraMotionListener2.a(j3, fArr);
            }
        }

        @Override // androidx.media3.exoplayer.video.spherical.CameraMotionListener
        public void d() {
            CameraMotionListener cameraMotionListener = this.f43044d;
            if (cameraMotionListener != null) {
                cameraMotionListener.d();
            }
            CameraMotionListener cameraMotionListener2 = this.f43042b;
            if (cameraMotionListener2 != null) {
                cameraMotionListener2.d();
            }
        }

        @Override // androidx.media3.exoplayer.video.VideoFrameMetadataListener
        public void e(long j3, long j4, Format format, MediaFormat mediaFormat) {
            long j5;
            long j6;
            Format format2;
            MediaFormat mediaFormat2;
            VideoFrameMetadataListener videoFrameMetadataListener = this.f43043c;
            if (videoFrameMetadataListener != null) {
                videoFrameMetadataListener.e(j3, j4, format, mediaFormat);
                mediaFormat2 = mediaFormat;
                format2 = format;
                j6 = j4;
                j5 = j3;
            } else {
                j5 = j3;
                j6 = j4;
                format2 = format;
                mediaFormat2 = mediaFormat;
            }
            VideoFrameMetadataListener videoFrameMetadataListener2 = this.f43041a;
            if (videoFrameMetadataListener2 != null) {
                videoFrameMetadataListener2.e(j5, j6, format2, mediaFormat2);
            }
        }

        @Override // androidx.media3.exoplayer.PlayerMessage.Target
        public void w(int i3, Object obj) {
            if (i3 == 7) {
                this.f43041a = (VideoFrameMetadataListener) obj;
                return;
            }
            if (i3 == 8) {
                this.f43042b = (CameraMotionListener) obj;
                return;
            }
            if (i3 != 10000) {
                return;
            }
            SphericalGLSurfaceView sphericalGLSurfaceView = (SphericalGLSurfaceView) obj;
            if (sphericalGLSurfaceView == null) {
                this.f43043c = null;
                this.f43044d = null;
            } else {
                this.f43043c = sphericalGLSurfaceView.getVideoFrameMetadataListener();
                this.f43044d = sphericalGLSurfaceView.getCameraMotionListener();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class MediaSourceHolderSnapshot implements MediaSourceInfoHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Object f43045a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final MediaSource f43046b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Timeline f43047c;

        public MediaSourceHolderSnapshot(Object obj, MaskingMediaSource maskingMediaSource) {
            this.f43045a = obj;
            this.f43046b = maskingMediaSource;
            this.f43047c = maskingMediaSource.L0();
        }

        @Override // androidx.media3.exoplayer.MediaSourceInfoHolder
        public Object a() {
            return this.f43045a;
        }

        @Override // androidx.media3.exoplayer.MediaSourceInfoHolder
        public Timeline b() {
            return this.f43047c;
        }

        public void c(Timeline timeline) {
            this.f43047c = timeline;
        }
    }

    static {
        MediaLibraryInfo.a("media3.exoplayer");
    }

    public ExoPlayerImpl(ExoPlayer.Builder builder, Player player) {
        Looper looper;
        Clock clock;
        try {
            Log.g("ExoPlayerImpl", "Init " + Integer.toHexString(System.identityHashCode(this)) + " [AndroidXMedia3/1.7.1] [" + Util.f41613e + "]");
            this.f42999f = builder.f42963a.getApplicationContext();
            this.f43027t = (AnalyticsCollector) builder.f42971i.apply(builder.f42964b);
            this.f43018o0 = builder.f42973k;
            this.f43020p0 = builder.f42974l;
            this.f43006i0 = builder.f42975m;
            this.f42997d0 = builder.f42981s;
            this.f42998e0 = builder.f42982t;
            this.f43010k0 = builder.f42979q;
            this.G = builder.B;
            ComponentListener componentListener = new ComponentListener();
            this.A = componentListener;
            this.B = new FrameMetadataListener();
            Handler handler = new Handler(builder.f42972j);
            RenderersFactory renderersFactory = (RenderersFactory) builder.f42966d.get();
            Renderer[] rendererArrB = renderersFactory.b(handler, componentListener, componentListener, componentListener, componentListener);
            this.f43003h = rendererArrB;
            Assertions.g(rendererArrB.length > 0);
            this.f43005i = new Renderer[rendererArrB.length];
            int i3 = 0;
            while (true) {
                Renderer[] rendererArr = this.f43005i;
                if (i3 >= rendererArr.length) {
                    break;
                }
                Renderer renderer = this.f43003h[i3];
                ComponentListener componentListener2 = this.A;
                RenderersFactory renderersFactory2 = renderersFactory;
                rendererArr[i3] = renderersFactory2.a(renderer, handler, componentListener2, componentListener2, componentListener2, componentListener2);
                i3++;
                renderersFactory = renderersFactory2;
            }
            TrackSelector trackSelector = (TrackSelector) builder.f42968f.get();
            this.f43007j = trackSelector;
            this.f43025s = (MediaSource.Factory) builder.f42967e.get();
            BandwidthMeter bandwidthMeter = (BandwidthMeter) builder.f42970h.get();
            this.f43031v = bandwidthMeter;
            this.f43023r = builder.f42983u;
            this.O = builder.f42984v;
            this.f43033w = builder.f42985w;
            this.f43035x = builder.f42986x;
            this.f43037y = builder.f42987y;
            this.R = builder.C;
            Looper looper2 = builder.f42972j;
            this.f43029u = looper2;
            Clock clock2 = builder.f42964b;
            this.f43039z = clock2;
            Player player2 = player == null ? this : player;
            this.f43001g = player2;
            this.f43015n = new ListenerSet(looper2, clock2, new ListenerSet.IterationFinishedEvent() { // from class: androidx.media3.exoplayer.w0
                @Override // androidx.media3.common.util.ListenerSet.IterationFinishedEvent
                public final void a(Object obj, FlagSet flagSet) {
                    ((Player.Listener) obj).c0(this.f46010a.f43001g, new Player.Events(flagSet));
                }
            });
            this.f43017o = new CopyOnWriteArraySet();
            this.f43021q = new ArrayList();
            this.P = new ShuffleOrder.DefaultShuffleOrder(0);
            this.Q = ExoPlayer.PreloadConfiguration.f42989b;
            Renderer[] rendererArr2 = this.f43003h;
            TrackSelectorResult trackSelectorResult = new TrackSelectorResult(new RendererConfiguration[rendererArr2.length], new ExoTrackSelection[rendererArr2.length], Tracks.f41239b, null);
            this.f42992b = trackSelectorResult;
            this.f43019p = new Timeline.Period();
            Player.Commands commandsE = new Player.Commands.Builder().c(1, 2, 3, 13, 14, 15, 16, 17, 18, 19, 31, 20, 30, 21, 35, 22, 24, 27, 28, 32).d(29, trackSelector.h()).d(23, builder.f42980r).d(25, builder.f42980r).d(33, builder.f42980r).d(26, builder.f42980r).d(34, builder.f42980r).e();
            this.f42994c = commandsE;
            this.S = new Player.Commands.Builder().b(commandsE).a(4).a(10).e();
            this.f43009k = clock2.d(looper2, null);
            ExoPlayerImplInternal.PlaybackInfoUpdateListener playbackInfoUpdateListener = new ExoPlayerImplInternal.PlaybackInfoUpdateListener() { // from class: androidx.media3.exoplayer.x0
                @Override // androidx.media3.exoplayer.ExoPlayerImplInternal.PlaybackInfoUpdateListener
                public final void a(ExoPlayerImplInternal.PlaybackInfoUpdate playbackInfoUpdate) {
                    ExoPlayerImpl exoPlayerImpl = this.f46015a;
                    exoPlayerImpl.f43009k.j(new Runnable() { // from class: androidx.media3.exoplayer.c1
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f43963a.T1(playbackInfoUpdate);
                        }
                    });
                }
            };
            this.f43011l = playbackInfoUpdateListener;
            this.f43032v0 = PlaybackInfo.k(trackSelectorResult);
            this.f43027t.u0(player2, looper2);
            PlayerId playerId = new PlayerId(builder.H);
            ExoPlayerImplInternal exoPlayerImplInternal = new ExoPlayerImplInternal(this.f42999f, this.f43003h, this.f43005i, trackSelector, trackSelectorResult, (LoadControl) builder.f42969g.get(), bandwidthMeter, this.J, this.K, this.f43027t, this.O, builder.f42988z, builder.A, this.R, builder.I, looper2, clock2, playbackInfoUpdateListener, playerId, builder.E, this.Q);
            this.f43013m = exoPlayerImplInternal;
            Looper looperK = exoPlayerImplInternal.K();
            this.f43008j0 = 1.0f;
            this.J = 0;
            MediaMetadata mediaMetadata = MediaMetadata.K;
            this.T = mediaMetadata;
            this.U = mediaMetadata;
            this.f43030u0 = mediaMetadata;
            this.f43034w0 = -1;
            this.f43012l0 = CueGroup.f41450c;
            this.f43014m0 = true;
            B(this.f43027t);
            bandwidthMeter.b(new Handler(looper2), this.f43027t);
            B1(this.A);
            long j3 = builder.f42965c;
            if (j3 > 0) {
                exoPlayerImplInternal.E(j3);
            }
            if (Util.f41609a >= 31) {
                Api31.b(this.f42999f, this, builder.D, playerId);
            }
            BackgroundThreadStateHandler backgroundThreadStateHandler = new BackgroundThreadStateHandler(0, looperK, looper2, clock2, new BackgroundThreadStateHandler.StateChangeListener() { // from class: androidx.media3.exoplayer.y0
                @Override // androidx.media3.common.util.BackgroundThreadStateHandler.StateChangeListener
                public final void a(Object obj, Object obj2) {
                    this.f46018a.Z1(((Integer) obj).intValue(), ((Integer) obj2).intValue());
                }
            });
            this.I = backgroundThreadStateHandler;
            backgroundThreadStateHandler.e(new Runnable() { // from class: androidx.media3.exoplayer.a1
                @Override // java.lang.Runnable
                public final void run() {
                    ExoPlayerImpl exoPlayerImpl = this.f43335a;
                    exoPlayerImpl.I.f(Integer.valueOf(Util.M(exoPlayerImpl.f42999f)));
                }
            });
            AudioBecomingNoisyManager audioBecomingNoisyManager = new AudioBecomingNoisyManager(builder.f42963a, looperK, builder.f42972j, this.A, clock2);
            Clock clock3 = clock2;
            this.C = audioBecomingNoisyManager;
            audioBecomingNoisyManager.d(builder.f42978p);
            if (builder.G) {
                SuitableOutputChecker suitableOutputChecker = builder.J;
                this.H = suitableOutputChecker;
                suitableOutputChecker.b(new SuitableOutputChecker.Callback() { // from class: androidx.media3.exoplayer.b1
                    @Override // androidx.media3.exoplayer.SuitableOutputChecker.Callback
                    public final void a(boolean z2) {
                        this.f43959a.a2(z2);
                    }
                }, this.f42999f, looper2, looperK, clock3);
                clock3 = clock3;
            } else {
                this.H = null;
            }
            if (builder.f42980r) {
                Clock clock4 = clock3;
                StreamVolumeManager streamVolumeManager = new StreamVolumeManager(builder.f42963a, this.A, this.f43006i0.b(), looperK, looper2, clock4);
                looper = looperK;
                clock = clock4;
                this.D = streamVolumeManager;
            } else {
                looper = looperK;
                clock = clock3;
                this.D = null;
            }
            WakeLockManager wakeLockManager = new WakeLockManager(builder.f42963a, looper, clock);
            this.E = wakeLockManager;
            wakeLockManager.c(builder.f42977o != 0);
            WifiLockManager wifiLockManager = new WifiLockManager(builder.f42963a, looper, clock);
            this.F = wifiLockManager;
            wifiLockManager.c(builder.f42977o == 2);
            this.f43026s0 = DeviceInfo.f40568e;
            this.f43028t0 = VideoSize.f41254e;
            this.f43000f0 = Size.f41593c;
            exoPlayerImplInternal.Z0(this.f43006i0, builder.f42976n);
            e2(1, 3, this.f43006i0);
            e2(2, 4, Integer.valueOf(this.f42997d0));
            e2(2, 5, Integer.valueOf(this.f42998e0));
            e2(1, 9, Boolean.valueOf(this.f43010k0));
            e2(2, 7, this.B);
            e2(6, 8, this.B);
            f2(16, Integer.valueOf(this.f43018o0));
            this.f42996d.f();
        } catch (Throwable th) {
            this.f42996d.f();
            throw th;
        }
    }

    private List C1(int i3, List list) {
        ArrayList arrayList = new ArrayList();
        for (int i4 = 0; i4 < list.size(); i4++) {
            MediaSourceList.MediaSourceHolder mediaSourceHolder = new MediaSourceList.MediaSourceHolder((MediaSource) list.get(i4), this.f43023r);
            arrayList.add(mediaSourceHolder);
            this.f43021q.add(i4 + i3, new MediaSourceHolderSnapshot(mediaSourceHolder.f43206b, mediaSourceHolder.f43205a));
        }
        this.P = this.P.g(i3, arrayList.size());
        return arrayList;
    }

    public static /* synthetic */ void D0(PlaybackInfo playbackInfo, Player.Listener listener) {
        listener.C(playbackInfo.f43240g);
        listener.b0(playbackInfo.f43240g);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public MediaMetadata D1() {
        Timeline timelineE = E();
        if (timelineE.q()) {
            return this.f43030u0;
        }
        return this.f43030u0.a().L(timelineE.n(f0(), this.f40538a).f41137c.f40717e).J();
    }

    private int E1(boolean z2) {
        SuitableOutputChecker suitableOutputChecker = this.H;
        if (suitableOutputChecker == null || suitableOutputChecker.a()) {
            return (this.f43032v0.f43247n != 1 || z2) ? 0 : 1;
        }
        return 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static DeviceInfo F1(StreamVolumeManager streamVolumeManager) {
        return new DeviceInfo.Builder(0).g(streamVolumeManager != null ? streamVolumeManager.j() : 0).f(streamVolumeManager != null ? streamVolumeManager.i() : 0).e();
    }

    private Timeline G1() {
        return new PlaylistTimeline(this.f43021q, this.P);
    }

    private List H1(List list) {
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < list.size(); i3++) {
            arrayList.add(this.f43025s.c((MediaItem) list.get(i3)));
        }
        return arrayList;
    }

    private PlayerMessage I1(PlayerMessage.Target target) {
        int iO1 = O1(this.f43032v0);
        ExoPlayerImplInternal exoPlayerImplInternal = this.f43013m;
        Timeline timeline = this.f43032v0.f43234a;
        if (iO1 == -1) {
            iO1 = 0;
        }
        return new PlayerMessage(exoPlayerImplInternal, target, timeline, iO1, this.f43039z, exoPlayerImplInternal.K());
    }

    private Pair J1(PlaybackInfo playbackInfo, PlaybackInfo playbackInfo2, boolean z2, int i3, boolean z3, boolean z4) {
        Timeline timeline = playbackInfo2.f43234a;
        Timeline timeline2 = playbackInfo.f43234a;
        if (timeline2.q() && timeline.q()) {
            return new Pair(Boolean.FALSE, -1);
        }
        int i4 = 3;
        if (timeline2.q() != timeline.q()) {
            return new Pair(Boolean.TRUE, 3);
        }
        if (timeline.n(timeline.h(playbackInfo2.f43235b.f44754a, this.f43019p).f41116c, this.f40538a).f41135a.equals(timeline2.n(timeline2.h(playbackInfo.f43235b.f44754a, this.f43019p).f41116c, this.f40538a).f41135a)) {
            return (z2 && i3 == 0 && playbackInfo2.f43235b.f44757d < playbackInfo.f43235b.f44757d) ? new Pair(Boolean.TRUE, 0) : (z2 && i3 == 1 && z4) ? new Pair(Boolean.TRUE, 2) : new Pair(Boolean.FALSE, -1);
        }
        if (z2 && i3 == 0) {
            i4 = 1;
        } else if (z2 && i3 == 1) {
            i4 = 2;
        } else if (!z3) {
            throw new IllegalStateException();
        }
        return new Pair(Boolean.TRUE, Integer.valueOf(i4));
    }

    private long M1(PlaybackInfo playbackInfo) {
        if (!playbackInfo.f43235b.c()) {
            return Util.t1(N1(playbackInfo));
        }
        playbackInfo.f43234a.h(playbackInfo.f43235b.f44754a, this.f43019p);
        return playbackInfo.f43236c == -9223372036854775807L ? playbackInfo.f43234a.n(O1(playbackInfo), this.f40538a).b() : this.f43019p.n() + Util.t1(playbackInfo.f43236c);
    }

    private long N1(PlaybackInfo playbackInfo) {
        if (playbackInfo.f43234a.q()) {
            return Util.P0(this.f43038y0);
        }
        long jM = playbackInfo.f43249p ? playbackInfo.m() : playbackInfo.f43252s;
        return playbackInfo.f43235b.c() ? jM : b2(playbackInfo.f43234a, playbackInfo.f43235b, jM);
    }

    private int O1(PlaybackInfo playbackInfo) {
        return playbackInfo.f43234a.q() ? this.f43034w0 : playbackInfo.f43234a.h(playbackInfo.f43235b.f44754a, this.f43019p).f41116c;
    }

    private Player.PositionInfo Q1(long j3) {
        Object obj;
        int iB;
        MediaItem mediaItem;
        Object obj2;
        int iF0 = f0();
        if (this.f43032v0.f43234a.q()) {
            obj = null;
            iB = -1;
            mediaItem = null;
            obj2 = null;
        } else {
            PlaybackInfo playbackInfo = this.f43032v0;
            Object obj3 = playbackInfo.f43235b.f44754a;
            playbackInfo.f43234a.h(obj3, this.f43019p);
            iB = this.f43032v0.f43234a.b(obj3);
            obj2 = obj3;
            obj = this.f43032v0.f43234a.n(iF0, this.f40538a).f41135a;
            mediaItem = this.f40538a.f41137c;
        }
        int i3 = iB;
        long jT1 = Util.t1(j3);
        long jT12 = this.f43032v0.f43235b.c() ? Util.t1(S1(this.f43032v0)) : jT1;
        MediaSource.MediaPeriodId mediaPeriodId = this.f43032v0.f43235b;
        return new Player.PositionInfo(obj, iF0, mediaItem, obj2, i3, jT1, jT12, mediaPeriodId.f44755b, mediaPeriodId.f44756c);
    }

    private Player.PositionInfo R1(int i3, PlaybackInfo playbackInfo, int i4) {
        int i5;
        Object obj;
        MediaItem mediaItem;
        Object obj2;
        int i6;
        long jS1;
        long jS12;
        Timeline.Period period = new Timeline.Period();
        if (playbackInfo.f43234a.q()) {
            i5 = i4;
            obj = null;
            mediaItem = null;
            obj2 = null;
            i6 = -1;
        } else {
            Object obj3 = playbackInfo.f43235b.f44754a;
            playbackInfo.f43234a.h(obj3, period);
            int i7 = period.f41116c;
            int iB = playbackInfo.f43234a.b(obj3);
            Object obj4 = playbackInfo.f43234a.n(i7, this.f40538a).f41135a;
            mediaItem = this.f40538a.f41137c;
            obj2 = obj3;
            i6 = iB;
            obj = obj4;
            i5 = i7;
        }
        if (i3 == 0) {
            if (playbackInfo.f43235b.c()) {
                MediaSource.MediaPeriodId mediaPeriodId = playbackInfo.f43235b;
                jS1 = period.b(mediaPeriodId.f44755b, mediaPeriodId.f44756c);
                jS12 = S1(playbackInfo);
            } else {
                jS1 = playbackInfo.f43235b.f44758e != -1 ? S1(this.f43032v0) : period.f41118e + period.f41117d;
                jS12 = jS1;
            }
        } else if (playbackInfo.f43235b.c()) {
            jS1 = playbackInfo.f43252s;
            jS12 = S1(playbackInfo);
        } else {
            jS1 = period.f41118e + playbackInfo.f43252s;
            jS12 = jS1;
        }
        long jT1 = Util.t1(jS1);
        long jT12 = Util.t1(jS12);
        MediaSource.MediaPeriodId mediaPeriodId2 = playbackInfo.f43235b;
        return new Player.PositionInfo(obj, i5, mediaItem, obj2, i6, jT1, jT12, mediaPeriodId2.f44755b, mediaPeriodId2.f44756c);
    }

    private static long S1(PlaybackInfo playbackInfo) {
        Timeline.Window window = new Timeline.Window();
        Timeline.Period period = new Timeline.Period();
        playbackInfo.f43234a.h(playbackInfo.f43235b.f44754a, period);
        return playbackInfo.f43236c == -9223372036854775807L ? playbackInfo.f43234a.n(period.f41116c, window).c() : period.o() + playbackInfo.f43236c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T1(ExoPlayerImplInternal.PlaybackInfoUpdate playbackInfoUpdate) {
        boolean z2;
        long jB2;
        int i3 = this.L - playbackInfoUpdate.f43094c;
        this.L = i3;
        boolean z3 = true;
        if (playbackInfoUpdate.f43095d) {
            this.M = playbackInfoUpdate.f43096e;
            this.N = true;
        }
        if (i3 == 0) {
            Timeline timeline = playbackInfoUpdate.f43093b.f43234a;
            if (!this.f43032v0.f43234a.q() && timeline.q()) {
                this.f43034w0 = -1;
                this.f43038y0 = 0L;
                this.f43036x0 = 0;
            }
            if (!timeline.q()) {
                List listF = ((PlaylistTimeline) timeline).F();
                Assertions.g(listF.size() == this.f43021q.size());
                for (int i4 = 0; i4 < listF.size(); i4++) {
                    ((MediaSourceHolderSnapshot) this.f43021q.get(i4)).c((Timeline) listF.get(i4));
                }
            }
            long j3 = -9223372036854775807L;
            if (this.N) {
                if (playbackInfoUpdate.f43093b.f43235b.equals(this.f43032v0.f43235b) && playbackInfoUpdate.f43093b.f43237d == this.f43032v0.f43252s) {
                    z3 = false;
                }
                if (z3) {
                    if (timeline.q() || playbackInfoUpdate.f43093b.f43235b.c()) {
                        jB2 = playbackInfoUpdate.f43093b.f43237d;
                    } else {
                        PlaybackInfo playbackInfo = playbackInfoUpdate.f43093b;
                        jB2 = b2(timeline, playbackInfo.f43235b, playbackInfo.f43237d);
                    }
                    j3 = jB2;
                }
                z2 = z3;
            } else {
                z2 = false;
            }
            this.N = false;
            o2(playbackInfoUpdate.f43093b, 1, z2, this.M, j3, -1, false);
        }
    }

    public static /* synthetic */ void U0(int i3, Player.PositionInfo positionInfo, Player.PositionInfo positionInfo2, Player.Listener listener) {
        listener.a0(i3);
        listener.v0(positionInfo, positionInfo2, i3);
    }

    private static PlaybackInfo V1(PlaybackInfo playbackInfo, int i3) {
        PlaybackInfo playbackInfoH = playbackInfo.h(i3);
        return (i3 == 1 || i3 == 4) ? playbackInfoH.b(false) : playbackInfoH;
    }

    private PlaybackInfo W1(PlaybackInfo playbackInfo, Timeline timeline, Pair pair) {
        Assertions.a(timeline.q() || pair != null);
        Timeline timeline2 = playbackInfo.f43234a;
        long jM1 = M1(playbackInfo);
        PlaybackInfo playbackInfoJ = playbackInfo.j(timeline);
        if (timeline.q()) {
            MediaSource.MediaPeriodId mediaPeriodIdL = PlaybackInfo.l();
            long jP0 = Util.P0(this.f43038y0);
            PlaybackInfo playbackInfoC = playbackInfoJ.d(mediaPeriodIdL, jP0, jP0, jP0, 0L, TrackGroupArray.f44985d, this.f42992b, ImmutableList.y()).c(mediaPeriodIdL);
            playbackInfoC.f43250q = playbackInfoC.f43252s;
            return playbackInfoC;
        }
        Object obj = playbackInfoJ.f43235b.f44754a;
        boolean zEquals = obj.equals(((Pair) Util.k(pair)).first);
        MediaSource.MediaPeriodId mediaPeriodId = !zEquals ? new MediaSource.MediaPeriodId(pair.first) : playbackInfoJ.f43235b;
        long jLongValue = ((Long) pair.second).longValue();
        long jP02 = Util.P0(jM1);
        if (!timeline2.q()) {
            jP02 -= timeline2.h(obj, this.f43019p).o();
        }
        if (!zEquals || jLongValue < jP02) {
            MediaSource.MediaPeriodId mediaPeriodId2 = mediaPeriodId;
            Assertions.g(!mediaPeriodId2.c());
            PlaybackInfo playbackInfoC2 = playbackInfoJ.d(mediaPeriodId2, jLongValue, jLongValue, jLongValue, 0L, !zEquals ? TrackGroupArray.f44985d : playbackInfoJ.f43241h, !zEquals ? this.f42992b : playbackInfoJ.f43242i, !zEquals ? ImmutableList.y() : playbackInfoJ.f43243j).c(mediaPeriodId2);
            playbackInfoC2.f43250q = jLongValue;
            return playbackInfoC2;
        }
        if (jLongValue != jP02) {
            MediaSource.MediaPeriodId mediaPeriodId3 = mediaPeriodId;
            Assertions.g(!mediaPeriodId3.c());
            long jMax = Math.max(0L, playbackInfoJ.f43251r - (jLongValue - jP02));
            long j3 = playbackInfoJ.f43250q;
            if (playbackInfoJ.f43244k.equals(playbackInfoJ.f43235b)) {
                j3 = jLongValue + jMax;
            }
            PlaybackInfo playbackInfoD = playbackInfoJ.d(mediaPeriodId3, jLongValue, jLongValue, jLongValue, jMax, playbackInfoJ.f43241h, playbackInfoJ.f43242i, playbackInfoJ.f43243j);
            playbackInfoD.f43250q = j3;
            return playbackInfoD;
        }
        int iB = timeline.b(playbackInfoJ.f43244k.f44754a);
        if (iB != -1 && timeline.f(iB, this.f43019p).f41116c == timeline.h(mediaPeriodId.f44754a, this.f43019p).f41116c) {
            return playbackInfoJ;
        }
        timeline.h(mediaPeriodId.f44754a, this.f43019p);
        long jB = mediaPeriodId.c() ? this.f43019p.b(mediaPeriodId.f44755b, mediaPeriodId.f44756c) : this.f43019p.f41117d;
        MediaSource.MediaPeriodId mediaPeriodId4 = mediaPeriodId;
        PlaybackInfo playbackInfoC3 = playbackInfoJ.d(mediaPeriodId4, playbackInfoJ.f43252s, playbackInfoJ.f43252s, playbackInfoJ.f43237d, jB - playbackInfoJ.f43252s, playbackInfoJ.f43241h, playbackInfoJ.f43242i, playbackInfoJ.f43243j).c(mediaPeriodId4);
        playbackInfoC3.f43250q = jB;
        return playbackInfoC3;
    }

    private Pair X1(Timeline timeline, int i3, long j3) {
        if (timeline.q()) {
            this.f43034w0 = i3;
            if (j3 == -9223372036854775807L) {
                j3 = 0;
            }
            this.f43038y0 = j3;
            this.f43036x0 = 0;
            return null;
        }
        if (i3 == -1 || i3 >= timeline.p()) {
            i3 = timeline.a(this.K);
            j3 = timeline.n(i3, this.f40538a).b();
        }
        return timeline.j(this.f40538a, this.f43019p, i3, Util.P0(j3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y1(final int i3, final int i4) {
        if (i3 == this.f43000f0.b() && i4 == this.f43000f0.a()) {
            return;
        }
        this.f43000f0 = new Size(i3, i4);
        this.f43015n.j(24, new ListenerSet.Event() { // from class: androidx.media3.exoplayer.t0
            @Override // androidx.media3.common.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((Player.Listener) obj).V(i3, i4);
            }
        });
        e2(2, 14, new Size(i3, i4));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z1(int i3, final int i4) {
        r2();
        e2(1, 10, Integer.valueOf(i4));
        e2(2, 10, Integer.valueOf(i4));
        this.f43015n.j(21, new ListenerSet.Event() { // from class: androidx.media3.exoplayer.d1
            @Override // androidx.media3.common.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((Player.Listener) obj).F(i4);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a2(boolean z2) {
        if (this.f43024r0) {
            return;
        }
        if (!z2) {
            n2(this.f43032v0.f43245l, 1);
            return;
        }
        PlaybackInfo playbackInfo = this.f43032v0;
        if (playbackInfo.f43247n == 3) {
            n2(playbackInfo.f43245l, 1);
        }
    }

    private long b2(Timeline timeline, MediaSource.MediaPeriodId mediaPeriodId, long j3) {
        timeline.h(mediaPeriodId.f44754a, this.f43019p);
        return j3 + this.f43019p.o();
    }

    private void c2(int i3, int i4) {
        for (int i5 = i4 - 1; i5 >= i3; i5--) {
            this.f43021q.remove(i5);
        }
        this.P = this.P.a(i3, i4);
    }

    private void d2() {
        if (this.f42991a0 != null) {
            I1(this.B).m(ColorExtractionConstants.MAX_PIXEL_SAMPLES).l(null).k();
            this.f42991a0.f(this.A);
            this.f42991a0 = null;
        }
        TextureView textureView = this.f42995c0;
        if (textureView != null) {
            if (textureView.getSurfaceTextureListener() != this.A) {
                Log.i("ExoPlayerImpl", "SurfaceTextureListener already unset or replaced.");
            } else {
                this.f42995c0.setSurfaceTextureListener(null);
            }
            this.f42995c0 = null;
        }
        SurfaceHolder surfaceHolder = this.Z;
        if (surfaceHolder != null) {
            surfaceHolder.removeCallback(this.A);
            this.Z = null;
        }
    }

    private void e2(int i3, int i4, Object obj) {
        for (Renderer renderer : this.f43003h) {
            if (i3 == -1 || renderer.g() == i3) {
                I1(renderer).m(i4).l(obj).k();
            }
        }
        for (Renderer renderer2 : this.f43005i) {
            if (renderer2 != null && (i3 == -1 || renderer2.g() == i3)) {
                I1(renderer2).m(i4).l(obj).k();
            }
        }
    }

    private void f2(int i3, Object obj) {
        e2(-1, i3, obj);
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00a5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void i2(java.util.List r15, int r16, long r17, boolean r19) {
        /*
            r14 = this;
            r1 = r16
            androidx.media3.exoplayer.PlaybackInfo r2 = r14.f43032v0
            int r2 = r14.O1(r2)
            long r3 = r14.getCurrentPosition()
            int r5 = r14.L
            r6 = 1
            int r5 = r5 + r6
            r14.L = r5
            java.util.List r5 = r14.f43021q
            boolean r5 = r5.isEmpty()
            r7 = 0
            if (r5 != 0) goto L24
            java.util.List r5 = r14.f43021q
            int r5 = r5.size()
            r14.c2(r7, r5)
        L24:
            java.util.List r9 = r14.C1(r7, r15)
            androidx.media3.common.Timeline r5 = r14.G1()
            boolean r8 = r5.q()
            if (r8 != 0) goto L38
            int r8 = r5.p()
            if (r1 >= r8) goto L3b
        L38:
            r10 = r17
            goto L43
        L3b:
            androidx.media3.common.IllegalSeekPositionException r2 = new androidx.media3.common.IllegalSeekPositionException
            r10 = r17
            r2.<init>(r5, r1, r10)
            throw r2
        L43:
            r8 = -1
            if (r19 == 0) goto L53
            boolean r1 = r14.K
            int r1 = r5.a(r1)
            r2 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
        L51:
            r10 = r1
            goto L5a
        L53:
            if (r1 != r8) goto L58
            r10 = r2
            r2 = r3
            goto L5a
        L58:
            r2 = r10
            goto L51
        L5a:
            androidx.media3.exoplayer.PlaybackInfo r1 = r14.f43032v0
            android.util.Pair r4 = r14.X1(r5, r10, r2)
            androidx.media3.exoplayer.PlaybackInfo r1 = r14.W1(r1, r5, r4)
            int r4 = r1.f43238e
            if (r10 == r8) goto L7a
            if (r4 == r6) goto L7a
            boolean r4 = r5.q()
            if (r4 != 0) goto L79
            int r4 = r5.p()
            if (r10 < r4) goto L77
            goto L79
        L77:
            r4 = 2
            goto L7a
        L79:
            r4 = 4
        L7a:
            androidx.media3.exoplayer.PlaybackInfo r1 = V1(r1, r4)
            androidx.media3.exoplayer.ExoPlayerImplInternal r8 = r14.f43013m
            long r11 = androidx.media3.common.util.Util.P0(r2)
            androidx.media3.exoplayer.source.ShuffleOrder r13 = r14.P
            r8.e1(r9, r10, r11, r13)
            androidx.media3.exoplayer.PlaybackInfo r2 = r14.f43032v0
            androidx.media3.exoplayer.source.MediaSource$MediaPeriodId r2 = r2.f43235b
            java.lang.Object r2 = r2.f44754a
            androidx.media3.exoplayer.source.MediaSource$MediaPeriodId r3 = r1.f43235b
            java.lang.Object r3 = r3.f44754a
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto La5
            androidx.media3.exoplayer.PlaybackInfo r2 = r14.f43032v0
            androidx.media3.common.Timeline r2 = r2.f43234a
            boolean r2 = r2.q()
            if (r2 != 0) goto La5
            r3 = r6
            goto La6
        La5:
            r3 = r7
        La6:
            long r5 = r14.N1(r1)
            r7 = -1
            r8 = 0
            r2 = 0
            r4 = 4
            r0 = r14
            r0.o2(r1, r2, r3, r4, r5, r7, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.ExoPlayerImpl.i2(java.util.List, int, long, boolean):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j2(SurfaceTexture surfaceTexture) {
        Surface surface = new Surface(surfaceTexture);
        k2(surface);
        this.Y = surface;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k2(Object obj) {
        Object obj2 = this.X;
        boolean z2 = (obj2 == null || obj2 == obj) ? false : true;
        boolean zQ1 = this.f43013m.q1(obj, z2 ? this.G : -9223372036854775807L);
        if (z2) {
            Object obj3 = this.X;
            Surface surface = this.Y;
            if (obj3 == surface) {
                surface.release();
                this.Y = null;
            }
        }
        this.X = obj;
        if (zQ1) {
            return;
        }
        l2(ExoPlaybackException.f(new ExoTimeoutException(3), 1003));
    }

    private void l2(ExoPlaybackException exoPlaybackException) {
        PlaybackInfo playbackInfo = this.f43032v0;
        PlaybackInfo playbackInfoC = playbackInfo.c(playbackInfo.f43235b);
        playbackInfoC.f43250q = playbackInfoC.f43252s;
        playbackInfoC.f43251r = 0L;
        PlaybackInfo playbackInfoV1 = V1(playbackInfoC, 1);
        if (exoPlaybackException != null) {
            playbackInfoV1 = playbackInfoV1.f(exoPlaybackException);
        }
        this.L++;
        this.f43013m.z1();
        o2(playbackInfoV1, 0, false, 5, -9223372036854775807L, -1, false);
    }

    private void m2() {
        Player.Commands commands = this.S;
        Player.Commands commandsR = Util.R(this.f43001g, this.f42994c);
        this.S = commandsR;
        if (commandsR.equals(commands)) {
            return;
        }
        this.f43015n.h(13, new ListenerSet.Event() { // from class: androidx.media3.exoplayer.v0
            @Override // androidx.media3.common.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((Player.Listener) obj).W(this.f45657a.S);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n2(boolean z2, int i3) {
        int iE1 = E1(z2);
        PlaybackInfo playbackInfoA = this.f43032v0;
        if (playbackInfoA.f43245l == z2 && playbackInfoA.f43247n == iE1 && playbackInfoA.f43246m == i3) {
            return;
        }
        this.L++;
        if (playbackInfoA.f43249p) {
            playbackInfoA = playbackInfoA.a();
        }
        PlaybackInfo playbackInfoE = playbackInfoA.e(z2, i3, iE1);
        this.f43013m.h1(z2, i3, iE1);
        o2(playbackInfoE, 0, false, 5, -9223372036854775807L, -1, false);
    }

    private void o2(final PlaybackInfo playbackInfo, final int i3, boolean z2, final int i4, long j3, int i5, boolean z3) {
        PlaybackInfo playbackInfo2 = this.f43032v0;
        this.f43032v0 = playbackInfo;
        boolean zEquals = playbackInfo2.f43234a.equals(playbackInfo.f43234a);
        Pair pairJ1 = J1(playbackInfo, playbackInfo2, z2, i4, !zEquals, z3);
        boolean zBooleanValue = ((Boolean) pairJ1.first).booleanValue();
        final int iIntValue = ((Integer) pairJ1.second).intValue();
        if (zBooleanValue) {
            mediaItem = playbackInfo.f43234a.q() ? null : playbackInfo.f43234a.n(playbackInfo.f43234a.h(playbackInfo.f43235b.f44754a, this.f43019p).f41116c, this.f40538a).f41137c;
            this.f43030u0 = MediaMetadata.K;
        }
        if (zBooleanValue || !playbackInfo2.f43243j.equals(playbackInfo.f43243j)) {
            this.f43030u0 = this.f43030u0.a().N(playbackInfo.f43243j).J();
        }
        MediaMetadata mediaMetadataD1 = D1();
        boolean zEquals2 = mediaMetadataD1.equals(this.T);
        this.T = mediaMetadataD1;
        boolean z4 = playbackInfo2.f43245l != playbackInfo.f43245l;
        boolean z5 = playbackInfo2.f43238e != playbackInfo.f43238e;
        if (z5 || z4) {
            q2();
        }
        boolean z6 = playbackInfo2.f43240g;
        boolean z7 = playbackInfo.f43240g;
        boolean z8 = z6 != z7;
        if (z8) {
            p2(z7);
        }
        if (!zEquals) {
            this.f43015n.h(0, new ListenerSet.Event() { // from class: androidx.media3.exoplayer.o0
                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    Player.Listener listener = (Player.Listener) obj;
                    listener.j0(playbackInfo.f43234a, i3);
                }
            });
        }
        if (z2) {
            final Player.PositionInfo positionInfoR1 = R1(i4, playbackInfo2, i5);
            final Player.PositionInfo positionInfoQ1 = Q1(j3);
            this.f43015n.h(11, new ListenerSet.Event() { // from class: androidx.media3.exoplayer.h1
                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    ExoPlayerImpl.U0(i4, positionInfoR1, positionInfoQ1, (Player.Listener) obj);
                }
            });
        }
        if (zBooleanValue) {
            this.f43015n.h(1, new ListenerSet.Event() { // from class: androidx.media3.exoplayer.i1
                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    ((Player.Listener) obj).Q(mediaItem, iIntValue);
                }
            });
        }
        if (playbackInfo2.f43239f != playbackInfo.f43239f) {
            this.f43015n.h(10, new ListenerSet.Event() { // from class: androidx.media3.exoplayer.j1
                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    ((Player.Listener) obj).q0(playbackInfo.f43239f);
                }
            });
            if (playbackInfo.f43239f != null) {
                this.f43015n.h(10, new ListenerSet.Event() { // from class: androidx.media3.exoplayer.k1
                    @Override // androidx.media3.common.util.ListenerSet.Event
                    public final void invoke(Object obj) {
                        ((Player.Listener) obj).T(playbackInfo.f43239f);
                    }
                });
            }
        }
        TrackSelectorResult trackSelectorResult = playbackInfo2.f43242i;
        TrackSelectorResult trackSelectorResult2 = playbackInfo.f43242i;
        if (trackSelectorResult != trackSelectorResult2) {
            this.f43007j.i(trackSelectorResult2.f45459e);
            this.f43015n.h(2, new ListenerSet.Event() { // from class: androidx.media3.exoplayer.l1
                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    ((Player.Listener) obj).o0(playbackInfo.f43242i.f45458d);
                }
            });
        }
        if (!zEquals2) {
            final MediaMetadata mediaMetadata = this.T;
            this.f43015n.h(14, new ListenerSet.Event() { // from class: androidx.media3.exoplayer.p0
                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    ((Player.Listener) obj).M(mediaMetadata);
                }
            });
        }
        if (z8) {
            this.f43015n.h(3, new ListenerSet.Event() { // from class: androidx.media3.exoplayer.q0
                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    ExoPlayerImpl.D0(playbackInfo, (Player.Listener) obj);
                }
            });
        }
        if (z5 || z4) {
            this.f43015n.h(-1, new ListenerSet.Event() { // from class: androidx.media3.exoplayer.r0
                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    PlaybackInfo playbackInfo3 = playbackInfo;
                    ((Player.Listener) obj).l0(playbackInfo3.f43245l, playbackInfo3.f43238e);
                }
            });
        }
        if (z5) {
            this.f43015n.h(4, new ListenerSet.Event() { // from class: androidx.media3.exoplayer.s0
                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    ((Player.Listener) obj).G(playbackInfo.f43238e);
                }
            });
        }
        if (z4 || playbackInfo2.f43246m != playbackInfo.f43246m) {
            this.f43015n.h(5, new ListenerSet.Event() { // from class: androidx.media3.exoplayer.z0
                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    PlaybackInfo playbackInfo3 = playbackInfo;
                    ((Player.Listener) obj).s0(playbackInfo3.f43245l, playbackInfo3.f43246m);
                }
            });
        }
        if (playbackInfo2.f43247n != playbackInfo.f43247n) {
            this.f43015n.h(6, new ListenerSet.Event() { // from class: androidx.media3.exoplayer.e1
                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    ((Player.Listener) obj).B(playbackInfo.f43247n);
                }
            });
        }
        if (playbackInfo2.n() != playbackInfo.n()) {
            this.f43015n.h(7, new ListenerSet.Event() { // from class: androidx.media3.exoplayer.f1
                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    ((Player.Listener) obj).w0(playbackInfo.n());
                }
            });
        }
        if (!playbackInfo2.f43248o.equals(playbackInfo.f43248o)) {
            this.f43015n.h(12, new ListenerSet.Event() { // from class: androidx.media3.exoplayer.g1
                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    ((Player.Listener) obj).j(playbackInfo.f43248o);
                }
            });
        }
        m2();
        this.f43015n.f();
        if (playbackInfo2.f43249p != playbackInfo.f43249p) {
            Iterator it = this.f43017o.iterator();
            while (it.hasNext()) {
                ((ExoPlayer.AudioOffloadListener) it.next()).F(playbackInfo.f43249p);
            }
        }
    }

    private void p2(boolean z2) {
        PriorityTaskManager priorityTaskManager = this.f43020p0;
        if (priorityTaskManager != null) {
            if (z2 && !this.f43022q0) {
                priorityTaskManager.a(this.f43018o0);
                this.f43022q0 = true;
            } else {
                if (z2 || !this.f43022q0) {
                    return;
                }
                priorityTaskManager.d(this.f43018o0);
                this.f43022q0 = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q2() {
        int iP = p();
        boolean z2 = false;
        if (iP != 1) {
            if (iP == 2 || iP == 3) {
                boolean zU1 = U1();
                WakeLockManager wakeLockManager = this.E;
                if (L() && !zU1) {
                    z2 = true;
                }
                wakeLockManager.d(z2);
                this.F.d(L());
                return;
            }
            if (iP != 4) {
                throw new IllegalStateException();
            }
        }
        this.E.d(false);
        this.F.d(false);
    }

    private void r2() {
        this.f42996d.c();
        if (Thread.currentThread() != K1().getThread()) {
            String strJ = Util.J("Player is accessed on the wrong thread.\nCurrent thread: '%s'\nExpected thread: '%s'\nSee https://developer.android.com/guide/topics/media/issues/player-accessed-on-wrong-thread", Thread.currentThread().getName(), K1().getThread().getName());
            if (this.f43014m0) {
                throw new IllegalStateException(strJ);
            }
            Log.j("ExoPlayerImpl", strJ, this.f43016n0 ? null : new IllegalStateException());
            this.f43016n0 = true;
        }
    }

    public void A1(AnalyticsListener analyticsListener) {
        this.f43027t.d0((AnalyticsListener) Assertions.e(analyticsListener));
    }

    @Override // androidx.media3.common.Player
    public void B(Player.Listener listener) {
        this.f43015n.c((Player.Listener) Assertions.e(listener));
    }

    public void B1(ExoPlayer.AudioOffloadListener audioOffloadListener) {
        this.f43017o.add(audioOffloadListener);
    }

    @Override // androidx.media3.common.Player
    public int C() {
        r2();
        return this.f43032v0.f43247n;
    }

    @Override // androidx.media3.common.Player
    public int D() {
        r2();
        return this.J;
    }

    @Override // androidx.media3.common.Player
    public Timeline E() {
        r2();
        return this.f43032v0.f43234a;
    }

    @Override // androidx.media3.exoplayer.ExoPlayer
    public boolean F() {
        r2();
        return this.f43024r0;
    }

    @Override // androidx.media3.common.Player
    public TrackSelectionParameters G() {
        r2();
        return this.f43007j.c();
    }

    @Override // androidx.media3.common.Player
    public int I() {
        r2();
        StreamVolumeManager streamVolumeManager = this.D;
        if (streamVolumeManager != null) {
            return streamVolumeManager.k();
        }
        return 0;
    }

    @Override // androidx.media3.common.Player
    public Player.Commands K() {
        r2();
        return this.S;
    }

    public Looper K1() {
        return this.f43029u;
    }

    @Override // androidx.media3.common.Player
    public boolean L() {
        r2();
        return this.f43032v0.f43245l;
    }

    public Clock L1() {
        return this.f43039z;
    }

    @Override // androidx.media3.common.Player
    public long M() {
        r2();
        return this.f43037y;
    }

    @Override // androidx.media3.common.Player
    public int N() {
        r2();
        if (this.f43032v0.f43234a.q()) {
            return this.f43036x0;
        }
        PlaybackInfo playbackInfo = this.f43032v0;
        return playbackInfo.f43234a.b(playbackInfo.f43235b.f44754a);
    }

    @Override // androidx.media3.common.Player
    public VideoSize O() {
        r2();
        return this.f43028t0;
    }

    public Looper P1() {
        return this.f43013m.K();
    }

    @Override // androidx.media3.common.Player
    public AudioAttributes Q() {
        r2();
        return this.f43006i0;
    }

    @Override // androidx.media3.common.Player
    public DeviceInfo R() {
        r2();
        return this.f43026s0;
    }

    @Override // androidx.media3.common.Player
    public int T() {
        r2();
        if (f()) {
            return this.f43032v0.f43235b.f44756c;
        }
        return -1;
    }

    @Override // androidx.media3.common.Player
    public void U(List list, int i3, long j3) {
        r2();
        g2(H1(list), i3, j3);
    }

    public boolean U1() {
        r2();
        return this.f43032v0.f43249p;
    }

    @Override // androidx.media3.common.Player
    public long V() {
        r2();
        return this.f43035x;
    }

    @Override // androidx.media3.exoplayer.ExoPlayer
    public DecoderCounters W() {
        r2();
        return this.f43002g0;
    }

    @Override // androidx.media3.common.Player
    public long X() {
        r2();
        return M1(this.f43032v0);
    }

    @Override // androidx.media3.exoplayer.ExoPlayer
    public Format Y() {
        r2();
        return this.W;
    }

    @Override // androidx.media3.common.Player
    public long Z() {
        r2();
        if (!f()) {
            return i0();
        }
        PlaybackInfo playbackInfo = this.f43032v0;
        return playbackInfo.f43244k.equals(playbackInfo.f43235b) ? Util.t1(this.f43032v0.f43250q) : getDuration();
    }

    @Override // androidx.media3.common.Player
    public boolean a() {
        r2();
        return this.f43032v0.f43240g;
    }

    @Override // androidx.media3.exoplayer.ExoPlayer
    public Format c() {
        r2();
        return this.V;
    }

    @Override // androidx.media3.common.Player
    public MediaMetadata c0() {
        r2();
        return this.U;
    }

    @Override // androidx.media3.common.Player
    public PlaybackParameters d() {
        r2();
        return this.f43032v0.f43248o;
    }

    @Override // androidx.media3.common.Player
    public void e() {
        r2();
        PlaybackInfo playbackInfo = this.f43032v0;
        if (playbackInfo.f43238e != 1) {
            return;
        }
        PlaybackInfo playbackInfoF = playbackInfo.f(null);
        PlaybackInfo playbackInfoV1 = V1(playbackInfoF, playbackInfoF.f43234a.q() ? 4 : 2);
        this.L++;
        this.f43013m.y0();
        o2(playbackInfoV1, 1, false, 5, -9223372036854775807L, -1, false);
    }

    @Override // androidx.media3.common.Player
    public boolean f() {
        r2();
        return this.f43032v0.f43235b.c();
    }

    @Override // androidx.media3.common.Player
    public int f0() {
        r2();
        int iO1 = O1(this.f43032v0);
        if (iO1 == -1) {
            return 0;
        }
        return iO1;
    }

    @Override // androidx.media3.common.Player
    public long g() {
        r2();
        return Util.t1(this.f43032v0.f43251r);
    }

    @Override // androidx.media3.common.Player
    public boolean g0() {
        r2();
        StreamVolumeManager streamVolumeManager = this.D;
        if (streamVolumeManager != null) {
            return streamVolumeManager.l();
        }
        return false;
    }

    public void g2(List list, int i3, long j3) {
        r2();
        i2(list, i3, j3, false);
    }

    @Override // androidx.media3.common.Player
    public long getCurrentPosition() {
        r2();
        return Util.t1(N1(this.f43032v0));
    }

    @Override // androidx.media3.common.Player
    public long getDuration() {
        r2();
        if (!f()) {
            return q0();
        }
        PlaybackInfo playbackInfo = this.f43032v0;
        MediaSource.MediaPeriodId mediaPeriodId = playbackInfo.f43235b;
        playbackInfo.f43234a.h(mediaPeriodId.f44754a, this.f43019p);
        return Util.t1(this.f43019p.b(mediaPeriodId.f44755b, mediaPeriodId.f44756c));
    }

    @Override // androidx.media3.common.Player
    public float getVolume() {
        r2();
        return this.f43008j0;
    }

    @Override // androidx.media3.common.Player
    public boolean h0() {
        r2();
        return this.K;
    }

    public void h2(List list, boolean z2) {
        r2();
        i2(list, -1, -9223372036854775807L, z2);
    }

    @Override // androidx.media3.common.Player
    public long i0() {
        r2();
        if (this.f43032v0.f43234a.q()) {
            return this.f43038y0;
        }
        PlaybackInfo playbackInfo = this.f43032v0;
        if (playbackInfo.f43244k.f44757d != playbackInfo.f43235b.f44757d) {
            return playbackInfo.f43234a.n(f0(), this.f40538a).d();
        }
        long j3 = playbackInfo.f43250q;
        if (this.f43032v0.f43244k.c()) {
            PlaybackInfo playbackInfo2 = this.f43032v0;
            Timeline.Period periodH = playbackInfo2.f43234a.h(playbackInfo2.f43244k.f44754a, this.f43019p);
            long jF = periodH.f(this.f43032v0.f43244k.f44755b);
            j3 = jF == Long.MIN_VALUE ? periodH.f41117d : jF;
        }
        PlaybackInfo playbackInfo3 = this.f43032v0;
        return Util.t1(b2(playbackInfo3.f43234a, playbackInfo3.f43244k, j3));
    }

    @Override // androidx.media3.common.Player
    public void k(List list, boolean z2) {
        r2();
        h2(H1(list), z2);
    }

    @Override // androidx.media3.exoplayer.ExoPlayer
    public DecoderCounters k0() {
        r2();
        return this.f43004h0;
    }

    @Override // androidx.media3.common.Player
    public Size l() {
        r2();
        return this.f43000f0;
    }

    @Override // androidx.media3.common.Player
    public MediaMetadata m0() {
        r2();
        return this.T;
    }

    @Override // androidx.media3.common.Player
    public void n(boolean z2) {
        r2();
        n2(z2, 1);
    }

    @Override // androidx.media3.common.Player
    public long o0() {
        r2();
        return this.f43033w;
    }

    @Override // androidx.media3.common.Player
    public int p() {
        r2();
        return this.f43032v0.f43238e;
    }

    @Override // androidx.media3.exoplayer.ExoPlayer
    public void release() {
        Log.g("ExoPlayerImpl", "Release " + Integer.toHexString(System.identityHashCode(this)) + " [AndroidXMedia3/1.7.1] [" + Util.f41613e + "] [" + MediaLibraryInfo.b() + "]");
        r2();
        this.C.d(false);
        StreamVolumeManager streamVolumeManager = this.D;
        if (streamVolumeManager != null) {
            streamVolumeManager.n();
        }
        this.E.d(false);
        this.F.d(false);
        SuitableOutputChecker suitableOutputChecker = this.H;
        if (suitableOutputChecker != null) {
            suitableOutputChecker.c();
        }
        if (!this.f43013m.A0()) {
            this.f43015n.j(10, new ListenerSet.Event() { // from class: androidx.media3.exoplayer.u0
                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    ((Player.Listener) obj).T(ExoPlaybackException.f(new ExoTimeoutException(1), 1003));
                }
            });
        }
        this.f43015n.i();
        this.f43009k.f(null);
        this.f43031v.a(this.f43027t);
        PlaybackInfo playbackInfo = this.f43032v0;
        if (playbackInfo.f43249p) {
            this.f43032v0 = playbackInfo.a();
        }
        PlaybackInfo playbackInfoV1 = V1(this.f43032v0, 1);
        this.f43032v0 = playbackInfoV1;
        PlaybackInfo playbackInfoC = playbackInfoV1.c(playbackInfoV1.f43235b);
        this.f43032v0 = playbackInfoC;
        playbackInfoC.f43250q = playbackInfoC.f43252s;
        this.f43032v0.f43251r = 0L;
        this.f43027t.release();
        d2();
        Surface surface = this.Y;
        if (surface != null) {
            surface.release();
            this.Y = null;
        }
        if (this.f43022q0) {
            ((PriorityTaskManager) Assertions.e(this.f43020p0)).d(this.f43018o0);
            this.f43022q0 = false;
        }
        this.f43012l0 = CueGroup.f41450c;
        this.f43024r0 = true;
    }

    @Override // androidx.media3.common.Player
    public Tracks s() {
        r2();
        return this.f43032v0.f43242i.f45458d;
    }

    @Override // androidx.media3.common.Player
    public void stop() {
        r2();
        l2(null);
        this.f43012l0 = new CueGroup(ImmutableList.y(), this.f43032v0.f43252s);
    }

    @Override // androidx.media3.common.Player
    public CueGroup u() {
        r2();
        return this.f43012l0;
    }

    @Override // androidx.media3.common.BasePlayer
    protected void w0(int i3, long j3, int i4, boolean z2) {
        r2();
        if (i3 == -1) {
            return;
        }
        Assertions.a(i3 >= 0);
        Timeline timeline = this.f43032v0.f43234a;
        if (timeline.q() || i3 < timeline.p()) {
            this.f43027t.I();
            this.L++;
            if (f()) {
                Log.i("ExoPlayerImpl", "seekTo ignored because an ad is playing");
                ExoPlayerImplInternal.PlaybackInfoUpdate playbackInfoUpdate = new ExoPlayerImplInternal.PlaybackInfoUpdate(this.f43032v0);
                playbackInfoUpdate.b(1);
                this.f43011l.a(playbackInfoUpdate);
                return;
            }
            PlaybackInfo playbackInfoV1 = this.f43032v0;
            int i5 = playbackInfoV1.f43238e;
            if (i5 == 3 || (i5 == 4 && !timeline.q())) {
                playbackInfoV1 = V1(this.f43032v0, 2);
            }
            int iF0 = f0();
            PlaybackInfo playbackInfoW1 = W1(playbackInfoV1, timeline, X1(timeline, i3, j3));
            this.f43013m.Q0(timeline, i3, Util.P0(j3));
            o2(playbackInfoW1, 0, true, 1, N1(playbackInfoW1), iF0, z2);
        }
    }

    @Override // androidx.media3.common.Player
    public int x() {
        r2();
        if (f()) {
            return this.f43032v0.f43235b.f44755b;
        }
        return -1;
    }

    @Override // androidx.media3.common.Player
    public ExoPlaybackException b() {
        r2();
        return this.f43032v0.f43239f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    final class ComponentListener implements VideoRendererEventListener, AudioRendererEventListener, TextOutput, MetadataOutput, SurfaceHolder.Callback, TextureView.SurfaceTextureListener, SphericalGLSurfaceView.VideoSurfaceListener, AudioBecomingNoisyManager.EventListener, StreamVolumeManager.Listener, ExoPlayer.AudioOffloadListener {
        private ComponentListener() {
        }

        @Override // androidx.media3.exoplayer.video.VideoRendererEventListener
        public void A(long j3, int i3) {
            ExoPlayerImpl.this.f43027t.A(j3, i3);
        }

        @Override // androidx.media3.exoplayer.video.spherical.SphericalGLSurfaceView.VideoSurfaceListener
        public void B(Surface surface) {
            ExoPlayerImpl.this.k2(null);
        }

        @Override // androidx.media3.exoplayer.video.spherical.SphericalGLSurfaceView.VideoSurfaceListener
        public void D(Surface surface) {
            ExoPlayerImpl.this.k2(surface);
        }

        @Override // androidx.media3.exoplayer.StreamVolumeManager.Listener
        public void E(final int i3, final boolean z2) {
            ExoPlayerImpl.this.f43015n.j(30, new ListenerSet.Event() { // from class: androidx.media3.exoplayer.u1
                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    ((Player.Listener) obj).K(i3, z2);
                }
            });
        }

        @Override // androidx.media3.exoplayer.ExoPlayer.AudioOffloadListener
        public void F(boolean z2) {
            ExoPlayerImpl.this.q2();
        }

        @Override // androidx.media3.exoplayer.audio.AudioRendererEventListener
        public void a(AudioSink.AudioTrackConfig audioTrackConfig) {
            ExoPlayerImpl.this.f43027t.a(audioTrackConfig);
        }

        @Override // androidx.media3.exoplayer.video.VideoRendererEventListener
        public void b(final VideoSize videoSize) {
            ExoPlayerImpl.this.f43028t0 = videoSize;
            ExoPlayerImpl.this.f43015n.j(25, new ListenerSet.Event() { // from class: androidx.media3.exoplayer.r1
                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    ((Player.Listener) obj).b(videoSize);
                }
            });
        }

        @Override // androidx.media3.exoplayer.audio.AudioRendererEventListener
        public void c(AudioSink.AudioTrackConfig audioTrackConfig) {
            ExoPlayerImpl.this.f43027t.c(audioTrackConfig);
        }

        @Override // androidx.media3.exoplayer.audio.AudioRendererEventListener
        public void d(final boolean z2) {
            if (ExoPlayerImpl.this.f43010k0 == z2) {
                return;
            }
            ExoPlayerImpl.this.f43010k0 = z2;
            ExoPlayerImpl.this.f43015n.j(23, new ListenerSet.Event() { // from class: androidx.media3.exoplayer.s1
                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    ((Player.Listener) obj).d(z2);
                }
            });
        }

        @Override // androidx.media3.exoplayer.audio.AudioRendererEventListener
        public void e(Exception exc) {
            ExoPlayerImpl.this.f43027t.e(exc);
        }

        @Override // androidx.media3.exoplayer.video.VideoRendererEventListener
        public void f(String str) {
            ExoPlayerImpl.this.f43027t.f(str);
        }

        @Override // androidx.media3.exoplayer.video.VideoRendererEventListener
        public void g(String str, long j3, long j4) {
            ExoPlayerImpl.this.f43027t.g(str, j3, j4);
        }

        @Override // androidx.media3.exoplayer.audio.AudioRendererEventListener
        public void h(String str) {
            ExoPlayerImpl.this.f43027t.h(str);
        }

        @Override // androidx.media3.exoplayer.audio.AudioRendererEventListener
        public void i(String str, long j3, long j4) {
            ExoPlayerImpl.this.f43027t.i(str, j3, j4);
        }

        @Override // androidx.media3.exoplayer.StreamVolumeManager.Listener
        public void j(int i3) {
            final DeviceInfo deviceInfoF1 = ExoPlayerImpl.F1(ExoPlayerImpl.this.D);
            if (deviceInfoF1.equals(ExoPlayerImpl.this.f43026s0)) {
                return;
            }
            ExoPlayerImpl.this.f43026s0 = deviceInfoF1;
            ExoPlayerImpl.this.f43015n.j(29, new ListenerSet.Event() { // from class: androidx.media3.exoplayer.t1
                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    ((Player.Listener) obj).p0(deviceInfoF1);
                }
            });
        }

        @Override // androidx.media3.exoplayer.audio.AudioRendererEventListener
        public void k(DecoderCounters decoderCounters) {
            ExoPlayerImpl.this.f43004h0 = decoderCounters;
            ExoPlayerImpl.this.f43027t.k(decoderCounters);
        }

        @Override // androidx.media3.exoplayer.video.VideoRendererEventListener
        public void l(DecoderCounters decoderCounters) {
            ExoPlayerImpl.this.f43002g0 = decoderCounters;
            ExoPlayerImpl.this.f43027t.l(decoderCounters);
        }

        @Override // androidx.media3.exoplayer.text.TextOutput
        public void m(final List list) {
            ExoPlayerImpl.this.f43015n.j(27, new ListenerSet.Event() { // from class: androidx.media3.exoplayer.q1
                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    ((Player.Listener) obj).m(list);
                }
            });
        }

        @Override // androidx.media3.exoplayer.audio.AudioRendererEventListener
        public void n(long j3) {
            ExoPlayerImpl.this.f43027t.n(j3);
        }

        @Override // androidx.media3.exoplayer.audio.AudioRendererEventListener
        public void o(Format format, DecoderReuseEvaluation decoderReuseEvaluation) {
            ExoPlayerImpl.this.W = format;
            ExoPlayerImpl.this.f43027t.o(format, decoderReuseEvaluation);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i3, int i4) {
            ExoPlayerImpl.this.j2(surfaceTexture);
            ExoPlayerImpl.this.Y1(i3, i4);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            ExoPlayerImpl.this.k2(null);
            ExoPlayerImpl.this.Y1(0, 0);
            return true;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i3, int i4) {
            ExoPlayerImpl.this.Y1(i3, i4);
        }

        @Override // androidx.media3.exoplayer.video.VideoRendererEventListener
        public void p(Exception exc) {
            ExoPlayerImpl.this.f43027t.p(exc);
        }

        @Override // androidx.media3.exoplayer.audio.AudioRendererEventListener
        public void q(DecoderCounters decoderCounters) {
            ExoPlayerImpl.this.f43027t.q(decoderCounters);
            ExoPlayerImpl.this.W = null;
            ExoPlayerImpl.this.f43004h0 = null;
        }

        @Override // androidx.media3.exoplayer.video.VideoRendererEventListener
        public void r(int i3, long j3) {
            ExoPlayerImpl.this.f43027t.r(i3, j3);
        }

        @Override // androidx.media3.exoplayer.video.VideoRendererEventListener
        public void s(Object obj, long j3) {
            ExoPlayerImpl.this.f43027t.s(obj, j3);
            if (ExoPlayerImpl.this.X == obj) {
                ExoPlayerImpl.this.f43015n.j(26, new androidx.media3.common.t());
            }
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(SurfaceHolder surfaceHolder, int i3, int i4, int i5) {
            ExoPlayerImpl.this.Y1(i4, i5);
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            if (ExoPlayerImpl.this.f42993b0) {
                ExoPlayerImpl.this.k2(surfaceHolder.getSurface());
            }
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            if (ExoPlayerImpl.this.f42993b0) {
                ExoPlayerImpl.this.k2(null);
            }
            ExoPlayerImpl.this.Y1(0, 0);
        }

        @Override // androidx.media3.exoplayer.text.TextOutput
        public void t(final CueGroup cueGroup) {
            ExoPlayerImpl.this.f43012l0 = cueGroup;
            ExoPlayerImpl.this.f43015n.j(27, new ListenerSet.Event() { // from class: androidx.media3.exoplayer.n1
                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    ((Player.Listener) obj).t(cueGroup);
                }
            });
        }

        @Override // androidx.media3.exoplayer.metadata.MetadataOutput
        public void u(final Metadata metadata) {
            ExoPlayerImpl exoPlayerImpl = ExoPlayerImpl.this;
            exoPlayerImpl.f43030u0 = exoPlayerImpl.f43030u0.a().M(metadata).J();
            MediaMetadata mediaMetadataD1 = ExoPlayerImpl.this.D1();
            if (!mediaMetadataD1.equals(ExoPlayerImpl.this.T)) {
                ExoPlayerImpl.this.T = mediaMetadataD1;
                ExoPlayerImpl.this.f43015n.h(14, new ListenerSet.Event() { // from class: androidx.media3.exoplayer.o1
                    @Override // androidx.media3.common.util.ListenerSet.Event
                    public final void invoke(Object obj) {
                        ((Player.Listener) obj).M(ExoPlayerImpl.this.T);
                    }
                });
            }
            ExoPlayerImpl.this.f43015n.h(28, new ListenerSet.Event() { // from class: androidx.media3.exoplayer.p1
                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    ((Player.Listener) obj).u(metadata);
                }
            });
            ExoPlayerImpl.this.f43015n.f();
        }

        @Override // androidx.media3.exoplayer.video.VideoRendererEventListener
        public void v(Format format, DecoderReuseEvaluation decoderReuseEvaluation) {
            ExoPlayerImpl.this.V = format;
            ExoPlayerImpl.this.f43027t.v(format, decoderReuseEvaluation);
        }

        @Override // androidx.media3.exoplayer.video.VideoRendererEventListener
        public void w(DecoderCounters decoderCounters) {
            ExoPlayerImpl.this.f43027t.w(decoderCounters);
            ExoPlayerImpl.this.V = null;
            ExoPlayerImpl.this.f43002g0 = null;
        }

        @Override // androidx.media3.exoplayer.audio.AudioRendererEventListener
        public void x(Exception exc) {
            ExoPlayerImpl.this.f43027t.x(exc);
        }

        @Override // androidx.media3.exoplayer.audio.AudioRendererEventListener
        public void y(int i3, long j3, long j4) {
            ExoPlayerImpl.this.f43027t.y(i3, j3, j4);
        }

        @Override // androidx.media3.exoplayer.AudioBecomingNoisyManager.EventListener
        public void z() {
            ExoPlayerImpl.this.n2(false, 3);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }
    }
}
