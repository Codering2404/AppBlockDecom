package androidx.room.support;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.net.Uri;
import android.os.Bundle;
import android.os.CancellationSignal;
import androidx.room.DelegatingOpenHelper;
import androidx.room.support.AutoClosingRoomOpenHelper;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteProgram;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.PropertyReference1Impl;

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
public final class AutoClosingRoomOpenHelper implements SupportSQLiteOpenHelper, DelegatingOpenHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SupportSQLiteOpenHelper f52747a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AutoCloser f52748b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final AutoClosingSupportSQLiteDatabase f52749c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class AutoClosingSupportSQLiteDatabase implements SupportSQLiteDatabase {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final AutoCloser f52750a;

        public AutoClosingSupportSQLiteDatabase(AutoCloser autoCloser) {
            Intrinsics.checkNotNullParameter(autoCloser, "autoCloser");
            this.f52750a = autoCloser;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final int C(String str, int i3, ContentValues contentValues, String str2, Object[] objArr, SupportSQLiteDatabase db) {
            Intrinsics.checkNotNullParameter(db, "db");
            return db.O1(str, i3, contentValues, str2, objArr);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit k(int i3, SupportSQLiteDatabase db) {
            Intrinsics.checkNotNullParameter(db, "db");
            db.r1(i3);
            return Unit.f139807a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit l(String str, SupportSQLiteDatabase db) {
            Intrinsics.checkNotNullParameter(db, "db");
            db.S(str);
            return Unit.f139807a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit m(String str, Object[] objArr, SupportSQLiteDatabase db) {
            Intrinsics.checkNotNullParameter(db, "db");
            db.u0(str, objArr);
            return Unit.f139807a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final long n(String str, int i3, ContentValues contentValues, SupportSQLiteDatabase db) {
            Intrinsics.checkNotNullParameter(db, "db");
            return db.a2(str, i3, contentValues);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Object z(SupportSQLiteDatabase it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return null;
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public boolean E() {
            if (this.f52750a.i() == null) {
                return false;
            }
            return ((Boolean) this.f52750a.h(AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$inTransaction$1.f52752a)).booleanValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public boolean F0() {
            if (this.f52750a.i() == null) {
                return false;
            }
            return ((Boolean) this.f52750a.h(new PropertyReference1Impl() { // from class: androidx.room.support.AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$isDbLockedByCurrentThread$1
                @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
                public Object get(Object obj) {
                    return Boolean.valueOf(((SupportSQLiteDatabase) obj).F0());
                }
            })).booleanValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public void G0() {
            try {
                SupportSQLiteDatabase supportSQLiteDatabaseI = this.f52750a.i();
                Intrinsics.checkNotNull(supportSQLiteDatabaseI);
                supportSQLiteDatabaseI.G0();
            } finally {
                this.f52750a.g();
            }
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public void H() {
            try {
                this.f52750a.j().H();
            } catch (Throwable th) {
                this.f52750a.g();
                throw th;
            }
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public boolean H1() {
            return ((Boolean) this.f52750a.h(new PropertyReference1Impl() { // from class: androidx.room.support.AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$isReadOnly$1
                @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
                public Object get(Object obj) {
                    return Boolean.valueOf(((SupportSQLiteDatabase) obj).H1());
                }
            })).booleanValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public long N1() {
            return ((Number) this.f52750a.h(new PropertyReference1Impl() { // from class: androidx.room.support.AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$maximumSize$1
                @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
                public Object get(Object obj) {
                    return Long.valueOf(((SupportSQLiteDatabase) obj).N1());
                }
            })).longValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public int O1(final String table, final int i3, final ContentValues values, final String str, final Object[] objArr) {
            Intrinsics.checkNotNullParameter(table, "table");
            Intrinsics.checkNotNullParameter(values, "values");
            return ((Number) this.f52750a.h(new Function1() { // from class: androidx.room.support.c
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return Integer.valueOf(AutoClosingRoomOpenHelper.AutoClosingSupportSQLiteDatabase.C(table, i3, values, str, objArr, (SupportSQLiteDatabase) obj));
                }
            })).intValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public Cursor P0(SupportSQLiteQuery query) {
            Intrinsics.checkNotNullParameter(query, "query");
            try {
                return new KeepAliveCursor(this.f52750a.j().P0(query), this.f52750a);
            } catch (Throwable th) {
                this.f52750a.g();
                throw th;
            }
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public List Q() {
            return (List) this.f52750a.h(new PropertyReference1Impl() { // from class: androidx.room.support.AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$attachedDbs$1
                @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
                public Object get(Object obj) {
                    return ((SupportSQLiteDatabase) obj).Q();
                }
            });
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public void R() {
            throw new UnsupportedOperationException("Enable/disable write ahead logging on the OpenHelper instead of on the database directly.");
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public void S(final String sql) {
            Intrinsics.checkNotNullParameter(sql, "sql");
            this.f52750a.h(new Function1() { // from class: androidx.room.support.d
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return AutoClosingRoomOpenHelper.AutoClosingSupportSQLiteDatabase.l(sql, (SupportSQLiteDatabase) obj);
                }
            });
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public boolean U1() {
            return ((Boolean) this.f52750a.h(AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$yieldIfContendedSafely$1.f52761a)).booleanValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public boolean W() {
            return ((Boolean) this.f52750a.h(new PropertyReference1Impl() { // from class: androidx.room.support.AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$isDatabaseIntegrityOk$1
                @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
                public Object get(Object obj) {
                    return Boolean.valueOf(((SupportSQLiteDatabase) obj).W());
                }
            })).booleanValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public Cursor W1(String query) {
            Intrinsics.checkNotNullParameter(query, "query");
            try {
                return new KeepAliveCursor(this.f52750a.j().W1(query), this.f52750a);
            } catch (Throwable th) {
                this.f52750a.g();
                throw th;
            }
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public long a2(final String table, final int i3, final ContentValues values) {
            Intrinsics.checkNotNullParameter(table, "table");
            Intrinsics.checkNotNullParameter(values, "values");
            return ((Number) this.f52750a.h(new Function1() { // from class: androidx.room.support.g
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return Long.valueOf(AutoClosingRoomOpenHelper.AutoClosingSupportSQLiteDatabase.n(table, i3, values, (SupportSQLiteDatabase) obj));
                }
            })).longValue();
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.f52750a.f();
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public int d1() {
            return ((Number) this.f52750a.h(new MutablePropertyReference1Impl() { // from class: androidx.room.support.AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$version$1
                @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KProperty1
                public Object get(Object obj) {
                    return Integer.valueOf(((SupportSQLiteDatabase) obj).d1());
                }
            })).intValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public Cursor f0(SupportSQLiteQuery query, CancellationSignal cancellationSignal) {
            Intrinsics.checkNotNullParameter(query, "query");
            try {
                return new KeepAliveCursor(this.f52750a.j().f0(query, cancellationSignal), this.f52750a);
            } catch (Throwable th) {
                this.f52750a.g();
                throw th;
            }
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public String g() {
            return (String) this.f52750a.h(new PropertyReference1Impl() { // from class: androidx.room.support.AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$path$1
                @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
                public Object get(Object obj) {
                    return ((SupportSQLiteDatabase) obj).g();
                }
            });
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public boolean isOpen() {
            return this.f52750a.m();
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public Cursor p1(String query, Object[] bindArgs) {
            Intrinsics.checkNotNullParameter(query, "query");
            Intrinsics.checkNotNullParameter(bindArgs, "bindArgs");
            try {
                return new KeepAliveCursor(this.f52750a.j().p1(query, bindArgs), this.f52750a);
            } catch (Throwable th) {
                this.f52750a.g();
                throw th;
            }
        }

        public final void r() {
            this.f52750a.h(new Function1() { // from class: androidx.room.support.f
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return AutoClosingRoomOpenHelper.AutoClosingSupportSQLiteDatabase.z((SupportSQLiteDatabase) obj);
                }
            });
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public void r1(final int i3) {
            this.f52750a.h(new Function1() { // from class: androidx.room.support.b
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return AutoClosingRoomOpenHelper.AutoClosingSupportSQLiteDatabase.k(i3, (SupportSQLiteDatabase) obj);
                }
            });
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public boolean s0() {
            throw new UnsupportedOperationException("Enable/disable write ahead logging on the OpenHelper instead of on the database directly.");
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public void t0() {
            SupportSQLiteDatabase supportSQLiteDatabaseI = this.f52750a.i();
            Intrinsics.checkNotNull(supportSQLiteDatabaseI);
            supportSQLiteDatabaseI.t0();
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public void u0(final String sql, final Object[] bindArgs) {
            Intrinsics.checkNotNullParameter(sql, "sql");
            Intrinsics.checkNotNullParameter(bindArgs, "bindArgs");
            this.f52750a.h(new Function1() { // from class: androidx.room.support.e
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return AutoClosingRoomOpenHelper.AutoClosingSupportSQLiteDatabase.m(sql, bindArgs, (SupportSQLiteDatabase) obj);
                }
            });
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public boolean u2() {
            return ((Boolean) this.f52750a.h(new PropertyReference1Impl() { // from class: androidx.room.support.AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$isWriteAheadLoggingEnabled$1
                @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
                public Object get(Object obj) {
                    return Boolean.valueOf(((SupportSQLiteDatabase) obj).u2());
                }
            })).booleanValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public void v0() {
            try {
                this.f52750a.j().v0();
            } catch (Throwable th) {
                this.f52750a.g();
                throw th;
            }
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public long w() {
            return ((Number) this.f52750a.h(new MutablePropertyReference1Impl() { // from class: androidx.room.support.AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$pageSize$1
                @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KProperty1
                public Object get(Object obj) {
                    return Long.valueOf(((SupportSQLiteDatabase) obj).w());
                }
            })).longValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public SupportSQLiteStatement x1(String sql) {
            Intrinsics.checkNotNullParameter(sql, "sql");
            return new AutoClosingSupportSQLiteStatement(sql, this.f52750a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    static final class AutoClosingSupportSQLiteStatement implements SupportSQLiteStatement {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final Companion f52763i = new Companion(null);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f52764a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final AutoCloser f52765b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int[] f52766c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private long[] f52767d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private double[] f52768f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private String[] f52769g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private byte[][] f52770h;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }

        public AutoClosingSupportSQLiteStatement(String sql, AutoCloser autoCloser) {
            Intrinsics.checkNotNullParameter(sql, "sql");
            Intrinsics.checkNotNullParameter(autoCloser, "autoCloser");
            this.f52764a = sql;
            this.f52765b = autoCloser;
            this.f52766c = new int[0];
            this.f52767d = new long[0];
            this.f52768f = new double[0];
            this.f52769g = new String[0];
            this.f52770h = new byte[0][];
        }

        private final void i(SupportSQLiteProgram supportSQLiteProgram) {
            int length = this.f52766c.length;
            for (int i3 = 1; i3 < length; i3++) {
                int i4 = this.f52766c[i3];
                if (i4 == 1) {
                    supportSQLiteProgram.A(i3, this.f52767d[i3]);
                } else if (i4 == 2) {
                    supportSQLiteProgram.t(i3, this.f52768f[i3]);
                } else if (i4 == 3) {
                    String str = this.f52769g[i3];
                    Intrinsics.checkNotNull(str);
                    supportSQLiteProgram.s1(i3, str);
                } else if (i4 == 4) {
                    byte[] bArr = this.f52770h[i3];
                    Intrinsics.checkNotNull(bArr);
                    supportSQLiteProgram.B(i3, bArr);
                } else if (i4 == 5) {
                    supportSQLiteProgram.D(i3);
                }
            }
        }

        private final void j(int i3, int i4) {
            int i5 = i4 + 1;
            int[] iArr = this.f52766c;
            if (iArr.length < i5) {
                int[] iArrCopyOf = Arrays.copyOf(iArr, i5);
                Intrinsics.checkNotNullExpressionValue(iArrCopyOf, "copyOf(...)");
                this.f52766c = iArrCopyOf;
            }
            if (i3 == 1) {
                long[] jArr = this.f52767d;
                if (jArr.length < i5) {
                    long[] jArrCopyOf = Arrays.copyOf(jArr, i5);
                    Intrinsics.checkNotNullExpressionValue(jArrCopyOf, "copyOf(...)");
                    this.f52767d = jArrCopyOf;
                    return;
                }
                return;
            }
            if (i3 == 2) {
                double[] dArr = this.f52768f;
                if (dArr.length < i5) {
                    double[] dArrCopyOf = Arrays.copyOf(dArr, i5);
                    Intrinsics.checkNotNullExpressionValue(dArrCopyOf, "copyOf(...)");
                    this.f52768f = dArrCopyOf;
                    return;
                }
                return;
            }
            if (i3 == 3) {
                String[] strArr = this.f52769g;
                if (strArr.length < i5) {
                    Object[] objArrCopyOf = Arrays.copyOf(strArr, i5);
                    Intrinsics.checkNotNullExpressionValue(objArrCopyOf, "copyOf(...)");
                    this.f52769g = (String[]) objArrCopyOf;
                    return;
                }
                return;
            }
            if (i3 != 4) {
                return;
            }
            byte[][] bArr = this.f52770h;
            if (bArr.length < i5) {
                Object[] objArrCopyOf2 = Arrays.copyOf(bArr, i5);
                Intrinsics.checkNotNullExpressionValue(objArrCopyOf2, "copyOf(...)");
                this.f52770h = (byte[][]) objArrCopyOf2;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit k(SupportSQLiteStatement statement) {
            Intrinsics.checkNotNullParameter(statement, "statement");
            statement.d();
            return Unit.f139807a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final long l(SupportSQLiteStatement obj) {
            Intrinsics.checkNotNullParameter(obj, "obj");
            return obj.k1();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final int m(SupportSQLiteStatement obj) {
            Intrinsics.checkNotNullParameter(obj, "obj");
            return obj.X();
        }

        private final Object n(final Function1 function1) {
            return this.f52765b.h(new Function1() { // from class: androidx.room.support.k
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return AutoClosingRoomOpenHelper.AutoClosingSupportSQLiteStatement.r(this.f52864a, function1, (SupportSQLiteDatabase) obj);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Object r(AutoClosingSupportSQLiteStatement autoClosingSupportSQLiteStatement, Function1 function1, SupportSQLiteDatabase db) {
            Intrinsics.checkNotNullParameter(db, "db");
            SupportSQLiteStatement supportSQLiteStatementX1 = db.x1(autoClosingSupportSQLiteStatement.f52764a);
            autoClosingSupportSQLiteStatement.i(supportSQLiteStatementX1);
            return function1.invoke(supportSQLiteStatementX1);
        }

        @Override // androidx.sqlite.db.SupportSQLiteProgram
        public void A(int i3, long j3) {
            j(1, i3);
            this.f52766c[i3] = 1;
            this.f52767d[i3] = j3;
        }

        @Override // androidx.sqlite.db.SupportSQLiteProgram
        public void B(int i3, byte[] value) {
            Intrinsics.checkNotNullParameter(value, "value");
            j(4, i3);
            this.f52766c[i3] = 4;
            this.f52770h[i3] = value;
        }

        @Override // androidx.sqlite.db.SupportSQLiteProgram
        public void D(int i3) {
            j(5, i3);
            this.f52766c[i3] = 5;
        }

        @Override // androidx.sqlite.db.SupportSQLiteStatement
        public int X() {
            return ((Number) n(new Function1() { // from class: androidx.room.support.h
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return Integer.valueOf(AutoClosingRoomOpenHelper.AutoClosingSupportSQLiteStatement.m((SupportSQLiteStatement) obj));
                }
            })).intValue();
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            x2();
        }

        @Override // androidx.sqlite.db.SupportSQLiteStatement
        public void d() {
            n(new Function1() { // from class: androidx.room.support.j
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return AutoClosingRoomOpenHelper.AutoClosingSupportSQLiteStatement.k((SupportSQLiteStatement) obj);
                }
            });
        }

        @Override // androidx.sqlite.db.SupportSQLiteStatement
        public long k1() {
            return ((Number) n(new Function1() { // from class: androidx.room.support.i
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return Long.valueOf(AutoClosingRoomOpenHelper.AutoClosingSupportSQLiteStatement.l((SupportSQLiteStatement) obj));
                }
            })).longValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteProgram
        public void s1(int i3, String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            j(3, i3);
            this.f52766c[i3] = 3;
            this.f52769g[i3] = value;
        }

        @Override // androidx.sqlite.db.SupportSQLiteProgram
        public void t(int i3, double d3) {
            j(2, i3);
            this.f52766c[i3] = 2;
            this.f52768f[i3] = d3;
        }

        @Override // androidx.sqlite.db.SupportSQLiteProgram
        public void x2() {
            this.f52766c = new int[0];
            this.f52767d = new long[0];
            this.f52768f = new double[0];
            this.f52769g = new String[0];
            this.f52770h = new byte[0][];
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class KeepAliveCursor implements Cursor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Cursor f52771a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final AutoCloser f52772b;

        public KeepAliveCursor(Cursor delegate, AutoCloser autoCloser) {
            Intrinsics.checkNotNullParameter(delegate, "delegate");
            Intrinsics.checkNotNullParameter(autoCloser, "autoCloser");
            this.f52771a = delegate;
            this.f52772b = autoCloser;
        }

        @Override // android.database.Cursor, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.f52771a.close();
            this.f52772b.g();
        }

        @Override // android.database.Cursor
        public void copyStringToBuffer(int i3, CharArrayBuffer charArrayBuffer) {
            this.f52771a.copyStringToBuffer(i3, charArrayBuffer);
        }

        @Override // android.database.Cursor
        public void deactivate() {
            this.f52771a.deactivate();
        }

        @Override // android.database.Cursor
        public byte[] getBlob(int i3) {
            return this.f52771a.getBlob(i3);
        }

        @Override // android.database.Cursor
        public int getColumnCount() {
            return this.f52771a.getColumnCount();
        }

        @Override // android.database.Cursor
        public int getColumnIndex(String str) {
            return this.f52771a.getColumnIndex(str);
        }

        @Override // android.database.Cursor
        public int getColumnIndexOrThrow(String str) {
            return this.f52771a.getColumnIndexOrThrow(str);
        }

        @Override // android.database.Cursor
        public String getColumnName(int i3) {
            return this.f52771a.getColumnName(i3);
        }

        @Override // android.database.Cursor
        public String[] getColumnNames() {
            return this.f52771a.getColumnNames();
        }

        @Override // android.database.Cursor
        public int getCount() {
            return this.f52771a.getCount();
        }

        @Override // android.database.Cursor
        public double getDouble(int i3) {
            return this.f52771a.getDouble(i3);
        }

        @Override // android.database.Cursor
        public Bundle getExtras() {
            return this.f52771a.getExtras();
        }

        @Override // android.database.Cursor
        public float getFloat(int i3) {
            return this.f52771a.getFloat(i3);
        }

        @Override // android.database.Cursor
        public int getInt(int i3) {
            return this.f52771a.getInt(i3);
        }

        @Override // android.database.Cursor
        public long getLong(int i3) {
            return this.f52771a.getLong(i3);
        }

        @Override // android.database.Cursor
        public Uri getNotificationUri() {
            return this.f52771a.getNotificationUri();
        }

        @Override // android.database.Cursor
        public int getPosition() {
            return this.f52771a.getPosition();
        }

        @Override // android.database.Cursor
        public short getShort(int i3) {
            return this.f52771a.getShort(i3);
        }

        @Override // android.database.Cursor
        public String getString(int i3) {
            return this.f52771a.getString(i3);
        }

        @Override // android.database.Cursor
        public int getType(int i3) {
            return this.f52771a.getType(i3);
        }

        @Override // android.database.Cursor
        public boolean getWantsAllOnMoveCalls() {
            return this.f52771a.getWantsAllOnMoveCalls();
        }

        @Override // android.database.Cursor
        public boolean isAfterLast() {
            return this.f52771a.isAfterLast();
        }

        @Override // android.database.Cursor
        public boolean isBeforeFirst() {
            return this.f52771a.isBeforeFirst();
        }

        @Override // android.database.Cursor
        public boolean isClosed() {
            return this.f52771a.isClosed();
        }

        @Override // android.database.Cursor
        public boolean isFirst() {
            return this.f52771a.isFirst();
        }

        @Override // android.database.Cursor
        public boolean isLast() {
            return this.f52771a.isLast();
        }

        @Override // android.database.Cursor
        public boolean isNull(int i3) {
            return this.f52771a.isNull(i3);
        }

        @Override // android.database.Cursor
        public boolean move(int i3) {
            return this.f52771a.move(i3);
        }

        @Override // android.database.Cursor
        public boolean moveToFirst() {
            return this.f52771a.moveToFirst();
        }

        @Override // android.database.Cursor
        public boolean moveToLast() {
            return this.f52771a.moveToLast();
        }

        @Override // android.database.Cursor
        public boolean moveToNext() {
            return this.f52771a.moveToNext();
        }

        @Override // android.database.Cursor
        public boolean moveToPosition(int i3) {
            return this.f52771a.moveToPosition(i3);
        }

        @Override // android.database.Cursor
        public boolean moveToPrevious() {
            return this.f52771a.moveToPrevious();
        }

        @Override // android.database.Cursor
        public void registerContentObserver(ContentObserver contentObserver) {
            this.f52771a.registerContentObserver(contentObserver);
        }

        @Override // android.database.Cursor
        public void registerDataSetObserver(DataSetObserver dataSetObserver) {
            this.f52771a.registerDataSetObserver(dataSetObserver);
        }

        @Override // android.database.Cursor
        public boolean requery() {
            return this.f52771a.requery();
        }

        @Override // android.database.Cursor
        public Bundle respond(Bundle bundle) {
            return this.f52771a.respond(bundle);
        }

        @Override // android.database.Cursor
        public void setExtras(Bundle bundle) {
            this.f52771a.setExtras(bundle);
        }

        @Override // android.database.Cursor
        public void setNotificationUri(ContentResolver contentResolver, Uri uri) {
            this.f52771a.setNotificationUri(contentResolver, uri);
        }

        @Override // android.database.Cursor
        public void unregisterContentObserver(ContentObserver contentObserver) {
            this.f52771a.unregisterContentObserver(contentObserver);
        }

        @Override // android.database.Cursor
        public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
            this.f52771a.unregisterDataSetObserver(dataSetObserver);
        }
    }

    public AutoClosingRoomOpenHelper(SupportSQLiteOpenHelper delegate, AutoCloser autoCloser) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        Intrinsics.checkNotNullParameter(autoCloser, "autoCloser");
        this.f52747a = delegate;
        this.f52748b = autoCloser;
        this.f52749c = new AutoClosingSupportSQLiteDatabase(autoCloser);
        autoCloser.l(getDelegate());
    }

    public final AutoCloser a() {
        return this.f52748b;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f52749c.close();
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public String getDatabaseName() {
        return this.f52747a.getDatabaseName();
    }

    @Override // androidx.room.DelegatingOpenHelper
    public SupportSQLiteOpenHelper getDelegate() {
        return this.f52747a;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public SupportSQLiteDatabase getReadableDatabase() {
        this.f52749c.r();
        return this.f52749c;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public SupportSQLiteDatabase getWritableDatabase() {
        this.f52749c.r();
        return this.f52749c;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public void setWriteAheadLoggingEnabled(boolean z2) {
        this.f52747a.setWriteAheadLoggingEnabled(z2);
    }
}
