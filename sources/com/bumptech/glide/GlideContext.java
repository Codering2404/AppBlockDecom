package com.bumptech.glide;

import android.content.Context;
import android.content.ContextWrapper;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.Engine;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.ImageViewTargetFactory;
import com.bumptech.glide.request.target.ViewTarget;
import com.bumptech.glide.util.GlideSuppliers;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class GlideContext extends ContextWrapper {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    static final TransitionOptions f66058k = new GenericTransitionOptions();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ArrayPool f66059a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final GlideSuppliers.GlideSupplier f66060b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ImageViewTargetFactory f66061c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Glide.RequestOptionsFactory f66062d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final List f66063e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Map f66064f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Engine f66065g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final GlideExperiments f66066h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final int f66067i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private RequestOptions f66068j;

    public GlideContext(Context context, ArrayPool arrayPool, GlideSuppliers.GlideSupplier glideSupplier, ImageViewTargetFactory imageViewTargetFactory, Glide.RequestOptionsFactory requestOptionsFactory, Map map, List list, Engine engine, GlideExperiments glideExperiments, int i3) {
        super(context.getApplicationContext());
        this.f66059a = arrayPool;
        this.f66061c = imageViewTargetFactory;
        this.f66062d = requestOptionsFactory;
        this.f66063e = list;
        this.f66064f = map;
        this.f66065g = engine;
        this.f66066h = glideExperiments;
        this.f66067i = i3;
        this.f66060b = GlideSuppliers.a(glideSupplier);
    }

    public ViewTarget a(ImageView imageView, Class cls) {
        return this.f66061c.a(imageView, cls);
    }

    public ArrayPool b() {
        return this.f66059a;
    }

    public List c() {
        return this.f66063e;
    }

    public synchronized RequestOptions d() {
        try {
            if (this.f66068j == null) {
                this.f66068j = (RequestOptions) this.f66062d.build().U();
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.f66068j;
    }

    public TransitionOptions e(Class cls) {
        TransitionOptions transitionOptions = (TransitionOptions) this.f66064f.get(cls);
        if (transitionOptions == null) {
            for (Map.Entry entry : this.f66064f.entrySet()) {
                if (((Class) entry.getKey()).isAssignableFrom(cls)) {
                    transitionOptions = (TransitionOptions) entry.getValue();
                }
            }
        }
        return transitionOptions == null ? f66058k : transitionOptions;
    }

    public Engine f() {
        return this.f66065g;
    }

    public GlideExperiments g() {
        return this.f66066h;
    }

    public int h() {
        return this.f66067i;
    }

    public Registry i() {
        return (Registry) this.f66060b.get();
    }
}
