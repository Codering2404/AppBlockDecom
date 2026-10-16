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
public final class FabPrimaryLargeTokens {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final FabPrimaryLargeTokens f22563a = new FabPrimaryLargeTokens();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f22564b = ColorSchemeKeyTokens.PrimaryContainer;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final float f22565c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final float f22566d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final ShapeKeyTokens f22567e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final float f22568f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final float f22569g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f22570h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final float f22571i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f22572j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f22573k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final float f22574l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final float f22575m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final float f22576n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final float f22577o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final float f22578p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final float f22579q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f22580r;

    static {
        ElevationTokens elevationTokens = ElevationTokens.f22534a;
        f22565c = elevationTokens.d();
        float f3 = (float) 96.0d;
        f22566d = Dp.g(f3);
        f22567e = ShapeKeyTokens.CornerExtraLarge;
        f22568f = Dp.g(f3);
        f22569g = elevationTokens.d();
        ColorSchemeKeyTokens colorSchemeKeyTokens = ColorSchemeKeyTokens.OnPrimaryContainer;
        f22570h = colorSchemeKeyTokens;
        f22571i = elevationTokens.e();
        f22572j = colorSchemeKeyTokens;
        f22573k = colorSchemeKeyTokens;
        f22574l = Dp.g((float) 36.0d);
        f22575m = elevationTokens.b();
        f22576n = elevationTokens.b();
        f22577o = elevationTokens.c();
        f22578p = elevationTokens.b();
        f22579q = elevationTokens.d();
        f22580r = colorSchemeKeyTokens;
    }

    private FabPrimaryLargeTokens() {
    }

    public final float a() {
        return f22566d;
    }

    public final ShapeKeyTokens b() {
        return f22567e;
    }

    public final float c() {
        return f22568f;
    }

    public final float d() {
        return f22574l;
    }
}
