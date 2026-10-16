package org.threeten.bp.format;

import java.io.IOException;
import java.text.FieldPosition;
import java.text.Format;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.HashMap;
import java.util.Locale;
import java.util.Set;
import org.threeten.bp.DateTimeException;
import org.threeten.bp.Period;
import org.threeten.bp.ZoneId;
import org.threeten.bp.chrono.Chronology;
import org.threeten.bp.chrono.IsoChronology;
import org.threeten.bp.format.DateTimeFormatterBuilder;
import org.threeten.bp.format.DateTimeParseContext;
import org.threeten.bp.jdk8.Jdk8Methods;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.IsoFields;
import org.threeten.bp.temporal.TemporalAccessor;
import org.threeten.bp.temporal.TemporalQuery;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class DateTimeFormatter {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final DateTimeFormatter f146335h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final DateTimeFormatter f146336i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final DateTimeFormatter f146337j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final DateTimeFormatter f146338k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final DateTimeFormatter f146339l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final DateTimeFormatter f146340m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final DateTimeFormatter f146341n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final DateTimeFormatter f146342o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final DateTimeFormatter f146343p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final DateTimeFormatter f146344q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final DateTimeFormatter f146345r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final DateTimeFormatter f146346s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final DateTimeFormatter f146347t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final DateTimeFormatter f146348u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final DateTimeFormatter f146349v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private static final TemporalQuery f146350w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private static final TemporalQuery f146351x;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final DateTimeFormatterBuilder.CompositePrinterParser f146352a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Locale f146353b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final DecimalStyle f146354c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ResolverStyle f146355d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Set f146356e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Chronology f146357f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final ZoneId f146358g;

    static {
        DateTimeFormatterBuilder dateTimeFormatterBuilder = new DateTimeFormatterBuilder();
        ChronoField chronoField = ChronoField.F;
        SignStyle signStyle = SignStyle.EXCEEDS_PAD;
        DateTimeFormatterBuilder dateTimeFormatterBuilderE = dateTimeFormatterBuilder.q(chronoField, 4, 10, signStyle).e('-');
        ChronoField chronoField2 = ChronoField.C;
        DateTimeFormatterBuilder dateTimeFormatterBuilderE2 = dateTimeFormatterBuilderE.p(chronoField2, 2).e('-');
        ChronoField chronoField3 = ChronoField.f146502x;
        DateTimeFormatterBuilder dateTimeFormatterBuilderP = dateTimeFormatterBuilderE2.p(chronoField3, 2);
        ResolverStyle resolverStyle = ResolverStyle.STRICT;
        DateTimeFormatter dateTimeFormatterG = dateTimeFormatterBuilderP.G(resolverStyle);
        IsoChronology isoChronology = IsoChronology.f146288f;
        DateTimeFormatter dateTimeFormatterS = dateTimeFormatterG.s(isoChronology);
        f146335h = dateTimeFormatterS;
        f146336i = new DateTimeFormatterBuilder().z().a(dateTimeFormatterS).j().G(resolverStyle).s(isoChronology);
        f146337j = new DateTimeFormatterBuilder().z().a(dateTimeFormatterS).w().j().G(resolverStyle).s(isoChronology);
        DateTimeFormatterBuilder dateTimeFormatterBuilder2 = new DateTimeFormatterBuilder();
        ChronoField chronoField4 = ChronoField.f146496r;
        DateTimeFormatterBuilder dateTimeFormatterBuilderE3 = dateTimeFormatterBuilder2.p(chronoField4, 2).e(':');
        ChronoField chronoField5 = ChronoField.f146492n;
        DateTimeFormatterBuilder dateTimeFormatterBuilderE4 = dateTimeFormatterBuilderE3.p(chronoField5, 2).w().e(':');
        ChronoField chronoField6 = ChronoField.f146490l;
        DateTimeFormatter dateTimeFormatterG2 = dateTimeFormatterBuilderE4.p(chronoField6, 2).w().b(ChronoField.f146484f, 0, 9, true).G(resolverStyle);
        f146338k = dateTimeFormatterG2;
        f146339l = new DateTimeFormatterBuilder().z().a(dateTimeFormatterG2).j().G(resolverStyle);
        f146340m = new DateTimeFormatterBuilder().z().a(dateTimeFormatterG2).w().j().G(resolverStyle);
        DateTimeFormatter dateTimeFormatterS2 = new DateTimeFormatterBuilder().z().a(dateTimeFormatterS).e('T').a(dateTimeFormatterG2).G(resolverStyle).s(isoChronology);
        f146341n = dateTimeFormatterS2;
        DateTimeFormatter dateTimeFormatterS3 = new DateTimeFormatterBuilder().z().a(dateTimeFormatterS2).j().G(resolverStyle).s(isoChronology);
        f146342o = dateTimeFormatterS3;
        f146343p = new DateTimeFormatterBuilder().a(dateTimeFormatterS3).w().e('[').A().t().e(']').G(resolverStyle).s(isoChronology);
        f146344q = new DateTimeFormatterBuilder().a(dateTimeFormatterS2).w().j().w().e('[').A().t().e(']').G(resolverStyle).s(isoChronology);
        f146345r = new DateTimeFormatterBuilder().z().q(chronoField, 4, 10, signStyle).e('-').p(ChronoField.f146503y, 3).w().j().G(resolverStyle).s(isoChronology);
        DateTimeFormatterBuilder dateTimeFormatterBuilderE5 = new DateTimeFormatterBuilder().z().q(IsoFields.f146531d, 4, 10, signStyle).f("-W").p(IsoFields.f146530c, 2).e('-');
        ChronoField chronoField7 = ChronoField.f146499u;
        f146346s = dateTimeFormatterBuilderE5.p(chronoField7, 1).w().j().G(resolverStyle).s(isoChronology);
        f146347t = new DateTimeFormatterBuilder().z().c().G(resolverStyle);
        f146348u = new DateTimeFormatterBuilder().z().p(chronoField, 4).p(chronoField2, 2).p(chronoField3, 2).w().i("+HHMMss", "Z").G(resolverStyle).s(isoChronology);
        HashMap map = new HashMap();
        map.put(1L, "Mon");
        map.put(2L, "Tue");
        map.put(3L, "Wed");
        map.put(4L, "Thu");
        map.put(5L, "Fri");
        map.put(6L, "Sat");
        map.put(7L, "Sun");
        HashMap map2 = new HashMap();
        map2.put(1L, "Jan");
        map2.put(2L, "Feb");
        map2.put(3L, "Mar");
        map2.put(4L, "Apr");
        map2.put(5L, "May");
        map2.put(6L, "Jun");
        map2.put(7L, "Jul");
        map2.put(8L, "Aug");
        map2.put(9L, "Sep");
        map2.put(10L, "Oct");
        map2.put(11L, "Nov");
        map2.put(12L, "Dec");
        f146349v = new DateTimeFormatterBuilder().z().C().w().l(chronoField7, map).f(", ").v().q(chronoField3, 1, 2, SignStyle.NOT_NEGATIVE).e(' ').l(chronoField2, map2).e(' ').p(chronoField, 4).e(' ').p(chronoField4, 2).e(':').p(chronoField5, 2).w().e(':').p(chronoField6, 2).v().e(' ').i("+HHMM", "GMT").G(ResolverStyle.SMART).s(isoChronology);
        f146350w = new TemporalQuery<Period>() { // from class: org.threeten.bp.format.DateTimeFormatter.1
            @Override // org.threeten.bp.temporal.TemporalQuery
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public Period a(TemporalAccessor temporalAccessor) {
                return temporalAccessor instanceof DateTimeBuilder ? ((DateTimeBuilder) temporalAccessor).f146334h : Period.f146198d;
            }
        };
        f146351x = new TemporalQuery<Boolean>() { // from class: org.threeten.bp.format.DateTimeFormatter.2
            @Override // org.threeten.bp.temporal.TemporalQuery
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public Boolean a(TemporalAccessor temporalAccessor) {
                return temporalAccessor instanceof DateTimeBuilder ? Boolean.valueOf(((DateTimeBuilder) temporalAccessor).f146333g) : Boolean.FALSE;
            }
        };
    }

    DateTimeFormatter(DateTimeFormatterBuilder.CompositePrinterParser compositePrinterParser, Locale locale, DecimalStyle decimalStyle, ResolverStyle resolverStyle, Set set, Chronology chronology, ZoneId zoneId) {
        this.f146352a = (DateTimeFormatterBuilder.CompositePrinterParser) Jdk8Methods.i(compositePrinterParser, "printerParser");
        this.f146353b = (Locale) Jdk8Methods.i(locale, "locale");
        this.f146354c = (DecimalStyle) Jdk8Methods.i(decimalStyle, "decimalStyle");
        this.f146355d = (ResolverStyle) Jdk8Methods.i(resolverStyle, "resolverStyle");
        this.f146356e = set;
        this.f146357f = chronology;
        this.f146358g = zoneId;
    }

    private DateTimeParseException c(CharSequence charSequence, RuntimeException runtimeException) {
        String string;
        if (charSequence.length() > 64) {
            string = charSequence.subSequence(0, 64).toString() + "...";
        } else {
            string = charSequence.toString();
        }
        return new DateTimeParseException("Text '" + string + "' could not be parsed: " + runtimeException.getMessage(), charSequence, 0, runtimeException);
    }

    public static DateTimeFormatter l(FormatStyle formatStyle) {
        Jdk8Methods.i(formatStyle, "dateStyle");
        return new DateTimeFormatterBuilder().g(formatStyle, null).E().s(IsoChronology.f146288f);
    }

    public static DateTimeFormatter m(String str) {
        return new DateTimeFormatterBuilder().k(str).E();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DateTimeBuilder p(CharSequence charSequence, ParsePosition parsePosition) {
        String string;
        ParsePosition parsePosition2 = parsePosition != null ? parsePosition : new ParsePosition(0);
        DateTimeParseContext.Parsed parsedQ = q(charSequence, parsePosition2);
        if (parsedQ != null && parsePosition2.getErrorIndex() < 0 && (parsePosition != null || parsePosition2.getIndex() >= charSequence.length())) {
            return parsedQ.q();
        }
        if (charSequence.length() > 64) {
            string = charSequence.subSequence(0, 64).toString() + "...";
        } else {
            string = charSequence.toString();
        }
        if (parsePosition2.getErrorIndex() >= 0) {
            throw new DateTimeParseException("Text '" + string + "' could not be parsed at index " + parsePosition2.getErrorIndex(), charSequence, parsePosition2.getErrorIndex());
        }
        throw new DateTimeParseException("Text '" + string + "' could not be parsed, unparsed text found at index " + parsePosition2.getIndex(), charSequence, parsePosition2.getIndex());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DateTimeParseContext.Parsed q(CharSequence charSequence, ParsePosition parsePosition) {
        Jdk8Methods.i(charSequence, "text");
        Jdk8Methods.i(parsePosition, "position");
        DateTimeParseContext dateTimeParseContext = new DateTimeParseContext(this);
        int iA = this.f146352a.a(dateTimeParseContext, charSequence, parsePosition.getIndex());
        if (iA < 0) {
            parsePosition.setErrorIndex(~iA);
            return null;
        }
        parsePosition.setIndex(iA);
        return dateTimeParseContext.v();
    }

    public String d(TemporalAccessor temporalAccessor) {
        StringBuilder sb = new StringBuilder(32);
        e(temporalAccessor, sb);
        return sb.toString();
    }

    public void e(TemporalAccessor temporalAccessor, Appendable appendable) {
        Jdk8Methods.i(temporalAccessor, "temporal");
        Jdk8Methods.i(appendable, "appendable");
        try {
            DateTimePrintContext dateTimePrintContext = new DateTimePrintContext(temporalAccessor, this);
            if (appendable instanceof StringBuilder) {
                this.f146352a.b(dateTimePrintContext, (StringBuilder) appendable);
                return;
            }
            StringBuilder sb = new StringBuilder(32);
            this.f146352a.b(dateTimePrintContext, sb);
            appendable.append(sb);
        } catch (IOException e3) {
            throw new DateTimeException(e3.getMessage(), e3);
        }
    }

    public Chronology f() {
        return this.f146357f;
    }

    public DecimalStyle g() {
        return this.f146354c;
    }

    public Locale h() {
        return this.f146353b;
    }

    public Set i() {
        return this.f146356e;
    }

    public ResolverStyle j() {
        return this.f146355d;
    }

    public ZoneId k() {
        return this.f146358g;
    }

    public Object n(CharSequence charSequence, TemporalQuery temporalQuery) {
        Jdk8Methods.i(charSequence, "text");
        Jdk8Methods.i(temporalQuery, "type");
        try {
            return p(charSequence, null).D(this.f146355d, this.f146356e).s(temporalQuery);
        } catch (DateTimeParseException e3) {
            throw e3;
        } catch (RuntimeException e4) {
            throw c(charSequence, e4);
        }
    }

    public TemporalAccessor o(CharSequence charSequence) {
        Jdk8Methods.i(charSequence, "text");
        try {
            return p(charSequence, null).D(this.f146355d, this.f146356e);
        } catch (DateTimeParseException e3) {
            throw e3;
        } catch (RuntimeException e4) {
            throw c(charSequence, e4);
        }
    }

    DateTimeFormatterBuilder.CompositePrinterParser r(boolean z2) {
        return this.f146352a.c(z2);
    }

    public DateTimeFormatter s(Chronology chronology) {
        return Jdk8Methods.c(this.f146357f, chronology) ? this : new DateTimeFormatter(this.f146352a, this.f146353b, this.f146354c, this.f146355d, this.f146356e, chronology, this.f146358g);
    }

    public DateTimeFormatter t(ResolverStyle resolverStyle) {
        Jdk8Methods.i(resolverStyle, "resolverStyle");
        return Jdk8Methods.c(this.f146355d, resolverStyle) ? this : new DateTimeFormatter(this.f146352a, this.f146353b, this.f146354c, resolverStyle, this.f146356e, this.f146357f, this.f146358g);
    }

    public String toString() {
        String string = this.f146352a.toString();
        return string.startsWith("[") ? string : string.substring(1, string.length() - 1);
    }

    public DateTimeFormatter u(ZoneId zoneId) {
        return Jdk8Methods.c(this.f146358g, zoneId) ? this : new DateTimeFormatter(this.f146352a, this.f146353b, this.f146354c, this.f146355d, this.f146356e, this.f146357f, zoneId);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class ClassicFormat extends Format {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final DateTimeFormatter f146359a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final TemporalQuery f146360b;

        @Override // java.text.Format
        public StringBuffer format(Object obj, StringBuffer stringBuffer, FieldPosition fieldPosition) {
            Jdk8Methods.i(obj, "obj");
            Jdk8Methods.i(stringBuffer, "toAppendTo");
            Jdk8Methods.i(fieldPosition, "pos");
            if (!(obj instanceof TemporalAccessor)) {
                throw new IllegalArgumentException("Format target must implement TemporalAccessor");
            }
            fieldPosition.setBeginIndex(0);
            fieldPosition.setEndIndex(0);
            try {
                this.f146359a.e((TemporalAccessor) obj, stringBuffer);
                return stringBuffer;
            } catch (RuntimeException e3) {
                throw new IllegalArgumentException(e3.getMessage(), e3);
            }
        }

        @Override // java.text.Format
        public Object parseObject(String str) throws ParseException {
            Jdk8Methods.i(str, "text");
            try {
                TemporalQuery temporalQuery = this.f146360b;
                return temporalQuery == null ? this.f146359a.p(str, null).D(this.f146359a.j(), this.f146359a.i()) : this.f146359a.n(str, temporalQuery);
            } catch (DateTimeParseException e3) {
                throw new ParseException(e3.getMessage(), e3.a());
            } catch (RuntimeException e4) {
                throw ((ParseException) new ParseException(e4.getMessage(), 0).initCause(e4));
            }
        }

        @Override // java.text.Format
        public Object parseObject(String str, ParsePosition parsePosition) {
            Jdk8Methods.i(str, "text");
            try {
                DateTimeParseContext.Parsed parsedQ = this.f146359a.q(str, parsePosition);
                if (parsedQ == null) {
                    if (parsePosition.getErrorIndex() < 0) {
                        parsePosition.setErrorIndex(0);
                    }
                    return null;
                }
                try {
                    DateTimeBuilder dateTimeBuilderD = parsedQ.q().D(this.f146359a.j(), this.f146359a.i());
                    TemporalQuery temporalQuery = this.f146360b;
                    return temporalQuery == null ? dateTimeBuilderD : dateTimeBuilderD.s(temporalQuery);
                } catch (RuntimeException unused) {
                    parsePosition.setErrorIndex(0);
                    return null;
                }
            } catch (IndexOutOfBoundsException unused2) {
                if (parsePosition.getErrorIndex() < 0) {
                    parsePosition.setErrorIndex(0);
                }
                return null;
            }
        }
    }
}
