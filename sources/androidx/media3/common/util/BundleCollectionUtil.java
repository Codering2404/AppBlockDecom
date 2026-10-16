package androidx.media3.common.util;

import android.os.Bundle;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class BundleCollectionUtil {
    public static ImmutableList a(Function function, List list) {
        ImmutableList.Builder builderO = ImmutableList.o();
        for (int i3 = 0; i3 < list.size(); i3++) {
            builderO.a(function.apply((Bundle) Assertions.e((Bundle) list.get(i3))));
        }
        return builderO.m();
    }

    public static ArrayList b(Collection collection, Function function) {
        ArrayList arrayList = new ArrayList(collection.size());
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add((Bundle) function.apply(it.next()));
        }
        return arrayList;
    }
}
