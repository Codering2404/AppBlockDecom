package com.applovin.impl.sdk.network;

import com.applovin.impl.gm;
import com.applovin.impl.sdk.EventServiceImpl;
import com.applovin.impl.sdk.j;
import com.applovin.impl.tm;
import com.applovin.impl.yl;
import com.applovin.sdk.AppLovinPostbackListener;
import com.applovin.sdk.AppLovinPostbackService;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class PostbackServiceImpl implements AppLovinPostbackService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final j f63476a;

    public PostbackServiceImpl(j jVar) {
        this.f63476a = jVar;
    }

    private boolean a(e eVar) {
        Map mapI = eVar.i();
        if (mapI == null) {
            return false;
        }
        Object obj = mapI.get("event");
        if ("postinstall".equals(obj)) {
            obj = mapI.get("sub_event");
        }
        return EventServiceImpl.ALLOW_PRE_INIT_EVENT_TYPES.contains(obj);
    }

    @Override // com.applovin.sdk.AppLovinPostbackService
    public void dispatchPostbackAsync(String str, AppLovinPostbackListener appLovinPostbackListener) {
        dispatchPostbackRequest(e.b(this.f63476a).b(str).a(false).a(), appLovinPostbackListener);
    }

    public void dispatchPostbackRequest(e eVar, tm.b bVar, AppLovinPostbackListener appLovinPostbackListener) {
        gm gmVar = new gm(eVar, bVar, this.f63476a, appLovinPostbackListener);
        gmVar.a(a(eVar));
        this.f63476a.i0().a((yl) gmVar, bVar);
    }

    public String toString() {
        return "PostbackService{}";
    }

    public void dispatchPostbackRequest(e eVar, AppLovinPostbackListener appLovinPostbackListener) {
        dispatchPostbackRequest(eVar, tm.b.OTHER, appLovinPostbackListener);
    }
}
