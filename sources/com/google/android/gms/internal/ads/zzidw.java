package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class zzidw {
    static zzido zzb(Class cls) {
        ClassLoader classLoader = zzidw.class.getClassLoader();
        if (cls.equals(zzido.class)) {
            try {
                try {
                    return (zzido) cls.cast(((zzidw) Class.forName("com.google.protobuf.BlazeGeneratedExtensionRegistryLiteLoader", true, classLoader).getConstructor(null).newInstance(null)).zza());
                } catch (ReflectiveOperationException e3) {
                    throw new IllegalStateException(e3);
                }
            } catch (ClassNotFoundException unused) {
            }
        }
        Iterator it = ServiceLoader.load(zzidw.class, classLoader).iterator();
        ArrayList arrayList = new ArrayList();
        while (it.hasNext()) {
            try {
                arrayList.add((zzido) cls.cast(((zzidw) it.next()).zza()));
            } catch (ServiceConfigurationError e4) {
                Logger.getLogger(zzidj.class.getName()).logp(Level.SEVERE, "com.google.protobuf.GeneratedExtensionRegistryLoader", "load", "Unable to load ".concat(cls.getSimpleName()), (Throwable) e4);
            }
        }
        if (arrayList.size() == 1) {
            return (zzido) arrayList.get(0);
        }
        if (arrayList.size() == 0) {
            return null;
        }
        try {
            return (zzido) cls.getMethod("combine", Collection.class).invoke(null, arrayList);
        } catch (ReflectiveOperationException e5) {
            throw new IllegalStateException(e5);
        }
    }

    protected abstract zzido zza();
}
