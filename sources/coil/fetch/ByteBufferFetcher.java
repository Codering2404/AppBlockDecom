package coil.fetch;

import coil.ImageLoader;
import coil.decode.DataSource;
import coil.decode.ImageSources;
import coil.fetch.Fetcher;
import coil.request.Options;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import okio.Buffer;

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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class ByteBufferFetcher implements Fetcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ByteBuffer f55821a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Options f55822b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Factory implements Fetcher.Factory<ByteBuffer> {
        @Override // coil.fetch.Fetcher.Factory
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Fetcher a(ByteBuffer byteBuffer, Options options, ImageLoader imageLoader) {
            return new ByteBufferFetcher(byteBuffer, options);
        }
    }

    public ByteBufferFetcher(ByteBuffer byteBuffer, Options options) {
        this.f55821a = byteBuffer;
        this.f55822b = options;
    }

    @Override // coil.fetch.Fetcher
    public Object a(Continuation continuation) {
        try {
            Buffer buffer = new Buffer();
            buffer.write(this.f55821a);
            this.f55821a.position(0);
            return new SourceResult(ImageSources.a(buffer, this.f55822b.g()), null, DataSource.MEMORY);
        } catch (Throwable th) {
            this.f55821a.position(0);
            throw th;
        }
    }
}
