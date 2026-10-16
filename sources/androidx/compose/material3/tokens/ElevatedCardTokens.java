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
public final class ElevatedCardTokens {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ElevatedCardTokens f22520a = new ElevatedCardTokens();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f22521b = ColorSchemeKeyTokens.SurfaceContainerLow;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final float f22522c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final ShapeKeyTokens f22523d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f22524e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final float f22525f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final float f22526g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final float f22527h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final float f22528i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f22529j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final float f22530k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f22531l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final float f22532m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final float f22533n;

    static {
        ElevationTokens elevationTokens = ElevationTokens.f22534a;
        f22522c = elevationTokens.b();
        f22523d = ShapeKeyTokens.CornerMedium;
        f22524e = ColorSchemeKeyTokens.Surface;
        f22525f = elevationTokens.b();
        f22526g = 0.38f;
        f22527h = elevationTokens.e();
        f22528i = elevationTokens.b();
        f22529j = ColorSchemeKeyTokens.Secondary;
        f22530k = elevationTokens.c();
        f22531l = ColorSchemeKeyTokens.Primary;
        f22532m = Dp.g((float) 24.0d);
        f22533n = elevationTokens.b();
    }

    private ElevatedCardTokens() {
    }

    public final ColorSchemeKeyTokens a() {
        return f22521b;
    }

    public final float b() {
        return f22522c;
    }

    public final ShapeKeyTokens c() {
        return f22523d;
    }

    public final ColorSchemeKeyTokens d() {
        return f22524e;
    }

    public final float e() {
        return f22525f;
    }

    public final float f() {
        return f22526g;
    }

    public final float g() {
        return f22527h;
    }

    public final float h() {
        return f22528i;
    }

    public final float i() {
        return f22530k;
    }

    public final float j() {
        return f22533n;
    }
}
