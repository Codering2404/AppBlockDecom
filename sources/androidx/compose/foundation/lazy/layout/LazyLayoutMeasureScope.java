package androidx.compose.foundation.lazy.layout;

import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpKt;
import androidx.compose.ui.unit.DpSize;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.compose.ui.unit.TextUnitType;
import java.util.List;
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
public interface LazyLayoutMeasureScope extends MeasureScope {
    @Override // androidx.compose.ui.unit.Density
    default float F(int i3) {
        return Dp.g(i3 / getDensity());
    }

    @Override // androidx.compose.ui.unit.Density
    default float G(float f3) {
        return Dp.g(f3 / getDensity());
    }

    @Override // androidx.compose.ui.unit.Density
    default long M(long j3) {
        if (j3 == 9205357640488583168L) {
            return Size.f25617b.a();
        }
        float fM1 = M1(DpSize.j(j3));
        return Size.d((((long) Float.floatToRawIntBits(M1(DpSize.i(j3)))) & 4294967295L) | (Float.floatToRawIntBits(fM1) << 32));
    }

    List m0(int i3, long j3);

    @Override // androidx.compose.ui.unit.FontScaling
    default long n(float f3) {
        return TextUnitKt.h(f3 / K1());
    }

    @Override // androidx.compose.ui.unit.Density
    default long o(long j3) {
        return j3 != 9205357640488583168L ? DpKt.b(G(Float.intBitsToFloat((int) (j3 >> 32))), G(Float.intBitsToFloat((int) (j3 & 4294967295L)))) : DpSize.f29984b.a();
    }

    @Override // androidx.compose.ui.unit.FontScaling
    default float q(long j3) {
        if (!TextUnitType.g(TextUnit.g(j3), TextUnitType.f30010b.b())) {
            InlineClassHelperKt.c("Only Sp can convert to Px");
        }
        return Dp.g(TextUnit.h(j3) * K1());
    }

    @Override // androidx.compose.ui.unit.Density
    default long v(float f3) {
        return TextUnitKt.h(f3 / (K1() * getDensity()));
    }
}
