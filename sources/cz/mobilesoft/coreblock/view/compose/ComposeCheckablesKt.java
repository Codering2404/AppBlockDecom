package cz.mobilesoft.coreblock.view.compose;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material.IconKt;
import androidx.compose.material.SwitchColors;
import androidx.compose.material.SwitchKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.VectorResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Dp;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class ComposeCheckablesKt {
    /* JADX WARN: Removed duplicated region for block: B:115:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x01c4  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x01d6  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x021b  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0227  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x022b  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0258  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0303  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x0311  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0323  */
    /* JADX WARN: Removed duplicated region for block: B:158:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00fb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void h(final androidx.compose.runtime.State r32, final java.lang.String r33, androidx.compose.ui.Modifier r34, androidx.compose.ui.Modifier r35, androidx.compose.ui.text.TextStyle r36, long r37, float r39, kotlin.jvm.functions.Function1 r40, androidx.compose.runtime.Composer r41, final int r42, final int r43) {
        /*
            Method dump skipped, instruction units count: 818
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.view.compose.ComposeCheckablesKt.h(androidx.compose.runtime.State, java.lang.String, androidx.compose.ui.Modifier, androidx.compose.ui.Modifier, androidx.compose.ui.text.TextStyle, long, float, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i(State state, boolean z2) {
        if (state instanceof MutableState) {
            ((MutableState) state).setValue(Boolean.valueOf(z2));
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j(Function1 function1, State state) {
        function1.invoke(Boolean.valueOf(!((Boolean) state.getValue()).booleanValue()));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k(State state, String str, Modifier modifier, Modifier modifier2, TextStyle textStyle, long j3, float f3, Function1 function1, int i3, int i4, Composer composer, int i5) {
        h(state, str, modifier, modifier2, textStyle, j3, f3, function1, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x01b1  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x01ce  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x01e7  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x01ec  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x0203  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0208  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x021f  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x0224  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x023d  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x0242  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x0261  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x026e  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x0277  */
    /* JADX WARN: Removed duplicated region for block: B:327:0x055c  */
    /* JADX WARN: Removed duplicated region for block: B:330:0x0583  */
    /* JADX WARN: Removed duplicated region for block: B:332:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0121  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void l(androidx.compose.ui.Modifier r46, final androidx.compose.runtime.State r47, boolean r48, final java.lang.String r49, java.lang.String r50, androidx.compose.foundation.layout.PaddingValues r51, float r52, androidx.compose.ui.graphics.vector.ImageVector r53, androidx.compose.ui.unit.Dp r54, long r55, boolean r57, androidx.compose.ui.text.TextStyle r58, androidx.compose.ui.text.TextStyle r59, boolean r60, boolean r61, boolean r62, androidx.compose.material.SwitchColors r63, kotlin.jvm.functions.Function1 r64, kotlin.jvm.functions.Function0 r65, androidx.compose.runtime.Composer r66, final int r67, final int r68, final int r69) {
        /*
            Method dump skipped, instruction units count: 1435
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.view.compose.ComposeCheckablesKt.l(androidx.compose.ui.Modifier, androidx.compose.runtime.State, boolean, java.lang.String, java.lang.String, androidx.compose.foundation.layout.PaddingValues, float, androidx.compose.ui.graphics.vector.ImageVector, androidx.compose.ui.unit.Dp, long, boolean, androidx.compose.ui.text.TextStyle, androidx.compose.ui.text.TextStyle, boolean, boolean, boolean, androidx.compose.material.SwitchColors, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m(State state, boolean z2) {
        if (state instanceof MutableState) {
            ((MutableState) state).setValue(Boolean.valueOf(z2));
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n(boolean z2, Function0 function0, boolean z3, boolean z4, Function1 function1, State state) {
        if (z2) {
            if (function0 != null) {
                function0.invoke();
            }
        } else if (z3 || z4) {
            function1.invoke(Boolean.valueOf(!((Boolean) state.getValue()).booleanValue()));
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o(PaddingValues paddingValues, ImageVector imageVector, float f3, boolean z2, boolean z3, State state, boolean z4, boolean z5, SwitchColors switchColors, Function1 function1, Dp dp, long j3, String str, TextStyle textStyle, String str2, TextStyle textStyle2, Composer composer, int i3) {
        Arrangement arrangement;
        long jS;
        long jS2;
        int i4;
        SwitchColors switchColorsM;
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(2064982426, i3, -1, "cz.mobilesoft.coreblock.view.compose.SwitchLayout.<anonymous> (ComposeCheckables.kt:224)");
            }
            Alignment.Companion companion = Alignment.f25072a;
            Alignment.Vertical verticalI = companion.i();
            Modifier.Companion companion2 = Modifier.b8;
            Modifier modifierH = PaddingKt.h(SizeKt.k(companion2, Dp.g(48), 0.0f, 2, null), paddingValues);
            Arrangement arrangement2 = Arrangement.f6574a;
            MeasurePolicy measurePolicyB = RowKt.b(arrangement2.g(), verticalI, composer, 48);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, modifierH);
            ComposeUiNode.Companion companion3 = ComposeUiNode.f8;
            Function0 function0A = companion3.a();
            if (composer.m() == null) {
                ComposablesKt.c();
            }
            composer.L();
            if (composer.i()) {
                composer.P(function0A);
            } else {
                composer.v();
            }
            Composer composerA = Updater.a(composer);
            Updater.e(composerA, measurePolicyB, companion3.e());
            Updater.e(composerA, compositionLocalMapU, companion3.g());
            Function2 function2B = companion3.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion3.f());
            RowScopeInstance rowScopeInstance = RowScopeInstance.f7101a;
            if (imageVector == null) {
                composer.a0(-339558702);
                composer.U();
                arrangement = arrangement2;
            } else {
                composer.a0(-339558701);
                arrangement = arrangement2;
                IconKt.b(imageVector, null, dp != null ? SizeKt.v(PaddingKt.m(companion2, 0.0f, 0.0f, f3, 0.0f, 11, null), dp.l()) : PaddingKt.m(companion2, 0.0f, 0.0f, f3, 0.0f, 11, null), j3, composer, 48, 0);
                Unit unit = Unit.f139807a;
                composer.U();
            }
            Arrangement.HorizontalOrVertical horizontalOrVerticalO = arrangement.o(Dp.g(4));
            Modifier modifierC = RowScope.c(rowScopeInstance, PaddingKt.m(companion2, 0.0f, 0.0f, f3, 0.0f, 11, null), 1.0f, false, 2, null);
            MeasurePolicy measurePolicyA = ColumnKt.a(horizontalOrVerticalO, companion.k(), composer, 6);
            int iA2 = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU2 = composer.u();
            Modifier modifierF2 = ComposedModifierKt.f(composer, modifierC);
            Function0 function0A2 = companion3.a();
            if (composer.m() == null) {
                ComposablesKt.c();
            }
            composer.L();
            if (composer.i()) {
                composer.P(function0A2);
            } else {
                composer.v();
            }
            Composer composerA2 = Updater.a(composer);
            Updater.e(composerA2, measurePolicyA, companion3.e());
            Updater.e(composerA2, compositionLocalMapU2, companion3.g());
            Function2 function2B2 = companion3.b();
            if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                composerA2.w(Integer.valueOf(iA2));
                composerA2.p(Integer.valueOf(iA2), function2B2);
            }
            Updater.e(composerA2, modifierF2, companion3.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            if (z5) {
                composer.a0(1841844864);
                jS = ComposeColorsKt.j(composer, 0).p();
            } else {
                composer.a0(1841845665);
                jS = ComposeColorsKt.j(composer, 0).s();
            }
            composer.U();
            androidx.compose.material.TextKt.c(str, null, jS, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, textStyle, composer, 0, 0, 65530);
            Composer composer2 = composer;
            if (str2 == null) {
                composer2.a0(1262708069);
            } else {
                composer2.a0(1262708070);
                if (z5) {
                    composer2.a0(-139544445);
                    jS2 = ComposeColorsKt.j(composer2, 0).q();
                } else {
                    composer2.a0(-139543613);
                    jS2 = ComposeColorsKt.j(composer2, 0).s();
                }
                composer2.U();
                androidx.compose.material.TextKt.c(str2, null, jS2, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, textStyle2, composer, 0, 0, 65530);
                composer2 = composer;
                Unit unit2 = Unit.f139807a;
            }
            composer2.U();
            composer2.y();
            if (z2) {
                composer2.a0(-338254190);
                i4 = 6;
                androidx.compose.foundation.ImageKt.b(VectorResources_androidKt.b(ImageVector.f26323k, R.drawable.f95524i2, composer2, 6), null, null, null, null, 0.0f, null, composer, 48, 124);
                composer2 = composer;
            } else {
                i4 = 6;
                composer2.a0(-348691580);
            }
            composer2.U();
            if (z3) {
                composer2.a0(-338008112);
                androidx.compose.foundation.ImageKt.b(VectorResources_androidKt.b(ImageVector.f26323k, R.drawable.u4, composer2, i4), null, null, null, null, 0.0f, null, composer2, 48, 124);
                composer2.U();
            } else {
                composer2.a0(-337769536);
                boolean zBooleanValue = ((Boolean) state.getValue()).booleanValue();
                boolean z6 = z4 ? true : z5;
                if (switchColors == null) {
                    if (!z4 || z5) {
                        composer2.a0(1651682250);
                        switchColorsM = ComposeColorsKt.m(composer2, 0);
                    } else {
                        composer2.a0(1651681147);
                        switchColorsM = ComposeColorsKt.i(composer2, 0);
                    }
                    composer2.U();
                } else {
                    switchColorsM = switchColors;
                }
                SwitchKt.a(zBooleanValue, function1, null, z6, null, switchColorsM, composer2, 0, 20);
                composer.U();
            }
            composer.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p(Modifier modifier, State state, boolean z2, String str, String str2, PaddingValues paddingValues, float f3, ImageVector imageVector, Dp dp, long j3, boolean z3, TextStyle textStyle, TextStyle textStyle2, boolean z4, boolean z5, boolean z6, SwitchColors switchColors, Function1 function1, Function0 function0, int i3, int i4, int i5, Composer composer, int i6) {
        l(modifier, state, z2, str, str2, paddingValues, f3, imageVector, dp, j3, z3, textStyle, textStyle2, z4, z5, z6, switchColors, function1, function0, composer, RecomposeScopeImplKt.a(i3 | 1), RecomposeScopeImplKt.a(i4), i5);
        return Unit.f139807a;
    }
}
