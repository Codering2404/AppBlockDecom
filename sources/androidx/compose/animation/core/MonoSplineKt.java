package androidx.compose.animation.core;

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
public final class MonoSplineKt {
    public static final float a(float f3, float f4, float f5, float f6, float f7, float f8) {
        float f9 = f4 * f4;
        float f10 = 2;
        return (f3 * ((f7 - ((f10 * f4) * ((f10 * f7) + f8))) + ((3 * (f7 + f8)) * f9))) - ((6 * (f4 - f9)) * (f5 - f6));
    }

    public static final float b(float f3, float f4, float f5, float f6, float f7, float f8) {
        float f9 = f4 * f4;
        float f10 = f9 * f4;
        float f11 = 2;
        return ((((f7 * f3) * ((f4 - (f11 * f9)) + f10)) + ((f3 * f8) * (f10 - f9))) + f5) - (((3 * f9) - (f11 * f10)) * (f5 - f6));
    }
}
