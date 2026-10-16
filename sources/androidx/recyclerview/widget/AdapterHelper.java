package androidx.recyclerview.widget;

import androidx.core.util.Pools;
import androidx.recyclerview.widget.OpReorderer;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class AdapterHelper implements OpReorderer.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Pools.Pool f51459a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final ArrayList f51460b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final ArrayList f51461c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final Callback f51462d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    Runnable f51463e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final boolean f51464f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final OpReorderer f51465g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f51466h;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    interface Callback {
        void a(int i3, int i4);

        void b(UpdateOp updateOp);

        void c(UpdateOp updateOp);

        void d(int i3, int i4);

        void e(int i3, int i4, Object obj);

        RecyclerView.ViewHolder f(int i3);

        void g(int i3, int i4);

        void h(int i3, int i4);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class UpdateOp {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f51467a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f51468b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f51469c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f51470d;

        UpdateOp(int i3, int i4, int i5, Object obj) {
            this.f51467a = i3;
            this.f51468b = i4;
            this.f51470d = i5;
            this.f51469c = obj;
        }

        String a() {
            int i3 = this.f51467a;
            return i3 != 1 ? i3 != 2 ? i3 != 4 ? i3 != 8 ? "??" : "mv" : "up" : "rm" : "add";
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof UpdateOp)) {
                return false;
            }
            UpdateOp updateOp = (UpdateOp) obj;
            int i3 = this.f51467a;
            if (i3 != updateOp.f51467a) {
                return false;
            }
            if (i3 == 8 && Math.abs(this.f51470d - this.f51468b) == 1 && this.f51470d == updateOp.f51468b && this.f51468b == updateOp.f51470d) {
                return true;
            }
            if (this.f51470d != updateOp.f51470d || this.f51468b != updateOp.f51468b) {
                return false;
            }
            Object obj2 = this.f51469c;
            if (obj2 != null) {
                if (!obj2.equals(updateOp.f51469c)) {
                    return false;
                }
            } else if (updateOp.f51469c != null) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return (((this.f51467a * 31) + this.f51468b) * 31) + this.f51470d;
        }

        public String toString() {
            return Integer.toHexString(System.identityHashCode(this)) + "[" + a() + ",s:" + this.f51468b + "c:" + this.f51470d + ",p:" + this.f51469c + "]";
        }
    }

    AdapterHelper(Callback callback) {
        this(callback, false);
    }

    private void c(UpdateOp updateOp) {
        v(updateOp);
    }

    private void d(UpdateOp updateOp) {
        v(updateOp);
    }

    private void f(UpdateOp updateOp) {
        boolean z2;
        byte b3;
        int i3 = updateOp.f51468b;
        int i4 = updateOp.f51470d + i3;
        byte b4 = -1;
        int i5 = i3;
        int i6 = 0;
        while (i5 < i4) {
            if (this.f51462d.f(i5) != null || h(i5)) {
                if (b4 == 0) {
                    k(a(2, i3, i6, null));
                    z2 = true;
                } else {
                    z2 = false;
                }
                b3 = 1;
            } else {
                if (b4 == 1) {
                    v(a(2, i3, i6, null));
                    z2 = true;
                } else {
                    z2 = false;
                }
                b3 = 0;
            }
            if (z2) {
                i5 -= i6;
                i4 -= i6;
                i6 = 1;
            } else {
                i6++;
            }
            i5++;
            b4 = b3;
        }
        if (i6 != updateOp.f51470d) {
            b(updateOp);
            updateOp = a(2, i3, i6, null);
        }
        if (b4 == 0) {
            k(updateOp);
        } else {
            v(updateOp);
        }
    }

    private void g(UpdateOp updateOp) {
        int i3 = updateOp.f51468b;
        int i4 = updateOp.f51470d + i3;
        int i5 = 0;
        byte b3 = -1;
        int i6 = i3;
        while (i3 < i4) {
            if (this.f51462d.f(i3) != null || h(i3)) {
                if (b3 == 0) {
                    k(a(4, i6, i5, updateOp.f51469c));
                    i6 = i3;
                    i5 = 0;
                }
                b3 = 1;
            } else {
                if (b3 == 1) {
                    v(a(4, i6, i5, updateOp.f51469c));
                    i6 = i3;
                    i5 = 0;
                }
                b3 = 0;
            }
            i5++;
            i3++;
        }
        if (i5 != updateOp.f51470d) {
            Object obj = updateOp.f51469c;
            b(updateOp);
            updateOp = a(4, i6, i5, obj);
        }
        if (b3 == 0) {
            k(updateOp);
        } else {
            v(updateOp);
        }
    }

    private boolean h(int i3) {
        int size = this.f51461c.size();
        for (int i4 = 0; i4 < size; i4++) {
            UpdateOp updateOp = (UpdateOp) this.f51461c.get(i4);
            int i5 = updateOp.f51467a;
            if (i5 == 8) {
                if (n(updateOp.f51470d, i4 + 1) == i3) {
                    return true;
                }
            } else if (i5 == 1) {
                int i6 = updateOp.f51468b;
                int i7 = updateOp.f51470d + i6;
                while (i6 < i7) {
                    if (n(i6, i4 + 1) == i3) {
                        return true;
                    }
                    i6++;
                }
            } else {
                continue;
            }
        }
        return false;
    }

    private void k(UpdateOp updateOp) {
        int i3;
        int i4 = updateOp.f51467a;
        if (i4 == 1 || i4 == 8) {
            throw new IllegalArgumentException("should not dispatch add or move for pre layout");
        }
        int iZ = z(updateOp.f51468b, i4);
        int i5 = updateOp.f51468b;
        int i6 = updateOp.f51467a;
        if (i6 == 2) {
            i3 = 0;
        } else {
            if (i6 != 4) {
                throw new IllegalArgumentException("op should be remove or update." + updateOp);
            }
            i3 = 1;
        }
        int i7 = 1;
        for (int i8 = 1; i8 < updateOp.f51470d; i8++) {
            int iZ2 = z(updateOp.f51468b + (i3 * i8), updateOp.f51467a);
            int i9 = updateOp.f51467a;
            if (i9 == 2 ? iZ2 != iZ : !(i9 == 4 && iZ2 == iZ + 1)) {
                UpdateOp updateOpA = a(i9, iZ, i7, updateOp.f51469c);
                l(updateOpA, i5);
                b(updateOpA);
                if (updateOp.f51467a == 4) {
                    i5 += i7;
                }
                i7 = 1;
                iZ = iZ2;
            } else {
                i7++;
            }
        }
        Object obj = updateOp.f51469c;
        b(updateOp);
        if (i7 > 0) {
            UpdateOp updateOpA2 = a(updateOp.f51467a, iZ, i7, obj);
            l(updateOpA2, i5);
            b(updateOpA2);
        }
    }

    private void v(UpdateOp updateOp) {
        this.f51461c.add(updateOp);
        int i3 = updateOp.f51467a;
        if (i3 == 1) {
            this.f51462d.g(updateOp.f51468b, updateOp.f51470d);
            return;
        }
        if (i3 == 2) {
            this.f51462d.d(updateOp.f51468b, updateOp.f51470d);
            return;
        }
        if (i3 == 4) {
            this.f51462d.e(updateOp.f51468b, updateOp.f51470d, updateOp.f51469c);
        } else {
            if (i3 == 8) {
                this.f51462d.a(updateOp.f51468b, updateOp.f51470d);
                return;
            }
            throw new IllegalArgumentException("Unknown update op type for " + updateOp);
        }
    }

    private int z(int i3, int i4) {
        int i5;
        int i6;
        for (int size = this.f51461c.size() - 1; size >= 0; size--) {
            UpdateOp updateOp = (UpdateOp) this.f51461c.get(size);
            int i7 = updateOp.f51467a;
            if (i7 == 8) {
                int i8 = updateOp.f51468b;
                int i9 = updateOp.f51470d;
                if (i8 < i9) {
                    i6 = i8;
                    i5 = i9;
                } else {
                    i5 = i8;
                    i6 = i9;
                }
                if (i3 < i6 || i3 > i5) {
                    if (i3 < i8) {
                        if (i4 == 1) {
                            updateOp.f51468b = i8 + 1;
                            updateOp.f51470d = i9 + 1;
                        } else if (i4 == 2) {
                            updateOp.f51468b = i8 - 1;
                            updateOp.f51470d = i9 - 1;
                        }
                    }
                } else if (i6 == i8) {
                    if (i4 == 1) {
                        updateOp.f51470d = i9 + 1;
                    } else if (i4 == 2) {
                        updateOp.f51470d = i9 - 1;
                    }
                    i3++;
                } else {
                    if (i4 == 1) {
                        updateOp.f51468b = i8 + 1;
                    } else if (i4 == 2) {
                        updateOp.f51468b = i8 - 1;
                    }
                    i3--;
                }
            } else {
                int i10 = updateOp.f51468b;
                if (i10 <= i3) {
                    if (i7 == 1) {
                        i3 -= updateOp.f51470d;
                    } else if (i7 == 2) {
                        i3 += updateOp.f51470d;
                    }
                } else if (i4 == 1) {
                    updateOp.f51468b = i10 + 1;
                } else if (i4 == 2) {
                    updateOp.f51468b = i10 - 1;
                }
            }
        }
        for (int size2 = this.f51461c.size() - 1; size2 >= 0; size2--) {
            UpdateOp updateOp2 = (UpdateOp) this.f51461c.get(size2);
            if (updateOp2.f51467a == 8) {
                int i11 = updateOp2.f51470d;
                if (i11 == updateOp2.f51468b || i11 < 0) {
                    this.f51461c.remove(size2);
                    b(updateOp2);
                }
            } else if (updateOp2.f51470d <= 0) {
                this.f51461c.remove(size2);
                b(updateOp2);
            }
        }
        return i3;
    }

    @Override // androidx.recyclerview.widget.OpReorderer.Callback
    public UpdateOp a(int i3, int i4, int i5, Object obj) {
        UpdateOp updateOp = (UpdateOp) this.f51459a.a();
        if (updateOp == null) {
            return new UpdateOp(i3, i4, i5, obj);
        }
        updateOp.f51467a = i3;
        updateOp.f51468b = i4;
        updateOp.f51470d = i5;
        updateOp.f51469c = obj;
        return updateOp;
    }

    @Override // androidx.recyclerview.widget.OpReorderer.Callback
    public void b(UpdateOp updateOp) {
        if (this.f51464f) {
            return;
        }
        updateOp.f51469c = null;
        this.f51459a.b(updateOp);
    }

    public int e(int i3) {
        int size = this.f51460b.size();
        for (int i4 = 0; i4 < size; i4++) {
            UpdateOp updateOp = (UpdateOp) this.f51460b.get(i4);
            int i5 = updateOp.f51467a;
            if (i5 != 1) {
                if (i5 == 2) {
                    int i6 = updateOp.f51468b;
                    if (i6 <= i3) {
                        int i7 = updateOp.f51470d;
                        if (i6 + i7 > i3) {
                            return -1;
                        }
                        i3 -= i7;
                    } else {
                        continue;
                    }
                } else if (i5 == 8) {
                    int i8 = updateOp.f51468b;
                    if (i8 == i3) {
                        i3 = updateOp.f51470d;
                    } else {
                        if (i8 < i3) {
                            i3--;
                        }
                        if (updateOp.f51470d <= i3) {
                            i3++;
                        }
                    }
                }
            } else if (updateOp.f51468b <= i3) {
                i3 += updateOp.f51470d;
            }
        }
        return i3;
    }

    void i() {
        int size = this.f51461c.size();
        for (int i3 = 0; i3 < size; i3++) {
            this.f51462d.c((UpdateOp) this.f51461c.get(i3));
        }
        x(this.f51461c);
        this.f51466h = 0;
    }

    void j() {
        i();
        int size = this.f51460b.size();
        for (int i3 = 0; i3 < size; i3++) {
            UpdateOp updateOp = (UpdateOp) this.f51460b.get(i3);
            int i4 = updateOp.f51467a;
            if (i4 == 1) {
                this.f51462d.c(updateOp);
                this.f51462d.g(updateOp.f51468b, updateOp.f51470d);
            } else if (i4 == 2) {
                this.f51462d.c(updateOp);
                this.f51462d.h(updateOp.f51468b, updateOp.f51470d);
            } else if (i4 == 4) {
                this.f51462d.c(updateOp);
                this.f51462d.e(updateOp.f51468b, updateOp.f51470d, updateOp.f51469c);
            } else if (i4 == 8) {
                this.f51462d.c(updateOp);
                this.f51462d.a(updateOp.f51468b, updateOp.f51470d);
            }
            Runnable runnable = this.f51463e;
            if (runnable != null) {
                runnable.run();
            }
        }
        x(this.f51460b);
        this.f51466h = 0;
    }

    void l(UpdateOp updateOp, int i3) {
        this.f51462d.b(updateOp);
        int i4 = updateOp.f51467a;
        if (i4 == 2) {
            this.f51462d.h(i3, updateOp.f51470d);
        } else {
            if (i4 != 4) {
                throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
            }
            this.f51462d.e(i3, updateOp.f51470d, updateOp.f51469c);
        }
    }

    int m(int i3) {
        return n(i3, 0);
    }

    int n(int i3, int i4) {
        int size = this.f51461c.size();
        while (i4 < size) {
            UpdateOp updateOp = (UpdateOp) this.f51461c.get(i4);
            int i5 = updateOp.f51467a;
            if (i5 == 8) {
                int i6 = updateOp.f51468b;
                if (i6 == i3) {
                    i3 = updateOp.f51470d;
                } else {
                    if (i6 < i3) {
                        i3--;
                    }
                    if (updateOp.f51470d <= i3) {
                        i3++;
                    }
                }
            } else {
                int i7 = updateOp.f51468b;
                if (i7 > i3) {
                    continue;
                } else if (i5 == 2) {
                    int i8 = updateOp.f51470d;
                    if (i3 < i7 + i8) {
                        return -1;
                    }
                    i3 -= i8;
                } else if (i5 == 1) {
                    i3 += updateOp.f51470d;
                }
            }
            i4++;
        }
        return i3;
    }

    boolean o(int i3) {
        return (i3 & this.f51466h) != 0;
    }

    boolean p() {
        return this.f51460b.size() > 0;
    }

    boolean q() {
        return (this.f51461c.isEmpty() || this.f51460b.isEmpty()) ? false : true;
    }

    boolean r(int i3, int i4, Object obj) {
        if (i4 < 1) {
            return false;
        }
        this.f51460b.add(a(4, i3, i4, obj));
        this.f51466h |= 4;
        return this.f51460b.size() == 1;
    }

    boolean s(int i3, int i4) {
        if (i4 < 1) {
            return false;
        }
        this.f51460b.add(a(1, i3, i4, null));
        this.f51466h |= 1;
        return this.f51460b.size() == 1;
    }

    boolean t(int i3, int i4, int i5) {
        if (i3 == i4) {
            return false;
        }
        if (i5 != 1) {
            throw new IllegalArgumentException("Moving more than 1 item is not supported yet");
        }
        this.f51460b.add(a(8, i3, i4, null));
        this.f51466h |= 8;
        return this.f51460b.size() == 1;
    }

    boolean u(int i3, int i4) {
        if (i4 < 1) {
            return false;
        }
        this.f51460b.add(a(2, i3, i4, null));
        this.f51466h |= 2;
        return this.f51460b.size() == 1;
    }

    void w() {
        this.f51465g.b(this.f51460b);
        int size = this.f51460b.size();
        for (int i3 = 0; i3 < size; i3++) {
            UpdateOp updateOp = (UpdateOp) this.f51460b.get(i3);
            int i4 = updateOp.f51467a;
            if (i4 == 1) {
                c(updateOp);
            } else if (i4 == 2) {
                f(updateOp);
            } else if (i4 == 4) {
                g(updateOp);
            } else if (i4 == 8) {
                d(updateOp);
            }
            Runnable runnable = this.f51463e;
            if (runnable != null) {
                runnable.run();
            }
        }
        this.f51460b.clear();
    }

    void x(List list) {
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            b((UpdateOp) list.get(i3));
        }
        list.clear();
    }

    void y() {
        x(this.f51460b);
        x(this.f51461c);
        this.f51466h = 0;
    }

    AdapterHelper(Callback callback, boolean z2) {
        this.f51459a = new Pools.SimplePool(30);
        this.f51460b = new ArrayList();
        this.f51461c = new ArrayList();
        this.f51466h = 0;
        this.f51462d = callback;
        this.f51464f = z2;
        this.f51465g = new OpReorderer(this);
    }
}
