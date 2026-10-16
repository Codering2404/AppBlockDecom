package cz.mobilesoft.statistics.model.datasource;

import android.database.Cursor;
import android.util.Log;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class MigrationsKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Migration f133762a = new Migration() { // from class: cz.mobilesoft.statistics.model.datasource.MigrationsKt$MIGRATION_1_2$1
        @Override // androidx.room.migration.Migration
        public void b(SupportSQLiteDatabase db) {
            Intrinsics.checkNotNullParameter(db, "db");
            long jCurrentTimeMillis = System.currentTimeMillis();
            db.S("DELETE FROM record\n                                    WHERE rowid NOT IN (\n                                    SELECT MIN(rowid) \n                                    FROM record \n                                    GROUP BY timestamp, typeId\n                                )");
            db.S("CREATE UNIQUE INDEX IF NOT EXISTS index_record_timestamp_typeId ON record(timestamp, typeId)");
            Log.d("Statistics", "Migration 1 >> 2 took " + (System.currentTimeMillis() - jCurrentTimeMillis) + " ms");
        }
    };

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Migration f133763b = new Migration() { // from class: cz.mobilesoft.statistics.model.datasource.MigrationsKt$MIGRATION_2_3$1
        @Override // androidx.room.migration.Migration
        public void b(SupportSQLiteDatabase db) {
            Intrinsics.checkNotNullParameter(db, "db");
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (!MigrationsKt.b(db, "record", "originalBeginTime")) {
                db.S("ALTER TABLE record ADD COLUMN originalBeginTime INTEGER NOT NULL DEFAULT 0;");
                db.S("UPDATE record SET originalBeginTime = 0;");
            }
            db.S("DROP INDEX IF EXISTS index_record_timestamp_typeId");
            db.S("CREATE UNIQUE INDEX IF NOT EXISTS index_record_timestamp_originalBeginTime_typeId ON record(timestamp, originalBeginTime, typeId);");
            Log.d("Statistics", "Migration 2 >> 3 took " + (System.currentTimeMillis() - jCurrentTimeMillis) + " ms");
        }
    };

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Migration f133764c = new Migration() { // from class: cz.mobilesoft.statistics.model.datasource.MigrationsKt$MIGRATION_3_4$1
        @Override // androidx.room.migration.Migration
        public void b(SupportSQLiteDatabase db) {
            Intrinsics.checkNotNullParameter(db, "db");
            if (!MigrationsKt.b(db, "record", "appType")) {
                db.S("ALTER TABLE record ADD COLUMN appType TEXT;");
            }
            if (MigrationsKt.b(db, "category", "appType")) {
                return;
            }
            db.S("ALTER TABLE record ADD COLUMN category TEXT;");
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean b(SupportSQLiteDatabase supportSQLiteDatabase, String str, String str2) {
        Cursor cursorP1 = null;
        try {
            boolean z2 = false;
            cursorP1 = supportSQLiteDatabase.p1("PRAGMA table_info(" + str + ")", new Object[0]);
            int columnIndexOrThrow = cursorP1.getColumnIndexOrThrow("name");
            while (true) {
                if (!cursorP1.moveToNext()) {
                    break;
                }
                if (Intrinsics.areEqual(cursorP1.getString(columnIndexOrThrow), str2)) {
                    z2 = true;
                    break;
                }
            }
            cursorP1.close();
            return z2;
        } catch (Throwable th) {
            if (cursorP1 != null) {
                cursorP1.close();
            }
            throw th;
        }
    }

    public static final Migration c() {
        return f133762a;
    }

    public static final Migration d() {
        return f133763b;
    }

    public static final Migration e() {
        return f133764c;
    }
}
