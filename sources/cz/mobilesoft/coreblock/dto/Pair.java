package cz.mobilesoft.coreblock.dto;

import androidx.core.util.ObjectsCompat;
import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public class Pair<F, S> implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f96933a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f96934b;

    public Pair(Object obj, Object obj2) {
        this.f96933a = obj;
        this.f96934b = obj2;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Pair)) {
            return false;
        }
        Pair pair = (Pair) obj;
        return ObjectsCompat.a(pair.f96933a, this.f96933a) && ObjectsCompat.a(pair.f96934b, this.f96934b);
    }

    public int hashCode() {
        return this.f96933a.hashCode() ^ this.f96934b.hashCode();
    }

    public String toString() {
        return "Pair{" + this.f96933a + " " + this.f96934b + "}";
    }
}
