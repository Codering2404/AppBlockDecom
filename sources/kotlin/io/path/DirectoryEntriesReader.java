package kotlin.io.path;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArrayDeque;
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
final class DirectoryEntriesReader extends SimpleFileVisitor<Path> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f140030a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private PathNode f140031b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ArrayDeque f140032c = new ArrayDeque();

    public DirectoryEntriesReader(boolean z2) {
        this.f140030a = z2;
    }

    @Override // java.nio.file.SimpleFileVisitor, java.nio.file.FileVisitor
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        Intrinsics.checkNotNullParameter(dir, "dir");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        this.f140032c.add(new PathNode(dir, attrs.fileKey(), this.f140031b));
        FileVisitResult fileVisitResultPreVisitDirectory = super.preVisitDirectory(dir, attrs);
        Intrinsics.checkNotNullExpressionValue(fileVisitResultPreVisitDirectory, "preVisitDirectory(...)");
        return fileVisitResultPreVisitDirectory;
    }

    public final List b(PathNode directoryNode) throws IOException {
        Intrinsics.checkNotNullParameter(directoryNode, "directoryNode");
        this.f140031b = directoryNode;
        Files.walkFileTree(directoryNode.d(), LinkFollowing.f140037a.b(this.f140030a), 1, this);
        this.f140032c.removeFirst();
        ArrayDeque arrayDeque = this.f140032c;
        this.f140032c = new ArrayDeque();
        return arrayDeque;
    }

    @Override // java.nio.file.SimpleFileVisitor, java.nio.file.FileVisitor
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        this.f140032c.add(new PathNode(file, null, this.f140031b));
        FileVisitResult fileVisitResultVisitFile = super.visitFile(file, attrs);
        Intrinsics.checkNotNullExpressionValue(fileVisitResultVisitFile, "visitFile(...)");
        return fileVisitResultVisitFile;
    }
}
