package cz.mobilesoft.coreblock.di;

import android.app.Application;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.location.LocationManager;
import androidx.room.Room;
import cz.mobilesoft.coreblock.LockieApplication;
import cz.mobilesoft.coreblock.di.AppModuleKt;
import cz.mobilesoft.coreblock.repository.AccountabilityPartnerRepository;
import cz.mobilesoft.coreblock.repository.DiagnosticRepository;
import cz.mobilesoft.coreblock.repository.PremiumRepositoryV2;
import cz.mobilesoft.coreblock.repository.QuickBlockRepository;
import cz.mobilesoft.coreblock.repository.StreakApiRepository;
import cz.mobilesoft.coreblock.repository.StrictModeRepository;
import cz.mobilesoft.coreblock.repository.SubAppRepository;
import cz.mobilesoft.coreblock.repository.TokenFCMRepository;
import cz.mobilesoft.coreblock.scene.email_consent.ConsentHelper;
import cz.mobilesoft.coreblock.scene.insights.usecase.AppDifferenceUseCase;
import cz.mobilesoft.coreblock.scene.insights.usecase.CreateIntervalsUseCase;
import cz.mobilesoft.coreblock.scene.insights.usecase.DailyStatisticsComparisonUseCase;
import cz.mobilesoft.coreblock.scene.insights.usecase.FetchAggregatedAppDataUseCase;
import cz.mobilesoft.coreblock.scene.insights.usecase.FetchAppDataUseCase;
import cz.mobilesoft.coreblock.scene.insights.usecase.FetchBlockingSessionsUseCase;
import cz.mobilesoft.coreblock.scene.insights.usecase.FetchGraphDataUseCase;
import cz.mobilesoft.coreblock.scene.insights.usecase.FetchTrialSummaryUseCase;
import cz.mobilesoft.coreblock.scene.insights.usecase.LongestContinuousBreakUseCase;
import cz.mobilesoft.coreblock.scene.insights.usecase.LongestContinuousUseUseCase;
import cz.mobilesoft.coreblock.scene.insights.usecase.MigrateStatisticsToInsightsUseCase;
import cz.mobilesoft.coreblock.scene.insights.usecase.WeeklyStatisticsComparisonUseCase;
import cz.mobilesoft.coreblock.scene.more.backup.usecase.GetBackupHistoryUseCase;
import cz.mobilesoft.coreblock.scene.more.backup.usecase.GetBackupProfilesUseCase;
import cz.mobilesoft.coreblock.scene.more.backup.usecase.GetBackupSettingsUseCase;
import cz.mobilesoft.coreblock.scene.more.backup.usecase.GetBackupStatisticsUseCase;
import cz.mobilesoft.coreblock.scene.more.backup.usecase.GetBackupStrictModeUseCase;
import cz.mobilesoft.coreblock.scene.more.backup.usecase.RestoreHistoryUseCase;
import cz.mobilesoft.coreblock.scene.more.backup.usecase.RestoreProfilesUseCase;
import cz.mobilesoft.coreblock.scene.more.backup.usecase.RestoreSettingsUseCase;
import cz.mobilesoft.coreblock.scene.more.backup.usecase.RestoreStatisticsUseCase;
import cz.mobilesoft.coreblock.scene.more.backup.usecase.RestoreStrictModeUseCase;
import cz.mobilesoft.coreblock.scene.more.settings.developer.streaks.StreakDebugHelper;
import cz.mobilesoft.coreblock.scene.permission.permissions.handler.PermissionsHandler;
import cz.mobilesoft.coreblock.scene.premium.trial_upsell.TrialUpsellManager;
import cz.mobilesoft.coreblock.scene.selection.usecase.GetApplicationStateWithSubAppsUseCase;
import cz.mobilesoft.coreblock.scene.streaks.StreakAchievementNotificationPlanner;
import cz.mobilesoft.coreblock.scene.streaks.StreakActivityRepository;
import cz.mobilesoft.coreblock.scene.streaks.StreakActivityTracker;
import cz.mobilesoft.coreblock.scene.streaks.StreakAvailability;
import cz.mobilesoft.coreblock.scene.streaks.StreakDailyPresenter;
import cz.mobilesoft.coreblock.scene.streaks.StreakEvaluator;
import cz.mobilesoft.coreblock.scene.streaks.StreakNudgePlanner;
import cz.mobilesoft.coreblock.scene.streaks.StreakPauseTracker;
import cz.mobilesoft.coreblock.scene.streaks.StreakRepository;
import cz.mobilesoft.coreblock.scene.streaks.StreakSnapshotSync;
import cz.mobilesoft.coreblock.scene.streaks.StreakStore;
import cz.mobilesoft.coreblock.scene.streaks.intro.StreakIntroAvailability;
import cz.mobilesoft.coreblock.scene.strictmode3.approval.ApprovalRepository;
import cz.mobilesoft.coreblock.scene.strictmode3.usecase.ActivateStrictModeUseCase;
import cz.mobilesoft.coreblock.scene.strictmode3.usecase.GetActiveStateUseCase;
import cz.mobilesoft.coreblock.scene.strictmode3.usecase.GetMissingPermissionsUseCase;
import cz.mobilesoft.coreblock.scene.strictmode3.usecase.GetTitleAndSubtitleUseCase;
import cz.mobilesoft.coreblock.scene.strictmode3.usecase.SetTimerValueUseCase;
import cz.mobilesoft.coreblock.scene.strictmode3.usecase.ShouldShowLimitedTimerUseCase;
import cz.mobilesoft.coreblock.scene.strictmode3.usecase.WillBeContinuousUseCase;
import cz.mobilesoft.coreblock.service.passlock.PassCodeManager;
import cz.mobilesoft.coreblock.service.receiver.DexReceiver;
import cz.mobilesoft.coreblock.storage.datastore.CoreDataStore;
import cz.mobilesoft.coreblock.storage.datastore.CoreMultiProcessDataStore;
import cz.mobilesoft.coreblock.storage.datastore.DirectBootDataStore;
import cz.mobilesoft.coreblock.storage.datastore.DiscountDataStore;
import cz.mobilesoft.coreblock.storage.datastore.EventDataStore;
import cz.mobilesoft.coreblock.storage.datastore.InAppUpdatesDataStore;
import cz.mobilesoft.coreblock.storage.datastore.NotificationDataStore;
import cz.mobilesoft.coreblock.storage.datastore.PassCodeDataStore;
import cz.mobilesoft.coreblock.storage.datastore.PaywallDataStore;
import cz.mobilesoft.coreblock.storage.datastore.QuickBlockDataStore;
import cz.mobilesoft.coreblock.storage.datastore.RatingDataStore;
import cz.mobilesoft.coreblock.storage.datastore.SessionDataStore;
import cz.mobilesoft.coreblock.storage.datastore.StatisticsDataStore;
import cz.mobilesoft.coreblock.storage.datastore.StreakDataStore;
import cz.mobilesoft.coreblock.storage.datastore.StrictModeDataStore;
import cz.mobilesoft.coreblock.storage.datastore.TrialConversionDataStore;
import cz.mobilesoft.coreblock.storage.datastore.UserTestingDataStore;
import cz.mobilesoft.coreblock.storage.datastore.dev.DevDataStore;
import cz.mobilesoft.coreblock.storage.greendao.GreendaoDatabase;
import cz.mobilesoft.coreblock.storage.greendao.GreendaoUtils;
import cz.mobilesoft.coreblock.storage.room.dao.PomodoroSessionDao;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.AdultContentWebsiteDao;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.AppWebsiteCategoryDao;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.ApplicationDao;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.ApplicationProfileRelationDao;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.BlockSessionDao;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.BlockedNotificationDao;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.BrowserViewIdDao;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.GeoAddressDao;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.IntervalDao;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.StreakActivitySessionDao;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.StreakDayDao;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.StreakPauseRecordDao;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.SubAppRelationDao;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.UsageLimitDao;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.WebsiteProfileRelationDao;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.WifiNetworkDao;
import cz.mobilesoft.coreblock.storage.room.dao.core.AcademyCourseDao;
import cz.mobilesoft.coreblock.storage.room.dao.core.AcademyLessonDao;
import cz.mobilesoft.coreblock.storage.room.dao.core.AppVersionDao;
import cz.mobilesoft.coreblock.storage.room.dao.core.CustomBlockingScreenConfigDao;
import cz.mobilesoft.coreblock.storage.room.dao.core.EmergencyUnblockingDao;
import cz.mobilesoft.coreblock.storage.room.dao.core.IgnoredStatisticsItemDao;
import cz.mobilesoft.coreblock.storage.room.dao.core.LaunchTimeDao;
import cz.mobilesoft.coreblock.storage.room.dao.core.MoodCheckInEntityDao;
import cz.mobilesoft.coreblock.storage.room.dao.core.PomodoroHistoryDao;
import cz.mobilesoft.coreblock.storage.room.dao.core.PricingPhaseDao;
import cz.mobilesoft.coreblock.storage.room.dao.core.ProductDao;
import cz.mobilesoft.coreblock.storage.room.dao.core.PurchasedOfferDao;
import cz.mobilesoft.coreblock.storage.room.dao.core.QuickBlockTimerHistoryDao;
import cz.mobilesoft.coreblock.storage.room.dao.core.SchedulePauseHistoryDao;
import cz.mobilesoft.coreblock.storage.room.dao.core.SubscriptionOptionDao;
import cz.mobilesoft.coreblock.storage.room.dao.core.TokenFCMDao;
import cz.mobilesoft.coreblock.storage.room.dao.core.UsedBackdoorCodeDao;
import cz.mobilesoft.coreblock.storage.room.management.BlockingDatabase;
import cz.mobilesoft.coreblock.storage.room.management.BlockingMigrationsKt;
import cz.mobilesoft.coreblock.storage.room.management.CoreDatabase;
import cz.mobilesoft.coreblock.storage.room.management.CoreDatabaseCallback;
import cz.mobilesoft.coreblock.storage.room.management.CoreMigrationsKt;
import cz.mobilesoft.coreblock.usecase.AverageStatisticsUseCase;
import cz.mobilesoft.coreblock.usecase.BackdoorCodeUseCase;
import cz.mobilesoft.coreblock.usecase.CalculateYearlySavingsUseCase;
import cz.mobilesoft.coreblock.usecase.CheckAutoTrialEligibilityUseCase;
import cz.mobilesoft.coreblock.usecase.CheckGuestPassEligibilityUseCase;
import cz.mobilesoft.coreblock.usecase.DeterminePremiumStateUseCase;
import cz.mobilesoft.coreblock.usecase.FetchRevenueCatOfferingUseCase;
import cz.mobilesoft.coreblock.usecase.GetForegroundAppsUseCase;
import cz.mobilesoft.coreblock.usecase.GetProfileRuntimeStateUseCase;
import cz.mobilesoft.coreblock.usecase.GetUsageLimitsForCurrentPeriodUseCase;
import cz.mobilesoft.coreblock.usecase.InitApplicationsUseCase;
import cz.mobilesoft.coreblock.usecase.MakeRevenueCatPurchaseUseCase;
import cz.mobilesoft.coreblock.usecase.PickDailyInsightsMotivationMessageUseCase;
import cz.mobilesoft.coreblock.usecase.RestoreRevenueCatPurchaseUseCase;
import cz.mobilesoft.coreblock.usecase.SchedulingConflictUseCase;
import cz.mobilesoft.coreblock.usecase.SendContactSupportDetailedRequestUseCase;
import cz.mobilesoft.coreblock.usecase.StatisticsPermissionsUseCase;
import cz.mobilesoft.coreblock.usecase.SupportJsonParseUseCase;
import cz.mobilesoft.coreblock.usecase.SyncEmailConsentUseCase;
import cz.mobilesoft.coreblock.usecase.TrialConversionGuardUseCase;
import cz.mobilesoft.coreblock.usecase.UpdateIconUseCase;
import cz.mobilesoft.coreblock.usecase.UpdateUserDetailUseCase;
import cz.mobilesoft.coreblock.usecase.UpdateUserPhotoUseCase;
import cz.mobilesoft.coreblock.usecase.accessibility.DetectBrowserUrlUseCase;
import cz.mobilesoft.coreblock.usecase.accessibility.ExtractUrlFromNodeUseCase;
import cz.mobilesoft.coreblock.usecase.accessibility.FindUrlBarNodeUseCase;
import cz.mobilesoft.coreblock.usecase.accessibility.nodefinders.FindComposeNodeByTestTagUseCase;
import cz.mobilesoft.coreblock.usecase.lockservice.GetLockServiceRunReasonsUseCase;
import cz.mobilesoft.coreblock.usecase.timenudge.ApplyTimeNudgeDefaultAppsUseCase;
import cz.mobilesoft.coreblock.usecase.timenudge.EvaluateTimeNudgeUseCase;
import cz.mobilesoft.coreblock.usecase.timenudge.GetTimeNudgeAppsUseCase;
import cz.mobilesoft.coreblock.usecase.timenudge.PickTimeNudgeNotificationMessageUseCase;
import cz.mobilesoft.coreblock.util.DeeplinkRouter;
import cz.mobilesoft.coreblock.util.VideoCompressionManager;
import cz.mobilesoft.coreblock.util.analytics.FacebookLogger;
import cz.mobilesoft.coreblock.util.monetization.PremiumStateChangeReactor;
import cz.mobilesoft.coreblock.util.runnability.JobHelperKtx;
import cz.mobilesoft.coreblock.util.subscription.DiscountRepository;
import cz.mobilesoft.coreblock.util.superwall.SuperwallPurchaseController;
import cz.mobilesoft.coreblock.util.trialconversion.TrialConversionCoordinator;
import cz.mobilesoft.nativecore.NativeLib;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.experimental.kJ.HcgZcEUYo;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.koin.android.ext.koin.ModuleExtKt;
import org.koin.core.definition.BeanDefinition;
import org.koin.core.definition.Kind;
import org.koin.core.definition.KoinDefinition;
import org.koin.core.instance.FactoryInstanceFactory;
import org.koin.core.instance.InstanceFactory;
import org.koin.core.instance.SingleInstanceFactory;
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
public final class AppModuleKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Module f96876a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Module f96877b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Module f96878c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Module f96879d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Module f96880e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Module f96881f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final List f96882g;

    static {
        Module moduleB = ModuleDSLKt.b(false, new Function1() { // from class: q0.a
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return AppModuleKt.T2((Module) obj);
            }
        }, 1, null);
        f96876a = moduleB;
        Module moduleB2 = ModuleDSLKt.b(false, new Function1() { // from class: q0.v1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return AppModuleKt.O3((Module) obj);
            }
        }, 1, null);
        f96877b = moduleB2;
        Module moduleB3 = ModuleDSLKt.b(false, new Function1() { // from class: q0.g2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return AppModuleKt.D2((Module) obj);
            }
        }, 1, null);
        f96878c = moduleB3;
        Module moduleB4 = ModuleDSLKt.b(false, new Function1() { // from class: q0.r2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return AppModuleKt.g2((Module) obj);
            }
        }, 1, null);
        f96879d = moduleB4;
        Module moduleB5 = ModuleDSLKt.b(false, new Function1() { // from class: q0.c3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return AppModuleKt.v3((Module) obj);
            }
        }, 1, null);
        f96880e = moduleB5;
        Module moduleB6 = ModuleDSLKt.b(false, new Function1() { // from class: q0.n3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return AppModuleKt.t3((Module) obj);
            }
        }, 1, null);
        f96881f = moduleB6;
        f96882g = CollectionsKt.listOf((Object[]) new Module[]{moduleB, moduleB3, moduleB4, moduleB6, moduleB5, moduleB2, ViewModelModuleKt.Z0()});
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WebsiteProfileRelationDao A2(Scope single, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it, "it");
        return ((BlockingDatabase) single.e(Reflection.b(BlockingDatabase.class), null, null)).G();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final NotificationDataStore A3(Scope single, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it, "it");
        return new NotificationDataStore((Context) single.e(Reflection.b(Context.class), null, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SchedulingConflictUseCase A4(Scope single, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it, "it");
        return new SchedulingConflictUseCase((ProfileDao) single.e(Reflection.b(ProfileDao.class), null, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final GeoAddressDao B2(Scope single, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it, "it");
        return ((BlockingDatabase) single.e(Reflection.b(BlockingDatabase.class), null, null)).u();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PassCodeDataStore B3(Scope single, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it, "it");
        return new PassCodeDataStore((Context) single.e(Reflection.b(Context.class), null, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WeeklyStatisticsComparisonUseCase B4(Scope single, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it, "it");
        return new WeeklyStatisticsComparisonUseCase();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WifiNetworkDao C2(Scope single, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it, "it");
        return ((BlockingDatabase) single.e(Reflection.b(BlockingDatabase.class), null, null)).H();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DirectBootDataStore C3(Scope single, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it, "it");
        return DirectBootDataStore.f124280d.a((Context) single.e(Reflection.b(Context.class), null, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DailyStatisticsComparisonUseCase C4(Scope single, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it, "it");
        return new DailyStatisticsComparisonUseCase();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit D2(Module module) {
        Intrinsics.checkNotNullParameter(module, "$this$module");
        Function2 function2 = new Function2() { // from class: q0.b0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return AppModuleKt.E2((Scope) obj, (ParametersHolder) obj2);
            }
        };
        ScopeRegistry.Companion companion = ScopeRegistry.f146057e;
        StringQualifier stringQualifierA = companion.a();
        Kind kind = Kind.Singleton;
        SingleInstanceFactory singleInstanceFactory = new SingleInstanceFactory(new BeanDefinition(stringQualifierA, Reflection.b(CoreDatabase.class), null, function2, kind, CollectionsKt.emptyList()));
        module.f(singleInstanceFactory);
        if (module.e()) {
            module.g(singleInstanceFactory);
        }
        new KoinDefinition(module, singleInstanceFactory);
        Function2 function22 = new Function2() { // from class: q0.i0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return AppModuleKt.F2((Scope) obj, (ParametersHolder) obj2);
            }
        };
        SingleInstanceFactory singleInstanceFactory2 = new SingleInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(AcademyCourseDao.class), null, function22, kind, CollectionsKt.emptyList()));
        module.f(singleInstanceFactory2);
        if (module.e()) {
            module.g(singleInstanceFactory2);
        }
        new KoinDefinition(module, singleInstanceFactory2);
        Function2 function23 = new Function2() { // from class: q0.j0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return AppModuleKt.L2((Scope) obj, (ParametersHolder) obj2);
            }
        };
        SingleInstanceFactory singleInstanceFactory3 = new SingleInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(AcademyLessonDao.class), null, function23, kind, CollectionsKt.emptyList()));
        module.f(singleInstanceFactory3);
        if (module.e()) {
            module.g(singleInstanceFactory3);
        }
        new KoinDefinition(module, singleInstanceFactory3);
        Function2 function24 = new Function2() { // from class: q0.k0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return AppModuleKt.M2((Scope) obj, (ParametersHolder) obj2);
            }
        };
        SingleInstanceFactory singleInstanceFactory4 = new SingleInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(TokenFCMDao.class), null, function24, kind, CollectionsKt.emptyList()));
        module.f(singleInstanceFactory4);
        if (module.e()) {
            module.g(singleInstanceFactory4);
        }
        new KoinDefinition(module, singleInstanceFactory4);
        Function2 function25 = new Function2() { // from class: q0.l0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return AppModuleKt.N2((Scope) obj, (ParametersHolder) obj2);
            }
        };
        SingleInstanceFactory singleInstanceFactory5 = new SingleInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(ProductDao.class), null, function25, kind, CollectionsKt.emptyList()));
        module.f(singleInstanceFactory5);
        if (module.e()) {
            module.g(singleInstanceFactory5);
        }
        new KoinDefinition(module, singleInstanceFactory5);
        Function2 function26 = new Function2() { // from class: q0.m0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return AppModuleKt.O2((Scope) obj, (ParametersHolder) obj2);
            }
        };
        SingleInstanceFactory singleInstanceFactory6 = new SingleInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(SubscriptionOptionDao.class), null, function26, kind, CollectionsKt.emptyList()));
        module.f(singleInstanceFactory6);
        if (module.e()) {
            module.g(singleInstanceFactory6);
        }
        new KoinDefinition(module, singleInstanceFactory6);
        Function2 function27 = new Function2() { // from class: q0.n0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return AppModuleKt.P2((Scope) obj, (ParametersHolder) obj2);
            }
        };
        SingleInstanceFactory singleInstanceFactory7 = new SingleInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(PricingPhaseDao.class), null, function27, kind, CollectionsKt.emptyList()));
        module.f(singleInstanceFactory7);
        if (module.e()) {
            module.g(singleInstanceFactory7);
        }
        new KoinDefinition(module, singleInstanceFactory7);
        Function2 function28 = new Function2() { // from class: q0.o0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return AppModuleKt.Q2((Scope) obj, (ParametersHolder) obj2);
            }
        };
        SingleInstanceFactory singleInstanceFactory8 = new SingleInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(UsedBackdoorCodeDao.class), null, function28, kind, CollectionsKt.emptyList()));
        module.f(singleInstanceFactory8);
        if (module.e()) {
            module.g(singleInstanceFactory8);
        }
        new KoinDefinition(module, singleInstanceFactory8);
        Function2 function29 = new Function2() { // from class: q0.p0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return AppModuleKt.R2((Scope) obj, (ParametersHolder) obj2);
            }
        };
        SingleInstanceFactory singleInstanceFactory9 = new SingleInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(AppVersionDao.class), null, function29, kind, CollectionsKt.emptyList()));
        module.f(singleInstanceFactory9);
        if (module.e()) {
            module.g(singleInstanceFactory9);
        }
        new KoinDefinition(module, singleInstanceFactory9);
        Function2 function210 = new Function2() { // from class: q0.q0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return AppModuleKt.S2((Scope) obj, (ParametersHolder) obj2);
            }
        };
        SingleInstanceFactory singleInstanceFactory10 = new SingleInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(PurchasedOfferDao.class), null, function210, kind, CollectionsKt.emptyList()));
        module.f(singleInstanceFactory10);
        if (module.e()) {
            module.g(singleInstanceFactory10);
        }
        new KoinDefinition(module, singleInstanceFactory10);
        Function2 function211 = new Function2() { // from class: q0.c0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return AppModuleKt.G2((Scope) obj, (ParametersHolder) obj2);
            }
        };
        SingleInstanceFactory singleInstanceFactory11 = new SingleInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(LaunchTimeDao.class), null, function211, kind, CollectionsKt.emptyList()));
        module.f(singleInstanceFactory11);
        if (module.e()) {
            module.g(singleInstanceFactory11);
        }
        new KoinDefinition(module, singleInstanceFactory11);
        Function2 function212 = new Function2() { // from class: q0.d0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return AppModuleKt.H2((Scope) obj, (ParametersHolder) obj2);
            }
        };
        SingleInstanceFactory singleInstanceFactory12 = new SingleInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(IgnoredStatisticsItemDao.class), null, function212, kind, CollectionsKt.emptyList()));
        module.f(singleInstanceFactory12);
        if (module.e()) {
            module.g(singleInstanceFactory12);
        }
        new KoinDefinition(module, singleInstanceFactory12);
        Function2 function213 = new Function2() { // from class: q0.e0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return AppModuleKt.I2((Scope) obj, (ParametersHolder) obj2);
            }
        };
        SingleInstanceFactory singleInstanceFactory13 = new SingleInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(EmergencyUnblockingDao.class), null, function213, kind, CollectionsKt.emptyList()));
        module.f(singleInstanceFactory13);
        if (module.e()) {
            module.g(singleInstanceFactory13);
        }
        new KoinDefinition(module, singleInstanceFactory13);
        Function2 function214 = new Function2() { // from class: q0.f0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return AppModuleKt.J2((Scope) obj, (ParametersHolder) obj2);
            }
        };
        SingleInstanceFactory singleInstanceFactory14 = new SingleInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(CustomBlockingScreenConfigDao.class), null, function214, kind, CollectionsKt.emptyList()));
        module.f(singleInstanceFactory14);
        if (module.e()) {
            module.g(singleInstanceFactory14);
        }
        new KoinDefinition(module, singleInstanceFactory14);
        Function2 function215 = new Function2() { // from class: q0.g0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return AppModuleKt.K2((Scope) obj, (ParametersHolder) obj2);
            }
        };
        SingleInstanceFactory singleInstanceFactory15 = new SingleInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(MoodCheckInEntityDao.class), null, function215, kind, CollectionsKt.emptyList()));
        module.f(singleInstanceFactory15);
        if (module.e()) {
            module.g(singleInstanceFactory15);
        }
        new KoinDefinition(module, singleInstanceFactory15);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final EventDataStore D3(Scope single, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it, "it");
        return new EventDataStore((Context) single.e(Reflection.b(Context.class), null, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FetchAggregatedAppDataUseCase D4(Scope single, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it, "it");
        return new FetchAggregatedAppDataUseCase();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CoreDatabase E2(Scope single, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it, "it");
        return (CoreDatabase) Room.a(ModuleExtKt.a(single), CoreDatabase.class, "core.db").e().a(new CoreDatabaseCallback()).b(CoreMigrationsKt.f(), CoreMigrationsKt.g(), CoreMigrationsKt.h(), CoreMigrationsKt.i(), CoreMigrationsKt.j(), CoreMigrationsKt.b(), CoreMigrationsKt.c(), CoreMigrationsKt.d(), CoreMigrationsKt.e()).d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PaywallDataStore E3(Scope single, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it, "it");
        return new PaywallDataStore((Context) single.e(Reflection.b(Context.class), null, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FetchAppDataUseCase E4(Scope single, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it, "it");
        return new FetchAppDataUseCase();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AcademyCourseDao F2(Scope single, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it, "it");
        return ((CoreDatabase) single.e(Reflection.b(CoreDatabase.class), null, null)).n();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TrialConversionDataStore F3(Scope single, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it, "it");
        return new TrialConversionDataStore((Context) single.e(Reflection.b(Context.class), null, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LongestContinuousUseUseCase F4(Scope single, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it, "it");
        return new LongestContinuousUseUseCase();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LaunchTimeDao G2(Scope single, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it, "it");
        return ((CoreDatabase) single.e(Reflection.b(CoreDatabase.class), null, null)).t();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StreakDataStore G3(Scope single, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it, "it");
        return new StreakDataStore((Context) single.e(Reflection.b(Context.class), null, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LongestContinuousBreakUseCase G4(Scope single, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it, "it");
        return new LongestContinuousBreakUseCase();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IgnoredStatisticsItemDao H2(Scope single, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it, "it");
        return ((CoreDatabase) single.e(Reflection.b(CoreDatabase.class), null, null)).s();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StrictModeDataStore H3(Scope single, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it, "it");
        return new StrictModeDataStore((Context) single.e(Reflection.b(Context.class), null, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AppDifferenceUseCase H4(Scope single, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it, "it");
        return new AppDifferenceUseCase();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final EmergencyUnblockingDao I2(Scope single, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it, "it");
        return ((CoreDatabase) single.e(Reflection.b(CoreDatabase.class), null, null)).r();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final RatingDataStore I3(Scope single, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it, "it");
        return new RatingDataStore((Context) single.e(Reflection.b(Context.class), null, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final UpdateUserPhotoUseCase I4(Scope single, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it, "it");
        return new UpdateUserPhotoUseCase((Context) single.e(Reflection.b(Context.class), null, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CustomBlockingScreenConfigDao J2(Scope single, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it, "it");
        return ((CoreDatabase) single.e(Reflection.b(CoreDatabase.class), null, null)).q();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final QuickBlockDataStore J3(Scope single, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it, "it");
        return new QuickBlockDataStore((Context) single.e(Reflection.b(Context.class), null, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ActivateStrictModeUseCase J4(Scope single, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it, "it");
        return new ActivateStrictModeUseCase();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MoodCheckInEntityDao K2(Scope single, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it, "it");
        return ((CoreDatabase) single.e(Reflection.b(CoreDatabase.class), null, null)).u();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SessionDataStore K3(Scope single, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it, "it");
        return new SessionDataStore((Context) single.e(Reflection.b(Context.class), null, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final GetTitleAndSubtitleUseCase K4(Scope single, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it, "it");
        return new GetTitleAndSubtitleUseCase();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AcademyLessonDao L2(Scope single, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it, "it");
        return ((CoreDatabase) single.e(Reflection.b(CoreDatabase.class), null, null)).o();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StatisticsDataStore L3(Scope single, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it, "it");
        return new StatisticsDataStore((Context) single.e(Reflection.b(Context.class), null, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SetTimerValueUseCase L4(Scope single, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it, "it");
        return new SetTimerValueUseCase();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TokenFCMDao M2(Scope single, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it, "it");
        return ((CoreDatabase) single.e(Reflection.b(CoreDatabase.class), null, null)).z();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DevDataStore M3(Scope single, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it, "it");
        return new DevDataStore((Context) single.e(Reflection.b(Context.class), null, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final GetActiveStateUseCase M4(Scope single, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it, "it");
        return new GetActiveStateUseCase();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ProductDao N2(Scope single, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it, "it");
        return ((CoreDatabase) single.e(Reflection.b(CoreDatabase.class), null, null)).w();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final UserTestingDataStore N3(Scope single, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it, "it");
        return new UserTestingDataStore((Context) single.e(Reflection.b(Context.class), null, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ShouldShowLimitedTimerUseCase N4(Scope single, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it, "it");
        return new ShouldShowLimitedTimerUseCase();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SubscriptionOptionDao O2(Scope single, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it, "it");
        return ((CoreDatabase) single.e(Reflection.b(CoreDatabase.class), null, null)).y();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit O3(Module module) {
        Intrinsics.checkNotNullParameter(module, "$this$module");
        Function2 function2 = new Function2() { // from class: q0.y3
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return AppModuleKt.P3((Scope) obj, (ParametersHolder) obj2);
            }
        };
        ScopeRegistry.Companion companion = ScopeRegistry.f146057e;
        StringQualifier stringQualifierA = companion.a();
        Kind kind = Kind.Singleton;
        SingleInstanceFactory singleInstanceFactory = new SingleInstanceFactory(new BeanDefinition(stringQualifierA, Reflection.b(InitApplicationsUseCase.class), null, function2, kind, CollectionsKt.emptyList()));
        module.f(singleInstanceFactory);
        if (module.e()) {
            module.g(singleInstanceFactory);
        }
        new KoinDefinition(module, singleInstanceFactory);
        Function2 function22 = new Function2() { // from class: q0.s1
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return AppModuleKt.Q3((Scope) obj, (ParametersHolder) obj2);
            }
        };
        SingleInstanceFactory singleInstanceFactory2 = new SingleInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(PickDailyInsightsMotivationMessageUseCase.class), null, function22, kind, CollectionsKt.emptyList()));
        module.f(singleInstanceFactory2);
        if (module.e()) {
            module.g(singleInstanceFactory2);
        }
        new KoinDefinition(module, singleInstanceFactory2);
        Function2 function23 = new Function2() { // from class: q0.e2
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return AppModuleKt.b4((Scope) obj, (ParametersHolder) obj2);
            }
        };
        SingleInstanceFactory singleInstanceFactory3 = new SingleInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(SendContactSupportDetailedRequestUseCase.class), null, function23, kind, CollectionsKt.emptyList()));
        module.f(singleInstanceFactory3);
        if (module.e()) {
            module.g(singleInstanceFactory3);
        }
        new KoinDefinition(module, singleInstanceFactory3);
        Function2 function24 = new Function2() { // from class: q0.q2
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return AppModuleKt.m4((Scope) obj, (ParametersHolder) obj2);
            }
        };
        SingleInstanceFactory singleInstanceFactory4 = new SingleInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(StatisticsPermissionsUseCase.class), null, function24, kind, CollectionsKt.emptyList()));
        module.f(singleInstanceFactory4);
        if (module.e()) {
            module.g(singleInstanceFactory4);
        }
        new KoinDefinition(module, singleInstanceFactory4);
        Function2 function25 = new Function2() { // from class: q0.d3
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return AppModuleKt.x4((Scope) obj, (ParametersHolder) obj2);
            }
        };
        SingleInstanceFactory singleInstanceFactory5 = new SingleInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(SupportJsonParseUseCase.class), null, function25, kind, CollectionsKt.emptyList()));
        module.f(singleInstanceFactory5);
        if (module.e()) {
            module.g(singleInstanceFactory5);
        }
        new KoinDefinition(module, singleInstanceFactory5);
        Function2 function26 = new Function2() { // from class: q0.p3
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return AppModuleKt.I4((Scope) obj, (ParametersHolder) obj2);
            }
        };
        SingleInstanceFactory singleInstanceFactory6 = new SingleInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(UpdateUserPhotoUseCase.class), null, function26, kind, CollectionsKt.emptyList()));
        module.f(singleInstanceFactory6);
        if (module.e()) {
            module.g(singleInstanceFactory6);
        }
        new KoinDefinition(module, singleInstanceFactory6);
        Function2 function27 = new Function2() { // from class: q0.b4
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return AppModuleKt.T4((Scope) obj, (ParametersHolder) obj2);
            }
        };
        SingleInstanceFactory singleInstanceFactory7 = new SingleInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(UpdateIconUseCase.class), null, function27, kind, CollectionsKt.emptyList()));
        module.f(singleInstanceFactory7);
        if (module.e()) {
            module.g(singleInstanceFactory7);
        }
        new KoinDefinition(module, singleInstanceFactory7);
        Function2 function28 = new Function2() { // from class: q0.i4
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return AppModuleKt.e5((Scope) obj, (ParametersHolder) obj2);
            }
        };
        SingleInstanceFactory singleInstanceFactory8 = new SingleInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(RestoreProfilesUseCase.class), null, function28, kind, CollectionsKt.emptyList()));
        module.f(singleInstanceFactory8);
        if (module.e()) {
            module.g(singleInstanceFactory8);
        }
        new KoinDefinition(module, singleInstanceFactory8);
        Function2 function29 = new Function2() { // from class: q0.k4
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return AppModuleKt.l5((Scope) obj, (ParametersHolder) obj2);
            }
        };
        SingleInstanceFactory singleInstanceFactory9 = new SingleInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(RestoreRevenueCatPurchaseUseCase.class), null, function29, kind, CollectionsKt.emptyList()));
        module.f(singleInstanceFactory9);
        if (module.e()) {
            module.g(singleInstanceFactory9);
        }
        new KoinDefinition(module, singleInstanceFactory9);
        Function2 function210 = new Function2() { // from class: q0.l4
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return AppModuleKt.m5((Scope) obj, (ParametersHolder) obj2);
            }
        };
        SingleInstanceFactory singleInstanceFactory10 = new SingleInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(GetTimeNudgeAppsUseCase.class), null, function210, kind, CollectionsKt.emptyList()));
        module.f(singleInstanceFactory10);
        if (module.e()) {
            module.g(singleInstanceFactory10);
        }
        new KoinDefinition(module, singleInstanceFactory10);
        Function2 function211 = new Function2() { // from class: q0.j4
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return AppModuleKt.R3((Scope) obj, (ParametersHolder) obj2);
            }
        };
        SingleInstanceFactory singleInstanceFactory11 = new SingleInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(PickTimeNudgeNotificationMessageUseCase.class), null, function211, kind, CollectionsKt.emptyList()));
        module.f(singleInstanceFactory11);
        if (module.e()) {
            module.g(singleInstanceFactory11);
        }
        new KoinDefinition(module, singleInstanceFactory11);
        Function2 function212 = new Function2() { // from class: q0.u4
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return AppModuleKt.S3((Scope) obj, (ParametersHolder) obj2);
            }
        };
        SingleInstanceFactory singleInstanceFactory12 = new SingleInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(ApplyTimeNudgeDefaultAppsUseCase.class), null, function212, kind, CollectionsKt.emptyList()));
        module.f(singleInstanceFactory12);
        if (module.e()) {
            module.g(singleInstanceFactory12);
        }
        new KoinDefinition(module, singleInstanceFactory12);
        Function2 function213 = new Function2() { // from class: q0.f5
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return AppModuleKt.T3((Scope) obj, (ParametersHolder) obj2);
            }
        };
        SingleInstanceFactory singleInstanceFactory13 = new SingleInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(EvaluateTimeNudgeUseCase.class), null, function213, kind, CollectionsKt.emptyList()));
        module.f(singleInstanceFactory13);
        if (module.e()) {
            module.g(singleInstanceFactory13);
        }
        new KoinDefinition(module, singleInstanceFactory13);
        Function2 function214 = new Function2() { // from class: q0.l
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return AppModuleKt.U3((Scope) obj, (ParametersHolder) obj2);
            }
        };
        SingleInstanceFactory singleInstanceFactory14 = new SingleInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(AverageStatisticsUseCase.class), null, function214, kind, CollectionsKt.emptyList()));
        module.f(singleInstanceFactory14);
        if (module.e()) {
            module.g(singleInstanceFactory14);
        }
        new KoinDefinition(module, singleInstanceFactory14);
        Function2 function215 = new Function2() { // from class: q0.w
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return AppModuleKt.V3((Scope) obj, (ParametersHolder) obj2);
            }
        };
        SingleInstanceFactory singleInstanceFactory15 = new SingleInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(BackdoorCodeUseCase.class), null, function215, kind, CollectionsKt.emptyList()));
        module.f(singleInstanceFactory15);
        if (module.e()) {
            module.g(singleInstanceFactory15);
        }
        new KoinDefinition(module, singleInstanceFactory15);
        Function2 function216 = new Function2() { // from class: q0.h0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return AppModuleKt.W3((Scope) obj, (ParametersHolder) obj2);
            }
        };
        SingleInstanceFactory singleInstanceFactory16 = new SingleInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(FetchRevenueCatOfferingUseCase.class), null, function216, kind, CollectionsKt.emptyList()));
        module.f(singleInstanceFactory16);
        if (module.e()) {
            module.g(singleInstanceFactory16);
        }
        new KoinDefinition(module, singleInstanceFactory16);
        Function2 function217 = new Function2() { // from class: q0.s0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return AppModuleKt.X3((Scope) obj, (ParametersHolder) obj2);
            }
        };
        SingleInstanceFactory singleInstanceFactory17 = new SingleInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(MakeRevenueCatPurchaseUseCase.class), null, function217, kind, CollectionsKt.emptyList()));
        module.f(singleInstanceFactory17);
        if (module.e()) {
            module.g(singleInstanceFactory17);
        }
        new KoinDefinition(module, singleInstanceFactory17);
        Function2 function218 = new Function2() { // from class: q0.d1
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return AppModuleKt.Y3((Scope) obj, (ParametersHolder) obj2);
            }
        };
        SingleInstanceFactory singleInstanceFactory18 = new SingleInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(UpdateUserDetailUseCase.class), null, function218, kind, CollectionsKt.emptyList()));
        module.f(singleInstanceFactory18);
        if (module.e()) {
            module.g(singleInstanceFactory18);
        }
        new KoinDefinition(module, singleInstanceFactory18);
        Function2 function219 = new Function2() { // from class: q0.o1
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return AppModuleKt.Z3((Scope) obj, (ParametersHolder) obj2);
            }
        };
        SingleInstanceFactory singleInstanceFactory19 = new SingleInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(SyncEmailConsentUseCase.class), null, function219, kind, CollectionsKt.emptyList()));
        module.f(singleInstanceFactory19);
        if (module.e()) {
            module.g(singleInstanceFactory19);
        }
        new KoinDefinition(module, singleInstanceFactory19);
        Function2 function220 = new Function2() { // from class: q0.r1
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return AppModuleKt.a4((Scope) obj, (ParametersHolder) obj2);
            }
        };
        SingleInstanceFactory singleInstanceFactory20 = new SingleInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(GetUsageLimitsForCurrentPeriodUseCase.class), null, function220, kind, CollectionsKt.emptyList()));
        module.f(singleInstanceFactory20);
        if (module.e()) {
            module.g(singleInstanceFactory20);
        }
        new KoinDefinition(module, singleInstanceFactory20);
        Function2 function221 = new Function2() { // from class: q0.t1
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return AppModuleKt.c4((Scope) obj, (ParametersHolder) obj2);
            }
        };
        SingleInstanceFactory singleInstanceFactory21 = new SingleInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(CheckGuestPassEligibilityUseCase.class), null, function221, kind, CollectionsKt.emptyList()));
        module.f(singleInstanceFactory21);
        if (module.e()) {
            module.g(singleInstanceFactory21);
        }
        new KoinDefinition(module, singleInstanceFactory21);
        Function2 function222 = new Function2() { // from class: q0.u1
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return AppModuleKt.d4((Scope) obj, (ParametersHolder) obj2);
            }
        };
        SingleInstanceFactory singleInstanceFactory22 = new SingleInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(CheckAutoTrialEligibilityUseCase.class), null, function222, kind, CollectionsKt.emptyList()));
        module.f(singleInstanceFactory22);
        if (module.e()) {
            module.g(singleInstanceFactory22);
        }
        new KoinDefinition(module, singleInstanceFactory22);
        Function2 function223 = new Function2() { // from class: q0.w1
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return AppModuleKt.e4((Scope) obj, (ParametersHolder) obj2);
            }
        };
        SingleInstanceFactory singleInstanceFactory23 = new SingleInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(GetProfileRuntimeStateUseCase.class), null, function223, kind, CollectionsKt.emptyList()));
        module.f(singleInstanceFactory23);
        if (module.e()) {
            module.g(singleInstanceFactory23);
        }
        new KoinDefinition(module, singleInstanceFactory23);
        Function2 function224 = new Function2() { // from class: q0.x1
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return AppModuleKt.f4((Scope) obj, (ParametersHolder) obj2);
            }
        };
        SingleInstanceFactory singleInstanceFactory24 = new SingleInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(GetLockServiceRunReasonsUseCase.class), null, function224, kind, CollectionsKt.emptyList()));
        module.f(singleInstanceFactory24);
        if (module.e()) {
            module.g(singleInstanceFactory24);
        }
        new KoinDefinition(module, singleInstanceFactory24);
        Function2 function225 = new Function2() { // from class: q0.y1
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return AppModuleKt.g4((Scope) obj, (ParametersHolder) obj2);
            }
        };
        StringQualifier stringQualifierA2 = companion.a();
        Kind kind2 = Kind.Factory;
        InstanceFactory factoryInstanceFactory = new FactoryInstanceFactory(new BeanDefinition(stringQualifierA2, Reflection.b(CalculateYearlySavingsUseCase.class), null, function225, kind2, CollectionsKt.emptyList()));
        module.f(factoryInstanceFactory);
        new KoinDefinition(module, factoryInstanceFactory);
        Function2 function226 = new Function2() { // from class: q0.z1
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return AppModuleKt.h4((Scope) obj, (ParametersHolder) obj2);
            }
        };
        SingleInstanceFactory singleInstanceFactory25 = new SingleInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(DeterminePremiumStateUseCase.class), null, function226, kind, CollectionsKt.emptyList()));
        module.f(singleInstanceFactory25);
        if (module.e()) {
            module.g(singleInstanceFactory25);
        }
        new KoinDefinition(module, singleInstanceFactory25);
        Function2 function227 = new Function2() { // from class: q0.a2
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return AppModuleKt.i4((Scope) obj, (ParametersHolder) obj2);
            }
        };
        InstanceFactory factoryInstanceFactory2 = new FactoryInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(TrialConversionGuardUseCase.class), null, function227, kind2, CollectionsKt.emptyList()));
        module.f(factoryInstanceFactory2);
        new KoinDefinition(module, factoryInstanceFactory2);
        Function2 function228 = new Function2() { // from class: q0.b2
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return AppModuleKt.j4((Scope) obj, (ParametersHolder) obj2);
            }
        };
        SingleInstanceFactory singleInstanceFactory26 = new SingleInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(GetBackupSettingsUseCase.class), null, function228, kind, CollectionsKt.emptyList()));
        module.f(singleInstanceFactory26);
        if (module.e()) {
            module.g(singleInstanceFactory26);
        }
        new KoinDefinition(module, singleInstanceFactory26);
        Function2 function229 = new Function2() { // from class: q0.c2
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return AppModuleKt.k4((Scope) obj, (ParametersHolder) obj2);
            }
        };
        SingleInstanceFactory singleInstanceFactory27 = new SingleInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(GetBackupProfilesUseCase.class), null, function229, kind, CollectionsKt.emptyList()));
        module.f(singleInstanceFactory27);
        if (module.e()) {
            module.g(singleInstanceFactory27);
        }
        new KoinDefinition(module, singleInstanceFactory27);
        Function2 function230 = new Function2() { // from class: q0.d2
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return AppModuleKt.l4((Scope) obj, (ParametersHolder) obj2);
            }
        };
        SingleInstanceFactory singleInstanceFactory28 = new SingleInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(GetBackupStrictModeUseCase.class), null, function230, kind, CollectionsKt.emptyList()));
        module.f(singleInstanceFactory28);
        if (module.e()) {
            module.g(singleInstanceFactory28);
        }
        new KoinDefinition(module, singleInstanceFactory28);
        Function2 function231 = new Function2() { // from class: q0.f2
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return AppModuleKt.n4((Scope) obj, (ParametersHolder) obj2);
            }
        };
        SingleInstanceFactory singleInstanceFactory29 = new SingleInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(GetBackupStatisticsUseCase.class), null, function231, kind, CollectionsKt.emptyList()));
        module.f(singleInstanceFactory29);
        if (module.e()) {
            module.g(singleInstanceFactory29);
        }
        new KoinDefinition(module, singleInstanceFactory29);
        Function2 function232 = new Function2() { // from class: q0.h2
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return AppModuleKt.o4((Scope) obj, (ParametersHolder) obj2);
            }
        };
        SingleInstanceFactory singleInstanceFactory30 = new SingleInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(GetBackupHistoryUseCase.class), null, function232, kind, CollectionsKt.emptyList()));
        module.f(singleInstanceFactory30);
        if (module.e()) {
            module.g(singleInstanceFactory30);
        }
        new KoinDefinition(module, singleInstanceFactory30);
        Function2 function233 = new Function2() { // from class: q0.i2
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return AppModuleKt.p4((Scope) obj, (ParametersHolder) obj2);
            }
        };
        SingleInstanceFactory singleInstanceFactory31 = new SingleInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(GetApplicationStateWithSubAppsUseCase.class), null, function233, kind, CollectionsKt.emptyList()));
        module.f(singleInstanceFactory31);
        if (module.e()) {
            module.g(singleInstanceFactory31);
        }
        new KoinDefinition(module, singleInstanceFactory31);
        Function2 function234 = new Function2() { // from class: q0.j2
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return AppModuleKt.q4((Scope) obj, (ParametersHolder) obj2);
            }
        };
        SingleInstanceFactory singleInstanceFactory32 = new SingleInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(RestoreSettingsUseCase.class), null, function234, kind, CollectionsKt.emptyList()));
        module.f(singleInstanceFactory32);
        if (module.e()) {
            module.g(singleInstanceFactory32);
        }
        new KoinDefinition(module, singleInstanceFactory32);
        Function2 function235 = new Function2() { // from class: q0.k2
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return AppModuleKt.r4((Scope) obj, (ParametersHolder) obj2);
            }
        };
        SingleInstanceFactory singleInstanceFactory33 = new SingleInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(RestoreStatisticsUseCase.class), null, function235, kind, CollectionsKt.emptyList()));
        module.f(singleInstanceFactory33);
        if (module.e()) {
            module.g(singleInstanceFactory33);
        }
        new KoinDefinition(module, singleInstanceFactory33);
        Function2 function236 = new Function2() { // from class: q0.l2
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return AppModuleKt.s4((Scope) obj, (ParametersHolder) obj2);
            }
        };
        SingleInstanceFactory singleInstanceFactory34 = new SingleInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(RestoreHistoryUseCase.class), null, function236, kind, CollectionsKt.emptyList()));
        module.f(singleInstanceFactory34);
        if (module.e()) {
            module.g(singleInstanceFactory34);
        }
        new KoinDefinition(module, singleInstanceFactory34);
        Function2 function237 = new Function2() { // from class: q0.m2
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return AppModuleKt.t4((Scope) obj, (ParametersHolder) obj2);
            }
        };
        SingleInstanceFactory singleInstanceFactory35 = new SingleInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(RestoreStrictModeUseCase.class), null, function237, kind, CollectionsKt.emptyList()));
        module.f(singleInstanceFactory35);
        if (module.e()) {
            module.g(singleInstanceFactory35);
        }
        new KoinDefinition(module, singleInstanceFactory35);
        Function2 function238 = new Function2() { // from class: q0.n2
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return AppModuleKt.u4((Scope) obj, (ParametersHolder) obj2);
            }
        };
        SingleInstanceFactory singleInstanceFactory36 = new SingleInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(CreateIntervalsUseCase.class), null, function238, kind, CollectionsKt.emptyList()));
        module.f(singleInstanceFactory36);
        if (module.e()) {
            module.g(singleInstanceFactory36);
        }
        new KoinDefinition(module, singleInstanceFactory36);
        Function2 function239 = new Function2() { // from class: q0.o2
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return AppModuleKt.v4((Scope) obj, (ParametersHolder) obj2);
            }
        };
        SingleInstanceFactory singleInstanceFactory37 = new SingleInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(FetchGraphDataUseCase.class), null, function239, kind, CollectionsKt.emptyList()));
        module.f(singleInstanceFactory37);
        if (module.e()) {
            module.g(singleInstanceFactory37);
        }
        new KoinDefinition(module, singleInstanceFactory37);
        Function2 function240 = new Function2() { // from class: q0.p2
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return AppModuleKt.w4((Scope) obj, (ParametersHolder) obj2);
            }
        };
        SingleInstanceFactory singleInstanceFactory38 = new SingleInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(MigrateStatisticsToInsightsUseCase.class), null, function240, kind, CollectionsKt.emptyList()));
        module.f(singleInstanceFactory38);
        if (module.e()) {
            module.g(singleInstanceFactory38);
        }
        new KoinDefinition(module, singleInstanceFactory38);
        Function2 function241 = new Function2() { // from class: q0.s2
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return AppModuleKt.y4((Scope) obj, (ParametersHolder) obj2);
            }
        };
        SingleInstanceFactory singleInstanceFactory39 = new SingleInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(FetchBlockingSessionsUseCase.class), null, function241, kind, CollectionsKt.emptyList()));
        module.f(singleInstanceFactory39);
        if (module.e()) {
            module.g(singleInstanceFactory39);
        }
        new KoinDefinition(module, singleInstanceFactory39);
        Function2 function242 = new Function2() { // from class: q0.t2
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return AppModuleKt.z4((Scope) obj, (ParametersHolder) obj2);
            }
        };
        SingleInstanceFactory singleInstanceFactory40 = new SingleInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(FetchTrialSummaryUseCase.class), null, function242, kind, CollectionsKt.emptyList()));
        module.f(singleInstanceFactory40);
        if (module.e()) {
            module.g(singleInstanceFactory40);
        }
        new KoinDefinition(module, singleInstanceFactory40);
        Function2 function243 = new Function2() { // from class: q0.u2
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return AppModuleKt.A4((Scope) obj, (ParametersHolder) obj2);
            }
        };
        SingleInstanceFactory singleInstanceFactory41 = new SingleInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(SchedulingConflictUseCase.class), null, function243, kind, CollectionsKt.emptyList()));
        module.f(singleInstanceFactory41);
        if (module.e()) {
            module.g(singleInstanceFactory41);
        }
        new KoinDefinition(module, singleInstanceFactory41);
        Function2 function244 = new Function2() { // from class: q0.v2
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return AppModuleKt.B4((Scope) obj, (ParametersHolder) obj2);
            }
        };
        SingleInstanceFactory singleInstanceFactory42 = new SingleInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(WeeklyStatisticsComparisonUseCase.class), null, function244, kind, CollectionsKt.emptyList()));
        module.f(singleInstanceFactory42);
        if (module.e()) {
            module.g(singleInstanceFactory42);
        }
        new KoinDefinition(module, singleInstanceFactory42);
        Function2 function245 = new Function2() { // from class: q0.w2
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return AppModuleKt.C4((Scope) obj, (ParametersHolder) obj2);
            }
        };
        SingleInstanceFactory singleInstanceFactory43 = new SingleInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(DailyStatisticsComparisonUseCase.class), null, function245, kind, CollectionsKt.emptyList()));
        module.f(singleInstanceFactory43);
        if (module.e()) {
            module.g(singleInstanceFactory43);
        }
        new KoinDefinition(module, singleInstanceFactory43);
        Function2 function246 = new Function2() { // from class: q0.x2
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return AppModuleKt.D4((Scope) obj, (ParametersHolder) obj2);
            }
        };
        SingleInstanceFactory singleInstanceFactory44 = new SingleInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(FetchAggregatedAppDataUseCase.class), null, function246, kind, CollectionsKt.emptyList()));
        module.f(singleInstanceFactory44);
        if (module.e()) {
            module.g(singleInstanceFactory44);
        }
        new KoinDefinition(module, singleInstanceFactory44);
        Function2 function247 = new Function2() { // from class: q0.y2
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return AppModuleKt.E4((Scope) obj, (ParametersHolder) obj2);
            }
        };
        SingleInstanceFactory singleInstanceFactory45 = new SingleInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(FetchAppDataUseCase.class), null, function247, kind, CollectionsKt.emptyList()));
        module.f(singleInstanceFactory45);
        if (module.e()) {
            module.g(singleInstanceFactory45);
        }
        new KoinDefinition(module, singleInstanceFactory45);
        Function2 function248 = new Function2() { // from class: q0.z2
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return AppModuleKt.F4((Scope) obj, (ParametersHolder) obj2);
            }
        };
        SingleInstanceFactory singleInstanceFactory46 = new SingleInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(LongestContinuousUseUseCase.class), null, function248, kind, CollectionsKt.emptyList()));
        module.f(singleInstanceFactory46);
        if (module.e()) {
            module.g(singleInstanceFactory46);
        }
        new KoinDefinition(module, singleInstanceFactory46);
        Function2 function249 = new Function2() { // from class: q0.a3
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return AppModuleKt.G4((Scope) obj, (ParametersHolder) obj2);
            }
        };
        SingleInstanceFactory singleInstanceFactory47 = new SingleInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(LongestContinuousBreakUseCase.class), null, function249, kind, CollectionsKt.emptyList()));
        module.f(singleInstanceFactory47);
        if (module.e()) {
            module.g(singleInstanceFactory47);
        }
        new KoinDefinition(module, singleInstanceFactory47);
        Function2 function250 = new Function2() { // from class: q0.b3
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return AppModuleKt.H4((Scope) obj, (ParametersHolder) obj2);
            }
        };
        SingleInstanceFactory singleInstanceFactory48 = new SingleInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(AppDifferenceUseCase.class), null, function250, kind, CollectionsKt.emptyList()));
        module.f(singleInstanceFactory48);
        if (module.e()) {
            module.g(singleInstanceFactory48);
        }
        new KoinDefinition(module, singleInstanceFactory48);
        Function2 function251 = new Function2() { // from class: q0.e3
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return AppModuleKt.J4((Scope) obj, (ParametersHolder) obj2);
            }
        };
        SingleInstanceFactory singleInstanceFactory49 = new SingleInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(ActivateStrictModeUseCase.class), null, function251, kind, CollectionsKt.emptyList()));
        module.f(singleInstanceFactory49);
        if (module.e()) {
            module.g(singleInstanceFactory49);
        }
        new KoinDefinition(module, singleInstanceFactory49);
        Function2 function252 = new Function2() { // from class: q0.f3
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return AppModuleKt.K4((Scope) obj, (ParametersHolder) obj2);
            }
        };
        SingleInstanceFactory singleInstanceFactory50 = new SingleInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(GetTitleAndSubtitleUseCase.class), null, function252, kind, CollectionsKt.emptyList()));
        module.f(singleInstanceFactory50);
        if (module.e()) {
            module.g(singleInstanceFactory50);
        }
        new KoinDefinition(module, singleInstanceFactory50);
        Function2 function253 = new Function2() { // from class: q0.g3
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return AppModuleKt.L4((Scope) obj, (ParametersHolder) obj2);
            }
        };
        SingleInstanceFactory singleInstanceFactory51 = new SingleInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(SetTimerValueUseCase.class), null, function253, kind, CollectionsKt.emptyList()));
        module.f(singleInstanceFactory51);
        if (module.e()) {
            module.g(singleInstanceFactory51);
        }
        new KoinDefinition(module, singleInstanceFactory51);
        Function2 function254 = new Function2() { // from class: q0.h3
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return AppModuleKt.M4((Scope) obj, (ParametersHolder) obj2);
            }
        };
        SingleInstanceFactory singleInstanceFactory52 = new SingleInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(GetActiveStateUseCase.class), null, function254, kind, CollectionsKt.emptyList()));
        module.f(singleInstanceFactory52);
        if (module.e()) {
            module.g(singleInstanceFactory52);
        }
        new KoinDefinition(module, singleInstanceFactory52);
        Function2 function255 = new Function2() { // from class: q0.i3
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return AppModuleKt.N4((Scope) obj, (ParametersHolder) obj2);
            }
        };
        SingleInstanceFactory singleInstanceFactory53 = new SingleInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(ShouldShowLimitedTimerUseCase.class), null, function255, kind, CollectionsKt.emptyList()));
        module.f(singleInstanceFactory53);
        if (module.e()) {
            module.g(singleInstanceFactory53);
        }
        new KoinDefinition(module, singleInstanceFactory53);
        Function2 function256 = new Function2() { // from class: q0.j3
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return AppModuleKt.O4((Scope) obj, (ParametersHolder) obj2);
            }
        };
        InstanceFactory factoryInstanceFactory3 = new FactoryInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(GetMissingPermissionsUseCase.class), null, function256, kind2, CollectionsKt.emptyList()));
        module.f(factoryInstanceFactory3);
        new KoinDefinition(module, factoryInstanceFactory3);
        Function2 function257 = new Function2() { // from class: q0.k3
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return AppModuleKt.P4((Scope) obj, (ParametersHolder) obj2);
            }
        };
        InstanceFactory factoryInstanceFactory4 = new FactoryInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(WillBeContinuousUseCase.class), null, function257, kind2, CollectionsKt.emptyList()));
        module.f(factoryInstanceFactory4);
        new KoinDefinition(module, factoryInstanceFactory4);
        Function2 function258 = new Function2() { // from class: q0.l3
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return AppModuleKt.Q4((Scope) obj, (ParametersHolder) obj2);
            }
        };
        SingleInstanceFactory singleInstanceFactory54 = new SingleInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(DetectBrowserUrlUseCase.class), null, function258, kind, CollectionsKt.emptyList()));
        module.f(singleInstanceFactory54);
        if (module.e()) {
            module.g(singleInstanceFactory54);
        }
        new KoinDefinition(module, singleInstanceFactory54);
        Function2 function259 = new Function2() { // from class: q0.m3
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return AppModuleKt.R4((Scope) obj, (ParametersHolder) obj2);
            }
        };
        SingleInstanceFactory singleInstanceFactory55 = new SingleInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(ExtractUrlFromNodeUseCase.class), null, function259, kind, CollectionsKt.emptyList()));
        module.f(singleInstanceFactory55);
        if (module.e()) {
            module.g(singleInstanceFactory55);
        }
        new KoinDefinition(module, singleInstanceFactory55);
        Function2 function260 = new Function2() { // from class: q0.o3
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return AppModuleKt.S4((Scope) obj, (ParametersHolder) obj2);
            }
        };
        SingleInstanceFactory singleInstanceFactory56 = new SingleInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(FindUrlBarNodeUseCase.class), null, function260, kind, CollectionsKt.emptyList()));
        module.f(singleInstanceFactory56);
        if (module.e()) {
            module.g(singleInstanceFactory56);
        }
        new KoinDefinition(module, singleInstanceFactory56);
        Function2 function261 = new Function2() { // from class: q0.q3
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return AppModuleKt.U4((Scope) obj, (ParametersHolder) obj2);
            }
        };
        SingleInstanceFactory singleInstanceFactory57 = new SingleInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(FindComposeNodeByTestTagUseCase.class), null, function261, kind, CollectionsKt.emptyList()));
        module.f(singleInstanceFactory57);
        if (module.e()) {
            module.g(singleInstanceFactory57);
        }
        new KoinDefinition(module, singleInstanceFactory57);
        Function2 function262 = new Function2() { // from class: q0.r3
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return AppModuleKt.V4((Scope) obj, (ParametersHolder) obj2);
            }
        };
        InstanceFactory factoryInstanceFactory5 = new FactoryInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(GetForegroundAppsUseCase.class), null, function262, kind2, CollectionsKt.emptyList()));
        module.f(factoryInstanceFactory5);
        new KoinDefinition(module, factoryInstanceFactory5);
        Function2 function263 = new Function2() { // from class: q0.s3
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return AppModuleKt.W4((Scope) obj, (ParametersHolder) obj2);
            }
        };
        SingleInstanceFactory singleInstanceFactory58 = new SingleInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(StreakAvailability.class), null, function263, kind, CollectionsKt.emptyList()));
        module.f(singleInstanceFactory58);
        if (module.e()) {
            module.g(singleInstanceFactory58);
        }
        new KoinDefinition(module, singleInstanceFactory58);
        Function2 function264 = new Function2() { // from class: q0.t3
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return AppModuleKt.X4((Scope) obj, (ParametersHolder) obj2);
            }
        };
        SingleInstanceFactory singleInstanceFactory59 = new SingleInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(StreakIntroAvailability.class), null, function264, kind, CollectionsKt.emptyList()));
        module.f(singleInstanceFactory59);
        if (module.e()) {
            module.g(singleInstanceFactory59);
        }
        new KoinDefinition(module, singleInstanceFactory59);
        Function2 function265 = new Function2() { // from class: q0.u3
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return AppModuleKt.Y4((Scope) obj, (ParametersHolder) obj2);
            }
        };
        SingleInstanceFactory singleInstanceFactory60 = new SingleInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(StreakActivityTracker.class), null, function265, kind, CollectionsKt.emptyList()));
        module.f(singleInstanceFactory60);
        if (module.e()) {
            module.g(singleInstanceFactory60);
        }
        new KoinDefinition(module, singleInstanceFactory60);
        Function2 function266 = new Function2() { // from class: q0.v3
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return AppModuleKt.Z4((Scope) obj, (ParametersHolder) obj2);
            }
        };
        SingleInstanceFactory singleInstanceFactory61 = new SingleInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(StreakPauseTracker.class), null, function266, kind, CollectionsKt.emptyList()));
        module.f(singleInstanceFactory61);
        if (module.e()) {
            module.g(singleInstanceFactory61);
        }
        new KoinDefinition(module, singleInstanceFactory61);
        Function2 function267 = new Function2() { // from class: q0.w3
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return AppModuleKt.a5((Scope) obj, (ParametersHolder) obj2);
            }
        };
        SingleInstanceFactory singleInstanceFactory62 = new SingleInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(StreakActivityRepository.class), null, function267, kind, CollectionsKt.emptyList()));
        module.f(singleInstanceFactory62);
        if (module.e()) {
            module.g(singleInstanceFactory62);
        }
        new KoinDefinition(module, singleInstanceFactory62);
        Function2 function268 = new Function2() { // from class: q0.x3
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return AppModuleKt.b5((Scope) obj, (ParametersHolder) obj2);
            }
        };
        SingleInstanceFactory singleInstanceFactory63 = new SingleInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(StreakRepository.class), null, function268, kind, CollectionsKt.emptyList()));
        module.f(singleInstanceFactory63);
        if (module.e()) {
            module.g(singleInstanceFactory63);
        }
        new KoinDefinition(module, singleInstanceFactory63);
        Function2 function269 = new Function2() { // from class: q0.z3
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return AppModuleKt.c5((Scope) obj, (ParametersHolder) obj2);
            }
        };
        SingleInstanceFactory singleInstanceFactory64 = new SingleInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(StreakEvaluator.class), null, function269, kind, CollectionsKt.emptyList()));
        module.f(singleInstanceFactory64);
        if (module.e()) {
            module.g(singleInstanceFactory64);
        }
        new KoinDefinition(module, singleInstanceFactory64);
        Function2 function270 = new Function2() { // from class: q0.a4
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return AppModuleKt.d5((Scope) obj, (ParametersHolder) obj2);
            }
        };
        SingleInstanceFactory singleInstanceFactory65 = new SingleInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(StreakAchievementNotificationPlanner.class), null, function270, kind, CollectionsKt.emptyList()));
        module.f(singleInstanceFactory65);
        if (module.e()) {
            module.g(singleInstanceFactory65);
        }
        new KoinDefinition(module, singleInstanceFactory65);
        Function2 function271 = new Function2() { // from class: q0.c4
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return AppModuleKt.f5((Scope) obj, (ParametersHolder) obj2);
            }
        };
        SingleInstanceFactory singleInstanceFactory66 = new SingleInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(StreakNudgePlanner.class), null, function271, kind, CollectionsKt.emptyList()));
        module.f(singleInstanceFactory66);
        if (module.e()) {
            module.g(singleInstanceFactory66);
        }
        new KoinDefinition(module, singleInstanceFactory66);
        Function2 function272 = new Function2() { // from class: q0.d4
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return AppModuleKt.g5((Scope) obj, (ParametersHolder) obj2);
            }
        };
        SingleInstanceFactory singleInstanceFactory67 = new SingleInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(StreakDailyPresenter.class), null, function272, kind, CollectionsKt.emptyList()));
        module.f(singleInstanceFactory67);
        if (module.e()) {
            module.g(singleInstanceFactory67);
        }
        new KoinDefinition(module, singleInstanceFactory67);
        Function2 function273 = new Function2() { // from class: q0.e4
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return AppModuleKt.h5((Scope) obj, (ParametersHolder) obj2);
            }
        };
        SingleInstanceFactory singleInstanceFactory68 = new SingleInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(StreakDebugHelper.class), null, function273, kind, CollectionsKt.emptyList()));
        module.f(singleInstanceFactory68);
        if (module.e()) {
            module.g(singleInstanceFactory68);
        }
        new KoinDefinition(module, singleInstanceFactory68);
        Function2 function274 = new Function2() { // from class: q0.f4
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return AppModuleKt.i5((Scope) obj, (ParametersHolder) obj2);
            }
        };
        SingleInstanceFactory singleInstanceFactory69 = new SingleInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(StreakStore.class), null, function274, kind, CollectionsKt.emptyList()));
        module.f(singleInstanceFactory69);
        if (module.e()) {
            module.g(singleInstanceFactory69);
        }
        new KoinDefinition(module, singleInstanceFactory69);
        Function2 function275 = new Function2() { // from class: q0.g4
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return AppModuleKt.j5((Scope) obj, (ParametersHolder) obj2);
            }
        };
        SingleInstanceFactory singleInstanceFactory70 = new SingleInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(StreakApiRepository.class), null, function275, kind, CollectionsKt.emptyList()));
        module.f(singleInstanceFactory70);
        if (module.e()) {
            module.g(singleInstanceFactory70);
        }
        new KoinDefinition(module, singleInstanceFactory70);
        Function2 function276 = new Function2() { // from class: q0.h4
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return AppModuleKt.k5((Scope) obj, (ParametersHolder) obj2);
            }
        };
        SingleInstanceFactory singleInstanceFactory71 = new SingleInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(StreakSnapshotSync.class), null, function276, kind, CollectionsKt.emptyList()));
        module.f(singleInstanceFactory71);
        if (module.e()) {
            module.g(singleInstanceFactory71);
        }
        new KoinDefinition(module, singleInstanceFactory71);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final GetMissingPermissionsUseCase O4(Scope factory, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(factory, "$this$factory");
        Intrinsics.checkNotNullParameter(it, "it");
        return new GetMissingPermissionsUseCase((Context) factory.e(Reflection.b(Context.class), null, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PricingPhaseDao P2(Scope single, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it, "it");
        return ((CoreDatabase) single.e(Reflection.b(CoreDatabase.class), null, null)).v();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InitApplicationsUseCase P3(Scope single, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it, "it");
        return new InitApplicationsUseCase((CoreMultiProcessDataStore) single.e(Reflection.b(CoreMultiProcessDataStore.class), null, null), (ApplicationDao) single.e(Reflection.b(ApplicationDao.class), null, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WillBeContinuousUseCase P4(Scope factory, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(factory, "$this$factory");
        Intrinsics.checkNotNullParameter(it, "it");
        return new WillBeContinuousUseCase((ProfileDao) factory.e(Reflection.b(ProfileDao.class), null, null), (IntervalDao) factory.e(Reflection.b(IntervalDao.class), null, null), (StrictModeDataStore) factory.e(Reflection.b(StrictModeDataStore.class), null, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final UsedBackdoorCodeDao Q2(Scope single, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it, "it");
        return ((CoreDatabase) single.e(Reflection.b(CoreDatabase.class), null, null)).A();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PickDailyInsightsMotivationMessageUseCase Q3(Scope single, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it, "it");
        return new PickDailyInsightsMotivationMessageUseCase((Context) single.e(Reflection.b(Context.class), null, null), (NotificationDataStore) single.e(Reflection.b(NotificationDataStore.class), null, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DetectBrowserUrlUseCase Q4(Scope single, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it, "it");
        return new DetectBrowserUrlUseCase((FindUrlBarNodeUseCase) single.e(Reflection.b(FindUrlBarNodeUseCase.class), null, null), (ExtractUrlFromNodeUseCase) single.e(Reflection.b(ExtractUrlFromNodeUseCase.class), null, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AppVersionDao R2(Scope single, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it, "it");
        return ((CoreDatabase) single.e(Reflection.b(CoreDatabase.class), null, null)).p();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PickTimeNudgeNotificationMessageUseCase R3(Scope single, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it, "it");
        return new PickTimeNudgeNotificationMessageUseCase((Context) single.e(Reflection.b(Context.class), null, null), (CoreMultiProcessDataStore) single.e(Reflection.b(CoreMultiProcessDataStore.class), null, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ExtractUrlFromNodeUseCase R4(Scope single, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it, "it");
        return new ExtractUrlFromNodeUseCase();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PurchasedOfferDao S2(Scope single, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it, "it");
        return ((CoreDatabase) single.e(Reflection.b(CoreDatabase.class), null, null)).x();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ApplyTimeNudgeDefaultAppsUseCase S3(Scope single, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it, "it");
        return new ApplyTimeNudgeDefaultAppsUseCase();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FindUrlBarNodeUseCase S4(Scope single, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it, "it");
        return new FindUrlBarNodeUseCase((FindComposeNodeByTestTagUseCase) single.e(Reflection.b(FindComposeNodeByTestTagUseCase.class), null, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit T2(Module module) {
        Intrinsics.checkNotNullParameter(module, "$this$module");
        Function2 function2 = new Function2() { // from class: q0.m4
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return AppModuleKt.U2((Scope) obj, (ParametersHolder) obj2);
            }
        };
        ScopeRegistry.Companion companion = ScopeRegistry.f146057e;
        StringQualifier stringQualifierA = companion.a();
        Kind kind = Kind.Singleton;
        SingleInstanceFactory singleInstanceFactory = new SingleInstanceFactory(new BeanDefinition(stringQualifierA, Reflection.b(TokenFCMRepository.class), null, function2, kind, CollectionsKt.emptyList()));
        module.f(singleInstanceFactory);
        if (module.e()) {
            module.g(singleInstanceFactory);
        }
        new KoinDefinition(module, singleInstanceFactory);
        Function2 function22 = new Function2() { // from class: q0.y4
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return AppModuleKt.V2((Scope) obj, (ParametersHolder) obj2);
            }
        };
        SingleInstanceFactory singleInstanceFactory2 = new SingleInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(FacebookLogger.class), null, function22, kind, CollectionsKt.emptyList()));
        module.f(singleInstanceFactory2);
        if (module.e()) {
            module.g(singleInstanceFactory2);
        }
        new KoinDefinition(module, singleInstanceFactory2);
        Function2 function23 = new Function2() { // from class: q0.d5
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return AppModuleKt.g3((Scope) obj, (ParametersHolder) obj2);
            }
        };
        SingleInstanceFactory singleInstanceFactory3 = new SingleInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(JobHelperKtx.class), null, function23, kind, CollectionsKt.emptyList()));
        module.f(singleInstanceFactory3);
        if (module.e()) {
            module.g(singleInstanceFactory3);
        }
        new KoinDefinition(module, singleInstanceFactory3);
        Function2 function24 = new Function2() { // from class: q0.e5
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return AppModuleKt.l3((Scope) obj, (ParametersHolder) obj2);
            }
        };
        SingleInstanceFactory singleInstanceFactory4 = new SingleInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(PassCodeManager.class), null, function24, kind, CollectionsKt.emptyList()));
        module.f(singleInstanceFactory4);
        if (module.e()) {
            module.g(singleInstanceFactory4);
        }
        new KoinDefinition(module, singleInstanceFactory4);
        Function2 function25 = new Function2() { // from class: q0.b
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return AppModuleKt.m3((Scope) obj, (ParametersHolder) obj2);
            }
        };
        SingleInstanceFactory singleInstanceFactory5 = new SingleInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(StrictModeRepository.class), null, function25, kind, CollectionsKt.emptyList()));
        module.f(singleInstanceFactory5);
        if (module.e()) {
            module.g(singleInstanceFactory5);
        }
        new KoinDefinition(module, singleInstanceFactory5);
        Function2 function26 = new Function2() { // from class: q0.c
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return AppModuleKt.n3((Scope) obj, (ParametersHolder) obj2);
            }
        };
        SingleInstanceFactory singleInstanceFactory6 = new SingleInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(DiscountRepository.class), null, function26, kind, CollectionsKt.emptyList()));
        module.f(singleInstanceFactory6);
        if (module.e()) {
            module.g(singleInstanceFactory6);
        }
        new KoinDefinition(module, singleInstanceFactory6);
        Function2 function27 = new Function2() { // from class: q0.d
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return AppModuleKt.o3((Scope) obj, (ParametersHolder) obj2);
            }
        };
        SingleInstanceFactory singleInstanceFactory7 = new SingleInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(PremiumStateChangeReactor.class), null, function27, kind, CollectionsKt.emptyList()));
        module.f(singleInstanceFactory7);
        if (module.e()) {
            module.g(singleInstanceFactory7);
        }
        new KoinDefinition(module, singleInstanceFactory7);
        Function2 function28 = new Function2() { // from class: q0.e
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return AppModuleKt.p3((Scope) obj, (ParametersHolder) obj2);
            }
        };
        SingleInstanceFactory singleInstanceFactory8 = new SingleInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(DiagnosticRepository.class), null, function28, kind, CollectionsKt.emptyList()));
        module.f(singleInstanceFactory8);
        if (module.e()) {
            module.g(singleInstanceFactory8);
        }
        new KoinDefinition(module, singleInstanceFactory8);
        Function2 function29 = new Function2() { // from class: q0.f
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return AppModuleKt.q3((Scope) obj, (ParametersHolder) obj2);
            }
        };
        SingleInstanceFactory singleInstanceFactory9 = new SingleInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(TrialUpsellManager.class), null, function29, kind, CollectionsKt.emptyList()));
        module.f(singleInstanceFactory9);
        if (module.e()) {
            module.g(singleInstanceFactory9);
        }
        new KoinDefinition(module, singleInstanceFactory9);
        Function2 function210 = new Function2() { // from class: q0.g
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return AppModuleKt.r3((Scope) obj, (ParametersHolder) obj2);
            }
        };
        SingleInstanceFactory singleInstanceFactory10 = new SingleInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(PremiumRepositoryV2.class), null, function210, kind, CollectionsKt.emptyList()));
        module.f(singleInstanceFactory10);
        if (module.e()) {
            module.g(singleInstanceFactory10);
        }
        new KoinDefinition(module, singleInstanceFactory10);
        Function2 function211 = new Function2() { // from class: q0.n4
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return AppModuleKt.W2((Scope) obj, (ParametersHolder) obj2);
            }
        };
        SingleInstanceFactory singleInstanceFactory11 = new SingleInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(SuperwallPurchaseController.class), null, function211, kind, CollectionsKt.emptyList()));
        module.f(singleInstanceFactory11);
        if (module.e()) {
            module.g(singleInstanceFactory11);
        }
        new KoinDefinition(module, singleInstanceFactory11);
        Function2 function212 = new Function2() { // from class: q0.o4
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return AppModuleKt.X2((Scope) obj, (ParametersHolder) obj2);
            }
        };
        SingleInstanceFactory singleInstanceFactory12 = new SingleInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(TrialConversionCoordinator.class), null, function212, kind, CollectionsKt.emptyList()));
        module.f(singleInstanceFactory12);
        if (module.e()) {
            module.g(singleInstanceFactory12);
        }
        new KoinDefinition(module, singleInstanceFactory12);
        Function2 function213 = new Function2() { // from class: q0.p4
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return AppModuleKt.Y2((Scope) obj, (ParametersHolder) obj2);
            }
        };
        SingleInstanceFactory singleInstanceFactory13 = new SingleInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(DeeplinkRouter.class), null, function213, kind, CollectionsKt.emptyList()));
        module.f(singleInstanceFactory13);
        if (module.e()) {
            module.g(singleInstanceFactory13);
        }
        new KoinDefinition(module, singleInstanceFactory13);
        Function2 function214 = new Function2() { // from class: q0.q4
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return AppModuleKt.Z2((Scope) obj, (ParametersHolder) obj2);
            }
        };
        SingleInstanceFactory singleInstanceFactory14 = new SingleInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(LocationManager.class), null, function214, kind, CollectionsKt.emptyList()));
        module.f(singleInstanceFactory14);
        if (module.e()) {
            module.g(singleInstanceFactory14);
        }
        new KoinDefinition(module, singleInstanceFactory14);
        Function2 function215 = new Function2() { // from class: q0.r4
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return AppModuleKt.a3((Scope) obj, (ParametersHolder) obj2);
            }
        };
        SingleInstanceFactory singleInstanceFactory15 = new SingleInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(PermissionsHandler.class), null, function215, kind, CollectionsKt.emptyList()));
        module.f(singleInstanceFactory15);
        if (module.e()) {
            module.g(singleInstanceFactory15);
        }
        new KoinDefinition(module, singleInstanceFactory15);
        Function2 function216 = new Function2() { // from class: q0.s4
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return AppModuleKt.b3((Scope) obj, (ParametersHolder) obj2);
            }
        };
        InstanceFactory factoryInstanceFactory = new FactoryInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(DexReceiver.class), null, function216, Kind.Factory, CollectionsKt.emptyList()));
        module.f(factoryInstanceFactory);
        new KoinDefinition(module, factoryInstanceFactory);
        Function2 function217 = new Function2() { // from class: q0.t4
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return AppModuleKt.c3((Scope) obj, (ParametersHolder) obj2);
            }
        };
        SingleInstanceFactory singleInstanceFactory16 = new SingleInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(VideoCompressionManager.class), null, function217, kind, CollectionsKt.emptyList()));
        module.f(singleInstanceFactory16);
        if (module.e()) {
            module.g(singleInstanceFactory16);
        }
        new KoinDefinition(module, singleInstanceFactory16);
        Function2 function218 = new Function2() { // from class: q0.v4
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return AppModuleKt.d3((Scope) obj, (ParametersHolder) obj2);
            }
        };
        SingleInstanceFactory singleInstanceFactory17 = new SingleInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(QuickBlockRepository.class), null, function218, kind, CollectionsKt.emptyList()));
        module.f(singleInstanceFactory17);
        if (module.e()) {
            module.g(singleInstanceFactory17);
        }
        new KoinDefinition(module, singleInstanceFactory17);
        Function2 function219 = new Function2() { // from class: q0.w4
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return AppModuleKt.e3((Scope) obj, (ParametersHolder) obj2);
            }
        };
        SingleInstanceFactory singleInstanceFactory18 = new SingleInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(NativeLib.class), null, function219, kind, CollectionsKt.emptyList()));
        module.f(singleInstanceFactory18);
        if (module.e()) {
            module.g(singleInstanceFactory18);
        }
        new KoinDefinition(module, singleInstanceFactory18);
        Function2 function220 = new Function2() { // from class: q0.x4
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return AppModuleKt.f3((Scope) obj, (ParametersHolder) obj2);
            }
        };
        SingleInstanceFactory singleInstanceFactory19 = new SingleInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(LockieApplication.class), null, function220, kind, CollectionsKt.emptyList()));
        module.f(singleInstanceFactory19);
        if (module.e()) {
            module.g(singleInstanceFactory19);
        }
        new KoinDefinition(module, singleInstanceFactory19);
        Function2 function221 = new Function2() { // from class: q0.z4
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return AppModuleKt.h3((Scope) obj, (ParametersHolder) obj2);
            }
        };
        SingleInstanceFactory singleInstanceFactory20 = new SingleInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(AccountabilityPartnerRepository.class), null, function221, kind, CollectionsKt.emptyList()));
        module.f(singleInstanceFactory20);
        if (module.e()) {
            module.g(singleInstanceFactory20);
        }
        new KoinDefinition(module, singleInstanceFactory20);
        Function2 function222 = new Function2() { // from class: q0.a5
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return AppModuleKt.i3((Scope) obj, (ParametersHolder) obj2);
            }
        };
        SingleInstanceFactory singleInstanceFactory21 = new SingleInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(ApprovalRepository.class), null, function222, kind, CollectionsKt.emptyList()));
        module.f(singleInstanceFactory21);
        if (module.e()) {
            module.g(singleInstanceFactory21);
        }
        new KoinDefinition(module, singleInstanceFactory21);
        Function2 function223 = new Function2() { // from class: q0.b5
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return AppModuleKt.j3((Scope) obj, (ParametersHolder) obj2);
            }
        };
        SingleInstanceFactory singleInstanceFactory22 = new SingleInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(SubAppRepository.class), null, function223, kind, CollectionsKt.emptyList()));
        module.f(singleInstanceFactory22);
        if (module.e()) {
            module.g(singleInstanceFactory22);
        }
        new KoinDefinition(module, singleInstanceFactory22);
        Function2 function224 = new Function2() { // from class: q0.c5
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return AppModuleKt.k3((Scope) obj, (ParametersHolder) obj2);
            }
        };
        SingleInstanceFactory singleInstanceFactory23 = new SingleInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(ConsentHelper.class), null, function224, kind, CollectionsKt.emptyList()));
        module.f(singleInstanceFactory23);
        if (module.e()) {
            module.g(singleInstanceFactory23);
        }
        new KoinDefinition(module, singleInstanceFactory23);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final EvaluateTimeNudgeUseCase T3(Scope single, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it, "it");
        return new EvaluateTimeNudgeUseCase(null, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final UpdateIconUseCase T4(Scope single, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it, "it");
        return new UpdateIconUseCase((Context) single.e(Reflection.b(Context.class), null, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TokenFCMRepository U2(Scope single, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it, "it");
        return new TokenFCMRepository((TokenFCMDao) single.e(Reflection.b(TokenFCMDao.class), null, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AverageStatisticsUseCase U3(Scope single, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it, "it");
        return new AverageStatisticsUseCase();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FindComposeNodeByTestTagUseCase U4(Scope single, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it, "it");
        return new FindComposeNodeByTestTagUseCase();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FacebookLogger V2(Scope single, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it, "it");
        return new FacebookLogger((Context) single.e(Reflection.b(Context.class), null, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BackdoorCodeUseCase V3(Scope single, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it, "it");
        return new BackdoorCodeUseCase();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final GetForegroundAppsUseCase V4(Scope factory, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(factory, "$this$factory");
        Intrinsics.checkNotNullParameter(it, "it");
        return new GetForegroundAppsUseCase((Context) factory.e(Reflection.b(Context.class), null, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SuperwallPurchaseController W2(Scope single, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it, "it");
        return new SuperwallPurchaseController();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FetchRevenueCatOfferingUseCase W3(Scope single, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it, "it");
        return new FetchRevenueCatOfferingUseCase();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StreakAvailability W4(Scope single, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it, "it");
        return new StreakAvailability((CoreDataStore) single.e(Reflection.b(CoreDataStore.class), null, null), (StreakDataStore) single.e(Reflection.b(StreakDataStore.class), null, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TrialConversionCoordinator X2(Scope single, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it, "it");
        return new TrialConversionCoordinator();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MakeRevenueCatPurchaseUseCase X3(Scope single, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it, "it");
        return new MakeRevenueCatPurchaseUseCase();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StreakIntroAvailability X4(Scope single, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it, "it");
        return new StreakIntroAvailability((CoreDataStore) single.e(Reflection.b(CoreDataStore.class), null, null), (StreakDataStore) single.e(Reflection.b(StreakDataStore.class), null, null), (AppVersionDao) single.e(Reflection.b(AppVersionDao.class), null, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DeeplinkRouter Y2(Scope single, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it, "it");
        return new DeeplinkRouter();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final UpdateUserDetailUseCase Y3(Scope single, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it, "it");
        return new UpdateUserDetailUseCase();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StreakActivityTracker Y4(Scope single, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it, "it");
        return new StreakActivityTracker((StreakDataStore) single.e(Reflection.b(StreakDataStore.class), null, null), (StreakActivitySessionDao) single.e(Reflection.b(StreakActivitySessionDao.class), null, null), (StreakAvailability) single.e(Reflection.b(StreakAvailability.class), null, null), (ProfileDao) single.e(Reflection.b(ProfileDao.class), null, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LocationManager Z2(Scope single, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it, "it");
        Object systemService = ModuleExtKt.b(single).getSystemService("location");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.location.LocationManager");
        return (LocationManager) systemService;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SyncEmailConsentUseCase Z3(Scope single, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it, "it");
        return new SyncEmailConsentUseCase();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StreakPauseTracker Z4(Scope single, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it, "it");
        return new StreakPauseTracker((StreakPauseRecordDao) single.e(Reflection.b(StreakPauseRecordDao.class), null, null), (StreakAvailability) single.e(Reflection.b(StreakAvailability.class), null, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PermissionsHandler a3(Scope single, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it, "it");
        return new PermissionsHandler((CoreDataStore) single.e(Reflection.b(CoreDataStore.class), null, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final GetUsageLimitsForCurrentPeriodUseCase a4(Scope single, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it, "it");
        return new GetUsageLimitsForCurrentPeriodUseCase();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StreakActivityRepository a5(Scope single, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it, "it");
        return new StreakActivityRepository((StreakPauseRecordDao) single.e(Reflection.b(StreakPauseRecordDao.class), null, null), (StreakActivitySessionDao) single.e(Reflection.b(StreakActivitySessionDao.class), null, null), (StreakActivityTracker) single.e(Reflection.b(StreakActivityTracker.class), null, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DexReceiver b3(Scope factory, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(factory, "$this$factory");
        Intrinsics.checkNotNullParameter(it, "it");
        return new DexReceiver();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SendContactSupportDetailedRequestUseCase b4(Scope single, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it, "it");
        return new SendContactSupportDetailedRequestUseCase((Context) single.e(Reflection.b(Context.class), null, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StreakRepository b5(Scope single, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it, "it");
        return new StreakRepository((StreakDayDao) single.e(Reflection.b(StreakDayDao.class), null, null), (StreakDataStore) single.e(Reflection.b(StreakDataStore.class), null, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final VideoCompressionManager c3(Scope single, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it, "it");
        return new VideoCompressionManager((Context) single.e(Reflection.b(Context.class), null, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CheckGuestPassEligibilityUseCase c4(Scope single, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it, "it");
        return new CheckGuestPassEligibilityUseCase();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StreakEvaluator c5(Scope single, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it, "it");
        return new StreakEvaluator((StreakPauseRecordDao) single.e(Reflection.b(StreakPauseRecordDao.class), null, null), (ProfileDao) single.e(Reflection.b(ProfileDao.class), null, null), (StreakActivityRepository) single.e(Reflection.b(StreakActivityRepository.class), null, null), (StreakRepository) single.e(Reflection.b(StreakRepository.class), null, null), (StreakAvailability) single.e(Reflection.b(StreakAvailability.class), null, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final QuickBlockRepository d3(Scope single, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it, "it");
        return new QuickBlockRepository();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CheckAutoTrialEligibilityUseCase d4(Scope single, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it, "it");
        return new CheckAutoTrialEligibilityUseCase();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StreakAchievementNotificationPlanner d5(Scope single, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it, "it");
        return new StreakAchievementNotificationPlanner((StreakStore) single.e(Reflection.b(StreakStore.class), null, null), (StreakDataStore) single.e(Reflection.b(StreakDataStore.class), null, null), (NotificationDataStore) single.e(Reflection.b(NotificationDataStore.class), null, null), (StreakAvailability) single.e(Reflection.b(StreakAvailability.class), null, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final NativeLib e3(Scope single, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it, "it");
        return new NativeLib();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final GetProfileRuntimeStateUseCase e4(Scope single, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it, "it");
        return new GetProfileRuntimeStateUseCase();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final RestoreProfilesUseCase e5(Scope single, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it, "it");
        return new RestoreProfilesUseCase((Context) single.e(Reflection.b(Context.class), null, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LockieApplication f3(Scope single, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it, "it");
        return LockieApplication.i((Context) single.e(Reflection.b(Context.class), null, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final GetLockServiceRunReasonsUseCase f4(Scope single, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it, "it");
        return new GetLockServiceRunReasonsUseCase();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g2(Module module) {
        Intrinsics.checkNotNullParameter(module, "$this$module");
        Function2 function2 = new Function2() { // from class: q0.t0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return AppModuleKt.h2((Scope) obj, (ParametersHolder) obj2);
            }
        };
        ScopeRegistry.Companion companion = ScopeRegistry.f146057e;
        StringQualifier stringQualifierA = companion.a();
        Kind kind = Kind.Singleton;
        SingleInstanceFactory singleInstanceFactory = new SingleInstanceFactory(new BeanDefinition(stringQualifierA, Reflection.b(BlockingDatabase.class), null, function2, kind, CollectionsKt.emptyList()));
        module.f(singleInstanceFactory);
        if (module.e()) {
            module.g(singleInstanceFactory);
        }
        new KoinDefinition(module, singleInstanceFactory);
        Function2 function22 = new Function2() { // from class: q0.f1
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return AppModuleKt.i2((Scope) obj, (ParametersHolder) obj2);
            }
        };
        SingleInstanceFactory singleInstanceFactory2 = new SingleInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(AppWebsiteCategoryDao.class), null, function22, kind, CollectionsKt.emptyList()));
        module.f(singleInstanceFactory2);
        if (module.e()) {
            module.g(singleInstanceFactory2);
        }
        new KoinDefinition(module, singleInstanceFactory2);
        Function2 function23 = new Function2() { // from class: q0.i1
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return AppModuleKt.t2((Scope) obj, (ParametersHolder) obj2);
            }
        };
        SingleInstanceFactory singleInstanceFactory3 = new SingleInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(BlockedNotificationDao.class), null, function23, kind, CollectionsKt.emptyList()));
        module.f(singleInstanceFactory3);
        if (module.e()) {
            module.g(singleInstanceFactory3);
        }
        new KoinDefinition(module, singleInstanceFactory3);
        Function2 function24 = new Function2() { // from class: q0.j1
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return AppModuleKt.w2((Scope) obj, (ParametersHolder) obj2);
            }
        };
        SingleInstanceFactory singleInstanceFactory4 = new SingleInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(BlockSessionDao.class), null, function24, kind, CollectionsKt.emptyList()));
        module.f(singleInstanceFactory4);
        if (module.e()) {
            module.g(singleInstanceFactory4);
        }
        new KoinDefinition(module, singleInstanceFactory4);
        Function2 function25 = new Function2() { // from class: q0.k1
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return AppModuleKt.x2((Scope) obj, (ParametersHolder) obj2);
            }
        };
        SingleInstanceFactory singleInstanceFactory5 = new SingleInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(BrowserViewIdDao.class), null, function25, kind, CollectionsKt.emptyList()));
        module.f(singleInstanceFactory5);
        if (module.e()) {
            module.g(singleInstanceFactory5);
        }
        new KoinDefinition(module, singleInstanceFactory5);
        Function2 function26 = new Function2() { // from class: q0.l1
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return AppModuleKt.y2((Scope) obj, (ParametersHolder) obj2);
            }
        };
        SingleInstanceFactory singleInstanceFactory6 = new SingleInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(ApplicationDao.class), null, function26, kind, CollectionsKt.emptyList()));
        module.f(singleInstanceFactory6);
        if (module.e()) {
            module.g(singleInstanceFactory6);
        }
        new KoinDefinition(module, singleInstanceFactory6);
        Function2 function27 = new Function2() { // from class: q0.m1
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return AppModuleKt.z2((Scope) obj, (ParametersHolder) obj2);
            }
        };
        SingleInstanceFactory singleInstanceFactory7 = new SingleInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(ApplicationProfileRelationDao.class), null, function27, kind, CollectionsKt.emptyList()));
        module.f(singleInstanceFactory7);
        if (module.e()) {
            module.g(singleInstanceFactory7);
        }
        new KoinDefinition(module, singleInstanceFactory7);
        Function2 function28 = new Function2() { // from class: q0.n1
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return AppModuleKt.A2((Scope) obj, (ParametersHolder) obj2);
            }
        };
        SingleInstanceFactory singleInstanceFactory8 = new SingleInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(WebsiteProfileRelationDao.class), null, function28, kind, CollectionsKt.emptyList()));
        module.f(singleInstanceFactory8);
        if (module.e()) {
            module.g(singleInstanceFactory8);
        }
        new KoinDefinition(module, singleInstanceFactory8);
        Function2 function29 = new Function2() { // from class: q0.p1
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return AppModuleKt.B2((Scope) obj, (ParametersHolder) obj2);
            }
        };
        SingleInstanceFactory singleInstanceFactory9 = new SingleInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(GeoAddressDao.class), null, function29, kind, CollectionsKt.emptyList()));
        module.f(singleInstanceFactory9);
        if (module.e()) {
            module.g(singleInstanceFactory9);
        }
        new KoinDefinition(module, singleInstanceFactory9);
        Function2 function210 = new Function2() { // from class: q0.q1
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return AppModuleKt.C2((Scope) obj, (ParametersHolder) obj2);
            }
        };
        SingleInstanceFactory singleInstanceFactory10 = new SingleInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(WifiNetworkDao.class), null, function210, kind, CollectionsKt.emptyList()));
        module.f(singleInstanceFactory10);
        if (module.e()) {
            module.g(singleInstanceFactory10);
        }
        new KoinDefinition(module, singleInstanceFactory10);
        Function2 function211 = new Function2() { // from class: q0.u0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return AppModuleKt.j2((Scope) obj, (ParametersHolder) obj2);
            }
        };
        SingleInstanceFactory singleInstanceFactory11 = new SingleInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(IntervalDao.class), null, function211, kind, CollectionsKt.emptyList()));
        module.f(singleInstanceFactory11);
        if (module.e()) {
            module.g(singleInstanceFactory11);
        }
        new KoinDefinition(module, singleInstanceFactory11);
        Function2 function212 = new Function2() { // from class: q0.v0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return AppModuleKt.k2((Scope) obj, (ParametersHolder) obj2);
            }
        };
        SingleInstanceFactory singleInstanceFactory12 = new SingleInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(UsageLimitDao.class), null, function212, kind, CollectionsKt.emptyList()));
        module.f(singleInstanceFactory12);
        if (module.e()) {
            module.g(singleInstanceFactory12);
        }
        new KoinDefinition(module, singleInstanceFactory12);
        Function2 function213 = new Function2() { // from class: q0.w0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return AppModuleKt.l2((Scope) obj, (ParametersHolder) obj2);
            }
        };
        SingleInstanceFactory singleInstanceFactory13 = new SingleInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(ProfileDao.class), null, function213, kind, CollectionsKt.emptyList()));
        module.f(singleInstanceFactory13);
        if (module.e()) {
            module.g(singleInstanceFactory13);
        }
        new KoinDefinition(module, singleInstanceFactory13);
        Function2 function214 = new Function2() { // from class: q0.x0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return AppModuleKt.m2((Scope) obj, (ParametersHolder) obj2);
            }
        };
        SingleInstanceFactory singleInstanceFactory14 = new SingleInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(AdultContentWebsiteDao.class), null, function214, kind, CollectionsKt.emptyList()));
        module.f(singleInstanceFactory14);
        if (module.e()) {
            module.g(singleInstanceFactory14);
        }
        new KoinDefinition(module, singleInstanceFactory14);
        Function2 function215 = new Function2() { // from class: q0.y0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return AppModuleKt.n2((Scope) obj, (ParametersHolder) obj2);
            }
        };
        SingleInstanceFactory singleInstanceFactory15 = new SingleInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(SchedulePauseHistoryDao.class), null, function215, kind, CollectionsKt.emptyList()));
        module.f(singleInstanceFactory15);
        if (module.e()) {
            module.g(singleInstanceFactory15);
        }
        new KoinDefinition(module, singleInstanceFactory15);
        Function2 function216 = new Function2() { // from class: q0.z0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return AppModuleKt.o2((Scope) obj, (ParametersHolder) obj2);
            }
        };
        SingleInstanceFactory singleInstanceFactory16 = new SingleInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(QuickBlockTimerHistoryDao.class), null, function216, kind, CollectionsKt.emptyList()));
        module.f(singleInstanceFactory16);
        if (module.e()) {
            module.g(singleInstanceFactory16);
        }
        new KoinDefinition(module, singleInstanceFactory16);
        Function2 function217 = new Function2() { // from class: q0.a1
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return AppModuleKt.p2((Scope) obj, (ParametersHolder) obj2);
            }
        };
        SingleInstanceFactory singleInstanceFactory17 = new SingleInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(PomodoroHistoryDao.class), null, function217, kind, CollectionsKt.emptyList()));
        module.f(singleInstanceFactory17);
        if (module.e()) {
            module.g(singleInstanceFactory17);
        }
        new KoinDefinition(module, singleInstanceFactory17);
        Function2 function218 = new Function2() { // from class: q0.b1
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return AppModuleKt.q2((Scope) obj, (ParametersHolder) obj2);
            }
        };
        SingleInstanceFactory singleInstanceFactory18 = new SingleInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(PomodoroSessionDao.class), null, function218, kind, CollectionsKt.emptyList()));
        module.f(singleInstanceFactory18);
        if (module.e()) {
            module.g(singleInstanceFactory18);
        }
        new KoinDefinition(module, singleInstanceFactory18);
        Function2 function219 = new Function2() { // from class: q0.c1
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return AppModuleKt.r2((Scope) obj, (ParametersHolder) obj2);
            }
        };
        SingleInstanceFactory singleInstanceFactory19 = new SingleInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(SubAppRelationDao.class), null, function219, kind, CollectionsKt.emptyList()));
        module.f(singleInstanceFactory19);
        if (module.e()) {
            module.g(singleInstanceFactory19);
        }
        new KoinDefinition(module, singleInstanceFactory19);
        Function2 function220 = new Function2() { // from class: q0.e1
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return AppModuleKt.s2((Scope) obj, (ParametersHolder) obj2);
            }
        };
        SingleInstanceFactory singleInstanceFactory20 = new SingleInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(StreakDayDao.class), null, function220, kind, CollectionsKt.emptyList()));
        module.f(singleInstanceFactory20);
        if (module.e()) {
            module.g(singleInstanceFactory20);
        }
        new KoinDefinition(module, singleInstanceFactory20);
        Function2 function221 = new Function2() { // from class: q0.g1
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return AppModuleKt.u2((Scope) obj, (ParametersHolder) obj2);
            }
        };
        SingleInstanceFactory singleInstanceFactory21 = new SingleInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(StreakActivitySessionDao.class), null, function221, kind, CollectionsKt.emptyList()));
        module.f(singleInstanceFactory21);
        if (module.e()) {
            module.g(singleInstanceFactory21);
        }
        new KoinDefinition(module, singleInstanceFactory21);
        Function2 function222 = new Function2() { // from class: q0.h1
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return AppModuleKt.v2((Scope) obj, (ParametersHolder) obj2);
            }
        };
        SingleInstanceFactory singleInstanceFactory22 = new SingleInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(StreakPauseRecordDao.class), null, function222, kind, CollectionsKt.emptyList()));
        module.f(singleInstanceFactory22);
        if (module.e()) {
            module.g(singleInstanceFactory22);
        }
        new KoinDefinition(module, singleInstanceFactory22);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final JobHelperKtx g3(Scope single, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it, "it");
        return new JobHelperKtx((IntervalDao) single.e(Reflection.b(IntervalDao.class), null, null), (ProfileDao) single.e(Reflection.b(ProfileDao.class), null, null), (EventDataStore) single.e(Reflection.b(EventDataStore.class), null, null), (DevDataStore) single.e(Reflection.b(DevDataStore.class), null, null), (NotificationDataStore) single.e(Reflection.b(NotificationDataStore.class), null, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CalculateYearlySavingsUseCase g4(Scope factory, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(factory, "$this$factory");
        Intrinsics.checkNotNullParameter(it, "it");
        return new CalculateYearlySavingsUseCase();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StreakDailyPresenter g5(Scope single, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it, "it");
        return new StreakDailyPresenter((StreakStore) single.e(Reflection.b(StreakStore.class), null, null), (StreakDataStore) single.e(Reflection.b(StreakDataStore.class), null, null), (StreakAvailability) single.e(Reflection.b(StreakAvailability.class), null, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BlockingDatabase h2(Scope single, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it, "it");
        return (BlockingDatabase) Room.a(ModuleExtKt.a(single), BlockingDatabase.class, "blocking.db").e().b(BlockingMigrationsKt.i(), BlockingMigrationsKt.n(), BlockingMigrationsKt.o(), BlockingMigrationsKt.p(), BlockingMigrationsKt.q(), BlockingMigrationsKt.r(), BlockingMigrationsKt.s(), BlockingMigrationsKt.a(), BlockingMigrationsKt.b(), BlockingMigrationsKt.c(), BlockingMigrationsKt.d(), BlockingMigrationsKt.e(), BlockingMigrationsKt.f(), BlockingMigrationsKt.g(), BlockingMigrationsKt.h(), BlockingMigrationsKt.j(), BlockingMigrationsKt.k(), BlockingMigrationsKt.l(), BlockingMigrationsKt.m()).d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AccountabilityPartnerRepository h3(Scope single, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it, "it");
        return new AccountabilityPartnerRepository();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DeterminePremiumStateUseCase h4(Scope single, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it, "it");
        return new DeterminePremiumStateUseCase();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StreakDebugHelper h5(Scope single, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it, "it");
        return new StreakDebugHelper((StreakDayDao) single.e(Reflection.b(StreakDayDao.class), null, null), (StreakActivitySessionDao) single.e(Reflection.b(StreakActivitySessionDao.class), null, null), (StreakPauseRecordDao) single.e(Reflection.b(StreakPauseRecordDao.class), null, null), (StreakDataStore) single.e(Reflection.b(StreakDataStore.class), null, null), (StreakEvaluator) single.e(Reflection.b(StreakEvaluator.class), null, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AppWebsiteCategoryDao i2(Scope single, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it, "it");
        return ((BlockingDatabase) single.e(Reflection.b(BlockingDatabase.class), null, null)).o();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ApprovalRepository i3(Scope single, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it, "it");
        return new ApprovalRepository((Application) single.e(Reflection.b(Application.class), null, null), 0L, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TrialConversionGuardUseCase i4(Scope factory, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(factory, "$this$factory");
        Intrinsics.checkNotNullParameter(it, "it");
        return new TrialConversionGuardUseCase();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StreakStore i5(Scope single, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it, "it");
        return new StreakStore((StreakRepository) single.e(Reflection.b(StreakRepository.class), null, null), (StreakPauseRecordDao) single.e(Reflection.b(StreakPauseRecordDao.class), null, null), (StreakEvaluator) single.e(Reflection.b(StreakEvaluator.class), null, null), (StreakActivityRepository) single.e(Reflection.b(StreakActivityRepository.class), null, null), (StreakDataStore) single.e(Reflection.b(StreakDataStore.class), null, null), (StreakAvailability) single.e(Reflection.b(StreakAvailability.class), null, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IntervalDao j2(Scope single, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it, "it");
        return ((BlockingDatabase) single.e(Reflection.b(BlockingDatabase.class), null, null)).v();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SubAppRepository j3(Scope single, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it, "it");
        return new SubAppRepository();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final GetBackupSettingsUseCase j4(Scope single, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it, "it");
        return new GetBackupSettingsUseCase();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StreakApiRepository j5(Scope single, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it, "it");
        return new StreakApiRepository();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final UsageLimitDao k2(Scope single, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it, "it");
        return ((BlockingDatabase) single.e(Reflection.b(BlockingDatabase.class), null, null)).F();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ConsentHelper k3(Scope single, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it, "it");
        return new ConsentHelper();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final GetBackupProfilesUseCase k4(Scope single, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it, "it");
        return new GetBackupProfilesUseCase();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StreakSnapshotSync k5(Scope single, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it, "it");
        return new StreakSnapshotSync((StreakStore) single.e(Reflection.b(StreakStore.class), null, null), (StreakRepository) single.e(Reflection.b(StreakRepository.class), null, null), (StreakDataStore) single.e(Reflection.b(StreakDataStore.class), null, null), (StreakApiRepository) single.e(Reflection.b(StreakApiRepository.class), null, null), (StreakAvailability) single.e(Reflection.b(StreakAvailability.class), null, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ProfileDao l2(Scope single, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it, "it");
        return ((BlockingDatabase) single.e(Reflection.b(BlockingDatabase.class), null, null)).y();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PassCodeManager l3(Scope single, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it, "it");
        return new PassCodeManager((LockieApplication) single.e(Reflection.b(LockieApplication.class), null, null), (PassCodeDataStore) single.e(Reflection.b(PassCodeDataStore.class), null, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final GetBackupStrictModeUseCase l4(Scope single, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it, "it");
        return new GetBackupStrictModeUseCase();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final RestoreRevenueCatPurchaseUseCase l5(Scope single, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it, "it");
        return new RestoreRevenueCatPurchaseUseCase((Context) single.e(Reflection.b(Context.class), null, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AdultContentWebsiteDao m2(Scope single, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it, "it");
        return ((BlockingDatabase) single.e(Reflection.b(BlockingDatabase.class), null, null)).n();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StrictModeRepository m3(Scope single, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it, "it");
        return new StrictModeRepository((StrictModeDataStore) single.e(Reflection.b(StrictModeDataStore.class), null, null), (ProfileDao) single.e(Reflection.b(ProfileDao.class), null, null), null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StatisticsPermissionsUseCase m4(Scope single, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it, "it");
        return new StatisticsPermissionsUseCase((Context) single.e(Reflection.b(Context.class), null, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final GetTimeNudgeAppsUseCase m5(Scope single, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it, "it");
        return new GetTimeNudgeAppsUseCase(null, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SchedulePauseHistoryDao n2(Scope single, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it, "it");
        return ((BlockingDatabase) single.e(Reflection.b(BlockingDatabase.class), null, null)).A();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DiscountRepository n3(Scope single, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it, "it");
        return new DiscountRepository((Context) single.e(Reflection.b(Context.class), null, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final GetBackupStatisticsUseCase n4(Scope single, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it, "it");
        return new GetBackupStatisticsUseCase();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final QuickBlockTimerHistoryDao o2(Scope single, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it, "it");
        return ((BlockingDatabase) single.e(Reflection.b(BlockingDatabase.class), null, null)).z();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PremiumStateChangeReactor o3(Scope single, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it, "it");
        return new PremiumStateChangeReactor();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final GetBackupHistoryUseCase o4(Scope single, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it, "it");
        return new GetBackupHistoryUseCase();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PomodoroHistoryDao p2(Scope single, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it, "it");
        return ((BlockingDatabase) single.e(Reflection.b(BlockingDatabase.class), null, null)).w();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DiagnosticRepository p3(Scope single, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it, "it");
        return new DiagnosticRepository((ProfileDao) single.e(Reflection.b(ProfileDao.class), null, null), (ApplicationDao) single.e(Reflection.b(ApplicationDao.class), null, null), (StrictModeDataStore) single.e(Reflection.b(StrictModeDataStore.class), null, null), (CoreMultiProcessDataStore) single.e(Reflection.b(CoreMultiProcessDataStore.class), null, null), (CoreDataStore) single.e(Reflection.b(CoreDataStore.class), null, null), (PremiumRepositoryV2) single.e(Reflection.b(PremiumRepositoryV2.class), null, null), (StrictModeRepository) single.e(Reflection.b(StrictModeRepository.class), null, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final GetApplicationStateWithSubAppsUseCase p4(Scope single, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it, "it");
        return new GetApplicationStateWithSubAppsUseCase();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PomodoroSessionDao q2(Scope single, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it, "it");
        return ((BlockingDatabase) single.e(Reflection.b(BlockingDatabase.class), null, null)).x();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TrialUpsellManager q3(Scope single, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it, "it");
        return new TrialUpsellManager((DiscountDataStore) single.e(Reflection.b(DiscountDataStore.class), null, null), (DevDataStore) single.e(Reflection.b(DevDataStore.class), null, null), (CoreDataStore) single.e(Reflection.b(CoreDataStore.class), null, null), (Context) single.e(Reflection.b(Context.class), null, null), (PremiumRepositoryV2) single.e(Reflection.b(PremiumRepositoryV2.class), null, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final RestoreSettingsUseCase q4(Scope single, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it, "it");
        return new RestoreSettingsUseCase();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SubAppRelationDao r2(Scope single, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it, "it");
        return ((BlockingDatabase) single.e(Reflection.b(BlockingDatabase.class), null, null)).E();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PremiumRepositoryV2 r3(Scope single, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it, "it");
        return new PremiumRepositoryV2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final RestoreStatisticsUseCase r4(Scope single, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it, "it");
        return new RestoreStatisticsUseCase();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StreakDayDao s2(Scope single, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it, "it");
        return ((BlockingDatabase) single.e(Reflection.b(BlockingDatabase.class), null, null)).C();
    }

    public static final List s3() {
        return f96882g;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final RestoreHistoryUseCase s4(Scope single, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it, "it");
        return new RestoreHistoryUseCase();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BlockedNotificationDao t2(Scope single, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it, "it");
        return ((BlockingDatabase) single.e(Reflection.b(BlockingDatabase.class), null, null)).s();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit t3(Module module) {
        Intrinsics.checkNotNullParameter(module, "$this$module");
        Function2 function2 = new Function2() { // from class: q0.r0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return AppModuleKt.u3((Scope) obj, (ParametersHolder) obj2);
            }
        };
        SingleInstanceFactory singleInstanceFactory = new SingleInstanceFactory(new BeanDefinition(ScopeRegistry.f146057e.a(), Reflection.b(GreendaoDatabase.class), null, function2, Kind.Singleton, CollectionsKt.emptyList()));
        module.f(singleInstanceFactory);
        if (module.e()) {
            module.g(singleInstanceFactory);
        }
        new KoinDefinition(module, singleInstanceFactory);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final RestoreStrictModeUseCase t4(Scope single, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it, "it");
        return new RestoreStrictModeUseCase();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StreakActivitySessionDao u2(Scope single, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it, "it");
        return ((BlockingDatabase) single.e(Reflection.b(BlockingDatabase.class), null, null)).B();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final GreendaoDatabase u3(Scope single, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it, "it");
        GreendaoUtils greendaoUtils = GreendaoUtils.f124809a;
        SQLiteDatabase sQLiteDatabaseA = greendaoUtils.h((Context) single.e(Reflection.b(Context.class), null, null), false).a();
        if (sQLiteDatabaseA != null && greendaoUtils.a(sQLiteDatabaseA)) {
            greendaoUtils.i(sQLiteDatabaseA);
        }
        return greendaoUtils.h((Context) single.e(Reflection.b(Context.class), null, null), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CreateIntervalsUseCase u4(Scope single, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it, "it");
        return new CreateIntervalsUseCase((Context) single.e(Reflection.b(Context.class), null, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StreakPauseRecordDao v2(Scope single, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it, "it");
        return ((BlockingDatabase) single.e(Reflection.b(BlockingDatabase.class), null, null)).D();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit v3(Module module) {
        Intrinsics.checkNotNullParameter(module, "$this$module");
        Function2 function2 = new Function2() { // from class: q0.h
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return AppModuleKt.w3((Scope) obj, (ParametersHolder) obj2);
            }
        };
        ScopeRegistry.Companion companion = ScopeRegistry.f146057e;
        StringQualifier stringQualifierA = companion.a();
        Kind kind = Kind.Singleton;
        SingleInstanceFactory singleInstanceFactory = new SingleInstanceFactory(new BeanDefinition(stringQualifierA, Reflection.b(CoreDataStore.class), null, function2, kind, CollectionsKt.emptyList()));
        module.f(singleInstanceFactory);
        if (module.e()) {
            module.g(singleInstanceFactory);
        }
        new KoinDefinition(module, singleInstanceFactory);
        Function2 function22 = new Function2() { // from class: q0.r
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return AppModuleKt.x3((Scope) obj, (ParametersHolder) obj2);
            }
        };
        SingleInstanceFactory singleInstanceFactory2 = new SingleInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(CoreMultiProcessDataStore.class), null, function22, kind, CollectionsKt.emptyList()));
        module.f(singleInstanceFactory2);
        if (module.e()) {
            module.g(singleInstanceFactory2);
        }
        new KoinDefinition(module, singleInstanceFactory2);
        Function2 function23 = new Function2() { // from class: q0.s
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return AppModuleKt.G3((Scope) obj, (ParametersHolder) obj2);
            }
        };
        SingleInstanceFactory singleInstanceFactory3 = new SingleInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(StreakDataStore.class), null, function23, kind, CollectionsKt.emptyList()));
        module.f(singleInstanceFactory3);
        if (module.e()) {
            module.g(singleInstanceFactory3);
        }
        new KoinDefinition(module, singleInstanceFactory3);
        Function2 function24 = new Function2() { // from class: q0.t
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return AppModuleKt.H3((Scope) obj, (ParametersHolder) obj2);
            }
        };
        SingleInstanceFactory singleInstanceFactory4 = new SingleInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(StrictModeDataStore.class), null, function24, kind, CollectionsKt.emptyList()));
        module.f(singleInstanceFactory4);
        if (module.e()) {
            module.g(singleInstanceFactory4);
        }
        new KoinDefinition(module, singleInstanceFactory4);
        Function2 function25 = new Function2() { // from class: q0.u
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return AppModuleKt.I3((Scope) obj, (ParametersHolder) obj2);
            }
        };
        SingleInstanceFactory singleInstanceFactory5 = new SingleInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(RatingDataStore.class), null, function25, kind, CollectionsKt.emptyList()));
        module.f(singleInstanceFactory5);
        if (module.e()) {
            module.g(singleInstanceFactory5);
        }
        new KoinDefinition(module, singleInstanceFactory5);
        Function2 function26 = new Function2() { // from class: q0.v
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return AppModuleKt.J3((Scope) obj, (ParametersHolder) obj2);
            }
        };
        SingleInstanceFactory singleInstanceFactory6 = new SingleInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(QuickBlockDataStore.class), null, function26, kind, CollectionsKt.emptyList()));
        module.f(singleInstanceFactory6);
        if (module.e()) {
            module.g(singleInstanceFactory6);
        }
        new KoinDefinition(module, singleInstanceFactory6);
        Function2 function27 = new Function2() { // from class: q0.x
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return AppModuleKt.K3((Scope) obj, (ParametersHolder) obj2);
            }
        };
        SingleInstanceFactory singleInstanceFactory7 = new SingleInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(SessionDataStore.class), null, function27, kind, CollectionsKt.emptyList()));
        module.f(singleInstanceFactory7);
        if (module.e()) {
            module.g(singleInstanceFactory7);
        }
        new KoinDefinition(module, singleInstanceFactory7);
        Function2 function28 = new Function2() { // from class: q0.y
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return AppModuleKt.L3((Scope) obj, (ParametersHolder) obj2);
            }
        };
        SingleInstanceFactory singleInstanceFactory8 = new SingleInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(StatisticsDataStore.class), null, function28, kind, CollectionsKt.emptyList()));
        module.f(singleInstanceFactory8);
        if (module.e()) {
            module.g(singleInstanceFactory8);
        }
        new KoinDefinition(module, singleInstanceFactory8);
        Function2 function29 = new Function2() { // from class: q0.z
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return AppModuleKt.M3((Scope) obj, (ParametersHolder) obj2);
            }
        };
        SingleInstanceFactory singleInstanceFactory9 = new SingleInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(DevDataStore.class), null, function29, kind, CollectionsKt.emptyList()));
        module.f(singleInstanceFactory9);
        if (module.e()) {
            module.g(singleInstanceFactory9);
        }
        new KoinDefinition(module, singleInstanceFactory9);
        Function2 function210 = new Function2() { // from class: q0.a0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return AppModuleKt.N3((Scope) obj, (ParametersHolder) obj2);
            }
        };
        SingleInstanceFactory singleInstanceFactory10 = new SingleInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(UserTestingDataStore.class), null, function210, kind, CollectionsKt.emptyList()));
        module.f(singleInstanceFactory10);
        if (module.e()) {
            module.g(singleInstanceFactory10);
        }
        new KoinDefinition(module, singleInstanceFactory10);
        Function2 function211 = new Function2() { // from class: q0.i
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return AppModuleKt.y3((Scope) obj, (ParametersHolder) obj2);
            }
        };
        SingleInstanceFactory singleInstanceFactory11 = new SingleInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(DiscountDataStore.class), null, function211, kind, CollectionsKt.emptyList()));
        module.f(singleInstanceFactory11);
        if (module.e()) {
            module.g(singleInstanceFactory11);
        }
        new KoinDefinition(module, singleInstanceFactory11);
        Function2 function212 = new Function2() { // from class: q0.j
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return AppModuleKt.z3((Scope) obj, (ParametersHolder) obj2);
            }
        };
        SingleInstanceFactory singleInstanceFactory12 = new SingleInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(InAppUpdatesDataStore.class), null, function212, kind, CollectionsKt.emptyList()));
        module.f(singleInstanceFactory12);
        if (module.e()) {
            module.g(singleInstanceFactory12);
        }
        new KoinDefinition(module, singleInstanceFactory12);
        Function2 function213 = new Function2() { // from class: q0.k
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return AppModuleKt.A3((Scope) obj, (ParametersHolder) obj2);
            }
        };
        SingleInstanceFactory singleInstanceFactory13 = new SingleInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(NotificationDataStore.class), null, function213, kind, CollectionsKt.emptyList()));
        module.f(singleInstanceFactory13);
        if (module.e()) {
            module.g(singleInstanceFactory13);
        }
        new KoinDefinition(module, singleInstanceFactory13);
        Function2 function214 = new Function2() { // from class: q0.m
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return AppModuleKt.B3((Scope) obj, (ParametersHolder) obj2);
            }
        };
        SingleInstanceFactory singleInstanceFactory14 = new SingleInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(PassCodeDataStore.class), null, function214, kind, CollectionsKt.emptyList()));
        module.f(singleInstanceFactory14);
        if (module.e()) {
            module.g(singleInstanceFactory14);
        }
        new KoinDefinition(module, singleInstanceFactory14);
        Function2 function215 = new Function2() { // from class: q0.n
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return AppModuleKt.C3((Scope) obj, (ParametersHolder) obj2);
            }
        };
        SingleInstanceFactory singleInstanceFactory15 = new SingleInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(DirectBootDataStore.class), null, function215, kind, CollectionsKt.emptyList()));
        module.f(singleInstanceFactory15);
        if (module.e()) {
            module.g(singleInstanceFactory15);
        }
        new KoinDefinition(module, singleInstanceFactory15);
        Function2 function216 = new Function2() { // from class: q0.o
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return AppModuleKt.D3((Scope) obj, (ParametersHolder) obj2);
            }
        };
        SingleInstanceFactory singleInstanceFactory16 = new SingleInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(EventDataStore.class), null, function216, kind, CollectionsKt.emptyList()));
        module.f(singleInstanceFactory16);
        if (module.e()) {
            module.g(singleInstanceFactory16);
        }
        new KoinDefinition(module, singleInstanceFactory16);
        Function2 function217 = new Function2() { // from class: q0.p
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return AppModuleKt.E3((Scope) obj, (ParametersHolder) obj2);
            }
        };
        SingleInstanceFactory singleInstanceFactory17 = new SingleInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(PaywallDataStore.class), null, function217, kind, CollectionsKt.emptyList()));
        module.f(singleInstanceFactory17);
        if (module.e()) {
            module.g(singleInstanceFactory17);
        }
        new KoinDefinition(module, singleInstanceFactory17);
        Function2 function218 = new Function2() { // from class: q0.q
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return AppModuleKt.F3((Scope) obj, (ParametersHolder) obj2);
            }
        };
        SingleInstanceFactory singleInstanceFactory18 = new SingleInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(TrialConversionDataStore.class), null, function218, kind, CollectionsKt.emptyList()));
        module.f(singleInstanceFactory18);
        if (module.e()) {
            module.g(singleInstanceFactory18);
        }
        new KoinDefinition(module, singleInstanceFactory18);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FetchGraphDataUseCase v4(Scope single, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it, "it");
        return new FetchGraphDataUseCase((Context) single.e(Reflection.b(Context.class), null, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BlockSessionDao w2(Scope single, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it, "it");
        return ((BlockingDatabase) single.e(Reflection.b(BlockingDatabase.class), null, null)).r();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final CoreDataStore w3(Scope single, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it, "it");
        return new CoreDataStore((Context) single.e(Reflection.b(Context.class), null, null), null, 2, 0 == true ? 1 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MigrateStatisticsToInsightsUseCase w4(Scope single, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it, "it");
        return new MigrateStatisticsToInsightsUseCase((Context) single.e(Reflection.b(Context.class), null, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BrowserViewIdDao x2(Scope single, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it, "it");
        return ((BlockingDatabase) single.e(Reflection.b(BlockingDatabase.class), null, null)).t();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CoreMultiProcessDataStore x3(Scope single, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it, "it");
        return new CoreMultiProcessDataStore((Context) single.e(Reflection.b(Context.class), null, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SupportJsonParseUseCase x4(Scope single, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it, "it");
        return new SupportJsonParseUseCase((Context) single.e(Reflection.b(Context.class), null, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ApplicationDao y2(Scope single, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it, "it");
        return ((BlockingDatabase) single.e(Reflection.b(BlockingDatabase.class), null, null)).p();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DiscountDataStore y3(Scope single, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it, "it");
        return new DiscountDataStore((Context) single.e(Reflection.b(Context.class), null, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FetchBlockingSessionsUseCase y4(Scope single, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it, "it");
        return new FetchBlockingSessionsUseCase((BlockSessionDao) single.e(Reflection.b(BlockSessionDao.class), null, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ApplicationProfileRelationDao z2(Scope single, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it, "it");
        return ((BlockingDatabase) single.e(Reflection.b(BlockingDatabase.class), null, null)).q();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InAppUpdatesDataStore z3(Scope single, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it, "it");
        return new InAppUpdatesDataStore((Context) single.e(Reflection.b(Context.class), null, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FetchTrialSummaryUseCase z4(Scope single, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it, "it");
        return new FetchTrialSummaryUseCase((IgnoredStatisticsItemDao) single.e(Reflection.b(IgnoredStatisticsItemDao.class), null, null), (BlockSessionDao) single.e(Reflection.b(BlockSessionDao.class), null, null), (DevDataStore) single.e(Reflection.b(DevDataStore.class), null, null), (PremiumRepositoryV2) single.e(Reflection.b(PremiumRepositoryV2.class), null, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StreakNudgePlanner f5(Scope scope, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(scope, HcgZcEUYo.SjmQSpHuIxLsS);
        Intrinsics.checkNotNullParameter(it, "it");
        return new StreakNudgePlanner((StreakStore) scope.e(Reflection.b(StreakStore.class), null, null), (StreakEvaluator) scope.e(Reflection.b(StreakEvaluator.class), null, null), (NotificationDataStore) scope.e(Reflection.b(NotificationDataStore.class), null, null), (StreakAvailability) scope.e(Reflection.b(StreakAvailability.class), null, null), (ProfileDao) scope.e(Reflection.b(ProfileDao.class), null, null));
    }
}
