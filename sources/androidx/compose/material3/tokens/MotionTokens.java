package androidx.compose.material3.tokens;

import androidx.compose.animation.core.CubicBezierEasing;
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
public final class MotionTokens {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final MotionTokens f22946a = new MotionTokens();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final CubicBezierEasing f22947b = new CubicBezierEasing(0.2f, 0.0f, 0.0f, 1.0f);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final CubicBezierEasing f22948c = new CubicBezierEasing(0.3f, 0.0f, 0.8f, 0.15f);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final CubicBezierEasing f22949d = new CubicBezierEasing(0.05f, 0.7f, 0.1f, 1.0f);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final CubicBezierEasing f22950e = new CubicBezierEasing(0.4f, 0.0f, 0.2f, 1.0f);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final CubicBezierEasing f22951f = new CubicBezierEasing(0.4f, 0.0f, 1.0f, 1.0f);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final CubicBezierEasing f22952g = new CubicBezierEasing(0.0f, 0.0f, 0.2f, 1.0f);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final CubicBezierEasing f22953h = new CubicBezierEasing(0.0f, 0.0f, 1.0f, 1.0f);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final CubicBezierEasing f22954i = new CubicBezierEasing(0.2f, 0.0f, 0.0f, 1.0f);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final CubicBezierEasing f22955j = new CubicBezierEasing(0.3f, 0.0f, 1.0f, 1.0f);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final CubicBezierEasing f22956k = new CubicBezierEasing(0.0f, 0.0f, 0.0f, 1.0f);

    private MotionTokens() {
    }

    public final CubicBezierEasing a() {
        return f22947b;
    }

    public final CubicBezierEasing b() {
        return f22949d;
    }

    public final CubicBezierEasing c() {
        return f22953h;
    }
}
