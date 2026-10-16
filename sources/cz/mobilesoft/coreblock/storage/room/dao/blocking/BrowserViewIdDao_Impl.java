package cz.mobilesoft.coreblock.storage.room.dao.blocking;

import android.content.Context;
import androidx.room.EntityDeleteOrUpdateAdapter;
import androidx.room.EntityInsertAdapter;
import androidx.room.EntityUpsertAdapter;
import androidx.room.RoomDatabase;
import androidx.room.coroutines.FlowUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.SQLiteStatementUtil;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.BrowserViewId;
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
public final class BrowserViewIdDao_Impl extends BrowserViewIdDao {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final Companion f125011m = new Companion(null);

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f125012n = 8;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final RoomDatabase f125013d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final EntityInsertAdapter f125014f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final BrowserViewId.ViewType.Converter f125015g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final BrowserViewId.DetectionMethod.Converter f125016h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final BrowserViewId.ExtractionMethod.Converter f125017i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final EntityDeleteOrUpdateAdapter f125018j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final EntityDeleteOrUpdateAdapter f125019k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final EntityUpsertAdapter f125020l;

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

    public BrowserViewIdDao_Impl(RoomDatabase __db) {
        Intrinsics.checkNotNullParameter(__db, "__db");
        this.f125015g = new BrowserViewId.ViewType.Converter();
        this.f125016h = new BrowserViewId.DetectionMethod.Converter();
        this.f125017i = new BrowserViewId.ExtractionMethod.Converter();
        this.f125013d = __db;
        this.f125014f = new EntityInsertAdapter<BrowserViewId>() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.BrowserViewIdDao_Impl.1
            @Override // androidx.room.EntityInsertAdapter
            protected String b() {
                return "INSERT OR REPLACE INTO `BrowserViewId` (`id`,`packageName`,`viewId`,`viewType`,`clearUrl`,`showLocalHtml`,`detectionMethod`,`extractionMethod`,`clickToOpenUrlBarViewId`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertAdapter
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public void a(SQLiteStatement statement, BrowserViewId entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.A(1, entity.getId());
                statement.p0(2, entity.getPackageName());
                statement.p0(3, entity.getViewId());
                statement.A(4, BrowserViewIdDao_Impl.this.f125015g.b(entity.getViewType()));
                statement.A(5, entity.getClearUrl() ? 1L : 0L);
                statement.A(6, entity.getShowLocalHtml() ? 1L : 0L);
                String strB = BrowserViewIdDao_Impl.this.f125016h.b(entity.getDetectionMethod());
                if (strB == null) {
                    statement.D(7);
                } else {
                    statement.p0(7, strB);
                }
                String strB2 = BrowserViewIdDao_Impl.this.f125017i.b(entity.getExtractionMethod());
                if (strB2 == null) {
                    statement.D(8);
                } else {
                    statement.p0(8, strB2);
                }
                String clickToOpenUrlBarViewId = entity.getClickToOpenUrlBarViewId();
                if (clickToOpenUrlBarViewId == null) {
                    statement.D(9);
                } else {
                    statement.p0(9, clickToOpenUrlBarViewId);
                }
            }
        };
        this.f125018j = new EntityDeleteOrUpdateAdapter<BrowserViewId>() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.BrowserViewIdDao_Impl.2
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            protected String b() {
                return "DELETE FROM `BrowserViewId` WHERE `id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public void a(SQLiteStatement statement, BrowserViewId entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.A(1, entity.getId());
            }
        };
        this.f125019k = new EntityDeleteOrUpdateAdapter<BrowserViewId>() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.BrowserViewIdDao_Impl.3
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            protected String b() {
                return "UPDATE OR ABORT `BrowserViewId` SET `id` = ?,`packageName` = ?,`viewId` = ?,`viewType` = ?,`clearUrl` = ?,`showLocalHtml` = ?,`detectionMethod` = ?,`extractionMethod` = ?,`clickToOpenUrlBarViewId` = ? WHERE `id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public void a(SQLiteStatement statement, BrowserViewId entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.A(1, entity.getId());
                statement.p0(2, entity.getPackageName());
                statement.p0(3, entity.getViewId());
                statement.A(4, BrowserViewIdDao_Impl.this.f125015g.b(entity.getViewType()));
                statement.A(5, entity.getClearUrl() ? 1L : 0L);
                statement.A(6, entity.getShowLocalHtml() ? 1L : 0L);
                String strB = BrowserViewIdDao_Impl.this.f125016h.b(entity.getDetectionMethod());
                if (strB == null) {
                    statement.D(7);
                } else {
                    statement.p0(7, strB);
                }
                String strB2 = BrowserViewIdDao_Impl.this.f125017i.b(entity.getExtractionMethod());
                if (strB2 == null) {
                    statement.D(8);
                } else {
                    statement.p0(8, strB2);
                }
                String clickToOpenUrlBarViewId = entity.getClickToOpenUrlBarViewId();
                if (clickToOpenUrlBarViewId == null) {
                    statement.D(9);
                } else {
                    statement.p0(9, clickToOpenUrlBarViewId);
                }
                statement.A(10, entity.getId());
            }
        };
        this.f125020l = new EntityUpsertAdapter(new EntityInsertAdapter<BrowserViewId>() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.BrowserViewIdDao_Impl.4
            @Override // androidx.room.EntityInsertAdapter
            protected String b() {
                return "INSERT INTO `BrowserViewId` (`id`,`packageName`,`viewId`,`viewType`,`clearUrl`,`showLocalHtml`,`detectionMethod`,`extractionMethod`,`clickToOpenUrlBarViewId`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertAdapter
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public void a(SQLiteStatement statement, BrowserViewId entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.A(1, entity.getId());
                statement.p0(2, entity.getPackageName());
                statement.p0(3, entity.getViewId());
                statement.A(4, BrowserViewIdDao_Impl.this.f125015g.b(entity.getViewType()));
                statement.A(5, entity.getClearUrl() ? 1L : 0L);
                statement.A(6, entity.getShowLocalHtml() ? 1L : 0L);
                String strB = BrowserViewIdDao_Impl.this.f125016h.b(entity.getDetectionMethod());
                if (strB == null) {
                    statement.D(7);
                } else {
                    statement.p0(7, strB);
                }
                String strB2 = BrowserViewIdDao_Impl.this.f125017i.b(entity.getExtractionMethod());
                if (strB2 == null) {
                    statement.D(8);
                } else {
                    statement.p0(8, strB2);
                }
                String clickToOpenUrlBarViewId = entity.getClickToOpenUrlBarViewId();
                if (clickToOpenUrlBarViewId == null) {
                    statement.D(9);
                } else {
                    statement.p0(9, clickToOpenUrlBarViewId);
                }
            }
        }, new EntityDeleteOrUpdateAdapter<BrowserViewId>() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.BrowserViewIdDao_Impl.5
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            protected String b() {
                return "UPDATE `BrowserViewId` SET `id` = ?,`packageName` = ?,`viewId` = ?,`viewType` = ?,`clearUrl` = ?,`showLocalHtml` = ?,`detectionMethod` = ?,`extractionMethod` = ?,`clickToOpenUrlBarViewId` = ? WHERE `id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public void a(SQLiteStatement statement, BrowserViewId entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.A(1, entity.getId());
                statement.p0(2, entity.getPackageName());
                statement.p0(3, entity.getViewId());
                statement.A(4, BrowserViewIdDao_Impl.this.f125015g.b(entity.getViewType()));
                statement.A(5, entity.getClearUrl() ? 1L : 0L);
                statement.A(6, entity.getShowLocalHtml() ? 1L : 0L);
                String strB = BrowserViewIdDao_Impl.this.f125016h.b(entity.getDetectionMethod());
                if (strB == null) {
                    statement.D(7);
                } else {
                    statement.p0(7, strB);
                }
                String strB2 = BrowserViewIdDao_Impl.this.f125017i.b(entity.getExtractionMethod());
                if (strB2 == null) {
                    statement.D(8);
                } else {
                    statement.p0(8, strB2);
                }
                String clickToOpenUrlBarViewId = entity.getClickToOpenUrlBarViewId();
                if (clickToOpenUrlBarViewId == null) {
                    statement.D(9);
                } else {
                    statement.p0(9, clickToOpenUrlBarViewId);
                }
                statement.A(10, entity.getId());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List h0(String str, BrowserViewIdDao_Impl browserViewIdDao_Impl, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        try {
            int iD = SQLiteStatementUtil.d(sQLiteStatementG2, "id");
            int iD2 = SQLiteStatementUtil.d(sQLiteStatementG2, "packageName");
            int iD3 = SQLiteStatementUtil.d(sQLiteStatementG2, "viewId");
            int iD4 = SQLiteStatementUtil.d(sQLiteStatementG2, "viewType");
            int iD5 = SQLiteStatementUtil.d(sQLiteStatementG2, "clearUrl");
            int iD6 = SQLiteStatementUtil.d(sQLiteStatementG2, "showLocalHtml");
            int iD7 = SQLiteStatementUtil.d(sQLiteStatementG2, "detectionMethod");
            int iD8 = SQLiteStatementUtil.d(sQLiteStatementG2, "extractionMethod");
            int iD9 = SQLiteStatementUtil.d(sQLiteStatementG2, "clickToOpenUrlBarViewId");
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementG2.B2()) {
                long j3 = sQLiteStatementG2.getLong(iD);
                String strF2 = sQLiteStatementG2.f2(iD2);
                String strF22 = sQLiteStatementG2.f2(iD3);
                BrowserViewId.ViewType viewTypeA = browserViewIdDao_Impl.f125015g.a((int) sQLiteStatementG2.getLong(iD4));
                boolean z2 = true;
                if (((int) sQLiteStatementG2.getLong(iD5)) == 0) {
                    z2 = false;
                }
                arrayList.add(new BrowserViewId(j3, strF2, strF22, viewTypeA, z2, ((int) sQLiteStatementG2.getLong(iD6)) != 0, browserViewIdDao_Impl.f125016h.a(sQLiteStatementG2.isNull(iD7) ? null : sQLiteStatementG2.f2(iD7)), browserViewIdDao_Impl.f125017i.a(sQLiteStatementG2.isNull(iD8) ? null : sQLiteStatementG2.f2(iD8)), sQLiteStatementG2.isNull(iD9) ? null : sQLiteStatementG2.f2(iD9)));
            }
            return arrayList;
        } finally {
            sQLiteStatementG2.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List i0(String str, BrowserViewIdDao_Impl browserViewIdDao_Impl, BrowserViewId.ViewType viewType, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        try {
            boolean z2 = true;
            sQLiteStatementG2.A(1, browserViewIdDao_Impl.f125015g.b(viewType));
            int iD = SQLiteStatementUtil.d(sQLiteStatementG2, "id");
            int iD2 = SQLiteStatementUtil.d(sQLiteStatementG2, "packageName");
            int iD3 = SQLiteStatementUtil.d(sQLiteStatementG2, "viewId");
            int iD4 = SQLiteStatementUtil.d(sQLiteStatementG2, "viewType");
            int iD5 = SQLiteStatementUtil.d(sQLiteStatementG2, "clearUrl");
            int iD6 = SQLiteStatementUtil.d(sQLiteStatementG2, "showLocalHtml");
            int iD7 = SQLiteStatementUtil.d(sQLiteStatementG2, "detectionMethod");
            int iD8 = SQLiteStatementUtil.d(sQLiteStatementG2, "extractionMethod");
            int iD9 = SQLiteStatementUtil.d(sQLiteStatementG2, "clickToOpenUrlBarViewId");
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementG2.B2()) {
                int i3 = iD3;
                arrayList.add(new BrowserViewId(sQLiteStatementG2.getLong(iD), sQLiteStatementG2.f2(iD2), sQLiteStatementG2.f2(iD3), browserViewIdDao_Impl.f125015g.a((int) sQLiteStatementG2.getLong(iD4)), ((int) sQLiteStatementG2.getLong(iD5)) != 0 ? z2 : false, ((int) sQLiteStatementG2.getLong(iD6)) != 0, browserViewIdDao_Impl.f125016h.a(sQLiteStatementG2.isNull(iD7) ? null : sQLiteStatementG2.f2(iD7)), browserViewIdDao_Impl.f125017i.a(sQLiteStatementG2.isNull(iD8) ? null : sQLiteStatementG2.f2(iD8)), sQLiteStatementG2.isNull(iD9) ? null : sQLiteStatementG2.f2(iD9)));
                iD3 = i3;
                z2 = true;
            }
            return arrayList;
        } finally {
            sQLiteStatementG2.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int j0(String str, BrowserViewIdDao_Impl browserViewIdDao_Impl, BrowserViewId.ViewType viewType, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        try {
            sQLiteStatementG2.A(1, browserViewIdDao_Impl.f125015g.b(viewType));
            return sQLiteStatementG2.B2() ? (int) sQLiteStatementG2.getLong(0) : 0;
        } finally {
            sQLiteStatementG2.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List k0(BrowserViewIdDao_Impl browserViewIdDao_Impl, Collection collection, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        return browserViewIdDao_Impl.f125014f.e(_connection, collection);
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.blocking.BrowserViewIdDao
    public Flow J() {
        final String str = "SELECT * FROM BrowserViewId";
        return FlowUtil.a(this.f125013d, true, new String[]{"BrowserViewId"}, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.i1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BrowserViewIdDao_Impl.h0(str, this, (SQLiteConnection) obj);
            }
        });
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.blocking.BrowserViewIdDao
    public Object K(final BrowserViewId.ViewType viewType, Continuation continuation) {
        final String str = "SELECT * FROM BrowserViewId WHERE viewType = ?";
        return DBUtil.g(this.f125013d, true, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.k1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BrowserViewIdDao_Impl.i0(str, this, viewType, (SQLiteConnection) obj);
            }
        }, continuation);
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.blocking.BrowserViewIdDao
    public Object M(final BrowserViewId.ViewType viewType, Continuation continuation) {
        final String str = "SELECT COUNT(*) FROM BrowserViewId WHERE viewType = ?";
        return DBUtil.g(this.f125013d, true, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.h1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Integer.valueOf(BrowserViewIdDao_Impl.j0(str, this, viewType, (SQLiteConnection) obj));
            }
        }, continuation);
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.blocking.BrowserViewIdDao
    public Object O(Continuation continuation) {
        return DBUtil.f(this.f125013d, new BrowserViewIdDao_Impl$getUnsupportedBrowserPackageNames$2(this, null), continuation);
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.blocking.BrowserViewIdDao
    public Object R(Context context, String str, BrowserViewId.ViewType viewType, Continuation continuation) {
        Object objF = DBUtil.f(this.f125013d, new BrowserViewIdDao_Impl$insertDefault$2(this, context, str, viewType, null), continuation);
        return objF == IntrinsicsKt.f() ? objF : Unit.f139807a;
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.BaseDao
    public Object t(final Collection collection, Continuation continuation) {
        return DBUtil.g(this.f125013d, false, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.j1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BrowserViewIdDao_Impl.k0(this.f125491a, collection, (SQLiteConnection) obj);
            }
        }, continuation);
    }
}
