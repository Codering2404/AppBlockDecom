package androidx.lifecycle;

import androidx.lifecycle.ClassesInfoCache;
import androidx.lifecycle.Lifecycle;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
@Deprecated
class ReflectiveGenericLifecycleObserver implements LifecycleEventObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f40044a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ClassesInfoCache.CallbackInfo f40045b;

    ReflectiveGenericLifecycleObserver(Object obj) {
        this.f40044a = obj;
        this.f40045b = ClassesInfoCache.f39882c.c(obj.getClass());
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public void j(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        this.f40045b.a(lifecycleOwner, event, this.f40044a);
    }
}
