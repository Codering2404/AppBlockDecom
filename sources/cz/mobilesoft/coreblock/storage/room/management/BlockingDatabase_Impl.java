package cz.mobilesoft.coreblock.storage.room.management;

import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenDelegate;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.SQLite;
import androidx.sqlite.SQLiteConnection;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.AnalyticsEvents;
import cz.mobilesoft.coreblock.storage.room.dao.PomodoroSessionDao;
import cz.mobilesoft.coreblock.storage.room.dao.PomodoroSessionDao_Impl;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.AdultContentWebsiteDao;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.AdultContentWebsiteDao_Impl;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.AppWebsiteCategoryDao;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.AppWebsiteCategoryDao_Impl;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.ApplicationDao;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.ApplicationDao_Impl;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.ApplicationProfileRelationDao;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.ApplicationProfileRelationDao_Impl;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.BlockSessionDao;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.BlockSessionDao_Impl;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.BlockedNotificationDao;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.BlockedNotificationDao_Impl;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.BrowserViewIdDao;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.BrowserViewIdDao_Impl;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.GeoAddressDao;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.GeoAddressDao_Impl;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.IntervalDao;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.IntervalDao_Impl;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao_Impl;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.StreakActivitySessionDao;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.StreakActivitySessionDao_Impl;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.StreakDayDao;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.StreakDayDao_Impl;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.StreakPauseRecordDao;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.StreakPauseRecordDao_Impl;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.SubAppRelationDao;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.SubAppRelationDao_Impl;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.UsageLimitDao;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.UsageLimitDao_Impl;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.WebsiteProfileRelationDao;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.WebsiteProfileRelationDao_Impl;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.WifiNetworkDao;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.WifiNetworkDao_Impl;
import cz.mobilesoft.coreblock.storage.room.dao.core.PomodoroHistoryDao;
import cz.mobilesoft.coreblock.storage.room.dao.core.PomodoroHistoryDao_Impl;
import cz.mobilesoft.coreblock.storage.room.dao.core.QuickBlockTimerHistoryDao;
import cz.mobilesoft.coreblock.storage.room.dao.core.QuickBlockTimerHistoryDao_Impl;
import cz.mobilesoft.coreblock.storage.room.dao.core.SchedulePauseHistoryDao;
import cz.mobilesoft.coreblock.storage.room.dao.core.SchedulePauseHistoryDao_Impl;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

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
public final class BlockingDatabase_Impl extends BlockingDatabase {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Lazy f126623a = LazyKt.b(new Function0() { // from class: cz.mobilesoft.coreblock.storage.room.management.a
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return BlockingDatabase_Impl.e0(this.f126767a);
        }
    });

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Lazy f126624b = LazyKt.b(new Function0() { // from class: cz.mobilesoft.coreblock.storage.room.management.c
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return BlockingDatabase_Impl.i0(this.f126771a);
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Lazy f126625c = LazyKt.b(new Function0() { // from class: cz.mobilesoft.coreblock.storage.room.management.e
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return BlockingDatabase_Impl.h0(this.f126775a);
        }
    });

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Lazy f126626d = LazyKt.b(new Function0() { // from class: cz.mobilesoft.coreblock.storage.room.management.f
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return BlockingDatabase_Impl.j0(this.f126777a);
        }
    });

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Lazy f126627e = LazyKt.b(new Function0() { // from class: cz.mobilesoft.coreblock.storage.room.management.g
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return BlockingDatabase_Impl.f0(this.f126779a);
        }
    });

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Lazy f126628f = LazyKt.b(new Function0() { // from class: cz.mobilesoft.coreblock.storage.room.management.h
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return BlockingDatabase_Impl.g0(this.f126781a);
        }
    });

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Lazy f126629g = LazyKt.b(new Function0() { // from class: cz.mobilesoft.coreblock.storage.room.management.i
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return BlockingDatabase_Impl.w0(this.f126783a);
        }
    });

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Lazy f126630h = LazyKt.b(new Function0() { // from class: cz.mobilesoft.coreblock.storage.room.management.j
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return BlockingDatabase_Impl.k0(this.f126785a);
        }
    });

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Lazy f126631i = LazyKt.b(new Function0() { // from class: cz.mobilesoft.coreblock.storage.room.management.k
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return BlockingDatabase_Impl.x0(this.f126787a);
        }
    });

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Lazy f126632j = LazyKt.b(new Function0() { // from class: cz.mobilesoft.coreblock.storage.room.management.m
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return BlockingDatabase_Impl.l0(this.f126791a);
        }
    });

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final Lazy f126633k = LazyKt.b(new Function0() { // from class: cz.mobilesoft.coreblock.storage.room.management.l
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return BlockingDatabase_Impl.v0(this.f126789a);
        }
    });

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final Lazy f126634l = LazyKt.b(new Function0() { // from class: cz.mobilesoft.coreblock.storage.room.management.n
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return BlockingDatabase_Impl.o0(this.f126793a);
        }
    });

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final Lazy f126635m = LazyKt.b(new Function0() { // from class: cz.mobilesoft.coreblock.storage.room.management.o
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return BlockingDatabase_Impl.d0(this.f126795a);
        }
    });

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final Lazy f126636n = LazyKt.b(new Function0() { // from class: cz.mobilesoft.coreblock.storage.room.management.p
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return BlockingDatabase_Impl.q0(this.f126798a);
        }
    });

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final Lazy f126637o = LazyKt.b(new Function0() { // from class: cz.mobilesoft.coreblock.storage.room.management.q
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return BlockingDatabase_Impl.p0(this.f126799a);
        }
    });

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final Lazy f126638p = LazyKt.b(new Function0() { // from class: cz.mobilesoft.coreblock.storage.room.management.r
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return BlockingDatabase_Impl.m0(this.f126800a);
        }
    });

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final Lazy f126639q = LazyKt.b(new Function0() { // from class: cz.mobilesoft.coreblock.storage.room.management.s
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return BlockingDatabase_Impl.n0(this.f126801a);
        }
    });

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final Lazy f126640r = LazyKt.b(new Function0() { // from class: cz.mobilesoft.coreblock.storage.room.management.t
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return BlockingDatabase_Impl.u0(this.f126802a);
        }
    });

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final Lazy f126641s = LazyKt.b(new Function0() { // from class: cz.mobilesoft.coreblock.storage.room.management.u
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return BlockingDatabase_Impl.s0(this.f126804a);
        }
    });

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final Lazy f126642t = LazyKt.b(new Function0() { // from class: cz.mobilesoft.coreblock.storage.room.management.b
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return BlockingDatabase_Impl.r0(this.f126769a);
        }
    });

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final Lazy f126643u = LazyKt.b(new Function0() { // from class: cz.mobilesoft.coreblock.storage.room.management.d
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return BlockingDatabase_Impl.t0(this.f126773a);
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final AdultContentWebsiteDao_Impl d0(BlockingDatabase_Impl blockingDatabase_Impl) {
        return new AdultContentWebsiteDao_Impl(blockingDatabase_Impl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AppWebsiteCategoryDao_Impl e0(BlockingDatabase_Impl blockingDatabase_Impl) {
        return new AppWebsiteCategoryDao_Impl(blockingDatabase_Impl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ApplicationDao_Impl f0(BlockingDatabase_Impl blockingDatabase_Impl) {
        return new ApplicationDao_Impl(blockingDatabase_Impl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ApplicationProfileRelationDao_Impl g0(BlockingDatabase_Impl blockingDatabase_Impl) {
        return new ApplicationProfileRelationDao_Impl(blockingDatabase_Impl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BlockSessionDao_Impl h0(BlockingDatabase_Impl blockingDatabase_Impl) {
        return new BlockSessionDao_Impl(blockingDatabase_Impl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BlockedNotificationDao_Impl i0(BlockingDatabase_Impl blockingDatabase_Impl) {
        return new BlockedNotificationDao_Impl(blockingDatabase_Impl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BrowserViewIdDao_Impl j0(BlockingDatabase_Impl blockingDatabase_Impl) {
        return new BrowserViewIdDao_Impl(blockingDatabase_Impl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final GeoAddressDao_Impl k0(BlockingDatabase_Impl blockingDatabase_Impl) {
        return new GeoAddressDao_Impl(blockingDatabase_Impl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IntervalDao_Impl l0(BlockingDatabase_Impl blockingDatabase_Impl) {
        return new IntervalDao_Impl(blockingDatabase_Impl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PomodoroHistoryDao_Impl m0(BlockingDatabase_Impl blockingDatabase_Impl) {
        return new PomodoroHistoryDao_Impl(blockingDatabase_Impl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PomodoroSessionDao_Impl n0(BlockingDatabase_Impl blockingDatabase_Impl) {
        return new PomodoroSessionDao_Impl(blockingDatabase_Impl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ProfileDao_Impl o0(BlockingDatabase_Impl blockingDatabase_Impl) {
        return new ProfileDao_Impl(blockingDatabase_Impl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final QuickBlockTimerHistoryDao_Impl p0(BlockingDatabase_Impl blockingDatabase_Impl) {
        return new QuickBlockTimerHistoryDao_Impl(blockingDatabase_Impl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SchedulePauseHistoryDao_Impl q0(BlockingDatabase_Impl blockingDatabase_Impl) {
        return new SchedulePauseHistoryDao_Impl(blockingDatabase_Impl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StreakActivitySessionDao_Impl r0(BlockingDatabase_Impl blockingDatabase_Impl) {
        return new StreakActivitySessionDao_Impl(blockingDatabase_Impl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StreakDayDao_Impl s0(BlockingDatabase_Impl blockingDatabase_Impl) {
        return new StreakDayDao_Impl(blockingDatabase_Impl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StreakPauseRecordDao_Impl t0(BlockingDatabase_Impl blockingDatabase_Impl) {
        return new StreakPauseRecordDao_Impl(blockingDatabase_Impl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SubAppRelationDao_Impl u0(BlockingDatabase_Impl blockingDatabase_Impl) {
        return new SubAppRelationDao_Impl(blockingDatabase_Impl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final UsageLimitDao_Impl v0(BlockingDatabase_Impl blockingDatabase_Impl) {
        return new UsageLimitDao_Impl(blockingDatabase_Impl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WebsiteProfileRelationDao_Impl w0(BlockingDatabase_Impl blockingDatabase_Impl) {
        return new WebsiteProfileRelationDao_Impl(blockingDatabase_Impl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WifiNetworkDao_Impl x0(BlockingDatabase_Impl blockingDatabase_Impl) {
        return new WifiNetworkDao_Impl(blockingDatabase_Impl);
    }

    @Override // cz.mobilesoft.coreblock.storage.room.management.BlockingDatabase
    public SchedulePauseHistoryDao A() {
        return (SchedulePauseHistoryDao) this.f126636n.getValue();
    }

    @Override // cz.mobilesoft.coreblock.storage.room.management.BlockingDatabase
    public StreakActivitySessionDao B() {
        return (StreakActivitySessionDao) this.f126642t.getValue();
    }

    @Override // cz.mobilesoft.coreblock.storage.room.management.BlockingDatabase
    public StreakDayDao C() {
        return (StreakDayDao) this.f126641s.getValue();
    }

    @Override // cz.mobilesoft.coreblock.storage.room.management.BlockingDatabase
    public StreakPauseRecordDao D() {
        return (StreakPauseRecordDao) this.f126643u.getValue();
    }

    @Override // cz.mobilesoft.coreblock.storage.room.management.BlockingDatabase
    public SubAppRelationDao E() {
        return (SubAppRelationDao) this.f126640r.getValue();
    }

    @Override // cz.mobilesoft.coreblock.storage.room.management.BlockingDatabase
    public UsageLimitDao F() {
        return (UsageLimitDao) this.f126633k.getValue();
    }

    @Override // cz.mobilesoft.coreblock.storage.room.management.BlockingDatabase
    public WebsiteProfileRelationDao G() {
        return (WebsiteProfileRelationDao) this.f126629g.getValue();
    }

    @Override // cz.mobilesoft.coreblock.storage.room.management.BlockingDatabase
    public WifiNetworkDao H() {
        return (WifiNetworkDao) this.f126631i.getValue();
    }

    @Override // androidx.room.RoomDatabase
    public void clearAllTables() {
        super.performClear(true, "AppWebsiteCategoryRelation", "Application", "ApplicationProfileRelation", "BlockSession", "BlockedNotification", "BrowserViewId", "GeoAddress", "Interval", "Profile", "UsageLimit", "WebsiteProfileRelation", "WifiNetwork", "AdultContentWebsite", "SchedulePauseHistoryTable", "QuickBlockTimerHistory", "PomodoroHistory", "PomodoroSession", "SubAppRelation", "StreakDay", "StreakActivitySession", "StreakPauseRecord");
    }

    @Override // androidx.room.RoomDatabase
    public List createAutoMigrations(Map autoMigrationSpecs) {
        Intrinsics.checkNotNullParameter(autoMigrationSpecs, "autoMigrationSpecs");
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BlockingDatabase_AutoMigration_2_3_Impl());
        arrayList.add(new BlockingDatabase_AutoMigration_6_7_Impl());
        arrayList.add(new BlockingDatabase_AutoMigration_11_12_Impl());
        arrayList.add(new BlockingDatabase_AutoMigration_13_14_Impl());
        arrayList.add(new BlockingDatabase_AutoMigration_24_25_Impl());
        return arrayList;
    }

    @Override // androidx.room.RoomDatabase
    protected InvalidationTracker createInvalidationTracker() {
        return new InvalidationTracker(this, new LinkedHashMap(), new LinkedHashMap(), "AppWebsiteCategoryRelation", "Application", "ApplicationProfileRelation", "BlockSession", "BlockedNotification", "BrowserViewId", "GeoAddress", "Interval", "Profile", "UsageLimit", "WebsiteProfileRelation", "WifiNetwork", "AdultContentWebsite", "SchedulePauseHistoryTable", "QuickBlockTimerHistory", "PomodoroHistory", "PomodoroSession", "SubAppRelation", "StreakDay", "StreakActivitySession", "StreakPauseRecord");
    }

    @Override // androidx.room.RoomDatabase
    public Set getRequiredAutoMigrationSpecClasses() {
        return new LinkedHashSet();
    }

    @Override // androidx.room.RoomDatabase
    protected Map getRequiredTypeConverterClasses() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(Reflection.b(AppWebsiteCategoryDao.class), AppWebsiteCategoryDao_Impl.f124853h.a());
        linkedHashMap.put(Reflection.b(BlockedNotificationDao.class), BlockedNotificationDao_Impl.f124976g.a());
        linkedHashMap.put(Reflection.b(BlockSessionDao.class), BlockSessionDao_Impl.f124963g.a());
        linkedHashMap.put(Reflection.b(BrowserViewIdDao.class), BrowserViewIdDao_Impl.f125011m.a());
        linkedHashMap.put(Reflection.b(ApplicationDao.class), ApplicationDao_Impl.f124920g.a());
        linkedHashMap.put(Reflection.b(ApplicationProfileRelationDao.class), ApplicationProfileRelationDao_Impl.f124956g.a());
        linkedHashMap.put(Reflection.b(WebsiteProfileRelationDao.class), WebsiteProfileRelationDao_Impl.f125313i.a());
        linkedHashMap.put(Reflection.b(GeoAddressDao.class), GeoAddressDao_Impl.f125032g.a());
        linkedHashMap.put(Reflection.b(WifiNetworkDao.class), WifiNetworkDao_Impl.f125325g.a());
        linkedHashMap.put(Reflection.b(IntervalDao.class), IntervalDao_Impl.f125062g.a());
        linkedHashMap.put(Reflection.b(UsageLimitDao.class), UsageLimitDao_Impl.f125269k.a());
        linkedHashMap.put(Reflection.b(ProfileDao.class), ProfileDao_Impl.f125112n.a());
        linkedHashMap.put(Reflection.b(AdultContentWebsiteDao.class), AdultContentWebsiteDao_Impl.f124832g.a());
        linkedHashMap.put(Reflection.b(SchedulePauseHistoryDao.class), SchedulePauseHistoryDao_Impl.f126116g.a());
        linkedHashMap.put(Reflection.b(QuickBlockTimerHistoryDao.class), QuickBlockTimerHistoryDao_Impl.f126097h.a());
        linkedHashMap.put(Reflection.b(PomodoroHistoryDao.class), PomodoroHistoryDao_Impl.f126046h.a());
        linkedHashMap.put(Reflection.b(PomodoroSessionDao.class), PomodoroSessionDao_Impl.f124814g.a());
        linkedHashMap.put(Reflection.b(SubAppRelationDao.class), SubAppRelationDao_Impl.f125220g.a());
        linkedHashMap.put(Reflection.b(StreakDayDao.class), StreakDayDao_Impl.f125200i.a());
        linkedHashMap.put(Reflection.b(StreakActivitySessionDao.class), StreakActivitySessionDao_Impl.f125193g.a());
        linkedHashMap.put(Reflection.b(StreakPauseRecordDao.class), StreakPauseRecordDao_Impl.f125213g.a());
        return linkedHashMap;
    }

    @Override // cz.mobilesoft.coreblock.storage.room.management.BlockingDatabase
    public AdultContentWebsiteDao n() {
        return (AdultContentWebsiteDao) this.f126635m.getValue();
    }

    @Override // cz.mobilesoft.coreblock.storage.room.management.BlockingDatabase
    public AppWebsiteCategoryDao o() {
        return (AppWebsiteCategoryDao) this.f126623a.getValue();
    }

    @Override // cz.mobilesoft.coreblock.storage.room.management.BlockingDatabase
    public ApplicationDao p() {
        return (ApplicationDao) this.f126627e.getValue();
    }

    @Override // cz.mobilesoft.coreblock.storage.room.management.BlockingDatabase
    public ApplicationProfileRelationDao q() {
        return (ApplicationProfileRelationDao) this.f126628f.getValue();
    }

    @Override // cz.mobilesoft.coreblock.storage.room.management.BlockingDatabase
    public BlockSessionDao r() {
        return (BlockSessionDao) this.f126625c.getValue();
    }

    @Override // cz.mobilesoft.coreblock.storage.room.management.BlockingDatabase
    public BlockedNotificationDao s() {
        return (BlockedNotificationDao) this.f126624b.getValue();
    }

    @Override // cz.mobilesoft.coreblock.storage.room.management.BlockingDatabase
    public BrowserViewIdDao t() {
        return (BrowserViewIdDao) this.f126626d.getValue();
    }

    @Override // cz.mobilesoft.coreblock.storage.room.management.BlockingDatabase
    public GeoAddressDao u() {
        return (GeoAddressDao) this.f126630h.getValue();
    }

    @Override // cz.mobilesoft.coreblock.storage.room.management.BlockingDatabase
    public IntervalDao v() {
        return (IntervalDao) this.f126632j.getValue();
    }

    @Override // cz.mobilesoft.coreblock.storage.room.management.BlockingDatabase
    public PomodoroHistoryDao w() {
        return (PomodoroHistoryDao) this.f126638p.getValue();
    }

    @Override // cz.mobilesoft.coreblock.storage.room.management.BlockingDatabase
    public PomodoroSessionDao x() {
        return (PomodoroSessionDao) this.f126639q.getValue();
    }

    @Override // cz.mobilesoft.coreblock.storage.room.management.BlockingDatabase
    public ProfileDao y() {
        return (ProfileDao) this.f126634l.getValue();
    }

    @Override // cz.mobilesoft.coreblock.storage.room.management.BlockingDatabase
    public QuickBlockTimerHistoryDao z() {
        return (QuickBlockTimerHistoryDao) this.f126637o.getValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.room.RoomDatabase
    /* JADX INFO: renamed from: z0, reason: merged with bridge method [inline-methods] */
    public RoomOpenDelegate createOpenDelegate() {
        return new RoomOpenDelegate() { // from class: cz.mobilesoft.coreblock.storage.room.management.BlockingDatabase_Impl$createOpenDelegate$_openDelegate$1
            {
                super(25, "c145f7dd1a603338f7fb580a5e16191c", "2372ca75ba521c122334d727d465ea21");
            }

            @Override // androidx.room.RoomOpenDelegate
            public void a(SQLiteConnection connection) throws Exception {
                Intrinsics.checkNotNullParameter(connection, "connection");
                SQLite.a(connection, "CREATE TABLE IF NOT EXISTS `AppWebsiteCategoryRelation` (`packageName` TEXT NOT NULL, `hostname` TEXT, `category` TEXT NOT NULL, `isPreset` INTEGER NOT NULL, PRIMARY KEY(`packageName`))");
                SQLite.a(connection, "CREATE INDEX IF NOT EXISTS `index_AppWebsiteCategoryRelation_hostname` ON `AppWebsiteCategoryRelation` (`hostname`)");
                SQLite.a(connection, "CREATE INDEX IF NOT EXISTS `index_AppWebsiteCategoryRelation_category` ON `AppWebsiteCategoryRelation` (`category`)");
                SQLite.a(connection, "CREATE TABLE IF NOT EXISTS `Application` (`packageName` TEXT NOT NULL, `label` TEXT NOT NULL, `labelForSearch` TEXT NOT NULL, `isUninstalled` INTEGER NOT NULL, `appCategories` INTEGER, PRIMARY KEY(`packageName`))");
                SQLite.a(connection, "CREATE INDEX IF NOT EXISTS `index_Application_labelForSearch` ON `Application` (`labelForSearch`)");
                SQLite.a(connection, "CREATE TABLE IF NOT EXISTS `ApplicationProfileRelation` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `packageName` TEXT NOT NULL, `profileId` INTEGER NOT NULL, `isEnabled` INTEGER NOT NULL, `flags` INTEGER NOT NULL, FOREIGN KEY(`profileId`) REFERENCES `Profile`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE )");
                SQLite.a(connection, "CREATE INDEX IF NOT EXISTS `index_ApplicationProfileRelation_packageName` ON `ApplicationProfileRelation` (`packageName`)");
                SQLite.a(connection, "CREATE INDEX IF NOT EXISTS `index_ApplicationProfileRelation_profileId` ON `ApplicationProfileRelation` (`profileId`)");
                SQLite.a(connection, "CREATE TABLE IF NOT EXISTS `BlockSession` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `name` TEXT NOT NULL, `timestamp` INTEGER NOT NULL)");
                SQLite.a(connection, "CREATE INDEX IF NOT EXISTS `index_BlockSession_name` ON `BlockSession` (`name`)");
                SQLite.a(connection, "CREATE INDEX IF NOT EXISTS `index_BlockSession_timestamp` ON `BlockSession` (`timestamp`)");
                SQLite.a(connection, "CREATE TABLE IF NOT EXISTS `BlockedNotification` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `packageName` TEXT NOT NULL, `timestamp` INTEGER NOT NULL, `profileId` INTEGER NOT NULL, `title` TEXT, `message` TEXT)");
                SQLite.a(connection, "CREATE INDEX IF NOT EXISTS `index_BlockedNotification_packageName` ON `BlockedNotification` (`packageName`)");
                SQLite.a(connection, "CREATE INDEX IF NOT EXISTS `index_BlockedNotification_timestamp` ON `BlockedNotification` (`timestamp`)");
                SQLite.a(connection, "CREATE INDEX IF NOT EXISTS `index_BlockedNotification_profileId` ON `BlockedNotification` (`profileId`)");
                SQLite.a(connection, "CREATE TABLE IF NOT EXISTS `BrowserViewId` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `packageName` TEXT NOT NULL, `viewId` TEXT NOT NULL, `viewType` INTEGER NOT NULL, `clearUrl` INTEGER NOT NULL, `showLocalHtml` INTEGER NOT NULL, `detectionMethod` TEXT, `extractionMethod` TEXT, `clickToOpenUrlBarViewId` TEXT)");
                SQLite.a(connection, "CREATE UNIQUE INDEX IF NOT EXISTS `index_BrowserViewId_packageName_viewId` ON `BrowserViewId` (`packageName`, `viewId`)");
                SQLite.a(connection, "CREATE TABLE IF NOT EXISTS `GeoAddress` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `profileId` INTEGER NOT NULL, `geofenceId` TEXT NOT NULL, `geofenceRadius` INTEGER NOT NULL, `latitude` REAL NOT NULL, `longitude` REAL NOT NULL, `isInverted` INTEGER NOT NULL, `locale` TEXT, `featureName` TEXT, `adminArea` TEXT, `subAdminArea` TEXT, `locality` TEXT, `subLocality` TEXT, `thoroughfare` TEXT, `subThoroughfare` TEXT, `premises` TEXT, `postalCode` TEXT, `countryCode` TEXT, `countryName` TEXT, FOREIGN KEY(`profileId`) REFERENCES `Profile`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE )");
                SQLite.a(connection, "CREATE INDEX IF NOT EXISTS `index_GeoAddress_profileId` ON `GeoAddress` (`profileId`)");
                SQLite.a(connection, "CREATE INDEX IF NOT EXISTS `index_GeoAddress_geofenceId` ON `GeoAddress` (`geofenceId`)");
                SQLite.a(connection, "CREATE TABLE IF NOT EXISTS `Interval` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `profileId` INTEGER NOT NULL, `fromInMinutes` INTEGER NOT NULL, `toInMinutes` INTEGER NOT NULL, `parentId` INTEGER, `isAllDayAuto` INTEGER NOT NULL, `isEnabled` INTEGER NOT NULL, FOREIGN KEY(`parentId`) REFERENCES `Interval`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE , FOREIGN KEY(`profileId`) REFERENCES `Profile`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE )");
                SQLite.a(connection, "CREATE INDEX IF NOT EXISTS `index_Interval_profileId` ON `Interval` (`profileId`)");
                SQLite.a(connection, "CREATE INDEX IF NOT EXISTS `index_Interval_parentId` ON `Interval` (`parentId`)");
                SQLite.a(connection, "CREATE TABLE IF NOT EXISTS `Profile` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `title` TEXT NOT NULL, `typeCombinations` INTEGER NOT NULL, `onConditions` INTEGER NOT NULL, `operator` INTEGER NOT NULL, `dayFlags` INTEGER NOT NULL, `blockNotifications` INTEGER NOT NULL, `blockLaunch` INTEGER NOT NULL, `addNewApplications` INTEGER NOT NULL, `isEnabled` INTEGER NOT NULL, `isLocked` INTEGER NOT NULL, `lastStartTime` INTEGER NOT NULL, `onUntil` INTEGER NOT NULL, `lockedUntil` INTEGER NOT NULL, `lockAt` INTEGER NOT NULL, `pausedUntil` INTEGER NOT NULL DEFAULT 0, `blockingMode` INTEGER NOT NULL DEFAULT 0, `emoji` INTEGER NOT NULL, `blockUnsupportedBrowsers` INTEGER NOT NULL DEFAULT 0, `blockAdultContent` INTEGER NOT NULL DEFAULT 0, `blockInAppPurchases` INTEGER NOT NULL DEFAULT 0, `selectedCategories` INTEGER NOT NULL DEFAULT 0, `webBrowsingMode` INTEGER NOT NULL DEFAULT 0)");
                SQLite.a(connection, "CREATE TABLE IF NOT EXISTS `UsageLimit` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `profileId` INTEGER NOT NULL, `periodType` INTEGER NOT NULL, `limitType` INTEGER NOT NULL, `lastResetTime` INTEGER NOT NULL, `allowedCount` INTEGER NOT NULL, `usedCount` INTEGER NOT NULL, `originalAllowedCount` INTEGER NOT NULL, FOREIGN KEY(`profileId`) REFERENCES `Profile`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE )");
                SQLite.a(connection, "CREATE INDEX IF NOT EXISTS `index_UsageLimit_profileId` ON `UsageLimit` (`profileId`)");
                SQLite.a(connection, "CREATE INDEX IF NOT EXISTS `index_UsageLimit_periodType` ON `UsageLimit` (`periodType`)");
                SQLite.a(connection, "CREATE INDEX IF NOT EXISTS `index_UsageLimit_limitType` ON `UsageLimit` (`limitType`)");
                SQLite.a(connection, "CREATE TABLE IF NOT EXISTS `WebsiteProfileRelation` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `profileId` INTEGER NOT NULL, `name` TEXT NOT NULL, `blockingType` INTEGER NOT NULL, `isAnywhereInUrl` INTEGER NOT NULL, `isEnabled` INTEGER NOT NULL, FOREIGN KEY(`profileId`) REFERENCES `Profile`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE )");
                SQLite.a(connection, "CREATE INDEX IF NOT EXISTS `index_WebsiteProfileRelation_profileId` ON `WebsiteProfileRelation` (`profileId`)");
                SQLite.a(connection, "CREATE TABLE IF NOT EXISTS `WifiNetwork` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `profileId` INTEGER NOT NULL, `ssid` TEXT NOT NULL, FOREIGN KEY(`profileId`) REFERENCES `Profile`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE )");
                SQLite.a(connection, "CREATE INDEX IF NOT EXISTS `index_WifiNetwork_profileId` ON `WifiNetwork` (`profileId`)");
                SQLite.a(connection, "CREATE TABLE IF NOT EXISTS `AdultContentWebsite` (`url` TEXT NOT NULL, PRIMARY KEY(`url`))");
                SQLite.a(connection, "CREATE TABLE IF NOT EXISTS `SchedulePauseHistoryTable` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `pauseTimeSeconds` INTEGER NOT NULL, `updatedAt` INTEGER NOT NULL, `isForToday` INTEGER NOT NULL, `profileId` INTEGER)");
                SQLite.a(connection, "CREATE TABLE IF NOT EXISTS `QuickBlockTimerHistory` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `timeMillis` INTEGER NOT NULL, `updatedAt` INTEGER NOT NULL)");
                SQLite.a(connection, "CREATE TABLE IF NOT EXISTS `PomodoroHistory` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `focusTimeMillis` INTEGER NOT NULL, `breakTimeMillis` INTEGER NOT NULL, `sessionCount` INTEGER NOT NULL, `updatedAt` INTEGER NOT NULL)");
                SQLite.a(connection, "CREATE TABLE IF NOT EXISTS `PomodoroSession` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `profileId` INTEGER NOT NULL, `originalStartTime` INTEGER NOT NULL, `focusTime` INTEGER NOT NULL, `breakTime` INTEGER NOT NULL, `sessionCount` INTEGER NOT NULL, `isStoppedManually` INTEGER NOT NULL, `originalEndTime` INTEGER NOT NULL, `adjustedEndTime` INTEGER NOT NULL)");
                SQLite.a(connection, "CREATE INDEX IF NOT EXISTS `index_PomodoroSession_profileId` ON `PomodoroSession` (`profileId`)");
                SQLite.a(connection, "CREATE TABLE IF NOT EXISTS `SubAppRelation` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `profileId` INTEGER NOT NULL, `subAppId` TEXT NOT NULL, FOREIGN KEY(`profileId`) REFERENCES `Profile`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE )");
                SQLite.a(connection, "CREATE INDEX IF NOT EXISTS `index_SubAppRelation_profileId` ON `SubAppRelation` (`profileId`)");
                SQLite.a(connection, "CREATE TABLE IF NOT EXISTS `StreakDay` (`dayKey` TEXT NOT NULL, `dayStartMillis` INTEGER NOT NULL, `timeZoneId` TEXT NOT NULL, `status` INTEGER NOT NULL DEFAULT 0, `lossReason` INTEGER NOT NULL DEFAULT 0, `evaluatedAtMillis` INTEGER NOT NULL, `earnedAtMillis` INTEGER, `rulesVersion` INTEGER NOT NULL DEFAULT 0, PRIMARY KEY(`dayKey`))");
                SQLite.a(connection, "CREATE TABLE IF NOT EXISTS `StreakActivitySession` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `profileId` INTEGER, `startMillis` INTEGER NOT NULL, `endMillis` INTEGER NOT NULL, `createdAtMillis` INTEGER NOT NULL)");
                SQLite.a(connection, "CREATE INDEX IF NOT EXISTS `index_StreakActivitySession_profileId` ON `StreakActivitySession` (`profileId`)");
                SQLite.a(connection, "CREATE INDEX IF NOT EXISTS `index_StreakActivitySession_startMillis` ON `StreakActivitySession` (`startMillis`)");
                SQLite.a(connection, "CREATE INDEX IF NOT EXISTS `index_StreakActivitySession_endMillis` ON `StreakActivitySession` (`endMillis`)");
                SQLite.a(connection, "CREATE TABLE IF NOT EXISTS `StreakPauseRecord` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `profileId` INTEGER NOT NULL, `startMillis` INTEGER NOT NULL, `plannedEndMillis` INTEGER NOT NULL, `endedAtMillis` INTEGER, `isIndefinite` INTEGER NOT NULL DEFAULT 0)");
                SQLite.a(connection, "CREATE INDEX IF NOT EXISTS `index_StreakPauseRecord_profileId` ON `StreakPauseRecord` (`profileId`)");
                SQLite.a(connection, "CREATE INDEX IF NOT EXISTS `index_StreakPauseRecord_startMillis` ON `StreakPauseRecord` (`startMillis`)");
                SQLite.a(connection, "CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
                SQLite.a(connection, "INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'c145f7dd1a603338f7fb580a5e16191c')");
            }

            @Override // androidx.room.RoomOpenDelegate
            public void b(SQLiteConnection connection) throws Exception {
                Intrinsics.checkNotNullParameter(connection, "connection");
                SQLite.a(connection, "DROP TABLE IF EXISTS `AppWebsiteCategoryRelation`");
                SQLite.a(connection, "DROP TABLE IF EXISTS `Application`");
                SQLite.a(connection, "DROP TABLE IF EXISTS `ApplicationProfileRelation`");
                SQLite.a(connection, "DROP TABLE IF EXISTS `BlockSession`");
                SQLite.a(connection, "DROP TABLE IF EXISTS `BlockedNotification`");
                SQLite.a(connection, "DROP TABLE IF EXISTS `BrowserViewId`");
                SQLite.a(connection, "DROP TABLE IF EXISTS `GeoAddress`");
                SQLite.a(connection, "DROP TABLE IF EXISTS `Interval`");
                SQLite.a(connection, "DROP TABLE IF EXISTS `Profile`");
                SQLite.a(connection, "DROP TABLE IF EXISTS `UsageLimit`");
                SQLite.a(connection, "DROP TABLE IF EXISTS `WebsiteProfileRelation`");
                SQLite.a(connection, "DROP TABLE IF EXISTS `WifiNetwork`");
                SQLite.a(connection, "DROP TABLE IF EXISTS `AdultContentWebsite`");
                SQLite.a(connection, "DROP TABLE IF EXISTS `SchedulePauseHistoryTable`");
                SQLite.a(connection, "DROP TABLE IF EXISTS `QuickBlockTimerHistory`");
                SQLite.a(connection, "DROP TABLE IF EXISTS `PomodoroHistory`");
                SQLite.a(connection, "DROP TABLE IF EXISTS `PomodoroSession`");
                SQLite.a(connection, "DROP TABLE IF EXISTS `SubAppRelation`");
                SQLite.a(connection, "DROP TABLE IF EXISTS `StreakDay`");
                SQLite.a(connection, "DROP TABLE IF EXISTS `StreakActivitySession`");
                SQLite.a(connection, "DROP TABLE IF EXISTS `StreakPauseRecord`");
            }

            @Override // androidx.room.RoomOpenDelegate
            public void f(SQLiteConnection connection) {
                Intrinsics.checkNotNullParameter(connection, "connection");
            }

            @Override // androidx.room.RoomOpenDelegate
            public void g(SQLiteConnection connection) throws Exception {
                Intrinsics.checkNotNullParameter(connection, "connection");
                SQLite.a(connection, "PRAGMA foreign_keys = ON");
                this.f126644d.internalInitInvalidationTracker(connection);
            }

            @Override // androidx.room.RoomOpenDelegate
            public void h(SQLiteConnection connection) {
                Intrinsics.checkNotNullParameter(connection, "connection");
            }

            @Override // androidx.room.RoomOpenDelegate
            public void i(SQLiteConnection connection) {
                Intrinsics.checkNotNullParameter(connection, "connection");
                DBUtil.b(connection);
            }

            @Override // androidx.room.RoomOpenDelegate
            public RoomOpenDelegate.ValidationResult j(SQLiteConnection connection) {
                Intrinsics.checkNotNullParameter(connection, "connection");
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put("packageName", new TableInfo.Column("packageName", "TEXT", true, 1, null, 1));
                linkedHashMap.put("hostname", new TableInfo.Column("hostname", "TEXT", false, 0, null, 1));
                linkedHashMap.put("category", new TableInfo.Column("category", "TEXT", true, 0, null, 1));
                linkedHashMap.put("isPreset", new TableInfo.Column("isPreset", "INTEGER", true, 0, null, 1));
                LinkedHashSet linkedHashSet = new LinkedHashSet();
                LinkedHashSet linkedHashSet2 = new LinkedHashSet();
                linkedHashSet2.add(new TableInfo.Index("index_AppWebsiteCategoryRelation_hostname", false, CollectionsKt.listOf("hostname"), CollectionsKt.listOf("ASC")));
                linkedHashSet2.add(new TableInfo.Index("index_AppWebsiteCategoryRelation_category", false, CollectionsKt.listOf("category"), CollectionsKt.listOf("ASC")));
                TableInfo tableInfo = new TableInfo("AppWebsiteCategoryRelation", linkedHashMap, linkedHashSet, linkedHashSet2);
                TableInfo.Companion companion = TableInfo.f52966e;
                TableInfo tableInfoA = companion.a(connection, "AppWebsiteCategoryRelation");
                if (!tableInfo.equals(tableInfoA)) {
                    return new RoomOpenDelegate.ValidationResult(false, "AppWebsiteCategoryRelation(cz.mobilesoft.coreblock.storage.room.entity.blocking.AppWebsiteCategoryRelation).\n Expected:\n" + tableInfo + "\n Found:\n" + tableInfoA);
                }
                LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                linkedHashMap2.put("packageName", new TableInfo.Column("packageName", "TEXT", true, 1, null, 1));
                linkedHashMap2.put("label", new TableInfo.Column("label", "TEXT", true, 0, null, 1));
                linkedHashMap2.put("labelForSearch", new TableInfo.Column("labelForSearch", "TEXT", true, 0, null, 1));
                linkedHashMap2.put("isUninstalled", new TableInfo.Column("isUninstalled", "INTEGER", true, 0, null, 1));
                linkedHashMap2.put("appCategories", new TableInfo.Column("appCategories", "INTEGER", false, 0, null, 1));
                LinkedHashSet linkedHashSet3 = new LinkedHashSet();
                LinkedHashSet linkedHashSet4 = new LinkedHashSet();
                linkedHashSet4.add(new TableInfo.Index("index_Application_labelForSearch", false, CollectionsKt.listOf("labelForSearch"), CollectionsKt.listOf("ASC")));
                TableInfo tableInfo2 = new TableInfo("Application", linkedHashMap2, linkedHashSet3, linkedHashSet4);
                TableInfo tableInfoA2 = companion.a(connection, "Application");
                if (!tableInfo2.equals(tableInfoA2)) {
                    return new RoomOpenDelegate.ValidationResult(false, "Application(cz.mobilesoft.coreblock.storage.room.entity.blocking.Application).\n Expected:\n" + tableInfo2 + "\n Found:\n" + tableInfoA2);
                }
                LinkedHashMap linkedHashMap3 = new LinkedHashMap();
                linkedHashMap3.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, 1));
                linkedHashMap3.put("packageName", new TableInfo.Column("packageName", "TEXT", true, 0, null, 1));
                linkedHashMap3.put("profileId", new TableInfo.Column("profileId", "INTEGER", true, 0, null, 1));
                linkedHashMap3.put("isEnabled", new TableInfo.Column("isEnabled", "INTEGER", true, 0, null, 1));
                linkedHashMap3.put("flags", new TableInfo.Column("flags", "INTEGER", true, 0, null, 1));
                LinkedHashSet linkedHashSet5 = new LinkedHashSet();
                linkedHashSet5.add(new TableInfo.ForeignKey("Profile", "CASCADE", "NO ACTION", CollectionsKt.listOf("profileId"), CollectionsKt.listOf("id")));
                LinkedHashSet linkedHashSet6 = new LinkedHashSet();
                linkedHashSet6.add(new TableInfo.Index("index_ApplicationProfileRelation_packageName", false, CollectionsKt.listOf("packageName"), CollectionsKt.listOf("ASC")));
                linkedHashSet6.add(new TableInfo.Index("index_ApplicationProfileRelation_profileId", false, CollectionsKt.listOf("profileId"), CollectionsKt.listOf("ASC")));
                TableInfo tableInfo3 = new TableInfo("ApplicationProfileRelation", linkedHashMap3, linkedHashSet5, linkedHashSet6);
                TableInfo tableInfoA3 = companion.a(connection, "ApplicationProfileRelation");
                if (!tableInfo3.equals(tableInfoA3)) {
                    return new RoomOpenDelegate.ValidationResult(false, "ApplicationProfileRelation(cz.mobilesoft.coreblock.storage.room.entity.blocking.ApplicationProfileRelation).\n Expected:\n" + tableInfo3 + "\n Found:\n" + tableInfoA3);
                }
                LinkedHashMap linkedHashMap4 = new LinkedHashMap();
                linkedHashMap4.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, 1));
                linkedHashMap4.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, 1));
                linkedHashMap4.put("timestamp", new TableInfo.Column("timestamp", "INTEGER", true, 0, null, 1));
                LinkedHashSet linkedHashSet7 = new LinkedHashSet();
                LinkedHashSet linkedHashSet8 = new LinkedHashSet();
                linkedHashSet8.add(new TableInfo.Index("index_BlockSession_name", false, CollectionsKt.listOf("name"), CollectionsKt.listOf("ASC")));
                linkedHashSet8.add(new TableInfo.Index("index_BlockSession_timestamp", false, CollectionsKt.listOf("timestamp"), CollectionsKt.listOf("ASC")));
                TableInfo tableInfo4 = new TableInfo("BlockSession", linkedHashMap4, linkedHashSet7, linkedHashSet8);
                TableInfo tableInfoA4 = companion.a(connection, "BlockSession");
                if (!tableInfo4.equals(tableInfoA4)) {
                    return new RoomOpenDelegate.ValidationResult(false, "BlockSession(cz.mobilesoft.coreblock.storage.room.entity.blocking.BlockSession).\n Expected:\n" + tableInfo4 + "\n Found:\n" + tableInfoA4);
                }
                LinkedHashMap linkedHashMap5 = new LinkedHashMap();
                linkedHashMap5.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, 1));
                linkedHashMap5.put("packageName", new TableInfo.Column("packageName", "TEXT", true, 0, null, 1));
                linkedHashMap5.put("timestamp", new TableInfo.Column("timestamp", "INTEGER", true, 0, null, 1));
                linkedHashMap5.put("profileId", new TableInfo.Column("profileId", "INTEGER", true, 0, null, 1));
                linkedHashMap5.put("title", new TableInfo.Column("title", "TEXT", false, 0, null, 1));
                linkedHashMap5.put("message", new TableInfo.Column("message", "TEXT", false, 0, null, 1));
                LinkedHashSet linkedHashSet9 = new LinkedHashSet();
                LinkedHashSet linkedHashSet10 = new LinkedHashSet();
                linkedHashSet10.add(new TableInfo.Index("index_BlockedNotification_packageName", false, CollectionsKt.listOf("packageName"), CollectionsKt.listOf("ASC")));
                linkedHashSet10.add(new TableInfo.Index("index_BlockedNotification_timestamp", false, CollectionsKt.listOf("timestamp"), CollectionsKt.listOf("ASC")));
                linkedHashSet10.add(new TableInfo.Index("index_BlockedNotification_profileId", false, CollectionsKt.listOf("profileId"), CollectionsKt.listOf("ASC")));
                TableInfo tableInfo5 = new TableInfo("BlockedNotification", linkedHashMap5, linkedHashSet9, linkedHashSet10);
                TableInfo tableInfoA5 = companion.a(connection, "BlockedNotification");
                if (!tableInfo5.equals(tableInfoA5)) {
                    return new RoomOpenDelegate.ValidationResult(false, "BlockedNotification(cz.mobilesoft.coreblock.storage.room.entity.blocking.BlockedNotification).\n Expected:\n" + tableInfo5 + "\n Found:\n" + tableInfoA5);
                }
                LinkedHashMap linkedHashMap6 = new LinkedHashMap();
                linkedHashMap6.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, 1));
                linkedHashMap6.put("packageName", new TableInfo.Column("packageName", "TEXT", true, 0, null, 1));
                linkedHashMap6.put("viewId", new TableInfo.Column("viewId", "TEXT", true, 0, null, 1));
                linkedHashMap6.put("viewType", new TableInfo.Column("viewType", "INTEGER", true, 0, null, 1));
                linkedHashMap6.put("clearUrl", new TableInfo.Column("clearUrl", "INTEGER", true, 0, null, 1));
                linkedHashMap6.put("showLocalHtml", new TableInfo.Column("showLocalHtml", "INTEGER", true, 0, null, 1));
                linkedHashMap6.put("detectionMethod", new TableInfo.Column("detectionMethod", "TEXT", false, 0, null, 1));
                linkedHashMap6.put("extractionMethod", new TableInfo.Column("extractionMethod", "TEXT", false, 0, null, 1));
                linkedHashMap6.put("clickToOpenUrlBarViewId", new TableInfo.Column("clickToOpenUrlBarViewId", "TEXT", false, 0, null, 1));
                LinkedHashSet linkedHashSet11 = new LinkedHashSet();
                LinkedHashSet linkedHashSet12 = new LinkedHashSet();
                linkedHashSet12.add(new TableInfo.Index("index_BrowserViewId_packageName_viewId", true, CollectionsKt.listOf((Object[]) new String[]{"packageName", "viewId"}), CollectionsKt.listOf((Object[]) new String[]{"ASC", "ASC"})));
                TableInfo tableInfo6 = new TableInfo("BrowserViewId", linkedHashMap6, linkedHashSet11, linkedHashSet12);
                TableInfo tableInfoA6 = companion.a(connection, "BrowserViewId");
                if (!tableInfo6.equals(tableInfoA6)) {
                    return new RoomOpenDelegate.ValidationResult(false, "BrowserViewId(cz.mobilesoft.coreblock.storage.room.entity.blocking.BrowserViewId).\n Expected:\n" + tableInfo6 + "\n Found:\n" + tableInfoA6);
                }
                LinkedHashMap linkedHashMap7 = new LinkedHashMap();
                linkedHashMap7.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, 1));
                linkedHashMap7.put("profileId", new TableInfo.Column("profileId", "INTEGER", true, 0, null, 1));
                linkedHashMap7.put("geofenceId", new TableInfo.Column("geofenceId", "TEXT", true, 0, null, 1));
                linkedHashMap7.put("geofenceRadius", new TableInfo.Column("geofenceRadius", "INTEGER", true, 0, null, 1));
                linkedHashMap7.put("latitude", new TableInfo.Column("latitude", "REAL", true, 0, null, 1));
                linkedHashMap7.put("longitude", new TableInfo.Column("longitude", "REAL", true, 0, null, 1));
                linkedHashMap7.put("isInverted", new TableInfo.Column("isInverted", "INTEGER", true, 0, null, 1));
                linkedHashMap7.put("locale", new TableInfo.Column("locale", "TEXT", false, 0, null, 1));
                linkedHashMap7.put("featureName", new TableInfo.Column("featureName", "TEXT", false, 0, null, 1));
                linkedHashMap7.put("adminArea", new TableInfo.Column("adminArea", "TEXT", false, 0, null, 1));
                linkedHashMap7.put("subAdminArea", new TableInfo.Column("subAdminArea", "TEXT", false, 0, null, 1));
                linkedHashMap7.put("locality", new TableInfo.Column("locality", "TEXT", false, 0, null, 1));
                linkedHashMap7.put("subLocality", new TableInfo.Column("subLocality", "TEXT", false, 0, null, 1));
                linkedHashMap7.put("thoroughfare", new TableInfo.Column("thoroughfare", "TEXT", false, 0, null, 1));
                linkedHashMap7.put("subThoroughfare", new TableInfo.Column("subThoroughfare", "TEXT", false, 0, null, 1));
                linkedHashMap7.put("premises", new TableInfo.Column("premises", "TEXT", false, 0, null, 1));
                linkedHashMap7.put("postalCode", new TableInfo.Column("postalCode", "TEXT", false, 0, null, 1));
                linkedHashMap7.put("countryCode", new TableInfo.Column("countryCode", "TEXT", false, 0, null, 1));
                linkedHashMap7.put("countryName", new TableInfo.Column("countryName", "TEXT", false, 0, null, 1));
                LinkedHashSet linkedHashSet13 = new LinkedHashSet();
                linkedHashSet13.add(new TableInfo.ForeignKey("Profile", "CASCADE", "NO ACTION", CollectionsKt.listOf("profileId"), CollectionsKt.listOf("id")));
                LinkedHashSet linkedHashSet14 = new LinkedHashSet();
                linkedHashSet14.add(new TableInfo.Index("index_GeoAddress_profileId", false, CollectionsKt.listOf("profileId"), CollectionsKt.listOf("ASC")));
                linkedHashSet14.add(new TableInfo.Index("index_GeoAddress_geofenceId", false, CollectionsKt.listOf("geofenceId"), CollectionsKt.listOf("ASC")));
                TableInfo tableInfo7 = new TableInfo("GeoAddress", linkedHashMap7, linkedHashSet13, linkedHashSet14);
                TableInfo tableInfoA7 = companion.a(connection, "GeoAddress");
                if (!tableInfo7.equals(tableInfoA7)) {
                    return new RoomOpenDelegate.ValidationResult(false, "GeoAddress(cz.mobilesoft.coreblock.storage.room.entity.blocking.GeoAddress).\n Expected:\n" + tableInfo7 + "\n Found:\n" + tableInfoA7);
                }
                LinkedHashMap linkedHashMap8 = new LinkedHashMap();
                linkedHashMap8.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, 1));
                linkedHashMap8.put("profileId", new TableInfo.Column("profileId", "INTEGER", true, 0, null, 1));
                linkedHashMap8.put("fromInMinutes", new TableInfo.Column("fromInMinutes", "INTEGER", true, 0, null, 1));
                linkedHashMap8.put("toInMinutes", new TableInfo.Column("toInMinutes", "INTEGER", true, 0, null, 1));
                linkedHashMap8.put("parentId", new TableInfo.Column("parentId", "INTEGER", false, 0, null, 1));
                linkedHashMap8.put("isAllDayAuto", new TableInfo.Column("isAllDayAuto", "INTEGER", true, 0, null, 1));
                linkedHashMap8.put("isEnabled", new TableInfo.Column("isEnabled", "INTEGER", true, 0, null, 1));
                LinkedHashSet linkedHashSet15 = new LinkedHashSet();
                linkedHashSet15.add(new TableInfo.ForeignKey("Interval", "CASCADE", "NO ACTION", CollectionsKt.listOf("parentId"), CollectionsKt.listOf("id")));
                linkedHashSet15.add(new TableInfo.ForeignKey("Profile", "CASCADE", "NO ACTION", CollectionsKt.listOf("profileId"), CollectionsKt.listOf("id")));
                LinkedHashSet linkedHashSet16 = new LinkedHashSet();
                linkedHashSet16.add(new TableInfo.Index("index_Interval_profileId", false, CollectionsKt.listOf("profileId"), CollectionsKt.listOf("ASC")));
                linkedHashSet16.add(new TableInfo.Index("index_Interval_parentId", false, CollectionsKt.listOf("parentId"), CollectionsKt.listOf("ASC")));
                TableInfo tableInfo8 = new TableInfo("Interval", linkedHashMap8, linkedHashSet15, linkedHashSet16);
                TableInfo tableInfoA8 = companion.a(connection, "Interval");
                if (!tableInfo8.equals(tableInfoA8)) {
                    return new RoomOpenDelegate.ValidationResult(false, "Interval(cz.mobilesoft.coreblock.storage.room.entity.blocking.Interval).\n Expected:\n" + tableInfo8 + "\n Found:\n" + tableInfoA8);
                }
                LinkedHashMap linkedHashMap9 = new LinkedHashMap();
                linkedHashMap9.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, 1));
                linkedHashMap9.put("title", new TableInfo.Column("title", "TEXT", true, 0, null, 1));
                linkedHashMap9.put("typeCombinations", new TableInfo.Column("typeCombinations", "INTEGER", true, 0, null, 1));
                linkedHashMap9.put("onConditions", new TableInfo.Column("onConditions", "INTEGER", true, 0, null, 1));
                linkedHashMap9.put("operator", new TableInfo.Column("operator", "INTEGER", true, 0, null, 1));
                linkedHashMap9.put("dayFlags", new TableInfo.Column("dayFlags", "INTEGER", true, 0, null, 1));
                linkedHashMap9.put("blockNotifications", new TableInfo.Column("blockNotifications", "INTEGER", true, 0, null, 1));
                linkedHashMap9.put("blockLaunch", new TableInfo.Column("blockLaunch", "INTEGER", true, 0, null, 1));
                linkedHashMap9.put("addNewApplications", new TableInfo.Column("addNewApplications", "INTEGER", true, 0, null, 1));
                linkedHashMap9.put("isEnabled", new TableInfo.Column("isEnabled", "INTEGER", true, 0, null, 1));
                linkedHashMap9.put("isLocked", new TableInfo.Column("isLocked", "INTEGER", true, 0, null, 1));
                linkedHashMap9.put("lastStartTime", new TableInfo.Column("lastStartTime", "INTEGER", true, 0, null, 1));
                linkedHashMap9.put("onUntil", new TableInfo.Column("onUntil", "INTEGER", true, 0, null, 1));
                linkedHashMap9.put("lockedUntil", new TableInfo.Column("lockedUntil", "INTEGER", true, 0, null, 1));
                linkedHashMap9.put("lockAt", new TableInfo.Column("lockAt", "INTEGER", true, 0, null, 1));
                linkedHashMap9.put("pausedUntil", new TableInfo.Column("pausedUntil", "INTEGER", true, 0, AppEventsConstants.EVENT_PARAM_VALUE_NO, 1));
                linkedHashMap9.put("blockingMode", new TableInfo.Column("blockingMode", "INTEGER", true, 0, AppEventsConstants.EVENT_PARAM_VALUE_NO, 1));
                linkedHashMap9.put("emoji", new TableInfo.Column("emoji", "INTEGER", true, 0, null, 1));
                linkedHashMap9.put("blockUnsupportedBrowsers", new TableInfo.Column("blockUnsupportedBrowsers", "INTEGER", true, 0, AppEventsConstants.EVENT_PARAM_VALUE_NO, 1));
                linkedHashMap9.put("blockAdultContent", new TableInfo.Column("blockAdultContent", "INTEGER", true, 0, AppEventsConstants.EVENT_PARAM_VALUE_NO, 1));
                linkedHashMap9.put("blockInAppPurchases", new TableInfo.Column("blockInAppPurchases", "INTEGER", true, 0, AppEventsConstants.EVENT_PARAM_VALUE_NO, 1));
                linkedHashMap9.put("selectedCategories", new TableInfo.Column("selectedCategories", "INTEGER", true, 0, AppEventsConstants.EVENT_PARAM_VALUE_NO, 1));
                linkedHashMap9.put("webBrowsingMode", new TableInfo.Column("webBrowsingMode", "INTEGER", true, 0, AppEventsConstants.EVENT_PARAM_VALUE_NO, 1));
                TableInfo tableInfo9 = new TableInfo("Profile", linkedHashMap9, new LinkedHashSet(), new LinkedHashSet());
                TableInfo tableInfoA9 = companion.a(connection, "Profile");
                if (!tableInfo9.equals(tableInfoA9)) {
                    return new RoomOpenDelegate.ValidationResult(false, "Profile(cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile).\n Expected:\n" + tableInfo9 + "\n Found:\n" + tableInfoA9);
                }
                LinkedHashMap linkedHashMap10 = new LinkedHashMap();
                linkedHashMap10.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, 1));
                linkedHashMap10.put("profileId", new TableInfo.Column("profileId", "INTEGER", true, 0, null, 1));
                linkedHashMap10.put("periodType", new TableInfo.Column("periodType", "INTEGER", true, 0, null, 1));
                linkedHashMap10.put("limitType", new TableInfo.Column("limitType", "INTEGER", true, 0, null, 1));
                linkedHashMap10.put("lastResetTime", new TableInfo.Column("lastResetTime", "INTEGER", true, 0, null, 1));
                linkedHashMap10.put("allowedCount", new TableInfo.Column("allowedCount", "INTEGER", true, 0, null, 1));
                linkedHashMap10.put("usedCount", new TableInfo.Column("usedCount", "INTEGER", true, 0, null, 1));
                linkedHashMap10.put("originalAllowedCount", new TableInfo.Column("originalAllowedCount", "INTEGER", true, 0, null, 1));
                LinkedHashSet linkedHashSet17 = new LinkedHashSet();
                linkedHashSet17.add(new TableInfo.ForeignKey("Profile", "CASCADE", "NO ACTION", CollectionsKt.listOf("profileId"), CollectionsKt.listOf("id")));
                LinkedHashSet linkedHashSet18 = new LinkedHashSet();
                linkedHashSet18.add(new TableInfo.Index("index_UsageLimit_profileId", false, CollectionsKt.listOf("profileId"), CollectionsKt.listOf("ASC")));
                linkedHashSet18.add(new TableInfo.Index("index_UsageLimit_periodType", false, CollectionsKt.listOf("periodType"), CollectionsKt.listOf("ASC")));
                linkedHashSet18.add(new TableInfo.Index("index_UsageLimit_limitType", false, CollectionsKt.listOf("limitType"), CollectionsKt.listOf("ASC")));
                TableInfo tableInfo10 = new TableInfo("UsageLimit", linkedHashMap10, linkedHashSet17, linkedHashSet18);
                TableInfo tableInfoA10 = companion.a(connection, "UsageLimit");
                if (!tableInfo10.equals(tableInfoA10)) {
                    return new RoomOpenDelegate.ValidationResult(false, "UsageLimit(cz.mobilesoft.coreblock.storage.room.entity.blocking.UsageLimit).\n Expected:\n" + tableInfo10 + "\n Found:\n" + tableInfoA10);
                }
                LinkedHashMap linkedHashMap11 = new LinkedHashMap();
                linkedHashMap11.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, 1));
                linkedHashMap11.put("profileId", new TableInfo.Column("profileId", "INTEGER", true, 0, null, 1));
                linkedHashMap11.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, 1));
                linkedHashMap11.put("blockingType", new TableInfo.Column("blockingType", "INTEGER", true, 0, null, 1));
                linkedHashMap11.put("isAnywhereInUrl", new TableInfo.Column("isAnywhereInUrl", "INTEGER", true, 0, null, 1));
                linkedHashMap11.put("isEnabled", new TableInfo.Column("isEnabled", "INTEGER", true, 0, null, 1));
                LinkedHashSet linkedHashSet19 = new LinkedHashSet();
                linkedHashSet19.add(new TableInfo.ForeignKey("Profile", "CASCADE", "NO ACTION", CollectionsKt.listOf("profileId"), CollectionsKt.listOf("id")));
                LinkedHashSet linkedHashSet20 = new LinkedHashSet();
                linkedHashSet20.add(new TableInfo.Index("index_WebsiteProfileRelation_profileId", false, CollectionsKt.listOf("profileId"), CollectionsKt.listOf("ASC")));
                TableInfo tableInfo11 = new TableInfo("WebsiteProfileRelation", linkedHashMap11, linkedHashSet19, linkedHashSet20);
                TableInfo tableInfoA11 = companion.a(connection, "WebsiteProfileRelation");
                if (!tableInfo11.equals(tableInfoA11)) {
                    return new RoomOpenDelegate.ValidationResult(false, "WebsiteProfileRelation(cz.mobilesoft.coreblock.storage.room.entity.blocking.WebsiteProfileRelation).\n Expected:\n" + tableInfo11 + "\n Found:\n" + tableInfoA11);
                }
                LinkedHashMap linkedHashMap12 = new LinkedHashMap();
                linkedHashMap12.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, 1));
                linkedHashMap12.put("profileId", new TableInfo.Column("profileId", "INTEGER", true, 0, null, 1));
                linkedHashMap12.put("ssid", new TableInfo.Column("ssid", "TEXT", true, 0, null, 1));
                LinkedHashSet linkedHashSet21 = new LinkedHashSet();
                linkedHashSet21.add(new TableInfo.ForeignKey("Profile", "CASCADE", "NO ACTION", CollectionsKt.listOf("profileId"), CollectionsKt.listOf("id")));
                LinkedHashSet linkedHashSet22 = new LinkedHashSet();
                linkedHashSet22.add(new TableInfo.Index("index_WifiNetwork_profileId", false, CollectionsKt.listOf("profileId"), CollectionsKt.listOf("ASC")));
                TableInfo tableInfo12 = new TableInfo("WifiNetwork", linkedHashMap12, linkedHashSet21, linkedHashSet22);
                TableInfo tableInfoA12 = companion.a(connection, "WifiNetwork");
                if (!tableInfo12.equals(tableInfoA12)) {
                    return new RoomOpenDelegate.ValidationResult(false, "WifiNetwork(cz.mobilesoft.coreblock.storage.room.entity.blocking.WifiNetwork).\n Expected:\n" + tableInfo12 + "\n Found:\n" + tableInfoA12);
                }
                LinkedHashMap linkedHashMap13 = new LinkedHashMap();
                linkedHashMap13.put("url", new TableInfo.Column("url", "TEXT", true, 1, null, 1));
                TableInfo tableInfo13 = new TableInfo("AdultContentWebsite", linkedHashMap13, new LinkedHashSet(), new LinkedHashSet());
                TableInfo tableInfoA13 = companion.a(connection, "AdultContentWebsite");
                if (!tableInfo13.equals(tableInfoA13)) {
                    return new RoomOpenDelegate.ValidationResult(false, "AdultContentWebsite(cz.mobilesoft.coreblock.storage.room.entity.blocking.AdultContentWebsite).\n Expected:\n" + tableInfo13 + "\n Found:\n" + tableInfoA13);
                }
                LinkedHashMap linkedHashMap14 = new LinkedHashMap();
                linkedHashMap14.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, 1));
                linkedHashMap14.put("pauseTimeSeconds", new TableInfo.Column("pauseTimeSeconds", "INTEGER", true, 0, null, 1));
                linkedHashMap14.put("updatedAt", new TableInfo.Column("updatedAt", "INTEGER", true, 0, null, 1));
                linkedHashMap14.put("isForToday", new TableInfo.Column("isForToday", "INTEGER", true, 0, null, 1));
                linkedHashMap14.put("profileId", new TableInfo.Column("profileId", "INTEGER", false, 0, null, 1));
                TableInfo tableInfo14 = new TableInfo("SchedulePauseHistoryTable", linkedHashMap14, new LinkedHashSet(), new LinkedHashSet());
                TableInfo tableInfoA14 = companion.a(connection, "SchedulePauseHistoryTable");
                if (!tableInfo14.equals(tableInfoA14)) {
                    return new RoomOpenDelegate.ValidationResult(false, "SchedulePauseHistoryTable(cz.mobilesoft.coreblock.storage.room.entity.core.SchedulePauseHistoryEntity).\n Expected:\n" + tableInfo14 + "\n Found:\n" + tableInfoA14);
                }
                LinkedHashMap linkedHashMap15 = new LinkedHashMap();
                linkedHashMap15.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, 1));
                linkedHashMap15.put("timeMillis", new TableInfo.Column("timeMillis", "INTEGER", true, 0, null, 1));
                linkedHashMap15.put("updatedAt", new TableInfo.Column("updatedAt", "INTEGER", true, 0, null, 1));
                TableInfo tableInfo15 = new TableInfo("QuickBlockTimerHistory", linkedHashMap15, new LinkedHashSet(), new LinkedHashSet());
                TableInfo tableInfoA15 = companion.a(connection, "QuickBlockTimerHistory");
                if (!tableInfo15.equals(tableInfoA15)) {
                    return new RoomOpenDelegate.ValidationResult(false, "QuickBlockTimerHistory(cz.mobilesoft.coreblock.storage.room.entity.core.QuickBlockTimerHistory).\n Expected:\n" + tableInfo15 + "\n Found:\n" + tableInfoA15);
                }
                LinkedHashMap linkedHashMap16 = new LinkedHashMap();
                linkedHashMap16.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, 1));
                linkedHashMap16.put("focusTimeMillis", new TableInfo.Column("focusTimeMillis", "INTEGER", true, 0, null, 1));
                linkedHashMap16.put("breakTimeMillis", new TableInfo.Column("breakTimeMillis", "INTEGER", true, 0, null, 1));
                linkedHashMap16.put("sessionCount", new TableInfo.Column("sessionCount", "INTEGER", true, 0, null, 1));
                linkedHashMap16.put("updatedAt", new TableInfo.Column("updatedAt", "INTEGER", true, 0, null, 1));
                TableInfo tableInfo16 = new TableInfo("PomodoroHistory", linkedHashMap16, new LinkedHashSet(), new LinkedHashSet());
                TableInfo tableInfoA16 = companion.a(connection, "PomodoroHistory");
                if (!tableInfo16.equals(tableInfoA16)) {
                    return new RoomOpenDelegate.ValidationResult(false, "PomodoroHistory(cz.mobilesoft.coreblock.storage.room.entity.core.PomodoroHistory).\n Expected:\n" + tableInfo16 + "\n Found:\n" + tableInfoA16);
                }
                LinkedHashMap linkedHashMap17 = new LinkedHashMap();
                linkedHashMap17.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, 1));
                linkedHashMap17.put("profileId", new TableInfo.Column("profileId", "INTEGER", true, 0, null, 1));
                linkedHashMap17.put("originalStartTime", new TableInfo.Column("originalStartTime", "INTEGER", true, 0, null, 1));
                linkedHashMap17.put("focusTime", new TableInfo.Column("focusTime", "INTEGER", true, 0, null, 1));
                linkedHashMap17.put("breakTime", new TableInfo.Column("breakTime", "INTEGER", true, 0, null, 1));
                linkedHashMap17.put("sessionCount", new TableInfo.Column("sessionCount", "INTEGER", true, 0, null, 1));
                linkedHashMap17.put("isStoppedManually", new TableInfo.Column("isStoppedManually", "INTEGER", true, 0, null, 1));
                linkedHashMap17.put("originalEndTime", new TableInfo.Column("originalEndTime", "INTEGER", true, 0, null, 1));
                linkedHashMap17.put("adjustedEndTime", new TableInfo.Column("adjustedEndTime", "INTEGER", true, 0, null, 1));
                LinkedHashSet linkedHashSet23 = new LinkedHashSet();
                LinkedHashSet linkedHashSet24 = new LinkedHashSet();
                linkedHashSet24.add(new TableInfo.Index("index_PomodoroSession_profileId", false, CollectionsKt.listOf("profileId"), CollectionsKt.listOf("ASC")));
                TableInfo tableInfo17 = new TableInfo("PomodoroSession", linkedHashMap17, linkedHashSet23, linkedHashSet24);
                TableInfo tableInfoA17 = companion.a(connection, "PomodoroSession");
                if (!tableInfo17.equals(tableInfoA17)) {
                    return new RoomOpenDelegate.ValidationResult(false, "PomodoroSession(cz.mobilesoft.coreblock.storage.room.entity.blocking.PomodoroSession).\n Expected:\n" + tableInfo17 + "\n Found:\n" + tableInfoA17);
                }
                LinkedHashMap linkedHashMap18 = new LinkedHashMap();
                linkedHashMap18.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, 1));
                linkedHashMap18.put("profileId", new TableInfo.Column("profileId", "INTEGER", true, 0, null, 1));
                linkedHashMap18.put("subAppId", new TableInfo.Column("subAppId", "TEXT", true, 0, null, 1));
                LinkedHashSet linkedHashSet25 = new LinkedHashSet();
                linkedHashSet25.add(new TableInfo.ForeignKey("Profile", "CASCADE", "NO ACTION", CollectionsKt.listOf("profileId"), CollectionsKt.listOf("id")));
                LinkedHashSet linkedHashSet26 = new LinkedHashSet();
                linkedHashSet26.add(new TableInfo.Index("index_SubAppRelation_profileId", false, CollectionsKt.listOf("profileId"), CollectionsKt.listOf("ASC")));
                TableInfo tableInfo18 = new TableInfo("SubAppRelation", linkedHashMap18, linkedHashSet25, linkedHashSet26);
                TableInfo tableInfoA18 = companion.a(connection, "SubAppRelation");
                if (!tableInfo18.equals(tableInfoA18)) {
                    return new RoomOpenDelegate.ValidationResult(false, "SubAppRelation(cz.mobilesoft.coreblock.storage.room.entity.blocking.SubAppRelation).\n Expected:\n" + tableInfo18 + "\n Found:\n" + tableInfoA18);
                }
                LinkedHashMap linkedHashMap19 = new LinkedHashMap();
                linkedHashMap19.put("dayKey", new TableInfo.Column("dayKey", "TEXT", true, 1, null, 1));
                linkedHashMap19.put("dayStartMillis", new TableInfo.Column("dayStartMillis", "INTEGER", true, 0, null, 1));
                linkedHashMap19.put("timeZoneId", new TableInfo.Column("timeZoneId", "TEXT", true, 0, null, 1));
                linkedHashMap19.put(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, new TableInfo.Column(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, "INTEGER", true, 0, AppEventsConstants.EVENT_PARAM_VALUE_NO, 1));
                linkedHashMap19.put("lossReason", new TableInfo.Column("lossReason", "INTEGER", true, 0, AppEventsConstants.EVENT_PARAM_VALUE_NO, 1));
                linkedHashMap19.put("evaluatedAtMillis", new TableInfo.Column("evaluatedAtMillis", "INTEGER", true, 0, null, 1));
                linkedHashMap19.put("earnedAtMillis", new TableInfo.Column("earnedAtMillis", "INTEGER", false, 0, null, 1));
                linkedHashMap19.put("rulesVersion", new TableInfo.Column("rulesVersion", "INTEGER", true, 0, AppEventsConstants.EVENT_PARAM_VALUE_NO, 1));
                TableInfo tableInfo19 = new TableInfo("StreakDay", linkedHashMap19, new LinkedHashSet(), new LinkedHashSet());
                TableInfo tableInfoA19 = companion.a(connection, "StreakDay");
                if (!tableInfo19.equals(tableInfoA19)) {
                    return new RoomOpenDelegate.ValidationResult(false, "StreakDay(cz.mobilesoft.coreblock.storage.room.entity.blocking.StreakDayEntity).\n Expected:\n" + tableInfo19 + "\n Found:\n" + tableInfoA19);
                }
                LinkedHashMap linkedHashMap20 = new LinkedHashMap();
                linkedHashMap20.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, 1));
                linkedHashMap20.put("profileId", new TableInfo.Column("profileId", "INTEGER", false, 0, null, 1));
                linkedHashMap20.put("startMillis", new TableInfo.Column("startMillis", "INTEGER", true, 0, null, 1));
                linkedHashMap20.put("endMillis", new TableInfo.Column("endMillis", "INTEGER", true, 0, null, 1));
                linkedHashMap20.put("createdAtMillis", new TableInfo.Column("createdAtMillis", "INTEGER", true, 0, null, 1));
                LinkedHashSet linkedHashSet27 = new LinkedHashSet();
                LinkedHashSet linkedHashSet28 = new LinkedHashSet();
                linkedHashSet28.add(new TableInfo.Index("index_StreakActivitySession_profileId", false, CollectionsKt.listOf("profileId"), CollectionsKt.listOf("ASC")));
                linkedHashSet28.add(new TableInfo.Index("index_StreakActivitySession_startMillis", false, CollectionsKt.listOf("startMillis"), CollectionsKt.listOf("ASC")));
                linkedHashSet28.add(new TableInfo.Index("index_StreakActivitySession_endMillis", false, CollectionsKt.listOf("endMillis"), CollectionsKt.listOf("ASC")));
                TableInfo tableInfo20 = new TableInfo("StreakActivitySession", linkedHashMap20, linkedHashSet27, linkedHashSet28);
                TableInfo tableInfoA20 = companion.a(connection, "StreakActivitySession");
                if (!tableInfo20.equals(tableInfoA20)) {
                    return new RoomOpenDelegate.ValidationResult(false, "StreakActivitySession(cz.mobilesoft.coreblock.storage.room.entity.blocking.StreakActivitySessionEntity).\n Expected:\n" + tableInfo20 + "\n Found:\n" + tableInfoA20);
                }
                LinkedHashMap linkedHashMap21 = new LinkedHashMap();
                linkedHashMap21.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, 1));
                linkedHashMap21.put("profileId", new TableInfo.Column("profileId", "INTEGER", true, 0, null, 1));
                linkedHashMap21.put("startMillis", new TableInfo.Column("startMillis", "INTEGER", true, 0, null, 1));
                linkedHashMap21.put("plannedEndMillis", new TableInfo.Column("plannedEndMillis", "INTEGER", true, 0, null, 1));
                linkedHashMap21.put("endedAtMillis", new TableInfo.Column("endedAtMillis", "INTEGER", false, 0, null, 1));
                linkedHashMap21.put("isIndefinite", new TableInfo.Column("isIndefinite", "INTEGER", true, 0, AppEventsConstants.EVENT_PARAM_VALUE_NO, 1));
                LinkedHashSet linkedHashSet29 = new LinkedHashSet();
                LinkedHashSet linkedHashSet30 = new LinkedHashSet();
                linkedHashSet30.add(new TableInfo.Index("index_StreakPauseRecord_profileId", false, CollectionsKt.listOf("profileId"), CollectionsKt.listOf("ASC")));
                linkedHashSet30.add(new TableInfo.Index("index_StreakPauseRecord_startMillis", false, CollectionsKt.listOf("startMillis"), CollectionsKt.listOf("ASC")));
                TableInfo tableInfo21 = new TableInfo("StreakPauseRecord", linkedHashMap21, linkedHashSet29, linkedHashSet30);
                TableInfo tableInfoA21 = companion.a(connection, "StreakPauseRecord");
                if (tableInfo21.equals(tableInfoA21)) {
                    return new RoomOpenDelegate.ValidationResult(true, null);
                }
                return new RoomOpenDelegate.ValidationResult(false, "StreakPauseRecord(cz.mobilesoft.coreblock.storage.room.entity.blocking.StreakPauseRecordEntity).\n Expected:\n" + tableInfo21 + "\n Found:\n" + tableInfoA21);
            }
        };
    }
}
