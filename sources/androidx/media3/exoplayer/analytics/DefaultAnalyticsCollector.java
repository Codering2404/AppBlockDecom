package androidx.media3.exoplayer.analytics;

import android.os.Looper;
import android.util.SparseArray;
import androidx.media3.common.AudioAttributes;
import androidx.media3.common.DeviceInfo;
import androidx.media3.common.FlagSet;
import androidx.media3.common.Format;
import androidx.media3.common.MediaItem;
import androidx.media3.common.MediaMetadata;
import androidx.media3.common.Metadata;
import androidx.media3.common.PlaybackException;
import androidx.media3.common.PlaybackParameters;
import androidx.media3.common.Player;
import androidx.media3.common.Timeline;
import androidx.media3.common.TrackSelectionParameters;
import androidx.media3.common.Tracks;
import androidx.media3.common.VideoSize;
import androidx.media3.common.text.CueGroup;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Clock;
import androidx.media3.common.util.HandlerWrapper;
import androidx.media3.common.util.ListenerSet;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.DecoderCounters;
import androidx.media3.exoplayer.DecoderReuseEvaluation;
import androidx.media3.exoplayer.ExoPlaybackException;
import androidx.media3.exoplayer.analytics.AnalyticsListener;
import androidx.media3.exoplayer.audio.AudioSink;
import androidx.media3.exoplayer.source.LoadEventInfo;
import androidx.media3.exoplayer.source.MediaLoadData;
import androidx.media3.exoplayer.source.MediaSource;
import com.facebook.ads.AdError;
import com.facebook.stetho.websocket.CloseCodes;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Iterables;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class DefaultAnalyticsCollector implements AnalyticsCollector {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Clock f43351a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Timeline.Period f43352b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Timeline.Window f43353c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final MediaPeriodQueueTracker f43354d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final SparseArray f43355f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private ListenerSet f43356g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Player f43357h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private HandlerWrapper f43358i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f43359j;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class MediaPeriodQueueTracker {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Timeline.Period f43360a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private ImmutableList f43361b = ImmutableList.y();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private ImmutableMap f43362c = ImmutableMap.n();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private MediaSource.MediaPeriodId f43363d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private MediaSource.MediaPeriodId f43364e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private MediaSource.MediaPeriodId f43365f;

        public MediaPeriodQueueTracker(Timeline.Period period) {
            this.f43360a = period;
        }

        private void b(ImmutableMap.Builder builder, MediaSource.MediaPeriodId mediaPeriodId, Timeline timeline) {
            if (mediaPeriodId == null) {
                return;
            }
            if (timeline.b(mediaPeriodId.f44754a) != -1) {
                builder.g(mediaPeriodId, timeline);
                return;
            }
            Timeline timeline2 = (Timeline) this.f43362c.get(mediaPeriodId);
            if (timeline2 != null) {
                builder.g(mediaPeriodId, timeline2);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        private static MediaSource.MediaPeriodId c(Player player, ImmutableList immutableList, MediaSource.MediaPeriodId mediaPeriodId, Timeline.Period period) {
            Timeline timelineE = player.E();
            int iN = player.N();
            Object objM = timelineE.q() ? null : timelineE.m(iN);
            int iD = (player.f() || timelineE.q()) ? -1 : timelineE.f(iN, period).d(Util.P0(player.getCurrentPosition()) - period.o());
            for (int i3 = 0; i3 < immutableList.size(); i3++) {
                MediaSource.MediaPeriodId mediaPeriodId2 = (MediaSource.MediaPeriodId) immutableList.get(i3);
                if (i(mediaPeriodId2, objM, player.f(), player.x(), player.T(), iD)) {
                    return mediaPeriodId2;
                }
            }
            if (immutableList.isEmpty() && mediaPeriodId != null && i(mediaPeriodId, objM, player.f(), player.x(), player.T(), iD)) {
                return mediaPeriodId;
            }
            return null;
        }

        private static boolean i(MediaSource.MediaPeriodId mediaPeriodId, Object obj, boolean z2, int i3, int i4, int i5) {
            if (!mediaPeriodId.f44754a.equals(obj)) {
                return false;
            }
            if (z2 && mediaPeriodId.f44755b == i3 && mediaPeriodId.f44756c == i4) {
                return true;
            }
            return !z2 && mediaPeriodId.f44755b == -1 && mediaPeriodId.f44758e == i5;
        }

        /* JADX WARN: Multi-variable type inference failed */
        private void m(Timeline timeline) {
            ImmutableMap.Builder builderA = ImmutableMap.a();
            if (this.f43361b.isEmpty()) {
                b(builderA, this.f43364e, timeline);
                if (!Objects.equals(this.f43365f, this.f43364e)) {
                    b(builderA, this.f43365f, timeline);
                }
                if (!Objects.equals(this.f43363d, this.f43364e) && !Objects.equals(this.f43363d, this.f43365f)) {
                    b(builderA, this.f43363d, timeline);
                }
            } else {
                for (int i3 = 0; i3 < this.f43361b.size(); i3++) {
                    b(builderA, (MediaSource.MediaPeriodId) this.f43361b.get(i3), timeline);
                }
                if (!this.f43361b.contains(this.f43363d)) {
                    b(builderA, this.f43363d, timeline);
                }
            }
            this.f43362c = builderA.d();
        }

        public MediaSource.MediaPeriodId d() {
            return this.f43363d;
        }

        public MediaSource.MediaPeriodId e() {
            if (this.f43361b.isEmpty()) {
                return null;
            }
            return (MediaSource.MediaPeriodId) Iterables.j(this.f43361b);
        }

        public Timeline f(MediaSource.MediaPeriodId mediaPeriodId) {
            return (Timeline) this.f43362c.get(mediaPeriodId);
        }

        public MediaSource.MediaPeriodId g() {
            return this.f43364e;
        }

        public MediaSource.MediaPeriodId h() {
            return this.f43365f;
        }

        public void j(Player player) {
            this.f43363d = c(player, this.f43361b, this.f43364e, this.f43360a);
        }

        public void k(List list, MediaSource.MediaPeriodId mediaPeriodId, Player player) {
            this.f43361b = ImmutableList.t(list);
            if (!list.isEmpty()) {
                this.f43364e = (MediaSource.MediaPeriodId) list.get(0);
                this.f43365f = (MediaSource.MediaPeriodId) Assertions.e(mediaPeriodId);
            }
            if (this.f43363d == null) {
                this.f43363d = c(player, this.f43361b, this.f43364e, this.f43360a);
            }
            m(player.E());
        }

        public void l(Player player) {
            this.f43363d = c(player, this.f43361b, this.f43364e, this.f43360a);
            m(player.E());
        }
    }

    public DefaultAnalyticsCollector(Clock clock) {
        this.f43351a = (Clock) Assertions.e(clock);
        this.f43356g = new ListenerSet(Util.Y(), clock, new ListenerSet.IterationFinishedEvent() { // from class: androidx.media3.exoplayer.analytics.p1
            @Override // androidx.media3.common.util.ListenerSet.IterationFinishedEvent
            public final void a(Object obj, FlagSet flagSet) {
                DefaultAnalyticsCollector.M1((AnalyticsListener) obj, flagSet);
            }
        });
        Timeline.Period period = new Timeline.Period();
        this.f43352b = period;
        this.f43353c = new Timeline.Window();
        this.f43354d = new MediaPeriodQueueTracker(period);
        this.f43355f = new SparseArray();
    }

    public static /* synthetic */ void A0(AnalyticsListener.EventTime eventTime, int i3, AnalyticsListener analyticsListener) {
        analyticsListener.e0(eventTime);
        analyticsListener.E(eventTime, i3);
    }

    public static /* synthetic */ void C0(AnalyticsListener.EventTime eventTime, String str, long j3, long j4, AnalyticsListener analyticsListener) {
        analyticsListener.R(eventTime, str, j3);
        analyticsListener.r(eventTime, str, j4, j3);
    }

    public static /* synthetic */ void L0(AnalyticsListener.EventTime eventTime, VideoSize videoSize, AnalyticsListener analyticsListener) {
        analyticsListener.r0(eventTime, videoSize);
        analyticsListener.a0(eventTime, videoSize.f41258a, videoSize.f41259b, 0, videoSize.f41261d);
    }

    public static /* synthetic */ void M0(AnalyticsListener.EventTime eventTime, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, int i3, AnalyticsListener analyticsListener) {
        analyticsListener.f0(eventTime, loadEventInfo, mediaLoadData);
        analyticsListener.D(eventTime, loadEventInfo, mediaLoadData, i3);
    }

    private AnalyticsListener.EventTime T1(MediaSource.MediaPeriodId mediaPeriodId) {
        Assertions.e(this.f43357h);
        Timeline timelineF = mediaPeriodId == null ? null : this.f43354d.f(mediaPeriodId);
        if (mediaPeriodId != null && timelineF != null) {
            return S1(timelineF, timelineF.h(mediaPeriodId.f44754a, this.f43352b).f41116c, mediaPeriodId);
        }
        int iF0 = this.f43357h.f0();
        Timeline timelineE = this.f43357h.E();
        if (iF0 >= timelineE.p()) {
            timelineE = Timeline.f41105a;
        }
        return S1(timelineE, iF0, null);
    }

    private AnalyticsListener.EventTime U1() {
        return T1(this.f43354d.e());
    }

    private AnalyticsListener.EventTime V1(int i3, MediaSource.MediaPeriodId mediaPeriodId) {
        Assertions.e(this.f43357h);
        if (mediaPeriodId != null) {
            return this.f43354d.f(mediaPeriodId) != null ? T1(mediaPeriodId) : S1(Timeline.f41105a, i3, mediaPeriodId);
        }
        Timeline timelineE = this.f43357h.E();
        if (i3 >= timelineE.p()) {
            timelineE = Timeline.f41105a;
        }
        return S1(timelineE, i3, null);
    }

    public static /* synthetic */ void W0(AnalyticsListener.EventTime eventTime, String str, long j3, long j4, AnalyticsListener analyticsListener) {
        analyticsListener.i0(eventTime, str, j3);
        analyticsListener.q0(eventTime, str, j4, j3);
    }

    private AnalyticsListener.EventTime W1() {
        return T1(this.f43354d.g());
    }

    private AnalyticsListener.EventTime X1() {
        return T1(this.f43354d.h());
    }

    private AnalyticsListener.EventTime Y1(PlaybackException playbackException) {
        MediaSource.MediaPeriodId mediaPeriodId;
        return (!(playbackException instanceof ExoPlaybackException) || (mediaPeriodId = ((ExoPlaybackException) playbackException).f42961p) == null) ? R1() : T1(mediaPeriodId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z1() {
        final AnalyticsListener.EventTime eventTimeR1 = R1();
        a2(eventTimeR1, 1028, new ListenerSet.Event() { // from class: androidx.media3.exoplayer.analytics.j1
            @Override // androidx.media3.common.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).A(eventTimeR1);
            }
        });
        this.f43356g.i();
    }

    public static /* synthetic */ void d1(AnalyticsListener.EventTime eventTime, boolean z2, AnalyticsListener analyticsListener) {
        analyticsListener.b0(eventTime, z2);
        analyticsListener.b(eventTime, z2);
    }

    public static /* synthetic */ void m1(AnalyticsListener.EventTime eventTime, int i3, Player.PositionInfo positionInfo, Player.PositionInfo positionInfo2, AnalyticsListener analyticsListener) {
        analyticsListener.k(eventTime, i3);
        analyticsListener.C(eventTime, positionInfo, positionInfo2, i3);
    }

    @Override // androidx.media3.exoplayer.analytics.AnalyticsCollector
    public final void A(final long j3, final int i3) {
        final AnalyticsListener.EventTime eventTimeW1 = W1();
        a2(eventTimeW1, 1021, new ListenerSet.Event() { // from class: androidx.media3.exoplayer.analytics.e
            @Override // androidx.media3.common.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).t0(eventTimeW1, j3, i3);
            }
        });
    }

    @Override // androidx.media3.common.Player.Listener
    public final void B(final int i3) {
        final AnalyticsListener.EventTime eventTimeR1 = R1();
        a2(eventTimeR1, 6, new ListenerSet.Event() { // from class: androidx.media3.exoplayer.analytics.o0
            @Override // androidx.media3.common.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).X(eventTimeR1, i3);
            }
        });
    }

    @Override // androidx.media3.exoplayer.analytics.AnalyticsCollector
    public final void D(List list, MediaSource.MediaPeriodId mediaPeriodId) {
        this.f43354d.k(list, mediaPeriodId, (Player) Assertions.e(this.f43357h));
    }

    @Override // androidx.media3.exoplayer.source.MediaSourceEventListener
    public final void E(int i3, MediaSource.MediaPeriodId mediaPeriodId, final MediaLoadData mediaLoadData) {
        final AnalyticsListener.EventTime eventTimeV1 = V1(i3, mediaPeriodId);
        a2(eventTimeV1, 1005, new ListenerSet.Event() { // from class: androidx.media3.exoplayer.analytics.p
            @Override // androidx.media3.common.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).Y(eventTimeV1, mediaLoadData);
            }
        });
    }

    @Override // androidx.media3.common.Player.Listener
    public final void F(final int i3) {
        final AnalyticsListener.EventTime eventTimeX1 = X1();
        a2(eventTimeX1, 21, new ListenerSet.Event() { // from class: androidx.media3.exoplayer.analytics.q1
            @Override // androidx.media3.common.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).P(eventTimeX1, i3);
            }
        });
    }

    @Override // androidx.media3.common.Player.Listener
    public final void G(final int i3) {
        final AnalyticsListener.EventTime eventTimeR1 = R1();
        a2(eventTimeR1, 4, new ListenerSet.Event() { // from class: androidx.media3.exoplayer.analytics.v0
            @Override // androidx.media3.common.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).L(eventTimeR1, i3);
            }
        });
    }

    @Override // androidx.media3.exoplayer.upstream.BandwidthMeter.EventListener
    public final void H(final int i3, final long j3, final long j4) {
        final AnalyticsListener.EventTime eventTimeU1 = U1();
        a2(eventTimeU1, CloseCodes.CLOSED_ABNORMALLY, new ListenerSet.Event() { // from class: androidx.media3.exoplayer.analytics.a
            @Override // androidx.media3.common.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).o(eventTimeU1, i3, j3, j4);
            }
        });
    }

    @Override // androidx.media3.exoplayer.analytics.AnalyticsCollector
    public final void I() {
        if (this.f43359j) {
            return;
        }
        final AnalyticsListener.EventTime eventTimeR1 = R1();
        this.f43359j = true;
        a2(eventTimeR1, -1, new ListenerSet.Event() { // from class: androidx.media3.exoplayer.analytics.m
            @Override // androidx.media3.common.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).j0(eventTimeR1);
            }
        });
    }

    @Override // androidx.media3.common.Player.Listener
    public final void J(final boolean z2) {
        final AnalyticsListener.EventTime eventTimeR1 = R1();
        a2(eventTimeR1, 9, new ListenerSet.Event() { // from class: androidx.media3.exoplayer.analytics.h1
            @Override // androidx.media3.common.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).K(eventTimeR1, z2);
            }
        });
    }

    @Override // androidx.media3.common.Player.Listener
    public void K(final int i3, final boolean z2) {
        final AnalyticsListener.EventTime eventTimeR1 = R1();
        a2(eventTimeR1, 30, new ListenerSet.Event() { // from class: androidx.media3.exoplayer.analytics.q0
            @Override // androidx.media3.common.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).d(eventTimeR1, i3, z2);
            }
        });
    }

    @Override // androidx.media3.common.Player.Listener
    public void L(final long j3) {
        final AnalyticsListener.EventTime eventTimeR1 = R1();
        a2(eventTimeR1, 16, new ListenerSet.Event() { // from class: androidx.media3.exoplayer.analytics.z
            @Override // androidx.media3.common.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).j(eventTimeR1, j3);
            }
        });
    }

    @Override // androidx.media3.common.Player.Listener
    public void M(final MediaMetadata mediaMetadata) {
        final AnalyticsListener.EventTime eventTimeR1 = R1();
        a2(eventTimeR1, 14, new ListenerSet.Event() { // from class: androidx.media3.exoplayer.analytics.y
            @Override // androidx.media3.common.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).t(eventTimeR1, mediaMetadata);
            }
        });
    }

    @Override // androidx.media3.exoplayer.drm.DrmSessionEventListener
    public final void N(int i3, MediaSource.MediaPeriodId mediaPeriodId) {
        final AnalyticsListener.EventTime eventTimeV1 = V1(i3, mediaPeriodId);
        a2(eventTimeV1, 1023, new ListenerSet.Event() { // from class: androidx.media3.exoplayer.analytics.g1
            @Override // androidx.media3.common.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).z0(eventTimeV1);
            }
        });
    }

    @Override // androidx.media3.common.Player.Listener
    public void O(final TrackSelectionParameters trackSelectionParameters) {
        final AnalyticsListener.EventTime eventTimeR1 = R1();
        a2(eventTimeR1, 19, new ListenerSet.Event() { // from class: androidx.media3.exoplayer.analytics.b0
            @Override // androidx.media3.common.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).s(eventTimeR1, trackSelectionParameters);
            }
        });
    }

    @Override // androidx.media3.common.Player.Listener
    public final void Q(final MediaItem mediaItem, final int i3) {
        final AnalyticsListener.EventTime eventTimeR1 = R1();
        a2(eventTimeR1, 1, new ListenerSet.Event() { // from class: androidx.media3.exoplayer.analytics.g0
            @Override // androidx.media3.common.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).y(eventTimeR1, mediaItem, i3);
            }
        });
    }

    @Override // androidx.media3.exoplayer.source.MediaSourceEventListener
    public final void R(int i3, MediaSource.MediaPeriodId mediaPeriodId, final LoadEventInfo loadEventInfo, final MediaLoadData mediaLoadData, final int i4) {
        final AnalyticsListener.EventTime eventTimeV1 = V1(i3, mediaPeriodId);
        a2(eventTimeV1, 1000, new ListenerSet.Event() { // from class: androidx.media3.exoplayer.analytics.h0
            @Override // androidx.media3.common.util.ListenerSet.Event
            public final void invoke(Object obj) {
                DefaultAnalyticsCollector.M0(eventTimeV1, loadEventInfo, mediaLoadData, i4, (AnalyticsListener) obj);
            }
        });
    }

    protected final AnalyticsListener.EventTime R1() {
        return T1(this.f43354d.d());
    }

    @Override // androidx.media3.exoplayer.drm.DrmSessionEventListener
    public final void S(int i3, MediaSource.MediaPeriodId mediaPeriodId, final int i4) {
        final AnalyticsListener.EventTime eventTimeV1 = V1(i3, mediaPeriodId);
        a2(eventTimeV1, 1022, new ListenerSet.Event() { // from class: androidx.media3.exoplayer.analytics.h
            @Override // androidx.media3.common.util.ListenerSet.Event
            public final void invoke(Object obj) {
                DefaultAnalyticsCollector.A0(eventTimeV1, i4, (AnalyticsListener) obj);
            }
        });
    }

    protected final AnalyticsListener.EventTime S1(Timeline timeline, int i3, MediaSource.MediaPeriodId mediaPeriodId) {
        MediaSource.MediaPeriodId mediaPeriodId2 = timeline.q() ? null : mediaPeriodId;
        long jA = this.f43351a.a();
        boolean z2 = timeline.equals(this.f43357h.E()) && i3 == this.f43357h.f0();
        long jB = 0;
        if (mediaPeriodId2 == null || !mediaPeriodId2.c()) {
            if (z2) {
                jB = this.f43357h.X();
            } else if (!timeline.q()) {
                jB = timeline.n(i3, this.f43353c).b();
            }
        } else if (z2 && this.f43357h.x() == mediaPeriodId2.f44755b && this.f43357h.T() == mediaPeriodId2.f44756c) {
            jB = this.f43357h.getCurrentPosition();
        }
        return new AnalyticsListener.EventTime(jA, timeline, i3, mediaPeriodId2, jB, this.f43357h.E(), this.f43357h.f0(), this.f43354d.d(), this.f43357h.getCurrentPosition(), this.f43357h.g());
    }

    @Override // androidx.media3.common.Player.Listener
    public final void T(final PlaybackException playbackException) {
        final AnalyticsListener.EventTime eventTimeY1 = Y1(playbackException);
        a2(eventTimeY1, 10, new ListenerSet.Event() { // from class: androidx.media3.exoplayer.analytics.u0
            @Override // androidx.media3.common.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).i(eventTimeY1, playbackException);
            }
        });
    }

    @Override // androidx.media3.exoplayer.source.MediaSourceEventListener
    public final void U(int i3, MediaSource.MediaPeriodId mediaPeriodId, final LoadEventInfo loadEventInfo, final MediaLoadData mediaLoadData, final IOException iOException, final boolean z2) {
        final AnalyticsListener.EventTime eventTimeV1 = V1(i3, mediaPeriodId);
        a2(eventTimeV1, 1003, new ListenerSet.Event() { // from class: androidx.media3.exoplayer.analytics.r1
            @Override // androidx.media3.common.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).M(eventTimeV1, loadEventInfo, mediaLoadData, iOException, z2);
            }
        });
    }

    @Override // androidx.media3.common.Player.Listener
    public final void V(final int i3, final int i4) {
        final AnalyticsListener.EventTime eventTimeX1 = X1();
        a2(eventTimeX1, 24, new ListenerSet.Event() { // from class: androidx.media3.exoplayer.analytics.i1
            @Override // androidx.media3.common.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).B(eventTimeX1, i3, i4);
            }
        });
    }

    @Override // androidx.media3.common.Player.Listener
    public void W(final Player.Commands commands) {
        final AnalyticsListener.EventTime eventTimeR1 = R1();
        a2(eventTimeR1, 13, new ListenerSet.Event() { // from class: androidx.media3.exoplayer.analytics.e0
            @Override // androidx.media3.common.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).F(eventTimeR1, commands);
            }
        });
    }

    @Override // androidx.media3.exoplayer.drm.DrmSessionEventListener
    public final void X(int i3, MediaSource.MediaPeriodId mediaPeriodId) {
        final AnalyticsListener.EventTime eventTimeV1 = V1(i3, mediaPeriodId);
        a2(eventTimeV1, 1026, new ListenerSet.Event() { // from class: androidx.media3.exoplayer.analytics.x0
            @Override // androidx.media3.common.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).Z(eventTimeV1);
            }
        });
    }

    @Override // androidx.media3.exoplayer.drm.DrmSessionEventListener
    public final void Y(int i3, MediaSource.MediaPeriodId mediaPeriodId, final Exception exc) {
        final AnalyticsListener.EventTime eventTimeV1 = V1(i3, mediaPeriodId);
        a2(eventTimeV1, 1024, new ListenerSet.Event() { // from class: androidx.media3.exoplayer.analytics.i
            @Override // androidx.media3.common.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).w(eventTimeV1, exc);
            }
        });
    }

    @Override // androidx.media3.exoplayer.source.MediaSourceEventListener
    public final void Z(int i3, MediaSource.MediaPeriodId mediaPeriodId, final LoadEventInfo loadEventInfo, final MediaLoadData mediaLoadData) {
        final AnalyticsListener.EventTime eventTimeV1 = V1(i3, mediaPeriodId);
        a2(eventTimeV1, 1002, new ListenerSet.Event() { // from class: androidx.media3.exoplayer.analytics.f
            @Override // androidx.media3.common.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).A0(eventTimeV1, loadEventInfo, mediaLoadData);
            }
        });
    }

    @Override // androidx.media3.exoplayer.analytics.AnalyticsCollector
    public void a(final AudioSink.AudioTrackConfig audioTrackConfig) {
        final AnalyticsListener.EventTime eventTimeX1 = X1();
        a2(eventTimeX1, 1031, new ListenerSet.Event() { // from class: androidx.media3.exoplayer.analytics.m1
            @Override // androidx.media3.common.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).S(eventTimeX1, audioTrackConfig);
            }
        });
    }

    protected final void a2(AnalyticsListener.EventTime eventTime, int i3, ListenerSet.Event event) {
        this.f43355f.put(i3, eventTime);
        this.f43356g.j(i3, event);
    }

    @Override // androidx.media3.common.Player.Listener
    public final void b(final VideoSize videoSize) {
        final AnalyticsListener.EventTime eventTimeX1 = X1();
        a2(eventTimeX1, 25, new ListenerSet.Event() { // from class: androidx.media3.exoplayer.analytics.a1
            @Override // androidx.media3.common.util.ListenerSet.Event
            public final void invoke(Object obj) {
                DefaultAnalyticsCollector.L0(eventTimeX1, videoSize, (AnalyticsListener) obj);
            }
        });
    }

    @Override // androidx.media3.common.Player.Listener
    public final void b0(final boolean z2) {
        final AnalyticsListener.EventTime eventTimeR1 = R1();
        a2(eventTimeR1, 3, new ListenerSet.Event() { // from class: androidx.media3.exoplayer.analytics.d0
            @Override // androidx.media3.common.util.ListenerSet.Event
            public final void invoke(Object obj) {
                DefaultAnalyticsCollector.d1(eventTimeR1, z2, (AnalyticsListener) obj);
            }
        });
    }

    @Override // androidx.media3.exoplayer.analytics.AnalyticsCollector
    public void c(final AudioSink.AudioTrackConfig audioTrackConfig) {
        final AnalyticsListener.EventTime eventTimeX1 = X1();
        a2(eventTimeX1, 1032, new ListenerSet.Event() { // from class: androidx.media3.exoplayer.analytics.n1
            @Override // androidx.media3.common.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).V(eventTimeX1, audioTrackConfig);
            }
        });
    }

    @Override // androidx.media3.common.Player.Listener
    public final void d(final boolean z2) {
        final AnalyticsListener.EventTime eventTimeX1 = X1();
        a2(eventTimeX1, 23, new ListenerSet.Event() { // from class: androidx.media3.exoplayer.analytics.k1
            @Override // androidx.media3.common.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).h(eventTimeX1, z2);
            }
        });
    }

    @Override // androidx.media3.exoplayer.analytics.AnalyticsCollector
    public void d0(AnalyticsListener analyticsListener) {
        Assertions.e(analyticsListener);
        this.f43356g.c(analyticsListener);
    }

    @Override // androidx.media3.exoplayer.analytics.AnalyticsCollector
    public final void e(final Exception exc) {
        final AnalyticsListener.EventTime eventTimeX1 = X1();
        a2(eventTimeX1, 1014, new ListenerSet.Event() { // from class: androidx.media3.exoplayer.analytics.t
            @Override // androidx.media3.common.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).I(eventTimeX1, exc);
            }
        });
    }

    @Override // androidx.media3.common.Player.Listener
    public final void e0(final float f3) {
        final AnalyticsListener.EventTime eventTimeX1 = X1();
        a2(eventTimeX1, 22, new ListenerSet.Event() { // from class: androidx.media3.exoplayer.analytics.i0
            @Override // androidx.media3.common.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).J(eventTimeX1, f3);
            }
        });
    }

    @Override // androidx.media3.exoplayer.analytics.AnalyticsCollector
    public final void f(final String str) {
        final AnalyticsListener.EventTime eventTimeX1 = X1();
        a2(eventTimeX1, 1019, new ListenerSet.Event() { // from class: androidx.media3.exoplayer.analytics.b
            @Override // androidx.media3.common.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).W(eventTimeX1, str);
            }
        });
    }

    @Override // androidx.media3.common.Player.Listener
    public final void f0(final AudioAttributes audioAttributes) {
        final AnalyticsListener.EventTime eventTimeX1 = X1();
        a2(eventTimeX1, 20, new ListenerSet.Event() { // from class: androidx.media3.exoplayer.analytics.l0
            @Override // androidx.media3.common.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).u(eventTimeX1, audioAttributes);
            }
        });
    }

    @Override // androidx.media3.exoplayer.analytics.AnalyticsCollector
    public final void g(final String str, final long j3, final long j4) {
        final AnalyticsListener.EventTime eventTimeX1 = X1();
        a2(eventTimeX1, 1016, new ListenerSet.Event() { // from class: androidx.media3.exoplayer.analytics.r
            @Override // androidx.media3.common.util.ListenerSet.Event
            public final void invoke(Object obj) {
                DefaultAnalyticsCollector.W0(eventTimeX1, str, j4, j3, (AnalyticsListener) obj);
            }
        });
    }

    @Override // androidx.media3.exoplayer.source.MediaSourceEventListener
    public final void g0(int i3, MediaSource.MediaPeriodId mediaPeriodId, final LoadEventInfo loadEventInfo, final MediaLoadData mediaLoadData) {
        final AnalyticsListener.EventTime eventTimeV1 = V1(i3, mediaPeriodId);
        a2(eventTimeV1, AdError.NO_FILL_ERROR_CODE, new ListenerSet.Event() { // from class: androidx.media3.exoplayer.analytics.j
            @Override // androidx.media3.common.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).q(eventTimeV1, loadEventInfo, mediaLoadData);
            }
        });
    }

    @Override // androidx.media3.exoplayer.analytics.AnalyticsCollector
    public final void h(final String str) {
        final AnalyticsListener.EventTime eventTimeX1 = X1();
        a2(eventTimeX1, 1012, new ListenerSet.Event() { // from class: androidx.media3.exoplayer.analytics.d1
            @Override // androidx.media3.common.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).U(eventTimeX1, str);
            }
        });
    }

    @Override // androidx.media3.exoplayer.source.MediaSourceEventListener
    public final void h0(int i3, MediaSource.MediaPeriodId mediaPeriodId, final MediaLoadData mediaLoadData) {
        final AnalyticsListener.EventTime eventTimeV1 = V1(i3, mediaPeriodId);
        a2(eventTimeV1, 1004, new ListenerSet.Event() { // from class: androidx.media3.exoplayer.analytics.l
            @Override // androidx.media3.common.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).u0(eventTimeV1, mediaLoadData);
            }
        });
    }

    @Override // androidx.media3.exoplayer.analytics.AnalyticsCollector
    public final void i(final String str, final long j3, final long j4) {
        final AnalyticsListener.EventTime eventTimeX1 = X1();
        a2(eventTimeX1, 1008, new ListenerSet.Event() { // from class: androidx.media3.exoplayer.analytics.t1
            @Override // androidx.media3.common.util.ListenerSet.Event
            public final void invoke(Object obj) {
                DefaultAnalyticsCollector.C0(eventTimeX1, str, j4, j3, (AnalyticsListener) obj);
            }
        });
    }

    @Override // androidx.media3.exoplayer.drm.DrmSessionEventListener
    public final void i0(int i3, MediaSource.MediaPeriodId mediaPeriodId) {
        final AnalyticsListener.EventTime eventTimeV1 = V1(i3, mediaPeriodId);
        a2(eventTimeV1, 1025, new ListenerSet.Event() { // from class: androidx.media3.exoplayer.analytics.y0
            @Override // androidx.media3.common.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).k0(eventTimeV1);
            }
        });
    }

    @Override // androidx.media3.common.Player.Listener
    public final void j(final PlaybackParameters playbackParameters) {
        final AnalyticsListener.EventTime eventTimeR1 = R1();
        a2(eventTimeR1, 12, new ListenerSet.Event() { // from class: androidx.media3.exoplayer.analytics.u
            @Override // androidx.media3.common.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).T(eventTimeR1, playbackParameters);
            }
        });
    }

    @Override // androidx.media3.common.Player.Listener
    public final void j0(Timeline timeline, final int i3) {
        this.f43354d.l((Player) Assertions.e(this.f43357h));
        final AnalyticsListener.EventTime eventTimeR1 = R1();
        a2(eventTimeR1, 0, new ListenerSet.Event() { // from class: androidx.media3.exoplayer.analytics.f0
            @Override // androidx.media3.common.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).v(eventTimeR1, i3);
            }
        });
    }

    @Override // androidx.media3.exoplayer.analytics.AnalyticsCollector
    public final void k(final DecoderCounters decoderCounters) {
        final AnalyticsListener.EventTime eventTimeX1 = X1();
        a2(eventTimeX1, 1007, new ListenerSet.Event() { // from class: androidx.media3.exoplayer.analytics.s0
            @Override // androidx.media3.common.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).z(eventTimeX1, decoderCounters);
            }
        });
    }

    @Override // androidx.media3.exoplayer.analytics.AnalyticsCollector
    public void k0(final int i3, final int i4, final boolean z2) {
        final AnalyticsListener.EventTime eventTimeX1 = X1();
        a2(eventTimeX1, 1033, new ListenerSet.Event() { // from class: androidx.media3.exoplayer.analytics.d
            @Override // androidx.media3.common.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).d0(eventTimeX1, i3, i4, z2);
            }
        });
    }

    @Override // androidx.media3.exoplayer.analytics.AnalyticsCollector
    public final void l(final DecoderCounters decoderCounters) {
        final AnalyticsListener.EventTime eventTimeX1 = X1();
        a2(eventTimeX1, 1015, new ListenerSet.Event() { // from class: androidx.media3.exoplayer.analytics.o
            @Override // androidx.media3.common.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).H(eventTimeX1, decoderCounters);
            }
        });
    }

    @Override // androidx.media3.common.Player.Listener
    public final void l0(final boolean z2, final int i3) {
        final AnalyticsListener.EventTime eventTimeR1 = R1();
        a2(eventTimeR1, -1, new ListenerSet.Event() { // from class: androidx.media3.exoplayer.analytics.k0
            @Override // androidx.media3.common.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).g0(eventTimeR1, z2, i3);
            }
        });
    }

    @Override // androidx.media3.common.Player.Listener
    public void m(final List list) {
        final AnalyticsListener.EventTime eventTimeR1 = R1();
        a2(eventTimeR1, 27, new ListenerSet.Event() { // from class: androidx.media3.exoplayer.analytics.t0
            @Override // androidx.media3.common.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).g(eventTimeR1, list);
            }
        });
    }

    @Override // androidx.media3.common.Player.Listener
    public void m0(final MediaMetadata mediaMetadata) {
        final AnalyticsListener.EventTime eventTimeR1 = R1();
        a2(eventTimeR1, 15, new ListenerSet.Event() { // from class: androidx.media3.exoplayer.analytics.z0
            @Override // androidx.media3.common.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).x0(eventTimeR1, mediaMetadata);
            }
        });
    }

    @Override // androidx.media3.exoplayer.analytics.AnalyticsCollector
    public final void n(final long j3) {
        final AnalyticsListener.EventTime eventTimeX1 = X1();
        a2(eventTimeX1, 1010, new ListenerSet.Event() { // from class: androidx.media3.exoplayer.analytics.s1
            @Override // androidx.media3.common.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).N(eventTimeX1, j3);
            }
        });
    }

    @Override // androidx.media3.common.Player.Listener
    public void n0(final long j3) {
        final AnalyticsListener.EventTime eventTimeR1 = R1();
        a2(eventTimeR1, 17, new ListenerSet.Event() { // from class: androidx.media3.exoplayer.analytics.c0
            @Override // androidx.media3.common.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).s0(eventTimeR1, j3);
            }
        });
    }

    @Override // androidx.media3.exoplayer.analytics.AnalyticsCollector
    public final void o(final Format format, final DecoderReuseEvaluation decoderReuseEvaluation) {
        final AnalyticsListener.EventTime eventTimeX1 = X1();
        a2(eventTimeX1, 1009, new ListenerSet.Event() { // from class: androidx.media3.exoplayer.analytics.n
            @Override // androidx.media3.common.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).Q(eventTimeX1, format, decoderReuseEvaluation);
            }
        });
    }

    @Override // androidx.media3.common.Player.Listener
    public void o0(final Tracks tracks) {
        final AnalyticsListener.EventTime eventTimeR1 = R1();
        a2(eventTimeR1, 2, new ListenerSet.Event() { // from class: androidx.media3.exoplayer.analytics.v
            @Override // androidx.media3.common.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).l0(eventTimeR1, tracks);
            }
        });
    }

    @Override // androidx.media3.exoplayer.analytics.AnalyticsCollector
    public final void p(final Exception exc) {
        final AnalyticsListener.EventTime eventTimeX1 = X1();
        a2(eventTimeX1, 1030, new ListenerSet.Event() { // from class: androidx.media3.exoplayer.analytics.o1
            @Override // androidx.media3.common.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).G(eventTimeX1, exc);
            }
        });
    }

    @Override // androidx.media3.common.Player.Listener
    public void p0(final DeviceInfo deviceInfo) {
        final AnalyticsListener.EventTime eventTimeR1 = R1();
        a2(eventTimeR1, 29, new ListenerSet.Event() { // from class: androidx.media3.exoplayer.analytics.w0
            @Override // androidx.media3.common.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).w0(eventTimeR1, deviceInfo);
            }
        });
    }

    @Override // androidx.media3.exoplayer.analytics.AnalyticsCollector
    public final void q(final DecoderCounters decoderCounters) {
        final AnalyticsListener.EventTime eventTimeW1 = W1();
        a2(eventTimeW1, 1013, new ListenerSet.Event() { // from class: androidx.media3.exoplayer.analytics.g
            @Override // androidx.media3.common.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).x(eventTimeW1, decoderCounters);
            }
        });
    }

    @Override // androidx.media3.common.Player.Listener
    public void q0(final PlaybackException playbackException) {
        final AnalyticsListener.EventTime eventTimeY1 = Y1(playbackException);
        a2(eventTimeY1, 10, new ListenerSet.Event() { // from class: androidx.media3.exoplayer.analytics.p0
            @Override // androidx.media3.common.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).h0(eventTimeY1, playbackException);
            }
        });
    }

    @Override // androidx.media3.exoplayer.analytics.AnalyticsCollector
    public final void r(final int i3, final long j3) {
        final AnalyticsListener.EventTime eventTimeW1 = W1();
        a2(eventTimeW1, 1018, new ListenerSet.Event() { // from class: androidx.media3.exoplayer.analytics.c
            @Override // androidx.media3.common.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).c0(eventTimeW1, i3, j3);
            }
        });
    }

    @Override // androidx.media3.common.Player.Listener
    public void r0(final long j3) {
        final AnalyticsListener.EventTime eventTimeR1 = R1();
        a2(eventTimeR1, 18, new ListenerSet.Event() { // from class: androidx.media3.exoplayer.analytics.a0
            @Override // androidx.media3.common.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).n0(eventTimeR1, j3);
            }
        });
    }

    @Override // androidx.media3.exoplayer.analytics.AnalyticsCollector
    public void release() {
        ((HandlerWrapper) Assertions.i(this.f43358i)).j(new Runnable() { // from class: androidx.media3.exoplayer.analytics.c1
            @Override // java.lang.Runnable
            public final void run() {
                this.f43517a.Z1();
            }
        });
    }

    @Override // androidx.media3.exoplayer.analytics.AnalyticsCollector
    public final void s(final Object obj, final long j3) {
        final AnalyticsListener.EventTime eventTimeX1 = X1();
        a2(eventTimeX1, 26, new ListenerSet.Event() { // from class: androidx.media3.exoplayer.analytics.f1
            @Override // androidx.media3.common.util.ListenerSet.Event
            public final void invoke(Object obj2) {
                ((AnalyticsListener) obj2).a(eventTimeX1, obj, j3);
            }
        });
    }

    @Override // androidx.media3.common.Player.Listener
    public final void s0(final boolean z2, final int i3) {
        final AnalyticsListener.EventTime eventTimeR1 = R1();
        a2(eventTimeR1, 5, new ListenerSet.Event() { // from class: androidx.media3.exoplayer.analytics.r0
            @Override // androidx.media3.common.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).l(eventTimeR1, z2, i3);
            }
        });
    }

    @Override // androidx.media3.common.Player.Listener
    public void t(final CueGroup cueGroup) {
        final AnalyticsListener.EventTime eventTimeR1 = R1();
        a2(eventTimeR1, 27, new ListenerSet.Event() { // from class: androidx.media3.exoplayer.analytics.x
            @Override // androidx.media3.common.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).p0(eventTimeR1, cueGroup);
            }
        });
    }

    @Override // androidx.media3.exoplayer.drm.DrmSessionEventListener
    public final void t0(int i3, MediaSource.MediaPeriodId mediaPeriodId) {
        final AnalyticsListener.EventTime eventTimeV1 = V1(i3, mediaPeriodId);
        a2(eventTimeV1, 1027, new ListenerSet.Event() { // from class: androidx.media3.exoplayer.analytics.s
            @Override // androidx.media3.common.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).n(eventTimeV1);
            }
        });
    }

    @Override // androidx.media3.common.Player.Listener
    public final void u(final Metadata metadata) {
        final AnalyticsListener.EventTime eventTimeR1 = R1();
        a2(eventTimeR1, 28, new ListenerSet.Event() { // from class: androidx.media3.exoplayer.analytics.m0
            @Override // androidx.media3.common.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).f(eventTimeR1, metadata);
            }
        });
    }

    @Override // androidx.media3.exoplayer.analytics.AnalyticsCollector
    public void u0(final Player player, Looper looper) {
        Assertions.g(this.f43357h == null || this.f43354d.f43361b.isEmpty());
        this.f43357h = (Player) Assertions.e(player);
        this.f43358i = this.f43351a.d(looper, null);
        this.f43356g = this.f43356g.e(looper, new ListenerSet.IterationFinishedEvent() { // from class: androidx.media3.exoplayer.analytics.l1
            @Override // androidx.media3.common.util.ListenerSet.IterationFinishedEvent
            public final void a(Object obj, FlagSet flagSet) {
                AnalyticsListener analyticsListener = (AnalyticsListener) obj;
                analyticsListener.v0(player, new AnalyticsListener.Events(flagSet, this.f43582a.f43355f));
            }
        });
    }

    @Override // androidx.media3.exoplayer.analytics.AnalyticsCollector
    public final void v(final Format format, final DecoderReuseEvaluation decoderReuseEvaluation) {
        final AnalyticsListener.EventTime eventTimeX1 = X1();
        a2(eventTimeX1, 1017, new ListenerSet.Event() { // from class: androidx.media3.exoplayer.analytics.k
            @Override // androidx.media3.common.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).C0(eventTimeX1, format, decoderReuseEvaluation);
            }
        });
    }

    @Override // androidx.media3.common.Player.Listener
    public final void v0(final Player.PositionInfo positionInfo, final Player.PositionInfo positionInfo2, final int i3) {
        if (i3 == 1) {
            this.f43359j = false;
        }
        this.f43354d.j((Player) Assertions.e(this.f43357h));
        final AnalyticsListener.EventTime eventTimeR1 = R1();
        a2(eventTimeR1, 11, new ListenerSet.Event() { // from class: androidx.media3.exoplayer.analytics.b1
            @Override // androidx.media3.common.util.ListenerSet.Event
            public final void invoke(Object obj) {
                DefaultAnalyticsCollector.m1(eventTimeR1, i3, positionInfo, positionInfo2, (AnalyticsListener) obj);
            }
        });
    }

    @Override // androidx.media3.exoplayer.analytics.AnalyticsCollector
    public final void w(final DecoderCounters decoderCounters) {
        final AnalyticsListener.EventTime eventTimeW1 = W1();
        a2(eventTimeW1, 1020, new ListenerSet.Event() { // from class: androidx.media3.exoplayer.analytics.w
            @Override // androidx.media3.common.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).m(eventTimeW1, decoderCounters);
            }
        });
    }

    @Override // androidx.media3.common.Player.Listener
    public void w0(final boolean z2) {
        final AnalyticsListener.EventTime eventTimeR1 = R1();
        a2(eventTimeR1, 7, new ListenerSet.Event() { // from class: androidx.media3.exoplayer.analytics.n0
            @Override // androidx.media3.common.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).e(eventTimeR1, z2);
            }
        });
    }

    @Override // androidx.media3.exoplayer.analytics.AnalyticsCollector
    public final void x(final Exception exc) {
        final AnalyticsListener.EventTime eventTimeX1 = X1();
        a2(eventTimeX1, 1029, new ListenerSet.Event() { // from class: androidx.media3.exoplayer.analytics.q
            @Override // androidx.media3.common.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).p(eventTimeX1, exc);
            }
        });
    }

    @Override // androidx.media3.exoplayer.analytics.AnalyticsCollector
    public final void y(final int i3, final long j3, final long j4) {
        final AnalyticsListener.EventTime eventTimeX1 = X1();
        a2(eventTimeX1, CloseCodes.UNEXPECTED_CONDITION, new ListenerSet.Event() { // from class: androidx.media3.exoplayer.analytics.j0
            @Override // androidx.media3.common.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).O(eventTimeX1, i3, j3, j4);
            }
        });
    }

    @Override // androidx.media3.common.Player.Listener
    public final void z(final int i3) {
        final AnalyticsListener.EventTime eventTimeR1 = R1();
        a2(eventTimeR1, 8, new ListenerSet.Event() { // from class: androidx.media3.exoplayer.analytics.e1
            @Override // androidx.media3.common.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).o0(eventTimeR1, i3);
            }
        });
    }

    @Override // androidx.media3.common.Player.Listener
    public void P() {
    }

    @Override // androidx.media3.common.Player.Listener
    public void C(boolean z2) {
    }

    @Override // androidx.media3.common.Player.Listener
    public void a0(int i3) {
    }

    public static /* synthetic */ void M1(AnalyticsListener analyticsListener, FlagSet flagSet) {
    }

    @Override // androidx.media3.common.Player.Listener
    public void c0(Player player, Player.Events events) {
    }
}
