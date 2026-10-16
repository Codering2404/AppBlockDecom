package androidx.media3.exoplayer.analytics;

import android.os.SystemClock;
import android.util.Pair;
import androidx.media3.common.Format;
import androidx.media3.common.PlaybackException;
import androidx.media3.common.Player;
import androidx.media3.common.Timeline;
import androidx.media3.common.Tracks;
import androidx.media3.common.VideoSize;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.analytics.AnalyticsListener;
import androidx.media3.exoplayer.analytics.PlaybackSessionManager;
import androidx.media3.exoplayer.analytics.PlaybackStats;
import androidx.media3.exoplayer.source.LoadEventInfo;
import androidx.media3.exoplayer.source.MediaLoadData;
import androidx.media3.exoplayer.source.MediaSource;
import com.facebook.stetho.websocket.CloseCodes;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class PlaybackStatsListener implements AnalyticsListener, PlaybackSessionManager.Listener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final PlaybackSessionManager f43446a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map f43447b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map f43448c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Callback f43449d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f43450e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Timeline.Period f43451f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private PlaybackStats f43452g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f43453h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private long f43454i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f43455j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f43456k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private Exception f43457l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private long f43458m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private long f43459n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private Format f43460o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private Format f43461p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private VideoSize f43462q;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface Callback {
        void a(AnalyticsListener.EventTime eventTime, PlaybackStats playbackStats);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class PlaybackStatsTracker {
        private long A;
        private long B;
        private long C;
        private long D;
        private long E;
        private int F;
        private int G;
        private int H;
        private long I;
        private boolean J;
        private boolean K;
        private boolean L;
        private boolean M;
        private boolean N;
        private long O;
        private Format P;
        private Format Q;
        private long R;
        private long S;
        private float T;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f43463a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long[] f43464b = new long[16];

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final List f43465c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final List f43466d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final List f43467e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final List f43468f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final List f43469g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final List f43470h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private final boolean f43471i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private long f43472j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private boolean f43473k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private boolean f43474l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private boolean f43475m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private int f43476n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private int f43477o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private int f43478p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        private int f43479q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        private long f43480r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        private int f43481s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        private long f43482t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        private long f43483u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        private long f43484v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        private long f43485w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        private long f43486x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        private long f43487y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        private long f43488z;

        public PlaybackStatsTracker(boolean z2, AnalyticsListener.EventTime eventTime) {
            this.f43463a = z2;
            this.f43465c = z2 ? new ArrayList() : Collections.EMPTY_LIST;
            this.f43466d = z2 ? new ArrayList() : Collections.EMPTY_LIST;
            this.f43467e = z2 ? new ArrayList() : Collections.EMPTY_LIST;
            this.f43468f = z2 ? new ArrayList() : Collections.EMPTY_LIST;
            this.f43469g = z2 ? new ArrayList() : Collections.EMPTY_LIST;
            this.f43470h = z2 ? new ArrayList() : Collections.EMPTY_LIST;
            boolean z3 = false;
            this.H = 0;
            this.I = eventTime.f43339a;
            this.f43472j = -9223372036854775807L;
            this.f43480r = -9223372036854775807L;
            MediaSource.MediaPeriodId mediaPeriodId = eventTime.f43342d;
            if (mediaPeriodId != null && mediaPeriodId.c()) {
                z3 = true;
            }
            this.f43471i = z3;
            this.f43483u = -1L;
            this.f43482t = -1L;
            this.f43481s = -1;
            this.T = 1.0f;
        }

        private long[] b(long j3) {
            List list = this.f43466d;
            return new long[]{j3, ((long[]) list.get(list.size() - 1))[1] + ((long) ((j3 - r0[0]) * this.T))};
        }

        private static boolean c(int i3, int i4) {
            return ((i3 != 1 && i3 != 2 && i3 != 14) || i4 == 1 || i4 == 2 || i4 == 14 || i4 == 3 || i4 == 4 || i4 == 9 || i4 == 11) ? false : true;
        }

        private static boolean d(int i3) {
            return i3 == 4 || i3 == 7;
        }

        private static boolean e(int i3) {
            return i3 == 3 || i3 == 4 || i3 == 9;
        }

        private static boolean f(int i3) {
            return i3 == 6 || i3 == 7 || i3 == 10;
        }

        private void g(long j3) {
            Format format;
            int i3;
            if (this.H == 3 && (format = this.Q) != null && (i3 = format.f40627j) != -1) {
                long j4 = (long) ((j3 - this.S) * this.T);
                this.f43488z += j4;
                this.A += j4 * ((long) i3);
            }
            this.S = j3;
        }

        private void h(long j3) {
            Format format;
            if (this.H == 3 && (format = this.P) != null) {
                long j4 = (long) ((j3 - this.R) * this.T);
                int i3 = format.f40640w;
                if (i3 != -1) {
                    this.f43484v += j4;
                    this.f43485w += ((long) i3) * j4;
                }
                int i4 = format.f40627j;
                if (i4 != -1) {
                    this.f43486x += j4;
                    this.f43487y += j4 * ((long) i4);
                }
            }
            this.R = j3;
        }

        private void i(AnalyticsListener.EventTime eventTime, Format format) {
            int i3;
            if (Objects.equals(this.Q, format)) {
                return;
            }
            g(eventTime.f43339a);
            if (format != null && this.f43483u == -1 && (i3 = format.f40627j) != -1) {
                this.f43483u = i3;
            }
            this.Q = format;
            if (this.f43463a) {
                this.f43468f.add(new PlaybackStats.EventTimeAndFormat(eventTime, format));
            }
        }

        private void j(long j3) {
            if (f(this.H)) {
                long j4 = j3 - this.O;
                long j5 = this.f43480r;
                if (j5 == -9223372036854775807L || j4 > j5) {
                    this.f43480r = j4;
                }
            }
        }

        private void k(long j3, long j4) {
            if (this.f43463a) {
                if (this.H != 3) {
                    if (j4 == -9223372036854775807L) {
                        return;
                    }
                    if (!this.f43466d.isEmpty()) {
                        List list = this.f43466d;
                        long j5 = ((long[]) list.get(list.size() - 1))[1];
                        if (j5 != j4) {
                            this.f43466d.add(new long[]{j3, j5});
                        }
                    }
                }
                if (j4 != -9223372036854775807L) {
                    this.f43466d.add(new long[]{j3, j4});
                } else {
                    if (this.f43466d.isEmpty()) {
                        return;
                    }
                    this.f43466d.add(b(j3));
                }
            }
        }

        private void l(AnalyticsListener.EventTime eventTime, Format format) {
            int i3;
            int i4;
            if (Objects.equals(this.P, format)) {
                return;
            }
            h(eventTime.f43339a);
            if (format != null) {
                if (this.f43481s == -1 && (i4 = format.f40640w) != -1) {
                    this.f43481s = i4;
                }
                if (this.f43482t == -1 && (i3 = format.f40627j) != -1) {
                    this.f43482t = i3;
                }
            }
            this.P = format;
            if (this.f43463a) {
                this.f43467e.add(new PlaybackStats.EventTimeAndFormat(eventTime, format));
            }
        }

        private int q(Player player) {
            int iP = player.p();
            if (this.J && this.K) {
                return 5;
            }
            if (this.M) {
                return 13;
            }
            if (!this.K) {
                return this.N ? 1 : 0;
            }
            if (this.L) {
                return 14;
            }
            if (iP == 4) {
                return 11;
            }
            if (iP != 2) {
                if (iP == 3) {
                    if (player.L()) {
                        return player.C() != 0 ? 9 : 3;
                    }
                    return 4;
                }
                if (iP != 1 || this.H == 0) {
                    return this.H;
                }
                return 12;
            }
            int i3 = this.H;
            if (i3 == 0 || i3 == 1 || i3 == 2 || i3 == 14) {
                return 2;
            }
            if (player.L()) {
                return player.C() != 0 ? 10 : 6;
            }
            return 7;
        }

        private void r(int i3, AnalyticsListener.EventTime eventTime) {
            Assertions.a(eventTime.f43339a >= this.I);
            long j3 = eventTime.f43339a;
            long j4 = j3 - this.I;
            long[] jArr = this.f43464b;
            int i4 = this.H;
            jArr[i4] = jArr[i4] + j4;
            if (this.f43472j == -9223372036854775807L) {
                this.f43472j = j3;
            }
            this.f43475m |= c(i4, i3);
            this.f43473k |= e(i3);
            this.f43474l |= i3 == 11;
            if (!d(this.H) && d(i3)) {
                this.f43476n++;
            }
            if (i3 == 5) {
                this.f43478p++;
            }
            if (!f(this.H) && f(i3)) {
                this.f43479q++;
                this.O = eventTime.f43339a;
            }
            if (f(this.H) && this.H != 7 && i3 == 7) {
                this.f43477o++;
            }
            j(eventTime.f43339a);
            this.H = i3;
            this.I = eventTime.f43339a;
            if (this.f43463a) {
                this.f43465c.add(new PlaybackStats.EventTimeAndPlaybackState(eventTime, i3));
            }
        }

        public PlaybackStats a(boolean z2) {
            long[] jArr;
            List list;
            long[] jArr2 = this.f43464b;
            List list2 = this.f43466d;
            if (z2) {
                jArr = jArr2;
                list = list2;
            } else {
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                long[] jArrCopyOf = Arrays.copyOf(this.f43464b, 16);
                long jMax = Math.max(0L, jElapsedRealtime - this.I);
                int i3 = this.H;
                jArrCopyOf[i3] = jArrCopyOf[i3] + jMax;
                j(jElapsedRealtime);
                h(jElapsedRealtime);
                g(jElapsedRealtime);
                ArrayList arrayList = new ArrayList(this.f43466d);
                if (this.f43463a && this.H == 3) {
                    arrayList.add(b(jElapsedRealtime));
                }
                jArr = jArrCopyOf;
                list = arrayList;
            }
            int i4 = (this.f43475m || !this.f43473k) ? 1 : 0;
            long j3 = i4 != 0 ? -9223372036854775807L : jArr[2];
            int i5 = jArr[1] > 0 ? 1 : 0;
            List arrayList2 = z2 ? this.f43467e : new ArrayList(this.f43467e);
            List arrayList3 = z2 ? this.f43468f : new ArrayList(this.f43468f);
            List arrayList4 = z2 ? this.f43465c : new ArrayList(this.f43465c);
            long j4 = this.f43472j;
            boolean z3 = this.K;
            int i6 = !this.f43473k ? 1 : 0;
            boolean z4 = this.f43474l;
            int i7 = i4 ^ 1;
            int i8 = this.f43476n;
            int i9 = this.f43477o;
            int i10 = this.f43478p;
            int i11 = this.f43479q;
            long j5 = this.f43480r;
            boolean z5 = this.f43471i;
            long j6 = this.f43484v;
            long j7 = this.f43485w;
            long j8 = this.f43486x;
            long j9 = this.f43487y;
            long j10 = this.f43488z;
            long j11 = this.A;
            int i12 = this.f43481s;
            int i13 = i12 == -1 ? 0 : 1;
            long j12 = this.f43482t;
            int i14 = j12 == -1 ? 0 : 1;
            long j13 = this.f43483u;
            int i15 = j13 == -1 ? 0 : 1;
            long j14 = this.B;
            long j15 = this.C;
            long j16 = this.D;
            long j17 = this.E;
            int i16 = this.F;
            return new PlaybackStats(1, jArr, arrayList4, list, j4, z3 ? 1 : 0, i6, z4 ? 1 : 0, i5, j3, i7, i8, i9, i10, i11, j5, z5 ? 1 : 0, arrayList2, arrayList3, j6, j7, j8, j9, j10, j11, i13, i14, i12, j12, i15, j13, j14, j15, j16, j17, i16 > 0 ? 1 : 0, i16, this.G, this.f43469g, this.f43470h);
        }

        public void m(Player player, AnalyticsListener.EventTime eventTime, boolean z2, long j3, boolean z3, int i3, boolean z4, boolean z5, PlaybackException playbackException, Exception exc, long j4, long j5, Format format, Format format2, VideoSize videoSize) {
            if (j3 != -9223372036854775807L) {
                k(eventTime.f43339a, j3);
                this.J = true;
            }
            if (player.p() != 2) {
                this.J = false;
            }
            int iP = player.p();
            if (iP == 1 || iP == 4 || z3) {
                this.L = false;
            }
            if (playbackException != null) {
                this.M = true;
                this.F++;
                if (this.f43463a) {
                    this.f43469g.add(new PlaybackStats.EventTimeAndException(eventTime, playbackException));
                }
            } else if (player.b() == null) {
                this.M = false;
            }
            if (this.K && !this.L) {
                Tracks tracksS = player.s();
                if (!tracksS.b(2)) {
                    l(eventTime, null);
                }
                if (!tracksS.b(1)) {
                    i(eventTime, null);
                }
            }
            if (format != null) {
                l(eventTime, format);
            }
            if (format2 != null) {
                i(eventTime, format2);
            }
            Format format3 = this.P;
            if (format3 != null && format3.f40640w == -1 && videoSize != null) {
                l(eventTime, format3.b().B0(videoSize.f41258a).d0(videoSize.f41259b).N());
            }
            if (z5) {
                this.N = true;
            }
            if (z4) {
                this.E++;
            }
            this.D += (long) i3;
            this.B += j4;
            this.C += j5;
            if (exc != null) {
                this.G++;
                if (this.f43463a) {
                    this.f43470h.add(new PlaybackStats.EventTimeAndException(eventTime, exc));
                }
            }
            int iQ = q(player);
            float f3 = player.d().f40953a;
            if (this.H != iQ || this.T != f3) {
                k(eventTime.f43339a, z2 ? eventTime.f43343e : -9223372036854775807L);
                h(eventTime.f43339a);
                g(eventTime.f43339a);
            }
            this.T = f3;
            if (this.H != iQ) {
                r(iQ, eventTime);
            }
        }

        public void n(AnalyticsListener.EventTime eventTime, boolean z2, long j3) {
            int i3 = 11;
            if (this.H != 11 && !z2) {
                i3 = 15;
            }
            k(eventTime.f43339a, j3);
            h(eventTime.f43339a);
            g(eventTime.f43339a);
            r(i3, eventTime);
        }

        public void o() {
            this.K = true;
        }

        public void p() {
            this.L = true;
            this.J = false;
        }
    }

    private Pair D0(AnalyticsListener.Events events, String str) {
        MediaSource.MediaPeriodId mediaPeriodId;
        AnalyticsListener.EventTime eventTime = null;
        boolean zD = false;
        for (int i3 = 0; i3 < events.d(); i3++) {
            AnalyticsListener.EventTime eventTimeC = events.c(events.b(i3));
            boolean zD2 = this.f43446a.d(eventTimeC, str);
            if (eventTime == null || ((zD2 && !zD) || (zD2 == zD && eventTimeC.f43339a > eventTime.f43339a))) {
                eventTime = eventTimeC;
                zD = zD2;
            }
        }
        Assertions.e(eventTime);
        if (!zD && (mediaPeriodId = eventTime.f43342d) != null && mediaPeriodId.c()) {
            long jF = eventTime.f43340b.h(eventTime.f43342d.f44754a, this.f43451f).f(eventTime.f43342d.f44755b);
            if (jF == Long.MIN_VALUE) {
                jF = this.f43451f.f41117d;
            }
            long jO = jF + this.f43451f.o();
            long j3 = eventTime.f43339a;
            Timeline timeline = eventTime.f43340b;
            int i4 = eventTime.f43341c;
            MediaSource.MediaPeriodId mediaPeriodId2 = eventTime.f43342d;
            AnalyticsListener.EventTime eventTime2 = new AnalyticsListener.EventTime(j3, timeline, i4, new MediaSource.MediaPeriodId(mediaPeriodId2.f44754a, mediaPeriodId2.f44757d, mediaPeriodId2.f44755b), Util.t1(jO), eventTime.f43340b, eventTime.f43345g, eventTime.f43346h, eventTime.f43347i, eventTime.f43348j);
            zD = this.f43446a.d(eventTime2, str);
            eventTime = eventTime2;
        }
        return Pair.create(eventTime, Boolean.valueOf(zD));
    }

    private boolean E0(AnalyticsListener.Events events, String str, int i3) {
        return events.a(i3) && this.f43446a.d(events.c(i3), str);
    }

    private void F0(AnalyticsListener.Events events) {
        for (int i3 = 0; i3 < events.d(); i3++) {
            int iB = events.b(i3);
            AnalyticsListener.EventTime eventTimeC = events.c(iB);
            if (iB == 0) {
                this.f43446a.e(eventTimeC);
            } else if (iB == 11) {
                this.f43446a.h(eventTimeC, this.f43455j);
            } else {
                this.f43446a.a(eventTimeC);
            }
        }
    }

    @Override // androidx.media3.exoplayer.analytics.PlaybackSessionManager.Listener
    public void B0(AnalyticsListener.EventTime eventTime, String str) {
        ((PlaybackStatsTracker) Assertions.e((PlaybackStatsTracker) this.f43447b.get(str))).o();
    }

    @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
    public void C(AnalyticsListener.EventTime eventTime, Player.PositionInfo positionInfo, Player.PositionInfo positionInfo2, int i3) {
        if (this.f43453h == null) {
            this.f43453h = this.f43446a.b();
            this.f43454i = positionInfo.f40975g;
        }
        this.f43455j = i3;
    }

    @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
    public void M(AnalyticsListener.EventTime eventTime, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, IOException iOException, boolean z2) {
        this.f43457l = iOException;
    }

    @Override // androidx.media3.exoplayer.analytics.PlaybackSessionManager.Listener
    public void c(AnalyticsListener.EventTime eventTime, String str, String str2) {
        ((PlaybackStatsTracker) Assertions.e((PlaybackStatsTracker) this.f43447b.get(str))).p();
    }

    @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
    public void c0(AnalyticsListener.EventTime eventTime, int i3, long j3) {
        this.f43456k = i3;
    }

    @Override // androidx.media3.exoplayer.analytics.PlaybackSessionManager.Listener
    public void m0(AnalyticsListener.EventTime eventTime, String str, boolean z2) {
        PlaybackStatsTracker playbackStatsTracker = (PlaybackStatsTracker) Assertions.e((PlaybackStatsTracker) this.f43447b.remove(str));
        AnalyticsListener.EventTime eventTime2 = (AnalyticsListener.EventTime) Assertions.e((AnalyticsListener.EventTime) this.f43448c.remove(str));
        playbackStatsTracker.n(eventTime, z2, str.equals(this.f43453h) ? this.f43454i : -9223372036854775807L);
        PlaybackStats playbackStatsA = playbackStatsTracker.a(true);
        this.f43452g = PlaybackStats.a(this.f43452g, playbackStatsA);
        Callback callback = this.f43449d;
        if (callback != null) {
            callback.a(eventTime2, playbackStatsA);
        }
    }

    @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
    public void o(AnalyticsListener.EventTime eventTime, int i3, long j3, long j4) {
        this.f43458m = i3;
        this.f43459n = j3;
    }

    @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
    public void r0(AnalyticsListener.EventTime eventTime, VideoSize videoSize) {
        this.f43462q = videoSize;
    }

    @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
    public void u0(AnalyticsListener.EventTime eventTime, MediaLoadData mediaLoadData) {
        int i3 = mediaLoadData.f44741b;
        if (i3 == 2 || i3 == 0) {
            this.f43460o = mediaLoadData.f44742c;
        } else if (i3 == 1) {
            this.f43461p = mediaLoadData.f44742c;
        }
    }

    @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
    public void v0(Player player, AnalyticsListener.Events events) {
        if (events.d() == 0) {
            return;
        }
        F0(events);
        Iterator it = this.f43447b.keySet().iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            Pair pairD0 = D0(events, str);
            PlaybackStatsTracker playbackStatsTracker = (PlaybackStatsTracker) this.f43447b.get(str);
            boolean zE0 = E0(events, str, 11);
            boolean zE02 = E0(events, str, 1018);
            boolean zE03 = E0(events, str, CloseCodes.UNEXPECTED_CONDITION);
            boolean zE04 = E0(events, str, 1000);
            boolean zE05 = E0(events, str, 10);
            boolean z2 = E0(events, str, 1003) || E0(events, str, 1024);
            boolean zE06 = E0(events, str, CloseCodes.CLOSED_ABNORMALLY);
            boolean zE07 = E0(events, str, 1004);
            boolean zE08 = E0(events, str, 25);
            Iterator it2 = it;
            playbackStatsTracker.m(player, (AnalyticsListener.EventTime) pairD0.first, ((Boolean) pairD0.second).booleanValue(), str.equals(this.f43453h) ? this.f43454i : -9223372036854775807L, zE0, zE02 ? this.f43456k : 0, zE03, zE04, zE05 ? player.b() : null, z2 ? this.f43457l : null, zE06 ? this.f43458m : 0L, zE06 ? this.f43459n : 0L, zE07 ? this.f43460o : null, zE07 ? this.f43461p : null, zE08 ? this.f43462q : null);
            it = it2;
        }
        this.f43460o = null;
        this.f43461p = null;
        this.f43453h = null;
        if (events.a(1028)) {
            this.f43446a.f(events.c(1028));
        }
    }

    @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
    public void w(AnalyticsListener.EventTime eventTime, Exception exc) {
        this.f43457l = exc;
    }

    @Override // androidx.media3.exoplayer.analytics.PlaybackSessionManager.Listener
    public void y0(AnalyticsListener.EventTime eventTime, String str) {
        this.f43447b.put(str, new PlaybackStatsTracker(this.f43450e, eventTime));
        this.f43448c.put(str, eventTime);
    }
}
