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
public final class ProgressIndicatorTokens {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ProgressIndicatorTokens f23273a = new ProgressIndicatorTokens();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f23274b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final ShapeKeyTokens f23275c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final float f23276d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final float f23277e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f23278f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final float f23279g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final float f23280h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f23281i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final ShapeKeyTokens f23282j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final float f23283k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final float f23284l;

    static {
        ColorSchemeKeyTokens colorSchemeKeyTokens = ColorSchemeKeyTokens.Primary;
        f23274b = colorSchemeKeyTokens;
        ShapeKeyTokens shapeKeyTokens = ShapeKeyTokens.CornerFull;
        f23275c = shapeKeyTokens;
        float f3 = (float) 4.0d;
        f23276d = Dp.g(f3);
        f23277e = Dp.g(f3);
        f23278f = colorSchemeKeyTokens;
        f23279g = Dp.g(f3);
        f23280h = Dp.g(f3);
        f23281i = ColorSchemeKeyTokens.SecondaryContainer;
        f23282j = shapeKeyTokens;
        f23283k = Dp.g(f3);
        f23284l = Dp.g((float) 48.0d);
    }

    private ProgressIndicatorTokens() {
    }

    public final ColorSchemeKeyTokens a() {
        return f23274b;
    }

    public final float b() {
        return f23277e;
    }

    public final float c() {
        return f23284l;
    }

    public final float d() {
        return f23280h;
    }

    public final ColorSchemeKeyTokens e() {
        return f23281i;
    }

    public final float f() {
        return f23283k;
    }
}
