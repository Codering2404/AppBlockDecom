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
public final class FilledCardTokens {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final FilledCardTokens f22698a = new FilledCardTokens();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f22699b = ColorSchemeKeyTokens.SurfaceContainerHighest;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final float f22700c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final ShapeKeyTokens f22701d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f22702e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final float f22703f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final float f22704g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final float f22705h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final float f22706i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f22707j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final float f22708k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f22709l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final float f22710m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final float f22711n;

    static {
        ElevationTokens elevationTokens = ElevationTokens.f22534a;
        f22700c = elevationTokens.a();
        f22701d = ShapeKeyTokens.CornerMedium;
        f22702e = ColorSchemeKeyTokens.SurfaceVariant;
        f22703f = elevationTokens.a();
        f22704g = 0.38f;
        f22705h = elevationTokens.d();
        f22706i = elevationTokens.a();
        f22707j = ColorSchemeKeyTokens.Secondary;
        f22708k = elevationTokens.b();
        f22709l = ColorSchemeKeyTokens.Primary;
        f22710m = Dp.g((float) 24.0d);
        f22711n = elevationTokens.a();
    }

    private FilledCardTokens() {
    }

    public final ColorSchemeKeyTokens a() {
        return f22699b;
    }

    public final float b() {
        return f22700c;
    }

    public final ShapeKeyTokens c() {
        return f22701d;
    }

    public final ColorSchemeKeyTokens d() {
        return f22702e;
    }

    public final float e() {
        return f22703f;
    }

    public final float f() {
        return f22704g;
    }

    public final float g() {
        return f22705h;
    }

    public final float h() {
        return f22706i;
    }

    public final float i() {
        return f22708k;
    }

    public final float j() {
        return f22711n;
    }
}
