package com.bumptech.glide.load.model;

import com.bumptech.glide.load.model.LazyHeaders;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public interface Headers {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Headers f66708a = new Headers() { // from class: com.bumptech.glide.load.model.Headers.1
        @Override // com.bumptech.glide.load.model.Headers
        public Map a() {
            return Collections.EMPTY_MAP;
        }
    };

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Headers f66709b = new LazyHeaders.Builder().a();

    Map a();
}
