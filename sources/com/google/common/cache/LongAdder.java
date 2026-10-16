package com.google.common.cache;

import com.google.common.cache.Striped64;
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
        this.f83654c = 0;
        this.f83652a = null;
        this.f83653b = objectInputStream.readLong();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeLong(h());
    }

    @Override // com.google.common.cache.LongAddable
    public void a() {
        add(1L);
    }

    @Override // com.google.common.cache.LongAddable
    public void add(long j3) {
        int length;
        Striped64.Cell cell;
        Striped64.Cell[] cellArr = this.f83652a;
        if (cellArr == null) {
            long j4 = this.f83653b;
            if (c(j4, j4 + j3)) {
                return;
            }
        }
        int[] iArr = (int[]) Striped64.f83646d.get();
        boolean zA = true;
        if (iArr != null && cellArr != null && (length = cellArr.length) >= 1 && (cell = cellArr[(length - 1) & iArr[0]]) != null) {
            long j5 = cell.f83657a;
            zA = cell.a(j5, j5 + j3);
            if (zA) {
                return;
            }
        }
        g(j3, iArr, zA);
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return h();
    }

    @Override // com.google.common.cache.Striped64
    final long e(long j3, long j4) {
        return j3 + j4;
    }

    @Override // java.lang.Number
    public float floatValue() {
        return h();
    }

    public long h() {
        long j3 = this.f83653b;
        Striped64.Cell[] cellArr = this.f83652a;
        if (cellArr != null) {
            for (Striped64.Cell cell : cellArr) {
                if (cell != null) {
                    j3 += cell.f83657a;
                }
            }
        }
        return j3;
    }

    @Override // java.lang.Number
    public int intValue() {
        return (int) h();
    }

    @Override // java.lang.Number
    public long longValue() {
        return h();
    }

    public String toString() {
        return Long.toString(h());
    }
}
