package ru.noties.markwon;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
class RenderPropsImpl implements RenderProps {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map f147091a = new HashMap(3);

    RenderPropsImpl() {
    }

    @Override // ru.noties.markwon.RenderProps
    public Object a(Prop prop, Object obj) {
        Object obj2 = this.f147091a.get(prop);
        return obj2 != null ? obj2 : obj;
    }

    @Override // ru.noties.markwon.RenderProps
    public void b() {
        this.f147091a.clear();
    }

    @Override // ru.noties.markwon.RenderProps
    public Object c(Prop prop) {
        return this.f147091a.get(prop);
    }

    @Override // ru.noties.markwon.RenderProps
    public void d(Prop prop, Object obj) {
        if (obj == null) {
            this.f147091a.remove(prop);
        } else {
            this.f147091a.put(prop, obj);
        }
    }
}
