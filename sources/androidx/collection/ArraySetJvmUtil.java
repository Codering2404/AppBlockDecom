package androidx.collection;

import java.lang.reflect.Array;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
class ArraySetJvmUtil {
    static Object[] a(Object[] objArr, int i3) {
        if (objArr.length < i3) {
            return (Object[]) Array.newInstance(objArr.getClass().getComponentType(), i3);
        }
        if (objArr.length > i3) {
            objArr[i3] = null;
        }
        return objArr;
    }
}
