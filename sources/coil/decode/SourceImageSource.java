package coil.decode;

import coil.decode.ImageSource;
import coil.util.Utils;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import okio.BufferedSource;
import okio.FileSystem;
import okio.Okio;
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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class SourceImageSource extends ImageSource {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ImageSource.Metadata f55736a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f55737b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private BufferedSource f55738c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Function0 f55739d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Path f55740f;

    public SourceImageSource(BufferedSource bufferedSource, Function0 function0, ImageSource.Metadata metadata) {
        super(null);
        this.f55736a = metadata;
        this.f55738c = bufferedSource;
        this.f55739d = function0;
    }

    private final void c() {
        if (this.f55737b) {
            throw new IllegalStateException("closed");
        }
    }

    @Override // coil.decode.ImageSource
    public ImageSource.Metadata a() {
        return this.f55736a;
    }

    @Override // coil.decode.ImageSource
    public synchronized BufferedSource b() {
        c();
        BufferedSource bufferedSource = this.f55738c;
        if (bufferedSource != null) {
            return bufferedSource;
        }
        FileSystem fileSystemF = f();
        Path path = this.f55740f;
        Intrinsics.checkNotNull(path);
        BufferedSource bufferedSourceD = Okio.d(fileSystemF.t(path));
        this.f55738c = bufferedSourceD;
        return bufferedSourceD;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        try {
            this.f55737b = true;
            BufferedSource bufferedSource = this.f55738c;
            if (bufferedSource != null) {
                Utils.d(bufferedSource);
            }
            Path path = this.f55740f;
            if (path != null) {
                f().h(path);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public FileSystem f() {
        return FileSystem.f145034b;
    }
}
