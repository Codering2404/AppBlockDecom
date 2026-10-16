package com.bumptech.glide.provider;

import com.bumptech.glide.load.ResourceDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class ResourceDecoderRegistry {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f67084a = new ArrayList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map f67085b = new HashMap();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class Entry<T, R> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Class f67086a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Class f67087b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final ResourceDecoder f67088c;

        public Entry(Class cls, Class cls2, ResourceDecoder resourceDecoder) {
            this.f67086a = cls;
            this.f67087b = cls2;
            this.f67088c = resourceDecoder;
        }

        public boolean a(Class cls, Class cls2) {
            return this.f67086a.isAssignableFrom(cls) && cls2.isAssignableFrom(this.f67087b);
        }
    }

    private synchronized List c(String str) {
        List arrayList;
        try {
            if (!this.f67084a.contains(str)) {
                this.f67084a.add(str);
            }
            arrayList = (List) this.f67085b.get(str);
            if (arrayList == null) {
                arrayList = new ArrayList();
                this.f67085b.put(str, arrayList);
            }
        } catch (Throwable th) {
            throw th;
        }
        return arrayList;
    }

    public synchronized void a(String str, ResourceDecoder resourceDecoder, Class cls, Class cls2) {
        c(str).add(new Entry(cls, cls2, resourceDecoder));
    }

    public synchronized List b(Class cls, Class cls2) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        Iterator it = this.f67084a.iterator();
        while (it.hasNext()) {
            List<Entry> list = (List) this.f67085b.get((String) it.next());
            if (list != null) {
                for (Entry entry : list) {
                    if (entry.a(cls, cls2)) {
                        arrayList.add(entry.f67088c);
                    }
                }
            }
        }
        return arrayList;
    }

    public synchronized List d(Class cls, Class cls2) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        Iterator it = this.f67084a.iterator();
        while (it.hasNext()) {
            List<Entry> list = (List) this.f67085b.get((String) it.next());
            if (list != null) {
                for (Entry entry : list) {
                    if (entry.a(cls, cls2) && !arrayList.contains(entry.f67087b)) {
                        arrayList.add(entry.f67087b);
                    }
                }
            }
        }
        return arrayList;
    }

    public synchronized void e(List list) {
        try {
            ArrayList arrayList = new ArrayList(this.f67084a);
            this.f67084a.clear();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                this.f67084a.add((String) it.next());
            }
            int size = arrayList.size();
            int i3 = 0;
            while (i3 < size) {
                Object obj = arrayList.get(i3);
                i3++;
                String str = (String) obj;
                if (!list.contains(str)) {
                    this.f67084a.add(str);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
