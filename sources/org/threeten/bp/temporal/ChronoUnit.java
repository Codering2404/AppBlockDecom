package org.threeten.bp.temporal;

import org.threeten.bp.Duration;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public enum ChronoUnit implements TemporalUnit {
    NANOS("Nanos", Duration.q(1)),
    MICROS("Micros", Duration.q(1000)),
    MILLIS("Millis", Duration.q(1000000)),
    SECONDS("Seconds", Duration.r(1)),
    MINUTES("Minutes", Duration.r(60)),
    HOURS("Hours", Duration.r(3600)),
    HALF_DAYS("HalfDays", Duration.r(43200)),
    DAYS("Days", Duration.r(86400)),
    WEEKS("Weeks", Duration.r(604800)),
    MONTHS("Months", Duration.r(2629746)),
    YEARS("Years", Duration.r(31556952)),
    DECADES("Decades", Duration.r(315569520)),
    CENTURIES("Centuries", Duration.r(3155695200L)),
    MILLENNIA("Millennia", Duration.r(31556952000L)),
    ERAS("Eras", Duration.r(31556952000000000L)),
    FOREVER("Forever", Duration.s(Long.MAX_VALUE, 999999999));


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f146526a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Duration f146527b;

    ChronoUnit(String str, Duration duration) {
        this.f146526a = str;
        this.f146527b = duration;
    }

    @Override // org.threeten.bp.temporal.TemporalUnit
    public long a(Temporal temporal, Temporal temporal2) {
        return temporal.i(temporal2, this);
    }

    @Override // org.threeten.bp.temporal.TemporalUnit
    public Temporal b(Temporal temporal, long j3) {
        return temporal.o(j3, this);
    }

    public boolean c() {
        return compareTo(DAYS) < 0;
    }

    @Override // org.threeten.bp.temporal.TemporalUnit
    public boolean isDateBased() {
        return compareTo(DAYS) >= 0 && this != FOREVER;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.f146526a;
    }
}
