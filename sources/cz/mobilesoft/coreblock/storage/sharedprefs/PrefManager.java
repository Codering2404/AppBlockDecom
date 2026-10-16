package cz.mobilesoft.coreblock.storage.sharedprefs;

import android.content.Context;
import android.preference.PreferenceManager;
import com.google.gson.Gson;
import com.revenuecat.purchases.ui.revenuecatui.templates.VWmQ.cJfnYMIyomoWf;
import cz.mobilesoft.coreblock.BuildConfig;
import cz.mobilesoft.coreblock.dto.QuestionnaireConfig;
import cz.mobilesoft.coreblock.enums.StatisticsRecordType;
import cz.mobilesoft.coreblock.enums.StatisticsTimeFilter;
import cz.mobilesoft.coreblock.enums.StatisticsUsageTypeFilter;
import cz.mobilesoft.coreblock.service.receiver.QuickBlockTileService;
import cz.mobilesoft.coreblock.storage.datastore.CoreDataStore;
import cz.mobilesoft.coreblock.storage.datastore.dev.DevDataStore;
import cz.mobilesoft.coreblock.storage.datastore.dev.DevPrefState;
import cz.mobilesoft.coreblock.storage.sharedprefs.flowproperty.BlockingFlowProperty;
import cz.mobilesoft.coreblock.util.AdsUtils;
import cz.mobilesoft.coreblock.util.BaseRemoteConfig;
import cz.mobilesoft.coreblock.util.CrashHelper;
import cz.mobilesoft.coreblock.util.InterstitialUtils;
import cz.mobilesoft.coreblock.util.constants.Constants;
import cz.mobilesoft.coreblock.util.helperextension.TimeHelperExt;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.koin.core.Koin;
import org.koin.core.component.KoinComponent;
import org.koin.core.component.KoinScopeComponent;
import org.koin.core.qualifier.Qualifier;
import org.koin.mp.KoinPlatformTools;

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
public final class PrefManager implements KoinComponent {
    private static final StringPref A;
    private static final StringPref A0;
    private static final IntPref B;
    private static final BooleanPref B0;
    private static final Lazy C;
    private static final BooleanPref C0;
    private static final StringPref D;
    private static final BooleanPref D0;
    private static final Lazy E;
    private static final BooleanPref E0;
    private static final StringPref F;
    private static final BooleanPref F0;
    private static final LongPref G;
    private static final BooleanPref G0;
    private static final BooleanPref H;
    private static final StringSetPref H0;
    private static final BooleanPref I;
    private static final BooleanPref I0;
    private static final StringSetPref J;
    private static final BooleanPref J0;
    private static final IntPref K;
    private static final IntPref K0;
    private static final IntPref L;
    private static final BooleanPref L0;
    private static final BooleanPref M;
    public static final int M0;
    private static final ConvertedIntPref N;
    private static final ConvertedIntPref O;
    private static final ConvertedIntPref P;
    private static final BooleanPref Q;
    private static final BooleanPref R;
    private static final BooleanPref S;
    private static final BooleanPref T;
    private static final BooleanPref U;
    private static final LongPref V;
    private static final BooleanPref W;
    private static final LongPref X;
    private static final StringPref Y;
    private static final StringPref Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final PrefManager f126839a;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    private static final BooleanPref f126840a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final /* synthetic */ KProperty[] f126841b = {Reflection.e(new MutablePropertyReference1Impl(PrefManager.class, "isUsageAccessNotRequired", "isUsageAccessNotRequired()Z", 0)), Reflection.e(new MutablePropertyReference1Impl(PrefManager.class, "showLockDialog", "getShowLockDialog()Z", 0)), Reflection.e(new MutablePropertyReference1Impl(PrefManager.class, "showLocationDisclaimerDialog", "getShowLocationDisclaimerDialog()Z", 0)), Reflection.e(new MutablePropertyReference1Impl(PrefManager.class, "activateLocationProfilesOnServicesOffOld", "getActivateLocationProfilesOnServicesOffOld()Z", 0)), Reflection.e(new MutablePropertyReference1Impl(PrefManager.class, "locationProfilesOnIfUnavailable", "getLocationProfilesOnIfUnavailable()Z", 0)), Reflection.e(new MutablePropertyReference1Impl(PrefManager.class, "shouldRecreateGeofencesWhenPossible", "getShouldRecreateGeofencesWhenPossible()Z", 0)), Reflection.e(new MutablePropertyReference1Impl(PrefManager.class, "lastGeofencesRecreationTime", "getLastGeofencesRecreationTime()J", 0)), Reflection.e(new MutablePropertyReference1Impl(PrefManager.class, "wereEverNoteJobsIntroduced", "getWereEverNoteJobsIntroduced()Z", 0)), Reflection.e(new MutablePropertyReference1Impl(PrefManager.class, "showOreoNotificationDisableDialog", "getShowOreoNotificationDisableDialog()Z", 0)), Reflection.e(new MutablePropertyReference1Impl(PrefManager.class, "adCountries", "getAdCountries()Ljava/lang/String;", 0)), Reflection.e(new MutablePropertyReference1Impl(PrefManager.class, "supportEmail", "getSupportEmail()Ljava/lang/String;", 0)), Reflection.e(new MutablePropertyReference1Impl(PrefManager.class, "showPermissionSkipDisclaimerDialog", "getShowPermissionSkipDisclaimerDialog()Z", 0)), Reflection.e(new MutablePropertyReference1Impl(PrefManager.class, "wasDefaultWebInfoSaved", "getWasDefaultWebInfoSaved()Z", 0)), Reflection.e(new MutablePropertyReference1Impl(PrefManager.class, "interstitialAdFrequency", "getInterstitialAdFrequency()I", 0)), Reflection.e(new MutablePropertyReference1Impl(PrefManager.class, "lastInterstitialAdShowTime", "getLastInterstitialAdShowTime()J", 0)), Reflection.e(new MutablePropertyReference1Impl(PrefManager.class, "wasMIUI11PermissionScreenShown", "getWasMIUI11PermissionScreenShown()Z", 0)), Reflection.e(new MutablePropertyReference1Impl(PrefManager.class, "showPaymentOneTimeDisclaimer", "getShowPaymentOneTimeDisclaimer()Z", 0)), Reflection.e(new MutablePropertyReference1Impl(PrefManager.class, "redirectAddress", "getRedirectAddress()Ljava/lang/String;", 0)), Reflection.e(new MutablePropertyReference1Impl(PrefManager.class, "dayNightMode", "getDayNightMode()I", 0)), Reflection.e(new MutablePropertyReference1Impl(PrefManager.class, "blockingScreenMessage", "getBlockingScreenMessage()Ljava/lang/String;", 0)), Reflection.e(new MutablePropertyReference1Impl(PrefManager.class, "firebaseToken", "getFirebaseToken()Ljava/lang/String;", 0)), Reflection.e(new MutablePropertyReference1Impl(PrefManager.class, "lastApplicationAccessSyncTime", "getLastApplicationAccessSyncTime()J", 0)), Reflection.e(new MutablePropertyReference1Impl(PrefManager.class, "isStatisticsAccessibilitySkipped", "isStatisticsAccessibilitySkipped()Z", 0)), Reflection.e(new MutablePropertyReference1Impl(PrefManager.class, "isDefaultStatisticsIgnoredAppsSet", "isDefaultStatisticsIgnoredAppsSet()Z", 0)), Reflection.e(new MutablePropertyReference1Impl(PrefManager.class, "defaultStatisticsIgnoredApps", "getDefaultStatisticsIgnoredApps()Ljava/util/Set;", 0)), Reflection.e(new MutablePropertyReference1Impl(PrefManager.class, "defaultStatisticsTimeFilterId", "getDefaultStatisticsTimeFilterId()I", 0)), Reflection.e(new MutablePropertyReference1Impl(PrefManager.class, "defaultStatisticsUsageTypeFilterId", "getDefaultStatisticsUsageTypeFilterId()I", 0)), Reflection.e(new MutablePropertyReference1Impl(PrefManager.class, "wasDBv28PackageInstallerFixed", "getWasDBv28PackageInstallerFixed()Z", 0)), Reflection.e(new MutablePropertyReference1Impl(PrefManager.class, "dashboardCardStatisticsAppsWebsFilter", "getDashboardCardStatisticsAppsWebsFilter()Lcz/mobilesoft/coreblock/enums/StatisticsRecordType;", 0)), Reflection.e(new MutablePropertyReference1Impl(PrefManager.class, "dashboardCardStatisticsUsageTypeFilter", "getDashboardCardStatisticsUsageTypeFilter()Lcz/mobilesoft/coreblock/enums/StatisticsUsageTypeFilter;", 0)), Reflection.e(new MutablePropertyReference1Impl(PrefManager.class, "dashboardCardStatisticsTimeFilter", "getDashboardCardStatisticsTimeFilter()Lcz/mobilesoft/coreblock/enums/StatisticsTimeFilter;", 0)), Reflection.e(new MutablePropertyReference1Impl(PrefManager.class, "statisticsEnabled", "getStatisticsEnabled()Z", 0)), Reflection.e(new MutablePropertyReference1Impl(PrefManager.class, "webStatisticsEnabled", "getWebStatisticsEnabled()Z", 0)), Reflection.e(new MutablePropertyReference1Impl(PrefManager.class, "incognitoStatisticsEnabled", "getIncognitoStatisticsEnabled()Z", 0)), Reflection.e(new MutablePropertyReference1Impl(PrefManager.class, "appStatisticsEnabled", "getAppStatisticsEnabled()Z", 0)), Reflection.e(new MutablePropertyReference1Impl(PrefManager.class, "shouldSendStatisticsEnabledState", "getShouldSendStatisticsEnabledState()Z", 0)), Reflection.e(new MutablePropertyReference1Impl(PrefManager.class, "lastSubscriptionUpdateTime", "getLastSubscriptionUpdateTime()J", 0)), Reflection.e(new MutablePropertyReference1Impl(PrefManager.class, "wasIncognitoBadgeViewIdsSaved", "getWasIncognitoBadgeViewIdsSaved()Z", 0)), Reflection.e(new MutablePropertyReference1Impl(PrefManager.class, "strictModeTime", "getStrictModeTime()J", 0)), Reflection.e(new MutablePropertyReference1Impl(PrefManager.class, "strictModeTimeType", "getStrictModeTimeType()Ljava/lang/String;", 0)), Reflection.e(new MutablePropertyReference1Impl(PrefManager.class, "incognitoSupportedBrowsers", "getIncognitoSupportedBrowsers()Ljava/lang/String;", 0)), Reflection.e(new MutablePropertyReference1Impl(PrefManager.class, "showStrictModeChargerWarningDialog", "getShowStrictModeChargerWarningDialog()Z", 0)), Reflection.e(new MutablePropertyReference1Impl(PrefManager.class, "wasStrictModeMIUISecurityAppFixed", "getWasStrictModeMIUISecurityAppFixed()Z", 0)), Reflection.e(new MutablePropertyReference1Impl(PrefManager.class, "wasQuickBlockProfileCreated", "getWasQuickBlockProfileCreated()Z", 0)), Reflection.e(new MutablePropertyReference1Impl(PrefManager.class, "wasAddNewlyInstalledAppsUsed", "getWasAddNewlyInstalledAppsUsed()Z", 0)), Reflection.e(new MutablePropertyReference1Impl(PrefManager.class, "shouldShowNewlyInstalledAppsInfoDialogOnEnter", "getShouldShowNewlyInstalledAppsInfoDialogOnEnter()Z", 0)), Reflection.e(new MutablePropertyReference1Impl(PrefManager.class, "quickBlockLastSetTime", "getQuickBlockLastSetTime()I", 0)), Reflection.e(new MutablePropertyReference1Impl(PrefManager.class, "shouldShowQuickBlockTileCard", "getShouldShowQuickBlockTileCard()Z", 0)), Reflection.e(new MutablePropertyReference1Impl(PrefManager.class, "wasStrictModeProfileCreated", "getWasStrictModeProfileCreated()Z", 0)), Reflection.e(new MutablePropertyReference1Impl(PrefManager.class, "premiumButtonColor", "getPremiumButtonColor()I", 0)), Reflection.e(new MutablePropertyReference1Impl(PrefManager.class, "premiumScreenButtonText", "getPremiumScreenButtonText()Ljava/lang/String;", 0)), Reflection.e(new MutablePropertyReference1Impl(PrefManager.class, "premiumScreenButtonTextTrial", "getPremiumScreenButtonTextTrial()Ljava/lang/String;", 0)), Reflection.e(new MutablePropertyReference1Impl(PrefManager.class, "premiumDiscountButtonText", "getPremiumDiscountButtonText()Ljava/lang/String;", 0)), Reflection.e(new MutablePropertyReference1Impl(PrefManager.class, "premiumHintButtonText", "getPremiumHintButtonText()Ljava/lang/String;", 0)), Reflection.e(new MutablePropertyReference1Impl(PrefManager.class, "limitScreenType", "getLimitScreenType()Ljava/lang/String;", 0)), Reflection.e(new MutablePropertyReference1Impl(PrefManager.class, "isDashboardAutomaticSortingEnabled", "isDashboardAutomaticSortingEnabled()Z", 0)), Reflection.e(new MutablePropertyReference1Impl(PrefManager.class, "dashboardCardPreferredBlocking", "getDashboardCardPreferredBlocking()J", 0)), Reflection.e(new MutablePropertyReference1Impl(PrefManager.class, "questionnaireConfigJson", "getQuestionnaireConfigJson()Ljava/lang/String;", 0)), Reflection.e(new MutablePropertyReference1Impl(PrefManager.class, "lastQuestionnaireId", "getLastQuestionnaireId()I", 0)), Reflection.e(new MutablePropertyReference1Impl(PrefManager.class, "earliestDiscountShowHours", "getEarliestDiscountShowHours()J", 0)), Reflection.e(new MutablePropertyReference1Impl(PrefManager.class, "adsShowAfterHours", "getAdsShowAfterHours()J", 0)), Reflection.e(new MutablePropertyReference1Impl(PrefManager.class, "interstitialShowAfterHours", "getInterstitialShowAfterHours()J", 0)), Reflection.e(new MutablePropertyReference1Impl(PrefManager.class, "showAcademyClosingLessonDialog", "getShowAcademyClosingLessonDialog()Z", 0)), Reflection.e(new MutablePropertyReference1Impl(PrefManager.class, "hasUserSeenAcademy", "getHasUserSeenAcademy()Z", 0)), Reflection.e(new MutablePropertyReference1Impl(PrefManager.class, "isAcademyEnabled", "isAcademyEnabled()Z", 0)), Reflection.e(new MutablePropertyReference1Impl(PrefManager.class, "academyFreeLessons", "getAcademyFreeLessons()I", 0)), Reflection.e(new MutablePropertyReference1Impl(PrefManager.class, cJfnYMIyomoWf.JAvyplVvGvbquE, "getPrivacyPolicyUrl()Ljava/lang/String;", 0)), Reflection.e(new MutablePropertyReference1Impl(PrefManager.class, "conditionsOfUseUrl", "getConditionsOfUseUrl()Ljava/lang/String;", 0)), Reflection.e(new MutablePropertyReference1Impl(PrefManager.class, "wasAccessibilityDisclaimerAccepted", "getWasAccessibilityDisclaimerAccepted()Z", 0)), Reflection.e(new MutablePropertyReference1Impl(PrefManager.class, "wasQuickBlockConfigCollected", "getWasQuickBlockConfigCollected()Z", 0)), Reflection.e(new MutablePropertyReference1Impl(PrefManager.class, "wasQuickBlockSetupFinished", "getWasQuickBlockSetupFinished()Z", 0)), Reflection.e(new MutablePropertyReference1Impl(PrefManager.class, "isDashboardCardAutomaticSortingReset", "isDashboardCardAutomaticSortingReset()Z", 0)), Reflection.e(new MutablePropertyReference1Impl(PrefManager.class, "was2022Q2InfoCollected", "getWas2022Q2InfoCollected()Z", 0)), Reflection.e(new MutablePropertyReference1Impl(PrefManager.class, "isAccessibilityServicePollingEnabled", "isAccessibilityServicePollingEnabled()Z", 0)), Reflection.e(new MutablePropertyReference1Impl(PrefManager.class, "forcedHiddenPackageNames", "getForcedHiddenPackageNames()Ljava/util/Set;", 0)), Reflection.e(new MutablePropertyReference1Impl(PrefManager.class, "wasExpiredSubscriptionOfferScheduledAfterUpdate", "getWasExpiredSubscriptionOfferScheduledAfterUpdate()Z", 0)), Reflection.e(new MutablePropertyReference1Impl(PrefManager.class, "showSubscriptionExpiredNotifications", "getShowSubscriptionExpiredNotifications()Z", 0)), Reflection.e(new MutablePropertyReference1Impl(PrefManager.class, "subscriptionExpiredScreenId", "getSubscriptionExpiredScreenId()I", 0)), Reflection.e(new MutablePropertyReference1Impl(PrefManager.class, "showAllStrictModeLevels", "getShowAllStrictModeLevels()Z", 0))};

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    private static final BooleanPref f126842b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static PreferencesHolder f126843c;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    private static final BooleanPref f126844c0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static PreferencesHolder f126845d;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    private static final BooleanPref f126846d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    private static final BooleanPref f126847e0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static PreferencesHolder f126848f;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    private static final IntPref f126849f0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final Lazy f126850g;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    private static final BooleanPref f126851g0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final Lazy f126852h;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    private static final BooleanPref f126853h0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static boolean f126854i;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    private static final IntPref f126855i0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final BooleanPref f126856j;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    private static final StringPref f126857j0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final BooleanPref f126858k;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    private static final StringPref f126859k0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final BooleanPref f126860l;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    private static final StringPref f126861l0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final BooleanPref f126862m;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    private static final StringPref f126863m0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final BooleanPref f126864n;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    private static final StringPref f126865n0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final BooleanPref f126866o;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    private static final BooleanPref f126867o0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final LongPref f126868p;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    private static final LongPref f126869p0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final BooleanPref f126870q;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    private static final StringPref f126871q0;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final BooleanPref f126872r;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    private static final IntPref f126873r0;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static final StringPref f126874s;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    private static final LongPref f126875s0;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private static final StringPref f126876t;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    private static final LongPref f126877t0;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static final BooleanPref f126878u;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    private static final LongPref f126879u0;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private static final BooleanPref f126880v;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    private static final BooleanPref f126881v0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private static final IntPref f126882w;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    private static final BooleanPref f126883w0;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private static final LongPref f126884x;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    private static final BooleanPref f126885x0;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private static final BooleanPref f126886y;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    private static final IntPref f126887y0;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private static final BooleanPref f126888z;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    private static final StringPref f126889z0;

    /* JADX WARN: Multi-variable type inference failed */
    static {
        final PrefManager prefManager = new PrefManager();
        f126839a = prefManager;
        KoinPlatformTools koinPlatformTools = KoinPlatformTools.f146106a;
        LazyThreadSafetyMode lazyThreadSafetyModeB = koinPlatformTools.b();
        final Qualifier qualifier = null;
        final Object[] objArr = 0 == true ? 1 : 0;
        f126850g = LazyKt.a(lazyThreadSafetyModeB, new Function0<DevDataStore>() { // from class: cz.mobilesoft.coreblock.storage.sharedprefs.PrefManager$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = prefManager;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(DevDataStore.class), qualifier, objArr);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB2 = koinPlatformTools.b();
        final Object[] objArr2 = 0 == true ? 1 : 0;
        final Object[] objArr3 = 0 == true ? 1 : 0;
        f126852h = LazyKt.a(lazyThreadSafetyModeB2, new Function0<CoreDataStore>() { // from class: cz.mobilesoft.coreblock.storage.sharedprefs.PrefManager$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = prefManager;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(CoreDataStore.class), objArr2, objArr3);
            }
        });
        f126856j = new BooleanPref(new MutablePropertyReference0Impl(prefManager) { // from class: cz.mobilesoft.coreblock.storage.sharedprefs.PrefManager$isUsageAccessNotRequired$2
            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
            public Object get() {
                PreferencesHolder preferencesHolder = PrefManager.f126845d;
                if (preferencesHolder != null) {
                    return preferencesHolder;
                }
                Intrinsics.throwUninitializedPropertyAccessException("settingsPrefs");
                return null;
            }
        }, "PROP_ACCESSIBILITY_SET", false, null, null, 28, null);
        f126858k = new BooleanPref(new MutablePropertyReference0Impl(prefManager) { // from class: cz.mobilesoft.coreblock.storage.sharedprefs.PrefManager$showLockDialog$2
            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
            public Object get() {
                PreferencesHolder preferencesHolder = PrefManager.f126845d;
                if (preferencesHolder != null) {
                    return preferencesHolder;
                }
                Intrinsics.throwUninitializedPropertyAccessException("settingsPrefs");
                return null;
            }
        }, "PROP_NOT_SHOW_LOCK_DIALOG", false, new Function0() { // from class: cz.mobilesoft.coreblock.storage.sharedprefs.d
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(PrefManager.a3());
            }
        }, null, 20, null);
        f126860l = new BooleanPref(new MutablePropertyReference0Impl(prefManager) { // from class: cz.mobilesoft.coreblock.storage.sharedprefs.PrefManager$showLocationDisclaimerDialog$2
            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
            public Object get() {
                PreferencesHolder preferencesHolder = PrefManager.f126845d;
                if (preferencesHolder != null) {
                    return preferencesHolder;
                }
                Intrinsics.throwUninitializedPropertyAccessException("settingsPrefs");
                return null;
            }
        }, "PROP_NOT_SHOW_LOCATION_DISCLAIMER_DIALOG", false, new Function0() { // from class: cz.mobilesoft.coreblock.storage.sharedprefs.f
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(PrefManager.Z2());
            }
        }, null, 20, null);
        f126862m = new BooleanPref(new MutablePropertyReference0Impl(prefManager) { // from class: cz.mobilesoft.coreblock.storage.sharedprefs.PrefManager$activateLocationProfilesOnServicesOffOld$2
            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
            public Object get() {
                PreferencesHolder preferencesHolder = PrefManager.f126848f;
                if (preferencesHolder != null) {
                    return preferencesHolder;
                }
                Intrinsics.throwUninitializedPropertyAccessException("settingsMultiProcessPrefs");
                return null;
            }
        }, "PROP_LOCATION_ON_WHEN_UNAVAILABLE", false, null, null, 28, null);
        f126864n = new BooleanPref(new MutablePropertyReference0Impl(prefManager) { // from class: cz.mobilesoft.coreblock.storage.sharedprefs.PrefManager$locationProfilesOnIfUnavailable$2
            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
            public Object get() {
                PreferencesHolder preferencesHolder = PrefManager.f126848f;
                if (preferencesHolder != null) {
                    return preferencesHolder;
                }
                Intrinsics.throwUninitializedPropertyAccessException("settingsMultiProcessPrefs");
                return null;
            }
        }, "pref_location_profiles_always_on", false, new Function0() { // from class: cz.mobilesoft.coreblock.storage.sharedprefs.r
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(PrefManager.L1());
            }
        }, null, 20, null);
        f126866o = new BooleanPref(new MutablePropertyReference0Impl(prefManager) { // from class: cz.mobilesoft.coreblock.storage.sharedprefs.PrefManager$shouldRecreateGeofencesWhenPossible$2
            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
            public Object get() {
                PreferencesHolder preferencesHolder = PrefManager.f126845d;
                if (preferencesHolder != null) {
                    return preferencesHolder;
                }
                Intrinsics.throwUninitializedPropertyAccessException("settingsPrefs");
                return null;
            }
        }, "RECREATE_GEOFENCES_WHEN_POSSIBLE", false, null, null, 28, null);
        f126868p = new LongPref(new MutablePropertyReference0Impl(prefManager) { // from class: cz.mobilesoft.coreblock.storage.sharedprefs.PrefManager$lastGeofencesRecreationTime$2
            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
            public Object get() {
                PreferencesHolder preferencesHolder = PrefManager.f126845d;
                if (preferencesHolder != null) {
                    return preferencesHolder;
                }
                Intrinsics.throwUninitializedPropertyAccessException("settingsPrefs");
                return null;
            }
        }, "LAST_GEOFENCES_RECREATION_TIME", false, new Function0() { // from class: cz.mobilesoft.coreblock.storage.sharedprefs.d0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Long.valueOf(PrefManager.J1());
            }
        }, 4, null);
        f126870q = new BooleanPref(new MutablePropertyReference0Impl(prefManager) { // from class: cz.mobilesoft.coreblock.storage.sharedprefs.PrefManager$wereEverNoteJobsIntroduced$2
            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
            public Object get() {
                PreferencesHolder preferencesHolder = PrefManager.f126845d;
                if (preferencesHolder != null) {
                    return preferencesHolder;
                }
                Intrinsics.throwUninitializedPropertyAccessException("settingsPrefs");
                return null;
            }
        }, "WAS_EVERNOTE_INTRODUCED", false, null, null, 28, null);
        f126872r = new BooleanPref(new MutablePropertyReference0Impl(prefManager) { // from class: cz.mobilesoft.coreblock.storage.sharedprefs.PrefManager$showOreoNotificationDisableDialog$2
            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
            public Object get() {
                PreferencesHolder preferencesHolder = PrefManager.f126845d;
                if (preferencesHolder != null) {
                    return preferencesHolder;
                }
                Intrinsics.throwUninitializedPropertyAccessException("settingsPrefs");
                return null;
            }
        }, "SHOW_OREO_NOTIFICATION_DISABLE_DIALOG", false, new Function0() { // from class: cz.mobilesoft.coreblock.storage.sharedprefs.f0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(PrefManager.b3());
            }
        }, null, 20, null);
        f126874s = new StringPref(new MutablePropertyReference0Impl(prefManager) { // from class: cz.mobilesoft.coreblock.storage.sharedprefs.PrefManager$adCountries$2
            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
            public Object get() {
                PreferencesHolder preferencesHolder = PrefManager.f126845d;
                if (preferencesHolder != null) {
                    return preferencesHolder;
                }
                Intrinsics.throwUninitializedPropertyAccessException("settingsPrefs");
                return null;
            }
        }, "pref_mobilesoft_ads_countries", false, null, null, 28, null);
        f126876t = new StringPref(new MutablePropertyReference0Impl(prefManager) { // from class: cz.mobilesoft.coreblock.storage.sharedprefs.PrefManager$supportEmail$2
            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
            public Object get() {
                PreferencesHolder preferencesHolder = PrefManager.f126845d;
                if (preferencesHolder != null) {
                    return preferencesHolder;
                }
                Intrinsics.throwUninitializedPropertyAccessException("settingsPrefs");
                return null;
            }
        }, "PROP_APPBLOCK_SUPPORT_EMAIL", false, new Function0() { // from class: cz.mobilesoft.coreblock.storage.sharedprefs.g0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return PrefManager.i3();
            }
        }, null, 20, null);
        f126878u = new BooleanPref(new MutablePropertyReference0Impl(prefManager) { // from class: cz.mobilesoft.coreblock.storage.sharedprefs.PrefManager$showPermissionSkipDisclaimerDialog$2
            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
            public Object get() {
                PreferencesHolder preferencesHolder = PrefManager.f126845d;
                if (preferencesHolder != null) {
                    return preferencesHolder;
                }
                Intrinsics.throwUninitializedPropertyAccessException("settingsPrefs");
                return null;
            }
        }, "PROP_SHOW_PERMISSION_SKIP_DISCLAIMER_DIALOG", false, new Function0() { // from class: cz.mobilesoft.coreblock.storage.sharedprefs.h0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(PrefManager.d3());
            }
        }, null, 20, null);
        f126880v = new BooleanPref(new MutablePropertyReference0Impl(prefManager) { // from class: cz.mobilesoft.coreblock.storage.sharedprefs.PrefManager$wasDefaultWebInfoSaved$2
            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
            public Object get() {
                PreferencesHolder preferencesHolder = PrefManager.f126845d;
                if (preferencesHolder != null) {
                    return preferencesHolder;
                }
                Intrinsics.throwUninitializedPropertyAccessException("settingsPrefs");
                return null;
            }
        }, "PROP_WAS_DEFAULT_WEB_INFO_SAVED", false, null, null, 28, null);
        f126882w = new IntPref(new MutablePropertyReference0Impl(prefManager) { // from class: cz.mobilesoft.coreblock.storage.sharedprefs.PrefManager$interstitialAdFrequency$2
            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
            public Object get() {
                PreferencesHolder preferencesHolder = PrefManager.f126848f;
                if (preferencesHolder != null) {
                    return preferencesHolder;
                }
                Intrinsics.throwUninitializedPropertyAccessException("settingsMultiProcessPrefs");
                return null;
            }
        }, "PROP_INTERSTITIAL_AD_FREQUENCY", false, new Function0() { // from class: cz.mobilesoft.coreblock.storage.sharedprefs.i0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Integer.valueOf(PrefManager.A1());
            }
        }, null, 20, null);
        f126884x = new LongPref(new MutablePropertyReference0Impl(prefManager) { // from class: cz.mobilesoft.coreblock.storage.sharedprefs.PrefManager$lastInterstitialAdShowTime$2
            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
            public Object get() {
                PreferencesHolder preferencesHolder = PrefManager.f126845d;
                if (preferencesHolder != null) {
                    return preferencesHolder;
                }
                Intrinsics.throwUninitializedPropertyAccessException("settingsPrefs");
                return null;
            }
        }, "pref_last_interstitial_ad_show_time", false, null, 12, null);
        f126886y = new BooleanPref(new MutablePropertyReference0Impl(prefManager) { // from class: cz.mobilesoft.coreblock.storage.sharedprefs.PrefManager$wasMIUI11PermissionScreenShown$2
            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
            public Object get() {
                PreferencesHolder preferencesHolder = PrefManager.f126848f;
                if (preferencesHolder != null) {
                    return preferencesHolder;
                }
                Intrinsics.throwUninitializedPropertyAccessException("settingsMultiProcessPrefs");
                return null;
            }
        }, "PROP_WAS_MIUI_11_PERMISSION_SCREEN_SHOWN", false, null, null, 28, null);
        f126888z = new BooleanPref(new MutablePropertyReference0Impl(prefManager) { // from class: cz.mobilesoft.coreblock.storage.sharedprefs.PrefManager$showPaymentOneTimeDisclaimer$2
            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
            public Object get() {
                PreferencesHolder preferencesHolder = PrefManager.f126845d;
                if (preferencesHolder != null) {
                    return preferencesHolder;
                }
                Intrinsics.throwUninitializedPropertyAccessException("settingsPrefs");
                return null;
            }
        }, "PROP_SHOW_PAYMENT_ONE_TIME_DISCLAIMER", false, new Function0() { // from class: cz.mobilesoft.coreblock.storage.sharedprefs.j0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(PrefManager.c3());
            }
        }, null, 20, null);
        A = new StringPref(new MutablePropertyReference0Impl(prefManager) { // from class: cz.mobilesoft.coreblock.storage.sharedprefs.PrefManager$redirectAddress$2
            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
            public Object get() {
                PreferencesHolder preferencesHolder = PrefManager.f126848f;
                if (preferencesHolder != null) {
                    return preferencesHolder;
                }
                Intrinsics.throwUninitializedPropertyAccessException("settingsMultiProcessPrefs");
                return null;
            }
        }, "PROP_REDIRECT_ADDRESS", false, new Function0() { // from class: cz.mobilesoft.coreblock.storage.sharedprefs.l0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return PrefManager.O1();
            }
        }, null, 20, null);
        B = new IntPref(new MutablePropertyReference0Impl(prefManager) { // from class: cz.mobilesoft.coreblock.storage.sharedprefs.PrefManager$dayNightMode$2
            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
            public Object get() {
                PreferencesHolder preferencesHolder = PrefManager.f126848f;
                if (preferencesHolder == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(cJfnYMIyomoWf.adOTSM);
                    return null;
                }
                return preferencesHolder;
            }
        }, "pref_day_night_mode", false, new Function0() { // from class: cz.mobilesoft.coreblock.storage.sharedprefs.o
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Integer.valueOf(PrefManager.b0());
            }
        }, new PrefManager$dayNightMode$4(null), 4, null);
        C = LazyKt.b(new Function0() { // from class: cz.mobilesoft.coreblock.storage.sharedprefs.z
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return PrefManager.a0();
            }
        });
        D = new StringPref(new MutablePropertyReference0Impl(prefManager) { // from class: cz.mobilesoft.coreblock.storage.sharedprefs.PrefManager$blockingScreenMessage$2
            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
            public Object get() {
                PreferencesHolder preferencesHolder = PrefManager.f126848f;
                if (preferencesHolder != null) {
                    return preferencesHolder;
                }
                Intrinsics.throwUninitializedPropertyAccessException("settingsMultiProcessPrefs");
                return null;
            }
        }, "pref_blocking_screen_message", false, new Function0() { // from class: cz.mobilesoft.coreblock.storage.sharedprefs.k0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return PrefManager.V();
            }
        }, new PrefManager$blockingScreenMessage$4(null), 4, null);
        E = LazyKt.b(new Function0() { // from class: cz.mobilesoft.coreblock.storage.sharedprefs.m0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return PrefManager.U();
            }
        });
        F = new StringPref(new MutablePropertyReference0Impl(prefManager) { // from class: cz.mobilesoft.coreblock.storage.sharedprefs.PrefManager$firebaseToken$2
            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
            public Object get() {
                PreferencesHolder preferencesHolder = PrefManager.f126845d;
                if (preferencesHolder != null) {
                    return preferencesHolder;
                }
                Intrinsics.throwUninitializedPropertyAccessException("settingsPrefs");
                return null;
            }
        }, "pref_firebase_token", false, null, null, 28, null);
        G = new LongPref(new MutablePropertyReference0Impl(prefManager) { // from class: cz.mobilesoft.coreblock.storage.sharedprefs.PrefManager$lastApplicationAccessSyncTime$2
            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
            public Object get() {
                PreferencesHolder preferencesHolder = PrefManager.f126848f;
                if (preferencesHolder != null) {
                    return preferencesHolder;
                }
                Intrinsics.throwUninitializedPropertyAccessException("settingsMultiProcessPrefs");
                return null;
            }
        }, "pref_last_application_access_sync_time", false, null, 12, null);
        H = new BooleanPref(new MutablePropertyReference0Impl(prefManager) { // from class: cz.mobilesoft.coreblock.storage.sharedprefs.PrefManager$isStatisticsAccessibilitySkipped$2
            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
            public Object get() {
                PreferencesHolder preferencesHolder = PrefManager.f126845d;
                if (preferencesHolder != null) {
                    return preferencesHolder;
                }
                Intrinsics.throwUninitializedPropertyAccessException("settingsPrefs");
                return null;
            }
        }, "pref_accessibility_skipped", false, null, null, 28, null);
        I = new BooleanPref(new MutablePropertyReference0Impl(prefManager) { // from class: cz.mobilesoft.coreblock.storage.sharedprefs.PrefManager$isDefaultStatisticsIgnoredAppsSet$2
            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
            public Object get() {
                PreferencesHolder preferencesHolder = PrefManager.f126845d;
                if (preferencesHolder != null) {
                    return preferencesHolder;
                }
                Intrinsics.throwUninitializedPropertyAccessException("settingsPrefs");
                return null;
            }
        }, "pref_were_default_statistics_ignored_apps_set", false, null, null, 28, null);
        J = new StringSetPref(new MutablePropertyReference0Impl(prefManager) { // from class: cz.mobilesoft.coreblock.storage.sharedprefs.PrefManager$defaultStatisticsIgnoredApps$2
            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
            public Object get() {
                PreferencesHolder preferencesHolder = PrefManager.f126845d;
                if (preferencesHolder != null) {
                    return preferencesHolder;
                }
                Intrinsics.throwUninitializedPropertyAccessException("settingsPrefs");
                return null;
            }
        }, "pref_default_statistics_ignored_apps", false, null, 12, null);
        K = new IntPref(new MutablePropertyReference0Impl(prefManager) { // from class: cz.mobilesoft.coreblock.storage.sharedprefs.PrefManager$defaultStatisticsTimeFilterId$2
            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
            public Object get() {
                PreferencesHolder preferencesHolder = PrefManager.f126845d;
                if (preferencesHolder != null) {
                    return preferencesHolder;
                }
                Intrinsics.throwUninitializedPropertyAccessException("settingsPrefs");
                return null;
            }
        }, "pref_default_statistics_time_filter_id", false, new Function0() { // from class: cz.mobilesoft.coreblock.storage.sharedprefs.n0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Integer.valueOf(PrefManager.c0());
            }
        }, null, 20, null);
        L = new IntPref(new MutablePropertyReference0Impl(prefManager) { // from class: cz.mobilesoft.coreblock.storage.sharedprefs.PrefManager$defaultStatisticsUsageTypeFilterId$2
            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
            public Object get() {
                PreferencesHolder preferencesHolder = PrefManager.f126845d;
                if (preferencesHolder != null) {
                    return preferencesHolder;
                }
                Intrinsics.throwUninitializedPropertyAccessException("settingsPrefs");
                return null;
            }
        }, "pref_default_statistics_usage_type_filter_id", false, new Function0() { // from class: cz.mobilesoft.coreblock.storage.sharedprefs.o0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Integer.valueOf(PrefManager.d0());
            }
        }, null, 20, null);
        M = new BooleanPref(new MutablePropertyReference0Impl(prefManager) { // from class: cz.mobilesoft.coreblock.storage.sharedprefs.PrefManager$wasDBv28PackageInstallerFixed$2
            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
            public Object get() {
                PreferencesHolder preferencesHolder = PrefManager.f126845d;
                if (preferencesHolder != null) {
                    return preferencesHolder;
                }
                Intrinsics.throwUninitializedPropertyAccessException("settingsPrefs");
                return null;
            }
        }, "pref_was_db28_package_installer_fixed", false, null, null, 28, null);
        N = new ConvertedIntPref(new MutablePropertyReference0Impl(prefManager) { // from class: cz.mobilesoft.coreblock.storage.sharedprefs.PrefManager$dashboardCardStatisticsAppsWebsFilter$2
            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
            public Object get() {
                PreferencesHolder preferencesHolder = PrefManager.f126848f;
                if (preferencesHolder != null) {
                    return preferencesHolder;
                }
                Intrinsics.throwUninitializedPropertyAccessException("settingsMultiProcessPrefs");
                return null;
            }
        }, StatisticsRecordType.Converter.f97041a, "pref_statistics_dashboard_card_apps_webs_filter", false, new Function0() { // from class: cz.mobilesoft.coreblock.storage.sharedprefs.p0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return PrefManager.X();
            }
        }, null, 40, null);
        O = new ConvertedIntPref(new MutablePropertyReference0Impl(prefManager) { // from class: cz.mobilesoft.coreblock.storage.sharedprefs.PrefManager$dashboardCardStatisticsUsageTypeFilter$2
            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
            public Object get() {
                PreferencesHolder preferencesHolder = PrefManager.f126848f;
                if (preferencesHolder != null) {
                    return preferencesHolder;
                }
                Intrinsics.throwUninitializedPropertyAccessException("settingsMultiProcessPrefs");
                return null;
            }
        }, StatisticsUsageTypeFilter.Converter.f97044a, "pref_statistics_dashboard_card_usage_type_filter", false, new Function0() { // from class: cz.mobilesoft.coreblock.storage.sharedprefs.q0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return PrefManager.Z();
            }
        }, null, 40, null);
        P = new ConvertedIntPref(new MutablePropertyReference0Impl(prefManager) { // from class: cz.mobilesoft.coreblock.storage.sharedprefs.PrefManager$dashboardCardStatisticsTimeFilter$2
            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
            public Object get() {
                PreferencesHolder preferencesHolder = PrefManager.f126848f;
                if (preferencesHolder != null) {
                    return preferencesHolder;
                }
                Intrinsics.throwUninitializedPropertyAccessException("settingsMultiProcessPrefs");
                return null;
            }
        }, StatisticsTimeFilter.Converter.f97042a, "pref_statistics_dashboard_card_time_filter", false, new Function0() { // from class: cz.mobilesoft.coreblock.storage.sharedprefs.r0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return PrefManager.Y();
            }
        }, null, 40, null);
        Q = new BooleanPref(new MutablePropertyReference0Impl(prefManager) { // from class: cz.mobilesoft.coreblock.storage.sharedprefs.PrefManager$statisticsEnabled$2
            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
            public Object get() {
                PreferencesHolder preferencesHolder = PrefManager.f126848f;
                if (preferencesHolder != null) {
                    return preferencesHolder;
                }
                Intrinsics.throwUninitializedPropertyAccessException("settingsMultiProcessPrefs");
                return null;
            }
        }, "pref_statistics_enabled", false, new Function0() { // from class: cz.mobilesoft.coreblock.storage.sharedprefs.e
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(PrefManager.f3());
            }
        }, null, 20, null);
        R = new BooleanPref(new MutablePropertyReference0Impl(prefManager) { // from class: cz.mobilesoft.coreblock.storage.sharedprefs.PrefManager$webStatisticsEnabled$2
            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
            public Object get() {
                PreferencesHolder preferencesHolder = PrefManager.f126848f;
                if (preferencesHolder != null) {
                    return preferencesHolder;
                }
                Intrinsics.throwUninitializedPropertyAccessException("settingsMultiProcessPrefs");
                return null;
            }
        }, "pref_web_statistics_enabled", false, new Function0() { // from class: cz.mobilesoft.coreblock.storage.sharedprefs.g
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(PrefManager.k3());
            }
        }, null, 20, null);
        S = new BooleanPref(new MutablePropertyReference0Impl(prefManager) { // from class: cz.mobilesoft.coreblock.storage.sharedprefs.PrefManager$incognitoStatisticsEnabled$2
            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
            public Object get() {
                PreferencesHolder preferencesHolder = PrefManager.f126848f;
                if (preferencesHolder != null) {
                    return preferencesHolder;
                }
                Intrinsics.throwUninitializedPropertyAccessException("settingsMultiProcessPrefs");
                return null;
            }
        }, "pref_statistics_enabled_in_incognito", false, new Function0() { // from class: cz.mobilesoft.coreblock.storage.sharedprefs.h
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(PrefManager.t1());
            }
        }, null, 20, null);
        T = new BooleanPref(new MutablePropertyReference0Impl(prefManager) { // from class: cz.mobilesoft.coreblock.storage.sharedprefs.PrefManager$appStatisticsEnabled$2
            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
            public Object get() {
                PreferencesHolder preferencesHolder = PrefManager.f126848f;
                if (preferencesHolder != null) {
                    return preferencesHolder;
                }
                Intrinsics.throwUninitializedPropertyAccessException("settingsMultiProcessPrefs");
                return null;
            }
        }, "pref_app_statistics_enabled", false, new Function0() { // from class: cz.mobilesoft.coreblock.storage.sharedprefs.i
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(PrefManager.T());
            }
        }, null, 20, null);
        U = new BooleanPref(new MutablePropertyReference0Impl(prefManager) { // from class: cz.mobilesoft.coreblock.storage.sharedprefs.PrefManager$shouldSendStatisticsEnabledState$2
            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
            public Object get() {
                PreferencesHolder preferencesHolder = PrefManager.f126845d;
                if (preferencesHolder != null) {
                    return preferencesHolder;
                }
                Intrinsics.throwUninitializedPropertyAccessException("settingsPrefs");
                return null;
            }
        }, "pref_send_stats_enabled_state", false, new Function0() { // from class: cz.mobilesoft.coreblock.storage.sharedprefs.j
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(PrefManager.U2());
            }
        }, null, 20, null);
        V = new LongPref(new MutablePropertyReference0Impl(prefManager) { // from class: cz.mobilesoft.coreblock.storage.sharedprefs.PrefManager$lastSubscriptionUpdateTime$2
            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
            public Object get() {
                PreferencesHolder preferencesHolder = PrefManager.f126845d;
                if (preferencesHolder != null) {
                    return preferencesHolder;
                }
                Intrinsics.throwUninitializedPropertyAccessException("settingsPrefs");
                return null;
            }
        }, "pref_last_subscription_update_time", false, null, 12, null);
        W = new BooleanPref(new MutablePropertyReference0Impl(prefManager) { // from class: cz.mobilesoft.coreblock.storage.sharedprefs.PrefManager$wasIncognitoBadgeViewIdsSaved$2
            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
            public Object get() {
                PreferencesHolder preferencesHolder = PrefManager.f126845d;
                if (preferencesHolder != null) {
                    return preferencesHolder;
                }
                Intrinsics.throwUninitializedPropertyAccessException("settingsPrefs");
                return null;
            }
        }, "pref_was_incognito_badge_view_ids_saved", false, null, null, 28, null);
        X = new LongPref(new MutablePropertyReference0Impl(prefManager) { // from class: cz.mobilesoft.coreblock.storage.sharedprefs.PrefManager$strictModeTime$2
            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
            public Object get() {
                PreferencesHolder preferencesHolder = PrefManager.f126845d;
                if (preferencesHolder != null) {
                    return preferencesHolder;
                }
                Intrinsics.throwUninitializedPropertyAccessException("settingsPrefs");
                return null;
            }
        }, "pref_strict_mode_time", false, null, 12, null);
        Y = new StringPref(new MutablePropertyReference0Impl(prefManager) { // from class: cz.mobilesoft.coreblock.storage.sharedprefs.PrefManager$strictModeTimeType$2
            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
            public Object get() {
                PreferencesHolder preferencesHolder = PrefManager.f126845d;
                if (preferencesHolder != null) {
                    return preferencesHolder;
                }
                Intrinsics.throwUninitializedPropertyAccessException("settingsPrefs");
                return null;
            }
        }, "pref_strict_mode_time_type", false, new Function0() { // from class: cz.mobilesoft.coreblock.storage.sharedprefs.k
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return PrefManager.g3();
            }
        }, null, 20, null);
        Z = new StringPref(new MutablePropertyReference0Impl(prefManager) { // from class: cz.mobilesoft.coreblock.storage.sharedprefs.PrefManager$incognitoSupportedBrowsers$2
            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
            public Object get() {
                PreferencesHolder preferencesHolder = PrefManager.f126845d;
                if (preferencesHolder != null) {
                    return preferencesHolder;
                }
                Intrinsics.throwUninitializedPropertyAccessException("settingsPrefs");
                return null;
            }
        }, "pref_incognito_supported_browsers", false, new Function0() { // from class: cz.mobilesoft.coreblock.storage.sharedprefs.l
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return PrefManager.u1();
            }
        }, null, 20, null);
        f126840a0 = new BooleanPref(new MutablePropertyReference0Impl(prefManager) { // from class: cz.mobilesoft.coreblock.storage.sharedprefs.PrefManager$showStrictModeChargerWarningDialog$2
            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
            public Object get() {
                PreferencesHolder preferencesHolder = PrefManager.f126845d;
                if (preferencesHolder != null) {
                    return preferencesHolder;
                }
                Intrinsics.throwUninitializedPropertyAccessException("settingsPrefs");
                return null;
            }
        }, "pref_show_strict_mode_charger_warning_dialog", false, new Function0() { // from class: cz.mobilesoft.coreblock.storage.sharedprefs.m
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(PrefManager.e3());
            }
        }, null, 20, null);
        f126842b0 = new BooleanPref(new MutablePropertyReference0Impl(prefManager) { // from class: cz.mobilesoft.coreblock.storage.sharedprefs.PrefManager$wasStrictModeMIUISecurityAppFixed$2
            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
            public Object get() {
                PreferencesHolder preferencesHolder = PrefManager.f126845d;
                if (preferencesHolder != null) {
                    return preferencesHolder;
                }
                Intrinsics.throwUninitializedPropertyAccessException("settingsPrefs");
                return null;
            }
        }, "pref_was_strict_mode_miui_security_fixed", false, null, null, 28, null);
        f126844c0 = new BooleanPref(new MutablePropertyReference0Impl(prefManager) { // from class: cz.mobilesoft.coreblock.storage.sharedprefs.PrefManager$wasQuickBlockProfileCreated$2
            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
            public Object get() {
                PreferencesHolder preferencesHolder = PrefManager.f126845d;
                if (preferencesHolder != null) {
                    return preferencesHolder;
                }
                Intrinsics.throwUninitializedPropertyAccessException("settingsPrefs");
                return null;
            }
        }, "BASIC_BLOCK_PROFILE_CREATED", false, null, null, 28, null);
        f126846d0 = new BooleanPref(new MutablePropertyReference0Impl(prefManager) { // from class: cz.mobilesoft.coreblock.storage.sharedprefs.PrefManager$wasAddNewlyInstalledAppsUsed$2
            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
            public Object get() {
                PreferencesHolder preferencesHolder = PrefManager.f126845d;
                if (preferencesHolder != null) {
                    return preferencesHolder;
                }
                Intrinsics.throwUninitializedPropertyAccessException("settingsPrefs");
                return null;
            }
        }, "pref_add_newly_installed_apps_used", false, null, null, 28, null);
        f126847e0 = new BooleanPref(new MutablePropertyReference0Impl(prefManager) { // from class: cz.mobilesoft.coreblock.storage.sharedprefs.PrefManager$shouldShowNewlyInstalledAppsInfoDialogOnEnter$2
            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
            public Object get() {
                PreferencesHolder preferencesHolder = PrefManager.f126845d;
                if (preferencesHolder != null) {
                    return preferencesHolder;
                }
                Intrinsics.throwUninitializedPropertyAccessException("settingsPrefs");
                return null;
            }
        }, "pref_pop_up_newly_installed_apps_info_dialog_on_enter", false, new Function0() { // from class: cz.mobilesoft.coreblock.storage.sharedprefs.n
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(PrefManager.V2());
            }
        }, null, 20, null);
        f126849f0 = new IntPref(new MutablePropertyReference0Impl(prefManager) { // from class: cz.mobilesoft.coreblock.storage.sharedprefs.PrefManager$quickBlockLastSetTime$2
            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
            public Object get() {
                PreferencesHolder preferencesHolder = PrefManager.f126845d;
                if (preferencesHolder != null) {
                    return preferencesHolder;
                }
                Intrinsics.throwUninitializedPropertyAccessException("settingsPrefs");
                return null;
            }
        }, "pref_quick_block_last_set_time", false, null, null, 28, null);
        f126851g0 = new BooleanPref(new MutablePropertyReference0Impl(prefManager) { // from class: cz.mobilesoft.coreblock.storage.sharedprefs.PrefManager$shouldShowQuickBlockTileCard$2
            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
            public Object get() {
                PreferencesHolder preferencesHolder = PrefManager.f126845d;
                if (preferencesHolder != null) {
                    return preferencesHolder;
                }
                Intrinsics.throwUninitializedPropertyAccessException("settingsPrefs");
                return null;
            }
        }, "pref_show_quick_block_tile_card", false, new Function0() { // from class: cz.mobilesoft.coreblock.storage.sharedprefs.p
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(PrefManager.W2());
            }
        }, null, 20, null);
        f126853h0 = new BooleanPref(new MutablePropertyReference0Impl(prefManager) { // from class: cz.mobilesoft.coreblock.storage.sharedprefs.PrefManager$wasStrictModeProfileCreated$2
            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
            public Object get() {
                PreferencesHolder preferencesHolder = PrefManager.f126845d;
                if (preferencesHolder != null) {
                    return preferencesHolder;
                }
                Intrinsics.throwUninitializedPropertyAccessException("settingsPrefs");
                return null;
            }
        }, "STRICT_MODE_PROFILE_CREATED_V2", false, null, null, 28, null);
        f126855i0 = new IntPref(new MutablePropertyReference0Impl(prefManager) { // from class: cz.mobilesoft.coreblock.storage.sharedprefs.PrefManager$premiumButtonColor$2
            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
            public Object get() {
                PreferencesHolder preferencesHolder = PrefManager.f126845d;
                if (preferencesHolder != null) {
                    return preferencesHolder;
                }
                Intrinsics.throwUninitializedPropertyAccessException("settingsPrefs");
                return null;
            }
        }, "pref_premium_button_color", false, new Function0() { // from class: cz.mobilesoft.coreblock.storage.sharedprefs.q
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Integer.valueOf(PrefManager.M1());
            }
        }, null, 20, null);
        f126857j0 = new StringPref(new MutablePropertyReference0Impl(prefManager) { // from class: cz.mobilesoft.coreblock.storage.sharedprefs.PrefManager$premiumScreenButtonText$2
            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
            public Object get() {
                PreferencesHolder preferencesHolder = PrefManager.f126845d;
                if (preferencesHolder != null) {
                    return preferencesHolder;
                }
                Intrinsics.throwUninitializedPropertyAccessException("settingsPrefs");
                return null;
            }
        }, "pref_premium_screen_button_text", false, null, null, 28, null);
        f126859k0 = new StringPref(new MutablePropertyReference0Impl(prefManager) { // from class: cz.mobilesoft.coreblock.storage.sharedprefs.PrefManager$premiumScreenButtonTextTrial$2
            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
            public Object get() {
                PreferencesHolder preferencesHolder = PrefManager.f126845d;
                if (preferencesHolder != null) {
                    return preferencesHolder;
                }
                Intrinsics.throwUninitializedPropertyAccessException("settingsPrefs");
                return null;
            }
        }, "pref_premium_screen_button_text_trial", false, null, null, 28, null);
        f126861l0 = new StringPref(new MutablePropertyReference0Impl(prefManager) { // from class: cz.mobilesoft.coreblock.storage.sharedprefs.PrefManager$premiumDiscountButtonText$2
            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
            public Object get() {
                PreferencesHolder preferencesHolder = PrefManager.f126845d;
                if (preferencesHolder != null) {
                    return preferencesHolder;
                }
                Intrinsics.throwUninitializedPropertyAccessException("settingsPrefs");
                return null;
            }
        }, "pref_premium_discount_button_text", false, null, null, 28, null);
        f126863m0 = new StringPref(new MutablePropertyReference0Impl(prefManager) { // from class: cz.mobilesoft.coreblock.storage.sharedprefs.PrefManager$premiumHintButtonText$2
            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
            public Object get() {
                PreferencesHolder preferencesHolder = PrefManager.f126845d;
                if (preferencesHolder != null) {
                    return preferencesHolder;
                }
                Intrinsics.throwUninitializedPropertyAccessException("settingsPrefs");
                return null;
            }
        }, "pref_premium_hint_button_text", false, null, null, 28, null);
        f126865n0 = new StringPref(new MutablePropertyReference0Impl(prefManager) { // from class: cz.mobilesoft.coreblock.storage.sharedprefs.PrefManager$limitScreenType$2
            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
            public Object get() {
                PreferencesHolder preferencesHolder = PrefManager.f126845d;
                if (preferencesHolder != null) {
                    return preferencesHolder;
                }
                Intrinsics.throwUninitializedPropertyAccessException("settingsPrefs");
                return null;
            }
        }, "pref_limit_screen_type", false, null, null, 28, null);
        f126867o0 = new BooleanPref(new MutablePropertyReference0Impl(prefManager) { // from class: cz.mobilesoft.coreblock.storage.sharedprefs.PrefManager$isDashboardAutomaticSortingEnabled$2
            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
            public Object get() {
                PreferencesHolder preferencesHolder = PrefManager.f126845d;
                if (preferencesHolder != null) {
                    return preferencesHolder;
                }
                Intrinsics.throwUninitializedPropertyAccessException("settingsPrefs");
                return null;
            }
        }, "pref_dashboard_cards_automatic_sorting_enabled", false, null, null, 28, null);
        f126869p0 = new LongPref(new MutablePropertyReference0Impl(prefManager) { // from class: cz.mobilesoft.coreblock.storage.sharedprefs.PrefManager$dashboardCardPreferredBlocking$2
            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
            public Object get() {
                PreferencesHolder preferencesHolder = PrefManager.f126845d;
                if (preferencesHolder != null) {
                    return preferencesHolder;
                }
                Intrinsics.throwUninitializedPropertyAccessException("settingsPrefs");
                return null;
            }
        }, "pref_dashboard_card_preferred_blocking", false, null, 12, null);
        f126871q0 = new StringPref(new MutablePropertyReference0Impl(prefManager) { // from class: cz.mobilesoft.coreblock.storage.sharedprefs.PrefManager$questionnaireConfigJson$2
            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
            public Object get() {
                PreferencesHolder preferencesHolder = PrefManager.f126845d;
                if (preferencesHolder != null) {
                    return preferencesHolder;
                }
                Intrinsics.throwUninitializedPropertyAccessException("settingsPrefs");
                return null;
            }
        }, "pref_questionnaire_config", false, null, null, 28, null);
        f126873r0 = new IntPref(new MutablePropertyReference0Impl(prefManager) { // from class: cz.mobilesoft.coreblock.storage.sharedprefs.PrefManager$lastQuestionnaireId$2
            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
            public Object get() {
                PreferencesHolder preferencesHolder = PrefManager.f126845d;
                if (preferencesHolder != null) {
                    return preferencesHolder;
                }
                Intrinsics.throwUninitializedPropertyAccessException("settingsPrefs");
                return null;
            }
        }, "pref_last_questionnaire_id", false, new Function0() { // from class: cz.mobilesoft.coreblock.storage.sharedprefs.s
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Integer.valueOf(PrefManager.K1());
            }
        }, null, 20, null);
        f126875s0 = new LongPref(new MutablePropertyReference0Impl(prefManager) { // from class: cz.mobilesoft.coreblock.storage.sharedprefs.PrefManager$earliestDiscountShowHours$2
            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
            public Object get() {
                PreferencesHolder preferencesHolder = PrefManager.f126848f;
                if (preferencesHolder != null) {
                    return preferencesHolder;
                }
                Intrinsics.throwUninitializedPropertyAccessException("settingsMultiProcessPrefs");
                return null;
            }
        }, "pref_earliest_discount_hours", false, new Function0() { // from class: cz.mobilesoft.coreblock.storage.sharedprefs.t
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Long.valueOf(PrefManager.e0());
            }
        }, 4, null);
        f126877t0 = new LongPref(new MutablePropertyReference0Impl(prefManager) { // from class: cz.mobilesoft.coreblock.storage.sharedprefs.PrefManager$adsShowAfterHours$2
            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
            public Object get() {
                PreferencesHolder preferencesHolder = PrefManager.f126848f;
                if (preferencesHolder != null) {
                    return preferencesHolder;
                }
                Intrinsics.throwUninitializedPropertyAccessException("settingsMultiProcessPrefs");
                return null;
            }
        }, "pref_ads_show_after_hours", false, new Function0() { // from class: cz.mobilesoft.coreblock.storage.sharedprefs.u
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Long.valueOf(PrefManager.S());
            }
        }, 4, null);
        f126879u0 = new LongPref(new MutablePropertyReference0Impl(prefManager) { // from class: cz.mobilesoft.coreblock.storage.sharedprefs.PrefManager$interstitialShowAfterHours$2
            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
            public Object get() {
                PreferencesHolder preferencesHolder = PrefManager.f126848f;
                if (preferencesHolder != null) {
                    return preferencesHolder;
                }
                Intrinsics.throwUninitializedPropertyAccessException("settingsMultiProcessPrefs");
                return null;
            }
        }, "pref_interstitial_show_after_hours", false, new Function0() { // from class: cz.mobilesoft.coreblock.storage.sharedprefs.v
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Long.valueOf(PrefManager.B1());
            }
        }, 4, null);
        f126881v0 = new BooleanPref(new MutablePropertyReference0Impl(prefManager) { // from class: cz.mobilesoft.coreblock.storage.sharedprefs.PrefManager$showAcademyClosingLessonDialog$2
            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
            public Object get() {
                PreferencesHolder preferencesHolder = PrefManager.f126845d;
                if (preferencesHolder != null) {
                    return preferencesHolder;
                }
                Intrinsics.throwUninitializedPropertyAccessException("settingsPrefs");
                return null;
            }
        }, "pref_academy_show_closing_lesson_dialog", false, new Function0() { // from class: cz.mobilesoft.coreblock.storage.sharedprefs.w
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(PrefManager.X2());
            }
        }, null, 20, null);
        f126883w0 = new BooleanPref(new MutablePropertyReference0Impl(prefManager) { // from class: cz.mobilesoft.coreblock.storage.sharedprefs.PrefManager$hasUserSeenAcademy$2
            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
            public Object get() {
                PreferencesHolder preferencesHolder = PrefManager.f126845d;
                if (preferencesHolder != null) {
                    return preferencesHolder;
                }
                Intrinsics.throwUninitializedPropertyAccessException("settingsPrefs");
                return null;
            }
        }, "pref_academy_was_seen", false, null, null, 28, null);
        f126885x0 = new BooleanPref(new MutablePropertyReference0Impl(prefManager) { // from class: cz.mobilesoft.coreblock.storage.sharedprefs.PrefManager$isAcademyEnabled$2
            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
            public Object get() {
                PreferencesHolder preferencesHolder = PrefManager.f126845d;
                if (preferencesHolder != null) {
                    return preferencesHolder;
                }
                Intrinsics.throwUninitializedPropertyAccessException("settingsPrefs");
                return null;
            }
        }, "pref_academy_enabled", false, null, null, 28, null);
        f126887y0 = new IntPref(new MutablePropertyReference0Impl(prefManager) { // from class: cz.mobilesoft.coreblock.storage.sharedprefs.PrefManager$academyFreeLessons$2
            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
            public Object get() {
                PreferencesHolder preferencesHolder = PrefManager.f126845d;
                if (preferencesHolder != null) {
                    return preferencesHolder;
                }
                Intrinsics.throwUninitializedPropertyAccessException("settingsPrefs");
                return null;
            }
        }, "pref_academy_free_lessons", false, new Function0() { // from class: cz.mobilesoft.coreblock.storage.sharedprefs.x
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Integer.valueOf(PrefManager.P());
            }
        }, null, 20, null);
        f126889z0 = new StringPref(new MutablePropertyReference0Impl(prefManager) { // from class: cz.mobilesoft.coreblock.storage.sharedprefs.PrefManager$privacyPolicyUrl$2
            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
            public Object get() {
                PreferencesHolder preferencesHolder = PrefManager.f126845d;
                if (preferencesHolder != null) {
                    return preferencesHolder;
                }
                Intrinsics.throwUninitializedPropertyAccessException("settingsPrefs");
                return null;
            }
        }, "pref_privacy_policy_url", false, new Function0() { // from class: cz.mobilesoft.coreblock.storage.sharedprefs.y
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return PrefManager.N1();
            }
        }, null, 20, null);
        A0 = new StringPref(new MutablePropertyReference0Impl(prefManager) { // from class: cz.mobilesoft.coreblock.storage.sharedprefs.PrefManager$conditionsOfUseUrl$2
            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
            public Object get() {
                PreferencesHolder preferencesHolder = PrefManager.f126845d;
                if (preferencesHolder != null) {
                    return preferencesHolder;
                }
                Intrinsics.throwUninitializedPropertyAccessException("settingsPrefs");
                return null;
            }
        }, "pref_conditions_of_use_url", false, new Function0() { // from class: cz.mobilesoft.coreblock.storage.sharedprefs.a0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return PrefManager.W();
            }
        }, null, 20, null);
        B0 = new BooleanPref(new MutablePropertyReference0Impl(prefManager) { // from class: cz.mobilesoft.coreblock.storage.sharedprefs.PrefManager$wasAccessibilityDisclaimerAccepted$2
            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
            public Object get() {
                PreferencesHolder preferencesHolder = PrefManager.f126845d;
                if (preferencesHolder != null) {
                    return preferencesHolder;
                }
                Intrinsics.throwUninitializedPropertyAccessException("settingsPrefs");
                return null;
            }
        }, "pref_was_accessibility_disclaimer_shown", false, null, null, 28, null);
        C0 = new BooleanPref(new MutablePropertyReference0Impl(prefManager) { // from class: cz.mobilesoft.coreblock.storage.sharedprefs.PrefManager$wasQuickBlockConfigCollected$2
            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
            public Object get() {
                PreferencesHolder preferencesHolder = PrefManager.f126845d;
                if (preferencesHolder != null) {
                    return preferencesHolder;
                }
                Intrinsics.throwUninitializedPropertyAccessException("settingsPrefs");
                return null;
            }
        }, "pref_was_quick_block_config_collected", false, null, null, 28, null);
        D0 = new BooleanPref(new MutablePropertyReference0Impl(prefManager) { // from class: cz.mobilesoft.coreblock.storage.sharedprefs.PrefManager$wasQuickBlockSetupFinished$2
            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
            public Object get() {
                PreferencesHolder preferencesHolder = PrefManager.f126845d;
                if (preferencesHolder != null) {
                    return preferencesHolder;
                }
                Intrinsics.throwUninitializedPropertyAccessException("settingsPrefs");
                return null;
            }
        }, "pref_was_quick_block_setup_finished", false, null, null, 28, null);
        E0 = new BooleanPref(new MutablePropertyReference0Impl(prefManager) { // from class: cz.mobilesoft.coreblock.storage.sharedprefs.PrefManager$isDashboardCardAutomaticSortingReset$2
            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
            public Object get() {
                PreferencesHolder preferencesHolder = PrefManager.f126845d;
                if (preferencesHolder != null) {
                    return preferencesHolder;
                }
                Intrinsics.throwUninitializedPropertyAccessException("settingsPrefs");
                return null;
            }
        }, "pref_is_dashboard_card_automatic_sorting_reset", false, null, null, 28, null);
        F0 = new BooleanPref(new MutablePropertyReference0Impl(prefManager) { // from class: cz.mobilesoft.coreblock.storage.sharedprefs.PrefManager$was2022Q2InfoCollected$2
            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
            public Object get() {
                PreferencesHolder preferencesHolder = PrefManager.f126845d;
                if (preferencesHolder != null) {
                    return preferencesHolder;
                }
                Intrinsics.throwUninitializedPropertyAccessException("settingsPrefs");
                return null;
            }
        }, "pref_was_2022_Q2_info_collected", false, null, null, 28, null);
        G0 = new BooleanPref(new MutablePropertyReference0Impl(prefManager) { // from class: cz.mobilesoft.coreblock.storage.sharedprefs.PrefManager$isAccessibilityServicePollingEnabled$2
            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
            public Object get() {
                PreferencesHolder preferencesHolder = PrefManager.f126845d;
                if (preferencesHolder != null) {
                    return preferencesHolder;
                }
                Intrinsics.throwUninitializedPropertyAccessException("settingsPrefs");
                return null;
            }
        }, "pref_accessibility_service_polling_enabled", false, null, null, 28, null);
        H0 = new StringSetPref(new MutablePropertyReference0Impl(prefManager) { // from class: cz.mobilesoft.coreblock.storage.sharedprefs.PrefManager$forcedHiddenPackageNames$2
            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
            public Object get() {
                PreferencesHolder preferencesHolder = PrefManager.f126845d;
                if (preferencesHolder != null) {
                    return preferencesHolder;
                }
                Intrinsics.throwUninitializedPropertyAccessException("settingsPrefs");
                return null;
            }
        }, "pref_forced_hidden_package_names", false, new Function0() { // from class: cz.mobilesoft.coreblock.storage.sharedprefs.b0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return PrefManager.f0();
            }
        }, 4, null);
        I0 = new BooleanPref(new MutablePropertyReference0Impl(prefManager) { // from class: cz.mobilesoft.coreblock.storage.sharedprefs.PrefManager$wasExpiredSubscriptionOfferScheduledAfterUpdate$2
            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
            public Object get() {
                PreferencesHolder preferencesHolder = PrefManager.f126845d;
                if (preferencesHolder != null) {
                    return preferencesHolder;
                }
                Intrinsics.throwUninitializedPropertyAccessException("settingsPrefs");
                return null;
            }
        }, "pref_was_subscription_expired_offer_scheduled_after_update", false, null, null, 28, null);
        J0 = new BooleanPref(new MutablePropertyReference0Impl(prefManager) { // from class: cz.mobilesoft.coreblock.storage.sharedprefs.PrefManager$showSubscriptionExpiredNotifications$2
            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
            public Object get() {
                PreferencesHolder preferencesHolder = PrefManager.f126845d;
                if (preferencesHolder != null) {
                    return preferencesHolder;
                }
                Intrinsics.throwUninitializedPropertyAccessException("settingsPrefs");
                return null;
            }
        }, "pref_show_subscription_expired_notifications", false, null, null, 28, null);
        K0 = new IntPref(new MutablePropertyReference0Impl(prefManager) { // from class: cz.mobilesoft.coreblock.storage.sharedprefs.PrefManager$subscriptionExpiredScreenId$2
            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
            public Object get() {
                PreferencesHolder preferencesHolder = PrefManager.f126845d;
                if (preferencesHolder != null) {
                    return preferencesHolder;
                }
                Intrinsics.throwUninitializedPropertyAccessException("settingsPrefs");
                return null;
            }
        }, "pref_subscription_expired_screen_id", false, new Function0() { // from class: cz.mobilesoft.coreblock.storage.sharedprefs.c0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Integer.valueOf(PrefManager.h3());
            }
        }, null, 20, null);
        L0 = new BooleanPref(new MutablePropertyReference0Impl(prefManager) { // from class: cz.mobilesoft.coreblock.storage.sharedprefs.PrefManager$showAllStrictModeLevels$2
            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
            public Object get() {
                PreferencesHolder preferencesHolder = PrefManager.f126845d;
                if (preferencesHolder != null) {
                    return preferencesHolder;
                }
                Intrinsics.throwUninitializedPropertyAccessException("settingsPrefs");
                return null;
            }
        }, "pref_show_all_strict_mode_levels", false, new Function0() { // from class: cz.mobilesoft.coreblock.storage.sharedprefs.e0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(PrefManager.Y2());
            }
        }, null, 20, null);
        M0 = 8;
    }

    private PrefManager() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int A1() {
        return 10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long B1() {
        return 24L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long J1() {
        return System.currentTimeMillis();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int K1() {
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean L1() {
        return f126839a.h0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int M1() {
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String N1() {
        return BuildConfig.f95356a.booleanValue() ? "https://appblock.app/privacy-policy-app-gallery" : "https://appblock.app/privacy-policy-google-play";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String O1() {
        return "http://appblock.app";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int P() {
        return 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long S() {
        return 24L;
    }

    private final QuestionnaireConfig S0() throws Exception {
        String strT0 = T0();
        if (strT0 == null) {
            return null;
        }
        try {
            return (QuestionnaireConfig) new Gson().j(strT0, QuestionnaireConfig.class);
        } catch (Exception e3) {
            e3.printStackTrace();
            if (BuildConfig.f95357b.booleanValue()) {
                throw e3;
            }
            CrashHelper.j(e3);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean T() {
        return !f126839a.l0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MutableStateFlow U() {
        return StateFlowKt.a(f126839a.q0());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean U2() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String V() {
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean V2() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String W() {
        return "https://appblock.app/conditions-of-use";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean W2() {
        return !f126839a.q1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StatisticsRecordType X() {
        return StatisticsRecordType.ALL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean X2() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StatisticsTimeFilter Y() {
        return StatisticsTimeFilter.WEEK;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean Y2() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StatisticsUsageTypeFilter Z() {
        return StatisticsUsageTypeFilter.USAGE_TIME;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean Z2() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MutableStateFlow a0() {
        return StateFlowKt.a(Integer.valueOf(f126839a.w0()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean a3() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int b0() {
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean b3() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int c0() {
        return StatisticsTimeFilter.WEEK.getFilterId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean c3() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int d0() {
        return StatisticsUsageTypeFilter.USAGE_TIME.getFilterId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean d3() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long e0() {
        return 24L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean e3() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Set f0() {
        return Constants.f128449g;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean f3() {
        return !f126839a.m0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String g3() {
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int h3() {
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String i3() {
        return "support@appblock.app";
    }

    private final void j3(boolean z2) {
        if (V0() == QuickBlockTileService.MonetizationState.UNKNOWN) {
            u2(z2 ? QuickBlockTileService.MonetizationState.MONETIZED : QuickBlockTileService.MonetizationState.FREE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean k3() {
        return !f126839a.o0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean t1() {
        return !f126839a.n0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String u1() {
        return "Chrome, Edge, Brave, Ecosia, Puffin";
    }

    public final int A0() {
        return L.i(this, f126841b[26]).intValue();
    }

    public final void A2(boolean z2) {
        PreferencesHolder preferencesHolder = f126845d;
        if (preferencesHolder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("settingsPrefs");
            preferencesHolder = null;
        }
        preferencesHolder.g("pref_show_accessibility_stopped_dialog", z2).apply();
    }

    public final DevDataStore B0() {
        return (DevDataStore) f126850g.getValue();
    }

    public final void B2(boolean z2) {
        PreferencesHolder preferencesHolder = f126845d;
        if (preferencesHolder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("settingsPrefs");
            preferencesHolder = null;
        }
        preferencesHolder.g("NOT_SHOW_AUTO_LOCK_DISCLAIMER_DIALOG", !z2).apply();
    }

    public final long C0() {
        PreferencesHolder preferencesHolder = f126848f;
        PreferencesHolder preferencesHolder2 = null;
        if (preferencesHolder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("settingsMultiProcessPrefs");
            preferencesHolder = null;
        }
        long jD = preferencesHolder.d("pref_first_init_time", -1L);
        if (jD != -1) {
            return jD;
        }
        PreferencesHolder preferencesHolder3 = f126845d;
        if (preferencesHolder3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("settingsPrefs");
        } else {
            preferencesHolder2 = preferencesHolder3;
        }
        Context contextB = preferencesHolder2.b();
        TimeHelperExt timeHelperExt = TimeHelperExt.f128663a;
        Intrinsics.checkNotNull(contextB);
        Long lE = timeHelperExt.e(contextB);
        if (lE != null) {
            return lE.longValue();
        }
        return 0L;
    }

    public final boolean C1() {
        return G0.i(this, f126841b[73]).booleanValue();
    }

    public final void C2(boolean z2) {
        PreferencesHolder preferencesHolder = f126845d;
        if (preferencesHolder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("settingsPrefs");
            preferencesHolder = null;
        }
        preferencesHolder.g("NOT_SHOW_AUTO_LOCK_NEW_PROFILE_DISCLAIMER_DIALOG", !z2).apply();
    }

    public final Set D0() {
        return H0.g(this, f126841b[74]);
    }

    public final boolean D1() {
        return I.i(this, f126841b[23]).booleanValue();
    }

    public final void D2(boolean z2) {
        f126860l.j(this, f126841b[2], z2);
    }

    public final int E0() {
        return f126882w.i(this, f126841b[13]).intValue();
    }

    public final boolean E1() {
        PreferencesHolder preferencesHolder = f126845d;
        if (preferencesHolder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("settingsPrefs");
            preferencesHolder = null;
        }
        return preferencesHolder.a("PROP_FIRST_INIT", false);
    }

    public final void E2(boolean z2) {
        f126858k.j(this, f126841b[1], z2);
    }

    public final long F0() {
        Boolean boolIsActive;
        PreferencesHolder preferencesHolder = null;
        if (BuildConfig.f95357b.booleanValue() && (boolIsActive = ((DevPrefState) new BlockingFlowProperty(B0().S0()).b()).isActive()) != null) {
            if (!boolIsActive.booleanValue()) {
                boolIsActive = null;
            }
            if (boolIsActive != null) {
                return 0L;
            }
        }
        PreferencesHolder preferencesHolder2 = f126845d;
        if (preferencesHolder2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("settingsPrefs");
        } else {
            preferencesHolder = preferencesHolder2;
        }
        return preferencesHolder.d("pref_interstitial_ad_timeout", BaseRemoteConfig.f127780a);
    }

    public final Boolean F1() {
        PreferencesHolder preferencesHolder = f126843c;
        if (preferencesHolder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("defaultPrefs");
            preferencesHolder = null;
        }
        int iC = preferencesHolder.c("IABTCF_gdprApplies", -1);
        if (iC == 0) {
            return Boolean.FALSE;
        }
        if (iC != 1) {
            return null;
        }
        return Boolean.TRUE;
    }

    public final void F2(boolean z2) {
        PreferencesHolder preferencesHolder = f126845d;
        if (preferencesHolder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("settingsPrefs");
            preferencesHolder = null;
        }
        preferencesHolder.g("PROP_SHOW_LOCK_SERVICE_RESTARTED_DIALOG", z2).apply();
    }

    public final long G0() {
        return f126879u0.i(this, f126841b[61]).longValue();
    }

    public final boolean G1() {
        PreferencesHolder preferencesHolder = f126843c;
        if (preferencesHolder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("defaultPrefs");
            preferencesHolder = null;
        }
        return preferencesHolder.a("pref_hide_system_notification_for_background_apps", false);
    }

    public final void G2(boolean z2) {
        PreferencesHolder preferencesHolder = f126845d;
        if (preferencesHolder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("settingsPrefs");
            preferencesHolder = null;
        }
        preferencesHolder.g("pref_showRationale_access_fine_location", z2).commit();
    }

    public final Set H0(int i3) {
        StringCompanionObject stringCompanionObject = StringCompanionObject.f140150a;
        String str = String.format(Locale.getDefault(), "pref_intro_question_%d_answers", Arrays.copyOf(new Object[]{Integer.valueOf(i3)}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        PreferencesHolder preferencesHolder = f126845d;
        if (preferencesHolder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("settingsPrefs");
            preferencesHolder = null;
        }
        String strE = preferencesHolder.e(str, null);
        if (strE != null) {
            try {
                List listV0 = StringsKt.V0(strE, new String[]{","}, false, 0, 6, null);
                if (listV0 != null) {
                    String[] strArr = (String[]) listV0.toArray(new String[0]);
                    if (strArr != null) {
                        LinkedHashSet linkedHashSet = new LinkedHashSet();
                        for (String str2 : strArr) {
                            linkedHashSet.add(Integer.valueOf(str2));
                        }
                        return linkedHashSet;
                    }
                }
            } catch (Exception unused) {
                return SetsKt.emptySet();
            }
        }
        return SetsKt.emptySet();
    }

    public final boolean H1() {
        return f126854i;
    }

    public final void H2(boolean z2) {
        J0.j(this, f126841b[76], z2);
    }

    public final long I0() {
        return f126884x.i(this, f126841b[14]).longValue();
    }

    public final boolean I1() {
        return V0() == QuickBlockTileService.MonetizationState.MONETIZED;
    }

    public final void I2(boolean z2) {
        PreferencesHolder preferencesHolder = f126845d;
        if (preferencesHolder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("settingsPrefs");
            preferencesHolder = null;
        }
        preferencesHolder.g("PROP_NOT_SHOW_WIFI_DISCLAIMER_DIALOG", z2).apply();
    }

    public final int J0() {
        return f126873r0.i(this, f126841b[58]).intValue();
    }

    public final void J2(int i3) {
        K0.j(this, f126841b[77], i3);
    }

    public final int K0() {
        PreferencesHolder preferencesHolder = f126848f;
        if (preferencesHolder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("settingsMultiProcessPrefs");
            preferencesHolder = null;
        }
        return preferencesHolder.c("PROP_LAUNCH_NUMBER_COUNTER", 0);
    }

    public final void K2(String str) {
        f126876t.h(this, f126841b[10], str);
    }

    public final int L0() {
        return f126855i0.i(this, f126841b[49]).intValue();
    }

    public final void L2(boolean z2) {
        F0.j(this, f126841b[72], z2);
    }

    public final String M0() {
        return f126861l0.g(this, f126841b[52]);
    }

    public final void M2(boolean z2) {
        B0.j(this, f126841b[68], z2);
    }

    public final String N0() {
        return f126863m0.g(this, f126841b[53]);
    }

    public final void N2(boolean z2) {
        f126880v.j(this, f126841b[12], z2);
    }

    public final String O0() {
        return f126857j0.g(this, f126841b[50]);
    }

    public final void O2(boolean z2) {
        W.j(this, f126841b[37], z2);
    }

    public final String P0() {
        return f126859k0.g(this, f126841b[51]);
    }

    public final void P1() {
        PreferencesHolder preferencesHolder = f126848f;
        if (preferencesHolder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("settingsMultiProcessPrefs");
            preferencesHolder = null;
        }
        preferencesHolder.h("PROP_INTERSTITIAL_AD_FREQUENCY", 10).apply();
    }

    public final void P2(boolean z2) {
        f126886y.j(this, f126841b[15], z2);
    }

    public final String Q0() {
        return f126889z0.g(this, f126841b[66]);
    }

    public final void Q1() {
        i2(BaseRemoteConfig.f127780a);
    }

    public final void Q2(boolean z2) {
        PreferencesHolder preferencesHolder = f126845d;
        if (preferencesHolder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("settingsPrefs");
            preferencesHolder = null;
        }
        preferencesHolder.g("PROP_WELCOME_SCREEN_SHOWN_WEBSITES", z2).apply();
    }

    public final int R0() {
        PreferencesHolder preferencesHolder = f126845d;
        if (preferencesHolder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("settingsPrefs");
            preferencesHolder = null;
        }
        return preferencesHolder.c("pref_qb_non_tile_start_count", 0);
    }

    public final void R1() {
        PreferencesHolder preferencesHolder = f126845d;
        if (preferencesHolder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("settingsPrefs");
            preferencesHolder = null;
        }
        preferencesHolder.j("PROP_REDIRECT_ADDRESS", "http://appblock.app").apply();
    }

    public final void R2(boolean z2) {
        f126870q.j(this, f126841b[7], z2);
    }

    public final void S1(int i3) {
        f126887y0.j(this, f126841b[65], i3);
    }

    public final void S2(boolean z2) {
        int i3 = z2 ? 245 : 0;
        PreferencesHolder preferencesHolder = f126845d;
        if (preferencesHolder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("settingsPrefs");
            preferencesHolder = null;
        }
        preferencesHolder.h("pref_whats_new_dashboard_card_hidden_version", i3).apply();
    }

    public final String T0() {
        return f126871q0.g(this, f126841b[57]);
    }

    public final void T1(boolean z2) {
        G0.j(this, f126841b[73], z2);
    }

    public final void T2(boolean z2) {
        int i3 = z2 ? -1 : 0;
        PreferencesHolder preferencesHolder = f126845d;
        if (preferencesHolder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("settingsPrefs");
            preferencesHolder = null;
        }
        preferencesHolder.h("pref_whats_new_dashboard_card_hidden_version", i3).apply();
    }

    public final int U0() {
        return f126849f0.i(this, f126841b[46]).intValue();
    }

    public final void U1() {
        PreferencesHolder preferencesHolder = f126845d;
        if (preferencesHolder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("settingsPrefs");
            preferencesHolder = null;
        }
        preferencesHolder.i("pref_accessibility_stopped_dialog_shown_time", System.currentTimeMillis()).apply();
    }

    public final QuickBlockTileService.MonetizationState V0() {
        QuickBlockTileService.MonetizationState.Companion companion = QuickBlockTileService.MonetizationState.Companion;
        PreferencesHolder preferencesHolder = f126845d;
        if (preferencesHolder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("settingsPrefs");
            preferencesHolder = null;
        }
        return companion.a(preferencesHolder.c("pref_qb_tile_monetization", QuickBlockTileService.MonetizationState.UNKNOWN.getId()));
    }

    public final void V1(String str) {
        f126874s.h(this, f126841b[9], str);
    }

    public final String W0() {
        return A.g(this, f126841b[17]);
    }

    public final void W1(long j3) {
        PreferencesHolder preferencesHolder = f126845d;
        if (preferencesHolder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("settingsPrefs");
            preferencesHolder = null;
        }
        preferencesHolder.i("pref_ad_lifetime", j3).apply();
        AdsUtils.f127678i.h(j3 * 1000);
    }

    public final boolean X0() {
        Boolean boolIsActive;
        if (((Boolean) new BlockingFlowProperty(u0().c2()).b()).booleanValue()) {
            return (!BuildConfig.f95357b.booleanValue() || (boolIsActive = ((DevPrefState) new BlockingFlowProperty(B0().S0()).b()).isActive()) == null) ? TimeHelperExt.c() - TimeUnit.HOURS.toMillis(k0()) > C0() : boolIsActive.booleanValue();
        }
        return false;
    }

    public final void X1(long j3) {
        f126877t0.j(this, f126841b[60], j3);
    }

    public final boolean Y0() {
        Boolean boolIsActive;
        if (!((Boolean) new BlockingFlowProperty(u0().c2()).b()).booleanValue()) {
            return false;
        }
        if (BuildConfig.f95357b.booleanValue() && (boolIsActive = ((DevPrefState) new BlockingFlowProperty(B0().S0()).b()).isActive()) != null) {
            return boolIsActive.booleanValue();
        }
        long jC = TimeHelperExt.c();
        TimeUnit timeUnit = TimeUnit.HOURS;
        return jC - timeUnit.toMillis(G0()) > C0() && jC - timeUnit.toMillis(k0()) > C0();
    }

    public final void Y1(String str) {
        D.h(this, f126841b[19], str);
    }

    public final boolean Z0() {
        return f126851g0.i(this, f126841b[47]).booleanValue();
    }

    public final void Z1(StatisticsUsageTypeFilter statisticsUsageTypeFilter) {
        Intrinsics.checkNotNullParameter(statisticsUsageTypeFilter, "<set-?>");
        O.f(this, f126841b[29], statisticsUsageTypeFilter);
    }

    public final boolean a1() {
        return f126881v0.i(this, f126841b[62]).booleanValue();
    }

    public final void a2(int i3) {
        B.j(this, f126841b[18], i3);
    }

    public final boolean b1() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        PreferencesHolder preferencesHolder = f126845d;
        PreferencesHolder preferencesHolder2 = null;
        if (preferencesHolder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("settingsPrefs");
            preferencesHolder = null;
        }
        if (jCurrentTimeMillis - preferencesHolder.d("pref_accessibility_stopped_dialog_shown_time", 0L) <= Constants.f128445c) {
            return false;
        }
        PreferencesHolder preferencesHolder3 = f126845d;
        if (preferencesHolder3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("settingsPrefs");
        } else {
            preferencesHolder2 = preferencesHolder3;
        }
        return preferencesHolder2.a("pref_show_accessibility_stopped_dialog", true);
    }

    public final void b2(boolean z2) {
        I.j(this, f126841b[23], z2);
    }

    public final boolean c1() {
        PreferencesHolder preferencesHolder = f126845d;
        if (preferencesHolder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("settingsPrefs");
            preferencesHolder = null;
        }
        return !preferencesHolder.a("NOT_SHOW_AUTO_LOCK_DISCLAIMER_DIALOG", false);
    }

    public final void c2(int i3) {
        K.j(this, f126841b[25], i3);
    }

    public final boolean d1() {
        PreferencesHolder preferencesHolder = f126845d;
        if (preferencesHolder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("settingsPrefs");
            preferencesHolder = null;
        }
        return !preferencesHolder.a("NOT_SHOW_AUTO_LOCK_NEW_PROFILE_DISCLAIMER_DIALOG", false);
    }

    public final void d2(int i3) {
        L.j(this, f126841b[26], i3);
    }

    public final boolean e1() {
        return f126860l.i(this, f126841b[2]).booleanValue();
    }

    public final void e2(boolean z2) {
        PreferencesHolder preferencesHolder = f126845d;
        PreferencesHolder preferencesHolder2 = null;
        if (preferencesHolder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("settingsPrefs");
            preferencesHolder = null;
        }
        preferencesHolder.g("PROP_FIRST_INIT", z2).commit();
        if (z2) {
            PreferencesHolder preferencesHolder3 = f126848f;
            if (preferencesHolder3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("settingsMultiProcessPrefs");
            } else {
                preferencesHolder2 = preferencesHolder3;
            }
            preferencesHolder2.i("pref_first_init_time", System.currentTimeMillis()).apply();
        }
    }

    public final boolean f1() {
        return f126858k.i(this, f126841b[1]).booleanValue();
    }

    public final void f2(Set set) {
        H0.h(this, f126841b[74], set);
    }

    public final int g0() {
        return f126887y0.i(this, f126841b[65]).intValue();
    }

    public final boolean g1() {
        PreferencesHolder preferencesHolder = f126845d;
        if (preferencesHolder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("settingsPrefs");
            preferencesHolder = null;
        }
        return preferencesHolder.a("PROP_SHOW_LOCK_SERVICE_RESTARTED_DIALOG", true);
    }

    public final void g2(boolean z2) {
        f126883w0.j(this, f126841b[63], z2);
    }

    public final boolean h0() {
        return f126862m.i(this, f126841b[3]).booleanValue();
    }

    public final boolean h1() {
        PreferencesHolder preferencesHolder = f126845d;
        if (preferencesHolder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("settingsPrefs");
            preferencesHolder = null;
        }
        return preferencesHolder.a("pref_showRationale_access_fine_location", true);
    }

    public final void h2(int i3) {
        f126882w.j(this, f126841b[13], i3);
    }

    public final List i0() {
        PreferencesHolder preferencesHolder = f126845d;
        if (preferencesHolder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("settingsPrefs");
            preferencesHolder = null;
        }
        String strE = preferencesHolder.e("pref_mobilesoft_ads_countries", "");
        if (strE == null || strE.length() == 0) {
            return CollectionsKt.emptyList();
        }
        String[] strArr = (String[]) StringsKt.V0(strE, new String[]{","}, false, 0, 6, null).toArray(new String[0]);
        return CollectionsKt.listOf(Arrays.copyOf(strArr, strArr.length));
    }

    public final boolean i1() {
        return J0.i(this, f126841b[76]).booleanValue();
    }

    public final void i2(long j3) {
        PreferencesHolder preferencesHolder = f126845d;
        if (preferencesHolder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("settingsPrefs");
            preferencesHolder = null;
        }
        preferencesHolder.i("pref_interstitial_ad_timeout", j3).apply();
        InterstitialUtils.f127880h.q(F0() * 1000);
    }

    public final long j0() {
        PreferencesHolder preferencesHolder = f126845d;
        if (preferencesHolder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("settingsPrefs");
            preferencesHolder = null;
        }
        return preferencesHolder.d("pref_ad_lifetime", 0L);
    }

    public final boolean j1() {
        PreferencesHolder preferencesHolder = f126845d;
        if (preferencesHolder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("settingsPrefs");
            preferencesHolder = null;
        }
        return preferencesHolder.a("PROP_NOT_SHOW_WIFI_DISCLAIMER_DIALOG", true);
    }

    public final void j2(long j3) {
        f126879u0.j(this, f126841b[61], j3);
    }

    public final long k0() {
        return f126877t0.i(this, f126841b[60]).longValue();
    }

    public final String k1() {
        return f126876t.g(this, f126841b[10]);
    }

    public final void k2(long j3) {
        f126884x.j(this, f126841b[14], j3);
    }

    public final boolean l0() {
        PreferencesHolder preferencesHolder = f126845d;
        if (preferencesHolder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("settingsPrefs");
            preferencesHolder = null;
        }
        return preferencesHolder.a("pref_app_statistics_disable", false);
    }

    public final boolean l1() {
        return F0.i(this, f126841b[72]).booleanValue();
    }

    public final void l2(int i3) {
        f126873r0.j(this, f126841b[58], i3);
    }

    public final boolean m0() {
        PreferencesHolder preferencesHolder = f126848f;
        if (preferencesHolder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("settingsMultiProcessPrefs");
            preferencesHolder = null;
        }
        return preferencesHolder.a("pref_statistics_disable", false);
    }

    public final boolean m1() {
        return B0.i(this, f126841b[68]).booleanValue();
    }

    public final void m2(int i3) {
        f126855i0.j(this, f126841b[49], i3);
    }

    public final boolean n0() {
        PreferencesHolder preferencesHolder = f126848f;
        if (preferencesHolder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("settingsMultiProcessPrefs");
            preferencesHolder = null;
        }
        return preferencesHolder.a("pref_statistics_disable_in_incognito", true);
    }

    public final boolean n1() {
        return f126880v.i(this, f126841b[12]).booleanValue();
    }

    public final void n2(String str) {
        f126861l0.h(this, f126841b[52], str);
    }

    public final boolean o0() {
        PreferencesHolder preferencesHolder = f126848f;
        if (preferencesHolder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("settingsMultiProcessPrefs");
            preferencesHolder = null;
        }
        return preferencesHolder.a("pref_web_statistics_disable", false);
    }

    public final boolean o1() {
        return W.i(this, f126841b[37]).booleanValue();
    }

    public final void o2(String str) {
        f126863m0.h(this, f126841b[53], str);
    }

    public final int p0() {
        PreferencesHolder preferencesHolder = f126845d;
        if (preferencesHolder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("settingsPrefs");
            preferencesHolder = null;
        }
        return preferencesHolder.c("PROP_BLOCKED_TIMES_COUNT", 0);
    }

    public final boolean p1() {
        return f126886y.i(this, f126841b[15]).booleanValue();
    }

    public final void p2(String str) {
        f126857j0.h(this, f126841b[50], str);
    }

    public final String q0() {
        return D.g(this, f126841b[19]);
    }

    public final boolean q1() {
        return R0() == -1;
    }

    public final void q2(String str) {
        f126859k0.h(this, f126841b[51], str);
    }

    @Override // org.koin.core.component.KoinComponent
    public /* bridge */ Koin r0() {
        return KoinComponent.DefaultImpls.a(this);
    }

    public final boolean r1() {
        Boolean boolIsActive;
        if (BuildConfig.f95357b.booleanValue() && (boolIsActive = ((DevPrefState) new BlockingFlowProperty(B0().W0()).b()).isActive()) != null) {
            return !boolIsActive.booleanValue();
        }
        PreferencesHolder preferencesHolder = f126845d;
        if (preferencesHolder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("settingsPrefs");
            preferencesHolder = null;
        }
        return preferencesHolder.a("PROP_WELCOME_SCREEN_SHOWN_WEBSITES", false);
    }

    public final void r2(String str) {
        f126871q0.h(this, f126841b[57], str);
    }

    public final MutableSharedFlow s0() {
        return (MutableSharedFlow) E.getValue();
    }

    public final boolean s1() {
        return f126870q.i(this, f126841b[7]).booleanValue();
    }

    public final void s2(int i3) {
        f126849f0.j(this, f126841b[46], i3);
    }

    public final String t0() {
        return A0.g(this, f126841b[67]);
    }

    public final void t2() {
        PreferencesHolder preferencesHolder = f126845d;
        if (preferencesHolder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("settingsPrefs");
            preferencesHolder = null;
        }
        preferencesHolder.h("pref_qb_non_tile_start_count", -1).apply();
        j3(true);
    }

    public final CoreDataStore u0() {
        return (CoreDataStore) f126852h.getValue();
    }

    public final void u2(QuickBlockTileService.MonetizationState value) {
        Intrinsics.checkNotNullParameter(value, "value");
        PreferencesHolder preferencesHolder = f126845d;
        if (preferencesHolder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("settingsPrefs");
            preferencesHolder = null;
        }
        preferencesHolder.h("pref_qb_tile_monetization", value.getId()).apply();
    }

    public final QuestionnaireConfig v0() throws Exception {
        QuestionnaireConfig questionnaireConfigS0 = S0();
        if (questionnaireConfigS0 != null && J0() < questionnaireConfigS0.b()) {
            return questionnaireConfigS0;
        }
        return null;
    }

    public final void v1() {
        PreferencesHolder preferencesHolder = f126845d;
        if (preferencesHolder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("settingsPrefs");
            preferencesHolder = null;
        }
        preferencesHolder.h("PROP_LAUNCH_NUMBER_COUNTER", K0() + 1).apply();
    }

    public final void v2() {
        j3(false);
    }

    public final int w0() {
        return B.i(this, f126841b[18]).intValue();
    }

    public final int w1() {
        int iP0 = p0() + 1;
        PreferencesHolder preferencesHolder = f126845d;
        if (preferencesHolder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("settingsPrefs");
            preferencesHolder = null;
        }
        preferencesHolder.h("PROP_BLOCKED_TIMES_COUNT", iP0).apply();
        return iP0;
    }

    public final void w2(String str) {
        A.h(this, f126841b[17], str);
    }

    public final MutableSharedFlow x0() {
        return (MutableSharedFlow) C.getValue();
    }

    public final void x1() {
        w1();
    }

    public final void x2(boolean z2) {
        f126851g0.j(this, f126841b[47], z2);
    }

    public final Set y0() {
        return J.g(this, f126841b[24]);
    }

    public final void y1() {
        int iR0 = R0();
        if (iR0 != -1) {
            PreferencesHolder preferencesHolder = f126845d;
            if (preferencesHolder == null) {
                Intrinsics.throwUninitializedPropertyAccessException("settingsPrefs");
                preferencesHolder = null;
            }
            preferencesHolder.h("pref_qb_non_tile_start_count", iR0 + 1).apply();
        }
    }

    public final void y2(boolean z2) {
        S2(!z2);
    }

    public final int z0() {
        return K.i(this, f126841b[25]).intValue();
    }

    public final void z1(Context applicationContext) {
        Intrinsics.checkNotNullParameter(applicationContext, "applicationContext");
        f126843c = new PreferencesHolder(PreferenceManager.getDefaultSharedPreferences(applicationContext), applicationContext);
        f126845d = new PreferencesHolder(applicationContext.getSharedPreferences("prop_setting", 0), applicationContext);
        f126848f = new PreferencesHolder(applicationContext.getSharedPreferences("prop_setting", 4), applicationContext);
        f126854i = true;
    }

    public final void z2(boolean z2) {
        f126881v0.j(this, f126841b[62], z2);
    }
}
