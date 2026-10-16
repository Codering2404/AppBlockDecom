package retrofit2;

import java.lang.reflect.Method;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class Invocation {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Class f146855a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f146856b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Method f146857c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final List f146858d;

    Invocation(Class cls, Object obj, Method method, List list) {
        this.f146855a = cls;
        this.f146856b = obj;
        this.f146857c = method;
        this.f146858d = Collections.unmodifiableList(list);
    }

    public Method a() {
        return this.f146857c;
    }

    public Class b() {
        return this.f146855a;
    }

    public String toString() {
        return String.format("%s.%s() %s", this.f146855a.getName(), this.f146857c.getName(), this.f146858d);
    }
}
