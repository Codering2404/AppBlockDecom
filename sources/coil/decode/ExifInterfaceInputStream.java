package coil.decode;

import java.io.IOException;
import java.io.InputStream;
import kotlin.Metadata;

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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
final class ExifInterfaceInputStream extends InputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final InputStream f55712a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f55713b = 1073741824;

    public ExifInterfaceInputStream(InputStream inputStream) {
        this.f55712a = inputStream;
    }

    private final int a(int i3) {
        if (i3 == -1) {
            this.f55713b = 0;
        }
        return i3;
    }

    @Override // java.io.InputStream
    public int available() {
        return this.f55713b;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f55712a.close();
    }

    @Override // java.io.InputStream
    public int read() {
        return a(this.f55712a.read());
    }

    @Override // java.io.InputStream
    public long skip(long j3) {
        return this.f55712a.skip(j3);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) {
        return a(this.f55712a.read(bArr));
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i3, int i4) {
        return a(this.f55712a.read(bArr, i3, i4));
    }
}
