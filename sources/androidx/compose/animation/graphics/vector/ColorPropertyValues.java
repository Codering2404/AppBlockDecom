package androidx.compose.animation.graphics.vector;

import androidx.compose.animation.ColorVectorConverterKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TransitionKt;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.colorspace.ColorSpace;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function3;
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
/* JADX INFO: loaded from: classes.dex */
@Metadata
final class ColorPropertyValues extends PropertyValues<Color> {
    public ColorPropertyValues() {
        super(null);
    }

    @Override // androidx.compose.animation.graphics.vector.PropertyValues
    public State b(Transition transition, String str, int i3, Composer composer, int i4) {
        long jB;
        long jB2;
        long jB3;
        composer.a0(-2133734837);
        if (ComposerKt.M()) {
            ComposerKt.U(-2133734837, i4, -1, "androidx.compose.animation.graphics.vector.ColorPropertyValues.createState (Animator.kt:200)");
        }
        Function3 function3A = a(i3);
        int i5 = ((i4 << 3) & 896) | (i4 & 14);
        boolean zBooleanValue = ((Boolean) transition.q()).booleanValue();
        composer.a0(1880460593);
        if (ComposerKt.M()) {
            ComposerKt.U(1880460593, 0, -1, "androidx.compose.animation.graphics.vector.ColorPropertyValues.createState.<anonymous> (Animator.kt:205)");
        }
        if (zBooleanValue) {
            PropertyValuesHolder propertyValuesHolderC = ((Timestamp) CollectionsKt.last(c())).c();
            Intrinsics.checkNotNull(propertyValuesHolderC, "null cannot be cast to non-null type androidx.compose.animation.graphics.vector.PropertyValuesHolderColor");
            jB = ((Color) ((Keyframe) CollectionsKt.last(((PropertyValuesHolderColor) propertyValuesHolderC).c())).c()).B();
        } else {
            PropertyValuesHolder propertyValuesHolderC2 = ((Timestamp) CollectionsKt.first(c())).c();
            Intrinsics.checkNotNull(propertyValuesHolderC2, "null cannot be cast to non-null type androidx.compose.animation.graphics.vector.PropertyValuesHolderColor");
            jB = ((Color) ((Keyframe) CollectionsKt.first(((PropertyValuesHolderColor) propertyValuesHolderC2).c())).c()).B();
        }
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        ColorSpace colorSpaceW = Color.w(jB);
        boolean Z = composer.Z(colorSpaceW);
        Object objG = composer.G();
        if (Z || objG == Composer.f23746a.a()) {
            objG = (TwoWayConverter) ColorVectorConverterKt.a(Color.f25715b).invoke(colorSpaceW);
            composer.w(objG);
        }
        TwoWayConverter twoWayConverter = (TwoWayConverter) objG;
        int i6 = ((i5 << 3) & 7168) | (i5 & 14);
        boolean zBooleanValue2 = ((Boolean) transition.i()).booleanValue();
        composer.a0(1880460593);
        if (ComposerKt.M()) {
            ComposerKt.U(1880460593, 0, -1, "androidx.compose.animation.graphics.vector.ColorPropertyValues.createState.<anonymous> (Animator.kt:205)");
        }
        if (zBooleanValue2) {
            PropertyValuesHolder propertyValuesHolderC3 = ((Timestamp) CollectionsKt.last(c())).c();
            Intrinsics.checkNotNull(propertyValuesHolderC3, "null cannot be cast to non-null type androidx.compose.animation.graphics.vector.PropertyValuesHolderColor");
            jB2 = ((Color) ((Keyframe) CollectionsKt.last(((PropertyValuesHolderColor) propertyValuesHolderC3).c())).c()).B();
        } else {
            PropertyValuesHolder propertyValuesHolderC4 = ((Timestamp) CollectionsKt.first(c())).c();
            Intrinsics.checkNotNull(propertyValuesHolderC4, "null cannot be cast to non-null type androidx.compose.animation.graphics.vector.PropertyValuesHolderColor");
            jB2 = ((Color) ((Keyframe) CollectionsKt.first(((PropertyValuesHolderColor) propertyValuesHolderC4).c())).c()).B();
        }
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        Color colorN = Color.n(jB2);
        boolean zBooleanValue3 = ((Boolean) transition.q()).booleanValue();
        composer.a0(1880460593);
        if (ComposerKt.M()) {
            ComposerKt.U(1880460593, 0, -1, "androidx.compose.animation.graphics.vector.ColorPropertyValues.createState.<anonymous> (Animator.kt:205)");
        }
        if (zBooleanValue3) {
            PropertyValuesHolder propertyValuesHolderC5 = ((Timestamp) CollectionsKt.last(c())).c();
            Intrinsics.checkNotNull(propertyValuesHolderC5, "null cannot be cast to non-null type androidx.compose.animation.graphics.vector.PropertyValuesHolderColor");
            jB3 = ((Color) ((Keyframe) CollectionsKt.last(((PropertyValuesHolderColor) propertyValuesHolderC5).c())).c()).B();
        } else {
            PropertyValuesHolder propertyValuesHolderC6 = ((Timestamp) CollectionsKt.first(c())).c();
            Intrinsics.checkNotNull(propertyValuesHolderC6, "null cannot be cast to non-null type androidx.compose.animation.graphics.vector.PropertyValuesHolderColor");
            jB3 = ((Color) ((Keyframe) CollectionsKt.first(((PropertyValuesHolderColor) propertyValuesHolderC6).c())).c()).B();
        }
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        State stateF = TransitionKt.f(transition, colorN, Color.n(jB3), (FiniteAnimationSpec) function3A.invoke(transition.o(), composer, 0), twoWayConverter, str, composer, (i6 & 14) | ((i6 << 6) & 458752));
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        return stateF;
    }
}
