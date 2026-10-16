package okio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.nio.channels.FileChannel;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.NoSuchFileException;
import java.nio.file.OpenOption;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.io.path.PathsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

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
public final class NioFileSystemWrappingFileSystem extends NioSystemFileSystem {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final java.nio.file.FileSystem f145066e;

    private final List u(Path path, boolean z2) throws IOException {
        java.nio.file.Path pathZ = z(path);
        try {
            List listL = PathsKt.l(pathZ, null, 1, null);
            ArrayList arrayList = new ArrayList();
            Iterator it = listL.iterator();
            while (it.hasNext()) {
                arrayList.add(path.j(((java.nio.file.Path) it.next()).toString()));
            }
            CollectionsKt.sort(arrayList);
            return arrayList;
        } catch (Exception unused) {
            if (!z2) {
                return null;
            }
            if (Files.exists(pathZ, (LinkOption[]) Arrays.copyOf(new LinkOption[0], 0))) {
                throw new IOException("failed to list " + path);
            }
            throw new FileNotFoundException("no such file: " + path);
        }
    }

    private final java.nio.file.Path z(Path path) {
        java.nio.file.Path path2 = this.f145066e.getPath(path.toString(), new String[0]);
        Intrinsics.checkNotNullExpressionValue(path2, "nioFileSystem.getPath(toString())");
        return path2;
    }

    @Override // okio.JvmSystemFileSystem, okio.FileSystem
    public Sink b(Path file, boolean z2) throws IOException {
        Intrinsics.checkNotNullParameter(file, "file");
        List listCreateListBuilder = CollectionsKt.createListBuilder();
        listCreateListBuilder.add(StandardOpenOption.APPEND);
        if (!z2) {
            listCreateListBuilder.add(StandardOpenOption.CREATE);
        }
        List listBuild = CollectionsKt.build(listCreateListBuilder);
        java.nio.file.Path pathZ = z(file);
        StandardOpenOption[] standardOpenOptionArr = (StandardOpenOption[]) listBuild.toArray(new StandardOpenOption[0]);
        OpenOption[] openOptionArr = (OpenOption[]) Arrays.copyOf(standardOpenOptionArr, standardOpenOptionArr.length);
        OutputStream outputStreamNewOutputStream = Files.newOutputStream(pathZ, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length));
        Intrinsics.checkNotNullExpressionValue(outputStreamNewOutputStream, "newOutputStream(this, *options)");
        return Okio.h(outputStreamNewOutputStream);
    }

    @Override // okio.NioSystemFileSystem, okio.JvmSystemFileSystem, okio.FileSystem
    public void c(Path source, Path target) throws IOException {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(target, "target");
        try {
            Intrinsics.checkNotNullExpressionValue(Files.move(z(source), z(target), (CopyOption[]) Arrays.copyOf(new CopyOption[]{StandardCopyOption.ATOMIC_MOVE, StandardCopyOption.REPLACE_EXISTING}, 2)), "move(this, target, *options)");
        } catch (UnsupportedOperationException unused) {
            throw new IOException("atomic move not supported");
        } catch (NoSuchFileException e3) {
            throw new FileNotFoundException(e3.getMessage());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @Override // okio.JvmSystemFileSystem, okio.FileSystem
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void g(okio.Path r4, boolean r5) throws java.io.IOException {
        /*
            r3 = this;
            java.lang.String r0 = "dir"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            okio.FileMetadata r0 = r3.n(r4)
            r1 = 0
            if (r0 == 0) goto L14
            boolean r0 = r0.f()
            r2 = 1
            if (r0 != r2) goto L14
            goto L15
        L14:
            r2 = r1
        L15:
            if (r2 == 0) goto L31
            if (r5 != 0) goto L1a
            goto L31
        L1a:
            java.io.IOException r5 = new java.io.IOException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r4)
            java.lang.String r4 = " already exist."
            r0.append(r4)
            java.lang.String r4 = r0.toString()
            r5.<init>(r4)
            throw r5
        L31:
            java.nio.file.Path r5 = r3.z(r4)     // Catch: java.io.IOException -> L47
            java.nio.file.attribute.FileAttribute[] r0 = new java.nio.file.attribute.FileAttribute[r1]     // Catch: java.io.IOException -> L47
            java.lang.Object[] r0 = java.util.Arrays.copyOf(r0, r1)     // Catch: java.io.IOException -> L47
            java.nio.file.attribute.FileAttribute[] r0 = (java.nio.file.attribute.FileAttribute[]) r0     // Catch: java.io.IOException -> L47
            java.nio.file.Path r5 = java.nio.file.Files.createDirectory(r5, r0)     // Catch: java.io.IOException -> L47
            java.lang.String r0 = "createDirectory(this, *attributes)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r0)     // Catch: java.io.IOException -> L47
            return
        L47:
            r5 = move-exception
            if (r2 == 0) goto L4b
            return
        L4b:
            java.io.IOException r0 = new java.io.IOException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "failed to create directory: "
            r1.append(r2)
            r1.append(r4)
            java.lang.String r4 = r1.toString()
            r0.<init>(r4, r5)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.NioFileSystemWrappingFileSystem.g(okio.Path, boolean):void");
    }

    @Override // okio.JvmSystemFileSystem, okio.FileSystem
    public void i(Path path, boolean z2) throws IOException {
        Intrinsics.checkNotNullParameter(path, "path");
        if (Thread.interrupted()) {
            throw new InterruptedIOException("interrupted");
        }
        java.nio.file.Path pathZ = z(path);
        try {
            Files.delete(pathZ);
        } catch (NoSuchFileException unused) {
            if (z2) {
                throw new FileNotFoundException("no such file: " + path);
            }
        } catch (IOException unused2) {
            if (Files.exists(pathZ, (LinkOption[]) Arrays.copyOf(new LinkOption[0], 0))) {
                throw new IOException("failed to delete " + path);
            }
        }
    }

    @Override // okio.JvmSystemFileSystem, okio.FileSystem
    public List k(Path dir) throws IOException {
        Intrinsics.checkNotNullParameter(dir, "dir");
        List listU = u(dir, true);
        Intrinsics.checkNotNull(listU);
        return listU;
    }

    @Override // okio.JvmSystemFileSystem, okio.FileSystem
    public List l(Path dir) {
        Intrinsics.checkNotNullParameter(dir, "dir");
        return u(dir, false);
    }

    @Override // okio.NioSystemFileSystem, okio.JvmSystemFileSystem, okio.FileSystem
    public FileMetadata n(Path path) {
        Intrinsics.checkNotNullParameter(path, "path");
        return x(z(path));
    }

    @Override // okio.JvmSystemFileSystem, okio.FileSystem
    public FileHandle o(Path file) throws IOException {
        Intrinsics.checkNotNullParameter(file, "file");
        try {
            FileChannel channel = FileChannel.open(z(file), StandardOpenOption.READ);
            Intrinsics.checkNotNullExpressionValue(channel, "channel");
            return new NioFileSystemFileHandle(false, channel);
        } catch (NoSuchFileException unused) {
            throw new FileNotFoundException("no such file: " + file);
        }
    }

    @Override // okio.JvmSystemFileSystem, okio.FileSystem
    public FileHandle q(Path file, boolean z2, boolean z3) throws IOException {
        Intrinsics.checkNotNullParameter(file, "file");
        if (z2 && z3) {
            throw new IllegalArgumentException("Cannot require mustCreate and mustExist at the same time.");
        }
        List listCreateListBuilder = CollectionsKt.createListBuilder();
        listCreateListBuilder.add(StandardOpenOption.READ);
        listCreateListBuilder.add(StandardOpenOption.WRITE);
        if (z2) {
            listCreateListBuilder.add(StandardOpenOption.CREATE_NEW);
        } else if (!z3) {
            listCreateListBuilder.add(StandardOpenOption.CREATE);
        }
        List listBuild = CollectionsKt.build(listCreateListBuilder);
        try {
            java.nio.file.Path pathZ = z(file);
            StandardOpenOption[] standardOpenOptionArr = (StandardOpenOption[]) listBuild.toArray(new StandardOpenOption[0]);
            FileChannel channel = FileChannel.open(pathZ, (OpenOption[]) Arrays.copyOf(standardOpenOptionArr, standardOpenOptionArr.length));
            Intrinsics.checkNotNullExpressionValue(channel, "channel");
            return new NioFileSystemFileHandle(true, channel);
        } catch (NoSuchFileException unused) {
            throw new FileNotFoundException("no such file: " + file);
        }
    }

    @Override // okio.JvmSystemFileSystem, okio.FileSystem
    public Sink s(Path file, boolean z2) throws IOException {
        Intrinsics.checkNotNullParameter(file, "file");
        List listCreateListBuilder = CollectionsKt.createListBuilder();
        if (z2) {
            listCreateListBuilder.add(StandardOpenOption.CREATE_NEW);
        }
        List listBuild = CollectionsKt.build(listCreateListBuilder);
        try {
            java.nio.file.Path pathZ = z(file);
            StandardOpenOption[] standardOpenOptionArr = (StandardOpenOption[]) listBuild.toArray(new StandardOpenOption[0]);
            OpenOption[] openOptionArr = (OpenOption[]) Arrays.copyOf(standardOpenOptionArr, standardOpenOptionArr.length);
            OutputStream outputStreamNewOutputStream = Files.newOutputStream(pathZ, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length));
            Intrinsics.checkNotNullExpressionValue(outputStreamNewOutputStream, "newOutputStream(this, *options)");
            return Okio.h(outputStreamNewOutputStream);
        } catch (NoSuchFileException unused) {
            throw new FileNotFoundException("no such file: " + file);
        }
    }

    @Override // okio.JvmSystemFileSystem, okio.FileSystem
    public Source t(Path file) throws IOException {
        Intrinsics.checkNotNullParameter(file, "file");
        try {
            InputStream inputStreamNewInputStream = Files.newInputStream(z(file), (OpenOption[]) Arrays.copyOf(new OpenOption[0], 0));
            Intrinsics.checkNotNullExpressionValue(inputStreamNewInputStream, "newInputStream(this, *options)");
            return Okio.l(inputStreamNewInputStream);
        } catch (NoSuchFileException unused) {
            throw new FileNotFoundException("no such file: " + file);
        }
    }

    @Override // okio.NioSystemFileSystem, okio.JvmSystemFileSystem
    public String toString() {
        String strM = Reflection.b(this.f145066e.getClass()).m();
        Intrinsics.checkNotNull(strM);
        return strM;
    }
}
