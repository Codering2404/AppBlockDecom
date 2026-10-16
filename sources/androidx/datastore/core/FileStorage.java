package androidx.datastore.core;

import androidx.datastore.core.FileStorage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
public final class FileStorage<T> implements Storage<T> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Companion f35698d = new Companion(null);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Set f35699e = new LinkedHashSet();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Object f35700f = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Serializer f35701a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Function1 f35702b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Function0 f35703c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Set a() {
            return FileStorage.f35699e;
        }

        public final Object b() {
            return FileStorage.f35700f;
        }

        private Companion() {
        }
    }

    public FileStorage(Serializer serializer, Function1 coordinatorProducer, Function0 produceFile) {
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        Intrinsics.checkNotNullParameter(coordinatorProducer, "coordinatorProducer");
        Intrinsics.checkNotNullParameter(produceFile, "produceFile");
        this.f35701a = serializer;
        this.f35702b = coordinatorProducer;
        this.f35703c = produceFile;
    }

    @Override // androidx.datastore.core.Storage
    public StorageConnection a() throws IOException {
        final File file = ((File) this.f35703c.invoke()).getCanonicalFile();
        synchronized (f35700f) {
            String path = file.getAbsolutePath();
            Set set = f35699e;
            if (set.contains(path)) {
                throw new IllegalStateException(("There are multiple DataStores active for the same file: " + path + ". You should either maintain your DataStore as a singleton or confirm that there is no two DataStore's active on the same file (by confirming that the scope is cancelled).").toString());
            }
            Intrinsics.checkNotNullExpressionValue(path, "path");
            set.add(path);
        }
        Intrinsics.checkNotNullExpressionValue(file, "file");
        return new FileStorageConnection(file, this.f35701a, (InterProcessCoordinator) this.f35702b.invoke(file), new Function0<Unit>() { // from class: androidx.datastore.core.FileStorage$createConnection$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m342invoke();
                return Unit.f139807a;
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m342invoke() {
                FileStorage.Companion companion = FileStorage.f35698d;
                Object objB = companion.b();
                File file2 = file;
                synchronized (objB) {
                    companion.a().remove(file2.getAbsolutePath());
                    Unit unit = Unit.f139807a;
                }
            }
        });
    }

    public /* synthetic */ FileStorage(Serializer serializer, Function1 function1, Function0 function0, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(serializer, (i3 & 2) != 0 ? new Function1<File, InterProcessCoordinator>() { // from class: androidx.datastore.core.FileStorage.1
            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final InterProcessCoordinator invoke(File it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return InterProcessCoordinator_jvmKt.a(it);
            }
        } : function1, function0);
    }
}
