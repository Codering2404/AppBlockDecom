package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.browser.customtabs.CustomTabsCallback;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.ads.impl.R;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzekr extends zzbyt {
    final Map zza = new HashMap();
    private final Context zzb;
    private final zzdzl zzc;
    private final com.google.android.gms.ads.internal.util.client.zzu zzd;
    private final zzekg zze;
    private String zzf;
    private String zzg;

    public zzekr(Context context, zzekg zzekgVar, com.google.android.gms.ads.internal.util.client.zzu zzuVar, zzdzl zzdzlVar) {
        this.zzb = context;
        this.zzc = zzdzlVar;
        this.zzd = zzuVar;
        this.zze = zzekgVar;
    }

    public static void zzd(Context context, zzdzl zzdzlVar, zzekg zzekgVar, String str, String str2) {
        zzk(context, zzdzlVar, zzekgVar, str, str2, new HashMap());
    }

    public static void zzk(Context context, zzdzl zzdzlVar, zzekg zzekgVar, String str, String str2, Map map) {
        String strZzg;
        String str3 = true != com.google.android.gms.ads.internal.zzt.l().zzs(context) ? "offline" : CustomTabsCallback.ONLINE_EXTRAS_KEY;
        if (zzdzlVar != null) {
            zzdzk zzdzkVarZza = zzdzlVar.zza();
            zzdzkVarZza.zzc("gqi", str);
            zzdzkVarZza.zzc("action", str2);
            zzdzkVarZza.zzc("device_connectivity", str3);
            zzdzkVarZza.zzc("event_timestamp", String.valueOf(com.google.android.gms.ads.internal.zzt.o().currentTimeMillis()));
            for (Map.Entry entry : map.entrySet()) {
                zzdzkVarZza.zzc((String) entry.getKey(), (String) entry.getValue());
            }
            strZzg = zzdzkVarZza.zzg();
        } else {
            strZzg = "";
        }
        zzekgVar.zze(new zzeki(com.google.android.gms.ads.internal.zzt.o().currentTimeMillis(), str, strZzg, 2));
    }

    public static final PendingIntent zzr(Context context, String str, String str2, String str3) {
        Intent intent = new Intent();
        intent.setAction(str);
        intent.putExtra("offline_notification_action", str);
        intent.putExtra("gws_query_id", str2);
        intent.putExtra(ShareConstants.MEDIA_URI, str3);
        if (Build.VERSION.SDK_INT < 29 || !str.equals("offline_notification_clicked")) {
            intent.setClassName(context, "com.google.android.gms.ads.AdService");
            return zzgqj.zzb(context, 0, intent, 1140850688, 0);
        }
        intent.setClassName(context, "com.google.android.gms.ads.NotificationHandlerActivity");
        return zzgqj.zza(context, 0, intent, 201326592);
    }

    private final void zzs(final Activity activity, final com.google.android.gms.ads.internal.overlay.zzm zzmVar) {
        com.google.android.gms.ads.internal.zzt.g();
        if (NotificationManagerCompat.d(activity).a()) {
            zzt();
            zzu(activity, zzmVar);
        } else {
            if (Build.VERSION.SDK_INT >= 33) {
                activity.requestPermissions(new String[]{"android.permission.POST_NOTIFICATIONS"}, 12345);
                zzw(this.zzf, "asnpdi", zzgwp.zza());
                return;
            }
            com.google.android.gms.ads.internal.zzt.g();
            AlertDialog.Builder builderN = com.google.android.gms.ads.internal.util.zzs.n(activity);
            builderN.setTitle(zzx(R.string.f69751f, "Allow app to send you notifications?")).setPositiveButton(zzx(R.string.f69749d, "Allow"), new DialogInterface.OnClickListener() { // from class: com.google.android.gms.internal.ads.zzekm
                @Override // android.content.DialogInterface.OnClickListener
                public final /* synthetic */ void onClick(DialogInterface dialogInterface, int i3) {
                    this.zza.zzo(activity, zzmVar, dialogInterface, i3);
                }
            }).setNegativeButton(zzx(R.string.f69750e, "Don't allow"), new DialogInterface.OnClickListener() { // from class: com.google.android.gms.internal.ads.zzekn
                @Override // android.content.DialogInterface.OnClickListener
                public final /* synthetic */ void onClick(DialogInterface dialogInterface, int i3) {
                    this.zza.zzp(zzmVar, dialogInterface, i3);
                }
            }).setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.google.android.gms.internal.ads.zzeko
                @Override // android.content.DialogInterface.OnCancelListener
                public final /* synthetic */ void onCancel(DialogInterface dialogInterface) {
                    this.zza.zzq(zzmVar, dialogInterface);
                }
            });
            builderN.create().show();
            zzw(this.zzf, "rtsdi", zzgwp.zza());
        }
    }

    private final void zzt() {
        boolean zZzg;
        boolean zZze;
        try {
            com.google.android.gms.ads.internal.zzt.g();
            Context context = this.zzb;
            com.google.android.gms.ads.internal.util.zzbo zzboVarC = com.google.android.gms.ads.internal.util.zzs.c(context);
            IObjectWrapper iObjectWrapperI5 = ObjectWrapper.i5(context);
            String str = this.zzg;
            String str2 = this.zzf;
            zzejy zzejyVar = (zzejy) this.zza.get(str2);
            zZzg = zzboVarC.zzg(iObjectWrapperI5, new com.google.android.gms.ads.internal.offline.buffering.zza(str, str2, zzejyVar == null ? "" : zzejyVar.zzb()));
            if (zZzg) {
                zZze = true;
            } else {
                try {
                    zZze = zzboVarC.zze(ObjectWrapper.i5(context), this.zzg, this.zzf);
                } catch (RemoteException e3) {
                    e = e3;
                    int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
                    com.google.android.gms.ads.internal.util.client.zzo.d("Failed to schedule offline notification poster.", e);
                    zZze = zZzg;
                }
            }
        } catch (RemoteException e4) {
            e = e4;
            zZzg = false;
        }
        if (zZze) {
            return;
        }
        this.zze.zzd(this.zzf);
        zzw(this.zzf, "offline_notification_worker_not_scheduled", zzgwp.zza());
    }

    private final void zzu(Activity activity, com.google.android.gms.ads.internal.overlay.zzm zzmVar) {
        AlertDialog alertDialogZzv = zzv(activity, zzmVar);
        alertDialogZzv.show();
        Timer timer = new Timer();
        timer.schedule(new zzekj(this, alertDialogZzv, timer, zzmVar), 3000L);
    }

    private final AlertDialog zzv(Activity activity, final com.google.android.gms.ads.internal.overlay.zzm zzmVar) {
        com.google.android.gms.ads.internal.zzt.g();
        AlertDialog.Builder onCancelListener = com.google.android.gms.ads.internal.util.zzs.n(activity).setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.google.android.gms.internal.ads.zzekp
            @Override // android.content.DialogInterface.OnCancelListener
            public final /* synthetic */ void onCancel(DialogInterface dialogInterface) {
                com.google.android.gms.ads.internal.overlay.zzm zzmVar2 = zzmVar;
                if (zzmVar2 != null) {
                    zzmVar2.zzb();
                }
            }
        });
        XmlResourceParser xmlResourceParserZzy = zzy(R.layout.f69745a);
        if (xmlResourceParserZzy == null) {
            onCancelListener.setMessage(zzx(R.string.f69752g, "Thanks for your interest.\nWe will share more once you're back online."));
            return onCancelListener.create();
        }
        try {
            View viewInflate = activity.getLayoutInflater().inflate(xmlResourceParserZzy, (ViewGroup) null);
            onCancelListener.setView(viewInflate);
            String strZzz = zzz();
            if (!TextUtils.isEmpty(strZzz)) {
                TextView textView = (TextView) viewInflate.findViewById(R.id.f69743a);
                textView.setVisibility(0);
                textView.setText(strZzz);
            }
            zzejy zzejyVar = (zzejy) this.zza.get(this.zzf);
            Drawable drawableZzc = zzejyVar != null ? zzejyVar.zzc() : null;
            if (drawableZzc != null) {
                ((ImageView) viewInflate.findViewById(R.id.f69744b)).setImageDrawable(drawableZzc);
            }
            AlertDialog alertDialogCreate = onCancelListener.create();
            alertDialogCreate.getWindow().setBackgroundDrawable(new ColorDrawable(0));
            return alertDialogCreate;
        } catch (Resources.NotFoundException unused) {
            onCancelListener.setMessage(zzx(R.string.f69752g, "Thanks for your interest.\nWe will share more once you're back online."));
            return onCancelListener.create();
        }
    }

    private final void zzw(String str, String str2, Map map) {
        zzk(this.zzb, this.zzc, this.zze, str, str2, map);
    }

    private static String zzx(int i3, String str) {
        Resources resourcesZzf = com.google.android.gms.ads.internal.zzt.l().zzf();
        if (resourcesZzf == null) {
            return str;
        }
        try {
            return resourcesZzf.getString(i3);
        } catch (Resources.NotFoundException unused) {
            return str;
        }
    }

    private static XmlResourceParser zzy(int i3) {
        Resources resourcesZzf = com.google.android.gms.ads.internal.zzt.l().zzf();
        if (resourcesZzf == null) {
            return null;
        }
        try {
            return resourcesZzf.getLayout(i3);
        } catch (Resources.NotFoundException unused) {
            return null;
        }
    }

    private final String zzz() {
        zzejy zzejyVar = (zzejy) this.zza.get(this.zzf);
        return zzejyVar == null ? "" : zzejyVar.zza();
    }

    public final void zzc(String str, zzdpt zzdptVar) {
        String strZzQ = zzdptVar.zzQ();
        String strZzB = zzdptVar.zzB();
        String string = "";
        if (TextUtils.isEmpty(strZzQ)) {
            strZzQ = strZzB != null ? strZzB : "";
        }
        zzbme zzbmeVarZzD = zzdptVar.zzD();
        if (zzbmeVarZzD != null) {
            try {
                string = zzbmeVarZzD.zzc().toString();
            } catch (RemoteException unused) {
            }
        }
        zzbme zzbmeVarZzP = zzdptVar.zzP();
        Drawable drawable = null;
        if (zzbmeVarZzP != null) {
            try {
                IObjectWrapper iObjectWrapperZzb = zzbmeVarZzP.zzb();
                if (iObjectWrapperZzb != null) {
                    drawable = (Drawable) ObjectWrapper.h5(iObjectWrapperZzb);
                }
            } catch (RemoteException unused2) {
            }
        }
        this.zza.put(str, new zzejv(strZzQ, string, drawable));
    }

    @Override // com.google.android.gms.internal.ads.zzbyu
    public final void zze(Intent intent) {
        String stringExtra = intent.getStringExtra("offline_notification_action");
        if (stringExtra != null) {
            if (stringExtra.equals("offline_notification_clicked") || stringExtra.equals("offline_notification_dismissed")) {
                String stringExtra2 = intent.getStringExtra("gws_query_id");
                String stringExtra3 = intent.getStringExtra(ShareConstants.MEDIA_URI);
                Context context = this.zzb;
                boolean zZzs = com.google.android.gms.ads.internal.zzt.l().zzs(context);
                HashMap map = new HashMap();
                if (stringExtra.equals("offline_notification_clicked")) {
                    map.put("offline_notification_action", "offline_notification_clicked");
                    c = true == zZzs ? (char) 1 : (char) 2;
                    map.put("obvs", String.valueOf(Build.VERSION.SDK_INT));
                    map.put("olaih", String.valueOf(stringExtra3.startsWith("http")));
                    try {
                        Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(stringExtra3);
                        if (launchIntentForPackage == null) {
                            launchIntentForPackage = new Intent("android.intent.action.VIEW");
                            launchIntentForPackage.setData(Uri.parse(stringExtra3));
                        }
                        launchIntentForPackage.addFlags(268435456);
                        context.startActivity(launchIntentForPackage);
                        map.put("olaa", "olas");
                    } catch (ActivityNotFoundException unused) {
                        map.put("olaa", "olaf");
                    }
                } else {
                    map.put("offline_notification_action", "offline_notification_dismissed");
                }
                zzw(stringExtra2, "offline_notification_action", map);
                try {
                    SQLiteDatabase writableDatabase = this.zze.getWritableDatabase();
                    if (c == 1) {
                        this.zze.zzb(writableDatabase, this.zzd, stringExtra2);
                    } else {
                        zzekg.zzi(writableDatabase, stringExtra2);
                    }
                } catch (SQLiteException e3) {
                    String strConcat = "Failed to get writable offline buffering database: ".concat(e3.toString());
                    int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
                    com.google.android.gms.ads.internal.util.client.zzo.c(strConcat);
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbyu
    public final void zzf(IObjectWrapper iObjectWrapper, String str, String str2) {
        zzj(iObjectWrapper, new com.google.android.gms.ads.internal.offline.buffering.zza(str, str2, ""));
    }

    @Override // com.google.android.gms.internal.ads.zzbyu
    public final void zzg() {
        final com.google.android.gms.ads.internal.util.client.zzu zzuVar = this.zzd;
        this.zze.zza(new zzfok() { // from class: com.google.android.gms.internal.ads.zzeke
            @Override // com.google.android.gms.internal.ads.zzfok
            public final /* synthetic */ Object zza(Object obj) throws Throwable {
                zzekg.zzf(zzuVar, (SQLiteDatabase) obj);
                return null;
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzbyu
    public final void zzh(IObjectWrapper iObjectWrapper) {
        zzekt zzektVar = (zzekt) ObjectWrapper.h5(iObjectWrapper);
        final Activity activityZza = zzektVar.zza();
        final com.google.android.gms.ads.internal.overlay.zzm zzmVarZzb = zzektVar.zzb();
        this.zzf = zzektVar.zzc();
        this.zzg = zzektVar.zzd();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzjK)).booleanValue()) {
            zzs(activityZza, zzmVarZzb);
            return;
        }
        zzw(this.zzf, "dialog_impression", zzgwp.zza());
        com.google.android.gms.ads.internal.zzt.g();
        AlertDialog.Builder builderN = com.google.android.gms.ads.internal.util.zzs.n(activityZza);
        builderN.setTitle(zzx(R.string.f69758m, "Open ad when you're back online.")).setMessage(zzx(R.string.f69757l, "We'll send you a notification with a link to the advertiser site.")).setPositiveButton(zzx(R.string.f69755j, "OK"), new DialogInterface.OnClickListener() { // from class: com.google.android.gms.internal.ads.zzekq
            @Override // android.content.DialogInterface.OnClickListener
            public final /* synthetic */ void onClick(DialogInterface dialogInterface, int i3) {
                this.zza.zzl(activityZza, zzmVarZzb, dialogInterface, i3);
            }
        }).setNegativeButton(zzx(R.string.f69756k, "No thanks"), new DialogInterface.OnClickListener() { // from class: com.google.android.gms.internal.ads.zzekk
            @Override // android.content.DialogInterface.OnClickListener
            public final /* synthetic */ void onClick(DialogInterface dialogInterface, int i3) {
                this.zza.zzm(zzmVarZzb, dialogInterface, i3);
            }
        }).setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.google.android.gms.internal.ads.zzekl
            @Override // android.content.DialogInterface.OnCancelListener
            public final /* synthetic */ void onCancel(DialogInterface dialogInterface) {
                this.zza.zzn(zzmVarZzb, dialogInterface);
            }
        });
        builderN.create().show();
    }

    @Override // com.google.android.gms.internal.ads.zzbyu
    public final void zzi(String[] strArr, int[] iArr, IObjectWrapper iObjectWrapper) {
        for (int i3 = 0; i3 < strArr.length; i3++) {
            if (strArr[i3].equals("android.permission.POST_NOTIFICATIONS")) {
                zzekt zzektVar = (zzekt) ObjectWrapper.h5(iObjectWrapper);
                Activity activityZza = zzektVar.zza();
                com.google.android.gms.ads.internal.overlay.zzm zzmVarZzb = zzektVar.zzb();
                HashMap map = new HashMap();
                if (iArr[i3] == 0) {
                    map.put("dialog_action", "confirm");
                    zzt();
                    zzu(activityZza, zzmVarZzb);
                } else {
                    map.put("dialog_action", "dismiss");
                    if (zzmVarZzb != null) {
                        zzmVarZzb.zzb();
                    }
                }
                zzw(this.zzf, "asnpdc", map);
                return;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbyu
    public final void zzj(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.offline.buffering.zza zzaVar) {
        Bitmap bitmapDecodeStream;
        String str;
        Context context = (Context) ObjectWrapper.h5(iObjectWrapper);
        String str2 = zzaVar.f70037a;
        String str3 = zzaVar.f70038b;
        String str4 = zzaVar.f70039c;
        String strZzz = zzz();
        com.google.android.gms.ads.internal.zzt.j().f(context, "offline_notification_channel", "AdMob Offline Notifications");
        PendingIntent pendingIntentZzr = zzr(context, "offline_notification_clicked", str3, str2);
        PendingIntent pendingIntentZzr2 = zzr(context, "offline_notification_dismissed", str3, str2);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, "offline_notification_channel");
        if (TextUtils.isEmpty(strZzz)) {
            builder.n(zzx(R.string.f69753h, "You are back online! Let's pick up where we left off"));
        } else {
            builder.n(String.format(zzx(R.string.f69754i, "You are back online! Continue learning about %s"), strZzz));
        }
        builder.f(true).p(pendingIntentZzr2).l(pendingIntentZzr).B(context.getApplicationInfo().icon).x(((Integer) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzjL)).intValue());
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzjN)).booleanValue() || str4.isEmpty()) {
            bitmapDecodeStream = null;
        } else {
            try {
                bitmapDecodeStream = BitmapFactory.decodeStream(new URL(str4).openConnection().getInputStream());
            } catch (IOException unused) {
                bitmapDecodeStream = null;
            }
        }
        if (bitmapDecodeStream != null) {
            try {
                builder.r(bitmapDecodeStream).D(new NotificationCompat.BigPictureStyle().i(bitmapDecodeStream).h(null));
            } catch (Resources.NotFoundException unused2) {
            }
        }
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        HashMap map = new HashMap();
        try {
            notificationManager.notify(str3, 54321, builder.c());
            str = "offline_notification_impression";
        } catch (IllegalArgumentException e3) {
            map.put("notification_not_shown_reason", e3.getMessage());
            str = "offline_notification_failed";
        }
        zzw(str3, str, map);
    }

    final /* synthetic */ void zzl(Activity activity, com.google.android.gms.ads.internal.overlay.zzm zzmVar, DialogInterface dialogInterface, int i3) {
        HashMap map = new HashMap();
        map.put("dialog_action", "confirm");
        zzw(this.zzf, "dialog_click", map);
        zzs(activity, zzmVar);
    }

    final /* synthetic */ void zzm(com.google.android.gms.ads.internal.overlay.zzm zzmVar, DialogInterface dialogInterface, int i3) {
        this.zze.zzd(this.zzf);
        HashMap map = new HashMap();
        map.put("dialog_action", "dismiss");
        zzw(this.zzf, "dialog_click", map);
        if (zzmVar != null) {
            zzmVar.zzb();
        }
    }

    final /* synthetic */ void zzn(com.google.android.gms.ads.internal.overlay.zzm zzmVar, DialogInterface dialogInterface) {
        this.zze.zzd(this.zzf);
        HashMap map = new HashMap();
        map.put("dialog_action", "dismiss");
        zzw(this.zzf, "dialog_click", map);
        if (zzmVar != null) {
            zzmVar.zzb();
        }
    }

    final /* synthetic */ void zzo(Activity activity, com.google.android.gms.ads.internal.overlay.zzm zzmVar, DialogInterface dialogInterface, int i3) {
        HashMap map = new HashMap();
        map.put("dialog_action", "confirm");
        zzw(this.zzf, "rtsdc", map);
        activity.startActivity(com.google.android.gms.ads.internal.zzt.j().h(activity));
        zzt();
        if (zzmVar != null) {
            zzmVar.zzb();
        }
    }

    final /* synthetic */ void zzp(com.google.android.gms.ads.internal.overlay.zzm zzmVar, DialogInterface dialogInterface, int i3) {
        this.zze.zzd(this.zzf);
        HashMap map = new HashMap();
        map.put("dialog_action", "dismiss");
        zzw(this.zzf, "rtsdc", map);
        if (zzmVar != null) {
            zzmVar.zzb();
        }
    }

    final /* synthetic */ void zzq(com.google.android.gms.ads.internal.overlay.zzm zzmVar, DialogInterface dialogInterface) {
        this.zze.zzd(this.zzf);
        HashMap map = new HashMap();
        map.put("dialog_action", "dismiss");
        zzw(this.zzf, "rtsdc", map);
        if (zzmVar != null) {
            zzmVar.zzb();
        }
    }
}
