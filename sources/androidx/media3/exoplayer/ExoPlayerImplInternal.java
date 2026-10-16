package androidx.media3.exoplayer;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Pair;
import androidx.media3.common.AudioAttributes;
import androidx.media3.common.Format;
import androidx.media3.common.MediaItem;
import androidx.media3.common.Metadata;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.PlaybackParameters;
import androidx.media3.common.Timeline;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Clock;
import androidx.media3.common.util.HandlerWrapper;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.AudioFocusManager;
import androidx.media3.exoplayer.DefaultMediaClock;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.exoplayer.LoadControl;
import androidx.media3.exoplayer.LoadingInfo;
import androidx.media3.exoplayer.MediaPeriodHolder;
import androidx.media3.exoplayer.MediaSourceList;
import androidx.media3.exoplayer.PlayerMessage;
import androidx.media3.exoplayer.Renderer;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.media3.exoplayer.analytics.AnalyticsCollector;
import androidx.media3.exoplayer.analytics.PlayerId;
import androidx.media3.exoplayer.source.MediaPeriod;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.source.ShuffleOrder;
import androidx.media3.exoplayer.source.TrackGroupArray;
import androidx.media3.exoplayer.trackselection.ExoTrackSelection;
import androidx.media3.exoplayer.trackselection.TrackSelector;
import androidx.media3.exoplayer.trackselection.TrackSelectorResult;
import androidx.media3.exoplayer.upstream.BandwidthMeter;
import com.google.common.base.Supplier;
import com.google.common.collect.ImmutableList;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes2.dex */
final class ExoPlayerImplInternal implements Handler.Callback, MediaPeriod.Callback, TrackSelector.InvalidationListener, MediaSourceList.MediaSourceListInfoRefreshListener, DefaultMediaClock.PlaybackParametersListener, PlayerMessage.Sender, AudioFocusManager.PlayerControl {

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    private static final long f43048f0 = Util.t1(10000);
    private final HandlerWrapper A;
    private final boolean B;
    private final AudioFocusManager C;
    private SeekParameters D;
    private PlaybackInfo E;
    private PlaybackInfoUpdate F;
    private boolean G;
    private boolean H;
    private boolean I;
    private boolean J;
    private boolean L;
    private int M;
    private boolean N;
    private boolean O;
    private boolean P;
    private boolean Q;
    private int R;
    private SeekPosition S;
    private long T;
    private long U;
    private int V;
    private boolean W;
    private ExoPlaybackException X;
    private long Y;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final RendererHolder[] f43049a;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    private ExoPlayer.PreloadConfiguration f43050a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final RendererCapabilities[] f43051b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean[] f43053c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final TrackSelector f43055d;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    private boolean f43056d0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final TrackSelectorResult f43058f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final LoadControl f43059g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final BandwidthMeter f43060h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final HandlerWrapper f43061i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final PlaybackLooperProvider f43062j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final Looper f43063k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final Timeline.Window f43064l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final Timeline.Period f43065m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final long f43066n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final boolean f43067o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final DefaultMediaClock f43068p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final ArrayList f43069q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final Clock f43070r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final PlaybackInfoUpdateListener f43071s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final MediaPeriodQueue f43072t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final MediaSourceList f43073u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final LivePlaybackSpeedControl f43074v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final long f43075w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final PlayerId f43076x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final boolean f43077y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private final AnalyticsCollector f43078z;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    private long f43054c0 = -9223372036854775807L;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    private float f43057e0 = 1.0f;
    private long Z = -9223372036854775807L;
    private long K = -9223372036854775807L;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    private Timeline f43052b0 = Timeline.f41105a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes3.dex */
    private static final class MediaSourceListUpdateMessage {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List f43080a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ShuffleOrder f43081b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f43082c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final long f43083d;

        private MediaSourceListUpdateMessage(List list, ShuffleOrder shuffleOrder, int i3, long j3) {
            this.f43080a = list;
            this.f43081b = shuffleOrder;
            this.f43082c = i3;
            this.f43083d = j3;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes3.dex */
    private static class MoveMediaItemsMessage {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f43084a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f43085b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f43086c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final ShuffleOrder f43087d;
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes3.dex */
    private static final class PendingMessageInfo implements Comparable<PendingMessageInfo> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final PlayerMessage f43088a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f43089b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f43090c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Object f43091d;

        public PendingMessageInfo(PlayerMessage playerMessage) {
            this.f43088a = playerMessage;
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(PendingMessageInfo pendingMessageInfo) {
            Object obj = this.f43091d;
            if ((obj == null) != (pendingMessageInfo.f43091d == null)) {
                return obj != null ? -1 : 1;
            }
            if (obj == null) {
                return 0;
            }
            int i3 = this.f43089b - pendingMessageInfo.f43089b;
            return i3 != 0 ? i3 : Util.p(this.f43090c, pendingMessageInfo.f43090c);
        }

        public void b(int i3, long j3, Object obj) {
            this.f43089b = i3;
            this.f43090c = j3;
            this.f43091d = obj;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes3.dex */
    public static final class PlaybackInfoUpdate {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f43092a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public PlaybackInfo f43093b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f43094c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f43095d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f43096e;

        public PlaybackInfoUpdate(PlaybackInfo playbackInfo) {
            this.f43093b = playbackInfo;
        }

        public void b(int i3) {
            this.f43092a |= i3 > 0;
            this.f43094c += i3;
        }

        public void c(PlaybackInfo playbackInfo) {
            this.f43092a |= this.f43093b != playbackInfo;
            this.f43093b = playbackInfo;
        }

        public void d(int i3) {
            if (this.f43095d && this.f43096e != 5) {
                Assertions.a(i3 == 5);
                return;
            }
            this.f43092a = true;
            this.f43095d = true;
            this.f43096e = i3;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes3.dex */
    public interface PlaybackInfoUpdateListener {
        void a(PlaybackInfoUpdate playbackInfoUpdate);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes3.dex */
    private static final class PositionUpdateForPlaylistChange {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final MediaSource.MediaPeriodId f43097a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f43098b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f43099c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f43100d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final boolean f43101e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final boolean f43102f;

        public PositionUpdateForPlaylistChange(MediaSource.MediaPeriodId mediaPeriodId, long j3, long j4, boolean z2, boolean z3, boolean z4) {
            this.f43097a = mediaPeriodId;
            this.f43098b = j3;
            this.f43099c = j4;
            this.f43100d = z2;
            this.f43101e = z3;
            this.f43102f = z4;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes3.dex */
    private static final class SeekPosition {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Timeline f43103a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f43104b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f43105c;

        public SeekPosition(Timeline timeline, int i3, long j3) {
            this.f43103a = timeline;
            this.f43104b = i3;
            this.f43105c = j3;
        }
    }

    public ExoPlayerImplInternal(Context context, Renderer[] rendererArr, Renderer[] rendererArr2, TrackSelector trackSelector, TrackSelectorResult trackSelectorResult, LoadControl loadControl, BandwidthMeter bandwidthMeter, int i3, boolean z2, AnalyticsCollector analyticsCollector, SeekParameters seekParameters, LivePlaybackSpeedControl livePlaybackSpeedControl, long j3, boolean z3, boolean z4, Looper looper, Clock clock, PlaybackInfoUpdateListener playbackInfoUpdateListener, PlayerId playerId, PlaybackLooperProvider playbackLooperProvider, ExoPlayer.PreloadConfiguration preloadConfiguration) {
        this.f43071s = playbackInfoUpdateListener;
        this.f43055d = trackSelector;
        this.f43058f = trackSelectorResult;
        this.f43059g = loadControl;
        this.f43060h = bandwidthMeter;
        this.M = i3;
        this.N = z2;
        this.D = seekParameters;
        this.f43074v = livePlaybackSpeedControl;
        this.f43075w = j3;
        this.Y = j3;
        this.H = z3;
        this.f43077y = z4;
        this.f43070r = clock;
        this.f43076x = playerId;
        this.f43050a0 = preloadConfiguration;
        this.f43078z = analyticsCollector;
        this.f43066n = loadControl.q(playerId);
        this.f43067o = loadControl.o(playerId);
        PlaybackInfo playbackInfoK = PlaybackInfo.k(trackSelectorResult);
        this.E = playbackInfoK;
        this.F = new PlaybackInfoUpdate(playbackInfoK);
        this.f43051b = new RendererCapabilities[rendererArr.length];
        this.f43053c = new boolean[rendererArr.length];
        RendererCapabilities.Listener listenerD = trackSelector.d();
        this.f43049a = new RendererHolder[rendererArr.length];
        boolean z5 = false;
        for (int i4 = 0; i4 < rendererArr.length; i4++) {
            rendererArr[i4].o(i4, playerId, clock);
            this.f43051b[i4] = rendererArr[i4].H();
            if (listenerD != null) {
                this.f43051b[i4].I(listenerD);
            }
            Renderer renderer = rendererArr2[i4];
            if (renderer != null) {
                renderer.o(rendererArr.length + i4, playerId, clock);
                z5 = true;
            }
            this.f43049a[i4] = new RendererHolder(rendererArr[i4], rendererArr2[i4], i4);
        }
        this.B = z5;
        this.f43068p = new DefaultMediaClock(this, clock);
        this.f43069q = new ArrayList();
        this.f43064l = new Timeline.Window();
        this.f43065m = new Timeline.Period();
        trackSelector.e(this, bandwidthMeter);
        this.W = true;
        HandlerWrapper handlerWrapperD = clock.d(looper, null);
        this.A = handlerWrapperD;
        this.f43072t = new MediaPeriodQueue(analyticsCollector, handlerWrapperD, new MediaPeriodHolder.Factory() { // from class: androidx.media3.exoplayer.z1
            @Override // androidx.media3.exoplayer.MediaPeriodHolder.Factory
            public final MediaPeriodHolder a(MediaPeriodInfo mediaPeriodInfo, long j4) {
                return this.f46021a.v(mediaPeriodInfo, j4);
            }
        }, preloadConfiguration);
        this.f43073u = new MediaSourceList(this, analyticsCollector, handlerWrapperD, playerId);
        PlaybackLooperProvider playbackLooperProvider2 = playbackLooperProvider == null ? new PlaybackLooperProvider() : playbackLooperProvider;
        this.f43062j = playbackLooperProvider2;
        Looper looperA = playbackLooperProvider2.a();
        this.f43063k = looperA;
        this.f43061i = clock.d(looperA, this);
        this.C = new AudioFocusManager(context, looperA, this);
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0198  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x01ab  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x01b5  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x012b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A() throws androidx.media3.exoplayer.ExoPlaybackException {
        /*
            Method dump skipped, instruction units count: 461
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.ExoPlayerImplInternal.A():void");
    }

    private void A1(boolean z2, boolean z3) {
        G0(z2 || !this.O, false, true, false);
        this.F.b(z3 ? 1 : 0);
        this.f43059g.l(this.f43076x);
        this.C.n(this.E.f43245l, 1);
        p1(1);
    }

    private void B(MediaPeriodHolder mediaPeriodHolder, int i3, boolean z2, long j3) throws ExoPlaybackException {
        RendererHolder rendererHolder = this.f43049a[i3];
        if (rendererHolder.x()) {
            return;
        }
        boolean z3 = mediaPeriodHolder == this.f43072t.u();
        TrackSelectorResult trackSelectorResultP = mediaPeriodHolder.p();
        RendererConfiguration rendererConfiguration = trackSelectorResultP.f45456b[i3];
        ExoTrackSelection exoTrackSelection = trackSelectorResultP.f45457c[i3];
        boolean z4 = v1() && this.E.f43238e == 3;
        boolean z5 = !z2 && z4;
        this.R++;
        rendererHolder.e(rendererConfiguration, exoTrackSelection, mediaPeriodHolder.f43145c[i3], this.T, z5, z3, j3, mediaPeriodHolder.m(), mediaPeriodHolder.f43150h.f43160a, this.f43068p);
        rendererHolder.n(11, new Renderer.WakeupListener() { // from class: androidx.media3.exoplayer.ExoPlayerImplInternal.1
            @Override // androidx.media3.exoplayer.Renderer.WakeupListener
            public void a() {
                ExoPlayerImplInternal.this.P = true;
            }

            @Override // androidx.media3.exoplayer.Renderer.WakeupListener
            public void b() {
                if (ExoPlayerImplInternal.this.f43077y || ExoPlayerImplInternal.this.Q) {
                    ExoPlayerImplInternal.this.f43061i.k(2);
                }
            }
        }, mediaPeriodHolder);
        if (z4 && z3) {
            rendererHolder.U();
        }
    }

    private void B0() {
        try {
            G0(true, false, true, false);
            C0();
            this.f43059g.j(this.f43076x);
            this.C.h();
            this.f43055d.j();
            p1(1);
            this.f43062j.b();
            synchronized (this) {
                this.G = true;
                notifyAll();
            }
        } catch (Throwable th) {
            this.f43062j.b();
            synchronized (this) {
                this.G = true;
                notifyAll();
                throw th;
            }
        }
    }

    private void B1() {
        this.f43068p.h();
        for (RendererHolder rendererHolder : this.f43049a) {
            rendererHolder.W();
        }
    }

    private void C() throws ExoPlaybackException {
        D(new boolean[this.f43049a.length], this.f43072t.y().n());
    }

    private void C0() {
        for (int i3 = 0; i3 < this.f43049a.length; i3++) {
            this.f43051b[i3].j();
            this.f43049a[i3].H();
        }
    }

    private void C1() {
        MediaPeriodHolder mediaPeriodHolderN = this.f43072t.n();
        boolean z2 = this.L || (mediaPeriodHolderN != null && mediaPeriodHolderN.f43143a.a());
        PlaybackInfo playbackInfo = this.E;
        if (z2 != playbackInfo.f43240g) {
            this.E = playbackInfo.b(z2);
        }
    }

    private void D(boolean[] zArr, long j3) throws ExoPlaybackException {
        long j4;
        MediaPeriodHolder mediaPeriodHolderY = this.f43072t.y();
        TrackSelectorResult trackSelectorResultP = mediaPeriodHolderY.p();
        for (int i3 = 0; i3 < this.f43049a.length; i3++) {
            if (!trackSelectorResultP.c(i3)) {
                this.f43049a[i3].L();
            }
        }
        int i4 = 0;
        while (i4 < this.f43049a.length) {
            if (!trackSelectorResultP.c(i4) || this.f43049a[i4].w(mediaPeriodHolderY)) {
                j4 = j3;
            } else {
                j4 = j3;
                B(mediaPeriodHolderY, i4, zArr[i4], j4);
            }
            i4++;
            j3 = j4;
        }
    }

    private void D0(int i3, int i4, ShuffleOrder shuffleOrder) throws Throwable {
        this.F.b(1);
        T(this.f43073u.A(i3, i4, shuffleOrder), false);
    }

    private void D1(MediaSource.MediaPeriodId mediaPeriodId, TrackGroupArray trackGroupArray, TrackSelectorResult trackSelectorResult) {
        MediaPeriodHolder mediaPeriodHolder = (MediaPeriodHolder) Assertions.e(this.f43072t.n());
        this.f43059g.g(new LoadControl.Parameters(this.f43076x, this.E.f43234a, mediaPeriodId, mediaPeriodHolder == this.f43072t.u() ? mediaPeriodHolder.C(this.T) : mediaPeriodHolder.C(this.T) - mediaPeriodHolder.f43150h.f43161b, M(mediaPeriodHolder.j()), this.f43068p.d().f40953a, this.E.f43245l, this.J, x1(this.E.f43234a, mediaPeriodHolder.f43150h.f43160a) ? this.f43074v.c() : -9223372036854775807L, this.K), trackGroupArray, trackSelectorResult.f45457c);
    }

    private void E0() throws ExoPlaybackException {
        float f3 = this.f43068p.d().f40953a;
        MediaPeriodHolder mediaPeriodHolderY = this.f43072t.y();
        TrackSelectorResult trackSelectorResult = null;
        boolean z2 = true;
        for (MediaPeriodHolder mediaPeriodHolderU = this.f43072t.u(); mediaPeriodHolderU != null && mediaPeriodHolderU.f43148f; mediaPeriodHolderU = mediaPeriodHolderU.k()) {
            PlaybackInfo playbackInfo = this.E;
            TrackSelectorResult trackSelectorResultZ = mediaPeriodHolderU.z(f3, playbackInfo.f43234a, playbackInfo.f43245l);
            if (mediaPeriodHolderU == this.f43072t.u()) {
                trackSelectorResult = trackSelectorResultZ;
            }
            if (!trackSelectorResultZ.a(mediaPeriodHolderU.p())) {
                if (z2) {
                    MediaPeriodHolder mediaPeriodHolderU2 = this.f43072t.u();
                    boolean z3 = (this.f43072t.N(mediaPeriodHolderU2) & 1) != 0;
                    boolean[] zArr = new boolean[this.f43049a.length];
                    long jB = mediaPeriodHolderU2.b((TrackSelectorResult) Assertions.e(trackSelectorResult), this.E.f43252s, z3, zArr);
                    PlaybackInfo playbackInfo2 = this.E;
                    boolean z4 = (playbackInfo2.f43238e == 4 || jB == playbackInfo2.f43252s) ? false : true;
                    PlaybackInfo playbackInfo3 = this.E;
                    this.E = X(playbackInfo3.f43235b, jB, playbackInfo3.f43236c, playbackInfo3.f43237d, z4, 5);
                    if (z4) {
                        I0(jB);
                    }
                    x();
                    boolean[] zArr2 = new boolean[this.f43049a.length];
                    int i3 = 0;
                    while (true) {
                        RendererHolder[] rendererHolderArr = this.f43049a;
                        if (i3 >= rendererHolderArr.length) {
                            break;
                        }
                        int iH = rendererHolderArr[i3].h();
                        zArr2[i3] = this.f43049a[i3].x();
                        this.f43049a[i3].B(mediaPeriodHolderU2.f43145c[i3], this.f43068p, this.T, zArr[i3]);
                        if (iH - this.f43049a[i3].h() > 0) {
                            j0(i3, false);
                        }
                        this.R -= iH - this.f43049a[i3].h();
                        i3++;
                    }
                    D(zArr2, this.T);
                    mediaPeriodHolderU2.f43151i = true;
                } else {
                    this.f43072t.N(mediaPeriodHolderU);
                    if (mediaPeriodHolderU.f43148f) {
                        long jMax = Math.max(mediaPeriodHolderU.f43150h.f43161b, mediaPeriodHolderU.C(this.T));
                        if (this.B && t() && this.f43072t.x() == mediaPeriodHolderU) {
                            x();
                        }
                        mediaPeriodHolderU.a(trackSelectorResultZ, jMax, false);
                    }
                }
                R(true);
                if (this.E.f43238e != 4) {
                    d0();
                    K1();
                    this.f43061i.k(2);
                    return;
                }
                return;
            }
            if (mediaPeriodHolderU == mediaPeriodHolderY) {
                z2 = false;
            }
        }
    }

    private void E1(int i3, int i4, List list) throws Throwable {
        this.F.b(1);
        T(this.f43073u.E(i3, i4, list), false);
    }

    private ImmutableList F(ExoTrackSelection[] exoTrackSelectionArr) {
        ImmutableList.Builder builder = new ImmutableList.Builder();
        boolean z2 = false;
        for (ExoTrackSelection exoTrackSelection : exoTrackSelectionArr) {
            if (exoTrackSelection != null) {
                Metadata metadata = exoTrackSelection.b(0).f40629l;
                if (metadata == null) {
                    builder.a(new Metadata(new Metadata.Entry[0]));
                } else {
                    builder.a(metadata);
                    z2 = true;
                }
            }
        }
        return z2 ? builder.m() : ImmutableList.y();
    }

    private void F0() throws ExoPlaybackException {
        E0();
        R0(true);
    }

    private void F1() throws ExoPlaybackException {
        if (this.E.f43234a.q() || !this.f43073u.t()) {
            return;
        }
        boolean zL0 = l0();
        p0();
        q0();
        r0();
        n0();
        o0(zL0);
    }

    private long G() {
        PlaybackInfo playbackInfo = this.E;
        return H(playbackInfo.f43234a, playbackInfo.f43235b.f44754a, playbackInfo.f43252s);
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0091 A[PHI: r2 r6 r8
      0x0091: PHI (r2v2 androidx.media3.exoplayer.source.MediaSource$MediaPeriodId) = 
      (r2v1 androidx.media3.exoplayer.source.MediaSource$MediaPeriodId)
      (r2v12 androidx.media3.exoplayer.source.MediaSource$MediaPeriodId)
     binds: [B:25:0x0067, B:27:0x008c] A[DONT_GENERATE, DONT_INLINE]
      0x0091: PHI (r6v3 long) = (r6v2 long), (r6v10 long) binds: [B:25:0x0067, B:27:0x008c] A[DONT_GENERATE, DONT_INLINE]
      0x0091: PHI (r8v2 long) = (r8v1 long), (r8v7 long) binds: [B:25:0x0067, B:27:0x008c] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00d8 A[PHI: r0
      0x00d8: PHI (r0v11 androidx.media3.common.Timeline) = 
      (r0v10 androidx.media3.common.Timeline)
      (r0v10 androidx.media3.common.Timeline)
      (r0v21 androidx.media3.common.Timeline)
      (r0v21 androidx.media3.common.Timeline)
     binds: [B:31:0x009e, B:33:0x00a2, B:35:0x00b3, B:37:0x00ca] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void G0(boolean r34, boolean r35, boolean r36, boolean r37) {
        /*
            Method dump skipped, instruction units count: 312
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.ExoPlayerImplInternal.G0(boolean, boolean, boolean, boolean):void");
    }

    private static int G1(int i3, int i4) {
        if (i3 == -1) {
            return 2;
        }
        if (i4 == 2) {
            return 1;
        }
        return i4;
    }

    private long H(Timeline timeline, Object obj, long j3) {
        timeline.n(timeline.h(obj, this.f43065m).f41116c, this.f43064l);
        Timeline.Window window = this.f43064l;
        if (window.f41140f != -9223372036854775807L && window.f()) {
            Timeline.Window window2 = this.f43064l;
            if (window2.f41143i) {
                return Util.P0(window2.a() - this.f43064l.f41140f) - (j3 + this.f43065m.o());
            }
        }
        return -9223372036854775807L;
    }

    private void H0() {
        MediaPeriodHolder mediaPeriodHolderU = this.f43072t.u();
        this.I = mediaPeriodHolderU != null && mediaPeriodHolderU.f43150h.f43168i && this.H;
    }

    private void H1() {
        PlaybackInfo playbackInfo = this.E;
        I1(playbackInfo.f43245l, playbackInfo.f43247n, playbackInfo.f43246m);
    }

    private long I(MediaPeriodHolder mediaPeriodHolder) {
        if (mediaPeriodHolder == null) {
            return 0L;
        }
        long jM = mediaPeriodHolder.m();
        if (!mediaPeriodHolder.f43148f) {
            return jM;
        }
        int i3 = 0;
        while (true) {
            RendererHolder[] rendererHolderArr = this.f43049a;
            if (i3 >= rendererHolderArr.length) {
                return jM;
            }
            if (rendererHolderArr[i3].w(mediaPeriodHolder)) {
                long jK = this.f43049a[i3].k(mediaPeriodHolder);
                if (jK == Long.MIN_VALUE) {
                    return Long.MIN_VALUE;
                }
                jM = Math.max(jK, jM);
            }
            i3++;
        }
    }

    private void I0(long j3) {
        MediaPeriodHolder mediaPeriodHolderU = this.f43072t.u();
        long jD = mediaPeriodHolderU == null ? j3 + 1000000000000L : mediaPeriodHolderU.D(j3);
        this.T = jD;
        this.f43068p.c(jD);
        for (RendererHolder rendererHolder : this.f43049a) {
            rendererHolder.M(mediaPeriodHolderU, this.T);
        }
        u0();
    }

    private void I1(boolean z2, int i3, int i4) {
        J1(z2, this.C.n(z2, this.E.f43238e), i3, i4);
    }

    private Pair J(Timeline timeline) {
        if (timeline.q()) {
            return Pair.create(PlaybackInfo.l(), 0L);
        }
        Pair pairJ = timeline.j(this.f43064l, this.f43065m, timeline.a(this.N), -9223372036854775807L);
        MediaSource.MediaPeriodId mediaPeriodIdQ = this.f43072t.Q(timeline, pairJ.first, 0L);
        long jLongValue = ((Long) pairJ.second).longValue();
        if (mediaPeriodIdQ.c()) {
            timeline.h(mediaPeriodIdQ.f44754a, this.f43065m);
            jLongValue = mediaPeriodIdQ.f44756c == this.f43065m.l(mediaPeriodIdQ.f44755b) ? this.f43065m.g() : 0L;
        }
        return Pair.create(mediaPeriodIdQ, Long.valueOf(jLongValue));
    }

    private static void J0(Timeline timeline, PendingMessageInfo pendingMessageInfo, Timeline.Window window, Timeline.Period period) {
        int i3 = timeline.n(timeline.h(pendingMessageInfo.f43091d, period).f41116c, window).f41149o;
        Object obj = timeline.g(i3, period, true).f41115b;
        long j3 = period.f41117d;
        pendingMessageInfo.b(i3, j3 != -9223372036854775807L ? j3 - 1 : Long.MAX_VALUE, obj);
    }

    private void J1(boolean z2, int i3, int i4, int i5) {
        boolean z3 = z2 && i3 != -1;
        int iG1 = G1(i3, i5);
        int iM1 = M1(i3, i4);
        PlaybackInfo playbackInfo = this.E;
        if (playbackInfo.f43245l == z3 && playbackInfo.f43247n == iM1 && playbackInfo.f43246m == iG1) {
            return;
        }
        this.E = playbackInfo.e(z3, iG1, iM1);
        N1(false, false);
        v0(z3);
        if (!v1()) {
            B1();
            K1();
            this.f43072t.K(this.T);
            return;
        }
        int i6 = this.E.f43238e;
        if (i6 == 3) {
            this.f43068p.g();
            y1();
            this.f43061i.k(2);
        } else if (i6 == 2) {
            this.f43061i.k(2);
        }
    }

    private static boolean K0(PendingMessageInfo pendingMessageInfo, Timeline timeline, Timeline timeline2, int i3, boolean z2, Timeline.Window window, Timeline.Period period) {
        Object obj = pendingMessageInfo.f43091d;
        if (obj == null) {
            Pair pairN0 = N0(timeline, new SeekPosition(pendingMessageInfo.f43088a.g(), pendingMessageInfo.f43088a.c(), pendingMessageInfo.f43088a.e() == Long.MIN_VALUE ? -9223372036854775807L : Util.P0(pendingMessageInfo.f43088a.e())), false, i3, z2, window, period);
            if (pairN0 == null) {
                return false;
            }
            pendingMessageInfo.b(timeline.b(pairN0.first), ((Long) pairN0.second).longValue(), pairN0.first);
            if (pendingMessageInfo.f43088a.e() == Long.MIN_VALUE) {
                J0(timeline, pendingMessageInfo, window, period);
            }
            return true;
        }
        int iB = timeline.b(obj);
        if (iB == -1) {
            return false;
        }
        if (pendingMessageInfo.f43088a.e() == Long.MIN_VALUE) {
            J0(timeline, pendingMessageInfo, window, period);
            return true;
        }
        pendingMessageInfo.f43089b = iB;
        timeline2.h(pendingMessageInfo.f43091d, period);
        if (period.f41119f && timeline2.n(period.f41116c, window).f41148n == timeline2.b(pendingMessageInfo.f43091d)) {
            Pair pairJ = timeline.j(window, period, timeline.h(pendingMessageInfo.f43091d, period).f41116c, pendingMessageInfo.f43090c + period.o());
            pendingMessageInfo.b(timeline.b(pairJ.first), ((Long) pairJ.second).longValue(), pairJ.first);
        }
        return true;
    }

    private void K1() {
        MediaPeriodHolder mediaPeriodHolderU = this.f43072t.u();
        if (mediaPeriodHolderU == null) {
            return;
        }
        long jL = mediaPeriodHolderU.f43148f ? mediaPeriodHolderU.f43143a.l() : -9223372036854775807L;
        if (jL != -9223372036854775807L) {
            if (!mediaPeriodHolderU.s()) {
                this.f43072t.N(mediaPeriodHolderU);
                R(false);
                d0();
            }
            I0(jL);
            if (jL != this.E.f43252s) {
                PlaybackInfo playbackInfo = this.E;
                long j3 = jL;
                this.E = X(playbackInfo.f43235b, j3, playbackInfo.f43236c, j3, true, 5);
            }
        } else {
            long jI = this.f43068p.i(mediaPeriodHolderU != this.f43072t.y());
            this.T = jI;
            long jC = mediaPeriodHolderU.C(jI);
            k0(this.E.f43252s, jC);
            if (this.f43068p.v()) {
                boolean z2 = !this.F.f43095d;
                PlaybackInfo playbackInfo2 = this.E;
                this.E = X(playbackInfo2.f43235b, jC, playbackInfo2.f43236c, jC, z2, 6);
            } else {
                this.E.o(jC);
            }
        }
        this.E.f43250q = this.f43072t.n().j();
        this.E.f43251r = L();
        PlaybackInfo playbackInfo3 = this.E;
        if (playbackInfo3.f43245l && playbackInfo3.f43238e == 3 && x1(playbackInfo3.f43234a, playbackInfo3.f43235b) && this.E.f43248o.f40953a == 1.0f) {
            float fB = this.f43074v.b(G(), this.E.f43251r);
            if (this.f43068p.d().f40953a != fB) {
                c1(this.E.f43248o.b(fB));
                V(this.E.f43248o, this.f43068p.d().f40953a, false, false);
            }
        }
    }

    private long L() {
        return M(this.E.f43250q);
    }

    private void L0(Timeline timeline, Timeline timeline2) {
        if (timeline.q() && timeline2.q()) {
            return;
        }
        int size = this.f43069q.size() - 1;
        while (size >= 0) {
            Timeline timeline3 = timeline;
            Timeline timeline4 = timeline2;
            if (!K0((PendingMessageInfo) this.f43069q.get(size), timeline3, timeline4, this.M, this.N, this.f43064l, this.f43065m)) {
                ((PendingMessageInfo) this.f43069q.get(size)).f43088a.j(false);
                this.f43069q.remove(size);
            }
            size--;
            timeline = timeline3;
            timeline2 = timeline4;
        }
        Collections.sort(this.f43069q);
    }

    private void L1(Timeline timeline, MediaSource.MediaPeriodId mediaPeriodId, Timeline timeline2, MediaSource.MediaPeriodId mediaPeriodId2, long j3, boolean z2) {
        if (!x1(timeline, mediaPeriodId)) {
            PlaybackParameters playbackParameters = mediaPeriodId.c() ? PlaybackParameters.f40950d : this.E.f43248o;
            if (this.f43068p.d().equals(playbackParameters)) {
                return;
            }
            c1(playbackParameters);
            V(this.E.f43248o, playbackParameters.f40953a, false, false);
            return;
        }
        timeline.n(timeline.h(mediaPeriodId.f44754a, this.f43065m).f41116c, this.f43064l);
        this.f43074v.a((MediaItem.LiveConfiguration) Util.k(this.f43064l.f41144j));
        if (j3 != -9223372036854775807L) {
            this.f43074v.e(H(timeline, mediaPeriodId.f44754a, j3));
            return;
        }
        if (!Objects.equals(!timeline2.q() ? timeline2.n(timeline2.h(mediaPeriodId2.f44754a, this.f43065m).f41116c, this.f43064l).f41135a : null, this.f43064l.f41135a) || z2) {
            this.f43074v.e(-9223372036854775807L);
        }
    }

    private long M(long j3) {
        MediaPeriodHolder mediaPeriodHolderN = this.f43072t.n();
        if (mediaPeriodHolderN == null) {
            return 0L;
        }
        return Math.max(0L, j3 - mediaPeriodHolderN.C(this.T));
    }

    private static PositionUpdateForPlaylistChange M0(Timeline timeline, PlaybackInfo playbackInfo, SeekPosition seekPosition, MediaPeriodQueue mediaPeriodQueue, int i3, boolean z2, Timeline.Window window, Timeline.Period period) {
        int i4;
        long j3;
        long jG;
        int iA;
        long jLongValue;
        boolean z3;
        boolean z4;
        boolean z5;
        int iA2;
        boolean z6;
        Timeline timeline2;
        Timeline.Period period2;
        long j4;
        int i5;
        long jLongValue2;
        int iA3;
        boolean z7;
        boolean z8;
        boolean z9;
        if (timeline.q()) {
            return new PositionUpdateForPlaylistChange(PlaybackInfo.l(), 0L, -9223372036854775807L, false, true, false);
        }
        MediaSource.MediaPeriodId mediaPeriodId = playbackInfo.f43235b;
        Object obj = mediaPeriodId.f44754a;
        boolean zC0 = c0(playbackInfo, period);
        long j5 = (playbackInfo.f43235b.c() || zC0) ? playbackInfo.f43236c : playbackInfo.f43252s;
        if (seekPosition != null) {
            i4 = -1;
            j3 = -9223372036854775807L;
            Pair pairN0 = N0(timeline, seekPosition, true, i3, z2, window, period);
            if (pairN0 == null) {
                iA3 = timeline.a(z2);
                jLongValue2 = j5;
                z7 = false;
                z8 = false;
                z9 = true;
            } else {
                if (seekPosition.f43105c == -9223372036854775807L) {
                    iA3 = timeline.h(pairN0.first, period).f41116c;
                    jLongValue2 = j5;
                    z7 = false;
                } else {
                    obj = pairN0.first;
                    jLongValue2 = ((Long) pairN0.second).longValue();
                    iA3 = -1;
                    z7 = true;
                }
                z8 = playbackInfo.f43238e == 4;
                z9 = false;
            }
            iA = iA3;
            jG = jLongValue2;
            z5 = z7;
            z3 = z8;
            z4 = z9;
        } else {
            i4 = -1;
            j3 = -9223372036854775807L;
            if (playbackInfo.f43234a.q()) {
                iA = timeline.a(z2);
            } else if (timeline.b(obj) == -1) {
                int iO0 = O0(window, period, i3, z2, obj, playbackInfo.f43234a, timeline);
                if (iO0 == -1) {
                    iA2 = timeline.a(z2);
                    z6 = true;
                } else {
                    iA2 = iO0;
                    z6 = false;
                }
                iA = iA2;
                obj = obj;
                jG = j5;
                z4 = z6;
                z3 = false;
                z5 = false;
            } else if (j5 == -9223372036854775807L) {
                iA = timeline.h(obj, period).f41116c;
                obj = obj;
            } else if (zC0) {
                playbackInfo.f43234a.h(mediaPeriodId.f44754a, period);
                if (playbackInfo.f43234a.n(period.f41116c, window).f41148n == playbackInfo.f43234a.b(mediaPeriodId.f44754a)) {
                    Pair pairJ = timeline.j(window, period, timeline.h(obj, period).f41116c, period.o() + j5);
                    obj = pairJ.first;
                    jLongValue = ((Long) pairJ.second).longValue();
                } else {
                    obj = obj;
                    jLongValue = j5;
                }
                jG = jLongValue;
                iA = -1;
                z3 = false;
                z4 = false;
                z5 = true;
            } else {
                obj = obj;
                jG = j5;
                iA = -1;
                z3 = false;
                z4 = false;
                z5 = false;
            }
            jG = j5;
            z3 = false;
            z4 = false;
            z5 = false;
        }
        if (iA != i4) {
            period2 = period;
            Pair pairJ2 = timeline.j(window, period2, iA, -9223372036854775807L);
            timeline2 = timeline;
            obj = pairJ2.first;
            jG = ((Long) pairJ2.second).longValue();
            j4 = j3;
        } else {
            timeline2 = timeline;
            period2 = period;
            j4 = jG;
        }
        MediaSource.MediaPeriodId mediaPeriodIdQ = mediaPeriodQueue.Q(timeline2, obj, jG);
        int i6 = mediaPeriodIdQ.f44758e;
        boolean z10 = mediaPeriodId.f44754a.equals(obj) && !mediaPeriodId.c() && !mediaPeriodIdQ.c() && (i6 == i4 || ((i5 = mediaPeriodId.f44758e) != i4 && i6 >= i5));
        long j6 = j4;
        MediaSource.MediaPeriodId mediaPeriodId2 = mediaPeriodIdQ;
        boolean Z = Z(zC0, mediaPeriodId, j5, mediaPeriodId2, timeline2.h(obj, period2), j6);
        if (z10 || Z) {
            mediaPeriodId2 = mediaPeriodId;
        }
        if (mediaPeriodId2.c()) {
            if (mediaPeriodId2.equals(mediaPeriodId)) {
                jG = playbackInfo.f43252s;
            } else {
                timeline2.h(mediaPeriodId2.f44754a, period2);
                jG = mediaPeriodId2.f44756c == period2.l(mediaPeriodId2.f44755b) ? period2.g() : 0L;
            }
        }
        return new PositionUpdateForPlaylistChange(mediaPeriodId2, jG, j6, z3, z4, z5);
    }

    private static int M1(int i3, int i4) {
        if (i3 == 0) {
            return 1;
        }
        if (i4 == 1) {
            return 0;
        }
        return i4;
    }

    private void N(int i3) {
        PlaybackInfo playbackInfo = this.E;
        J1(playbackInfo.f43245l, i3, playbackInfo.f43247n, playbackInfo.f43246m);
    }

    private static Pair N0(Timeline timeline, SeekPosition seekPosition, boolean z2, int i3, boolean z3, Timeline.Window window, Timeline.Period period) {
        Pair pairJ;
        Timeline timeline2;
        int iO0;
        Timeline timeline3 = seekPosition.f43103a;
        if (timeline.q()) {
            return null;
        }
        boolean zQ = timeline3.q();
        Timeline timeline4 = timeline3;
        if (zQ) {
            timeline4 = timeline;
        }
        try {
            pairJ = timeline4.j(window, period, seekPosition.f43104b, seekPosition.f43105c);
            timeline2 = timeline4;
        } catch (IndexOutOfBoundsException unused) {
        }
        if (timeline.equals(timeline2)) {
            return pairJ;
        }
        if (timeline.b(pairJ.first) != -1) {
            return (timeline2.h(pairJ.first, period).f41119f && timeline2.n(period.f41116c, window).f41148n == timeline2.b(pairJ.first)) ? timeline.j(window, period, timeline.h(pairJ.first, period).f41116c, seekPosition.f43105c) : pairJ;
        }
        if (z2 && (iO0 = O0(window, period, i3, z3, pairJ.first, timeline2, timeline)) != -1) {
            return timeline.j(window, period, iO0, -9223372036854775807L);
        }
        return null;
    }

    private void N1(boolean z2, boolean z3) {
        this.J = z2;
        this.K = (!z2 || z3) ? -9223372036854775807L : this.f43070r.a();
    }

    private void O() {
        s1(this.f43057e0);
    }

    static int O0(Timeline.Window window, Timeline.Period period, int i3, boolean z2, Object obj, Timeline timeline, Timeline timeline2) {
        Timeline.Period period2;
        Object obj2 = timeline.n(timeline.h(obj, period).f41116c, window).f41135a;
        int i4 = 0;
        for (int i5 = 0; i5 < timeline2.p(); i5++) {
            if (timeline2.n(i5, window).f41135a.equals(obj2)) {
                return i5;
            }
        }
        int iB = timeline.b(obj);
        int i6 = timeline.i();
        int iD = iB;
        int iB2 = -1;
        while (i4 < i6 && iB2 == -1) {
            Timeline.Window window2 = window;
            period2 = period;
            int i7 = i3;
            boolean z3 = z2;
            Timeline timeline3 = timeline;
            iD = timeline3.d(iD, period2, window2, i7, z3);
            if (iD == -1) {
                break;
            }
            iB2 = timeline2.b(timeline3.m(iD));
            i4++;
            timeline = timeline3;
            period = period2;
            window = window2;
            i3 = i7;
            z2 = z3;
        }
        period2 = period;
        if (iB2 == -1) {
            return -1;
        }
        return timeline2.f(iB2, period2).f41116c;
    }

    private boolean O1() throws ExoPlaybackException {
        MediaPeriodHolder mediaPeriodHolderY = this.f43072t.y();
        TrackSelectorResult trackSelectorResultP = mediaPeriodHolderY.p();
        boolean z2 = true;
        int i3 = 0;
        while (true) {
            RendererHolder[] rendererHolderArr = this.f43049a;
            if (i3 >= rendererHolderArr.length) {
                break;
            }
            int iH = rendererHolderArr[i3].h();
            int iJ = this.f43049a[i3].J(mediaPeriodHolderY, trackSelectorResultP, this.f43068p);
            if ((iJ & 2) != 0 && this.Q) {
                f1(false);
            }
            this.R -= iH - this.f43049a[i3].h();
            z2 &= (iJ & 1) != 0;
            i3++;
        }
        if (z2) {
            for (int i4 = 0; i4 < this.f43049a.length; i4++) {
                if (trackSelectorResultP.c(i4) && !this.f43049a[i4].w(mediaPeriodHolderY)) {
                    B(mediaPeriodHolderY, i4, false, mediaPeriodHolderY.n());
                }
            }
        }
        return z2;
    }

    private void P(MediaPeriod mediaPeriod) {
        if (this.f43072t.F(mediaPeriod)) {
            this.f43072t.K(this.T);
            d0();
        } else if (this.f43072t.G(mediaPeriod)) {
            e0();
        }
    }

    private void P0(long j3) {
        long jMin = (this.E.f43238e != 3 || (!this.f43077y && v1())) ? f43048f0 : 1000L;
        if (this.f43077y && v1()) {
            for (RendererHolder rendererHolder : this.f43049a) {
                jMin = Math.min(jMin, Util.t1(rendererHolder.j(this.T, this.U)));
            }
            if ((this.f43072t.u() != null ? this.f43072t.u().k() : null) != null && this.T + (Util.P0(jMin) * this.E.f43248o.f40953a) >= r2.n()) {
                jMin = Math.min(jMin, f43048f0);
            }
        }
        this.f43061i.l(2, j3 + jMin);
    }

    private void P1(float f3) {
        for (MediaPeriodHolder mediaPeriodHolderU = this.f43072t.u(); mediaPeriodHolderU != null; mediaPeriodHolderU = mediaPeriodHolderU.k()) {
            for (ExoTrackSelection exoTrackSelection : mediaPeriodHolderU.p().f45457c) {
                if (exoTrackSelection != null) {
                    exoTrackSelection.e(f3);
                }
            }
        }
    }

    private void Q(IOException iOException, int i3) {
        ExoPlaybackException exoPlaybackExceptionE = ExoPlaybackException.e(iOException, i3);
        MediaPeriodHolder mediaPeriodHolderU = this.f43072t.u();
        if (mediaPeriodHolderU != null) {
            exoPlaybackExceptionE = exoPlaybackExceptionE.c(mediaPeriodHolderU.f43150h.f43160a);
        }
        Log.e("ExoPlayerImplInternal", "Playback error", exoPlaybackExceptionE);
        A1(false, false);
        this.E = this.E.f(exoPlaybackExceptionE);
    }

    private synchronized void Q1(Supplier supplier, long j3) {
        long jA = this.f43070r.a() + j3;
        boolean z2 = false;
        while (!((Boolean) supplier.get()).booleanValue() && j3 > 0) {
            try {
                this.f43070r.e();
                wait(j3);
            } catch (InterruptedException unused) {
                z2 = true;
            }
            j3 = jA - this.f43070r.a();
        }
        if (z2) {
            Thread.currentThread().interrupt();
        }
    }

    private void R(boolean z2) {
        MediaPeriodHolder mediaPeriodHolderN = this.f43072t.n();
        MediaSource.MediaPeriodId mediaPeriodId = mediaPeriodHolderN == null ? this.E.f43235b : mediaPeriodHolderN.f43150h.f43160a;
        boolean zEquals = this.E.f43244k.equals(mediaPeriodId);
        if (!zEquals) {
            this.E = this.E.c(mediaPeriodId);
        }
        PlaybackInfo playbackInfo = this.E;
        playbackInfo.f43250q = mediaPeriodHolderN == null ? playbackInfo.f43252s : mediaPeriodHolderN.j();
        this.E.f43251r = L();
        if ((!zEquals || z2) && mediaPeriodHolderN != null && mediaPeriodHolderN.f43148f) {
            D1(mediaPeriodHolderN.f43150h.f43160a, mediaPeriodHolderN.o(), mediaPeriodHolderN.p());
        }
    }

    private void R0(boolean z2) throws ExoPlaybackException {
        MediaSource.MediaPeriodId mediaPeriodId = this.f43072t.u().f43150h.f43160a;
        long jU0 = U0(mediaPeriodId, this.E.f43252s, true, false);
        if (jU0 != this.E.f43252s) {
            PlaybackInfo playbackInfo = this.E;
            this.E = X(mediaPeriodId, jU0, playbackInfo.f43236c, playbackInfo.f43237d, z2, 5);
        }
    }

    private void S(MediaPeriodHolder mediaPeriodHolder) throws ExoPlaybackException {
        if (!mediaPeriodHolder.f43148f) {
            float f3 = this.f43068p.d().f40953a;
            PlaybackInfo playbackInfo = this.E;
            mediaPeriodHolder.q(f3, playbackInfo.f43234a, playbackInfo.f43245l);
        }
        D1(mediaPeriodHolder.f43150h.f43160a, mediaPeriodHolder.o(), mediaPeriodHolder.p());
        if (mediaPeriodHolder == this.f43072t.u()) {
            I0(mediaPeriodHolder.f43150h.f43161b);
            C();
            mediaPeriodHolder.f43151i = true;
            PlaybackInfo playbackInfo2 = this.E;
            MediaSource.MediaPeriodId mediaPeriodId = playbackInfo2.f43235b;
            long j3 = mediaPeriodHolder.f43150h.f43161b;
            this.E = X(mediaPeriodId, j3, playbackInfo2.f43236c, j3, false, 5);
        }
        d0();
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x00a1 A[Catch: all -> 0x00a4, TryCatch #1 {all -> 0x00a4, blocks: (B:22:0x0097, B:24:0x00a1, B:30:0x00ad, B:32:0x00b3, B:33:0x00b6, B:35:0x00be, B:39:0x00d0, B:43:0x00d8), top: B:91:0x0097 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00aa  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void S0(androidx.media3.exoplayer.ExoPlayerImplInternal.SeekPosition r20) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 344
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.ExoPlayerImplInternal.S0(androidx.media3.exoplayer.ExoPlayerImplInternal$SeekPosition):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:100:0x01c8  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x01d3  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x01db  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x01fa  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0205  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x020b  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x022c  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x01c6  */
    /* JADX WARN: Type inference failed for: r12v0, types: [long] */
    /* JADX WARN: Type inference failed for: r12v14 */
    /* JADX WARN: Type inference failed for: r12v15 */
    /* JADX WARN: Type inference failed for: r12v2, types: [boolean] */
    /* JADX WARN: Type inference failed for: r12v4 */
    /* JADX WARN: Type inference failed for: r12v5 */
    /* JADX WARN: Type inference failed for: r12v6 */
    /* JADX WARN: Type inference failed for: r21v0 */
    /* JADX WARN: Type inference failed for: r21v1, types: [long] */
    /* JADX WARN: Type inference failed for: r21v10 */
    /* JADX WARN: Type inference failed for: r21v11 */
    /* JADX WARN: Type inference failed for: r21v12 */
    /* JADX WARN: Type inference failed for: r21v13 */
    /* JADX WARN: Type inference failed for: r21v14 */
    /* JADX WARN: Type inference failed for: r21v15 */
    /* JADX WARN: Type inference failed for: r21v16 */
    /* JADX WARN: Type inference failed for: r21v2 */
    /* JADX WARN: Type inference failed for: r21v3 */
    /* JADX WARN: Type inference failed for: r21v4 */
    /* JADX WARN: Type inference failed for: r21v5 */
    /* JADX WARN: Type inference failed for: r21v6, types: [long] */
    /* JADX WARN: Type inference failed for: r21v7 */
    /* JADX WARN: Type inference failed for: r21v8 */
    /* JADX WARN: Type inference failed for: r21v9 */
    /* JADX WARN: Type inference failed for: r28v0, types: [androidx.media3.exoplayer.ExoPlayerImplInternal] */
    /* JADX WARN: Type inference failed for: r5v3, types: [long] */
    /* JADX WARN: Type inference failed for: r5v7, types: [long] */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v2, types: [boolean] */
    /* JADX WARN: Type inference failed for: r9v3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void T(androidx.media3.common.Timeline r29, boolean r30) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 569
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.ExoPlayerImplInternal.T(androidx.media3.common.Timeline, boolean):void");
    }

    private long T0(MediaSource.MediaPeriodId mediaPeriodId, long j3, boolean z2) {
        return U0(mediaPeriodId, j3, this.f43072t.u() != this.f43072t.y(), z2);
    }

    private void U(MediaPeriod mediaPeriod) throws ExoPlaybackException {
        if (this.f43072t.F(mediaPeriod)) {
            S((MediaPeriodHolder) Assertions.e(this.f43072t.n()));
            return;
        }
        MediaPeriodHolder mediaPeriodHolderV = this.f43072t.v(mediaPeriod);
        if (mediaPeriodHolderV != null) {
            Assertions.g(!mediaPeriodHolderV.f43148f);
            float f3 = this.f43068p.d().f40953a;
            PlaybackInfo playbackInfo = this.E;
            mediaPeriodHolderV.q(f3, playbackInfo.f43234a, playbackInfo.f43245l);
            if (this.f43072t.G(mediaPeriod)) {
                e0();
            }
        }
    }

    private long U0(MediaSource.MediaPeriodId mediaPeriodId, long j3, boolean z2, boolean z3) throws ExoPlaybackException {
        B1();
        N1(false, true);
        if (z3 || this.E.f43238e == 3) {
            p1(2);
        }
        MediaPeriodHolder mediaPeriodHolderU = this.f43072t.u();
        MediaPeriodHolder mediaPeriodHolderK = mediaPeriodHolderU;
        while (mediaPeriodHolderK != null && !mediaPeriodId.equals(mediaPeriodHolderK.f43150h.f43160a)) {
            mediaPeriodHolderK = mediaPeriodHolderK.k();
        }
        if (z2 || mediaPeriodHolderU != mediaPeriodHolderK || (mediaPeriodHolderK != null && mediaPeriodHolderK.D(j3) < 0)) {
            z();
            if (mediaPeriodHolderK != null) {
                while (this.f43072t.u() != mediaPeriodHolderK) {
                    this.f43072t.b();
                }
                this.f43072t.N(mediaPeriodHolderK);
                mediaPeriodHolderK.B(1000000000000L);
                C();
                mediaPeriodHolderK.f43151i = true;
            }
        }
        x();
        if (mediaPeriodHolderK != null) {
            this.f43072t.N(mediaPeriodHolderK);
            if (!mediaPeriodHolderK.f43148f) {
                mediaPeriodHolderK.f43150h = mediaPeriodHolderK.f43150h.b(j3);
            } else if (mediaPeriodHolderK.f43149g) {
                j3 = mediaPeriodHolderK.f43143a.j(j3);
                mediaPeriodHolderK.f43143a.u(j3 - this.f43066n, this.f43067o);
            }
            I0(j3);
            d0();
        } else {
            this.f43072t.g();
            I0(j3);
        }
        R(false);
        this.f43061i.k(2);
        return j3;
    }

    private void V(PlaybackParameters playbackParameters, float f3, boolean z2, boolean z3) {
        if (z2) {
            if (z3) {
                this.F.b(1);
            }
            this.E = this.E.g(playbackParameters);
        }
        P1(playbackParameters.f40953a);
        for (RendererHolder rendererHolder : this.f43049a) {
            rendererHolder.Q(f3, playbackParameters.f40953a);
        }
    }

    private void V0(PlayerMessage playerMessage) {
        if (playerMessage.e() == -9223372036854775807L) {
            W0(playerMessage);
            return;
        }
        if (this.E.f43234a.q()) {
            this.f43069q.add(new PendingMessageInfo(playerMessage));
            return;
        }
        PendingMessageInfo pendingMessageInfo = new PendingMessageInfo(playerMessage);
        Timeline timeline = this.E.f43234a;
        if (!K0(pendingMessageInfo, timeline, timeline, this.M, this.N, this.f43064l, this.f43065m)) {
            playerMessage.j(false);
        } else {
            this.f43069q.add(pendingMessageInfo);
            Collections.sort(this.f43069q);
        }
    }

    private void W(PlaybackParameters playbackParameters, boolean z2) {
        V(playbackParameters, playbackParameters.f40953a, true, z2);
    }

    private void W0(PlayerMessage playerMessage) {
        if (playerMessage.b() != this.f43063k) {
            this.f43061i.e(15, playerMessage).a();
            return;
        }
        w(playerMessage);
        int i3 = this.E.f43238e;
        if (i3 == 3 || i3 == 2) {
            this.f43061i.k(2);
        }
    }

    private PlaybackInfo X(MediaSource.MediaPeriodId mediaPeriodId, long j3, long j4, long j5, boolean z2, int i3) {
        List list;
        TrackGroupArray trackGroupArray;
        TrackSelectorResult trackSelectorResult;
        this.W = (!this.W && j3 == this.E.f43252s && mediaPeriodId.equals(this.E.f43235b)) ? false : true;
        H0();
        PlaybackInfo playbackInfo = this.E;
        TrackGroupArray trackGroupArray2 = playbackInfo.f43241h;
        TrackSelectorResult trackSelectorResult2 = playbackInfo.f43242i;
        List listY = playbackInfo.f43243j;
        if (this.f43073u.t()) {
            MediaPeriodHolder mediaPeriodHolderU = this.f43072t.u();
            TrackGroupArray trackGroupArrayO = mediaPeriodHolderU == null ? TrackGroupArray.f44985d : mediaPeriodHolderU.o();
            TrackSelectorResult trackSelectorResultP = mediaPeriodHolderU == null ? this.f43058f : mediaPeriodHolderU.p();
            ImmutableList immutableListF = F(trackSelectorResultP.f45457c);
            if (mediaPeriodHolderU != null) {
                MediaPeriodInfo mediaPeriodInfo = mediaPeriodHolderU.f43150h;
                if (mediaPeriodInfo.f43162c != j4) {
                    mediaPeriodHolderU.f43150h = mediaPeriodInfo.a(j4);
                }
            }
            m0();
            trackGroupArray = trackGroupArrayO;
            trackSelectorResult = trackSelectorResultP;
            list = immutableListF;
        } else {
            if (!mediaPeriodId.equals(this.E.f43235b)) {
                trackGroupArray2 = TrackGroupArray.f44985d;
                trackSelectorResult2 = this.f43058f;
                listY = ImmutableList.y();
            }
            list = listY;
            trackGroupArray = trackGroupArray2;
            trackSelectorResult = trackSelectorResult2;
        }
        if (z2) {
            this.F.d(i3);
        }
        return this.E.d(mediaPeriodId, j3, j4, j5, L(), trackGroupArray, trackSelectorResult, list);
    }

    private void X0(final PlayerMessage playerMessage) {
        Looper looperB = playerMessage.b();
        if (looperB.getThread().isAlive()) {
            this.f43070r.d(looperB, null).j(new Runnable() { // from class: androidx.media3.exoplayer.x1
                @Override // java.lang.Runnable
                public final void run() {
                    ExoPlayerImplInternal.l(this.f46016a, playerMessage);
                }
            });
        } else {
            Log.i("TAG", "Trying to send message on a dead thread.");
            playerMessage.j(false);
        }
    }

    private boolean Y() {
        MediaPeriodHolder mediaPeriodHolderY = this.f43072t.y();
        if (!mediaPeriodHolderY.f43148f) {
            return false;
        }
        int i3 = 0;
        while (true) {
            RendererHolder[] rendererHolderArr = this.f43049a;
            if (i3 >= rendererHolderArr.length) {
                return true;
            }
            if (!rendererHolderArr[i3].o(mediaPeriodHolderY)) {
                return false;
            }
            i3++;
        }
    }

    private void Y0(long j3) {
        for (RendererHolder rendererHolder : this.f43049a) {
            rendererHolder.N(j3);
        }
    }

    private static boolean Z(boolean z2, MediaSource.MediaPeriodId mediaPeriodId, long j3, MediaSource.MediaPeriodId mediaPeriodId2, Timeline.Period period, long j4) {
        if (!z2 && j3 == j4 && mediaPeriodId.f44754a.equals(mediaPeriodId2.f44754a)) {
            if (mediaPeriodId.c() && period.s(mediaPeriodId.f44755b)) {
                return (period.h(mediaPeriodId.f44755b, mediaPeriodId.f44756c) == 4 || period.h(mediaPeriodId.f44755b, mediaPeriodId.f44756c) == 2) ? false : true;
            }
            if (mediaPeriodId2.c() && period.s(mediaPeriodId2.f44755b)) {
                return true;
            }
        }
        return false;
    }

    private boolean a0(MediaPeriodHolder mediaPeriodHolder) {
        return (mediaPeriodHolder == null || mediaPeriodHolder.r() || mediaPeriodHolder.l() == Long.MIN_VALUE) ? false : true;
    }

    private void a1(AudioAttributes audioAttributes, boolean z2) {
        this.f43055d.l(audioAttributes);
        AudioFocusManager audioFocusManager = this.C;
        if (!z2) {
            audioAttributes = null;
        }
        audioFocusManager.k(audioAttributes);
        H1();
    }

    private boolean b0() {
        MediaPeriodHolder mediaPeriodHolderU = this.f43072t.u();
        long j3 = mediaPeriodHolderU.f43150h.f43164e;
        if (mediaPeriodHolderU.f43148f) {
            return j3 == -9223372036854775807L || this.E.f43252s < j3 || !v1();
        }
        return false;
    }

    private void b1(boolean z2, AtomicBoolean atomicBoolean) {
        if (this.O != z2) {
            this.O = z2;
            if (!z2) {
                for (RendererHolder rendererHolder : this.f43049a) {
                    rendererHolder.L();
                }
            }
        }
        if (atomicBoolean != null) {
            synchronized (this) {
                atomicBoolean.set(true);
                notifyAll();
            }
        }
    }

    private static boolean c0(PlaybackInfo playbackInfo, Timeline.Period period) {
        MediaSource.MediaPeriodId mediaPeriodId = playbackInfo.f43235b;
        Timeline timeline = playbackInfo.f43234a;
        return timeline.q() || timeline.h(mediaPeriodId.f44754a, period).f41119f;
    }

    private void c1(PlaybackParameters playbackParameters) {
        this.f43061i.m(16);
        this.f43068p.e(playbackParameters);
    }

    private void d0() {
        boolean zU1 = u1();
        this.L = zU1;
        if (zU1) {
            MediaPeriodHolder mediaPeriodHolder = (MediaPeriodHolder) Assertions.e(this.f43072t.n());
            mediaPeriodHolder.e(new LoadingInfo.Builder().f(mediaPeriodHolder.C(this.T)).g(this.f43068p.d().f40953a).e(this.K).d());
        }
        C1();
    }

    private void d1(MediaSourceListUpdateMessage mediaSourceListUpdateMessage) throws Throwable {
        this.F.b(1);
        if (mediaSourceListUpdateMessage.f43082c != -1) {
            this.S = new SeekPosition(new PlaylistTimeline(mediaSourceListUpdateMessage.f43080a, mediaSourceListUpdateMessage.f43081b), mediaSourceListUpdateMessage.f43082c, mediaSourceListUpdateMessage.f43083d);
        }
        T(this.f43073u.C(mediaSourceListUpdateMessage.f43080a, mediaSourceListUpdateMessage.f43081b), false);
    }

    private void e0() {
        this.f43072t.I();
        MediaPeriodHolder mediaPeriodHolderW = this.f43072t.w();
        if (mediaPeriodHolderW != null) {
            if ((!mediaPeriodHolderW.f43147e || mediaPeriodHolderW.f43148f) && !mediaPeriodHolderW.f43143a.a()) {
                if (this.f43059g.f(this.E.f43234a, mediaPeriodHolderW.f43150h.f43160a, mediaPeriodHolderW.f43148f ? mediaPeriodHolderW.f43143a.e() : 0L)) {
                    if (mediaPeriodHolderW.f43147e) {
                        mediaPeriodHolderW.e(new LoadingInfo.Builder().f(mediaPeriodHolderW.C(this.T)).g(this.f43068p.d().f40953a).e(this.K).d());
                    } else {
                        mediaPeriodHolderW.v(this, mediaPeriodHolderW.f43150h.f43161b);
                    }
                }
            }
        }
    }

    private void f0() {
        for (RendererHolder rendererHolder : this.f43049a) {
            rendererHolder.D();
        }
    }

    private void f1(boolean z2) {
        if (z2 == this.Q) {
            return;
        }
        this.Q = z2;
        if (z2 || !this.E.f43249p) {
            return;
        }
        this.f43061i.k(2);
    }

    private void g0() {
        this.F.c(this.E);
        if (this.F.f43092a) {
            this.f43071s.a(this.F);
            this.F = new PlaybackInfoUpdate(this.E);
        }
    }

    private void g1(boolean z2) throws ExoPlaybackException {
        this.H = z2;
        H0();
        if (!this.I || this.f43072t.y() == this.f43072t.u()) {
            return;
        }
        R0(true);
        R(false);
    }

    private void h0() throws ExoPlaybackException {
        MediaPeriodHolder mediaPeriodHolderX = this.f43072t.x();
        if (mediaPeriodHolderX == null) {
            return;
        }
        TrackSelectorResult trackSelectorResultP = mediaPeriodHolderX.p();
        for (int i3 = 0; i3 < this.f43049a.length; i3++) {
            if (trackSelectorResultP.c(i3) && this.f43049a[i3].s() && !this.f43049a[i3].u()) {
                this.f43049a[i3].V();
                B(mediaPeriodHolderX, i3, false, mediaPeriodHolderX.n());
            }
        }
        if (t()) {
            this.f43054c0 = mediaPeriodHolderX.f43143a.l();
            if (mediaPeriodHolderX.s()) {
                return;
            }
            this.f43072t.N(mediaPeriodHolderX);
            R(false);
            d0();
        }
    }

    private void i0(int i3) {
        RendererHolder rendererHolder = this.f43049a[i3];
        try {
            rendererHolder.G((MediaPeriodHolder) Assertions.e(this.f43072t.u()));
        } catch (IOException | RuntimeException e3) {
            int iM = rendererHolder.m();
            if (iM != 3 && iM != 5) {
                throw e3;
            }
            TrackSelectorResult trackSelectorResultP = this.f43072t.u().p();
            Log.e("ExoPlayerImplInternal", "Disabling track due to error: " + Format.h(trackSelectorResultP.f45457c[i3].l()), e3);
            TrackSelectorResult trackSelectorResult = new TrackSelectorResult((RendererConfiguration[]) trackSelectorResultP.f45456b.clone(), (ExoTrackSelection[]) trackSelectorResultP.f45457c.clone(), trackSelectorResultP.f45458d, trackSelectorResultP.f45459e);
            trackSelectorResult.f45456b[i3] = null;
            trackSelectorResult.f45457c[i3] = null;
            y(i3);
            this.f43072t.u().a(trackSelectorResult, this.E.f43252s, false);
        }
    }

    private void i1(boolean z2, int i3, boolean z3, int i4) {
        this.F.b(z3 ? 1 : 0);
        I1(z2, i3, i4);
    }

    private void j0(final int i3, final boolean z2) {
        boolean[] zArr = this.f43053c;
        if (zArr[i3] != z2) {
            zArr[i3] = z2;
            this.A.j(new Runnable() { // from class: androidx.media3.exoplayer.v1
                @Override // java.lang.Runnable
                public final void run() {
                    ExoPlayerImplInternal exoPlayerImplInternal = this.f45658a;
                    int i4 = i3;
                    exoPlayerImplInternal.f43078z.k0(i4, exoPlayerImplInternal.f43049a[i4].m(), z2);
                }
            });
        }
    }

    private void j1(PlaybackParameters playbackParameters) {
        c1(playbackParameters);
        W(this.f43068p.d(), true);
    }

    /* JADX WARN: Code restructure failed: missing block: B:72:0x0079, code lost:
    
        r3 = null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void k0(long r9, long r11) {
        /*
            Method dump skipped, instruction units count: 253
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.ExoPlayerImplInternal.k0(long, long):void");
    }

    private void k1(ExoPlayer.PreloadConfiguration preloadConfiguration) {
        this.f43050a0 = preloadConfiguration;
        this.f43072t.V(this.E.f43234a, preloadConfiguration);
    }

    public static /* synthetic */ void l(ExoPlayerImplInternal exoPlayerImplInternal, PlayerMessage playerMessage) {
        exoPlayerImplInternal.getClass();
        try {
            exoPlayerImplInternal.w(playerMessage);
        } catch (ExoPlaybackException e3) {
            Log.e("ExoPlayerImplInternal", "Unexpected error delivering message on external thread.", e3);
            throw new RuntimeException(e3);
        }
    }

    private boolean l0() {
        MediaPeriodInfo mediaPeriodInfoT;
        this.f43072t.K(this.T);
        boolean z2 = false;
        if (this.f43072t.T() && (mediaPeriodInfoT = this.f43072t.t(this.T, this.E)) != null) {
            MediaPeriodHolder mediaPeriodHolderH = this.f43072t.h(mediaPeriodInfoT);
            if (!mediaPeriodHolderH.f43147e) {
                mediaPeriodHolderH.v(this, mediaPeriodInfoT.f43161b);
            } else if (mediaPeriodHolderH.f43148f) {
                this.f43061i.e(8, mediaPeriodHolderH.f43143a).a();
            }
            if (this.f43072t.u() == mediaPeriodHolderH) {
                I0(mediaPeriodInfoT.f43161b);
            }
            R(false);
            z2 = true;
        }
        if (!this.L) {
            d0();
            return z2;
        }
        this.L = a0(this.f43072t.n());
        C1();
        return z2;
    }

    private void l1(int i3) throws ExoPlaybackException {
        this.M = i3;
        int iX = this.f43072t.X(this.E.f43234a, i3);
        if ((iX & 1) != 0) {
            R0(true);
        } else if ((iX & 2) != 0) {
            x();
        }
        R(false);
    }

    private void m0() {
        MediaPeriodHolder mediaPeriodHolderU;
        boolean z2;
        if (this.f43072t.u() == this.f43072t.y() && (mediaPeriodHolderU = this.f43072t.u()) != null) {
            TrackSelectorResult trackSelectorResultP = mediaPeriodHolderU.p();
            boolean z3 = false;
            int i3 = 0;
            boolean z4 = false;
            while (true) {
                if (i3 >= this.f43049a.length) {
                    z2 = true;
                    break;
                }
                if (trackSelectorResultP.c(i3)) {
                    if (this.f43049a[i3].m() != 1) {
                        z2 = false;
                        break;
                    } else if (trackSelectorResultP.f45456b[i3].f43288a != 0) {
                        z4 = true;
                    }
                }
                i3++;
            }
            if (z4 && z2) {
                z3 = true;
            }
            f1(z3);
        }
    }

    private void m1(SeekParameters seekParameters) {
        this.D = seekParameters;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0047  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void n0() {
        /*
            r15 = this;
            r0 = 0
            r1 = r0
        L2:
            boolean r2 = r15.t1()
            if (r2 == 0) goto L81
            if (r1 == 0) goto Ld
            r15.g0()
        Ld:
            r15.f43056d0 = r0
            androidx.media3.exoplayer.MediaPeriodQueue r1 = r15.f43072t
            androidx.media3.exoplayer.MediaPeriodHolder r1 = r1.b()
            java.lang.Object r1 = androidx.media3.common.util.Assertions.e(r1)
            androidx.media3.exoplayer.MediaPeriodHolder r1 = (androidx.media3.exoplayer.MediaPeriodHolder) r1
            androidx.media3.exoplayer.PlaybackInfo r2 = r15.E
            androidx.media3.exoplayer.source.MediaSource$MediaPeriodId r2 = r2.f43235b
            java.lang.Object r2 = r2.f44754a
            androidx.media3.exoplayer.MediaPeriodInfo r3 = r1.f43150h
            androidx.media3.exoplayer.source.MediaSource$MediaPeriodId r3 = r3.f43160a
            java.lang.Object r3 = r3.f44754a
            boolean r2 = r2.equals(r3)
            r3 = 1
            if (r2 == 0) goto L47
            androidx.media3.exoplayer.PlaybackInfo r2 = r15.E
            androidx.media3.exoplayer.source.MediaSource$MediaPeriodId r2 = r2.f43235b
            int r4 = r2.f44755b
            r5 = -1
            if (r4 != r5) goto L47
            androidx.media3.exoplayer.MediaPeriodInfo r4 = r1.f43150h
            androidx.media3.exoplayer.source.MediaSource$MediaPeriodId r4 = r4.f43160a
            int r6 = r4.f44755b
            if (r6 != r5) goto L47
            int r2 = r2.f44758e
            int r4 = r4.f44758e
            if (r2 == r4) goto L47
            r2 = r3
            goto L48
        L47:
            r2 = r0
        L48:
            androidx.media3.exoplayer.MediaPeriodInfo r4 = r1.f43150h
            androidx.media3.exoplayer.source.MediaSource$MediaPeriodId r6 = r4.f43160a
            long r7 = r4.f43161b
            long r9 = r4.f43162c
            r13 = r2 ^ 1
            r14 = 0
            r11 = r7
            r5 = r15
            androidx.media3.exoplayer.PlaybackInfo r2 = r5.X(r6, r7, r9, r11, r13, r14)
            r5.E = r2
            r15.H0()
            r15.K1()
            boolean r2 = r15.t()
            if (r2 == 0) goto L72
            androidx.media3.exoplayer.MediaPeriodQueue r2 = r5.f43072t
            androidx.media3.exoplayer.MediaPeriodHolder r2 = r2.x()
            if (r1 != r2) goto L72
            r15.f0()
        L72:
            androidx.media3.exoplayer.PlaybackInfo r1 = r5.E
            int r1 = r1.f43238e
            r2 = 3
            if (r1 != r2) goto L7c
            r15.y1()
        L7c:
            r15.s()
            r1 = r3
            goto L2
        L81:
            r5 = r15
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.ExoPlayerImplInternal.n0():void");
    }

    private void n1(boolean z2) throws ExoPlaybackException {
        this.N = z2;
        int iY = this.f43072t.Y(this.E.f43234a, z2);
        if ((iY & 1) != 0) {
            R0(true);
        } else if ((iY & 2) != 0) {
            x();
        }
        R(false);
    }

    private void o0(boolean z2) {
        if (this.f43050a0.f42990a == -9223372036854775807L) {
            return;
        }
        if (z2 || !this.E.f43234a.equals(this.f43052b0)) {
            Timeline timeline = this.E.f43234a;
            this.f43052b0 = timeline;
            this.f43072t.B(timeline);
        }
        e0();
    }

    private void o1(ShuffleOrder shuffleOrder) throws Throwable {
        this.F.b(1);
        T(this.f43073u.D(shuffleOrder), false);
    }

    private void p0() throws ExoPlaybackException {
        MediaPeriodHolder mediaPeriodHolderX;
        if (this.I || !this.B || this.f43056d0 || t() || (mediaPeriodHolderX = this.f43072t.x()) == null || mediaPeriodHolderX != this.f43072t.y() || mediaPeriodHolderX.k() == null || !mediaPeriodHolderX.k().f43148f) {
            return;
        }
        this.f43072t.c();
        h0();
    }

    private void p1(int i3) {
        PlaybackInfo playbackInfo = this.E;
        if (playbackInfo.f43238e != i3) {
            if (i3 != 2) {
                this.Z = -9223372036854775807L;
            }
            this.E = playbackInfo.h(i3);
        }
    }

    private void q0() {
        MediaPeriodHolder mediaPeriodHolderY = this.f43072t.y();
        if (mediaPeriodHolderY == null) {
            return;
        }
        int i3 = 0;
        if (mediaPeriodHolderY.k() == null || this.I) {
            if (mediaPeriodHolderY.f43150h.f43169j || this.I) {
                RendererHolder[] rendererHolderArr = this.f43049a;
                int length = rendererHolderArr.length;
                while (i3 < length) {
                    RendererHolder rendererHolder = rendererHolderArr[i3];
                    if (rendererHolder.w(mediaPeriodHolderY) && rendererHolder.r(mediaPeriodHolderY)) {
                        long j3 = mediaPeriodHolderY.f43150h.f43164e;
                        rendererHolder.O(mediaPeriodHolderY, (j3 == -9223372036854775807L || j3 == Long.MIN_VALUE) ? -9223372036854775807L : mediaPeriodHolderY.m() + mediaPeriodHolderY.f43150h.f43164e);
                    }
                    i3++;
                }
                return;
            }
            return;
        }
        if (Y()) {
            if (t() && this.f43072t.x() == this.f43072t.y()) {
                return;
            }
            if (mediaPeriodHolderY.k().f43148f || this.T >= mediaPeriodHolderY.k().n()) {
                TrackSelectorResult trackSelectorResultP = mediaPeriodHolderY.p();
                MediaPeriodHolder mediaPeriodHolderD = this.f43072t.d();
                TrackSelectorResult trackSelectorResultP2 = mediaPeriodHolderD.p();
                Timeline timeline = this.E.f43234a;
                L1(timeline, mediaPeriodHolderD.f43150h.f43160a, timeline, mediaPeriodHolderY.f43150h.f43160a, -9223372036854775807L, false);
                if (mediaPeriodHolderD.f43148f && ((this.B && this.f43054c0 != -9223372036854775807L) || mediaPeriodHolderD.f43143a.l() != -9223372036854775807L)) {
                    this.f43054c0 = -9223372036854775807L;
                    boolean z2 = this.B && !this.f43056d0;
                    if (z2) {
                        int i4 = 0;
                        while (true) {
                            if (i4 >= this.f43049a.length) {
                                break;
                            }
                            if (trackSelectorResultP2.c(i4) && !MimeTypes.a(trackSelectorResultP2.f45457c[i4].l().f40632o, trackSelectorResultP2.f45457c[i4].l().f40628k) && !this.f43049a[i4].u()) {
                                z2 = false;
                                break;
                            }
                            i4++;
                        }
                    }
                    if (!z2) {
                        Y0(mediaPeriodHolderD.n());
                        if (mediaPeriodHolderD.s()) {
                            return;
                        }
                        this.f43072t.N(mediaPeriodHolderD);
                        R(false);
                        d0();
                        return;
                    }
                }
                RendererHolder[] rendererHolderArr2 = this.f43049a;
                int length2 = rendererHolderArr2.length;
                while (i3 < length2) {
                    rendererHolderArr2[i3].F(trackSelectorResultP, trackSelectorResultP2, mediaPeriodHolderD.n());
                    i3++;
                }
            }
        }
    }

    private void r(MediaSourceListUpdateMessage mediaSourceListUpdateMessage, int i3) throws Throwable {
        this.F.b(1);
        MediaSourceList mediaSourceList = this.f43073u;
        if (i3 == -1) {
            i3 = mediaSourceList.r();
        }
        T(mediaSourceList.f(i3, mediaSourceListUpdateMessage.f43080a, mediaSourceListUpdateMessage.f43081b), false);
    }

    private void r0() {
        MediaPeriodHolder mediaPeriodHolderY = this.f43072t.y();
        if (mediaPeriodHolderY == null || this.f43072t.u() == mediaPeriodHolderY || mediaPeriodHolderY.f43151i || !O1()) {
            return;
        }
        this.f43072t.y().f43151i = true;
    }

    private void r1(Object obj, AtomicBoolean atomicBoolean) {
        for (RendererHolder rendererHolder : this.f43049a) {
            rendererHolder.S(obj);
        }
        int i3 = this.E.f43238e;
        if (i3 == 3 || i3 == 2) {
            this.f43061i.k(2);
        }
        if (atomicBoolean != null) {
            synchronized (this) {
                atomicBoolean.set(true);
                notifyAll();
            }
        }
    }

    private void s() {
        TrackSelectorResult trackSelectorResultP = this.f43072t.u().p();
        for (int i3 = 0; i3 < this.f43049a.length; i3++) {
            if (trackSelectorResultP.c(i3)) {
                this.f43049a[i3].f();
            }
        }
    }

    private void s0() throws Throwable {
        T(this.f43073u.i(), true);
    }

    private void s1(float f3) {
        this.f43057e0 = f3;
        float f4 = f3 * this.C.f();
        for (RendererHolder rendererHolder : this.f43049a) {
            rendererHolder.T(f4);
        }
    }

    private boolean t() {
        if (!this.B) {
            return false;
        }
        for (RendererHolder rendererHolder : this.f43049a) {
            if (rendererHolder.u()) {
                return true;
            }
        }
        return false;
    }

    private void t0(MoveMediaItemsMessage moveMediaItemsMessage) throws Throwable {
        this.F.b(1);
        T(this.f43073u.v(moveMediaItemsMessage.f43084a, moveMediaItemsMessage.f43085b, moveMediaItemsMessage.f43086c, moveMediaItemsMessage.f43087d), false);
    }

    private boolean t1() {
        MediaPeriodHolder mediaPeriodHolderU;
        MediaPeriodHolder mediaPeriodHolderK;
        return v1() && !this.I && (mediaPeriodHolderU = this.f43072t.u()) != null && (mediaPeriodHolderK = mediaPeriodHolderU.k()) != null && this.T >= mediaPeriodHolderK.n() && mediaPeriodHolderK.f43151i;
    }

    private void u() throws ExoPlaybackException {
        F0();
    }

    private void u0() {
        for (MediaPeriodHolder mediaPeriodHolderU = this.f43072t.u(); mediaPeriodHolderU != null; mediaPeriodHolderU = mediaPeriodHolderU.k()) {
            for (ExoTrackSelection exoTrackSelection : mediaPeriodHolderU.p().f45457c) {
                if (exoTrackSelection != null) {
                    exoTrackSelection.f();
                }
            }
        }
    }

    private boolean u1() {
        if (!a0(this.f43072t.n())) {
            return false;
        }
        MediaPeriodHolder mediaPeriodHolderN = this.f43072t.n();
        long jM = M(mediaPeriodHolderN.l());
        LoadControl.Parameters parameters = new LoadControl.Parameters(this.f43076x, this.E.f43234a, mediaPeriodHolderN.f43150h.f43160a, mediaPeriodHolderN == this.f43072t.u() ? mediaPeriodHolderN.C(this.T) : mediaPeriodHolderN.C(this.T) - mediaPeriodHolderN.f43150h.f43161b, jM, this.f43068p.d().f40953a, this.E.f43245l, this.J, x1(this.E.f43234a, mediaPeriodHolderN.f43150h.f43160a) ? this.f43074v.c() : -9223372036854775807L, this.K);
        boolean zK = this.f43059g.k(parameters);
        MediaPeriodHolder mediaPeriodHolderU = this.f43072t.u();
        if (zK || !mediaPeriodHolderU.f43148f || jM >= 500000) {
            return zK;
        }
        if (this.f43066n <= 0 && !this.f43067o) {
            return zK;
        }
        mediaPeriodHolderU.f43143a.u(this.E.f43252s, false);
        return this.f43059g.k(parameters);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public MediaPeriodHolder v(MediaPeriodInfo mediaPeriodInfo, long j3) {
        return new MediaPeriodHolder(this.f43051b, j3, this.f43055d, this.f43059g.h(), this.f43073u, mediaPeriodInfo, this.f43058f, this.f43050a0.f42990a);
    }

    private void v0(boolean z2) {
        for (MediaPeriodHolder mediaPeriodHolderU = this.f43072t.u(); mediaPeriodHolderU != null; mediaPeriodHolderU = mediaPeriodHolderU.k()) {
            for (ExoTrackSelection exoTrackSelection : mediaPeriodHolderU.p().f45457c) {
                if (exoTrackSelection != null) {
                    exoTrackSelection.i(z2);
                }
            }
        }
    }

    private boolean v1() {
        PlaybackInfo playbackInfo = this.E;
        return playbackInfo.f43245l && playbackInfo.f43247n == 0;
    }

    private void w(PlayerMessage playerMessage) {
        if (playerMessage.i()) {
            return;
        }
        try {
            playerMessage.f().w(playerMessage.h(), playerMessage.d());
        } finally {
            playerMessage.j(true);
        }
    }

    private void w0() {
        for (MediaPeriodHolder mediaPeriodHolderU = this.f43072t.u(); mediaPeriodHolderU != null; mediaPeriodHolderU = mediaPeriodHolderU.k()) {
            for (ExoTrackSelection exoTrackSelection : mediaPeriodHolderU.p().f45457c) {
                if (exoTrackSelection != null) {
                    exoTrackSelection.m();
                }
            }
        }
    }

    private boolean w1(boolean z2) {
        if (this.R == 0) {
            return b0();
        }
        boolean z3 = false;
        if (!z2) {
            return false;
        }
        if (!this.E.f43240g) {
            return true;
        }
        MediaPeriodHolder mediaPeriodHolderU = this.f43072t.u();
        long jC = x1(this.E.f43234a, mediaPeriodHolderU.f43150h.f43160a) ? this.f43074v.c() : -9223372036854775807L;
        MediaPeriodHolder mediaPeriodHolderN = this.f43072t.n();
        boolean z4 = mediaPeriodHolderN.s() && mediaPeriodHolderN.f43150h.f43169j;
        if (mediaPeriodHolderN.f43150h.f43160a.c() && !mediaPeriodHolderN.f43148f) {
            z3 = true;
        }
        if (z4 || z3) {
            return true;
        }
        return this.f43059g.a(new LoadControl.Parameters(this.f43076x, this.E.f43234a, mediaPeriodHolderU.f43150h.f43160a, mediaPeriodHolderU.C(this.T), M(mediaPeriodHolderN.j()), this.f43068p.d().f40953a, this.E.f43245l, this.J, jC, this.K));
    }

    private void x() {
        if (this.B && t()) {
            for (RendererHolder rendererHolder : this.f43049a) {
                int iH = rendererHolder.h();
                rendererHolder.c(this.f43068p);
                this.R -= iH - rendererHolder.h();
            }
            this.f43054c0 = -9223372036854775807L;
        }
    }

    private boolean x1(Timeline timeline, MediaSource.MediaPeriodId mediaPeriodId) {
        if (!mediaPeriodId.c() && !timeline.q()) {
            timeline.n(timeline.h(mediaPeriodId.f44754a, this.f43065m).f41116c, this.f43064l);
            if (this.f43064l.f()) {
                Timeline.Window window = this.f43064l;
                if (window.f41143i && window.f41140f != -9223372036854775807L) {
                    return true;
                }
            }
        }
        return false;
    }

    private void y(int i3) {
        int iH = this.f43049a[i3].h();
        this.f43049a[i3].b(this.f43068p);
        j0(i3, false);
        this.R -= iH;
    }

    private void y1() {
        MediaPeriodHolder mediaPeriodHolderU = this.f43072t.u();
        if (mediaPeriodHolderU == null) {
            return;
        }
        TrackSelectorResult trackSelectorResultP = mediaPeriodHolderU.p();
        for (int i3 = 0; i3 < this.f43049a.length; i3++) {
            if (trackSelectorResultP.c(i3)) {
                this.f43049a[i3].U();
            }
        }
    }

    private void z() {
        for (int i3 = 0; i3 < this.f43049a.length; i3++) {
            y(i3);
        }
        this.f43054c0 = -9223372036854775807L;
    }

    private void z0() {
        this.F.b(1);
        G0(false, false, false, true);
        this.f43059g.d(this.f43076x);
        p1(this.E.f43234a.q() ? 4 : 2);
        H1();
        this.f43073u.w(this.f43060h.d());
        this.f43061i.k(2);
    }

    public synchronized boolean A0() {
        if (!this.G && this.f43063k.getThread().isAlive()) {
            this.f43061i.k(7);
            Q1(new Supplier() { // from class: androidx.media3.exoplayer.y1
                @Override // com.google.common.base.Supplier
                public final Object get() {
                    return Boolean.valueOf(this.f46019a.G);
                }
            }, this.f43075w);
            return this.G;
        }
        return true;
    }

    public void E(long j3) {
        this.Y = j3;
    }

    public Looper K() {
        return this.f43063k;
    }

    public void Q0(Timeline timeline, int i3, long j3) {
        this.f43061i.e(3, new SeekPosition(timeline, i3, j3)).a();
    }

    public void Z0(AudioAttributes audioAttributes, boolean z2) {
        this.f43061i.d(31, z2 ? 1 : 0, 0, audioAttributes).a();
    }

    @Override // androidx.media3.exoplayer.trackselection.TrackSelector.InvalidationListener
    public void a(Renderer renderer) {
        this.f43061i.k(26);
    }

    @Override // androidx.media3.exoplayer.trackselection.TrackSelector.InvalidationListener
    public void b() {
        this.f43061i.k(10);
    }

    @Override // androidx.media3.exoplayer.MediaSourceList.MediaSourceListInfoRefreshListener
    public void c() {
        this.f43061i.m(2);
        this.f43061i.k(22);
    }

    @Override // androidx.media3.exoplayer.AudioFocusManager.PlayerControl
    public void d(float f3) {
        this.f43061i.k(34);
    }

    @Override // androidx.media3.exoplayer.AudioFocusManager.PlayerControl
    public void e(int i3) {
        this.f43061i.h(33, i3, 0).a();
    }

    public void e1(List list, int i3, long j3, ShuffleOrder shuffleOrder) {
        this.f43061i.e(17, new MediaSourceListUpdateMessage(list, shuffleOrder, i3, j3)).a();
    }

    @Override // androidx.media3.exoplayer.PlayerMessage.Sender
    public synchronized void f(PlayerMessage playerMessage) {
        if (!this.G && this.f43063k.getThread().isAlive()) {
            this.f43061i.e(14, playerMessage).a();
            return;
        }
        Log.i("ExoPlayerImplInternal", "Ignoring messages sent after release.");
        playerMessage.j(false);
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod.Callback
    public void g(MediaPeriod mediaPeriod) {
        this.f43061i.e(8, mediaPeriod).a();
    }

    public void h1(boolean z2, int i3, int i4) {
        this.f43061i.h(1, z2 ? 1 : 0, i3 | (i4 << 4)).a();
    }

    @Override // androidx.media3.exoplayer.DefaultMediaClock.PlaybackParametersListener
    public void j(PlaybackParameters playbackParameters) {
        this.f43061i.e(16, playbackParameters).a();
    }

    public synchronized boolean q1(Object obj, long j3) {
        if (!this.G && this.f43063k.getThread().isAlive()) {
            final AtomicBoolean atomicBoolean = new AtomicBoolean();
            this.f43061i.e(30, new Pair(obj, atomicBoolean)).a();
            if (j3 == -9223372036854775807L) {
                return true;
            }
            Q1(new Supplier() { // from class: androidx.media3.exoplayer.w1
                @Override // com.google.common.base.Supplier
                public final Object get() {
                    return Boolean.valueOf(atomicBoolean.get());
                }
            }, j3);
            return atomicBoolean.get();
        }
        return true;
    }

    @Override // androidx.media3.exoplayer.source.SequenceableLoader.Callback
    /* JADX INFO: renamed from: x0, reason: merged with bridge method [inline-methods] */
    public void h(MediaPeriod mediaPeriod) {
        this.f43061i.e(9, mediaPeriod).a();
    }

    public void y0() {
        this.f43061i.b(29).a();
    }

    public void z1() {
        this.f43061i.b(6).a();
    }

    /* JADX WARN: Removed duplicated region for block: B:121:0x0231  */
    @Override // android.os.Handler.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean handleMessage(android.os.Message r16) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 776
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.ExoPlayerImplInternal.handleMessage(android.os.Message):boolean");
    }
}
