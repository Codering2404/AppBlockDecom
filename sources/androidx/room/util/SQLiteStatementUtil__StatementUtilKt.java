package androidx.room.util;

import androidx.sqlite.SQLiteStatement;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
final /* synthetic */ class SQLiteStatementUtil__StatementUtilKt {
    public static final int a(SQLiteStatement sQLiteStatement, String name) {
        Intrinsics.checkNotNullParameter(sQLiteStatement, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        if (sQLiteStatement instanceof MappedColumnsSQLiteStatementWrapper) {
            return ((MappedColumnsSQLiteStatementWrapper) sQLiteStatement).getColumnIndex(name);
        }
        int columnCount = sQLiteStatement.getColumnCount();
        for (int i3 = 0; i3 < columnCount; i3++) {
            if (Intrinsics.areEqual(name, sQLiteStatement.getColumnName(i3))) {
                return i3;
            }
        }
        return -1;
    }

    public static final int b(SQLiteStatement stmt, String name) {
        Intrinsics.checkNotNullParameter(stmt, "stmt");
        Intrinsics.checkNotNullParameter(name, "name");
        return SQLiteStatementUtil.a(stmt, name);
    }

    public static final int c(SQLiteStatement stmt, String name) {
        Intrinsics.checkNotNullParameter(stmt, "stmt");
        Intrinsics.checkNotNullParameter(name, "name");
        int iA = SQLiteStatementUtil.a(stmt, name);
        if (iA >= 0) {
            return iA;
        }
        int columnCount = stmt.getColumnCount();
        ArrayList arrayList = new ArrayList(columnCount);
        for (int i3 = 0; i3 < columnCount; i3++) {
            arrayList.add(stmt.getColumnName(i3));
        }
        throw new IllegalArgumentException("Column '" + name + "' does not exist. Available columns: [" + CollectionsKt.joinToString$default(arrayList, null, null, null, 0, null, null, 63, null) + ']');
    }
}
