package androidx.compose.material3.tokens;

import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class TextButtonTokens {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final TextButtonTokens f23500a = new TextButtonTokens();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final float f23501b = Dp.g((float) 40.0d);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final ShapeKeyTokens f23502c = ShapeKeyTokens.CornerFull;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f23503d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f23504e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f23505f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f23506g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final TypographyKeyTokens f23507h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f23508i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f23509j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f23510k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f23511l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f23512m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final float f23513n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f23514o;

    static {
        ColorSchemeKeyTokens colorSchemeKeyTokens = ColorSchemeKeyTokens.OnSurface;
        f23503d = colorSchemeKeyTokens;
        ColorSchemeKeyTokens colorSchemeKeyTokens2 = ColorSchemeKeyTokens.Primary;
        f23504e = colorSchemeKeyTokens2;
        f23505f = colorSchemeKeyTokens2;
        f23506g = colorSchemeKeyTokens2;
        f23507h = TypographyKeyTokens.LabelLarge;
        f23508i = colorSchemeKeyTokens2;
        f23509j = colorSchemeKeyTokens;
        f23510k = colorSchemeKeyTokens2;
        f23511l = colorSchemeKeyTokens2;
        f23512m = colorSchemeKeyTokens2;
        f23513n = Dp.g((float) 18.0d);
        f23514o = colorSchemeKeyTokens2;
    }

    private TextButtonTokens() {
    }

    public final ShapeKeyTokens a() {
        return f23502c;
    }

    public final ColorSchemeKeyTokens b() {
        return f23503d;
    }

    public final ColorSchemeKeyTokens c() {
        return f23506g;
    }
}
