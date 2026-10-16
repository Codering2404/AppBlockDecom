package coil.fetch;

import android.net.Uri;
import android.webkit.MimeTypeMap;
import coil.ImageLoader;
import coil.decode.AssetMetadata;
import coil.decode.DataSource;
import coil.decode.ImageSources;
import coil.fetch.Fetcher;
import coil.request.Options;
import coil.util.Utils;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import okio.Okio;

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
public final class AssetUriFetcher implements Fetcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Uri f55817a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Options f55818b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Factory implements Fetcher.Factory<Uri> {
        @Override // coil.fetch.Fetcher.Factory
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Fetcher a(Uri uri, Options options, ImageLoader imageLoader) {
            if (Utils.r(uri)) {
                return new AssetUriFetcher(uri, options);
            }
            return null;
        }
    }

    public AssetUriFetcher(Uri uri, Options options) {
        this.f55817a = uri;
        this.f55818b = options;
    }

    @Override // coil.fetch.Fetcher
    public Object a(Continuation continuation) {
        String strJoinToString$default = CollectionsKt.joinToString$default(CollectionsKt.drop(this.f55817a.getPathSegments(), 1), "/", null, null, 0, null, null, 62, null);
        return new SourceResult(ImageSources.b(Okio.d(Okio.l(this.f55818b.g().getAssets().open(strJoinToString$default))), this.f55818b.g(), new AssetMetadata(strJoinToString$default)), Utils.k(MimeTypeMap.getSingleton(), strJoinToString$default), DataSource.DISK);
    }
}
