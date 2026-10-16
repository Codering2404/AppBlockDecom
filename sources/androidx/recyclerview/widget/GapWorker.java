package androidx.recyclerview.widget;

import androidx.core.os.TraceCompat;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class GapWorker implements Runnable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final ThreadLocal f51663f = new ThreadLocal();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    static Comparator f51664g = new Comparator<Task>() { // from class: androidx.recyclerview.widget.GapWorker.1
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(Task task, Task task2) {
            RecyclerView recyclerView = task.f51676d;
            if ((recyclerView == null) != (task2.f51676d == null)) {
                return recyclerView == null ? 1 : -1;
            }
            boolean z2 = task.f51673a;
            if (z2 != task2.f51673a) {
                return z2 ? -1 : 1;
            }
            int i3 = task2.f51674b - task.f51674b;
            if (i3 != 0) {
                return i3;
            }
            int i4 = task.f51675c - task2.f51675c;
            if (i4 != 0) {
                return i4;
            }
            return 0;
        }
    };

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    long f51666b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    long f51667c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    ArrayList f51665a = new ArrayList();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ArrayList f51668d = new ArrayList();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class LayoutPrefetchRegistryImpl implements RecyclerView.LayoutManager.LayoutPrefetchRegistry {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f51669a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f51670b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int[] f51671c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f51672d;

        LayoutPrefetchRegistryImpl() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager.LayoutPrefetchRegistry
        public void a(int i3, int i4) {
            if (i3 < 0) {
                throw new IllegalArgumentException("Layout positions must be non-negative");
            }
            if (i4 < 0) {
                throw new IllegalArgumentException("Pixel distance must be non-negative");
            }
            int i5 = this.f51672d;
            int i6 = i5 * 2;
            int[] iArr = this.f51671c;
            if (iArr == null) {
                int[] iArr2 = new int[4];
                this.f51671c = iArr2;
                Arrays.fill(iArr2, -1);
            } else if (i6 >= iArr.length) {
                int[] iArr3 = new int[i5 * 4];
                this.f51671c = iArr3;
                System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
            }
            int[] iArr4 = this.f51671c;
            iArr4[i6] = i3;
            iArr4[i6 + 1] = i4;
            this.f51672d++;
        }

        void b() {
            int[] iArr = this.f51671c;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            this.f51672d = 0;
        }

        void c(RecyclerView recyclerView, boolean z2) {
            this.f51672d = 0;
            int[] iArr = this.f51671c;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            RecyclerView.LayoutManager layoutManager = recyclerView.f51866o;
            if (recyclerView.f51864n == null || layoutManager == null || !layoutManager.z0()) {
                return;
            }
            if (z2) {
                if (!recyclerView.f51848f.p()) {
                    layoutManager.v(recyclerView.f51864n.getItemCount(), this);
                }
            } else if (!recyclerView.v0()) {
                layoutManager.u(this.f51669a, this.f51670b, recyclerView.f51859k0, this);
            }
            int i3 = this.f51672d;
            if (i3 > layoutManager.f51923m) {
                layoutManager.f51923m = i3;
                layoutManager.f51924n = z2;
                recyclerView.f51843c.P();
            }
        }

        boolean d(int i3) {
            if (this.f51671c != null) {
                int i4 = this.f51672d * 2;
                for (int i5 = 0; i5 < i4; i5 += 2) {
                    if (this.f51671c[i5] == i3) {
                        return true;
                    }
                }
            }
            return false;
        }

        void e(int i3, int i4) {
            this.f51669a = i3;
            this.f51670b = i4;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Task {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f51673a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f51674b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f51675c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public RecyclerView f51676d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f51677e;

        Task() {
        }

        public void a() {
            this.f51673a = false;
            this.f51674b = 0;
            this.f51675c = 0;
            this.f51676d = null;
            this.f51677e = 0;
        }
    }

    GapWorker() {
    }

    private void b() {
        Task task;
        int size = this.f51665a.size();
        int i3 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            RecyclerView recyclerView = (RecyclerView) this.f51665a.get(i4);
            if (recyclerView.getWindowVisibility() == 0) {
                recyclerView.f51857j0.c(recyclerView, false);
                i3 += recyclerView.f51857j0.f51672d;
            }
        }
        this.f51668d.ensureCapacity(i3);
        int i5 = 0;
        for (int i6 = 0; i6 < size; i6++) {
            RecyclerView recyclerView2 = (RecyclerView) this.f51665a.get(i6);
            if (recyclerView2.getWindowVisibility() == 0) {
                LayoutPrefetchRegistryImpl layoutPrefetchRegistryImpl = recyclerView2.f51857j0;
                int iAbs = Math.abs(layoutPrefetchRegistryImpl.f51669a) + Math.abs(layoutPrefetchRegistryImpl.f51670b);
                for (int i7 = 0; i7 < layoutPrefetchRegistryImpl.f51672d * 2; i7 += 2) {
                    if (i5 >= this.f51668d.size()) {
                        task = new Task();
                        this.f51668d.add(task);
                    } else {
                        task = (Task) this.f51668d.get(i5);
                    }
                    int[] iArr = layoutPrefetchRegistryImpl.f51671c;
                    int i8 = iArr[i7 + 1];
                    task.f51673a = i8 <= iAbs;
                    task.f51674b = iAbs;
                    task.f51675c = i8;
                    task.f51676d = recyclerView2;
                    task.f51677e = iArr[i7];
                    i5++;
                }
            }
        }
        Collections.sort(this.f51668d, f51664g);
    }

    private void c(Task task, long j3) {
        RecyclerView.ViewHolder viewHolderI = i(task.f51676d, task.f51677e, task.f51673a ? Long.MAX_VALUE : j3);
        if (viewHolderI == null || viewHolderI.mNestedRecyclerView == null || !viewHolderI.isBound() || viewHolderI.isInvalid()) {
            return;
        }
        h(viewHolderI.mNestedRecyclerView.get(), j3);
    }

    private void d(long j3) {
        for (int i3 = 0; i3 < this.f51668d.size(); i3++) {
            Task task = (Task) this.f51668d.get(i3);
            if (task.f51676d == null) {
                return;
            }
            c(task, j3);
            task.a();
        }
    }

    static boolean e(RecyclerView recyclerView, int i3) {
        int iJ = recyclerView.f51850g.j();
        for (int i4 = 0; i4 < iJ; i4++) {
            RecyclerView.ViewHolder viewHolderN0 = RecyclerView.n0(recyclerView.f51850g.i(i4));
            if (viewHolderN0.mPosition == i3 && !viewHolderN0.isInvalid()) {
                return true;
            }
        }
        return false;
    }

    private void h(RecyclerView recyclerView, long j3) {
        if (recyclerView == null) {
            return;
        }
        if (recyclerView.G && recyclerView.f51850g.j() != 0) {
            recyclerView.h1();
        }
        LayoutPrefetchRegistryImpl layoutPrefetchRegistryImpl = recyclerView.f51857j0;
        layoutPrefetchRegistryImpl.c(recyclerView, true);
        if (layoutPrefetchRegistryImpl.f51672d != 0) {
            try {
                TraceCompat.a("RV Nested Prefetch");
                recyclerView.f51859k0.f(recyclerView.f51864n);
                for (int i3 = 0; i3 < layoutPrefetchRegistryImpl.f51672d * 2; i3 += 2) {
                    i(recyclerView, layoutPrefetchRegistryImpl.f51671c[i3], j3);
                }
            } finally {
                TraceCompat.b();
            }
        }
    }

    private RecyclerView.ViewHolder i(RecyclerView recyclerView, int i3, long j3) {
        if (e(recyclerView, i3)) {
            return null;
        }
        RecyclerView.Recycler recycler = recyclerView.f51843c;
        try {
            recyclerView.R0();
            RecyclerView.ViewHolder viewHolderN = recycler.N(i3, false, j3);
            if (viewHolderN != null) {
                if (!viewHolderN.isBound() || viewHolderN.isInvalid()) {
                    recycler.a(viewHolderN, false);
                } else {
                    recycler.G(viewHolderN.itemView);
                }
            }
            recyclerView.T0(false);
            return viewHolderN;
        } catch (Throwable th) {
            recyclerView.T0(false);
            throw th;
        }
    }

    public void a(RecyclerView recyclerView) {
        if (RecyclerView.E0 && this.f51665a.contains(recyclerView)) {
            throw new IllegalStateException("RecyclerView already present in worker list!");
        }
        this.f51665a.add(recyclerView);
    }

    void f(RecyclerView recyclerView, int i3, int i4) {
        if (recyclerView.isAttachedToWindow()) {
            if (RecyclerView.E0 && !this.f51665a.contains(recyclerView)) {
                throw new IllegalStateException("attempting to post unregistered view!");
            }
            if (this.f51666b == 0) {
                this.f51666b = recyclerView.getNanoTime();
                recyclerView.post(this);
            }
        }
        recyclerView.f51857j0.e(i3, i4);
    }

    void g(long j3) {
        b();
        d(j3);
    }

    public void j(RecyclerView recyclerView) {
        boolean zRemove = this.f51665a.remove(recyclerView);
        if (RecyclerView.E0 && !zRemove) {
            throw new IllegalStateException("RecyclerView removal failed!");
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            TraceCompat.a("RV Prefetch");
            if (!this.f51665a.isEmpty()) {
                int size = this.f51665a.size();
                long jMax = 0;
                for (int i3 = 0; i3 < size; i3++) {
                    RecyclerView recyclerView = (RecyclerView) this.f51665a.get(i3);
                    if (recyclerView.getWindowVisibility() == 0) {
                        jMax = Math.max(recyclerView.getDrawingTime(), jMax);
                    }
                }
                if (jMax != 0) {
                    g(TimeUnit.MILLISECONDS.toNanos(jMax) + this.f51667c);
                }
            }
        } finally {
            this.f51666b = 0L;
            TraceCompat.b();
        }
    }
}
