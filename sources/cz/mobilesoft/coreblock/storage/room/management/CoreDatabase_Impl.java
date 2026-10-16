package cz.mobilesoft.coreblock.storage.room.management;

import androidx.media3.common.JBEE.bfIdKSjLOVjG;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenDelegate;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.SQLite;
import androidx.sqlite.SQLiteConnection;
import com.applovin.sdk.AppLovinEventParameters;
import com.bumptech.glide.load.data.Bwyd.SbbqvQlxi;
import com.facebook.AccessToken;
import com.facebook.appevents.internal.Constants;
import cz.mobilesoft.coreblock.storage.room.dao.core.AcademyCourseDao;
import cz.mobilesoft.coreblock.storage.room.dao.core.AcademyCourseDao_Impl;
import cz.mobilesoft.coreblock.storage.room.dao.core.AcademyLessonDao;
import cz.mobilesoft.coreblock.storage.room.dao.core.AcademyLessonDao_Impl;
import cz.mobilesoft.coreblock.storage.room.dao.core.AppVersionDao;
import cz.mobilesoft.coreblock.storage.room.dao.core.AppVersionDao_Impl;
import cz.mobilesoft.coreblock.storage.room.dao.core.CustomBlockingScreenConfigDao;
import cz.mobilesoft.coreblock.storage.room.dao.core.CustomBlockingScreenConfigDao_Impl;
import cz.mobilesoft.coreblock.storage.room.dao.core.EmergencyUnblockingDao;
import cz.mobilesoft.coreblock.storage.room.dao.core.EmergencyUnblockingDao_Impl;
import cz.mobilesoft.coreblock.storage.room.dao.core.IgnoredStatisticsItemDao;
import cz.mobilesoft.coreblock.storage.room.dao.core.IgnoredStatisticsItemDao_Impl;
import cz.mobilesoft.coreblock.storage.room.dao.core.LaunchTimeDao;
import cz.mobilesoft.coreblock.storage.room.dao.core.LaunchTimeDao_Impl;
import cz.mobilesoft.coreblock.storage.room.dao.core.MoodCheckInEntityDao;
import cz.mobilesoft.coreblock.storage.room.dao.core.MoodCheckInEntityDao_Impl;
import cz.mobilesoft.coreblock.storage.room.dao.core.PricingPhaseDao;
import cz.mobilesoft.coreblock.storage.room.dao.core.PricingPhaseDao_Impl;
import cz.mobilesoft.coreblock.storage.room.dao.core.ProductDao;
import cz.mobilesoft.coreblock.storage.room.dao.core.ProductDao_Impl;
import cz.mobilesoft.coreblock.storage.room.dao.core.PurchasedOfferDao;
import cz.mobilesoft.coreblock.storage.room.dao.core.PurchasedOfferDao_Impl;
import cz.mobilesoft.coreblock.storage.room.dao.core.SubscriptionOptionDao;
import cz.mobilesoft.coreblock.storage.room.dao.core.SubscriptionOptionDao_Impl;
import cz.mobilesoft.coreblock.storage.room.dao.core.TokenFCMDao;
import cz.mobilesoft.coreblock.storage.room.dao.core.TokenFCMDao_Impl;
import cz.mobilesoft.coreblock.storage.room.dao.core.UsedBackdoorCodeDao;
import cz.mobilesoft.coreblock.storage.room.dao.core.UsedBackdoorCodeDao_Impl;
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
public final class CoreDatabase_Impl extends CoreDatabase {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Lazy f126674a = LazyKt.b(new Function0() { // from class: cz.mobilesoft.coreblock.storage.room.management.a0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return CoreDatabase_Impl.P(this.f126768a);
        }
    });

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Lazy f126675b = LazyKt.b(new Function0() { // from class: cz.mobilesoft.coreblock.storage.room.management.j0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return CoreDatabase_Impl.Q(this.f126786a);
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Lazy f126676c = LazyKt.b(new Function0() { // from class: cz.mobilesoft.coreblock.storage.room.management.k0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return CoreDatabase_Impl.b0(this.f126788a);
        }
    });

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Lazy f126677d = LazyKt.b(new Function0() { // from class: cz.mobilesoft.coreblock.storage.room.management.l0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return CoreDatabase_Impl.Y(this.f126790a);
        }
    });

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Lazy f126678e = LazyKt.b(new Function0() { // from class: cz.mobilesoft.coreblock.storage.room.management.m0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return CoreDatabase_Impl.a0(this.f126792a);
        }
    });

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Lazy f126679f = LazyKt.b(new Function0() { // from class: cz.mobilesoft.coreblock.storage.room.management.n0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return CoreDatabase_Impl.X(this.f126794a);
        }
    });

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Lazy f126680g = LazyKt.b(new Function0() { // from class: cz.mobilesoft.coreblock.storage.room.management.b0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return CoreDatabase_Impl.c0(this.f126770a);
        }
    });

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Lazy f126681h = LazyKt.b(new Function0() { // from class: cz.mobilesoft.coreblock.storage.room.management.c0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return CoreDatabase_Impl.R(this.f126772a);
        }
    });

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Lazy f126682i = LazyKt.b(new Function0() { // from class: cz.mobilesoft.coreblock.storage.room.management.d0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return CoreDatabase_Impl.Z(this.f126774a);
        }
    });

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Lazy f126683j = LazyKt.b(new Function0() { // from class: cz.mobilesoft.coreblock.storage.room.management.e0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return CoreDatabase_Impl.V(this.f126776a);
        }
    });

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final Lazy f126684k = LazyKt.b(new Function0() { // from class: cz.mobilesoft.coreblock.storage.room.management.f0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return CoreDatabase_Impl.U(this.f126778a);
        }
    });

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final Lazy f126685l = LazyKt.b(new Function0() { // from class: cz.mobilesoft.coreblock.storage.room.management.g0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return CoreDatabase_Impl.T(this.f126780a);
        }
    });

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final Lazy f126686m = LazyKt.b(new Function0() { // from class: cz.mobilesoft.coreblock.storage.room.management.h0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return CoreDatabase_Impl.S(this.f126782a);
        }
    });

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final Lazy f126687n = LazyKt.b(new Function0() { // from class: cz.mobilesoft.coreblock.storage.room.management.i0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return CoreDatabase_Impl.W(this.f126784a);
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final AcademyCourseDao_Impl P(CoreDatabase_Impl coreDatabase_Impl) {
        return new AcademyCourseDao_Impl(coreDatabase_Impl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AcademyLessonDao_Impl Q(CoreDatabase_Impl coreDatabase_Impl) {
        return new AcademyLessonDao_Impl(coreDatabase_Impl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AppVersionDao_Impl R(CoreDatabase_Impl coreDatabase_Impl) {
        return new AppVersionDao_Impl(coreDatabase_Impl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CustomBlockingScreenConfigDao_Impl S(CoreDatabase_Impl coreDatabase_Impl) {
        return new CustomBlockingScreenConfigDao_Impl(coreDatabase_Impl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final EmergencyUnblockingDao_Impl T(CoreDatabase_Impl coreDatabase_Impl) {
        return new EmergencyUnblockingDao_Impl(coreDatabase_Impl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IgnoredStatisticsItemDao_Impl U(CoreDatabase_Impl coreDatabase_Impl) {
        return new IgnoredStatisticsItemDao_Impl(coreDatabase_Impl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LaunchTimeDao_Impl V(CoreDatabase_Impl coreDatabase_Impl) {
        return new LaunchTimeDao_Impl(coreDatabase_Impl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MoodCheckInEntityDao_Impl W(CoreDatabase_Impl coreDatabase_Impl) {
        return new MoodCheckInEntityDao_Impl(coreDatabase_Impl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PricingPhaseDao_Impl X(CoreDatabase_Impl coreDatabase_Impl) {
        return new PricingPhaseDao_Impl(coreDatabase_Impl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ProductDao_Impl Y(CoreDatabase_Impl coreDatabase_Impl) {
        return new ProductDao_Impl(coreDatabase_Impl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PurchasedOfferDao_Impl Z(CoreDatabase_Impl coreDatabase_Impl) {
        return new PurchasedOfferDao_Impl(coreDatabase_Impl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SubscriptionOptionDao_Impl a0(CoreDatabase_Impl coreDatabase_Impl) {
        return new SubscriptionOptionDao_Impl(coreDatabase_Impl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TokenFCMDao_Impl b0(CoreDatabase_Impl coreDatabase_Impl) {
        return new TokenFCMDao_Impl(coreDatabase_Impl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final UsedBackdoorCodeDao_Impl c0(CoreDatabase_Impl coreDatabase_Impl) {
        return new UsedBackdoorCodeDao_Impl(coreDatabase_Impl);
    }

    @Override // cz.mobilesoft.coreblock.storage.room.management.CoreDatabase
    public UsedBackdoorCodeDao A() {
        return (UsedBackdoorCodeDao) this.f126680g.getValue();
    }

    @Override // androidx.room.RoomDatabase
    public void clearAllTables() {
        super.performClear(true, "academy_course", "academy_lesson", "TokenFCMEntity", "ProductEntity", "UsedBackdoorCodeEntity", "AppVersionEntity", "SubscriptionOptionEntity", "PricingPhaseEntity", "PurchasedOfferEntity", "IgnoredStatisticsItem", "LaunchTime", "EmergencyUnblocking", "BlockingConfig", "MoodCheckInEntity");
    }

    @Override // androidx.room.RoomDatabase
    public List createAutoMigrations(Map autoMigrationSpecs) {
        Intrinsics.checkNotNullParameter(autoMigrationSpecs, "autoMigrationSpecs");
        ArrayList arrayList = new ArrayList();
        arrayList.add(new CoreDatabase_AutoMigration_4_5_Impl());
        arrayList.add(new CoreDatabase_AutoMigration_5_6_Impl());
        arrayList.add(new CoreDatabase_AutoMigration_6_7_Impl());
        arrayList.add(new CoreDatabase_AutoMigration_8_9_Impl());
        arrayList.add(new CoreDatabase_AutoMigration_10_11_Impl());
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.room.RoomDatabase
    /* JADX INFO: renamed from: e0, reason: merged with bridge method [inline-methods] */
    public RoomOpenDelegate createOpenDelegate() {
        return new RoomOpenDelegate() { // from class: cz.mobilesoft.coreblock.storage.room.management.CoreDatabase_Impl$createOpenDelegate$_openDelegate$1
            {
                super(15, "75413f2b6705b1003214f5c88b70ac9f", "41b5221f46d47ebf784540cb32c4f5f4");
            }

            @Override // androidx.room.RoomOpenDelegate
            public void b(SQLiteConnection connection) throws Exception {
                Intrinsics.checkNotNullParameter(connection, "connection");
                SQLite.a(connection, "DROP TABLE IF EXISTS `academy_course`");
                SQLite.a(connection, "DROP TABLE IF EXISTS `academy_lesson`");
                SQLite.a(connection, "DROP TABLE IF EXISTS `TokenFCMEntity`");
                SQLite.a(connection, "DROP TABLE IF EXISTS `ProductEntity`");
                SQLite.a(connection, "DROP TABLE IF EXISTS `UsedBackdoorCodeEntity`");
                SQLite.a(connection, "DROP TABLE IF EXISTS `AppVersionEntity`");
                SQLite.a(connection, "DROP TABLE IF EXISTS `SubscriptionOptionEntity`");
                SQLite.a(connection, "DROP TABLE IF EXISTS `PricingPhaseEntity`");
                SQLite.a(connection, "DROP TABLE IF EXISTS `PurchasedOfferEntity`");
                SQLite.a(connection, "DROP TABLE IF EXISTS `IgnoredStatisticsItem`");
                SQLite.a(connection, "DROP TABLE IF EXISTS `LaunchTime`");
                SQLite.a(connection, "DROP TABLE IF EXISTS `EmergencyUnblocking`");
                SQLite.a(connection, "DROP TABLE IF EXISTS `BlockingConfig`");
                SQLite.a(connection, "DROP TABLE IF EXISTS `MoodCheckInEntity`");
            }

            @Override // androidx.room.RoomOpenDelegate
            public void f(SQLiteConnection connection) {
                Intrinsics.checkNotNullParameter(connection, "connection");
            }

            @Override // androidx.room.RoomOpenDelegate
            public void g(SQLiteConnection connection) throws Exception {
                Intrinsics.checkNotNullParameter(connection, "connection");
                SQLite.a(connection, "PRAGMA foreign_keys = ON");
                this.f126688d.internalInitInvalidationTracker(connection);
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
                linkedHashMap.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, 1));
                linkedHashMap.put("course_order", new TableInfo.Column("course_order", "INTEGER", true, 0, null, 1));
                linkedHashMap.put("title", new TableInfo.Column("title", "TEXT", true, 0, null, 1));
                linkedHashMap.put("lead", new TableInfo.Column("lead", "TEXT", true, 0, null, 1));
                linkedHashMap.put("icon_url", new TableInfo.Column("icon_url", "TEXT", true, 0, null, 1));
                linkedHashMap.put("course_state", new TableInfo.Column("course_state", "INTEGER", true, 0, null, 1));
                LinkedHashSet linkedHashSet = new LinkedHashSet();
                LinkedHashSet linkedHashSet2 = new LinkedHashSet();
                linkedHashSet2.add(new TableInfo.Index("index_academy_course_course_order", false, CollectionsKt.listOf("course_order"), CollectionsKt.listOf("ASC")));
                TableInfo tableInfo = new TableInfo("academy_course", linkedHashMap, linkedHashSet, linkedHashSet2);
                TableInfo.Companion companion = TableInfo.f52966e;
                TableInfo tableInfoA = companion.a(connection, "academy_course");
                if (!tableInfo.equals(tableInfoA)) {
                    return new RoomOpenDelegate.ValidationResult(false, "academy_course(cz.mobilesoft.coreblock.storage.room.entity.core.AcademyCourseEntity).\n Expected:\n" + tableInfo + "\n Found:\n" + tableInfoA);
                }
                LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                linkedHashMap2.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, 1));
                linkedHashMap2.put("course_id", new TableInfo.Column("course_id", "INTEGER", true, 0, null, 1));
                linkedHashMap2.put("lesson_order", new TableInfo.Column("lesson_order", "INTEGER", true, 0, null, 1));
                linkedHashMap2.put("title", new TableInfo.Column("title", "TEXT", true, 0, null, 1));
                linkedHashMap2.put("lead", new TableInfo.Column("lead", "TEXT", true, 0, null, 1));
                linkedHashMap2.put("body", new TableInfo.Column("body", "TEXT", true, 0, null, 1));
                linkedHashMap2.put("unlocked_at", new TableInfo.Column("unlocked_at", "INTEGER", true, 0, null, 1));
                linkedHashMap2.put("finished_at", new TableInfo.Column("finished_at", "INTEGER", true, 0, null, 1));
                linkedHashMap2.put("lesson_state", new TableInfo.Column("lesson_state", "INTEGER", true, 0, null, 1));
                LinkedHashSet linkedHashSet3 = new LinkedHashSet();
                linkedHashSet3.add(new TableInfo.ForeignKey("academy_course", "CASCADE", "NO ACTION", CollectionsKt.listOf("course_id"), CollectionsKt.listOf("id")));
                LinkedHashSet linkedHashSet4 = new LinkedHashSet();
                linkedHashSet4.add(new TableInfo.Index("index_academy_lesson_course_id", false, CollectionsKt.listOf("course_id"), CollectionsKt.listOf("ASC")));
                linkedHashSet4.add(new TableInfo.Index("index_academy_lesson_lesson_order", false, CollectionsKt.listOf("lesson_order"), CollectionsKt.listOf("ASC")));
                TableInfo tableInfo2 = new TableInfo("academy_lesson", linkedHashMap2, linkedHashSet3, linkedHashSet4);
                TableInfo tableInfoA2 = companion.a(connection, "academy_lesson");
                if (!tableInfo2.equals(tableInfoA2)) {
                    return new RoomOpenDelegate.ValidationResult(false, "academy_lesson(cz.mobilesoft.coreblock.storage.room.entity.core.AcademyLessonEntity).\n Expected:\n" + tableInfo2 + "\n Found:\n" + tableInfoA2);
                }
                LinkedHashMap linkedHashMap3 = new LinkedHashMap();
                linkedHashMap3.put(AccessToken.TOKEN_KEY, new TableInfo.Column(AccessToken.TOKEN_KEY, "TEXT", true, 1, null, 1));
                linkedHashMap3.put("isSyncedWithServer", new TableInfo.Column("isSyncedWithServer", "INTEGER", true, 0, null, 1));
                TableInfo tableInfo3 = new TableInfo("TokenFCMEntity", linkedHashMap3, new LinkedHashSet(), new LinkedHashSet());
                TableInfo tableInfoA3 = companion.a(connection, "TokenFCMEntity");
                if (!tableInfo3.equals(tableInfoA3)) {
                    return new RoomOpenDelegate.ValidationResult(false, "TokenFCMEntity(cz.mobilesoft.coreblock.storage.room.entity.core.TokenFCMEntity).\n Expected:\n" + tableInfo3 + "\n Found:\n" + tableInfoA3);
                }
                LinkedHashMap linkedHashMap4 = new LinkedHashMap();
                linkedHashMap4.put("productId", new TableInfo.Column("productId", "TEXT", true, 1, null, 1));
                linkedHashMap4.put("revenueCatId", new TableInfo.Column("revenueCatId", "TEXT", true, 0, null, 1));
                linkedHashMap4.put("title", new TableInfo.Column("title", "TEXT", false, 0, null, 1));
                linkedHashMap4.put("description", new TableInfo.Column("description", "TEXT", false, 0, null, 1));
                linkedHashMap4.put("isSubscription", new TableInfo.Column("isSubscription", "INTEGER", true, 0, null, 1));
                linkedHashMap4.put(AppLovinEventParameters.REVENUE_CURRENCY, new TableInfo.Column(AppLovinEventParameters.REVENUE_CURRENCY, "TEXT", false, 0, null, 1));
                linkedHashMap4.put("priceValue", new TableInfo.Column("priceValue", "REAL", false, 0, null, 1));
                linkedHashMap4.put("priceText", new TableInfo.Column("priceText", "TEXT", false, 0, null, 1));
                linkedHashMap4.put("introductoryPriceValue", new TableInfo.Column("introductoryPriceValue", "REAL", false, 0, null, 1));
                linkedHashMap4.put("introductoryPriceText", new TableInfo.Column("introductoryPriceText", "TEXT", false, 0, null, 1));
                linkedHashMap4.put("isActive", new TableInfo.Column("isActive", "INTEGER", true, 0, null, 1));
                linkedHashMap4.put("orderInList", new TableInfo.Column("orderInList", "INTEGER", true, 0, null, 1));
                linkedHashMap4.put("purchaseToken", new TableInfo.Column("purchaseToken", "TEXT", false, 0, null, 1));
                linkedHashMap4.put("trialPeriod", new TableInfo.Column("trialPeriod", "TEXT", false, 0, null, 1));
                linkedHashMap4.put("isLifeTime", new TableInfo.Column("isLifeTime", "INTEGER", true, 0, null, 1));
                linkedHashMap4.put("deactivationTimeInMillis", new TableInfo.Column("deactivationTimeInMillis", "INTEGER", false, 0, null, 1));
                LinkedHashSet linkedHashSet5 = new LinkedHashSet();
                LinkedHashSet linkedHashSet6 = new LinkedHashSet();
                linkedHashSet6.add(new TableInfo.Index("index_ProductEntity_revenueCatId", false, CollectionsKt.listOf("revenueCatId"), CollectionsKt.listOf("ASC")));
                TableInfo tableInfo4 = new TableInfo("ProductEntity", linkedHashMap4, linkedHashSet5, linkedHashSet6);
                TableInfo tableInfoA4 = companion.a(connection, "ProductEntity");
                if (!tableInfo4.equals(tableInfoA4)) {
                    return new RoomOpenDelegate.ValidationResult(false, "ProductEntity(cz.mobilesoft.coreblock.storage.room.entity.core.ProductEntity).\n Expected:\n" + tableInfo4 + "\n Found:\n" + tableInfoA4);
                }
                LinkedHashMap linkedHashMap5 = new LinkedHashMap();
                linkedHashMap5.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, 1));
                linkedHashMap5.put("code", new TableInfo.Column("code", "TEXT", true, 0, null, 1));
                linkedHashMap5.put("timeInMillis", new TableInfo.Column("timeInMillis", "INTEGER", true, 0, null, 1));
                LinkedHashSet linkedHashSet7 = new LinkedHashSet();
                LinkedHashSet linkedHashSet8 = new LinkedHashSet();
                linkedHashSet8.add(new TableInfo.Index("index_UsedBackdoorCodeEntity_code", true, CollectionsKt.listOf("code"), CollectionsKt.listOf("ASC")));
                TableInfo tableInfo5 = new TableInfo("UsedBackdoorCodeEntity", linkedHashMap5, linkedHashSet7, linkedHashSet8);
                TableInfo tableInfoA5 = companion.a(connection, "UsedBackdoorCodeEntity");
                if (!tableInfo5.equals(tableInfoA5)) {
                    return new RoomOpenDelegate.ValidationResult(false, "UsedBackdoorCodeEntity(cz.mobilesoft.coreblock.storage.room.entity.core.UsedBackdoorCodeEntity).\n Expected:\n" + tableInfo5 + "\n Found:\n" + tableInfoA5);
                }
                LinkedHashMap linkedHashMap6 = new LinkedHashMap();
                linkedHashMap6.put("versionCode", new TableInfo.Column("versionCode", "INTEGER", true, 1, null, 1));
                linkedHashMap6.put("versionName", new TableInfo.Column("versionName", "TEXT", true, 0, null, 1));
                linkedHashMap6.put("firstInstallTime", new TableInfo.Column("firstInstallTime", "INTEGER", true, 0, null, 1));
                linkedHashMap6.put("changelogShownInPast", new TableInfo.Column("changelogShownInPast", "INTEGER", true, 0, null, 1));
                linkedHashMap6.put("changelogShowingNow", new TableInfo.Column("changelogShowingNow", "INTEGER", true, 0, null, 1));
                linkedHashMap6.put("whatsNewShownInPast", new TableInfo.Column("whatsNewShownInPast", "INTEGER", true, 0, null, 1));
                linkedHashMap6.put("whatsNewShowingNow", new TableInfo.Column("whatsNewShowingNow", "INTEGER", true, 0, null, 1));
                TableInfo tableInfo6 = new TableInfo("AppVersionEntity", linkedHashMap6, new LinkedHashSet(), new LinkedHashSet());
                TableInfo tableInfoA6 = companion.a(connection, "AppVersionEntity");
                if (!tableInfo6.equals(tableInfoA6)) {
                    return new RoomOpenDelegate.ValidationResult(false, "AppVersionEntity(cz.mobilesoft.coreblock.storage.room.entity.core.AppVersionEntity).\n Expected:\n" + tableInfo6 + "\n Found:\n" + tableInfoA6);
                }
                LinkedHashMap linkedHashMap7 = new LinkedHashMap();
                linkedHashMap7.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, 1));
                linkedHashMap7.put("productId", new TableInfo.Column("productId", "TEXT", true, 0, null, 1));
                linkedHashMap7.put("optionId", new TableInfo.Column("optionId", "TEXT", true, 0, null, 1));
                linkedHashMap7.put(Constants.GP_IAP_OFFER_ID, new TableInfo.Column(Constants.GP_IAP_OFFER_ID, "TEXT", true, 0, null, 1));
                linkedHashMap7.put("offerTags", new TableInfo.Column("offerTags", "TEXT", true, 0, null, 1));
                linkedHashMap7.put("offerToken", new TableInfo.Column("offerToken", "TEXT", false, 0, null, 1));
                LinkedHashSet linkedHashSet9 = new LinkedHashSet();
                linkedHashSet9.add(new TableInfo.ForeignKey("ProductEntity", "CASCADE", "NO ACTION", CollectionsKt.listOf("productId"), CollectionsKt.listOf("productId")));
                LinkedHashSet linkedHashSet10 = new LinkedHashSet();
                linkedHashSet10.add(new TableInfo.Index("index_SubscriptionOptionEntity_productId", false, CollectionsKt.listOf("productId"), CollectionsKt.listOf("ASC")));
                linkedHashSet10.add(new TableInfo.Index("index_SubscriptionOptionEntity_optionId", false, CollectionsKt.listOf("optionId"), CollectionsKt.listOf("ASC")));
                linkedHashSet10.add(new TableInfo.Index("index_SubscriptionOptionEntity_offerId", false, CollectionsKt.listOf(Constants.GP_IAP_OFFER_ID), CollectionsKt.listOf("ASC")));
                TableInfo tableInfo7 = new TableInfo("SubscriptionOptionEntity", linkedHashMap7, linkedHashSet9, linkedHashSet10);
                TableInfo tableInfoA7 = companion.a(connection, "SubscriptionOptionEntity");
                if (!tableInfo7.equals(tableInfoA7)) {
                    return new RoomOpenDelegate.ValidationResult(false, "SubscriptionOptionEntity(cz.mobilesoft.coreblock.storage.room.entity.core.SubscriptionOptionEntity).\n Expected:\n" + tableInfo7 + "\n Found:\n" + tableInfoA7);
                }
                LinkedHashMap linkedHashMap8 = new LinkedHashMap();
                linkedHashMap8.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, 1));
                linkedHashMap8.put("optionId", new TableInfo.Column("optionId", "INTEGER", true, 0, null, 1));
                linkedHashMap8.put("phaseIndex", new TableInfo.Column("phaseIndex", "INTEGER", true, 0, null, 1));
                linkedHashMap8.put("phaseType", new TableInfo.Column("phaseType", "INTEGER", true, 0, null, 1));
                linkedHashMap8.put("formattedPrice", new TableInfo.Column("formattedPrice", "TEXT", true, 0, null, 1));
                linkedHashMap8.put("priceAmount", new TableInfo.Column("priceAmount", "REAL", true, 0, null, 1));
                linkedHashMap8.put(Constants.GP_IAP_PRICE_CURRENCY_CODE_V5V7, new TableInfo.Column(Constants.GP_IAP_PRICE_CURRENCY_CODE_V5V7, "TEXT", true, 0, null, 1));
                linkedHashMap8.put(Constants.GP_IAP_BILLING_PERIOD, new TableInfo.Column(Constants.GP_IAP_BILLING_PERIOD, "TEXT", true, 0, null, 1));
                linkedHashMap8.put("billingCycleCount", new TableInfo.Column("billingCycleCount", "INTEGER", true, 0, null, 1));
                linkedHashMap8.put(Constants.GP_IAP_RECURRENCE_MODE, new TableInfo.Column(Constants.GP_IAP_RECURRENCE_MODE, "INTEGER", true, 0, null, 1));
                LinkedHashSet linkedHashSet11 = new LinkedHashSet();
                linkedHashSet11.add(new TableInfo.ForeignKey("SubscriptionOptionEntity", "CASCADE", "NO ACTION", CollectionsKt.listOf("optionId"), CollectionsKt.listOf("id")));
                LinkedHashSet linkedHashSet12 = new LinkedHashSet();
                linkedHashSet12.add(new TableInfo.Index("index_PricingPhaseEntity_optionId", false, CollectionsKt.listOf("optionId"), CollectionsKt.listOf("ASC")));
                linkedHashSet12.add(new TableInfo.Index("index_PricingPhaseEntity_phaseIndex", false, CollectionsKt.listOf("phaseIndex"), CollectionsKt.listOf("ASC")));
                TableInfo tableInfo8 = new TableInfo("PricingPhaseEntity", linkedHashMap8, linkedHashSet11, linkedHashSet12);
                TableInfo tableInfoA8 = companion.a(connection, "PricingPhaseEntity");
                if (!tableInfo8.equals(tableInfoA8)) {
                    return new RoomOpenDelegate.ValidationResult(false, "PricingPhaseEntity(cz.mobilesoft.coreblock.storage.room.premium.PricingPhaseEntity).\n Expected:\n" + tableInfo8 + "\n Found:\n" + tableInfoA8);
                }
                LinkedHashMap linkedHashMap9 = new LinkedHashMap();
                linkedHashMap9.put("purchaseToken", new TableInfo.Column("purchaseToken", "TEXT", true, 1, null, 1));
                linkedHashMap9.put("productId", new TableInfo.Column("productId", "TEXT", true, 0, null, 1));
                linkedHashMap9.put("offerTags", new TableInfo.Column("offerTags", "TEXT", true, 0, null, 1));
                linkedHashMap9.put(Constants.GP_IAP_PURCHASE_TIME, new TableInfo.Column(Constants.GP_IAP_PURCHASE_TIME, "TEXT", true, 0, null, 1));
                linkedHashMap9.put("isSynchronized", new TableInfo.Column("isSynchronized", "INTEGER", true, 0, null, 1));
                TableInfo tableInfo9 = new TableInfo("PurchasedOfferEntity", linkedHashMap9, new LinkedHashSet(), new LinkedHashSet());
                TableInfo tableInfoA9 = companion.a(connection, "PurchasedOfferEntity");
                if (!tableInfo9.equals(tableInfoA9)) {
                    return new RoomOpenDelegate.ValidationResult(false, "PurchasedOfferEntity(cz.mobilesoft.coreblock.storage.room.entity.core.PurchasedOfferEntity).\n Expected:\n" + tableInfo9 + "\n Found:\n" + tableInfoA9);
                }
                LinkedHashMap linkedHashMap10 = new LinkedHashMap();
                linkedHashMap10.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, 1));
                linkedHashMap10.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, 1));
                linkedHashMap10.put("type", new TableInfo.Column("type", "INTEGER", true, 0, null, 1));
                linkedHashMap10.put("itemSourceType", new TableInfo.Column("itemSourceType", "INTEGER", true, 0, null, 1));
                linkedHashMap10.put("isActive", new TableInfo.Column("isActive", "INTEGER", true, 0, null, 1));
                linkedHashMap10.put("isInstalled", new TableInfo.Column("isInstalled", "INTEGER", true, 0, null, 1));
                LinkedHashSet linkedHashSet13 = new LinkedHashSet();
                LinkedHashSet linkedHashSet14 = new LinkedHashSet();
                linkedHashSet14.add(new TableInfo.Index("index_IgnoredStatisticsItem_name_type", true, CollectionsKt.listOf((Object[]) new String[]{"name", "type"}), CollectionsKt.listOf((Object[]) new String[]{"ASC", "ASC"})));
                TableInfo tableInfo10 = new TableInfo("IgnoredStatisticsItem", linkedHashMap10, linkedHashSet13, linkedHashSet14);
                TableInfo tableInfoA10 = companion.a(connection, "IgnoredStatisticsItem");
                if (!tableInfo10.equals(tableInfoA10)) {
                    return new RoomOpenDelegate.ValidationResult(false, "IgnoredStatisticsItem(cz.mobilesoft.coreblock.storage.room.entity.core.IgnoredStatisticsItem).\n Expected:\n" + tableInfo10 + "\n Found:\n" + tableInfoA10);
                }
                LinkedHashMap linkedHashMap11 = new LinkedHashMap();
                linkedHashMap11.put("timestamp", new TableInfo.Column("timestamp", "INTEGER", true, 1, null, 1));
                TableInfo tableInfo11 = new TableInfo("LaunchTime", linkedHashMap11, new LinkedHashSet(), new LinkedHashSet());
                TableInfo tableInfoA11 = companion.a(connection, "LaunchTime");
                if (!tableInfo11.equals(tableInfoA11)) {
                    return new RoomOpenDelegate.ValidationResult(false, "LaunchTime(cz.mobilesoft.coreblock.storage.room.entity.core.LaunchTimeEntity).\n Expected:\n" + tableInfo11 + "\n Found:\n" + tableInfoA11);
                }
                LinkedHashMap linkedHashMap12 = new LinkedHashMap();
                linkedHashMap12.put("timestamp", new TableInfo.Column("timestamp", "INTEGER", true, 1, null, 1));
                TableInfo tableInfo12 = new TableInfo("EmergencyUnblocking", linkedHashMap12, new LinkedHashSet(), new LinkedHashSet());
                TableInfo tableInfoA12 = companion.a(connection, "EmergencyUnblocking");
                if (!tableInfo12.equals(tableInfoA12)) {
                    return new RoomOpenDelegate.ValidationResult(false, "EmergencyUnblocking(cz.mobilesoft.coreblock.storage.room.entity.core.EmergencyUnblockingEntity).\n Expected:\n" + tableInfo12 + "\n Found:\n" + tableInfoA12);
                }
                LinkedHashMap linkedHashMap13 = new LinkedHashMap();
                linkedHashMap13.put("id", new TableInfo.Column("id", "TEXT", true, 1, null, 1));
                linkedHashMap13.put("config_type", new TableInfo.Column("config_type", "INTEGER", true, 0, null, 1));
                linkedHashMap13.put("blocking_message", new TableInfo.Column("blocking_message", "TEXT", true, 0, null, 1));
                linkedHashMap13.put("show_reason", new TableInfo.Column("show_reason", "INTEGER", true, 0, null, 1));
                linkedHashMap13.put("timeout_seconds", new TableInfo.Column("timeout_seconds", "INTEGER", true, 0, null, 1));
                linkedHashMap13.put("show_counter", new TableInfo.Column("show_counter", "INTEGER", true, 0, null, 1));
                linkedHashMap13.put("icon_res", new TableInfo.Column("icon_res", "INTEGER", true, 0, null, 1));
                linkedHashMap13.put("custom_title", new TableInfo.Column("custom_title", "TEXT", true, 0, null, 1));
                linkedHashMap13.put("custom_subtitle", new TableInfo.Column("custom_subtitle", "TEXT", true, 0, null, 1));
                linkedHashMap13.put("custom_exit_button_text", new TableInfo.Column("custom_exit_button_text", "TEXT", true, 0, null, 1));
                linkedHashMap13.put("custom_color_hex", new TableInfo.Column("custom_color_hex", "TEXT", true, 0, null, 1));
                TableInfo tableInfo13 = new TableInfo("BlockingConfig", linkedHashMap13, new LinkedHashSet(), new LinkedHashSet());
                TableInfo tableInfoA13 = companion.a(connection, "BlockingConfig");
                if (!tableInfo13.equals(tableInfoA13)) {
                    return new RoomOpenDelegate.ValidationResult(false, "BlockingConfig(cz.mobilesoft.coreblock.storage.room.entity.core.CustomBlockingScreenConfigEntity).\n Expected:\n" + tableInfo13 + "\n Found:\n" + tableInfoA13);
                }
                LinkedHashMap linkedHashMap14 = new LinkedHashMap();
                linkedHashMap14.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, 1));
                linkedHashMap14.put("mood", new TableInfo.Column("mood", "INTEGER", true, 0, null, 1));
                linkedHashMap14.put("mood_raw_value", new TableInfo.Column("mood_raw_value", "INTEGER", true, 0, null, 1));
                linkedHashMap14.put("day", new TableInfo.Column("day", "TEXT", true, 0, null, 1));
                linkedHashMap14.put("created_at", new TableInfo.Column("created_at", "INTEGER", true, 0, null, 1));
                linkedHashMap14.put("note", new TableInfo.Column("note", "TEXT", false, 0, null, 1));
                LinkedHashSet linkedHashSet15 = new LinkedHashSet();
                LinkedHashSet linkedHashSet16 = new LinkedHashSet();
                linkedHashSet16.add(new TableInfo.Index("index_MoodCheckInEntity_day", true, CollectionsKt.listOf("day"), CollectionsKt.listOf("ASC")));
                TableInfo tableInfo14 = new TableInfo("MoodCheckInEntity", linkedHashMap14, linkedHashSet15, linkedHashSet16);
                TableInfo tableInfoA14 = companion.a(connection, "MoodCheckInEntity");
                if (tableInfo14.equals(tableInfoA14)) {
                    return new RoomOpenDelegate.ValidationResult(true, null);
                }
                return new RoomOpenDelegate.ValidationResult(false, "MoodCheckInEntity(cz.mobilesoft.coreblock.storage.room.entity.core.MoodCheckInEntity).\n Expected:\n" + tableInfo14 + "\n Found:\n" + tableInfoA14);
            }

            @Override // androidx.room.RoomOpenDelegate
            public void a(SQLiteConnection connection) throws Exception {
                Intrinsics.checkNotNullParameter(connection, "connection");
                SQLite.a(connection, "CREATE TABLE IF NOT EXISTS `academy_course` (`id` INTEGER NOT NULL, `course_order` INTEGER NOT NULL, `title` TEXT NOT NULL, `lead` TEXT NOT NULL, `icon_url` TEXT NOT NULL, `course_state` INTEGER NOT NULL, PRIMARY KEY(`id`))");
                SQLite.a(connection, "CREATE INDEX IF NOT EXISTS `index_academy_course_course_order` ON `academy_course` (`course_order`)");
                SQLite.a(connection, "CREATE TABLE IF NOT EXISTS `academy_lesson` (`id` INTEGER NOT NULL, `course_id` INTEGER NOT NULL, `lesson_order` INTEGER NOT NULL, `title` TEXT NOT NULL, `lead` TEXT NOT NULL, `body` TEXT NOT NULL, `unlocked_at` INTEGER NOT NULL, `finished_at` INTEGER NOT NULL, `lesson_state` INTEGER NOT NULL, PRIMARY KEY(`id`), FOREIGN KEY(`course_id`) REFERENCES `academy_course`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE )");
                SQLite.a(connection, "CREATE INDEX IF NOT EXISTS `index_academy_lesson_course_id` ON `academy_lesson` (`course_id`)");
                SQLite.a(connection, "CREATE INDEX IF NOT EXISTS `index_academy_lesson_lesson_order` ON `academy_lesson` (`lesson_order`)");
                SQLite.a(connection, bfIdKSjLOVjG.AkGGPknLrWjj);
                SQLite.a(connection, "CREATE TABLE IF NOT EXISTS `ProductEntity` (`productId` TEXT NOT NULL, `revenueCatId` TEXT NOT NULL, `title` TEXT, `description` TEXT, `isSubscription` INTEGER NOT NULL, `currency` TEXT, `priceValue` REAL, `priceText` TEXT, `introductoryPriceValue` REAL, `introductoryPriceText` TEXT, `isActive` INTEGER NOT NULL, `orderInList` INTEGER NOT NULL, `purchaseToken` TEXT, `trialPeriod` TEXT, `isLifeTime` INTEGER NOT NULL, `deactivationTimeInMillis` INTEGER, PRIMARY KEY(`productId`))");
                SQLite.a(connection, "CREATE INDEX IF NOT EXISTS `index_ProductEntity_revenueCatId` ON `ProductEntity` (`revenueCatId`)");
                SQLite.a(connection, "CREATE TABLE IF NOT EXISTS `UsedBackdoorCodeEntity` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `code` TEXT NOT NULL, `timeInMillis` INTEGER NOT NULL)");
                SQLite.a(connection, "CREATE UNIQUE INDEX IF NOT EXISTS `index_UsedBackdoorCodeEntity_code` ON `UsedBackdoorCodeEntity` (`code`)");
                SQLite.a(connection, "CREATE TABLE IF NOT EXISTS `AppVersionEntity` (`versionCode` INTEGER NOT NULL, `versionName` TEXT NOT NULL, `firstInstallTime` INTEGER NOT NULL, `changelogShownInPast` INTEGER NOT NULL, `changelogShowingNow` INTEGER NOT NULL, `whatsNewShownInPast` INTEGER NOT NULL, `whatsNewShowingNow` INTEGER NOT NULL, PRIMARY KEY(`versionCode`))");
                SQLite.a(connection, "CREATE TABLE IF NOT EXISTS `SubscriptionOptionEntity` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `productId` TEXT NOT NULL, `optionId` TEXT NOT NULL, `offerId` TEXT NOT NULL, `offerTags` TEXT NOT NULL, `offerToken` TEXT, FOREIGN KEY(`productId`) REFERENCES `ProductEntity`(`productId`) ON UPDATE NO ACTION ON DELETE CASCADE )");
                SQLite.a(connection, "CREATE INDEX IF NOT EXISTS `index_SubscriptionOptionEntity_productId` ON `SubscriptionOptionEntity` (`productId`)");
                SQLite.a(connection, "CREATE INDEX IF NOT EXISTS `index_SubscriptionOptionEntity_optionId` ON `SubscriptionOptionEntity` (`optionId`)");
                SQLite.a(connection, "CREATE INDEX IF NOT EXISTS `index_SubscriptionOptionEntity_offerId` ON `SubscriptionOptionEntity` (`offerId`)");
                SQLite.a(connection, "CREATE TABLE IF NOT EXISTS `PricingPhaseEntity` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `optionId` INTEGER NOT NULL, `phaseIndex` INTEGER NOT NULL, `phaseType` INTEGER NOT NULL, `formattedPrice` TEXT NOT NULL, `priceAmount` REAL NOT NULL, `priceCurrencyCode` TEXT NOT NULL, `billingPeriod` TEXT NOT NULL, `billingCycleCount` INTEGER NOT NULL, `recurrenceMode` INTEGER NOT NULL, FOREIGN KEY(`optionId`) REFERENCES `SubscriptionOptionEntity`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE )");
                SQLite.a(connection, "CREATE INDEX IF NOT EXISTS `index_PricingPhaseEntity_optionId` ON `PricingPhaseEntity` (`optionId`)");
                SQLite.a(connection, "CREATE INDEX IF NOT EXISTS `index_PricingPhaseEntity_phaseIndex` ON `PricingPhaseEntity` (`phaseIndex`)");
                SQLite.a(connection, "CREATE TABLE IF NOT EXISTS `PurchasedOfferEntity` (`purchaseToken` TEXT NOT NULL, `productId` TEXT NOT NULL, `offerTags` TEXT NOT NULL, `purchaseTime` TEXT NOT NULL, `isSynchronized` INTEGER NOT NULL, PRIMARY KEY(`purchaseToken`))");
                SQLite.a(connection, "CREATE TABLE IF NOT EXISTS `IgnoredStatisticsItem` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `name` TEXT NOT NULL, `type` INTEGER NOT NULL, `itemSourceType` INTEGER NOT NULL, `isActive` INTEGER NOT NULL, `isInstalled` INTEGER NOT NULL)");
                SQLite.a(connection, "CREATE UNIQUE INDEX IF NOT EXISTS `index_IgnoredStatisticsItem_name_type` ON `IgnoredStatisticsItem` (`name`, `type`)");
                SQLite.a(connection, "CREATE TABLE IF NOT EXISTS `LaunchTime` (`timestamp` INTEGER NOT NULL, PRIMARY KEY(`timestamp`))");
                SQLite.a(connection, "CREATE TABLE IF NOT EXISTS `EmergencyUnblocking` (`timestamp` INTEGER NOT NULL, PRIMARY KEY(`timestamp`))");
                SQLite.a(connection, "CREATE TABLE IF NOT EXISTS `BlockingConfig` (`id` TEXT NOT NULL, `config_type` INTEGER NOT NULL, `blocking_message` TEXT NOT NULL, `show_reason` INTEGER NOT NULL, `timeout_seconds` INTEGER NOT NULL, `show_counter` INTEGER NOT NULL, `icon_res` INTEGER NOT NULL, `custom_title` TEXT NOT NULL, `custom_subtitle` TEXT NOT NULL, `custom_exit_button_text` TEXT NOT NULL, `custom_color_hex` TEXT NOT NULL, PRIMARY KEY(`id`))");
                SQLite.a(connection, "CREATE TABLE IF NOT EXISTS `MoodCheckInEntity` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `mood` INTEGER NOT NULL, `mood_raw_value` INTEGER NOT NULL, `day` TEXT NOT NULL, `created_at` INTEGER NOT NULL, `note` TEXT)");
                SQLite.a(connection, "CREATE UNIQUE INDEX IF NOT EXISTS `index_MoodCheckInEntity_day` ON `MoodCheckInEntity` (`day`)");
                SQLite.a(connection, "CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
                SQLite.a(connection, "INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '75413f2b6705b1003214f5c88b70ac9f')");
            }
        };
    }

    @Override // androidx.room.RoomDatabase
    public Set getRequiredAutoMigrationSpecClasses() {
        return new LinkedHashSet();
    }

    @Override // androidx.room.RoomDatabase
    protected Map getRequiredTypeConverterClasses() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(Reflection.b(AcademyCourseDao.class), AcademyCourseDao_Impl.f125800i.a());
        linkedHashMap.put(Reflection.b(AcademyLessonDao.class), AcademyLessonDao_Impl.f125821i.a());
        linkedHashMap.put(Reflection.b(TokenFCMDao.class), TokenFCMDao_Impl.f126133g.a());
        linkedHashMap.put(Reflection.b(ProductDao.class), ProductDao_Impl.f126066g.a());
        linkedHashMap.put(Reflection.b(SubscriptionOptionDao.class), SubscriptionOptionDao_Impl.f126126g.a());
        linkedHashMap.put(Reflection.b(PricingPhaseDao.class), PricingPhaseDao_Impl.f126059g.a());
        linkedHashMap.put(Reflection.b(UsedBackdoorCodeDao.class), UsedBackdoorCodeDao_Impl.f126140g.a());
        linkedHashMap.put(Reflection.b(AppVersionDao.class), AppVersionDao_Impl.f125836g.a());
        linkedHashMap.put(Reflection.b(PurchasedOfferDao.class), PurchasedOfferDao_Impl.f126073g.a());
        linkedHashMap.put(Reflection.b(LaunchTimeDao.class), LaunchTimeDao_Impl.f126008g.a());
        linkedHashMap.put(Reflection.b(IgnoredStatisticsItemDao.class), IgnoredStatisticsItemDao_Impl.f125946i.a());
        linkedHashMap.put(Reflection.b(EmergencyUnblockingDao.class), EmergencyUnblockingDao_Impl.f125863g.a());
        linkedHashMap.put(Reflection.b(CustomBlockingScreenConfigDao.class), CustomBlockingScreenConfigDao_Impl.f125848h.a());
        linkedHashMap.put(Reflection.b(MoodCheckInEntityDao.class), MoodCheckInEntityDao_Impl.f126020h.a());
        return linkedHashMap;
    }

    @Override // cz.mobilesoft.coreblock.storage.room.management.CoreDatabase
    public AcademyCourseDao n() {
        return (AcademyCourseDao) this.f126674a.getValue();
    }

    @Override // cz.mobilesoft.coreblock.storage.room.management.CoreDatabase
    public AcademyLessonDao o() {
        return (AcademyLessonDao) this.f126675b.getValue();
    }

    @Override // cz.mobilesoft.coreblock.storage.room.management.CoreDatabase
    public AppVersionDao p() {
        return (AppVersionDao) this.f126681h.getValue();
    }

    @Override // cz.mobilesoft.coreblock.storage.room.management.CoreDatabase
    public CustomBlockingScreenConfigDao q() {
        return (CustomBlockingScreenConfigDao) this.f126686m.getValue();
    }

    @Override // cz.mobilesoft.coreblock.storage.room.management.CoreDatabase
    public EmergencyUnblockingDao r() {
        return (EmergencyUnblockingDao) this.f126685l.getValue();
    }

    @Override // cz.mobilesoft.coreblock.storage.room.management.CoreDatabase
    public IgnoredStatisticsItemDao s() {
        return (IgnoredStatisticsItemDao) this.f126684k.getValue();
    }

    @Override // cz.mobilesoft.coreblock.storage.room.management.CoreDatabase
    public LaunchTimeDao t() {
        return (LaunchTimeDao) this.f126683j.getValue();
    }

    @Override // cz.mobilesoft.coreblock.storage.room.management.CoreDatabase
    public MoodCheckInEntityDao u() {
        return (MoodCheckInEntityDao) this.f126687n.getValue();
    }

    @Override // cz.mobilesoft.coreblock.storage.room.management.CoreDatabase
    public PricingPhaseDao v() {
        return (PricingPhaseDao) this.f126679f.getValue();
    }

    @Override // cz.mobilesoft.coreblock.storage.room.management.CoreDatabase
    public ProductDao w() {
        return (ProductDao) this.f126677d.getValue();
    }

    @Override // cz.mobilesoft.coreblock.storage.room.management.CoreDatabase
    public PurchasedOfferDao x() {
        return (PurchasedOfferDao) this.f126682i.getValue();
    }

    @Override // cz.mobilesoft.coreblock.storage.room.management.CoreDatabase
    public SubscriptionOptionDao y() {
        return (SubscriptionOptionDao) this.f126678e.getValue();
    }

    @Override // cz.mobilesoft.coreblock.storage.room.management.CoreDatabase
    public TokenFCMDao z() {
        return (TokenFCMDao) this.f126676c.getValue();
    }

    @Override // androidx.room.RoomDatabase
    protected InvalidationTracker createInvalidationTracker() {
        return new InvalidationTracker(this, new LinkedHashMap(), new LinkedHashMap(), "academy_course", "academy_lesson", "TokenFCMEntity", "ProductEntity", "UsedBackdoorCodeEntity", "AppVersionEntity", "SubscriptionOptionEntity", "PricingPhaseEntity", SbbqvQlxi.JNjnAoMO, "IgnoredStatisticsItem", "LaunchTime", "EmergencyUnblocking", "BlockingConfig", "MoodCheckInEntity");
    }
}
