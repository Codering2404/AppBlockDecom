package org.threeten.bp.chrono;

import java.io.Serializable;
import org.threeten.bp.Instant;
import org.threeten.bp.LocalDate;
import org.threeten.bp.ZoneId;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.TemporalAccessor;
import org.threeten.bp.temporal.ValueRange;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class ThaiBuddhistChronology extends Chronology implements Serializable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final ThaiBuddhistChronology f146321f = new ThaiBuddhistChronology();
    private static final long serialVersionUID = 2775954514031616474L;

    /* JADX INFO: renamed from: org.threeten.bp.chrono.ThaiBuddhistChronology$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f146322a;

        static {
            int[] iArr = new int[ChronoField.values().length];
            f146322a = iArr;
            try {
                iArr[ChronoField.D.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f146322a[ChronoField.E.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f146322a[ChronoField.F.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private ThaiBuddhistChronology() {
    }

    private Object readResolve() {
        return f146321f;
    }

    @Override // org.threeten.bp.chrono.Chronology
    public String getCalendarType() {
        return "buddhist";
    }

    @Override // org.threeten.bp.chrono.Chronology
    public String getId() {
        return "ThaiBuddhist";
    }

    @Override // org.threeten.bp.chrono.Chronology
    public ChronoLocalDateTime k(TemporalAccessor temporalAccessor) {
        return super.k(temporalAccessor);
    }

    @Override // org.threeten.bp.chrono.Chronology
    public ChronoZonedDateTime q(Instant instant, ZoneId zoneId) {
        return super.q(instant, zoneId);
    }

    @Override // org.threeten.bp.chrono.Chronology
    public ChronoZonedDateTime r(TemporalAccessor temporalAccessor) {
        return super.r(temporalAccessor);
    }

    @Override // org.threeten.bp.chrono.Chronology
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public ThaiBuddhistDate b(int i3, int i4, int i5) {
        return new ThaiBuddhistDate(LocalDate.f0(i3 - 543, i4, i5));
    }

    @Override // org.threeten.bp.chrono.Chronology
    /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] */
    public ThaiBuddhistDate c(TemporalAccessor temporalAccessor) {
        return temporalAccessor instanceof ThaiBuddhistDate ? (ThaiBuddhistDate) temporalAccessor : new ThaiBuddhistDate(LocalDate.I(temporalAccessor));
    }

    @Override // org.threeten.bp.chrono.Chronology
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public ThaiBuddhistDate d(long j3) {
        return new ThaiBuddhistDate(LocalDate.i0(j3));
    }

    @Override // org.threeten.bp.chrono.Chronology
    /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
    public ThaiBuddhistEra h(int i3) {
        return ThaiBuddhistEra.d(i3);
    }

    public ValueRange w(ChronoField chronoField) {
        int i3 = AnonymousClass1.f146322a[chronoField.ordinal()];
        if (i3 == 1) {
            ValueRange valueRangeRange = ChronoField.D.range();
            return ValueRange.i(valueRangeRange.d() + 6516, valueRangeRange.c() + 6516);
        }
        if (i3 == 2) {
            ValueRange valueRangeRange2 = ChronoField.F.range();
            return ValueRange.j(1L, (-(valueRangeRange2.d() + 543)) + 1, valueRangeRange2.c() + 543);
        }
        if (i3 != 3) {
            return chronoField.range();
        }
        ValueRange valueRangeRange3 = ChronoField.F.range();
        return ValueRange.i(valueRangeRange3.d() + 543, valueRangeRange3.c() + 543);
    }
}
