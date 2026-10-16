package androidx.room;

import androidx.room.util.SQLiteConnectionUtil;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jdk7.AutoCloseableKt;
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
public abstract class EntityInsertAdapter<T> {
    protected abstract void a(SQLiteStatement sQLiteStatement, Object obj);

    protected abstract String b();

    public final void c(SQLiteConnection connection, Object obj) throws Exception {
        Intrinsics.checkNotNullParameter(connection, "connection");
        if (obj == null) {
            return;
        }
        SQLiteStatement sQLiteStatementG2 = connection.G2(b());
        try {
            a(sQLiteStatementG2, obj);
            sQLiteStatementG2.B2();
            AutoCloseableKt.a(sQLiteStatementG2, null);
        } finally {
        }
    }

    public final long d(SQLiteConnection connection, Object obj) throws Exception {
        Intrinsics.checkNotNullParameter(connection, "connection");
        if (obj == null) {
            return -1L;
        }
        SQLiteStatement sQLiteStatementG2 = connection.G2(b());
        try {
            a(sQLiteStatementG2, obj);
            sQLiteStatementG2.B2();
            AutoCloseableKt.a(sQLiteStatementG2, null);
            return SQLiteConnectionUtil.a(connection);
        } finally {
        }
    }

    public final List e(SQLiteConnection connection, Collection collection) throws Exception {
        Intrinsics.checkNotNullParameter(connection, "connection");
        if (collection == null) {
            return CollectionsKt.emptyList();
        }
        List listCreateListBuilder = CollectionsKt.createListBuilder();
        SQLiteStatement sQLiteStatementG2 = connection.G2(b());
        try {
            for (T t2 : collection) {
                if (t2 != null) {
                    a(sQLiteStatementG2, t2);
                    sQLiteStatementG2.B2();
                    sQLiteStatementG2.reset();
                    listCreateListBuilder.add(Long.valueOf(SQLiteConnectionUtil.a(connection)));
                } else {
                    listCreateListBuilder.add(-1L);
                }
            }
            Unit unit = Unit.f139807a;
            AutoCloseableKt.a(sQLiteStatementG2, null);
            return CollectionsKt.build(listCreateListBuilder);
        } finally {
        }
    }
}
