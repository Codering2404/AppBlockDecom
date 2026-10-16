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
public final class FilledButtonTokens {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final FilledButtonTokens f22676a = new FilledButtonTokens();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f22677b = ColorSchemeKeyTokens.Primary;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final float f22678c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final float f22679d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final ShapeKeyTokens f22680e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f22681f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final float f22682g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f22683h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final float f22684i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f22685j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final float f22686k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f22687l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f22688m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final TypographyKeyTokens f22689n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final float f22690o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f22691p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f22692q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f22693r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f22694s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f22695t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static final float f22696u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f22697v;

    static {
        ElevationTokens elevationTokens = ElevationTokens.f22534a;
        f22678c = elevationTokens.a();
        f22679d = Dp.g((float) 40.0d);
        f22680e = ShapeKeyTokens.CornerFull;
        ColorSchemeKeyTokens colorSchemeKeyTokens = ColorSchemeKeyTokens.OnSurface;
        f22681f = colorSchemeKeyTokens;
        f22682g = elevationTokens.a();
        f22683h = colorSchemeKeyTokens;
        f22684i = elevationTokens.a();
        ColorSchemeKeyTokens colorSchemeKeyTokens2 = ColorSchemeKeyTokens.OnPrimary;
        f22685j = colorSchemeKeyTokens2;
        f22686k = elevationTokens.b();
        f22687l = colorSchemeKeyTokens2;
        f22688m = colorSchemeKeyTokens2;
        f22689n = TypographyKeyTokens.LabelLarge;
        f22690o = elevationTokens.a();
        f22691p = colorSchemeKeyTokens2;
        f22692q = colorSchemeKeyTokens;
        f22693r = colorSchemeKeyTokens2;
        f22694s = colorSchemeKeyTokens2;
        f22695t = colorSchemeKeyTokens2;
        f22696u = Dp.g((float) 18.0d);
        f22697v = colorSchemeKeyTokens2;
    }

    private FilledButtonTokens() {
    }

    public final ColorSchemeKeyTokens a() {
        return f22677b;
    }

    public final float b() {
        return f22678c;
    }

    public final ShapeKeyTokens c() {
        return f22680e;
    }

    public final ColorSchemeKeyTokens d() {
        return f22681f;
    }

    public final float e() {
        return f22682g;
    }

    public final ColorSchemeKeyTokens f() {
        return f22683h;
    }

    public final float g() {
        return f22684i;
    }

    public final float h() {
        return f22686k;
    }

    public final float i() {
        return f22696u;
    }

    public final ColorSchemeKeyTokens j() {
        return f22688m;
    }

    public final float k() {
        return f22690o;
    }
}
