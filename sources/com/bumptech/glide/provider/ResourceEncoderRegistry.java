package com.bumptech.glide.provider;

import com.bumptech.glide.load.ResourceEncoder;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class ResourceEncoderRegistry {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f67089a = new ArrayList();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class Entry<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Class f67090a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final ResourceEncoder f67091b;

        Entry(Class cls, ResourceEncoder resourceEncoder) {
            this.f67090a = cls;
            this.f67091b = resourceEncoder;
        }

        boolean a(Class cls) {
            return this.f67090a.isAssignableFrom(cls);
        }
    }

    public synchronized void a(Class cls, ResourceEncoder resourceEncoder) {
        this.f67089a.add(new Entry(cls, resourceEncoder));
    }

    public synchronized ResourceEncoder b(Class cls) {
        int size = this.f67089a.size();
        for (int i3 = 0; i3 < size; i3++) {
            Entry entry = (Entry) this.f67089a.get(i3);
            if (entry.a(cls)) {
                return entry.f67091b;
            }
        }
        return null;
    }

    public synchronized void c(Class cls, ResourceEncoder resourceEncoder) {
        this.f67089a.add(0, new Entry(cls, resourceEncoder));
    }
}
