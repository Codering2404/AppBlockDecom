package com.google.android.datatransport.runtime.util;

import android.util.SparseArray;
import com.google.android.datatransport.Priority;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class PriorityMapping {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static SparseArray f69623a = new SparseArray();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static HashMap f69624b;

    static {
        HashMap map = new HashMap();
        f69624b = map;
        map.put(Priority.DEFAULT, 0);
        f69624b.put(Priority.VERY_LOW, 1);
        f69624b.put(Priority.HIGHEST, 2);
        for (Priority priority : f69624b.keySet()) {
            f69623a.append(((Integer) f69624b.get(priority)).intValue(), priority);
        }
    }

    public static int a(Priority priority) {
        Integer num = (Integer) f69624b.get(priority);
        if (num != null) {
            return num.intValue();
        }
        throw new IllegalStateException("PriorityMapping is missing known Priority value " + priority);
    }

    public static Priority b(int i3) {
        Priority priority = (Priority) f69623a.get(i3);
        if (priority != null) {
            return priority;
        }
        throw new IllegalArgumentException("Unknown Priority for value " + i3);
    }
}
