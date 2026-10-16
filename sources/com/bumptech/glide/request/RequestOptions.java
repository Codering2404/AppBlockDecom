package com.bumptech.glide.request;

import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class RequestOptions extends BaseRequestOptions<RequestOptions> {
    private static RequestOptions B;

    public static RequestOptions s0(Transformation transformation) {
        return (RequestOptions) new RequestOptions().n0(transformation);
    }

    public static RequestOptions t0() {
        if (B == null) {
            B = (RequestOptions) ((RequestOptions) new RequestOptions().c()).b();
        }
        return B;
    }

    public static RequestOptions u0(Class cls) {
        return (RequestOptions) new RequestOptions().g(cls);
    }

    public static RequestOptions v0(DiskCacheStrategy diskCacheStrategy) {
        return (RequestOptions) new RequestOptions().h(diskCacheStrategy);
    }

    public static RequestOptions w0(Key key) {
        return (RequestOptions) new RequestOptions().j0(key);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public boolean equals(Object obj) {
        return (obj instanceof RequestOptions) && super.equals(obj);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public int hashCode() {
        return super.hashCode();
    }
}
