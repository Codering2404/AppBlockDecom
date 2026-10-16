package coil.disk;

import android.os.StatFs;
import java.io.Closeable;
import java.io.File;
import kotlin.Metadata;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;
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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public interface DiskCache {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Path f55749a;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private long f55754f;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private FileSystem f55750b = FileSystem.f145034b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private double f55751c = 0.02d;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private long f55752d = 10485760;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private long f55753e = 262144000;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private CoroutineDispatcher f55755g = Dispatchers.b();

        public final DiskCache a() {
            long jR;
            Path path = this.f55749a;
            if (path == null) {
                throw new IllegalStateException("directory == null");
            }
            if (this.f55751c > 0.0d) {
                try {
                    File file = path.toFile();
                    file.mkdir();
                    StatFs statFs = new StatFs(file.getAbsolutePath());
                    jR = RangesKt.r((long) (this.f55751c * statFs.getBlockCountLong() * statFs.getBlockSizeLong()), this.f55752d, this.f55753e);
                } catch (Exception unused) {
                    jR = this.f55752d;
                }
            } else {
                jR = this.f55754f;
            }
            return new RealDiskCache(jR, path, this.f55750b, this.f55755g);
        }

        public final Builder b(File file) {
            return c(Path.Companion.d(Path.f145073b, file, false, 1, null));
        }

        public final Builder c(Path path) {
            this.f55749a = path;
            return this;
        }

        public final Builder d(long j3) {
            if (j3 <= 0) {
                throw new IllegalArgumentException("size must be > 0.");
            }
            this.f55751c = 0.0d;
            this.f55754f = j3;
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public interface Editor {
        Snapshot a();

        void abort();

        Path getData();

        Path o();
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public interface Snapshot extends Closeable {
        Editor P1();

        Path getData();

        Path o();
    }

    Editor a(String str);

    Snapshot b(String str);

    FileSystem getFileSystem();
}
