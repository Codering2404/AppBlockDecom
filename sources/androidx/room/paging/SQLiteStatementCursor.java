package androidx.room.paging;

import android.database.AbstractCursor;
import androidx.sqlite.SQLiteStatement;
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
public final class SQLiteStatementCursor extends AbstractCursor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SQLiteStatement f52711a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f52712b;

    public SQLiteStatementCursor(SQLiteStatement statement, int i3) {
        Intrinsics.checkNotNullParameter(statement, "statement");
        this.f52711a = statement;
        this.f52712b = i3;
    }

    @Override // android.database.AbstractCursor, android.database.Cursor
    public String[] getColumnNames() {
        return (String[]) this.f52711a.getColumnNames().toArray(new String[0]);
    }

    @Override // android.database.AbstractCursor, android.database.Cursor
    public int getCount() {
        return this.f52712b;
    }

    @Override // android.database.AbstractCursor, android.database.Cursor
    public double getDouble(int i3) {
        return this.f52711a.getDouble(i3);
    }

    @Override // android.database.AbstractCursor, android.database.Cursor
    public float getFloat(int i3) {
        return this.f52711a.getFloat(i3);
    }

    @Override // android.database.AbstractCursor, android.database.Cursor
    public int getInt(int i3) {
        return this.f52711a.getInt(i3);
    }

    @Override // android.database.AbstractCursor, android.database.Cursor
    public long getLong(int i3) {
        return this.f52711a.getLong(i3);
    }

    @Override // android.database.AbstractCursor, android.database.Cursor
    public short getShort(int i3) {
        return (short) this.f52711a.getLong(i3);
    }

    @Override // android.database.AbstractCursor, android.database.Cursor
    public String getString(int i3) {
        return this.f52711a.f2(i3);
    }

    @Override // android.database.AbstractCursor, android.database.Cursor
    public boolean isNull(int i3) {
        return this.f52711a.isNull(i3);
    }

    @Override // android.database.AbstractCursor, android.database.CrossProcessCursor
    public boolean onMove(int i3, int i4) {
        if (i3 + 1 == i4) {
            return this.f52711a.B2();
        }
        throw new IllegalStateException("Compat cursor can only move forward one position at a time.");
    }
}
