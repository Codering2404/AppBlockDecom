package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.Internal;
import com.google.android.gms.common.api.Api;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class DoubleArrayList extends AbstractProtobufList<Double> implements Internal.DoubleList, RandomAccess, PrimitiveNonBoxingCollection {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final DoubleArrayList f36275d = new DoubleArrayList(new double[0], 0, false);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private double[] f36276b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f36277c;

    DoubleArrayList() {
        this(new double[10], 0, true);
    }

    private void f(int i3, double d3) {
        int i4;
        a();
        if (i3 < 0 || i3 > (i4 = this.f36277c)) {
            throw new IndexOutOfBoundsException(n(i3));
        }
        double[] dArr = this.f36276b;
        if (i4 < dArr.length) {
            System.arraycopy(dArr, i3, dArr, i3 + 1, i4 - i3);
        } else {
            double[] dArr2 = new double[((i4 * 3) / 2) + 1];
            System.arraycopy(dArr, 0, dArr2, 0, i3);
            System.arraycopy(this.f36276b, i3, dArr2, i3 + 1, this.f36277c - i3);
            this.f36276b = dArr2;
        }
        this.f36276b[i3] = d3;
        this.f36277c++;
        ((AbstractList) this).modCount++;
    }

    private void g(int i3) {
        if (i3 < 0 || i3 >= this.f36277c) {
            throw new IndexOutOfBoundsException(n(i3));
        }
    }

    private String n(int i3) {
        return "Index:" + i3 + ", Size:" + this.f36277c;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractProtobufList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection collection) {
        a();
        Internal.a(collection);
        if (!(collection instanceof DoubleArrayList)) {
            return super.addAll(collection);
        }
        DoubleArrayList doubleArrayList = (DoubleArrayList) collection;
        int i3 = doubleArrayList.f36277c;
        if (i3 == 0) {
            return false;
        }
        int i4 = this.f36277c;
        if (Api.BaseClientBuilder.API_PRIORITY_OTHER - i4 < i3) {
            throw new OutOfMemoryError();
        }
        int i5 = i4 + i3;
        double[] dArr = this.f36276b;
        if (i5 > dArr.length) {
            this.f36276b = Arrays.copyOf(dArr, i5);
        }
        System.arraycopy(doubleArrayList.f36276b, 0, this.f36276b, this.f36277c, doubleArrayList.f36277c);
        this.f36277c = i5;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void add(int i3, Double d3) {
        f(i3, d3.doubleValue());
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean add(Double d3) {
        e(d3.doubleValue());
        return true;
    }

    public void e(double d3) {
        a();
        int i3 = this.f36277c;
        double[] dArr = this.f36276b;
        if (i3 == dArr.length) {
            double[] dArr2 = new double[((i3 * 3) / 2) + 1];
            System.arraycopy(dArr, 0, dArr2, 0, i3);
            this.f36276b = dArr2;
        }
        double[] dArr3 = this.f36276b;
        int i4 = this.f36277c;
        this.f36277c = i4 + 1;
        dArr3[i4] = d3;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DoubleArrayList)) {
            return super.equals(obj);
        }
        DoubleArrayList doubleArrayList = (DoubleArrayList) obj;
        if (this.f36277c != doubleArrayList.f36277c) {
            return false;
        }
        double[] dArr = doubleArrayList.f36276b;
        for (int i3 = 0; i3 < this.f36277c; i3++) {
            if (Double.doubleToLongBits(this.f36276b[i3]) != Double.doubleToLongBits(dArr[i3])) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public Double get(int i3) {
        return Double.valueOf(l(i3));
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        int iF = 1;
        for (int i3 = 0; i3 < this.f36277c; i3++) {
            iF = (iF * 31) + Internal.f(Double.doubleToLongBits(this.f36276b[i3]));
        }
        return iF;
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object obj) {
        if (!(obj instanceof Double)) {
            return -1;
        }
        double dDoubleValue = ((Double) obj).doubleValue();
        int size = size();
        for (int i3 = 0; i3 < size; i3++) {
            if (this.f36276b[i3] == dDoubleValue) {
                return i3;
            }
        }
        return -1;
    }

    public double l(int i3) {
        g(i3);
        return this.f36276b[i3];
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public Double remove(int i3) {
        a();
        g(i3);
        double[] dArr = this.f36276b;
        double d3 = dArr[i3];
        if (i3 < this.f36277c - 1) {
            System.arraycopy(dArr, i3 + 1, dArr, i3, (r3 - i3) - 1);
        }
        this.f36277c--;
        ((AbstractList) this).modCount++;
        return Double.valueOf(d3);
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public Double set(int i3, Double d3) {
        return Double.valueOf(q(i3, d3.doubleValue()));
    }

    public double q(int i3, double d3) {
        a();
        g(i3);
        double[] dArr = this.f36276b;
        double d4 = dArr[i3];
        dArr[i3] = d3;
        return d4;
    }

    @Override // java.util.AbstractList
    protected void removeRange(int i3, int i4) {
        a();
        if (i4 < i3) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        double[] dArr = this.f36276b;
        System.arraycopy(dArr, i4, dArr, i3, this.f36277c - i4);
        this.f36277c -= i4 - i3;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f36277c;
    }

    private DoubleArrayList(double[] dArr, int i3, boolean z2) {
        super(z2);
        this.f36276b = dArr;
        this.f36277c = i3;
    }

    @Override // androidx.datastore.preferences.protobuf.Internal.ProtobufList, androidx.datastore.preferences.protobuf.Internal.BooleanList
    public Internal.DoubleList c(int i3) {
        if (i3 >= this.f36277c) {
            return new DoubleArrayList(Arrays.copyOf(this.f36276b, i3), this.f36277c, true);
        }
        throw new IllegalArgumentException();
    }
}
