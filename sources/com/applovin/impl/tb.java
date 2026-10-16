package com.applovin.impl;

import com.applovin.exoplayer2.common.base.Preconditions;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class tb {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class a extends AbstractList implements RandomAccess, Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final int[] f63919a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final int f63920b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final int f63921c;

        a(int[] iArr) {
            this(iArr, 0, iArr.length);
        }

        int[] a() {
            return Arrays.copyOfRange(this.f63919a, this.f63920b, this.f63921c);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean contains(Object obj) {
            return (obj instanceof Integer) && tb.c(this.f63919a, ((Integer) obj).intValue(), this.f63920b, this.f63921c) != -1;
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof a)) {
                return super.equals(obj);
            }
            a aVar = (a) obj;
            int size = size();
            if (aVar.size() != size) {
                return false;
            }
            for (int i3 = 0; i3 < size; i3++) {
                if (this.f63919a[this.f63920b + i3] != aVar.f63919a[aVar.f63920b + i3]) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.AbstractList, java.util.List
        public Integer get(int i3) {
            Preconditions.checkElementIndex(i3, size());
            return Integer.valueOf(this.f63919a[this.f63920b + i3]);
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public int hashCode() {
            int iA = 1;
            for (int i3 = this.f63920b; i3 < this.f63921c; i3++) {
                iA = (iA * 31) + tb.a(this.f63919a[i3]);
            }
            return iA;
        }

        @Override // java.util.AbstractList, java.util.List
        public int indexOf(Object obj) {
            int iC;
            if (!(obj instanceof Integer) || (iC = tb.c(this.f63919a, ((Integer) obj).intValue(), this.f63920b, this.f63921c)) < 0) {
                return -1;
            }
            return iC - this.f63920b;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean isEmpty() {
            return false;
        }

        @Override // java.util.AbstractList, java.util.List
        public int lastIndexOf(Object obj) {
            int iD;
            if (!(obj instanceof Integer) || (iD = tb.d(this.f63919a, ((Integer) obj).intValue(), this.f63920b, this.f63921c)) < 0) {
                return -1;
            }
            return iD - this.f63920b;
        }

        @Override // java.util.AbstractList, java.util.List
        public Integer set(int i3, Integer num) {
            Preconditions.checkElementIndex(i3, size());
            int[] iArr = this.f63919a;
            int i4 = this.f63920b + i3;
            int i5 = iArr[i4];
            iArr[i4] = ((Integer) Preconditions.checkNotNull(num)).intValue();
            return Integer.valueOf(i5);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f63921c - this.f63920b;
        }

        @Override // java.util.AbstractList, java.util.List
        public List subList(int i3, int i4) {
            Preconditions.checkPositionIndexes(i3, i4, size());
            if (i3 == i4) {
                return Collections.EMPTY_LIST;
            }
            int[] iArr = this.f63919a;
            int i5 = this.f63920b;
            return new a(iArr, i3 + i5, i5 + i4);
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            StringBuilder sb = new StringBuilder(size() * 5);
            sb.append('[');
            sb.append(this.f63919a[this.f63920b]);
            int i3 = this.f63920b;
            while (true) {
                i3++;
                if (i3 >= this.f63921c) {
                    sb.append(']');
                    return sb.toString();
                }
                sb.append(", ");
                sb.append(this.f63919a[i3]);
            }
        }

        a(int[] iArr, int i3, int i4) {
            this.f63919a = iArr;
            this.f63920b = i3;
            this.f63921c = i4;
        }
    }

    public static int a(int i3) {
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int c(int[] iArr, int i3, int i4, int i5) {
        while (i4 < i5) {
            if (iArr[i4] == i3) {
                return i4;
            }
            i4++;
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int d(int[] iArr, int i3, int i4, int i5) {
        for (int i6 = i5 - 1; i6 >= i4; i6--) {
            if (iArr[i6] == i3) {
                return i6;
            }
        }
        return -1;
    }

    public static int a(int i3, int i4) {
        if (i3 < i4) {
            return -1;
        }
        return i3 > i4 ? 1 : 0;
    }

    public static List a(int... iArr) {
        if (iArr.length == 0) {
            return Collections.EMPTY_LIST;
        }
        return new a(iArr);
    }

    public static int a(long j3) {
        int i3 = (int) j3;
        Preconditions.checkArgument(((long) i3) == j3, "Out of range: %s", j3);
        return i3;
    }

    public static int[] a(Collection collection) {
        if (collection instanceof a) {
            return ((a) collection).a();
        }
        Object[] array = collection.toArray();
        int length = array.length;
        int[] iArr = new int[length];
        for (int i3 = 0; i3 < length; i3++) {
            iArr[i3] = ((Number) Preconditions.checkNotNull(array[i3])).intValue();
        }
        return iArr;
    }
}
