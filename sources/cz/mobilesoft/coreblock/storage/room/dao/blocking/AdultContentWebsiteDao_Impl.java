package cz.mobilesoft.coreblock.storage.room.dao.blocking;

import androidx.room.EntityDeleteOrUpdateAdapter;
import androidx.room.EntityInsertAdapter;
import androidx.room.EntityUpsertAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomRawQuery;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.DBUtil;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import androidx.sqlite.db.SupportSQLiteQuery;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.AdultContentWebsite;
import cz.mobilesoft.coreblock.storage.room.management.BlockingDatabase;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class AdultContentWebsiteDao_Impl extends AdultContentWebsiteDao {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Companion f124832g = new Companion(null);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f124833h = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final RoomDatabase f124834a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final EntityInsertAdapter f124835b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final EntityDeleteOrUpdateAdapter f124836c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final EntityDeleteOrUpdateAdapter f124837d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final EntityUpsertAdapter f124838f;

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

    public AdultContentWebsiteDao_Impl(RoomDatabase __db) {
        Intrinsics.checkNotNullParameter(__db, "__db");
        this.f124834a = __db;
        this.f124835b = new EntityInsertAdapter<AdultContentWebsite>() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.AdultContentWebsiteDao_Impl.1
            @Override // androidx.room.EntityInsertAdapter
            protected String b() {
                return "INSERT OR REPLACE INTO `AdultContentWebsite` (`url`) VALUES (?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertAdapter
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public void a(SQLiteStatement statement, AdultContentWebsite entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.p0(1, entity.a());
            }
        };
        this.f124836c = new EntityDeleteOrUpdateAdapter<AdultContentWebsite>() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.AdultContentWebsiteDao_Impl.2
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            protected String b() {
                return "DELETE FROM `AdultContentWebsite` WHERE `url` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public void a(SQLiteStatement statement, AdultContentWebsite entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.p0(1, entity.a());
            }
        };
        this.f124837d = new EntityDeleteOrUpdateAdapter<AdultContentWebsite>() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.AdultContentWebsiteDao_Impl.3
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            protected String b() {
                return "UPDATE OR ABORT `AdultContentWebsite` SET `url` = ? WHERE `url` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public void a(SQLiteStatement statement, AdultContentWebsite entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.p0(1, entity.a());
                statement.p0(2, entity.a());
            }
        };
        this.f124838f = new EntityUpsertAdapter(new EntityInsertAdapter<AdultContentWebsite>() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.AdultContentWebsiteDao_Impl.4
            @Override // androidx.room.EntityInsertAdapter
            protected String b() {
                return "INSERT INTO `AdultContentWebsite` (`url`) VALUES (?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertAdapter
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public void a(SQLiteStatement statement, AdultContentWebsite entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.p0(1, entity.a());
            }
        }, new EntityDeleteOrUpdateAdapter<AdultContentWebsite>() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.AdultContentWebsiteDao_Impl.5
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            protected String b() {
                return "UPDATE `AdultContentWebsite` SET `url` = ? WHERE `url` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public void a(SQLiteStatement statement, AdultContentWebsite entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.p0(1, entity.a());
                statement.p0(2, entity.a());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long V(String str, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        try {
            return sQLiteStatementG2.B2() ? sQLiteStatementG2.getLong(0) : 0L;
        } finally {
            sQLiteStatementG2.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit W(AdultContentWebsiteDao_Impl adultContentWebsiteDao_Impl, List list, SQLiteConnection _connection) throws Exception {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        adultContentWebsiteDao_Impl.f124836c.d(_connection, list);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit X(String str, SQLiteConnection _connection) {
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
    public static final Long Y(String str, RoomRawQuery roomRawQuery, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        try {
            roomRawQuery.e().invoke(sQLiteStatementG2);
            Long lValueOf = null;
            if (sQLiteStatementG2.B2() && !sQLiteStatementG2.isNull(0)) {
                lValueOf = Long.valueOf(sQLiteStatementG2.getLong(0));
            }
            return lValueOf;
        } finally {
            sQLiteStatementG2.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean Z(String str, String str2, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        try {
            sQLiteStatementG2.p0(1, str2);
            sQLiteStatementG2.p0(2, str2);
            sQLiteStatementG2.p0(3, str2);
            sQLiteStatementG2.p0(4, str2);
            sQLiteStatementG2.p0(5, str2);
            sQLiteStatementG2.p0(6, str2);
            boolean z2 = false;
            if (sQLiteStatementG2.B2()) {
                z2 = ((int) sQLiteStatementG2.getLong(0)) != 0;
            }
            return z2;
        } finally {
            sQLiteStatementG2.close();
        }
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.blocking.AdultContentWebsiteDao
    public Object J(Continuation continuation) {
        final String str = "SELECT COUNT(*) FROM AdultContentWebsite";
        return DBUtil.g(this.f124834a, true, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.b
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Long.valueOf(AdultContentWebsiteDao_Impl.V(str, (SQLiteConnection) obj));
            }
        }, continuation);
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.blocking.AdultContentWebsiteDao
    public Object K(SupportSQLiteQuery supportSQLiteQuery, Continuation continuation) {
        final RoomRawQuery roomRawQueryN = RoomSQLiteQuery.f52354j.b(supportSQLiteQuery).n();
        final String strF = roomRawQueryN.f();
        return DBUtil.g(this.f124834a, true, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.e
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return AdultContentWebsiteDao_Impl.Y(strF, roomRawQueryN, (SQLiteConnection) obj);
            }
        }, continuation);
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.blocking.AdultContentWebsiteDao
    public Object M(final String str, Continuation continuation) {
        final String str2 = "SELECT EXISTS (SELECT * FROM AdultContentWebsite WHERE (TRIM(url, 'www.')) = (    -- Extract the core domain from the given URL\n    CASE         WHEN ? LIKE '%.%.%' THEN             SUBSTR(?, INSTR(?, '.') + 1)         ELSE ?    END )  -- Check if subdomain exists\n OR TRIM(url, 'www.') = ?-- Excluding new tabs and our local html page\nAND ? NOT IN ('search', 'content'))";
        return DBUtil.g(this.f124834a, true, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.a
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(AdultContentWebsiteDao_Impl.Z(str2, str, (SQLiteConnection) obj));
            }
        }, continuation);
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.blocking.AdultContentWebsiteDao
    public Object N(BlockingDatabase blockingDatabase, List list, List list2, List list3, Continuation continuation) {
        Object objF = DBUtil.f(this.f124834a, new AdultContentWebsiteDao_Impl$updateAll$2(this, blockingDatabase, list, list2, list3, null), continuation);
        return objF == IntrinsicsKt.f() ? objF : Unit.f139807a;
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.blocking.AdultContentWebsiteDao
    public Object deleteAll(Continuation continuation) {
        final String str = "DELETE FROM AdultContentWebsite";
        Object objG = DBUtil.g(this.f124834a, false, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.c
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return AdultContentWebsiteDao_Impl.X(str, (SQLiteConnection) obj);
            }
        }, continuation);
        return objG == IntrinsicsKt.f() ? objG : Unit.f139807a;
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.BaseDao
    public Object h(final List list, Continuation continuation) {
        Object objG = DBUtil.g(this.f124834a, false, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.d
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return AdultContentWebsiteDao_Impl.W(this.f125382a, list, (SQLiteConnection) obj);
            }
        }, continuation);
        return objG == IntrinsicsKt.f() ? objG : Unit.f139807a;
    }
}
