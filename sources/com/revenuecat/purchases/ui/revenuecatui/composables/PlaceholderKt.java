package com.revenuecat.purchases.ui.revenuecatui.composables;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.OutlineKt;
import androidx.compose.ui.graphics.Paint;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.unit.LayoutDirection;
import com.revenuecat.purchases.ui.revenuecatui.helpers.HelperFunctionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class PlaceholderKt {
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: drawPlaceholder-hpmOzss, reason: not valid java name */
    public static final Outline m919drawPlaceholderhpmOzss(DrawScope drawScope, Shape shape, long j3, PlaceholderHighlight placeholderHighlight, float f3, Outline outline, LayoutDirection layoutDirection, Size size) {
        DrawScope drawScope2;
        Outline outlineMo29createOutlinePq9zytI = null;
        if (shape == RectangleShapeKt.a()) {
            DrawScope.L1(drawScope, j3, 0L, 0L, 0.0f, null, null, 0, 126, null);
            if (placeholderHighlight != null) {
                DrawScope.k1(drawScope, placeholderHighlight.mo880brushd16Qtg0(f3, drawScope.b()), 0L, 0L, placeholderHighlight.alpha(f3), null, null, 0, 118, null);
            }
            return null;
        }
        if (Size.e(drawScope.b(), size) && drawScope.getLayoutDirection() == layoutDirection) {
            outlineMo29createOutlinePq9zytI = outline;
        }
        if (outlineMo29createOutlinePq9zytI == null) {
            drawScope2 = drawScope;
            outlineMo29createOutlinePq9zytI = shape.mo29createOutlinePq9zytI(drawScope.b(), drawScope.getLayoutDirection(), drawScope2);
        } else {
            drawScope2 = drawScope;
        }
        Outline outline2 = outlineMo29createOutlinePq9zytI;
        OutlineKt.e(drawScope2, outline2, j3, 0.0f, null, null, 0, 60, null);
        if (placeholderHighlight != null) {
            OutlineKt.c(drawScope, outline2, placeholderHighlight.mo880brushd16Qtg0(f3, drawScope.b()), placeholderHighlight.alpha(f3), null, null, 0, 56, null);
        }
        return outline2;
    }

    /* JADX INFO: renamed from: placeholder-TgFrcIs, reason: not valid java name */
    public static final Modifier m920placeholderTgFrcIs(Modifier placeholder, boolean z2, long j3, Shape shape, PlaceholderHighlight placeholderHighlight, Function0<? extends FiniteAnimationSpec<Float>> function0, Function0<? extends FiniteAnimationSpec<Float>> function02, Composer composer, int i3, int i4) {
        Intrinsics.checkNotNullParameter(placeholder, "$this$placeholder");
        composer.a0(828411458);
        Shape shapeA = (i4 & 4) != 0 ? RectangleShapeKt.a() : shape;
        PlaceholderHighlight placeholderHighlight2 = (i4 & 8) != 0 ? null : placeholderHighlight;
        Function0<? extends FiniteAnimationSpec<Float>> function03 = (i4 & 16) != 0 ? new Function0<SpringSpec<Float>>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.PlaceholderKt$placeholder$1
            @Override // kotlin.jvm.functions.Function0
            public final SpringSpec<Float> invoke() {
                return AnimationSpecKt.l(0.0f, 0.0f, null, 7, null);
            }
        } : function0;
        Function0<? extends FiniteAnimationSpec<Float>> function04 = (i4 & 32) != 0 ? new Function0<SpringSpec<Float>>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.PlaceholderKt$placeholder$2
            @Override // kotlin.jvm.functions.Function0
            public final SpringSpec<Float> invoke() {
                return AnimationSpecKt.l(0.0f, 0.0f, null, 7, null);
            }
        } : function02;
        if (ComposerKt.M()) {
            ComposerKt.U(828411458, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.composables.placeholder (Placeholder.kt:68)");
        }
        Modifier modifierThen = placeholder.then(new PlaceholderElement(m921rememberPlaceholderOadGlvw(z2, j3, shapeA, placeholderHighlight2, function03, function04, composer, (i3 >> 3) & 524286, 0)));
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        return modifierThen;
    }

    /* JADX INFO: renamed from: rememberPlaceholder-OadGlvw, reason: not valid java name */
    public static final Placeholder m921rememberPlaceholderOadGlvw(boolean z2, long j3, Shape shape, PlaceholderHighlight placeholderHighlight, Function0<? extends FiniteAnimationSpec<Float>> function0, Function0<? extends FiniteAnimationSpec<Float>> function02, Composer composer, int i3, int i4) {
        composer.a0(1627318888);
        Shape shapeA = (i4 & 4) != 0 ? RectangleShapeKt.a() : shape;
        PlaceholderHighlight placeholderHighlight2 = (i4 & 8) != 0 ? null : placeholderHighlight;
        Function0<? extends FiniteAnimationSpec<Float>> function03 = (i4 & 16) != 0 ? new Function0<SpringSpec<Float>>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.PlaceholderKt$rememberPlaceholder$1
            @Override // kotlin.jvm.functions.Function0
            public final SpringSpec<Float> invoke() {
                return AnimationSpecKt.l(0.0f, 0.0f, null, 7, null);
            }
        } : function0;
        Function0<? extends FiniteAnimationSpec<Float>> function04 = (i4 & 32) != 0 ? new Function0<SpringSpec<Float>>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.PlaceholderKt$rememberPlaceholder$2
            @Override // kotlin.jvm.functions.Function0
            public final SpringSpec<Float> invoke() {
                return AnimationSpecKt.l(0.0f, 0.0f, null, 7, null);
            }
        } : function02;
        if (ComposerKt.M()) {
            ComposerKt.U(1627318888, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.composables.rememberPlaceholder (Placeholder.kt:102)");
        }
        Object[] objArr = {Boolean.valueOf(z2), Color.n(j3), shapeA, placeholderHighlight2, function03, function04};
        boolean Z = false;
        for (int i5 = 0; i5 < 6; i5++) {
            Z |= composer.Z(objArr[i5]);
        }
        Object objG = composer.G();
        if (Z || objG == Composer.f23746a.a()) {
            objG = new Placeholder(z2, j3, shapeA, placeholderHighlight2, function03, function04, null);
            composer.w(objG);
        }
        Placeholder placeholder = (Placeholder) objG;
        boolean zIsInPreviewMode = HelperFunctionsKt.isInPreviewMode(composer, 0);
        composer.a0(653949553);
        boolean zB = ((((i3 & 14) ^ 6) > 4 && composer.b(z2)) || (i3 & 6) == 4) | composer.b(zIsInPreviewMode) | composer.Z(placeholder);
        Object objG2 = composer.G();
        if (zB || objG2 == Composer.f23746a.a()) {
            objG2 = new PlaceholderKt$rememberPlaceholder$3$1(z2, zIsInPreviewMode, placeholder, null);
            composer.w(objG2);
        }
        composer.U();
        EffectsKt.g(placeholder, (Function2) objG2, composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        return placeholder;
    }

    private static final void withLayer(DrawScope drawScope, Paint paint, Function1<? super DrawScope, Unit> function1) {
        Canvas canvasG = drawScope.Q1().g();
        canvasG.p(SizeKt.c(drawScope.b()), paint);
        function1.invoke(drawScope);
        canvasG.k();
    }
}
