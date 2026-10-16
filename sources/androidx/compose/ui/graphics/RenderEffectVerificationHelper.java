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
final class RenderEffectVerificationHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final RenderEffectVerificationHelper f25880a = new RenderEffectVerificationHelper();

    private RenderEffectVerificationHelper() {
    }

    public final android.graphics.RenderEffect a(RenderEffect renderEffect, float f3, float f4, int i3) {
        return (f3 == 0.0f && f4 == 0.0f) ? android.graphics.RenderEffect.createOffsetEffect(0.0f, 0.0f) : renderEffect == null ? android.graphics.RenderEffect.createBlurEffect(f3, f4, AndroidTileMode_androidKt.a(i3)) : android.graphics.RenderEffect.createBlurEffect(f3, f4, renderEffect.a(), AndroidTileMode_androidKt.a(i3));
    }

    public final android.graphics.RenderEffect b(RenderEffect renderEffect, long j3) {
        return renderEffect == null ? android.graphics.RenderEffect.createOffsetEffect(Float.intBitsToFloat((int) (j3 >> 32)), Float.intBitsToFloat((int) (j3 & 4294967295L))) : android.graphics.RenderEffect.createOffsetEffect(Float.intBitsToFloat((int) (j3 >> 32)), Float.intBitsToFloat((int) (j3 & 4294967295L)), renderEffect.a());
    }
}
