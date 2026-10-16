package okhttp3.internal.ws;

import java.io.Closeable;
import java.io.IOException;
import java.util.zip.Inflater;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import okio.InflaterSource;
import okio.Source;

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
public final class MessageInflater implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f144869a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Buffer f144870b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Inflater f144871c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final InflaterSource f144872d;

    public MessageInflater(boolean z2) {
        this.f144869a = z2;
        Buffer buffer = new Buffer();
        this.f144870b = buffer;
        Inflater inflater = new Inflater(true);
        this.f144871c = inflater;
        this.f144872d = new InflaterSource((Source) buffer, inflater);
    }

    public final void a(Buffer buffer) throws IOException {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        if (this.f144870b.size() != 0) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        if (this.f144869a) {
            this.f144871c.reset();
        }
        this.f144870b.K0(buffer);
        this.f144870b.writeInt(65535);
        long bytesRead = this.f144871c.getBytesRead() + this.f144870b.size();
        do {
            this.f144872d.a(buffer, Long.MAX_VALUE);
        } while (this.f144871c.getBytesRead() < bytesRead);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f144872d.close();
    }
}
