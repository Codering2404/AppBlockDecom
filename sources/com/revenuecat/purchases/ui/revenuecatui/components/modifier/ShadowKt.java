package com.revenuecat.purchases.ui.revenuecatui.components.modifier;

import android.graphics.BlurMaskFilter;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.RoundRectKt;
import androidx.compose.ui.graphics.AndroidPaint_androidKt;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.ClipOp;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.OutlineKt;
import androidx.compose.ui.graphics.Paint;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import com.revenuecat.purchases.paywalls.components.properties.ColorInfo;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ColorStyle;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ColorStyleKt;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ShadowStyle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final /* synthetic */ class ShadowKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void Shadow_Preview_Circle(Composer composer, final int i3) {
        Composer composerK = composer.k(1888265500);
        if (i3 == 0 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(1888265500, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.components.modifier.Shadow_Preview_Circle (Shadow.kt:96)");
            }
            RoundedCornerShape roundedCornerShapeG = RoundedCornerShapeKt.g();
            Modifier.Companion companion = Modifier.b8;
            Modifier modifierO = androidx.compose.foundation.layout.SizeKt.o(companion, Dp.g(200));
            MeasurePolicy measurePolicyG = BoxKt.g(Alignment.f25072a.e(), false);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierO);
            ComposeUiNode.Companion companion2 = ComposeUiNode.f8;
            Function0 function0A = companion2.a();
            if (composerK.m() == null) {
                ComposablesKt.c();
            }
            composerK.L();
            if (composerK.i()) {
                composerK.P(function0A);
            } else {
                composerK.v();
            }
            Composer composerA = Updater.a(composerK);
            Updater.e(composerA, measurePolicyG, companion2.e());
            Updater.e(composerA, compositionLocalMapU, companion2.g());
            Function2 function2B = companion2.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion2.f());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
            Modifier modifierO2 = androidx.compose.foundation.layout.SizeKt.o(companion, Dp.g(100));
            Color.Companion companion3 = Color.f25715b;
            long jM776constructorimpl = ColorStyle.Solid.m776constructorimpl(companion3.a());
            float f3 = 5;
            BoxKt.a(androidx.compose.foundation.BackgroundKt.c(shadow(modifierO2, new ShadowStyle(ColorStyle.Solid.m775boximpl(jM776constructorimpl), Dp.g(0), Dp.g(f3), Dp.g(f3), null), roundedCornerShapeG), companion3.i(), roundedCornerShapeG), composerK, 0);
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.modifier.ShadowKt.Shadow_Preview_Circle.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i4) {
                    ShadowKt.Shadow_Preview_Circle(composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Shadow_Preview_CircleAlpha(Composer composer, final int i3) {
        Composer composerK = composer.k(524710378);
        if (i3 == 0 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(524710378, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.components.modifier.Shadow_Preview_CircleAlpha (Shadow.kt:149)");
            }
            RoundedCornerShape roundedCornerShapeG = RoundedCornerShapeKt.g();
            Modifier.Companion companion = Modifier.b8;
            Modifier modifierO = androidx.compose.foundation.layout.SizeKt.o(companion, Dp.g(200));
            MeasurePolicy measurePolicyG = BoxKt.g(Alignment.f25072a.e(), false);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierO);
            ComposeUiNode.Companion companion2 = ComposeUiNode.f8;
            Function0 function0A = companion2.a();
            if (composerK.m() == null) {
                ComposablesKt.c();
            }
            composerK.L();
            if (composerK.i()) {
                composerK.P(function0A);
            } else {
                composerK.v();
            }
            Composer composerA = Updater.a(composerK);
            Updater.e(composerA, measurePolicyG, companion2.e());
            Updater.e(composerA, compositionLocalMapU, companion2.g());
            Function2 function2B = companion2.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion2.f());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
            Modifier modifierO2 = androidx.compose.foundation.layout.SizeKt.o(companion, Dp.g(100));
            Color.Companion companion3 = Color.f25715b;
            long jM776constructorimpl = ColorStyle.Solid.m776constructorimpl(companion3.a());
            float f3 = 5;
            BoxKt.a(androidx.compose.foundation.BackgroundKt.c(shadow(modifierO2, new ShadowStyle(ColorStyle.Solid.m775boximpl(jM776constructorimpl), Dp.g(0), Dp.g(f3), Dp.g(f3), null), roundedCornerShapeG), Color.r(companion3.i(), 0.5f, 0.0f, 0.0f, 0.0f, 14, null), roundedCornerShapeG), composerK, 0);
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.modifier.ShadowKt.Shadow_Preview_CircleAlpha.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i4) {
                    ShadowKt.Shadow_Preview_CircleAlpha(composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Shadow_Preview_Gradient_CustomShape(Composer composer, final int i3) {
        Composer composer2;
        Composer composerK = composer.k(2006972301);
        if (i3 == 0 && composerK.l()) {
            composerK.Q();
            composer2 = composerK;
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(2006972301, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.components.modifier.Shadow_Preview_Gradient_CustomShape (Shadow.kt:203)");
            }
            RoundedCornerShape roundedCornerShapeA = RoundedCornerShapeKt.a(50);
            Modifier.Companion companion = Modifier.b8;
            Modifier modifierO = androidx.compose.foundation.layout.SizeKt.o(companion, Dp.g(200));
            MeasurePolicy measurePolicyG = BoxKt.g(Alignment.f25072a.e(), false);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierO);
            ComposeUiNode.Companion companion2 = ComposeUiNode.f8;
            Function0 function0A = companion2.a();
            if (composerK.m() == null) {
                ComposablesKt.c();
            }
            composerK.L();
            if (composerK.i()) {
                composerK.P(function0A);
            } else {
                composerK.v();
            }
            Composer composerA = Updater.a(composerK);
            Updater.e(composerA, measurePolicyG, companion2.e());
            Updater.e(composerA, compositionLocalMapU, companion2.g());
            Function2 function2B = companion2.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion2.f());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
            Color.Companion companion3 = Color.f25715b;
            composer2 = composerK;
            TextKt.c("GET UNLIMITED RGB", PaddingKt.j(androidx.compose.foundation.BackgroundKt.c(shadow(companion, new ShadowStyle(ColorStyleKt.toColorStyle(new ColorInfo.Gradient.Linear(90.0f, CollectionsKt.listOf((Object[]) new ColorInfo.Gradient.Point[]{new ColorInfo.Gradient.Point(ColorKt.k(companion3.i()), 10.0f), new ColorInfo.Gradient.Point(ColorKt.k(companion3.f()), 50.0f), new ColorInfo.Gradient.Point(ColorKt.k(companion3.b()), 90.0f)}))), Dp.g((float) 9.5d), Dp.g(0), Dp.g(6), null), roundedCornerShapeA), companion3.a(), roundedCornerShapeA), Dp.g(24), Dp.g(16)), companion3.l(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.f18110a.c(composerK, MaterialTheme.f18111b).p(), composer2, 390, 0, 65528);
            composer2.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.modifier.ShadowKt.Shadow_Preview_Gradient_CustomShape.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer3, int i4) {
                    ShadowKt.Shadow_Preview_Gradient_CustomShape(composer3, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Shadow_Preview_Margin(Composer composer, final int i3) {
        Composer composerK = composer.k(-1769512070);
        if (i3 == 0 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(-1769512070, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.components.modifier.Shadow_Preview_Margin (Shadow.kt:249)");
            }
            float f3 = 16;
            PaddingValues paddingValuesD = PaddingKt.d(Dp.g(8), Dp.g(f3), Dp.g(4), Dp.g(24));
            Shape shapeA = RectangleShapeKt.a();
            Modifier.Companion companion = Modifier.b8;
            Modifier modifierP = androidx.compose.foundation.layout.SizeKt.p(companion, Dp.g(100), Dp.g(200));
            MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.b(), Alignment.f25072a.g(), composerK, 54);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierP);
            ComposeUiNode.Companion companion2 = ComposeUiNode.f8;
            Function0 function0A = companion2.a();
            if (composerK.m() == null) {
                ComposablesKt.c();
            }
            composerK.L();
            if (composerK.i()) {
                composerK.P(function0A);
            } else {
                composerK.v();
            }
            Composer composerA = Updater.a(composerK);
            Updater.e(composerA, measurePolicyA, companion2.e());
            Updater.e(composerA, compositionLocalMapU, companion2.g());
            Function2 function2B = companion2.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion2.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            float f4 = 50;
            Modifier modifierP2 = androidx.compose.foundation.layout.SizeKt.p(PaddingKt.h(companion, paddingValuesD), Dp.g(f4), Dp.g(f4));
            Color.Companion companion3 = Color.f25715b;
            long jM776constructorimpl = ColorStyle.Solid.m776constructorimpl(companion3.a());
            float f5 = 0;
            float fG = Dp.g(f5);
            float f6 = 5;
            float fG2 = Dp.g(f6);
            float f7 = 20;
            float f8 = 2;
            BoxKt.a(PaddingKt.i(androidx.compose.foundation.BorderKt.f(androidx.compose.foundation.BackgroundKt.c(shadow(modifierP2, new ShadowStyle(ColorStyle.Solid.m775boximpl(jM776constructorimpl), Dp.g(f7), fG, fG2, null), shapeA), companion3.i(), shapeA), Dp.g(f8), companion3.b(), shapeA), Dp.g(f3)), composerK, 0);
            Modifier modifierP3 = androidx.compose.foundation.layout.SizeKt.p(PaddingKt.h(companion, paddingValuesD), Dp.g(f4), Dp.g(f4));
            long jM776constructorimpl2 = ColorStyle.Solid.m776constructorimpl(companion3.a());
            BoxKt.a(PaddingKt.i(androidx.compose.foundation.BorderKt.f(androidx.compose.foundation.BackgroundKt.c(shadow(modifierP3, new ShadowStyle(ColorStyle.Solid.m775boximpl(jM776constructorimpl2), Dp.g(f7), Dp.g(f5), Dp.g(f6), null), shapeA), companion3.i(), shapeA), Dp.g(f8), companion3.b(), shapeA), Dp.g(f3)), composerK, 0);
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.modifier.ShadowKt.Shadow_Preview_Margin.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i4) {
                    ShadowKt.Shadow_Preview_Margin(composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Shadow_Preview_Square(Composer composer, final int i3) {
        Composer composerK = composer.k(-1204850263);
        if (i3 == 0 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(-1204850263, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.components.modifier.Shadow_Preview_Square (Shadow.kt:123)");
            }
            Shape shapeA = RectangleShapeKt.a();
            Modifier.Companion companion = Modifier.b8;
            Modifier modifierO = androidx.compose.foundation.layout.SizeKt.o(companion, Dp.g(200));
            MeasurePolicy measurePolicyG = BoxKt.g(Alignment.f25072a.e(), false);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierO);
            ComposeUiNode.Companion companion2 = ComposeUiNode.f8;
            Function0 function0A = companion2.a();
            if (composerK.m() == null) {
                ComposablesKt.c();
            }
            composerK.L();
            if (composerK.i()) {
                composerK.P(function0A);
            } else {
                composerK.v();
            }
            Composer composerA = Updater.a(composerK);
            Updater.e(composerA, measurePolicyG, companion2.e());
            Updater.e(composerA, compositionLocalMapU, companion2.g());
            Function2 function2B = companion2.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion2.f());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
            Modifier modifierO2 = androidx.compose.foundation.layout.SizeKt.o(companion, Dp.g(100));
            Color.Companion companion3 = Color.f25715b;
            long jM776constructorimpl = ColorStyle.Solid.m776constructorimpl(companion3.a());
            BoxKt.a(androidx.compose.foundation.BackgroundKt.c(shadow(modifierO2, new ShadowStyle(ColorStyle.Solid.m775boximpl(jM776constructorimpl), Dp.g(20), Dp.g(10), Dp.g(5), null), shapeA), companion3.i(), shapeA), composerK, 0);
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.modifier.ShadowKt.Shadow_Preview_Square.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i4) {
                    ShadowKt.Shadow_Preview_Square(composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Shadow_Preview_SquareAlpha(Composer composer, final int i3) {
        Composer composerK = composer.k(1511945597);
        if (i3 == 0 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(1511945597, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.components.modifier.Shadow_Preview_SquareAlpha (Shadow.kt:176)");
            }
            Shape shapeA = RectangleShapeKt.a();
            Modifier.Companion companion = Modifier.b8;
            Modifier modifierO = androidx.compose.foundation.layout.SizeKt.o(companion, Dp.g(200));
            MeasurePolicy measurePolicyG = BoxKt.g(Alignment.f25072a.e(), false);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierO);
            ComposeUiNode.Companion companion2 = ComposeUiNode.f8;
            Function0 function0A = companion2.a();
            if (composerK.m() == null) {
                ComposablesKt.c();
            }
            composerK.L();
            if (composerK.i()) {
                composerK.P(function0A);
            } else {
                composerK.v();
            }
            Composer composerA = Updater.a(composerK);
            Updater.e(composerA, measurePolicyG, companion2.e());
            Updater.e(composerA, compositionLocalMapU, companion2.g());
            Function2 function2B = companion2.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion2.f());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
            Modifier modifierO2 = androidx.compose.foundation.layout.SizeKt.o(companion, Dp.g(100));
            Color.Companion companion3 = Color.f25715b;
            long jM776constructorimpl = ColorStyle.Solid.m776constructorimpl(companion3.a());
            BoxKt.a(androidx.compose.foundation.BackgroundKt.c(shadow(modifierO2, new ShadowStyle(ColorStyle.Solid.m775boximpl(jM776constructorimpl), Dp.g(20), Dp.g(10), Dp.g(5), null), shapeA), Color.r(companion3.i(), 0.5f, 0.0f, 0.0f, 0.0f, 14, null), shapeA), composerK, 0);
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.modifier.ShadowKt.Shadow_Preview_SquareAlpha.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i4) {
                    ShadowKt.Shadow_Preview_SquareAlpha(composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: renamed from: addOutline-0AR0LA0, reason: not valid java name */
    private static final void m742addOutline0AR0LA0(Path path, Outline outline, long j3) {
        if (outline instanceof Outline.Rectangle) {
            Path.d(path, ((Outline.Rectangle) outline).b().B(j3), null, 2, null);
        } else if (outline instanceof Outline.Rounded) {
            Path.s(path, RoundRectKt.h(((Outline.Rounded) outline).b(), j3), null, 2, null);
        } else if (outline instanceof Outline.Generic) {
            path.y(((Outline.Generic) outline).b(), j3);
        }
    }

    public static final /* synthetic */ Modifier shadow(Modifier modifier, final ShadowStyle shadow, final Shape shape) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(shadow, "shadow");
        Intrinsics.checkNotNullParameter(shape, "shape");
        return DrawModifierKt.b(modifier, new Function1<DrawScope, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.modifier.ShadowKt.shadow.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((DrawScope) obj);
                return Unit.f139807a;
            }

            public final void invoke(DrawScope drawBehind) {
                Intrinsics.checkNotNullParameter(drawBehind, "$this$drawBehind");
                Path pathM743toPathXbl9iGQ = ShadowKt.m743toPathXbl9iGQ(shape, drawBehind.b(), drawBehind.getLayoutDirection(), drawBehind, Offset.d(OffsetKt.a(drawBehind.M1(shadow.m795getXD9Ej5fM()), drawBehind.M1(shadow.m796getYD9Ej5fM()))));
                Paint paintA = AndroidPaint_androidKt.a();
                ShadowStyle shadowStyle = shadow;
                ColorStyle color = shadowStyle.getColor();
                if (color instanceof ColorStyle.Solid) {
                    paintA.u(((ColorStyle.Solid) shadowStyle.getColor()).m782unboximpl());
                } else if (color instanceof ColorStyle.Gradient) {
                    ((ColorStyle.Gradient) shadowStyle.getColor()).m774unboximpl().mo218applyToPq9zytI(drawBehind.b(), paintA, 1.0f);
                }
                if (!Dp.i(shadowStyle.m794getRadiusD9Ej5fM(), Dp.g(0))) {
                    paintA.y().setMaskFilter(new BlurMaskFilter(drawBehind.M1(shadowStyle.m794getRadiusD9Ej5fM()), BlurMaskFilter.Blur.NORMAL));
                }
                Shape shape2 = shape;
                Canvas canvasG = drawBehind.Q1().g();
                canvasG.t();
                canvasG.d(ShadowKt.m744toPathXbl9iGQ$default(shape2, drawBehind.b(), drawBehind.getLayoutDirection(), drawBehind, null, 8, null), ClipOp.f25711b.a());
                canvasG.x(pathM743toPathXbl9iGQ, paintA);
                canvasG.k();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: toPath-Xbl9iGQ, reason: not valid java name */
    public static final Path m743toPathXbl9iGQ(Shape shape, long j3, LayoutDirection layoutDirection, Density density, Offset offset) {
        Outline outlineMo29createOutlinePq9zytI = shape.mo29createOutlinePq9zytI(j3, layoutDirection, density);
        if (offset == null) {
            Path pathA = AndroidPath_androidKt.a();
            OutlineKt.a(pathA, outlineMo29createOutlinePq9zytI);
            return pathA;
        }
        Path pathA2 = AndroidPath_androidKt.a();
        m742addOutline0AR0LA0(pathA2, outlineMo29createOutlinePq9zytI, offset.u());
        return pathA2;
    }

    /* JADX INFO: renamed from: toPath-Xbl9iGQ$default, reason: not valid java name */
    static /* synthetic */ Path m744toPathXbl9iGQ$default(Shape shape, long j3, LayoutDirection layoutDirection, Density density, Offset offset, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            offset = null;
        }
        return m743toPathXbl9iGQ(shape, j3, layoutDirection, density, offset);
    }
}
