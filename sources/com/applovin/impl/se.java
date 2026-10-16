package com.applovin.impl;

import android.content.Context;
import android.text.TextUtils;
import com.applovin.communicator.AppLovinCommunicator;
import com.applovin.communicator.AppLovinCommunicatorMessage;
import com.applovin.communicator.AppLovinCommunicatorSubscriber;
import com.applovin.impl.cc;
import com.applovin.impl.je;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.y0;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkConfiguration;
import com.applovin.sdk.AppLovinSdkUtils;
import com.applovin.sdk.R;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.share.HKJ.pnxuebdT;
import com.google.firebase.crashlytics.internal.breadcrumbs.PKU.tDEtWsFLJfe;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class se extends dc implements AppLovinCommunicatorSubscriber, y0.a {
    private List A;
    private List B;
    private List C;
    private List D;
    private List E;
    private List F;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private com.applovin.impl.sdk.j f63648f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private List f63649g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private List f63650h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private List f63651i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private String f63652j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private String f63653k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private String f63654l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private Boolean f63655m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f63656n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final StringBuilder f63657o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final AtomicBoolean f63658p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f63659q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private List f63660r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private List f63661s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private List f63662t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private List f63663u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private List f63664v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private List f63665w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private List f63666x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private List f63667y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private List f63668z;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f63669a;

        static {
            int[] iArr = new int[y0.b.values().length];
            f63669a = iArr;
            try {
                iArr[y0.b.APP_DETAILS_NOT_FOUND.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f63669a[y0.b.INVALID_DEVELOPER_URI.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f63669a[y0.b.APPADSTXT_NOT_FOUND.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f63669a[y0.b.MISSING_APPLOVIN_ENTRIES.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f63669a[y0.b.MISSING_NON_APPLOVIN_ENTRIES.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public enum b {
        AD_UNITS,
        SELECT_LIVE_NETWORKS,
        SELECT_TEST_MODE_NETWORKS,
        INITIALIZATION_AD_UNITS,
        COUNT
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private enum c {
        SUCCESS,
        WARNING,
        ERROR
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public enum d {
        CMP,
        NETWORK_CONSENT_STATUSES,
        DO_NOT_SELL,
        COUNT
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public enum e {
        APP_INFO,
        MAX,
        PRIVACY,
        ADS,
        INCOMPLETE_NETWORKS,
        MICRO_SDK_PARTNER_NETWORKS,
        COMPLETED_NETWORKS,
        MISSING_NETWORKS,
        COUNT
    }

    public se(Context context) {
        super(context);
        this.f63657o = new StringBuilder("");
        this.f63658p = new AtomicBoolean();
        this.f63659q = false;
        this.f63660r = new ArrayList();
        this.f63661s = new ArrayList();
        this.f63662t = new ArrayList();
        this.f63663u = new ArrayList();
        this.f63664v = new ArrayList();
        this.f63665w = new ArrayList();
        this.f63666x = new ArrayList();
        this.f63667y = new ArrayList();
        this.f63668z = new ArrayList();
        this.A = new ArrayList();
        this.B = new ArrayList();
        this.C = new ArrayList();
        this.D = new ArrayList();
        this.E = new ArrayList();
        this.F = new ArrayList();
    }

    private void a(StringBuilder sb, String str) {
        String string = sb.toString();
        if (string.length() + str.length() >= ((Integer) this.f63648f.a(sj.f63791t)).intValue()) {
            com.applovin.impl.sdk.n.g("MediationDebuggerListAdapter", string);
            this.f63657o.append(string);
            sb.setLength(1);
        }
        sb.append(str);
    }

    private cc b(String str, String str2) {
        cc.b bVarD = cc.a().d(str);
        if (StringUtils.isValidString(str2)) {
            bVarD.c(str2);
        } else {
            bVarD.a(R.drawable.applovin_ic_x_mark);
            bVarD.b(t3.a(R.color.applovin_sdk_xmarkColor, this.f59200a));
        }
        return bVarD.a();
    }

    private List f() {
        boolean zC = this.f63648f.k0().c();
        List listB = this.f63648f.k0().b();
        return zC ? a((String) null, a(listB, false)) : a(a(listB, true), (String) null);
    }

    private List i() {
        String str;
        ArrayList arrayList = new ArrayList(7);
        try {
            str = this.f59200a.getPackageManager().getPackageInfo(this.f59200a.getPackageName(), 0).versionName;
        } catch (Throwable unused) {
            str = null;
        }
        arrayList.add(cc.a().d("Package Name").c(this.f59200a.getPackageName()).a());
        cc.b bVarD = cc.a().d("App Version");
        if (!StringUtils.isValidString(str)) {
            str = "None";
        }
        arrayList.add(bVarD.c(str).a());
        arrayList.add(cc.a().d("OS").c(yp.d()).a());
        arrayList.add(cc.a().d("Account").c(StringUtils.isValidString(this.f63654l) ? this.f63654l : "None").a());
        arrayList.add(cc.a().d("Mediation Provider").c(StringUtils.isValidString(this.f63648f.N()) ? this.f63648f.N() : "None").a());
        arrayList.add(cc.a().d("OM SDK Version").c(this.f63648f.V().c()).a());
        arrayList.add(a(com.applovin.impl.sdk.j.w0()));
        if (this.f63655m != null) {
            arrayList.add(cc.a().d("Google Families Policy").c(String.valueOf(this.f63655m)).a());
        }
        return arrayList;
    }

    private cc k() {
        String strD = this.f63648f.j0().d();
        boolean zIsValidString = StringUtils.isValidString(strD);
        boolean zIsValidString2 = StringUtils.isValidString(this.f63648f.j0().k());
        cc.b bVarD = cc.a(cc.c.DETAIL).d("CMP (Consent Management Platform)");
        if (!zIsValidString) {
            strD = zIsValidString2 ? AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN : "None";
        }
        cc.b bVarC = bVarD.c(strD);
        if (this.f63656n) {
            bVarC.a(true);
            if (zIsValidString2) {
                bVarC.a(this.f59200a);
            } else {
                bVarC.b("TC Data Not Found");
                bVarC.a("By January 16, 2024, if you use Google AdMob or Google Ad Manager, you must also use a Google-certified CMP. Test your app in EEA and UK regions to ensure that this warning doesn't appear in those regions.\n\nFor more details, see:\nhttps://support.google.com/admob/answer/13554116");
                boolean z2 = this.f63648f.s().getConsentFlowUserGeography() == AppLovinSdkConfiguration.ConsentFlowUserGeography.GDPR;
                bVarC.a(z2 ? R.drawable.applovin_ic_x_mark : R.drawable.applovin_ic_warning);
                bVarC.b(t3.a(z2 ? R.color.applovin_sdk_xmarkColor : R.color.applovin_sdk_warningColor, this.f59200a));
            }
        }
        return bVarC.a();
    }

    private cc l() {
        return cc.a().d("MAX Terms and Privacy Policy Flow").a(this.f59200a).a(true).a();
    }

    private cc m() {
        boolean zHasSupportedCmp = this.f63648f.p().hasSupportedCmp();
        return cc.a().d("Google UMP SDK").a(zHasSupportedCmp ? R.drawable.applovin_ic_check_mark_bordered : R.drawable.applovin_ic_x_mark).b(t3.a(zHasSupportedCmp ? R.color.applovin_sdk_checkmarkColor : R.color.applovin_sdk_xmarkColor, this.f59200a)).b("Google UMP SDK").a("In order to use MAX Terms and Privacy Policy Flow, you must add the Google User Messaging Platform SDK as a dependency.\n\nFor more details, see:\nhttps://developers.applovin.com/en/android/overview/terms-and-privacy-policy-flow").a(!zHasSupportedCmp).a();
    }

    private List p() {
        ArrayList arrayList = new ArrayList(7);
        arrayList.add(cc.a().d("SDK Version").c(AppLovinSdk.VERSION).a());
        String str = (String) this.f63648f.a(sj.K3);
        cc.b bVarD = cc.a().d("Plugin Version");
        if (!StringUtils.isValidString(str)) {
            str = "None";
        }
        arrayList.add(bVarD.c(str).a());
        cc.b bVarD2 = cc.a().d("Ad Review Version");
        String strB = v.b();
        if (StringUtils.isValidString(strB)) {
            String strA = v.a();
            if (!StringUtils.isValidString(strA) || strA.equals(this.f63648f.a0())) {
                bVarD2.c(strB);
            } else {
                StringBuilder sb = new StringBuilder("MAX Ad Review integrated with wrong SDK key. Please check that your ");
                sb.append(this.f63648f.z0() ? "SDK key is downloaded" : "Gradle plugin snippet is integrated");
                sb.append(" from the correct account.");
                a(bVarD2, sb.toString());
            }
        } else {
            a(bVarD2, "Integrating MAX Ad review is OPTIONAL. This feature gives developers unprecedented transparency into the creatives the users see in their apps.");
        }
        arrayList.add(bVarD2.a());
        if (this.f63648f.z0()) {
            String strA2 = yp.a(this.f63648f.f0());
            arrayList.add(b("Unity Version", StringUtils.isValidString(strA2) ? strA2 : "None"));
        }
        if (this.f63648f.u().j()) {
            arrayList.add(l());
            arrayList.add(m());
        }
        return arrayList;
    }

    private cc q() {
        return cc.a().d("Network Consent Statuses").a(this.f59200a).a(true).a();
    }

    private List r() {
        ArrayList arrayList = new ArrayList(d.COUNT.ordinal());
        arrayList.add(k());
        if (StringUtils.isValidString(this.f63648f.j0().k())) {
            arrayList.add(q());
        } else {
            arrayList.add(new xh(a4.b(), false, this.f59200a));
        }
        arrayList.add(new xh(a4.a(), true, this.f59200a));
        return arrayList;
    }

    @Override // com.applovin.impl.dc
    protected List c(int i3) {
        return i3 == e.APP_INFO.ordinal() ? this.f63667y : i3 == e.MAX.ordinal() ? this.f63668z : i3 == e.PRIVACY.ordinal() ? this.A : i3 == e.ADS.ordinal() ? this.B : i3 == e.INCOMPLETE_NETWORKS.ordinal() ? this.C : i3 == e.MICRO_SDK_PARTNER_NETWORKS.ordinal() ? this.D : i3 == e.COMPLETED_NETWORKS.ordinal() ? this.E : this.F;
    }

    public boolean d() {
        return this.f63659q;
    }

    public List e() {
        return this.f63649g;
    }

    public String g() {
        return this.f63653k;
    }

    @Override // com.applovin.communicator.AppLovinCommunicatorEntity
    public String getCommunicatorId() {
        return "MediationDebuggerListAdapter";
    }

    public String h() {
        return this.f63652j;
    }

    public List j() {
        return this.f63664v;
    }

    public List n() {
        return this.f63650h;
    }

    public String o() {
        return this.f63657o.toString();
    }

    @Override // com.applovin.communicator.AppLovinCommunicatorSubscriber
    public void onMessageReceived(AppLovinCommunicatorMessage appLovinCommunicatorMessage) {
        if ("privacy_setting_updated".equals(appLovinCommunicatorMessage.getTopic())) {
            this.A = r();
            c();
            return;
        }
        if ("network_sdk_version_updated".equals(appLovinCommunicatorMessage.getTopic())) {
            this.C = a(this.f63660r);
            this.D = a(this.f63661s);
            this.E = a(this.f63662t);
            c();
            return;
        }
        if ("live_networks_updated".equals(appLovinCommunicatorMessage.getTopic())) {
            this.B = a(a((List) appLovinCommunicatorMessage.getMessageData().getStringArrayList("live_networks"), true), (String) null);
            c();
        } else if ("test_mode_networks_updated".equals(appLovinCommunicatorMessage.getTopic())) {
            this.B = a((String) null, a((List) appLovinCommunicatorMessage.getMessageData().getStringArrayList("test_mode_networks"), false));
            c();
        }
    }

    public com.applovin.impl.sdk.j s() {
        return this.f63648f;
    }

    public List t() {
        return this.f63666x;
    }

    public String toString() {
        return "MediationDebuggerListAdapter{isInitialized=" + this.f63658p.get() + "}";
    }

    public List u() {
        return this.f63665w;
    }

    public boolean v() {
        return this.f63658p.get();
    }

    private void w() {
        StringBuilder sb = new StringBuilder("\n========== MEDIATION DEBUGGER ==========");
        sb.append("\n========== APP INFO ==========");
        sb.append("\nDev Build - " + yp.c(this.f63648f));
        StringBuilder sb2 = new StringBuilder();
        sb2.append("\nTest Mode - ");
        sb2.append(this.f63648f.k0().c() ? "enabled" : "disabled");
        sb.append(sb2.toString());
        sb.append("\nTarget SDK - " + this.f63648f.x().B().get("target_sdk"));
        sb.append("\n========== MAX ==========");
        String str = AppLovinSdk.VERSION;
        String str2 = (String) this.f63648f.a(sj.K3);
        String strB = v.b();
        sb.append("\nSDK Version - " + str);
        StringBuilder sb3 = new StringBuilder();
        sb3.append(pnxuebdT.RLGfpZEW);
        if (!StringUtils.isValidString(str2)) {
            str2 = "None";
        }
        sb3.append(str2);
        sb.append(sb3.toString());
        StringBuilder sb4 = new StringBuilder();
        sb4.append("\nAd Review Version - ");
        if (!StringUtils.isValidString(strB)) {
            strB = "Disabled";
        }
        sb4.append(strB);
        sb.append(sb4.toString());
        if (this.f63648f.z0()) {
            String strA = yp.a(this.f63648f.f0());
            StringBuilder sb5 = new StringBuilder();
            sb5.append("\nUnity Version - ");
            sb5.append(StringUtils.isValidString(strA) ? strA : "None");
            sb.append(sb5.toString());
        }
        sb.append("\n========== PRIVACY ==========");
        sb.append(a4.a(this.f59200a));
        sb.append(this.f63648f.u().f());
        sb.append("\n========== CMP (CONSENT MANAGEMENT PLATFORM) ==========");
        sb.append(this.f63648f.j0().j());
        sb.append("\n========== NETWORK CONSENT STATUSES ==========");
        Iterator it = this.f63648f.j0().i().iterator();
        while (it.hasNext()) {
            sb.append(((rn) it.next()).e());
        }
        sb.append("\n========== NETWORKS ==========");
        Iterator it2 = this.f63661s.iterator();
        while (it2.hasNext()) {
            a(sb, ((je) it2.next()).j());
        }
        Iterator it3 = this.f63662t.iterator();
        while (it3.hasNext()) {
            a(sb, ((je) it3.next()).j());
        }
        Iterator it4 = this.f63660r.iterator();
        while (it4.hasNext()) {
            a(sb, ((je) it4.next()).j());
        }
        sb.append("\n========== AD UNITS ==========");
        Iterator it5 = this.f63649g.iterator();
        while (it5.hasNext()) {
            a(sb, ((z) it5.next()).e());
        }
        sb.append("\n========== END ==========");
        com.applovin.impl.sdk.n.g("MediationDebuggerListAdapter", sb.toString());
        this.f63657o.append(sb.toString());
    }

    @Override // com.applovin.impl.dc
    protected int d(int i3) {
        return i3 == e.APP_INFO.ordinal() ? this.f63667y.size() : i3 == e.MAX.ordinal() ? this.f63668z.size() : i3 == e.PRIVACY.ordinal() ? this.A.size() : i3 == e.ADS.ordinal() ? this.B.size() : i3 == e.INCOMPLETE_NETWORKS.ordinal() ? this.C.size() : i3 == e.MICRO_SDK_PARTNER_NETWORKS.ordinal() ? this.D.size() : i3 == e.COMPLETED_NETWORKS.ordinal() ? this.E.size() : this.F.size();
    }

    @Override // com.applovin.impl.dc
    protected cc e(int i3) {
        return i3 == e.APP_INFO.ordinal() ? new fj("APP INFO") : i3 == e.MAX.ordinal() ? new fj("MAX") : i3 == e.PRIVACY.ordinal() ? new fj("PRIVACY") : i3 == e.ADS.ordinal() ? new fj("ADS") : i3 == e.INCOMPLETE_NETWORKS.ordinal() ? new fj("INCOMPLETE SDK INTEGRATIONS") : i3 == e.MICRO_SDK_PARTNER_NETWORKS.ordinal() ? new fj("APPLOVIN MICRO SDK PARTNERS") : i3 == e.COMPLETED_NETWORKS.ordinal() ? new fj("COMPLETED SDK INTEGRATIONS") : new fj("MISSING SDK INTEGRATIONS");
    }

    private List a(String str, String str2) {
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(cc.a().d("View Ad Units (" + this.f63649g.size() + ")").a(this.f59200a).a(true).a());
        arrayList.add(a(str));
        arrayList.add(b(str2));
        if (!this.f63650h.isEmpty()) {
            arrayList.add(cc.a().d("Selective Init Ad Units (" + this.f63650h.size() + ")").a(this.f59200a).a(true).a());
        }
        arrayList.add(cc.a().d("Test Mode Enabled").c(String.valueOf(this.f63648f.k0().c())).a());
        return arrayList;
    }

    private cc b(String str) {
        cc.b bVarA = cc.a();
        if (this.f63648f.k0().c()) {
            bVarA.a(this.f59200a);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(StringUtils.isValidString(str) ? "" : "Select ");
        sb.append("Test Mode Network");
        cc.b bVarD = bVarA.d(sb.toString());
        if (!this.f63648f.k0().c()) {
            str = "Enable";
        }
        return bVarD.c(str).c(-16776961).a("Please re-launch the app to enable test mode. This will allow the selection of test mode networks.").a(true).a();
    }

    private void c(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            je jeVar = (je) it.next();
            if (!jeVar.F()) {
                if (jeVar.q() != je.a.INCOMPLETE_INTEGRATION && jeVar.q() != je.a.INVALID_INTEGRATION) {
                    if (jeVar.q() == je.a.COMPLETE) {
                        if (jeVar.z()) {
                            this.f63661s.add(jeVar);
                        } else {
                            this.f63662t.add(jeVar);
                        }
                    } else if (jeVar.q() == je.a.MISSING) {
                        this.f63663u.add(jeVar);
                    }
                } else if (jeVar.z()) {
                    this.f63661s.add(jeVar);
                } else {
                    this.f63660r.add(jeVar);
                }
            }
        }
    }

    private void b(List list) {
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            a0 a0VarF = ((z) it.next()).f();
            Iterator it2 = a0VarF.a().iterator();
            while (it2.hasNext()) {
                hashSet.add(((ir) it2.next()).b());
            }
            Iterator it3 = a0VarF.e().iterator();
            while (it3.hasNext()) {
                hashSet2.add(((ir) it3.next()).b());
            }
        }
        this.f63664v = new ArrayList(hashSet);
        this.f63665w = new ArrayList(hashSet2);
        Collections.sort(this.f63664v);
        Collections.sort(this.f63665w);
    }

    private void d(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            je jeVar = (je) it.next();
            if (jeVar.y() == je.b.READY) {
                this.f63666x.add(jeVar);
            }
        }
    }

    private String a(y0.b bVar, String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            str = "app-ads.txt URL";
        }
        int i3 = a.f63669a[bVar.ordinal()];
        if (i3 == 1) {
            return "Could not retrieve app details from the Play Store for this package name. Check back once this app has been published on the Play Store.";
        }
        if (i3 == 2) {
            return "Unable to find a valid developer URL from the Play Store listing.";
        }
        if (i3 == 3) {
            return "Unable to find app-ads.txt file or parse entries of the file at " + str + ".\n\nFor more information, please visit Account -> App-Ads.txt Info at:\nhttps://dash.applovin.com/o/account?r=2#app_ads_txt";
        }
        if (i3 != 4) {
            if (i3 != 5) {
                return "";
            }
            return "Text file at " + str + " is missing some of the suggested lines.\n\nFor more information, please visit Account -> App-Ads.txt Info at:\nhttps://dash.applovin.com/o/account?r=2#app_ads_txt";
        }
        return "Text file at " + str + " is missing the required AppLovin line:\n\n" + str2 + "\n\nFor more information, please visit Account -> App-Ads.txt Info at:\nhttps://dash.applovin.com/o/account?r=2#app_ads_txt";
    }

    public void b(boolean z2) {
        this.f63659q = z2;
    }

    @Override // com.applovin.impl.dc
    protected int b() {
        return e.COUNT.ordinal();
    }

    private cc a(String str, c cVar) {
        int i3;
        int iA;
        if (cVar == c.SUCCESS) {
            i3 = R.drawable.applovin_ic_check_mark_bordered;
            iA = t3.a(R.color.applovin_sdk_checkmarkColor, this.f59200a);
        } else if (cVar == c.WARNING) {
            i3 = R.drawable.applovin_ic_warning;
            iA = t3.a(R.color.applovin_sdk_warningColor, this.f59200a);
        } else {
            i3 = R.drawable.applovin_ic_x_mark;
            iA = t3.a(R.color.applovin_sdk_xmarkColor, this.f59200a);
        }
        return cc.a().d("app-ads.txt").a(i3).b(iA).b("app-ads.txt").a(str).a(true).a();
    }

    private cc a(boolean z2) {
        return cc.a().d("Java 8").a(z2 ? R.drawable.applovin_ic_check_mark_bordered : R.drawable.applovin_ic_x_mark).b(t3.a(z2 ? R.color.applovin_sdk_checkmarkColor : R.color.applovin_sdk_xmarkColor, this.f59200a)).b("Upgrade to Java 8").a("For optimal performance, please enable Java 8 support. This will be required in a future SDK release. See: https://developers.applovin.com/en/android/overview/integration").a(!z2).a();
    }

    private String a(List list, boolean z2) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        if (z2) {
            for (ic icVar : this.f63664v) {
                if (list.equals(icVar.b())) {
                    return icVar.a();
                }
            }
            for (ic icVar2 : this.f63665w) {
                if (list.equals(icVar2.b())) {
                    return icVar2.a();
                }
            }
        } else {
            for (je jeVar : this.f63666x) {
                if (list.equals(jeVar.u())) {
                    return jeVar.g();
                }
            }
        }
        return String.join(",", list);
    }

    private List a(List list) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new bg((je) it.next(), this.f59200a));
        }
        return arrayList;
    }

    private cc a(String str) {
        cc.b bVarA = cc.a();
        if (!this.f63648f.k0().c()) {
            bVarA.a(this.f59200a);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(StringUtils.isValidString(str) ? "" : "Select ");
        sb.append("Live Network");
        cc.b bVarD = bVarA.d(sb.toString());
        if (this.f63648f.k0().c()) {
            str = tDEtWsFLJfe.MvNRr;
        }
        return bVarD.c(str).c(-16776961).a("Ad loads are not supported while Test Mode is enabled. Please restart the app and make sure your GAID has not been enabled for test mode and that you are not on an emulator.").a(true).a();
    }

    public void a(List list, List list2, List list3, List list4, String str, String str2, String str3, Boolean bool, boolean z2, com.applovin.impl.sdk.j jVar) {
        this.f63648f = jVar;
        this.f63649g = list2;
        this.f63650h = list3;
        this.f63651i = list4;
        this.f63652j = str;
        this.f63653k = str2;
        this.f63654l = str3;
        this.f63655m = bool;
        this.f63656n = z2;
        if (list != null && this.f63658p.compareAndSet(false, true)) {
            jVar.I();
            if (com.applovin.impl.sdk.n.a()) {
                jVar.I().a("MediationDebuggerListAdapter", "Populating networks...");
            }
            jVar.j0().a(list);
            c(list);
            b(list2);
            d(this.f63662t);
            this.f63667y.addAll(i());
            this.f63668z.addAll(p());
            this.A.addAll(r());
            this.B.addAll(f());
            this.C = a(this.f63660r);
            this.D = a(this.f63661s);
            this.E = a(this.f63662t);
            this.F = a(this.f63663u);
            ArrayList arrayList = new ArrayList(3);
            arrayList.add("privacy_setting_updated");
            arrayList.add("network_sdk_version_updated");
            arrayList.add("live_networks_updated");
            arrayList.add("test_mode_networks_updated");
            AppLovinCommunicator.getInstance(this.f59200a).subscribe(this, arrayList);
            w();
        }
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.b50
            @Override // java.lang.Runnable
            public final void run() {
                this.f58555a.notifyDataSetChanged();
            }
        });
    }

    public boolean a(cc ccVar) {
        if (ccVar.k() == null) {
            return false;
        }
        return "MAX Terms and Privacy Policy Flow".equals(ccVar.k().toString());
    }

    @Override // com.applovin.impl.y0.a
    public void a(y0.b bVar, String str) {
        if (bVar == y0.b.APP_DETAILS_NOT_FOUND) {
            this.f63648f.I();
            if (com.applovin.impl.sdk.n.a()) {
                this.f63648f.I().a("MediationDebuggerListAdapter", "Could not retrieve app details for this package name; app-ads.txt row will not show on the mediation debugger.");
                return;
            }
            return;
        }
        this.f63668z.add(a(a(bVar, str, null), a(bVar)));
        c();
    }

    @Override // com.applovin.impl.y0.a
    public void a(w0 w0Var, String str) {
        x0 x0Var;
        String strA;
        c cVarA;
        c cVar;
        String str2;
        ArrayList arrayList = new ArrayList();
        for (x0 x0Var2 : this.f63651i) {
            List list = (List) w0Var.a().get(x0Var2.b());
            if (list == null || !list.contains(x0Var2)) {
                this.f63648f.I();
                if (com.applovin.impl.sdk.n.a()) {
                    this.f63648f.I().b("MediationDebuggerListAdapter", str + " is missing a required entry: " + x0Var2.d());
                }
                arrayList.add(x0Var2);
            }
        }
        if (arrayList.isEmpty()) {
            str2 = "All required entries found at " + str + ".";
            cVar = c.SUCCESS;
        } else {
            int size = arrayList.size();
            int i3 = 0;
            while (true) {
                if (i3 >= size) {
                    x0Var = null;
                    break;
                }
                Object obj = arrayList.get(i3);
                i3++;
                x0Var = (x0) obj;
                if (x0Var.g()) {
                    break;
                }
            }
            if (x0Var != null) {
                y0.b bVar = y0.b.MISSING_APPLOVIN_ENTRIES;
                strA = a(bVar, str, x0Var.d());
                cVarA = a(bVar);
            } else {
                y0.b bVar2 = y0.b.MISSING_NON_APPLOVIN_ENTRIES;
                strA = a(bVar2, str, null);
                cVarA = a(bVar2);
            }
            String str3 = strA;
            cVar = cVarA;
            str2 = str3;
        }
        this.f63668z.add(a(str2, cVar));
        c();
    }

    private void a(cc.b bVar, String str) {
        bVar.b("MAX Ad Review").a(str).a(R.drawable.applovin_ic_x_mark).b(t3.a(R.color.applovin_sdk_xmarkColor, this.f59200a)).a(true);
    }

    private c a(y0.b bVar) {
        int i3 = a.f63669a[bVar.ordinal()];
        if (i3 == 1 || i3 == 2 || i3 == 3 || i3 == 4) {
            return c.ERROR;
        }
        if (i3 != 5) {
            return c.ERROR;
        }
        return c.WARNING;
    }
}
