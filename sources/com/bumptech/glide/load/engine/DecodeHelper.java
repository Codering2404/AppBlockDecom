package com.bumptech.glide.load.engine;

import com.bumptech.glide.GlideContext;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.data.DataRewinder;
import com.bumptech.glide.load.engine.DecodeJob;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.engine.cache.DiskCache;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.resource.UnitTransformation;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class DecodeHelper<Transcode> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f66335a = new ArrayList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List f66336b = new ArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private GlideContext f66337c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Object f66338d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f66339e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f66340f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Class f66341g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private DecodeJob.DiskCacheProvider f66342h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Options f66343i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Map f66344j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private Class f66345k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f66346l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f66347m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private Key f66348n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private Priority f66349o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private DiskCacheStrategy f66350p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f66351q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private boolean f66352r;

    DecodeHelper() {
    }

    void a() {
        this.f66337c = null;
        this.f66338d = null;
        this.f66348n = null;
        this.f66341g = null;
        this.f66345k = null;
        this.f66343i = null;
        this.f66349o = null;
        this.f66344j = null;
        this.f66350p = null;
        this.f66335a.clear();
        this.f66346l = false;
        this.f66336b.clear();
        this.f66347m = false;
    }

    ArrayPool b() {
        return this.f66337c.b();
    }

    List c() {
        if (!this.f66347m) {
            this.f66347m = true;
            this.f66336b.clear();
            List listG = g();
            int size = listG.size();
            for (int i3 = 0; i3 < size; i3++) {
                ModelLoader.LoadData loadData = (ModelLoader.LoadData) listG.get(i3);
                if (!this.f66336b.contains(loadData.f66729a)) {
                    this.f66336b.add(loadData.f66729a);
                }
                for (int i4 = 0; i4 < loadData.f66730b.size(); i4++) {
                    if (!this.f66336b.contains(loadData.f66730b.get(i4))) {
                        this.f66336b.add((Key) loadData.f66730b.get(i4));
                    }
                }
            }
        }
        return this.f66336b;
    }

    DiskCache d() {
        return this.f66342h.a();
    }

    DiskCacheStrategy e() {
        return this.f66350p;
    }

    int f() {
        return this.f66340f;
    }

    List g() {
        if (!this.f66346l) {
            this.f66346l = true;
            this.f66335a.clear();
            List listI = this.f66337c.i().i(this.f66338d);
            int size = listI.size();
            for (int i3 = 0; i3 < size; i3++) {
                ModelLoader.LoadData loadDataB = ((ModelLoader) listI.get(i3)).b(this.f66338d, this.f66339e, this.f66340f, this.f66343i);
                if (loadDataB != null) {
                    this.f66335a.add(loadDataB);
                }
            }
        }
        return this.f66335a;
    }

    LoadPath h(Class cls) {
        return this.f66337c.i().h(cls, this.f66341g, this.f66345k);
    }

    Class i() {
        return this.f66338d.getClass();
    }

    List j(File file) {
        return this.f66337c.i().i(file);
    }

    Options k() {
        return this.f66343i;
    }

    Priority l() {
        return this.f66349o;
    }

    List m() {
        return this.f66337c.i().j(this.f66338d.getClass(), this.f66341g, this.f66345k);
    }

    ResourceEncoder n(Resource resource) {
        return this.f66337c.i().k(resource);
    }

    DataRewinder o(Object obj) {
        return this.f66337c.i().l(obj);
    }

    Key p() {
        return this.f66348n;
    }

    Encoder q(Object obj) {
        return this.f66337c.i().m(obj);
    }

    Class r() {
        return this.f66345k;
    }

    Transformation s(Class cls) {
        Transformation transformation = (Transformation) this.f66344j.get(cls);
        if (transformation == null) {
            Iterator it = this.f66344j.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry entry = (Map.Entry) it.next();
                if (((Class) entry.getKey()).isAssignableFrom(cls)) {
                    transformation = (Transformation) entry.getValue();
                    break;
                }
            }
        }
        if (transformation != null) {
            return transformation;
        }
        if (!this.f66344j.isEmpty() || !this.f66351q) {
            return UnitTransformation.c();
        }
        throw new IllegalArgumentException("Missing transformation for " + cls + ". If you wish to ignore unknown resource types, use the optional transformation methods.");
    }

    int t() {
        return this.f66339e;
    }

    boolean u(Class cls) {
        return h(cls) != null;
    }

    void v(GlideContext glideContext, Object obj, Key key, int i3, int i4, DiskCacheStrategy diskCacheStrategy, Class cls, Class cls2, Priority priority, Options options, Map map, boolean z2, boolean z3, DecodeJob.DiskCacheProvider diskCacheProvider) {
        this.f66337c = glideContext;
        this.f66338d = obj;
        this.f66348n = key;
        this.f66339e = i3;
        this.f66340f = i4;
        this.f66350p = diskCacheStrategy;
        this.f66341g = cls;
        this.f66342h = diskCacheProvider;
        this.f66345k = cls2;
        this.f66349o = priority;
        this.f66343i = options;
        this.f66344j = map;
        this.f66351q = z2;
        this.f66352r = z3;
    }

    boolean w(Resource resource) {
        return this.f66337c.i().n(resource);
    }

    boolean x() {
        return this.f66352r;
    }

    boolean y(Key key) {
        List listG = g();
        int size = listG.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (((ModelLoader.LoadData) listG.get(i3)).f66729a.equals(key)) {
                return true;
            }
        }
        return false;
    }
}
