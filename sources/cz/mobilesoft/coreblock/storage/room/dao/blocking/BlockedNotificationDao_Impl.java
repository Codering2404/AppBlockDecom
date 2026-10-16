package cz.mobilesoft.coreblock.storage.room.dao.blocking;

import androidx.collection.ArrayMap;
import androidx.paging.PagingSource;
import androidx.room.EntityDeleteOrUpdateAdapter;
import androidx.room.EntityInsertAdapter;
import androidx.room.EntityUpsertAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomRawQuery;
import androidx.room.coroutines.FlowUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.RelationUtil;
import androidx.room.util.SQLiteStatementUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import cz.mobilesoft.coreblock.scene.permission.permissions.success.lbR.YgVrd;
import cz.mobilesoft.coreblock.storage.room.dto.blocking.BlockedNotificationWithApplication;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.Application;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.BlockedNotification;
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
public final class BlockedNotificationDao_Impl extends BlockedNotificationDao {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Companion f124976g = new Companion(null);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f124977h = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final RoomDatabase f124978a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final EntityInsertAdapter f124979b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final EntityDeleteOrUpdateAdapter f124980c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final EntityDeleteOrUpdateAdapter f124981d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final EntityUpsertAdapter f124982f;

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

    public BlockedNotificationDao_Impl(RoomDatabase __db) {
        Intrinsics.checkNotNullParameter(__db, "__db");
        this.f124978a = __db;
        this.f124979b = new EntityInsertAdapter<BlockedNotification>() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.BlockedNotificationDao_Impl.1
            @Override // androidx.room.EntityInsertAdapter
            protected String b() {
                return "INSERT OR REPLACE INTO `BlockedNotification` (`id`,`packageName`,`timestamp`,`profileId`,`title`,`message`) VALUES (nullif(?, 0),?,?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertAdapter
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public void a(SQLiteStatement statement, BlockedNotification entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.A(1, entity.a());
                statement.p0(2, entity.c());
                statement.A(3, entity.e());
                statement.A(4, entity.d());
                String strF = entity.f();
                if (strF == null) {
                    statement.D(5);
                } else {
                    statement.p0(5, strF);
                }
                String strB = entity.b();
                if (strB == null) {
                    statement.D(6);
                } else {
                    statement.p0(6, strB);
                }
            }
        };
        this.f124980c = new EntityDeleteOrUpdateAdapter<BlockedNotification>() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.BlockedNotificationDao_Impl.2
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            protected String b() {
                return "DELETE FROM `BlockedNotification` WHERE `id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public void a(SQLiteStatement statement, BlockedNotification entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.A(1, entity.a());
            }
        };
        this.f124981d = new EntityDeleteOrUpdateAdapter<BlockedNotification>() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.BlockedNotificationDao_Impl.3
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            protected String b() {
                return "UPDATE OR ABORT `BlockedNotification` SET `id` = ?,`packageName` = ?,`timestamp` = ?,`profileId` = ?,`title` = ?,`message` = ? WHERE `id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public void a(SQLiteStatement statement, BlockedNotification entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.A(1, entity.a());
                statement.p0(2, entity.c());
                statement.A(3, entity.e());
                statement.A(4, entity.d());
                String strF = entity.f();
                if (strF == null) {
                    statement.D(5);
                } else {
                    statement.p0(5, strF);
                }
                String strB = entity.b();
                if (strB == null) {
                    statement.D(6);
                } else {
                    statement.p0(6, strB);
                }
                statement.A(7, entity.a());
            }
        };
        this.f124982f = new EntityUpsertAdapter(new EntityInsertAdapter<BlockedNotification>() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.BlockedNotificationDao_Impl.4
            @Override // androidx.room.EntityInsertAdapter
            protected String b() {
                return "INSERT INTO `BlockedNotification` (`id`,`packageName`,`timestamp`,`profileId`,`title`,`message`) VALUES (nullif(?, 0),?,?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertAdapter
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public void a(SQLiteStatement statement, BlockedNotification entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.A(1, entity.a());
                statement.p0(2, entity.c());
                statement.A(3, entity.e());
                statement.A(4, entity.d());
                String strF = entity.f();
                if (strF == null) {
                    statement.D(5);
                } else {
                    statement.p0(5, strF);
                }
                String strB = entity.b();
                if (strB == null) {
                    statement.D(6);
                } else {
                    statement.p0(6, strB);
                }
            }
        }, new EntityDeleteOrUpdateAdapter<BlockedNotification>() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.BlockedNotificationDao_Impl.5
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            protected String b() {
                return "UPDATE `BlockedNotification` SET `id` = ?,`packageName` = ?,`timestamp` = ?,`profileId` = ?,`title` = ?,`message` = ? WHERE `id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public void a(SQLiteStatement statement, BlockedNotification entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.A(1, entity.a());
                statement.p0(2, entity.c());
                statement.A(3, entity.e());
                statement.A(4, entity.d());
                String strF = entity.f();
                if (strF == null) {
                    statement.D(5);
                } else {
                    statement.p0(5, strF);
                }
                String strB = entity.b();
                if (strB == null) {
                    statement.D(6);
                } else {
                    statement.p0(6, strB);
                }
                statement.A(7, entity.a());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void W(final SQLiteConnection sQLiteConnection, ArrayMap arrayMap) {
        Set setKeySet = arrayMap.keySet();
        if (setKeySet.isEmpty()) {
            return;
        }
        if (arrayMap.size() > 999) {
            RelationUtil.a(arrayMap, false, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.f1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return BlockedNotificationDao_Impl.X(this.f125423a, sQLiteConnection, (ArrayMap) obj);
                }
            });
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT `packageName`,`label`,`labelForSearch`,`isUninstalled`,`appCategories` FROM `Application` WHERE `packageName` IN (");
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
                    arrayMap.put(strF2, new Application(sQLiteStatementG2.f2(0), sQLiteStatementG2.f2(1), sQLiteStatementG2.f2(2), ((int) sQLiteStatementG2.getLong(3)) != 0, sQLiteStatementG2.isNull(4) ? null : Integer.valueOf((int) sQLiteStatementG2.getLong(4))));
                }
            }
        } finally {
            sQLiteStatementG2.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit X(BlockedNotificationDao_Impl blockedNotificationDao_Impl, SQLiteConnection sQLiteConnection, ArrayMap _tmpMap) {
        Intrinsics.checkNotNullParameter(_tmpMap, "_tmpMap");
        blockedNotificationDao_Impl.W(sQLiteConnection, _tmpMap);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit b0(String str, SQLiteConnection _connection) {
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
    public static final List c0(String str, long j3, long j4, BlockedNotificationDao_Impl blockedNotificationDao_Impl, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        try {
            sQLiteStatementG2.A(1, j3);
            sQLiteStatementG2.A(2, j4);
            ArrayMap arrayMap = new ArrayMap();
            while (sQLiteStatementG2.B2()) {
                arrayMap.put(sQLiteStatementG2.f2(1), null);
            }
            sQLiteStatementG2.reset();
            blockedNotificationDao_Impl.W(_connection, arrayMap);
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementG2.B2()) {
                arrayList.add(new BlockedNotificationWithApplication(new BlockedNotification(sQLiteStatementG2.getLong(0), sQLiteStatementG2.f2(1), sQLiteStatementG2.getLong(2), sQLiteStatementG2.getLong(3), sQLiteStatementG2.isNull(4) ? null : sQLiteStatementG2.f2(4), sQLiteStatementG2.isNull(5) ? null : sQLiteStatementG2.f2(5)), (Application) arrayMap.get(sQLiteStatementG2.f2(1)), null));
            }
            sQLiteStatementG2.close();
            return arrayList;
        } catch (Throwable th) {
            sQLiteStatementG2.close();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List d0(String str, int i3, BlockedNotificationDao_Impl blockedNotificationDao_Impl, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        try {
            sQLiteStatementG2.A(1, i3);
            ArrayMap arrayMap = new ArrayMap();
            while (sQLiteStatementG2.B2()) {
                arrayMap.put(sQLiteStatementG2.f2(1), null);
            }
            sQLiteStatementG2.reset();
            blockedNotificationDao_Impl.W(_connection, arrayMap);
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementG2.B2()) {
                arrayList.add(new BlockedNotificationWithApplication(new BlockedNotification(sQLiteStatementG2.getLong(0), sQLiteStatementG2.f2(1), sQLiteStatementG2.getLong(2), sQLiteStatementG2.getLong(3), sQLiteStatementG2.isNull(4) ? null : sQLiteStatementG2.f2(4), sQLiteStatementG2.isNull(5) ? null : sQLiteStatementG2.f2(5)), (Application) arrayMap.get(sQLiteStatementG2.f2(1)), null));
            }
            sQLiteStatementG2.close();
            return arrayList;
        } catch (Throwable th) {
            sQLiteStatementG2.close();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long f0(BlockedNotificationDao_Impl blockedNotificationDao_Impl, BlockedNotification blockedNotification, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        return blockedNotificationDao_Impl.f124979b.d(_connection, blockedNotification);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List g0(BlockedNotificationDao_Impl blockedNotificationDao_Impl, Collection collection, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        return blockedNotificationDao_Impl.f124979b.e(_connection, collection);
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.blocking.BlockedNotificationDao
    public Object K(final long j3, final long j4, Continuation continuation) {
        final String str = "\n            SELECT b.id, b.packageName, b.timestamp, b.profileId, b.title, b.message, a.packageName, a.label, a.labelForSearch\n            FROM BlockedNotification b \n            LEFT JOIN Application a ON b.packageName = a.packageName \n            WHERE b.profileId = ? AND b.timestamp >= ? \n            ORDER BY b.timestamp DESC\n            ";
        return DBUtil.g(this.f124978a, true, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.e1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BlockedNotificationDao_Impl.c0(str, j3, j4, this, (SQLiteConnection) obj);
            }
        }, continuation);
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.blocking.BlockedNotificationDao
    public Flow L(final int i3) {
        final String str = "\n            SELECT b.id, b.packageName, b.timestamp, b.profileId, b.title, b.message, a.packageName, a.label, a.labelForSearch\n            FROM BlockedNotification b \n            LEFT JOIN Application a ON b.packageName = a.packageName \n            ORDER BY b.timestamp DESC \n            LIMIT ?\n            ";
        return FlowUtil.a(this.f124978a, true, new String[]{"Application", "BlockedNotification"}, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.c1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BlockedNotificationDao_Impl.d0(str, i3, this, (SQLiteConnection) obj);
            }
        });
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.blocking.BlockedNotificationDao
    public Object N(long j3, long j4, Continuation continuation) {
        return DBUtil.f(this.f124978a, new BlockedNotificationDao_Impl$getAppNamesSeparateByComma$2(this, j3, j4, null), continuation);
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.blocking.BlockedNotificationDao
    public Object deleteAll(Continuation continuation) {
        final String str = "DELETE FROM BlockedNotification";
        Object objG = DBUtil.g(this.f124978a, false, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.a1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BlockedNotificationDao_Impl.b0(str, (SQLiteConnection) obj);
            }
        }, continuation);
        return objG == IntrinsicsKt.f() ? objG : Unit.f139807a;
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.BaseDao
    /* JADX INFO: renamed from: e0, reason: merged with bridge method [inline-methods] */
    public Object n(final BlockedNotification blockedNotification, Continuation continuation) {
        return DBUtil.g(this.f124978a, false, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.b1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Long.valueOf(BlockedNotificationDao_Impl.f0(this.f125351a, blockedNotification, (SQLiteConnection) obj));
            }
        }, continuation);
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.BaseDao
    public Object t(final Collection collection, Continuation continuation) {
        return DBUtil.g(this.f124978a, false, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.d1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BlockedNotificationDao_Impl.g0(this.f125384a, collection, (SQLiteConnection) obj);
            }
        }, continuation);
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.blocking.BlockedNotificationDao
    public PagingSource M() {
        return new BlockedNotificationDao_Impl$getAllPaged$1(new RoomRawQuery("\n            SELECT b.id, b.packageName, b.timestamp, b.profileId, b.title, b.message, a.packageName, a.label, a.labelForSearch, COUNT(b.id) as totalCount \n            FROM BlockedNotification b \n            LEFT JOIN Application a ON b.packageName = a.packageName \n            GROUP BY b.packageName, b.title, b.message \n            ORDER BY b.timestamp DESC\n            ", null, 2, null), this, this.f124978a, new String[]{YgVrd.qWMJfw, "BlockedNotification"});
    }
}
