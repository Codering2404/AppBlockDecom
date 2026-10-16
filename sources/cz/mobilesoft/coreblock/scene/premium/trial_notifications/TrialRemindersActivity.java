package cz.mobilesoft.coreblock.scene.premium.trial_notifications;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;
import androidx.activity.compose.ActivityResultRegistryKt;
import androidx.activity.compose.BackHandlerKt;
import androidx.activity.compose.ManagedActivityResultLauncher;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.compose.animation.AnimatedContentScope;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.material3.AppBarKt;
import androidx.compose.material3.ScaffoldKt;
import androidx.compose.material3.TopAppBarDefaults;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.unit.Dp;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.NavGraphBuilder;
import androidx.navigation.NavHostController;
import androidx.navigation.Navigator;
import androidx.navigation.compose.NavGraphBuilderKt;
import androidx.navigation.compose.NavHostControllerKt;
import androidx.navigation.compose.NavHostKt;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.BuildConfig;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.base.activity.BaseComposeActivity;
import cz.mobilesoft.coreblock.scene.premium.trial_notifications.pages.TrialAddToCalendarScreenKt;
import cz.mobilesoft.coreblock.scene.premium.trial_notifications.pages.TrialEndNotificationScreenKt;
import cz.mobilesoft.coreblock.util.IntentHelperKt;
import cz.mobilesoft.coreblock.util.compose.FlowExtKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.util.helperextension.ContextExtKt;
import cz.mobilesoft.coreblock.util.permissions.PermissionHelper;
import cz.mobilesoft.coreblock.util.runnability.JobHelper;
import cz.mobilesoft.coreblock.view.compose.ComposeButtonsKt;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
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
import org.koin.android.ext.android.AndroidKoinScopeExtKt;
import org.koin.androidx.viewmodel.GetViewModelKt;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class TrialRemindersActivity extends BaseComposeActivity {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Companion f113891h = new Companion(null);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f113892i = 8;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Lazy f113893f = LazyKt.b(new Function0() { // from class: cz.mobilesoft.coreblock.scene.premium.trial_notifications.b
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return Integer.valueOf(TrialRemindersActivity.c1(this.f113907a));
        }
    });

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Lazy f113894g = LazyKt.b(new Function0() { // from class: cz.mobilesoft.coreblock.scene.premium.trial_notifications.l
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return Boolean.valueOf(TrialRemindersActivity.a1(this.f113931a));
        }
    });

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ Intent b(Companion companion, Context context, int i3, boolean z2, int i4, Object obj) {
            if ((i4 & 4) != 0) {
                z2 = false;
            }
            return companion.a(context, i3, z2);
        }

        public final Intent a(Context context, int i3, boolean z2) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intent intent = new Intent(context, (Class<?>) TrialRemindersActivity.class);
            intent.putExtra("TRIAL_DAYS_VALUE", i3);
            intent.putExtra("IS_OPEN_FROM_DEVELOPER_MENU", z2);
            return intent;
        }

        private Companion() {
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class TrialNotificationNavItem {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ TrialNotificationNavItem[] $VALUES;
        public static final TrialNotificationNavItem AddToCalendar = new TrialNotificationNavItem("AddToCalendar", 0, "add_to_calendar");
        public static final TrialNotificationNavItem TrialEndNotification = new TrialNotificationNavItem("TrialEndNotification", 1, "trial_end_notification");
        private final String route;

        private static final /* synthetic */ TrialNotificationNavItem[] $values() {
            return new TrialNotificationNavItem[]{AddToCalendar, TrialEndNotification};
        }

        static {
            TrialNotificationNavItem[] trialNotificationNavItemArr$values = $values();
            $VALUES = trialNotificationNavItemArr$values;
            $ENTRIES = EnumEntriesKt.a(trialNotificationNavItemArr$values);
        }

        private TrialNotificationNavItem(String str, int i3, String str2) {
            this.route = str2;
        }

        public static EnumEntries<TrialNotificationNavItem> getEntries() {
            return $ENTRIES;
        }

        public static TrialNotificationNavItem valueOf(String str) {
            return (TrialNotificationNavItem) Enum.valueOf(TrialNotificationNavItem.class, str);
        }

        public static TrialNotificationNavItem[] values() {
            return (TrialNotificationNavItem[]) $VALUES.clone();
        }

        public final String getRoute() {
            return this.route;
        }
    }

    private final void E0(TrialRemindersViewModel trialRemindersViewModel, Composer composer, final int i3) {
        int i4;
        final TrialRemindersViewModel trialRemindersViewModel2;
        Composer composerK = composer.k(-1849297511);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(trialRemindersViewModel) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(this) ? 32 : 16;
        }
        if (composerK.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1849297511, i4, -1, "cz.mobilesoft.coreblock.scene.premium.trial_notifications.TrialRemindersActivity.CommandProcessor (TrialRemindersActivity.kt:130)");
            }
            boolean zI = composerK.I(this);
            Object objG = composerK.G();
            if (zI || objG == Composer.f23746a.a()) {
                objG = new TrialRemindersActivity$CommandProcessor$1$1(this, null);
                composerK.w(objG);
            }
            trialRemindersViewModel2 = trialRemindersViewModel;
            FlowExtKt.g(trialRemindersViewModel2, null, (Function2) objG, composerK, i4 & 14, 2);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            trialRemindersViewModel2 = trialRemindersViewModel;
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.premium.trial_notifications.c
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TrialRemindersActivity.F0(this.f113908a, trialRemindersViewModel2, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit F0(TrialRemindersActivity trialRemindersActivity, TrialRemindersViewModel trialRemindersViewModel, int i3, Composer composer, int i4) {
        trialRemindersActivity.E0(trialRemindersViewModel, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    private final void G0(final int i3, final boolean z2, final Context context, final NavHostController navHostController, final PaddingValues paddingValues, Composer composer, final int i4) {
        int i5;
        int i6;
        boolean z3;
        Composer composerK = composer.k(-995687187);
        if ((i4 & 6) == 0) {
            i5 = i3;
            i6 = (composerK.e(i5) ? 4 : 2) | i4;
        } else {
            i5 = i3;
            i6 = i4;
        }
        if ((i4 & 48) == 0) {
            z3 = z2;
            i6 |= composerK.b(z3) ? 32 : 16;
        } else {
            z3 = z2;
        }
        if ((i4 & 384) == 0) {
            i6 |= composerK.I(context) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i4 & 3072) == 0) {
            i6 |= composerK.I(navHostController) ? 2048 : 1024;
        }
        if ((i4 & 24576) == 0) {
            i6 |= composerK.Z(paddingValues) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        }
        if ((196608 & i4) == 0) {
            i6 |= composerK.I(this) ? 131072 : NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
        }
        int i7 = i6;
        if (composerK.r((74899 & i7) != 74898, i7 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-995687187, i7, -1, "cz.mobilesoft.coreblock.scene.premium.trial_notifications.TrialRemindersActivity.NavigationHost (TrialRemindersActivity.kt:148)");
            }
            ActivityResultContracts.RequestPermission requestPermission = new ActivityResultContracts.RequestPermission();
            boolean zI = composerK.I(this);
            Object objG = composerK.G();
            if (zI || objG == Composer.f23746a.a()) {
                objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.premium.trial_notifications.q
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return TrialRemindersActivity.H0(this.f113947a, ((Boolean) obj).booleanValue());
                    }
                };
                composerK.w(objG);
            }
            final ManagedActivityResultLauncher managedActivityResultLauncherA = ActivityResultRegistryKt.a(requestPermission, (Function1) objG, composerK, 0);
            ActivityResultContracts.StartActivityForResult startActivityForResult = new ActivityResultContracts.StartActivityForResult();
            Object objG2 = composerK.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG2 == companion.a()) {
                objG2 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.premium.trial_notifications.r
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return TrialRemindersActivity.I0((ActivityResult) obj);
                    }
                };
                composerK.w(objG2);
            }
            final ManagedActivityResultLauncher managedActivityResultLauncherA2 = ActivityResultRegistryKt.a(startActivityForResult, (Function1) objG2, composerK, 48);
            Modifier modifierH = PaddingKt.h(BackgroundKt.d(Modifier.b8, ComposeColorsKt.j(composerK, 0).e(), null, 2, null), paddingValues);
            String route = TrialNotificationNavItem.AddToCalendar.getRoute();
            boolean zI2 = ((i7 & 14) == 4) | ((i7 & 112) == 32) | composerK.I(this) | composerK.I(managedActivityResultLauncherA2) | composerK.I(context) | composerK.I(navHostController) | composerK.I(managedActivityResultLauncherA);
            Object objG3 = composerK.G();
            if (zI2 || objG3 == companion.a()) {
                final int i8 = i5;
                final boolean z4 = z3;
                Function1 function1 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.premium.trial_notifications.s
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return TrialRemindersActivity.J0(i8, z4, this, managedActivityResultLauncherA2, context, navHostController, managedActivityResultLauncherA, (NavGraphBuilder) obj);
                    }
                };
                composerK.w(function1);
                objG3 = function1;
            }
            NavHostKt.v(navHostController, route, modifierH, null, null, null, null, null, null, null, (Function1) objG3, composerK, ((i7 >> 9) & 14) | 48, 0, 1016);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.premium.trial_notifications.t
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TrialRemindersActivity.R0(this.f113955a, i3, z2, context, navHostController, paddingValues, i4, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit H0(TrialRemindersActivity trialRemindersActivity, boolean z2) {
        trialRemindersActivity.b1();
        trialRemindersActivity.finish();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit I0(ActivityResult it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit J0(final int i3, final boolean z2, final TrialRemindersActivity trialRemindersActivity, final ManagedActivityResultLauncher managedActivityResultLauncher, final Context context, final NavHostController navHostController, final ManagedActivityResultLauncher managedActivityResultLauncher2, NavGraphBuilder NavHost) {
        Intrinsics.checkNotNullParameter(NavHost, "$this$NavHost");
        NavGraphBuilderKt.c(NavHost, TrialNotificationNavItem.AddToCalendar.getRoute(), null, null, null, null, null, null, null, ComposableLambdaKt.c(-1061742576, true, new Function4() { // from class: cz.mobilesoft.coreblock.scene.premium.trial_notifications.e
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return TrialRemindersActivity.K0(i3, z2, trialRemindersActivity, managedActivityResultLauncher, context, navHostController, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        }), 254, null);
        NavGraphBuilderKt.c(NavHost, TrialNotificationNavItem.TrialEndNotification.getRoute(), null, null, null, null, null, null, null, ComposableLambdaKt.c(-444024441, true, new Function4() { // from class: cz.mobilesoft.coreblock.scene.premium.trial_notifications.f
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return TrialRemindersActivity.O0(context, managedActivityResultLauncher2, trialRemindersActivity, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        }), 254, null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit K0(final int i3, boolean z2, final TrialRemindersActivity trialRemindersActivity, final ManagedActivityResultLauncher managedActivityResultLauncher, final Context context, final NavHostController navHostController, AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i4) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        if (ComposerKt.M()) {
            ComposerKt.U(-1061742576, i4, -1, "cz.mobilesoft.coreblock.scene.premium.trial_notifications.TrialRemindersActivity.NavigationHost.<anonymous>.<anonymous>.<anonymous> (TrialRemindersActivity.kt:167)");
        }
        Object objG = composer.G();
        Composer.Companion companion = Composer.f23746a;
        if (objG == companion.a()) {
            objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.premium.trial_notifications.i
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return TrialRemindersActivity.L0();
                }
            };
            composer.w(objG);
        }
        BackHandlerKt.a(false, (Function0) objG, composer, 48, 1);
        boolean zE = composer.e(i3) | composer.I(trialRemindersActivity) | composer.I(managedActivityResultLauncher) | composer.I(context);
        Object objG2 = composer.G();
        if (zE || objG2 == companion.a()) {
            objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.premium.trial_notifications.j
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return TrialRemindersActivity.M0(i3, trialRemindersActivity, managedActivityResultLauncher, context);
                }
            };
            composer.w(objG2);
        }
        Function0 function0 = (Function0) objG2;
        boolean zI = composer.I(trialRemindersActivity) | composer.I(context) | composer.I(navHostController);
        Object objG3 = composer.G();
        if (zI || objG3 == companion.a()) {
            objG3 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.premium.trial_notifications.k
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return TrialRemindersActivity.N0(this.f113928a, context, navHostController);
                }
            };
            composer.w(objG3);
        }
        TrialAddToCalendarScreenKt.c(i3, z2, function0, (Function0) objG3, composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit L0() {
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit M0(int i3, TrialRemindersActivity trialRemindersActivity, ManagedActivityResultLauncher managedActivityResultLauncher, Context context) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(5, Math.max(i3 - 3, 0));
        String string = trialRemindersActivity.getString(R.string.fq);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String string2 = trialRemindersActivity.getString(R.string.lE);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        Intrinsics.checkNotNull(calendar);
        Intent intentA = IntentHelperKt.a(string, string2, calendar);
        if (intentA.resolveActivity(trialRemindersActivity.getPackageManager()) != null) {
            managedActivityResultLauncher.b(intentA);
        } else {
            Toast.makeText(context, trialRemindersActivity.getString(R.string.Lk), 0).show();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit N0(TrialRemindersActivity trialRemindersActivity, Context context, NavHostController navHostController) {
        Activity activityB;
        if (trialRemindersActivity.Z0() || (!PermissionHelper.o(context) && ((activityB = ContextExtKt.b(context)) == null || !activityB.shouldShowRequestPermissionRationale("android.permission.POST_NOTIFICATIONS")))) {
            NavController.P(navHostController, TrialNotificationNavItem.TrialEndNotification.getRoute(), null, null, 6, null);
        } else {
            trialRemindersActivity.b1();
            trialRemindersActivity.finish();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit O0(final Context context, final ManagedActivityResultLauncher managedActivityResultLauncher, final TrialRemindersActivity trialRemindersActivity, AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        if (ComposerKt.M()) {
            ComposerKt.U(-444024441, i3, -1, "cz.mobilesoft.coreblock.scene.premium.trial_notifications.TrialRemindersActivity.NavigationHost.<anonymous>.<anonymous>.<anonymous> (TrialRemindersActivity.kt:203)");
        }
        Object objG = composer.G();
        Composer.Companion companion = Composer.f23746a;
        if (objG == companion.a()) {
            objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.premium.trial_notifications.g
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return TrialRemindersActivity.P0();
                }
            };
            composer.w(objG);
        }
        BackHandlerKt.a(false, (Function0) objG, composer, 48, 1);
        boolean zI = composer.I(context) | composer.I(managedActivityResultLauncher) | composer.I(trialRemindersActivity);
        Object objG2 = composer.G();
        if (zI || objG2 == companion.a()) {
            objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.premium.trial_notifications.h
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return TrialRemindersActivity.Q0(context, managedActivityResultLauncher, trialRemindersActivity);
                }
            };
            composer.w(objG2);
        }
        TrialEndNotificationScreenKt.k((Function0) objG2, composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit P0() {
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Q0(Context context, ManagedActivityResultLauncher managedActivityResultLauncher, TrialRemindersActivity trialRemindersActivity) {
        Activity activityB;
        if (PermissionHelper.o(context) || ((activityB = ContextExtKt.b(context)) != null && activityB.shouldShowRequestPermissionRationale("android.permission.POST_NOTIFICATIONS"))) {
            trialRemindersActivity.b1();
            trialRemindersActivity.finish();
        } else {
            managedActivityResultLauncher.b("android.permission.POST_NOTIFICATIONS");
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit R0(TrialRemindersActivity trialRemindersActivity, int i3, boolean z2, Context context, NavHostController navHostController, PaddingValues paddingValues, int i4, Composer composer, int i5) {
        trialRemindersActivity.G0(i3, z2, context, navHostController, paddingValues, composer, RecomposeScopeImplKt.a(i4 | 1));
        return Unit.f139807a;
    }

    private static final NavBackStackEntry S0(State state) {
        return (NavBackStackEntry) state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit T0(final TrialRemindersActivity trialRemindersActivity, final State state, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1086272338, i3, -1, "cz.mobilesoft.coreblock.scene.premium.trial_notifications.TrialRemindersActivity.RootCompose.<anonymous> (TrialRemindersActivity.kt:94)");
            }
            AppBarKt.p(ComposableSingletons$TrialRemindersActivityKt.f113889a.b(), null, ComposableLambdaKt.e(2037672948, true, new Function2() { // from class: cz.mobilesoft.coreblock.scene.premium.trial_notifications.p
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TrialRemindersActivity.U0(this.f113941a, state, (Composer) obj, ((Integer) obj2).intValue());
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
    public static final Unit U0(final TrialRemindersActivity trialRemindersActivity, State state, Composer composer, int i3) {
        Composer composer2;
        NavDestination navDestinationD;
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(2037672948, i3, -1, "cz.mobilesoft.coreblock.scene.premium.trial_notifications.TrialRemindersActivity.RootCompose.<anonymous>.<anonymous> (TrialRemindersActivity.kt:100)");
            }
            NavBackStackEntry navBackStackEntryS0 = S0(state);
            if (Intrinsics.areEqual((navBackStackEntryS0 == null || (navDestinationD = navBackStackEntryS0.d()) == null) ? null : navDestinationD.t(), TrialNotificationNavItem.TrialEndNotification.getRoute())) {
                composer.a0(-752795217);
                PaddingValues paddingValuesA = PaddingKt.a(Dp.g(0));
                boolean zI = composer.I(trialRemindersActivity);
                Object objG = composer.G();
                if (zI || objG == Composer.f23746a.a()) {
                    objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.premium.trial_notifications.d
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return TrialRemindersActivity.V0(this.f113911a);
                        }
                    };
                    composer.w(objG);
                }
                composer2 = composer;
                ComposeButtonsKt.o0(null, paddingValuesA, 0, (Function0) objG, composer2, 48, 5);
            } else {
                composer2 = composer;
                composer2.a0(-757143122);
            }
            composer2.U();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit V0(TrialRemindersActivity trialRemindersActivity) {
        trialRemindersActivity.finish();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit W0(TrialRemindersActivity trialRemindersActivity, TrialRemindersState trialRemindersState, Context context, NavHostController navHostController, PaddingValues it, Composer composer, int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(it, "it");
        if ((i3 & 6) == 0) {
            i4 = (composer.Z(it) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if (composer.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1855719171, i4, -1, "cz.mobilesoft.coreblock.scene.premium.trial_notifications.TrialRemindersActivity.RootCompose.<anonymous> (TrialRemindersActivity.kt:112)");
            }
            trialRemindersActivity.G0(trialRemindersActivity.Y0(), trialRemindersState.b() || trialRemindersActivity.Z0(), context, navHostController, it, composer, (i4 << 12) & 57344);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit X0(TrialRemindersActivity trialRemindersActivity, PaddingValues paddingValues, int i3, Composer composer, int i4) {
        trialRemindersActivity.c0(paddingValues, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean a1(TrialRemindersActivity trialRemindersActivity) {
        return trialRemindersActivity.getIntent().getBooleanExtra("IS_OPEN_FROM_DEVELOPER_MENU", false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int c1(TrialRemindersActivity trialRemindersActivity) {
        return trialRemindersActivity.getIntent().getIntExtra("TRIAL_DAYS_VALUE", 7);
    }

    public final int Y0() {
        return ((Number) this.f113893f.getValue()).intValue();
    }

    public final boolean Z0() {
        return ((Boolean) this.f113894g.getValue()).booleanValue();
    }

    public final void b1() {
        JobHelper.o(System.currentTimeMillis() + (BuildConfig.f95357b.booleanValue() ? TimeUnit.SECONDS.toMillis(20L) : TimeUnit.DAYS.toMillis(Math.max(Y0() - 3, 0))));
    }

    @Override // cz.mobilesoft.coreblock.base.activity.BaseComposeActivity
    public void c0(final PaddingValues paddingValues, Composer composer, final int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        Composer composerK = composer.k(-231343118);
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
                ComposerKt.U(-231343118, i4, -1, "cz.mobilesoft.coreblock.scene.premium.trial_notifications.TrialRemindersActivity.RootCompose (TrialRemindersActivity.kt:81)");
            }
            final NavHostController navHostControllerB = NavHostControllerKt.b(new Navigator[0], composerK, 0);
            ViewModelStore viewModelStore = getViewModelStore();
            CreationExtras defaultViewModelCreationExtras = getDefaultViewModelCreationExtras();
            Intrinsics.checkNotNullExpressionValue(defaultViewModelCreationExtras, "this.defaultViewModelCreationExtras");
            Scope scopeA = AndroidKoinScopeExtKt.a(this);
            KClass kClassB = Reflection.b(TrialRemindersViewModel.class);
            Intrinsics.checkNotNullExpressionValue(viewModelStore, "viewModelStore");
            TrialRemindersViewModel trialRemindersViewModel = (TrialRemindersViewModel) GetViewModelKt.b(kClassB, viewModelStore, null, defaultViewModelCreationExtras, null, scopeA, null, 4, null);
            final TrialRemindersState trialRemindersState = (TrialRemindersState) FlowExtKt.m(trialRemindersViewModel, composerK, 0);
            final Context context = (Context) composerK.q(AndroidCompositionLocals_androidKt.g());
            final State stateA = NavHostControllerKt.a(navHostControllerB, composerK, 0);
            ScaffoldKt.a(PaddingKt.h(Modifier.b8, paddingValues), ComposableLambdaKt.e(-1086272338, true, new Function2() { // from class: cz.mobilesoft.coreblock.scene.premium.trial_notifications.m
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TrialRemindersActivity.T0(this.f113932a, stateA, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerK, 54), null, null, null, 0, 0L, 0L, null, ComposableLambdaKt.e(1855719171, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.premium.trial_notifications.n
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return TrialRemindersActivity.W0(this.f113934a, trialRemindersState, context, navHostControllerB, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerK, 54), composerK, 805306416, 508);
            composerK = composerK;
            E0(trialRemindersViewModel, composerK, i4 & 112);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.premium.trial_notifications.o
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TrialRemindersActivity.X0(this.f113938a, paddingValues, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}
