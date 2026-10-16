package com.google.android.libraries.places.internal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzbnl {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v1, types: [java.lang.Iterable, java.util.ServiceLoader] */
    /* JADX WARN: Type inference failed for: r5v2, types: [java.util.ServiceLoader] */
    /* JADX WARN: Type inference failed for: r5v3, types: [java.lang.Iterable] */
    /* JADX WARN: Type inference failed for: r5v6, types: [java.util.ArrayList, java.util.List] */
    public static List a(Class cls, Iterable iterable, ClassLoader classLoader, zzbnk zzbnkVar) {
        ?? Load;
        if (b(classLoader)) {
            Load = new ArrayList();
            Iterator it = iterable.iterator();
            while (it.hasNext()) {
                Class cls2 = (Class) it.next();
                Object objNewInstance = null;
                try {
                    objNewInstance = cls2.asSubclass(cls).getConstructor(null).newInstance(null);
                } catch (ClassCastException unused) {
                } catch (Throwable th) {
                    throw new ServiceConfigurationError(String.format("Provider %s could not be instantiated %s", cls2.getName(), th), th);
                }
                if (objNewInstance != null) {
                    Load.add(objNewInstance);
                }
            }
        } else {
            Load = ServiceLoader.load(cls, classLoader);
            if (!Load.iterator().hasNext()) {
                Load = ServiceLoader.load(cls);
            }
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : Load) {
            zzbnkVar.zzb(obj);
            arrayList.add(obj);
        }
        Collections.sort(arrayList, Collections.reverseOrder(new zzbnj(zzbnkVar)));
        return Collections.unmodifiableList(arrayList);
    }

    static boolean b(ClassLoader classLoader) {
        try {
            Class.forName("android.app.Application", false, classLoader);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }
}
