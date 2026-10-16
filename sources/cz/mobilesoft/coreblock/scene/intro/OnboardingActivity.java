package cz.mobilesoft.coreblock.scene.intro;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.activity.ComponentActivity;
import androidx.compose.animation.AnimatedContentScope;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
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
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.navigation.NamedNavArgumentKt;
import androidx.navigation.NavArgumentBuilder;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavController;
import androidx.navigation.NavGraphBuilder;
import androidx.navigation.NavHostController;
import androidx.navigation.NavType;
import androidx.navigation.Navigator;
import androidx.navigation.compose.NavGraphBuilderKt;
import androidx.navigation.compose.NavHostControllerKt;
import androidx.navigation.compose.NavHostKt;
import com.facebook.CallbackManager;
import com.facebook.internal.Utility;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.base.activity.BaseComposeActivity;
import cz.mobilesoft.coreblock.enums.SignInEntryPoint;
import cz.mobilesoft.coreblock.scene.dashboard.DashboardActivity;
import cz.mobilesoft.coreblock.scene.intro.OnboardingHelpItem;
import cz.mobilesoft.coreblock.scene.intro.OnboardingViewEvent;
import cz.mobilesoft.coreblock.scene.intro.question.Explanation1ScreenKt;
import cz.mobilesoft.coreblock.scene.intro.question.Explanation2ScreenKt;
import cz.mobilesoft.coreblock.scene.intro.question.OtherAnswerScreenKt;
import cz.mobilesoft.coreblock.scene.intro.question.Question1ScreenKt;
import cz.mobilesoft.coreblock.scene.intro.quickblock.QuickBlockAboutScreenKt;
import cz.mobilesoft.coreblock.scene.intro.reviews.ReviewsScreenKt;
import cz.mobilesoft.coreblock.scene.intro.stats.StatsExplanation1ScreenKt;
import cz.mobilesoft.coreblock.scene.intro.stats.StatsExplanation2ScreenKt;
import cz.mobilesoft.coreblock.scene.intro.stats.StatsExplanation3ScreenKt;
import cz.mobilesoft.coreblock.scene.intro.stats.StatsQuestion1ScreenKt;
import cz.mobilesoft.coreblock.scene.intro.stats.StatsQuestion2ScreenKt;
import cz.mobilesoft.coreblock.scene.more.signin.SignInConfig;
import cz.mobilesoft.coreblock.scene.more.signin.SignInContentKt;
import cz.mobilesoft.coreblock.scene.onboarding.statistics.IntroReportScreenKt;
import cz.mobilesoft.coreblock.scene.permission.privacy.PrivacyExplanationScreenKt;
import cz.mobilesoft.coreblock.util.analytics.AnswersHelper;
import cz.mobilesoft.coreblock.util.compose.FlowExtKt;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import org.koin.androidx.compose.ViewModelComposeExtKt;
import org.koin.androidx.viewmodel.GetViewModelKt;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class OnboardingActivity extends BaseComposeActivity {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Lazy f104486f = LazyKt.b(new Function0() { // from class: cz.mobilesoft.coreblock.scene.intro.k
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return OnboardingActivity.a2();
        }
    });

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f104487g;

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit A1(Function1 function1) {
        AnswersHelper.f128199a.U2();
        function1.invoke(OnboardingViewEvent.OnSetUpSkipped.f104521a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit B1(final Function1 function1, AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        if (ComposerKt.M()) {
            ComposerKt.U(619955884, i3, -1, "cz.mobilesoft.coreblock.scene.intro.OnboardingActivity.NavigationHost.<anonymous>.<anonymous>.<anonymous> (OnboardingActivity.kt:343)");
        }
        boolean Z = composer.Z(function1);
        Object objG = composer.G();
        if (Z || objG == Composer.f23746a.a()) {
            objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.intro.w0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return OnboardingActivity.C1(function1);
                }
            };
            composer.w(objG);
        }
        Function0 function0 = (Function0) objG;
        boolean Z2 = composer.Z(function1);
        Object objG2 = composer.G();
        if (Z2 || objG2 == Composer.f23746a.a()) {
            objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.intro.x0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return OnboardingActivity.D1(function1);
                }
            };
            composer.w(objG2);
        }
        QuickBlockAboutScreenKt.c(function0, (Function0) objG2, composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit C1(Function1 function1) {
        AnswersHelper.f128199a.v3();
        function1.invoke(OnboardingViewEvent.OnQuickBlockSetUpClicked.f104519a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit D1(Function1 function1) {
        AnswersHelper.f128199a.u3();
        function1.invoke(OnboardingViewEvent.OnQuickBlockSetUpSkipped.f104520a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit E1(final OnboardingActivity onboardingActivity, final NavHostController navHostController, final Function1 function1, final Context context, AnimatedContentScope composable, NavBackStackEntry backStackEntry, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(backStackEntry, "backStackEntry");
        if (ComposerKt.M()) {
            ComposerKt.U(1505972275, i3, -1, "cz.mobilesoft.coreblock.scene.intro.OnboardingActivity.NavigationHost.<anonymous>.<anonymous>.<anonymous> (OnboardingActivity.kt:169)");
        }
        Bundle bundleB = backStackEntry.b();
        boolean z2 = bundleB != null ? bundleB.getBoolean("alreadyAMember") : false;
        CallbackManager callbackManagerB2 = onboardingActivity.b2();
        SignInConfig signInConfig = new SignInConfig(SignInEntryPoint.ONBOARDING, null, z2, !z2, false, false, false, false, false, false, null, 2034, null);
        boolean zI = composer.I(navHostController);
        Object objG = composer.G();
        if (zI || objG == Composer.f23746a.a()) {
            objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.intro.u0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return OnboardingActivity.F1(navHostController, ((Boolean) obj).booleanValue());
                }
            };
            composer.w(objG);
        }
        Function1 function12 = (Function1) objG;
        boolean Z = composer.Z(function1) | composer.I(context) | composer.I(onboardingActivity);
        Object objG2 = composer.G();
        if (Z || objG2 == Composer.f23746a.a()) {
            objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.intro.v0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return OnboardingActivity.G1(function1, context, onboardingActivity);
                }
            };
            composer.w(objG2);
        }
        SignInContentKt.R(null, signInConfig, callbackManagerB2, function12, (Function0) objG2, composer, 0, 1);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit F1(NavHostController navHostController, boolean z2) {
        if (z2) {
            NavController.P(navHostController, OnboardingNavItem.Question1.getRoute(), null, null, 6, null);
        } else {
            navHostController.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit G1(Function1 function1, Context context, OnboardingActivity onboardingActivity) {
        function1.invoke(OnboardingViewEvent.OnAlreadyAMemberLoggedIn.f104514a);
        Intent intentC = DashboardActivity.Companion.c(DashboardActivity.f99133o, context, null, null, 6, null);
        intentC.setFlags(268468224);
        onboardingActivity.startActivity(intentC);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit H1(OnboardingViewState onboardingViewState, final Function1 function1, final NavHostController navHostController, AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        if (ComposerKt.M()) {
            ComposerKt.U(-2140767564, i3, -1, "cz.mobilesoft.coreblock.scene.intro.OnboardingActivity.NavigationHost.<anonymous>.<anonymous>.<anonymous> (OnboardingActivity.kt:195)");
        }
        boolean Z = composer.Z(function1);
        Object objG = composer.G();
        if (Z || objG == Composer.f23746a.a()) {
            objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.intro.i0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return OnboardingActivity.I1(function1, (OnboardingHelpItem) obj);
                }
            };
            composer.w(objG);
        }
        Function1 function12 = (Function1) objG;
        boolean zI = composer.I(navHostController);
        Object objG2 = composer.G();
        if (zI || objG2 == Composer.f23746a.a()) {
            objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.intro.j0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return OnboardingActivity.J1(navHostController);
                }
            };
            composer.w(objG2);
        }
        Function0 function0 = (Function0) objG2;
        boolean Z2 = composer.Z(function1);
        Object objG3 = composer.G();
        if (Z2 || objG3 == Composer.f23746a.a()) {
            objG3 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.intro.k0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return OnboardingActivity.K1(function1);
                }
            };
            composer.w(objG3);
        }
        Question1ScreenKt.m(onboardingViewState, function12, function0, (Function0) objG3, composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit I1(Function1 function1, OnboardingHelpItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        AnswersHelper.f128199a.Z2(item);
        function1.invoke(new OnboardingViewEvent.OnQuestion1Answer(item));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit J1(NavHostController navHostController) {
        AnswersHelper.f128199a.a3();
        NavController.P(navHostController, OnboardingNavItem.FeaturesOverview.getRoute(), null, null, 6, null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit K1(Function1 function1) {
        function1.invoke(OnboardingViewEvent.OnMultiSelectContinueClicked.f104516a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit L1(HelpItemWithExplanation helpItemWithExplanation, final NavHostController navHostController, AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        if (ComposerKt.M()) {
            ComposerKt.U(1500130590, i3, -1, "cz.mobilesoft.coreblock.scene.intro.OnboardingActivity.NavigationHost.<anonymous>.<anonymous>.<anonymous> (OnboardingActivity.kt:213)");
        }
        boolean zI = composer.I(navHostController);
        Object objG = composer.G();
        if (zI || objG == Composer.f23746a.a()) {
            objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.intro.a0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return OnboardingActivity.M1(navHostController);
                }
            };
            composer.w(objG);
        }
        Explanation1ScreenKt.g(helpItemWithExplanation, (Function0) objG, composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit M1(NavHostController navHostController) {
        AnswersHelper.f128199a.T2();
        NavController.P(navHostController, OnboardingNavItem.Explanation2.getRoute(), null, null, 6, null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit N1(final OnboardingViewState onboardingViewState, final NavHostController navHostController, AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        if (ComposerKt.M()) {
            ComposerKt.U(-1492540107, i3, -1, "cz.mobilesoft.coreblock.scene.intro.OnboardingActivity.NavigationHost.<anonymous>.<anonymous>.<anonymous> (OnboardingActivity.kt:224)");
        }
        boolean Z = composer.Z(onboardingViewState) | composer.I(navHostController);
        Object objG = composer.G();
        if (Z || objG == Composer.f23746a.a()) {
            objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.intro.e0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return OnboardingActivity.O1(onboardingViewState, navHostController, (String) obj);
                }
            };
            composer.w(objG);
        }
        OtherAnswerScreenKt.g((Function1) objG, composer, 0, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0068  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final kotlin.Unit O1(cz.mobilesoft.coreblock.scene.intro.OnboardingViewState r6, androidx.navigation.NavHostController r7, java.lang.String r8) {
        /*
            java.lang.String r0 = "answer"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            cz.mobilesoft.coreblock.util.analytics.AnswersHelper r0 = cz.mobilesoft.coreblock.util.analytics.AnswersHelper.f128199a
            r0.i3(r8)
            kotlinx.collections.immutable.ImmutableSet r6 = r6.e()
            cz.mobilesoft.coreblock.scene.intro.OnboardingHelpItem$Other r8 = cz.mobilesoft.coreblock.scene.intro.OnboardingHelpItem.Other.f104503g
            java.util.Set r6 = kotlin.collections.SetsKt.minus(r6, r8)
            r8 = r6
            java.util.Collection r8 = (java.util.Collection) r8
            boolean r8 = r8.isEmpty()
            r0 = 0
            if (r8 != 0) goto L1f
            goto L20
        L1f:
            r6 = r0
        L20:
            if (r6 == 0) goto L68
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            java.util.Iterator r6 = r6.iterator()
            boolean r8 = r6.hasNext()
            if (r8 != 0) goto L2f
            goto L56
        L2f:
            java.lang.Object r0 = r6.next()
            boolean r8 = r6.hasNext()
            if (r8 != 0) goto L3a
            goto L56
        L3a:
            r8 = r0
            cz.mobilesoft.coreblock.scene.intro.OnboardingHelpItem r8 = (cz.mobilesoft.coreblock.scene.intro.OnboardingHelpItem) r8
            int r8 = r8.d()
        L41:
            java.lang.Object r1 = r6.next()
            r2 = r1
            cz.mobilesoft.coreblock.scene.intro.OnboardingHelpItem r2 = (cz.mobilesoft.coreblock.scene.intro.OnboardingHelpItem) r2
            int r2 = r2.d()
            if (r8 <= r2) goto L50
            r0 = r1
            r8 = r2
        L50:
            boolean r1 = r6.hasNext()
            if (r1 != 0) goto L41
        L56:
            cz.mobilesoft.coreblock.scene.intro.OnboardingHelpItem r0 = (cz.mobilesoft.coreblock.scene.intro.OnboardingHelpItem) r0
            if (r0 == 0) goto L68
            cz.mobilesoft.coreblock.scene.intro.OnboardingNavItem r6 = r0.c()
            if (r6 == 0) goto L68
            java.lang.String r6 = r6.getRoute()
            if (r6 == 0) goto L68
        L66:
            r1 = r6
            goto L6f
        L68:
            cz.mobilesoft.coreblock.scene.intro.OnboardingNavItem r6 = cz.mobilesoft.coreblock.scene.intro.OnboardingNavItem.Reviews
            java.lang.String r6 = r6.getRoute()
            goto L66
        L6f:
            r4 = 6
            r5 = 0
            r2 = 0
            r3 = 0
            r0 = r7
            androidx.navigation.NavController.P(r0, r1, r2, r3, r4, r5)
            kotlin.Unit r6 = kotlin.Unit.f139807a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.intro.OnboardingActivity.O1(cz.mobilesoft.coreblock.scene.intro.OnboardingViewState, androidx.navigation.NavHostController, java.lang.String):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit P1(final NavHostController navHostController, AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        if (ComposerKt.M()) {
            ComposerKt.U(-844312650, i3, -1, "cz.mobilesoft.coreblock.scene.intro.OnboardingActivity.NavigationHost.<anonymous>.<anonymous>.<anonymous> (OnboardingActivity.kt:239)");
        }
        boolean zI = composer.I(navHostController);
        Object objG = composer.G();
        if (zI || objG == Composer.f23746a.a()) {
            objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.intro.h0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return OnboardingActivity.Q1(navHostController);
                }
            };
            composer.w(objG);
        }
        Explanation2ScreenKt.e((Function0) objG, composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Q1(NavHostController navHostController) {
        AnswersHelper.f128199a.f3();
        NavController.P(navHostController, OnboardingNavItem.Reviews.getRoute(), null, null, 6, null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit R1(OnboardingViewState onboardingViewState, final NavHostController navHostController, AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i3) {
        Object obj;
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        if (ComposerKt.M()) {
            ComposerKt.U(-196085193, i3, -1, "cz.mobilesoft.coreblock.scene.intro.OnboardingActivity.NavigationHost.<anonymous>.<anonymous>.<anonymous> (OnboardingActivity.kt:248)");
        }
        Iterator<E> it2 = onboardingViewState.e().iterator();
        if (it2.hasNext()) {
            Object next = it2.next();
            if (it2.hasNext()) {
                int iD = ((OnboardingHelpItem) next).d();
                do {
                    Object next2 = it2.next();
                    int iD2 = ((OnboardingHelpItem) next2).d();
                    if (iD > iD2) {
                        next = next2;
                        iD = iD2;
                    }
                } while (it2.hasNext());
            }
            obj = next;
        } else {
            obj = null;
        }
        OnboardingHelpItem onboardingHelpItem = (OnboardingHelpItem) obj;
        if (onboardingHelpItem == null) {
            onboardingHelpItem = OnboardingHelpItem.Other.f104503g;
        }
        boolean zI = composer.I(navHostController);
        Object objG = composer.G();
        if (zI || objG == Composer.f23746a.a()) {
            objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.intro.f0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return OnboardingActivity.S1(navHostController);
                }
            };
            composer.w(objG);
        }
        ReviewsScreenKt.l(onboardingHelpItem, (Function0) objG, composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit S1(NavHostController navHostController) {
        AnswersHelper.f128199a.y3();
        NavController.P(navHostController, OnboardingNavItem.StatsQuestion1.getRoute(), null, null, 6, null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit T1(final Function1 function1, AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        if (ComposerKt.M()) {
            ComposerKt.U(452142264, i3, -1, "cz.mobilesoft.coreblock.scene.intro.OnboardingActivity.NavigationHost.<anonymous>.<anonymous>.<anonymous> (OnboardingActivity.kt:260)");
        }
        boolean Z = composer.Z(function1);
        Object objG = composer.G();
        if (Z || objG == Composer.f23746a.a()) {
            objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.intro.m0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return OnboardingActivity.U1(function1, ((Integer) obj).intValue());
                }
            };
            composer.w(objG);
        }
        StatsQuestion1ScreenKt.c((Function1) objG, composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit U1(Function1 function1, int i3) {
        AnswersHelper.f128199a.b3(i3);
        function1.invoke(new OnboardingViewEvent.OnStatsQuestion1Answer(i3));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit V1(final Function1 function1, AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        if (ComposerKt.M()) {
            ComposerKt.U(1100369721, i3, -1, "cz.mobilesoft.coreblock.scene.intro.OnboardingActivity.NavigationHost.<anonymous>.<anonymous>.<anonymous> (OnboardingActivity.kt:269)");
        }
        boolean Z = composer.Z(function1);
        Object objG = composer.G();
        if (Z || objG == Composer.f23746a.a()) {
            objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.intro.o0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return OnboardingActivity.W1(function1, ((Integer) obj).intValue());
                }
            };
            composer.w(objG);
        }
        StatsQuestion2ScreenKt.c((Function1) objG, composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit W1(Function1 function1, int i3) {
        AnswersHelper.f128199a.g3(i3);
        function1.invoke(new OnboardingViewEvent.OnStatsQuestion2Answer(i3));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit X1(OnboardingActivity onboardingActivity, OnboardingViewState onboardingViewState, NavHostController navHostController, PaddingValues paddingValues, Function1 function1, int i3, Composer composer, int i4) {
        onboardingActivity.h1(onboardingViewState, navHostController, paddingValues, function1, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Y1(OnboardingActivity onboardingActivity, OnboardingViewState onboardingViewState, NavHostController navHostController, Function1 function1, PaddingValues it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(it, "it");
        if ((i3 & 6) == 0) {
            i3 |= composer.Z(it) ? 4 : 2;
        }
        if (composer.r((i3 & 19) != 18, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-188593776, i3, -1, "cz.mobilesoft.coreblock.scene.intro.OnboardingActivity.RootCompose.<anonymous> (OnboardingActivity.kt:71)");
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
            onboardingActivity.h1(onboardingViewState, navHostController, it, function1, composer, (i3 << 6) & 896);
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
    public static final Unit Z1(OnboardingActivity onboardingActivity, PaddingValues paddingValues, int i3, Composer composer, int i4) {
        onboardingActivity.c0(paddingValues, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CallbackManager a2() {
        return CallbackManager.Factory.create();
    }

    private final CallbackManager b2() {
        return (CallbackManager) this.f104486f.getValue();
    }

    private final void f1(final NavHostController navHostController, OnboardingViewModel onboardingViewModel, Composer composer, final int i3) {
        int i4;
        final OnboardingViewModel onboardingViewModel2;
        Composer composerK = composer.k(1906099146);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(navHostController) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(onboardingViewModel) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.I(this) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if (composerK.r((i4 & 147) != 146, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1906099146, i4, -1, "cz.mobilesoft.coreblock.scene.intro.OnboardingActivity.CommandProcessor (OnboardingActivity.kt:92)");
            }
            boolean zI = composerK.I(navHostController) | composerK.I(this);
            Object objG = composerK.G();
            if (zI || objG == Composer.f23746a.a()) {
                objG = new OnboardingActivity$CommandProcessor$1$1(navHostController, this, null);
                composerK.w(objG);
            }
            onboardingViewModel2 = onboardingViewModel;
            FlowExtKt.g(onboardingViewModel2, null, (Function2) objG, composerK, (i4 >> 3) & 14, 2);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            onboardingViewModel2 = onboardingViewModel;
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.intro.r0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return OnboardingActivity.g1(this.f104796a, navHostController, onboardingViewModel2, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g1(OnboardingActivity onboardingActivity, NavHostController navHostController, OnboardingViewModel onboardingViewModel, int i3, Composer composer, int i4) {
        onboardingActivity.f1(navHostController, onboardingViewModel, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    private final void h1(final OnboardingViewState onboardingViewState, final NavHostController navHostController, final PaddingValues paddingValues, final Function1 function1, Composer composer, final int i3) {
        OnboardingViewState onboardingViewState2;
        int i4;
        Function1 function12;
        Composer composerK = composer.k(-412038503);
        if ((i3 & 6) == 0) {
            onboardingViewState2 = onboardingViewState;
            i4 = (composerK.Z(onboardingViewState2) ? 4 : 2) | i3;
        } else {
            onboardingViewState2 = onboardingViewState;
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(navHostController) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.Z(paddingValues) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            function12 = function1;
            i4 |= composerK.I(function12) ? 2048 : 1024;
        } else {
            function12 = function1;
        }
        if ((i3 & 24576) == 0) {
            i4 |= composerK.I(this) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        }
        int i5 = i4;
        if (composerK.r((i5 & 9363) != 9362, i5 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-412038503, i5, -1, "cz.mobilesoft.coreblock.scene.intro.OnboardingActivity.NavigationHost (OnboardingActivity.kt:132)");
            }
            final Context context = (Context) composerK.q(AndroidCompositionLocals_androidKt.g());
            Modifier modifierH = PaddingKt.h(Modifier.b8, paddingValues);
            String route = OnboardingNavItem.Welcome.getRoute();
            boolean zI = ((i5 & 14) == 4) | composerK.I(navHostController) | ((i5 & 7168) == 2048) | composerK.I(this) | composerK.I(context);
            Object objG = composerK.G();
            if (zI || objG == Composer.f23746a.a()) {
                final OnboardingViewState onboardingViewState3 = onboardingViewState2;
                final Function1 function13 = function12;
                Function1 function14 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.intro.y0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return OnboardingActivity.i1(onboardingViewState3, navHostController, function13, this, context, (NavGraphBuilder) obj);
                    }
                };
                composerK.w(function14);
                objG = function14;
            }
            NavHostKt.v(navHostController, route, modifierH, null, null, null, null, null, null, null, (Function1) objG, composerK, (i5 >> 3) & 14, 0, 1016);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.intro.z0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return OnboardingActivity.X1(this.f105316a, onboardingViewState, navHostController, paddingValues, function1, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i1(final OnboardingViewState onboardingViewState, final NavHostController navHostController, final Function1 function1, final OnboardingActivity onboardingActivity, final Context context, NavGraphBuilder NavHost) {
        Intrinsics.checkNotNullParameter(NavHost, "$this$NavHost");
        NavGraphBuilderKt.c(NavHost, OnboardingNavItem.Welcome.getRoute(), null, null, null, null, null, null, null, ComposableLambdaKt.c(-2079224516, true, new Function4() { // from class: cz.mobilesoft.coreblock.scene.intro.a1
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return OnboardingActivity.j1(onboardingViewState, navHostController, function1, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        }), 254, null);
        NavGraphBuilderKt.c(NavHost, OnboardingNavItem.SignIn.getRoute() + "?alreadyAMember={alreadyAMember}", CollectionsKt.listOf(NamedNavArgumentKt.a("alreadyAMember", new Function1() { // from class: cz.mobilesoft.coreblock.scene.intro.p
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return OnboardingActivity.n1((NavArgumentBuilder) obj);
            }
        })), null, null, null, null, null, null, ComposableLambdaKt.c(1505972275, true, new Function4() { // from class: cz.mobilesoft.coreblock.scene.intro.q
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return OnboardingActivity.E1(this.f104663a, navHostController, function1, context, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        }), 252, null);
        NavGraphBuilderKt.c(NavHost, OnboardingNavItem.Question1.getRoute(), null, null, null, null, null, null, null, ComposableLambdaKt.c(-2140767564, true, new Function4() { // from class: cz.mobilesoft.coreblock.scene.intro.r
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return OnboardingActivity.H1(onboardingViewState, function1, navHostController, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        }), 254, null);
        for (final HelpItemWithExplanation helpItemWithExplanation : HelpItemWithExplanation.f104475h.a()) {
            NavGraphBuilderKt.c(NavHost, helpItemWithExplanation.c().getRoute(), null, null, null, null, null, null, null, ComposableLambdaKt.c(1500130590, true, new Function4() { // from class: cz.mobilesoft.coreblock.scene.intro.s
                @Override // kotlin.jvm.functions.Function4
                public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                    return OnboardingActivity.L1(helpItemWithExplanation, navHostController, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                }
            }), 254, null);
        }
        NavGraphBuilderKt.c(NavHost, OnboardingNavItem.Explanation1Other.getRoute(), null, null, null, null, null, null, null, ComposableLambdaKt.c(-1492540107, true, new Function4() { // from class: cz.mobilesoft.coreblock.scene.intro.t
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return OnboardingActivity.N1(onboardingViewState, navHostController, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        }), 254, null);
        NavGraphBuilderKt.c(NavHost, OnboardingNavItem.Explanation2.getRoute(), null, null, null, null, null, null, null, ComposableLambdaKt.c(-844312650, true, new Function4() { // from class: cz.mobilesoft.coreblock.scene.intro.u
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return OnboardingActivity.P1(navHostController, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        }), 254, null);
        NavGraphBuilderKt.c(NavHost, OnboardingNavItem.Reviews.getRoute(), null, null, null, null, null, null, null, ComposableLambdaKt.c(-196085193, true, new Function4() { // from class: cz.mobilesoft.coreblock.scene.intro.w
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return OnboardingActivity.R1(onboardingViewState, navHostController, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        }), 254, null);
        NavGraphBuilderKt.c(NavHost, OnboardingNavItem.StatsQuestion1.getRoute(), null, null, null, null, null, null, null, ComposableLambdaKt.c(452142264, true, new Function4() { // from class: cz.mobilesoft.coreblock.scene.intro.x
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return OnboardingActivity.T1(function1, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        }), 254, null);
        NavGraphBuilderKt.c(NavHost, OnboardingNavItem.StatsQuestion2.getRoute(), null, null, null, null, null, null, null, ComposableLambdaKt.c(1100369721, true, new Function4() { // from class: cz.mobilesoft.coreblock.scene.intro.y
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return OnboardingActivity.V1(function1, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        }), 254, null);
        NavGraphBuilderKt.c(NavHost, OnboardingNavItem.PrivacyExplanation.getRoute(), null, null, null, null, null, null, null, ComposableLambdaKt.c(1748597178, true, new Function4() { // from class: cz.mobilesoft.coreblock.scene.intro.b1
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return OnboardingActivity.o1(function1, navHostController, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        }), 254, null);
        NavGraphBuilderKt.c(NavHost, OnboardingNavItem.StatsPermission.getRoute(), null, null, null, null, null, null, null, ComposableLambdaKt.c(-1898142661, true, new Function4() { // from class: cz.mobilesoft.coreblock.scene.intro.c1
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return OnboardingActivity.q1(navHostController, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        }), 254, null);
        NavGraphBuilderKt.c(NavHost, OnboardingNavItem.StatsReport.getRoute(), null, null, null, null, null, null, null, ComposableSingletons$OnboardingActivityKt.f104471a.b(), 254, null);
        NavGraphBuilderKt.c(NavHost, OnboardingNavItem.StatsExplanation1.getRoute(), null, null, null, null, null, null, null, ComposableLambdaKt.c(-1972953944, true, new Function4() { // from class: cz.mobilesoft.coreblock.scene.intro.d1
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return OnboardingActivity.s1(onboardingViewState, navHostController, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        }), 254, null);
        NavGraphBuilderKt.c(NavHost, OnboardingNavItem.StatsExplanation2.getRoute(), null, null, null, null, null, null, null, ComposableLambdaKt.c(-1324726487, true, new Function4() { // from class: cz.mobilesoft.coreblock.scene.intro.l
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return OnboardingActivity.u1(onboardingViewState, navHostController, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        }), 254, null);
        NavGraphBuilderKt.c(NavHost, OnboardingNavItem.StatsExplanation3.getRoute(), null, null, null, null, null, null, null, ComposableLambdaKt.c(-676499030, true, new Function4() { // from class: cz.mobilesoft.coreblock.scene.intro.m
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return OnboardingActivity.w1(navHostController, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        }), 254, null);
        NavGraphBuilderKt.c(NavHost, OnboardingNavItem.FeaturesOverview.getRoute(), null, null, null, null, null, null, null, ComposableLambdaKt.c(-28271573, true, new Function4() { // from class: cz.mobilesoft.coreblock.scene.intro.n
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return OnboardingActivity.y1(navHostController, function1, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        }), 254, null);
        NavGraphBuilderKt.c(NavHost, OnboardingNavItem.QuickBlockAbout.getRoute(), null, null, null, null, null, null, null, ComposableLambdaKt.c(619955884, true, new Function4() { // from class: cz.mobilesoft.coreblock.scene.intro.o
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return OnboardingActivity.B1(function1, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        }), 254, null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j1(final OnboardingViewState onboardingViewState, final NavHostController navHostController, final Function1 function1, AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        if (ComposerKt.M()) {
            ComposerKt.U(-2079224516, i3, -1, "cz.mobilesoft.coreblock.scene.intro.OnboardingActivity.NavigationHost.<anonymous>.<anonymous>.<anonymous> (OnboardingActivity.kt:141)");
        }
        boolean z2 = !onboardingViewState.h();
        boolean Z = composer.Z(onboardingViewState) | composer.I(navHostController);
        Object objG = composer.G();
        if (Z || objG == Composer.f23746a.a()) {
            objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.intro.p0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return OnboardingActivity.k1(onboardingViewState, navHostController);
                }
            };
            composer.w(objG);
        }
        Function0 function0 = (Function0) objG;
        boolean Z2 = composer.Z(function1);
        Object objG2 = composer.G();
        if (Z2 || objG2 == Composer.f23746a.a()) {
            objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.intro.q0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return OnboardingActivity.l1(function1);
                }
            };
            composer.w(objG2);
        }
        Function0 function02 = (Function0) objG2;
        boolean zI = composer.I(navHostController);
        Object objG3 = composer.G();
        if (zI || objG3 == Composer.f23746a.a()) {
            objG3 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.intro.s0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return OnboardingActivity.m1(navHostController);
                }
            };
            composer.w(objG3);
        }
        WelcomeScreenKt.k(z2, function0, function02, (Function0) objG3, composer, 0, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k1(OnboardingViewState onboardingViewState, NavHostController navHostController) {
        AnswersHelper.f128199a.C3();
        if (onboardingViewState.f()) {
            NavController.P(navHostController, OnboardingNavItem.Question1.getRoute(), null, null, 6, null);
        } else {
            NavController.P(navHostController, OnboardingNavItem.SignIn.getRoute(), null, null, 6, null);
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l1(Function1 function1) {
        function1.invoke(OnboardingViewEvent.OnDeveloperOnboardingSkipped.f104515a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m1(NavHostController navHostController) {
        NavController.P(navHostController, OnboardingNavItem.SignIn.getRoute() + "?alreadyAMember=true", null, null, 6, null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n1(NavArgumentBuilder navArgument) {
        Intrinsics.checkNotNullParameter(navArgument, "$this$navArgument");
        navArgument.d(NavType.f48967n);
        navArgument.b(Boolean.FALSE);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o1(final Function1 function1, final NavHostController navHostController, AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        if (ComposerKt.M()) {
            ComposerKt.U(1748597178, i3, -1, "cz.mobilesoft.coreblock.scene.intro.OnboardingActivity.NavigationHost.<anonymous>.<anonymous>.<anonymous> (OnboardingActivity.kt:278)");
        }
        boolean Z = composer.Z(function1) | composer.I(navHostController);
        Object objG = composer.G();
        if (Z || objG == Composer.f23746a.a()) {
            objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.intro.n0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return OnboardingActivity.p1(function1, navHostController);
                }
            };
            composer.w(objG);
        }
        PrivacyExplanationScreenKt.y((Function0) objG, composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p1(Function1 function1, NavHostController navHostController) {
        function1.invoke(OnboardingViewEvent.OnPrivacyExplanationClosed.f104517a);
        AnswersHelper.f128199a.p3();
        NavController.P(navHostController, OnboardingNavItem.StatsPermission.getRoute(), null, null, 6, null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit q1(final NavHostController navHostController, AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        if (ComposerKt.M()) {
            ComposerKt.U(-1898142661, i3, -1, "cz.mobilesoft.coreblock.scene.intro.OnboardingActivity.NavigationHost.<anonymous>.<anonymous>.<anonymous> (OnboardingActivity.kt:288)");
        }
        boolean zI = composer.I(navHostController);
        Object objG = composer.G();
        if (zI || objG == Composer.f23746a.a()) {
            objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.intro.z
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return OnboardingActivity.r1(navHostController);
                }
            };
            composer.w(objG);
        }
        IntroReportScreenKt.j((Function0) objG, composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit r1(NavHostController navHostController) {
        AnswersHelper.f128199a.l3();
        NavController.P(navHostController, OnboardingNavItem.FeaturesOverview.getRoute(), null, null, 6, null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit s1(OnboardingViewState onboardingViewState, final NavHostController navHostController, AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        if (ComposerKt.M()) {
            ComposerKt.U(-1972953944, i3, -1, "cz.mobilesoft.coreblock.scene.intro.OnboardingActivity.NavigationHost.<anonymous>.<anonymous>.<anonymous> (OnboardingActivity.kt:301)");
        }
        boolean zI = composer.I(navHostController);
        Object objG = composer.G();
        if (zI || objG == Composer.f23746a.a()) {
            objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.intro.l0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return OnboardingActivity.t1(navHostController);
                }
            };
            composer.w(objG);
        }
        StatsExplanation1ScreenKt.c(onboardingViewState, (Function0) objG, composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit t1(NavHostController navHostController) {
        AnswersHelper.f128199a.d3();
        NavController.P(navHostController, OnboardingNavItem.StatsExplanation2.getRoute(), null, null, 6, null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit u1(OnboardingViewState onboardingViewState, final NavHostController navHostController, AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        if (ComposerKt.M()) {
            ComposerKt.U(-1324726487, i3, -1, "cz.mobilesoft.coreblock.scene.intro.OnboardingActivity.NavigationHost.<anonymous>.<anonymous>.<anonymous> (OnboardingActivity.kt:311)");
        }
        boolean zI = composer.I(navHostController);
        Object objG = composer.G();
        if (zI || objG == Composer.f23746a.a()) {
            objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.intro.d0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return OnboardingActivity.v1(navHostController);
                }
            };
            composer.w(objG);
        }
        StatsExplanation2ScreenKt.z(onboardingViewState, (Function0) objG, composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit v1(NavHostController navHostController) {
        AnswersHelper.f128199a.o3();
        NavController.P(navHostController, OnboardingNavItem.StatsExplanation3.getRoute(), null, null, 6, null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit w1(final NavHostController navHostController, AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        if (ComposerKt.M()) {
            ComposerKt.U(-676499030, i3, -1, "cz.mobilesoft.coreblock.scene.intro.OnboardingActivity.NavigationHost.<anonymous>.<anonymous>.<anonymous> (OnboardingActivity.kt:321)");
        }
        boolean zI = composer.I(navHostController);
        Object objG = composer.G();
        if (zI || objG == Composer.f23746a.a()) {
            objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.intro.t0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return OnboardingActivity.x1(navHostController);
                }
            };
            composer.w(objG);
        }
        StatsExplanation3ScreenKt.b((Function0) objG, composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit x1(NavHostController navHostController) {
        AnswersHelper.f128199a.Q2();
        NavController.P(navHostController, OnboardingNavItem.FeaturesOverview.getRoute(), null, null, 6, null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit y1(final NavHostController navHostController, final Function1 function1, AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        if (ComposerKt.M()) {
            ComposerKt.U(-28271573, i3, -1, "cz.mobilesoft.coreblock.scene.intro.OnboardingActivity.NavigationHost.<anonymous>.<anonymous>.<anonymous> (OnboardingActivity.kt:330)");
        }
        boolean zI = composer.I(navHostController);
        Object objG = composer.G();
        if (zI || objG == Composer.f23746a.a()) {
            objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.intro.b0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return OnboardingActivity.z1(navHostController);
                }
            };
            composer.w(objG);
        }
        Function0 function0 = (Function0) objG;
        boolean Z = composer.Z(function1);
        Object objG2 = composer.G();
        if (Z || objG2 == Composer.f23746a.a()) {
            objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.intro.c0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return OnboardingActivity.A1(function1);
                }
            };
            composer.w(objG2);
        }
        IntroFeaturesOverviewScreenKt.f(function0, (Function0) objG2, composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit z1(NavHostController navHostController) {
        AnswersHelper.f128199a.V2();
        NavController.P(navHostController, OnboardingNavItem.QuickBlockAbout.getRoute(), null, null, 6, null);
        return Unit.f139807a;
    }

    @Override // cz.mobilesoft.coreblock.base.activity.BaseComposeActivity
    public void c0(final PaddingValues paddingValues, Composer composer, final int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        Composer composerK = composer.k(934376846);
        if ((i3 & 48) == 0) {
            i4 = (composerK.I(this) ? 32 : 16) | i3;
        } else {
            i4 = i3;
        }
        if (composerK.r((i4 & 17) != 16, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(934376846, i4, -1, "cz.mobilesoft.coreblock.scene.intro.OnboardingActivity.RootCompose (OnboardingActivity.kt:59)");
            }
            ScaffoldState scaffoldStateG = ScaffoldKt.g(null, null, composerK, 0, 3);
            final NavHostController navHostControllerB = NavHostControllerKt.b(new Navigator[0], composerK, 0);
            Object objQ = composerK.q(AndroidCompositionLocals_androidKt.g());
            Intrinsics.checkNotNull(objQ, "null cannot be cast to non-null type androidx.activity.ComponentActivity");
            ComponentActivity componentActivity = (ComponentActivity) objQ;
            composerK.F(-101221098);
            CreationExtras creationExtrasA = ViewModelComposeExtKt.a(componentActivity, composerK, 8);
            Scope scopeD = GlobalContext.f145907a.get().j().d();
            composerK.F(-1072256281);
            KClass kClassB = Reflection.b(OnboardingViewModel.class);
            ViewModelStore viewModelStore = componentActivity.getViewModelStore();
            Intrinsics.checkNotNullExpressionValue(viewModelStore, "viewModelStoreOwner.viewModelStore");
            ViewModel viewModelA = GetViewModelKt.a(kClassB, viewModelStore, null, creationExtrasA, null, scopeD, null);
            composerK.Y();
            composerK.Y();
            OnboardingViewModel onboardingViewModel = (OnboardingViewModel) viewModelA;
            final OnboardingViewState onboardingViewState = (OnboardingViewState) FlowExtKt.m(onboardingViewModel, composerK, 0);
            final Function1 function1N = FlowExtKt.n(onboardingViewModel, composerK, 0);
            ScaffoldKt.a(null, scaffoldStateG, null, null, null, null, 0, false, null, false, null, 0.0f, 0L, 0L, 0L, 0L, 0L, ComposableLambdaKt.e(-188593776, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.intro.v
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return OnboardingActivity.Y1(this.f105293a, onboardingViewState, navHostControllerB, function1N, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerK, 54), composerK, 0, 12582912, 131069);
            composerK = composerK;
            f1(navHostControllerB, onboardingViewModel, composerK, (i4 << 3) & 896);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.intro.g0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return OnboardingActivity.Z1(this.f104618a, paddingValues, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    @Override // cz.mobilesoft.coreblock.base.activity.BaseComposeActivity
    protected boolean f0() {
        return this.f104487g;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int i3, int i4, Intent intent) {
        b2().onActivityResult(i3, i4, intent);
        super.onActivityResult(i3, i4, intent);
    }
}
