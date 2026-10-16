package androidx.sqlite.driver;

import android.database.Cursor;
import androidx.sqlite.SQLite;
import androidx.sqlite.SQLiteStatement;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteProgram;
import androidx.sqlite.db.SupportSQLiteQuery;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

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
public abstract class SupportSQLiteStatement implements SQLiteStatement {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Companion f53227d = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SupportSQLiteDatabase f53228a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f53229b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f53230c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        private static abstract class SpecialOperation {

            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            public static final class JournalModeOperation extends SpecialOperation {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public static final JournalModeOperation f53231a = new JournalModeOperation();

                private JournalModeOperation() {
                    super(null);
                }
            }

            public /* synthetic */ SpecialOperation(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private SpecialOperation() {
            }
        }

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        private static final class TransactionOperation {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final TransactionOperation f53232a = new TransactionOperation("END", 0);

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final TransactionOperation f53233b = new TransactionOperation("ROLLBACK", 1);

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public static final TransactionOperation f53234c = new TransactionOperation("BEGIN_EXCLUSIVE", 2);

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public static final TransactionOperation f53235d = new TransactionOperation("BEGIN_IMMEDIATE", 3);

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public static final TransactionOperation f53236f = new TransactionOperation("BEGIN_DEFERRED", 4);

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            private static final /* synthetic */ TransactionOperation[] f53237g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            private static final /* synthetic */ EnumEntries f53238h;

            static {
                TransactionOperation[] transactionOperationArrA = a();
                f53237g = transactionOperationArrA;
                f53238h = EnumEntriesKt.a(transactionOperationArrA);
            }

            private TransactionOperation(String str, int i3) {
            }

            private static final /* synthetic */ TransactionOperation[] a() {
                return new TransactionOperation[]{f53232a, f53233b, f53234c, f53235d, f53236f};
            }

            public static TransactionOperation valueOf(String str) {
                return (TransactionOperation) Enum.valueOf(TransactionOperation.class, str);
            }

            public static TransactionOperation[] values() {
                return (TransactionOperation[]) f53237g.clone();
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final SpecialOperation b(String str, String str2) {
            if (Intrinsics.areEqual(str, "PRA")) {
                String lowerCase = str2.toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                if (StringsKt.a0(StringsKt.d1(lowerCase, "journal_mode", ""), "=", false, 2, null)) {
                    return SpecialOperation.JournalModeOperation.f53231a;
                }
            }
            return null;
        }

        private final int d(String str) {
            String str2;
            int i3;
            int length = str.length() - 2;
            if (length < 0) {
                return -1;
            }
            int i4 = 0;
            while (i4 < length) {
                char cCharAt = str.charAt(i4);
                if (Intrinsics.compare((int) cCharAt, 32) <= 0) {
                    i4++;
                } else {
                    if (cCharAt != '-') {
                        str2 = str;
                        if (cCharAt == '/') {
                            int iM0 = i4 + 1;
                            if (str2.charAt(iM0) == '*') {
                                do {
                                    String str3 = str2;
                                    iM0 = StringsKt.m0(str3, '*', iM0 + 1, false, 4, null);
                                    str2 = str3;
                                    if (iM0 >= 0) {
                                        i3 = iM0 + 1;
                                        if (i3 >= length) {
                                            break;
                                        }
                                    } else {
                                        return -1;
                                    }
                                } while (str2.charAt(i3) != '/');
                                i4 = iM0 + 2;
                                str = str2;
                            }
                        }
                        return i4;
                    }
                    if (str.charAt(i4 + 1) != '-') {
                        return i4;
                    }
                    str2 = str;
                    int iM02 = StringsKt.m0(str2, '\n', i4 + 2, false, 4, null);
                    if (iM02 < 0) {
                        return -1;
                    }
                    i4 = iM02 + 1;
                    str = str2;
                }
            }
            return -1;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Code restructure failed: missing block: B:14:0x0026, code lost:
        
            if (r5.equals("END") == false) goto L23;
         */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x002f, code lost:
        
            if (r5.equals("COM") == false) goto L23;
         */
        /* JADX WARN: Code restructure failed: missing block: B:20:0x0034, code lost:
        
            return androidx.sqlite.driver.SupportSQLiteStatement.Companion.TransactionOperation.f53232a;
         */
        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private final androidx.sqlite.driver.SupportSQLiteStatement.Companion.TransactionOperation e(java.lang.String r5, java.lang.String r6) {
            /*
                r4 = this;
                int r0 = r5.hashCode()
                r1 = 2
                r2 = 0
                r3 = 0
                switch(r0) {
                    case 65636: goto L35;
                    case 66913: goto L29;
                    case 68795: goto L20;
                    case 81327: goto Lb;
                    default: goto La;
                }
            La:
                goto L3d
            Lb:
                java.lang.String r0 = "ROL"
                boolean r5 = r5.equals(r0)
                if (r5 != 0) goto L14
                goto L3d
            L14:
                java.lang.String r5 = " TO "
                boolean r5 = kotlin.text.StringsKt.a0(r6, r5, r2, r1, r3)
                if (r5 == 0) goto L1d
                return r3
            L1d:
                androidx.sqlite.driver.SupportSQLiteStatement$Companion$TransactionOperation r5 = androidx.sqlite.driver.SupportSQLiteStatement.Companion.TransactionOperation.f53233b
                return r5
            L20:
                java.lang.String r6 = "END"
                boolean r5 = r5.equals(r6)
                if (r5 != 0) goto L32
                goto L3d
            L29:
                java.lang.String r6 = "COM"
                boolean r5 = r5.equals(r6)
                if (r5 != 0) goto L32
                goto L3d
            L32:
                androidx.sqlite.driver.SupportSQLiteStatement$Companion$TransactionOperation r5 = androidx.sqlite.driver.SupportSQLiteStatement.Companion.TransactionOperation.f53232a
                return r5
            L35:
                java.lang.String r0 = "BEG"
                boolean r5 = r5.equals(r0)
                if (r5 != 0) goto L3e
            L3d:
                return r3
            L3e:
                java.lang.String r5 = "EXCLUSIVE"
                boolean r5 = kotlin.text.StringsKt.a0(r6, r5, r2, r1, r3)
                if (r5 == 0) goto L49
                androidx.sqlite.driver.SupportSQLiteStatement$Companion$TransactionOperation r5 = androidx.sqlite.driver.SupportSQLiteStatement.Companion.TransactionOperation.f53234c
                return r5
            L49:
                java.lang.String r5 = "IMMEDIATE"
                boolean r5 = kotlin.text.StringsKt.a0(r6, r5, r2, r1, r3)
                if (r5 == 0) goto L54
                androidx.sqlite.driver.SupportSQLiteStatement$Companion$TransactionOperation r5 = androidx.sqlite.driver.SupportSQLiteStatement.Companion.TransactionOperation.f53235d
                return r5
            L54:
                androidx.sqlite.driver.SupportSQLiteStatement$Companion$TransactionOperation r5 = androidx.sqlite.driver.SupportSQLiteStatement.Companion.TransactionOperation.f53236f
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.sqlite.driver.SupportSQLiteStatement.Companion.e(java.lang.String, java.lang.String):androidx.sqlite.driver.SupportSQLiteStatement$Companion$TransactionOperation");
        }

        private final boolean f(String str) {
            int iHashCode = str.hashCode();
            return iHashCode != 79487 ? iHashCode != 81978 ? iHashCode == 85954 && str.equals("WIT") : str.equals("SEL") : str.equals("PRA");
        }

        public final SupportSQLiteStatement a(SupportSQLiteDatabase db, String sql) {
            Intrinsics.checkNotNullParameter(db, "db");
            Intrinsics.checkNotNullParameter(sql, "sql");
            String upperCase = StringsKt.t1(sql).toString().toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
            String strC = c(upperCase);
            if (strC == null) {
                return new OtherSQLiteStatement(db, sql);
            }
            TransactionOperation transactionOperationE = e(strC, upperCase);
            return transactionOperationE != null ? new TransactionSQLiteStatement(db, sql, transactionOperationE) : b(strC, upperCase) instanceof SpecialOperation.JournalModeOperation ? new JournalModeSetStatement(db, sql, new RowSQLiteStatement(db, sql)) : f(strC) ? new RowSQLiteStatement(db, sql) : new OtherSQLiteStatement(db, sql);
        }

        public final String c(String sql) {
            Intrinsics.checkNotNullParameter(sql, "sql");
            int iD = d(sql);
            if (iD < 0 || iD > sql.length()) {
                return null;
            }
            String strSubstring = sql.substring(iD, Math.min(iD + 3, sql.length()));
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            return strSubstring;
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class JournalModeSetStatement extends SupportSQLiteStatement implements SQLiteStatement {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final SupportSQLiteStatement f53239f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public JournalModeSetStatement(SupportSQLiteDatabase db, String sql, SupportSQLiteStatement delegate) {
            super(db, sql, null);
            Intrinsics.checkNotNullParameter(db, "db");
            Intrinsics.checkNotNullParameter(sql, "sql");
            Intrinsics.checkNotNullParameter(delegate, "delegate");
            this.f53239f = delegate;
        }

        @Override // androidx.sqlite.SQLiteStatement
        public void A(int i3, long j3) {
            this.f53239f.A(i3, j3);
        }

        @Override // androidx.sqlite.SQLiteStatement
        public void B(int i3, byte[] value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this.f53239f.B(i3, value);
        }

        @Override // androidx.sqlite.SQLiteStatement
        public boolean B2() {
            boolean zB2 = this.f53239f.B2();
            if (StringsKt.F(f2(0), "wal", true)) {
                a().s0();
                return zB2;
            }
            a().R();
            return zB2;
        }

        @Override // androidx.sqlite.SQLiteStatement
        public void D(int i3) {
            this.f53239f.D(i3);
        }

        @Override // androidx.sqlite.SQLiteStatement
        public boolean J1(int i3) {
            return this.f53239f.J1(i3);
        }

        @Override // androidx.sqlite.SQLiteStatement, java.lang.AutoCloseable
        public void close() {
            this.f53239f.close();
        }

        @Override // androidx.sqlite.SQLiteStatement
        public String f2(int i3) {
            return this.f53239f.f2(i3);
        }

        @Override // androidx.sqlite.SQLiteStatement
        public int getColumnCount() {
            return this.f53239f.getColumnCount();
        }

        @Override // androidx.sqlite.SQLiteStatement
        public String getColumnName(int i3) {
            return this.f53239f.getColumnName(i3);
        }

        @Override // androidx.sqlite.SQLiteStatement
        public List getColumnNames() {
            return this.f53239f.getColumnNames();
        }

        @Override // androidx.sqlite.SQLiteStatement
        public double getDouble(int i3) {
            return this.f53239f.getDouble(i3);
        }

        @Override // androidx.sqlite.SQLiteStatement
        public float getFloat(int i3) {
            return this.f53239f.getFloat(i3);
        }

        @Override // androidx.sqlite.SQLiteStatement
        public int getInt(int i3) {
            return this.f53239f.getInt(i3);
        }

        @Override // androidx.sqlite.SQLiteStatement
        public long getLong(int i3) {
            return this.f53239f.getLong(i3);
        }

        @Override // androidx.sqlite.SQLiteStatement
        public boolean isNull(int i3) {
            return this.f53239f.isNull(i3);
        }

        @Override // androidx.sqlite.SQLiteStatement
        public void p0(int i3, String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this.f53239f.p0(i3, value);
        }

        @Override // androidx.sqlite.SQLiteStatement
        public void reset() {
            this.f53239f.reset();
        }

        @Override // androidx.sqlite.SQLiteStatement
        public void t(int i3, double d3) {
            this.f53239f.t(i3, d3);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class OtherSQLiteStatement extends SupportSQLiteStatement {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final androidx.sqlite.db.SupportSQLiteStatement f53240f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OtherSQLiteStatement(SupportSQLiteDatabase db, String sql) {
            super(db, sql, null);
            Intrinsics.checkNotNullParameter(db, "db");
            Intrinsics.checkNotNullParameter(sql, "sql");
            this.f53240f = db.x1(sql);
        }

        @Override // androidx.sqlite.SQLiteStatement
        public void A(int i3, long j3) {
            f();
            this.f53240f.A(i3, j3);
        }

        @Override // androidx.sqlite.SQLiteStatement
        public void B(int i3, byte[] value) {
            Intrinsics.checkNotNullParameter(value, "value");
            f();
            this.f53240f.B(i3, value);
        }

        @Override // androidx.sqlite.SQLiteStatement
        public boolean B2() {
            f();
            this.f53240f.d();
            return false;
        }

        @Override // androidx.sqlite.SQLiteStatement
        public void D(int i3) {
            f();
            this.f53240f.D(i3);
        }

        @Override // androidx.sqlite.SQLiteStatement, java.lang.AutoCloseable
        public void close() throws IOException {
            this.f53240f.close();
            c(true);
        }

        @Override // androidx.sqlite.SQLiteStatement
        public String f2(int i3) {
            f();
            SQLite.b(21, "no row");
            throw new KotlinNothingValueException();
        }

        @Override // androidx.sqlite.SQLiteStatement
        public int getColumnCount() {
            f();
            return 0;
        }

        @Override // androidx.sqlite.SQLiteStatement
        public String getColumnName(int i3) {
            f();
            SQLite.b(21, "no row");
            throw new KotlinNothingValueException();
        }

        @Override // androidx.sqlite.SQLiteStatement
        public double getDouble(int i3) {
            f();
            SQLite.b(21, "no row");
            throw new KotlinNothingValueException();
        }

        @Override // androidx.sqlite.SQLiteStatement
        public long getLong(int i3) {
            f();
            SQLite.b(21, "no row");
            throw new KotlinNothingValueException();
        }

        @Override // androidx.sqlite.SQLiteStatement
        public boolean isNull(int i3) {
            f();
            SQLite.b(21, "no row");
            throw new KotlinNothingValueException();
        }

        @Override // androidx.sqlite.SQLiteStatement
        public void p0(int i3, String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            f();
            this.f53240f.s1(i3, value);
        }

        @Override // androidx.sqlite.SQLiteStatement
        public void reset() {
            f();
        }

        @Override // androidx.sqlite.SQLiteStatement
        public void t(int i3, double d3) {
            f();
            this.f53240f.t(i3, d3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    static final class RowSQLiteStatement extends SupportSQLiteStatement {

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public static final Companion f53241l = new Companion(null);

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int[] f53242f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private long[] f53243g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private double[] f53244h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private String[] f53245i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private byte[][] f53246j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private Cursor f53247k;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RowSQLiteStatement(SupportSQLiteDatabase db, String sql) {
            super(db, sql, null);
            Intrinsics.checkNotNullParameter(db, "db");
            Intrinsics.checkNotNullParameter(sql, "sql");
            this.f53242f = new int[0];
            this.f53243g = new long[0];
            this.f53244h = new double[0];
            this.f53245i = new String[0];
            this.f53246j = new byte[0][];
        }

        private final Cursor C() {
            Cursor cursor = this.f53247k;
            if (cursor != null) {
                return cursor;
            }
            SQLite.b(21, "no row");
            throw new KotlinNothingValueException();
        }

        private final void n(int i3, int i4) {
            int i5 = i4 + 1;
            int[] iArr = this.f53242f;
            if (iArr.length < i5) {
                int[] iArrCopyOf = Arrays.copyOf(iArr, i5);
                Intrinsics.checkNotNullExpressionValue(iArrCopyOf, "copyOf(...)");
                this.f53242f = iArrCopyOf;
            }
            if (i3 == 1) {
                long[] jArr = this.f53243g;
                if (jArr.length < i5) {
                    long[] jArrCopyOf = Arrays.copyOf(jArr, i5);
                    Intrinsics.checkNotNullExpressionValue(jArrCopyOf, "copyOf(...)");
                    this.f53243g = jArrCopyOf;
                    return;
                }
                return;
            }
            if (i3 == 2) {
                double[] dArr = this.f53244h;
                if (dArr.length < i5) {
                    double[] dArrCopyOf = Arrays.copyOf(dArr, i5);
                    Intrinsics.checkNotNullExpressionValue(dArrCopyOf, "copyOf(...)");
                    this.f53244h = dArrCopyOf;
                    return;
                }
                return;
            }
            if (i3 == 3) {
                String[] strArr = this.f53245i;
                if (strArr.length < i5) {
                    Object[] objArrCopyOf = Arrays.copyOf(strArr, i5);
                    Intrinsics.checkNotNullExpressionValue(objArrCopyOf, "copyOf(...)");
                    this.f53245i = (String[]) objArrCopyOf;
                    return;
                }
                return;
            }
            if (i3 != 4) {
                return;
            }
            byte[][] bArr = this.f53246j;
            if (bArr.length < i5) {
                Object[] objArrCopyOf2 = Arrays.copyOf(bArr, i5);
                Intrinsics.checkNotNullExpressionValue(objArrCopyOf2, "copyOf(...)");
                this.f53246j = (byte[][]) objArrCopyOf2;
            }
        }

        private final void r() {
            if (this.f53247k == null) {
                this.f53247k = a().P0(new SupportSQLiteQuery() { // from class: androidx.sqlite.driver.SupportSQLiteStatement$RowSQLiteStatement$ensureCursor$1
                    @Override // androidx.sqlite.db.SupportSQLiteQuery
                    public int a() {
                        return this.f53248a.f53242f.length;
                    }

                    @Override // androidx.sqlite.db.SupportSQLiteQuery
                    public String b() {
                        return this.f53248a.b();
                    }

                    @Override // androidx.sqlite.db.SupportSQLiteQuery
                    public void c(SupportSQLiteProgram statement) {
                        Intrinsics.checkNotNullParameter(statement, "statement");
                        int length = this.f53248a.f53242f.length;
                        for (int i3 = 1; i3 < length; i3++) {
                            int i4 = this.f53248a.f53242f[i3];
                            if (i4 == 1) {
                                statement.A(i3, this.f53248a.f53243g[i3]);
                            } else if (i4 == 2) {
                                statement.t(i3, this.f53248a.f53244h[i3]);
                            } else if (i4 == 3) {
                                String str = this.f53248a.f53245i[i3];
                                Intrinsics.checkNotNull(str);
                                statement.s1(i3, str);
                            } else if (i4 == 4) {
                                byte[] bArr = this.f53248a.f53246j[i3];
                                Intrinsics.checkNotNull(bArr);
                                statement.B(i3, bArr);
                            } else if (i4 == 5) {
                                statement.D(i3);
                            }
                        }
                    }
                });
            }
        }

        private final void z(Cursor cursor, int i3) {
            if (i3 < 0 || i3 >= cursor.getColumnCount()) {
                SQLite.b(25, "column index out of range");
                throw new KotlinNothingValueException();
            }
        }

        @Override // androidx.sqlite.SQLiteStatement
        public void A(int i3, long j3) {
            f();
            n(1, i3);
            this.f53242f[i3] = 1;
            this.f53243g[i3] = j3;
        }

        @Override // androidx.sqlite.SQLiteStatement
        public void B(int i3, byte[] value) {
            Intrinsics.checkNotNullParameter(value, "value");
            f();
            n(4, i3);
            this.f53242f[i3] = 4;
            this.f53246j[i3] = value;
        }

        @Override // androidx.sqlite.SQLiteStatement
        public boolean B2() {
            f();
            r();
            Cursor cursor = this.f53247k;
            if (cursor != null) {
                return cursor.moveToNext();
            }
            throw new IllegalStateException("Required value was null.");
        }

        @Override // androidx.sqlite.SQLiteStatement
        public void D(int i3) {
            f();
            n(5, i3);
            this.f53242f[i3] = 5;
        }

        @Override // androidx.sqlite.SQLiteStatement, java.lang.AutoCloseable
        public void close() {
            if (!isClosed()) {
                x2();
                reset();
            }
            c(true);
        }

        @Override // androidx.sqlite.SQLiteStatement
        public String f2(int i3) {
            f();
            Cursor cursorC = C();
            z(cursorC, i3);
            String string = cursorC.getString(i3);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            return string;
        }

        @Override // androidx.sqlite.SQLiteStatement
        public int getColumnCount() {
            f();
            r();
            Cursor cursor = this.f53247k;
            if (cursor != null) {
                return cursor.getColumnCount();
            }
            return 0;
        }

        @Override // androidx.sqlite.SQLiteStatement
        public String getColumnName(int i3) {
            f();
            r();
            Cursor cursor = this.f53247k;
            if (cursor == null) {
                throw new IllegalStateException("Required value was null.");
            }
            z(cursor, i3);
            String columnName = cursor.getColumnName(i3);
            Intrinsics.checkNotNullExpressionValue(columnName, "getColumnName(...)");
            return columnName;
        }

        @Override // androidx.sqlite.SQLiteStatement
        public double getDouble(int i3) {
            f();
            Cursor cursorC = C();
            z(cursorC, i3);
            return cursorC.getDouble(i3);
        }

        @Override // androidx.sqlite.SQLiteStatement
        public long getLong(int i3) {
            f();
            Cursor cursorC = C();
            z(cursorC, i3);
            return cursorC.getLong(i3);
        }

        @Override // androidx.sqlite.SQLiteStatement
        public boolean isNull(int i3) {
            f();
            Cursor cursorC = C();
            z(cursorC, i3);
            return cursorC.isNull(i3);
        }

        @Override // androidx.sqlite.SQLiteStatement
        public void p0(int i3, String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            f();
            n(3, i3);
            this.f53242f[i3] = 3;
            this.f53245i[i3] = value;
        }

        @Override // androidx.sqlite.SQLiteStatement
        public void reset() {
            f();
            Cursor cursor = this.f53247k;
            if (cursor != null) {
                cursor.close();
            }
            this.f53247k = null;
        }

        @Override // androidx.sqlite.SQLiteStatement
        public void t(int i3, double d3) {
            f();
            n(2, i3);
            this.f53242f[i3] = 2;
            this.f53244h[i3] = d3;
        }

        public void x2() {
            f();
            this.f53242f = new int[0];
            this.f53243g = new long[0];
            this.f53244h = new double[0];
            this.f53245i = new String[0];
            this.f53246j = new byte[0][];
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class TransactionSQLiteStatement extends SupportSQLiteStatement {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final Companion.TransactionOperation f53249f;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final /* synthetic */ class WhenMappings {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f53250a;

            static {
                int[] iArr = new int[Companion.TransactionOperation.values().length];
                try {
                    iArr[Companion.TransactionOperation.f53232a.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[Companion.TransactionOperation.f53233b.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[Companion.TransactionOperation.f53234c.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[Companion.TransactionOperation.f53235d.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[Companion.TransactionOperation.f53236f.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                f53250a = iArr;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TransactionSQLiteStatement(SupportSQLiteDatabase db, String sql, Companion.TransactionOperation operation) {
            super(db, sql, null);
            Intrinsics.checkNotNullParameter(db, "db");
            Intrinsics.checkNotNullParameter(sql, "sql");
            Intrinsics.checkNotNullParameter(operation, "operation");
            this.f53249f = operation;
        }

        @Override // androidx.sqlite.SQLiteStatement
        public void A(int i3, long j3) {
            f();
            SQLite.b(25, "column index out of range");
            throw new KotlinNothingValueException();
        }

        @Override // androidx.sqlite.SQLiteStatement
        public void B(int i3, byte[] value) {
            Intrinsics.checkNotNullParameter(value, "value");
            f();
            SQLite.b(25, "column index out of range");
            throw new KotlinNothingValueException();
        }

        @Override // androidx.sqlite.SQLiteStatement
        public boolean B2() {
            int i3 = WhenMappings.f53250a[this.f53249f.ordinal()];
            if (i3 == 1) {
                a().t0();
                a().G0();
                return false;
            }
            if (i3 == 2) {
                a().G0();
                return false;
            }
            if (i3 == 3) {
                a().H();
                return false;
            }
            if (i3 == 4) {
                a().v0();
                return false;
            }
            if (i3 != 5) {
                throw new NoWhenBranchMatchedException();
            }
            a().F1();
            return false;
        }

        @Override // androidx.sqlite.SQLiteStatement
        public void D(int i3) {
            f();
            SQLite.b(25, "column index out of range");
            throw new KotlinNothingValueException();
        }

        @Override // androidx.sqlite.SQLiteStatement, java.lang.AutoCloseable
        public void close() {
            c(true);
        }

        @Override // androidx.sqlite.SQLiteStatement
        public String f2(int i3) {
            f();
            SQLite.b(21, "no row");
            throw new KotlinNothingValueException();
        }

        @Override // androidx.sqlite.SQLiteStatement
        public int getColumnCount() {
            f();
            return 0;
        }

        @Override // androidx.sqlite.SQLiteStatement
        public String getColumnName(int i3) {
            f();
            SQLite.b(21, "no row");
            throw new KotlinNothingValueException();
        }

        @Override // androidx.sqlite.SQLiteStatement
        public double getDouble(int i3) {
            f();
            SQLite.b(21, "no row");
            throw new KotlinNothingValueException();
        }

        @Override // androidx.sqlite.SQLiteStatement
        public long getLong(int i3) {
            f();
            SQLite.b(21, "no row");
            throw new KotlinNothingValueException();
        }

        @Override // androidx.sqlite.SQLiteStatement
        public boolean isNull(int i3) {
            f();
            SQLite.b(21, "no row");
            throw new KotlinNothingValueException();
        }

        @Override // androidx.sqlite.SQLiteStatement
        public void p0(int i3, String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            f();
            SQLite.b(25, "column index out of range");
            throw new KotlinNothingValueException();
        }

        @Override // androidx.sqlite.SQLiteStatement
        public void reset() {
            f();
        }

        @Override // androidx.sqlite.SQLiteStatement
        public void t(int i3, double d3) {
            f();
            SQLite.b(25, "column index out of range");
            throw new KotlinNothingValueException();
        }
    }

    public /* synthetic */ SupportSQLiteStatement(SupportSQLiteDatabase supportSQLiteDatabase, String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(supportSQLiteDatabase, str);
    }

    protected final SupportSQLiteDatabase a() {
        return this.f53228a;
    }

    protected final String b() {
        return this.f53229b;
    }

    protected final void c(boolean z2) {
        this.f53230c = z2;
    }

    protected final void f() {
        if (this.f53230c) {
            SQLite.b(21, "statement is closed");
            throw new KotlinNothingValueException();
        }
    }

    protected final boolean isClosed() {
        return this.f53230c;
    }

    private SupportSQLiteStatement(SupportSQLiteDatabase supportSQLiteDatabase, String str) {
        this.f53228a = supportSQLiteDatabase;
        this.f53229b = str;
    }
}
