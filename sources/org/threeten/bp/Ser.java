package org.threeten.bp;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.Externalizable;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.StreamCorruptedException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
final class Ser implements Externalizable {
    private static final long serialVersionUID = -7683839454370182990L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private byte f146203a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Object f146204b;

    public Ser() {
    }

    static Object a(DataInput dataInput) {
        return b(dataInput.readByte(), dataInput);
    }

    private static Object b(byte b3, DataInput dataInput) throws StreamCorruptedException {
        if (b3 == 64) {
            return MonthDay.u(dataInput);
        }
        switch (b3) {
            case 1:
                return Duration.v(dataInput);
            case 2:
                return Instant.Q(dataInput);
            case 3:
                return LocalDate.t0(dataInput);
            case 4:
                return LocalDateTime.h0(dataInput);
            case 5:
                return LocalTime.S(dataInput);
            case 6:
                return ZonedDateTime.V(dataInput);
            case 7:
                return ZoneRegion.w(dataInput);
            case 8:
                return ZoneOffset.C(dataInput);
            default:
                switch (b3) {
                    case 66:
                        return OffsetTime.v(dataInput);
                    case 67:
                        return Year.w(dataInput);
                    case 68:
                        return YearMonth.y(dataInput);
                    case 69:
                        return OffsetDateTime.B(dataInput);
                    default:
                        throw new StreamCorruptedException("Unknown serialized type");
                }
        }
    }

    static void c(byte b3, Object obj, DataOutput dataOutput) throws IOException {
        dataOutput.writeByte(b3);
        if (b3 == 64) {
            ((MonthDay) obj).v(dataOutput);
            return;
        }
        switch (b3) {
            case 1:
                ((Duration) obj).B(dataOutput);
                return;
            case 2:
                ((Instant) obj).W(dataOutput);
                return;
            case 3:
                ((LocalDate) obj).E0(dataOutput);
                return;
            case 4:
                ((LocalDateTime) obj).n0(dataOutput);
                return;
            case 5:
                ((LocalTime) obj).c0(dataOutput);
                return;
            case 6:
                ((ZonedDateTime) obj).h0(dataOutput);
                return;
            case 7:
                ((ZoneRegion) obj).x(dataOutput);
                return;
            case 8:
                ((ZoneOffset) obj).F(dataOutput);
                return;
            default:
                switch (b3) {
                    case 66:
                        ((OffsetTime) obj).A(dataOutput);
                        return;
                    case 67:
                        ((Year) obj).z(dataOutput);
                        return;
                    case 68:
                        ((YearMonth) obj).F(dataOutput);
                        return;
                    case 69:
                        ((OffsetDateTime) obj).R(dataOutput);
                        return;
                    default:
                        throw new InvalidClassException("Unknown serialized type");
                }
        }
    }

    private Object readResolve() {
        return this.f146204b;
    }

    @Override // java.io.Externalizable
    public void readExternal(ObjectInput objectInput) throws IOException {
        byte b3 = objectInput.readByte();
        this.f146203a = b3;
        this.f146204b = b(b3, objectInput);
    }

    @Override // java.io.Externalizable
    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        c(this.f146203a, this.f146204b, objectOutput);
    }

    Ser(byte b3, Object obj) {
        this.f146203a = b3;
        this.f146204b = obj;
    }
}
