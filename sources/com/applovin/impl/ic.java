package com.applovin.impl;

import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class ic implements Comparable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f60433a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f60434b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f60435c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final je f60436d;

    ic(String str, String str2, boolean z2, je jeVar) {
        this.f60433a = str;
        this.f60434b = str2;
        this.f60435c = z2;
        this.f60436d = jeVar;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(ic icVar) {
        return this.f60434b.compareToIgnoreCase(icVar.f60434b);
    }

    public List b() {
        List listL = this.f60436d.l();
        return (listL == null || listL.isEmpty()) ? Collections.singletonList(this.f60433a) : listL;
    }

    public String c() {
        return this.f60433a;
    }

    public je d() {
        return this.f60436d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            ic icVar = (ic) obj;
            String str = this.f60433a;
            if (str == null ? icVar.f60433a != null : !str.equals(icVar.f60433a)) {
                return false;
            }
            String str2 = this.f60434b;
            if (str2 == null ? icVar.f60434b != null : !str2.equals(icVar.f60434b)) {
                return false;
            }
            if (this.f60435c == icVar.f60435c) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        String str = this.f60433a;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f60434b;
        return ((iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + (this.f60435c ? 1 : 0);
    }

    public String a() {
        return this.f60434b;
    }
}
