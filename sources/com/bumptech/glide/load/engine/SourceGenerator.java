package com.bumptech.glide.load.engine;

import android.util.Log;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.data.DataRewinder;
import com.bumptech.glide.load.engine.DataFetcherGenerator;
import com.bumptech.glide.load.engine.cache.DiskCache;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.util.LogTime;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
class SourceGenerator implements DataFetcherGenerator, DataFetcherGenerator.FetcherReadyCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final DecodeHelper f66525a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final DataFetcherGenerator.FetcherReadyCallback f66526b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile int f66527c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile DataCacheGenerator f66528d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private volatile Object f66529f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private volatile ModelLoader.LoadData f66530g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private volatile DataCacheKey f66531h;

    SourceGenerator(DecodeHelper decodeHelper, DataFetcherGenerator.FetcherReadyCallback fetcherReadyCallback) {
        this.f66525a = decodeHelper;
        this.f66526b = fetcherReadyCallback;
    }

    private boolean d(Object obj) throws Throwable {
        Throwable th;
        long jB = LogTime.b();
        boolean z2 = false;
        try {
            DataRewinder dataRewinderO = this.f66525a.o(obj);
            Object objA = dataRewinderO.a();
            Encoder encoderQ = this.f66525a.q(objA);
            DataCacheWriter dataCacheWriter = new DataCacheWriter(encoderQ, objA, this.f66525a.k());
            DataCacheKey dataCacheKey = new DataCacheKey(this.f66530g.f66729a, this.f66525a.p());
            DiskCache diskCacheD = this.f66525a.d();
            diskCacheD.a(dataCacheKey, dataCacheWriter);
            if (Log.isLoggable("SourceGenerator", 2)) {
                Log.v("SourceGenerator", "Finished encoding source to cache, key: " + dataCacheKey + ", data: " + obj + ", encoder: " + encoderQ + ", duration: " + LogTime.a(jB));
            }
            if (diskCacheD.b(dataCacheKey) != null) {
                this.f66531h = dataCacheKey;
                this.f66528d = new DataCacheGenerator(Collections.singletonList(this.f66530g.f66729a), this.f66525a, this);
                this.f66530g.f66731c.b();
                return true;
            }
            if (Log.isLoggable("SourceGenerator", 3)) {
                Log.d("SourceGenerator", "Attempt to write: " + this.f66531h + ", data: " + obj + " to the disk cache failed, maybe the disk cache is disabled? Trying to decode the data directly...");
            }
            try {
                this.f66526b.e(this.f66530g.f66729a, dataRewinderO.a(), this.f66530g.f66731c, this.f66530g.f66731c.d(), this.f66530g.f66729a);
                return false;
            } catch (Throwable th2) {
                th = th2;
                z2 = true;
                if (z2) {
                    throw th;
                }
                this.f66530g.f66731c.b();
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    private boolean f() {
        return this.f66527c < this.f66525a.g().size();
    }

    private void j(final ModelLoader.LoadData loadData) {
        this.f66530g.f66731c.e(this.f66525a.l(), new DataFetcher.DataCallback<Object>() { // from class: com.bumptech.glide.load.engine.SourceGenerator.1
            @Override // com.bumptech.glide.load.data.DataFetcher.DataCallback
            public void c(Exception exc) {
                if (SourceGenerator.this.g(loadData)) {
                    SourceGenerator.this.i(loadData, exc);
                }
            }

            @Override // com.bumptech.glide.load.data.DataFetcher.DataCallback
            public void f(Object obj) {
                if (SourceGenerator.this.g(loadData)) {
                    SourceGenerator.this.h(loadData, obj);
                }
            }
        });
    }

    @Override // com.bumptech.glide.load.engine.DataFetcherGenerator.FetcherReadyCallback
    public void a(Key key, Exception exc, DataFetcher dataFetcher, DataSource dataSource) {
        this.f66526b.a(key, exc, dataFetcher, this.f66530g.f66731c.d());
    }

    @Override // com.bumptech.glide.load.engine.DataFetcherGenerator
    public boolean b() {
        if (this.f66529f != null) {
            Object obj = this.f66529f;
            this.f66529f = null;
            try {
                if (!d(obj)) {
                    return true;
                }
            } catch (IOException e3) {
                if (Log.isLoggable("SourceGenerator", 3)) {
                    Log.d("SourceGenerator", "Failed to properly rewind or write data to cache", e3);
                }
            }
        }
        if (this.f66528d != null && this.f66528d.b()) {
            return true;
        }
        this.f66528d = null;
        this.f66530g = null;
        boolean z2 = false;
        while (!z2 && f()) {
            List listG = this.f66525a.g();
            int i3 = this.f66527c;
            this.f66527c = i3 + 1;
            this.f66530g = (ModelLoader.LoadData) listG.get(i3);
            if (this.f66530g != null && (this.f66525a.e().c(this.f66530g.f66731c.d()) || this.f66525a.u(this.f66530g.f66731c.a()))) {
                j(this.f66530g);
                z2 = true;
            }
        }
        return z2;
    }

    @Override // com.bumptech.glide.load.engine.DataFetcherGenerator.FetcherReadyCallback
    public void c() {
        throw new UnsupportedOperationException();
    }

    @Override // com.bumptech.glide.load.engine.DataFetcherGenerator
    public void cancel() {
        ModelLoader.LoadData loadData = this.f66530g;
        if (loadData != null) {
            loadData.f66731c.cancel();
        }
    }

    @Override // com.bumptech.glide.load.engine.DataFetcherGenerator.FetcherReadyCallback
    public void e(Key key, Object obj, DataFetcher dataFetcher, DataSource dataSource, Key key2) {
        this.f66526b.e(key, obj, dataFetcher, this.f66530g.f66731c.d(), key);
    }

    boolean g(ModelLoader.LoadData loadData) {
        ModelLoader.LoadData loadData2 = this.f66530g;
        return loadData2 != null && loadData2 == loadData;
    }

    void h(ModelLoader.LoadData loadData, Object obj) {
        DiskCacheStrategy diskCacheStrategyE = this.f66525a.e();
        if (obj != null && diskCacheStrategyE.c(loadData.f66731c.d())) {
            this.f66529f = obj;
            this.f66526b.c();
        } else {
            DataFetcherGenerator.FetcherReadyCallback fetcherReadyCallback = this.f66526b;
            Key key = loadData.f66729a;
            DataFetcher dataFetcher = loadData.f66731c;
            fetcherReadyCallback.e(key, obj, dataFetcher, dataFetcher.d(), this.f66531h);
        }
    }

    void i(ModelLoader.LoadData loadData, Exception exc) {
        DataFetcherGenerator.FetcherReadyCallback fetcherReadyCallback = this.f66526b;
        DataCacheKey dataCacheKey = this.f66531h;
        DataFetcher dataFetcher = loadData.f66731c;
        fetcherReadyCallback.a(dataCacheKey, exc, dataFetcher, dataFetcher.d());
    }
}
