package cz.mobilesoft.coreblock.view.compose.material3;

import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.RichTooltipColors;
import androidx.compose.material3.TextKt;
import androidx.compose.material3.TooltipDefaults;
import androidx.compose.material3.TooltipScope;
import androidx.compose.material3.TooltipState;
import androidx.compose.material3.Tooltip_androidKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.res.PrimitiveResources_androidKt;
import androidx.compose.ui.unit.Dp;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class TooltipKt {
    public static final void g(final String str, Modifier modifier, TooltipState tooltipState, final Function2 anchor, Composer composer, final int i3, final int i4) {
        int i5;
        TooltipState tooltipState2;
        Composer composer2;
        final Modifier modifier2;
        final TooltipState tooltipState3;
        Composer composer3;
        TooltipState tooltipStateM;
        Modifier modifier3;
        int i6;
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        Composer composerK = composer.k(-948972687);
        if ((i3 & 6) == 0) {
            i5 = (composerK.Z(str) ? 4 : 2) | i3;
        } else {
            i5 = i3;
        }
        int i7 = i4 & 2;
        if (i7 != 0) {
            i5 |= 48;
        } else if ((i3 & 48) == 0) {
            i5 |= composerK.Z(modifier) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            if ((i4 & 4) == 0) {
                tooltipState2 = tooltipState;
                if (composerK.I(tooltipState2)) {
                    i6 = Function.MAX_NARGS;
                }
                i5 |= i6;
            } else {
                tooltipState2 = tooltipState;
            }
            i6 = ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
            i5 |= i6;
        } else {
            tooltipState2 = tooltipState;
        }
        if ((i3 & 3072) == 0) {
            i5 |= composerK.I(anchor) ? 2048 : 1024;
        }
        if (composerK.r((i5 & 1171) != 1170, i5 & 1)) {
            composerK.J();
            if ((i3 & 1) == 0 || composerK.S()) {
                Modifier modifier4 = i7 != 0 ? Modifier.b8 : modifier;
                composer3 = composerK;
                if ((i4 & 4) != 0) {
                    i5 &= -897;
                    tooltipStateM = androidx.compose.material3.TooltipKt.m(false, true, null, composer3, 48, 5);
                } else {
                    tooltipStateM = tooltipState2;
                }
                modifier3 = modifier4;
            } else {
                composerK.Q();
                if ((i4 & 4) != 0) {
                    i5 &= -897;
                }
                modifier3 = modifier;
                tooltipStateM = tooltipState2;
                composer3 = composerK;
            }
            composer3.z();
            if (ComposerKt.M()) {
                ComposerKt.U(-948972687, i5, -1, "cz.mobilesoft.coreblock.view.compose.material3.AppBlockTooltip (Tooltip.kt:49)");
            }
            Composer composer4 = composer3;
            androidx.compose.material3.TooltipKt.a(TooltipDefaults.f21443a.g(Dp.g(8), composer3, (TooltipDefaults.f21445c << 3) | 6, 0), ComposableLambdaKt.e(1973081884, true, new Function3() { // from class: cz.mobilesoft.coreblock.view.compose.material3.j2
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return TooltipKt.h(str, (TooltipScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer3, 54), tooltipStateM, modifier3, false, false, anchor, composer4, (i5 & 896) | 48 | ((i5 << 6) & 7168) | ((i5 << 9) & 3670016), 48);
            composer2 = composer4;
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
            tooltipState3 = tooltipStateM;
            modifier2 = modifier3;
        } else {
            composer2 = composerK;
            composer2.Q();
            modifier2 = modifier;
            tooltipState3 = tooltipState2;
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.view.compose.material3.k2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TooltipKt.j(str, modifier2, tooltipState3, anchor, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h(final String str, TooltipScope TooltipBox, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(TooltipBox, "$this$TooltipBox");
        if (ComposerKt.M()) {
            ComposerKt.U(1973081884, i3, -1, "cz.mobilesoft.coreblock.view.compose.material3.AppBlockTooltip.<anonymous> (Tooltip.kt:56)");
        }
        if (str == null || StringsKt.p0(str)) {
            composer.a0(-842233850);
        } else {
            composer.a0(-839934270);
            Tooltip_androidKt.b(TooltipBox, null, null, null, 0L, RoundedCornerShapeKt.d(PrimitiveResources_androidKt.a(R.dimen.f95480n, composer, 0)), new RichTooltipColors(ComposeColorsKt.j(composer, 0).l0(), ComposeColorsKt.j(composer, 0).p(), ComposeColorsKt.j(composer, 0).p(), ComposeColorsKt.j(composer, 0).p(), null), 0.0f, 0.0f, ComposableLambdaKt.e(299691211, true, new Function2() { // from class: cz.mobilesoft.coreblock.view.compose.material3.l2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TooltipKt.i(str, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, (i3 & 14) | 805306368, 207);
        }
        composer.U();
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i(String str, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(299691211, i3, -1, "cz.mobilesoft.coreblock.view.compose.material3.AppBlockTooltip.<anonymous>.<anonymous> (Tooltip.kt:66)");
            }
            TextKt.c(str, PaddingKt.j(Modifier.b8, Dp.g(8), Dp.g(16)), ComposeColorsKt.j(composer, 0).p(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).i(), composer, 48, 0, 65528);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j(String str, Modifier modifier, TooltipState tooltipState, Function2 function2, int i3, int i4, Composer composer, int i5) {
        g(str, modifier, tooltipState, function2, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:108:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:113:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00c0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void k(final java.lang.String r16, androidx.compose.ui.Modifier r17, androidx.compose.ui.graphics.vector.ImageVector r18, long r19, float r21, androidx.compose.material3.TooltipState r22, androidx.compose.runtime.Composer r23, final int r24, final int r25) {
        /*
            Method dump skipped, instruction units count: 441
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.view.compose.material3.TooltipKt.k(java.lang.String, androidx.compose.ui.Modifier, androidx.compose.ui.graphics.vector.ImageVector, long, float, androidx.compose.material3.TooltipState, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l(float f3, final CoroutineScope coroutineScope, final TooltipState tooltipState, ImageVector imageVector, long j3, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(380199761, i3, -1, "cz.mobilesoft.coreblock.view.compose.material3.AppBlockTooltipWithIcon.<anonymous> (Tooltip.kt:103)");
            }
            Modifier modifierV = SizeKt.v(Modifier.b8, f3);
            boolean zI = composer.I(coroutineScope) | composer.I(tooltipState);
            Object objG = composer.G();
            if (zI || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.view.compose.material3.i2
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return TooltipKt.m(coroutineScope, tooltipState);
                    }
                };
                composer.w(objG);
            }
            IconKt.d(imageVector, null, ClickableKt.f(modifierV, false, null, null, (Function0) objG, 7, null), j3, composer, 48, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m(CoroutineScope coroutineScope, TooltipState tooltipState) {
        BuildersKt__Builders_commonKt.d(coroutineScope, null, null, new TooltipKt$AppBlockTooltipWithIcon$1$1$1$1(tooltipState, null), 3, null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n(String str, Modifier modifier, ImageVector imageVector, long j3, float f3, TooltipState tooltipState, int i3, int i4, Composer composer, int i5) {
        k(str, modifier, imageVector, j3, f3, tooltipState, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }
}
