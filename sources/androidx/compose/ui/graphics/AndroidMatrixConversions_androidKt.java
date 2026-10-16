package androidx.compose.ui.graphics;

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
public final class AndroidMatrixConversions_androidKt {
    public static final void a(android.graphics.Matrix matrix, float[] fArr) {
        float f3 = fArr[0];
        float f4 = fArr[1];
        float f5 = fArr[2];
        float f6 = fArr[3];
        float f7 = fArr[4];
        float f8 = fArr[5];
        float f9 = fArr[6];
        float f10 = fArr[7];
        float f11 = fArr[8];
        float f12 = fArr[12];
        float f13 = fArr[13];
        float f14 = fArr[15];
        fArr[0] = f3;
        fArr[1] = f7;
        fArr[2] = f12;
        fArr[3] = f4;
        fArr[4] = f8;
        fArr[5] = f13;
        fArr[6] = f6;
        fArr[7] = f10;
        fArr[8] = f14;
        matrix.setValues(fArr);
        fArr[0] = f3;
        fArr[1] = f4;
        fArr[2] = f5;
        fArr[3] = f6;
        fArr[4] = f7;
        fArr[5] = f8;
        fArr[6] = f9;
        fArr[7] = f10;
        fArr[8] = f11;
    }

    public static final void b(float[] fArr, android.graphics.Matrix matrix) {
        matrix.getValues(fArr);
        float f3 = fArr[0];
        float f4 = fArr[1];
        float f5 = fArr[2];
        float f6 = fArr[3];
        float f7 = fArr[4];
        float f8 = fArr[5];
        float f9 = fArr[6];
        float f10 = fArr[7];
        float f11 = fArr[8];
        fArr[0] = f3;
        fArr[1] = f6;
        fArr[2] = 0.0f;
        fArr[3] = f9;
        fArr[4] = f4;
        fArr[5] = f7;
        fArr[6] = 0.0f;
        fArr[7] = f10;
        fArr[8] = 0.0f;
        fArr[9] = 0.0f;
        fArr[10] = 1.0f;
        fArr[11] = 0.0f;
        fArr[12] = f5;
        fArr[13] = f8;
        fArr[14] = 0.0f;
        fArr[15] = f11;
    }
}
