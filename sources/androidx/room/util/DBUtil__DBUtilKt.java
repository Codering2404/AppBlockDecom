package androidx.room.util;

import androidx.sqlite.SQLite;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jdk7.AutoCloseableKt;
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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
final /* synthetic */ class DBUtil__DBUtilKt {
    public static final void a(SQLiteConnection connection) {
        Intrinsics.checkNotNullParameter(connection, "connection");
        List listCreateListBuilder = CollectionsKt.createListBuilder();
        SQLiteStatement sQLiteStatementG2 = connection.G2("SELECT name FROM sqlite_master WHERE type = 'trigger'");
        while (sQLiteStatementG2.B2()) {
            try {
                listCreateListBuilder.add(sQLiteStatementG2.f2(0));
            } finally {
            }
        }
        Unit unit = Unit.f139807a;
        AutoCloseableKt.a(sQLiteStatementG2, null);
        for (String str : CollectionsKt.build(listCreateListBuilder)) {
            if (StringsKt.U(str, "room_fts_content_sync_", false, 2, null)) {
                SQLite.a(connection, "DROP TRIGGER IF EXISTS " + str);
            }
        }
    }
}
