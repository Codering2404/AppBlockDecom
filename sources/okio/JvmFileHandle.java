package okio;

import java.io.RandomAccessFile;
import kotlin.Metadata;
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
public final class JvmFileHandle extends FileHandle {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final RandomAccessFile f145064f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JvmFileHandle(boolean z2, RandomAccessFile randomAccessFile) {
        super(z2);
        Intrinsics.checkNotNullParameter(randomAccessFile, "randomAccessFile");
        this.f145064f = randomAccessFile;
    }

    @Override // okio.FileHandle
    protected synchronized void k() {
        this.f145064f.close();
    }

    @Override // okio.FileHandle
    protected synchronized void l() {
        this.f145064f.getFD().sync();
    }

    @Override // okio.FileHandle
    protected synchronized int m(long j3, byte[] array, int i3, int i4) {
        Intrinsics.checkNotNullParameter(array, "array");
        this.f145064f.seek(j3);
        int i5 = 0;
        while (true) {
            if (i5 >= i4) {
                break;
            }
            int i6 = this.f145064f.read(array, i3, i4 - i5);
            if (i6 != -1) {
                i5 += i6;
            } else if (i5 == 0) {
                return -1;
            }
        }
        return i5;
    }

    @Override // okio.FileHandle
    protected synchronized long n() {
        return this.f145064f.length();
    }

    @Override // okio.FileHandle
    protected synchronized void r(long j3, byte[] array, int i3, int i4) {
        Intrinsics.checkNotNullParameter(array, "array");
        this.f145064f.seek(j3);
        this.f145064f.write(array, i3, i4);
    }
}
