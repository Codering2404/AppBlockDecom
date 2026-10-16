package androidx.room;

import androidx.room.BaseRoomConnectionManager;
import androidx.room.RoomDatabase;
import androidx.room.RoomOpenDelegate;
import androidx.room.coroutines.ConnectionPool;
import androidx.room.coroutines.ConnectionPoolKt;
import androidx.room.coroutines.PassthroughConnectionPool;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteDriver;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.driver.SupportSQLiteConnection;
import androidx.sqlite.driver.SupportSQLiteDriver;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class RoomConnectionManager extends BaseRoomConnectionManager {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final DatabaseConfiguration f52252d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final RoomOpenDelegate f52253e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final List f52254f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final ConnectionPool f52255g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final SupportSQLiteOpenHelper f52256h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private SupportSQLiteDatabase f52257i;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class NoOpOpenDelegate extends RoomOpenDelegate {
        public NoOpOpenDelegate() {
            super(-1, "", "");
        }

        @Override // androidx.room.RoomOpenDelegate
        public void a(SQLiteConnection connection) {
            Intrinsics.checkNotNullParameter(connection, "connection");
            throw new IllegalStateException("NOP delegate should never be called");
        }

        @Override // androidx.room.RoomOpenDelegate
        public void b(SQLiteConnection connection) {
            Intrinsics.checkNotNullParameter(connection, "connection");
            throw new IllegalStateException("NOP delegate should never be called");
        }

        @Override // androidx.room.RoomOpenDelegate
        public void f(SQLiteConnection connection) {
            Intrinsics.checkNotNullParameter(connection, "connection");
            throw new IllegalStateException("NOP delegate should never be called");
        }

        @Override // androidx.room.RoomOpenDelegate
        public void g(SQLiteConnection connection) {
            Intrinsics.checkNotNullParameter(connection, "connection");
            throw new IllegalStateException("NOP delegate should never be called");
        }

        @Override // androidx.room.RoomOpenDelegate
        public void h(SQLiteConnection connection) {
            Intrinsics.checkNotNullParameter(connection, "connection");
            throw new IllegalStateException("NOP delegate should never be called");
        }

        @Override // androidx.room.RoomOpenDelegate
        public void i(SQLiteConnection connection) {
            Intrinsics.checkNotNullParameter(connection, "connection");
            throw new IllegalStateException("NOP delegate should never be called");
        }

        @Override // androidx.room.RoomOpenDelegate
        public RoomOpenDelegate.ValidationResult j(SQLiteConnection connection) {
            Intrinsics.checkNotNullParameter(connection, "connection");
            throw new IllegalStateException("NOP delegate should never be called");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public final class SupportOpenHelperCallback extends SupportSQLiteOpenHelper.Callback {
        public SupportOpenHelperCallback(int i3) {
            super(i3);
        }

        @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Callback
        public void d(SupportSQLiteDatabase db) {
            Intrinsics.checkNotNullParameter(db, "db");
            RoomConnectionManager.this.x(new SupportSQLiteConnection(db));
        }

        @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Callback
        public void e(SupportSQLiteDatabase db, int i3, int i4) {
            Intrinsics.checkNotNullParameter(db, "db");
            g(db, i3, i4);
        }

        @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Callback
        public void f(SupportSQLiteDatabase db) {
            Intrinsics.checkNotNullParameter(db, "db");
            RoomConnectionManager.this.z(new SupportSQLiteConnection(db));
            RoomConnectionManager.this.f52257i = db;
        }

        @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Callback
        public void g(SupportSQLiteDatabase db, int i3, int i4) {
            Intrinsics.checkNotNullParameter(db, "db");
            RoomConnectionManager.this.y(new SupportSQLiteConnection(db), i3, i4);
        }
    }

    public RoomConnectionManager(DatabaseConfiguration config, RoomOpenDelegate openDelegate, Function2 transactionWrapper) {
        ConnectionPool connectionPoolB;
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(openDelegate, "openDelegate");
        Intrinsics.checkNotNullParameter(transactionWrapper, "transactionWrapper");
        this.f52252d = config;
        this.f52253e = openDelegate;
        List list = config.f52131e;
        this.f52254f = list == null ? CollectionsKt.emptyList() : list;
        SQLiteDriver sQLiteDriver = config.f52147u;
        if (sQLiteDriver != null) {
            this.f52256h = null;
            if (sQLiteDriver.b()) {
                BaseRoomConnectionManager.DriverWrapper driverWrapper = new BaseRoomConnectionManager.DriverWrapper(this, config.f52147u);
                String str = config.f52128b;
                connectionPoolB = new PassthroughConnectionPool(driverWrapper, str != null ? str : ":memory:", transactionWrapper);
            } else {
                connectionPoolB = config.f52128b == null ? ConnectionPoolKt.b(new BaseRoomConnectionManager.DriverWrapper(this, config.f52147u), ":memory:") : ConnectionPoolKt.a(new BaseRoomConnectionManager.DriverWrapper(this, config.f52147u), config.f52128b, p(config.f52133g), q(config.f52133g));
            }
            this.f52255g = connectionPoolB;
        } else {
            if (config.f52129c == null) {
                throw new IllegalArgumentException("SQLiteManager was constructed with both null driver and open helper factory!");
            }
            SupportSQLiteOpenHelper supportSQLiteOpenHelperA = config.f52129c.a(SupportSQLiteOpenHelper.Configuration.f53168f.a(config.f52127a).d(config.f52128b).c(new SupportOpenHelperCallback(openDelegate.e())).b());
            this.f52256h = supportSQLiteOpenHelperA;
            SupportSQLiteDriver supportSQLiteDriver = new SupportSQLiteDriver(supportSQLiteOpenHelperA);
            String str2 = config.f52128b;
            this.f52255g = new PassthroughConnectionPool(supportSQLiteDriver, str2 != null ? str2 : ":memory:", transactionWrapper);
        }
        H();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit D(RoomConnectionManager roomConnectionManager, SupportSQLiteDatabase db) {
        Intrinsics.checkNotNullParameter(db, "db");
        roomConnectionManager.f52257i = db;
        return Unit.f139807a;
    }

    private final void H() {
        boolean z2 = o().f52133g == RoomDatabase.JournalMode.f52288c;
        SupportSQLiteOpenHelper supportSQLiteOpenHelper = this.f52256h;
        if (supportSQLiteOpenHelper != null) {
            supportSQLiteOpenHelper.setWriteAheadLoggingEnabled(z2);
        }
    }

    private final DatabaseConfiguration I(DatabaseConfiguration databaseConfiguration, final Function1 function1) {
        List listEmptyList = databaseConfiguration.f52131e;
        if (listEmptyList == null) {
            listEmptyList = CollectionsKt.emptyList();
        }
        return DatabaseConfiguration.b(databaseConfiguration, null, null, null, null, CollectionsKt.plus((Collection<? extends RoomDatabase.Callback>) listEmptyList, new RoomDatabase.Callback() { // from class: androidx.room.RoomConnectionManager$installOnOpenCallback$newCallbacks$1
            @Override // androidx.room.RoomDatabase.Callback
            public void f(SupportSQLiteDatabase db) {
                Intrinsics.checkNotNullParameter(db, "db");
                function1.invoke(db);
            }
        }), false, null, null, null, null, false, false, null, null, null, null, null, null, null, false, null, null, 4194287, null);
    }

    @Override // androidx.room.BaseRoomConnectionManager
    public String A(String fileName) {
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        if (Intrinsics.areEqual(fileName, ":memory:")) {
            return fileName;
        }
        String absolutePath = o().f52127a.getDatabasePath(fileName).getAbsolutePath();
        Intrinsics.checkNotNull(absolutePath);
        return absolutePath;
    }

    public final void F() {
        this.f52255g.close();
        SupportSQLiteOpenHelper supportSQLiteOpenHelper = this.f52256h;
        if (supportSQLiteOpenHelper != null) {
            supportSQLiteOpenHelper.close();
        }
    }

    public final SupportSQLiteOpenHelper G() {
        return this.f52256h;
    }

    public final boolean J() {
        SupportSQLiteDatabase supportSQLiteDatabase = this.f52257i;
        if (supportSQLiteDatabase != null) {
            return supportSQLiteDatabase.isOpen();
        }
        return false;
    }

    public Object K(boolean z2, Function2 function2, Continuation continuation) {
        return this.f52255g.h0(z2, function2, continuation);
    }

    @Override // androidx.room.BaseRoomConnectionManager
    protected List n() {
        return this.f52254f;
    }

    @Override // androidx.room.BaseRoomConnectionManager
    protected DatabaseConfiguration o() {
        return this.f52252d;
    }

    @Override // androidx.room.BaseRoomConnectionManager
    protected RoomOpenDelegate r() {
        return this.f52253e;
    }

    public RoomConnectionManager(DatabaseConfiguration config, Function1 supportOpenHelperFactory, Function2 transactionWrapper) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(supportOpenHelperFactory, "supportOpenHelperFactory");
        Intrinsics.checkNotNullParameter(transactionWrapper, "transactionWrapper");
        this.f52252d = config;
        this.f52253e = new NoOpOpenDelegate();
        List list = config.f52131e;
        this.f52254f = list == null ? CollectionsKt.emptyList() : list;
        SupportSQLiteOpenHelper supportSQLiteOpenHelper = (SupportSQLiteOpenHelper) supportOpenHelperFactory.invoke(I(config, new Function1() { // from class: androidx.room.e
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return RoomConnectionManager.D(this.f52652a, (SupportSQLiteDatabase) obj);
            }
        }));
        this.f52256h = supportSQLiteOpenHelper;
        SupportSQLiteDriver supportSQLiteDriver = new SupportSQLiteDriver(supportSQLiteOpenHelper);
        String str = config.f52128b;
        this.f52255g = new PassthroughConnectionPool(supportSQLiteDriver, str == null ? ":memory:" : str, transactionWrapper);
        H();
    }
}
