package com.google.android.gms.ads.internal.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.google.android.gms.internal.ads.zzbiq;
import com.google.android.gms.internal.ads.zzgck;
import com.google.android.gms.internal.ads.zzgcl;
import com.google.android.gms.internal.ads.zzgcm;
import com.google.android.gms.internal.ads.zzgsx;
import com.google.android.gms.internal.ads.zzgty;
import java.io.IOException;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzac {
    public static void a(Context context) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzhh)).booleanValue() && context != null) {
            context.deleteDatabase("OfflineUpload.db");
        }
        try {
            zzgck zzgckVarZzh = zzgck.zzh(context);
            zzgcl zzgclVarZzh = zzgcl.zzh(context);
            zzgcm zzgcmVarZza = zzgcm.zza(context);
            zzgckVarZzh.zzk();
            zzgckVarZzh.zzl();
            zzgclVarZzh.zzj();
            zzgcmVarZza.zzb(null);
        } catch (IOException e3) {
            com.google.android.gms.ads.internal.zzt.l().zzg(e3, "clearStorageOnIdlessMode");
        }
    }

    public static Bundle b(Context context, String str) {
        JSONArray jSONArray;
        Object obj;
        SharedPreferences sharedPreferences;
        String str2;
        if (TextUtils.isEmpty(str)) {
            jSONArray = null;
        } else {
            try {
                jSONArray = new JSONArray(str);
            } catch (JSONException e3) {
                int i3 = zze.f70328b;
                com.google.android.gms.ads.internal.util.client.zzo.b("JSON parsing error", e3);
                jSONArray = null;
            }
        }
        if (jSONArray == null) {
            return Bundle.EMPTY;
        }
        Bundle bundle = new Bundle();
        for (int i4 = 0; i4 < jSONArray.length(); i4++) {
            JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i4);
            String strOptString = jSONObjectOptJSONObject.optString("bk");
            String strOptString2 = jSONObjectOptJSONObject.optString("sk");
            int iOptInt = jSONObjectOptJSONObject.optInt("type", -1);
            int i5 = iOptInt != 0 ? iOptInt != 1 ? iOptInt != 2 ? 0 : 3 : 2 : 1;
            if (!TextUtils.isEmpty(strOptString) && !TextUtils.isEmpty(strOptString2) && i5 != 0) {
                List listZze = zzgty.zza(zzgsx.zzc('/')).zze(strOptString2);
                if (listZze.size() > 2 || listZze.isEmpty()) {
                    obj = null;
                } else {
                    if (listZze.size() == 1) {
                        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
                        str2 = (String) listZze.get(0);
                    } else {
                        sharedPreferences = context.getSharedPreferences((String) listZze.get(0), 0);
                        str2 = (String) listZze.get(1);
                    }
                    obj = sharedPreferences.getAll().get(str2);
                }
                if (obj != null) {
                    int i6 = i5 - 1;
                    if (i6 != 0) {
                        if (i6 != 1) {
                            if (obj instanceof Boolean) {
                                bundle.putBoolean(strOptString, ((Boolean) obj).booleanValue());
                            }
                        } else if (obj instanceof Integer) {
                            bundle.putInt(strOptString, ((Integer) obj).intValue());
                        } else if (obj instanceof Long) {
                            bundle.putLong(strOptString, ((Long) obj).longValue());
                        } else if (obj instanceof Float) {
                            bundle.putFloat(strOptString, ((Float) obj).floatValue());
                        }
                    } else if (obj instanceof String) {
                        bundle.putString(strOptString, (String) obj);
                    }
                }
            }
        }
        return bundle;
    }

    public static Bundle c(Context context, String str, SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        if (TextUtils.isEmpty(str)) {
            return Bundle.EMPTY;
        }
        PreferenceManager.getDefaultSharedPreferences(context).registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
        return b(context, str);
    }
}
