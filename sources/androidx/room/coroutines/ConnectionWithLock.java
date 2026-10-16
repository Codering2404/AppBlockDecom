package androidx.room.coroutines;

import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import java.util.Iterator;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

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
final class ConnectionWithLock implements SQLiteConnection, Mutex {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SQLiteConnection f52524a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Mutex f52525b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private CoroutineContext f52526c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Throwable f52527d;

    public ConnectionWithLock(SQLiteConnection delegate, Mutex lock) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        Intrinsics.checkNotNullParameter(lock, "lock");
        this.f52524a = delegate;
        this.f52525b = lock;
    }

    @Override // androidx.sqlite.SQLiteConnection
    public boolean E() {
        return this.f52524a.E();
    }

    @Override // androidx.sqlite.SQLiteConnection
    public SQLiteStatement G2(String sql) {
        Intrinsics.checkNotNullParameter(sql, "sql");
        return this.f52524a.G2(sql);
    }

    public final void a(StringBuilder builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        if (this.f52526c == null && this.f52527d == null) {
            builder.append("\t\tStatus: Free connection");
            builder.append('\n');
            return;
        }
        builder.append("\t\tStatus: Acquired connection");
        builder.append('\n');
        CoroutineContext coroutineContext = this.f52526c;
        if (coroutineContext != null) {
            builder.append("\t\tCoroutine: " + coroutineContext);
            builder.append('\n');
        }
        Throwable th = this.f52527d;
        if (th != null) {
            builder.append("\t\tAcquired:");
            builder.append('\n');
            Iterator it = CollectionsKt.drop(StringsKt.x0(ExceptionsKt.b(th)), 1).iterator();
            while (it.hasNext()) {
                builder.append("\t\t" + ((String) it.next()));
                builder.append('\n');
            }
        }
    }

    @Override // kotlinx.coroutines.sync.Mutex
    public boolean b(Object obj) {
        return this.f52525b.b(obj);
    }

    @Override // kotlinx.coroutines.sync.Mutex
    public boolean c() {
        return this.f52525b.c();
    }

    @Override // androidx.sqlite.SQLiteConnection, java.lang.AutoCloseable
    public void close() {
        this.f52524a.close();
    }

    @Override // kotlinx.coroutines.sync.Mutex
    public Object f(Object obj, Continuation continuation) {
        return this.f52525b.f(obj, continuation);
    }

    @Override // kotlinx.coroutines.sync.Mutex
    public void i(Object obj) {
        this.f52525b.i(obj);
    }

    public final ConnectionWithLock j(CoroutineContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f52526c = context;
        this.f52527d = new Throwable();
        return this;
    }

    public final ConnectionWithLock k() {
        this.f52526c = null;
        this.f52527d = null;
        return this;
    }

    public String toString() {
        return this.f52524a.toString();
    }

    public /* synthetic */ ConnectionWithLock(SQLiteConnection sQLiteConnection, Mutex mutex, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(sQLiteConnection, (i3 & 2) != 0 ? MutexKt.b(false, 1, null) : mutex);
    }
}
