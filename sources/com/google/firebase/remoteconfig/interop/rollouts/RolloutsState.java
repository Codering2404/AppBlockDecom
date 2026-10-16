package com.google.firebase.remoteconfig.interop.rollouts;

import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public abstract class RolloutsState {
    public static RolloutsState a(Set set) {
        return new AutoValue_RolloutsState(set);
    }

    public abstract Set b();
}
