package androidx.datastore.core.okio;

import androidx.datastore.core.ReadScope;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public class OkioReadScope<T> implements ReadScope<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final FileSystem f35843a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Path f35844b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final OkioSerializer f35845c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final AtomicBoolean f35846d;

    public OkioReadScope(FileSystem fileSystem, Path path, OkioSerializer serializer) {
        Intrinsics.checkNotNullParameter(fileSystem, "fileSystem");
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        this.f35843a = fileSystem;
        this.f35844b = path;
        this.f35845c = serializer;
        this.f35846d = new AtomicBoolean(false);
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0090 A[Catch: FileNotFoundException -> 0x008a, TryCatch #8 {FileNotFoundException -> 0x008a, blocks: (B:46:0x0090, B:47:0x0094, B:42:0x0086, B:39:0x0081), top: B:82:0x0081, inners: #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0094 A[Catch: FileNotFoundException -> 0x008a, TRY_LEAVE, TryCatch #8 {FileNotFoundException -> 0x008a, blocks: (B:46:0x0090, B:47:0x0094, B:42:0x0086, B:39:0x0081), top: B:82:0x0081, inners: #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00bf A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0081 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0072 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00cb A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static /* synthetic */ java.lang.Object j(androidx.datastore.core.okio.OkioReadScope r7, kotlin.coroutines.Continuation r8) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 229
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.okio.OkioReadScope.j(androidx.datastore.core.okio.OkioReadScope, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // androidx.datastore.core.ReadScope
    public Object c(Continuation continuation) {
        return j(this, continuation);
    }

    @Override // androidx.datastore.core.Closeable
    public void close() {
        this.f35846d.b(true);
    }

    protected final void f() {
        if (this.f35846d.a()) {
            throw new IllegalStateException("This scope has already been closed.");
        }
    }

    protected final FileSystem g() {
        return this.f35843a;
    }

    protected final Path h() {
        return this.f35844b;
    }

    protected final OkioSerializer i() {
        return this.f35845c;
    }
}
