package androidx.room.support;

import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.google.firebase.crashlytics.internal.breadcrumbs.PKU.tDEtWsFLJfe;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
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
/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class QueryInterceptorStatement implements SupportSQLiteStatement {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SupportSQLiteStatement f52832a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f52833b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final CoroutineScope f52834c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final RoomDatabase.QueryCallback f52835d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final List f52836f;

    private final void c(int i3, Object obj) {
        int i4 = i3 - 1;
        if (i4 >= this.f52836f.size()) {
            int size = (i4 - this.f52836f.size()) + 1;
            for (int i5 = 0; i5 < size; i5++) {
                this.f52836f.add(null);
            }
        }
        this.f52836f.set(i4, obj);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void A(int i3, long j3) {
        c(i3, Long.valueOf(j3));
        this.f52832a.A(i3, j3);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void B(int i3, byte[] value) {
        Intrinsics.checkNotNullParameter(value, "value");
        c(i3, value);
        this.f52832a.B(i3, value);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void D(int i3) {
        c(i3, null);
        this.f52832a.D(i3);
    }

    @Override // androidx.sqlite.db.SupportSQLiteStatement
    public int X() {
        BuildersKt__Builders_commonKt.d(this.f52834c, null, null, new QueryInterceptorStatement$executeUpdateDelete$1(this, CollectionsKt.toList(this.f52836f), null), 3, null);
        return this.f52832a.X();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f52832a.close();
    }

    @Override // androidx.sqlite.db.SupportSQLiteStatement
    public void d() {
        BuildersKt__Builders_commonKt.d(this.f52834c, null, null, new QueryInterceptorStatement$execute$1(this, CollectionsKt.toList(this.f52836f), null), 3, null);
        this.f52832a.d();
    }

    @Override // androidx.sqlite.db.SupportSQLiteStatement
    public long k1() {
        BuildersKt__Builders_commonKt.d(this.f52834c, null, null, new QueryInterceptorStatement$executeInsert$1(this, CollectionsKt.toList(this.f52836f), null), 3, null);
        return this.f52832a.k1();
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void s1(int i3, String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        c(i3, value);
        this.f52832a.s1(i3, value);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void t(int i3, double d3) {
        c(i3, Double.valueOf(d3));
        this.f52832a.t(i3, d3);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void x2() {
        this.f52836f.clear();
        this.f52832a.x2();
    }

    public QueryInterceptorStatement(SupportSQLiteStatement delegate, String sqlStatement, CoroutineScope coroutineScope, RoomDatabase.QueryCallback queryCallback) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        Intrinsics.checkNotNullParameter(sqlStatement, "sqlStatement");
        Intrinsics.checkNotNullParameter(coroutineScope, tDEtWsFLJfe.nAyzPnNFtb);
        Intrinsics.checkNotNullParameter(queryCallback, "queryCallback");
        this.f52832a = delegate;
        this.f52833b = sqlStatement;
        this.f52834c = coroutineScope;
        this.f52835d = queryCallback;
        this.f52836f = new ArrayList();
    }
}
