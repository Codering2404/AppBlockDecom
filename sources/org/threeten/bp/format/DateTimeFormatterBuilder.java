package org.threeten.bp.format;

import com.facebook.AccessTokenManager;
import com.facebook.ads.AdError;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.AnalyticsEvents;
import com.google.android.gms.internal.measurement.a;
import com.revenuecat.purchases.common.Constants;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.TimeZone;
import java.util.TreeMap;
import org.threeten.bp.DateTimeException;
import org.threeten.bp.Instant;
import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalDateTime;
import org.threeten.bp.ZoneId;
import org.threeten.bp.ZoneOffset;
import org.threeten.bp.chrono.ChronoLocalDate;
import org.threeten.bp.chrono.Chronology;
import org.threeten.bp.format.SimpleDateTimeTextProvider;
import org.threeten.bp.jdk8.Jdk8Methods;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.IsoFields;
import org.threeten.bp.temporal.TemporalAccessor;
import org.threeten.bp.temporal.TemporalField;
import org.threeten.bp.temporal.TemporalQueries;
import org.threeten.bp.temporal.TemporalQuery;
import org.threeten.bp.temporal.ValueRange;
import org.threeten.bp.temporal.WeekFields;
import org.threeten.bp.zone.ZoneRulesProvider;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class DateTimeFormatterBuilder {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final TemporalQuery f146361h = new TemporalQuery<ZoneId>() { // from class: org.threeten.bp.format.DateTimeFormatterBuilder.1
        @Override // org.threeten.bp.temporal.TemporalQuery
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public ZoneId a(TemporalAccessor temporalAccessor) {
            ZoneId zoneId = (ZoneId) temporalAccessor.e(TemporalQueries.g());
            if (zoneId == null || (zoneId instanceof ZoneOffset)) {
                return null;
            }
            return zoneId;
        }
    };

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final Map f146362i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    static final Comparator f146363j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private DateTimeFormatterBuilder f146364a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final DateTimeFormatterBuilder f146365b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List f146366c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f146367d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f146368e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private char f146369f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f146370g;

    /* JADX INFO: renamed from: org.threeten.bp.format.DateTimeFormatterBuilder$4, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static /* synthetic */ class AnonymousClass4 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f146373a;

        static {
            int[] iArr = new int[SignStyle.values().length];
            f146373a = iArr;
            try {
                iArr[SignStyle.EXCEEDS_PAD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f146373a[SignStyle.ALWAYS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f146373a[SignStyle.NORMAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f146373a[SignStyle.NOT_NEGATIVE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class CharLiteralPrinterParser implements DateTimePrinterParser {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final char f146374a;

        CharLiteralPrinterParser(char c3) {
            this.f146374a = c3;
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public int a(DateTimeParseContext dateTimeParseContext, CharSequence charSequence, int i3) {
            if (i3 == charSequence.length()) {
                return ~i3;
            }
            return !dateTimeParseContext.c(this.f146374a, charSequence.charAt(i3)) ? ~i3 : i3 + 1;
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public boolean b(DateTimePrintContext dateTimePrintContext, StringBuilder sb) {
            sb.append(this.f146374a);
            return true;
        }

        public String toString() {
            if (this.f146374a == '\'') {
                return "''";
            }
            return "'" + this.f146374a + "'";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class ChronoPrinterParser implements DateTimePrinterParser {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final TextStyle f146375a;

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public int a(DateTimeParseContext dateTimeParseContext, CharSequence charSequence, int i3) {
            DateTimeParseContext dateTimeParseContext2;
            CharSequence charSequence2;
            int i4;
            if (i3 < 0 || i3 > charSequence.length()) {
                throw new IndexOutOfBoundsException();
            }
            Chronology chronology = null;
            int i5 = -1;
            for (Chronology chronology2 : Chronology.getAvailableChronologies()) {
                String id = chronology2.getId();
                int length = id.length();
                if (length > i5) {
                    dateTimeParseContext2 = dateTimeParseContext;
                    charSequence2 = charSequence;
                    i4 = i3;
                    if (dateTimeParseContext2.u(charSequence2, i4, id, 0, length)) {
                        chronology = chronology2;
                        i5 = length;
                    }
                } else {
                    dateTimeParseContext2 = dateTimeParseContext;
                    charSequence2 = charSequence;
                    i4 = i3;
                }
                dateTimeParseContext = dateTimeParseContext2;
                charSequence = charSequence2;
                i3 = i4;
            }
            DateTimeParseContext dateTimeParseContext3 = dateTimeParseContext;
            int i6 = i3;
            if (chronology == null) {
                return ~i6;
            }
            dateTimeParseContext3.p(chronology);
            return i6 + i5;
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public boolean b(DateTimePrintContext dateTimePrintContext, StringBuilder sb) {
            Chronology chronology = (Chronology) dateTimePrintContext.g(TemporalQueries.a());
            if (chronology == null) {
                return false;
            }
            if (this.f146375a == null) {
                sb.append(chronology.getId());
                return true;
            }
            try {
                sb.append(ResourceBundle.getBundle("org.threeten.bp.format.ChronologyText", dateTimePrintContext.c(), DateTimeFormatterBuilder.class.getClassLoader()).getString(chronology.getId()));
                return true;
            } catch (MissingResourceException unused) {
                sb.append(chronology.getId());
                return true;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class CompositePrinterParser implements DateTimePrinterParser {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final DateTimePrinterParser[] f146376a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f146377b;

        CompositePrinterParser(List list, boolean z2) {
            this((DateTimePrinterParser[]) list.toArray(new DateTimePrinterParser[list.size()]), z2);
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public int a(DateTimeParseContext dateTimeParseContext, CharSequence charSequence, int i3) {
            if (!this.f146377b) {
                for (DateTimePrinterParser dateTimePrinterParser : this.f146376a) {
                    i3 = dateTimePrinterParser.a(dateTimeParseContext, charSequence, i3);
                    if (i3 < 0) {
                        return i3;
                    }
                }
                return i3;
            }
            dateTimeParseContext.t();
            int iA = i3;
            for (DateTimePrinterParser dateTimePrinterParser2 : this.f146376a) {
                iA = dateTimePrinterParser2.a(dateTimeParseContext, charSequence, iA);
                if (iA < 0) {
                    dateTimeParseContext.g(false);
                    return i3;
                }
            }
            dateTimeParseContext.g(true);
            return iA;
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public boolean b(DateTimePrintContext dateTimePrintContext, StringBuilder sb) {
            int length = sb.length();
            if (this.f146377b) {
                dateTimePrintContext.h();
            }
            try {
                for (DateTimePrinterParser dateTimePrinterParser : this.f146376a) {
                    if (!dateTimePrinterParser.b(dateTimePrintContext, sb)) {
                        sb.setLength(length);
                        return true;
                    }
                }
                if (this.f146377b) {
                    dateTimePrintContext.b();
                }
                return true;
            } finally {
                if (this.f146377b) {
                    dateTimePrintContext.b();
                }
            }
        }

        public CompositePrinterParser c(boolean z2) {
            return z2 == this.f146377b ? this : new CompositePrinterParser(this.f146376a, z2);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            if (this.f146376a != null) {
                sb.append(this.f146377b ? "[" : "(");
                for (DateTimePrinterParser dateTimePrinterParser : this.f146376a) {
                    sb.append(dateTimePrinterParser);
                }
                sb.append(this.f146377b ? "]" : ")");
            }
            return sb.toString();
        }

        CompositePrinterParser(DateTimePrinterParser[] dateTimePrinterParserArr, boolean z2) {
            this.f146376a = dateTimePrinterParserArr;
            this.f146377b = z2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    interface DateTimePrinterParser {
        int a(DateTimeParseContext dateTimeParseContext, CharSequence charSequence, int i3);

        boolean b(DateTimePrintContext dateTimePrintContext, StringBuilder sb);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class DefaultingParser implements DateTimePrinterParser {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final TemporalField f146378a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f146379b;

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public int a(DateTimeParseContext dateTimeParseContext, CharSequence charSequence, int i3) {
            if (dateTimeParseContext.j(this.f146378a) != null) {
                return i3;
            }
            dateTimeParseContext.q(this.f146378a, this.f146379b, i3, i3);
            return i3;
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public boolean b(DateTimePrintContext dateTimePrintContext, StringBuilder sb) {
            return true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class FractionPrinterParser implements DateTimePrinterParser {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final TemporalField f146380a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f146381b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f146382c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final boolean f146383d;

        FractionPrinterParser(TemporalField temporalField, int i3, int i4, boolean z2) {
            Jdk8Methods.i(temporalField, "field");
            if (!temporalField.range().e()) {
                throw new IllegalArgumentException("Field must have a fixed set of values: " + temporalField);
            }
            if (i3 < 0 || i3 > 9) {
                throw new IllegalArgumentException("Minimum width must be from 0 to 9 inclusive but was " + i3);
            }
            if (i4 < 1 || i4 > 9) {
                throw new IllegalArgumentException("Maximum width must be from 1 to 9 inclusive but was " + i4);
            }
            if (i4 >= i3) {
                this.f146380a = temporalField;
                this.f146381b = i3;
                this.f146382c = i4;
                this.f146383d = z2;
                return;
            }
            throw new IllegalArgumentException("Maximum width must exceed or equal the minimum width but " + i4 + " < " + i3);
        }

        private long c(BigDecimal bigDecimal) {
            ValueRange valueRangeRange = this.f146380a.range();
            BigDecimal bigDecimalValueOf = BigDecimal.valueOf(valueRangeRange.d());
            return bigDecimal.multiply(BigDecimal.valueOf(valueRangeRange.c()).subtract(bigDecimalValueOf).add(BigDecimal.ONE)).setScale(0, RoundingMode.FLOOR).add(bigDecimalValueOf).longValueExact();
        }

        private BigDecimal d(long j3) {
            ValueRange valueRangeRange = this.f146380a.range();
            valueRangeRange.b(j3, this.f146380a);
            BigDecimal bigDecimalValueOf = BigDecimal.valueOf(valueRangeRange.d());
            BigDecimal bigDecimalDivide = BigDecimal.valueOf(j3).subtract(bigDecimalValueOf).divide(BigDecimal.valueOf(valueRangeRange.c()).subtract(bigDecimalValueOf).add(BigDecimal.ONE), 9, RoundingMode.FLOOR);
            BigDecimal bigDecimal = BigDecimal.ZERO;
            return bigDecimalDivide.compareTo(bigDecimal) == 0 ? bigDecimal : a.a(bigDecimalDivide);
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public int a(DateTimeParseContext dateTimeParseContext, CharSequence charSequence, int i3) {
            int i4 = 0;
            int i5 = dateTimeParseContext.m() ? this.f146381b : 0;
            int i6 = dateTimeParseContext.m() ? this.f146382c : 9;
            int length = charSequence.length();
            if (i3 != length) {
                if (this.f146383d) {
                    if (charSequence.charAt(i3) == dateTimeParseContext.k().c()) {
                        i3++;
                    } else if (i5 > 0) {
                        return ~i3;
                    }
                }
                int i7 = i3;
                int i8 = i5 + i7;
                if (i8 > length) {
                    return ~i7;
                }
                int iMin = Math.min(i6 + i7, length);
                int i9 = i7;
                while (true) {
                    if (i9 >= iMin) {
                        break;
                    }
                    int i10 = i9 + 1;
                    int iB = dateTimeParseContext.k().b(charSequence.charAt(i9));
                    if (iB >= 0) {
                        i4 = (i4 * 10) + iB;
                        i9 = i10;
                    } else if (i10 < i8) {
                        return ~i7;
                    }
                }
                return dateTimeParseContext.q(this.f146380a, c(new BigDecimal(i4).movePointLeft(i9 - i7)), i7, i9);
            }
            if (i5 > 0) {
                return ~i3;
            }
            return i3;
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public boolean b(DateTimePrintContext dateTimePrintContext, StringBuilder sb) {
            Long lF = dateTimePrintContext.f(this.f146380a);
            if (lF == null) {
                return false;
            }
            DecimalStyle decimalStyleD = dateTimePrintContext.d();
            BigDecimal bigDecimalD = d(lF.longValue());
            if (bigDecimalD.scale() != 0) {
                String strA = decimalStyleD.a(bigDecimalD.setScale(Math.min(Math.max(bigDecimalD.scale(), this.f146381b), this.f146382c), RoundingMode.FLOOR).toPlainString().substring(2));
                if (this.f146383d) {
                    sb.append(decimalStyleD.c());
                }
                sb.append(strA);
                return true;
            }
            if (this.f146381b <= 0) {
                return true;
            }
            if (this.f146383d) {
                sb.append(decimalStyleD.c());
            }
            for (int i3 = 0; i3 < this.f146381b; i3++) {
                sb.append(decimalStyleD.f());
            }
            return true;
        }

        public String toString() {
            return "Fraction(" + this.f146380a + "," + this.f146381b + "," + this.f146382c + (this.f146383d ? ",DecimalPoint" : "") + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class InstantPrinterParser implements DateTimePrinterParser {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f146384a;

        InstantPrinterParser(int i3) {
            this.f146384a = i3;
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public int a(DateTimeParseContext dateTimeParseContext, CharSequence charSequence, int i3) {
            int i4;
            int i5;
            DateTimeParseContext dateTimeParseContextE = dateTimeParseContext.e();
            int i6 = this.f146384a;
            int i7 = 0;
            int i8 = i6 < 0 ? 0 : i6;
            if (i6 < 0) {
                i6 = 9;
            }
            DateTimeFormatterBuilder dateTimeFormatterBuilderE = new DateTimeFormatterBuilder().a(DateTimeFormatter.f146335h).e('T');
            ChronoField chronoField = ChronoField.f146496r;
            DateTimeFormatterBuilder dateTimeFormatterBuilderE2 = dateTimeFormatterBuilderE.p(chronoField, 2).e(':');
            ChronoField chronoField2 = ChronoField.f146492n;
            DateTimeFormatterBuilder dateTimeFormatterBuilderE3 = dateTimeFormatterBuilderE2.p(chronoField2, 2).e(':');
            ChronoField chronoField3 = ChronoField.f146490l;
            DateTimeFormatterBuilder dateTimeFormatterBuilderP = dateTimeFormatterBuilderE3.p(chronoField3, 2);
            ChronoField chronoField4 = ChronoField.f146484f;
            int iA = dateTimeFormatterBuilderP.b(chronoField4, i8, i6, true).e('Z').E().r(false).a(dateTimeParseContextE, charSequence, i3);
            if (iA < 0) {
                return iA;
            }
            long jLongValue = dateTimeParseContextE.j(ChronoField.F).longValue();
            int iIntValue = dateTimeParseContextE.j(ChronoField.C).intValue();
            int iIntValue2 = dateTimeParseContextE.j(ChronoField.f146502x).intValue();
            int iIntValue3 = dateTimeParseContextE.j(chronoField).intValue();
            int iIntValue4 = dateTimeParseContextE.j(chronoField2).intValue();
            Long lJ = dateTimeParseContextE.j(chronoField3);
            Long lJ2 = dateTimeParseContextE.j(chronoField4);
            int iIntValue5 = lJ != null ? lJ.intValue() : 0;
            int iIntValue6 = lJ2 != null ? lJ2.intValue() : 0;
            int i9 = ((int) jLongValue) % ColorExtractionConstants.MAX_PIXEL_SAMPLES;
            if (iIntValue3 == 24 && iIntValue4 == 0 && iIntValue5 == 0 && iIntValue6 == 0) {
                i4 = 0;
                i5 = iIntValue5;
                i7 = 1;
            } else if (iIntValue3 == 23 && iIntValue4 == 59 && iIntValue5 == 60) {
                dateTimeParseContext.r();
                i5 = 59;
                i4 = iIntValue3;
            } else {
                i4 = iIntValue3;
                i5 = iIntValue5;
            }
            try {
                return dateTimeParseContext.q(chronoField4, iIntValue6, i3, dateTimeParseContext.q(ChronoField.H, Jdk8Methods.n(jLongValue / 10000, 315569520000L) + LocalDateTime.V(i9, iIntValue, iIntValue2, i4, iIntValue4, i5, 0).a0(i7).x(ZoneOffset.f146222i), i3, iA));
            } catch (RuntimeException unused) {
                return ~i3;
            }
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public boolean b(DateTimePrintContext dateTimePrintContext, StringBuilder sb) {
            Long lF = dateTimePrintContext.f(ChronoField.H);
            TemporalAccessor temporalAccessorE = dateTimePrintContext.e();
            ChronoField chronoField = ChronoField.f146484f;
            Long lValueOf = temporalAccessorE.g(chronoField) ? Long.valueOf(dateTimePrintContext.e().m(chronoField)) : 0L;
            int i3 = 0;
            if (lF == null) {
                return false;
            }
            long jLongValue = lF.longValue();
            int iF = chronoField.f(lValueOf.longValue());
            if (jLongValue >= -62167219200L) {
                long j3 = jLongValue - 253402300800L;
                long jE = Jdk8Methods.e(j3, 315569520000L) + 1;
                LocalDateTime localDateTimeX = LocalDateTime.X(Jdk8Methods.h(j3, 315569520000L) - 62167219200L, 0, ZoneOffset.f146222i);
                if (jE > 0) {
                    sb.append('+');
                    sb.append(jE);
                }
                sb.append(localDateTimeX);
                if (localDateTimeX.P() == 0) {
                    sb.append(":00");
                }
            } else {
                long j4 = jLongValue + 62167219200L;
                long j5 = j4 / 315569520000L;
                long j6 = j4 % 315569520000L;
                LocalDateTime localDateTimeX2 = LocalDateTime.X(j6 - 62167219200L, 0, ZoneOffset.f146222i);
                int length = sb.length();
                sb.append(localDateTimeX2);
                if (localDateTimeX2.P() == 0) {
                    sb.append(":00");
                }
                if (j5 < 0) {
                    if (localDateTimeX2.Q() == -10000) {
                        sb.replace(length, length + 2, Long.toString(j5 - 1));
                    } else if (j6 == 0) {
                        sb.insert(length, j5);
                    } else {
                        sb.insert(length + 1, Math.abs(j5));
                    }
                }
            }
            int i4 = this.f146384a;
            if (i4 == -2) {
                if (iF != 0) {
                    sb.append('.');
                    if (iF % 1000000 == 0) {
                        sb.append(Integer.toString((iF / 1000000) + 1000).substring(1));
                    } else if (iF % 1000 == 0) {
                        sb.append(Integer.toString((iF / 1000) + 1000000).substring(1));
                    } else {
                        sb.append(Integer.toString(iF + 1000000000).substring(1));
                    }
                }
            } else if (i4 > 0 || (i4 == -1 && iF > 0)) {
                sb.append('.');
                int i5 = 100000000;
                while (true) {
                    int i6 = this.f146384a;
                    if ((i6 != -1 || iF <= 0) && i3 >= i6) {
                        break;
                    }
                    int i7 = iF / i5;
                    sb.append((char) (i7 + 48));
                    iF -= i7 * i5;
                    i5 /= 10;
                    i3++;
                }
            }
            sb.append('Z');
            return true;
        }

        public String toString() {
            return "Instant()";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class LocalizedOffsetPrinterParser implements DateTimePrinterParser {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final TextStyle f146385a;

        public LocalizedOffsetPrinterParser(TextStyle textStyle) {
            this.f146385a = textStyle;
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public int a(DateTimeParseContext dateTimeParseContext, CharSequence charSequence, int i3) {
            char cCharAt;
            if (!dateTimeParseContext.u(charSequence, i3, "GMT", 0, 3)) {
                return ~i3;
            }
            int i4 = i3 + 3;
            if (this.f146385a == TextStyle.FULL) {
                return new OffsetIdPrinterParser("", "+HH:MM:ss").a(dateTimeParseContext, charSequence, i4);
            }
            int length = charSequence.length();
            if (i4 == length) {
                return dateTimeParseContext.q(ChronoField.I, 0L, i4, i4);
            }
            char cCharAt2 = charSequence.charAt(i4);
            if (cCharAt2 != '+' && cCharAt2 != '-') {
                return dateTimeParseContext.q(ChronoField.I, 0L, i4, i4);
            }
            int i5 = cCharAt2 == '-' ? -1 : 1;
            if (i4 == length) {
                return ~i4;
            }
            int i6 = i3 + 4;
            char cCharAt3 = charSequence.charAt(i6);
            if (cCharAt3 < '0' || cCharAt3 > '9') {
                return ~i6;
            }
            int i7 = i3 + 5;
            int i8 = cCharAt3 - '0';
            if (i7 != length && (cCharAt = charSequence.charAt(i7)) >= '0' && cCharAt <= '9') {
                i8 = (i8 * 10) + (cCharAt - '0');
                if (i8 > 23) {
                    return ~i7;
                }
                i7 = i3 + 6;
            }
            if (i7 == length || charSequence.charAt(i7) != ':') {
                return dateTimeParseContext.q(ChronoField.I, i5 * AccessTokenManager.TOKEN_EXTEND_RETRY_SECONDS * i8, i7, i7);
            }
            int i9 = i7 + 1;
            int i10 = length - 2;
            if (i9 > i10) {
                return ~i9;
            }
            char cCharAt4 = charSequence.charAt(i9);
            if (cCharAt4 < '0' || cCharAt4 > '9') {
                return ~i9;
            }
            int i11 = i7 + 2;
            int i12 = cCharAt4 - '0';
            char cCharAt5 = charSequence.charAt(i11);
            if (cCharAt5 < '0' || cCharAt5 > '9') {
                return ~i11;
            }
            int i13 = i7 + 3;
            if ((i12 * 10) + (cCharAt5 - '0') > 59) {
                return ~i13;
            }
            if (i13 == length || charSequence.charAt(i13) != ':') {
                return dateTimeParseContext.q(ChronoField.I, i5 * ((i8 * AccessTokenManager.TOKEN_EXTEND_RETRY_SECONDS) + (r8 * 60)), i13, i13);
            }
            int i14 = i7 + 4;
            if (i14 > i10) {
                return ~i14;
            }
            char cCharAt6 = charSequence.charAt(i14);
            if (cCharAt6 < '0' || cCharAt6 > '9') {
                return ~i14;
            }
            int i15 = i7 + 5;
            int i16 = cCharAt6 - '0';
            char cCharAt7 = charSequence.charAt(i15);
            if (cCharAt7 < '0' || cCharAt7 > '9') {
                return ~i15;
            }
            int i17 = i7 + 6;
            return (i16 * 10) + (cCharAt7 - '0') > 59 ? ~i17 : dateTimeParseContext.q(ChronoField.I, i5 * ((i8 * AccessTokenManager.TOKEN_EXTEND_RETRY_SECONDS) + (r8 * 60) + r4), i17, i17);
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public boolean b(DateTimePrintContext dateTimePrintContext, StringBuilder sb) {
            Long lF = dateTimePrintContext.f(ChronoField.I);
            if (lF == null) {
                return false;
            }
            sb.append("GMT");
            if (this.f146385a == TextStyle.FULL) {
                return new OffsetIdPrinterParser("", "+HH:MM:ss").b(dateTimePrintContext, sb);
            }
            int iQ = Jdk8Methods.q(lF.longValue());
            if (iQ == 0) {
                return true;
            }
            int iAbs = Math.abs((iQ / AccessTokenManager.TOKEN_EXTEND_RETRY_SECONDS) % 100);
            int iAbs2 = Math.abs((iQ / 60) % 60);
            int iAbs3 = Math.abs(iQ % 60);
            sb.append(iQ < 0 ? "-" : "+");
            sb.append(iAbs);
            if (iAbs2 <= 0 && iAbs3 <= 0) {
                return true;
            }
            sb.append(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR);
            sb.append((char) ((iAbs2 / 10) + 48));
            sb.append((char) ((iAbs2 % 10) + 48));
            if (iAbs3 <= 0) {
                return true;
            }
            sb.append(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR);
            sb.append((char) ((iAbs3 / 10) + 48));
            sb.append((char) ((iAbs3 % 10) + 48));
            return true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class LocalizedPrinterParser implements DateTimePrinterParser {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final FormatStyle f146386a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final FormatStyle f146387b;

        LocalizedPrinterParser(FormatStyle formatStyle, FormatStyle formatStyle2) {
            this.f146386a = formatStyle;
            this.f146387b = formatStyle2;
        }

        private DateTimeFormatter c(Locale locale, Chronology chronology) {
            return DateTimeFormatStyleProvider.b().a(this.f146386a, this.f146387b, chronology, locale);
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public int a(DateTimeParseContext dateTimeParseContext, CharSequence charSequence, int i3) {
            return c(dateTimeParseContext.i(), dateTimeParseContext.h()).r(false).a(dateTimeParseContext, charSequence, i3);
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public boolean b(DateTimePrintContext dateTimePrintContext, StringBuilder sb) {
            return c(dateTimePrintContext.c(), Chronology.i(dateTimePrintContext.e())).r(false).b(dateTimePrintContext, sb);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Localized(");
            Object obj = this.f146386a;
            if (obj == null) {
                obj = "";
            }
            sb.append(obj);
            sb.append(",");
            FormatStyle formatStyle = this.f146387b;
            sb.append(formatStyle != null ? formatStyle : "");
            sb.append(")");
            return sb.toString();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class NumberPrinterParser implements DateTimePrinterParser {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        static final int[] f146388g = {0, 10, 100, 1000, ColorExtractionConstants.MAX_PIXEL_SAMPLES, 100000, 1000000, 10000000, 100000000, 1000000000};

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final TemporalField f146389a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final int f146390b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final int f146391c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final SignStyle f146392d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final int f146393f;

        /* JADX WARN: Code restructure failed: missing block: B:101:0x014f, code lost:
        
            if (r1 > r22.f146390b) goto L86;
         */
        /* JADX WARN: Code restructure failed: missing block: B:103:0x0154, code lost:
        
            return ~(r4 - 1);
         */
        /* JADX WARN: Code restructure failed: missing block: B:105:0x0157, code lost:
        
            if (r1 <= r22.f146390b) goto L86;
         */
        /* JADX WARN: Code restructure failed: missing block: B:107:0x015a, code lost:
        
            return ~r4;
         */
        /* JADX WARN: Code restructure failed: missing block: B:108:0x015b, code lost:
        
            if (r13 == null) goto L114;
         */
        /* JADX WARN: Code restructure failed: missing block: B:110:0x0163, code lost:
        
            if (r13.bitLength() <= 63) goto L112;
         */
        /* JADX WARN: Code restructure failed: missing block: B:111:0x0165, code lost:
        
            r13 = r13.divide(java.math.BigInteger.TEN);
            r5 = r5 - 1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:113:0x0177, code lost:
        
            return e(r23, r13.longValue(), r4, r5);
         */
        /* JADX WARN: Code restructure failed: missing block: B:115:0x017e, code lost:
        
            return e(r23, r2, r4, r5);
         */
        /* JADX WARN: Code restructure failed: missing block: B:75:0x0108, code lost:
        
            r5 = r10;
         */
        /* JADX WARN: Code restructure failed: missing block: B:77:0x0111, code lost:
        
            if (r1 == false) goto L94;
         */
        /* JADX WARN: Code restructure failed: missing block: B:78:0x0113, code lost:
        
            if (r13 == null) goto L87;
         */
        /* JADX WARN: Code restructure failed: missing block: B:80:0x011b, code lost:
        
            if (r13.equals(java.math.BigInteger.ZERO) == false) goto L85;
         */
        /* JADX WARN: Code restructure failed: missing block: B:82:0x0121, code lost:
        
            if (r23.m() == false) goto L85;
         */
        /* JADX WARN: Code restructure failed: missing block: B:84:0x0126, code lost:
        
            return ~(r4 - 1);
         */
        /* JADX WARN: Code restructure failed: missing block: B:85:0x0127, code lost:
        
            r13 = r13.negate();
         */
        /* JADX WARN: Code restructure failed: missing block: B:86:0x012b, code lost:
        
            r2 = r14;
         */
        /* JADX WARN: Code restructure failed: missing block: B:88:0x012f, code lost:
        
            if (r14 != r18) goto L93;
         */
        /* JADX WARN: Code restructure failed: missing block: B:90:0x0135, code lost:
        
            if (r23.m() == false) goto L93;
         */
        /* JADX WARN: Code restructure failed: missing block: B:92:0x013a, code lost:
        
            return ~(r4 - 1);
         */
        /* JADX WARN: Code restructure failed: missing block: B:93:0x013b, code lost:
        
            r14 = -r14;
         */
        /* JADX WARN: Code restructure failed: missing block: B:95:0x0141, code lost:
        
            if (r22.f146392d != org.threeten.bp.format.SignStyle.EXCEEDS_PAD) goto L86;
         */
        /* JADX WARN: Code restructure failed: missing block: B:97:0x0147, code lost:
        
            if (r23.m() == false) goto L86;
         */
        /* JADX WARN: Code restructure failed: missing block: B:98:0x0149, code lost:
        
            r1 = r5 - r4;
         */
        /* JADX WARN: Code restructure failed: missing block: B:99:0x014b, code lost:
        
            if (r3 == false) goto L104;
         */
        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public int a(org.threeten.bp.format.DateTimeParseContext r23, java.lang.CharSequence r24, int r25) {
            /*
                Method dump skipped, instruction units count: 383
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: org.threeten.bp.format.DateTimeFormatterBuilder.NumberPrinterParser.a(org.threeten.bp.format.DateTimeParseContext, java.lang.CharSequence, int):int");
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public boolean b(DateTimePrintContext dateTimePrintContext, StringBuilder sb) {
            Long lF = dateTimePrintContext.f(this.f146389a);
            if (lF == null) {
                return false;
            }
            long jC = c(dateTimePrintContext, lF.longValue());
            DecimalStyle decimalStyleD = dateTimePrintContext.d();
            String string = jC == Long.MIN_VALUE ? "9223372036854775808" : Long.toString(Math.abs(jC));
            if (string.length() > this.f146391c) {
                throw new DateTimeException("Field " + this.f146389a + " cannot be printed as the value " + jC + " exceeds the maximum print width of " + this.f146391c);
            }
            String strA = decimalStyleD.a(string);
            if (jC >= 0) {
                int i3 = AnonymousClass4.f146373a[this.f146392d.ordinal()];
                if (i3 == 1) {
                    if (this.f146390b < 19 && jC >= f146388g[r4]) {
                        sb.append(decimalStyleD.e());
                    }
                } else if (i3 == 2) {
                    sb.append(decimalStyleD.e());
                }
            } else {
                int i4 = AnonymousClass4.f146373a[this.f146392d.ordinal()];
                if (i4 == 1 || i4 == 2 || i4 == 3) {
                    sb.append(decimalStyleD.d());
                } else if (i4 == 4) {
                    throw new DateTimeException("Field " + this.f146389a + " cannot be printed as the value " + jC + " cannot be negative according to the SignStyle");
                }
            }
            for (int i5 = 0; i5 < this.f146390b - strA.length(); i5++) {
                sb.append(decimalStyleD.f());
            }
            sb.append(strA);
            return true;
        }

        boolean d(DateTimeParseContext dateTimeParseContext) {
            int i3 = this.f146393f;
            if (i3 != -1) {
                return i3 > 0 && this.f146390b == this.f146391c && this.f146392d == SignStyle.NOT_NEGATIVE;
            }
            return true;
        }

        int e(DateTimeParseContext dateTimeParseContext, long j3, int i3, int i4) {
            return dateTimeParseContext.q(this.f146389a, j3, i3, i4);
        }

        NumberPrinterParser f() {
            return this.f146393f == -1 ? this : new NumberPrinterParser(this.f146389a, this.f146390b, this.f146391c, this.f146392d, -1);
        }

        NumberPrinterParser g(int i3) {
            return new NumberPrinterParser(this.f146389a, this.f146390b, this.f146391c, this.f146392d, this.f146393f + i3);
        }

        public String toString() {
            int i3 = this.f146390b;
            if (i3 == 1 && this.f146391c == 19 && this.f146392d == SignStyle.NORMAL) {
                return "Value(" + this.f146389a + ")";
            }
            if (i3 == this.f146391c && this.f146392d == SignStyle.NOT_NEGATIVE) {
                return "Value(" + this.f146389a + "," + this.f146390b + ")";
            }
            return "Value(" + this.f146389a + "," + this.f146390b + "," + this.f146391c + "," + this.f146392d + ")";
        }

        NumberPrinterParser(TemporalField temporalField, int i3, int i4, SignStyle signStyle) {
            this.f146389a = temporalField;
            this.f146390b = i3;
            this.f146391c = i4;
            this.f146392d = signStyle;
            this.f146393f = 0;
        }

        private NumberPrinterParser(TemporalField temporalField, int i3, int i4, SignStyle signStyle, int i5) {
            this.f146389a = temporalField;
            this.f146390b = i3;
            this.f146391c = i4;
            this.f146392d = signStyle;
            this.f146393f = i5;
        }

        long c(DateTimePrintContext dateTimePrintContext, long j3) {
            return j3;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class OffsetIdPrinterParser implements DateTimePrinterParser {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        static final String[] f146394c = {"+HH", "+HHmm", "+HH:mm", "+HHMM", "+HH:MM", "+HHMMss", "+HH:MM:ss", "+HHMMSS", "+HH:MM:SS"};

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        static final OffsetIdPrinterParser f146395d = new OffsetIdPrinterParser("Z", "+HH:MM:ss");

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        static final OffsetIdPrinterParser f146396f = new OffsetIdPrinterParser(AppEventsConstants.EVENT_PARAM_VALUE_NO, "+HH:MM:ss");

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f146397a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f146398b;

        OffsetIdPrinterParser(String str, String str2) {
            Jdk8Methods.i(str, "noOffsetText");
            Jdk8Methods.i(str2, "pattern");
            this.f146397a = str;
            this.f146398b = c(str2);
        }

        private int c(String str) {
            int i3 = 0;
            while (true) {
                String[] strArr = f146394c;
                if (i3 >= strArr.length) {
                    throw new IllegalArgumentException("Invalid zone offset pattern: " + str);
                }
                if (strArr[i3].equals(str)) {
                    return i3;
                }
                i3++;
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x002e  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private boolean d(int[] r6, int r7, java.lang.CharSequence r8, boolean r9) {
            /*
                r5 = this;
                int r0 = r5.f146398b
                int r1 = r0 + 3
                int r1 = r1 / 2
                r2 = 0
                if (r1 >= r7) goto La
                return r2
            La:
                r1 = r6[r2]
                int r0 = r0 % 2
                if (r0 != 0) goto L25
                r0 = 1
                if (r7 <= r0) goto L25
                int r0 = r1 + 1
                int r3 = r8.length()
                if (r0 > r3) goto L58
                char r1 = r8.charAt(r1)
                r3 = 58
                if (r1 == r3) goto L24
                goto L58
            L24:
                r1 = r0
            L25:
                int r0 = r1 + 2
                int r3 = r8.length()
                if (r0 <= r3) goto L2e
                goto L58
            L2e:
                int r0 = r1 + 1
                char r3 = r8.charAt(r1)
                int r1 = r1 + 2
                char r8 = r8.charAt(r0)
                r0 = 48
                if (r3 < r0) goto L58
                r4 = 57
                if (r3 > r4) goto L58
                if (r8 < r0) goto L58
                if (r8 <= r4) goto L47
                goto L58
            L47:
                int r3 = r3 - r0
                int r3 = r3 * 10
                int r8 = r8 - r0
                int r3 = r3 + r8
                if (r3 < 0) goto L58
                r8 = 59
                if (r3 <= r8) goto L53
                goto L58
            L53:
                r6[r7] = r3
                r6[r2] = r1
                return r2
            L58:
                return r9
            */
            throw new UnsupportedOperationException("Method not decompiled: org.threeten.bp.format.DateTimeFormatterBuilder.OffsetIdPrinterParser.d(int[], int, java.lang.CharSequence, boolean):boolean");
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public int a(DateTimeParseContext dateTimeParseContext, CharSequence charSequence, int i3) {
            CharSequence charSequence2;
            int length = charSequence.length();
            int length2 = this.f146397a.length();
            if (length2 == 0) {
                if (i3 == length) {
                    return dateTimeParseContext.q(ChronoField.I, 0L, i3, i3);
                }
                charSequence2 = charSequence;
            } else {
                if (i3 == length) {
                    return ~i3;
                }
                charSequence2 = charSequence;
                if (dateTimeParseContext.u(charSequence2, i3, this.f146397a, 0, length2)) {
                    return dateTimeParseContext.q(ChronoField.I, 0L, i3, i3 + length2);
                }
            }
            char cCharAt = charSequence.charAt(i3);
            if (cCharAt == '+' || cCharAt == '-') {
                int i4 = cCharAt == '-' ? -1 : 1;
                int[] iArr = new int[4];
                iArr[0] = i3 + 1;
                if (!d(iArr, 1, charSequence2, true)) {
                    if (!d(iArr, 2, charSequence2, this.f146398b >= 3) && !d(iArr, 3, charSequence2, false)) {
                        return dateTimeParseContext.q(ChronoField.I, ((long) i4) * ((((long) iArr[1]) * 3600) + (((long) iArr[2]) * 60) + ((long) iArr[3])), i3, iArr[0]);
                    }
                }
            }
            return length2 == 0 ? dateTimeParseContext.q(ChronoField.I, 0L, i3, i3 + length2) : ~i3;
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public boolean b(DateTimePrintContext dateTimePrintContext, StringBuilder sb) {
            Long lF = dateTimePrintContext.f(ChronoField.I);
            if (lF == null) {
                return false;
            }
            int iQ = Jdk8Methods.q(lF.longValue());
            if (iQ == 0) {
                sb.append(this.f146397a);
            } else {
                int iAbs = Math.abs((iQ / AccessTokenManager.TOKEN_EXTEND_RETRY_SECONDS) % 100);
                int iAbs2 = Math.abs((iQ / 60) % 60);
                int iAbs3 = Math.abs(iQ % 60);
                int length = sb.length();
                sb.append(iQ < 0 ? "-" : "+");
                sb.append((char) ((iAbs / 10) + 48));
                sb.append((char) ((iAbs % 10) + 48));
                int i3 = this.f146398b;
                if (i3 >= 3 || (i3 >= 1 && iAbs2 > 0)) {
                    sb.append(i3 % 2 == 0 ? Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR : "");
                    sb.append((char) ((iAbs2 / 10) + 48));
                    sb.append((char) ((iAbs2 % 10) + 48));
                    iAbs += iAbs2;
                    int i4 = this.f146398b;
                    if (i4 >= 7 || (i4 >= 5 && iAbs3 > 0)) {
                        sb.append(i4 % 2 == 0 ? Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR : "");
                        sb.append((char) ((iAbs3 / 10) + 48));
                        sb.append((char) ((iAbs3 % 10) + 48));
                        iAbs += iAbs3;
                    }
                }
                if (iAbs == 0) {
                    sb.setLength(length);
                    sb.append(this.f146397a);
                }
            }
            return true;
        }

        public String toString() {
            return "Offset(" + f146394c[this.f146398b] + ",'" + this.f146397a.replace("'", "''") + "')";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class PadPrinterParserDecorator implements DateTimePrinterParser {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final DateTimePrinterParser f146399a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f146400b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final char f146401c;

        PadPrinterParserDecorator(DateTimePrinterParser dateTimePrinterParser, int i3, char c3) {
            this.f146399a = dateTimePrinterParser;
            this.f146400b = i3;
            this.f146401c = c3;
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public int a(DateTimeParseContext dateTimeParseContext, CharSequence charSequence, int i3) {
            boolean zM = dateTimeParseContext.m();
            boolean zL = dateTimeParseContext.l();
            if (i3 > charSequence.length()) {
                throw new IndexOutOfBoundsException();
            }
            if (i3 == charSequence.length()) {
                return ~i3;
            }
            int length = this.f146400b + i3;
            if (length > charSequence.length()) {
                if (zM) {
                    return ~i3;
                }
                length = charSequence.length();
            }
            int i4 = i3;
            while (i4 < length) {
                if (!zL) {
                    if (!dateTimeParseContext.c(charSequence.charAt(i4), this.f146401c)) {
                        break;
                    }
                    i4++;
                } else {
                    if (charSequence.charAt(i4) != this.f146401c) {
                        break;
                    }
                    i4++;
                }
            }
            int iA = this.f146399a.a(dateTimeParseContext, charSequence.subSequence(0, length), i4);
            return (iA == length || !zM) ? iA : ~(i3 + i4);
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public boolean b(DateTimePrintContext dateTimePrintContext, StringBuilder sb) {
            int length = sb.length();
            if (!this.f146399a.b(dateTimePrintContext, sb)) {
                return false;
            }
            int length2 = sb.length() - length;
            if (length2 <= this.f146400b) {
                for (int i3 = 0; i3 < this.f146400b - length2; i3++) {
                    sb.insert(length, this.f146401c);
                }
                return true;
            }
            throw new DateTimeException("Cannot print as output of " + length2 + " characters exceeds pad width of " + this.f146400b);
        }

        public String toString() {
            String str;
            StringBuilder sb = new StringBuilder();
            sb.append("Pad(");
            sb.append(this.f146399a);
            sb.append(",");
            sb.append(this.f146400b);
            if (this.f146401c == ' ') {
                str = ")";
            } else {
                str = ",'" + this.f146401c + "')";
            }
            sb.append(str);
            return sb.toString();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    enum SettingsParser implements DateTimePrinterParser {
        SENSITIVE,
        INSENSITIVE,
        STRICT,
        LENIENT;

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public int a(DateTimeParseContext dateTimeParseContext, CharSequence charSequence, int i3) {
            int iOrdinal = ordinal();
            if (iOrdinal == 0) {
                dateTimeParseContext.n(true);
                return i3;
            }
            if (iOrdinal == 1) {
                dateTimeParseContext.n(false);
                return i3;
            }
            if (iOrdinal == 2) {
                dateTimeParseContext.s(true);
                return i3;
            }
            if (iOrdinal != 3) {
                return i3;
            }
            dateTimeParseContext.s(false);
            return i3;
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public boolean b(DateTimePrintContext dateTimePrintContext, StringBuilder sb) {
            return true;
        }

        @Override // java.lang.Enum
        public String toString() {
            int iOrdinal = ordinal();
            if (iOrdinal == 0) {
                return "ParseCaseSensitive(true)";
            }
            if (iOrdinal == 1) {
                return "ParseCaseSensitive(false)";
            }
            if (iOrdinal == 2) {
                return "ParseStrict(true)";
            }
            if (iOrdinal == 3) {
                return "ParseStrict(false)";
            }
            throw new IllegalStateException("Unreachable");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class StringLiteralPrinterParser implements DateTimePrinterParser {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f146410a;

        StringLiteralPrinterParser(String str) {
            this.f146410a = str;
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public int a(DateTimeParseContext dateTimeParseContext, CharSequence charSequence, int i3) {
            if (i3 > charSequence.length() || i3 < 0) {
                throw new IndexOutOfBoundsException();
            }
            String str = this.f146410a;
            return !dateTimeParseContext.u(charSequence, i3, str, 0, str.length()) ? ~i3 : i3 + this.f146410a.length();
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public boolean b(DateTimePrintContext dateTimePrintContext, StringBuilder sb) {
            sb.append(this.f146410a);
            return true;
        }

        public String toString() {
            return "'" + this.f146410a.replace("'", "''") + "'";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class TextPrinterParser implements DateTimePrinterParser {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final TemporalField f146411a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final TextStyle f146412b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final DateTimeTextProvider f146413c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private volatile NumberPrinterParser f146414d;

        TextPrinterParser(TemporalField temporalField, TextStyle textStyle, DateTimeTextProvider dateTimeTextProvider) {
            this.f146411a = temporalField;
            this.f146412b = textStyle;
            this.f146413c = dateTimeTextProvider;
        }

        private NumberPrinterParser c() {
            if (this.f146414d == null) {
                this.f146414d = new NumberPrinterParser(this.f146411a, 1, 19, SignStyle.NORMAL);
            }
            return this.f146414d;
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public int a(DateTimeParseContext dateTimeParseContext, CharSequence charSequence, int i3) {
            DateTimeParseContext dateTimeParseContext2;
            CharSequence charSequence2;
            int i4;
            int length = charSequence.length();
            if (i3 < 0 || i3 > length) {
                throw new IndexOutOfBoundsException();
            }
            Iterator itD = this.f146413c.d(this.f146411a, dateTimeParseContext.m() ? this.f146412b : null, dateTimeParseContext.i());
            if (itD != null) {
                while (itD.hasNext()) {
                    Map.Entry entry = (Map.Entry) itD.next();
                    String str = (String) entry.getKey();
                    DateTimeParseContext dateTimeParseContext3 = dateTimeParseContext;
                    CharSequence charSequence3 = charSequence;
                    int i5 = i3;
                    if (dateTimeParseContext3.u(str, 0, charSequence3, i5, str.length())) {
                        return dateTimeParseContext3.q(this.f146411a, ((Long) entry.getValue()).longValue(), i5, i5 + str.length());
                    }
                    dateTimeParseContext = dateTimeParseContext3;
                    charSequence = charSequence3;
                    i3 = i5;
                }
                dateTimeParseContext2 = dateTimeParseContext;
                charSequence2 = charSequence;
                i4 = i3;
                if (dateTimeParseContext2.m()) {
                    return ~i4;
                }
            } else {
                dateTimeParseContext2 = dateTimeParseContext;
                charSequence2 = charSequence;
                i4 = i3;
            }
            return c().a(dateTimeParseContext2, charSequence2, i4);
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public boolean b(DateTimePrintContext dateTimePrintContext, StringBuilder sb) {
            Long lF = dateTimePrintContext.f(this.f146411a);
            if (lF == null) {
                return false;
            }
            String strC = this.f146413c.c(this.f146411a, lF.longValue(), this.f146412b, dateTimePrintContext.c());
            if (strC == null) {
                return c().b(dateTimePrintContext, sb);
            }
            sb.append(strC);
            return true;
        }

        public String toString() {
            if (this.f146412b == TextStyle.FULL) {
                return "Text(" + this.f146411a + ")";
            }
            return "Text(" + this.f146411a + "," + this.f146412b + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class WeekFieldsPrinterParser implements DateTimePrinterParser {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final char f146415a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f146416b;

        public WeekFieldsPrinterParser(char c3, int i3) {
            this.f146415a = c3;
            this.f146416b = i3;
        }

        private DateTimePrinterParser c(WeekFields weekFields) {
            char c3 = this.f146415a;
            if (c3 == 'W') {
                return new NumberPrinterParser(weekFields.h(), 1, 2, SignStyle.NOT_NEGATIVE);
            }
            if (c3 == 'Y') {
                if (this.f146416b == 2) {
                    return new ReducedPrinterParser(weekFields.g(), 2, 2, 0, ReducedPrinterParser.f146402j);
                }
                TemporalField temporalFieldG = weekFields.g();
                int i3 = this.f146416b;
                return new NumberPrinterParser(temporalFieldG, i3, 19, i3 < 4 ? SignStyle.NORMAL : SignStyle.EXCEEDS_PAD, -1);
            }
            if (c3 == 'c') {
                return new NumberPrinterParser(weekFields.b(), this.f146416b, 2, SignStyle.NOT_NEGATIVE);
            }
            if (c3 == 'e') {
                return new NumberPrinterParser(weekFields.b(), this.f146416b, 2, SignStyle.NOT_NEGATIVE);
            }
            if (c3 != 'w') {
                return null;
            }
            return new NumberPrinterParser(weekFields.i(), this.f146416b, 2, SignStyle.NOT_NEGATIVE);
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public int a(DateTimeParseContext dateTimeParseContext, CharSequence charSequence, int i3) {
            return c(WeekFields.e(dateTimeParseContext.i())).a(dateTimeParseContext, charSequence, i3);
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public boolean b(DateTimePrintContext dateTimePrintContext, StringBuilder sb) {
            return c(WeekFields.e(dateTimePrintContext.c())).b(dateTimePrintContext, sb);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(30);
            sb.append("Localized(");
            char c3 = this.f146415a;
            if (c3 == 'Y') {
                int i3 = this.f146416b;
                if (i3 == 1) {
                    sb.append("WeekBasedYear");
                } else if (i3 == 2) {
                    sb.append("ReducedValue(WeekBasedYear,2,2,2000-01-01)");
                } else {
                    sb.append("WeekBasedYear,");
                    sb.append(this.f146416b);
                    sb.append(",");
                    sb.append(19);
                    sb.append(",");
                    sb.append(this.f146416b < 4 ? SignStyle.NORMAL : SignStyle.EXCEEDS_PAD);
                }
            } else {
                if (c3 == 'c' || c3 == 'e') {
                    sb.append("DayOfWeek");
                } else if (c3 == 'w') {
                    sb.append("WeekOfWeekBasedYear");
                } else if (c3 == 'W') {
                    sb.append("WeekOfMonth");
                }
                sb.append(",");
                sb.append(this.f146416b);
            }
            sb.append(")");
            return sb.toString();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class ZoneIdPrinterParser implements DateTimePrinterParser {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static volatile Map.Entry f146417c;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final TemporalQuery f146418a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f146419b;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        private static final class SubstringTree {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final int f146420a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final Map f146421b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private final Map f146422c;

            /* JADX INFO: Access modifiers changed from: private */
            public void c(String str) {
                int length = str.length();
                int i3 = this.f146420a;
                if (length == i3) {
                    this.f146421b.put(str, null);
                    this.f146422c.put(str.toLowerCase(Locale.ENGLISH), null);
                } else if (length > i3) {
                    String strSubstring = str.substring(0, i3);
                    SubstringTree substringTree = (SubstringTree) this.f146421b.get(strSubstring);
                    if (substringTree == null) {
                        substringTree = new SubstringTree(length);
                        this.f146421b.put(strSubstring, substringTree);
                        this.f146422c.put(strSubstring.toLowerCase(Locale.ENGLISH), substringTree);
                    }
                    substringTree.c(str);
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public SubstringTree d(CharSequence charSequence, boolean z2) {
                return z2 ? (SubstringTree) this.f146421b.get(charSequence) : (SubstringTree) this.f146422c.get(charSequence.toString().toLowerCase(Locale.ENGLISH));
            }

            private SubstringTree(int i3) {
                this.f146421b = new HashMap();
                this.f146422c = new HashMap();
                this.f146420a = i3;
            }
        }

        ZoneIdPrinterParser(TemporalQuery temporalQuery, String str) {
            this.f146418a = temporalQuery;
            this.f146419b = str;
        }

        private ZoneId c(Set set, String str, boolean z2) {
            if (str == null) {
                return null;
            }
            if (z2) {
                if (set.contains(str)) {
                    return ZoneId.p(str);
                }
                return null;
            }
            Iterator it = set.iterator();
            while (it.hasNext()) {
                String str2 = (String) it.next();
                if (str2.equalsIgnoreCase(str)) {
                    return ZoneId.p(str2);
                }
            }
            return null;
        }

        private int d(DateTimeParseContext dateTimeParseContext, CharSequence charSequence, int i3, int i4) {
            String upperCase = charSequence.subSequence(i3, i4).toString().toUpperCase();
            DateTimeParseContext dateTimeParseContextE = dateTimeParseContext.e();
            if (i4 < charSequence.length() && dateTimeParseContext.c(charSequence.charAt(i4), 'Z')) {
                dateTimeParseContext.o(ZoneId.r(upperCase, ZoneOffset.f146222i));
                return i4;
            }
            int iA = OffsetIdPrinterParser.f146395d.a(dateTimeParseContextE, charSequence, i4);
            if (iA < 0) {
                dateTimeParseContext.o(ZoneId.r(upperCase, ZoneOffset.f146222i));
                return i4;
            }
            dateTimeParseContext.o(ZoneId.r(upperCase, ZoneOffset.A((int) dateTimeParseContextE.j(ChronoField.I).longValue())));
            return iA;
        }

        private static SubstringTree e(Set set) {
            ArrayList arrayList = new ArrayList(set);
            Collections.sort(arrayList, DateTimeFormatterBuilder.f146363j);
            int i3 = 0;
            SubstringTree substringTree = new SubstringTree(((String) arrayList.get(0)).length());
            int size = arrayList.size();
            while (i3 < size) {
                Object obj = arrayList.get(i3);
                i3++;
                substringTree.c((String) obj);
            }
            return substringTree;
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public int a(DateTimeParseContext dateTimeParseContext, CharSequence charSequence, int i3) {
            int i4;
            int length = charSequence.length();
            if (i3 > length) {
                throw new IndexOutOfBoundsException();
            }
            if (i3 == length) {
                return ~i3;
            }
            char cCharAt = charSequence.charAt(i3);
            if (cCharAt == '+' || cCharAt == '-') {
                DateTimeParseContext dateTimeParseContextE = dateTimeParseContext.e();
                int iA = OffsetIdPrinterParser.f146395d.a(dateTimeParseContextE, charSequence, i3);
                if (iA < 0) {
                    return iA;
                }
                dateTimeParseContext.o(ZoneOffset.A((int) dateTimeParseContextE.j(ChronoField.I).longValue()));
                return iA;
            }
            int i5 = i3 + 2;
            if (length >= i5) {
                char cCharAt2 = charSequence.charAt(i3 + 1);
                if (dateTimeParseContext.c(cCharAt, 'U') && dateTimeParseContext.c(cCharAt2, 'T')) {
                    int i6 = i3 + 3;
                    return (length < i6 || !dateTimeParseContext.c(charSequence.charAt(i5), 'C')) ? d(dateTimeParseContext, charSequence, i3, i5) : d(dateTimeParseContext, charSequence, i3, i6);
                }
                if (dateTimeParseContext.c(cCharAt, 'G') && length >= (i4 = i3 + 3) && dateTimeParseContext.c(cCharAt2, 'M') && dateTimeParseContext.c(charSequence.charAt(i5), 'T')) {
                    return d(dateTimeParseContext, charSequence, i3, i4);
                }
            }
            Set setA = ZoneRulesProvider.a();
            int size = setA.size();
            Map.Entry simpleImmutableEntry = f146417c;
            if (simpleImmutableEntry == null || ((Integer) simpleImmutableEntry.getKey()).intValue() != size) {
                synchronized (this) {
                    try {
                        simpleImmutableEntry = f146417c;
                        if (simpleImmutableEntry == null || ((Integer) simpleImmutableEntry.getKey()).intValue() != size) {
                            simpleImmutableEntry = new AbstractMap.SimpleImmutableEntry(Integer.valueOf(size), e(setA));
                            f146417c = simpleImmutableEntry;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            SubstringTree substringTreeD = (SubstringTree) simpleImmutableEntry.getValue();
            String str = null;
            String str2 = null;
            while (substringTreeD != null) {
                int i7 = substringTreeD.f146420a + i3;
                if (i7 > length) {
                    break;
                }
                String string = charSequence.subSequence(i3, i7).toString();
                substringTreeD = substringTreeD.d(string, dateTimeParseContext.l());
                str2 = str;
                str = string;
            }
            ZoneId zoneIdC = c(setA, str, dateTimeParseContext.l());
            if (zoneIdC == null) {
                zoneIdC = c(setA, str2, dateTimeParseContext.l());
                if (zoneIdC == null) {
                    if (!dateTimeParseContext.c(cCharAt, 'Z')) {
                        return ~i3;
                    }
                    dateTimeParseContext.o(ZoneOffset.f146222i);
                    return i3 + 1;
                }
                str = str2;
            }
            dateTimeParseContext.o(zoneIdC);
            return i3 + str.length();
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public boolean b(DateTimePrintContext dateTimePrintContext, StringBuilder sb) {
            ZoneId zoneId = (ZoneId) dateTimePrintContext.g(this.f146418a);
            if (zoneId == null) {
                return false;
            }
            sb.append(zoneId.getId());
            return true;
        }

        public String toString() {
            return this.f146419b;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class ZoneTextPrinterParser implements DateTimePrinterParser {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final Comparator f146423b = new Comparator<String>() { // from class: org.threeten.bp.format.DateTimeFormatterBuilder.ZoneTextPrinterParser.1
            @Override // java.util.Comparator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public int compare(String str, String str2) {
                int length = str2.length() - str.length();
                return length == 0 ? str.compareTo(str2) : length;
            }
        };

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final TextStyle f146424a;

        ZoneTextPrinterParser(TextStyle textStyle) {
            this.f146424a = (TextStyle) Jdk8Methods.i(textStyle, "textStyle");
        }

        private int c(DateTimeParseContext dateTimeParseContext, CharSequence charSequence, int i3, String str) {
            int length = str.length();
            int i4 = i3 + length;
            if (i4 >= charSequence.length()) {
                dateTimeParseContext.o(ZoneId.p(str));
                return i4;
            }
            char cCharAt = charSequence.charAt(i4);
            if (cCharAt != '+' && cCharAt != '-') {
                dateTimeParseContext.o(ZoneId.p(str));
                return i4;
            }
            DateTimeParseContext dateTimeParseContextE = dateTimeParseContext.e();
            try {
                int iA = OffsetIdPrinterParser.f146396f.a(dateTimeParseContextE, charSequence, i4);
                if (iA < 0) {
                    dateTimeParseContext.o(ZoneId.p(str));
                    return i4;
                }
                ZoneOffset zoneOffsetA = ZoneOffset.A((int) dateTimeParseContextE.j(ChronoField.I).longValue());
                dateTimeParseContext.o(length == 0 ? zoneOffsetA : ZoneId.r(str, zoneOffsetA));
                return iA;
            } catch (DateTimeException unused) {
                return ~i3;
            }
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public int a(DateTimeParseContext dateTimeParseContext, CharSequence charSequence, int i3) {
            int length = charSequence.length();
            if (i3 > length) {
                throw new IndexOutOfBoundsException();
            }
            if (i3 == length) {
                return ~i3;
            }
            char cCharAt = charSequence.charAt(i3);
            if (cCharAt == '+' || cCharAt == '-') {
                return i3 + 6 > length ? ~i3 : c(dateTimeParseContext, charSequence, i3, "");
            }
            if (dateTimeParseContext.u(charSequence, i3, "GMT", 0, 3)) {
                return c(dateTimeParseContext, charSequence, i3, "GMT");
            }
            if (dateTimeParseContext.u(charSequence, i3, "UTC", 0, 3)) {
                return c(dateTimeParseContext, charSequence, i3, "UTC");
            }
            if (dateTimeParseContext.u(charSequence, i3, "UT", 0, 2)) {
                return c(dateTimeParseContext, charSequence, i3, "UT");
            }
            TreeMap treeMap = new TreeMap(f146423b);
            for (String str : ZoneId.f()) {
                treeMap.put(str, str);
                TimeZone timeZone = TimeZone.getTimeZone(str);
                int i4 = this.f146424a.a() == TextStyle.FULL ? 1 : 0;
                String displayName = timeZone.getDisplayName(false, i4, dateTimeParseContext.i());
                if (str.startsWith("Etc/") || (!displayName.startsWith("GMT+") && !displayName.startsWith("GMT+"))) {
                    treeMap.put(displayName, str);
                }
                String displayName2 = timeZone.getDisplayName(true, i4, dateTimeParseContext.i());
                if (str.startsWith("Etc/") || (!displayName2.startsWith("GMT+") && !displayName2.startsWith("GMT+"))) {
                    treeMap.put(displayName2, str);
                }
            }
            for (Map.Entry entry : treeMap.entrySet()) {
                String str2 = (String) entry.getKey();
                if (dateTimeParseContext.u(charSequence, i3, str2, 0, str2.length())) {
                    dateTimeParseContext.o(ZoneId.p((String) entry.getValue()));
                    return i3 + str2.length();
                }
            }
            if (cCharAt != 'Z') {
                return ~i3;
            }
            dateTimeParseContext.o(ZoneOffset.f146222i);
            return i3 + 1;
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public boolean b(DateTimePrintContext dateTimePrintContext, StringBuilder sb) {
            ZoneId zoneId = (ZoneId) dateTimePrintContext.g(TemporalQueries.g());
            if (zoneId == null) {
                return false;
            }
            if (zoneId.n() instanceof ZoneOffset) {
                sb.append(zoneId.getId());
                return true;
            }
            TemporalAccessor temporalAccessorE = dateTimePrintContext.e();
            ChronoField chronoField = ChronoField.H;
            sb.append(TimeZone.getTimeZone(zoneId.getId()).getDisplayName(temporalAccessorE.g(chronoField) ? zoneId.l().d(Instant.B(temporalAccessorE.m(chronoField))) : false, this.f146424a.a() == TextStyle.FULL ? 1 : 0, dateTimePrintContext.c()));
            return true;
        }

        public String toString() {
            return "ZoneText(" + this.f146424a + ")";
        }
    }

    static {
        HashMap map = new HashMap();
        f146362i = map;
        map.put('G', ChronoField.G);
        map.put('y', ChronoField.E);
        map.put('u', ChronoField.F);
        TemporalField temporalField = IsoFields.f146529b;
        map.put('Q', temporalField);
        map.put('q', temporalField);
        ChronoField chronoField = ChronoField.C;
        map.put('M', chronoField);
        map.put('L', chronoField);
        map.put('D', ChronoField.f146503y);
        map.put('d', ChronoField.f146502x);
        map.put('F', ChronoField.f146500v);
        ChronoField chronoField2 = ChronoField.f146499u;
        map.put('E', chronoField2);
        map.put('c', chronoField2);
        map.put('e', chronoField2);
        map.put('a', ChronoField.f146498t);
        map.put('H', ChronoField.f146496r);
        map.put('k', ChronoField.f146497s);
        map.put('K', ChronoField.f146494p);
        map.put('h', ChronoField.f146495q);
        map.put('m', ChronoField.f146492n);
        map.put('s', ChronoField.f146490l);
        ChronoField chronoField3 = ChronoField.f146484f;
        map.put('S', chronoField3);
        map.put('A', ChronoField.f146489k);
        map.put('n', chronoField3);
        map.put('N', ChronoField.f146485g);
        f146363j = new Comparator<String>() { // from class: org.threeten.bp.format.DateTimeFormatterBuilder.3
            @Override // java.util.Comparator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public int compare(String str, String str2) {
                return str.length() == str2.length() ? str.compareTo(str2) : str.length() - str2.length();
            }
        };
    }

    public DateTimeFormatterBuilder() {
        this.f146364a = this;
        this.f146366c = new ArrayList();
        this.f146370g = -1;
        this.f146365b = null;
        this.f146367d = false;
    }

    /* JADX WARN: Removed duplicated region for block: B:115:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0195  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void B(char r8, int r9, org.threeten.bp.temporal.TemporalField r10) {
        /*
            Method dump skipped, instruction units count: 560
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.threeten.bp.format.DateTimeFormatterBuilder.B(char, int, org.threeten.bp.temporal.TemporalField):void");
    }

    private void D(String str) {
        int i3;
        int i4 = 0;
        while (i4 < str.length()) {
            char cCharAt = str.charAt(i4);
            if ((cCharAt >= 'A' && cCharAt <= 'Z') || (cCharAt >= 'a' && cCharAt <= 'z')) {
                int i5 = i4 + 1;
                while (i5 < str.length() && str.charAt(i5) == cCharAt) {
                    i5++;
                }
                int i6 = i5 - i4;
                if (cCharAt == 'p') {
                    if (i5 >= str.length() || (((cCharAt = str.charAt(i5)) < 'A' || cCharAt > 'Z') && (cCharAt < 'a' || cCharAt > 'z'))) {
                        i3 = i6;
                        i6 = 0;
                    } else {
                        int i7 = i5 + 1;
                        while (i7 < str.length() && str.charAt(i7) == cCharAt) {
                            i7++;
                        }
                        i3 = i7 - i5;
                        i5 = i7;
                    }
                    if (i6 == 0) {
                        throw new IllegalArgumentException("Pad letter 'p' must be followed by valid pad pattern: " + str);
                    }
                    x(i6);
                    i6 = i3;
                }
                TemporalField temporalField = (TemporalField) f146362i.get(Character.valueOf(cCharAt));
                if (temporalField != null) {
                    B(cCharAt, i6, temporalField);
                } else if (cCharAt == 'z') {
                    if (i6 > 4) {
                        throw new IllegalArgumentException("Too many pattern letters: " + cCharAt);
                    }
                    if (i6 == 4) {
                        u(TextStyle.FULL);
                    } else {
                        u(TextStyle.SHORT);
                    }
                } else if (cCharAt != 'V') {
                    String str2 = "+0000";
                    if (cCharAt == 'Z') {
                        if (i6 < 4) {
                            i("+HHMM", "+0000");
                        } else if (i6 == 4) {
                            h(TextStyle.FULL);
                        } else {
                            if (i6 != 5) {
                                throw new IllegalArgumentException("Too many pattern letters: " + cCharAt);
                            }
                            i("+HH:MM:ss", "Z");
                        }
                    } else if (cCharAt == 'O') {
                        if (i6 == 1) {
                            h(TextStyle.SHORT);
                        } else {
                            if (i6 != 4) {
                                throw new IllegalArgumentException("Pattern letter count must be 1 or 4: " + cCharAt);
                            }
                            h(TextStyle.FULL);
                        }
                    } else if (cCharAt == 'X') {
                        if (i6 > 5) {
                            throw new IllegalArgumentException("Too many pattern letters: " + cCharAt);
                        }
                        i(OffsetIdPrinterParser.f146394c[i6 + (i6 == 1 ? 0 : 1)], "Z");
                    } else if (cCharAt == 'x') {
                        if (i6 > 5) {
                            throw new IllegalArgumentException("Too many pattern letters: " + cCharAt);
                        }
                        if (i6 == 1) {
                            str2 = "+00";
                        } else if (i6 % 2 != 0) {
                            str2 = "+00:00";
                        }
                        i(OffsetIdPrinterParser.f146394c[i6 + (i6 == 1 ? 0 : 1)], str2);
                    } else if (cCharAt == 'W') {
                        if (i6 > 1) {
                            throw new IllegalArgumentException("Too many pattern letters: " + cCharAt);
                        }
                        d(new WeekFieldsPrinterParser('W', i6));
                    } else if (cCharAt == 'w') {
                        if (i6 > 2) {
                            throw new IllegalArgumentException("Too many pattern letters: " + cCharAt);
                        }
                        d(new WeekFieldsPrinterParser('w', i6));
                    } else {
                        if (cCharAt != 'Y') {
                            throw new IllegalArgumentException("Unknown pattern letter: " + cCharAt);
                        }
                        d(new WeekFieldsPrinterParser('Y', i6));
                    }
                } else {
                    if (i6 != 2) {
                        throw new IllegalArgumentException("Pattern letter count must be 2: " + cCharAt);
                    }
                    s();
                }
                i4 = i5 - 1;
            } else if (cCharAt == '\'') {
                int i8 = i4 + 1;
                int i9 = i8;
                while (i9 < str.length()) {
                    if (str.charAt(i9) == '\'') {
                        int i10 = i9 + 1;
                        if (i10 >= str.length() || str.charAt(i10) != '\'') {
                            break;
                        } else {
                            i9 = i10;
                        }
                    }
                    i9++;
                }
                if (i9 >= str.length()) {
                    throw new IllegalArgumentException("Pattern ends with an incomplete string literal: " + str);
                }
                String strSubstring = str.substring(i8, i9);
                if (strSubstring.length() == 0) {
                    e('\'');
                } else {
                    f(strSubstring.replace("''", "'"));
                }
                i4 = i9;
            } else if (cCharAt == '[') {
                w();
            } else if (cCharAt == ']') {
                if (this.f146364a.f146365b == null) {
                    throw new IllegalArgumentException("Pattern invalid as it contains ] without previous [");
                }
                v();
            } else {
                if (cCharAt == '{' || cCharAt == '}' || cCharAt == '#') {
                    throw new IllegalArgumentException("Pattern includes reserved character: '" + cCharAt + "'");
                }
                e(cCharAt);
            }
            i4++;
        }
    }

    private int d(DateTimePrinterParser dateTimePrinterParser) {
        Jdk8Methods.i(dateTimePrinterParser, "pp");
        DateTimeFormatterBuilder dateTimeFormatterBuilder = this.f146364a;
        int i3 = dateTimeFormatterBuilder.f146368e;
        if (i3 > 0) {
            if (dateTimePrinterParser != null) {
                dateTimePrinterParser = new PadPrinterParserDecorator(dateTimePrinterParser, i3, dateTimeFormatterBuilder.f146369f);
            }
            DateTimeFormatterBuilder dateTimeFormatterBuilder2 = this.f146364a;
            dateTimeFormatterBuilder2.f146368e = 0;
            dateTimeFormatterBuilder2.f146369f = (char) 0;
        }
        this.f146364a.f146366c.add(dateTimePrinterParser);
        this.f146364a.f146370g = -1;
        return r4.f146366c.size() - 1;
    }

    private DateTimeFormatterBuilder n(NumberPrinterParser numberPrinterParser) {
        NumberPrinterParser numberPrinterParserF;
        DateTimeFormatterBuilder dateTimeFormatterBuilder = this.f146364a;
        int i3 = dateTimeFormatterBuilder.f146370g;
        if (i3 < 0 || !(dateTimeFormatterBuilder.f146366c.get(i3) instanceof NumberPrinterParser)) {
            this.f146364a.f146370g = d(numberPrinterParser);
            return this;
        }
        DateTimeFormatterBuilder dateTimeFormatterBuilder2 = this.f146364a;
        int i4 = dateTimeFormatterBuilder2.f146370g;
        NumberPrinterParser numberPrinterParser2 = (NumberPrinterParser) dateTimeFormatterBuilder2.f146366c.get(i4);
        int i5 = numberPrinterParser.f146390b;
        int i6 = numberPrinterParser.f146391c;
        if (i5 == i6 && numberPrinterParser.f146392d == SignStyle.NOT_NEGATIVE) {
            numberPrinterParserF = numberPrinterParser2.g(i6);
            d(numberPrinterParser.f());
            this.f146364a.f146370g = i4;
        } else {
            numberPrinterParserF = numberPrinterParser2.f();
            this.f146364a.f146370g = d(numberPrinterParser);
        }
        this.f146364a.f146366c.set(i4, numberPrinterParserF);
        return this;
    }

    public DateTimeFormatterBuilder A() {
        d(SettingsParser.SENSITIVE);
        return this;
    }

    public DateTimeFormatterBuilder C() {
        d(SettingsParser.LENIENT);
        return this;
    }

    public DateTimeFormatter E() {
        return F(Locale.getDefault());
    }

    public DateTimeFormatter F(Locale locale) {
        Jdk8Methods.i(locale, "locale");
        while (this.f146364a.f146365b != null) {
            v();
        }
        return new DateTimeFormatter(new CompositePrinterParser(this.f146366c, false), locale, DecimalStyle.f146451e, ResolverStyle.SMART, null, null, null);
    }

    DateTimeFormatter G(ResolverStyle resolverStyle) {
        return E().t(resolverStyle);
    }

    public DateTimeFormatterBuilder a(DateTimeFormatter dateTimeFormatter) {
        Jdk8Methods.i(dateTimeFormatter, "formatter");
        d(dateTimeFormatter.r(false));
        return this;
    }

    public DateTimeFormatterBuilder b(TemporalField temporalField, int i3, int i4, boolean z2) {
        d(new FractionPrinterParser(temporalField, i3, i4, z2));
        return this;
    }

    public DateTimeFormatterBuilder c() {
        d(new InstantPrinterParser(-2));
        return this;
    }

    public DateTimeFormatterBuilder e(char c3) {
        d(new CharLiteralPrinterParser(c3));
        return this;
    }

    public DateTimeFormatterBuilder f(String str) {
        Jdk8Methods.i(str, "literal");
        if (str.length() > 0) {
            if (str.length() == 1) {
                d(new CharLiteralPrinterParser(str.charAt(0)));
                return this;
            }
            d(new StringLiteralPrinterParser(str));
        }
        return this;
    }

    public DateTimeFormatterBuilder g(FormatStyle formatStyle, FormatStyle formatStyle2) {
        if (formatStyle == null && formatStyle2 == null) {
            throw new IllegalArgumentException("Either the date or time style must be non-null");
        }
        d(new LocalizedPrinterParser(formatStyle, formatStyle2));
        return this;
    }

    public DateTimeFormatterBuilder h(TextStyle textStyle) {
        Jdk8Methods.i(textStyle, AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE);
        if (textStyle != TextStyle.FULL && textStyle != TextStyle.SHORT) {
            throw new IllegalArgumentException("Style must be either full or short");
        }
        d(new LocalizedOffsetPrinterParser(textStyle));
        return this;
    }

    public DateTimeFormatterBuilder i(String str, String str2) {
        d(new OffsetIdPrinterParser(str2, str));
        return this;
    }

    public DateTimeFormatterBuilder j() {
        d(OffsetIdPrinterParser.f146395d);
        return this;
    }

    public DateTimeFormatterBuilder k(String str) {
        Jdk8Methods.i(str, "pattern");
        D(str);
        return this;
    }

    public DateTimeFormatterBuilder l(TemporalField temporalField, Map map) {
        Jdk8Methods.i(temporalField, "field");
        Jdk8Methods.i(map, "textLookup");
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        TextStyle textStyle = TextStyle.FULL;
        final SimpleDateTimeTextProvider.LocaleStore localeStore = new SimpleDateTimeTextProvider.LocaleStore(Collections.singletonMap(textStyle, linkedHashMap));
        d(new TextPrinterParser(temporalField, textStyle, new DateTimeTextProvider() { // from class: org.threeten.bp.format.DateTimeFormatterBuilder.2
            @Override // org.threeten.bp.format.DateTimeTextProvider
            public String c(TemporalField temporalField2, long j3, TextStyle textStyle2, Locale locale) {
                return localeStore.a(j3, textStyle2);
            }

            @Override // org.threeten.bp.format.DateTimeTextProvider
            public Iterator d(TemporalField temporalField2, TextStyle textStyle2, Locale locale) {
                return localeStore.b(textStyle2);
            }
        }));
        return this;
    }

    public DateTimeFormatterBuilder m(TemporalField temporalField, TextStyle textStyle) {
        Jdk8Methods.i(temporalField, "field");
        Jdk8Methods.i(textStyle, "textStyle");
        d(new TextPrinterParser(temporalField, textStyle, DateTimeTextProvider.b()));
        return this;
    }

    public DateTimeFormatterBuilder o(TemporalField temporalField) {
        Jdk8Methods.i(temporalField, "field");
        n(new NumberPrinterParser(temporalField, 1, 19, SignStyle.NORMAL));
        return this;
    }

    public DateTimeFormatterBuilder p(TemporalField temporalField, int i3) {
        Jdk8Methods.i(temporalField, "field");
        if (i3 >= 1 && i3 <= 19) {
            n(new NumberPrinterParser(temporalField, i3, i3, SignStyle.NOT_NEGATIVE));
            return this;
        }
        throw new IllegalArgumentException("The width must be from 1 to 19 inclusive but was " + i3);
    }

    public DateTimeFormatterBuilder q(TemporalField temporalField, int i3, int i4, SignStyle signStyle) {
        if (i3 == i4 && signStyle == SignStyle.NOT_NEGATIVE) {
            return p(temporalField, i4);
        }
        Jdk8Methods.i(temporalField, "field");
        Jdk8Methods.i(signStyle, "signStyle");
        if (i3 < 1 || i3 > 19) {
            throw new IllegalArgumentException("The minimum width must be from 1 to 19 inclusive but was " + i3);
        }
        if (i4 < 1 || i4 > 19) {
            throw new IllegalArgumentException("The maximum width must be from 1 to 19 inclusive but was " + i4);
        }
        if (i4 >= i3) {
            n(new NumberPrinterParser(temporalField, i3, i4, signStyle));
            return this;
        }
        throw new IllegalArgumentException("The maximum width must exceed or equal the minimum width but " + i4 + " < " + i3);
    }

    public DateTimeFormatterBuilder r(TemporalField temporalField, int i3, int i4, ChronoLocalDate chronoLocalDate) {
        Jdk8Methods.i(temporalField, "field");
        Jdk8Methods.i(chronoLocalDate, "baseDate");
        n(new ReducedPrinterParser(temporalField, i3, i4, 0, chronoLocalDate));
        return this;
    }

    public DateTimeFormatterBuilder s() {
        d(new ZoneIdPrinterParser(TemporalQueries.g(), "ZoneId()"));
        return this;
    }

    public DateTimeFormatterBuilder t() {
        d(new ZoneIdPrinterParser(f146361h, "ZoneRegionId()"));
        return this;
    }

    public DateTimeFormatterBuilder u(TextStyle textStyle) {
        d(new ZoneTextPrinterParser(textStyle));
        return this;
    }

    public DateTimeFormatterBuilder v() {
        DateTimeFormatterBuilder dateTimeFormatterBuilder = this.f146364a;
        if (dateTimeFormatterBuilder.f146365b == null) {
            throw new IllegalStateException("Cannot call optionalEnd() as there was no previous call to optionalStart()");
        }
        if (dateTimeFormatterBuilder.f146366c.size() <= 0) {
            this.f146364a = this.f146364a.f146365b;
            return this;
        }
        DateTimeFormatterBuilder dateTimeFormatterBuilder2 = this.f146364a;
        CompositePrinterParser compositePrinterParser = new CompositePrinterParser(dateTimeFormatterBuilder2.f146366c, dateTimeFormatterBuilder2.f146367d);
        this.f146364a = this.f146364a.f146365b;
        d(compositePrinterParser);
        return this;
    }

    public DateTimeFormatterBuilder w() {
        DateTimeFormatterBuilder dateTimeFormatterBuilder = this.f146364a;
        dateTimeFormatterBuilder.f146370g = -1;
        this.f146364a = new DateTimeFormatterBuilder(dateTimeFormatterBuilder, true);
        return this;
    }

    public DateTimeFormatterBuilder x(int i3) {
        return y(i3, ' ');
    }

    public DateTimeFormatterBuilder y(int i3, char c3) {
        if (i3 < 1) {
            throw new IllegalArgumentException("The pad width must be at least one but was " + i3);
        }
        DateTimeFormatterBuilder dateTimeFormatterBuilder = this.f146364a;
        dateTimeFormatterBuilder.f146368e = i3;
        dateTimeFormatterBuilder.f146369f = c3;
        dateTimeFormatterBuilder.f146370g = -1;
        return this;
    }

    public DateTimeFormatterBuilder z() {
        d(SettingsParser.INSENSITIVE);
        return this;
    }

    private DateTimeFormatterBuilder(DateTimeFormatterBuilder dateTimeFormatterBuilder, boolean z2) {
        this.f146364a = this;
        this.f146366c = new ArrayList();
        this.f146370g = -1;
        this.f146365b = dateTimeFormatterBuilder;
        this.f146367d = z2;
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class ReducedPrinterParser extends NumberPrinterParser {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        static final LocalDate f146402j = LocalDate.f0(AdError.SERVER_ERROR_CODE, 1, 1);

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final int f146403h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private final ChronoLocalDate f146404i;

        ReducedPrinterParser(TemporalField temporalField, int i3, int i4, int i5, ChronoLocalDate chronoLocalDate) {
            super(temporalField, i3, i4, SignStyle.NOT_NEGATIVE);
            if (i3 < 1 || i3 > 10) {
                throw new IllegalArgumentException("The width must be from 1 to 10 inclusive but was " + i3);
            }
            if (i4 < 1 || i4 > 10) {
                throw new IllegalArgumentException("The maxWidth must be from 1 to 10 inclusive but was " + i4);
            }
            if (i4 < i3) {
                throw new IllegalArgumentException("The maxWidth must be greater than the width");
            }
            if (chronoLocalDate == null) {
                long j3 = i5;
                if (!temporalField.range().h(j3)) {
                    throw new IllegalArgumentException("The base value must be within the range of the field");
                }
                if (j3 + ((long) NumberPrinterParser.f146388g[i3]) > 2147483647L) {
                    throw new DateTimeException("Unable to add printer-parser as the range exceeds the capacity of an int");
                }
            }
            this.f146403h = i5;
            this.f146404i = chronoLocalDate;
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.NumberPrinterParser
        long c(DateTimePrintContext dateTimePrintContext, long j3) {
            long jAbs = Math.abs(j3);
            int iJ = this.f146403h;
            if (this.f146404i != null) {
                iJ = Chronology.i(dateTimePrintContext.e()).c(this.f146404i).j(this.f146389a);
            }
            if (j3 >= iJ) {
                int i3 = NumberPrinterParser.f146388g[this.f146390b];
                if (j3 < iJ + i3) {
                    return jAbs % ((long) i3);
                }
            }
            return jAbs % ((long) NumberPrinterParser.f146388g[this.f146391c]);
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.NumberPrinterParser
        boolean d(DateTimeParseContext dateTimeParseContext) {
            if (dateTimeParseContext.m()) {
                return super.d(dateTimeParseContext);
            }
            return false;
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.NumberPrinterParser
        int e(DateTimeParseContext dateTimeParseContext, long j3, int i3, int i4) {
            ReducedPrinterParser reducedPrinterParser;
            DateTimeParseContext dateTimeParseContext2;
            long j4;
            int i5;
            int i6;
            long j5;
            int iJ = this.f146403h;
            if (this.f146404i != null) {
                iJ = dateTimeParseContext.h().c(this.f146404i).j(this.f146389a);
                reducedPrinterParser = this;
                dateTimeParseContext2 = dateTimeParseContext;
                j4 = j3;
                i5 = i3;
                i6 = i4;
                dateTimeParseContext2.b(reducedPrinterParser, j4, i5, i6);
            } else {
                reducedPrinterParser = this;
                dateTimeParseContext2 = dateTimeParseContext;
                j4 = j3;
                i5 = i3;
                i6 = i4;
            }
            int i7 = i6 - i5;
            int i8 = reducedPrinterParser.f146390b;
            if (i7 != i8 || j4 < 0) {
                j5 = j4;
            } else {
                long j6 = NumberPrinterParser.f146388g[i8];
                long j7 = iJ;
                long j8 = j7 - (j7 % j6);
                long j9 = iJ > 0 ? j8 + j4 : j8 - j4;
                j5 = j9 < j7 ? j9 + j6 : j9;
            }
            return dateTimeParseContext2.q(reducedPrinterParser.f146389a, j5, i5, i6);
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.NumberPrinterParser
        NumberPrinterParser f() {
            return this.f146393f == -1 ? this : new ReducedPrinterParser(this.f146389a, this.f146390b, this.f146391c, this.f146403h, this.f146404i, -1);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.NumberPrinterParser
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public ReducedPrinterParser g(int i3) {
            return new ReducedPrinterParser(this.f146389a, this.f146390b, this.f146391c, this.f146403h, this.f146404i, this.f146393f + i3);
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.NumberPrinterParser
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("ReducedValue(");
            sb.append(this.f146389a);
            sb.append(",");
            sb.append(this.f146390b);
            sb.append(",");
            sb.append(this.f146391c);
            sb.append(",");
            Object objValueOf = this.f146404i;
            if (objValueOf == null) {
                objValueOf = Integer.valueOf(this.f146403h);
            }
            sb.append(objValueOf);
            sb.append(")");
            return sb.toString();
        }

        private ReducedPrinterParser(TemporalField temporalField, int i3, int i4, int i5, ChronoLocalDate chronoLocalDate, int i6) {
            super(temporalField, i3, i4, SignStyle.NOT_NEGATIVE, i6);
            this.f146403h = i5;
            this.f146404i = chronoLocalDate;
        }
    }
}
