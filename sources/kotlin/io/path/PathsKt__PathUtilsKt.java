package kotlin.io.path;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
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
public class PathsKt__PathUtilsKt extends PathsKt__PathRecursiveFunctionsKt {
    public static final String j(Path path) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Path fileName = path.getFileName();
        String string = fileName != null ? fileName.toString() : null;
        return string == null ? "" : string;
    }

    public static final List k(Path path, String glob) throws IOException {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(glob, "glob");
        DirectoryStream<Path> directoryStreamNewDirectoryStream = Files.newDirectoryStream(path, glob);
        try {
            Intrinsics.checkNotNull(directoryStreamNewDirectoryStream);
            List list = CollectionsKt.toList(directoryStreamNewDirectoryStream);
            CloseableKt.a(directoryStreamNewDirectoryStream, null);
            return list;
        } finally {
        }
    }

    public static /* synthetic */ List l(Path path, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = "*";
        }
        return k(path, str);
    }

    public static final Path m(Path path, Path base) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(base, "base");
        try {
            return PathRelativizer.f140050a.a(path, base);
        } catch (IllegalArgumentException e3) {
            throw new IllegalArgumentException(e3.getMessage() + "\nthis path: " + path + "\nbase path: " + base, e3);
        }
    }
}
