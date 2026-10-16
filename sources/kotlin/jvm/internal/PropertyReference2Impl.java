package kotlin.jvm.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public class PropertyReference2Impl extends PropertyReference2 {
    public PropertyReference2Impl(Class cls, String str, String str2, int i3) {
        super(cls, str, str2, i3);
    }

    @Override // kotlin.reflect.KProperty2
    public Object E(Object obj, Object obj2) {
        return a().call(obj, obj2);
    }
}
