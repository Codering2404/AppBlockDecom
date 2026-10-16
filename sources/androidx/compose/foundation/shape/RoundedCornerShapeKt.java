package androidx.compose.foundation.shape;

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
public final class RoundedCornerShapeKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final RoundedCornerShape f9029a = a(50);

    public static final RoundedCornerShape a(int i3) {
        return c(CornerSizeKt.b(i3));
    }

    public static final RoundedCornerShape b(int i3, int i4, int i5, int i6) {
        return new RoundedCornerShape(CornerSizeKt.b(i3), CornerSizeKt.b(i4), CornerSizeKt.b(i5), CornerSizeKt.b(i6));
    }

    public static final RoundedCornerShape c(CornerSize cornerSize) {
        return new RoundedCornerShape(cornerSize, cornerSize, cornerSize, cornerSize);
    }

    public static final RoundedCornerShape d(float f3) {
        return c(CornerSizeKt.c(f3));
    }

    public static final RoundedCornerShape e(float f3, float f4, float f5, float f6) {
        return new RoundedCornerShape(CornerSizeKt.c(f3), CornerSizeKt.c(f4), CornerSizeKt.c(f5), CornerSizeKt.c(f6));
    }

    public static /* synthetic */ RoundedCornerShape f(float f3, float f4, float f5, float f6, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            f3 = Dp.g(0);
        }
        if ((i3 & 2) != 0) {
            f4 = Dp.g(0);
        }
        if ((i3 & 4) != 0) {
            f5 = Dp.g(0);
        }
        if ((i3 & 8) != 0) {
            f6 = Dp.g(0);
        }
        return e(f3, f4, f5, f6);
    }

    public static final RoundedCornerShape g() {
        return f9029a;
    }
}
