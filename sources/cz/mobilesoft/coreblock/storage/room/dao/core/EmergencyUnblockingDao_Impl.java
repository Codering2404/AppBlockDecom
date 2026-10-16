package cz.mobilesoft.coreblock.storage.room.dao.core;

import androidx.room.EntityDeleteOrUpdateAdapter;
import androidx.room.EntityInsertAdapter;
import androidx.room.EntityUpsertAdapter;
import androidx.room.RoomDatabase;
import androidx.room.util.DBUtil;
import androidx.room.util.SQLiteStatementUtil;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import cz.mobilesoft.coreblock.storage.room.entity.core.EmergencyUnblockingEntity;
import java.util.ArrayList;
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
public final class EmergencyUnblockingDao_Impl extends EmergencyUnblockingDao {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Companion f125863g = new Companion(null);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f125864h = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final RoomDatabase f125865a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final EntityInsertAdapter f125866b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final EntityDeleteOrUpdateAdapter f125867c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final EntityDeleteOrUpdateAdapter f125868d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final EntityUpsertAdapter f125869f;

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

    public EmergencyUnblockingDao_Impl(RoomDatabase __db) {
        Intrinsics.checkNotNullParameter(__db, "__db");
        this.f125865a = __db;
        this.f125866b = new EntityInsertAdapter<EmergencyUnblockingEntity>() { // from class: cz.mobilesoft.coreblock.storage.room.dao.core.EmergencyUnblockingDao_Impl.1
            @Override // androidx.room.EntityInsertAdapter
            protected String b() {
                return "INSERT OR REPLACE INTO `EmergencyUnblocking` (`timestamp`) VALUES (?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertAdapter
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public void a(SQLiteStatement statement, EmergencyUnblockingEntity entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.A(1, entity.a());
            }
        };
        this.f125867c = new EntityDeleteOrUpdateAdapter<EmergencyUnblockingEntity>() { // from class: cz.mobilesoft.coreblock.storage.room.dao.core.EmergencyUnblockingDao_Impl.2
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            protected String b() {
                return "DELETE FROM `EmergencyUnblocking` WHERE `timestamp` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public void a(SQLiteStatement statement, EmergencyUnblockingEntity entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.A(1, entity.a());
            }
        };
        this.f125868d = new EntityDeleteOrUpdateAdapter<EmergencyUnblockingEntity>() { // from class: cz.mobilesoft.coreblock.storage.room.dao.core.EmergencyUnblockingDao_Impl.3
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            protected String b() {
                return "UPDATE OR ABORT `EmergencyUnblocking` SET `timestamp` = ? WHERE `timestamp` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public void a(SQLiteStatement statement, EmergencyUnblockingEntity entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.A(1, entity.a());
                statement.A(2, entity.a());
            }
        };
        this.f125869f = new EntityUpsertAdapter(new EntityInsertAdapter<EmergencyUnblockingEntity>() { // from class: cz.mobilesoft.coreblock.storage.room.dao.core.EmergencyUnblockingDao_Impl.4
            @Override // androidx.room.EntityInsertAdapter
            protected String b() {
                return "INSERT INTO `EmergencyUnblocking` (`timestamp`) VALUES (?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertAdapter
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public void a(SQLiteStatement statement, EmergencyUnblockingEntity entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.A(1, entity.a());
            }
        }, new EntityDeleteOrUpdateAdapter<EmergencyUnblockingEntity>() { // from class: cz.mobilesoft.coreblock.storage.room.dao.core.EmergencyUnblockingDao_Impl.5
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            protected String b() {
                return "UPDATE `EmergencyUnblocking` SET `timestamp` = ? WHERE `timestamp` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public void a(SQLiteStatement statement, EmergencyUnblockingEntity entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.A(1, entity.a());
                statement.A(2, entity.a());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long N(EmergencyUnblockingDao_Impl emergencyUnblockingDao_Impl, EmergencyUnblockingEntity emergencyUnblockingEntity, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        return emergencyUnblockingDao_Impl.f125866b.d(_connection, emergencyUnblockingEntity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List O(String str, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        try {
            int iD = SQLiteStatementUtil.d(sQLiteStatementG2, "timestamp");
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementG2.B2()) {
                arrayList.add(new EmergencyUnblockingEntity(sQLiteStatementG2.getLong(iD)));
            }
            return arrayList;
        } finally {
            sQLiteStatementG2.close();
        }
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.core.EmergencyUnblockingDao
    public Object J(Continuation continuation) {
        final String str = "SELECT * FROM EmergencyUnblocking";
        return DBUtil.g(this.f125865a, true, false, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.core.m0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return EmergencyUnblockingDao_Impl.O(str, (SQLiteConnection) obj);
            }
        }, continuation);
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.BaseDao
    /* JADX INFO: renamed from: M, reason: merged with bridge method [inline-methods] */
    public Object n(final EmergencyUnblockingEntity emergencyUnblockingEntity, Continuation continuation) {
        return DBUtil.g(this.f125865a, false, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.core.l0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Long.valueOf(EmergencyUnblockingDao_Impl.N(this.f126247a, emergencyUnblockingEntity, (SQLiteConnection) obj));
            }
        }, continuation);
    }
}
