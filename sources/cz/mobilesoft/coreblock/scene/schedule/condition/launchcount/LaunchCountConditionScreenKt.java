package cz.mobilesoft.coreblock.scene.schedule.condition.launchcount;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.material.ScaffoldState;
import androidx.compose.material.TextKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.PrimitiveResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.unit.Dp;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.enums.PremiumFeature;
import cz.mobilesoft.coreblock.enums.ProfileType;
import cz.mobilesoft.coreblock.scene.schedule.condition.BaseConditionScreenKt;
import cz.mobilesoft.coreblock.scene.schedule.condition.ConditionDTO;
import cz.mobilesoft.coreblock.scene.schedule.condition.IntervalDTO;
import cz.mobilesoft.coreblock.scene.schedule.condition.launchcount.LaunchCountConditionViewEvent;
import cz.mobilesoft.coreblock.scene.schedule.condition.time.Configuration;
import cz.mobilesoft.coreblock.scene.schedule.condition.time.LaunchCountConditionConfigurationViewState;
import cz.mobilesoft.coreblock.scene.schedule.condition.time.TimeConditionConfigurationViewState;
import cz.mobilesoft.coreblock.scene.schedule.condition.time.TimeConditionViewEvent;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.UsageLimit;
import cz.mobilesoft.coreblock.util.analytics.AnswersHelper;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.util.compose.FlowExtKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.util.helperextension.StringHelperExtKt;
import cz.mobilesoft.coreblock.view.compose.ChipKt;
import cz.mobilesoft.coreblock.view.compose.ComposeDialogsKt;
import cz.mobilesoft.coreblock.view.compose.material3.CardsKt;
import cz.mobilesoft.coreblock.view.compose.material3.FlatButtonColors;
import cz.mobilesoft.coreblock.view.compose.material3.FlatButtonsKt;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.parameter.ParametersHolderKt;
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
public final class LaunchCountConditionScreenKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit A(boolean z2, Function0 function0) {
        AnswersHelper.f128199a.R4(ProfileType.LAUNCH_COUNT, z2);
        function0.invoke();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit B(CoroutineScope coroutineScope, ScaffoldState scaffoldState, boolean z2, LaunchCountConditionViewModel launchCountConditionViewModel, Function1 function1, Function0 function0, int i3, Composer composer, int i4) {
        z(coroutineScope, scaffoldState, z2, launchCountConditionViewModel, function1, function0, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C(final ColumnScope columnScope, final LaunchCountConditionViewState launchCountConditionViewState, final Function1 function1, Composer composer, final int i3) {
        int i4;
        Composer composerK = composer.k(1892389403);
        if ((i3 & 48) == 0) {
            i4 = (composerK.Z(launchCountConditionViewState) ? 32 : 16) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.I(function1) ? 256 : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if (composerK.r((i4 & 145) != 144, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1892389403, i4, -1, "cz.mobilesoft.coreblock.scene.schedule.condition.launchcount.Content (LaunchCountConditionScreen.kt:202)");
            }
            TimeConditionConfigurationViewState timeConditionConfigurationViewStateD = launchCountConditionViewState.d();
            LaunchCountConditionConfigurationViewState launchCountConditionConfigurationViewStateC = launchCountConditionViewState.c();
            int i5 = i4 & 896;
            boolean z2 = i5 == 256;
            Object objG = composerK.G();
            if (z2 || objG == Composer.f23746a.a()) {
                objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.schedule.condition.launchcount.w
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return LaunchCountConditionScreenKt.D(function1, (UsageLimit.PeriodType) obj);
                    }
                };
                composerK.w(objG);
            }
            Function1 function12 = (Function1) objG;
            boolean z3 = i5 == 256;
            Object objG2 = composerK.G();
            if (z3 || objG2 == Composer.f23746a.a()) {
                objG2 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.schedule.condition.launchcount.x
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return LaunchCountConditionScreenKt.E(function1, ((Integer) obj).intValue());
                    }
                };
                composerK.w(objG2);
            }
            R(launchCountConditionConfigurationViewStateC, function12, (Function1) objG2, composerK, 0);
            Configuration configurationF = timeConditionConfigurationViewStateD.f();
            boolean zI = timeConditionConfigurationViewStateD.i();
            boolean zM = timeConditionConfigurationViewStateD.m();
            boolean z4 = i5 == 256;
            Object objG3 = composerK.G();
            if (z4 || objG3 == Composer.f23746a.a()) {
                objG3 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.schedule.condition.launchcount.y
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return LaunchCountConditionScreenKt.F(function1);
                    }
                };
                composerK.w(objG3);
            }
            Function0 function0 = (Function0) objG3;
            boolean z5 = i5 == 256;
            Object objG4 = composerK.G();
            if (z5 || objG4 == Composer.f23746a.a()) {
                objG4 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.schedule.condition.launchcount.z
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return LaunchCountConditionScreenKt.G(function1, ((Boolean) obj).booleanValue());
                    }
                };
                composerK.w(objG4);
            }
            Function1 function13 = (Function1) objG4;
            boolean z6 = i5 == 256;
            Object objG5 = composerK.G();
            if (z6 || objG5 == Composer.f23746a.a()) {
                objG5 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.schedule.condition.launchcount.a0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return LaunchCountConditionScreenKt.H(function1, (IntervalDTO) obj);
                    }
                };
                composerK.w(objG5);
            }
            Function1 function14 = (Function1) objG5;
            boolean z7 = i5 == 256;
            Object objG6 = composerK.G();
            if (z7 || objG6 == Composer.f23746a.a()) {
                objG6 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.schedule.condition.launchcount.b0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return LaunchCountConditionScreenKt.I(function1, (IntervalDTO) obj);
                    }
                };
                composerK.w(objG6);
            }
            BaseConditionScreenKt.R0(configurationF, zI, zM, function0, function13, function14, (Function1) objG6, composerK, 0, 0);
            Configuration configurationF2 = timeConditionConfigurationViewStateD.f();
            boolean zH = timeConditionConfigurationViewStateD.h();
            boolean z8 = i5 == 256;
            Object objG7 = composerK.G();
            if (z8 || objG7 == Composer.f23746a.a()) {
                objG7 = new Function2() { // from class: cz.mobilesoft.coreblock.scene.schedule.condition.launchcount.c0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return LaunchCountConditionScreenKt.J(function1, ((Boolean) obj).booleanValue(), (DayOfWeek) obj2);
                    }
                };
                composerK.w(objG7);
            }
            BaseConditionScreenKt.i0(configurationF2, zH, (Function2) objG7, composerK, 0, 0);
            BaseConditionScreenKt.n0(StringResources_androidKt.b(R.string.St, composerK, 0), composerK, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.schedule.condition.launchcount.d0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return LaunchCountConditionScreenKt.K(columnScope, launchCountConditionViewState, function1, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit D(Function1 function1, UsageLimit.PeriodType it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function1.invoke(new LaunchCountConditionViewEvent.OnPeriodTypeChanged(it));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit E(Function1 function1, int i3) {
        function1.invoke(new LaunchCountConditionViewEvent.OnLaunchCountChanged(i3));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit F(Function1 function1) {
        function1.invoke(new LaunchCountConditionViewEvent.LaunchCountTimeConditionViewEvent(TimeConditionViewEvent.OnAddIntervalClicked.f115749a));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit G(Function1 function1, boolean z2) {
        function1.invoke(new LaunchCountConditionViewEvent.LaunchCountTimeConditionViewEvent(new TimeConditionViewEvent.OnAllDayLongCheckedChanged(z2)));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit H(Function1 function1, IntervalDTO interval) {
        Intrinsics.checkNotNullParameter(interval, "interval");
        function1.invoke(new LaunchCountConditionViewEvent.LaunchCountTimeConditionViewEvent(new TimeConditionViewEvent.OnIntervalClicked(interval)));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit I(Function1 function1, IntervalDTO interval) {
        Intrinsics.checkNotNullParameter(interval, "interval");
        function1.invoke(new LaunchCountConditionViewEvent.LaunchCountTimeConditionViewEvent(new TimeConditionViewEvent.OnIntervalRemoveClicked(interval)));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit J(Function1 function1, boolean z2, DayOfWeek dayOfWeek) {
        Intrinsics.checkNotNullParameter(dayOfWeek, "dayOfWeek");
        function1.invoke(new LaunchCountConditionViewEvent.LaunchCountTimeConditionViewEvent(new TimeConditionViewEvent.OnDayCheckedChanged(z2, dayOfWeek)));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit K(ColumnScope columnScope, LaunchCountConditionViewState launchCountConditionViewState, Function1 function1, int i3, Composer composer, int i4) {
        C(columnScope, launchCountConditionViewState, function1, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:165:0x02da  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x02eb  */
    /* JADX WARN: Removed duplicated region for block: B:170:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00ff  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void L(final cz.mobilesoft.coreblock.scene.schedule.condition.ConditionDTO.LaunchCountDTO r29, final boolean r30, final java.lang.Long r31, final kotlin.jvm.functions.Function1 r32, boolean r33, boolean r34, boolean r35, java.lang.Float r36, final kotlin.jvm.functions.Function0 r37, androidx.compose.runtime.Composer r38, final int r39, final int r40) {
        /*
            Method dump skipped, instruction units count: 766
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.schedule.condition.launchcount.LaunchCountConditionScreenKt.L(cz.mobilesoft.coreblock.scene.schedule.condition.ConditionDTO$LaunchCountDTO, boolean, java.lang.Long, kotlin.jvm.functions.Function1, boolean, boolean, boolean, java.lang.Float, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ParametersHolder M(ConditionDTO.LaunchCountDTO launchCountDTO, Long l3, boolean z2) {
        return ParametersHolderKt.b(launchCountDTO, l3, Boolean.valueOf(z2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit N(boolean z2, Function1 function1) {
        if (z2) {
            function1.invoke(LaunchCountConditionViewEvent.OnCloseClicked.f115235a);
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit O(Function1 function1) {
        function1.invoke(new LaunchCountConditionViewEvent.LaunchCountTimeConditionViewEvent(TimeConditionViewEvent.OnDismissTimeRangePickerBottomSheet.f115754a));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit P(Function1 function1, LaunchCountConditionViewState launchCountConditionViewState, long j3, long j4) {
        function1.invoke(new LaunchCountConditionViewEvent.LaunchCountTimeConditionViewEvent(new TimeConditionViewEvent.OnIntervalSet(launchCountConditionViewState.d().g(), j3, j4)));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Q(ConditionDTO.LaunchCountDTO launchCountDTO, boolean z2, Long l3, Function1 function1, boolean z3, boolean z4, boolean z5, Float f3, Function0 function0, int i3, int i4, Composer composer, int i5) {
        L(launchCountDTO, z2, l3, function1, z3, z4, z5, f3, function0, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    public static final void R(final LaunchCountConditionConfigurationViewState viewState, final Function1 onTabSelected, final Function1 onLaunchCountChanged, Composer composer, final int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(viewState, "viewState");
        Intrinsics.checkNotNullParameter(onTabSelected, "onTabSelected");
        Intrinsics.checkNotNullParameter(onLaunchCountChanged, "onLaunchCountChanged");
        Composer composerK = composer.k(831975916);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(viewState) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(onTabSelected) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.I(onLaunchCountChanged) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if (composerK.r((i4 & 147) != 146, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(831975916, i4, -1, "cz.mobilesoft.coreblock.scene.schedule.condition.launchcount.LaunchCountSelectionContent (LaunchCountConditionScreen.kt:249)");
            }
            CardsKt.k(PaddingKt.k(PaddingKt.k(SizeKt.h(Modifier.b8, 0.0f, 1, null), PrimitiveResources_androidKt.a(R.dimen.f95467a, composerK, 0), 0.0f, 2, null), 0.0f, Dp.g(8), 1, null), 0L, 0.0f, null, null, ComposableLambdaKt.e(-98980145, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.schedule.condition.launchcount.f
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return LaunchCountConditionScreenKt.S(viewState, onTabSelected, onLaunchCountChanged, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerK, 54), composerK, 196608, 30);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.schedule.condition.launchcount.q
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return LaunchCountConditionScreenKt.X(viewState, onTabSelected, onLaunchCountChanged, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit S(LaunchCountConditionConfigurationViewState launchCountConditionConfigurationViewState, final Function1 function1, final Function1 function12, ColumnScope BaseCard, Composer composer, int i3) {
        Function0 function0;
        Intrinsics.checkNotNullParameter(BaseCard, "$this$BaseCard");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-98980145, i3, -1, "cz.mobilesoft.coreblock.scene.schedule.condition.launchcount.LaunchCountSelectionContent.<anonymous> (LaunchCountConditionScreen.kt:256)");
            }
            Modifier.Companion companion = Modifier.b8;
            float f3 = 16;
            Modifier modifierH = SizeKt.h(PaddingKt.i(companion, Dp.g(f3)), 0.0f, 1, null);
            Arrangement arrangement = Arrangement.f6574a;
            Arrangement.Vertical verticalH = arrangement.h();
            Alignment.Companion companion2 = Alignment.f25072a;
            MeasurePolicy measurePolicyA = ColumnKt.a(verticalH, companion2.k(), composer, 0);
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
            Updater.e(composerA, measurePolicyA, companion3.e());
            Updater.e(composerA, compositionLocalMapU, companion3.g());
            Function2 function2B = companion3.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion3.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            EnumEntries<UsageLimit.PeriodType> entries = UsageLimit.PeriodType.getEntries();
            int iOrdinal = launchCountConditionConfigurationViewState.i().ordinal();
            boolean Z = composer.Z(function1);
            Object objG = composer.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = new Function2() { // from class: cz.mobilesoft.coreblock.scene.schedule.condition.launchcount.g
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return LaunchCountConditionScreenKt.T(function1, ((Integer) obj).intValue(), (UsageLimit.PeriodType) obj2);
                    }
                };
                composer.w(objG);
            }
            ChipKt.o(null, false, 0.0f, entries, iOrdinal, 0L, (Function2) objG, null, new Function3() { // from class: cz.mobilesoft.coreblock.scene.schedule.condition.launchcount.h
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return LaunchCountConditionScreenKt.U((UsageLimit.PeriodType) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer, 0, 167);
            Modifier modifierM = PaddingKt.m(SizeKt.h(companion, 0.0f, 1, null), 0.0f, Dp.g(10), 0.0f, 0.0f, 13, null);
            MeasurePolicy measurePolicyB = RowKt.b(arrangement.g(), companion2.i(), composer, 48);
            int iA2 = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU2 = composer.u();
            Modifier modifierF2 = ComposedModifierKt.f(composer, modifierM);
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
            Updater.e(composerA2, measurePolicyB, companion3.e());
            Updater.e(composerA2, compositionLocalMapU2, companion3.g());
            Function2 function2B2 = companion3.b();
            if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                composerA2.w(Integer.valueOf(iA2));
                composerA2.p(Integer.valueOf(iA2), function2B2);
            }
            Updater.e(composerA2, modifierF2, companion3.f());
            RowScopeInstance rowScopeInstance = RowScopeInstance.f7101a;
            FlatButtonColors flatButtonColors = launchCountConditionConfigurationViewState.f() > 0 ? FlatButtonColors.Secondary.f131167a : FlatButtonColors.Disabled.f131162a;
            int i4 = R.drawable.h6;
            if (launchCountConditionConfigurationViewState.f() > 0) {
                composer.a0(1124530213);
                boolean Z2 = composer.Z(function12);
                Object objG2 = composer.G();
                if (Z2 || objG2 == Composer.f23746a.a()) {
                    objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.schedule.condition.launchcount.i
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return LaunchCountConditionScreenKt.V(function12);
                        }
                    };
                    composer.w(objG2);
                }
                function0 = (Function0) objG2;
                composer.U();
            } else {
                composer.a0(1124617012);
                composer.U();
                function0 = null;
            }
            FlatButtonsKt.K(null, 0.0f, i4, flatButtonColors, "Decrease", function0, composer, 24576, 3);
            Modifier modifierC = RowScope.c(rowScopeInstance, companion, 1.0f, false, 2, null);
            MeasurePolicy measurePolicyA2 = ColumnKt.a(arrangement.h(), companion2.g(), composer, 48);
            int iA3 = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU3 = composer.u();
            Modifier modifierF3 = ComposedModifierKt.f(composer, modifierC);
            Function0 function0A3 = companion3.a();
            if (composer.m() == null) {
                ComposablesKt.c();
            }
            composer.L();
            if (composer.i()) {
                composer.P(function0A3);
            } else {
                composer.v();
            }
            Composer composerA3 = Updater.a(composer);
            Updater.e(composerA3, measurePolicyA2, companion3.e());
            Updater.e(composerA3, compositionLocalMapU3, companion3.g());
            Function2 function2B3 = companion3.b();
            if (composerA3.i() || !Intrinsics.areEqual(composerA3.G(), Integer.valueOf(iA3))) {
                composerA3.w(Integer.valueOf(iA3));
                composerA3.p(Integer.valueOf(iA3), function2B3);
            }
            Updater.e(composerA3, modifierF3, companion3.f());
            TextKt.c(launchCountConditionConfigurationViewState.f() + "×", null, ComposeColorsKt.j(composer, 0).p(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).e(), composer, 0, 0, 65530);
            TextKt.c(StringHelperExtKt.e(StringResources_androidKt.b(launchCountConditionConfigurationViewState.i().getPerPeriodRes(), composer, 0)), null, ComposeColorsKt.j(composer, 0).q(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).d(), composer, 0, 0, 65530);
            composer.y();
            FlatButtonColors.Secondary secondary = FlatButtonColors.Secondary.f131167a;
            int i5 = R.drawable.f95558r0;
            boolean Z3 = composer.Z(function12);
            Object objG3 = composer.G();
            if (Z3 || objG3 == Composer.f23746a.a()) {
                objG3 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.schedule.condition.launchcount.j
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return LaunchCountConditionScreenKt.W(function12);
                    }
                };
                composer.w(objG3);
            }
            FlatButtonsKt.K(null, 0.0f, i5, secondary, "Increase", (Function0) objG3, composer, 27648, 3);
            composer.y();
            if (launchCountConditionConfigurationViewState.k()) {
                composer.a0(974678877);
            } else {
                composer.a0(987714129);
                SpacerKt.a(SizeKt.i(companion, Dp.g(f3)), composer, 6);
                BaseConditionScreenKt.x0(PremiumFeature.LAUNCH_COUNT_UNLIMITED, composer, 6);
            }
            composer.U();
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
    public static final Unit T(Function1 function1, int i3, UsageLimit.PeriodType periodType) {
        Intrinsics.checkNotNullParameter(periodType, "periodType");
        function1.invoke(periodType);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String U(UsageLimit.PeriodType SelectableChipRow, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(SelectableChipRow, "$this$SelectableChipRow");
        composer.a0(1737180692);
        if (ComposerKt.M()) {
            ComposerKt.U(1737180692, i3, -1, "cz.mobilesoft.coreblock.scene.schedule.condition.launchcount.LaunchCountSelectionContent.<anonymous>.<anonymous>.<anonymous> (LaunchCountConditionScreen.kt:267)");
        }
        String lowerCase = StringResources_androidKt.b(SelectableChipRow.getTitleRes(), composer, 0).toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        String strC = StringHelperExtKt.c(lowerCase);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        return strC;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit V(Function1 function1) {
        function1.invoke(-1);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit W(Function1 function1) {
        function1.invoke(1);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit X(LaunchCountConditionConfigurationViewState launchCountConditionConfigurationViewState, Function1 function1, Function1 function12, int i3, Composer composer, int i4) {
        R(launchCountConditionConfigurationViewState, function1, function12, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:121:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:126:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00c4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final void Y(final androidx.compose.material.ScaffoldState r22, final cz.mobilesoft.coreblock.scene.schedule.condition.launchcount.LaunchCountConditionViewState r23, boolean r24, boolean r25, boolean r26, java.lang.Float r27, final kotlin.jvm.functions.Function1 r28, androidx.compose.runtime.Composer r29, final int r30, final int r31) {
        /*
            Method dump skipped, instruction units count: 418
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.schedule.condition.launchcount.LaunchCountConditionScreenKt.Y(androidx.compose.material.ScaffoldState, cz.mobilesoft.coreblock.scene.schedule.condition.launchcount.LaunchCountConditionViewState, boolean, boolean, boolean, java.lang.Float, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Z(Function1 function1) {
        function1.invoke(LaunchCountConditionViewEvent.OnCloseClicked.f115235a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit a0(Function1 function1) {
        function1.invoke(LaunchCountConditionViewEvent.OnSaveClicked.f115238a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit b0(LaunchCountConditionViewState launchCountConditionViewState, Function1 function1, ColumnScope BaseConditionScreen, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(BaseConditionScreen, "$this$BaseConditionScreen");
        if ((i3 & 6) == 0) {
            i3 |= composer.Z(BaseConditionScreen) ? 4 : 2;
        }
        if (composer.r((i3 & 19) != 18, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-142433137, i3, -1, "cz.mobilesoft.coreblock.scene.schedule.condition.launchcount.RootCompose.<anonymous> (LaunchCountConditionScreen.kt:191)");
            }
            C(BaseConditionScreen, launchCountConditionViewState, function1, composer, i3 & 14);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit c0(ScaffoldState scaffoldState, LaunchCountConditionViewState launchCountConditionViewState, boolean z2, boolean z3, boolean z4, Float f3, Function1 function1, int i3, int i4, Composer composer, int i5) {
        Y(scaffoldState, launchCountConditionViewState, z2, z3, z4, f3, function1, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    private static final void z(final CoroutineScope coroutineScope, final ScaffoldState scaffoldState, final boolean z2, final LaunchCountConditionViewModel launchCountConditionViewModel, final Function1 function1, final Function0 function0, Composer composer, final int i3) {
        int i4;
        ScaffoldState scaffoldState2;
        LaunchCountConditionViewModel launchCountConditionViewModel2;
        Function1 function12;
        Composer composer2;
        Composer composerK = composer.k(528293276);
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
            launchCountConditionViewModel2 = launchCountConditionViewModel;
            i4 |= composerK.I(launchCountConditionViewModel2) ? 2048 : 1024;
        } else {
            launchCountConditionViewModel2 = launchCountConditionViewModel;
        }
        if ((i3 & 24576) == 0) {
            function12 = function1;
            i4 |= composerK.I(function12) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        } else {
            function12 = function1;
        }
        if ((196608 & i3) == 0) {
            i4 |= composerK.I(function0) ? 131072 : NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
        }
        int i5 = i4;
        if (composerK.r((74899 & i5) != 74898, i5 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(528293276, i5, -1, "cz.mobilesoft.coreblock.scene.schedule.condition.launchcount.CommandProcessor (LaunchCountConditionScreen.kt:134)");
            }
            Object objG = composerK.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG == companion.a()) {
                objG = SnapshotStateKt__SnapshotStateKt.e(Boolean.FALSE, null, 2, null);
                composerK.w(objG);
            }
            MutableState mutableState = (MutableState) objG;
            int i6 = 458752 & i5;
            boolean z3 = ((i5 & 896) == 256) | (i6 == 131072);
            Object objG2 = composerK.G();
            if (z3 || objG2 == companion.a()) {
                objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.schedule.condition.launchcount.p
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return LaunchCountConditionScreenKt.A(z2, function0);
                    }
                };
                composerK.w(objG2);
            }
            ComposeDialogsKt.H0(mutableState, (Function0) objG2, composerK, 6);
            boolean zI = (i6 == 131072) | ((i5 & 112) == 32) | composerK.I(coroutineScope) | ((57344 & i5) == 16384);
            Object objG3 = composerK.G();
            if (zI || objG3 == companion.a()) {
                LaunchCountConditionScreenKt$CommandProcessor$2$1 launchCountConditionScreenKt$CommandProcessor$2$1 = new LaunchCountConditionScreenKt$CommandProcessor$2$1(function0, mutableState, scaffoldState2, coroutineScope, function12, null);
                composerK.w(launchCountConditionScreenKt$CommandProcessor$2$1);
                objG3 = launchCountConditionScreenKt$CommandProcessor$2$1;
            }
            composer2 = composerK;
            FlowExtKt.g(launchCountConditionViewModel2, null, (Function2) objG3, composer2, (i5 >> 9) & 14, 2);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer2 = composerK;
            composer2.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.schedule.condition.launchcount.r
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return LaunchCountConditionScreenKt.B(coroutineScope, scaffoldState, z2, launchCountConditionViewModel, function1, function0, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}
