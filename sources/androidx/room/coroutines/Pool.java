package androidx.room.coroutines;

import androidx.collection.CircularArray;
import androidx.media3.common.JBEE.bfIdKSjLOVjG;
import androidx.sqlite.SQLiteConnection;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.sync.Semaphore;
import kotlinx.coroutines.sync.SemaphoreKt;

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
final class Pool {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f52572a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Function0 f52573b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ReentrantLock f52574c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f52575d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f52576e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final ConnectionWithLock[] f52577f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Semaphore f52578g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final CircularArray f52579h;

    public Pool(int i3, Function0 connectionFactory) {
        Intrinsics.checkNotNullParameter(connectionFactory, "connectionFactory");
        this.f52572a = i3;
        this.f52573b = connectionFactory;
        this.f52574c = new ReentrantLock();
        this.f52577f = new ConnectionWithLock[i3];
        this.f52578g = SemaphoreKt.b(i3, 0, 2, null);
        this.f52579h = new CircularArray(i3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void f() {
        if (this.f52575d >= this.f52572a) {
            return;
        }
        ConnectionWithLock connectionWithLock = new ConnectionWithLock((SQLiteConnection) this.f52573b.invoke(), null, 2, 0 == true ? 1 : 0);
        ConnectionWithLock[] connectionWithLockArr = this.f52577f;
        int i3 = this.f52575d;
        this.f52575d = i3 + 1;
        connectionWithLockArr[i3] = connectionWithLock;
        this.f52579h.a(connectionWithLock);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(kotlin.coroutines.Continuation r5) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r5 instanceof androidx.room.coroutines.Pool$acquire$1
            if (r0 == 0) goto L13
            r0 = r5
            androidx.room.coroutines.Pool$acquire$1 r0 = (androidx.room.coroutines.Pool$acquire$1) r0
            int r1 = r0.f52582c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f52582c = r1
            goto L18
        L13:
            androidx.room.coroutines.Pool$acquire$1 r0 = new androidx.room.coroutines.Pool$acquire$1
            r0.<init>(r4, r5)
        L18:
            java.lang.Object r5 = r0.f52580a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f52582c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.ResultKt.b(r5)
            goto L3f
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L31:
            kotlin.ResultKt.b(r5)
            kotlinx.coroutines.sync.Semaphore r5 = r4.f52578g
            r0.f52582c = r3
            java.lang.Object r5 = r5.d(r0)
            if (r5 != r1) goto L3f
            return r1
        L3f:
            java.util.concurrent.locks.ReentrantLock r5 = r4.f52574c     // Catch: java.lang.Throwable -> L62
            r5.lock()     // Catch: java.lang.Throwable -> L62
            boolean r0 = r4.f52576e     // Catch: java.lang.Throwable -> L54
            if (r0 != 0) goto L64
            androidx.collection.CircularArray r0 = r4.f52579h     // Catch: java.lang.Throwable -> L54
            boolean r0 = r0.d()     // Catch: java.lang.Throwable -> L54
            if (r0 == 0) goto L56
            r4.f()     // Catch: java.lang.Throwable -> L54
            goto L56
        L54:
            r0 = move-exception
            goto L71
        L56:
            androidx.collection.CircularArray r0 = r4.f52579h     // Catch: java.lang.Throwable -> L54
            java.lang.Object r0 = r0.e()     // Catch: java.lang.Throwable -> L54
            androidx.room.coroutines.ConnectionWithLock r0 = (androidx.room.coroutines.ConnectionWithLock) r0     // Catch: java.lang.Throwable -> L54
            r5.unlock()     // Catch: java.lang.Throwable -> L62
            return r0
        L62:
            r5 = move-exception
            goto L75
        L64:
            java.lang.String r0 = "Connection pool is closed"
            r1 = 21
            androidx.sqlite.SQLite.b(r1, r0)     // Catch: java.lang.Throwable -> L54
            kotlin.KotlinNothingValueException r0 = new kotlin.KotlinNothingValueException     // Catch: java.lang.Throwable -> L54
            r0.<init>()     // Catch: java.lang.Throwable -> L54
            throw r0     // Catch: java.lang.Throwable -> L54
        L71:
            r5.unlock()     // Catch: java.lang.Throwable -> L62
            throw r0     // Catch: java.lang.Throwable -> L62
        L75:
            kotlinx.coroutines.sync.Semaphore r0 = r4.f52578g
            r0.release()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.coroutines.Pool.a(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Can't wrap try/catch for region: R(9:(2:47|12)|45|28|(1:(1:38)(2:34|(1:36)))(1:30)|37|19|43|20|(1:22)(10:23|24|45|28|(0)(0)|37|19|43|20|(0)(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0061, code lost:
    
        r2 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0066, code lost:
    
        r11 = r11;
        r10 = r10;
        r2 = r0;
        r0 = r2;
     */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0059 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x006f A[Catch: all -> 0x0073, TryCatch #1 {all -> 0x0073, blocks: (B:28:0x006b, B:30:0x006f, B:34:0x0077, B:38:0x007e), top: B:45:0x006b }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x005a -> B:24:0x005c). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object b(long r8, kotlin.jvm.functions.Function0 r10, kotlin.coroutines.Continuation r11) throws java.lang.Throwable {
        /*
            r7 = this;
            boolean r0 = r11 instanceof androidx.room.coroutines.Pool$acquireWithTimeout$1
            if (r0 == 0) goto L13
            r0 = r11
            androidx.room.coroutines.Pool$acquireWithTimeout$1 r0 = (androidx.room.coroutines.Pool$acquireWithTimeout$1) r0
            int r1 = r0.f52588g
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f52588g = r1
            goto L18
        L13:
            androidx.room.coroutines.Pool$acquireWithTimeout$1 r0 = new androidx.room.coroutines.Pool$acquireWithTimeout$1
            r0.<init>(r7, r11)
        L18:
            java.lang.Object r11 = r0.f52586d
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f52588g
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L3e
            if (r2 != r3) goto L36
            long r8 = r0.f52583a
            java.lang.Object r10 = r0.f52585c
            kotlin.jvm.internal.Ref$ObjectRef r10 = (kotlin.jvm.internal.Ref.ObjectRef) r10
            java.lang.Object r2 = r0.f52584b
            kotlin.jvm.functions.Function0 r2 = (kotlin.jvm.functions.Function0) r2
            kotlin.ResultKt.b(r11)     // Catch: java.lang.Throwable -> L34
            goto L5c
        L34:
            r11 = move-exception
            goto L66
        L36:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L3e:
            kotlin.ResultKt.b(r11)
        L41:
            kotlin.jvm.internal.Ref$ObjectRef r11 = new kotlin.jvm.internal.Ref$ObjectRef
            r11.<init>()
            androidx.room.coroutines.Pool$acquireWithTimeout$2 r2 = new androidx.room.coroutines.Pool$acquireWithTimeout$2     // Catch: java.lang.Throwable -> L61
            r2.<init>(r11, r7, r4)     // Catch: java.lang.Throwable -> L61
            r0.f52584b = r10     // Catch: java.lang.Throwable -> L61
            r0.f52585c = r11     // Catch: java.lang.Throwable -> L61
            r0.f52583a = r8     // Catch: java.lang.Throwable -> L61
            r0.f52588g = r3     // Catch: java.lang.Throwable -> L61
            java.lang.Object r2 = kotlinx.coroutines.TimeoutKt.d(r8, r2, r0)     // Catch: java.lang.Throwable -> L61
            if (r2 != r1) goto L5a
            return r1
        L5a:
            r2 = r10
            r10 = r11
        L5c:
            r11 = r10
            r10 = r2
            r2 = r0
            r0 = r4
            goto L6b
        L61:
            r2 = move-exception
            r6 = r2
            r2 = r10
            r10 = r11
            r11 = r6
        L66:
            r6 = r11
            r11 = r10
            r10 = r2
            r2 = r0
            r0 = r6
        L6b:
            boolean r5 = r0 instanceof kotlinx.coroutines.TimeoutCancellationException     // Catch: java.lang.Throwable -> L73
            if (r5 == 0) goto L75
            r10.invoke()     // Catch: java.lang.Throwable -> L73
            goto L7c
        L73:
            r8 = move-exception
            goto L7f
        L75:
            if (r0 != 0) goto L7e
            java.lang.Object r11 = r11.f140144a     // Catch: java.lang.Throwable -> L73
            if (r11 == 0) goto L7c
            return r11
        L7c:
            r0 = r2
            goto L41
        L7e:
            throw r0     // Catch: java.lang.Throwable -> L73
        L7f:
            java.lang.Object r9 = r11.f140144a
            androidx.room.coroutines.ConnectionWithLock r9 = (androidx.room.coroutines.ConnectionWithLock) r9
            if (r9 == 0) goto L88
            r7.e(r9)
        L88:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.coroutines.Pool.b(long, kotlin.jvm.functions.Function0, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void c() {
        ReentrantLock reentrantLock = this.f52574c;
        reentrantLock.lock();
        try {
            this.f52576e = true;
            for (ConnectionWithLock connectionWithLock : this.f52577f) {
                if (connectionWithLock != null) {
                    connectionWithLock.close();
                }
            }
            Unit unit = Unit.f139807a;
            reentrantLock.unlock();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public final void e(ConnectionWithLock connection) {
        Intrinsics.checkNotNullParameter(connection, "connection");
        ReentrantLock reentrantLock = this.f52574c;
        reentrantLock.lock();
        try {
            this.f52579h.a(connection);
            Unit unit = Unit.f139807a;
            reentrantLock.unlock();
            this.f52578g.release();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public final void d(StringBuilder builder) {
        String str = bfIdKSjLOVjG.DtDeMBToEnzvgQq;
        Intrinsics.checkNotNullParameter(builder, "builder");
        ReentrantLock reentrantLock = this.f52574c;
        reentrantLock.lock();
        try {
            List listCreateListBuilder = CollectionsKt.createListBuilder();
            int iF = this.f52579h.f();
            for (int i3 = 0; i3 < iF; i3++) {
                listCreateListBuilder.add(this.f52579h.c(i3));
            }
            List listBuild = CollectionsKt.build(listCreateListBuilder);
            builder.append('\t' + super.toString() + " (");
            builder.append("capacity=" + this.f52572a + str);
            builder.append("permits=" + this.f52578g.a() + str);
            builder.append("queue=(size=" + listBuild.size() + ")[" + CollectionsKt.joinToString$default(listBuild, null, null, null, 0, null, null, 63, null) + ']');
            builder.append(")");
            builder.append('\n');
            ConnectionWithLock[] connectionWithLockArr = this.f52577f;
            int length = connectionWithLockArr.length;
            int i4 = 0;
            for (int i5 = 0; i5 < length; i5++) {
                ConnectionWithLock connectionWithLock = connectionWithLockArr[i5];
                i4++;
                StringBuilder sb = new StringBuilder();
                sb.append("\t\t[");
                sb.append(i4);
                sb.append("] - ");
                sb.append(connectionWithLock != null ? connectionWithLock.toString() : null);
                builder.append(sb.toString());
                builder.append('\n');
                if (connectionWithLock != null) {
                    connectionWithLock.a(builder);
                }
            }
            Unit unit = Unit.f139807a;
            reentrantLock.unlock();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }
}
