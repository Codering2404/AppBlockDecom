package com.google.common.primitives;

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
public final class Floats extends FloatsMethodsForWeb {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class FloatArrayAsList extends AbstractList<Float> implements RandomAccess, Serializable {
        private static final long serialVersionUID = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final float[] f85460a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final int f85461b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final int f85462c;

        FloatArrayAsList(float[] fArr, int i3, int i4) {
            this.f85460a = fArr;
            this.f85461b = i3;
            this.f85462c = i4;
        }

        @Override // java.util.AbstractList, java.util.List
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(int i3) {
            Preconditions.r(i3, size());
            return Float.valueOf(this.f85460a[this.f85461b + i3]);
        }

        @Override // java.util.AbstractList, java.util.List
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Float set(int i3, Float f3) {
            Preconditions.r(i3, size());
            float[] fArr = this.f85460a;
            int i4 = this.f85461b;
            float f4 = fArr[i4 + i3];
            fArr[i4 + i3] = ((Float) Preconditions.t(f3)).floatValue();
            return Float.valueOf(f4);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean contains(Object obj) {
            return (obj instanceof Float) && Floats.d(this.f85460a, ((Float) obj).floatValue(), this.f85461b, this.f85462c) != -1;
        }

        float[] d() {
            return Arrays.copyOfRange(this.f85460a, this.f85461b, this.f85462c);
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof FloatArrayAsList)) {
                return super.equals(obj);
            }
            FloatArrayAsList floatArrayAsList = (FloatArrayAsList) obj;
            int size = size();
            if (floatArrayAsList.size() != size) {
                return false;
            }
            for (int i3 = 0; i3 < size; i3++) {
                if (this.f85460a[this.f85461b + i3] != floatArrayAsList.f85460a[floatArrayAsList.f85461b + i3]) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public int hashCode() {
            int iC = 1;
            for (int i3 = this.f85461b; i3 < this.f85462c; i3++) {
                iC = (iC * 31) + Floats.c(this.f85460a[i3]);
            }
            return iC;
        }

        @Override // java.util.AbstractList, java.util.List
        public int indexOf(Object obj) {
            int iD;
            if (!(obj instanceof Float) || (iD = Floats.d(this.f85460a, ((Float) obj).floatValue(), this.f85461b, this.f85462c)) < 0) {
                return -1;
            }
            return iD - this.f85461b;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean isEmpty() {
            return false;
        }

        @Override // java.util.AbstractList, java.util.List
        public int lastIndexOf(Object obj) {
            int iE;
            if (!(obj instanceof Float) || (iE = Floats.e(this.f85460a, ((Float) obj).floatValue(), this.f85461b, this.f85462c)) < 0) {
                return -1;
            }
            return iE - this.f85461b;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f85462c - this.f85461b;
        }

        @Override // java.util.AbstractList, java.util.List
        public List subList(int i3, int i4) {
            Preconditions.y(i3, i4, size());
            if (i3 == i4) {
                return Collections.EMPTY_LIST;
            }
            float[] fArr = this.f85460a;
            int i5 = this.f85461b;
            return new FloatArrayAsList(fArr, i3 + i5, i5 + i4);
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            StringBuilder sb = new StringBuilder(size() * 12);
            sb.append('[');
            sb.append(this.f85460a[this.f85461b]);
            int i3 = this.f85461b;
            while (true) {
                i3++;
                if (i3 >= this.f85462c) {
                    sb.append(']');
                    return sb.toString();
                }
                sb.append(", ");
                sb.append(this.f85460a[i3]);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class FloatConverter extends Converter<String, Float> implements Serializable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final Converter f85463b = new FloatConverter();
        private static final long serialVersionUID = 1;

        private FloatConverter() {
        }

        private Object readResolve() {
            return f85463b;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.base.Converter
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public String d(Float f3) {
            return f3.toString();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.base.Converter
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public Float e(String str) {
            return Float.valueOf(str);
        }

        public String toString() {
            return "Floats.stringConverter()";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private enum LexicographicalComparator implements Comparator<float[]> {
        INSTANCE;

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public int compare(float[] fArr, float[] fArr2) {
            int iMin = Math.min(fArr.length, fArr2.length);
            for (int i3 = 0; i3 < iMin; i3++) {
                int iCompare = Float.compare(fArr[i3], fArr2[i3]);
                if (iCompare != 0) {
                    return iCompare;
                }
            }
            return fArr.length - fArr2.length;
        }

        @Override // java.lang.Enum
        public String toString() {
            return "Floats.lexicographicalComparator()";
        }
    }

    public static int c(float f3) {
        return Float.valueOf(f3).hashCode();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int d(float[] fArr, float f3, int i3, int i4) {
        while (i3 < i4) {
            if (fArr[i3] == f3) {
                return i3;
            }
            i3++;
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int e(float[] fArr, float f3, int i3, int i4) {
        for (int i5 = i4 - 1; i5 >= i3; i5--) {
            if (fArr[i5] == f3) {
                return i5;
            }
        }
        return -1;
    }

    public static float[] f(Collection collection) {
        if (collection instanceof FloatArrayAsList) {
            return ((FloatArrayAsList) collection).d();
        }
        Object[] array = collection.toArray();
        int length = array.length;
        float[] fArr = new float[length];
        for (int i3 = 0; i3 < length; i3++) {
            fArr[i3] = ((Number) Preconditions.t(array[i3])).floatValue();
        }
        return fArr;
    }
}
