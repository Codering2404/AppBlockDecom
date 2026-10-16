package cz.mobilesoft.coreblock.storage.greendao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.share.internal.ShareConstants;
import cz.mobilesoft.coreblock.BuildConfig;
import cz.mobilesoft.coreblock.enums.ProfileType;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.BrowserViewId;
import cz.mobilesoft.coreblock.storage.sharedprefs.PrefManager;
import cz.mobilesoft.coreblock.util.CrashHelper;
import java.io.File;
import java.util.Set;
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
public final class GreendaoUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final GreendaoUtils f124809a = new GreendaoUtils();

    private GreendaoUtils() {
    }

    private final void b(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS \"APP_WEBSITE_CATEGORY_RELATION\" \n(\n    \"_id\" INTEGER PRIMARY KEY,\n    \"PACKAGE_NAME\" TEXT NOT NULL,\n    \"HOSTNAME\" TEXT,\n    \"CATEGORY_STRING\" TEXT,\n    \"IS_PRESET\" INTEGER NOT NULL\n);");
        sQLiteDatabase.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS IDX_APP_WEBSITE_CATEGORY_RELATION_PACKAGE_NAME ON \"APP_WEBSITE_CATEGORY_RELATION\" (\"PACKAGE_NAME\" ASC);");
        sQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS IDX_APP_WEBSITE_CATEGORY_RELATION_HOSTNAME ON \"APP_WEBSITE_CATEGORY_RELATION\" (\"HOSTNAME\" ASC);");
    }

    private final void c(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS \"BROWSER_VIEW_ID\" (\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT, \"PACKAGE_NAME\" TEXT, \"VIEW_ID\" TEXT, \"VIEW_TYPE\" INTEGER, \"CLEAR_URL\" INTEGER);");
        sQLiteDatabase.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS IDX_BROWSER_VIEW_ID_PACKAGE_NAME_VIEW_ID ON \"BROWSER_VIEW_ID\" (\"PACKAGE_NAME\" ASC,\"VIEW_ID\" ASC);");
    }

    private final void d(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS \"IGNORED_STATISTICS_ITEM_V28\" \n(\n    \"_id\" INTEGER PRIMARY KEY AUTOINCREMENT,\n    \"NAME\" TEXT,\n    \"TYPE_ID\" INTEGER NOT NULL,\n    \"ITEM_SOURCE_TYPE\" INTEGER,\n    \"IS_ACTIVE\" INTEGER NOT NULL,\n    \"IS_INSTALLED\" INTEGER NOT NULL\n);");
        sQLiteDatabase.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS IDX_IGNORED_STATISTICS_ITEM_V28_NAME_TYPE_ID \nON \"IGNORED_STATISTICS_ITEM_V28\" (\"NAME\" ASC,\"TYPE_ID\" ASC);");
    }

    private final void e(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("                    CREATE TABLE IF NOT EXISTS \"WEBSITE\"\n                    (\n                        \"_id\" INTEGER PRIMARY KEY AUTOINCREMENT,\n                        \"URL\" TEXT,\n                        \"BLOCKING_TYPE\" INTEGER,\n                        \"PROFILE_ID\" INTEGER NOT NULL,\n                        \"CREATED\" INTEGER,\n                        \"ENABLED\" INTEGER,\n                        \"IS_ANYWHERE_IN_URL\" INTEGER\n                    );");
    }

    private final void f(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS \"WIFI_NETWORK\" (\"_id\" INTEGER PRIMARY KEY, \"PROFILE_ID\" INTEGER, \"SSID\" TEXT, \"BSSID\" TEXT);");
    }

    private final boolean g(SQLiteDatabase sQLiteDatabase, String str, String str2) {
        Cursor cursorRawQuery = null;
        try {
            cursorRawQuery = sQLiteDatabase.rawQuery("PRAGMA table_info(" + str + ")", null);
            int columnIndexOrThrow = cursorRawQuery.getColumnIndexOrThrow("name");
            while (cursorRawQuery.moveToNext()) {
                if (Intrinsics.areEqual(cursorRawQuery.getString(columnIndexOrThrow), str2)) {
                    cursorRawQuery.close();
                    return true;
                }
            }
            cursorRawQuery.close();
            return false;
        } catch (Throwable th) {
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
            throw th;
        }
    }

    public final boolean a(SQLiteDatabase sQLiteDatabase) {
        return sQLiteDatabase != null && sQLiteDatabase.getVersion() < 40;
    }

    public final GreendaoDatabase h(Context context, boolean z2) {
        Intrinsics.checkNotNullParameter(context, "context");
        File databasePath = context.getDatabasePath("lockie.db");
        if (!databasePath.exists()) {
            return new GreendaoDatabase(null, z2);
        }
        try {
            return new GreendaoDatabase(SQLiteDatabase.openDatabase(databasePath.getPath(), null, z2 ? 1 : 0), z2);
        } catch (SQLiteException e3) {
            if (BuildConfig.f95357b.booleanValue()) {
                e3.printStackTrace();
            }
            return new GreendaoDatabase(null, z2);
        }
    }

    public final void i(SQLiteDatabase db) {
        String str;
        GreendaoUtils greendaoUtils;
        String str2;
        String str3;
        String str4;
        Intrinsics.checkNotNullParameter(db, "db");
        int version = db.getVersion();
        Log.i("GreenDao", "Upgrading schema from version " + version);
        if (version < 6) {
            db.execSQL("ALTER TABLE Profile ADD COLUMN locked INTEGER DEFAULT 0;");
            db.execSQL("ALTER TABLE Profile ADD COLUMN created INTEGER DEFAULT 0;");
        }
        if (version < 7) {
            db.execSQL("ALTER TABLE Profile ADD COLUMN BLOCK_CALLS INTEGER DEFAULT 1;");
            db.execSQL("ALTER TABLE Profile ADD COLUMN ALLOW_SMS_REPLAY INTEGER DEFAULT 0;");
            db.execSQL("ALTER TABLE Profile ADD COLUMN SMS_TEXT TEXT;");
        }
        if (version < 9) {
            db.execSQL("ALTER TABLE Profile ADD COLUMN ON_UNTIL INTEGER DEFAULT 0;");
        }
        if (version < 10) {
            db.execSQL("ALTER TABLE Profile ADD COLUMN LIST_INDEX INTEGER DEFAULT 0;");
            db.execSQL("ALTER TABLE Profile ADD COLUMN LOCKED_TEMPORARILY INTEGER DEFAULT 0;");
        }
        if (version < 12) {
            db.execSQL("ALTER TABLE Profile ADD COLUMN TYPE INTEGER DEFAULT 0;");
        }
        if (version < 13) {
            f(db);
        }
        if (version < 15) {
            db.execSQL("ALTER TABLE Profile ADD COLUMN LOCKED_UNTIL INTEGER DEFAULT 0;");
        }
        if (version < 16) {
            db.execSQL("ALTER TABLE Profile ADD COLUMN LOCK_AT INTEGER DEFAULT 0;");
        }
        if (version < 17 && !g(db, "GEO_ADDRESS", "IS_INVERTED")) {
            db.execSQL("ALTER TABLE GEO_ADDRESS ADD COLUMN IS_INVERTED INTEGER DEFAULT 0;");
        }
        if (version < 18 && !g(db, "SOUND_PROFILE_RELATION", "ACTIVATION_TIME")) {
            db.execSQL("ALTER TABLE SOUND_PROFILE_RELATION ADD COLUMN ACTIVATION_TIME INTEGER DEFAULT 0;");
        }
        if (version < 19 && !g(db, "SOUND_PROFILE_RELATION", "INTERRUPTION_FILTER")) {
            db.execSQL("ALTER TABLE SOUND_PROFILE_RELATION ADD COLUMN INTERRUPTION_FILTER INTEGER DEFAULT 0;");
        }
        if (version < 20) {
            if (!g(db, "SOUND_PROFILE_RELATION", "IGNORED_SOUNDS")) {
                db.execSQL("ALTER TABLE SOUND_PROFILE_RELATION ADD COLUMN IGNORED_SOUNDS INTEGER DEFAULT 0;");
            }
            if (!g(db, "Profile", "LAST_START_TIME")) {
                db.execSQL("ALTER TABLE Profile ADD COLUMN LAST_START_TIME INTEGER DEFAULT 0;");
            }
            if (!g(db, "NOTIFICATION", ShareConstants.TITLE)) {
                db.execSQL("ALTER TABLE NOTIFICATION ADD COLUMN TITLE TEXT;");
            }
            if (!g(db, "NOTIFICATION", "CONTENT_TEXT")) {
                db.execSQL("ALTER TABLE NOTIFICATION ADD COLUMN CONTENT_TEXT TEXT;");
            }
        }
        if (version < 21) {
            if (!g(db, "Profile", "TYPE_COMBINATIONS")) {
                db.execSQL("ALTER TABLE Profile ADD COLUMN TYPE_COMBINATIONS INTEGER DEFAULT 0;");
            }
            if (!g(db, "Profile", "ON_CONDITIONS")) {
                db.execSQL("ALTER TABLE Profile ADD COLUMN ON_CONDITIONS INTEGER DEFAULT 0;");
            }
            if (!g(db, "Profile", "OPERATOR")) {
                db.execSQL("ALTER TABLE Profile ADD COLUMN OPERATOR INTEGER DEFAULT 0;");
            }
            ProfileType profileType = ProfileType.TIME;
            int iOrder = profileType.order();
            int iMask = profileType.mask();
            ProfileType profileType2 = ProfileType.LOCATION;
            int iOrder2 = profileType2.order();
            int iMask2 = profileType2.mask();
            ProfileType profileType3 = ProfileType.WIFI;
            int iOrder3 = profileType3.order();
            int iMask3 = profileType3.mask();
            ProfileType profileType4 = ProfileType.STRICT_MODE;
            db.execSQL("UPDATE Profile SET TYPE_COMBINATIONS = CASE WHEN TYPE = " + iOrder + " THEN " + iMask + " WHEN TYPE = " + iOrder2 + " THEN " + iMask2 + " WHEN TYPE = " + iOrder3 + " THEN " + iMask3 + " WHEN TYPE = " + profileType4.order() + " THEN " + profileType4.mask() + " ELSE 0 END;");
            str = "INSERT INTO IGNORED_STATISTICS_ITEM_V28(NAME,TYPE_ID,ITEM_SOURCE_TYPE,IS_ACTIVE";
            db.execSQL("UPDATE Profile SET ON_CONDITIONS = CASE WHEN TYPE = " + profileType.order() + " THEN " + profileType.mask() + " WHEN TYPE = " + profileType2.order() + " AND ON_UNTIL = -2 THEN " + profileType2.mask() + " WHEN TYPE = " + profileType3.order() + " AND ON_UNTIL = -2 THEN " + profileType3.mask() + " WHEN TYPE = " + profileType4.order() + " AND ON_UNTIL = -2 THEN " + profileType4.mask() + " ELSE 0 END;");
        } else {
            str = "INSERT INTO IGNORED_STATISTICS_ITEM_V28(NAME,TYPE_ID,ITEM_SOURCE_TYPE,IS_ACTIVE";
        }
        if (version < 22) {
            ProfileType profileType5 = ProfileType.STRICT_MODE;
            db.execSQL("UPDATE Profile SET TYPE_COMBINATIONS = " + profileType5.mask() + " WHERE TYPE_COMBINATIONS = 2147483647;");
            db.execSQL("UPDATE Profile SET ON_CONDITIONS = " + profileType5.mask() + " WHERE ON_CONDITIONS = 2147483647;");
            db.execSQL("UPDATE Profile SET BLOCK_NOTIFICATIONS = 1 WHERE TITLE = 'STRICT_MODE_INSTALLER_TAG';");
        }
        if (version < 23) {
            e(db);
            b(db);
            c(db);
            greendaoUtils = this;
            if (!greendaoUtils.g(db, "Profile", "BLOCK_WEBSITES")) {
                db.execSQL("ALTER TABLE Profile ADD COLUMN BLOCK_WEBSITES INTEGER DEFAULT 0;");
            }
            if (!greendaoUtils.g(db, "SKU_DETAIL", "ORDER_IN_LIST")) {
                db.execSQL("ALTER TABLE SKU_DETAIL ADD COLUMN ORDER_IN_LIST INTEGER DEFAULT 0;");
            }
        } else {
            greendaoUtils = this;
        }
        if (version < 24 && !greendaoUtils.g(db, "APPLICATION_USAGE_LIMIT", "PERIOD_TYPE")) {
            db.execSQL("ALTER TABLE APPLICATION_USAGE_LIMIT ADD COLUMN PERIOD_TYPE INTEGER DEFAULT 0;");
        }
        if (version < 25 && !greendaoUtils.g(db, "APPLICATION_USAGE_LIMIT", "LIMIT_TYPE")) {
            db.execSQL("ALTER TABLE APPLICATION_USAGE_LIMIT ADD COLUMN LIMIT_TYPE INTEGER DEFAULT 0;");
        }
        if (version < 28) {
            d(db);
            Set setY0 = PrefManager.f126839a.y0();
            String str5 = "";
            if (setY0 != null) {
                str2 = "'" + TextUtils.join("','", setY0) + "'";
            } else {
                str2 = "";
            }
            try {
                if (greendaoUtils.g(db, "IGNORED_STATISTICS_ITEM_V28", "IS_INSTALLED")) {
                    str5 = ",IS_INSTALLED";
                    str3 = ",1";
                } else {
                    str3 = "";
                }
                StringBuilder sb = new StringBuilder();
                String str6 = str;
                sb.append(str6);
                sb.append(str5);
                sb.append(") SELECT NAME,TYPE_ID,0,1");
                sb.append(str3);
                sb.append(" FROM IGNORED_STATISTICS_ITEM WHERE NAME IN (");
                sb.append(str2);
                sb.append(");");
                db.execSQL(sb.toString());
                if (str2.length() == 0) {
                    str4 = "!= 'us.zoom.videomeetings'";
                } else {
                    str4 = "NOT IN (" + str2 + ",'us.zoom.videomeetings');";
                }
                db.execSQL(str6 + str5 + ") SELECT NAME,TYPE_ID,1,1" + str3 + " FROM IGNORED_STATISTICS_ITEM WHERE NAME " + str4);
            } catch (Exception e3) {
                CrashHelper.j(e3);
            }
            db.execSQL("DELETE FROM APPLICATION_PROFILE_RELATION WHERE APPLICATION_PACKAGE != 'com.google.android.packageinstaller' AND PROFILE_ID IN (SELECT _ID FROM PROFILE WHERE TITLE = 'STRICT_MODE_INSTALLER_TAG')");
            PrefManager.f126839a.b2(false);
        }
        if (version < 29) {
            if (!greendaoUtils.g(db, "IGNORED_STATISTICS_ITEM_V28", "IS_INSTALLED")) {
                db.execSQL("ALTER TABLE IGNORED_STATISTICS_ITEM_V28 ADD COLUMN IS_INSTALLED INTEGER DEFAULT 0;");
            }
            db.execSQL("UPDATE IGNORED_STATISTICS_ITEM_V28 SET IS_INSTALLED = 1");
        }
        if (version < 30) {
            if (!greendaoUtils.g(db, "WEBSITE", "BLOCKING_TYPE")) {
                db.execSQL("ALTER TABLE WEBSITE ADD COLUMN BLOCKING_TYPE INTEGER DEFAULT 0;");
            }
            db.execSQL("UPDATE WEBSITE SET BLOCKING_TYPE = 0");
        }
        if (version < 31) {
            if (!greendaoUtils.g(db, "SKU_DETAIL", "PURCHASE_TOKEN")) {
                db.execSQL("ALTER TABLE SKU_DETAIL ADD COLUMN PURCHASE_TOKEN TEXT;");
            }
            if (!greendaoUtils.g(db, "BROWSER_VIEW_ID", "VIEW_TYPE")) {
                db.execSQL("ALTER TABLE BROWSER_VIEW_ID ADD COLUMN VIEW_TYPE INTEGER DEFAULT 0;");
            }
            db.execSQL("UPDATE BROWSER_VIEW_ID SET VIEW_TYPE = " + BrowserViewId.ViewType.URL_BAR.getId());
        }
        if (version < 32 && !greendaoUtils.g(db, "SKU_DETAIL", "TRIAL_PERIOD")) {
            db.execSQL("ALTER TABLE SKU_DETAIL ADD COLUMN TRIAL_PERIOD TEXT;");
        }
        if (version < 33) {
            if (!greendaoUtils.g(db, "SKU_DETAIL", "INTRODUCTORY_PRICE_VALUE")) {
                db.execSQL("ALTER TABLE SKU_DETAIL ADD COLUMN INTRODUCTORY_PRICE_VALUE REAL;");
            }
            if (!greendaoUtils.g(db, "SKU_DETAIL", "INTRODUCTORY_PRICE_TEXT")) {
                db.execSQL("ALTER TABLE SKU_DETAIL ADD COLUMN INTRODUCTORY_PRICE_TEXT TEXT;");
            }
        }
        if (version < 34) {
            if (!greendaoUtils.g(db, "APPLICATION_PROFILE_RELATION", "ENABLED")) {
                db.execSQL("ALTER TABLE APPLICATION_PROFILE_RELATION ADD COLUMN ENABLED INTEGER DEFAULT 1;");
            }
            if (!greendaoUtils.g(db, "WEBSITE", "ENABLED")) {
                db.execSQL("ALTER TABLE WEBSITE ADD COLUMN ENABLED INTEGER DEFAULT 1;");
            }
            if (!greendaoUtils.g(db, "APPLICATION_USAGE_LIMIT", "ALLOWED_TIME_ORIGINAL")) {
                db.execSQL("ALTER TABLE APPLICATION_USAGE_LIMIT ADD COLUMN ALLOWED_TIME_ORIGINAL INTEGER DEFAULT -1;");
            }
            if (!greendaoUtils.g(db, "INTERVAL", "ENABLED")) {
                db.execSQL("ALTER TABLE INTERVAL ADD COLUMN ENABLED INTEGER DEFAULT 1;");
            }
        }
        if (version < 35 && !greendaoUtils.g(db, "PROFILE", "ADD_NEW_APPLICATIONS")) {
            db.execSQL("ALTER TABLE PROFILE ADD COLUMN ADD_NEW_APPLICATIONS INTEGER DEFAULT 0;");
        }
        if (version < 36 && !greendaoUtils.g(db, "APPLICATION_PROFILE_RELATION", "FLAGS")) {
            db.execSQL("ALTER TABLE APPLICATION_PROFILE_RELATION ADD COLUMN FLAGS INTEGER DEFAULT 0;");
        }
        if (version < 38 && !greendaoUtils.g(db, "BROWSER_VIEW_ID", "CLEAR_URL")) {
            db.execSQL("ALTER TABLE BROWSER_VIEW_ID ADD COLUMN CLEAR_URL INTEGER DEFAULT 1;");
        }
        if (version < 39 && !greendaoUtils.g(db, "WEBSITE", "IS_ANYWHERE_IN_URL")) {
            db.execSQL("ALTER TABLE WEBSITE ADD COLUMN IS_ANYWHERE_IN_URL INTEGER DEFAULT 0;");
        }
        if (version < 40) {
            db.execSQL("DELETE FROM APPLICATION_USAGE_LIMIT WHERE APPLICATION_PACKAGE != 'ALL_APPLICATIONS';");
        }
        db.setVersion(40);
    }
}
