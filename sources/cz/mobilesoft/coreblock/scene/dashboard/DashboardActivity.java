package cz.mobilesoft.coreblock.scene.dashboard;

import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.activity.ComponentActivity;
import androidx.activity.compose.ActivityResultRegistryKt;
import androidx.activity.compose.ManagedActivityResultLauncher;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.compose.animation.AnimatedContentScope;
import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.EnterTransition;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.KeyframesSpec;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.AspectRatioKt;
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
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.BottomNavigationKt;
import androidx.compose.material.IconKt;
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
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.res.VectorResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavDestination;
import androidx.navigation.NavGraph;
import androidx.navigation.NavGraphBuilder;
import androidx.navigation.NavHostController;
import androidx.navigation.NavOptionsBuilder;
import androidx.navigation.Navigator;
import androidx.navigation.PopUpToBuilder;
import androidx.navigation.compose.NavGraphBuilderKt;
import androidx.navigation.compose.NavHostControllerKt;
import androidx.navigation.compose.NavHostKt;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.base.activity.BaseComposeActivity;
import cz.mobilesoft.coreblock.enums.PremiumFeature;
import cz.mobilesoft.coreblock.enums.SettingsScreenType;
import cz.mobilesoft.coreblock.enums.SignInEntryPoint;
import cz.mobilesoft.coreblock.repository.AcademyRepository;
import cz.mobilesoft.coreblock.scene.dashboard.DashboardActivity;
import cz.mobilesoft.coreblock.scene.dashboard.DashboardViewEvent;
import cz.mobilesoft.coreblock.scene.dashboard.profile.ProfileScreenKt;
import cz.mobilesoft.coreblock.scene.dashboard.shortcuts.unlock_all_apps.UnlockAllAppsScreenKt;
import cz.mobilesoft.coreblock.scene.dashboard.shortcuts.unlock_all_apps.UnlockAllAppsViewModel;
import cz.mobilesoft.coreblock.scene.dashboard.shortcuts.unlock_all_apps.UnlockAllAppsViewState;
import cz.mobilesoft.coreblock.scene.dashboard.strictmode.StrictModeScreenKt;
import cz.mobilesoft.coreblock.scene.inappupdate.InAppUpdateActivity;
import cz.mobilesoft.coreblock.scene.insights.InsightsScreenKt;
import cz.mobilesoft.coreblock.scene.insights.weekly.WeeklyInsightsActivity;
import cz.mobilesoft.coreblock.scene.more.help.HelpActivity;
import cz.mobilesoft.coreblock.scene.more.settings.SettingsActivity;
import cz.mobilesoft.coreblock.scene.more.signin.SignInActivity;
import cz.mobilesoft.coreblock.scene.more.signin.SignInConfig;
import cz.mobilesoft.coreblock.scene.password.PassCodeActivity;
import cz.mobilesoft.coreblock.scene.password.PassCodeType;
import cz.mobilesoft.coreblock.scene.pirateversion.PirateVersionBottomSheetKt;
import cz.mobilesoft.coreblock.scene.premium.host.Paywall;
import cz.mobilesoft.coreblock.scene.premium.host.PaywallTarget;
import cz.mobilesoft.coreblock.scene.streaks.intro.StreakIntroAvailability;
import cz.mobilesoft.coreblock.storage.datastore.EventDataStore;
import cz.mobilesoft.coreblock.storage.datastore.PassCodeDataStore;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile;
import cz.mobilesoft.coreblock.storage.sharedprefs.PrefManager;
import cz.mobilesoft.coreblock.util.AdsUtils;
import cz.mobilesoft.coreblock.util.DeeplinkRouter;
import cz.mobilesoft.coreblock.util.ExternalLinksHelper;
import cz.mobilesoft.coreblock.util.ads.BaseAdsUtils;
import cz.mobilesoft.coreblock.util.analytics.AnswersHelper;
import cz.mobilesoft.coreblock.util.compose.ComposableExtKt;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.util.compose.FlowExtKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.util.helperextension.CoroutinesHelperExtKt;
import cz.mobilesoft.coreblock.util.helperextension.DateHelper;
import cz.mobilesoft.coreblock.util.runnability.InitHelper;
import cz.mobilesoft.coreblock.util.updates.InAppUpdateDialogDTO;
import cz.mobilesoft.coreblock.view.compose.ButtonColor;
import cz.mobilesoft.coreblock.view.compose.ButtonType;
import cz.mobilesoft.coreblock.view.compose.ComposeBottomSheetsKt;
import cz.mobilesoft.coreblock.view.compose.ComposeButtonsKt;
import cz.mobilesoft.coreblock.view.compose.ComposeCountDownKt;
import cz.mobilesoft.coreblock.view.compose.ComposeDialogsKt;
import cz.mobilesoft.coreblock.view.compose.IconCircleBackgroundKt;
import cz.mobilesoft.coreblock.view.dialog.InfoDialogFragment;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import org.koin.android.ext.android.AndroidKoinScopeExtKt;
import org.koin.androidx.compose.ViewModelComposeExtKt;
import org.koin.androidx.viewmodel.GetViewModelKt;
import org.koin.androidx.viewmodel.ext.android.BundleExtKt;
import org.koin.core.context.GlobalContext;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.parameter.ParametersHolderKt;
import org.koin.core.qualifier.Qualifier;
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
public final class DashboardActivity extends BaseComposeActivity {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final Companion f99133o = new Companion(null);

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f99134p = 8;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final Lazy f99135q = LazyKt.b(new Function0() { // from class: cz.mobilesoft.coreblock.scene.dashboard.r1
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return DashboardActivity.z2();
        }
    });

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Lazy f99136f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Lazy f99137g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final CoroutineScope f99138h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final boolean f99139i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Lazy f99140j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final Lazy f99141k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final MutableState f99142l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final AtomicBoolean f99143m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final ActivityResultLauncher f99144n;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ Intent c(Companion companion, Context context, Integer num, NavBarItem navBarItem, int i3, Object obj) {
            if ((i3 & 2) != 0) {
                num = null;
            }
            if ((i3 & 4) != 0) {
                navBarItem = null;
            }
            return companion.b(context, num, navBarItem);
        }

        public final List a() {
            return (List) DashboardActivity.f99135q.getValue();
        }

        public final Intent b(Context context, Integer num, NavBarItem navBarItem) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intent intent = new Intent(context, (Class<?>) DashboardActivity.class);
            intent.putExtra("PROFILE_TYPE_COMBINATIONS", num);
            intent.putExtra("DASHBOARD_START_NAV_ITEM", navBarItem);
            return intent;
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static abstract class NavBarItem implements Serializable {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final Companion f99168h = new Companion(null);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f99169a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f99170b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f99171c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final String f99172d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final Integer f99173f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final Integer f99174g;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Blocking extends NavBarItem {

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            public static final Blocking f99175i = new Blocking();

            private Blocking() {
                super(R.string.x4, R.drawable.f95495b1, R.drawable.Z0, "blocking", null, null, 48, null);
            }

            private final Object readResolve() {
                return f99175i;
            }

            public boolean equals(Object obj) {
                return this == obj || (obj instanceof Blocking);
            }

            public int hashCode() {
                return 570612398;
            }

            public String toString() {
                return "Blocking";
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Insights extends NavBarItem {

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            public static final Insights f99176i = new Insights();

            private Insights() {
                super(R.string.zh, R.drawable.H5, R.drawable.G5, "insights", null, null, 48, null);
            }

            private final Object readResolve() {
                return f99176i;
            }

            public boolean equals(Object obj) {
                return this == obj || (obj instanceof Insights);
            }

            public int hashCode() {
                return 1780328020;
            }

            public String toString() {
                return "Insights";
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Profile extends NavBarItem {

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            public static final Profile f99177i = new Profile();

            private Profile() {
                super(R.string.uC, R.drawable.O6, R.drawable.N6, "profile", null, null, 48, null);
            }

            private final Object readResolve() {
                return f99177i;
            }

            public boolean equals(Object obj) {
                return this == obj || (obj instanceof Profile);
            }

            public int hashCode() {
                return 561702928;
            }

            public String toString() {
                return "Profile";
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Deprecated
        @Metadata
        public static final class Statistics extends NavBarItem {

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            public static final Statistics f99178i = new Statistics();

            private Statistics() {
                super(R.string.OD, R.drawable.H5, R.drawable.G5, "statistics", null, null, 48, null);
            }

            private final Object readResolve() {
                return f99178i;
            }

            public boolean equals(Object obj) {
                return this == obj || (obj instanceof Statistics);
            }

            public int hashCode() {
                return 1507485020;
            }

            public String toString() {
                return "Statistics";
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class StrictMode extends NavBarItem {

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            public static final StrictMode f99179i = new StrictMode();

            /* JADX WARN: Illegal instructions before constructor call */
            private StrictMode() {
                String str = "strict_mode";
                super(R.string.PD, R.drawable.db, R.drawable.cb, str, Integer.valueOf(R.drawable.Za), Integer.valueOf(R.drawable.ab), null);
            }

            private final Object readResolve() {
                return f99179i;
            }

            public boolean equals(Object obj) {
                return this == obj || (obj instanceof StrictMode);
            }

            public int hashCode() {
                return -274123707;
            }

            public String toString() {
                return "StrictMode";
            }
        }

        public /* synthetic */ NavBarItem(int i3, int i4, int i5, String str, Integer num, Integer num2, DefaultConstructorMarker defaultConstructorMarker) {
            this(i3, i4, i5, str, num, num2);
        }

        public final Integer a() {
            return this.f99173f;
        }

        public final Integer b() {
            return this.f99174g;
        }

        public final String c() {
            return this.f99172d;
        }

        public final int d() {
            return this.f99171c;
        }

        public final int e() {
            return this.f99169a;
        }

        public final int f() {
            return this.f99170b;
        }

        private NavBarItem(int i3, int i4, int i5, String str, Integer num, Integer num2) {
            this.f99169a = i3;
            this.f99170b = i4;
            this.f99171c = i5;
            this.f99172d = str;
            this.f99173f = num;
            this.f99174g = num2;
        }

        public /* synthetic */ NavBarItem(int i3, int i4, int i5, String str, Integer num, Integer num2, int i6, DefaultConstructorMarker defaultConstructorMarker) {
            this(i3, i4, i5, str, (i6 & 16) != 0 ? null : num, (i6 & 32) != 0 ? null : num2, null);
        }
    }

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.dashboard.DashboardActivity$onCreate$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.dashboard.DashboardActivity$onCreate$1", f = "DashboardActivity.kt", l = {215}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f99204a;

        AnonymousClass1(Continuation continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return DashboardActivity.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f99204a;
            if (i3 == 0) {
                ResultKt.b(obj);
                DashboardActivity dashboardActivity = DashboardActivity.this;
                Intent intent = dashboardActivity.getIntent();
                Intrinsics.checkNotNullExpressionValue(intent, "getIntent(...)");
                this.f99204a = 1;
                if (dashboardActivity.L2(intent, this) == objF) {
                    return objF;
                }
            } else {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            DashboardActivity dashboardActivity2 = DashboardActivity.this;
            dashboardActivity2.K2(dashboardActivity2.getIntent());
            AcademyRepository.q(null, 1, null);
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((AnonymousClass1) create(continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.dashboard.DashboardActivity$onCreate$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.dashboard.DashboardActivity$onCreate$2", f = "DashboardActivity.kt", l = {223, 224}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f99206a;

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.dashboard.DashboardActivity$onCreate$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.dashboard.DashboardActivity$onCreate$2$1", f = "DashboardActivity.kt", l = {}, m = "invokeSuspend", v = 1)
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f99208a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ DashboardActivity f99209b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(DashboardActivity dashboardActivity, Continuation continuation) {
                super(2, continuation);
                this.f99209b = dashboardActivity;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Object obj, Continuation continuation) {
                return new AnonymousClass1(this.f99209b, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                IntrinsicsKt.f();
                if (this.f99208a != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
                this.f99209b.f99144n.b(PassCodeActivity.f111670f.a(this.f99209b, PassCodeType.Check));
                return Unit.f139807a;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
            }
        }

        AnonymousClass2(Continuation continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return DashboardActivity.this.new AnonymousClass2(continuation);
        }

        /* JADX WARN: Code restructure failed: missing block: B:18:0x0059, code lost:
        
            if (kotlinx.coroutines.BuildersKt.g(r6, r1, r5) == r0) goto L19;
         */
        /* JADX WARN: Removed duplicated region for block: B:17:0x0047  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r6) throws java.lang.Throwable {
            /*
                r5 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                int r1 = r5.f99206a
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L1e
                if (r1 == r3) goto L1a
                if (r1 != r2) goto L12
                kotlin.ResultKt.b(r6)
                goto L5c
            L12:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r0)
                throw r6
            L1a:
                kotlin.ResultKt.b(r6)
                goto L3f
            L1e:
                kotlin.ResultKt.b(r6)
                cz.mobilesoft.coreblock.scene.dashboard.DashboardActivity r6 = cz.mobilesoft.coreblock.scene.dashboard.DashboardActivity.this
                android.content.Intent r6 = r6.getIntent()
                java.lang.String r1 = "IS_FROM_WIDGET"
                r4 = 0
                boolean r6 = r6.getBooleanExtra(r1, r4)
                if (r6 == 0) goto L5c
                cz.mobilesoft.coreblock.scene.dashboard.DashboardActivity r6 = cz.mobilesoft.coreblock.scene.dashboard.DashboardActivity.this
                cz.mobilesoft.coreblock.storage.datastore.PassCodeDataStore r6 = cz.mobilesoft.coreblock.scene.dashboard.DashboardActivity.q2(r6)
                r5.f99206a = r3
                java.lang.Object r6 = r6.B(r5)
                if (r6 != r0) goto L3f
                goto L5b
            L3f:
                java.lang.Boolean r6 = (java.lang.Boolean) r6
                boolean r6 = r6.booleanValue()
                if (r6 == 0) goto L5c
                kotlinx.coroutines.MainCoroutineDispatcher r6 = kotlinx.coroutines.Dispatchers.c()
                cz.mobilesoft.coreblock.scene.dashboard.DashboardActivity$onCreate$2$1 r1 = new cz.mobilesoft.coreblock.scene.dashboard.DashboardActivity$onCreate$2$1
                cz.mobilesoft.coreblock.scene.dashboard.DashboardActivity r3 = cz.mobilesoft.coreblock.scene.dashboard.DashboardActivity.this
                r4 = 0
                r1.<init>(r3, r4)
                r5.f99206a = r2
                java.lang.Object r6 = kotlinx.coroutines.BuildersKt.g(r6, r1, r5)
                if (r6 != r0) goto L5c
            L5b:
                return r0
            L5c:
                kotlin.Unit r6 = kotlin.Unit.f139807a
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.dashboard.DashboardActivity.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((AnonymousClass2) create(continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DashboardActivity() {
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.f139761a;
        final Qualifier qualifier = null;
        final Object[] objArr = 0 == true ? 1 : 0;
        this.f99136f = LazyKt.a(lazyThreadSafetyMode, new Function0<EventDataStore>() { // from class: cz.mobilesoft.coreblock.scene.dashboard.DashboardActivity$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                ComponentCallbacks componentCallbacks = this;
                return AndroidKoinScopeExtKt.a(componentCallbacks).e(Reflection.b(EventDataStore.class), qualifier, objArr);
            }
        });
        final Object[] objArr2 = 0 == true ? 1 : 0;
        final Object[] objArr3 = 0 == true ? 1 : 0;
        this.f99137g = LazyKt.a(lazyThreadSafetyMode, new Function0<PassCodeDataStore>() { // from class: cz.mobilesoft.coreblock.scene.dashboard.DashboardActivity$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                ComponentCallbacks componentCallbacks = this;
                return AndroidKoinScopeExtKt.a(componentCallbacks).e(Reflection.b(PassCodeDataStore.class), objArr2, objArr3);
            }
        });
        this.f99138h = CoroutineScopeKt.a(Dispatchers.b().plus(SupervisorKt.b(null, 1, null)).plus(CoroutinesHelperExtKt.b()));
        final Object[] objArr4 = 0 == true ? 1 : 0;
        final Object[] objArr5 = 0 == true ? 1 : 0;
        this.f99140j = LazyKt.a(lazyThreadSafetyMode, new Function0<DeeplinkRouter>() { // from class: cz.mobilesoft.coreblock.scene.dashboard.DashboardActivity$special$$inlined$inject$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                ComponentCallbacks componentCallbacks = this;
                return AndroidKoinScopeExtKt.a(componentCallbacks).e(Reflection.b(DeeplinkRouter.class), objArr4, objArr5);
            }
        });
        final Object[] objArr6 = 0 == true ? 1 : 0;
        final Object[] objArr7 = 0 == true ? 1 : 0;
        this.f99141k = LazyKt.a(lazyThreadSafetyMode, new Function0<StreakIntroAvailability>() { // from class: cz.mobilesoft.coreblock.scene.dashboard.DashboardActivity$special$$inlined$inject$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                ComponentCallbacks componentCallbacks = this;
                return AndroidKoinScopeExtKt.a(componentCallbacks).e(Reflection.b(StreakIntroAvailability.class), objArr6, objArr7);
            }
        });
        this.f99142l = SnapshotStateKt__SnapshotStateKt.e(null, null, 2, null);
        this.f99143m = new AtomicBoolean(false);
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type androidx.activity.ComponentActivity");
        this.f99144n = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: cz.mobilesoft.coreblock.scene.dashboard.y2
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                DashboardActivity.P2(this.f101620a, (ActivityResult) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit A1(Context context, Function1 function1) {
        context.startActivity(SignInActivity.f110366h.a(context, new SignInConfig(SignInEntryPoint.DIALOG, null, false, false, false, false, false, false, false, false, null, 2046, null)));
        function1.invoke(DashboardViewEvent.OnRegistrationDialogClosed.f99249a);
        return Unit.f139807a;
    }

    private final void A2() {
        BuildersKt__Builders_commonKt.d(LifecycleOwnerKt.a(this), Dispatchers.a().plus(SupervisorKt.b(null, 1, null)).plus(CoroutinesHelperExtKt.b()), null, new DashboardActivity$checkAccessibilityServiceAndShowDialog$1(this, null), 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit B1(Context context, Function1 function1) {
        context.startActivity(SignInActivity.f110366h.a(context, new SignInConfig(SignInEntryPoint.DIALOG, null, true, false, false, false, false, false, false, false, null, 2042, null)));
        function1.invoke(DashboardViewEvent.OnRegistrationDialogClosed.f99249a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void B2() {
        AdsUtils.f127678i.s(this, new Function1() { // from class: cz.mobilesoft.coreblock.scene.dashboard.n2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return DashboardActivity.C2(this.f100874a, ((Integer) obj).intValue());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit C1(Function1 function1) {
        function1.invoke(DashboardViewEvent.OnWeeklyInsightsDialogClosed.f99253a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit C2(final DashboardActivity dashboardActivity, int i3) {
        if (i3 == 0 || i3 == 2) {
            AdsUtils.f127678i.x(dashboardActivity, new BaseAdsUtils.ConsentFormCallback() { // from class: cz.mobilesoft.coreblock.scene.dashboard.j3
                @Override // cz.mobilesoft.coreblock.util.ads.BaseAdsUtils.ConsentFormCallback
                public final void l(Object obj, boolean z2) {
                    DashboardActivity.D2(this.f100836a, (Integer) obj, z2);
                }
            });
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit D1(Context context, DashboardActivity dashboardActivity) {
        dashboardActivity.startActivity(WeeklyInsightsActivity.f103883g.b(context));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D2(DashboardActivity dashboardActivity, Integer num, boolean z2) {
        if (z2) {
            dashboardActivity.startActivity(Paywall.c(Paywall.f113165a, dashboardActivity, PaywallTarget.Generic.INSTANCE, "blocking_tab", "ad_consent", false, false, false, null, 240, null));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit E1(KeyframesSpec.KeyframesSpecConfig keyframes) {
        Intrinsics.checkNotNullParameter(keyframes, "$this$keyframes");
        keyframes.d(500);
        return Unit.f139807a;
    }

    private final void E2() {
        FlowExtKt.l(G2().Y0(), this.f99138h, new FlowCollector() { // from class: cz.mobilesoft.coreblock.scene.dashboard.DashboardActivity$checkLockServiceRestart$1

            /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.dashboard.DashboardActivity$checkLockServiceRestart$1$1, reason: invalid class name */
            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.dashboard.DashboardActivity$checkLockServiceRestart$1$1", f = "DashboardActivity.kt", l = {243}, m = "invokeSuspend", v = 1)
            static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                int f99196a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                final /* synthetic */ DashboardActivity f99197b;

                /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.dashboard.DashboardActivity$checkLockServiceRestart$1$1$1, reason: invalid class name and collision with other inner class name */
                /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
                @Metadata
                @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.dashboard.DashboardActivity$checkLockServiceRestart$1$1$1", f = "DashboardActivity.kt", l = {}, m = "invokeSuspend", v = 1)
                static final class C02681 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    int f99198a;

                    /* JADX INFO: renamed from: b, reason: collision with root package name */
                    final /* synthetic */ DashboardActivity f99199b;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    C02681(DashboardActivity dashboardActivity, Continuation continuation) {
                        super(2, continuation);
                        this.f99199b = dashboardActivity;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation create(Object obj, Continuation continuation) {
                        return new C02681(this.f99199b, continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) throws Throwable {
                        IntrinsicsKt.f();
                        if (this.f99198a != 0) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.b(obj);
                        if (!this.f99199b.getSupportFragmentManager().Y0()) {
                            InfoDialogFragment.Companion companion = InfoDialogFragment.f132708b;
                            FragmentManager supportFragmentManager = this.f99199b.getSupportFragmentManager();
                            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
                            String string = this.f99199b.getString(R.string.xj);
                            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                            DashboardActivity dashboardActivity = this.f99199b;
                            String string2 = dashboardActivity.getString(R.string.wj, dashboardActivity.getString(R.string.f95790f1));
                            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                            InfoDialogFragment.InfoDialogSetupDTO infoDialogSetupDTO = new InfoDialogFragment.InfoDialogSetupDTO(string, string2, Boxing.d(R.string.GE), Boxing.d(R.string.N7), true);
                            final DashboardActivity dashboardActivity2 = this.f99199b;
                            companion.b(supportFragmentManager, infoDialogSetupDTO, new InfoDialogFragment.OnDialogClosedListener() { // from class: cz.mobilesoft.coreblock.scene.dashboard.DashboardActivity.checkLockServiceRestart.1.1.1.1
                                @Override // cz.mobilesoft.coreblock.view.dialog.InfoDialogFragment.OnDialogClosedListener
                                public void a(int i3, boolean z2) {
                                    if (i3 == -1) {
                                        dashboardActivity2.Q2();
                                    }
                                    if (z2) {
                                        PrefManager.f126839a.F2(false);
                                    }
                                }

                                @Override // cz.mobilesoft.coreblock.view.dialog.InfoDialogFragment.OnDialogClosedListener
                                public LifecycleOwner b() {
                                    return dashboardActivity2;
                                }
                            });
                        }
                        return Unit.f139807a;
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
                        return ((C02681) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass1(DashboardActivity dashboardActivity, Continuation continuation) {
                    super(2, continuation);
                    this.f99197b = dashboardActivity;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation create(Object obj, Continuation continuation) {
                    return new AnonymousClass1(this.f99197b, continuation);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) throws Throwable {
                    Object objF = IntrinsicsKt.f();
                    int i3 = this.f99196a;
                    if (i3 == 0) {
                        ResultKt.b(obj);
                        if (PrefManager.f126839a.g1()) {
                            MainCoroutineDispatcher mainCoroutineDispatcherC = Dispatchers.c();
                            C02681 c02681 = new C02681(this.f99197b, null);
                            this.f99196a = 1;
                            if (BuildersKt.g(mainCoroutineDispatcherC, c02681, this) == objF) {
                                return objF;
                            }
                        }
                    } else {
                        if (i3 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.b(obj);
                    }
                    return Unit.f139807a;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
                    return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
                }
            }

            public final Object a(long j3, Continuation continuation) {
                Object objG = BuildersKt.g(Dispatchers.b(), new AnonymousClass1(this.f99195a, null), continuation);
                return objG == IntrinsicsKt.f() ? objG : Unit.f139807a;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                return a(((Number) obj).longValue(), continuation);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit F1(DashboardActivity dashboardActivity, DashboardViewState dashboardViewState, AnimatedVisibilityScope AnimatedVisibility, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
        if (ComposerKt.M()) {
            ComposerKt.U(394905871, i3, -1, "cz.mobilesoft.coreblock.scene.dashboard.DashboardActivity.DashboardScreen.<anonymous> (DashboardActivity.kt:625)");
        }
        dashboardActivity.T1(dashboardViewState.e().d() - dashboardViewState.e().e(), dashboardViewState.e().c(), composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DeeplinkRouter F2() {
        return (DeeplinkRouter) this.f99140j.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit G1(MutableState mutableState, DashboardActivity dashboardActivity, NavHostController navHostController, Function1 function1, MutableState mutableState2, MutableState mutableState3, ColumnScope AppBottomSheet, SheetState it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(AppBottomSheet, "$this$AppBottomSheet");
        Intrinsics.checkNotNullParameter(it, "it");
        if (composer.r((i3 & 129) != 128, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-564135317, i3, -1, "cz.mobilesoft.coreblock.scene.dashboard.DashboardActivity.DashboardScreen.<anonymous> (DashboardActivity.kt:650)");
            }
            if (((Boolean) mutableState.getValue()).booleanValue()) {
                composer.a0(51878282);
                dashboardActivity.h2(navHostController, function1, mutableState2, composer, 0);
                composer.U();
            } else {
                composer.a0(52248360);
                dashboardActivity.e2(navHostController, function1, mutableState3, mutableState2, composer, 0);
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

    private final EventDataStore G2() {
        return (EventDataStore) this.f99136f.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit H1(MutableState mutableState) {
        mutableState.setValue(Boolean.FALSE);
        AnswersHelper.f128199a.I7();
        return Unit.f139807a;
    }

    private final NavBarItem H2() {
        NavBarItem navBarItem = (NavBarItem) getIntent().getSerializableExtra("DASHBOARD_START_NAV_ITEM");
        if (navBarItem != null) {
            return navBarItem;
        }
        if (getIntent().getBooleanExtra("IS_TILE_SERVICE", false)) {
            return NavBarItem.Blocking.f99175i;
        }
        String stringExtra = getIntent().getStringExtra("DASHBOARD_TAB");
        Object obj = null;
        if (stringExtra == null) {
            return null;
        }
        if (!getIntent().hasExtra("NOTIFICATION_ID")) {
            int iHashCode = stringExtra.hashCode();
            if (iHashCode != -664572875) {
                if (iHashCode != 545142747) {
                    if (iHashCode == 1983998297 && stringExtra.equals("strict_mode")) {
                        AnswersHelper.f128199a.s0();
                    }
                } else if (stringExtra.equals("insights")) {
                    AnswersHelper.f128199a.q0();
                }
            } else if (stringExtra.equals("blocking")) {
                AnswersHelper.f128199a.o0();
            }
        }
        Iterator it = f99133o.a().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (Intrinsics.areEqual(((NavBarItem) next).c(), stringExtra)) {
                obj = next;
                break;
            }
        }
        return (NavBarItem) obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit I1(DashboardActivity dashboardActivity, NavHostController navHostController, DashboardViewState dashboardViewState, State state, NavBarItem navBarItem, Function1 function1, ScaffoldState scaffoldState, MutableState mutableState, MutableState mutableState2, MutableState mutableState3, Flow flow, boolean z2, int i3, int i4, Composer composer, int i5) {
        dashboardActivity.u1(navHostController, dashboardViewState, state, navBarItem, function1, scaffoldState, mutableState, mutableState2, mutableState3, flow, z2, composer, RecomposeScopeImplKt.a(i3 | 1), RecomposeScopeImplKt.a(i4));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PassCodeDataStore I2() {
        return (PassCodeDataStore) this.f99137g.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final StreakIntroAvailability J2() {
        return (StreakIntroAvailability) this.f99141k.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit K1(final Function1 function1, final DashboardActivity dashboardActivity, final NavHostController navHostController, final Flow flow, final ScaffoldState scaffoldState, NavGraphBuilder NavHost) {
        Intrinsics.checkNotNullParameter(NavHost, "$this$NavHost");
        NavGraphBuilderKt.c(NavHost, NavBarItem.Blocking.f99175i.c(), null, null, null, null, null, null, null, ComposableLambdaKt.c(1931310895, true, new Function4() { // from class: cz.mobilesoft.coreblock.scene.dashboard.c3
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return DashboardActivity.L1(function1, dashboardActivity, navHostController, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        }), 254, null);
        NavGraphBuilderKt.c(NavHost, NavBarItem.StrictMode.f99179i.c(), null, null, null, null, null, null, null, ComposableLambdaKt.c(1477480920, true, new Function4() { // from class: cz.mobilesoft.coreblock.scene.dashboard.d3
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return DashboardActivity.O1(flow, function1, scaffoldState, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        }), 254, null);
        NavGraphBuilderKt.c(NavHost, NavBarItem.Insights.f99176i.c(), null, null, null, null, null, null, null, ComposableLambdaKt.c(-937959753, true, new Function4() { // from class: cz.mobilesoft.coreblock.scene.dashboard.e3
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return DashboardActivity.P1(this.f100787a, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        }), 254, null);
        NavGraphBuilderKt.c(NavHost, NavBarItem.Profile.f99177i.c(), null, null, null, null, null, null, null, ComposableLambdaKt.c(941566870, true, new Function4() { // from class: cz.mobilesoft.coreblock.scene.dashboard.f3
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return DashboardActivity.R1(scaffoldState, function1, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        }), 254, null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void K2(Intent intent) {
        Uri data;
        if (intent == null || (data = intent.getData()) == null) {
            return;
        }
        F2().o(this, data, LifecycleOwnerKt.a(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit L1(final Function1 function1, final DashboardActivity dashboardActivity, final NavHostController navHostController, AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        if (ComposerKt.M()) {
            ComposerKt.U(1931310895, i3, -1, "cz.mobilesoft.coreblock.scene.dashboard.DashboardActivity.NavigationHost.<anonymous>.<anonymous>.<anonymous> (DashboardActivity.kt:758)");
        }
        ActivityResultContracts.StartActivityForResult startActivityForResult = new ActivityResultContracts.StartActivityForResult();
        boolean Z = composer.Z(function1);
        Object objG = composer.G();
        if (Z || objG == Composer.f23746a.a()) {
            objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.dashboard.g3
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return DashboardActivity.M1(function1, (ActivityResult) obj);
                }
            };
            composer.w(objG);
        }
        ManagedActivityResultLauncher managedActivityResultLauncherA = ActivityResultRegistryKt.a(startActivityForResult, (Function1) objG, composer, 0);
        boolean zI = composer.I(dashboardActivity) | composer.I(navHostController) | composer.Z(function1);
        Object objG2 = composer.G();
        if (zI || objG2 == Composer.f23746a.a()) {
            objG2 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.dashboard.h3
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return DashboardActivity.N1(this.f100816a, navHostController, function1, (DashboardActivity.NavBarItem) obj);
                }
            };
            composer.w(objG2);
        }
        BlockingScreenKt.p0(managedActivityResultLauncherA, function1, (Function1) objG2, composer, ManagedActivityResultLauncher.f461c);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object L2(Intent intent, Continuation continuation) {
        Object objG = BuildersKt.g(Dispatchers.c(), new DashboardActivity$handleIntent$2(intent, this, null), continuation);
        return objG == IntrinsicsKt.f() ? objG : Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit M1(Function1 function1, ActivityResult it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (it.d() == -1) {
            Intent intentC = it.c();
            Serializable serializableExtra = intentC != null ? intentC.getSerializableExtra("PAUSED_UNTIL") : null;
            Profile.PausedUntil pausedUntil = serializableExtra instanceof Profile.PausedUntil ? (Profile.PausedUntil) serializableExtra : null;
            if (pausedUntil != null) {
                Intent intentC2 = it.c();
                function1.invoke(new DashboardViewEvent.OnProfilePaused(pausedUntil, (Long) (intentC2 != null ? intentC2.getSerializableExtra("PROFILE_ID") : null)));
            }
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void M2(final NavHostController navHostController, final NavBarItem navBarItem, final Function1 function1) {
        navHostController.N(navBarItem.c(), new Function1() { // from class: cz.mobilesoft.coreblock.scene.dashboard.c2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return DashboardActivity.N2(navHostController, function1, navBarItem, (NavOptionsBuilder) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit N1(DashboardActivity dashboardActivity, NavHostController navHostController, Function1 function1, NavBarItem it) {
        Intrinsics.checkNotNullParameter(it, "it");
        dashboardActivity.M2(navHostController, it, function1);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit N2(NavHostController navHostController, Function1 function1, NavBarItem navBarItem, NavOptionsBuilder navigate) {
        Intrinsics.checkNotNullParameter(navigate, "$this$navigate");
        navigate.c(NavGraph.f48886j.d(navHostController.x()).o(), new Function1() { // from class: cz.mobilesoft.coreblock.scene.dashboard.k3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return DashboardActivity.O2((PopUpToBuilder) obj);
            }
        });
        navigate.e(true);
        navigate.h(true);
        function1.invoke(new DashboardViewEvent.OnScreenOpened(navBarItem));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit O1(Flow flow, Function1 function1, ScaffoldState scaffoldState, AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        if (ComposerKt.M()) {
            ComposerKt.U(1477480920, i3, -1, "cz.mobilesoft.coreblock.scene.dashboard.DashboardActivity.NavigationHost.<anonymous>.<anonymous>.<anonymous> (DashboardActivity.kt:776)");
        }
        StrictModeScreenKt.n(flow, function1, scaffoldState, composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit O2(PopUpToBuilder popUpTo) {
        Intrinsics.checkNotNullParameter(popUpTo, "$this$popUpTo");
        popUpTo.d(true);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit P1(final DashboardActivity dashboardActivity, AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        if (ComposerKt.M()) {
            ComposerKt.U(-937959753, i3, -1, "cz.mobilesoft.coreblock.scene.dashboard.DashboardActivity.NavigationHost.<anonymous>.<anonymous>.<anonymous> (DashboardActivity.kt:784)");
        }
        boolean zI = composer.I(dashboardActivity);
        Object objG = composer.G();
        if (zI || objG == Composer.f23746a.a()) {
            objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.dashboard.i3
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return DashboardActivity.Q1(this.f100825a);
                }
            };
            composer.w(objG);
        }
        InsightsScreenKt.i0(null, null, null, (Function0) objG, composer, 0, 7);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P2(DashboardActivity dashboardActivity, ActivityResult result) {
        Intrinsics.checkNotNullParameter(result, "result");
        BuildersKt__Builders_commonKt.d(dashboardActivity.f99138h, null, null, new DashboardActivity$passCodeLauncher$1$1(dashboardActivity, result, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Q1(DashboardActivity dashboardActivity) {
        dashboardActivity.startActivity(Paywall.c(Paywall.f113165a, dashboardActivity, new PaywallTarget.LimitScreen(PremiumFeature.STATISTICS), "app_feel_labeling", "app_feel_exclude", false, false, false, null, 240, null));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Q2() {
        startActivity(HelpActivity.f107722u.a(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit R1(ScaffoldState scaffoldState, Function1 function1, AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        if (ComposerKt.M()) {
            ComposerKt.U(941566870, i3, -1, "cz.mobilesoft.coreblock.scene.dashboard.DashboardActivity.NavigationHost.<anonymous>.<anonymous>.<anonymous> (DashboardActivity.kt:799)");
        }
        ProfileScreenKt.K0(scaffoldState, function1, composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit S1(DashboardActivity dashboardActivity, NavHostController navHostController, PaddingValues paddingValues, String str, DashboardViewState dashboardViewState, Function1 function1, ScaffoldState scaffoldState, Flow flow, int i3, Composer composer, int i4) {
        dashboardActivity.J1(navHostController, paddingValues, str, dashboardViewState, function1, scaffoldState, flow, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    private final void T1(final long j3, final float f3, Composer composer, final int i3) {
        int i4;
        float f4;
        Composer composerK = composer.k(-629855602);
        if ((i3 & 6) == 0) {
            i4 = i3 | (composerK.f(j3) ? 4 : 2);
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            f4 = f3;
            i4 |= composerK.c(f4) ? 32 : 16;
        } else {
            f4 = f3;
        }
        if (composerK.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-629855602, i4, -1, "cz.mobilesoft.coreblock.scene.dashboard.DashboardActivity.PauseCountDown (DashboardActivity.kt:701)");
            }
            final String strK = j3 >= TimeUnit.HOURS.toMillis(1L) ? DateHelper.k((Context) composerK.q(AndroidCompositionLocals_androidKt.g()), j3) : DateHelper.e(TimeUnit.MILLISECONDS.toSeconds(j3));
            Modifier.Companion companion = Modifier.b8;
            Modifier modifierD = BackgroundKt.d(SizeKt.f(companion, 0.0f, 1, null), Color.r(Color.f25715b.a(), 0.5f, 0.0f, 0.0f, 0.0f, 14, null), null, 2, null);
            Object objG = composerK.G();
            if (objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.dashboard.r2
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return DashboardActivity.U1();
                    }
                };
                composerK.w(objG);
            }
            Modifier modifierD2 = ClickableKt.d(modifierD, null, null, false, null, null, (Function0) objG, 28, null);
            Alignment.Companion companion2 = Alignment.f25072a;
            MeasurePolicy measurePolicyG = BoxKt.g(companion2.o(), false);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierD2);
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
            Updater.e(composerA, measurePolicyG, companion3.e());
            Updater.e(composerA, compositionLocalMapU, companion3.g());
            Function2 function2B = companion3.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion3.f());
            ComposeCountDownKt.b(BackgroundKt.c(PaddingKt.i(AspectRatioKt.b(SizeKt.h(BoxScopeInstance.f6642a.f(companion, companion2.e()), 0.0f, 1, null), 1.0f, false, 2, null), Dp.g(32)), ColorKt.h(ComposeColorsKt.j(composerK, 0).u(), ComposeColorsKt.j(composerK, 0).l0()), RoundedCornerShapeKt.g()), Dp.g(16), Dp.g(8), f4, 0L, ComposableLambdaKt.e(1019602263, true, new Function2() { // from class: cz.mobilesoft.coreblock.scene.dashboard.s2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DashboardActivity.V1(strK, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerK, 54), composerK, ((i4 << 6) & 7168) | 197040, 16);
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.dashboard.t2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DashboardActivity.W1(this.f101546a, j3, f3, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit U1() {
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit V1(String str, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1019602263, i3, -1, "cz.mobilesoft.coreblock.scene.dashboard.DashboardActivity.PauseCountDown.<anonymous>.<anonymous> (DashboardActivity.kt:728)");
            }
            Intrinsics.checkNotNull(str);
            TextKt.c(str, null, ComposeColorsKt.j(composer, 0).b(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, cz.mobilesoft.coreblock.view.compose.TextKt.d(ComposeTypographyKt.g(composer, 0).e()), composer, 0, 0, 65530);
            TextKt.c(StringResources_androidKt.b(R.string.F4, composer, 0), null, ComposeColorsKt.j(composer, 0).q(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).b(), composer, 0, 0, 65530);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit W1(DashboardActivity dashboardActivity, long j3, float f3, int i3, Composer composer, int i4) {
        dashboardActivity.T1(j3, f3, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ParametersHolder X1(DashboardActivity dashboardActivity) {
        return ParametersHolderKt.b(dashboardActivity.H2());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Y1(MutableState mutableState, DashboardActivity dashboardActivity, ScaffoldState scaffoldState, String str) {
        mutableState.setValue(Boolean.FALSE);
        BuildersKt__Builders_commonKt.d(LifecycleOwnerKt.a(dashboardActivity), null, null, new DashboardActivity$RootCompose$4$1$1(scaffoldState, str, null), 3, null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Z1(Function1 function1, DashboardActivity dashboardActivity, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "<unused var>");
        Intrinsics.checkNotNullParameter(event, "event");
        if (event == Lifecycle.Event.ON_RESUME) {
            function1.invoke(DashboardViewEvent.OnDashboardResumed.f99244a);
            dashboardActivity.A2();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit a2(DashboardActivity dashboardActivity, PaddingValues paddingValues, int i3, Composer composer, int i4) {
        dashboardActivity.c0(paddingValues, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    private static final Boolean b2(State state) {
        return (Boolean) state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit c2(DashboardActivity dashboardActivity) {
        ExternalLinksHelper.f(ExternalLinksHelper.f127866a, dashboardActivity, false, null, 3, null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit d2(UnlockAllAppsViewModel unlockAllAppsViewModel, MutableState mutableState, ActivityResult result) {
        Intrinsics.checkNotNullParameter(result, "result");
        if (result.d() == -1) {
            unlockAllAppsViewModel.d1();
            mutableState.setValue(Boolean.TRUE);
        }
        return Unit.f139807a;
    }

    private final void e2(final NavHostController navHostController, final Function1 function1, final MutableState mutableState, final MutableState mutableState2, Composer composer, final int i3) {
        NavHostController navHostController2;
        int i4;
        DashboardActivity dashboardActivity;
        Composer composerK = composer.k(1241722295);
        if ((i3 & 6) == 0) {
            navHostController2 = navHostController;
            i4 = (composerK.I(navHostController2) ? 4 : 2) | i3;
        } else {
            navHostController2 = navHostController;
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(function1) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.Z(mutableState) ? 256 : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            i4 |= composerK.Z(mutableState2) ? 2048 : 1024;
        }
        if ((i3 & 24576) == 0) {
            dashboardActivity = this;
            i4 |= composerK.I(dashboardActivity) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        } else {
            dashboardActivity = this;
        }
        if (composerK.r((i4 & 9363) != 9362, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1241722295, i4, -1, "cz.mobilesoft.coreblock.scene.dashboard.DashboardActivity.StrictModeSuggestionBottomSheet (DashboardActivity.kt:945)");
            }
            long jI = ComposeColorsKt.j(composerK, 0).i();
            long jP = ComposeColorsKt.j(composerK, 0).p();
            int i5 = R.drawable.c6;
            int i6 = R.string.G4;
            int i7 = R.string.pd;
            int i8 = ((Boolean) mutableState.getValue()).booleanValue() ? R.string.Dk : R.string.kl;
            float fG = Dp.g(16);
            int i9 = i4 & 112;
            boolean z2 = (i9 == 32) | ((i4 & 896) == 256) | ((i4 & 7168) == 2048);
            Object objG = composerK.G();
            if (z2 || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.dashboard.d2
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return DashboardActivity.f2(mutableState, function1, mutableState2);
                    }
                };
                composerK.w(objG);
            }
            dashboardActivity.k2(navHostController2, function1, mutableState2, jI, jP, i5, i6, i7, i8, fG, (Function0) objG, composerK, (i4 & 14) | 805306368 | i9 | ((i4 >> 3) & 896), (i4 >> 9) & 112);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.dashboard.e2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DashboardActivity.g2(this.f100781a, navHostController, function1, mutableState, mutableState2, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit f2(MutableState mutableState, Function1 function1, MutableState mutableState2) {
        if (((Boolean) mutableState.getValue()).booleanValue()) {
            function1.invoke(DashboardViewEvent.OnStrictModeSuggestionNeverShowAgainClicked.f99252a);
            AnswersHelper.f128199a.J7();
        } else {
            AnswersHelper.f128199a.I7();
        }
        mutableState2.setValue(Boolean.FALSE);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g2(DashboardActivity dashboardActivity, NavHostController navHostController, Function1 function1, MutableState mutableState, MutableState mutableState2, int i3, Composer composer, int i4) {
        dashboardActivity.e2(navHostController, function1, mutableState, mutableState2, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    private final void h2(final NavHostController navHostController, final Function1 function1, final MutableState mutableState, Composer composer, final int i3) {
        int i4;
        Function1 function12;
        DashboardActivity dashboardActivity;
        Composer composerK = composer.k(550351743);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(navHostController) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            function12 = function1;
            i4 |= composerK.I(function12) ? 32 : 16;
        } else {
            function12 = function1;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.Z(mutableState) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            dashboardActivity = this;
            i4 |= composerK.I(dashboardActivity) ? 2048 : 1024;
        } else {
            dashboardActivity = this;
        }
        if (composerK.r((i4 & 1171) != 1170, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(550351743, i4, -1, "cz.mobilesoft.coreblock.scene.dashboard.DashboardActivity.StrictModeSuggestionSchedulePausedBottomSheet (DashboardActivity.kt:919)");
            }
            final Context context = (Context) composerK.q(AndroidCompositionLocals_androidKt.g());
            long jC = ComposeColorsKt.j(composerK, 0).C();
            long jQ0 = ComposeColorsKt.j(composerK, 0).q0();
            int i5 = R.drawable.W;
            int i6 = R.string.An;
            boolean z2 = true;
            int i7 = R.string.zn;
            int i8 = R.string.Ff;
            float fG = Dp.g(24);
            int i9 = i4 & 896;
            if (i9 != 256) {
                z2 = false;
            }
            boolean zI = z2 | composerK.I(context);
            Object objG = composerK.G();
            if (zI || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.dashboard.f2
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return DashboardActivity.i2(mutableState, context);
                    }
                };
                composerK.w(objG);
            }
            dashboardActivity.k2(navHostController, function12, mutableState, jC, jQ0, i5, i6, i7, i8, fG, (Function0) objG, composerK, (i4 & 14) | 805306368 | (i4 & 112) | i9, (i4 >> 6) & 112);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.dashboard.g2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DashboardActivity.j2(this.f100802a, navHostController, function1, mutableState, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i2(MutableState mutableState, Context context) {
        mutableState.setValue(Boolean.FALSE);
        context.startActivity(SettingsActivity.Companion.b(SettingsActivity.f108043h, context, SettingsScreenType.OVERVIEW, false, 4, null));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j2(DashboardActivity dashboardActivity, NavHostController navHostController, Function1 function1, MutableState mutableState, int i3, Composer composer, int i4) {
        dashboardActivity.h2(navHostController, function1, mutableState, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k1(NavHostController navHostController, boolean z2, final DashboardViewState dashboardViewState, final DashboardActivity dashboardActivity, final Function1 function1, RowScope rowScope, Composer composer, int i3) {
        long jQ;
        MutableState mutableState;
        NavDestination navDestinationD;
        final NavHostController navHostController2 = navHostController;
        RowScope BottomNavigation = rowScope;
        Intrinsics.checkNotNullParameter(BottomNavigation, "$this$BottomNavigation");
        int i4 = (i3 & 6) == 0 ? i3 | (composer.Z(BottomNavigation) ? 4 : 2) : i3;
        int i5 = 0;
        boolean z3 = true;
        if (composer.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-2024797463, i4, -1, "cz.mobilesoft.coreblock.scene.dashboard.DashboardActivity.BottomNavigationBar.<anonymous> (DashboardActivity.kt:814)");
            }
            NavBackStackEntry navBackStackEntryL1 = l1(NavHostControllerKt.a(navHostController2, composer, 0));
            String strT = (navBackStackEntryL1 == null || (navDestinationD = navBackStackEntryL1.d()) == null) ? null : navDestinationD.t();
            Object objG = composer.G();
            if (objG == Composer.f23746a.a()) {
                objG = SnapshotStateKt__SnapshotStateKt.e(0L, null, 2, null);
                composer.w(objG);
            }
            final MutableState mutableState2 = (MutableState) objG;
            Ref.BooleanRef booleanRef = new Ref.BooleanRef();
            booleanRef.f140137a = z2;
            composer.a0(-210162663);
            for (final NavBarItem navBarItem : dashboardViewState.c()) {
                final boolean zAreEqual = Intrinsics.areEqual(strT, navBarItem.c());
                if (zAreEqual) {
                    composer.a0(774992217);
                    booleanRef.f140137a = z3;
                    jQ = ComposeColorsKt.j(composer, i5).b();
                    composer.U();
                } else {
                    composer.a0(775094207);
                    jQ = ComposeColorsKt.j(composer, i5).q();
                    composer.U();
                }
                final long j3 = jQ;
                boolean zI = composer.I(dashboardActivity) | composer.I(navHostController2) | composer.Z(navBarItem) | composer.Z(function1);
                Object objG2 = composer.G();
                if (zI || objG2 == Composer.f23746a.a()) {
                    Object obj = new Function0() { // from class: cz.mobilesoft.coreblock.scene.dashboard.u2
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return DashboardActivity.o1(this.f101562a, navHostController2, navBarItem, function1, mutableState2);
                        }
                    };
                    mutableState = mutableState2;
                    composer.w(obj);
                    objG2 = obj;
                } else {
                    mutableState = mutableState2;
                }
                BottomNavigationKt.c(BottomNavigation, zAreEqual, (Function0) objG2, ComposableLambdaKt.e(199109544, z3, new Function2() { // from class: cz.mobilesoft.coreblock.scene.dashboard.v2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj2, Object obj3) {
                        return DashboardActivity.p1(navBarItem, zAreEqual, dashboardViewState, j3, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composer, 54), null, false, ComposableLambdaKt.e(506540523, z3, new Function2() { // from class: cz.mobilesoft.coreblock.scene.dashboard.w2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj2, Object obj3) {
                        return DashboardActivity.q1(navBarItem, j3, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composer, 54), false, null, 0L, 0L, composer, (i4 & 14) | 1575936, 0, 984);
                navHostController2 = navHostController;
                BottomNavigation = rowScope;
                strT = strT;
                z3 = z3;
                i4 = i4;
                mutableState2 = mutableState;
                booleanRef = booleanRef;
                i5 = 0;
            }
            String str = strT;
            Ref.BooleanRef booleanRef2 = booleanRef;
            composer.U();
            if (str != null) {
                composer.a0(2079412275);
                EffectsKt.g(Boolean.valueOf(booleanRef2.f140137a), new DashboardActivity$BottomNavigationBar$1$2(booleanRef2, dashboardActivity, navHostController, function1, null), composer, 0);
            } else {
                composer.a0(2036893977);
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

    private final void k2(final NavHostController navHostController, final Function1 function1, final MutableState mutableState, final long j3, final long j4, final int i3, final int i4, final int i5, int i6, final float f3, final Function0 function0, Composer composer, final int i7, final int i8) {
        int i9;
        int i10;
        int i11;
        Composer composerK = composer.k(1588229346);
        if ((i7 & 6) == 0) {
            i9 = (composerK.I(navHostController) ? 4 : 2) | i7;
        } else {
            i9 = i7;
        }
        if ((i7 & 48) == 0) {
            i9 |= composerK.I(function1) ? 32 : 16;
        }
        if ((i7 & 384) == 0) {
            i9 |= composerK.Z(mutableState) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i7 & 3072) == 0) {
            i9 |= composerK.f(j3) ? 2048 : 1024;
        }
        if ((i7 & 24576) == 0) {
            i9 |= composerK.f(j4) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        }
        if ((i7 & 196608) == 0) {
            i9 |= composerK.e(i3) ? 131072 : NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
        }
        if ((i7 & 1572864) == 0) {
            i9 |= composerK.e(i4) ? 1048576 : 524288;
        }
        if ((i7 & 12582912) == 0) {
            i9 |= composerK.e(i5) ? 8388608 : 4194304;
        }
        if ((i7 & 100663296) == 0) {
            i9 |= composerK.e(i6) ? 67108864 : 33554432;
        }
        if ((i7 & 805306368) == 0) {
            i9 |= composerK.c(f3) ? 536870912 : 268435456;
        }
        if ((i8 & 6) == 0) {
            i10 = i8 | (composerK.I(function0) ? 4 : 2);
        } else {
            i10 = i8;
        }
        if ((i8 & 48) == 0) {
            i10 |= composerK.I(this) ? 32 : 16;
        }
        int i12 = i10;
        if (composerK.r(((i9 & 306783379) == 306783378 && (i12 & 19) == 18) ? false : true, i9 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1588229346, i9, i12, "cz.mobilesoft.coreblock.scene.dashboard.DashboardActivity.StrictModeSuggestionSheetContent (DashboardActivity.kt:987)");
            }
            Modifier.Companion companion = Modifier.b8;
            Modifier modifierD = WindowInsetsPaddingKt.d(BackgroundKt.d(SizeKt.h(companion, 0.0f, 1, null), ComposeColorsKt.j(composerK, 0).X(), null, 2, null), WindowInsets_androidKt.b(WindowInsets.f7172a, composerK, 6));
            Arrangement.Vertical verticalH = Arrangement.f6574a.h();
            Alignment.Companion companion2 = Alignment.f25072a;
            MeasurePolicy measurePolicyA = ColumnKt.a(verticalH, companion2.k(), composerK, 0);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierD);
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
            Updater.e(composerA, measurePolicyA, companion3.e());
            Updater.e(composerA, compositionLocalMapU, companion3.g());
            Function2 function2B = companion3.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion3.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            float f4 = 16;
            SpacerKt.a(SizeKt.i(companion, Dp.g(f4)), composerK, 6);
            IconCircleBackgroundKt.c(columnScopeInstance.c(companion, companion2.g()), Dp.g(40), 0.0f, VectorResources_androidKt.b(ImageVector.f26323k, i3, composerK, ((i9 >> 12) & 112) | 6), j4, j3, null, composerK, (57344 & i9) | 48 | ((i9 << 6) & 458752), 68);
            SpacerKt.a(SizeKt.i(companion, Dp.g(f4)), composerK, 6);
            TextKt.c(StringResources_androidKt.b(i4, composerK, (i9 >> 18) & 14), columnScopeInstance.c(companion, companion2.g()), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composerK, 0).f(), composerK, 0, 0, 65532);
            SpacerKt.a(SizeKt.i(companion, Dp.g(f4)), composerK, 6);
            String strB = StringResources_androidKt.b(i5, composerK, (i9 >> 21) & 14);
            TextStyle textStyleB = ComposeTypographyKt.g(composerK, 0).b();
            long jQ = ComposeColorsKt.j(composerK, 0).q();
            TextAlign.Companion companion4 = TextAlign.f29616b;
            TextKt.c(strB, PaddingKt.k(columnScopeInstance.c(companion, companion2.g()), Dp.g(20), 0.0f, 2, null), jQ, 0L, null, null, null, 0L, null, TextAlign.h(companion4.a()), 0L, 0, false, 0, 0, null, textStyleB, composerK, 0, 0, 65016);
            composerK = composerK;
            SpacerKt.a(SizeKt.i(companion, f3), composerK, 0);
            Modifier modifierI = SizeKt.I(SizeKt.h(companion, 0.0f, 1, null), companion2.g(), false, 2, null);
            MeasurePolicy measurePolicyG = BoxKt.g(companion2.o(), false);
            int iA2 = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU2 = composerK.u();
            Modifier modifierF2 = ComposedModifierKt.f(composerK, modifierI);
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
            Updater.e(composerA2, measurePolicyG, companion3.e());
            Updater.e(composerA2, compositionLocalMapU2, companion3.g());
            Function2 function2B2 = companion3.b();
            if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                composerA2.w(Integer.valueOf(iA2));
                composerA2.p(Integer.valueOf(iA2), function2B2);
            }
            Updater.e(composerA2, modifierF2, companion3.f());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
            ButtonType.SmallRound smallRound = new ButtonType.SmallRound(null, null, StringResources_androidKt.b(R.string.Gw, composerK, 0), null, false, 27, null);
            ButtonColor.Accent accent = new ButtonColor.Accent(true, null, false, null, 14, null);
            boolean zI = composerK.I(this) | ((i9 & 896) == 256) | composerK.I(navHostController) | ((i9 & 112) == 32);
            Object objG = composerK.G();
            if (zI || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.dashboard.a3
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return DashboardActivity.l2(mutableState, this, navHostController, function1);
                    }
                };
                composerK.w(objG);
            }
            ComposeButtonsKt.i0(null, smallRound, accent, (Function0) objG, composerK, 0, 1);
            composerK.y();
            SpacerKt.a(SizeKt.i(companion, f3), composerK, 0);
            i11 = i6;
            TextKt.c(StringResources_androidKt.b(i11, composerK, (i9 >> 24) & 14), ClickableKt.f(columnScopeInstance.c(companion, companion2.g()), false, null, null, function0, 5, null), ComposeColorsKt.j(composerK, 0).q(), 0L, null, null, null, 0L, null, TextAlign.h(companion4.a()), 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composerK, 0).j(), composerK, 0, 0, 65016);
            SpacerKt.a(SizeKt.i(companion, f3), composerK, 0);
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            i11 = i6;
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            final int i13 = i11;
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.dashboard.b3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DashboardActivity.m2(this.f99504a, navHostController, function1, mutableState, j3, j4, i3, i4, i5, i13, f3, function0, i7, i8, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final NavBackStackEntry l1(State state) {
        return (NavBackStackEntry) state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l2(MutableState mutableState, DashboardActivity dashboardActivity, NavHostController navHostController, Function1 function1) {
        AnswersHelper.f128199a.K7();
        mutableState.setValue(Boolean.FALSE);
        dashboardActivity.M2(navHostController, NavBarItem.StrictMode.f99179i, function1);
        return Unit.f139807a;
    }

    private static final long m1(MutableState mutableState) {
        return ((Number) mutableState.getValue()).longValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m2(DashboardActivity dashboardActivity, NavHostController navHostController, Function1 function1, MutableState mutableState, long j3, long j4, int i3, int i4, int i5, int i6, float f3, Function0 function0, int i7, int i8, Composer composer, int i9) {
        dashboardActivity.k2(navHostController, function1, mutableState, j3, j4, i3, i4, i5, i6, f3, function0, composer, RecomposeScopeImplKt.a(i7 | 1), RecomposeScopeImplKt.a(i8));
        return Unit.f139807a;
    }

    private static final void n1(MutableState mutableState, long j3) {
        mutableState.setValue(Long.valueOf(j3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o1(DashboardActivity dashboardActivity, NavHostController navHostController, NavBarItem navBarItem, Function1 function1, MutableState mutableState) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - m1(mutableState) > 500) {
            n1(mutableState, jCurrentTimeMillis);
            dashboardActivity.M2(navHostController, navBarItem, function1);
            if (Intrinsics.areEqual(navBarItem, NavBarItem.Blocking.f99175i)) {
                AnswersHelper.f128199a.V7();
            } else if (Intrinsics.areEqual(navBarItem, NavBarItem.Profile.f99177i)) {
                AnswersHelper.f128199a.X7();
            } else if (Intrinsics.areEqual(navBarItem, NavBarItem.Insights.f99176i)) {
                AnswersHelper.f128199a.W7();
            } else if (Intrinsics.areEqual(navBarItem, NavBarItem.StrictMode.f99179i)) {
                AnswersHelper.f128199a.Y7();
            }
            AnswersHelper.f128199a.m5(navBarItem.c());
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p1(NavBarItem navBarItem, boolean z2, DashboardViewState dashboardViewState, long j3, Composer composer, int i3) {
        Integer numB;
        Integer numA;
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(199109544, i3, -1, "cz.mobilesoft.coreblock.scene.dashboard.DashboardActivity.BottomNavigationBar.<anonymous>.<anonymous>.<anonymous> (DashboardActivity.kt:847)");
            }
            Modifier.Companion companion = Modifier.b8;
            float f3 = 2;
            Modifier modifierM = PaddingKt.m(companion, 0.0f, 0.0f, 0.0f, Dp.g(f3), 7, null);
            MeasurePolicy measurePolicyG = BoxKt.g(Alignment.f25072a.o(), false);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, modifierM);
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
            Updater.e(composerA, measurePolicyG, companion2.e());
            Updater.e(composerA, compositionLocalMapU, companion2.g());
            Function2 function2B = companion2.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion2.f());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
            IconKt.b(VectorResources_androidKt.b(ImageVector.f26323k, Intrinsics.areEqual(navBarItem, NavBarItem.StrictMode.f99179i) ? z2 ? (!dashboardViewState.m() || (numA = navBarItem.a()) == null) ? navBarItem.d() : numA.intValue() : (!dashboardViewState.m() || (numB = navBarItem.b()) == null) ? navBarItem.f() : numB.intValue() : z2 ? navBarItem.d() : navBarItem.f(), composer, 6), StringResources_androidKt.b(navBarItem.e(), composer, 0), PaddingKt.k(companion, Dp.g(f3), 0.0f, 2, null), j3, composer, 384, 0);
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
    public static final Unit q1(NavBarItem navBarItem, long j3, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(506540523, i3, -1, "cz.mobilesoft.coreblock.scene.dashboard.DashboardActivity.BottomNavigationBar.<anonymous>.<anonymous>.<anonymous> (DashboardActivity.kt:877)");
            }
            Alignment.Companion companion = Alignment.f25072a;
            Alignment alignmentE = companion.e();
            Modifier.Companion companion2 = Modifier.b8;
            MeasurePolicy measurePolicyG = BoxKt.g(alignmentE, false);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, companion2);
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
            Updater.e(composerA, measurePolicyG, companion3.e());
            Updater.e(composerA, compositionLocalMapU, companion3.g());
            Function2 function2B = companion3.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion3.f());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
            MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.b(), companion.g(), composer, 54);
            int iA2 = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU2 = composer.u();
            Modifier modifierF2 = ComposedModifierKt.f(composer, companion2);
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
            Updater.e(composerA2, measurePolicyA, companion3.e());
            Updater.e(composerA2, compositionLocalMapU2, companion3.g());
            Function2 function2B2 = companion3.b();
            if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                composerA2.w(Integer.valueOf(iA2));
                composerA2.p(Integer.valueOf(iA2), function2B2);
            }
            Updater.e(composerA2, modifierF2, companion3.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            TextKt.c(StringResources_androidKt.b(navBarItem.e(), composer, 0), null, j3, 0L, null, null, null, 0L, null, null, 0L, TextOverflow.f29661b.b(), false, 1, 0, null, TextStyle.e(ComposeTypographyKt.g(composer, 0).j(), 0L, TextUnitKt.i(11), null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, TextUnitKt.i(17), null, null, null, 0, 0, null, 16646141, null), composer, 0, 3120, 55290);
            composer.y();
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
    public static final Unit r1(DashboardActivity dashboardActivity, NavHostController navHostController, DashboardViewState dashboardViewState, Function1 function1, boolean z2, int i3, int i4, Composer composer, int i5) {
        dashboardActivity.j1(navHostController, dashboardViewState, function1, z2, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit t1(DashboardActivity dashboardActivity, DashboardViewModel dashboardViewModel, NavHostController navHostController, MutableState mutableState, MutableState mutableState2, MutableState mutableState3, Function1 function1, int i3, Composer composer, int i4) {
        dashboardActivity.s1(dashboardViewModel, navHostController, mutableState, mutableState2, mutableState3, function1, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    private final void u1(final NavHostController navHostController, final DashboardViewState dashboardViewState, final State state, final NavBarItem navBarItem, final Function1 function1, final ScaffoldState scaffoldState, final MutableState mutableState, final MutableState mutableState2, final MutableState mutableState3, final Flow flow, final boolean z2, Composer composer, final int i3, final int i4) {
        final NavHostController navHostController2;
        int i5;
        State state2;
        NavBarItem navBarItem2;
        Function1 function12;
        ScaffoldState scaffoldState2;
        int i6;
        final MutableState mutableState4;
        Composer composer2;
        DashboardActivity dashboardActivity;
        Composer composerK = composer.k(1132380391);
        if ((i3 & 6) == 0) {
            navHostController2 = navHostController;
            i5 = (composerK.I(navHostController2) ? 4 : 2) | i3;
        } else {
            navHostController2 = navHostController;
            i5 = i3;
        }
        if ((i3 & 48) == 0) {
            i5 |= composerK.Z(dashboardViewState) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            state2 = state;
            i5 |= composerK.Z(state2) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        } else {
            state2 = state;
        }
        if ((i3 & 3072) == 0) {
            navBarItem2 = navBarItem;
            i5 |= composerK.Z(navBarItem2) ? 2048 : 1024;
        } else {
            navBarItem2 = navBarItem;
        }
        if ((i3 & 24576) == 0) {
            function12 = function1;
            i5 |= composerK.I(function12) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        } else {
            function12 = function1;
        }
        if ((196608 & i3) == 0) {
            scaffoldState2 = scaffoldState;
            i5 |= composerK.Z(scaffoldState2) ? 131072 : NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
        } else {
            scaffoldState2 = scaffoldState;
        }
        if ((i3 & 1572864) == 0) {
            i5 |= composerK.Z(mutableState) ? 1048576 : 524288;
        }
        if ((i3 & 12582912) == 0) {
            i5 |= composerK.Z(mutableState2) ? 8388608 : 4194304;
        }
        if ((i3 & 100663296) == 0) {
            i5 |= composerK.Z(mutableState3) ? 67108864 : 33554432;
        }
        if ((i3 & 805306368) == 0) {
            i5 |= composerK.I(flow) ? 536870912 : 268435456;
        }
        if ((i4 & 6) == 0) {
            i6 = i4 | (composerK.b(z2) ? 4 : 2);
        } else {
            i6 = i4;
        }
        if ((i4 & 48) == 0) {
            i6 |= composerK.I(this) ? 32 : 16;
        }
        int i7 = i6;
        if (composerK.r(((i5 & 306783379) == 306783378 && (i7 & 19) == 18) ? false : true, i5 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1132380391, i5, i7, "cz.mobilesoft.coreblock.scene.dashboard.DashboardActivity.DashboardScreen (DashboardActivity.kt:512)");
            }
            final Context context = (Context) composerK.q(AndroidCompositionLocals_androidKt.g());
            int i8 = i5;
            final Function1 function13 = function12;
            final NavBarItem navBarItem3 = navBarItem2;
            final State state3 = state2;
            final ScaffoldState scaffoldState3 = scaffoldState2;
            ScaffoldKt.a(WindowInsetsPaddingKt.d(Modifier.b8, WindowInsets_androidKt.b(WindowInsets.f7172a, composerK, 6)), scaffoldState, null, ComposableLambdaKt.e(-224913055, true, new Function2() { // from class: cz.mobilesoft.coreblock.scene.dashboard.v1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DashboardActivity.v1(this.f101575a, navHostController2, dashboardViewState, function13, z2, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerK, 54), ComposableSingletons$DashboardActivityKt.f99131a.b(), null, 0, false, null, false, null, 0.0f, 0L, 0L, 0L, 0L, 0L, ComposableLambdaKt.e(1692212841, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.dashboard.w1
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return DashboardActivity.w1(state3, this, function1, dashboardViewState, context, navHostController, navBarItem3, scaffoldState3, flow, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerK, 54), composerK, ((i8 >> 12) & 112) | 27648, 12582912, 131044);
            composer2 = composerK;
            boolean zF = dashboardViewState.e().f();
            EnterTransition enterTransitionA = EnterTransition.f3563a.a();
            Object objG = composer2.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG == companion.a()) {
                objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.dashboard.x1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return DashboardActivity.E1((KeyframesSpec.KeyframesSpecConfig) obj);
                    }
                };
                composer2.w(objG);
            }
            AnimatedVisibilityKt.j(zF, null, enterTransitionA, EnterExitTransitionKt.q(AnimationSpecKt.f((Function1) objG), 0.0f, 2, null), null, ComposableLambdaKt.e(394905871, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.dashboard.y1
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return DashboardActivity.F1(this.f101618a, dashboardViewState, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer2, 54), composer2, 199680, 18);
            int iK = ColorKt.k(ComposeColorsKt.j(composer2, 0).X());
            int iK2 = ColorKt.k(ComposeColorsKt.j(composer2, 0).e());
            Object value = mutableState3.getValue();
            boolean zI = composer2.I(context);
            int i9 = i8 & 234881024;
            boolean zE = zI | (i9 == 67108864) | composer2.e(iK) | composer2.e(iK2);
            Object objG2 = composer2.G();
            if (zE || objG2 == companion.a()) {
                DashboardActivity$DashboardScreen$5$1 dashboardActivity$DashboardScreen$5$1 = new DashboardActivity$DashboardScreen$5$1(context, mutableState3, iK, iK2, null);
                composer2.w(dashboardActivity$DashboardScreen$5$1);
                objG2 = dashboardActivity$DashboardScreen$5$1;
            }
            EffectsKt.g(value, (Function2) objG2, composer2, 0);
            if (((Boolean) mutableState3.getValue()).booleanValue()) {
                composer2.a0(2078045495);
                dashboardActivity = this;
                mutableState4 = mutableState3;
                ComposableLambda composableLambdaE = ComposableLambdaKt.e(-564135317, true, new Function4() { // from class: cz.mobilesoft.coreblock.scene.dashboard.z1
                    @Override // kotlin.jvm.functions.Function4
                    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                        return DashboardActivity.G1(mutableState2, this, navHostController, function1, mutableState3, mutableState, (ColumnScope) obj, (SheetState) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                    }
                }, composer2, 54);
                boolean z3 = i9 == 67108864;
                Object objG3 = composer2.G();
                if (z3 || objG3 == companion.a()) {
                    objG3 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.dashboard.a2
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return DashboardActivity.H1(mutableState4);
                        }
                    };
                    composer2.w(objG3);
                }
                ComposeBottomSheetsKt.f(null, null, false, composableLambdaE, null, (Function0) objG3, composer2, 3072, 23);
            } else {
                dashboardActivity = this;
                mutableState4 = mutableState3;
                composer2.a0(2047714971);
            }
            composer2.U();
            Unit unit = Unit.f139807a;
            boolean zI2 = composer2.I(dashboardActivity);
            Object objG4 = composer2.G();
            if (zI2 || objG4 == companion.a()) {
                objG4 = new DashboardActivity$DashboardScreen$8$1(dashboardActivity, null);
                composer2.w(objG4);
            }
            EffectsKt.g(unit, (Function2) objG4, composer2, 6);
            boolean zI3 = composer2.I(dashboardActivity);
            Object objG5 = composer2.G();
            if (zI3 || objG5 == companion.a()) {
                objG5 = new DashboardActivity$DashboardScreen$9$1(dashboardActivity, null);
                composer2.w(objG5);
            }
            EffectsKt.g(unit, (Function2) objG5, composer2, 6);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            mutableState4 = mutableState3;
            composer2 = composerK;
            composer2.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            final MutableState mutableState5 = mutableState4;
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.dashboard.b2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DashboardActivity.I1(this.f99490a, navHostController, dashboardViewState, state, navBarItem, function1, scaffoldState, mutableState, mutableState2, mutableState5, flow, z2, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit v1(DashboardActivity dashboardActivity, NavHostController navHostController, DashboardViewState dashboardViewState, Function1 function1, boolean z2, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-224913055, i3, -1, "cz.mobilesoft.coreblock.scene.dashboard.DashboardActivity.DashboardScreen.<anonymous> (DashboardActivity.kt:615)");
            }
            dashboardActivity.j1(navHostController, dashboardViewState, function1, z2, composer, 0, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit w1(final State state, final DashboardActivity dashboardActivity, final Function1 function1, DashboardViewState dashboardViewState, final Context context, NavHostController navHostController, NavBarItem navBarItem, ScaffoldState scaffoldState, Flow flow, PaddingValues it, Composer composer, int i3) {
        int i4;
        int i5;
        boolean z2;
        int i6;
        Intrinsics.checkNotNullParameter(it, "it");
        if ((i3 & 6) == 0) {
            i4 = i3 | (composer.Z(it) ? 4 : 2);
        } else {
            i4 = i3;
        }
        if (composer.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1692212841, i4, -1, "cz.mobilesoft.coreblock.scene.dashboard.DashboardActivity.DashboardScreen.<anonymous> (DashboardActivity.kt:523)");
            }
            Modifier.Companion companion = Modifier.b8;
            Alignment.Companion companion2 = Alignment.f25072a;
            MeasurePolicy measurePolicyG = BoxKt.g(companion2.o(), false);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, companion);
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
            Updater.e(composerA, measurePolicyG, companion3.e());
            Updater.e(composerA, compositionLocalMapU, companion3.g());
            Function2 function2B = companion3.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion3.f());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
            dashboardActivity.J1(navHostController, it, navBarItem.c(), dashboardViewState, function1, scaffoldState, flow, composer, (i4 << 3) & 112);
            String strB = null;
            if (Intrinsics.areEqual(dashboardViewState.l(), Boolean.FALSE)) {
                composer.a0(-530355198);
                Modifier modifierK = PaddingKt.k(SizeKt.h(companion, 0.0f, 1, null), Dp.g(16), 0.0f, 2, null);
                MeasurePolicy measurePolicyB = RowKt.b(Arrangement.f6574a.g(), companion2.l(), composer, 0);
                int iA2 = ComposablesKt.a(composer, 0);
                CompositionLocalMap compositionLocalMapU2 = composer.u();
                Modifier modifierF2 = ComposedModifierKt.f(composer, modifierK);
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
                SpacerKt.a(RowScope.c(RowScopeInstance.f7101a, companion, 1.0f, false, 2, null), composer, 0);
                i5 = 2;
                z2 = true;
                i6 = 0;
                TextKt.c("DEV", null, ComposeColorsKt.j(composer, 0).k(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).j(), composer, 6, 0, 65530);
                composer.y();
            } else {
                i5 = 2;
                z2 = true;
                i6 = 0;
                composer.a0(-555242401);
            }
            composer.U();
            composer.y();
            boolean Z = composer.Z((InAppUpdateDialogDTO) state.getValue());
            Object objG = composer.G();
            if (Z || objG == Composer.f23746a.a()) {
                InAppUpdateDialogDTO inAppUpdateDialogDTO = (InAppUpdateDialogDTO) state.getValue();
                if (inAppUpdateDialogDTO != null) {
                    AnswersHelper.f128199a.b2(inAppUpdateDialogDTO.b());
                    Unit unit = Unit.f139807a;
                }
                objG = SnapshotStateKt__SnapshotStateKt.e(Boolean.valueOf(state.getValue() != null ? z2 : i6), null, i5, null);
                composer.w(objG);
            }
            MutableState mutableState = (MutableState) objG;
            String strB2 = StringResources_androidKt.b(R.string.f95807j1, composer, i6);
            InAppUpdateDialogDTO inAppUpdateDialogDTO2 = (InAppUpdateDialogDTO) state.getValue();
            if (inAppUpdateDialogDTO2 == null) {
                composer.a0(-1611562545);
            } else {
                composer.a0(-1611562544);
                strB = StringResources_androidKt.b(inAppUpdateDialogDTO2.a(), composer, i6);
            }
            composer.U();
            String str = strB;
            String strB3 = StringResources_androidKt.b(R.string.f95802i1, composer, i6);
            boolean zI = composer.I(dashboardActivity);
            Object objG2 = composer.G();
            if (zI || objG2 == Composer.f23746a.a()) {
                objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.dashboard.h2
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return DashboardActivity.x1(this.f100815a);
                    }
                };
                composer.w(objG2);
            }
            Function0 function0 = (Function0) objG2;
            String strB4 = StringResources_androidKt.b(R.string.O4, composer, i6);
            boolean Z2 = composer.Z(state) | composer.Z(function1);
            Object objG3 = composer.G();
            if (Z2 || objG3 == Composer.f23746a.a()) {
                objG3 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.dashboard.i2
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return DashboardActivity.y1(state, function1);
                    }
                };
                composer.w(objG3);
            }
            ComposeDialogsKt.x0(mutableState, strB2, str, null, strB3, 0L, false, function0, strB4, 0L, (Function0) objG3, composer, 0, 0, 616);
            if (dashboardViewState.h()) {
                composer.a0(-1610547759);
                boolean Z3 = composer.Z(function1);
                Object objG4 = composer.G();
                if (Z3 || objG4 == Composer.f23746a.a()) {
                    objG4 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.dashboard.j2
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return DashboardActivity.z1(function1);
                        }
                    };
                    composer.w(objG4);
                }
                Function0 function02 = (Function0) objG4;
                boolean zI2 = composer.I(context) | composer.Z(function1);
                Object objG5 = composer.G();
                if (zI2 || objG5 == Composer.f23746a.a()) {
                    objG5 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.dashboard.k2
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return DashboardActivity.A1(context, function1);
                        }
                    };
                    composer.w(objG5);
                }
                Function0 function03 = (Function0) objG5;
                boolean zI3 = composer.I(context) | composer.Z(function1);
                Object objG6 = composer.G();
                if (zI3 || objG6 == Composer.f23746a.a()) {
                    objG6 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.dashboard.l2
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return DashboardActivity.B1(context, function1);
                        }
                    };
                    composer.w(objG6);
                }
                ComposeDialogsKt.U0(function02, function03, (Function0) objG6, composer, i6);
            } else {
                composer.a0(-1637679207);
            }
            composer.U();
            if (dashboardViewState.i()) {
                composer.a0(-1609140607);
                boolean Z4 = composer.Z(function1);
                Object objG7 = composer.G();
                if (Z4 || objG7 == Composer.f23746a.a()) {
                    objG7 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.dashboard.m2
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return DashboardActivity.C1(function1);
                        }
                    };
                    composer.w(objG7);
                }
                Function0 function04 = (Function0) objG7;
                boolean zI4 = composer.I(context) | composer.I(dashboardActivity);
                Object objG8 = composer.G();
                if (zI4 || objG8 == Composer.f23746a.a()) {
                    objG8 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.dashboard.o2
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return DashboardActivity.D1(context, dashboardActivity);
                        }
                    };
                    composer.w(objG8);
                }
                ComposeDialogsKt.p1(function04, (Function0) objG8, composer, i6, i6);
            } else {
                composer.a0(-1637679207);
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
    public static final Unit x1(DashboardActivity dashboardActivity) {
        dashboardActivity.startActivity(InAppUpdateActivity.f102432h.a(dashboardActivity, "dashboard"));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit y1(State state, Function1 function1) {
        InAppUpdateDialogDTO inAppUpdateDialogDTO = (InAppUpdateDialogDTO) state.getValue();
        if (inAppUpdateDialogDTO != null) {
            AnswersHelper.f128199a.a2(inAppUpdateDialogDTO.b());
        }
        function1.invoke(DashboardViewEvent.InAppUpdateDialogClosed.f99243a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit z1(Function1 function1) {
        function1.invoke(DashboardViewEvent.OnRegistrationDialogClosed.f99249a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List z2() {
        return CollectionsKt.listOf((Object[]) new NavBarItem[]{NavBarItem.Blocking.f99175i, NavBarItem.StrictMode.f99179i, NavBarItem.Insights.f99176i, NavBarItem.Profile.f99177i});
    }

    public final void J1(final NavHostController navController, final PaddingValues paddingValues, final String startDestination, final DashboardViewState viewState, final Function1 onEvent, final ScaffoldState scaffoldState, final Flow stateFlow, Composer composer, final int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(navController, "navController");
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        Intrinsics.checkNotNullParameter(startDestination, "startDestination");
        Intrinsics.checkNotNullParameter(viewState, "viewState");
        Intrinsics.checkNotNullParameter(onEvent, "onEvent");
        Intrinsics.checkNotNullParameter(scaffoldState, "scaffoldState");
        Intrinsics.checkNotNullParameter(stateFlow, "stateFlow");
        Composer composerK = composer.k(923781042);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(navController) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.Z(paddingValues) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.Z(startDestination) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 24576) == 0) {
            i4 |= composerK.I(onEvent) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        }
        if ((196608 & i3) == 0) {
            i4 |= composerK.Z(scaffoldState) ? 131072 : NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
        }
        if ((1572864 & i3) == 0) {
            i4 |= composerK.I(stateFlow) ? 1048576 : 524288;
        }
        if ((12582912 & i3) == 0) {
            i4 |= composerK.I(this) ? 8388608 : 4194304;
        }
        int i5 = i4;
        if (composerK.r((4792467 & i5) != 4792466, i5 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(923781042, i5, -1, "cz.mobilesoft.coreblock.scene.dashboard.DashboardActivity.NavigationHost (DashboardActivity.kt:751)");
            }
            Modifier modifierH = PaddingKt.h(Modifier.b8, paddingValues);
            boolean zI = ((57344 & i5) == 16384) | composerK.I(this) | composerK.I(navController) | composerK.I(stateFlow) | ((458752 & i5) == 131072);
            Object objG = composerK.G();
            if (zI || objG == Composer.f23746a.a()) {
                Function1 function1 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.dashboard.x2
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return DashboardActivity.K1(onEvent, this, navController, stateFlow, scaffoldState, (NavGraphBuilder) obj);
                    }
                };
                composerK.w(function1);
                objG = function1;
            }
            NavHostKt.v(navController, startDestination, modifierH, null, null, null, null, null, null, null, (Function1) objG, composerK, (i5 & 14) | ((i5 >> 3) & 112), 0, 1016);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.dashboard.z2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DashboardActivity.S1(this.f101632a, navController, paddingValues, startDestination, viewState, onEvent, scaffoldState, stateFlow, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r20v2 */
    /* JADX WARN: Type inference failed for: r20v3, types: [androidx.lifecycle.viewmodel.CreationExtras] */
    /* JADX WARN: Type inference failed for: r20v4 */
    /* JADX WARN: Type inference failed for: r3v22 */
    /* JADX WARN: Type inference failed for: r3v23, types: [androidx.navigation.NavBackStackEntry] */
    /* JADX WARN: Type inference failed for: r3v24 */
    /* JADX WARN: Type inference failed for: r3v25 */
    /* JADX WARN: Type inference failed for: r3v45 */
    /* JADX WARN: Type inference failed for: r3v46 */
    /* JADX WARN: Type inference failed for: r8v6 */
    /* JADX WARN: Type inference failed for: r8v7, types: [androidx.lifecycle.LifecycleOwner, kotlin.coroutines.Continuation] */
    /* JADX WARN: Type inference failed for: r8v8 */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // cz.mobilesoft.coreblock.base.activity.BaseComposeActivity
    public void c0(final PaddingValues paddingValues, Composer composer, final int i3) {
        int i4;
        final DashboardActivity dashboardActivity;
        int i5;
        int i6;
        DashboardViewModel dashboardViewModel;
        int i7;
        NavHostController navHostController;
        final Function1 function1;
        final ScaffoldState scaffoldState;
        MutableState mutableState;
        MutableState mutableState2;
        MutableState mutableState3;
        ?? r8;
        final MutableState mutableState4;
        Bundle bundleB;
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        Composer composerK = composer.k(-1879673556);
        if ((i3 & 48) == 0) {
            i4 = i3 | (composerK.I(this) ? 32 : 16);
        } else {
            i4 = i3;
        }
        boolean z2 = false;
        if (composerK.r((i4 & 17) != 16, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1879673556, i4, -1, "cz.mobilesoft.coreblock.scene.dashboard.DashboardActivity.RootCompose (DashboardActivity.kt:292)");
            }
            Object objQ = composerK.q(AndroidCompositionLocals_androidKt.g());
            Intrinsics.checkNotNull(objQ, "null cannot be cast to non-null type androidx.activity.ComponentActivity");
            ComponentActivity componentActivity = (ComponentActivity) objQ;
            boolean zI = composerK.I(this);
            Object objG = composerK.G();
            if (zI || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.dashboard.l3
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return DashboardActivity.X1(this.f100854a);
                    }
                };
                composerK.w(objG);
            }
            composerK.F(-101221098);
            CreationExtras creationExtrasA = ViewModelComposeExtKt.a(componentActivity, composerK, 8);
            GlobalContext globalContext = GlobalContext.f145907a;
            Scope scopeD = globalContext.get().j().d();
            composerK.F(-1072256281);
            KClass kClassB = Reflection.b(DashboardViewModel.class);
            ViewModelStore viewModelStore = componentActivity.getViewModelStore();
            Intrinsics.checkNotNullExpressionValue(viewModelStore, "viewModelStoreOwner.viewModelStore");
            ViewModel viewModelA = GetViewModelKt.a(kClassB, viewModelStore, null, creationExtrasA, null, scopeD, (Function0) objG);
            composerK.Y();
            composerK.Y();
            DashboardViewModel dashboardViewModel2 = (DashboardViewModel) viewModelA;
            Object objG2 = composerK.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG2 == companion.a()) {
                objG2 = SnapshotStateKt__SnapshotStateKt.e(Boolean.FALSE, null, 2, null);
                composerK.w(objG2);
            }
            MutableState mutableState5 = (MutableState) objG2;
            Object objG3 = composerK.G();
            if (objG3 == companion.a()) {
                objG3 = SnapshotStateKt__SnapshotStateKt.e(Boolean.FALSE, null, 2, null);
                composerK.w(objG3);
            }
            MutableState mutableState6 = (MutableState) objG3;
            Object objG4 = composerK.G();
            if (objG4 == companion.a()) {
                objG4 = SnapshotStateKt__SnapshotStateKt.e(Boolean.FALSE, null, 2, null);
                composerK.w(objG4);
            }
            MutableState mutableState7 = (MutableState) objG4;
            NavHostController navHostControllerB = NavHostControllerKt.b(new Navigator[0], composerK, 0);
            DashboardViewState dashboardViewState = (DashboardViewState) FlowExtKt.m(dashboardViewModel2, composerK, 0);
            Flow flowM0 = dashboardViewModel2.M0();
            State stateC = androidx.lifecycle.compose.FlowExtKt.c(dashboardViewModel2.C1(), null, null, null, composerK, 0, 7);
            Function1 function1N = FlowExtKt.n(dashboardViewModel2, composerK, 0);
            ScaffoldState scaffoldStateG = ScaffoldKt.g(null, null, composerK, 0, 3);
            if (dashboardViewState.j() == null) {
                composerK.a0(429652944);
                SplashScreenKt.b(composerK, 0);
                composerK.U();
                dashboardViewModel = dashboardViewModel2;
                mutableState = mutableState5;
                i7 = i4;
                mutableState3 = mutableState6;
                scaffoldState = scaffoldStateG;
                function1 = function1N;
                i6 = 0;
                mutableState2 = mutableState7;
                navHostController = navHostControllerB;
            } else {
                composerK.a0(429730320);
                NavBarItem navBarItemJ = dashboardViewState.j();
                if (((NavBarItem) getIntent().getSerializableExtra("DASHBOARD_START_NAV_ITEM")) != null) {
                    i5 = 0;
                    z2 = true;
                } else {
                    i5 = 0;
                }
                i6 = i5;
                dashboardViewModel = dashboardViewModel2;
                i7 = i4;
                u1(navHostControllerB, dashboardViewState, stateC, navBarItemJ, function1N, scaffoldStateG, mutableState5, mutableState6, mutableState7, flowM0, z2, composerK, 114819072, i4 & 112);
                navHostController = navHostControllerB;
                function1 = function1N;
                scaffoldState = scaffoldStateG;
                mutableState = mutableState5;
                mutableState2 = mutableState7;
                composerK = composerK;
                mutableState3 = mutableState6;
                if ((Intrinsics.areEqual(b2(androidx.lifecycle.compose.FlowExtKt.c(InitHelper.f129486a.r(), null, null, null, composerK, 0, 7)), Boolean.FALSE) && dashboardViewState.f()) || dashboardViewState.g()) {
                    composerK.a0(430704464);
                    boolean zI2 = composerK.I(this);
                    Object objG5 = composerK.G();
                    if (zI2 || objG5 == companion.a()) {
                        objG5 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.dashboard.m3
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return DashboardActivity.c2(this.f100863a);
                            }
                        };
                        composerK.w(objG5);
                    }
                    PirateVersionBottomSheetKt.e((Function0) objG5, composerK, i6);
                } else {
                    composerK.a0(414642806);
                }
                composerK.U();
                composerK.U();
            }
            Composer composer2 = composerK;
            s1(dashboardViewModel, navHostController, mutableState, mutableState2, mutableState3, function1, composer2, ((i7 << 15) & 3670016) | 28032);
            Object objG6 = composer2.G();
            if (objG6 == companion.a()) {
                r8 = 0;
                objG6 = SnapshotStateKt__SnapshotStateKt.e(Boolean.FALSE, null, 2, null);
                composer2.w(objG6);
            } else {
                r8 = 0;
            }
            final MutableState mutableState8 = (MutableState) objG6;
            composer2.F(-101221098);
            ViewModelStoreOwner viewModelStoreOwnerC = LocalViewModelStoreOwner.f40240a.c(composer2, 8);
            if (viewModelStoreOwnerC == null) {
                throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
            }
            CreationExtras creationExtrasA2 = ViewModelComposeExtKt.a(viewModelStoreOwnerC, composer2, 8);
            Scope scopeD2 = globalContext.get().j().d();
            composer2.F(-1072256281);
            ?? r3 = viewModelStoreOwnerC instanceof NavBackStackEntry ? (NavBackStackEntry) viewModelStoreOwnerC : r8;
            ?? A = (r3 == 0 || (bundleB = r3.b()) == null) ? r8 : BundleExtKt.a(bundleB, viewModelStoreOwnerC);
            KClass kClassB2 = Reflection.b(UnlockAllAppsViewModel.class);
            ViewModelStore viewModelStore2 = viewModelStoreOwnerC.getViewModelStore();
            Intrinsics.checkNotNullExpressionValue(viewModelStore2, "viewModelStoreOwner.viewModelStore");
            ViewModel viewModelA2 = GetViewModelKt.a(kClassB2, viewModelStore2, null, A == 0 ? creationExtrasA2 : A, null, scopeD2, null);
            composer2.Y();
            composer2.Y();
            final UnlockAllAppsViewModel unlockAllAppsViewModel = (UnlockAllAppsViewModel) viewModelA2;
            ActivityResultContracts.StartActivityForResult startActivityForResult = new ActivityResultContracts.StartActivityForResult();
            boolean zI3 = composer2.I(unlockAllAppsViewModel);
            Object objG7 = composer2.G();
            if (zI3 || objG7 == companion.a()) {
                objG7 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.dashboard.n3
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return DashboardActivity.d2(unlockAllAppsViewModel, mutableState8, (ActivityResult) obj);
                    }
                };
                composer2.w(objG7);
            }
            ManagedActivityResultLauncher managedActivityResultLauncherA = ActivityResultRegistryKt.a(startActivityForResult, (Function1) objG7, composer2, i6);
            String str = (String) this.f99142l.getValue();
            boolean Z = composer2.Z(str) | composer2.I(managedActivityResultLauncherA) | composer2.I(this) | composer2.I(unlockAllAppsViewModel);
            Object objG8 = composer2.G();
            if (Z || objG8 == companion.a()) {
                DashboardActivity$RootCompose$2$1 dashboardActivity$RootCompose$2$1 = new DashboardActivity$RootCompose$2$1(str, managedActivityResultLauncherA, this, unlockAllAppsViewModel, mutableState8, null);
                str = str;
                dashboardActivity = this;
                unlockAllAppsViewModel = unlockAllAppsViewModel;
                mutableState4 = mutableState8;
                composer2.w(dashboardActivity$RootCompose$2$1);
                objG8 = dashboardActivity$RootCompose$2$1;
            } else {
                dashboardActivity = this;
                mutableState4 = mutableState8;
            }
            EffectsKt.g(str, (Function2) objG8, composer2, i6);
            if (((Boolean) mutableState4.getValue()).booleanValue()) {
                composer2.a0(432557396);
                UnlockAllAppsViewState unlockAllAppsViewState = (UnlockAllAppsViewState) FlowExtKt.m(unlockAllAppsViewModel, composer2, i6);
                Function1 function1N2 = FlowExtKt.n(unlockAllAppsViewModel, composer2, i6);
                boolean zI4 = composer2.I(dashboardActivity);
                Object objG9 = composer2.G();
                if (zI4 || objG9 == companion.a()) {
                    objG9 = new DashboardActivity$RootCompose$3$1(mutableState4, dashboardActivity, r8);
                    composer2.w(objG9);
                }
                FlowExtKt.j(unlockAllAppsViewModel, null, (Function2) objG9, composer2, 0, 1);
                composerK = composer2;
                final String strB = StringResources_androidKt.b(R.string.y4, composerK, i6);
                boolean zI5 = composerK.I(dashboardActivity) | composerK.Z(scaffoldState) | composerK.Z(strB);
                Object objG10 = composerK.G();
                if (zI5 || objG10 == companion.a()) {
                    objG10 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.dashboard.o3
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return DashboardActivity.Y1(mutableState4, dashboardActivity, scaffoldState, strB);
                        }
                    };
                    composerK.w(objG10);
                }
                UnlockAllAppsScreenKt.i(unlockAllAppsViewState, function1N2, (Function0) objG10, composerK, i6);
            } else {
                composerK = composer2;
                composerK.a0(414642806);
            }
            composerK.U();
            boolean Z2 = composerK.Z(function1) | composerK.I(dashboardActivity);
            Object objG11 = composerK.G();
            if (Z2 || objG11 == companion.a()) {
                objG11 = new Function2() { // from class: cz.mobilesoft.coreblock.scene.dashboard.s1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return DashboardActivity.Z1(function1, dashboardActivity, (LifecycleOwner) obj, (Lifecycle.Event) obj2);
                    }
                };
                composerK.w(objG11);
            }
            ComposableExtKt.j(r8, (Function2) objG11, composerK, i6, 1);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            dashboardActivity = this;
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.dashboard.t1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DashboardActivity.a2(this.f101543a, paddingValues, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    @Override // cz.mobilesoft.coreblock.base.activity.BaseComposeActivity
    protected boolean f0() {
        return this.f99139i;
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:63:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void j1(final androidx.navigation.NavHostController r18, final cz.mobilesoft.coreblock.scene.dashboard.DashboardViewState r19, final kotlin.jvm.functions.Function1 r20, boolean r21, androidx.compose.runtime.Composer r22, final int r23, final int r24) {
        /*
            Method dump skipped, instruction units count: 256
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.dashboard.DashboardActivity.j1(androidx.navigation.NavHostController, cz.mobilesoft.coreblock.scene.dashboard.DashboardViewState, kotlin.jvm.functions.Function1, boolean, androidx.compose.runtime.Composer, int, int):void");
    }

    @Override // cz.mobilesoft.coreblock.base.activity.BaseComposeActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        CoroutinesHelperExtKt.h(this, new AnonymousClass1(null));
        E2();
        CoroutinesHelperExtKt.d(new AnonymousClass2(null));
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    protected void onNewIntent(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        super.onNewIntent(intent);
        setIntent(intent);
        String stringExtra = intent.getStringExtra("SHORTCUT_ACTION");
        if (stringExtra != null) {
            this.f99142l.setValue(stringExtra);
            intent.removeExtra("SHORTCUT_ACTION");
        }
        CoroutinesHelperExtKt.h(this, new DashboardActivity$onNewIntent$2$1(this, intent, null));
    }

    public final void s1(final DashboardViewModel viewModel, final NavHostController navController, final MutableState showNeverAgainButton, final MutableState showStrictModeSuggestionBottomSheet, final MutableState showSchedulePausedBottomSheet, final Function1 onEvent, Composer composer, final int i3) {
        int i4;
        Composer composer2;
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(navController, "navController");
        Intrinsics.checkNotNullParameter(showNeverAgainButton, "showNeverAgainButton");
        Intrinsics.checkNotNullParameter(showStrictModeSuggestionBottomSheet, "showStrictModeSuggestionBottomSheet");
        Intrinsics.checkNotNullParameter(showSchedulePausedBottomSheet, "showSchedulePausedBottomSheet");
        Intrinsics.checkNotNullParameter(onEvent, "onEvent");
        Composer composerK = composer.k(-918248749);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(viewModel) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(navController) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.Z(showNeverAgainButton) ? 256 : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            i4 |= composerK.Z(showStrictModeSuggestionBottomSheet) ? 2048 : 1024;
        }
        if ((i3 & 24576) == 0) {
            i4 |= composerK.Z(showSchedulePausedBottomSheet) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        }
        if ((196608 & i3) == 0) {
            i4 |= composerK.I(onEvent) ? 131072 : NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
        }
        if ((1572864 & i3) == 0) {
            i4 |= composerK.I(this) ? 1048576 : 524288;
        }
        int i5 = i4;
        if (composerK.r((599187 & i5) != 599186, i5 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-918248749, i5, -1, "cz.mobilesoft.coreblock.scene.dashboard.DashboardActivity.CommandProcessor (DashboardActivity.kt:426)");
            }
            boolean zI = composerK.I(this) | composerK.I(navController) | ((458752 & i5) == 131072) | ((i5 & 896) == 256) | ((57344 & i5) == 16384) | ((i5 & 7168) == 2048);
            Object objG = composerK.G();
            if (zI || objG == Composer.f23746a.a()) {
                DashboardActivity$CommandProcessor$1$1 dashboardActivity$CommandProcessor$1$1 = new DashboardActivity$CommandProcessor$1$1(this, navController, onEvent, showNeverAgainButton, showSchedulePausedBottomSheet, showStrictModeSuggestionBottomSheet, null);
                composerK.w(dashboardActivity$CommandProcessor$1$1);
                objG = dashboardActivity$CommandProcessor$1$1;
            }
            composer2 = composerK;
            FlowExtKt.g(viewModel, null, (Function2) objG, composer2, i5 & 14, 2);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer2 = composerK;
            composer2.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.dashboard.u1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DashboardActivity.t1(this.f101554a, viewModel, navController, showNeverAgainButton, showStrictModeSuggestionBottomSheet, showSchedulePausedBottomSheet, onEvent, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}
