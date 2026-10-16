package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.engine.DataFetcherGenerator;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.util.pool.GlideTrace;
import java.io.File;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
class ResourceCacheGenerator implements DataFetcherGenerator, DataFetcher.DataCallback<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final DataFetcherGenerator.FetcherReadyCallback f66504a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final DecodeHelper f66505b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f66506c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f66507d = -1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Key f66508f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private List f66509g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f66510h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private volatile ModelLoader.LoadData f66511i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private File f66512j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private ResourceCacheKey f66513k;

    ResourceCacheGenerator(DecodeHelper decodeHelper, DataFetcherGenerator.FetcherReadyCallback fetcherReadyCallback) {
        this.f66505b = decodeHelper;
        this.f66504a = fetcherReadyCallback;
    }

    private boolean a() {
        return this.f66510h < this.f66509g.size();
    }

    @Override // com.bumptech.glide.load.engine.DataFetcherGenerator
    public boolean b() {
        GlideTrace.a("ResourceCacheGenerator.startNext");
        try {
            List listC = this.f66505b.c();
            boolean z2 = false;
            if (listC.isEmpty()) {
                GlideTrace.e();
                return false;
            }
            List listM = this.f66505b.m();
            if (listM.isEmpty()) {
                if (File.class.equals(this.f66505b.r())) {
                    GlideTrace.e();
                    return false;
                }
                throw new IllegalStateException("Failed to find any load path from " + this.f66505b.i() + " to " + this.f66505b.r());
            }
            while (true) {
                if (this.f66509g != null && a()) {
                    this.f66511i = null;
                    while (!z2 && a()) {
                        List list = this.f66509g;
                        int i3 = this.f66510h;
                        this.f66510h = i3 + 1;
                        this.f66511i = ((ModelLoader) list.get(i3)).b(this.f66512j, this.f66505b.t(), this.f66505b.f(), this.f66505b.k());
                        if (this.f66511i != null && this.f66505b.u(this.f66511i.f66731c.a())) {
                            this.f66511i.f66731c.e(this.f66505b.l(), this);
                            z2 = true;
                        }
                    }
                    GlideTrace.e();
                    return z2;
                }
                int i4 = this.f66507d + 1;
                this.f66507d = i4;
                if (i4 >= listM.size()) {
                    int i5 = this.f66506c + 1;
                    this.f66506c = i5;
                    if (i5 >= listC.size()) {
                        GlideTrace.e();
                        return false;
                    }
                    this.f66507d = 0;
                }
                Key key = (Key) listC.get(this.f66506c);
                Class cls = (Class) listM.get(this.f66507d);
                this.f66513k = new ResourceCacheKey(this.f66505b.b(), key, this.f66505b.p(), this.f66505b.t(), this.f66505b.f(), this.f66505b.s(cls), cls, this.f66505b.k());
                File fileB = this.f66505b.d().b(this.f66513k);
                this.f66512j = fileB;
                if (fileB != null) {
                    this.f66508f = key;
                    this.f66509g = this.f66505b.j(fileB);
                    this.f66510h = 0;
                }
            }
        } catch (Throwable th) {
            GlideTrace.e();
            throw th;
        }
    }

    @Override // com.bumptech.glide.load.data.DataFetcher.DataCallback
    public void c(Exception exc) {
        this.f66504a.a(this.f66513k, exc, this.f66511i.f66731c, DataSource.RESOURCE_DISK_CACHE);
    }

    @Override // com.bumptech.glide.load.engine.DataFetcherGenerator
    public void cancel() {
        ModelLoader.LoadData loadData = this.f66511i;
        if (loadData != null) {
            loadData.f66731c.cancel();
        }
    }

    @Override // com.bumptech.glide.load.data.DataFetcher.DataCallback
    public void f(Object obj) {
        this.f66504a.e(this.f66508f, obj, this.f66511i.f66731c, DataSource.RESOURCE_DISK_CACHE, this.f66513k);
    }
}
