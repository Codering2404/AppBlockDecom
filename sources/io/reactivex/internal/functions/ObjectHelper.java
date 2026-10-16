package io.reactivex.internal.functions;

import io.reactivex.functions.BiPredicate;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class ObjectHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final BiPredicate f134950a = new BiObjectPredicate();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class BiObjectPredicate implements BiPredicate<Object, Object> {
        BiObjectPredicate() {
        }

        @Override // io.reactivex.functions.BiPredicate
        public boolean test(Object obj, Object obj2) {
            return ObjectHelper.c(obj, obj2);
        }
    }

    public static int a(int i3, int i4) {
        if (i3 < i4) {
            return -1;
        }
        return i3 > i4 ? 1 : 0;
    }

    public static int b(long j3, long j4) {
        if (j3 < j4) {
            return -1;
        }
        return j3 > j4 ? 1 : 0;
    }

    public static boolean c(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static Object d(Object obj, String str) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException(str);
    }

    public static int e(int i3, String str) {
        if (i3 > 0) {
            return i3;
        }
        throw new IllegalArgumentException(str + " > 0 required but it was " + i3);
    }
}
