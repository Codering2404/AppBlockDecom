package okio;

import d.qFm.sECyKyO;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
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
public abstract class ForwardingFileSystem extends FileSystem {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final FileSystem f145037e;

    public ForwardingFileSystem(FileSystem delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.f145037e = delegate;
    }

    @Override // okio.FileSystem
    public Sink b(Path file, boolean z2) {
        Intrinsics.checkNotNullParameter(file, "file");
        return this.f145037e.b(u(file, "appendingSink", "file"), z2);
    }

    @Override // okio.FileSystem
    public void c(Path source, Path target) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(target, "target");
        this.f145037e.c(u(source, "atomicMove", "source"), u(target, "atomicMove", "target"));
    }

    @Override // okio.FileSystem
    public void g(Path dir, boolean z2) {
        Intrinsics.checkNotNullParameter(dir, "dir");
        this.f145037e.g(u(dir, "createDirectory", "dir"), z2);
    }

    @Override // okio.FileSystem
    public void i(Path path, boolean z2) {
        Intrinsics.checkNotNullParameter(path, "path");
        this.f145037e.i(u(path, "delete", "path"), z2);
    }

    @Override // okio.FileSystem
    public List k(Path dir) {
        Intrinsics.checkNotNullParameter(dir, "dir");
        List listK = this.f145037e.k(u(dir, "list", "dir"));
        ArrayList arrayList = new ArrayList();
        Iterator it = listK.iterator();
        while (it.hasNext()) {
            arrayList.add(v((Path) it.next(), "list"));
        }
        CollectionsKt.sort(arrayList);
        return arrayList;
    }

    @Override // okio.FileSystem
    public List l(Path dir) {
        Intrinsics.checkNotNullParameter(dir, "dir");
        List listL = this.f145037e.l(u(dir, "listOrNull", "dir"));
        if (listL == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = listL.iterator();
        while (it.hasNext()) {
            arrayList.add(v((Path) it.next(), "listOrNull"));
        }
        CollectionsKt.sort(arrayList);
        return arrayList;
    }

    @Override // okio.FileSystem
    public FileMetadata n(Path path) {
        Intrinsics.checkNotNullParameter(path, "path");
        FileMetadata fileMetadataN = this.f145037e.n(u(path, "metadataOrNull", "path"));
        if (fileMetadataN == null) {
            return null;
        }
        return fileMetadataN.e() == null ? fileMetadataN : FileMetadata.b(fileMetadataN, false, false, v(fileMetadataN.e(), "metadataOrNull"), null, null, null, null, null, 251, null);
    }

    @Override // okio.FileSystem
    public FileHandle o(Path file) {
        Intrinsics.checkNotNullParameter(file, "file");
        return this.f145037e.o(u(file, "openReadOnly", "file"));
    }

    @Override // okio.FileSystem
    public Sink s(Path file, boolean z2) {
        Intrinsics.checkNotNullParameter(file, "file");
        return this.f145037e.s(u(file, "sink", "file"), z2);
    }

    @Override // okio.FileSystem
    public Source t(Path file) {
        Intrinsics.checkNotNullParameter(file, "file");
        return this.f145037e.t(u(file, "source", "file"));
    }

    public String toString() {
        return Reflection.b(getClass()).m() + '(' + this.f145037e + ')';
    }

    public Path u(Path path, String functionName, String parameterName) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(functionName, "functionName");
        Intrinsics.checkNotNullParameter(parameterName, "parameterName");
        return path;
    }

    public Path v(Path path, String functionName) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(functionName, "functionName");
        return path;
    }

    @Override // okio.FileSystem
    public FileHandle q(Path file, boolean z2, boolean z3) {
        Intrinsics.checkNotNullParameter(file, "file");
        return this.f145037e.q(u(file, sECyKyO.WIFIJ, "file"), z2, z3);
    }
}
