package kotlin.io.path;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
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
final class FileVisitorImpl extends SimpleFileVisitor<Path> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Function2 f140033a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Function2 f140034b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Function2 f140035c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Function2 f140036d;

    @Override // java.nio.file.SimpleFileVisitor, java.nio.file.FileVisitor
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public FileVisitResult postVisitDirectory(Path dir, IOException iOException) throws IOException {
        FileVisitResult fileVisitResult;
        Intrinsics.checkNotNullParameter(dir, "dir");
        Function2 function2 = this.f140036d;
        if (function2 != null && (fileVisitResult = (FileVisitResult) function2.invoke(dir, iOException)) != null) {
            return fileVisitResult;
        }
        FileVisitResult fileVisitResultPostVisitDirectory = super.postVisitDirectory(dir, iOException);
        Intrinsics.checkNotNullExpressionValue(fileVisitResultPostVisitDirectory, "postVisitDirectory(...)");
        return fileVisitResultPostVisitDirectory;
    }

    @Override // java.nio.file.SimpleFileVisitor, java.nio.file.FileVisitor
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        FileVisitResult fileVisitResult;
        Intrinsics.checkNotNullParameter(dir, "dir");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        Function2 function2 = this.f140033a;
        if (function2 != null && (fileVisitResult = (FileVisitResult) function2.invoke(dir, attrs)) != null) {
            return fileVisitResult;
        }
        FileVisitResult fileVisitResultPreVisitDirectory = super.preVisitDirectory(dir, attrs);
        Intrinsics.checkNotNullExpressionValue(fileVisitResultPreVisitDirectory, "preVisitDirectory(...)");
        return fileVisitResultPreVisitDirectory;
    }

    @Override // java.nio.file.SimpleFileVisitor, java.nio.file.FileVisitor
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        FileVisitResult fileVisitResult;
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        Function2 function2 = this.f140034b;
        if (function2 != null && (fileVisitResult = (FileVisitResult) function2.invoke(file, attrs)) != null) {
            return fileVisitResult;
        }
        FileVisitResult fileVisitResultVisitFile = super.visitFile(file, attrs);
        Intrinsics.checkNotNullExpressionValue(fileVisitResultVisitFile, "visitFile(...)");
        return fileVisitResultVisitFile;
    }

    @Override // java.nio.file.SimpleFileVisitor, java.nio.file.FileVisitor
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        FileVisitResult fileVisitResult;
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(exc, "exc");
        Function2 function2 = this.f140035c;
        if (function2 != null && (fileVisitResult = (FileVisitResult) function2.invoke(file, exc)) != null) {
            return fileVisitResult;
        }
        FileVisitResult fileVisitResultVisitFileFailed = super.visitFileFailed(file, exc);
        Intrinsics.checkNotNullExpressionValue(fileVisitResultVisitFileFailed, "visitFileFailed(...)");
        return fileVisitResultVisitFileFailed;
    }
}
