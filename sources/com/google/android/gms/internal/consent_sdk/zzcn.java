package com.google.android.gms.internal.consent_sdk;

import android.util.JsonReader;
import coil.target.Yb.oUcQRqOVfOC;
import com.facebook.share.internal.ShareConstants;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlinx.serialization.json.internal.OBeo.vgWWUoTKYyuC;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzcn {
    public String zza;
    public String zzb;
    public String zzc;
    public List zzd;
    public List zze;
    public String zzf;
    public int zzg = 1;
    public int zzh;

    public zzcn() {
        List list = Collections.EMPTY_LIST;
        this.zzd = list;
        this.zze = list;
        this.zzh = 1;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static zzcn zza(JsonReader jsonReader) throws IOException {
        int i3;
        zzcn zzcnVar = new zzcn();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            int i4 = 3;
            switch (strNextName.hashCode()) {
                case -2001388947:
                    if (!strNextName.equals("consent_signal")) {
                        jsonReader.skipValue();
                        break;
                    } else {
                        String strNextString = jsonReader.nextString();
                        switch (strNextString.hashCode()) {
                            case -2058725357:
                                if (!strNextString.equals("CONSENT_SIGNAL_COLLECT_CONSENT")) {
                                    throw new IOException("Failed to parse contentads.contributor.direct.serving.appswitchboard.proto.ApplicationGdprResponse.ConsentSignalfrom: ".concat(strNextString));
                                }
                                i4 = 5;
                                zzcnVar.zzg = i4;
                                break;
                                break;
                            case -1969035850:
                                if (!strNextString.equals("CONSENT_SIGNAL_ERROR")) {
                                    throw new IOException("Failed to parse contentads.contributor.direct.serving.appswitchboard.proto.ApplicationGdprResponse.ConsentSignalfrom: ".concat(strNextString));
                                }
                                i4 = 7;
                                zzcnVar.zzg = i4;
                                break;
                                break;
                            case -1263695752:
                                if (!strNextString.equals("CONSENT_SIGNAL_UNKNOWN")) {
                                    throw new IOException("Failed to parse contentads.contributor.direct.serving.appswitchboard.proto.ApplicationGdprResponse.ConsentSignalfrom: ".concat(strNextString));
                                }
                                i4 = 1;
                                zzcnVar.zzg = i4;
                                break;
                                break;
                            case -954325659:
                                if (!strNextString.equals("CONSENT_SIGNAL_NON_PERSONALIZED_ADS")) {
                                    throw new IOException("Failed to parse contentads.contributor.direct.serving.appswitchboard.proto.ApplicationGdprResponse.ConsentSignalfrom: ".concat(strNextString));
                                }
                                zzcnVar.zzg = i4;
                                break;
                            case -918677260:
                                if (!strNextString.equals("CONSENT_SIGNAL_PUBLISHER_MISCONFIGURATION")) {
                                    throw new IOException("Failed to parse contentads.contributor.direct.serving.appswitchboard.proto.ApplicationGdprResponse.ConsentSignalfrom: ".concat(strNextString));
                                }
                                i4 = 8;
                                zzcnVar.zzg = i4;
                                break;
                                break;
                            case 429411856:
                                if (!strNextString.equals("CONSENT_SIGNAL_SUFFICIENT")) {
                                    throw new IOException("Failed to parse contentads.contributor.direct.serving.appswitchboard.proto.ApplicationGdprResponse.ConsentSignalfrom: ".concat(strNextString));
                                }
                                i4 = 4;
                                zzcnVar.zzg = i4;
                                break;
                                break;
                            case 467888915:
                                if (!strNextString.equals("CONSENT_SIGNAL_PERSONALIZED_ADS")) {
                                    throw new IOException("Failed to parse contentads.contributor.direct.serving.appswitchboard.proto.ApplicationGdprResponse.ConsentSignalfrom: ".concat(strNextString));
                                }
                                i4 = 2;
                                zzcnVar.zzg = i4;
                                break;
                                break;
                            case 1725474845:
                                if (!strNextString.equals("CONSENT_SIGNAL_NOT_REQUIRED")) {
                                    throw new IOException("Failed to parse contentads.contributor.direct.serving.appswitchboard.proto.ApplicationGdprResponse.ConsentSignalfrom: ".concat(strNextString));
                                }
                                i4 = 6;
                                zzcnVar.zzg = i4;
                                break;
                                break;
                            default:
                                throw new IOException("Failed to parse contentads.contributor.direct.serving.appswitchboard.proto.ApplicationGdprResponse.ConsentSignalfrom: ".concat(strNextString));
                        }
                    }
                    break;
                case -1938755376:
                    if (!strNextName.equals(oUcQRqOVfOC.ueikGeyizmBSU)) {
                        jsonReader.skipValue();
                    } else {
                        zzcnVar.zzc = jsonReader.nextString();
                    }
                    break;
                case -1851537225:
                    if (!strNextName.equals("consent_form_base_url")) {
                        jsonReader.skipValue();
                    } else {
                        zzcnVar.zzb = jsonReader.nextString();
                    }
                    break;
                case -1734348803:
                    if (!strNextName.equals("client_side_pingback_url")) {
                        jsonReader.skipValue();
                    } else {
                        zzcnVar.zzf = jsonReader.nextString();
                    }
                    break;
                case -1324537865:
                    if (!strNextName.equals("privacy_options_required")) {
                        jsonReader.skipValue();
                    } else {
                        String strNextString2 = jsonReader.nextString();
                        int iHashCode = strNextString2.hashCode();
                        if (iHashCode == -1888946261) {
                            if (!strNextString2.equals("NOT_REQUIRED")) {
                                throw new IOException("Failed to parse contentads.contributor.direct.serving.appswitchboard.proto.ApplicationGdprResponse.PrivacyOptionsRequirementStatusfrom: ".concat(strNextString2));
                            }
                            zzcnVar.zzh = i4;
                        } else if (iHashCode != 389487519) {
                            if (iHashCode != 433141802 || !strNextString2.equals("UNKNOWN")) {
                                throw new IOException("Failed to parse contentads.contributor.direct.serving.appswitchboard.proto.ApplicationGdprResponse.PrivacyOptionsRequirementStatusfrom: ".concat(strNextString2));
                            }
                            i4 = 1;
                            zzcnVar.zzh = i4;
                        } else {
                            if (!strNextString2.equals("REQUIRED")) {
                                throw new IOException("Failed to parse contentads.contributor.direct.serving.appswitchboard.proto.ApplicationGdprResponse.PrivacyOptionsRequirementStatusfrom: ".concat(strNextString2));
                            }
                            i4 = 2;
                            zzcnVar.zzh = i4;
                        }
                    }
                    break;
                case -1161803523:
                    if (!strNextName.equals("actions")) {
                        jsonReader.skipValue();
                    } else {
                        zzcnVar.zze = new ArrayList();
                        jsonReader.beginArray();
                        while (jsonReader.hasNext()) {
                            zzcm zzcmVar = new zzcm();
                            jsonReader.beginObject();
                            while (jsonReader.hasNext()) {
                                String strNextName2 = jsonReader.nextName();
                                int iHashCode2 = strNextName2.hashCode();
                                if (iHashCode2 != -2105551094) {
                                    if (iHashCode2 == 1583758243 && strNextName2.equals(ShareConstants.WEB_DIALOG_PARAM_ACTION_TYPE)) {
                                        String strNextString3 = jsonReader.nextString();
                                        int iHashCode3 = strNextString3.hashCode();
                                        if (iHashCode3 == 64208429) {
                                            if (!strNextString3.equals("CLEAR")) {
                                                throw new IOException(vgWWUoTKYyuC.GZBc.concat(strNextString3));
                                            }
                                            i3 = 3;
                                            zzcmVar.zzb = i3;
                                        } else if (iHashCode3 != 82862015) {
                                            if (iHashCode3 != 1856333582 || !strNextString3.equals("UNKNOWN_ACTION_TYPE")) {
                                                throw new IOException(vgWWUoTKYyuC.GZBc.concat(strNextString3));
                                            }
                                            i3 = 1;
                                            zzcmVar.zzb = i3;
                                        } else {
                                            if (!strNextString3.equals("WRITE")) {
                                                throw new IOException(vgWWUoTKYyuC.GZBc.concat(strNextString3));
                                            }
                                            i3 = 2;
                                            zzcmVar.zzb = i3;
                                        }
                                    } else {
                                        jsonReader.skipValue();
                                    }
                                } else if (strNextName2.equals("args_json")) {
                                    zzcmVar.zza = jsonReader.nextString();
                                } else {
                                    jsonReader.skipValue();
                                }
                            }
                            jsonReader.endObject();
                            zzcnVar.zze.add(zzcmVar);
                        }
                        jsonReader.endArray();
                    }
                    break;
                case -986806987:
                    if (!strNextName.equals("request_info_keys")) {
                        jsonReader.skipValue();
                    } else {
                        zzcnVar.zzd = new ArrayList();
                        jsonReader.beginArray();
                        while (jsonReader.hasNext()) {
                            zzcnVar.zzd.add(jsonReader.nextString());
                        }
                        jsonReader.endArray();
                    }
                    break;
                case -790907624:
                    if (!strNextName.equals("consent_form_payload")) {
                        jsonReader.skipValue();
                    } else {
                        zzcnVar.zza = jsonReader.nextString();
                    }
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return zzcnVar;
    }
}
