package okio;

import java.io.OutputStream;
import java.nio.channels.WritableByteChannel;
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
/* JADX INFO: loaded from: classes9.dex */
@Metadata
public interface BufferedSink extends Sink, WritableByteChannel {
    BufferedSink C0(String str);

    OutputStream D2();

    BufferedSink J0(String str, int i3, int i4);

    long K0(Source source);

    BufferedSink U();

    BufferedSink e2(long j3);

    @Override // okio.Sink, java.io.Flushable
    void flush();

    BufferedSink j1(long j3);

    BufferedSink o0();

    BufferedSink q2(ByteString byteString);

    Buffer s();

    Buffer u();

    BufferedSink write(byte[] bArr);

    BufferedSink write(byte[] bArr, int i3, int i4);

    BufferedSink writeByte(int i3);

    BufferedSink writeInt(int i3);

    BufferedSink writeShort(int i3);
}
