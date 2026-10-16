package com.applovin.impl;

import android.net.Uri;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public interface h5 extends f5 {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface a {
        h5 a();
    }

    long a(k5 k5Var);

    void a(xo xoVar);

    Uri c();

    void close();

    default Map e() {
        return Collections.EMPTY_MAP;
    }
}
