package com.superwall.sdk.contrib.threeteen;

import androidx.compose.animation.core.Xrg.muQRKXGtpOhe;
import com.applovin.impl.mediation.nativeAds.xNe.qRMDmh;
import com.facebook.appevents.AppEventsConstants;
import com.superwall.sdk.contrib.threeteen.AmountFormats;
import com.superwall.sdk.logger.LogLevel;
import com.superwall.sdk.logger.LogScope;
import com.superwall.sdk.logger.Logger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.threeten.bp.Duration;
import org.threeten.bp.Period;
import org.threeten.bp.format.DateTimeParseException;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class AmountFormats {
    private static final String BUNDLE_NAME = "com.superwall.extra.wordbased";
    private static final int DAYS_PER_WEEK = 7;
    private static final List<DurationUnit> DURATION_UNITS;
    private static final FractionScalarPart EMPTY_FRACTION;
    private static final int HOURS_PER_DAY = 24;
    private static final int MINUTES_PER_HOUR = 60;
    private static final int NANOS_PER_MILLIS = 1000000;
    private static final int SECONDS_PER_MINUTE = 60;
    private static final String WORDBASED_COMMASPACE = "WordBased.commaspace";
    private static final String WORDBASED_DAY = "WordBased.day";
    private static final String WORDBASED_HOUR = "WordBased.hour";
    private static final String WORDBASED_MILLISECOND = "WordBased.millisecond";
    private static final String WORDBASED_MINUTE = "WordBased.minute";
    private static final String WORDBASED_MONTH = "WordBased.month";
    private static final String WORDBASED_SECOND = "WordBased.second";
    private static final String WORDBASED_SPACEANDSPACE = "WordBased.spaceandspace";
    private static final String WORDBASED_WEEK = "WordBased.week";
    private static final String WORDBASED_YEAR = "WordBased.year";
    public static final AmountFormats INSTANCE = new AmountFormats();
    private static final Pattern SPLITTER = Pattern.compile("[|][|][|]");
    private static final IntPredicate PREDICATE_1 = new IntPredicate() { // from class: com.superwall.sdk.contrib.threeteen.a
        @Override // com.superwall.sdk.contrib.threeteen.AmountFormats.IntPredicate
        public final boolean test(int i3) {
            return AmountFormats.PREDICATE_1$lambda$0(i3);
        }
    };
    private static final IntPredicate PREDICATE_END1_NOT11 = new IntPredicate() { // from class: com.superwall.sdk.contrib.threeteen.b
        @Override // com.superwall.sdk.contrib.threeteen.AmountFormats.IntPredicate
        public final boolean test(int i3) {
            return AmountFormats.PREDICATE_END1_NOT11$lambda$1(i3);
        }
    };
    private static final IntPredicate PREDICATE_END234_NOTTEENS = new IntPredicate() { // from class: com.superwall.sdk.contrib.threeteen.c
        @Override // com.superwall.sdk.contrib.threeteen.AmountFormats.IntPredicate
        public final boolean test(int i3) {
            return AmountFormats.PREDICATE_END234_NOTTEENS$lambda$2(i3);
        }
    };

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public interface DurationScalar {
        Duration applyTo(DurationUnit durationUnit);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class DurationUnit {
        private final String abbrev;
        private final Duration value;

        public DurationUnit(String abbrev, Duration value) {
            Intrinsics.checkNotNullParameter(abbrev, "abbrev");
            Intrinsics.checkNotNullParameter(value, "value");
            this.abbrev = abbrev;
            this.value = value;
        }

        public final CharSequence consumeDurationUnit(CharSequence text) {
            Intrinsics.checkNotNullParameter(text, "text");
            return text.subSequence(this.abbrev.length(), text.length());
        }

        public final boolean prefixMatchesUnit(CharSequence text) {
            Intrinsics.checkNotNullParameter(text, "text");
            if (text.length() >= this.abbrev.length()) {
                String str = this.abbrev;
                if (Intrinsics.areEqual(str, text.subSequence(0, str.length()))) {
                    return true;
                }
            }
            return false;
        }

        public final Duration scaleBy(Function1<? super Duration, Duration> scaleFunc) {
            Intrinsics.checkNotNullParameter(scaleFunc, "scaleFunc");
            return (Duration) scaleFunc.invoke(this.value);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class FractionScalarPart implements DurationScalar {
        private final long scale;
        private final long value;

        public FractionScalarPart(long j3, long j4) {
            this.value = j3;
            this.scale = j4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Duration applyTo$lambda$0(FractionScalarPart fractionScalarPart, Duration d3) {
            Intrinsics.checkNotNullParameter(d3, "d");
            Duration durationG = d3.k(fractionScalarPart.value).g(fractionScalarPart.scale);
            Intrinsics.checkNotNull(durationG, "null cannot be cast to non-null type org.threeten.bp.Duration");
            return durationG;
        }

        @Override // com.superwall.sdk.contrib.threeteen.AmountFormats.DurationScalar
        public Duration applyTo(DurationUnit unit) {
            Intrinsics.checkNotNullParameter(unit, "unit");
            if (this.value == 0) {
                Duration duration = Duration.f146124c;
                Intrinsics.checkNotNull(duration);
                return duration;
            }
            Duration durationScaleBy = unit.scaleBy(new Function1() { // from class: com.superwall.sdk.contrib.threeteen.d
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return AmountFormats.FractionScalarPart.applyTo$lambda$0(this.f93505a, (Duration) obj);
                }
            });
            Intrinsics.checkNotNull(durationScaleBy);
            return durationScaleBy;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public interface IntPredicate {
        boolean test(int i3);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class IntegerScalarPart implements DurationScalar {
        private final long value;

        public IntegerScalarPart(long j3) {
            this.value = j3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Duration applyTo$lambda$0(IntegerScalarPart integerScalarPart, Duration d3) {
            Intrinsics.checkNotNullParameter(d3, "d");
            return d3.k(integerScalarPart.value);
        }

        @Override // com.superwall.sdk.contrib.threeteen.AmountFormats.DurationScalar
        public Duration applyTo(DurationUnit unit) {
            Intrinsics.checkNotNullParameter(unit, "unit");
            Duration durationScaleBy = unit.scaleBy(new Function1() { // from class: com.superwall.sdk.contrib.threeteen.e
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return AmountFormats.IntegerScalarPart.applyTo$lambda$0(this.f93506a, (Duration) obj);
                }
            });
            Intrinsics.checkNotNull(durationScaleBy, "null cannot be cast to non-null type org.threeten.bp.Duration");
            return durationScaleBy;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ParsedUnitPart implements DurationScalar {
        private final CharSequence remainingText;
        private final DurationScalar scalar;

        public ParsedUnitPart(CharSequence remainingText, DurationScalar scalar) {
            Intrinsics.checkNotNullParameter(remainingText, "remainingText");
            Intrinsics.checkNotNullParameter(scalar, "scalar");
            this.remainingText = remainingText;
            this.scalar = scalar;
        }

        @Override // com.superwall.sdk.contrib.threeteen.AmountFormats.DurationScalar
        public Duration applyTo(DurationUnit unit) {
            Intrinsics.checkNotNullParameter(unit, "unit");
            return this.scalar.applyTo(unit);
        }

        public final CharSequence remainingText() {
            return this.remainingText;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class PredicateFormat implements UnitFormat {
        private final IntPredicate[] predicates;
        private final String[] text;

        public PredicateFormat(String[] predicateStrs, String[] text) {
            Intrinsics.checkNotNullParameter(predicateStrs, "predicateStrs");
            Intrinsics.checkNotNullParameter(text, "text");
            if (predicateStrs.length + 1 != text.length) {
                throw new IllegalStateException("Invalid word-based resource");
            }
            ArrayList arrayList = new ArrayList(predicateStrs.length);
            for (String str : predicateStrs) {
                Intrinsics.checkNotNull(str);
                arrayList.add(findPredicate(str));
            }
            this.predicates = (IntPredicate[]) arrayList.toArray(new IntPredicate[0]);
            this.text = text;
        }

        private final IntPredicate findPredicate(String str) {
            int iHashCode = str.hashCode();
            if (iHashCode != -1690360067) {
                if (iHashCode != -1663276706) {
                    if (iHashCode == 79430 && str.equals("One")) {
                        return AmountFormats.PREDICATE_1;
                    }
                } else if (str.equals("End234NotTeens")) {
                    return AmountFormats.PREDICATE_END234_NOTTEENS;
                }
            } else if (str.equals("End1Not11")) {
                return AmountFormats.PREDICATE_END1_NOT11;
            }
            throw new IllegalStateException("Invalid word-based resource");
        }

        @Override // com.superwall.sdk.contrib.threeteen.AmountFormats.UnitFormat
        public void formatTo(int i3, StringBuilder buf) {
            Intrinsics.checkNotNullParameter(buf, "buf");
            int length = this.predicates.length;
            for (int i4 = 0; i4 < length; i4++) {
                if (this.predicates[i4].test(i3)) {
                    buf.append(i3);
                    buf.append(this.text[i4]);
                    return;
                }
            }
            buf.append(i3);
            buf.append(this.text[this.predicates.length]);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class SinglePluralFormat implements UnitFormat {
        private final String plural;
        private final String single;

        public SinglePluralFormat(String single, String plural) {
            Intrinsics.checkNotNullParameter(single, "single");
            Intrinsics.checkNotNullParameter(plural, "plural");
            this.single = single;
            this.plural = plural;
        }

        @Override // com.superwall.sdk.contrib.threeteen.AmountFormats.UnitFormat
        public void formatTo(int i3, StringBuilder buf) {
            Intrinsics.checkNotNullParameter(buf, "buf");
            buf.append(i3);
            buf.append((i3 == -1 || i3 == 1) ? this.single : this.plural);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public interface UnitFormat {
        public static final Companion Companion = Companion.$$INSTANCE;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();

            private Companion() {
            }

            public final UnitFormat of(ResourceBundle bundle, String keyStem) {
                Intrinsics.checkNotNullParameter(bundle, "bundle");
                Intrinsics.checkNotNullParameter(keyStem, "keyStem");
                if (!bundle.containsKey(keyStem + "s.predicates")) {
                    String string = bundle.getString(keyStem);
                    String string2 = bundle.getString(keyStem + "s");
                    Intrinsics.checkNotNull(string);
                    Intrinsics.checkNotNull(string2);
                    return new SinglePluralFormat(string, string2);
                }
                String string3 = bundle.getString(keyStem + "s.predicates");
                String string4 = bundle.getString(keyStem + "s.list");
                String[] strArrSplit = AmountFormats.SPLITTER.split(string3);
                String[] strArrSplit2 = AmountFormats.SPLITTER.split(string4);
                Intrinsics.checkNotNull(strArrSplit);
                Intrinsics.checkNotNull(strArrSplit2);
                return new PredicateFormat(strArrSplit, strArrSplit2);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class DefaultImpls {
            public static void formatTo(UnitFormat unitFormat, int i3, StringBuilder buf) {
                Intrinsics.checkNotNullParameter(buf, "buf");
            }
        }

        void formatTo(int i3, StringBuilder sb);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class WordBased {
        private final String lastSeparator;
        private final String separator;
        private final UnitFormat[] units;

        public WordBased(UnitFormat[] units, String separator, String lastSeparator) {
            Intrinsics.checkNotNullParameter(units, "units");
            Intrinsics.checkNotNullParameter(separator, "separator");
            Intrinsics.checkNotNullParameter(lastSeparator, "lastSeparator");
            this.units = units;
            this.separator = separator;
            this.lastSeparator = lastSeparator;
        }

        public final String format(int[] values) {
            Intrinsics.checkNotNullParameter(values, "values");
            StringBuilder sb = new StringBuilder(32);
            int i3 = 0;
            for (int i4 : values) {
                if (i4 != 0) {
                    i3++;
                }
            }
            int length = values.length;
            int i5 = 0;
            for (int i6 = 0; i6 < length; i6++) {
                int i7 = values[i6];
                if (i7 != 0 || (i5 == 0 && i6 == values.length - 1)) {
                    this.units[i6].formatTo(i7, sb);
                    int i8 = i3 - 2;
                    if (i5 < i8) {
                        sb.append(this.separator);
                    } else if (i5 == i8) {
                        sb.append(this.lastSeparator);
                    }
                    i5++;
                }
            }
            String string = sb.toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            return string;
        }
    }

    private AmountFormats() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean PREDICATE_1$lambda$0(int i3) {
        return i3 == 1 || i3 == -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean PREDICATE_END1_NOT11$lambda$1(int i3) {
        int iAbs = Math.abs(i3);
        return iAbs % 10 == 1 && (iAbs % 100) / 10 != 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean PREDICATE_END234_NOTTEENS$lambda$2(int i3) {
        int iAbs = Math.abs(i3);
        int i4 = iAbs % 10;
        return i4 >= 2 && i4 <= 4 && (iAbs % 100) / 10 != 1;
    }

    private final ParsedUnitPart consumeDurationFraction(CharSequence charSequence, CharSequence charSequence2, int i3) {
        int i4 = 0;
        long j3 = 0;
        long j4 = 1;
        boolean z2 = false;
        while (i4 < charSequence.length()) {
            char cCharAt = charSequence.charAt(i4);
            if (Intrinsics.compare((int) cCharAt, 48) < 0 || Intrinsics.compare((int) cCharAt, 57) > 0) {
                break;
            }
            if (z2 || j3 > 922337203685477580L) {
                i4++;
            } else {
                long j5 = 10;
                long j6 = (j3 * j5) + ((long) (cCharAt - '0'));
                if (j6 < 0) {
                    i4++;
                    z2 = true;
                } else {
                    j4 *= j5;
                    i4++;
                    j3 = j6;
                }
            }
        }
        if (i4 != 0) {
            return new ParsedUnitPart(charSequence.subSequence(i4, charSequence.length()), new FractionScalarPart(j3, j4));
        }
        throw new DateTimeParseException("Missing numeric fraction after '.'", charSequence2, i3);
    }

    private final ParsedUnitPart consumeDurationLeadingInt(CharSequence charSequence, CharSequence charSequence2, int i3) {
        int length = charSequence.length();
        int i4 = 0;
        long j3 = 0;
        while (i4 < length) {
            char cCharAt = charSequence.charAt(i4);
            if (Intrinsics.compare((int) cCharAt, 48) < 0 || Intrinsics.compare((int) cCharAt, 57) > 0) {
                break;
            }
            if (j3 > 922337203685477580L) {
                throw new DateTimeParseException("Duration string exceeds valid numeric range", charSequence2, i4 + i3);
            }
            j3 = (j3 * ((long) 10)) + ((long) (cCharAt - '0'));
            if (j3 < 0) {
                throw new DateTimeParseException("Duration string exceeds valid numeric range", charSequence2, i4 + i3);
            }
            i4++;
        }
        if (i4 != 0) {
            return new ParsedUnitPart(charSequence.subSequence(i4, charSequence.length()), new IntegerScalarPart(j3));
        }
        throw new DateTimeParseException("Missing leading integer", charSequence2, i3);
    }

    /* JADX INFO: renamed from: consumePrefix-gIAlu-s, reason: not valid java name */
    private final Object m1265consumePrefixgIAlus(CharSequence charSequence, char c3) {
        if (charSequence.length() <= 0 || charSequence.charAt(0) != c3) {
            Result.Companion companion = Result.f139772b;
            return Result.b(ResultKt.a(new Exception("Prefix not found")));
        }
        Result.Companion companion2 = Result.f139772b;
        return Result.b(charSequence.subSequence(1, charSequence.length()));
    }

    /* JADX INFO: renamed from: findUnit-IoAF18A, reason: not valid java name */
    private final Object m1266findUnitIoAF18A(CharSequence charSequence) {
        Object next;
        Iterator<T> it = DURATION_UNITS.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (((DurationUnit) next).prefixMatchesUnit(charSequence)) {
                break;
            }
        }
        DurationUnit durationUnit = (DurationUnit) next;
        if (durationUnit != null) {
            return Result.b(durationUnit);
        }
        Result.Companion companion = Result.f139772b;
        return Result.b(ResultKt.a(new Exception("No matching duration unit found")));
    }

    private final boolean oppositeSigns(int i3, int i4) {
        return i3 < 0 ? i4 >= 0 : i4 < 0;
    }

    public final ResourceBundle getResourceBundle(Locale locale) {
        Intrinsics.checkNotNullParameter(locale, "locale");
        try {
            return ResourceBundle.getBundle(BUNDLE_NAME, locale);
        } catch (MissingResourceException e3) {
            Logger.INSTANCE.debug(LogLevel.error, LogScope.localizationManager, "Resource not found: com.superwall.extra.wordbased", MapsKt.mapOf(TuplesKt.a("locale", locale)), e3);
            return ResourceBundle.getBundle(BUNDLE_NAME, Locale.ENGLISH);
        }
    }

    public final String iso8601(Period period, Duration duration) {
        Intrinsics.checkNotNullParameter(period, "period");
        Intrinsics.checkNotNullParameter(duration, "duration");
        Objects.requireNonNull(period, "period must not be null");
        Objects.requireNonNull(duration, "duration must not be null");
        if (period.e()) {
            String string = duration.toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            return string;
        }
        if (duration.j()) {
            String string2 = period.toString();
            Intrinsics.checkNotNull(string2);
            return string2;
        }
        String string3 = duration.toString();
        Intrinsics.checkNotNullExpressionValue(string3, "toString(...)");
        String strSubstring = string3.substring(1);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        return period + strSubstring;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Duration parseUnitBasedDuration(CharSequence durationText) {
        CharSequence charSequence;
        byte b3;
        Intrinsics.checkNotNullParameter(durationText, "durationText");
        Objects.requireNonNull(durationText, "durationText must not be null");
        Object objM1265consumePrefixgIAlus = m1265consumePrefixgIAlus(durationText, '-');
        boolean z2 = true;
        if (Result.h(objM1265consumePrefixgIAlus)) {
            if (Result.g(objM1265consumePrefixgIAlus)) {
                objM1265consumePrefixgIAlus = null;
            }
            Intrinsics.checkNotNull(objM1265consumePrefixgIAlus);
            charSequence = (CharSequence) objM1265consumePrefixgIAlus;
            b3 = -1;
        } else {
            Object objM1265consumePrefixgIAlus2 = m1265consumePrefixgIAlus(durationText, '+');
            boolean zH = Result.h(objM1265consumePrefixgIAlus2);
            if (Result.g(objM1265consumePrefixgIAlus2)) {
                objM1265consumePrefixgIAlus2 = null;
            }
            charSequence = (CharSequence) objM1265consumePrefixgIAlus2;
            if (charSequence == null) {
                charSequence = durationText;
            }
            z2 = zH;
            b3 = 1;
        }
        if (Intrinsics.areEqual(charSequence, AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
            Duration ZERO = Duration.f146124c;
            Intrinsics.checkNotNullExpressionValue(ZERO, "ZERO");
            return ZERO;
        }
        if (charSequence.length() == 0) {
            throw new DateTimeParseException("Not a numeric value", durationText, 0);
        }
        Duration durationU = Duration.f146124c;
        int length = charSequence.length();
        int i3 = z2;
        while (length > 0) {
            ParsedUnitPart parsedUnitPartConsumeDurationLeadingInt = consumeDurationLeadingInt(charSequence, durationText, i3);
            int length2 = i3 + (charSequence.length() - parsedUnitPartConsumeDurationLeadingInt.remainingText().length());
            CharSequence charSequenceRemainingText = parsedUnitPartConsumeDurationLeadingInt.remainingText();
            FractionScalarPart fractionScalarPart = EMPTY_FRACTION;
            Object objM1265consumePrefixgIAlus3 = m1265consumePrefixgIAlus(charSequenceRemainingText, '.');
            DurationScalar durationScalar = fractionScalarPart;
            if (Result.h(objM1265consumePrefixgIAlus3)) {
                int i4 = length2 + 1;
                if (Result.g(objM1265consumePrefixgIAlus3)) {
                    objM1265consumePrefixgIAlus3 = null;
                }
                Intrinsics.checkNotNull(objM1265consumePrefixgIAlus3);
                CharSequence charSequence2 = (CharSequence) objM1265consumePrefixgIAlus3;
                ParsedUnitPart parsedUnitPartConsumeDurationFraction = consumeDurationFraction(charSequence2, durationText, i4);
                length2 = i4 + (charSequence2.length() - parsedUnitPartConsumeDurationFraction.remainingText().length());
                charSequenceRemainingText = parsedUnitPartConsumeDurationFraction.remainingText();
                durationScalar = parsedUnitPartConsumeDurationFraction;
            }
            Object objM1266findUnitIoAF18A = m1266findUnitIoAF18A(charSequenceRemainingText);
            if (Result.g(objM1266findUnitIoAF18A)) {
                throw new DateTimeParseException("Invalid duration unit", durationText, length2);
            }
            if (Result.g(objM1266findUnitIoAF18A)) {
                objM1266findUnitIoAF18A = null;
            }
            Intrinsics.checkNotNull(objM1266findUnitIoAF18A);
            DurationUnit durationUnit = (DurationUnit) objM1266findUnitIoAF18A;
            try {
                durationU = durationU.u(parsedUnitPartConsumeDurationLeadingInt.applyTo(durationUnit).u(durationScalar.applyTo(durationUnit)));
                CharSequence charSequenceConsumeDurationUnit = durationUnit.consumeDurationUnit(charSequenceRemainingText);
                int length3 = length2 + (charSequenceRemainingText.length() - charSequenceConsumeDurationUnit.length());
                length = charSequenceConsumeDurationUnit.length();
                charSequence = charSequenceConsumeDurationUnit;
                i3 = length3;
            } catch (ArithmeticException e3) {
                throw new DateTimeParseException("Duration string exceeds valid numeric range", durationText, length2, e3);
            }
        }
        if (b3 >= 0) {
            Intrinsics.checkNotNull(durationU);
            return durationU;
        }
        Duration durationL = durationU.l();
        Intrinsics.checkNotNullExpressionValue(durationL, "negated(...)");
        return durationL;
    }

    public final String wordBased(Period period, Locale locale) {
        int iG;
        Intrinsics.checkNotNullParameter(period, "period");
        Intrinsics.checkNotNullParameter(locale, "locale");
        Objects.requireNonNull(period, "period must not be null");
        Objects.requireNonNull(locale, "locale must not be null");
        ResourceBundle resourceBundle = getResourceBundle(locale);
        UnitFormat.Companion companion = UnitFormat.Companion;
        int iG2 = 0;
        UnitFormat[] unitFormatArr = {companion.of(resourceBundle, WORDBASED_YEAR), companion.of(resourceBundle, WORDBASED_MONTH), companion.of(resourceBundle, WORDBASED_WEEK), companion.of(resourceBundle, WORDBASED_DAY)};
        String string = resourceBundle.getString(qRMDmh.xWFDypBtWQNf);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String string2 = resourceBundle.getString(WORDBASED_SPACEANDSPACE);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        WordBased wordBased = new WordBased(unitFormatArr, string, string2);
        if (oppositeSigns(period.h(), period.i())) {
            period = period.j();
        }
        if (period.g() % 7 == 0) {
            iG2 = period.g() / 7;
            iG = 0;
        } else {
            iG = period.g();
        }
        return wordBased.format(new int[]{period.i(), period.h(), iG2, iG});
    }

    static {
        Duration durationQ = Duration.q(1L);
        Intrinsics.checkNotNullExpressionValue(durationQ, "ofNanos(...)");
        DurationUnit durationUnit = new DurationUnit("ns", durationQ);
        Duration durationQ2 = Duration.q(1000L);
        Intrinsics.checkNotNullExpressionValue(durationQ2, "ofNanos(...)");
        DurationUnit durationUnit2 = new DurationUnit("µs", durationQ2);
        Duration durationQ3 = Duration.q(1000L);
        Intrinsics.checkNotNullExpressionValue(durationQ3, "ofNanos(...)");
        DurationUnit durationUnit3 = new DurationUnit("μs", durationQ3);
        Duration durationQ4 = Duration.q(1000L);
        Intrinsics.checkNotNullExpressionValue(durationQ4, "ofNanos(...)");
        DurationUnit durationUnit4 = new DurationUnit("us", durationQ4);
        Duration durationO = Duration.o(1L);
        Intrinsics.checkNotNullExpressionValue(durationO, "ofMillis(...)");
        DurationUnit durationUnit5 = new DurationUnit(muQRKXGtpOhe.leeCWY, durationO);
        Duration durationR = Duration.r(1L);
        Intrinsics.checkNotNullExpressionValue(durationR, "ofSeconds(...)");
        DurationUnit durationUnit6 = new DurationUnit("s", durationR);
        Duration durationP = Duration.p(1L);
        Intrinsics.checkNotNullExpressionValue(durationP, "ofMinutes(...)");
        DurationUnit durationUnit7 = new DurationUnit("m", durationP);
        Duration durationN = Duration.n(1L);
        Intrinsics.checkNotNullExpressionValue(durationN, "ofHours(...)");
        DURATION_UNITS = CollectionsKt.listOf((Object[]) new DurationUnit[]{durationUnit, durationUnit2, durationUnit3, durationUnit4, durationUnit5, durationUnit6, durationUnit7, new DurationUnit("h", durationN)});
        EMPTY_FRACTION = new FractionScalarPart(0L, 0L);
    }

    public final String wordBased(Duration duration, Locale locale) {
        Intrinsics.checkNotNullParameter(duration, "duration");
        Intrinsics.checkNotNullParameter(locale, "locale");
        Objects.requireNonNull(duration, "duration must not be null");
        Objects.requireNonNull(locale, "locale must not be null");
        ResourceBundle bundle = ResourceBundle.getBundle(BUNDLE_NAME, locale);
        UnitFormat.Companion companion = UnitFormat.Companion;
        Intrinsics.checkNotNull(bundle);
        UnitFormat[] unitFormatArr = {companion.of(bundle, WORDBASED_HOUR), companion.of(bundle, WORDBASED_MINUTE), companion.of(bundle, WORDBASED_SECOND), companion.of(bundle, WORDBASED_MILLISECOND)};
        String string = bundle.getString(WORDBASED_COMMASPACE);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String string2 = bundle.getString(WORDBASED_SPACEANDSPACE);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        long j3 = 60;
        return new WordBased(unitFormatArr, string, string2).format(new int[]{(int) duration.x(), (int) (duration.z() % j3), (int) (duration.i() % j3), duration.h() / NANOS_PER_MILLIS});
    }

    public final String wordBased(Period period, Duration duration, Locale locale) {
        int iG;
        Intrinsics.checkNotNullParameter(period, "period");
        Intrinsics.checkNotNullParameter(duration, "duration");
        Intrinsics.checkNotNullParameter(locale, "locale");
        Objects.requireNonNull(period, "period must not be null");
        Objects.requireNonNull(duration, "duration must not be null");
        Objects.requireNonNull(locale, "locale must not be null");
        ResourceBundle bundle = ResourceBundle.getBundle(BUNDLE_NAME, locale);
        UnitFormat.Companion companion = UnitFormat.Companion;
        Intrinsics.checkNotNull(bundle);
        int iG2 = 0;
        UnitFormat[] unitFormatArr = {companion.of(bundle, WORDBASED_YEAR), companion.of(bundle, WORDBASED_MONTH), companion.of(bundle, WORDBASED_WEEK), companion.of(bundle, WORDBASED_DAY), companion.of(bundle, WORDBASED_HOUR), companion.of(bundle, WORDBASED_MINUTE), companion.of(bundle, WORDBASED_SECOND), companion.of(bundle, WORDBASED_MILLISECOND)};
        String string = bundle.getString(WORDBASED_COMMASPACE);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String string2 = bundle.getString(WORDBASED_SPACEANDSPACE);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        WordBased wordBased = new WordBased(unitFormatArr, string, string2);
        if (oppositeSigns(period.h(), period.i())) {
            period = period.j();
        }
        if (period.g() % 7 == 0) {
            iG = period.g() / 7;
        } else {
            iG = 0;
            iG2 = period.g();
        }
        long jX = duration.x();
        long j3 = 24;
        long j4 = 60;
        return wordBased.format(new int[]{period.i(), period.h(), iG, iG2 + ((int) (jX / j3)), (int) (jX % j3), (int) (duration.z() % j4), (int) (duration.i() % j4), duration.h() / NANOS_PER_MILLIS});
    }
}
