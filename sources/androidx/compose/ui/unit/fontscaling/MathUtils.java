package androidx.compose.ui.unit.fontscaling;

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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class MathUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final MathUtils f30027a = new MathUtils();

    private MathUtils() {
    }

    public final float a(float f3, float f4, float f5, float f6, float f7) {
        return b(f3, f4, Math.max(0.0f, Math.min(1.0f, c(f5, f6, f7))));
    }

    public final float b(float f3, float f4, float f5) {
        return f3 + ((f4 - f3) * f5);
    }

    public final float c(float f3, float f4, float f5) {
        if (f3 == f4) {
            return 0.0f;
        }
        return (f5 - f3) / (f4 - f3);
    }
}
