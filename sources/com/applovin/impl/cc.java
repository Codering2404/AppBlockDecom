package com.applovin.impl;

import android.content.Context;
import android.text.SpannedString;
import android.text.TextUtils;
import com.applovin.sdk.R;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class cc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected c f58862a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected boolean f58863b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected SpannedString f58864c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected SpannedString f58865d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected String f58866e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected String f58867f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected int f58868g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    protected int f58869h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    protected int f58870i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    protected int f58871j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    protected int f58872k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    protected int f58873l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    protected boolean f58874m;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final c f58875a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        boolean f58876b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        SpannedString f58877c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        SpannedString f58878d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        String f58879e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        String f58880f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        int f58881g = 0;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        int f58882h = 0;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        int f58883i = -16777216;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        int f58884j = -16777216;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        int f58885k = 0;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        int f58886l = 0;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        boolean f58887m;

        public b(c cVar) {
            this.f58875a = cVar;
        }

        public b a(String str) {
            this.f58880f = str;
            return this;
        }

        public b b(String str) {
            this.f58879e = str;
            return this;
        }

        public b c(String str) {
            return a(!TextUtils.isEmpty(str) ? new SpannedString(str) : null);
        }

        public b d(String str) {
            return b(!TextUtils.isEmpty(str) ? new SpannedString(str) : null);
        }

        public b a(int i3) {
            this.f58882h = i3;
            return this;
        }

        public b b(int i3) {
            this.f58886l = i3;
            return this;
        }

        public b a(Context context) {
            this.f58882h = R.drawable.applovin_ic_disclosure_arrow;
            this.f58886l = t3.a(R.color.applovin_sdk_disclosureButtonColor, context);
            return this;
        }

        public b b(boolean z2) {
            this.f58887m = z2;
            return this;
        }

        public b c(int i3) {
            this.f58884j = i3;
            return this;
        }

        public b d(int i3) {
            this.f58883i = i3;
            return this;
        }

        public b b(SpannedString spannedString) {
            this.f58877c = spannedString;
            return this;
        }

        public b a(boolean z2) {
            this.f58876b = z2;
            return this;
        }

        public b a(SpannedString spannedString) {
            this.f58878d = spannedString;
            return this;
        }

        public cc a() {
            return new cc(this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public enum c {
        SECTION(0),
        SECTION_CENTERED(1),
        SIMPLE(2),
        DETAIL(3),
        RIGHT_DETAIL(4),
        COUNT(5);


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f58895a;

        c(int i3) {
            this.f58895a = i3;
        }

        public int b() {
            return this == SECTION ? R.layout.mediation_debugger_list_section : this == SECTION_CENTERED ? R.layout.mediation_debugger_list_section_centered : this == SIMPLE ? android.R.layout.simple_list_item_1 : this == DETAIL ? R.layout.applovin_debugger_list_item_detail : R.layout.mediation_debugger_list_item_right_detail;
        }

        public int c() {
            return this.f58895a;
        }
    }

    private cc(b bVar) {
        this.f58868g = 0;
        this.f58869h = 0;
        this.f58870i = -16777216;
        this.f58871j = -16777216;
        this.f58872k = 0;
        this.f58873l = 0;
        this.f58862a = bVar.f58875a;
        this.f58863b = bVar.f58876b;
        this.f58864c = bVar.f58877c;
        this.f58865d = bVar.f58878d;
        this.f58866e = bVar.f58879e;
        this.f58867f = bVar.f58880f;
        this.f58868g = bVar.f58881g;
        this.f58869h = bVar.f58882h;
        this.f58870i = bVar.f58883i;
        this.f58871j = bVar.f58884j;
        this.f58872k = bVar.f58885k;
        this.f58873l = bVar.f58886l;
        this.f58874m = bVar.f58887m;
    }

    public static b a() {
        return a(c.RIGHT_DETAIL);
    }

    public static int n() {
        return c.COUNT.c();
    }

    public String b() {
        return this.f58867f;
    }

    public String c() {
        return this.f58866e;
    }

    public int d() {
        return this.f58869h;
    }

    public int e() {
        return this.f58873l;
    }

    public SpannedString f() {
        return this.f58865d;
    }

    public int g() {
        return this.f58871j;
    }

    public int h() {
        return this.f58868g;
    }

    public int i() {
        return this.f58872k;
    }

    public int j() {
        return this.f58862a.b();
    }

    public SpannedString k() {
        return this.f58864c;
    }

    public int l() {
        return this.f58870i;
    }

    public int m() {
        return this.f58862a.c();
    }

    public boolean o() {
        return this.f58863b;
    }

    public boolean p() {
        return this.f58874m;
    }

    public static b a(c cVar) {
        return new b(cVar);
    }

    protected cc(c cVar) {
        this.f58868g = 0;
        this.f58869h = 0;
        this.f58870i = -16777216;
        this.f58871j = -16777216;
        this.f58872k = 0;
        this.f58873l = 0;
        this.f58862a = cVar;
    }
}
