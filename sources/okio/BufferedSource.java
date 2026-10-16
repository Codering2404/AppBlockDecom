package okio;

import java.io.InputStream;
import java.nio.channels.ReadableByteChannel;
import java.nio.charset.Charset;
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
public interface BufferedSource extends Source, ReadableByteChannel {
    byte[] D1();

    boolean E0(long j3, ByteString byteString);

    long F2();

    boolean G1();

    InputStream H2();

    int I2(Options options);

    long M1();

    String Q0();

    byte[] S0(long j3);

    short W0();

    String Z1(Charset charset);

    long b1();

    long c0(ByteString byteString);

    void g1(long j3);

    void l0(Buffer buffer, long j3);

    int l2();

    long m0(byte b3, long j3, long j4);

    String m1(long j3);

    long n0(ByteString byteString);

    BufferedSource peek();

    ByteString q1(long j3);

    String r0(long j3);

    byte readByte();

    void readFully(byte[] bArr);

    int readInt();

    long readLong();

    short readShort();

    Buffer s();

    void skip(long j3);

    Buffer u();

    long w2(Sink sink);

    boolean y(long j3);
}
