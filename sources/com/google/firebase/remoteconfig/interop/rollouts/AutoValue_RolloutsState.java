package com.google.firebase.remoteconfig.interop.rollouts;

import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class AutoValue_RolloutsState extends RolloutsState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Set f89856a;

    AutoValue_RolloutsState(Set set) {
        if (set == null) {
            throw new NullPointerException("Null rolloutAssignments");
        }
        this.f89856a = set;
    }

    @Override // com.google.firebase.remoteconfig.interop.rollouts.RolloutsState
    public Set b() {
        return this.f89856a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof RolloutsState) {
            return this.f89856a.equals(((RolloutsState) obj).b());
        }
        return false;
    }

    public int hashCode() {
        return this.f89856a.hashCode() ^ 1000003;
    }

    public String toString() {
        return "RolloutsState{rolloutAssignments=" + this.f89856a + "}";
    }
}
