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
public final class BadgeTokens {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final BadgeTokens f22320a = new BadgeTokens();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f22321b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f22322c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f22323d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final TypographyKeyTokens f22324e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final ShapeKeyTokens f22325f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final float f22326g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final ShapeKeyTokens f22327h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final float f22328i;

    static {
        ColorSchemeKeyTokens colorSchemeKeyTokens = ColorSchemeKeyTokens.Error;
        f22321b = colorSchemeKeyTokens;
        f22322c = colorSchemeKeyTokens;
        f22323d = ColorSchemeKeyTokens.OnError;
        f22324e = TypographyKeyTokens.LabelSmall;
        ShapeKeyTokens shapeKeyTokens = ShapeKeyTokens.CornerFull;
        f22325f = shapeKeyTokens;
        f22326g = Dp.g((float) 16.0d);
        f22327h = shapeKeyTokens;
        f22328i = Dp.g((float) 6.0d);
    }

    private BadgeTokens() {
    }

    public final ColorSchemeKeyTokens a() {
        return f22321b;
    }

    public final TypographyKeyTokens b() {
        return f22324e;
    }

    public final ShapeKeyTokens c() {
        return f22325f;
    }

    public final float d() {
        return f22326g;
    }

    public final ShapeKeyTokens e() {
        return f22327h;
    }

    public final float f() {
        return f22328i;
    }
}
