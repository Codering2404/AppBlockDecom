package com.revenuecat.purchases.ui.revenuecatui.composables;

import androidx.compose.animation.core.SnapSpec;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.IndicationKt;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.ColorScheme;
import androidx.compose.material3.ContentColorKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.RippleKt;
import androidx.compose.material3.Shapes;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Dp;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.revenuecat.purchases.ui.revenuecatui.components.modifier.BackgroundKt;
import com.revenuecat.purchases.ui.revenuecatui.components.modifier.BorderKt;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ColorStyle;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
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
public final class SwitchKt {
    private static final TweenSpec<Float> AnimationSpec;
    private static final SnapSpec<Float> SnapSpec;
    private static final float SwitchHeight;
    private static final float SwitchWidth;
    private static final float ThumbDiameter;
    private static final float ThumbPadding;
    private static final float UncheckedThumbDiameter;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[ShapeKeyTokens.values().length];
            try {
                iArr[ShapeKeyTokens.CornerFull.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[ColorSchemeKeyTokens.values().length];
            try {
                iArr2[ColorSchemeKeyTokens.OnPrimary.ordinal()] = 1;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr2[ColorSchemeKeyTokens.OnPrimaryContainer.ordinal()] = 2;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[ColorSchemeKeyTokens.OnSurface.ordinal()] = 3;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[ColorSchemeKeyTokens.Outline.ordinal()] = 4;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[ColorSchemeKeyTokens.Primary.ordinal()] = 5;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[ColorSchemeKeyTokens.Surface.ordinal()] = 6;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[ColorSchemeKeyTokens.SurfaceContainerHighest.ordinal()] = 7;
            } catch (NoSuchFieldError unused8) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    static {
        SwitchTokens switchTokens = SwitchTokens.INSTANCE;
        float fM934getSelectedHandleWidthD9Ej5fM = switchTokens.m934getSelectedHandleWidthD9Ej5fM();
        ThumbDiameter = fM934getSelectedHandleWidthD9Ej5fM;
        UncheckedThumbDiameter = switchTokens.m939getUnselectedHandleWidthD9Ej5fM();
        SwitchWidth = switchTokens.m938getTrackWidthD9Ej5fM();
        float fM936getTrackHeightD9Ej5fM = switchTokens.m936getTrackHeightD9Ej5fM();
        SwitchHeight = fM936getTrackHeightD9Ej5fM;
        ThumbPadding = Dp.g(Dp.g(fM936getTrackHeightD9Ej5fM - fM934getSelectedHandleWidthD9Ej5fM) / 2);
        SnapSpec = new SnapSpec<>(0, 1, null);
        AnimationSpec = new TweenSpec<>(100, 0, null, 6, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x016b  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0184  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x01b2  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x01b9  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x01d4  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x021e  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x022d  */
    /* JADX WARN: Removed duplicated region for block: B:132:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0115  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void Switch(final boolean r37, final kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> r38, androidx.compose.ui.Modifier r39, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r40, boolean r41, com.revenuecat.purchases.ui.revenuecatui.composables.SwitchColors r42, androidx.compose.foundation.interaction.MutableInteractionSource r43, androidx.compose.runtime.Composer r44, final int r45, final int r46) {
        /*
            Method dump skipped, instruction units count: 572
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.ui.revenuecatui.composables.SwitchKt.Switch(boolean, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function2, boolean, com.revenuecat.purchases.ui.revenuecatui.composables.SwitchColors, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void SwitchImpl(final Modifier modifier, final boolean z2, final boolean z3, final SwitchColors switchColors, final Function2<? super Composer, ? super Integer, Unit> function2, final InteractionSource interactionSource, final Shape shape, Composer composer, final int i3) {
        int i4;
        Composer composerK = composer.k(871043204);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(modifier) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.b(z2) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.b(z3) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            i4 |= composerK.Z(switchColors) ? 2048 : 1024;
        }
        if ((i3 & 24576) == 0) {
            i4 |= composerK.I(function2) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        }
        if ((196608 & i3) == 0) {
            i4 |= composerK.Z(interactionSource) ? 131072 : NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
        }
        if ((1572864 & i3) == 0) {
            i4 |= composerK.Z(shape) ? 1048576 : 524288;
        }
        if ((599187 & i4) == 599186 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(871043204, i4, -1, "com.revenuecat.purchases.ui.revenuecatui.composables.SwitchImpl (Switch.kt:256)");
            }
            ColorStyle colorStyleTrackColor$revenuecatui_defaultsBc8Release = switchColors.trackColor$revenuecatui_defaultsBc8Release(z3, z2);
            ColorStyle colorStyleThumbColor$revenuecatui_defaultsBc8Release = switchColors.thumbColor$revenuecatui_defaultsBc8Release(z3, z2);
            SwitchTokens switchTokens = SwitchTokens.INSTANCE;
            Shape value = getValue(switchTokens.getTrackShape(), composerK, 6);
            Modifier modifierBackground = BackgroundKt.background(BorderKt.m740borderziNgDLE(modifier, switchTokens.m937getTrackOutlineWidthD9Ej5fM(), switchColors.borderColor$revenuecatui_defaultsBc8Release(z3, z2), value), colorStyleTrackColor$revenuecatui_defaultsBc8Release, value);
            Alignment.Companion companion = Alignment.f25072a;
            MeasurePolicy measurePolicyG = BoxKt.g(companion.o(), false);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierBackground);
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
            Modifier modifierBackground2 = BackgroundKt.background(IndicationKt.b(BoxScopeInstance.f6642a.f(Modifier.b8, companion.h()).then(new ThumbElement(interactionSource, z2)), interactionSource, RippleKt.c(false, Dp.g(switchTokens.m935getStateLayerSizeD9Ej5fM() / 2), 0L, 4, null)), colorStyleThumbColor$revenuecatui_defaultsBc8Release, shape);
            MeasurePolicy measurePolicyG2 = BoxKt.g(companion.e(), false);
            int iA2 = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU2 = composerK.u();
            Modifier modifierF2 = ComposedModifierKt.f(composerK, modifierBackground2);
            Function0 function0A2 = companion2.a();
            if (composerK.m() == null) {
                ComposablesKt.c();
            }
            composerK.L();
            if (composerK.i()) {
                composerK.P(function0A2);
            } else {
                composerK.v();
            }
            Composer composerA2 = Updater.a(composerK);
            Updater.e(composerA2, measurePolicyG2, companion2.e());
            Updater.e(composerA2, compositionLocalMapU2, companion2.g());
            Function2 function2B2 = companion2.b();
            if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                composerA2.w(Integer.valueOf(iA2));
                composerA2.p(Integer.valueOf(iA2), function2B2);
            }
            Updater.e(composerA2, modifierF2, companion2.f());
            composerK.a0(-1860834223);
            if (function2 != null) {
                CompositionLocalKt.b(ContentColorKt.a().d(Color.n(switchColors.m931iconColorWaAFU9c$revenuecatui_defaultsBc8Release(z3, z2))), function2, composerK, ProvidedValue.f24012i | ((i4 >> 9) & 112));
            }
            composerK.U();
            composerK.y();
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.SwitchKt.SwitchImpl.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i5) {
                    SwitchKt.SwitchImpl(modifier, z2, z3, switchColors, function2, interactionSource, shape, composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    private static final Shape fromToken(Shapes shapes, ShapeKeyTokens shapeKeyTokens) {
        if (WhenMappings.$EnumSwitchMapping$0[shapeKeyTokens.ordinal()] == 1) {
            return RoundedCornerShapeKt.g();
        }
        throw new NoWhenBranchMatchedException();
    }

    private static final Shape getValue(ShapeKeyTokens shapeKeyTokens, Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(2130513227, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.composables.<get-value> (Switch.kt:464)");
        }
        Shape shapeFromToken = fromToken(MaterialTheme.f18110a.b(composer, MaterialTheme.f18111b), shapeKeyTokens);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return shapeFromToken;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long getValue(ColorSchemeKeyTokens colorSchemeKeyTokens, Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(-323273324, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.composables.<get-value> (Switch.kt:468)");
        }
        long jFromToken = fromToken(MaterialTheme.f18110a.a(composer, MaterialTheme.f18111b), colorSchemeKeyTokens);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return jFromToken;
    }

    private static final long fromToken(ColorScheme colorScheme, ColorSchemeKeyTokens colorSchemeKeyTokens) {
        switch (WhenMappings.$EnumSwitchMapping$1[colorSchemeKeyTokens.ordinal()]) {
            case 1:
                return colorScheme.Z();
            case 2:
                return colorScheme.a0();
            case 3:
                return colorScheme.d0();
            case 4:
                return colorScheme.h0();
            case 5:
                return colorScheme.j0();
            case 6:
                return colorScheme.o0();
            case 7:
                return colorScheme.s0();
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}
