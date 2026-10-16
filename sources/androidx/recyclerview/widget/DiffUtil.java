package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class DiffUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Comparator f51603a = new Comparator<Diagonal>() { // from class: androidx.recyclerview.widget.DiffUtil.1
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(Diagonal diagonal, Diagonal diagonal2) {
            return diagonal.f51606a - diagonal2.f51606a;
        }
    };

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static abstract class Callback {
        public abstract boolean a(int i3, int i4);

        public abstract boolean b(int i3, int i4);

        public Object c(int i3, int i4) {
            return null;
        }

        public abstract int d();

        public abstract int e();
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class CenteredArray {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int[] f51604a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f51605b;

        CenteredArray(int i3) {
            int[] iArr = new int[i3];
            this.f51604a = iArr;
            this.f51605b = iArr.length / 2;
        }

        int[] a() {
            return this.f51604a;
        }

        int b(int i3) {
            return this.f51604a[i3 + this.f51605b];
        }

        void c(int i3, int i4) {
            this.f51604a[i3 + this.f51605b] = i4;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Diagonal {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f51606a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f51607b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f51608c;

        Diagonal(int i3, int i4, int i5) {
            this.f51606a = i3;
            this.f51607b = i4;
            this.f51608c = i5;
        }

        int a() {
            return this.f51606a + this.f51608c;
        }

        int b() {
            return this.f51607b + this.f51608c;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class DiffResult {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List f51609a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int[] f51610b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int[] f51611c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final Callback f51612d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final int f51613e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final int f51614f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final boolean f51615g;

        DiffResult(Callback callback, List list, int[] iArr, int[] iArr2, boolean z2) {
            this.f51609a = list;
            this.f51610b = iArr;
            this.f51611c = iArr2;
            Arrays.fill(iArr, 0);
            Arrays.fill(iArr2, 0);
            this.f51612d = callback;
            this.f51613e = callback.e();
            this.f51614f = callback.d();
            this.f51615g = z2;
            a();
            f();
        }

        private void a() {
            Diagonal diagonal = this.f51609a.isEmpty() ? null : (Diagonal) this.f51609a.get(0);
            if (diagonal == null || diagonal.f51606a != 0 || diagonal.f51607b != 0) {
                this.f51609a.add(0, new Diagonal(0, 0, 0));
            }
            this.f51609a.add(new Diagonal(this.f51613e, this.f51614f, 0));
        }

        private void e(int i3) {
            int size = this.f51609a.size();
            int iB = 0;
            for (int i4 = 0; i4 < size; i4++) {
                Diagonal diagonal = (Diagonal) this.f51609a.get(i4);
                while (iB < diagonal.f51607b) {
                    if (this.f51611c[iB] == 0 && this.f51612d.b(i3, iB)) {
                        int i5 = this.f51612d.a(i3, iB) ? 8 : 4;
                        this.f51610b[i3] = (iB << 4) | i5;
                        this.f51611c[iB] = (i3 << 4) | i5;
                        return;
                    }
                    iB++;
                }
                iB = diagonal.b();
            }
        }

        private void f() {
            for (Diagonal diagonal : this.f51609a) {
                for (int i3 = 0; i3 < diagonal.f51608c; i3++) {
                    int i4 = diagonal.f51606a + i3;
                    int i5 = diagonal.f51607b + i3;
                    int i6 = this.f51612d.a(i4, i5) ? 1 : 2;
                    this.f51610b[i4] = (i5 << 4) | i6;
                    this.f51611c[i5] = (i4 << 4) | i6;
                }
            }
            if (this.f51615g) {
                g();
            }
        }

        private void g() {
            int iA = 0;
            for (Diagonal diagonal : this.f51609a) {
                while (iA < diagonal.f51606a) {
                    if (this.f51610b[iA] == 0) {
                        e(iA);
                    }
                    iA++;
                }
                iA = diagonal.a();
            }
        }

        private static PostponedUpdate h(Collection collection, int i3, boolean z2) {
            PostponedUpdate postponedUpdate;
            Iterator it = collection.iterator();
            while (true) {
                if (!it.hasNext()) {
                    postponedUpdate = null;
                    break;
                }
                postponedUpdate = (PostponedUpdate) it.next();
                if (postponedUpdate.f51616a == i3 && postponedUpdate.f51618c == z2) {
                    it.remove();
                    break;
                }
            }
            while (it.hasNext()) {
                PostponedUpdate postponedUpdate2 = (PostponedUpdate) it.next();
                if (z2) {
                    postponedUpdate2.f51617b--;
                } else {
                    postponedUpdate2.f51617b++;
                }
            }
            return postponedUpdate;
        }

        public int b(int i3) {
            if (i3 >= 0 && i3 < this.f51613e) {
                int i4 = this.f51610b[i3];
                if ((i4 & 15) == 0) {
                    return -1;
                }
                return i4 >> 4;
            }
            throw new IndexOutOfBoundsException("Index out of bounds - passed position = " + i3 + ", old list size = " + this.f51613e);
        }

        public void c(ListUpdateCallback listUpdateCallback) {
            int i3;
            BatchingListUpdateCallback batchingListUpdateCallback = listUpdateCallback instanceof BatchingListUpdateCallback ? (BatchingListUpdateCallback) listUpdateCallback : new BatchingListUpdateCallback(listUpdateCallback);
            int i4 = this.f51613e;
            ArrayDeque arrayDeque = new ArrayDeque();
            int i5 = this.f51613e;
            int i6 = this.f51614f;
            for (int size = this.f51609a.size() - 1; size >= 0; size--) {
                Diagonal diagonal = (Diagonal) this.f51609a.get(size);
                int iA = diagonal.a();
                int iB = diagonal.b();
                while (true) {
                    if (i5 <= iA) {
                        break;
                    }
                    i5--;
                    int i7 = this.f51610b[i5];
                    if ((i7 & 12) != 0) {
                        int i8 = i7 >> 4;
                        PostponedUpdate postponedUpdateH = h(arrayDeque, i8, false);
                        if (postponedUpdateH != null) {
                            int i9 = (i4 - postponedUpdateH.f51617b) - 1;
                            batchingListUpdateCallback.d(i5, i9);
                            if ((i7 & 4) != 0) {
                                batchingListUpdateCallback.c(i9, 1, this.f51612d.c(i5, i8));
                            }
                        } else {
                            arrayDeque.add(new PostponedUpdate(i5, (i4 - i5) - 1, true));
                        }
                    } else {
                        batchingListUpdateCallback.b(i5, 1);
                        i4--;
                    }
                }
                while (i6 > iB) {
                    i6--;
                    int i10 = this.f51611c[i6];
                    if ((i10 & 12) != 0) {
                        int i11 = i10 >> 4;
                        PostponedUpdate postponedUpdateH2 = h(arrayDeque, i11, true);
                        if (postponedUpdateH2 == null) {
                            arrayDeque.add(new PostponedUpdate(i6, i4 - i5, false));
                        } else {
                            batchingListUpdateCallback.d((i4 - postponedUpdateH2.f51617b) - 1, i5);
                            if ((i10 & 4) != 0) {
                                batchingListUpdateCallback.c(i5, 1, this.f51612d.c(i11, i6));
                            }
                        }
                    } else {
                        batchingListUpdateCallback.a(i5, 1);
                        i4++;
                    }
                }
                int i12 = diagonal.f51606a;
                int i13 = diagonal.f51607b;
                for (i3 = 0; i3 < diagonal.f51608c; i3++) {
                    if ((this.f51610b[i12] & 15) == 2) {
                        batchingListUpdateCallback.c(i12, 1, this.f51612d.c(i12, i13));
                    }
                    i12++;
                    i13++;
                }
                i5 = diagonal.f51606a;
                i6 = diagonal.f51607b;
            }
            batchingListUpdateCallback.e();
        }

        public void d(RecyclerView.Adapter adapter) {
            c(new AdapterListUpdateCallback(adapter));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static abstract class ItemCallback<T> {
        public abstract boolean a(Object obj, Object obj2);

        public abstract boolean b(Object obj, Object obj2);

        public Object c(Object obj, Object obj2) {
            return null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class PostponedUpdate {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f51616a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f51617b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f51618c;

        PostponedUpdate(int i3, int i4, boolean z2) {
            this.f51616a = i3;
            this.f51617b = i4;
            this.f51618c = z2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Range {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f51619a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f51620b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f51621c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f51622d;

        public Range() {
        }

        int a() {
            return this.f51622d - this.f51621c;
        }

        int b() {
            return this.f51620b - this.f51619a;
        }

        public Range(int i3, int i4, int i5, int i6) {
            this.f51619a = i3;
            this.f51620b = i4;
            this.f51621c = i5;
            this.f51622d = i6;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Snake {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f51623a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f51624b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f51625c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f51626d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f51627e;

        Snake() {
        }

        int a() {
            return Math.min(this.f51625c - this.f51623a, this.f51626d - this.f51624b);
        }

        boolean b() {
            return this.f51626d - this.f51624b != this.f51625c - this.f51623a;
        }

        boolean c() {
            return this.f51626d - this.f51624b > this.f51625c - this.f51623a;
        }

        Diagonal d() {
            if (b()) {
                return this.f51627e ? new Diagonal(this.f51623a, this.f51624b, a()) : c() ? new Diagonal(this.f51623a, this.f51624b + 1, a()) : new Diagonal(this.f51623a + 1, this.f51624b, a());
            }
            int i3 = this.f51623a;
            return new Diagonal(i3, this.f51624b, this.f51625c - i3);
        }
    }

    private static Snake a(Range range, Callback callback, CenteredArray centeredArray, CenteredArray centeredArray2, int i3) {
        int iB;
        int i4;
        int i5;
        boolean z2 = (range.b() - range.a()) % 2 == 0;
        int iB2 = range.b() - range.a();
        int i6 = -i3;
        for (int i7 = i6; i7 <= i3; i7 += 2) {
            if (i7 == i6 || (i7 != i3 && centeredArray2.b(i7 + 1) < centeredArray2.b(i7 - 1))) {
                iB = centeredArray2.b(i7 + 1);
                i4 = iB;
            } else {
                iB = centeredArray2.b(i7 - 1);
                i4 = iB - 1;
            }
            int i8 = range.f51622d - ((range.f51620b - i4) - i7);
            int i9 = (i3 == 0 || i4 != iB) ? i8 : i8 + 1;
            while (i4 > range.f51619a && i8 > range.f51621c && callback.b(i4 - 1, i8 - 1)) {
                i4--;
                i8--;
            }
            centeredArray2.c(i7, i4);
            if (z2 && (i5 = iB2 - i7) >= i6 && i5 <= i3 && centeredArray.b(i5) >= i4) {
                Snake snake = new Snake();
                snake.f51623a = i4;
                snake.f51624b = i8;
                snake.f51625c = iB;
                snake.f51626d = i9;
                snake.f51627e = true;
                return snake;
            }
        }
        return null;
    }

    public static DiffResult b(Callback callback) {
        return c(callback, true);
    }

    public static DiffResult c(Callback callback, boolean z2) {
        int iE = callback.e();
        int iD = callback.d();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(new Range(0, iE, 0, iD));
        int i3 = ((((iE + iD) + 1) / 2) * 2) + 1;
        CenteredArray centeredArray = new CenteredArray(i3);
        CenteredArray centeredArray2 = new CenteredArray(i3);
        ArrayList arrayList3 = new ArrayList();
        while (!arrayList2.isEmpty()) {
            Range range = (Range) arrayList2.remove(arrayList2.size() - 1);
            Snake snakeE = e(range, callback, centeredArray, centeredArray2);
            if (snakeE != null) {
                if (snakeE.a() > 0) {
                    arrayList.add(snakeE.d());
                }
                Range range2 = arrayList3.isEmpty() ? new Range() : (Range) arrayList3.remove(arrayList3.size() - 1);
                range2.f51619a = range.f51619a;
                range2.f51621c = range.f51621c;
                range2.f51620b = snakeE.f51623a;
                range2.f51622d = snakeE.f51624b;
                arrayList2.add(range2);
                range.f51620b = range.f51620b;
                range.f51622d = range.f51622d;
                range.f51619a = snakeE.f51625c;
                range.f51621c = snakeE.f51626d;
                arrayList2.add(range);
            } else {
                arrayList3.add(range);
            }
        }
        Collections.sort(arrayList, f51603a);
        return new DiffResult(callback, arrayList, centeredArray.a(), centeredArray2.a(), z2);
    }

    private static Snake d(Range range, Callback callback, CenteredArray centeredArray, CenteredArray centeredArray2, int i3) {
        int iB;
        int i4;
        int i5;
        boolean z2 = Math.abs(range.b() - range.a()) % 2 == 1;
        int iB2 = range.b() - range.a();
        int i6 = -i3;
        for (int i7 = i6; i7 <= i3; i7 += 2) {
            if (i7 == i6 || (i7 != i3 && centeredArray.b(i7 + 1) > centeredArray.b(i7 - 1))) {
                iB = centeredArray.b(i7 + 1);
                i4 = iB;
            } else {
                iB = centeredArray.b(i7 - 1);
                i4 = iB + 1;
            }
            int i8 = (range.f51621c + (i4 - range.f51619a)) - i7;
            int i9 = (i3 == 0 || i4 != iB) ? i8 : i8 - 1;
            while (i4 < range.f51620b && i8 < range.f51622d && callback.b(i4, i8)) {
                i4++;
                i8++;
            }
            centeredArray.c(i7, i4);
            if (z2 && (i5 = iB2 - i7) >= i6 + 1 && i5 <= i3 - 1 && centeredArray2.b(i5) <= i4) {
                Snake snake = new Snake();
                snake.f51623a = iB;
                snake.f51624b = i9;
                snake.f51625c = i4;
                snake.f51626d = i8;
                snake.f51627e = false;
                return snake;
            }
        }
        return null;
    }

    private static Snake e(Range range, Callback callback, CenteredArray centeredArray, CenteredArray centeredArray2) {
        if (range.b() >= 1 && range.a() >= 1) {
            int iB = ((range.b() + range.a()) + 1) / 2;
            centeredArray.c(1, range.f51619a);
            centeredArray2.c(1, range.f51620b);
            for (int i3 = 0; i3 < iB; i3++) {
                Snake snakeD = d(range, callback, centeredArray, centeredArray2, i3);
                if (snakeD != null) {
                    return snakeD;
                }
                Snake snakeA = a(range, callback, centeredArray, centeredArray2, i3);
                if (snakeA != null) {
                    return snakeA;
                }
            }
        }
        return null;
    }
}
