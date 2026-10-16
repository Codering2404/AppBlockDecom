package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;
import com.facebook.GraphRequest;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.ads.admanager.AdManagerAdRequest;
import com.google.android.gms.ads.nativead.NativeAdOptions;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbqe implements zzbpq {
    private final zzedo zza;

    public zzbqe(zzedo zzedoVar) {
        this.zza = zzedoVar;
    }

    private static final Bundle zzb(Map map) {
        Bundle bundle = new Bundle();
        bundle.putString("request_origin", "inspector_ooct");
        if (map.containsKey("networkExtras")) {
            try {
                JSONObject jSONObject = new JSONObject((String) map.get("networkExtras"));
                Iterator<String> itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    Object obj = jSONObject.get(next);
                    if (obj instanceof String) {
                        bundle.putString(next, (String) obj);
                    } else if (obj instanceof Integer) {
                        bundle.putInt(next, ((Integer) obj).intValue());
                    } else if (obj instanceof Boolean) {
                        bundle.putBoolean(next, ((Boolean) obj).booleanValue());
                    } else if (obj instanceof Float) {
                        bundle.putFloat(next, ((Float) obj).floatValue());
                    } else if (obj instanceof Double) {
                        bundle.putDouble(next, ((Double) obj).doubleValue());
                    } else if (obj instanceof Long) {
                        bundle.putLong(next, ((Long) obj).longValue());
                    }
                }
            } catch (JSONException e3) {
                com.google.android.gms.ads.internal.zzt.l().zzg(e3, "OutOfContextTestingGmsgHandler.generateNetworkExtras");
            }
        }
        return bundle;
    }

    private static final List zzc(String str, String str2) {
        try {
            JSONArray jSONArray = new JSONArray(str);
            ArrayList arrayList = new ArrayList();
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                arrayList.add(jSONArray.getString(i3));
            }
            return arrayList;
        } catch (JSONException e3) {
            com.google.android.gms.ads.internal.zzt.l().zzg(e3, "OutOfContextTestingGmsgHandler.stringArrayToList.".concat(str2));
            return new ArrayList();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbpq
    public final void zza(Object obj, Map map) {
        AdRequest adRequestM;
        AdSize adSize;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzkM)).booleanValue()) {
            zzedp zzedpVar = new zzedp();
            String str = (String) map.get("adUnitId");
            if (!TextUtils.isEmpty(str)) {
                zzedpVar.zzh(str);
            }
            String str2 = (String) map.get(GraphRequest.FORMAT_PARAM);
            if (!TextUtils.isEmpty(str2)) {
                zzedpVar.zzi(str2);
            }
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzkO)).booleanValue()) {
                boolean z2 = false;
                if (map.containsKey("isGamRequest") && ((String) map.get("isGamRequest")).equals(AppEventsConstants.EVENT_PARAM_VALUE_YES)) {
                    z2 = true;
                }
                zzedpVar.zzn(z2);
                if (zzedpVar.zzg()) {
                    AdManagerAdRequest.Builder builder = new AdManagerAdRequest.Builder();
                    if (map.containsKey("keywords")) {
                        Iterator it = zzc((String) map.get("keywords"), "keywords").iterator();
                        while (it.hasNext()) {
                            builder.b((String) it.next());
                        }
                    }
                    builder.c(AdMobAdapter.class, zzb(map));
                    if (map.containsKey("customTargeting")) {
                        try {
                            JSONObject jSONObject = new JSONObject((String) map.get("customTargeting"));
                            Iterator<String> itKeys = jSONObject.keys();
                            while (itKeys.hasNext()) {
                                String next = itKeys.next();
                                builder.a(next, jSONObject.getString(next));
                            }
                        } catch (JSONException e3) {
                            com.google.android.gms.ads.internal.zzt.l().zzg(e3, "OutOfContextTestingGmsgHandler.generateAdManagerAdRequest");
                        }
                    }
                    if (map.containsKey("contentUrl") && !TextUtils.isEmpty((CharSequence) map.get("contentUrl"))) {
                        builder.f((String) map.get("contentUrl"));
                    }
                    if (map.containsKey("neighboringContentUrlStrings")) {
                        builder.g(zzc((String) map.get("neighboringContentUrlStrings"), "neighboringContentUrlStrings"));
                    }
                    if (map.containsKey("requestAgent")) {
                        builder.h((String) map.get("requestAgent"));
                    }
                    if (map.containsKey("publisherProvidedId")) {
                        builder.o((String) map.get("publisherProvidedId"));
                    }
                    if (map.containsKey("categoryExclusions")) {
                        Iterator it2 = zzc((String) map.get("categoryExclusions"), "categoryExclusions").iterator();
                        while (it2.hasNext()) {
                            builder.m((String) it2.next());
                        }
                    }
                    adRequestM = builder.n();
                } else {
                    AdRequest.Builder builder2 = new AdRequest.Builder();
                    if (map.containsKey("keywords")) {
                        Iterator it3 = zzc((String) map.get("keywords"), "keywords").iterator();
                        while (it3.hasNext()) {
                            builder2.b((String) it3.next());
                        }
                    }
                    builder2.c(AdMobAdapter.class, zzb(map));
                    if (map.containsKey("customTargeting")) {
                        try {
                            JSONObject jSONObject2 = new JSONObject((String) map.get("customTargeting"));
                            Iterator<String> itKeys2 = jSONObject2.keys();
                            while (itKeys2.hasNext()) {
                                String next2 = itKeys2.next();
                                builder2.a(next2, jSONObject2.getString(next2));
                            }
                        } catch (JSONException e4) {
                            com.google.android.gms.ads.internal.zzt.l().zzg(e4, "OutOfContextTestingGmsgHandler.generateAdMobAdRequest");
                        }
                    }
                    if (map.containsKey("contentUrl") && !TextUtils.isEmpty((CharSequence) map.get("contentUrl"))) {
                        builder2.f((String) map.get("contentUrl"));
                    }
                    if (map.containsKey("neighboringContentUrlStrings")) {
                        builder2.g(zzc((String) map.get("neighboringContentUrlStrings"), "neighboringContentUrlStrings"));
                    }
                    if (map.containsKey("requestAgent")) {
                        builder2.h((String) map.get("requestAgent"));
                    }
                    adRequestM = builder2.m();
                }
                zzedpVar.zzj(adRequestM);
                String str3 = (String) map.get(ViewHierarchyConstants.DIMENSION_WIDTH_KEY);
                String str4 = (String) map.get(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY);
                if (TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4)) {
                    adSize = AdSize.f69645j;
                } else {
                    try {
                        adSize = new AdSize(Integer.parseInt(str3), Integer.parseInt(str4));
                    } catch (NumberFormatException e5) {
                        com.google.android.gms.ads.internal.zzt.l().zzg(e5, "OutOfContextTestingGmsgHandler.generateAdSize");
                        adSize = AdSize.f69645j;
                    }
                }
                zzedpVar.zzk(adSize);
                if (map.containsKey("clickToExpandRequested") || map.containsKey("customControlsRequested") || map.containsKey("startMuted")) {
                    VideoOptions.Builder builder3 = new VideoOptions.Builder();
                    if (map.containsKey("startMuted")) {
                        builder3.d(((String) map.get("startMuted")).equals(AppEventsConstants.EVENT_PARAM_VALUE_YES));
                    }
                    if (map.containsKey("customControlsRequested")) {
                        builder3.c(((String) map.get("customControlsRequested")).equals(AppEventsConstants.EVENT_PARAM_VALUE_YES));
                    }
                    if (map.containsKey("clickToExpandRequested")) {
                        builder3.b(((String) map.get("clickToExpandRequested")).equals(AppEventsConstants.EVENT_PARAM_VALUE_YES));
                    }
                    zzedpVar.zzm(builder3.a());
                }
                if (map.containsKey("customMuteThisAdRequested") || map.containsKey("disableImageLoading") || map.containsKey("mediaAspectRatio") || map.containsKey("preferredAdChoicesPosition") || map.containsKey("shouldRequestMultipleImages") || (zzedpVar.zzf() != null && zzedpVar.zzb().equals("NATIVE"))) {
                    NativeAdOptions.Builder builder4 = new NativeAdOptions.Builder();
                    if (map.containsKey("disableImageLoading")) {
                        builder4.g(((String) map.get("disableImageLoading")).equals(AppEventsConstants.EVENT_PARAM_VALUE_YES));
                    }
                    if (map.containsKey("mediaAspectRatio")) {
                        String str5 = (String) map.get("mediaAspectRatio");
                        if (!TextUtils.isEmpty(str5)) {
                            try {
                                builder4.d(Integer.parseInt(str5));
                            } catch (NumberFormatException e6) {
                                com.google.android.gms.ads.internal.zzt.l().zzg(e6, "OutOfContextTestingGmsgHandler.generateNativeAdOptionsBuilder.mediaAspectRatio");
                            }
                        }
                    }
                    if (map.containsKey("shouldRequestMultipleImages")) {
                        builder4.f(((String) map.get("shouldRequestMultipleImages")).equals(AppEventsConstants.EVENT_PARAM_VALUE_YES));
                    }
                    if (map.containsKey("preferredAdChoicesPosition")) {
                        String str6 = (String) map.get("preferredAdChoicesPosition");
                        if (!TextUtils.isEmpty(str6)) {
                            try {
                                builder4.c(Integer.parseInt(str6));
                            } catch (NumberFormatException e7) {
                                com.google.android.gms.ads.internal.zzt.l().zzg(e7, "OutOfContextTestingGmsgHandler.generateNativeAdOptionsBuilder.preferredAdChoicesPosition");
                            }
                        }
                    }
                    if (map.containsKey("customMuteThisAdRequested")) {
                        builder4.e(((String) map.get("customMuteThisAdRequested")).equals(AppEventsConstants.EVENT_PARAM_VALUE_YES));
                    }
                    VideoOptions videoOptionsZzf = zzedpVar.zzf();
                    if (videoOptionsZzf != null) {
                        builder4.h(videoOptionsZzf);
                    }
                    zzedpVar.zzl(builder4.a());
                }
            }
            String str7 = (String) map.get("action");
            if (TextUtils.isEmpty(str7) || TextUtils.isEmpty(zzedpVar.zza())) {
                return;
            }
            if (str7.equals("load") && !TextUtils.isEmpty(zzedpVar.zzb())) {
                this.zza.zzc(zzedpVar);
            } else if (str7.equals("show")) {
                this.zza.zzd(zzedpVar.zza());
            }
        }
    }
}
