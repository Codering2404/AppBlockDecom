package androidx.room.support;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.io.IOException;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

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
public final class QueryInterceptorDatabase implements SupportSQLiteDatabase {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SupportSQLiteDatabase f52788a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final CoroutineScope f52789b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final RoomDatabase.QueryCallback f52790c;

    public QueryInterceptorDatabase(SupportSQLiteDatabase delegate, CoroutineScope queryCallbackScope, RoomDatabase.QueryCallback queryCallback) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        Intrinsics.checkNotNullParameter(queryCallbackScope, "queryCallbackScope");
        Intrinsics.checkNotNullParameter(queryCallback, "queryCallback");
        this.f52788a = delegate;
        this.f52789b = queryCallbackScope;
        this.f52790c = queryCallback;
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean E() {
        return this.f52788a.E();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean F0() {
        return this.f52788a.F0();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void F1() {
        this.f52788a.F1();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void G0() {
        BuildersKt__Builders_commonKt.d(this.f52789b, null, null, new QueryInterceptorDatabase$endTransaction$1(this, null), 3, null);
        this.f52788a.G0();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void H() {
        BuildersKt__Builders_commonKt.d(this.f52789b, null, null, new QueryInterceptorDatabase$beginTransaction$1(this, null), 3, null);
        this.f52788a.H();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean H1() {
        return this.f52788a.H1();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public long N1() {
        return this.f52788a.N1();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public int O1(String table, int i3, ContentValues values, String str, Object[] objArr) {
        Intrinsics.checkNotNullParameter(table, "table");
        Intrinsics.checkNotNullParameter(values, "values");
        return this.f52788a.O1(table, i3, values, str, objArr);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public Cursor P0(SupportSQLiteQuery query) {
        Intrinsics.checkNotNullParameter(query, "query");
        QueryInterceptorProgram queryInterceptorProgram = new QueryInterceptorProgram();
        query.c(queryInterceptorProgram);
        BuildersKt__Builders_commonKt.d(this.f52789b, null, null, new QueryInterceptorDatabase$query$3(this, query, queryInterceptorProgram, null), 3, null);
        return this.f52788a.P0(query);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public List Q() {
        return this.f52788a.Q();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void R() {
        this.f52788a.R();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void S(String sql) {
        Intrinsics.checkNotNullParameter(sql, "sql");
        BuildersKt__Builders_commonKt.d(this.f52789b, null, null, new QueryInterceptorDatabase$execSQL$1(this, sql, null), 3, null);
        this.f52788a.S(sql);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean U1() {
        return this.f52788a.U1();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean W() {
        return this.f52788a.W();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public Cursor W1(String query) {
        Intrinsics.checkNotNullParameter(query, "query");
        BuildersKt__Builders_commonKt.d(this.f52789b, null, null, new QueryInterceptorDatabase$query$1(this, query, null), 3, null);
        return this.f52788a.W1(query);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public long a2(String table, int i3, ContentValues values) {
        Intrinsics.checkNotNullParameter(table, "table");
        Intrinsics.checkNotNullParameter(values, "values");
        return this.f52788a.a2(table, i3, values);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f52788a.close();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public int d1() {
        return this.f52788a.d1();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public Cursor f0(SupportSQLiteQuery query, CancellationSignal cancellationSignal) {
        Intrinsics.checkNotNullParameter(query, "query");
        QueryInterceptorProgram queryInterceptorProgram = new QueryInterceptorProgram();
        query.c(queryInterceptorProgram);
        BuildersKt__Builders_commonKt.d(this.f52789b, null, null, new QueryInterceptorDatabase$query$4(this, query, queryInterceptorProgram, null), 3, null);
        return this.f52788a.P0(query);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public String g() {
        return this.f52788a.g();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean isOpen() {
        return this.f52788a.isOpen();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public Cursor p1(String query, Object[] bindArgs) {
        Intrinsics.checkNotNullParameter(query, "query");
        Intrinsics.checkNotNullParameter(bindArgs, "bindArgs");
        BuildersKt__Builders_commonKt.d(this.f52789b, null, null, new QueryInterceptorDatabase$query$2(this, query, ArraysKt.toList(bindArgs), null), 3, null);
        return this.f52788a.p1(query, bindArgs);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void r1(int i3) {
        this.f52788a.r1(i3);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean s0() {
        return this.f52788a.s0();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void t0() {
        BuildersKt__Builders_commonKt.d(this.f52789b, null, null, new QueryInterceptorDatabase$setTransactionSuccessful$1(this, null), 3, null);
        this.f52788a.t0();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void u0(String sql, Object[] bindArgs) {
        Intrinsics.checkNotNullParameter(sql, "sql");
        Intrinsics.checkNotNullParameter(bindArgs, "bindArgs");
        BuildersKt__Builders_commonKt.d(this.f52789b, null, null, new QueryInterceptorDatabase$execSQL$2(this, sql, ArraysKt.toList(bindArgs), null), 3, null);
        this.f52788a.u0(sql, bindArgs);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean u2() {
        return this.f52788a.u2();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void v0() {
        BuildersKt__Builders_commonKt.d(this.f52789b, null, null, new QueryInterceptorDatabase$beginTransactionNonExclusive$1(this, null), 3, null);
        this.f52788a.v0();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public long w() {
        return this.f52788a.w();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public SupportSQLiteStatement x1(String sql) {
        Intrinsics.checkNotNullParameter(sql, "sql");
        return new QueryInterceptorStatement(this.f52788a.x1(sql), sql, this.f52789b, this.f52790c);
    }
}
