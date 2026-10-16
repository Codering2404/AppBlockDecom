package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.engine.DataFetcherGenerator;
import com.bumptech.glide.load.model.ModelLoader;
import java.io.File;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
class DataCacheGenerator implements DataFetcherGenerator, DataFetcher.DataCallback<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f66321a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final DecodeHelper f66322b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final DataFetcherGenerator.FetcherReadyCallback f66323c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f66324d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Key f66325f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private List f66326g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f66327h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private volatile ModelLoader.LoadData f66328i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private File f66329j;

    DataCacheGenerator(DecodeHelper decodeHelper, DataFetcherGenerator.FetcherReadyCallback fetcherReadyCallback) {
        this(decodeHelper.c(), decodeHelper, fetcherReadyCallback);
    }

    private boolean a() {
        return this.f66327h < this.f66326g.size();
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x001b, code lost:
    
        if (a() == false) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x001d, code lost:
    
        r0 = r7.f66326g;
        r3 = r7.f66327h;
        r7.f66327h = r3 + 1;
        r7.f66328i = ((com.bumptech.glide.load.model.ModelLoader) r0.get(r3)).b(r7.f66329j, r7.f66322b.t(), r7.f66322b.f(), r7.f66322b.k());
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0047, code lost:
    
        if (r7.f66328i == null) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0057, code lost:
    
        if (r7.f66322b.u(r7.f66328i.f66731c.a()) == false) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0059, code lost:
    
        r7.f66328i.f66731c.e(r7.f66322b.l(), r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0066, code lost:
    
        r2 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x006d, code lost:
    
        return r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0012, code lost:
    
        r7.f66328i = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0015, code lost:
    
        if (r2 != false) goto L40;
     */
    @Override // com.bumptech.glide.load.engine.DataFetcherGenerator
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean b() {
        /*
            r7 = this;
            java.lang.String r0 = "DataCacheGenerator.startNext"
            com.bumptech.glide.util.pool.GlideTrace.a(r0)
        L5:
            java.util.List r0 = r7.f66326g     // Catch: java.lang.Throwable -> L68
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L6e
            boolean r0 = r7.a()     // Catch: java.lang.Throwable -> L68
            if (r0 != 0) goto L12
            goto L6e
        L12:
            r0 = 0
            r7.f66328i = r0     // Catch: java.lang.Throwable -> L68
        L15:
            if (r2 != 0) goto L6a
            boolean r0 = r7.a()     // Catch: java.lang.Throwable -> L68
            if (r0 == 0) goto L6a
            java.util.List r0 = r7.f66326g     // Catch: java.lang.Throwable -> L68
            int r3 = r7.f66327h     // Catch: java.lang.Throwable -> L68
            int r4 = r3 + 1
            r7.f66327h = r4     // Catch: java.lang.Throwable -> L68
            java.lang.Object r0 = r0.get(r3)     // Catch: java.lang.Throwable -> L68
            com.bumptech.glide.load.model.ModelLoader r0 = (com.bumptech.glide.load.model.ModelLoader) r0     // Catch: java.lang.Throwable -> L68
            java.io.File r3 = r7.f66329j     // Catch: java.lang.Throwable -> L68
            com.bumptech.glide.load.engine.DecodeHelper r4 = r7.f66322b     // Catch: java.lang.Throwable -> L68
            int r4 = r4.t()     // Catch: java.lang.Throwable -> L68
            com.bumptech.glide.load.engine.DecodeHelper r5 = r7.f66322b     // Catch: java.lang.Throwable -> L68
            int r5 = r5.f()     // Catch: java.lang.Throwable -> L68
            com.bumptech.glide.load.engine.DecodeHelper r6 = r7.f66322b     // Catch: java.lang.Throwable -> L68
            com.bumptech.glide.load.Options r6 = r6.k()     // Catch: java.lang.Throwable -> L68
            com.bumptech.glide.load.model.ModelLoader$LoadData r0 = r0.b(r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L68
            r7.f66328i = r0     // Catch: java.lang.Throwable -> L68
            com.bumptech.glide.load.model.ModelLoader$LoadData r0 = r7.f66328i     // Catch: java.lang.Throwable -> L68
            if (r0 == 0) goto L15
            com.bumptech.glide.load.engine.DecodeHelper r0 = r7.f66322b     // Catch: java.lang.Throwable -> L68
            com.bumptech.glide.load.model.ModelLoader$LoadData r3 = r7.f66328i     // Catch: java.lang.Throwable -> L68
            com.bumptech.glide.load.data.DataFetcher r3 = r3.f66731c     // Catch: java.lang.Throwable -> L68
            java.lang.Class r3 = r3.a()     // Catch: java.lang.Throwable -> L68
            boolean r0 = r0.u(r3)     // Catch: java.lang.Throwable -> L68
            if (r0 == 0) goto L15
            com.bumptech.glide.load.model.ModelLoader$LoadData r0 = r7.f66328i     // Catch: java.lang.Throwable -> L68
            com.bumptech.glide.load.data.DataFetcher r0 = r0.f66731c     // Catch: java.lang.Throwable -> L68
            com.bumptech.glide.load.engine.DecodeHelper r2 = r7.f66322b     // Catch: java.lang.Throwable -> L68
            com.bumptech.glide.Priority r2 = r2.l()     // Catch: java.lang.Throwable -> L68
            r0.e(r2, r7)     // Catch: java.lang.Throwable -> L68
            r2 = r1
            goto L15
        L68:
            r0 = move-exception
            goto Lb0
        L6a:
            com.bumptech.glide.util.pool.GlideTrace.e()
            return r2
        L6e:
            int r0 = r7.f66324d     // Catch: java.lang.Throwable -> L68
            int r0 = r0 + r1
            r7.f66324d = r0     // Catch: java.lang.Throwable -> L68
            java.util.List r1 = r7.f66321a     // Catch: java.lang.Throwable -> L68
            int r1 = r1.size()     // Catch: java.lang.Throwable -> L68
            if (r0 < r1) goto L7f
            com.bumptech.glide.util.pool.GlideTrace.e()
            return r2
        L7f:
            java.util.List r0 = r7.f66321a     // Catch: java.lang.Throwable -> L68
            int r1 = r7.f66324d     // Catch: java.lang.Throwable -> L68
            java.lang.Object r0 = r0.get(r1)     // Catch: java.lang.Throwable -> L68
            com.bumptech.glide.load.Key r0 = (com.bumptech.glide.load.Key) r0     // Catch: java.lang.Throwable -> L68
            com.bumptech.glide.load.engine.DataCacheKey r1 = new com.bumptech.glide.load.engine.DataCacheKey     // Catch: java.lang.Throwable -> L68
            com.bumptech.glide.load.engine.DecodeHelper r3 = r7.f66322b     // Catch: java.lang.Throwable -> L68
            com.bumptech.glide.load.Key r3 = r3.p()     // Catch: java.lang.Throwable -> L68
            r1.<init>(r0, r3)     // Catch: java.lang.Throwable -> L68
            com.bumptech.glide.load.engine.DecodeHelper r3 = r7.f66322b     // Catch: java.lang.Throwable -> L68
            com.bumptech.glide.load.engine.cache.DiskCache r3 = r3.d()     // Catch: java.lang.Throwable -> L68
            java.io.File r1 = r3.b(r1)     // Catch: java.lang.Throwable -> L68
            r7.f66329j = r1     // Catch: java.lang.Throwable -> L68
            if (r1 == 0) goto L5
            r7.f66325f = r0     // Catch: java.lang.Throwable -> L68
            com.bumptech.glide.load.engine.DecodeHelper r0 = r7.f66322b     // Catch: java.lang.Throwable -> L68
            java.util.List r0 = r0.j(r1)     // Catch: java.lang.Throwable -> L68
            r7.f66326g = r0     // Catch: java.lang.Throwable -> L68
            r7.f66327h = r2     // Catch: java.lang.Throwable -> L68
            goto L5
        Lb0:
            com.bumptech.glide.util.pool.GlideTrace.e()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.engine.DataCacheGenerator.b():boolean");
    }

    @Override // com.bumptech.glide.load.data.DataFetcher.DataCallback
    public void c(Exception exc) {
        this.f66323c.a(this.f66325f, exc, this.f66328i.f66731c, DataSource.DATA_DISK_CACHE);
    }

    @Override // com.bumptech.glide.load.engine.DataFetcherGenerator
    public void cancel() {
        ModelLoader.LoadData loadData = this.f66328i;
        if (loadData != null) {
            loadData.f66731c.cancel();
        }
    }

    @Override // com.bumptech.glide.load.data.DataFetcher.DataCallback
    public void f(Object obj) {
        this.f66323c.e(this.f66325f, obj, this.f66328i.f66731c, DataSource.DATA_DISK_CACHE, this.f66325f);
    }

    DataCacheGenerator(List list, DecodeHelper decodeHelper, DataFetcherGenerator.FetcherReadyCallback fetcherReadyCallback) {
        this.f66324d = -1;
        this.f66321a = list;
        this.f66322b = decodeHelper;
        this.f66323c = fetcherReadyCallback;
    }
}
