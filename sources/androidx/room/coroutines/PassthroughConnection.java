package androidx.room.coroutines;

import androidx.room.TransactionScope;
import androidx.room.Transactor;
import androidx.sqlite.SQLiteConnection;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
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
final class PassthroughConnection implements Transactor, RawConnectionAccessor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Function2 f52540a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final SQLiteConnection f52541b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private AtomicInteger f52542c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Transactor.SQLiteTransactionType f52543d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private final class PassthroughTransactor<T> implements TransactionScope<T>, RawConnectionAccessor {
        public PassthroughTransactor() {
        }

        @Override // androidx.room.coroutines.RawConnectionAccessor
        public SQLiteConnection c() {
            return PassthroughConnection.this.c();
        }

        @Override // androidx.room.PooledConnection
        public Object d(String str, Function1 function1, Continuation continuation) {
            return PassthroughConnection.this.d(str, function1, continuation);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f52545a;

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
            f52545a = iArr;
        }
    }

    public PassthroughConnection(Function2 function2, SQLiteConnection delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.f52540a = function2;
        this.f52541b = delegate;
        this.f52542c = new AtomicInteger(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00c6 A[Catch: SQLException -> 0x00c9, TryCatch #0 {SQLException -> 0x00c9, blocks: (B:56:0x00be, B:58:0x00c6, B:61:0x00cb), top: B:67:0x00be }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object g(androidx.room.Transactor.SQLiteTransactionType r8, kotlin.jvm.functions.Function2 r9, kotlin.coroutines.Continuation r10) throws java.lang.Exception {
        /*
            Method dump skipped, instruction units count: 216
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.coroutines.PassthroughConnection.g(androidx.room.Transactor$SQLiteTransactionType, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // androidx.room.Transactor
    public Object a(Transactor.SQLiteTransactionType sQLiteTransactionType, Function2 function2, Continuation continuation) {
        Function2 function22 = this.f52540a;
        if (function22 == null) {
            return g(sQLiteTransactionType, function2, continuation);
        }
        Object objInvoke = function22.invoke(new PassthroughConnection$withTransaction$2(this, sQLiteTransactionType, function2, null), continuation);
        IntrinsicsKt.f();
        return objInvoke;
    }

    @Override // androidx.room.Transactor
    public Object b(Continuation continuation) {
        return Boxing.a(this.f52543d != null || this.f52541b.E());
    }

    @Override // androidx.room.coroutines.RawConnectionAccessor
    public SQLiteConnection c() {
        return this.f52541b;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // androidx.room.PooledConnection
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object d(java.lang.String r6, kotlin.jvm.functions.Function1 r7, kotlin.coroutines.Continuation r8) throws java.lang.Exception {
        /*
            r5 = this;
            boolean r0 = r8 instanceof androidx.room.coroutines.PassthroughConnection$usePrepared$1
            if (r0 == 0) goto L13
            r0 = r8
            androidx.room.coroutines.PassthroughConnection$usePrepared$1 r0 = (androidx.room.coroutines.PassthroughConnection$usePrepared$1) r0
            int r1 = r0.f52554f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f52554f = r1
            goto L18
        L13:
            androidx.room.coroutines.PassthroughConnection$usePrepared$1 r0 = new androidx.room.coroutines.PassthroughConnection$usePrepared$1
            r0.<init>(r5, r8)
        L18:
            java.lang.Object r8 = r0.f52552c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f52554f
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L41
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            kotlin.ResultKt.b(r8)
            return r8
        L2c:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L34:
            java.lang.Object r6 = r0.f52551b
            r7 = r6
            kotlin.jvm.functions.Function1 r7 = (kotlin.jvm.functions.Function1) r7
            java.lang.Object r6 = r0.f52550a
            java.lang.String r6 = (java.lang.String) r6
            kotlin.ResultKt.b(r8)
            goto L51
        L41:
            kotlin.ResultKt.b(r8)
            r0.f52550a = r6
            r0.f52551b = r7
            r0.f52554f = r4
            java.lang.Object r8 = r5.b(r0)
            if (r8 != r1) goto L51
            goto L6f
        L51:
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r8 = r8.booleanValue()
            r2 = 0
            if (r8 == 0) goto L71
            kotlin.jvm.functions.Function2 r8 = r5.f52540a
            if (r8 == 0) goto L71
            androidx.room.coroutines.PassthroughConnection$usePrepared$2 r4 = new androidx.room.coroutines.PassthroughConnection$usePrepared$2
            r4.<init>(r5, r6, r7, r2)
            r0.f52550a = r2
            r0.f52551b = r2
            r0.f52554f = r3
            java.lang.Object r6 = r8.invoke(r4, r0)
            if (r6 != r1) goto L70
        L6f:
            return r1
        L70:
            return r6
        L71:
            androidx.sqlite.SQLiteConnection r8 = r5.f52541b
            androidx.sqlite.SQLiteStatement r6 = r8.G2(r6)
            java.lang.Object r7 = r7.invoke(r6)     // Catch: java.lang.Throwable -> L7f
            kotlin.jdk7.AutoCloseableKt.a(r6, r2)
            return r7
        L7f:
            r7 = move-exception
            throw r7     // Catch: java.lang.Throwable -> L81
        L81:
            r8 = move-exception
            kotlin.jdk7.AutoCloseableKt.a(r6, r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.coroutines.PassthroughConnection.d(java.lang.String, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final SQLiteConnection f() {
        return this.f52541b;
    }
}
