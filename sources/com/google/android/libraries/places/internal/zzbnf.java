package com.google.android.libraries.places.internal;

import com.google.common.collect.ImmutableList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
class zzbnf implements zzbmm {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final int f76457a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final String f76458b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final List f76459c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected final List f76460d;

    protected zzbnf(int i3, String str, String str2, String str3, List list, List list2, boolean z2) {
        this.f76457a = i3;
        this.f76458b = str;
        this.f76459c = ImmutableList.t(list);
        this.f76460d = ImmutableList.t(list2);
    }

    public final int a() {
        return this.f76457a;
    }

    public final String toString() {
        String name = getClass().getName();
        int length = name.length();
        String str = this.f76458b;
        StringBuilder sb = new StringBuilder(length + 1 + str.length() + 1);
        sb.append(name);
        sb.append("(");
        sb.append(str);
        sb.append(")");
        return sb.toString();
    }
}
