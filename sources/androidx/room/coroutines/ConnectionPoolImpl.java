package androidx.room.coroutines;

import android.database.SQLException;
import androidx.compose.animation.core.Xrg.muQRKXGtpOhe;
import androidx.room.concurrent.ThreadLocal_jvmAndroidKt;
import androidx.sqlite.SQLite;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteDriver;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;

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
public final class ConnectionPoolImpl implements ConnectionPool {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SQLiteDriver f52500a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Pool f52501b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Pool f52502c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ConnectionElementKey f52503d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final ThreadLocal f52504f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final AtomicBoolean f52505g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f52506h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f52507i;

    public ConnectionPoolImpl(final SQLiteDriver driver, final String fileName) {
        Intrinsics.checkNotNullParameter(driver, "driver");
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        this.f52503d = new ConnectionElementKey();
        this.f52504f = new ThreadLocal();
        this.f52505g = new AtomicBoolean(false);
        Duration.Companion companion = Duration.f140631b;
        this.f52506h = DurationKt.s(30, DurationUnit.f140641f);
        this.f52507i = 2;
        this.f52500a = driver;
        Pool pool = new Pool(1, new Function0() { // from class: androidx.room.coroutines.d
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ConnectionPoolImpl.i(driver, fileName);
            }
        });
        this.f52501b = pool;
        this.f52502c = pool;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SQLiteConnection i(SQLiteDriver sQLiteDriver, String str) {
        return sQLiteDriver.a(str);
    }

    private final boolean isClosed() {
        return this.f52505g.get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SQLiteConnection j(SQLiteDriver sQLiteDriver, String str) throws Exception {
        SQLiteConnection sQLiteConnectionA = sQLiteDriver.a(str);
        SQLite.a(sQLiteConnectionA, "PRAGMA query_only = 1");
        return sQLiteConnectionA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SQLiteConnection k(SQLiteDriver sQLiteDriver, String str) {
        return sQLiteDriver.a(str);
    }

    private final CoroutineContext l(PooledConnectionImpl pooledConnectionImpl) {
        return new ConnectionElement(this.f52503d, pooledConnectionImpl).plus(ThreadLocal_jvmAndroidKt.a(this.f52504f, pooledConnectionImpl));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n(ConnectionPoolImpl connectionPoolImpl, boolean z2) {
        connectionPoolImpl.m(z2);
        return Unit.f139807a;
    }

    @Override // androidx.room.coroutines.ConnectionPool, java.lang.AutoCloseable
    public void close() {
        if (this.f52505g.compareAndSet(false, true)) {
            this.f52501b.c();
            this.f52502c.c();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:71:0x013e A[Catch: all -> 0x0178, TRY_LEAVE, TryCatch #3 {all -> 0x0178, blocks: (B:64:0x0123, B:69:0x0133, B:71:0x013e, B:81:0x017c, B:82:0x0183), top: B:103:0x0123 }] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0166  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001b  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x017c A[Catch: all -> 0x0178, TRY_ENTER, TryCatch #3 {all -> 0x0178, blocks: (B:64:0x0123, B:69:0x0133, B:71:0x013e, B:81:0x017c, B:82:0x0183), top: B:103:0x0123 }] */
    @Override // androidx.room.coroutines.ConnectionPool
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object h0(boolean r18, kotlin.jvm.functions.Function2 r19, kotlin.coroutines.Continuation r20) throws java.lang.Exception {
        /*
            Method dump skipped, instruction units count: 436
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.coroutines.ConnectionPoolImpl.h0(boolean, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final void m(boolean z2) {
        String str = z2 ? muQRKXGtpOhe.CYTGbVRM : "writer";
        StringBuilder sb = new StringBuilder();
        sb.append("Timed out attempting to acquire a " + str + " connection.");
        sb.append('\n');
        sb.append('\n');
        sb.append("Writer pool:");
        sb.append('\n');
        this.f52502c.d(sb);
        sb.append("Reader pool:");
        sb.append('\n');
        this.f52501b.d(sb);
        try {
            SQLite.b(5, sb.toString());
            throw new KotlinNothingValueException();
        } catch (SQLException e3) {
            int i3 = this.f52507i;
            if (i3 == 1) {
                throw e3;
            }
            if (i3 != 2) {
                return;
            }
            e3.printStackTrace();
        }
    }

    public ConnectionPoolImpl(final SQLiteDriver driver, final String fileName, int i3, int i4) {
        Intrinsics.checkNotNullParameter(driver, "driver");
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        this.f52503d = new ConnectionElementKey();
        this.f52504f = new ThreadLocal();
        this.f52505g = new AtomicBoolean(false);
        Duration.Companion companion = Duration.f140631b;
        this.f52506h = DurationKt.s(30, DurationUnit.f140641f);
        this.f52507i = 2;
        if (i3 <= 0) {
            throw new IllegalArgumentException("Maximum number of readers must be greater than 0");
        }
        if (i4 > 0) {
            this.f52500a = driver;
            this.f52501b = new Pool(i3, new Function0() { // from class: androidx.room.coroutines.b
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ConnectionPoolImpl.j(driver, fileName);
                }
            });
            this.f52502c = new Pool(i4, new Function0() { // from class: androidx.room.coroutines.c
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ConnectionPoolImpl.k(driver, fileName);
                }
            });
            return;
        }
        throw new IllegalArgumentException("Maximum number of writers must be greater than 0");
    }
}
