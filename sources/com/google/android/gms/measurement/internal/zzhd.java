package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzqp;
import java.util.Arrays;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzhd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f73791a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Bundle f73792b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Bundle f73793c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ zzhh f73794d;

    public zzhd(zzhh zzhhVar, String str, Bundle bundle) {
        Objects.requireNonNull(zzhhVar);
        this.f73794d = zzhhVar;
        Preconditions.g(str);
        this.f73791a = str;
        this.f73792b = new Bundle();
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x00fc A[Catch: NumberFormatException | JSONException -> 0x010c, NumberFormatException | JSONException -> 0x010c, TRY_LEAVE, TryCatch #1 {NumberFormatException | JSONException -> 0x010c, blocks: (B:10:0x0027, B:24:0x005b, B:24:0x005b, B:26:0x006c, B:26:0x006c, B:28:0x007e, B:28:0x007e, B:29:0x0087, B:29:0x0087, B:51:0x00fc, B:51:0x00fc, B:33:0x0094, B:33:0x0094, B:35:0x00a5, B:35:0x00a5, B:37:0x00b7, B:37:0x00b7, B:38:0x00c0, B:38:0x00c0, B:42:0x00cc, B:42:0x00cc, B:46:0x00dc, B:46:0x00dc, B:50:0x00f0, B:50:0x00f0), top: B:65:0x0027, outer: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.os.Bundle a() {
        /*
            Method dump skipped, instruction units count: 331
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzhd.a():android.os.Bundle");
    }

    public final void b(Bundle bundle) {
        Bundle bundle2 = bundle == null ? new Bundle() : new Bundle(bundle);
        zzhh zzhhVar = this.f73794d;
        SharedPreferences.Editor editorEdit = zzhhVar.p().edit();
        if (bundle2.size() == 0) {
            editorEdit.remove(this.f73791a);
        } else {
            String str = this.f73791a;
            JSONArray jSONArray = new JSONArray();
            for (String str2 : bundle2.keySet()) {
                Object obj = bundle2.get(str2);
                if (obj != null) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("n", str2);
                        zzqp.zza();
                        zzic zzicVar = zzhhVar.f73997a;
                        if (zzicVar.w().H(null, zzfy.R0)) {
                            if (obj instanceof String) {
                                jSONObject.put("v", obj.toString());
                                jSONObject.put("t", "s");
                            } else if (obj instanceof Long) {
                                jSONObject.put("v", obj.toString());
                                jSONObject.put("t", "l");
                            } else if (obj instanceof int[]) {
                                jSONObject.put("v", Arrays.toString((int[]) obj));
                                jSONObject.put("t", "ia");
                            } else if (obj instanceof long[]) {
                                jSONObject.put("v", Arrays.toString((long[]) obj));
                                jSONObject.put("t", "la");
                            } else if (obj instanceof Double) {
                                jSONObject.put("v", obj.toString());
                                jSONObject.put("t", "d");
                            } else {
                                zzicVar.a().o().b("Cannot serialize bundle value to SharedPreferences. Type", obj.getClass());
                            }
                            jSONArray.put(jSONObject);
                        } else {
                            jSONObject.put("v", obj.toString());
                            if (obj instanceof String) {
                                jSONObject.put("t", "s");
                            } else if (obj instanceof Long) {
                                jSONObject.put("t", "l");
                            } else if (obj instanceof Double) {
                                jSONObject.put("t", "d");
                            } else {
                                zzicVar.a().o().b("Cannot serialize bundle value to SharedPreferences. Type", obj.getClass());
                            }
                            jSONArray.put(jSONObject);
                        }
                    } catch (JSONException e3) {
                        this.f73794d.f73997a.a().o().b("Cannot serialize bundle value to SharedPreferences", e3);
                    }
                }
            }
            editorEdit.putString(str, jSONArray.toString());
        }
        editorEdit.apply();
        this.f73793c = bundle2;
    }
}
