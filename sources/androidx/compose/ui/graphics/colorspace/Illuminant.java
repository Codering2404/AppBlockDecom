package androidx.compose.ui.graphics.colorspace;

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
public final class Illuminant {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Illuminant f26016a = new Illuminant();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final WhitePoint f26017b = new WhitePoint(0.44757f, 0.40745f);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final WhitePoint f26018c = new WhitePoint(0.34842f, 0.35161f);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final WhitePoint f26019d = new WhitePoint(0.31006f, 0.31616f);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final WhitePoint f26020e = new WhitePoint(0.34567f, 0.3585f);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final WhitePoint f26021f = new WhitePoint(0.33242f, 0.34743f);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final WhitePoint f26022g = new WhitePoint(0.32168f, 0.33767f);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final WhitePoint f26023h = new WhitePoint(0.31271f, 0.32902f);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final WhitePoint f26024i = new WhitePoint(0.29902f, 0.31485f);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final WhitePoint f26025j = new WhitePoint(0.33333f, 0.33333f);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final float[] f26026k = {0.964212f, 1.0f, 0.825188f};

    private Illuminant() {
    }

    public final WhitePoint a() {
        return f26019d;
    }

    public final WhitePoint b() {
        return f26020e;
    }

    public final float[] c() {
        return f26026k;
    }

    public final WhitePoint d() {
        return f26022g;
    }

    public final WhitePoint e() {
        return f26023h;
    }

    public final float[] f() {
        return new float[]{0.964212f, 1.0f, 0.825188f};
    }
}
