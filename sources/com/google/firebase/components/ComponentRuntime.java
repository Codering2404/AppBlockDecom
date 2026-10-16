package com.google.firebase.components;

import android.util.Log;
import com.google.firebase.components.ComponentRuntime;
import com.google.firebase.dynamicloading.ComponentLoader;
import com.google.firebase.events.Publisher;
import com.google.firebase.events.Subscriber;
import com.google.firebase.inject.Deferred;
import com.google.firebase.inject.Provider;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class ComponentRuntime implements ComponentContainer, ComponentLoader {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final Provider f88108i = new Provider() { // from class: com.google.firebase.components.e
        @Override // com.google.firebase.inject.Provider
        public final Object get() {
            return Collections.EMPTY_SET;
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map f88109a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map f88110b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map f88111c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final List f88112d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Set f88113e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final EventBus f88114f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final AtomicReference f88115g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final ComponentRegistrarProcessor f88116h;

    public static /* synthetic */ Object j(ComponentRuntime componentRuntime, Component component) {
        componentRuntime.getClass();
        return component.h().a(new RestrictedComponentContainer(component, componentRuntime));
    }

    public static Builder m(Executor executor) {
        return new Builder(executor);
    }

    private void n(List list) {
        int i3;
        ArrayList arrayList = new ArrayList();
        synchronized (this) {
            Iterator it = this.f88112d.iterator();
            while (it.hasNext()) {
                try {
                    ComponentRegistrar componentRegistrar = (ComponentRegistrar) ((Provider) it.next()).get();
                    if (componentRegistrar != null) {
                        list.addAll(this.f88116h.a(componentRegistrar));
                        it.remove();
                    }
                } catch (InvalidRegistrarException e3) {
                    it.remove();
                    Log.w("ComponentDiscovery", "Invalid component registrar.", e3);
                }
            }
            Iterator it2 = list.iterator();
            while (true) {
                i3 = 0;
                if (!it2.hasNext()) {
                    break;
                }
                Object[] array = ((Component) it2.next()).j().toArray();
                int length = array.length;
                while (true) {
                    if (i3 < length) {
                        Object obj = array[i3];
                        if (obj.toString().contains("kotlinx.coroutines.CoroutineDispatcher")) {
                            if (this.f88113e.contains(obj.toString())) {
                                it2.remove();
                                break;
                            }
                            this.f88113e.add(obj.toString());
                        }
                        i3++;
                    }
                }
            }
            if (this.f88109a.isEmpty()) {
                CycleDetector.a(list);
            } else {
                ArrayList arrayList2 = new ArrayList(this.f88109a.keySet());
                arrayList2.addAll(list);
                CycleDetector.a(arrayList2);
            }
            Iterator it3 = list.iterator();
            while (it3.hasNext()) {
                final Component component = (Component) it3.next();
                this.f88109a.put(component, new Lazy(new Provider() { // from class: com.google.firebase.components.f
                    @Override // com.google.firebase.inject.Provider
                    public final Object get() {
                        return ComponentRuntime.j(this.f88156a, component);
                    }
                }));
            }
            arrayList.addAll(t(list));
            arrayList.addAll(u());
            s();
        }
        int size = arrayList.size();
        while (i3 < size) {
            Object obj2 = arrayList.get(i3);
            i3++;
            ((Runnable) obj2).run();
        }
        r();
    }

    private void o(Map map, boolean z2) {
        for (Map.Entry entry : map.entrySet()) {
            Component component = (Component) entry.getKey();
            Provider provider = (Provider) entry.getValue();
            if (component.n() || (component.o() && z2)) {
                provider.get();
            }
        }
        this.f88114f.d();
    }

    private static List q(Iterable iterable) {
        ArrayList arrayList = new ArrayList();
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return arrayList;
    }

    private void r() {
        Boolean bool = (Boolean) this.f88115g.get();
        if (bool != null) {
            o(this.f88109a, bool.booleanValue());
        }
    }

    private void s() {
        for (Component component : this.f88109a.keySet()) {
            for (Dependency dependency : component.g()) {
                if (dependency.g() && !this.f88111c.containsKey(dependency.c())) {
                    this.f88111c.put(dependency.c(), LazySet.b(Collections.EMPTY_SET));
                } else if (this.f88110b.containsKey(dependency.c())) {
                    continue;
                } else {
                    if (dependency.f()) {
                        throw new MissingDependencyException(String.format("Unsatisfied dependency for component %s: %s", component, dependency.c()));
                    }
                    if (!dependency.g()) {
                        this.f88110b.put(dependency.c(), OptionalProvider.e());
                    }
                }
            }
        }
    }

    private List t(List list) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Component component = (Component) it.next();
            if (component.p()) {
                final Provider provider = (Provider) this.f88109a.get(component);
                for (Qualified qualified : component.j()) {
                    if (this.f88110b.containsKey(qualified)) {
                        final OptionalProvider optionalProvider = (OptionalProvider) ((Provider) this.f88110b.get(qualified));
                        arrayList.add(new Runnable() { // from class: com.google.firebase.components.g
                            @Override // java.lang.Runnable
                            public final void run() {
                                optionalProvider.g(provider);
                            }
                        });
                    } else {
                        this.f88110b.put(qualified, provider);
                    }
                }
            }
        }
        return arrayList;
    }

    private List u() {
        ArrayList arrayList = new ArrayList();
        HashMap map = new HashMap();
        for (Map.Entry entry : this.f88109a.entrySet()) {
            Component component = (Component) entry.getKey();
            if (!component.p()) {
                Provider provider = (Provider) entry.getValue();
                for (Qualified qualified : component.j()) {
                    if (!map.containsKey(qualified)) {
                        map.put(qualified, new HashSet());
                    }
                    ((Set) map.get(qualified)).add(provider);
                }
            }
        }
        for (Map.Entry entry2 : map.entrySet()) {
            if (this.f88111c.containsKey(entry2.getKey())) {
                final LazySet lazySet = (LazySet) this.f88111c.get(entry2.getKey());
                for (final Provider provider2 : (Set) entry2.getValue()) {
                    arrayList.add(new Runnable() { // from class: com.google.firebase.components.h
                        @Override // java.lang.Runnable
                        public final void run() {
                            lazySet.a(provider2);
                        }
                    });
                }
            } else {
                this.f88111c.put((Qualified) entry2.getKey(), LazySet.b((Collection) entry2.getValue()));
            }
        }
        return arrayList;
    }

    @Override // com.google.firebase.components.ComponentContainer
    public synchronized Provider b(Qualified qualified) {
        Preconditions.c(qualified, "Null interface requested.");
        return (Provider) this.f88110b.get(qualified);
    }

    @Override // com.google.firebase.components.ComponentContainer
    public synchronized Provider d(Qualified qualified) {
        LazySet lazySet = (LazySet) this.f88111c.get(qualified);
        if (lazySet != null) {
            return lazySet;
        }
        return f88108i;
    }

    @Override // com.google.firebase.components.ComponentContainer
    public Deferred h(Qualified qualified) {
        Provider providerB = b(qualified);
        return providerB == null ? OptionalProvider.e() : providerB instanceof OptionalProvider ? (OptionalProvider) providerB : OptionalProvider.f(providerB);
    }

    public void p(boolean z2) {
        HashMap map;
        if (androidx.compose.animation.core.h.a(this.f88115g, null, Boolean.valueOf(z2))) {
            synchronized (this) {
                map = new HashMap(this.f88109a);
            }
            o(map, z2);
        }
    }

    private ComponentRuntime(Executor executor, Iterable iterable, Collection collection, ComponentRegistrarProcessor componentRegistrarProcessor) {
        this.f88109a = new HashMap();
        this.f88110b = new HashMap();
        this.f88111c = new HashMap();
        this.f88113e = new HashSet();
        this.f88115g = new AtomicReference();
        EventBus eventBus = new EventBus(executor);
        this.f88114f = eventBus;
        this.f88116h = componentRegistrarProcessor;
        ArrayList arrayList = new ArrayList();
        arrayList.add(Component.q(eventBus, EventBus.class, Subscriber.class, Publisher.class));
        arrayList.add(Component.q(this, ComponentLoader.class, new Class[0]));
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            Component component = (Component) it.next();
            if (component != null) {
                arrayList.add(component);
            }
        }
        this.f88112d = q(iterable);
        n(arrayList);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Executor f88117a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final List f88118b = new ArrayList();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final List f88119c = new ArrayList();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private ComponentRegistrarProcessor f88120d = ComponentRegistrarProcessor.f88107a;

        Builder(Executor executor) {
            this.f88117a = executor;
        }

        public Builder b(Component component) {
            this.f88119c.add(component);
            return this;
        }

        public Builder c(final ComponentRegistrar componentRegistrar) {
            this.f88118b.add(new Provider() { // from class: com.google.firebase.components.i
                @Override // com.google.firebase.inject.Provider
                public final Object get() {
                    return ComponentRuntime.Builder.a(componentRegistrar);
                }
            });
            return this;
        }

        public Builder d(Collection collection) {
            this.f88118b.addAll(collection);
            return this;
        }

        public ComponentRuntime e() {
            return new ComponentRuntime(this.f88117a, this.f88118b, this.f88119c, this.f88120d);
        }

        public Builder f(ComponentRegistrarProcessor componentRegistrarProcessor) {
            this.f88120d = componentRegistrarProcessor;
            return this;
        }

        public static /* synthetic */ ComponentRegistrar a(ComponentRegistrar componentRegistrar) {
            return componentRegistrar;
        }
    }
}
