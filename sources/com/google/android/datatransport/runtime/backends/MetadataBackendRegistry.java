package com.google.android.datatransport.runtime.backends;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.util.Log;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Singleton;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
@Singleton
class MetadataBackendRegistry implements BackendRegistry {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final BackendFactoryProvider f69393a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final CreationContextFactory f69394b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map f69395c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class BackendFactoryProvider {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Context f69396a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Map f69397b = null;

        BackendFactoryProvider(Context context) {
            this.f69396a = context;
        }

        private Map a(Context context) {
            Bundle bundleD = d(context);
            if (bundleD == null) {
                Log.w("BackendRegistry", "Could not retrieve metadata, returning empty list of transport backends.");
                return Collections.EMPTY_MAP;
            }
            HashMap map = new HashMap();
            for (String str : bundleD.keySet()) {
                Object obj = bundleD.get(str);
                if ((obj instanceof String) && str.startsWith("backend:")) {
                    for (String str2 : ((String) obj).split(",", -1)) {
                        String strTrim = str2.trim();
                        if (!strTrim.isEmpty()) {
                            map.put(strTrim, str.substring(8));
                        }
                    }
                }
            }
            return map;
        }

        private Map c() {
            if (this.f69397b == null) {
                this.f69397b = a(this.f69396a);
            }
            return this.f69397b;
        }

        private static Bundle d(Context context) {
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager == null) {
                    Log.w("BackendRegistry", "Context has no PackageManager.");
                    return null;
                }
                ServiceInfo serviceInfo = packageManager.getServiceInfo(new ComponentName(context, (Class<?>) TransportBackendDiscovery.class), ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD);
                if (serviceInfo != null) {
                    return serviceInfo.metaData;
                }
                Log.w("BackendRegistry", "TransportBackendDiscovery has no service info.");
                return null;
            } catch (PackageManager.NameNotFoundException unused) {
                Log.w("BackendRegistry", "Application info not found.");
                return null;
            }
        }

        BackendFactory b(String str) {
            String str2 = (String) c().get(str);
            if (str2 == null) {
                return null;
            }
            try {
                return (BackendFactory) Class.forName(str2).asSubclass(BackendFactory.class).getDeclaredConstructor(null).newInstance(null);
            } catch (ClassNotFoundException e3) {
                Log.w("BackendRegistry", String.format("Class %s is not found.", str2), e3);
                return null;
            } catch (IllegalAccessException e4) {
                Log.w("BackendRegistry", String.format("Could not instantiate %s.", str2), e4);
                return null;
            } catch (InstantiationException e5) {
                Log.w("BackendRegistry", String.format("Could not instantiate %s.", str2), e5);
                return null;
            } catch (NoSuchMethodException e6) {
                Log.w("BackendRegistry", String.format("Could not instantiate %s", str2), e6);
                return null;
            } catch (InvocationTargetException e7) {
                Log.w("BackendRegistry", String.format("Could not instantiate %s", str2), e7);
                return null;
            }
        }
    }

    MetadataBackendRegistry(Context context, CreationContextFactory creationContextFactory) {
        this(new BackendFactoryProvider(context), creationContextFactory);
    }

    @Override // com.google.android.datatransport.runtime.backends.BackendRegistry
    public synchronized TransportBackend a(String str) {
        if (this.f69395c.containsKey(str)) {
            return (TransportBackend) this.f69395c.get(str);
        }
        BackendFactory backendFactoryB = this.f69393a.b(str);
        if (backendFactoryB == null) {
            return null;
        }
        TransportBackend transportBackendCreate = backendFactoryB.create(this.f69394b.a(str));
        this.f69395c.put(str, transportBackendCreate);
        return transportBackendCreate;
    }

    MetadataBackendRegistry(BackendFactoryProvider backendFactoryProvider, CreationContextFactory creationContextFactory) {
        this.f69395c = new HashMap();
        this.f69393a = backendFactoryProvider;
        this.f69394b = creationContextFactory;
    }
}
