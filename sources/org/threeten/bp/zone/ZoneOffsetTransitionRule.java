package org.threeten.bp.zone;

import com.facebook.AccessTokenManager;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.Serializable;
import org.threeten.bp.DayOfWeek;
import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalDateTime;
import org.threeten.bp.LocalTime;
import org.threeten.bp.Month;
import org.threeten.bp.ZoneOffset;
import org.threeten.bp.chrono.IsoChronology;
import org.threeten.bp.jdk8.Jdk8Methods;
import org.threeten.bp.temporal.TemporalAdjusters;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class ZoneOffsetTransitionRule implements Serializable {
    private static final long serialVersionUID = 6889046316657758795L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Month f146619a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final byte f146620b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final DayOfWeek f146621c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final LocalTime f146622d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f146623f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final TimeDefinition f146624g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final ZoneOffset f146625h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final ZoneOffset f146626i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final ZoneOffset f146627j;

    /* JADX INFO: renamed from: org.threeten.bp.zone.ZoneOffsetTransitionRule$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f146628a;

        static {
            int[] iArr = new int[TimeDefinition.values().length];
            f146628a = iArr;
            try {
                iArr[TimeDefinition.UTC.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f146628a[TimeDefinition.STANDARD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public enum TimeDefinition {
        UTC,
        WALL,
        STANDARD;

        public LocalDateTime a(LocalDateTime localDateTime, ZoneOffset zoneOffset, ZoneOffset zoneOffset2) {
            int i3 = AnonymousClass1.f146628a[ordinal()];
            return i3 != 1 ? i3 != 2 ? localDateTime : localDateTime.e0(zoneOffset2.x() - zoneOffset.x()) : localDateTime.e0(zoneOffset2.x() - ZoneOffset.f146222i.x());
        }
    }

    ZoneOffsetTransitionRule(Month month, int i3, DayOfWeek dayOfWeek, LocalTime localTime, int i4, TimeDefinition timeDefinition, ZoneOffset zoneOffset, ZoneOffset zoneOffset2, ZoneOffset zoneOffset3) {
        this.f146619a = month;
        this.f146620b = (byte) i3;
        this.f146621c = dayOfWeek;
        this.f146622d = localTime;
        this.f146623f = i4;
        this.f146624g = timeDefinition;
        this.f146625h = zoneOffset;
        this.f146626i = zoneOffset2;
        this.f146627j = zoneOffset3;
    }

    private void a(StringBuilder sb, long j3) {
        if (j3 < 10) {
            sb.append(0);
        }
        sb.append(j3);
    }

    static ZoneOffsetTransitionRule c(DataInput dataInput) throws IOException {
        int i3 = dataInput.readInt();
        Month monthQ = Month.q(i3 >>> 28);
        int i4 = ((264241152 & i3) >>> 22) - 32;
        int i5 = (3670016 & i3) >>> 19;
        DayOfWeek dayOfWeekL = i5 == 0 ? null : DayOfWeek.l(i5);
        int i6 = (507904 & i3) >>> 14;
        TimeDefinition timeDefinition = TimeDefinition.values()[(i3 & 12288) >>> 12];
        int i7 = (i3 & 4080) >>> 4;
        int i8 = (i3 & 12) >>> 2;
        int i9 = i3 & 3;
        int i10 = i6 == 31 ? dataInput.readInt() : i6 * AccessTokenManager.TOKEN_EXTEND_RETRY_SECONDS;
        ZoneOffset zoneOffsetA = ZoneOffset.A(i7 == 255 ? dataInput.readInt() : (i7 - 128) * 900);
        ZoneOffset zoneOffsetA2 = i8 == 3 ? ZoneOffset.A(dataInput.readInt()) : ZoneOffset.A(zoneOffsetA.x() + (i8 * 1800));
        ZoneOffset zoneOffsetA3 = ZoneOffset.A(i9 == 3 ? dataInput.readInt() : zoneOffsetA.x() + (i9 * 1800));
        if (i4 < -28 || i4 > 31 || i4 == 0) {
            throw new IllegalArgumentException("Day of month indicator must be between -28 and 31 inclusive excluding zero");
        }
        return new ZoneOffsetTransitionRule(monthQ, i4, dayOfWeekL, LocalTime.F(Jdk8Methods.f(i10, AccessTokenManager.TOKEN_EXTEND_THRESHOLD_SECONDS)), Jdk8Methods.d(i10, AccessTokenManager.TOKEN_EXTEND_THRESHOLD_SECONDS), timeDefinition, zoneOffsetA, zoneOffsetA2, zoneOffsetA3);
    }

    private Object writeReplace() {
        return new Ser((byte) 3, this);
    }

    public ZoneOffsetTransition b(int i3) {
        LocalDate localDateH0;
        byte b3 = this.f146620b;
        if (b3 < 0) {
            Month month = this.f146619a;
            localDateH0 = LocalDate.h0(i3, month, month.l(IsoChronology.f146288f.isLeapYear(i3)) + 1 + this.f146620b);
            DayOfWeek dayOfWeek = this.f146621c;
            if (dayOfWeek != null) {
                localDateH0 = localDateH0.z(TemporalAdjusters.b(dayOfWeek));
            }
        } else {
            localDateH0 = LocalDate.h0(i3, this.f146619a, b3);
            DayOfWeek dayOfWeek2 = this.f146621c;
            if (dayOfWeek2 != null) {
                localDateH0 = localDateH0.z(TemporalAdjusters.a(dayOfWeek2));
            }
        }
        return new ZoneOffsetTransition(this.f146624g.a(LocalDateTime.W(localDateH0.p0(this.f146623f), this.f146622d), this.f146625h, this.f146626i), this.f146626i, this.f146627j);
    }

    void d(DataOutput dataOutput) {
        int iV = this.f146622d.V() + (this.f146623f * AccessTokenManager.TOKEN_EXTEND_THRESHOLD_SECONDS);
        int iX = this.f146625h.x();
        int iX2 = this.f146626i.x() - iX;
        int iX3 = this.f146627j.x() - iX;
        int iU = (iV % AccessTokenManager.TOKEN_EXTEND_RETRY_SECONDS != 0 || iV > 86400) ? 31 : iV == 86400 ? 24 : this.f146622d.u();
        int i3 = iX % 900 == 0 ? (iX / 900) + ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD : 255;
        int i4 = (iX2 == 0 || iX2 == 1800 || iX2 == 3600) ? iX2 / 1800 : 3;
        int i5 = (iX3 == 0 || iX3 == 1800 || iX3 == 3600) ? iX3 / 1800 : 3;
        DayOfWeek dayOfWeek = this.f146621c;
        dataOutput.writeInt((this.f146619a.getValue() << 28) + ((this.f146620b + 32) << 22) + ((dayOfWeek == null ? 0 : dayOfWeek.getValue()) << 19) + (iU << 14) + (this.f146624g.ordinal() << 12) + (i3 << 4) + (i4 << 2) + i5);
        if (iU == 31) {
            dataOutput.writeInt(iV);
        }
        if (i3 == 255) {
            dataOutput.writeInt(iX);
        }
        if (i4 == 3) {
            dataOutput.writeInt(this.f146626i.x());
        }
        if (i5 == 3) {
            dataOutput.writeInt(this.f146627j.x());
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ZoneOffsetTransitionRule) {
            ZoneOffsetTransitionRule zoneOffsetTransitionRule = (ZoneOffsetTransitionRule) obj;
            if (this.f146619a == zoneOffsetTransitionRule.f146619a && this.f146620b == zoneOffsetTransitionRule.f146620b && this.f146621c == zoneOffsetTransitionRule.f146621c && this.f146624g == zoneOffsetTransitionRule.f146624g && this.f146623f == zoneOffsetTransitionRule.f146623f && this.f146622d.equals(zoneOffsetTransitionRule.f146622d) && this.f146625h.equals(zoneOffsetTransitionRule.f146625h) && this.f146626i.equals(zoneOffsetTransitionRule.f146626i) && this.f146627j.equals(zoneOffsetTransitionRule.f146627j)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int iV = ((this.f146622d.V() + this.f146623f) << 15) + (this.f146619a.ordinal() << 11) + ((this.f146620b + 32) << 5);
        DayOfWeek dayOfWeek = this.f146621c;
        return ((((iV + ((dayOfWeek == null ? 7 : dayOfWeek.ordinal()) << 2)) + this.f146624g.ordinal()) ^ this.f146625h.hashCode()) ^ this.f146626i.hashCode()) ^ this.f146627j.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TransitionRule[");
        sb.append(this.f146626i.compareTo(this.f146627j) > 0 ? "Gap " : "Overlap ");
        sb.append(this.f146626i);
        sb.append(" to ");
        sb.append(this.f146627j);
        sb.append(", ");
        DayOfWeek dayOfWeek = this.f146621c;
        if (dayOfWeek != null) {
            byte b3 = this.f146620b;
            if (b3 == -1) {
                sb.append(dayOfWeek.name());
                sb.append(" on or before last day of ");
                sb.append(this.f146619a.name());
            } else if (b3 < 0) {
                sb.append(dayOfWeek.name());
                sb.append(" on or before last day minus ");
                sb.append((-this.f146620b) - 1);
                sb.append(" of ");
                sb.append(this.f146619a.name());
            } else {
                sb.append(dayOfWeek.name());
                sb.append(" on or after ");
                sb.append(this.f146619a.name());
                sb.append(' ');
                sb.append((int) this.f146620b);
            }
        } else {
            sb.append(this.f146619a.name());
            sb.append(' ');
            sb.append((int) this.f146620b);
        }
        sb.append(" at ");
        if (this.f146623f == 0) {
            sb.append(this.f146622d);
        } else {
            a(sb, Jdk8Methods.e((this.f146622d.V() / 60) + (this.f146623f * 1440), 60L));
            sb.append(':');
            a(sb, Jdk8Methods.g(r3, 60));
        }
        sb.append(" ");
        sb.append(this.f146624g);
        sb.append(", standard offset ");
        sb.append(this.f146625h);
        sb.append(']');
        return sb.toString();
    }
}
