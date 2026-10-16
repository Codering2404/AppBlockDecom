package androidx.room.util;

import android.database.Cursor;
import android.database.MatrixCursor;
import android.util.Log;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
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
public final class CursorUtil {
    public static final Cursor a(Cursor c3) {
        Intrinsics.checkNotNullParameter(c3, "c");
        try {
            MatrixCursor matrixCursor = new MatrixCursor(c3.getColumnNames(), c3.getCount());
            while (c3.moveToNext()) {
                Object[] objArr = new Object[c3.getColumnCount()];
                int columnCount = c3.getColumnCount();
                for (int i3 = 0; i3 < columnCount; i3++) {
                    int type = c3.getType(i3);
                    if (type == 0) {
                        objArr[i3] = null;
                    } else if (type == 1) {
                        objArr[i3] = Long.valueOf(c3.getLong(i3));
                    } else if (type == 2) {
                        objArr[i3] = Double.valueOf(c3.getDouble(i3));
                    } else if (type == 3) {
                        objArr[i3] = c3.getString(i3);
                    } else {
                        if (type != 4) {
                            throw new IllegalStateException();
                        }
                        objArr[i3] = c3.getBlob(i3);
                    }
                }
                matrixCursor.addRow(objArr);
            }
            CloseableKt.a(c3, null);
            return matrixCursor;
        } finally {
        }
    }

    private static final int b(Cursor cursor, String str) {
        return -1;
    }

    public static final int c(Cursor c3, String name) {
        Intrinsics.checkNotNullParameter(c3, "c");
        Intrinsics.checkNotNullParameter(name, "name");
        int columnIndex = c3.getColumnIndex(name);
        if (columnIndex >= 0) {
            return columnIndex;
        }
        int columnIndex2 = c3.getColumnIndex('`' + name + '`');
        return columnIndex2 >= 0 ? columnIndex2 : b(c3, name);
    }

    public static final int d(Cursor c3, String name) {
        String strJoinToString$default;
        Intrinsics.checkNotNullParameter(c3, "c");
        Intrinsics.checkNotNullParameter(name, "name");
        int iC = c(c3, name);
        if (iC >= 0) {
            return iC;
        }
        try {
            String[] columnNames = c3.getColumnNames();
            Intrinsics.checkNotNullExpressionValue(columnNames, "getColumnNames(...)");
            strJoinToString$default = ArraysKt.joinToString$default(columnNames, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 63, (Object) null);
        } catch (Exception e3) {
            Log.d("RoomCursorUtil", "Cannot collect column names for debug purposes", e3);
            strJoinToString$default = "unknown";
        }
        throw new IllegalArgumentException("column '" + name + "' does not exist. Available columns: " + strJoinToString$default);
    }
}
