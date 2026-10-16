package okhttp3.internal.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.Okio;
import okio.Okio__JvmOkioKt;
import okio.Sink;
import okio.Source;

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
public interface FileSystem {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ Companion f144787a = new Companion();

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        private static final class SystemFileSystem implements FileSystem {
            @Override // okhttp3.internal.io.FileSystem
            public void a(File directory) throws IOException {
                Intrinsics.checkNotNullParameter(directory, "directory");
                File[] fileArrListFiles = directory.listFiles();
                if (fileArrListFiles == null) {
                    throw new IOException(Intrinsics.stringPlus("not a readable directory: ", directory));
                }
                int length = fileArrListFiles.length;
                int i3 = 0;
                while (i3 < length) {
                    File file = fileArrListFiles[i3];
                    i3++;
                    if (file.isDirectory()) {
                        Intrinsics.checkNotNullExpressionValue(file, "file");
                        a(file);
                    }
                    if (!file.delete()) {
                        throw new IOException(Intrinsics.stringPlus("failed to delete ", file));
                    }
                }
            }

            @Override // okhttp3.internal.io.FileSystem
            public boolean b(File file) {
                Intrinsics.checkNotNullParameter(file, "file");
                return file.exists();
            }

            @Override // okhttp3.internal.io.FileSystem
            public Sink c(File file) {
                Intrinsics.checkNotNullParameter(file, "file");
                try {
                    return Okio.a(file);
                } catch (FileNotFoundException unused) {
                    file.getParentFile().mkdirs();
                    return Okio.a(file);
                }
            }

            @Override // okhttp3.internal.io.FileSystem
            public long d(File file) {
                Intrinsics.checkNotNullParameter(file, "file");
                return file.length();
            }

            @Override // okhttp3.internal.io.FileSystem
            public Source e(File file) {
                Intrinsics.checkNotNullParameter(file, "file");
                return Okio.k(file);
            }

            @Override // okhttp3.internal.io.FileSystem
            public Sink f(File file) {
                Intrinsics.checkNotNullParameter(file, "file");
                try {
                    return Okio__JvmOkioKt.h(file, false, 1, null);
                } catch (FileNotFoundException unused) {
                    file.getParentFile().mkdirs();
                    return Okio__JvmOkioKt.h(file, false, 1, null);
                }
            }

            @Override // okhttp3.internal.io.FileSystem
            public void g(File from, File to) throws IOException {
                Intrinsics.checkNotNullParameter(from, "from");
                Intrinsics.checkNotNullParameter(to, "to");
                h(to);
                if (from.renameTo(to)) {
                    return;
                }
                throw new IOException("failed to rename " + from + " to " + to);
            }

            @Override // okhttp3.internal.io.FileSystem
            public void h(File file) throws IOException {
                Intrinsics.checkNotNullParameter(file, "file");
                if (!file.delete() && file.exists()) {
                    throw new IOException(Intrinsics.stringPlus("failed to delete ", file));
                }
            }

            public String toString() {
                return "FileSystem.SYSTEM";
            }
        }

        private Companion() {
        }
    }

    void a(File file);

    boolean b(File file);

    Sink c(File file);

    long d(File file);

    Source e(File file);

    Sink f(File file);

    void g(File file, File file2);

    void h(File file);
}
