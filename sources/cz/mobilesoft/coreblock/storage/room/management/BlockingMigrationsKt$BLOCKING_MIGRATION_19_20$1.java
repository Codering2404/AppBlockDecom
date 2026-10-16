package cz.mobilesoft.coreblock.storage.room.management;

import android.database.Cursor;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import cz.mobilesoft.coreblock.util.constants.Constants;
import java.util.ArrayList;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class BlockingMigrationsKt$BLOCKING_MIGRATION_19_20$1 extends Migration {
    BlockingMigrationsKt$BLOCKING_MIGRATION_19_20$1() {
        super(19, 20);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence d(String str) {
        return "'" + str + "'";
    }

    /* JADX WARN: Finally extract failed */
    @Override // androidx.room.migration.Migration
    public void b(SupportSQLiteDatabase db) {
        Intrinsics.checkNotNullParameter(db, "db");
        Set ADDITIONAL_SETTINGS_APPS_FOR_STRICT_MODE = Constants.f128453k;
        Intrinsics.checkNotNullExpressionValue(ADDITIONAL_SETTINGS_APPS_FOR_STRICT_MODE, "ADDITIONAL_SETTINGS_APPS_FOR_STRICT_MODE");
        Cursor cursorW1 = db.W1(StringsKt.n("\n                SELECT apr.profileId, apr.packageName \n                FROM ApplicationProfileRelation apr\n                INNER JOIN Profile p ON apr.profileId = p.id\n                WHERE apr.packageName IN (" + CollectionsKt.joinToString$default(ADDITIONAL_SETTINGS_APPS_FOR_STRICT_MODE, ",", null, null, 0, null, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.management.v
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BlockingMigrationsKt$BLOCKING_MIGRATION_19_20$1.d((String) obj);
            }
        }, 30, null) + ")\n                AND p.title != 'STRICT_MODE_TAG_V2'\n            "));
        ArrayList arrayList = new ArrayList();
        try {
            int columnIndex = cursorW1.getColumnIndex("profileId");
            int columnIndex2 = cursorW1.getColumnIndex("packageName");
            while (cursorW1.moveToNext()) {
                arrayList.add(TuplesKt.a(Long.valueOf(cursorW1.getLong(columnIndex)), cursorW1.getString(columnIndex2)));
            }
            cursorW1.close();
            int size = arrayList.size();
            int i3 = 0;
            while (i3 < size) {
                Object obj = arrayList.get(i3);
                i3++;
                Pair pair = (Pair) obj;
                db.S(StringsKt.n("\n                    DELETE FROM ApplicationProfileRelation \n                    WHERE profileId = " + ((Number) pair.a()).longValue() + " AND packageName = '" + ((String) pair.b()) + "'\n                "));
            }
        } catch (Throwable th) {
            cursorW1.close();
            throw th;
        }
    }
}
