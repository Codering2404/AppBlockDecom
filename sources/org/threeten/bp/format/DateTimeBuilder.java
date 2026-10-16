package org.threeten.bp.format;

import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.threeten.bp.DateTimeException;
import org.threeten.bp.Instant;
import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalTime;
import org.threeten.bp.Period;
import org.threeten.bp.ZoneId;
import org.threeten.bp.ZoneOffset;
import org.threeten.bp.chrono.ChronoLocalDate;
import org.threeten.bp.chrono.ChronoLocalDateTime;
import org.threeten.bp.chrono.ChronoZonedDateTime;
import org.threeten.bp.chrono.Chronology;
import org.threeten.bp.chrono.IsoChronology;
import org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor;
import org.threeten.bp.jdk8.Jdk8Methods;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.TemporalAccessor;
import org.threeten.bp.temporal.TemporalField;
import org.threeten.bp.temporal.TemporalQueries;
import org.threeten.bp.temporal.TemporalQuery;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
final class DateTimeBuilder extends DefaultInterfaceTemporalAccessor implements TemporalAccessor, Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Map f146328a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Chronology f146329b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    ZoneId f146330c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    ChronoLocalDate f146331d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    LocalTime f146332f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    boolean f146333g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    Period f146334h;

    private void A(ResolverStyle resolverStyle) {
        Map map = this.f146328a;
        ChronoField chronoField = ChronoField.f146497s;
        if (map.containsKey(chronoField)) {
            long jLongValue = ((Long) this.f146328a.remove(chronoField)).longValue();
            if (resolverStyle != ResolverStyle.LENIENT && (resolverStyle != ResolverStyle.SMART || jLongValue != 0)) {
                chronoField.g(jLongValue);
            }
            ChronoField chronoField2 = ChronoField.f146496r;
            if (jLongValue == 24) {
                jLongValue = 0;
            }
            p(chronoField2, jLongValue);
        }
        Map map2 = this.f146328a;
        ChronoField chronoField3 = ChronoField.f146495q;
        if (map2.containsKey(chronoField3)) {
            long jLongValue2 = ((Long) this.f146328a.remove(chronoField3)).longValue();
            if (resolverStyle != ResolverStyle.LENIENT && (resolverStyle != ResolverStyle.SMART || jLongValue2 != 0)) {
                chronoField3.g(jLongValue2);
            }
            p(ChronoField.f146494p, jLongValue2 != 12 ? jLongValue2 : 0L);
        }
        ResolverStyle resolverStyle2 = ResolverStyle.LENIENT;
        if (resolverStyle != resolverStyle2) {
            Map map3 = this.f146328a;
            ChronoField chronoField4 = ChronoField.f146498t;
            if (map3.containsKey(chronoField4)) {
                chronoField4.g(((Long) this.f146328a.get(chronoField4)).longValue());
            }
            Map map4 = this.f146328a;
            ChronoField chronoField5 = ChronoField.f146494p;
            if (map4.containsKey(chronoField5)) {
                chronoField5.g(((Long) this.f146328a.get(chronoField5)).longValue());
            }
        }
        Map map5 = this.f146328a;
        ChronoField chronoField6 = ChronoField.f146498t;
        if (map5.containsKey(chronoField6)) {
            Map map6 = this.f146328a;
            ChronoField chronoField7 = ChronoField.f146494p;
            if (map6.containsKey(chronoField7)) {
                p(ChronoField.f146496r, (((Long) this.f146328a.remove(chronoField6)).longValue() * 12) + ((Long) this.f146328a.remove(chronoField7)).longValue());
            }
        }
        Map map7 = this.f146328a;
        ChronoField chronoField8 = ChronoField.f146485g;
        if (map7.containsKey(chronoField8)) {
            long jLongValue3 = ((Long) this.f146328a.remove(chronoField8)).longValue();
            if (resolverStyle != resolverStyle2) {
                chronoField8.g(jLongValue3);
            }
            p(ChronoField.f146491m, jLongValue3 / 1000000000);
            p(ChronoField.f146484f, jLongValue3 % 1000000000);
        }
        Map map8 = this.f146328a;
        ChronoField chronoField9 = ChronoField.f146487i;
        if (map8.containsKey(chronoField9)) {
            long jLongValue4 = ((Long) this.f146328a.remove(chronoField9)).longValue();
            if (resolverStyle != resolverStyle2) {
                chronoField9.g(jLongValue4);
            }
            p(ChronoField.f146491m, jLongValue4 / 1000000);
            p(ChronoField.f146486h, jLongValue4 % 1000000);
        }
        Map map9 = this.f146328a;
        ChronoField chronoField10 = ChronoField.f146489k;
        if (map9.containsKey(chronoField10)) {
            long jLongValue5 = ((Long) this.f146328a.remove(chronoField10)).longValue();
            if (resolverStyle != resolverStyle2) {
                chronoField10.g(jLongValue5);
            }
            p(ChronoField.f146491m, jLongValue5 / 1000);
            p(ChronoField.f146488j, jLongValue5 % 1000);
        }
        Map map10 = this.f146328a;
        ChronoField chronoField11 = ChronoField.f146491m;
        if (map10.containsKey(chronoField11)) {
            long jLongValue6 = ((Long) this.f146328a.remove(chronoField11)).longValue();
            if (resolverStyle != resolverStyle2) {
                chronoField11.g(jLongValue6);
            }
            p(ChronoField.f146496r, jLongValue6 / 3600);
            p(ChronoField.f146492n, (jLongValue6 / 60) % 60);
            p(ChronoField.f146490l, jLongValue6 % 60);
        }
        Map map11 = this.f146328a;
        ChronoField chronoField12 = ChronoField.f146493o;
        if (map11.containsKey(chronoField12)) {
            long jLongValue7 = ((Long) this.f146328a.remove(chronoField12)).longValue();
            if (resolverStyle != resolverStyle2) {
                chronoField12.g(jLongValue7);
            }
            p(ChronoField.f146496r, jLongValue7 / 60);
            p(ChronoField.f146492n, jLongValue7 % 60);
        }
        if (resolverStyle != resolverStyle2) {
            Map map12 = this.f146328a;
            ChronoField chronoField13 = ChronoField.f146488j;
            if (map12.containsKey(chronoField13)) {
                chronoField13.g(((Long) this.f146328a.get(chronoField13)).longValue());
            }
            Map map13 = this.f146328a;
            ChronoField chronoField14 = ChronoField.f146486h;
            if (map13.containsKey(chronoField14)) {
                chronoField14.g(((Long) this.f146328a.get(chronoField14)).longValue());
            }
        }
        Map map14 = this.f146328a;
        ChronoField chronoField15 = ChronoField.f146488j;
        if (map14.containsKey(chronoField15)) {
            Map map15 = this.f146328a;
            ChronoField chronoField16 = ChronoField.f146486h;
            if (map15.containsKey(chronoField16)) {
                p(chronoField16, (((Long) this.f146328a.remove(chronoField15)).longValue() * 1000) + (((Long) this.f146328a.get(chronoField16)).longValue() % 1000));
            }
        }
        Map map16 = this.f146328a;
        ChronoField chronoField17 = ChronoField.f146486h;
        if (map16.containsKey(chronoField17)) {
            Map map17 = this.f146328a;
            ChronoField chronoField18 = ChronoField.f146484f;
            if (map17.containsKey(chronoField18)) {
                p(chronoField17, ((Long) this.f146328a.get(chronoField18)).longValue() / 1000);
                this.f146328a.remove(chronoField17);
            }
        }
        if (this.f146328a.containsKey(chronoField15)) {
            Map map18 = this.f146328a;
            ChronoField chronoField19 = ChronoField.f146484f;
            if (map18.containsKey(chronoField19)) {
                p(chronoField15, ((Long) this.f146328a.get(chronoField19)).longValue() / 1000000);
                this.f146328a.remove(chronoField15);
            }
        }
        if (this.f146328a.containsKey(chronoField17)) {
            p(ChronoField.f146484f, ((Long) this.f146328a.remove(chronoField17)).longValue() * 1000);
        } else if (this.f146328a.containsKey(chronoField15)) {
            p(ChronoField.f146484f, ((Long) this.f146328a.remove(chronoField15)).longValue() * 1000000);
        }
    }

    private DateTimeBuilder B(TemporalField temporalField, long j3) {
        this.f146328a.put(temporalField, Long.valueOf(j3));
        return this;
    }

    private boolean E(ResolverStyle resolverStyle) {
        int i3 = 0;
        loop0: while (i3 < 100) {
            Iterator it = this.f146328a.entrySet().iterator();
            while (it.hasNext()) {
                TemporalField temporalField = (TemporalField) ((Map.Entry) it.next()).getKey();
                TemporalAccessor temporalAccessorE = temporalField.e(this.f146328a, this, resolverStyle);
                if (temporalAccessorE != null) {
                    if (temporalAccessorE instanceof ChronoZonedDateTime) {
                        ChronoZonedDateTime chronoZonedDateTime = (ChronoZonedDateTime) temporalAccessorE;
                        ZoneId zoneId = this.f146330c;
                        if (zoneId == null) {
                            this.f146330c = chronoZonedDateTime.s();
                        } else if (!zoneId.equals(chronoZonedDateTime.s())) {
                            throw new DateTimeException("ChronoZonedDateTime must use the effective parsed zone: " + this.f146330c);
                        }
                        temporalAccessorE = chronoZonedDateTime.x();
                    }
                    if (temporalAccessorE instanceof ChronoLocalDate) {
                        I(temporalField, (ChronoLocalDate) temporalAccessorE);
                    } else if (temporalAccessorE instanceof LocalTime) {
                        H(temporalField, (LocalTime) temporalAccessorE);
                    } else {
                        if (!(temporalAccessorE instanceof ChronoLocalDateTime)) {
                            throw new DateTimeException("Unknown type: " + temporalAccessorE.getClass().getName());
                        }
                        ChronoLocalDateTime chronoLocalDateTime = (ChronoLocalDateTime) temporalAccessorE;
                        I(temporalField, chronoLocalDateTime.z());
                        H(temporalField, chronoLocalDateTime.A());
                    }
                } else if (!this.f146328a.containsKey(temporalField)) {
                    break;
                }
                i3++;
            }
        }
        if (i3 != 100) {
            return i3 > 0;
        }
        throw new DateTimeException("Badly written field");
    }

    private void F() {
        if (this.f146332f == null) {
            if (this.f146328a.containsKey(ChronoField.H) || this.f146328a.containsKey(ChronoField.f146491m) || this.f146328a.containsKey(ChronoField.f146490l)) {
                Map map = this.f146328a;
                ChronoField chronoField = ChronoField.f146484f;
                if (map.containsKey(chronoField)) {
                    long jLongValue = ((Long) this.f146328a.get(chronoField)).longValue();
                    this.f146328a.put(ChronoField.f146486h, Long.valueOf(jLongValue / 1000));
                    this.f146328a.put(ChronoField.f146488j, Long.valueOf(jLongValue / 1000000));
                } else {
                    this.f146328a.put(chronoField, 0L);
                    this.f146328a.put(ChronoField.f146486h, 0L);
                    this.f146328a.put(ChronoField.f146488j, 0L);
                }
            }
        }
    }

    private void G() {
        if (this.f146331d == null || this.f146332f == null) {
            return;
        }
        Long l3 = (Long) this.f146328a.get(ChronoField.I);
        if (l3 != null) {
            ChronoZonedDateTime chronoZonedDateTimeQ = this.f146331d.q(this.f146332f).q(ZoneOffset.A(l3.intValue()));
            ChronoField chronoField = ChronoField.H;
            this.f146328a.put(chronoField, Long.valueOf(chronoZonedDateTimeQ.m(chronoField)));
            return;
        }
        if (this.f146330c != null) {
            ChronoZonedDateTime chronoZonedDateTimeQ2 = this.f146331d.q(this.f146332f).q(this.f146330c);
            ChronoField chronoField2 = ChronoField.H;
            this.f146328a.put(chronoField2, Long.valueOf(chronoZonedDateTimeQ2.m(chronoField2)));
        }
    }

    private void H(TemporalField temporalField, LocalTime localTime) {
        long jU = localTime.U();
        Long l3 = (Long) this.f146328a.put(ChronoField.f146485g, Long.valueOf(jU));
        if (l3 == null || l3.longValue() == jU) {
            return;
        }
        throw new DateTimeException("Conflict found: " + LocalTime.E(l3.longValue()) + " differs from " + localTime + " while resolving  " + temporalField);
    }

    private void I(TemporalField temporalField, ChronoLocalDate chronoLocalDate) {
        if (!this.f146329b.equals(chronoLocalDate.s())) {
            throw new DateTimeException("ChronoLocalDate must use the effective parsed chronology: " + this.f146329b);
        }
        long epochDay = chronoLocalDate.toEpochDay();
        Long l3 = (Long) this.f146328a.put(ChronoField.f146504z, Long.valueOf(epochDay));
        if (l3 == null || l3.longValue() == epochDay) {
            return;
        }
        throw new DateTimeException("Conflict found: " + LocalDate.i0(l3.longValue()) + " differs from " + LocalDate.i0(epochDay) + " while resolving  " + temporalField);
    }

    private void P(ResolverStyle resolverStyle) {
        Map map = this.f146328a;
        ChronoField chronoField = ChronoField.f146496r;
        Long l3 = (Long) map.get(chronoField);
        Map map2 = this.f146328a;
        ChronoField chronoField2 = ChronoField.f146492n;
        Long l4 = (Long) map2.get(chronoField2);
        Map map3 = this.f146328a;
        ChronoField chronoField3 = ChronoField.f146490l;
        Long l5 = (Long) map3.get(chronoField3);
        Map map4 = this.f146328a;
        ChronoField chronoField4 = ChronoField.f146484f;
        Long l6 = (Long) map4.get(chronoField4);
        if (l3 == null) {
            return;
        }
        if (l4 != null || (l5 == null && l6 == null)) {
            if (l4 == null || l5 != null || l6 == null) {
                if (resolverStyle != ResolverStyle.LENIENT) {
                    if (resolverStyle == ResolverStyle.SMART && l3.longValue() == 24 && ((l4 == null || l4.longValue() == 0) && ((l5 == null || l5.longValue() == 0) && (l6 == null || l6.longValue() == 0)))) {
                        this.f146334h = Period.k(1);
                    } else {
                        l = l3;
                    }
                    int iF = chronoField.f(l.longValue());
                    if (l4 != null) {
                        int iF2 = chronoField2.f(l4.longValue());
                        if (l5 != null) {
                            int iF3 = chronoField3.f(l5.longValue());
                            if (l6 != null) {
                                q(LocalTime.D(iF, iF2, iF3, chronoField4.f(l6.longValue())));
                            } else {
                                q(LocalTime.B(iF, iF2, iF3));
                            }
                        } else if (l6 == null) {
                            q(LocalTime.A(iF, iF2));
                        }
                    } else if (l5 == null && l6 == null) {
                        q(LocalTime.A(iF, 0));
                    }
                } else {
                    long jLongValue = l3.longValue();
                    if (l4 == null) {
                        int iQ = Jdk8Methods.q(Jdk8Methods.e(jLongValue, 24L));
                        q(LocalTime.A(Jdk8Methods.g(jLongValue, 24), 0));
                        this.f146334h = Period.k(iQ);
                    } else if (l5 != null) {
                        long jK = Jdk8Methods.k(Jdk8Methods.k(Jdk8Methods.k(Jdk8Methods.n(jLongValue, 3600000000000L), Jdk8Methods.n(l4.longValue(), 60000000000L)), Jdk8Methods.n(l5.longValue(), 1000000000L)), (l6 != null ? l6 : 0L).longValue());
                        int iE = (int) Jdk8Methods.e(jK, 86400000000000L);
                        q(LocalTime.E(Jdk8Methods.h(jK, 86400000000000L)));
                        this.f146334h = Period.k(iE);
                    } else {
                        long jK2 = Jdk8Methods.k(Jdk8Methods.n(jLongValue, 3600L), Jdk8Methods.n(l4.longValue(), 60L));
                        int iE2 = (int) Jdk8Methods.e(jK2, 86400L);
                        q(LocalTime.F(Jdk8Methods.h(jK2, 86400L)));
                        this.f146334h = Period.k(iE2);
                    }
                }
                this.f146328a.remove(chronoField);
                this.f146328a.remove(chronoField2);
                this.f146328a.remove(chronoField3);
                this.f146328a.remove(chronoField4);
            }
        }
    }

    private void t(LocalDate localDate) {
        if (localDate != null) {
            r(localDate);
            for (TemporalField temporalField : this.f146328a.keySet()) {
                if ((temporalField instanceof ChronoField) && temporalField.isDateBased()) {
                    try {
                        long jM = localDate.m(temporalField);
                        Long l3 = (Long) this.f146328a.get(temporalField);
                        if (jM != l3.longValue()) {
                            throw new DateTimeException("Conflict found: Field " + temporalField + " " + jM + " differs from " + temporalField + " " + l3 + " derived from " + localDate);
                        }
                    } catch (DateTimeException unused) {
                        continue;
                    }
                }
            }
        }
    }

    private void u() {
        LocalTime localTime;
        if (this.f146328a.size() > 0) {
            ChronoLocalDate chronoLocalDate = this.f146331d;
            if (chronoLocalDate != null && (localTime = this.f146332f) != null) {
                v(chronoLocalDate.q(localTime));
                return;
            }
            if (chronoLocalDate != null) {
                v(chronoLocalDate);
                return;
            }
            TemporalAccessor temporalAccessor = this.f146332f;
            if (temporalAccessor != null) {
                v(temporalAccessor);
            }
        }
    }

    private void v(TemporalAccessor temporalAccessor) {
        Iterator it = this.f146328a.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            TemporalField temporalField = (TemporalField) entry.getKey();
            long jLongValue = ((Long) entry.getValue()).longValue();
            if (temporalAccessor.g(temporalField)) {
                try {
                    long jM = temporalAccessor.m(temporalField);
                    if (jM != jLongValue) {
                        throw new DateTimeException("Cross check failed: " + temporalField + " " + jM + " vs " + temporalField + " " + jLongValue);
                    }
                    it.remove();
                } catch (RuntimeException unused) {
                    continue;
                }
            }
        }
    }

    private Long w(TemporalField temporalField) {
        return (Long) this.f146328a.get(temporalField);
    }

    private void x(ResolverStyle resolverStyle) {
        if (this.f146329b instanceof IsoChronology) {
            t(IsoChronology.f146288f.x(this.f146328a, resolverStyle));
            return;
        }
        Map map = this.f146328a;
        ChronoField chronoField = ChronoField.f146504z;
        if (map.containsKey(chronoField)) {
            t(LocalDate.i0(((Long) this.f146328a.remove(chronoField)).longValue()));
        }
    }

    private void y() {
        if (this.f146328a.containsKey(ChronoField.H)) {
            ZoneId zoneId = this.f146330c;
            if (zoneId != null) {
                z(zoneId);
                return;
            }
            Long l3 = (Long) this.f146328a.get(ChronoField.I);
            if (l3 != null) {
                z(ZoneOffset.A(l3.intValue()));
            }
        }
    }

    private void z(ZoneId zoneId) {
        Map map = this.f146328a;
        ChronoField chronoField = ChronoField.H;
        ChronoZonedDateTime chronoZonedDateTimeQ = this.f146329b.q(Instant.B(((Long) map.remove(chronoField)).longValue()), zoneId);
        if (this.f146331d == null) {
            r(chronoZonedDateTimeQ.w());
        } else {
            I(chronoField, chronoZonedDateTimeQ.w());
        }
        p(ChronoField.f146491m, chronoZonedDateTimeQ.y().V());
    }

    public DateTimeBuilder D(ResolverStyle resolverStyle, Set set) {
        ChronoLocalDate chronoLocalDate;
        if (set != null) {
            this.f146328a.keySet().retainAll(set);
        }
        y();
        x(resolverStyle);
        A(resolverStyle);
        if (E(resolverStyle)) {
            y();
            x(resolverStyle);
            A(resolverStyle);
        }
        P(resolverStyle);
        u();
        Period period = this.f146334h;
        if (period != null && !period.e() && (chronoLocalDate = this.f146331d) != null && this.f146332f != null) {
            this.f146331d = chronoLocalDate.y(this.f146334h);
            this.f146334h = Period.f146198d;
        }
        F();
        G();
        return this;
    }

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor, org.threeten.bp.temporal.TemporalAccessor
    public Object e(TemporalQuery temporalQuery) {
        if (temporalQuery == TemporalQueries.g()) {
            return this.f146330c;
        }
        if (temporalQuery == TemporalQueries.a()) {
            return this.f146329b;
        }
        if (temporalQuery == TemporalQueries.b()) {
            ChronoLocalDate chronoLocalDate = this.f146331d;
            if (chronoLocalDate != null) {
                return LocalDate.I(chronoLocalDate);
            }
            return null;
        }
        if (temporalQuery == TemporalQueries.c()) {
            return this.f146332f;
        }
        if (temporalQuery == TemporalQueries.f() || temporalQuery == TemporalQueries.d()) {
            return temporalQuery.a(this);
        }
        if (temporalQuery == TemporalQueries.e()) {
            return null;
        }
        return temporalQuery.a(this);
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public boolean g(TemporalField temporalField) {
        if (temporalField == null) {
            return false;
        }
        if (this.f146328a.containsKey(temporalField)) {
            return true;
        }
        ChronoLocalDate chronoLocalDate = this.f146331d;
        if (chronoLocalDate != null && chronoLocalDate.g(temporalField)) {
            return true;
        }
        LocalTime localTime = this.f146332f;
        return localTime != null && localTime.g(temporalField);
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public long m(TemporalField temporalField) {
        Jdk8Methods.i(temporalField, "field");
        Long lW = w(temporalField);
        if (lW != null) {
            return lW.longValue();
        }
        ChronoLocalDate chronoLocalDate = this.f146331d;
        if (chronoLocalDate != null && chronoLocalDate.g(temporalField)) {
            return this.f146331d.m(temporalField);
        }
        LocalTime localTime = this.f146332f;
        if (localTime != null && localTime.g(temporalField)) {
            return this.f146332f.m(temporalField);
        }
        throw new DateTimeException("Field not found: " + temporalField);
    }

    DateTimeBuilder p(TemporalField temporalField, long j3) {
        Jdk8Methods.i(temporalField, "field");
        Long lW = w(temporalField);
        if (lW == null || lW.longValue() == j3) {
            return B(temporalField, j3);
        }
        throw new DateTimeException("Conflict found: " + temporalField + " " + lW + " differs from " + temporalField + " " + j3 + ": " + this);
    }

    void q(LocalTime localTime) {
        this.f146332f = localTime;
    }

    void r(ChronoLocalDate chronoLocalDate) {
        this.f146331d = chronoLocalDate;
    }

    public Object s(TemporalQuery temporalQuery) {
        return temporalQuery.a(this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD);
        sb.append("DateTimeBuilder[");
        if (this.f146328a.size() > 0) {
            sb.append("fields=");
            sb.append(this.f146328a);
        }
        sb.append(", ");
        sb.append(this.f146329b);
        sb.append(", ");
        sb.append(this.f146330c);
        sb.append(", ");
        sb.append(this.f146331d);
        sb.append(", ");
        sb.append(this.f146332f);
        sb.append(']');
        return sb.toString();
    }
}
