package org.threeten.bp.zone;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.threeten.bp.Duration;
import org.threeten.bp.Instant;
import org.threeten.bp.LocalDateTime;
import org.threeten.bp.ZoneOffset;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class ZoneOffsetTransition implements Comparable<ZoneOffsetTransition>, Serializable {
    private static final long serialVersionUID = -6946044323557704546L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LocalDateTime f146616a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ZoneOffset f146617b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ZoneOffset f146618c;

    ZoneOffsetTransition(LocalDateTime localDateTime, ZoneOffset zoneOffset, ZoneOffset zoneOffset2) {
        this.f146616a = localDateTime;
        this.f146617b = zoneOffset;
        this.f146618c = zoneOffset2;
    }

    private int e() {
        return g().x() - h().x();
    }

    static ZoneOffsetTransition k(DataInput dataInput) {
        long jB = Ser.b(dataInput);
        ZoneOffset zoneOffsetD = Ser.d(dataInput);
        ZoneOffset zoneOffsetD2 = Ser.d(dataInput);
        if (zoneOffsetD.equals(zoneOffsetD2)) {
            throw new IllegalArgumentException("Offsets must not be equal");
        }
        return new ZoneOffsetTransition(jB, zoneOffsetD, zoneOffsetD2);
    }

    private Object writeReplace() {
        return new Ser((byte) 2, this);
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(ZoneOffsetTransition zoneOffsetTransition) {
        return f().compareTo(zoneOffsetTransition.f());
    }

    public LocalDateTime b() {
        return this.f146616a.e0(e());
    }

    public LocalDateTime c() {
        return this.f146616a;
    }

    public Duration d() {
        return Duration.r(e());
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ZoneOffsetTransition) {
            ZoneOffsetTransition zoneOffsetTransition = (ZoneOffsetTransition) obj;
            if (this.f146616a.equals(zoneOffsetTransition.f146616a) && this.f146617b.equals(zoneOffsetTransition.f146617b) && this.f146618c.equals(zoneOffsetTransition.f146618c)) {
                return true;
            }
        }
        return false;
    }

    public Instant f() {
        return this.f146616a.y(this.f146617b);
    }

    public ZoneOffset g() {
        return this.f146618c;
    }

    public ZoneOffset h() {
        return this.f146617b;
    }

    public int hashCode() {
        return (this.f146616a.hashCode() ^ this.f146617b.hashCode()) ^ Integer.rotateLeft(this.f146618c.hashCode(), 16);
    }

    List i() {
        return j() ? Collections.EMPTY_LIST : Arrays.asList(h(), g());
    }

    public boolean j() {
        return g().x() > h().x();
    }

    void l(DataOutput dataOutput) {
        Ser.e(toEpochSecond(), dataOutput);
        Ser.g(this.f146617b, dataOutput);
        Ser.g(this.f146618c, dataOutput);
    }

    public long toEpochSecond() {
        return this.f146616a.x(this.f146617b);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Transition[");
        sb.append(j() ? "Gap" : "Overlap");
        sb.append(" at ");
        sb.append(this.f146616a);
        sb.append(this.f146617b);
        sb.append(" to ");
        sb.append(this.f146618c);
        sb.append(']');
        return sb.toString();
    }

    ZoneOffsetTransition(long j3, ZoneOffset zoneOffset, ZoneOffset zoneOffset2) {
        this.f146616a = LocalDateTime.X(j3, 0, zoneOffset);
        this.f146617b = zoneOffset;
        this.f146618c = zoneOffset2;
    }
}
