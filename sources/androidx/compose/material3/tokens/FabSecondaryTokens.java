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
public final class FabSecondaryTokens {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final FabSecondaryTokens f22617a = new FabSecondaryTokens();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f22618b = ColorSchemeKeyTokens.SecondaryContainer;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final float f22619c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final float f22620d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final ShapeKeyTokens f22621e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final float f22622f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final float f22623g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f22624h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final float f22625i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f22626j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f22627k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final float f22628l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final float f22629m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final float f22630n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final float f22631o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final float f22632p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final float f22633q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f22634r;

    static {
        ElevationTokens elevationTokens = ElevationTokens.f22534a;
        f22619c = elevationTokens.d();
        float f3 = (float) 56.0d;
        f22620d = Dp.g(f3);
        f22621e = ShapeKeyTokens.CornerLarge;
        f22622f = Dp.g(f3);
        f22623g = elevationTokens.d();
        ColorSchemeKeyTokens colorSchemeKeyTokens = ColorSchemeKeyTokens.OnSecondaryContainer;
        f22624h = colorSchemeKeyTokens;
        f22625i = elevationTokens.e();
        f22626j = colorSchemeKeyTokens;
        f22627k = colorSchemeKeyTokens;
        f22628l = Dp.g((float) 24.0d);
        f22629m = elevationTokens.b();
        f22630n = elevationTokens.b();
        f22631o = elevationTokens.c();
        f22632p = elevationTokens.b();
        f22633q = elevationTokens.d();
        f22634r = colorSchemeKeyTokens;
    }

    private FabSecondaryTokens() {
    }
}
