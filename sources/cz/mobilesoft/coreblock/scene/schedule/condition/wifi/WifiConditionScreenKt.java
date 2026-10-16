package cz.mobilesoft.coreblock.scene.schedule.condition.wifi;

import android.content.Context;
import androidx.activity.compose.ActivityResultRegistryKt;
import androidx.activity.compose.ManagedActivityResultLauncher;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.compose.animation.AnimatedContentScope;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.LazyListStateKt;
import androidx.compose.material.IconKt;
import androidx.compose.material.ScaffoldState;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.SignalWifiOffKt;
import androidx.compose.material3.CheckboxKt;
import androidx.compose.material3.TextKt;
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
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.PrimitiveResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.res.VectorResources_androidKt;
import androidx.compose.ui.unit.Dp;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavController;
import androidx.navigation.NavGraphBuilder;
import androidx.navigation.NavHostController;
import androidx.navigation.compose.NavGraphBuilderKt;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.google.android.material.bottomsheet.lKiE.YznnJpHcAmeoW;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.enums.ProfileType;
import cz.mobilesoft.coreblock.scene.schedule.condition.BaseConditionScreenKt;
import cz.mobilesoft.coreblock.scene.schedule.condition.ConditionDTO;
import cz.mobilesoft.coreblock.scene.schedule.condition.IntervalDTO;
import cz.mobilesoft.coreblock.scene.schedule.condition.time.Configuration;
import cz.mobilesoft.coreblock.scene.schedule.condition.time.TimeConditionConfigurationViewState;
import cz.mobilesoft.coreblock.scene.schedule.condition.time.TimeConditionViewEvent;
import cz.mobilesoft.coreblock.scene.schedule.condition.time.Wifi;
import cz.mobilesoft.coreblock.scene.schedule.condition.time.WifiConfigurationViewState;
import cz.mobilesoft.coreblock.scene.schedule.condition.wifi.SharedWifiConditionEvent;
import cz.mobilesoft.coreblock.scene.schedule.condition.wifi.WifiConditionScreenNavigation;
import cz.mobilesoft.coreblock.scene.schedule.condition.wifi.WifiConditionViewEvent;
import cz.mobilesoft.coreblock.util.Success;
import cz.mobilesoft.coreblock.util.analytics.AnswersHelper;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.util.compose.FlowExtKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.util.helperextension.StringHelperExtKt;
import cz.mobilesoft.coreblock.view.compose.ComposeButtonsKt;
import cz.mobilesoft.coreblock.view.compose.ComposeDialogsKt;
import cz.mobilesoft.coreblock.view.compose.material3.CardsKt;
import cz.mobilesoft.coreblock.view.compose.material3.FlatButtonColors;
import cz.mobilesoft.coreblock.view.compose.material3.FlatButtonsKt;
import cz.mobilesoft.coreblock.view.compose.skeleton.SkeletonPresets;
import cz.mobilesoft.coreblock.view.compose.skeleton.StructuredSkeletonKt;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CoroutineScope;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.parameter.ParametersHolderKt;
import org.threeten.bp.DayOfWeek;
import org.xmlpull.v1.XmlPullParserException;

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
public final class WifiConditionScreenKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit A0(Function1 function1, MutableState mutableState) {
        x0(mutableState, "");
        function1.invoke(new WifiConditionViewEvent.OnSharedWifiConditionEvent(new SharedWifiConditionEvent.OnSearchOpenStateChanged(false)));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit B0(Function1 function1) {
        function1.invoke(new WifiConditionViewEvent.OnSharedWifiConditionEvent(new SharedWifiConditionEvent.OnSearchOpenStateChanged(true)));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit C0(WifiConfigurationViewState wifiConfigurationViewState, boolean z2, boolean z3, Function1 function1, Function0 function0, int i3, int i4, Composer composer, int i5) {
        v0(wifiConfigurationViewState, z2, z3, function1, function0, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:170:0x02fc  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0309  */
    /* JADX WARN: Removed duplicated region for block: B:175:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00fd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void D0(final cz.mobilesoft.coreblock.scene.schedule.condition.ConditionDTO.WifisDTO r28, final java.lang.Long r29, final boolean r30, boolean r31, boolean r32, java.lang.Float r33, boolean r34, final kotlin.jvm.functions.Function1 r35, final kotlin.jvm.functions.Function0 r36, androidx.compose.runtime.Composer r37, final int r38, final int r39) {
        /*
            Method dump skipped, instruction units count: 798
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.schedule.condition.wifi.WifiConditionScreenKt.D0(cz.mobilesoft.coreblock.scene.schedule.condition.ConditionDTO$WifisDTO, java.lang.Long, boolean, boolean, boolean, java.lang.Float, boolean, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ParametersHolder E0(ConditionDTO.WifisDTO wifisDTO, Long l3, boolean z2) {
        return ParametersHolderKt.b(wifisDTO, l3, Boolean.valueOf(z2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit F0(WifiConditionViewState wifiConditionViewState, Function1 function1, boolean z2) {
        if (wifiConditionViewState.d().o()) {
            function1.invoke(new WifiConditionViewEvent.OnSharedWifiConditionEvent(new SharedWifiConditionEvent.OnSearchOpenStateChanged(false)));
        } else if (z2) {
            function1.invoke(WifiConditionViewEvent.OnCloseClicked.f116041a);
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit G0(Function1 function1) {
        function1.invoke(new WifiConditionViewEvent.WifiTimeConditionViewEvent(TimeConditionViewEvent.OnDismissTimeRangePickerBottomSheet.f115754a));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit H0(Function1 function1, WifiConditionViewState wifiConditionViewState, long j3, long j4) {
        function1.invoke(new WifiConditionViewEvent.WifiTimeConditionViewEvent(new TimeConditionViewEvent.OnIntervalSet(wifiConditionViewState.c().g(), j3, j4)));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit I0(Function1 function1, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(event, "event");
        if (event == Lifecycle.Event.ON_RESUME) {
            function1.invoke(new WifiConditionViewEvent.OnSharedWifiConditionEvent(SharedWifiConditionEvent.CheckPermissionState.f115990a));
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit J0(ConditionDTO.WifisDTO wifisDTO, Long l3, boolean z2, boolean z3, boolean z4, Float f3, boolean z5, Function1 function1, Function0 function0, int i3, int i4, Composer composer, int i5) {
        D0(wifisDTO, l3, z2, z3, z4, f3, z5, function1, function0, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    public static final void K0(final Wifi wifi, final Function1 onEvent, Composer composer, final int i3) throws XmlPullParserException, IOException {
        int i4;
        ImageVector imageVectorB;
        Intrinsics.checkNotNullParameter(wifi, "wifi");
        Intrinsics.checkNotNullParameter(onEvent, "onEvent");
        Composer composerK = composer.k(163780771);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(wifi) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(onEvent) ? 32 : 16;
        }
        if (composerK.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(163780771, i4, -1, "cz.mobilesoft.coreblock.scene.schedule.condition.wifi.WifiRow (WifiConditionScreen.kt:702)");
            }
            boolean z2 = (i4 & 112) == 32;
            int i5 = i4 & 14;
            boolean z3 = z2 | (i5 == 4);
            Object objG = composerK.G();
            if (z3 || objG == Composer.f23746a.a()) {
                objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.schedule.condition.wifi.j0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return WifiConditionScreenKt.L0(onEvent, wifi, ((Boolean) obj).booleanValue());
                    }
                };
                composerK.w(objG);
            }
            final Function1 function1 = (Function1) objG;
            Alignment.Companion companion = Alignment.f25072a;
            Alignment.Vertical verticalI = companion.i();
            Arrangement arrangement = Arrangement.f6574a;
            Arrangement.HorizontalOrVertical horizontalOrVerticalO = arrangement.o(Dp.g(16));
            Modifier.Companion companion2 = Modifier.b8;
            Modifier modifierK = PaddingKt.k(SizeKt.i(SizeKt.h(companion2, 0.0f, 1, null), Dp.g(56)), PrimitiveResources_androidKt.a(R.dimen.f95467a, composerK, 0), 0.0f, 2, null);
            boolean Z = (i5 == 4) | composerK.Z(function1);
            Object objG2 = composerK.G();
            if (Z || objG2 == Composer.f23746a.a()) {
                objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.schedule.condition.wifi.k0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return WifiConditionScreenKt.M0(function1, wifi);
                    }
                };
                composerK.w(objG2);
            }
            Modifier modifierF = ClickableKt.f(modifierK, false, null, null, (Function0) objG2, 7, null);
            MeasurePolicy measurePolicyB = RowKt.b(horizontalOrVerticalO, verticalI, composerK, 54);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF2 = ComposedModifierKt.f(composerK, modifierF);
            ComposeUiNode.Companion companion3 = ComposeUiNode.f8;
            Function0 function0A = companion3.a();
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
            Updater.e(composerA, measurePolicyB, companion3.e());
            Updater.e(composerA, compositionLocalMapU, companion3.g());
            Function2 function2B = companion3.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF2, companion3.f());
            RowScopeInstance rowScopeInstance = RowScopeInstance.f7101a;
            if (wifi.f() || wifi.h()) {
                composerK.a0(-1133917454);
                imageVectorB = VectorResources_androidKt.b(ImageVector.f26323k, R.drawable.Y6, composerK, 6);
                composerK.U();
            } else {
                composerK.a0(-1133915468);
                composerK.U();
                imageVectorB = SignalWifiOffKt.a(Icons.f15145a.a());
            }
            FlatButtonsKt.L(null, Dp.g(40), imageVectorB, wifi.f() ? FlatButtonColors.Primary.f131166a : FlatButtonColors.Secondary.f131167a, null, null, composerK, 24624, 33);
            Modifier modifierC = RowScope.c(rowScopeInstance, companion2, 1.0f, false, 2, null);
            MeasurePolicy measurePolicyA = ColumnKt.a(arrangement.h(), companion.k(), composerK, 0);
            int iA2 = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU2 = composerK.u();
            Modifier modifierF3 = ComposedModifierKt.f(composerK, modifierC);
            Function0 function0A2 = companion3.a();
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
            Updater.e(composerA2, measurePolicyA, companion3.e());
            Updater.e(composerA2, compositionLocalMapU2, companion3.g());
            Function2 function2B2 = companion3.b();
            if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                composerA2.w(Integer.valueOf(iA2));
                composerA2.p(Integer.valueOf(iA2), function2B2);
            }
            Updater.e(composerA2, modifierF3, companion3.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            TextKt.c(wifi.d(), null, ComposeColorsKt.j(composerK, 0).p(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 1, 0, null, ComposeTypographyKt.g(composerK, 0).h(), composerK, 0, 3072, 57338);
            composerK = composerK;
            if (wifi.f()) {
                composerK.a0(374304573);
                TextKt.c(StringResources_androidKt.b(R.string.g8, composerK, 0), null, ComposeColorsKt.j(composerK, 0).q(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composerK, 0).d(), composerK, 0, 0, 65530);
                composerK = composerK;
            } else {
                composerK.a0(343982853);
            }
            composerK.U();
            composerK.y();
            CheckboxKt.a(wifi.e(), function1, null, !wifi.g(), ComposeColorsKt.h(composerK, 0), null, composerK, 0, 36);
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.schedule.condition.wifi.m0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return WifiConditionScreenKt.N0(wifi, onEvent, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit L0(Function1 function1, Wifi wifi, boolean z2) {
        function1.invoke(new WifiConditionViewEvent.OnSharedWifiConditionEvent(new SharedWifiConditionEvent.OnWifiCheckedChanged(wifi, z2)));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit M0(Function1 function1, Wifi wifi) {
        function1.invoke(Boolean.valueOf(!wifi.e()));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit N0(Wifi wifi, Function1 function1, int i3, Composer composer, int i4) throws XmlPullParserException, IOException {
        K0(wifi, function1, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    public static final void O0(boolean z2, final Function0 onClick, final int i3, Composer composer, final int i4, final int i5) {
        int i6;
        final boolean z3;
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Composer composerK = composer.k(-845864937);
        int i7 = i5 & 1;
        if (i7 != 0) {
            i6 = i4 | 6;
        } else if ((i4 & 6) == 0) {
            i6 = (composerK.b(z2) ? 4 : 2) | i4;
        } else {
            i6 = i4;
        }
        if ((i4 & 48) == 0) {
            i6 |= composerK.I(onClick) ? 32 : 16;
        }
        if ((i4 & 384) == 0) {
            i6 |= composerK.e(i3) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if (composerK.r((i6 & 147) != 146, i6 & 1)) {
            boolean z4 = i7 != 0 ? true : z2;
            if (ComposerKt.M()) {
                ComposerKt.U(-845864937, i6, -1, "cz.mobilesoft.coreblock.scene.schedule.condition.wifi.WifiSelectionContent (WifiConditionScreen.kt:489)");
            }
            CardsKt.j(PaddingKt.k(PaddingKt.k(SizeKt.h(Modifier.b8, 0.0f, 1, null), PrimitiveResources_androidKt.a(R.dimen.f95467a, composerK, 0), 0.0f, 2, null), 0.0f, Dp.g(8), 1, null), 0L, 0.0f, z4, null, onClick, ComposableLambdaKt.e(1452148027, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.schedule.condition.wifi.b0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return WifiConditionScreenKt.P0(i3, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerK, 54), composerK, ((i6 << 9) & 7168) | 1572864 | ((i6 << 12) & 458752), 22);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
            z3 = z4;
        } else {
            composerK.Q();
            z3 = z2;
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.schedule.condition.wifi.c0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return WifiConditionScreenKt.Q0(z3, onClick, i3, i4, i5, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit P0(int i3, ColumnScope BaseCard, Composer composer, int i4) {
        int i5;
        long jB;
        Intrinsics.checkNotNullParameter(BaseCard, "$this$BaseCard");
        if (composer.r((i4 & 17) != 16, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1452148027, i4, -1, "cz.mobilesoft.coreblock.scene.schedule.condition.wifi.WifiSelectionContent.<anonymous> (WifiConditionScreen.kt:498)");
            }
            Modifier.Companion companion = Modifier.b8;
            float f3 = 16;
            Modifier modifierJ = PaddingKt.j(SizeKt.f(companion, 0.0f, 1, null), Dp.g(f3), Dp.g(20));
            Alignment.Companion companion2 = Alignment.f25072a;
            Alignment.Vertical verticalI = companion2.i();
            Arrangement arrangement = Arrangement.f6574a;
            MeasurePolicy measurePolicyB = RowKt.b(arrangement.g(), verticalI, composer, 48);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, modifierJ);
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
            androidx.compose.material.TextKt.c(StringHelperExtKt.c("Wi-fi networks"), RowScope.c(RowScopeInstance.f7101a, companion, 1.0f, false, 2, null), ComposeColorsKt.j(composer, 0).p(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).h(), composer, 0, 0, 65528);
            if (i3 == 0) {
                composer.a0(1452244652);
                i5 = 0;
                jB = ComposeColorsKt.j(composer, 0).q();
            } else {
                i5 = 0;
                composer.a0(1452245477);
                jB = ComposeColorsKt.j(composer, 0).b();
            }
            composer.U();
            long j3 = jB;
            MeasurePolicy measurePolicyB2 = RowKt.b(arrangement.g(), companion2.i(), composer, 48);
            int iA2 = ComposablesKt.a(composer, i5);
            CompositionLocalMap compositionLocalMapU2 = composer.u();
            Modifier modifierF2 = ComposedModifierKt.f(composer, companion);
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
            Updater.e(composerA2, measurePolicyB2, companion3.e());
            Updater.e(composerA2, compositionLocalMapU2, companion3.g());
            Function2 function2B2 = companion3.b();
            if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                composerA2.w(Integer.valueOf(iA2));
                composerA2.p(Integer.valueOf(iA2), function2B2);
            }
            Updater.e(composerA2, modifierF2, companion3.f());
            IconKt.a(PainterResources_androidKt.c(R.drawable.Y6, composer, i5), null, SizeKt.v(companion, Dp.g(f3)), j3, composer, 432, 0);
            androidx.compose.material.TextKt.c(String.valueOf(i3), PaddingKt.k(companion, Dp.g(2), 0.0f, 2, null), j3, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, i5).j(), composer, 48, 0, 65528);
            composer.y();
            IconKt.b(VectorResources_androidKt.b(ImageVector.f26323k, R.drawable.f95580y1, composer, 6), null, SizeKt.v(companion, Dp.g(24)), ComposeColorsKt.j(composer, 0).q(), composer, 432, 0);
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
    public static final Unit Q0(boolean z2, Function0 function0, int i3, int i4, int i5, Composer composer, int i6) {
        O0(z2, function0, i3, composer, RecomposeScopeImplKt.a(i4 | 1), i5);
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:108:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00f2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void R0(final androidx.compose.material.ScaffoldState r18, final cz.mobilesoft.coreblock.scene.schedule.condition.time.WifiConfigurationViewState r19, boolean r20, boolean r21, boolean r22, java.lang.Float r23, final kotlin.jvm.functions.Function1 r24, final kotlin.jvm.functions.Function0 r25, androidx.compose.runtime.Composer r26, final int r27, final int r28) {
        /*
            Method dump skipped, instruction units count: 407
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.schedule.condition.wifi.WifiConditionScreenKt.R0(androidx.compose.material.ScaffoldState, cz.mobilesoft.coreblock.scene.schedule.condition.time.WifiConfigurationViewState, boolean, boolean, boolean, java.lang.Float, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int):void");
    }

    private static final void S(final CoroutineScope coroutineScope, final ScaffoldState scaffoldState, final boolean z2, final WifiConditionViewModel wifiConditionViewModel, final Function1 function1, final Function1 function12, final Function0 function0, Composer composer, final int i3) {
        int i4;
        Composer composer2;
        Composer composerK = composer.k(-1109772992);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(coroutineScope) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.Z(scaffoldState) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.b(z2) ? 256 : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            i4 |= composerK.I(wifiConditionViewModel) ? 2048 : 1024;
        }
        if ((i3 & 24576) == 0) {
            i4 |= composerK.I(function1) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        }
        if ((196608 & i3) == 0) {
            i4 |= composerK.I(function12) ? 131072 : NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
        }
        if ((i3 & 1572864) == 0) {
            i4 |= composerK.I(function0) ? 1048576 : 524288;
        }
        if (composerK.r((i4 & 599187) != 599186, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1109772992, i4, -1, "cz.mobilesoft.coreblock.scene.schedule.condition.wifi.CommandProcessor (WifiConditionScreen.kt:256)");
            }
            Context context = (Context) composerK.q(AndroidCompositionLocals_androidKt.g());
            Object objG = composerK.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG == companion.a()) {
                objG = SnapshotStateKt__SnapshotStateKt.e(Boolean.FALSE, null, 2, null);
                composerK.w(objG);
            }
            MutableState mutableState = (MutableState) objG;
            int i5 = i4 & 896;
            int i6 = i4 & 3670016;
            int i7 = i4;
            boolean z3 = (i6 == 1048576) | (i5 == 256);
            Object objG2 = composerK.G();
            if (z3 || objG2 == companion.a()) {
                objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.schedule.condition.wifi.v0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return WifiConditionScreenKt.T(z2, function0);
                    }
                };
                composerK.w(objG2);
            }
            ComposeDialogsKt.H0(mutableState, (Function0) objG2, composerK, 6);
            ActivityResultContracts.StartActivityForResult startActivityForResult = new ActivityResultContracts.StartActivityForResult();
            int i8 = i7 & 57344;
            boolean z4 = (i8 == 16384) | (i6 == 1048576);
            Object objG3 = composerK.G();
            if (z4 || objG3 == companion.a()) {
                objG3 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.schedule.condition.wifi.x0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return WifiConditionScreenKt.U(function0, function1, (ActivityResult) obj);
                    }
                };
                composerK.w(objG3);
            }
            ManagedActivityResultLauncher managedActivityResultLauncherA = ActivityResultRegistryKt.a(startActivityForResult, (Function1) objG3, composerK, 0);
            ActivityResultContracts.RequestMultiplePermissions requestMultiplePermissions = new ActivityResultContracts.RequestMultiplePermissions();
            boolean z5 = i6 == 1048576;
            Object objG4 = composerK.G();
            if (z5 || objG4 == companion.a()) {
                objG4 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.schedule.condition.wifi.y0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return WifiConditionScreenKt.V(function0, (Map) obj);
                    }
                };
                composerK.w(objG4);
            }
            ManagedActivityResultLauncher managedActivityResultLauncherA2 = ActivityResultRegistryKt.a(requestMultiplePermissions, (Function1) objG4, composerK, 0);
            ActivityResultContracts.StartIntentSenderForResult startIntentSenderForResult = new ActivityResultContracts.StartIntentSenderForResult();
            boolean z6 = (i8 == 16384) | (i5 == 256) | (i6 == 1048576);
            Object objG5 = composerK.G();
            if (z6 || objG5 == companion.a()) {
                objG5 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.schedule.condition.wifi.z0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return WifiConditionScreenKt.W(function1, z2, function0, (ActivityResult) obj);
                    }
                };
                composerK.w(objG5);
            }
            ManagedActivityResultLauncher managedActivityResultLauncherA3 = ActivityResultRegistryKt.a(startIntentSenderForResult, (Function1) objG5, composerK, 0);
            boolean zI = ((i7 & 458752) == 131072) | (i6 == 1048576) | ((i7 & 112) == 32) | composerK.I(coroutineScope) | composerK.I(context) | (i8 == 16384) | composerK.I(managedActivityResultLauncherA3) | composerK.I(managedActivityResultLauncherA) | composerK.I(managedActivityResultLauncherA2);
            Object objG6 = composerK.G();
            if (zI || objG6 == companion.a()) {
                WifiConditionScreenKt$CommandProcessor$2$1 wifiConditionScreenKt$CommandProcessor$2$1 = new WifiConditionScreenKt$CommandProcessor$2$1(function12, function0, mutableState, scaffoldState, coroutineScope, context, managedActivityResultLauncherA, managedActivityResultLauncherA2, function1, managedActivityResultLauncherA3, null);
                composerK.w(wifiConditionScreenKt$CommandProcessor$2$1);
                objG6 = wifiConditionScreenKt$CommandProcessor$2$1;
            }
            composer2 = composerK;
            FlowExtKt.g(wifiConditionViewModel, null, (Function2) objG6, composer2, (i7 >> 9) & 14, 2);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer2 = composerK;
            composer2.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.schedule.condition.wifi.a1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return WifiConditionScreenKt.X(coroutineScope, scaffoldState, z2, wifiConditionViewModel, function1, function12, function0, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit S0(WifiConfigurationViewState wifiConfigurationViewState, Function1 function1, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(952738189, i3, -1, "cz.mobilesoft.coreblock.scene.schedule.condition.wifi.WifiSelectionScreen.<anonymous> (WifiConditionScreen.kt:413)");
            }
            if (Intrinsics.areEqual(wifiConfigurationViewState.l(), Success.f128020a)) {
                composer.a0(1879548210);
                Y(wifiConfigurationViewState, function1, composer, 0);
                composer.U();
            } else {
                composer.a0(1879620223);
                c0(composer, 0);
                composer.U();
            }
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit T(boolean z2, Function0 function0) {
        AnswersHelper.f128199a.R4(ProfileType.WIFI, z2);
        function0.invoke();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit T0(WifiConfigurationViewState wifiConfigurationViewState, boolean z2, boolean z3, final Function1 function1, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-704370068, i3, -1, "cz.mobilesoft.coreblock.scene.schedule.condition.wifi.WifiSelectionScreen.<anonymous> (WifiConditionScreen.kt:402)");
            }
            boolean Z = composer.Z(function1);
            Object objG = composer.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.schedule.condition.wifi.z
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return WifiConditionScreenKt.U0(function1);
                    }
                };
                composer.w(objG);
            }
            v0(wifiConfigurationViewState, z2, z3, function1, (Function0) objG, composer, 0, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit U(Function0 function0, Function1 function1, ActivityResult it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (it.d() != -1) {
            function0.invoke();
        } else {
            function1.invoke(new WifiConditionViewEvent.OnSharedWifiConditionEvent(SharedWifiConditionEvent.OnPermissionsGranted.f115993a));
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit U0(Function1 function1) {
        function1.invoke(WifiConditionViewEvent.OnCloseClicked.f116041a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit V(Function0 function0, Map it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (it.isEmpty()) {
            function0.invoke();
        } else {
            Iterator it2 = it.entrySet().iterator();
            while (it2.hasNext()) {
                if (((Boolean) ((Map.Entry) it2.next()).getValue()).booleanValue()) {
                    break;
                }
            }
            function0.invoke();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit V0(ScaffoldState scaffoldState, WifiConfigurationViewState wifiConfigurationViewState, boolean z2, boolean z3, boolean z4, Float f3, Function1 function1, Function0 function0, int i3, int i4, Composer composer, int i5) {
        R0(scaffoldState, wifiConfigurationViewState, z2, z3, z4, f3, function1, function0, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit W(Function1 function1, boolean z2, Function0 function0, ActivityResult result) {
        Intrinsics.checkNotNullParameter(result, "result");
        if (result.d() == -1) {
            function1.invoke(new WifiConditionViewEvent.OnSharedWifiConditionEvent(SharedWifiConditionEvent.OnLocationServicesEnabled.f115991a));
        } else if (z2) {
            function0.invoke();
        } else {
            function1.invoke(new WifiConditionViewEvent.OnSharedWifiConditionEvent(SharedWifiConditionEvent.OnPermissionsDenied.f115992a));
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit X(CoroutineScope coroutineScope, ScaffoldState scaffoldState, boolean z2, WifiConditionViewModel wifiConditionViewModel, Function1 function1, Function1 function12, Function0 function0, int i3, Composer composer, int i4) {
        S(coroutineScope, scaffoldState, z2, wifiConditionViewModel, function1, function12, function0, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    public static final void Y(final WifiConfigurationViewState viewState, final Function1 onEvent, Composer composer, final int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(viewState, "viewState");
        Intrinsics.checkNotNullParameter(onEvent, "onEvent");
        Composer composerK = composer.k(-994188255);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(viewState) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(onEvent) ? 32 : 16;
        }
        if (composerK.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-994188255, i4, -1, "cz.mobilesoft.coreblock.scene.schedule.condition.wifi.Content (WifiConditionScreen.kt:647)");
            }
            Modifier.Companion companion = Modifier.b8;
            Modifier modifierG = ScrollKt.g(SizeKt.f(companion, 0.0f, 1, null), ScrollKt.c(0, composerK, 0, 1), false, null, false, 14, null);
            Arrangement arrangement = Arrangement.f6574a;
            MeasurePolicy measurePolicyA = ColumnKt.a(arrangement.h(), Alignment.f25072a.k(), composerK, 0);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierG);
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
            LazyListState lazyListStateB = LazyListStateKt.b(0, 0, composerK, 0, 3);
            String strJ = viewState.j();
            int i5 = i4 & 14;
            boolean Z = (i5 == 4) | composerK.Z(lazyListStateB);
            Object objG = composerK.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = new WifiConditionScreenKt$Content$1$1$1(viewState, lazyListStateB, null);
                composerK.w(objG);
            }
            EffectsKt.g(strJ, (Function2) objG, composerK, 0);
            float f3 = 8;
            PaddingValues paddingValuesE = PaddingKt.e(0.0f, 0.0f, 0.0f, Dp.g(f3), 7, null);
            Modifier modifierB = ColumnScope.b(columnScopeInstance, companion, 1.0f, false, 2, null);
            Arrangement.HorizontalOrVertical horizontalOrVerticalO = arrangement.o(Dp.g(f3));
            boolean z2 = (i5 == 4) | ((i4 & 112) == 32);
            Object objG2 = composerK.G();
            if (z2 || objG2 == Composer.f23746a.a()) {
                objG2 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.schedule.condition.wifi.w
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return WifiConditionScreenKt.Z(viewState, onEvent, (LazyListScope) obj);
                    }
                };
                composerK.w(objG2);
            }
            LazyDslKt.b(modifierB, lazyListStateB, paddingValuesE, false, horizontalOrVerticalO, null, null, false, null, (Function1) objG2, composerK, 24960, 488);
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.schedule.condition.wifi.x
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return WifiConditionScreenKt.b0(viewState, onEvent, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Z(final WifiConfigurationViewState wifiConfigurationViewState, final Function1 function1, LazyListScope LazyColumn) {
        Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
        int size = wifiConfigurationViewState.g().size();
        if (wifiConfigurationViewState.n()) {
            size++;
        }
        LazyListScope.b(LazyColumn, size, null, null, ComposableLambdaKt.c(1535038133, true, new Function4() { // from class: cz.mobilesoft.coreblock.scene.schedule.condition.wifi.d0
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return WifiConditionScreenKt.a0(wifiConfigurationViewState, function1, (LazyItemScope) obj, ((Integer) obj2).intValue(), (Composer) obj3, ((Integer) obj4).intValue());
            }
        }), 6, null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit a0(WifiConfigurationViewState wifiConfigurationViewState, Function1 function1, LazyItemScope items, int i3, Composer composer, int i4) throws XmlPullParserException, IOException {
        int i5;
        Unit unit;
        Intrinsics.checkNotNullParameter(items, "$this$items");
        if ((i4 & 48) == 0) {
            i5 = (composer.e(i3) ? 32 : 16) | i4;
        } else {
            i5 = i4;
        }
        if (composer.r((i5 & 145) != 144, i5 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1535038133, i5, -1, "cz.mobilesoft.coreblock.scene.schedule.condition.wifi.Content.<anonymous>.<anonymous>.<anonymous>.<anonymous> (WifiConditionScreen.kt:672)");
            }
            Wifi wifi = (Wifi) CollectionsKt.getOrNull(wifiConfigurationViewState.g(), i3);
            if (wifi == null) {
                composer.a0(1804279057);
                composer.U();
                unit = null;
            } else {
                composer.a0(1804279058);
                K0(wifi, function1, composer, 0);
                composer.U();
                unit = Unit.f139807a;
            }
            if (unit == null) {
                composer.a0(1997868479);
                StructuredSkeletonKt.E(true, SkeletonPresets.b(SkeletonPresets.f131964a, 0, 1, null), PaddingKt.i(SizeKt.f(Modifier.b8, 0.0f, 1, null), Dp.g(16)), false, null, ComposableSingletons$WifiConditionScreenKt.f115983a.n(), composer, 196998, 24);
                composer.U();
            } else {
                composer.a0(1997864325);
                composer.U();
            }
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit b0(WifiConfigurationViewState wifiConfigurationViewState, Function1 function1, int i3, Composer composer, int i4) {
        Y(wifiConfigurationViewState, function1, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    private static final void c0(Composer composer, final int i3) {
        Composer composerK = composer.k(504843048);
        if (composerK.r(i3 != 0, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(504843048, i3, -1, "cz.mobilesoft.coreblock.scene.schedule.condition.wifi.EmptyContent (WifiConditionScreen.kt:688)");
            }
            Modifier.Companion companion = Modifier.b8;
            MeasurePolicy measurePolicyG = BoxKt.g(Alignment.f25072a.o(), false);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, companion);
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
            StructuredSkeletonKt.E(true, SkeletonPresets.b(SkeletonPresets.f131964a, 0, 1, null), PaddingKt.i(SizeKt.f(companion, 0.0f, 1, null), Dp.g(16)), false, null, ComposableSingletons$WifiConditionScreenKt.f115983a.m(), composerK, 196998, 24);
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.schedule.condition.wifi.y
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return WifiConditionScreenKt.d0(i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit d0(int i3, Composer composer, int i4) {
        c0(composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:129:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x01b5  */
    /* JADX WARN: Removed duplicated region for block: B:134:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00dc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void e0(final androidx.compose.material.ScaffoldState r26, final cz.mobilesoft.coreblock.scene.schedule.condition.wifi.WifiConditionViewState r27, boolean r28, boolean r29, boolean r30, java.lang.Float r31, final kotlin.jvm.functions.Function1 r32, androidx.compose.runtime.Composer r33, final int r34, final int r35) {
        /*
            Method dump skipped, instruction units count: 455
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.schedule.condition.wifi.WifiConditionScreenKt.e0(androidx.compose.material.ScaffoldState, cz.mobilesoft.coreblock.scene.schedule.condition.wifi.WifiConditionViewState, boolean, boolean, boolean, java.lang.Float, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit f0(final WifiConditionViewState wifiConditionViewState, final ScaffoldState scaffoldState, final boolean z2, final boolean z3, final boolean z4, final Float f3, final Function1 function1, final NavHostController navHostController, NavGraphBuilder NavHost) {
        Intrinsics.checkNotNullParameter(NavHost, "$this$NavHost");
        ComposableLambda composableLambdaC = ComposableLambdaKt.c(131344425, true, new Function4() { // from class: cz.mobilesoft.coreblock.scene.schedule.condition.wifi.p
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return WifiConditionScreenKt.g0(wifiConditionViewState, scaffoldState, z2, z3, z4, f3, function1, navHostController, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        });
        NavGraphBuilderKt.b(NavHost, Reflection.b(WifiConditionScreenNavigation.WifiSelection.class), MapsKt.emptyMap(), CollectionsKt.emptyList(), null, null, null, null, null, composableLambdaC);
        ComposableLambda composableLambdaC2 = ComposableLambdaKt.c(-1581678048, true, new Function4() { // from class: cz.mobilesoft.coreblock.scene.schedule.condition.wifi.a0
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return WifiConditionScreenKt.i0(scaffoldState, wifiConditionViewState, z3, z4, f3, navHostController, function1, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        });
        NavGraphBuilderKt.b(NavHost, Reflection.b(WifiConditionScreenNavigation.TimeCondition.class), MapsKt.emptyMap(), CollectionsKt.emptyList(), null, null, null, null, null, composableLambdaC2);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h0(NavHostController navHostController) {
        NavController.O(navHostController, WifiConditionScreenNavigation.TimeCondition.INSTANCE, null, null, 6, null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i0(ScaffoldState scaffoldState, WifiConditionViewState wifiConditionViewState, boolean z2, boolean z3, Float f3, final NavHostController navHostController, Function1 function1, AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        if (ComposerKt.M()) {
            ComposerKt.U(-1581678048, i3, -1, "cz.mobilesoft.coreblock.scene.schedule.condition.wifi.RootCompose.<anonymous>.<anonymous>.<anonymous> (WifiConditionScreen.kt:366)");
        }
        boolean zI = composer.I(navHostController);
        Object objG = composer.G();
        if (zI || objG == Composer.f23746a.a()) {
            objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.schedule.condition.wifi.l0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return WifiConditionScreenKt.j0(navHostController);
                }
            };
            composer.w(objG);
        }
        l0(scaffoldState, wifiConditionViewState, false, z2, z3, f3, (Function0) objG, function1, composer, 0, 4);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j0(NavHostController navHostController) {
        NavController.O(navHostController, WifiConditionScreenNavigation.WifiSelection.INSTANCE, null, null, 6, null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k0(ScaffoldState scaffoldState, WifiConditionViewState wifiConditionViewState, boolean z2, boolean z3, boolean z4, Float f3, Function1 function1, int i3, int i4, Composer composer, int i5) {
        e0(scaffoldState, wifiConditionViewState, z2, z3, z4, f3, function1, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:127:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:132:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00f0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void l0(final androidx.compose.material.ScaffoldState r18, final cz.mobilesoft.coreblock.scene.schedule.condition.wifi.WifiConditionViewState r19, boolean r20, boolean r21, boolean r22, java.lang.Float r23, final kotlin.jvm.functions.Function0 r24, final kotlin.jvm.functions.Function1 r25, androidx.compose.runtime.Composer r26, final int r27, final int r28) {
        /*
            Method dump skipped, instruction units count: 466
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.schedule.condition.wifi.WifiConditionScreenKt.l0(androidx.compose.material.ScaffoldState, cz.mobilesoft.coreblock.scene.schedule.condition.wifi.WifiConditionViewState, boolean, boolean, boolean, java.lang.Float, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m0(Function1 function1) {
        function1.invoke(WifiConditionViewEvent.OnCloseClicked.f116041a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n0(Function1 function1) {
        function1.invoke(WifiConditionViewEvent.OnSaveClicked.f116042a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o0(WifiConditionViewState wifiConditionViewState, Function0 function0, final Function1 function1, ColumnScope BaseConditionScreen, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(BaseConditionScreen, "$this$BaseConditionScreen");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(2006891608, i3, -1, "cz.mobilesoft.coreblock.scene.schedule.condition.wifi.TimeConditionScreen.<anonymous> (WifiConditionScreen.kt:448)");
            }
            TimeConditionConfigurationViewState timeConditionConfigurationViewStateC = wifiConditionViewState.c();
            O0(wifiConditionViewState.d().m(), function0, wifiConditionViewState.d().k().size(), composer, 0, 0);
            Configuration configurationF = timeConditionConfigurationViewStateC.f();
            boolean zI = timeConditionConfigurationViewStateC.i();
            boolean zM = timeConditionConfigurationViewStateC.m();
            boolean Z = composer.Z(function1);
            Object objG = composer.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.schedule.condition.wifi.r
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return WifiConditionScreenKt.p0(function1);
                    }
                };
                composer.w(objG);
            }
            Function0 function02 = (Function0) objG;
            boolean Z2 = composer.Z(function1);
            Object objG2 = composer.G();
            if (Z2 || objG2 == Composer.f23746a.a()) {
                objG2 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.schedule.condition.wifi.s
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return WifiConditionScreenKt.q0(function1, ((Boolean) obj).booleanValue());
                    }
                };
                composer.w(objG2);
            }
            Function1 function12 = (Function1) objG2;
            boolean Z3 = composer.Z(function1);
            Object objG3 = composer.G();
            if (Z3 || objG3 == Composer.f23746a.a()) {
                objG3 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.schedule.condition.wifi.t
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return WifiConditionScreenKt.r0(function1, (IntervalDTO) obj);
                    }
                };
                composer.w(objG3);
            }
            Function1 function13 = (Function1) objG3;
            boolean Z4 = composer.Z(function1);
            Object objG4 = composer.G();
            if (Z4 || objG4 == Composer.f23746a.a()) {
                objG4 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.schedule.condition.wifi.u
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return WifiConditionScreenKt.s0(function1, (IntervalDTO) obj);
                    }
                };
                composer.w(objG4);
            }
            BaseConditionScreenKt.R0(configurationF, zI, zM, function02, function12, function13, (Function1) objG4, composer, 0, 0);
            Configuration configurationF2 = timeConditionConfigurationViewStateC.f();
            boolean zH = timeConditionConfigurationViewStateC.h();
            boolean Z5 = composer.Z(function1);
            Object objG5 = composer.G();
            if (Z5 || objG5 == Composer.f23746a.a()) {
                objG5 = new Function2() { // from class: cz.mobilesoft.coreblock.scene.schedule.condition.wifi.v
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return WifiConditionScreenKt.t0(function1, ((Boolean) obj).booleanValue(), (DayOfWeek) obj2);
                    }
                };
                composer.w(objG5);
            }
            BaseConditionScreenKt.i0(configurationF2, zH, (Function2) objG5, composer, 0, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p0(Function1 function1) {
        function1.invoke(new WifiConditionViewEvent.WifiTimeConditionViewEvent(TimeConditionViewEvent.OnAddIntervalClicked.f115749a));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit q0(Function1 function1, boolean z2) {
        function1.invoke(new WifiConditionViewEvent.WifiTimeConditionViewEvent(new TimeConditionViewEvent.OnAllDayLongCheckedChanged(z2)));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit r0(Function1 function1, IntervalDTO interval) {
        Intrinsics.checkNotNullParameter(interval, "interval");
        function1.invoke(new WifiConditionViewEvent.WifiTimeConditionViewEvent(new TimeConditionViewEvent.OnIntervalClicked(interval)));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit s0(Function1 function1, IntervalDTO interval) {
        Intrinsics.checkNotNullParameter(interval, "interval");
        function1.invoke(new WifiConditionViewEvent.WifiTimeConditionViewEvent(new TimeConditionViewEvent.OnIntervalRemoveClicked(interval)));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit t0(Function1 function1, boolean z2, DayOfWeek dayOfWeek) {
        Intrinsics.checkNotNullParameter(dayOfWeek, "dayOfWeek");
        function1.invoke(new WifiConditionViewEvent.WifiTimeConditionViewEvent(new TimeConditionViewEvent.OnDayCheckedChanged(z2, dayOfWeek)));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit u0(ScaffoldState scaffoldState, WifiConditionViewState wifiConditionViewState, boolean z2, boolean z3, boolean z4, Float f3, Function0 function0, Function1 function1, int i3, int i4, Composer composer, int i5) {
        l0(scaffoldState, wifiConditionViewState, z2, z3, z4, f3, function0, function1, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:128:0x03e6  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x03f1  */
    /* JADX WARN: Removed duplicated region for block: B:133:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x008f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final void v0(final cz.mobilesoft.coreblock.scene.schedule.condition.time.WifiConfigurationViewState r95, boolean r96, boolean r97, final kotlin.jvm.functions.Function1 r98, final kotlin.jvm.functions.Function0 r99, androidx.compose.runtime.Composer r100, final int r101, final int r102) {
        /*
            Method dump skipped, instruction units count: 1024
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.schedule.condition.wifi.WifiConditionScreenKt.v0(cz.mobilesoft.coreblock.scene.schedule.condition.time.WifiConfigurationViewState, boolean, boolean, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int):void");
    }

    private static final String w0(MutableState mutableState) {
        return (String) mutableState.getValue();
    }

    private static final void x0(MutableState mutableState, String str) {
        mutableState.setValue(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit y0(Function1 function1, MutableState mutableState, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        x0(mutableState, it);
        function1.invoke(new WifiConditionViewEvent.OnSharedWifiConditionEvent(new SharedWifiConditionEvent.OnQueryChanged(it)));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit z0(final MutableState mutableState, final Function1 function1, Composer composer, int i3) throws XmlPullParserException, IOException {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1652627212, i3, -1, "cz.mobilesoft.coreblock.scene.schedule.condition.wifi.Toolbar.<anonymous>.<anonymous> (WifiConditionScreen.kt:610)");
            }
            if (w0(mutableState).length() > 0) {
                composer.a0(207260636);
                ImageVector imageVectorB = VectorResources_androidKt.b(ImageVector.f26323k, R.drawable.C1, composer, 6);
                long jQ = ComposeColorsKt.j(composer, 0).q();
                float fG = Dp.g(16);
                boolean Z = composer.Z(mutableState) | composer.Z(function1);
                Object objG = composer.G();
                if (Z || objG == Composer.f23746a.a()) {
                    objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.schedule.condition.wifi.i0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return WifiConditionScreenKt.A0(function1, mutableState);
                        }
                    };
                    composer.w(objG);
                }
                ComposeButtonsKt.q0(null, imageVectorB, null, false, 0.0f, fG, jQ, null, (Function0) objG, composer, 196608, 157);
            } else {
                composer.a0(181532310);
            }
            composer.U();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g0(WifiConditionViewState wifiConditionViewState, ScaffoldState scaffoldState, boolean z2, boolean z3, boolean z4, Float f3, Function1 function1, final NavHostController navHostController, AnimatedContentScope animatedContentScope, NavBackStackEntry it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(animatedContentScope, YznnJpHcAmeoW.Klx);
        Intrinsics.checkNotNullParameter(it, "it");
        if (ComposerKt.M()) {
            ComposerKt.U(131344425, i3, -1, "cz.mobilesoft.coreblock.scene.schedule.condition.wifi.RootCompose.<anonymous>.<anonymous>.<anonymous> (WifiConditionScreen.kt:351)");
        }
        WifiConfigurationViewState wifiConfigurationViewStateD = wifiConditionViewState.d();
        boolean zI = composer.I(navHostController);
        Object objG = composer.G();
        if (zI || objG == Composer.f23746a.a()) {
            objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.schedule.condition.wifi.w0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return WifiConditionScreenKt.h0(navHostController);
                }
            };
            composer.w(objG);
        }
        R0(scaffoldState, wifiConfigurationViewStateD, z2, z3, z4, f3, function1, (Function0) objG, composer, 0, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }
}
