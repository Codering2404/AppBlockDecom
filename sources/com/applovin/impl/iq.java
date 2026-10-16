package com.applovin.impl;

import android.net.Uri;
import android.webkit.URLUtil;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class iq implements hh {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private a f60521a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Uri f60522b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f60523c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public enum a {
        UNSPECIFIED,
        STATIC,
        IFRAME,
        HTML
    }

    private iq() {
    }

    static iq a(es esVar, iq iqVar, com.applovin.impl.sdk.j jVar) {
        if (esVar == null) {
            throw new IllegalArgumentException("No node specified.");
        }
        if (jVar == null) {
            throw new IllegalArgumentException("No sdk specified.");
        }
        if (iqVar == null) {
            try {
                iqVar = new iq();
            } catch (Throwable th) {
                jVar.I();
                if (com.applovin.impl.sdk.n.a()) {
                    jVar.I().a("VastNonVideoResource", "Error occurred while initializing", th);
                }
                jVar.D().a("VastNonVideoResource", th);
                return null;
            }
        }
        if (iqVar.f60522b == null && !StringUtils.isValidString(iqVar.f60523c)) {
            String strA = a(esVar, "StaticResource");
            if (URLUtil.isValidUrl(strA)) {
                iqVar.f60522b = Uri.parse(strA);
                iqVar.f60521a = a.STATIC;
                return iqVar;
            }
            String strA2 = a(esVar, "IFrameResource");
            if (StringUtils.isValidString(strA2)) {
                iqVar.f60521a = a.IFRAME;
                if (URLUtil.isValidUrl(strA2)) {
                    iqVar.f60522b = Uri.parse(strA2);
                    return iqVar;
                }
                iqVar.f60523c = strA2;
                return iqVar;
            }
            String strA3 = a(esVar, "HTMLResource");
            if (StringUtils.isValidString(strA3)) {
                iqVar.f60521a = a.HTML;
                if (URLUtil.isValidUrl(strA3)) {
                    iqVar.f60522b = Uri.parse(strA3);
                    return iqVar;
                }
                iqVar.f60523c = strA3;
            }
        }
        return iqVar;
    }

    public String b() {
        return this.f60523c;
    }

    public Uri c() {
        return this.f60522b;
    }

    public a d() {
        return this.f60521a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof iq)) {
            return false;
        }
        iq iqVar = (iq) obj;
        if (this.f60521a != iqVar.f60521a) {
            return false;
        }
        Uri uri = this.f60522b;
        if (uri == null ? iqVar.f60522b != null : !uri.equals(iqVar.f60522b)) {
            return false;
        }
        String str = this.f60523c;
        String str2 = iqVar.f60523c;
        return str != null ? str.equals(str2) : str2 == null;
    }

    public int hashCode() {
        a aVar = this.f60521a;
        int iHashCode = (aVar != null ? aVar.hashCode() : 0) * 31;
        Uri uri = this.f60522b;
        int iHashCode2 = (iHashCode + (uri != null ? uri.hashCode() : 0)) * 31;
        String str = this.f60523c;
        return iHashCode2 + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "VastNonVideoResource{type=" + this.f60521a + ", resourceUri=" + this.f60522b + ", resourceContents='" + this.f60523c + "'}";
    }

    public static iq a(JSONObject jSONObject, com.applovin.impl.sdk.j jVar) {
        if (jSONObject == null) {
            return null;
        }
        String string = JsonUtils.getString(jSONObject, "type", null);
        a aVarValueOf = string == null ? null : a.valueOf(string);
        String string2 = JsonUtils.getString(jSONObject, "resource_uri", null);
        Uri uri = StringUtils.isValidString(string2) ? Uri.parse(string2) : null;
        iq iqVar = new iq();
        iqVar.f60521a = aVarValueOf;
        iqVar.f60522b = uri;
        iqVar.f60523c = JsonUtils.getString(jSONObject, "resource_contents", null);
        return iqVar;
    }

    public void a(String str) {
        this.f60523c = str;
    }

    public void a(Uri uri) {
        this.f60522b = uri;
    }

    private static String a(es esVar, String str) {
        es esVarC = esVar.c(str);
        if (esVarC != null) {
            return esVarC.d();
        }
        return null;
    }

    @Override // com.applovin.impl.hh
    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        a aVar = this.f60521a;
        JsonUtils.putString(jSONObject, "type", aVar == null ? null : aVar.toString());
        Uri uri = this.f60522b;
        JsonUtils.putString(jSONObject, "resource_uri", uri != null ? uri.toString() : null);
        JsonUtils.putString(jSONObject, "resource_contents", this.f60523c);
        return jSONObject;
    }
}
