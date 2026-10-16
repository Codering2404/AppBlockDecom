package androidx.media3.common;

import android.net.Uri;
import android.util.Pair;
import androidx.media3.common.AdPlaybackState;
import androidx.media3.common.MediaItem;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import com.google.common.collect.ImmutableList;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class Timeline {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Timeline f41105a = new Timeline() { // from class: androidx.media3.common.Timeline.1
        @Override // androidx.media3.common.Timeline
        public int b(Object obj) {
            return -1;
        }

        @Override // androidx.media3.common.Timeline
        public Period g(int i3, Period period, boolean z2) {
            throw new IndexOutOfBoundsException();
        }

        @Override // androidx.media3.common.Timeline
        public int i() {
            return 0;
        }

        @Override // androidx.media3.common.Timeline
        public Object m(int i3) {
            throw new IndexOutOfBoundsException();
        }

        @Override // androidx.media3.common.Timeline
        public Window o(int i3, Window window, long j3) {
            throw new IndexOutOfBoundsException();
        }

        @Override // androidx.media3.common.Timeline
        public int p() {
            return 0;
        }
    };

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f41106b = Util.y0(0);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f41107c = Util.y0(1);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f41108d = Util.y0(2);

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Period {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private static final String f41109h = Util.y0(0);

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private static final String f41110i = Util.y0(1);

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private static final String f41111j = Util.y0(2);

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private static final String f41112k = Util.y0(3);

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private static final String f41113l = Util.y0(4);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f41114a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Object f41115b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f41116c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f41117d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f41118e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f41119f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public AdPlaybackState f41120g = AdPlaybackState.f40484g;

        public int a(int i3) {
            return this.f41120g.b(i3).f40508b;
        }

        public long b(int i3, int i4) {
            AdPlaybackState.AdGroup adGroupB = this.f41120g.b(i3);
            if (adGroupB.f40508b != -1) {
                return adGroupB.f40513g[i4];
            }
            return -9223372036854775807L;
        }

        public int c() {
            return this.f41120g.f40491b;
        }

        public int d(long j3) {
            return this.f41120g.c(j3, this.f41117d);
        }

        public int e(long j3) {
            return this.f41120g.d(j3, this.f41117d);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && Period.class.equals(obj.getClass())) {
                Period period = (Period) obj;
                if (Objects.equals(this.f41114a, period.f41114a) && Objects.equals(this.f41115b, period.f41115b) && this.f41116c == period.f41116c && this.f41117d == period.f41117d && this.f41118e == period.f41118e && this.f41119f == period.f41119f && Objects.equals(this.f41120g, period.f41120g)) {
                    return true;
                }
            }
            return false;
        }

        public long f(int i3) {
            return this.f41120g.b(i3).f40507a;
        }

        public long g() {
            return this.f41120g.f40492c;
        }

        public int h(int i3, int i4) {
            AdPlaybackState.AdGroup adGroupB = this.f41120g.b(i3);
            if (adGroupB.f40508b != -1) {
                return adGroupB.f40512f[i4];
            }
            return 0;
        }

        public int hashCode() {
            Object obj = this.f41114a;
            int iHashCode = (217 + (obj == null ? 0 : obj.hashCode())) * 31;
            Object obj2 = this.f41115b;
            int iHashCode2 = (((iHashCode + (obj2 != null ? obj2.hashCode() : 0)) * 31) + this.f41116c) * 31;
            long j3 = this.f41117d;
            int i3 = (iHashCode2 + ((int) (j3 ^ (j3 >>> 32)))) * 31;
            long j4 = this.f41118e;
            return ((((i3 + ((int) (j4 ^ (j4 >>> 32)))) * 31) + (this.f41119f ? 1 : 0)) * 31) + this.f41120g.hashCode();
        }

        public long i(int i3) {
            return this.f41120g.b(i3).f40515i;
        }

        public long j() {
            return Util.t1(this.f41117d);
        }

        public long k() {
            return this.f41117d;
        }

        public int l(int i3) {
            return this.f41120g.b(i3).c();
        }

        public int m(int i3, int i4) {
            return this.f41120g.b(i3).d(i4);
        }

        public long n() {
            return Util.t1(this.f41118e);
        }

        public long o() {
            return this.f41118e;
        }

        public int p() {
            return this.f41120g.f40494e;
        }

        public boolean q(int i3) {
            return !this.f41120g.b(i3).e();
        }

        public boolean r(int i3) {
            return i3 == c() - 1 && this.f41120g.e(i3);
        }

        public boolean s(int i3) {
            return this.f41120g.b(i3).f40516j;
        }

        public Period t(Object obj, Object obj2, int i3, long j3, long j4) {
            return u(obj, obj2, i3, j3, j4, AdPlaybackState.f40484g, false);
        }

        public Period u(Object obj, Object obj2, int i3, long j3, long j4, AdPlaybackState adPlaybackState, boolean z2) {
            this.f41114a = obj;
            this.f41115b = obj2;
            this.f41116c = i3;
            this.f41117d = j3;
            this.f41118e = j4;
            this.f41120g = adPlaybackState;
            this.f41119f = z2;
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class RemotableTimeline extends Timeline {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final ImmutableList f41121e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final ImmutableList f41122f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final int[] f41123g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final int[] f41124h;

        @Override // androidx.media3.common.Timeline
        public int a(boolean z2) {
            if (q()) {
                return -1;
            }
            if (z2) {
                return this.f41123g[0];
            }
            return 0;
        }

        @Override // androidx.media3.common.Timeline
        public int b(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // androidx.media3.common.Timeline
        public int c(boolean z2) {
            if (q()) {
                return -1;
            }
            return z2 ? this.f41123g[p() - 1] : p() - 1;
        }

        @Override // androidx.media3.common.Timeline
        public int e(int i3, int i4, boolean z2) {
            if (i4 == 1) {
                return i3;
            }
            if (i3 != c(z2)) {
                return z2 ? this.f41123g[this.f41124h[i3] + 1] : i3 + 1;
            }
            if (i4 == 2) {
                return a(z2);
            }
            return -1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.media3.common.Timeline
        public Period g(int i3, Period period, boolean z2) {
            Period period2 = (Period) this.f41122f.get(i3);
            period.u(period2.f41114a, period2.f41115b, period2.f41116c, period2.f41117d, period2.f41118e, period2.f41120g, period2.f41119f);
            return period;
        }

        @Override // androidx.media3.common.Timeline
        public int i() {
            return this.f41122f.size();
        }

        @Override // androidx.media3.common.Timeline
        public int l(int i3, int i4, boolean z2) {
            if (i4 == 1) {
                return i3;
            }
            if (i3 != a(z2)) {
                return z2 ? this.f41123g[this.f41124h[i3] - 1] : i3 - 1;
            }
            if (i4 == 2) {
                return c(z2);
            }
            return -1;
        }

        @Override // androidx.media3.common.Timeline
        public Object m(int i3) {
            throw new UnsupportedOperationException();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.media3.common.Timeline
        public Window o(int i3, Window window, long j3) {
            Window window2 = (Window) this.f41121e.get(i3);
            window.g(window2.f41135a, window2.f41137c, window2.f41138d, window2.f41139e, window2.f41140f, window2.f41141g, window2.f41142h, window2.f41143i, window2.f41144j, window2.f41146l, window2.f41147m, window2.f41148n, window2.f41149o, window2.f41150p);
            window.f41145k = window2.f41145k;
            return window;
        }

        @Override // androidx.media3.common.Timeline
        public int p() {
            return this.f41121e.size();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Window {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Object f41136b;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Object f41138d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f41139e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public long f41140f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public long f41141g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f41142h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f41143i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public MediaItem.LiveConfiguration f41144j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public boolean f41145k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public long f41146l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public long f41147m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public int f41148n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public int f41149o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public long f41150p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public static final Object f41125q = new Object();

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        private static final Object f41126r = new Object();

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        private static final MediaItem f41127s = new MediaItem.Builder().f("androidx.media3.common.Timeline").k(Uri.EMPTY).a();

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        private static final String f41128t = Util.y0(1);

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        private static final String f41129u = Util.y0(2);

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        private static final String f41130v = Util.y0(3);

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        private static final String f41131w = Util.y0(4);

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        private static final String f41132x = Util.y0(5);

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        private static final String f41133y = Util.y0(6);

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        private static final String f41134z = Util.y0(7);
        private static final String A = Util.y0(8);
        private static final String B = Util.y0(9);
        private static final String C = Util.y0(10);
        private static final String D = Util.y0(11);
        private static final String E = Util.y0(12);
        private static final String F = Util.y0(13);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f41135a = f41125q;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public MediaItem f41137c = f41127s;

        public long a() {
            return Util.g0(this.f41141g);
        }

        public long b() {
            return Util.t1(this.f41146l);
        }

        public long c() {
            return this.f41146l;
        }

        public long d() {
            return Util.t1(this.f41147m);
        }

        public long e() {
            return this.f41150p;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && Window.class.equals(obj.getClass())) {
                Window window = (Window) obj;
                if (Objects.equals(this.f41135a, window.f41135a) && Objects.equals(this.f41137c, window.f41137c) && Objects.equals(this.f41138d, window.f41138d) && Objects.equals(this.f41144j, window.f41144j) && this.f41139e == window.f41139e && this.f41140f == window.f41140f && this.f41141g == window.f41141g && this.f41142h == window.f41142h && this.f41143i == window.f41143i && this.f41145k == window.f41145k && this.f41146l == window.f41146l && this.f41147m == window.f41147m && this.f41148n == window.f41148n && this.f41149o == window.f41149o && this.f41150p == window.f41150p) {
                    return true;
                }
            }
            return false;
        }

        public boolean f() {
            return this.f41144j != null;
        }

        public Window g(Object obj, MediaItem mediaItem, Object obj2, long j3, long j4, long j5, boolean z2, boolean z3, MediaItem.LiveConfiguration liveConfiguration, long j6, long j7, int i3, int i4, long j8) {
            MediaItem.LocalConfiguration localConfiguration;
            this.f41135a = obj;
            this.f41137c = mediaItem != null ? mediaItem : f41127s;
            this.f41136b = (mediaItem == null || (localConfiguration = mediaItem.f40714b) == null) ? null : localConfiguration.f40818i;
            this.f41138d = obj2;
            this.f41139e = j3;
            this.f41140f = j4;
            this.f41141g = j5;
            this.f41142h = z2;
            this.f41143i = z3;
            this.f41144j = liveConfiguration;
            this.f41146l = j6;
            this.f41147m = j7;
            this.f41148n = i3;
            this.f41149o = i4;
            this.f41150p = j8;
            this.f41145k = false;
            return this;
        }

        public int hashCode() {
            int iHashCode = (((217 + this.f41135a.hashCode()) * 31) + this.f41137c.hashCode()) * 31;
            Object obj = this.f41138d;
            int iHashCode2 = (iHashCode + (obj == null ? 0 : obj.hashCode())) * 31;
            MediaItem.LiveConfiguration liveConfiguration = this.f41144j;
            int iHashCode3 = (iHashCode2 + (liveConfiguration != null ? liveConfiguration.hashCode() : 0)) * 31;
            long j3 = this.f41139e;
            int i3 = (iHashCode3 + ((int) (j3 ^ (j3 >>> 32)))) * 31;
            long j4 = this.f41140f;
            int i4 = (i3 + ((int) (j4 ^ (j4 >>> 32)))) * 31;
            long j5 = this.f41141g;
            int i5 = (((((((i4 + ((int) (j5 ^ (j5 >>> 32)))) * 31) + (this.f41142h ? 1 : 0)) * 31) + (this.f41143i ? 1 : 0)) * 31) + (this.f41145k ? 1 : 0)) * 31;
            long j6 = this.f41146l;
            int i6 = (i5 + ((int) (j6 ^ (j6 >>> 32)))) * 31;
            long j7 = this.f41147m;
            int i7 = (((((i6 + ((int) (j7 ^ (j7 >>> 32)))) * 31) + this.f41148n) * 31) + this.f41149o) * 31;
            long j8 = this.f41150p;
            return i7 + ((int) (j8 ^ (j8 >>> 32)));
        }
    }

    protected Timeline() {
    }

    public int a(boolean z2) {
        return q() ? -1 : 0;
    }

    public abstract int b(Object obj);

    public int c(boolean z2) {
        if (q()) {
            return -1;
        }
        return p() - 1;
    }

    public final int d(int i3, Period period, Window window, int i4, boolean z2) {
        int i5 = f(i3, period).f41116c;
        if (n(i5, window).f41149o != i3) {
            return i3 + 1;
        }
        int iE = e(i5, i4, z2);
        if (iE == -1) {
            return -1;
        }
        return n(iE, window).f41148n;
    }

    public int e(int i3, int i4, boolean z2) {
        if (i4 == 0) {
            if (i3 == c(z2)) {
                return -1;
            }
            return i3 + 1;
        }
        if (i4 == 1) {
            return i3;
        }
        if (i4 == 2) {
            return i3 == c(z2) ? a(z2) : i3 + 1;
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object obj) {
        int iC;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Timeline)) {
            return false;
        }
        Timeline timeline = (Timeline) obj;
        if (timeline.p() != p() || timeline.i() != i()) {
            return false;
        }
        Window window = new Window();
        Period period = new Period();
        Window window2 = new Window();
        Period period2 = new Period();
        for (int i3 = 0; i3 < p(); i3++) {
            if (!n(i3, window).equals(timeline.n(i3, window2))) {
                return false;
            }
        }
        for (int i4 = 0; i4 < i(); i4++) {
            if (!g(i4, period, true).equals(timeline.g(i4, period2, true))) {
                return false;
            }
        }
        int iA = a(true);
        if (iA != timeline.a(true) || (iC = c(true)) != timeline.c(true)) {
            return false;
        }
        while (iA != iC) {
            int iE = e(iA, 0, true);
            if (iE != timeline.e(iA, 0, true)) {
                return false;
            }
            iA = iE;
        }
        return true;
    }

    public final Period f(int i3, Period period) {
        return g(i3, period, false);
    }

    public abstract Period g(int i3, Period period, boolean z2);

    public Period h(Object obj, Period period) {
        return g(b(obj), period, true);
    }

    public int hashCode() {
        Window window = new Window();
        Period period = new Period();
        int iP = 217 + p();
        for (int i3 = 0; i3 < p(); i3++) {
            iP = (iP * 31) + n(i3, window).hashCode();
        }
        int i4 = (iP * 31) + i();
        for (int i5 = 0; i5 < i(); i5++) {
            i4 = (i4 * 31) + g(i5, period, true).hashCode();
        }
        int iA = a(true);
        while (iA != -1) {
            i4 = (i4 * 31) + iA;
            iA = e(iA, 0, true);
        }
        return i4;
    }

    public abstract int i();

    public final Pair j(Window window, Period period, int i3, long j3) {
        return (Pair) Assertions.e(k(window, period, i3, j3, 0L));
    }

    public final Pair k(Window window, Period period, int i3, long j3, long j4) {
        Assertions.c(i3, 0, p());
        o(i3, window, j4);
        if (j3 == -9223372036854775807L) {
            j3 = window.c();
            if (j3 == -9223372036854775807L) {
                return null;
            }
        }
        int i4 = window.f41148n;
        f(i4, period);
        while (i4 < window.f41149o && period.f41118e != j3) {
            int i5 = i4 + 1;
            if (f(i5, period).f41118e > j3) {
                break;
            }
            i4 = i5;
        }
        g(i4, period, true);
        long jMin = j3 - period.f41118e;
        long j5 = period.f41117d;
        if (j5 != -9223372036854775807L) {
            jMin = Math.min(jMin, j5 - 1);
        }
        return Pair.create(Assertions.e(period.f41115b), Long.valueOf(Math.max(0L, jMin)));
    }

    public int l(int i3, int i4, boolean z2) {
        if (i4 == 0) {
            if (i3 == a(z2)) {
                return -1;
            }
            return i3 - 1;
        }
        if (i4 == 1) {
            return i3;
        }
        if (i4 == 2) {
            return i3 == a(z2) ? c(z2) : i3 - 1;
        }
        throw new IllegalStateException();
    }

    public abstract Object m(int i3);

    public final Window n(int i3, Window window) {
        return o(i3, window, 0L);
    }

    public abstract Window o(int i3, Window window, long j3);

    public abstract int p();

    public final boolean q() {
        return p() == 0;
    }

    public final boolean r(int i3, Period period, Window window, int i4, boolean z2) {
        return d(i3, period, window, i4, z2) == -1;
    }
}
