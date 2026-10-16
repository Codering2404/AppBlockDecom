package com.google.common.util.concurrent;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public class AtomicDouble extends Number implements Serializable {
    private static final long serialVersionUID = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private transient AtomicLong f85712a;

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        this.f85712a = new AtomicLong();
        b(objectInputStream.readDouble());
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeDouble(a());
    }

    public final double a() {
        return Double.longBitsToDouble(this.f85712a.get());
    }

    public final void b(double d3) {
        this.f85712a.set(Double.doubleToRawLongBits(d3));
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return a();
    }

    @Override // java.lang.Number
    public float floatValue() {
        return (float) a();
    }

    @Override // java.lang.Number
    public int intValue() {
        return (int) a();
    }

    @Override // java.lang.Number
    public long longValue() {
        return (long) a();
    }

    public String toString() {
        return Double.toString(a());
    }
}
