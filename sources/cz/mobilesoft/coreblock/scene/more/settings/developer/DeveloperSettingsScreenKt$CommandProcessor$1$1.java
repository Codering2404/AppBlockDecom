package cz.mobilesoft.coreblock.scene.more.settings.developer;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.util.Log;
import android.widget.Toast;
import androidx.activity.compose.ManagedActivityResultLauncher;
import com.google.android.gms.ads.AdInspectorError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.OnAdInspectorClosedListener;
import com.jakewharton.processphoenix.ProcessPhoenix;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.activity.rating.RatingDialogActivity;
import cz.mobilesoft.coreblock.enums.PremiumFeature;
import cz.mobilesoft.coreblock.enums.RevenueCatPlacement;
import cz.mobilesoft.coreblock.scene.app_feel.AppFeelActivity;
import cz.mobilesoft.coreblock.scene.auto_trial.AutoTrialActivity;
import cz.mobilesoft.coreblock.scene.chatbot.ChatBotActivity;
import cz.mobilesoft.coreblock.scene.insights.weekly.WeeklyInsightsActivity;
import cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewCommand;
import cz.mobilesoft.coreblock.scene.more.settings.developer.browserslist.BrowsersListActivity;
import cz.mobilesoft.coreblock.scene.more.settings.developer.remoteconfigvalues.RemoteConfigValuesActivity;
import cz.mobilesoft.coreblock.scene.onboarding.OnboardingActivityV2;
import cz.mobilesoft.coreblock.scene.premium.dto.CampaignSource;
import cz.mobilesoft.coreblock.scene.premium.enums.DiscountSource;
import cz.mobilesoft.coreblock.scene.premium.host.Paywall;
import cz.mobilesoft.coreblock.scene.premium.host.PaywallTarget;
import cz.mobilesoft.coreblock.scene.premium.premium_expiring.PremiumExpiringActivity;
import cz.mobilesoft.coreblock.scene.premium.trial_notifications.TrialRemindersActivity;
import cz.mobilesoft.coreblock.scene.streaks.milestone.StreakMilestoneActivity;
import cz.mobilesoft.coreblock.scene.subscriptionob.SubscriptionOnboardingActivity;
import cz.mobilesoft.coreblock.scene.whats_new.WhatsNewFullScreenActivity;
import cz.mobilesoft.coreblock.util.helperextension.DialogHelperExtKt;
import cz.mobilesoft.coreblock.util.permissions.PermissionHelperV2;
import cz.mobilesoft.coreblock.util.runnability.DeviceAdminHelper;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsScreenKt$CommandProcessor$1$1", f = "DeveloperSettingsScreen.kt", l = {}, m = "invokeSuspend", v = 1)
final class DeveloperSettingsScreenKt$CommandProcessor$1$1 extends SuspendLambda implements Function2<DeveloperSettingsViewCommand, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f108286a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    /* synthetic */ Object f108287b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Context f108288c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ Function1 f108289d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ ManagedActivityResultLauncher f108290f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DeveloperSettingsScreenKt$CommandProcessor$1$1(Context context, Function1 function1, ManagedActivityResultLauncher managedActivityResultLauncher, Continuation continuation) {
        super(2, continuation);
        this.f108288c = context;
        this.f108289d = function1;
        this.f108290f = managedActivityResultLauncher;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(AdInspectorError adInspectorError) {
        Log.e("AdInspector", "Ad Inspector error: " + adInspectorError);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        DeveloperSettingsScreenKt$CommandProcessor$1$1 developerSettingsScreenKt$CommandProcessor$1$1 = new DeveloperSettingsScreenKt$CommandProcessor$1$1(this.f108288c, this.f108289d, this.f108290f, continuation);
        developerSettingsScreenKt$CommandProcessor$1$1.f108287b = obj;
        return developerSettingsScreenKt$CommandProcessor$1$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        DeveloperSettingsViewCommand developerSettingsViewCommand = (DeveloperSettingsViewCommand) this.f108287b;
        IntrinsicsKt.f();
        if (this.f108286a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        if (developerSettingsViewCommand instanceof DeveloperSettingsViewCommand.OpenStreakMilestone) {
            Context context = this.f108288c;
            context.startActivity(StreakMilestoneActivity.f120940g.b(context, ((DeveloperSettingsViewCommand.OpenStreakMilestone) developerSettingsViewCommand).a()));
        } else if (developerSettingsViewCommand instanceof DeveloperSettingsViewCommand.OpenStreakIntroduction) {
            Context context2 = this.f108288c;
            context2.startActivity(StreakMilestoneActivity.f120940g.a(context2));
        } else if (developerSettingsViewCommand instanceof DeveloperSettingsViewCommand.ShowSnackbar) {
            this.f108289d.invoke(Boxing.d(((DeveloperSettingsViewCommand.ShowSnackbar) developerSettingsViewCommand).a()));
        } else if (developerSettingsViewCommand instanceof DeveloperSettingsViewCommand.ShowToast) {
            Toast.makeText(this.f108288c, ((DeveloperSettingsViewCommand.ShowToast) developerSettingsViewCommand).a(), 0).show();
        } else if (developerSettingsViewCommand instanceof DeveloperSettingsViewCommand.NavigateToCampaignPremium) {
            this.f108288c.startActivity(Paywall.c(Paywall.f113165a, this.f108288c, new PaywallTarget.Campaign(((DeveloperSettingsViewCommand.NavigateToCampaignPremium) developerSettingsViewCommand).a(), CampaignSource.None, "unknown"), "developer_menu", "developer_menu", false, false, false, null, 240, null));
        } else if (Intrinsics.areEqual(developerSettingsViewCommand, DeveloperSettingsViewCommand.NavigateToSubscriptionOnboarding.f108334a)) {
            this.f108288c.startActivity(SubscriptionOnboardingActivity.f122709g.a(this.f108288c, true, 7));
        } else if (developerSettingsViewCommand instanceof DeveloperSettingsViewCommand.ShowToWhatsNewFlow) {
            this.f108288c.startActivity(WhatsNewFullScreenActivity.f123056h.a(this.f108288c, ((DeveloperSettingsViewCommand.ShowToWhatsNewFlow) developerSettingsViewCommand).a()));
        } else if (Intrinsics.areEqual(developerSettingsViewCommand, DeveloperSettingsViewCommand.NavigateToWeeklyInsights.f108337a)) {
            this.f108288c.startActivity(new Intent(this.f108288c, (Class<?>) WeeklyInsightsActivity.class));
        } else if (Intrinsics.areEqual(developerSettingsViewCommand, DeveloperSettingsViewCommand.NavigateToPremiumExpiring.f108330a)) {
            this.f108288c.startActivity(PremiumExpiringActivity.Companion.b(PremiumExpiringActivity.f113543g, this.f108288c, "app_start", "renewal_screen", null, 8, null));
        } else if (Intrinsics.areEqual(developerSettingsViewCommand, DeveloperSettingsViewCommand.NavigateToBrowsersList.f108313a)) {
            this.f108288c.startActivity(BrowsersListActivity.f109037f.a(this.f108288c));
        } else if (Intrinsics.areEqual(developerSettingsViewCommand, DeveloperSettingsViewCommand.NavigateToRemoteConfigValues.f108333a)) {
            this.f108288c.startActivity(RemoteConfigValuesActivity.f109279f.a(this.f108288c));
        } else if (developerSettingsViewCommand instanceof DeveloperSettingsViewCommand.NavigateToChatBot) {
            this.f108288c.startActivity(ChatBotActivity.f99024h.a(this.f108288c, "developer_menu", ((DeveloperSettingsViewCommand.NavigateToChatBot) developerSettingsViewCommand).a()));
        } else if (Intrinsics.areEqual(developerSettingsViewCommand, DeveloperSettingsViewCommand.NavigateToOnboarding.f108328a)) {
            Intent intent = new Intent(this.f108288c, (Class<?>) OnboardingActivityV2.class);
            intent.setFlags(268468224);
            this.f108288c.startActivity(intent);
        } else if (Intrinsics.areEqual(developerSettingsViewCommand, DeveloperSettingsViewCommand.NavigateToAppFeelOnboarding.f108311a)) {
            this.f108288c.startActivity(AppFeelActivity.f98567f.a(this.f108288c, true));
        } else if (Intrinsics.areEqual(developerSettingsViewCommand, DeveloperSettingsViewCommand.NavigateToTrialReminders.f108335a)) {
            this.f108288c.startActivity(TrialRemindersActivity.f113891h.a(this.f108288c, 0, true));
        } else if (Intrinsics.areEqual(developerSettingsViewCommand, DeveloperSettingsViewCommand.NavigateToRatingDialogFlow.f108332a)) {
            RatingDialogActivity.f95979p.j(this.f108288c);
        } else {
            if (Intrinsics.areEqual(developerSettingsViewCommand, DeveloperSettingsViewCommand.ShowBackdoorCodeDialog.f108350a)) {
                Context context3 = this.f108288c;
                Activity activity = context3 instanceof Activity ? (Activity) context3 : null;
                if (activity != null) {
                    DialogHelperExtKt.u(activity);
                }
            } else if (Intrinsics.areEqual(developerSettingsViewCommand, DeveloperSettingsViewCommand.ShowAdsInspector.f108349a)) {
                Context context4 = this.f108288c;
                Intrinsics.checkNotNull(context4, "null cannot be cast to non-null type android.app.Activity");
                MobileAds.c((Activity) context4, new OnAdInspectorClosedListener() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.r4
                    @Override // com.google.android.gms.ads.OnAdInspectorClosedListener
                    public final void a(AdInspectorError adInspectorError) {
                        DeveloperSettingsScreenKt$CommandProcessor$1$1.y(adInspectorError);
                    }
                });
            } else if (Intrinsics.areEqual(developerSettingsViewCommand, DeveloperSettingsViewCommand.OpenFilePicker.f108341a)) {
                Intent intent2 = new Intent("android.intent.action.OPEN_DOCUMENT");
                intent2.addCategory("android.intent.category.OPENABLE");
                intent2.setType("application/json");
                this.f108290f.b(intent2);
            } else if (Intrinsics.areEqual(developerSettingsViewCommand, DeveloperSettingsViewCommand.LaunchEventsBubble.f108310a)) {
                if (Build.VERSION.SDK_INT >= 30) {
                    DeveloperSettingsScreenKt.b0(this.f108288c);
                }
            } else if (Intrinsics.areEqual(developerSettingsViewCommand, DeveloperSettingsViewCommand.OpenAccessibilitySettings.f108338a)) {
                PermissionHelperV2 permissionHelperV2 = PermissionHelperV2.f129006a;
                Context context5 = this.f108288c;
                Intrinsics.checkNotNull(context5, "null cannot be cast to non-null type android.app.Activity");
                permissionHelperV2.c((Activity) context5, null, null, false);
            } else if (Intrinsics.areEqual(developerSettingsViewCommand, DeveloperSettingsViewCommand.OpenOverlaySettings.f108343a)) {
                PermissionHelperV2 permissionHelperV22 = PermissionHelperV2.f129006a;
                Context context6 = this.f108288c;
                Intrinsics.checkNotNull(context6, "null cannot be cast to non-null type android.app.Activity");
                permissionHelperV22.f((Activity) context6, null, null);
            } else if (Intrinsics.areEqual(developerSettingsViewCommand, DeveloperSettingsViewCommand.OpenUsageSettings.f108346a)) {
                PermissionHelperV2 permissionHelperV23 = PermissionHelperV2.f129006a;
                Context context7 = this.f108288c;
                Intrinsics.checkNotNull(context7, "null cannot be cast to non-null type android.app.Activity");
                permissionHelperV23.h((Activity) context7, null, null, false);
            } else if (Intrinsics.areEqual(developerSettingsViewCommand, DeveloperSettingsViewCommand.OpenNotificationAccessSettings.f108342a)) {
                Boxing.a(PermissionHelperV2.f129006a.g(this.f108288c, null, null));
            } else if (Intrinsics.areEqual(developerSettingsViewCommand, DeveloperSettingsViewCommand.OpenAppSettings.f108339a)) {
                this.f108288c.startActivity(new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.fromParts("package", this.f108288c.getPackageName(), null)));
            } else if (Intrinsics.areEqual(developerSettingsViewCommand, DeveloperSettingsViewCommand.RemoveDeviceAdmin.f108347a)) {
                DeviceAdminHelper.i(this.f108288c);
            } else if (Intrinsics.areEqual(developerSettingsViewCommand, DeveloperSettingsViewCommand.OpenDiscountScreen.f108340a)) {
                this.f108288c.startActivity(Paywall.c(Paywall.f113165a, this.f108288c, new PaywallTarget.Discount(RevenueCatPlacement.Discount20, DiscountSource.REFERRAL_RECEIVER, false, null), "blocking_tab", null, false, false, false, null, 248, null));
            } else if (Intrinsics.areEqual(developerSettingsViewCommand, DeveloperSettingsViewCommand.NavigateToAutoTrialFlow.f108312a)) {
                Context context8 = this.f108288c;
                context8.startActivity(AutoTrialActivity.f98899g.a(context8));
            } else if (Intrinsics.areEqual(developerSettingsViewCommand, DeveloperSettingsViewCommand.NavigateToIntroTrialPremium.f108325a)) {
                this.f108288c.startActivity(Paywall.c(Paywall.f113165a, this.f108288c, new PaywallTarget.IntroTrial(true), "developer_menu", "developer_menu", true, true, true, null, ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD, null));
            } else if (Intrinsics.areEqual(developerSettingsViewCommand, DeveloperSettingsViewCommand.NavigateToTrialRetentionPremium.f108336a)) {
                this.f108288c.startActivity(Paywall.c(Paywall.f113165a, this.f108288c, PaywallTarget.TrialRetention.INSTANCE, "developer_menu", "developer_menu", false, false, false, null, 240, null));
            } else if (Intrinsics.areEqual(developerSettingsViewCommand, DeveloperSettingsViewCommand.NavigateToGenericPremium.f108324a)) {
                this.f108288c.startActivity(Paywall.c(Paywall.f113165a, this.f108288c, PaywallTarget.Generic.INSTANCE, "developer_menu", "developer_menu", false, false, false, null, 240, null));
            } else if (Intrinsics.areEqual(developerSettingsViewCommand, DeveloperSettingsViewCommand.NavigateToDiscountPremium.f108317a)) {
                this.f108288c.startActivity(Paywall.c(Paywall.f113165a, this.f108288c, new PaywallTarget.Discount(RevenueCatPlacement.Discount20, DiscountSource.LEAVING_SCREEN, false, null), "developer_menu", null, false, false, false, null, 248, null));
            } else if (Intrinsics.areEqual(developerSettingsViewCommand, DeveloperSettingsViewCommand.NavigateToDiscountPremium30.f108318a)) {
                this.f108288c.startActivity(Paywall.c(Paywall.f113165a, this.f108288c, new PaywallTarget.Discount(RevenueCatPlacement.Discount30, DiscountSource.LEAVING_SCREEN, false, null), "developer_menu", null, false, false, false, null, 248, null));
            } else if (Intrinsics.areEqual(developerSettingsViewCommand, DeveloperSettingsViewCommand.NavigateToDiscountPremium50.f108319a)) {
                this.f108288c.startActivity(Paywall.c(Paywall.f113165a, this.f108288c, new PaywallTarget.Discount(RevenueCatPlacement.Discount50, DiscountSource.LEAVING_SCREEN, false, null), "developer_menu", null, false, false, false, null, 248, null));
            } else if (Intrinsics.areEqual(developerSettingsViewCommand, DeveloperSettingsViewCommand.NavigateToExpiredSubPremium.f108323a)) {
                this.f108288c.startActivity(Paywall.c(Paywall.f113165a, this.f108288c, new PaywallTarget.ExpiredSub(1), "developer_menu", "developer_menu", false, false, false, null, 240, null));
            } else if (Intrinsics.areEqual(developerSettingsViewCommand, DeveloperSettingsViewCommand.NavigateToProductPlanPremium.f108331a)) {
                this.f108288c.startActivity(Paywall.c(Paywall.f113165a, this.f108288c, new PaywallTarget.MySubscription("Dev Test"), "developer_menu", "developer_menu", false, false, false, null, 240, null));
            } else if (Intrinsics.areEqual(developerSettingsViewCommand, DeveloperSettingsViewCommand.NavigateToLimitScreenPremium.f108327a)) {
                this.f108288c.startActivity(Paywall.c(Paywall.f113165a, this.f108288c, new PaywallTarget.LimitScreen(PremiumFeature.QUICK_BLOCK_TIMER), "developer_menu", "developer_menu", false, false, false, null, 240, null));
            } else if (Intrinsics.areEqual(developerSettingsViewCommand, DeveloperSettingsViewCommand.NavigateToExpiredSubDiscountPremium.f108322a)) {
                this.f108288c.startActivity(Paywall.c(Paywall.f113165a, this.f108288c, new PaywallTarget.ExpiredSubDiscount(false), "developer_menu", "developer_menu", false, false, false, null, 240, null));
            } else if (Intrinsics.areEqual(developerSettingsViewCommand, DeveloperSettingsViewCommand.NavigateToIntroTrialTogglePremium.f108326a)) {
                this.f108288c.startActivity(Paywall.c(Paywall.f113165a, this.f108288c, PaywallTarget.IntroTrialToggle.INSTANCE, "developer_menu", "developer_menu", false, false, false, null, 240, null));
            } else if (Intrinsics.areEqual(developerSettingsViewCommand, DeveloperSettingsViewCommand.NavigateToOneTimeToSubPremium.f108329a)) {
                Paywall paywall = Paywall.f113165a;
                Context context9 = this.f108288c;
                String string = this.f108288c.getString(R.string.r2);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                this.f108288c.startActivity(Paywall.c(paywall, context9, new PaywallTarget.OneTimeToSub(string), "developer_menu", "developer_menu", false, false, false, null, 240, null));
            } else if (Intrinsics.areEqual(developerSettingsViewCommand, DeveloperSettingsViewCommand.NavigateToDiscountPremiumReferralSender.f108321a)) {
                this.f108288c.startActivity(Paywall.c(Paywall.f113165a, this.f108288c, new PaywallTarget.Discount(RevenueCatPlacement.ReferralSent, DiscountSource.REFERRAL_SENDER, false, null), "developer_menu", null, false, false, false, null, 248, null));
            } else if (Intrinsics.areEqual(developerSettingsViewCommand, DeveloperSettingsViewCommand.NavigateToDiscountPremiumReferralReceiver.f108320a)) {
                this.f108288c.startActivity(Paywall.c(Paywall.f113165a, this.f108288c, new PaywallTarget.Discount(RevenueCatPlacement.ReferralReceived, DiscountSource.REFERRAL_RECEIVER, false, null), "developer_menu", null, false, false, false, null, 248, null));
            } else if (Intrinsics.areEqual(developerSettingsViewCommand, DeveloperSettingsViewCommand.NavigateToCampaignPremiumDefault.f108315a)) {
                this.f108288c.startActivity(Paywall.c(Paywall.f113165a, this.f108288c, new PaywallTarget.Campaign(2L, CampaignSource.DeepLink, "unknown"), "developer_menu", "developer_menu", false, false, false, null, 240, null));
            } else {
                if (!Intrinsics.areEqual(developerSettingsViewCommand, DeveloperSettingsViewCommand.RestartApp.f108348a)) {
                    throw new NoWhenBranchMatchedException();
                }
                ProcessPhoenix.b(this.f108288c.getApplicationContext());
            }
        }
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public final Object invoke(DeveloperSettingsViewCommand developerSettingsViewCommand, Continuation continuation) {
        return ((DeveloperSettingsScreenKt$CommandProcessor$1$1) create(developerSettingsViewCommand, continuation)).invokeSuspend(Unit.f139807a);
    }
}
