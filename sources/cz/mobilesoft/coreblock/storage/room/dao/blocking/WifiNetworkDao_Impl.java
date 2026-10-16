package cz.mobilesoft.coreblock.storage.room.dao.blocking;

import androidx.room.EntityDeleteOrUpdateAdapter;
import androidx.room.EntityInsertAdapter;
import androidx.room.EntityUpsertAdapter;
import androidx.room.RoomDatabase;
import androidx.room.util.DBUtil;
import androidx.room.util.SQLiteStatementUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.WifiNetwork;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
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
public final class WifiNetworkDao_Impl extends WifiNetworkDao {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Companion f125325g = new Companion(null);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f125326h = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final RoomDatabase f125327a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final EntityInsertAdapter f125328b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final EntityDeleteOrUpdateAdapter f125329c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final EntityDeleteOrUpdateAdapter f125330d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final EntityUpsertAdapter f125331f;

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

    public WifiNetworkDao_Impl(RoomDatabase __db) {
        Intrinsics.checkNotNullParameter(__db, "__db");
        this.f125327a = __db;
        this.f125328b = new EntityInsertAdapter<WifiNetwork>() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.WifiNetworkDao_Impl.1
            @Override // androidx.room.EntityInsertAdapter
            protected String b() {
                return "INSERT OR REPLACE INTO `WifiNetwork` (`id`,`profileId`,`ssid`) VALUES (nullif(?, 0),?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertAdapter
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public void a(SQLiteStatement statement, WifiNetwork entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.A(1, entity.a());
                statement.A(2, entity.b());
                statement.p0(3, entity.c());
            }
        };
        this.f125329c = new EntityDeleteOrUpdateAdapter<WifiNetwork>() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.WifiNetworkDao_Impl.2
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            protected String b() {
                return "DELETE FROM `WifiNetwork` WHERE `id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public void a(SQLiteStatement statement, WifiNetwork entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.A(1, entity.a());
            }
        };
        this.f125330d = new EntityDeleteOrUpdateAdapter<WifiNetwork>() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.WifiNetworkDao_Impl.3
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            protected String b() {
                return "UPDATE OR ABORT `WifiNetwork` SET `id` = ?,`profileId` = ?,`ssid` = ? WHERE `id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public void a(SQLiteStatement statement, WifiNetwork entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.A(1, entity.a());
                statement.A(2, entity.b());
                statement.p0(3, entity.c());
                statement.A(4, entity.a());
            }
        };
        this.f125331f = new EntityUpsertAdapter(new EntityInsertAdapter<WifiNetwork>() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.WifiNetworkDao_Impl.4
            @Override // androidx.room.EntityInsertAdapter
            protected String b() {
                return "INSERT INTO `WifiNetwork` (`id`,`profileId`,`ssid`) VALUES (nullif(?, 0),?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertAdapter
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public void a(SQLiteStatement statement, WifiNetwork entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.A(1, entity.a());
                statement.A(2, entity.b());
                statement.p0(3, entity.c());
            }
        }, new EntityDeleteOrUpdateAdapter<WifiNetwork>() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.WifiNetworkDao_Impl.5
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            protected String b() {
                return "UPDATE `WifiNetwork` SET `id` = ?,`profileId` = ?,`ssid` = ? WHERE `id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public void a(SQLiteStatement statement, WifiNetwork entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.A(1, entity.a());
                statement.A(2, entity.b());
                statement.p0(3, entity.c());
                statement.A(4, entity.a());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit U(WifiNetworkDao_Impl wifiNetworkDao_Impl, List list, SQLiteConnection _connection) throws Exception {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        wifiNetworkDao_Impl.f125329c.d(_connection, list);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit V(String str, Collection collection, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        try {
            Iterator it = collection.iterator();
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
    public static final List W(String str, long j3, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        try {
            sQLiteStatementG2.A(1, j3);
            int iD = SQLiteStatementUtil.d(sQLiteStatementG2, "id");
            int iD2 = SQLiteStatementUtil.d(sQLiteStatementG2, "profileId");
            int iD3 = SQLiteStatementUtil.d(sQLiteStatementG2, "ssid");
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementG2.B2()) {
                arrayList.add(new WifiNetwork(sQLiteStatementG2.getLong(iD), sQLiteStatementG2.getLong(iD2), sQLiteStatementG2.f2(iD3)));
            }
            return arrayList;
        } finally {
            sQLiteStatementG2.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List X(String str, Collection collection, SQLiteConnection _connection) {
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
            int iD2 = SQLiteStatementUtil.d(sQLiteStatementG2, "profileId");
            int iD3 = SQLiteStatementUtil.d(sQLiteStatementG2, "ssid");
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementG2.B2()) {
                arrayList.add(new WifiNetwork(sQLiteStatementG2.getLong(iD), sQLiteStatementG2.getLong(iD2), sQLiteStatementG2.f2(iD3)));
            }
            sQLiteStatementG2.close();
            return arrayList;
        } catch (Throwable th) {
            sQLiteStatementG2.close();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List Y(String str, String str2, String str3, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        try {
            sQLiteStatementG2.p0(1, str2);
            sQLiteStatementG2.p0(2, str3);
            int iD = SQLiteStatementUtil.d(sQLiteStatementG2, "id");
            int iD2 = SQLiteStatementUtil.d(sQLiteStatementG2, "profileId");
            int iD3 = SQLiteStatementUtil.d(sQLiteStatementG2, "ssid");
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementG2.B2()) {
                arrayList.add(new WifiNetwork(sQLiteStatementG2.getLong(iD), sQLiteStatementG2.getLong(iD2), sQLiteStatementG2.f2(iD3)));
            }
            return arrayList;
        } finally {
            sQLiteStatementG2.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List Z(WifiNetworkDao_Impl wifiNetworkDao_Impl, Collection collection, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        return wifiNetworkDao_Impl.f125328b.e(_connection, collection);
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.blocking.WifiNetworkDao
    public Object J(final Collection collection, Continuation continuation) {
        StringBuilder sb = new StringBuilder();
        sb.append("DELETE FROM WifiNetwork WHERE profileId IN (");
        StringUtil.a(sb, collection.size());
        sb.append(")");
        final String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        Object objG = DBUtil.g(this.f125327a, false, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.p6
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return WifiNetworkDao_Impl.V(string, collection, (SQLiteConnection) obj);
            }
        }, continuation);
        return objG == IntrinsicsKt.f() ? objG : Unit.f139807a;
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.blocking.WifiNetworkDao
    public Object K(final long j3, Continuation continuation) {
        final String str = "SELECT * FROM WifiNetwork WHERE profileId = ?";
        return DBUtil.g(this.f125327a, true, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.q6
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return WifiNetworkDao_Impl.W(str, j3, (SQLiteConnection) obj);
            }
        }, continuation);
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.blocking.WifiNetworkDao
    public Object L(final Collection collection, Continuation continuation) {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT * FROM WifiNetwork WHERE profileId IN (");
        StringUtil.a(sb, collection.size());
        sb.append(")");
        final String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return DBUtil.g(this.f125327a, true, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.o6
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return WifiNetworkDao_Impl.X(string, collection, (SQLiteConnection) obj);
            }
        }, continuation);
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.blocking.WifiNetworkDao
    public Object N(final String str, final String str2, Continuation continuation) {
        final String str3 = "SELECT * FROM WifiNetwork WHERE ssid LIKE ? OR ssid LIKE ?";
        return DBUtil.g(this.f125327a, true, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.s6
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return WifiNetworkDao_Impl.Y(str3, str, str2, (SQLiteConnection) obj);
            }
        }, continuation);
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.BaseDao
    public Object h(final List list, Continuation continuation) {
        Object objG = DBUtil.g(this.f125327a, false, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.n6
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return WifiNetworkDao_Impl.U(this.f125569a, list, (SQLiteConnection) obj);
            }
        }, continuation);
        return objG == IntrinsicsKt.f() ? objG : Unit.f139807a;
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.BaseDao
    public Object t(final Collection collection, Continuation continuation) {
        return DBUtil.g(this.f125327a, false, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.r6
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return WifiNetworkDao_Impl.Z(this.f125640a, collection, (SQLiteConnection) obj);
            }
        }, continuation);
    }
}
