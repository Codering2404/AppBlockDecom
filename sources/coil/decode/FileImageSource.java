package coil.decode;

import androidx.media3.extractor.jpeg.xWt.jTYhJgqLBN;
import coil.decode.ImageSource;
import coil.util.Utils;
import java.io.Closeable;
import kotlin.Metadata;
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
public final class FileImageSource extends ImageSource {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Path f55722a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final FileSystem f55723b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f55724c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Closeable f55725d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final ImageSource.Metadata f55726f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f55727g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private BufferedSource f55728h;

    public FileImageSource(Path path, FileSystem fileSystem, String str, Closeable closeable, ImageSource.Metadata metadata) {
        super(null);
        this.f55722a = path;
        this.f55723b = fileSystem;
        this.f55724c = str;
        this.f55725d = closeable;
        this.f55726f = metadata;
    }

    @Override // coil.decode.ImageSource
    public ImageSource.Metadata a() {
        return this.f55726f;
    }

    @Override // coil.decode.ImageSource
    public synchronized BufferedSource b() {
        c();
        BufferedSource bufferedSource = this.f55728h;
        if (bufferedSource != null) {
            return bufferedSource;
        }
        BufferedSource bufferedSourceD = Okio.d(i().t(this.f55722a));
        this.f55728h = bufferedSourceD;
        return bufferedSourceD;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        try {
            this.f55727g = true;
            BufferedSource bufferedSource = this.f55728h;
            if (bufferedSource != null) {
                Utils.d(bufferedSource);
            }
            Closeable closeable = this.f55725d;
            if (closeable != null) {
                Utils.d(closeable);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final String f() {
        return this.f55724c;
    }

    public FileSystem i() {
        return this.f55723b;
    }

    private final void c() {
        if (this.f55727g) {
            throw new IllegalStateException(jTYhJgqLBN.hLpxsJl);
        }
    }
}
