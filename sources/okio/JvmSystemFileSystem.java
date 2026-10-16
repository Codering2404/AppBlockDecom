package okio;

import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
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
/* JADX INFO: loaded from: classes9.dex */
@Metadata
public class JvmSystemFileSystem extends FileSystem {
    private final List u(Path path, boolean z2) throws IOException {
        File file = path.toFile();
        String[] list = file.list();
        if (list != null) {
            ArrayList arrayList = new ArrayList();
            for (String it : list) {
                Intrinsics.checkNotNullExpressionValue(it, "it");
                arrayList.add(path.j(it));
            }
            CollectionsKt.sort(arrayList);
            return arrayList;
        }
        if (!z2) {
            return null;
        }
        if (file.exists()) {
            throw new IOException("failed to list " + path);
        }
        throw new FileNotFoundException("no such file: " + path);
    }

    private final void v(Path path) throws IOException {
        if (j(path)) {
            throw new IOException(path + " already exists.");
        }
    }

    private final void w(Path path) throws IOException {
        if (j(path)) {
            return;
        }
        throw new IOException(path + " doesn't exist.");
    }

    @Override // okio.FileSystem
    public Sink b(Path file, boolean z2) throws IOException {
        Intrinsics.checkNotNullParameter(file, "file");
        if (z2) {
            w(file);
        }
        return Okio.g(file.toFile(), true);
    }

    @Override // okio.FileSystem
    public void c(Path source, Path target) throws IOException {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(target, "target");
        if (source.toFile().renameTo(target.toFile())) {
            return;
        }
        throw new IOException("failed to move " + source + " to " + target);
    }

    @Override // okio.FileSystem
    public void g(Path dir, boolean z2) throws IOException {
        Intrinsics.checkNotNullParameter(dir, "dir");
        if (dir.toFile().mkdir()) {
            return;
        }
        FileMetadata fileMetadataN = n(dir);
        if (fileMetadataN == null || !fileMetadataN.f()) {
            throw new IOException("failed to create directory: " + dir);
        }
        if (z2) {
            throw new IOException(dir + " already exist.");
        }
    }

    @Override // okio.FileSystem
    public void i(Path path, boolean z2) throws IOException {
        Intrinsics.checkNotNullParameter(path, "path");
        if (Thread.interrupted()) {
            throw new InterruptedIOException("interrupted");
        }
        File file = path.toFile();
        if (file.delete()) {
            return;
        }
        if (file.exists()) {
            throw new IOException("failed to delete " + path);
        }
        if (z2) {
            throw new FileNotFoundException("no such file: " + path);
        }
    }

    @Override // okio.FileSystem
    public List k(Path dir) throws IOException {
        Intrinsics.checkNotNullParameter(dir, "dir");
        List listU = u(dir, true);
        Intrinsics.checkNotNull(listU);
        return listU;
    }

    @Override // okio.FileSystem
    public List l(Path dir) {
        Intrinsics.checkNotNullParameter(dir, "dir");
        return u(dir, false);
    }

    @Override // okio.FileSystem
    public FileMetadata n(Path path) {
        Intrinsics.checkNotNullParameter(path, "path");
        File file = path.toFile();
        boolean zIsFile = file.isFile();
        boolean zIsDirectory = file.isDirectory();
        long jLastModified = file.lastModified();
        long length = file.length();
        if (zIsFile || zIsDirectory || jLastModified != 0 || length != 0 || file.exists()) {
            return new FileMetadata(zIsFile, zIsDirectory, null, Long.valueOf(length), null, Long.valueOf(jLastModified), null, null, ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD, null);
        }
        return null;
    }

    @Override // okio.FileSystem
    public FileHandle o(Path file) {
        Intrinsics.checkNotNullParameter(file, "file");
        return new JvmFileHandle(false, new RandomAccessFile(file.toFile(), "r"));
    }

    @Override // okio.FileSystem
    public FileHandle q(Path file, boolean z2, boolean z3) throws IOException {
        Intrinsics.checkNotNullParameter(file, "file");
        if (z2 && z3) {
            throw new IllegalArgumentException("Cannot require mustCreate and mustExist at the same time.");
        }
        if (z2) {
            v(file);
        }
        if (z3) {
            w(file);
        }
        return new JvmFileHandle(true, new RandomAccessFile(file.toFile(), "rw"));
    }

    @Override // okio.FileSystem
    public Sink s(Path file, boolean z2) throws IOException {
        Intrinsics.checkNotNullParameter(file, "file");
        if (z2) {
            v(file);
        }
        return Okio__JvmOkioKt.h(file.toFile(), false, 1, null);
    }

    @Override // okio.FileSystem
    public Source t(Path file) {
        Intrinsics.checkNotNullParameter(file, "file");
        return Okio.k(file.toFile());
    }

    public String toString() {
        return "JvmSystemFileSystem";
    }
}
