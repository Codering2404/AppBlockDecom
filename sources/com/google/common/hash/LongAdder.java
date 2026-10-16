package com.google.common.hash;

import com.google.common.hash.Striped64;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
final class LongAdder extends Striped64 implements Serializable, LongAddable {
    private static final long serialVersionUID = 7249069246863182397L;

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        this.f85175c = 0;
        this.f85173a = null;
        this.f85174b = objectInputStream.readLong();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeLong(g());
    }

    @Override // com.google.common.hash.LongAddable
    public void add(long j3) {
        int length;
        Striped64.Cell cell;
        Striped64.Cell[] cellArr = this.f85173a;
        if (cellArr == null) {
            long j4 = this.f85174b;
            if (b(j4, j4 + j3)) {
                return;
            }
        }
        int[] iArr = (int[]) Striped64.f85167d.get();
        boolean zA = true;
        if (iArr != null && cellArr != null && (length = cellArr.length) >= 1 && (cell = cellArr[(length - 1) & iArr[0]]) != null) {
            long j5 = cell.f85178a;
            zA = cell.a(j5, j5 + j3);
            if (zA) {
                return;
            }
        }
        f(j3, iArr, zA);
    }

    @Override // com.google.common.hash.Striped64
    final long d(long j3, long j4) {
        return j3 + j4;
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return g();
    }

    @Override // java.lang.Number
    public float floatValue() {
        return g();
    }

    public long g() {
        long j3 = this.f85174b;
        Striped64.Cell[] cellArr = this.f85173a;
        if (cellArr != null) {
            for (Striped64.Cell cell : cellArr) {
                if (cell != null) {
                    j3 += cell.f85178a;
                }
            }
        }
        return j3;
    }

    @Override // java.lang.Number
    public int intValue() {
        return (int) g();
    }

    @Override // java.lang.Number
    public long longValue() {
        return g();
    }

    public String toString() {
        return Long.toString(g());
    }
}
