package coil.memory;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import coil.EventListener;
import coil.ImageLoader;
import coil.decode.DataSource;
import coil.decode.DecodeUtils;
import coil.intercept.EngineInterceptor;
import coil.intercept.Interceptor;
import coil.memory.MemoryCache;
import coil.request.ImageRequest;
import coil.request.Options;
import coil.request.RequestService;
import coil.request.SuccessResult;
import coil.size.Dimension;
import coil.size.Scale;
import coil.size.Size;
import coil.size.Sizes;
import coil.transform.Transformation;
import coil.util.Bitmaps;
import coil.util.Logger;
import coil.util.Requests;
import coil.util.Utils;
import com.google.android.gms.common.api.Api;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

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
public final class MemoryCacheService {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Companion f55957d = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ImageLoader f55958a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final RequestService f55959b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Logger f55960c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public MemoryCacheService(ImageLoader imageLoader, RequestService requestService, Logger logger) {
        this.f55958a = imageLoader;
        this.f55959b = requestService;
        this.f55960c = logger;
    }

    private final String b(MemoryCache.Value value) {
        Object obj = value.b().get("coil#disk_cache_key");
        if (obj instanceof String) {
            return (String) obj;
        }
        return null;
    }

    private final boolean d(MemoryCache.Value value) {
        Object obj = value.b().get("coil#is_sampled");
        Boolean bool = obj instanceof Boolean ? (Boolean) obj : null;
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    private final boolean e(ImageRequest imageRequest, MemoryCache.Key key, MemoryCache.Value value, Size size, Scale scale) {
        double d3;
        String str;
        boolean zD = d(value);
        if (Sizes.a(size)) {
            if (!zD) {
                return true;
            }
            Logger logger = this.f55960c;
            if (logger != null && logger.getLevel() <= 3) {
                logger.a("MemoryCacheService", 3, imageRequest.m() + ": Requested original size, but cached image is sampled.", null);
            }
            return false;
        }
        String str2 = (String) key.d().get("coil#transformation_size");
        if (str2 != null) {
            return Intrinsics.areEqual(str2, size.toString());
        }
        int width = value.a().getWidth();
        int height = value.a().getHeight();
        Dimension dimensionD = size.d();
        boolean z2 = dimensionD instanceof Dimension.Pixels;
        int i3 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        int i4 = z2 ? ((Dimension.Pixels) dimensionD).f56163a : Integer.MAX_VALUE;
        Dimension dimensionC = size.c();
        if (dimensionC instanceof Dimension.Pixels) {
            i3 = ((Dimension.Pixels) dimensionC).f56163a;
        }
        double dC = DecodeUtils.c(width, height, i4, i3, scale);
        boolean zA = Requests.a(imageRequest);
        if (!zA) {
            d3 = 1.0d;
            str = "MemoryCacheService";
            if ((!Utils.t(i4) && Math.abs(i4 - width) > 1) || (!Utils.t(i3) && Math.abs(i3 - height) > 1)) {
            }
            return true;
        }
        double dI = RangesKt.i(dC, 1.0d);
        d3 = 1.0d;
        str = "MemoryCacheService";
        if (Math.abs(((double) i4) - (((double) width) * dI)) <= 1.0d || Math.abs(((double) i3) - (dI * ((double) height))) <= 1.0d) {
            return true;
        }
        if (dC != d3 && !zA) {
            Logger logger2 = this.f55960c;
            if (logger2 != null && logger2.getLevel() <= 3) {
                logger2.a(str, 3, imageRequest.m() + ": Cached image's request size (" + width + ", " + height + ") does not exactly match the requested size (" + size.d() + ", " + size.c() + ", " + scale + ").", null);
            }
            return false;
        }
        String str3 = str;
        if (dC > d3 && zD) {
            Logger logger3 = this.f55960c;
            if (logger3 != null && logger3.getLevel() <= 3) {
                logger3.a(str3, 3, imageRequest.m() + ": Cached image's request size (" + width + ", " + height + ") is smaller than the requested size (" + size.d() + ", " + size.c() + ", " + scale + ").", null);
            }
            return false;
        }
        return true;
    }

    public final MemoryCache.Value a(ImageRequest imageRequest, MemoryCache.Key key, Size size, Scale scale) {
        if (!imageRequest.C().b()) {
            return null;
        }
        MemoryCache memoryCacheD = this.f55958a.d();
        MemoryCache.Value valueB = memoryCacheD != null ? memoryCacheD.b(key) : null;
        if (valueB == null || !c(imageRequest, key, valueB, size, scale)) {
            return null;
        }
        return valueB;
    }

    public final boolean c(ImageRequest imageRequest, MemoryCache.Key key, MemoryCache.Value value, Size size, Scale scale) {
        if (this.f55959b.c(imageRequest, Bitmaps.c(value.a()))) {
            return e(imageRequest, key, value, size, scale);
        }
        Logger logger = this.f55960c;
        if (logger == null || logger.getLevel() > 3) {
            return false;
        }
        logger.a("MemoryCacheService", 3, imageRequest.m() + ": Cached bitmap is hardware-backed, which is incompatible with the request.", null);
        return false;
    }

    public final MemoryCache.Key f(ImageRequest imageRequest, Object obj, Options options, EventListener eventListener) {
        MemoryCache.Key keyB = imageRequest.B();
        if (keyB != null) {
            return keyB;
        }
        eventListener.m(imageRequest, obj);
        String strF = this.f55958a.getComponents().f(obj, options);
        eventListener.e(imageRequest, strF);
        if (strF == null) {
            return null;
        }
        List listO = imageRequest.O();
        Map mapB = imageRequest.E().b();
        if (listO.isEmpty() && mapB.isEmpty()) {
            return new MemoryCache.Key(strF, null, 2, null);
        }
        Map mutableMap = MapsKt.toMutableMap(mapB);
        if (!listO.isEmpty()) {
            List listO2 = imageRequest.O();
            int size = listO2.size();
            for (int i3 = 0; i3 < size; i3++) {
                mutableMap.put("coil#transformation_" + i3, ((Transformation) listO2.get(i3)).a());
            }
            mutableMap.put("coil#transformation_size", options.o().toString());
        }
        return new MemoryCache.Key(strF, mutableMap);
    }

    public final SuccessResult g(Interceptor.Chain chain, ImageRequest imageRequest, MemoryCache.Key key, MemoryCache.Value value) {
        return new SuccessResult(new BitmapDrawable(imageRequest.l().getResources(), value.a()), imageRequest, DataSource.MEMORY_CACHE, key, b(value), d(value), Utils.u(chain));
    }

    public final boolean h(MemoryCache.Key key, ImageRequest imageRequest, EngineInterceptor.ExecuteResult executeResult) {
        MemoryCache memoryCacheD;
        Bitmap bitmap;
        if (imageRequest.C().c() && (memoryCacheD = this.f55958a.d()) != null && key != null) {
            Drawable drawableE = executeResult.e();
            BitmapDrawable bitmapDrawable = drawableE instanceof BitmapDrawable ? (BitmapDrawable) drawableE : null;
            if (bitmapDrawable != null && (bitmap = bitmapDrawable.getBitmap()) != null) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put("coil#is_sampled", Boolean.valueOf(executeResult.f()));
                String strD = executeResult.d();
                if (strD != null) {
                    linkedHashMap.put("coil#disk_cache_key", strD);
                }
                memoryCacheD.c(key, new MemoryCache.Value(bitmap, linkedHashMap));
                return true;
            }
        }
        return false;
    }
}
