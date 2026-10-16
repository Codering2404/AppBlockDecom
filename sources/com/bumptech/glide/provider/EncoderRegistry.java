package com.bumptech.glide.provider;

import com.bumptech.glide.load.Encoder;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class EncoderRegistry {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f67075a = new ArrayList();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class Entry<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Class f67076a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Encoder f67077b;

        Entry(Class cls, Encoder encoder) {
            this.f67076a = cls;
            this.f67077b = encoder;
        }

        boolean a(Class cls) {
            return this.f67076a.isAssignableFrom(cls);
        }
    }

    public synchronized void a(Class cls, Encoder encoder) {
        this.f67075a.add(new Entry(cls, encoder));
    }

    public synchronized Encoder b(Class cls) {
        for (Entry entry : this.f67075a) {
            if (entry.a(cls)) {
                return entry.f67077b;
            }
        }
        return null;
    }
}
