package androidx.media3.exoplayer;

import androidx.media3.common.Timeline;
import androidx.media3.common.util.Log;
import androidx.media3.exoplayer.analytics.PlayerId;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.source.TrackGroupArray;
import androidx.media3.exoplayer.trackselection.ExoTrackSelection;
import androidx.media3.exoplayer.upstream.Allocator;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public interface LoadControl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final MediaSource.MediaPeriodId f43110a = new MediaSource.MediaPeriodId(new Object());

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Parameters {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final PlayerId f43111a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Timeline f43112b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final MediaSource.MediaPeriodId f43113c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final long f43114d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final long f43115e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final float f43116f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final boolean f43117g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final boolean f43118h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final long f43119i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final long f43120j;

        public Parameters(PlayerId playerId, Timeline timeline, MediaSource.MediaPeriodId mediaPeriodId, long j3, long j4, float f3, boolean z2, boolean z3, long j5, long j6) {
            this.f43111a = playerId;
            this.f43112b = timeline;
            this.f43113c = mediaPeriodId;
            this.f43114d = j3;
            this.f43115e = j4;
            this.f43116f = f3;
            this.f43117g = z2;
            this.f43118h = z3;
            this.f43119i = j5;
            this.f43120j = j6;
        }
    }

    default boolean a(Parameters parameters) {
        return m(parameters.f43112b, parameters.f43113c, parameters.f43115e, parameters.f43116f, parameters.f43118h, parameters.f43119i);
    }

    default boolean b() {
        throw new IllegalStateException("retainBackBufferFromKeyframe not implemented");
    }

    default long c() {
        throw new IllegalStateException("getBackBufferDurationUs not implemented");
    }

    default void d(PlayerId playerId) {
        onPrepared();
    }

    default boolean e(long j3, float f3, boolean z2, long j4) {
        throw new IllegalStateException("shouldStartPlayback not implemented");
    }

    default boolean f(Timeline timeline, MediaSource.MediaPeriodId mediaPeriodId, long j3) {
        Log.i("LoadControl", "shouldContinuePreloading needs to be implemented when playlist preloading is enabled");
        return false;
    }

    default void g(Parameters parameters, TrackGroupArray trackGroupArray, ExoTrackSelection[] exoTrackSelectionArr) {
        throw new IllegalStateException("onTracksSelected not implemented");
    }

    Allocator h();

    default void i() {
        throw new IllegalStateException("onStopped not implemented");
    }

    default void j(PlayerId playerId) {
        n();
    }

    default boolean k(Parameters parameters) {
        return p(parameters.f43114d, parameters.f43115e, parameters.f43116f);
    }

    default void l(PlayerId playerId) {
        i();
    }

    default boolean m(Timeline timeline, MediaSource.MediaPeriodId mediaPeriodId, long j3, float f3, boolean z2, long j4) {
        return e(j3, f3, z2, j4);
    }

    default void n() {
        throw new IllegalStateException("onReleased not implemented");
    }

    default boolean o(PlayerId playerId) {
        return b();
    }

    default void onPrepared() {
        throw new IllegalStateException("onPrepared not implemented");
    }

    default boolean p(long j3, long j4, float f3) {
        throw new IllegalStateException("shouldContinueLoading not implemented");
    }

    default long q(PlayerId playerId) {
        return c();
    }
}
