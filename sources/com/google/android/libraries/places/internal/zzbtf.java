package com.google.android.libraries.places.internal;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzbtf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ArrayList f76849a = new ArrayList();

    public final zzbtf a(Object obj) {
        this.f76849a.add(String.valueOf(obj));
        return this;
    }

    public final zzbtf b(String str, Object obj) {
        String strValueOf = String.valueOf(obj);
        StringBuilder sb = new StringBuilder(str.length() + 1 + strValueOf.length());
        sb.append(str);
        sb.append("=");
        sb.append(strValueOf);
        this.f76849a.add(sb.toString());
        return this;
    }

    public final String toString() {
        return this.f76849a.toString();
    }
}
