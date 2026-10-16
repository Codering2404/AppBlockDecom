package com.applovin.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class es {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final es f59546f = new es();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final es f59547a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f59548b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map f59549c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected String f59550d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected final List f59551e;

    private es() {
        this.f59547a = null;
        this.f59548b = "";
        this.f59549c = Collections.EMPTY_MAP;
        this.f59550d = "";
        this.f59551e = Collections.EMPTY_LIST;
    }

    public List a(String str) {
        if (str == null) {
            throw new IllegalArgumentException("No name specified.");
        }
        ArrayList arrayList = new ArrayList(this.f59551e.size());
        for (es esVar : this.f59551e) {
            if (str.equalsIgnoreCase(esVar.c())) {
                arrayList.add(esVar);
            }
        }
        return arrayList;
    }

    public List b() {
        return Collections.unmodifiableList(this.f59551e);
    }

    public String c() {
        return this.f59548b;
    }

    public String d() {
        return this.f59550d;
    }

    public String toString() {
        return "XmlNode{elementName='" + this.f59548b + "', text='" + this.f59550d + "', attributes=" + this.f59549c + '}';
    }

    public es b(String str) {
        if (str == null) {
            throw new IllegalArgumentException("No name specified.");
        }
        if (this.f59551e.size() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(this);
        while (!arrayList.isEmpty()) {
            es esVar = (es) arrayList.get(0);
            arrayList.remove(0);
            if (str.equalsIgnoreCase(esVar.c())) {
                return esVar;
            }
            arrayList.addAll(esVar.b());
        }
        return null;
    }

    public es c(String str) {
        if (str == null) {
            throw new IllegalArgumentException("No name specified.");
        }
        for (es esVar : this.f59551e) {
            if (str.equalsIgnoreCase(esVar.c())) {
                return esVar;
            }
        }
        return null;
    }

    public Map a() {
        return this.f59549c;
    }

    public es(String str, Map map, es esVar) {
        this.f59547a = esVar;
        this.f59548b = str;
        this.f59549c = Collections.unmodifiableMap(map);
        this.f59551e = new ArrayList();
    }
}
