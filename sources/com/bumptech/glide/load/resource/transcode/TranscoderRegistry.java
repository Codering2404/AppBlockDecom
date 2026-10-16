package com.bumptech.glide.load.resource.transcode;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class TranscoderRegistry {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f67016a = new ArrayList();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class Entry<Z, R> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Class f67017a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Class f67018b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final ResourceTranscoder f67019c;

        Entry(Class cls, Class cls2, ResourceTranscoder resourceTranscoder) {
            this.f67017a = cls;
            this.f67018b = cls2;
            this.f67019c = resourceTranscoder;
        }

        public boolean a(Class cls, Class cls2) {
            return this.f67017a.isAssignableFrom(cls) && cls2.isAssignableFrom(this.f67018b);
        }
    }

    public synchronized ResourceTranscoder a(Class cls, Class cls2) {
        if (cls2.isAssignableFrom(cls)) {
            return UnitTranscoder.b();
        }
        for (Entry entry : this.f67016a) {
            if (entry.a(cls, cls2)) {
                return entry.f67019c;
            }
        }
        throw new IllegalArgumentException("No transcoder registered to transcode from " + cls + " to " + cls2);
    }

    public synchronized List b(Class cls, Class cls2) {
        ArrayList arrayList = new ArrayList();
        if (cls2.isAssignableFrom(cls)) {
            arrayList.add(cls2);
            return arrayList;
        }
        for (Entry entry : this.f67016a) {
            if (entry.a(cls, cls2) && !arrayList.contains(entry.f67018b)) {
                arrayList.add(entry.f67018b);
            }
        }
        return arrayList;
    }

    public synchronized void c(Class cls, Class cls2, ResourceTranscoder resourceTranscoder) {
        this.f67016a.add(new Entry(cls, cls2, resourceTranscoder));
    }
}
