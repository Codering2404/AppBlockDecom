package androidx.compose.ui.unit;

import androidx.compose.ui.unit.fontscaling.FontScaleConverter;
import androidx.compose.ui.unit.fontscaling.FontScaleConverterFactory;
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
public interface FontScaling {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class DefaultImpls {
    }

    float K1();

    default long n(float f3) {
        FontScaleConverterFactory fontScaleConverterFactory = FontScaleConverterFactory.f30018a;
        if (!fontScaleConverterFactory.f(K1())) {
            return TextUnitKt.h(f3 / K1());
        }
        FontScaleConverter fontScaleConverterB = fontScaleConverterFactory.b(K1());
        return TextUnitKt.h(fontScaleConverterB != null ? fontScaleConverterB.a(f3) : f3 / K1());
    }

    default float q(long j3) {
        if (!TextUnitType.g(TextUnit.g(j3), TextUnitType.f30010b.b())) {
            InlineClassHelperKt.b("Only Sp can convert to Px");
        }
        FontScaleConverterFactory fontScaleConverterFactory = FontScaleConverterFactory.f30018a;
        if (!fontScaleConverterFactory.f(K1())) {
            return Dp.g(TextUnit.h(j3) * K1());
        }
        FontScaleConverter fontScaleConverterB = fontScaleConverterFactory.b(K1());
        float fH = TextUnit.h(j3);
        return fontScaleConverterB == null ? Dp.g(fH * K1()) : Dp.g(fontScaleConverterB.b(fH));
    }
}
