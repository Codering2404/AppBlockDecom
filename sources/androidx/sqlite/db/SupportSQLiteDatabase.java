package androidx.sqlite.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.CancellationSignal;
import java.io.Closeable;
import java.util.List;
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
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public interface SupportSQLiteDatabase extends Closeable {
    boolean E();

    boolean F0();

    default void F1() {
        H();
    }

    void G0();

    void H();

    boolean H1();

    long N1();

    int O1(String str, int i3, ContentValues contentValues, String str2, Object[] objArr);

    Cursor P0(SupportSQLiteQuery supportSQLiteQuery);

    List Q();

    void R();

    void S(String str);

    boolean U1();

    boolean W();

    Cursor W1(String str);

    long a2(String str, int i3, ContentValues contentValues);

    int d1();

    Cursor f0(SupportSQLiteQuery supportSQLiteQuery, CancellationSignal cancellationSignal);

    String g();

    boolean isOpen();

    Cursor p1(String str, Object[] objArr);

    void r1(int i3);

    boolean s0();

    void t0();

    void u0(String str, Object[] objArr);

    boolean u2();

    void v0();

    long w();

    SupportSQLiteStatement x1(String str);
}
