package com.google.firebase.components;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.util.Log;
import com.google.firebase.inject.Provider;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class ComponentDiscovery<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f88104a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final RegistrarNameRetriever f88105b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class MetadataRegistrarNameRetriever implements RegistrarNameRetriever<Context> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Class f88106a;

        private Bundle b(Context context) {
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager == null) {
                    Log.w("ComponentDiscovery", "Context has no PackageManager.");
                    return null;
                }
                ServiceInfo serviceInfo = packageManager.getServiceInfo(new ComponentName(context, (Class<?>) this.f88106a), ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD);
                if (serviceInfo != null) {
                    return serviceInfo.metaData;
                }
                Log.w("ComponentDiscovery", this.f88106a + " has no service info.");
                return null;
            } catch (PackageManager.NameNotFoundException unused) {
                Log.w("ComponentDiscovery", "Application info not found.");
                return null;
            }
        }

        @Override // com.google.firebase.components.ComponentDiscovery.RegistrarNameRetriever
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public List a(Context context) {
            Bundle bundleB = b(context);
            if (bundleB == null) {
                Log.w("ComponentDiscovery", "Could not retrieve metadata, returning empty list of registrars.");
                return Collections.EMPTY_LIST;
            }
            ArrayList arrayList = new ArrayList();
            for (String str : bundleB.keySet()) {
                if ("com.google.firebase.components.ComponentRegistrar".equals(bundleB.get(str)) && str.startsWith("com.google.firebase.components:")) {
                    arrayList.add(str.substring(31));
                }
            }
            return arrayList;
        }

        private MetadataRegistrarNameRetriever(Class cls) {
            this.f88106a = cls;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    interface RegistrarNameRetriever<T> {
        List a(Object obj);
    }

    ComponentDiscovery(Object obj, RegistrarNameRetriever registrarNameRetriever) {
        this.f88104a = obj;
        this.f88105b = registrarNameRetriever;
    }

    public static ComponentDiscovery c(Context context, Class cls) {
        return new ComponentDiscovery(context, new MetadataRegistrarNameRetriever(cls));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ComponentRegistrar d(String str) {
        try {
            Class<?> cls = Class.forName(str);
            if (ComponentRegistrar.class.isAssignableFrom(cls)) {
                return (ComponentRegistrar) cls.getDeclaredConstructor(null).newInstance(null);
            }
            throw new InvalidRegistrarException(String.format("Class %s is not an instance of %s", str, "com.google.firebase.components.ComponentRegistrar"));
        } catch (ClassNotFoundException unused) {
            Log.w("ComponentDiscovery", String.format("Class %s is not an found.", str));
            return null;
        } catch (IllegalAccessException e3) {
            throw new InvalidRegistrarException(String.format("Could not instantiate %s.", str), e3);
        } catch (InstantiationException e4) {
            throw new InvalidRegistrarException(String.format("Could not instantiate %s.", str), e4);
        } catch (NoSuchMethodException e5) {
            throw new InvalidRegistrarException(String.format("Could not instantiate %s", str), e5);
        } catch (InvocationTargetException e6) {
            throw new InvalidRegistrarException(String.format("Could not instantiate %s", str), e6);
        }
    }

    public List b() {
        ArrayList arrayList = new ArrayList();
        for (final String str : this.f88105b.a(this.f88104a)) {
            arrayList.add(new Provider() { // from class: com.google.firebase.components.c
                @Override // com.google.firebase.inject.Provider
                public final Object get() {
                    return ComponentDiscovery.d(str);
                }
            });
        }
        return arrayList;
    }
}
