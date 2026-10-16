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
public final class OutlinedButtonTokens {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final OutlinedButtonTokens f23074a = new OutlinedButtonTokens();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final float f23075b = Dp.g((float) 40.0d);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final ShapeKeyTokens f23076c = ShapeKeyTokens.CornerFull;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f23077d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f23078e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f23079f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f23080g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f23081h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f23082i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f23083j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final TypographyKeyTokens f23084k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f23085l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final float f23086m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f23087n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f23088o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f23089p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f23090q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f23091r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f23092s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private static final float f23093t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f23094u;

    static {
        ColorSchemeKeyTokens colorSchemeKeyTokens = ColorSchemeKeyTokens.OnSurface;
        f23077d = colorSchemeKeyTokens;
        f23078e = colorSchemeKeyTokens;
        ColorSchemeKeyTokens colorSchemeKeyTokens2 = ColorSchemeKeyTokens.Primary;
        f23079f = colorSchemeKeyTokens2;
        f23080g = colorSchemeKeyTokens2;
        f23081h = colorSchemeKeyTokens2;
        ColorSchemeKeyTokens colorSchemeKeyTokens3 = ColorSchemeKeyTokens.Outline;
        f23082i = colorSchemeKeyTokens3;
        f23083j = colorSchemeKeyTokens2;
        f23084k = TypographyKeyTokens.LabelLarge;
        f23085l = colorSchemeKeyTokens3;
        f23086m = Dp.g((float) 1.0d);
        f23087n = colorSchemeKeyTokens2;
        f23088o = colorSchemeKeyTokens3;
        f23089p = colorSchemeKeyTokens;
        f23090q = colorSchemeKeyTokens2;
        f23091r = colorSchemeKeyTokens2;
        f23092s = colorSchemeKeyTokens2;
        f23093t = Dp.g((float) 18.0d);
        f23094u = colorSchemeKeyTokens2;
    }

    private OutlinedButtonTokens() {
    }

    public final ShapeKeyTokens a() {
        return f23076c;
    }

    public final ColorSchemeKeyTokens b() {
        return f23077d;
    }

    public final ColorSchemeKeyTokens c() {
        return f23083j;
    }

    public final ColorSchemeKeyTokens d() {
        return f23085l;
    }

    public final float e() {
        return f23086m;
    }
}
