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
public final class OutlinedCardTokens {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final OutlinedCardTokens f23095a = new OutlinedCardTokens();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f23096b = ColorSchemeKeyTokens.Surface;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final float f23097c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final ShapeKeyTokens f23098d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final float f23099e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f23100f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final float f23101g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f23102h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final float f23103i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f23104j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final float f23105k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f23106l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f23107m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final float f23108n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f23109o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final float f23110p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final float f23111q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f23112r;

    static {
        ElevationTokens elevationTokens = ElevationTokens.f22534a;
        f23097c = elevationTokens.a();
        f23098d = ShapeKeyTokens.CornerMedium;
        f23099e = elevationTokens.a();
        f23100f = ColorSchemeKeyTokens.Outline;
        f23101g = elevationTokens.d();
        ColorSchemeKeyTokens colorSchemeKeyTokens = ColorSchemeKeyTokens.OutlineVariant;
        f23102h = colorSchemeKeyTokens;
        f23103i = elevationTokens.a();
        f23104j = ColorSchemeKeyTokens.OnSurface;
        f23105k = elevationTokens.b();
        f23106l = colorSchemeKeyTokens;
        f23107m = ColorSchemeKeyTokens.Primary;
        f23108n = Dp.g((float) 24.0d);
        f23109o = colorSchemeKeyTokens;
        f23110p = Dp.g((float) 1.0d);
        f23111q = elevationTokens.a();
        f23112r = colorSchemeKeyTokens;
    }

    private OutlinedCardTokens() {
    }

    public final ColorSchemeKeyTokens a() {
        return f23096b;
    }

    public final float b() {
        return f23097c;
    }

    public final ShapeKeyTokens c() {
        return f23098d;
    }

    public final float d() {
        return f23099e;
    }

    public final ColorSchemeKeyTokens e() {
        return f23100f;
    }

    public final float f() {
        return f23101g;
    }

    public final ColorSchemeKeyTokens g() {
        return f23109o;
    }

    public final float h() {
        return f23110p;
    }
}
