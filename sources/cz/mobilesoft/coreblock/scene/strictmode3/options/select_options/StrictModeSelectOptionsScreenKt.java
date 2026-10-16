package cz.mobilesoft.coreblock.scene.strictmode3.options.select_options;

import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material.TextKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.PrimitiveResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Dp;
import com.facebook.internal.Utility;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.enums.StrictModeOption;
import cz.mobilesoft.coreblock.scene.strictmode3.options.StrictModeOptionsViewEvent;
import cz.mobilesoft.coreblock.scene.strictmode3.options.StrictModeOptionsViewState;
import cz.mobilesoft.coreblock.scene.strictmode3.options.select_options.StrictModeSelectOptionsScreenKt;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.view.compose.ButtonColor;
import cz.mobilesoft.coreblock.view.compose.ButtonType;
import cz.mobilesoft.coreblock.view.compose.ComposeButtonsKt;
import cz.mobilesoft.coreblock.view.compose.ComposeCheckablesKt;
import cz.mobilesoft.coreblock.view.compose.ComposeCommonsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.collections.immutable.ImmutableList;

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
public final class StrictModeSelectOptionsScreenKt {
    private static final void k(final ImmutableList immutableList, final ImmutableList immutableList2, final PaddingValues paddingValues, final Function1 function1, final boolean z2, Composer composer, final int i3) {
        Composer composerK = composer.k(1899012832);
        int i4 = (i3 & 6) == 0 ? (composerK.Z(immutableList) ? 4 : 2) | i3 : i3;
        if ((i3 & 48) == 0) {
            i4 |= composerK.Z(immutableList2) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.Z(paddingValues) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            i4 |= composerK.I(function1) ? 2048 : 1024;
        }
        if ((i3 & 24576) == 0) {
            i4 |= composerK.b(z2) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        }
        if (composerK.r((i4 & 9363) != 9362, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1899012832, i4, -1, "cz.mobilesoft.coreblock.scene.strictmode3.options.select_options.Content (StrictModeSelectOptionsScreen.kt:84)");
            }
            Modifier.Companion companion = Modifier.b8;
            float f3 = 16;
            Modifier modifierM = PaddingKt.m(PaddingKt.k(PaddingKt.h(ScrollKt.g(SizeKt.f(companion, 0.0f, 1, null), ScrollKt.c(0, composerK, 0, 1), false, null, false, 14, null), paddingValues), PrimitiveResources_androidKt.a(R.dimen.f95467a, composerK, 0), 0.0f, 2, null), 0.0f, 0.0f, 0.0f, Dp.g(f3), 7, null);
            MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.o(Dp.g(f3)), Alignment.f25072a.k(), composerK, 6);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierM);
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
            float f4 = 8;
            TextKt.c(StringResources_androidKt.b(R.string.Fz, composerK, 0), PaddingKt.m(PaddingKt.k(companion, Dp.g(f4), 0.0f, 2, null), 0.0f, 0.0f, 0.0f, Dp.g(f4), 7, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composerK, 0).a(), composerK, 48, 0, 65532);
            composerK = composerK;
            composerK.a0(1539773899);
            for (StrictModeOption strictModeOption : StrictModeOption.getEntries()) {
                if (strictModeOption.isOptionAvailable()) {
                    composerK.a0(-740763067);
                    m(immutableList.contains(strictModeOption), z2 || !immutableList2.contains(strictModeOption), strictModeOption, function1, composerK, i4 & 7168, 0);
                } else {
                    composerK.a0(-745024916);
                }
                composerK.U();
            }
            composerK.U();
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: b2.f
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return StrictModeSelectOptionsScreenKt.l(immutableList, immutableList2, paddingValues, function1, z2, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l(ImmutableList immutableList, ImmutableList immutableList2, PaddingValues paddingValues, Function1 function1, boolean z2, int i3, Composer composer, int i4) {
        k(immutableList, immutableList2, paddingValues, function1, z2, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:70:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final void m(boolean r20, boolean r21, cz.mobilesoft.coreblock.enums.StrictModeOption r22, final kotlin.jvm.functions.Function1 r23, androidx.compose.runtime.Composer r24, final int r25, final int r26) {
        /*
            Method dump skipped, instruction units count: 262
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.strictmode3.options.select_options.StrictModeSelectOptionsScreenKt.m(boolean, boolean, cz.mobilesoft.coreblock.enums.StrictModeOption, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o(final StrictModeOption strictModeOption, boolean z2, State state, final Function1 function1, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1312547403, i3, -1, "cz.mobilesoft.coreblock.scene.strictmode3.options.select_options.StrictModeConditionCard.<anonymous> (StrictModeSelectOptionsScreen.kt:130)");
            }
            boolean z3 = strictModeOption == StrictModeOption.BlockEditing ? false : z2;
            String strB = StringResources_androidKt.b(strictModeOption.getTitle(), composer, 0);
            String strB2 = StringResources_androidKt.b(strictModeOption.getSubtitle(), composer, 0);
            Modifier modifierH = SizeKt.h(Modifier.b8, 0.0f, 1, null);
            PaddingValues paddingValuesA = PaddingKt.a(Dp.g(16));
            TextStyle textStyleI = ComposeTypographyKt.g(composer, 0).i();
            TextStyle textStyleD = ComposeTypographyKt.g(composer, 0).d();
            boolean Z = composer.Z(function1) | composer.e(strictModeOption.ordinal());
            Object objG = composer.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = new Function1() { // from class: b2.a
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return StrictModeSelectOptionsScreenKt.p(function1, strictModeOption, ((Boolean) obj).booleanValue());
                    }
                };
                composer.w(objG);
            }
            ComposeCheckablesKt.l(modifierH, state, z3, strB, strB2, paddingValuesA, 0.0f, null, null, 0L, false, textStyleI, textStyleD, false, false, false, null, (Function1) objG, null, composer, 196614, 0, 387008);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p(Function1 function1, StrictModeOption strictModeOption, boolean z2) {
        function1.invoke(new StrictModeOptionsViewEvent.OnOptionClicked(strictModeOption));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit q(boolean z2, boolean z3, StrictModeOption strictModeOption, Function1 function1, int i3, int i4, Composer composer, int i5) {
        m(z2, z3, strictModeOption, function1, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:63:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void r(final cz.mobilesoft.coreblock.scene.strictmode3.options.StrictModeOptionsViewState r34, final kotlin.jvm.functions.Function1 r35, boolean r36, final kotlin.jvm.functions.Function1 r37, final kotlin.jvm.functions.Function0 r38, androidx.compose.runtime.Composer r39, final int r40, final int r41) {
        /*
            Method dump skipped, instruction units count: 279
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.strictmode3.options.select_options.StrictModeSelectOptionsScreenKt.r(cz.mobilesoft.coreblock.scene.strictmode3.options.StrictModeOptionsViewState, kotlin.jvm.functions.Function1, boolean, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit s(final Function1 function1, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1116800764, i3, -1, "cz.mobilesoft.coreblock.scene.strictmode3.options.select_options.StrictModeSelectOptionsScreen.<anonymous> (StrictModeSelectOptionsScreen.kt:46)");
            }
            String strB = StringResources_androidKt.b(R.string.Gz, composer, 0);
            boolean Z = composer.Z(function1);
            Object objG = composer.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: b2.g
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return StrictModeSelectOptionsScreenKt.t(function1);
                    }
                };
                composer.w(objG);
            }
            ComposeCommonsKt.n(strB, (Function0) objG, null, composer, 0, 4);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit t(Function1 function1) {
        function1.invoke(Boolean.FALSE);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit u(Function0 function0, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-671263453, i3, -1, "cz.mobilesoft.coreblock.scene.strictmode3.options.select_options.StrictModeSelectOptionsScreen.<anonymous> (StrictModeSelectOptionsScreen.kt:61)");
            }
            Modifier modifierM = PaddingKt.m(PaddingKt.k(Modifier.b8, PrimitiveResources_androidKt.a(R.dimen.f95467a, composer, 0), 0.0f, 2, null), 0.0f, 0.0f, 0.0f, Dp.g(10), 7, null);
            MeasurePolicy measurePolicyG = BoxKt.g(Alignment.f25072a.o(), false);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, modifierM);
            ComposeUiNode.Companion companion = ComposeUiNode.f8;
            Function0 function0A = companion.a();
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
            Updater.e(composerA, measurePolicyG, companion.e());
            Updater.e(composerA, compositionLocalMapU, companion.g());
            Function2 function2B = companion.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion.f());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
            ComposeButtonsKt.i0(null, new ButtonType.Big(null, null, StringResources_androidKt.b(R.string.l8, composer, 0), 0.0f, 11, null), new ButtonColor.Accent(false, null, false, null, 15, null), function0, composer, 0, 1);
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
    public static final Unit v(StrictModeOptionsViewState strictModeOptionsViewState, Function1 function1, boolean z2, PaddingValues it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(it, "it");
        if ((i3 & 6) == 0) {
            i3 |= composer.Z(it) ? 4 : 2;
        }
        if (composer.r((i3 & 19) != 18, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1313152981, i3, -1, "cz.mobilesoft.coreblock.scene.strictmode3.options.select_options.StrictModeSelectOptionsScreen.<anonymous> (StrictModeSelectOptionsScreen.kt:52)");
            }
            k(strictModeOptionsViewState.d(), strictModeOptionsViewState.c(), it, function1, z2, composer, (i3 << 6) & 896);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit w(StrictModeOptionsViewState strictModeOptionsViewState, Function1 function1, boolean z2, Function1 function12, Function0 function0, int i3, int i4, Composer composer, int i5) {
        r(strictModeOptionsViewState, function1, z2, function12, function0, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean n(boolean z2) {
        return z2;
    }
}
