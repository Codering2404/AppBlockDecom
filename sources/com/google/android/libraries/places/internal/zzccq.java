package com.google.android.libraries.places.internal;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzccq implements InvocationHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f77580a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f77581b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f77582c;

    public zzccq(List list) {
        this.f77580a = list;
    }

    final /* synthetic */ boolean a() {
        return this.f77581b;
    }

    final /* synthetic */ String b() {
        return this.f77582c;
    }

    @Override // java.lang.reflect.InvocationHandler
    public final Object invoke(Object obj, Method method, Object[] objArr) {
        String name = method.getName();
        Class<?> returnType = method.getReturnType();
        if (objArr == null) {
            objArr = zzccu.f77600a;
        }
        if (name.equals("supports") && Boolean.TYPE == returnType) {
            return Boolean.TRUE;
        }
        if (name.equals("unsupported") && Void.TYPE == returnType) {
            this.f77581b = true;
            return null;
        }
        if (name.equals("protocols") && objArr.length == 0) {
            return this.f77580a;
        }
        if ((name.equals("selectProtocol") || name.equals("select")) && returnType == String.class && objArr.length == 1) {
            Object obj2 = objArr[0];
            if (obj2 instanceof List) {
                List list = (List) obj2;
                int size = list.size();
                for (int i3 = 0; i3 < size; i3++) {
                    if (this.f77580a.contains(list.get(i3))) {
                        String str = (String) list.get(i3);
                        this.f77582c = str;
                        return str;
                    }
                }
                String str2 = (String) this.f77580a.get(0);
                this.f77582c = str2;
                return str2;
            }
        }
        if ((!name.equals("protocolSelected") && !name.equals("selected")) || objArr.length != 1) {
            return method.invoke(this, objArr);
        }
        this.f77582c = (String) objArr[0];
        return null;
    }
}
