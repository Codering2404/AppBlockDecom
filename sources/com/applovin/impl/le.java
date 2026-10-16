package com.applovin.impl;

import android.content.Context;
import android.text.SpannableString;
import android.text.SpannedString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import com.applovin.impl.cc;
import com.applovin.impl.je;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.mediation.adapter.MaxAdapter;
import com.applovin.sdk.R;
import com.google.firebase.crashlytics.internal.breadcrumbs.PKU.tDEtWsFLJfe;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class le extends dc {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final je f61194f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private List f61195g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final List f61196h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final List f61197i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final List f61198j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final List f61199k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private SpannedString f61200l;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public enum a {
        INTEGRATIONS,
        f61202b,
        CONFIGURATION,
        DEPENDENCIES,
        TEST_ADS,
        COUNT
    }

    le(je jeVar, Context context) {
        super(context);
        this.f61194f = jeVar;
        if (jeVar.q() == je.a.INVALID_INTEGRATION) {
            SpannableString spannableString = new SpannableString("Tap for more information");
            spannableString.setSpan(new AbsoluteSizeSpan(12, true), 0, spannableString.length(), 33);
            this.f61200l = new SpannedString(spannableString);
        } else {
            this.f61200l = new SpannedString("");
        }
        this.f61195g = g();
        this.f61196h = b(jeVar.n());
        this.f61197i = e();
        this.f61198j = a(jeVar.f());
        this.f61199k = j();
        notifyDataSetChanged();
    }

    private cc a(String str, String str2, boolean z2, boolean z3) {
        return cc.a(z2 ? cc.c.RIGHT_DETAIL : cc.c.DETAIL).d(str).a(z2 ? null : this.f61200l).b("Instructions").a(str2).a(z2 ? R.drawable.applovin_ic_check_mark_bordered : c(z3)).b(z2 ? t3.a(R.color.applovin_sdk_checkmarkColor, this.f59200a) : d(z3)).a(!z2).a();
    }

    private int b(boolean z2) {
        return t3.a(z2 ? R.color.applovin_sdk_checkmarkColor : R.color.applovin_sdk_xmarkColor, this.f59200a);
    }

    private int c(boolean z2) {
        return z2 ? R.drawable.applovin_ic_x_mark : R.drawable.applovin_ic_warning;
    }

    private cc d() {
        cc.b bVarC = cc.a().d("Adapter").c(this.f61194f.c());
        if (TextUtils.isEmpty(this.f61194f.c())) {
            bVarC.a(a(this.f61194f.A())).b(b(this.f61194f.A()));
        }
        return bVarC.a();
    }

    private List e() {
        ArrayList arrayList = new ArrayList(1);
        if (this.f61194f.D()) {
            arrayList.add(a("Java 8", "For optimal performance, please enable Java 8 support. See: https://developers.applovin.com/en/android/overview/integration", com.applovin.impl.sdk.j.w0(), true));
        }
        return arrayList;
    }

    private cc f() {
        if (this.f61194f.G()) {
            return null;
        }
        return cc.a().d("Initialization Status").c(f(this.f61194f.i())).a(false).a();
    }

    private List g() {
        ArrayList arrayList = new ArrayList(3);
        CollectionUtils.addObjectIfExists(i(), arrayList);
        CollectionUtils.addObjectIfExists(d(), arrayList);
        CollectionUtils.addObjectIfExists(f(), arrayList);
        return arrayList;
    }

    private cc i() {
        cc.b bVarC = cc.a().d("SDK").c(this.f61194f.p());
        if (TextUtils.isEmpty(this.f61194f.p())) {
            bVarC.a(a(this.f61194f.E())).b(b(this.f61194f.E()));
        }
        return bVarC.a();
    }

    private List j() {
        ArrayList arrayList = new ArrayList(3);
        if (StringUtils.isValidString(this.f61194f.v())) {
            arrayList.add(cc.a(cc.c.DETAIL).d(this.f61194f.v()).a());
        }
        if (this.f61194f.y() == je.b.NOT_SUPPORTED) {
            return arrayList;
        }
        if (this.f61194f.s() != null) {
            arrayList.add(c(this.f61194f.s()));
        }
        arrayList.add(a(this.f61194f.y()));
        return arrayList;
    }

    public je h() {
        return this.f61194f;
    }

    public void k() {
        this.f61195g = g();
    }

    public String toString() {
        return "MediatedNetworkListAdapter{}";
    }

    private List b(List list) {
        ArrayList arrayList = new ArrayList(list.size());
        if (list.size() > 0) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                gh ghVar = (gh) it.next();
                arrayList.add(a(ghVar.b(), ghVar.a(), ghVar.c(), true));
            }
        }
        return arrayList;
    }

    @Override // com.applovin.impl.dc
    protected List c(int i3) {
        return i3 == a.INTEGRATIONS.ordinal() ? this.f61195g : i3 == a.f61202b.ordinal() ? this.f61196h : i3 == a.CONFIGURATION.ordinal() ? this.f61197i : i3 == a.DEPENDENCIES.ordinal() ? this.f61198j : this.f61199k;
    }

    @Override // com.applovin.impl.dc
    protected cc e(int i3) {
        if (i3 == a.INTEGRATIONS.ordinal()) {
            return new fj("INTEGRATIONS");
        }
        if (i3 == a.f61202b.ordinal()) {
            return new fj("PERMISSIONS");
        }
        if (i3 == a.CONFIGURATION.ordinal()) {
            return new fj("CONFIGURATION");
        }
        if (i3 == a.DEPENDENCIES.ordinal()) {
            return new fj(tDEtWsFLJfe.asWBPrWqtOQ);
        }
        return new fj("TEST ADS");
    }

    private String f(int i3) {
        if (MaxAdapter.InitializationStatus.INITIALIZED_SUCCESS.getCode() != i3 && MaxAdapter.InitializationStatus.INITIALIZED_UNKNOWN.getCode() != i3 && MaxAdapter.InitializationStatus.DOES_NOT_APPLY.getCode() != i3) {
            if (MaxAdapter.InitializationStatus.INITIALIZED_FAILURE.getCode() == i3) {
                return "Failure";
            }
            if (MaxAdapter.InitializationStatus.INITIALIZING.getCode() == i3) {
                return "Initializing...";
            }
            return "Not Initialized";
        }
        return "Initialized";
    }

    private int d(boolean z2) {
        return t3.a(z2 ? R.color.applovin_sdk_xmarkColor : R.color.applovin_sdk_warningColor, this.f59200a);
    }

    @Override // com.applovin.impl.dc
    protected int b() {
        return a.COUNT.ordinal();
    }

    @Override // com.applovin.impl.dc
    protected int d(int i3) {
        if (i3 == a.INTEGRATIONS.ordinal()) {
            return this.f61195g.size();
        }
        if (i3 == a.f61202b.ordinal()) {
            return this.f61196h.size();
        }
        if (i3 == a.CONFIGURATION.ordinal()) {
            return this.f61197i.size();
        }
        if (i3 == a.DEPENDENCIES.ordinal()) {
            return this.f61198j.size();
        }
        return this.f61199k.size();
    }

    private List a(List list) {
        ArrayList arrayList = new ArrayList(list.size());
        if (list.size() > 0) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                o6 o6Var = (o6) it.next();
                arrayList.add(a(o6Var.b(), o6Var.a(), o6Var.c(), true));
            }
        }
        return arrayList;
    }

    private cc c(List list) {
        return cc.a().d("Region/VPN Required").c(CollectionUtils.implode(list, ", ", list.size())).a();
    }

    private int a(boolean z2) {
        return z2 ? R.drawable.applovin_ic_check_mark_bordered : R.drawable.applovin_ic_x_mark;
    }

    private cc a(je.b bVar) {
        cc.b bVarA = cc.a();
        if (bVar == je.b.READY) {
            bVarA.a(this.f59200a);
        }
        return bVarA.d("Test Mode").c(bVar.c()).c(bVar.d()).b("Restart Required").a(bVar.b()).a(true).a();
    }

    public boolean a(kb kbVar) {
        return kbVar.b() == a.TEST_ADS.ordinal() && kbVar.a() == this.f61199k.size() - 1;
    }
}
