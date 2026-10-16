package androidx.room.coroutines;

import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteDriver;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

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
public final class PassthroughConnectionPool implements ConnectionPool {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SQLiteDriver f52563a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f52564b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Function2 f52565c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Lazy f52566d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class ConnectionElement implements CoroutineContext.Element {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Key f52567b = new Key(null);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final PassthroughConnection f52568a;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Key implements CoroutineContext.Key<ConnectionElement> {
            public /* synthetic */ Key(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Key() {
            }
        }

        public ConnectionElement(PassthroughConnection connectionWrapper) {
            Intrinsics.checkNotNullParameter(connectionWrapper, "connectionWrapper");
            this.f52568a = connectionWrapper;
        }

        public final PassthroughConnection d() {
            return this.f52568a;
        }

        @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
        public Object fold(Object obj, Function2 function2) {
            return CoroutineContext.Element.DefaultImpls.a(this, obj, function2);
        }

        @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
        public CoroutineContext.Element get(CoroutineContext.Key key) {
            return CoroutineContext.Element.DefaultImpls.b(this, key);
        }

        @Override // kotlin.coroutines.CoroutineContext.Element
        public CoroutineContext.Key getKey() {
            return f52567b;
        }

        @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
        public CoroutineContext minusKey(CoroutineContext.Key key) {
            return CoroutineContext.Element.DefaultImpls.c(this, key);
        }

        @Override // kotlin.coroutines.CoroutineContext
        public CoroutineContext plus(CoroutineContext coroutineContext) {
            return CoroutineContext.Element.DefaultImpls.d(this, coroutineContext);
        }
    }

    public PassthroughConnectionPool(SQLiteDriver driver, String fileName, Function2 function2) {
        Intrinsics.checkNotNullParameter(driver, "driver");
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        this.f52563a = driver;
        this.f52564b = fileName;
        this.f52565c = function2;
        this.f52566d = LazyKt.b(new Function0() { // from class: androidx.room.coroutines.e
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return PassthroughConnectionPool.b(this.f52650a);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SQLiteConnection b(PassthroughConnectionPool passthroughConnectionPool) {
        return passthroughConnectionPool.f52563a.a(passthroughConnectionPool.f52564b);
    }

    @Override // androidx.room.coroutines.ConnectionPool, java.lang.AutoCloseable
    public void close() {
        if (this.f52566d.isInitialized()) {
            ((SQLiteConnection) this.f52566d.getValue()).close();
        }
    }

    @Override // androidx.room.coroutines.ConnectionPool
    public Object h0(boolean z2, Function2 function2, Continuation continuation) {
        ConnectionElement connectionElement = (ConnectionElement) continuation.getContext().get(ConnectionElement.f52567b);
        PassthroughConnection passthroughConnectionD = connectionElement != null ? connectionElement.d() : null;
        if (passthroughConnectionD != null) {
            return function2.invoke(passthroughConnectionD, continuation);
        }
        PassthroughConnection passthroughConnection = new PassthroughConnection(this.f52565c, (SQLiteConnection) this.f52566d.getValue());
        return BuildersKt.g(new ConnectionElement(passthroughConnection), new PassthroughConnectionPool$useConnection$2(function2, passthroughConnection, null), continuation);
    }
}
