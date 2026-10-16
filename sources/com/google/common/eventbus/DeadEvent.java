package com.google.common.eventbus;

import com.google.common.base.MoreObjects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public class DeadEvent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f84895a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f84896b;

    public String toString() {
        return MoreObjects.c(this).d("source", this.f84895a).d("event", this.f84896b).toString();
    }
}
