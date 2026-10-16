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
public final class FabPrimaryTokens {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final FabPrimaryTokens f22599a = new FabPrimaryTokens();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f22600b = ColorSchemeKeyTokens.PrimaryContainer;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final float f22601c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final float f22602d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final ShapeKeyTokens f22603e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final float f22604f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final float f22605g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f22606h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final float f22607i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f22608j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f22609k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final float f22610l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final float f22611m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final float f22612n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final float f22613o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final float f22614p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final float f22615q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f22616r;

    static {
        ElevationTokens elevationTokens = ElevationTokens.f22534a;
        f22601c = elevationTokens.d();
        float f3 = (float) 56.0d;
        f22602d = Dp.g(f3);
        f22603e = ShapeKeyTokens.CornerLarge;
        f22604f = Dp.g(f3);
        f22605g = elevationTokens.d();
        ColorSchemeKeyTokens colorSchemeKeyTokens = ColorSchemeKeyTokens.OnPrimaryContainer;
        f22606h = colorSchemeKeyTokens;
        f22607i = elevationTokens.e();
        f22608j = colorSchemeKeyTokens;
        f22609k = colorSchemeKeyTokens;
        f22610l = Dp.g((float) 24.0d);
        f22611m = elevationTokens.b();
        f22612n = elevationTokens.b();
        f22613o = elevationTokens.c();
        f22614p = elevationTokens.b();
        f22615q = elevationTokens.d();
        f22616r = colorSchemeKeyTokens;
    }

    private FabPrimaryTokens() {
    }

    public final ColorSchemeKeyTokens a() {
        return f22600b;
    }

    public final float b() {
        return f22601c;
    }

    public final float c() {
        return f22602d;
    }

    public final ShapeKeyTokens d() {
        return f22603e;
    }

    public final float e() {
        return f22604f;
    }

    public final float f() {
        return f22605g;
    }

    public final float g() {
        return f22607i;
    }

    public final float h() {
        return f22615q;
    }
}
