package kotlin.text;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

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
/* JADX INFO: loaded from: classes9.dex */
@Metadata
public final class Regex implements Serializable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Companion f140573b = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Pattern f140574a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int b(int i3) {
            return (i3 & 2) != 0 ? i3 | 64 : i3;
        }

        public final String c(String literal) {
            Intrinsics.checkNotNullParameter(literal, "literal");
            String strQuote = Pattern.quote(literal);
            Intrinsics.checkNotNullExpressionValue(strQuote, "quote(...)");
            return strQuote;
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class Serialized implements Serializable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final Companion f140575c = new Companion(null);
        private static final long serialVersionUID = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f140576a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f140577b;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }

        public Serialized(String pattern, int i3) {
            Intrinsics.checkNotNullParameter(pattern, "pattern");
            this.f140576a = pattern;
            this.f140577b = i3;
        }

        private final Object readResolve() {
            Pattern patternCompile = Pattern.compile(this.f140576a, this.f140577b);
            Intrinsics.checkNotNullExpressionValue(patternCompile, "compile(...)");
            return new Regex(patternCompile);
        }
    }

    public Regex(Pattern nativePattern) {
        Intrinsics.checkNotNullParameter(nativePattern, "nativePattern");
        this.f140574a = nativePattern;
    }

    public static /* synthetic */ MatchResult e(Regex regex, CharSequence charSequence, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i3 = 0;
        }
        return regex.d(charSequence, i3);
    }

    public static /* synthetic */ Sequence g(Regex regex, CharSequence charSequence, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i3 = 0;
        }
        return regex.f(charSequence, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MatchResult h(Regex regex, CharSequence charSequence, int i3) {
        return regex.d(charSequence, i3);
    }

    private final void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization is supported via proxy only");
    }

    private final Object writeReplace() {
        String strPattern = this.f140574a.pattern();
        Intrinsics.checkNotNullExpressionValue(strPattern, "pattern(...)");
        return new Serialized(strPattern, this.f140574a.flags());
    }

    public final boolean c(CharSequence input) {
        Intrinsics.checkNotNullParameter(input, "input");
        return this.f140574a.matcher(input).find();
    }

    public final MatchResult d(CharSequence input, int i3) {
        Intrinsics.checkNotNullParameter(input, "input");
        Matcher matcher = this.f140574a.matcher(input);
        Intrinsics.checkNotNullExpressionValue(matcher, "matcher(...)");
        return RegexKt.e(matcher, i3, input);
    }

    public final Sequence f(final CharSequence input, final int i3) {
        Intrinsics.checkNotNullParameter(input, "input");
        if (i3 >= 0 && i3 <= input.length()) {
            return SequencesKt.j(new Function0() { // from class: kotlin.text.c
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return Regex.h(this.f140611a, input, i3);
                }
            }, Regex$findAll$2.f140578a);
        }
        throw new IndexOutOfBoundsException("Start index out of bounds: " + i3 + ", input length: " + input.length());
    }

    public final String i() {
        String strPattern = this.f140574a.pattern();
        Intrinsics.checkNotNullExpressionValue(strPattern, "pattern(...)");
        return strPattern;
    }

    public final MatchResult j(CharSequence input) {
        Intrinsics.checkNotNullParameter(input, "input");
        Matcher matcher = this.f140574a.matcher(input);
        Intrinsics.checkNotNullExpressionValue(matcher, "matcher(...)");
        return RegexKt.f(matcher, input);
    }

    public final boolean k(CharSequence input) {
        Intrinsics.checkNotNullParameter(input, "input");
        return this.f140574a.matcher(input).matches();
    }

    public final String l(CharSequence input, Function1 transform) {
        Intrinsics.checkNotNullParameter(input, "input");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int iIntValue = 0;
        MatchResult matchResultE = e(this, input, 0, 2, null);
        if (matchResultE == null) {
            return input.toString();
        }
        int length = input.length();
        StringBuilder sb = new StringBuilder(length);
        do {
            sb.append(input, iIntValue, matchResultE.c().a().intValue());
            sb.append((CharSequence) transform.invoke(matchResultE));
            iIntValue = matchResultE.c().e().intValue() + 1;
            matchResultE = matchResultE.next();
            if (iIntValue >= length) {
                break;
            }
        } while (matchResultE != null);
        if (iIntValue < length) {
            sb.append(input, iIntValue, length);
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    public final List m(CharSequence input, int i3) {
        Intrinsics.checkNotNullParameter(input, "input");
        StringsKt__StringsKt.Q0(i3);
        Matcher matcher = this.f140574a.matcher(input);
        if (i3 == 1 || !matcher.find()) {
            return CollectionsKt.listOf(input.toString());
        }
        ArrayList arrayList = new ArrayList(i3 > 0 ? RangesKt.k(i3, 10) : 10);
        int i4 = i3 - 1;
        int iEnd = 0;
        do {
            arrayList.add(input.subSequence(iEnd, matcher.start()).toString());
            iEnd = matcher.end();
            if (i4 >= 0 && arrayList.size() == i4) {
                break;
            }
        } while (matcher.find());
        arrayList.add(input.subSequence(iEnd, input.length()).toString());
        return arrayList;
    }

    public final String replace(CharSequence input, String replacement) {
        Intrinsics.checkNotNullParameter(input, "input");
        Intrinsics.checkNotNullParameter(replacement, "replacement");
        String strReplaceAll = this.f140574a.matcher(input).replaceAll(replacement);
        Intrinsics.checkNotNullExpressionValue(strReplaceAll, "replaceAll(...)");
        return strReplaceAll;
    }

    public String toString() {
        String string = this.f140574a.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public Regex(String pattern) {
        Intrinsics.checkNotNullParameter(pattern, "pattern");
        Pattern patternCompile = Pattern.compile(pattern);
        Intrinsics.checkNotNullExpressionValue(patternCompile, "compile(...)");
        this(patternCompile);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public Regex(String pattern, RegexOption option) {
        Intrinsics.checkNotNullParameter(pattern, "pattern");
        Intrinsics.checkNotNullParameter(option, "option");
        Pattern patternCompile = Pattern.compile(pattern, f140573b.b(option.getValue()));
        Intrinsics.checkNotNullExpressionValue(patternCompile, "compile(...)");
        this(patternCompile);
    }
}
