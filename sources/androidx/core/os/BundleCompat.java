package androidx.core.os;

import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import java.io.Serializable;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class BundleCompat {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Api33Impl {
        static Object a(Bundle bundle, String str, Class cls) {
            return bundle.getParcelable(str, cls);
        }

        static Object[] b(Bundle bundle, String str, Class cls) {
            return bundle.getParcelableArray(str, cls);
        }

        static ArrayList c(Bundle bundle, String str, Class cls) {
            return bundle.getParcelableArrayList(str, cls);
        }

        static Serializable d(Bundle bundle, String str, Class cls) {
            return bundle.getSerializable(str, cls);
        }

        static SparseArray e(Bundle bundle, String str, Class cls) {
            return bundle.getSparseParcelableArray(str, cls);
        }
    }

    public static Object a(Bundle bundle, String str, Class cls) {
        if (Build.VERSION.SDK_INT >= 34) {
            return Api33Impl.a(bundle, str, cls);
        }
        Parcelable parcelable = bundle.getParcelable(str);
        if (cls.isInstance(parcelable)) {
            return parcelable;
        }
        return null;
    }

    public static Parcelable[] b(Bundle bundle, String str, Class cls) {
        return Build.VERSION.SDK_INT >= 34 ? (Parcelable[]) Api33Impl.b(bundle, str, cls) : bundle.getParcelableArray(str);
    }

    public static ArrayList c(Bundle bundle, String str, Class cls) {
        return Build.VERSION.SDK_INT >= 34 ? Api33Impl.c(bundle, str, cls) : bundle.getParcelableArrayList(str);
    }

    public static Serializable d(Bundle bundle, String str, Class cls) {
        if (Build.VERSION.SDK_INT >= 34) {
            return Api33Impl.d(bundle, str, cls);
        }
        Serializable serializable = bundle.getSerializable(str);
        if (cls.isInstance(serializable)) {
            return serializable;
        }
        return null;
    }

    public static SparseArray e(Bundle bundle, String str, Class cls) {
        return Build.VERSION.SDK_INT >= 34 ? Api33Impl.e(bundle, str, cls) : bundle.getSparseParcelableArray(str);
    }
}
