package androidx.compose.material3.tokens;

import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.Shape;
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
public final class ShapeTokens {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final RoundedCornerShape f23375b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final RoundedCornerShape f23376c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final RoundedCornerShape f23377d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final RoundedCornerShape f23378e;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final RoundedCornerShape f23380g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final RoundedCornerShape f23381h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final RoundedCornerShape f23382i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ShapeTokens f23374a = new ShapeTokens();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final RoundedCornerShape f23379f = RoundedCornerShapeKt.g();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final RoundedCornerShape f23383j = RoundedCornerShapeKt.d(Dp.g((float) 12.0d));

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final Shape f23384k = RectangleShapeKt.a();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final RoundedCornerShape f23385l = RoundedCornerShapeKt.d(Dp.g((float) 8.0d));

    static {
        float f3 = (float) 28.0d;
        f23375b = RoundedCornerShapeKt.d(Dp.g(f3));
        float f4 = (float) 0.0d;
        f23376c = RoundedCornerShapeKt.e(Dp.g(f3), Dp.g(f3), Dp.g(f4), Dp.g(f4));
        float f5 = (float) 4.0d;
        f23377d = RoundedCornerShapeKt.d(Dp.g(f5));
        f23378e = RoundedCornerShapeKt.e(Dp.g(f5), Dp.g(f5), Dp.g(f4), Dp.g(f4));
        float f6 = (float) 16.0d;
        f23380g = RoundedCornerShapeKt.d(Dp.g(f6));
        f23381h = RoundedCornerShapeKt.e(Dp.g(f4), Dp.g(f6), Dp.g(f6), Dp.g(f4));
        f23382i = RoundedCornerShapeKt.e(Dp.g(f6), Dp.g(f6), Dp.g(f4), Dp.g(f4));
    }

    private ShapeTokens() {
    }

    public final RoundedCornerShape a() {
        return f23375b;
    }

    public final RoundedCornerShape b() {
        return f23377d;
    }

    public final RoundedCornerShape c() {
        return f23380g;
    }

    public final RoundedCornerShape d() {
        return f23383j;
    }

    public final RoundedCornerShape e() {
        return f23385l;
    }
}
