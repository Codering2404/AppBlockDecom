package com.bumptech.glide.load.model;

import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.util.Preconditions;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public interface ModelLoader<Model, Data> {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class LoadData<Data> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Key f66729a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List f66730b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final DataFetcher f66731c;

        public LoadData(Key key, DataFetcher dataFetcher) {
            this(key, Collections.EMPTY_LIST, dataFetcher);
        }

        public LoadData(Key key, List list, DataFetcher dataFetcher) {
            this.f66729a = (Key) Preconditions.e(key);
            this.f66730b = (List) Preconditions.e(list);
            this.f66731c = (DataFetcher) Preconditions.e(dataFetcher);
        }
    }

    boolean a(Object obj);

    LoadData b(Object obj, int i3, int i4, Options options);
}
