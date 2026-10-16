package com.bumptech.glide.load.engine;

import android.util.Log;
import androidx.core.util.Pools;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.data.DataRewinder;
import com.bumptech.glide.load.resource.transcode.ResourceTranscoder;
import com.bumptech.glide.util.Preconditions;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class DecodePath<DataType, ResourceType, Transcode> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Class f66400a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List f66401b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ResourceTranscoder f66402c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Pools.Pool f66403d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f66404e;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    interface DecodeCallback<ResourceType> {
        Resource a(Resource resource);
    }

    public DecodePath(Class cls, Class cls2, Class cls3, List list, ResourceTranscoder resourceTranscoder, Pools.Pool pool) {
        this.f66400a = cls;
        this.f66401b = list;
        this.f66402c = resourceTranscoder;
        this.f66403d = pool;
        this.f66404e = "Failed DecodePath{" + cls.getSimpleName() + "->" + cls2.getSimpleName() + "->" + cls3.getSimpleName() + "}";
    }

    private Resource b(DataRewinder dataRewinder, int i3, int i4, Options options) {
        List list = (List) Preconditions.e((List) this.f66403d.a());
        try {
            return c(dataRewinder, i3, i4, options, list);
        } finally {
            this.f66403d.b(list);
        }
    }

    private Resource c(DataRewinder dataRewinder, int i3, int i4, Options options, List list) throws GlideException {
        int size = this.f66401b.size();
        Resource resourceB = null;
        for (int i5 = 0; i5 < size; i5++) {
            ResourceDecoder resourceDecoder = (ResourceDecoder) this.f66401b.get(i5);
            try {
                if (resourceDecoder.a(dataRewinder.a(), options)) {
                    resourceB = resourceDecoder.b(dataRewinder.a(), i3, i4, options);
                }
            } catch (IOException | OutOfMemoryError | RuntimeException e3) {
                if (Log.isLoggable("DecodePath", 2)) {
                    Log.v("DecodePath", "Failed to decode data for " + resourceDecoder, e3);
                }
                list.add(e3);
            }
            if (resourceB != null) {
                break;
            }
        }
        if (resourceB != null) {
            return resourceB;
        }
        throw new GlideException(this.f66404e, new ArrayList(list));
    }

    public Resource a(DataRewinder dataRewinder, int i3, int i4, Options options, DecodeCallback decodeCallback) {
        return this.f66402c.a(decodeCallback.a(b(dataRewinder, i3, i4, options)), options);
    }

    public String toString() {
        return "DecodePath{ dataClass=" + this.f66400a + ", decoders=" + this.f66401b + ", transcoder=" + this.f66402c + '}';
    }
}
