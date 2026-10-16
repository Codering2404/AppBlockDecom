package com.google.common.primitives;

import com.applovin.exoplayer2.common.base.Ascii;
import com.google.android.gms.common.api.Api;
import com.google.common.base.Converter;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public final class Ints extends IntsMethodsForWeb {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class IntArrayAsList extends AbstractList<Integer> implements RandomAccess, Serializable {
        private static final long serialVersionUID = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final int[] f85483a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final int f85484b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final int f85485c;

        IntArrayAsList(int[] iArr) {
            this(iArr, 0, iArr.length);
        }

        @Override // java.util.AbstractList, java.util.List
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Integer get(int i3) {
            Preconditions.r(i3, size());
            return Integer.valueOf(this.f85483a[this.f85484b + i3]);
        }

        @Override // java.util.AbstractList, java.util.List
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Integer set(int i3, Integer num) {
            Preconditions.r(i3, size());
            int[] iArr = this.f85483a;
            int i4 = this.f85484b;
            int i5 = iArr[i4 + i3];
            iArr[i4 + i3] = ((Integer) Preconditions.t(num)).intValue();
            return Integer.valueOf(i5);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean contains(Object obj) {
            return (obj instanceof Integer) && Ints.j(this.f85483a, ((Integer) obj).intValue(), this.f85484b, this.f85485c) != -1;
        }

        int[] d() {
            return Arrays.copyOfRange(this.f85483a, this.f85484b, this.f85485c);
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof IntArrayAsList)) {
                return super.equals(obj);
            }
            IntArrayAsList intArrayAsList = (IntArrayAsList) obj;
            int size = size();
            if (intArrayAsList.size() != size) {
                return false;
            }
            for (int i3 = 0; i3 < size; i3++) {
                if (this.f85483a[this.f85484b + i3] != intArrayAsList.f85483a[intArrayAsList.f85484b + i3]) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public int hashCode() {
            int i3 = 1;
            for (int i4 = this.f85484b; i4 < this.f85485c; i4++) {
                i3 = (i3 * 31) + Ints.i(this.f85483a[i4]);
            }
            return i3;
        }

        @Override // java.util.AbstractList, java.util.List
        public int indexOf(Object obj) {
            int iJ;
            if (!(obj instanceof Integer) || (iJ = Ints.j(this.f85483a, ((Integer) obj).intValue(), this.f85484b, this.f85485c)) < 0) {
                return -1;
            }
            return iJ - this.f85484b;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean isEmpty() {
            return false;
        }

        @Override // java.util.AbstractList, java.util.List
        public int lastIndexOf(Object obj) {
            int iK;
            if (!(obj instanceof Integer) || (iK = Ints.k(this.f85483a, ((Integer) obj).intValue(), this.f85484b, this.f85485c)) < 0) {
                return -1;
            }
            return iK - this.f85484b;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f85485c - this.f85484b;
        }

        @Override // java.util.AbstractList, java.util.List
        public List subList(int i3, int i4) {
            Preconditions.y(i3, i4, size());
            if (i3 == i4) {
                return Collections.EMPTY_LIST;
            }
            int[] iArr = this.f85483a;
            int i5 = this.f85484b;
            return new IntArrayAsList(iArr, i3 + i5, i5 + i4);
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            StringBuilder sb = new StringBuilder(size() * 5);
            sb.append('[');
            sb.append(this.f85483a[this.f85484b]);
            int i3 = this.f85484b;
            while (true) {
                i3++;
                if (i3 >= this.f85485c) {
                    sb.append(']');
                    return sb.toString();
                }
                sb.append(", ");
                sb.append(this.f85483a[i3]);
            }
        }

        IntArrayAsList(int[] iArr, int i3, int i4) {
            this.f85483a = iArr;
            this.f85484b = i3;
            this.f85485c = i4;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class IntConverter extends Converter<String, Integer> implements Serializable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final Converter f85486b = new IntConverter();
        private static final long serialVersionUID = 1;

        private IntConverter() {
        }

        private Object readResolve() {
            return f85486b;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.base.Converter
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public String d(Integer num) {
            return num.toString();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.base.Converter
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public Integer e(String str) {
            return Integer.decode(str);
        }

        public String toString() {
            return "Ints.stringConverter()";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private enum LexicographicalComparator implements Comparator<int[]> {
        INSTANCE;

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public int compare(int[] iArr, int[] iArr2) {
            int iMin = Math.min(iArr.length, iArr2.length);
            for (int i3 = 0; i3 < iMin; i3++) {
                int iCompare = Integer.compare(iArr[i3], iArr2[i3]);
                if (iCompare != 0) {
                    return iCompare;
                }
            }
            return iArr.length - iArr2.length;
        }

        @Override // java.lang.Enum
        public String toString() {
            return "Ints.lexicographicalComparator()";
        }
    }

    public static List c(int... iArr) {
        return iArr.length == 0 ? Collections.EMPTY_LIST : new IntArrayAsList(iArr);
    }

    public static int d(long j3) {
        int i3 = (int) j3;
        Preconditions.k(((long) i3) == j3, "Out of range: %s", j3);
        return i3;
    }

    public static int e(int i3, int i4) {
        return Integer.compare(i3, i4);
    }

    public static int f(int i3, int i4, int i5) {
        Preconditions.i(i4 <= i5, "min (%s) must be less than or equal to max (%s)", i4, i5);
        return Math.min(Math.max(i3, i4), i5);
    }

    public static int g(byte[] bArr) {
        Preconditions.i(bArr.length >= 4, "array too small: %s < %s", bArr.length, 4);
        return h(bArr[0], bArr[1], bArr[2], bArr[3]);
    }

    public static int h(byte b3, byte b4, byte b5, byte b6) {
        return (b3 << Ascii.CAN) | ((b4 & 255) << 16) | ((b5 & 255) << 8) | (b6 & 255);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int j(int[] iArr, int i3, int i4, int i5) {
        while (i4 < i5) {
            if (iArr[i4] == i3) {
                return i4;
            }
            i4++;
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int k(int[] iArr, int i3, int i4, int i5) {
        for (int i6 = i5 - 1; i6 >= i4; i6--) {
            if (iArr[i6] == i3) {
                return i6;
            }
        }
        return -1;
    }

    public static int l(int... iArr) {
        Preconditions.d(iArr.length > 0);
        int i3 = iArr[0];
        for (int i4 = 1; i4 < iArr.length; i4++) {
            int i5 = iArr[i4];
            if (i5 < i3) {
                i3 = i5;
            }
        }
        return i3;
    }

    public static int m(long j3) {
        if (j3 > 2147483647L) {
            return Api.BaseClientBuilder.API_PRIORITY_OTHER;
        }
        if (j3 < -2147483648L) {
            return Integer.MIN_VALUE;
        }
        return (int) j3;
    }

    public static int[] n(Collection collection) {
        if (collection instanceof IntArrayAsList) {
            return ((IntArrayAsList) collection).d();
        }
        Object[] array = collection.toArray();
        int length = array.length;
        int[] iArr = new int[length];
        for (int i3 = 0; i3 < length; i3++) {
            iArr[i3] = ((Number) Preconditions.t(array[i3])).intValue();
        }
        return iArr;
    }

    public static Integer o(String str) {
        return p(str, 10);
    }

    public static Integer p(String str, int i3) {
        Long lK = Longs.k(str, i3);
        if (lK == null || lK.longValue() != lK.intValue()) {
            return null;
        }
        return Integer.valueOf(lK.intValue());
    }

    public static int i(int i3) {
        return i3;
    }
}
