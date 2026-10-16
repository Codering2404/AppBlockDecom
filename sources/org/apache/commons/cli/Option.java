package org.apache.commons.cli;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public class Option implements Cloneable, Serializable {
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f145212a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f145213b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f145215d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f145216f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f145217g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f145218h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Object f145219i;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private char f145221k;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f145214c = "arg";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private List f145220j = new ArrayList();

    public Option(String str, String str2, boolean z2, String str3) {
        this.f145218h = -1;
        OptionValidator.c(str);
        this.f145212a = str;
        this.f145213b = str2;
        if (z2) {
            this.f145218h = 1;
        }
        this.f145215d = str3;
    }

    private void a(String str) {
        if (this.f145218h > 0 && this.f145220j.size() > this.f145218h - 1) {
            throw new RuntimeException("Cannot add value, list full.");
        }
        this.f145220j.add(str);
    }

    private boolean s() {
        return this.f145220j.isEmpty();
    }

    private void w(String str) {
        if (u()) {
            char cK = k();
            int iIndexOf = str.indexOf(cK);
            while (iIndexOf != -1 && this.f145220j.size() != this.f145218h - 1) {
                a(str.substring(0, iIndexOf));
                str = str.substring(iIndexOf + 1);
                iIndexOf = str.indexOf(cK);
            }
        }
        a(str);
    }

    void b(String str) {
        if (this.f145218h == -1) {
            throw new RuntimeException("NO_ARGS_ALLOWED");
        }
        w(str);
    }

    void c() {
        this.f145220j.clear();
    }

    public Object clone() {
        try {
            Option option = (Option) super.clone();
            option.f145220j = new ArrayList(this.f145220j);
            return option;
        } catch (CloneNotSupportedException e3) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("A CloneNotSupportedException was thrown: ");
            stringBuffer.append(e3.getMessage());
            throw new RuntimeException(stringBuffer.toString());
        }
    }

    public String e() {
        return this.f145214c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Option option = (Option) obj;
        String str = this.f145212a;
        if (str == null ? option.f145212a != null : !str.equals(option.f145212a)) {
            return false;
        }
        String str2 = this.f145213b;
        String str3 = option.f145213b;
        return str2 == null ? str3 == null : str2.equals(str3);
    }

    public String g() {
        return this.f145215d;
    }

    String h() {
        String str = this.f145212a;
        return str == null ? this.f145213b : str;
    }

    public int hashCode() {
        String str = this.f145212a;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f145213b;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String i() {
        return this.f145213b;
    }

    public String j() {
        return this.f145212a;
    }

    public char k() {
        return this.f145221k;
    }

    public String[] m() {
        if (s()) {
            return null;
        }
        List list = this.f145220j;
        return (String[]) list.toArray(new String[list.size()]);
    }

    public boolean o() {
        int i3 = this.f145218h;
        return i3 > 0 || i3 == -2;
    }

    public boolean p() {
        String str = this.f145214c;
        return str != null && str.length() > 0;
    }

    public boolean q() {
        int i3 = this.f145218h;
        return i3 > 1 || i3 == -2;
    }

    public boolean r() {
        return this.f145213b != null;
    }

    public boolean t() {
        return this.f145217g;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[ option: ");
        stringBuffer.append(this.f145212a);
        if (this.f145213b != null) {
            stringBuffer.append(" ");
            stringBuffer.append(this.f145213b);
        }
        stringBuffer.append(" ");
        if (q()) {
            stringBuffer.append("[ARG...]");
        } else if (o()) {
            stringBuffer.append(" [ARG]");
        }
        stringBuffer.append(" :: ");
        stringBuffer.append(this.f145215d);
        if (this.f145219i != null) {
            stringBuffer.append(" :: ");
            stringBuffer.append(this.f145219i);
        }
        stringBuffer.append(" ]");
        return stringBuffer.toString();
    }

    public boolean u() {
        return this.f145221k > 0;
    }

    public boolean v() {
        return this.f145216f;
    }
}
