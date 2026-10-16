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
public final class IconButtonTokens {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final IconButtonTokens f22867a = new IconButtonTokens();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f22868b = ColorSchemeKeyTokens.OnSurface;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final float f22869c = Dp.g((float) 24.0d);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f22870d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f22871e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f22872f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f22873g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final ShapeKeyTokens f22874h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final float f22875i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f22876j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f22877k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f22878l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f22879m;

    static {
        ColorSchemeKeyTokens colorSchemeKeyTokens = ColorSchemeKeyTokens.Primary;
        f22870d = colorSchemeKeyTokens;
        f22871e = colorSchemeKeyTokens;
        f22872f = colorSchemeKeyTokens;
        f22873g = colorSchemeKeyTokens;
        f22874h = ShapeKeyTokens.CornerFull;
        f22875i = Dp.g((float) 40.0d);
        ColorSchemeKeyTokens colorSchemeKeyTokens2 = ColorSchemeKeyTokens.OnSurfaceVariant;
        f22876j = colorSchemeKeyTokens2;
        f22877k = colorSchemeKeyTokens2;
        f22878l = colorSchemeKeyTokens2;
        f22879m = colorSchemeKeyTokens2;
    }

    private IconButtonTokens() {
    }

    public final float a() {
        return f22869c;
    }

    public final ColorSchemeKeyTokens b() {
        return f22872f;
    }

    public final ShapeKeyTokens c() {
        return f22874h;
    }

    public final float d() {
        return f22875i;
    }
}
