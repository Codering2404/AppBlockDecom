package com.google.android.gms.ads.nonagon.signalgeneration;

import android.os.Bundle;
import android.util.JsonReader;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.internal.NativeProtocol;
import com.google.android.gms.internal.ads.zzbiq;
import com.google.android.gms.internal.ads.zzcbd;
import com.google.android.gms.internal.ads.zzdyu;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f70706a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f70707b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public zzcbd f70708c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Bundle f70709d = new Bundle();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f70710e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f70711f;

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public zzbc(JsonReader jsonReader, zzcbd zzcbdVar) throws IOException {
        Bundle bundle;
        this.f70710e = -1L;
        this.f70711f = -1L;
        this.f70708c = zzcbdVar;
        HashMap map = new HashMap();
        jsonReader.beginObject();
        String strNextString = "";
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName = strNextName == null ? "" : strNextName;
            switch (strNextName.hashCode()) {
                case -1573145462:
                    if (strNextName.equals("start_time")) {
                        this.f70710e = jsonReader.nextLong();
                    } else {
                        jsonReader.skipValue();
                    }
                    break;
                case -995427962:
                    if (strNextName.equals(NativeProtocol.WEB_DIALOG_PARAMS)) {
                        strNextString = jsonReader.nextString();
                    } else {
                        jsonReader.skipValue();
                    }
                    break;
                case -271442291:
                    if (strNextName.equals("signal_dictionary")) {
                        map = new HashMap();
                        jsonReader.beginObject();
                        while (jsonReader.hasNext()) {
                            map.put(jsonReader.nextName(), jsonReader.nextString());
                        }
                        jsonReader.endObject();
                    } else {
                        jsonReader.skipValue();
                    }
                    break;
                case 1725551537:
                    if (strNextName.equals(SDKConstants.PARAM_TOURNAMENTS_END_TIME)) {
                        this.f70711f = jsonReader.nextLong();
                    } else {
                        jsonReader.skipValue();
                    }
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        this.f70706a = strNextString;
        jsonReader.endObject();
        for (Map.Entry entry : map.entrySet()) {
            if (entry.getKey() != null && entry.getValue() != null) {
                this.f70709d.putString((String) entry.getKey(), (String) entry.getValue());
            }
        }
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzcN)).booleanValue() || zzcbdVar == null || (bundle = zzcbdVar.zzm) == null) {
            return;
        }
        bundle.putLong(zzdyu.GET_SIGNALS_SDKCORE_START.zza(), this.f70710e);
        zzcbdVar.zzm.putLong(zzdyu.GET_SIGNALS_SDKCORE_END.zza(), this.f70711f);
    }
}
