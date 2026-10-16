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
public final class MenuTokens {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final MenuTokens f22937a = new MenuTokens();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f22938b = ColorSchemeKeyTokens.SurfaceContainer;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final float f22939c = ElevationTokens.f22534a.c();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final ShapeKeyTokens f22940d = ShapeKeyTokens.CornerExtraSmall;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f22941e = ColorSchemeKeyTokens.Secondary;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f22942f = ColorSchemeKeyTokens.SecondaryContainer;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f22943g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f22944h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f22945i;

    static {
        ColorSchemeKeyTokens colorSchemeKeyTokens = ColorSchemeKeyTokens.OnSecondaryContainer;
        f22943g = colorSchemeKeyTokens;
        f22944h = colorSchemeKeyTokens;
        f22945i = colorSchemeKeyTokens;
    }

    private MenuTokens() {
    }

    public final ColorSchemeKeyTokens a() {
        return f22938b;
    }

    public final float b() {
        return f22939c;
    }

    public final ShapeKeyTokens c() {
        return f22940d;
    }
}
