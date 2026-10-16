package com.applovin.impl;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class x0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f64770a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f64771b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f64772c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f64773d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f64774e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f64775f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f64776g;

    public x0(String str) {
        this(str, -1);
    }

    protected boolean a(Object obj) {
        return obj instanceof x0;
    }

    public String b() {
        return this.f64770a;
    }

    public String c() {
        return this.f64771b;
    }

    public String d() {
        return this.f64774e;
    }

    public String e() {
        return this.f64772c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof x0)) {
            return false;
        }
        x0 x0Var = (x0) obj;
        if (!x0Var.a(this)) {
            return false;
        }
        String strB = b();
        String strB2 = x0Var.b();
        if (strB != null ? !strB.equals(strB2) : strB2 != null) {
            return false;
        }
        String strC = c();
        String strC2 = x0Var.c();
        if (strC != null ? !strC.equals(strC2) : strC2 != null) {
            return false;
        }
        String strE = e();
        String strE2 = x0Var.e();
        if (strE != null ? !strE.equals(strE2) : strE2 != null) {
            return false;
        }
        String strA = a();
        String strA2 = x0Var.a();
        return strA != null ? strA.equals(strA2) : strA2 == null;
    }

    public int f() {
        return this.f64775f;
    }

    public boolean g() {
        return this.f64770a.equals("applovin.com");
    }

    public boolean h() {
        return this.f64776g;
    }

    public int hashCode() {
        String strB = b();
        int iHashCode = strB == null ? 43 : strB.hashCode();
        String strC = c();
        int iHashCode2 = ((iHashCode + 59) * 59) + (strC == null ? 43 : strC.hashCode());
        String strE = e();
        int iHashCode3 = (iHashCode2 * 59) + (strE == null ? 43 : strE.hashCode());
        String strA = a();
        return (iHashCode3 * 59) + (strA != null ? strA.hashCode() : 43);
    }

    public String toString() {
        return "AppAdsTxtEntry(domainName=" + b() + ", publisherId=" + c() + ", relationship=" + e() + ", certificateAuthorityId=" + a() + ", rawValue=" + d() + ", rowNumber=" + f() + ", valid=" + h() + ")";
    }

    public x0(String str, int i3) {
        this.f64774e = str;
        this.f64775f = i3;
        String[] strArrSplit = str.split(",");
        boolean z2 = strArrSplit.length == 3 || strArrSplit.length == 4;
        this.f64776g = z2;
        if (z2) {
            this.f64770a = a(strArrSplit[0]);
            this.f64771b = a(strArrSplit[1]);
            this.f64772c = a(strArrSplit[2]);
            this.f64773d = strArrSplit.length == 4 ? a(strArrSplit[3]) : "";
            return;
        }
        this.f64770a = "";
        this.f64771b = "";
        this.f64772c = "";
        this.f64773d = "";
    }

    public String a() {
        return this.f64773d;
    }

    private String a(String str) {
        return str.replace((char) 173, ' ').trim();
    }
}
