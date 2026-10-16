package androidx.compose.material3.tokens;

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
public final class RichTooltipTokens {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final RichTooltipTokens f23298a = new RichTooltipTokens();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f23299b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f23300c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f23301d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final TypographyKeyTokens f23302e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f23303f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f23304g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final float f23305h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final ShapeKeyTokens f23306i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f23307j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final TypographyKeyTokens f23308k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f23309l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final TypographyKeyTokens f23310m;

    static {
        ColorSchemeKeyTokens colorSchemeKeyTokens = ColorSchemeKeyTokens.Primary;
        f23299b = colorSchemeKeyTokens;
        f23300c = colorSchemeKeyTokens;
        f23301d = colorSchemeKeyTokens;
        f23302e = TypographyKeyTokens.LabelLarge;
        f23303f = colorSchemeKeyTokens;
        f23304g = ColorSchemeKeyTokens.SurfaceContainer;
        f23305h = ElevationTokens.f22534a.c();
        f23306i = ShapeKeyTokens.CornerMedium;
        ColorSchemeKeyTokens colorSchemeKeyTokens2 = ColorSchemeKeyTokens.OnSurfaceVariant;
        f23307j = colorSchemeKeyTokens2;
        f23308k = TypographyKeyTokens.TitleSmall;
        f23309l = colorSchemeKeyTokens2;
        f23310m = TypographyKeyTokens.BodyMedium;
    }

    private RichTooltipTokens() {
    }

    public final ColorSchemeKeyTokens a() {
        return f23301d;
    }

    public final TypographyKeyTokens b() {
        return f23302e;
    }

    public final ColorSchemeKeyTokens c() {
        return f23304g;
    }

    public final float d() {
        return f23305h;
    }

    public final ShapeKeyTokens e() {
        return f23306i;
    }

    public final ColorSchemeKeyTokens f() {
        return f23307j;
    }

    public final TypographyKeyTokens g() {
        return f23308k;
    }

    public final ColorSchemeKeyTokens h() {
        return f23309l;
    }

    public final TypographyKeyTokens i() {
        return f23310m;
    }
}
