package cz.mobilesoft.coreblock.scene.schedule.condition.time;

import android.content.Context;
import android.os.Bundle;
import androidx.activity.compose.BackHandlerKt;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.ScaffoldKt;
import androidx.compose.material.ScaffoldState;
import androidx.compose.material.TextKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.navigation.NavBackStackEntry;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.enums.ProfileType;
import cz.mobilesoft.coreblock.scene.insights.InsightsScreenHabitsListKt;
import cz.mobilesoft.coreblock.scene.schedule.condition.BaseConditionScreenKt;
import cz.mobilesoft.coreblock.scene.schedule.condition.ConditionDTO;
import cz.mobilesoft.coreblock.scene.schedule.condition.IntervalDTO;
import cz.mobilesoft.coreblock.scene.schedule.condition.time.TimeConditionViewEvent;
import cz.mobilesoft.coreblock.util.analytics.AnswersHelper;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.util.compose.FlowExtKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.util.helperextension.CoroutinesHelperExtKt;
import cz.mobilesoft.coreblock.util.helperextension.DateHelper;
import cz.mobilesoft.coreblock.util.helperextension.StringHelperExtKt;
import cz.mobilesoft.coreblock.view.compose.ComposeDialogsKt;
import cz.mobilesoft.coreblock.view.graph.BarGraphKt;
import cz.mobilesoft.coreblock.view.graph.GraphConfiguration;
import cz.mobilesoft.coreblock.view.graph.GraphData;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import org.koin.androidx.compose.ViewModelComposeExtKt;
import org.koin.androidx.viewmodel.GetViewModelKt;
import org.koin.androidx.viewmodel.ext.android.BundleExtKt;
import org.koin.core.context.GlobalContext;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.parameter.ParametersHolderKt;
import org.koin.core.scope.Scope;
import org.threeten.bp.DayOfWeek;

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
public final class TimeConditionScreenKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit A(Function1 function1, IntervalDTO interval) {
        Intrinsics.checkNotNullParameter(interval, "interval");
        function1.invoke(new TimeConditionViewEvent.OnIntervalRemoveClicked(interval));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit B(Function1 function1, boolean z2, DayOfWeek dayOfWeek) {
        Intrinsics.checkNotNullParameter(dayOfWeek, "dayOfWeek");
        function1.invoke(new TimeConditionViewEvent.OnDayCheckedChanged(z2, dayOfWeek));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit C(TimeConditionViewState timeConditionViewState, GraphData graphData, Function1 function1, int i3, Composer composer, int i4) {
        w(timeConditionViewState, graphData, function1, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    public static final void D(final GraphData graphData, final Configuration configuration, Composer composer, final int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(graphData, "graphData");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Composer composerK = composer.k(1096588243);
        if ((i3 & 6) == 0) {
            i4 = ((i3 & 8) == 0 ? composerK.Z(graphData) : composerK.I(graphData) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.Z(configuration) ? 32 : 16;
        }
        if (composerK.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1096588243, i4, -1, "cz.mobilesoft.coreblock.scene.schedule.condition.time.GraphContent (TimeConditionScreen.kt:337)");
            }
            final boolean z2 = graphData.d() == 0.0f;
            InsightsScreenHabitsListKt.o(null, null, null, ComposableLambdaKt.e(2044927758, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.schedule.condition.time.f
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return TimeConditionScreenKt.E(configuration, z2, graphData, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerK, 54), composerK, 3072, 7);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.schedule.condition.time.g
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TimeConditionScreenKt.F(graphData, configuration, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit E(Configuration configuration, boolean z2, GraphData graphData, BoxScope BorderedBox, Composer composer, int i3) {
        Modifier.Companion companion;
        Intrinsics.checkNotNullParameter(BorderedBox, "$this$BorderedBox");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(2044927758, i3, -1, "cz.mobilesoft.coreblock.scene.schedule.condition.time.GraphContent.<anonymous> (TimeConditionScreen.kt:340)");
            }
            Modifier.Companion companion2 = Modifier.b8;
            Modifier modifierH = SizeKt.h(companion2, 0.0f, 1, null);
            Alignment.Companion companion3 = Alignment.f25072a;
            Alignment.Horizontal horizontalK = companion3.k();
            Arrangement arrangement = Arrangement.f6574a;
            MeasurePolicy measurePolicyA = ColumnKt.a(arrangement.h(), horizontalK, composer, 48);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, modifierH);
            ComposeUiNode.Companion companion4 = ComposeUiNode.f8;
            Function0 function0A = companion4.a();
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
            Updater.e(composerA, measurePolicyA, companion4.e());
            Updater.e(composerA, compositionLocalMapU, companion4.g());
            Function2 function2B = companion4.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion4.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            String strB = StringResources_androidKt.b(R.string.z4, composer, 0);
            String strK = DateHelper.k((Context) composer.q(AndroidCompositionLocals_androidKt.g()), configuration.c());
            Intrinsics.checkNotNullExpressionValue(strK, "getRemainingTimeOnlyString(...)");
            String strQ = StringHelperExtKt.q(strB, strK, null, 2, null);
            TextStyle textStyleB = ComposeTypographyKt.g(composer, 0).b();
            TextAlign.Companion companion5 = TextAlign.f29616b;
            TextKt.c(strQ, null, ComposeColorsKt.j(composer, 0).b(), 0L, null, null, null, 0L, null, TextAlign.h(companion5.f()), 0L, 0, false, 0, 0, null, textStyleB, composer, 0, 0, 65018);
            Composer composer2 = composer;
            if (z2) {
                companion = companion2;
                composer2.a0(-1705861026);
            } else {
                composer2.a0(-1691667180);
                MeasurePolicy measurePolicyB = RowKt.b(arrangement.g(), companion3.i(), composer2, 48);
                int iA2 = ComposablesKt.a(composer2, 0);
                CompositionLocalMap compositionLocalMapU2 = composer2.u();
                Modifier modifierF2 = ComposedModifierKt.f(composer2, companion2);
                Function0 function0A2 = companion4.a();
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
                Updater.e(composerA2, measurePolicyB, companion4.e());
                Updater.e(composerA2, compositionLocalMapU2, companion4.g());
                Function2 function2B2 = companion4.b();
                if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                    composerA2.w(Integer.valueOf(iA2));
                    composerA2.p(Integer.valueOf(iA2), function2B2);
                }
                Updater.e(composerA2, modifierF2, companion4.f());
                RowScopeInstance rowScopeInstance = RowScopeInstance.f7101a;
                BoxKt.a(BackgroundKt.c(SizeKt.v(companion2, Dp.g(8)), ComposeColorsKt.j(composer2, 0).P(), RoundedCornerShapeKt.d(Dp.g(2))), composer2, 0);
                SpacerKt.a(SizeKt.A(companion2, Dp.g(4)), composer2, 6);
                companion = companion2;
                TextKt.c(StringResources_androidKt.b(R.string.sv, composer2, 0), RowScope.c(rowScopeInstance, companion2, 1.0f, false, 2, null), ComposeColorsKt.j(composer2, 0).P(), 0L, null, null, null, 0L, null, TextAlign.h(companion5.f()), 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer2, 0).b(), composer, 0, 0, 65016);
                composer2 = composer;
                composer2.y();
            }
            composer2.U();
            Modifier.Companion companion6 = companion;
            SpacerKt.a(SizeKt.i(companion6, Dp.g(8)), composer2, 6);
            Modifier modifierM = PaddingKt.m(companion6, 0.0f, 0.0f, 0.0f, Dp.g(32), 7, null);
            float fG = Dp.g(z2 ? 12 : 96);
            Color colorN = Color.n(ComposeColorsKt.j(composer2, 0).F());
            long jB = ComposeColorsKt.j(composer2, 0).b();
            List<IntervalDTO> listG = configuration.g();
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listG, 10));
            for (IntervalDTO intervalDTO : listG) {
                float f3 = 1440L;
                arrayList.add(new Pair(Float.valueOf(intervalDTO.b() / f3), Float.valueOf(intervalDTO.a() / f3)));
            }
            BarGraphKt.m(modifierM, graphData, new GraphConfiguration(false, false, true, false, false, false, colorN, null, null, null, false, true, new GraphConfiguration.GraphOverlay(jB, arrayList, null), false, null, null, 59304, null), 0L, fG, null, composer2, (GraphData.f132767h << 3) | 6 | (GraphConfiguration.f132743r << 6), 40);
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
    public static final Unit F(GraphData graphData, Configuration configuration, int i3, Composer composer, int i4) {
        D(graphData, configuration, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:132:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:137:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00e3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void G(final androidx.compose.material.ScaffoldState r23, final cz.mobilesoft.coreblock.scene.schedule.condition.time.TimeConditionViewState r24, final cz.mobilesoft.coreblock.view.graph.GraphData r25, boolean r26, boolean r27, java.lang.Float r28, boolean r29, final kotlin.jvm.functions.Function1 r30, androidx.compose.runtime.Composer r31, final int r32, final int r33) {
        /*
            Method dump skipped, instruction units count: 463
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.schedule.condition.time.TimeConditionScreenKt.G(androidx.compose.material.ScaffoldState, cz.mobilesoft.coreblock.scene.schedule.condition.time.TimeConditionViewState, cz.mobilesoft.coreblock.view.graph.GraphData, boolean, boolean, java.lang.Float, boolean, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit H(Function1 function1) {
        function1.invoke(TimeConditionViewEvent.OnCloseClicked.f115751a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit I(Function1 function1) {
        function1.invoke(TimeConditionViewEvent.OnSaveClicked.f115760a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit J(TimeConditionViewState timeConditionViewState, GraphData graphData, Function1 function1, ColumnScope BaseConditionScreen, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(BaseConditionScreen, "$this$BaseConditionScreen");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(326334790, i3, -1, "cz.mobilesoft.coreblock.scene.schedule.condition.time.RootCompose.<anonymous> (TimeConditionScreen.kt:283)");
            }
            w(timeConditionViewState, graphData, function1, composer, GraphData.f132767h << 3);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit K(ScaffoldState scaffoldState, TimeConditionViewState timeConditionViewState, GraphData graphData, boolean z2, boolean z3, Float f3, boolean z4, Function1 function1, int i3, int i4, Composer composer, int i5) {
        G(scaffoldState, timeConditionViewState, graphData, z2, z3, f3, z4, function1, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    public static final void L(final ConditionDTO.TimeDTO timeDTO, final GraphData graphData, final Long l3, final boolean z2, final boolean z3, final Function1 onConditionSet, boolean z4, boolean z5, Float f3, final Function0 onCloseClicked, Composer composer, final int i3, final int i4) {
        int i5;
        boolean z6;
        final boolean z7;
        Composer composer2;
        final Float f4;
        Bundle bundleB;
        Intrinsics.checkNotNullParameter(onConditionSet, "onConditionSet");
        Intrinsics.checkNotNullParameter(onCloseClicked, "onCloseClicked");
        Composer composerK = composer.k(1637533799);
        if ((i3 & 6) == 0) {
            i5 = (composerK.Z(timeDTO) ? 4 : 2) | i3;
        } else {
            i5 = i3;
        }
        if ((i3 & 48) == 0) {
            i5 |= (i3 & 64) == 0 ? composerK.Z(graphData) : composerK.I(graphData) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i5 |= composerK.Z(l3) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            i5 |= composerK.b(z2) ? 2048 : 1024;
        }
        if ((i3 & 24576) == 0) {
            i5 |= composerK.b(z3) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        }
        if ((196608 & i3) == 0) {
            i5 |= composerK.I(onConditionSet) ? 131072 : NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
        }
        int i6 = i4 & 64;
        if (i6 != 0) {
            i5 |= 1572864;
            z6 = z4;
        } else {
            z6 = z4;
            if ((i3 & 1572864) == 0) {
                i5 |= composerK.b(z6) ? 1048576 : 524288;
            }
        }
        int i7 = i4 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        if (i7 != 0) {
            i5 |= 12582912;
            z7 = z5;
        } else {
            z7 = z5;
            if ((i3 & 12582912) == 0) {
                i5 |= composerK.b(z7) ? 8388608 : 4194304;
            }
        }
        int i8 = i4 & Function.MAX_NARGS;
        if (i8 != 0) {
            i5 |= 100663296;
        } else if ((i3 & 100663296) == 0) {
            i5 |= composerK.Z(f3) ? 67108864 : 33554432;
        }
        if ((i3 & 805306368) == 0) {
            i5 |= composerK.I(onCloseClicked) ? 536870912 : 268435456;
        }
        if (composerK.r((i5 & 306783379) != 306783378, i5 & 1)) {
            if (i6 != 0) {
                z6 = false;
            }
            boolean z8 = i7 != 0 ? false : z7;
            Float f5 = i8 != 0 ? null : f3;
            if (ComposerKt.M()) {
                ComposerKt.U(1637533799, i5, -1, "cz.mobilesoft.coreblock.scene.schedule.condition.time.TimeConditionScreen (TimeConditionScreen.kt:158)");
            }
            Object objG = composerK.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG == companion.a()) {
                objG = EffectsKt.l(EmptyCoroutineContext.f139889a, composerK);
                composerK.w(objG);
            }
            CoroutineScope coroutineScopeI = CoroutineScopeKt.i((CoroutineScope) objG, CoroutinesHelperExtKt.b());
            boolean z9 = ((i5 & 14) == 4) | ((i5 & 896) == 256) | ((i5 & 7168) == 2048);
            Object objG2 = composerK.G();
            if (z9 || objG2 == companion.a()) {
                objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.schedule.condition.time.h
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return TimeConditionScreenKt.M(timeDTO, l3, z2);
                    }
                };
                composerK.w(objG2);
            }
            Function0 function0 = (Function0) objG2;
            composerK.F(-101221098);
            ViewModelStoreOwner viewModelStoreOwnerC = LocalViewModelStoreOwner.f40240a.c(composerK, 8);
            if (viewModelStoreOwnerC == null) {
                throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
            }
            CreationExtras creationExtrasA = ViewModelComposeExtKt.a(viewModelStoreOwnerC, composerK, 8);
            Scope scopeD = GlobalContext.f145907a.get().j().d();
            composerK.F(-1072256281);
            NavBackStackEntry navBackStackEntry = viewModelStoreOwnerC instanceof NavBackStackEntry ? (NavBackStackEntry) viewModelStoreOwnerC : null;
            CreationExtras creationExtrasA2 = (navBackStackEntry == null || (bundleB = navBackStackEntry.b()) == null) ? null : BundleExtKt.a(bundleB, viewModelStoreOwnerC);
            KClass kClassB = Reflection.b(TimeConditionViewModel.class);
            ViewModelStore viewModelStore = viewModelStoreOwnerC.getViewModelStore();
            Intrinsics.checkNotNullExpressionValue(viewModelStore, "viewModelStoreOwner.viewModelStore");
            ViewModel viewModelA = GetViewModelKt.a(kClassB, viewModelStore, null, creationExtrasA2 == null ? creationExtrasA : creationExtrasA2, null, scopeD, function0);
            composerK.Y();
            composerK.Y();
            TimeConditionViewModel timeConditionViewModel = (TimeConditionViewModel) viewModelA;
            ScaffoldState scaffoldStateG = ScaffoldKt.g(null, null, composerK, 0, 3);
            final TimeConditionViewState timeConditionViewState = (TimeConditionViewState) FlowExtKt.m(timeConditionViewModel, composerK, 0);
            final Function1 function1N = FlowExtKt.n(timeConditionViewModel, composerK, 0);
            boolean Z = ((i5 & 57344) == 16384) | composerK.Z(function1N);
            Object objG3 = composerK.G();
            if (Z || objG3 == companion.a()) {
                objG3 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.schedule.condition.time.i
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return TimeConditionScreenKt.N(z3, function1N);
                    }
                };
                composerK.w(objG3);
            }
            BackHandlerKt.a(false, (Function0) objG3, composerK, 0, 1);
            int i9 = i5 >> 9;
            int i10 = (GraphData.f132767h << 6) | ((i5 << 3) & 896) | (i9 & 7168) | (i9 & 57344) | (i9 & 458752) | ((i5 << 6) & 3670016);
            boolean z10 = z6;
            int i11 = i5;
            Float f6 = f5;
            G(scaffoldStateG, timeConditionViewState, graphData, z10, z8, f6, z3, function1N, composerK, i10, 0);
            z6 = z10;
            boolean z11 = z8;
            if (timeConditionViewState.c().j()) {
                composerK.a0(1532219749);
                IntervalDTO intervalDTOG = timeConditionViewState.c().g();
                boolean zK = timeConditionViewState.c().k();
                boolean Z2 = composerK.Z(function1N);
                Object objG4 = composerK.G();
                if (Z2 || objG4 == companion.a()) {
                    objG4 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.schedule.condition.time.j
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return TimeConditionScreenKt.O(function1N);
                        }
                    };
                    composerK.w(objG4);
                }
                Function0 function02 = (Function0) objG4;
                boolean Z3 = composerK.Z(function1N) | composerK.Z(timeConditionViewState);
                Object objG5 = composerK.G();
                if (Z3 || objG5 == companion.a()) {
                    objG5 = new Function2() { // from class: cz.mobilesoft.coreblock.scene.schedule.condition.time.k
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return TimeConditionScreenKt.P(function1N, timeConditionViewState, ((Long) obj).longValue(), ((Long) obj2).longValue());
                        }
                    };
                    composerK.w(objG5);
                }
                BaseConditionScreenKt.A0(intervalDTOG, zK, function02, (Function2) objG5, composerK, 0, 0);
            } else {
                composerK.a0(1524046971);
            }
            composerK.U();
            t(coroutineScopeI, scaffoldStateG, timeConditionViewState.d(), timeConditionViewModel, function1N, onConditionSet, onCloseClicked, composerK, (i11 & 458752) | (i9 & 3670016));
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
            composer2 = composerK;
            z7 = z11;
            f4 = f6;
        } else {
            composerK.Q();
            composer2 = composerK;
            f4 = f3;
        }
        final boolean z12 = z6;
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.schedule.condition.time.l
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TimeConditionScreenKt.Q(timeDTO, graphData, l3, z2, z3, onConditionSet, z12, z7, f4, onCloseClicked, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ParametersHolder M(ConditionDTO.TimeDTO timeDTO, Long l3, boolean z2) {
        return ParametersHolderKt.b(timeDTO, l3, Boolean.valueOf(z2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit N(boolean z2, Function1 function1) {
        if (z2) {
            function1.invoke(TimeConditionViewEvent.OnCloseClicked.f115751a);
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit O(Function1 function1) {
        function1.invoke(TimeConditionViewEvent.OnDismissTimeRangePickerBottomSheet.f115754a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit P(Function1 function1, TimeConditionViewState timeConditionViewState, long j3, long j4) {
        function1.invoke(new TimeConditionViewEvent.OnIntervalSet(timeConditionViewState.c().g(), j3, j4));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Q(ConditionDTO.TimeDTO timeDTO, GraphData graphData, Long l3, boolean z2, boolean z3, Function1 function1, boolean z4, boolean z5, Float f3, Function0 function0, int i3, int i4, Composer composer, int i5) {
        L(timeDTO, graphData, l3, z2, z3, function1, z4, z5, f3, function0, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    private static final void t(final CoroutineScope coroutineScope, final ScaffoldState scaffoldState, final boolean z2, final TimeConditionViewModel timeConditionViewModel, final Function1 function1, final Function1 function12, final Function0 function0, Composer composer, final int i3) {
        int i4;
        ScaffoldState scaffoldState2;
        TimeConditionViewModel timeConditionViewModel2;
        Function1 function13;
        Composer composer2;
        Composer composerK = composer.k(408196088);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(coroutineScope) ? 4 : 2) | i3;
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
            i4 |= composerK.b(z2) ? 256 : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            timeConditionViewModel2 = timeConditionViewModel;
            i4 |= composerK.I(timeConditionViewModel2) ? 2048 : 1024;
        } else {
            timeConditionViewModel2 = timeConditionViewModel;
        }
        if ((196608 & i3) == 0) {
            function13 = function12;
            i4 |= composerK.I(function13) ? 131072 : NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
        } else {
            function13 = function12;
        }
        if ((1572864 & i3) == 0) {
            i4 |= composerK.I(function0) ? 1048576 : 524288;
        }
        int i5 = i4;
        if (composerK.r((590995 & i5) != 590994, i5 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(408196088, i5, -1, "cz.mobilesoft.coreblock.scene.schedule.condition.time.CommandProcessor (TimeConditionScreen.kt:225)");
            }
            Object objG = composerK.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG == companion.a()) {
                objG = SnapshotStateKt__SnapshotStateKt.e(Boolean.FALSE, null, 2, null);
                composerK.w(objG);
            }
            MutableState mutableState = (MutableState) objG;
            int i6 = 3670016 & i5;
            boolean z3 = ((i5 & 896) == 256) | (i6 == 1048576);
            Object objG2 = composerK.G();
            if (z3 || objG2 == companion.a()) {
                objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.schedule.condition.time.m
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return TimeConditionScreenKt.u(z2, function0);
                    }
                };
                composerK.w(objG2);
            }
            ComposeDialogsKt.H0(mutableState, (Function0) objG2, composerK, 6);
            boolean zI = ((458752 & i5) == 131072) | (i6 == 1048576) | ((i5 & 112) == 32) | composerK.I(coroutineScope);
            Object objG3 = composerK.G();
            if (zI || objG3 == companion.a()) {
                TimeConditionScreenKt$CommandProcessor$2$1 timeConditionScreenKt$CommandProcessor$2$1 = new TimeConditionScreenKt$CommandProcessor$2$1(function13, function0, mutableState, scaffoldState2, coroutineScope, null);
                composerK.w(timeConditionScreenKt$CommandProcessor$2$1);
                objG3 = timeConditionScreenKt$CommandProcessor$2$1;
            }
            composer2 = composerK;
            FlowExtKt.g(timeConditionViewModel2, null, (Function2) objG3, composer2, (i5 >> 9) & 14, 2);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer2 = composerK;
            composer2.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.schedule.condition.time.n
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TimeConditionScreenKt.v(coroutineScope, scaffoldState, z2, timeConditionViewModel, function1, function12, function0, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit u(boolean z2, Function0 function0) {
        AnswersHelper.f128199a.R4(ProfileType.TIME, z2);
        function0.invoke();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit v(CoroutineScope coroutineScope, ScaffoldState scaffoldState, boolean z2, TimeConditionViewModel timeConditionViewModel, Function1 function1, Function1 function12, Function0 function0, int i3, Composer composer, int i4) {
        t(coroutineScope, scaffoldState, z2, timeConditionViewModel, function1, function12, function0, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    private static final void w(final TimeConditionViewState timeConditionViewState, final GraphData graphData, final Function1 function1, Composer composer, final int i3) {
        int i4;
        Composer composerK = composer.k(532202290);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(timeConditionViewState) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= (i3 & 64) == 0 ? composerK.Z(graphData) : composerK.I(graphData) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.I(function1) ? 256 : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if (composerK.r((i4 & 147) != 146, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(532202290, i4, -1, "cz.mobilesoft.coreblock.scene.schedule.condition.time.Content (TimeConditionScreen.kt:296)");
            }
            TimeConditionConfigurationViewState timeConditionConfigurationViewStateC = timeConditionViewState.c();
            Configuration configurationF = timeConditionConfigurationViewStateC.f();
            boolean zI = timeConditionConfigurationViewStateC.i();
            boolean zM = timeConditionConfigurationViewStateC.m();
            int i5 = i4 & 896;
            boolean z2 = i5 == 256;
            Object objG = composerK.G();
            if (z2 || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.schedule.condition.time.r
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return TimeConditionScreenKt.x(function1);
                    }
                };
                composerK.w(objG);
            }
            Function0 function0 = (Function0) objG;
            boolean z3 = i5 == 256;
            Object objG2 = composerK.G();
            if (z3 || objG2 == Composer.f23746a.a()) {
                objG2 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.schedule.condition.time.s
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return TimeConditionScreenKt.y(function1, ((Boolean) obj).booleanValue());
                    }
                };
                composerK.w(objG2);
            }
            Function1 function12 = (Function1) objG2;
            boolean z4 = i5 == 256;
            Object objG3 = composerK.G();
            if (z4 || objG3 == Composer.f23746a.a()) {
                objG3 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.schedule.condition.time.t
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return TimeConditionScreenKt.z(function1, (IntervalDTO) obj);
                    }
                };
                composerK.w(objG3);
            }
            Function1 function13 = (Function1) objG3;
            boolean z5 = i5 == 256;
            Object objG4 = composerK.G();
            if (z5 || objG4 == Composer.f23746a.a()) {
                objG4 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.schedule.condition.time.u
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return TimeConditionScreenKt.A(function1, (IntervalDTO) obj);
                    }
                };
                composerK.w(objG4);
            }
            BaseConditionScreenKt.R0(configurationF, zI, zM, function0, function12, function13, (Function1) objG4, composerK, 0, 0);
            Configuration configurationF2 = timeConditionConfigurationViewStateC.f();
            boolean zH = timeConditionConfigurationViewStateC.h();
            boolean z6 = i5 == 256;
            Object objG5 = composerK.G();
            if (z6 || objG5 == Composer.f23746a.a()) {
                objG5 = new Function2() { // from class: cz.mobilesoft.coreblock.scene.schedule.condition.time.v
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return TimeConditionScreenKt.B(function1, ((Boolean) obj).booleanValue(), (DayOfWeek) obj2);
                    }
                };
                composerK.w(objG5);
            }
            BaseConditionScreenKt.i0(configurationF2, zH, (Function2) objG5, composerK, 0, 0);
            if (graphData == null) {
                composerK.a0(2115403940);
            } else {
                composerK.a0(2115403941);
                D(graphData, timeConditionConfigurationViewStateC.f(), composerK, GraphData.f132767h);
            }
            composerK.U();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.schedule.condition.time.w
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TimeConditionScreenKt.C(timeConditionViewState, graphData, function1, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit x(Function1 function1) {
        function1.invoke(TimeConditionViewEvent.OnAddIntervalClicked.f115749a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit y(Function1 function1, boolean z2) {
        function1.invoke(new TimeConditionViewEvent.OnAllDayLongCheckedChanged(z2));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit z(Function1 function1, IntervalDTO interval) {
        Intrinsics.checkNotNullParameter(interval, "interval");
        function1.invoke(new TimeConditionViewEvent.OnIntervalClicked(interval));
        return Unit.f139807a;
    }
}
