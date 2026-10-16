package org.threeten.bp.chrono;

import java.io.Externalizable;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.StreamCorruptedException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
final class Ser implements Externalizable {
    private static final long serialVersionUID = 7857518227608961174L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private byte f146319a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Object f146320b;

    public Ser() {
    }

    private static Object a(byte b3, ObjectInput objectInput) throws StreamCorruptedException {
        switch (b3) {
            case 1:
                return JapaneseDate.X(objectInput);
            case 2:
                return JapaneseEra.t(objectInput);
            case 3:
                return HijrahDate.C0(objectInput);
            case 4:
                return HijrahEra.l(objectInput);
            case 5:
                return MinguoDate.X(objectInput);
            case 6:
                return MinguoEra.f(objectInput);
            case 7:
                return ThaiBuddhistDate.X(objectInput);
            case 8:
                return ThaiBuddhistEra.f(objectInput);
            case 9:
            case 10:
            default:
                throw new StreamCorruptedException("Unknown serialized type");
            case 11:
                return Chronology.m(objectInput);
            case 12:
                return ChronoLocalDateTimeImpl.S(objectInput);
            case 13:
                return ChronoZonedDateTimeImpl.H(objectInput);
        }
    }

    private static void b(byte b3, Object obj, ObjectOutput objectOutput) throws IOException {
        objectOutput.writeByte(b3);
        switch (b3) {
            case 1:
                ((JapaneseDate) obj).d0(objectOutput);
                return;
            case 2:
                ((JapaneseEra) obj).w(objectOutput);
                return;
            case 3:
                ((HijrahDate) obj).G0(objectOutput);
                return;
            case 4:
                ((HijrahEra) obj).n(objectOutput);
                return;
            case 5:
                ((MinguoDate) obj).b0(objectOutput);
                return;
            case 6:
                ((MinguoEra) obj).l(objectOutput);
                return;
            case 7:
                ((ThaiBuddhistDate) obj).b0(objectOutput);
                return;
            case 8:
                ((ThaiBuddhistEra) obj).l(objectOutput);
                return;
            case 9:
            case 10:
            default:
                throw new InvalidClassException("Unknown serialized type");
            case 11:
                ((Chronology) obj).p(objectOutput);
                return;
            case 12:
                ((ChronoLocalDateTimeImpl) obj).writeExternal(objectOutput);
                return;
            case 13:
                ((ChronoZonedDateTimeImpl) obj).writeExternal(objectOutput);
                return;
        }
    }

    private Object readResolve() {
        return this.f146320b;
    }

    @Override // java.io.Externalizable
    public void readExternal(ObjectInput objectInput) throws IOException {
        byte b3 = objectInput.readByte();
        this.f146319a = b3;
        this.f146320b = a(b3, objectInput);
    }

    @Override // java.io.Externalizable
    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        b(this.f146319a, this.f146320b, objectOutput);
    }

    Ser(byte b3, Object obj) {
        this.f146319a = b3;
        this.f146320b = obj;
    }
}
