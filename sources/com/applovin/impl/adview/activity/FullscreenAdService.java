package com.applovin.impl.adview.activity;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import com.applovin.adview.AppLovinFullscreenActivity;
import com.applovin.impl.fc;
import com.applovin.impl.sb;
import com.applovin.impl.sdk.n;
import com.applovin.impl.yp;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class FullscreenAdService extends Service {
    public static final String DATA_KEY_RAW_FULL_AD_RESPONSE = "raw_full_ad_response";
    private static final String TAG = "FullscreenAdService";

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class b extends Handler {
        private b() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            try {
                sb sbVar = AppLovinFullscreenActivity.parentInterstitialWrapper;
                if (sbVar == null) {
                    if (!yp.a(1.0d)) {
                        super.handleMessage(message);
                        return;
                    }
                    throw new RuntimeException("parentWrapper is null for " + message.what);
                }
                com.applovin.impl.sdk.ad.b bVarF = sbVar.f();
                int i3 = message.what;
                c cVar = c.AD;
                if (i3 == cVar.b()) {
                    Bundle bundle = new Bundle();
                    bundle.putString(FullscreenAdService.DATA_KEY_RAW_FULL_AD_RESPONSE, bVarF.getRawFullResponse());
                    Message messageObtain = Message.obtain((Handler) null, cVar.b());
                    messageObtain.setData(bundle);
                    try {
                        message.replyTo.send(messageObtain);
                        return;
                    } catch (RemoteException e3) {
                        n.c(FullscreenAdService.TAG, "Failed to respond to Fullscreen Activity in another process with ad", e3);
                        return;
                    }
                }
                if (message.what == c.AD_DISPLAYED.b()) {
                    fc.a(sbVar.c(), bVarF);
                    return;
                }
                if (message.what == c.AD_CLICKED.b()) {
                    fc.a(sbVar.b(), bVarF);
                    return;
                }
                if (message.what == c.AD_VIDEO_STARTED.b()) {
                    fc.a(sbVar.d(), bVarF);
                    return;
                }
                if (message.what == c.AD_VIDEO_ENDED.b()) {
                    Bundle data = message.getData();
                    fc.a(sbVar.d(), bVarF, data.getDouble("percent_viewed"), data.getBoolean("fully_watched"));
                    return;
                }
                if (message.what == c.AD_HIDDEN.b()) {
                    fc.b(sbVar.c(), bVarF);
                } else {
                    super.handleMessage(message);
                }
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public enum c {
        AD(0),
        AD_DISPLAYED(1),
        AD_CLICKED(2),
        AD_VIDEO_STARTED(3),
        AD_VIDEO_ENDED(4),
        AD_HIDDEN(5);


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f58306a;

        c(int i3) {
            this.f58306a = i3;
        }

        public int b() {
            return this.f58306a;
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return new Messenger(new b()).getBinder();
    }
}
