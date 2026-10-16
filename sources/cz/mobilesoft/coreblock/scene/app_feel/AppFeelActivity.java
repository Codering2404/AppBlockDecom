package cz.mobilesoft.coreblock.scene.app_feel;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.activity.compose.BackHandlerKt;
import androidx.compose.animation.AnimatedContentScope;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.material.icons.twotone.Phg.QaXmqxvjHhxVy;
import androidx.compose.material3.AppBarKt;
import androidx.compose.material3.ScaffoldKt;
import androidx.compose.material3.TopAppBarDefaults;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
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
import com.facebook.internal.Utility;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.base.activity.BaseComposeActivity;
import cz.mobilesoft.coreblock.enums.AppDistractionType;
import cz.mobilesoft.coreblock.enums.PremiumFeature;
import cz.mobilesoft.coreblock.scene.app_feel.AppFeelViewEvent;
import cz.mobilesoft.coreblock.scene.app_feel.screens.AppFeelFinishedScreenKt;
import cz.mobilesoft.coreblock.scene.app_feel.screens.AppFeelLabelingScreenKt;
import cz.mobilesoft.coreblock.scene.app_feel.screens.AppFeelSummaryScreenKt;
import cz.mobilesoft.coreblock.scene.app_feel.screens.AppFeelWelcomeScreenKt;
import cz.mobilesoft.coreblock.scene.premium.host.Paywall;
import cz.mobilesoft.coreblock.scene.premium.host.PaywallTarget;
import cz.mobilesoft.coreblock.util.compose.FlowExtKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.view.compose.ComposeButtonsKt;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import org.koin.androidx.compose.ViewModelComposeExtKt;
import org.koin.androidx.viewmodel.GetViewModelKt;
import org.koin.androidx.viewmodel.ext.android.BundleExtKt;
import org.koin.core.context.GlobalContext;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.parameter.ParametersHolderKt;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class AppFeelActivity extends BaseComposeActivity {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Companion f98567f = new Companion(null);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f98568g = 8;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class AppFeelNavItem {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ AppFeelNavItem[] $VALUES;
        private final String route;
        public static final AppFeelNavItem Welcome = new AppFeelNavItem("Welcome", 0, "welcome");
        public static final AppFeelNavItem Labeling = new AppFeelNavItem("Labeling", 1, "labeling");
        public static final AppFeelNavItem Summary = new AppFeelNavItem("Summary", 2, "summary");
        public static final AppFeelNavItem Finished = new AppFeelNavItem("Finished", 3, "finished");
        public static final AppFeelNavItem Empty = new AppFeelNavItem("Empty", 4, "empty");

        private static final /* synthetic */ AppFeelNavItem[] $values() {
            return new AppFeelNavItem[]{Welcome, Labeling, Summary, Finished, Empty};
        }

        static {
            AppFeelNavItem[] appFeelNavItemArr$values = $values();
            $VALUES = appFeelNavItemArr$values;
            $ENTRIES = EnumEntriesKt.a(appFeelNavItemArr$values);
        }

        private AppFeelNavItem(String str, int i3, String str2) {
            this.route = str2;
        }

        public static EnumEntries<AppFeelNavItem> getEntries() {
            return $ENTRIES;
        }

        public static AppFeelNavItem valueOf(String str) {
            return (AppFeelNavItem) Enum.valueOf(AppFeelNavItem.class, str);
        }

        public static AppFeelNavItem[] values() {
            return (AppFeelNavItem[]) $VALUES.clone();
        }

        public final String getRoute() {
            return this.route;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ Intent b(Companion companion, Context context, boolean z2, int i3, Object obj) {
            if ((i3 & 2) != 0) {
                z2 = false;
            }
            return companion.a(context, z2);
        }

        public final Intent a(Context context, boolean z2) {
            Intrinsics.checkNotNullParameter(context, "context");
            Bundle bundle = new Bundle();
            bundle.putBoolean("IS_APP_FEEL_ONBOARDING", z2);
            Intent intent = new Intent(context, (Class<?>) AppFeelActivity.class);
            intent.putExtras(bundle);
            return intent;
        }

        private Companion() {
        }
    }

    private final void I0(final AppFeelViewState appFeelViewState, final NavHostController navHostController, final PaddingValues paddingValues, final Function1 function1, Composer composer, final int i3) {
        int i4;
        Composer composerK = composer.k(-280210569);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(appFeelViewState) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(navHostController) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.Z(paddingValues) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            i4 |= composerK.I(function1) ? 2048 : 1024;
        }
        if ((i3 & 24576) == 0) {
            i4 |= composerK.I(this) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        }
        if (composerK.r((i4 & 9363) != 9362, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-280210569, i4, -1, "cz.mobilesoft.coreblock.scene.app_feel.AppFeelActivity.NavigationHost (AppFeelActivity.kt:107)");
            }
            Modifier modifierH = PaddingKt.h(BackgroundKt.d(Modifier.b8, ComposeColorsKt.j(composerK, 0).e(), null, 2, null), paddingValues);
            String route = AppFeelNavItem.Welcome.getRoute();
            boolean zI = ((i4 & 14) == 4) | composerK.I(navHostController) | ((i4 & 7168) == 2048) | composerK.I(this);
            Object objG = composerK.G();
            if (zI || objG == Composer.f23746a.a()) {
                objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.app_feel.r
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return AppFeelActivity.J0(appFeelViewState, navHostController, function1, this, (NavGraphBuilder) obj);
                    }
                };
                composerK.w(objG);
            }
            NavHostKt.v(navHostController, route, modifierH, null, null, null, null, null, null, null, (Function1) objG, composerK, ((i4 >> 3) & 14) | 48, 0, 1016);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.app_feel.s
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AppFeelActivity.Z0(this.f98655a, appFeelViewState, navHostController, paddingValues, function1, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit J0(final AppFeelViewState appFeelViewState, final NavHostController navHostController, final Function1 function1, final AppFeelActivity appFeelActivity, NavGraphBuilder NavHost) {
        Intrinsics.checkNotNullParameter(NavHost, "$this$NavHost");
        NavGraphBuilderKt.c(NavHost, AppFeelNavItem.Welcome.getRoute(), null, null, null, null, null, null, null, ComposableLambdaKt.c(969968730, true, new Function4() { // from class: cz.mobilesoft.coreblock.scene.app_feel.u
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return AppFeelActivity.K0(appFeelViewState, navHostController, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        }), 254, null);
        NavGraphBuilderKt.c(NavHost, AppFeelNavItem.Empty.getRoute(), null, null, null, null, null, null, null, ComposableSingletons$AppFeelActivityKt.f98622a.e(), 254, null);
        NavGraphBuilderKt.c(NavHost, AppFeelNavItem.Labeling.getRoute(), null, null, null, null, null, null, null, ComposableLambdaKt.c(-1646070830, true, new Function4() { // from class: cz.mobilesoft.coreblock.scene.app_feel.v
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return AppFeelActivity.M0(appFeelViewState, function1, navHostController, appFeelActivity, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        }), 254, null);
        NavGraphBuilderKt.c(NavHost, AppFeelNavItem.Summary.getRoute(), null, null, null, null, null, null, null, ComposableLambdaKt.c(517231379, true, new Function4() { // from class: cz.mobilesoft.coreblock.scene.app_feel.w
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return AppFeelActivity.S0(appFeelViewState, appFeelActivity, navHostController, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        }), 254, null);
        NavGraphBuilderKt.c(NavHost, AppFeelNavItem.Finished.getRoute(), null, null, null, null, null, null, null, ComposableLambdaKt.c(-1614433708, true, new Function4() { // from class: cz.mobilesoft.coreblock.scene.app_feel.b
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return AppFeelActivity.W0(this.f98629a, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        }), 254, null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit L0(AppFeelViewState appFeelViewState, NavHostController navHostController) {
        if (appFeelViewState.d().isEmpty()) {
            NavController.P(navHostController, AppFeelNavItem.Empty.getRoute(), null, null, 6, null);
        } else {
            NavController.P(navHostController, AppFeelNavItem.Labeling.getRoute(), null, null, 6, null);
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit M0(final AppFeelViewState appFeelViewState, final Function1 function1, final NavHostController navHostController, final AppFeelActivity appFeelActivity, AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        if (ComposerKt.M()) {
            ComposerKt.U(-1646070830, i3, -1, "cz.mobilesoft.coreblock.scene.app_feel.AppFeelActivity.NavigationHost.<anonymous>.<anonymous>.<anonymous> (AppFeelActivity.kt:134)");
        }
        Object objG = composer.G();
        Composer.Companion companion = Composer.f23746a;
        if (objG == companion.a()) {
            objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.app_feel.e
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return AppFeelActivity.N0();
                }
            };
            composer.w(objG);
        }
        BackHandlerKt.a(false, (Function0) objG, composer, 48, 1);
        boolean Z = composer.Z(function1);
        Object objG2 = composer.G();
        if (Z || objG2 == companion.a()) {
            objG2 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.app_feel.f
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return AppFeelActivity.O0(function1, (String) obj);
                }
            };
            composer.w(objG2);
        }
        Function1 function12 = (Function1) objG2;
        boolean Z2 = composer.Z(function1);
        Object objG3 = composer.G();
        if (Z2 || objG3 == companion.a()) {
            objG3 = new Function2() { // from class: cz.mobilesoft.coreblock.scene.app_feel.g
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AppFeelActivity.P0(function1, (String) obj, (AppDistractionType) obj2);
                }
            };
            composer.w(objG3);
        }
        Function2 function2 = (Function2) objG3;
        boolean Z3 = composer.Z(appFeelViewState) | composer.I(navHostController) | composer.Z(function1);
        Object objG4 = composer.G();
        if (Z3 || objG4 == companion.a()) {
            objG4 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.app_feel.h
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return AppFeelActivity.Q0(appFeelViewState, navHostController, function1);
                }
            };
            composer.w(objG4);
        }
        Function0 function0 = (Function0) objG4;
        boolean zI = composer.I(appFeelActivity);
        Object objG5 = composer.G();
        if (zI || objG5 == companion.a()) {
            objG5 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.app_feel.i
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return AppFeelActivity.R0(this.f98639a);
                }
            };
            composer.w(objG5);
        }
        AppFeelLabelingScreenKt.J(appFeelViewState, function12, function2, function0, (Function0) objG5, composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit N0() {
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit O0(Function1 function1, String packageName) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        function1.invoke(new AppFeelViewEvent.OnItemExcludedFromReports(packageName, true));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit P0(Function1 function1, String packageName, AppDistractionType appDistractionType) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        Intrinsics.checkNotNullParameter(appDistractionType, "appDistractionType");
        function1.invoke(new AppFeelViewEvent.OnAppTypeUpdated(packageName, appDistractionType));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Q0(AppFeelViewState appFeelViewState, NavHostController navHostController, Function1 function1) {
        if (appFeelViewState.h()) {
            NavController.P(navHostController, AppFeelNavItem.Summary.getRoute(), null, null, 6, null);
        } else {
            NavController.P(navHostController, AppFeelNavItem.Finished.getRoute(), null, null, 6, null);
        }
        function1.invoke(AppFeelViewEvent.OnLabelingFinished.f98573a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit R0(AppFeelActivity appFeelActivity) {
        appFeelActivity.startActivity(Paywall.c(Paywall.f113165a, appFeelActivity, new PaywallTarget.LimitScreen(PremiumFeature.STATISTICS), "app_feel_labeling", "app_feel_exclude", false, false, false, null, 240, null));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit S0(AppFeelViewState appFeelViewState, final AppFeelActivity appFeelActivity, final NavHostController navHostController, AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        if (ComposerKt.M()) {
            ComposerKt.U(517231379, i3, -1, "cz.mobilesoft.coreblock.scene.app_feel.AppFeelActivity.NavigationHost.<anonymous>.<anonymous>.<anonymous> (AppFeelActivity.kt:167)");
        }
        Object objG = composer.G();
        Composer.Companion companion = Composer.f23746a;
        if (objG == companion.a()) {
            objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.app_feel.m
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return AppFeelActivity.T0();
                }
            };
            composer.w(objG);
        }
        BackHandlerKt.a(false, (Function0) objG, composer, 48, 1);
        boolean zI = composer.I(appFeelActivity);
        Object objG2 = composer.G();
        if (zI || objG2 == companion.a()) {
            objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.app_feel.n
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return AppFeelActivity.U0(this.f98642a);
                }
            };
            composer.w(objG2);
        }
        Function0 function0 = (Function0) objG2;
        boolean zI2 = composer.I(navHostController);
        Object objG3 = composer.G();
        if (zI2 || objG3 == companion.a()) {
            objG3 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.app_feel.o
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return AppFeelActivity.V0(navHostController);
                }
            };
            composer.w(objG3);
        }
        AppFeelSummaryScreenKt.c(appFeelViewState, function0, (Function0) objG3, composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit T0() {
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit U0(AppFeelActivity appFeelActivity) {
        appFeelActivity.finish();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit V0(NavHostController navHostController) {
        NavController.P(navHostController, AppFeelNavItem.Labeling.getRoute(), null, null, 6, null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit W0(final AppFeelActivity appFeelActivity, AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i3) throws XmlPullParserException, IOException {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        if (ComposerKt.M()) {
            ComposerKt.U(-1614433708, i3, -1, "cz.mobilesoft.coreblock.scene.app_feel.AppFeelActivity.NavigationHost.<anonymous>.<anonymous>.<anonymous> (AppFeelActivity.kt:182)");
        }
        Object objG = composer.G();
        Composer.Companion companion = Composer.f23746a;
        if (objG == companion.a()) {
            objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.app_feel.j
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return AppFeelActivity.X0();
                }
            };
            composer.w(objG);
        }
        BackHandlerKt.a(false, (Function0) objG, composer, 48, 1);
        boolean zI = composer.I(appFeelActivity);
        Object objG2 = composer.G();
        if (zI || objG2 == companion.a()) {
            objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.app_feel.k
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return AppFeelActivity.Y0(this.f98640a);
                }
            };
            composer.w(objG2);
        }
        AppFeelFinishedScreenKt.g((Function0) objG2, composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit X0() {
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Y0(AppFeelActivity appFeelActivity) {
        appFeelActivity.setResult(-1);
        appFeelActivity.finish();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Z0(AppFeelActivity appFeelActivity, AppFeelViewState appFeelViewState, NavHostController navHostController, PaddingValues paddingValues, Function1 function1, int i3, Composer composer, int i4) {
        appFeelActivity.I0(appFeelViewState, navHostController, paddingValues, function1, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ParametersHolder a1(AppFeelActivity appFeelActivity) {
        return ParametersHolderKt.b(Boolean.valueOf(appFeelActivity.g1()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit b1(final AppFeelActivity appFeelActivity, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1820553098, i3, -1, "cz.mobilesoft.coreblock.scene.app_feel.AppFeelActivity.RootCompose.<anonymous> (AppFeelActivity.kt:75)");
            }
            AppBarKt.p(ComposableSingletons$AppFeelActivityKt.f98622a.d(), null, ComposableLambdaKt.e(-192718736, true, new Function2() { // from class: cz.mobilesoft.coreblock.scene.app_feel.t
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AppFeelActivity.c1(this.f98887a, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), null, 0.0f, null, TopAppBarDefaults.f21543a.p(ComposeColorsKt.j(composer, 0).e(), 0L, 0L, 0L, 0L, composer, TopAppBarDefaults.f21549g << 15, 30), null, composer, 390, 186);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit c1(final AppFeelActivity appFeelActivity, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-192718736, i3, -1, "cz.mobilesoft.coreblock.scene.app_feel.AppFeelActivity.RootCompose.<anonymous>.<anonymous> (AppFeelActivity.kt:81)");
            }
            PaddingValues paddingValuesA = PaddingKt.a(Dp.g(0));
            boolean zI = composer.I(appFeelActivity);
            Object objG = composer.G();
            if (zI || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.app_feel.c
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return AppFeelActivity.d1(this.f98631a);
                    }
                };
                composer.w(objG);
            }
            ComposeButtonsKt.o0(null, paddingValuesA, 0, (Function0) objG, composer, 48, 5);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit d1(AppFeelActivity appFeelActivity) {
        appFeelActivity.finish();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit e1(AppFeelActivity appFeelActivity, AppFeelViewState appFeelViewState, NavHostController navHostController, Function1 function1, PaddingValues it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(it, "it");
        if ((i3 & 6) == 0) {
            i3 |= composer.Z(it) ? 4 : 2;
        }
        if (composer.r((i3 & 19) != 18, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1776475263, i3, -1, "cz.mobilesoft.coreblock.scene.app_feel.AppFeelActivity.RootCompose.<anonymous> (AppFeelActivity.kt:91)");
            }
            appFeelActivity.I0(appFeelViewState, navHostController, it, function1, composer, (i3 << 6) & 896);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit f1(AppFeelActivity appFeelActivity, PaddingValues paddingValues, int i3, Composer composer, int i4) {
        appFeelActivity.c0(paddingValues, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    @Override // cz.mobilesoft.coreblock.base.activity.BaseComposeActivity
    public void c0(final PaddingValues paddingValues, Composer composer, final int i3) {
        int i4;
        Composer composer2;
        Bundle bundleB;
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        Composer composerK = composer.k(-1546495822);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(paddingValues) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(this) ? 32 : 16;
        }
        if (composerK.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1546495822, i4, -1, "cz.mobilesoft.coreblock.scene.app_feel.AppFeelActivity.RootCompose (AppFeelActivity.kt:58)");
            }
            final NavHostController navHostControllerB = NavHostControllerKt.b(new Navigator[0], composerK, 0);
            boolean zI = composerK.I(this);
            Object objG = composerK.G();
            if (zI || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.app_feel.a
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return AppFeelActivity.a1(this.f98625a);
                    }
                };
                composerK.w(objG);
            }
            Function0 function0 = (Function0) objG;
            composerK.F(-101221098);
            ViewModelStoreOwner viewModelStoreOwnerC = LocalViewModelStoreOwner.f40240a.c(composerK, 8);
            if (viewModelStoreOwnerC == null) {
                throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
            }
            CreationExtras creationExtrasA = ViewModelComposeExtKt.a(viewModelStoreOwnerC, composerK, 8);
            Scope scopeD = GlobalContext.f145907a.get().j().d();
            composerK.F(-1072256281);
            CreationExtras creationExtrasA2 = null;
            NavBackStackEntry navBackStackEntry = viewModelStoreOwnerC instanceof NavBackStackEntry ? (NavBackStackEntry) viewModelStoreOwnerC : null;
            if (navBackStackEntry != null && (bundleB = navBackStackEntry.b()) != null) {
                creationExtrasA2 = BundleExtKt.a(bundleB, viewModelStoreOwnerC);
            }
            KClass kClassB = Reflection.b(AppFeelViewModel.class);
            ViewModelStore viewModelStore = viewModelStoreOwnerC.getViewModelStore();
            Intrinsics.checkNotNullExpressionValue(viewModelStore, "viewModelStoreOwner.viewModelStore");
            ViewModel viewModelA = GetViewModelKt.a(kClassB, viewModelStore, null, creationExtrasA2 == null ? creationExtrasA : creationExtrasA2, null, scopeD, function0);
            composerK.Y();
            composerK.Y();
            AppFeelViewModel appFeelViewModel = (AppFeelViewModel) viewModelA;
            final AppFeelViewState appFeelViewState = (AppFeelViewState) FlowExtKt.m(appFeelViewModel, composerK, 0);
            final Function1 function1N = FlowExtKt.n(appFeelViewModel, composerK, 0);
            composer2 = composerK;
            ScaffoldKt.a(PaddingKt.m(PaddingKt.h(Modifier.b8, paddingValues), 0.0f, 0.0f, 0.0f, Dp.g(16), 7, null), ComposableLambdaKt.e(-1820553098, true, new Function2() { // from class: cz.mobilesoft.coreblock.scene.app_feel.l
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AppFeelActivity.b1(this.f98641a, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerK, 54), null, null, null, 0, 0L, 0L, null, ComposableLambdaKt.e(-1776475263, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.app_feel.p
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return AppFeelActivity.e1(this.f98644a, appFeelViewState, navHostControllerB, function1N, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerK, 54), composer2, 805306416, 508);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer2 = composerK;
            composer2.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.app_feel.q
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AppFeelActivity.f1(this.f98648a, paddingValues, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public final boolean g1() {
        Intent intent = getIntent();
        if (intent != null) {
            return intent.getBooleanExtra("IS_APP_FEEL_ONBOARDING", false);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit K0(final AppFeelViewState appFeelViewState, final NavHostController navHostController, AnimatedContentScope animatedContentScope, NavBackStackEntry it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(animatedContentScope, QaXmqxvjHhxVy.EIczelhOyrxlsH);
        Intrinsics.checkNotNullParameter(it, "it");
        if (ComposerKt.M()) {
            ComposerKt.U(969968730, i3, -1, "cz.mobilesoft.coreblock.scene.app_feel.AppFeelActivity.NavigationHost.<anonymous>.<anonymous>.<anonymous> (AppFeelActivity.kt:116)");
        }
        boolean Z = composer.Z(appFeelViewState) | composer.I(navHostController);
        Object objG = composer.G();
        if (Z || objG == Composer.f23746a.a()) {
            objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.app_feel.d
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return AppFeelActivity.L0(appFeelViewState, navHostController);
                }
            };
            composer.w(objG);
        }
        AppFeelWelcomeScreenKt.b((Function0) objG, composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }
}
