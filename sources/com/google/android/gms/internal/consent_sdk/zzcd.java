package com.google.android.gms.internal.consent_sdk;

import android.app.Application;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.facebook.internal.NativeProtocol;
import java.io.ByteArrayOutputStream;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.Executor;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzcd implements zzd {
    private final Application zza;
    private final zzbz zzb;
    private final Handler zzc;
    private final Executor zzd;
    private final zze zze;
    private final zzao zzf;
    private final zzbe zzg;
    private final zzaq zzh;

    zzcd(Application application, zzbz zzbzVar, Handler handler, Executor executor, zze zzeVar, zzao zzaoVar, zzbe zzbeVar, zzaq zzaqVar) {
        this.zza = application;
        this.zzb = zzbzVar;
        this.zzc = handler;
        this.zzd = executor;
        this.zze = zzeVar;
        this.zzf = zzaoVar;
        this.zzg = zzbeVar;
        this.zzh = zzaqVar;
    }

    public static /* synthetic */ void zzc(zzcd zzcdVar) {
        JSONObject jSONObject = new JSONObject();
        Application application = zzcdVar.zza;
        try {
            jSONObject.put(NativeProtocol.BRIDGE_ARG_APP_NAME_STRING, application.getPackageManager().getApplicationLabel(application.getApplicationInfo()).toString());
            Drawable applicationIcon = application.getPackageManager().getApplicationIcon(application.getApplicationInfo());
            String strConcat = null;
            if (applicationIcon != null && applicationIcon.getIntrinsicWidth() > 0 && applicationIcon.getIntrinsicHeight() > 0) {
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(applicationIcon.getIntrinsicWidth(), applicationIcon.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(bitmapCreateBitmap);
                applicationIcon.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
                applicationIcon.draw(canvas);
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                bitmapCreateBitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                strConcat = "data:image/png;base64,".concat(String.valueOf(Base64.encodeToString(byteArrayOutputStream.toByteArray(), 2)));
            }
            jSONObject.put("app_icon", strConcat);
            JSONObject jSONObject2 = new JSONObject();
            zzaq zzaqVar = zzcdVar.zzh;
            for (String str : zzaqVar.zzc().keySet()) {
                jSONObject2.put(str, zzaqVar.zzc().get(str));
            }
            jSONObject.put("stored_infos_map", jSONObject2);
        } catch (JSONException unused) {
        }
        zzcdVar.zzg.zzc().zzd("UMP_configureFormWithAppAssets", jSONObject.toString());
    }

    private final void zzg(JSONObject jSONObject) {
        String strOptString = jSONObject.optString("url");
        if (TextUtils.isEmpty(strOptString)) {
            Log.d("UserMessagingPlatform", "Action[browser]: empty url.");
        }
        Uri uri = Uri.parse(strOptString);
        if (uri.getScheme() == null) {
            Log.d("UserMessagingPlatform", "Action[browser]: empty scheme: ".concat(String.valueOf(strOptString)));
        }
        try {
            this.zzb.startActivity(new Intent("android.intent.action.VIEW", uri));
        } catch (ActivityNotFoundException e3) {
            Log.d("UserMessagingPlatform", "Action[browser]: can not open url: ".concat(String.valueOf(strOptString)), e3);
        }
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzd
    public final Executor zza() {
        final Handler handler = this.zzc;
        Objects.requireNonNull(handler);
        return new Executor() { // from class: com.google.android.gms.internal.consent_sdk.zzcb
            @Override // java.util.concurrent.Executor
            public final void execute(Runnable runnable) {
                handler.post(runnable);
            }
        };
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0030, code lost:
    
        if (r3.equals("non_personalized") != false) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0039, code lost:
    
        if (r3.equals("CONSENT_SIGNAL_PERSONALIZED_ADS") != false) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0042, code lost:
    
        if (r3.equals("CONSENT_SIGNAL_SUFFICIENT") != false) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x004b, code lost:
    
        if (r3.equals("personalized") != false) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0054, code lost:
    
        if (r3.equals("CONSENT_SIGNAL_NON_PERSONALIZED_ADS") != false) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0056, code lost:
    
        r3 = 3;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.google.android.gms.internal.consent_sdk.zzd
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean zzb(java.lang.String r3, org.json.JSONObject r4) {
        /*
            r2 = this;
            int r0 = r3.hashCode()
            r1 = 1
            switch(r0) {
                case -1370505102: goto L82;
                case -278739366: goto L76;
                case 150940456: goto L6a;
                case 1671672458: goto La;
                default: goto L8;
            }
        L8:
            goto L90
        La:
            java.lang.String r0 = "dismiss"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L90
            java.lang.String r3 = "status"
            java.lang.String r3 = r4.optString(r3)
            int r4 = r3.hashCode()
            switch(r4) {
                case -954325659: goto L4e;
                case -258041904: goto L45;
                case 429411856: goto L3c;
                case 467888915: goto L33;
                case 1666911234: goto L2a;
                case 1725474845: goto L20;
                default: goto L1f;
            }
        L1f:
            goto L5d
        L20:
            java.lang.String r4 = "CONSENT_SIGNAL_NOT_REQUIRED"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L5d
            r3 = r1
            goto L57
        L2a:
            java.lang.String r4 = "non_personalized"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L5d
            goto L56
        L33:
            java.lang.String r4 = "CONSENT_SIGNAL_PERSONALIZED_ADS"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L5d
            goto L56
        L3c:
            java.lang.String r4 = "CONSENT_SIGNAL_SUFFICIENT"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L5d
            goto L56
        L45:
            java.lang.String r4 = "personalized"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L5d
            goto L56
        L4e:
            java.lang.String r4 = "CONSENT_SIGNAL_NON_PERSONALIZED_ADS"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L5d
        L56:
            r3 = 3
        L57:
            com.google.android.gms.internal.consent_sdk.zzbe r4 = r2.zzg
            r4.zzg(r3)
            goto L69
        L5d:
            com.google.android.gms.internal.consent_sdk.zzbe r3 = r2.zzg
            com.google.android.gms.internal.consent_sdk.zzg r4 = new com.google.android.gms.internal.consent_sdk.zzg
            java.lang.String r0 = "We are getting something wrong with the webview."
            r4.<init>(r1, r0)
            r3.zzh(r4)
        L69:
            return r1
        L6a:
            java.lang.String r0 = "browser"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L90
            r2.zzg(r4)
            return r1
        L76:
            java.lang.String r4 = "configure_app_assets"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L90
            r2.zzd()
            return r1
        L82:
            java.lang.String r4 = "load_complete"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L90
            com.google.android.gms.internal.consent_sdk.zzbe r3 = r2.zzg
            r3.zzi()
            return r1
        L90:
            r3 = 0
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.consent_sdk.zzcd.zzb(java.lang.String, org.json.JSONObject):boolean");
    }

    public final void zzd() {
        this.zzd.execute(new Runnable() { // from class: com.google.android.gms.internal.consent_sdk.zzcc
            @Override // java.lang.Runnable
            public final void run() {
                zzcd.zzc(this.zza);
            }
        });
    }

    final void zze(String str) {
        Log.d("UserMessagingPlatform", "Receive consent action: ".concat(String.valueOf(str)));
        Uri uri = Uri.parse(str);
        this.zze.zzb(uri.getQueryParameter("action"), uri.getQueryParameter("args"), this, this.zzf);
    }

    final void zzf(int i3, String str, String str2) {
        this.zzg.zzj(new zzg(2, String.format(Locale.US, "WebResourceError(%d, %s): %s", Integer.valueOf(i3), str2, str)));
    }
}
