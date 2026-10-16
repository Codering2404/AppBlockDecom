package androidx.sqlite.db.framework;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQuery;
import android.database.sqlite.SQLiteStatement;
import android.database.sqlite.SQLiteTransactionListener;
import android.os.CancellationSignal;
import android.text.TextUtils;
import androidx.sqlite.db.SimpleSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function4;
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
public final class FrameworkSQLiteDatabase implements SupportSQLiteDatabase {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Companion f53181b = new Companion(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String[] f53182c = {"", " OR ROLLBACK ", " OR ABORT ", " OR FAIL ", " OR IGNORE ", " OR REPLACE "};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String[] f53183d = new String[0];

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Lazy f53184f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final Lazy f53185g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SQLiteDatabase f53186a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Api30Impl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Api30Impl f53187a = new Api30Impl();

        private Api30Impl() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Method c() {
            return (Method) FrameworkSQLiteDatabase.f53185g.getValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Method d() {
            return (Method) FrameworkSQLiteDatabase.f53184f.getValue();
        }

        private Companion() {
        }
    }

    static {
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.f139762b;
        f53184f = LazyKt.a(lazyThreadSafetyMode, new Function0() { // from class: androidx.sqlite.db.framework.d
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return FrameworkSQLiteDatabase.n();
            }
        });
        f53185g = LazyKt.a(lazyThreadSafetyMode, new Function0() { // from class: androidx.sqlite.db.framework.e
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return FrameworkSQLiteDatabase.l();
            }
        });
    }

    public FrameworkSQLiteDatabase(SQLiteDatabase delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.f53186a = delegate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SQLiteCursor C(SupportSQLiteQuery supportSQLiteQuery, SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
        Intrinsics.checkNotNull(sQLiteQuery);
        supportSQLiteQuery.c(new FrameworkSQLiteProgram(sQLiteQuery));
        return new SQLiteCursor(sQLiteCursorDriver, str, sQLiteQuery);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Cursor F(Function4 function4, SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
        return (Cursor) function4.invoke(sQLiteDatabase, sQLiteCursorDriver, str, sQLiteQuery);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Cursor J(SupportSQLiteQuery supportSQLiteQuery, SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
        Intrinsics.checkNotNull(sQLiteQuery);
        supportSQLiteQuery.c(new FrameworkSQLiteProgram(sQLiteQuery));
        return new SQLiteCursor(sQLiteCursorDriver, str, sQLiteQuery);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Method l() {
        Class<?> returnType;
        try {
            Method methodD = f53181b.d();
            if (methodD == null || (returnType = methodD.getReturnType()) == null) {
                return null;
            }
            Class cls = Integer.TYPE;
            return returnType.getDeclaredMethod("beginTransaction", cls, SQLiteTransactionListener.class, cls, CancellationSignal.class);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Method n() {
        try {
            Method declaredMethod = SQLiteDatabase.class.getDeclaredMethod("getThreadSession", null);
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (Throwable unused) {
            return null;
        }
    }

    private final void r(SQLiteTransactionListener sQLiteTransactionListener) throws IllegalAccessException, InvocationTargetException {
        Companion companion = f53181b;
        if (companion.c() == null || companion.d() == null) {
            if (sQLiteTransactionListener != null) {
                m(sQLiteTransactionListener);
                return;
            } else {
                H();
                return;
            }
        }
        Method methodC = companion.c();
        Intrinsics.checkNotNull(methodC);
        Method methodD = companion.d();
        Intrinsics.checkNotNull(methodD);
        Object objInvoke = methodD.invoke(this.f53186a, null);
        if (objInvoke == null) {
            throw new IllegalStateException("Required value was null.");
        }
        methodC.invoke(objInvoke, 0, sQLiteTransactionListener, 0, null);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean E() {
        return this.f53186a.inTransaction();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean F0() {
        return this.f53186a.isDbLockedByCurrentThread();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void F1() throws IllegalAccessException, InvocationTargetException {
        r(null);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void G0() {
        this.f53186a.endTransaction();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void H() {
        this.f53186a.beginTransaction();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean H1() {
        return this.f53186a.isReadOnly();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public long N1() {
        return this.f53186a.getMaximumSize();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public int O1(String table, int i3, ContentValues values, String str, Object[] objArr) {
        Intrinsics.checkNotNullParameter(table, "table");
        Intrinsics.checkNotNullParameter(values, "values");
        if (values.size() == 0) {
            throw new IllegalArgumentException("Empty values");
        }
        int size = values.size();
        int length = objArr == null ? size : objArr.length + size;
        Object[] objArr2 = new Object[length];
        StringBuilder sb = new StringBuilder();
        sb.append("UPDATE ");
        sb.append(f53182c[i3]);
        sb.append(table);
        sb.append(" SET ");
        int i4 = 0;
        for (String str2 : values.keySet()) {
            sb.append(i4 > 0 ? "," : "");
            sb.append(str2);
            objArr2[i4] = values.get(str2);
            sb.append("=?");
            i4++;
        }
        if (objArr != null) {
            for (int i5 = size; i5 < length; i5++) {
                objArr2[i5] = objArr[i5 - size];
            }
        }
        if (!TextUtils.isEmpty(str)) {
            sb.append(" WHERE ");
            sb.append(str);
        }
        SupportSQLiteStatement supportSQLiteStatementX1 = x1(sb.toString());
        SimpleSQLiteQuery.f53158c.b(supportSQLiteStatementX1, objArr2);
        return supportSQLiteStatementX1.X();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public Cursor P0(final SupportSQLiteQuery query) {
        Intrinsics.checkNotNullParameter(query, "query");
        final Function4 function4 = new Function4() { // from class: androidx.sqlite.db.framework.b
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return FrameworkSQLiteDatabase.C(query, (SQLiteDatabase) obj, (SQLiteCursorDriver) obj2, (String) obj3, (SQLiteQuery) obj4);
            }
        };
        Cursor cursorRawQueryWithFactory = this.f53186a.rawQueryWithFactory(new SQLiteDatabase.CursorFactory() { // from class: androidx.sqlite.db.framework.c
            @Override // android.database.sqlite.SQLiteDatabase.CursorFactory
            public final Cursor newCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
                return FrameworkSQLiteDatabase.F(function4, sQLiteDatabase, sQLiteCursorDriver, str, sQLiteQuery);
            }
        }, query.b(), f53183d, null);
        Intrinsics.checkNotNullExpressionValue(cursorRawQueryWithFactory, "rawQueryWithFactory(...)");
        return cursorRawQueryWithFactory;
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public List Q() {
        return this.f53186a.getAttachedDbs();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void R() {
        this.f53186a.disableWriteAheadLogging();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void S(String sql) {
        Intrinsics.checkNotNullParameter(sql, "sql");
        this.f53186a.execSQL(sql);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean U1() {
        return this.f53186a.yieldIfContendedSafely();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean W() {
        return this.f53186a.isDatabaseIntegrityOk();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public Cursor W1(String query) {
        Intrinsics.checkNotNullParameter(query, "query");
        return P0(new SimpleSQLiteQuery(query));
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public long a2(String table, int i3, ContentValues values) {
        Intrinsics.checkNotNullParameter(table, "table");
        Intrinsics.checkNotNullParameter(values, "values");
        return this.f53186a.insertWithOnConflict(table, null, values, i3);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f53186a.close();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public int d1() {
        return this.f53186a.getVersion();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public Cursor f0(final SupportSQLiteQuery query, CancellationSignal cancellationSignal) {
        Intrinsics.checkNotNullParameter(query, "query");
        SQLiteDatabase sQLiteDatabase = this.f53186a;
        SQLiteDatabase.CursorFactory cursorFactory = new SQLiteDatabase.CursorFactory() { // from class: androidx.sqlite.db.framework.a
            @Override // android.database.sqlite.SQLiteDatabase.CursorFactory
            public final Cursor newCursor(SQLiteDatabase sQLiteDatabase2, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
                return FrameworkSQLiteDatabase.J(query, sQLiteDatabase2, sQLiteCursorDriver, str, sQLiteQuery);
            }
        };
        String strB = query.b();
        String[] strArr = f53183d;
        Intrinsics.checkNotNull(cancellationSignal);
        Cursor cursorRawQueryWithFactory = sQLiteDatabase.rawQueryWithFactory(cursorFactory, strB, strArr, null, cancellationSignal);
        Intrinsics.checkNotNullExpressionValue(cursorRawQueryWithFactory, "rawQueryWithFactory(...)");
        return cursorRawQueryWithFactory;
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public String g() {
        return this.f53186a.getPath();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean isOpen() {
        return this.f53186a.isOpen();
    }

    public void m(SQLiteTransactionListener transactionListener) {
        Intrinsics.checkNotNullParameter(transactionListener, "transactionListener");
        this.f53186a.beginTransactionWithListener(transactionListener);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public Cursor p1(String query, Object[] bindArgs) {
        Intrinsics.checkNotNullParameter(query, "query");
        Intrinsics.checkNotNullParameter(bindArgs, "bindArgs");
        return P0(new SimpleSQLiteQuery(query, bindArgs));
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void r1(int i3) {
        this.f53186a.setVersion(i3);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean s0() {
        return this.f53186a.enableWriteAheadLogging();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void t0() {
        this.f53186a.setTransactionSuccessful();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void u0(String sql, Object[] bindArgs) {
        Intrinsics.checkNotNullParameter(sql, "sql");
        Intrinsics.checkNotNullParameter(bindArgs, "bindArgs");
        this.f53186a.execSQL(sql, bindArgs);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean u2() {
        return this.f53186a.isWriteAheadLoggingEnabled();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void v0() {
        this.f53186a.beginTransactionNonExclusive();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public long w() {
        return this.f53186a.getPageSize();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public SupportSQLiteStatement x1(String sql) {
        Intrinsics.checkNotNullParameter(sql, "sql");
        SQLiteStatement sQLiteStatementCompileStatement = this.f53186a.compileStatement(sql);
        Intrinsics.checkNotNullExpressionValue(sQLiteStatementCompileStatement, "compileStatement(...)");
        return new FrameworkSQLiteStatement(sQLiteStatementCompileStatement);
    }

    public final boolean z(SQLiteDatabase sqLiteDatabase) {
        Intrinsics.checkNotNullParameter(sqLiteDatabase, "sqLiteDatabase");
        return Intrinsics.areEqual(this.f53186a, sqLiteDatabase);
    }
}
