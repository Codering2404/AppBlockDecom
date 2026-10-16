package kotlin.jvm.internal;

import kotlin.reflect.KCallable;
import kotlin.reflect.KProperty2;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public abstract class PropertyReference2 extends PropertyReference implements KProperty2 {
    public PropertyReference2() {
    }

    @Override // kotlin.reflect.KProperty2
    public KProperty2.Getter a() {
        return ((KProperty2) getReflected()).a();
    }

    @Override // kotlin.jvm.internal.CallableReference
    protected KCallable computeReflected() {
        return Reflection.j(this);
    }

    @Override // kotlin.jvm.functions.Function2
    public Object invoke(Object obj, Object obj2) {
        return E(obj, obj2);
    }

    public PropertyReference2(Class cls, String str, String str2, int i3) {
        super(CallableReference.NO_RECEIVER, cls, str, str2, i3);
    }
}
