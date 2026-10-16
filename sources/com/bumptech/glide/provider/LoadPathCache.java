package com.bumptech.glide.provider;

import androidx.collection.ArrayMap;
import com.bumptech.glide.load.engine.DecodePath;
import com.bumptech.glide.load.engine.LoadPath;
import com.bumptech.glide.load.resource.transcode.UnitTranscoder;
import com.bumptech.glide.util.MultiClassKey;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class LoadPathCache {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final LoadPath f67079c = new LoadPath(Object.class, Object.class, Object.class, Collections.singletonList(new DecodePath(Object.class, Object.class, Object.class, Collections.EMPTY_LIST, new UnitTranscoder(), null)), null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ArrayMap f67080a = new ArrayMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AtomicReference f67081b = new AtomicReference();

    private MultiClassKey b(Class cls, Class cls2, Class cls3) {
        MultiClassKey multiClassKey = (MultiClassKey) this.f67081b.getAndSet(null);
        if (multiClassKey == null) {
            multiClassKey = new MultiClassKey();
        }
        multiClassKey.a(cls, cls2, cls3);
        return multiClassKey;
    }

    public LoadPath a(Class cls, Class cls2, Class cls3) {
        LoadPath loadPath;
        MultiClassKey multiClassKeyB = b(cls, cls2, cls3);
        synchronized (this.f67080a) {
            loadPath = (LoadPath) this.f67080a.get(multiClassKeyB);
        }
        this.f67081b.set(multiClassKeyB);
        return loadPath;
    }

    public boolean c(LoadPath loadPath) {
        return f67079c.equals(loadPath);
    }

    public void d(Class cls, Class cls2, Class cls3, LoadPath loadPath) {
        synchronized (this.f67080a) {
            ArrayMap arrayMap = this.f67080a;
            MultiClassKey multiClassKey = new MultiClassKey(cls, cls2, cls3);
            if (loadPath == null) {
                loadPath = f67079c;
            }
            arrayMap.put(multiClassKey, loadPath);
        }
    }
}
