package cz.mobilesoft.coreblock.scene.insights.settings;

import android.os.Bundle;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.compose.animation.AnimatedContentScope;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.ScaffoldKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.unit.Dp;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavController;
import androidx.navigation.NavGraphBuilder;
import androidx.navigation.NavHostController;
import androidx.navigation.Navigator;
import androidx.navigation.compose.NavGraphBuilderKt;
import androidx.navigation.compose.NavHostControllerKt;
import androidx.navigation.compose.NavHostKt;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.base.activity.BaseComposeActivity;
import cz.mobilesoft.coreblock.scene.app_feel.AppFeelActivity;
import cz.mobilesoft.coreblock.scene.insights.settings.InsightsSettingsActivity;
import cz.mobilesoft.coreblock.util.compose.FlowExtKt;
import cz.mobilesoft.coreblock.view.compose.NavigationKt$animatedComposable$1;
import cz.mobilesoft.coreblock.view.compose.NavigationKt$animatedComposable$2;
import cz.mobilesoft.coreblock.view.compose.NavigationKt$animatedComposable$3;
import cz.mobilesoft.coreblock.view.compose.NavigationKt$animatedComposable$4;
import cz.mobilesoft.coreblock.view.compose.SectionedItemKt;
import cz.mobilesoft.coreblock.view.compose.ToolbarKt;
import java.lang.annotation.Annotation;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
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
import kotlin.reflect.KClass;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.internal.ObjectSerializer;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class InsightsSettingsActivity extends BaseComposeActivity {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final ActivityResultLauncher f103469f = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: cz.mobilesoft.coreblock.scene.insights.settings.b0
        @Override // androidx.activity.result.ActivityResultCallback
        public final void onActivityResult(Object obj) {
            InsightsSettingsActivity.U0(this.f103478a, (ActivityResult) obj);
        }
    });

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static abstract class Navigation {

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @Serializable
        public static final class NavIgnoreList {
            public static final NavIgnoreList INSTANCE = new NavIgnoreList();

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private static final /* synthetic */ Lazy f103470a = LazyKt.a(LazyThreadSafetyMode.f139762b, new Function0() { // from class: cz.mobilesoft.coreblock.scene.insights.settings.s0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return InsightsSettingsActivity.Navigation.NavIgnoreList.b();
                }
            });

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final int f103471b = 8;

            private NavIgnoreList() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final /* synthetic */ KSerializer b() {
                return new ObjectSerializer("cz.mobilesoft.coreblock.scene.insights.settings.InsightsSettingsActivity.Navigation.NavIgnoreList", INSTANCE, new Annotation[0]);
            }

            private final /* synthetic */ KSerializer c() {
                return (KSerializer) f103470a.getValue();
            }

            public boolean equals(Object obj) {
                return this == obj || (obj instanceof NavIgnoreList);
            }

            public int hashCode() {
                return -1185856715;
            }

            public final KSerializer<NavIgnoreList> serializer() {
                return c();
            }

            public String toString() {
                return "NavIgnoreList";
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @Serializable
        public static final class NavInsightsSettings {
            public static final NavInsightsSettings INSTANCE = new NavInsightsSettings();

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private static final /* synthetic */ Lazy f103472a = LazyKt.a(LazyThreadSafetyMode.f139762b, new Function0() { // from class: cz.mobilesoft.coreblock.scene.insights.settings.t0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return InsightsSettingsActivity.Navigation.NavInsightsSettings.b();
                }
            });

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final int f103473b = 8;

            private NavInsightsSettings() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final /* synthetic */ KSerializer b() {
                return new ObjectSerializer("cz.mobilesoft.coreblock.scene.insights.settings.InsightsSettingsActivity.Navigation.NavInsightsSettings", INSTANCE, new Annotation[0]);
            }

            private final /* synthetic */ KSerializer c() {
                return (KSerializer) f103472a.getValue();
            }

            public boolean equals(Object obj) {
                return this == obj || (obj instanceof NavInsightsSettings);
            }

            public int hashCode() {
                return 1276450563;
            }

            public final KSerializer<NavInsightsSettings> serializer() {
                return c();
            }

            public String toString() {
                return "NavInsightsSettings";
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @Serializable
        public static final class NavStatisticsSettings {
            public static final NavStatisticsSettings INSTANCE = new NavStatisticsSettings();

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private static final /* synthetic */ Lazy f103474a = LazyKt.a(LazyThreadSafetyMode.f139762b, new Function0() { // from class: cz.mobilesoft.coreblock.scene.insights.settings.u0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return InsightsSettingsActivity.Navigation.NavStatisticsSettings.b();
                }
            });

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final int f103475b = 8;

            private NavStatisticsSettings() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final /* synthetic */ KSerializer b() {
                return new ObjectSerializer("cz.mobilesoft.coreblock.scene.insights.settings.InsightsSettingsActivity.Navigation.NavStatisticsSettings", INSTANCE, new Annotation[0]);
            }

            private final /* synthetic */ KSerializer c() {
                return (KSerializer) f103474a.getValue();
            }

            public boolean equals(Object obj) {
                return this == obj || (obj instanceof NavStatisticsSettings);
            }

            public int hashCode() {
                return 1432281867;
            }

            public final KSerializer<NavStatisticsSettings> serializer() {
                return c();
            }

            public String toString() {
                return "NavStatisticsSettings";
            }
        }
    }

    private final void C0(final NavHostController navHostController, final int i3, Composer composer, final int i4) {
        int i5;
        Composer composer2;
        Composer composerK = composer.k(-267496130);
        if ((i4 & 6) == 0) {
            i5 = (composerK.I(navHostController) ? 4 : 2) | i4;
        } else {
            i5 = i4;
        }
        if ((i4 & 48) == 0) {
            i5 |= composerK.e(i3) ? 32 : 16;
        }
        if ((i4 & 384) == 0) {
            i5 |= composerK.I(this) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if (composerK.r((i5 & 147) != 146, i5 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-267496130, i5, -1, "cz.mobilesoft.coreblock.scene.insights.settings.InsightsSettingsActivity.Content (InsightsSettingsActivity.kt:79)");
            }
            composer2 = composerK;
            ScaffoldKt.a(null, null, ComposableLambdaKt.e(16935449, true, new Function2() { // from class: cz.mobilesoft.coreblock.scene.insights.settings.r0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return InsightsSettingsActivity.D0(this.f103563a, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerK, 54), null, null, null, 0, false, null, false, null, 0.0f, 0L, 0L, 0L, 0L, 0L, ComposableLambdaKt.e(-252120512, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.insights.settings.c0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return InsightsSettingsActivity.F0(navHostController, i3, this, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerK, 54), composer2, 384, 12582912, 131067);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer2 = composerK;
            composer2.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.insights.settings.d0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return InsightsSettingsActivity.J0(this.f103489a, navHostController, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit D0(final InsightsSettingsActivity insightsSettingsActivity, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(16935449, i3, -1, "cz.mobilesoft.coreblock.scene.insights.settings.InsightsSettingsActivity.Content.<anonymous> (InsightsSettingsActivity.kt:82)");
            }
            String strB = StringResources_androidKt.b(R.string.wh, composer, 0);
            boolean zI = composer.I(insightsSettingsActivity);
            Object objG = composer.G();
            if (zI || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.insights.settings.i0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return InsightsSettingsActivity.E0(this.f103506a);
                    }
                };
                composer.w(objG);
            }
            ToolbarKt.d(strB, null, (Function0) objG, composer, 0, 2);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit E0(InsightsSettingsActivity insightsSettingsActivity) {
        insightsSettingsActivity.finish();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit F0(final NavHostController navHostController, int i3, final InsightsSettingsActivity insightsSettingsActivity, PaddingValues it, Composer composer, int i4) {
        int i5;
        Intrinsics.checkNotNullParameter(it, "it");
        if ((i4 & 6) == 0) {
            i5 = i4 | (composer.Z(it) ? 4 : 2);
        } else {
            i5 = i4;
        }
        if (composer.r((i5 & 19) != 18, i5 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-252120512, i5, -1, "cz.mobilesoft.coreblock.scene.insights.settings.InsightsSettingsActivity.Content.<anonymous> (InsightsSettingsActivity.kt:89)");
            }
            Modifier.Companion companion = Modifier.b8;
            float f3 = 16;
            Modifier modifierF = SizeKt.f(PaddingKt.i(PaddingKt.h(companion, it), Dp.g(f3)), 0.0f, 1, null);
            MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.h(), Alignment.f25072a.k(), composer, 0);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF2 = ComposedModifierKt.f(composer, modifierF);
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
            Updater.e(composerA, modifierF2, companion2.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            SpacerKt.a(SizeKt.v(companion, Dp.g(f3)), composer, 6);
            String strB = StringResources_androidKt.b(R.string.f95845t, composer, 0);
            RoundedCornerShape roundedCornerShapeF = RoundedCornerShapeKt.f(Dp.g(f3), Dp.g(f3), 0.0f, 0.0f, 12, null);
            Painter painterC = PainterResources_androidKt.c(R.drawable.h5, composer, 0);
            boolean zI = composer.I(navHostController);
            Object objG = composer.G();
            if (zI || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.insights.settings.e0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return InsightsSettingsActivity.G0(navHostController);
                    }
                };
                composer.w(objG);
            }
            SectionedItemKt.G(null, strB, null, null, null, null, null, null, painterC, true, 0L, 0L, roundedCornerShapeF, true, (Function0) objG, false, null, 0L, composer, 817889280, 3072, 232573);
            String strB2 = StringResources_androidKt.b(R.string.Lg, composer, 0);
            String strValueOf = String.valueOf(i3);
            RoundedCornerShape roundedCornerShapeD = RoundedCornerShapeKt.d(Dp.g(0));
            Painter painterC2 = PainterResources_androidKt.c(R.drawable.f95536l2, composer, 0);
            boolean zI2 = composer.I(navHostController);
            Object objG2 = composer.G();
            if (zI2 || objG2 == Composer.f23746a.a()) {
                objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.insights.settings.f0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return InsightsSettingsActivity.H0(navHostController);
                    }
                };
                composer.w(objG2);
            }
            SectionedItemKt.G(null, strB2, null, null, null, strValueOf, null, null, painterC2, true, 0L, 0L, roundedCornerShapeD, true, (Function0) objG2, false, null, 0L, composer, 817889280, 3072, 232541);
            String strB3 = StringResources_androidKt.b(R.string.S0, composer, 0);
            RoundedCornerShape roundedCornerShapeF2 = RoundedCornerShapeKt.f(0.0f, 0.0f, Dp.g(f3), Dp.g(f3), 3, null);
            Painter painterC3 = PainterResources_androidKt.c(R.drawable.f95579y0, composer, 0);
            boolean zI3 = composer.I(insightsSettingsActivity);
            Object objG3 = composer.G();
            if (zI3 || objG3 == Composer.f23746a.a()) {
                objG3 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.insights.settings.g0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return InsightsSettingsActivity.I0(this.f103503a);
                    }
                };
                composer.w(objG3);
            }
            SectionedItemKt.G(null, strB3, null, null, null, null, null, null, painterC3, true, 0L, 0L, roundedCornerShapeF2, false, (Function0) objG3, false, null, 0L, composer, 817889280, 0, 240765);
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
    public static final Unit G0(NavHostController navHostController) {
        NavController.O(navHostController, Navigation.NavStatisticsSettings.INSTANCE, null, null, 6, null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit H0(NavHostController navHostController) {
        NavController.O(navHostController, Navigation.NavIgnoreList.INSTANCE, null, null, 6, null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit I0(InsightsSettingsActivity insightsSettingsActivity) {
        insightsSettingsActivity.f103469f.b(AppFeelActivity.Companion.b(AppFeelActivity.f98567f, insightsSettingsActivity, false, 2, null));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit J0(InsightsSettingsActivity insightsSettingsActivity, NavHostController navHostController, int i3, int i4, Composer composer, int i5) {
        insightsSettingsActivity.C0(navHostController, i3, composer, RecomposeScopeImplKt.a(i4 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit K0(final InsightsSettingsActivity insightsSettingsActivity, final NavHostController navHostController, final ExcludedAppsViewState excludedAppsViewState, final Function1 function1, NavGraphBuilder NavHost) {
        Intrinsics.checkNotNullParameter(NavHost, "$this$NavHost");
        ComposableLambda composableLambdaC = ComposableLambdaKt.c(-1042399935, true, new Function4() { // from class: cz.mobilesoft.coreblock.scene.insights.settings.l0
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return InsightsSettingsActivity.L0(this.f103529a, navHostController, excludedAppsViewState, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        });
        NavigationKt$animatedComposable$1 navigationKt$animatedComposable$1 = NavigationKt$animatedComposable$1.f130488a;
        NavigationKt$animatedComposable$2 navigationKt$animatedComposable$2 = NavigationKt$animatedComposable$2.f130490a;
        NavigationKt$animatedComposable$3 navigationKt$animatedComposable$3 = NavigationKt$animatedComposable$3.f130492a;
        NavigationKt$animatedComposable$4 navigationKt$animatedComposable$4 = NavigationKt$animatedComposable$4.f130494a;
        NavGraphBuilderKt.b(NavHost, Reflection.b(Navigation.NavInsightsSettings.class), MapsKt.emptyMap(), CollectionsKt.emptyList(), navigationKt$animatedComposable$1, navigationKt$animatedComposable$2, navigationKt$animatedComposable$3, navigationKt$animatedComposable$4, null, composableLambdaC);
        ComposableLambda composableLambdaC2 = ComposableLambdaKt.c(-1822041238, true, new Function4() { // from class: cz.mobilesoft.coreblock.scene.insights.settings.m0
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return InsightsSettingsActivity.M0(this.f103533a, navHostController, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        });
        NavGraphBuilderKt.b(NavHost, Reflection.b(Navigation.NavStatisticsSettings.class), MapsKt.emptyMap(), CollectionsKt.emptyList(), navigationKt$animatedComposable$1, navigationKt$animatedComposable$2, navigationKt$animatedComposable$3, navigationKt$animatedComposable$4, null, composableLambdaC2);
        ComposableLambda composableLambdaC3 = ComposableLambdaKt.c(1435915657, true, new Function4() { // from class: cz.mobilesoft.coreblock.scene.insights.settings.n0
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return InsightsSettingsActivity.N0(excludedAppsViewState, function1, navHostController, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        });
        NavGraphBuilderKt.b(NavHost, Reflection.b(Navigation.NavIgnoreList.class), MapsKt.emptyMap(), CollectionsKt.emptyList(), navigationKt$animatedComposable$1, navigationKt$animatedComposable$2, navigationKt$animatedComposable$3, navigationKt$animatedComposable$4, null, composableLambdaC3);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit L0(InsightsSettingsActivity insightsSettingsActivity, NavHostController navHostController, ExcludedAppsViewState excludedAppsViewState, AnimatedContentScope animatedComposable, NavBackStackEntry it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(animatedComposable, "$this$animatedComposable");
        Intrinsics.checkNotNullParameter(it, "it");
        if (ComposerKt.M()) {
            ComposerKt.U(-1042399935, i3, -1, "cz.mobilesoft.coreblock.scene.insights.settings.InsightsSettingsActivity.RootCompose.<anonymous>.<anonymous>.<anonymous> (InsightsSettingsActivity.kt:53)");
        }
        insightsSettingsActivity.C0(navHostController, excludedAppsViewState.c().size(), composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit M0(InsightsSettingsActivity insightsSettingsActivity, NavHostController navHostController, AnimatedContentScope animatedComposable, NavBackStackEntry it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(animatedComposable, "$this$animatedComposable");
        Intrinsics.checkNotNullParameter(it, "it");
        if (ComposerKt.M()) {
            ComposerKt.U(-1822041238, i3, -1, "cz.mobilesoft.coreblock.scene.insights.settings.InsightsSettingsActivity.RootCompose.<anonymous>.<anonymous>.<anonymous> (InsightsSettingsActivity.kt:60)");
        }
        insightsSettingsActivity.Q0(navHostController, composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit N0(ExcludedAppsViewState excludedAppsViewState, Function1 function1, final NavHostController navHostController, AnimatedContentScope animatedComposable, NavBackStackEntry it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(animatedComposable, "$this$animatedComposable");
        Intrinsics.checkNotNullParameter(it, "it");
        if (ComposerKt.M()) {
            ComposerKt.U(1435915657, i3, -1, "cz.mobilesoft.coreblock.scene.insights.settings.InsightsSettingsActivity.RootCompose.<anonymous>.<anonymous>.<anonymous> (InsightsSettingsActivity.kt:64)");
        }
        boolean zI = composer.I(navHostController);
        Object objG = composer.G();
        if (zI || objG == Composer.f23746a.a()) {
            objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.insights.settings.o0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return InsightsSettingsActivity.O0(navHostController);
                }
            };
            composer.w(objG);
        }
        ExcludedAppsScreenKt.R(excludedAppsViewState, function1, (Function0) objG, composer, 0, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit O0(NavHostController navHostController) {
        navHostController.R();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit P0(InsightsSettingsActivity insightsSettingsActivity, PaddingValues paddingValues, int i3, Composer composer, int i4) {
        insightsSettingsActivity.c0(paddingValues, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    private final void Q0(final NavHostController navHostController, Composer composer, final int i3) {
        int i4;
        Composer composer2;
        Composer composerK = composer.k(175320199);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(navHostController) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if (composerK.r((i4 & 3) != 2, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(175320199, i4, -1, "cz.mobilesoft.coreblock.scene.insights.settings.InsightsSettingsActivity.StatisticsSettingsContent (InsightsSettingsActivity.kt:139)");
            }
            composer2 = composerK;
            ScaffoldKt.a(null, null, ComposableLambdaKt.e(1667769890, true, new Function2() { // from class: cz.mobilesoft.coreblock.scene.insights.settings.p0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return InsightsSettingsActivity.R0(navHostController, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerK, 54), null, null, null, 0, false, null, false, null, 0.0f, 0L, 0L, 0L, 0L, 0L, ComposableSingletons$InsightsSettingsActivityKt.f103423a.b(), composer2, 384, 12582912, 131067);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer2 = composerK;
            composer2.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.insights.settings.q0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return InsightsSettingsActivity.T0(this.f103553a, navHostController, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit R0(final NavHostController navHostController, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1667769890, i3, -1, "cz.mobilesoft.coreblock.scene.insights.settings.InsightsSettingsActivity.StatisticsSettingsContent.<anonymous> (InsightsSettingsActivity.kt:142)");
            }
            String strB = StringResources_androidKt.b(R.string.f95845t, composer, 0);
            boolean zI = composer.I(navHostController);
            Object objG = composer.G();
            if (zI || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.insights.settings.h0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return InsightsSettingsActivity.S0(navHostController);
                    }
                };
                composer.w(objG);
            }
            ToolbarKt.d(strB, null, (Function0) objG, composer, 0, 2);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit S0(NavHostController navHostController) {
        navHostController.R();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit T0(InsightsSettingsActivity insightsSettingsActivity, NavHostController navHostController, int i3, Composer composer, int i4) {
        insightsSettingsActivity.Q0(navHostController, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U0(InsightsSettingsActivity insightsSettingsActivity, ActivityResult result) {
        Intrinsics.checkNotNullParameter(result, "result");
        if (result.d() == -1) {
            insightsSettingsActivity.finish();
        }
    }

    @Override // cz.mobilesoft.coreblock.base.activity.BaseComposeActivity
    public void c0(final PaddingValues paddingValues, Composer composer, final int i3) {
        int i4;
        Composer composer2;
        Bundle bundleB;
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        Composer composerK = composer.k(609538334);
        if ((i3 & 48) == 0) {
            i4 = (composerK.I(this) ? 32 : 16) | i3;
        } else {
            i4 = i3;
        }
        if (composerK.r((i4 & 17) != 16, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(609538334, i4, -1, "cz.mobilesoft.coreblock.scene.insights.settings.InsightsSettingsActivity.RootCompose (InsightsSettingsActivity.kt:40)");
            }
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
            KClass kClassB = Reflection.b(ExcludedAppsViewModel.class);
            ViewModelStore viewModelStore = viewModelStoreOwnerC.getViewModelStore();
            Intrinsics.checkNotNullExpressionValue(viewModelStore, "viewModelStoreOwner.viewModelStore");
            ViewModel viewModelA = GetViewModelKt.a(kClassB, viewModelStore, null, creationExtrasA2 == null ? creationExtrasA : creationExtrasA2, null, scopeD, null);
            composerK.Y();
            composerK.Y();
            ExcludedAppsViewModel excludedAppsViewModel = (ExcludedAppsViewModel) viewModelA;
            final ExcludedAppsViewState excludedAppsViewState = (ExcludedAppsViewState) FlowExtKt.m(excludedAppsViewModel, composerK, 0);
            final Function1 function1N = FlowExtKt.n(excludedAppsViewModel, composerK, 0);
            final NavHostController navHostControllerB = NavHostControllerKt.b(new Navigator[0], composerK, 0);
            Modifier modifierF = SizeKt.f(Modifier.b8, 0.0f, 1, null);
            Navigation.NavInsightsSettings navInsightsSettings = Navigation.NavInsightsSettings.INSTANCE;
            boolean zI = composerK.I(this) | composerK.I(navHostControllerB) | composerK.Z(excludedAppsViewState) | composerK.Z(function1N);
            Object objG = composerK.G();
            if (zI || objG == Composer.f23746a.a()) {
                objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.insights.settings.j0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return InsightsSettingsActivity.K0(this.f103509a, navHostControllerB, excludedAppsViewState, function1N, (NavGraphBuilder) obj);
                    }
                };
                composerK.w(objG);
            }
            composer2 = composerK;
            NavHostKt.u(navHostControllerB, navInsightsSettings, modifierF, null, null, null, null, null, null, null, null, (Function1) objG, composer2, 384, 0, 2040);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer2 = composerK;
            composer2.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.insights.settings.k0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return InsightsSettingsActivity.P0(this.f103518a, paddingValues, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}
