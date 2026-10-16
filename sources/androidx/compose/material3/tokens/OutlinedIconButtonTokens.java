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
public final class OutlinedIconButtonTokens {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final OutlinedIconButtonTokens f23113a = new OutlinedIconButtonTokens();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ShapeKeyTokens f23114b = ShapeKeyTokens.CornerFull;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final float f23115c = Dp.g((float) 40.0d);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f23116d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f23117e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f23118f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final float f23119g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f23120h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f23121i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f23122j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f23123k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f23124l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f23125m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f23126n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f23127o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f23128p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final float f23129q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f23130r;

    static {
        ColorSchemeKeyTokens colorSchemeKeyTokens = ColorSchemeKeyTokens.OnSurface;
        f23116d = colorSchemeKeyTokens;
        f23117e = colorSchemeKeyTokens;
        f23118f = colorSchemeKeyTokens;
        f23119g = Dp.g((float) 24.0d);
        f23120h = ColorSchemeKeyTokens.InverseSurface;
        ColorSchemeKeyTokens colorSchemeKeyTokens2 = ColorSchemeKeyTokens.InverseOnSurface;
        f23121i = colorSchemeKeyTokens2;
        f23122j = colorSchemeKeyTokens2;
        f23123k = colorSchemeKeyTokens2;
        f23124l = colorSchemeKeyTokens2;
        ColorSchemeKeyTokens colorSchemeKeyTokens3 = ColorSchemeKeyTokens.OnSurfaceVariant;
        f23125m = colorSchemeKeyTokens3;
        f23126n = colorSchemeKeyTokens3;
        f23127o = colorSchemeKeyTokens3;
        f23128p = ColorSchemeKeyTokens.Outline;
        f23129q = Dp.g((float) 1.0d);
        f23130r = colorSchemeKeyTokens;
    }

    private OutlinedIconButtonTokens() {
    }

    public final ShapeKeyTokens a() {
        return f23114b;
    }

    public final float b() {
        return f23115c;
    }

    public final ColorSchemeKeyTokens c() {
        return f23120h;
    }

    public final float d() {
        return f23129q;
    }
}
