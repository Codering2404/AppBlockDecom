package org.threeten.bp.format;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.threeten.bp.Period;
import org.threeten.bp.ZoneId;
import org.threeten.bp.chrono.Chronology;
import org.threeten.bp.chrono.IsoChronology;
import org.threeten.bp.format.DateTimeFormatterBuilder;
import org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor;
import org.threeten.bp.jdk8.Jdk8Methods;
import org.threeten.bp.temporal.TemporalField;
import org.threeten.bp.temporal.TemporalQueries;
import org.threeten.bp.temporal.TemporalQuery;
import org.threeten.bp.temporal.UnsupportedTemporalTypeException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
final class DateTimeParseContext {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Locale f146425a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private DecimalStyle f146426b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Chronology f146427c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ZoneId f146428d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f146429e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f146430f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final ArrayList f146431g;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    final class Parsed extends DefaultInterfaceTemporalAccessor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Chronology f146432a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        ZoneId f146433b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final Map f146434c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f146435d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        Period f146436f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        List f146437g;

        @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor, org.threeten.bp.temporal.TemporalAccessor
        public Object e(TemporalQuery temporalQuery) {
            return temporalQuery == TemporalQueries.a() ? this.f146432a : (temporalQuery == TemporalQueries.g() || temporalQuery == TemporalQueries.f()) ? this.f146433b : super.e(temporalQuery);
        }

        @Override // org.threeten.bp.temporal.TemporalAccessor
        public boolean g(TemporalField temporalField) {
            return this.f146434c.containsKey(temporalField);
        }

        @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor, org.threeten.bp.temporal.TemporalAccessor
        public int j(TemporalField temporalField) {
            if (this.f146434c.containsKey(temporalField)) {
                return Jdk8Methods.q(((Long) this.f146434c.get(temporalField)).longValue());
            }
            throw new UnsupportedTemporalTypeException("Unsupported field: " + temporalField);
        }

        @Override // org.threeten.bp.temporal.TemporalAccessor
        public long m(TemporalField temporalField) {
            if (this.f146434c.containsKey(temporalField)) {
                return ((Long) this.f146434c.get(temporalField)).longValue();
            }
            throw new UnsupportedTemporalTypeException("Unsupported field: " + temporalField);
        }

        protected Parsed p() {
            Parsed parsed = DateTimeParseContext.this.new Parsed();
            parsed.f146432a = this.f146432a;
            parsed.f146433b = this.f146433b;
            parsed.f146434c.putAll(this.f146434c);
            parsed.f146435d = this.f146435d;
            return parsed;
        }

        DateTimeBuilder q() {
            DateTimeBuilder dateTimeBuilder = new DateTimeBuilder();
            dateTimeBuilder.f146328a.putAll(this.f146434c);
            dateTimeBuilder.f146329b = DateTimeParseContext.this.h();
            ZoneId zoneId = this.f146433b;
            if (zoneId != null) {
                dateTimeBuilder.f146330c = zoneId;
            } else {
                dateTimeBuilder.f146330c = DateTimeParseContext.this.f146428d;
            }
            dateTimeBuilder.f146333g = this.f146435d;
            dateTimeBuilder.f146334h = this.f146436f;
            return dateTimeBuilder;
        }

        public String toString() {
            return this.f146434c.toString() + "," + this.f146432a + "," + this.f146433b;
        }

        private Parsed() {
            this.f146432a = null;
            this.f146433b = null;
            this.f146434c = new HashMap();
            this.f146436f = Period.f146198d;
        }
    }

    DateTimeParseContext(DateTimeFormatter dateTimeFormatter) {
        this.f146429e = true;
        this.f146430f = true;
        ArrayList arrayList = new ArrayList();
        this.f146431g = arrayList;
        this.f146425a = dateTimeFormatter.h();
        this.f146426b = dateTimeFormatter.g();
        this.f146427c = dateTimeFormatter.f();
        this.f146428d = dateTimeFormatter.k();
        arrayList.add(new Parsed());
    }

    static boolean d(char c3, char c4) {
        return c3 == c4 || Character.toUpperCase(c3) == Character.toUpperCase(c4) || Character.toLowerCase(c3) == Character.toLowerCase(c4);
    }

    private Parsed f() {
        return (Parsed) this.f146431g.get(r0.size() - 1);
    }

    void b(DateTimeFormatterBuilder.ReducedPrinterParser reducedPrinterParser, long j3, int i3, int i4) {
        Parsed parsedF = f();
        if (parsedF.f146437g == null) {
            parsedF.f146437g = new ArrayList(2);
        }
        parsedF.f146437g.add(new Object[]{reducedPrinterParser, Long.valueOf(j3), Integer.valueOf(i3), Integer.valueOf(i4)});
    }

    boolean c(char c3, char c4) {
        return l() ? c3 == c4 : d(c3, c4);
    }

    DateTimeParseContext e() {
        return new DateTimeParseContext(this);
    }

    void g(boolean z2) {
        if (z2) {
            this.f146431g.remove(r2.size() - 2);
        } else {
            this.f146431g.remove(r2.size() - 1);
        }
    }

    Chronology h() {
        Chronology chronology = f().f146432a;
        if (chronology != null) {
            return chronology;
        }
        Chronology chronology2 = this.f146427c;
        return chronology2 == null ? IsoChronology.f146288f : chronology2;
    }

    Locale i() {
        return this.f146425a;
    }

    Long j(TemporalField temporalField) {
        return (Long) f().f146434c.get(temporalField);
    }

    DecimalStyle k() {
        return this.f146426b;
    }

    boolean l() {
        return this.f146429e;
    }

    boolean m() {
        return this.f146430f;
    }

    void n(boolean z2) {
        this.f146429e = z2;
    }

    void o(ZoneId zoneId) {
        Jdk8Methods.i(zoneId, "zone");
        f().f146433b = zoneId;
    }

    void p(Chronology chronology) {
        Jdk8Methods.i(chronology, "chrono");
        Parsed parsedF = f();
        parsedF.f146432a = chronology;
        if (parsedF.f146437g != null) {
            ArrayList arrayList = new ArrayList(parsedF.f146437g);
            parsedF.f146437g.clear();
            int size = arrayList.size();
            int i3 = 0;
            while (i3 < size) {
                Object obj = arrayList.get(i3);
                i3++;
                Object[] objArr = (Object[]) obj;
                ((DateTimeFormatterBuilder.ReducedPrinterParser) objArr[0]).e(this, ((Long) objArr[1]).longValue(), ((Integer) objArr[2]).intValue(), ((Integer) objArr[3]).intValue());
            }
        }
    }

    int q(TemporalField temporalField, long j3, int i3, int i4) {
        Jdk8Methods.i(temporalField, "field");
        Long l3 = (Long) f().f146434c.put(temporalField, Long.valueOf(j3));
        return (l3 == null || l3.longValue() == j3) ? i4 : ~i3;
    }

    void r() {
        f().f146435d = true;
    }

    void s(boolean z2) {
        this.f146430f = z2;
    }

    void t() {
        this.f146431g.add(f().p());
    }

    public String toString() {
        return f().toString();
    }

    boolean u(CharSequence charSequence, int i3, CharSequence charSequence2, int i4, int i5) {
        if (i3 + i5 > charSequence.length() || i4 + i5 > charSequence2.length()) {
            return false;
        }
        if (l()) {
            for (int i6 = 0; i6 < i5; i6++) {
                if (charSequence.charAt(i3 + i6) != charSequence2.charAt(i4 + i6)) {
                    return false;
                }
            }
            return true;
        }
        for (int i7 = 0; i7 < i5; i7++) {
            char cCharAt = charSequence.charAt(i3 + i7);
            char cCharAt2 = charSequence2.charAt(i4 + i7);
            if (cCharAt != cCharAt2 && Character.toUpperCase(cCharAt) != Character.toUpperCase(cCharAt2) && Character.toLowerCase(cCharAt) != Character.toLowerCase(cCharAt2)) {
                return false;
            }
        }
        return true;
    }

    Parsed v() {
        return f();
    }

    DateTimeParseContext(DateTimeParseContext dateTimeParseContext) {
        this.f146429e = true;
        this.f146430f = true;
        ArrayList arrayList = new ArrayList();
        this.f146431g = arrayList;
        this.f146425a = dateTimeParseContext.f146425a;
        this.f146426b = dateTimeParseContext.f146426b;
        this.f146427c = dateTimeParseContext.f146427c;
        this.f146428d = dateTimeParseContext.f146428d;
        this.f146429e = dateTimeParseContext.f146429e;
        this.f146430f = dateTimeParseContext.f146430f;
        arrayList.add(new Parsed());
    }
}
