package org.threeten.bp.zone;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.threeten.bp.Instant;
import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalDateTime;
import org.threeten.bp.ZoneOffset;
import org.threeten.bp.jdk8.Jdk8Methods;
import org.threeten.bp.zone.ZoneRules;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
final class StandardZoneRules extends ZoneRules implements Serializable {
    private static final long serialVersionUID = 3044319355680032515L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long[] f146602a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ZoneOffset[] f146603b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long[] f146604c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final LocalDateTime[] f146605d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final ZoneOffset[] f146606f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final ZoneOffsetTransitionRule[] f146607g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final ConcurrentMap f146608h = new ConcurrentHashMap();

    private StandardZoneRules(long[] jArr, ZoneOffset[] zoneOffsetArr, long[] jArr2, ZoneOffset[] zoneOffsetArr2, ZoneOffsetTransitionRule[] zoneOffsetTransitionRuleArr) {
        this.f146602a = jArr;
        this.f146603b = zoneOffsetArr;
        this.f146604c = jArr2;
        this.f146606f = zoneOffsetArr2;
        this.f146607g = zoneOffsetTransitionRuleArr;
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        while (i3 < jArr2.length) {
            int i4 = i3 + 1;
            ZoneOffsetTransition zoneOffsetTransition = new ZoneOffsetTransition(jArr2[i3], zoneOffsetArr2[i3], zoneOffsetArr2[i4]);
            if (zoneOffsetTransition.j()) {
                arrayList.add(zoneOffsetTransition.c());
                arrayList.add(zoneOffsetTransition.b());
            } else {
                arrayList.add(zoneOffsetTransition.b());
                arrayList.add(zoneOffsetTransition.c());
            }
            i3 = i4;
        }
        this.f146605d = (LocalDateTime[]) arrayList.toArray(new LocalDateTime[arrayList.size()]);
    }

    private Object h(LocalDateTime localDateTime, ZoneOffsetTransition zoneOffsetTransition) {
        LocalDateTime localDateTimeC = zoneOffsetTransition.c();
        if (zoneOffsetTransition.j()) {
            if (localDateTime.u(localDateTimeC)) {
                return zoneOffsetTransition.h();
            }
            if (!localDateTime.u(zoneOffsetTransition.b())) {
                return zoneOffsetTransition.g();
            }
        } else {
            if (!localDateTime.u(localDateTimeC)) {
                return zoneOffsetTransition.g();
            }
            if (localDateTime.u(zoneOffsetTransition.b())) {
                return zoneOffsetTransition.h();
            }
        }
        return zoneOffsetTransition;
    }

    private ZoneOffsetTransition[] i(int i3) {
        Integer numValueOf = Integer.valueOf(i3);
        ZoneOffsetTransition[] zoneOffsetTransitionArr = (ZoneOffsetTransition[]) this.f146608h.get(numValueOf);
        if (zoneOffsetTransitionArr != null) {
            return zoneOffsetTransitionArr;
        }
        ZoneOffsetTransitionRule[] zoneOffsetTransitionRuleArr = this.f146607g;
        ZoneOffsetTransition[] zoneOffsetTransitionArr2 = new ZoneOffsetTransition[zoneOffsetTransitionRuleArr.length];
        for (int i4 = 0; i4 < zoneOffsetTransitionRuleArr.length; i4++) {
            zoneOffsetTransitionArr2[i4] = zoneOffsetTransitionRuleArr[i4].b(i3);
        }
        if (i3 < 2100) {
            this.f146608h.putIfAbsent(numValueOf, zoneOffsetTransitionArr2);
        }
        return zoneOffsetTransitionArr2;
    }

    private int j(long j3, ZoneOffset zoneOffset) {
        return LocalDate.i0(Jdk8Methods.e(j3 + ((long) zoneOffset.x()), 86400L)).Y();
    }

    private Object k(LocalDateTime localDateTime) {
        int i3 = 0;
        if (this.f146607g.length > 0) {
            LocalDateTime[] localDateTimeArr = this.f146605d;
            if (localDateTimeArr.length == 0 || localDateTime.t(localDateTimeArr[localDateTimeArr.length - 1])) {
                ZoneOffsetTransition[] zoneOffsetTransitionArrI = i(localDateTime.Q());
                int length = zoneOffsetTransitionArrI.length;
                Object obj = null;
                while (i3 < length) {
                    ZoneOffsetTransition zoneOffsetTransition = zoneOffsetTransitionArrI[i3];
                    Object objH = h(localDateTime, zoneOffsetTransition);
                    if ((objH instanceof ZoneOffsetTransition) || objH.equals(zoneOffsetTransition.h())) {
                        return objH;
                    }
                    i3++;
                    obj = objH;
                }
                return obj;
            }
        }
        int iBinarySearch = Arrays.binarySearch(this.f146605d, localDateTime);
        if (iBinarySearch == -1) {
            return this.f146606f[0];
        }
        if (iBinarySearch < 0) {
            iBinarySearch = (-iBinarySearch) - 2;
        } else {
            Object[] objArr = this.f146605d;
            if (iBinarySearch < objArr.length - 1) {
                int i4 = iBinarySearch + 1;
                if (objArr[iBinarySearch].equals(objArr[i4])) {
                    iBinarySearch = i4;
                }
            }
        }
        if ((iBinarySearch & 1) != 0) {
            return this.f146606f[(iBinarySearch / 2) + 1];
        }
        LocalDateTime[] localDateTimeArr2 = this.f146605d;
        LocalDateTime localDateTime2 = localDateTimeArr2[iBinarySearch];
        LocalDateTime localDateTime3 = localDateTimeArr2[iBinarySearch + 1];
        ZoneOffset[] zoneOffsetArr = this.f146606f;
        int i5 = iBinarySearch / 2;
        ZoneOffset zoneOffset = zoneOffsetArr[i5];
        ZoneOffset zoneOffset2 = zoneOffsetArr[i5 + 1];
        return zoneOffset2.x() > zoneOffset.x() ? new ZoneOffsetTransition(localDateTime2, zoneOffset, zoneOffset2) : new ZoneOffsetTransition(localDateTime3, zoneOffset, zoneOffset2);
    }

    static StandardZoneRules m(DataInput dataInput) throws IOException {
        int i3 = dataInput.readInt();
        long[] jArr = new long[i3];
        for (int i4 = 0; i4 < i3; i4++) {
            jArr[i4] = Ser.b(dataInput);
        }
        int i5 = i3 + 1;
        ZoneOffset[] zoneOffsetArr = new ZoneOffset[i5];
        for (int i6 = 0; i6 < i5; i6++) {
            zoneOffsetArr[i6] = Ser.d(dataInput);
        }
        int i7 = dataInput.readInt();
        long[] jArr2 = new long[i7];
        for (int i8 = 0; i8 < i7; i8++) {
            jArr2[i8] = Ser.b(dataInput);
        }
        int i9 = i7 + 1;
        ZoneOffset[] zoneOffsetArr2 = new ZoneOffset[i9];
        for (int i10 = 0; i10 < i9; i10++) {
            zoneOffsetArr2[i10] = Ser.d(dataInput);
        }
        int i11 = dataInput.readByte();
        ZoneOffsetTransitionRule[] zoneOffsetTransitionRuleArr = new ZoneOffsetTransitionRule[i11];
        for (int i12 = 0; i12 < i11; i12++) {
            zoneOffsetTransitionRuleArr[i12] = ZoneOffsetTransitionRule.c(dataInput);
        }
        return new StandardZoneRules(jArr, zoneOffsetArr, jArr2, zoneOffsetArr2, zoneOffsetTransitionRuleArr);
    }

    private Object writeReplace() {
        return new Ser((byte) 1, this);
    }

    @Override // org.threeten.bp.zone.ZoneRules
    public ZoneOffset a(Instant instant) {
        long jT = instant.t();
        if (this.f146607g.length > 0) {
            long[] jArr = this.f146604c;
            if (jArr.length == 0 || jT > jArr[jArr.length - 1]) {
                ZoneOffsetTransition[] zoneOffsetTransitionArrI = i(j(jT, this.f146606f[r7.length - 1]));
                ZoneOffsetTransition zoneOffsetTransition = null;
                for (int i3 = 0; i3 < zoneOffsetTransitionArrI.length; i3++) {
                    zoneOffsetTransition = zoneOffsetTransitionArrI[i3];
                    if (jT < zoneOffsetTransition.toEpochSecond()) {
                        return zoneOffsetTransition.h();
                    }
                }
                return zoneOffsetTransition.g();
            }
        }
        int iBinarySearch = Arrays.binarySearch(this.f146604c, jT);
        if (iBinarySearch < 0) {
            iBinarySearch = (-iBinarySearch) - 2;
        }
        return this.f146606f[iBinarySearch + 1];
    }

    @Override // org.threeten.bp.zone.ZoneRules
    public ZoneOffsetTransition b(LocalDateTime localDateTime) {
        Object objK = k(localDateTime);
        if (objK instanceof ZoneOffsetTransition) {
            return (ZoneOffsetTransition) objK;
        }
        return null;
    }

    @Override // org.threeten.bp.zone.ZoneRules
    public List c(LocalDateTime localDateTime) {
        Object objK = k(localDateTime);
        return objK instanceof ZoneOffsetTransition ? ((ZoneOffsetTransition) objK).i() : Collections.singletonList((ZoneOffset) objK);
    }

    @Override // org.threeten.bp.zone.ZoneRules
    public boolean d(Instant instant) {
        return !l(instant).equals(a(instant));
    }

    @Override // org.threeten.bp.zone.ZoneRules
    public boolean e() {
        return this.f146604c.length == 0 && this.f146607g.length == 0 && this.f146606f[0].equals(this.f146603b[0]);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof StandardZoneRules) {
            StandardZoneRules standardZoneRules = (StandardZoneRules) obj;
            return Arrays.equals(this.f146602a, standardZoneRules.f146602a) && Arrays.equals(this.f146603b, standardZoneRules.f146603b) && Arrays.equals(this.f146604c, standardZoneRules.f146604c) && Arrays.equals(this.f146606f, standardZoneRules.f146606f) && Arrays.equals(this.f146607g, standardZoneRules.f146607g);
        }
        if ((obj instanceof ZoneRules.Fixed) && e()) {
            Instant instant = Instant.f146130c;
            if (a(instant).equals(((ZoneRules.Fixed) obj).a(instant))) {
                return true;
            }
        }
        return false;
    }

    @Override // org.threeten.bp.zone.ZoneRules
    public boolean f(LocalDateTime localDateTime, ZoneOffset zoneOffset) {
        return c(localDateTime).contains(zoneOffset);
    }

    public int hashCode() {
        return (((Arrays.hashCode(this.f146602a) ^ Arrays.hashCode(this.f146603b)) ^ Arrays.hashCode(this.f146604c)) ^ Arrays.hashCode(this.f146606f)) ^ Arrays.hashCode(this.f146607g);
    }

    public ZoneOffset l(Instant instant) {
        int iBinarySearch = Arrays.binarySearch(this.f146602a, instant.t());
        if (iBinarySearch < 0) {
            iBinarySearch = (-iBinarySearch) - 2;
        }
        return this.f146603b[iBinarySearch + 1];
    }

    void n(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(this.f146602a.length);
        for (long j3 : this.f146602a) {
            Ser.e(j3, dataOutput);
        }
        for (ZoneOffset zoneOffset : this.f146603b) {
            Ser.g(zoneOffset, dataOutput);
        }
        dataOutput.writeInt(this.f146604c.length);
        for (long j4 : this.f146604c) {
            Ser.e(j4, dataOutput);
        }
        for (ZoneOffset zoneOffset2 : this.f146606f) {
            Ser.g(zoneOffset2, dataOutput);
        }
        dataOutput.writeByte(this.f146607g.length);
        for (ZoneOffsetTransitionRule zoneOffsetTransitionRule : this.f146607g) {
            zoneOffsetTransitionRule.d(dataOutput);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("StandardZoneRules[currentStandardOffset=");
        sb.append(this.f146603b[r1.length - 1]);
        sb.append("]");
        return sb.toString();
    }
}
