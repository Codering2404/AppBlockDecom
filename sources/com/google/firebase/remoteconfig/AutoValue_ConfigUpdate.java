package com.google.firebase.remoteconfig;

import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class AutoValue_ConfigUpdate extends ConfigUpdate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Set f89624a;

    AutoValue_ConfigUpdate(Set set) {
        if (set == null) {
            throw new NullPointerException("Null updatedKeys");
        }
        this.f89624a = set;
    }

    @Override // com.google.firebase.remoteconfig.ConfigUpdate
    public Set b() {
        return this.f89624a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ConfigUpdate) {
            return this.f89624a.equals(((ConfigUpdate) obj).b());
        }
        return false;
    }

    public int hashCode() {
        return this.f89624a.hashCode() ^ 1000003;
    }

    public String toString() {
        return "ConfigUpdate{updatedKeys=" + this.f89624a + "}";
    }
}
