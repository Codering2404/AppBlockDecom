package com.applovin.impl;

import android.text.TextUtils;
import com.applovin.communicator.AppLovinCommunicatorMessage;
import com.applovin.communicator.AppLovinCommunicatorSubscriber;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.adapter.MaxAdViewAdapter;
import com.applovin.mediation.adapter.MaxAdapter;
import com.applovin.mediation.adapter.MaxAppOpenAdapter;
import com.applovin.mediation.adapter.MaxInterstitialAdapter;
import com.applovin.mediation.adapter.MaxNativeAdAdapter;
import com.applovin.mediation.adapter.MaxRewardedAdapter;
import com.applovin.mediation.adapter.MaxRewardedInterstitialAdapter;
import d.qFm.sECyKyO;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class je implements Comparable, AppLovinCommunicatorSubscriber {
    private final List A;
    private final List B;
    private final List C;
    private final Map D;
    private final boolean E;
    private final boolean F;
    private final rn G;
    private final boolean H;
    private final String I;
    private final Map J;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.applovin.impl.sdk.j f60702a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final a f60703b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f60704c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f60705d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f60706f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f60707g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final boolean f60708h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final boolean f60709i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final boolean f60710j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final boolean f60711k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final boolean f60712l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final boolean f60713m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final boolean f60714n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final String f60715o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final String f60716p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private String f60717q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private String f60718r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final String f60719s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final String f60720t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final String f60721u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final String f60722v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final int f60723w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final List f60724x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final List f60725y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private final List f60726z;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public enum a {
        MISSING("MISSING"),
        INCOMPLETE_INTEGRATION("INCOMPLETE INTEGRATION"),
        INVALID_INTEGRATION("INVALID INTEGRATION"),
        COMPLETE("COMPLETE");


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f60732a;

        a(String str) {
            this.f60732a = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String b() {
            return this.f60732a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public enum b {
        NOT_SUPPORTED("Not Supported", -65536, "This network does not support test mode."),
        INVALID_INTEGRATION("Invalid Integration", -65536, "Please address all the integration issue(s) marked in red above."),
        NOT_INITIALIZED("Not Initialized", -65536, "Please configure this network in your MAX dashboard."),
        DISABLED("Enable", -16776961, "Please re-launch the app to enable test ads."),
        READY("", -16776961, "");


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f60739a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f60740b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f60741c;

        b(String str, int i3, String str2) {
            this.f60739a = str;
            this.f60740b = i3;
            this.f60741c = str2;
        }

        public String b() {
            return this.f60741c;
        }

        public String c() {
            return this.f60739a;
        }

        public int d() {
            return this.f60740b;
        }
    }

    public boolean A() {
        return this.f60706f;
    }

    public boolean B() {
        return this.f60707g;
    }

    public boolean C() {
        return this.H;
    }

    public boolean D() {
        return this.f60714n;
    }

    public boolean E() {
        return this.f60705d;
    }

    public boolean F() {
        return this.f60703b == a.MISSING && this.f60711k;
    }

    public boolean G() {
        return this.F;
    }

    public boolean H() {
        return this.f60712l;
    }

    public boolean I() {
        return this.f60713m;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(je jeVar) {
        return this.f60716p.compareToIgnoreCase(jeVar.f60716p);
    }

    public String b() {
        return this.f60717q;
    }

    public String c() {
        return this.f60719s;
    }

    public Map d() {
        return this.J;
    }

    public String e() {
        return this.I;
    }

    public List f() {
        return this.f60726z;
    }

    public String g() {
        return this.f60716p;
    }

    @Override // com.applovin.communicator.AppLovinCommunicatorEntity
    public String getCommunicatorId() {
        return "MediatedNetwork";
    }

    public int h() {
        return this.f60723w;
    }

    public int i() {
        return this.f60704c;
    }

    public final String j() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n---------- ");
        sb.append(this.f60715o);
        sb.append(" ----------");
        sb.append("\nStatus  - ");
        sb.append(this.f60703b.b());
        sb.append("\nSDK     - ");
        String str = "UNAVAILABLE";
        sb.append((!this.f60705d || TextUtils.isEmpty(this.f60718r)) ? "UNAVAILABLE" : this.f60718r);
        sb.append("\nAdapter - ");
        if (this.f60706f && !TextUtils.isEmpty(this.f60719s)) {
            str = this.f60719s;
        }
        sb.append(str);
        for (gh ghVar : n()) {
            if (!ghVar.c()) {
                sb.append("\n* MISSING ");
                sb.append(ghVar.b());
                sb.append(": ");
                sb.append(ghVar.a());
            }
        }
        for (o6 o6Var : f()) {
            if (!o6Var.c()) {
                sb.append("\n* MISSING ");
                sb.append(o6Var.b());
                sb.append(": ");
                sb.append(o6Var.a());
            }
        }
        return sb.toString();
    }

    public String k() {
        return this.f60720t;
    }

    public List l() {
        return this.B;
    }

    public String m() {
        return this.f60715o;
    }

    public List n() {
        return this.f60725y;
    }

    public final com.applovin.impl.sdk.j o() {
        return this.f60702a;
    }

    public String p() {
        return this.f60718r;
    }

    public a q() {
        return this.f60703b;
    }

    public List r() {
        return this.f60724x;
    }

    public List s() {
        return this.A;
    }

    public rn t() {
        return this.G;
    }

    public String toString() {
        return "MediatedNetwork{name=" + this.f60715o + ", displayName=" + this.f60716p + ", sdkAvailable=" + this.f60705d + ", sdkVersion=" + this.f60718r + ", adapterAvailable=" + this.f60706f + ", adapterVersion=" + this.f60719s + "}";
    }

    public List u() {
        return this.C;
    }

    public String v() {
        return this.f60721u;
    }

    public String w() {
        return this.f60722v;
    }

    public Map x() {
        return this.D;
    }

    public b y() {
        if (!this.f60709i) {
            return b.NOT_SUPPORTED;
        }
        a aVar = this.f60703b;
        return (aVar == a.COMPLETE || (aVar == a.INCOMPLETE_INTEGRATION && E() && A())) ? !this.f60702a.k0().c() ? b.DISABLED : (this.f60710j && (this.f60704c == MaxAdapter.InitializationStatus.INITIALIZED_FAILURE.getCode() || this.f60704c == MaxAdapter.InitializationStatus.INITIALIZING.getCode())) ? b.NOT_INITIALIZED : b.READY : b.INVALID_INTEGRATION;
    }

    public boolean z() {
        return this.E;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(12:26|(4:107|27|103|28)|(3:111|29|(2:31|(4:33|(1:39)(1:36)|105|40)(0))(1:44))|(3:113|45|46)|109|54|55|56|57|101|58|59) */
    /* JADX WARN: Can't wrap try/catch for region: R(15:26|107|27|103|28|(3:111|29|(2:31|(4:33|(1:39)(1:36)|105|40)(0))(1:44))|(3:113|45|46)|109|54|55|56|57|101|58|59) */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x01f0, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x01f3, code lost:
    
        r18 = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x01f6, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x01f7, code lost:
    
        r17 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x01fa, code lost:
    
        r21.I();
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0201, code lost:
    
        if (com.applovin.impl.sdk.n.a() != false) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0203, code lost:
    
        r21.I().a("MediatedNetwork", "Failed to check if adapter overrides MaxNativeAdAdapter", r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x020c, code lost:
    
        r7 = r17;
        r0 = r18;
        r4 = false;
     */
    /* JADX WARN: Removed duplicated region for block: B:39:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x024c A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0250  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0262  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x026e  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x02b2  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x02c1  */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public je(org.json.JSONObject r20, com.applovin.impl.sdk.j r21) {
        /*
            Method dump skipped, instruction units count: 800
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.je.<init>(org.json.JSONObject, com.applovin.impl.sdk.j):void");
    }

    private a a() {
        a aVar = this.f60705d ? this.f60706f ? a.COMPLETE : this.f60708h ? a.MISSING : a.INCOMPLETE_INTEGRATION : this.f60706f ? a.INCOMPLETE_INTEGRATION : a.MISSING;
        if (aVar == a.MISSING) {
            return aVar;
        }
        Iterator it = this.f60725y.iterator();
        while (it.hasNext()) {
            if (!((gh) it.next()).c()) {
                return a.INVALID_INTEGRATION;
            }
        }
        Iterator it2 = this.f60726z.iterator();
        while (it2.hasNext()) {
            if (!((o6) it2.next()).c()) {
                return a.INVALID_INTEGRATION;
            }
        }
        return (!this.f60714n || com.applovin.impl.sdk.j.w0()) ? aVar : a.INVALID_INTEGRATION;
    }

    @Override // com.applovin.communicator.AppLovinCommunicatorSubscriber
    public void onMessageReceived(AppLovinCommunicatorMessage appLovinCommunicatorMessage) {
        String string = appLovinCommunicatorMessage.getMessageData().getString("adapter_class", sECyKyO.cTCpIraixNCBBUE);
        if (this.f60717q.equals(string)) {
            this.f60704c = appLovinCommunicatorMessage.getMessageData().getInt("init_status", 0);
            MaxAdapter maxAdapterA = ze.a(string, this.f60702a);
            if (maxAdapterA != null) {
                String strA = ze.a(maxAdapterA);
                if (!this.f60718r.equals(strA)) {
                    this.f60718r = strA;
                    this.f60702a.q().a(this.f60718r, string);
                }
            }
        }
    }

    private List a(JSONObject jSONObject, String str, com.applovin.impl.sdk.j jVar) {
        JSONArray jSONArray = JsonUtils.getJSONArray(jSONObject, "dependencies", new JSONArray());
        JSONArray jSONArray2 = JsonUtils.getJSONArray(jSONObject, "dependencies_v2", new JSONArray());
        ArrayList arrayList = new ArrayList(jSONArray.length() + jSONArray2.length());
        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
            JSONObject jSONObject2 = JsonUtils.getJSONObject(jSONArray, i3, (JSONObject) null);
            if (jSONObject2 != null) {
                arrayList.add(new o6(jSONObject2, jVar));
            }
        }
        for (int i4 = 0; i4 < jSONArray2.length(); i4++) {
            JSONObject jSONObject3 = JsonUtils.getJSONObject(jSONArray2, i4, (JSONObject) null);
            if (jSONObject3 != null && o6.a(str, JsonUtils.getString(jSONObject3, "min_adapter_version", null), JsonUtils.getString(jSONObject3, "max_adapter_version", null))) {
                arrayList.add(new o6(jSONObject3, jVar));
            }
        }
        return arrayList;
    }

    private List a(JSONObject jSONObject, com.applovin.impl.sdk.j jVar) {
        ArrayList arrayList = new ArrayList();
        if (this.f60717q.equals("com.applovin.mediation.adapters.AppLovinMediationAdapter")) {
            gh ghVar = new gh("com.google.android.gms.permission.AD_ID", "Please add\n<uses-permission android:name=\"com.google.android.gms.permission.AD_ID\" />\nto your AndroidManifest.xml", com.applovin.impl.sdk.j.m());
            if (ghVar.c()) {
                arrayList.add(ghVar);
            }
        }
        JSONObject jSONObject2 = JsonUtils.getJSONObject(jSONObject, "permissions", new JSONObject());
        Iterator<String> itKeys = jSONObject2.keys();
        while (itKeys.hasNext()) {
            try {
                String next = itKeys.next();
                arrayList.add(new gh(next, jSONObject2.getString(next), com.applovin.impl.sdk.j.m()));
            } catch (JSONException unused) {
            }
        }
        return arrayList;
    }

    private List a(MaxAdapter maxAdapter, boolean z2) {
        ArrayList arrayList = new ArrayList(5);
        if (maxAdapter instanceof MaxInterstitialAdapter) {
            arrayList.add(MaxAdFormat.INTERSTITIAL);
        }
        if (maxAdapter instanceof MaxAppOpenAdapter) {
            arrayList.add(MaxAdFormat.APP_OPEN);
        }
        if (maxAdapter instanceof MaxRewardedAdapter) {
            arrayList.add(MaxAdFormat.REWARDED);
        }
        if (maxAdapter instanceof MaxRewardedInterstitialAdapter) {
            arrayList.add(MaxAdFormat.REWARDED_INTERSTITIAL);
        }
        if (maxAdapter instanceof MaxAdViewAdapter) {
            arrayList.add(MaxAdFormat.BANNER);
            arrayList.add(MaxAdFormat.LEADER);
            if (z2) {
                arrayList.add(MaxAdFormat.MREC);
            }
        }
        if (maxAdapter instanceof MaxNativeAdAdapter) {
            arrayList.add(MaxAdFormat.NATIVE);
        }
        return arrayList;
    }

    private List a(JSONObject jSONObject) {
        return JsonUtils.optList(JsonUtils.getJSONArray(jSONObject, "supported_regions", null), null);
    }
}
