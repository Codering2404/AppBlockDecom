package com.applovin.impl.adview.activity;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.text.TextUtils;
import com.applovin.adview.AppLovinFullscreenActivity;
import com.applovin.impl.adview.activity.FullscreenAdService;
import com.applovin.impl.h0;
import com.applovin.impl.o9;
import com.applovin.impl.sb;
import com.applovin.impl.sdk.j;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.um;
import com.applovin.mediation.AppLovinUtils;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class a implements ServiceConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final j f58307a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final n f58308b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final WeakReference f58309c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final AtomicBoolean f58310d = new AtomicBoolean();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Messenger f58311e;

    /* JADX INFO: renamed from: com.applovin.impl.adview.activity.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class C0100a implements AppLovinAdLoadListener {
        C0100a() {
        }

        @Override // com.applovin.sdk.AppLovinAdLoadListener
        public void adReceived(AppLovinAd appLovinAd) {
            AppLovinFullscreenActivity appLovinFullscreenActivity = (AppLovinFullscreenActivity) a.this.f58309c.get();
            if (appLovinFullscreenActivity != null) {
                n unused = a.this.f58308b;
                if (n.a()) {
                    a.this.f58308b.a("AppLovinFullscreenActivity", "Presenting ad...");
                }
                b bVar = new b(a.this, null);
                o9.a((com.applovin.impl.sdk.ad.b) appLovinAd, bVar, bVar, bVar, null, a.this.f58307a, appLovinFullscreenActivity, new C0101a(appLovinFullscreenActivity, appLovinAd, bVar));
                return;
            }
            n unused2 = a.this.f58308b;
            if (n.a()) {
                a.this.f58308b.b("AppLovinFullscreenActivity", "Unable to present ad, parent activity has been GC'd - " + appLovinAd);
            }
        }

        @Override // com.applovin.sdk.AppLovinAdLoadListener
        public void failedToReceiveAd(int i3) {
            a.this.a();
        }

        /* JADX INFO: renamed from: com.applovin.impl.adview.activity.a$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        class C0101a implements o9.d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ AppLovinFullscreenActivity f58313a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ AppLovinAd f58314b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ b f58315c;

            C0101a(AppLovinFullscreenActivity appLovinFullscreenActivity, AppLovinAd appLovinAd, b bVar) {
                this.f58313a = appLovinFullscreenActivity;
                this.f58314b = appLovinAd;
                this.f58315c = bVar;
            }

            @Override // com.applovin.impl.o9.d
            public void a(o9 o9Var) {
                this.f58313a.setPresenter(o9Var);
                o9Var.y();
            }

            @Override // com.applovin.impl.o9.d
            public void a(String str, Throwable th) {
                sb.a((com.applovin.impl.sdk.ad.b) this.f58314b, this.f58315c, str, th, this.f58313a);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class b implements AppLovinAdDisplayListener, AppLovinAdClickListener, AppLovinAdVideoPlaybackListener {
        private b() {
        }

        private void a(FullscreenAdService.c cVar) {
            a(null, cVar);
        }

        @Override // com.applovin.sdk.AppLovinAdClickListener
        public void adClicked(AppLovinAd appLovinAd) {
            a(FullscreenAdService.c.AD_CLICKED);
        }

        @Override // com.applovin.sdk.AppLovinAdDisplayListener
        public void adDisplayed(AppLovinAd appLovinAd) {
            a(FullscreenAdService.c.AD_DISPLAYED);
        }

        @Override // com.applovin.sdk.AppLovinAdDisplayListener
        public void adHidden(AppLovinAd appLovinAd) {
            a(FullscreenAdService.c.AD_HIDDEN);
        }

        @Override // com.applovin.sdk.AppLovinAdVideoPlaybackListener
        public void videoPlaybackBegan(AppLovinAd appLovinAd) {
            a(FullscreenAdService.c.AD_VIDEO_STARTED);
        }

        @Override // com.applovin.sdk.AppLovinAdVideoPlaybackListener
        public void videoPlaybackEnded(AppLovinAd appLovinAd, double d3, boolean z2) {
            Bundle bundle = new Bundle();
            bundle.putDouble("percent_viewed", d3);
            bundle.putBoolean("fully_watched", z2);
            a(bundle, FullscreenAdService.c.AD_VIDEO_ENDED);
        }

        /* synthetic */ b(a aVar, C0100a c0100a) {
            this();
        }

        private void a(Bundle bundle, FullscreenAdService.c cVar) {
            Message messageObtain = Message.obtain((Handler) null, cVar.b());
            if (bundle != null) {
                messageObtain.setData(bundle);
            }
            try {
                a.this.f58311e.send(messageObtain);
            } catch (RemoteException e3) {
                n unused = a.this.f58308b;
                if (n.a()) {
                    a.this.f58308b.a("AppLovinFullscreenActivity", "Failed to forward callback (" + cVar.b() + ")", e3);
                }
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class c extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final WeakReference f58318a;

        /* synthetic */ c(a aVar, C0100a c0100a) {
            this(aVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            a aVar;
            if (message.what != FullscreenAdService.c.AD.b() || (aVar = (a) this.f58318a.get()) == null) {
                super.handleMessage(message);
            } else {
                aVar.a(message.getData().getString(FullscreenAdService.DATA_KEY_RAW_FULL_AD_RESPONSE));
            }
        }

        private c(a aVar) {
            this.f58318a = new WeakReference(aVar);
        }
    }

    public a(AppLovinFullscreenActivity appLovinFullscreenActivity, j jVar) {
        this.f58307a = jVar;
        this.f58308b = jVar.I();
        this.f58309c = new WeakReference(appLovinFullscreenActivity);
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (this.f58310d.compareAndSet(false, true)) {
            if (n.a()) {
                this.f58308b.a("AppLovinFullscreenActivity", "Fullscreen ad service connected to " + componentName);
            }
            this.f58311e = new Messenger(iBinder);
            Message messageObtain = Message.obtain((Handler) null, FullscreenAdService.c.AD.b());
            messageObtain.replyTo = new Messenger(new c(this, null));
            try {
                if (n.a()) {
                    this.f58308b.a("AppLovinFullscreenActivity", "Requesting ad from FullscreenAdService...");
                }
                this.f58311e.send(messageObtain);
            } catch (RemoteException e3) {
                if (n.a()) {
                    this.f58308b.a("AppLovinFullscreenActivity", "Failed to send ad request message to FullscreenAdService", e3);
                }
                a();
            }
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        if (this.f58310d.compareAndSet(true, false) && n.a()) {
            this.f58308b.a("AppLovinFullscreenActivity", "FullscreenAdService disconnected from " + componentName);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        AppLovinFullscreenActivity appLovinFullscreenActivity = (AppLovinFullscreenActivity) this.f58309c.get();
        if (appLovinFullscreenActivity != null) {
            if (n.a()) {
                this.f58308b.a("AppLovinFullscreenActivity", "Dismissing...");
            }
            appLovinFullscreenActivity.dismiss();
        } else if (n.a()) {
            this.f58308b.b("AppLovinFullscreenActivity", "Unable to dismiss parent Activity");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = JsonUtils.getString(jSONObject, AppLovinUtils.ServerParameterKeys.ZONE_ID, "");
            if (!TextUtils.isEmpty(string)) {
                this.f58307a.i0().a(new um(jSONObject, h0.a(string), true, new C0100a(), this.f58307a));
                return;
            }
            throw new IllegalStateException("No zone identifier found in ad response: " + jSONObject);
        } catch (JSONException e3) {
            if (n.a()) {
                this.f58308b.a("AppLovinFullscreenActivity", "Unable to process ad: " + str, e3);
            }
            a();
        }
    }
}
