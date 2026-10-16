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
public final class ImmutableIntArray implements Serializable {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final ImmutableIntArray f85471d = new ImmutableIntArray(new int[0]);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int[] f85472a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final transient int f85473b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f85474c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class AsList extends AbstractList<Integer> implements RandomAccess, Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ImmutableIntArray f85475a;

        @Override // java.util.AbstractList, java.util.List
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Integer get(int i3) {
            return Integer.valueOf(this.f85475a.e(i3));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean contains(Object obj) {
            return indexOf(obj) >= 0;
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public boolean equals(Object obj) {
            if (obj instanceof AsList) {
                return this.f85475a.equals(((AsList) obj).f85475a);
            }
            if (!(obj instanceof List)) {
                return false;
            }
            List list = (List) obj;
            if (size() != list.size()) {
                return false;
            }
            int i3 = this.f85475a.f85473b;
            for (Object obj2 : list) {
                if (obj2 instanceof Integer) {
                    int i4 = i3 + 1;
                    if (this.f85475a.f85472a[i3] == ((Integer) obj2).intValue()) {
                        i3 = i4;
                    }
                }
                return false;
            }
            return true;
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public int hashCode() {
            return this.f85475a.hashCode();
        }

        @Override // java.util.AbstractList, java.util.List
        public int indexOf(Object obj) {
            if (obj instanceof Integer) {
                return this.f85475a.f(((Integer) obj).intValue());
            }
            return -1;
        }

        @Override // java.util.AbstractList, java.util.List
        public int lastIndexOf(Object obj) {
            if (obj instanceof Integer) {
                return this.f85475a.i(((Integer) obj).intValue());
            }
            return -1;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f85475a.j();
        }

        @Override // java.util.AbstractList, java.util.List
        public List subList(int i3, int i4) {
            return this.f85475a.l(i3, i4).c();
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            return this.f85475a.toString();
        }

        private AsList(ImmutableIntArray immutableIntArray) {
            this.f85475a = immutableIntArray;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Builder {
    }

    private ImmutableIntArray(int[] iArr) {
        this(iArr, 0, iArr.length);
    }

    public static ImmutableIntArray d(int[] iArr) {
        return iArr.length == 0 ? f85471d : new ImmutableIntArray(Arrays.copyOf(iArr, iArr.length));
    }

    private boolean h() {
        return this.f85473b > 0 || this.f85474c < this.f85472a.length;
    }

    public static ImmutableIntArray k() {
        return f85471d;
    }

    public List c() {
        return new AsList();
    }

    public int e(int i3) {
        Preconditions.r(i3, j());
        return this.f85472a[this.f85473b + i3];
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ImmutableIntArray)) {
            return false;
        }
        ImmutableIntArray immutableIntArray = (ImmutableIntArray) obj;
        if (j() != immutableIntArray.j()) {
            return false;
        }
        for (int i3 = 0; i3 < j(); i3++) {
            if (e(i3) != immutableIntArray.e(i3)) {
                return false;
            }
        }
        return true;
    }

    public int f(int i3) {
        for (int i4 = this.f85473b; i4 < this.f85474c; i4++) {
            if (this.f85472a[i4] == i3) {
                return i4 - this.f85473b;
            }
        }
        return -1;
    }

    public boolean g() {
        return this.f85474c == this.f85473b;
    }

    public int hashCode() {
        int i3 = 1;
        for (int i4 = this.f85473b; i4 < this.f85474c; i4++) {
            i3 = (i3 * 31) + Ints.i(this.f85472a[i4]);
        }
        return i3;
    }

    public int i(int i3) {
        int i4;
        int i5 = this.f85474c;
        do {
            i5--;
            i4 = this.f85473b;
            if (i5 < i4) {
                return -1;
            }
        } while (this.f85472a[i5] != i3);
        return i5 - i4;
    }

    public int j() {
        return this.f85474c - this.f85473b;
    }

    public ImmutableIntArray l(int i3, int i4) {
        Preconditions.y(i3, i4, j());
        if (i3 == i4) {
            return f85471d;
        }
        int[] iArr = this.f85472a;
        int i5 = this.f85473b;
        return new ImmutableIntArray(iArr, i3 + i5, i5 + i4);
    }

    public int[] m() {
        return Arrays.copyOfRange(this.f85472a, this.f85473b, this.f85474c);
    }

    public ImmutableIntArray n() {
        return h() ? new ImmutableIntArray(m()) : this;
    }

    Object readResolve() {
        return g() ? f85471d : this;
    }

    public String toString() {
        if (g()) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder(j() * 5);
        sb.append('[');
        sb.append(this.f85472a[this.f85473b]);
        int i3 = this.f85473b;
        while (true) {
            i3++;
            if (i3 >= this.f85474c) {
                sb.append(']');
                return sb.toString();
            }
            sb.append(", ");
            sb.append(this.f85472a[i3]);
        }
    }

    Object writeReplace() {
        return n();
    }

    private ImmutableIntArray(int[] iArr, int i3, int i4) {
        this.f85472a = iArr;
        this.f85473b = i3;
        this.f85474c = i4;
    }
}
