package coil.fetch;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import coil.ImageLoader;
import coil.decode.DataSource;
import coil.fetch.Fetcher;
import coil.request.Options;
import coil.util.DrawableUtils;
import coil.util.Utils;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

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
public final class DrawableFetcher implements Fetcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Drawable f55825a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Options f55826b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Factory implements Fetcher.Factory<Drawable> {
        @Override // coil.fetch.Fetcher.Factory
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Fetcher a(Drawable drawable, Options options, ImageLoader imageLoader) {
            return new DrawableFetcher(drawable, options);
        }
    }

    public DrawableFetcher(Drawable drawable, Options options) {
        this.f55825a = drawable;
        this.f55826b = options;
    }

    @Override // coil.fetch.Fetcher
    public Object a(Continuation continuation) {
        Drawable bitmapDrawable;
        boolean zV = Utils.v(this.f55825a);
        if (zV) {
            bitmapDrawable = new BitmapDrawable(this.f55826b.g().getResources(), DrawableUtils.f56225a.a(this.f55825a, this.f55826b.f(), this.f55826b.o(), this.f55826b.n(), this.f55826b.c()));
        } else {
            bitmapDrawable = this.f55825a;
        }
        return new DrawableResult(bitmapDrawable, zV, DataSource.MEMORY);
    }
}
