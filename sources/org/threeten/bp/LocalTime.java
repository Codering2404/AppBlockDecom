package org.threeten.bp;

import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.AccessTokenManager;
import com.facebook.appevents.AppEventsConstants;
import com.revenuecat.purchases.common.Constants;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor;
import org.threeten.bp.jdk8.Jdk8Methods;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.ChronoUnit;
import org.threeten.bp.temporal.Temporal;
import org.threeten.bp.temporal.TemporalAccessor;
import org.threeten.bp.temporal.TemporalAdjuster;
import org.threeten.bp.temporal.TemporalField;
import org.threeten.bp.temporal.TemporalQueries;
import org.threeten.bp.temporal.TemporalQuery;
import org.threeten.bp.temporal.TemporalUnit;
import org.threeten.bp.temporal.UnsupportedTemporalTypeException;
import org.threeten.bp.temporal.ValueRange;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class LocalTime extends DefaultInterfaceTemporalAccessor implements Temporal, TemporalAdjuster, Comparable<LocalTime>, Serializable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final LocalTime f146152f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final LocalTime f146153g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final LocalTime f146154h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final LocalTime f146155i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final TemporalQuery f146156j = new TemporalQuery<LocalTime>() { // from class: org.threeten.bp.LocalTime.1
        @Override // org.threeten.bp.temporal.TemporalQuery
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public LocalTime a(TemporalAccessor temporalAccessor) {
            return LocalTime.s(temporalAccessor);
        }
    };

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final LocalTime[] f146157k = new LocalTime[24];
    private static final long serialVersionUID = 6414437269572265201L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final byte f146158a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final byte f146159b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final byte f146160c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f146161d;

    /* JADX INFO: renamed from: org.threeten.bp.LocalTime$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static /* synthetic */ class AnonymousClass2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f146162a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f146163b;

        static {
            int[] iArr = new int[ChronoUnit.values().length];
            f146163b = iArr;
            try {
                iArr[ChronoUnit.NANOS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f146163b[ChronoUnit.MICROS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f146163b[ChronoUnit.MILLIS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f146163b[ChronoUnit.SECONDS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f146163b[ChronoUnit.MINUTES.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f146163b[ChronoUnit.HOURS.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f146163b[ChronoUnit.HALF_DAYS.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            int[] iArr2 = new int[ChronoField.values().length];
            f146162a = iArr2;
            try {
                iArr2[ChronoField.f146484f.ordinal()] = 1;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f146162a[ChronoField.f146485g.ordinal()] = 2;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f146162a[ChronoField.f146486h.ordinal()] = 3;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f146162a[ChronoField.f146487i.ordinal()] = 4;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f146162a[ChronoField.f146488j.ordinal()] = 5;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f146162a[ChronoField.f146489k.ordinal()] = 6;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f146162a[ChronoField.f146490l.ordinal()] = 7;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f146162a[ChronoField.f146491m.ordinal()] = 8;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f146162a[ChronoField.f146492n.ordinal()] = 9;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f146162a[ChronoField.f146493o.ordinal()] = 10;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                f146162a[ChronoField.f146494p.ordinal()] = 11;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                f146162a[ChronoField.f146495q.ordinal()] = 12;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                f146162a[ChronoField.f146496r.ordinal()] = 13;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                f146162a[ChronoField.f146497s.ordinal()] = 14;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                f146162a[ChronoField.f146498t.ordinal()] = 15;
            } catch (NoSuchFieldError unused22) {
            }
        }
    }

    static {
        int i3 = 0;
        while (true) {
            LocalTime[] localTimeArr = f146157k;
            if (i3 >= localTimeArr.length) {
                LocalTime localTime = localTimeArr[0];
                f146154h = localTime;
                f146155i = localTimeArr[12];
                f146152f = localTime;
                f146153g = new LocalTime(23, 59, 59, 999999999);
                return;
            }
            localTimeArr[i3] = new LocalTime(i3, 0, 0, 0);
            i3++;
        }
    }

    private LocalTime(int i3, int i4, int i5, int i6) {
        this.f146158a = (byte) i3;
        this.f146159b = (byte) i4;
        this.f146160c = (byte) i5;
        this.f146161d = i6;
    }

    public static LocalTime A(int i3, int i4) {
        ChronoField.f146496r.g(i3);
        if (i4 == 0) {
            return f146157k[i3];
        }
        ChronoField.f146492n.g(i4);
        return new LocalTime(i3, i4, 0, 0);
    }

    public static LocalTime B(int i3, int i4, int i5) {
        ChronoField.f146496r.g(i3);
        if ((i4 | i5) == 0) {
            return f146157k[i3];
        }
        ChronoField.f146492n.g(i4);
        ChronoField.f146490l.g(i5);
        return new LocalTime(i3, i4, i5, 0);
    }

    public static LocalTime D(int i3, int i4, int i5, int i6) {
        ChronoField.f146496r.g(i3);
        ChronoField.f146492n.g(i4);
        ChronoField.f146490l.g(i5);
        ChronoField.f146484f.g(i6);
        return r(i3, i4, i5, i6);
    }

    public static LocalTime E(long j3) {
        ChronoField.f146485g.g(j3);
        int i3 = (int) (j3 / 3600000000000L);
        long j4 = j3 - (((long) i3) * 3600000000000L);
        int i4 = (int) (j4 / 60000000000L);
        long j5 = j4 - (((long) i4) * 60000000000L);
        int i5 = (int) (j5 / 1000000000);
        return r(i3, i4, i5, (int) (j5 - (((long) i5) * 1000000000)));
    }

    public static LocalTime F(long j3) {
        ChronoField.f146491m.g(j3);
        int i3 = (int) (j3 / 3600);
        long j4 = j3 - ((long) (i3 * AccessTokenManager.TOKEN_EXTEND_RETRY_SECONDS));
        int i4 = (int) (j4 / 60);
        return r(i3, i4, (int) (j4 - ((long) (i4 * 60))), 0);
    }

    static LocalTime G(long j3, int i3) {
        ChronoField.f146491m.g(j3);
        ChronoField.f146484f.g(i3);
        int i4 = (int) (j3 / 3600);
        long j4 = j3 - ((long) (i4 * AccessTokenManager.TOKEN_EXTEND_RETRY_SECONDS));
        int i5 = (int) (j4 / 60);
        return r(i4, i5, (int) (j4 - ((long) (i5 * 60))), i3);
    }

    static LocalTime S(DataInput dataInput) throws IOException {
        int i3;
        int i4;
        int i5 = dataInput.readByte();
        int i6 = 0;
        if (i5 < 0) {
            i5 = ~i5;
            i4 = 0;
            i3 = 0;
        } else {
            byte b3 = dataInput.readByte();
            if (b3 < 0) {
                int i7 = ~b3;
                i3 = 0;
                i6 = i7;
                i4 = 0;
            } else {
                byte b4 = dataInput.readByte();
                if (b4 < 0) {
                    i4 = ~b4;
                    i3 = 0;
                    i6 = b3;
                } else {
                    i3 = dataInput.readInt();
                    i6 = b3;
                    i4 = b4;
                }
            }
        }
        return D(i5, i6, i4, i3);
    }

    private static LocalTime r(int i3, int i4, int i5, int i6) {
        return ((i4 | i5) | i6) == 0 ? f146157k[i3] : new LocalTime(i3, i4, i5, i6);
    }

    private Object readResolve() throws ObjectStreamException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    public static LocalTime s(TemporalAccessor temporalAccessor) {
        LocalTime localTime = (LocalTime) temporalAccessor.e(TemporalQueries.c());
        if (localTime != null) {
            return localTime;
        }
        throw new DateTimeException("Unable to obtain LocalTime from TemporalAccessor: " + temporalAccessor + ", type " + temporalAccessor.getClass().getName());
    }

    private int t(TemporalField temporalField) {
        switch (AnonymousClass2.f146162a[((ChronoField) temporalField).ordinal()]) {
            case 1:
                return this.f146161d;
            case 2:
                throw new DateTimeException("Field too large for an int: " + temporalField);
            case 3:
                return this.f146161d / 1000;
            case 4:
                throw new DateTimeException("Field too large for an int: " + temporalField);
            case 5:
                return this.f146161d / 1000000;
            case 6:
                return (int) (U() / 1000000);
            case 7:
                return this.f146160c;
            case 8:
                return V();
            case 9:
                return this.f146159b;
            case 10:
                return (this.f146158a * 60) + this.f146159b;
            case 11:
                return this.f146158a % Ascii.FF;
            case 12:
                int i3 = this.f146158a % Ascii.FF;
                if (i3 % 12 == 0) {
                    return 12;
                }
                return i3;
            case 13:
                return this.f146158a;
            case 14:
                byte b3 = this.f146158a;
                if (b3 == 0) {
                    return 24;
                }
                return b3;
            case 15:
                return this.f146158a / Ascii.FF;
            default:
                throw new UnsupportedTemporalTypeException("Unsupported field: " + temporalField);
        }
    }

    private Object writeReplace() {
        return new Ser((byte) 5, this);
    }

    @Override // org.threeten.bp.temporal.Temporal
    /* JADX INFO: renamed from: H, reason: merged with bridge method [inline-methods] */
    public LocalTime u(long j3, TemporalUnit temporalUnit) {
        if (!(temporalUnit instanceof ChronoUnit)) {
            return (LocalTime) temporalUnit.b(this, j3);
        }
        switch (AnonymousClass2.f146163b[((ChronoUnit) temporalUnit).ordinal()]) {
            case 1:
                return Q(j3);
            case 2:
                return Q((j3 % 86400000000L) * 1000);
            case 3:
                return Q((j3 % 86400000) * 1000000);
            case 4:
                return R(j3);
            case 5:
                return P(j3);
            case 6:
                return I(j3);
            case 7:
                return I((j3 % 2) * 12);
            default:
                throw new UnsupportedTemporalTypeException("Unsupported unit: " + temporalUnit);
        }
    }

    public LocalTime I(long j3) {
        return j3 == 0 ? this : r(((((int) (j3 % 24)) + this.f146158a) + 24) % 24, this.f146159b, this.f146160c, this.f146161d);
    }

    public LocalTime P(long j3) {
        if (j3 != 0) {
            int i3 = (this.f146158a * 60) + this.f146159b;
            int i4 = ((((int) (j3 % 1440)) + i3) + 1440) % 1440;
            if (i3 != i4) {
                return r(i4 / 60, i4 % 60, this.f146160c, this.f146161d);
            }
        }
        return this;
    }

    public LocalTime Q(long j3) {
        if (j3 != 0) {
            long jU = U();
            long j4 = (((j3 % 86400000000000L) + jU) + 86400000000000L) % 86400000000000L;
            if (jU != j4) {
                return r((int) (j4 / 3600000000000L), (int) ((j4 / 60000000000L) % 60), (int) ((j4 / 1000000000) % 60), (int) (j4 % 1000000000));
            }
        }
        return this;
    }

    public LocalTime R(long j3) {
        if (j3 != 0) {
            int i3 = (this.f146158a * Ascii.DLE) + (this.f146159b * 60) + this.f146160c;
            int i4 = ((((int) (j3 % 86400)) + i3) + AccessTokenManager.TOKEN_EXTEND_THRESHOLD_SECONDS) % AccessTokenManager.TOKEN_EXTEND_THRESHOLD_SECONDS;
            if (i3 != i4) {
                return r(i4 / AccessTokenManager.TOKEN_EXTEND_RETRY_SECONDS, (i4 / 60) % 60, i4 % 60, this.f146161d);
            }
        }
        return this;
    }

    public long U() {
        return (((long) this.f146158a) * 3600000000000L) + (((long) this.f146159b) * 60000000000L) + (((long) this.f146160c) * 1000000000) + ((long) this.f146161d);
    }

    public int V() {
        return (this.f146158a * Ascii.DLE) + (this.f146159b * 60) + this.f146160c;
    }

    @Override // org.threeten.bp.temporal.Temporal
    /* JADX INFO: renamed from: W, reason: merged with bridge method [inline-methods] */
    public LocalTime z(TemporalAdjuster temporalAdjuster) {
        return temporalAdjuster instanceof LocalTime ? (LocalTime) temporalAdjuster : (LocalTime) temporalAdjuster.b(this);
    }

    @Override // org.threeten.bp.temporal.Temporal
    /* JADX INFO: renamed from: X, reason: merged with bridge method [inline-methods] */
    public LocalTime a(TemporalField temporalField, long j3) {
        if (!(temporalField instanceof ChronoField)) {
            return (LocalTime) temporalField.a(this, j3);
        }
        ChronoField chronoField = (ChronoField) temporalField;
        chronoField.g(j3);
        switch (AnonymousClass2.f146162a[chronoField.ordinal()]) {
            case 1:
                return a0((int) j3);
            case 2:
                return E(j3);
            case 3:
                return a0(((int) j3) * 1000);
            case 4:
                return E(j3 * 1000);
            case 5:
                return a0(((int) j3) * 1000000);
            case 6:
                return E(j3 * 1000000);
            case 7:
                return b0((int) j3);
            case 8:
                return R(j3 - ((long) V()));
            case 9:
                return Z((int) j3);
            case 10:
                return P(j3 - ((long) ((this.f146158a * 60) + this.f146159b)));
            case 11:
                return I(j3 - ((long) (this.f146158a % Ascii.FF)));
            case 12:
                if (j3 == 12) {
                    j3 = 0;
                }
                return I(j3 - ((long) (this.f146158a % Ascii.FF)));
            case 13:
                return Y((int) j3);
            case 14:
                if (j3 == 24) {
                    j3 = 0;
                }
                return Y((int) j3);
            case 15:
                return I((j3 - ((long) (this.f146158a / Ascii.FF))) * 12);
            default:
                throw new UnsupportedTemporalTypeException("Unsupported field: " + temporalField);
        }
    }

    public LocalTime Y(int i3) {
        if (this.f146158a == i3) {
            return this;
        }
        ChronoField.f146496r.g(i3);
        return r(i3, this.f146159b, this.f146160c, this.f146161d);
    }

    public LocalTime Z(int i3) {
        if (this.f146159b == i3) {
            return this;
        }
        ChronoField.f146492n.g(i3);
        return r(this.f146158a, i3, this.f146160c, this.f146161d);
    }

    public LocalTime a0(int i3) {
        if (this.f146161d == i3) {
            return this;
        }
        ChronoField.f146484f.g(i3);
        return r(this.f146158a, this.f146159b, this.f146160c, i3);
    }

    @Override // org.threeten.bp.temporal.TemporalAdjuster
    public Temporal b(Temporal temporal) {
        return temporal.a(ChronoField.f146485g, U());
    }

    public LocalTime b0(int i3) {
        if (this.f146160c == i3) {
            return this;
        }
        ChronoField.f146490l.g(i3);
        return r(this.f146158a, this.f146159b, i3, this.f146161d);
    }

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor, org.threeten.bp.temporal.TemporalAccessor
    public ValueRange c(TemporalField temporalField) {
        return super.c(temporalField);
    }

    void c0(DataOutput dataOutput) {
        if (this.f146161d != 0) {
            dataOutput.writeByte(this.f146158a);
            dataOutput.writeByte(this.f146159b);
            dataOutput.writeByte(this.f146160c);
            dataOutput.writeInt(this.f146161d);
            return;
        }
        if (this.f146160c != 0) {
            dataOutput.writeByte(this.f146158a);
            dataOutput.writeByte(this.f146159b);
            dataOutput.writeByte(~this.f146160c);
        } else if (this.f146159b == 0) {
            dataOutput.writeByte(~this.f146158a);
        } else {
            dataOutput.writeByte(this.f146158a);
            dataOutput.writeByte(~this.f146159b);
        }
    }

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor, org.threeten.bp.temporal.TemporalAccessor
    public Object e(TemporalQuery temporalQuery) {
        if (temporalQuery == TemporalQueries.e()) {
            return ChronoUnit.NANOS;
        }
        if (temporalQuery == TemporalQueries.c()) {
            return this;
        }
        if (temporalQuery == TemporalQueries.a() || temporalQuery == TemporalQueries.g() || temporalQuery == TemporalQueries.f() || temporalQuery == TemporalQueries.d() || temporalQuery == TemporalQueries.b()) {
            return null;
        }
        return temporalQuery.a(this);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof LocalTime) {
            LocalTime localTime = (LocalTime) obj;
            if (this.f146158a == localTime.f146158a && this.f146159b == localTime.f146159b && this.f146160c == localTime.f146160c && this.f146161d == localTime.f146161d) {
                return true;
            }
        }
        return false;
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public boolean g(TemporalField temporalField) {
        return temporalField instanceof ChronoField ? temporalField.isTimeBased() : temporalField != null && temporalField.b(this);
    }

    public int hashCode() {
        long jU = U();
        return (int) (jU ^ (jU >>> 32));
    }

    @Override // org.threeten.bp.temporal.Temporal
    public long i(Temporal temporal, TemporalUnit temporalUnit) {
        LocalTime localTimeS = s(temporal);
        if (!(temporalUnit instanceof ChronoUnit)) {
            return temporalUnit.a(this, localTimeS);
        }
        long jU = localTimeS.U() - U();
        switch (AnonymousClass2.f146163b[((ChronoUnit) temporalUnit).ordinal()]) {
            case 1:
                return jU;
            case 2:
                return jU / 1000;
            case 3:
                return jU / 1000000;
            case 4:
                return jU / 1000000000;
            case 5:
                return jU / 60000000000L;
            case 6:
                return jU / 3600000000000L;
            case 7:
                return jU / 43200000000000L;
            default:
                throw new UnsupportedTemporalTypeException("Unsupported unit: " + temporalUnit);
        }
    }

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor, org.threeten.bp.temporal.TemporalAccessor
    public int j(TemporalField temporalField) {
        return temporalField instanceof ChronoField ? t(temporalField) : super.j(temporalField);
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public long m(TemporalField temporalField) {
        return temporalField instanceof ChronoField ? temporalField == ChronoField.f146485g ? U() : temporalField == ChronoField.f146487i ? U() / 1000 : t(temporalField) : temporalField.d(this);
    }

    public OffsetTime p(ZoneOffset zoneOffset) {
        return OffsetTime.t(this, zoneOffset);
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public int compareTo(LocalTime localTime) {
        int iA = Jdk8Methods.a(this.f146158a, localTime.f146158a);
        return (iA == 0 && (iA = Jdk8Methods.a(this.f146159b, localTime.f146159b)) == 0 && (iA = Jdk8Methods.a(this.f146160c, localTime.f146160c)) == 0) ? Jdk8Methods.a(this.f146161d, localTime.f146161d) : iA;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(18);
        byte b3 = this.f146158a;
        byte b4 = this.f146159b;
        byte b5 = this.f146160c;
        int i3 = this.f146161d;
        sb.append(b3 < 10 ? AppEventsConstants.EVENT_PARAM_VALUE_NO : "");
        sb.append((int) b3);
        String str = Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR;
        sb.append(b4 < 10 ? ":0" : Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR);
        sb.append((int) b4);
        if (b5 > 0 || i3 > 0) {
            if (b5 < 10) {
                str = ":0";
            }
            sb.append(str);
            sb.append((int) b5);
            if (i3 > 0) {
                sb.append('.');
                if (i3 % 1000000 == 0) {
                    sb.append(Integer.toString((i3 / 1000000) + 1000).substring(1));
                } else if (i3 % 1000 == 0) {
                    sb.append(Integer.toString((i3 / 1000) + 1000000).substring(1));
                } else {
                    sb.append(Integer.toString(i3 + 1000000000).substring(1));
                }
            }
        }
        return sb.toString();
    }

    public int u() {
        return this.f146158a;
    }

    public int v() {
        return this.f146161d;
    }

    public int w() {
        return this.f146160c;
    }

    public boolean x(LocalTime localTime) {
        return compareTo(localTime) > 0;
    }

    public boolean y(LocalTime localTime) {
        return compareTo(localTime) < 0;
    }

    @Override // org.threeten.bp.temporal.Temporal
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public LocalTime t(long j3, TemporalUnit temporalUnit) {
        return j3 == Long.MIN_VALUE ? w(Long.MAX_VALUE, temporalUnit).w(1L, temporalUnit) : w(-j3, temporalUnit);
    }
}
