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
public final class DialogTokens {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DialogTokens f22476a = new DialogTokens();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f22477b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f22478c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f22479d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final TypographyKeyTokens f22480e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f22481f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f22482g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final float f22483h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final ShapeKeyTokens f22484i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f22485j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final TypographyKeyTokens f22486k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f22487l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final TypographyKeyTokens f22488m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f22489n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final float f22490o;

    static {
        ColorSchemeKeyTokens colorSchemeKeyTokens = ColorSchemeKeyTokens.Primary;
        f22477b = colorSchemeKeyTokens;
        f22478c = colorSchemeKeyTokens;
        f22479d = colorSchemeKeyTokens;
        f22480e = TypographyKeyTokens.LabelLarge;
        f22481f = colorSchemeKeyTokens;
        f22482g = ColorSchemeKeyTokens.SurfaceContainerHigh;
        f22483h = ElevationTokens.f22534a.d();
        f22484i = ShapeKeyTokens.CornerExtraLarge;
        f22485j = ColorSchemeKeyTokens.OnSurface;
        f22486k = TypographyKeyTokens.HeadlineSmall;
        f22487l = ColorSchemeKeyTokens.OnSurfaceVariant;
        f22488m = TypographyKeyTokens.BodyMedium;
        f22489n = ColorSchemeKeyTokens.Secondary;
        f22490o = Dp.g((float) 24.0d);
    }

    private DialogTokens() {
    }

    public final ColorSchemeKeyTokens a() {
        return f22479d;
    }

    public final TypographyKeyTokens b() {
        return f22480e;
    }

    public final ColorSchemeKeyTokens c() {
        return f22482g;
    }

    public final ShapeKeyTokens d() {
        return f22484i;
    }

    public final ColorSchemeKeyTokens e() {
        return f22485j;
    }

    public final TypographyKeyTokens f() {
        return f22486k;
    }

    public final ColorSchemeKeyTokens g() {
        return f22489n;
    }

    public final ColorSchemeKeyTokens h() {
        return f22487l;
    }

    public final TypographyKeyTokens i() {
        return f22488m;
    }
}
