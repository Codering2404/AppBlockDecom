package okhttp3.internal.ws;

import java.io.Closeable;
import java.util.zip.Deflater;
import kotlin.Metadata;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import okio.ByteString;
import okio.DeflaterSink;
import okio.Sink;

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
public final class MessageDeflater implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f144864a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Buffer f144865b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Deflater f144866c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final DeflaterSink f144867d;

    public MessageDeflater(boolean z2) {
        this.f144864a = z2;
        Buffer buffer = new Buffer();
        this.f144865b = buffer;
        Deflater deflater = new Deflater(-1, true);
        this.f144866c = deflater;
        this.f144867d = new DeflaterSink((Sink) buffer, deflater);
    }

    private final boolean b(Buffer buffer, ByteString byteString) {
        return buffer.E0(buffer.size() - ((long) byteString.C()), byteString);
    }

    public final void a(Buffer buffer) {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        if (this.f144865b.size() != 0) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        if (this.f144864a) {
            this.f144866c.reset();
        }
        this.f144867d.H0(buffer, buffer.size());
        this.f144867d.flush();
        if (b(this.f144865b, MessageDeflaterKt.f144868a)) {
            long size = this.f144865b.size() - ((long) 4);
            Buffer.UnsafeCursor unsafeCursorL = Buffer.L(this.f144865b, null, 1, null);
            try {
                unsafeCursorL.c(size);
                CloseableKt.a(unsafeCursorL, null);
            } finally {
            }
        } else {
            this.f144865b.writeByte(0);
        }
        Buffer buffer2 = this.f144865b;
        buffer.H0(buffer2, buffer2.size());
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f144867d.close();
    }
}
