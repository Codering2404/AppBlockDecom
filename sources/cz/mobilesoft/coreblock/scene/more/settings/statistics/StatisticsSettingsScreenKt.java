package cz.mobilesoft.coreblock.scene.more.settings.statistics;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.IconKt;
import androidx.compose.material.ScaffoldKt;
import androidx.compose.material.ScaffoldState;
import androidx.compose.material.TextKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.outlined.VisibilityOffKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.res.VectorResources_androidKt;
import androidx.compose.ui.unit.Dp;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.navigation.NavBackStackEntry;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.scene.more.settings.generalSettings.GeneralSettingsViewState;
import cz.mobilesoft.coreblock.scene.more.settings.statistics.StatisticsSettingsViewEvent;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.util.compose.FlowExtKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.util.helperextension.ContextExtKt;
import cz.mobilesoft.coreblock.util.helperextension.DialogHelper;
import cz.mobilesoft.coreblock.view.compose.SectionedItemKt;
import java.io.IOException;
import java.util.List;
import kotlin.Metadata;
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
import org.koin.androidx.compose.ViewModelComposeExtKt;
import org.koin.androidx.viewmodel.GetViewModelKt;
import org.koin.androidx.viewmodel.ext.android.BundleExtKt;
import org.koin.core.context.GlobalContext;
import org.koin.core.scope.Scope;
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
public final class StatisticsSettingsScreenKt {
    private static final void m(final StatisticsSettingsViewModel statisticsSettingsViewModel, final ScaffoldState scaffoldState, final Function1 function1, Composer composer, final int i3) {
        int i4;
        Composer composerK = composer.k(1000399927);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(statisticsSettingsViewModel) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.Z(scaffoldState) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.I(function1) ? 256 : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        int i5 = i4;
        if (composerK.r((i5 & 147) != 146, i5 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1000399927, i5, -1, "cz.mobilesoft.coreblock.scene.more.settings.statistics.CommandProcessor (StatisticsSettingsScreen.kt:209)");
            }
            Context context = (Context) composerK.q(AndroidCompositionLocals_androidKt.g());
            Object objG = composerK.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG == companion.a()) {
                objG = EffectsKt.l(EmptyCoroutineContext.f139889a, composerK);
                composerK.w(objG);
            }
            CoroutineScope coroutineScope = (CoroutineScope) objG;
            boolean zI = ((i5 & 112) == 32) | composerK.I(coroutineScope) | composerK.I(context) | ((i5 & 896) == 256);
            Object objG2 = composerK.G();
            if (zI || objG2 == companion.a()) {
                StatisticsSettingsScreenKt$CommandProcessor$1$1 statisticsSettingsScreenKt$CommandProcessor$1$1 = new StatisticsSettingsScreenKt$CommandProcessor$1$1(coroutineScope, context, scaffoldState, function1, null);
                composerK.w(statisticsSettingsScreenKt$CommandProcessor$1$1);
                objG2 = statisticsSettingsScreenKt$CommandProcessor$1$1;
            }
            FlowExtKt.g(statisticsSettingsViewModel, null, (Function2) objG2, composerK, i5 & 14, 2);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.settings.statistics.f
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return StatisticsSettingsScreenKt.n(statisticsSettingsViewModel, scaffoldState, function1, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n(StatisticsSettingsViewModel statisticsSettingsViewModel, ScaffoldState scaffoldState, Function1 function1, int i3, Composer composer, int i4) {
        m(statisticsSettingsViewModel, scaffoldState, function1, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    public static final void o(Modifier modifier, Composer composer, final int i3, final int i4) {
        Modifier modifier2;
        int i5;
        Composer composer2;
        final Modifier modifier3;
        Bundle bundleB;
        Composer composerK = composer.k(-1514691937);
        int i6 = i4 & 1;
        if (i6 != 0) {
            i5 = i3 | 6;
            modifier2 = modifier;
        } else if ((i3 & 6) == 0) {
            modifier2 = modifier;
            i5 = (composerK.Z(modifier2) ? 4 : 2) | i3;
        } else {
            modifier2 = modifier;
            i5 = i3;
        }
        if (composerK.r((i5 & 3) != 2, i5 & 1)) {
            Modifier modifier4 = i6 != 0 ? Modifier.b8 : modifier2;
            if (ComposerKt.M()) {
                ComposerKt.U(-1514691937, i5, -1, "cz.mobilesoft.coreblock.scene.more.settings.statistics.StatisticsSettingsScreen (StatisticsSettingsScreen.kt:52)");
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
            KClass kClassB = Reflection.b(StatisticsSettingsViewModel.class);
            ViewModelStore viewModelStore = viewModelStoreOwnerC.getViewModelStore();
            Intrinsics.checkNotNullExpressionValue(viewModelStore, "viewModelStoreOwner.viewModelStore");
            ViewModel viewModelA = GetViewModelKt.a(kClassB, viewModelStore, null, creationExtrasA2 == null ? creationExtrasA : creationExtrasA2, null, scopeD, null);
            composerK.Y();
            composerK.Y();
            StatisticsSettingsViewModel statisticsSettingsViewModel = (StatisticsSettingsViewModel) viewModelA;
            final StatisticsSettingsViewState statisticsSettingsViewState = (StatisticsSettingsViewState) FlowExtKt.m(statisticsSettingsViewModel, composerK, 0);
            final Function1 function1N = FlowExtKt.n(statisticsSettingsViewModel, composerK, 0);
            ScaffoldState scaffoldStateG = ScaffoldKt.g(null, null, composerK, 0, 3);
            m(statisticsSettingsViewModel, scaffoldStateG, function1N, composerK, 0);
            composer2 = composerK;
            modifier3 = modifier4;
            ScaffoldKt.a(modifier3, scaffoldStateG, null, null, ComposableSingletons$StatisticsSettingsScreenKt.f110181a.b(), null, 0, false, null, false, null, 0.0f, 0L, 0L, 0L, 0L, 0L, ComposableLambdaKt.e(658330785, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.more.settings.statistics.b
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return StatisticsSettingsScreenKt.p(function1N, statisticsSettingsViewState, context, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerK, 54), composer2, (i5 & 14) | 24576, 12582912, 131052);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer2 = composerK;
            composer2.Q();
            modifier3 = modifier2;
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.settings.statistics.e
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return StatisticsSettingsScreenKt.z(modifier3, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p(final Function1 function1, final StatisticsSettingsViewState statisticsSettingsViewState, final Context context, PaddingValues padding, Composer composer, int i3) throws XmlPullParserException, IOException {
        int i4;
        Intrinsics.checkNotNullParameter(padding, "padding");
        if ((i3 & 6) == 0) {
            i4 = i3 | (composer.Z(padding) ? 4 : 2);
        } else {
            i4 = i3;
        }
        if (composer.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(658330785, i4, -1, "cz.mobilesoft.coreblock.scene.more.settings.statistics.StatisticsSettingsScreen.<anonymous> (StatisticsSettingsScreen.kt:72)");
            }
            Modifier.Companion companion = Modifier.b8;
            float f3 = 16;
            Modifier modifierI = PaddingKt.i(PaddingKt.h(ScrollKt.g(companion, ScrollKt.c(0, composer, 0, 1), false, null, false, 14, null), padding), Dp.g(f3));
            Arrangement arrangement = Arrangement.f6574a;
            Arrangement.Vertical verticalH = arrangement.h();
            Alignment.Companion companion2 = Alignment.f25072a;
            MeasurePolicy measurePolicyA = ColumnKt.a(verticalH, companion2.k(), composer, 0);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, modifierI);
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
            SpacerKt.a(SizeKt.v(companion, Dp.g(f3)), composer, 6);
            String strB = StringResources_androidKt.b(R.string.OD, composer, 0);
            ImageVector.Companion companion4 = ImageVector.f26323k;
            ImageVector imageVectorB = VectorResources_androidKt.b(companion4, R.drawable.H5, composer, 6);
            boolean Z = composer.Z(function1);
            Object objG = composer.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.settings.statistics.g
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return StatisticsSettingsScreenKt.q(function1);
                    }
                };
                composer.w(objG);
            }
            SectionedItemKt.P(null, strB, null, null, null, imageVectorB, 0L, 0L, 0L, null, null, (Function0) objG, Boolean.valueOf(statisticsSettingsViewState.e()), false, composer, 0, 0, 10205);
            SpacerKt.a(SizeKt.v(companion, Dp.g(f3)), composer, 6);
            String strB2 = StringResources_androidKt.b(R.string.mw, composer, 0);
            Boolean boolValueOf = Boolean.valueOf(statisticsSettingsViewState.c());
            ImageVector imageVectorB2 = VectorResources_androidKt.b(companion4, R.drawable.b5, composer, 6);
            boolean Z2 = composer.Z(statisticsSettingsViewState) | composer.I(context) | composer.Z(function1);
            Object objG2 = composer.G();
            if (Z2 || objG2 == Composer.f23746a.a()) {
                objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.settings.statistics.h
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return StatisticsSettingsScreenKt.r(statisticsSettingsViewState, context, function1);
                    }
                };
                composer.w(objG2);
            }
            GeneralSettingsViewState.SettingsItem settingsItem = new GeneralSettingsViewState.SettingsItem(strB2, null, null, boolValueOf, imageVectorB2, false, false, (Function0) objG2, 102, null);
            String strB3 = StringResources_androidKt.b(R.string.qw, composer, 0);
            Boolean boolValueOf2 = Boolean.valueOf(statisticsSettingsViewState.f());
            ImageVector imageVectorB3 = VectorResources_androidKt.b(companion4, R.drawable.V6, composer, 6);
            boolean Z3 = composer.Z(statisticsSettingsViewState) | composer.I(context) | composer.Z(function1);
            Object objG3 = composer.G();
            if (Z3 || objG3 == Composer.f23746a.a()) {
                objG3 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.settings.statistics.i
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return StatisticsSettingsScreenKt.s(statisticsSettingsViewState, context, function1);
                    }
                };
                composer.w(objG3);
            }
            GeneralSettingsViewState.SettingsItem settingsItem2 = new GeneralSettingsViewState.SettingsItem(strB3, null, null, boolValueOf2, imageVectorB3, false, false, (Function0) objG3, 102, null);
            String strB4 = StringResources_androidKt.b(R.string.sw, composer, 0);
            Boolean boolValueOf3 = Boolean.valueOf(statisticsSettingsViewState.d());
            ImageVector imageVectorA = VisibilityOffKt.a(Icons.Outlined.f15155a);
            boolean Z4 = composer.Z(statisticsSettingsViewState) | composer.I(context) | composer.Z(function1);
            Object objG4 = composer.G();
            if (Z4 || objG4 == Composer.f23746a.a()) {
                objG4 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.settings.statistics.j
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return StatisticsSettingsScreenKt.t(statisticsSettingsViewState, context, function1);
                    }
                };
                composer.w(objG4);
            }
            List listMutableListOf = CollectionsKt.mutableListOf(settingsItem, settingsItem2, new GeneralSettingsViewState.SettingsItem(strB4, null, null, boolValueOf3, imageVectorA, false, false, (Function0) objG4, 102, null));
            Function3 function3 = new Function3() { // from class: cz.mobilesoft.coreblock.scene.more.settings.statistics.k
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return StatisticsSettingsScreenKt.u((GeneralSettingsViewState.SettingsItem) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            };
            Function3 function32 = new Function3() { // from class: cz.mobilesoft.coreblock.scene.more.settings.statistics.l
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return StatisticsSettingsScreenKt.v((GeneralSettingsViewState.SettingsItem) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            };
            Function3 function33 = new Function3() { // from class: cz.mobilesoft.coreblock.scene.more.settings.statistics.m
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return StatisticsSettingsScreenKt.w((GeneralSettingsViewState.SettingsItem) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            };
            Function3 function34 = new Function3() { // from class: cz.mobilesoft.coreblock.scene.more.settings.statistics.c
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return StatisticsSettingsScreenKt.x((GeneralSettingsViewState.SettingsItem) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            };
            Object objG5 = composer.G();
            if (objG5 == Composer.f23746a.a()) {
                objG5 = new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.settings.statistics.d
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return StatisticsSettingsScreenKt.y((GeneralSettingsViewState.SettingsItem) obj, ((Integer) obj2).intValue());
                    }
                };
                composer.w(objG5);
            }
            SectionedItemKt.f0(listMutableListOf, function3, function32, null, function33, null, null, function34, null, null, null, null, null, false, false, true, 0L, null, null, 0L, null, null, 0L, null, null, (Function2) objG5, composer, 0, 196608, 196608, 16760756);
            SpacerKt.a(SizeKt.v(companion, Dp.g(f3)), composer, 6);
            Modifier modifierF2 = BorderKt.f(columnScopeInstance.c(SizeKt.h(companion, 0.0f, 1, null), companion2.g()), Dp.g(1), ComposeColorsKt.j(composer, 0).M(), RoundedCornerShapeKt.d(Dp.g(f3)));
            MeasurePolicy measurePolicyB = RowKt.b(arrangement.g(), companion2.i(), composer, 48);
            int iA2 = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU2 = composer.u();
            Modifier modifierF3 = ComposedModifierKt.f(composer, modifierF2);
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
            Updater.e(composerA2, modifierF3, companion3.f());
            RowScopeInstance rowScopeInstance = RowScopeInstance.f7101a;
            IconKt.a(PainterResources_androidKt.c(R.drawable.N2, composer, 0), null, PaddingKt.m(PaddingKt.k(companion, 0.0f, Dp.g(f3), 1, null), Dp.g(f3), 0.0f, 0.0f, 0.0f, 14, null), ComposeColorsKt.j(composer, 0).b(), composer, 432, 0);
            TextKt.c(StringResources_androidKt.b(R.string.lA, composer, 0), PaddingKt.i(companion, Dp.g(f3)), ComposeColorsKt.j(composer, 0).M(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).d(), composer, 48, 0, 65528);
            composer.y();
            SpacerKt.a(SizeKt.v(companion, Dp.g(f3)), composer, 6);
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
    public static final Unit q(Function1 function1) {
        function1.invoke(StatisticsSettingsViewEvent.OnStatisticsEnabledClick.f110202a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit r(StatisticsSettingsViewState statisticsSettingsViewState, Context context, final Function1 function1) {
        if (statisticsSettingsViewState.e()) {
            if (statisticsSettingsViewState.c()) {
                Activity activityB = ContextExtKt.b(context);
                if (activityB != null) {
                    DialogHelper.k(activityB, activityB.getString(R.string.gA), new DialogHelper.OnDialogClosedListener() { // from class: cz.mobilesoft.coreblock.scene.more.settings.statistics.StatisticsSettingsScreenKt$StatisticsSettingsScreen$1$1$generalSettings$1$1$1$1
                        @Override // cz.mobilesoft.coreblock.util.helperextension.DialogHelper.OnDialogClosedListener
                        public void a() {
                            function1.invoke(new StatisticsSettingsViewEvent.OnAppStatisticsClick(false));
                        }

                        @Override // cz.mobilesoft.coreblock.util.helperextension.DialogHelper.OnDialogClosedListener
                        public void b() {
                        }
                    });
                }
            } else {
                function1.invoke(new StatisticsSettingsViewEvent.OnAppStatisticsClick(true));
            }
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit s(StatisticsSettingsViewState statisticsSettingsViewState, Context context, final Function1 function1) {
        if (statisticsSettingsViewState.e()) {
            if (statisticsSettingsViewState.f()) {
                Activity activityB = ContextExtKt.b(context);
                if (activityB != null) {
                    DialogHelper.k(activityB, activityB.getString(R.string.iA), new DialogHelper.OnDialogClosedListener() { // from class: cz.mobilesoft.coreblock.scene.more.settings.statistics.StatisticsSettingsScreenKt$StatisticsSettingsScreen$1$1$generalSettings$2$1$1$1
                        @Override // cz.mobilesoft.coreblock.util.helperextension.DialogHelper.OnDialogClosedListener
                        public void a() {
                            function1.invoke(new StatisticsSettingsViewEvent.OnWebStatisticsClick(false));
                        }

                        @Override // cz.mobilesoft.coreblock.util.helperextension.DialogHelper.OnDialogClosedListener
                        public void b() {
                        }
                    });
                }
            } else {
                function1.invoke(new StatisticsSettingsViewEvent.OnWebStatisticsClick(true));
            }
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit t(StatisticsSettingsViewState statisticsSettingsViewState, Context context, final Function1 function1) {
        if (statisticsSettingsViewState.e()) {
            if (statisticsSettingsViewState.d()) {
                Activity activityB = ContextExtKt.b(context);
                if (activityB != null) {
                    DialogHelper.k(activityB, activityB.getString(R.string.iA), new DialogHelper.OnDialogClosedListener() { // from class: cz.mobilesoft.coreblock.scene.more.settings.statistics.StatisticsSettingsScreenKt$StatisticsSettingsScreen$1$1$generalSettings$3$1$1$1
                        @Override // cz.mobilesoft.coreblock.util.helperextension.DialogHelper.OnDialogClosedListener
                        public void a() {
                            function1.invoke(new StatisticsSettingsViewEvent.OnIncognitoStatisticsClick(false));
                        }

                        @Override // cz.mobilesoft.coreblock.util.helperextension.DialogHelper.OnDialogClosedListener
                        public void b() {
                        }
                    });
                }
            } else {
                function1.invoke(new StatisticsSettingsViewEvent.OnIncognitoStatisticsClick(true));
            }
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String u(GeneralSettingsViewState.SettingsItem it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(it, "it");
        composer.a0(-275823088);
        if (ComposerKt.M()) {
            ComposerKt.U(-275823088, i3, -1, "cz.mobilesoft.coreblock.scene.more.settings.statistics.StatisticsSettingsScreen.<anonymous>.<anonymous>.<anonymous> (StatisticsSettingsScreen.kt:167)");
        }
        String strE = it.e();
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        return strE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String v(GeneralSettingsViewState.SettingsItem it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(it, "it");
        composer.a0(2062997295);
        if (ComposerKt.M()) {
            ComposerKt.U(2062997295, i3, -1, "cz.mobilesoft.coreblock.scene.more.settings.statistics.StatisticsSettingsScreen.<anonymous>.<anonymous>.<anonymous> (StatisticsSettingsScreen.kt:168)");
        }
        String strD = it.d();
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        return strD;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ImageVector w(GeneralSettingsViewState.SettingsItem it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(it, "it");
        composer.a0(-1630296304);
        if (ComposerKt.M()) {
            ComposerKt.U(-1630296304, i3, -1, "cz.mobilesoft.coreblock.scene.more.settings.statistics.StatisticsSettingsScreen.<anonymous>.<anonymous>.<anonymous> (StatisticsSettingsScreen.kt:171)");
        }
        ImageVector imageVectorB = it.b();
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        return imageVectorB;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Boolean x(GeneralSettingsViewState.SettingsItem it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(it, "it");
        composer.a0(650352515);
        if (ComposerKt.M()) {
            ComposerKt.U(650352515, i3, -1, "cz.mobilesoft.coreblock.scene.more.settings.statistics.StatisticsSettingsScreen.<anonymous>.<anonymous>.<anonymous> (StatisticsSettingsScreen.kt:170)");
        }
        Boolean boolG = it.g();
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        return boolG;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit y(GeneralSettingsViewState.SettingsItem item, int i3) {
        Intrinsics.checkNotNullParameter(item, "item");
        item.c().invoke();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit z(Modifier modifier, int i3, int i4, Composer composer, int i5) {
        o(modifier, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }
}
