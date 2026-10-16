package androidx.room.util;

import androidx.sqlite.SQLiteStatement;
import kotlin.Metadata;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    */
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class SQLiteStatementUtil {
    public static final int a(SQLiteStatement sQLiteStatement, String str) {
        return SQLiteStatementUtil__StatementUtil_androidKt.a(sQLiteStatement, str);
    }

    public static final int b(SQLiteStatement sQLiteStatement, String str) {
        return SQLiteStatementUtil__StatementUtilKt.a(sQLiteStatement, str);
    }

    public static final int c(SQLiteStatement sQLiteStatement, String str) {
        return SQLiteStatementUtil__StatementUtilKt.b(sQLiteStatement, str);
    }

    public static final int d(SQLiteStatement sQLiteStatement, String str) {
        return SQLiteStatementUtil__StatementUtilKt.c(sQLiteStatement, str);
    }
}
