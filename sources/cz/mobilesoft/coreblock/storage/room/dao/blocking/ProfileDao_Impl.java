package cz.mobilesoft.coreblock.storage.room.dao.blocking;

import androidx.appcompat.app.jE.vxrlPPpdv;
import androidx.collection.ArrayMap;
import androidx.collection.LongSparseArray;
import androidx.compose.material.icons.twotone.Phg.QaXmqxvjHhxVy;
import androidx.glance.color.Tq.KqqtdetwHMIO;
import androidx.media3.extractor.jpeg.xWt.jTYhJgqLBN;
import androidx.room.EntityDeleteOrUpdateAdapter;
import androidx.room.EntityInsertAdapter;
import androidx.room.EntityUpsertAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomRawQuery;
import androidx.room.RoomSQLiteQuery;
import androidx.room.coroutines.FlowUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.RelationUtil;
import androidx.room.util.SQLiteStatementUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import androidx.sqlite.db.SupportSQLiteQuery;
import com.bumptech.glide.load.data.Bwyd.SbbqvQlxi;
import com.facebook.internal.instrument.anrreport.jRA.jlWo;
import cz.mobilesoft.coreblock.dto.UrlDto;
import cz.mobilesoft.coreblock.enums.ProfileType;
import cz.mobilesoft.coreblock.enums.ScheduleEmoji;
import cz.mobilesoft.coreblock.storage.room.dto.blocking.ProfileWithBlockedItems;
import cz.mobilesoft.coreblock.storage.room.dto.blocking.ProfileWithConfiguration;
import cz.mobilesoft.coreblock.storage.room.dto.blocking.ProfileWithIntervals;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.Application;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.ApplicationProfileRelation;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.GeoAddress;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.Interval;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.PomodoroSession;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.SubAppRelation;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.UsageLimit;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.WebsiteProfileRelation;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.WifiNetwork;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;

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
public final class ProfileDao_Impl extends ProfileDao {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final Companion f125112n = new Companion(null);

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f125113o = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final RoomDatabase f125114a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final EntityInsertAdapter f125115b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Profile.PausedUntil.Converter f125116c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Profile.BlockingMode.Converter f125117d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final ScheduleEmoji.Converter f125118f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Profile.AllowlistWebBrowsingMode.Converter f125119g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final EntityDeleteOrUpdateAdapter f125120h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final EntityDeleteOrUpdateAdapter f125121i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final EntityUpsertAdapter f125122j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final WebsiteProfileRelation.BlockingType.Converter f125123k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final UsageLimit.PeriodType.Converter f125124l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final UsageLimit.LimitType.Converter f125125m;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final List a() {
            return CollectionsKt.emptyList();
        }

        private Companion() {
        }
    }

    public ProfileDao_Impl(RoomDatabase __db) {
        Intrinsics.checkNotNullParameter(__db, "__db");
        this.f125116c = new Profile.PausedUntil.Converter();
        this.f125117d = new Profile.BlockingMode.Converter();
        this.f125118f = new ScheduleEmoji.Converter();
        this.f125119g = new Profile.AllowlistWebBrowsingMode.Converter();
        this.f125123k = new WebsiteProfileRelation.BlockingType.Converter();
        this.f125124l = new UsageLimit.PeriodType.Converter();
        this.f125125m = new UsageLimit.LimitType.Converter();
        this.f125114a = __db;
        this.f125115b = new EntityInsertAdapter<Profile>() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao_Impl.1
            @Override // androidx.room.EntityInsertAdapter
            protected String b() {
                return "INSERT OR REPLACE INTO `Profile` (`id`,`title`,`typeCombinations`,`onConditions`,`operator`,`dayFlags`,`blockNotifications`,`blockLaunch`,`addNewApplications`,`isEnabled`,`isLocked`,`lastStartTime`,`onUntil`,`lockedUntil`,`lockAt`,`pausedUntil`,`blockingMode`,`emoji`,`blockUnsupportedBrowsers`,`blockAdultContent`,`blockInAppPurchases`,`selectedCategories`,`webBrowsingMode`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertAdapter
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public void a(SQLiteStatement statement, Profile entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.A(1, entity.r());
                statement.p0(2, entity.A());
                statement.A(3, entity.E());
                statement.A(4, entity.v());
                statement.A(5, entity.x());
                statement.A(6, entity.p());
                statement.A(7, entity.m() ? 1L : 0L);
                statement.A(8, entity.l() ? 1L : 0L);
                statement.A(9, entity.i() ? 1L : 0L);
                statement.A(10, entity.K() ? 1L : 0L);
                statement.A(11, entity.L() ? 1L : 0L);
                statement.A(12, entity.s());
                statement.A(13, entity.w());
                statement.A(14, entity.u());
                statement.A(15, entity.t());
                statement.A(16, ProfileDao_Impl.this.f125116c.b(entity.y()));
                statement.A(17, ProfileDao_Impl.this.f125117d.b(entity.o()));
                statement.A(18, ProfileDao_Impl.this.f125118f.b(entity.q()));
                statement.A(19, entity.n() ? 1L : 0L);
                statement.A(20, entity.j() ? 1L : 0L);
                statement.A(21, entity.k() ? 1L : 0L);
                statement.A(22, entity.z());
                statement.A(23, ProfileDao_Impl.this.f125119g.b(entity.F()));
            }
        };
        this.f125120h = new EntityDeleteOrUpdateAdapter<Profile>() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao_Impl.2
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            protected String b() {
                return "DELETE FROM `Profile` WHERE `id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public void a(SQLiteStatement sQLiteStatement, Profile entity) {
                Intrinsics.checkNotNullParameter(sQLiteStatement, jlWo.iNXuvLwvR);
                Intrinsics.checkNotNullParameter(entity, "entity");
                sQLiteStatement.A(1, entity.r());
            }
        };
        this.f125121i = new EntityDeleteOrUpdateAdapter<Profile>() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao_Impl.3
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            protected String b() {
                return "UPDATE OR ABORT `Profile` SET `id` = ?,`title` = ?,`typeCombinations` = ?,`onConditions` = ?,`operator` = ?,`dayFlags` = ?,`blockNotifications` = ?,`blockLaunch` = ?,`addNewApplications` = ?,`isEnabled` = ?,`isLocked` = ?,`lastStartTime` = ?,`onUntil` = ?,`lockedUntil` = ?,`lockAt` = ?,`pausedUntil` = ?,`blockingMode` = ?,`emoji` = ?,`blockUnsupportedBrowsers` = ?,`blockAdultContent` = ?,`blockInAppPurchases` = ?,`selectedCategories` = ?,`webBrowsingMode` = ? WHERE `id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public void a(SQLiteStatement statement, Profile entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.A(1, entity.r());
                statement.p0(2, entity.A());
                statement.A(3, entity.E());
                statement.A(4, entity.v());
                statement.A(5, entity.x());
                statement.A(6, entity.p());
                statement.A(7, entity.m() ? 1L : 0L);
                statement.A(8, entity.l() ? 1L : 0L);
                statement.A(9, entity.i() ? 1L : 0L);
                statement.A(10, entity.K() ? 1L : 0L);
                statement.A(11, entity.L() ? 1L : 0L);
                statement.A(12, entity.s());
                statement.A(13, entity.w());
                statement.A(14, entity.u());
                statement.A(15, entity.t());
                statement.A(16, ProfileDao_Impl.this.f125116c.b(entity.y()));
                statement.A(17, ProfileDao_Impl.this.f125117d.b(entity.o()));
                statement.A(18, ProfileDao_Impl.this.f125118f.b(entity.q()));
                statement.A(19, entity.n() ? 1L : 0L);
                statement.A(20, entity.j() ? 1L : 0L);
                statement.A(21, entity.k() ? 1L : 0L);
                statement.A(22, entity.z());
                statement.A(23, ProfileDao_Impl.this.f125119g.b(entity.F()));
                statement.A(24, entity.r());
            }
        };
        this.f125122j = new EntityUpsertAdapter(new EntityInsertAdapter<Profile>() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao_Impl.4
            @Override // androidx.room.EntityInsertAdapter
            protected String b() {
                return "INSERT INTO `Profile` (`id`,`title`,`typeCombinations`,`onConditions`,`operator`,`dayFlags`,`blockNotifications`,`blockLaunch`,`addNewApplications`,`isEnabled`,`isLocked`,`lastStartTime`,`onUntil`,`lockedUntil`,`lockAt`,`pausedUntil`,`blockingMode`,`emoji`,`blockUnsupportedBrowsers`,`blockAdultContent`,`blockInAppPurchases`,`selectedCategories`,`webBrowsingMode`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertAdapter
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public void a(SQLiteStatement statement, Profile entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.A(1, entity.r());
                statement.p0(2, entity.A());
                statement.A(3, entity.E());
                statement.A(4, entity.v());
                statement.A(5, entity.x());
                statement.A(6, entity.p());
                statement.A(7, entity.m() ? 1L : 0L);
                statement.A(8, entity.l() ? 1L : 0L);
                statement.A(9, entity.i() ? 1L : 0L);
                statement.A(10, entity.K() ? 1L : 0L);
                statement.A(11, entity.L() ? 1L : 0L);
                statement.A(12, entity.s());
                statement.A(13, entity.w());
                statement.A(14, entity.u());
                statement.A(15, entity.t());
                statement.A(16, ProfileDao_Impl.this.f125116c.b(entity.y()));
                statement.A(17, ProfileDao_Impl.this.f125117d.b(entity.o()));
                statement.A(18, ProfileDao_Impl.this.f125118f.b(entity.q()));
                statement.A(19, entity.n() ? 1L : 0L);
                statement.A(20, entity.j() ? 1L : 0L);
                statement.A(21, entity.k() ? 1L : 0L);
                statement.A(22, entity.z());
                statement.A(23, ProfileDao_Impl.this.f125119g.b(entity.F()));
            }
        }, new EntityDeleteOrUpdateAdapter<Profile>() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao_Impl.5
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            protected String b() {
                return "UPDATE `Profile` SET `id` = ?,`title` = ?,`typeCombinations` = ?,`onConditions` = ?,`operator` = ?,`dayFlags` = ?,`blockNotifications` = ?,`blockLaunch` = ?,`addNewApplications` = ?,`isEnabled` = ?,`isLocked` = ?,`lastStartTime` = ?,`onUntil` = ?,`lockedUntil` = ?,`lockAt` = ?,`pausedUntil` = ?,`blockingMode` = ?,`emoji` = ?,`blockUnsupportedBrowsers` = ?,`blockAdultContent` = ?,`blockInAppPurchases` = ?,`selectedCategories` = ?,`webBrowsingMode` = ? WHERE `id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public void a(SQLiteStatement statement, Profile entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.A(1, entity.r());
                statement.p0(2, entity.A());
                statement.A(3, entity.E());
                statement.A(4, entity.v());
                statement.A(5, entity.x());
                statement.A(6, entity.p());
                statement.A(7, entity.m() ? 1L : 0L);
                statement.A(8, entity.l() ? 1L : 0L);
                statement.A(9, entity.i() ? 1L : 0L);
                statement.A(10, entity.K() ? 1L : 0L);
                statement.A(11, entity.L() ? 1L : 0L);
                statement.A(12, entity.s());
                statement.A(13, entity.w());
                statement.A(14, entity.u());
                statement.A(15, entity.t());
                statement.A(16, ProfileDao_Impl.this.f125116c.b(entity.y()));
                statement.A(17, ProfileDao_Impl.this.f125117d.b(entity.o()));
                statement.A(18, ProfileDao_Impl.this.f125118f.b(entity.q()));
                statement.A(19, entity.n() ? 1L : 0L);
                statement.A(20, entity.j() ? 1L : 0L);
                statement.A(21, entity.k() ? 1L : 0L);
                statement.A(22, entity.z());
                statement.A(23, ProfileDao_Impl.this.f125119g.b(entity.F()));
                statement.A(24, entity.r());
            }
        });
    }

    private final void A2(final SQLiteConnection sQLiteConnection, LongSparseArray longSparseArray) {
        if (longSparseArray.j()) {
            return;
        }
        int i3 = 1;
        if (longSparseArray.r() > 999) {
            RelationUtil.b(longSparseArray, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.o3
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return ProfileDao_Impl.B2(this.f125581a, sQLiteConnection, (LongSparseArray) obj);
                }
            });
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT `id`,`profileId`,`fromInMinutes`,`toInMinutes`,`parentId`,`isAllDayAuto`,`isEnabled` FROM `Interval` WHERE `profileId` IN (");
        StringUtil.a(sb, longSparseArray.r());
        sb.append(")");
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        SQLiteStatement sQLiteStatementG2 = sQLiteConnection.G2(string);
        int iR = longSparseArray.r();
        int i4 = 0;
        int i5 = 1;
        for (int i6 = 0; i6 < iR; i6++) {
            sQLiteStatementG2.A(i5, longSparseArray.k(i6));
            i5++;
        }
        try {
            int iC = SQLiteStatementUtil.c(sQLiteStatementG2, "profileId");
            if (iC == -1) {
                return;
            }
            while (sQLiteStatementG2.B2()) {
                List list = (List) longSparseArray.g(sQLiteStatementG2.getLong(iC));
                if (list != null) {
                    list.add(new Interval(sQLiteStatementG2.getLong(i4), sQLiteStatementG2.getLong(i3), sQLiteStatementG2.getLong(2), sQLiteStatementG2.getLong(3), sQLiteStatementG2.isNull(4) ? null : Long.valueOf(sQLiteStatementG2.getLong(4)), ((int) sQLiteStatementG2.getLong(5)) != 0, ((int) sQLiteStatementG2.getLong(6)) != 0));
                    i3 = 1;
                    i4 = 0;
                }
            }
        } finally {
            sQLiteStatementG2.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List A3(String str, ProfileDao_Impl profileDao_Impl, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        try {
            int iD = SQLiteStatementUtil.d(sQLiteStatementG2, "id");
            int iD2 = SQLiteStatementUtil.d(sQLiteStatementG2, "title");
            int iD3 = SQLiteStatementUtil.d(sQLiteStatementG2, "typeCombinations");
            int iD4 = SQLiteStatementUtil.d(sQLiteStatementG2, "onConditions");
            int iD5 = SQLiteStatementUtil.d(sQLiteStatementG2, "operator");
            int iD6 = SQLiteStatementUtil.d(sQLiteStatementG2, "dayFlags");
            int iD7 = SQLiteStatementUtil.d(sQLiteStatementG2, "blockNotifications");
            int iD8 = SQLiteStatementUtil.d(sQLiteStatementG2, "blockLaunch");
            int iD9 = SQLiteStatementUtil.d(sQLiteStatementG2, "addNewApplications");
            int iD10 = SQLiteStatementUtil.d(sQLiteStatementG2, "isEnabled");
            int iD11 = SQLiteStatementUtil.d(sQLiteStatementG2, "isLocked");
            int iD12 = SQLiteStatementUtil.d(sQLiteStatementG2, "lastStartTime");
            int iD13 = SQLiteStatementUtil.d(sQLiteStatementG2, "onUntil");
            int iD14 = SQLiteStatementUtil.d(sQLiteStatementG2, "lockedUntil");
            int iD15 = SQLiteStatementUtil.d(sQLiteStatementG2, "lockAt");
            int iD16 = SQLiteStatementUtil.d(sQLiteStatementG2, "pausedUntil");
            int iD17 = SQLiteStatementUtil.d(sQLiteStatementG2, "blockingMode");
            int iD18 = SQLiteStatementUtil.d(sQLiteStatementG2, "emoji");
            int iD19 = SQLiteStatementUtil.d(sQLiteStatementG2, "blockUnsupportedBrowsers");
            int iD20 = SQLiteStatementUtil.d(sQLiteStatementG2, "blockAdultContent");
            int iD21 = SQLiteStatementUtil.d(sQLiteStatementG2, "blockInAppPurchases");
            int iD22 = SQLiteStatementUtil.d(sQLiteStatementG2, "selectedCategories");
            int iD23 = SQLiteStatementUtil.d(sQLiteStatementG2, "webBrowsingMode");
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementG2.B2()) {
                long j3 = sQLiteStatementG2.getLong(iD);
                String strF2 = sQLiteStatementG2.f2(iD2);
                int i3 = iD;
                int i4 = iD2;
                int i5 = (int) sQLiteStatementG2.getLong(iD3);
                int i6 = (int) sQLiteStatementG2.getLong(iD4);
                int i7 = (int) sQLiteStatementG2.getLong(iD5);
                int i8 = (int) sQLiteStatementG2.getLong(iD6);
                boolean z2 = ((int) sQLiteStatementG2.getLong(iD7)) != 0;
                int i9 = iD3;
                boolean z3 = ((int) sQLiteStatementG2.getLong(iD8)) != 0;
                boolean z4 = ((int) sQLiteStatementG2.getLong(iD9)) != 0;
                boolean z5 = ((int) sQLiteStatementG2.getLong(iD10)) != 0;
                boolean z6 = ((int) sQLiteStatementG2.getLong(iD11)) != 0;
                long j4 = sQLiteStatementG2.getLong(iD12);
                long j5 = sQLiteStatementG2.getLong(iD13);
                long j6 = sQLiteStatementG2.getLong(iD14);
                int i10 = iD15;
                long j7 = sQLiteStatementG2.getLong(i10);
                int i11 = iD16;
                int i12 = iD4;
                Profile.PausedUntil pausedUntilA = profileDao_Impl.f125116c.a(sQLiteStatementG2.getLong(i11));
                int i13 = iD17;
                Profile.BlockingMode blockingModeA = profileDao_Impl.f125117d.a((int) sQLiteStatementG2.getLong(i13));
                int i14 = iD5;
                int i15 = iD18;
                ScheduleEmoji scheduleEmojiA = profileDao_Impl.f125118f.a((int) sQLiteStatementG2.getLong(i15));
                if (scheduleEmojiA == null) {
                    throw new IllegalStateException("Expected NON-NULL 'cz.mobilesoft.coreblock.enums.ScheduleEmoji', but it was NULL.");
                }
                iD18 = i15;
                int i16 = iD19;
                boolean z7 = ((int) sQLiteStatementG2.getLong(i16)) != 0;
                iD19 = i16;
                int i17 = iD20;
                boolean z8 = ((int) sQLiteStatementG2.getLong(i17)) != 0;
                int i18 = iD21;
                boolean z9 = ((int) sQLiteStatementG2.getLong(i18)) != 0;
                iD21 = i18;
                int i19 = iD22;
                iD22 = i19;
                int i20 = iD23;
                arrayList.add(new Profile(j3, strF2, i5, i6, i7, i8, z2, z3, z4, z5, z6, j4, j5, j6, j7, pausedUntilA, blockingModeA, scheduleEmojiA, z7, z8, z9, (int) sQLiteStatementG2.getLong(i19), profileDao_Impl.f125119g.a((int) sQLiteStatementG2.getLong(i20))));
                iD4 = i12;
                iD23 = i20;
                iD5 = i14;
                iD17 = i13;
                iD = i3;
                iD2 = i4;
                iD3 = i9;
                iD16 = i11;
                iD20 = i17;
                iD15 = i10;
            }
            sQLiteStatementG2.close();
            return arrayList;
        } catch (Throwable th) {
            sQLiteStatementG2.close();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit B2(ProfileDao_Impl profileDao_Impl, SQLiteConnection sQLiteConnection, LongSparseArray _tmpMap) {
        Intrinsics.checkNotNullParameter(_tmpMap, "_tmpMap");
        profileDao_Impl.A2(sQLiteConnection, _tmpMap);
        return Unit.f139807a;
    }

    private final void C2(final SQLiteConnection sQLiteConnection, LongSparseArray longSparseArray) {
        LongSparseArray longSparseArray2 = longSparseArray;
        if (longSparseArray2.j()) {
            return;
        }
        int i3 = 1;
        if (longSparseArray2.r() > 999) {
            RelationUtil.b(longSparseArray2, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.t3
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return ProfileDao_Impl.D2(this.f125669a, sQLiteConnection, (LongSparseArray) obj);
                }
            });
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT `id`,`profileId`,`originalStartTime`,`focusTime`,`breakTime`,`sessionCount`,`isStoppedManually`,`originalEndTime`,`adjustedEndTime` FROM `PomodoroSession` WHERE `profileId` IN (");
        StringUtil.a(sb, longSparseArray2.r());
        sb.append(")");
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        SQLiteStatement sQLiteStatementG2 = sQLiteConnection.G2(string);
        int iR = longSparseArray2.r();
        int i4 = 0;
        int i5 = 1;
        for (int i6 = 0; i6 < iR; i6++) {
            sQLiteStatementG2.A(i5, longSparseArray2.k(i6));
            i5++;
        }
        try {
            int iC = SQLiteStatementUtil.c(sQLiteStatementG2, "profileId");
            if (iC == -1) {
                return;
            }
            while (sQLiteStatementG2.B2()) {
                List list = (List) longSparseArray2.g(sQLiteStatementG2.getLong(iC));
                if (list != null) {
                    int i7 = iC;
                    list.add(new PomodoroSession(sQLiteStatementG2.getLong(i4), sQLiteStatementG2.getLong(i3), sQLiteStatementG2.getLong(2), sQLiteStatementG2.getLong(3), sQLiteStatementG2.getLong(4), (int) sQLiteStatementG2.getLong(5), ((int) sQLiteStatementG2.getLong(6)) != 0, sQLiteStatementG2.getLong(7), sQLiteStatementG2.getLong(8)));
                    longSparseArray2 = longSparseArray;
                    iC = i7;
                    i3 = 1;
                    i4 = 0;
                } else {
                    longSparseArray2 = longSparseArray;
                }
            }
        } finally {
            sQLiteStatementG2.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List C3(String str, ProfileDao_Impl profileDao_Impl, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        try {
            int iD = SQLiteStatementUtil.d(sQLiteStatementG2, "id");
            int iD2 = SQLiteStatementUtil.d(sQLiteStatementG2, "title");
            int iD3 = SQLiteStatementUtil.d(sQLiteStatementG2, "typeCombinations");
            int iD4 = SQLiteStatementUtil.d(sQLiteStatementG2, "onConditions");
            int iD5 = SQLiteStatementUtil.d(sQLiteStatementG2, "operator");
            int iD6 = SQLiteStatementUtil.d(sQLiteStatementG2, "dayFlags");
            int iD7 = SQLiteStatementUtil.d(sQLiteStatementG2, "blockNotifications");
            int iD8 = SQLiteStatementUtil.d(sQLiteStatementG2, "blockLaunch");
            int iD9 = SQLiteStatementUtil.d(sQLiteStatementG2, "addNewApplications");
            int iD10 = SQLiteStatementUtil.d(sQLiteStatementG2, "isEnabled");
            int iD11 = SQLiteStatementUtil.d(sQLiteStatementG2, "isLocked");
            int iD12 = SQLiteStatementUtil.d(sQLiteStatementG2, "lastStartTime");
            int iD13 = SQLiteStatementUtil.d(sQLiteStatementG2, "onUntil");
            int iD14 = SQLiteStatementUtil.d(sQLiteStatementG2, "lockedUntil");
            int iD15 = SQLiteStatementUtil.d(sQLiteStatementG2, "lockAt");
            int iD16 = SQLiteStatementUtil.d(sQLiteStatementG2, "pausedUntil");
            int iD17 = SQLiteStatementUtil.d(sQLiteStatementG2, "blockingMode");
            int iD18 = SQLiteStatementUtil.d(sQLiteStatementG2, "emoji");
            int iD19 = SQLiteStatementUtil.d(sQLiteStatementG2, "blockUnsupportedBrowsers");
            int iD20 = SQLiteStatementUtil.d(sQLiteStatementG2, "blockAdultContent");
            int iD21 = SQLiteStatementUtil.d(sQLiteStatementG2, "blockInAppPurchases");
            int iD22 = SQLiteStatementUtil.d(sQLiteStatementG2, "selectedCategories");
            int iD23 = SQLiteStatementUtil.d(sQLiteStatementG2, "webBrowsingMode");
            int i3 = iD12;
            int i4 = iD11;
            int i5 = iD10;
            LongSparseArray longSparseArray = new LongSparseArray(0, 1, null);
            while (sQLiteStatementG2.B2()) {
                long j3 = sQLiteStatementG2.getLong(iD);
                if (!longSparseArray.e(j3)) {
                    longSparseArray.m(j3, new ArrayList());
                }
            }
            sQLiteStatementG2.reset();
            profileDao_Impl.A2(_connection, longSparseArray);
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementG2.B2()) {
                long j4 = sQLiteStatementG2.getLong(iD);
                String strF2 = sQLiteStatementG2.f2(iD2);
                int i6 = (int) sQLiteStatementG2.getLong(iD3);
                int i7 = (int) sQLiteStatementG2.getLong(iD4);
                int i8 = iD2;
                int i9 = iD3;
                int i10 = (int) sQLiteStatementG2.getLong(iD5);
                int i11 = (int) sQLiteStatementG2.getLong(iD6);
                boolean z2 = ((int) sQLiteStatementG2.getLong(iD7)) != 0;
                boolean z3 = ((int) sQLiteStatementG2.getLong(iD8)) != 0;
                boolean z4 = ((int) sQLiteStatementG2.getLong(iD9)) != 0;
                int i12 = i5;
                int i13 = iD4;
                boolean z5 = ((int) sQLiteStatementG2.getLong(i12)) != 0;
                int i14 = i4;
                int i15 = iD5;
                boolean z6 = ((int) sQLiteStatementG2.getLong(i14)) != 0;
                int i16 = i3;
                long j5 = sQLiteStatementG2.getLong(i16);
                int i17 = iD13;
                long j6 = sQLiteStatementG2.getLong(i17);
                int i18 = iD14;
                long j7 = sQLiteStatementG2.getLong(i18);
                iD14 = i18;
                int i19 = iD15;
                long j8 = sQLiteStatementG2.getLong(i19);
                iD15 = i19;
                int i20 = iD16;
                Profile.PausedUntil pausedUntilA = profileDao_Impl.f125116c.a(sQLiteStatementG2.getLong(i20));
                int i21 = iD17;
                Profile.BlockingMode blockingModeA = profileDao_Impl.f125117d.a((int) sQLiteStatementG2.getLong(i21));
                int i22 = iD18;
                ScheduleEmoji scheduleEmojiA = profileDao_Impl.f125118f.a((int) sQLiteStatementG2.getLong(i22));
                if (scheduleEmojiA == null) {
                    throw new IllegalStateException("Expected NON-NULL 'cz.mobilesoft.coreblock.enums.ScheduleEmoji', but it was NULL.");
                }
                iD18 = i22;
                int i23 = iD19;
                boolean z7 = ((int) sQLiteStatementG2.getLong(i23)) != 0;
                iD19 = i23;
                int i24 = iD20;
                boolean z8 = ((int) sQLiteStatementG2.getLong(i24)) != 0;
                int i25 = iD21;
                boolean z9 = ((int) sQLiteStatementG2.getLong(i25)) != 0;
                iD21 = i25;
                int i26 = iD22;
                iD22 = i26;
                int i27 = iD23;
                Profile profile = new Profile(j4, strF2, i6, i7, i10, i11, z2, z3, z4, z5, z6, j5, j6, j7, j8, pausedUntilA, blockingModeA, scheduleEmojiA, z7, z8, z9, (int) sQLiteStatementG2.getLong(i26), profileDao_Impl.f125119g.a((int) sQLiteStatementG2.getLong(i27)));
                Object objG = longSparseArray.g(sQLiteStatementG2.getLong(iD));
                if (objG == null) {
                    throw new IllegalStateException("Required value was null.");
                }
                arrayList.add(new ProfileWithIntervals(profile, (List) objG));
                iD2 = i8;
                iD5 = i15;
                iD4 = i13;
                i4 = i14;
                i5 = i12;
                i3 = i16;
                iD16 = i20;
                iD13 = i17;
                iD17 = i21;
                iD20 = i24;
                iD23 = i27;
                iD3 = i9;
            }
            sQLiteStatementG2.close();
            return arrayList;
        } catch (Throwable th) {
            sQLiteStatementG2.close();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit D2(ProfileDao_Impl profileDao_Impl, SQLiteConnection sQLiteConnection, LongSparseArray _tmpMap) {
        Intrinsics.checkNotNullParameter(_tmpMap, "_tmpMap");
        profileDao_Impl.C2(sQLiteConnection, _tmpMap);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List D3(String str, ProfileDao_Impl profileDao_Impl, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        try {
            int iD = SQLiteStatementUtil.d(sQLiteStatementG2, "id");
            int iD2 = SQLiteStatementUtil.d(sQLiteStatementG2, "title");
            int iD3 = SQLiteStatementUtil.d(sQLiteStatementG2, "typeCombinations");
            int iD4 = SQLiteStatementUtil.d(sQLiteStatementG2, "onConditions");
            int iD5 = SQLiteStatementUtil.d(sQLiteStatementG2, "operator");
            int iD6 = SQLiteStatementUtil.d(sQLiteStatementG2, "dayFlags");
            int iD7 = SQLiteStatementUtil.d(sQLiteStatementG2, "blockNotifications");
            int iD8 = SQLiteStatementUtil.d(sQLiteStatementG2, "blockLaunch");
            int iD9 = SQLiteStatementUtil.d(sQLiteStatementG2, "addNewApplications");
            int iD10 = SQLiteStatementUtil.d(sQLiteStatementG2, "isEnabled");
            int iD11 = SQLiteStatementUtil.d(sQLiteStatementG2, "isLocked");
            int iD12 = SQLiteStatementUtil.d(sQLiteStatementG2, "lastStartTime");
            int iD13 = SQLiteStatementUtil.d(sQLiteStatementG2, "onUntil");
            int iD14 = SQLiteStatementUtil.d(sQLiteStatementG2, "lockedUntil");
            int iD15 = SQLiteStatementUtil.d(sQLiteStatementG2, "lockAt");
            int iD16 = SQLiteStatementUtil.d(sQLiteStatementG2, "pausedUntil");
            int iD17 = SQLiteStatementUtil.d(sQLiteStatementG2, "blockingMode");
            int iD18 = SQLiteStatementUtil.d(sQLiteStatementG2, "emoji");
            int iD19 = SQLiteStatementUtil.d(sQLiteStatementG2, "blockUnsupportedBrowsers");
            int iD20 = SQLiteStatementUtil.d(sQLiteStatementG2, "blockAdultContent");
            int iD21 = SQLiteStatementUtil.d(sQLiteStatementG2, "blockInAppPurchases");
            int iD22 = SQLiteStatementUtil.d(sQLiteStatementG2, "selectedCategories");
            int iD23 = SQLiteStatementUtil.d(sQLiteStatementG2, "webBrowsingMode");
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementG2.B2()) {
                long j3 = sQLiteStatementG2.getLong(iD);
                String strF2 = sQLiteStatementG2.f2(iD2);
                int i3 = iD;
                int i4 = iD2;
                int i5 = (int) sQLiteStatementG2.getLong(iD3);
                int i6 = (int) sQLiteStatementG2.getLong(iD4);
                int i7 = (int) sQLiteStatementG2.getLong(iD5);
                int i8 = (int) sQLiteStatementG2.getLong(iD6);
                boolean z2 = ((int) sQLiteStatementG2.getLong(iD7)) != 0;
                int i9 = iD3;
                boolean z3 = ((int) sQLiteStatementG2.getLong(iD8)) != 0;
                boolean z4 = ((int) sQLiteStatementG2.getLong(iD9)) != 0;
                boolean z5 = ((int) sQLiteStatementG2.getLong(iD10)) != 0;
                boolean z6 = ((int) sQLiteStatementG2.getLong(iD11)) != 0;
                long j4 = sQLiteStatementG2.getLong(iD12);
                long j5 = sQLiteStatementG2.getLong(iD13);
                long j6 = sQLiteStatementG2.getLong(iD14);
                int i10 = iD15;
                long j7 = sQLiteStatementG2.getLong(i10);
                int i11 = iD16;
                int i12 = iD4;
                Profile.PausedUntil pausedUntilA = profileDao_Impl.f125116c.a(sQLiteStatementG2.getLong(i11));
                int i13 = iD17;
                Profile.BlockingMode blockingModeA = profileDao_Impl.f125117d.a((int) sQLiteStatementG2.getLong(i13));
                int i14 = iD5;
                int i15 = iD18;
                ScheduleEmoji scheduleEmojiA = profileDao_Impl.f125118f.a((int) sQLiteStatementG2.getLong(i15));
                if (scheduleEmojiA == null) {
                    throw new IllegalStateException("Expected NON-NULL 'cz.mobilesoft.coreblock.enums.ScheduleEmoji', but it was NULL.");
                }
                iD18 = i15;
                int i16 = iD19;
                boolean z7 = ((int) sQLiteStatementG2.getLong(i16)) != 0;
                iD19 = i16;
                int i17 = iD20;
                boolean z8 = ((int) sQLiteStatementG2.getLong(i17)) != 0;
                int i18 = iD21;
                boolean z9 = ((int) sQLiteStatementG2.getLong(i18)) != 0;
                iD21 = i18;
                int i19 = iD22;
                iD22 = i19;
                int i20 = iD23;
                arrayList.add(new Profile(j3, strF2, i5, i6, i7, i8, z2, z3, z4, z5, z6, j4, j5, j6, j7, pausedUntilA, blockingModeA, scheduleEmojiA, z7, z8, z9, (int) sQLiteStatementG2.getLong(i19), profileDao_Impl.f125119g.a((int) sQLiteStatementG2.getLong(i20))));
                iD4 = i12;
                iD23 = i20;
                iD5 = i14;
                iD17 = i13;
                iD = i3;
                iD2 = i4;
                iD3 = i9;
                iD16 = i11;
                iD20 = i17;
                iD15 = i10;
            }
            sQLiteStatementG2.close();
            return arrayList;
        } catch (Throwable th) {
            sQLiteStatementG2.close();
            throw th;
        }
    }

    private final void E2(final SQLiteConnection sQLiteConnection, LongSparseArray longSparseArray) {
        if (longSparseArray.j()) {
            return;
        }
        if (longSparseArray.r() > 999) {
            RelationUtil.b(longSparseArray, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.y3
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return ProfileDao_Impl.F2(this.f125762a, sQLiteConnection, (LongSparseArray) obj);
                }
            });
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT `id`,`profileId`,`subAppId` FROM `SubAppRelation` WHERE `profileId` IN (");
        StringUtil.a(sb, longSparseArray.r());
        sb.append(")");
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        SQLiteStatement sQLiteStatementG2 = sQLiteConnection.G2(string);
        int iR = longSparseArray.r();
        int i3 = 1;
        for (int i4 = 0; i4 < iR; i4++) {
            sQLiteStatementG2.A(i3, longSparseArray.k(i4));
            i3++;
        }
        try {
            int iC = SQLiteStatementUtil.c(sQLiteStatementG2, "profileId");
            if (iC == -1) {
                sQLiteStatementG2.close();
                return;
            }
            while (sQLiteStatementG2.B2()) {
                List list = (List) longSparseArray.g(sQLiteStatementG2.getLong(iC));
                if (list != null) {
                    list.add(new SubAppRelation(sQLiteStatementG2.getLong(0), sQLiteStatementG2.getLong(1), sQLiteStatementG2.f2(2)));
                }
            }
        } finally {
            sQLiteStatementG2.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit F2(ProfileDao_Impl profileDao_Impl, SQLiteConnection sQLiteConnection, LongSparseArray _tmpMap) {
        Intrinsics.checkNotNullParameter(_tmpMap, "_tmpMap");
        profileDao_Impl.E2(sQLiteConnection, _tmpMap);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List F3(String str, ProfileDao_Impl profileDao_Impl, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        try {
            int iD = SQLiteStatementUtil.d(sQLiteStatementG2, "id");
            int iD2 = SQLiteStatementUtil.d(sQLiteStatementG2, "title");
            int iD3 = SQLiteStatementUtil.d(sQLiteStatementG2, "typeCombinations");
            int iD4 = SQLiteStatementUtil.d(sQLiteStatementG2, "onConditions");
            int iD5 = SQLiteStatementUtil.d(sQLiteStatementG2, "operator");
            int iD6 = SQLiteStatementUtil.d(sQLiteStatementG2, "dayFlags");
            int iD7 = SQLiteStatementUtil.d(sQLiteStatementG2, "blockNotifications");
            int iD8 = SQLiteStatementUtil.d(sQLiteStatementG2, "blockLaunch");
            int iD9 = SQLiteStatementUtil.d(sQLiteStatementG2, "addNewApplications");
            int iD10 = SQLiteStatementUtil.d(sQLiteStatementG2, "isEnabled");
            int iD11 = SQLiteStatementUtil.d(sQLiteStatementG2, "isLocked");
            int iD12 = SQLiteStatementUtil.d(sQLiteStatementG2, "lastStartTime");
            int iD13 = SQLiteStatementUtil.d(sQLiteStatementG2, "onUntil");
            int iD14 = SQLiteStatementUtil.d(sQLiteStatementG2, "lockedUntil");
            int iD15 = SQLiteStatementUtil.d(sQLiteStatementG2, "lockAt");
            int iD16 = SQLiteStatementUtil.d(sQLiteStatementG2, "pausedUntil");
            int iD17 = SQLiteStatementUtil.d(sQLiteStatementG2, "blockingMode");
            int iD18 = SQLiteStatementUtil.d(sQLiteStatementG2, "emoji");
            int iD19 = SQLiteStatementUtil.d(sQLiteStatementG2, "blockUnsupportedBrowsers");
            int iD20 = SQLiteStatementUtil.d(sQLiteStatementG2, "blockAdultContent");
            int iD21 = SQLiteStatementUtil.d(sQLiteStatementG2, "blockInAppPurchases");
            int iD22 = SQLiteStatementUtil.d(sQLiteStatementG2, "selectedCategories");
            int iD23 = SQLiteStatementUtil.d(sQLiteStatementG2, "webBrowsingMode");
            int i3 = iD12;
            int i4 = iD11;
            int i5 = iD10;
            LongSparseArray longSparseArray = new LongSparseArray(0, 1, null);
            int i6 = iD9;
            LongSparseArray longSparseArray2 = new LongSparseArray(0, 1, null);
            int i7 = iD8;
            LongSparseArray longSparseArray3 = new LongSparseArray(0, 1, null);
            int i8 = iD7;
            LongSparseArray longSparseArray4 = new LongSparseArray(0, 1, null);
            int i9 = iD6;
            LongSparseArray longSparseArray5 = new LongSparseArray(0, 1, null);
            int i10 = iD5;
            LongSparseArray longSparseArray6 = new LongSparseArray(0, 1, null);
            int i11 = iD4;
            LongSparseArray longSparseArray7 = new LongSparseArray(0, 1, null);
            int i12 = iD3;
            LongSparseArray longSparseArray8 = new LongSparseArray(0, 1, null);
            while (sQLiteStatementG2.B2()) {
                long j3 = sQLiteStatementG2.getLong(iD);
                if (!longSparseArray.e(j3)) {
                    longSparseArray.m(j3, new ArrayList());
                }
                long j4 = sQLiteStatementG2.getLong(iD);
                if (!longSparseArray2.e(j4)) {
                    longSparseArray2.m(j4, new ArrayList());
                }
                long j5 = sQLiteStatementG2.getLong(iD);
                if (!longSparseArray3.e(j5)) {
                    longSparseArray3.m(j5, new ArrayList());
                }
                long j6 = sQLiteStatementG2.getLong(iD);
                if (!longSparseArray4.e(j6)) {
                    longSparseArray4.m(j6, new ArrayList());
                }
                long j7 = sQLiteStatementG2.getLong(iD);
                if (!longSparseArray5.e(j7)) {
                    longSparseArray5.m(j7, new ArrayList());
                }
                long j8 = sQLiteStatementG2.getLong(iD);
                if (!longSparseArray6.e(j8)) {
                    longSparseArray6.m(j8, new ArrayList());
                }
                long j9 = sQLiteStatementG2.getLong(iD);
                if (!longSparseArray7.e(j9)) {
                    longSparseArray7.m(j9, new ArrayList());
                }
                long j10 = sQLiteStatementG2.getLong(iD);
                if (!longSparseArray8.e(j10)) {
                    longSparseArray8.m(j10, new ArrayList());
                }
            }
            sQLiteStatementG2.reset();
            profileDao_Impl.u2(_connection, longSparseArray);
            profileDao_Impl.I2(_connection, longSparseArray2);
            profileDao_Impl.A2(_connection, longSparseArray3);
            profileDao_Impl.y2(_connection, longSparseArray4);
            profileDao_Impl.K2(_connection, longSparseArray5);
            profileDao_Impl.G2(_connection, longSparseArray6);
            profileDao_Impl.C2(_connection, longSparseArray7);
            profileDao_Impl.E2(_connection, longSparseArray8);
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementG2.B2()) {
                long j11 = sQLiteStatementG2.getLong(iD);
                String strF2 = sQLiteStatementG2.f2(iD2);
                int i13 = i12;
                int i14 = (int) sQLiteStatementG2.getLong(i13);
                i12 = i13;
                int i15 = i11;
                int i16 = (int) sQLiteStatementG2.getLong(i15);
                LongSparseArray longSparseArray9 = longSparseArray8;
                int i17 = i10;
                int i18 = iD2;
                int i19 = (int) sQLiteStatementG2.getLong(i17);
                int i20 = i9;
                int i21 = (int) sQLiteStatementG2.getLong(i20);
                int i22 = i8;
                boolean z2 = ((int) sQLiteStatementG2.getLong(i22)) != 0;
                int i23 = i7;
                boolean z3 = ((int) sQLiteStatementG2.getLong(i23)) != 0;
                i7 = i23;
                int i24 = i6;
                boolean z4 = ((int) sQLiteStatementG2.getLong(i24)) != 0;
                i6 = i24;
                int i25 = i5;
                boolean z5 = ((int) sQLiteStatementG2.getLong(i25)) != 0;
                i5 = i25;
                int i26 = i4;
                boolean z6 = ((int) sQLiteStatementG2.getLong(i26)) != 0;
                int i27 = i3;
                long j12 = sQLiteStatementG2.getLong(i27);
                int i28 = iD13;
                long j13 = sQLiteStatementG2.getLong(i28);
                i3 = i27;
                int i29 = iD14;
                long j14 = sQLiteStatementG2.getLong(i29);
                iD14 = i29;
                int i30 = iD15;
                long j15 = sQLiteStatementG2.getLong(i30);
                iD15 = i30;
                i4 = i26;
                int i31 = iD16;
                iD16 = i31;
                Profile.PausedUntil pausedUntilA = profileDao_Impl.f125116c.a(sQLiteStatementG2.getLong(i31));
                int i32 = iD17;
                Profile.BlockingMode blockingModeA = profileDao_Impl.f125117d.a((int) sQLiteStatementG2.getLong(i32));
                iD17 = i32;
                int i33 = iD18;
                ScheduleEmoji scheduleEmojiA = profileDao_Impl.f125118f.a((int) sQLiteStatementG2.getLong(i33));
                if (scheduleEmojiA == null) {
                    throw new IllegalStateException("Expected NON-NULL 'cz.mobilesoft.coreblock.enums.ScheduleEmoji', but it was NULL.");
                }
                iD18 = i33;
                int i34 = iD19;
                boolean z7 = ((int) sQLiteStatementG2.getLong(i34)) != 0;
                iD19 = i34;
                int i35 = iD20;
                boolean z8 = ((int) sQLiteStatementG2.getLong(i35)) != 0;
                iD20 = i35;
                int i36 = iD21;
                iD21 = i36;
                int i37 = iD22;
                iD22 = i37;
                int i38 = iD23;
                Profile profile = new Profile(j11, strF2, i14, i16, i19, i21, z2, z3, z4, z5, z6, j12, j13, j14, j15, pausedUntilA, blockingModeA, scheduleEmojiA, z7, z8, ((int) sQLiteStatementG2.getLong(i36)) != 0, (int) sQLiteStatementG2.getLong(i37), profileDao_Impl.f125119g.a((int) sQLiteStatementG2.getLong(i38)));
                Object objG = longSparseArray.g(sQLiteStatementG2.getLong(iD));
                if (objG == null) {
                    throw new IllegalStateException("Required value was null.");
                }
                List list = (List) objG;
                iD23 = i38;
                Object objG2 = longSparseArray2.g(sQLiteStatementG2.getLong(iD));
                if (objG2 == null) {
                    throw new IllegalStateException("Required value was null.");
                }
                List list2 = (List) objG2;
                Object objG3 = longSparseArray3.g(sQLiteStatementG2.getLong(iD));
                if (objG3 == null) {
                    throw new IllegalStateException("Required value was null.");
                }
                List list3 = (List) objG3;
                Object objG4 = longSparseArray4.g(sQLiteStatementG2.getLong(iD));
                if (objG4 == null) {
                    throw new IllegalStateException("Required value was null.");
                }
                List list4 = (List) objG4;
                Object objG5 = longSparseArray5.g(sQLiteStatementG2.getLong(iD));
                if (objG5 == null) {
                    throw new IllegalStateException("Required value was null.");
                }
                List list5 = (List) objG5;
                Object objG6 = longSparseArray6.g(sQLiteStatementG2.getLong(iD));
                if (objG6 == null) {
                    throw new IllegalStateException("Required value was null.");
                }
                List list6 = (List) objG6;
                Object objG7 = longSparseArray7.g(sQLiteStatementG2.getLong(iD));
                if (objG7 == null) {
                    throw new IllegalStateException("Required value was null.");
                }
                List list7 = (List) objG7;
                Object objG8 = longSparseArray9.g(sQLiteStatementG2.getLong(iD));
                if (objG8 == null) {
                    throw new IllegalStateException("Required value was null.");
                }
                arrayList.add(new ProfileWithConfiguration(profile, list, list2, list3, list4, list5, list6, list7, (List) objG8));
                longSparseArray8 = longSparseArray9;
                i11 = i15;
                iD2 = i18;
                i10 = i17;
                i9 = i20;
                i8 = i22;
                iD13 = i28;
            }
            sQLiteStatementG2.close();
            return arrayList;
        } catch (Throwable th) {
            sQLiteStatementG2.close();
            throw th;
        }
    }

    private final void G2(final SQLiteConnection sQLiteConnection, LongSparseArray longSparseArray) {
        if (longSparseArray.j()) {
            return;
        }
        if (longSparseArray.r() > 999) {
            RelationUtil.b(longSparseArray, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.m3
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return ProfileDao_Impl.H2(this.f125548a, sQLiteConnection, (LongSparseArray) obj);
                }
            });
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT `id`,`profileId`,`periodType`,`limitType`,`lastResetTime`,`allowedCount`,`usedCount`,`originalAllowedCount` FROM `UsageLimit` WHERE `profileId` IN (");
        StringUtil.a(sb, longSparseArray.r());
        sb.append(")");
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        SQLiteStatement sQLiteStatementG2 = sQLiteConnection.G2(string);
        int iR = longSparseArray.r();
        int i3 = 1;
        for (int i4 = 0; i4 < iR; i4++) {
            sQLiteStatementG2.A(i3, longSparseArray.k(i4));
            i3++;
        }
        try {
            int iC = SQLiteStatementUtil.c(sQLiteStatementG2, "profileId");
            if (iC == -1) {
                return;
            }
            while (sQLiteStatementG2.B2()) {
                List list = (List) longSparseArray.g(sQLiteStatementG2.getLong(iC));
                if (list != null) {
                    list.add(new UsageLimit(sQLiteStatementG2.getLong(0), sQLiteStatementG2.getLong(1), this.f125124l.a((int) sQLiteStatementG2.getLong(2)), this.f125125m.a((int) sQLiteStatementG2.getLong(3)), sQLiteStatementG2.getLong(4), sQLiteStatementG2.getLong(5), sQLiteStatementG2.getLong(6), sQLiteStatementG2.getLong(7)));
                }
            }
        } finally {
            sQLiteStatementG2.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List G3(String str, ProfileDao_Impl profileDao_Impl, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        try {
            int iD = SQLiteStatementUtil.d(sQLiteStatementG2, "id");
            int iD2 = SQLiteStatementUtil.d(sQLiteStatementG2, "title");
            int iD3 = SQLiteStatementUtil.d(sQLiteStatementG2, "typeCombinations");
            int iD4 = SQLiteStatementUtil.d(sQLiteStatementG2, "onConditions");
            int iD5 = SQLiteStatementUtil.d(sQLiteStatementG2, "operator");
            int iD6 = SQLiteStatementUtil.d(sQLiteStatementG2, "dayFlags");
            int iD7 = SQLiteStatementUtil.d(sQLiteStatementG2, "blockNotifications");
            int iD8 = SQLiteStatementUtil.d(sQLiteStatementG2, "blockLaunch");
            int iD9 = SQLiteStatementUtil.d(sQLiteStatementG2, "addNewApplications");
            int iD10 = SQLiteStatementUtil.d(sQLiteStatementG2, "isEnabled");
            int iD11 = SQLiteStatementUtil.d(sQLiteStatementG2, "isLocked");
            int iD12 = SQLiteStatementUtil.d(sQLiteStatementG2, "lastStartTime");
            int iD13 = SQLiteStatementUtil.d(sQLiteStatementG2, "onUntil");
            int iD14 = SQLiteStatementUtil.d(sQLiteStatementG2, "lockedUntil");
            int iD15 = SQLiteStatementUtil.d(sQLiteStatementG2, "lockAt");
            int iD16 = SQLiteStatementUtil.d(sQLiteStatementG2, "pausedUntil");
            int iD17 = SQLiteStatementUtil.d(sQLiteStatementG2, "blockingMode");
            int iD18 = SQLiteStatementUtil.d(sQLiteStatementG2, "emoji");
            int iD19 = SQLiteStatementUtil.d(sQLiteStatementG2, "blockUnsupportedBrowsers");
            int iD20 = SQLiteStatementUtil.d(sQLiteStatementG2, "blockAdultContent");
            int iD21 = SQLiteStatementUtil.d(sQLiteStatementG2, "blockInAppPurchases");
            int iD22 = SQLiteStatementUtil.d(sQLiteStatementG2, "selectedCategories");
            int iD23 = SQLiteStatementUtil.d(sQLiteStatementG2, "webBrowsingMode");
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementG2.B2()) {
                long j3 = sQLiteStatementG2.getLong(iD);
                String strF2 = sQLiteStatementG2.f2(iD2);
                int i3 = iD;
                int i4 = iD2;
                int i5 = (int) sQLiteStatementG2.getLong(iD3);
                int i6 = (int) sQLiteStatementG2.getLong(iD4);
                int i7 = (int) sQLiteStatementG2.getLong(iD5);
                int i8 = (int) sQLiteStatementG2.getLong(iD6);
                boolean z2 = ((int) sQLiteStatementG2.getLong(iD7)) != 0;
                int i9 = iD3;
                boolean z3 = ((int) sQLiteStatementG2.getLong(iD8)) != 0;
                boolean z4 = ((int) sQLiteStatementG2.getLong(iD9)) != 0;
                boolean z5 = ((int) sQLiteStatementG2.getLong(iD10)) != 0;
                boolean z6 = ((int) sQLiteStatementG2.getLong(iD11)) != 0;
                long j4 = sQLiteStatementG2.getLong(iD12);
                long j5 = sQLiteStatementG2.getLong(iD13);
                long j6 = sQLiteStatementG2.getLong(iD14);
                int i10 = iD15;
                long j7 = sQLiteStatementG2.getLong(i10);
                int i11 = iD16;
                int i12 = iD4;
                Profile.PausedUntil pausedUntilA = profileDao_Impl.f125116c.a(sQLiteStatementG2.getLong(i11));
                int i13 = iD17;
                Profile.BlockingMode blockingModeA = profileDao_Impl.f125117d.a((int) sQLiteStatementG2.getLong(i13));
                int i14 = iD5;
                int i15 = iD18;
                ScheduleEmoji scheduleEmojiA = profileDao_Impl.f125118f.a((int) sQLiteStatementG2.getLong(i15));
                if (scheduleEmojiA == null) {
                    throw new IllegalStateException("Expected NON-NULL 'cz.mobilesoft.coreblock.enums.ScheduleEmoji', but it was NULL.");
                }
                iD18 = i15;
                int i16 = iD19;
                boolean z7 = ((int) sQLiteStatementG2.getLong(i16)) != 0;
                iD19 = i16;
                int i17 = iD20;
                boolean z8 = ((int) sQLiteStatementG2.getLong(i17)) != 0;
                int i18 = iD21;
                boolean z9 = ((int) sQLiteStatementG2.getLong(i18)) != 0;
                iD21 = i18;
                int i19 = iD22;
                iD22 = i19;
                int i20 = iD23;
                arrayList.add(new Profile(j3, strF2, i5, i6, i7, i8, z2, z3, z4, z5, z6, j4, j5, j6, j7, pausedUntilA, blockingModeA, scheduleEmojiA, z7, z8, z9, (int) sQLiteStatementG2.getLong(i19), profileDao_Impl.f125119g.a((int) sQLiteStatementG2.getLong(i20))));
                iD4 = i12;
                iD23 = i20;
                iD5 = i14;
                iD17 = i13;
                iD = i3;
                iD2 = i4;
                iD3 = i9;
                iD16 = i11;
                iD20 = i17;
                iD15 = i10;
            }
            sQLiteStatementG2.close();
            return arrayList;
        } catch (Throwable th) {
            sQLiteStatementG2.close();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit H2(ProfileDao_Impl profileDao_Impl, SQLiteConnection sQLiteConnection, LongSparseArray _tmpMap) {
        Intrinsics.checkNotNullParameter(_tmpMap, "_tmpMap");
        profileDao_Impl.G2(sQLiteConnection, _tmpMap);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Profile H3(String str, long j3, ProfileDao_Impl profileDao_Impl, SQLiteConnection _connection) {
        Profile profile;
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        try {
            sQLiteStatementG2.A(1, j3);
            int iD = SQLiteStatementUtil.d(sQLiteStatementG2, "id");
            int iD2 = SQLiteStatementUtil.d(sQLiteStatementG2, "title");
            int iD3 = SQLiteStatementUtil.d(sQLiteStatementG2, "typeCombinations");
            int iD4 = SQLiteStatementUtil.d(sQLiteStatementG2, "onConditions");
            int iD5 = SQLiteStatementUtil.d(sQLiteStatementG2, "operator");
            int iD6 = SQLiteStatementUtil.d(sQLiteStatementG2, "dayFlags");
            int iD7 = SQLiteStatementUtil.d(sQLiteStatementG2, "blockNotifications");
            int iD8 = SQLiteStatementUtil.d(sQLiteStatementG2, "blockLaunch");
            int iD9 = SQLiteStatementUtil.d(sQLiteStatementG2, "addNewApplications");
            int iD10 = SQLiteStatementUtil.d(sQLiteStatementG2, "isEnabled");
            int iD11 = SQLiteStatementUtil.d(sQLiteStatementG2, "isLocked");
            int iD12 = SQLiteStatementUtil.d(sQLiteStatementG2, "lastStartTime");
            int iD13 = SQLiteStatementUtil.d(sQLiteStatementG2, "onUntil");
            int iD14 = SQLiteStatementUtil.d(sQLiteStatementG2, "lockedUntil");
            int iD15 = SQLiteStatementUtil.d(sQLiteStatementG2, "lockAt");
            int iD16 = SQLiteStatementUtil.d(sQLiteStatementG2, "pausedUntil");
            int iD17 = SQLiteStatementUtil.d(sQLiteStatementG2, "blockingMode");
            int iD18 = SQLiteStatementUtil.d(sQLiteStatementG2, "emoji");
            int iD19 = SQLiteStatementUtil.d(sQLiteStatementG2, "blockUnsupportedBrowsers");
            int iD20 = SQLiteStatementUtil.d(sQLiteStatementG2, "blockAdultContent");
            int iD21 = SQLiteStatementUtil.d(sQLiteStatementG2, "blockInAppPurchases");
            int iD22 = SQLiteStatementUtil.d(sQLiteStatementG2, "selectedCategories");
            int iD23 = SQLiteStatementUtil.d(sQLiteStatementG2, "webBrowsingMode");
            if (sQLiteStatementG2.B2()) {
                long j4 = sQLiteStatementG2.getLong(iD);
                String strF2 = sQLiteStatementG2.f2(iD2);
                int i3 = (int) sQLiteStatementG2.getLong(iD3);
                int i4 = (int) sQLiteStatementG2.getLong(iD4);
                int i5 = (int) sQLiteStatementG2.getLong(iD5);
                int i6 = (int) sQLiteStatementG2.getLong(iD6);
                boolean z2 = ((int) sQLiteStatementG2.getLong(iD7)) != 0;
                boolean z3 = ((int) sQLiteStatementG2.getLong(iD8)) != 0;
                boolean z4 = ((int) sQLiteStatementG2.getLong(iD9)) != 0;
                boolean z5 = ((int) sQLiteStatementG2.getLong(iD10)) != 0;
                boolean z6 = ((int) sQLiteStatementG2.getLong(iD11)) != 0;
                long j5 = sQLiteStatementG2.getLong(iD12);
                long j6 = sQLiteStatementG2.getLong(iD13);
                long j7 = sQLiteStatementG2.getLong(iD14);
                long j8 = sQLiteStatementG2.getLong(iD15);
                Profile.PausedUntil pausedUntilA = profileDao_Impl.f125116c.a(sQLiteStatementG2.getLong(iD16));
                Profile.BlockingMode blockingModeA = profileDao_Impl.f125117d.a((int) sQLiteStatementG2.getLong(iD17));
                ScheduleEmoji scheduleEmojiA = profileDao_Impl.f125118f.a((int) sQLiteStatementG2.getLong(iD18));
                if (scheduleEmojiA == null) {
                    throw new IllegalStateException("Expected NON-NULL 'cz.mobilesoft.coreblock.enums.ScheduleEmoji', but it was NULL.");
                }
                profile = new Profile(j4, strF2, i3, i4, i5, i6, z2, z3, z4, z5, z6, j5, j6, j7, j8, pausedUntilA, blockingModeA, scheduleEmojiA, ((int) sQLiteStatementG2.getLong(iD19)) != 0, ((int) sQLiteStatementG2.getLong(iD20)) != 0, ((int) sQLiteStatementG2.getLong(iD21)) != 0, (int) sQLiteStatementG2.getLong(iD22), profileDao_Impl.f125119g.a((int) sQLiteStatementG2.getLong(iD23)));
            } else {
                profile = null;
            }
            sQLiteStatementG2.close();
            return profile;
        } catch (Throwable th) {
            sQLiteStatementG2.close();
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void I2(final SQLiteConnection sQLiteConnection, LongSparseArray longSparseArray) {
        if (longSparseArray.j()) {
            return;
        }
        int i3 = 1;
        if (longSparseArray.r() > 999) {
            RelationUtil.b(longSparseArray, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.q3
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return ProfileDao_Impl.J2(this.f125617a, sQLiteConnection, (LongSparseArray) obj);
                }
            });
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT `id`,`profileId`,`name`,`blockingType`,`isAnywhereInUrl`,`isEnabled` FROM `WebsiteProfileRelation` WHERE `profileId` IN (");
        StringUtil.a(sb, longSparseArray.r());
        sb.append(")");
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        SQLiteStatement sQLiteStatementG2 = sQLiteConnection.G2(string);
        int iR = longSparseArray.r();
        int i4 = 0;
        int i5 = 1;
        for (int i6 = 0; i6 < iR; i6++) {
            sQLiteStatementG2.A(i5, longSparseArray.k(i6));
            i5++;
        }
        try {
            int iC = SQLiteStatementUtil.c(sQLiteStatementG2, "profileId");
            if (iC == -1) {
                return;
            }
            while (sQLiteStatementG2.B2()) {
                List list = (List) longSparseArray.g(sQLiteStatementG2.getLong(iC));
                if (list != null) {
                    list.add(new WebsiteProfileRelation(sQLiteStatementG2.getLong(i4), sQLiteStatementG2.getLong(i3), sQLiteStatementG2.f2(2), this.f125123k.a((int) sQLiteStatementG2.getLong(3)), ((int) sQLiteStatementG2.getLong(4)) != 0 ? i3 : i4, ((int) sQLiteStatementG2.getLong(5)) != 0));
                    i4 = 0;
                    i3 = 1;
                }
            }
        } finally {
            sQLiteStatementG2.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit J2(ProfileDao_Impl profileDao_Impl, SQLiteConnection sQLiteConnection, LongSparseArray _tmpMap) {
        Intrinsics.checkNotNullParameter(_tmpMap, "_tmpMap");
        profileDao_Impl.I2(sQLiteConnection, _tmpMap);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ProfileWithBlockedItems J3(String str, ProfileDao_Impl profileDao_Impl, SQLiteConnection _connection) {
        ProfileWithBlockedItems profileWithBlockedItems;
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        try {
            int iD = SQLiteStatementUtil.d(sQLiteStatementG2, "id");
            int iD2 = SQLiteStatementUtil.d(sQLiteStatementG2, "title");
            int iD3 = SQLiteStatementUtil.d(sQLiteStatementG2, "typeCombinations");
            int iD4 = SQLiteStatementUtil.d(sQLiteStatementG2, "onConditions");
            int iD5 = SQLiteStatementUtil.d(sQLiteStatementG2, "operator");
            int iD6 = SQLiteStatementUtil.d(sQLiteStatementG2, "dayFlags");
            int iD7 = SQLiteStatementUtil.d(sQLiteStatementG2, "blockNotifications");
            int iD8 = SQLiteStatementUtil.d(sQLiteStatementG2, "blockLaunch");
            int iD9 = SQLiteStatementUtil.d(sQLiteStatementG2, "addNewApplications");
            int iD10 = SQLiteStatementUtil.d(sQLiteStatementG2, "isEnabled");
            int iD11 = SQLiteStatementUtil.d(sQLiteStatementG2, "isLocked");
            int iD12 = SQLiteStatementUtil.d(sQLiteStatementG2, "lastStartTime");
            int iD13 = SQLiteStatementUtil.d(sQLiteStatementG2, "onUntil");
            int iD14 = SQLiteStatementUtil.d(sQLiteStatementG2, "lockedUntil");
            int iD15 = SQLiteStatementUtil.d(sQLiteStatementG2, "lockAt");
            int iD16 = SQLiteStatementUtil.d(sQLiteStatementG2, "pausedUntil");
            int iD17 = SQLiteStatementUtil.d(sQLiteStatementG2, "blockingMode");
            int iD18 = SQLiteStatementUtil.d(sQLiteStatementG2, "emoji");
            int iD19 = SQLiteStatementUtil.d(sQLiteStatementG2, "blockUnsupportedBrowsers");
            int iD20 = SQLiteStatementUtil.d(sQLiteStatementG2, "blockAdultContent");
            int iD21 = SQLiteStatementUtil.d(sQLiteStatementG2, "blockInAppPurchases");
            int iD22 = SQLiteStatementUtil.d(sQLiteStatementG2, "selectedCategories");
            int iD23 = SQLiteStatementUtil.d(sQLiteStatementG2, "webBrowsingMode");
            LongSparseArray longSparseArray = new LongSparseArray(0, 1, null);
            LongSparseArray longSparseArray2 = new LongSparseArray(0, 1, null);
            LongSparseArray longSparseArray3 = new LongSparseArray(0, 1, null);
            LongSparseArray longSparseArray4 = new LongSparseArray(0, 1, null);
            while (sQLiteStatementG2.B2()) {
                long j3 = sQLiteStatementG2.getLong(iD);
                if (!longSparseArray.e(j3)) {
                    longSparseArray.m(j3, new ArrayList());
                }
                long j4 = sQLiteStatementG2.getLong(iD);
                if (!longSparseArray2.e(j4)) {
                    longSparseArray2.m(j4, new ArrayList());
                }
                long j5 = sQLiteStatementG2.getLong(iD);
                if (!longSparseArray3.e(j5)) {
                    longSparseArray3.m(j5, new ArrayList());
                }
                long j6 = sQLiteStatementG2.getLong(iD);
                if (!longSparseArray4.e(j6)) {
                    longSparseArray4.m(j6, new ArrayList());
                }
            }
            sQLiteStatementG2.reset();
            profileDao_Impl.s2(_connection, longSparseArray);
            profileDao_Impl.I2(_connection, longSparseArray2);
            profileDao_Impl.C2(_connection, longSparseArray3);
            profileDao_Impl.E2(_connection, longSparseArray4);
            if (sQLiteStatementG2.B2()) {
                long j7 = sQLiteStatementG2.getLong(iD);
                String strF2 = sQLiteStatementG2.f2(iD2);
                int i3 = (int) sQLiteStatementG2.getLong(iD3);
                int i4 = (int) sQLiteStatementG2.getLong(iD4);
                int i5 = (int) sQLiteStatementG2.getLong(iD5);
                int i6 = (int) sQLiteStatementG2.getLong(iD6);
                boolean z2 = ((int) sQLiteStatementG2.getLong(iD7)) != 0;
                boolean z3 = ((int) sQLiteStatementG2.getLong(iD8)) != 0;
                boolean z4 = ((int) sQLiteStatementG2.getLong(iD9)) != 0;
                boolean z5 = ((int) sQLiteStatementG2.getLong(iD10)) != 0;
                boolean z6 = ((int) sQLiteStatementG2.getLong(iD11)) != 0;
                long j8 = sQLiteStatementG2.getLong(iD12);
                long j9 = sQLiteStatementG2.getLong(iD13);
                long j10 = sQLiteStatementG2.getLong(iD14);
                long j11 = sQLiteStatementG2.getLong(iD15);
                Profile.PausedUntil pausedUntilA = profileDao_Impl.f125116c.a(sQLiteStatementG2.getLong(iD16));
                Profile.BlockingMode blockingModeA = profileDao_Impl.f125117d.a((int) sQLiteStatementG2.getLong(iD17));
                ScheduleEmoji scheduleEmojiA = profileDao_Impl.f125118f.a((int) sQLiteStatementG2.getLong(iD18));
                if (scheduleEmojiA == null) {
                    throw new IllegalStateException("Expected NON-NULL 'cz.mobilesoft.coreblock.enums.ScheduleEmoji', but it was NULL.");
                }
                Profile profile = new Profile(j7, strF2, i3, i4, i5, i6, z2, z3, z4, z5, z6, j8, j9, j10, j11, pausedUntilA, blockingModeA, scheduleEmojiA, ((int) sQLiteStatementG2.getLong(iD19)) != 0, ((int) sQLiteStatementG2.getLong(iD20)) != 0, ((int) sQLiteStatementG2.getLong(iD21)) != 0, (int) sQLiteStatementG2.getLong(iD22), profileDao_Impl.f125119g.a((int) sQLiteStatementG2.getLong(iD23)));
                Object objG = longSparseArray.g(sQLiteStatementG2.getLong(iD));
                if (objG == null) {
                    throw new IllegalStateException("Required value was null.");
                }
                List list = (List) objG;
                Object objG2 = longSparseArray2.g(sQLiteStatementG2.getLong(iD));
                if (objG2 == null) {
                    throw new IllegalStateException("Required value was null.");
                }
                List list2 = (List) objG2;
                Object objG3 = longSparseArray3.g(sQLiteStatementG2.getLong(iD));
                if (objG3 == null) {
                    throw new IllegalStateException("Required value was null.");
                }
                List list3 = (List) objG3;
                Object objG4 = longSparseArray4.g(sQLiteStatementG2.getLong(iD));
                if (objG4 == null) {
                    throw new IllegalStateException("Required value was null.");
                }
                profileWithBlockedItems = new ProfileWithBlockedItems(profile, list, list2, list3, (List) objG4);
            } else {
                profileWithBlockedItems = null;
            }
            sQLiteStatementG2.close();
            return profileWithBlockedItems;
        } catch (Throwable th) {
            sQLiteStatementG2.close();
            throw th;
        }
    }

    private final void K2(final SQLiteConnection sQLiteConnection, LongSparseArray longSparseArray) {
        if (longSparseArray.j()) {
            return;
        }
        if (longSparseArray.r() > 999) {
            RelationUtil.b(longSparseArray, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.r3
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return ProfileDao_Impl.L2(this.f125632a, sQLiteConnection, (LongSparseArray) obj);
                }
            });
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT `id`,`profileId`,`ssid` FROM `WifiNetwork` WHERE `profileId` IN (");
        StringUtil.a(sb, longSparseArray.r());
        sb.append(")");
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        SQLiteStatement sQLiteStatementG2 = sQLiteConnection.G2(string);
        int iR = longSparseArray.r();
        int i3 = 1;
        for (int i4 = 0; i4 < iR; i4++) {
            sQLiteStatementG2.A(i3, longSparseArray.k(i4));
            i3++;
        }
        try {
            int iC = SQLiteStatementUtil.c(sQLiteStatementG2, "profileId");
            if (iC == -1) {
                sQLiteStatementG2.close();
                return;
            }
            while (sQLiteStatementG2.B2()) {
                List list = (List) longSparseArray.g(sQLiteStatementG2.getLong(iC));
                if (list != null) {
                    list.add(new WifiNetwork(sQLiteStatementG2.getLong(0), sQLiteStatementG2.getLong(1), sQLiteStatementG2.f2(2)));
                }
            }
        } finally {
            sQLiteStatementG2.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List K3(String str, ProfileDao_Impl profileDao_Impl, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        try {
            int iD = SQLiteStatementUtil.d(sQLiteStatementG2, "id");
            int iD2 = SQLiteStatementUtil.d(sQLiteStatementG2, "title");
            int iD3 = SQLiteStatementUtil.d(sQLiteStatementG2, "typeCombinations");
            int iD4 = SQLiteStatementUtil.d(sQLiteStatementG2, "onConditions");
            int iD5 = SQLiteStatementUtil.d(sQLiteStatementG2, "operator");
            int iD6 = SQLiteStatementUtil.d(sQLiteStatementG2, "dayFlags");
            int iD7 = SQLiteStatementUtil.d(sQLiteStatementG2, "blockNotifications");
            int iD8 = SQLiteStatementUtil.d(sQLiteStatementG2, "blockLaunch");
            int iD9 = SQLiteStatementUtil.d(sQLiteStatementG2, "addNewApplications");
            int iD10 = SQLiteStatementUtil.d(sQLiteStatementG2, "isEnabled");
            int iD11 = SQLiteStatementUtil.d(sQLiteStatementG2, "isLocked");
            int iD12 = SQLiteStatementUtil.d(sQLiteStatementG2, "lastStartTime");
            int iD13 = SQLiteStatementUtil.d(sQLiteStatementG2, "onUntil");
            int iD14 = SQLiteStatementUtil.d(sQLiteStatementG2, "lockedUntil");
            int iD15 = SQLiteStatementUtil.d(sQLiteStatementG2, "lockAt");
            int iD16 = SQLiteStatementUtil.d(sQLiteStatementG2, "pausedUntil");
            int iD17 = SQLiteStatementUtil.d(sQLiteStatementG2, "blockingMode");
            int iD18 = SQLiteStatementUtil.d(sQLiteStatementG2, "emoji");
            int iD19 = SQLiteStatementUtil.d(sQLiteStatementG2, "blockUnsupportedBrowsers");
            int iD20 = SQLiteStatementUtil.d(sQLiteStatementG2, "blockAdultContent");
            int iD21 = SQLiteStatementUtil.d(sQLiteStatementG2, "blockInAppPurchases");
            int iD22 = SQLiteStatementUtil.d(sQLiteStatementG2, "selectedCategories");
            int iD23 = SQLiteStatementUtil.d(sQLiteStatementG2, "webBrowsingMode");
            int i3 = iD12;
            int i4 = iD11;
            int i5 = iD10;
            LongSparseArray longSparseArray = new LongSparseArray(0, 1, null);
            while (sQLiteStatementG2.B2()) {
                long j3 = sQLiteStatementG2.getLong(iD);
                if (!longSparseArray.e(j3)) {
                    longSparseArray.m(j3, new ArrayList());
                }
            }
            sQLiteStatementG2.reset();
            profileDao_Impl.A2(_connection, longSparseArray);
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementG2.B2()) {
                long j4 = sQLiteStatementG2.getLong(iD);
                String strF2 = sQLiteStatementG2.f2(iD2);
                int i6 = (int) sQLiteStatementG2.getLong(iD3);
                int i7 = (int) sQLiteStatementG2.getLong(iD4);
                int i8 = iD2;
                int i9 = iD3;
                int i10 = (int) sQLiteStatementG2.getLong(iD5);
                int i11 = (int) sQLiteStatementG2.getLong(iD6);
                boolean z2 = ((int) sQLiteStatementG2.getLong(iD7)) != 0;
                boolean z3 = ((int) sQLiteStatementG2.getLong(iD8)) != 0;
                boolean z4 = ((int) sQLiteStatementG2.getLong(iD9)) != 0;
                int i12 = i5;
                int i13 = iD4;
                boolean z5 = ((int) sQLiteStatementG2.getLong(i12)) != 0;
                int i14 = i4;
                int i15 = iD5;
                boolean z6 = ((int) sQLiteStatementG2.getLong(i14)) != 0;
                int i16 = i3;
                long j5 = sQLiteStatementG2.getLong(i16);
                int i17 = iD13;
                long j6 = sQLiteStatementG2.getLong(i17);
                int i18 = iD14;
                long j7 = sQLiteStatementG2.getLong(i18);
                iD14 = i18;
                int i19 = iD15;
                long j8 = sQLiteStatementG2.getLong(i19);
                iD15 = i19;
                int i20 = iD16;
                Profile.PausedUntil pausedUntilA = profileDao_Impl.f125116c.a(sQLiteStatementG2.getLong(i20));
                int i21 = iD17;
                Profile.BlockingMode blockingModeA = profileDao_Impl.f125117d.a((int) sQLiteStatementG2.getLong(i21));
                int i22 = iD18;
                ScheduleEmoji scheduleEmojiA = profileDao_Impl.f125118f.a((int) sQLiteStatementG2.getLong(i22));
                if (scheduleEmojiA == null) {
                    throw new IllegalStateException("Expected NON-NULL 'cz.mobilesoft.coreblock.enums.ScheduleEmoji', but it was NULL.");
                }
                iD18 = i22;
                int i23 = iD19;
                boolean z7 = ((int) sQLiteStatementG2.getLong(i23)) != 0;
                iD19 = i23;
                int i24 = iD20;
                boolean z8 = ((int) sQLiteStatementG2.getLong(i24)) != 0;
                int i25 = iD21;
                boolean z9 = ((int) sQLiteStatementG2.getLong(i25)) != 0;
                iD21 = i25;
                int i26 = iD22;
                iD22 = i26;
                int i27 = iD23;
                Profile profile = new Profile(j4, strF2, i6, i7, i10, i11, z2, z3, z4, z5, z6, j5, j6, j7, j8, pausedUntilA, blockingModeA, scheduleEmojiA, z7, z8, z9, (int) sQLiteStatementG2.getLong(i26), profileDao_Impl.f125119g.a((int) sQLiteStatementG2.getLong(i27)));
                Object objG = longSparseArray.g(sQLiteStatementG2.getLong(iD));
                if (objG == null) {
                    throw new IllegalStateException("Required value was null.");
                }
                arrayList.add(new ProfileWithIntervals(profile, (List) objG));
                iD2 = i8;
                iD5 = i15;
                iD4 = i13;
                i4 = i14;
                i5 = i12;
                i3 = i16;
                iD16 = i20;
                iD13 = i17;
                iD17 = i21;
                iD20 = i24;
                iD23 = i27;
                iD3 = i9;
            }
            sQLiteStatementG2.close();
            return arrayList;
        } catch (Throwable th) {
            sQLiteStatementG2.close();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit L2(ProfileDao_Impl profileDao_Impl, SQLiteConnection sQLiteConnection, LongSparseArray _tmpMap) {
        Intrinsics.checkNotNullParameter(_tmpMap, "_tmpMap");
        profileDao_Impl.K2(sQLiteConnection, _tmpMap);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Profile M3(String str, ProfileDao_Impl profileDao_Impl, SQLiteConnection _connection) {
        Profile profile;
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        try {
            int iD = SQLiteStatementUtil.d(sQLiteStatementG2, "id");
            int iD2 = SQLiteStatementUtil.d(sQLiteStatementG2, "title");
            int iD3 = SQLiteStatementUtil.d(sQLiteStatementG2, "typeCombinations");
            int iD4 = SQLiteStatementUtil.d(sQLiteStatementG2, "onConditions");
            int iD5 = SQLiteStatementUtil.d(sQLiteStatementG2, "operator");
            int iD6 = SQLiteStatementUtil.d(sQLiteStatementG2, "dayFlags");
            int iD7 = SQLiteStatementUtil.d(sQLiteStatementG2, "blockNotifications");
            int iD8 = SQLiteStatementUtil.d(sQLiteStatementG2, "blockLaunch");
            int iD9 = SQLiteStatementUtil.d(sQLiteStatementG2, "addNewApplications");
            int iD10 = SQLiteStatementUtil.d(sQLiteStatementG2, "isEnabled");
            int iD11 = SQLiteStatementUtil.d(sQLiteStatementG2, "isLocked");
            int iD12 = SQLiteStatementUtil.d(sQLiteStatementG2, "lastStartTime");
            int iD13 = SQLiteStatementUtil.d(sQLiteStatementG2, "onUntil");
            int iD14 = SQLiteStatementUtil.d(sQLiteStatementG2, "lockedUntil");
            int iD15 = SQLiteStatementUtil.d(sQLiteStatementG2, "lockAt");
            int iD16 = SQLiteStatementUtil.d(sQLiteStatementG2, "pausedUntil");
            int iD17 = SQLiteStatementUtil.d(sQLiteStatementG2, "blockingMode");
            int iD18 = SQLiteStatementUtil.d(sQLiteStatementG2, "emoji");
            int iD19 = SQLiteStatementUtil.d(sQLiteStatementG2, "blockUnsupportedBrowsers");
            int iD20 = SQLiteStatementUtil.d(sQLiteStatementG2, "blockAdultContent");
            int iD21 = SQLiteStatementUtil.d(sQLiteStatementG2, "blockInAppPurchases");
            int iD22 = SQLiteStatementUtil.d(sQLiteStatementG2, "selectedCategories");
            int iD23 = SQLiteStatementUtil.d(sQLiteStatementG2, "webBrowsingMode");
            if (sQLiteStatementG2.B2()) {
                long j3 = sQLiteStatementG2.getLong(iD);
                String strF2 = sQLiteStatementG2.f2(iD2);
                int i3 = (int) sQLiteStatementG2.getLong(iD3);
                int i4 = (int) sQLiteStatementG2.getLong(iD4);
                int i5 = (int) sQLiteStatementG2.getLong(iD5);
                int i6 = (int) sQLiteStatementG2.getLong(iD6);
                boolean z2 = ((int) sQLiteStatementG2.getLong(iD7)) != 0;
                boolean z3 = ((int) sQLiteStatementG2.getLong(iD8)) != 0;
                boolean z4 = ((int) sQLiteStatementG2.getLong(iD9)) != 0;
                boolean z5 = ((int) sQLiteStatementG2.getLong(iD10)) != 0;
                boolean z6 = ((int) sQLiteStatementG2.getLong(iD11)) != 0;
                long j4 = sQLiteStatementG2.getLong(iD12);
                long j5 = sQLiteStatementG2.getLong(iD13);
                long j6 = sQLiteStatementG2.getLong(iD14);
                long j7 = sQLiteStatementG2.getLong(iD15);
                Profile.PausedUntil pausedUntilA = profileDao_Impl.f125116c.a(sQLiteStatementG2.getLong(iD16));
                Profile.BlockingMode blockingModeA = profileDao_Impl.f125117d.a((int) sQLiteStatementG2.getLong(iD17));
                ScheduleEmoji scheduleEmojiA = profileDao_Impl.f125118f.a((int) sQLiteStatementG2.getLong(iD18));
                if (scheduleEmojiA == null) {
                    throw new IllegalStateException("Expected NON-NULL 'cz.mobilesoft.coreblock.enums.ScheduleEmoji', but it was NULL.");
                }
                profile = new Profile(j3, strF2, i3, i4, i5, i6, z2, z3, z4, z5, z6, j4, j5, j6, j7, pausedUntilA, blockingModeA, scheduleEmojiA, ((int) sQLiteStatementG2.getLong(iD19)) != 0, ((int) sQLiteStatementG2.getLong(iD20)) != 0, ((int) sQLiteStatementG2.getLong(iD21)) != 0, (int) sQLiteStatementG2.getLong(iD22), profileDao_Impl.f125119g.a((int) sQLiteStatementG2.getLong(iD23)));
            } else {
                profile = null;
            }
            sQLiteStatementG2.close();
            return profile;
        } catch (Throwable th) {
            sQLiteStatementG2.close();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long O3(ProfileDao_Impl profileDao_Impl, Profile profile, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        return profileDao_Impl.f125115b.d(_connection, profile);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List P3(ProfileDao_Impl profileDao_Impl, Collection collection, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        return profileDao_Impl.f125115b.e(_connection, collection);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Q3(String str, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        try {
            sQLiteStatementG2.B2();
            sQLiteStatementG2.close();
            return Unit.f139807a;
        } catch (Throwable th) {
            sQLiteStatementG2.close();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit S3(ProfileDao_Impl profileDao_Impl, Profile profile, SQLiteConnection _connection) throws Exception {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        profileDao_Impl.f125121i.c(_connection, profile);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit T3(ProfileDao_Impl profileDao_Impl, Collection collection, SQLiteConnection _connection) throws Exception {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        profileDao_Impl.f125121i.d(_connection, collection);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long U3(String str, RoomRawQuery roomRawQuery, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        try {
            roomRawQuery.e().invoke(sQLiteStatementG2);
            return sQLiteStatementG2.B2() ? sQLiteStatementG2.getLong(0) : 0L;
        } finally {
            sQLiteStatementG2.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long a3(String str, RoomRawQuery roomRawQuery, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        try {
            roomRawQuery.e().invoke(sQLiteStatementG2);
            return sQLiteStatementG2.B2() ? sQLiteStatementG2.getLong(0) : 0L;
        } finally {
            sQLiteStatementG2.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long b3(String str, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        try {
            return sQLiteStatementG2.B2() ? sQLiteStatementG2.getLong(0) : 0L;
        } finally {
            sQLiteStatementG2.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long c3(String str, long j3, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        try {
            sQLiteStatementG2.A(1, j3);
            return sQLiteStatementG2.B2() ? sQLiteStatementG2.getLong(0) : 0L;
        } finally {
            sQLiteStatementG2.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long d3(String str, int i3, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        try {
            sQLiteStatementG2.A(1, i3);
            return sQLiteStatementG2.B2() ? sQLiteStatementG2.getLong(0) : 0L;
        } finally {
            sQLiteStatementG2.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int e3(String str, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        try {
            return sQLiteStatementG2.B2() ? (int) sQLiteStatementG2.getLong(0) : 0;
        } finally {
            sQLiteStatementG2.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long f3(String str, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        try {
            return sQLiteStatementG2.B2() ? sQLiteStatementG2.getLong(0) : 0L;
        } finally {
            sQLiteStatementG2.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long g3(String str, long j3, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        try {
            sQLiteStatementG2.A(1, j3);
            return sQLiteStatementG2.B2() ? sQLiteStatementG2.getLong(0) : 0L;
        } finally {
            sQLiteStatementG2.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long h3(String str, long j3, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        try {
            sQLiteStatementG2.A(1, j3);
            return sQLiteStatementG2.B2() ? sQLiteStatementG2.getLong(0) : 0L;
        } finally {
            sQLiteStatementG2.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i3(ProfileDao_Impl profileDao_Impl, List list, SQLiteConnection _connection) throws Exception {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        profileDao_Impl.f125120h.d(_connection, list);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j3(String str, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        try {
            sQLiteStatementG2.B2();
            sQLiteStatementG2.close();
            return Unit.f139807a;
        } catch (Throwable th) {
            sQLiteStatementG2.close();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k3(String str, int i3, long j3, long j4, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        try {
            sQLiteStatementG2.A(1, i3);
            sQLiteStatementG2.A(2, j3);
            sQLiteStatementG2.A(3, j4);
            sQLiteStatementG2.B2();
            sQLiteStatementG2.close();
            return Unit.f139807a;
        } catch (Throwable th) {
            sQLiteStatementG2.close();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l3(String str, boolean z2, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        try {
            sQLiteStatementG2.A(1, z2 ? 1L : 0L);
            sQLiteStatementG2.B2();
            sQLiteStatementG2.close();
            return Unit.f139807a;
        } catch (Throwable th) {
            sQLiteStatementG2.close();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m3(String str, List list, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        try {
            Iterator it = list.iterator();
            int i3 = 1;
            while (it.hasNext()) {
                sQLiteStatementG2.A(i3, ((Number) it.next()).longValue());
                i3++;
            }
            sQLiteStatementG2.B2();
            sQLiteStatementG2.close();
            return Unit.f139807a;
        } catch (Throwable th) {
            sQLiteStatementG2.close();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List n3(String str, ProfileDao_Impl profileDao_Impl, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        try {
            int iD = SQLiteStatementUtil.d(sQLiteStatementG2, "id");
            int iD2 = SQLiteStatementUtil.d(sQLiteStatementG2, "title");
            int iD3 = SQLiteStatementUtil.d(sQLiteStatementG2, "typeCombinations");
            int iD4 = SQLiteStatementUtil.d(sQLiteStatementG2, "onConditions");
            int iD5 = SQLiteStatementUtil.d(sQLiteStatementG2, "operator");
            int iD6 = SQLiteStatementUtil.d(sQLiteStatementG2, "dayFlags");
            int iD7 = SQLiteStatementUtil.d(sQLiteStatementG2, "blockNotifications");
            int iD8 = SQLiteStatementUtil.d(sQLiteStatementG2, "blockLaunch");
            int iD9 = SQLiteStatementUtil.d(sQLiteStatementG2, "addNewApplications");
            int iD10 = SQLiteStatementUtil.d(sQLiteStatementG2, "isEnabled");
            int iD11 = SQLiteStatementUtil.d(sQLiteStatementG2, "isLocked");
            int iD12 = SQLiteStatementUtil.d(sQLiteStatementG2, "lastStartTime");
            int iD13 = SQLiteStatementUtil.d(sQLiteStatementG2, "onUntil");
            int iD14 = SQLiteStatementUtil.d(sQLiteStatementG2, "lockedUntil");
            int iD15 = SQLiteStatementUtil.d(sQLiteStatementG2, "lockAt");
            int iD16 = SQLiteStatementUtil.d(sQLiteStatementG2, "pausedUntil");
            int iD17 = SQLiteStatementUtil.d(sQLiteStatementG2, "blockingMode");
            int iD18 = SQLiteStatementUtil.d(sQLiteStatementG2, "emoji");
            int iD19 = SQLiteStatementUtil.d(sQLiteStatementG2, "blockUnsupportedBrowsers");
            int iD20 = SQLiteStatementUtil.d(sQLiteStatementG2, "blockAdultContent");
            int iD21 = SQLiteStatementUtil.d(sQLiteStatementG2, "blockInAppPurchases");
            int iD22 = SQLiteStatementUtil.d(sQLiteStatementG2, "selectedCategories");
            int iD23 = SQLiteStatementUtil.d(sQLiteStatementG2, "webBrowsingMode");
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementG2.B2()) {
                long j3 = sQLiteStatementG2.getLong(iD);
                String strF2 = sQLiteStatementG2.f2(iD2);
                int i3 = iD;
                int i4 = iD2;
                int i5 = (int) sQLiteStatementG2.getLong(iD3);
                int i6 = (int) sQLiteStatementG2.getLong(iD4);
                int i7 = (int) sQLiteStatementG2.getLong(iD5);
                int i8 = (int) sQLiteStatementG2.getLong(iD6);
                boolean z2 = ((int) sQLiteStatementG2.getLong(iD7)) != 0;
                int i9 = iD3;
                boolean z3 = ((int) sQLiteStatementG2.getLong(iD8)) != 0;
                boolean z4 = ((int) sQLiteStatementG2.getLong(iD9)) != 0;
                boolean z5 = ((int) sQLiteStatementG2.getLong(iD10)) != 0;
                boolean z6 = ((int) sQLiteStatementG2.getLong(iD11)) != 0;
                long j4 = sQLiteStatementG2.getLong(iD12);
                long j5 = sQLiteStatementG2.getLong(iD13);
                long j6 = sQLiteStatementG2.getLong(iD14);
                int i10 = iD15;
                long j7 = sQLiteStatementG2.getLong(i10);
                int i11 = iD16;
                int i12 = iD4;
                Profile.PausedUntil pausedUntilA = profileDao_Impl.f125116c.a(sQLiteStatementG2.getLong(i11));
                int i13 = iD17;
                Profile.BlockingMode blockingModeA = profileDao_Impl.f125117d.a((int) sQLiteStatementG2.getLong(i13));
                int i14 = iD5;
                int i15 = iD18;
                ScheduleEmoji scheduleEmojiA = profileDao_Impl.f125118f.a((int) sQLiteStatementG2.getLong(i15));
                if (scheduleEmojiA == null) {
                    throw new IllegalStateException("Expected NON-NULL 'cz.mobilesoft.coreblock.enums.ScheduleEmoji', but it was NULL.");
                }
                iD18 = i15;
                int i16 = iD19;
                boolean z7 = ((int) sQLiteStatementG2.getLong(i16)) != 0;
                iD19 = i16;
                int i17 = iD20;
                boolean z8 = ((int) sQLiteStatementG2.getLong(i17)) != 0;
                int i18 = iD21;
                boolean z9 = ((int) sQLiteStatementG2.getLong(i18)) != 0;
                iD21 = i18;
                int i19 = iD22;
                iD22 = i19;
                int i20 = iD23;
                arrayList.add(new Profile(j3, strF2, i5, i6, i7, i8, z2, z3, z4, z5, z6, j4, j5, j6, j7, pausedUntilA, blockingModeA, scheduleEmojiA, z7, z8, z9, (int) sQLiteStatementG2.getLong(i19), profileDao_Impl.f125119g.a((int) sQLiteStatementG2.getLong(i20))));
                iD4 = i12;
                iD23 = i20;
                iD5 = i14;
                iD17 = i13;
                iD = i3;
                iD2 = i4;
                iD3 = i9;
                iD16 = i11;
                iD20 = i17;
                iD15 = i10;
            }
            sQLiteStatementG2.close();
            return arrayList;
        } catch (Throwable th) {
            sQLiteStatementG2.close();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List o3(String str, List list, int i3, List list2, ProfileDao_Impl profileDao_Impl, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        try {
            Iterator it = list.iterator();
            int i4 = 1;
            while (it.hasNext()) {
                sQLiteStatementG2.p0(i4, (String) it.next());
                i4++;
            }
            int i5 = i3 + 1;
            Iterator it2 = list2.iterator();
            while (it2.hasNext()) {
                sQLiteStatementG2.p0(i5, (String) it2.next());
                i5++;
            }
            int iD = SQLiteStatementUtil.d(sQLiteStatementG2, "id");
            int iD2 = SQLiteStatementUtil.d(sQLiteStatementG2, "title");
            int iD3 = SQLiteStatementUtil.d(sQLiteStatementG2, "typeCombinations");
            int iD4 = SQLiteStatementUtil.d(sQLiteStatementG2, "onConditions");
            int iD5 = SQLiteStatementUtil.d(sQLiteStatementG2, "operator");
            int iD6 = SQLiteStatementUtil.d(sQLiteStatementG2, "dayFlags");
            int iD7 = SQLiteStatementUtil.d(sQLiteStatementG2, "blockNotifications");
            int iD8 = SQLiteStatementUtil.d(sQLiteStatementG2, "blockLaunch");
            int iD9 = SQLiteStatementUtil.d(sQLiteStatementG2, "addNewApplications");
            int iD10 = SQLiteStatementUtil.d(sQLiteStatementG2, "isEnabled");
            int iD11 = SQLiteStatementUtil.d(sQLiteStatementG2, "isLocked");
            int iD12 = SQLiteStatementUtil.d(sQLiteStatementG2, "lastStartTime");
            int iD13 = SQLiteStatementUtil.d(sQLiteStatementG2, "onUntil");
            int iD14 = SQLiteStatementUtil.d(sQLiteStatementG2, "lockedUntil");
            int iD15 = SQLiteStatementUtil.d(sQLiteStatementG2, "lockAt");
            int iD16 = SQLiteStatementUtil.d(sQLiteStatementG2, "pausedUntil");
            int iD17 = SQLiteStatementUtil.d(sQLiteStatementG2, "blockingMode");
            int iD18 = SQLiteStatementUtil.d(sQLiteStatementG2, "emoji");
            int iD19 = SQLiteStatementUtil.d(sQLiteStatementG2, "blockUnsupportedBrowsers");
            int iD20 = SQLiteStatementUtil.d(sQLiteStatementG2, "blockAdultContent");
            int iD21 = SQLiteStatementUtil.d(sQLiteStatementG2, "blockInAppPurchases");
            int iD22 = SQLiteStatementUtil.d(sQLiteStatementG2, "selectedCategories");
            int iD23 = SQLiteStatementUtil.d(sQLiteStatementG2, "webBrowsingMode");
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementG2.B2()) {
                long j3 = sQLiteStatementG2.getLong(iD);
                String strF2 = sQLiteStatementG2.f2(iD2);
                int i6 = iD;
                int i7 = iD14;
                int i8 = (int) sQLiteStatementG2.getLong(iD3);
                int i9 = (int) sQLiteStatementG2.getLong(iD4);
                int i10 = (int) sQLiteStatementG2.getLong(iD5);
                int i11 = (int) sQLiteStatementG2.getLong(iD6);
                boolean z2 = ((int) sQLiteStatementG2.getLong(iD7)) != 0;
                int i12 = iD2;
                boolean z3 = ((int) sQLiteStatementG2.getLong(iD8)) != 0;
                boolean z4 = ((int) sQLiteStatementG2.getLong(iD9)) != 0;
                boolean z5 = ((int) sQLiteStatementG2.getLong(iD10)) != 0;
                boolean z6 = ((int) sQLiteStatementG2.getLong(iD11)) != 0;
                long j4 = sQLiteStatementG2.getLong(iD12);
                long j5 = sQLiteStatementG2.getLong(iD13);
                long j6 = sQLiteStatementG2.getLong(i7);
                int i13 = iD15;
                long j7 = sQLiteStatementG2.getLong(i13);
                int i14 = iD16;
                int i15 = iD3;
                Profile.PausedUntil pausedUntilA = profileDao_Impl.f125116c.a(sQLiteStatementG2.getLong(i14));
                int i16 = iD17;
                Profile.BlockingMode blockingModeA = profileDao_Impl.f125117d.a((int) sQLiteStatementG2.getLong(i16));
                int i17 = iD18;
                int i18 = iD4;
                ScheduleEmoji scheduleEmojiA = profileDao_Impl.f125118f.a((int) sQLiteStatementG2.getLong(i17));
                if (scheduleEmojiA == null) {
                    throw new IllegalStateException("Expected NON-NULL 'cz.mobilesoft.coreblock.enums.ScheduleEmoji', but it was NULL.");
                }
                iD18 = i17;
                int i19 = iD19;
                boolean z7 = ((int) sQLiteStatementG2.getLong(i19)) != 0;
                iD19 = i19;
                int i20 = iD20;
                boolean z8 = ((int) sQLiteStatementG2.getLong(i20)) != 0;
                int i21 = iD21;
                boolean z9 = ((int) sQLiteStatementG2.getLong(i21)) != 0;
                iD21 = i21;
                int i22 = iD22;
                iD22 = i22;
                int i23 = iD23;
                arrayList.add(new Profile(j3, strF2, i8, i9, i10, i11, z2, z3, z4, z5, z6, j4, j5, j6, j7, pausedUntilA, blockingModeA, scheduleEmojiA, z7, z8, z9, (int) sQLiteStatementG2.getLong(i22), profileDao_Impl.f125119g.a((int) sQLiteStatementG2.getLong(i23))));
                iD4 = i18;
                iD17 = i16;
                iD20 = i20;
                iD = i6;
                iD14 = i7;
                iD3 = i15;
                iD23 = i23;
                iD2 = i12;
                iD15 = i13;
                iD16 = i14;
            }
            sQLiteStatementG2.close();
            return arrayList;
        } catch (Throwable th) {
            sQLiteStatementG2.close();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List q3(String str, RoomRawQuery roomRawQuery, ProfileDao_Impl profileDao_Impl, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        try {
            roomRawQuery.e().invoke(sQLiteStatementG2);
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementG2.B2()) {
                arrayList.add(profileDao_Impl.r2(sQLiteStatementG2));
            }
            return arrayList;
        } finally {
            sQLiteStatementG2.close();
        }
    }

    private final Profile r2(SQLiteStatement sQLiteStatement) {
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        boolean z9;
        int iC = SQLiteStatementUtil.c(sQLiteStatement, "id");
        int iC2 = SQLiteStatementUtil.c(sQLiteStatement, "title");
        int iC3 = SQLiteStatementUtil.c(sQLiteStatement, "typeCombinations");
        int iC4 = SQLiteStatementUtil.c(sQLiteStatement, "onConditions");
        int iC5 = SQLiteStatementUtil.c(sQLiteStatement, "operator");
        int iC6 = SQLiteStatementUtil.c(sQLiteStatement, "dayFlags");
        int iC7 = SQLiteStatementUtil.c(sQLiteStatement, "blockNotifications");
        int iC8 = SQLiteStatementUtil.c(sQLiteStatement, "blockLaunch");
        int iC9 = SQLiteStatementUtil.c(sQLiteStatement, "addNewApplications");
        int iC10 = SQLiteStatementUtil.c(sQLiteStatement, "isEnabled");
        int iC11 = SQLiteStatementUtil.c(sQLiteStatement, "isLocked");
        int iC12 = SQLiteStatementUtil.c(sQLiteStatement, "lastStartTime");
        int iC13 = SQLiteStatementUtil.c(sQLiteStatement, "onUntil");
        int iC14 = SQLiteStatementUtil.c(sQLiteStatement, "lockedUntil");
        int iC15 = SQLiteStatementUtil.c(sQLiteStatement, "lockAt");
        int iC16 = SQLiteStatementUtil.c(sQLiteStatement, "pausedUntil");
        int iC17 = SQLiteStatementUtil.c(sQLiteStatement, "blockingMode");
        int iC18 = SQLiteStatementUtil.c(sQLiteStatement, "emoji");
        int iC19 = SQLiteStatementUtil.c(sQLiteStatement, "blockUnsupportedBrowsers");
        int iC20 = SQLiteStatementUtil.c(sQLiteStatement, "blockAdultContent");
        int iC21 = SQLiteStatementUtil.c(sQLiteStatement, "blockInAppPurchases");
        int iC22 = SQLiteStatementUtil.c(sQLiteStatement, "selectedCategories");
        int iC23 = SQLiteStatementUtil.c(sQLiteStatement, "webBrowsingMode");
        long j3 = iC == -1 ? 0L : sQLiteStatement.getLong(iC);
        if (iC2 == -1) {
            throw new IllegalStateException("Missing column 'title' for a NON-NULL value, column not found in result.");
        }
        String strF2 = sQLiteStatement.f2(iC2);
        int i3 = iC3 == -1 ? 0 : (int) sQLiteStatement.getLong(iC3);
        int i4 = iC4 == -1 ? 0 : (int) sQLiteStatement.getLong(iC4);
        int i5 = iC5 == -1 ? 0 : (int) sQLiteStatement.getLong(iC5);
        int i6 = iC6 == -1 ? 0 : (int) sQLiteStatement.getLong(iC6);
        if (iC7 == -1) {
            z2 = false;
        } else {
            z2 = ((int) sQLiteStatement.getLong(iC7)) != 0;
        }
        if (iC8 == -1) {
            z3 = false;
        } else {
            z3 = ((int) sQLiteStatement.getLong(iC8)) != 0;
        }
        if (iC9 == -1) {
            z4 = false;
        } else {
            z4 = ((int) sQLiteStatement.getLong(iC9)) != 0;
        }
        if (iC10 == -1) {
            z5 = false;
        } else {
            z5 = ((int) sQLiteStatement.getLong(iC10)) != 0;
        }
        if (iC11 == -1) {
            z6 = false;
        } else {
            z6 = ((int) sQLiteStatement.getLong(iC11)) != 0;
        }
        long j4 = iC12 == -1 ? 0L : sQLiteStatement.getLong(iC12);
        long j5 = iC13 == -1 ? 0L : sQLiteStatement.getLong(iC13);
        long j6 = iC14 == -1 ? 0L : sQLiteStatement.getLong(iC14);
        long j7 = iC15 != -1 ? sQLiteStatement.getLong(iC15) : 0L;
        if (iC16 == -1) {
            throw new IllegalStateException("Missing column 'pausedUntil' for a NON-NULL value, column not found in result.");
        }
        Profile.PausedUntil pausedUntilA = this.f125116c.a(sQLiteStatement.getLong(iC16));
        if (iC17 == -1) {
            throw new IllegalStateException("Missing column 'blockingMode' for a NON-NULL value, column not found in result.");
        }
        Profile.BlockingMode blockingModeA = this.f125117d.a((int) sQLiteStatement.getLong(iC17));
        if (iC18 == -1) {
            throw new IllegalStateException("Missing column 'emoji' for a NON-NULL value, column not found in result.");
        }
        ScheduleEmoji scheduleEmojiA = this.f125118f.a((int) sQLiteStatement.getLong(iC18));
        if (scheduleEmojiA == null) {
            throw new IllegalStateException("Expected NON-NULL 'cz.mobilesoft.coreblock.enums.ScheduleEmoji', but it was NULL.");
        }
        if (iC19 == -1) {
            z7 = false;
        } else {
            z7 = ((int) sQLiteStatement.getLong(iC19)) != 0;
        }
        if (iC20 == -1) {
            z8 = false;
        } else {
            z8 = ((int) sQLiteStatement.getLong(iC20)) != 0;
        }
        if (iC21 == -1) {
            z9 = false;
        } else {
            z9 = ((int) sQLiteStatement.getLong(iC21)) != 0;
        }
        int i7 = iC22 != -1 ? (int) sQLiteStatement.getLong(iC22) : 0;
        if (iC23 != -1) {
            return new Profile(j3, strF2, i3, i4, i5, i6, z2, z3, z4, z5, z6, j4, j5, j6, j7, pausedUntilA, blockingModeA, scheduleEmojiA, z7, z8, z9, i7, this.f125119g.a((int) sQLiteStatement.getLong(iC23)));
        }
        throw new IllegalStateException("Missing column 'webBrowsingMode' for a NON-NULL value, column not found in result.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List r3(String str, RoomRawQuery roomRawQuery, ProfileDao_Impl profileDao_Impl, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        try {
            roomRawQuery.e().invoke(sQLiteStatementG2);
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementG2.B2()) {
                arrayList.add(profileDao_Impl.r2(sQLiteStatementG2));
            }
            return arrayList;
        } finally {
            sQLiteStatementG2.close();
        }
    }

    private final void s2(final SQLiteConnection sQLiteConnection, LongSparseArray longSparseArray) {
        if (longSparseArray.j()) {
            return;
        }
        if (longSparseArray.r() > 999) {
            RelationUtil.b(longSparseArray, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.e4
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return ProfileDao_Impl.t2(this.f125411a, sQLiteConnection, (LongSparseArray) obj);
                }
            });
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT `Application`.`packageName` AS `packageName`,`Application`.`label` AS `label`,`Application`.`labelForSearch` AS `labelForSearch`,`Application`.`isUninstalled` AS `isUninstalled`,`Application`.`appCategories` AS `appCategories`,_junction.`profileId` FROM `ApplicationProfileRelation` AS _junction INNER JOIN `Application` ON (_junction.`packageName` = `Application`.`packageName`) WHERE _junction.`profileId` IN (");
        StringUtil.a(sb, longSparseArray.r());
        sb.append(")");
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        SQLiteStatement sQLiteStatementG2 = sQLiteConnection.G2(string);
        int iR = longSparseArray.r();
        int i3 = 1;
        for (int i4 = 0; i4 < iR; i4++) {
            sQLiteStatementG2.A(i3, longSparseArray.k(i4));
            i3++;
        }
        try {
            ArrayMap arrayMap = new ArrayMap();
            while (sQLiteStatementG2.B2()) {
                arrayMap.put(sQLiteStatementG2.f2(0), null);
            }
            sQLiteStatementG2.reset();
            w2(sQLiteConnection, arrayMap);
            while (sQLiteStatementG2.B2()) {
                List list = (List) longSparseArray.g(sQLiteStatementG2.getLong(5));
                if (list != null) {
                    Application application = new Application(sQLiteStatementG2.f2(0), sQLiteStatementG2.f2(1), sQLiteStatementG2.f2(2), ((int) sQLiteStatementG2.getLong(3)) != 0, sQLiteStatementG2.isNull(4) ? null : Integer.valueOf((int) sQLiteStatementG2.getLong(4)));
                    ApplicationProfileRelation applicationProfileRelation = (ApplicationProfileRelation) arrayMap.get(sQLiteStatementG2.f2(0));
                    if (applicationProfileRelation == null) {
                        throw new IllegalStateException("Relationship item 'applicationProfileRelation' was expected to be NON-NULL but is NULL in @Relation involving a parent column named 'packageName' and entityColumn named 'packageName'.");
                    }
                    list.add(new ProfileWithBlockedItems.ApplicationProfileRelationWithApplication(application, applicationProfileRelation));
                }
            }
            sQLiteStatementG2.close();
        } catch (Throwable th) {
            sQLiteStatementG2.close();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List s3(String str, int i3, ProfileDao_Impl profileDao_Impl, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        try {
            sQLiteStatementG2.A(1, i3);
            int iD = SQLiteStatementUtil.d(sQLiteStatementG2, "id");
            int iD2 = SQLiteStatementUtil.d(sQLiteStatementG2, "title");
            int iD3 = SQLiteStatementUtil.d(sQLiteStatementG2, "typeCombinations");
            int iD4 = SQLiteStatementUtil.d(sQLiteStatementG2, "onConditions");
            int iD5 = SQLiteStatementUtil.d(sQLiteStatementG2, "operator");
            int iD6 = SQLiteStatementUtil.d(sQLiteStatementG2, "dayFlags");
            int iD7 = SQLiteStatementUtil.d(sQLiteStatementG2, "blockNotifications");
            int iD8 = SQLiteStatementUtil.d(sQLiteStatementG2, "blockLaunch");
            int iD9 = SQLiteStatementUtil.d(sQLiteStatementG2, "addNewApplications");
            int iD10 = SQLiteStatementUtil.d(sQLiteStatementG2, "isEnabled");
            int iD11 = SQLiteStatementUtil.d(sQLiteStatementG2, "isLocked");
            int iD12 = SQLiteStatementUtil.d(sQLiteStatementG2, "lastStartTime");
            int iD13 = SQLiteStatementUtil.d(sQLiteStatementG2, "onUntil");
            int iD14 = SQLiteStatementUtil.d(sQLiteStatementG2, "lockedUntil");
            int iD15 = SQLiteStatementUtil.d(sQLiteStatementG2, "lockAt");
            int iD16 = SQLiteStatementUtil.d(sQLiteStatementG2, "pausedUntil");
            int iD17 = SQLiteStatementUtil.d(sQLiteStatementG2, "blockingMode");
            int iD18 = SQLiteStatementUtil.d(sQLiteStatementG2, "emoji");
            int iD19 = SQLiteStatementUtil.d(sQLiteStatementG2, "blockUnsupportedBrowsers");
            int iD20 = SQLiteStatementUtil.d(sQLiteStatementG2, "blockAdultContent");
            int iD21 = SQLiteStatementUtil.d(sQLiteStatementG2, "blockInAppPurchases");
            int iD22 = SQLiteStatementUtil.d(sQLiteStatementG2, "selectedCategories");
            int iD23 = SQLiteStatementUtil.d(sQLiteStatementG2, "webBrowsingMode");
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementG2.B2()) {
                long j3 = sQLiteStatementG2.getLong(iD);
                String strF2 = sQLiteStatementG2.f2(iD2);
                int i4 = iD;
                int i5 = iD2;
                int i6 = (int) sQLiteStatementG2.getLong(iD3);
                int i7 = (int) sQLiteStatementG2.getLong(iD4);
                int i8 = (int) sQLiteStatementG2.getLong(iD5);
                int i9 = (int) sQLiteStatementG2.getLong(iD6);
                boolean z2 = ((int) sQLiteStatementG2.getLong(iD7)) != 0;
                int i10 = iD14;
                boolean z3 = ((int) sQLiteStatementG2.getLong(iD8)) != 0;
                boolean z4 = ((int) sQLiteStatementG2.getLong(iD9)) != 0;
                boolean z5 = ((int) sQLiteStatementG2.getLong(iD10)) != 0;
                boolean z6 = ((int) sQLiteStatementG2.getLong(iD11)) != 0;
                long j4 = sQLiteStatementG2.getLong(iD12);
                long j5 = sQLiteStatementG2.getLong(iD13);
                long j6 = sQLiteStatementG2.getLong(i10);
                int i11 = iD15;
                long j7 = sQLiteStatementG2.getLong(i11);
                int i12 = iD16;
                int i13 = iD3;
                Profile.PausedUntil pausedUntilA = profileDao_Impl.f125116c.a(sQLiteStatementG2.getLong(i12));
                int i14 = iD4;
                int i15 = iD17;
                Profile.BlockingMode blockingModeA = profileDao_Impl.f125117d.a((int) sQLiteStatementG2.getLong(i15));
                iD17 = i15;
                int i16 = iD18;
                ScheduleEmoji scheduleEmojiA = profileDao_Impl.f125118f.a((int) sQLiteStatementG2.getLong(i16));
                if (scheduleEmojiA == null) {
                    throw new IllegalStateException("Expected NON-NULL 'cz.mobilesoft.coreblock.enums.ScheduleEmoji', but it was NULL.");
                }
                iD18 = i16;
                int i17 = iD19;
                boolean z7 = ((int) sQLiteStatementG2.getLong(i17)) != 0;
                iD19 = i17;
                int i18 = iD20;
                boolean z8 = ((int) sQLiteStatementG2.getLong(i18)) != 0;
                iD20 = i18;
                int i19 = iD21;
                iD21 = i19;
                int i20 = iD22;
                iD22 = i20;
                int i21 = iD23;
                arrayList.add(new Profile(j3, strF2, i6, i7, i8, i9, z2, z3, z4, z5, z6, j4, j5, j6, j7, pausedUntilA, blockingModeA, scheduleEmojiA, z7, z8, ((int) sQLiteStatementG2.getLong(i19)) != 0, (int) sQLiteStatementG2.getLong(i20), profileDao_Impl.f125119g.a((int) sQLiteStatementG2.getLong(i21))));
                iD14 = i10;
                iD15 = i11;
                iD4 = i14;
                iD = i4;
                iD16 = i12;
                iD3 = i13;
                iD23 = i21;
                iD2 = i5;
            }
            sQLiteStatementG2.close();
            return arrayList;
        } catch (Throwable th) {
            sQLiteStatementG2.close();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit t2(ProfileDao_Impl profileDao_Impl, SQLiteConnection sQLiteConnection, LongSparseArray _tmpMap) {
        Intrinsics.checkNotNullParameter(_tmpMap, "_tmpMap");
        profileDao_Impl.s2(sQLiteConnection, _tmpMap);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List t3(String str, long j3, int i3, ProfileDao_Impl profileDao_Impl, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        try {
            sQLiteStatementG2.A(1, j3);
            sQLiteStatementG2.A(2, i3);
            int iD = SQLiteStatementUtil.d(sQLiteStatementG2, "id");
            int iD2 = SQLiteStatementUtil.d(sQLiteStatementG2, "title");
            int iD3 = SQLiteStatementUtil.d(sQLiteStatementG2, "typeCombinations");
            int iD4 = SQLiteStatementUtil.d(sQLiteStatementG2, "onConditions");
            int iD5 = SQLiteStatementUtil.d(sQLiteStatementG2, "operator");
            int iD6 = SQLiteStatementUtil.d(sQLiteStatementG2, "dayFlags");
            int iD7 = SQLiteStatementUtil.d(sQLiteStatementG2, "blockNotifications");
            int iD8 = SQLiteStatementUtil.d(sQLiteStatementG2, "blockLaunch");
            int iD9 = SQLiteStatementUtil.d(sQLiteStatementG2, "addNewApplications");
            int iD10 = SQLiteStatementUtil.d(sQLiteStatementG2, "isEnabled");
            int iD11 = SQLiteStatementUtil.d(sQLiteStatementG2, "isLocked");
            int iD12 = SQLiteStatementUtil.d(sQLiteStatementG2, "lastStartTime");
            int iD13 = SQLiteStatementUtil.d(sQLiteStatementG2, "onUntil");
            int iD14 = SQLiteStatementUtil.d(sQLiteStatementG2, "lockedUntil");
            int iD15 = SQLiteStatementUtil.d(sQLiteStatementG2, "lockAt");
            int iD16 = SQLiteStatementUtil.d(sQLiteStatementG2, "pausedUntil");
            int iD17 = SQLiteStatementUtil.d(sQLiteStatementG2, "blockingMode");
            int iD18 = SQLiteStatementUtil.d(sQLiteStatementG2, "emoji");
            int iD19 = SQLiteStatementUtil.d(sQLiteStatementG2, "blockUnsupportedBrowsers");
            int iD20 = SQLiteStatementUtil.d(sQLiteStatementG2, "blockAdultContent");
            int iD21 = SQLiteStatementUtil.d(sQLiteStatementG2, "blockInAppPurchases");
            int iD22 = SQLiteStatementUtil.d(sQLiteStatementG2, "selectedCategories");
            int iD23 = SQLiteStatementUtil.d(sQLiteStatementG2, "webBrowsingMode");
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementG2.B2()) {
                long j4 = sQLiteStatementG2.getLong(iD);
                String strF2 = sQLiteStatementG2.f2(iD2);
                int i4 = iD;
                int i5 = iD2;
                int i6 = (int) sQLiteStatementG2.getLong(iD3);
                int i7 = (int) sQLiteStatementG2.getLong(iD4);
                int i8 = (int) sQLiteStatementG2.getLong(iD5);
                int i9 = (int) sQLiteStatementG2.getLong(iD6);
                boolean z2 = ((int) sQLiteStatementG2.getLong(iD7)) != 0;
                int i10 = iD3;
                boolean z3 = ((int) sQLiteStatementG2.getLong(iD8)) != 0;
                boolean z4 = ((int) sQLiteStatementG2.getLong(iD9)) != 0;
                boolean z5 = ((int) sQLiteStatementG2.getLong(iD10)) != 0;
                boolean z6 = ((int) sQLiteStatementG2.getLong(iD11)) != 0;
                long j5 = sQLiteStatementG2.getLong(iD12);
                long j6 = sQLiteStatementG2.getLong(iD13);
                long j7 = sQLiteStatementG2.getLong(iD14);
                int i11 = iD15;
                long j8 = sQLiteStatementG2.getLong(i11);
                int i12 = iD16;
                int i13 = iD14;
                Profile.PausedUntil pausedUntilA = profileDao_Impl.f125116c.a(sQLiteStatementG2.getLong(i12));
                int i14 = iD17;
                int i15 = iD4;
                Profile.BlockingMode blockingModeA = profileDao_Impl.f125117d.a((int) sQLiteStatementG2.getLong(i14));
                int i16 = iD18;
                ScheduleEmoji scheduleEmojiA = profileDao_Impl.f125118f.a((int) sQLiteStatementG2.getLong(i16));
                if (scheduleEmojiA == null) {
                    throw new IllegalStateException("Expected NON-NULL 'cz.mobilesoft.coreblock.enums.ScheduleEmoji', but it was NULL.");
                }
                iD18 = i16;
                int i17 = iD19;
                boolean z7 = ((int) sQLiteStatementG2.getLong(i17)) != 0;
                iD19 = i17;
                int i18 = iD20;
                boolean z8 = ((int) sQLiteStatementG2.getLong(i18)) != 0;
                iD20 = i18;
                int i19 = iD21;
                iD21 = i19;
                int i20 = iD22;
                iD22 = i20;
                int i21 = iD23;
                arrayList.add(new Profile(j4, strF2, i6, i7, i8, i9, z2, z3, z4, z5, z6, j5, j6, j7, j8, pausedUntilA, blockingModeA, scheduleEmojiA, z7, z8, ((int) sQLiteStatementG2.getLong(i19)) != 0, (int) sQLiteStatementG2.getLong(i20), profileDao_Impl.f125119g.a((int) sQLiteStatementG2.getLong(i21))));
                iD4 = i15;
                iD17 = i14;
                iD23 = i21;
                iD14 = i13;
                iD3 = i10;
                iD = i4;
                iD2 = i5;
                iD15 = i11;
                iD16 = i12;
            }
            sQLiteStatementG2.close();
            return arrayList;
        } catch (Throwable th) {
            sQLiteStatementG2.close();
            throw th;
        }
    }

    private final void u2(final SQLiteConnection sQLiteConnection, LongSparseArray longSparseArray) {
        if (longSparseArray.j()) {
            return;
        }
        if (longSparseArray.r() > 999) {
            RelationUtil.b(longSparseArray, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.c4
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return ProfileDao_Impl.v2(this.f125375a, sQLiteConnection, (LongSparseArray) obj);
                }
            });
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT `id`,`packageName`,`profileId`,`isEnabled`,`flags` FROM `ApplicationProfileRelation` WHERE `profileId` IN (");
        StringUtil.a(sb, longSparseArray.r());
        sb.append(")");
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        SQLiteStatement sQLiteStatementG2 = sQLiteConnection.G2(string);
        int iR = longSparseArray.r();
        int i3 = 1;
        for (int i4 = 0; i4 < iR; i4++) {
            sQLiteStatementG2.A(i3, longSparseArray.k(i4));
            i3++;
        }
        try {
            int iC = SQLiteStatementUtil.c(sQLiteStatementG2, "profileId");
            if (iC == -1) {
                sQLiteStatementG2.close();
                return;
            }
            while (sQLiteStatementG2.B2()) {
                List list = (List) longSparseArray.g(sQLiteStatementG2.getLong(iC));
                if (list != null) {
                    list.add(new ApplicationProfileRelation(sQLiteStatementG2.getLong(0), sQLiteStatementG2.f2(1), sQLiteStatementG2.getLong(2), ((int) sQLiteStatementG2.getLong(3)) != 0, (int) sQLiteStatementG2.getLong(4)));
                }
            }
        } finally {
            sQLiteStatementG2.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List u3(String str, long j3, ProfileDao_Impl profileDao_Impl, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        try {
            sQLiteStatementG2.A(1, j3);
            int iD = SQLiteStatementUtil.d(sQLiteStatementG2, "id");
            int iD2 = SQLiteStatementUtil.d(sQLiteStatementG2, "title");
            int iD3 = SQLiteStatementUtil.d(sQLiteStatementG2, "typeCombinations");
            int iD4 = SQLiteStatementUtil.d(sQLiteStatementG2, "onConditions");
            int iD5 = SQLiteStatementUtil.d(sQLiteStatementG2, "operator");
            int iD6 = SQLiteStatementUtil.d(sQLiteStatementG2, "dayFlags");
            int iD7 = SQLiteStatementUtil.d(sQLiteStatementG2, "blockNotifications");
            int iD8 = SQLiteStatementUtil.d(sQLiteStatementG2, "blockLaunch");
            int iD9 = SQLiteStatementUtil.d(sQLiteStatementG2, "addNewApplications");
            int iD10 = SQLiteStatementUtil.d(sQLiteStatementG2, "isEnabled");
            int iD11 = SQLiteStatementUtil.d(sQLiteStatementG2, "isLocked");
            int iD12 = SQLiteStatementUtil.d(sQLiteStatementG2, "lastStartTime");
            int iD13 = SQLiteStatementUtil.d(sQLiteStatementG2, "onUntil");
            int iD14 = SQLiteStatementUtil.d(sQLiteStatementG2, "lockedUntil");
            int iD15 = SQLiteStatementUtil.d(sQLiteStatementG2, "lockAt");
            int iD16 = SQLiteStatementUtil.d(sQLiteStatementG2, "pausedUntil");
            int iD17 = SQLiteStatementUtil.d(sQLiteStatementG2, "blockingMode");
            int iD18 = SQLiteStatementUtil.d(sQLiteStatementG2, "emoji");
            int iD19 = SQLiteStatementUtil.d(sQLiteStatementG2, "blockUnsupportedBrowsers");
            int iD20 = SQLiteStatementUtil.d(sQLiteStatementG2, "blockAdultContent");
            int iD21 = SQLiteStatementUtil.d(sQLiteStatementG2, "blockInAppPurchases");
            int iD22 = SQLiteStatementUtil.d(sQLiteStatementG2, "selectedCategories");
            int iD23 = SQLiteStatementUtil.d(sQLiteStatementG2, "webBrowsingMode");
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementG2.B2()) {
                long j4 = sQLiteStatementG2.getLong(iD);
                String strF2 = sQLiteStatementG2.f2(iD2);
                int i3 = iD;
                int i4 = iD2;
                int i5 = (int) sQLiteStatementG2.getLong(iD3);
                int i6 = (int) sQLiteStatementG2.getLong(iD4);
                int i7 = (int) sQLiteStatementG2.getLong(iD5);
                int i8 = (int) sQLiteStatementG2.getLong(iD6);
                boolean z2 = ((int) sQLiteStatementG2.getLong(iD7)) != 0;
                int i9 = iD3;
                boolean z3 = ((int) sQLiteStatementG2.getLong(iD8)) != 0;
                boolean z4 = ((int) sQLiteStatementG2.getLong(iD9)) != 0;
                boolean z5 = ((int) sQLiteStatementG2.getLong(iD10)) != 0;
                boolean z6 = ((int) sQLiteStatementG2.getLong(iD11)) != 0;
                long j5 = sQLiteStatementG2.getLong(iD12);
                long j6 = sQLiteStatementG2.getLong(iD13);
                long j7 = sQLiteStatementG2.getLong(iD14);
                int i10 = iD15;
                long j8 = sQLiteStatementG2.getLong(i10);
                int i11 = iD16;
                int i12 = iD14;
                Profile.PausedUntil pausedUntilA = profileDao_Impl.f125116c.a(sQLiteStatementG2.getLong(i11));
                int i13 = iD17;
                int i14 = iD4;
                Profile.BlockingMode blockingModeA = profileDao_Impl.f125117d.a((int) sQLiteStatementG2.getLong(i13));
                int i15 = iD18;
                ScheduleEmoji scheduleEmojiA = profileDao_Impl.f125118f.a((int) sQLiteStatementG2.getLong(i15));
                if (scheduleEmojiA == null) {
                    throw new IllegalStateException("Expected NON-NULL 'cz.mobilesoft.coreblock.enums.ScheduleEmoji', but it was NULL.");
                }
                iD18 = i15;
                int i16 = iD19;
                boolean z7 = ((int) sQLiteStatementG2.getLong(i16)) != 0;
                iD19 = i16;
                int i17 = iD20;
                boolean z8 = ((int) sQLiteStatementG2.getLong(i17)) != 0;
                iD20 = i17;
                int i18 = iD21;
                iD21 = i18;
                int i19 = iD22;
                iD22 = i19;
                int i20 = iD23;
                arrayList.add(new Profile(j4, strF2, i5, i6, i7, i8, z2, z3, z4, z5, z6, j5, j6, j7, j8, pausedUntilA, blockingModeA, scheduleEmojiA, z7, z8, ((int) sQLiteStatementG2.getLong(i18)) != 0, (int) sQLiteStatementG2.getLong(i19), profileDao_Impl.f125119g.a((int) sQLiteStatementG2.getLong(i20))));
                iD4 = i14;
                iD17 = i13;
                iD23 = i20;
                iD14 = i12;
                iD3 = i9;
                iD = i3;
                iD2 = i4;
                iD15 = i10;
                iD16 = i11;
            }
            sQLiteStatementG2.close();
            return arrayList;
        } catch (Throwable th) {
            sQLiteStatementG2.close();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit v2(ProfileDao_Impl profileDao_Impl, SQLiteConnection sQLiteConnection, LongSparseArray _tmpMap) {
        Intrinsics.checkNotNullParameter(_tmpMap, "_tmpMap");
        profileDao_Impl.u2(sQLiteConnection, _tmpMap);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List v3(String str, ProfileDao_Impl profileDao_Impl, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        try {
            int iD = SQLiteStatementUtil.d(sQLiteStatementG2, "id");
            int iD2 = SQLiteStatementUtil.d(sQLiteStatementG2, "title");
            int iD3 = SQLiteStatementUtil.d(sQLiteStatementG2, "typeCombinations");
            int iD4 = SQLiteStatementUtil.d(sQLiteStatementG2, "onConditions");
            int iD5 = SQLiteStatementUtil.d(sQLiteStatementG2, "operator");
            int iD6 = SQLiteStatementUtil.d(sQLiteStatementG2, "dayFlags");
            int iD7 = SQLiteStatementUtil.d(sQLiteStatementG2, "blockNotifications");
            int iD8 = SQLiteStatementUtil.d(sQLiteStatementG2, "blockLaunch");
            int iD9 = SQLiteStatementUtil.d(sQLiteStatementG2, "addNewApplications");
            int iD10 = SQLiteStatementUtil.d(sQLiteStatementG2, "isEnabled");
            int iD11 = SQLiteStatementUtil.d(sQLiteStatementG2, "isLocked");
            int iD12 = SQLiteStatementUtil.d(sQLiteStatementG2, "lastStartTime");
            int iD13 = SQLiteStatementUtil.d(sQLiteStatementG2, "onUntil");
            int iD14 = SQLiteStatementUtil.d(sQLiteStatementG2, "lockedUntil");
            int iD15 = SQLiteStatementUtil.d(sQLiteStatementG2, "lockAt");
            int iD16 = SQLiteStatementUtil.d(sQLiteStatementG2, "pausedUntil");
            int iD17 = SQLiteStatementUtil.d(sQLiteStatementG2, "blockingMode");
            int iD18 = SQLiteStatementUtil.d(sQLiteStatementG2, "emoji");
            int iD19 = SQLiteStatementUtil.d(sQLiteStatementG2, "blockUnsupportedBrowsers");
            int iD20 = SQLiteStatementUtil.d(sQLiteStatementG2, "blockAdultContent");
            int iD21 = SQLiteStatementUtil.d(sQLiteStatementG2, "blockInAppPurchases");
            int iD22 = SQLiteStatementUtil.d(sQLiteStatementG2, "selectedCategories");
            int iD23 = SQLiteStatementUtil.d(sQLiteStatementG2, "webBrowsingMode");
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementG2.B2()) {
                long j3 = sQLiteStatementG2.getLong(iD);
                String strF2 = sQLiteStatementG2.f2(iD2);
                int i3 = iD;
                int i4 = iD2;
                int i5 = (int) sQLiteStatementG2.getLong(iD3);
                int i6 = (int) sQLiteStatementG2.getLong(iD4);
                int i7 = (int) sQLiteStatementG2.getLong(iD5);
                int i8 = (int) sQLiteStatementG2.getLong(iD6);
                boolean z2 = ((int) sQLiteStatementG2.getLong(iD7)) != 0;
                int i9 = iD3;
                boolean z3 = ((int) sQLiteStatementG2.getLong(iD8)) != 0;
                boolean z4 = ((int) sQLiteStatementG2.getLong(iD9)) != 0;
                boolean z5 = ((int) sQLiteStatementG2.getLong(iD10)) != 0;
                boolean z6 = ((int) sQLiteStatementG2.getLong(iD11)) != 0;
                long j4 = sQLiteStatementG2.getLong(iD12);
                long j5 = sQLiteStatementG2.getLong(iD13);
                long j6 = sQLiteStatementG2.getLong(iD14);
                int i10 = iD15;
                long j7 = sQLiteStatementG2.getLong(i10);
                int i11 = iD16;
                int i12 = iD4;
                Profile.PausedUntil pausedUntilA = profileDao_Impl.f125116c.a(sQLiteStatementG2.getLong(i11));
                int i13 = iD17;
                Profile.BlockingMode blockingModeA = profileDao_Impl.f125117d.a((int) sQLiteStatementG2.getLong(i13));
                int i14 = iD5;
                int i15 = iD18;
                ScheduleEmoji scheduleEmojiA = profileDao_Impl.f125118f.a((int) sQLiteStatementG2.getLong(i15));
                if (scheduleEmojiA == null) {
                    throw new IllegalStateException("Expected NON-NULL 'cz.mobilesoft.coreblock.enums.ScheduleEmoji', but it was NULL.");
                }
                iD18 = i15;
                int i16 = iD19;
                boolean z7 = ((int) sQLiteStatementG2.getLong(i16)) != 0;
                iD19 = i16;
                int i17 = iD20;
                boolean z8 = ((int) sQLiteStatementG2.getLong(i17)) != 0;
                int i18 = iD21;
                boolean z9 = ((int) sQLiteStatementG2.getLong(i18)) != 0;
                iD21 = i18;
                int i19 = iD22;
                iD22 = i19;
                int i20 = iD23;
                arrayList.add(new Profile(j3, strF2, i5, i6, i7, i8, z2, z3, z4, z5, z6, j4, j5, j6, j7, pausedUntilA, blockingModeA, scheduleEmojiA, z7, z8, z9, (int) sQLiteStatementG2.getLong(i19), profileDao_Impl.f125119g.a((int) sQLiteStatementG2.getLong(i20))));
                iD4 = i12;
                iD23 = i20;
                iD5 = i14;
                iD17 = i13;
                iD = i3;
                iD2 = i4;
                iD3 = i9;
                iD16 = i11;
                iD20 = i17;
                iD15 = i10;
            }
            sQLiteStatementG2.close();
            return arrayList;
        } catch (Throwable th) {
            sQLiteStatementG2.close();
            throw th;
        }
    }

    private final void w2(final SQLiteConnection sQLiteConnection, ArrayMap arrayMap) {
        Set setKeySet = arrayMap.keySet();
        if (setKeySet.isEmpty()) {
            return;
        }
        if (arrayMap.size() > 999) {
            RelationUtil.a(arrayMap, false, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.f4
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return ProfileDao_Impl.x2(this.f125430a, sQLiteConnection, (ArrayMap) obj);
                }
            });
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT `id`,`packageName`,`profileId`,`isEnabled`,`flags` FROM `ApplicationProfileRelation` WHERE `packageName` IN (");
        StringUtil.a(sb, setKeySet.size());
        sb.append(")");
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        SQLiteStatement sQLiteStatementG2 = sQLiteConnection.G2(string);
        Iterator it = setKeySet.iterator();
        int i3 = 1;
        while (it.hasNext()) {
            sQLiteStatementG2.p0(i3, (String) it.next());
            i3++;
        }
        try {
            int iC = SQLiteStatementUtil.c(sQLiteStatementG2, "packageName");
            if (iC == -1) {
                sQLiteStatementG2.close();
                return;
            }
            while (sQLiteStatementG2.B2()) {
                String strF2 = sQLiteStatementG2.f2(iC);
                if (arrayMap.containsKey(strF2)) {
                    arrayMap.put(strF2, new ApplicationProfileRelation(sQLiteStatementG2.getLong(0), sQLiteStatementG2.f2(1), sQLiteStatementG2.getLong(2), ((int) sQLiteStatementG2.getLong(3)) != 0, (int) sQLiteStatementG2.getLong(4)));
                }
            }
        } finally {
            sQLiteStatementG2.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List w3(String str, long j3, ProfileDao_Impl profileDao_Impl, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        try {
            sQLiteStatementG2.A(1, j3);
            int iD = SQLiteStatementUtil.d(sQLiteStatementG2, "id");
            int iD2 = SQLiteStatementUtil.d(sQLiteStatementG2, "title");
            int iD3 = SQLiteStatementUtil.d(sQLiteStatementG2, "typeCombinations");
            int iD4 = SQLiteStatementUtil.d(sQLiteStatementG2, "onConditions");
            int iD5 = SQLiteStatementUtil.d(sQLiteStatementG2, "operator");
            int iD6 = SQLiteStatementUtil.d(sQLiteStatementG2, "dayFlags");
            int iD7 = SQLiteStatementUtil.d(sQLiteStatementG2, "blockNotifications");
            int iD8 = SQLiteStatementUtil.d(sQLiteStatementG2, "blockLaunch");
            int iD9 = SQLiteStatementUtil.d(sQLiteStatementG2, "addNewApplications");
            int iD10 = SQLiteStatementUtil.d(sQLiteStatementG2, "isEnabled");
            int iD11 = SQLiteStatementUtil.d(sQLiteStatementG2, "isLocked");
            int iD12 = SQLiteStatementUtil.d(sQLiteStatementG2, "lastStartTime");
            int iD13 = SQLiteStatementUtil.d(sQLiteStatementG2, "onUntil");
            int iD14 = SQLiteStatementUtil.d(sQLiteStatementG2, "lockedUntil");
            int iD15 = SQLiteStatementUtil.d(sQLiteStatementG2, "lockAt");
            int iD16 = SQLiteStatementUtil.d(sQLiteStatementG2, "pausedUntil");
            int iD17 = SQLiteStatementUtil.d(sQLiteStatementG2, "blockingMode");
            int iD18 = SQLiteStatementUtil.d(sQLiteStatementG2, "emoji");
            int iD19 = SQLiteStatementUtil.d(sQLiteStatementG2, "blockUnsupportedBrowsers");
            int iD20 = SQLiteStatementUtil.d(sQLiteStatementG2, "blockAdultContent");
            int iD21 = SQLiteStatementUtil.d(sQLiteStatementG2, "blockInAppPurchases");
            int iD22 = SQLiteStatementUtil.d(sQLiteStatementG2, "selectedCategories");
            int iD23 = SQLiteStatementUtil.d(sQLiteStatementG2, "webBrowsingMode");
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementG2.B2()) {
                long j4 = sQLiteStatementG2.getLong(iD);
                String strF2 = sQLiteStatementG2.f2(iD2);
                int i3 = iD;
                int i4 = iD2;
                int i5 = (int) sQLiteStatementG2.getLong(iD3);
                int i6 = (int) sQLiteStatementG2.getLong(iD4);
                int i7 = (int) sQLiteStatementG2.getLong(iD5);
                int i8 = (int) sQLiteStatementG2.getLong(iD6);
                boolean z2 = ((int) sQLiteStatementG2.getLong(iD7)) != 0;
                int i9 = iD3;
                boolean z3 = ((int) sQLiteStatementG2.getLong(iD8)) != 0;
                boolean z4 = ((int) sQLiteStatementG2.getLong(iD9)) != 0;
                boolean z5 = ((int) sQLiteStatementG2.getLong(iD10)) != 0;
                boolean z6 = ((int) sQLiteStatementG2.getLong(iD11)) != 0;
                long j5 = sQLiteStatementG2.getLong(iD12);
                long j6 = sQLiteStatementG2.getLong(iD13);
                long j7 = sQLiteStatementG2.getLong(iD14);
                int i10 = iD15;
                long j8 = sQLiteStatementG2.getLong(i10);
                int i11 = iD16;
                int i12 = iD14;
                Profile.PausedUntil pausedUntilA = profileDao_Impl.f125116c.a(sQLiteStatementG2.getLong(i11));
                int i13 = iD17;
                int i14 = iD4;
                Profile.BlockingMode blockingModeA = profileDao_Impl.f125117d.a((int) sQLiteStatementG2.getLong(i13));
                int i15 = iD18;
                ScheduleEmoji scheduleEmojiA = profileDao_Impl.f125118f.a((int) sQLiteStatementG2.getLong(i15));
                if (scheduleEmojiA == null) {
                    throw new IllegalStateException("Expected NON-NULL 'cz.mobilesoft.coreblock.enums.ScheduleEmoji', but it was NULL.");
                }
                iD18 = i15;
                int i16 = iD19;
                boolean z7 = ((int) sQLiteStatementG2.getLong(i16)) != 0;
                iD19 = i16;
                int i17 = iD20;
                boolean z8 = ((int) sQLiteStatementG2.getLong(i17)) != 0;
                iD20 = i17;
                int i18 = iD21;
                iD21 = i18;
                int i19 = iD22;
                iD22 = i19;
                int i20 = iD23;
                arrayList.add(new Profile(j4, strF2, i5, i6, i7, i8, z2, z3, z4, z5, z6, j5, j6, j7, j8, pausedUntilA, blockingModeA, scheduleEmojiA, z7, z8, ((int) sQLiteStatementG2.getLong(i18)) != 0, (int) sQLiteStatementG2.getLong(i19), profileDao_Impl.f125119g.a((int) sQLiteStatementG2.getLong(i20))));
                iD4 = i14;
                iD17 = i13;
                iD23 = i20;
                iD14 = i12;
                iD3 = i9;
                iD = i3;
                iD2 = i4;
                iD15 = i10;
                iD16 = i11;
            }
            sQLiteStatementG2.close();
            return arrayList;
        } catch (Throwable th) {
            sQLiteStatementG2.close();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit x2(ProfileDao_Impl profileDao_Impl, SQLiteConnection sQLiteConnection, ArrayMap _tmpMap) {
        Intrinsics.checkNotNullParameter(_tmpMap, "_tmpMap");
        profileDao_Impl.w2(sQLiteConnection, _tmpMap);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List x3(String str, ProfileDao_Impl profileDao_Impl, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        try {
            int iD = SQLiteStatementUtil.d(sQLiteStatementG2, "id");
            int iD2 = SQLiteStatementUtil.d(sQLiteStatementG2, "title");
            int iD3 = SQLiteStatementUtil.d(sQLiteStatementG2, "typeCombinations");
            int iD4 = SQLiteStatementUtil.d(sQLiteStatementG2, "onConditions");
            int iD5 = SQLiteStatementUtil.d(sQLiteStatementG2, "operator");
            int iD6 = SQLiteStatementUtil.d(sQLiteStatementG2, "dayFlags");
            int iD7 = SQLiteStatementUtil.d(sQLiteStatementG2, "blockNotifications");
            int iD8 = SQLiteStatementUtil.d(sQLiteStatementG2, "blockLaunch");
            int iD9 = SQLiteStatementUtil.d(sQLiteStatementG2, "addNewApplications");
            int iD10 = SQLiteStatementUtil.d(sQLiteStatementG2, "isEnabled");
            int iD11 = SQLiteStatementUtil.d(sQLiteStatementG2, "isLocked");
            int iD12 = SQLiteStatementUtil.d(sQLiteStatementG2, "lastStartTime");
            int iD13 = SQLiteStatementUtil.d(sQLiteStatementG2, "onUntil");
            int iD14 = SQLiteStatementUtil.d(sQLiteStatementG2, "lockedUntil");
            int iD15 = SQLiteStatementUtil.d(sQLiteStatementG2, "lockAt");
            int iD16 = SQLiteStatementUtil.d(sQLiteStatementG2, "pausedUntil");
            int iD17 = SQLiteStatementUtil.d(sQLiteStatementG2, "blockingMode");
            int iD18 = SQLiteStatementUtil.d(sQLiteStatementG2, "emoji");
            int iD19 = SQLiteStatementUtil.d(sQLiteStatementG2, "blockUnsupportedBrowsers");
            int iD20 = SQLiteStatementUtil.d(sQLiteStatementG2, "blockAdultContent");
            int iD21 = SQLiteStatementUtil.d(sQLiteStatementG2, "blockInAppPurchases");
            int iD22 = SQLiteStatementUtil.d(sQLiteStatementG2, "selectedCategories");
            int iD23 = SQLiteStatementUtil.d(sQLiteStatementG2, "webBrowsingMode");
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementG2.B2()) {
                long j3 = sQLiteStatementG2.getLong(iD);
                String strF2 = sQLiteStatementG2.f2(iD2);
                int i3 = iD;
                int i4 = iD2;
                int i5 = (int) sQLiteStatementG2.getLong(iD3);
                int i6 = (int) sQLiteStatementG2.getLong(iD4);
                int i7 = (int) sQLiteStatementG2.getLong(iD5);
                int i8 = (int) sQLiteStatementG2.getLong(iD6);
                boolean z2 = ((int) sQLiteStatementG2.getLong(iD7)) != 0;
                int i9 = iD3;
                boolean z3 = ((int) sQLiteStatementG2.getLong(iD8)) != 0;
                boolean z4 = ((int) sQLiteStatementG2.getLong(iD9)) != 0;
                boolean z5 = ((int) sQLiteStatementG2.getLong(iD10)) != 0;
                boolean z6 = ((int) sQLiteStatementG2.getLong(iD11)) != 0;
                long j4 = sQLiteStatementG2.getLong(iD12);
                long j5 = sQLiteStatementG2.getLong(iD13);
                long j6 = sQLiteStatementG2.getLong(iD14);
                int i10 = iD15;
                long j7 = sQLiteStatementG2.getLong(i10);
                int i11 = iD16;
                int i12 = iD4;
                Profile.PausedUntil pausedUntilA = profileDao_Impl.f125116c.a(sQLiteStatementG2.getLong(i11));
                int i13 = iD17;
                Profile.BlockingMode blockingModeA = profileDao_Impl.f125117d.a((int) sQLiteStatementG2.getLong(i13));
                int i14 = iD5;
                int i15 = iD18;
                ScheduleEmoji scheduleEmojiA = profileDao_Impl.f125118f.a((int) sQLiteStatementG2.getLong(i15));
                if (scheduleEmojiA == null) {
                    throw new IllegalStateException("Expected NON-NULL 'cz.mobilesoft.coreblock.enums.ScheduleEmoji', but it was NULL.");
                }
                iD18 = i15;
                int i16 = iD19;
                boolean z7 = ((int) sQLiteStatementG2.getLong(i16)) != 0;
                iD19 = i16;
                int i17 = iD20;
                boolean z8 = ((int) sQLiteStatementG2.getLong(i17)) != 0;
                int i18 = iD21;
                boolean z9 = ((int) sQLiteStatementG2.getLong(i18)) != 0;
                iD21 = i18;
                int i19 = iD22;
                iD22 = i19;
                int i20 = iD23;
                arrayList.add(new Profile(j3, strF2, i5, i6, i7, i8, z2, z3, z4, z5, z6, j4, j5, j6, j7, pausedUntilA, blockingModeA, scheduleEmojiA, z7, z8, z9, (int) sQLiteStatementG2.getLong(i19), profileDao_Impl.f125119g.a((int) sQLiteStatementG2.getLong(i20))));
                iD4 = i12;
                iD23 = i20;
                iD5 = i14;
                iD17 = i13;
                iD = i3;
                iD2 = i4;
                iD3 = i9;
                iD16 = i11;
                iD20 = i17;
                iD15 = i10;
            }
            sQLiteStatementG2.close();
            return arrayList;
        } catch (Throwable th) {
            sQLiteStatementG2.close();
            throw th;
        }
    }

    private final void y2(final SQLiteConnection sQLiteConnection, LongSparseArray longSparseArray) {
        if (longSparseArray.j()) {
            return;
        }
        int i3 = 1;
        if (longSparseArray.r() > 999) {
            RelationUtil.b(longSparseArray, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.b4
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return ProfileDao_Impl.z2(this.f125357a, sQLiteConnection, (LongSparseArray) obj);
                }
            });
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT `id`,`profileId`,`geofenceId`,`geofenceRadius`,`latitude`,`longitude`,`isInverted`,`locale`,`featureName`,`adminArea`,`subAdminArea`,`locality`,`subLocality`,`thoroughfare`,`subThoroughfare`,`premises`,`postalCode`,`countryCode`,`countryName` FROM `GeoAddress` WHERE `profileId` IN (");
        StringUtil.a(sb, longSparseArray.r());
        sb.append(")");
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        SQLiteStatement sQLiteStatementG2 = sQLiteConnection.G2(string);
        int iR = longSparseArray.r();
        int i4 = 0;
        int i5 = 1;
        for (int i6 = 0; i6 < iR; i6++) {
            sQLiteStatementG2.A(i5, longSparseArray.k(i6));
            i5++;
        }
        try {
            int iC = SQLiteStatementUtil.c(sQLiteStatementG2, "profileId");
            if (iC == -1) {
                return;
            }
            while (sQLiteStatementG2.B2()) {
                List list = (List) longSparseArray.g(sQLiteStatementG2.getLong(iC));
                if (list != null) {
                    list.add(new GeoAddress(sQLiteStatementG2.getLong(i4), sQLiteStatementG2.getLong(i3), sQLiteStatementG2.f2(2), (int) sQLiteStatementG2.getLong(3), sQLiteStatementG2.getDouble(4), sQLiteStatementG2.getDouble(5), ((int) sQLiteStatementG2.getLong(6)) != 0, sQLiteStatementG2.isNull(7) ? null : sQLiteStatementG2.f2(7), sQLiteStatementG2.isNull(8) ? null : sQLiteStatementG2.f2(8), sQLiteStatementG2.isNull(9) ? null : sQLiteStatementG2.f2(9), sQLiteStatementG2.isNull(10) ? null : sQLiteStatementG2.f2(10), sQLiteStatementG2.isNull(11) ? null : sQLiteStatementG2.f2(11), sQLiteStatementG2.isNull(12) ? null : sQLiteStatementG2.f2(12), sQLiteStatementG2.isNull(13) ? null : sQLiteStatementG2.f2(13), sQLiteStatementG2.isNull(14) ? null : sQLiteStatementG2.f2(14), sQLiteStatementG2.isNull(15) ? null : sQLiteStatementG2.f2(15), sQLiteStatementG2.isNull(16) ? null : sQLiteStatementG2.f2(16), sQLiteStatementG2.isNull(17) ? null : sQLiteStatementG2.f2(17), sQLiteStatementG2.isNull(18) ? null : sQLiteStatementG2.f2(18)));
                    i3 = 1;
                    i4 = 0;
                }
            }
        } finally {
            sQLiteStatementG2.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit z2(ProfileDao_Impl profileDao_Impl, SQLiteConnection sQLiteConnection, LongSparseArray _tmpMap) {
        Intrinsics.checkNotNullParameter(_tmpMap, "_tmpMap");
        profileDao_Impl.y2(sQLiteConnection, _tmpMap);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List z3(String str, long j3, ProfileDao_Impl profileDao_Impl, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        try {
            sQLiteStatementG2.A(1, j3);
            int iD = SQLiteStatementUtil.d(sQLiteStatementG2, "id");
            int iD2 = SQLiteStatementUtil.d(sQLiteStatementG2, "title");
            int iD3 = SQLiteStatementUtil.d(sQLiteStatementG2, "typeCombinations");
            int iD4 = SQLiteStatementUtil.d(sQLiteStatementG2, "onConditions");
            int iD5 = SQLiteStatementUtil.d(sQLiteStatementG2, "operator");
            int iD6 = SQLiteStatementUtil.d(sQLiteStatementG2, "dayFlags");
            int iD7 = SQLiteStatementUtil.d(sQLiteStatementG2, "blockNotifications");
            int iD8 = SQLiteStatementUtil.d(sQLiteStatementG2, "blockLaunch");
            int iD9 = SQLiteStatementUtil.d(sQLiteStatementG2, "addNewApplications");
            int iD10 = SQLiteStatementUtil.d(sQLiteStatementG2, "isEnabled");
            int iD11 = SQLiteStatementUtil.d(sQLiteStatementG2, "isLocked");
            int iD12 = SQLiteStatementUtil.d(sQLiteStatementG2, "lastStartTime");
            int iD13 = SQLiteStatementUtil.d(sQLiteStatementG2, "onUntil");
            int iD14 = SQLiteStatementUtil.d(sQLiteStatementG2, "lockedUntil");
            int iD15 = SQLiteStatementUtil.d(sQLiteStatementG2, "lockAt");
            int iD16 = SQLiteStatementUtil.d(sQLiteStatementG2, "pausedUntil");
            int iD17 = SQLiteStatementUtil.d(sQLiteStatementG2, "blockingMode");
            int iD18 = SQLiteStatementUtil.d(sQLiteStatementG2, "emoji");
            int iD19 = SQLiteStatementUtil.d(sQLiteStatementG2, "blockUnsupportedBrowsers");
            int iD20 = SQLiteStatementUtil.d(sQLiteStatementG2, "blockAdultContent");
            int iD21 = SQLiteStatementUtil.d(sQLiteStatementG2, "blockInAppPurchases");
            int iD22 = SQLiteStatementUtil.d(sQLiteStatementG2, "selectedCategories");
            int iD23 = SQLiteStatementUtil.d(sQLiteStatementG2, "webBrowsingMode");
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementG2.B2()) {
                long j4 = sQLiteStatementG2.getLong(iD);
                String strF2 = sQLiteStatementG2.f2(iD2);
                int i3 = iD;
                int i4 = iD2;
                int i5 = (int) sQLiteStatementG2.getLong(iD3);
                int i6 = (int) sQLiteStatementG2.getLong(iD4);
                int i7 = (int) sQLiteStatementG2.getLong(iD5);
                int i8 = (int) sQLiteStatementG2.getLong(iD6);
                boolean z2 = ((int) sQLiteStatementG2.getLong(iD7)) != 0;
                int i9 = iD3;
                boolean z3 = ((int) sQLiteStatementG2.getLong(iD8)) != 0;
                boolean z4 = ((int) sQLiteStatementG2.getLong(iD9)) != 0;
                boolean z5 = ((int) sQLiteStatementG2.getLong(iD10)) != 0;
                boolean z6 = ((int) sQLiteStatementG2.getLong(iD11)) != 0;
                long j5 = sQLiteStatementG2.getLong(iD12);
                long j6 = sQLiteStatementG2.getLong(iD13);
                long j7 = sQLiteStatementG2.getLong(iD14);
                int i10 = iD15;
                long j8 = sQLiteStatementG2.getLong(i10);
                int i11 = iD16;
                int i12 = iD14;
                Profile.PausedUntil pausedUntilA = profileDao_Impl.f125116c.a(sQLiteStatementG2.getLong(i11));
                int i13 = iD17;
                int i14 = iD4;
                Profile.BlockingMode blockingModeA = profileDao_Impl.f125117d.a((int) sQLiteStatementG2.getLong(i13));
                int i15 = iD18;
                ScheduleEmoji scheduleEmojiA = profileDao_Impl.f125118f.a((int) sQLiteStatementG2.getLong(i15));
                if (scheduleEmojiA == null) {
                    throw new IllegalStateException("Expected NON-NULL 'cz.mobilesoft.coreblock.enums.ScheduleEmoji', but it was NULL.");
                }
                iD18 = i15;
                int i16 = iD19;
                boolean z7 = ((int) sQLiteStatementG2.getLong(i16)) != 0;
                iD19 = i16;
                int i17 = iD20;
                boolean z8 = ((int) sQLiteStatementG2.getLong(i17)) != 0;
                iD20 = i17;
                int i18 = iD21;
                iD21 = i18;
                int i19 = iD22;
                iD22 = i19;
                int i20 = iD23;
                arrayList.add(new Profile(j4, strF2, i5, i6, i7, i8, z2, z3, z4, z5, z6, j5, j6, j7, j8, pausedUntilA, blockingModeA, scheduleEmojiA, z7, z8, ((int) sQLiteStatementG2.getLong(i18)) != 0, (int) sQLiteStatementG2.getLong(i19), profileDao_Impl.f125119g.a((int) sQLiteStatementG2.getLong(i20))));
                iD4 = i14;
                iD17 = i13;
                iD23 = i20;
                iD14 = i12;
                iD3 = i9;
                iD = i3;
                iD2 = i4;
                iD15 = i10;
                iD16 = i11;
            }
            sQLiteStatementG2.close();
            return arrayList;
        } catch (Throwable th) {
            sQLiteStatementG2.close();
            throw th;
        }
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao
    public Object A0(final int i3, Continuation continuation) {
        final String str = "\n            SELECT * FROM Profile p\n            WHERE p.typeCombinations & ? <> 0 ;\n            ";
        return DBUtil.g(this.f125114a, true, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.p2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ProfileDao_Impl.s3(str, i3, this, (SQLiteConnection) obj);
            }
        }, continuation);
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao
    public Object B0(final int i3, final long j3, Continuation continuation) {
        final String str = "\n            SELECT * FROM Profile p\n            WHERE (p.pausedUntil > -1 AND p.pausedUntil < ?)\n            AND p.typeCombinations & ? <> 0 ;\n            ";
        return DBUtil.g(this.f125114a, true, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.l2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ProfileDao_Impl.t3(str, j3, i3, this, (SQLiteConnection) obj);
            }
        }, continuation);
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao
    public Object D0(Boolean bool, Boolean bool2, Boolean bool3, String str, UrlDto urlDto, Boolean bool4, Boolean bool5, Continuation continuation) {
        return DBUtil.f(this.f125114a, new ProfileDao_Impl$getAllCurrentlyOn$2(this, bool, bool2, bool3, str, urlDto, bool4, bool5, null), continuation);
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao
    public Object I0(final long j3, Continuation continuation) {
        final String str = "SELECT * FROM Profile p WHERE (p.pausedUntil > -1 AND p.pausedUntil < ?) ;";
        return DBUtil.g(this.f125114a, true, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.f3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ProfileDao_Impl.u3(str, j3, this, (SQLiteConnection) obj);
            }
        }, continuation);
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao
    public Object K(SupportSQLiteQuery supportSQLiteQuery, Continuation continuation) {
        final RoomRawQuery roomRawQueryN = RoomSQLiteQuery.f52354j.b(supportSQLiteQuery).n();
        final String strF = roomRawQueryN.f();
        return DBUtil.g(this.f125114a, true, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.i2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Long.valueOf(ProfileDao_Impl.a3(strF, roomRawQueryN, (SQLiteConnection) obj));
            }
        }, continuation);
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao
    public Object K0(Continuation continuation) {
        final String str = "\n            SELECT * FROM Profile\n            WHERE pausedUntil = -2\n            ";
        return DBUtil.g(this.f125114a, true, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.w2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ProfileDao_Impl.v3(str, this, (SQLiteConnection) obj);
            }
        }, continuation);
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao
    public Object L(Boolean bool, Boolean bool2, Boolean bool3, String str, UrlDto urlDto, Boolean bool4, Boolean bool5, Continuation continuation) {
        return DBUtil.f(this.f125114a, new ProfileDao_Impl$countAllCurrentlyOn$2(this, bool, bool2, bool3, str, urlDto, bool4, bool5, null), continuation);
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao
    public Object L0(ProfileType profileType, List list, Continuation continuation) {
        return DBUtil.f(this.f125114a, new ProfileDao_Impl$getAllIndefinitelyOn$2(this, profileType, list, null), continuation);
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.BaseDao
    /* JADX INFO: renamed from: N3, reason: merged with bridge method [inline-methods] */
    public Object n(final Profile profile, Continuation continuation) {
        return DBUtil.g(this.f125114a, false, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.j2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Long.valueOf(ProfileDao_Impl.O3(this.f125493a, profile, (SQLiteConnection) obj));
            }
        }, continuation);
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao
    public Object O(Continuation continuation) {
        final String str = "SELECT COUNT(*) FROM Profile p WHERE p.typeCombinations NOT IN (64, -2147483648)";
        return DBUtil.g(this.f125114a, true, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.n2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Long.valueOf(ProfileDao_Impl.b3(str, (SQLiteConnection) obj));
            }
        }, continuation);
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao
    public Object O0(final long j3, Continuation continuation) {
        final String str = "SELECT * FROM Profile p WHERE p.isLocked = 1 OR p.lockedUntil > ?";
        return DBUtil.g(this.f125114a, true, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.a3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ProfileDao_Impl.w3(str, j3, this, (SQLiteConnection) obj);
            }
        }, continuation);
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao
    public Object P(final long j3, Continuation continuation) {
        final String str = "SELECT COUNT(*) FROM Profile p WHERE (p.pausedUntil > -1 AND p.pausedUntil < ?) AND p.typeCombinations NOT IN (64, -2147483648)";
        return DBUtil.g(this.f125114a, true, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.h3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Long.valueOf(ProfileDao_Impl.c3(str, j3, (SQLiteConnection) obj));
            }
        }, continuation);
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao
    public Object P0(Continuation continuation) {
        final String str = "\n            SELECT * FROM Profile\n            WHERE pausedUntil > -1\n            AND typeCombinations NOT IN (64, -2147483648)\n            ";
        return DBUtil.g(this.f125114a, true, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.v2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ProfileDao_Impl.x3(str, this, (SQLiteConnection) obj);
            }
        }, continuation);
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao
    public Flow Q0() {
        final String str = "\n            SELECT * FROM Profile\n            WHERE pausedUntil > -1\n            ";
        return FlowUtil.a(this.f125114a, true, new String[]{"ApplicationProfileRelation", "WebsiteProfileRelation", "Interval", "GeoAddress", "WifiNetwork", "UsageLimit", "PomodoroSession", "SubAppRelation", "Profile"}, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.d3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ProfileDao_Impl.y3(str, this, (SQLiteConnection) obj);
            }
        });
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao
    public Object R(final int i3, Continuation continuation) {
        final String str = "\n            SELECT COUNT(*) FROM Profile p \n            WHERE p.typeCombinations & ? <> 0 \n            AND p.typeCombinations NOT IN (64, -2147483648)\n            ";
        return DBUtil.g(this.f125114a, true, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.a4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Long.valueOf(ProfileDao_Impl.d3(str, i3, (SQLiteConnection) obj));
            }
        }, continuation);
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao
    public Object R0(final long j3, Continuation continuation) {
        final String str = "SELECT * FROM Profile p WHERE p.pausedUntil > ? ;";
        return DBUtil.g(this.f125114a, true, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.x3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ProfileDao_Impl.z3(str, j3, this, (SQLiteConnection) obj);
            }
        }, continuation);
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.BaseDao
    /* JADX INFO: renamed from: R3, reason: merged with bridge method [inline-methods] */
    public Object p(final Profile profile, Continuation continuation) {
        Object objG = DBUtil.g(this.f125114a, false, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.t2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ProfileDao_Impl.S3(this.f125667a, profile, (SQLiteConnection) obj);
            }
        }, continuation);
        return objG == IntrinsicsKt.f() ? objG : Unit.f139807a;
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao
    public Object S(Continuation continuation) {
        final String str = "\n            SELECT COUNT(*) FROM Profile\n            WHERE pausedUntil > -1\n            AND typeCombinations NOT IN (64, -2147483648)\n            ";
        return DBUtil.g(this.f125114a, true, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.u3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Integer.valueOf(ProfileDao_Impl.e3(str, (SQLiteConnection) obj));
            }
        }, continuation);
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao
    public Object T(Continuation continuation) {
        final String str = "SELECT COUNT(*) FROM Profile p WHERE p.blockAdultContent = 1";
        return DBUtil.g(this.f125114a, true, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.j4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Long.valueOf(ProfileDao_Impl.f3(str, (SQLiteConnection) obj));
            }
        }, continuation);
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao
    public Object T0(Continuation continuation) {
        final String str = "SELECT * FROM Profile p WHERE p.typeCombinations & -2147483648 <> 0";
        return DBUtil.g(this.f125114a, true, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.i3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ProfileDao_Impl.A3(str, this, (SQLiteConnection) obj);
            }
        }, continuation);
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao
    public Object U0(Continuation continuation) {
        final String str = "SELECT * FROM Profile p WHERE p.typeCombinations & -2147483648 <> 0 AND p.title != 'STRICT_MODE_TAG_V2'";
        return DBUtil.g(this.f125114a, true, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.i4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ProfileDao_Impl.B3(str, this, (SQLiteConnection) obj);
            }
        }, continuation);
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao
    public Object V(boolean z2, Continuation continuation) {
        return DBUtil.f(this.f125114a, new ProfileDao_Impl$countAllWithInAppPurchaseBlocking$2(this, z2, null), continuation);
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao
    public Flow V0() {
        final String str = "SELECT * FROM Profile p WHERE p.typeCombinations & -2147483648 <> 0";
        return FlowUtil.a(this.f125114a, true, new String[]{"Interval", "Profile"}, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.p3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ProfileDao_Impl.C3(str, this, (SQLiteConnection) obj);
            }
        });
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao
    public Object W0(Continuation continuation) {
        final String str = "SELECT * FROM Profile p WHERE p.addNewApplications = 1";
        return DBUtil.g(this.f125114a, true, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.k2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ProfileDao_Impl.D3(str, this, (SQLiteConnection) obj);
            }
        }, continuation);
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao
    public Object X0(Continuation continuation) {
        final String str = "SELECT * FROM Profile";
        return DBUtil.g(this.f125114a, true, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.x2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ProfileDao_Impl.E3(str, this, (SQLiteConnection) obj);
            }
        }, continuation);
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao
    public Object Y(final long j3, Continuation continuation) {
        final String str = "\n            SELECT COUNT(*) FROM Profile p \n            WHERE p.typeCombinations = 64\n            AND (p.onUntil > ? OR p.onConditions = 64)\n            ";
        return DBUtil.g(this.f125114a, true, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.g3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Long.valueOf(ProfileDao_Impl.g3(str, j3, (SQLiteConnection) obj));
            }
        }, continuation);
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao
    public Flow Y0() {
        final String str = "SELECT * FROM Profile";
        return FlowUtil.a(this.f125114a, false, new String[]{"ApplicationProfileRelation", "WebsiteProfileRelation", "Interval", "GeoAddress", "WifiNetwork", "UsageLimit", "PomodoroSession", "SubAppRelation", "Profile"}, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.c3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ProfileDao_Impl.F3(str, this, (SQLiteConnection) obj);
            }
        });
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao
    public Object Z(final long j3, Continuation continuation) {
        final String str = "\n            SELECT COUNT(*) FROM Profile p \n            WHERE (p.title != 'STRICT_MODE_TAG_V2' AND p.typeCombinations & -2147483648 <> 0) \n            OR (p.title = 'STRICT_MODE_TAG_V2' AND (\n                p.onUntil > ? OR p.onConditions = -2147483648\n            ))\n            ";
        return DBUtil.g(this.f125114a, true, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.j3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Long.valueOf(ProfileDao_Impl.h3(str, j3, (SQLiteConnection) obj));
            }
        }, continuation);
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao
    public Object a(final Collection collection, Continuation continuation) {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT * FROM Profile p WHERE p.id IN (");
        StringUtil.a(sb, collection.size());
        sb.append(")");
        final String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return DBUtil.g(this.f125114a, true, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.u2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ProfileDao_Impl.p3(string, collection, this, (SQLiteConnection) obj);
            }
        }, continuation);
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao
    public Object a1(Continuation continuation) {
        final String str = "SELECT * FROM Profile p WHERE p.blockUnsupportedBrowsers = 1";
        return DBUtil.g(this.f125114a, true, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.y2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ProfileDao_Impl.G3(str, this, (SQLiteConnection) obj);
            }
        }, continuation);
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao
    public Object b0(Continuation continuation) {
        final String str = "\n            UPDATE Profile SET blockAdultContent = 0\n            WHERE blockAdultContent = 1\n            ";
        Object objG = DBUtil.g(this.f125114a, false, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.h4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ProfileDao_Impl.j3(str, (SQLiteConnection) obj);
            }
        }, continuation);
        return objG == IntrinsicsKt.f() ? objG : Unit.f139807a;
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao
    public Flow b1(final long j3) {
        final String str = "SELECT * FROM Profile p WHERE p.id = ?";
        return FlowUtil.a(this.f125114a, false, new String[]{"ApplicationProfileRelation", "WebsiteProfileRelation", "Interval", "GeoAddress", "WifiNetwork", "UsageLimit", "PomodoroSession", "SubAppRelation", "Profile"}, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.z2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ProfileDao_Impl.I3(str, j3, this, (SQLiteConnection) obj);
            }
        });
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao
    public Object c0(boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10, boolean z11, boolean z12, Continuation continuation) {
        Object objF = DBUtil.f(this.f125114a, new ProfileDao_Impl$disableAllSchedulesExceedingLimits$2(this, z2, z3, z4, z5, z6, z7, z8, z9, z10, z11, z12, null), continuation);
        return objF == IntrinsicsKt.f() ? objF : Unit.f139807a;
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao
    public Flow c1() {
        final String str = "\n            SELECT * FROM Profile p\n            WHERE p.typeCombinations == 64\n            ";
        return FlowUtil.a(this.f125114a, true, new String[]{"ApplicationProfileRelation", "Application", "WebsiteProfileRelation", "PomodoroSession", "SubAppRelation", "Profile"}, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.w3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ProfileDao_Impl.J3(str, this, (SQLiteConnection) obj);
            }
        });
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao
    public Object d1(Continuation continuation) {
        final String str = "SELECT * FROM Profile p WHERE p.typeCombinations & -2147483648 <> 0 AND p.blockLaunch = 1";
        return DBUtil.g(this.f125114a, true, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.o2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ProfileDao_Impl.K3(str, this, (SQLiteConnection) obj);
            }
        }, continuation);
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao
    public Object e(final long j3, Continuation continuation) {
        final String str = "SELECT * FROM Profile p WHERE p.id = ?";
        return DBUtil.g(this.f125114a, true, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.m2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ProfileDao_Impl.H3(str, j3, this, (SQLiteConnection) obj);
            }
        }, continuation);
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao
    public Object e1(Continuation continuation) {
        final String str = "SELECT * FROM Profile p WHERE p.title = 'STRICT_MODE_TAG_V2'";
        return DBUtil.g(this.f125114a, true, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.k4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ProfileDao_Impl.L3(str, this, (SQLiteConnection) obj);
            }
        }, continuation);
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao
    public Flow f1() {
        final String str = "SELECT * FROM Profile p WHERE p.title = 'STRICT_MODE_TAG_V2'";
        return FlowUtil.a(this.f125114a, true, new String[]{"Profile"}, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.d4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ProfileDao_Impl.M3(str, this, (SQLiteConnection) obj);
            }
        });
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao
    public Object g0(final int i3, final long j3, final long j4, Continuation continuation) {
        final String str = "\n                UPDATE Profile SET onConditions = ?, onUntil = ?\n                WHERE typeCombinations = -2147483648\n                AND (onUntil > ? OR onUntil = 0) \n            ";
        Object objG = DBUtil.g(this.f125114a, false, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.v3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ProfileDao_Impl.k3(str, i3, j3, j4, (SQLiteConnection) obj);
            }
        }, continuation);
        return objG == IntrinsicsKt.f() ? objG : Unit.f139807a;
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.BaseDao
    public Object h(final List list, Continuation continuation) {
        Object objG = DBUtil.g(this.f125114a, false, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.l3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ProfileDao_Impl.i3(this.f125533a, list, (SQLiteConnection) obj);
            }
        }, continuation);
        return objG == IntrinsicsKt.f() ? objG : Unit.f139807a;
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao
    public Object i0(final boolean z2, Continuation continuation) {
        final String str = "\n            UPDATE Profile SET pausedUntil = 0\n            WHERE pausedUntil = -2\n            AND (blockingMode = 0 OR ? = 1)\n            ";
        Object objG = DBUtil.g(this.f125114a, false, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.z3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ProfileDao_Impl.l3(str, z2, (SQLiteConnection) obj);
            }
        }, continuation);
        return objG == IntrinsicsKt.f() ? objG : Unit.f139807a;
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao
    public Object i1(Continuation continuation) {
        final String str = "\n                UPDATE Profile SET onConditions = 0\n                WHERE title = 'STRICT_MODE_TAG_V2'\n            ";
        Object objG = DBUtil.g(this.f125114a, false, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.r2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ProfileDao_Impl.Q3(str, (SQLiteConnection) obj);
            }
        }, continuation);
        return objG == IntrinsicsKt.f() ? objG : Unit.f139807a;
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao
    public Object j0(final List list, Continuation continuation) {
        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        sb.append("                UPDATE Profile SET pausedUntil = 0");
        sb.append("\n");
        sb.append("                WHERE id IN (");
        StringUtil.a(sb, list.size());
        sb.append(")");
        sb.append("\n");
        sb.append("            ");
        final String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        Object objG = DBUtil.g(this.f125114a, false, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.g4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ProfileDao_Impl.m3(string, list, (SQLiteConnection) obj);
            }
        }, continuation);
        return objG == IntrinsicsKt.f() ? objG : Unit.f139807a;
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao
    public Object j1(boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, Continuation continuation) {
        Object objF = DBUtil.f(this.f125114a, new ProfileDao_Impl$stopQuickBlockIfExceedingLimits$2(this, z2, z3, z4, z5, z6, z7, z8, null), continuation);
        return objF == IntrinsicsKt.f() ? objF : Unit.f139807a;
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao
    public Object l1(Continuation continuation) {
        Object objF = DBUtil.f(this.f125114a, new ProfileDao_Impl$unlockAll$2(this, null), continuation);
        return objF == IntrinsicsKt.f() ? objF : Unit.f139807a;
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao
    public Object n1(SupportSQLiteQuery supportSQLiteQuery, Continuation continuation) {
        final RoomRawQuery roomRawQueryN = RoomSQLiteQuery.f52354j.b(supportSQLiteQuery).n();
        final String strF = roomRawQueryN.f();
        return DBUtil.g(this.f125114a, true, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.n3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Long.valueOf(ProfileDao_Impl.U3(strF, roomRawQueryN, (SQLiteConnection) obj));
            }
        }, continuation);
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao
    public Object p0(boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, Continuation continuation) {
        Object objF = DBUtil.f(this.f125114a, new ProfileDao_Impl$fixAllSchedulesFalselyExceedingLimits$2(this, z2, z3, z4, z5, z6, z7, null), continuation);
        return objF == IntrinsicsKt.f() ? objF : Unit.f139807a;
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.BaseDao
    public Object r(final Collection collection, Continuation continuation) {
        Object objG = DBUtil.g(this.f125114a, false, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.k3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ProfileDao_Impl.T3(this.f125512a, collection, (SQLiteConnection) obj);
            }
        }, continuation);
        return objG == IntrinsicsKt.f() ? objG : Unit.f139807a;
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao
    public Object s0(boolean z2, boolean z3, Continuation continuation) {
        return DBUtil.f(this.f125114a, new ProfileDao_Impl$getAll$2(this, z2, z3, null), continuation);
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.BaseDao
    public Object t(final Collection collection, Continuation continuation) {
        return DBUtil.g(this.f125114a, false, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.s3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ProfileDao_Impl.P3(this.f125651a, collection, (SQLiteConnection) obj);
            }
        }, continuation);
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao
    public Object t0(Continuation continuation) {
        final String str = "SELECT * FROM Profile p";
        return DBUtil.g(this.f125114a, true, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.s2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ProfileDao_Impl.n3(str, this, (SQLiteConnection) obj);
            }
        }, continuation);
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao
    public Object y0(SupportSQLiteQuery supportSQLiteQuery, Continuation continuation) {
        final RoomRawQuery roomRawQueryN = RoomSQLiteQuery.f52354j.b(supportSQLiteQuery).n();
        final String strF = roomRawQueryN.f();
        return DBUtil.g(this.f125114a, true, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.b3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ProfileDao_Impl.q3(strF, roomRawQueryN, this, (SQLiteConnection) obj);
            }
        }, continuation);
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao
    public Flow z0(SupportSQLiteQuery query) {
        Intrinsics.checkNotNullParameter(query, "query");
        final RoomRawQuery roomRawQueryN = RoomSQLiteQuery.f52354j.b(query).n();
        final String strF = roomRawQueryN.f();
        return FlowUtil.a(this.f125114a, true, new String[]{"Profile"}, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.q2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ProfileDao_Impl.r3(strF, roomRawQueryN, this, (SQLiteConnection) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List B3(String str, ProfileDao_Impl profileDao_Impl, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        try {
            int iD = SQLiteStatementUtil.d(sQLiteStatementG2, "id");
            int iD2 = SQLiteStatementUtil.d(sQLiteStatementG2, "title");
            int iD3 = SQLiteStatementUtil.d(sQLiteStatementG2, "typeCombinations");
            int iD4 = SQLiteStatementUtil.d(sQLiteStatementG2, "onConditions");
            int iD5 = SQLiteStatementUtil.d(sQLiteStatementG2, "operator");
            int iD6 = SQLiteStatementUtil.d(sQLiteStatementG2, "dayFlags");
            int iD7 = SQLiteStatementUtil.d(sQLiteStatementG2, "blockNotifications");
            int iD8 = SQLiteStatementUtil.d(sQLiteStatementG2, "blockLaunch");
            int iD9 = SQLiteStatementUtil.d(sQLiteStatementG2, "addNewApplications");
            int iD10 = SQLiteStatementUtil.d(sQLiteStatementG2, "isEnabled");
            int iD11 = SQLiteStatementUtil.d(sQLiteStatementG2, "isLocked");
            int iD12 = SQLiteStatementUtil.d(sQLiteStatementG2, "lastStartTime");
            int iD13 = SQLiteStatementUtil.d(sQLiteStatementG2, "onUntil");
            int iD14 = SQLiteStatementUtil.d(sQLiteStatementG2, jTYhJgqLBN.JyuJMCOMq);
            int iD15 = SQLiteStatementUtil.d(sQLiteStatementG2, "lockAt");
            int iD16 = SQLiteStatementUtil.d(sQLiteStatementG2, "pausedUntil");
            int iD17 = SQLiteStatementUtil.d(sQLiteStatementG2, "blockingMode");
            int iD18 = SQLiteStatementUtil.d(sQLiteStatementG2, "emoji");
            int iD19 = SQLiteStatementUtil.d(sQLiteStatementG2, "blockUnsupportedBrowsers");
            int iD20 = SQLiteStatementUtil.d(sQLiteStatementG2, "blockAdultContent");
            int iD21 = SQLiteStatementUtil.d(sQLiteStatementG2, "blockInAppPurchases");
            int iD22 = SQLiteStatementUtil.d(sQLiteStatementG2, "selectedCategories");
            int iD23 = SQLiteStatementUtil.d(sQLiteStatementG2, "webBrowsingMode");
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementG2.B2()) {
                long j3 = sQLiteStatementG2.getLong(iD);
                String strF2 = sQLiteStatementG2.f2(iD2);
                int i3 = iD;
                int i4 = iD2;
                int i5 = (int) sQLiteStatementG2.getLong(iD3);
                int i6 = (int) sQLiteStatementG2.getLong(iD4);
                int i7 = (int) sQLiteStatementG2.getLong(iD5);
                int i8 = (int) sQLiteStatementG2.getLong(iD6);
                boolean z2 = ((int) sQLiteStatementG2.getLong(iD7)) != 0;
                int i9 = iD3;
                boolean z3 = ((int) sQLiteStatementG2.getLong(iD8)) != 0;
                boolean z4 = ((int) sQLiteStatementG2.getLong(iD9)) != 0;
                boolean z5 = ((int) sQLiteStatementG2.getLong(iD10)) != 0;
                boolean z6 = ((int) sQLiteStatementG2.getLong(iD11)) != 0;
                long j4 = sQLiteStatementG2.getLong(iD12);
                long j5 = sQLiteStatementG2.getLong(iD13);
                long j6 = sQLiteStatementG2.getLong(iD14);
                int i10 = iD15;
                long j7 = sQLiteStatementG2.getLong(i10);
                int i11 = iD16;
                int i12 = iD4;
                Profile.PausedUntil pausedUntilA = profileDao_Impl.f125116c.a(sQLiteStatementG2.getLong(i11));
                int i13 = iD17;
                Profile.BlockingMode blockingModeA = profileDao_Impl.f125117d.a((int) sQLiteStatementG2.getLong(i13));
                int i14 = iD5;
                int i15 = iD18;
                ScheduleEmoji scheduleEmojiA = profileDao_Impl.f125118f.a((int) sQLiteStatementG2.getLong(i15));
                if (scheduleEmojiA == null) {
                    throw new IllegalStateException("Expected NON-NULL 'cz.mobilesoft.coreblock.enums.ScheduleEmoji', but it was NULL.");
                }
                iD18 = i15;
                int i16 = iD19;
                boolean z7 = ((int) sQLiteStatementG2.getLong(i16)) != 0;
                iD19 = i16;
                int i17 = iD20;
                boolean z8 = ((int) sQLiteStatementG2.getLong(i17)) != 0;
                int i18 = iD21;
                boolean z9 = ((int) sQLiteStatementG2.getLong(i18)) != 0;
                iD21 = i18;
                int i19 = iD22;
                iD22 = i19;
                int i20 = iD23;
                arrayList.add(new Profile(j3, strF2, i5, i6, i7, i8, z2, z3, z4, z5, z6, j4, j5, j6, j7, pausedUntilA, blockingModeA, scheduleEmojiA, z7, z8, z9, (int) sQLiteStatementG2.getLong(i19), profileDao_Impl.f125119g.a((int) sQLiteStatementG2.getLong(i20))));
                iD4 = i12;
                iD23 = i20;
                iD5 = i14;
                iD17 = i13;
                iD = i3;
                iD2 = i4;
                iD3 = i9;
                iD16 = i11;
                iD20 = i17;
                iD15 = i10;
            }
            sQLiteStatementG2.close();
            return arrayList;
        } catch (Throwable th) {
            sQLiteStatementG2.close();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List E3(String str, ProfileDao_Impl profileDao_Impl, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        try {
            int iD = SQLiteStatementUtil.d(sQLiteStatementG2, "id");
            int iD2 = SQLiteStatementUtil.d(sQLiteStatementG2, "title");
            int iD3 = SQLiteStatementUtil.d(sQLiteStatementG2, "typeCombinations");
            int iD4 = SQLiteStatementUtil.d(sQLiteStatementG2, "onConditions");
            int iD5 = SQLiteStatementUtil.d(sQLiteStatementG2, "operator");
            int iD6 = SQLiteStatementUtil.d(sQLiteStatementG2, "dayFlags");
            int iD7 = SQLiteStatementUtil.d(sQLiteStatementG2, "blockNotifications");
            int iD8 = SQLiteStatementUtil.d(sQLiteStatementG2, "blockLaunch");
            int iD9 = SQLiteStatementUtil.d(sQLiteStatementG2, "addNewApplications");
            int iD10 = SQLiteStatementUtil.d(sQLiteStatementG2, "isEnabled");
            int iD11 = SQLiteStatementUtil.d(sQLiteStatementG2, "isLocked");
            int iD12 = SQLiteStatementUtil.d(sQLiteStatementG2, "lastStartTime");
            int iD13 = SQLiteStatementUtil.d(sQLiteStatementG2, "onUntil");
            int iD14 = SQLiteStatementUtil.d(sQLiteStatementG2, "lockedUntil");
            int iD15 = SQLiteStatementUtil.d(sQLiteStatementG2, "lockAt");
            int iD16 = SQLiteStatementUtil.d(sQLiteStatementG2, "pausedUntil");
            int iD17 = SQLiteStatementUtil.d(sQLiteStatementG2, "blockingMode");
            int iD18 = SQLiteStatementUtil.d(sQLiteStatementG2, "emoji");
            int iD19 = SQLiteStatementUtil.d(sQLiteStatementG2, "blockUnsupportedBrowsers");
            int iD20 = SQLiteStatementUtil.d(sQLiteStatementG2, "blockAdultContent");
            int iD21 = SQLiteStatementUtil.d(sQLiteStatementG2, QaXmqxvjHhxVy.uSbIfgWLCoWTE);
            int iD22 = SQLiteStatementUtil.d(sQLiteStatementG2, "selectedCategories");
            int iD23 = SQLiteStatementUtil.d(sQLiteStatementG2, "webBrowsingMode");
            int i3 = iD12;
            int i4 = iD11;
            int i5 = iD10;
            LongSparseArray longSparseArray = new LongSparseArray(0, 1, null);
            int i6 = iD9;
            LongSparseArray longSparseArray2 = new LongSparseArray(0, 1, null);
            int i7 = iD8;
            LongSparseArray longSparseArray3 = new LongSparseArray(0, 1, null);
            int i8 = iD7;
            LongSparseArray longSparseArray4 = new LongSparseArray(0, 1, null);
            int i9 = iD6;
            LongSparseArray longSparseArray5 = new LongSparseArray(0, 1, null);
            int i10 = iD5;
            LongSparseArray longSparseArray6 = new LongSparseArray(0, 1, null);
            int i11 = iD4;
            LongSparseArray longSparseArray7 = new LongSparseArray(0, 1, null);
            int i12 = iD3;
            LongSparseArray longSparseArray8 = new LongSparseArray(0, 1, null);
            while (sQLiteStatementG2.B2()) {
                long j3 = sQLiteStatementG2.getLong(iD);
                if (!longSparseArray.e(j3)) {
                    longSparseArray.m(j3, new ArrayList());
                }
                long j4 = sQLiteStatementG2.getLong(iD);
                if (!longSparseArray2.e(j4)) {
                    longSparseArray2.m(j4, new ArrayList());
                }
                long j5 = sQLiteStatementG2.getLong(iD);
                if (!longSparseArray3.e(j5)) {
                    longSparseArray3.m(j5, new ArrayList());
                }
                long j6 = sQLiteStatementG2.getLong(iD);
                if (!longSparseArray4.e(j6)) {
                    longSparseArray4.m(j6, new ArrayList());
                }
                long j7 = sQLiteStatementG2.getLong(iD);
                if (!longSparseArray5.e(j7)) {
                    longSparseArray5.m(j7, new ArrayList());
                }
                long j8 = sQLiteStatementG2.getLong(iD);
                if (!longSparseArray6.e(j8)) {
                    longSparseArray6.m(j8, new ArrayList());
                }
                long j9 = sQLiteStatementG2.getLong(iD);
                if (!longSparseArray7.e(j9)) {
                    longSparseArray7.m(j9, new ArrayList());
                }
                long j10 = sQLiteStatementG2.getLong(iD);
                if (!longSparseArray8.e(j10)) {
                    longSparseArray8.m(j10, new ArrayList());
                }
            }
            sQLiteStatementG2.reset();
            profileDao_Impl.u2(_connection, longSparseArray);
            profileDao_Impl.I2(_connection, longSparseArray2);
            profileDao_Impl.A2(_connection, longSparseArray3);
            profileDao_Impl.y2(_connection, longSparseArray4);
            profileDao_Impl.K2(_connection, longSparseArray5);
            profileDao_Impl.G2(_connection, longSparseArray6);
            profileDao_Impl.C2(_connection, longSparseArray7);
            profileDao_Impl.E2(_connection, longSparseArray8);
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementG2.B2()) {
                long j11 = sQLiteStatementG2.getLong(iD);
                String strF2 = sQLiteStatementG2.f2(iD2);
                int i13 = i12;
                int i14 = (int) sQLiteStatementG2.getLong(i13);
                i12 = i13;
                int i15 = i11;
                int i16 = (int) sQLiteStatementG2.getLong(i15);
                LongSparseArray longSparseArray9 = longSparseArray8;
                int i17 = i10;
                int i18 = iD2;
                int i19 = (int) sQLiteStatementG2.getLong(i17);
                int i20 = i9;
                int i21 = (int) sQLiteStatementG2.getLong(i20);
                int i22 = i8;
                boolean z2 = ((int) sQLiteStatementG2.getLong(i22)) != 0;
                int i23 = i7;
                boolean z3 = ((int) sQLiteStatementG2.getLong(i23)) != 0;
                i7 = i23;
                int i24 = i6;
                boolean z4 = ((int) sQLiteStatementG2.getLong(i24)) != 0;
                i6 = i24;
                int i25 = i5;
                boolean z5 = ((int) sQLiteStatementG2.getLong(i25)) != 0;
                i5 = i25;
                int i26 = i4;
                boolean z6 = ((int) sQLiteStatementG2.getLong(i26)) != 0;
                int i27 = i3;
                long j12 = sQLiteStatementG2.getLong(i27);
                int i28 = iD13;
                long j13 = sQLiteStatementG2.getLong(i28);
                i3 = i27;
                int i29 = iD14;
                long j14 = sQLiteStatementG2.getLong(i29);
                iD14 = i29;
                int i30 = iD15;
                long j15 = sQLiteStatementG2.getLong(i30);
                iD15 = i30;
                i4 = i26;
                int i31 = iD16;
                iD16 = i31;
                Profile.PausedUntil pausedUntilA = profileDao_Impl.f125116c.a(sQLiteStatementG2.getLong(i31));
                int i32 = iD17;
                Profile.BlockingMode blockingModeA = profileDao_Impl.f125117d.a((int) sQLiteStatementG2.getLong(i32));
                iD17 = i32;
                int i33 = iD18;
                ScheduleEmoji scheduleEmojiA = profileDao_Impl.f125118f.a((int) sQLiteStatementG2.getLong(i33));
                if (scheduleEmojiA == null) {
                    throw new IllegalStateException("Expected NON-NULL 'cz.mobilesoft.coreblock.enums.ScheduleEmoji', but it was NULL.");
                }
                iD18 = i33;
                int i34 = iD19;
                boolean z7 = ((int) sQLiteStatementG2.getLong(i34)) != 0;
                iD19 = i34;
                int i35 = iD20;
                boolean z8 = ((int) sQLiteStatementG2.getLong(i35)) != 0;
                iD20 = i35;
                int i36 = iD21;
                iD21 = i36;
                int i37 = iD22;
                iD22 = i37;
                int i38 = iD23;
                Profile profile = new Profile(j11, strF2, i14, i16, i19, i21, z2, z3, z4, z5, z6, j12, j13, j14, j15, pausedUntilA, blockingModeA, scheduleEmojiA, z7, z8, ((int) sQLiteStatementG2.getLong(i36)) != 0, (int) sQLiteStatementG2.getLong(i37), profileDao_Impl.f125119g.a((int) sQLiteStatementG2.getLong(i38)));
                Object objG = longSparseArray.g(sQLiteStatementG2.getLong(iD));
                if (objG == null) {
                    throw new IllegalStateException("Required value was null.");
                }
                List list = (List) objG;
                iD23 = i38;
                Object objG2 = longSparseArray2.g(sQLiteStatementG2.getLong(iD));
                if (objG2 == null) {
                    throw new IllegalStateException("Required value was null.");
                }
                List list2 = (List) objG2;
                Object objG3 = longSparseArray3.g(sQLiteStatementG2.getLong(iD));
                if (objG3 == null) {
                    throw new IllegalStateException("Required value was null.");
                }
                List list3 = (List) objG3;
                Object objG4 = longSparseArray4.g(sQLiteStatementG2.getLong(iD));
                if (objG4 == null) {
                    throw new IllegalStateException("Required value was null.");
                }
                List list4 = (List) objG4;
                Object objG5 = longSparseArray5.g(sQLiteStatementG2.getLong(iD));
                if (objG5 == null) {
                    throw new IllegalStateException("Required value was null.");
                }
                List list5 = (List) objG5;
                Object objG6 = longSparseArray6.g(sQLiteStatementG2.getLong(iD));
                if (objG6 == null) {
                    throw new IllegalStateException("Required value was null.");
                }
                List list6 = (List) objG6;
                Object objG7 = longSparseArray7.g(sQLiteStatementG2.getLong(iD));
                if (objG7 == null) {
                    throw new IllegalStateException("Required value was null.");
                }
                List list7 = (List) objG7;
                Object objG8 = longSparseArray9.g(sQLiteStatementG2.getLong(iD));
                if (objG8 == null) {
                    throw new IllegalStateException("Required value was null.");
                }
                arrayList.add(new ProfileWithConfiguration(profile, list, list2, list3, list4, list5, list6, list7, (List) objG8));
                longSparseArray8 = longSparseArray9;
                i11 = i15;
                iD2 = i18;
                i10 = i17;
                i9 = i20;
                i8 = i22;
                iD13 = i28;
            }
            sQLiteStatementG2.close();
            return arrayList;
        } catch (Throwable th) {
            sQLiteStatementG2.close();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ProfileWithConfiguration I3(String str, long j3, ProfileDao_Impl profileDao_Impl, SQLiteConnection _connection) {
        ProfileWithConfiguration profileWithConfiguration;
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        try {
            sQLiteStatementG2.A(1, j3);
            int iD = SQLiteStatementUtil.d(sQLiteStatementG2, "id");
            int iD2 = SQLiteStatementUtil.d(sQLiteStatementG2, "title");
            int iD3 = SQLiteStatementUtil.d(sQLiteStatementG2, "typeCombinations");
            int iD4 = SQLiteStatementUtil.d(sQLiteStatementG2, "onConditions");
            int iD5 = SQLiteStatementUtil.d(sQLiteStatementG2, "operator");
            int iD6 = SQLiteStatementUtil.d(sQLiteStatementG2, "dayFlags");
            int iD7 = SQLiteStatementUtil.d(sQLiteStatementG2, "blockNotifications");
            int iD8 = SQLiteStatementUtil.d(sQLiteStatementG2, SbbqvQlxi.PlMQwwhdq);
            int iD9 = SQLiteStatementUtil.d(sQLiteStatementG2, "addNewApplications");
            int iD10 = SQLiteStatementUtil.d(sQLiteStatementG2, "isEnabled");
            int iD11 = SQLiteStatementUtil.d(sQLiteStatementG2, "isLocked");
            int iD12 = SQLiteStatementUtil.d(sQLiteStatementG2, "lastStartTime");
            int iD13 = SQLiteStatementUtil.d(sQLiteStatementG2, "onUntil");
            int iD14 = SQLiteStatementUtil.d(sQLiteStatementG2, "lockedUntil");
            int iD15 = SQLiteStatementUtil.d(sQLiteStatementG2, "lockAt");
            int iD16 = SQLiteStatementUtil.d(sQLiteStatementG2, "pausedUntil");
            int iD17 = SQLiteStatementUtil.d(sQLiteStatementG2, "blockingMode");
            int iD18 = SQLiteStatementUtil.d(sQLiteStatementG2, "emoji");
            int iD19 = SQLiteStatementUtil.d(sQLiteStatementG2, "blockUnsupportedBrowsers");
            int iD20 = SQLiteStatementUtil.d(sQLiteStatementG2, "blockAdultContent");
            int iD21 = SQLiteStatementUtil.d(sQLiteStatementG2, "blockInAppPurchases");
            int iD22 = SQLiteStatementUtil.d(sQLiteStatementG2, "selectedCategories");
            int iD23 = SQLiteStatementUtil.d(sQLiteStatementG2, "webBrowsingMode");
            LongSparseArray longSparseArray = new LongSparseArray(0, 1, null);
            LongSparseArray longSparseArray2 = new LongSparseArray(0, 1, null);
            LongSparseArray longSparseArray3 = new LongSparseArray(0, 1, null);
            LongSparseArray longSparseArray4 = new LongSparseArray(0, 1, null);
            LongSparseArray longSparseArray5 = new LongSparseArray(0, 1, null);
            LongSparseArray longSparseArray6 = new LongSparseArray(0, 1, null);
            LongSparseArray longSparseArray7 = new LongSparseArray(0, 1, null);
            LongSparseArray longSparseArray8 = new LongSparseArray(0, 1, null);
            while (sQLiteStatementG2.B2()) {
                long j4 = sQLiteStatementG2.getLong(iD);
                if (!longSparseArray.e(j4)) {
                    longSparseArray.m(j4, new ArrayList());
                }
                long j5 = sQLiteStatementG2.getLong(iD);
                if (!longSparseArray2.e(j5)) {
                    longSparseArray2.m(j5, new ArrayList());
                }
                long j6 = sQLiteStatementG2.getLong(iD);
                if (!longSparseArray3.e(j6)) {
                    longSparseArray3.m(j6, new ArrayList());
                }
                long j7 = sQLiteStatementG2.getLong(iD);
                if (!longSparseArray4.e(j7)) {
                    longSparseArray4.m(j7, new ArrayList());
                }
                long j8 = sQLiteStatementG2.getLong(iD);
                if (!longSparseArray5.e(j8)) {
                    longSparseArray5.m(j8, new ArrayList());
                }
                long j9 = sQLiteStatementG2.getLong(iD);
                if (!longSparseArray6.e(j9)) {
                    longSparseArray6.m(j9, new ArrayList());
                }
                long j10 = sQLiteStatementG2.getLong(iD);
                if (!longSparseArray7.e(j10)) {
                    longSparseArray7.m(j10, new ArrayList());
                }
                long j11 = sQLiteStatementG2.getLong(iD);
                if (!longSparseArray8.e(j11)) {
                    longSparseArray8.m(j11, new ArrayList());
                }
            }
            sQLiteStatementG2.reset();
            profileDao_Impl.u2(_connection, longSparseArray);
            profileDao_Impl.I2(_connection, longSparseArray2);
            profileDao_Impl.A2(_connection, longSparseArray3);
            profileDao_Impl.y2(_connection, longSparseArray4);
            profileDao_Impl.K2(_connection, longSparseArray5);
            profileDao_Impl.G2(_connection, longSparseArray6);
            profileDao_Impl.C2(_connection, longSparseArray7);
            profileDao_Impl.E2(_connection, longSparseArray8);
            if (sQLiteStatementG2.B2()) {
                long j12 = sQLiteStatementG2.getLong(iD);
                String strF2 = sQLiteStatementG2.f2(iD2);
                int i3 = (int) sQLiteStatementG2.getLong(iD3);
                int i4 = (int) sQLiteStatementG2.getLong(iD4);
                int i5 = (int) sQLiteStatementG2.getLong(iD5);
                int i6 = (int) sQLiteStatementG2.getLong(iD6);
                boolean z2 = ((int) sQLiteStatementG2.getLong(iD7)) != 0;
                boolean z3 = ((int) sQLiteStatementG2.getLong(iD8)) != 0;
                boolean z4 = ((int) sQLiteStatementG2.getLong(iD9)) != 0;
                boolean z5 = ((int) sQLiteStatementG2.getLong(iD10)) != 0;
                boolean z6 = ((int) sQLiteStatementG2.getLong(iD11)) != 0;
                long j13 = sQLiteStatementG2.getLong(iD12);
                long j14 = sQLiteStatementG2.getLong(iD13);
                long j15 = sQLiteStatementG2.getLong(iD14);
                long j16 = sQLiteStatementG2.getLong(iD15);
                Profile.PausedUntil pausedUntilA = profileDao_Impl.f125116c.a(sQLiteStatementG2.getLong(iD16));
                Profile.BlockingMode blockingModeA = profileDao_Impl.f125117d.a((int) sQLiteStatementG2.getLong(iD17));
                ScheduleEmoji scheduleEmojiA = profileDao_Impl.f125118f.a((int) sQLiteStatementG2.getLong(iD18));
                if (scheduleEmojiA == null) {
                    throw new IllegalStateException("Expected NON-NULL 'cz.mobilesoft.coreblock.enums.ScheduleEmoji', but it was NULL.");
                }
                Profile profile = new Profile(j12, strF2, i3, i4, i5, i6, z2, z3, z4, z5, z6, j13, j14, j15, j16, pausedUntilA, blockingModeA, scheduleEmojiA, ((int) sQLiteStatementG2.getLong(iD19)) != 0, ((int) sQLiteStatementG2.getLong(iD20)) != 0, ((int) sQLiteStatementG2.getLong(iD21)) != 0, (int) sQLiteStatementG2.getLong(iD22), profileDao_Impl.f125119g.a((int) sQLiteStatementG2.getLong(iD23)));
                Object objG = longSparseArray.g(sQLiteStatementG2.getLong(iD));
                if (objG == null) {
                    throw new IllegalStateException("Required value was null.");
                }
                List list = (List) objG;
                Object objG2 = longSparseArray2.g(sQLiteStatementG2.getLong(iD));
                if (objG2 == null) {
                    throw new IllegalStateException("Required value was null.");
                }
                List list2 = (List) objG2;
                Object objG3 = longSparseArray3.g(sQLiteStatementG2.getLong(iD));
                if (objG3 == null) {
                    throw new IllegalStateException("Required value was null.");
                }
                List list3 = (List) objG3;
                Object objG4 = longSparseArray4.g(sQLiteStatementG2.getLong(iD));
                if (objG4 == null) {
                    throw new IllegalStateException("Required value was null.");
                }
                List list4 = (List) objG4;
                Object objG5 = longSparseArray5.g(sQLiteStatementG2.getLong(iD));
                if (objG5 == null) {
                    throw new IllegalStateException("Required value was null.");
                }
                List list5 = (List) objG5;
                Object objG6 = longSparseArray6.g(sQLiteStatementG2.getLong(iD));
                if (objG6 == null) {
                    throw new IllegalStateException("Required value was null.");
                }
                List list6 = (List) objG6;
                Object objG7 = longSparseArray7.g(sQLiteStatementG2.getLong(iD));
                if (objG7 == null) {
                    throw new IllegalStateException("Required value was null.");
                }
                List list7 = (List) objG7;
                Object objG8 = longSparseArray8.g(sQLiteStatementG2.getLong(iD));
                if (objG8 == null) {
                    throw new IllegalStateException("Required value was null.");
                }
                profileWithConfiguration = new ProfileWithConfiguration(profile, list, list2, list3, list4, list5, list6, list7, (List) objG8);
            } else {
                profileWithConfiguration = null;
            }
            sQLiteStatementG2.close();
            return profileWithConfiguration;
        } catch (Throwable th) {
            sQLiteStatementG2.close();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Profile L3(String str, ProfileDao_Impl profileDao_Impl, SQLiteConnection _connection) {
        Profile profile;
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        try {
            int iD = SQLiteStatementUtil.d(sQLiteStatementG2, "id");
            int iD2 = SQLiteStatementUtil.d(sQLiteStatementG2, "title");
            int iD3 = SQLiteStatementUtil.d(sQLiteStatementG2, "typeCombinations");
            int iD4 = SQLiteStatementUtil.d(sQLiteStatementG2, "onConditions");
            int iD5 = SQLiteStatementUtil.d(sQLiteStatementG2, "operator");
            int iD6 = SQLiteStatementUtil.d(sQLiteStatementG2, SbbqvQlxi.JTf);
            int iD7 = SQLiteStatementUtil.d(sQLiteStatementG2, "blockNotifications");
            int iD8 = SQLiteStatementUtil.d(sQLiteStatementG2, "blockLaunch");
            int iD9 = SQLiteStatementUtil.d(sQLiteStatementG2, "addNewApplications");
            int iD10 = SQLiteStatementUtil.d(sQLiteStatementG2, "isEnabled");
            int iD11 = SQLiteStatementUtil.d(sQLiteStatementG2, "isLocked");
            int iD12 = SQLiteStatementUtil.d(sQLiteStatementG2, "lastStartTime");
            int iD13 = SQLiteStatementUtil.d(sQLiteStatementG2, "onUntil");
            int iD14 = SQLiteStatementUtil.d(sQLiteStatementG2, "lockedUntil");
            int iD15 = SQLiteStatementUtil.d(sQLiteStatementG2, "lockAt");
            int iD16 = SQLiteStatementUtil.d(sQLiteStatementG2, "pausedUntil");
            int iD17 = SQLiteStatementUtil.d(sQLiteStatementG2, "blockingMode");
            int iD18 = SQLiteStatementUtil.d(sQLiteStatementG2, "emoji");
            int iD19 = SQLiteStatementUtil.d(sQLiteStatementG2, "blockUnsupportedBrowsers");
            int iD20 = SQLiteStatementUtil.d(sQLiteStatementG2, "blockAdultContent");
            int iD21 = SQLiteStatementUtil.d(sQLiteStatementG2, "blockInAppPurchases");
            int iD22 = SQLiteStatementUtil.d(sQLiteStatementG2, "selectedCategories");
            int iD23 = SQLiteStatementUtil.d(sQLiteStatementG2, "webBrowsingMode");
            if (sQLiteStatementG2.B2()) {
                long j3 = sQLiteStatementG2.getLong(iD);
                String strF2 = sQLiteStatementG2.f2(iD2);
                int i3 = (int) sQLiteStatementG2.getLong(iD3);
                int i4 = (int) sQLiteStatementG2.getLong(iD4);
                int i5 = (int) sQLiteStatementG2.getLong(iD5);
                int i6 = (int) sQLiteStatementG2.getLong(iD6);
                boolean z2 = ((int) sQLiteStatementG2.getLong(iD7)) != 0;
                boolean z3 = ((int) sQLiteStatementG2.getLong(iD8)) != 0;
                boolean z4 = ((int) sQLiteStatementG2.getLong(iD9)) != 0;
                boolean z5 = ((int) sQLiteStatementG2.getLong(iD10)) != 0;
                boolean z6 = ((int) sQLiteStatementG2.getLong(iD11)) != 0;
                long j4 = sQLiteStatementG2.getLong(iD12);
                long j5 = sQLiteStatementG2.getLong(iD13);
                long j6 = sQLiteStatementG2.getLong(iD14);
                long j7 = sQLiteStatementG2.getLong(iD15);
                Profile.PausedUntil pausedUntilA = profileDao_Impl.f125116c.a(sQLiteStatementG2.getLong(iD16));
                Profile.BlockingMode blockingModeA = profileDao_Impl.f125117d.a((int) sQLiteStatementG2.getLong(iD17));
                ScheduleEmoji scheduleEmojiA = profileDao_Impl.f125118f.a((int) sQLiteStatementG2.getLong(iD18));
                if (scheduleEmojiA == null) {
                    throw new IllegalStateException("Expected NON-NULL 'cz.mobilesoft.coreblock.enums.ScheduleEmoji', but it was NULL.");
                }
                profile = new Profile(j3, strF2, i3, i4, i5, i6, z2, z3, z4, z5, z6, j4, j5, j6, j7, pausedUntilA, blockingModeA, scheduleEmojiA, ((int) sQLiteStatementG2.getLong(iD19)) != 0, ((int) sQLiteStatementG2.getLong(iD20)) != 0, ((int) sQLiteStatementG2.getLong(iD21)) != 0, (int) sQLiteStatementG2.getLong(iD22), profileDao_Impl.f125119g.a((int) sQLiteStatementG2.getLong(iD23)));
            } else {
                profile = null;
            }
            sQLiteStatementG2.close();
            return profile;
        } catch (Throwable th) {
            sQLiteStatementG2.close();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List p3(String str, Collection collection, ProfileDao_Impl profileDao_Impl, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        try {
            Iterator it = collection.iterator();
            int i3 = 1;
            while (it.hasNext()) {
                sQLiteStatementG2.A(i3, ((Number) it.next()).longValue());
                i3++;
            }
            int iD = SQLiteStatementUtil.d(sQLiteStatementG2, "id");
            int iD2 = SQLiteStatementUtil.d(sQLiteStatementG2, "title");
            int iD3 = SQLiteStatementUtil.d(sQLiteStatementG2, "typeCombinations");
            int iD4 = SQLiteStatementUtil.d(sQLiteStatementG2, "onConditions");
            int iD5 = SQLiteStatementUtil.d(sQLiteStatementG2, "operator");
            int iD6 = SQLiteStatementUtil.d(sQLiteStatementG2, "dayFlags");
            int iD7 = SQLiteStatementUtil.d(sQLiteStatementG2, "blockNotifications");
            int iD8 = SQLiteStatementUtil.d(sQLiteStatementG2, "blockLaunch");
            int iD9 = SQLiteStatementUtil.d(sQLiteStatementG2, "addNewApplications");
            int iD10 = SQLiteStatementUtil.d(sQLiteStatementG2, "isEnabled");
            int iD11 = SQLiteStatementUtil.d(sQLiteStatementG2, "isLocked");
            int iD12 = SQLiteStatementUtil.d(sQLiteStatementG2, "lastStartTime");
            int iD13 = SQLiteStatementUtil.d(sQLiteStatementG2, "onUntil");
            int iD14 = SQLiteStatementUtil.d(sQLiteStatementG2, "lockedUntil");
            int iD15 = SQLiteStatementUtil.d(sQLiteStatementG2, "lockAt");
            int iD16 = SQLiteStatementUtil.d(sQLiteStatementG2, "pausedUntil");
            int iD17 = SQLiteStatementUtil.d(sQLiteStatementG2, "blockingMode");
            int iD18 = SQLiteStatementUtil.d(sQLiteStatementG2, "emoji");
            int iD19 = SQLiteStatementUtil.d(sQLiteStatementG2, "blockUnsupportedBrowsers");
            int iD20 = SQLiteStatementUtil.d(sQLiteStatementG2, "blockAdultContent");
            int iD21 = SQLiteStatementUtil.d(sQLiteStatementG2, "blockInAppPurchases");
            int iD22 = SQLiteStatementUtil.d(sQLiteStatementG2, vxrlPPpdv.bUiSTrhYDFnu);
            int iD23 = SQLiteStatementUtil.d(sQLiteStatementG2, "webBrowsingMode");
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementG2.B2()) {
                long j3 = sQLiteStatementG2.getLong(iD);
                String strF2 = sQLiteStatementG2.f2(iD2);
                int i4 = iD;
                int i5 = iD14;
                int i6 = (int) sQLiteStatementG2.getLong(iD3);
                int i7 = (int) sQLiteStatementG2.getLong(iD4);
                int i8 = (int) sQLiteStatementG2.getLong(iD5);
                int i9 = (int) sQLiteStatementG2.getLong(iD6);
                boolean z2 = ((int) sQLiteStatementG2.getLong(iD7)) != 0;
                int i10 = iD2;
                boolean z3 = ((int) sQLiteStatementG2.getLong(iD8)) != 0;
                boolean z4 = ((int) sQLiteStatementG2.getLong(iD9)) != 0;
                boolean z5 = ((int) sQLiteStatementG2.getLong(iD10)) != 0;
                boolean z6 = ((int) sQLiteStatementG2.getLong(iD11)) != 0;
                long j4 = sQLiteStatementG2.getLong(iD12);
                long j5 = sQLiteStatementG2.getLong(iD13);
                long j6 = sQLiteStatementG2.getLong(i5);
                int i11 = iD15;
                long j7 = sQLiteStatementG2.getLong(i11);
                int i12 = iD16;
                int i13 = iD3;
                Profile.PausedUntil pausedUntilA = profileDao_Impl.f125116c.a(sQLiteStatementG2.getLong(i12));
                int i14 = iD17;
                Profile.BlockingMode blockingModeA = profileDao_Impl.f125117d.a((int) sQLiteStatementG2.getLong(i14));
                int i15 = iD4;
                int i16 = iD18;
                ScheduleEmoji scheduleEmojiA = profileDao_Impl.f125118f.a((int) sQLiteStatementG2.getLong(i16));
                if (scheduleEmojiA == null) {
                    throw new IllegalStateException("Expected NON-NULL 'cz.mobilesoft.coreblock.enums.ScheduleEmoji', but it was NULL.");
                }
                iD18 = i16;
                int i17 = iD19;
                boolean z7 = ((int) sQLiteStatementG2.getLong(i17)) != 0;
                iD19 = i17;
                int i18 = iD20;
                boolean z8 = ((int) sQLiteStatementG2.getLong(i18)) != 0;
                int i19 = iD21;
                boolean z9 = ((int) sQLiteStatementG2.getLong(i19)) != 0;
                iD21 = i19;
                int i20 = iD22;
                iD22 = i20;
                int i21 = iD23;
                arrayList.add(new Profile(j3, strF2, i6, i7, i8, i9, z2, z3, z4, z5, z6, j4, j5, j6, j7, pausedUntilA, blockingModeA, scheduleEmojiA, z7, z8, z9, (int) sQLiteStatementG2.getLong(i20), profileDao_Impl.f125119g.a((int) sQLiteStatementG2.getLong(i21))));
                iD4 = i15;
                iD17 = i14;
                iD20 = i18;
                iD = i4;
                iD14 = i5;
                iD3 = i13;
                iD23 = i21;
                iD2 = i10;
                iD15 = i11;
                iD16 = i12;
            }
            sQLiteStatementG2.close();
            return arrayList;
        } catch (Throwable th) {
            sQLiteStatementG2.close();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List y3(String str, ProfileDao_Impl profileDao_Impl, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        try {
            int iD = SQLiteStatementUtil.d(sQLiteStatementG2, "id");
            int iD2 = SQLiteStatementUtil.d(sQLiteStatementG2, "title");
            int iD3 = SQLiteStatementUtil.d(sQLiteStatementG2, "typeCombinations");
            int iD4 = SQLiteStatementUtil.d(sQLiteStatementG2, "onConditions");
            int iD5 = SQLiteStatementUtil.d(sQLiteStatementG2, "operator");
            int iD6 = SQLiteStatementUtil.d(sQLiteStatementG2, "dayFlags");
            int iD7 = SQLiteStatementUtil.d(sQLiteStatementG2, "blockNotifications");
            int iD8 = SQLiteStatementUtil.d(sQLiteStatementG2, "blockLaunch");
            int iD9 = SQLiteStatementUtil.d(sQLiteStatementG2, "addNewApplications");
            int iD10 = SQLiteStatementUtil.d(sQLiteStatementG2, "isEnabled");
            int iD11 = SQLiteStatementUtil.d(sQLiteStatementG2, "isLocked");
            int iD12 = SQLiteStatementUtil.d(sQLiteStatementG2, "lastStartTime");
            int iD13 = SQLiteStatementUtil.d(sQLiteStatementG2, "onUntil");
            int iD14 = SQLiteStatementUtil.d(sQLiteStatementG2, "lockedUntil");
            int iD15 = SQLiteStatementUtil.d(sQLiteStatementG2, "lockAt");
            int iD16 = SQLiteStatementUtil.d(sQLiteStatementG2, "pausedUntil");
            int iD17 = SQLiteStatementUtil.d(sQLiteStatementG2, "blockingMode");
            int iD18 = SQLiteStatementUtil.d(sQLiteStatementG2, "emoji");
            int iD19 = SQLiteStatementUtil.d(sQLiteStatementG2, "blockUnsupportedBrowsers");
            int iD20 = SQLiteStatementUtil.d(sQLiteStatementG2, "blockAdultContent");
            int iD21 = SQLiteStatementUtil.d(sQLiteStatementG2, "blockInAppPurchases");
            int iD22 = SQLiteStatementUtil.d(sQLiteStatementG2, vxrlPPpdv.KhZfigJzoeuvkZ);
            int iD23 = SQLiteStatementUtil.d(sQLiteStatementG2, "webBrowsingMode");
            int i3 = iD12;
            int i4 = iD11;
            int i5 = iD10;
            LongSparseArray longSparseArray = new LongSparseArray(0, 1, null);
            int i6 = iD9;
            LongSparseArray longSparseArray2 = new LongSparseArray(0, 1, null);
            int i7 = iD8;
            LongSparseArray longSparseArray3 = new LongSparseArray(0, 1, null);
            int i8 = iD7;
            LongSparseArray longSparseArray4 = new LongSparseArray(0, 1, null);
            int i9 = iD6;
            LongSparseArray longSparseArray5 = new LongSparseArray(0, 1, null);
            int i10 = iD5;
            LongSparseArray longSparseArray6 = new LongSparseArray(0, 1, null);
            int i11 = iD4;
            LongSparseArray longSparseArray7 = new LongSparseArray(0, 1, null);
            int i12 = iD3;
            LongSparseArray longSparseArray8 = new LongSparseArray(0, 1, null);
            while (sQLiteStatementG2.B2()) {
                long j3 = sQLiteStatementG2.getLong(iD);
                if (!longSparseArray.e(j3)) {
                    longSparseArray.m(j3, new ArrayList());
                }
                long j4 = sQLiteStatementG2.getLong(iD);
                if (!longSparseArray2.e(j4)) {
                    longSparseArray2.m(j4, new ArrayList());
                }
                long j5 = sQLiteStatementG2.getLong(iD);
                if (!longSparseArray3.e(j5)) {
                    longSparseArray3.m(j5, new ArrayList());
                }
                long j6 = sQLiteStatementG2.getLong(iD);
                if (!longSparseArray4.e(j6)) {
                    longSparseArray4.m(j6, new ArrayList());
                }
                long j7 = sQLiteStatementG2.getLong(iD);
                if (!longSparseArray5.e(j7)) {
                    longSparseArray5.m(j7, new ArrayList());
                }
                long j8 = sQLiteStatementG2.getLong(iD);
                if (!longSparseArray6.e(j8)) {
                    longSparseArray6.m(j8, new ArrayList());
                }
                long j9 = sQLiteStatementG2.getLong(iD);
                if (!longSparseArray7.e(j9)) {
                    longSparseArray7.m(j9, new ArrayList());
                }
                long j10 = sQLiteStatementG2.getLong(iD);
                if (!longSparseArray8.e(j10)) {
                    longSparseArray8.m(j10, new ArrayList());
                }
            }
            sQLiteStatementG2.reset();
            profileDao_Impl.u2(_connection, longSparseArray);
            profileDao_Impl.I2(_connection, longSparseArray2);
            profileDao_Impl.A2(_connection, longSparseArray3);
            profileDao_Impl.y2(_connection, longSparseArray4);
            profileDao_Impl.K2(_connection, longSparseArray5);
            profileDao_Impl.G2(_connection, longSparseArray6);
            profileDao_Impl.C2(_connection, longSparseArray7);
            profileDao_Impl.E2(_connection, longSparseArray8);
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementG2.B2()) {
                long j11 = sQLiteStatementG2.getLong(iD);
                String strF2 = sQLiteStatementG2.f2(iD2);
                int i13 = i12;
                int i14 = (int) sQLiteStatementG2.getLong(i13);
                i12 = i13;
                int i15 = i11;
                int i16 = (int) sQLiteStatementG2.getLong(i15);
                LongSparseArray longSparseArray9 = longSparseArray8;
                int i17 = i10;
                int i18 = iD2;
                int i19 = (int) sQLiteStatementG2.getLong(i17);
                int i20 = i9;
                int i21 = (int) sQLiteStatementG2.getLong(i20);
                int i22 = i8;
                boolean z2 = ((int) sQLiteStatementG2.getLong(i22)) != 0;
                int i23 = i7;
                boolean z3 = ((int) sQLiteStatementG2.getLong(i23)) != 0;
                i7 = i23;
                int i24 = i6;
                boolean z4 = ((int) sQLiteStatementG2.getLong(i24)) != 0;
                i6 = i24;
                int i25 = i5;
                boolean z5 = ((int) sQLiteStatementG2.getLong(i25)) != 0;
                i5 = i25;
                int i26 = i4;
                boolean z6 = ((int) sQLiteStatementG2.getLong(i26)) != 0;
                int i27 = i3;
                long j12 = sQLiteStatementG2.getLong(i27);
                int i28 = iD13;
                long j13 = sQLiteStatementG2.getLong(i28);
                i3 = i27;
                int i29 = iD14;
                long j14 = sQLiteStatementG2.getLong(i29);
                iD14 = i29;
                int i30 = iD15;
                long j15 = sQLiteStatementG2.getLong(i30);
                iD15 = i30;
                i4 = i26;
                int i31 = iD16;
                iD16 = i31;
                Profile.PausedUntil pausedUntilA = profileDao_Impl.f125116c.a(sQLiteStatementG2.getLong(i31));
                int i32 = iD17;
                Profile.BlockingMode blockingModeA = profileDao_Impl.f125117d.a((int) sQLiteStatementG2.getLong(i32));
                iD17 = i32;
                int i33 = iD18;
                ScheduleEmoji scheduleEmojiA = profileDao_Impl.f125118f.a((int) sQLiteStatementG2.getLong(i33));
                if (scheduleEmojiA == null) {
                    throw new IllegalStateException("Expected NON-NULL 'cz.mobilesoft.coreblock.enums.ScheduleEmoji', but it was NULL.");
                }
                iD18 = i33;
                int i34 = iD19;
                boolean z7 = ((int) sQLiteStatementG2.getLong(i34)) != 0;
                iD19 = i34;
                int i35 = iD20;
                boolean z8 = ((int) sQLiteStatementG2.getLong(i35)) != 0;
                iD20 = i35;
                int i36 = iD21;
                iD21 = i36;
                int i37 = iD22;
                iD22 = i37;
                int i38 = iD23;
                Profile profile = new Profile(j11, strF2, i14, i16, i19, i21, z2, z3, z4, z5, z6, j12, j13, j14, j15, pausedUntilA, blockingModeA, scheduleEmojiA, z7, z8, ((int) sQLiteStatementG2.getLong(i36)) != 0, (int) sQLiteStatementG2.getLong(i37), profileDao_Impl.f125119g.a((int) sQLiteStatementG2.getLong(i38)));
                Object objG = longSparseArray.g(sQLiteStatementG2.getLong(iD));
                if (objG == null) {
                    throw new IllegalStateException("Required value was null.");
                }
                List list = (List) objG;
                iD23 = i38;
                Object objG2 = longSparseArray2.g(sQLiteStatementG2.getLong(iD));
                if (objG2 == null) {
                    throw new IllegalStateException("Required value was null.");
                }
                List list2 = (List) objG2;
                Object objG3 = longSparseArray3.g(sQLiteStatementG2.getLong(iD));
                if (objG3 == null) {
                    throw new IllegalStateException("Required value was null.");
                }
                List list3 = (List) objG3;
                Object objG4 = longSparseArray4.g(sQLiteStatementG2.getLong(iD));
                if (objG4 == null) {
                    throw new IllegalStateException("Required value was null.");
                }
                List list4 = (List) objG4;
                Object objG5 = longSparseArray5.g(sQLiteStatementG2.getLong(iD));
                if (objG5 == null) {
                    throw new IllegalStateException("Required value was null.");
                }
                List list5 = (List) objG5;
                Object objG6 = longSparseArray6.g(sQLiteStatementG2.getLong(iD));
                if (objG6 == null) {
                    throw new IllegalStateException("Required value was null.");
                }
                List list6 = (List) objG6;
                Object objG7 = longSparseArray7.g(sQLiteStatementG2.getLong(iD));
                if (objG7 == null) {
                    throw new IllegalStateException("Required value was null.");
                }
                List list7 = (List) objG7;
                Object objG8 = longSparseArray9.g(sQLiteStatementG2.getLong(iD));
                if (objG8 == null) {
                    throw new IllegalStateException("Required value was null.");
                }
                arrayList.add(new ProfileWithConfiguration(profile, list, list2, list3, list4, list5, list6, list7, (List) objG8));
                longSparseArray8 = longSparseArray9;
                i11 = i15;
                iD2 = i18;
                i10 = i17;
                i9 = i20;
                i8 = i22;
                iD13 = i28;
            }
            sQLiteStatementG2.close();
            return arrayList;
        } catch (Throwable th) {
            sQLiteStatementG2.close();
            throw th;
        }
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao
    public Object x0(final List list, final List list2, Continuation continuation) {
        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        sb.append("            SELECT * FROM Profile p");
        sb.append("\n");
        sb.append("            WHERE p.typeCombinations != -2147483648");
        sb.append("\n");
        sb.append("            AND EXISTS (");
        sb.append("\n");
        sb.append("                SELECT * FROM ApplicationProfileRelation ar");
        sb.append("\n");
        sb.append("                WHERE ar.profileId = p.id");
        sb.append("\n");
        sb.append("                AND ar.packageName IN (");
        final int size = list.size();
        StringUtil.a(sb, size);
        sb.append(")");
        sb.append("\n");
        sb.append("            )");
        sb.append("\n");
        sb.append("            AND EXISTS (");
        sb.append("\n");
        sb.append("                SELECT * FROM WebsiteProfileRelation wr");
        sb.append("\n");
        sb.append("                WHERE wr.profileId = p.id");
        sb.append("\n");
        sb.append("                AND wr.name IN (");
        StringUtil.a(sb, list2.size());
        sb.append(")");
        sb.append("\n");
        sb.append("            )");
        sb.append("\n");
        sb.append(KqqtdetwHMIO.GHvXqcQi);
        final String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return DBUtil.g(this.f125114a, true, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.e3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ProfileDao_Impl.o3(string, list, size, list2, this, (SQLiteConnection) obj);
            }
        }, continuation);
    }
}
