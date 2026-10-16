package kotlin.text;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
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
public final class CharCategory {
    private static final /* synthetic */ CharCategory[] I;
    private static final /* synthetic */ EnumEntries J;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Companion f140459c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f140482a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f140483b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final CharCategory f140460d = new CharCategory("UNASSIGNED", 0, 0, "Cn");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final CharCategory f140461f = new CharCategory("UPPERCASE_LETTER", 1, 1, "Lu");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final CharCategory f140462g = new CharCategory("LOWERCASE_LETTER", 2, 2, "Ll");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final CharCategory f140463h = new CharCategory("TITLECASE_LETTER", 3, 3, "Lt");

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final CharCategory f140464i = new CharCategory("MODIFIER_LETTER", 4, 4, "Lm");

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final CharCategory f140465j = new CharCategory("OTHER_LETTER", 5, 5, "Lo");

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final CharCategory f140466k = new CharCategory("NON_SPACING_MARK", 6, 6, "Mn");

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final CharCategory f140467l = new CharCategory("ENCLOSING_MARK", 7, 7, "Me");

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final CharCategory f140468m = new CharCategory("COMBINING_SPACING_MARK", 8, 8, "Mc");

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final CharCategory f140469n = new CharCategory("DECIMAL_DIGIT_NUMBER", 9, 9, "Nd");

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final CharCategory f140470o = new CharCategory("LETTER_NUMBER", 10, 10, "Nl");

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final CharCategory f140471p = new CharCategory("OTHER_NUMBER", 11, 11, "No");

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final CharCategory f140472q = new CharCategory("SPACE_SEPARATOR", 12, 12, "Zs");

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final CharCategory f140473r = new CharCategory("LINE_SEPARATOR", 13, 13, "Zl");

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final CharCategory f140474s = new CharCategory("PARAGRAPH_SEPARATOR", 14, 14, "Zp");

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final CharCategory f140475t = new CharCategory("CONTROL", 15, 15, "Cc");

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final CharCategory f140476u = new CharCategory("FORMAT", 16, 16, "Cf");

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final CharCategory f140477v = new CharCategory("PRIVATE_USE", 17, 18, "Co");

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final CharCategory f140478w = new CharCategory("SURROGATE", 18, 19, "Cs");

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final CharCategory f140479x = new CharCategory("DASH_PUNCTUATION", 19, 20, "Pd");

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final CharCategory f140480y = new CharCategory("START_PUNCTUATION", 20, 21, "Ps");

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final CharCategory f140481z = new CharCategory("END_PUNCTUATION", 21, 22, "Pe");
    public static final CharCategory A = new CharCategory("CONNECTOR_PUNCTUATION", 22, 23, "Pc");
    public static final CharCategory B = new CharCategory("OTHER_PUNCTUATION", 23, 24, "Po");
    public static final CharCategory C = new CharCategory("MATH_SYMBOL", 24, 25, "Sm");
    public static final CharCategory D = new CharCategory("CURRENCY_SYMBOL", 25, 26, "Sc");
    public static final CharCategory E = new CharCategory("MODIFIER_SYMBOL", 26, 27, "Sk");
    public static final CharCategory F = new CharCategory("OTHER_SYMBOL", 27, 28, "So");
    public static final CharCategory G = new CharCategory("INITIAL_QUOTE_PUNCTUATION", 28, 29, "Pi");
    public static final CharCategory H = new CharCategory("FINAL_QUOTE_PUNCTUATION", 29, 30, "Pf");

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    static {
        CharCategory[] charCategoryArrA = a();
        I = charCategoryArrA;
        J = EnumEntriesKt.a(charCategoryArrA);
        f140459c = new Companion(null);
    }

    private CharCategory(String str, int i3, int i4, String str2) {
        this.f140482a = i4;
        this.f140483b = str2;
    }

    private static final /* synthetic */ CharCategory[] a() {
        return new CharCategory[]{f140460d, f140461f, f140462g, f140463h, f140464i, f140465j, f140466k, f140467l, f140468m, f140469n, f140470o, f140471p, f140472q, f140473r, f140474s, f140475t, f140476u, f140477v, f140478w, f140479x, f140480y, f140481z, A, B, C, D, E, F, G, H};
    }

    public static CharCategory valueOf(String str) {
        return (CharCategory) Enum.valueOf(CharCategory.class, str);
    }

    public static CharCategory[] values() {
        return (CharCategory[]) I.clone();
    }
}
