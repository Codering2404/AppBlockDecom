package androidx.sqlite;

import java.util.ArrayList;
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
public interface SQLiteStatement extends AutoCloseable {
    void A(int i3, long j3);

    void B(int i3, byte[] bArr);

    boolean B2();

    void D(int i3);

    default boolean J1(int i3) {
        return getLong(i3) != 0;
    }

    @Override // java.lang.AutoCloseable
    void close();

    String f2(int i3);

    int getColumnCount();

    String getColumnName(int i3);

    default List getColumnNames() {
        int columnCount = getColumnCount();
        ArrayList arrayList = new ArrayList(columnCount);
        for (int i3 = 0; i3 < columnCount; i3++) {
            arrayList.add(getColumnName(i3));
        }
        return arrayList;
    }

    double getDouble(int i3);

    default float getFloat(int i3) {
        return (float) getDouble(i3);
    }

    default int getInt(int i3) {
        return (int) getLong(i3);
    }

    long getLong(int i3);

    boolean isNull(int i3);

    void p0(int i3, String str);

    void reset();

    void t(int i3, double d3);
}
