package androidx.media3.exoplayer.analytics;

import androidx.media3.common.Format;
import androidx.media3.exoplayer.analytics.AnalyticsListener;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class PlaybackStats {
    public static final PlaybackStats O = a(new PlaybackStats[0]);
    public final int A;
    public final long B;
    public final int C;
    public final long D;
    public final long E;
    public final long F;
    public final long G;
    public final long H;
    public final int I;
    public final int J;
    public final int K;
    public final List L;
    public final List M;
    private final long[] N;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f43414a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List f43415b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List f43416c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f43417d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f43418e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f43419f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f43420g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f43421h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final long f43422i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f43423j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f43424k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f43425l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f43426m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f43427n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final long f43428o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final int f43429p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final List f43430q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final List f43431r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final long f43432s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final long f43433t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final long f43434u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final long f43435v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final long f43436w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final long f43437x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final int f43438y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final int f43439z;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class EventTimeAndException {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AnalyticsListener.EventTime f43440a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Exception f43441b;

        public EventTimeAndException(AnalyticsListener.EventTime eventTime, Exception exc) {
            this.f43440a = eventTime;
            this.f43441b = exc;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || EventTimeAndException.class != obj.getClass()) {
                return false;
            }
            EventTimeAndException eventTimeAndException = (EventTimeAndException) obj;
            if (this.f43440a.equals(eventTimeAndException.f43440a)) {
                return this.f43441b.equals(eventTimeAndException.f43441b);
            }
            return false;
        }

        public int hashCode() {
            return (this.f43440a.hashCode() * 31) + this.f43441b.hashCode();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class EventTimeAndFormat {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AnalyticsListener.EventTime f43442a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Format f43443b;

        public EventTimeAndFormat(AnalyticsListener.EventTime eventTime, Format format) {
            this.f43442a = eventTime;
            this.f43443b = format;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && EventTimeAndFormat.class == obj.getClass()) {
                EventTimeAndFormat eventTimeAndFormat = (EventTimeAndFormat) obj;
                if (!this.f43442a.equals(eventTimeAndFormat.f43442a)) {
                    return false;
                }
                Format format = this.f43443b;
                Format format2 = eventTimeAndFormat.f43443b;
                if (format != null) {
                    return format.equals(format2);
                }
                if (format2 == null) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            int iHashCode = this.f43442a.hashCode() * 31;
            Format format = this.f43443b;
            return iHashCode + (format != null ? format.hashCode() : 0);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class EventTimeAndPlaybackState {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AnalyticsListener.EventTime f43444a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f43445b;

        public EventTimeAndPlaybackState(AnalyticsListener.EventTime eventTime, int i3) {
            this.f43444a = eventTime;
            this.f43445b = i3;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || EventTimeAndPlaybackState.class != obj.getClass()) {
                return false;
            }
            EventTimeAndPlaybackState eventTimeAndPlaybackState = (EventTimeAndPlaybackState) obj;
            if (this.f43445b != eventTimeAndPlaybackState.f43445b) {
                return false;
            }
            return this.f43444a.equals(eventTimeAndPlaybackState.f43444a);
        }

        public int hashCode() {
            return (this.f43444a.hashCode() * 31) + this.f43445b;
        }
    }

    PlaybackStats(int i3, long[] jArr, List list, List list2, long j3, int i4, int i5, int i6, int i7, long j4, int i8, int i9, int i10, int i11, int i12, long j5, int i13, List list3, List list4, long j6, long j7, long j8, long j9, long j10, long j11, int i14, int i15, int i16, long j12, int i17, long j13, long j14, long j15, long j16, long j17, int i18, int i19, int i20, List list5, List list6) {
        this.f43414a = i3;
        this.N = jArr;
        this.f43415b = Collections.unmodifiableList(list);
        this.f43416c = Collections.unmodifiableList(list2);
        this.f43417d = j3;
        this.f43418e = i4;
        this.f43419f = i5;
        this.f43420g = i6;
        this.f43421h = i7;
        this.f43422i = j4;
        this.f43423j = i8;
        this.f43424k = i9;
        this.f43425l = i10;
        this.f43426m = i11;
        this.f43427n = i12;
        this.f43428o = j5;
        this.f43429p = i13;
        this.f43430q = Collections.unmodifiableList(list3);
        this.f43431r = Collections.unmodifiableList(list4);
        this.f43432s = j6;
        this.f43433t = j7;
        this.f43434u = j8;
        this.f43435v = j9;
        this.f43436w = j10;
        this.f43437x = j11;
        this.f43438y = i14;
        this.f43439z = i15;
        this.A = i16;
        this.B = j12;
        this.C = i17;
        this.D = j13;
        this.E = j14;
        this.F = j15;
        this.G = j16;
        this.H = j17;
        this.I = i18;
        this.J = i19;
        this.K = i20;
        this.L = Collections.unmodifiableList(list5);
        this.M = Collections.unmodifiableList(list6);
    }

    public static PlaybackStats a(PlaybackStats... playbackStatsArr) {
        int i3;
        PlaybackStats[] playbackStatsArr2 = playbackStatsArr;
        long[] jArr = new long[16];
        int length = playbackStatsArr2.length;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        int i16 = 0;
        int i17 = 0;
        long j3 = 0;
        long j4 = 0;
        long j5 = 0;
        long j6 = 0;
        long j7 = 0;
        long j8 = 0;
        long j9 = 0;
        long j10 = 0;
        long j11 = 0;
        long j12 = 0;
        long j13 = -1;
        long j14 = -1;
        long jMax = -9223372036854775807L;
        long jMin = -9223372036854775807L;
        long j15 = -9223372036854775807L;
        int i18 = -1;
        int i19 = 0;
        int i20 = 0;
        int i21 = 0;
        int i22 = 0;
        while (i19 < length) {
            PlaybackStats playbackStats = playbackStatsArr2[i19];
            i4 += playbackStats.f43414a;
            for (int i23 = 0; i23 < 16; i23++) {
                jArr[i23] = jArr[i23] + playbackStats.N[i23];
            }
            if (jMin == -9223372036854775807L) {
                jMin = playbackStats.f43417d;
            } else {
                long j16 = playbackStats.f43417d;
                if (j16 != -9223372036854775807L) {
                    jMin = Math.min(jMin, j16);
                }
            }
            i20 += playbackStats.f43418e;
            i21 += playbackStats.f43419f;
            i22 += playbackStats.f43420g;
            i5 += playbackStats.f43421h;
            if (j15 == -9223372036854775807L) {
                j15 = playbackStats.f43422i;
            } else {
                long j17 = playbackStats.f43422i;
                if (j17 != -9223372036854775807L) {
                    j15 += j17;
                }
            }
            i6 += playbackStats.f43423j;
            i7 += playbackStats.f43424k;
            i8 += playbackStats.f43425l;
            i9 += playbackStats.f43426m;
            i10 += playbackStats.f43427n;
            if (jMax == -9223372036854775807L) {
                jMax = playbackStats.f43428o;
            } else {
                long j18 = playbackStats.f43428o;
                if (j18 != -9223372036854775807L) {
                    jMax = Math.max(jMax, j18);
                }
            }
            i11 += playbackStats.f43429p;
            j3 += playbackStats.f43432s;
            j4 += playbackStats.f43433t;
            j5 += playbackStats.f43434u;
            j6 += playbackStats.f43435v;
            j7 += playbackStats.f43436w;
            j8 += playbackStats.f43437x;
            i12 += playbackStats.f43438y;
            i13 += playbackStats.f43439z;
            int i24 = i18;
            if (i24 == -1) {
                i18 = playbackStats.A;
            } else {
                i18 = i24;
                int i25 = playbackStats.A;
                if (i25 != -1) {
                    i18 += i25;
                }
            }
            if (j13 == -1) {
                i3 = length;
                j13 = playbackStats.B;
            } else {
                i3 = length;
                long j19 = playbackStats.B;
                if (j19 != -1) {
                    j13 += j19;
                }
            }
            i14 += playbackStats.C;
            if (j14 == -1) {
                j14 = playbackStats.D;
            } else {
                long j20 = playbackStats.D;
                if (j20 != -1) {
                    j14 += j20;
                }
            }
            j9 += playbackStats.E;
            j10 += playbackStats.F;
            j11 += playbackStats.G;
            j12 += playbackStats.H;
            i15 += playbackStats.I;
            i16 += playbackStats.J;
            i17 += playbackStats.K;
            i19++;
            length = i3;
            playbackStatsArr2 = playbackStatsArr;
        }
        long j21 = jMin;
        long j22 = jMax;
        List list = Collections.EMPTY_LIST;
        return new PlaybackStats(i4, jArr, list, list, j21, i20, i21, i22, i5, j15, i6, i7, i8, i9, i10, j22, i11, list, list, j3, j4, j5, j6, j7, j8, i12, i13, i18, j13, i14, j14, j9, j10, j11, j12, i15, i16, i17, list, list);
    }
}
