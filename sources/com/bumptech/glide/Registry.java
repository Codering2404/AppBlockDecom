package com.bumptech.glide;

import androidx.core.util.Pools;
import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.data.DataRewinder;
import com.bumptech.glide.load.data.DataRewinderRegistry;
import com.bumptech.glide.load.engine.DecodePath;
import com.bumptech.glide.load.engine.LoadPath;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.ModelLoaderRegistry;
import com.bumptech.glide.load.resource.transcode.ResourceTranscoder;
import com.bumptech.glide.load.resource.transcode.TranscoderRegistry;
import com.bumptech.glide.provider.EncoderRegistry;
import com.bumptech.glide.provider.ImageHeaderParserRegistry;
import com.bumptech.glide.provider.LoadPathCache;
import com.bumptech.glide.provider.ModelToResourceClassCache;
import com.bumptech.glide.provider.ResourceDecoderRegistry;
import com.bumptech.glide.provider.ResourceEncoderRegistry;
import com.bumptech.glide.util.pool.FactoryPools;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class Registry {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ModelLoaderRegistry f66096a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final EncoderRegistry f66097b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ResourceDecoderRegistry f66098c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ResourceEncoderRegistry f66099d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final DataRewinderRegistry f66100e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final TranscoderRegistry f66101f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final ImageHeaderParserRegistry f66102g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final ModelToResourceClassCache f66103h = new ModelToResourceClassCache();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final LoadPathCache f66104i = new LoadPathCache();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Pools.Pool f66105j;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class MissingComponentException extends RuntimeException {
        public MissingComponentException(String str) {
            super(str);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class NoImageHeaderParserException extends MissingComponentException {
        public NoImageHeaderParserException() {
            super("Failed to find image header parser.");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class NoModelLoaderAvailableException extends MissingComponentException {
        public NoModelLoaderAvailableException(Object obj) {
            super("Failed to find any ModelLoaders registered for model class: " + obj.getClass());
        }

        public NoModelLoaderAvailableException(Object obj, List list) {
            super("Found ModelLoaders for model class: " + list + ", but none that handle this specific model instance: " + obj);
        }

        public NoModelLoaderAvailableException(Class cls, Class cls2) {
            super("Failed to find any ModelLoaders for model: " + cls + " and data: " + cls2);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class NoResultEncoderAvailableException extends MissingComponentException {
        public NoResultEncoderAvailableException(Class cls) {
            super("Failed to find result encoder for resource class: " + cls + ", you may need to consider registering a new Encoder for the requested type or DiskCacheStrategy.DATA/DiskCacheStrategy.NONE if caching your transformed resource is unnecessary.");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class NoSourceEncoderAvailableException extends MissingComponentException {
        public NoSourceEncoderAvailableException(Class cls) {
            super("Failed to find source encoder for data class: " + cls);
        }
    }

    public Registry() {
        Pools.Pool poolE = FactoryPools.e();
        this.f66105j = poolE;
        this.f66096a = new ModelLoaderRegistry(poolE);
        this.f66097b = new EncoderRegistry();
        this.f66098c = new ResourceDecoderRegistry();
        this.f66099d = new ResourceEncoderRegistry();
        this.f66100e = new DataRewinderRegistry();
        this.f66101f = new TranscoderRegistry();
        this.f66102g = new ImageHeaderParserRegistry();
        s(Arrays.asList("Animation", "Bitmap", "BitmapDrawable"));
    }

    private List f(Class cls, Class cls2, Class cls3) {
        ArrayList arrayList = new ArrayList();
        for (Class cls4 : this.f66098c.d(cls, cls2)) {
            for (Class cls5 : this.f66101f.b(cls4, cls3)) {
                arrayList.add(new DecodePath(cls, cls4, cls5, this.f66098c.b(cls, cls4), this.f66101f.a(cls4, cls5), this.f66105j));
            }
        }
        return arrayList;
    }

    public Registry a(Class cls, Encoder encoder) {
        this.f66097b.a(cls, encoder);
        return this;
    }

    public Registry b(Class cls, ResourceEncoder resourceEncoder) {
        this.f66099d.a(cls, resourceEncoder);
        return this;
    }

    public Registry c(Class cls, Class cls2, ResourceDecoder resourceDecoder) {
        e("legacy_append", cls, cls2, resourceDecoder);
        return this;
    }

    public Registry d(Class cls, Class cls2, ModelLoaderFactory modelLoaderFactory) {
        this.f66096a.a(cls, cls2, modelLoaderFactory);
        return this;
    }

    public Registry e(String str, Class cls, Class cls2, ResourceDecoder resourceDecoder) {
        this.f66098c.a(str, resourceDecoder, cls, cls2);
        return this;
    }

    public List g() {
        List listB = this.f66102g.b();
        if (listB.isEmpty()) {
            throw new NoImageHeaderParserException();
        }
        return listB;
    }

    public LoadPath h(Class cls, Class cls2, Class cls3) {
        Class cls4;
        Class cls5;
        Class cls6;
        LoadPath loadPathA = this.f66104i.a(cls, cls2, cls3);
        LoadPath loadPath = null;
        if (this.f66104i.c(loadPathA)) {
            return null;
        }
        if (loadPathA != null) {
            return loadPathA;
        }
        List listF = f(cls, cls2, cls3);
        if (listF.isEmpty()) {
            cls4 = cls;
            cls5 = cls2;
            cls6 = cls3;
        } else {
            cls4 = cls;
            cls5 = cls2;
            cls6 = cls3;
            loadPath = new LoadPath(cls4, cls5, cls6, listF, this.f66105j);
        }
        this.f66104i.d(cls4, cls5, cls6, loadPath);
        return loadPath;
    }

    public List i(Object obj) {
        return this.f66096a.d(obj);
    }

    public List j(Class cls, Class cls2, Class cls3) {
        List listA = this.f66103h.a(cls, cls2, cls3);
        if (listA == null) {
            listA = new ArrayList();
            Iterator it = this.f66096a.c(cls).iterator();
            while (it.hasNext()) {
                for (Class cls4 : this.f66098c.d((Class) it.next(), cls2)) {
                    if (!this.f66101f.b(cls4, cls3).isEmpty() && !listA.contains(cls4)) {
                        listA.add(cls4);
                    }
                }
            }
            this.f66103h.b(cls, cls2, cls3, Collections.unmodifiableList(listA));
        }
        return listA;
    }

    public ResourceEncoder k(Resource resource) {
        ResourceEncoder resourceEncoderB = this.f66099d.b(resource.b());
        if (resourceEncoderB != null) {
            return resourceEncoderB;
        }
        throw new NoResultEncoderAvailableException(resource.b());
    }

    public DataRewinder l(Object obj) {
        return this.f66100e.a(obj);
    }

    public Encoder m(Object obj) {
        Encoder encoderB = this.f66097b.b(obj.getClass());
        if (encoderB != null) {
            return encoderB;
        }
        throw new NoSourceEncoderAvailableException(obj.getClass());
    }

    public boolean n(Resource resource) {
        return this.f66099d.b(resource.b()) != null;
    }

    public Registry o(Class cls, ResourceEncoder resourceEncoder) {
        this.f66099d.c(cls, resourceEncoder);
        return this;
    }

    public Registry p(ImageHeaderParser imageHeaderParser) {
        this.f66102g.a(imageHeaderParser);
        return this;
    }

    public Registry q(DataRewinder.Factory factory) {
        this.f66100e.b(factory);
        return this;
    }

    public Registry r(Class cls, Class cls2, ResourceTranscoder resourceTranscoder) {
        this.f66101f.c(cls, cls2, resourceTranscoder);
        return this;
    }

    public final Registry s(List list) {
        ArrayList arrayList = new ArrayList(list.size());
        arrayList.add("legacy_prepend_all");
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add((String) it.next());
        }
        arrayList.add("legacy_append");
        this.f66098c.e(arrayList);
        return this;
    }
}
