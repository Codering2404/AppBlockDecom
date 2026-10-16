package androidx.media3.exoplayer;

import android.util.Pair;
import androidx.media3.common.Timeline;
import androidx.media3.common.util.Assertions;
import androidx.media3.exoplayer.source.ShuffleOrder;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractConcatenatedTimeline extends Timeline {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f42825e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final ShuffleOrder f42826f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f42827g;

    public AbstractConcatenatedTimeline(boolean z2, ShuffleOrder shuffleOrder) {
        this.f42827g = z2;
        this.f42826f = shuffleOrder;
        this.f42825e = shuffleOrder.getLength();
    }

    private int B(int i3, boolean z2) {
        if (z2) {
            return this.f42826f.c(i3);
        }
        if (i3 < this.f42825e - 1) {
            return i3 + 1;
        }
        return -1;
    }

    private int C(int i3, boolean z2) {
        if (z2) {
            return this.f42826f.b(i3);
        }
        if (i3 > 0) {
            return i3 - 1;
        }
        return -1;
    }

    public static Object v(Object obj) {
        return ((Pair) obj).second;
    }

    public static Object w(Object obj) {
        return ((Pair) obj).first;
    }

    public static Object y(Object obj, Object obj2) {
        return Pair.create(obj, obj2);
    }

    protected abstract int A(int i3);

    protected abstract Timeline D(int i3);

    @Override // androidx.media3.common.Timeline
    public int a(boolean z2) {
        if (this.f42825e == 0) {
            return -1;
        }
        if (this.f42827g) {
            z2 = false;
        }
        int iF = z2 ? this.f42826f.f() : 0;
        while (D(iF).q()) {
            iF = B(iF, z2);
            if (iF == -1) {
                return -1;
            }
        }
        return A(iF) + D(iF).a(z2);
    }

    @Override // androidx.media3.common.Timeline
    public final int b(Object obj) {
        int iB;
        if (!(obj instanceof Pair)) {
            return -1;
        }
        Object objW = w(obj);
        Object objV = v(obj);
        int iS = s(objW);
        if (iS == -1 || (iB = D(iS).b(objV)) == -1) {
            return -1;
        }
        return z(iS) + iB;
    }

    @Override // androidx.media3.common.Timeline
    public int c(boolean z2) {
        int i3 = this.f42825e;
        if (i3 == 0) {
            return -1;
        }
        if (this.f42827g) {
            z2 = false;
        }
        int iD = z2 ? this.f42826f.d() : i3 - 1;
        while (D(iD).q()) {
            iD = C(iD, z2);
            if (iD == -1) {
                return -1;
            }
        }
        return A(iD) + D(iD).c(z2);
    }

    @Override // androidx.media3.common.Timeline
    public int e(int i3, int i4, boolean z2) {
        if (this.f42827g) {
            if (i4 == 1) {
                i4 = 2;
            }
            z2 = false;
        }
        int iU = u(i3);
        int iA = A(iU);
        int iE = D(iU).e(i3 - iA, i4 != 2 ? i4 : 0, z2);
        if (iE != -1) {
            return iA + iE;
        }
        int iB = B(iU, z2);
        while (iB != -1 && D(iB).q()) {
            iB = B(iB, z2);
        }
        if (iB != -1) {
            return A(iB) + D(iB).a(z2);
        }
        if (i4 == 2) {
            return a(z2);
        }
        return -1;
    }

    @Override // androidx.media3.common.Timeline
    public final Timeline.Period g(int i3, Timeline.Period period, boolean z2) {
        int iT = t(i3);
        int iA = A(iT);
        D(iT).g(i3 - z(iT), period, z2);
        period.f41116c += iA;
        if (z2) {
            period.f41115b = y(x(iT), Assertions.e(period.f41115b));
        }
        return period;
    }

    @Override // androidx.media3.common.Timeline
    public final Timeline.Period h(Object obj, Timeline.Period period) {
        Object objW = w(obj);
        Object objV = v(obj);
        int iS = s(objW);
        int iA = A(iS);
        D(iS).h(objV, period);
        period.f41116c += iA;
        period.f41115b = obj;
        return period;
    }

    @Override // androidx.media3.common.Timeline
    public int l(int i3, int i4, boolean z2) {
        if (this.f42827g) {
            if (i4 == 1) {
                i4 = 2;
            }
            z2 = false;
        }
        int iU = u(i3);
        int iA = A(iU);
        int iL = D(iU).l(i3 - iA, i4 != 2 ? i4 : 0, z2);
        if (iL != -1) {
            return iA + iL;
        }
        int iC = C(iU, z2);
        while (iC != -1 && D(iC).q()) {
            iC = C(iC, z2);
        }
        if (iC != -1) {
            return A(iC) + D(iC).c(z2);
        }
        if (i4 == 2) {
            return c(z2);
        }
        return -1;
    }

    @Override // androidx.media3.common.Timeline
    public final Object m(int i3) {
        int iT = t(i3);
        return y(x(iT), D(iT).m(i3 - z(iT)));
    }

    @Override // androidx.media3.common.Timeline
    public final Timeline.Window o(int i3, Timeline.Window window, long j3) {
        int iU = u(i3);
        int iA = A(iU);
        int iZ = z(iU);
        D(iU).o(i3 - iA, window, j3);
        Object objX = x(iU);
        if (!Timeline.Window.f41125q.equals(window.f41135a)) {
            objX = y(objX, window.f41135a);
        }
        window.f41135a = objX;
        window.f41148n += iZ;
        window.f41149o += iZ;
        return window;
    }

    protected abstract int s(Object obj);

    protected abstract int t(int i3);

    protected abstract int u(int i3);

    protected abstract Object x(int i3);

    protected abstract int z(int i3);
}
