package androidx.media3.transformer;

import android.util.Pair;
import android.util.SparseBooleanArray;
import android.view.Surface;
import android.view.SurfaceHolder;
import androidx.media3.common.PlaybackException;
import androidx.media3.common.Player;
import androidx.media3.common.SimpleBasePlayer;
import androidx.media3.common.Timeline;
import androidx.media3.common.VideoFrameProcessingException;
import androidx.media3.common.VideoSize;
import androidx.media3.common.audio.SpeedProvider;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.HandlerWrapper;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Size;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.media3.exoplayer.audio.AudioSink;
import androidx.media3.exoplayer.source.ForwardingTimeline;
import androidx.media3.exoplayer.source.MediaPeriod;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.source.TrackGroupArray;
import androidx.media3.exoplayer.source.WrappingMediaSource;
import androidx.media3.exoplayer.trackselection.DefaultTrackSelector;
import androidx.media3.exoplayer.trackselection.MappingTrackSelector;
import androidx.media3.exoplayer.upstream.Allocator;
import androidx.media3.exoplayer.video.PlaybackVideoGraphWrapper;
import androidx.media3.exoplayer.video.VideoFrameReleaseControl;
import androidx.media3.transformer.CompositionPlayerInternal;
import com.facebook.ads.AdError;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class CompositionPlayer extends SimpleBasePlayer implements CompositionPlayerInternal.Listener, PlaybackVideoGraphWrapper.Listener, SurfaceHolder.Callback {
    private static final Player.Commands F = new Player.Commands.Builder().c(1, 2, 3, 5, 8, 4, 11, 12, 16, 17, 15, 27, 22, 24, 32).e();
    private static final int[] G = {4, 5, 10, 11, 1};
    private boolean A;
    private SimpleBasePlayer.LivePositionSupplier B;
    private SimpleBasePlayer.LivePositionSupplier C;
    private SimpleBasePlayer.LivePositionSupplier D;
    private boolean E;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final HandlerWrapper f47984j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final List f47985k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final AudioSink f47986l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final SparseBooleanArray f47987m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private CompositionPlayerInternal f47988n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private ImmutableList f47989o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private Composition f47990p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private Size f47991q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private PlaybackVideoGraphWrapper f47992r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f47993s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f47994t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private int f47995u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private float f47996v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private boolean f47997w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private PlaybackException f47998x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private int f47999y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private Surface f48000z;

    /* JADX INFO: renamed from: androidx.media3.transformer.CompositionPlayer$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass1 extends WrappingMediaSource {

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        final /* synthetic */ SpeedProvider f48001n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        final /* synthetic */ long f48002o;

        @Override // androidx.media3.exoplayer.source.WrappingMediaSource, androidx.media3.exoplayer.source.MediaSource
        public void B(MediaPeriod mediaPeriod) {
            super.B(((SpeedProviderMediaPeriod) mediaPeriod).f48447a);
        }

        @Override // androidx.media3.exoplayer.source.WrappingMediaSource
        protected void E0(final Timeline timeline) {
            super.E0(new ForwardingTimeline(timeline) { // from class: androidx.media3.transformer.CompositionPlayer.1.1
                @Override // androidx.media3.exoplayer.source.ForwardingTimeline, androidx.media3.common.Timeline
                public Timeline.Period g(int i3, Timeline.Period period, boolean z2) {
                    Timeline.Period periodG = timeline.g(i3, period, z2);
                    periodG.f41117d = AnonymousClass1.this.f48002o;
                    return periodG;
                }

                @Override // androidx.media3.exoplayer.source.ForwardingTimeline, androidx.media3.common.Timeline
                public Timeline.Window o(int i3, Timeline.Window window, long j3) {
                    Timeline.Window windowO = timeline.o(i3, window, j3);
                    windowO.f41147m = AnonymousClass1.this.f48002o;
                    return windowO;
                }
            });
        }

        @Override // androidx.media3.exoplayer.source.WrappingMediaSource, androidx.media3.exoplayer.source.MediaSource
        public MediaPeriod j(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator, long j3) {
            return new SpeedProviderMediaPeriod(super.j(mediaPeriodId, allocator, j3), this.f48001n);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Builder {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class CompositionFrameTimingEvaluator implements VideoFrameReleaseControl.FrameTimingEvaluator {
        @Override // androidx.media3.exoplayer.video.VideoFrameReleaseControl.FrameTimingEvaluator
        public boolean A(long j3, long j4) {
            return j3 < -30000 && j4 > 100000;
        }

        @Override // androidx.media3.exoplayer.video.VideoFrameReleaseControl.FrameTimingEvaluator
        public boolean C(long j3, long j4, long j5, boolean z2, boolean z3) {
            return false;
        }

        @Override // androidx.media3.exoplayer.video.VideoFrameReleaseControl.FrameTimingEvaluator
        public boolean M(long j3, long j4, boolean z2) {
            return j3 < -30000 && !z2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private final class CompositionTrackSelector extends DefaultTrackSelector {

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private final int f48005k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private final boolean f48006l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        final /* synthetic */ CompositionPlayer f48007m;

        @Override // androidx.media3.exoplayer.trackselection.DefaultTrackSelector
        protected Pair X(MappingTrackSelector.MappedTrackInfo mappedTrackInfo, int[][][] iArr, int[] iArr2, DefaultTrackSelector.Parameters parameters) {
            int i3 = 0;
            while (true) {
                if (i3 >= mappedTrackInfo.d()) {
                    i3 = -1;
                    break;
                }
                if (mappedTrackInfo.e(i3) == 1) {
                    break;
                }
                i3++;
            }
            Assertions.g(i3 != -1);
            TrackGroupArray trackGroupArrayF = mappedTrackInfo.f(i3);
            if (trackGroupArrayF.f44987a > 1) {
                boolean z2 = false;
                int i4 = -1;
                for (int i5 = 0; i5 < trackGroupArrayF.f44987a; i5++) {
                    if (trackGroupArrayF.b(i5).f41154b.startsWith("1:")) {
                        i4 = i5;
                    } else {
                        for (int i6 = 0; i6 < trackGroupArrayF.b(i5).f41153a; i6++) {
                            z2 |= RendererCapabilities.R(iArr[i3][i5][i6]) == 4;
                        }
                    }
                }
                Assertions.g(i4 != -1);
                if (z2) {
                    iArr[i3][trackGroupArrayF.f44987a - 1][0] = RendererCapabilities.u(0);
                }
            }
            return super.X(mappedTrackInfo, iArr, iArr2, parameters);
        }

        @Override // androidx.media3.exoplayer.trackselection.DefaultTrackSelector
        protected Pair Y(MappingTrackSelector.MappedTrackInfo mappedTrackInfo, int[][][] iArr, DefaultTrackSelector.Parameters parameters) {
            Pair pairY = super.Y(mappedTrackInfo, iArr, parameters);
            if (this.f48006l) {
                pairY = null;
            }
            this.f48007m.m2(pairY != null, this.f48005k);
            return pairY;
        }

        @Override // androidx.media3.exoplayer.trackselection.DefaultTrackSelector
        protected Pair c0(MappingTrackSelector.MappedTrackInfo mappedTrackInfo, int[][][] iArr, int[] iArr2, DefaultTrackSelector.Parameters parameters, String str) {
            Pair pairC0 = super.c0(mappedTrackInfo, iArr, iArr2, parameters, str);
            if (this.f48006l) {
                pairC0 = null;
            }
            this.f48007m.m2(pairC0 != null, this.f48005k);
            return pairC0;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private final class PlayerListener implements Player.Listener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f48008a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ CompositionPlayer f48009b;

        @Override // androidx.media3.common.Player.Listener
        public void G(int i3) {
            this.f48009b.q2();
        }

        @Override // androidx.media3.common.Player.Listener
        public void T(PlaybackException playbackException) {
            this.f48009b.l2("error from player " + this.f48008a, playbackException, playbackException.f40947a);
        }

        @Override // androidx.media3.common.Player.Listener
        public void c0(Player player, Player.Events events) {
            if (events.a(CompositionPlayer.G)) {
                this.f48009b.I1();
            }
        }

        @Override // androidx.media3.common.Player.Listener
        public void s0(boolean z2, int i3) {
            this.f48009b.f47994t = i3;
            if (i3 == 5 && this.f48009b.f47995u != 0 && this.f48008a == 0) {
                this.f48009b.n2();
            }
        }
    }

    public static /* synthetic */ void U1(CompositionPlayer compositionPlayer) {
        compositionPlayer.f47997w = true;
        compositionPlayer.I1();
    }

    private void f2() {
        this.f48000z = null;
        CompositionPlayerInternal compositionPlayerInternal = this.f47988n;
        if (compositionPlayerInternal != null) {
            compositionPlayerInternal.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long g2() {
        if (this.f47985k.isEmpty()) {
            return 0L;
        }
        long jMin = 2147483647L;
        for (int i3 = 0; i3 < this.f47985k.size(); i3++) {
            int iP = ((ExoPlayer) this.f47985k.get(i3)).p();
            if (iP == 3 || iP == 2) {
                jMin = Math.min(jMin, ((ExoPlayer) this.f47985k.get(i3)).Z());
            }
        }
        if (jMin == 2147483647L) {
            return 0L;
        }
        return jMin;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long h2() {
        long jMax = 0;
        if (this.f47985k.isEmpty()) {
            return 0L;
        }
        for (int i3 = 0; i3 < this.f47985k.size(); i3++) {
            jMax = Math.max(jMax, ((ExoPlayer) this.f47985k.get(i3)).X());
        }
        return jMax;
    }

    private boolean i2() {
        boolean z2 = this.f47997w;
        this.f47997w = false;
        return z2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long j2() {
        if (this.f47985k.isEmpty()) {
            return 0L;
        }
        long jMin = 2147483647L;
        for (int i3 = 0; i3 < this.f47985k.size(); i3++) {
            int iP = ((ExoPlayer) this.f47985k.get(i3)).p();
            if (iP == 3 || iP == 2) {
                jMin = Math.min(jMin, ((ExoPlayer) this.f47985k.get(i3)).g());
            }
        }
        if (jMin == 2147483647L) {
            return 0L;
        }
        return jMin;
    }

    private void k2(int i3, int i4) {
        CompositionPlayerInternal compositionPlayerInternal;
        Surface surface = this.f48000z;
        if (i3 == 0 || i4 == 0 || surface == null || (compositionPlayerInternal = this.f47988n) == null) {
            return;
        }
        compositionPlayerInternal.g(surface, new Size(i3, i4));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l2(String str, Exception exc, int i3) {
        if (this.f47998x != null) {
            Log.j("CompositionPlayer", str, exc);
            return;
        }
        this.f47998x = new PlaybackException(str, exc, i3);
        for (int i4 = 0; i4 < this.f47985k.size(); i4++) {
            ((ExoPlayer) this.f47985k.get(i4)).stop();
        }
        q2();
        I1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m2(boolean z2, int i3) {
        this.f47987m.put(i3, z2);
        if (this.f47987m.size() == ((Composition) Assertions.e(this.f47990p)).f47968a.size()) {
            int i4 = 0;
            for (int i5 = 0; i5 < this.f47987m.size(); i5++) {
                SparseBooleanArray sparseBooleanArray = this.f47987m;
                if (sparseBooleanArray.get(sparseBooleanArray.keyAt(i5))) {
                    i4++;
                }
            }
            ((PlaybackVideoGraphWrapper) Assertions.e(this.f47992r)).S(i4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n2() {
        this.A = true;
        j();
    }

    private void o2() {
        this.B.e(h2());
        this.C.e(g2());
        this.D.e(j2());
        this.B = new SimpleBasePlayer.LivePositionSupplier(new SimpleBasePlayer.PositionSupplier() { // from class: androidx.media3.transformer.w
            @Override // androidx.media3.common.SimpleBasePlayer.PositionSupplier
            public final long get() {
                return this.f48723b.h2();
            }
        });
        this.C = new SimpleBasePlayer.LivePositionSupplier(new SimpleBasePlayer.PositionSupplier() { // from class: androidx.media3.transformer.x
            @Override // androidx.media3.common.SimpleBasePlayer.PositionSupplier
            public final long get() {
                return this.f48725b.g2();
            }
        });
        this.D = new SimpleBasePlayer.LivePositionSupplier(new SimpleBasePlayer.PositionSupplier() { // from class: androidx.media3.transformer.y
            @Override // androidx.media3.common.SimpleBasePlayer.PositionSupplier
            public final long get() {
                return this.f48727b.j2();
            }
        });
    }

    private void p2(Surface surface, Size size) {
        this.f48000z = surface;
        k2(size.b(), size.a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q2() {
        if (this.f47985k.isEmpty() || this.f47998x != null) {
            this.f47999y = 1;
            return;
        }
        int i3 = this.f47999y;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        for (int i7 = 0; i7 < this.f47985k.size(); i7++) {
            int iP = ((ExoPlayer) this.f47985k.get(i7)).p();
            if (iP == 1) {
                i4++;
            } else if (iP == 2) {
                i5++;
            } else if (iP == 3) {
                continue;
            } else {
                if (iP != 4) {
                    throw new IllegalStateException(String.valueOf(iP));
                }
                i6++;
            }
        }
        if (i4 > 0) {
            this.f47999y = 1;
            return;
        }
        if (i5 > 0) {
            this.f47999y = 2;
            if (i3 == 3 && this.f47993s) {
                for (int i8 = 0; i8 < this.f47985k.size(); i8++) {
                    ((ExoPlayer) this.f47985k.get(i8)).n(false);
                }
                if (this.E) {
                    return;
                }
                this.f47986l.pause();
                return;
            }
            return;
        }
        if (i6 == this.f47985k.size()) {
            this.f47999y = 4;
            return;
        }
        this.f47999y = 3;
        this.E = false;
        if (i3 == 3 || !this.f47993s) {
            return;
        }
        for (int i9 = 0; i9 < this.f47985k.size(); i9++) {
            ((ExoPlayer) this.f47985k.get(i9)).n(true);
        }
        this.f47986l.q();
    }

    @Override // androidx.media3.common.SimpleBasePlayer
    protected SimpleBasePlayer.State C1() {
        SimpleBasePlayer.State.Builder builderH0 = new SimpleBasePlayer.State.Builder().V(F).k0(this.f47999y).m0(this.f47998x).i0(this.f47993s, this.f47994t).r0(this.f47995u).A0(this.f47996v).Y(this.B).W(this.C).x0(this.D).h0(i2());
        if (this.A) {
            builderH0.q0(0, -9223372036854775807L);
            this.A = false;
        }
        ImmutableList immutableList = this.f47989o;
        if (immutableList != null) {
            builderH0.o0(immutableList);
        }
        return builderH0.Q();
    }

    @Override // androidx.media3.common.SimpleBasePlayer
    protected ListenableFuture F1(int i3, long j3, int i4) {
        o2();
        CompositionPlayerInternal compositionPlayerInternal = (CompositionPlayerInternal) Assertions.i(this.f47988n);
        this.E = true;
        compositionPlayerInternal.i(j3);
        for (int i5 = 0; i5 < this.f47985k.size(); i5++) {
            ((ExoPlayer) this.f47985k.get(i5)).v(j3);
        }
        compositionPlayerInternal.d();
        return Futures.g();
    }

    @Override // androidx.media3.common.SimpleBasePlayer
    protected ListenableFuture H1(boolean z2) {
        this.f47993s = z2;
        this.f47994t = 1;
        if (this.f47999y == 3) {
            if (z2) {
                this.f47986l.q();
            } else {
                this.f47986l.pause();
            }
            for (int i3 = 0; i3 < this.f47985k.size(); i3++) {
                ((ExoPlayer) this.f47985k.get(i3)).n(z2);
            }
        }
        return Futures.g();
    }

    @Override // androidx.media3.transformer.CompositionPlayerInternal.Listener
    public void P(String str, Exception exc, int i3) {
        l2(str, exc, i3);
    }

    @Override // androidx.media3.exoplayer.video.PlaybackVideoGraphWrapper.Listener
    public void b0(PlaybackVideoGraphWrapper playbackVideoGraphWrapper) {
        this.f47984j.j(new Runnable() { // from class: androidx.media3.transformer.v
            @Override // java.lang.Runnable
            public final void run() {
                CompositionPlayer.U1(this.f48720a);
            }
        });
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i3, int i4, int i5) {
        k2(i4, i5);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.f47991q = new Size(surfaceHolder.getSurfaceFrame().width(), surfaceHolder.getSurfaceFrame().height());
        p2(surfaceHolder.getSurface(), this.f47991q);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        f2();
    }

    @Override // androidx.media3.exoplayer.video.PlaybackVideoGraphWrapper.Listener
    public void w(PlaybackVideoGraphWrapper playbackVideoGraphWrapper, final VideoFrameProcessingException videoFrameProcessingException) {
        this.f47984j.j(new Runnable() { // from class: androidx.media3.transformer.z
            @Override // java.lang.Runnable
            public final void run() {
                this.f48728a.l2("Error processing video frames", videoFrameProcessingException, AdError.SHOW_CALLED_BEFORE_LOAD_ERROR_CODE);
            }
        });
    }

    @Override // androidx.media3.exoplayer.video.PlaybackVideoGraphWrapper.Listener
    public void e0(PlaybackVideoGraphWrapper playbackVideoGraphWrapper) {
    }

    @Override // androidx.media3.exoplayer.video.PlaybackVideoGraphWrapper.Listener
    public void z(PlaybackVideoGraphWrapper playbackVideoGraphWrapper, VideoSize videoSize) {
    }
}
