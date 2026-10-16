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
public final class SearchBarTokens {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SearchBarTokens f23313a = new SearchBarTokens();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ShapeKeyTokens f23314b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final float f23315c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f23316d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final float f23317e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final float f23318f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final ShapeKeyTokens f23319g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f23320h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f23321i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f23322j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final TypographyKeyTokens f23323k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f23324l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f23325m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f23326n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final TypographyKeyTokens f23327o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f23328p;

    static {
        ShapeKeyTokens shapeKeyTokens = ShapeKeyTokens.CornerFull;
        f23314b = shapeKeyTokens;
        f23315c = Dp.g((float) 30.0d);
        f23316d = ColorSchemeKeyTokens.SurfaceContainerHigh;
        f23317e = ElevationTokens.f22534a.d();
        f23318f = Dp.g((float) 56.0d);
        f23319g = shapeKeyTokens;
        f23320h = ColorSchemeKeyTokens.Secondary;
        ColorSchemeKeyTokens colorSchemeKeyTokens = ColorSchemeKeyTokens.OnSurfaceVariant;
        f23321i = colorSchemeKeyTokens;
        ColorSchemeKeyTokens colorSchemeKeyTokens2 = ColorSchemeKeyTokens.OnSurface;
        f23322j = colorSchemeKeyTokens2;
        TypographyKeyTokens typographyKeyTokens = TypographyKeyTokens.BodyLarge;
        f23323k = typographyKeyTokens;
        f23324l = colorSchemeKeyTokens2;
        f23325m = colorSchemeKeyTokens;
        f23326n = colorSchemeKeyTokens;
        f23327o = typographyKeyTokens;
        f23328p = colorSchemeKeyTokens;
    }

    private SearchBarTokens() {
    }

    public final ColorSchemeKeyTokens a() {
        return f23316d;
    }

    public final float b() {
        return f23318f;
    }

    public final ShapeKeyTokens c() {
        return f23319g;
    }

    public final ColorSchemeKeyTokens d() {
        return f23322j;
    }

    public final ColorSchemeKeyTokens e() {
        return f23324l;
    }

    public final ColorSchemeKeyTokens f() {
        return f23326n;
    }

    public final ColorSchemeKeyTokens g() {
        return f23328p;
    }
}
