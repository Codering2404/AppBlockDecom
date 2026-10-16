package com.applovin.impl.mediation;

import android.text.TextUtils;
import com.applovin.impl.fe;
import com.applovin.impl.oe;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.adapter.MaxAdapter;
import com.applovin.mediation.adapters.MediationAdapterBase;
import com.applovin.sdk.AppLovinSdk;
import com.facebook.GraphRequest;
import cz.mobilesoft.coreblock.scene.permission.permissions.success.lbR.YgVrd;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.applovin.impl.sdk.j f61720b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.applovin.impl.sdk.n f61721c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map f61719a = Collections.synchronizedMap(new HashMap(16));

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Object f61722d = new Object();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Map f61723e = new HashMap();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Set f61724f = new HashSet();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Object f61725g = new Object();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Set f61726h = new HashSet();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f61727a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f61728b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final MaxAdFormat f61729c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final JSONObject f61730d;

        a(String str, String str2, fe feVar, com.applovin.impl.sdk.j jVar) {
            this.f61727a = str;
            this.f61728b = str2;
            JSONObject jSONObject = new JSONObject();
            this.f61730d = jSONObject;
            JsonUtils.putString(jSONObject, "class", str);
            JsonUtils.putString(jSONObject, "operation", str2);
            if (feVar == null) {
                this.f61729c = null;
            } else {
                this.f61729c = feVar.getFormat();
                JsonUtils.putString(jSONObject, GraphRequest.FORMAT_PARAM, feVar.getFormat().getLabel());
            }
        }

        JSONObject a() {
            return this.f61730d;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            if (!this.f61727a.equals(aVar.f61727a) || !this.f61728b.equals(aVar.f61728b)) {
                return false;
            }
            MaxAdFormat maxAdFormat = this.f61729c;
            MaxAdFormat maxAdFormat2 = aVar.f61729c;
            return maxAdFormat == null ? maxAdFormat2 == null : maxAdFormat.equals(maxAdFormat2);
        }

        public int hashCode() {
            int iHashCode = ((this.f61727a.hashCode() * 31) + this.f61728b.hashCode()) * 31;
            MaxAdFormat maxAdFormat = this.f61729c;
            return iHashCode + (maxAdFormat != null ? maxAdFormat.hashCode() : 0);
        }

        public String toString() {
            return "DisabledAdapterInfo{className='" + this.f61727a + "', operationTag='" + this.f61728b + "', format=" + this.f61729c + '}';
        }
    }

    public f(com.applovin.impl.sdk.j jVar) {
        if (jVar == null) {
            throw new IllegalArgumentException("No sdk specified");
        }
        this.f61720b = jVar;
        this.f61721c = jVar.I();
    }

    public void a(String str, String str2, fe feVar) {
        synchronized (this.f61725g) {
            try {
                this.f61720b.I();
                if (com.applovin.impl.sdk.n.a()) {
                    this.f61720b.I().b("MediationAdapterManager", "Adding " + str + " to list of disabled adapters.");
                }
                this.f61726h.add(new a(str, str2, feVar, this.f61720b));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public Collection b() {
        Set setUnmodifiableSet;
        synchronized (this.f61722d) {
            setUnmodifiableSet = Collections.unmodifiableSet(this.f61724f);
        }
        return setUnmodifiableSet;
    }

    public Collection c() {
        Set setUnmodifiableSet;
        synchronized (this.f61722d) {
            try {
                HashSet hashSet = new HashSet(this.f61723e.size());
                Iterator it = this.f61723e.values().iterator();
                while (it.hasNext()) {
                    hashSet.add(((Class) it.next()).getName());
                }
                setUnmodifiableSet = Collections.unmodifiableSet(hashSet);
            } catch (Throwable th) {
                throw th;
            }
        }
        return setUnmodifiableSet;
    }

    g a(oe oeVar) {
        return a(oeVar, false);
    }

    g a(oe oeVar, boolean z2) {
        Class clsA;
        g gVar;
        if (oeVar != null) {
            String strC = oeVar.c();
            String strB = oeVar.b();
            if (TextUtils.isEmpty(strC)) {
                if (com.applovin.impl.sdk.n.a()) {
                    this.f61721c.b("MediationAdapterManager", "No adapter name provided for " + strB + ", not loading the adapter ");
                }
                return null;
            }
            if (TextUtils.isEmpty(strB)) {
                if (com.applovin.impl.sdk.n.a()) {
                    this.f61721c.b("MediationAdapterManager", "Unable to find default className for '" + strC + "'");
                }
                return null;
            }
            if (z2 && (gVar = (g) this.f61719a.get(strB)) != null) {
                return gVar;
            }
            synchronized (this.f61722d) {
                try {
                    if (!this.f61724f.contains(strB)) {
                        if (this.f61723e.containsKey(strB)) {
                            clsA = (Class) this.f61723e.get(strB);
                        } else {
                            clsA = a(strB);
                            if (clsA == null) {
                                if (com.applovin.impl.sdk.n.a()) {
                                    this.f61721c.k("MediationAdapterManager", "Adapter " + strC + " could not be loaded, class " + strB + " not found");
                                }
                                this.f61724f.add(strB);
                                return null;
                            }
                        }
                        g gVarA = a(oeVar, clsA, z2);
                        if (gVarA != null) {
                            if (com.applovin.impl.sdk.n.a()) {
                                this.f61721c.a("MediationAdapterManager", "Loaded " + strC);
                            }
                            this.f61723e.put(strB, clsA);
                            if (z2) {
                                this.f61719a.put(oeVar.b(), gVarA);
                            }
                            return gVarA;
                        }
                        if (com.applovin.impl.sdk.n.a()) {
                            this.f61721c.b("MediationAdapterManager", "Failed to load " + strC);
                        }
                        this.f61724f.add(strB);
                        return null;
                    }
                    if (com.applovin.impl.sdk.n.a()) {
                        this.f61721c.a("MediationAdapterManager", "Not attempting to load " + strC + " due to prior errors");
                    }
                    return null;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        throw new IllegalArgumentException("No adapter spec specified");
    }

    private g a(oe oeVar, Class cls, boolean z2) {
        try {
            return new g(oeVar, (MediationAdapterBase) cls.getConstructor(AppLovinSdk.class).newInstance(this.f61720b.q0()), z2, this.f61720b);
        } catch (Throwable th) {
            com.applovin.impl.sdk.n.c("MediationAdapterManager", "Failed to load adapter: " + oeVar, th);
            return null;
        }
    }

    public Collection a() {
        ArrayList arrayList;
        synchronized (this.f61725g) {
            try {
                arrayList = new ArrayList(this.f61726h.size());
                Iterator it = this.f61726h.iterator();
                while (it.hasNext()) {
                    arrayList.add(((a) it.next()).a());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return arrayList;
    }

    private Class a(String str) {
        try {
            Class<?> cls = Class.forName(str);
            if (MaxAdapter.class.isAssignableFrom(cls)) {
                return cls.asSubclass(MaxAdapter.class);
            }
            com.applovin.impl.sdk.n.h("MediationAdapterManager", str + YgVrd.PwXCx + MaxAdapter.class.getName() + "'.");
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }
}
