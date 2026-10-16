package com.applovin.impl;

import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.sdk.AppLovinAdLoadListener;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class zm extends yl {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final AppLovinAdLoadListener f65466h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final a f65467i;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class a extends eq {
        a(JSONObject jSONObject, JSONObject jSONObject2, com.applovin.impl.sdk.j jVar) {
            super(jSONObject, jSONObject2, jVar);
        }

        void a(es esVar) {
            if (esVar == null) {
                throw new IllegalArgumentException("No aggregated vast response specified");
            }
            this.f59532b.add(esVar);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class b extends zm {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private final String f65468j;

        b(String str, eq eqVar, AppLovinAdLoadListener appLovinAdLoadListener, com.applovin.impl.sdk.j jVar) {
            super(eqVar, appLovinAdLoadListener, jVar);
            this.f65468j = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            es esVarB = b(this.f65468j);
            if (esVarB != null) {
                a(esVarB);
                return;
            }
            if (com.applovin.impl.sdk.n.a()) {
                this.f65233c.b(this.f65232b, "Unable to process XML: " + this.f65468j);
            }
            c(this.f65468j);
            a(fq.XML_PARSING);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class c extends zm {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private final JSONObject f65469j;

        c(eq eqVar, AppLovinAdLoadListener appLovinAdLoadListener, com.applovin.impl.sdk.j jVar) {
            super(eqVar, appLovinAdLoadListener, jVar);
            this.f65469j = eqVar.b();
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.applovin.impl.sdk.n.a()) {
                this.f65233c.a(this.f65232b, "Processing SDK JSON response...");
            }
            String string = JsonUtils.getString(this.f65469j, "xml", null);
            if (!StringUtils.isValidString(string)) {
                if (com.applovin.impl.sdk.n.a()) {
                    this.f65233c.b(this.f65232b, "No VAST response received.");
                }
                a(fq.NO_WRAPPER_RESPONSE);
                return;
            }
            if (string.length() >= ((Integer) this.f65231a.a(sj.F4)).intValue()) {
                if (com.applovin.impl.sdk.n.a()) {
                    this.f65233c.b(this.f65232b, "VAST response is over max length");
                }
                a(fq.XML_PARSING);
                return;
            }
            es esVarB = b(string);
            if (esVarB != null) {
                a(esVarB);
                return;
            }
            if (com.applovin.impl.sdk.n.a()) {
                this.f65233c.b(this.f65232b, "Unable to process XML: " + string);
            }
            c(string);
            a(fq.XML_PARSING);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class d extends zm {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private final es f65470j;

        d(es esVar, eq eqVar, AppLovinAdLoadListener appLovinAdLoadListener, com.applovin.impl.sdk.j jVar) {
            super(eqVar, appLovinAdLoadListener, jVar);
            if (esVar == null) {
                throw new IllegalArgumentException("No response specified.");
            }
            if (eqVar == null) {
                throw new IllegalArgumentException("No context specified.");
            }
            if (appLovinAdLoadListener == null) {
                throw new IllegalArgumentException("No callback specified.");
            }
            this.f65470j = esVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.applovin.impl.sdk.n.a()) {
                this.f65233c.a(this.f65232b, "Processing VAST Wrapper response...");
            }
            a(this.f65470j);
        }
    }

    zm(eq eqVar, AppLovinAdLoadListener appLovinAdLoadListener, com.applovin.impl.sdk.j jVar) {
        super("TaskProcessVastResponse", jVar);
        if (eqVar == null) {
            throw new IllegalArgumentException("No context specified.");
        }
        this.f65466h = appLovinAdLoadListener;
        this.f65467i = (a) eqVar;
    }

    void a(es esVar) {
        int iD = this.f65467i.d();
        if (com.applovin.impl.sdk.n.a()) {
            this.f65233c.a(this.f65232b, "Finished parsing XML at depth " + iD);
        }
        this.f65467i.a(esVar);
        if (!mq.b(esVar)) {
            if (!mq.a(esVar)) {
                if (com.applovin.impl.sdk.n.a()) {
                    this.f65233c.b(this.f65232b, "VAST response is an error");
                }
                a(fq.NO_WRAPPER_RESPONSE);
                return;
            } else {
                if (com.applovin.impl.sdk.n.a()) {
                    this.f65233c.a(this.f65232b, "VAST response is inline. Rendering ad...");
                }
                this.f65231a.i0().a(new cn(this.f65467i, this.f65466h, this.f65231a));
                return;
            }
        }
        int iIntValue = ((Integer) this.f65231a.a(sj.G4)).intValue();
        if (iD < iIntValue) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f65233c.a(this.f65232b, "VAST response is wrapper. Resolving...");
            }
            this.f65231a.i0().a(new hn(this.f65467i, this.f65466h, this.f65231a));
            return;
        }
        if (com.applovin.impl.sdk.n.a()) {
            this.f65233c.b(this.f65232b, "Reached beyond max wrapper depth of " + iIntValue);
        }
        a(fq.WRAPPER_LIMIT_REACHED);
    }

    protected es b(String str) {
        try {
            return fs.a(str, this.f65231a);
        } catch (Throwable th) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f65233c.a(this.f65232b, "Failed to process VAST response", th);
            }
            a(fq.XML_PARSING);
            return null;
        }
    }

    protected void c(String str) {
        if (str == null) {
            return;
        }
        Iterator<String> it = StringUtils.getRegexMatches(StringUtils.match(str, (String) this.f65231a.a(sj.Z4)), 1).iterator();
        while (it.hasNext()) {
            es esVarB = b("<VAST>" + it.next() + "</VAST>");
            if (esVarB != null) {
                this.f65467i.a(esVarB);
            }
        }
    }

    public static zm a(JSONObject jSONObject, JSONObject jSONObject2, AppLovinAdLoadListener appLovinAdLoadListener, com.applovin.impl.sdk.j jVar) {
        return new c(new a(jSONObject, jSONObject2, jVar), appLovinAdLoadListener, jVar);
    }

    public static zm a(String str, JSONObject jSONObject, JSONObject jSONObject2, AppLovinAdLoadListener appLovinAdLoadListener, com.applovin.impl.sdk.j jVar) {
        return new b(str, new a(jSONObject, jSONObject2, jVar), appLovinAdLoadListener, jVar);
    }

    public static zm a(es esVar, eq eqVar, AppLovinAdLoadListener appLovinAdLoadListener, com.applovin.impl.sdk.j jVar) {
        return new d(esVar, eqVar, appLovinAdLoadListener, jVar);
    }

    void a(fq fqVar) {
        if (com.applovin.impl.sdk.n.a()) {
            this.f65233c.b(this.f65232b, "Failed to process VAST response due to VAST error code " + fqVar);
        }
        mq.a(this.f65467i, this.f65466h, fqVar, -6, this.f65231a);
    }
}
