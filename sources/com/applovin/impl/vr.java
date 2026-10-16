package com.applovin.impl;

import android.text.TextUtils;
import com.applovin.exoplayer2.common.base.Ascii;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class vr {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f64491f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f64493h;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private float f64500o;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f64486a = "";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f64487b = "";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Set f64488c = Collections.EMPTY_SET;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f64489d = "";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f64490e = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f64492g = false;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f64494i = false;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f64495j = -1;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f64496k = -1;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f64497l = -1;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f64498m = -1;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f64499n = -1;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f64501p = -1;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f64502q = false;

    public int a() {
        if (this.f64494i) {
            return this.f64493h;
        }
        throw new IllegalStateException("Background color not defined.");
    }

    public boolean b() {
        return this.f64502q;
    }

    public int c() {
        if (this.f64492g) {
            return this.f64491f;
        }
        throw new IllegalStateException("Font color not defined");
    }

    public String d() {
        return this.f64490e;
    }

    public float e() {
        return this.f64500o;
    }

    public int f() {
        return this.f64499n;
    }

    public int g() {
        return this.f64501p;
    }

    public int h() {
        int i3 = this.f64497l;
        if (i3 == -1 && this.f64498m == -1) {
            return -1;
        }
        return (i3 == 1 ? 1 : 0) | (this.f64498m == 1 ? 2 : 0);
    }

    public boolean i() {
        return this.f64494i;
    }

    public boolean j() {
        return this.f64492g;
    }

    public boolean k() {
        return this.f64495j == 1;
    }

    public boolean l() {
        return this.f64496k == 1;
    }

    public vr b(boolean z2) {
        this.f64502q = z2;
        return this;
    }

    public vr d(int i3) {
        this.f64501p = i3;
        return this;
    }

    public vr b(int i3) {
        this.f64491f = i3;
        this.f64492g = true;
        return this;
    }

    public void d(String str) {
        this.f64489d = str;
    }

    public int a(String str, String str2, Set set, String str3) {
        if (this.f64486a.isEmpty() && this.f64487b.isEmpty() && this.f64488c.isEmpty() && this.f64489d.isEmpty()) {
            return TextUtils.isEmpty(str2) ? 1 : 0;
        }
        int iA = a(a(a(0, this.f64486a, str, 1073741824), this.f64487b, str2, 2), this.f64489d, str3, 4);
        if (iA == -1 || !set.containsAll(this.f64488c)) {
            return 0;
        }
        return iA + (this.f64488c.size() * 4);
    }

    public vr c(int i3) {
        this.f64499n = i3;
        return this;
    }

    public vr d(boolean z2) {
        this.f64496k = z2 ? 1 : 0;
        return this;
    }

    public void b(String str) {
        this.f64486a = str;
    }

    public vr c(boolean z2) {
        this.f64498m = z2 ? 1 : 0;
        return this;
    }

    public void c(String str) {
        this.f64487b = str;
    }

    public vr a(int i3) {
        this.f64493h = i3;
        this.f64494i = true;
        return this;
    }

    public vr a(boolean z2) {
        this.f64497l = z2 ? 1 : 0;
        return this;
    }

    public vr a(String str) {
        this.f64490e = str == null ? null : Ascii.toLowerCase(str);
        return this;
    }

    public vr a(float f3) {
        this.f64500o = f3;
        return this;
    }

    public void a(String[] strArr) {
        this.f64488c = new HashSet(Arrays.asList(strArr));
    }

    private static int a(int i3, String str, String str2, int i4) {
        if (str.isEmpty() || i3 == -1) {
            return i3;
        }
        if (str.equals(str2)) {
            return i3 + i4;
        }
        return -1;
    }
}
