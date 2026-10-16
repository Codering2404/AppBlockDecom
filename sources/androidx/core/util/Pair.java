package androidx.core.util;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class Pair<F, S> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f34340a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f34341b;

    public Pair(Object obj, Object obj2) {
        this.f34340a = obj;
        this.f34341b = obj2;
    }

    public static Pair a(Object obj, Object obj2) {
        return new Pair(obj, obj2);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Pair)) {
            return false;
        }
        Pair pair = (Pair) obj;
        return ObjectsCompat.a(pair.f34340a, this.f34340a) && ObjectsCompat.a(pair.f34341b, this.f34341b);
    }

    public int hashCode() {
        Object obj = this.f34340a;
        int iHashCode = obj == null ? 0 : obj.hashCode();
        Object obj2 = this.f34341b;
        return iHashCode ^ (obj2 != null ? obj2.hashCode() : 0);
    }

    public String toString() {
        return "Pair{" + this.f34340a + " " + this.f34341b + "}";
    }
}
