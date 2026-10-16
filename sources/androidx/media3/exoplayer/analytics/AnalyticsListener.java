package androidx.media3.exoplayer.analytics;

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
import androidx.media3.exoplayer.DecoderCounters;
import androidx.media3.exoplayer.DecoderReuseEvaluation;
import androidx.media3.exoplayer.audio.AudioSink;
import androidx.media3.exoplayer.source.LoadEventInfo;
import androidx.media3.exoplayer.source.MediaLoadData;
import androidx.media3.exoplayer.source.MediaSource;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public interface AnalyticsListener {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface EventFlags {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class EventTime {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f43339a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Timeline f43340b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f43341c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final MediaSource.MediaPeriodId f43342d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final long f43343e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final Timeline f43344f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final int f43345g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final MediaSource.MediaPeriodId f43346h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final long f43347i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final long f43348j;

        public EventTime(long j3, Timeline timeline, int i3, MediaSource.MediaPeriodId mediaPeriodId, long j4, Timeline timeline2, int i4, MediaSource.MediaPeriodId mediaPeriodId2, long j5, long j6) {
            this.f43339a = j3;
            this.f43340b = timeline;
            this.f43341c = i3;
            this.f43342d = mediaPeriodId;
            this.f43343e = j4;
            this.f43344f = timeline2;
            this.f43345g = i4;
            this.f43346h = mediaPeriodId2;
            this.f43347i = j5;
            this.f43348j = j6;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && EventTime.class == obj.getClass()) {
                EventTime eventTime = (EventTime) obj;
                if (this.f43339a == eventTime.f43339a && this.f43341c == eventTime.f43341c && this.f43343e == eventTime.f43343e && this.f43345g == eventTime.f43345g && this.f43347i == eventTime.f43347i && this.f43348j == eventTime.f43348j && Objects.equals(this.f43340b, eventTime.f43340b) && Objects.equals(this.f43342d, eventTime.f43342d) && Objects.equals(this.f43344f, eventTime.f43344f) && Objects.equals(this.f43346h, eventTime.f43346h)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return Objects.hash(Long.valueOf(this.f43339a), this.f43340b, Integer.valueOf(this.f43341c), this.f43342d, Long.valueOf(this.f43343e), this.f43344f, Integer.valueOf(this.f43345g), this.f43346h, Long.valueOf(this.f43347i), Long.valueOf(this.f43348j));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Events {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final FlagSet f43349a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final SparseArray f43350b;

        public Events(FlagSet flagSet, SparseArray sparseArray) {
            this.f43349a = flagSet;
            SparseArray sparseArray2 = new SparseArray(flagSet.d());
            for (int i3 = 0; i3 < flagSet.d(); i3++) {
                int iC = flagSet.c(i3);
                sparseArray2.append(iC, (EventTime) Assertions.e((EventTime) sparseArray.get(iC)));
            }
            this.f43350b = sparseArray2;
        }

        public boolean a(int i3) {
            return this.f43349a.a(i3);
        }

        public int b(int i3) {
            return this.f43349a.c(i3);
        }

        public EventTime c(int i3) {
            return (EventTime) Assertions.e((EventTime) this.f43350b.get(i3));
        }

        public int d() {
            return this.f43349a.d();
        }
    }

    default void A(EventTime eventTime) {
    }

    default void Z(EventTime eventTime) {
    }

    default void e0(EventTime eventTime) {
    }

    default void j0(EventTime eventTime) {
    }

    default void k0(EventTime eventTime) {
    }

    default void n(EventTime eventTime) {
    }

    default void z0(EventTime eventTime) {
    }

    default void E(EventTime eventTime, int i3) {
    }

    default void F(EventTime eventTime, Player.Commands commands) {
    }

    default void G(EventTime eventTime, Exception exc) {
    }

    default void H(EventTime eventTime, DecoderCounters decoderCounters) {
    }

    default void I(EventTime eventTime, Exception exc) {
    }

    default void J(EventTime eventTime, float f3) {
    }

    default void K(EventTime eventTime, boolean z2) {
    }

    default void L(EventTime eventTime, int i3) {
    }

    default void N(EventTime eventTime, long j3) {
    }

    default void P(EventTime eventTime, int i3) {
    }

    default void S(EventTime eventTime, AudioSink.AudioTrackConfig audioTrackConfig) {
    }

    default void T(EventTime eventTime, PlaybackParameters playbackParameters) {
    }

    default void U(EventTime eventTime, String str) {
    }

    default void V(EventTime eventTime, AudioSink.AudioTrackConfig audioTrackConfig) {
    }

    default void W(EventTime eventTime, String str) {
    }

    default void X(EventTime eventTime, int i3) {
    }

    default void Y(EventTime eventTime, MediaLoadData mediaLoadData) {
    }

    default void b(EventTime eventTime, boolean z2) {
    }

    default void b0(EventTime eventTime, boolean z2) {
    }

    default void e(EventTime eventTime, boolean z2) {
    }

    default void f(EventTime eventTime, Metadata metadata) {
    }

    default void g(EventTime eventTime, List list) {
    }

    default void h(EventTime eventTime, boolean z2) {
    }

    default void h0(EventTime eventTime, PlaybackException playbackException) {
    }

    default void i(EventTime eventTime, PlaybackException playbackException) {
    }

    default void j(EventTime eventTime, long j3) {
    }

    default void k(EventTime eventTime, int i3) {
    }

    default void l0(EventTime eventTime, Tracks tracks) {
    }

    default void m(EventTime eventTime, DecoderCounters decoderCounters) {
    }

    default void n0(EventTime eventTime, long j3) {
    }

    default void o0(EventTime eventTime, int i3) {
    }

    default void p(EventTime eventTime, Exception exc) {
    }

    default void p0(EventTime eventTime, CueGroup cueGroup) {
    }

    default void r0(EventTime eventTime, VideoSize videoSize) {
    }

    default void s(EventTime eventTime, TrackSelectionParameters trackSelectionParameters) {
    }

    default void s0(EventTime eventTime, long j3) {
    }

    default void t(EventTime eventTime, MediaMetadata mediaMetadata) {
    }

    default void u(EventTime eventTime, AudioAttributes audioAttributes) {
    }

    default void u0(EventTime eventTime, MediaLoadData mediaLoadData) {
    }

    default void v(EventTime eventTime, int i3) {
    }

    default void v0(Player player, Events events) {
    }

    default void w(EventTime eventTime, Exception exc) {
    }

    default void w0(EventTime eventTime, DeviceInfo deviceInfo) {
    }

    default void x(EventTime eventTime, DecoderCounters decoderCounters) {
    }

    default void x0(EventTime eventTime, MediaMetadata mediaMetadata) {
    }

    default void z(EventTime eventTime, DecoderCounters decoderCounters) {
    }

    default void A0(EventTime eventTime, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
    }

    default void B(EventTime eventTime, int i3, int i4) {
    }

    default void C0(EventTime eventTime, Format format, DecoderReuseEvaluation decoderReuseEvaluation) {
    }

    default void Q(EventTime eventTime, Format format, DecoderReuseEvaluation decoderReuseEvaluation) {
    }

    default void R(EventTime eventTime, String str, long j3) {
    }

    default void a(EventTime eventTime, Object obj, long j3) {
    }

    default void c0(EventTime eventTime, int i3, long j3) {
    }

    default void d(EventTime eventTime, int i3, boolean z2) {
    }

    default void f0(EventTime eventTime, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
    }

    default void g0(EventTime eventTime, boolean z2, int i3) {
    }

    default void i0(EventTime eventTime, String str, long j3) {
    }

    default void l(EventTime eventTime, boolean z2, int i3) {
    }

    default void q(EventTime eventTime, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
    }

    default void t0(EventTime eventTime, long j3, int i3) {
    }

    default void y(EventTime eventTime, MediaItem mediaItem, int i3) {
    }

    default void C(EventTime eventTime, Player.PositionInfo positionInfo, Player.PositionInfo positionInfo2, int i3) {
    }

    default void D(EventTime eventTime, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, int i3) {
    }

    default void O(EventTime eventTime, int i3, long j3, long j4) {
    }

    default void d0(EventTime eventTime, int i3, int i4, boolean z2) {
    }

    default void o(EventTime eventTime, int i3, long j3, long j4) {
    }

    default void q0(EventTime eventTime, String str, long j3, long j4) {
    }

    default void r(EventTime eventTime, String str, long j3, long j4) {
    }

    default void M(EventTime eventTime, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, IOException iOException, boolean z2) {
    }

    default void a0(EventTime eventTime, int i3, int i4, int i5, float f3) {
    }
}
