package org.threeten.bp;

import com.facebook.AccessTokenManager;
import com.facebook.appevents.AppEventsConstants;
import com.revenuecat.purchases.common.Constants;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.Temporal;
import org.threeten.bp.temporal.TemporalAccessor;
import org.threeten.bp.temporal.TemporalAdjuster;
import org.threeten.bp.temporal.TemporalField;
import org.threeten.bp.temporal.TemporalQueries;
import org.threeten.bp.temporal.TemporalQuery;
import org.threeten.bp.temporal.UnsupportedTemporalTypeException;
import org.threeten.bp.temporal.ValueRange;
import org.threeten.bp.zone.ZoneRules;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class ZoneOffset extends ZoneId implements TemporalAccessor, TemporalAdjuster, Comparable<ZoneOffset>, Serializable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final TemporalQuery f146219f = new TemporalQuery<ZoneOffset>() { // from class: org.threeten.bp.ZoneOffset.1
        @Override // org.threeten.bp.temporal.TemporalQuery
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public ZoneOffset a(TemporalAccessor temporalAccessor) {
            return ZoneOffset.w(temporalAccessor);
        }
    };

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final ConcurrentMap f146220g = new ConcurrentHashMap(16, 0.75f, 4);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final ConcurrentMap f146221h = new ConcurrentHashMap(16, 0.75f, 4);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final ZoneOffset f146222i = A(0);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final ZoneOffset f146223j = A(-64800);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final ZoneOffset f146224k = A(64800);
    private static final long serialVersionUID = 2357656521762053153L;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f146225c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final transient String f146226d;

    private ZoneOffset(int i3) {
        this.f146225c = i3;
        this.f146226d = u(i3);
    }

    public static ZoneOffset A(int i3) {
        if (Math.abs(i3) > 64800) {
            throw new DateTimeException("Zone offset not in valid range: -18:00 to +18:00");
        }
        if (i3 % 900 != 0) {
            return new ZoneOffset(i3);
        }
        Integer numValueOf = Integer.valueOf(i3);
        ConcurrentMap concurrentMap = f146220g;
        ZoneOffset zoneOffset = (ZoneOffset) concurrentMap.get(numValueOf);
        if (zoneOffset != null) {
            return zoneOffset;
        }
        concurrentMap.putIfAbsent(numValueOf, new ZoneOffset(i3));
        ZoneOffset zoneOffset2 = (ZoneOffset) concurrentMap.get(numValueOf);
        f146221h.putIfAbsent(zoneOffset2.getId(), zoneOffset2);
        return zoneOffset2;
    }

    private static int B(CharSequence charSequence, int i3, boolean z2) {
        if (z2 && charSequence.charAt(i3 - 1) != ':') {
            throw new DateTimeException("Invalid ID for ZoneOffset, colon not found when expected: " + ((Object) charSequence));
        }
        char cCharAt = charSequence.charAt(i3);
        char cCharAt2 = charSequence.charAt(i3 + 1);
        if (cCharAt >= '0' && cCharAt <= '9' && cCharAt2 >= '0' && cCharAt2 <= '9') {
            return ((cCharAt - '0') * 10) + (cCharAt2 - '0');
        }
        throw new DateTimeException("Invalid ID for ZoneOffset, non numeric characters found: " + ((Object) charSequence));
    }

    static ZoneOffset C(DataInput dataInput) throws IOException {
        byte b3 = dataInput.readByte();
        return b3 == 127 ? A(dataInput.readInt()) : A(b3 * 900);
    }

    private static int D(int i3, int i4, int i5) {
        return (i3 * AccessTokenManager.TOKEN_EXTEND_RETRY_SECONDS) + (i4 * 60) + i5;
    }

    private static void E(int i3, int i4, int i5) {
        if (i3 < -18 || i3 > 18) {
            throw new DateTimeException("Zone offset hours not in valid range: value " + i3 + " is not in the range -18 to 18");
        }
        if (i3 > 0) {
            if (i4 < 0 || i5 < 0) {
                throw new DateTimeException("Zone offset minutes and seconds must be positive because hours is positive");
            }
        } else if (i3 < 0) {
            if (i4 > 0 || i5 > 0) {
                throw new DateTimeException("Zone offset minutes and seconds must be negative because hours is negative");
            }
        } else if ((i4 > 0 && i5 < 0) || (i4 < 0 && i5 > 0)) {
            throw new DateTimeException("Zone offset minutes and seconds must have the same sign");
        }
        if (Math.abs(i4) > 59) {
            throw new DateTimeException("Zone offset minutes not in valid range: abs(value) " + Math.abs(i4) + " is not in the range 0 to 59");
        }
        if (Math.abs(i5) > 59) {
            throw new DateTimeException("Zone offset seconds not in valid range: abs(value) " + Math.abs(i5) + " is not in the range 0 to 59");
        }
        if (Math.abs(i3) == 18) {
            if (Math.abs(i4) > 0 || Math.abs(i5) > 0) {
                throw new DateTimeException("Zone offset not in valid range: -18:00 to +18:00");
            }
        }
    }

    private Object readResolve() throws ObjectStreamException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private static String u(int i3) {
        if (i3 == 0) {
            return "Z";
        }
        int iAbs = Math.abs(i3);
        StringBuilder sb = new StringBuilder();
        int i4 = iAbs / AccessTokenManager.TOKEN_EXTEND_RETRY_SECONDS;
        int i5 = (iAbs / 60) % 60;
        sb.append(i3 < 0 ? "-" : "+");
        sb.append(i4 < 10 ? AppEventsConstants.EVENT_PARAM_VALUE_NO : "");
        sb.append(i4);
        String str = Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR;
        sb.append(i5 < 10 ? ":0" : Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR);
        sb.append(i5);
        int i6 = iAbs % 60;
        if (i6 != 0) {
            if (i6 < 10) {
                str = ":0";
            }
            sb.append(str);
            sb.append(i6);
        }
        return sb.toString();
    }

    public static ZoneOffset w(TemporalAccessor temporalAccessor) {
        ZoneOffset zoneOffset = (ZoneOffset) temporalAccessor.e(TemporalQueries.d());
        if (zoneOffset != null) {
            return zoneOffset;
        }
        throw new DateTimeException("Unable to obtain ZoneOffset from TemporalAccessor: " + temporalAccessor + ", type " + temporalAccessor.getClass().getName());
    }

    private Object writeReplace() {
        return new Ser((byte) 8, this);
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00be  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static org.threeten.bp.ZoneOffset y(java.lang.String r7) {
        /*
            java.lang.String r0 = "offsetId"
            org.threeten.bp.jdk8.Jdk8Methods.i(r7, r0)
            java.util.concurrent.ConcurrentMap r0 = org.threeten.bp.ZoneOffset.f146221h
            java.lang.Object r0 = r0.get(r7)
            org.threeten.bp.ZoneOffset r0 = (org.threeten.bp.ZoneOffset) r0
            if (r0 == 0) goto L10
            return r0
        L10:
            int r0 = r7.length()
            r1 = 2
            r2 = 1
            r3 = 0
            if (r0 == r1) goto L6e
            r1 = 3
            if (r0 == r1) goto L8a
            r4 = 5
            if (r0 == r4) goto L65
            r5 = 6
            r6 = 4
            if (r0 == r5) goto L5b
            r5 = 7
            if (r0 == r5) goto L4e
            r1 = 9
            if (r0 != r1) goto L37
            int r0 = B(r7, r2, r3)
            int r1 = B(r7, r6, r2)
            int r2 = B(r7, r5, r2)
            goto L90
        L37:
            org.threeten.bp.DateTimeException r0 = new org.threeten.bp.DateTimeException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Invalid ID for ZoneOffset, invalid format: "
            r1.append(r2)
            r1.append(r7)
            java.lang.String r7 = r1.toString()
            r0.<init>(r7)
            throw r0
        L4e:
            int r0 = B(r7, r2, r3)
            int r1 = B(r7, r1, r3)
            int r2 = B(r7, r4, r3)
            goto L90
        L5b:
            int r0 = B(r7, r2, r3)
            int r1 = B(r7, r6, r2)
        L63:
            r2 = r3
            goto L90
        L65:
            int r0 = B(r7, r2, r3)
            int r1 = B(r7, r1, r3)
            goto L63
        L6e:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            char r1 = r7.charAt(r3)
            r0.append(r1)
            java.lang.String r1 = "0"
            r0.append(r1)
            char r7 = r7.charAt(r2)
            r0.append(r7)
            java.lang.String r7 = r0.toString()
        L8a:
            int r0 = B(r7, r2, r3)
            r1 = r3
            r2 = r1
        L90:
            char r3 = r7.charAt(r3)
            r4 = 43
            r5 = 45
            if (r3 == r4) goto Lb4
            if (r3 != r5) goto L9d
            goto Lb4
        L9d:
            org.threeten.bp.DateTimeException r0 = new org.threeten.bp.DateTimeException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Invalid ID for ZoneOffset, plus/minus not found when expected: "
            r1.append(r2)
            r1.append(r7)
            java.lang.String r7 = r1.toString()
            r0.<init>(r7)
            throw r0
        Lb4:
            if (r3 != r5) goto Lbe
            int r7 = -r0
            int r0 = -r1
            int r1 = -r2
            org.threeten.bp.ZoneOffset r7 = z(r7, r0, r1)
            return r7
        Lbe:
            org.threeten.bp.ZoneOffset r7 = z(r0, r1, r2)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: org.threeten.bp.ZoneOffset.y(java.lang.String):org.threeten.bp.ZoneOffset");
    }

    public static ZoneOffset z(int i3, int i4, int i5) {
        E(i3, i4, i5);
        return A(D(i3, i4, i5));
    }

    void F(DataOutput dataOutput) {
        int i3 = this.f146225c;
        int i4 = i3 % 900 == 0 ? i3 / 900 : 127;
        dataOutput.writeByte(i4);
        if (i4 == 127) {
            dataOutput.writeInt(i3);
        }
    }

    @Override // org.threeten.bp.temporal.TemporalAdjuster
    public Temporal b(Temporal temporal) {
        return temporal.a(ChronoField.I, this.f146225c);
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public ValueRange c(TemporalField temporalField) {
        if (temporalField == ChronoField.I) {
            return temporalField.range();
        }
        if (!(temporalField instanceof ChronoField)) {
            return temporalField.c(this);
        }
        throw new UnsupportedTemporalTypeException("Unsupported field: " + temporalField);
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public Object e(TemporalQuery temporalQuery) {
        if (temporalQuery == TemporalQueries.d() || temporalQuery == TemporalQueries.f()) {
            return this;
        }
        if (temporalQuery == TemporalQueries.b() || temporalQuery == TemporalQueries.c() || temporalQuery == TemporalQueries.e() || temporalQuery == TemporalQueries.a() || temporalQuery == TemporalQueries.g()) {
            return null;
        }
        return temporalQuery.a(this);
    }

    @Override // org.threeten.bp.ZoneId
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ZoneOffset) && this.f146225c == ((ZoneOffset) obj).f146225c;
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public boolean g(TemporalField temporalField) {
        return temporalField instanceof ChronoField ? temporalField == ChronoField.I : temporalField != null && temporalField.b(this);
    }

    @Override // org.threeten.bp.ZoneId
    public String getId() {
        return this.f146226d;
    }

    @Override // org.threeten.bp.ZoneId
    public int hashCode() {
        return this.f146225c;
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public int j(TemporalField temporalField) {
        if (temporalField == ChronoField.I) {
            return this.f146225c;
        }
        if (!(temporalField instanceof ChronoField)) {
            return c(temporalField).a(m(temporalField), temporalField);
        }
        throw new UnsupportedTemporalTypeException("Unsupported field: " + temporalField);
    }

    @Override // org.threeten.bp.ZoneId
    public ZoneRules l() {
        return ZoneRules.g(this);
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public long m(TemporalField temporalField) {
        if (temporalField == ChronoField.I) {
            return this.f146225c;
        }
        if (!(temporalField instanceof ChronoField)) {
            return temporalField.d(this);
        }
        throw new DateTimeException("Unsupported field: " + temporalField);
    }

    @Override // org.threeten.bp.ZoneId
    void t(DataOutput dataOutput) throws IOException {
        dataOutput.writeByte(8);
        F(dataOutput);
    }

    @Override // org.threeten.bp.ZoneId
    public String toString() {
        return this.f146226d;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
    public int compareTo(ZoneOffset zoneOffset) {
        return zoneOffset.f146225c - this.f146225c;
    }

    public int x() {
        return this.f146225c;
    }
}
