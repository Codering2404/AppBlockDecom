package androidx.room;

import androidx.sqlite.db.SupportSQLiteStatement;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

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
public abstract class SharedSQLiteStatement {
    private final RoomDatabase database;
    private final AtomicBoolean lock;
    private final Lazy stmt$delegate;

    public SharedSQLiteStatement(RoomDatabase database) {
        Intrinsics.checkNotNullParameter(database, "database");
        this.database = database;
        this.lock = new AtomicBoolean(false);
        this.stmt$delegate = LazyKt.b(new Function0() { // from class: androidx.room.n
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return SharedSQLiteStatement.e(this.f52663a);
            }
        });
    }

    private final SupportSQLiteStatement b() {
        return this.database.compileStatement(createQuery());
    }

    private final SupportSQLiteStatement c() {
        return (SupportSQLiteStatement) this.stmt$delegate.getValue();
    }

    private final SupportSQLiteStatement d(boolean z2) {
        return z2 ? c() : b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SupportSQLiteStatement e(SharedSQLiteStatement sharedSQLiteStatement) {
        return sharedSQLiteStatement.b();
    }

    public SupportSQLiteStatement acquire() {
        assertNotMainThread();
        return d(this.lock.compareAndSet(false, true));
    }

    protected void assertNotMainThread() {
        this.database.assertNotMainThread();
    }

    protected abstract String createQuery();

    public void release(SupportSQLiteStatement statement) {
        Intrinsics.checkNotNullParameter(statement, "statement");
        if (statement == c()) {
            this.lock.set(false);
        }
    }
}
