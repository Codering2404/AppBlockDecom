package androidx.compose.ui.unit;

import androidx.compose.ui.geometry.Size;
import com.google.android.gms.common.api.Api;
import kotlin.Metadata;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public interface Density extends FontScaling {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class DefaultImpls {
    }

    default float F(int i3) {
        return Dp.g(i3 / getDensity());
    }

    default float G(float f3) {
        return Dp.g(f3 / getDensity());
    }

    default float J0(long j3) {
        if (!TextUnitType.g(TextUnit.g(j3), TextUnitType.f30010b.b())) {
            InlineClassHelperKt.b("Only Sp can convert to Px");
        }
        return M1(q(j3));
    }

    default long M(long j3) {
        if (j3 == 9205357640488583168L) {
            return Size.f25617b.a();
        }
        float fM1 = M1(DpSize.j(j3));
        return Size.d((((long) Float.floatToRawIntBits(M1(DpSize.i(j3)))) & 4294967295L) | (Float.floatToRawIntBits(fM1) << 32));
    }

    default float M1(float f3) {
        return f3 * getDensity();
    }

    default int T1(long j3) {
        return Math.round(J0(j3));
    }

    float getDensity();

    default long o(long j3) {
        return j3 != 9205357640488583168L ? DpKt.b(G(Float.intBitsToFloat((int) (j3 >> 32))), G(Float.intBitsToFloat((int) (j3 & 4294967295L)))) : DpSize.f29984b.a();
    }

    default long v(float f3) {
        return n(G(f3));
    }

    default int z0(float f3) {
        float fM1 = M1(f3);
        return Float.isInfinite(fM1) ? Api.BaseClientBuilder.API_PRIORITY_OTHER : Math.round(fM1);
    }
}
