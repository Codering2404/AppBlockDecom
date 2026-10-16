package androidx.compose.foundation.gestures;

import androidx.compose.animation.core.AnimationVector4D;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.ui.geometry.Offset;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

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
final class AnimationDataConverter implements TwoWayConverter<AnimationData, AnimationVector4D> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AnimationDataConverter f5539a = new AnimationDataConverter();

    private AnimationDataConverter() {
    }

    @Override // androidx.compose.animation.core.TwoWayConverter
    public Function1 a() {
        return new Function1<AnimationData, AnimationVector4D>() { // from class: androidx.compose.foundation.gestures.AnimationDataConverter$convertToVector$1
            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final AnimationVector4D invoke(AnimationData animationData) {
                return new AnimationVector4D(animationData.c(), Float.intBitsToFloat((int) (animationData.b() >> 32)), Float.intBitsToFloat((int) (animationData.b() & 4294967295L)), animationData.a());
            }
        };
    }

    @Override // androidx.compose.animation.core.TwoWayConverter
    public Function1 b() {
        return new Function1<AnimationVector4D, AnimationData>() { // from class: androidx.compose.foundation.gestures.AnimationDataConverter$convertFromVector$1
            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final AnimationData invoke(AnimationVector4D animationVector4D) {
                float f3 = animationVector4D.f();
                float fG = animationVector4D.g();
                return new AnimationData(f3, Offset.e((((long) Float.floatToRawIntBits(animationVector4D.h())) & 4294967295L) | (Float.floatToRawIntBits(fG) << 32)), animationVector4D.i(), null);
            }
        };
    }
}
