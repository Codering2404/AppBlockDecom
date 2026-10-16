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
public final class DateInputModalTokens {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final float f22443g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final float f22445i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f22446j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final TypographyKeyTokens f22447k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f22448l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final TypographyKeyTokens f22449m;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DateInputModalTokens f22437a = new DateInputModalTokens();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f22438b = ColorSchemeKeyTokens.Surface;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final float f22439c = ElevationTokens.f22534a.d();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final float f22440d = Dp.g((float) 512.0d);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final ShapeKeyTokens f22441e = ShapeKeyTokens.CornerExtraLarge;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f22442f = ColorSchemeKeyTokens.SurfaceTint;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final float f22444h = Dp.g((float) 120.0d);

    static {
        float f3 = (float) 328.0d;
        f22443g = Dp.g(f3);
        f22445i = Dp.g(f3);
        ColorSchemeKeyTokens colorSchemeKeyTokens = ColorSchemeKeyTokens.OnSurfaceVariant;
        f22446j = colorSchemeKeyTokens;
        f22447k = TypographyKeyTokens.HeadlineLarge;
        f22448l = colorSchemeKeyTokens;
        f22449m = TypographyKeyTokens.LabelLarge;
    }

    private DateInputModalTokens() {
    }
}
