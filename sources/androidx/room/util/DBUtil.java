package androidx.room.util;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.room.RoomDatabase;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteQuery;
import java.io.File;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;

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
public final class DBUtil {
    public static final CancellationSignal a() {
        return DBUtil__DBUtil_androidKt.a();
    }

    public static final void b(SQLiteConnection sQLiteConnection) {
        DBUtil__DBUtilKt.a(sQLiteConnection);
    }

    public static final void c(SupportSQLiteDatabase supportSQLiteDatabase) {
        DBUtil__DBUtil_androidKt.b(supportSQLiteDatabase);
    }

    public static final Object d(RoomDatabase roomDatabase, boolean z2, Continuation continuation) {
        return DBUtil__DBUtil_androidKt.c(roomDatabase, z2, continuation);
    }

    public static final Object e(RoomDatabase roomDatabase, boolean z2, boolean z3, Function1 function1) {
        return DBUtil__DBUtil_androidKt.d(roomDatabase, z2, z3, function1);
    }

    public static final Object f(RoomDatabase roomDatabase, Function1 function1, Continuation continuation) {
        return DBUtil__DBUtil_androidKt.e(roomDatabase, function1, continuation);
    }

    public static final Object g(RoomDatabase roomDatabase, boolean z2, boolean z3, Function1 function1, Continuation continuation) {
        return DBUtil__DBUtil_androidKt.f(roomDatabase, z2, z3, function1, continuation);
    }

    public static final Cursor h(RoomDatabase roomDatabase, SupportSQLiteQuery supportSQLiteQuery, boolean z2, CancellationSignal cancellationSignal) {
        return DBUtil__DBUtil_androidKt.g(roomDatabase, supportSQLiteQuery, z2, cancellationSignal);
    }

    public static final int i(File file) {
        return DBUtil__DBUtil_androidKt.h(file);
    }
}
