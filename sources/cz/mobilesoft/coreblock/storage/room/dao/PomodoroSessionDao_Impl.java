package cz.mobilesoft.coreblock.storage.room.dao;

import androidx.room.EntityDeleteOrUpdateAdapter;
import androidx.room.EntityInsertAdapter;
import androidx.room.EntityUpsertAdapter;
import androidx.room.RoomDatabase;
import androidx.room.util.DBUtil;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import cz.mobilesoft.coreblock.storage.room.dao.PomodoroSessionDao_Impl;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.PomodoroSession;
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
public final class PomodoroSessionDao_Impl implements PomodoroSessionDao {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Companion f124814g = new Companion(null);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f124815h = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final RoomDatabase f124816a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final EntityInsertAdapter f124817b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final EntityDeleteOrUpdateAdapter f124818c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final EntityDeleteOrUpdateAdapter f124819d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final EntityUpsertAdapter f124820f;

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

    public PomodoroSessionDao_Impl(RoomDatabase __db) {
        Intrinsics.checkNotNullParameter(__db, "__db");
        this.f124816a = __db;
        this.f124817b = new EntityInsertAdapter<PomodoroSession>() { // from class: cz.mobilesoft.coreblock.storage.room.dao.PomodoroSessionDao_Impl.1
            @Override // androidx.room.EntityInsertAdapter
            protected String b() {
                return "INSERT OR REPLACE INTO `PomodoroSession` (`id`,`profileId`,`originalStartTime`,`focusTime`,`breakTime`,`sessionCount`,`isStoppedManually`,`originalEndTime`,`adjustedEndTime`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertAdapter
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public void a(SQLiteStatement statement, PomodoroSession entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.A(1, entity.l());
                statement.A(2, entity.p());
                statement.A(3, entity.o());
                statement.A(4, entity.k());
                statement.A(5, entity.g());
                statement.A(6, entity.q());
                statement.A(7, entity.v() ? 1L : 0L);
                statement.A(8, entity.n());
                statement.A(9, entity.d());
            }
        };
        this.f124818c = new EntityDeleteOrUpdateAdapter<PomodoroSession>() { // from class: cz.mobilesoft.coreblock.storage.room.dao.PomodoroSessionDao_Impl.2
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            protected String b() {
                return "DELETE FROM `PomodoroSession` WHERE `id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public void a(SQLiteStatement statement, PomodoroSession entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.A(1, entity.l());
            }
        };
        this.f124819d = new EntityDeleteOrUpdateAdapter<PomodoroSession>() { // from class: cz.mobilesoft.coreblock.storage.room.dao.PomodoroSessionDao_Impl.3
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            protected String b() {
                return "UPDATE OR ABORT `PomodoroSession` SET `id` = ?,`profileId` = ?,`originalStartTime` = ?,`focusTime` = ?,`breakTime` = ?,`sessionCount` = ?,`isStoppedManually` = ?,`originalEndTime` = ?,`adjustedEndTime` = ? WHERE `id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public void a(SQLiteStatement statement, PomodoroSession entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.A(1, entity.l());
                statement.A(2, entity.p());
                statement.A(3, entity.o());
                statement.A(4, entity.k());
                statement.A(5, entity.g());
                statement.A(6, entity.q());
                statement.A(7, entity.v() ? 1L : 0L);
                statement.A(8, entity.n());
                statement.A(9, entity.d());
                statement.A(10, entity.l());
            }
        };
        this.f124820f = new EntityUpsertAdapter(new EntityInsertAdapter<PomodoroSession>() { // from class: cz.mobilesoft.coreblock.storage.room.dao.PomodoroSessionDao_Impl.4
            @Override // androidx.room.EntityInsertAdapter
            protected String b() {
                return "INSERT INTO `PomodoroSession` (`id`,`profileId`,`originalStartTime`,`focusTime`,`breakTime`,`sessionCount`,`isStoppedManually`,`originalEndTime`,`adjustedEndTime`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertAdapter
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public void a(SQLiteStatement statement, PomodoroSession entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.A(1, entity.l());
                statement.A(2, entity.p());
                statement.A(3, entity.o());
                statement.A(4, entity.k());
                statement.A(5, entity.g());
                statement.A(6, entity.q());
                statement.A(7, entity.v() ? 1L : 0L);
                statement.A(8, entity.n());
                statement.A(9, entity.d());
            }
        }, new EntityDeleteOrUpdateAdapter<PomodoroSession>() { // from class: cz.mobilesoft.coreblock.storage.room.dao.PomodoroSessionDao_Impl.5
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            protected String b() {
                return "UPDATE `PomodoroSession` SET `id` = ?,`profileId` = ?,`originalStartTime` = ?,`focusTime` = ?,`breakTime` = ?,`sessionCount` = ?,`isStoppedManually` = ?,`originalEndTime` = ?,`adjustedEndTime` = ? WHERE `id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public void a(SQLiteStatement statement, PomodoroSession entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.A(1, entity.l());
                statement.A(2, entity.p());
                statement.A(3, entity.o());
                statement.A(4, entity.k());
                statement.A(5, entity.g());
                statement.A(6, entity.q());
                statement.A(7, entity.v() ? 1L : 0L);
                statement.A(8, entity.n());
                statement.A(9, entity.d());
                statement.A(10, entity.l());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit M(String str, SQLiteConnection _connection) {
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
    public static final long O(PomodoroSessionDao_Impl pomodoroSessionDao_Impl, PomodoroSession pomodoroSession, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        return pomodoroSessionDao_Impl.f124817b.d(_connection, pomodoroSession);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Q(PomodoroSessionDao_Impl pomodoroSessionDao_Impl, PomodoroSession pomodoroSession, SQLiteConnection _connection) throws Exception {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        pomodoroSessionDao_Impl.f124819d.c(_connection, pomodoroSession);
        return Unit.f139807a;
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.BaseDao
    /* JADX INFO: renamed from: N, reason: merged with bridge method [inline-methods] */
    public Object n(final PomodoroSession pomodoroSession, Continuation continuation) {
        return DBUtil.g(this.f124816a, false, true, new Function1() { // from class: d2.b
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Long.valueOf(PomodoroSessionDao_Impl.O(this.f134383a, pomodoroSession, (SQLiteConnection) obj));
            }
        }, continuation);
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.BaseDao
    /* JADX INFO: renamed from: P, reason: merged with bridge method [inline-methods] */
    public Object p(final PomodoroSession pomodoroSession, Continuation continuation) {
        Object objG = DBUtil.g(this.f124816a, false, true, new Function1() { // from class: d2.a
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PomodoroSessionDao_Impl.Q(this.f134381a, pomodoroSession, (SQLiteConnection) obj);
            }
        }, continuation);
        return objG == IntrinsicsKt.f() ? objG : Unit.f139807a;
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.PomodoroSessionDao
    public void b() {
        final String str = "DELETE FROM PomodoroSession";
        DBUtil.e(this.f124816a, false, true, new Function1() { // from class: d2.c
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PomodoroSessionDao_Impl.M(str, (SQLiteConnection) obj);
            }
        });
    }
}
