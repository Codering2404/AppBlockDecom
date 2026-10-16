package androidx.media3.common;

import androidx.media3.common.FlagSet;
import androidx.media3.common.text.CueGroup;
import androidx.media3.common.util.Size;
import androidx.media3.common.util.Util;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public interface Player {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface Command {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Commands {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Commands f40956b = new Builder().e();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final String f40957c = Util.y0(0);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final FlagSet f40958a;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        public static final class Builder {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private static final int[] f40959b = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 31, 20, 21, 22, 23, 24, 25, 33, 26, 34, 35, 27, 28, 29, 30, 32};

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final FlagSet.Builder f40960a = new FlagSet.Builder();

            public Builder a(int i3) {
                this.f40960a.a(i3);
                return this;
            }

            public Builder b(Commands commands) {
                this.f40960a.b(commands.f40958a);
                return this;
            }

            public Builder c(int... iArr) {
                this.f40960a.c(iArr);
                return this;
            }

            public Builder d(int i3, boolean z2) {
                this.f40960a.d(i3, z2);
                return this;
            }

            public Commands e() {
                return new Commands(this.f40960a.e());
            }
        }

        public boolean b(int i3) {
            return this.f40958a.a(i3);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Commands) {
                return this.f40958a.equals(((Commands) obj).f40958a);
            }
            return false;
        }

        public int hashCode() {
            return this.f40958a.hashCode();
        }

        private Commands(FlagSet flagSet) {
            this.f40958a = flagSet;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface DiscontinuityReason {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface Event {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Events {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final FlagSet f40961a;

        public Events(FlagSet flagSet) {
            this.f40961a = flagSet;
        }

        public boolean a(int... iArr) {
            return this.f40961a.b(iArr);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Events) {
                return this.f40961a.equals(((Events) obj).f40961a);
            }
            return false;
        }

        public int hashCode() {
            return this.f40961a.hashCode();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface MediaItemTransitionReason {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface PlayWhenReadyChangeReason {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface PlaybackSuppressionReason {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class PositionInfo {

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        static final String f40962k = Util.y0(0);

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private static final String f40963l = Util.y0(1);

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        static final String f40964m = Util.y0(2);

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        static final String f40965n = Util.y0(3);

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        static final String f40966o = Util.y0(4);

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private static final String f40967p = Util.y0(5);

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        private static final String f40968q = Util.y0(6);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f40969a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f40970b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f40971c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final MediaItem f40972d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Object f40973e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f40974f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final long f40975g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final long f40976h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final int f40977i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final int f40978j;

        public PositionInfo(Object obj, int i3, MediaItem mediaItem, Object obj2, int i4, long j3, long j4, int i5, int i6) {
            this.f40969a = obj;
            this.f40970b = i3;
            this.f40971c = i3;
            this.f40972d = mediaItem;
            this.f40973e = obj2;
            this.f40974f = i4;
            this.f40975g = j3;
            this.f40976h = j4;
            this.f40977i = i5;
            this.f40978j = i6;
        }

        public boolean a(PositionInfo positionInfo) {
            return this.f40971c == positionInfo.f40971c && this.f40974f == positionInfo.f40974f && this.f40975g == positionInfo.f40975g && this.f40976h == positionInfo.f40976h && this.f40977i == positionInfo.f40977i && this.f40978j == positionInfo.f40978j && Objects.equals(this.f40972d, positionInfo.f40972d);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && PositionInfo.class == obj.getClass()) {
                PositionInfo positionInfo = (PositionInfo) obj;
                if (a(positionInfo) && Objects.equals(this.f40969a, positionInfo.f40969a) && Objects.equals(this.f40973e, positionInfo.f40973e)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return Objects.hash(this.f40969a, Integer.valueOf(this.f40971c), this.f40972d, this.f40973e, Integer.valueOf(this.f40974f), Long.valueOf(this.f40975g), Long.valueOf(this.f40976h), Integer.valueOf(this.f40977i), Integer.valueOf(this.f40978j));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface RepeatMode {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface State {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface TimelineChangeReason {
    }

    boolean A();

    void B(Listener listener);

    int C();

    int D();

    Timeline E();

    TrackSelectionParameters G();

    void H();

    int I();

    void J(int i3, long j3);

    Commands K();

    boolean L();

    long M();

    int N();

    VideoSize O();

    AudioAttributes Q();

    DeviceInfo R();

    boolean S();

    int T();

    void U(List list, int i3, long j3);

    long V();

    long X();

    long Z();

    boolean a();

    boolean a0();

    PlaybackException b();

    MediaMetadata c0();

    PlaybackParameters d();

    void d0(MediaItem mediaItem, long j3);

    void e();

    boolean f();

    int f0();

    long g();

    boolean g0();

    long getCurrentPosition();

    long getDuration();

    float getVolume();

    MediaItem h();

    boolean h0();

    void i();

    long i0();

    void j();

    void j0();

    void k(List list, boolean z2);

    Size l();

    void l0();

    void m();

    MediaMetadata m0();

    void n(boolean z2);

    void n0(List list);

    void o(MediaItem mediaItem);

    long o0();

    int p();

    boolean p0();

    void q();

    void r();

    Tracks s();

    void stop();

    boolean t();

    CueGroup u();

    void v(long j3);

    int x();

    boolean y(int i3);

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface Listener {
        default void P() {
        }

        default void B(int i3) {
        }

        default void C(boolean z2) {
        }

        default void F(int i3) {
        }

        default void G(int i3) {
        }

        default void J(boolean z2) {
        }

        default void L(long j3) {
        }

        default void M(MediaMetadata mediaMetadata) {
        }

        default void O(TrackSelectionParameters trackSelectionParameters) {
        }

        default void T(PlaybackException playbackException) {
        }

        default void W(Commands commands) {
        }

        default void a0(int i3) {
        }

        default void b(VideoSize videoSize) {
        }

        default void b0(boolean z2) {
        }

        default void d(boolean z2) {
        }

        default void e0(float f3) {
        }

        default void f0(AudioAttributes audioAttributes) {
        }

        default void j(PlaybackParameters playbackParameters) {
        }

        default void m(List list) {
        }

        default void m0(MediaMetadata mediaMetadata) {
        }

        default void n0(long j3) {
        }

        default void o0(Tracks tracks) {
        }

        default void p0(DeviceInfo deviceInfo) {
        }

        default void q0(PlaybackException playbackException) {
        }

        default void r0(long j3) {
        }

        default void t(CueGroup cueGroup) {
        }

        default void u(Metadata metadata) {
        }

        default void w0(boolean z2) {
        }

        default void z(int i3) {
        }

        default void K(int i3, boolean z2) {
        }

        default void Q(MediaItem mediaItem, int i3) {
        }

        default void V(int i3, int i4) {
        }

        default void c0(Player player, Events events) {
        }

        default void j0(Timeline timeline, int i3) {
        }

        default void l0(boolean z2, int i3) {
        }

        default void s0(boolean z2, int i3) {
        }

        default void v0(PositionInfo positionInfo, PositionInfo positionInfo2, int i3) {
        }
    }
}
