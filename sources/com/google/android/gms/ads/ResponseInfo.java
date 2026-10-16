package com.google.android.gms.ads;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.client.zzdx;
import com.google.android.gms.ads.internal.client.zzv;
import com.google.android.gms.ads.internal.util.client.zzo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class ResponseInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zzdx f69694a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List f69695b = new ArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private AdapterResponseInfo f69696c;

    private ResponseInfo(zzdx zzdxVar) {
        this.f69694a = zzdxVar;
        if (zzdxVar != null) {
            try {
                List listZzg = zzdxVar.zzg();
                if (listZzg != null) {
                    Iterator it = listZzg.iterator();
                    while (it.hasNext()) {
                        AdapterResponseInfo adapterResponseInfoE = AdapterResponseInfo.e((zzv) it.next());
                        if (adapterResponseInfoE != null) {
                            this.f69695b.add(adapterResponseInfoE);
                        }
                    }
                }
            } catch (RemoteException e3) {
                zzo.d("Could not forward getAdapterResponseInfo to ResponseInfo.", e3);
            }
        }
        zzdx zzdxVar2 = this.f69694a;
        if (zzdxVar2 == null) {
            return;
        }
        try {
            zzv zzvVarZzh = zzdxVar2.zzh();
            if (zzvVarZzh != null) {
                this.f69696c = AdapterResponseInfo.e(zzvVarZzh);
            }
        } catch (RemoteException e4) {
            zzo.d("Could not forward getLoadedAdapterResponse to ResponseInfo.", e4);
        }
    }

    public static ResponseInfo e(zzdx zzdxVar) {
        if (zzdxVar != null) {
            return new ResponseInfo(zzdxVar);
        }
        return null;
    }

    public static ResponseInfo f(zzdx zzdxVar) {
        return new ResponseInfo(zzdxVar);
    }

    public String a() {
        try {
            zzdx zzdxVar = this.f69694a;
            if (zzdxVar != null) {
                return zzdxVar.zze();
            }
            return null;
        } catch (RemoteException e3) {
            zzo.d("Could not forward getMediationAdapterClassName to ResponseInfo.", e3);
            return null;
        }
    }

    public Bundle b() {
        try {
            zzdx zzdxVar = this.f69694a;
            if (zzdxVar != null) {
                return zzdxVar.zzi();
            }
        } catch (RemoteException e3) {
            zzo.d("Could not forward getResponseExtras to ResponseInfo.", e3);
        }
        return new Bundle();
    }

    public String c() {
        try {
            zzdx zzdxVar = this.f69694a;
            if (zzdxVar != null) {
                return zzdxVar.zzf();
            }
            return null;
        } catch (RemoteException e3) {
            zzo.d("Could not forward getResponseId to ResponseInfo.", e3);
            return null;
        }
    }

    public final JSONObject d() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        String strC = c();
        if (strC == null) {
            jSONObject.put("Response ID", "null");
        } else {
            jSONObject.put("Response ID", strC);
        }
        String strA = a();
        if (strA == null) {
            jSONObject.put("Mediation Adapter Class Name", "null");
        } else {
            jSONObject.put("Mediation Adapter Class Name", strA);
        }
        JSONArray jSONArray = new JSONArray();
        Iterator it = this.f69695b.iterator();
        while (it.hasNext()) {
            jSONArray.put(((AdapterResponseInfo) it.next()).f());
        }
        jSONObject.put("Adapter Responses", jSONArray);
        AdapterResponseInfo adapterResponseInfo = this.f69696c;
        if (adapterResponseInfo != null) {
            jSONObject.put("Loaded Adapter Response", adapterResponseInfo.f());
        }
        Bundle bundleB = b();
        if (bundleB != null) {
            jSONObject.put("Response Extras", zzay.a().y(bundleB));
        }
        return jSONObject;
    }

    public final zzdx g() {
        return this.f69694a;
    }

    public String toString() {
        try {
            return d().toString(2);
        } catch (JSONException unused) {
            return "Error forming toString output.";
        }
    }
}
