package com.google.android.gms.ads.internal.util;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.PointF;
import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.WindowManager;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.internal.ads.zzbiq;
import com.google.android.gms.internal.ads.zzcfr;
import com.google.android.gms.internal.ads.zzecn;
import com.google.android.gms.internal.ads.zzecr;
import com.google.android.gms.internal.ads.zzhcg;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzat {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f70235a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzecr f70236b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f70237c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f70238d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f70239e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f70240f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f70241g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f70242h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private PointF f70243i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private PointF f70244j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private Handler f70245k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private Runnable f70246l;

    public zzat(Context context) {
        this.f70241g = 0;
        this.f70246l = new Runnable() { // from class: com.google.android.gms.ads.internal.util.zzas
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.f70234a.g();
            }
        };
        this.f70235a = context;
        this.f70242h = ViewConfiguration.get(context).getScaledTouchSlop();
        com.google.android.gms.ads.internal.zzt.w().a();
        this.f70245k = com.google.android.gms.ads.internal.zzt.w().b();
        this.f70236b = com.google.android.gms.ads.internal.zzt.s().b();
    }

    private final boolean s(float f3, float f4, float f5, float f6) {
        return Math.abs(this.f70243i.x - f3) < ((float) this.f70242h) && Math.abs(this.f70243i.y - f4) < ((float) this.f70242h) && Math.abs(this.f70244j.x - f5) < ((float) this.f70242h) && Math.abs(this.f70244j.y - f6) < ((float) this.f70242h);
    }

    private final void t(Context context) {
        ArrayList arrayList = new ArrayList();
        int iU = u(arrayList, "None", true);
        final int iU2 = u(arrayList, "Shake", true);
        final int iU3 = u(arrayList, "Flick", true);
        int iOrdinal = this.f70236b.zzf().ordinal();
        final int i3 = iOrdinal != 1 ? iOrdinal != 2 ? iU : iU3 : iU2;
        com.google.android.gms.ads.internal.zzt.g();
        AlertDialog.Builder builderN = zzs.n(context);
        final AtomicInteger atomicInteger = new AtomicInteger(i3);
        builderN.setTitle("Setup gesture");
        builderN.setSingleChoiceItems((CharSequence[]) arrayList.toArray(new String[0]), i3, new DialogInterface.OnClickListener() { // from class: com.google.android.gms.ads.internal.util.zzaj
            @Override // android.content.DialogInterface.OnClickListener
            public final /* synthetic */ void onClick(DialogInterface dialogInterface, int i4) {
                atomicInteger.set(i4);
            }
        });
        builderN.setNegativeButton("Dismiss", new DialogInterface.OnClickListener() { // from class: com.google.android.gms.ads.internal.util.zzak
            @Override // android.content.DialogInterface.OnClickListener
            public final /* synthetic */ void onClick(DialogInterface dialogInterface, int i4) {
                this.f70219a.b();
            }
        });
        builderN.setPositiveButton("Save", new DialogInterface.OnClickListener() { // from class: com.google.android.gms.ads.internal.util.zzal
            @Override // android.content.DialogInterface.OnClickListener
            public final /* synthetic */ void onClick(DialogInterface dialogInterface, int i4) {
                this.f70220a.i(atomicInteger, i3, iU2, iU3, dialogInterface, i4);
            }
        });
        builderN.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.google.android.gms.ads.internal.util.zzam
            @Override // android.content.DialogInterface.OnCancelListener
            public final /* synthetic */ void onCancel(DialogInterface dialogInterface) {
                this.f70225a.b();
            }
        });
        builderN.create().show();
    }

    private static final int u(List list, String str, boolean z2) {
        if (!z2) {
            return -1;
        }
        list.add(str);
        return list.size() - 1;
    }

    public final void a(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        int historySize = motionEvent.getHistorySize();
        int pointerCount = motionEvent.getPointerCount();
        if (actionMasked == 0) {
            this.f70241g = 0;
            this.f70243i = new PointF(motionEvent.getX(0), motionEvent.getY(0));
            return;
        }
        int i3 = this.f70241g;
        if (i3 == -1) {
            return;
        }
        if (i3 == 0) {
            if (actionMasked == 5) {
                this.f70241g = 5;
                this.f70244j = new PointF(motionEvent.getX(1), motionEvent.getY(1));
                this.f70245k.postDelayed(this.f70246l, ((Long) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzfR)).longValue());
                return;
            }
            return;
        }
        if (i3 == 5) {
            if (pointerCount == 2) {
                if (actionMasked != 2) {
                    return;
                }
                boolean z2 = false;
                for (int i4 = 0; i4 < historySize; i4++) {
                    z2 |= !s(motionEvent.getHistoricalX(0, i4), motionEvent.getHistoricalY(0, i4), motionEvent.getHistoricalX(1, i4), motionEvent.getHistoricalY(1, i4));
                }
                if (s(motionEvent.getX(), motionEvent.getY(), motionEvent.getX(1), motionEvent.getY(1)) && !z2) {
                    return;
                }
            }
            this.f70241g = -1;
            this.f70245k.removeCallbacks(this.f70246l);
        }
    }

    public final void b() {
        try {
            Context context = this.f70235a;
            if (!(context instanceof Activity)) {
                int i3 = zze.f70328b;
                com.google.android.gms.ads.internal.util.client.zzo.e("Can not create dialog without Activity Context");
                return;
            }
            String str = "Creative preview (enabled)";
            if (true == TextUtils.isEmpty(com.google.android.gms.ads.internal.zzt.s().i())) {
                str = "Creative preview";
            }
            String str2 = true != com.google.android.gms.ads.internal.zzt.s().m() ? "Troubleshooting" : "Troubleshooting (enabled)";
            ArrayList arrayList = new ArrayList();
            final int iU = u(arrayList, "Ad information", true);
            final int iU2 = u(arrayList, str, true);
            final int iU3 = u(arrayList, str2, true);
            boolean zBooleanValue = ((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzkD)).booleanValue();
            final int iU4 = u(arrayList, "Open ad inspector", zBooleanValue);
            final int iU5 = u(arrayList, "Ad inspector settings", zBooleanValue);
            com.google.android.gms.ads.internal.zzt.g();
            AlertDialog.Builder builderN = zzs.n(context);
            builderN.setTitle("Select a debug mode").setItems((CharSequence[]) arrayList.toArray(new String[0]), new DialogInterface.OnClickListener() { // from class: com.google.android.gms.ads.internal.util.zzad
                @Override // android.content.DialogInterface.OnClickListener
                public final /* synthetic */ void onClick(DialogInterface dialogInterface, int i4) {
                    this.f70207a.h(iU, iU2, iU3, iU4, iU5, dialogInterface, i4);
                }
            });
            builderN.create().show();
        } catch (WindowManager.BadTokenException e3) {
            zze.l("", e3);
        }
    }

    public final void c(String str) {
        this.f70238d = str;
    }

    public final void d(String str) {
        this.f70239e = str;
    }

    public final void e(String str) {
        this.f70237c = str;
    }

    public final void f(String str) {
        this.f70240f = str;
    }

    final /* synthetic */ void g() {
        this.f70241g = 4;
        b();
    }

    final /* synthetic */ void h(int i3, int i4, int i5, int i6, int i7, DialogInterface dialogInterface, int i8) {
        if (i8 != i3) {
            if (i8 == i4) {
                int i9 = zze.f70328b;
                com.google.android.gms.ads.internal.util.client.zzo.a("Debug mode [Creative Preview] selected.");
                zzcfr.zza.execute(new Runnable() { // from class: com.google.android.gms.ads.internal.util.zzaf
                    @Override // java.lang.Runnable
                    public final /* synthetic */ void run() {
                        this.f70214a.o();
                    }
                });
                return;
            }
            if (i8 == i5) {
                int i10 = zze.f70328b;
                com.google.android.gms.ads.internal.util.client.zzo.a("Debug mode [Troubleshooting] selected.");
                zzcfr.zza.execute(new Runnable() { // from class: com.google.android.gms.ads.internal.util.zzag
                    @Override // java.lang.Runnable
                    public final /* synthetic */ void run() {
                        this.f70215a.p();
                    }
                });
                return;
            }
            if (i8 == i6) {
                zzecr zzecrVar = this.f70236b;
                final zzhcg zzhcgVar = zzcfr.zzf;
                zzhcg zzhcgVar2 = zzcfr.zza;
                if (zzecrVar.zzs()) {
                    zzhcgVar.execute(new Runnable() { // from class: com.google.android.gms.ads.internal.util.zzaq
                        @Override // java.lang.Runnable
                        public final /* synthetic */ void run() {
                            this.f70231a.l();
                        }
                    });
                    return;
                } else {
                    zzhcgVar2.execute(new Runnable() { // from class: com.google.android.gms.ads.internal.util.zzap
                        @Override // java.lang.Runnable
                        public final /* synthetic */ void run() {
                            this.f70229a.k(zzhcgVar);
                        }
                    });
                    return;
                }
            }
            if (i8 == i7) {
                zzecr zzecrVar2 = this.f70236b;
                final zzhcg zzhcgVar3 = zzcfr.zzf;
                zzhcg zzhcgVar4 = zzcfr.zza;
                if (zzecrVar2.zzs()) {
                    zzhcgVar3.execute(new Runnable() { // from class: com.google.android.gms.ads.internal.util.zzae
                        @Override // java.lang.Runnable
                        public final /* synthetic */ void run() {
                            this.f70213a.n();
                        }
                    });
                    return;
                } else {
                    zzhcgVar4.execute(new Runnable() { // from class: com.google.android.gms.ads.internal.util.zzar
                        @Override // java.lang.Runnable
                        public final /* synthetic */ void run() {
                            this.f70232a.m(zzhcgVar3);
                        }
                    });
                    return;
                }
            }
            return;
        }
        Context context = this.f70235a;
        if (!(context instanceof Activity)) {
            int i11 = zze.f70328b;
            com.google.android.gms.ads.internal.util.client.zzo.e("Can not create dialog without Activity Context");
            return;
        }
        String str = this.f70237c;
        final String str2 = "No debug information";
        if (!TextUtils.isEmpty(str)) {
            Uri uriBuild = new Uri.Builder().encodedQuery(str.replaceAll("\\+", "%20")).build();
            StringBuilder sb = new StringBuilder();
            com.google.android.gms.ads.internal.zzt.g();
            Map mapT = zzs.t(uriBuild);
            for (String str3 : mapT.keySet()) {
                sb.append(str3);
                sb.append(" = ");
                sb.append((String) mapT.get(str3));
                sb.append("\n\n");
            }
            String strTrim = sb.toString().trim();
            if (!TextUtils.isEmpty(strTrim)) {
                str2 = strTrim;
            }
        }
        com.google.android.gms.ads.internal.zzt.g();
        AlertDialog.Builder builderN = zzs.n(context);
        builderN.setMessage(str2);
        builderN.setTitle("Ad Information");
        builderN.setPositiveButton("Share", new DialogInterface.OnClickListener() { // from class: com.google.android.gms.ads.internal.util.zzan
            @Override // android.content.DialogInterface.OnClickListener
            public final /* synthetic */ void onClick(DialogInterface dialogInterface2, int i12) {
                this.f70226a.j(str2, dialogInterface2, i12);
            }
        });
        builderN.setNegativeButton("Close", zzao.f70228a);
        builderN.create().show();
    }

    final /* synthetic */ void i(AtomicInteger atomicInteger, int i3, int i4, int i5, DialogInterface dialogInterface, int i6) {
        if (atomicInteger.get() != i3) {
            if (atomicInteger.get() == i4) {
                this.f70236b.zze(zzecn.SHAKE);
            } else if (atomicInteger.get() == i5) {
                this.f70236b.zze(zzecn.FLICK);
            } else {
                this.f70236b.zze(zzecn.NONE);
            }
        }
        b();
    }

    final /* synthetic */ void j(String str, DialogInterface dialogInterface, int i3) {
        com.google.android.gms.ads.internal.zzt.g();
        zzs.y(this.f70235a, Intent.createChooser(new Intent("android.intent.action.SEND").setType("text/plain").putExtra("android.intent.extra.TEXT", str), "Share via"));
    }

    final /* synthetic */ void k(zzhcg zzhcgVar) {
        zzax zzaxVarS = com.google.android.gms.ads.internal.zzt.s();
        Context context = this.f70235a;
        if (zzaxVarS.e(context, this.f70238d, this.f70239e)) {
            zzhcgVar.execute(new Runnable() { // from class: com.google.android.gms.ads.internal.util.zzai
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.f70217a.r();
                }
            });
        } else {
            com.google.android.gms.ads.internal.zzt.s().f(context, this.f70238d, this.f70239e);
        }
    }

    final /* synthetic */ void l() {
        com.google.android.gms.ads.internal.zzt.s().c(this.f70235a);
    }

    final /* synthetic */ void m(zzhcg zzhcgVar) {
        zzax zzaxVarS = com.google.android.gms.ads.internal.zzt.s();
        Context context = this.f70235a;
        if (zzaxVarS.e(context, this.f70238d, this.f70239e)) {
            zzhcgVar.execute(new Runnable() { // from class: com.google.android.gms.ads.internal.util.zzah
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.f70216a.q();
                }
            });
        } else {
            com.google.android.gms.ads.internal.zzt.s().f(context, this.f70238d, this.f70239e);
        }
    }

    final /* synthetic */ void n() {
        t(this.f70235a);
    }

    final /* synthetic */ void o() {
        zzax zzaxVarS = com.google.android.gms.ads.internal.zzt.s();
        Context context = this.f70235a;
        String str = this.f70238d;
        String str2 = this.f70239e;
        if (!zzaxVarS.d(context, str, str2)) {
            zzaxVarS.n(context, "In-app preview failed to load because of a system error. Please try again later.", true, true);
            return;
        }
        String str3 = zzaxVarS.f70259f;
        if ("2".equals(str3)) {
            int i3 = zze.f70328b;
            com.google.android.gms.ads.internal.util.client.zzo.a("Creative is not pushed for this device.");
            zzaxVarS.n(context, "There was no creative pushed from DFP to the device.", false, false);
        } else if (AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(str3)) {
            int i4 = zze.f70328b;
            com.google.android.gms.ads.internal.util.client.zzo.a("The app is not linked for creative preview.");
            zzaxVarS.f(context, str, str2);
        } else if (AppEventsConstants.EVENT_PARAM_VALUE_NO.equals(str3)) {
            int i5 = zze.f70328b;
            com.google.android.gms.ads.internal.util.client.zzo.a("Device is linked for in app preview.");
            zzaxVarS.n(context, "The device is successfully linked for creative preview.", false, true);
        }
    }

    final /* synthetic */ void p() {
        zzax zzaxVarS = com.google.android.gms.ads.internal.zzt.s();
        String str = this.f70238d;
        String str2 = this.f70239e;
        String str3 = this.f70240f;
        boolean zM = zzaxVarS.m();
        Context context = this.f70235a;
        zzaxVarS.l(zzaxVarS.e(context, str, str2));
        if (!zzaxVarS.m()) {
            zzaxVarS.f(context, str, str2);
            return;
        }
        if (!zM && !TextUtils.isEmpty(str3)) {
            zzaxVarS.h(context, str2, str3, str);
        }
        int i3 = zze.f70328b;
        com.google.android.gms.ads.internal.util.client.zzo.a("Device is linked for debug signals.");
        zzaxVarS.n(context, "The device is successfully linked for troubleshooting.", false, true);
    }

    final /* synthetic */ void q() {
        t(this.f70235a);
    }

    final /* synthetic */ void r() {
        com.google.android.gms.ads.internal.zzt.s().c(this.f70235a);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(100);
        sb.append("{Dialog: ");
        sb.append(this.f70237c);
        sb.append(",DebugSignal: ");
        sb.append(this.f70240f);
        sb.append(",AFMA Version: ");
        sb.append(this.f70239e);
        sb.append(",Ad Unit ID: ");
        sb.append(this.f70238d);
        sb.append("}");
        return sb.toString();
    }

    public zzat(Context context, String str) {
        this(context);
        this.f70237c = str;
    }
}
