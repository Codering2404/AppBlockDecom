package androidx.room.paging;

import android.database.Cursor;
import androidx.sqlite.SQLiteStatement;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class CursorSQLiteStatement implements SQLiteStatement {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Companion f52698b = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Cursor f52699a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public CursorSQLiteStatement(Cursor cursor) {
        Intrinsics.checkNotNullParameter(cursor, "cursor");
        this.f52699a = cursor;
    }

    @Override // androidx.sqlite.SQLiteStatement
    public boolean B2() {
        return this.f52699a.moveToNext();
    }

    @Override // androidx.sqlite.SQLiteStatement
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Void B(int i3, byte[] value) {
        Intrinsics.checkNotNullParameter(value, "value");
        throw new IllegalStateException("Only get*() calls are allowed on a Cursor backed SQLiteStatement");
    }

    @Override // androidx.sqlite.SQLiteStatement
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public Void t(int i3, double d3) {
        throw new IllegalStateException("Only get*() calls are allowed on a Cursor backed SQLiteStatement");
    }

    @Override // androidx.sqlite.SQLiteStatement
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public Void A(int i3, long j3) {
        throw new IllegalStateException("Only get*() calls are allowed on a Cursor backed SQLiteStatement");
    }

    @Override // androidx.sqlite.SQLiteStatement, java.lang.AutoCloseable
    public void close() {
        this.f52699a.close();
    }

    @Override // androidx.sqlite.SQLiteStatement
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public Void D(int i3) {
        throw new IllegalStateException("Only get*() calls are allowed on a Cursor backed SQLiteStatement");
    }

    @Override // androidx.sqlite.SQLiteStatement
    public String f2(int i3) {
        String string = this.f52699a.getString(i3);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }

    @Override // androidx.sqlite.SQLiteStatement
    public int getColumnCount() {
        return this.f52699a.getColumnCount();
    }

    @Override // androidx.sqlite.SQLiteStatement
    public String getColumnName(int i3) {
        String columnName = this.f52699a.getColumnName(i3);
        Intrinsics.checkNotNullExpressionValue(columnName, "getColumnName(...)");
        return columnName;
    }

    @Override // androidx.sqlite.SQLiteStatement
    public double getDouble(int i3) {
        return this.f52699a.getDouble(i3);
    }

    @Override // androidx.sqlite.SQLiteStatement
    public long getLong(int i3) {
        return this.f52699a.getLong(i3);
    }

    @Override // androidx.sqlite.SQLiteStatement
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public Void p0(int i3, String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        throw new IllegalStateException("Only get*() calls are allowed on a Cursor backed SQLiteStatement");
    }

    @Override // androidx.sqlite.SQLiteStatement
    public boolean isNull(int i3) {
        return this.f52699a.isNull(i3);
    }

    @Override // androidx.sqlite.SQLiteStatement
    public void reset() {
        this.f52699a.moveToPosition(-1);
    }
}
