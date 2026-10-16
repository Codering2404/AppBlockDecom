package androidx.media3.exoplayer.source.preload;

import android.os.Handler;
import android.os.Looper;
import android.util.Pair;
import androidx.media3.common.MediaItem;
import androidx.media3.common.Timeline;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.ExoPlaybackException;
import androidx.media3.exoplayer.LoadingInfo;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.media3.exoplayer.analytics.PlayerId;
import androidx.media3.exoplayer.drm.DrmSessionManagerProvider;
import androidx.media3.exoplayer.source.MediaPeriod;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.source.WrappingMediaSource;
import androidx.media3.exoplayer.source.preload.PreloadMediaSource;
import androidx.media3.exoplayer.trackselection.TrackSelector;
import androidx.media3.exoplayer.trackselection.TrackSelectorResult;
import androidx.media3.exoplayer.upstream.Allocator;
import androidx.media3.exoplayer.upstream.BandwidthMeter;
import androidx.media3.exoplayer.upstream.CmcdConfiguration;
import androidx.media3.exoplayer.upstream.LoadErrorHandlingPolicy;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class PreloadMediaSource extends WrappingMediaSource {
    private boolean A;
    private boolean B;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final PreloadControl f45229n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final TrackSelector f45230o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final BandwidthMeter f45231p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final RendererCapabilities[] f45232q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final Allocator f45233r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final Handler f45234s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final Handler f45235t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private boolean f45236u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private boolean f45237v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private long f45238w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private Timeline f45239x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private Pair f45240y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private Pair f45241z;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Factory implements MediaSource.Factory {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final MediaSource.Factory f45242c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final Looper f45243d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final Allocator f45244e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final TrackSelector f45245f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final BandwidthMeter f45246g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final RendererCapabilities[] f45247h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private final PreloadControl f45248i;

        @Override // androidx.media3.exoplayer.source.MediaSource.Factory
        public int[] e() {
            return this.f45242c.e();
        }

        @Override // androidx.media3.exoplayer.source.MediaSource.Factory
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public PreloadMediaSource c(MediaItem mediaItem) {
            return new PreloadMediaSource(this.f45242c.c(mediaItem), this.f45248i, this.f45245f, this.f45246g, this.f45247h, this.f45244e, this.f45243d);
        }

        @Override // androidx.media3.exoplayer.source.MediaSource.Factory
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public Factory h(CmcdConfiguration.Factory factory) {
            this.f45242c.h(factory);
            return this;
        }

        @Override // androidx.media3.exoplayer.source.MediaSource.Factory
        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
        public Factory d(DrmSessionManagerProvider drmSessionManagerProvider) {
            this.f45242c.d(drmSessionManagerProvider);
            return this;
        }

        @Override // androidx.media3.exoplayer.source.MediaSource.Factory
        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
        public Factory f(LoadErrorHandlingPolicy loadErrorHandlingPolicy) {
            this.f45242c.f(loadErrorHandlingPolicy);
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class MediaPeriodKey {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final MediaSource.MediaPeriodId f45249a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Long f45250b;

        public MediaPeriodKey(MediaSource.MediaPeriodId mediaPeriodId, long j3) {
            this.f45249a = mediaPeriodId;
            this.f45250b = Long.valueOf(j3);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof MediaPeriodKey)) {
                return false;
            }
            MediaPeriodKey mediaPeriodKey = (MediaPeriodKey) obj;
            return PreloadMediaSource.Z0(this.f45249a, mediaPeriodKey.f45249a) && this.f45250b.equals(mediaPeriodKey.f45250b);
        }

        public int hashCode() {
            int iHashCode = (527 + this.f45249a.f44754a.hashCode()) * 31;
            MediaSource.MediaPeriodId mediaPeriodId = this.f45249a;
            return ((((((iHashCode + mediaPeriodId.f44755b) * 31) + mediaPeriodId.f44756c) * 31) + mediaPeriodId.f44758e) * 31) + this.f45250b.intValue();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class PreloadMediaPeriodCallback implements MediaPeriod.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f45251a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f45252b;

        public PreloadMediaPeriodCallback(long j3) {
            this.f45251a = j3;
        }

        public static /* synthetic */ void a(PreloadMediaPeriodCallback preloadMediaPeriodCallback, MediaPeriod mediaPeriod) {
            if (PreloadMediaSource.this.Y0()) {
                return;
            }
            PreloadMediaPeriod preloadMediaPeriod = (PreloadMediaPeriod) mediaPeriod;
            if (preloadMediaPeriodCallback.f45252b) {
                long jE = mediaPeriod.e();
                if (jE == Long.MIN_VALUE) {
                    PreloadMediaSource.this.f45229n.a(PreloadMediaSource.this);
                    PreloadMediaSource.this.c1();
                    return;
                } else if (!PreloadMediaSource.this.f45229n.c(PreloadMediaSource.this, jE - preloadMediaPeriodCallback.f45251a)) {
                    PreloadMediaSource.this.c1();
                    return;
                }
            }
            preloadMediaPeriod.b(new LoadingInfo.Builder().f(preloadMediaPeriodCallback.f45251a).d());
        }

        public static /* synthetic */ void b(PreloadMediaPeriodCallback preloadMediaPeriodCallback, MediaPeriod mediaPeriod) {
            TrackSelectorResult trackSelectorResultK;
            if (PreloadMediaSource.this.Y0()) {
                return;
            }
            PreloadMediaPeriod preloadMediaPeriod = (PreloadMediaPeriod) mediaPeriod;
            try {
                trackSelectorResultK = PreloadMediaSource.this.f45230o.k(PreloadMediaSource.this.f45232q, preloadMediaPeriod.s(), ((MediaPeriodKey) ((Pair) Assertions.e(PreloadMediaSource.this.f45240y)).second).f45249a, (Timeline) Assertions.e(PreloadMediaSource.this.f45239x));
            } catch (ExoPlaybackException e3) {
                Log.e("PreloadMediaSource", "Failed to select tracks", e3);
                trackSelectorResultK = null;
            }
            if (trackSelectorResultK == null) {
                PreloadMediaSource.this.c1();
                return;
            }
            preloadMediaPeriod.q(trackSelectorResultK.f45457c, preloadMediaPeriodCallback.f45251a);
            if (PreloadMediaSource.this.f45229n.e(PreloadMediaSource.this)) {
                preloadMediaPeriod.b(new LoadingInfo.Builder().f(preloadMediaPeriodCallback.f45251a).d());
            } else {
                PreloadMediaSource.this.c1();
            }
        }

        @Override // androidx.media3.exoplayer.source.SequenceableLoader.Callback
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void h(final MediaPeriod mediaPeriod) {
            PreloadMediaSource.this.f45234s.post(new Runnable() { // from class: androidx.media3.exoplayer.source.preload.n
                @Override // java.lang.Runnable
                public final void run() {
                    PreloadMediaSource.PreloadMediaPeriodCallback.a(this.f45272a, mediaPeriod);
                }
            });
        }

        @Override // androidx.media3.exoplayer.source.MediaPeriod.Callback
        public void g(final MediaPeriod mediaPeriod) {
            this.f45252b = true;
            PreloadMediaSource.this.f45234s.post(new Runnable() { // from class: androidx.media3.exoplayer.source.preload.m
                @Override // java.lang.Runnable
                public final void run() {
                    PreloadMediaSource.PreloadMediaPeriodCallback.b(this.f45270a, mediaPeriod);
                }
            });
        }
    }

    public static /* synthetic */ void I0(PreloadMediaSource preloadMediaSource) {
        Pair pair = preloadMediaSource.f45240y;
        if (pair != null) {
            preloadMediaSource.f44993l.B(((PreloadMediaPeriod) pair.first).f45218a);
            preloadMediaSource.f45240y = null;
        }
    }

    public static /* synthetic */ void K0(PreloadMediaSource preloadMediaSource, long j3) {
        preloadMediaSource.f45236u = true;
        preloadMediaSource.f45238w = j3;
        preloadMediaSource.A = false;
        if (preloadMediaSource.Y0()) {
            preloadMediaSource.a1();
            return;
        }
        preloadMediaSource.m0(PlayerId.f43489d);
        preloadMediaSource.f0(preloadMediaSource.f45231p.d());
        preloadMediaSource.V0();
    }

    public static /* synthetic */ void L0(PreloadMediaSource preloadMediaSource, Timeline timeline) {
        if (preloadMediaSource.Y0() || preloadMediaSource.A) {
            return;
        }
        preloadMediaSource.A = true;
        if (!preloadMediaSource.f45229n.d(preloadMediaSource)) {
            preloadMediaSource.c1();
        } else {
            Pair pairJ = timeline.j(new Timeline.Window(), new Timeline.Period(), 0, preloadMediaSource.f45238w);
            preloadMediaSource.j(new MediaSource.MediaPeriodId(pairJ.first), preloadMediaSource.f45233r, ((Long) pairJ.second).longValue()).n(preloadMediaSource.new PreloadMediaPeriodCallback(((Long) pairJ.second).longValue()), ((Long) pairJ.second).longValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V0() {
        try {
            L();
            Pair pair = this.f45240y;
            if (pair != null) {
                PreloadMediaPeriod preloadMediaPeriod = (PreloadMediaPeriod) pair.first;
                if (preloadMediaPeriod.f45219b) {
                    preloadMediaPeriod.h();
                } else {
                    preloadMediaPeriod.o();
                }
            }
            this.f45234s.postDelayed(new Runnable() { // from class: androidx.media3.exoplayer.source.preload.l
                @Override // java.lang.Runnable
                public final void run() {
                    this.f45269a.V0();
                }
            }, 100L);
        } catch (IOException e3) {
            this.f45229n.f(new PreloadException(m(), null, e3), this);
            c1();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Y0() {
        return e0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean Z0(MediaSource.MediaPeriodId mediaPeriodId, MediaSource.MediaPeriodId mediaPeriodId2) {
        return mediaPeriodId.f44754a.equals(mediaPeriodId2.f44754a) && mediaPeriodId.f44755b == mediaPeriodId2.f44755b && mediaPeriodId.f44756c == mediaPeriodId2.f44756c && mediaPeriodId.f44758e == mediaPeriodId2.f44758e;
    }

    private void a1() {
        this.f45229n.b(this);
        c1();
        this.B = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c1() {
        this.f45234s.removeCallbacksAndMessages(null);
    }

    @Override // androidx.media3.exoplayer.source.WrappingMediaSource, androidx.media3.exoplayer.source.MediaSource
    public void B(MediaPeriod mediaPeriod) {
        PreloadMediaPeriod preloadMediaPeriod = (PreloadMediaPeriod) mediaPeriod;
        Pair pair = this.f45240y;
        if (pair == null || preloadMediaPeriod != ((Pair) Assertions.e(pair)).first) {
            Pair pair2 = this.f45241z;
            if (pair2 != null && preloadMediaPeriod == ((Pair) Assertions.e(pair2)).first) {
                this.f45241z = null;
            }
        } else {
            this.f45240y = null;
        }
        this.f44993l.B(preloadMediaPeriod.f45218a);
    }

    @Override // androidx.media3.exoplayer.source.WrappingMediaSource
    protected void E0(final Timeline timeline) {
        this.f45239x = timeline;
        j0(timeline);
        this.f45234s.post(new Runnable() { // from class: androidx.media3.exoplayer.source.preload.i
            @Override // java.lang.Runnable
            public final void run() {
                PreloadMediaSource.L0(this.f45264a, timeline);
            }
        });
    }

    @Override // androidx.media3.exoplayer.source.WrappingMediaSource
    protected void H0() {
        if (Y0() && !this.B) {
            a1();
        }
        Timeline timeline = this.f45239x;
        if (timeline != null) {
            E0(timeline);
        } else {
            if (this.f45237v) {
                return;
            }
            this.f45237v = true;
            G0();
        }
    }

    public void W0() {
        Util.W0(this.f45234s, new Runnable() { // from class: androidx.media3.exoplayer.source.preload.j
            @Override // java.lang.Runnable
            public final void run() {
                PreloadMediaSource.I0(this.f45266a);
            }
        });
    }

    @Override // androidx.media3.exoplayer.source.WrappingMediaSource, androidx.media3.exoplayer.source.MediaSource
    /* JADX INFO: renamed from: X0, reason: merged with bridge method [inline-methods] */
    public PreloadMediaPeriod j(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator, long j3) {
        MediaPeriodKey mediaPeriodKey = new MediaPeriodKey(mediaPeriodId, j3);
        Pair pair = this.f45240y;
        if (pair != null && mediaPeriodKey.equals(pair.second)) {
            PreloadMediaPeriod preloadMediaPeriod = (PreloadMediaPeriod) ((Pair) Assertions.e(this.f45240y)).first;
            if (Y0()) {
                this.f45240y = null;
                this.f45241z = new Pair(preloadMediaPeriod, mediaPeriodId);
            }
            return preloadMediaPeriod;
        }
        Pair pair2 = this.f45240y;
        if (pair2 != null) {
            this.f44993l.B(((PreloadMediaPeriod) ((Pair) Assertions.e(pair2)).first).f45218a);
            this.f45240y = null;
        }
        PreloadMediaPeriod preloadMediaPeriod2 = new PreloadMediaPeriod(this.f44993l.j(mediaPeriodId, allocator, j3));
        if (!Y0()) {
            this.f45240y = new Pair(preloadMediaPeriod2, mediaPeriodKey);
        }
        return preloadMediaPeriod2;
    }

    public void b1(final long j3) {
        this.f45234s.post(new Runnable() { // from class: androidx.media3.exoplayer.source.preload.k
            @Override // java.lang.Runnable
            public final void run() {
                PreloadMediaSource.K0(this.f45267a, j3);
            }
        });
    }

    @Override // androidx.media3.exoplayer.source.CompositeMediaSource, androidx.media3.exoplayer.source.BaseMediaSource
    protected void l0() {
        if (Y0()) {
            return;
        }
        this.B = false;
        if (this.f45236u) {
            return;
        }
        this.f45239x = null;
        this.f45237v = false;
        super.l0();
    }

    @Override // androidx.media3.exoplayer.source.WrappingMediaSource
    protected MediaSource.MediaPeriodId y0(MediaSource.MediaPeriodId mediaPeriodId) {
        Pair pair = this.f45241z;
        return (pair == null || !Z0(mediaPeriodId, (MediaSource.MediaPeriodId) ((Pair) Assertions.e(pair)).second)) ? mediaPeriodId : (MediaSource.MediaPeriodId) ((Pair) Assertions.e(this.f45241z)).second;
    }

    private PreloadMediaSource(MediaSource mediaSource, PreloadControl preloadControl, TrackSelector trackSelector, BandwidthMeter bandwidthMeter, RendererCapabilities[] rendererCapabilitiesArr, Allocator allocator, Looper looper) {
        super(mediaSource);
        this.f45229n = preloadControl;
        this.f45230o = trackSelector;
        this.f45231p = bandwidthMeter;
        this.f45232q = rendererCapabilitiesArr;
        this.f45233r = allocator;
        this.f45234s = Util.B(looper, null);
        this.f45235t = Util.B(looper, null);
        this.f45238w = -9223372036854775807L;
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface PreloadControl {
        void b(PreloadMediaSource preloadMediaSource);

        boolean c(PreloadMediaSource preloadMediaSource, long j3);

        boolean d(PreloadMediaSource preloadMediaSource);

        boolean e(PreloadMediaSource preloadMediaSource);

        void f(PreloadException preloadException, PreloadMediaSource preloadMediaSource);

        default void a(PreloadMediaSource preloadMediaSource) {
        }
    }
}
