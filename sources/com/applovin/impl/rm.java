package com.applovin.impl;

import android.net.Uri;
import com.applovin.impl.mediation.MaxErrorImpl;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.mediation.MaxError;
import com.applovin.mediation.adapter.MaxAdapterError;
import com.bumptech.glide.load.data.Bwyd.SbbqvQlxi;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class rm extends yl {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final String f62879h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final List f62880i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final oe f62881j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final Map f62882k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final Map f62883l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final Map f62884m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final MaxError f62885n;

    public rm(String str, List list, Map map, Map map2, MaxError maxError, oe oeVar, com.applovin.impl.sdk.j jVar, boolean z2) {
        super("TaskFireMediationPostbacks", jVar);
        this.f62879h = str + "_urls";
        this.f62880i = list;
        this.f62882k = yp.a(map, jVar);
        this.f62883l = map2 == null ? new HashMap() : map2;
        this.f62885n = maxError != null ? maxError : new MaxErrorImpl(-1);
        this.f62881j = oeVar;
        HashMap map3 = new HashMap(7);
        map3.put("AppLovin-Event-Type", str);
        if (z2 && oeVar != null) {
            map3.put("AppLovin-Ad-Network-Name", oeVar.c());
        }
        if (oeVar instanceof fe) {
            fe feVar = (fe) oeVar;
            map3.put("AppLovin-Ad-Unit-Id", feVar.getAdUnitId());
            map3.put("AppLovin-Ad-Format", feVar.getFormat().getLabel());
            if (z2) {
                map3.put("AppLovin-Third-Party-Ad-Placement-Id", feVar.T());
            }
        }
        if (maxError != null) {
            map3.put("AppLovin-Error-Code", String.valueOf(maxError.getCode()));
            map3.put("AppLovin-Error-Message", maxError.getMessage());
        }
        this.f62884m = map3;
    }

    private void a(String str, Map map) {
        b().W().e(com.applovin.impl.sdk.network.d.b().d(str).c("POST").a(this.f62884m).a(false).c(map).c(((Boolean) this.f65231a.a(ue.O7)).booleanValue()).a());
    }

    private String b(String str, Map map) {
        for (String str2 : map.keySet()) {
            str = str.replace(str2, StringUtils.emptyIfNull((String) map.get(str2)));
        }
        return str;
    }

    private Map e() {
        try {
            return JsonUtils.toStringMap(new JSONObject((String) this.f65231a.a(ue.L6)));
        } catch (JSONException unused) {
            return Collections.EMPTY_MAP;
        }
    }

    private List f() {
        List list = this.f62880i;
        if (list != null) {
            return list;
        }
        oe oeVar = this.f62881j;
        if (oeVar != null) {
            return oeVar.b(this.f62879h);
        }
        return null;
    }

    @Override // java.lang.Runnable
    public void run() {
        List listF = f();
        if (CollectionUtils.isEmpty(listF)) {
            return;
        }
        Map mapE = e();
        Iterator it = listF.iterator();
        while (it.hasNext()) {
            Uri uri = Uri.parse(a(b((String) it.next(), this.f62882k), this.f62885n));
            Uri.Builder builderClearQuery = uri.buildUpon().clearQuery();
            HashMap map = new HashMap(this.f62883l);
            for (String str : uri.getQueryParameterNames()) {
                String queryParameter = uri.getQueryParameter(str);
                if (mapE.containsKey(queryParameter)) {
                    oe oeVar = this.f62881j;
                    if (oeVar != null) {
                        map.put(str, oeVar.a((String) mapE.get(queryParameter)));
                    }
                } else {
                    builderClearQuery.appendQueryParameter(str, queryParameter);
                }
            }
            map.putAll(this.f65231a.x().e());
            a(builderClearQuery.build().toString(), map);
        }
    }

    private String a(String str, MaxError maxError) {
        int mediatedNetworkErrorCode;
        String mediatedNetworkErrorMessage;
        if (maxError instanceof MaxAdapterError) {
            MaxAdapterError maxAdapterError = (MaxAdapterError) maxError;
            mediatedNetworkErrorCode = maxAdapterError.getMediatedNetworkErrorCode();
            mediatedNetworkErrorMessage = maxAdapterError.getMediatedNetworkErrorMessage();
        } else {
            mediatedNetworkErrorCode = 0;
            mediatedNetworkErrorMessage = "";
        }
        return str.replace(SbbqvQlxi.ssMwxdnVDyKTKgV, String.valueOf(maxError.getCode())).replace("{ERROR_MESSAGE}", StringUtils.encodeUriString(maxError.getMessage())).replace("{THIRD_PARTY_SDK_ERROR_CODE}", String.valueOf(mediatedNetworkErrorCode)).replace("{THIRD_PARTY_SDK_ERROR_MESSAGE}", StringUtils.encodeUriString(mediatedNetworkErrorMessage));
    }
}
