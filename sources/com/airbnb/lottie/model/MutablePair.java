package com.airbnb.lottie.model;

import androidx.core.util.Pair;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class MutablePair<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f56716a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f56717b;

    private static boolean a(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public void b(Object obj, Object obj2) {
        this.f56716a = obj;
        this.f56717b = obj2;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Pair)) {
            return false;
        }
        Pair pair = (Pair) obj;
        return a(pair.f34340a, this.f56716a) && a(pair.f34341b, this.f56717b);
    }

    public int hashCode() {
        Object obj = this.f56716a;
        int iHashCode = obj == null ? 0 : obj.hashCode();
        Object obj2 = this.f56717b;
        return iHashCode ^ (obj2 != null ? obj2.hashCode() : 0);
    }

    public String toString() {
        return "Pair{" + this.f56716a + " " + this.f56717b + "}";
    }
}
