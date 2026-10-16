package cz.mobilesoft.coreblock.scene.more.signin;

import android.content.Context;
import android.content.Intent;
import androidx.activity.compose.ActivityResultRegistryKt;
import androidx.activity.compose.ManagedActivityResultLauncher;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.compose.animation.AnimatedContentScope;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.material.ScaffoldState;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavController;
import androidx.navigation.NavGraphBuilder;
import androidx.navigation.NavHostController;
import androidx.navigation.compose.NavGraphBuilderKt;
import androidx.navigation.compose.NavHostKt;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.scene.more.help.restorepurchase.RestorePurchaseScreenKt;
import cz.mobilesoft.coreblock.scene.more.signin.SignInViewEvent;
import cz.mobilesoft.coreblock.util.compose.FlowExtKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
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
public final class SignInContentKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit A(SignInViewState signInViewState, NavHostController navHostController, Function1 function1, ActivityResult it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (signInViewState.p()) {
            NavController.P(navHostController, NavItem.RestorePurchase.getRoute(), null, null, 6, null);
        } else {
            function1.invoke(Boolean.TRUE);
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit B(Context context, NavHostController navHostController, SignInViewModel signInViewModel, SignInViewState signInViewState, ScaffoldState scaffoldState, MutableState mutableState, MutableState mutableState2, MutableState mutableState3, CoroutineScope coroutineScope, Function1 function1, Function0 function0, int i3, int i4, Composer composer, int i5) {
        z(context, navHostController, signInViewModel, signInViewState, scaffoldState, mutableState, mutableState2, mutableState3, coroutineScope, function1, function0, composer, RecomposeScopeImplKt.a(i3 | 1), RecomposeScopeImplKt.a(i4));
        return Unit.f139807a;
    }

    private static final void C(Float f3, final NavHostController navHostController, final Function1 function1, final SignInViewState signInViewState, final PaddingValues paddingValues, final Function1 function12, Composer composer, final int i3, final int i4) {
        Float f4;
        int i5;
        Function1 function13;
        SignInViewState signInViewState2;
        Function1 function14;
        final Float f5;
        Float f6;
        Composer composerK = composer.k(-596179947);
        int i6 = i4 & 1;
        if (i6 != 0) {
            i5 = i3 | 6;
            f4 = f3;
        } else if ((i3 & 6) == 0) {
            f4 = f3;
            i5 = (composerK.Z(f4) ? 4 : 2) | i3;
        } else {
            f4 = f3;
            i5 = i3;
        }
        if ((i3 & 48) == 0) {
            i5 |= composerK.I(navHostController) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            function13 = function1;
            i5 |= composerK.I(function13) ? 256 : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        } else {
            function13 = function1;
        }
        if ((i3 & 3072) == 0) {
            signInViewState2 = signInViewState;
            i5 |= composerK.Z(signInViewState2) ? 2048 : 1024;
        } else {
            signInViewState2 = signInViewState;
        }
        if ((i3 & 24576) == 0) {
            i5 |= composerK.Z(paddingValues) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        }
        if ((196608 & i3) == 0) {
            function14 = function12;
            i5 |= composerK.I(function14) ? 131072 : NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
        } else {
            function14 = function12;
        }
        int i7 = i5;
        if (composerK.r((74899 & i7) != 74898, i7 & 1)) {
            final Float f7 = i6 != 0 ? null : f4;
            if (ComposerKt.M()) {
                ComposerKt.U(-596179947, i7, -1, "cz.mobilesoft.coreblock.scene.more.signin.NavigationHost (SignInContent.kt:275)");
            }
            Modifier modifierH = PaddingKt.h(Modifier.b8, paddingValues);
            String route = (signInViewState2.h() != null ? NavItem.FinishRegistration : NavItem.SignInMethods).getRoute();
            boolean zI = ((i7 & 7168) == 2048) | ((i7 & 14) == 4) | ((i7 & 896) == 256) | composerK.I(navHostController) | ((458752 & i7) == 131072);
            Object objG = composerK.G();
            if (zI || objG == Composer.f23746a.a()) {
                final Function1 function15 = function13;
                final SignInViewState signInViewState3 = signInViewState2;
                final Function1 function16 = function14;
                Function1 function17 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.signin.m1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return SignInContentKt.D(signInViewState3, f7, function15, navHostController, function16, (NavGraphBuilder) obj);
                    }
                };
                f6 = f7;
                composerK.w(function17);
                objG = function17;
            } else {
                f6 = f7;
            }
            NavHostKt.v(navHostController, route, modifierH, null, null, null, null, null, null, null, (Function1) objG, composerK, (i7 >> 3) & 14, 0, 1016);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
            f5 = f6;
        } else {
            composerK.Q();
            f5 = f4;
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.signin.p0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SignInContentKt.Q(f5, navHostController, function1, signInViewState, paddingValues, function12, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit D(final SignInViewState signInViewState, final Float f3, final Function1 function1, final NavHostController navHostController, final Function1 function12, NavGraphBuilder NavHost) {
        Intrinsics.checkNotNullParameter(NavHost, "$this$NavHost");
        NavGraphBuilderKt.c(NavHost, NavItem.SignInMethods.getRoute(), null, null, null, null, null, null, null, ComposableLambdaKt.c(155476792, true, new Function4() { // from class: cz.mobilesoft.coreblock.scene.more.signin.s0
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return SignInContentKt.E(signInViewState, f3, function1, navHostController, function12, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        }), 254, null);
        NavGraphBuilderKt.c(NavHost, NavItem.SignInUpWithEmail.getRoute(), null, null, null, null, null, null, null, ComposableLambdaKt.c(2063704239, true, new Function4() { // from class: cz.mobilesoft.coreblock.scene.more.signin.t0
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return SignInContentKt.G(function1, signInViewState, navHostController, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        }), 254, null);
        NavGraphBuilderKt.c(NavHost, NavItem.FinishRegistration.getRoute(), null, null, null, null, null, null, null, ComposableLambdaKt.c(-415775568, true, new Function4() { // from class: cz.mobilesoft.coreblock.scene.more.signin.u0
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return SignInContentKt.J(function1, signInViewState, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        }), 254, null);
        NavGraphBuilderKt.c(NavHost, NavItem.NickName.getRoute(), null, null, null, null, null, null, null, ComposableLambdaKt.c(1399711921, true, new Function4() { // from class: cz.mobilesoft.coreblock.scene.more.signin.v0
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return SignInContentKt.K(signInViewState, function1, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        }), 254, null);
        NavGraphBuilderKt.c(NavHost, NavItem.ForgotPassword.getRoute(), null, null, null, null, null, null, null, ComposableLambdaKt.c(-1079767886, true, new Function4() { // from class: cz.mobilesoft.coreblock.scene.more.signin.w0
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return SignInContentKt.L(function1, signInViewState, navHostController, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        }), 254, null);
        NavGraphBuilderKt.c(NavHost, NavItem.SignInWelcome.getRoute(), null, null, null, null, null, null, null, ComposableLambdaKt.c(735719603, true, new Function4() { // from class: cz.mobilesoft.coreblock.scene.more.signin.x0
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return SignInContentKt.N(signInViewState, function1, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        }), 254, null);
        NavGraphBuilderKt.c(NavHost, NavItem.RestorePurchase.getRoute(), null, null, null, null, null, null, null, ComposableLambdaKt.c(-1743760204, true, new Function4() { // from class: cz.mobilesoft.coreblock.scene.more.signin.y0
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return SignInContentKt.O(function12, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        }), 254, null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit E(final SignInViewState signInViewState, Float f3, Function1 function1, final NavHostController navHostController, final Function1 function12, AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i3) {
        Pair pairA;
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        if (ComposerKt.M()) {
            ComposerKt.U(155476792, i3, -1, "cz.mobilesoft.coreblock.scene.more.signin.NavigationHost.<anonymous>.<anonymous>.<anonymous> (SignInContent.kt:282)");
        }
        if (signInViewState.p()) {
            composer.a0(-910655071);
            pairA = TuplesKt.a(StringResources_androidKt.b(R.string.Uo, composer, 0), StringResources_androidKt.b(R.string.Is, composer, 0));
            composer.U();
        } else if (signInViewState.v()) {
            composer.a0(-910650270);
            pairA = TuplesKt.a(StringResources_androidKt.b(R.string.Bj, composer, 0), "");
            composer.U();
        } else if (signInViewState.o()) {
            composer.a0(-910647410);
            pairA = TuplesKt.a(StringResources_androidKt.b(R.string.vx, composer, 0), StringResources_androidKt.b(R.string.mx, composer, 0));
            composer.U();
        } else if (signInViewState.t()) {
            composer.a0(-910642034);
            pairA = TuplesKt.a(StringResources_androidKt.b(R.string.vx, composer, 0), StringResources_androidKt.b(R.string.mx, composer, 0));
            composer.U();
        } else {
            composer.a0(-910637507);
            pairA = TuplesKt.a(StringResources_androidKt.b(R.string.nx, composer, 0), "");
            composer.U();
        }
        String str = (String) pairA.a();
        String str2 = (String) pairA.b();
        boolean zC = signInViewState.c();
        boolean zQ = signInViewState.q();
        boolean zR = signInViewState.r();
        boolean Z = composer.Z(signInViewState) | composer.I(navHostController) | composer.Z(function12);
        Object objG = composer.G();
        if (Z || objG == Composer.f23746a.a()) {
            objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.signin.e1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return SignInContentKt.F(signInViewState, navHostController, function12, ((Boolean) obj).booleanValue());
                }
            };
            composer.w(objG);
        }
        SignInScreenKt.h(f3, signInViewState, str, str2, zC, zQ, zR, function1, (Function1) objG, composer, 0, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit F(SignInViewState signInViewState, NavHostController navHostController, Function1 function1, boolean z2) {
        if (signInViewState.p() && z2) {
            NavController.P(navHostController, NavItem.RestorePurchase.getRoute(), null, null, 6, null);
        } else {
            function1.invoke(Boolean.valueOf(z2));
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit G(final Function1 function1, SignInViewState signInViewState, final NavHostController navHostController, AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        if (ComposerKt.M()) {
            ComposerKt.U(2063704239, i3, -1, "cz.mobilesoft.coreblock.scene.more.signin.NavigationHost.<anonymous>.<anonymous>.<anonymous> (SignInContent.kt:310)");
        }
        boolean Z = composer.Z(function1) | composer.I(navHostController);
        Object objG = composer.G();
        if (Z || objG == Composer.f23746a.a()) {
            objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.signin.c1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return SignInContentKt.H(function1, navHostController);
                }
            };
            composer.w(objG);
        }
        Function0 function0 = (Function0) objG;
        boolean Z2 = composer.Z(function1) | composer.I(navHostController);
        Object objG2 = composer.G();
        if (Z2 || objG2 == Composer.f23746a.a()) {
            objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.signin.d1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return SignInContentKt.I(function1, navHostController);
                }
            };
            composer.w(objG2);
        }
        SignInUpWithEmailScreenKt.W(function1, signInViewState, function0, (Function0) objG2, composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit H(Function1 function1, NavHostController navHostController) {
        function1.invoke(new SignInViewEvent.ClearEmailAndPassword(true));
        navHostController.Q();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit I(Function1 function1, NavHostController navHostController) {
        function1.invoke(new SignInViewEvent.ClearEmailAndPassword(false));
        NavController.P(navHostController, NavItem.ForgotPassword.getRoute(), null, null, 6, null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit J(Function1 function1, SignInViewState signInViewState, AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        if (ComposerKt.M()) {
            ComposerKt.U(-415775568, i3, -1, "cz.mobilesoft.coreblock.scene.more.signin.NavigationHost.<anonymous>.<anonymous>.<anonymous> (SignInContent.kt:325)");
        }
        FinishRegistrationPasswordScreenKt.l(function1, signInViewState, composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit K(SignInViewState signInViewState, Function1 function1, AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        if (ComposerKt.M()) {
            ComposerKt.U(1399711921, i3, -1, "cz.mobilesoft.coreblock.scene.more.signin.NavigationHost.<anonymous>.<anonymous>.<anonymous> (SignInContent.kt:332)");
        }
        NickNameScreenKt.i(signInViewState, function1, composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit L(final Function1 function1, SignInViewState signInViewState, final NavHostController navHostController, AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        if (ComposerKt.M()) {
            ComposerKt.U(-1079767886, i3, -1, "cz.mobilesoft.coreblock.scene.more.signin.NavigationHost.<anonymous>.<anonymous>.<anonymous> (SignInContent.kt:336)");
        }
        boolean Z = composer.Z(function1) | composer.I(navHostController);
        Object objG = composer.G();
        if (Z || objG == Composer.f23746a.a()) {
            objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.signin.a1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return SignInContentKt.M(function1, navHostController);
                }
            };
            composer.w(objG);
        }
        ForgotPasswordScreenKt.v(function1, signInViewState, (Function0) objG, composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit M(Function1 function1, NavHostController navHostController) {
        function1.invoke(new SignInViewEvent.ClearEmailAndPassword(true));
        navHostController.R();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit N(SignInViewState signInViewState, Function1 function1, AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        if (ComposerKt.M()) {
            ComposerKt.U(735719603, i3, -1, "cz.mobilesoft.coreblock.scene.more.signin.NavigationHost.<anonymous>.<anonymous>.<anonymous> (SignInContent.kt:346)");
        }
        SignInWelcomeScreenKt.f(signInViewState.l(), signInViewState.v(), function1, composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit O(final Function1 function1, AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        if (ComposerKt.M()) {
            ComposerKt.U(-1743760204, i3, -1, "cz.mobilesoft.coreblock.scene.more.signin.NavigationHost.<anonymous>.<anonymous>.<anonymous> (SignInContent.kt:354)");
        }
        boolean Z = composer.Z(function1);
        Object objG = composer.G();
        if (Z || objG == Composer.f23746a.a()) {
            objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.signin.b1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return SignInContentKt.P(function1);
                }
            };
            composer.w(objG);
        }
        RestorePurchaseScreenKt.j((Function0) objG, composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit P(Function1 function1) {
        function1.invoke(Boolean.TRUE);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Q(Float f3, NavHostController navHostController, Function1 function1, SignInViewState signInViewState, PaddingValues paddingValues, Function1 function12, int i3, int i4, Composer composer, int i5) {
        C(f3, navHostController, function1, signInViewState, paddingValues, function12, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit S() {
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ParametersHolder T(SignInConfig signInConfig) {
        return ParametersHolderKt.b(signInConfig);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult U(final CallbackManager callbackManager, final Function1 function1, DisposableEffectScope DisposableEffect) {
        Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
        LoginManager.Companion.getInstance().registerCallback(callbackManager, new FacebookCallback<LoginResult>() { // from class: cz.mobilesoft.coreblock.scene.more.signin.SignInContentKt$SignInContent$6$1$1
            @Override // com.facebook.FacebookCallback
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(LoginResult result) {
                Intrinsics.checkNotNullParameter(result, "result");
                function1.invoke(new SignInViewEvent.OnFacebookSignInResult(result));
            }

            @Override // com.facebook.FacebookCallback
            public void onCancel() {
                function1.invoke(SignInViewEvent.OnFacebookSignInCancel.f110423a);
            }

            @Override // com.facebook.FacebookCallback
            public void onError(FacebookException error) {
                Intrinsics.checkNotNullParameter(error, "error");
                function1.invoke(new SignInViewEvent.OnFacebookSignInError(error));
            }
        });
        return new DisposableEffectResult() { // from class: cz.mobilesoft.coreblock.scene.more.signin.SignInContentKt$SignInContent$lambda$10$0$$inlined$onDispose$1
            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
                LoginManager.Companion.getInstance().unregisterCallback(callbackManager);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit V(Float f3, SignInConfig signInConfig, CallbackManager callbackManager, Function1 function1, Function0 function0, int i3, int i4, Composer composer, int i5) {
        R(f3, signInConfig, callbackManager, function1, function0, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit W(Function1 function1, NavHostController navHostController, CoroutineScope coroutineScope, ScaffoldState scaffoldState, String str, ActivityResult result) {
        Intrinsics.checkNotNullParameter(result, "result");
        if (result.d() == -1) {
            Intent intentC = result.c();
            String stringExtra = intentC != null ? intentC.getStringExtra("APPLE_AUTHORIZATION_CODE") : null;
            if (stringExtra != null) {
                function1.invoke(new SignInViewEvent.OnAppleSignInResult(stringExtra));
            } else {
                navHostController.R();
                BuildersKt__Builders_commonKt.d(coroutineScope, null, null, new SignInContentKt$SignInContent$appleSignInLauncher$1$1$2$1(scaffoldState, str, null), 3, null);
            }
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit X(MutableState mutableState, Context context, ManagedActivityResultLauncher managedActivityResultLauncher) {
        if (Intrinsics.areEqual(((Pair) mutableState.getValue()).e(), context.getString(R.string.tf))) {
            managedActivityResultLauncher.b(new Intent(context, (Class<?>) AppleSignInActivity.class));
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Y(Function1 function1) {
        function1.invoke(SignInViewEvent.OnAlreadyHaveAccountClicked.f110419a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Z(MutableState mutableState) {
        mutableState.setValue(Boolean.FALSE);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit a0(Float f3, NavHostController navHostController, Function1 function1, SignInViewState signInViewState, Function1 function12, PaddingValues it, Composer composer, int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(it, "it");
        if ((i3 & 6) == 0) {
            i4 = i3 | (composer.Z(it) ? 4 : 2);
        } else {
            i4 = i3;
        }
        if (composer.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(464845411, i4, -1, "cz.mobilesoft.coreblock.scene.more.signin.SignInContent.<anonymous> (SignInContent.kt:133)");
            }
            Modifier.Companion companion = Modifier.b8;
            MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.h(), Alignment.f25072a.k(), composer, 0);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, companion);
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
            C(f3, navHostController, function1, signInViewState, it, function12, composer, (i4 << 12) & 57344, 0);
            composer.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    public static final void z(final Context context, final NavHostController navController, final SignInViewModel viewModel, final SignInViewState viewState, final ScaffoldState scaffoldState, final MutableState infoDialogState, final MutableState showInfoDialog, final MutableState showConfirmDialog, final CoroutineScope scope, final Function1 onScreenClose, final Function0 onSkipOnboardingClick, Composer composer, final int i3, final int i4) {
        int i5;
        int i6;
        Composer composer2;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(navController, "navController");
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(viewState, "viewState");
        Intrinsics.checkNotNullParameter(scaffoldState, "scaffoldState");
        Intrinsics.checkNotNullParameter(infoDialogState, "infoDialogState");
        Intrinsics.checkNotNullParameter(showInfoDialog, "showInfoDialog");
        Intrinsics.checkNotNullParameter(showConfirmDialog, "showConfirmDialog");
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(onScreenClose, "onScreenClose");
        Intrinsics.checkNotNullParameter(onSkipOnboardingClick, "onSkipOnboardingClick");
        Composer composerK = composer.k(-1794869495);
        if ((i3 & 6) == 0) {
            i5 = (composerK.I(context) ? 4 : 2) | i3;
        } else {
            i5 = i3;
        }
        if ((i3 & 48) == 0) {
            i5 |= composerK.I(navController) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i5 |= composerK.I(viewModel) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            i5 |= composerK.Z(viewState) ? 2048 : 1024;
        }
        if ((i3 & 24576) == 0) {
            i5 |= composerK.Z(scaffoldState) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        }
        if ((196608 & i3) == 0) {
            i5 |= composerK.Z(infoDialogState) ? 131072 : NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
        }
        if ((1572864 & i3) == 0) {
            i5 |= composerK.Z(showInfoDialog) ? 1048576 : 524288;
        }
        if ((12582912 & i3) == 0) {
            i5 |= composerK.Z(showConfirmDialog) ? 8388608 : 4194304;
        }
        if ((100663296 & i3) == 0) {
            i5 |= composerK.I(scope) ? 67108864 : 33554432;
        }
        if ((805306368 & i3) == 0) {
            i5 |= composerK.I(onScreenClose) ? 536870912 : 268435456;
        }
        int i7 = i5;
        if ((i4 & 6) == 0) {
            i6 = i4 | (composerK.I(onSkipOnboardingClick) ? 4 : 2);
        } else {
            i6 = i4;
        }
        if (composerK.r(((i7 & 306783379) == 306783378 && (i6 & 3) == 2) ? false : true, i7 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1794869495, i7, i6, "cz.mobilesoft.coreblock.scene.more.signin.CommandProcessor (SignInContent.kt:198)");
            }
            ActivityResultContracts.StartActivityForResult startActivityForResult = new ActivityResultContracts.StartActivityForResult();
            int i8 = i7 & 7168;
            int i9 = i7 & 1879048192;
            int i10 = i6;
            boolean zI = (i9 == 536870912) | (i8 == 2048) | composerK.I(navController);
            Object objG = composerK.G();
            if (zI || objG == Composer.f23746a.a()) {
                objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.signin.q0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return SignInContentKt.A(viewState, navController, onScreenClose, (ActivityResult) obj);
                    }
                };
                composerK.w(objG);
            }
            ManagedActivityResultLauncher managedActivityResultLauncherA = ActivityResultRegistryKt.a(startActivityForResult, (Function1) objG, composerK, 0);
            boolean zI2 = (i9 == 536870912) | (i8 == 2048) | composerK.I(navController) | composerK.I(managedActivityResultLauncherA) | composerK.I(context) | composerK.I(scope) | ((i7 & 57344) == 16384) | ((i7 & 458752) == 131072) | ((i7 & 29360128) == 8388608) | ((i7 & 3670016) == 1048576) | ((i10 & 14) == 4);
            Object objG2 = composerK.G();
            if (zI2 || objG2 == Composer.f23746a.a()) {
                SignInContentKt$CommandProcessor$1$1 signInContentKt$CommandProcessor$1$1 = new SignInContentKt$CommandProcessor$1$1(navController, viewState, managedActivityResultLauncherA, context, onScreenClose, scope, infoDialogState, showConfirmDialog, showInfoDialog, onSkipOnboardingClick, scaffoldState, null);
                composerK.w(signInContentKt$CommandProcessor$1$1);
                objG2 = signInContentKt$CommandProcessor$1$1;
            }
            composer2 = composerK;
            FlowExtKt.g(viewModel, null, (Function2) objG2, composer2, (i7 >> 6) & 14, 2);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer2 = composerK;
            composer2.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.signin.r0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SignInContentKt.B(context, navController, viewModel, viewState, scaffoldState, infoDialogState, showInfoDialog, showConfirmDialog, scope, onScreenClose, onSkipOnboardingClick, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:134:0x03c3  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x03ce  */
    /* JADX WARN: Removed duplicated region for block: B:139:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0098  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void R(java.lang.Float r42, final cz.mobilesoft.coreblock.scene.more.signin.SignInConfig r43, final com.facebook.CallbackManager r44, final kotlin.jvm.functions.Function1 r45, kotlin.jvm.functions.Function0 r46, androidx.compose.runtime.Composer r47, final int r48, final int r49) {
        /*
            Method dump skipped, instruction units count: 991
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.more.signin.SignInContentKt.R(java.lang.Float, cz.mobilesoft.coreblock.scene.more.signin.SignInConfig, com.facebook.CallbackManager, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int):void");
    }
}
