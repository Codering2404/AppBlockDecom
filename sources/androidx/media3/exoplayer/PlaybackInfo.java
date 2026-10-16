package androidx.media3.exoplayer;

import android.os.SystemClock;
import androidx.media3.common.PlaybackParameters;
import androidx.media3.common.Timeline;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.source.TrackGroupArray;
import androidx.media3.exoplayer.trackselection.TrackSelectorResult;
import com.google.common.collect.ImmutableList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class PlaybackInfo {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static final MediaSource.MediaPeriodId f43233u = new MediaSource.MediaPeriodId(new Object());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Timeline f43234a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MediaSource.MediaPeriodId f43235b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f43236c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f43237d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f43238e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ExoPlaybackException f43239f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f43240g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final TrackGroupArray f43241h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final TrackSelectorResult f43242i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final List f43243j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final MediaSource.MediaPeriodId f43244k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f43245l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f43246m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f43247n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final PlaybackParameters f43248o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final boolean f43249p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public volatile long f43250q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public volatile long f43251r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public volatile long f43252s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public volatile long f43253t;

    public PlaybackInfo(Timeline timeline, MediaSource.MediaPeriodId mediaPeriodId, long j3, long j4, int i3, ExoPlaybackException exoPlaybackException, boolean z2, TrackGroupArray trackGroupArray, TrackSelectorResult trackSelectorResult, List list, MediaSource.MediaPeriodId mediaPeriodId2, boolean z3, int i4, int i5, PlaybackParameters playbackParameters, long j5, long j6, long j7, long j8, boolean z4) {
        this.f43234a = timeline;
        this.f43235b = mediaPeriodId;
        this.f43236c = j3;
        this.f43237d = j4;
        this.f43238e = i3;
        this.f43239f = exoPlaybackException;
        this.f43240g = z2;
        this.f43241h = trackGroupArray;
        this.f43242i = trackSelectorResult;
        this.f43243j = list;
        this.f43244k = mediaPeriodId2;
        this.f43245l = z3;
        this.f43246m = i4;
        this.f43247n = i5;
        this.f43248o = playbackParameters;
        this.f43250q = j5;
        this.f43251r = j6;
        this.f43252s = j7;
        this.f43253t = j8;
        this.f43249p = z4;
    }

    public static PlaybackInfo k(TrackSelectorResult trackSelectorResult) {
        Timeline timeline = Timeline.f41105a;
        MediaSource.MediaPeriodId mediaPeriodId = f43233u;
        return new PlaybackInfo(timeline, mediaPeriodId, -9223372036854775807L, 0L, 1, null, false, TrackGroupArray.f44985d, trackSelectorResult, ImmutableList.y(), mediaPeriodId, false, 1, 0, PlaybackParameters.f40950d, 0L, 0L, 0L, 0L, false);
    }

    public static MediaSource.MediaPeriodId l() {
        return f43233u;
    }

    public PlaybackInfo a() {
        return new PlaybackInfo(this.f43234a, this.f43235b, this.f43236c, this.f43237d, this.f43238e, this.f43239f, this.f43240g, this.f43241h, this.f43242i, this.f43243j, this.f43244k, this.f43245l, this.f43246m, this.f43247n, this.f43248o, this.f43250q, this.f43251r, m(), SystemClock.elapsedRealtime(), this.f43249p);
    }

    public PlaybackInfo b(boolean z2) {
        return new PlaybackInfo(this.f43234a, this.f43235b, this.f43236c, this.f43237d, this.f43238e, this.f43239f, z2, this.f43241h, this.f43242i, this.f43243j, this.f43244k, this.f43245l, this.f43246m, this.f43247n, this.f43248o, this.f43250q, this.f43251r, this.f43252s, this.f43253t, this.f43249p);
    }

    public PlaybackInfo c(MediaSource.MediaPeriodId mediaPeriodId) {
        return new PlaybackInfo(this.f43234a, this.f43235b, this.f43236c, this.f43237d, this.f43238e, this.f43239f, this.f43240g, this.f43241h, this.f43242i, this.f43243j, mediaPeriodId, this.f43245l, this.f43246m, this.f43247n, this.f43248o, this.f43250q, this.f43251r, this.f43252s, this.f43253t, this.f43249p);
    }

    public PlaybackInfo d(MediaSource.MediaPeriodId mediaPeriodId, long j3, long j4, long j5, long j6, TrackGroupArray trackGroupArray, TrackSelectorResult trackSelectorResult, List list) {
        return new PlaybackInfo(this.f43234a, mediaPeriodId, j4, j5, this.f43238e, this.f43239f, this.f43240g, trackGroupArray, trackSelectorResult, list, this.f43244k, this.f43245l, this.f43246m, this.f43247n, this.f43248o, this.f43250q, j6, j3, SystemClock.elapsedRealtime(), this.f43249p);
    }

    public PlaybackInfo e(boolean z2, int i3, int i4) {
        return new PlaybackInfo(this.f43234a, this.f43235b, this.f43236c, this.f43237d, this.f43238e, this.f43239f, this.f43240g, this.f43241h, this.f43242i, this.f43243j, this.f43244k, z2, i3, i4, this.f43248o, this.f43250q, this.f43251r, this.f43252s, this.f43253t, this.f43249p);
    }

    public PlaybackInfo f(ExoPlaybackException exoPlaybackException) {
        return new PlaybackInfo(this.f43234a, this.f43235b, this.f43236c, this.f43237d, this.f43238e, exoPlaybackException, this.f43240g, this.f43241h, this.f43242i, this.f43243j, this.f43244k, this.f43245l, this.f43246m, this.f43247n, this.f43248o, this.f43250q, this.f43251r, this.f43252s, this.f43253t, this.f43249p);
    }

    public PlaybackInfo g(PlaybackParameters playbackParameters) {
        return new PlaybackInfo(this.f43234a, this.f43235b, this.f43236c, this.f43237d, this.f43238e, this.f43239f, this.f43240g, this.f43241h, this.f43242i, this.f43243j, this.f43244k, this.f43245l, this.f43246m, this.f43247n, playbackParameters, this.f43250q, this.f43251r, this.f43252s, this.f43253t, this.f43249p);
    }

    public PlaybackInfo h(int i3) {
        return new PlaybackInfo(this.f43234a, this.f43235b, this.f43236c, this.f43237d, i3, this.f43239f, this.f43240g, this.f43241h, this.f43242i, this.f43243j, this.f43244k, this.f43245l, this.f43246m, this.f43247n, this.f43248o, this.f43250q, this.f43251r, this.f43252s, this.f43253t, this.f43249p);
    }

    public PlaybackInfo i(boolean z2) {
        return new PlaybackInfo(this.f43234a, this.f43235b, this.f43236c, this.f43237d, this.f43238e, this.f43239f, this.f43240g, this.f43241h, this.f43242i, this.f43243j, this.f43244k, this.f43245l, this.f43246m, this.f43247n, this.f43248o, this.f43250q, this.f43251r, this.f43252s, this.f43253t, z2);
    }

    public PlaybackInfo j(Timeline timeline) {
        return new PlaybackInfo(timeline, this.f43235b, this.f43236c, this.f43237d, this.f43238e, this.f43239f, this.f43240g, this.f43241h, this.f43242i, this.f43243j, this.f43244k, this.f43245l, this.f43246m, this.f43247n, this.f43248o, this.f43250q, this.f43251r, this.f43252s, this.f43253t, this.f43249p);
    }

    public long m() {
        long j3;
        long j4;
        if (!n()) {
            return this.f43252s;
        }
        do {
            j3 = this.f43253t;
            j4 = this.f43252s;
        } while (j3 != this.f43253t);
        return Util.P0(Util.t1(j4) + ((long) ((SystemClock.elapsedRealtime() - j3) * this.f43248o.f40953a)));
    }

    public boolean n() {
        return this.f43238e == 3 && this.f43245l && this.f43247n == 0;
    }

    public void o(long j3) {
        this.f43252s = j3;
        this.f43253t = SystemClock.elapsedRealtime();
    }
}
