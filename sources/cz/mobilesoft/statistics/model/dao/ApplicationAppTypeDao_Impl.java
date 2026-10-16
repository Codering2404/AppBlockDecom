package cz.mobilesoft.statistics.model.dao;

import androidx.room.EntityDeleteOrUpdateAdapter;
import androidx.room.EntityInsertAdapter;
import androidx.room.EntityUpsertAdapter;
import androidx.room.RoomDatabase;
import androidx.room.util.DBUtil;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import cz.mobilesoft.statistics.model.ApplicationAppType;
import cz.mobilesoft.statistics.model.dao.ApplicationAppTypeDao_Impl;
import java.util.List;
import kotlin.Metadata;
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
public final class ApplicationAppTypeDao_Impl implements ApplicationAppTypeDao {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Companion f133744f = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final RoomDatabase f133745a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final EntityInsertAdapter f133746b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final EntityDeleteOrUpdateAdapter f133747c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final EntityDeleteOrUpdateAdapter f133748d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final EntityUpsertAdapter f133749e;

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

    public ApplicationAppTypeDao_Impl(RoomDatabase __db) {
        Intrinsics.checkNotNullParameter(__db, "__db");
        this.f133745a = __db;
        this.f133746b = new EntityInsertAdapter<ApplicationAppType>() { // from class: cz.mobilesoft.statistics.model.dao.ApplicationAppTypeDao_Impl.1
            @Override // androidx.room.EntityInsertAdapter
            protected String b() {
                return "INSERT OR REPLACE INTO `applicationAppType` (`packageName`,`appDistractionType`) VALUES (?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertAdapter
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public void a(SQLiteStatement statement, ApplicationAppType entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.p0(1, entity.b());
                statement.p0(2, entity.a());
            }
        };
        this.f133747c = new EntityDeleteOrUpdateAdapter<ApplicationAppType>() { // from class: cz.mobilesoft.statistics.model.dao.ApplicationAppTypeDao_Impl.2
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            protected String b() {
                return "DELETE FROM `applicationAppType` WHERE `packageName` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public void a(SQLiteStatement statement, ApplicationAppType entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.p0(1, entity.b());
            }
        };
        this.f133748d = new EntityDeleteOrUpdateAdapter<ApplicationAppType>() { // from class: cz.mobilesoft.statistics.model.dao.ApplicationAppTypeDao_Impl.3
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            protected String b() {
                return "UPDATE OR ABORT `applicationAppType` SET `packageName` = ?,`appDistractionType` = ? WHERE `packageName` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public void a(SQLiteStatement statement, ApplicationAppType entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.p0(1, entity.b());
                statement.p0(2, entity.a());
                statement.p0(3, entity.b());
            }
        };
        this.f133749e = new EntityUpsertAdapter(new EntityInsertAdapter<ApplicationAppType>() { // from class: cz.mobilesoft.statistics.model.dao.ApplicationAppTypeDao_Impl.4
            @Override // androidx.room.EntityInsertAdapter
            protected String b() {
                return "INSERT INTO `applicationAppType` (`packageName`,`appDistractionType`) VALUES (?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertAdapter
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public void a(SQLiteStatement statement, ApplicationAppType entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.p0(1, entity.b());
                statement.p0(2, entity.a());
            }
        }, new EntityDeleteOrUpdateAdapter<ApplicationAppType>() { // from class: cz.mobilesoft.statistics.model.dao.ApplicationAppTypeDao_Impl.5
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            protected String b() {
                return "UPDATE `applicationAppType` SET `packageName` = ?,`appDistractionType` = ? WHERE `packageName` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public void a(SQLiteStatement statement, ApplicationAppType entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.p0(1, entity.b());
                statement.p0(2, entity.a());
                statement.p0(3, entity.b());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long W(ApplicationAppTypeDao_Impl applicationAppTypeDao_Impl, ApplicationAppType applicationAppType, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        return applicationAppTypeDao_Impl.f133749e.b(_connection, applicationAppType);
    }

    @Override // cz.mobilesoft.statistics.model.dao.BaseDao
    /* JADX INFO: renamed from: V, reason: merged with bridge method [inline-methods] */
    public long i(final ApplicationAppType entity) {
        Intrinsics.checkNotNullParameter(entity, "entity");
        return ((Number) DBUtil.e(this.f133745a, false, true, new Function1() { // from class: n2.a
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Long.valueOf(ApplicationAppTypeDao_Impl.W(this.f143465a, entity, (SQLiteConnection) obj));
            }
        })).longValue();
    }
}
