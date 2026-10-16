package com.google.firebase.components;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
class CycleDetector {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class ComponentNode {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Component f88121a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Set f88122b = new HashSet();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Set f88123c = new HashSet();

        ComponentNode(Component component) {
            this.f88121a = component;
        }

        void a(ComponentNode componentNode) {
            this.f88122b.add(componentNode);
        }

        void b(ComponentNode componentNode) {
            this.f88123c.add(componentNode);
        }

        Component c() {
            return this.f88121a;
        }

        Set d() {
            return this.f88122b;
        }

        boolean e() {
            return this.f88122b.isEmpty();
        }

        boolean f() {
            return this.f88123c.isEmpty();
        }

        void g(ComponentNode componentNode) {
            this.f88123c.remove(componentNode);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class Dep {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Qualified f88124a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f88125b;

        public boolean equals(Object obj) {
            if (obj instanceof Dep) {
                Dep dep = (Dep) obj;
                if (dep.f88124a.equals(this.f88124a) && dep.f88125b == this.f88125b) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return ((this.f88124a.hashCode() ^ 1000003) * 1000003) ^ Boolean.valueOf(this.f88125b).hashCode();
        }

        private Dep(Qualified qualified, boolean z2) {
            this.f88124a = qualified;
            this.f88125b = z2;
        }
    }

    static void a(List list) {
        Set<ComponentNode> setC = c(list);
        Set setB = b(setC);
        int i3 = 0;
        while (!setB.isEmpty()) {
            ComponentNode componentNode = (ComponentNode) setB.iterator().next();
            setB.remove(componentNode);
            i3++;
            for (ComponentNode componentNode2 : componentNode.d()) {
                componentNode2.g(componentNode);
                if (componentNode2.f()) {
                    setB.add(componentNode2);
                }
            }
        }
        if (i3 == list.size()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (ComponentNode componentNode3 : setC) {
            if (!componentNode3.f() && !componentNode3.e()) {
                arrayList.add(componentNode3.c());
            }
        }
        throw new DependencyCycleException(arrayList);
    }

    private static Set b(Set set) {
        HashSet hashSet = new HashSet();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            ComponentNode componentNode = (ComponentNode) it.next();
            if (componentNode.f()) {
                hashSet.add(componentNode);
            }
        }
        return hashSet;
    }

    private static Set c(List list) {
        Set<ComponentNode> set;
        HashMap map = new HashMap(list.size());
        Iterator it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                Iterator it2 = map.values().iterator();
                while (it2.hasNext()) {
                    for (ComponentNode componentNode : (Set) it2.next()) {
                        for (Dependency dependency : componentNode.c().g()) {
                            if (dependency.e() && (set = (Set) map.get(new Dep(dependency.c(), dependency.g()))) != null) {
                                for (ComponentNode componentNode2 : set) {
                                    componentNode.a(componentNode2);
                                    componentNode2.b(componentNode);
                                }
                            }
                        }
                    }
                }
                HashSet hashSet = new HashSet();
                Iterator it3 = map.values().iterator();
                while (it3.hasNext()) {
                    hashSet.addAll((Set) it3.next());
                }
                return hashSet;
            }
            Component component = (Component) it.next();
            ComponentNode componentNode3 = new ComponentNode(component);
            for (Qualified qualified : component.j()) {
                Dep dep = new Dep(qualified, !component.p());
                if (!map.containsKey(dep)) {
                    map.put(dep, new HashSet());
                }
                Set set2 = (Set) map.get(dep);
                if (!set2.isEmpty() && !dep.f88125b) {
                    throw new IllegalArgumentException(String.format("Multiple components provide %s.", qualified));
                }
                set2.add(componentNode3);
            }
        }
    }
}
