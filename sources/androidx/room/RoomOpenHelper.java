package androidx.room;

import android.database.Cursor;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SimpleSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.driver.SupportSQLiteConnection;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.xn.YvFRmou;
import kotlin.io.CloseableKt;
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
@Deprecated
@Metadata
public class RoomOpenHelper extends SupportSQLiteOpenHelper.Callback {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Companion f52344h = new Companion(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private DatabaseConfiguration f52345c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final List f52346d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Delegate f52347e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f52348f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final String f52349g;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes3.dex */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(SupportSQLiteDatabase db) {
            Intrinsics.checkNotNullParameter(db, "db");
            Cursor cursorW1 = db.W1("SELECT name, type FROM sqlite_master WHERE type = 'table' OR type = 'view'");
            try {
                List listCreateListBuilder = CollectionsKt.createListBuilder();
                while (cursorW1.moveToNext()) {
                    String string = cursorW1.getString(0);
                    Intrinsics.checkNotNull(string);
                    if (!StringsKt.U(string, "sqlite_", false, 2, null) && !Intrinsics.areEqual(string, "android_metadata")) {
                        listCreateListBuilder.add(TuplesKt.a(string, Boolean.valueOf(Intrinsics.areEqual(cursorW1.getString(1), ViewHierarchyConstants.VIEW_KEY))));
                    }
                }
                List<Pair> listBuild = CollectionsKt.build(listCreateListBuilder);
                CloseableKt.a(cursorW1, null);
                for (Pair pair : listBuild) {
                    String str = (String) pair.a();
                    if (((Boolean) pair.b()).booleanValue()) {
                        db.S("DROP VIEW IF EXISTS " + str);
                    } else {
                        db.S("DROP TABLE IF EXISTS " + str);
                    }
                }
            } finally {
            }
        }

        public final boolean b(SupportSQLiteDatabase db) {
            Intrinsics.checkNotNullParameter(db, "db");
            Cursor cursorW1 = db.W1("SELECT count(*) FROM sqlite_master WHERE name != 'android_metadata'");
            try {
                boolean z2 = false;
                if (cursorW1.moveToFirst()) {
                    if (cursorW1.getInt(0) == 0) {
                        z2 = true;
                    }
                }
                CloseableKt.a(cursorW1, null);
                return z2;
            } finally {
            }
        }

        public final boolean c(SupportSQLiteDatabase db) {
            Intrinsics.checkNotNullParameter(db, "db");
            Cursor cursorW1 = db.W1("SELECT 1 FROM sqlite_master WHERE type = 'table' AND name='room_master_table'");
            try {
                boolean z2 = false;
                if (cursorW1.moveToFirst()) {
                    if (cursorW1.getInt(0) != 0) {
                        z2 = true;
                    }
                }
                CloseableKt.a(cursorW1, null);
                return z2;
            } finally {
            }
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes3.dex */
    @Deprecated
    @Metadata
    public static abstract class Delegate {
        public final int version;

        public Delegate(int i3) {
            this.version = i3;
        }

        public abstract void createAllTables(SupportSQLiteDatabase supportSQLiteDatabase);

        public abstract void dropAllTables(SupportSQLiteDatabase supportSQLiteDatabase);

        public abstract void onCreate(SupportSQLiteDatabase supportSQLiteDatabase);

        public abstract void onOpen(SupportSQLiteDatabase supportSQLiteDatabase);

        public void onPostMigrate(SupportSQLiteDatabase db) {
            Intrinsics.checkNotNullParameter(db, "db");
        }

        public void onPreMigrate(SupportSQLiteDatabase db) {
            Intrinsics.checkNotNullParameter(db, "db");
        }

        public ValidationResult onValidateSchema(SupportSQLiteDatabase db) {
            Intrinsics.checkNotNullParameter(db, "db");
            validateMigration(db);
            return new ValidationResult(true, null);
        }

        @Deprecated
        protected void validateMigration(SupportSQLiteDatabase db) {
            Intrinsics.checkNotNullParameter(db, "db");
            throw new UnsupportedOperationException("validateMigration is deprecated");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes3.dex */
    @Deprecated
    @Metadata
    public static class ValidationResult {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f52350a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f52351b;

        public ValidationResult(boolean z2, String str) {
            this.f52350a = z2;
            this.f52351b = str;
        }
    }

    private final void h(SupportSQLiteDatabase supportSQLiteDatabase) {
        if (!f52344h.c(supportSQLiteDatabase)) {
            ValidationResult validationResultOnValidateSchema = this.f52347e.onValidateSchema(supportSQLiteDatabase);
            if (validationResultOnValidateSchema.f52350a) {
                this.f52347e.onPostMigrate(supportSQLiteDatabase);
                j(supportSQLiteDatabase);
                return;
            } else {
                throw new IllegalStateException("Pre-packaged database has an invalid schema: " + validationResultOnValidateSchema.f52351b);
            }
        }
        Cursor cursorP0 = supportSQLiteDatabase.P0(new SimpleSQLiteQuery("SELECT identity_hash FROM room_master_table WHERE id = 42 LIMIT 1"));
        try {
            String string = cursorP0.moveToFirst() ? cursorP0.getString(0) : null;
            CloseableKt.a(cursorP0, null);
            if (Intrinsics.areEqual(this.f52348f, string) || Intrinsics.areEqual(this.f52349g, string)) {
                return;
            }
            throw new IllegalStateException("Room cannot verify the data integrity. Looks like you've changed schema but forgot to update the version number. You can simply fix this by increasing the version number. Expected identity hash: " + this.f52348f + ", found: " + string);
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.a(cursorP0, th);
                throw th2;
            }
        }
    }

    private final void i(SupportSQLiteDatabase supportSQLiteDatabase) {
        supportSQLiteDatabase.S("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
    }

    private final void j(SupportSQLiteDatabase supportSQLiteDatabase) {
        i(supportSQLiteDatabase);
        supportSQLiteDatabase.S(RoomMasterTable.a(this.f52348f));
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Callback
    public void b(SupportSQLiteDatabase db) {
        Intrinsics.checkNotNullParameter(db, "db");
        super.b(db);
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Callback
    public void d(SupportSQLiteDatabase db) {
        Intrinsics.checkNotNullParameter(db, "db");
        boolean zB = f52344h.b(db);
        this.f52347e.createAllTables(db);
        if (!zB) {
            ValidationResult validationResultOnValidateSchema = this.f52347e.onValidateSchema(db);
            if (!validationResultOnValidateSchema.f52350a) {
                throw new IllegalStateException("Pre-packaged database has an invalid schema: " + validationResultOnValidateSchema.f52351b);
            }
        }
        j(db);
        this.f52347e.onCreate(db);
        List list = this.f52346d;
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ((RoomDatabase.Callback) it.next()).b(db);
            }
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Callback
    public void e(SupportSQLiteDatabase db, int i3, int i4) {
        Intrinsics.checkNotNullParameter(db, "db");
        g(db, i3, i4);
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Callback
    public void f(SupportSQLiteDatabase db) {
        Intrinsics.checkNotNullParameter(db, "db");
        super.f(db);
        h(db);
        this.f52347e.onOpen(db);
        List list = this.f52346d;
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ((RoomDatabase.Callback) it.next()).f(db);
            }
        }
        this.f52345c = null;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Callback
    public void g(SupportSQLiteDatabase db, int i3, int i4) {
        List listD;
        Intrinsics.checkNotNullParameter(db, "db");
        DatabaseConfiguration databaseConfiguration = this.f52345c;
        if (databaseConfiguration != null && (listD = databaseConfiguration.f52130d.d(i3, i4)) != null) {
            this.f52347e.onPreMigrate(db);
            Iterator it = listD.iterator();
            while (it.hasNext()) {
                ((Migration) it.next()).a(new SupportSQLiteConnection(db));
            }
            ValidationResult validationResultOnValidateSchema = this.f52347e.onValidateSchema(db);
            if (validationResultOnValidateSchema.f52350a) {
                this.f52347e.onPostMigrate(db);
                j(db);
                return;
            } else {
                throw new IllegalStateException("Migration didn't properly handle: " + validationResultOnValidateSchema.f52351b);
            }
        }
        DatabaseConfiguration databaseConfiguration2 = this.f52345c;
        if (databaseConfiguration2 == null || databaseConfiguration2.e(i3, i4)) {
            throw new IllegalStateException("A migration from " + i3 + " to " + i4 + " was required but not found. Please provide the necessary Migration path via RoomDatabase.Builder.addMigration(Migration ...) or allow for destructive migrations via one of the RoomDatabase.Builder.fallbackToDestructiveMigration* methods.");
        }
        if (databaseConfiguration2.f52146t) {
            f52344h.a(db);
        } else {
            this.f52347e.dropAllTables(db);
        }
        List list = this.f52346d;
        if (list != null) {
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                ((RoomDatabase.Callback) it2.next()).d(db);
            }
        }
        this.f52347e.createAllTables(db);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoomOpenHelper(DatabaseConfiguration configuration, Delegate delegate, String identityHash, String str) {
        super(delegate.version);
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        Intrinsics.checkNotNullParameter(identityHash, "identityHash");
        Intrinsics.checkNotNullParameter(str, YvFRmou.TckHlPRclhZu);
        this.f52346d = configuration.f52131e;
        this.f52345c = configuration;
        this.f52347e = delegate;
        this.f52348f = identityHash;
        this.f52349g = str;
    }
}
