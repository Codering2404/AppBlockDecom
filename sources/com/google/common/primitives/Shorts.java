package com.google.common.primitives;

import com.google.common.base.Converter;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public final class Shorts extends ShortsMethodsForWeb {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private enum LexicographicalComparator implements Comparator<short[]> {
        INSTANCE;

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public int compare(short[] sArr, short[] sArr2) {
            int iMin = Math.min(sArr.length, sArr2.length);
            for (int i3 = 0; i3 < iMin; i3++) {
                int iCompare = Short.compare(sArr[i3], sArr2[i3]);
                if (iCompare != 0) {
                    return iCompare;
                }
            }
            return sArr.length - sArr2.length;
        }

        @Override // java.lang.Enum
        public String toString() {
            return "Shorts.lexicographicalComparator()";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class ShortArrayAsList extends AbstractList<Short> implements RandomAccess, Serializable {
        private static final long serialVersionUID = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final short[] f85500a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final int f85501b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final int f85502c;

        ShortArrayAsList(short[] sArr, int i3, int i4) {
            this.f85500a = sArr;
            this.f85501b = i3;
            this.f85502c = i4;
        }

        @Override // java.util.AbstractList, java.util.List
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Short get(int i3) {
            Preconditions.r(i3, size());
            return Short.valueOf(this.f85500a[this.f85501b + i3]);
        }

        @Override // java.util.AbstractList, java.util.List
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Short set(int i3, Short sh) {
            Preconditions.r(i3, size());
            short[] sArr = this.f85500a;
            int i4 = this.f85501b;
            short s2 = sArr[i4 + i3];
            sArr[i4 + i3] = ((Short) Preconditions.t(sh)).shortValue();
            return Short.valueOf(s2);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean contains(Object obj) {
            return (obj instanceof Short) && Shorts.d(this.f85500a, ((Short) obj).shortValue(), this.f85501b, this.f85502c) != -1;
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof ShortArrayAsList)) {
                return super.equals(obj);
            }
            ShortArrayAsList shortArrayAsList = (ShortArrayAsList) obj;
            int size = size();
            if (shortArrayAsList.size() != size) {
                return false;
            }
            for (int i3 = 0; i3 < size; i3++) {
                if (this.f85500a[this.f85501b + i3] != shortArrayAsList.f85500a[shortArrayAsList.f85501b + i3]) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public int hashCode() {
            int iC = 1;
            for (int i3 = this.f85501b; i3 < this.f85502c; i3++) {
                iC = (iC * 31) + Shorts.c(this.f85500a[i3]);
            }
            return iC;
        }

        @Override // java.util.AbstractList, java.util.List
        public int indexOf(Object obj) {
            int iD;
            if (!(obj instanceof Short) || (iD = Shorts.d(this.f85500a, ((Short) obj).shortValue(), this.f85501b, this.f85502c)) < 0) {
                return -1;
            }
            return iD - this.f85501b;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean isEmpty() {
            return false;
        }

        @Override // java.util.AbstractList, java.util.List
        public int lastIndexOf(Object obj) {
            int iE;
            if (!(obj instanceof Short) || (iE = Shorts.e(this.f85500a, ((Short) obj).shortValue(), this.f85501b, this.f85502c)) < 0) {
                return -1;
            }
            return iE - this.f85501b;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f85502c - this.f85501b;
        }

        @Override // java.util.AbstractList, java.util.List
        public List subList(int i3, int i4) {
            Preconditions.y(i3, i4, size());
            if (i3 == i4) {
                return Collections.EMPTY_LIST;
            }
            short[] sArr = this.f85500a;
            int i5 = this.f85501b;
            return new ShortArrayAsList(sArr, i3 + i5, i5 + i4);
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            StringBuilder sb = new StringBuilder(size() * 6);
            sb.append('[');
            sb.append((int) this.f85500a[this.f85501b]);
            int i3 = this.f85501b;
            while (true) {
                i3++;
                if (i3 >= this.f85502c) {
                    sb.append(']');
                    return sb.toString();
                }
                sb.append(", ");
                sb.append((int) this.f85500a[i3]);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class ShortConverter extends Converter<String, Short> implements Serializable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final Converter f85503b = new ShortConverter();
        private static final long serialVersionUID = 1;

        private ShortConverter() {
        }

        private Object readResolve() {
            return f85503b;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.base.Converter
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public String d(Short sh) {
            return sh.toString();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.base.Converter
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public Short e(String str) {
            return Short.decode(str);
        }

        public String toString() {
            return "Shorts.stringConverter()";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int d(short[] sArr, short s2, int i3, int i4) {
        while (i3 < i4) {
            if (sArr[i3] == s2) {
                return i3;
            }
            i3++;
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int e(short[] sArr, short s2, int i3, int i4) {
        for (int i5 = i4 - 1; i5 >= i3; i5--) {
            if (sArr[i5] == s2) {
                return i5;
            }
        }
        return -1;
    }

    public static int c(short s2) {
        return s2;
    }
}
