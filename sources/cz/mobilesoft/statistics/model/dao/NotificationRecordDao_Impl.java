package cz.mobilesoft.statistics.model.dao;

import androidx.room.EntityDeleteOrUpdateAdapter;
import androidx.room.EntityInsertAdapter;
import androidx.room.EntityUpsertAdapter;
import androidx.room.RoomDatabase;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import cz.mobilesoft.statistics.model.NotificationRecord;
import cz.mobilesoft.statistics.model.dao.NotificationRecordDao_Impl;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
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
public final class NotificationRecordDao_Impl implements NotificationRecordDao {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Companion f133750f = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final RoomDatabase f133751a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final EntityInsertAdapter f133752b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final EntityDeleteOrUpdateAdapter f133753c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final EntityDeleteOrUpdateAdapter f133754d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final EntityUpsertAdapter f133755e;

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

    public NotificationRecordDao_Impl(RoomDatabase __db) {
        Intrinsics.checkNotNullParameter(__db, "__db");
        this.f133751a = __db;
        this.f133752b = new EntityInsertAdapter<NotificationRecord>() { // from class: cz.mobilesoft.statistics.model.dao.NotificationRecordDao_Impl.1
            @Override // androidx.room.EntityInsertAdapter
            protected String b() {
                return "INSERT OR REPLACE INTO `notificationRecord` (`id`,`timestamp`,`name`) VALUES (nullif(?, 0),?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertAdapter
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public void a(SQLiteStatement statement, NotificationRecord entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.A(1, entity.a());
                statement.A(2, entity.c());
                statement.p0(3, entity.b());
            }
        };
        this.f133753c = new EntityDeleteOrUpdateAdapter<NotificationRecord>() { // from class: cz.mobilesoft.statistics.model.dao.NotificationRecordDao_Impl.2
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            protected String b() {
                return "DELETE FROM `notificationRecord` WHERE `id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public void a(SQLiteStatement statement, NotificationRecord entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.A(1, entity.a());
            }
        };
        this.f133754d = new EntityDeleteOrUpdateAdapter<NotificationRecord>() { // from class: cz.mobilesoft.statistics.model.dao.NotificationRecordDao_Impl.3
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            protected String b() {
                return "UPDATE OR ABORT `notificationRecord` SET `id` = ?,`timestamp` = ?,`name` = ? WHERE `id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public void a(SQLiteStatement statement, NotificationRecord entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.A(1, entity.a());
                statement.A(2, entity.c());
                statement.p0(3, entity.b());
                statement.A(4, entity.a());
            }
        };
        this.f133755e = new EntityUpsertAdapter(new EntityInsertAdapter<NotificationRecord>() { // from class: cz.mobilesoft.statistics.model.dao.NotificationRecordDao_Impl.4
            @Override // androidx.room.EntityInsertAdapter
            protected String b() {
                return "INSERT INTO `notificationRecord` (`id`,`timestamp`,`name`) VALUES (nullif(?, 0),?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertAdapter
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public void a(SQLiteStatement statement, NotificationRecord entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.A(1, entity.a());
                statement.A(2, entity.c());
                statement.p0(3, entity.b());
            }
        }, new EntityDeleteOrUpdateAdapter<NotificationRecord>() { // from class: cz.mobilesoft.statistics.model.dao.NotificationRecordDao_Impl.5
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            protected String b() {
                return "UPDATE `notificationRecord` SET `id` = ?,`timestamp` = ?,`name` = ? WHERE `id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public void a(SQLiteStatement statement, NotificationRecord entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.A(1, entity.a());
                statement.A(2, entity.c());
                statement.p0(3, entity.b());
                statement.A(4, entity.a());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Double W(String str, long j3, long j4, List list, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        try {
            sQLiteStatementG2.A(1, j3);
            sQLiteStatementG2.A(2, j4);
            Iterator it = list.iterator();
            int i3 = 3;
            while (it.hasNext()) {
                sQLiteStatementG2.p0(i3, (String) it.next());
                i3++;
            }
            Double dValueOf = null;
            if (sQLiteStatementG2.B2() && !sQLiteStatementG2.isNull(0)) {
                dValueOf = Double.valueOf(sQLiteStatementG2.getDouble(0));
            }
            return dValueOf;
        } finally {
            sQLiteStatementG2.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Y(NotificationRecordDao_Impl notificationRecordDao_Impl, NotificationRecord notificationRecord, SQLiteConnection _connection) throws Exception {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        notificationRecordDao_Impl.f133752b.c(_connection, notificationRecord);
        return Unit.f139807a;
    }

    @Override // cz.mobilesoft.statistics.model.dao.BaseDao
    /* JADX INFO: renamed from: X, reason: merged with bridge method [inline-methods] */
    public void w(final NotificationRecord entity) {
        Intrinsics.checkNotNullParameter(entity, "entity");
        DBUtil.e(this.f133751a, false, true, new Function1() { // from class: n2.b
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return NotificationRecordDao_Impl.Y(this.f143469a, entity, (SQLiteConnection) obj);
            }
        });
    }

    @Override // cz.mobilesoft.statistics.model.dao.NotificationRecordDao
    public Double x(final List ignoredNames, final long j3, final long j4) {
        Intrinsics.checkNotNullParameter(ignoredNames, "ignoredNames");
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT AVG(count) ");
        sb.append("\n");
        sb.append("            FROM (");
        sb.append("\n");
        sb.append("                SELECT COUNT(*) AS count  ");
        sb.append("\n");
        sb.append("                FROM notificationRecord ");
        sb.append("\n");
        sb.append("                WHERE timestamp BETWEEN ");
        sb.append("?");
        sb.append(" AND ");
        sb.append("?");
        sb.append(" ");
        sb.append("\n");
        sb.append("                AND name NOT IN (");
        StringUtil.a(sb, ignoredNames.size());
        sb.append(")");
        sb.append("\n");
        sb.append("                GROUP BY DATE(timestamp, 'unixepoch', 'localtime') ");
        sb.append("\n");
        sb.append("            )");
        final String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return (Double) DBUtil.e(this.f133751a, true, false, new Function1() { // from class: n2.c
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return NotificationRecordDao_Impl.W(string, j3, j4, ignoredNames, (SQLiteConnection) obj);
            }
        });
    }
}
