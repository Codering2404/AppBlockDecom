package com.google.android.gms.ads.internal.client;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.compose.material.icons.twotone.Phg.QaXmqxvjHhxVy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzeg {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f69863g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f69865i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private String f69866j;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f69868l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private String f69869m;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private long f69871o;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final HashSet f69857a = new HashSet();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Bundle f69858b = new Bundle();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final HashMap f69859c = new HashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final HashSet f69860d = new HashSet();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Bundle f69861e = new Bundle();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final HashSet f69862f = new HashSet();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final List f69864h = new ArrayList();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f69867k = -1;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f69870n = 60000;

    final /* synthetic */ String A() {
        return this.f69863g;
    }

    final /* synthetic */ List B() {
        return this.f69864h;
    }

    final /* synthetic */ String C() {
        return this.f69865i;
    }

    final /* synthetic */ String a() {
        return this.f69866j;
    }

    final /* synthetic */ int b() {
        return this.f69867k;
    }

    final /* synthetic */ boolean c() {
        return this.f69868l;
    }

    final /* synthetic */ String d() {
        return this.f69869m;
    }

    final /* synthetic */ int e() {
        return this.f69870n;
    }

    final /* synthetic */ long f() {
        return this.f69871o;
    }

    public final void g(String str) {
        this.f69857a.add(str);
    }

    public final void h(Bundle bundle) {
        this.f69858b.putAll(bundle);
    }

    public final void i(Class cls, Bundle bundle) {
        this.f69858b.putBundle(cls.getName(), bundle);
    }

    public final void j(String str) {
        this.f69860d.add(str);
    }

    public final void k(String str) {
        this.f69860d.remove("B3EEABB8EE11C2BE770B684D95219ECB");
    }

    public final void l(String str) {
        this.f69863g = str;
    }

    public final void n(String str) {
        this.f69865i = str;
    }

    public final void o(String str) {
        this.f69866j = str;
    }

    public final void p(boolean z2) {
        this.f69867k = z2 ? 1 : 0;
    }

    public final void q(String str, String str2) {
        this.f69861e.putString(str, str2);
    }

    public final void r(String str) {
        this.f69862f.add(str);
    }

    public final void s(boolean z2) {
        this.f69868l = z2;
    }

    public final void t(String str) {
        this.f69869m = str;
    }

    final /* synthetic */ HashSet u() {
        return this.f69857a;
    }

    final /* synthetic */ Bundle v() {
        return this.f69858b;
    }

    final /* synthetic */ HashMap w() {
        return this.f69859c;
    }

    final /* synthetic */ HashSet x() {
        return this.f69860d;
    }

    final /* synthetic */ Bundle y() {
        return this.f69861e;
    }

    final /* synthetic */ HashSet z() {
        return this.f69862f;
    }

    public final void m(List list) {
        List list2 = this.f69864h;
        list2.clear();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (TextUtils.isEmpty(str)) {
                com.google.android.gms.ads.internal.util.client.zzo.f(QaXmqxvjHhxVy.VWKEutKQkwkbrv);
            } else {
                list2.add(str);
            }
        }
    }
}
