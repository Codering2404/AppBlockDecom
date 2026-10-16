package com.bumptech.glide.provider;

import androidx.collection.ArrayMap;
import com.bumptech.glide.util.MultiClassKey;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class ModelToResourceClassCache {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AtomicReference f67082a = new AtomicReference();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ArrayMap f67083b = new ArrayMap();

    public List a(Class cls, Class cls2, Class cls3) {
        List list;
        MultiClassKey multiClassKey = (MultiClassKey) this.f67082a.getAndSet(null);
        if (multiClassKey == null) {
            multiClassKey = new MultiClassKey(cls, cls2, cls3);
        } else {
            multiClassKey.a(cls, cls2, cls3);
        }
        synchronized (this.f67083b) {
            list = (List) this.f67083b.get(multiClassKey);
        }
        this.f67082a.set(multiClassKey);
        return list;
    }

    public void b(Class cls, Class cls2, Class cls3, List list) {
        synchronized (this.f67083b) {
            this.f67083b.put(new MultiClassKey(cls, cls2, cls3), list);
        }
    }
}
