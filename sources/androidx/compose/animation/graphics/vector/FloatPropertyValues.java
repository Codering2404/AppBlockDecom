package androidx.compose.animation.graphics.vector;

import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TransitionKt;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.State;
import com.facebook.share.HKJ.pnxuebdT;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;

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
/* JADX INFO: loaded from: classes2.dex */
@Metadata
final class FloatPropertyValues extends PropertyValues<Float> {
    public FloatPropertyValues() {
        super(null);
    }

    @Override // androidx.compose.animation.graphics.vector.PropertyValues
    public State b(Transition transition, String str, int i3, Composer composer, int i4) {
        float fFloatValue;
        float fFloatValue2;
        composer.a0(2006928772);
        if (ComposerKt.M()) {
            ComposerKt.U(2006928772, i4, -1, "androidx.compose.animation.graphics.vector.FloatPropertyValues.createState (Animator.kt:172)");
        }
        Function3 function3A = a(i3);
        int i5 = ((i4 << 3) & 896) | (i4 & 14);
        TwoWayConverter twoWayConverterI = VectorConvertersKt.i(FloatCompanionObject.f140130a);
        int i6 = ((i5 << 3) & 7168) | (i5 & 14);
        boolean zBooleanValue = ((Boolean) transition.i()).booleanValue();
        composer.a0(-1743438372);
        boolean zM = ComposerKt.M();
        String str2 = pnxuebdT.zeWAfqHuyS;
        if (zM) {
            ComposerKt.U(-1743438372, 0, -1, str2);
        }
        if (zBooleanValue) {
            PropertyValuesHolder propertyValuesHolderC = ((Timestamp) CollectionsKt.last(c())).c();
            Intrinsics.checkNotNull(propertyValuesHolderC, "null cannot be cast to non-null type androidx.compose.animation.graphics.vector.PropertyValuesHolderFloat");
            fFloatValue = ((Number) ((Keyframe) CollectionsKt.last(((PropertyValuesHolderFloat) propertyValuesHolderC).c())).c()).floatValue();
        } else {
            PropertyValuesHolder propertyValuesHolderC2 = ((Timestamp) CollectionsKt.first(c())).c();
            Intrinsics.checkNotNull(propertyValuesHolderC2, "null cannot be cast to non-null type androidx.compose.animation.graphics.vector.PropertyValuesHolderFloat");
            fFloatValue = ((Number) ((Keyframe) CollectionsKt.first(((PropertyValuesHolderFloat) propertyValuesHolderC2).c())).c()).floatValue();
        }
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        Float fValueOf = Float.valueOf(fFloatValue);
        boolean zBooleanValue2 = ((Boolean) transition.q()).booleanValue();
        composer.a0(-1743438372);
        if (ComposerKt.M()) {
            ComposerKt.U(-1743438372, 0, -1, str2);
        }
        if (zBooleanValue2) {
            PropertyValuesHolder propertyValuesHolderC3 = ((Timestamp) CollectionsKt.last(c())).c();
            Intrinsics.checkNotNull(propertyValuesHolderC3, "null cannot be cast to non-null type androidx.compose.animation.graphics.vector.PropertyValuesHolderFloat");
            fFloatValue2 = ((Number) ((Keyframe) CollectionsKt.last(((PropertyValuesHolderFloat) propertyValuesHolderC3).c())).c()).floatValue();
        } else {
            PropertyValuesHolder propertyValuesHolderC4 = ((Timestamp) CollectionsKt.first(c())).c();
            Intrinsics.checkNotNull(propertyValuesHolderC4, "null cannot be cast to non-null type androidx.compose.animation.graphics.vector.PropertyValuesHolderFloat");
            fFloatValue2 = ((Number) ((Keyframe) CollectionsKt.first(((PropertyValuesHolderFloat) propertyValuesHolderC4).c())).c()).floatValue();
        }
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        State stateF = TransitionKt.f(transition, fValueOf, Float.valueOf(fFloatValue2), (FiniteAnimationSpec) function3A.invoke(transition.o(), composer, 0), twoWayConverterI, str, composer, (i6 & 14) | ((i6 << 6) & 458752));
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        return stateF;
    }
}
