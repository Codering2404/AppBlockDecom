package com.bumptech.glide.load.model.stream;

import android.text.TextUtils;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.Headers;
import com.bumptech.glide.load.model.ModelCache;
import com.bumptech.glide.load.model.ModelLoader;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class BaseGlideUrlLoader<Model> implements ModelLoader<Model, InputStream> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ModelLoader f66779a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ModelCache f66780b;

    private static List c(Collection collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(new GlideUrl((String) it.next()));
        }
        return arrayList;
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public ModelLoader.LoadData b(Object obj, int i3, int i4, Options options) {
        ModelCache modelCache = this.f66780b;
        GlideUrl glideUrl = modelCache != null ? (GlideUrl) modelCache.a(obj, i3, i4) : null;
        if (glideUrl == null) {
            String strF = f(obj, i3, i4, options);
            if (TextUtils.isEmpty(strF)) {
                return null;
            }
            GlideUrl glideUrl2 = new GlideUrl(strF, e(obj, i3, i4, options));
            ModelCache modelCache2 = this.f66780b;
            if (modelCache2 != null) {
                modelCache2.b(obj, i3, i4, glideUrl2);
            }
            glideUrl = glideUrl2;
        }
        List listD = d(obj, i3, i4, options);
        ModelLoader.LoadData loadDataB = this.f66779a.b(glideUrl, i3, i4, options);
        return (loadDataB == null || listD.isEmpty()) ? loadDataB : new ModelLoader.LoadData(loadDataB.f66729a, c(listD), loadDataB.f66731c);
    }

    protected List d(Object obj, int i3, int i4, Options options) {
        return Collections.EMPTY_LIST;
    }

    protected Headers e(Object obj, int i3, int i4, Options options) {
        return Headers.f66709b;
    }

    protected abstract String f(Object obj, int i3, int i4, Options options);
}
