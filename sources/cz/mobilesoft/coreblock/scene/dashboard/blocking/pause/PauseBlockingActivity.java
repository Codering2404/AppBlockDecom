package cz.mobilesoft.coreblock.scene.dashboard.blocking.pause;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.compose.animation.AnimatedContentScope;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
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
import cz.mobilesoft.coreblock.base.activity.BaseComposeActivity;
import cz.mobilesoft.coreblock.enums.PremiumState;
import cz.mobilesoft.coreblock.scene.dashboard.blocking.pause.datetimepicker.DateTimePickerScreenKt;
import cz.mobilesoft.coreblock.storage.datastore.entity.ProfileDisabledSuggestStrictModeState;
import cz.mobilesoft.coreblock.util.compose.FlowExtKt;
import cz.mobilesoft.coreblock.util.helperextension.ComparableExtKt;
import cz.mobilesoft.coreblock.util.helperextension.TimeHelperExt;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
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
public final class PauseBlockingActivity extends BaseComposeActivity {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Companion f100101g = new Companion(null);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f100102h = 8;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f100103f;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Intent a(Context context, long j3, String isPremium, ProfileDisabledSuggestStrictModeState state) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(isPremium, "isPremium");
            Intrinsics.checkNotNullParameter(state, "state");
            Intent intent = new Intent(context, (Class<?>) PauseBlockingActivity.class);
            intent.putExtra("PROFILE_ID", j3);
            intent.putExtra("IS_PREMIUM", isPremium);
            intent.putExtra("PROFILE_STATE_SUGGESTION", state);
            return intent;
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit A0(PauseBlockingActivity pauseBlockingActivity, PaddingValues paddingValues, int i3, Composer composer, int i4) {
        pauseBlockingActivity.c0(paddingValues, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ParametersHolder t0(PauseBlockingActivity pauseBlockingActivity, PremiumState premiumState) {
        return ParametersHolderKt.b(Long.valueOf(pauseBlockingActivity.getIntent().getLongExtra("PROFILE_ID", -1L)), premiumState);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit u0(final PauseBlockingViewState pauseBlockingViewState, final Function1 function1, final NavHostController navHostController, final PauseBlockingActivity pauseBlockingActivity, NavGraphBuilder NavHost) {
        Intrinsics.checkNotNullParameter(NavHost, "$this$NavHost");
        ComposableLambda composableLambdaC = ComposableLambdaKt.c(-1480912450, true, new Function4() { // from class: cz.mobilesoft.coreblock.scene.dashboard.blocking.pause.l
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return PauseBlockingActivity.v0(pauseBlockingViewState, function1, navHostController, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        });
        NavGraphBuilderKt.b(NavHost, Reflection.b(NavPauseBlocking.class), MapsKt.emptyMap(), CollectionsKt.emptyList(), null, null, null, null, null, composableLambdaC);
        ComposableLambda composableLambdaC2 = ComposableLambdaKt.c(663619509, true, new Function4() { // from class: cz.mobilesoft.coreblock.scene.dashboard.blocking.pause.m
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return PauseBlockingActivity.w0(navHostController, function1, pauseBlockingViewState, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        });
        NavGraphBuilderKt.b(NavHost, Reflection.b(NavDateTimePicker.class), MapsKt.emptyMap(), CollectionsKt.emptyList(), null, null, null, null, null, composableLambdaC2);
        ComposableLambda composableLambdaC3 = ComposableLambdaKt.c(-1418931850, true, new Function4() { // from class: cz.mobilesoft.coreblock.scene.dashboard.blocking.pause.n
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return PauseBlockingActivity.x0(this.f100315a, navHostController, pauseBlockingViewState, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        });
        NavGraphBuilderKt.b(NavHost, Reflection.b(NavPauseBlockingWarning.class), MapsKt.emptyMap(), CollectionsKt.emptyList(), null, null, null, null, null, composableLambdaC3);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit v0(PauseBlockingViewState pauseBlockingViewState, Function1 function1, NavHostController navHostController, AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        if (ComposerKt.M()) {
            ComposerKt.U(-1480912450, i3, -1, "cz.mobilesoft.coreblock.scene.dashboard.blocking.pause.PauseBlockingActivity.RootCompose.<anonymous>.<anonymous>.<anonymous> (PauseBlockingActivity.kt:114)");
        }
        PauseBlockingScreenKt.u(pauseBlockingViewState, function1, navHostController, composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit w0(NavHostController navHostController, Function1 function1, PauseBlockingViewState pauseBlockingViewState, AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        if (ComposerKt.M()) {
            ComposerKt.U(663619509, i3, -1, "cz.mobilesoft.coreblock.scene.dashboard.blocking.pause.PauseBlockingActivity.RootCompose.<anonymous>.<anonymous>.<anonymous> (PauseBlockingActivity.kt:122)");
        }
        DateTimePickerScreenKt.t(navHostController, function1, pauseBlockingViewState, composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit x0(final PauseBlockingActivity pauseBlockingActivity, final NavHostController navHostController, PauseBlockingViewState pauseBlockingViewState, AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        if (ComposerKt.M()) {
            ComposerKt.U(-1418931850, i3, -1, "cz.mobilesoft.coreblock.scene.dashboard.blocking.pause.PauseBlockingActivity.RootCompose.<anonymous>.<anonymous>.<anonymous> (PauseBlockingActivity.kt:130)");
        }
        boolean zI = composer.I(pauseBlockingActivity);
        Object objG = composer.G();
        if (zI || objG == Composer.f23746a.a()) {
            objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.dashboard.blocking.pause.o
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return PauseBlockingActivity.y0(this.f100322a);
                }
            };
            composer.w(objG);
        }
        Function0 function0 = (Function0) objG;
        boolean zI2 = composer.I(navHostController);
        Object objG2 = composer.G();
        if (zI2 || objG2 == Composer.f23746a.a()) {
            objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.dashboard.blocking.pause.p
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return PauseBlockingActivity.z0(navHostController);
                }
            };
            composer.w(objG2);
        }
        PauseBlockingWarningScreenKt.f(function0, (Function0) objG2, pauseBlockingViewState, composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit y0(PauseBlockingActivity pauseBlockingActivity) {
        pauseBlockingActivity.finish();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit z0(NavHostController navHostController) {
        NavController.O(navHostController, NavPauseBlocking.INSTANCE, null, null, 6, null);
        return Unit.f139807a;
    }

    @Override // cz.mobilesoft.coreblock.base.activity.BaseComposeActivity
    public void c0(final PaddingValues paddingValues, Composer composer, final int i3) {
        int i4;
        Composer composer2;
        final PremiumState premiumStateA;
        Bundle bundleB;
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        Composer composerK = composer.k(-688044931);
        if ((i3 & 48) == 0) {
            i4 = (composerK.I(this) ? 32 : 16) | i3;
        } else {
            i4 = i3;
        }
        if (composerK.r((i4 & 17) != 16, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-688044931, i4, -1, "cz.mobilesoft.coreblock.scene.dashboard.blocking.pause.PauseBlockingActivity.RootCompose (PauseBlockingActivity.kt:61)");
            }
            String stringExtra = getIntent().getStringExtra("IS_PREMIUM");
            if (stringExtra == null || (premiumStateA = PremiumState.Companion.a(stringExtra)) == null) {
                premiumStateA = PremiumState.None.INSTANCE;
            }
            final NavHostController navHostControllerB = NavHostControllerKt.b(new Navigator[0], composerK, 0);
            boolean zI = composerK.I(this) | composerK.Z(premiumStateA);
            Object objG = composerK.G();
            if (zI || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.dashboard.blocking.pause.i
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return PauseBlockingActivity.t0(this.f100294a, premiumStateA);
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
            NavBackStackEntry navBackStackEntry = viewModelStoreOwnerC instanceof NavBackStackEntry ? (NavBackStackEntry) viewModelStoreOwnerC : null;
            CreationExtras creationExtrasA2 = (navBackStackEntry == null || (bundleB = navBackStackEntry.b()) == null) ? null : BundleExtKt.a(bundleB, viewModelStoreOwnerC);
            KClass kClassB = Reflection.b(PauseBlockingViewModel.class);
            ViewModelStore viewModelStore = viewModelStoreOwnerC.getViewModelStore();
            Intrinsics.checkNotNullExpressionValue(viewModelStore, "viewModelStoreOwner.viewModelStore");
            ViewModel viewModelA = GetViewModelKt.a(kClassB, viewModelStore, null, creationExtrasA2 == null ? creationExtrasA : creationExtrasA2, null, scopeD, function0);
            composerK.Y();
            composerK.Y();
            PauseBlockingViewModel pauseBlockingViewModel = (PauseBlockingViewModel) viewModelA;
            Serializable serializableExtra = getIntent().getSerializableExtra("PROFILE_STATE_SUGGESTION");
            Intrinsics.checkNotNull(serializableExtra, "null cannot be cast to non-null type cz.mobilesoft.coreblock.storage.datastore.entity.ProfileDisabledSuggestStrictModeState");
            ProfileDisabledSuggestStrictModeState profileDisabledSuggestStrictModeState = (ProfileDisabledSuggestStrictModeState) serializableExtra;
            final Function1 function1N = FlowExtKt.n(pauseBlockingViewModel, composerK, 0);
            final PauseBlockingViewState pauseBlockingViewState = (PauseBlockingViewState) FlowExtKt.m(pauseBlockingViewModel, composerK, 0);
            Context context = (Context) composerK.q(AndroidCompositionLocals_androidKt.g());
            long jCurrentTimeMillis = System.currentTimeMillis();
            boolean zI2 = composerK.I(this) | composerK.I(context);
            Object objG2 = composerK.G();
            if (zI2 || objG2 == Composer.f23746a.a()) {
                objG2 = new PauseBlockingActivity$RootCompose$1$1(this, context, null);
                composerK.w(objG2);
            }
            FlowExtKt.g(pauseBlockingViewModel, null, (Function2) objG2, composerK, 0, 2);
            Object obj = (!ComparableExtKt.c(Long.valueOf(profileDisabledSuggestStrictModeState.getDisabledCount()), 2L) || profileDisabledSuggestStrictModeState.getLastDisabledTime() < jCurrentTimeMillis - TimeHelperExt.f128663a.l()) ? NavPauseBlocking.INSTANCE : NavPauseBlockingWarning.INSTANCE;
            boolean Z = composerK.Z(pauseBlockingViewState) | composerK.Z(function1N) | composerK.I(navHostControllerB) | composerK.I(this);
            Object objG3 = composerK.G();
            if (Z || objG3 == Composer.f23746a.a()) {
                objG3 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.dashboard.blocking.pause.j
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return PauseBlockingActivity.u0(pauseBlockingViewState, function1N, navHostControllerB, this, (NavGraphBuilder) obj2);
                    }
                };
                composerK.w(objG3);
            }
            composer2 = composerK;
            NavHostKt.u(navHostControllerB, obj, null, null, null, null, null, null, null, null, null, (Function1) objG3, composer2, 0, 0, 2044);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer2 = composerK;
            composer2.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.dashboard.blocking.pause.k
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    return PauseBlockingActivity.A0(this.f100303a, paddingValues, i3, (Composer) obj2, ((Integer) obj3).intValue());
                }
            });
        }
    }

    @Override // cz.mobilesoft.coreblock.base.activity.BaseComposeActivity
    protected boolean f0() {
        return this.f100103f;
    }
}
