package android.support.v4.media;

import java.lang.reflect.Constructor;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
class ParceledListSliceAdapterApi21 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Constructor f200a;

    static {
        try {
            f200a = Class.forName("android.content.pm.ParceledListSlice").getConstructor(List.class);
        } catch (ClassNotFoundException | NoSuchMethodException e3) {
            e3.printStackTrace();
        }
    }
}
