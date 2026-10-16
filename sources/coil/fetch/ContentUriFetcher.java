package coil.fetch;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.graphics.Point;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import coil.ImageLoader;
import coil.decode.ContentMetadata;
import coil.decode.DataSource;
import coil.decode.ImageSources;
import coil.fetch.Fetcher;
import coil.request.Options;
import coil.size.Dimension;
import com.applovin.sdk.AppLovinEventTypes;
import com.facebook.share.internal.ShareConstants;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
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
public final class ContentUriFetcher implements Fetcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Uri f55823a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Options f55824b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Factory implements Fetcher.Factory<Uri> {
        private final boolean c(Uri uri) {
            return Intrinsics.areEqual(uri.getScheme(), AppLovinEventTypes.USER_VIEWED_CONTENT);
        }

        @Override // coil.fetch.Fetcher.Factory
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Fetcher a(Uri uri, Options options, ImageLoader imageLoader) {
            if (c(uri)) {
                return new ContentUriFetcher(uri, options);
            }
            return null;
        }
    }

    public ContentUriFetcher(Uri uri, Options options) {
        this.f55823a = uri;
        this.f55824b = options;
    }

    private final Bundle d() {
        Dimension dimensionD = this.f55824b.o().d();
        Dimension.Pixels pixels = dimensionD instanceof Dimension.Pixels ? (Dimension.Pixels) dimensionD : null;
        if (pixels == null) {
            return null;
        }
        int i3 = pixels.f56163a;
        Dimension dimensionC = this.f55824b.o().c();
        Dimension.Pixels pixels2 = dimensionC instanceof Dimension.Pixels ? (Dimension.Pixels) dimensionC : null;
        if (pixels2 == null) {
            return null;
        }
        int i4 = pixels2.f56163a;
        Bundle bundle = new Bundle(1);
        bundle.putParcelable("android.content.extra.SIZE", new Point(i3, i4));
        return bundle;
    }

    @Override // coil.fetch.Fetcher
    public Object a(Continuation continuation) throws FileNotFoundException {
        InputStream inputStreamOpenInputStream;
        ContentResolver contentResolver = this.f55824b.g().getContentResolver();
        if (b(this.f55823a)) {
            AssetFileDescriptor assetFileDescriptorOpenAssetFileDescriptor = contentResolver.openAssetFileDescriptor(this.f55823a, "r");
            inputStreamOpenInputStream = assetFileDescriptorOpenAssetFileDescriptor != null ? assetFileDescriptorOpenAssetFileDescriptor.createInputStream() : null;
            if (inputStreamOpenInputStream == null) {
                throw new IllegalStateException(("Unable to find a contact photo associated with '" + this.f55823a + "'.").toString());
            }
        } else if (Build.VERSION.SDK_INT < 29 || !c(this.f55823a)) {
            inputStreamOpenInputStream = contentResolver.openInputStream(this.f55823a);
            if (inputStreamOpenInputStream == null) {
                throw new IllegalStateException(("Unable to open '" + this.f55823a + "'.").toString());
            }
        } else {
            AssetFileDescriptor assetFileDescriptorOpenTypedAssetFile = contentResolver.openTypedAssetFile(this.f55823a, "image/*", d(), null);
            inputStreamOpenInputStream = assetFileDescriptorOpenTypedAssetFile != null ? assetFileDescriptorOpenTypedAssetFile.createInputStream() : null;
            if (inputStreamOpenInputStream == null) {
                throw new IllegalStateException(("Unable to find a music thumbnail associated with '" + this.f55823a + "'.").toString());
            }
        }
        return new SourceResult(ImageSources.b(Okio.d(Okio.l(inputStreamOpenInputStream)), this.f55824b.g(), new ContentMetadata(this.f55823a)), contentResolver.getType(this.f55823a), DataSource.DISK);
    }

    public final boolean b(Uri uri) {
        return Intrinsics.areEqual(uri.getAuthority(), "com.android.contacts") && Intrinsics.areEqual(uri.getLastPathSegment(), "display_photo");
    }

    public final boolean c(Uri uri) {
        List<String> pathSegments;
        int size;
        return Intrinsics.areEqual(uri.getAuthority(), ShareConstants.WEB_DIALOG_PARAM_MEDIA) && (size = (pathSegments = uri.getPathSegments()).size()) >= 3 && Intrinsics.areEqual(pathSegments.get(size + (-3)), "audio") && Intrinsics.areEqual(pathSegments.get(size + (-2)), "albums");
    }
}
