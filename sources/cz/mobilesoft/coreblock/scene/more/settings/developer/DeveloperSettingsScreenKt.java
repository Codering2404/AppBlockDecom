package cz.mobilesoft.coreblock.scene.more.settings.developer;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;
import androidx.activity.compose.ActivityResultRegistryKt;
import androidx.activity.compose.ManagedActivityResultLauncher;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.ProgressIndicatorKt;
import androidx.compose.material.ScaffoldKt;
import androidx.compose.material.ScaffoldState;
import androidx.compose.material3.AppBarKt;
import androidx.compose.material3.IconButtonKt;
import androidx.compose.material3.TopAppBarDefaults;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
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
import androidx.compose.ui.res.PrimitiveResources_androidKt;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.unit.Dp;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.app.Person;
import androidx.core.content.ContextCompat;
import androidx.core.content.LocusIdCompat;
import androidx.core.content.pm.ShortcutInfoCompat;
import androidx.core.content.pm.ShortcutManagerCompat;
import androidx.core.graphics.drawable.IconCompat;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.navigation.NavBackStackEntry;
import com.facebook.appevents.integrity.IntegrityManager;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.activity.rating.RatingDialogType;
import cz.mobilesoft.coreblock.enums.RevenueCatOffering;
import cz.mobilesoft.coreblock.scene.dev_events.DevEventsActivity;
import cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewEvent;
import cz.mobilesoft.coreblock.scene.more.settings.developer.streaks.StreakDebugHelper;
import cz.mobilesoft.coreblock.util.analytics.AnswersHelper;
import cz.mobilesoft.coreblock.util.compose.FlowExtKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.util.notifications.NotificationChannelHelper;
import cz.mobilesoft.coreblock.util.updates.InAppUpdatesMockSettingsDTO;
import cz.mobilesoft.coreblock.view.compose.SectionedItemKt;
import cz.mobilesoft.coreblock.view.compose.material3.CardsKt;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class DeveloperSettingsScreenKt {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f108308a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f108309b;

        static {
            int[] iArr = new int[SettingsItemType.values().length];
            try {
                iArr[SettingsItemType.Toggle.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SettingsItemType.Action.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[SettingsItemType.Navigation.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[SettingsItemType.Value.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f108308a = iArr;
            int[] iArr2 = new int[DeveloperSettingsItemId.values().length];
            try {
                iArr2[DeveloperSettingsItemId.UseProductionServer.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[DeveloperSettingsItemId.EnableInternet.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[DeveloperSettingsItemId.SpeedUpTimers.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[DeveloperSettingsItemId.TimeNudgeShortIntervals.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr2[DeveloperSettingsItemId.OfferLifetime.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr2[DeveloperSettingsItemId.TrialAlwaysEligible.ordinal()] = 6;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr2[DeveloperSettingsItemId.SimulateActiveTrial.ordinal()] = 7;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr2[DeveloperSettingsItemId.SimulateBillingError.ordinal()] = 8;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr2[DeveloperSettingsItemId.ShowPirateVersionSheet.ordinal()] = 9;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr2[DeveloperSettingsItemId.UseNewPaywall.ordinal()] = 10;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr2[DeveloperSettingsItemId.ShowAllTrendItems.ordinal()] = 11;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                iArr2[DeveloperSettingsItemId.ShowPremiumExpiring.ordinal()] = 12;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                iArr2[DeveloperSettingsItemId.ShowPremiumExpiringCards.ordinal()] = 13;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                iArr2[DeveloperSettingsItemId.ForceAutoTrialExpired.ordinal()] = 14;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                iArr2[DeveloperSettingsItemId.ForceAutoTrialExpiredCard.ordinal()] = 15;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                iArr2[DeveloperSettingsItemId.ShortenAutoTrialWait.ordinal()] = 16;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                iArr2[DeveloperSettingsItemId.MockTrialComparisonData.ordinal()] = 17;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                iArr2[DeveloperSettingsItemId.DisableBackdoorCodeCheck.ordinal()] = 18;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                iArr2[DeveloperSettingsItemId.AlwaysValidateEmergencyString.ordinal()] = 19;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                iArr2[DeveloperSettingsItemId.LogLockService.ordinal()] = 20;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                iArr2[DeveloperSettingsItemId.PomodoroInSeconds.ordinal()] = 21;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                iArr2[DeveloperSettingsItemId.StrictModePauseInSeconds.ordinal()] = 22;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                iArr2[DeveloperSettingsItemId.AlwaysShowEmailConsent.ordinal()] = 23;
            } catch (NoSuchFieldError unused27) {
            }
            try {
                iArr2[DeveloperSettingsItemId.ForceLoadingDelay.ordinal()] = 24;
            } catch (NoSuchFieldError unused28) {
            }
            try {
                iArr2[DeveloperSettingsItemId.UseFakeReviewManager.ordinal()] = 25;
            } catch (NoSuchFieldError unused29) {
            }
            try {
                iArr2[DeveloperSettingsItemId.StreakToday.ordinal()] = 26;
            } catch (NoSuchFieldError unused30) {
            }
            try {
                iArr2[DeveloperSettingsItemId.StreakPausesToday.ordinal()] = 27;
            } catch (NoSuchFieldError unused31) {
            }
            try {
                iArr2[DeveloperSettingsItemId.StreakPresentationState.ordinal()] = 28;
            } catch (NoSuchFieldError unused32) {
            }
            try {
                iArr2[DeveloperSettingsItemId.StreakStoredDays.ordinal()] = 29;
            } catch (NoSuchFieldError unused33) {
            }
            try {
                iArr2[DeveloperSettingsItemId.PremiumState.ordinal()] = 30;
            } catch (NoSuchFieldError unused34) {
            }
            try {
                iArr2[DeveloperSettingsItemId.PremiumProduct.ordinal()] = 31;
            } catch (NoSuchFieldError unused35) {
            }
            try {
                iArr2[DeveloperSettingsItemId.FcmToken.ordinal()] = 32;
            } catch (NoSuchFieldError unused36) {
            }
            try {
                iArr2[DeveloperSettingsItemId.RevenueCatId.ordinal()] = 33;
            } catch (NoSuchFieldError unused37) {
            }
            try {
                iArr2[DeveloperSettingsItemId.CustomerId.ordinal()] = 34;
            } catch (NoSuchFieldError unused38) {
            }
            try {
                iArr2[DeveloperSettingsItemId.ShowAdsState.ordinal()] = 35;
            } catch (NoSuchFieldError unused39) {
            }
            try {
                iArr2[DeveloperSettingsItemId.SkipDiscountTimer.ordinal()] = 36;
            } catch (NoSuchFieldError unused40) {
            }
            try {
                iArr2[DeveloperSettingsItemId.ShowAllDiscounts.ordinal()] = 37;
            } catch (NoSuchFieldError unused41) {
            }
            try {
                iArr2[DeveloperSettingsItemId.ShowIntro.ordinal()] = 38;
            } catch (NoSuchFieldError unused42) {
            }
            try {
                iArr2[DeveloperSettingsItemId.WhatsNewCard.ordinal()] = 39;
            } catch (NoSuchFieldError unused43) {
            }
            try {
                iArr2[DeveloperSettingsItemId.ShowAniaInfoDialog.ordinal()] = 40;
            } catch (NoSuchFieldError unused44) {
            }
            try {
                iArr2[DeveloperSettingsItemId.ForceRatingDialog.ordinal()] = 41;
            } catch (NoSuchFieldError unused45) {
            }
            try {
                iArr2[DeveloperSettingsItemId.InAppUpdatesMock.ordinal()] = 42;
            } catch (NoSuchFieldError unused46) {
            }
            try {
                iArr2[DeveloperSettingsItemId.RemoteConfigMock.ordinal()] = 43;
            } catch (NoSuchFieldError unused47) {
            }
            try {
                iArr2[DeveloperSettingsItemId.QuestionnaireConfig.ordinal()] = 44;
            } catch (NoSuchFieldError unused48) {
            }
            try {
                iArr2[DeveloperSettingsItemId.TimeChangeLimit.ordinal()] = 45;
            } catch (NoSuchFieldError unused49) {
            }
            try {
                iArr2[DeveloperSettingsItemId.TestTargetingGroup.ordinal()] = 46;
            } catch (NoSuchFieldError unused50) {
            }
            try {
                iArr2[DeveloperSettingsItemId.StreakSeed.ordinal()] = 47;
            } catch (NoSuchFieldError unused51) {
            }
            try {
                iArr2[DeveloperSettingsItemId.StreakSendAchievement.ordinal()] = 48;
            } catch (NoSuchFieldError unused52) {
            }
            try {
                iArr2[DeveloperSettingsItemId.StreakAddActivity.ordinal()] = 49;
            } catch (NoSuchFieldError unused53) {
            }
            try {
                iArr2[DeveloperSettingsItemId.StreakRunCatchUp.ordinal()] = 50;
            } catch (NoSuchFieldError unused54) {
            }
            try {
                iArr2[DeveloperSettingsItemId.StreakClear.ordinal()] = 51;
            } catch (NoSuchFieldError unused55) {
            }
            try {
                iArr2[DeveloperSettingsItemId.StreakOpenMilestone.ordinal()] = 52;
            } catch (NoSuchFieldError unused56) {
            }
            try {
                iArr2[DeveloperSettingsItemId.StreakOpenIntroduction.ordinal()] = 53;
            } catch (NoSuchFieldError unused57) {
            }
            try {
                iArr2[DeveloperSettingsItemId.StreakShowBanner.ordinal()] = 54;
            } catch (NoSuchFieldError unused58) {
            }
            try {
                iArr2[DeveloperSettingsItemId.StreakUpload.ordinal()] = 55;
            } catch (NoSuchFieldError unused59) {
            }
            try {
                iArr2[DeveloperSettingsItemId.StreakSendNudge.ordinal()] = 56;
            } catch (NoSuchFieldError unused60) {
            }
            try {
                iArr2[DeveloperSettingsItemId.StreakResetPresentation.ordinal()] = 57;
            } catch (NoSuchFieldError unused61) {
            }
            try {
                iArr2[DeveloperSettingsItemId.TriggerTimeNudge.ordinal()] = 58;
            } catch (NoSuchFieldError unused62) {
            }
            try {
                iArr2[DeveloperSettingsItemId.RemovePremium.ordinal()] = 59;
            } catch (NoSuchFieldError unused63) {
            }
            try {
                iArr2[DeveloperSettingsItemId.ActivateCampaign.ordinal()] = 60;
            } catch (NoSuchFieldError unused64) {
            }
            try {
                iArr2[DeveloperSettingsItemId.SubscriptionOnboardingTest.ordinal()] = 61;
            } catch (NoSuchFieldError unused65) {
            }
            try {
                iArr2[DeveloperSettingsItemId.OpenDiscountScreen.ordinal()] = 62;
            } catch (NoSuchFieldError unused66) {
            }
            try {
                iArr2[DeveloperSettingsItemId.OverridePaywallSettings.ordinal()] = 63;
            } catch (NoSuchFieldError unused67) {
            }
            try {
                iArr2[DeveloperSettingsItemId.ResetDiscountOffers.ordinal()] = 64;
            } catch (NoSuchFieldError unused68) {
            }
            try {
                iArr2[DeveloperSettingsItemId.ShowWhatsNewFlow.ordinal()] = 65;
            } catch (NoSuchFieldError unused69) {
            }
            try {
                iArr2[DeveloperSettingsItemId.MockWeeklyStatsNotification.ordinal()] = 66;
            } catch (NoSuchFieldError unused70) {
            }
            try {
                iArr2[DeveloperSettingsItemId.MockDailyInsights.ordinal()] = 67;
            } catch (NoSuchFieldError unused71) {
            }
            try {
                iArr2[DeveloperSettingsItemId.MockTrialExpiringNotification.ordinal()] = 68;
            } catch (NoSuchFieldError unused72) {
            }
            try {
                iArr2[DeveloperSettingsItemId.MockTrialConvReminderNotification.ordinal()] = 69;
            } catch (NoSuchFieldError unused73) {
            }
            try {
                iArr2[DeveloperSettingsItemId.MockTrialConvFailedNotification.ordinal()] = 70;
            } catch (NoSuchFieldError unused74) {
            }
            try {
                iArr2[DeveloperSettingsItemId.MockWeeklyStatsScreen.ordinal()] = 71;
            } catch (NoSuchFieldError unused75) {
            }
            try {
                iArr2[DeveloperSettingsItemId.MockWeeklyStatsDialog.ordinal()] = 72;
            } catch (NoSuchFieldError unused76) {
            }
            try {
                iArr2[DeveloperSettingsItemId.MockPremiumExpiringScreen.ordinal()] = 73;
            } catch (NoSuchFieldError unused77) {
            }
            try {
                iArr2[DeveloperSettingsItemId.GenerateFakeInsightsData.ordinal()] = 74;
            } catch (NoSuchFieldError unused78) {
            }
            try {
                iArr2[DeveloperSettingsItemId.ParseSupportJson.ordinal()] = 75;
            } catch (NoSuchFieldError unused79) {
            }
            try {
                iArr2[DeveloperSettingsItemId.ParseSupportJsonFile.ordinal()] = 76;
            } catch (NoSuchFieldError unused80) {
            }
            try {
                iArr2[DeveloperSettingsItemId.RemoteConfigValues.ordinal()] = 77;
            } catch (NoSuchFieldError unused81) {
            }
            try {
                iArr2[DeveloperSettingsItemId.ClearStrictMode.ordinal()] = 78;
            } catch (NoSuchFieldError unused82) {
            }
            try {
                iArr2[DeveloperSettingsItemId.ClearStrictModeOnboarding.ordinal()] = 79;
            } catch (NoSuchFieldError unused83) {
            }
            try {
                iArr2[DeveloperSettingsItemId.ResetQuickBlock.ordinal()] = 80;
            } catch (NoSuchFieldError unused84) {
            }
            try {
                iArr2[DeveloperSettingsItemId.ClearAdultContent.ordinal()] = 81;
            } catch (NoSuchFieldError unused85) {
            }
            try {
                iArr2[DeveloperSettingsItemId.ResetStrictModeUpsell.ordinal()] = 82;
            } catch (NoSuchFieldError unused86) {
            }
            try {
                iArr2[DeveloperSettingsItemId.ResetUnlockAllAppsTimer.ordinal()] = 83;
            } catch (NoSuchFieldError unused87) {
            }
            try {
                iArr2[DeveloperSettingsItemId.GenerateBackdoorCode.ordinal()] = 84;
            } catch (NoSuchFieldError unused88) {
            }
            try {
                iArr2[DeveloperSettingsItemId.ListBrowsers.ordinal()] = 85;
            } catch (NoSuchFieldError unused89) {
            }
            try {
                iArr2[DeveloperSettingsItemId.ShowAdsInspector.ordinal()] = 86;
            } catch (NoSuchFieldError unused90) {
            }
            try {
                iArr2[DeveloperSettingsItemId.ShowEventsBubble.ordinal()] = 87;
            } catch (NoSuchFieldError unused91) {
            }
            try {
                iArr2[DeveloperSettingsItemId.ShowChatbot.ordinal()] = 88;
            } catch (NoSuchFieldError unused92) {
            }
            try {
                iArr2[DeveloperSettingsItemId.PerformFatalCrash.ordinal()] = 89;
            } catch (NoSuchFieldError unused93) {
            }
            try {
                iArr2[DeveloperSettingsItemId.OpenAutoTrialFlow.ordinal()] = 90;
            } catch (NoSuchFieldError unused94) {
            }
            try {
                iArr2[DeveloperSettingsItemId.OpenIntroTrialPremium.ordinal()] = 91;
            } catch (NoSuchFieldError unused95) {
            }
            try {
                iArr2[DeveloperSettingsItemId.OpenTrialRetentionPremium.ordinal()] = 92;
            } catch (NoSuchFieldError unused96) {
            }
            try {
                iArr2[DeveloperSettingsItemId.OpenGenericPremium.ordinal()] = 93;
            } catch (NoSuchFieldError unused97) {
            }
            try {
                iArr2[DeveloperSettingsItemId.OpenDiscountPremium.ordinal()] = 94;
            } catch (NoSuchFieldError unused98) {
            }
            try {
                iArr2[DeveloperSettingsItemId.OpenDiscountPremium30.ordinal()] = 95;
            } catch (NoSuchFieldError unused99) {
            }
            try {
                iArr2[DeveloperSettingsItemId.OpenDiscountPremium50.ordinal()] = 96;
            } catch (NoSuchFieldError unused100) {
            }
            try {
                iArr2[DeveloperSettingsItemId.OpenExpiredSubPremium.ordinal()] = 97;
            } catch (NoSuchFieldError unused101) {
            }
            try {
                iArr2[DeveloperSettingsItemId.OpenProductPlanPremium.ordinal()] = 98;
            } catch (NoSuchFieldError unused102) {
            }
            try {
                iArr2[DeveloperSettingsItemId.OpenLimitScreenPremium.ordinal()] = 99;
            } catch (NoSuchFieldError unused103) {
            }
            try {
                iArr2[DeveloperSettingsItemId.OpenExpiredSubDiscountPremium.ordinal()] = 100;
            } catch (NoSuchFieldError unused104) {
            }
            try {
                iArr2[DeveloperSettingsItemId.OpenIntroTrialTogglePremium.ordinal()] = 101;
            } catch (NoSuchFieldError unused105) {
            }
            try {
                iArr2[DeveloperSettingsItemId.OpenOneTimeToSubPremium.ordinal()] = 102;
            } catch (NoSuchFieldError unused106) {
            }
            try {
                iArr2[DeveloperSettingsItemId.OpenDiscountPremiumReferralSender.ordinal()] = 103;
            } catch (NoSuchFieldError unused107) {
            }
            try {
                iArr2[DeveloperSettingsItemId.OpenDiscountPremiumReferralReceiver.ordinal()] = 104;
            } catch (NoSuchFieldError unused108) {
            }
            try {
                iArr2[DeveloperSettingsItemId.OpenCampaignPremium.ordinal()] = 105;
            } catch (NoSuchFieldError unused109) {
            }
            try {
                iArr2[DeveloperSettingsItemId.LaunchOnboarding.ordinal()] = 106;
            } catch (NoSuchFieldError unused110) {
            }
            try {
                iArr2[DeveloperSettingsItemId.ShowAppFeelOnboarding.ordinal()] = 107;
            } catch (NoSuchFieldError unused111) {
            }
            try {
                iArr2[DeveloperSettingsItemId.ShowTrialRemindersFlow.ordinal()] = 108;
            } catch (NoSuchFieldError unused112) {
            }
            try {
                iArr2[DeveloperSettingsItemId.ShowRatingDialogFlow.ordinal()] = 109;
            } catch (NoSuchFieldError unused113) {
            }
            try {
                iArr2[DeveloperSettingsItemId.OpenAccessibilitySettings.ordinal()] = 110;
            } catch (NoSuchFieldError unused114) {
            }
            try {
                iArr2[DeveloperSettingsItemId.OpenOverlaySettings.ordinal()] = 111;
            } catch (NoSuchFieldError unused115) {
            }
            try {
                iArr2[DeveloperSettingsItemId.OpenUsageSettings.ordinal()] = 112;
            } catch (NoSuchFieldError unused116) {
            }
            try {
                iArr2[DeveloperSettingsItemId.OpenNotificationAccessSettings.ordinal()] = 113;
            } catch (NoSuchFieldError unused117) {
            }
            try {
                iArr2[DeveloperSettingsItemId.OpenAppSettings.ordinal()] = 114;
            } catch (NoSuchFieldError unused118) {
            }
            try {
                iArr2[DeveloperSettingsItemId.RemoveDeviceAdmin.ordinal()] = 115;
            } catch (NoSuchFieldError unused119) {
            }
            f108309b = iArr2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit A(Function1 function1, ActivityResult result) {
        Uri data;
        Intrinsics.checkNotNullParameter(result, "result");
        Intent intentC = result.c();
        if (intentC != null && (data = intentC.getData()) != null) {
            function1.invoke(new DeveloperSettingsViewEvent.OnFilePicked(data));
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit B(DeveloperSettingsViewModel developerSettingsViewModel, Function0 function0, Function1 function1, int i3, Composer composer, int i4) {
        z(developerSettingsViewModel, function0, function1, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    private static final void C(final DeveloperSettingsViewState developerSettingsViewState, final Function1 function1, Composer composer, final int i3) {
        int i4;
        Composer composerK = composer.k(-542759890);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(developerSettingsViewState) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(function1) ? 32 : 16;
        }
        int i5 = i4;
        if (composerK.r((i5 & 19) != 18, i5 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-542759890, i5, -1, "cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsContent (DeveloperSettingsScreen.kt:191)");
            }
            Modifier.Companion companion = Modifier.b8;
            Modifier modifierF = SizeKt.f(companion, 0.0f, 1, null);
            MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.h(), Alignment.f25072a.k(), composerK, 0);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF2 = ComposedModifierKt.f(composerK, modifierF);
            ComposeUiNode.Companion companion2 = ComposeUiNode.f8;
            Function0 function0A = companion2.a();
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
            Updater.e(composerA, measurePolicyA, companion2.e());
            Updater.e(composerA, compositionLocalMapU, companion2.g());
            Function2 function2B = companion2.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF2, companion2.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            String strZ = developerSettingsViewState.z();
            int i6 = i5 & 112;
            boolean z2 = i6 == 32;
            Object objG = composerK.G();
            if (z2 || objG == Composer.f23746a.a()) {
                objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.e4
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return DeveloperSettingsScreenKt.D(function1, (String) obj);
                    }
                };
                composerK.w(objG);
            }
            DeveloperSettingsComponentsKt.k(strZ, (Function1) objG, null, null, composerK, 0, 12);
            Modifier modifierF3 = SizeKt.f(companion, 0.0f, 1, null);
            boolean z3 = ((i5 & 14) == 4) | (i6 == 32);
            Object objG2 = composerK.G();
            if (z3 || objG2 == Composer.f23746a.a()) {
                objG2 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.f4
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return DeveloperSettingsScreenKt.E(developerSettingsViewState, function1, (LazyListScope) obj);
                    }
                };
                composerK.w(objG2);
            }
            composerK = composerK;
            LazyDslKt.b(modifierF3, null, null, false, null, null, null, false, null, (Function1) objG2, composerK, 6, 510);
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.g4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DeveloperSettingsScreenKt.F(developerSettingsViewState, function1, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit D(Function1 function1, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function1.invoke(new DeveloperSettingsViewEvent.OnSearchQueryChanged(it));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit E(final DeveloperSettingsViewState developerSettingsViewState, final Function1 function1, LazyListScope LazyColumn) {
        LazyListScope lazyListScope;
        Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
        final List listK = developerSettingsViewState.k();
        if (!listK.isEmpty() || StringsKt.p0(developerSettingsViewState.z())) {
            lazyListScope = LazyColumn;
            final DeveloperSettingsScreenKt$DeveloperSettingsContent$lambda$0$1$0$$inlined$items$default$1 developerSettingsScreenKt$DeveloperSettingsContent$lambda$0$1$0$$inlined$items$default$1 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsScreenKt$DeveloperSettingsContent$lambda$0$1$0$$inlined$items$default$1
                @Override // kotlin.jvm.functions.Function1
                public final Void invoke(Object obj) {
                    return null;
                }
            };
            lazyListScope.h(listK.size(), null, new Function1<Integer, Object>() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsScreenKt$DeveloperSettingsContent$lambda$0$1$0$$inlined$items$default$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return invoke(((Number) obj).intValue());
                }

                public final Object invoke(int i3) {
                    return developerSettingsScreenKt$DeveloperSettingsContent$lambda$0$1$0$$inlined$items$default$1.invoke(listK.get(i3));
                }
            }, ComposableLambdaKt.c(-632812321, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsScreenKt$DeveloperSettingsContent$lambda$0$1$0$$inlined$items$default$4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(4);
                }

                @Override // kotlin.jvm.functions.Function4
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                    invoke((LazyItemScope) obj, ((Number) obj2).intValue(), (Composer) obj3, ((Number) obj4).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(LazyItemScope lazyItemScope, int i3, Composer composer, int i4) {
                    int i5;
                    if ((i4 & 6) == 0) {
                        i5 = (composer.Z(lazyItemScope) ? 4 : 2) | i4;
                    } else {
                        i5 = i4;
                    }
                    if ((i4 & 48) == 0) {
                        i5 |= composer.e(i3) ? 32 : 16;
                    }
                    if (!composer.r((i5 & 147) != 146, i5 & 1)) {
                        composer.Q();
                        return;
                    }
                    if (ComposerKt.M()) {
                        ComposerKt.U(-632812321, i5, -1, "androidx.compose.foundation.lazy.items.<anonymous> (LazyDsl.kt:178)");
                    }
                    final DeveloperSettingsCategory developerSettingsCategory = (DeveloperSettingsCategory) listK.get(i3);
                    composer.a0(548087010);
                    String strZ = developerSettingsViewState.z();
                    boolean zContains = developerSettingsViewState.i().contains(developerSettingsCategory.d());
                    boolean Z = composer.Z(function1) | composer.I(developerSettingsCategory);
                    Object objG = composer.G();
                    if (Z || objG == Composer.f23746a.a()) {
                        final Function1 function12 = function1;
                        objG = new Function0<Unit>() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsScreenKt$DeveloperSettingsContent$1$2$1$1$1$1
                            public final void c() {
                                function12.invoke(new DeveloperSettingsViewEvent.OnCategoryExpandToggled(developerSettingsCategory.d()));
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Object invoke() {
                                c();
                                return Unit.f139807a;
                            }
                        };
                        composer.w(objG);
                    }
                    Function0 function0 = (Function0) objG;
                    final DeveloperSettingsViewState developerSettingsViewState2 = developerSettingsViewState;
                    final Function1 function13 = function1;
                    DeveloperSettingsComponentsKt.v(developerSettingsCategory, zContains, function0, ComposableLambdaKt.e(1950378825, true, new Function2<Composer, Integer, Unit>() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsScreenKt$DeveloperSettingsContent$1$2$1$1$2
                        public final void c(Composer composer2, int i6) {
                            if (!composer2.r((i6 & 3) != 2, i6 & 1)) {
                                composer2.Q();
                                return;
                            }
                            if (ComposerKt.M()) {
                                ComposerKt.U(1950378825, i6, -1, "cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsContent.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (DeveloperSettingsScreen.kt:218)");
                            }
                            DeveloperSettingsScreenKt.v(developerSettingsCategory, developerSettingsViewState2.z(), developerSettingsViewState2, function13, composer2, DeveloperSettingsCategory.f108268g);
                            if (ComposerKt.M()) {
                                ComposerKt.T();
                            }
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            c((Composer) obj, ((Number) obj2).intValue());
                            return Unit.f139807a;
                        }
                    }, composer, 54), null, strZ, composer, DeveloperSettingsCategory.f108268g | 3072, 16);
                    composer.U();
                    if (ComposerKt.M()) {
                        ComposerKt.T();
                    }
                }
            }));
        } else {
            LazyListScope.c(LazyColumn, null, null, ComposableSingletons$DeveloperSettingsScreenKt.f108261a.h(), 3, null);
            lazyListScope = LazyColumn;
        }
        LazyListScope.c(lazyListScope, null, null, ComposableSingletons$DeveloperSettingsScreenKt.f108261a.j(), 3, null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit F(DeveloperSettingsViewState developerSettingsViewState, Function1 function1, int i3, Composer composer, int i4) {
        C(developerSettingsViewState, function1, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    public static final void G(PaddingValues paddingValues, final Function0 onBackClick, Composer composer, final int i3, final int i4) {
        int i5;
        final PaddingValues paddingValues2;
        Bundle bundleB;
        Intrinsics.checkNotNullParameter(onBackClick, "onBackClick");
        Composer composerK = composer.k(431249158);
        if ((i3 & 48) == 0) {
            i5 = i3 | (composerK.I(onBackClick) ? 32 : 16);
        } else {
            i5 = i3;
        }
        if (composerK.r((i5 & 17) != 16, i5 & 1)) {
            PaddingValues paddingValuesA = (i4 & 1) != 0 ? PaddingKt.a(Dp.g(0)) : paddingValues;
            if (ComposerKt.M()) {
                ComposerKt.U(431249158, i5, -1, "cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsScreen (DeveloperSettingsScreen.kt:107)");
            }
            final Context context = (Context) composerK.q(AndroidCompositionLocals_androidKt.g());
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
            KClass kClassB = Reflection.b(DeveloperSettingsViewModel.class);
            ViewModelStore viewModelStore = viewModelStoreOwnerC.getViewModelStore();
            Intrinsics.checkNotNullExpressionValue(viewModelStore, "viewModelStoreOwner.viewModelStore");
            ViewModel viewModelA = GetViewModelKt.a(kClassB, viewModelStore, null, creationExtrasA2 == null ? creationExtrasA : creationExtrasA2, null, scopeD, null);
            composerK.Y();
            composerK.Y();
            DeveloperSettingsViewModel developerSettingsViewModel = (DeveloperSettingsViewModel) viewModelA;
            final DeveloperSettingsViewState developerSettingsViewState = (DeveloperSettingsViewState) FlowExtKt.m(developerSettingsViewModel, composerK, 0);
            final Function1 function1N = FlowExtKt.n(developerSettingsViewModel, composerK, 0);
            final ScaffoldState scaffoldStateG = ScaffoldKt.g(null, null, composerK, 0, 3);
            Object objG = composerK.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG == companion.a()) {
                objG = EffectsKt.l(EmptyCoroutineContext.f139889a, composerK);
                composerK.w(objG);
            }
            final CoroutineScope coroutineScope = (CoroutineScope) objG;
            boolean zI = composerK.I(coroutineScope) | composerK.Z(scaffoldStateG) | composerK.I(context);
            Object objG2 = composerK.G();
            if (zI || objG2 == companion.a()) {
                objG2 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.y3
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return DeveloperSettingsScreenKt.H(coroutineScope, scaffoldStateG, context, ((Integer) obj).intValue());
                    }
                };
                composerK.w(objG2);
            }
            z(developerSettingsViewModel, onBackClick, (Function1) objG2, composerK, i5 & 112);
            ScaffoldKt.a(null, scaffoldStateG, ComposableLambdaKt.e(-2102626591, true, new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.z3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DeveloperSettingsScreenKt.I(onBackClick, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerK, 54), null, ComposableSingletons$DeveloperSettingsScreenKt.f108261a.f(), null, 0, false, null, false, null, 0.0f, 0L, 0L, 0L, ComposeColorsKt.j(composerK, 0).e(), 0L, ComposableLambdaKt.e(1933907464, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.a4
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return DeveloperSettingsScreenKt.K(developerSettingsViewState, function1N, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerK, 54), composerK, 24960, 12582912, 98281);
            composerK = composerK;
            DeveloperSettingsDialogsKt.h1(developerSettingsViewState, function1N, composerK, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
            paddingValues2 = paddingValuesA;
        } else {
            composerK.Q();
            paddingValues2 = paddingValues;
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.b4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DeveloperSettingsScreenKt.L(paddingValues2, onBackClick, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit H(CoroutineScope coroutineScope, ScaffoldState scaffoldState, Context context, int i3) {
        BuildersKt__Builders_commonKt.d(coroutineScope, null, null, new DeveloperSettingsScreenKt$DeveloperSettingsScreen$1$1$1(scaffoldState, context, i3, null), 3, null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit I(final Function0 function0, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-2102626591, i3, -1, "cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsScreen.<anonymous> (DeveloperSettingsScreen.kt:129)");
            }
            AppBarKt.p(ComposableSingletons$DeveloperSettingsScreenKt.f108261a.i(), null, ComposableLambdaKt.e(-1434757721, true, new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.i4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DeveloperSettingsScreenKt.J(function0, (Composer) obj, ((Integer) obj2).intValue());
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
    public static final Unit J(Function0 function0, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1434757721, i3, -1, "cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsScreen.<anonymous>.<anonymous> (DeveloperSettingsScreen.kt:138)");
            }
            IconButtonKt.e(function0, null, false, null, null, ComposableSingletons$DeveloperSettingsScreenKt.f108261a.g(), composer, 196608, 30);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit K(DeveloperSettingsViewState developerSettingsViewState, Function1 function1, PaddingValues innerPadding, Composer composer, int i3) {
        Composer composer2;
        Intrinsics.checkNotNullParameter(innerPadding, "innerPadding");
        if ((i3 & 6) == 0) {
            i3 |= composer.Z(innerPadding) ? 4 : 2;
        }
        if (composer.r((i3 & 19) != 18, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1933907464, i3, -1, "cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsScreen.<anonymous> (DeveloperSettingsScreen.kt:154)");
            }
            Modifier.Companion companion = Modifier.b8;
            Modifier modifierH = PaddingKt.h(SizeKt.f(companion, 0.0f, 1, null), innerPadding);
            Alignment.Companion companion2 = Alignment.f25072a;
            MeasurePolicy measurePolicyG = BoxKt.g(companion2.o(), false);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, modifierH);
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
            C(developerSettingsViewState, function1, composer, 0);
            if (developerSettingsViewState.a0()) {
                composer.a0(-94829815);
                Modifier modifierI = PaddingKt.i(SizeKt.f(companion, 0.0f, 1, null), Dp.g(16));
                MeasurePolicy measurePolicyG2 = BoxKt.g(companion2.e(), false);
                int iA2 = ComposablesKt.a(composer, 0);
                CompositionLocalMap compositionLocalMapU2 = composer.u();
                Modifier modifierF2 = ComposedModifierKt.f(composer, modifierI);
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
                Updater.e(composerA2, measurePolicyG2, companion3.e());
                Updater.e(composerA2, compositionLocalMapU2, companion3.g());
                Function2 function2B2 = companion3.b();
                if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                    composerA2.w(Integer.valueOf(iA2));
                    composerA2.p(Integer.valueOf(iA2), function2B2);
                }
                Updater.e(composerA2, modifierF2, companion3.f());
                composer2 = composer;
                ProgressIndicatorKt.b(null, ComposeColorsKt.j(composer, 0).b(), 0.0f, 0L, 0, composer2, 0, 29);
                composer2.y();
            } else {
                composer2 = composer;
                composer2.a0(-102293344);
            }
            composer2.U();
            composer2.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit L(PaddingValues paddingValues, Function0 function0, int i3, int i4, Composer composer, int i5) {
        G(paddingValues, function0, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    private static final void M(final DeveloperSettingsItem developerSettingsItem, final String str, final float f3, final float f4, final Function0 function0, Composer composer, final int i3) {
        int i4;
        Composer composerK = composer.k(1214037508);
        if ((i3 & 6) == 0) {
            i4 = ((i3 & 8) == 0 ? composerK.Z(developerSettingsItem) : composerK.I(developerSettingsItem) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.Z(str) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.c(f3) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            i4 |= composerK.c(f4) ? 2048 : 1024;
        }
        if ((i3 & 24576) == 0) {
            i4 |= composerK.I(function0) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        }
        if (composerK.r((i4 & 9363) != 9362, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1214037508, i4, -1, "cz.mobilesoft.coreblock.scene.more.settings.developer.RenderActionItem (DeveloperSettingsScreen.kt:343)");
            }
            CardsKt.j(null, 0L, 0.0f, false, RoundedCornerShapeKt.e(f3, f3, f4, f4), function0, ComposableLambdaKt.e(-43364256, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.n4
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return DeveloperSettingsScreenKt.N(developerSettingsItem, str, function0, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerK, 54), composerK, ((i4 << 3) & 458752) | 1572864, 15);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.o4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DeveloperSettingsScreenKt.O(developerSettingsItem, str, f3, f4, function0, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit N(DeveloperSettingsItem developerSettingsItem, String str, Function0 function0, ColumnScope BaseCard, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(BaseCard, "$this$BaseCard");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-43364256, i3, -1, "cz.mobilesoft.coreblock.scene.more.settings.developer.RenderActionItem.<anonymous> (DeveloperSettingsScreen.kt:353)");
            }
            AnnotatedString annotatedStringA = DeveloperSettingsComponentsKt.A(developerSettingsItem.e(), str);
            String strD = developerSettingsItem.d();
            SectionedItemKt.G(null, null, annotatedStringA, null, strD != null ? DeveloperSettingsComponentsKt.A(strD, str) : null, null, null, null, null, developerSettingsItem.b() == SettingsItemType.Navigation, 0L, 0L, null, false, function0, false, null, 0L, composer, 0, 0, 245227);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit O(DeveloperSettingsItem developerSettingsItem, String str, float f3, float f4, Function0 function0, int i3, Composer composer, int i4) {
        M(developerSettingsItem, str, f3, f4, function0, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    private static final void P(final DeveloperSettingsItem developerSettingsItem, final String str, final DeveloperSettingsViewState developerSettingsViewState, final Function1 function1, final float f3, final float f4, Composer composer, final int i3) {
        int i4;
        DeveloperSettingsViewState developerSettingsViewState2;
        Composer composer2;
        final boolean zV;
        Composer composerK = composer.k(1701159978);
        if ((i3 & 6) == 0) {
            i4 = ((i3 & 8) == 0 ? composerK.Z(developerSettingsItem) : composerK.I(developerSettingsItem) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.Z(str) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            developerSettingsViewState2 = developerSettingsViewState;
            i4 |= composerK.Z(developerSettingsViewState2) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        } else {
            developerSettingsViewState2 = developerSettingsViewState;
        }
        if ((i3 & 3072) == 0) {
            i4 |= composerK.I(function1) ? 2048 : 1024;
        }
        if ((i3 & 24576) == 0) {
            i4 |= composerK.c(f3) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        }
        if ((196608 & i3) == 0) {
            i4 |= composerK.c(f4) ? 131072 : NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
        }
        if (composerK.r((74899 & i4) != 74898, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1701159978, i4, -1, "cz.mobilesoft.coreblock.scene.more.settings.developer.RenderToggleItem (DeveloperSettingsScreen.kt:284)");
            }
            DeveloperSettingsItemId developerSettingsItemIdA = DeveloperSettingsItemId.Companion.a(developerSettingsItem.a());
            switch (developerSettingsItemIdA != null ? WhenMappings.f108309b[developerSettingsItemIdA.ordinal()] : -1) {
                case 1:
                    zV = developerSettingsViewState2.V();
                    break;
                case 2:
                    zV = developerSettingsViewState2.Z();
                    break;
                case 3:
                    zV = developerSettingsViewState2.M();
                    break;
                case 4:
                    zV = developerSettingsViewState2.R();
                    break;
                case 5:
                    zV = developerSettingsViewState2.s();
                    break;
                case 6:
                    zV = developerSettingsViewState2.S();
                    break;
                case 7:
                    zV = developerSettingsViewState2.J();
                    break;
                case 8:
                    zV = developerSettingsViewState2.K();
                    break;
                case 9:
                    zV = developerSettingsViewState2.G();
                    break;
                case 10:
                    zV = developerSettingsViewState2.U();
                    break;
                case 11:
                    zV = developerSettingsViewState2.D();
                    break;
                case 12:
                    zV = developerSettingsViewState2.H();
                    break;
                case 13:
                    zV = developerSettingsViewState2.I();
                    break;
                case 14:
                    zV = developerSettingsViewState2.l();
                    break;
                case 15:
                    zV = developerSettingsViewState2.m();
                    break;
                case 16:
                    zV = developerSettingsViewState2.A();
                    break;
                case 17:
                    zV = developerSettingsViewState2.r();
                    break;
                case 18:
                    zV = developerSettingsViewState2.h();
                    break;
                case 19:
                    zV = developerSettingsViewState2.e();
                    break;
                case 20:
                    zV = developerSettingsViewState2.p();
                    break;
                case 21:
                    zV = developerSettingsViewState2.u();
                    break;
                case 22:
                    zV = developerSettingsViewState2.O();
                    break;
                case 23:
                    zV = developerSettingsViewState2.d();
                    break;
                case 24:
                    zV = developerSettingsViewState2.Y();
                    break;
                case 25:
                    zV = developerSettingsViewState2.T();
                    break;
                default:
                    zV = false;
                    break;
            }
            RoundedCornerShape roundedCornerShapeE = RoundedCornerShapeKt.e(f3, f3, f4, f4);
            boolean z2 = ((i4 & 14) == 4 || ((i4 & 8) != 0 && composerK.I(developerSettingsItem))) | ((i4 & 7168) == 2048);
            Object objG = composerK.G();
            if (z2 || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.k4
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return DeveloperSettingsScreenKt.Q(developerSettingsItem, function1);
                    }
                };
                composerK.w(objG);
            }
            composer2 = composerK;
            CardsKt.j(null, 0L, 0.0f, false, roundedCornerShapeE, (Function0) objG, ComposableLambdaKt.e(-1316259762, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.l4
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return DeveloperSettingsScreenKt.R(developerSettingsItem, str, function1, zV, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerK, 54), composer2, 1572864, 15);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer2 = composerK;
            composer2.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.m4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DeveloperSettingsScreenKt.T(developerSettingsItem, str, developerSettingsViewState, function1, f3, f4, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Q(DeveloperSettingsItem developerSettingsItem, Function1 function1) {
        a0(developerSettingsItem.a(), function1);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit R(final DeveloperSettingsItem developerSettingsItem, String str, final Function1 function1, boolean z2, ColumnScope BaseCard, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(BaseCard, "$this$BaseCard");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1316259762, i3, -1, "cz.mobilesoft.coreblock.scene.more.settings.developer.RenderToggleItem.<anonymous> (DeveloperSettingsScreen.kt:324)");
            }
            AnnotatedString annotatedStringA = DeveloperSettingsComponentsKt.A(developerSettingsItem.e(), str);
            String strD = developerSettingsItem.d();
            AnnotatedString annotatedStringA2 = strD != null ? DeveloperSettingsComponentsKt.A(strD, str) : null;
            boolean zI = composer.I(developerSettingsItem) | composer.Z(function1);
            Object objG = composer.G();
            if (zI || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.x3
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return DeveloperSettingsScreenKt.S(developerSettingsItem, function1);
                    }
                };
                composer.w(objG);
            }
            SectionedItemKt.P(null, null, annotatedStringA, null, annotatedStringA2, null, 0L, 0L, 0L, null, null, (Function0) objG, Boolean.valueOf(z2), false, composer, 0, 0, 10219);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit S(DeveloperSettingsItem developerSettingsItem, Function1 function1) {
        a0(developerSettingsItem.a(), function1);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit T(DeveloperSettingsItem developerSettingsItem, String str, DeveloperSettingsViewState developerSettingsViewState, Function1 function1, float f3, float f4, int i3, Composer composer, int i4) {
        P(developerSettingsItem, str, developerSettingsViewState, function1, f3, f4, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    private static final void U(final DeveloperSettingsItem developerSettingsItem, final String str, final String str2, final float f3, final float f4, final Function0 function0, Composer composer, final int i3) {
        int i4;
        Composer composerK = composer.k(897869092);
        if ((i3 & 6) == 0) {
            i4 = ((i3 & 8) == 0 ? composerK.Z(developerSettingsItem) : composerK.I(developerSettingsItem) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.Z(str) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.Z(str2) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            i4 |= composerK.c(f3) ? 2048 : 1024;
        }
        if ((i3 & 24576) == 0) {
            i4 |= composerK.c(f4) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        }
        if ((196608 & i3) == 0) {
            i4 |= composerK.I(function0) ? 131072 : NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
        }
        if (composerK.r((74899 & i4) != 74898, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(897869092, i4, -1, "cz.mobilesoft.coreblock.scene.more.settings.developer.RenderValueItem (DeveloperSettingsScreen.kt:373)");
            }
            CardsKt.j(null, 0L, 0.0f, false, RoundedCornerShapeKt.e(f3, f3, f4, f4), function0, ComposableLambdaKt.e(2103034496, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.p4
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return DeveloperSettingsScreenKt.V(developerSettingsItem, str, str2, function0, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerK, 54), composerK, (458752 & i4) | 1572864, 15);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.q4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DeveloperSettingsScreenKt.W(developerSettingsItem, str, str2, f3, f4, function0, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit V(DeveloperSettingsItem developerSettingsItem, String str, String str2, Function0 function0, ColumnScope BaseCard, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(BaseCard, "$this$BaseCard");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(2103034496, i3, -1, "cz.mobilesoft.coreblock.scene.more.settings.developer.RenderValueItem.<anonymous> (DeveloperSettingsScreen.kt:383)");
            }
            SectionedItemKt.G(null, null, DeveloperSettingsComponentsKt.A(developerSettingsItem.e(), str), null, str2 != null ? DeveloperSettingsComponentsKt.A(str2, str) : null, null, null, null, null, false, 0L, 0L, null, false, function0, false, null, 0L, composer, 0, 0, 245739);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit W(DeveloperSettingsItem developerSettingsItem, String str, String str2, float f3, float f4, Function0 function0, int i3, Composer composer, int i4) {
        U(developerSettingsItem, str, str2, f3, f4, function0, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    private static final String Z(String str, DeveloperSettingsViewState developerSettingsViewState) {
        String string;
        String strName;
        StreakDebugHelper.Snapshot snapshotN = developerSettingsViewState.N();
        DeveloperSettingsItemId developerSettingsItemIdA = DeveloperSettingsItemId.Companion.a(str);
        String str2 = null;
        switch (developerSettingsItemIdA == null ? -1 : WhenMappings.f108309b[developerSettingsItemIdA.ordinal()]) {
            case 26:
                if (snapshotN != null) {
                    TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                    long minutes = timeUnit.toMinutes(snapshotN.g());
                    long minutes2 = timeUnit.toMinutes(snapshotN.m());
                    String str3 = snapshotN.a() ? ", limit schedule" : "";
                    Long lH = snapshotN.h();
                    if (lH != null) {
                        str2 = ", earned at " + Instant.ofEpochMilli(lH.longValue()).atZone(ZoneId.systemDefault()).format(DateTimeFormatter.ofPattern("HH:mm"));
                    }
                    String str4 = str2 != null ? str2 : "";
                    String str5 = snapshotN.l() + " — " + minutes + "/" + minutes2 + " min" + str3 + str4;
                    if (str5 != null) {
                        return str5;
                    }
                }
                return "-";
            case 27:
                if (snapshotN != null) {
                    long minutes3 = TimeUnit.MILLISECONDS.toMinutes(snapshotN.i());
                    String str6 = snapshotN.k() + ", longest " + minutes3 + " min, " + snapshotN.j();
                    if (str6 != null) {
                        return str6;
                    }
                }
                return "-";
            case 28:
                if (snapshotN != null) {
                    String strC = snapshotN.c();
                    if (strC.length() == 0) {
                        strC = "not yet";
                    }
                    String strJoinToString$default = CollectionsKt.joinToString$default(CollectionsKt.sorted(snapshotN.d()), null, null, null, 0, null, null, 63, null);
                    if (strJoinToString$default.length() == 0) {
                        strJoinToString$default = IntegrityManager.INTEGRITY_TYPE_NONE;
                    }
                    String str7 = "evaluated " + strC + ", milestones shown: " + strJoinToString$default;
                    if (str7 != null) {
                        return str7;
                    }
                }
                return "-";
            case 29:
                if (snapshotN != null) {
                    String strB = snapshotN.b();
                    if (strB.length() == 0) {
                        strB = "never";
                    }
                    String str8 = snapshotN.f() + ", evaluated to " + strB;
                    if (str8 != null) {
                        return str8;
                    }
                }
                return "-";
            case 30:
                return developerSettingsViewState.w().toString();
            case 31:
                RevenueCatOffering revenueCatOfferingV = developerSettingsViewState.v();
                return (revenueCatOfferingV == null || (string = revenueCatOfferingV.toString()) == null) ? "None" : string;
            case 32:
                String strJ = developerSettingsViewState.j();
                return strJ == null ? "Not found" : strJ;
            case 33:
                String strY = developerSettingsViewState.y();
                return strY == null ? "Not found" : strY;
            case 34:
                return developerSettingsViewState.X() ? developerSettingsViewState.f() : "Not signed in";
            case 35:
                return developerSettingsViewState.B().toString();
            case 36:
                return developerSettingsViewState.L().toString();
            case 37:
                return developerSettingsViewState.C().toString();
            case 38:
                return developerSettingsViewState.F().toString();
            case 39:
                return developerSettingsViewState.W().toString();
            case 40:
                return developerSettingsViewState.E().toString();
            case 41:
                RatingDialogType ratingDialogTypeN = developerSettingsViewState.n();
                return (ratingDialogTypeN == null || (strName = ratingDialogTypeN.name()) == null) ? "App Decides" : strName;
            case 42:
                InAppUpdatesMockSettingsDTO inAppUpdatesMockSettingsDTOO = developerSettingsViewState.o();
                return (inAppUpdatesMockSettingsDTOO == null || !inAppUpdatesMockSettingsDTOO.getEnabled()) ? "Disabled" : "Enabled";
            case 43:
                return developerSettingsViewState.q().length() > 0 ? "Set" : "Not set";
            case 44:
                return developerSettingsViewState.x().length() > 0 ? "Set" : "Default";
            case 45:
                return TimeUnit.MILLISECONDS.toMinutes(developerSettingsViewState.Q()) + " min";
            case 46:
                String strP = developerSettingsViewState.P();
                return StringsKt.p0(strP) ? "Not set" : strP;
            default:
                return null;
        }
    }

    private static final void a0(String str, Function1 function1) {
        Object obj;
        DeveloperSettingsItemId developerSettingsItemIdA = DeveloperSettingsItemId.Companion.a(str);
        switch (developerSettingsItemIdA == null ? -1 : WhenMappings.f108309b[developerSettingsItemIdA.ordinal()]) {
            case 1:
                obj = DeveloperSettingsViewEvent.OnUseProductionServerToggled.f108487a;
                break;
            case 2:
                obj = DeveloperSettingsViewEvent.OnInternetEnabledToggled.f108375a;
                break;
            case 3:
                obj = DeveloperSettingsViewEvent.OnSpeedUpTimersToggled.f108462a;
                break;
            case 4:
                obj = DeveloperSettingsViewEvent.OnTimeNudgeShortIntervalsToggled.f108482a;
                break;
            case 5:
                obj = DeveloperSettingsViewEvent.OnOfferLifetimeToggled.f108393a;
                break;
            case 6:
                obj = DeveloperSettingsViewEvent.OnTrialAlwaysEligibleToggled.f108483a;
                break;
            case 7:
                obj = DeveloperSettingsViewEvent.OnSimulateActiveTrialToggled.f108458a;
                break;
            case 8:
                obj = DeveloperSettingsViewEvent.OnSimulateBillingErrorToggled.f108459a;
                break;
            case 9:
                obj = DeveloperSettingsViewEvent.OnShowPirateVersionSheetToggled.f108452a;
                break;
            case 10:
                obj = DeveloperSettingsViewEvent.OnUseNewPaywallToggled.f108486a;
                break;
            case 11:
                obj = DeveloperSettingsViewEvent.OnShowAllTrendItemsToggled.f108444a;
                break;
            case 12:
                obj = DeveloperSettingsViewEvent.OnShowPremiumExpiringToggled.f108454a;
                break;
            case 13:
                obj = DeveloperSettingsViewEvent.OnShowPremiumExpiringCardsToggled.f108453a;
                break;
            case 14:
                obj = DeveloperSettingsViewEvent.OnForceAutoTrialExpiredToggled.f108369a;
                break;
            case 15:
                obj = DeveloperSettingsViewEvent.OnForceAutoTrialExpiredCardToggled.f108368a;
                break;
            case 16:
                obj = DeveloperSettingsViewEvent.OnShortenAutoTrialWaitToggled.f108438a;
                break;
            case 17:
                obj = DeveloperSettingsViewEvent.OnMockTrialComparisonDataToggled.f108386a;
                break;
            case 18:
                obj = DeveloperSettingsViewEvent.OnDisableBackdoorCodeCheckToggled.f108365a;
                break;
            case 19:
                obj = DeveloperSettingsViewEvent.OnAlwaysValidateEmergencyStringToggled.f108356a;
                break;
            case 20:
                obj = DeveloperSettingsViewEvent.OnLogLockServiceToggled.f108378a;
                break;
            case 21:
                obj = DeveloperSettingsViewEvent.OnPomodoroInSecondsToggled.f108423a;
                break;
            case 22:
                obj = DeveloperSettingsViewEvent.OnStrictModePauseInSecondsToggled.f108476a;
                break;
            case 23:
                obj = DeveloperSettingsViewEvent.OnAlwaysShowEmailConsentToggled.f108355a;
                break;
            case 24:
                obj = DeveloperSettingsViewEvent.OnForceLoadingEnabledToggled.f108370a;
                break;
            case 25:
                obj = DeveloperSettingsViewEvent.OnUseFakeReviewManagerToggled.f108485a;
                break;
            case 26:
            case 27:
            case 29:
                obj = DeveloperSettingsViewEvent.OnStreakRefreshClicked.f108467a;
                break;
            case 28:
                obj = DeveloperSettingsViewEvent.OnStreakRefreshClicked.f108467a;
                break;
            case 30:
                obj = DeveloperSettingsViewEvent.OnPremiumStateClicked.f108426a;
                break;
            case 31:
                obj = DeveloperSettingsViewEvent.OnPremiumProductClicked.f108424a;
                break;
            case 32:
                obj = DeveloperSettingsViewEvent.OnCopyFCMTokenClicked.f108363a;
                break;
            case 33:
                obj = DeveloperSettingsViewEvent.OnCopyRevenueCatIdClicked.f108364a;
                break;
            case 34:
                obj = DeveloperSettingsViewEvent.OnCopyCustomerIdClicked.f108362a;
                break;
            case 35:
                obj = DeveloperSettingsViewEvent.OnShowAdsClicked.f108439a;
                break;
            case 36:
                obj = DeveloperSettingsViewEvent.OnSkipDiscountTimerClicked.f108460a;
                break;
            case 37:
                obj = DeveloperSettingsViewEvent.OnShowAllDiscountsClicked.f108442a;
                break;
            case 38:
                obj = DeveloperSettingsViewEvent.OnShowIntroClicked.f108450a;
                break;
            case 39:
                obj = DeveloperSettingsViewEvent.OnWhatsNewCardClicked.f108488a;
                break;
            case 40:
                obj = DeveloperSettingsViewEvent.OnShowAniaInfoDialogClicked.f108445a;
                break;
            case 41:
                obj = DeveloperSettingsViewEvent.OnForceRatingDialogClicked.f108371a;
                break;
            case 42:
                obj = DeveloperSettingsViewEvent.OnMockInAppUpdatesClicked.f108380a;
                break;
            case 43:
                obj = DeveloperSettingsViewEvent.OnMockRemoteConfigClicked.f108384a;
                break;
            case 44:
                obj = DeveloperSettingsViewEvent.OnQuestionnaireConfigClicked.f108428a;
                break;
            case 45:
                obj = DeveloperSettingsViewEvent.OnTimeChangeLimitClicked.f108480a;
                break;
            case 46:
                obj = DeveloperSettingsViewEvent.OnTestTargetingGroupClicked.f108478a;
                break;
            case 47:
                obj = DeveloperSettingsViewEvent.OnStreakSeedClicked.f108470a;
                break;
            case 48:
                obj = DeveloperSettingsViewEvent.OnStreakSendAchievementClicked.f108472a;
                break;
            case 49:
                obj = DeveloperSettingsViewEvent.OnStreakAddActivityClicked.f108463a;
                break;
            case 50:
                obj = DeveloperSettingsViewEvent.OnStreakRunCatchUpClicked.f108469a;
                break;
            case 51:
                obj = DeveloperSettingsViewEvent.OnStreakClearClicked.f108464a;
                break;
            case 52:
                obj = DeveloperSettingsViewEvent.OnStreakOpenMilestoneClicked.f108466a;
                break;
            case 53:
                obj = DeveloperSettingsViewEvent.OnStreakOpenIntroductionClicked.f108465a;
                break;
            case 54:
                obj = DeveloperSettingsViewEvent.OnStreakShowBannerClicked.f108474a;
                break;
            case 55:
                obj = DeveloperSettingsViewEvent.OnStreakUploadClicked.f108475a;
                break;
            case 56:
                obj = DeveloperSettingsViewEvent.OnStreakSendNudgeClicked.f108473a;
                break;
            case 57:
                obj = DeveloperSettingsViewEvent.OnStreakResetPresentationClicked.f108468a;
                break;
            case 58:
                obj = DeveloperSettingsViewEvent.OnTriggerTimeNudgeClicked.f108484a;
                break;
            case 59:
                obj = DeveloperSettingsViewEvent.OnRemovePremiumClicked.f108432a;
                break;
            case 60:
                obj = DeveloperSettingsViewEvent.OnActivateCampaignClicked.f108354a;
                break;
            case 61:
                obj = DeveloperSettingsViewEvent.OnSubscriptionOnboardingTestClicked.f108477a;
                break;
            case 62:
                obj = DeveloperSettingsViewEvent.OnOpenDiscountScreenClicked.f108404a;
                break;
            case 63:
                obj = DeveloperSettingsViewEvent.OnOverridePaywallSettingsClicked.f108417a;
                break;
            case 64:
                obj = DeveloperSettingsViewEvent.OnResetDiscountOffersClicked.f108433a;
                break;
            case 65:
                obj = DeveloperSettingsViewEvent.OnShowWhatsNewFlowClicked.f108457a;
                break;
            case 66:
                obj = DeveloperSettingsViewEvent.OnMockWeeklyStatsNotificationClicked.f108391a;
                break;
            case 67:
                obj = DeveloperSettingsViewEvent.OnMockDailyInsightsMotivationClicked.f108379a;
                break;
            case 68:
                obj = DeveloperSettingsViewEvent.OnMockTrialExpiringNotificationClicked.f108389a;
                break;
            case 69:
                obj = DeveloperSettingsViewEvent.OnMockTrialConvReminderNotificationClicked.f108388a;
                break;
            case 70:
                obj = DeveloperSettingsViewEvent.OnMockTrialConvFailedNotificationClicked.f108387a;
                break;
            case 71:
                obj = DeveloperSettingsViewEvent.OnMockWeeklyStatsScreenClicked.f108392a;
                break;
            case 72:
                obj = DeveloperSettingsViewEvent.OnMockWeeklyStatsDialogClicked.f108390a;
                break;
            case 73:
                obj = DeveloperSettingsViewEvent.OnMockPremiumExpiringScreenClicked.f108383a;
                break;
            case 74:
                obj = DeveloperSettingsViewEvent.OnGenerateFakeInsightsDataClicked.f108374a;
                break;
            case 75:
                obj = DeveloperSettingsViewEvent.OnParseSupportJsonClicked.f108419a;
                break;
            case 76:
                obj = DeveloperSettingsViewEvent.OnParseSupportJsonFileClicked.f108420a;
                break;
            case 77:
                obj = DeveloperSettingsViewEvent.OnRemoteConfigValuesClicked.f108430a;
                break;
            case 78:
                obj = DeveloperSettingsViewEvent.OnClearStrictModeClicked.f108360a;
                break;
            case 79:
                obj = DeveloperSettingsViewEvent.OnClearStrictModeOnboardingClicked.f108361a;
                break;
            case 80:
                obj = DeveloperSettingsViewEvent.OnResetQuickBlockClicked.f108434a;
                break;
            case 81:
                obj = DeveloperSettingsViewEvent.OnClearAdultContentClicked.f108359a;
                break;
            case 82:
                obj = DeveloperSettingsViewEvent.OnResetStrictModeUpsellClicked.f108435a;
                break;
            case 83:
                obj = DeveloperSettingsViewEvent.OnResetUnlockAllAppsTimerClicked.f108436a;
                break;
            case 84:
                obj = DeveloperSettingsViewEvent.OnGenerateBackdoorCodeClicked.f108373a;
                break;
            case 85:
                obj = DeveloperSettingsViewEvent.OnListAllBrowsersClicked.f108377a;
                break;
            case 86:
                obj = DeveloperSettingsViewEvent.OnShowAdsInspectorClicked.f108440a;
                break;
            case 87:
                obj = DeveloperSettingsViewEvent.OnShowEventsBubbleClicked.f108449a;
                break;
            case 88:
                obj = DeveloperSettingsViewEvent.OnShowChatBotClicked.f108448a;
                break;
            case 89:
                obj = DeveloperSettingsViewEvent.OnPerformFatalCrashClicked.f108422a;
                break;
            case 90:
                obj = DeveloperSettingsViewEvent.OnOpenAutoTrialFlowClicked.f108397a;
                break;
            case 91:
                obj = DeveloperSettingsViewEvent.OnOpenIntroTrialPremiumClicked.f108408a;
                break;
            case 92:
                obj = DeveloperSettingsViewEvent.OnOpenTrialRetentionPremiumClicked.f108415a;
                break;
            case 93:
                obj = DeveloperSettingsViewEvent.OnOpenGenericPremiumClicked.f108407a;
                break;
            case 94:
                obj = DeveloperSettingsViewEvent.OnOpenDiscountPremiumClicked.f108401a;
                break;
            case 95:
                obj = DeveloperSettingsViewEvent.OnOpenDiscountPremium30Clicked.f108399a;
                break;
            case 96:
                obj = DeveloperSettingsViewEvent.OnOpenDiscountPremium50Clicked.f108400a;
                break;
            case 97:
                obj = DeveloperSettingsViewEvent.OnOpenExpiredSubPremiumClicked.f108406a;
                break;
            case 98:
                obj = DeveloperSettingsViewEvent.OnOpenProductPlanPremiumClicked.f108414a;
                break;
            case 99:
                obj = DeveloperSettingsViewEvent.OnOpenLimitScreenPremiumClicked.f108410a;
                break;
            case 100:
                obj = DeveloperSettingsViewEvent.OnOpenExpiredSubDiscountPremiumClicked.f108405a;
                break;
            case 101:
                obj = DeveloperSettingsViewEvent.OnOpenIntroTrialTogglePremiumClicked.f108409a;
                break;
            case 102:
                obj = DeveloperSettingsViewEvent.OnOpenOneTimeToSubPremiumClicked.f108412a;
                break;
            case 103:
                obj = DeveloperSettingsViewEvent.OnOpenDiscountPremiumReferralSenderClicked.f108403a;
                break;
            case 104:
                obj = DeveloperSettingsViewEvent.OnOpenDiscountPremiumReferralReceiverClicked.f108402a;
                break;
            case 105:
                obj = DeveloperSettingsViewEvent.OnOpenCampaignPremiumClicked.f108398a;
                break;
            case 106:
                obj = DeveloperSettingsViewEvent.OnLaunchOnboardingClicked.f108376a;
                break;
            case 107:
                obj = DeveloperSettingsViewEvent.OnShowAppFeelOnboardingClicked.f108447a;
                break;
            case 108:
                obj = DeveloperSettingsViewEvent.OnShowTrialRemindersFlowClicked.f108456a;
                break;
            case 109:
                obj = DeveloperSettingsViewEvent.OnShowRatingDialogFlowClicked.f108455a;
                break;
            case 110:
                obj = DeveloperSettingsViewEvent.OnOpenAccessibilitySettings.f108395a;
                break;
            case 111:
                obj = DeveloperSettingsViewEvent.OnOpenOverlaySettings.f108413a;
                break;
            case 112:
                obj = DeveloperSettingsViewEvent.OnOpenUsageSettings.f108416a;
                break;
            case 113:
                obj = DeveloperSettingsViewEvent.OnOpenNotificationAccessSettings.f108411a;
                break;
            case 114:
                obj = DeveloperSettingsViewEvent.OnOpenAppSettings.f108396a;
                break;
            case 115:
                obj = DeveloperSettingsViewEvent.OnRemoveDeviceAdmin.f108431a;
                break;
            default:
                return;
        }
        function1.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b0(Context context) {
        AnswersHelper.f128199a.y8(true);
        Intent data = new Intent(context, (Class<?>) DevEventsActivity.class).setAction("android.intent.action.VIEW").setData(Uri.parse("https://cz.mobilesoft.appblock/chat/12345"));
        Intrinsics.checkNotNullExpressionValue(data, "setData(...)");
        PendingIntent activity = PendingIntent.getActivity(context, 1, data, 167772160);
        NotificationCompat.MessagingStyle messagingStyle = new NotificationCompat.MessagingStyle(new Person.Builder().e("User").a());
        Person personA = new Person.Builder().e("Chat partner").c(true).a();
        Intrinsics.checkNotNullExpressionValue(personA, "build(...)");
        ShortcutInfoCompat.Builder builderG = new ShortcutInfoCompat.Builder(context, "12345").b(SetsKt.setOf("cz.mobilesoft.appblock.IMG_SHARE_TARGET")).d(new Intent("android.intent.action.VIEW")).f(new LocusIdCompat("12345")).g(true);
        CharSequence charSequenceD = personA.d();
        if (charSequenceD == null) {
            charSequenceD = "";
        }
        ShortcutInfoCompat shortcutInfoCompatA = builderG.i(charSequenceD).d(new Intent(context, (Class<?>) DevEventsActivity.class).setAction("android.intent.action.VIEW")).a();
        Intrinsics.checkNotNullExpressionValue(shortcutInfoCompatA, "build(...)");
        ShortcutManagerCompat.k(context, shortcutInfoCompatA);
        NotificationCompat.BubbleMetadata bubbleMetadataA = new NotificationCompat.BubbleMetadata.Builder(activity, IconCompat.d(context, R.drawable.Z)).c(600).b(true).e(true).a();
        Intrinsics.checkNotNullExpressionValue(bubbleMetadataA, "build(...)");
        NotificationCompat.Builder builderB = new NotificationCompat.Builder(context, NotificationChannelHelper.Channel.DEFAULT.getId()).h(bubbleMetadataA).y("12345").i(SDKConstants.PARAM_DEBUG_MESSAGE).x(0).b(personA).D(messagingStyle).l(PendingIntent.getActivity(context, 1, data, 167772160)).B(R.drawable.C0);
        Intrinsics.checkNotNullExpressionValue(builderB, "setSmallIcon(...)");
        NotificationManagerCompat notificationManagerCompatD = NotificationManagerCompat.d(context);
        Intrinsics.checkNotNullExpressionValue(notificationManagerCompatD, "from(...)");
        if (ContextCompat.checkSelfPermission(context, "android.permission.POST_NOTIFICATIONS") != 0) {
            Toast.makeText(context, "Notification permission required", 0).show();
        } else {
            notificationManagerCompatD.f(100015, builderB.c());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(final DeveloperSettingsCategory developerSettingsCategory, final String str, final DeveloperSettingsViewState developerSettingsViewState, final Function1 function1, Composer composer, final int i3) {
        String str2;
        Composer composer2;
        int i4;
        float f3;
        int i5;
        int i6;
        int i7;
        Composer composer3;
        int i8;
        DeveloperSettingsViewState developerSettingsViewState2 = developerSettingsViewState;
        final Function1 function12 = function1;
        Composer composerK = composer.k(-1404930698);
        int i9 = (i3 & 6) == 0 ? ((i3 & 8) == 0 ? composerK.Z(developerSettingsCategory) : composerK.I(developerSettingsCategory) ? 4 : 2) | i3 : i3;
        if ((i3 & 48) == 0) {
            str2 = str;
            i9 |= composerK.Z(str2) ? 32 : 16;
        } else {
            str2 = str;
        }
        if ((i3 & 384) == 0) {
            i9 |= composerK.Z(developerSettingsViewState2) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            i9 |= composerK.I(function12) ? 2048 : 1024;
        }
        int i10 = 0;
        int i11 = 1;
        if (composerK.r((i9 & 1171) != 1170, i9 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1404930698, i9, -1, "cz.mobilesoft.coreblock.scene.more.settings.developer.CategoryItems (DeveloperSettingsScreen.kt:246)");
            }
            float fA = PrimitiveResources_androidKt.a(R.dimen.f95480n, composerK, 0);
            float fG = Dp.g(2);
            int i12 = 0;
            for (Object obj : developerSettingsCategory.e()) {
                int i13 = i12 + 1;
                if (i12 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                final DeveloperSettingsItem developerSettingsItem = (DeveloperSettingsItem) obj;
                float f4 = i12 == 0 ? fA : fG;
                if (i12 == CollectionsKt.getLastIndex(developerSettingsCategory.e())) {
                    i4 = i10;
                    f3 = fA;
                } else {
                    i4 = i10;
                    f3 = fG;
                }
                int i14 = WhenMappings.f108308a[developerSettingsItem.b().ordinal()];
                if (i14 != i11) {
                    if (i14 == 2) {
                        i5 = i4;
                    } else if (i14 == 3) {
                        i5 = 0;
                    } else {
                        if (i14 != 4) {
                            composerK.a0(1164890050);
                            composerK.U();
                            throw new NoWhenBranchMatchedException();
                        }
                        composerK.a0(1752283402);
                        String strZ = Z(developerSettingsItem.a(), developerSettingsViewState2);
                        boolean zI = ((i9 & 7168) == 2048) | composerK.I(developerSettingsItem);
                        Object objG = composerK.G();
                        if (zI || objG == Composer.f23746a.a()) {
                            objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.h4
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return DeveloperSettingsScreenKt.x(developerSettingsItem, function12);
                                }
                            };
                            composerK.w(objG);
                        }
                        i8 = i9;
                        composer3 = composerK;
                        i5 = 0;
                        i6 = 1;
                        U(developerSettingsItem, str2, strZ, f4, f3, (Function0) objG, composer3, DeveloperSettingsItem.f108278h | (i9 & 112));
                        composer3.U();
                        i7 = i8;
                    }
                    i8 = i9;
                    float f5 = f4;
                    float f6 = f3;
                    i6 = i11;
                    composerK.a0(1752077965);
                    int i15 = (composerK.I(developerSettingsItem) ? 1 : 0) | ((i8 & 7168) == 2048 ? i6 : i5);
                    Object objG2 = composerK.G();
                    if (i15 != 0 || objG2 == Composer.f23746a.a()) {
                        objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.w3
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return DeveloperSettingsScreenKt.w(developerSettingsItem, function12);
                            }
                        };
                        composerK.w(objG2);
                    }
                    M(developerSettingsItem, str, f5, f6, (Function0) objG2, composerK, (i8 & 112) | DeveloperSettingsItem.f108278h);
                    composerK.U();
                    composer3 = composerK;
                    i7 = i8;
                } else {
                    i5 = i4;
                    int i16 = i9;
                    i6 = i11;
                    composerK.a0(1751896739);
                    Composer composer4 = composerK;
                    i7 = i16;
                    P(developerSettingsItem, str, developerSettingsViewState2, function12, f4, f3, composer4, (i16 & 7168) | DeveloperSettingsItem.f108278h | (i16 & 112) | (i16 & 896));
                    composer3 = composer4;
                    composer3.U();
                }
                str2 = str;
                developerSettingsViewState2 = developerSettingsViewState;
                function12 = function1;
                i9 = i7;
                composerK = composer3;
                i12 = i13;
                i10 = i5;
                i11 = i6;
            }
            composer2 = composerK;
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer2 = composerK;
            composer2.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.j4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    return DeveloperSettingsScreenKt.y(developerSettingsCategory, str, developerSettingsViewState, function1, i3, (Composer) obj2, ((Integer) obj3).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit w(DeveloperSettingsItem developerSettingsItem, Function1 function1) {
        a0(developerSettingsItem.a(), function1);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit x(DeveloperSettingsItem developerSettingsItem, Function1 function1) {
        a0(developerSettingsItem.a(), function1);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit y(DeveloperSettingsCategory developerSettingsCategory, String str, DeveloperSettingsViewState developerSettingsViewState, Function1 function1, int i3, Composer composer, int i4) {
        v(developerSettingsCategory, str, developerSettingsViewState, function1, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    private static final void z(DeveloperSettingsViewModel developerSettingsViewModel, final Function0 function0, final Function1 function1, Composer composer, final int i3) {
        int i4;
        final DeveloperSettingsViewModel developerSettingsViewModel2;
        Composer composerK = composer.k(342535781);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(developerSettingsViewModel) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.I(function1) ? 256 : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if (composerK.r((i4 & 131) != 130, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(342535781, i4, -1, "cz.mobilesoft.coreblock.scene.more.settings.developer.CommandProcessor (DeveloperSettingsScreen.kt:609)");
            }
            Context context = (Context) composerK.q(AndroidCompositionLocals_androidKt.g());
            boolean z2 = false;
            int i5 = i4 & 14;
            final Function1 function1N = FlowExtKt.n(developerSettingsViewModel, composerK, i5);
            ActivityResultContracts.StartActivityForResult startActivityForResult = new ActivityResultContracts.StartActivityForResult();
            boolean Z = composerK.Z(function1N);
            Object objG = composerK.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.c4
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return DeveloperSettingsScreenKt.A(function1N, (ActivityResult) obj);
                    }
                };
                composerK.w(objG);
            }
            ManagedActivityResultLauncher managedActivityResultLauncherA = ActivityResultRegistryKt.a(startActivityForResult, (Function1) objG, composerK, 0);
            boolean zI = composerK.I(context);
            if ((i4 & 896) == 256) {
                z2 = true;
            }
            boolean zI2 = zI | z2 | composerK.I(managedActivityResultLauncherA);
            Object objG2 = composerK.G();
            if (zI2 || objG2 == Composer.f23746a.a()) {
                objG2 = new DeveloperSettingsScreenKt$CommandProcessor$1$1(context, function1, managedActivityResultLauncherA, null);
                composerK.w(objG2);
            }
            Function2 function2 = (Function2) objG2;
            developerSettingsViewModel2 = developerSettingsViewModel;
            FlowExtKt.g(developerSettingsViewModel2, null, function2, composerK, i5, 2);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            developerSettingsViewModel2 = developerSettingsViewModel;
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.d4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DeveloperSettingsScreenKt.B(developerSettingsViewModel2, function0, function1, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}
