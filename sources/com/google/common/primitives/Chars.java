package com.google.common.primitives;

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
public final class Chars {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class CharArrayAsList extends AbstractList<Character> implements RandomAccess, Serializable {
        private static final long serialVersionUID = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final char[] f85448a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final int f85449b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final int f85450c;

        CharArrayAsList(char[] cArr, int i3, int i4) {
            this.f85448a = cArr;
            this.f85449b = i3;
            this.f85450c = i4;
        }

        @Override // java.util.AbstractList, java.util.List
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Character get(int i3) {
            Preconditions.r(i3, size());
            return Character.valueOf(this.f85448a[this.f85449b + i3]);
        }

        @Override // java.util.AbstractList, java.util.List
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Character set(int i3, Character ch) {
            Preconditions.r(i3, size());
            char[] cArr = this.f85448a;
            int i4 = this.f85449b;
            char c3 = cArr[i4 + i3];
            cArr[i4 + i3] = ((Character) Preconditions.t(ch)).charValue();
            return Character.valueOf(c3);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean contains(Object obj) {
            return (obj instanceof Character) && Chars.e(this.f85448a, ((Character) obj).charValue(), this.f85449b, this.f85450c) != -1;
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof CharArrayAsList)) {
                return super.equals(obj);
            }
            CharArrayAsList charArrayAsList = (CharArrayAsList) obj;
            int size = size();
            if (charArrayAsList.size() != size) {
                return false;
            }
            for (int i3 = 0; i3 < size; i3++) {
                if (this.f85448a[this.f85449b + i3] != charArrayAsList.f85448a[charArrayAsList.f85449b + i3]) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public int hashCode() {
            int iD = 1;
            for (int i3 = this.f85449b; i3 < this.f85450c; i3++) {
                iD = (iD * 31) + Chars.d(this.f85448a[i3]);
            }
            return iD;
        }

        @Override // java.util.AbstractList, java.util.List
        public int indexOf(Object obj) {
            int iE;
            if (!(obj instanceof Character) || (iE = Chars.e(this.f85448a, ((Character) obj).charValue(), this.f85449b, this.f85450c)) < 0) {
                return -1;
            }
            return iE - this.f85449b;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean isEmpty() {
            return false;
        }

        @Override // java.util.AbstractList, java.util.List
        public int lastIndexOf(Object obj) {
            int iF;
            if (!(obj instanceof Character) || (iF = Chars.f(this.f85448a, ((Character) obj).charValue(), this.f85449b, this.f85450c)) < 0) {
                return -1;
            }
            return iF - this.f85449b;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f85450c - this.f85449b;
        }

        @Override // java.util.AbstractList, java.util.List
        public List subList(int i3, int i4) {
            Preconditions.y(i3, i4, size());
            if (i3 == i4) {
                return Collections.EMPTY_LIST;
            }
            char[] cArr = this.f85448a;
            int i5 = this.f85449b;
            return new CharArrayAsList(cArr, i3 + i5, i5 + i4);
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            StringBuilder sb = new StringBuilder(size() * 3);
            sb.append('[');
            sb.append(this.f85448a[this.f85449b]);
            int i3 = this.f85449b;
            while (true) {
                i3++;
                if (i3 >= this.f85450c) {
                    sb.append(']');
                    return sb.toString();
                }
                sb.append(", ");
                sb.append(this.f85448a[i3]);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private enum LexicographicalComparator implements Comparator<char[]> {
        INSTANCE;

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public int compare(char[] cArr, char[] cArr2) {
            int iMin = Math.min(cArr.length, cArr2.length);
            for (int i3 = 0; i3 < iMin; i3++) {
                int iCompare = Character.compare(cArr[i3], cArr2[i3]);
                if (iCompare != 0) {
                    return iCompare;
                }
            }
            return cArr.length - cArr2.length;
        }

        @Override // java.lang.Enum
        public String toString() {
            return "Chars.lexicographicalComparator()";
        }
    }

    public static boolean c(char[] cArr, char c3) {
        for (char c4 : cArr) {
            if (c4 == c3) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int e(char[] cArr, char c3, int i3, int i4) {
        while (i3 < i4) {
            if (cArr[i3] == c3) {
                return i3;
            }
            i3++;
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int f(char[] cArr, char c3, int i3, int i4) {
        for (int i5 = i4 - 1; i5 >= i3; i5--) {
            if (cArr[i5] == c3) {
                return i5;
            }
        }
        return -1;
    }

    public static int d(char c3) {
        return c3;
    }
}
