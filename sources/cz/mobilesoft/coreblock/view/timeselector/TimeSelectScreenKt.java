package cz.mobilesoft.coreblock.view.timeselector;

import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.IntrinsicKt;
import androidx.compose.foundation.layout.IntrinsicSize;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.DividerKt;
import androidx.compose.material.ScaffoldKt;
import androidx.compose.material.ScaffoldState;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.SubcomposeLayoutKt;
import androidx.compose.ui.layout.SubcomposeMeasureScope;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.PrimitiveResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Dp;
import com.applovin.sdk.AppLovinEventTypes;
import com.facebook.internal.Utility;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.util.analytics.AnswersHelper;
import cz.mobilesoft.coreblock.util.compose.FlowExtKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.view.compose.ComposeButtonsKt;
import cz.mobilesoft.coreblock.view.compose.material3.ToolbarKt;
import cz.mobilesoft.coreblock.view.timepicker.ComposeSwipeableTimePickerKt;
import cz.mobilesoft.coreblock.view.timepicker.TimePickerConfig;
import cz.mobilesoft.coreblock.view.timepicker.TimePickerViewModel;
import cz.mobilesoft.coreblock.view.timepicker.TimePickerViewState;
import cz.mobilesoft.coreblock.view.timepicker.config.TimePickerConfiguration;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.parameter.ParametersHolderKt;

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
public final class TimeSelectScreenKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit A(TimePickerViewState timePickerViewState, Function1 function1, PaddingValues it, Composer composer, int i3) {
        int i4;
        int i5;
        Composer composer2 = composer;
        Intrinsics.checkNotNullParameter(it, "it");
        if ((i3 & 6) == 0) {
            i4 = i3 | (composer2.Z(it) ? 4 : 2);
        } else {
            i4 = i3;
        }
        if (composer2.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1598394647, i4, -1, "cz.mobilesoft.coreblock.view.timeselector.RootCompose.<anonymous> (TimeSelectScreen.kt:160)");
            }
            Modifier.Companion companion = Modifier.b8;
            Modifier modifierK = PaddingKt.k(PaddingKt.h(companion, it), PrimitiveResources_androidKt.a(R.dimen.f95467a, composer2, 0), 0.0f, 2, null);
            Alignment.Companion companion2 = Alignment.f25072a;
            Alignment.Horizontal horizontalG = companion2.g();
            Arrangement arrangement = Arrangement.f6574a;
            MeasurePolicy measurePolicyA = ColumnKt.a(arrangement.h(), horizontalG, composer2, 48);
            int iA = ComposablesKt.a(composer2, 0);
            CompositionLocalMap compositionLocalMapU = composer2.u();
            Modifier modifierF = ComposedModifierKt.f(composer2, modifierK);
            ComposeUiNode.Companion companion3 = ComposeUiNode.f8;
            Function0 function0A = companion3.a();
            if (composer2.m() == null) {
                ComposablesKt.c();
            }
            composer2.L();
            if (composer2.i()) {
                composer2.P(function0A);
            } else {
                composer2.v();
            }
            Composer composerA = Updater.a(composer2);
            Updater.e(composerA, measurePolicyA, companion3.e());
            Updater.e(composerA, compositionLocalMapU, companion3.g());
            Function2 function2B = companion3.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion3.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            if (timePickerViewState.s()) {
                composer2.a0(1867492683);
                float f3 = 16;
                Modifier modifierI = PaddingKt.i(companion, Dp.g(f3));
                MeasurePolicy measurePolicyG = BoxKt.g(companion2.o(), false);
                int iA2 = ComposablesKt.a(composer2, 0);
                CompositionLocalMap compositionLocalMapU2 = composer2.u();
                Modifier modifierF2 = ComposedModifierKt.f(composer2, modifierI);
                Function0 function0A2 = companion3.a();
                if (composer2.m() == null) {
                    ComposablesKt.c();
                }
                composer2.L();
                if (composer2.i()) {
                    composer2.P(function0A2);
                } else {
                    composer2.v();
                }
                Composer composerA2 = Updater.a(composer2);
                Updater.e(composerA2, measurePolicyG, companion3.e());
                Updater.e(composerA2, compositionLocalMapU2, companion3.g());
                Function2 function2B2 = companion3.b();
                if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                    composerA2.w(Integer.valueOf(iA2));
                    composerA2.p(Integer.valueOf(iA2), function2B2);
                }
                Updater.e(composerA2, modifierF2, companion3.f());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
                Arrangement.HorizontalOrVertical horizontalOrVerticalD = arrangement.d();
                float f4 = 2;
                Modifier modifierI2 = PaddingKt.i(IntrinsicKt.a(SizeKt.h(BorderKt.f(companion, Dp.g(f4), ComposeColorsKt.j(composer2, 0).M(), RoundedCornerShapeKt.d(Dp.g(f3))), 0.0f, 1, null), IntrinsicSize.f6986a), Dp.g(f3));
                MeasurePolicy measurePolicyB = RowKt.b(horizontalOrVerticalD, companion2.l(), composer2, 6);
                int iA3 = ComposablesKt.a(composer2, 0);
                CompositionLocalMap compositionLocalMapU3 = composer2.u();
                Modifier modifierF3 = ComposedModifierKt.f(composer2, modifierI2);
                Function0 function0A3 = companion3.a();
                if (composer2.m() == null) {
                    ComposablesKt.c();
                }
                composer2.L();
                if (composer2.i()) {
                    composer2.P(function0A3);
                } else {
                    composer2.v();
                }
                Composer composerA3 = Updater.a(composer2);
                Updater.e(composerA3, measurePolicyB, companion3.e());
                Updater.e(composerA3, compositionLocalMapU3, companion3.g());
                Function2 function2B3 = companion3.b();
                if (composerA3.i() || !Intrinsics.areEqual(composerA3.G(), Integer.valueOf(iA3))) {
                    composerA3.w(Integer.valueOf(iA3));
                    composerA3.p(Integer.valueOf(iA3), function2B3);
                }
                Updater.e(composerA3, modifierF3, companion3.f());
                RowScopeInstance rowScopeInstance = RowScopeInstance.f7101a;
                i5 = 6;
                C(rowScopeInstance, false, timePickerViewState.j(), composer2, 6, 1);
                DividerKt.a(SizeKt.d(SizeKt.A(companion, Dp.g(f4)), 0.0f, 1, null), ComposeColorsKt.j(composer2, 0).M(), 0.0f, 0.0f, composer, 6, 12);
                composer2 = composer;
                C(rowScopeInstance, false, timePickerViewState.j() + timePickerViewState.o(), composer2, 54, 0);
                composer2.y();
                composer2.y();
            } else {
                i5 = 6;
                composer2.a0(1860638645);
            }
            composer2.U();
            SpacerKt.a(SizeKt.v(companion, Dp.g(16)), composer2, i5);
            ComposeSwipeableTimePickerKt.W(timePickerViewState, TimePickerConfiguration.b(TimePickerConfiguration.f133137r.a(composer2, i5), 0, 0L, null, 0.0f, 0.0f, Dp.g(0), 0.0f, 0.0f, 0L, null, 0L, 0L, 0.0f, null, null, null, null, 131039, null), function1, composer, 0, 0);
            if (StringsKt.p0(timePickerViewState.e()) || !timePickerViewState.r()) {
                composer.a0(1860638645);
            } else {
                composer.a0(1868943731);
                SpacerKt.a(SizeKt.v(companion, Dp.g(8)), composer, i5);
                ComposeSwipeableTimePickerKt.u(timePickerViewState.e(), composer, 0);
            }
            composer.U();
            SpacerKt.a(ColumnScope.b(columnScopeInstance, companion, 0.3f, false, 2, null), composer, 0);
            composer.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer2.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit B(TimePickerViewState timePickerViewState, ScaffoldState scaffoldState, Function1 function1, Function1 function12, Function0 function0, int i3, Composer composer, int i4) {
        v(timePickerViewState, scaffoldState, function1, function12, function0, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0215  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0221  */
    /* JADX WARN: Removed duplicated region for block: B:76:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final void C(final androidx.compose.foundation.layout.RowScope r34, boolean r35, final long r36, androidx.compose.runtime.Composer r38, final int r39, final int r40) {
        /*
            Method dump skipped, instruction units count: 558
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.view.timeselector.TimeSelectScreenKt.C(androidx.compose.foundation.layout.RowScope, boolean, long, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit D(RowScope rowScope, boolean z2, long j3, int i3, int i4, Composer composer, int i5) {
        C(rowScope, z2, j3, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:130:0x022a  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0238  */
    /* JADX WARN: Removed duplicated region for block: B:135:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00c1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void E(final kotlin.jvm.functions.Function1 r29, final kotlin.jvm.functions.Function0 r30, cz.mobilesoft.coreblock.view.timepicker.TimePickerConfig r31, long r32, java.lang.Long r34, boolean r35, androidx.compose.runtime.Composer r36, final int r37, final int r38) {
        /*
            Method dump skipped, instruction units count: 583
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.view.timeselector.TimeSelectScreenKt.E(kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function0, cz.mobilesoft.coreblock.view.timepicker.TimePickerConfig, long, java.lang.Long, boolean, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ParametersHolder F(TimePickerConfig timePickerConfig, long j3, Long l3, boolean z2) {
        return ParametersHolderKt.b(new TimePickerViewModel.Params(timePickerConfig, j3, l3, z2, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit G(Function1 function1, Function0 function0, TimePickerConfig timePickerConfig, long j3, Long l3, boolean z2, int i3, int i4, Composer composer, int i5) {
        E(function1, function0, timePickerConfig, j3, l3, z2, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    private static final void o(TimePickerViewModel timePickerViewModel, final Function0 function0, Composer composer, final int i3) {
        int i4;
        final TimePickerViewModel timePickerViewModel2;
        Composer composerK = composer.k(-273222981);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(timePickerViewModel) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(function0) ? 32 : 16;
        }
        if (composerK.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-273222981, i4, -1, "cz.mobilesoft.coreblock.view.timeselector.CommandProcessor (TimeSelectScreen.kt:102)");
            }
            boolean z2 = (i4 & 112) == 32;
            Object objG = composerK.G();
            if (z2 || objG == Composer.f23746a.a()) {
                objG = new TimeSelectScreenKt$CommandProcessor$1$1(function0, null);
                composerK.w(objG);
            }
            timePickerViewModel2 = timePickerViewModel;
            FlowExtKt.g(timePickerViewModel2, null, (Function2) objG, composerK, i4 & 14, 2);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            timePickerViewModel2 = timePickerViewModel;
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.view.timeselector.r
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TimeSelectScreenKt.p(timePickerViewModel2, function0, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p(TimePickerViewModel timePickerViewModel, Function0 function0, int i3, Composer composer, int i4) {
        o(timePickerViewModel, function0, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    public static final void q(final Function2 viewToMeasure, final Function3 content, Composer composer, final int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(viewToMeasure, "viewToMeasure");
        Intrinsics.checkNotNullParameter(content, "content");
        Composer composerK = composer.k(484246096);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(viewToMeasure) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(content) ? 32 : 16;
        }
        if (composerK.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(484246096, i4, -1, "cz.mobilesoft.coreblock.view.timeselector.MeasureUnconstrainedViewWidth (TimeSelectScreen.kt:237)");
            }
            boolean z2 = ((i4 & 14) == 4) | ((i4 & 112) == 32);
            Object objG = composerK.G();
            if (z2 || objG == Composer.f23746a.a()) {
                objG = new Function2() { // from class: cz.mobilesoft.coreblock.view.timeselector.i
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return TimeSelectScreenKt.r(viewToMeasure, content, (SubcomposeMeasureScope) obj, (Constraints) obj2);
                    }
                };
                composerK.w(objG);
            }
            SubcomposeLayoutKt.a(null, (Function2) objG, composerK, 0, 1);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.view.timeselector.j
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TimeSelectScreenKt.u(viewToMeasure, content, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MeasureResult r(Function2 function2, final Function3 function3, SubcomposeMeasureScope SubcomposeLayout, Constraints constraints) {
        Intrinsics.checkNotNullParameter(SubcomposeLayout, "$this$SubcomposeLayout");
        final float F = SubcomposeLayout.F(((Measurable) SubcomposeLayout.V("viewToMeasure", function2).get(0)).n0(ConstraintsKt.b(0, 0, 0, 0, 15, null)).X0());
        final Placeable placeableN0 = ((Measurable) SubcomposeLayout.V(AppLovinEventTypes.USER_VIEWED_CONTENT, ComposableLambdaKt.c(118202062, true, new Function2() { // from class: cz.mobilesoft.coreblock.view.timeselector.k
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return TimeSelectScreenKt.s(function3, F, (Composer) obj, ((Integer) obj2).intValue());
            }
        })).get(0)).n0(constraints.r());
        return MeasureScope.B0(SubcomposeLayout, placeableN0.X0(), placeableN0.O0(), null, new Function1() { // from class: cz.mobilesoft.coreblock.view.timeselector.l
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return TimeSelectScreenKt.t(placeableN0, (Placeable.PlacementScope) obj);
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit s(Function3 function3, float f3, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(118202062, i3, -1, "cz.mobilesoft.coreblock.view.timeselector.MeasureUnconstrainedViewWidth.<anonymous>.<anonymous>.<anonymous> (TimeSelectScreen.kt:243)");
            }
            function3.invoke(Dp.d(f3), composer, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit t(Placeable placeable, Placeable.PlacementScope layout) {
        Intrinsics.checkNotNullParameter(layout, "$this$layout");
        Placeable.PlacementScope.i(layout, placeable, 0, 0, 0.0f, 4, null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit u(Function2 function2, Function3 function3, int i3, Composer composer, int i4) {
        q(function2, function3, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    private static final void v(final TimePickerViewState timePickerViewState, final ScaffoldState scaffoldState, final Function1 function1, final Function1 function12, final Function0 function0, Composer composer, final int i3) {
        int i4;
        ScaffoldState scaffoldState2;
        Composer composer2;
        Composer composerK = composer.k(1121750489);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(timePickerViewState) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            scaffoldState2 = scaffoldState;
            i4 |= composerK.Z(scaffoldState2) ? 32 : 16;
        } else {
            scaffoldState2 = scaffoldState;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.I(function1) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            i4 |= composerK.I(function12) ? 2048 : 1024;
        }
        if ((i3 & 24576) == 0) {
            i4 |= composerK.I(function0) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        }
        if (composerK.r((i4 & 9363) != 9362, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1121750489, i4, -1, "cz.mobilesoft.coreblock.view.timeselector.RootCompose (TimeSelectScreen.kt:119)");
            }
            composer2 = composerK;
            ScaffoldKt.a(WindowInsetsPaddingKt.d(Modifier.b8, WindowInsets_androidKt.e(WindowInsets.f7172a, composerK, 6)), scaffoldState2, ComposableLambdaKt.e(1349194846, true, new Function2() { // from class: cz.mobilesoft.coreblock.view.timeselector.n
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TimeSelectScreenKt.w(timePickerViewState, function0, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerK, 54), ComposableLambdaKt.e(-473992417, true, new Function2() { // from class: cz.mobilesoft.coreblock.view.timeselector.o
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TimeSelectScreenKt.y(timePickerViewState, function12, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerK, 54), ComposableSingletons$TimeSelectScreenKt.f133335a.b(), null, 0, false, null, false, null, 0.0f, 0L, 0L, 0L, 0L, 0L, ComposableLambdaKt.e(1598394647, true, new Function3() { // from class: cz.mobilesoft.coreblock.view.timeselector.p
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return TimeSelectScreenKt.A(timePickerViewState, function1, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerK, 54), composer2, (i4 & 112) | 28032, 12582912, 131040);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer2 = composerK;
            composer2.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.view.timeselector.q
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TimeSelectScreenKt.B(timePickerViewState, scaffoldState, function1, function12, function0, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit w(final TimePickerViewState timePickerViewState, final Function0 function0, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1349194846, i3, -1, "cz.mobilesoft.coreblock.view.timeselector.RootCompose.<anonymous> (TimeSelectScreen.kt:126)");
            }
            String strB = StringResources_androidKt.b(!timePickerViewState.s() ? R.string.Zv : R.string.KB, composer, 0);
            boolean Z = composer.Z(timePickerViewState) | composer.Z(function0);
            Object objG = composer.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.view.timeselector.t
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return TimeSelectScreenKt.x(timePickerViewState, function0);
                    }
                };
                composer.w(objG);
            }
            ToolbarKt.e(null, (Function0) objG, strB, true, null, false, false, null, null, composer, 3072, 497);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit x(TimePickerViewState timePickerViewState, Function0 function0) {
        if (timePickerViewState.s()) {
            AnswersHelper.f128199a.p7();
        } else {
            AnswersHelper.f128199a.N7();
        }
        function0.invoke();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit y(final TimePickerViewState timePickerViewState, final Function1 function1, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-473992417, i3, -1, "cz.mobilesoft.coreblock.view.timeselector.RootCompose.<anonymous> (TimeSelectScreen.kt:140)");
            }
            boolean z2 = timePickerViewState.o() > 0;
            String strB = StringResources_androidKt.b(R.string.Lt, composer, 0);
            boolean Z = composer.Z(timePickerViewState) | composer.Z(function1);
            Object objG = composer.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.view.timeselector.s
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return TimeSelectScreenKt.z(timePickerViewState, function1);
                    }
                };
                composer.w(objG);
            }
            ComposeButtonsKt.J(null, strB, z2, false, null, (Function0) objG, composer, 0, 25);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit z(TimePickerViewState timePickerViewState, Function1 function1) {
        long jO = timePickerViewState.o();
        long minutes = TimeUnit.MILLISECONDS.toMinutes(jO);
        if (timePickerViewState.s()) {
            AnswersHelper answersHelper = AnswersHelper.f128199a;
            answersHelper.O7(timePickerViewState.j(), jO);
            answersHelper.r7(minutes);
        } else {
            AnswersHelper.f128199a.P7(minutes);
        }
        function1.invoke(Long.valueOf(jO));
        return Unit.f139807a;
    }
}
