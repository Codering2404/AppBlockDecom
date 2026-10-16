package cz.mobilesoft.coreblock.scene.dashboard.profile;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import androidx.activity.compose.ManagedActivityResultLauncher;
import com.facebook.ads.AdError;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.enums.PremiumFeature;
import cz.mobilesoft.coreblock.enums.PremiumState;
import cz.mobilesoft.coreblock.enums.SettingsScreenType;
import cz.mobilesoft.coreblock.enums.SignInEntryPoint;
import cz.mobilesoft.coreblock.scene.dashboard.DashboardActivity;
import cz.mobilesoft.coreblock.scene.dashboard.DashboardViewEvent;
import cz.mobilesoft.coreblock.scene.dashboard.profile.ProfileViewCommand;
import cz.mobilesoft.coreblock.scene.dashboard.profile.ProfileViewEvent;
import cz.mobilesoft.coreblock.scene.dashboard.profile.account.AccountDetailActivity;
import cz.mobilesoft.coreblock.scene.dashboard.profile.type.ProfileSectionItemType;
import cz.mobilesoft.coreblock.scene.insights.weekly.WeeklyInsightsActivity;
import cz.mobilesoft.coreblock.scene.more.academy.course.AcademyCoursesActivity;
import cz.mobilesoft.coreblock.scene.more.backup.BackupMainActivity;
import cz.mobilesoft.coreblock.scene.more.changelog.ChangelogActivity;
import cz.mobilesoft.coreblock.scene.more.customBlockScreen.CustomBlockScreenActivity;
import cz.mobilesoft.coreblock.scene.more.guestpassshare.GuestPassShareActivity;
import cz.mobilesoft.coreblock.scene.more.guestpassshare.GuestPassShareFlowScenario;
import cz.mobilesoft.coreblock.scene.more.haf.HaFActivity;
import cz.mobilesoft.coreblock.scene.more.help.HelpActivity;
import cz.mobilesoft.coreblock.scene.more.help.restorepurchase.RestorePurchaseActivity;
import cz.mobilesoft.coreblock.scene.more.notifications.BlockedNotificationsActivity;
import cz.mobilesoft.coreblock.scene.more.referral.ReferralActivity;
import cz.mobilesoft.coreblock.scene.more.settings.SettingsActivity;
import cz.mobilesoft.coreblock.scene.more.settings.icon_select.AppIconSelectActivity;
import cz.mobilesoft.coreblock.scene.more.signin.SignInActivity;
import cz.mobilesoft.coreblock.scene.more.signin.SignInConfig;
import cz.mobilesoft.coreblock.scene.premium.host.Paywall;
import cz.mobilesoft.coreblock.scene.premium.host.PaywallTarget;
import cz.mobilesoft.coreblock.util.AdsUtils;
import cz.mobilesoft.coreblock.util.ExternalLinksHelper;
import cz.mobilesoft.coreblock.util.SessionManager;
import cz.mobilesoft.coreblock.util.ads.BaseAdsUtils;
import cz.mobilesoft.coreblock.util.analytics.AnswersHelper;
import cz.mobilesoft.coreblock.util.helperextension.ContextExtKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.dashboard.profile.ProfileScreenKt$CommandProcessor$1$1", f = "ProfileScreen.kt", l = {}, m = "invokeSuspend", v = 1)
final class ProfileScreenKt$CommandProcessor$1$1 extends SuspendLambda implements Function2<ProfileViewCommand, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f100903a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    /* synthetic */ Object f100904b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Context f100905c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ Function1 f100906d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ Function1 f100907f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ ManagedActivityResultLauncher f100908g;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f100909a;

        static {
            int[] iArr = new int[ProfileSectionItemType.values().length];
            try {
                iArr[ProfileSectionItemType.Account.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ProfileSectionItemType.Academy.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ProfileSectionItemType.BlockedNotifications.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ProfileSectionItemType.Backup.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[ProfileSectionItemType.Premium.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[ProfileSectionItemType.MyPremium.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[ProfileSectionItemType.MyProductPlan.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[ProfileSectionItemType.MySubscription.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[ProfileSectionItemType.MonthlyTrial.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[ProfileSectionItemType.Troubleshooting.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[ProfileSectionItemType.Help.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr[ProfileSectionItemType.GeneralSettings.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr[ProfileSectionItemType.InviteFriend.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr[ProfileSectionItemType.News.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr[ProfileSectionItemType.MacOsxApp.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                iArr[ProfileSectionItemType.DiscordCommunity.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                iArr[ProfileSectionItemType.RestorePurchase.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                iArr[ProfileSectionItemType.Notifications.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                iArr[ProfileSectionItemType.TimeNudge.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                iArr[ProfileSectionItemType.BlockingPreferences.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                iArr[ProfileSectionItemType.Statistics.ordinal()] = 21;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                iArr[ProfileSectionItemType.RateUsOnGooglePlay.ordinal()] = 22;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                iArr[ProfileSectionItemType.AdsRelevance.ordinal()] = 23;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                iArr[ProfileSectionItemType.CustomBlockingScreen.ordinal()] = 24;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                iArr[ProfileSectionItemType.AppIcon.ordinal()] = 25;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                iArr[ProfileSectionItemType.GuestPass.ordinal()] = 26;
            } catch (NoSuchFieldError unused26) {
            }
            f100909a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ProfileScreenKt$CommandProcessor$1$1(Context context, Function1 function1, Function1 function12, ManagedActivityResultLauncher managedActivityResultLauncher, Continuation continuation) {
        super(2, continuation);
        this.f100905c = context;
        this.f100906d = function1;
        this.f100907f = function12;
        this.f100908g = managedActivityResultLauncher;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(Function1 function1, Integer num, boolean z2) {
        AnswersHelper.f128199a.r5();
        function1.invoke(new ProfileViewEvent.OnAdsConsentUpdated(num, z2));
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        ProfileScreenKt$CommandProcessor$1$1 profileScreenKt$CommandProcessor$1$1 = new ProfileScreenKt$CommandProcessor$1$1(this.f100905c, this.f100906d, this.f100907f, this.f100908g, continuation);
        profileScreenKt$CommandProcessor$1$1.f100904b = obj;
        return profileScreenKt$CommandProcessor$1$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Intent intentC;
        ProfileViewCommand profileViewCommand = (ProfileViewCommand) this.f100904b;
        IntrinsicsKt.f();
        if (this.f100903a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        if (profileViewCommand instanceof ProfileViewCommand.OnSectionClickActionCommand) {
            ProfileViewCommand.OnSectionClickActionCommand onSectionClickActionCommand = (ProfileViewCommand.OnSectionClickActionCommand) profileViewCommand;
            switch (WhenMappings.f100909a[onSectionClickActionCommand.a().ordinal()]) {
                case 1:
                    Context context = this.f100905c;
                    context.startActivity(AccountDetailActivity.f101090f.a(context));
                    break;
                case 2:
                    AnswersHelper.H();
                    Context context2 = this.f100905c;
                    context2.startActivity(AcademyCoursesActivity.f106131t.a(context2));
                    break;
                case 3:
                    Context context3 = this.f100905c;
                    context3.startActivity(BlockedNotificationsActivity.f107859o.a(context3));
                    break;
                case 4:
                    this.f100906d.invoke(ProfileViewEvent.OnBackupClicked.f100927a);
                    break;
                case 5:
                    Context context4 = this.f100905c;
                    context4.startActivity(SettingsActivity.f108043h.a(context4, SettingsScreenType.PREMIUM, onSectionClickActionCommand.b()));
                    break;
                case 6:
                case 7:
                    Context context5 = this.f100905c;
                    Paywall paywall = Paywall.f113165a;
                    String string = this.f100905c.getString(R.string.uk);
                    Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                    context5.startActivity(Paywall.c(paywall, context5, new PaywallTarget.MySubscription(string), "profile_tab", "profile_tab", false, false, false, null, 240, null));
                    break;
                case 8:
                    Context context6 = this.f100905c;
                    Paywall paywall2 = Paywall.f113165a;
                    String string2 = this.f100905c.getString(R.string.vk);
                    Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                    context6.startActivity(Paywall.c(paywall2, context6, new PaywallTarget.MySubscription(string2), "profile_tab", "profile_tab", false, false, false, null, 240, null));
                    break;
                case 9:
                    Context context7 = this.f100905c;
                    context7.startActivity(Paywall.c(Paywall.f113165a, context7, new PaywallTarget.AutoTrialPromo(false), "profile_tab", "auto_trial_my_subscription", false, false, false, null, 240, null));
                    break;
                case 10:
                    Context context8 = this.f100905c;
                    context8.startActivity(HelpActivity.f107722u.a(context8));
                    break;
                case 11:
                    AnswersHelper.f128199a.N1();
                    Context context9 = this.f100905c;
                    context9.startActivity(HaFActivity.Companion.b(HaFActivity.f107547f, context9, null, 2, null));
                    break;
                case 12:
                    Context context10 = this.f100905c;
                    context10.startActivity(SettingsActivity.Companion.b(SettingsActivity.f108043h, context10, SettingsScreenType.OVERVIEW, false, 4, null));
                    break;
                case 13:
                    AnswersHelper.f128199a.A4();
                    Context context11 = this.f100905c;
                    context11.startActivity(ReferralActivity.f107961f.a(context11));
                    break;
                case 14:
                    AnswersHelper.f128199a.j1();
                    Context context12 = this.f100905c;
                    context12.startActivity(ChangelogActivity.f106918t.a(context12));
                    break;
                case 15:
                    ExternalLinksHelper.f127866a.d(this.f100905c, "https://appblock.app/extensions/");
                    break;
                case 16:
                    ExternalLinksHelper.f127866a.d(this.f100905c, "https://discord.gg/5yTsfjFqGp");
                    break;
                case 17:
                    if (!SessionManager.f127910a.r()) {
                        Context context13 = this.f100905c;
                        context13.startActivity(SignInActivity.f110366h.a(context13, new SignInConfig(SignInEntryPoint.RESTORE, null, false, true, false, true, false, false, false, false, null, AdError.INTERNAL_ERROR_2006, null)));
                    } else {
                        Context context14 = this.f100905c;
                        context14.startActivity(RestorePurchaseActivity.f107825f.a(context14));
                    }
                    break;
                case 18:
                    Context context15 = this.f100905c;
                    context15.startActivity(SettingsActivity.Companion.b(SettingsActivity.f108043h, context15, SettingsScreenType.NOTIFICATION, false, 4, null));
                    break;
                case 19:
                    Context context16 = this.f100905c;
                    context16.startActivity(SettingsActivity.Companion.b(SettingsActivity.f108043h, context16, SettingsScreenType.TIME_NUDGE, false, 4, null));
                    break;
                case 20:
                    Context context17 = this.f100905c;
                    context17.startActivity(SettingsActivity.Companion.b(SettingsActivity.f108043h, context17, SettingsScreenType.BLOCKING_PREFERENCES, false, 4, null));
                    break;
                case 21:
                    Context context18 = this.f100905c;
                    context18.startActivity(SettingsActivity.Companion.b(SettingsActivity.f108043h, context18, SettingsScreenType.STATISTICS, false, 4, null));
                    break;
                case 22:
                    ExternalLinksHelper.f(ExternalLinksHelper.f127866a, this.f100905c, false, null, 3, null);
                    break;
                case 23:
                    Activity activityB = ContextExtKt.b(this.f100905c);
                    if (activityB != null) {
                        final Function1 function1 = this.f100906d;
                        AnswersHelper.f128199a.s5();
                        AdsUtils.f127678i.x(activityB, new BaseAdsUtils.ConsentFormCallback() { // from class: cz.mobilesoft.coreblock.scene.dashboard.profile.n1
                            @Override // cz.mobilesoft.coreblock.util.ads.BaseAdsUtils.ConsentFormCallback
                            public final void l(Object obj2, boolean z2) {
                                ProfileScreenKt$CommandProcessor$1$1.y(function1, (Integer) obj2, z2);
                            }
                        });
                    }
                    break;
                case 24:
                    this.f100905c.startActivity(new Intent(this.f100905c, (Class<?>) CustomBlockScreenActivity.class));
                    break;
                case 25:
                    Context context19 = this.f100905c;
                    context19.startActivity(AppIconSelectActivity.f109892f.a(context19));
                    break;
                case 26:
                    GuestPassShareFlowScenario guestPassShareFlowScenario = onSectionClickActionCommand.b() ? GuestPassShareFlowScenario.EligibleGuestPassShare : GuestPassShareFlowScenario.ShareOnly;
                    Context context20 = this.f100905c;
                    context20.startActivity(GuestPassShareActivity.f107428g.a(context20, guestPassShareFlowScenario));
                    break;
                default:
                    throw new NoWhenBranchMatchedException();
            }
        } else if (Intrinsics.areEqual(profileViewCommand, ProfileViewCommand.OnShowStatisticsPageCommand.f100921a)) {
            this.f100907f.invoke(new DashboardViewEvent.OnNavPageRequested(DashboardActivity.NavBarItem.Insights.f99176i));
        } else if (Intrinsics.areEqual(profileViewCommand, ProfileViewCommand.OnShowWeeklyInsightsCommand.f100922a)) {
            Context context21 = this.f100905c;
            context21.startActivity(WeeklyInsightsActivity.f103883g.b(context21));
        } else if (profileViewCommand instanceof ProfileViewCommand.OnSocialMediaClickActionCommand) {
            ExternalLinksHelper.f127866a.d(this.f100905c, ((ProfileViewCommand.OnSocialMediaClickActionCommand) profileViewCommand).a().getUrl());
        } else if (Intrinsics.areEqual(profileViewCommand, ProfileViewCommand.OnRequestSignUpLoginCommand.f100918a)) {
            Context context22 = this.f100905c;
            context22.startActivity(SignInActivity.f110366h.a(context22, new SignInConfig(SignInEntryPoint.MORE, null, false, false, true, false, false, false, false, false, null, 2030, null)));
        } else {
            if (!(profileViewCommand instanceof ProfileViewCommand.LaunchBackupCommand)) {
                throw new NoWhenBranchMatchedException();
            }
            Context context23 = this.f100905c;
            ProfileViewCommand.LaunchBackupCommand launchBackupCommand = (ProfileViewCommand.LaunchBackupCommand) profileViewCommand;
            if (launchBackupCommand.a().g()) {
                if (!launchBackupCommand.b()) {
                    this.f100908g.b(SignInActivity.f110366h.a(this.f100905c, new SignInConfig(SignInEntryPoint.BACKUP, null, false, false, false, false, true, false, false, false, null, 1982, null)));
                    return Unit.f139807a;
                }
                intentC = BackupMainActivity.f106365v.a(this.f100905c);
            } else if (launchBackupCommand.a() instanceof PremiumState.OldFull) {
                Paywall paywall3 = Paywall.f113165a;
                Context context24 = this.f100905c;
                String string3 = this.f100905c.getString(R.string.r2);
                Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
                intentC = Paywall.c(paywall3, context24, new PaywallTarget.OneTimeToSub(string3), "profile_tab", "backup", false, false, false, null, 240, null);
            } else {
                intentC = Paywall.c(Paywall.f113165a, this.f100905c, new PaywallTarget.LimitScreen(PremiumFeature.BACKUP), "profile_tab", "backup", false, false, false, null, 240, null);
            }
            context23.startActivity(intentC);
        }
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public final Object invoke(ProfileViewCommand profileViewCommand, Continuation continuation) {
        return ((ProfileScreenKt$CommandProcessor$1$1) create(profileViewCommand, continuation)).invokeSuspend(Unit.f139807a);
    }
}
