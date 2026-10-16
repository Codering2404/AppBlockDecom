package org.threeten.bp.chrono;

import java.io.Serializable;
import org.threeten.bp.DateTimeException;
import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalTime;
import org.threeten.bp.chrono.ChronoLocalDate;
import org.threeten.bp.jdk8.Jdk8Methods;
import org.threeten.bp.temporal.ChronoUnit;
import org.threeten.bp.temporal.Temporal;
import org.threeten.bp.temporal.TemporalAdjuster;
import org.threeten.bp.temporal.TemporalUnit;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
abstract class ChronoDateImpl<D extends ChronoLocalDate> extends ChronoLocalDate implements Temporal, TemporalAdjuster, Serializable {
    private static final long serialVersionUID = 6282433883239719096L;

    /* JADX INFO: renamed from: org.threeten.bp.chrono.ChronoDateImpl$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f146235a;

        static {
            int[] iArr = new int[ChronoUnit.values().length];
            f146235a = iArr;
            try {
                iArr[ChronoUnit.DAYS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f146235a[ChronoUnit.WEEKS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f146235a[ChronoUnit.MONTHS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f146235a[ChronoUnit.YEARS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f146235a[ChronoUnit.DECADES.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f146235a[ChronoUnit.CENTURIES.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f146235a[ChronoUnit.MILLENNIA.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    ChronoDateImpl() {
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate
    /* JADX INFO: renamed from: B */
    public ChronoDateImpl u(long j3, TemporalUnit temporalUnit) {
        if (!(temporalUnit instanceof ChronoUnit)) {
            return (ChronoDateImpl) s().e(temporalUnit.b(this, j3));
        }
        switch (AnonymousClass1.f146235a[((ChronoUnit) temporalUnit).ordinal()]) {
            case 1:
                return D(j3);
            case 2:
                return D(Jdk8Methods.m(j3, 7));
            case 3:
                return E(j3);
            case 4:
                return F(j3);
            case 5:
                return F(Jdk8Methods.m(j3, 10));
            case 6:
                return F(Jdk8Methods.m(j3, 100));
            case 7:
                return F(Jdk8Methods.m(j3, 1000));
            default:
                throw new DateTimeException(temporalUnit + " not valid for chronology " + s().getId());
        }
    }

    abstract ChronoDateImpl D(long j3);

    abstract ChronoDateImpl E(long j3);

    abstract ChronoDateImpl F(long j3);

    @Override // org.threeten.bp.temporal.Temporal
    public long i(Temporal temporal, TemporalUnit temporalUnit) {
        ChronoLocalDate chronoLocalDateC = s().c(temporal);
        return temporalUnit instanceof ChronoUnit ? LocalDate.I(this).i(chronoLocalDateC, temporalUnit) : temporalUnit.a(this, chronoLocalDateC);
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate
    public ChronoLocalDateTime q(LocalTime localTime) {
        return ChronoLocalDateTimeImpl.E(this, localTime);
    }
}
