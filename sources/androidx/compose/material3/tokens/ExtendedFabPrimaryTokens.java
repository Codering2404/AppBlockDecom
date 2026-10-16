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
public final class ExtendedFabPrimaryTokens {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ExtendedFabPrimaryTokens f22541a = new ExtendedFabPrimaryTokens();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f22542b = ColorSchemeKeyTokens.PrimaryContainer;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final float f22543c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final float f22544d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final ShapeKeyTokens f22545e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final float f22546f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f22547g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f22548h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final float f22549i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f22550j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f22551k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f22552l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final float f22553m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f22554n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final TypographyKeyTokens f22555o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final float f22556p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final float f22557q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final float f22558r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static final float f22559s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private static final float f22560t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f22561u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f22562v;

    static {
        ElevationTokens elevationTokens = ElevationTokens.f22534a;
        f22543c = elevationTokens.d();
        f22544d = Dp.g((float) 56.0d);
        f22545e = ShapeKeyTokens.CornerLarge;
        f22546f = elevationTokens.d();
        ColorSchemeKeyTokens colorSchemeKeyTokens = ColorSchemeKeyTokens.OnPrimaryContainer;
        f22547g = colorSchemeKeyTokens;
        f22548h = colorSchemeKeyTokens;
        f22549i = elevationTokens.e();
        f22550j = colorSchemeKeyTokens;
        f22551k = colorSchemeKeyTokens;
        f22552l = colorSchemeKeyTokens;
        f22553m = Dp.g((float) 24.0d);
        f22554n = colorSchemeKeyTokens;
        f22555o = TypographyKeyTokens.LabelLarge;
        f22556p = elevationTokens.b();
        f22557q = elevationTokens.b();
        f22558r = elevationTokens.c();
        f22559s = elevationTokens.b();
        f22560t = elevationTokens.d();
        f22561u = colorSchemeKeyTokens;
        f22562v = colorSchemeKeyTokens;
    }

    private ExtendedFabPrimaryTokens() {
    }

    public final ShapeKeyTokens a() {
        return f22545e;
    }

    public final TypographyKeyTokens b() {
        return f22555o;
    }
}
