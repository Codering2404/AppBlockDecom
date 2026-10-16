package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.Internal;
import com.google.android.gms.common.api.Api;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class FloatArrayList extends AbstractProtobufList<Float> implements Internal.FloatList, RandomAccess, PrimitiveNonBoxingCollection {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final FloatArrayList f36389d = new FloatArrayList(new float[0], 0, false);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private float[] f36390b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f36391c;

    FloatArrayList() {
        this(new float[10], 0, true);
    }

    private void f(int i3, float f3) {
        int i4;
        a();
        if (i3 < 0 || i3 > (i4 = this.f36391c)) {
            throw new IndexOutOfBoundsException(n(i3));
        }
        float[] fArr = this.f36390b;
        if (i4 < fArr.length) {
            System.arraycopy(fArr, i3, fArr, i3 + 1, i4 - i3);
        } else {
            float[] fArr2 = new float[((i4 * 3) / 2) + 1];
            System.arraycopy(fArr, 0, fArr2, 0, i3);
            System.arraycopy(this.f36390b, i3, fArr2, i3 + 1, this.f36391c - i3);
            this.f36390b = fArr2;
        }
        this.f36390b[i3] = f3;
        this.f36391c++;
        ((AbstractList) this).modCount++;
    }

    private void g(int i3) {
        if (i3 < 0 || i3 >= this.f36391c) {
            throw new IndexOutOfBoundsException(n(i3));
        }
    }

    private String n(int i3) {
        return "Index:" + i3 + ", Size:" + this.f36391c;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractProtobufList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection collection) {
        a();
        Internal.a(collection);
        if (!(collection instanceof FloatArrayList)) {
            return super.addAll(collection);
        }
        FloatArrayList floatArrayList = (FloatArrayList) collection;
        int i3 = floatArrayList.f36391c;
        if (i3 == 0) {
            return false;
        }
        int i4 = this.f36391c;
        if (Api.BaseClientBuilder.API_PRIORITY_OTHER - i4 < i3) {
            throw new OutOfMemoryError();
        }
        int i5 = i4 + i3;
        float[] fArr = this.f36390b;
        if (i5 > fArr.length) {
            this.f36390b = Arrays.copyOf(fArr, i5);
        }
        System.arraycopy(floatArrayList.f36390b, 0, this.f36390b, this.f36391c, floatArrayList.f36391c);
        this.f36391c = i5;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void add(int i3, Float f3) {
        f(i3, f3.floatValue());
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean add(Float f3) {
        e(f3.floatValue());
        return true;
    }

    public void e(float f3) {
        a();
        int i3 = this.f36391c;
        float[] fArr = this.f36390b;
        if (i3 == fArr.length) {
            float[] fArr2 = new float[((i3 * 3) / 2) + 1];
            System.arraycopy(fArr, 0, fArr2, 0, i3);
            this.f36390b = fArr2;
        }
        float[] fArr3 = this.f36390b;
        int i4 = this.f36391c;
        this.f36391c = i4 + 1;
        fArr3[i4] = f3;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FloatArrayList)) {
            return super.equals(obj);
        }
        FloatArrayList floatArrayList = (FloatArrayList) obj;
        if (this.f36391c != floatArrayList.f36391c) {
            return false;
        }
        float[] fArr = floatArrayList.f36390b;
        for (int i3 = 0; i3 < this.f36391c; i3++) {
            if (Float.floatToIntBits(this.f36390b[i3]) != Float.floatToIntBits(fArr[i3])) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public Float get(int i3) {
        return Float.valueOf(l(i3));
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        int iFloatToIntBits = 1;
        for (int i3 = 0; i3 < this.f36391c; i3++) {
            iFloatToIntBits = (iFloatToIntBits * 31) + Float.floatToIntBits(this.f36390b[i3]);
        }
        return iFloatToIntBits;
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object obj) {
        if (!(obj instanceof Float)) {
            return -1;
        }
        float fFloatValue = ((Float) obj).floatValue();
        int size = size();
        for (int i3 = 0; i3 < size; i3++) {
            if (this.f36390b[i3] == fFloatValue) {
                return i3;
            }
        }
        return -1;
    }

    public float l(int i3) {
        g(i3);
        return this.f36390b[i3];
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public Float remove(int i3) {
        a();
        g(i3);
        float[] fArr = this.f36390b;
        float f3 = fArr[i3];
        if (i3 < this.f36391c - 1) {
            System.arraycopy(fArr, i3 + 1, fArr, i3, (r2 - i3) - 1);
        }
        this.f36391c--;
        ((AbstractList) this).modCount++;
        return Float.valueOf(f3);
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public Float set(int i3, Float f3) {
        return Float.valueOf(q(i3, f3.floatValue()));
    }

    public float q(int i3, float f3) {
        a();
        g(i3);
        float[] fArr = this.f36390b;
        float f4 = fArr[i3];
        fArr[i3] = f3;
        return f4;
    }

    @Override // java.util.AbstractList
    protected void removeRange(int i3, int i4) {
        a();
        if (i4 < i3) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        float[] fArr = this.f36390b;
        System.arraycopy(fArr, i4, fArr, i3, this.f36391c - i4);
        this.f36391c -= i4 - i3;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f36391c;
    }

    private FloatArrayList(float[] fArr, int i3, boolean z2) {
        super(z2);
        this.f36390b = fArr;
        this.f36391c = i3;
    }

    @Override // androidx.datastore.preferences.protobuf.Internal.ProtobufList, androidx.datastore.preferences.protobuf.Internal.BooleanList
    public Internal.FloatList c(int i3) {
        if (i3 >= this.f36391c) {
            return new FloatArrayList(Arrays.copyOf(this.f36390b, i3), this.f36391c, true);
        }
        throw new IllegalArgumentException();
    }
}
