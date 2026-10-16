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
public final class SnackbarTokens {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SnackbarTokens f23422a = new SnackbarTokens();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f23423b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f23424c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f23425d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final TypographyKeyTokens f23426e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f23427f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f23428g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final float f23429h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final ShapeKeyTokens f23430i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f23431j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f23432k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f23433l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f23434m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final float f23435n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f23436o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final TypographyKeyTokens f23437p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final float f23438q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final float f23439r;

    static {
        ColorSchemeKeyTokens colorSchemeKeyTokens = ColorSchemeKeyTokens.InversePrimary;
        f23423b = colorSchemeKeyTokens;
        f23424c = colorSchemeKeyTokens;
        f23425d = colorSchemeKeyTokens;
        f23426e = TypographyKeyTokens.LabelLarge;
        f23427f = colorSchemeKeyTokens;
        f23428g = ColorSchemeKeyTokens.InverseSurface;
        f23429h = ElevationTokens.f22534a.d();
        f23430i = ShapeKeyTokens.CornerExtraSmall;
        ColorSchemeKeyTokens colorSchemeKeyTokens2 = ColorSchemeKeyTokens.InverseOnSurface;
        f23431j = colorSchemeKeyTokens2;
        f23432k = colorSchemeKeyTokens2;
        f23433l = colorSchemeKeyTokens2;
        f23434m = colorSchemeKeyTokens2;
        f23435n = Dp.g((float) 24.0d);
        f23436o = colorSchemeKeyTokens2;
        f23437p = TypographyKeyTokens.BodyMedium;
        f23438q = Dp.g((float) 48.0d);
        f23439r = Dp.g((float) 68.0d);
    }

    private SnackbarTokens() {
    }

    public final ColorSchemeKeyTokens a() {
        return f23425d;
    }

    public final TypographyKeyTokens b() {
        return f23426e;
    }

    public final ColorSchemeKeyTokens c() {
        return f23428g;
    }

    public final float d() {
        return f23429h;
    }

    public final ShapeKeyTokens e() {
        return f23430i;
    }

    public final ColorSchemeKeyTokens f() {
        return f23431j;
    }

    public final float g() {
        return f23438q;
    }

    public final ColorSchemeKeyTokens h() {
        return f23436o;
    }

    public final TypographyKeyTokens i() {
        return f23437p;
    }

    public final float j() {
        return f23439r;
    }
}
