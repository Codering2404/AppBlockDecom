package okhttp3.internal.cache2;

import java.io.IOException;
import java.nio.channels.FileChannel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;

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
public final class FileOperator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final FileChannel f144364a;

    public FileOperator(FileChannel fileChannel) {
        Intrinsics.checkNotNullParameter(fileChannel, "fileChannel");
        this.f144364a = fileChannel;
    }

    public final void a(long j3, Buffer sink, long j4) throws IOException {
        Intrinsics.checkNotNullParameter(sink, "sink");
        if (j4 < 0) {
            throw new IndexOutOfBoundsException();
        }
        long j5 = j3;
        long j6 = j4;
        while (j6 > 0) {
            long jTransferTo = this.f144364a.transferTo(j5, j6, sink);
            j5 += jTransferTo;
            j6 -= jTransferTo;
        }
    }

    public final void b(long j3, Buffer source, long j4) throws IOException {
        Intrinsics.checkNotNullParameter(source, "source");
        if (j4 < 0 || j4 > source.size()) {
            throw new IndexOutOfBoundsException();
        }
        long j5 = j3;
        long j6 = j4;
        while (j6 > 0) {
            long jTransferFrom = this.f144364a.transferFrom(source, j5, j6);
            j5 += jTransferFrom;
            j6 -= jTransferFrom;
        }
    }
}
