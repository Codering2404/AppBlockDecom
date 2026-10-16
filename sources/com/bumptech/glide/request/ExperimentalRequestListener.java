package com.bumptech.glide.request;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.request.target.Target;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public abstract class ExperimentalRequestListener<ResourceT> implements RequestListener<ResourceT> {
    public abstract boolean c(Object obj, Object obj2, Target target, DataSource dataSource, boolean z2, boolean z3);

    public void b(Object obj) {
    }
}
