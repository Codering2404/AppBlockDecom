package androidx.room.util;

import androidx.sqlite.SQLiteStatement;
import java.util.List;
import java.util.Map;
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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class MappedColumnsSQLiteStatementWrapper implements SQLiteStatement {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SQLiteStatement f52961a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map f52962b;

    @Override // androidx.sqlite.SQLiteStatement
    public void A(int i3, long j3) {
        this.f52961a.A(i3, j3);
    }

    @Override // androidx.sqlite.SQLiteStatement
    public void B(int i3, byte[] value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.f52961a.B(i3, value);
    }

    @Override // androidx.sqlite.SQLiteStatement
    public boolean B2() {
        return this.f52961a.B2();
    }

    @Override // androidx.sqlite.SQLiteStatement
    public void D(int i3) {
        this.f52961a.D(i3);
    }

    @Override // androidx.sqlite.SQLiteStatement
    public boolean J1(int i3) {
        return this.f52961a.J1(i3);
    }

    @Override // androidx.sqlite.SQLiteStatement, java.lang.AutoCloseable
    public void close() {
        this.f52961a.close();
    }

    @Override // androidx.sqlite.SQLiteStatement
    public String f2(int i3) {
        return this.f52961a.f2(i3);
    }

    @Override // androidx.sqlite.SQLiteStatement
    public int getColumnCount() {
        return this.f52961a.getColumnCount();
    }

    public final int getColumnIndex(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        Integer num = (Integer) this.f52962b.get(name);
        if (num != null) {
            return num.intValue();
        }
        return -1;
    }

    @Override // androidx.sqlite.SQLiteStatement
    public String getColumnName(int i3) {
        return this.f52961a.getColumnName(i3);
    }

    @Override // androidx.sqlite.SQLiteStatement
    public List getColumnNames() {
        return this.f52961a.getColumnNames();
    }

    @Override // androidx.sqlite.SQLiteStatement
    public double getDouble(int i3) {
        return this.f52961a.getDouble(i3);
    }

    @Override // androidx.sqlite.SQLiteStatement
    public float getFloat(int i3) {
        return this.f52961a.getFloat(i3);
    }

    @Override // androidx.sqlite.SQLiteStatement
    public int getInt(int i3) {
        return this.f52961a.getInt(i3);
    }

    @Override // androidx.sqlite.SQLiteStatement
    public long getLong(int i3) {
        return this.f52961a.getLong(i3);
    }

    @Override // androidx.sqlite.SQLiteStatement
    public boolean isNull(int i3) {
        return this.f52961a.isNull(i3);
    }

    @Override // androidx.sqlite.SQLiteStatement
    public void p0(int i3, String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.f52961a.p0(i3, value);
    }

    @Override // androidx.sqlite.SQLiteStatement
    public void reset() {
        this.f52961a.reset();
    }

    @Override // androidx.sqlite.SQLiteStatement
    public void t(int i3, double d3) {
        this.f52961a.t(i3, d3);
    }
}
