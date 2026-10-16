package com.bumptech.glide.load.data;

import com.bumptech.glide.load.data.DataRewinder;
import com.bumptech.glide.util.Preconditions;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class DataRewinderRegistry {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final DataRewinder.Factory f66271b = new DataRewinder.Factory<Object>() { // from class: com.bumptech.glide.load.data.DataRewinderRegistry.1
        @Override // com.bumptech.glide.load.data.DataRewinder.Factory
        public Class a() {
            throw new UnsupportedOperationException("Not implemented");
        }

        @Override // com.bumptech.glide.load.data.DataRewinder.Factory
        public DataRewinder b(Object obj) {
            return new DefaultRewinder(obj);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map f66272a = new HashMap();

    public synchronized DataRewinder a(Object obj) {
        DataRewinder.Factory factory;
        try {
            Preconditions.e(obj);
            factory = (DataRewinder.Factory) this.f66272a.get(obj.getClass());
            if (factory == null) {
                Iterator it = this.f66272a.values().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    DataRewinder.Factory factory2 = (DataRewinder.Factory) it.next();
                    if (factory2.a().isAssignableFrom(obj.getClass())) {
                        factory = factory2;
                        break;
                    }
                }
            }
            if (factory == null) {
                factory = f66271b;
            }
        } catch (Throwable th) {
            throw th;
        }
        return factory.b(obj);
    }

    public synchronized void b(DataRewinder.Factory factory) {
        this.f66272a.put(factory.a(), factory);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class DefaultRewinder implements DataRewinder<Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Object f66273a;

        DefaultRewinder(Object obj) {
            this.f66273a = obj;
        }

        @Override // com.bumptech.glide.load.data.DataRewinder
        public Object a() {
            return this.f66273a;
        }

        @Override // com.bumptech.glide.load.data.DataRewinder
        public void b() {
        }
    }
}
