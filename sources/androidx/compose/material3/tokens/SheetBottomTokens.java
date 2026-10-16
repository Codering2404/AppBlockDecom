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
public final class SheetBottomTokens {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SheetBottomTokens f23386a = new SheetBottomTokens();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f23387b = ColorSchemeKeyTokens.SurfaceContainerLow;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final ShapeKeyTokens f23388c = ShapeKeyTokens.CornerExtraLargeTop;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f23389d = ColorSchemeKeyTokens.OnSurfaceVariant;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final float f23390e = Dp.g((float) 4.0d);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final float f23391f = Dp.g((float) 32.0d);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final ShapeKeyTokens f23392g = ShapeKeyTokens.CornerNone;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final float f23393h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final float f23394i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f23395j;

    static {
        ElevationTokens elevationTokens = ElevationTokens.f22534a;
        f23393h = elevationTokens.b();
        f23394i = elevationTokens.b();
        f23395j = ColorSchemeKeyTokens.Secondary;
    }

    private SheetBottomTokens() {
    }

    public final ColorSchemeKeyTokens a() {
        return f23387b;
    }

    public final ShapeKeyTokens b() {
        return f23388c;
    }

    public final ColorSchemeKeyTokens c() {
        return f23389d;
    }

    public final float d() {
        return f23390e;
    }

    public final float e() {
        return f23391f;
    }

    public final float f() {
        return f23393h;
    }
}
