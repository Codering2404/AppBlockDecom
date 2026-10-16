package ru.noties.markwon.priority;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import ru.noties.markwon.MarkwonPlugin;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
class PriorityProcessorImpl extends PriorityProcessor {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class PriorityComparator implements Comparator<MarkwonPlugin> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Map f147392a;

        PriorityComparator(Map map) {
            this.f147392a = map;
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(MarkwonPlugin markwonPlugin, MarkwonPlugin markwonPlugin2) {
            return ((Integer) this.f147392a.get(markwonPlugin)).compareTo((Integer) this.f147392a.get(markwonPlugin2));
        }
    }

    PriorityProcessorImpl() {
    }

    private static int c(Class cls, Class cls2, Map map) {
        Set<Class> set = (Set) map.get(cls2);
        if (set == null) {
            Iterator it = map.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry entry = (Map.Entry) it.next();
                if (cls2.isAssignableFrom((Class) entry.getKey())) {
                    set = (Set) entry.getValue();
                    break;
                }
            }
            if (set == null) {
                throw new IllegalStateException(String.format("Markwon unsatisfied dependency found. Plugin `%s` comes after `%s` but it is not added.", cls.getName(), cls2.getName()));
            }
        }
        if (set.isEmpty()) {
            return 0;
        }
        int iC = 1;
        for (Class cls3 : set) {
            if (cls.equals(cls3)) {
                throw new IllegalStateException(String.format("Markwon plugin `%s` defined self as a dependency or being referenced by own dependency (cycle)", cls.getName()));
            }
            iC += c(cls, cls3, map);
        }
        return iC;
    }

    private static int d(MarkwonPlugin markwonPlugin, Map map) {
        Set set = (Set) map.get(markwonPlugin.getClass());
        int iMax = 0;
        if (set.isEmpty()) {
            return 0;
        }
        Class<?> cls = markwonPlugin.getClass();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            iMax = Math.max(iMax, c(cls, (Class) it.next(), map));
        }
        return iMax + 1;
    }

    @Override // ru.noties.markwon.priority.PriorityProcessor
    public List b(List list) {
        ArrayList arrayList = new ArrayList(list);
        int size = arrayList.size();
        HashMap map = new HashMap(size);
        int size2 = arrayList.size();
        int i3 = 0;
        int i4 = 0;
        while (i4 < size2) {
            Object obj = arrayList.get(i4);
            i4++;
            MarkwonPlugin markwonPlugin = (MarkwonPlugin) obj;
            if (map.put(markwonPlugin.getClass(), new HashSet(markwonPlugin.priority().a())) != null) {
                throw new IllegalStateException(String.format("Markwon duplicate plugin found `%s`: %s", markwonPlugin.getClass().getName(), markwonPlugin));
            }
        }
        HashMap map2 = new HashMap(size);
        int size3 = arrayList.size();
        while (i3 < size3) {
            Object obj2 = arrayList.get(i3);
            i3++;
            MarkwonPlugin markwonPlugin2 = (MarkwonPlugin) obj2;
            map2.put(markwonPlugin2, Integer.valueOf(d(markwonPlugin2, map)));
        }
        Collections.sort(arrayList, new PriorityComparator(map2));
        return arrayList;
    }
}
