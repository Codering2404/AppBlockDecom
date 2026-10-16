package com.google.android.gms.internal.ads;

import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.internal.ServerProtocol;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public class zzbyg {
    private final zzcku zza;
    private final String zzb;

    public zzbyg(zzcku zzckuVar, String str) {
        this.zza = zzckuVar;
        this.zzb = str;
    }

    public final void zzg(String str) {
        try {
            JSONObject jSONObjectPut = new JSONObject().put("message", str).put("action", this.zzb);
            zzcku zzckuVar = this.zza;
            if (zzckuVar != null) {
                zzckuVar.zzd("onError", jSONObjectPut);
            }
        } catch (JSONException e3) {
            int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
            com.google.android.gms.ads.internal.util.client.zzo.d("Error occurred while dispatching error event.", e3);
        }
    }

    public final void zzh(String str) {
        try {
            this.zza.zzd("onReadyEventReceived", new JSONObject().put("js", str));
        } catch (JSONException e3) {
            int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
            com.google.android.gms.ads.internal.util.client.zzo.d("Error occurred while dispatching ready Event.", e3);
        }
    }

    public final void zzi(int i3, int i4, int i5, int i6) {
        try {
            this.zza.zzd("onSizeChanged", new JSONObject().put("x", i3).put("y", i4).put(ViewHierarchyConstants.DIMENSION_WIDTH_KEY, i5).put(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, i6));
        } catch (JSONException e3) {
            int i7 = com.google.android.gms.ads.internal.util.zze.f70328b;
            com.google.android.gms.ads.internal.util.client.zzo.d("Error occurred while dispatching size change.", e3);
        }
    }

    public final void zzj(int i3, int i4, int i5, int i6) {
        try {
            this.zza.zzd("onDefaultPositionReceived", new JSONObject().put("x", i3).put("y", i4).put(ViewHierarchyConstants.DIMENSION_WIDTH_KEY, i5).put(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, i6));
        } catch (JSONException e3) {
            int i7 = com.google.android.gms.ads.internal.util.zze.f70328b;
            com.google.android.gms.ads.internal.util.client.zzo.d("Error occurred while dispatching default position.", e3);
        }
    }

    public final void zzk(String str) {
        try {
            this.zza.zzd("onStateChanged", new JSONObject().put(ServerProtocol.DIALOG_PARAM_STATE, str));
        } catch (JSONException e3) {
            int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
            com.google.android.gms.ads.internal.util.client.zzo.d("Error occurred while dispatching state change.", e3);
        }
    }

    public final void zzl(int i3, int i4, int i5, int i6, float f3, int i7) {
        try {
            this.zza.zzd("onScreenInfoChanged", new JSONObject().put(ViewHierarchyConstants.DIMENSION_WIDTH_KEY, i3).put(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, i4).put("maxSizeWidth", i5).put("maxSizeHeight", i6).put("density", f3).put("rotation", i7));
        } catch (JSONException e3) {
            int i8 = com.google.android.gms.ads.internal.util.zze.f70328b;
            com.google.android.gms.ads.internal.util.client.zzo.d("Error occurred while obtaining screen information.", e3);
        }
    }
}
