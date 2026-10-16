package androidx.recyclerview.widget;

import android.util.Log;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import androidx.recyclerview.widget.ThreadUtil;
import androidx.recyclerview.widget.TileList;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class AsyncListUtil<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Class f51497a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final int f51498b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final DataCallback f51499c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final ViewCallback f51500d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final TileList f51501e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final ThreadUtil.MainThreadCallback f51502f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final ThreadUtil.BackgroundCallback f51503g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final int[] f51504h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final int[] f51505i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    final int[] f51506j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    boolean f51507k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f51508l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    int f51509m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    int f51510n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    int f51511o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    final SparseIntArray f51512p;

    /* JADX INFO: renamed from: androidx.recyclerview.widget.AsyncListUtil$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass1 implements ThreadUtil.MainThreadCallback<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AsyncListUtil f51513a;

        private boolean d(int i3) {
            return i3 == this.f51513a.f51511o;
        }

        private void e() {
            for (int i3 = 0; i3 < this.f51513a.f51501e.e(); i3++) {
                AsyncListUtil asyncListUtil = this.f51513a;
                asyncListUtil.f51503g.d(asyncListUtil.f51501e.c(i3));
            }
            this.f51513a.f51501e.b();
        }

        @Override // androidx.recyclerview.widget.ThreadUtil.MainThreadCallback
        public void a(int i3, int i4) {
            if (d(i3)) {
                TileList.Tile tileD = this.f51513a.f51501e.d(i4);
                if (tileD != null) {
                    this.f51513a.f51503g.d(tileD);
                    return;
                }
                Log.e("AsyncListUtil", "tile not found @" + i4);
            }
        }

        @Override // androidx.recyclerview.widget.ThreadUtil.MainThreadCallback
        public void b(int i3, TileList.Tile tile) {
            if (!d(i3)) {
                this.f51513a.f51503g.d(tile);
                return;
            }
            TileList.Tile tileA = this.f51513a.f51501e.a(tile);
            if (tileA != null) {
                Log.e("AsyncListUtil", "duplicate tile @" + tileA.f52060b);
                this.f51513a.f51503g.d(tileA);
            }
            int i4 = tile.f52060b + tile.f52061c;
            int i5 = 0;
            while (i5 < this.f51513a.f51512p.size()) {
                int iKeyAt = this.f51513a.f51512p.keyAt(i5);
                if (tile.f52060b > iKeyAt || iKeyAt >= i4) {
                    i5++;
                } else {
                    this.f51513a.f51512p.removeAt(i5);
                    this.f51513a.f51500d.d(iKeyAt);
                }
            }
        }

        @Override // androidx.recyclerview.widget.ThreadUtil.MainThreadCallback
        public void c(int i3, int i4) {
            if (d(i3)) {
                AsyncListUtil asyncListUtil = this.f51513a;
                asyncListUtil.f51509m = i4;
                asyncListUtil.f51500d.c();
                AsyncListUtil asyncListUtil2 = this.f51513a;
                asyncListUtil2.f51510n = asyncListUtil2.f51511o;
                e();
                AsyncListUtil asyncListUtil3 = this.f51513a;
                asyncListUtil3.f51507k = false;
                asyncListUtil3.a();
            }
        }
    }

    /* JADX INFO: renamed from: androidx.recyclerview.widget.AsyncListUtil$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass2 implements ThreadUtil.BackgroundCallback<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private TileList.Tile f51514a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final SparseBooleanArray f51515b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f51516c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f51517d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f51518e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f51519f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ AsyncListUtil f51520g;

        private TileList.Tile e() {
            TileList.Tile tile = this.f51514a;
            if (tile != null) {
                this.f51514a = tile.f52062d;
                return tile;
            }
            AsyncListUtil asyncListUtil = this.f51520g;
            return new TileList.Tile(asyncListUtil.f51497a, asyncListUtil.f51498b);
        }

        private void f(TileList.Tile tile) {
            this.f51515b.put(tile.f52060b, true);
            this.f51520g.f51502f.b(this.f51516c, tile);
        }

        private void g(int i3) {
            int iB = this.f51520g.f51499c.b();
            while (this.f51515b.size() >= iB) {
                int iKeyAt = this.f51515b.keyAt(0);
                SparseBooleanArray sparseBooleanArray = this.f51515b;
                int iKeyAt2 = sparseBooleanArray.keyAt(sparseBooleanArray.size() - 1);
                int i4 = this.f51518e - iKeyAt;
                int i5 = iKeyAt2 - this.f51519f;
                if (i4 > 0 && (i4 >= i5 || i3 == 2)) {
                    j(iKeyAt);
                } else {
                    if (i5 <= 0) {
                        return;
                    }
                    if (i4 >= i5 && i3 != 1) {
                        return;
                    } else {
                        j(iKeyAt2);
                    }
                }
            }
        }

        private int h(int i3) {
            return i3 - (i3 % this.f51520g.f51498b);
        }

        private boolean i(int i3) {
            return this.f51515b.get(i3);
        }

        private void j(int i3) {
            this.f51515b.delete(i3);
            this.f51520g.f51502f.a(this.f51516c, i3);
        }

        private void k(int i3, int i4, int i5, boolean z2) {
            int i6 = i3;
            while (i6 <= i4) {
                this.f51520g.f51503g.b(z2 ? (i4 + i3) - i6 : i6, i5);
                i6 += this.f51520g.f51498b;
            }
        }

        @Override // androidx.recyclerview.widget.ThreadUtil.BackgroundCallback
        public void a(int i3, int i4, int i5, int i6, int i7) {
            if (i3 > i4) {
                return;
            }
            int iH = h(i3);
            int iH2 = h(i4);
            this.f51518e = h(i5);
            int iH3 = h(i6);
            this.f51519f = iH3;
            if (i7 == 1) {
                k(this.f51518e, iH2, i7, true);
                k(iH2 + this.f51520g.f51498b, this.f51519f, i7, false);
            } else {
                k(iH, iH3, i7, false);
                k(this.f51518e, iH - this.f51520g.f51498b, i7, true);
            }
        }

        @Override // androidx.recyclerview.widget.ThreadUtil.BackgroundCallback
        public void b(int i3, int i4) {
            if (i(i3)) {
                return;
            }
            TileList.Tile tileE = e();
            tileE.f52060b = i3;
            int iMin = Math.min(this.f51520g.f51498b, this.f51517d - i3);
            tileE.f52061c = iMin;
            this.f51520g.f51499c.a(tileE.f52059a, tileE.f52060b, iMin);
            g(i4);
            f(tileE);
        }

        @Override // androidx.recyclerview.widget.ThreadUtil.BackgroundCallback
        public void c(int i3) {
            this.f51516c = i3;
            this.f51515b.clear();
            int iD = this.f51520g.f51499c.d();
            this.f51517d = iD;
            this.f51520g.f51502f.c(this.f51516c, iD);
        }

        @Override // androidx.recyclerview.widget.ThreadUtil.BackgroundCallback
        public void d(TileList.Tile tile) {
            this.f51520g.f51499c.c(tile.f52059a, tile.f52061c);
            tile.f52062d = this.f51514a;
            this.f51514a = tile;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static abstract class ViewCallback {
        public void a(int[] iArr, int[] iArr2, int i3) {
            int i4 = iArr[1];
            int i5 = iArr[0];
            int i6 = (i4 - i5) + 1;
            int i7 = i6 / 2;
            iArr2[0] = i5 - (i3 == 1 ? i6 : i7);
            if (i3 != 2) {
                i6 = i7;
            }
            iArr2[1] = i4 + i6;
        }

        public abstract void b(int[] iArr);

        public abstract void c();

        public abstract void d(int i3);
    }

    void a() {
        int i3;
        this.f51500d.b(this.f51504h);
        int[] iArr = this.f51504h;
        int i4 = iArr[0];
        int i5 = iArr[1];
        if (i4 > i5 || i4 < 0 || i5 >= this.f51509m) {
            return;
        }
        if (this.f51507k) {
            int[] iArr2 = this.f51505i;
            if (i4 > iArr2[1] || (i3 = iArr2[0]) > i5) {
                this.f51508l = 0;
            } else if (i4 < i3) {
                this.f51508l = 1;
            } else if (i4 > i3) {
                this.f51508l = 2;
            }
        } else {
            this.f51508l = 0;
        }
        int[] iArr3 = this.f51505i;
        iArr3[0] = i4;
        iArr3[1] = i5;
        this.f51500d.a(iArr, this.f51506j, this.f51508l);
        int[] iArr4 = this.f51506j;
        iArr4[0] = Math.min(this.f51504h[0], Math.max(iArr4[0], 0));
        int[] iArr5 = this.f51506j;
        iArr5[1] = Math.max(this.f51504h[1], Math.min(iArr5[1], this.f51509m - 1));
        ThreadUtil.BackgroundCallback backgroundCallback = this.f51503g;
        int[] iArr6 = this.f51504h;
        int i6 = iArr6[0];
        int i7 = iArr6[1];
        int[] iArr7 = this.f51506j;
        backgroundCallback.a(i6, i7, iArr7[0], iArr7[1], this.f51508l);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static abstract class DataCallback<T> {
        public abstract void a(Object[] objArr, int i3, int i4);

        public int b() {
            return 10;
        }

        public abstract int d();

        public void c(Object[] objArr, int i3) {
        }
    }
}
