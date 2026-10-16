package kotlin.text;

import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
@Metadata
public final class RegexOption implements FlagEnum {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final RegexOption f140589c = new RegexOption("IGNORE_CASE", 0, 2, 0, 2, null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final RegexOption f140590d = new RegexOption("MULTILINE", 1, 8, 0, 2, null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final RegexOption f140591f = new RegexOption("LITERAL", 2, 16, 0, 2, null);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final RegexOption f140592g = new RegexOption("UNIX_LINES", 3, 1, 0, 2, null);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final RegexOption f140593h = new RegexOption("COMMENTS", 4, 4, 0, 2, null);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final RegexOption f140594i = new RegexOption("DOT_MATCHES_ALL", 5, 32, 0, 2, null);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final RegexOption f140595j = new RegexOption("CANON_EQ", 6, ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD, 0, 2, null);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final /* synthetic */ RegexOption[] f140596k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final /* synthetic */ EnumEntries f140597l;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f140598a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f140599b;

    static {
        RegexOption[] regexOptionArrB = b();
        f140596k = regexOptionArrB;
        f140597l = EnumEntriesKt.a(regexOptionArrB);
    }

    private RegexOption(String str, int i3, int i4, int i5) {
        this.f140598a = i4;
        this.f140599b = i5;
    }

    private static final /* synthetic */ RegexOption[] b() {
        return new RegexOption[]{f140589c, f140590d, f140591f, f140592g, f140593h, f140594i, f140595j};
    }

    public static RegexOption valueOf(String str) {
        return (RegexOption) Enum.valueOf(RegexOption.class, str);
    }

    public static RegexOption[] values() {
        return (RegexOption[]) f140596k.clone();
    }

    @Override // kotlin.text.FlagEnum
    public int a() {
        return this.f140599b;
    }

    @Override // kotlin.text.FlagEnum
    public int getValue() {
        return this.f140598a;
    }

    /* synthetic */ RegexOption(String str, int i3, int i4, int i5, int i6, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i3, i4, (i6 & 2) != 0 ? i4 : i5);
    }
}
