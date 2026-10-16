package com.google.common.primitives;

import com.google.common.base.Converter;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.RandomAccess;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public final class Doubles extends DoublesMethodsForWeb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final Pattern f85453a = c();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class DoubleArrayAsList extends AbstractList<Double> implements RandomAccess, Serializable {
        private static final long serialVersionUID = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final double[] f85454a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final int f85455b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final int f85456c;

        DoubleArrayAsList(double[] dArr, int i3, int i4) {
            this.f85454a = dArr;
            this.f85455b = i3;
            this.f85456c = i4;
        }

        @Override // java.util.AbstractList, java.util.List
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Double get(int i3) {
            Preconditions.r(i3, size());
            return Double.valueOf(this.f85454a[this.f85455b + i3]);
        }

        @Override // java.util.AbstractList, java.util.List
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Double set(int i3, Double d3) {
            Preconditions.r(i3, size());
            double[] dArr = this.f85454a;
            int i4 = this.f85455b;
            double d4 = dArr[i4 + i3];
            dArr[i4 + i3] = ((Double) Preconditions.t(d3)).doubleValue();
            return Double.valueOf(d4);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean contains(Object obj) {
            return (obj instanceof Double) && Doubles.e(this.f85454a, ((Double) obj).doubleValue(), this.f85455b, this.f85456c) != -1;
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof DoubleArrayAsList)) {
                return super.equals(obj);
            }
            DoubleArrayAsList doubleArrayAsList = (DoubleArrayAsList) obj;
            int size = size();
            if (doubleArrayAsList.size() != size) {
                return false;
            }
            for (int i3 = 0; i3 < size; i3++) {
                if (this.f85454a[this.f85455b + i3] != doubleArrayAsList.f85454a[doubleArrayAsList.f85455b + i3]) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public int hashCode() {
            int iD = 1;
            for (int i3 = this.f85455b; i3 < this.f85456c; i3++) {
                iD = (iD * 31) + Doubles.d(this.f85454a[i3]);
            }
            return iD;
        }

        @Override // java.util.AbstractList, java.util.List
        public int indexOf(Object obj) {
            int iE;
            if (!(obj instanceof Double) || (iE = Doubles.e(this.f85454a, ((Double) obj).doubleValue(), this.f85455b, this.f85456c)) < 0) {
                return -1;
            }
            return iE - this.f85455b;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean isEmpty() {
            return false;
        }

        @Override // java.util.AbstractList, java.util.List
        public int lastIndexOf(Object obj) {
            int iF;
            if (!(obj instanceof Double) || (iF = Doubles.f(this.f85454a, ((Double) obj).doubleValue(), this.f85455b, this.f85456c)) < 0) {
                return -1;
            }
            return iF - this.f85455b;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f85456c - this.f85455b;
        }

        @Override // java.util.AbstractList, java.util.List
        public List subList(int i3, int i4) {
            Preconditions.y(i3, i4, size());
            if (i3 == i4) {
                return Collections.EMPTY_LIST;
            }
            double[] dArr = this.f85454a;
            int i5 = this.f85455b;
            return new DoubleArrayAsList(dArr, i3 + i5, i5 + i4);
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            StringBuilder sb = new StringBuilder(size() * 12);
            sb.append('[');
            sb.append(this.f85454a[this.f85455b]);
            int i3 = this.f85455b;
            while (true) {
                i3++;
                if (i3 >= this.f85456c) {
                    sb.append(']');
                    return sb.toString();
                }
                sb.append(", ");
                sb.append(this.f85454a[i3]);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class DoubleConverter extends Converter<String, Double> implements Serializable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final Converter f85457b = new DoubleConverter();
        private static final long serialVersionUID = 1;

        private DoubleConverter() {
        }

        private Object readResolve() {
            return f85457b;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.base.Converter
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public String d(Double d3) {
            return d3.toString();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.base.Converter
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public Double e(String str) {
            return Double.valueOf(str);
        }

        public String toString() {
            return "Doubles.stringConverter()";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private enum LexicographicalComparator implements Comparator<double[]> {
        INSTANCE;

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public int compare(double[] dArr, double[] dArr2) {
            int iMin = Math.min(dArr.length, dArr2.length);
            for (int i3 = 0; i3 < iMin; i3++) {
                int iCompare = Double.compare(dArr[i3], dArr2[i3]);
                if (iCompare != 0) {
                    return iCompare;
                }
            }
            return dArr.length - dArr2.length;
        }

        @Override // java.lang.Enum
        public String toString() {
            return "Doubles.lexicographicalComparator()";
        }
    }

    private static Pattern c() {
        return Pattern.compile(("[+-]?(?:NaN|Infinity|" + ("(?:\\d+#(?:\\.\\d*#)?|\\.\\d+#)(?:[eE][+-]?\\d+#)?[fFdD]?") + "|" + ("0[xX](?:[0-9a-fA-F]+#(?:\\.[0-9a-fA-F]*#)?|\\.[0-9a-fA-F]+#)[pP][+-]?\\d+#[fFdD]?") + ")").replace("#", "+"));
    }

    public static int d(double d3) {
        return Double.valueOf(d3).hashCode();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int e(double[] dArr, double d3, int i3, int i4) {
        while (i3 < i4) {
            if (dArr[i3] == d3) {
                return i3;
            }
            i3++;
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int f(double[] dArr, double d3, int i3, int i4) {
        for (int i5 = i4 - 1; i5 >= i3; i5--) {
            if (dArr[i5] == d3) {
                return i5;
            }
        }
        return -1;
    }
}
