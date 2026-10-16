package com.applovin.impl;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.applovin.impl.rn;
import com.applovin.impl.sdk.utils.StringUtils;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.ServerProtocol;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class qn implements SharedPreferences.OnSharedPreferenceChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.applovin.impl.sdk.j f62649a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final SharedPreferences f62650b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Integer f62651c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Integer f62652d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Integer f62653e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f62654f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f62655g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f62656h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f62657i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private String f62658j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final List f62659k;

    public qn(com.applovin.impl.sdk.j jVar) {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(com.applovin.impl.sdk.j.m());
        this.f62650b = defaultSharedPreferences;
        this.f62659k = new ArrayList();
        this.f62649a = jVar;
        defaultSharedPreferences.registerOnSharedPreferenceChangeListener(this);
        this.f62651c = a(uj.f64240p.a());
        this.f62652d = a(uj.f64241q.a());
        this.f62653e = h();
        this.f62654f = (String) vj.a(uj.f64243s, (Object) null, defaultSharedPreferences, false);
        this.f62655g = (String) vj.a(uj.f64244t, (Object) null, defaultSharedPreferences, false);
        this.f62656h = (String) vj.a(uj.f64245u, (Object) null, defaultSharedPreferences, false);
        this.f62657i = (String) vj.a(uj.f64247w, (Object) null, defaultSharedPreferences, false);
        this.f62658j = (String) vj.a(uj.f64249y, (Object) null, defaultSharedPreferences, false);
        c(this.f62655g);
    }

    private void a() {
        this.f62651c = null;
        this.f62653e = null;
        this.f62654f = null;
        this.f62655g = null;
        this.f62656h = null;
        Iterator it = this.f62659k.iterator();
        while (it.hasNext()) {
            ((rn) it.next()).a(null);
        }
    }

    private Integer h() {
        String strA = uj.f64242r.a();
        if (this.f62650b.contains(strA)) {
            Integer num = (Integer) vj.a(strA, null, Integer.class, this.f62650b, false);
            if (num != null) {
                if (num.intValue() == 1 || num.intValue() == 0) {
                    return num;
                }
                this.f62649a.I();
                if (com.applovin.impl.sdk.n.a()) {
                    this.f62649a.I().b("TcfManager", "Integer value (" + num + ") for " + strA + " is invalid - setting GDPR Applies to null");
                }
                return null;
            }
            Long l3 = (Long) vj.a(strA, null, Long.class, this.f62650b, false);
            if (l3 != null) {
                if (l3.longValue() == 1 || l3.longValue() == 0) {
                    return Integer.valueOf(l3.intValue());
                }
                this.f62649a.I();
                if (com.applovin.impl.sdk.n.a()) {
                    this.f62649a.I().b("TcfManager", "Long value (" + l3 + ") for " + strA + " is invalid - setting GDPR Applies to null");
                }
                return null;
            }
            Boolean bool = (Boolean) vj.a(strA, null, Boolean.class, this.f62650b, false);
            if (bool != null) {
                return Integer.valueOf(bool.booleanValue() ? 1 : 0);
            }
            String str = (String) vj.a(strA, null, String.class, this.f62650b, false);
            if (str != null) {
                if (AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(str) || ServerProtocol.DIALOG_RETURN_SCOPES_TRUE.equals(str)) {
                    return 1;
                }
                if (AppEventsConstants.EVENT_PARAM_VALUE_NO.equals(str) || "false".equals(str)) {
                    return 0;
                }
                this.f62649a.I();
                if (com.applovin.impl.sdk.n.a()) {
                    this.f62649a.I().b("TcfManager", "String value (" + str + ") for " + strA + " is invalid - setting GDPR Applies to null");
                }
                return null;
            }
        }
        return null;
    }

    public boolean b() {
        return tn.a(this.f62655g);
    }

    public String c() {
        return this.f62655g;
    }

    public String d() {
        return on.a(this.f62651c);
    }

    public Integer e() {
        return this.f62651c;
    }

    public Integer f() {
        return this.f62652d;
    }

    public Integer g() {
        return this.f62653e;
    }

    public List i() {
        return this.f62659k;
    }

    public String j() {
        return a("CMP Name", d()) + a("CMP SDK ID", this.f62651c) + a("CMP SDK Version", this.f62652d) + a(uj.f64242r.a(), this.f62653e) + a(uj.f64243s.a(), this.f62654f) + a(uj.f64244t.a(), this.f62655g);
    }

    public String k() {
        return this.f62654f;
    }

    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        if (str == null) {
            this.f62649a.I();
            if (com.applovin.impl.sdk.n.a()) {
                this.f62649a.I().a("TcfManager", "SharedPreferences are cleared - setting all stored TC data to null");
            }
            a();
            return;
        }
        if (str.equals(uj.f64240p.a())) {
            this.f62651c = a(str);
            this.f62649a.I();
            if (com.applovin.impl.sdk.n.a()) {
                this.f62649a.I().a("TcfManager", "SharedPreferences entry updated - key: " + str + ", value: " + this.f62651c);
            }
            this.f62649a.L0();
            return;
        }
        if (str.equals(uj.f64241q.a())) {
            this.f62652d = a(str);
            this.f62649a.I();
            if (com.applovin.impl.sdk.n.a()) {
                this.f62649a.I().a("TcfManager", "SharedPreferences entry updated - key: " + str + ", value: " + this.f62652d);
                return;
            }
            return;
        }
        if (str.equals(uj.f64242r.a())) {
            this.f62653e = h();
            this.f62649a.I();
            if (com.applovin.impl.sdk.n.a()) {
                this.f62649a.I().a("TcfManager", "SharedPreferences entry updated - key: " + str + ", value: " + this.f62653e);
                return;
            }
            return;
        }
        if (str.equals(uj.f64243s.a())) {
            this.f62654f = (String) vj.a(str, (Object) null, String.class, sharedPreferences);
            this.f62649a.I();
            if (com.applovin.impl.sdk.n.a()) {
                this.f62649a.I().a("TcfManager", "SharedPreferences entry updated - key: " + str + ", value: " + this.f62654f);
            }
            this.f62649a.L0();
            return;
        }
        if (str.equals(uj.f64244t.a())) {
            this.f62655g = (String) vj.a(str, (Object) null, String.class, sharedPreferences);
            this.f62649a.I();
            if (com.applovin.impl.sdk.n.a()) {
                this.f62649a.I().a("TcfManager", "SharedPreferences entry updated - key: " + str + ", value: " + this.f62655g);
            }
            c(this.f62655g);
            b(this.f62655g);
            return;
        }
        if (str.equals(uj.f64245u.a())) {
            this.f62656h = (String) vj.a(str, (Object) null, String.class, sharedPreferences);
            this.f62649a.I();
            if (com.applovin.impl.sdk.n.a()) {
                this.f62649a.I().a("TcfManager", "SharedPreferences entry updated - key: " + str + ", value: " + this.f62656h);
            }
            d(this.f62656h);
            return;
        }
        if (str.equals(uj.f64246v.a())) {
            String str2 = (String) vj.a(str, (Object) null, String.class, sharedPreferences);
            this.f62649a.I();
            if (com.applovin.impl.sdk.n.a()) {
                this.f62649a.I().a("TcfManager", "SharedPreferences entry updated - key: " + str + ", value: " + str2);
                return;
            }
            return;
        }
        if (str.equals(uj.f64247w.a())) {
            this.f62657i = (String) vj.a(str, (Object) null, String.class, sharedPreferences);
            this.f62649a.I();
            if (com.applovin.impl.sdk.n.a()) {
                this.f62649a.I().a("TcfManager", "SharedPreferences entry updated - key: " + str + ", value: " + this.f62657i);
                return;
            }
            return;
        }
        if (str.equals(uj.f64248x.a())) {
            String str3 = (String) vj.a(str, (Object) null, String.class, sharedPreferences);
            this.f62649a.I();
            if (com.applovin.impl.sdk.n.a()) {
                this.f62649a.I().a("TcfManager", "SharedPreferences entry updated - key: " + str + ", value: " + str3);
                return;
            }
            return;
        }
        if (str.equals(uj.f64249y.a())) {
            this.f62658j = (String) vj.a(str, (Object) null, String.class, sharedPreferences);
            this.f62649a.I();
            if (com.applovin.impl.sdk.n.a()) {
                this.f62649a.I().a("TcfManager", "SharedPreferences entry updated - key: " + str + ", value: " + this.f62658j);
                return;
            }
            return;
        }
        if (str.contains("IABTCF_PublisherRestrictions")) {
            String str4 = (String) vj.a(str, (Object) null, String.class, sharedPreferences);
            this.f62649a.I();
            if (com.applovin.impl.sdk.n.a()) {
                this.f62649a.I().a("TcfManager", "SharedPreferences entry updated - key: " + str + ", value: " + str4);
            }
        }
    }

    public Boolean b(int i3) {
        String str = this.f62657i;
        if (str == null) {
            return null;
        }
        return Boolean.valueOf(tn.a(str, i3 - 1));
    }

    public Boolean c(int i3) {
        String str = this.f62658j;
        if (str == null) {
            return null;
        }
        return Boolean.valueOf(tn.a(str, i3 - 1));
    }

    public Boolean d(int i3) {
        String str = this.f62656h;
        if (str == null) {
            return null;
        }
        return Boolean.valueOf(tn.a(str, i3 - 1));
    }

    private void b(String str) {
        for (rn rnVar : this.f62659k) {
            if (rnVar.f() == rn.a.ATP_NETWORK && rnVar.d() != null) {
                rnVar.a(tn.a(rnVar.d().intValue(), str));
            }
        }
    }

    private void c(String str) {
        this.f62649a.I();
        if (com.applovin.impl.sdk.n.a()) {
            this.f62649a.I().a("TcfManager", "Attempting to update consent from Additional Consent string: " + str);
        }
        Boolean boolA = tn.a(1301, str);
        if (boolA != null) {
            if (boolA.booleanValue()) {
                this.f62649a.I();
                if (com.applovin.impl.sdk.n.a()) {
                    this.f62649a.I().a("TcfManager", "Found AppLovin ID in the list of consented ATP IDs - setting user consent to true");
                }
                a4.b(true, com.applovin.impl.sdk.j.m());
            } else {
                this.f62649a.I();
                if (com.applovin.impl.sdk.n.a()) {
                    this.f62649a.I().a("TcfManager", "Could not find AppLovin ID in the list of consented ATP IDs - setting user consent to false");
                }
                a4.b(false, com.applovin.impl.sdk.j.m());
            }
            this.f62649a.L0();
            return;
        }
        this.f62649a.I();
        if (com.applovin.impl.sdk.n.a()) {
            this.f62649a.I().a("TcfManager", "AC string is not valid or AppLovin was not listed on the CMP flow - no consent update");
        }
    }

    private void d(String str) {
        if (str != null) {
            for (rn rnVar : this.f62659k) {
                if (rnVar.f() == rn.a.TCF_VENDOR && rnVar.d() != null) {
                    rnVar.a(Boolean.valueOf(tn.a(str, rnVar.d().intValue() - 1)));
                }
            }
            return;
        }
        Iterator it = this.f62659k.iterator();
        while (it.hasNext()) {
            ((rn) it.next()).a(null);
        }
    }

    public Boolean a(int i3) {
        return tn.a(i3, this.f62655g);
    }

    private String a(String str, Object obj) {
        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        sb.append(str);
        sb.append(" - ");
        sb.append(obj != null ? obj.toString() : "No value set");
        return sb.toString();
    }

    private Integer a(String str) {
        if (this.f62650b.contains(str)) {
            Integer num = (Integer) vj.a(str, null, Integer.class, this.f62650b, false);
            if (num != null) {
                return num;
            }
            Long l3 = (Long) vj.a(str, null, Long.class, this.f62650b, false);
            if (l3 != null && l3.longValue() >= -2147483648L && l3.longValue() <= 2147483647L) {
                return Integer.valueOf(l3.intValue());
            }
            String str2 = (String) vj.a(str, null, String.class, this.f62650b, false);
            if (str2 != null) {
                if (StringUtils.isNumeric(str2)) {
                    return Integer.valueOf(Integer.parseInt(str2));
                }
                this.f62649a.I();
                if (com.applovin.impl.sdk.n.a()) {
                    this.f62649a.I().b("TcfManager", "String value (" + str2 + ") for " + str + " is not numeric - storing value as null");
                }
            }
        }
        return null;
    }

    public void a(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            this.f62659k.add(((je) it.next()).t());
        }
        d(this.f62656h);
        b(this.f62655g);
    }
}
