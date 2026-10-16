package androidx.media3.exoplayer;

import android.util.Pair;
import androidx.media3.common.Timeline;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.HandlerWrapper;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.exoplayer.MediaPeriodHolder;
import androidx.media3.exoplayer.analytics.AnalyticsCollector;
import androidx.media3.exoplayer.source.MediaPeriod;
import androidx.media3.exoplayer.source.MediaSource;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class MediaPeriodQueue {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final AnalyticsCollector f43172c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final HandlerWrapper f43173d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final MediaPeriodHolder.Factory f43174e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f43175f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f43176g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f43177h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private ExoPlayer.PreloadConfiguration f43178i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private MediaPeriodHolder f43179j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private MediaPeriodHolder f43180k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private MediaPeriodHolder f43181l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private MediaPeriodHolder f43182m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private MediaPeriodHolder f43183n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f43184o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private Object f43185p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private long f43186q;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Timeline.Period f43170a = new Timeline.Period();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Timeline.Window f43171b = new Timeline.Window();

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private List f43187r = new ArrayList();

    public MediaPeriodQueue(AnalyticsCollector analyticsCollector, HandlerWrapper handlerWrapper, MediaPeriodHolder.Factory factory, ExoPlayer.PreloadConfiguration preloadConfiguration) {
        this.f43172c = analyticsCollector;
        this.f43173d = handlerWrapper;
        this.f43174e = factory;
        this.f43178i = preloadConfiguration;
    }

    private boolean A(Object obj, Timeline timeline) {
        int iC = timeline.h(obj, this.f43170a).c();
        int iP = this.f43170a.p();
        if (iC <= 0 || !this.f43170a.s(iP)) {
            return false;
        }
        return iC > 1 || this.f43170a.f(iP) != Long.MIN_VALUE;
    }

    private boolean C(MediaSource.MediaPeriodId mediaPeriodId) {
        return !mediaPeriodId.c() && mediaPeriodId.f44758e == -1;
    }

    private boolean D(Timeline timeline, MediaSource.MediaPeriodId mediaPeriodId, boolean z2) {
        int iB = timeline.b(mediaPeriodId.f44754a);
        return !timeline.n(timeline.f(iB, this.f43170a).f41116c, this.f43171b).f41143i && timeline.r(iB, this.f43170a, this.f43171b, this.f43176g, this.f43177h) && z2;
    }

    private boolean E(Timeline timeline, MediaSource.MediaPeriodId mediaPeriodId) {
        if (C(mediaPeriodId)) {
            return timeline.n(timeline.h(mediaPeriodId.f44754a, this.f43170a).f41116c, this.f43171b).f41149o == timeline.b(mediaPeriodId.f44754a);
        }
        return false;
    }

    private static boolean H(Timeline.Period period) {
        int iC = period.c();
        if (iC != 0 && ((iC != 1 || !period.r(0)) && period.s(period.p()))) {
            long jI = 0;
            if (period.e(0L) == -1) {
                if (period.f41117d == 0) {
                    return true;
                }
                int i3 = iC - (period.r(iC + (-1)) ? 2 : 1);
                for (int i4 = 0; i4 <= i3; i4++) {
                    jI += period.i(i4);
                }
                if (period.f41117d <= jI) {
                    return true;
                }
            }
        }
        return false;
    }

    private void J() {
        final ImmutableList.Builder builderO = ImmutableList.o();
        for (MediaPeriodHolder mediaPeriodHolderK = this.f43179j; mediaPeriodHolderK != null; mediaPeriodHolderK = mediaPeriodHolderK.k()) {
            builderO.a(mediaPeriodHolderK.f43150h.f43160a);
        }
        MediaPeriodHolder mediaPeriodHolder = this.f43180k;
        final MediaSource.MediaPeriodId mediaPeriodId = mediaPeriodHolder == null ? null : mediaPeriodHolder.f43150h.f43160a;
        this.f43173d.j(new Runnable() { // from class: androidx.media3.exoplayer.a2
            @Override // java.lang.Runnable
            public final void run() {
                this.f43336a.f43172c.D(builderO.m(), mediaPeriodId);
            }
        });
    }

    private void L(List list) {
        for (int i3 = 0; i3 < this.f43187r.size(); i3++) {
            ((MediaPeriodHolder) this.f43187r.get(i3)).x();
        }
        this.f43187r = list;
        this.f43183n = null;
        I();
    }

    private MediaPeriodHolder O(MediaPeriodInfo mediaPeriodInfo) {
        for (int i3 = 0; i3 < this.f43187r.size(); i3++) {
            if (((MediaPeriodHolder) this.f43187r.get(i3)).d(mediaPeriodInfo)) {
                return (MediaPeriodHolder) this.f43187r.remove(i3);
            }
        }
        return null;
    }

    private static MediaSource.MediaPeriodId P(Timeline timeline, Object obj, long j3, long j4, Timeline.Window window, Timeline.Period period) {
        timeline.h(obj, period);
        timeline.n(period.f41116c, window);
        for (int iB = timeline.b(obj); H(period) && iB <= window.f41149o; iB++) {
            timeline.g(iB, period, true);
            obj = Assertions.e(period.f41115b);
        }
        timeline.h(obj, period);
        int iE = period.e(j3);
        return iE == -1 ? new MediaSource.MediaPeriodId(obj, j4, period.d(j3)) : new MediaSource.MediaPeriodId(obj, iE, period.l(iE), j4);
    }

    private long R(Timeline timeline, Object obj) {
        int iB;
        int i3 = timeline.h(obj, this.f43170a).f41116c;
        Object obj2 = this.f43185p;
        if (obj2 != null && (iB = timeline.b(obj2)) != -1 && timeline.f(iB, this.f43170a).f41116c == i3) {
            return this.f43186q;
        }
        for (MediaPeriodHolder mediaPeriodHolderK = this.f43179j; mediaPeriodHolderK != null; mediaPeriodHolderK = mediaPeriodHolderK.k()) {
            if (mediaPeriodHolderK.f43144b.equals(obj)) {
                return mediaPeriodHolderK.f43150h.f43160a.f44757d;
            }
        }
        for (MediaPeriodHolder mediaPeriodHolderK2 = this.f43179j; mediaPeriodHolderK2 != null; mediaPeriodHolderK2 = mediaPeriodHolderK2.k()) {
            int iB2 = timeline.b(mediaPeriodHolderK2.f43144b);
            if (iB2 != -1 && timeline.f(iB2, this.f43170a).f41116c == i3) {
                return mediaPeriodHolderK2.f43150h.f43160a.f44757d;
            }
        }
        long jS = S(obj);
        if (jS != -1) {
            return jS;
        }
        long j3 = this.f43175f;
        this.f43175f = 1 + j3;
        if (this.f43179j == null) {
            this.f43185p = obj;
            this.f43186q = j3;
        }
        return j3;
    }

    private long S(Object obj) {
        for (int i3 = 0; i3 < this.f43187r.size(); i3++) {
            MediaPeriodHolder mediaPeriodHolder = (MediaPeriodHolder) this.f43187r.get(i3);
            if (mediaPeriodHolder.f43144b.equals(obj)) {
                return mediaPeriodHolder.f43150h.f43160a.f44757d;
            }
        }
        return -1L;
    }

    private int U(Timeline timeline) {
        Timeline timeline2;
        MediaPeriodHolder mediaPeriodHolderK = this.f43179j;
        if (mediaPeriodHolderK == null) {
            return 0;
        }
        int iB = timeline.b(mediaPeriodHolderK.f43144b);
        while (true) {
            timeline2 = timeline;
            iB = timeline2.d(iB, this.f43170a, this.f43171b, this.f43176g, this.f43177h);
            while (((MediaPeriodHolder) Assertions.e(mediaPeriodHolderK)).k() != null && !mediaPeriodHolderK.f43150h.f43167h) {
                mediaPeriodHolderK = mediaPeriodHolderK.k();
            }
            MediaPeriodHolder mediaPeriodHolderK2 = mediaPeriodHolderK.k();
            if (iB == -1 || mediaPeriodHolderK2 == null || timeline2.b(mediaPeriodHolderK2.f43144b) != iB) {
                break;
            }
            mediaPeriodHolderK = mediaPeriodHolderK2;
            timeline = timeline2;
        }
        int iN = N(mediaPeriodHolderK);
        mediaPeriodHolderK.f43150h = z(timeline2, mediaPeriodHolderK.f43150h);
        return iN;
    }

    static boolean e(long j3, long j4) {
        return j3 == -9223372036854775807L || j3 == j4;
    }

    private boolean f(MediaPeriodInfo mediaPeriodInfo, MediaPeriodInfo mediaPeriodInfo2) {
        return mediaPeriodInfo.f43161b == mediaPeriodInfo2.f43161b && mediaPeriodInfo.f43160a.equals(mediaPeriodInfo2.f43160a);
    }

    private Pair i(Timeline timeline, Object obj, long j3) {
        int iE = timeline.e(timeline.h(obj, this.f43170a).f41116c, this.f43176g, this.f43177h);
        if (iE != -1) {
            return timeline.k(this.f43171b, this.f43170a, iE, -9223372036854775807L, j3);
        }
        return null;
    }

    private MediaPeriodInfo j(PlaybackInfo playbackInfo) {
        return o(playbackInfo.f43234a, playbackInfo.f43235b, playbackInfo.f43236c, playbackInfo.f43252s);
    }

    private MediaPeriodInfo k(Timeline timeline, MediaPeriodHolder mediaPeriodHolder, long j3) {
        Object obj;
        long j4;
        MediaPeriodInfo mediaPeriodInfo = mediaPeriodHolder.f43150h;
        int iD = timeline.d(timeline.b(mediaPeriodInfo.f43160a.f44754a), this.f43170a, this.f43171b, this.f43176g, this.f43177h);
        if (iD == -1) {
            return null;
        }
        int i3 = timeline.g(iD, this.f43170a, true).f41116c;
        Object objE = Assertions.e(this.f43170a.f41115b);
        long j5 = mediaPeriodInfo.f43160a.f44757d;
        long j6 = 0;
        if (timeline.n(i3, this.f43171b).f41148n == iD) {
            Pair pairK = timeline.k(this.f43171b, this.f43170a, i3, -9223372036854775807L, Math.max(0L, j3));
            if (pairK == null) {
                return null;
            }
            Object obj2 = pairK.first;
            long jLongValue = ((Long) pairK.second).longValue();
            MediaPeriodHolder mediaPeriodHolderK = mediaPeriodHolder.k();
            if (mediaPeriodHolderK == null || !mediaPeriodHolderK.f43144b.equals(obj2)) {
                long jS = S(obj2);
                if (jS == -1) {
                    jS = this.f43175f;
                    this.f43175f = 1 + jS;
                }
                j5 = jS;
            } else {
                j5 = mediaPeriodHolderK.f43150h.f43160a.f44757d;
            }
            obj = obj2;
            j4 = jLongValue;
            j6 = -9223372036854775807L;
        } else {
            obj = objE;
            j4 = 0;
        }
        MediaSource.MediaPeriodId mediaPeriodIdP = P(timeline, obj, j4, j5, this.f43171b, this.f43170a);
        if (j6 != -9223372036854775807L && mediaPeriodInfo.f43162c != -9223372036854775807L) {
            boolean zA = A(mediaPeriodInfo.f43160a.f44754a, timeline);
            if (mediaPeriodIdP.c() && zA) {
                j6 = mediaPeriodInfo.f43162c;
            } else if (zA) {
                j4 = mediaPeriodInfo.f43162c;
            }
        }
        return o(timeline, mediaPeriodIdP, j6, j4);
    }

    private MediaPeriodInfo l(Timeline timeline, MediaPeriodHolder mediaPeriodHolder, long j3) {
        MediaPeriodInfo mediaPeriodInfo = mediaPeriodHolder.f43150h;
        long jM = (mediaPeriodHolder.m() + mediaPeriodInfo.f43164e) - j3;
        return mediaPeriodInfo.f43167h ? k(timeline, mediaPeriodHolder, jM) : m(timeline, mediaPeriodHolder, jM);
    }

    private MediaPeriodInfo m(Timeline timeline, MediaPeriodHolder mediaPeriodHolder, long j3) {
        MediaPeriodInfo mediaPeriodInfo = mediaPeriodHolder.f43150h;
        MediaSource.MediaPeriodId mediaPeriodId = mediaPeriodInfo.f43160a;
        timeline.h(mediaPeriodId.f44754a, this.f43170a);
        boolean z2 = mediaPeriodInfo.f43166g;
        if (!mediaPeriodId.c()) {
            int i3 = mediaPeriodId.f44758e;
            if (i3 != -1 && this.f43170a.r(i3)) {
                return k(timeline, mediaPeriodHolder, j3);
            }
            int iL = this.f43170a.l(mediaPeriodId.f44758e);
            boolean z3 = this.f43170a.s(mediaPeriodId.f44758e) && this.f43170a.h(mediaPeriodId.f44758e, iL) == 3;
            if (iL == this.f43170a.a(mediaPeriodId.f44758e) || z3) {
                return q(timeline, mediaPeriodId.f44754a, s(timeline, mediaPeriodId.f44754a, mediaPeriodId.f44758e), mediaPeriodInfo.f43164e, mediaPeriodId.f44757d, false);
            }
            return p(timeline, mediaPeriodId.f44754a, mediaPeriodId.f44758e, iL, mediaPeriodInfo.f43164e, mediaPeriodId.f44757d, z2);
        }
        int i4 = mediaPeriodId.f44755b;
        int iA = this.f43170a.a(i4);
        if (iA == -1) {
            return null;
        }
        int iM = this.f43170a.m(i4, mediaPeriodId.f44756c);
        if (iM < iA) {
            return p(timeline, mediaPeriodId.f44754a, i4, iM, mediaPeriodInfo.f43162c, mediaPeriodId.f44757d, z2);
        }
        long jLongValue = mediaPeriodInfo.f43162c;
        if (jLongValue == -9223372036854775807L) {
            Timeline.Window window = this.f43171b;
            Timeline.Period period = this.f43170a;
            Pair pairK = timeline.k(window, period, period.f41116c, -9223372036854775807L, Math.max(0L, j3));
            if (pairK == null) {
                return null;
            }
            jLongValue = ((Long) pairK.second).longValue();
        }
        return q(timeline, mediaPeriodId.f44754a, Math.max(s(timeline, mediaPeriodId.f44754a, mediaPeriodId.f44755b), jLongValue), mediaPeriodInfo.f43162c, mediaPeriodId.f44757d, z2);
    }

    private MediaPeriodInfo o(Timeline timeline, MediaSource.MediaPeriodId mediaPeriodId, long j3, long j4) {
        timeline.h(mediaPeriodId.f44754a, this.f43170a);
        return mediaPeriodId.c() ? p(timeline, mediaPeriodId.f44754a, mediaPeriodId.f44755b, mediaPeriodId.f44756c, j3, mediaPeriodId.f44757d, false) : q(timeline, mediaPeriodId.f44754a, j4, j3, mediaPeriodId.f44757d, false);
    }

    private MediaPeriodInfo p(Timeline timeline, Object obj, int i3, int i4, long j3, long j4, boolean z2) {
        MediaSource.MediaPeriodId mediaPeriodId = new MediaSource.MediaPeriodId(obj, i3, i4, j4);
        long jB = timeline.h(mediaPeriodId.f44754a, this.f43170a).b(mediaPeriodId.f44755b, mediaPeriodId.f44756c);
        long jG = i4 == this.f43170a.l(i3) ? this.f43170a.g() : 0L;
        boolean zS = this.f43170a.s(mediaPeriodId.f44755b);
        if (jB != -9223372036854775807L && jG >= jB) {
            jG = Math.max(0L, jB - 1);
        }
        return new MediaPeriodInfo(mediaPeriodId, jG, j3, -9223372036854775807L, jB, z2, zS, false, false, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00ba  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private androidx.media3.exoplayer.MediaPeriodInfo q(androidx.media3.common.Timeline r27, java.lang.Object r28, long r29, long r31, long r33, boolean r35) {
        /*
            Method dump skipped, instruction units count: 209
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.MediaPeriodQueue.q(androidx.media3.common.Timeline, java.lang.Object, long, long, long, boolean):androidx.media3.exoplayer.MediaPeriodInfo");
    }

    private MediaPeriodInfo r(Timeline timeline, Object obj, long j3, long j4) {
        MediaSource.MediaPeriodId mediaPeriodIdP = P(timeline, obj, j3, j4, this.f43171b, this.f43170a);
        return mediaPeriodIdP.c() ? p(timeline, mediaPeriodIdP.f44754a, mediaPeriodIdP.f44755b, mediaPeriodIdP.f44756c, j3, mediaPeriodIdP.f44757d, false) : q(timeline, mediaPeriodIdP.f44754a, j3, -9223372036854775807L, mediaPeriodIdP.f44757d, false);
    }

    private long s(Timeline timeline, Object obj, int i3) {
        timeline.h(obj, this.f43170a);
        long jF = this.f43170a.f(i3);
        return jF == Long.MIN_VALUE ? this.f43170a.f41117d : jF + this.f43170a.i(i3);
    }

    public void B(Timeline timeline) {
        MediaPeriodHolder mediaPeriodHolder;
        if (this.f43178i.f42990a == -9223372036854775807L || (mediaPeriodHolder = this.f43182m) == null) {
            M();
            return;
        }
        ArrayList arrayList = new ArrayList();
        Pair pairI = i(timeline, mediaPeriodHolder.f43150h.f43160a.f44754a, 0L);
        if (pairI != null && !timeline.n(timeline.h(pairI.first, this.f43170a).f41116c, this.f43171b).f()) {
            long jS = S(pairI.first);
            if (jS == -1) {
                jS = this.f43175f;
                this.f43175f = 1 + jS;
            }
            MediaPeriodInfo mediaPeriodInfoR = r(timeline, pairI.first, ((Long) pairI.second).longValue(), jS);
            MediaPeriodHolder mediaPeriodHolderO = O(mediaPeriodInfoR);
            if (mediaPeriodHolderO == null) {
                mediaPeriodHolderO = this.f43174e.a(mediaPeriodInfoR, (mediaPeriodHolder.m() + mediaPeriodHolder.f43150h.f43164e) - mediaPeriodInfoR.f43161b);
            }
            arrayList.add(mediaPeriodHolderO);
        }
        L(arrayList);
    }

    public boolean F(MediaPeriod mediaPeriod) {
        MediaPeriodHolder mediaPeriodHolder = this.f43182m;
        return mediaPeriodHolder != null && mediaPeriodHolder.f43143a == mediaPeriod;
    }

    public boolean G(MediaPeriod mediaPeriod) {
        MediaPeriodHolder mediaPeriodHolder = this.f43183n;
        return mediaPeriodHolder != null && mediaPeriodHolder.f43143a == mediaPeriod;
    }

    public void I() {
        MediaPeriodHolder mediaPeriodHolder = this.f43183n;
        if (mediaPeriodHolder == null || mediaPeriodHolder.t()) {
            this.f43183n = null;
            for (int i3 = 0; i3 < this.f43187r.size(); i3++) {
                MediaPeriodHolder mediaPeriodHolder2 = (MediaPeriodHolder) this.f43187r.get(i3);
                if (!mediaPeriodHolder2.t()) {
                    this.f43183n = mediaPeriodHolder2;
                    return;
                }
            }
        }
    }

    public void K(long j3) {
        MediaPeriodHolder mediaPeriodHolder = this.f43182m;
        if (mediaPeriodHolder != null) {
            mediaPeriodHolder.w(j3);
        }
    }

    public void M() {
        if (this.f43187r.isEmpty()) {
            return;
        }
        L(new ArrayList());
    }

    public int N(MediaPeriodHolder mediaPeriodHolder) {
        Assertions.i(mediaPeriodHolder);
        int i3 = 0;
        if (mediaPeriodHolder.equals(this.f43182m)) {
            return 0;
        }
        this.f43182m = mediaPeriodHolder;
        while (mediaPeriodHolder.k() != null) {
            mediaPeriodHolder = (MediaPeriodHolder) Assertions.e(mediaPeriodHolder.k());
            if (mediaPeriodHolder == this.f43180k) {
                MediaPeriodHolder mediaPeriodHolder2 = this.f43179j;
                this.f43180k = mediaPeriodHolder2;
                this.f43181l = mediaPeriodHolder2;
                i3 = 3;
            }
            if (mediaPeriodHolder == this.f43181l) {
                this.f43181l = this.f43180k;
                i3 |= 2;
            }
            mediaPeriodHolder.x();
            this.f43184o--;
        }
        ((MediaPeriodHolder) Assertions.e(this.f43182m)).A(null);
        J();
        return i3;
    }

    public MediaSource.MediaPeriodId Q(Timeline timeline, Object obj, long j3) {
        long jR = R(timeline, obj);
        timeline.h(obj, this.f43170a);
        timeline.n(this.f43170a.f41116c, this.f43171b);
        boolean z2 = false;
        for (int iB = timeline.b(obj); iB >= this.f43171b.f41148n; iB--) {
            timeline.g(iB, this.f43170a, true);
            boolean z3 = this.f43170a.c() > 0;
            z2 |= z3;
            Timeline.Period period = this.f43170a;
            if (period.e(period.f41117d) != -1) {
                obj = Assertions.e(this.f43170a.f41115b);
            }
            if (z2 && (!z3 || this.f43170a.f41117d != 0)) {
                break;
            }
        }
        return P(timeline, obj, j3, jR, this.f43171b, this.f43170a);
    }

    public boolean T() {
        MediaPeriodHolder mediaPeriodHolder = this.f43182m;
        if (mediaPeriodHolder != null) {
            return !mediaPeriodHolder.f43150h.f43169j && mediaPeriodHolder.s() && this.f43182m.f43150h.f43164e != -9223372036854775807L && this.f43184o < 100;
        }
        return true;
    }

    public void V(Timeline timeline, ExoPlayer.PreloadConfiguration preloadConfiguration) {
        this.f43178i = preloadConfiguration;
        B(timeline);
    }

    /* JADX WARN: Code restructure failed: missing block: B:46:0x0086, code lost:
    
        return N(r1);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int W(androidx.media3.common.Timeline r9, long r10, long r12, long r14) {
        /*
            r8 = this;
            androidx.media3.exoplayer.MediaPeriodHolder r0 = r8.f43179j
            r1 = 0
        L3:
            r2 = 0
            if (r0 == 0) goto L87
            androidx.media3.exoplayer.MediaPeriodInfo r3 = r0.f43150h
            if (r1 != 0) goto Lf
            androidx.media3.exoplayer.MediaPeriodInfo r1 = r8.z(r9, r3)
            goto L1e
        Lf:
            androidx.media3.exoplayer.MediaPeriodInfo r4 = r8.l(r9, r1, r10)
            if (r4 == 0) goto L82
            boolean r5 = r8.f(r3, r4)
            if (r5 != 0) goto L1d
            goto L82
        L1d:
            r1 = r4
        L1e:
            long r4 = r3.f43162c
            androidx.media3.exoplayer.MediaPeriodInfo r4 = r1.a(r4)
            r0.f43150h = r4
            long r3 = r3.f43164e
            long r5 = r1.f43164e
            boolean r3 = e(r3, r5)
            if (r3 != 0) goto L7a
            r0.E()
            long r9 = r1.f43164e
            r3 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r11 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
            if (r11 != 0) goto L44
            r9 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            goto L48
        L44:
            long r9 = r0.D(r9)
        L48:
            androidx.media3.exoplayer.MediaPeriodHolder r11 = r8.f43180k
            r1 = 1
            r3 = -9223372036854775808
            if (r0 != r11) goto L5f
            androidx.media3.exoplayer.MediaPeriodInfo r11 = r0.f43150h
            boolean r11 = r11.f43166g
            if (r11 != 0) goto L5f
            int r11 = (r12 > r3 ? 1 : (r12 == r3 ? 0 : -1))
            if (r11 == 0) goto L5d
            int r11 = (r12 > r9 ? 1 : (r12 == r9 ? 0 : -1))
            if (r11 < 0) goto L5f
        L5d:
            r11 = r1
            goto L60
        L5f:
            r11 = r2
        L60:
            androidx.media3.exoplayer.MediaPeriodHolder r12 = r8.f43181l
            if (r0 != r12) goto L6d
            int r12 = (r14 > r3 ? 1 : (r14 == r3 ? 0 : -1))
            if (r12 == 0) goto L6c
            int r9 = (r14 > r9 ? 1 : (r14 == r9 ? 0 : -1))
            if (r9 < 0) goto L6d
        L6c:
            r2 = r1
        L6d:
            int r9 = r8.N(r0)
            if (r9 == 0) goto L74
            return r9
        L74:
            if (r2 == 0) goto L79
            r9 = r11 | 2
            return r9
        L79:
            return r11
        L7a:
            androidx.media3.exoplayer.MediaPeriodHolder r1 = r0.k()
            r7 = r1
            r1 = r0
            r0 = r7
            goto L3
        L82:
            int r9 = r8.N(r1)
            return r9
        L87:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.MediaPeriodQueue.W(androidx.media3.common.Timeline, long, long, long):int");
    }

    public int X(Timeline timeline, int i3) {
        this.f43176g = i3;
        return U(timeline);
    }

    public int Y(Timeline timeline, boolean z2) {
        this.f43177h = z2;
        return U(timeline);
    }

    public MediaPeriodHolder b() {
        MediaPeriodHolder mediaPeriodHolder = this.f43179j;
        if (mediaPeriodHolder == null) {
            return null;
        }
        if (mediaPeriodHolder == this.f43180k) {
            this.f43180k = mediaPeriodHolder.k();
        }
        MediaPeriodHolder mediaPeriodHolder2 = this.f43179j;
        if (mediaPeriodHolder2 == this.f43181l) {
            this.f43181l = mediaPeriodHolder2.k();
        }
        this.f43179j.x();
        int i3 = this.f43184o - 1;
        this.f43184o = i3;
        if (i3 == 0) {
            this.f43182m = null;
            MediaPeriodHolder mediaPeriodHolder3 = this.f43179j;
            this.f43185p = mediaPeriodHolder3.f43144b;
            this.f43186q = mediaPeriodHolder3.f43150h.f43160a.f44757d;
        }
        this.f43179j = this.f43179j.k();
        J();
        return this.f43179j;
    }

    public MediaPeriodHolder c() {
        this.f43181l = ((MediaPeriodHolder) Assertions.i(this.f43181l)).k();
        J();
        return (MediaPeriodHolder) Assertions.i(this.f43181l);
    }

    public MediaPeriodHolder d() {
        MediaPeriodHolder mediaPeriodHolder = this.f43181l;
        MediaPeriodHolder mediaPeriodHolder2 = this.f43180k;
        if (mediaPeriodHolder == mediaPeriodHolder2) {
            this.f43181l = ((MediaPeriodHolder) Assertions.i(mediaPeriodHolder2)).k();
        }
        this.f43180k = ((MediaPeriodHolder) Assertions.i(this.f43180k)).k();
        J();
        return (MediaPeriodHolder) Assertions.i(this.f43180k);
    }

    public void g() {
        if (this.f43184o == 0) {
            return;
        }
        MediaPeriodHolder mediaPeriodHolderK = (MediaPeriodHolder) Assertions.i(this.f43179j);
        this.f43185p = mediaPeriodHolderK.f43144b;
        this.f43186q = mediaPeriodHolderK.f43150h.f43160a.f44757d;
        while (mediaPeriodHolderK != null) {
            mediaPeriodHolderK.x();
            mediaPeriodHolderK = mediaPeriodHolderK.k();
        }
        this.f43179j = null;
        this.f43182m = null;
        this.f43180k = null;
        this.f43181l = null;
        this.f43184o = 0;
        J();
    }

    public MediaPeriodHolder h(MediaPeriodInfo mediaPeriodInfo) {
        MediaPeriodHolder mediaPeriodHolder = this.f43182m;
        long jM = mediaPeriodHolder == null ? 1000000000000L : (mediaPeriodHolder.m() + this.f43182m.f43150h.f43164e) - mediaPeriodInfo.f43161b;
        MediaPeriodHolder mediaPeriodHolderO = O(mediaPeriodInfo);
        if (mediaPeriodHolderO == null) {
            mediaPeriodHolderO = this.f43174e.a(mediaPeriodInfo, jM);
        } else {
            mediaPeriodHolderO.f43150h = mediaPeriodInfo;
            mediaPeriodHolderO.B(jM);
        }
        MediaPeriodHolder mediaPeriodHolder2 = this.f43182m;
        if (mediaPeriodHolder2 != null) {
            mediaPeriodHolder2.A(mediaPeriodHolderO);
        } else {
            this.f43179j = mediaPeriodHolderO;
            this.f43180k = mediaPeriodHolderO;
            this.f43181l = mediaPeriodHolderO;
        }
        this.f43185p = null;
        this.f43182m = mediaPeriodHolderO;
        this.f43184o++;
        J();
        return mediaPeriodHolderO;
    }

    public MediaPeriodHolder n() {
        return this.f43182m;
    }

    public MediaPeriodInfo t(long j3, PlaybackInfo playbackInfo) {
        MediaPeriodHolder mediaPeriodHolder = this.f43182m;
        return mediaPeriodHolder == null ? j(playbackInfo) : l(playbackInfo.f43234a, mediaPeriodHolder, j3);
    }

    public MediaPeriodHolder u() {
        return this.f43179j;
    }

    public MediaPeriodHolder v(MediaPeriod mediaPeriod) {
        for (int i3 = 0; i3 < this.f43187r.size(); i3++) {
            MediaPeriodHolder mediaPeriodHolder = (MediaPeriodHolder) this.f43187r.get(i3);
            if (mediaPeriodHolder.f43143a == mediaPeriod) {
                return mediaPeriodHolder;
            }
        }
        return null;
    }

    public MediaPeriodHolder w() {
        return this.f43183n;
    }

    public MediaPeriodHolder x() {
        return this.f43181l;
    }

    public MediaPeriodHolder y() {
        return this.f43180k;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x006c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public androidx.media3.exoplayer.MediaPeriodInfo z(androidx.media3.common.Timeline r18, androidx.media3.exoplayer.MediaPeriodInfo r19) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            r2 = r19
            androidx.media3.exoplayer.source.MediaSource$MediaPeriodId r3 = r2.f43160a
            boolean r13 = r0.C(r3)
            boolean r14 = r0.E(r1, r3)
            boolean r15 = r0.D(r1, r3, r13)
            androidx.media3.exoplayer.source.MediaSource$MediaPeriodId r4 = r2.f43160a
            java.lang.Object r4 = r4.f44754a
            androidx.media3.common.Timeline$Period r5 = r0.f43170a
            r1.h(r4, r5)
            boolean r1 = r3.c()
            r4 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r6 = -1
            if (r1 != 0) goto L35
            int r1 = r3.f44758e
            if (r1 != r6) goto L2e
            goto L35
        L2e:
            androidx.media3.common.Timeline$Period r7 = r0.f43170a
            long r7 = r7.f(r1)
            goto L36
        L35:
            r7 = r4
        L36:
            boolean r1 = r3.c()
            if (r1 == 0) goto L48
            androidx.media3.common.Timeline$Period r1 = r0.f43170a
            int r4 = r3.f44755b
            int r5 = r3.f44756c
            long r4 = r1.b(r4, r5)
        L46:
            r9 = r4
            goto L5c
        L48:
            int r1 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r1 == 0) goto L55
            r4 = -9223372036854775808
            int r1 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r1 != 0) goto L53
            goto L55
        L53:
            r9 = r7
            goto L5c
        L55:
            androidx.media3.common.Timeline$Period r1 = r0.f43170a
            long r4 = r1.k()
            goto L46
        L5c:
            boolean r1 = r3.c()
            if (r1 == 0) goto L6c
            androidx.media3.common.Timeline$Period r1 = r0.f43170a
            int r4 = r3.f44755b
            boolean r1 = r1.s(r4)
        L6a:
            r12 = r1
            goto L7c
        L6c:
            int r1 = r3.f44758e
            if (r1 == r6) goto L7a
            androidx.media3.common.Timeline$Period r4 = r0.f43170a
            boolean r1 = r4.s(r1)
            if (r1 == 0) goto L7a
            r1 = 1
            goto L6a
        L7a:
            r1 = 0
            goto L6a
        L7c:
            androidx.media3.exoplayer.MediaPeriodInfo r1 = new androidx.media3.exoplayer.MediaPeriodInfo
            r5 = r3
            long r3 = r2.f43161b
            r11 = r5
            long r5 = r2.f43162c
            boolean r2 = r2.f43165f
            r16 = r11
            r11 = r2
            r2 = r16
            r1.<init>(r2, r3, r5, r7, r9, r11, r12, r13, r14, r15)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.MediaPeriodQueue.z(androidx.media3.common.Timeline, androidx.media3.exoplayer.MediaPeriodInfo):androidx.media3.exoplayer.MediaPeriodInfo");
    }
}
