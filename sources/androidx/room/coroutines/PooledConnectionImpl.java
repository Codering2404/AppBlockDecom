package androidx.room.coroutines;

import androidx.room.TransactionScope;
import androidx.room.Transactor;
import androidx.room.concurrent.ThreadLocal_jvmAndroidKt;
import androidx.sqlite.SQLite;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.collections.ArrayDeque;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
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
final class PooledConnectionImpl implements Transactor, RawConnectionAccessor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ConnectionElementKey f52593a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ConnectionWithLock f52594b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f52595c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ArrayDeque f52596d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final AtomicBoolean f52597e;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private final class StatementWrapper implements SQLiteStatement {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final SQLiteStatement f52598a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f52599b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ PooledConnectionImpl f52600c;

        public StatementWrapper(PooledConnectionImpl pooledConnectionImpl, SQLiteStatement delegate) {
            Intrinsics.checkNotNullParameter(delegate, "delegate");
            this.f52600c = pooledConnectionImpl;
            this.f52598a = delegate;
            this.f52599b = ThreadLocal_jvmAndroidKt.b();
        }

        @Override // androidx.sqlite.SQLiteStatement
        public void A(int i3, long j3) {
            if (this.f52600c.o()) {
                SQLite.b(21, "Statement is recycled");
                throw new KotlinNothingValueException();
            }
            if (this.f52599b == ThreadLocal_jvmAndroidKt.b()) {
                this.f52598a.A(i3, j3);
            } else {
                SQLite.b(21, "Attempted to use statement on a different thread");
                throw new KotlinNothingValueException();
            }
        }

        @Override // androidx.sqlite.SQLiteStatement
        public void B(int i3, byte[] value) {
            Intrinsics.checkNotNullParameter(value, "value");
            if (this.f52600c.o()) {
                SQLite.b(21, "Statement is recycled");
                throw new KotlinNothingValueException();
            }
            if (this.f52599b == ThreadLocal_jvmAndroidKt.b()) {
                this.f52598a.B(i3, value);
            } else {
                SQLite.b(21, "Attempted to use statement on a different thread");
                throw new KotlinNothingValueException();
            }
        }

        @Override // androidx.sqlite.SQLiteStatement
        public boolean B2() {
            if (this.f52600c.o()) {
                SQLite.b(21, "Statement is recycled");
                throw new KotlinNothingValueException();
            }
            if (this.f52599b == ThreadLocal_jvmAndroidKt.b()) {
                return this.f52598a.B2();
            }
            SQLite.b(21, "Attempted to use statement on a different thread");
            throw new KotlinNothingValueException();
        }

        @Override // androidx.sqlite.SQLiteStatement
        public void D(int i3) {
            if (this.f52600c.o()) {
                SQLite.b(21, "Statement is recycled");
                throw new KotlinNothingValueException();
            }
            if (this.f52599b == ThreadLocal_jvmAndroidKt.b()) {
                this.f52598a.D(i3);
            } else {
                SQLite.b(21, "Attempted to use statement on a different thread");
                throw new KotlinNothingValueException();
            }
        }

        @Override // androidx.sqlite.SQLiteStatement, java.lang.AutoCloseable
        public void close() {
            if (this.f52600c.o()) {
                SQLite.b(21, "Statement is recycled");
                throw new KotlinNothingValueException();
            }
            if (this.f52599b == ThreadLocal_jvmAndroidKt.b()) {
                this.f52598a.close();
            } else {
                SQLite.b(21, "Attempted to use statement on a different thread");
                throw new KotlinNothingValueException();
            }
        }

        @Override // androidx.sqlite.SQLiteStatement
        public String f2(int i3) {
            if (this.f52600c.o()) {
                SQLite.b(21, "Statement is recycled");
                throw new KotlinNothingValueException();
            }
            if (this.f52599b == ThreadLocal_jvmAndroidKt.b()) {
                return this.f52598a.f2(i3);
            }
            SQLite.b(21, "Attempted to use statement on a different thread");
            throw new KotlinNothingValueException();
        }

        @Override // androidx.sqlite.SQLiteStatement
        public int getColumnCount() {
            if (this.f52600c.o()) {
                SQLite.b(21, "Statement is recycled");
                throw new KotlinNothingValueException();
            }
            if (this.f52599b == ThreadLocal_jvmAndroidKt.b()) {
                return this.f52598a.getColumnCount();
            }
            SQLite.b(21, "Attempted to use statement on a different thread");
            throw new KotlinNothingValueException();
        }

        @Override // androidx.sqlite.SQLiteStatement
        public String getColumnName(int i3) {
            if (this.f52600c.o()) {
                SQLite.b(21, "Statement is recycled");
                throw new KotlinNothingValueException();
            }
            if (this.f52599b == ThreadLocal_jvmAndroidKt.b()) {
                return this.f52598a.getColumnName(i3);
            }
            SQLite.b(21, "Attempted to use statement on a different thread");
            throw new KotlinNothingValueException();
        }

        @Override // androidx.sqlite.SQLiteStatement
        public double getDouble(int i3) {
            if (this.f52600c.o()) {
                SQLite.b(21, "Statement is recycled");
                throw new KotlinNothingValueException();
            }
            if (this.f52599b == ThreadLocal_jvmAndroidKt.b()) {
                return this.f52598a.getDouble(i3);
            }
            SQLite.b(21, "Attempted to use statement on a different thread");
            throw new KotlinNothingValueException();
        }

        @Override // androidx.sqlite.SQLiteStatement
        public long getLong(int i3) {
            if (this.f52600c.o()) {
                SQLite.b(21, "Statement is recycled");
                throw new KotlinNothingValueException();
            }
            if (this.f52599b == ThreadLocal_jvmAndroidKt.b()) {
                return this.f52598a.getLong(i3);
            }
            SQLite.b(21, "Attempted to use statement on a different thread");
            throw new KotlinNothingValueException();
        }

        @Override // androidx.sqlite.SQLiteStatement
        public boolean isNull(int i3) {
            if (this.f52600c.o()) {
                SQLite.b(21, "Statement is recycled");
                throw new KotlinNothingValueException();
            }
            if (this.f52599b == ThreadLocal_jvmAndroidKt.b()) {
                return this.f52598a.isNull(i3);
            }
            SQLite.b(21, "Attempted to use statement on a different thread");
            throw new KotlinNothingValueException();
        }

        @Override // androidx.sqlite.SQLiteStatement
        public void p0(int i3, String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            if (this.f52600c.o()) {
                SQLite.b(21, "Statement is recycled");
                throw new KotlinNothingValueException();
            }
            if (this.f52599b == ThreadLocal_jvmAndroidKt.b()) {
                this.f52598a.p0(i3, value);
            } else {
                SQLite.b(21, "Attempted to use statement on a different thread");
                throw new KotlinNothingValueException();
            }
        }

        @Override // androidx.sqlite.SQLiteStatement
        public void reset() {
            if (this.f52600c.o()) {
                SQLite.b(21, "Statement is recycled");
                throw new KotlinNothingValueException();
            }
            if (this.f52599b == ThreadLocal_jvmAndroidKt.b()) {
                this.f52598a.reset();
            } else {
                SQLite.b(21, "Attempted to use statement on a different thread");
                throw new KotlinNothingValueException();
            }
        }

        @Override // androidx.sqlite.SQLiteStatement
        public void t(int i3, double d3) {
            if (this.f52600c.o()) {
                SQLite.b(21, "Statement is recycled");
                throw new KotlinNothingValueException();
            }
            if (this.f52599b == ThreadLocal_jvmAndroidKt.b()) {
                this.f52598a.t(i3, d3);
            } else {
                SQLite.b(21, "Attempted to use statement on a different thread");
                throw new KotlinNothingValueException();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    final class TransactionImpl<T> implements TransactionScope<T>, RawConnectionAccessor {
        public TransactionImpl() {
        }

        @Override // androidx.room.coroutines.RawConnectionAccessor
        public SQLiteConnection c() {
            return PooledConnectionImpl.this.c();
        }

        @Override // androidx.room.PooledConnection
        public Object d(String str, Function1 function1, Continuation continuation) {
            return PooledConnectionImpl.this.d(str, function1, continuation);
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public java.lang.Object e(java.lang.Object r8, kotlin.coroutines.Continuation r9) throws java.lang.Throwable {
            /*
                r7 = this;
                boolean r0 = r9 instanceof androidx.room.coroutines.PooledConnectionImpl$TransactionImpl$rollback$1
                if (r0 == 0) goto L13
                r0 = r9
                androidx.room.coroutines.PooledConnectionImpl$TransactionImpl$rollback$1 r0 = (androidx.room.coroutines.PooledConnectionImpl$TransactionImpl$rollback$1) r0
                int r1 = r0.f52607g
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.f52607g = r1
                goto L18
            L13:
                androidx.room.coroutines.PooledConnectionImpl$TransactionImpl$rollback$1 r0 = new androidx.room.coroutines.PooledConnectionImpl$TransactionImpl$rollback$1
                r0.<init>(r7, r9)
            L18:
                java.lang.Object r9 = r0.f52605d
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                int r2 = r0.f52607g
                r3 = 1
                r4 = 0
                if (r2 == 0) goto L3c
                if (r2 == r3) goto L2e
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r9)
                throw r8
            L2e:
                java.lang.Object r8 = r0.f52604c
                kotlinx.coroutines.sync.Mutex r8 = (kotlinx.coroutines.sync.Mutex) r8
                java.lang.Object r1 = r0.f52603b
                androidx.room.coroutines.PooledConnectionImpl r1 = (androidx.room.coroutines.PooledConnectionImpl) r1
                java.lang.Object r0 = r0.f52602a
                kotlin.ResultKt.b(r9)
                goto L7f
            L3c:
                kotlin.ResultKt.b(r9)
                androidx.room.coroutines.PooledConnectionImpl r9 = androidx.room.coroutines.PooledConnectionImpl.this
                boolean r2 = androidx.room.coroutines.PooledConnectionImpl.h(r9)
                r5 = 21
                if (r2 != 0) goto Laf
                kotlin.coroutines.CoroutineContext r2 = r0.getContext()
                androidx.room.coroutines.ConnectionElementKey r6 = r9.l()
                kotlin.coroutines.CoroutineContext$Element r2 = r2.get(r6)
                androidx.room.coroutines.ConnectionElement r2 = (androidx.room.coroutines.ConnectionElement) r2
                if (r2 == 0) goto La4
                androidx.room.coroutines.PooledConnectionImpl r2 = r2.d()
                if (r2 != r9) goto La4
                kotlin.collections.ArrayDeque r2 = androidx.room.coroutines.PooledConnectionImpl.g(r9)
                boolean r2 = r2.isEmpty()
                if (r2 != 0) goto L9c
                androidx.room.coroutines.ConnectionWithLock r2 = r9.m()
                r0.f52602a = r8
                r0.f52603b = r9
                r0.f52604c = r2
                r0.f52607g = r3
                java.lang.Object r0 = r2.f(r4, r0)
                if (r0 != r1) goto L7c
                return r1
            L7c:
                r0 = r8
                r1 = r9
                r8 = r2
            L7f:
                kotlin.collections.ArrayDeque r9 = androidx.room.coroutines.PooledConnectionImpl.g(r1)     // Catch: java.lang.Throwable -> L97
                java.lang.Object r9 = r9.last()     // Catch: java.lang.Throwable -> L97
                androidx.room.coroutines.PooledConnectionImpl$TransactionItem r9 = (androidx.room.coroutines.PooledConnectionImpl.TransactionItem) r9     // Catch: java.lang.Throwable -> L97
                r9.c(r3)     // Catch: java.lang.Throwable -> L97
                kotlin.Unit r9 = kotlin.Unit.f139807a     // Catch: java.lang.Throwable -> L97
                r8.i(r4)
                androidx.room.coroutines.ConnectionPool$RollbackException r8 = new androidx.room.coroutines.ConnectionPool$RollbackException
                r8.<init>(r0)
                throw r8
            L97:
                r9 = move-exception
                r8.i(r4)
                throw r9
            L9c:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r9 = "Not in a transaction"
                r8.<init>(r9)
                throw r8
            La4:
                java.lang.String r8 = "Attempted to use connection on a different coroutine"
                androidx.sqlite.SQLite.b(r5, r8)
                kotlin.KotlinNothingValueException r8 = new kotlin.KotlinNothingValueException
                r8.<init>()
                throw r8
            Laf:
                java.lang.String r8 = "Connection is recycled"
                androidx.sqlite.SQLite.b(r5, r8)
                kotlin.KotlinNothingValueException r8 = new kotlin.KotlinNothingValueException
                r8.<init>()
                throw r8
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.room.coroutines.PooledConnectionImpl.TransactionImpl.e(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class TransactionItem {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f52608a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f52609b;

        public TransactionItem(int i3, boolean z2) {
            this.f52608a = i3;
            this.f52609b = z2;
        }

        public final int a() {
            return this.f52608a;
        }

        public final boolean b() {
            return this.f52609b;
        }

        public final void c(boolean z2) {
            this.f52609b = z2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f52610a;

        static {
            int[] iArr = new int[Transactor.SQLiteTransactionType.values().length];
            try {
                iArr[Transactor.SQLiteTransactionType.f52389a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Transactor.SQLiteTransactionType.f52390b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Transactor.SQLiteTransactionType.f52391c.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f52610a = iArr;
        }
    }

    public PooledConnectionImpl(ConnectionElementKey connectionElementKey, ConnectionWithLock delegate, boolean z2) {
        Intrinsics.checkNotNullParameter(connectionElementKey, "connectionElementKey");
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.f52593a = connectionElementKey;
        this.f52594b = delegate;
        this.f52595c = z2;
        this.f52596d = new ArrayDeque();
        this.f52597e = new AtomicBoolean(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object j(androidx.room.Transactor.SQLiteTransactionType r6, kotlin.coroutines.Continuation r7) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r7 instanceof androidx.room.coroutines.PooledConnectionImpl$beginTransaction$1
            if (r0 == 0) goto L13
            r0 = r7
            androidx.room.coroutines.PooledConnectionImpl$beginTransaction$1 r0 = (androidx.room.coroutines.PooledConnectionImpl$beginTransaction$1) r0
            int r1 = r0.f52615f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f52615f = r1
            goto L18
        L13:
            androidx.room.coroutines.PooledConnectionImpl$beginTransaction$1 r0 = new androidx.room.coroutines.PooledConnectionImpl$beginTransaction$1
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.f52613c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f52615f
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L3c
            if (r2 != r3) goto L34
            java.lang.Object r6 = r0.f52612b
            kotlinx.coroutines.sync.Mutex r6 = (kotlinx.coroutines.sync.Mutex) r6
            java.lang.Object r0 = r0.f52611a
            androidx.room.Transactor$SQLiteTransactionType r0 = (androidx.room.Transactor.SQLiteTransactionType) r0
            kotlin.ResultKt.b(r7)
            r7 = r6
            r6 = r0
            goto L4e
        L34:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3c:
            kotlin.ResultKt.b(r7)
            androidx.room.coroutines.ConnectionWithLock r7 = r5.f52594b
            r0.f52611a = r6
            r0.f52612b = r7
            r0.f52615f = r3
            java.lang.Object r0 = r7.f(r4, r0)
            if (r0 != r1) goto L4e
            return r1
        L4e:
            kotlin.collections.ArrayDeque r0 = r5.f52596d     // Catch: java.lang.Throwable -> L74
            int r0 = r0.size()     // Catch: java.lang.Throwable -> L74
            kotlin.collections.ArrayDeque r1 = r5.f52596d     // Catch: java.lang.Throwable -> L74
            boolean r1 = r1.isEmpty()     // Catch: java.lang.Throwable -> L74
            if (r1 == 0) goto L8c
            int[] r1 = androidx.room.coroutines.PooledConnectionImpl.WhenMappings.f52610a     // Catch: java.lang.Throwable -> L74
            int r6 = r6.ordinal()     // Catch: java.lang.Throwable -> L74
            r6 = r1[r6]     // Catch: java.lang.Throwable -> L74
            if (r6 == r3) goto L84
            r1 = 2
            if (r6 == r1) goto L7c
            r1 = 3
            if (r6 != r1) goto L76
            androidx.room.coroutines.ConnectionWithLock r6 = r5.f52594b     // Catch: java.lang.Throwable -> L74
            java.lang.String r1 = "BEGIN EXCLUSIVE TRANSACTION"
            androidx.sqlite.SQLite.a(r6, r1)     // Catch: java.lang.Throwable -> L74
            goto La7
        L74:
            r6 = move-exception
            goto Lb8
        L76:
            kotlin.NoWhenBranchMatchedException r6 = new kotlin.NoWhenBranchMatchedException     // Catch: java.lang.Throwable -> L74
            r6.<init>()     // Catch: java.lang.Throwable -> L74
            throw r6     // Catch: java.lang.Throwable -> L74
        L7c:
            androidx.room.coroutines.ConnectionWithLock r6 = r5.f52594b     // Catch: java.lang.Throwable -> L74
            java.lang.String r1 = "BEGIN IMMEDIATE TRANSACTION"
            androidx.sqlite.SQLite.a(r6, r1)     // Catch: java.lang.Throwable -> L74
            goto La7
        L84:
            androidx.room.coroutines.ConnectionWithLock r6 = r5.f52594b     // Catch: java.lang.Throwable -> L74
            java.lang.String r1 = "BEGIN DEFERRED TRANSACTION"
            androidx.sqlite.SQLite.a(r6, r1)     // Catch: java.lang.Throwable -> L74
            goto La7
        L8c:
            androidx.room.coroutines.ConnectionWithLock r6 = r5.f52594b     // Catch: java.lang.Throwable -> L74
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L74
            r1.<init>()     // Catch: java.lang.Throwable -> L74
            java.lang.String r2 = "SAVEPOINT '"
            r1.append(r2)     // Catch: java.lang.Throwable -> L74
            r1.append(r0)     // Catch: java.lang.Throwable -> L74
            r2 = 39
            r1.append(r2)     // Catch: java.lang.Throwable -> L74
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L74
            androidx.sqlite.SQLite.a(r6, r1)     // Catch: java.lang.Throwable -> L74
        La7:
            kotlin.collections.ArrayDeque r6 = r5.f52596d     // Catch: java.lang.Throwable -> L74
            androidx.room.coroutines.PooledConnectionImpl$TransactionItem r1 = new androidx.room.coroutines.PooledConnectionImpl$TransactionItem     // Catch: java.lang.Throwable -> L74
            r2 = 0
            r1.<init>(r0, r2)     // Catch: java.lang.Throwable -> L74
            r6.addLast(r1)     // Catch: java.lang.Throwable -> L74
            kotlin.Unit r6 = kotlin.Unit.f139807a     // Catch: java.lang.Throwable -> L74
            r7.i(r4)
            return r6
        Lb8:
            r7.i(r4)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.coroutines.PooledConnectionImpl.j(androidx.room.Transactor$SQLiteTransactionType, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object k(boolean r6, kotlin.coroutines.Continuation r7) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 212
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.coroutines.PooledConnectionImpl.k(boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean o() {
        return this.f52597e.get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00bc, code lost:
    
        if (k(false, r0) == r1) goto L60;
     */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0095 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00be A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object q(androidx.room.Transactor.SQLiteTransactionType r11, kotlin.jvm.functions.Function2 r12, kotlin.coroutines.Continuation r13) throws java.lang.Throwable {
        /*
            r10 = this;
            boolean r0 = r13 instanceof androidx.room.coroutines.PooledConnectionImpl$transaction$1
            if (r0 == 0) goto L13
            r0 = r13
            androidx.room.coroutines.PooledConnectionImpl$transaction$1 r0 = (androidx.room.coroutines.PooledConnectionImpl$transaction$1) r0
            int r1 = r0.f52626g
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f52626g = r1
            goto L18
        L13:
            androidx.room.coroutines.PooledConnectionImpl$transaction$1 r0 = new androidx.room.coroutines.PooledConnectionImpl$transaction$1
            r0.<init>(r10, r13)
        L18:
            java.lang.Object r13 = r0.f52624d
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f52626g
            r3 = 5
            r4 = 4
            r5 = 3
            r6 = 2
            r7 = 0
            r8 = 1
            r9 = 0
            if (r2 == 0) goto L62
            if (r2 == r8) goto L59
            if (r2 == r6) goto L51
            if (r2 == r5) goto L4b
            if (r2 == r4) goto L4b
            if (r2 == r3) goto L3b
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L3b:
            java.lang.Object r11 = r0.f52622b
            java.lang.Throwable r11 = (java.lang.Throwable) r11
            java.lang.Object r12 = r0.f52621a
            java.lang.Throwable r12 = (java.lang.Throwable) r12
            kotlin.ResultKt.b(r13)     // Catch: android.database.SQLException -> L48
            goto Lc6
        L48:
            r13 = move-exception
            goto Lc1
        L4b:
            java.lang.Object r11 = r0.f52621a
            kotlin.ResultKt.b(r13)
            return r11
        L51:
            int r11 = r0.f52623c
            kotlin.ResultKt.b(r13)     // Catch: java.lang.Throwable -> L57
            goto L87
        L57:
            r11 = move-exception
            goto L96
        L59:
            java.lang.Object r11 = r0.f52621a
            r12 = r11
            kotlin.jvm.functions.Function2 r12 = (kotlin.jvm.functions.Function2) r12
            kotlin.ResultKt.b(r13)
            goto L74
        L62:
            kotlin.ResultKt.b(r13)
            if (r11 != 0) goto L69
            androidx.room.Transactor$SQLiteTransactionType r11 = androidx.room.Transactor.SQLiteTransactionType.f52389a
        L69:
            r0.f52621a = r12
            r0.f52626g = r8
            java.lang.Object r11 = r10.j(r11, r0)
            if (r11 != r1) goto L74
            goto Lbe
        L74:
            androidx.room.coroutines.PooledConnectionImpl$TransactionImpl r11 = new androidx.room.coroutines.PooledConnectionImpl$TransactionImpl     // Catch: java.lang.Throwable -> L57
            r11.<init>()     // Catch: java.lang.Throwable -> L57
            r0.f52621a = r9     // Catch: java.lang.Throwable -> L57
            r0.f52623c = r8     // Catch: java.lang.Throwable -> L57
            r0.f52626g = r6     // Catch: java.lang.Throwable -> L57
            java.lang.Object r13 = r12.invoke(r11, r0)     // Catch: java.lang.Throwable -> L57
            if (r13 != r1) goto L86
            goto Lbe
        L86:
            r11 = r8
        L87:
            if (r11 == 0) goto L8a
            r7 = r8
        L8a:
            r0.f52621a = r13
            r0.f52626g = r5
            java.lang.Object r11 = r10.k(r7, r0)
            if (r11 != r1) goto L95
            goto Lbe
        L95:
            return r13
        L96:
            boolean r12 = r11 instanceof androidx.room.coroutines.ConnectionPool.RollbackException     // Catch: java.lang.Throwable -> Lac
            if (r12 == 0) goto Lae
            androidx.room.coroutines.ConnectionPool$RollbackException r11 = (androidx.room.coroutines.ConnectionPool.RollbackException) r11     // Catch: java.lang.Throwable -> Lac
            java.lang.Object r11 = r11.a()     // Catch: java.lang.Throwable -> Lac
            r0.f52621a = r11
            r0.f52626g = r4
            java.lang.Object r12 = r10.k(r7, r0)
            if (r12 != r1) goto Lab
            goto Lbe
        Lab:
            return r11
        Lac:
            r11 = move-exception
            goto Lb2
        Lae:
            throw r11     // Catch: java.lang.Throwable -> Laf
        Laf:
            r12 = move-exception
            r9 = r11
            r11 = r12
        Lb2:
            r0.f52621a = r9     // Catch: android.database.SQLException -> Lbf
            r0.f52622b = r11     // Catch: android.database.SQLException -> Lbf
            r0.f52626g = r3     // Catch: android.database.SQLException -> Lbf
            java.lang.Object r12 = r10.k(r7, r0)     // Catch: android.database.SQLException -> Lbf
            if (r12 != r1) goto Lc6
        Lbe:
            return r1
        Lbf:
            r13 = move-exception
            r12 = r9
        Lc1:
            if (r12 == 0) goto Lc7
            kotlin.ExceptionsKt.a(r12, r13)
        Lc6:
            throw r11
        Lc7:
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.coroutines.PooledConnectionImpl.q(androidx.room.Transactor$SQLiteTransactionType, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // androidx.room.Transactor
    public Object a(Transactor.SQLiteTransactionType sQLiteTransactionType, Function2 function2, Continuation continuation) {
        if (o()) {
            SQLite.b(21, "Connection is recycled");
            throw new KotlinNothingValueException();
        }
        ConnectionElement connectionElement = (ConnectionElement) continuation.getContext().get(l());
        if (connectionElement != null && connectionElement.d() == this) {
            return q(sQLiteTransactionType, function2, continuation);
        }
        SQLite.b(21, "Attempted to use connection on a different coroutine");
        throw new KotlinNothingValueException();
    }

    @Override // androidx.room.Transactor
    public Object b(Continuation continuation) {
        if (o()) {
            SQLite.b(21, "Connection is recycled");
            throw new KotlinNothingValueException();
        }
        ConnectionElement connectionElement = (ConnectionElement) continuation.getContext().get(l());
        if (connectionElement != null && connectionElement.d() == this) {
            return Boxing.a(!this.f52596d.isEmpty() || this.f52594b.E());
        }
        SQLite.b(21, "Attempted to use connection on a different coroutine");
        throw new KotlinNothingValueException();
    }

    @Override // androidx.room.coroutines.RawConnectionAccessor
    public SQLiteConnection c() {
        return this.f52594b;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // androidx.room.PooledConnection
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object d(java.lang.String r7, kotlin.jvm.functions.Function1 r8, kotlin.coroutines.Continuation r9) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r9 instanceof androidx.room.coroutines.PooledConnectionImpl$usePrepared$1
            if (r0 == 0) goto L13
            r0 = r9
            androidx.room.coroutines.PooledConnectionImpl$usePrepared$1 r0 = (androidx.room.coroutines.PooledConnectionImpl$usePrepared$1) r0
            int r1 = r0.f52632g
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f52632g = r1
            goto L18
        L13:
            androidx.room.coroutines.PooledConnectionImpl$usePrepared$1 r0 = new androidx.room.coroutines.PooledConnectionImpl$usePrepared$1
            r0.<init>(r6, r9)
        L18:
            java.lang.Object r9 = r0.f52630d
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f52632g
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L40
            if (r2 != r3) goto L38
            java.lang.Object r7 = r0.f52629c
            kotlinx.coroutines.sync.Mutex r7 = (kotlinx.coroutines.sync.Mutex) r7
            java.lang.Object r8 = r0.f52628b
            kotlin.jvm.functions.Function1 r8 = (kotlin.jvm.functions.Function1) r8
            java.lang.Object r0 = r0.f52627a
            java.lang.String r0 = (java.lang.String) r0
            kotlin.ResultKt.b(r9)
            r9 = r7
            r7 = r0
            goto L72
        L38:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L40:
            kotlin.ResultKt.b(r9)
            boolean r9 = h(r6)
            r2 = 21
            if (r9 != 0) goto La0
            kotlin.coroutines.CoroutineContext r9 = r0.getContext()
            androidx.room.coroutines.ConnectionElementKey r5 = r6.l()
            kotlin.coroutines.CoroutineContext$Element r9 = r9.get(r5)
            androidx.room.coroutines.ConnectionElement r9 = (androidx.room.coroutines.ConnectionElement) r9
            if (r9 == 0) goto L95
            androidx.room.coroutines.PooledConnectionImpl r9 = r9.d()
            if (r9 != r6) goto L95
            androidx.room.coroutines.ConnectionWithLock r9 = r6.f52594b
            r0.f52627a = r7
            r0.f52628b = r8
            r0.f52629c = r9
            r0.f52632g = r3
            java.lang.Object r0 = r9.f(r4, r0)
            if (r0 != r1) goto L72
            return r1
        L72:
            androidx.room.coroutines.PooledConnectionImpl$StatementWrapper r0 = new androidx.room.coroutines.PooledConnectionImpl$StatementWrapper     // Catch: java.lang.Throwable -> L88
            androidx.room.coroutines.ConnectionWithLock r1 = r6.f52594b     // Catch: java.lang.Throwable -> L88
            androidx.sqlite.SQLiteStatement r7 = r1.G2(r7)     // Catch: java.lang.Throwable -> L88
            r0.<init>(r6, r7)     // Catch: java.lang.Throwable -> L88
            java.lang.Object r7 = r8.invoke(r0)     // Catch: java.lang.Throwable -> L8a
            kotlin.jdk7.AutoCloseableKt.a(r0, r4)     // Catch: java.lang.Throwable -> L88
            r9.i(r4)
            return r7
        L88:
            r7 = move-exception
            goto L91
        L8a:
            r7 = move-exception
            throw r7     // Catch: java.lang.Throwable -> L8c
        L8c:
            r8 = move-exception
            kotlin.jdk7.AutoCloseableKt.a(r0, r7)     // Catch: java.lang.Throwable -> L88
            throw r8     // Catch: java.lang.Throwable -> L88
        L91:
            r9.i(r4)
            throw r7
        L95:
            java.lang.String r7 = "Attempted to use connection on a different coroutine"
            androidx.sqlite.SQLite.b(r2, r7)
            kotlin.KotlinNothingValueException r7 = new kotlin.KotlinNothingValueException
            r7.<init>()
            throw r7
        La0:
            java.lang.String r7 = "Connection is recycled"
            androidx.sqlite.SQLite.b(r2, r7)
            kotlin.KotlinNothingValueException r7 = new kotlin.KotlinNothingValueException
            r7.<init>()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.coroutines.PooledConnectionImpl.d(java.lang.String, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final ConnectionElementKey l() {
        return this.f52593a;
    }

    public final ConnectionWithLock m() {
        return this.f52594b;
    }

    public final boolean n() {
        return this.f52595c;
    }

    public final void p() throws Exception {
        if (this.f52597e.compareAndSet(false, true) && this.f52594b.E()) {
            SQLite.a(this.f52594b, "ROLLBACK TRANSACTION");
        }
    }
}
