package com.bumptech.glide;

import android.content.Context;
import androidx.collection.ArrayMap;
import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideExperiments;
import com.bumptech.glide.load.engine.Engine;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPoolAdapter;
import com.bumptech.glide.load.engine.bitmap_recycle.LruArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool;
import com.bumptech.glide.load.engine.cache.DiskCache;
import com.bumptech.glide.load.engine.cache.InternalCacheDiskCacheFactory;
import com.bumptech.glide.load.engine.cache.LruResourceCache;
import com.bumptech.glide.load.engine.cache.MemoryCache;
import com.bumptech.glide.load.engine.cache.MemorySizeCalculator;
import com.bumptech.glide.load.engine.executor.GlideExecutor;
import com.bumptech.glide.manager.ConnectivityMonitorFactory;
import com.bumptech.glide.manager.DefaultConnectivityMonitorFactory;
import com.bumptech.glide.manager.RequestManagerRetriever;
import com.bumptech.glide.module.AppGlideModule;
import com.bumptech.glide.request.RequestOptions;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class GlideBuilder {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Engine f66041c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private BitmapPool f66042d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ArrayPool f66043e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private MemoryCache f66044f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private GlideExecutor f66045g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private GlideExecutor f66046h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private DiskCache.Factory f66047i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private MemorySizeCalculator f66048j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private ConnectivityMonitorFactory f66049k;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private RequestManagerRetriever.RequestManagerFactory f66052n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private GlideExecutor f66053o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f66054p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private List f66055q;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map f66039a = new ArrayMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final GlideExperiments.Builder f66040b = new GlideExperiments.Builder();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f66050l = 4;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private Glide.RequestOptionsFactory f66051m = new Glide.RequestOptionsFactory() { // from class: com.bumptech.glide.GlideBuilder.1
        @Override // com.bumptech.glide.Glide.RequestOptionsFactory
        public RequestOptions build() {
            return new RequestOptions();
        }
    };

    /* JADX INFO: renamed from: com.bumptech.glide.GlideBuilder$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass2 implements Glide.RequestOptionsFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ RequestOptions f66057a;

        @Override // com.bumptech.glide.Glide.RequestOptionsFactory
        public RequestOptions build() {
            RequestOptions requestOptions = this.f66057a;
            return requestOptions != null ? requestOptions : new RequestOptions();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class EnableImageDecoderForBitmaps implements GlideExperiments.Experiment {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class LogRequestOrigins implements GlideExperiments.Experiment {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class ManualOverrideHardwareBitmapMaxFdCount implements GlideExperiments.Experiment {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class OverrideGlideThreadPriority implements GlideExperiments.Experiment {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class UseMediaStoreOpenFileApisIfPossible implements GlideExperiments.Experiment {
    }

    Glide a(Context context, List list, AppGlideModule appGlideModule) {
        if (this.f66045g == null) {
            this.f66045g = GlideExecutor.l();
        }
        if (this.f66046h == null) {
            this.f66046h = GlideExecutor.j();
        }
        if (this.f66053o == null) {
            this.f66053o = GlideExecutor.f();
        }
        if (this.f66048j == null) {
            this.f66048j = new MemorySizeCalculator.Builder(context).a();
        }
        if (this.f66049k == null) {
            this.f66049k = new DefaultConnectivityMonitorFactory();
        }
        if (this.f66042d == null) {
            int iB = this.f66048j.b();
            if (iB > 0) {
                this.f66042d = new LruBitmapPool(iB);
            } else {
                this.f66042d = new BitmapPoolAdapter();
            }
        }
        if (this.f66043e == null) {
            this.f66043e = new LruArrayPool(this.f66048j.a());
        }
        if (this.f66044f == null) {
            this.f66044f = new LruResourceCache(this.f66048j.d());
        }
        if (this.f66047i == null) {
            this.f66047i = new InternalCacheDiskCacheFactory(context);
        }
        if (this.f66041c == null) {
            this.f66041c = new Engine(this.f66044f, this.f66047i, this.f66046h, this.f66045g, GlideExecutor.m(), this.f66053o, this.f66054p);
        }
        List list2 = this.f66055q;
        if (list2 == null) {
            this.f66055q = Collections.EMPTY_LIST;
        } else {
            this.f66055q = Collections.unmodifiableList(list2);
        }
        return new Glide(context, this.f66041c, this.f66044f, this.f66042d, this.f66043e, new RequestManagerRetriever(this.f66052n), this.f66049k, this.f66050l, this.f66051m, this.f66039a, this.f66055q, list, appGlideModule, this.f66040b.b());
    }

    void b(RequestManagerRetriever.RequestManagerFactory requestManagerFactory) {
        this.f66052n = requestManagerFactory;
    }
}
