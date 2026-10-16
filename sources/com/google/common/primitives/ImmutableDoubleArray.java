package com.google.common.primitives;

import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.Immutable;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
@Immutable
public final class ImmutableDoubleArray implements Serializable {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final ImmutableDoubleArray f85466d = new ImmutableDoubleArray(new double[0]);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final double[] f85467a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final transient int f85468b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f85469c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class AsList extends AbstractList<Double> implements RandomAccess, Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ImmutableDoubleArray f85470a;

        @Override // java.util.AbstractList, java.util.List
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Double get(int i3) {
            return Double.valueOf(this.f85470a.f(i3));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean contains(Object obj) {
            return indexOf(obj) >= 0;
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public boolean equals(Object obj) {
            if (obj instanceof AsList) {
                return this.f85470a.equals(((AsList) obj).f85470a);
            }
            if (!(obj instanceof List)) {
                return false;
            }
            List list = (List) obj;
            if (size() != list.size()) {
                return false;
            }
            int i3 = this.f85470a.f85468b;
            for (Object obj2 : list) {
                if (obj2 instanceof Double) {
                    int i4 = i3 + 1;
                    if (ImmutableDoubleArray.d(this.f85470a.f85467a[i3], ((Double) obj2).doubleValue())) {
                        i3 = i4;
                    }
                }
                return false;
            }
            return true;
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public int hashCode() {
            return this.f85470a.hashCode();
        }

        @Override // java.util.AbstractList, java.util.List
        public int indexOf(Object obj) {
            if (obj instanceof Double) {
                return this.f85470a.g(((Double) obj).doubleValue());
            }
            return -1;
        }

        @Override // java.util.AbstractList, java.util.List
        public int lastIndexOf(Object obj) {
            if (obj instanceof Double) {
                return this.f85470a.j(((Double) obj).doubleValue());
            }
            return -1;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f85470a.k();
        }

        @Override // java.util.AbstractList, java.util.List
        public List subList(int i3, int i4) {
            return this.f85470a.l(i3, i4).e();
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            return this.f85470a.toString();
        }

        private AsList(ImmutableDoubleArray immutableDoubleArray) {
            this.f85470a = immutableDoubleArray;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Builder {
    }

    private ImmutableDoubleArray(double[] dArr) {
        this(dArr, 0, dArr.length);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean d(double d3, double d4) {
        return Double.doubleToLongBits(d3) == Double.doubleToLongBits(d4);
    }

    private boolean i() {
        return this.f85468b > 0 || this.f85469c < this.f85467a.length;
    }

    public List e() {
        return new AsList();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ImmutableDoubleArray)) {
            return false;
        }
        ImmutableDoubleArray immutableDoubleArray = (ImmutableDoubleArray) obj;
        if (k() != immutableDoubleArray.k()) {
            return false;
        }
        for (int i3 = 0; i3 < k(); i3++) {
            if (!d(f(i3), immutableDoubleArray.f(i3))) {
                return false;
            }
        }
        return true;
    }

    public double f(int i3) {
        Preconditions.r(i3, k());
        return this.f85467a[this.f85468b + i3];
    }

    public int g(double d3) {
        for (int i3 = this.f85468b; i3 < this.f85469c; i3++) {
            if (d(this.f85467a[i3], d3)) {
                return i3 - this.f85468b;
            }
        }
        return -1;
    }

    public boolean h() {
        return this.f85469c == this.f85468b;
    }

    public int hashCode() {
        int iD = 1;
        for (int i3 = this.f85468b; i3 < this.f85469c; i3++) {
            iD = (iD * 31) + Doubles.d(this.f85467a[i3]);
        }
        return iD;
    }

    public int j(double d3) {
        int i3 = this.f85469c;
        do {
            i3--;
            if (i3 < this.f85468b) {
                return -1;
            }
        } while (!d(this.f85467a[i3], d3));
        return i3 - this.f85468b;
    }

    public int k() {
        return this.f85469c - this.f85468b;
    }

    public ImmutableDoubleArray l(int i3, int i4) {
        Preconditions.y(i3, i4, k());
        if (i3 == i4) {
            return f85466d;
        }
        double[] dArr = this.f85467a;
        int i5 = this.f85468b;
        return new ImmutableDoubleArray(dArr, i3 + i5, i5 + i4);
    }

    public double[] m() {
        return Arrays.copyOfRange(this.f85467a, this.f85468b, this.f85469c);
    }

    public ImmutableDoubleArray n() {
        return i() ? new ImmutableDoubleArray(m()) : this;
    }

    Object readResolve() {
        return h() ? f85466d : this;
    }

    public String toString() {
        if (h()) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder(k() * 5);
        sb.append('[');
        sb.append(this.f85467a[this.f85468b]);
        int i3 = this.f85468b;
        while (true) {
            i3++;
            if (i3 >= this.f85469c) {
                sb.append(']');
                return sb.toString();
            }
            sb.append(", ");
            sb.append(this.f85467a[i3]);
        }
    }

    Object writeReplace() {
        return n();
    }

    private ImmutableDoubleArray(double[] dArr, int i3, int i4) {
        this.f85467a = dArr;
        this.f85468b = i3;
        this.f85469c = i4;
    }
}
