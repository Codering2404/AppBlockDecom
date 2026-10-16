package com.bumptech.glide.load.engine;

import androidx.core.util.Pools;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataRewinder;
import com.bumptech.glide.load.engine.DecodePath;
import com.bumptech.glide.util.Preconditions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class LoadPath<Data, ResourceType, Transcode> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Class f66495a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Pools.Pool f66496b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List f66497c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f66498d;

    public LoadPath(Class cls, Class cls2, Class cls3, List list, Pools.Pool pool) {
        this.f66495a = cls;
        this.f66496b = pool;
        this.f66497c = (List) Preconditions.d(list);
        this.f66498d = "Failed LoadPath{" + cls.getSimpleName() + "->" + cls2.getSimpleName() + "->" + cls3.getSimpleName() + "}";
    }

    private Resource b(DataRewinder dataRewinder, Options options, int i3, int i4, DecodePath.DecodeCallback decodeCallback, List list) throws GlideException {
        int size = this.f66497c.size();
        Resource resourceA = null;
        for (int i5 = 0; i5 < size; i5++) {
            try {
                resourceA = ((DecodePath) this.f66497c.get(i5)).a(dataRewinder, i3, i4, options, decodeCallback);
            } catch (GlideException e3) {
                list.add(e3);
            }
            if (resourceA != null) {
                break;
            }
        }
        if (resourceA != null) {
            return resourceA;
        }
        throw new GlideException(this.f66498d, new ArrayList(list));
    }

    public Resource a(DataRewinder dataRewinder, Options options, int i3, int i4, DecodePath.DecodeCallback decodeCallback) {
        List list = (List) Preconditions.e((List) this.f66496b.a());
        try {
            return b(dataRewinder, options, i3, i4, decodeCallback, list);
        } finally {
            this.f66496b.b(list);
        }
    }

    public String toString() {
        return "LoadPath{decodePaths=" + Arrays.toString(this.f66497c.toArray()) + '}';
    }
}
