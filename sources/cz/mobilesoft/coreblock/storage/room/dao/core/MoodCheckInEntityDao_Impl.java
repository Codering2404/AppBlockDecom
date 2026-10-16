package cz.mobilesoft.coreblock.storage.room.dao.core;

import androidx.room.EntityDeleteOrUpdateAdapter;
import androidx.room.EntityInsertAdapter;
import androidx.room.EntityUpsertAdapter;
import androidx.room.RoomDatabase;
import androidx.room.util.DBUtil;
import androidx.room.util.SQLiteStatementUtil;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import cz.mobilesoft.coreblock.enums.MoodType;
import cz.mobilesoft.coreblock.storage.room.entity.core.MoodCheckInEntity;
import cz.mobilesoft.coreblock.storage.room.management.DateConverters;
import java.time.LocalDate;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
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
public final class MoodCheckInEntityDao_Impl extends MoodCheckInEntityDao {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Companion f126020h = new Companion(null);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f126021i = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final RoomDatabase f126022a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final EntityInsertAdapter f126023b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final MoodType.Converter f126024c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final EntityDeleteOrUpdateAdapter f126025d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final EntityDeleteOrUpdateAdapter f126026f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final EntityUpsertAdapter f126027g;

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

    public MoodCheckInEntityDao_Impl(RoomDatabase __db) {
        Intrinsics.checkNotNullParameter(__db, "__db");
        this.f126024c = new MoodType.Converter();
        this.f126022a = __db;
        this.f126023b = new EntityInsertAdapter<MoodCheckInEntity>() { // from class: cz.mobilesoft.coreblock.storage.room.dao.core.MoodCheckInEntityDao_Impl.1
            @Override // androidx.room.EntityInsertAdapter
            protected String b() {
                return "INSERT OR REPLACE INTO `MoodCheckInEntity` (`id`,`mood`,`mood_raw_value`,`day`,`created_at`,`note`) VALUES (nullif(?, 0),?,?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertAdapter
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public void a(SQLiteStatement statement, MoodCheckInEntity entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.A(1, entity.c());
                statement.A(2, MoodCheckInEntityDao_Impl.this.f126024c.b(entity.d()));
                statement.A(3, entity.e());
                String strA = DateConverters.f126712a.a(entity.b());
                if (strA == null) {
                    statement.D(4);
                } else {
                    statement.p0(4, strA);
                }
                statement.A(5, entity.a());
                String strF = entity.f();
                if (strF == null) {
                    statement.D(6);
                } else {
                    statement.p0(6, strF);
                }
            }
        };
        this.f126025d = new EntityDeleteOrUpdateAdapter<MoodCheckInEntity>() { // from class: cz.mobilesoft.coreblock.storage.room.dao.core.MoodCheckInEntityDao_Impl.2
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            protected String b() {
                return "DELETE FROM `MoodCheckInEntity` WHERE `id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public void a(SQLiteStatement statement, MoodCheckInEntity entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.A(1, entity.c());
            }
        };
        this.f126026f = new EntityDeleteOrUpdateAdapter<MoodCheckInEntity>() { // from class: cz.mobilesoft.coreblock.storage.room.dao.core.MoodCheckInEntityDao_Impl.3
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            protected String b() {
                return "UPDATE OR ABORT `MoodCheckInEntity` SET `id` = ?,`mood` = ?,`mood_raw_value` = ?,`day` = ?,`created_at` = ?,`note` = ? WHERE `id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public void a(SQLiteStatement statement, MoodCheckInEntity entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.A(1, entity.c());
                statement.A(2, MoodCheckInEntityDao_Impl.this.f126024c.b(entity.d()));
                statement.A(3, entity.e());
                String strA = DateConverters.f126712a.a(entity.b());
                if (strA == null) {
                    statement.D(4);
                } else {
                    statement.p0(4, strA);
                }
                statement.A(5, entity.a());
                String strF = entity.f();
                if (strF == null) {
                    statement.D(6);
                } else {
                    statement.p0(6, strF);
                }
                statement.A(7, entity.c());
            }
        };
        this.f126027g = new EntityUpsertAdapter(new EntityInsertAdapter<MoodCheckInEntity>() { // from class: cz.mobilesoft.coreblock.storage.room.dao.core.MoodCheckInEntityDao_Impl.4
            @Override // androidx.room.EntityInsertAdapter
            protected String b() {
                return "INSERT INTO `MoodCheckInEntity` (`id`,`mood`,`mood_raw_value`,`day`,`created_at`,`note`) VALUES (nullif(?, 0),?,?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertAdapter
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public void a(SQLiteStatement statement, MoodCheckInEntity entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.A(1, entity.c());
                statement.A(2, MoodCheckInEntityDao_Impl.this.f126024c.b(entity.d()));
                statement.A(3, entity.e());
                String strA = DateConverters.f126712a.a(entity.b());
                if (strA == null) {
                    statement.D(4);
                } else {
                    statement.p0(4, strA);
                }
                statement.A(5, entity.a());
                String strF = entity.f();
                if (strF == null) {
                    statement.D(6);
                } else {
                    statement.p0(6, strF);
                }
            }
        }, new EntityDeleteOrUpdateAdapter<MoodCheckInEntity>() { // from class: cz.mobilesoft.coreblock.storage.room.dao.core.MoodCheckInEntityDao_Impl.5
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            protected String b() {
                return "UPDATE `MoodCheckInEntity` SET `id` = ?,`mood` = ?,`mood_raw_value` = ?,`day` = ?,`created_at` = ?,`note` = ? WHERE `id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public void a(SQLiteStatement statement, MoodCheckInEntity entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.A(1, entity.c());
                statement.A(2, MoodCheckInEntityDao_Impl.this.f126024c.b(entity.d()));
                statement.A(3, entity.e());
                String strA = DateConverters.f126712a.a(entity.b());
                if (strA == null) {
                    statement.D(4);
                } else {
                    statement.p0(4, strA);
                }
                statement.A(5, entity.a());
                String strF = entity.f();
                if (strF == null) {
                    statement.D(6);
                } else {
                    statement.p0(6, strF);
                }
                statement.A(7, entity.c());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean Q(String str, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        try {
            boolean z2 = false;
            if (sQLiteStatementG2.B2()) {
                if (((int) sQLiteStatementG2.getLong(0)) != 0) {
                    z2 = true;
                }
            }
            return z2;
        } finally {
            sQLiteStatementG2.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MoodCheckInEntity R(String str, LocalDate localDate, MoodCheckInEntityDao_Impl moodCheckInEntityDao_Impl, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        try {
            DateConverters dateConverters = DateConverters.f126712a;
            String strA = dateConverters.a(localDate);
            if (strA == null) {
                sQLiteStatementG2.D(1);
            } else {
                sQLiteStatementG2.p0(1, strA);
            }
            int iD = SQLiteStatementUtil.d(sQLiteStatementG2, "id");
            int iD2 = SQLiteStatementUtil.d(sQLiteStatementG2, "mood");
            int iD3 = SQLiteStatementUtil.d(sQLiteStatementG2, "mood_raw_value");
            int iD4 = SQLiteStatementUtil.d(sQLiteStatementG2, "day");
            int iD5 = SQLiteStatementUtil.d(sQLiteStatementG2, "created_at");
            int iD6 = SQLiteStatementUtil.d(sQLiteStatementG2, "note");
            MoodCheckInEntity moodCheckInEntity = null;
            if (sQLiteStatementG2.B2()) {
                long j3 = sQLiteStatementG2.getLong(iD);
                MoodType moodTypeA = moodCheckInEntityDao_Impl.f126024c.a((int) sQLiteStatementG2.getLong(iD2));
                int i3 = (int) sQLiteStatementG2.getLong(iD3);
                LocalDate localDateB = dateConverters.b(sQLiteStatementG2.isNull(iD4) ? null : sQLiteStatementG2.f2(iD4));
                if (localDateB == null) {
                    throw new IllegalStateException("Expected NON-NULL 'java.time.LocalDate', but it was NULL.");
                }
                moodCheckInEntity = new MoodCheckInEntity(j3, moodTypeA, i3, localDateB, sQLiteStatementG2.getLong(iD5), sQLiteStatementG2.isNull(iD6) ? null : sQLiteStatementG2.f2(iD6));
            }
            sQLiteStatementG2.close();
            return moodCheckInEntity;
        } catch (Throwable th) {
            sQLiteStatementG2.close();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long T(MoodCheckInEntityDao_Impl moodCheckInEntityDao_Impl, MoodCheckInEntity moodCheckInEntity, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        return moodCheckInEntityDao_Impl.f126023b.d(_connection, moodCheckInEntity);
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.core.MoodCheckInEntityDao
    public Object J(Continuation continuation) {
        final String str = "SELECT EXISTS (SELECT 1 FROM MoodCheckInEntity LIMIT 1)";
        return DBUtil.g(this.f126022a, true, false, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.core.f1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(MoodCheckInEntityDao_Impl.Q(str, (SQLiteConnection) obj));
            }
        }, continuation);
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.core.MoodCheckInEntityDao
    public Object K(final LocalDate localDate, Continuation continuation) {
        final String str = "SELECT * FROM MoodCheckInEntity WHERE day = ? LIMIT 1";
        return DBUtil.g(this.f126022a, true, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.core.h1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MoodCheckInEntityDao_Impl.R(str, localDate, this, (SQLiteConnection) obj);
            }
        }, continuation);
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.BaseDao
    /* JADX INFO: renamed from: S, reason: merged with bridge method [inline-methods] */
    public Object n(final MoodCheckInEntity moodCheckInEntity, Continuation continuation) {
        return DBUtil.g(this.f126022a, false, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.core.g1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Long.valueOf(MoodCheckInEntityDao_Impl.T(this.f126197a, moodCheckInEntity, (SQLiteConnection) obj));
            }
        }, continuation);
    }
}
