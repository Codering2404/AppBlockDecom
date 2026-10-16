package coil;

import android.content.Context;
import coil.EventListener;
import coil.disk.DiskCache;
import coil.memory.MemoryCache;
import coil.request.DefaultRequestOptions;
import coil.request.Disposable;
import coil.request.ImageRequest;
import coil.util.ImageLoaderOptions;
import coil.util.Logger;
import coil.util.Requests;
import coil.util.SingletonDiskCache;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import okhttp3.OkHttpClient;

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
public interface ImageLoader {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Context f55426a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private DefaultRequestOptions f55427b = Requests.b();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Lazy f55428c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private Lazy f55429d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private Lazy f55430e = null;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private EventListener.Factory f55431f = null;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private ComponentRegistry f55432g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private ImageLoaderOptions f55433h = new ImageLoaderOptions(false, false, false, 0, null, 31, null);

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private Logger f55434i = null;

        public Builder(Context context) {
            this.f55426a = context.getApplicationContext();
        }

        public final ImageLoader b() {
            Context context = this.f55426a;
            DefaultRequestOptions defaultRequestOptions = this.f55427b;
            Lazy lazyB = this.f55428c;
            if (lazyB == null) {
                lazyB = LazyKt.b(new Function0<MemoryCache>() { // from class: coil.ImageLoader$Builder$build$1
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                    public final MemoryCache invoke() {
                        return new MemoryCache.Builder(this.f55435a.f55426a).a();
                    }
                });
            }
            Lazy lazyB2 = this.f55429d;
            if (lazyB2 == null) {
                lazyB2 = LazyKt.b(new Function0<DiskCache>() { // from class: coil.ImageLoader$Builder$build$2
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final DiskCache invoke() {
                        return SingletonDiskCache.f56240a.a(this.f55436a.f55426a);
                    }
                });
            }
            Lazy lazyB3 = this.f55430e;
            if (lazyB3 == null) {
                lazyB3 = LazyKt.b(new Function0<OkHttpClient>() { // from class: coil.ImageLoader$Builder$build$3
                    @Override // kotlin.jvm.functions.Function0
                    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                    public final OkHttpClient invoke() {
                        return new OkHttpClient();
                    }
                });
            }
            EventListener.Factory factory = this.f55431f;
            if (factory == null) {
                factory = EventListener.Factory.f55424b;
            }
            ComponentRegistry componentRegistry = this.f55432g;
            if (componentRegistry == null) {
                componentRegistry = new ComponentRegistry();
            }
            return new RealImageLoader(context, defaultRequestOptions, lazyB, lazyB2, lazyB3, factory, componentRegistry, this.f55433h, this.f55434i);
        }

        public final Builder c(ComponentRegistry componentRegistry) {
            this.f55432g = componentRegistry;
            return this;
        }

        public final Builder d(Function0 function0) {
            this.f55429d = LazyKt.b(function0);
            return this;
        }
    }

    DefaultRequestOptions a();

    Disposable b(ImageRequest imageRequest);

    Object c(ImageRequest imageRequest, Continuation continuation);

    MemoryCache d();

    ComponentRegistry getComponents();
}
