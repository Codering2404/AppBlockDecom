package io.reactivex.internal.util;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class OpenHashSet<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final float f139218a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f139219b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f139220c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f139221d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    Object[] f139222e;

    public OpenHashSet() {
        this(16, 0.75f);
    }

    static int c(int i3) {
        int i4 = i3 * (-1640531527);
        return i4 ^ (i4 >>> 16);
    }

    public boolean a(Object obj) {
        Object obj2;
        Object[] objArr = this.f139222e;
        int i3 = this.f139219b;
        int iC = c(obj.hashCode()) & i3;
        Object obj3 = objArr[iC];
        if (obj3 != null) {
            if (obj3.equals(obj)) {
                return false;
            }
            do {
                iC = (iC + 1) & i3;
                obj2 = objArr[iC];
                if (obj2 == null) {
                }
            } while (!obj2.equals(obj));
            return false;
        }
        objArr[iC] = obj;
        int i4 = this.f139220c + 1;
        this.f139220c = i4;
        if (i4 >= this.f139221d) {
            d();
        }
        return true;
    }

    public Object[] b() {
        return this.f139222e;
    }

    void d() {
        Object obj;
        Object[] objArr = this.f139222e;
        int length = objArr.length;
        int i3 = length << 1;
        int i4 = i3 - 1;
        Object[] objArr2 = new Object[i3];
        int i5 = this.f139220c;
        while (true) {
            int i6 = i5 - 1;
            if (i5 == 0) {
                this.f139219b = i4;
                this.f139221d = (int) (i3 * this.f139218a);
                this.f139222e = objArr2;
                return;
            }
            do {
                length--;
                obj = objArr[length];
            } while (obj == null);
            int iC = c(obj.hashCode()) & i4;
            if (objArr2[iC] != null) {
                do {
                    iC = (iC + 1) & i4;
                } while (objArr2[iC] != null);
            }
            objArr2[iC] = objArr[length];
            i5 = i6;
        }
    }

    public boolean e(Object obj) {
        Object obj2;
        Object[] objArr = this.f139222e;
        int i3 = this.f139219b;
        int iC = c(obj.hashCode()) & i3;
        Object obj3 = objArr[iC];
        if (obj3 == null) {
            return false;
        }
        if (obj3.equals(obj)) {
            return f(iC, objArr, i3);
        }
        do {
            iC = (iC + 1) & i3;
            obj2 = objArr[iC];
            if (obj2 == null) {
                return false;
            }
        } while (!obj2.equals(obj));
        return f(iC, objArr, i3);
    }

    boolean f(int i3, Object[] objArr, int i4) {
        int i5;
        Object obj;
        this.f139220c--;
        while (true) {
            int i6 = i3 + 1;
            while (true) {
                i5 = i6 & i4;
                obj = objArr[i5];
                if (obj == null) {
                    objArr[i3] = null;
                    return true;
                }
                int iC = c(obj.hashCode()) & i4;
                if (i3 <= i5) {
                    if (i3 >= iC || iC > i5) {
                        break;
                    }
                    i6 = i5 + 1;
                } else if (i3 < iC || iC <= i5) {
                    i6 = i5 + 1;
                }
            }
            objArr[i3] = obj;
            i3 = i5;
        }
    }

    public int g() {
        return this.f139220c;
    }

    public OpenHashSet(int i3, float f3) {
        this.f139218a = f3;
        int iA = Pow2.a(i3);
        this.f139219b = iA - 1;
        this.f139221d = (int) (f3 * iA);
        this.f139222e = new Object[iA];
    }
}
