package com.google.android.gms.common;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.util.Log;
import android.util.TypedValue;
import android.widget.ProgressBar;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.FragmentActivity;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.google.android.gms.common.api.internal.LifecycleFragment;
import com.google.android.gms.common.api.internal.zabw;
import com.google.android.gms.common.api.internal.zabx;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.zag;
import com.google.android.gms.common.util.DeviceProperties;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.wrappers.InstantApps;
import com.google.android.gms.internal.base.zae;
import com.google.android.gms.internal.base.zao;
import com.google.android.gms.internal.base.zap;
import com.google.errorprone.annotations.RestrictedInheritance;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
@RestrictedInheritance(allowedOnPath = ".*java.*/com/google/android/gms.*", allowlistAnnotations = {com.google.android.gms.internal.base.zad.class, zae.class}, explanation = "Sub classing of GMS Core's APIs are restricted to GMS Core client libs and testing fakes.", link = "go/gmscore-restrictedinheritance")
public class GoogleApiAvailability extends GoogleApiAvailabilityLight {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f71452c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Object f71450e = new Object();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final GoogleApiAvailability f71451f = new GoogleApiAvailability();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f71449d = GoogleApiAvailabilityLight.f71453a;

    public static GoogleApiAvailability q() {
        return f71451f;
    }

    public final boolean A(Context context, ConnectionResult connectionResult, int i3) {
        PendingIntent pendingIntentP;
        if (InstantApps.a(context) || (pendingIntentP = p(context, connectionResult)) == null) {
            return false;
        }
        x(context, connectionResult.N(), null, PendingIntent.getActivity(context, 0, GoogleApiActivity.a(context, pendingIntentP, i3, true), zap.zaa | 134217728));
        return true;
    }

    @Override // com.google.android.gms.common.GoogleApiAvailabilityLight
    public Intent d(Context context, int i3, String str) {
        return super.d(context, i3, str);
    }

    @Override // com.google.android.gms.common.GoogleApiAvailabilityLight
    public PendingIntent e(Context context, int i3, int i4) {
        return super.e(context, i3, i4);
    }

    @Override // com.google.android.gms.common.GoogleApiAvailabilityLight
    public final String g(int i3) {
        return super.g(i3);
    }

    @Override // com.google.android.gms.common.GoogleApiAvailabilityLight
    public int i(Context context) {
        return super.i(context);
    }

    @Override // com.google.android.gms.common.GoogleApiAvailabilityLight
    public int j(Context context, int i3) {
        return super.j(context, i3);
    }

    @Override // com.google.android.gms.common.GoogleApiAvailabilityLight
    public final boolean m(int i3) {
        return super.m(i3);
    }

    public Dialog o(Activity activity, int i3, int i4, DialogInterface.OnCancelListener onCancelListener) {
        return t(activity, i3, zag.b(activity, d(activity, i3, "d"), i4), onCancelListener, null);
    }

    public PendingIntent p(Context context, ConnectionResult connectionResult) {
        return connectionResult.j0() ? connectionResult.g0() : e(context, connectionResult.N(), 0);
    }

    public boolean r(Activity activity, int i3, int i4, DialogInterface.OnCancelListener onCancelListener) {
        Dialog dialogO = o(activity, i3, i4, onCancelListener);
        if (dialogO == null) {
            return false;
        }
        w(activity, dialogO, "GooglePlayServicesErrorDialog", onCancelListener);
        return true;
    }

    public void s(Context context, int i3) {
        x(context, i3, null, f(context, i3, 0, "n"));
    }

    final Dialog t(Context context, int i3, zag zagVar, DialogInterface.OnCancelListener onCancelListener, DialogInterface.OnClickListener onClickListener) {
        if (i3 == 0) {
            return null;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(android.R.attr.alertDialogTheme, typedValue, true);
        AlertDialog.Builder builder = "Theme.Dialog.Alert".equals(context.getResources().getResourceEntryName(typedValue.resourceId)) ? new AlertDialog.Builder(context, 5) : null;
        if (builder == null) {
            builder = new AlertDialog.Builder(context);
        }
        builder.setMessage(com.google.android.gms.common.internal.zac.c(context, i3));
        if (onCancelListener != null) {
            builder.setOnCancelListener(onCancelListener);
        }
        String strB = com.google.android.gms.common.internal.zac.b(context, i3);
        DialogInterface.OnClickListener onClickListener2 = zagVar;
        if (strB != null) {
            if (zagVar == null) {
                onClickListener2 = onClickListener;
            }
            builder.setPositiveButton(strB, onClickListener2);
        }
        String strF = com.google.android.gms.common.internal.zac.f(context, i3);
        if (strF != null) {
            builder.setTitle(strF);
        }
        Log.w("GoogleApiAvailability", String.format("Creating dialog for Google Play services availability issue. ConnectionResult=%s", Integer.valueOf(i3)), new IllegalArgumentException());
        return builder.create();
    }

    public final Dialog u(Activity activity, DialogInterface.OnCancelListener onCancelListener) {
        ProgressBar progressBar = new ProgressBar(activity, null, android.R.attr.progressBarStyleLarge);
        progressBar.setIndeterminate(true);
        progressBar.setVisibility(0);
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setView(progressBar);
        builder.setMessage(com.google.android.gms.common.internal.zac.c(activity, 18));
        builder.setPositiveButton("", (DialogInterface.OnClickListener) null);
        AlertDialog alertDialogCreate = builder.create();
        w(activity, alertDialogCreate, "GooglePlayServicesUpdatingDialog", onCancelListener);
        return alertDialogCreate;
    }

    public final zabx v(Context context, zabw zabwVar) {
        IntentFilter intentFilter = new IntentFilter("android.intent.action.PACKAGE_ADDED");
        intentFilter.addDataScheme("package");
        zabx zabxVar = new zabx(zabwVar);
        zao.zaa(context, zabxVar, intentFilter);
        zabxVar.a(context);
        if (l(context, "com.google.android.gms")) {
            return zabxVar;
        }
        zabwVar.a();
        zabxVar.b();
        return null;
    }

    final void w(Activity activity, Dialog dialog, String str, DialogInterface.OnCancelListener onCancelListener) {
        try {
            if (activity instanceof FragmentActivity) {
                SupportErrorDialogFragment.y(dialog, onCancelListener).show(((FragmentActivity) activity).getSupportFragmentManager(), str);
                return;
            }
        } catch (NoClassDefFoundError unused) {
        }
        ErrorDialogFragment.a(dialog, onCancelListener).show(activity.getFragmentManager(), str);
    }

    final void x(Context context, int i3, String str, PendingIntent pendingIntent) {
        int i4;
        String str2;
        Log.w("GoogleApiAvailability", String.format("GMS core API Availability. ConnectionResult=%s, tag=%s", Integer.valueOf(i3), null), new IllegalArgumentException());
        if (i3 == 18) {
            y(context);
            return;
        }
        if (pendingIntent == null) {
            if (i3 == 6) {
                Log.w("GoogleApiAvailability", "Missing resolution for ConnectionResult.RESOLUTION_REQUIRED. Call GoogleApiAvailability#showErrorNotification(Context, ConnectionResult) instead.");
                return;
            }
            return;
        }
        String strE = com.google.android.gms.common.internal.zac.e(context, i3);
        String strD = com.google.android.gms.common.internal.zac.d(context, i3);
        Resources resources = context.getResources();
        NotificationManager notificationManager = (NotificationManager) Preconditions.m(context.getSystemService("notification"));
        NotificationCompat.Builder builderD = new NotificationCompat.Builder(context).t(true).f(true).n(strE).D(new NotificationCompat.BigTextStyle().h(strD));
        if (DeviceProperties.f(context)) {
            Preconditions.q(PlatformVersion.b());
            builderD.B(context.getApplicationInfo().icon).x(2);
            if (DeviceProperties.g(context)) {
                builderD.a(com.google.android.gms.base.R.drawable.f71341a, resources.getString(com.google.android.gms.base.R.string.f71360o), pendingIntent);
            } else {
                builderD.l(pendingIntent);
            }
        } else {
            builderD.B(android.R.drawable.stat_sys_warning).F(resources.getString(com.google.android.gms.base.R.string.f71353h)).I(System.currentTimeMillis()).l(pendingIntent).m(strD);
        }
        if (PlatformVersion.e()) {
            Preconditions.q(PlatformVersion.e());
            synchronized (f71450e) {
                str2 = this.f71452c;
            }
            if (str2 == null) {
                str2 = "com.google.android.gms.availability";
                NotificationChannel notificationChannel = notificationManager.getNotificationChannel("com.google.android.gms.availability");
                String string = context.getResources().getString(com.google.android.gms.base.R.string.f71352g);
                if (notificationChannel == null) {
                    notificationManager.createNotificationChannel(new NotificationChannel("com.google.android.gms.availability", string, 4));
                } else if (!string.contentEquals(notificationChannel.getName())) {
                    notificationChannel.setName(string);
                    notificationManager.createNotificationChannel(notificationChannel);
                }
            }
            builderD.j(str2);
        }
        Notification notificationC = builderD.c();
        if (i3 == 1 || i3 == 2 || i3 == 3) {
            GooglePlayServicesUtilLight.f71460b.set(false);
            i4 = 10436;
        } else {
            i4 = 39789;
        }
        notificationManager.notify(i4, notificationC);
    }

    final void y(Context context) {
        new zad(this, context).sendEmptyMessageDelayed(1, 120000L);
    }

    public final boolean z(Activity activity, LifecycleFragment lifecycleFragment, int i3, int i4, DialogInterface.OnCancelListener onCancelListener) {
        Dialog dialogT = t(activity, i3, zag.c(lifecycleFragment, d(activity, i3, "d"), 2), onCancelListener, null);
        if (dialogT == null) {
            return false;
        }
        w(activity, dialogT, "GooglePlayServicesErrorDialog", onCancelListener);
        return true;
    }
}
