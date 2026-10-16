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
public final class MinguoChronology extends Chronology implements Serializable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final MinguoChronology f146312f = new MinguoChronology();
    private static final long serialVersionUID = 1039765215346859963L;

    /* JADX INFO: renamed from: org.threeten.bp.chrono.MinguoChronology$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f146313a;

        static {
            int[] iArr = new int[ChronoField.values().length];
            f146313a = iArr;
            try {
                iArr[ChronoField.D.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f146313a[ChronoField.E.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f146313a[ChronoField.F.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private MinguoChronology() {
    }

    private Object readResolve() {
        return f146312f;
    }

    @Override // org.threeten.bp.chrono.Chronology
    public String getCalendarType() {
        return "roc";
    }

    @Override // org.threeten.bp.chrono.Chronology
    public String getId() {
        return "Minguo";
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
    public MinguoDate b(int i3, int i4, int i5) {
        return new MinguoDate(LocalDate.f0(i3 + 1911, i4, i5));
    }

    @Override // org.threeten.bp.chrono.Chronology
    /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] */
    public MinguoDate c(TemporalAccessor temporalAccessor) {
        return temporalAccessor instanceof MinguoDate ? (MinguoDate) temporalAccessor : new MinguoDate(LocalDate.I(temporalAccessor));
    }

    @Override // org.threeten.bp.chrono.Chronology
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public MinguoDate d(long j3) {
        return new MinguoDate(LocalDate.i0(j3));
    }

    @Override // org.threeten.bp.chrono.Chronology
    /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
    public MinguoEra h(int i3) {
        return MinguoEra.d(i3);
    }

    public ValueRange w(ChronoField chronoField) {
        int i3 = AnonymousClass1.f146313a[chronoField.ordinal()];
        if (i3 == 1) {
            ValueRange valueRangeRange = ChronoField.D.range();
            return ValueRange.i(valueRangeRange.d() - 22932, valueRangeRange.c() - 22932);
        }
        if (i3 == 2) {
            ValueRange valueRangeRange2 = ChronoField.F.range();
            return ValueRange.j(1L, valueRangeRange2.c() - 1911, (-valueRangeRange2.d()) + 1912);
        }
        if (i3 != 3) {
            return chronoField.range();
        }
        ValueRange valueRangeRange3 = ChronoField.F.range();
        return ValueRange.i(valueRangeRange3.d() - 1911, valueRangeRange3.c() - 1911);
    }
}
