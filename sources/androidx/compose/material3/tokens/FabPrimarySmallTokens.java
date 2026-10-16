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
public final class FabPrimarySmallTokens {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final FabPrimarySmallTokens f22581a = new FabPrimarySmallTokens();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f22582b = ColorSchemeKeyTokens.PrimaryContainer;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final float f22583c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final float f22584d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final ShapeKeyTokens f22585e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final float f22586f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final float f22587g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f22588h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final float f22589i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f22590j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f22591k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final float f22592l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final float f22593m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final float f22594n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final float f22595o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final float f22596p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final float f22597q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f22598r;

    static {
        ElevationTokens elevationTokens = ElevationTokens.f22534a;
        f22583c = elevationTokens.d();
        float f3 = (float) 40.0d;
        f22584d = Dp.g(f3);
        f22585e = ShapeKeyTokens.CornerMedium;
        f22586f = Dp.g(f3);
        f22587g = elevationTokens.d();
        ColorSchemeKeyTokens colorSchemeKeyTokens = ColorSchemeKeyTokens.OnPrimaryContainer;
        f22588h = colorSchemeKeyTokens;
        f22589i = elevationTokens.e();
        f22590j = colorSchemeKeyTokens;
        f22591k = colorSchemeKeyTokens;
        f22592l = Dp.g((float) 24.0d);
        f22593m = elevationTokens.b();
        f22594n = elevationTokens.b();
        f22595o = elevationTokens.c();
        f22596p = elevationTokens.b();
        f22597q = elevationTokens.d();
        f22598r = colorSchemeKeyTokens;
    }

    private FabPrimarySmallTokens() {
    }

    public final float a() {
        return f22584d;
    }

    public final ShapeKeyTokens b() {
        return f22585e;
    }

    public final float c() {
        return f22586f;
    }
}
