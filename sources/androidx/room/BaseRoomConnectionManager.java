package androidx.room;

import androidx.compose.material.icons.twotone.Phg.QaXmqxvjHhxVy;
import androidx.room.BaseRoomConnectionManager;
import androidx.room.RoomDatabase;
import androidx.room.RoomOpenDelegate;
import androidx.room.concurrent.ExclusiveLock;
import androidx.room.migration.Migration;
import androidx.room.util.MigrationUtil;
import androidx.sqlite.SQLite;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteDriver;
import androidx.sqlite.SQLiteStatement;
import com.bumptech.glide.load.data.Bwyd.SbbqvQlxi;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jdk7.AutoCloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

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
/* JADX INFO: loaded from: classes2.dex */
@Metadata
public abstract class BaseRoomConnectionManager {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Companion f52093c = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f52094a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f52095b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes3.dex */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes3.dex */
    @Metadata
    protected final class DriverWrapper implements SQLiteDriver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final SQLiteDriver f52096a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ BaseRoomConnectionManager f52097b;

        public DriverWrapper(BaseRoomConnectionManager baseRoomConnectionManager, SQLiteDriver actual) {
            Intrinsics.checkNotNullParameter(actual, "actual");
            this.f52097b = baseRoomConnectionManager;
            this.f52096a = actual;
        }

        private final SQLiteConnection d(final String str) {
            ExclusiveLock exclusiveLock = new ExclusiveLock(str, (this.f52097b.f52094a || this.f52097b.f52095b || Intrinsics.areEqual(str, ":memory:")) ? false : true);
            final BaseRoomConnectionManager baseRoomConnectionManager = this.f52097b;
            return (SQLiteConnection) exclusiveLock.b(new Function0() { // from class: androidx.room.a
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return BaseRoomConnectionManager.DriverWrapper.e(baseRoomConnectionManager, this, str);
                }
            }, new Function1() { // from class: androidx.room.BaseRoomConnectionManager$DriverWrapper$openLocked$2
                @Override // kotlin.jvm.functions.Function1
                /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                public final Void invoke(Throwable error) {
                    Intrinsics.checkNotNullParameter(error, "error");
                    throw new IllegalStateException("Unable to open database '" + str + "'. Was a proper path / name used in Room's database builder?", error);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final SQLiteConnection e(BaseRoomConnectionManager baseRoomConnectionManager, DriverWrapper driverWrapper, String str) throws Exception {
            if (baseRoomConnectionManager.f52095b) {
                throw new IllegalStateException("Recursive database initialization detected. Did you try to use the database instance during initialization? Maybe in one of the callbacks?");
            }
            SQLiteConnection sQLiteConnectionA = driverWrapper.f52096a.a(str);
            if (baseRoomConnectionManager.f52094a) {
                baseRoomConnectionManager.g(sQLiteConnectionA);
                return sQLiteConnectionA;
            }
            try {
                baseRoomConnectionManager.f52095b = true;
                baseRoomConnectionManager.i(sQLiteConnectionA);
                return sQLiteConnectionA;
            } finally {
                baseRoomConnectionManager.f52095b = false;
            }
        }

        @Override // androidx.sqlite.SQLiteDriver
        public SQLiteConnection a(String fileName) {
            Intrinsics.checkNotNullParameter(fileName, "fileName");
            return d(this.f52097b.A(fileName));
        }

        @Override // androidx.sqlite.SQLiteDriver
        public boolean b() {
            return this.f52096a.b();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes3.dex */
    @Metadata
    public static final /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f52099a;

        static {
            int[] iArr = new int[RoomDatabase.JournalMode.values().length];
            try {
                iArr[RoomDatabase.JournalMode.f52287b.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[RoomDatabase.JournalMode.f52288c.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f52099a = iArr;
        }
    }

    private final void B(SQLiteConnection sQLiteConnection) throws Exception {
        l(sQLiteConnection);
        SQLite.a(sQLiteConnection, RoomMasterTable.a(r().c()));
    }

    private final void f(SQLiteConnection sQLiteConnection) throws Exception {
        Object objB;
        RoomOpenDelegate.ValidationResult validationResultJ;
        if (t(sQLiteConnection)) {
            SQLiteStatement sQLiteStatementG2 = sQLiteConnection.G2("SELECT identity_hash FROM room_master_table WHERE id = 42 LIMIT 1");
            try {
                String strF2 = sQLiteStatementG2.B2() ? sQLiteStatementG2.f2(0) : null;
                AutoCloseableKt.a(sQLiteStatementG2, null);
                if (Intrinsics.areEqual(r().c(), strF2) || Intrinsics.areEqual(r().d(), strF2)) {
                    return;
                }
                throw new IllegalStateException(("Room cannot verify the data integrity. Looks like you've changed schema but forgot to update the version number. You can simply fix this by increasing the version number. Expected identity hash: " + r().c() + ", found: " + strF2).toString());
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    AutoCloseableKt.a(sQLiteStatementG2, th);
                    throw th2;
                }
            }
        }
        SQLite.a(sQLiteConnection, "BEGIN EXCLUSIVE TRANSACTION");
        try {
            Result.Companion companion = Result.f139772b;
            validationResultJ = r().j(sQLiteConnection);
        } catch (Throwable th3) {
            Result.Companion companion2 = Result.f139772b;
            objB = Result.b(ResultKt.a(th3));
        }
        if (!validationResultJ.f52342a) {
            throw new IllegalStateException(("Pre-packaged database has an invalid schema: " + validationResultJ.f52343b).toString());
        }
        r().h(sQLiteConnection);
        B(sQLiteConnection);
        objB = Result.b(Unit.f139807a);
        if (Result.h(objB)) {
            SQLite.a(sQLiteConnection, "END TRANSACTION");
        }
        Throwable thE = Result.e(objB);
        if (thE == null) {
            Result.a(objB);
        } else {
            SQLite.a(sQLiteConnection, "ROLLBACK TRANSACTION");
            throw thE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g(SQLiteConnection sQLiteConnection) throws Exception {
        k(sQLiteConnection);
        h(sQLiteConnection);
        r().g(sQLiteConnection);
    }

    private final void h(SQLiteConnection sQLiteConnection) throws Exception {
        SQLiteStatement sQLiteStatementG2 = sQLiteConnection.G2("PRAGMA busy_timeout");
        try {
            sQLiteStatementG2.B2();
            long j3 = sQLiteStatementG2.getLong(0);
            AutoCloseableKt.a(sQLiteStatementG2, null);
            if (j3 < 3000) {
                SQLite.a(sQLiteConnection, "PRAGMA busy_timeout = 3000");
            }
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                AutoCloseableKt.a(sQLiteStatementG2, th);
                throw th2;
            }
        }
    }

    private final void j(SQLiteConnection sQLiteConnection) throws Exception {
        if (o().f52133g == RoomDatabase.JournalMode.f52288c) {
            SQLite.a(sQLiteConnection, "PRAGMA journal_mode = WAL");
        } else {
            SQLite.a(sQLiteConnection, "PRAGMA journal_mode = TRUNCATE");
        }
    }

    private final void k(SQLiteConnection sQLiteConnection) throws Exception {
        if (o().f52133g == RoomDatabase.JournalMode.f52288c) {
            SQLite.a(sQLiteConnection, "PRAGMA synchronous = NORMAL");
        } else {
            SQLite.a(sQLiteConnection, "PRAGMA synchronous = FULL");
        }
    }

    private final void l(SQLiteConnection sQLiteConnection) throws Exception {
        SQLite.a(sQLiteConnection, "CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
    }

    private final void m(SQLiteConnection sQLiteConnection) throws Exception {
        if (!o().f52146t) {
            r().b(sQLiteConnection);
            return;
        }
        SQLiteStatement sQLiteStatementG2 = sQLiteConnection.G2("SELECT name, type FROM sqlite_master WHERE type = 'table' OR type = 'view'");
        try {
            List listCreateListBuilder = CollectionsKt.createListBuilder();
            while (sQLiteStatementG2.B2()) {
                String strF2 = sQLiteStatementG2.f2(0);
                if (!StringsKt.U(strF2, "sqlite_", false, 2, null) && !Intrinsics.areEqual(strF2, "android_metadata")) {
                    listCreateListBuilder.add(TuplesKt.a(strF2, Boolean.valueOf(Intrinsics.areEqual(sQLiteStatementG2.f2(1), ViewHierarchyConstants.VIEW_KEY))));
                }
            }
            List<Pair> listBuild = CollectionsKt.build(listCreateListBuilder);
            AutoCloseableKt.a(sQLiteStatementG2, null);
            for (Pair pair : listBuild) {
                String str = (String) pair.a();
                if (((Boolean) pair.b()).booleanValue()) {
                    SQLite.a(sQLiteConnection, "DROP VIEW IF EXISTS `" + str + '`');
                } else {
                    SQLite.a(sQLiteConnection, "DROP TABLE IF EXISTS `" + str + '`');
                }
            }
        } finally {
        }
    }

    private final boolean s(SQLiteConnection sQLiteConnection) throws Exception {
        SQLiteStatement sQLiteStatementG2 = sQLiteConnection.G2("SELECT count(*) FROM sqlite_master WHERE name != 'android_metadata'");
        try {
            boolean z2 = false;
            if (sQLiteStatementG2.B2()) {
                if (sQLiteStatementG2.getLong(0) == 0) {
                    z2 = true;
                }
            }
            AutoCloseableKt.a(sQLiteStatementG2, null);
            return z2;
        } finally {
        }
    }

    private final boolean t(SQLiteConnection sQLiteConnection) throws Exception {
        SQLiteStatement sQLiteStatementG2 = sQLiteConnection.G2("SELECT 1 FROM sqlite_master WHERE type = 'table' AND name = 'room_master_table'");
        try {
            boolean z2 = false;
            if (sQLiteStatementG2.B2()) {
                if (sQLiteStatementG2.getLong(0) != 0) {
                    z2 = true;
                }
            }
            AutoCloseableKt.a(sQLiteStatementG2, null);
            return z2;
        } finally {
        }
    }

    private final void u(SQLiteConnection sQLiteConnection) {
        Iterator it = n().iterator();
        while (it.hasNext()) {
            ((RoomDatabase.Callback) it.next()).a(sQLiteConnection);
        }
    }

    private final void v(SQLiteConnection sQLiteConnection) {
        Iterator it = n().iterator();
        while (it.hasNext()) {
            ((RoomDatabase.Callback) it.next()).c(sQLiteConnection);
        }
    }

    private final void w(SQLiteConnection sQLiteConnection) {
        Iterator it = n().iterator();
        while (it.hasNext()) {
            ((RoomDatabase.Callback) it.next()).e(sQLiteConnection);
        }
    }

    public String A(String fileName) {
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        return fileName;
    }

    protected abstract List n();

    protected abstract DatabaseConfiguration o();

    protected final int p(RoomDatabase.JournalMode journalMode) {
        Intrinsics.checkNotNullParameter(journalMode, "<this>");
        int i3 = WhenMappings.f52099a[journalMode.ordinal()];
        if (i3 == 1) {
            return 1;
        }
        if (i3 == 2) {
            return 4;
        }
        throw new IllegalStateException(("Can't get max number of reader for journal mode '" + journalMode + '\'').toString());
    }

    protected final int q(RoomDatabase.JournalMode journalMode) {
        Intrinsics.checkNotNullParameter(journalMode, "<this>");
        int i3 = WhenMappings.f52099a[journalMode.ordinal()];
        if (i3 == 1 || i3 == 2) {
            return 1;
        }
        throw new IllegalStateException(("Can't get max number of writers for journal mode '" + journalMode + '\'').toString());
    }

    protected abstract RoomOpenDelegate r();

    protected final void x(SQLiteConnection connection) {
        Intrinsics.checkNotNullParameter(connection, "connection");
        boolean zS = s(connection);
        r().a(connection);
        if (!zS) {
            RoomOpenDelegate.ValidationResult validationResultJ = r().j(connection);
            if (!validationResultJ.f52342a) {
                throw new IllegalStateException(("Pre-packaged database has an invalid schema: " + validationResultJ.f52343b).toString());
            }
        }
        B(connection);
        r().f(connection);
        u(connection);
    }

    protected final void z(SQLiteConnection connection) {
        Intrinsics.checkNotNullParameter(connection, "connection");
        f(connection);
        r().g(connection);
        w(connection);
        this.f52094a = true;
    }

    protected final void y(SQLiteConnection connection, int i3, int i4) {
        Intrinsics.checkNotNullParameter(connection, "connection");
        List listB = MigrationUtil.b(o().f52130d, i3, i4);
        if (listB == null) {
            if (!MigrationUtil.d(o(), i3, i4)) {
                m(connection);
                v(connection);
                r().a(connection);
                return;
            } else {
                throw new IllegalStateException(("A migration from " + i3 + " to " + i4 + SbbqvQlxi.ZonILS).toString());
            }
        }
        r().i(connection);
        Iterator it = listB.iterator();
        while (it.hasNext()) {
            ((Migration) it.next()).a(connection);
        }
        RoomOpenDelegate.ValidationResult validationResultJ = r().j(connection);
        if (validationResultJ.f52342a) {
            r().h(connection);
            B(connection);
        } else {
            throw new IllegalStateException(("Migration didn't properly handle: " + validationResultJ.f52343b).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i(SQLiteConnection sQLiteConnection) throws Exception {
        Object objB;
        j(sQLiteConnection);
        k(sQLiteConnection);
        h(sQLiteConnection);
        SQLiteStatement sQLiteStatementG2 = sQLiteConnection.G2("PRAGMA user_version");
        try {
            sQLiteStatementG2.B2();
            int i3 = (int) sQLiteStatementG2.getLong(0);
            AutoCloseableKt.a(sQLiteStatementG2, null);
            if (i3 != r().e()) {
                SQLite.a(sQLiteConnection, QaXmqxvjHhxVy.ThkG);
                try {
                    Result.Companion companion = Result.f139772b;
                    if (i3 == 0) {
                        x(sQLiteConnection);
                    } else {
                        y(sQLiteConnection, i3, r().e());
                    }
                    SQLite.a(sQLiteConnection, "PRAGMA user_version = " + r().e());
                    objB = Result.b(Unit.f139807a);
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.f139772b;
                    objB = Result.b(ResultKt.a(th));
                }
                if (Result.h(objB)) {
                    SQLite.a(sQLiteConnection, "END TRANSACTION");
                }
                Throwable thE = Result.e(objB);
                if (thE != null) {
                    SQLite.a(sQLiteConnection, "ROLLBACK TRANSACTION");
                    throw thE;
                }
            }
            z(sQLiteConnection);
        } finally {
        }
    }
}
