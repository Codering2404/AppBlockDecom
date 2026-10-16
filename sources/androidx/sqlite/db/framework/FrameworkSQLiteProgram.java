package androidx.sqlite.db.framework;

import android.database.sqlite.SQLiteProgram;
import androidx.sqlite.db.SupportSQLiteProgram;
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
public class FrameworkSQLiteProgram implements SupportSQLiteProgram {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SQLiteProgram f53215a;

    public FrameworkSQLiteProgram(SQLiteProgram delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.f53215a = delegate;
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void A(int i3, long j3) {
        this.f53215a.bindLong(i3, j3);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void B(int i3, byte[] value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.f53215a.bindBlob(i3, value);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void D(int i3) {
        this.f53215a.bindNull(i3);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f53215a.close();
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void s1(int i3, String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.f53215a.bindString(i3, value);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void t(int i3, double d3) {
        this.f53215a.bindDouble(i3, d3);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void x2() {
        this.f53215a.clearBindings();
    }
}
