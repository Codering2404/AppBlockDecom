package coil.disk;

import coil.disk.DiskCache;
import coil.disk.DiskLruCache;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineDispatcher;
import okio.ByteString;
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
public final class RealDiskCache implements DiskCache {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Companion f55797e = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f55798a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Path f55799b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final FileSystem f55800c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final DiskLruCache f55801d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class RealEditor implements DiskCache.Editor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final DiskLruCache.Editor f55802a;

        public RealEditor(DiskLruCache.Editor editor) {
            this.f55802a = editor;
        }

        @Override // coil.disk.DiskCache.Editor
        public void abort() {
            this.f55802a.a();
        }

        @Override // coil.disk.DiskCache.Editor
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public RealSnapshot a() {
            DiskLruCache.Snapshot snapshotC = this.f55802a.c();
            if (snapshotC != null) {
                return new RealSnapshot(snapshotC);
            }
            return null;
        }

        @Override // coil.disk.DiskCache.Editor
        public Path getData() {
            return this.f55802a.f(1);
        }

        @Override // coil.disk.DiskCache.Editor
        public Path o() {
            return this.f55802a.f(0);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class RealSnapshot implements DiskCache.Snapshot {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final DiskLruCache.Snapshot f55803a;

        public RealSnapshot(DiskLruCache.Snapshot snapshot) {
            this.f55803a = snapshot;
        }

        @Override // coil.disk.DiskCache.Snapshot
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public RealEditor P1() {
            DiskLruCache.Editor editorA = this.f55803a.a();
            if (editorA != null) {
                return new RealEditor(editorA);
            }
            return null;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.f55803a.close();
        }

        @Override // coil.disk.DiskCache.Snapshot
        public Path getData() {
            return this.f55803a.b(1);
        }

        @Override // coil.disk.DiskCache.Snapshot
        public Path o() {
            return this.f55803a.b(0);
        }
    }

    public RealDiskCache(long j3, Path path, FileSystem fileSystem, CoroutineDispatcher coroutineDispatcher) {
        this.f55798a = j3;
        this.f55799b = path;
        this.f55800c = fileSystem;
        this.f55801d = new DiskLruCache(getFileSystem(), c(), coroutineDispatcher, d(), 1, 2);
    }

    private final String e(String str) {
        return ByteString.f144997d.d(str).B().l();
    }

    @Override // coil.disk.DiskCache
    public DiskCache.Editor a(String str) {
        DiskLruCache.Editor editorM = this.f55801d.M(e(str));
        if (editorM != null) {
            return new RealEditor(editorM);
        }
        return null;
    }

    @Override // coil.disk.DiskCache
    public DiskCache.Snapshot b(String str) {
        DiskLruCache.Snapshot snapshotN = this.f55801d.N(e(str));
        if (snapshotN != null) {
            return new RealSnapshot(snapshotN);
        }
        return null;
    }

    public Path c() {
        return this.f55799b;
    }

    public long d() {
        return this.f55798a;
    }

    @Override // coil.disk.DiskCache
    public FileSystem getFileSystem() {
        return this.f55800c;
    }
}
