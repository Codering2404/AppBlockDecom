package androidx.media3.exoplayer.source;

import android.util.SparseArray;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Consumer;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class SpannedData<V> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Consumer f44978c;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final SparseArray f44977b = new SparseArray();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f44976a = -1;

    public SpannedData(Consumer consumer) {
        this.f44978c = consumer;
    }

    public void a(int i3, Object obj) {
        if (this.f44976a == -1) {
            Assertions.g(this.f44977b.size() == 0);
            this.f44976a = 0;
        }
        if (this.f44977b.size() > 0) {
            SparseArray sparseArray = this.f44977b;
            int iKeyAt = sparseArray.keyAt(sparseArray.size() - 1);
            Assertions.a(i3 >= iKeyAt);
            if (iKeyAt == i3) {
                Consumer consumer = this.f44978c;
                SparseArray sparseArray2 = this.f44977b;
                consumer.accept(sparseArray2.valueAt(sparseArray2.size() - 1));
            }
        }
        this.f44977b.append(i3, obj);
    }

    public void b() {
        for (int i3 = 0; i3 < this.f44977b.size(); i3++) {
            this.f44978c.accept(this.f44977b.valueAt(i3));
        }
        this.f44976a = -1;
        this.f44977b.clear();
    }

    public void c(int i3) {
        for (int size = this.f44977b.size() - 1; size >= 0 && i3 < this.f44977b.keyAt(size); size--) {
            this.f44978c.accept(this.f44977b.valueAt(size));
            this.f44977b.removeAt(size);
        }
        this.f44976a = this.f44977b.size() > 0 ? Math.min(this.f44976a, this.f44977b.size() - 1) : -1;
    }

    public void d(int i3) {
        int i4 = 0;
        while (i4 < this.f44977b.size() - 1) {
            int i5 = i4 + 1;
            if (i3 < this.f44977b.keyAt(i5)) {
                return;
            }
            this.f44978c.accept(this.f44977b.valueAt(i4));
            this.f44977b.removeAt(i4);
            int i6 = this.f44976a;
            if (i6 > 0) {
                this.f44976a = i6 - 1;
            }
            i4 = i5;
        }
    }

    public Object e(int i3) {
        if (this.f44976a == -1) {
            this.f44976a = 0;
        }
        while (true) {
            int i4 = this.f44976a;
            if (i4 <= 0 || i3 >= this.f44977b.keyAt(i4)) {
                break;
            }
            this.f44976a--;
        }
        while (this.f44976a < this.f44977b.size() - 1 && i3 >= this.f44977b.keyAt(this.f44976a + 1)) {
            this.f44976a++;
        }
        return this.f44977b.valueAt(this.f44976a);
    }

    public Object f() {
        return this.f44977b.valueAt(r0.size() - 1);
    }

    public boolean g() {
        return this.f44977b.size() == 0;
    }
}
