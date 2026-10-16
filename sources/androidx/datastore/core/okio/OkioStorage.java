package androidx.datastore.core.okio;

import androidx.datastore.core.InterProcessCoordinator;
import androidx.datastore.core.Storage;
import androidx.datastore.core.StorageConnection;
import androidx.datastore.core.okio.OkioStorage;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okio.FileSystem;
import okio.Path;

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
public final class OkioStorage<T> implements Storage<T> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Companion f35852f = new Companion(null);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final Set f35853g = new LinkedHashSet();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final Synchronizer f35854h = new Synchronizer();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final FileSystem f35855a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final OkioSerializer f35856b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Function2 f35857c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Function0 f35858d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Lazy f35859e;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Set a() {
            return OkioStorage.f35853g;
        }

        public final Synchronizer b() {
            return OkioStorage.f35854h;
        }

        private Companion() {
        }
    }

    public OkioStorage(FileSystem fileSystem, OkioSerializer serializer, Function2 coordinatorProducer, Function0 producePath) {
        Intrinsics.checkNotNullParameter(fileSystem, "fileSystem");
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        Intrinsics.checkNotNullParameter(coordinatorProducer, "coordinatorProducer");
        Intrinsics.checkNotNullParameter(producePath, "producePath");
        this.f35855a = fileSystem;
        this.f35856b = serializer;
        this.f35857c = coordinatorProducer;
        this.f35858d = producePath;
        this.f35859e = LazyKt.b(new Function0<Path>() { // from class: androidx.datastore.core.okio.OkioStorage$canonicalPath$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final Path invoke() {
                Path path = (Path) this.f35861a.f35858d.invoke();
                boolean zIsAbsolute = path.isAbsolute();
                OkioStorage okioStorage = this.f35861a;
                if (zIsAbsolute) {
                    return path.g();
                }
                throw new IllegalStateException(("OkioStorage requires absolute paths, but did not get an absolute path from producePath = " + okioStorage.f35858d + ", instead got " + path).toString());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Path f() {
        return (Path) this.f35859e.getValue();
    }

    @Override // androidx.datastore.core.Storage
    public StorageConnection a() {
        String string = f().toString();
        synchronized (f35854h) {
            Set set = f35853g;
            if (set.contains(string)) {
                throw new IllegalStateException(("There are multiple DataStores active for the same file: " + string + ". You should either maintain your DataStore as a singleton or confirm that there is no two DataStore's active on the same file (by confirming that the scope is cancelled).").toString());
            }
            set.add(string);
        }
        return new OkioStorageConnection(this.f35855a, f(), this.f35856b, (InterProcessCoordinator) this.f35857c.invoke(f(), this.f35855a), new Function0<Unit>() { // from class: androidx.datastore.core.okio.OkioStorage$createConnection$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m344invoke();
                return Unit.f139807a;
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m344invoke() {
                OkioStorage.Companion companion = OkioStorage.f35852f;
                Synchronizer synchronizerB = companion.b();
                OkioStorage okioStorage = this.f35862a;
                synchronized (synchronizerB) {
                    companion.a().remove(okioStorage.f().toString());
                    Unit unit = Unit.f139807a;
                }
            }
        });
    }

    public /* synthetic */ OkioStorage(FileSystem fileSystem, OkioSerializer okioSerializer, Function2 function2, Function0 function0, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(fileSystem, okioSerializer, (i3 & 4) != 0 ? new Function2<Path, FileSystem, InterProcessCoordinator>() { // from class: androidx.datastore.core.okio.OkioStorage.1
            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final InterProcessCoordinator invoke(Path path, FileSystem fileSystem2) {
                Intrinsics.checkNotNullParameter(path, "path");
                Intrinsics.checkNotNullParameter(fileSystem2, "<anonymous parameter 1>");
                return OkioStorageKt.a(path);
            }
        } : function2, function0);
    }
}
