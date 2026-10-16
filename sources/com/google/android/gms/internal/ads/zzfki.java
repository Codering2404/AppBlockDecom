package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.util.JsonReader;
import android.util.JsonToken;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsTracker;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzfki {
    public final List zza;
    public final String zzb;
    public final int zzc;
    public final int zzd;
    public final String zze;
    public final int zzf;
    public final long zzg;
    public final boolean zzh;
    public final String zzi;
    public final zzfkh zzj;
    public final Bundle zzk;
    public final String zzl;
    public final String zzm;
    public final String zzn;
    public final JSONObject zzo;
    public final JSONObject zzp;
    public final String zzq;
    public final int zzr;
    public long zzs;
    public long zzt;

    zzfki(JsonReader jsonReader) throws IllegalStateException, JSONException, IOException, NumberFormatException {
        List listB = Collections.EMPTY_LIST;
        Bundle bundle = new Bundle();
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        jsonReader.beginObject();
        String strNextString = "";
        String strNextString2 = "";
        String strNextString3 = strNextString2;
        String strNextString4 = strNextString3;
        String strNextString5 = strNextString4;
        int iNextInt = 0;
        int iNextInt2 = 0;
        boolean zNextBoolean = false;
        zzfkh zzfkhVar = null;
        long jZza = -1;
        long jZza2 = -1;
        long jNextLong = 0;
        int iNextInt3 = -1;
        int iMax = 1;
        String strNextString6 = strNextString5;
        String strNextString7 = strNextString6;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            if (Objects.equals(strNextName, "nofill_urls")) {
                listB = com.google.android.gms.ads.internal.util.zzbp.b(jsonReader);
            } else if ("refresh_interval".equals(strNextName)) {
                iNextInt = jsonReader.nextInt();
            } else if (Objects.equals(strNextName, "refresh_load_delay_time_interval")) {
                iNextInt3 = jsonReader.nextInt();
            } else if ("gws_query_id".equals(strNextName)) {
                strNextString = jsonReader.nextString();
            } else if ("analytics_query_ad_event_id".equals(strNextName)) {
                strNextString6 = jsonReader.nextString();
            } else if ("is_idless".equals(strNextName)) {
                zNextBoolean = jsonReader.nextBoolean();
            } else if (DiagnosticsTracker.RESPONSE_CODE_KEY.equals(strNextName)) {
                iNextInt2 = jsonReader.nextInt();
            } else if ("latency".equals(strNextName)) {
                jNextLong = jsonReader.nextLong();
            } else {
                String str = strNextString3;
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzjB)).booleanValue() && "public_error".equals(strNextName) && jsonReader.peek() == JsonToken.BEGIN_OBJECT) {
                    zzfkhVar = new zzfkh(jsonReader);
                } else if ("bidding_data".equals(strNextName)) {
                    strNextString7 = jsonReader.nextString();
                } else {
                    if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzlP)).booleanValue() && Objects.equals(strNextName, "topics_should_record_observation")) {
                        jsonReader.nextBoolean();
                    } else if ("adapter_response_replacement_key".equals(strNextName)) {
                        strNextString3 = jsonReader.nextString();
                    } else if ("response_info_extras".equals(strNextName)) {
                        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzhK)).booleanValue()) {
                            try {
                                try {
                                    Bundle bundleL = com.google.android.gms.ads.internal.util.zzbp.l(com.google.android.gms.ads.internal.util.zzbp.d(jsonReader));
                                    if (bundleL != null) {
                                        bundle = bundleL;
                                    }
                                } catch (IOException | JSONException unused) {
                                }
                            } catch (IllegalStateException unused2) {
                                jsonReader.skipValue();
                            }
                        } else {
                            jsonReader.skipValue();
                        }
                    } else if ("adRequestPostBody".equals(strNextName)) {
                        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzkH)).booleanValue()) {
                            strNextString5 = jsonReader.nextString();
                        } else {
                            jsonReader.skipValue();
                        }
                    } else if ("adRequestUrl".equals(strNextName)) {
                        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzkH)).booleanValue()) {
                            strNextString4 = jsonReader.nextString();
                        } else {
                            jsonReader.skipValue();
                        }
                    } else {
                        zzbih zzbihVar = zzbiq.zzkI;
                        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbihVar)).booleanValue() && Objects.equals(strNextName, "adResponseBody")) {
                            strNextString2 = jsonReader.nextString();
                        } else if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbihVar)).booleanValue() && Objects.equals(strNextName, "adResponseHeaders")) {
                            jSONObject = com.google.android.gms.ads.internal.util.zzbp.d(jsonReader);
                        } else if (Objects.equals(strNextName, "max_parallel_renderers")) {
                            iMax = Math.max(1, jsonReader.nextInt());
                        } else {
                            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzkQ)).booleanValue() && Objects.equals(strNextName, "inspector_ad_transaction_extras")) {
                                jSONObject2 = com.google.android.gms.ads.internal.util.zzbp.d(jsonReader);
                            } else {
                                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzcO)).booleanValue() && Objects.equals(strNextName, "latency_extras")) {
                                    try {
                                        Bundle bundleL2 = com.google.android.gms.ads.internal.util.zzbp.l(com.google.android.gms.ads.internal.util.zzbp.d(jsonReader));
                                        if (bundleL2 != null) {
                                            jZza2 = zza(bundleL2.getDouble("start_time"));
                                            jZza = zza(bundleL2.getDouble(SDKConstants.PARAM_TOURNAMENTS_END_TIME));
                                        }
                                    } catch (IllegalStateException unused3) {
                                        jsonReader.skipValue();
                                    }
                                } else {
                                    jsonReader.skipValue();
                                }
                            }
                        }
                    }
                }
                strNextString3 = str;
            }
        }
        String str2 = strNextString3;
        jsonReader.endObject();
        this.zza = listB;
        this.zzc = iNextInt;
        if (((Boolean) zzbkw.zzd.zze()).booleanValue()) {
            this.zzd = -1;
        } else {
            zzbka zzbkaVar = zzbke.zza;
            if (((Long) zzbkaVar.zze()).longValue() > -1) {
                this.zzd = ((Long) zzbkaVar.zze()).intValue();
            } else {
                this.zzd = iNextInt3;
            }
        }
        this.zzb = strNextString;
        this.zze = strNextString6;
        this.zzf = iNextInt2;
        this.zzg = jNextLong;
        this.zzj = zzfkhVar;
        this.zzh = zNextBoolean;
        this.zzi = strNextString7;
        this.zzk = bundle;
        this.zzl = strNextString4;
        this.zzm = strNextString5;
        this.zzn = strNextString2;
        this.zzo = jSONObject;
        this.zzp = jSONObject2;
        this.zzq = str2;
        zzbka zzbkaVar2 = zzbku.zza;
        this.zzr = ((Long) zzbkaVar2.zze()).longValue() > 0 ? ((Long) zzbkaVar2.zze()).intValue() : iMax;
        this.zzs = jZza2;
        this.zzt = jZza;
    }

    private static final long zza(double d3) {
        if (d3 > 9.223372036854776E18d || d3 < -9.223372036854776E18d) {
            return -1L;
        }
        return (long) d3;
    }
}
