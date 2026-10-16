package com.google.common.util.concurrent;

import com.google.common.primitives.ImmutableLongArray;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicLongArray;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public class AtomicDoubleArray implements Serializable {
    private static final long serialVersionUID = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private transient AtomicLongArray f85713a;

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        int i3 = objectInputStream.readInt();
        ImmutableLongArray.Builder builderE = ImmutableLongArray.e();
        for (int i4 = 0; i4 < i3; i4++) {
            builderE.a(Double.doubleToRawLongBits(objectInputStream.readDouble()));
        }
        this.f85713a = new AtomicLongArray(builderE.b().m());
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        int iB = b();
        objectOutputStream.writeInt(iB);
        for (int i3 = 0; i3 < iB; i3++) {
            objectOutputStream.writeDouble(a(i3));
        }
    }

    public final double a(int i3) {
        return Double.longBitsToDouble(this.f85713a.get(i3));
    }

    public final int b() {
        return this.f85713a.length();
    }

    public String toString() {
        int iB = b();
        int i3 = iB - 1;
        if (i3 == -1) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder(iB * 19);
        sb.append('[');
        int i4 = 0;
        while (true) {
            sb.append(Double.longBitsToDouble(this.f85713a.get(i4)));
            if (i4 == i3) {
                sb.append(']');
                return sb.toString();
            }
            sb.append(',');
            sb.append(' ');
            i4++;
        }
    }
}
