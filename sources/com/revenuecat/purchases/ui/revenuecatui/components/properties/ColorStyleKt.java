package com.revenuecat.purchases.ui.revenuecatui.components.properties;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.DarkThemeKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
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
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.TileMode;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.tooling.preview.PreviewParameter;
import androidx.compose.ui.unit.Dp;
import com.revenuecat.purchases.ColorAlias;
import com.revenuecat.purchases.paywalls.components.properties.ColorInfo;
import com.revenuecat.purchases.paywalls.components.properties.ColorScheme;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ColorStyle;
import com.revenuecat.purchases.ui.revenuecatui.errors.PaywallValidationError;
import com.revenuecat.purchases.ui.revenuecatui.helpers.NonEmptyList;
import com.revenuecat.purchases.ui.revenuecatui.helpers.NonEmptyListKt;
import com.revenuecat.purchases.ui.revenuecatui.helpers.Result;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
public final class ColorStyleKt {
    private static final float PERCENT_SCALE = 100.0f;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void LinearGradient_Preview_Rectangle(Composer composer, final int i3) {
        Composer composerK = composer.k(-2011369738);
        if (i3 == 0 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(-2011369738, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.components.properties.LinearGradient_Preview_Rectangle (ColorStyle.kt:320)");
            }
            Modifier modifierP = SizeKt.p(Modifier.b8, Dp.g(300), Dp.g(100));
            Float fValueOf = Float.valueOf(0.0f);
            Color.Companion companion = Color.f25715b;
            BoxKt.a(BackgroundKt.b(modifierP, m786relativeLinearGradient3YTHUZs$default(new Pair[]{TuplesKt.a(fValueOf, Color.n(companion.m())), TuplesKt.a(Float.valueOf(0.5f), Color.n(companion.i())), TuplesKt.a(Float.valueOf(1.0f), Color.n(companion.b()))}, 45.0f, 0, 4, null), null, 0.0f, 6, null), composerK, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.properties.ColorStyleKt.LinearGradient_Preview_Rectangle.1
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
                    ColorStyleKt.LinearGradient_Preview_Rectangle(composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void LinearGradient_Preview_Rectangle_OrangeCyan(Composer composer, final int i3) {
        Composer composerK = composer.k(-123893266);
        if (i3 == 0 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(-123893266, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.components.properties.LinearGradient_Preview_Rectangle_OrangeCyan (ColorStyle.kt:364)");
            }
            BoxKt.a(BackgroundKt.b(SizeKt.p(Modifier.b8, Dp.g(300), Dp.g(55)), m786relativeLinearGradient3YTHUZs$default(new Pair[]{TuplesKt.a(Float.valueOf(0.6f), Color.n(ColorKt.f(255, 165, 0, 0, 8, null))), TuplesKt.a(Float.valueOf(1.0f), Color.n(Color.f25715b.c()))}, 135.0f, 0, 4, null), null, 0.0f, 6, null), composerK, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.properties.ColorStyleKt.LinearGradient_Preview_Rectangle_OrangeCyan.1
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
                    ColorStyleKt.LinearGradient_Preview_Rectangle_OrangeCyan(composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void LinearGradient_Preview_Rectangle_RedBlue(Composer composer, final int i3) {
        Composer composerK = composer.k(1224320034);
        if (i3 == 0 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(1224320034, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.components.properties.LinearGradient_Preview_Rectangle_RedBlue (ColorStyle.kt:342)");
            }
            Modifier modifierP = SizeKt.p(Modifier.b8, Dp.g(300), Dp.g(55));
            Float fValueOf = Float.valueOf(0.0f);
            Color.Companion companion = Color.f25715b;
            BoxKt.a(BackgroundKt.b(modifierP, m786relativeLinearGradient3YTHUZs$default(new Pair[]{TuplesKt.a(fValueOf, Color.n(companion.i())), TuplesKt.a(Float.valueOf(1.0f), Color.n(companion.b()))}, 45.0f, 0, 4, null), null, 0.0f, 6, null), composerK, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.properties.ColorStyleKt.LinearGradient_Preview_Rectangle_RedBlue.1
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
                    ColorStyleKt.LinearGradient_Preview_Rectangle_RedBlue(composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void LinearGradient_Preview_Rectangle_Template014Button(Composer composer, final int i3) {
        Composer composerK = composer.k(1429933954);
        if (i3 == 0 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(1429933954, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.components.properties.LinearGradient_Preview_Rectangle_Template014Button (ColorStyle.kt:383)");
            }
            BoxKt.a(BackgroundKt.b(SizeKt.p(Modifier.b8, Dp.g(300), Dp.g(55)), m786relativeLinearGradient3YTHUZs$default(new Pair[]{TuplesKt.a(Float.valueOf(0.0f), Color.n(ColorKt.f(1, 1, 87, 0, 8, null))), TuplesKt.a(Float.valueOf(0.46f), Color.n(ColorKt.f(35, 35, 151, 0, 8, null))), TuplesKt.a(Float.valueOf(1.0f), Color.n(ColorKt.f(221, 2, 92, 0, 8, null)))}, 8.0f, 0, 4, null), RoundedCornerShapeKt.a(50), 0.0f, 4, null), composerK, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.properties.ColorStyleKt.LinearGradient_Preview_Rectangle_Template014Button.1
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
                    ColorStyleKt.LinearGradient_Preview_Rectangle_Template014Button(composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void LinearGradient_Preview_Square(Composer composer, final int i3) {
        Composer composerK = composer.k(1721100010);
        if (i3 == 0 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(1721100010, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.components.properties.LinearGradient_Preview_Square (ColorStyle.kt:300)");
            }
            Modifier modifierO = SizeKt.o(Modifier.b8, Dp.g(200));
            Float fValueOf = Float.valueOf(0.0f);
            Color.Companion companion = Color.f25715b;
            BoxKt.a(BackgroundKt.b(modifierO, m786relativeLinearGradient3YTHUZs$default(new Pair[]{TuplesKt.a(fValueOf, Color.n(companion.m())), TuplesKt.a(Float.valueOf(0.5f), Color.n(companion.i())), TuplesKt.a(Float.valueOf(1.0f), Color.n(companion.b()))}, 45.0f, 0, 4, null), null, 0.0f, 6, null), composerK, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.properties.ColorStyleKt.LinearGradient_Preview_Square.1
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
                    ColorStyleKt.LinearGradient_Preview_Square(composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void LinearGradient_Preview_Square_BluePink(Composer composer, final int i3) {
        Composer composerK = composer.k(1487537977);
        if (i3 == 0 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(1487537977, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.components.properties.LinearGradient_Preview_Square_BluePink (ColorStyle.kt:406)");
            }
            BoxKt.a(BackgroundKt.b(SizeKt.o(Modifier.b8, Dp.g(100)), m786relativeLinearGradient3YTHUZs$default(new Pair[]{TuplesKt.a(Float.valueOf(0.0f), Color.n(Color.f25715b.b())), TuplesKt.a(Float.valueOf(1.0f), Color.n(ColorKt.f(255, 192, 203, 0, 8, null)))}, 70.0f, 0, 4, null), null, 0.0f, 6, null), composerK, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.properties.ColorStyleKt.LinearGradient_Preview_Square_BluePink.1
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
                    ColorStyleKt.LinearGradient_Preview_Square_BluePink(composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void LinearGradient_Preview_SquaresDegrees(@PreviewParameter final float f3, Composer composer, final int i3) {
        int i4;
        Composer composer2;
        Composer composerK = composer.k(-1866931670);
        if ((i3 & 6) == 0) {
            i4 = (composerK.c(f3) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i4 & 3) == 2 && composerK.l()) {
            composerK.Q();
            composer2 = composerK;
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(-1866931670, i4, -1, "com.revenuecat.purchases.ui.revenuecatui.components.properties.LinearGradient_Preview_SquaresDegrees (ColorStyle.kt:439)");
            }
            Modifier modifierO = SizeKt.o(Modifier.b8, Dp.g(100));
            Float fValueOf = Float.valueOf(0.0f);
            Color.Companion companion = Color.f25715b;
            Modifier modifierB = BackgroundKt.b(modifierO, m786relativeLinearGradient3YTHUZs$default(new Pair[]{TuplesKt.a(fValueOf, Color.n(companion.i())), TuplesKt.a(Float.valueOf(1.0f), Color.n(companion.l()))}, f3, 0, 4, null), null, 0.0f, 6, null);
            MeasurePolicy measurePolicyG = BoxKt.g(Alignment.f25072a.e(), false);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierB);
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
            composer2 = composerK;
            TextKt.c(f3 + "deg", null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer2, 0, 0, 131070);
            composer2.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.properties.ColorStyleKt.LinearGradient_Preview_SquaresDegrees.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer3, int i5) {
                    ColorStyleKt.LinearGradient_Preview_SquaresDegrees(f3, composer3, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void RadialGradient_Preview(Composer composer, final int i3) {
        Composer composerK = composer.k(1776704032);
        if (i3 == 0 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(1776704032, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.components.properties.RadialGradient_Preview (ColorStyle.kt:462)");
            }
            Modifier modifierP = SizeKt.p(Modifier.b8, Dp.g(300), Dp.g(100));
            Float fValueOf = Float.valueOf(0.0f);
            Color.Companion companion = Color.f25715b;
            Modifier modifierB = BackgroundKt.b(modifierP, m784radialGradientP_VxKs$default(new Pair[]{TuplesKt.a(fValueOf, Color.n(companion.i())), TuplesKt.a(Float.valueOf(1.0f), Color.n(companion.l()))}, 0L, 0.0f, 0, 14, null), null, 0.0f, 6, null);
            MeasurePolicy measurePolicyG = BoxKt.g(Alignment.f25072a.e(), false);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierB);
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
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.properties.ColorStyleKt.RadialGradient_Preview.2
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
                    ColorStyleKt.RadialGradient_Preview(composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    public static final /* synthetic */ ColorStyle getForCurrentTheme(ColorStyles colorStyles, Composer composer, int i3) {
        ColorStyle light;
        Intrinsics.checkNotNullParameter(colorStyles, "<this>");
        composer.a0(-375069960);
        if (ComposerKt.M()) {
            ComposerKt.U(-375069960, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.components.properties.<get-forCurrentTheme> (ColorStyle.kt:75)");
        }
        if (!DarkThemeKt.a(composer, 0) || (light = colorStyles.getDark()) == null) {
            light = colorStyles.getLight();
        }
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        return light;
    }

    /* JADX INFO: renamed from: radialGradient-P_Vx-Ks, reason: not valid java name */
    private static final GradientBrush m783radialGradientP_VxKs(Pair<Float, Color>[] pairArr, long j3, float f3, int i3) {
        return new RadialGradient((Pair[]) Arrays.copyOf(pairArr, pairArr.length), j3, f3, i3, null);
    }

    /* JADX INFO: renamed from: radialGradient-P_Vx-Ks$default, reason: not valid java name */
    static /* synthetic */ GradientBrush m784radialGradientP_VxKs$default(Pair[] pairArr, long j3, float f3, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            j3 = Offset.f25596b.b();
        }
        if ((i4 & 4) != 0) {
            f3 = Float.POSITIVE_INFINITY;
        }
        if ((i4 & 8) != 0) {
            i3 = TileMode.f25948b.a();
        }
        return m783radialGradientP_VxKs(pairArr, j3, f3, i3);
    }

    /* JADX INFO: renamed from: relativeLinearGradient-3YTHUZs, reason: not valid java name */
    private static final GradientBrush m785relativeLinearGradient3YTHUZs(Pair<Float, Color>[] pairArr, float f3, int i3) {
        ArrayList arrayList = new ArrayList(pairArr.length);
        for (Pair<Float, Color> pair : pairArr) {
            arrayList.add(Color.n(((Color) pair.f()).B()));
        }
        ArrayList arrayList2 = new ArrayList(pairArr.length);
        for (Pair<Float, Color> pair2 : pairArr) {
            arrayList2.add(Float.valueOf(((Number) pair2.e()).floatValue()));
        }
        return new RelativeLinearGradient(arrayList, arrayList2, f3, i3, null);
    }

    /* JADX INFO: renamed from: relativeLinearGradient-3YTHUZs$default, reason: not valid java name */
    static /* synthetic */ GradientBrush m786relativeLinearGradient3YTHUZs$default(Pair[] pairArr, float f3, int i3, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            i3 = TileMode.f25948b.a();
        }
        return m785relativeLinearGradient3YTHUZs(pairArr, f3, i3);
    }

    private static final Pair<Float, Color>[] toColorStops(List<ColorInfo.Gradient.Point> list) {
        List<ColorInfo.Gradient.Point> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (ColorInfo.Gradient.Point point : list2) {
            arrayList.add(TuplesKt.a(Float.valueOf(point.getPercent() / PERCENT_SCALE), Color.n(ColorKt.b(point.getColor()))));
        }
        return (Pair[]) arrayList.toArray(new Pair[0]);
    }

    public static final /* synthetic */ ColorStyle toColorStyle(ColorInfo.Gradient gradient) {
        GradientBrush gradientBrushM784radialGradientP_VxKs$default;
        Intrinsics.checkNotNullParameter(gradient, "<this>");
        if (gradient instanceof ColorInfo.Gradient.Linear) {
            ColorInfo.Gradient.Linear linear = (ColorInfo.Gradient.Linear) gradient;
            Pair<Float, Color>[] colorStops = toColorStops(linear.getPoints());
            gradientBrushM784radialGradientP_VxKs$default = m786relativeLinearGradient3YTHUZs$default((Pair[]) Arrays.copyOf(colorStops, colorStops.length), linear.getDegrees(), 0, 4, null);
        } else {
            if (!(gradient instanceof ColorInfo.Gradient.Radial)) {
                throw new NoWhenBranchMatchedException();
            }
            Pair<Float, Color>[] colorStops2 = toColorStops(((ColorInfo.Gradient.Radial) gradient).getPoints());
            gradientBrushM784radialGradientP_VxKs$default = m784radialGradientP_VxKs$default((Pair[]) Arrays.copyOf(colorStops2, colorStops2.length), 0L, 0.0f, 0, 14, null);
        }
        return ColorStyle.Gradient.m768boximpl(ColorStyle.Gradient.m769constructorimpl(gradientBrushM784radialGradientP_VxKs$default));
    }

    public static final /* synthetic */ Result toColorStyles(ColorScheme colorScheme, Map aliases) {
        Intrinsics.checkNotNullParameter(colorScheme, "<this>");
        Intrinsics.checkNotNullParameter(aliases, "aliases");
        Result colorStyle = toColorStyle(colorScheme.getLight(), aliases, true);
        if (!(colorStyle instanceof Result.Success)) {
            if (!(colorStyle instanceof Result.Error)) {
                throw new NoWhenBranchMatchedException();
            }
            colorStyle = new Result.Error(NonEmptyListKt.nonEmptyListOf((PaywallValidationError) ((Result.Error) colorStyle).getValue(), new PaywallValidationError[0]));
        }
        ColorInfo dark = colorScheme.getDark();
        Result resultOrSuccessfullyNull = ResultKt.orSuccessfullyNull(dark != null ? toColorStyle(dark, aliases, false) : null);
        if (!(resultOrSuccessfullyNull instanceof Result.Success)) {
            if (!(resultOrSuccessfullyNull instanceof Result.Error)) {
                throw new NoWhenBranchMatchedException();
            }
            resultOrSuccessfullyNull = new Result.Error(NonEmptyListKt.nonEmptyListOf((PaywallValidationError) ((Result.Error) resultOrSuccessfullyNull).getValue(), new PaywallValidationError[0]));
        }
        Unit unit = Unit.f139807a;
        Result.Success success = new Result.Success(unit);
        Result.Success success2 = new Result.Success(unit);
        Result.Success success3 = new Result.Success(unit);
        Result.Success success4 = new Result.Success(unit);
        NonEmptyList nonEmptyListOrNull = NonEmptyListKt.toNonEmptyListOrNull(ResultKt.collectErrors(CollectionsKt.listOf((Object[]) new Result[]{colorStyle, resultOrSuccessfullyNull, success, success2, success3, success4})));
        if (nonEmptyListOrNull != null) {
            return new Result.Error(nonEmptyListOrNull);
        }
        Intrinsics.checkNotNull(colorStyle, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<A of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
        Object value = ((Result.Success) colorStyle).getValue();
        Intrinsics.checkNotNull(resultOrSuccessfullyNull, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<B of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
        Object value2 = ((Result.Success) resultOrSuccessfullyNull).getValue();
        Object value3 = success.getValue();
        Object value4 = success2.getValue();
        Object value5 = success3.getValue();
        return new Result.Success(new ColorStyles((ColorStyle) value, (ColorStyle) value2));
    }

    public static final /* synthetic */ Result toColorStyle(ColorInfo colorInfo, Map aliases, boolean z2) {
        GradientBrush gradientBrushM784radialGradientP_VxKs$default;
        ColorInfo light;
        ColorInfo dark;
        Intrinsics.checkNotNullParameter(colorInfo, "<this>");
        Intrinsics.checkNotNullParameter(aliases, "aliases");
        DefaultConstructorMarker defaultConstructorMarker = null;
        if (colorInfo instanceof ColorInfo.Alias) {
            ColorInfo.Alias alias = (ColorInfo.Alias) colorInfo;
            ColorScheme colorScheme = (ColorScheme) aliases.get(ColorAlias.m414boximpl(alias.m659getValue671NwFM()));
            if (colorScheme != null) {
                light = (z2 || (dark = colorScheme.getDark()) == null) ? colorScheme.getLight() : dark;
            } else {
                light = null;
            }
            if (light instanceof ColorInfo.Gradient ? true : light instanceof ColorInfo.Hex) {
                return toColorStyle(light, aliases, z2);
            }
            if (light instanceof ColorInfo.Alias) {
                return new Result.Error(new PaywallValidationError.AliasedColorIsAlias(alias.m659getValue671NwFM(), ((ColorInfo.Alias) light).m659getValue671NwFM(), defaultConstructorMarker));
            }
            if (light == null) {
                return new Result.Error(new PaywallValidationError.MissingColorAlias(alias.m659getValue671NwFM(), defaultConstructorMarker));
            }
            throw new NoWhenBranchMatchedException();
        }
        if (colorInfo instanceof ColorInfo.Hex) {
            return new Result.Success(ColorStyle.Solid.m775boximpl(ColorStyle.Solid.m776constructorimpl(ColorKt.b(((ColorInfo.Hex) colorInfo).getValue()))));
        }
        if (colorInfo instanceof ColorInfo.Gradient) {
            if (colorInfo instanceof ColorInfo.Gradient.Linear) {
                ColorInfo.Gradient.Linear linear = (ColorInfo.Gradient.Linear) colorInfo;
                Pair<Float, Color>[] colorStops = toColorStops(linear.getPoints());
                gradientBrushM784radialGradientP_VxKs$default = m786relativeLinearGradient3YTHUZs$default((Pair[]) Arrays.copyOf(colorStops, colorStops.length), linear.getDegrees(), 0, 4, null);
            } else if (colorInfo instanceof ColorInfo.Gradient.Radial) {
                Pair<Float, Color>[] colorStops2 = toColorStops(((ColorInfo.Gradient.Radial) colorInfo).getPoints());
                gradientBrushM784radialGradientP_VxKs$default = m784radialGradientP_VxKs$default((Pair[]) Arrays.copyOf(colorStops2, colorStops2.length), 0L, 0.0f, 0, 14, null);
            } else {
                throw new NoWhenBranchMatchedException();
            }
            return new Result.Success(ColorStyle.Gradient.m768boximpl(ColorStyle.Gradient.m769constructorimpl(gradientBrushM784radialGradientP_VxKs$default)));
        }
        throw new NoWhenBranchMatchedException();
    }
}
