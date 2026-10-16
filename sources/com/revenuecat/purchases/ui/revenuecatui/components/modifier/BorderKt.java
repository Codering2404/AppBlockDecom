package com.revenuecat.purchases.ui.revenuecatui.components.modifier;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Dp;
import com.revenuecat.purchases.paywalls.components.properties.ColorInfo;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.BorderStyle;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ColorStyle;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ColorStyleKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
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
public final /* synthetic */ class BorderKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void Border_Preview_LinearGradient(final Shape shape, Composer composer, final int i3) {
        int i4;
        Composer composerK = composer.k(-1213727402);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(shape) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i4 & 3) == 2 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(-1213727402, i4, -1, "com.revenuecat.purchases.ui.revenuecatui.components.modifier.Border_Preview_LinearGradient (Border.kt:117)");
            }
            Modifier modifierO = androidx.compose.foundation.layout.SizeKt.o(Modifier.b8, Dp.g(100));
            Color.Companion companion = Color.f25715b;
            BoxKt.a(border(androidx.compose.foundation.BackgroundKt.d(modifierO, companion.i(), null, 2, null), new BorderStyle(Dp.g(10), ColorStyleKt.toColorStyle(new ColorInfo.Gradient.Linear(135.0f, CollectionsKt.listOf((Object[]) new ColorInfo.Gradient.Point[]{new ColorInfo.Gradient.Point(ColorKt.k(companion.c()), 10.0f), new ColorInfo.Gradient.Point(ColorKt.k(ColorKt.f(0, 102, 255, 0, 8, null)), 30.0f), new ColorInfo.Gradient.Point(ColorKt.k(ColorKt.f(160, 0, 160, 0, 8, null)), 80.0f)}))), null), shape), composerK, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.modifier.BorderKt.Border_Preview_LinearGradient.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i5) {
                    BorderKt.Border_Preview_LinearGradient(shape, composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Border_Preview_LinearGradientCircle(Composer composer, final int i3) {
        Composer composerK = composer.k(-873280999);
        if (i3 == 0 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(-873280999, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.components.modifier.Border_Preview_LinearGradientCircle (Border.kt:99)");
            }
            Border_Preview_LinearGradient(RoundedCornerShapeKt.g(), composerK, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.modifier.BorderKt.Border_Preview_LinearGradientCircle.1
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
                    BorderKt.Border_Preview_LinearGradientCircle(composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Border_Preview_LinearGradientSquare(Composer composer, final int i3) {
        Composer composerK = composer.k(328570534);
        if (i3 == 0 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(328570534, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.components.modifier.Border_Preview_LinearGradientSquare (Border.kt:93)");
            }
            Border_Preview_LinearGradient(RectangleShapeKt.a(), composerK, 6);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.modifier.BorderKt.Border_Preview_LinearGradientSquare.1
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
                    BorderKt.Border_Preview_LinearGradientSquare(composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Border_Preview_RadialGradient(final Shape shape, Composer composer, final int i3) {
        int i4;
        Composer composerK = composer.k(-1379549156);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(shape) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i4 & 3) == 2 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(-1379549156, i4, -1, "com.revenuecat.purchases.ui.revenuecatui.components.modifier.Border_Preview_RadialGradient (Border.kt:150)");
            }
            Modifier modifierO = androidx.compose.foundation.layout.SizeKt.o(Modifier.b8, Dp.g(100));
            Color.Companion companion = Color.f25715b;
            BoxKt.a(border(androidx.compose.foundation.BackgroundKt.d(modifierO, companion.i(), null, 2, null), new BorderStyle(Dp.g(10), ColorStyleKt.toColorStyle(new ColorInfo.Gradient.Radial(CollectionsKt.listOf((Object[]) new ColorInfo.Gradient.Point[]{new ColorInfo.Gradient.Point(ColorKt.k(companion.c()), 80.0f), new ColorInfo.Gradient.Point(ColorKt.k(ColorKt.f(0, 102, 255, 0, 8, null)), 90.0f), new ColorInfo.Gradient.Point(ColorKt.k(ColorKt.f(160, 0, 160, 0, 8, null)), 96.0f)}))), null), shape), composerK, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.modifier.BorderKt.Border_Preview_RadialGradient.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i5) {
                    BorderKt.Border_Preview_RadialGradient(shape, composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Border_Preview_RadialGradientCircle(Composer composer, final int i3) {
        Composer composerK = composer.k(-1718788077);
        if (i3 == 0 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(-1718788077, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.components.modifier.Border_Preview_RadialGradientCircle (Border.kt:111)");
            }
            Border_Preview_RadialGradient(RoundedCornerShapeKt.g(), composerK, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.modifier.BorderKt.Border_Preview_RadialGradientCircle.1
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
                    BorderKt.Border_Preview_RadialGradientCircle(composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Border_Preview_RadialGradientSquare(Composer composer, final int i3) {
        Composer composerK = composer.k(-516936544);
        if (i3 == 0 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(-516936544, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.components.modifier.Border_Preview_RadialGradientSquare (Border.kt:105)");
            }
            Border_Preview_RadialGradient(RectangleShapeKt.a(), composerK, 6);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.modifier.BorderKt.Border_Preview_RadialGradientSquare.1
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
                    BorderKt.Border_Preview_RadialGradientSquare(composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Border_Preview_Solid(Composer composer, final int i3) {
        Composer composerK = composer.k(-1171018009);
        if (i3 == 0 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(-1171018009, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.components.modifier.Border_Preview_Solid (Border.kt:42)");
            }
            Modifier modifierO = androidx.compose.foundation.layout.SizeKt.o(Modifier.b8, Dp.g(100));
            Color.Companion companion = Color.f25715b;
            BoxKt.a(border$default(androidx.compose.foundation.BackgroundKt.d(modifierO, companion.i(), null, 2, null), new BorderStyle(Dp.g(10), ColorStyle.Solid.m775boximpl(ColorStyle.Solid.m776constructorimpl(companion.b())), null), null, 2, null), composerK, 6);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.modifier.BorderKt.Border_Preview_Solid.1
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
                    BorderKt.Border_Preview_Solid(composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Border_Preview_SolidCircle(Composer composer, final int i3) {
        Composer composerK = composer.k(2094328983);
        if (i3 == 0 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(2094328983, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.components.modifier.Border_Preview_SolidCircle (Border.kt:76)");
            }
            Modifier modifierO = androidx.compose.foundation.layout.SizeKt.o(Modifier.b8, Dp.g(100));
            Color.Companion companion = Color.f25715b;
            BoxKt.a(border(androidx.compose.foundation.BackgroundKt.d(modifierO, companion.i(), null, 2, null), new BorderStyle(Dp.g(10), ColorStyle.Solid.m775boximpl(ColorStyle.Solid.m776constructorimpl(companion.b())), null), RoundedCornerShapeKt.g()), composerK, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.modifier.BorderKt.Border_Preview_SolidCircle.1
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
                    BorderKt.Border_Preview_SolidCircle(composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Border_Preview_SolidThin(Composer composer, final int i3) {
        Composer composerK = composer.k(471558496);
        if (i3 == 0 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(471558496, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.components.modifier.Border_Preview_SolidThin (Border.kt:59)");
            }
            Modifier modifierO = androidx.compose.foundation.layout.SizeKt.o(Modifier.b8, Dp.g(100));
            Color.Companion companion = Color.f25715b;
            BoxKt.a(border$default(androidx.compose.foundation.BackgroundKt.d(modifierO, companion.i(), null, 2, null), new BorderStyle(Dp.g(2), ColorStyle.Solid.m775boximpl(ColorStyle.Solid.m776constructorimpl(companion.b())), null), null, 2, null), composerK, 6);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.modifier.BorderKt.Border_Preview_SolidThin.1
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
                    BorderKt.Border_Preview_SolidThin(composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    public static final /* synthetic */ Modifier border(Modifier modifier, BorderStyle border, Shape shape) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(border, "border");
        Intrinsics.checkNotNullParameter(shape, "shape");
        return m740borderziNgDLE(modifier, border.m763getWidthD9Ej5fM(), border.getColor(), shape);
    }

    public static /* synthetic */ Modifier border$default(Modifier modifier, BorderStyle borderStyle, Shape shape, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            shape = RectangleShapeKt.a();
        }
        return border(modifier, borderStyle, shape);
    }

    /* JADX INFO: renamed from: border-ziNgDLE, reason: not valid java name */
    public static final /* synthetic */ Modifier m740borderziNgDLE(Modifier border, float f3, ColorStyle colorStyle, Shape shape) {
        Intrinsics.checkNotNullParameter(border, "$this$border");
        Intrinsics.checkNotNullParameter(colorStyle, "colorStyle");
        Intrinsics.checkNotNullParameter(shape, "shape");
        if (colorStyle instanceof ColorStyle.Solid) {
            return androidx.compose.foundation.BorderKt.f(border, f3, ((ColorStyle.Solid) colorStyle).m782unboximpl(), shape);
        }
        if (colorStyle instanceof ColorStyle.Gradient) {
            return androidx.compose.foundation.BorderKt.h(border, f3, ((ColorStyle.Gradient) colorStyle).m774unboximpl(), shape);
        }
        throw new NoWhenBranchMatchedException();
    }
}
