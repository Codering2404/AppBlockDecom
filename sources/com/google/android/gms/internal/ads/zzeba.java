package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.JsonReader;
import com.google.android.gms.ads.RequestConfiguration;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzeba extends zzbqs {
    private final zzebd zza;
    private final zzeay zzb;
    private final Map zzc = new HashMap();

    zzeba(zzebd zzebdVar, zzeay zzeayVar) {
        this.zza = zzebdVar;
        this.zzb = zzeayVar;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private static com.google.android.gms.ads.internal.client.zzm zzc(Map map) {
        com.google.android.gms.ads.internal.client.zzn zznVar = new com.google.android.gms.ads.internal.client.zzn();
        String str = (String) map.get("ad_request");
        if (str == null) {
            return zznVar.a();
        }
        JsonReader jsonReader = new JsonReader(new StringReader(Uri.decode(str)));
        try {
            jsonReader.beginObject();
            while (jsonReader.hasNext()) {
                String strNextName = jsonReader.nextName();
                switch (strNextName.hashCode()) {
                    case -1289032093:
                        if (!strNextName.equals("extras")) {
                            jsonReader.skipValue();
                        } else {
                            jsonReader.beginObject();
                            Bundle bundle = new Bundle();
                            while (jsonReader.hasNext()) {
                                bundle.putString(jsonReader.nextName(), jsonReader.nextString());
                            }
                            jsonReader.endObject();
                            zznVar.b(bundle);
                        }
                        break;
                    case -839117230:
                        if (!strNextName.equals("isTestDevice")) {
                            jsonReader.skipValue();
                        } else {
                            zznVar.d(jsonReader.nextBoolean());
                        }
                        break;
                    case -733436947:
                        if (!strNextName.equals("tagForUnderAgeOfConsent")) {
                            jsonReader.skipValue();
                        } else if (!jsonReader.nextBoolean()) {
                            zznVar.f(0);
                        } else {
                            zznVar.f(1);
                        }
                        break;
                    case -99890337:
                        if (!strNextName.equals("httpTimeoutMillis")) {
                            jsonReader.skipValue();
                        } else {
                            zznVar.h(jsonReader.nextInt());
                        }
                        break;
                    case 523149226:
                        if (!strNextName.equals("keywords")) {
                            jsonReader.skipValue();
                        } else {
                            jsonReader.beginArray();
                            ArrayList arrayList = new ArrayList();
                            while (jsonReader.hasNext()) {
                                arrayList.add(jsonReader.nextString());
                            }
                            jsonReader.endArray();
                            zznVar.c(arrayList);
                        }
                        break;
                    case 597632527:
                        if (!strNextName.equals("maxAdContentRating")) {
                            jsonReader.skipValue();
                        } else {
                            String strNextString = jsonReader.nextString();
                            if (RequestConfiguration.f69678f.contains(strNextString)) {
                                zznVar.g(strNextString);
                            }
                        }
                        break;
                    case 1411582723:
                        if (!strNextName.equals("tagForChildDirectedTreatment")) {
                            jsonReader.skipValue();
                        } else if (!jsonReader.nextBoolean()) {
                            zznVar.e(0);
                        } else {
                            zznVar.e(1);
                        }
                        break;
                    default:
                        jsonReader.skipValue();
                        break;
                }
            }
            jsonReader.endObject();
        } catch (IOException unused) {
            int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
            com.google.android.gms.ads.internal.util.client.zzo.a("Ad Request json was malformed, parsing ended early.");
        }
        com.google.android.gms.ads.internal.client.zzm zzmVarA = zznVar.a();
        Bundle bundle2 = zzmVarA.f69976n;
        Bundle bundle3 = bundle2.getBundle("com.google.ads.mediation.admob.AdMobAdapter");
        if (bundle3 == null) {
            bundle3 = zzmVarA.f69966c;
            bundle2.putBundle("com.google.ads.mediation.admob.AdMobAdapter", bundle3);
        }
        return new com.google.android.gms.ads.internal.client.zzm(zzmVarA.f69964a, zzmVarA.f69965b, bundle3, zzmVarA.f69967d, zzmVarA.f69968f, zzmVarA.f69969g, zzmVarA.f69970h, zzmVarA.f69971i, zzmVarA.f69972j, zzmVarA.f69973k, zzmVarA.f69974l, zzmVarA.f69975m, bundle2, zzmVarA.f69977o, zzmVarA.f69978p, zzmVarA.f69979q, zzmVarA.f69980r, zzmVarA.f69981s, zzmVarA.f69982t, zzmVarA.f69983u, zzmVarA.f69984v, zzmVarA.f69985w, zzmVarA.f69986x, zzmVarA.f69987y, zzmVarA.f69988z, zzmVarA.A, zzmVarA.B);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.google.android.gms.internal.ads.zzbqt
    public final void zze(String str) throws RemoteException {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzlq)).booleanValue()) {
            com.google.android.gms.ads.internal.util.zze.k("Received H5 gmsg: ".concat(String.valueOf(str)));
            Uri uri = Uri.parse(str);
            com.google.android.gms.ads.internal.zzt.g();
            Map mapT = com.google.android.gms.ads.internal.util.zzs.t(uri);
            String str2 = (String) mapT.get("action");
            if (TextUtils.isEmpty(str2)) {
                com.google.android.gms.ads.internal.util.client.zzo.a("H5 gmsg did not contain an action");
                return;
            }
            int iHashCode = str2.hashCode();
            if (iHashCode != 579053441) {
                if (iHashCode == 871091088 && str2.equals("initialize")) {
                    this.zzc.clear();
                    this.zzb.zza();
                    return;
                }
            } else if (str2.equals("dispose_all")) {
                Map map = this.zzc;
                Iterator it = map.values().iterator();
                while (it.hasNext()) {
                    ((zzeau) it.next()).zzc();
                }
                map.clear();
                return;
            }
            String str3 = (String) mapT.get("obj_id");
            try {
                Objects.requireNonNull(str3);
                long j3 = Long.parseLong(str3);
                switch (str2.hashCode()) {
                    case -1790951212:
                        if (str2.equals("show_interstitial_ad")) {
                            zzeau zzeauVar = (zzeau) this.zzc.get(Long.valueOf(j3));
                            if (zzeauVar != null) {
                                zzeauVar.zzb();
                                return;
                            } else {
                                com.google.android.gms.ads.internal.util.client.zzo.a("Could not show H5 ad, object ID does not exist");
                                this.zzb.zzd(j3);
                                return;
                            }
                        }
                        break;
                    case -1266374734:
                        if (str2.equals("show_rewarded_ad")) {
                            zzeau zzeauVar2 = (zzeau) this.zzc.get(Long.valueOf(j3));
                            if (zzeauVar2 != null) {
                                zzeauVar2.zzb();
                                return;
                            } else {
                                com.google.android.gms.ads.internal.util.client.zzo.a("Could not show H5 ad, object ID does not exist");
                                this.zzb.zzj(j3);
                                return;
                            }
                        }
                        break;
                    case -257098725:
                        if (str2.equals("load_rewarded_ad")) {
                            zzeau zzeauVar3 = (zzeau) this.zzc.get(Long.valueOf(j3));
                            if (zzeauVar3 != null) {
                                zzeauVar3.zza(zzc(mapT));
                                return;
                            } else {
                                com.google.android.gms.ads.internal.util.client.zzo.a("Could not load H5 ad, object ID does not exist");
                                this.zzb.zzj(j3);
                                return;
                            }
                        }
                        break;
                    case 393881811:
                        if (str2.equals("create_interstitial_ad")) {
                            Map map2 = this.zzc;
                            if (map2.size() >= ((Integer) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzlr)).intValue()) {
                                com.google.android.gms.ads.internal.util.client.zzo.f("Could not create H5 ad, too many existing objects");
                                this.zzb.zzc(j3);
                                return;
                            }
                            Long lValueOf = Long.valueOf(j3);
                            if (map2.containsKey(lValueOf)) {
                                com.google.android.gms.ads.internal.util.client.zzo.a("Could not create H5 ad, object ID already exists");
                                this.zzb.zzc(j3);
                                return;
                            }
                            String str4 = (String) mapT.get("ad_unit");
                            if (TextUtils.isEmpty(str4)) {
                                com.google.android.gms.ads.internal.util.client.zzo.f("Could not create H5 ad, missing ad unit id");
                                this.zzb.zzc(j3);
                                return;
                            }
                            zzeav zzeavVarZzc = this.zza.zzc();
                            zzeavVarZzc.zzc(j3);
                            zzeavVarZzc.zzb(str4);
                            map2.put(lValueOf, zzeavVarZzc.zza().zza());
                            this.zzb.zzb(j3);
                            StringBuilder sb = new StringBuilder(String.valueOf(j3).length() + 39 + String.valueOf(str4).length());
                            sb.append("Created H5 interstitial #");
                            sb.append(j3);
                            sb.append(" with ad unit ");
                            sb.append(str4);
                            com.google.android.gms.ads.internal.util.zze.k(sb.toString());
                            return;
                        }
                        break;
                    case 585513149:
                        if (str2.equals("load_interstitial_ad")) {
                            zzeau zzeauVar4 = (zzeau) this.zzc.get(Long.valueOf(j3));
                            if (zzeauVar4 != null) {
                                zzeauVar4.zza(zzc(mapT));
                                return;
                            } else {
                                com.google.android.gms.ads.internal.util.client.zzo.a("Could not load H5 ad, object ID does not exist");
                                this.zzb.zzd(j3);
                                return;
                            }
                        }
                        break;
                    case 1671767583:
                        if (str2.equals("dispose")) {
                            Map map3 = this.zzc;
                            Long lValueOf2 = Long.valueOf(j3);
                            zzeau zzeauVar5 = (zzeau) map3.get(lValueOf2);
                            if (zzeauVar5 == null) {
                                com.google.android.gms.ads.internal.util.client.zzo.a("Could not dispose H5 ad, object ID does not exist");
                                return;
                            }
                            zzeauVar5.zzc();
                            map3.remove(lValueOf2);
                            StringBuilder sb2 = new StringBuilder(String.valueOf(j3).length() + 16);
                            sb2.append("Disposed H5 ad #");
                            sb2.append(j3);
                            com.google.android.gms.ads.internal.util.zze.k(sb2.toString());
                            return;
                        }
                        break;
                    case 2109237041:
                        if (str2.equals("create_rewarded_ad")) {
                            Map map4 = this.zzc;
                            if (map4.size() >= ((Integer) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzlr)).intValue()) {
                                com.google.android.gms.ads.internal.util.client.zzo.f("Could not create H5 ad, too many existing objects");
                                this.zzb.zzc(j3);
                                return;
                            }
                            Long lValueOf3 = Long.valueOf(j3);
                            if (map4.containsKey(lValueOf3)) {
                                com.google.android.gms.ads.internal.util.client.zzo.a("Could not create H5 ad, object ID already exists");
                                this.zzb.zzc(j3);
                                return;
                            }
                            String str5 = (String) mapT.get("ad_unit");
                            if (TextUtils.isEmpty(str5)) {
                                com.google.android.gms.ads.internal.util.client.zzo.f("Could not create H5 ad, missing ad unit id");
                                this.zzb.zzc(j3);
                                return;
                            }
                            zzeav zzeavVarZzc2 = this.zza.zzc();
                            zzeavVarZzc2.zzc(j3);
                            zzeavVarZzc2.zzb(str5);
                            map4.put(lValueOf3, zzeavVarZzc2.zza().zzb());
                            this.zzb.zzb(j3);
                            StringBuilder sb3 = new StringBuilder(String.valueOf(j3).length() + 35 + String.valueOf(str5).length());
                            sb3.append("Created H5 rewarded #");
                            sb3.append(j3);
                            sb3.append(" with ad unit ");
                            sb3.append(str5);
                            com.google.android.gms.ads.internal.util.zze.k(sb3.toString());
                            return;
                        }
                        break;
                }
                com.google.android.gms.ads.internal.util.client.zzo.a("H5 gmsg contained invalid action: ".concat(str2));
            } catch (NullPointerException | NumberFormatException unused) {
                com.google.android.gms.ads.internal.util.client.zzo.a("H5 gmsg did not contain a valid object id: ".concat(String.valueOf(str3)));
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbqt
    public final void zzf() {
        this.zzc.clear();
    }
}
