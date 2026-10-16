package cz.mobilesoft.coreblock.storage.room.dao.core;

import androidx.room.EntityDeleteOrUpdateAdapter;
import androidx.room.EntityInsertAdapter;
import androidx.room.EntityUpsertAdapter;
import androidx.room.RoomDatabase;
import androidx.room.coroutines.FlowUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.SQLiteStatementUtil;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import cz.mobilesoft.coreblock.storage.room.entity.core.ConfigType;
import cz.mobilesoft.coreblock.storage.room.entity.core.CustomBlockingScreenConfigEntity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
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
public final class CustomBlockingScreenConfigDao_Impl extends CustomBlockingScreenConfigDao {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Companion f125848h = new Companion(null);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f125849i = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final RoomDatabase f125850a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final EntityInsertAdapter f125851b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ConfigType.Converter f125852c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final EntityDeleteOrUpdateAdapter f125853d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final EntityDeleteOrUpdateAdapter f125854f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final EntityUpsertAdapter f125855g;

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

    public CustomBlockingScreenConfigDao_Impl(RoomDatabase __db) {
        Intrinsics.checkNotNullParameter(__db, "__db");
        this.f125852c = new ConfigType.Converter();
        this.f125850a = __db;
        this.f125851b = new EntityInsertAdapter<CustomBlockingScreenConfigEntity>() { // from class: cz.mobilesoft.coreblock.storage.room.dao.core.CustomBlockingScreenConfigDao_Impl.1
            @Override // androidx.room.EntityInsertAdapter
            protected String b() {
                return "INSERT OR REPLACE INTO `BlockingConfig` (`id`,`config_type`,`blocking_message`,`show_reason`,`timeout_seconds`,`show_counter`,`icon_res`,`custom_title`,`custom_subtitle`,`custom_exit_button_text`,`custom_color_hex`) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertAdapter
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public void a(SQLiteStatement statement, CustomBlockingScreenConfigEntity entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.p0(1, entity.i());
                statement.A(2, CustomBlockingScreenConfigDao_Impl.this.f125852c.b(entity.m()));
                statement.p0(3, entity.c());
                statement.A(4, entity.j() ? 1L : 0L);
                statement.A(5, entity.l());
                statement.A(6, entity.k() ? 1L : 0L);
                statement.A(7, entity.h());
                statement.p0(8, entity.g());
                statement.p0(9, entity.f());
                statement.p0(10, entity.e());
                statement.p0(11, entity.d());
            }
        };
        this.f125853d = new EntityDeleteOrUpdateAdapter<CustomBlockingScreenConfigEntity>() { // from class: cz.mobilesoft.coreblock.storage.room.dao.core.CustomBlockingScreenConfigDao_Impl.2
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            protected String b() {
                return "DELETE FROM `BlockingConfig` WHERE `id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public void a(SQLiteStatement statement, CustomBlockingScreenConfigEntity entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.p0(1, entity.i());
            }
        };
        this.f125854f = new EntityDeleteOrUpdateAdapter<CustomBlockingScreenConfigEntity>() { // from class: cz.mobilesoft.coreblock.storage.room.dao.core.CustomBlockingScreenConfigDao_Impl.3
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            protected String b() {
                return "UPDATE OR ABORT `BlockingConfig` SET `id` = ?,`config_type` = ?,`blocking_message` = ?,`show_reason` = ?,`timeout_seconds` = ?,`show_counter` = ?,`icon_res` = ?,`custom_title` = ?,`custom_subtitle` = ?,`custom_exit_button_text` = ?,`custom_color_hex` = ? WHERE `id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public void a(SQLiteStatement statement, CustomBlockingScreenConfigEntity entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.p0(1, entity.i());
                statement.A(2, CustomBlockingScreenConfigDao_Impl.this.f125852c.b(entity.m()));
                statement.p0(3, entity.c());
                statement.A(4, entity.j() ? 1L : 0L);
                statement.A(5, entity.l());
                statement.A(6, entity.k() ? 1L : 0L);
                statement.A(7, entity.h());
                statement.p0(8, entity.g());
                statement.p0(9, entity.f());
                statement.p0(10, entity.e());
                statement.p0(11, entity.d());
                statement.p0(12, entity.i());
            }
        };
        this.f125855g = new EntityUpsertAdapter(new EntityInsertAdapter<CustomBlockingScreenConfigEntity>() { // from class: cz.mobilesoft.coreblock.storage.room.dao.core.CustomBlockingScreenConfigDao_Impl.4
            @Override // androidx.room.EntityInsertAdapter
            protected String b() {
                return "INSERT INTO `BlockingConfig` (`id`,`config_type`,`blocking_message`,`show_reason`,`timeout_seconds`,`show_counter`,`icon_res`,`custom_title`,`custom_subtitle`,`custom_exit_button_text`,`custom_color_hex`) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertAdapter
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public void a(SQLiteStatement statement, CustomBlockingScreenConfigEntity entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.p0(1, entity.i());
                statement.A(2, CustomBlockingScreenConfigDao_Impl.this.f125852c.b(entity.m()));
                statement.p0(3, entity.c());
                statement.A(4, entity.j() ? 1L : 0L);
                statement.A(5, entity.l());
                statement.A(6, entity.k() ? 1L : 0L);
                statement.A(7, entity.h());
                statement.p0(8, entity.g());
                statement.p0(9, entity.f());
                statement.p0(10, entity.e());
                statement.p0(11, entity.d());
            }
        }, new EntityDeleteOrUpdateAdapter<CustomBlockingScreenConfigEntity>() { // from class: cz.mobilesoft.coreblock.storage.room.dao.core.CustomBlockingScreenConfigDao_Impl.5
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            protected String b() {
                return "UPDATE `BlockingConfig` SET `id` = ?,`config_type` = ?,`blocking_message` = ?,`show_reason` = ?,`timeout_seconds` = ?,`show_counter` = ?,`icon_res` = ?,`custom_title` = ?,`custom_subtitle` = ?,`custom_exit_button_text` = ?,`custom_color_hex` = ? WHERE `id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public void a(SQLiteStatement statement, CustomBlockingScreenConfigEntity entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.p0(1, entity.i());
                statement.A(2, CustomBlockingScreenConfigDao_Impl.this.f125852c.b(entity.m()));
                statement.p0(3, entity.c());
                statement.A(4, entity.j() ? 1L : 0L);
                statement.A(5, entity.l());
                statement.A(6, entity.k() ? 1L : 0L);
                statement.A(7, entity.h());
                statement.p0(8, entity.g());
                statement.p0(9, entity.f());
                statement.p0(10, entity.e());
                statement.p0(11, entity.d());
                statement.p0(12, entity.i());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit a0(CustomBlockingScreenConfigDao_Impl customBlockingScreenConfigDao_Impl, CustomBlockingScreenConfigEntity customBlockingScreenConfigEntity, SQLiteConnection _connection) throws Exception {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        customBlockingScreenConfigDao_Impl.f125853d.c(_connection, customBlockingScreenConfigEntity);
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
    public static final List c0(String str, CustomBlockingScreenConfigDao_Impl customBlockingScreenConfigDao_Impl, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        try {
            int iD = SQLiteStatementUtil.d(sQLiteStatementG2, "id");
            int iD2 = SQLiteStatementUtil.d(sQLiteStatementG2, "config_type");
            int iD3 = SQLiteStatementUtil.d(sQLiteStatementG2, "blocking_message");
            int iD4 = SQLiteStatementUtil.d(sQLiteStatementG2, "show_reason");
            int iD5 = SQLiteStatementUtil.d(sQLiteStatementG2, "timeout_seconds");
            int iD6 = SQLiteStatementUtil.d(sQLiteStatementG2, "show_counter");
            int iD7 = SQLiteStatementUtil.d(sQLiteStatementG2, "icon_res");
            int iD8 = SQLiteStatementUtil.d(sQLiteStatementG2, "custom_title");
            int iD9 = SQLiteStatementUtil.d(sQLiteStatementG2, "custom_subtitle");
            int iD10 = SQLiteStatementUtil.d(sQLiteStatementG2, "custom_exit_button_text");
            int iD11 = SQLiteStatementUtil.d(sQLiteStatementG2, "custom_color_hex");
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementG2.B2()) {
                String strF2 = sQLiteStatementG2.f2(iD);
                int i3 = iD;
                ConfigType configTypeA = customBlockingScreenConfigDao_Impl.f125852c.a((int) sQLiteStatementG2.getLong(iD2));
                int i4 = iD2;
                int i5 = iD3;
                int i6 = iD4;
                arrayList.add(new CustomBlockingScreenConfigEntity(strF2, configTypeA, sQLiteStatementG2.f2(iD3), ((int) sQLiteStatementG2.getLong(iD4)) != 0, (int) sQLiteStatementG2.getLong(iD5), ((int) sQLiteStatementG2.getLong(iD6)) != 0, (int) sQLiteStatementG2.getLong(iD7), sQLiteStatementG2.f2(iD8), sQLiteStatementG2.f2(iD9), sQLiteStatementG2.f2(iD10), sQLiteStatementG2.f2(iD11)));
                iD3 = i5;
                iD4 = i6;
                iD = i3;
                iD2 = i4;
            }
            return arrayList;
        } finally {
            sQLiteStatementG2.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CustomBlockingScreenConfigEntity d0(String str, String str2, CustomBlockingScreenConfigDao_Impl customBlockingScreenConfigDao_Impl, SQLiteConnection _connection) {
        CustomBlockingScreenConfigEntity customBlockingScreenConfigEntity;
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        try {
            sQLiteStatementG2.p0(1, str2);
            int iD = SQLiteStatementUtil.d(sQLiteStatementG2, "id");
            int iD2 = SQLiteStatementUtil.d(sQLiteStatementG2, "config_type");
            int iD3 = SQLiteStatementUtil.d(sQLiteStatementG2, "blocking_message");
            int iD4 = SQLiteStatementUtil.d(sQLiteStatementG2, "show_reason");
            int iD5 = SQLiteStatementUtil.d(sQLiteStatementG2, "timeout_seconds");
            int iD6 = SQLiteStatementUtil.d(sQLiteStatementG2, "show_counter");
            int iD7 = SQLiteStatementUtil.d(sQLiteStatementG2, "icon_res");
            int iD8 = SQLiteStatementUtil.d(sQLiteStatementG2, "custom_title");
            int iD9 = SQLiteStatementUtil.d(sQLiteStatementG2, "custom_subtitle");
            int iD10 = SQLiteStatementUtil.d(sQLiteStatementG2, "custom_exit_button_text");
            int iD11 = SQLiteStatementUtil.d(sQLiteStatementG2, "custom_color_hex");
            if (sQLiteStatementG2.B2()) {
                customBlockingScreenConfigEntity = new CustomBlockingScreenConfigEntity(sQLiteStatementG2.f2(iD), customBlockingScreenConfigDao_Impl.f125852c.a((int) sQLiteStatementG2.getLong(iD2)), sQLiteStatementG2.f2(iD3), ((int) sQLiteStatementG2.getLong(iD4)) != 0, (int) sQLiteStatementG2.getLong(iD5), ((int) sQLiteStatementG2.getLong(iD6)) != 0, (int) sQLiteStatementG2.getLong(iD7), sQLiteStatementG2.f2(iD8), sQLiteStatementG2.f2(iD9), sQLiteStatementG2.f2(iD10), sQLiteStatementG2.f2(iD11));
            } else {
                customBlockingScreenConfigEntity = null;
            }
            return customBlockingScreenConfigEntity;
        } finally {
            sQLiteStatementG2.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CustomBlockingScreenConfigEntity e0(String str, CustomBlockingScreenConfigDao_Impl customBlockingScreenConfigDao_Impl, ConfigType configType, SQLiteConnection _connection) {
        CustomBlockingScreenConfigEntity customBlockingScreenConfigEntity;
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        try {
            sQLiteStatementG2.A(1, customBlockingScreenConfigDao_Impl.f125852c.b(configType));
            int iD = SQLiteStatementUtil.d(sQLiteStatementG2, "id");
            int iD2 = SQLiteStatementUtil.d(sQLiteStatementG2, "config_type");
            int iD3 = SQLiteStatementUtil.d(sQLiteStatementG2, "blocking_message");
            int iD4 = SQLiteStatementUtil.d(sQLiteStatementG2, "show_reason");
            int iD5 = SQLiteStatementUtil.d(sQLiteStatementG2, "timeout_seconds");
            int iD6 = SQLiteStatementUtil.d(sQLiteStatementG2, "show_counter");
            int iD7 = SQLiteStatementUtil.d(sQLiteStatementG2, "icon_res");
            int iD8 = SQLiteStatementUtil.d(sQLiteStatementG2, "custom_title");
            int iD9 = SQLiteStatementUtil.d(sQLiteStatementG2, "custom_subtitle");
            int iD10 = SQLiteStatementUtil.d(sQLiteStatementG2, "custom_exit_button_text");
            int iD11 = SQLiteStatementUtil.d(sQLiteStatementG2, "custom_color_hex");
            if (sQLiteStatementG2.B2()) {
                customBlockingScreenConfigEntity = new CustomBlockingScreenConfigEntity(sQLiteStatementG2.f2(iD), customBlockingScreenConfigDao_Impl.f125852c.a((int) sQLiteStatementG2.getLong(iD2)), sQLiteStatementG2.f2(iD3), ((int) sQLiteStatementG2.getLong(iD4)) != 0, (int) sQLiteStatementG2.getLong(iD5), ((int) sQLiteStatementG2.getLong(iD6)) != 0, (int) sQLiteStatementG2.getLong(iD7), sQLiteStatementG2.f2(iD8), sQLiteStatementG2.f2(iD9), sQLiteStatementG2.f2(iD10), sQLiteStatementG2.f2(iD11));
            } else {
                customBlockingScreenConfigEntity = null;
            }
            return customBlockingScreenConfigEntity;
        } finally {
            sQLiteStatementG2.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List f0(CustomBlockingScreenConfigDao_Impl customBlockingScreenConfigDao_Impl, Collection collection, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        return customBlockingScreenConfigDao_Impl.f125851b.e(_connection, collection);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h0(CustomBlockingScreenConfigDao_Impl customBlockingScreenConfigDao_Impl, CustomBlockingScreenConfigEntity customBlockingScreenConfigEntity, SQLiteConnection _connection) throws Exception {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        customBlockingScreenConfigDao_Impl.f125854f.c(_connection, customBlockingScreenConfigEntity);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long j0(CustomBlockingScreenConfigDao_Impl customBlockingScreenConfigDao_Impl, CustomBlockingScreenConfigEntity customBlockingScreenConfigEntity, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        return customBlockingScreenConfigDao_Impl.f125855g.b(_connection, customBlockingScreenConfigEntity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List k0(CustomBlockingScreenConfigDao_Impl customBlockingScreenConfigDao_Impl, Collection collection, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        return customBlockingScreenConfigDao_Impl.f125855g.c(_connection, collection);
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.core.CustomBlockingScreenConfigDao
    public Flow J() {
        final String str = "SELECT * FROM BlockingConfig";
        return FlowUtil.a(this.f125850a, true, new String[]{"BlockingConfig"}, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.core.j0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return CustomBlockingScreenConfigDao_Impl.c0(str, this, (SQLiteConnection) obj);
            }
        });
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.core.CustomBlockingScreenConfigDao
    public Flow K(final String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        final String str = "SELECT * FROM BlockingConfig WHERE id = ?";
        return FlowUtil.a(this.f125850a, true, new String[]{"BlockingConfig"}, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.core.i0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return CustomBlockingScreenConfigDao_Impl.d0(str, id, this, (SQLiteConnection) obj);
            }
        });
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.core.CustomBlockingScreenConfigDao
    public Object L(final ConfigType configType, Continuation continuation) {
        final String str = "SELECT * FROM BlockingConfig WHERE config_type = ? LIMIT 1";
        return DBUtil.g(this.f125850a, true, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.core.h0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return CustomBlockingScreenConfigDao_Impl.e0(str, this, configType, (SQLiteConnection) obj);
            }
        }, continuation);
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.core.CustomBlockingScreenConfigDao
    public Object M(List list, Continuation continuation) {
        Object objF = DBUtil.f(this.f125850a, new CustomBlockingScreenConfigDao_Impl$insertConfigs$2(this, list, null), continuation);
        return objF == IntrinsicsKt.f() ? objF : Unit.f139807a;
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.BaseDao
    /* JADX INFO: renamed from: Z, reason: merged with bridge method [inline-methods] */
    public Object q(final CustomBlockingScreenConfigEntity customBlockingScreenConfigEntity, Continuation continuation) {
        Object objG = DBUtil.g(this.f125850a, false, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.core.k0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return CustomBlockingScreenConfigDao_Impl.a0(this.f126240a, customBlockingScreenConfigEntity, (SQLiteConnection) obj);
            }
        }, continuation);
        return objG == IntrinsicsKt.f() ? objG : Unit.f139807a;
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.core.CustomBlockingScreenConfigDao
    public void b() {
        final String str = "DELETE FROM BlockingConfig";
        DBUtil.e(this.f125850a, false, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.core.c0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return CustomBlockingScreenConfigDao_Impl.b0(str, (SQLiteConnection) obj);
            }
        });
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.BaseDao
    /* JADX INFO: renamed from: g0, reason: merged with bridge method [inline-methods] */
    public Object p(final CustomBlockingScreenConfigEntity customBlockingScreenConfigEntity, Continuation continuation) {
        Object objG = DBUtil.g(this.f125850a, false, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.core.d0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return CustomBlockingScreenConfigDao_Impl.h0(this.f126174a, customBlockingScreenConfigEntity, (SQLiteConnection) obj);
            }
        }, continuation);
        return objG == IntrinsicsKt.f() ? objG : Unit.f139807a;
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.BaseDao
    /* JADX INFO: renamed from: i0, reason: merged with bridge method [inline-methods] */
    public Object f(final CustomBlockingScreenConfigEntity customBlockingScreenConfigEntity, Continuation continuation) {
        return DBUtil.g(this.f125850a, false, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.core.e0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Long.valueOf(CustomBlockingScreenConfigDao_Impl.j0(this.f126181a, customBlockingScreenConfigEntity, (SQLiteConnection) obj));
            }
        }, continuation);
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.BaseDao
    public Object j(final Collection collection, Continuation continuation) {
        return DBUtil.g(this.f125850a, false, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.core.f0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return CustomBlockingScreenConfigDao_Impl.k0(this.f126188a, collection, (SQLiteConnection) obj);
            }
        }, continuation);
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.BaseDao
    public Object t(final Collection collection, Continuation continuation) {
        return DBUtil.g(this.f125850a, false, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.core.g0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return CustomBlockingScreenConfigDao_Impl.f0(this.f126195a, collection, (SQLiteConnection) obj);
            }
        }, continuation);
    }
}
