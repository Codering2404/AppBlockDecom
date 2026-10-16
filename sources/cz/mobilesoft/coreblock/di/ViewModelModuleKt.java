package cz.mobilesoft.coreblock.di;

import android.app.Application;
import android.location.LocationManager;
import androidx.lifecycle.SavedStateHandle;
import cz.mobilesoft.coreblock.LockieApplication;
import cz.mobilesoft.coreblock.activity.rating.RatingDialogViewModel;
import cz.mobilesoft.coreblock.activity.rating.RatingFlowViewModel;
import cz.mobilesoft.coreblock.activity.rating.RatingTriggerSource;
import cz.mobilesoft.coreblock.di.ViewModelModuleKt;
import cz.mobilesoft.coreblock.dto.Pair;
import cz.mobilesoft.coreblock.dto.QuestionDTO;
import cz.mobilesoft.coreblock.enums.ContactReason;
import cz.mobilesoft.coreblock.enums.PremiumState;
import cz.mobilesoft.coreblock.enums.ProfileType;
import cz.mobilesoft.coreblock.enums.StrictModeAccessMethod;
import cz.mobilesoft.coreblock.repository.PremiumRepositoryV2;
import cz.mobilesoft.coreblock.repository.QuickBlockRepository;
import cz.mobilesoft.coreblock.repository.StrictModeRepository;
import cz.mobilesoft.coreblock.scene.app_feel.AppFeelViewModel;
import cz.mobilesoft.coreblock.scene.chatbot.intro.IntroChatBotViewModel;
import cz.mobilesoft.coreblock.scene.dashboard.DashboardActivity;
import cz.mobilesoft.coreblock.scene.dashboard.DashboardViewModel;
import cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel;
import cz.mobilesoft.coreblock.scene.dashboard.blocking.ProfileViewDTO;
import cz.mobilesoft.coreblock.scene.dashboard.blocking.pause.PauseBlockingViewModel;
import cz.mobilesoft.coreblock.scene.dashboard.card.QuickBlockCardViewModel;
import cz.mobilesoft.coreblock.scene.dashboard.profile.ProfileViewModel;
import cz.mobilesoft.coreblock.scene.dashboard.profile.account.AccountDetailViewModel;
import cz.mobilesoft.coreblock.scene.dashboard.shortcuts.unlock_all_apps.UnlockAllAppsViewModel;
import cz.mobilesoft.coreblock.scene.dev_events.DevEventsViewModel;
import cz.mobilesoft.coreblock.scene.email_consent.EmailConsentViewModel;
import cz.mobilesoft.coreblock.scene.emergency_unblock.EmergencyUnblockViewModel;
import cz.mobilesoft.coreblock.scene.feedback.FeedbackViewModel;
import cz.mobilesoft.coreblock.scene.feedback.backdoorcode.feedback.BackdoorFeedbackViewModel;
import cz.mobilesoft.coreblock.scene.inappupdate.InAppUpdateViewModel;
import cz.mobilesoft.coreblock.scene.insights.InsightsViewModel;
import cz.mobilesoft.coreblock.scene.insights.InsightsViewState;
import cz.mobilesoft.coreblock.scene.insights.settings.ExcludedAppsViewModel;
import cz.mobilesoft.coreblock.scene.insights.trial_summary.TrialSummaryViewModel;
import cz.mobilesoft.coreblock.scene.insights.weekly.WeeklyInsightsViewModel;
import cz.mobilesoft.coreblock.scene.intro.OnboardingViewModel;
import cz.mobilesoft.coreblock.scene.intro.quickblock.QuickBlockBlockingTestViewModel;
import cz.mobilesoft.coreblock.scene.intro.schedule.IntroScheduleViewModel;
import cz.mobilesoft.coreblock.scene.intro.strictmode.StrictModeIntroViewModel;
import cz.mobilesoft.coreblock.scene.lockscreen.LockViewModel;
import cz.mobilesoft.coreblock.scene.more.academy.course.AcademyCourseFinishedViewModel;
import cz.mobilesoft.coreblock.scene.more.academy.course.AcademyCoursesViewModel;
import cz.mobilesoft.coreblock.scene.more.academy.lesson.AcademyAnotherCurrentLessonViewModel;
import cz.mobilesoft.coreblock.scene.more.academy.lesson.AcademyLessonViewModel;
import cz.mobilesoft.coreblock.scene.more.academy.lesson.AcademyLessonsViewModel;
import cz.mobilesoft.coreblock.scene.more.backup.BackupMainViewModel;
import cz.mobilesoft.coreblock.scene.more.backup.progress.BackupProgressViewModel;
import cz.mobilesoft.coreblock.scene.more.changelog.ChangelogViewModel;
import cz.mobilesoft.coreblock.scene.more.customBlockScreen.CustomBlockingViewModel;
import cz.mobilesoft.coreblock.scene.more.guestpassshare.GuestPassShareViewModel;
import cz.mobilesoft.coreblock.scene.more.haf.HaFViewModel;
import cz.mobilesoft.coreblock.scene.more.help.HelpViewModel;
import cz.mobilesoft.coreblock.scene.more.help.restorepurchase.RestorePurchaseViewModel;
import cz.mobilesoft.coreblock.scene.more.notifications.BlockedNotificationsViewModel;
import cz.mobilesoft.coreblock.scene.more.referral.ReferralViewModel;
import cz.mobilesoft.coreblock.scene.more.settings.blockingPreferences.BlockingPreferencesViewModel;
import cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel;
import cz.mobilesoft.coreblock.scene.more.settings.developer.browserslist.BrowsersListViewModel;
import cz.mobilesoft.coreblock.scene.more.settings.developer.remoteconfigvalues.RemoteConfigValuesViewModel;
import cz.mobilesoft.coreblock.scene.more.settings.excludedBrowsers.ExcludedUnsupportedBrowsersViewModel;
import cz.mobilesoft.coreblock.scene.more.settings.generalSettings.GeneralSettingsViewModel;
import cz.mobilesoft.coreblock.scene.more.settings.icon_select.AppIconSelectViewModel;
import cz.mobilesoft.coreblock.scene.more.settings.notification.NotificationSettingsViewModel;
import cz.mobilesoft.coreblock.scene.more.settings.statistics.StatisticsSettingsViewModel;
import cz.mobilesoft.coreblock.scene.more.settings.timenudge.TimeNudgeSettingsViewModel;
import cz.mobilesoft.coreblock.scene.more.signin.SignInConfig;
import cz.mobilesoft.coreblock.scene.more.signin.SignInViewModel;
import cz.mobilesoft.coreblock.scene.onboarding.OnboardingViewModelV2;
import cz.mobilesoft.coreblock.scene.password.PassCodeType;
import cz.mobilesoft.coreblock.scene.password.PassCodeViewModel;
import cz.mobilesoft.coreblock.scene.permission.location.LocationPermissionViewModel;
import cz.mobilesoft.coreblock.scene.permission.permissions.PermissionComposeViewModel;
import cz.mobilesoft.coreblock.scene.permission.permissions.PermissionsDTO;
import cz.mobilesoft.coreblock.scene.premium.exitpaywall.ExitPaywallPremiumViewModel;
import cz.mobilesoft.coreblock.scene.premium.host.CampaignPaywallViewModel;
import cz.mobilesoft.coreblock.scene.premium.host.DiscountPaywallViewModel;
import cz.mobilesoft.coreblock.scene.premium.host.MySubscriptionPaywallViewModel;
import cz.mobilesoft.coreblock.scene.premium.host.PaywallHostViewModel;
import cz.mobilesoft.coreblock.scene.premium.host.PaywallSpec;
import cz.mobilesoft.coreblock.scene.premium.host.PaywallTarget;
import cz.mobilesoft.coreblock.scene.premium.host.PlainPaywallViewModel;
import cz.mobilesoft.coreblock.scene.premium.premium_expiring.PremiumExpiringActivity;
import cz.mobilesoft.coreblock.scene.premium.premium_expiring.PremiumExpiringPurchaseViewModel;
import cz.mobilesoft.coreblock.scene.premium.premium_expiring.PremiumExpiringViewModel;
import cz.mobilesoft.coreblock.scene.premium.superwall.SuperwallPlacementViewModel;
import cz.mobilesoft.coreblock.scene.premium.trial_notifications.TrialRemindersViewModel;
import cz.mobilesoft.coreblock.scene.quickblock.pomodoro.PomodoroViewModel;
import cz.mobilesoft.coreblock.scene.quickblock.timer.QuickBlockTimeSelectViewModel;
import cz.mobilesoft.coreblock.scene.schedule.ScheduleDescriptor;
import cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel;
import cz.mobilesoft.coreblock.scene.schedule.blockingmode.BlockingModeSettingsViewModel;
import cz.mobilesoft.coreblock.scene.schedule.condition.ConditionDTO;
import cz.mobilesoft.coreblock.scene.schedule.condition.launchcount.LaunchCountConditionViewModel;
import cz.mobilesoft.coreblock.scene.schedule.condition.location.LocationConditionScreenViewModel;
import cz.mobilesoft.coreblock.scene.schedule.condition.location.LocationPlacesSelectViewModel;
import cz.mobilesoft.coreblock.scene.schedule.condition.time.TimeConditionViewModel;
import cz.mobilesoft.coreblock.scene.schedule.condition.usagelimit.UsageLimitConditionViewModel;
import cz.mobilesoft.coreblock.scene.schedule.condition.wifi.WifiConditionViewModel;
import cz.mobilesoft.coreblock.scene.schedule.customcombination.CustomCombinationViewModel;
import cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePreviewViewModel;
import cz.mobilesoft.coreblock.scene.selection.BlockingSelectViewModel;
import cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionViewModel;
import cz.mobilesoft.coreblock.scene.selection.ignorelist.IgnoreListSelectViewModel;
import cz.mobilesoft.coreblock.scene.selection.recommended.RecommendedAppsViewModel;
import cz.mobilesoft.coreblock.scene.sharing.SocialsSharingViewModel;
import cz.mobilesoft.coreblock.scene.sharing.dto.SocialsSharePayload;
import cz.mobilesoft.coreblock.scene.statistics.detail.StatisticsDetailFragmentViewModel;
import cz.mobilesoft.coreblock.scene.statistics.ignorelist.DefaultApplicationSelectFragmentViewModel;
import cz.mobilesoft.coreblock.scene.statistics.ignorelist.IgnoreListCustomFragmentViewModel;
import cz.mobilesoft.coreblock.scene.statistics.ignorelist.IgnoreListDefaultFragmentViewModel;
import cz.mobilesoft.coreblock.scene.statistics.overview.StatisticsOverviewFragmentViewModel;
import cz.mobilesoft.coreblock.scene.streaks.detail.StreakDetailViewModel;
import cz.mobilesoft.coreblock.scene.streaks.feedback.StreakFeedbackViewModel;
import cz.mobilesoft.coreblock.scene.streaks.milestone.StreakMilestoneViewModel;
import cz.mobilesoft.coreblock.scene.strictmode.passcode.StrictModePassCodeViewModel;
import cz.mobilesoft.coreblock.scene.strictmode3.StrictMode3ViewModel;
import cz.mobilesoft.coreblock.scene.strictmode3.access.StrictModeAccessViewModel;
import cz.mobilesoft.coreblock.scene.strictmode3.component.emailinput.StrictModeEmailInputBottomSheetViewModel;
import cz.mobilesoft.coreblock.scene.strictmode3.followschedules.ScheduleSelectViewModel;
import cz.mobilesoft.coreblock.scene.strictmode3.options.StrictModeOptionsViewModel;
import cz.mobilesoft.coreblock.scene.strictmode3.usecase.WillBeContinuousUseCase;
import cz.mobilesoft.coreblock.scene.timenudge.TimeNudgeViewModel;
import cz.mobilesoft.coreblock.scene.timenudge.select.TimeNudgeSelectViewModel;
import cz.mobilesoft.coreblock.scene.troubleshooting.TroubleshootingStackViewModel;
import cz.mobilesoft.coreblock.scene.whats_new.WhatsNewFullScreenViewModel;
import cz.mobilesoft.coreblock.storage.datastore.CoreDataStore;
import cz.mobilesoft.coreblock.storage.datastore.EventDataStore;
import cz.mobilesoft.coreblock.storage.datastore.PassCodeDataStore;
import cz.mobilesoft.coreblock.storage.datastore.StrictModeDataStore;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.IntervalDao;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao;
import cz.mobilesoft.coreblock.storage.room.dao.core.TokenFCMDao;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile;
import cz.mobilesoft.coreblock.usecase.InitApplicationsUseCase;
import cz.mobilesoft.coreblock.usecase.SendContactSupportDetailedRequestUseCase;
import cz.mobilesoft.coreblock.view.bottomsheet.timeselector.BaseTimeSelectorBottomSheetViewModel;
import cz.mobilesoft.coreblock.view.timepicker.TimePickerViewModel;
import cz.mobilesoft.coreblock.view.timeselector.TimeSelectViewModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.koin.core.definition.BeanDefinition;
import org.koin.core.definition.Kind;
import org.koin.core.definition.KoinDefinition;
import org.koin.core.instance.FactoryInstanceFactory;
import org.koin.core.module.Module;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.qualifier.StringQualifier;
import org.koin.core.registry.ScopeRegistry;
import org.koin.core.scope.Scope;
import org.koin.dsl.ModuleDSLKt;

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
public final class ViewModelModuleKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Module f96883a = ModuleDSLKt.b(false, new Function1() { // from class: q0.g5
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return ViewModelModuleKt.a1((Module) obj);
        }
    }, 1, null);

    /* JADX INFO: Access modifiers changed from: private */
    public static final AcademyLessonsViewModel A1(Scope viewModel, ParametersHolder parametersHolder) {
        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
        Intrinsics.checkNotNullParameter(parametersHolder, "<destruct>");
        return new AcademyLessonsViewModel((Application) viewModel.e(Reflection.b(Application.class), null, null), ((Number) parametersHolder.b(0, Reflection.b(Long.class))).longValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ExcludedUnsupportedBrowsersViewModel A2(Scope viewModel, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
        Intrinsics.checkNotNullParameter(it, "it");
        return new ExcludedUnsupportedBrowsersViewModel((Application) viewModel.e(Reflection.b(Application.class), null, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FeedbackViewModel B1(Scope viewModel, ParametersHolder parametersHolder) {
        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
        Intrinsics.checkNotNullParameter(parametersHolder, "<destruct>");
        return new FeedbackViewModel((Application) viewModel.e(Reflection.b(Application.class), null, null), (SendContactSupportDetailedRequestUseCase) viewModel.e(Reflection.b(SendContactSupportDetailedRequestUseCase.class), null, null), (ContactReason) parametersHolder.b(0, Reflection.b(ContactReason.class)), ((Boolean) parametersHolder.b(1, Reflection.b(Boolean.class))).booleanValue(), ((Boolean) parametersHolder.b(2, Reflection.b(Boolean.class))).booleanValue(), (String) parametersHolder.b(3, Reflection.b(String.class)), (String) parametersHolder.b(4, Reflection.b(String.class)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IntroChatBotViewModel B2(Scope viewModel, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
        Intrinsics.checkNotNullParameter(it, "it");
        return new IntroChatBotViewModel((Application) viewModel.e(Reflection.b(Application.class), null, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SignInViewModel C1(Scope viewModel, ParametersHolder parametersHolder) {
        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
        Intrinsics.checkNotNullParameter(parametersHolder, "<destruct>");
        return new SignInViewModel((Application) viewModel.e(Reflection.b(Application.class), null, null), (SignInConfig) parametersHolder.b(0, Reflection.b(SignInConfig.class)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PomodoroViewModel C2(Scope viewModel, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
        Intrinsics.checkNotNullParameter(it, "it");
        return new PomodoroViewModel((Application) viewModel.e(Reflection.b(Application.class), null, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MySubscriptionPaywallViewModel D1(Scope viewModel, ParametersHolder parametersHolder) {
        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
        Intrinsics.checkNotNullParameter(parametersHolder, "<destruct>");
        return new MySubscriptionPaywallViewModel((Application) viewModel.e(Reflection.b(Application.class), null, null), (PaywallTarget.MySubscription) parametersHolder.b(0, Reflection.b(PaywallTarget.MySubscription.class)), (PaywallSpec) parametersHolder.b(1, Reflection.b(PaywallSpec.class)), (PaywallHostViewModel.Launch) parametersHolder.b(2, Reflection.b(PaywallHostViewModel.Launch.class)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ExitPaywallPremiumViewModel D2(Scope viewModel, ParametersHolder parametersHolder) {
        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
        Intrinsics.checkNotNullParameter(parametersHolder, "<destruct>");
        return new ExitPaywallPremiumViewModel((Application) viewModel.e(Reflection.b(Application.class), null, null), (String) parametersHolder.b(0, Reflection.b(String.class)), (String) parametersHolder.b(1, Reflection.b(String.class)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DiscountPaywallViewModel E1(Scope viewModel, ParametersHolder parametersHolder) {
        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
        Intrinsics.checkNotNullParameter(parametersHolder, "<destruct>");
        return new DiscountPaywallViewModel((Application) viewModel.e(Reflection.b(Application.class), null, null), (PaywallTarget) parametersHolder.b(0, Reflection.b(PaywallTarget.class)), (PaywallSpec) parametersHolder.b(1, Reflection.b(PaywallSpec.class)), (PaywallHostViewModel.Launch) parametersHolder.b(2, Reflection.b(PaywallHostViewModel.Launch.class)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BackdoorFeedbackViewModel E2(Scope viewModel, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
        Intrinsics.checkNotNullParameter(it, "it");
        return new BackdoorFeedbackViewModel((Application) viewModel.e(Reflection.b(Application.class), null, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PremiumExpiringPurchaseViewModel F1(Scope viewModel, ParametersHolder parametersHolder) {
        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
        Intrinsics.checkNotNullParameter(parametersHolder, "<destruct>");
        return new PremiumExpiringPurchaseViewModel((Application) viewModel.e(Reflection.b(Application.class), null, null), (String) parametersHolder.b(0, Reflection.b(String.class)), (String) parametersHolder.b(1, Reflection.b(String.class)), (PremiumExpiringActivity.PremiumExpiringTrialType) parametersHolder.b(2, Reflection.b(PremiumExpiringActivity.PremiumExpiringTrialType.class)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PremiumExpiringViewModel F2(Scope viewModel, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
        Intrinsics.checkNotNullParameter(it, "it");
        return new PremiumExpiringViewModel((Application) viewModel.e(Reflection.b(Application.class), null, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TimePickerViewModel G1(Scope viewModel, ParametersHolder parametersHolder) {
        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
        Intrinsics.checkNotNullParameter(parametersHolder, "<destruct>");
        return new TimePickerViewModel((Application) viewModel.e(Reflection.b(Application.class), null, null), (TimePickerViewModel.Params) parametersHolder.b(0, Reflection.b(TimePickerViewModel.Params.class)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final EmergencyUnblockViewModel G2(Scope viewModel, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
        Intrinsics.checkNotNullParameter(it, "it");
        return new EmergencyUnblockViewModel((Application) viewModel.e(Reflection.b(Application.class), null, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final QuickBlockTimeSelectViewModel H1(Scope viewModel, ParametersHolder parametersHolder) {
        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
        Intrinsics.checkNotNullParameter(parametersHolder, "<destruct>");
        return new QuickBlockTimeSelectViewModel((Application) viewModel.e(Reflection.b(Application.class), null, null), (List) parametersHolder.b(0, Reflection.b(List.class)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final GeneralSettingsViewModel H2(Scope viewModel, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
        Intrinsics.checkNotNullParameter(it, "it");
        return new GeneralSettingsViewModel((Application) viewModel.e(Reflection.b(Application.class), null, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final HaFViewModel I1(Scope viewModel, ParametersHolder parametersHolder) {
        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
        Intrinsics.checkNotNullParameter(parametersHolder, "<destruct>");
        return new HaFViewModel((Application) viewModel.e(Reflection.b(Application.class), null, null), (QuestionDTO) parametersHolder.b(0, Reflection.b(QuestionDTO.class)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BlockingPreferencesViewModel I2(Scope viewModel, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
        Intrinsics.checkNotNullParameter(it, "it");
        return new BlockingPreferencesViewModel((Application) viewModel.e(Reflection.b(Application.class), null, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InsightsViewModel J1(Scope viewModel, ParametersHolder parametersHolder) {
        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
        Intrinsics.checkNotNullParameter(parametersHolder, "<destruct>");
        return new InsightsViewModel((Application) viewModel.e(Reflection.b(Application.class), null, null), (String) parametersHolder.b(0, Reflection.b(String.class)), (InsightsViewState.InsightsPeriodType) parametersHolder.b(1, Reflection.b(InsightsViewState.InsightsPeriodType.class)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StatisticsSettingsViewModel J2(Scope viewModel, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
        Intrinsics.checkNotNullParameter(it, "it");
        return new StatisticsSettingsViewModel((Application) viewModel.e(Reflection.b(Application.class), null, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AppFeelViewModel K1(Scope viewModel, ParametersHolder parametersHolder) {
        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
        Intrinsics.checkNotNullParameter(parametersHolder, "<destruct>");
        return new AppFeelViewModel(((Boolean) parametersHolder.b(0, Reflection.b(Boolean.class))).booleanValue(), (Application) viewModel.e(Reflection.b(Application.class), null, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TimeNudgeSettingsViewModel K2(Scope viewModel, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
        Intrinsics.checkNotNullParameter(it, "it");
        return new TimeNudgeSettingsViewModel((Application) viewModel.e(Reflection.b(Application.class), null, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AcademyLessonViewModel L1(Scope viewModel, ParametersHolder parametersHolder) {
        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
        Intrinsics.checkNotNullParameter(parametersHolder, "<destruct>");
        return new AcademyLessonViewModel((Application) viewModel.e(Reflection.b(Application.class), null, null), ((Number) parametersHolder.b(0, Reflection.b(Long.class))).longValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TimeNudgeViewModel L2(Scope viewModel, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
        Intrinsics.checkNotNullParameter(it, "it");
        return new TimeNudgeViewModel((Application) viewModel.e(Reflection.b(Application.class), null, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SchedulePreviewViewModel M1(Scope viewModel, ParametersHolder parametersHolder) {
        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
        Intrinsics.checkNotNullParameter(parametersHolder, "<destruct>");
        return new SchedulePreviewViewModel((Application) viewModel.e(Reflection.b(Application.class), null, null), (ProfileViewDTO) parametersHolder.b(0, Reflection.b(ProfileViewDTO.class)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CustomBlockingViewModel M2(Scope viewModel, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
        Intrinsics.checkNotNullParameter(it, "it");
        return new CustomBlockingViewModel((Application) viewModel.e(Reflection.b(Application.class), null, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BlockingModeSettingsViewModel N1(Scope viewModel, ParametersHolder parametersHolder) {
        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
        Intrinsics.checkNotNullParameter(parametersHolder, "<destruct>");
        return new BlockingModeSettingsViewModel((Application) viewModel.e(Reflection.b(Application.class), null, null), (ProfileType) parametersHolder.b(0, Reflection.b(ProfileType.class)), ((Boolean) parametersHolder.b(1, Reflection.b(Boolean.class))).booleanValue(), (Profile.BlockingMode) parametersHolder.b(2, Reflection.b(Profile.BlockingMode.class)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AppIconSelectViewModel N2(Scope viewModel, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
        Intrinsics.checkNotNullParameter(it, "it");
        return new AppIconSelectViewModel((Application) viewModel.e(Reflection.b(Application.class), null, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WhatsNewFullScreenViewModel O1(Scope viewModel, ParametersHolder parametersHolder) {
        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
        Intrinsics.checkNotNullParameter(parametersHolder, "<destruct>");
        return new WhatsNewFullScreenViewModel((Application) viewModel.e(Reflection.b(Application.class), null, null), (String) parametersHolder.b(0, Reflection.b(String.class)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BaseTimeSelectorBottomSheetViewModel O2(Scope viewModel, ParametersHolder parametersHolder) {
        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
        Intrinsics.checkNotNullParameter(parametersHolder, "<destruct>");
        return new BaseTimeSelectorBottomSheetViewModel((Application) viewModel.e(Reflection.b(Application.class), null, null), (Pair) parametersHolder.b(0, Reflection.b(Pair.class)), ((Boolean) parametersHolder.b(1, Reflection.b(Boolean.class))).booleanValue(), (Long) parametersHolder.b(2, Reflection.b(Long.class)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PermissionComposeViewModel P1(Scope viewModel, ParametersHolder parametersHolder) {
        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
        Intrinsics.checkNotNullParameter(parametersHolder, "<destruct>");
        return new PermissionComposeViewModel((Application) viewModel.e(Reflection.b(Application.class), null, null), (CoreDataStore) viewModel.e(Reflection.b(CoreDataStore.class), null, null), (EventDataStore) viewModel.e(Reflection.b(EventDataStore.class), null, null), (PermissionsDTO) parametersHolder.b(0, Reflection.b(PermissionsDTO.class)), (QuickBlockRepository) viewModel.e(Reflection.b(QuickBlockRepository.class), null, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ExcludedAppsViewModel P2(Scope viewModel, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
        Intrinsics.checkNotNullParameter(it, "it");
        return new ExcludedAppsViewModel((Application) viewModel.e(Reflection.b(Application.class), null, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LocationPermissionViewModel Q1(Scope viewModel, ParametersHolder parametersHolder) {
        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
        Intrinsics.checkNotNullParameter(parametersHolder, "<destruct>");
        return new LocationPermissionViewModel(((Boolean) parametersHolder.b(0, Reflection.b(Boolean.class))).booleanValue(), ((Boolean) parametersHolder.b(1, Reflection.b(Boolean.class))).booleanValue(), (Application) viewModel.e(Reflection.b(Application.class), null, null), (LocationManager) viewModel.e(Reflection.b(LocationManager.class), null, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StreakDetailViewModel Q2(Scope viewModel, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
        Intrinsics.checkNotNullParameter(it, "it");
        return new StreakDetailViewModel((Application) viewModel.e(Reflection.b(Application.class), null, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final GuestPassShareViewModel R1(Scope viewModel, ParametersHolder parametersHolder) {
        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
        Intrinsics.checkNotNullParameter(parametersHolder, "<destruct>");
        return new GuestPassShareViewModel((Application) viewModel.e(Reflection.b(Application.class), null, null), ((Boolean) parametersHolder.b(0, Reflection.b(Boolean.class))).booleanValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StreakFeedbackViewModel R2(Scope viewModel, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
        Intrinsics.checkNotNullParameter(it, "it");
        return new StreakFeedbackViewModel((Application) viewModel.e(Reflection.b(Application.class), null, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AcademyCoursesViewModel S1(Scope viewModel, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
        Intrinsics.checkNotNullParameter(it, "it");
        return new AcademyCoursesViewModel((Application) viewModel.e(Reflection.b(Application.class), null, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StreakMilestoneViewModel S2(Scope viewModel, ParametersHolder parametersHolder) {
        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
        Intrinsics.checkNotNullParameter(parametersHolder, "<destruct>");
        return new StreakMilestoneViewModel((Application) viewModel.e(Reflection.b(Application.class), null, null), ((Number) parametersHolder.b(0, Reflection.b(Integer.class))).intValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OnboardingViewModel T1(Scope viewModel, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
        Intrinsics.checkNotNullParameter(it, "it");
        return new OnboardingViewModel((Application) viewModel.e(Reflection.b(Application.class), null, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WeeklyInsightsViewModel T2(Scope viewModel, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
        Intrinsics.checkNotNullParameter(it, "it");
        return new WeeklyInsightsViewModel((Application) viewModel.e(Reflection.b(Application.class), null, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OnboardingViewModelV2 U1(Scope viewModel, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
        Intrinsics.checkNotNullParameter(it, "it");
        return new OnboardingViewModelV2((Application) viewModel.e(Reflection.b(Application.class), null, null), (PremiumRepositoryV2) viewModel.e(Reflection.b(PremiumRepositoryV2.class), null, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SocialsSharingViewModel U2(Scope viewModel, ParametersHolder parametersHolder) {
        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
        Intrinsics.checkNotNullParameter(parametersHolder, "<destruct>");
        return new SocialsSharingViewModel((Application) viewModel.e(Reflection.b(Application.class), null, null), (SocialsSharePayload) parametersHolder.b(0, Reflection.b(SocialsSharePayload.class)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StatisticsOverviewFragmentViewModel V1(Scope viewModel, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
        Intrinsics.checkNotNullParameter(it, "it");
        return new StatisticsOverviewFragmentViewModel((Application) viewModel.e(Reflection.b(Application.class), null, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TrialSummaryViewModel V2(Scope viewModel, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
        Intrinsics.checkNotNullParameter(it, "it");
        return new TrialSummaryViewModel((Application) viewModel.e(Reflection.b(Application.class), null, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PlainPaywallViewModel W1(Scope viewModel, ParametersHolder parametersHolder) {
        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
        Intrinsics.checkNotNullParameter(parametersHolder, "<destruct>");
        return new PlainPaywallViewModel((Application) viewModel.e(Reflection.b(Application.class), null, null), (PaywallTarget) parametersHolder.b(0, Reflection.b(PaywallTarget.class)), (PaywallSpec) parametersHolder.b(1, Reflection.b(PaywallSpec.class)), (PaywallHostViewModel.Launch) parametersHolder.b(2, Reflection.b(PaywallHostViewModel.Launch.class)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TrialRemindersViewModel W2(Scope viewModel, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
        Intrinsics.checkNotNullParameter(it, "it");
        return new TrialRemindersViewModel((Application) viewModel.e(Reflection.b(Application.class), null, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StatisticsDetailFragmentViewModel X1(Scope viewModel, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
        Intrinsics.checkNotNullParameter(it, "it");
        return new StatisticsDetailFragmentViewModel((Application) viewModel.e(Reflection.b(Application.class), null, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final EmailConsentViewModel X2(Scope viewModel, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
        Intrinsics.checkNotNullParameter(it, "it");
        return new EmailConsentViewModel((Application) viewModel.e(Reflection.b(Application.class), null, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DefaultApplicationSelectFragmentViewModel Y1(Scope viewModel, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
        Intrinsics.checkNotNullParameter(it, "it");
        return new DefaultApplicationSelectFragmentViewModel((Application) viewModel.e(Reflection.b(Application.class), null, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final RatingDialogViewModel Y2(Scope viewModel, ParametersHolder parametersHolder) {
        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
        Intrinsics.checkNotNullParameter(parametersHolder, "<destruct>");
        return new RatingDialogViewModel((Application) viewModel.e(Reflection.b(Application.class), null, null), (RatingTriggerSource) parametersHolder.b(0, Reflection.b(RatingTriggerSource.class)), ((Boolean) parametersHolder.b(1, Reflection.b(Boolean.class))).booleanValue());
    }

    public static final Module Z0() {
        return f96883a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IgnoreListCustomFragmentViewModel Z1(Scope viewModel, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
        Intrinsics.checkNotNullParameter(it, "it");
        return new IgnoreListCustomFragmentViewModel((Application) viewModel.e(Reflection.b(Application.class), null, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit a1(Module module) {
        Intrinsics.checkNotNullParameter(module, "$this$module");
        Function2 function2 = new Function2() { // from class: q0.u5
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ViewModelModuleKt.b1((Scope) obj, (ParametersHolder) obj2);
            }
        };
        ScopeRegistry.Companion companion = ScopeRegistry.f146057e;
        StringQualifier stringQualifierA = companion.a();
        Kind kind = Kind.Factory;
        FactoryInstanceFactory factoryInstanceFactory = new FactoryInstanceFactory(new BeanDefinition(stringQualifierA, Reflection.b(RecommendedAppsViewModel.class), null, function2, kind, CollectionsKt.emptyList()));
        module.f(factoryInstanceFactory);
        new KoinDefinition(module, factoryInstanceFactory);
        Function2 function22 = new Function2() { // from class: q0.o5
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ViewModelModuleKt.c1((Scope) obj, (ParametersHolder) obj2);
            }
        };
        FactoryInstanceFactory factoryInstanceFactory2 = new FactoryInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(AcademyAnotherCurrentLessonViewModel.class), null, function22, kind, CollectionsKt.emptyList()));
        module.f(factoryInstanceFactory2);
        new KoinDefinition(module, factoryInstanceFactory2);
        Function2 function23 = new Function2() { // from class: q0.a6
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ViewModelModuleKt.p1((Scope) obj, (ParametersHolder) obj2);
            }
        };
        FactoryInstanceFactory factoryInstanceFactory3 = new FactoryInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(AcademyCourseFinishedViewModel.class), null, function23, kind, CollectionsKt.emptyList()));
        module.f(factoryInstanceFactory3);
        new KoinDefinition(module, factoryInstanceFactory3);
        Function2 function24 = new Function2() { // from class: q0.m6
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ViewModelModuleKt.A1((Scope) obj, (ParametersHolder) obj2);
            }
        };
        FactoryInstanceFactory factoryInstanceFactory4 = new FactoryInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(AcademyLessonsViewModel.class), null, function24, kind, CollectionsKt.emptyList()));
        module.f(factoryInstanceFactory4);
        new KoinDefinition(module, factoryInstanceFactory4);
        Function2 function25 = new Function2() { // from class: q0.y6
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ViewModelModuleKt.L1((Scope) obj, (ParametersHolder) obj2);
            }
        };
        FactoryInstanceFactory factoryInstanceFactory5 = new FactoryInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(AcademyLessonViewModel.class), null, function25, kind, CollectionsKt.emptyList()));
        module.f(factoryInstanceFactory5);
        new KoinDefinition(module, factoryInstanceFactory5);
        Function2 function26 = new Function2() { // from class: q0.k7
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ViewModelModuleKt.W1((Scope) obj, (ParametersHolder) obj2);
            }
        };
        FactoryInstanceFactory factoryInstanceFactory6 = new FactoryInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(PlainPaywallViewModel.class), null, function26, kind, CollectionsKt.emptyList()));
        module.f(factoryInstanceFactory6);
        new KoinDefinition(module, factoryInstanceFactory6);
        Function2 function27 = new Function2() { // from class: q0.w7
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ViewModelModuleKt.h2((Scope) obj, (ParametersHolder) obj2);
            }
        };
        FactoryInstanceFactory factoryInstanceFactory7 = new FactoryInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(CampaignPaywallViewModel.class), null, function27, kind, CollectionsKt.emptyList()));
        module.f(factoryInstanceFactory7);
        new KoinDefinition(module, factoryInstanceFactory7);
        Function2 function28 = new Function2() { // from class: q0.j8
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ViewModelModuleKt.s2((Scope) obj, (ParametersHolder) obj2);
            }
        };
        FactoryInstanceFactory factoryInstanceFactory8 = new FactoryInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(SuperwallPlacementViewModel.class), null, function28, kind, CollectionsKt.emptyList()));
        module.f(factoryInstanceFactory8);
        new KoinDefinition(module, factoryInstanceFactory8);
        Function2 function29 = new Function2() { // from class: q0.v8
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ViewModelModuleKt.D2((Scope) obj, (ParametersHolder) obj2);
            }
        };
        FactoryInstanceFactory factoryInstanceFactory9 = new FactoryInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(ExitPaywallPremiumViewModel.class), null, function29, kind, CollectionsKt.emptyList()));
        module.f(factoryInstanceFactory9);
        new KoinDefinition(module, factoryInstanceFactory9);
        Function2 function210 = new Function2() { // from class: q0.j5
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ViewModelModuleKt.O2((Scope) obj, (ParametersHolder) obj2);
            }
        };
        FactoryInstanceFactory factoryInstanceFactory10 = new FactoryInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(BaseTimeSelectorBottomSheetViewModel.class), null, function210, kind, CollectionsKt.emptyList()));
        module.f(factoryInstanceFactory10);
        new KoinDefinition(module, factoryInstanceFactory10);
        Function2 function211 = new Function2() { // from class: q0.b7
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ViewModelModuleKt.d1((Scope) obj, (ParametersHolder) obj2);
            }
        };
        FactoryInstanceFactory factoryInstanceFactory11 = new FactoryInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(DashboardViewModel.class), null, function211, kind, CollectionsKt.emptyList()));
        module.f(factoryInstanceFactory11);
        new KoinDefinition(module, factoryInstanceFactory11);
        Function2 function212 = new Function2() { // from class: q0.m7
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ViewModelModuleKt.g1((Scope) obj, (ParametersHolder) obj2);
            }
        };
        FactoryInstanceFactory factoryInstanceFactory12 = new FactoryInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(InAppUpdateViewModel.class), null, function212, kind, CollectionsKt.emptyList()));
        module.f(factoryInstanceFactory12);
        new KoinDefinition(module, factoryInstanceFactory12);
        Function2 function213 = new Function2() { // from class: q0.x7
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ViewModelModuleKt.h1((Scope) obj, (ParametersHolder) obj2);
            }
        };
        FactoryInstanceFactory factoryInstanceFactory13 = new FactoryInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(ScheduleViewModel.class), null, function213, kind, CollectionsKt.emptyList()));
        module.f(factoryInstanceFactory13);
        new KoinDefinition(module, factoryInstanceFactory13);
        Function2 function214 = new Function2() { // from class: q0.i8
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ViewModelModuleKt.i1((Scope) obj, (ParametersHolder) obj2);
            }
        };
        FactoryInstanceFactory factoryInstanceFactory14 = new FactoryInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(TimeConditionViewModel.class), null, function214, kind, CollectionsKt.emptyList()));
        module.f(factoryInstanceFactory14);
        new KoinDefinition(module, factoryInstanceFactory14);
        Function2 function215 = new Function2() { // from class: q0.t8
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ViewModelModuleKt.j1((Scope) obj, (ParametersHolder) obj2);
            }
        };
        FactoryInstanceFactory factoryInstanceFactory15 = new FactoryInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(LaunchCountConditionViewModel.class), null, function215, kind, CollectionsKt.emptyList()));
        module.f(factoryInstanceFactory15);
        new KoinDefinition(module, factoryInstanceFactory15);
        Function2 function216 = new Function2() { // from class: q0.e9
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ViewModelModuleKt.k1((Scope) obj, (ParametersHolder) obj2);
            }
        };
        FactoryInstanceFactory factoryInstanceFactory16 = new FactoryInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(UsageLimitConditionViewModel.class), null, function216, kind, CollectionsKt.emptyList()));
        module.f(factoryInstanceFactory16);
        new KoinDefinition(module, factoryInstanceFactory16);
        Function2 function217 = new Function2() { // from class: q0.k5
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ViewModelModuleKt.l1((Scope) obj, (ParametersHolder) obj2);
            }
        };
        FactoryInstanceFactory factoryInstanceFactory17 = new FactoryInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(LocationConditionScreenViewModel.class), null, function217, kind, CollectionsKt.emptyList()));
        module.f(factoryInstanceFactory17);
        new KoinDefinition(module, factoryInstanceFactory17);
        Function2 function218 = new Function2() { // from class: q0.l5
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ViewModelModuleKt.m1((Scope) obj, (ParametersHolder) obj2);
            }
        };
        FactoryInstanceFactory factoryInstanceFactory18 = new FactoryInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(WifiConditionViewModel.class), null, function218, kind, CollectionsKt.emptyList()));
        module.f(factoryInstanceFactory18);
        new KoinDefinition(module, factoryInstanceFactory18);
        Function2 function219 = new Function2() { // from class: q0.m5
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ViewModelModuleKt.n1((Scope) obj, (ParametersHolder) obj2);
            }
        };
        FactoryInstanceFactory factoryInstanceFactory19 = new FactoryInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(CustomCombinationViewModel.class), null, function219, kind, CollectionsKt.emptyList()));
        module.f(factoryInstanceFactory19);
        new KoinDefinition(module, factoryInstanceFactory19);
        Function2 function220 = new Function2() { // from class: q0.n5
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ViewModelModuleKt.o1((Scope) obj, (ParametersHolder) obj2);
            }
        };
        FactoryInstanceFactory factoryInstanceFactory20 = new FactoryInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(PauseBlockingViewModel.class), null, function220, kind, CollectionsKt.emptyList()));
        module.f(factoryInstanceFactory20);
        new KoinDefinition(module, factoryInstanceFactory20);
        Function2 function221 = new Function2() { // from class: q0.p5
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ViewModelModuleKt.q1((Scope) obj, (ParametersHolder) obj2);
            }
        };
        FactoryInstanceFactory factoryInstanceFactory21 = new FactoryInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(BlockingSelectViewModel.class), null, function221, kind, CollectionsKt.emptyList()));
        module.f(factoryInstanceFactory21);
        new KoinDefinition(module, factoryInstanceFactory21);
        Function2 function222 = new Function2() { // from class: q0.q5
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ViewModelModuleKt.r1((Scope) obj, (ParametersHolder) obj2);
            }
        };
        FactoryInstanceFactory factoryInstanceFactory22 = new FactoryInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(PassCodeViewModel.class), null, function222, kind, CollectionsKt.emptyList()));
        module.f(factoryInstanceFactory22);
        new KoinDefinition(module, factoryInstanceFactory22);
        Function2 function223 = new Function2() { // from class: q0.r5
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ViewModelModuleKt.s1((Scope) obj, (ParametersHolder) obj2);
            }
        };
        FactoryInstanceFactory factoryInstanceFactory23 = new FactoryInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(StrictModePassCodeViewModel.class), null, function223, kind, CollectionsKt.emptyList()));
        module.f(factoryInstanceFactory23);
        new KoinDefinition(module, factoryInstanceFactory23);
        Function2 function224 = new Function2() { // from class: q0.s5
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ViewModelModuleKt.t1((Scope) obj, (ParametersHolder) obj2);
            }
        };
        FactoryInstanceFactory factoryInstanceFactory24 = new FactoryInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(IgnoreListSelectViewModel.class), null, function224, kind, CollectionsKt.emptyList()));
        module.f(factoryInstanceFactory24);
        new KoinDefinition(module, factoryInstanceFactory24);
        Function2 function225 = new Function2() { // from class: q0.t5
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ViewModelModuleKt.u1((Scope) obj, (ParametersHolder) obj2);
            }
        };
        FactoryInstanceFactory factoryInstanceFactory25 = new FactoryInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(TimeNudgeSelectViewModel.class), null, function225, kind, CollectionsKt.emptyList()));
        module.f(factoryInstanceFactory25);
        new KoinDefinition(module, factoryInstanceFactory25);
        Function2 function226 = new Function2() { // from class: q0.v5
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ViewModelModuleKt.v1((Scope) obj, (ParametersHolder) obj2);
            }
        };
        FactoryInstanceFactory factoryInstanceFactory26 = new FactoryInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(TimeSelectViewModel.class), null, function226, kind, CollectionsKt.emptyList()));
        module.f(factoryInstanceFactory26);
        new KoinDefinition(module, factoryInstanceFactory26);
        Function2 function227 = new Function2() { // from class: q0.w5
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ViewModelModuleKt.w1((Scope) obj, (ParametersHolder) obj2);
            }
        };
        FactoryInstanceFactory factoryInstanceFactory27 = new FactoryInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(ScheduleSelectViewModel.class), null, function227, kind, CollectionsKt.emptyList()));
        module.f(factoryInstanceFactory27);
        new KoinDefinition(module, factoryInstanceFactory27);
        Function2 function228 = new Function2() { // from class: q0.x5
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ViewModelModuleKt.x1((Scope) obj, (ParametersHolder) obj2);
            }
        };
        FactoryInstanceFactory factoryInstanceFactory28 = new FactoryInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(TroubleshootingStackViewModel.class), null, function228, kind, CollectionsKt.emptyList()));
        module.f(factoryInstanceFactory28);
        new KoinDefinition(module, factoryInstanceFactory28);
        Function2 function229 = new Function2() { // from class: q0.y5
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ViewModelModuleKt.y1((Scope) obj, (ParametersHolder) obj2);
            }
        };
        FactoryInstanceFactory factoryInstanceFactory29 = new FactoryInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(BlockingScreenViewModel.class), null, function229, kind, CollectionsKt.emptyList()));
        module.f(factoryInstanceFactory29);
        new KoinDefinition(module, factoryInstanceFactory29);
        Function2 function230 = new Function2() { // from class: q0.z5
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ViewModelModuleKt.z1((Scope) obj, (ParametersHolder) obj2);
            }
        };
        FactoryInstanceFactory factoryInstanceFactory30 = new FactoryInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(QuickBlockCardViewModel.class), null, function230, kind, CollectionsKt.emptyList()));
        module.f(factoryInstanceFactory30);
        new KoinDefinition(module, factoryInstanceFactory30);
        Function2 function231 = new Function2() { // from class: q0.b6
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ViewModelModuleKt.B1((Scope) obj, (ParametersHolder) obj2);
            }
        };
        FactoryInstanceFactory factoryInstanceFactory31 = new FactoryInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(FeedbackViewModel.class), null, function231, kind, CollectionsKt.emptyList()));
        module.f(factoryInstanceFactory31);
        new KoinDefinition(module, factoryInstanceFactory31);
        Function2 function232 = new Function2() { // from class: q0.c6
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ViewModelModuleKt.C1((Scope) obj, (ParametersHolder) obj2);
            }
        };
        FactoryInstanceFactory factoryInstanceFactory32 = new FactoryInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(SignInViewModel.class), null, function232, kind, CollectionsKt.emptyList()));
        module.f(factoryInstanceFactory32);
        new KoinDefinition(module, factoryInstanceFactory32);
        Function2 function233 = new Function2() { // from class: q0.d6
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ViewModelModuleKt.D1((Scope) obj, (ParametersHolder) obj2);
            }
        };
        FactoryInstanceFactory factoryInstanceFactory33 = new FactoryInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(MySubscriptionPaywallViewModel.class), null, function233, kind, CollectionsKt.emptyList()));
        module.f(factoryInstanceFactory33);
        new KoinDefinition(module, factoryInstanceFactory33);
        Function2 function234 = new Function2() { // from class: q0.e6
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ViewModelModuleKt.E1((Scope) obj, (ParametersHolder) obj2);
            }
        };
        FactoryInstanceFactory factoryInstanceFactory34 = new FactoryInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(DiscountPaywallViewModel.class), null, function234, kind, CollectionsKt.emptyList()));
        module.f(factoryInstanceFactory34);
        new KoinDefinition(module, factoryInstanceFactory34);
        Function2 function235 = new Function2() { // from class: q0.g6
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ViewModelModuleKt.F1((Scope) obj, (ParametersHolder) obj2);
            }
        };
        FactoryInstanceFactory factoryInstanceFactory35 = new FactoryInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(PremiumExpiringPurchaseViewModel.class), null, function235, kind, CollectionsKt.emptyList()));
        module.f(factoryInstanceFactory35);
        new KoinDefinition(module, factoryInstanceFactory35);
        Function2 function236 = new Function2() { // from class: q0.h6
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ViewModelModuleKt.G1((Scope) obj, (ParametersHolder) obj2);
            }
        };
        FactoryInstanceFactory factoryInstanceFactory36 = new FactoryInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(TimePickerViewModel.class), null, function236, kind, CollectionsKt.emptyList()));
        module.f(factoryInstanceFactory36);
        new KoinDefinition(module, factoryInstanceFactory36);
        Function2 function237 = new Function2() { // from class: q0.i6
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ViewModelModuleKt.H1((Scope) obj, (ParametersHolder) obj2);
            }
        };
        FactoryInstanceFactory factoryInstanceFactory37 = new FactoryInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(QuickBlockTimeSelectViewModel.class), null, function237, kind, CollectionsKt.emptyList()));
        module.f(factoryInstanceFactory37);
        new KoinDefinition(module, factoryInstanceFactory37);
        Function2 function238 = new Function2() { // from class: q0.j6
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ViewModelModuleKt.I1((Scope) obj, (ParametersHolder) obj2);
            }
        };
        FactoryInstanceFactory factoryInstanceFactory38 = new FactoryInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(HaFViewModel.class), null, function238, kind, CollectionsKt.emptyList()));
        module.f(factoryInstanceFactory38);
        new KoinDefinition(module, factoryInstanceFactory38);
        Function2 function239 = new Function2() { // from class: q0.k6
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ViewModelModuleKt.J1((Scope) obj, (ParametersHolder) obj2);
            }
        };
        FactoryInstanceFactory factoryInstanceFactory39 = new FactoryInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(InsightsViewModel.class), null, function239, kind, CollectionsKt.emptyList()));
        module.f(factoryInstanceFactory39);
        new KoinDefinition(module, factoryInstanceFactory39);
        Function2 function240 = new Function2() { // from class: q0.l6
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ViewModelModuleKt.K1((Scope) obj, (ParametersHolder) obj2);
            }
        };
        FactoryInstanceFactory factoryInstanceFactory40 = new FactoryInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(AppFeelViewModel.class), null, function240, kind, CollectionsKt.emptyList()));
        module.f(factoryInstanceFactory40);
        new KoinDefinition(module, factoryInstanceFactory40);
        Function2 function241 = new Function2() { // from class: q0.n6
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ViewModelModuleKt.M1((Scope) obj, (ParametersHolder) obj2);
            }
        };
        FactoryInstanceFactory factoryInstanceFactory41 = new FactoryInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(SchedulePreviewViewModel.class), null, function241, kind, CollectionsKt.emptyList()));
        module.f(factoryInstanceFactory41);
        new KoinDefinition(module, factoryInstanceFactory41);
        Function2 function242 = new Function2() { // from class: q0.o6
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ViewModelModuleKt.N1((Scope) obj, (ParametersHolder) obj2);
            }
        };
        FactoryInstanceFactory factoryInstanceFactory42 = new FactoryInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(BlockingModeSettingsViewModel.class), null, function242, kind, CollectionsKt.emptyList()));
        module.f(factoryInstanceFactory42);
        new KoinDefinition(module, factoryInstanceFactory42);
        Function2 function243 = new Function2() { // from class: q0.p6
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ViewModelModuleKt.O1((Scope) obj, (ParametersHolder) obj2);
            }
        };
        FactoryInstanceFactory factoryInstanceFactory43 = new FactoryInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(WhatsNewFullScreenViewModel.class), null, function243, kind, CollectionsKt.emptyList()));
        module.f(factoryInstanceFactory43);
        new KoinDefinition(module, factoryInstanceFactory43);
        Function2 function244 = new Function2() { // from class: q0.r6
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ViewModelModuleKt.P1((Scope) obj, (ParametersHolder) obj2);
            }
        };
        FactoryInstanceFactory factoryInstanceFactory44 = new FactoryInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(PermissionComposeViewModel.class), null, function244, kind, CollectionsKt.emptyList()));
        module.f(factoryInstanceFactory44);
        new KoinDefinition(module, factoryInstanceFactory44);
        Function2 function245 = new Function2() { // from class: q0.s6
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ViewModelModuleKt.Q1((Scope) obj, (ParametersHolder) obj2);
            }
        };
        FactoryInstanceFactory factoryInstanceFactory45 = new FactoryInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(LocationPermissionViewModel.class), null, function245, kind, CollectionsKt.emptyList()));
        module.f(factoryInstanceFactory45);
        new KoinDefinition(module, factoryInstanceFactory45);
        Function2 function246 = new Function2() { // from class: q0.t6
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ViewModelModuleKt.R1((Scope) obj, (ParametersHolder) obj2);
            }
        };
        FactoryInstanceFactory factoryInstanceFactory46 = new FactoryInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(GuestPassShareViewModel.class), null, function246, kind, CollectionsKt.emptyList()));
        module.f(factoryInstanceFactory46);
        new KoinDefinition(module, factoryInstanceFactory46);
        Function2 function247 = new Function2() { // from class: q0.u6
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ViewModelModuleKt.S1((Scope) obj, (ParametersHolder) obj2);
            }
        };
        FactoryInstanceFactory factoryInstanceFactory47 = new FactoryInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(AcademyCoursesViewModel.class), null, function247, kind, CollectionsKt.emptyList()));
        module.f(factoryInstanceFactory47);
        new KoinDefinition(module, factoryInstanceFactory47);
        Function2 function248 = new Function2() { // from class: q0.v6
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ViewModelModuleKt.T1((Scope) obj, (ParametersHolder) obj2);
            }
        };
        FactoryInstanceFactory factoryInstanceFactory48 = new FactoryInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(OnboardingViewModel.class), null, function248, kind, CollectionsKt.emptyList()));
        module.f(factoryInstanceFactory48);
        new KoinDefinition(module, factoryInstanceFactory48);
        Function2 function249 = new Function2() { // from class: q0.w6
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ViewModelModuleKt.U1((Scope) obj, (ParametersHolder) obj2);
            }
        };
        FactoryInstanceFactory factoryInstanceFactory49 = new FactoryInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(OnboardingViewModelV2.class), null, function249, kind, CollectionsKt.emptyList()));
        module.f(factoryInstanceFactory49);
        new KoinDefinition(module, factoryInstanceFactory49);
        Function2 function250 = new Function2() { // from class: q0.x6
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ViewModelModuleKt.V1((Scope) obj, (ParametersHolder) obj2);
            }
        };
        FactoryInstanceFactory factoryInstanceFactory50 = new FactoryInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(StatisticsOverviewFragmentViewModel.class), null, function250, kind, CollectionsKt.emptyList()));
        module.f(factoryInstanceFactory50);
        new KoinDefinition(module, factoryInstanceFactory50);
        Function2 function251 = new Function2() { // from class: q0.z6
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ViewModelModuleKt.X1((Scope) obj, (ParametersHolder) obj2);
            }
        };
        FactoryInstanceFactory factoryInstanceFactory51 = new FactoryInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(StatisticsDetailFragmentViewModel.class), null, function251, kind, CollectionsKt.emptyList()));
        module.f(factoryInstanceFactory51);
        new KoinDefinition(module, factoryInstanceFactory51);
        Function2 function252 = new Function2() { // from class: q0.a7
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ViewModelModuleKt.Y1((Scope) obj, (ParametersHolder) obj2);
            }
        };
        FactoryInstanceFactory factoryInstanceFactory52 = new FactoryInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(DefaultApplicationSelectFragmentViewModel.class), null, function252, kind, CollectionsKt.emptyList()));
        module.f(factoryInstanceFactory52);
        new KoinDefinition(module, factoryInstanceFactory52);
        Function2 function253 = new Function2() { // from class: q0.c7
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ViewModelModuleKt.Z1((Scope) obj, (ParametersHolder) obj2);
            }
        };
        FactoryInstanceFactory factoryInstanceFactory53 = new FactoryInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(IgnoreListCustomFragmentViewModel.class), null, function253, kind, CollectionsKt.emptyList()));
        module.f(factoryInstanceFactory53);
        new KoinDefinition(module, factoryInstanceFactory53);
        Function2 function254 = new Function2() { // from class: q0.d7
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ViewModelModuleKt.a2((Scope) obj, (ParametersHolder) obj2);
            }
        };
        FactoryInstanceFactory factoryInstanceFactory54 = new FactoryInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(IgnoreListDefaultFragmentViewModel.class), null, function254, kind, CollectionsKt.emptyList()));
        module.f(factoryInstanceFactory54);
        new KoinDefinition(module, factoryInstanceFactory54);
        Function2 function255 = new Function2() { // from class: q0.e7
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ViewModelModuleKt.b2((Scope) obj, (ParametersHolder) obj2);
            }
        };
        FactoryInstanceFactory factoryInstanceFactory55 = new FactoryInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(HelpViewModel.class), null, function255, kind, CollectionsKt.emptyList()));
        module.f(factoryInstanceFactory55);
        new KoinDefinition(module, factoryInstanceFactory55);
        Function2 function256 = new Function2() { // from class: q0.f7
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ViewModelModuleKt.c2((Scope) obj, (ParametersHolder) obj2);
            }
        };
        FactoryInstanceFactory factoryInstanceFactory56 = new FactoryInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(LocationPlacesSelectViewModel.class), null, function256, kind, CollectionsKt.emptyList()));
        module.f(factoryInstanceFactory56);
        new KoinDefinition(module, factoryInstanceFactory56);
        Function2 function257 = new Function2() { // from class: q0.g7
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ViewModelModuleKt.d2((Scope) obj, (ParametersHolder) obj2);
            }
        };
        FactoryInstanceFactory factoryInstanceFactory57 = new FactoryInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(BackupProgressViewModel.class), null, function257, kind, CollectionsKt.emptyList()));
        module.f(factoryInstanceFactory57);
        new KoinDefinition(module, factoryInstanceFactory57);
        Function2 function258 = new Function2() { // from class: q0.h7
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ViewModelModuleKt.e2((Scope) obj, (ParametersHolder) obj2);
            }
        };
        FactoryInstanceFactory factoryInstanceFactory58 = new FactoryInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(BackupMainViewModel.class), null, function258, kind, CollectionsKt.emptyList()));
        module.f(factoryInstanceFactory58);
        new KoinDefinition(module, factoryInstanceFactory58);
        Function2 function259 = new Function2() { // from class: q0.i7
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ViewModelModuleKt.f2((Scope) obj, (ParametersHolder) obj2);
            }
        };
        FactoryInstanceFactory factoryInstanceFactory59 = new FactoryInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(ChangelogViewModel.class), null, function259, kind, CollectionsKt.emptyList()));
        module.f(factoryInstanceFactory59);
        new KoinDefinition(module, factoryInstanceFactory59);
        Function2 function260 = new Function2() { // from class: q0.j7
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ViewModelModuleKt.g2((Scope) obj, (ParametersHolder) obj2);
            }
        };
        FactoryInstanceFactory factoryInstanceFactory60 = new FactoryInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(ProfileViewModel.class), null, function260, kind, CollectionsKt.emptyList()));
        module.f(factoryInstanceFactory60);
        new KoinDefinition(module, factoryInstanceFactory60);
        Function2 function261 = new Function2() { // from class: q0.l7
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ViewModelModuleKt.i2((Scope) obj, (ParametersHolder) obj2);
            }
        };
        FactoryInstanceFactory factoryInstanceFactory61 = new FactoryInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(DeveloperSettingsViewModel.class), null, function261, kind, CollectionsKt.emptyList()));
        module.f(factoryInstanceFactory61);
        new KoinDefinition(module, factoryInstanceFactory61);
        Function2 function262 = new Function2() { // from class: q0.n7
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ViewModelModuleKt.j2((Scope) obj, (ParametersHolder) obj2);
            }
        };
        FactoryInstanceFactory factoryInstanceFactory62 = new FactoryInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(RemoteConfigValuesViewModel.class), null, function262, kind, CollectionsKt.emptyList()));
        module.f(factoryInstanceFactory62);
        new KoinDefinition(module, factoryInstanceFactory62);
        Function2 function263 = new Function2() { // from class: q0.o7
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ViewModelModuleKt.k2((Scope) obj, (ParametersHolder) obj2);
            }
        };
        FactoryInstanceFactory factoryInstanceFactory63 = new FactoryInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(NotificationSettingsViewModel.class), null, function263, kind, CollectionsKt.emptyList()));
        module.f(factoryInstanceFactory63);
        new KoinDefinition(module, factoryInstanceFactory63);
        Function2 function264 = new Function2() { // from class: q0.p7
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ViewModelModuleKt.l2((Scope) obj, (ParametersHolder) obj2);
            }
        };
        FactoryInstanceFactory factoryInstanceFactory64 = new FactoryInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(IntroScheduleViewModel.class), null, function264, kind, CollectionsKt.emptyList()));
        module.f(factoryInstanceFactory64);
        new KoinDefinition(module, factoryInstanceFactory64);
        Function2 function265 = new Function2() { // from class: q0.q7
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ViewModelModuleKt.m2((Scope) obj, (ParametersHolder) obj2);
            }
        };
        FactoryInstanceFactory factoryInstanceFactory65 = new FactoryInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(QuickBlockBlockingTestViewModel.class), null, function265, kind, CollectionsKt.emptyList()));
        module.f(factoryInstanceFactory65);
        new KoinDefinition(module, factoryInstanceFactory65);
        Function2 function266 = new Function2() { // from class: q0.r7
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ViewModelModuleKt.n2((Scope) obj, (ParametersHolder) obj2);
            }
        };
        FactoryInstanceFactory factoryInstanceFactory66 = new FactoryInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(ReferralViewModel.class), null, function266, kind, CollectionsKt.emptyList()));
        module.f(factoryInstanceFactory66);
        new KoinDefinition(module, factoryInstanceFactory66);
        Function2 function267 = new Function2() { // from class: q0.s7
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ViewModelModuleKt.o2((Scope) obj, (ParametersHolder) obj2);
            }
        };
        FactoryInstanceFactory factoryInstanceFactory67 = new FactoryInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(BlockedNotificationsViewModel.class), null, function267, kind, CollectionsKt.emptyList()));
        module.f(factoryInstanceFactory67);
        new KoinDefinition(module, factoryInstanceFactory67);
        Function2 function268 = new Function2() { // from class: q0.t7
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ViewModelModuleKt.p2((Scope) obj, (ParametersHolder) obj2);
            }
        };
        FactoryInstanceFactory factoryInstanceFactory68 = new FactoryInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(BrowsersListViewModel.class), null, function268, kind, CollectionsKt.emptyList()));
        module.f(factoryInstanceFactory68);
        new KoinDefinition(module, factoryInstanceFactory68);
        Function2 function269 = new Function2() { // from class: q0.u7
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ViewModelModuleKt.q2((Scope) obj, (ParametersHolder) obj2);
            }
        };
        FactoryInstanceFactory factoryInstanceFactory69 = new FactoryInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(StrictMode3ViewModel.class), null, function269, kind, CollectionsKt.emptyList()));
        module.f(factoryInstanceFactory69);
        new KoinDefinition(module, factoryInstanceFactory69);
        Function2 function270 = new Function2() { // from class: q0.v7
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ViewModelModuleKt.r2((Scope) obj, (ParametersHolder) obj2);
            }
        };
        FactoryInstanceFactory factoryInstanceFactory70 = new FactoryInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(StrictModeOptionsViewModel.class), null, function270, kind, CollectionsKt.emptyList()));
        module.f(factoryInstanceFactory70);
        new KoinDefinition(module, factoryInstanceFactory70);
        Function2 function271 = new Function2() { // from class: q0.y7
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ViewModelModuleKt.t2((Scope) obj, (ParametersHolder) obj2);
            }
        };
        FactoryInstanceFactory factoryInstanceFactory71 = new FactoryInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(StrictModeAccessViewModel.class), null, function271, kind, CollectionsKt.emptyList()));
        module.f(factoryInstanceFactory71);
        new KoinDefinition(module, factoryInstanceFactory71);
        Function2 function272 = new Function2() { // from class: q0.z7
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ViewModelModuleKt.u2((Scope) obj, (ParametersHolder) obj2);
            }
        };
        FactoryInstanceFactory factoryInstanceFactory72 = new FactoryInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(StrictModeIntroViewModel.class), null, function272, kind, CollectionsKt.emptyList()));
        module.f(factoryInstanceFactory72);
        new KoinDefinition(module, factoryInstanceFactory72);
        Function2 function273 = new Function2() { // from class: q0.a8
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ViewModelModuleKt.v2((Scope) obj, (ParametersHolder) obj2);
            }
        };
        FactoryInstanceFactory factoryInstanceFactory73 = new FactoryInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(StrictModeEmailInputBottomSheetViewModel.class), null, function273, kind, CollectionsKt.emptyList()));
        module.f(factoryInstanceFactory73);
        new KoinDefinition(module, factoryInstanceFactory73);
        Function2 function274 = new Function2() { // from class: q0.b8
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ViewModelModuleKt.w2((Scope) obj, (ParametersHolder) obj2);
            }
        };
        FactoryInstanceFactory factoryInstanceFactory74 = new FactoryInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(RestorePurchaseViewModel.class), null, function274, kind, CollectionsKt.emptyList()));
        module.f(factoryInstanceFactory74);
        new KoinDefinition(module, factoryInstanceFactory74);
        Function2 function275 = new Function2() { // from class: q0.c8
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ViewModelModuleKt.x2((Scope) obj, (ParametersHolder) obj2);
            }
        };
        FactoryInstanceFactory factoryInstanceFactory75 = new FactoryInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(LockViewModel.class), null, function275, kind, CollectionsKt.emptyList()));
        module.f(factoryInstanceFactory75);
        new KoinDefinition(module, factoryInstanceFactory75);
        Function2 function276 = new Function2() { // from class: q0.d8
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ViewModelModuleKt.y2((Scope) obj, (ParametersHolder) obj2);
            }
        };
        FactoryInstanceFactory factoryInstanceFactory76 = new FactoryInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(DevEventsViewModel.class), null, function276, kind, CollectionsKt.emptyList()));
        module.f(factoryInstanceFactory76);
        new KoinDefinition(module, factoryInstanceFactory76);
        Function2 function277 = new Function2() { // from class: q0.e8
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ViewModelModuleKt.z2((Scope) obj, (ParametersHolder) obj2);
            }
        };
        FactoryInstanceFactory factoryInstanceFactory77 = new FactoryInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(AccountDetailViewModel.class), null, function277, kind, CollectionsKt.emptyList()));
        module.f(factoryInstanceFactory77);
        new KoinDefinition(module, factoryInstanceFactory77);
        Function2 function278 = new Function2() { // from class: q0.f8
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ViewModelModuleKt.A2((Scope) obj, (ParametersHolder) obj2);
            }
        };
        FactoryInstanceFactory factoryInstanceFactory78 = new FactoryInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(ExcludedUnsupportedBrowsersViewModel.class), null, function278, kind, CollectionsKt.emptyList()));
        module.f(factoryInstanceFactory78);
        new KoinDefinition(module, factoryInstanceFactory78);
        Function2 function279 = new Function2() { // from class: q0.g8
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ViewModelModuleKt.B2((Scope) obj, (ParametersHolder) obj2);
            }
        };
        FactoryInstanceFactory factoryInstanceFactory79 = new FactoryInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(IntroChatBotViewModel.class), null, function279, kind, CollectionsKt.emptyList()));
        module.f(factoryInstanceFactory79);
        new KoinDefinition(module, factoryInstanceFactory79);
        Function2 function280 = new Function2() { // from class: q0.h8
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ViewModelModuleKt.C2((Scope) obj, (ParametersHolder) obj2);
            }
        };
        FactoryInstanceFactory factoryInstanceFactory80 = new FactoryInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(PomodoroViewModel.class), null, function280, kind, CollectionsKt.emptyList()));
        module.f(factoryInstanceFactory80);
        new KoinDefinition(module, factoryInstanceFactory80);
        Function2 function281 = new Function2() { // from class: q0.k8
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ViewModelModuleKt.E2((Scope) obj, (ParametersHolder) obj2);
            }
        };
        FactoryInstanceFactory factoryInstanceFactory81 = new FactoryInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(BackdoorFeedbackViewModel.class), null, function281, kind, CollectionsKt.emptyList()));
        module.f(factoryInstanceFactory81);
        new KoinDefinition(module, factoryInstanceFactory81);
        Function2 function282 = new Function2() { // from class: q0.l8
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ViewModelModuleKt.F2((Scope) obj, (ParametersHolder) obj2);
            }
        };
        FactoryInstanceFactory factoryInstanceFactory82 = new FactoryInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(PremiumExpiringViewModel.class), null, function282, kind, CollectionsKt.emptyList()));
        module.f(factoryInstanceFactory82);
        new KoinDefinition(module, factoryInstanceFactory82);
        Function2 function283 = new Function2() { // from class: q0.m8
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ViewModelModuleKt.G2((Scope) obj, (ParametersHolder) obj2);
            }
        };
        FactoryInstanceFactory factoryInstanceFactory83 = new FactoryInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(EmergencyUnblockViewModel.class), null, function283, kind, CollectionsKt.emptyList()));
        module.f(factoryInstanceFactory83);
        new KoinDefinition(module, factoryInstanceFactory83);
        Function2 function284 = new Function2() { // from class: q0.n8
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ViewModelModuleKt.H2((Scope) obj, (ParametersHolder) obj2);
            }
        };
        FactoryInstanceFactory factoryInstanceFactory84 = new FactoryInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(GeneralSettingsViewModel.class), null, function284, kind, CollectionsKt.emptyList()));
        module.f(factoryInstanceFactory84);
        new KoinDefinition(module, factoryInstanceFactory84);
        Function2 function285 = new Function2() { // from class: q0.o8
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ViewModelModuleKt.I2((Scope) obj, (ParametersHolder) obj2);
            }
        };
        FactoryInstanceFactory factoryInstanceFactory85 = new FactoryInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(BlockingPreferencesViewModel.class), null, function285, kind, CollectionsKt.emptyList()));
        module.f(factoryInstanceFactory85);
        new KoinDefinition(module, factoryInstanceFactory85);
        Function2 function286 = new Function2() { // from class: q0.p8
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ViewModelModuleKt.J2((Scope) obj, (ParametersHolder) obj2);
            }
        };
        FactoryInstanceFactory factoryInstanceFactory86 = new FactoryInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(StatisticsSettingsViewModel.class), null, function286, kind, CollectionsKt.emptyList()));
        module.f(factoryInstanceFactory86);
        new KoinDefinition(module, factoryInstanceFactory86);
        Function2 function287 = new Function2() { // from class: q0.q8
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ViewModelModuleKt.K2((Scope) obj, (ParametersHolder) obj2);
            }
        };
        FactoryInstanceFactory factoryInstanceFactory87 = new FactoryInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(TimeNudgeSettingsViewModel.class), null, function287, kind, CollectionsKt.emptyList()));
        module.f(factoryInstanceFactory87);
        new KoinDefinition(module, factoryInstanceFactory87);
        Function2 function288 = new Function2() { // from class: q0.r8
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ViewModelModuleKt.L2((Scope) obj, (ParametersHolder) obj2);
            }
        };
        FactoryInstanceFactory factoryInstanceFactory88 = new FactoryInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(TimeNudgeViewModel.class), null, function288, kind, CollectionsKt.emptyList()));
        module.f(factoryInstanceFactory88);
        new KoinDefinition(module, factoryInstanceFactory88);
        Function2 function289 = new Function2() { // from class: q0.s8
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ViewModelModuleKt.M2((Scope) obj, (ParametersHolder) obj2);
            }
        };
        FactoryInstanceFactory factoryInstanceFactory89 = new FactoryInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(CustomBlockingViewModel.class), null, function289, kind, CollectionsKt.emptyList()));
        module.f(factoryInstanceFactory89);
        new KoinDefinition(module, factoryInstanceFactory89);
        Function2 function290 = new Function2() { // from class: q0.u8
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ViewModelModuleKt.N2((Scope) obj, (ParametersHolder) obj2);
            }
        };
        FactoryInstanceFactory factoryInstanceFactory90 = new FactoryInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(AppIconSelectViewModel.class), null, function290, kind, CollectionsKt.emptyList()));
        module.f(factoryInstanceFactory90);
        new KoinDefinition(module, factoryInstanceFactory90);
        Function2 function291 = new Function2() { // from class: q0.w8
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ViewModelModuleKt.P2((Scope) obj, (ParametersHolder) obj2);
            }
        };
        FactoryInstanceFactory factoryInstanceFactory91 = new FactoryInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(ExcludedAppsViewModel.class), null, function291, kind, CollectionsKt.emptyList()));
        module.f(factoryInstanceFactory91);
        new KoinDefinition(module, factoryInstanceFactory91);
        Function2 function292 = new Function2() { // from class: q0.x8
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ViewModelModuleKt.Q2((Scope) obj, (ParametersHolder) obj2);
            }
        };
        FactoryInstanceFactory factoryInstanceFactory92 = new FactoryInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(StreakDetailViewModel.class), null, function292, kind, CollectionsKt.emptyList()));
        module.f(factoryInstanceFactory92);
        new KoinDefinition(module, factoryInstanceFactory92);
        Function2 function293 = new Function2() { // from class: q0.y8
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ViewModelModuleKt.R2((Scope) obj, (ParametersHolder) obj2);
            }
        };
        FactoryInstanceFactory factoryInstanceFactory93 = new FactoryInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(StreakFeedbackViewModel.class), null, function293, kind, CollectionsKt.emptyList()));
        module.f(factoryInstanceFactory93);
        new KoinDefinition(module, factoryInstanceFactory93);
        Function2 function294 = new Function2() { // from class: q0.z8
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ViewModelModuleKt.S2((Scope) obj, (ParametersHolder) obj2);
            }
        };
        FactoryInstanceFactory factoryInstanceFactory94 = new FactoryInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(StreakMilestoneViewModel.class), null, function294, kind, CollectionsKt.emptyList()));
        module.f(factoryInstanceFactory94);
        new KoinDefinition(module, factoryInstanceFactory94);
        Function2 function295 = new Function2() { // from class: q0.a9
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ViewModelModuleKt.T2((Scope) obj, (ParametersHolder) obj2);
            }
        };
        FactoryInstanceFactory factoryInstanceFactory95 = new FactoryInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(WeeklyInsightsViewModel.class), null, function295, kind, CollectionsKt.emptyList()));
        module.f(factoryInstanceFactory95);
        new KoinDefinition(module, factoryInstanceFactory95);
        Function2 function296 = new Function2() { // from class: q0.b9
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ViewModelModuleKt.U2((Scope) obj, (ParametersHolder) obj2);
            }
        };
        FactoryInstanceFactory factoryInstanceFactory96 = new FactoryInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(SocialsSharingViewModel.class), null, function296, kind, CollectionsKt.emptyList()));
        module.f(factoryInstanceFactory96);
        new KoinDefinition(module, factoryInstanceFactory96);
        Function2 function297 = new Function2() { // from class: q0.c9
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ViewModelModuleKt.V2((Scope) obj, (ParametersHolder) obj2);
            }
        };
        FactoryInstanceFactory factoryInstanceFactory97 = new FactoryInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(TrialSummaryViewModel.class), null, function297, kind, CollectionsKt.emptyList()));
        module.f(factoryInstanceFactory97);
        new KoinDefinition(module, factoryInstanceFactory97);
        Function2 function298 = new Function2() { // from class: q0.d9
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ViewModelModuleKt.W2((Scope) obj, (ParametersHolder) obj2);
            }
        };
        FactoryInstanceFactory factoryInstanceFactory98 = new FactoryInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(TrialRemindersViewModel.class), null, function298, kind, CollectionsKt.emptyList()));
        module.f(factoryInstanceFactory98);
        new KoinDefinition(module, factoryInstanceFactory98);
        Function2 function299 = new Function2() { // from class: q0.h5
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ViewModelModuleKt.X2((Scope) obj, (ParametersHolder) obj2);
            }
        };
        FactoryInstanceFactory factoryInstanceFactory99 = new FactoryInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(EmailConsentViewModel.class), null, function299, kind, CollectionsKt.emptyList()));
        module.f(factoryInstanceFactory99);
        new KoinDefinition(module, factoryInstanceFactory99);
        Function2 function2100 = new Function2() { // from class: q0.i5
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ViewModelModuleKt.Y2((Scope) obj, (ParametersHolder) obj2);
            }
        };
        FactoryInstanceFactory factoryInstanceFactory100 = new FactoryInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(RatingDialogViewModel.class), null, function2100, kind, CollectionsKt.emptyList()));
        module.f(factoryInstanceFactory100);
        new KoinDefinition(module, factoryInstanceFactory100);
        Function2 function2101 = new Function2() { // from class: q0.f6
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ViewModelModuleKt.e1((Scope) obj, (ParametersHolder) obj2);
            }
        };
        FactoryInstanceFactory factoryInstanceFactory101 = new FactoryInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(RatingFlowViewModel.class), null, function2101, kind, CollectionsKt.emptyList()));
        module.f(factoryInstanceFactory101);
        new KoinDefinition(module, factoryInstanceFactory101);
        Function2 function2102 = new Function2() { // from class: q0.q6
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ViewModelModuleKt.f1((Scope) obj, (ParametersHolder) obj2);
            }
        };
        FactoryInstanceFactory factoryInstanceFactory102 = new FactoryInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(UnlockAllAppsViewModel.class), null, function2102, kind, CollectionsKt.emptyList()));
        module.f(factoryInstanceFactory102);
        new KoinDefinition(module, factoryInstanceFactory102);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IgnoreListDefaultFragmentViewModel a2(Scope viewModel, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
        Intrinsics.checkNotNullParameter(it, "it");
        return new IgnoreListDefaultFragmentViewModel((Application) viewModel.e(Reflection.b(Application.class), null, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final RecommendedAppsViewModel b1(Scope viewModel, ParametersHolder parametersHolder) {
        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
        Intrinsics.checkNotNullParameter(parametersHolder, "<destruct>");
        return new RecommendedAppsViewModel((Application) viewModel.e(Reflection.b(Application.class), null, null), (List) parametersHolder.b(0, Reflection.b(List.class)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final HelpViewModel b2(Scope viewModel, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
        Intrinsics.checkNotNullParameter(it, "it");
        return new HelpViewModel((Application) viewModel.e(Reflection.b(Application.class), null, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AcademyAnotherCurrentLessonViewModel c1(Scope viewModel, ParametersHolder parametersHolder) {
        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
        Intrinsics.checkNotNullParameter(parametersHolder, "<destruct>");
        return new AcademyAnotherCurrentLessonViewModel((Application) viewModel.e(Reflection.b(Application.class), null, null), ((Number) parametersHolder.b(0, Reflection.b(Long.class))).longValue(), ((Number) parametersHolder.b(1, Reflection.b(Long.class))).longValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LocationPlacesSelectViewModel c2(Scope viewModel, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
        Intrinsics.checkNotNullParameter(it, "it");
        return new LocationPlacesSelectViewModel((Application) viewModel.e(Reflection.b(Application.class), null, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DashboardViewModel d1(Scope viewModel, ParametersHolder parametersHolder) {
        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
        Intrinsics.checkNotNullParameter(parametersHolder, "<destruct>");
        return new DashboardViewModel((Application) viewModel.e(Reflection.b(Application.class), null, null), (DashboardActivity.NavBarItem) parametersHolder.b(0, Reflection.b(DashboardActivity.NavBarItem.class)), (PremiumRepositoryV2) viewModel.e(Reflection.b(PremiumRepositoryV2.class), null, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BackupProgressViewModel d2(Scope viewModel, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
        Intrinsics.checkNotNullParameter(it, "it");
        return new BackupProgressViewModel((Application) viewModel.e(Reflection.b(Application.class), null, null), (TokenFCMDao) viewModel.e(Reflection.b(TokenFCMDao.class), null, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final RatingFlowViewModel e1(Scope viewModel, ParametersHolder parametersHolder) {
        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
        Intrinsics.checkNotNullParameter(parametersHolder, "<destruct>");
        return new RatingFlowViewModel((Application) viewModel.e(Reflection.b(Application.class), null, null), (RatingTriggerSource) parametersHolder.b(0, Reflection.b(RatingTriggerSource.class)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BackupMainViewModel e2(Scope viewModel, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
        Intrinsics.checkNotNullParameter(it, "it");
        return new BackupMainViewModel((Application) viewModel.e(Reflection.b(Application.class), null, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final UnlockAllAppsViewModel f1(Scope viewModel, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
        Intrinsics.checkNotNullParameter(it, "it");
        return new UnlockAllAppsViewModel((Application) viewModel.e(Reflection.b(Application.class), null, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ChangelogViewModel f2(Scope viewModel, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
        Intrinsics.checkNotNullParameter(it, "it");
        return new ChangelogViewModel((Application) viewModel.e(Reflection.b(Application.class), null, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InAppUpdateViewModel g1(Scope viewModel, ParametersHolder parametersHolder) {
        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
        Intrinsics.checkNotNullParameter(parametersHolder, "<destruct>");
        return new InAppUpdateViewModel((Application) viewModel.e(Reflection.b(Application.class), null, null), (String) parametersHolder.b(0, Reflection.b(String.class)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ProfileViewModel g2(Scope viewModel, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
        Intrinsics.checkNotNullParameter(it, "it");
        return new ProfileViewModel((Application) viewModel.e(Reflection.b(Application.class), null, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ScheduleViewModel h1(Scope viewModel, ParametersHolder parametersHolder) {
        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
        Intrinsics.checkNotNullParameter(parametersHolder, "<destruct>");
        return new ScheduleViewModel((Application) viewModel.e(Reflection.b(Application.class), null, null), (ScheduleDescriptor) parametersHolder.b(0, Reflection.b(ScheduleDescriptor.class)), ((Boolean) parametersHolder.b(1, Reflection.b(Boolean.class))).booleanValue(), (InitApplicationsUseCase) viewModel.e(Reflection.b(InitApplicationsUseCase.class), null, null), (PremiumRepositoryV2) viewModel.e(Reflection.b(PremiumRepositoryV2.class), null, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CampaignPaywallViewModel h2(Scope viewModel, ParametersHolder parametersHolder) {
        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
        Intrinsics.checkNotNullParameter(parametersHolder, "<destruct>");
        return new CampaignPaywallViewModel((Application) viewModel.e(Reflection.b(Application.class), null, null), (PaywallTarget.Campaign) parametersHolder.b(0, Reflection.b(PaywallTarget.Campaign.class)), (PaywallSpec) parametersHolder.b(1, Reflection.b(PaywallSpec.class)), (PaywallHostViewModel.Launch) parametersHolder.b(2, Reflection.b(PaywallHostViewModel.Launch.class)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TimeConditionViewModel i1(Scope viewModel, ParametersHolder parametersHolder) {
        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
        Intrinsics.checkNotNullParameter(parametersHolder, "<destruct>");
        return new TimeConditionViewModel((Application) viewModel.e(Reflection.b(Application.class), null, null), (ConditionDTO.TimeDTO) parametersHolder.b(0, Reflection.b(ConditionDTO.TimeDTO.class)), (Long) parametersHolder.b(1, Reflection.b(Long.class)), ((Boolean) parametersHolder.b(2, Reflection.b(Boolean.class))).booleanValue(), (PremiumRepositoryV2) viewModel.e(Reflection.b(PremiumRepositoryV2.class), null, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DeveloperSettingsViewModel i2(Scope viewModel, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
        Intrinsics.checkNotNullParameter(it, "it");
        return new DeveloperSettingsViewModel((Application) viewModel.e(Reflection.b(Application.class), null, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LaunchCountConditionViewModel j1(Scope viewModel, ParametersHolder parametersHolder) {
        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
        Intrinsics.checkNotNullParameter(parametersHolder, "<destruct>");
        return new LaunchCountConditionViewModel((Application) viewModel.e(Reflection.b(Application.class), null, null), (ConditionDTO.LaunchCountDTO) parametersHolder.b(0, Reflection.b(ConditionDTO.LaunchCountDTO.class)), (Long) parametersHolder.b(1, Reflection.b(Long.class)), ((Boolean) parametersHolder.b(2, Reflection.b(Boolean.class))).booleanValue(), (PremiumRepositoryV2) viewModel.e(Reflection.b(PremiumRepositoryV2.class), null, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final RemoteConfigValuesViewModel j2(Scope viewModel, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
        Intrinsics.checkNotNullParameter(it, "it");
        return new RemoteConfigValuesViewModel((Application) viewModel.e(Reflection.b(Application.class), null, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final UsageLimitConditionViewModel k1(Scope viewModel, ParametersHolder parametersHolder) {
        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
        Intrinsics.checkNotNullParameter(parametersHolder, "<destruct>");
        return new UsageLimitConditionViewModel((Application) viewModel.e(Reflection.b(Application.class), null, null), (ConditionDTO.UsageLimitDTO) parametersHolder.b(0, Reflection.b(ConditionDTO.UsageLimitDTO.class)), (Long) parametersHolder.b(1, Reflection.b(Long.class)), ((Boolean) parametersHolder.b(2, Reflection.b(Boolean.class))).booleanValue(), (PremiumRepositoryV2) viewModel.e(Reflection.b(PremiumRepositoryV2.class), null, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final NotificationSettingsViewModel k2(Scope viewModel, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
        Intrinsics.checkNotNullParameter(it, "it");
        return new NotificationSettingsViewModel((Application) viewModel.e(Reflection.b(Application.class), null, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LocationConditionScreenViewModel l1(Scope viewModel, ParametersHolder parametersHolder) {
        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
        Intrinsics.checkNotNullParameter(parametersHolder, "<destruct>");
        return new LocationConditionScreenViewModel((Application) viewModel.e(Reflection.b(Application.class), null, null), (ConditionDTO.LocationDTO) parametersHolder.b(0, Reflection.b(ConditionDTO.LocationDTO.class)), (Long) parametersHolder.b(1, Reflection.b(Long.class)), ((Boolean) parametersHolder.b(2, Reflection.b(Boolean.class))).booleanValue(), (PremiumRepositoryV2) viewModel.e(Reflection.b(PremiumRepositoryV2.class), null, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IntroScheduleViewModel l2(Scope viewModel, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
        Intrinsics.checkNotNullParameter(it, "it");
        return new IntroScheduleViewModel((Application) viewModel.e(Reflection.b(Application.class), null, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WifiConditionViewModel m1(Scope viewModel, ParametersHolder parametersHolder) {
        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
        Intrinsics.checkNotNullParameter(parametersHolder, "<destruct>");
        return new WifiConditionViewModel((Application) viewModel.e(Reflection.b(Application.class), null, null), (ConditionDTO.WifisDTO) parametersHolder.b(0, Reflection.b(ConditionDTO.WifisDTO.class)), (Long) parametersHolder.b(1, Reflection.b(Long.class)), ((Boolean) parametersHolder.b(2, Reflection.b(Boolean.class))).booleanValue(), (PremiumRepositoryV2) viewModel.e(Reflection.b(PremiumRepositoryV2.class), null, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final QuickBlockBlockingTestViewModel m2(Scope viewModel, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
        Intrinsics.checkNotNullParameter(it, "it");
        return new QuickBlockBlockingTestViewModel((Application) viewModel.e(Reflection.b(Application.class), null, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CustomCombinationViewModel n1(Scope viewModel, ParametersHolder parametersHolder) {
        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
        Intrinsics.checkNotNullParameter(parametersHolder, "<destruct>");
        return new CustomCombinationViewModel((Application) viewModel.e(Reflection.b(Application.class), null, null), (ConditionDTO.CombinationDTO) parametersHolder.b(0, Reflection.b(ConditionDTO.CombinationDTO.class)), (Long) parametersHolder.b(1, Reflection.b(Long.class)), ((Boolean) parametersHolder.b(2, Reflection.b(Boolean.class))).booleanValue(), ((Boolean) parametersHolder.b(3, Reflection.b(Boolean.class))).booleanValue(), (PremiumRepositoryV2) viewModel.e(Reflection.b(PremiumRepositoryV2.class), null, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ReferralViewModel n2(Scope viewModel, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
        Intrinsics.checkNotNullParameter(it, "it");
        return new ReferralViewModel((Application) viewModel.e(Reflection.b(Application.class), null, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PauseBlockingViewModel o1(Scope viewModel, ParametersHolder parametersHolder) {
        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
        Intrinsics.checkNotNullParameter(parametersHolder, "<destruct>");
        return new PauseBlockingViewModel((Application) viewModel.e(Reflection.b(Application.class), null, null), ((Number) parametersHolder.b(0, Reflection.b(Long.class))).longValue(), (PremiumState) parametersHolder.b(1, Reflection.b(PremiumState.class)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BlockedNotificationsViewModel o2(Scope viewModel, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
        Intrinsics.checkNotNullParameter(it, "it");
        return new BlockedNotificationsViewModel((Application) viewModel.e(Reflection.b(Application.class), null, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AcademyCourseFinishedViewModel p1(Scope viewModel, ParametersHolder parametersHolder) {
        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
        Intrinsics.checkNotNullParameter(parametersHolder, "<destruct>");
        return new AcademyCourseFinishedViewModel((Application) viewModel.e(Reflection.b(Application.class), null, null), ((Number) parametersHolder.b(0, Reflection.b(Long.class))).longValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BrowsersListViewModel p2(Scope viewModel, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
        Intrinsics.checkNotNullParameter(it, "it");
        return new BrowsersListViewModel((Application) viewModel.e(Reflection.b(Application.class), null, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BlockingSelectViewModel q1(Scope viewModel, ParametersHolder parametersHolder) {
        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
        Intrinsics.checkNotNullParameter(parametersHolder, "<destruct>");
        return new BlockingSelectViewModel((Application) viewModel.e(Reflection.b(Application.class), null, null), (BaseSelectionViewModel.ApplicationWebsiteSelectDTO) parametersHolder.b(0, Reflection.b(BaseSelectionViewModel.ApplicationWebsiteSelectDTO.class)), (InitApplicationsUseCase) viewModel.e(Reflection.b(InitApplicationsUseCase.class), null, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StrictMode3ViewModel q2(Scope viewModel, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
        Intrinsics.checkNotNullParameter(it, "it");
        return new StrictMode3ViewModel((Application) viewModel.e(Reflection.b(Application.class), null, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PassCodeViewModel r1(Scope viewModel, ParametersHolder parametersHolder) {
        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
        Intrinsics.checkNotNullParameter(parametersHolder, "<destruct>");
        return new PassCodeViewModel((Application) viewModel.e(Reflection.b(Application.class), null, null), (PassCodeType) parametersHolder.b(0, Reflection.b(PassCodeType.class)), (PassCodeDataStore) viewModel.e(Reflection.b(PassCodeDataStore.class), null, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StrictModeOptionsViewModel r2(Scope viewModel, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
        Intrinsics.checkNotNullParameter(it, "it");
        return new StrictModeOptionsViewModel((Application) viewModel.e(Reflection.b(Application.class), null, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StrictModePassCodeViewModel s1(Scope viewModel, ParametersHolder parametersHolder) {
        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
        Intrinsics.checkNotNullParameter(parametersHolder, "<destruct>");
        return new StrictModePassCodeViewModel((Application) viewModel.e(Reflection.b(Application.class), null, null), (PassCodeType) parametersHolder.b(0, Reflection.b(PassCodeType.class)), (StrictModeDataStore) viewModel.e(Reflection.b(StrictModeDataStore.class), null, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SuperwallPlacementViewModel s2(Scope viewModel, ParametersHolder parametersHolder) {
        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
        Intrinsics.checkNotNullParameter(parametersHolder, "<destruct>");
        return new SuperwallPlacementViewModel((Application) viewModel.e(Reflection.b(Application.class), null, null), (SavedStateHandle) viewModel.e(Reflection.b(SavedStateHandle.class), null, null), (SuperwallPlacementViewModel.Param) parametersHolder.b(0, Reflection.b(SuperwallPlacementViewModel.Param.class)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IgnoreListSelectViewModel t1(Scope viewModel, ParametersHolder parametersHolder) {
        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
        Intrinsics.checkNotNullParameter(parametersHolder, "<destruct>");
        return new IgnoreListSelectViewModel((Application) viewModel.e(Reflection.b(Application.class), null, null), (BaseSelectionViewModel.ApplicationWebsiteSelectDTO) parametersHolder.b(0, Reflection.b(BaseSelectionViewModel.ApplicationWebsiteSelectDTO.class)), (InitApplicationsUseCase) viewModel.e(Reflection.b(InitApplicationsUseCase.class), null, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StrictModeAccessViewModel t2(Scope viewModel, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
        Intrinsics.checkNotNullParameter(it, "it");
        return new StrictModeAccessViewModel((Application) viewModel.e(Reflection.b(Application.class), null, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TimeNudgeSelectViewModel u1(Scope viewModel, ParametersHolder parametersHolder) {
        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
        Intrinsics.checkNotNullParameter(parametersHolder, "<destruct>");
        return new TimeNudgeSelectViewModel((Application) viewModel.e(Reflection.b(Application.class), null, null), (BaseSelectionViewModel.ApplicationWebsiteSelectDTO) parametersHolder.b(0, Reflection.b(BaseSelectionViewModel.ApplicationWebsiteSelectDTO.class)), (InitApplicationsUseCase) viewModel.e(Reflection.b(InitApplicationsUseCase.class), null, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StrictModeIntroViewModel u2(Scope viewModel, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
        Intrinsics.checkNotNullParameter(it, "it");
        return new StrictModeIntroViewModel((LockieApplication) viewModel.e(Reflection.b(LockieApplication.class), null, null), (ProfileDao) viewModel.e(Reflection.b(ProfileDao.class), null, null), (StrictModeDataStore) viewModel.e(Reflection.b(StrictModeDataStore.class), null, null), (StrictModeRepository) viewModel.e(Reflection.b(StrictModeRepository.class), null, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TimeSelectViewModel v1(Scope viewModel, ParametersHolder parametersHolder) {
        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
        Intrinsics.checkNotNullParameter(parametersHolder, "<destruct>");
        return new TimeSelectViewModel((Application) viewModel.e(Reflection.b(Application.class), null, null), ((Number) parametersHolder.b(0, Reflection.b(Long.class))).longValue(), ((Boolean) parametersHolder.b(1, Reflection.b(Boolean.class))).booleanValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StrictModeEmailInputBottomSheetViewModel v2(Scope viewModel, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
        Intrinsics.checkNotNullParameter(it, "it");
        return new StrictModeEmailInputBottomSheetViewModel((Application) viewModel.e(Reflection.b(Application.class), null, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ScheduleSelectViewModel w1(Scope viewModel, ParametersHolder parametersHolder) {
        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
        Intrinsics.checkNotNullParameter(parametersHolder, "<destruct>");
        return new ScheduleSelectViewModel((StrictModeAccessMethod) parametersHolder.b(0, Reflection.b(StrictModeAccessMethod.class)), (long[]) parametersHolder.b(1, Reflection.b(long[].class)), ((Boolean) parametersHolder.b(2, Reflection.b(Boolean.class))).booleanValue(), (Application) viewModel.e(Reflection.b(Application.class), null, null), (ProfileDao) viewModel.e(Reflection.b(ProfileDao.class), null, null), (IntervalDao) viewModel.e(Reflection.b(IntervalDao.class), null, null), (StrictModeRepository) viewModel.e(Reflection.b(StrictModeRepository.class), null, null), (WillBeContinuousUseCase) viewModel.e(Reflection.b(WillBeContinuousUseCase.class), null, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final RestorePurchaseViewModel w2(Scope viewModel, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
        Intrinsics.checkNotNullParameter(it, "it");
        return new RestorePurchaseViewModel((Application) viewModel.e(Reflection.b(Application.class), null, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TroubleshootingStackViewModel x1(Scope viewModel, ParametersHolder parametersHolder) {
        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
        Intrinsics.checkNotNullParameter(parametersHolder, "<destruct>");
        return new TroubleshootingStackViewModel((List) parametersHolder.b(0, Reflection.b(List.class)), (Application) viewModel.e(Reflection.b(Application.class), null, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LockViewModel x2(Scope viewModel, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
        Intrinsics.checkNotNullParameter(it, "it");
        return new LockViewModel((Application) viewModel.e(Reflection.b(Application.class), null, null), (PremiumRepositoryV2) viewModel.e(Reflection.b(PremiumRepositoryV2.class), null, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BlockingScreenViewModel y1(Scope viewModel, ParametersHolder parametersHolder) {
        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
        Intrinsics.checkNotNullParameter(parametersHolder, "<destruct>");
        return new BlockingScreenViewModel((Application) viewModel.e(Reflection.b(Application.class), null, null), ((Boolean) parametersHolder.b(0, Reflection.b(Boolean.class))).booleanValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DevEventsViewModel y2(Scope viewModel, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
        Intrinsics.checkNotNullParameter(it, "it");
        return new DevEventsViewModel((Application) viewModel.e(Reflection.b(Application.class), null, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final QuickBlockCardViewModel z1(Scope viewModel, ParametersHolder parametersHolder) {
        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
        Intrinsics.checkNotNullParameter(parametersHolder, "<destruct>");
        return new QuickBlockCardViewModel((Application) viewModel.e(Reflection.b(Application.class), null, null), (QuickBlockCardViewModel.Params) parametersHolder.b(0, Reflection.b(QuickBlockCardViewModel.Params.class)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AccountDetailViewModel z2(Scope viewModel, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
        Intrinsics.checkNotNullParameter(it, "it");
        return new AccountDetailViewModel((Application) viewModel.e(Reflection.b(Application.class), null, null));
    }
}
