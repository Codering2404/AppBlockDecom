package com.bumptech.glide.load.resource;

import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.util.Preconditions;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class SimpleResource<T> implements Resource<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final Object f66814a;

    public SimpleResource(Object obj) {
        this.f66814a = Preconditions.e(obj);
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public Class b() {
        return this.f66814a.getClass();
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public final Object get() {
        return this.f66814a;
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public final int getSize() {
        return 1;
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public void a() {
    }
}
