package org.threeten.bp.chrono;

import java.io.Serializable;
import java.util.HashMap;
import org.threeten.bp.DateTimeException;
import org.threeten.bp.Instant;
import org.threeten.bp.LocalDate;
import org.threeten.bp.ZoneId;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.TemporalAccessor;
import org.threeten.bp.temporal.ValueRange;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class HijrahChronology extends Chronology implements Serializable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final HijrahChronology f146256f = new HijrahChronology();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final HashMap f146257g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final HashMap f146258h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final HashMap f146259i;
    private static final long serialVersionUID = 3127340209035924785L;

    static {
        HashMap map = new HashMap();
        f146257g = map;
        HashMap map2 = new HashMap();
        f146258h = map2;
        HashMap map3 = new HashMap();
        f146259i = map3;
        map.put("en", new String[]{"BH", "HE"});
        map2.put("en", new String[]{"B.H.", "H.E."});
        map3.put("en", new String[]{"Before Hijrah", "Hijrah Era"});
    }

    private HijrahChronology() {
    }

    private Object readResolve() {
        return f146256f;
    }

    @Override // org.threeten.bp.chrono.Chronology
    public String getCalendarType() {
        return "islamic-umalqura";
    }

    @Override // org.threeten.bp.chrono.Chronology
    public String getId() {
        return "Hijrah-umalqura";
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
    public HijrahDate b(int i3, int i4, int i5) {
        return HijrahDate.o0(i3, i4, i5);
    }

    @Override // org.threeten.bp.chrono.Chronology
    /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] */
    public HijrahDate c(TemporalAccessor temporalAccessor) {
        return temporalAccessor instanceof HijrahDate ? (HijrahDate) temporalAccessor : HijrahDate.r0(temporalAccessor.m(ChronoField.f146504z));
    }

    @Override // org.threeten.bp.chrono.Chronology
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public HijrahDate d(long j3) {
        return HijrahDate.p0(LocalDate.i0(j3));
    }

    @Override // org.threeten.bp.chrono.Chronology
    /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
    public HijrahEra h(int i3) {
        if (i3 == 0) {
            return HijrahEra.BEFORE_AH;
        }
        if (i3 == 1) {
            return HijrahEra.AH;
        }
        throw new DateTimeException("invalid Hijrah era");
    }

    public ValueRange w(ChronoField chronoField) {
        return chronoField.range();
    }
}
