package okhttp3.internal.connection;

import java.lang.ref.Reference;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.Util;
import okhttp3.internal.concurrent.Task;
import okhttp3.internal.concurrent.TaskQueue;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.connection.RealCall;
import okhttp3.internal.platform.Platform;

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
/* JADX INFO: loaded from: classes9.dex */
@Metadata
public final class RealConnectionPool {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Companion f144491f = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f144492a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f144493b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final TaskQueue f144494c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final RealConnectionPool$cleanupTask$1 f144495d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ConcurrentLinkedQueue f144496e;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: Type inference failed for: r4v2, types: [okhttp3.internal.connection.RealConnectionPool$cleanupTask$1] */
    public RealConnectionPool(TaskRunner taskRunner, int i3, long j3, TimeUnit timeUnit) {
        Intrinsics.checkNotNullParameter(taskRunner, "taskRunner");
        Intrinsics.checkNotNullParameter(timeUnit, "timeUnit");
        this.f144492a = i3;
        this.f144493b = timeUnit.toNanos(j3);
        this.f144494c = taskRunner.i();
        final String strStringPlus = Intrinsics.stringPlus(Util.f144282i, " ConnectionPool");
        this.f144495d = new Task(strStringPlus) { // from class: okhttp3.internal.connection.RealConnectionPool$cleanupTask$1
            @Override // okhttp3.internal.concurrent.Task
            public long f() {
                return this.f144497e.b(System.nanoTime());
            }
        };
        this.f144496e = new ConcurrentLinkedQueue();
        if (j3 <= 0) {
            throw new IllegalArgumentException(Intrinsics.stringPlus("keepAliveDuration <= 0: ", Long.valueOf(j3)).toString());
        }
    }

    private final int d(RealConnection realConnection, long j3) {
        if (Util.f144281h && !Thread.holdsLock(realConnection)) {
            throw new AssertionError("Thread " + ((Object) Thread.currentThread().getName()) + " MUST hold lock on " + realConnection);
        }
        List listO = realConnection.o();
        int i3 = 0;
        while (i3 < listO.size()) {
            Reference reference = (Reference) listO.get(i3);
            if (reference.get() != null) {
                i3++;
            } else {
                Platform.f144818a.g().m("A connection to " + realConnection.B().a().l() + " was leaked. Did you forget to close a response body?", ((RealCall.CallReference) reference).a());
                listO.remove(i3);
                realConnection.E(true);
                if (listO.isEmpty()) {
                    realConnection.D(j3 - this.f144493b);
                    return 0;
                }
            }
        }
        return listO.size();
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x002d A[Catch: all -> 0x002b, TryCatch #0 {all -> 0x002b, blocks: (B:8:0x0024, B:15:0x0033, B:13:0x002d, B:18:0x0037), top: B:26:0x0024 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean a(okhttp3.Address r4, okhttp3.internal.connection.RealCall r5, java.util.List r6, boolean r7) {
        /*
            r3 = this;
            java.lang.String r0 = "address"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "call"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.util.concurrent.ConcurrentLinkedQueue r0 = r3.f144496e
            java.util.Iterator r0 = r0.iterator()
        L10:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L3f
            java.lang.Object r1 = r0.next()
            okhttp3.internal.connection.RealConnection r1 = (okhttp3.internal.connection.RealConnection) r1
            java.lang.String r2 = "connection"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            monitor-enter(r1)
            if (r7 == 0) goto L2d
            boolean r2 = r1.w()     // Catch: java.lang.Throwable -> L2b
            if (r2 != 0) goto L2d
            goto L33
        L2b:
            r4 = move-exception
            goto L3d
        L2d:
            boolean r2 = r1.u(r4, r6)     // Catch: java.lang.Throwable -> L2b
            if (r2 != 0) goto L37
        L33:
            kotlin.Unit r2 = kotlin.Unit.f139807a     // Catch: java.lang.Throwable -> L2b
            monitor-exit(r1)
            goto L10
        L37:
            r5.c(r1)     // Catch: java.lang.Throwable -> L2b
            monitor-exit(r1)
            r4 = 1
            return r4
        L3d:
            monitor-exit(r1)
            throw r4
        L3f:
            r4 = 0
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.RealConnectionPool.a(okhttp3.Address, okhttp3.internal.connection.RealCall, java.util.List, boolean):boolean");
    }

    public final long b(long j3) {
        int i3 = 0;
        long j4 = Long.MIN_VALUE;
        RealConnection realConnection = null;
        int i4 = 0;
        for (RealConnection connection : this.f144496e) {
            Intrinsics.checkNotNullExpressionValue(connection, "connection");
            synchronized (connection) {
                if (d(connection, j3) > 0) {
                    i4++;
                } else {
                    i3++;
                    long jP = j3 - connection.p();
                    if (jP > j4) {
                        realConnection = connection;
                        j4 = jP;
                    }
                    Unit unit = Unit.f139807a;
                }
            }
        }
        long j5 = this.f144493b;
        if (j4 < j5 && i3 <= this.f144492a) {
            if (i3 > 0) {
                return j5 - j4;
            }
            if (i4 > 0) {
                return j5;
            }
            return -1L;
        }
        Intrinsics.checkNotNull(realConnection);
        synchronized (realConnection) {
            if (!realConnection.o().isEmpty()) {
                return 0L;
            }
            if (realConnection.p() + j4 != j3) {
                return 0L;
            }
            realConnection.E(true);
            this.f144496e.remove(realConnection);
            Util.n(realConnection.F());
            if (this.f144496e.isEmpty()) {
                this.f144494c.a();
            }
            return 0L;
        }
    }

    public final boolean c(RealConnection connection) {
        Intrinsics.checkNotNullParameter(connection, "connection");
        if (Util.f144281h && !Thread.holdsLock(connection)) {
            throw new AssertionError("Thread " + ((Object) Thread.currentThread().getName()) + " MUST hold lock on " + connection);
        }
        if (!connection.q() && this.f144492a != 0) {
            TaskQueue.j(this.f144494c, this.f144495d, 0L, 2, null);
            return false;
        }
        connection.E(true);
        this.f144496e.remove(connection);
        if (this.f144496e.isEmpty()) {
            this.f144494c.a();
        }
        return true;
    }

    public final void e(RealConnection connection) {
        Intrinsics.checkNotNullParameter(connection, "connection");
        if (!Util.f144281h || Thread.holdsLock(connection)) {
            this.f144496e.add(connection);
            TaskQueue.j(this.f144494c, this.f144495d, 0L, 2, null);
            return;
        }
        throw new AssertionError("Thread " + ((Object) Thread.currentThread().getName()) + " MUST hold lock on " + connection);
    }
}
