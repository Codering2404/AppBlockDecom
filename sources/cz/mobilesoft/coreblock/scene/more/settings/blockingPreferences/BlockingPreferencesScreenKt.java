package cz.mobilesoft.coreblock.scene.more.settings.blockingPreferences;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.activity.compose.ActivityResultRegistryKt;
import androidx.activity.compose.ManagedActivityResultLauncher;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
import androidx.compose.material.ScaffoldKt;
import androidx.compose.material.ScaffoldState;
import androidx.compose.material.TextKt;
import androidx.compose.material3.SheetState;
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
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.PrimitiveResources_androidKt;
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
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.enums.StrictModeDeactivationTime;
import cz.mobilesoft.coreblock.scene.lockscreen.ossettings.SystemSettingsType;
import cz.mobilesoft.coreblock.scene.more.settings.blockingPreferences.BlockingPreferencesViewEvent;
import cz.mobilesoft.coreblock.scene.more.settings.excludedBrowsers.ExcludedUnsupportedBrowsersActivity;
import cz.mobilesoft.coreblock.scene.more.settings.generalSettings.GeneralSettingsViewState;
import cz.mobilesoft.coreblock.util.analytics.AnswersHelper;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.util.compose.FlowExtKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.util.runnability.DeviceAdminHelper;
import cz.mobilesoft.coreblock.view.compose.ButtonColor;
import cz.mobilesoft.coreblock.view.compose.ButtonType;
import cz.mobilesoft.coreblock.view.compose.ComposeBottomSheetsKt;
import cz.mobilesoft.coreblock.view.compose.ComposeButtonsKt;
import cz.mobilesoft.coreblock.view.compose.material3.FlatButtonsKt;
import cz.mobilesoft.coreblock.view.timepicker.StatelessTimePickerKt;
import cz.mobilesoft.coreblock.view.timepicker.TimePickerConfig;
import cz.mobilesoft.coreblock.view.timepicker.TimePickerState;
import cz.mobilesoft.coreblock.view.timepicker.config.TimePickerConfiguration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.enums.EnumEntries;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.coroutines.CoroutineScope;
import org.koin.androidx.compose.ViewModelComposeExtKt;
import org.koin.androidx.viewmodel.GetViewModelKt;
import org.koin.androidx.viewmodel.ext.android.BundleExtKt;
import org.koin.core.context.GlobalContext;
import org.koin.core.scope.Scope;

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
public final class BlockingPreferencesScreenKt {
    public static final void F(Composer composer, final int i3) {
        int i4;
        int i5;
        Bundle bundleB;
        Composer composerK = composer.k(-347717180);
        if (composerK.r(i3 != 0, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-347717180, i3, -1, "cz.mobilesoft.coreblock.scene.more.settings.blockingPreferences.BlockingPreferencesScreen (BlockingPreferencesScreen.kt:75)");
            }
            final Context context = (Context) composerK.q(AndroidCompositionLocals_androidKt.g());
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
            KClass kClassB = Reflection.b(BlockingPreferencesViewModel.class);
            ViewModelStore viewModelStore = viewModelStoreOwnerC.getViewModelStore();
            Intrinsics.checkNotNullExpressionValue(viewModelStore, "viewModelStoreOwner.viewModelStore");
            ViewModel viewModelA = GetViewModelKt.a(kClassB, viewModelStore, null, creationExtrasA2 == null ? creationExtrasA : creationExtrasA2, null, scopeD, null);
            composerK.Y();
            composerK.Y();
            BlockingPreferencesViewModel blockingPreferencesViewModel = (BlockingPreferencesViewModel) viewModelA;
            final BlockingPreferencesViewState blockingPreferencesViewState = (BlockingPreferencesViewState) FlowExtKt.m(blockingPreferencesViewModel, composerK, 0);
            final Function1 function1N = FlowExtKt.n(blockingPreferencesViewModel, composerK, 0);
            ScaffoldState scaffoldStateG = ScaffoldKt.g(null, null, composerK, 0, 3);
            Object objG = composerK.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG == companion.a()) {
                objG = SnapshotStateKt__SnapshotStateKt.e("", null, 2, null);
                composerK.w(objG);
            }
            final MutableState mutableState = (MutableState) objG;
            Object objG2 = composerK.G();
            if (objG2 == companion.a()) {
                objG2 = SnapshotStateKt__SnapshotStateKt.e(Boolean.FALSE, null, 2, null);
                composerK.w(objG2);
            }
            final MutableState mutableState2 = (MutableState) objG2;
            k0(blockingPreferencesViewModel, scaffoldStateG, mutableState, function1N, composerK, 384);
            if (((CharSequence) mutableState.getValue()).length() > 0) {
                composerK.a0(619406111);
                ComposableLambda composableLambdaE = ComposableLambdaKt.e(1996652736, true, new Function4() { // from class: cz.mobilesoft.coreblock.scene.more.settings.blockingPreferences.a
                    @Override // kotlin.jvm.functions.Function4
                    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                        return BlockingPreferencesScreenKt.G(function1N, mutableState, (ColumnScope) obj, (SheetState) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                    }
                }, composerK, 54);
                Object objG3 = composerK.G();
                if (objG3 == companion.a()) {
                    objG3 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.settings.blockingPreferences.l
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return BlockingPreferencesScreenKt.J(mutableState);
                        }
                    };
                    composerK.w(objG3);
                }
                i4 = 614635614;
                ComposeBottomSheetsKt.f(null, null, true, composableLambdaE, null, (Function0) objG3, composerK, 200064, 19);
            } else {
                i4 = 614635614;
                composerK.a0(614635614);
            }
            composerK.U();
            if (((Boolean) mutableState2.getValue()).booleanValue()) {
                composerK.a0(621978212);
                ComposableLambda composableLambdaE2 = ComposableLambdaKt.e(485513335, true, new Function4() { // from class: cz.mobilesoft.coreblock.scene.more.settings.blockingPreferences.w
                    @Override // kotlin.jvm.functions.Function4
                    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                        return BlockingPreferencesScreenKt.K(blockingPreferencesViewState, function1N, mutableState2, (ColumnScope) obj, (SheetState) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                    }
                }, composerK, 54);
                Object objG4 = composerK.G();
                if (objG4 == companion.a()) {
                    objG4 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.settings.blockingPreferences.y
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return BlockingPreferencesScreenKt.Q(mutableState2);
                        }
                    };
                    composerK.w(objG4);
                }
                ComposeBottomSheetsKt.f(null, null, true, composableLambdaE2, null, (Function0) objG4, composerK, 200064, 19);
                composerK.U();
                i5 = 54;
            } else {
                i5 = 54;
                composerK.a0(i4);
                composerK.U();
            }
            ScaffoldKt.a(null, scaffoldStateG, null, null, ComposableSingletons$BlockingPreferencesScreenKt.f108195a.b(), null, 0, false, null, false, null, 0.0f, 0L, 0L, 0L, 0L, 0L, ComposableLambdaKt.e(-1869858686, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.more.settings.blockingPreferences.z
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return BlockingPreferencesScreenKt.R(blockingPreferencesViewState, function1N, context, mutableState2, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerK, i5), composerK, 24576, 12582912, 131053);
            composerK = composerK;
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.settings.blockingPreferences.a0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BlockingPreferencesScreenKt.j0(i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit G(final Function1 function1, MutableState mutableState, ColumnScope AppBottomSheet, SheetState it, Composer composer, int i3) {
        final MutableState mutableState2;
        Intrinsics.checkNotNullParameter(AppBottomSheet, "$this$AppBottomSheet");
        Intrinsics.checkNotNullParameter(it, "it");
        if (composer.r((i3 & 129) != 128, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1996652736, i3, -1, "cz.mobilesoft.coreblock.scene.more.settings.blockingPreferences.BlockingPreferencesScreen.<anonymous> (BlockingPreferencesScreen.kt:96)");
            }
            Modifier.Companion companion = Modifier.b8;
            float f3 = 24;
            float f4 = 16;
            Modifier modifierD = WindowInsetsPaddingKt.d(PaddingKt.k(PaddingKt.m(companion, 0.0f, Dp.g(f3), 0.0f, Dp.g(f3), 5, null), Dp.g(f4), 0.0f, 2, null), WindowInsets_androidKt.b(WindowInsets.f7172a, composer, 6));
            MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.h(), Alignment.f25072a.k(), composer, 0);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, modifierD);
            ComposeUiNode.Companion companion2 = ComposeUiNode.f8;
            Function0 function0A = companion2.a();
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
            Updater.e(composerA, measurePolicyA, companion2.e());
            Updater.e(composerA, compositionLocalMapU, companion2.g());
            Function2 function2B = companion2.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion2.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            String strB = StringResources_androidKt.b(R.string.Rx, composer, 0);
            TextStyle textStyleF = ComposeTypographyKt.g(composer, 0).f();
            long jL = ComposeColorsKt.j(composer, 0).L();
            TextAlign.Companion companion3 = TextAlign.f29616b;
            TextKt.c(strB, SizeKt.h(companion, 0.0f, 1, null), jL, 0L, null, null, null, 0L, null, TextAlign.h(companion3.a()), 0L, 0, false, 0, 0, null, textStyleF, composer, 48, 0, 65016);
            SpacerKt.a(SizeKt.i(companion, Dp.g(f4)), composer, 6);
            TextKt.c(StringResources_androidKt.b(R.string.Qx, composer, 0), SizeKt.h(companion, 0.0f, 1, null), ComposeColorsKt.j(composer, 0).O(), 0L, null, null, null, 0L, null, TextAlign.h(companion3.a()), 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).b(), composer, 48, 0, 65016);
            SpacerKt.a(SizeKt.i(companion, Dp.g(f3)), composer, 6);
            ButtonType.Big big = new ButtonType.Big(null, null, StringResources_androidKt.b(R.string.qs, composer, 0), 0.0f, 11, null);
            ButtonColor.Accent accent = new ButtonColor.Accent(false, null, false, null, 15, null);
            boolean Z = composer.Z(function1);
            Object objG = composer.G();
            if (Z || objG == Composer.f23746a.a()) {
                mutableState2 = mutableState;
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.settings.blockingPreferences.e0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return BlockingPreferencesScreenKt.H(function1, mutableState2);
                    }
                };
                composer.w(objG);
            } else {
                mutableState2 = mutableState;
            }
            ComposeButtonsKt.i0(null, big, accent, (Function0) objG, composer, 0, 1);
            SpacerKt.a(SizeKt.i(companion, Dp.g(f4)), composer, 6);
            ButtonType.Big big2 = new ButtonType.Big(null, null, StringResources_androidKt.b(R.string.O4, composer, 0), 0.0f, 11, null);
            ButtonColor.Light light = new ButtonColor.Light(false, null, false, null, Color.n(ComposeColorsKt.j(composer, 0).L()), 15, null);
            Object objG2 = composer.G();
            if (objG2 == Composer.f23746a.a()) {
                objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.settings.blockingPreferences.b
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return BlockingPreferencesScreenKt.I(mutableState2);
                    }
                };
                composer.w(objG2);
            }
            ComposeButtonsKt.i0(null, big2, light, (Function0) objG2, composer, 3072, 1);
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
    public static final Unit H(Function1 function1, MutableState mutableState) {
        function1.invoke(new BlockingPreferencesViewEvent.OnAvailableSettingsItemClicked((String) mutableState.getValue(), true));
        mutableState.setValue("");
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit I(MutableState mutableState) {
        mutableState.setValue("");
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit J(MutableState mutableState) {
        mutableState.setValue("");
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit K(BlockingPreferencesViewState blockingPreferencesViewState, final Function1 function1, final MutableState mutableState, ColumnScope AppBottomSheet, SheetState it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(AppBottomSheet, "$this$AppBottomSheet");
        Intrinsics.checkNotNullParameter(it, "it");
        if (composer.r((i3 & 129) != 128, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(485513335, i3, -1, "cz.mobilesoft.coreblock.scene.more.settings.blockingPreferences.BlockingPreferencesScreen.<anonymous> (BlockingPreferencesScreen.kt:149)");
            }
            EnumEntries<StrictModeDeactivationTime> entries = StrictModeDeactivationTime.getEntries();
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(entries, 10));
            Iterator<StrictModeDeactivationTime> it2 = entries.iterator();
            while (it2.hasNext()) {
                arrayList.add(Long.valueOf(it2.next().getTimeInMinutes()));
            }
            TimePickerState timePickerStateZ = StatelessTimePickerKt.Z(new TimePickerConfig(new TimePickerConfig.TimePickerType.Minutes(arrayList), null, null, false, null, false, 62, null), TimeUnit.MINUTES.toMillis(blockingPreferencesViewState.m().getTimeInMinutes()), composer, 0, 0);
            boolean zE = composer.e(blockingPreferencesViewState.m().ordinal());
            Object objG = composer.G();
            if (zE || objG == Composer.f23746a.a()) {
                objG = SnapshotStateKt__SnapshotStateKt.e(timePickerStateZ, null, 2, null);
                composer.w(objG);
            }
            final MutableState mutableState2 = (MutableState) objG;
            TimePickerConfiguration timePickerConfigurationB = TimePickerConfiguration.b(TimePickerConfiguration.f133137r.a(composer, 6), 0, ComposeColorsKt.j(composer, 0).l0(), null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, 0L, 0L, 0.0f, null, null, null, null, 131069, null);
            TimePickerState timePickerStateL = L(mutableState2);
            boolean Z = composer.Z(mutableState2);
            Object objG2 = composer.G();
            if (Z || objG2 == Composer.f23746a.a()) {
                objG2 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.blockingPreferences.b0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return BlockingPreferencesScreenKt.N(mutableState2, (TimePickerState) obj);
                    }
                };
                composer.w(objG2);
            }
            Function1 function12 = (Function1) objG2;
            Object objG3 = composer.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG3 == companion.a()) {
                objG3 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.blockingPreferences.c0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return BlockingPreferencesScreenKt.O(((Boolean) obj).booleanValue());
                    }
                };
                composer.w(objG3);
            }
            StatelessTimePickerKt.N(null, timePickerStateL, timePickerConfigurationB, function12, (Function1) objG3, composer, 24576, 1);
            Modifier modifierK = PaddingKt.k(Modifier.b8, PrimitiveResources_androidKt.a(R.dimen.f95467a, composer, 0), 0.0f, 2, null);
            String strB = StringResources_androidKt.b(R.string.d8, composer, 0);
            boolean Z2 = composer.Z(function1) | composer.Z(mutableState2);
            Object objG4 = composer.G();
            if (Z2 || objG4 == companion.a()) {
                objG4 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.settings.blockingPreferences.d0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return BlockingPreferencesScreenKt.P(function1, mutableState, mutableState2);
                    }
                };
                composer.w(objG4);
            }
            FlatButtonsKt.u(modifierK, 0.0f, 0.0f, null, null, null, strB, null, 0L, null, null, false, false, (Function0) objG4, composer, 0, 0, 8126);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    private static final TimePickerState L(MutableState mutableState) {
        return (TimePickerState) mutableState.getValue();
    }

    private static final void M(MutableState mutableState, TimePickerState timePickerState) {
        mutableState.setValue(timePickerState);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit N(MutableState mutableState, TimePickerState newState) {
        Intrinsics.checkNotNullParameter(newState, "newState");
        M(mutableState, newState);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit O(boolean z2) {
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit P(Function1 function1, MutableState mutableState, MutableState mutableState2) {
        function1.invoke(new BlockingPreferencesViewEvent.OnStrictDeactivationTimeConfirm(L(mutableState2).s()));
        mutableState.setValue(Boolean.FALSE);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Q(MutableState mutableState) {
        mutableState.setValue(Boolean.FALSE);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:106:0x050e  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x053f  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x04f3 A[EDGE_INSN: B:119:0x04f3->B:102:0x04f3 BREAK  A[LOOP:2: B:98:0x04df->B:121:?], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x04e1  */
    /* JADX WARN: Type inference failed for: r13v14, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v20, types: [java.util.ArrayList, java.util.Collection] */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v27, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r45v0, types: [androidx.compose.runtime.Composer] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final kotlin.Unit R(cz.mobilesoft.coreblock.scene.more.settings.blockingPreferences.BlockingPreferencesViewState r40, final kotlin.jvm.functions.Function1 r41, final android.content.Context r42, final androidx.compose.runtime.MutableState r43, androidx.compose.foundation.layout.PaddingValues r44, androidx.compose.runtime.Composer r45, int r46) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            Method dump skipped, instruction units count: 1353
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.more.settings.blockingPreferences.BlockingPreferencesScreenKt.R(cz.mobilesoft.coreblock.scene.more.settings.blockingPreferences.BlockingPreferencesViewState, kotlin.jvm.functions.Function1, android.content.Context, androidx.compose.runtime.MutableState, androidx.compose.foundation.layout.PaddingValues, androidx.compose.runtime.Composer, int):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit S(Function1 function1) {
        function1.invoke(BlockingPreferencesViewEvent.OnSchedulePauseClicked.f108079a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit T(Function1 function1) {
        function1.invoke(BlockingPreferencesViewEvent.OnLocationSwitchClicked.f108076a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit U(Function1 function1) {
        function1.invoke(BlockingPreferencesViewEvent.OnBlockPopupsClicked.f108075a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit V(Function1 function1) {
        function1.invoke(BlockingPreferencesViewEvent.OnBlockAppUninstallClicked.f108073a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit W(Context context) {
        context.startActivity(new Intent(context, (Class<?>) ExcludedUnsupportedBrowsersActivity.class));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit X(Function1 function1) {
        function1.invoke(BlockingPreferencesViewEvent.OnMindfulEditClicked.f108077a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Y(Function1 function1) {
        function1.invoke(BlockingPreferencesViewEvent.OnBlockPhoneStartupClicked.f108074a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Z(MutableState mutableState) {
        mutableState.setValue(Boolean.TRUE);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String a0(GeneralSettingsViewState.SettingsItem it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(it, "it");
        composer.a0(140188851);
        if (ComposerKt.M()) {
            ComposerKt.U(140188851, i3, -1, "cz.mobilesoft.coreblock.scene.more.settings.blockingPreferences.BlockingPreferencesScreen.<anonymous>.<anonymous>.<anonymous> (BlockingPreferencesScreen.kt:284)");
        }
        String strE = it.e();
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        return strE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit b0(Function1 function1) {
        function1.invoke(BlockingPreferencesViewEvent.OnAvailableSettingsClicked.f108070a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String c0(GeneralSettingsViewState.SettingsItem it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(it, "it");
        composer.a0(-1316224204);
        if (ComposerKt.M()) {
            ComposerKt.U(-1316224204, i3, -1, "cz.mobilesoft.coreblock.scene.more.settings.blockingPreferences.BlockingPreferencesScreen.<anonymous>.<anonymous>.<anonymous> (BlockingPreferencesScreen.kt:285)");
        }
        String strD = it.d();
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        return strD;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String d0(GeneralSettingsViewState.SettingsItem it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(it, "it");
        composer.a0(1522330037);
        if (ComposerKt.M()) {
            ComposerKt.U(1522330037, i3, -1, "cz.mobilesoft.coreblock.scene.more.settings.blockingPreferences.BlockingPreferencesScreen.<anonymous>.<anonymous>.<anonymous> (BlockingPreferencesScreen.kt:286)");
        }
        String strA = it.a();
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        return strA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ImageVector e0(GeneralSettingsViewState.SettingsItem it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(it, "it");
        composer.a0(246356915);
        if (ComposerKt.M()) {
            ComposerKt.U(246356915, i3, -1, "cz.mobilesoft.coreblock.scene.more.settings.blockingPreferences.BlockingPreferencesScreen.<anonymous>.<anonymous>.<anonymous> (BlockingPreferencesScreen.kt:289)");
        }
        ImageVector imageVectorB = it.b();
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        return imageVectorB;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Boolean f0(GeneralSettingsViewState.SettingsItem it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(it, "it");
        composer.a0(967668320);
        if (ComposerKt.M()) {
            ComposerKt.U(967668320, i3, -1, "cz.mobilesoft.coreblock.scene.more.settings.blockingPreferences.BlockingPreferencesScreen.<anonymous>.<anonymous>.<anonymous> (BlockingPreferencesScreen.kt:288)");
        }
        Boolean boolG = it.g();
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        return boolG;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean g0(GeneralSettingsViewState.SettingsItem it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(it, "it");
        composer.a0(1475953013);
        if (ComposerKt.M()) {
            ComposerKt.U(1475953013, i3, -1, "cz.mobilesoft.coreblock.scene.more.settings.blockingPreferences.BlockingPreferencesScreen.<anonymous>.<anonymous>.<anonymous> (BlockingPreferencesScreen.kt:290)");
        }
        boolean zF = it.f();
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        return zF;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h0(GeneralSettingsViewState.SettingsItem item, int i3) {
        Intrinsics.checkNotNullParameter(item, "item");
        item.c().invoke();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i0(Function1 function1, Pair pair) {
        function1.invoke(new BlockingPreferencesViewEvent.OnAvailableSettingsItemClicked(((SystemSettingsType) pair.e()).name(), false, 2, null));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j0(int i3, Composer composer, int i4) {
        F(composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    private static final void k0(final BlockingPreferencesViewModel blockingPreferencesViewModel, final ScaffoldState scaffoldState, final MutableState mutableState, final Function1 function1, Composer composer, final int i3) {
        BlockingPreferencesViewModel blockingPreferencesViewModel2;
        int i4;
        Composer composerK = composer.k(-2003603190);
        if ((i3 & 6) == 0) {
            blockingPreferencesViewModel2 = blockingPreferencesViewModel;
            i4 = (composerK.I(blockingPreferencesViewModel2) ? 4 : 2) | i3;
        } else {
            blockingPreferencesViewModel2 = blockingPreferencesViewModel;
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.Z(scaffoldState) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.Z(mutableState) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            i4 |= composerK.I(function1) ? 2048 : 1024;
        }
        if (composerK.r((i4 & 1171) != 1170, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-2003603190, i4, -1, "cz.mobilesoft.coreblock.scene.more.settings.blockingPreferences.CommandProcessor (BlockingPreferencesScreen.kt:328)");
            }
            Object objG = composerK.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG == companion.a()) {
                objG = EffectsKt.l(EmptyCoroutineContext.f139889a, composerK);
                composerK.w(objG);
            }
            CoroutineScope coroutineScope = (CoroutineScope) objG;
            Context context = (Context) composerK.q(AndroidCompositionLocals_androidKt.g());
            ActivityResultContracts.StartActivityForResult startActivityForResult = new ActivityResultContracts.StartActivityForResult();
            Object objG2 = composerK.G();
            if (objG2 == companion.a()) {
                objG2 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.blockingPreferences.c
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return BlockingPreferencesScreenKt.l0((ActivityResult) obj);
                    }
                };
                composerK.w(objG2);
            }
            ManagedActivityResultLauncher managedActivityResultLauncherA = ActivityResultRegistryKt.a(startActivityForResult, (Function1) objG2, composerK, 48);
            ActivityResultContracts.StartActivityForResult startActivityForResult2 = new ActivityResultContracts.StartActivityForResult();
            boolean z2 = (i4 & 7168) == 2048;
            Object objG3 = composerK.G();
            if (z2 || objG3 == companion.a()) {
                objG3 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.blockingPreferences.d
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return BlockingPreferencesScreenKt.m0(function1, (ActivityResult) obj);
                    }
                };
                composerK.w(objG3);
            }
            ManagedActivityResultLauncher managedActivityResultLauncherA2 = ActivityResultRegistryKt.a(startActivityForResult2, (Function1) objG3, composerK, 0);
            boolean zI = ((i4 & 112) == 32) | composerK.I(coroutineScope) | composerK.I(context) | composerK.I(managedActivityResultLauncherA) | composerK.I(managedActivityResultLauncherA2) | ((i4 & 896) == 256);
            Object objG4 = composerK.G();
            if (zI || objG4 == companion.a()) {
                BlockingPreferencesScreenKt$CommandProcessor$1$1 blockingPreferencesScreenKt$CommandProcessor$1$1 = new BlockingPreferencesScreenKt$CommandProcessor$1$1(coroutineScope, context, managedActivityResultLauncherA2, mutableState, scaffoldState, managedActivityResultLauncherA, null);
                composerK.w(blockingPreferencesScreenKt$CommandProcessor$1$1);
                objG4 = blockingPreferencesScreenKt$CommandProcessor$1$1;
            }
            FlowExtKt.g(blockingPreferencesViewModel2, null, (Function2) objG4, composerK, i4 & 14, 2);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.settings.blockingPreferences.e
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BlockingPreferencesScreenKt.n0(blockingPreferencesViewModel, scaffoldState, mutableState, function1, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l0(ActivityResult result) {
        Intrinsics.checkNotNullParameter(result, "result");
        if (result.d() == -1) {
            AnswersHelper.f128199a.J5();
            DeviceAdminHelper.f129458a.j(Boolean.TRUE);
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m0(Function1 function1, ActivityResult result) {
        Intrinsics.checkNotNullParameter(result, "result");
        if (result.d() == -1) {
            function1.invoke(BlockingPreferencesViewEvent.OnPopupBlockingPermissionGiven.f108078a);
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n0(BlockingPreferencesViewModel blockingPreferencesViewModel, ScaffoldState scaffoldState, MutableState mutableState, Function1 function1, int i3, Composer composer, int i4) {
        k0(blockingPreferencesViewModel, scaffoldState, mutableState, function1, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }
}
