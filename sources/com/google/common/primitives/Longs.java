package com.google.common.primitives;

import com.google.common.base.Converter;
import com.google.common.base.Preconditions;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public final class Longs {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class AsciiDigits {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final byte[] f85489a;

        static {
            byte[] bArr = new byte[ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD];
            Arrays.fill(bArr, (byte) -1);
            for (int i3 = 0; i3 < 10; i3++) {
                bArr[i3 + 48] = (byte) i3;
            }
            for (int i4 = 0; i4 < 26; i4++) {
                byte b3 = (byte) (i4 + 10);
                bArr[i4 + 65] = b3;
                bArr[i4 + 97] = b3;
            }
            f85489a = bArr;
        }

        static int a(char c3) {
            if (c3 < 128) {
                return f85489a[c3];
            }
            return -1;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private enum LexicographicalComparator implements Comparator<long[]> {
        INSTANCE;

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public int compare(long[] jArr, long[] jArr2) {
            int iMin = Math.min(jArr.length, jArr2.length);
            for (int i3 = 0; i3 < iMin; i3++) {
                int iCompare = Long.compare(jArr[i3], jArr2[i3]);
                if (iCompare != 0) {
                    return iCompare;
                }
            }
            return jArr.length - jArr2.length;
        }

        @Override // java.lang.Enum
        public String toString() {
            return "Longs.lexicographicalComparator()";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class LongArrayAsList extends AbstractList<Long> implements RandomAccess, Serializable {
        private static final long serialVersionUID = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final long[] f85492a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final int f85493b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final int f85494c;

        LongArrayAsList(long[] jArr, int i3, int i4) {
            this.f85492a = jArr;
            this.f85493b = i3;
            this.f85494c = i4;
        }

        @Override // java.util.AbstractList, java.util.List
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Long get(int i3) {
            Preconditions.r(i3, size());
            return Long.valueOf(this.f85492a[this.f85493b + i3]);
        }

        @Override // java.util.AbstractList, java.util.List
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Long set(int i3, Long l3) {
            Preconditions.r(i3, size());
            long[] jArr = this.f85492a;
            int i4 = this.f85493b;
            long j3 = jArr[i4 + i3];
            jArr[i4 + i3] = ((Long) Preconditions.t(l3)).longValue();
            return Long.valueOf(j3);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean contains(Object obj) {
            return (obj instanceof Long) && Longs.f(this.f85492a, ((Long) obj).longValue(), this.f85493b, this.f85494c) != -1;
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof LongArrayAsList)) {
                return super.equals(obj);
            }
            LongArrayAsList longArrayAsList = (LongArrayAsList) obj;
            int size = size();
            if (longArrayAsList.size() != size) {
                return false;
            }
            for (int i3 = 0; i3 < size; i3++) {
                if (this.f85492a[this.f85493b + i3] != longArrayAsList.f85492a[longArrayAsList.f85493b + i3]) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public int hashCode() {
            int iE = 1;
            for (int i3 = this.f85493b; i3 < this.f85494c; i3++) {
                iE = (iE * 31) + Longs.e(this.f85492a[i3]);
            }
            return iE;
        }

        @Override // java.util.AbstractList, java.util.List
        public int indexOf(Object obj) {
            int iF;
            if (!(obj instanceof Long) || (iF = Longs.f(this.f85492a, ((Long) obj).longValue(), this.f85493b, this.f85494c)) < 0) {
                return -1;
            }
            return iF - this.f85493b;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean isEmpty() {
            return false;
        }

        @Override // java.util.AbstractList, java.util.List
        public int lastIndexOf(Object obj) {
            int iG;
            if (!(obj instanceof Long) || (iG = Longs.g(this.f85492a, ((Long) obj).longValue(), this.f85493b, this.f85494c)) < 0) {
                return -1;
            }
            return iG - this.f85493b;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f85494c - this.f85493b;
        }

        @Override // java.util.AbstractList, java.util.List
        public List subList(int i3, int i4) {
            Preconditions.y(i3, i4, size());
            if (i3 == i4) {
                return Collections.EMPTY_LIST;
            }
            long[] jArr = this.f85492a;
            int i5 = this.f85493b;
            return new LongArrayAsList(jArr, i3 + i5, i5 + i4);
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            StringBuilder sb = new StringBuilder(size() * 10);
            sb.append('[');
            sb.append(this.f85492a[this.f85493b]);
            int i3 = this.f85493b;
            while (true) {
                i3++;
                if (i3 >= this.f85494c) {
                    sb.append(']');
                    return sb.toString();
                }
                sb.append(", ");
                sb.append(this.f85492a[i3]);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class LongConverter extends Converter<String, Long> implements Serializable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final Converter f85495b = new LongConverter();
        private static final long serialVersionUID = 1;

        private LongConverter() {
        }

        private Object readResolve() {
            return f85495b;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.base.Converter
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public String d(Long l3) {
            return l3.toString();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.base.Converter
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public Long e(String str) {
            return Long.decode(str);
        }

        public String toString() {
            return "Longs.stringConverter()";
        }
    }

    public static int c(long j3, long j4) {
        return Long.compare(j3, j4);
    }

    public static long d(byte b3, byte b4, byte b5, byte b6, byte b7, byte b8, byte b9, byte b10) {
        return ((((long) b4) & 255) << 48) | ((((long) b3) & 255) << 56) | ((((long) b5) & 255) << 40) | ((((long) b6) & 255) << 32) | ((((long) b7) & 255) << 24) | ((((long) b8) & 255) << 16) | ((((long) b9) & 255) << 8) | (((long) b10) & 255);
    }

    public static int e(long j3) {
        return (int) (j3 ^ (j3 >>> 32));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int f(long[] jArr, long j3, int i3, int i4) {
        while (i3 < i4) {
            if (jArr[i3] == j3) {
                return i3;
            }
            i3++;
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int g(long[] jArr, long j3, int i3, int i4) {
        for (int i5 = i4 - 1; i5 >= i3; i5--) {
            if (jArr[i5] == j3) {
                return i5;
            }
        }
        return -1;
    }

    public static long h(long... jArr) {
        Preconditions.d(jArr.length > 0);
        long j3 = jArr[0];
        for (int i3 = 1; i3 < jArr.length; i3++) {
            long j4 = jArr[i3];
            if (j4 > j3) {
                j3 = j4;
            }
        }
        return j3;
    }

    public static long i(long... jArr) {
        Preconditions.d(jArr.length > 0);
        long j3 = jArr[0];
        for (int i3 = 1; i3 < jArr.length; i3++) {
            long j4 = jArr[i3];
            if (j4 < j3) {
                j3 = j4;
            }
        }
        return j3;
    }

    public static byte[] j(long j3) {
        byte[] bArr = new byte[8];
        for (int i3 = 7; i3 >= 0; i3--) {
            bArr[i3] = (byte) (255 & j3);
            j3 >>= 8;
        }
        return bArr;
    }

    public static Long k(String str, int i3) {
        if (((String) Preconditions.t(str)).isEmpty()) {
            return null;
        }
        if (i3 < 2 || i3 > 36) {
            throw new IllegalArgumentException("radix must be between MIN_RADIX and MAX_RADIX but was " + i3);
        }
        int i4 = str.charAt(0) == '-' ? 1 : 0;
        if (i4 == str.length()) {
            return null;
        }
        int i5 = i4 + 1;
        int iA = AsciiDigits.a(str.charAt(i4));
        if (iA < 0 || iA >= i3) {
            return null;
        }
        long j3 = -iA;
        long j4 = i3;
        long j5 = Long.MIN_VALUE / j4;
        while (i5 < str.length()) {
            int i6 = i5 + 1;
            int iA2 = AsciiDigits.a(str.charAt(i5));
            if (iA2 < 0 || iA2 >= i3 || j3 < j5) {
                return null;
            }
            long j6 = j3 * j4;
            long j7 = iA2;
            if (j6 < j7 - Long.MIN_VALUE) {
                return null;
            }
            j3 = j6 - j7;
            i5 = i6;
        }
        if (i4 != 0) {
            return Long.valueOf(j3);
        }
        if (j3 == Long.MIN_VALUE) {
            return null;
        }
        return Long.valueOf(-j3);
    }
}
