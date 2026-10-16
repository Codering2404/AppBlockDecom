package cz.mobilesoft.coreblock.repository;

import android.content.Context;
import androidx.room.RoomDatabaseKt;
import cz.mobilesoft.coreblock.scene.schedule.ApplicationDTO;
import cz.mobilesoft.coreblock.scene.schedule.KeywordDTO;
import cz.mobilesoft.coreblock.scene.schedule.WebsiteDTO;
import cz.mobilesoft.coreblock.scene.schedule.condition.IntervalDTO;
import cz.mobilesoft.coreblock.scene.streaks.StreakActivityTracker;
import cz.mobilesoft.coreblock.storage.datastore.CoreDataStore;
import cz.mobilesoft.coreblock.storage.datastore.EventDataStore;
import cz.mobilesoft.coreblock.storage.datastore.QuickBlockDataStore;
import cz.mobilesoft.coreblock.storage.datastore.StrictModeDataStore;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.ApplicationDao;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.ApplicationProfileRelationDao;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.BrowserViewIdDao;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.GeoAddressDao;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.IntervalDao;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.SubAppRelationDao;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.UsageLimitDao;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.WebsiteProfileRelationDao;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.WifiNetworkDao;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.Application;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.Interval;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.WebsiteProfileRelation;
import cz.mobilesoft.coreblock.storage.room.management.BlockingDatabase;
import cz.mobilesoft.coreblock.util.runnability.JobHelperKtx;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class ScheduleRepository implements KoinComponent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ScheduleRepository f97962a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Lazy f97963b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Lazy f97964c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Lazy f97965d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Lazy f97966f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final Lazy f97967g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final Lazy f97968h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final Lazy f97969i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final Lazy f97970j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final Lazy f97971k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final Lazy f97972l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final Lazy f97973m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final Lazy f97974n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final Lazy f97975o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final Lazy f97976p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final Lazy f97977q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final Lazy f97978r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static final Lazy f97979s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private static final Lazy f97980t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static final Lazy f97981u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private static final Lazy f97982v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final int f97983w;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f97984a;

        static {
            int[] iArr = new int[WebsiteProfileRelation.BlockingType.values().length];
            try {
                iArr[WebsiteProfileRelation.BlockingType.KEYWORD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            f97984a = iArr;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        final ScheduleRepository scheduleRepository = new ScheduleRepository();
        f97962a = scheduleRepository;
        KoinPlatformTools koinPlatformTools = KoinPlatformTools.f146106a;
        LazyThreadSafetyMode lazyThreadSafetyModeB = koinPlatformTools.b();
        final Qualifier qualifier = null;
        final Object[] objArr = 0 == true ? 1 : 0;
        f97963b = LazyKt.a(lazyThreadSafetyModeB, new Function0<JobHelperKtx>() { // from class: cz.mobilesoft.coreblock.repository.ScheduleRepository$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = scheduleRepository;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(JobHelperKtx.class), qualifier, objArr);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB2 = koinPlatformTools.b();
        final Object[] objArr2 = 0 == true ? 1 : 0;
        final Object[] objArr3 = 0 == true ? 1 : 0;
        f97964c = LazyKt.a(lazyThreadSafetyModeB2, new Function0<StreakActivityTracker>() { // from class: cz.mobilesoft.coreblock.repository.ScheduleRepository$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = scheduleRepository;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(StreakActivityTracker.class), objArr2, objArr3);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB3 = koinPlatformTools.b();
        final Object[] objArr4 = 0 == true ? 1 : 0;
        final Object[] objArr5 = 0 == true ? 1 : 0;
        f97965d = LazyKt.a(lazyThreadSafetyModeB3, new Function0<BlockingDatabase>() { // from class: cz.mobilesoft.coreblock.repository.ScheduleRepository$special$$inlined$inject$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = scheduleRepository;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(BlockingDatabase.class), objArr4, objArr5);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB4 = koinPlatformTools.b();
        final Object[] objArr6 = 0 == true ? 1 : 0;
        final Object[] objArr7 = 0 == true ? 1 : 0;
        f97966f = LazyKt.a(lazyThreadSafetyModeB4, new Function0<ApplicationProfileRelationDao>() { // from class: cz.mobilesoft.coreblock.repository.ScheduleRepository$special$$inlined$inject$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = scheduleRepository;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(ApplicationProfileRelationDao.class), objArr6, objArr7);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB5 = koinPlatformTools.b();
        final Object[] objArr8 = 0 == true ? 1 : 0;
        final Object[] objArr9 = 0 == true ? 1 : 0;
        f97967g = LazyKt.a(lazyThreadSafetyModeB5, new Function0<WebsiteProfileRelationDao>() { // from class: cz.mobilesoft.coreblock.repository.ScheduleRepository$special$$inlined$inject$default$5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = scheduleRepository;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(WebsiteProfileRelationDao.class), objArr8, objArr9);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB6 = koinPlatformTools.b();
        final Object[] objArr10 = 0 == true ? 1 : 0;
        final Object[] objArr11 = 0 == true ? 1 : 0;
        f97968h = LazyKt.a(lazyThreadSafetyModeB6, new Function0<ApplicationDao>() { // from class: cz.mobilesoft.coreblock.repository.ScheduleRepository$special$$inlined$inject$default$6
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = scheduleRepository;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(ApplicationDao.class), objArr10, objArr11);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB7 = koinPlatformTools.b();
        final Object[] objArr12 = 0 == true ? 1 : 0;
        final Object[] objArr13 = 0 == true ? 1 : 0;
        f97969i = LazyKt.a(lazyThreadSafetyModeB7, new Function0<GeoAddressDao>() { // from class: cz.mobilesoft.coreblock.repository.ScheduleRepository$special$$inlined$inject$default$7
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = scheduleRepository;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(GeoAddressDao.class), objArr12, objArr13);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB8 = koinPlatformTools.b();
        final Object[] objArr14 = 0 == true ? 1 : 0;
        final Object[] objArr15 = 0 == true ? 1 : 0;
        f97970j = LazyKt.a(lazyThreadSafetyModeB8, new Function0<WifiNetworkDao>() { // from class: cz.mobilesoft.coreblock.repository.ScheduleRepository$special$$inlined$inject$default$8
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = scheduleRepository;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(WifiNetworkDao.class), objArr14, objArr15);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB9 = koinPlatformTools.b();
        final Object[] objArr16 = 0 == true ? 1 : 0;
        final Object[] objArr17 = 0 == true ? 1 : 0;
        f97971k = LazyKt.a(lazyThreadSafetyModeB9, new Function0<IntervalDao>() { // from class: cz.mobilesoft.coreblock.repository.ScheduleRepository$special$$inlined$inject$default$9
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = scheduleRepository;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(IntervalDao.class), objArr16, objArr17);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB10 = koinPlatformTools.b();
        final Object[] objArr18 = 0 == true ? 1 : 0;
        final Object[] objArr19 = 0 == true ? 1 : 0;
        f97972l = LazyKt.a(lazyThreadSafetyModeB10, new Function0<UsageLimitDao>() { // from class: cz.mobilesoft.coreblock.repository.ScheduleRepository$special$$inlined$inject$default$10
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = scheduleRepository;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(UsageLimitDao.class), objArr18, objArr19);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB11 = koinPlatformTools.b();
        final Object[] objArr20 = 0 == true ? 1 : 0;
        final Object[] objArr21 = 0 == true ? 1 : 0;
        f97973m = LazyKt.a(lazyThreadSafetyModeB11, new Function0<ProfileDao>() { // from class: cz.mobilesoft.coreblock.repository.ScheduleRepository$special$$inlined$inject$default$11
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = scheduleRepository;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(ProfileDao.class), objArr20, objArr21);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB12 = koinPlatformTools.b();
        final Object[] objArr22 = 0 == true ? 1 : 0;
        final Object[] objArr23 = 0 == true ? 1 : 0;
        f97974n = LazyKt.a(lazyThreadSafetyModeB12, new Function0<BrowserViewIdDao>() { // from class: cz.mobilesoft.coreblock.repository.ScheduleRepository$special$$inlined$inject$default$12
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = scheduleRepository;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(BrowserViewIdDao.class), objArr22, objArr23);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB13 = koinPlatformTools.b();
        final Object[] objArr24 = 0 == true ? 1 : 0;
        final Object[] objArr25 = 0 == true ? 1 : 0;
        f97975o = LazyKt.a(lazyThreadSafetyModeB13, new Function0<EventDataStore>() { // from class: cz.mobilesoft.coreblock.repository.ScheduleRepository$special$$inlined$inject$default$13
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = scheduleRepository;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(EventDataStore.class), objArr24, objArr25);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB14 = koinPlatformTools.b();
        final Object[] objArr26 = 0 == true ? 1 : 0;
        final Object[] objArr27 = 0 == true ? 1 : 0;
        f97976p = LazyKt.a(lazyThreadSafetyModeB14, new Function0<SubAppRelationDao>() { // from class: cz.mobilesoft.coreblock.repository.ScheduleRepository$special$$inlined$inject$default$14
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = scheduleRepository;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(SubAppRelationDao.class), objArr26, objArr27);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB15 = koinPlatformTools.b();
        final Object[] objArr28 = 0 == true ? 1 : 0;
        final Object[] objArr29 = 0 == true ? 1 : 0;
        f97977q = LazyKt.a(lazyThreadSafetyModeB15, new Function0<SubAppRepository>() { // from class: cz.mobilesoft.coreblock.repository.ScheduleRepository$special$$inlined$inject$default$15
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = scheduleRepository;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(SubAppRepository.class), objArr28, objArr29);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB16 = koinPlatformTools.b();
        final Object[] objArr30 = 0 == true ? 1 : 0;
        final Object[] objArr31 = 0 == true ? 1 : 0;
        f97978r = LazyKt.a(lazyThreadSafetyModeB16, new Function0<QuickBlockDataStore>() { // from class: cz.mobilesoft.coreblock.repository.ScheduleRepository$special$$inlined$inject$default$16
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = scheduleRepository;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(QuickBlockDataStore.class), objArr30, objArr31);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB17 = koinPlatformTools.b();
        final Object[] objArr32 = 0 == true ? 1 : 0;
        final Object[] objArr33 = 0 == true ? 1 : 0;
        f97979s = LazyKt.a(lazyThreadSafetyModeB17, new Function0<StrictModeDataStore>() { // from class: cz.mobilesoft.coreblock.repository.ScheduleRepository$special$$inlined$inject$default$17
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = scheduleRepository;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(StrictModeDataStore.class), objArr32, objArr33);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB18 = koinPlatformTools.b();
        final Object[] objArr34 = 0 == true ? 1 : 0;
        final Object[] objArr35 = 0 == true ? 1 : 0;
        f97980t = LazyKt.a(lazyThreadSafetyModeB18, new Function0<CoreDataStore>() { // from class: cz.mobilesoft.coreblock.repository.ScheduleRepository$special$$inlined$inject$default$18
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = scheduleRepository;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(CoreDataStore.class), objArr34, objArr35);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB19 = koinPlatformTools.b();
        final Object[] objArr36 = 0 == true ? 1 : 0;
        final Object[] objArr37 = 0 == true ? 1 : 0;
        f97981u = LazyKt.a(lazyThreadSafetyModeB19, new Function0<StrictModeRepository>() { // from class: cz.mobilesoft.coreblock.repository.ScheduleRepository$special$$inlined$inject$default$19
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = scheduleRepository;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(StrictModeRepository.class), objArr36, objArr37);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB20 = koinPlatformTools.b();
        final Object[] objArr38 = 0 == true ? 1 : 0;
        final Object[] objArr39 = 0 == true ? 1 : 0;
        f97982v = LazyKt.a(lazyThreadSafetyModeB20, new Function0<QuickBlockRepository>() { // from class: cz.mobilesoft.coreblock.repository.ScheduleRepository$special$$inlined$inject$default$20
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = scheduleRepository;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(QuickBlockRepository.class), objArr38, objArr39);
            }
        });
        f97983w = 8;
    }

    private ScheduleRepository() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final BrowserViewIdDao A() {
        return (BrowserViewIdDao) f97974n.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final EventDataStore B() {
        return (EventDataStore) f97975o.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final GeoAddressDao C() {
        return (GeoAddressDao) f97969i.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IntervalDao D() {
        return (IntervalDao) f97971k.getValue();
    }

    private final JobHelperKtx E() {
        return (JobHelperKtx) f97963b.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ProfileDao F() {
        return (ProfileDao) f97973m.getValue();
    }

    private final QuickBlockDataStore G() {
        return (QuickBlockDataStore) f97978r.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final QuickBlockRepository H() {
        return (QuickBlockRepository) f97982v.getValue();
    }

    private final StreakActivityTracker I() {
        return (StreakActivityTracker) f97964c.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final StrictModeDataStore J() {
        return (StrictModeDataStore) f97979s.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final StrictModeRepository K() {
        return (StrictModeRepository) f97981u.getValue();
    }

    private final SubAppRelationDao L() {
        return (SubAppRelationDao) f97976p.getValue();
    }

    private final SubAppRepository M() {
        return (SubAppRepository) f97977q.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final UsageLimitDao N() {
        return (UsageLimitDao) f97972l.getValue();
    }

    private final WebsiteProfileRelationDao O() {
        return (WebsiteProfileRelationDao) f97967g.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final WifiNetworkDao P() {
        return (WifiNetworkDao) f97970j.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean V(Application application, ApplicationDTO it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Intrinsics.areEqual(it.c(), application.d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean X(Interval interval, IntervalDTO it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.b() == interval.b() && it.a() == interval.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0235, code lost:
    
        if (r3.t(r12, r4) != r6) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x024b, code lost:
    
        if (r3.V(r0, 2, r4) == r6) goto L80;
     */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x017b  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01fe  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object Z(long r24, boolean r26, kotlin.coroutines.Continuation r27) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 612
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.repository.ScheduleRepository.Z(long, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x027d, code lost:
    
        if (r2.t(r7, r3) != r5) goto L59;
     */
    /* JADX WARN: Removed duplicated region for block: B:47:0x019e A[LOOP:0: B:45:0x0198->B:47:0x019e, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x01d5 A[LOOP:1: B:49:0x01cf->B:51:0x01d5, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x023a  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object b0(long r32, java.util.List r34, java.util.List r35, int r36, kotlin.coroutines.Continuation r37) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 643
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.repository.ScheduleRepository.b0(long, java.util.List, java.util.List, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean c0(WebsiteProfileRelation websiteProfileRelation, WebsiteDTO it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Intrinsics.areEqual(it.a(), websiteProfileRelation.c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean d0(WebsiteProfileRelation websiteProfileRelation, KeywordDTO it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Intrinsics.areEqual(it.a(), websiteProfileRelation.c()) && it.b() == websiteProfileRelation.e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00d3, code lost:
    
        if (r6.J(r2, r0) != r1) goto L36;
     */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0086 A[PHI: r5
      0x0086: PHI (r5v4 java.util.List) = (r5v1 java.util.List), (r5v6 java.util.List) binds: [B:22:0x0083, B:16:0x004d] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0099 A[PHI: r5
      0x0099: PHI (r5v7 java.util.List) = (r5v4 java.util.List), (r5v9 java.util.List) binds: [B:25:0x0096, B:15:0x0045] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00ac A[PHI: r5
      0x00ac: PHI (r5v10 java.util.List) = (r5v7 java.util.List), (r5v12 java.util.List) binds: [B:28:0x00a9, B:14:0x003d] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00bf A[PHI: r5
      0x00bf: PHI (r5v13 java.util.List) = (r5v10 java.util.List), (r5v18 java.util.List) binds: [B:31:0x00bc, B:13:0x0034] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object v(java.util.List r5, kotlin.coroutines.Continuation r6) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 236
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.repository.ScheduleRepository.v(java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ApplicationDao x() {
        return (ApplicationDao) f97968h.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ApplicationProfileRelationDao y() {
        return (ApplicationProfileRelationDao) f97966f.getValue();
    }

    private final BlockingDatabase z() {
        return (BlockingDatabase) f97965d.getValue();
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0103, code lost:
    
        if (r10.Z(r17, r1) != r3) goto L34;
     */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object Q(long r32, cz.mobilesoft.coreblock.scene.schedule.condition.IntervalDTO r34, kotlin.coroutines.Continuation r35) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 265
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.repository.ScheduleRepository.Q(long, cz.mobilesoft.coreblock.scene.schedule.condition.IntervalDTO, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0153, code lost:
    
        if (r0 == r3) goto L140;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x028e, code lost:
    
        if (r0 == r3) goto L140;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0370  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0383  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x03d9  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x043e  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0474  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x047c  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x04cd  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x04e5  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x01fd  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0203  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0212  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x023a  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0252  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0264  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x026d  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x02a5  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x02b0  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x02b5  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x02bc  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x02d1  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x030c  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x031d  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0328  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0337  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0342  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0355  */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v15 */
    /* JADX WARN: Type inference failed for: r4v16, types: [int] */
    /* JADX WARN: Type inference failed for: r4v20 */
    /* JADX WARN: Type inference failed for: r4v21, types: [int] */
    /* JADX WARN: Type inference failed for: r4v22, types: [int] */
    /* JADX WARN: Type inference failed for: r4v23, types: [int] */
    /* JADX WARN: Type inference failed for: r4v25 */
    /* JADX WARN: Type inference failed for: r4v39 */
    /* JADX WARN: Type inference failed for: r4v40 */
    /* JADX WARN: Type inference failed for: r4v41 */
    /* JADX WARN: Type inference failed for: r4v42 */
    /* JADX WARN: Type inference failed for: r4v43 */
    /* JADX WARN: Type inference failed for: r4v44 */
    /* JADX WARN: Type inference failed for: r4v45 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object R(cz.mobilesoft.coreblock.scene.schedule.ScheduleDTO r45, android.content.Context r46, java.lang.String r47, kotlin.coroutines.Continuation r48) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 1286
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.repository.ScheduleRepository.R(cz.mobilesoft.coreblock.scene.schedule.ScheduleDTO, android.content.Context, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x00a2, code lost:
    
        if (cz.mobilesoft.coreblock.scene.streaks.StreakActivityTracker.w(r1, 0, r4, 1, null) != r7) goto L35;
     */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object S(cz.mobilesoft.coreblock.enums.PremiumState r10, kotlin.coroutines.Continuation r11) throws java.lang.Throwable {
        /*
            r9 = this;
            boolean r0 = r11 instanceof cz.mobilesoft.coreblock.repository.ScheduleRepository$setPremiumContentEnabled$1
            if (r0 == 0) goto L14
            r0 = r11
            cz.mobilesoft.coreblock.repository.ScheduleRepository$setPremiumContentEnabled$1 r0 = (cz.mobilesoft.coreblock.repository.ScheduleRepository$setPremiumContentEnabled$1) r0
            int r1 = r0.f98057g
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.f98057g = r1
        L12:
            r4 = r0
            goto L1a
        L14:
            cz.mobilesoft.coreblock.repository.ScheduleRepository$setPremiumContentEnabled$1 r0 = new cz.mobilesoft.coreblock.repository.ScheduleRepository$setPremiumContentEnabled$1
            r0.<init>(r9, r11)
            goto L12
        L1a:
            java.lang.Object r11 = r4.f98055d
            java.lang.Object r7 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r0 = r4.f98057g
            r1 = 2
            r2 = 1
            if (r0 == 0) goto L51
            if (r0 == r2) goto L3b
            if (r0 != r1) goto L33
            java.lang.Object r10 = r4.f98052a
            cz.mobilesoft.coreblock.enums.PremiumState r10 = (cz.mobilesoft.coreblock.enums.PremiumState) r10
            kotlin.ResultKt.b(r11)
            goto La5
        L33:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L3b:
            boolean r10 = r4.f98054c
            boolean r2 = r4.f98053b
            java.lang.Object r0 = r4.f98052a
            r3 = r0
            cz.mobilesoft.coreblock.enums.PremiumState r3 = (cz.mobilesoft.coreblock.enums.PremiumState) r3
            kotlin.ResultKt.b(r11)     // Catch: java.lang.Exception -> L4b
            r8 = r3
            r3 = r10
            r10 = r8
            goto L81
        L4b:
            r0 = move-exception
            r11 = r0
            r8 = r3
            r3 = r10
            r10 = r8
            goto L86
        L51:
            kotlin.ResultKt.b(r11)
            cz.mobilesoft.coreblock.util.monetization.Capability r11 = cz.mobilesoft.coreblock.util.monetization.Capability.PremiumAccess
            boolean r11 = cz.mobilesoft.coreblock.util.monetization.AccessPolicyKt.a(r10, r11)
            boolean r3 = r10.g()
            if (r11 == 0) goto L63
            cz.mobilesoft.coreblock.repository.AcademyRepository.n()
        L63:
            cz.mobilesoft.coreblock.storage.room.management.BlockingDatabase r0 = r9.z()     // Catch: java.lang.Exception -> L83
            cz.mobilesoft.coreblock.repository.ScheduleRepository$setPremiumContentEnabled$2 r5 = new cz.mobilesoft.coreblock.repository.ScheduleRepository$setPremiumContentEnabled$2     // Catch: java.lang.Exception -> L83
            r6 = 0
            r5.<init>(r3, r11, r10, r6)     // Catch: java.lang.Exception -> L83
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.a(r10)     // Catch: java.lang.Exception -> L83
            r4.f98052a = r6     // Catch: java.lang.Exception -> L83
            r4.f98053b = r11     // Catch: java.lang.Exception -> L83
            r4.f98054c = r3     // Catch: java.lang.Exception -> L83
            r4.f98057g = r2     // Catch: java.lang.Exception -> L83
            java.lang.Object r0 = androidx.room.RoomDatabaseKt.g(r0, r5, r4)     // Catch: java.lang.Exception -> L83
            if (r0 != r7) goto L80
            goto La4
        L80:
            r2 = r11
        L81:
            r11 = r1
            goto L8a
        L83:
            r0 = move-exception
            r2 = r11
            r11 = r0
        L86:
            r11.printStackTrace()
            goto L81
        L8a:
            cz.mobilesoft.coreblock.scene.streaks.StreakActivityTracker r1 = r9.I()
            java.lang.Object r10 = kotlin.coroutines.jvm.internal.SpillingKt.a(r10)
            r4.f98052a = r10
            r4.f98053b = r2
            r4.f98054c = r3
            r4.f98057g = r11
            r2 = 0
            r5 = 1
            r6 = 0
            java.lang.Object r10 = cz.mobilesoft.coreblock.scene.streaks.StreakActivityTracker.w(r1, r2, r4, r5, r6)
            if (r10 != r7) goto La5
        La4:
            return r7
        La5:
            kotlin.Unit r10 = kotlin.Unit.f139807a
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.repository.ScheduleRepository.S(cz.mobilesoft.coreblock.enums.PremiumState, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0449  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x04b9  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x04d1  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0516 A[LOOP:2: B:127:0x0510->B:129:0x0516, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:133:0x055b A[LOOP:3: B:131:0x0555->B:133:0x055b, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:137:0x05b5  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x05de  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x0604  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x0650  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x0653  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x06b6  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x06c5  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x01f5  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0245  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x024e  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0276  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x027d  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0287  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0292  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x02b7  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x02d7  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x02da  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x02e7  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x030f  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x032f  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0332  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0340  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0381 A[LOOP:6: B:80:0x037b->B:82:0x0381, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x03a0  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x03d5  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0018  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x03fd A[LOOP:5: B:90:0x03f7->B:92:0x03fd, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0431  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object T(cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile r52, kotlin.coroutines.Continuation r53) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 1784
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.repository.ScheduleRepository.T(cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:45:0x019d, code lost:
    
        if (r7.t(r8, r3) == r5) goto L46;
     */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0149 A[LOOP:0: B:41:0x0143->B:43:0x0149, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object U(long r24, java.util.List r26, int r27, kotlin.coroutines.Continuation r28) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 419
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.repository.ScheduleRepository.U(long, java.util.List, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:47:0x0162, code lost:
    
        if (r14.h(r2, r0) != r1) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x01f1, code lost:
    
        if (r14.X(r11, r0) != r1) goto L72;
     */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01d6  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object W(long r11, java.util.List r13, kotlin.coroutines.Continuation r14) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 522
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.repository.ScheduleRepository.W(long, java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x00a2, code lost:
    
        if (r0.t(r2, r3) == r5) goto L26;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object Y(long r17, java.util.List r19, kotlin.coroutines.Continuation r20) throws java.lang.Throwable {
        /*
            r16 = this;
            r0 = r17
            r2 = r20
            boolean r3 = r2 instanceof cz.mobilesoft.coreblock.repository.ScheduleRepository$updateSubApps$1
            if (r3 == 0) goto L19
            r3 = r2
            cz.mobilesoft.coreblock.repository.ScheduleRepository$updateSubApps$1 r3 = (cz.mobilesoft.coreblock.repository.ScheduleRepository$updateSubApps$1) r3
            int r4 = r3.f98176f
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r6 = r4 & r5
            if (r6 == 0) goto L19
            int r4 = r4 - r5
            r3.f98176f = r4
            r4 = r16
            goto L20
        L19:
            cz.mobilesoft.coreblock.repository.ScheduleRepository$updateSubApps$1 r3 = new cz.mobilesoft.coreblock.repository.ScheduleRepository$updateSubApps$1
            r4 = r16
            r3.<init>(r4, r2)
        L20:
            java.lang.Object r2 = r3.f98174c
            java.lang.Object r5 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r6 = r3.f98176f
            r7 = 2
            r8 = 1
            if (r6 == 0) goto L4b
            if (r6 == r8) goto L40
            if (r6 != r7) goto L38
            java.lang.Object r0 = r3.f98173b
            java.util.List r0 = (java.util.List) r0
            kotlin.ResultKt.b(r2)
            goto La5
        L38:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L40:
            long r0 = r3.f98172a
            java.lang.Object r6 = r3.f98173b
            java.util.List r6 = (java.util.List) r6
            kotlin.ResultKt.b(r2)
        L49:
            r11 = r0
            goto L61
        L4b:
            kotlin.ResultKt.b(r2)
            cz.mobilesoft.coreblock.storage.room.dao.blocking.SubAppRelationDao r2 = r4.L()
            r6 = r19
            r3.f98173b = r6
            r3.f98172a = r0
            r3.f98176f = r8
            java.lang.Object r2 = r2.J(r0, r3)
            if (r2 != r5) goto L49
            goto La4
        L61:
            cz.mobilesoft.coreblock.storage.room.dao.blocking.SubAppRelationDao r0 = r4.L()
            r1 = r6
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.ArrayList r2 = new java.util.ArrayList
            r8 = 10
            int r8 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r1, r8)
            r2.<init>(r8)
            java.util.Iterator r1 = r1.iterator()
        L77:
            boolean r8 = r1.hasNext()
            if (r8 == 0) goto L94
            java.lang.Object r8 = r1.next()
            cz.mobilesoft.coreblock.repository.SubApp r8 = (cz.mobilesoft.coreblock.repository.SubApp) r8
            java.lang.String r13 = r8.getId()
            cz.mobilesoft.coreblock.storage.room.entity.blocking.SubAppRelation r8 = new cz.mobilesoft.coreblock.storage.room.entity.blocking.SubAppRelation
            r14 = 1
            r15 = 0
            r9 = 0
            r8.<init>(r9, r11, r13, r14, r15)
            r2.add(r8)
            goto L77
        L94:
            java.lang.Object r1 = kotlin.coroutines.jvm.internal.SpillingKt.a(r6)
            r3.f98173b = r1
            r3.f98172a = r11
            r3.f98176f = r7
            java.lang.Object r0 = r0.t(r2, r3)
            if (r0 != r5) goto La5
        La4:
            return r5
        La5:
            kotlin.Unit r0 = kotlin.Unit.f139807a
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.repository.ScheduleRepository.Y(long, java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object a0(Continuation continuation) {
        Object objG = RoomDatabaseKt.g(z(), new ScheduleRepository$updateUnsupportedBrowsersForAllProfiles$2(null), continuation);
        return objG == IntrinsicsKt.f() ? objG : Unit.f139807a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x0145, code lost:
    
        if (r0.t(r1, r3) == r5) goto L40;
     */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0104 A[LOOP:0: B:35:0x00fe->B:37:0x0104, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object e0(long r20, java.util.List r22, kotlin.coroutines.Continuation r23) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 331
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.repository.ScheduleRepository.e0(long, java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // org.koin.core.component.KoinComponent
    public /* bridge */ Koin r0() {
        return KoinComponent.DefaultImpls.a(this);
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x006c, code lost:
    
        if (r2.i1(r0) == r1) goto L25;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object t(kotlin.coroutines.Continuation r6) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r6 instanceof cz.mobilesoft.coreblock.repository.ScheduleRepository$checkAndRepairStrictModeProfileFollowSchedulesBug$1
            if (r0 == 0) goto L13
            r0 = r6
            cz.mobilesoft.coreblock.repository.ScheduleRepository$checkAndRepairStrictModeProfileFollowSchedulesBug$1 r0 = (cz.mobilesoft.coreblock.repository.ScheduleRepository$checkAndRepairStrictModeProfileFollowSchedulesBug$1) r0
            int r1 = r0.f97988d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f97988d = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.repository.ScheduleRepository$checkAndRepairStrictModeProfileFollowSchedulesBug$1 r0 = new cz.mobilesoft.coreblock.repository.ScheduleRepository$checkAndRepairStrictModeProfileFollowSchedulesBug$1
            r0.<init>(r5, r6)
        L18:
            java.lang.Object r6 = r0.f97986b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f97988d
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L38
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            kotlin.ResultKt.b(r6)
            goto L6f
        L2c:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L34:
            kotlin.ResultKt.b(r6)
            goto L4c
        L38:
            kotlin.ResultKt.b(r6)
            cz.mobilesoft.coreblock.storage.datastore.StrictModeDataStore r6 = r5.J()
            kotlinx.coroutines.flow.Flow r6 = r6.g0()
            r0.f97988d = r4
            java.lang.Object r6 = kotlinx.coroutines.flow.FlowKt.D(r6, r0)
            if (r6 != r1) goto L4c
            goto L6e
        L4c:
            java.util.List r6 = (java.util.List) r6
            cz.mobilesoft.coreblock.enums.StrictModeAccessMethod r2 = cz.mobilesoft.coreblock.enums.StrictModeAccessMethod.FollowSchedules
            boolean r6 = r6.contains(r2)
            if (r6 == 0) goto L72
            cz.mobilesoft.coreblock.repository.StrictModeRepository r2 = r5.K()
            boolean r2 = r2.n()
            if (r2 == 0) goto L72
            cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao r2 = r5.F()
            r0.f97985a = r6
            r0.f97988d = r3
            java.lang.Object r6 = r2.i1(r0)
            if (r6 != r1) goto L6f
        L6e:
            return r1
        L6f:
            kotlin.Unit r6 = kotlin.Unit.f139807a
            return r6
        L72:
            kotlin.Unit r6 = kotlin.Unit.f139807a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.repository.ScheduleRepository.t(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object u(Context context, Profile profile, Continuation continuation) throws Throwable {
        Object objW = w(context, CollectionsKt.listOf(profile), continuation);
        return objW == IntrinsicsKt.f() ? objW : Unit.f139807a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x0199, code lost:
    
        if (androidx.room.RoomDatabaseKt.g(r0, r1, r6) == r3) goto L40;
     */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x016a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x00f9 -> B:29:0x00fa). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object w(android.content.Context r25, java.util.List r26, kotlin.coroutines.Continuation r27) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 418
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.repository.ScheduleRepository.w(android.content.Context, java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
