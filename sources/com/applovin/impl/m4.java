package com.applovin.impl;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.DialogInterface;
import android.net.Uri;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;
import com.applovin.impl.h4;
import com.applovin.impl.i4;
import com.applovin.impl.k4;
import com.applovin.impl.privacy.cmp.CmpServiceImpl;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.sdk.AppLovinCmpError;
import com.applovin.sdk.AppLovinSdkConfiguration;
import com.applovin.sdk.AppLovinSdkUtils;
import com.applovin.sdk.AppLovinWebViewActivity;
import com.applovin.sdk.R;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class m4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.applovin.impl.sdk.j f61336a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f61337b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private List f61338c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f61339d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private i4 f61340e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private h4.b f61341f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private h4.a f61342g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private i4 f61343h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Dialog f61344i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final p f61345j = new a();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class a extends p {
        a() {
        }

        @Override // com.applovin.impl.p, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            super.onActivityResumed(activity);
            if ((activity instanceof AppLovinWebViewActivity) || m4.this.f61343h == null) {
                return;
            }
            if (m4.this.f61344i != null) {
                m4 m4Var = m4.this;
                if (!r.a(m4Var.a(m4Var.f61344i))) {
                    m4.this.f61344i.dismiss();
                }
                m4.this.f61344i = null;
            }
            i4 i4Var = m4.this.f61343h;
            m4.this.f61343h = null;
            m4 m4Var2 = m4.this;
            m4Var2.a(m4Var2.f61340e, i4Var, activity);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class b implements DialogInterface.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ k4 f61347a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ i4 f61348b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Activity f61349c;

        b(k4 k4Var, i4 i4Var, Activity activity) {
            this.f61347a = k4Var;
            this.f61348b = i4Var;
            this.f61349c = activity;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            m4.this.f61343h = null;
            m4.this.f61344i = null;
            i4 i4VarA = m4.this.a(this.f61347a.a());
            if (i4VarA == null) {
                m4.this.b("Destination state for TOS/PP alert is null");
                return;
            }
            m4.this.a(this.f61348b, i4VarA, this.f61349c);
            if (i4VarA.c() != i4.b.ALERT) {
                dialogInterface.dismiss();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class c extends ClickableSpan {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Uri f61351a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Activity f61352b;

        c(Uri uri, Activity activity) {
            this.f61351a = uri;
            this.f61352b = activity;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            yp.a(this.f61351a, this.f61352b, m4.this.f61336a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class d extends ClickableSpan {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Uri f61354a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Activity f61355b;

        d(Uri uri, Activity activity) {
            this.f61354a = uri;
            this.f61355b = activity;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            yp.a(this.f61354a, this.f61355b, m4.this.f61336a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class e implements CmpServiceImpl.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ i4 f61357a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Activity f61358b;

        e(i4 i4Var, Activity activity) {
            this.f61357a = i4Var;
            this.f61358b = activity;
        }

        @Override // com.applovin.impl.privacy.cmp.CmpServiceImpl.d
        public void a(AppLovinCmpError appLovinCmpError) {
            m4.this.a(this.f61357a, this.f61358b, Boolean.valueOf(appLovinCmpError == null));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class f implements CmpServiceImpl.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ i4 f61360a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Activity f61361b;

        f(i4 i4Var, Activity activity) {
            this.f61360a = i4Var;
            this.f61361b = activity;
        }

        @Override // com.applovin.impl.privacy.cmp.CmpServiceImpl.e
        public void a(AppLovinCmpError appLovinCmpError) {
            if (appLovinCmpError == null && m4.this.f61342g != null) {
                m4.this.f61342g.a(true);
            }
            m4.this.b(this.f61360a, this.f61361b);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class g implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ i4 f61363a;

        g(i4 i4Var) {
            this.f61363a = i4Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            m4 m4Var = m4.this;
            m4Var.a(m4Var.f61340e, this.f61363a, m4.this.f61336a.m0());
        }
    }

    public m4(com.applovin.impl.sdk.j jVar) {
        this.f61336a = jVar;
        this.f61337b = ((Integer) jVar.a(sj.q6)).intValue();
    }

    public void c() {
        h4.a aVar;
        this.f61338c = null;
        this.f61340e = null;
        this.f61336a.e().b(this.f61345j);
        h4.b bVar = this.f61341f;
        if (bVar != null && (aVar = this.f61342g) != null) {
            bVar.a(aVar);
        }
        this.f61341f = null;
        this.f61342g = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        p6.a(str, new Object[0]);
        this.f61336a.D().a(ka.S, str, (Map) CollectionUtils.hashMap("details", "Last started states: " + this.f61339d + "\nLast successful state: " + this.f61340e));
        h4.a aVar = this.f61342g;
        if (aVar != null) {
            aVar.a(new f4(f4.f59631f, str));
        }
        c();
    }

    private i4 a() {
        List<i4> list = this.f61338c;
        if (list == null) {
            return null;
        }
        for (i4 i4Var : list) {
            if (i4Var.d()) {
                return i4Var;
            }
        }
        return null;
    }

    private void c(final i4 i4Var, final Activity activity) {
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.nz
            @Override // java.lang.Runnable
            public final void run() {
                this.f62147a.a(i4Var, activity);
            }
        });
    }

    public boolean b() {
        return this.f61338c != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Activity a(Dialog dialog) {
        Context context = dialog.getContext();
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (!(context instanceof ContextWrapper)) {
            return null;
        }
        Context baseContext = ((ContextWrapper) context).getBaseContext();
        if (baseContext instanceof Activity) {
            return (Activity) baseContext;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(i4 i4Var, Activity activity) {
        a(i4Var, activity, (Boolean) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public i4 a(String str) {
        List<i4> list = this.f61338c;
        if (list == null) {
            return null;
        }
        for (i4 i4Var : list) {
            if (str.equalsIgnoreCase(i4Var.b())) {
                return i4Var;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(AlertDialog alertDialog, Activity activity, DialogInterface dialogInterface) {
        TextView textView = (TextView) alertDialog.findViewById(alertDialog.getContext().getResources().getIdentifier("android:id/alertTitle", null, null));
        textView.setLinkTextColor(textView.getCurrentTextColor());
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setMaxLines(this.f61337b);
        textView.setMinHeight(AppLovinSdkUtils.dpToPx(activity, 48));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(i4 i4Var, final Activity activity) {
        SpannableString spannableString;
        if (i4Var == null) {
            b("Consent flow state is null");
            return;
        }
        this.f61336a.I();
        if (com.applovin.impl.sdk.n.a()) {
            this.f61336a.I().a("AppLovinSdk", "Transitioning to state: " + i4Var);
        }
        if (i4Var.c() == i4.b.ALERT) {
            if (r.a(activity)) {
                a(i4Var);
                return;
            }
            j4 j4Var = (j4) i4Var;
            this.f61343h = j4Var;
            AlertDialog.Builder builder = new AlertDialog.Builder(activity);
            builder.setCancelable(false);
            for (k4 k4Var : j4Var.e()) {
                b bVar = new b(k4Var, i4Var, activity);
                if (k4Var.c() == k4.a.POSITIVE) {
                    builder.setPositiveButton(k4Var.d(), bVar);
                } else if (k4Var.c() == k4.a.NEGATIVE) {
                    builder.setNegativeButton(k4Var.d(), bVar);
                } else {
                    builder.setNeutralButton(k4Var.d(), bVar);
                }
            }
            String strG = j4Var.g();
            if (StringUtils.isValidString(strG)) {
                spannableString = new SpannableString(strG);
                String strA = com.applovin.impl.sdk.j.a(R.string.applovin_terms_of_service_text);
                String strA2 = com.applovin.impl.sdk.j.a(R.string.applovin_privacy_policy_text);
                if (StringUtils.containsAtLeastOneSubstring(strG, Arrays.asList(strA, strA2))) {
                    Uri uriH = this.f61336a.u().h();
                    if (uriH != null) {
                        StringUtils.addLinks(spannableString, Pattern.compile(strA), new c(uriH, activity), true);
                    }
                    StringUtils.addLinks(spannableString, Pattern.compile(strA2), new d(this.f61336a.u().g(), activity), true);
                }
            } else {
                spannableString = null;
            }
            final AlertDialog alertDialogCreate = builder.setTitle(spannableString).setMessage(j4Var.f()).create();
            alertDialogCreate.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.applovin.impl.mz
                @Override // android.content.DialogInterface.OnShowListener
                public final void onShow(DialogInterface dialogInterface) {
                    this.f61943a.a(alertDialogCreate, activity, dialogInterface);
                }
            });
            this.f61344i = alertDialogCreate;
            alertDialogCreate.show();
            return;
        }
        if (i4Var.c() == i4.b.EVENT) {
            l4 l4Var = (l4) i4Var;
            String strF = l4Var.f();
            Map<String, String> mapE = l4Var.e();
            if (mapE == null) {
                mapE = new HashMap<>(1);
            }
            mapE.put("flow_type", "unified");
            this.f61336a.z().trackEvent(strF, mapE);
            b(l4Var, activity);
            return;
        }
        if (i4Var.c() == i4.b.HAS_USER_CONSENT) {
            a(true);
            b(i4Var, activity);
            return;
        }
        if (i4Var.c() == i4.b.CMP_LOAD) {
            if (r.a(activity)) {
                a(i4Var);
                return;
            } else {
                this.f61336a.p().loadCmp(activity, new e(i4Var, activity));
                return;
            }
        }
        if (i4Var.c() == i4.b.CMP_SHOW) {
            if (r.a(activity)) {
                a(i4Var);
                return;
            } else {
                this.f61336a.z().trackEvent("cf_start");
                this.f61336a.p().showCmp(activity, new f(i4Var, activity));
                return;
            }
        }
        if (i4Var.c() == i4.b.DECISION) {
            i4.a aVarA = i4Var.a();
            if (aVarA != i4.a.IS_AL_GDPR) {
                b("Invalid consent flow decision type: " + aVarA);
                return;
            }
            AppLovinSdkConfiguration.ConsentFlowUserGeography consentFlowUserGeographyE = this.f61336a.u().e();
            AppLovinSdkConfiguration.ConsentFlowUserGeography consentFlowUserGeography = AppLovinSdkConfiguration.ConsentFlowUserGeography.GDPR;
            a(i4Var, activity, Boolean.valueOf(this.f61336a.s().getConsentFlowUserGeography() == consentFlowUserGeography || (consentFlowUserGeographyE == consentFlowUserGeography && yp.c(this.f61336a))));
            return;
        }
        if (i4Var.c() == i4.b.TERMS_FLOW) {
            List listA = g4.a(this.f61336a);
            if (listA != null && listA.size() > 0) {
                this.f61336a.z().trackEvent("cf_start");
                this.f61338c = listA;
                a(i4Var, a(), activity);
                return;
            }
            c();
            return;
        }
        if (i4Var.c() == i4.b.REINIT) {
            c();
            return;
        }
        b("Invalid consent flow destination state: " + i4Var);
    }

    public void a(boolean z2) {
        a4.b(z2, com.applovin.impl.sdk.j.m());
    }

    public void a(List list, Activity activity, h4.b bVar) {
        if (this.f61338c != null) {
            this.f61336a.I();
            if (com.applovin.impl.sdk.n.a()) {
                this.f61336a.I().a("AppLovinSdk", "Unable to start states: " + list);
            }
            this.f61336a.I();
            if (com.applovin.impl.sdk.n.a()) {
                this.f61336a.I().a("AppLovinSdk", "Consent flow already in progress for states: " + this.f61338c);
            }
            bVar.a(new h4.a(new f4(f4.f59630e, "Consent flow is already in progress.")));
            return;
        }
        this.f61338c = list;
        this.f61339d = String.valueOf(list);
        this.f61341f = bVar;
        this.f61342g = new h4.a();
        com.applovin.impl.sdk.j.a(activity).a(this.f61345j);
        a((i4) null, a(), activity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(i4 i4Var, Activity activity, Boolean bool) {
        a(i4Var, a(i4Var.a(bool)), activity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(i4 i4Var, i4 i4Var2, Activity activity) {
        this.f61340e = i4Var;
        c(i4Var2, activity);
    }

    private void a(i4 i4Var) {
        AppLovinSdkUtils.runOnUiThreadDelayed(new g(i4Var), TimeUnit.SECONDS.toMillis(1L));
    }
}
