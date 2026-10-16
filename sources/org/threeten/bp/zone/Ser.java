package org.threeten.bp.zone;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.Externalizable;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.StreamCorruptedException;
import org.threeten.bp.ZoneOffset;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
final class Ser implements Externalizable {
    private static final long serialVersionUID = -8885321777449118786L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private byte f146600a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Object f146601b;

    public Ser() {
    }

    static Object a(DataInput dataInput) {
        return c(dataInput.readByte(), dataInput);
    }

    static long b(DataInput dataInput) {
        int i3 = dataInput.readByte() & 255;
        if (i3 == 255) {
            return dataInput.readLong();
        }
        return (((long) (((i3 << 16) + ((dataInput.readByte() & 255) << 8)) + (dataInput.readByte() & 255))) * 900) - 4575744000L;
    }

    private static Object c(byte b3, DataInput dataInput) throws StreamCorruptedException {
        if (b3 == 1) {
            return StandardZoneRules.m(dataInput);
        }
        if (b3 == 2) {
            return ZoneOffsetTransition.k(dataInput);
        }
        if (b3 == 3) {
            return ZoneOffsetTransitionRule.c(dataInput);
        }
        throw new StreamCorruptedException("Unknown serialized type");
    }

    static ZoneOffset d(DataInput dataInput) {
        byte b3 = dataInput.readByte();
        return b3 == 127 ? ZoneOffset.A(dataInput.readInt()) : ZoneOffset.A(b3 * 900);
    }

    static void e(long j3, DataOutput dataOutput) {
        if (j3 < -4575744000L || j3 >= 10413792000L || j3 % 900 != 0) {
            dataOutput.writeByte(255);
            dataOutput.writeLong(j3);
        } else {
            int i3 = (int) ((j3 + 4575744000L) / 900);
            dataOutput.writeByte((i3 >>> 16) & 255);
            dataOutput.writeByte((i3 >>> 8) & 255);
            dataOutput.writeByte(i3 & 255);
        }
    }

    private static void f(byte b3, Object obj, DataOutput dataOutput) throws IOException {
        dataOutput.writeByte(b3);
        if (b3 == 1) {
            ((StandardZoneRules) obj).n(dataOutput);
        } else if (b3 == 2) {
            ((ZoneOffsetTransition) obj).l(dataOutput);
        } else {
            if (b3 != 3) {
                throw new InvalidClassException("Unknown serialized type");
            }
            ((ZoneOffsetTransitionRule) obj).d(dataOutput);
        }
    }

    static void g(ZoneOffset zoneOffset, DataOutput dataOutput) {
        int iX = zoneOffset.x();
        int i3 = iX % 900 == 0 ? iX / 900 : 127;
        dataOutput.writeByte(i3);
        if (i3 == 127) {
            dataOutput.writeInt(iX);
        }
    }

    private Object readResolve() {
        return this.f146601b;
    }

    @Override // java.io.Externalizable
    public void readExternal(ObjectInput objectInput) throws IOException {
        byte b3 = objectInput.readByte();
        this.f146600a = b3;
        this.f146601b = c(b3, objectInput);
    }

    @Override // java.io.Externalizable
    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        f(this.f146600a, this.f146601b, objectOutput);
    }

    Ser(byte b3, Object obj) {
        this.f146600a = b3;
        this.f146601b = obj;
    }
}
