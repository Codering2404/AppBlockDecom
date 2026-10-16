package com.google.ads.mediation.facebook;

import android.content.Context;
import com.facebook.ads.AudienceNetworkAds;
import com.google.android.gms.ads.AdError;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
class FacebookInitializer implements AudienceNetworkAds.InitListener {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static FacebookInitializer f68989d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f68990a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f68991b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ArrayList f68992c = new ArrayList();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    interface Listener {
        void a(AdError adError);

        void b();
    }

    private FacebookInitializer() {
    }

    static FacebookInitializer a() {
        if (f68989d == null) {
            f68989d = new FacebookInitializer();
        }
        return f68989d;
    }

    void b(Context context, ArrayList arrayList, Listener listener) {
        if (this.f68990a) {
            this.f68992c.add(listener);
        } else {
            if (this.f68991b) {
                listener.b();
                return;
            }
            this.f68990a = true;
            a().f68992c.add(listener);
            AudienceNetworkAds.buildInitSettings(context).withMediationService("GOOGLE:6.21.0.3").withPlacementIds(arrayList).withInitListener(this).initialize();
        }
    }

    @Override // com.facebook.ads.AudienceNetworkAds.InitListener
    public void onInitialized(AudienceNetworkAds.InitResult initResult) {
        int i3 = 0;
        this.f68990a = false;
        this.f68991b = initResult.isSuccess();
        ArrayList arrayList = this.f68992c;
        int size = arrayList.size();
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            Listener listener = (Listener) obj;
            if (initResult.isSuccess()) {
                listener.b();
            } else {
                listener.a(new AdError(104, initResult.getMessage(), FacebookMediationAdapter.ERROR_DOMAIN));
            }
        }
        this.f68992c.clear();
    }
}
