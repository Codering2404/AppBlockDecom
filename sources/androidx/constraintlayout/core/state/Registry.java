package androidx.constraintlayout.core.state;

import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class Registry {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Registry f32025b = new Registry();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private HashMap f32026a = new HashMap();

    public static Registry a() {
        return f32025b;
    }

    public void b(String str, RegistryCallback registryCallback) {
        this.f32026a.put(str, registryCallback);
    }
}
