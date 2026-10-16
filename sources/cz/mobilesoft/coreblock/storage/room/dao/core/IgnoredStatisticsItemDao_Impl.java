package cz.mobilesoft.coreblock.storage.room.dao.core;

import android.content.pm.PackageManager;
import androidx.room.EntityDeleteOrUpdateAdapter;
import androidx.room.EntityInsertAdapter;
import androidx.room.EntityUpsertAdapter;
import androidx.room.RoomDatabase;
import androidx.room.coroutines.FlowUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.SQLiteStatementUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import com.revenuecat.purchases.ui.revenuecatui.templates.VWmQ.cJfnYMIyomoWf;
import cz.mobilesoft.coreblock.dto.UsageAccess;
import cz.mobilesoft.coreblock.storage.room.entity.core.IgnoredStatisticsItem;
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
public final class IgnoredStatisticsItemDao_Impl extends IgnoredStatisticsItemDao {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Companion f125946i = new Companion(null);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f125947j = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final RoomDatabase f125948a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final EntityInsertAdapter f125949b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final UsageAccess.Type.Converter f125950c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final IgnoredStatisticsItem.ItemSourceType.Converter f125951d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final EntityDeleteOrUpdateAdapter f125952f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final EntityDeleteOrUpdateAdapter f125953g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final EntityUpsertAdapter f125954h;

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

    public IgnoredStatisticsItemDao_Impl(RoomDatabase __db) {
        Intrinsics.checkNotNullParameter(__db, "__db");
        this.f125950c = new UsageAccess.Type.Converter();
        this.f125951d = new IgnoredStatisticsItem.ItemSourceType.Converter();
        this.f125948a = __db;
        this.f125949b = new EntityInsertAdapter<IgnoredStatisticsItem>() { // from class: cz.mobilesoft.coreblock.storage.room.dao.core.IgnoredStatisticsItemDao_Impl.1
            @Override // androidx.room.EntityInsertAdapter
            protected String b() {
                return "INSERT OR REPLACE INTO `IgnoredStatisticsItem` (`id`,`name`,`type`,`itemSourceType`,`isActive`,`isInstalled`) VALUES (nullif(?, 0),?,?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertAdapter
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public void a(SQLiteStatement statement, IgnoredStatisticsItem entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.A(1, entity.a());
                statement.p0(2, entity.c());
                statement.A(3, IgnoredStatisticsItemDao_Impl.this.f125950c.b(entity.d()));
                statement.A(4, IgnoredStatisticsItemDao_Impl.this.f125951d.b(entity.b()));
                statement.A(5, entity.e() ? 1L : 0L);
                statement.A(6, entity.f() ? 1L : 0L);
            }
        };
        this.f125952f = new EntityDeleteOrUpdateAdapter<IgnoredStatisticsItem>() { // from class: cz.mobilesoft.coreblock.storage.room.dao.core.IgnoredStatisticsItemDao_Impl.2
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            protected String b() {
                return "DELETE FROM `IgnoredStatisticsItem` WHERE `id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public void a(SQLiteStatement statement, IgnoredStatisticsItem entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.A(1, entity.a());
            }
        };
        this.f125953g = new EntityDeleteOrUpdateAdapter<IgnoredStatisticsItem>() { // from class: cz.mobilesoft.coreblock.storage.room.dao.core.IgnoredStatisticsItemDao_Impl.3
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            protected String b() {
                return "UPDATE OR ABORT `IgnoredStatisticsItem` SET `id` = ?,`name` = ?,`type` = ?,`itemSourceType` = ?,`isActive` = ?,`isInstalled` = ? WHERE `id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public void a(SQLiteStatement statement, IgnoredStatisticsItem entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.A(1, entity.a());
                statement.p0(2, entity.c());
                statement.A(3, IgnoredStatisticsItemDao_Impl.this.f125950c.b(entity.d()));
                statement.A(4, IgnoredStatisticsItemDao_Impl.this.f125951d.b(entity.b()));
                statement.A(5, entity.e() ? 1L : 0L);
                statement.A(6, entity.f() ? 1L : 0L);
                statement.A(7, entity.a());
            }
        };
        this.f125954h = new EntityUpsertAdapter(new EntityInsertAdapter<IgnoredStatisticsItem>() { // from class: cz.mobilesoft.coreblock.storage.room.dao.core.IgnoredStatisticsItemDao_Impl.4
            @Override // androidx.room.EntityInsertAdapter
            protected String b() {
                return "INSERT INTO `IgnoredStatisticsItem` (`id`,`name`,`type`,`itemSourceType`,`isActive`,`isInstalled`) VALUES (nullif(?, 0),?,?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertAdapter
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public void a(SQLiteStatement statement, IgnoredStatisticsItem entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.A(1, entity.a());
                statement.p0(2, entity.c());
                statement.A(3, IgnoredStatisticsItemDao_Impl.this.f125950c.b(entity.d()));
                statement.A(4, IgnoredStatisticsItemDao_Impl.this.f125951d.b(entity.b()));
                statement.A(5, entity.e() ? 1L : 0L);
                statement.A(6, entity.f() ? 1L : 0L);
            }
        }, new EntityDeleteOrUpdateAdapter<IgnoredStatisticsItem>() { // from class: cz.mobilesoft.coreblock.storage.room.dao.core.IgnoredStatisticsItemDao_Impl.5
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            protected String b() {
                return "UPDATE `IgnoredStatisticsItem` SET `id` = ?,`name` = ?,`type` = ?,`itemSourceType` = ?,`isActive` = ?,`isInstalled` = ? WHERE `id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public void a(SQLiteStatement statement, IgnoredStatisticsItem entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.A(1, entity.a());
                statement.p0(2, entity.c());
                statement.A(3, IgnoredStatisticsItemDao_Impl.this.f125950c.b(entity.d()));
                statement.A(4, IgnoredStatisticsItemDao_Impl.this.f125951d.b(entity.b()));
                statement.A(5, entity.e() ? 1L : 0L);
                statement.A(6, entity.f() ? 1L : 0L);
                statement.A(7, entity.a());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long a1(String str, IgnoredStatisticsItemDao_Impl ignoredStatisticsItemDao_Impl, IgnoredStatisticsItem.ItemSourceType itemSourceType, boolean z2, boolean z3, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        try {
            sQLiteStatementG2.A(1, ignoredStatisticsItemDao_Impl.f125951d.b(itemSourceType));
            sQLiteStatementG2.A(2, z2 ? 1L : 0L);
            sQLiteStatementG2.A(3, z3 ? 1L : 0L);
            return sQLiteStatementG2.B2() ? sQLiteStatementG2.getLong(0) : 0L;
        } finally {
            sQLiteStatementG2.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit b1(IgnoredStatisticsItemDao_Impl ignoredStatisticsItemDao_Impl, List list, SQLiteConnection _connection) throws Exception {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        ignoredStatisticsItemDao_Impl.f125952f.d(_connection, list);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List c1(String str, boolean z2, IgnoredStatisticsItemDao_Impl ignoredStatisticsItemDao_Impl, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        boolean z3 = true;
        try {
            sQLiteStatementG2.A(1, z2 ? 1L : 0L);
            int iD = SQLiteStatementUtil.d(sQLiteStatementG2, "id");
            int iD2 = SQLiteStatementUtil.d(sQLiteStatementG2, "name");
            int iD3 = SQLiteStatementUtil.d(sQLiteStatementG2, "type");
            int iD4 = SQLiteStatementUtil.d(sQLiteStatementG2, "itemSourceType");
            int iD5 = SQLiteStatementUtil.d(sQLiteStatementG2, "isActive");
            int iD6 = SQLiteStatementUtil.d(sQLiteStatementG2, "isInstalled");
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementG2.B2()) {
                int i3 = iD3;
                arrayList.add(new IgnoredStatisticsItem(sQLiteStatementG2.getLong(iD), sQLiteStatementG2.f2(iD2), ignoredStatisticsItemDao_Impl.f125950c.a((int) sQLiteStatementG2.getLong(iD3)), ignoredStatisticsItemDao_Impl.f125951d.a((int) sQLiteStatementG2.getLong(iD4)), ((int) sQLiteStatementG2.getLong(iD5)) != 0 ? z3 : false, ((int) sQLiteStatementG2.getLong(iD6)) != 0));
                iD3 = i3;
                z3 = true;
            }
            return arrayList;
        } finally {
            sQLiteStatementG2.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IgnoredStatisticsItem e1(String str, String str2, IgnoredStatisticsItemDao_Impl ignoredStatisticsItemDao_Impl, SQLiteConnection _connection) {
        IgnoredStatisticsItem ignoredStatisticsItem;
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        try {
            sQLiteStatementG2.p0(1, str2);
            int iD = SQLiteStatementUtil.d(sQLiteStatementG2, "id");
            int iD2 = SQLiteStatementUtil.d(sQLiteStatementG2, "name");
            int iD3 = SQLiteStatementUtil.d(sQLiteStatementG2, "type");
            int iD4 = SQLiteStatementUtil.d(sQLiteStatementG2, "itemSourceType");
            int iD5 = SQLiteStatementUtil.d(sQLiteStatementG2, "isActive");
            int iD6 = SQLiteStatementUtil.d(sQLiteStatementG2, "isInstalled");
            if (sQLiteStatementG2.B2()) {
                ignoredStatisticsItem = new IgnoredStatisticsItem(sQLiteStatementG2.getLong(iD), sQLiteStatementG2.f2(iD2), ignoredStatisticsItemDao_Impl.f125950c.a((int) sQLiteStatementG2.getLong(iD3)), ignoredStatisticsItemDao_Impl.f125951d.a((int) sQLiteStatementG2.getLong(iD4)), ((int) sQLiteStatementG2.getLong(iD5)) != 0, ((int) sQLiteStatementG2.getLong(iD6)) != 0);
            } else {
                ignoredStatisticsItem = null;
            }
            return ignoredStatisticsItem;
        } finally {
            sQLiteStatementG2.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IgnoredStatisticsItem f1(String str, String str2, IgnoredStatisticsItemDao_Impl ignoredStatisticsItemDao_Impl, UsageAccess.Type type, boolean z2, SQLiteConnection _connection) {
        IgnoredStatisticsItem ignoredStatisticsItem;
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        try {
            sQLiteStatementG2.p0(1, str2);
            sQLiteStatementG2.A(2, ignoredStatisticsItemDao_Impl.f125950c.b(type));
            sQLiteStatementG2.A(3, z2 ? 1L : 0L);
            int iD = SQLiteStatementUtil.d(sQLiteStatementG2, "id");
            int iD2 = SQLiteStatementUtil.d(sQLiteStatementG2, "name");
            int iD3 = SQLiteStatementUtil.d(sQLiteStatementG2, "type");
            int iD4 = SQLiteStatementUtil.d(sQLiteStatementG2, "itemSourceType");
            int iD5 = SQLiteStatementUtil.d(sQLiteStatementG2, "isActive");
            int iD6 = SQLiteStatementUtil.d(sQLiteStatementG2, "isInstalled");
            if (sQLiteStatementG2.B2()) {
                ignoredStatisticsItem = new IgnoredStatisticsItem(sQLiteStatementG2.getLong(iD), sQLiteStatementG2.f2(iD2), ignoredStatisticsItemDao_Impl.f125950c.a((int) sQLiteStatementG2.getLong(iD3)), ignoredStatisticsItemDao_Impl.f125951d.a((int) sQLiteStatementG2.getLong(iD4)), ((int) sQLiteStatementG2.getLong(iD5)) != 0, ((int) sQLiteStatementG2.getLong(iD6)) != 0);
            } else {
                ignoredStatisticsItem = null;
            }
            return ignoredStatisticsItem;
        } finally {
            sQLiteStatementG2.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List g1(String str, Collection collection, int i3, IgnoredStatisticsItemDao_Impl ignoredStatisticsItemDao_Impl, UsageAccess.Type type, boolean z2, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        try {
            Iterator it = collection.iterator();
            int i4 = 1;
            while (it.hasNext()) {
                sQLiteStatementG2.p0(i4, (String) it.next());
                i4++;
            }
            sQLiteStatementG2.A(i3 + 1, ignoredStatisticsItemDao_Impl.f125950c.b(type));
            sQLiteStatementG2.A(i3 + 2, z2 ? 1L : 0L);
            int iD = SQLiteStatementUtil.d(sQLiteStatementG2, "id");
            int iD2 = SQLiteStatementUtil.d(sQLiteStatementG2, "name");
            int iD3 = SQLiteStatementUtil.d(sQLiteStatementG2, "type");
            int iD4 = SQLiteStatementUtil.d(sQLiteStatementG2, "itemSourceType");
            int iD5 = SQLiteStatementUtil.d(sQLiteStatementG2, "isActive");
            int iD6 = SQLiteStatementUtil.d(sQLiteStatementG2, "isInstalled");
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementG2.B2()) {
                int i5 = iD2;
                arrayList.add(new IgnoredStatisticsItem(sQLiteStatementG2.getLong(iD), sQLiteStatementG2.f2(iD2), ignoredStatisticsItemDao_Impl.f125950c.a((int) sQLiteStatementG2.getLong(iD3)), ignoredStatisticsItemDao_Impl.f125951d.a((int) sQLiteStatementG2.getLong(iD4)), ((int) sQLiteStatementG2.getLong(iD5)) != 0, ((int) sQLiteStatementG2.getLong(iD6)) != 0));
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
    public static final List h1(String str, Collection collection, int i3, IgnoredStatisticsItemDao_Impl ignoredStatisticsItemDao_Impl, UsageAccess.Type type, IgnoredStatisticsItem.ItemSourceType itemSourceType, boolean z2, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        try {
            Iterator it = collection.iterator();
            int i4 = 1;
            while (it.hasNext()) {
                sQLiteStatementG2.p0(i4, (String) it.next());
                i4++;
            }
            sQLiteStatementG2.A(i3 + 1, ignoredStatisticsItemDao_Impl.f125950c.b(type));
            sQLiteStatementG2.A(i3 + 2, ignoredStatisticsItemDao_Impl.f125951d.b(itemSourceType));
            sQLiteStatementG2.A(i3 + 3, z2 ? 1L : 0L);
            int iD = SQLiteStatementUtil.d(sQLiteStatementG2, "id");
            int iD2 = SQLiteStatementUtil.d(sQLiteStatementG2, "name");
            int iD3 = SQLiteStatementUtil.d(sQLiteStatementG2, "type");
            int iD4 = SQLiteStatementUtil.d(sQLiteStatementG2, "itemSourceType");
            int iD5 = SQLiteStatementUtil.d(sQLiteStatementG2, "isActive");
            int iD6 = SQLiteStatementUtil.d(sQLiteStatementG2, "isInstalled");
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementG2.B2()) {
                int i5 = iD2;
                arrayList.add(new IgnoredStatisticsItem(sQLiteStatementG2.getLong(iD), sQLiteStatementG2.f2(iD2), ignoredStatisticsItemDao_Impl.f125950c.a((int) sQLiteStatementG2.getLong(iD3)), ignoredStatisticsItemDao_Impl.f125951d.a((int) sQLiteStatementG2.getLong(iD4)), ((int) sQLiteStatementG2.getLong(iD5)) != 0, ((int) sQLiteStatementG2.getLong(iD6)) != 0));
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
    public static final List i1(String str, IgnoredStatisticsItemDao_Impl ignoredStatisticsItemDao_Impl, IgnoredStatisticsItem.ItemSourceType itemSourceType, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        try {
            boolean z2 = true;
            sQLiteStatementG2.A(1, ignoredStatisticsItemDao_Impl.f125951d.b(itemSourceType));
            int iD = SQLiteStatementUtil.d(sQLiteStatementG2, "id");
            int iD2 = SQLiteStatementUtil.d(sQLiteStatementG2, "name");
            int iD3 = SQLiteStatementUtil.d(sQLiteStatementG2, "type");
            int iD4 = SQLiteStatementUtil.d(sQLiteStatementG2, "itemSourceType");
            int iD5 = SQLiteStatementUtil.d(sQLiteStatementG2, "isActive");
            int iD6 = SQLiteStatementUtil.d(sQLiteStatementG2, "isInstalled");
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementG2.B2()) {
                int i3 = iD3;
                arrayList.add(new IgnoredStatisticsItem(sQLiteStatementG2.getLong(iD), sQLiteStatementG2.f2(iD2), ignoredStatisticsItemDao_Impl.f125950c.a((int) sQLiteStatementG2.getLong(iD3)), ignoredStatisticsItemDao_Impl.f125951d.a((int) sQLiteStatementG2.getLong(iD4)), ((int) sQLiteStatementG2.getLong(iD5)) != 0 ? z2 : false, ((int) sQLiteStatementG2.getLong(iD6)) != 0));
                iD3 = i3;
                z2 = true;
            }
            return arrayList;
        } finally {
            sQLiteStatementG2.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List j1(String str, IgnoredStatisticsItemDao_Impl ignoredStatisticsItemDao_Impl, IgnoredStatisticsItem.ItemSourceType itemSourceType, boolean z2, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        try {
            boolean z3 = true;
            sQLiteStatementG2.A(1, ignoredStatisticsItemDao_Impl.f125951d.b(itemSourceType));
            sQLiteStatementG2.A(2, z2 ? 1L : 0L);
            int iD = SQLiteStatementUtil.d(sQLiteStatementG2, "id");
            int iD2 = SQLiteStatementUtil.d(sQLiteStatementG2, "name");
            int iD3 = SQLiteStatementUtil.d(sQLiteStatementG2, "type");
            int iD4 = SQLiteStatementUtil.d(sQLiteStatementG2, "itemSourceType");
            int iD5 = SQLiteStatementUtil.d(sQLiteStatementG2, "isActive");
            int iD6 = SQLiteStatementUtil.d(sQLiteStatementG2, "isInstalled");
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementG2.B2()) {
                int i3 = iD3;
                arrayList.add(new IgnoredStatisticsItem(sQLiteStatementG2.getLong(iD), sQLiteStatementG2.f2(iD2), ignoredStatisticsItemDao_Impl.f125950c.a((int) sQLiteStatementG2.getLong(iD3)), ignoredStatisticsItemDao_Impl.f125951d.a((int) sQLiteStatementG2.getLong(iD4)), ((int) sQLiteStatementG2.getLong(iD5)) != 0 ? z3 : false, ((int) sQLiteStatementG2.getLong(iD6)) != 0));
                iD3 = i3;
                z3 = true;
            }
            return arrayList;
        } finally {
            sQLiteStatementG2.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List k1(String str, IgnoredStatisticsItemDao_Impl ignoredStatisticsItemDao_Impl, IgnoredStatisticsItem.ItemSourceType itemSourceType, boolean z2, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        try {
            boolean z3 = true;
            sQLiteStatementG2.A(1, ignoredStatisticsItemDao_Impl.f125951d.b(itemSourceType));
            sQLiteStatementG2.A(2, z2 ? 1L : 0L);
            int iD = SQLiteStatementUtil.d(sQLiteStatementG2, "id");
            int iD2 = SQLiteStatementUtil.d(sQLiteStatementG2, "name");
            int iD3 = SQLiteStatementUtil.d(sQLiteStatementG2, "type");
            int iD4 = SQLiteStatementUtil.d(sQLiteStatementG2, "itemSourceType");
            int iD5 = SQLiteStatementUtil.d(sQLiteStatementG2, "isActive");
            int iD6 = SQLiteStatementUtil.d(sQLiteStatementG2, "isInstalled");
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementG2.B2()) {
                int i3 = iD3;
                arrayList.add(new IgnoredStatisticsItem(sQLiteStatementG2.getLong(iD), sQLiteStatementG2.f2(iD2), ignoredStatisticsItemDao_Impl.f125950c.a((int) sQLiteStatementG2.getLong(iD3)), ignoredStatisticsItemDao_Impl.f125951d.a((int) sQLiteStatementG2.getLong(iD4)), ((int) sQLiteStatementG2.getLong(iD5)) != 0 ? z3 : false, ((int) sQLiteStatementG2.getLong(iD6)) != 0));
                iD3 = i3;
                z3 = true;
            }
            return arrayList;
        } finally {
            sQLiteStatementG2.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long m1(IgnoredStatisticsItemDao_Impl ignoredStatisticsItemDao_Impl, IgnoredStatisticsItem ignoredStatisticsItem, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        return ignoredStatisticsItemDao_Impl.f125949b.d(_connection, ignoredStatisticsItem);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List n1(IgnoredStatisticsItemDao_Impl ignoredStatisticsItemDao_Impl, Collection collection, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        return ignoredStatisticsItemDao_Impl.f125949b.e(_connection, collection);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p1(IgnoredStatisticsItemDao_Impl ignoredStatisticsItemDao_Impl, IgnoredStatisticsItem ignoredStatisticsItem, SQLiteConnection _connection) throws Exception {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        ignoredStatisticsItemDao_Impl.f125953g.c(_connection, ignoredStatisticsItem);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit q1(IgnoredStatisticsItemDao_Impl ignoredStatisticsItemDao_Impl, Collection collection, SQLiteConnection _connection) throws Exception {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        ignoredStatisticsItemDao_Impl.f125953g.d(_connection, collection);
        return Unit.f139807a;
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.core.IgnoredStatisticsItemDao
    public Object K(PackageManager packageManager, Continuation continuation) {
        Object objF = DBUtil.f(this.f125948a, new IgnoredStatisticsItemDao_Impl$checkAndInsertLaunchers$2(this, packageManager, null), continuation);
        return objF == IntrinsicsKt.f() ? objF : Unit.f139807a;
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.core.IgnoredStatisticsItemDao
    public Object M(Collection collection, Continuation continuation) {
        Object objF = DBUtil.f(this.f125948a, new IgnoredStatisticsItemDao_Impl$checkAndUpdateCustomAsDefault$2(this, collection, null), continuation);
        return objF == IntrinsicsKt.f() ? objF : Unit.f139807a;
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.core.IgnoredStatisticsItemDao
    public Object O(final IgnoredStatisticsItem.ItemSourceType itemSourceType, final boolean z2, final boolean z3, Continuation continuation) {
        final String str = "SELECT COUNT(*) FROM IgnoredStatisticsItem WHERE itemSourceType = ? AND isActive = ? AND isInstalled = ?";
        return DBUtil.g(this.f125948a, true, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.core.o0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Long.valueOf(IgnoredStatisticsItemDao_Impl.a1(str, this, itemSourceType, z2, z3, (SQLiteConnection) obj));
            }
        }, continuation);
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.core.IgnoredStatisticsItemDao
    public Object P(Continuation continuation) {
        return DBUtil.f(this.f125948a, new IgnoredStatisticsItemDao_Impl$getActiveNames$2(this, null), continuation);
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.core.IgnoredStatisticsItemDao
    public Object R(final boolean z2, Continuation continuation) {
        final String str = "SELECT * FROM IgnoredStatisticsItem WHERE isActive = ?";
        return DBUtil.g(this.f125948a, true, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.core.z0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return IgnoredStatisticsItemDao_Impl.c1(str, z2, this, (SQLiteConnection) obj);
            }
        }, continuation);
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.core.IgnoredStatisticsItemDao
    public Flow S(final boolean z2) {
        final String str = "SELECT * FROM IgnoredStatisticsItem WHERE isActive = ?";
        return FlowUtil.a(this.f125948a, true, new String[]{"IgnoredStatisticsItem"}, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.core.x0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return IgnoredStatisticsItemDao_Impl.d1(str, z2, this, (SQLiteConnection) obj);
            }
        });
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.core.IgnoredStatisticsItemDao
    public Object T(final String str, Continuation continuation) {
        final String str2 = "SELECT * FROM IgnoredStatisticsItem WHERE name = ? LIMIT 1";
        return DBUtil.g(this.f125948a, true, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.core.u0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return IgnoredStatisticsItemDao_Impl.e1(str2, str, this, (SQLiteConnection) obj);
            }
        }, continuation);
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.core.IgnoredStatisticsItemDao
    public Object U(final String str, final UsageAccess.Type type, final boolean z2, Continuation continuation) {
        final String str2 = "SELECT * FROM IgnoredStatisticsItem WHERE name = ? AND type = ? AND isInstalled = ?";
        return DBUtil.g(this.f125948a, true, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.core.w0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return IgnoredStatisticsItemDao_Impl.f1(str2, str, this, type, z2, (SQLiteConnection) obj);
            }
        }, continuation);
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.core.IgnoredStatisticsItemDao
    public Object V(final Collection collection, final UsageAccess.Type type, final boolean z2, Continuation continuation) {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT * FROM IgnoredStatisticsItem WHERE name IN (");
        final int size = collection.size();
        StringUtil.a(sb, size);
        sb.append(") AND type = ");
        sb.append("?");
        sb.append(" AND isInstalled = ");
        sb.append("?");
        final String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return DBUtil.g(this.f125948a, true, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.core.y0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return IgnoredStatisticsItemDao_Impl.g1(string, collection, size, this, type, z2, (SQLiteConnection) obj);
            }
        }, continuation);
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.core.IgnoredStatisticsItemDao
    public Object Y(final Collection collection, final UsageAccess.Type type, final IgnoredStatisticsItem.ItemSourceType itemSourceType, final boolean z2, Continuation continuation) {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT * FROM IgnoredStatisticsItem WHERE name IN (");
        final int size = collection.size();
        StringUtil.a(sb, size);
        sb.append(") AND type = ");
        sb.append("?");
        sb.append(" AND itemSourceType = ");
        sb.append("?");
        sb.append(" AND isInstalled = ");
        sb.append("?");
        final String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return DBUtil.g(this.f125948a, true, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.core.p0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return IgnoredStatisticsItemDao_Impl.h1(string, collection, size, this, type, itemSourceType, z2, (SQLiteConnection) obj);
            }
        }, continuation);
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.core.IgnoredStatisticsItemDao
    public Object a0(final IgnoredStatisticsItem.ItemSourceType itemSourceType, Continuation continuation) {
        final String str = "SELECT * FROM IgnoredStatisticsItem WHERE itemSourceType = ?";
        return DBUtil.g(this.f125948a, true, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.core.a1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return IgnoredStatisticsItemDao_Impl.i1(str, this, itemSourceType, (SQLiteConnection) obj);
            }
        }, continuation);
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.core.IgnoredStatisticsItemDao
    public Object b0(final IgnoredStatisticsItem.ItemSourceType itemSourceType, final boolean z2, Continuation continuation) {
        final String str = "SELECT * FROM IgnoredStatisticsItem WHERE itemSourceType = ? AND isInstalled = ?";
        return DBUtil.g(this.f125948a, true, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.core.b1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return IgnoredStatisticsItemDao_Impl.j1(str, this, itemSourceType, z2, (SQLiteConnection) obj);
            }
        }, continuation);
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.core.IgnoredStatisticsItemDao
    public Object c0(final IgnoredStatisticsItem.ItemSourceType itemSourceType, final boolean z2, Continuation continuation) {
        final String str = "SELECT * FROM IgnoredStatisticsItem WHERE itemSourceType = ? AND isActive = ?";
        return DBUtil.g(this.f125948a, true, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.core.r0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return IgnoredStatisticsItemDao_Impl.k1(str, this, itemSourceType, z2, (SQLiteConnection) obj);
            }
        }, continuation);
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.core.IgnoredStatisticsItemDao
    public Object d0(IgnoredStatisticsItem.ItemSourceType itemSourceType, boolean z2, Continuation continuation) {
        return DBUtil.f(this.f125948a, new IgnoredStatisticsItemDao_Impl$getNamesBySourceType$2(this, itemSourceType, z2, null), continuation);
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.BaseDao
    public Object h(final List list, Continuation continuation) {
        Object objG = DBUtil.g(this.f125948a, false, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.core.t0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return IgnoredStatisticsItemDao_Impl.b1(this.f126314a, list, (SQLiteConnection) obj);
            }
        }, continuation);
        return objG == IntrinsicsKt.f() ? objG : Unit.f139807a;
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.core.IgnoredStatisticsItemDao
    public Object h0(Collection collection, Continuation continuation) {
        Object objF = DBUtil.f(this.f125948a, new IgnoredStatisticsItemDao_Impl$insertFromBackup$2(this, collection, null), continuation);
        return objF == IntrinsicsKt.f() ? objF : Unit.f139807a;
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.core.IgnoredStatisticsItemDao
    public Object j0(Collection collection, Continuation continuation) {
        Object objF = DBUtil.f(this.f125948a, new IgnoredStatisticsItemDao_Impl$insertOrActivate$2(this, collection, null), continuation);
        return objF == IntrinsicsKt.f() ? objF : Unit.f139807a;
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.core.IgnoredStatisticsItemDao
    public Object l0(Collection collection, Continuation continuation) {
        Object objF = DBUtil.f(this.f125948a, new IgnoredStatisticsItemDao_Impl$insertResolved$2(this, collection, null), continuation);
        return objF == IntrinsicsKt.f() ? objF : Unit.f139807a;
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.BaseDao
    /* JADX INFO: renamed from: l1, reason: merged with bridge method [inline-methods] */
    public Object n(final IgnoredStatisticsItem ignoredStatisticsItem, Continuation continuation) {
        return DBUtil.g(this.f125948a, false, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.core.q0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Long.valueOf(IgnoredStatisticsItemDao_Impl.m1(this.f126293a, ignoredStatisticsItem, (SQLiteConnection) obj));
            }
        }, continuation);
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.core.IgnoredStatisticsItemDao
    public Object n0(IgnoredStatisticsItem ignoredStatisticsItem, boolean z2, Continuation continuation) {
        Object objF = DBUtil.f(this.f125948a, new IgnoredStatisticsItemDao_Impl$setActive$2(this, ignoredStatisticsItem, z2, null), continuation);
        return objF == IntrinsicsKt.f() ? objF : Unit.f139807a;
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.core.IgnoredStatisticsItemDao
    public Object o0(String str, UsageAccess.Type type, boolean z2, Continuation continuation) {
        Object objF = DBUtil.f(this.f125948a, new IgnoredStatisticsItemDao_Impl$setActive$6(this, str, type, z2, null), continuation);
        return objF == IntrinsicsKt.f() ? objF : Unit.f139807a;
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.BaseDao
    /* JADX INFO: renamed from: o1, reason: merged with bridge method [inline-methods] */
    public Object p(final IgnoredStatisticsItem ignoredStatisticsItem, Continuation continuation) {
        Object objG = DBUtil.g(this.f125948a, false, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.core.s0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return IgnoredStatisticsItemDao_Impl.p1(this.f126309a, ignoredStatisticsItem, (SQLiteConnection) obj);
            }
        }, continuation);
        return objG == IntrinsicsKt.f() ? objG : Unit.f139807a;
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.core.IgnoredStatisticsItemDao
    public Object p0(Collection collection, UsageAccess.Type type, boolean z2, Continuation continuation) {
        Object objF = DBUtil.f(this.f125948a, new IgnoredStatisticsItemDao_Impl$setActive$8(this, collection, type, z2, null), continuation);
        return objF == IntrinsicsKt.f() ? objF : Unit.f139807a;
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.core.IgnoredStatisticsItemDao
    public Object q0(Collection collection, boolean z2, Continuation continuation) {
        Object objF = DBUtil.f(this.f125948a, new IgnoredStatisticsItemDao_Impl$setActive$4(this, collection, z2, null), continuation);
        return objF == IntrinsicsKt.f() ? objF : Unit.f139807a;
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.BaseDao
    public Object r(final Collection collection, Continuation continuation) {
        Object objG = DBUtil.g(this.f125948a, false, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.core.n0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return IgnoredStatisticsItemDao_Impl.q1(this.f126262a, collection, (SQLiteConnection) obj);
            }
        }, continuation);
        return objG == IntrinsicsKt.f() ? objG : Unit.f139807a;
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.BaseDao
    public Object t(final Collection collection, Continuation continuation) {
        return DBUtil.g(this.f125948a, false, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.core.v0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return IgnoredStatisticsItemDao_Impl.n1(this.f126326a, collection, (SQLiteConnection) obj);
            }
        }, continuation);
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.core.IgnoredStatisticsItemDao
    public Object v0(boolean z2, Continuation continuation) {
        Object objF = DBUtil.f(this.f125948a, new IgnoredStatisticsItemDao_Impl$setAllDefaultActive$2(this, z2, null), continuation);
        return objF == IntrinsicsKt.f() ? objF : Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List d1(String str, boolean z2, IgnoredStatisticsItemDao_Impl ignoredStatisticsItemDao_Impl, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        boolean z3 = true;
        try {
            sQLiteStatementG2.A(1, z2 ? 1L : 0L);
            int iD = SQLiteStatementUtil.d(sQLiteStatementG2, "id");
            int iD2 = SQLiteStatementUtil.d(sQLiteStatementG2, "name");
            int iD3 = SQLiteStatementUtil.d(sQLiteStatementG2, "type");
            int iD4 = SQLiteStatementUtil.d(sQLiteStatementG2, "itemSourceType");
            int iD5 = SQLiteStatementUtil.d(sQLiteStatementG2, "isActive");
            int iD6 = SQLiteStatementUtil.d(sQLiteStatementG2, cJfnYMIyomoWf.YbQ);
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementG2.B2()) {
                int i3 = iD3;
                arrayList.add(new IgnoredStatisticsItem(sQLiteStatementG2.getLong(iD), sQLiteStatementG2.f2(iD2), ignoredStatisticsItemDao_Impl.f125950c.a((int) sQLiteStatementG2.getLong(iD3)), ignoredStatisticsItemDao_Impl.f125951d.a((int) sQLiteStatementG2.getLong(iD4)), ((int) sQLiteStatementG2.getLong(iD5)) != 0 ? z3 : false, ((int) sQLiteStatementG2.getLong(iD6)) != 0));
                iD3 = i3;
                z3 = true;
            }
            return arrayList;
        } finally {
            sQLiteStatementG2.close();
        }
    }
}
