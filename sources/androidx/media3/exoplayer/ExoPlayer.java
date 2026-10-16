package androidx.media3.exoplayer;

import android.content.Context;
import android.os.Looper;
import androidx.media3.common.AudioAttributes;
import androidx.media3.common.Format;
import androidx.media3.common.Player;
import androidx.media3.common.PriorityTaskManager;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Clock;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.DefaultLivePlaybackSpeedControl;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.exoplayer.analytics.DefaultAnalyticsCollector;
import androidx.media3.exoplayer.source.DefaultMediaSourceFactory;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.trackselection.DefaultTrackSelector;
import androidx.media3.exoplayer.trackselection.TrackSelector;
import androidx.media3.exoplayer.upstream.DefaultBandwidthMeter;
import androidx.media3.extractor.DefaultExtractorsFactory;
import com.google.common.base.Function;
import com.google.common.base.Supplier;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public interface ExoPlayer extends Player {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class PreloadConfiguration {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final PreloadConfiguration f42989b = new PreloadConfiguration(-9223372036854775807L);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f42990a;

        public PreloadConfiguration(long j3) {
            this.f42990a = j3;
        }
    }

    boolean F();

    DecoderCounters W();

    Format Y();

    @Override // androidx.media3.common.Player
    ExoPlaybackException b();

    Format c();

    DecoderCounters k0();

    void release();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Builder {
        long A;
        long B;
        boolean C;
        boolean D;
        PlaybackLooperProvider E;
        boolean F;
        boolean G;
        String H;
        boolean I;
        SuitableOutputChecker J;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Context f42963a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Clock f42964b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        long f42965c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Supplier f42966d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Supplier f42967e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        Supplier f42968f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        Supplier f42969g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        Supplier f42970h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        Function f42971i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        Looper f42972j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        int f42973k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        PriorityTaskManager f42974l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        AudioAttributes f42975m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        boolean f42976n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        int f42977o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        boolean f42978p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        boolean f42979q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        boolean f42980r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        int f42981s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        int f42982t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        boolean f42983u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        SeekParameters f42984v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        long f42985w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        long f42986x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        long f42987y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        LivePlaybackSpeedControl f42988z;

        public Builder(final Context context, final RenderersFactory renderersFactory) {
            this(context, new Supplier() { // from class: androidx.media3.exoplayer.i0
                @Override // com.google.common.base.Supplier
                public final Object get() {
                    return ExoPlayer.Builder.f(renderersFactory);
                }
            }, new Supplier() { // from class: androidx.media3.exoplayer.j0
                @Override // com.google.common.base.Supplier
                public final Object get() {
                    return ExoPlayer.Builder.a(context);
                }
            });
            Assertions.e(renderersFactory);
        }

        public static /* synthetic */ MediaSource.Factory a(Context context) {
            return new DefaultMediaSourceFactory(context, new DefaultExtractorsFactory());
        }

        public static /* synthetic */ TrackSelector g(Context context) {
            return new DefaultTrackSelector(context);
        }

        public ExoPlayer h() {
            Assertions.g(!this.F);
            this.F = true;
            return new ExoPlayerImpl(this, null);
        }

        public Builder i(boolean z2) {
            Assertions.g(!this.F);
            this.I = z2;
            return this;
        }

        public Builder j(Clock clock) {
            Assertions.g(!this.F);
            this.f42964b = clock;
            return this;
        }

        public Builder k(final LoadControl loadControl) {
            Assertions.g(!this.F);
            Assertions.e(loadControl);
            this.f42969g = new Supplier() { // from class: androidx.media3.exoplayer.f0
                @Override // com.google.common.base.Supplier
                public final Object get() {
                    return ExoPlayer.Builder.b(loadControl);
                }
            };
            return this;
        }

        public Builder l(Looper looper) {
            Assertions.g(!this.F);
            Assertions.e(looper);
            this.f42972j = looper;
            return this;
        }

        public Builder m(final MediaSource.Factory factory) {
            Assertions.g(!this.F);
            Assertions.e(factory);
            this.f42967e = new Supplier() { // from class: androidx.media3.exoplayer.h0
                @Override // com.google.common.base.Supplier
                public final Object get() {
                    return ExoPlayer.Builder.c(factory);
                }
            };
            return this;
        }

        public Builder n(final TrackSelector trackSelector) {
            Assertions.g(!this.F);
            Assertions.e(trackSelector);
            this.f42968f = new Supplier() { // from class: androidx.media3.exoplayer.g0
                @Override // com.google.common.base.Supplier
                public final Object get() {
                    return ExoPlayer.Builder.e(trackSelector);
                }
            };
            return this;
        }

        public Builder o(boolean z2) {
            Assertions.g(!this.F);
            this.D = z2;
            return this;
        }

        private Builder(final Context context, Supplier supplier, Supplier supplier2) {
            this(context, supplier, supplier2, new Supplier() { // from class: androidx.media3.exoplayer.k0
                @Override // com.google.common.base.Supplier
                public final Object get() {
                    return ExoPlayer.Builder.g(context);
                }
            }, new Supplier() { // from class: androidx.media3.exoplayer.l0
                @Override // com.google.common.base.Supplier
                public final Object get() {
                    return new DefaultLoadControl();
                }
            }, new Supplier() { // from class: androidx.media3.exoplayer.m0
                @Override // com.google.common.base.Supplier
                public final Object get() {
                    return DefaultBandwidthMeter.l(context);
                }
            }, new Function() { // from class: androidx.media3.exoplayer.n0
                @Override // com.google.common.base.Function
                public final Object apply(Object obj) {
                    return new DefaultAnalyticsCollector((Clock) obj);
                }
            });
        }

        private Builder(Context context, Supplier supplier, Supplier supplier2, Supplier supplier3, Supplier supplier4, Supplier supplier5, Function function) {
            this.f42963a = (Context) Assertions.e(context);
            this.f42966d = supplier;
            this.f42967e = supplier2;
            this.f42968f = supplier3;
            this.f42969g = supplier4;
            this.f42970h = supplier5;
            this.f42971i = function;
            this.f42972j = Util.Y();
            this.f42975m = AudioAttributes.f40518g;
            this.f42977o = 0;
            this.f42981s = 1;
            this.f42982t = 0;
            this.f42983u = true;
            this.f42984v = SeekParameters.f43300g;
            this.f42985w = 5000L;
            this.f42986x = 15000L;
            this.f42987y = 3000L;
            this.f42988z = new DefaultLivePlaybackSpeedControl.Builder().a();
            this.f42964b = Clock.f41485a;
            this.A = 500L;
            this.B = 2000L;
            this.D = true;
            this.H = "";
            this.f42973k = -1000;
            this.J = new DefaultSuitableOutputChecker();
        }

        public static /* synthetic */ LoadControl b(LoadControl loadControl) {
            return loadControl;
        }

        public static /* synthetic */ MediaSource.Factory c(MediaSource.Factory factory) {
            return factory;
        }

        public static /* synthetic */ TrackSelector e(TrackSelector trackSelector) {
            return trackSelector;
        }

        public static /* synthetic */ RenderersFactory f(RenderersFactory renderersFactory) {
            return renderersFactory;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface AudioOffloadListener {
        default void C(boolean z2) {
        }

        default void F(boolean z2) {
        }
    }
}
