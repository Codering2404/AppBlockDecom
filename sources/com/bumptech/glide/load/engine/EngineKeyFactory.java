package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
class EngineKeyFactory {
    EngineKeyFactory() {
    }

    EngineKey a(Object obj, Key key, int i3, int i4, Map map, Class cls, Class cls2, Options options) {
        return new EngineKey(obj, key, i3, i4, map, cls, cls2, options);
    }
}
