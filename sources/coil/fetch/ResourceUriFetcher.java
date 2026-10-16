package coil.fetch;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.TypedValue;
import android.webkit.MimeTypeMap;
import coil.ImageLoader;
import coil.decode.DataSource;
import coil.decode.ImageSources;
import coil.decode.ResourceMetadata;
import coil.fetch.Fetcher;
import coil.request.Options;
import coil.util.Contexts;
import coil.util.DrawableUtils;
import coil.util.Utils;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
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
public final class ResourceUriFetcher implements Fetcher {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Companion f55851c = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Uri f55852a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Options f55853b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Factory implements Fetcher.Factory<Uri> {
        private final boolean c(Uri uri) {
            return Intrinsics.areEqual(uri.getScheme(), "android.resource");
        }

        @Override // coil.fetch.Fetcher.Factory
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Fetcher a(Uri uri, Options options, ImageLoader imageLoader) {
            if (c(uri)) {
                return new ResourceUriFetcher(uri, options);
            }
            return null;
        }
    }

    public ResourceUriFetcher(Uri uri, Options options) {
        this.f55852a = uri;
        this.f55853b = options;
    }

    private final Void b(Uri uri) {
        throw new IllegalStateException("Invalid android.resource URI: " + uri);
    }

    @Override // coil.fetch.Fetcher
    public Object a(Continuation continuation) {
        Integer numU;
        String authority = this.f55852a.getAuthority();
        if (authority != null) {
            if (StringsKt.p0(authority)) {
                authority = null;
            }
            if (authority != null) {
                String str = (String) CollectionsKt.lastOrNull((List) this.f55852a.getPathSegments());
                if (str == null || (numU = StringsKt.u(str)) == null) {
                    b(this.f55852a);
                    throw new KotlinNothingValueException();
                }
                int iIntValue = numU.intValue();
                Context contextG = this.f55853b.g();
                Resources resources = Intrinsics.areEqual(authority, contextG.getPackageName()) ? contextG.getResources() : contextG.getPackageManager().getResourcesForApplication(authority);
                TypedValue typedValue = new TypedValue();
                resources.getValue(iIntValue, typedValue, true);
                CharSequence charSequence = typedValue.string;
                String strK = Utils.k(MimeTypeMap.getSingleton(), charSequence.subSequence(StringsKt.t0(charSequence, '/', 0, false, 6, null), charSequence.length()).toString());
                if (!Intrinsics.areEqual(strK, "text/xml")) {
                    TypedValue typedValue2 = new TypedValue();
                    return new SourceResult(ImageSources.b(Okio.d(Okio.l(resources.openRawResource(iIntValue, typedValue2))), contextG, new ResourceMetadata(authority, iIntValue, typedValue2.density)), strK, DataSource.DISK);
                }
                Drawable drawableA = Intrinsics.areEqual(authority, contextG.getPackageName()) ? Contexts.a(contextG, iIntValue) : Contexts.d(contextG, resources, iIntValue);
                boolean zV = Utils.v(drawableA);
                if (zV) {
                    drawableA = new BitmapDrawable(contextG.getResources(), DrawableUtils.f56225a.a(drawableA, this.f55853b.f(), this.f55853b.o(), this.f55853b.n(), this.f55853b.c()));
                }
                return new DrawableResult(drawableA, zV, DataSource.DISK);
            }
        }
        b(this.f55852a);
        throw new KotlinNothingValueException();
    }
}
