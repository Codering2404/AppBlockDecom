package okio;

import com.google.android.material.bottomsheet.lKiE.YznnJpHcAmeoW;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.zip.Inflater;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okio.Path;
import okio.internal.FixedLengthSource;
import okio.internal.ZipEntry;
import okio.internal.ZipFilesKt;

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
/* JADX INFO: loaded from: classes9.dex */
@Metadata
public final class ZipFileSystem extends FileSystem {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final Companion f145132i = new Companion(null);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final Path f145133j = Path.Companion.e(Path.f145073b, YznnJpHcAmeoW.gmsLkBTkp, false, 1, null);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Path f145134e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final FileSystem f145135f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Map f145136g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final String f145137h;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public ZipFileSystem(Path zipPath, FileSystem fileSystem, Map entries, String str) {
        Intrinsics.checkNotNullParameter(zipPath, "zipPath");
        Intrinsics.checkNotNullParameter(fileSystem, "fileSystem");
        Intrinsics.checkNotNullParameter(entries, "entries");
        this.f145134e = zipPath;
        this.f145135f = fileSystem;
        this.f145136g = entries;
        this.f145137h = str;
    }

    private final Path u(Path path) {
        return f145133j.l(path, true);
    }

    private final List v(Path path, boolean z2) throws IOException {
        ZipEntry zipEntry = (ZipEntry) this.f145136g.get(u(path));
        if (zipEntry != null) {
            return CollectionsKt.toList(zipEntry.b());
        }
        if (!z2) {
            return null;
        }
        throw new IOException("not a directory: " + path);
    }

    @Override // okio.FileSystem
    public Sink b(Path file, boolean z2) throws IOException {
        Intrinsics.checkNotNullParameter(file, "file");
        throw new IOException("zip file systems are read-only");
    }

    @Override // okio.FileSystem
    public void c(Path source, Path target) throws IOException {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(target, "target");
        throw new IOException("zip file systems are read-only");
    }

    @Override // okio.FileSystem
    public void g(Path dir, boolean z2) throws IOException {
        Intrinsics.checkNotNullParameter(dir, "dir");
        throw new IOException("zip file systems are read-only");
    }

    @Override // okio.FileSystem
    public void i(Path path, boolean z2) throws IOException {
        Intrinsics.checkNotNullParameter(path, "path");
        throw new IOException("zip file systems are read-only");
    }

    @Override // okio.FileSystem
    public List k(Path dir) throws IOException {
        Intrinsics.checkNotNullParameter(dir, "dir");
        List listV = v(dir, true);
        Intrinsics.checkNotNull(listV);
        return listV;
    }

    @Override // okio.FileSystem
    public List l(Path dir) {
        Intrinsics.checkNotNullParameter(dir, "dir");
        return v(dir, false);
    }

    @Override // okio.FileSystem
    public FileMetadata n(Path path) throws Throwable {
        BufferedSource bufferedSourceD;
        Intrinsics.checkNotNullParameter(path, "path");
        ZipEntry zipEntry = (ZipEntry) this.f145136g.get(u(path));
        Throwable th = null;
        if (zipEntry == null) {
            return null;
        }
        FileMetadata fileMetadata = new FileMetadata(!zipEntry.h(), zipEntry.h(), null, zipEntry.h() ? null : Long.valueOf(zipEntry.g()), null, zipEntry.e(), null, null, ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD, null);
        if (zipEntry.f() == -1) {
            return fileMetadata;
        }
        FileHandle fileHandleO = this.f145135f.o(this.f145134e);
        try {
            bufferedSourceD = Okio.d(fileHandleO.J(zipEntry.f()));
            if (fileHandleO != null) {
                try {
                    fileHandleO.close();
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        } catch (Throwable th3) {
            if (fileHandleO != null) {
                try {
                    fileHandleO.close();
                } catch (Throwable th4) {
                    ExceptionsKt.a(th3, th4);
                }
            }
            th = th3;
            bufferedSourceD = null;
        }
        if (th != null) {
            throw th;
        }
        Intrinsics.checkNotNull(bufferedSourceD);
        return ZipFilesKt.h(bufferedSourceD, fileMetadata);
    }

    @Override // okio.FileSystem
    public FileHandle o(Path file) {
        Intrinsics.checkNotNullParameter(file, "file");
        throw new UnsupportedOperationException("not implemented yet!");
    }

    @Override // okio.FileSystem
    public FileHandle q(Path file, boolean z2, boolean z3) throws IOException {
        Intrinsics.checkNotNullParameter(file, "file");
        throw new IOException("zip entries are not writable");
    }

    @Override // okio.FileSystem
    public Sink s(Path file, boolean z2) throws IOException {
        Intrinsics.checkNotNullParameter(file, "file");
        throw new IOException("zip file systems are read-only");
    }

    @Override // okio.FileSystem
    public Source t(Path file) throws Throwable {
        BufferedSource bufferedSourceD;
        Intrinsics.checkNotNullParameter(file, "file");
        ZipEntry zipEntry = (ZipEntry) this.f145136g.get(u(file));
        if (zipEntry == null) {
            throw new FileNotFoundException("no such file: " + file);
        }
        FileHandle fileHandleO = this.f145135f.o(this.f145134e);
        Throwable th = null;
        try {
            bufferedSourceD = Okio.d(fileHandleO.J(zipEntry.f()));
            if (fileHandleO != null) {
                try {
                    fileHandleO.close();
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        } catch (Throwable th3) {
            if (fileHandleO != null) {
                try {
                    fileHandleO.close();
                } catch (Throwable th4) {
                    ExceptionsKt.a(th3, th4);
                }
            }
            bufferedSourceD = null;
            th = th3;
        }
        if (th != null) {
            throw th;
        }
        Intrinsics.checkNotNull(bufferedSourceD);
        ZipFilesKt.k(bufferedSourceD);
        return zipEntry.d() == 0 ? new FixedLengthSource(bufferedSourceD, zipEntry.g(), true) : new FixedLengthSource(new InflaterSource(new FixedLengthSource(bufferedSourceD, zipEntry.c(), true), new Inflater(true)), zipEntry.g(), false);
    }
}
