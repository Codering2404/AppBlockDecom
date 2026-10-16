package com.google.android.gms.internal.ads;

import android.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.os.Message;
import android.view.View;
import android.view.WindowManager;
import android.webkit.ConsoleMessage;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebStorage;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.revenuecat.purchases.common.Constants;
import cz.mobilesoft.coreblock.scene.lockscreen.EI.MrGIhy;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzckt extends WebChromeClient {
    private final zzcku zza;

    public zzckt(zzcku zzckuVar) {
        this.zza = zzckuVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final Context zzb(WebView webView) {
        if (!(webView instanceof zzcku)) {
            return webView.getContext();
        }
        zzcku zzckuVar = (zzcku) webView;
        Activity activityZzj = zzckuVar.zzj();
        return activityZzj != null ? activityZzj : zzckuVar.getContext();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.webkit.WebChromeClient
    public final void onCloseWindow(WebView webView) {
        if (!(webView instanceof zzcku)) {
            int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
            com.google.android.gms.ads.internal.util.client.zzo.f("Tried to close a WebView that wasn't an AdWebView.");
            return;
        }
        com.google.android.gms.ads.internal.overlay.zzm zzmVarZzL = ((zzcku) webView).zzL();
        if (zzmVarZzL != null) {
            zzmVarZzL.zzb();
        } else {
            int i4 = com.google.android.gms.ads.internal.util.zze.f70328b;
            com.google.android.gms.ads.internal.util.client.zzo.f("Tried to close an AdWebView not associated with an overlay.");
        }
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onCreateWindow(WebView webView, boolean z2, boolean z3, Message message) {
        WebView.WebViewTransport webViewTransport = (WebView.WebViewTransport) message.obj;
        WebView webView2 = new WebView(webView.getContext());
        zzcku zzckuVar = this.zza;
        if (zzckuVar.zzQ() != null) {
            webView2.setWebViewClient(zzckuVar.zzQ());
        }
        webViewTransport.setWebView(webView2);
        message.sendToTarget();
        return true;
    }

    @Override // android.webkit.WebChromeClient
    public final void onExceededDatabaseQuota(String str, String str2, long j3, long j4, long j5, WebStorage.QuotaUpdater quotaUpdater) {
        long j6 = 5242880 - j5;
        if (j6 <= 0) {
            quotaUpdater.updateQuota(j3);
            return;
        }
        if (j3 == 0) {
            if (j4 > j6 || j4 > 1048576) {
                j4 = 0;
            }
        } else if (j4 == 0) {
            j4 = Math.min(j3 + Math.min(131072L, j6), 1048576L);
        } else {
            if (j4 <= Math.min(1048576 - j3, j6)) {
                j3 += j4;
            }
            j4 = j3;
        }
        quotaUpdater.updateQuota(j4);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0024  */
    @Override // android.webkit.WebChromeClient
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onGeolocationPermissionsShowPrompt(java.lang.String r6, android.webkit.GeolocationPermissions.Callback r7) {
        /*
            r5 = this;
            if (r7 == 0) goto L59
            com.google.android.gms.internal.ads.zzcku r0 = r5.zza
            com.google.android.gms.ads.internal.zzt.g()
            android.content.Context r1 = r0.getContext()
            java.lang.String r2 = "android.permission.ACCESS_FINE_LOCATION"
            boolean r1 = com.google.android.gms.ads.internal.util.zzs.d(r1, r2)
            r2 = 0
            r3 = 1
            if (r1 != 0) goto L24
            com.google.android.gms.ads.internal.zzt.g()
            android.content.Context r0 = r0.getContext()
            java.lang.String r1 = "android.permission.ACCESS_COARSE_LOCATION"
            boolean r0 = com.google.android.gms.ads.internal.util.zzs.d(r0, r1)
            if (r0 == 0) goto L26
        L24:
            r0 = r3
            goto L27
        L26:
            r0 = r2
        L27:
            com.google.android.gms.internal.ads.zzbih r1 = com.google.android.gms.internal.ads.zzbiq.zzoI
            com.google.android.gms.internal.ads.zzbio r4 = com.google.android.gms.ads.internal.client.zzba.c()
            java.lang.Object r1 = r4.zzd(r1)
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            if (r1 == 0) goto L3d
            r7.invoke(r6, r2, r3)
            goto L40
        L3d:
            r7.invoke(r6, r0, r3)
        L40:
            com.google.android.gms.internal.ads.zzbih r6 = com.google.android.gms.internal.ads.zzbiq.zzoJ
            com.google.android.gms.internal.ads.zzbio r7 = com.google.android.gms.ads.internal.client.zzba.c()
            java.lang.Object r6 = r7.zzd(r6)
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r6 = r6.booleanValue()
            if (r6 == 0) goto L59
            int r6 = com.google.android.gms.ads.internal.util.zze.f70328b
            java.lang.String r6 = "AdWebChromeClient.onGeolocationPermissionsShowPrompt()"
            com.google.android.gms.ads.internal.util.client.zzo.a(r6)
        L59:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzckt.onGeolocationPermissionsShowPrompt(java.lang.String, android.webkit.GeolocationPermissions$Callback):void");
    }

    @Override // android.webkit.WebChromeClient
    public final void onHideCustomView() {
        com.google.android.gms.ads.internal.overlay.zzm zzmVarZzL = this.zza.zzL();
        if (zzmVarZzL != null) {
            zzmVarZzL.zzc();
        } else {
            int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
            com.google.android.gms.ads.internal.util.client.zzo.f("Could not get ad overlay when hiding custom view.");
        }
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        return zza(zzb(webView), "alert", str, str2, null, jsResult, null, false);
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onJsBeforeUnload(WebView webView, String str, String str2, JsResult jsResult) {
        return zza(zzb(webView), "onBeforeUnload", str, str2, null, jsResult, null, false);
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
        return zza(zzb(webView), "confirm", str, str2, null, jsResult, null, false);
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        return zza(zzb(webView), "prompt", str, str2, str3, null, jsPromptResult, true);
    }

    @Override // android.webkit.WebChromeClient
    @Deprecated
    public final void onShowCustomView(View view, int i3, WebChromeClient.CustomViewCallback customViewCallback) {
        com.google.android.gms.ads.internal.overlay.zzm zzmVarZzL = this.zza.zzL();
        if (zzmVarZzL != null) {
            zzmVarZzL.p5(view, customViewCallback);
            zzmVarZzL.o5(i3);
        } else {
            int i4 = com.google.android.gms.ads.internal.util.zze.f70328b;
            com.google.android.gms.ads.internal.util.client.zzo.f("Could not get ad overlay when showing custom view.");
            customViewCallback.onCustomViewHidden();
        }
    }

    protected final boolean zza(Context context, String str, String str2, String str3, String str4, JsResult jsResult, JsPromptResult jsPromptResult, boolean z2) {
        zzcku zzckuVar;
        com.google.android.gms.ads.internal.zzb zzbVarZzh;
        try {
            zzckuVar = this.zza;
        } catch (WindowManager.BadTokenException e3) {
            int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
            com.google.android.gms.ads.internal.util.client.zzo.g("Fail to display Dialog.", e3);
        }
        if (zzckuVar != null && zzckuVar.zzP() != null && zzckuVar.zzP().zzh() != null && (zzbVarZzh = zzckuVar.zzP().zzh()) != null && !zzbVarZzh.b()) {
            StringBuilder sb = new StringBuilder(str.length() + 9 + String.valueOf(str3).length() + 2);
            sb.append("window.");
            sb.append(str);
            sb.append("('");
            sb.append(str3);
            sb.append("')");
            zzbVarZzh.c(sb.toString());
            return false;
        }
        com.google.android.gms.ads.internal.zzt.g();
        AlertDialog.Builder builderN = com.google.android.gms.ads.internal.util.zzs.n(context);
        builderN.setTitle(str2);
        if (z2) {
            LinearLayout linearLayout = new LinearLayout(context);
            linearLayout.setOrientation(1);
            TextView textView = new TextView(context);
            textView.setText(str3);
            EditText editText = new EditText(context);
            editText.setText(str4);
            linearLayout.addView(textView);
            linearLayout.addView(editText);
            builderN.setView(linearLayout).setPositiveButton(R.string.ok, new zzckr(jsPromptResult, editText)).setNegativeButton(R.string.cancel, new zzckq(jsPromptResult)).setOnCancelListener(new zzckp(jsPromptResult)).create().show();
        } else {
            builderN.setMessage(str3).setPositiveButton(R.string.ok, new zzcko(jsResult)).setNegativeButton(R.string.cancel, new zzckn(jsResult)).setOnCancelListener(new zzckm(jsResult)).create().show();
        }
        return true;
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        String strMessage = consoleMessage.message();
        String strSourceId = consoleMessage.sourceId();
        int iLineNumber = consoleMessage.lineNumber();
        int length = String.valueOf(strMessage).length();
        StringBuilder sb = new StringBuilder(length + 6 + String.valueOf(strSourceId).length() + 1 + String.valueOf(iLineNumber).length() + 1);
        sb.append("JS: ");
        sb.append(strMessage);
        sb.append(" (");
        sb.append(strSourceId);
        sb.append(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR);
        sb.append(iLineNumber);
        sb.append(MrGIhy.RnUlkCQVBv);
        String string = sb.toString();
        if (string.contains("Application Cache")) {
            return super.onConsoleMessage(consoleMessage);
        }
        int i3 = zzcks.zza[consoleMessage.messageLevel().ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 3 || i3 == 4 || i3 != 5) {
                    int i4 = com.google.android.gms.ads.internal.util.zze.f70328b;
                    com.google.android.gms.ads.internal.util.client.zzo.e(string);
                } else {
                    int i5 = com.google.android.gms.ads.internal.util.zze.f70328b;
                    com.google.android.gms.ads.internal.util.client.zzo.a(string);
                }
            } else {
                int i6 = com.google.android.gms.ads.internal.util.zze.f70328b;
                com.google.android.gms.ads.internal.util.client.zzo.f(string);
            }
        } else {
            int i7 = com.google.android.gms.ads.internal.util.zze.f70328b;
            com.google.android.gms.ads.internal.util.client.zzo.c(string);
        }
        return super.onConsoleMessage(consoleMessage);
    }

    @Override // android.webkit.WebChromeClient
    public final void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        onShowCustomView(view, -1, customViewCallback);
    }
}
