package com.google.android.gms.measurement.internal;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.media3.common.JBEE.bfIdKSjLOVjG;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.stetho.common.Utf8Charset;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.internal.measurement.zzqp;
import com.google.android.gms.internal.measurement.zzrb;
import com.revenuecat.purchases.common.Constants;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzpk extends zzos {
    zzpk(zzpg zzpgVar) {
        super(zzpgVar);
    }

    private static final String A(boolean z2, boolean z3, boolean z4) {
        StringBuilder sb = new StringBuilder();
        if (z2) {
            sb.append("Dynamic ");
        }
        if (z3) {
            sb.append("Sequence ");
        }
        if (z4) {
            sb.append("Session-Scoped ");
        }
        return sb.toString();
    }

    private static final Object B(com.google.android.gms.internal.measurement.zzhw zzhwVar) {
        if (zzhwVar.zzc()) {
            return zzhwVar.zzd();
        }
        if (zzhwVar.zze()) {
            return Long.valueOf(zzhwVar.zzf());
        }
        if (zzhwVar.zzi()) {
            return Double.valueOf(zzhwVar.zzj());
        }
        if (zzhwVar.zzm() > 0) {
            return Y(zzhwVar.zzk());
        }
        return null;
    }

    private static final void C(Uri.Builder builder, String[] strArr, Bundle bundle, Set set) {
        for (String str : strArr) {
            String[] strArrSplit = str.split(",");
            String str2 = strArrSplit[0];
            String str3 = strArrSplit[strArrSplit.length - 1];
            String string = bundle.getString(str2);
            if (string != null) {
                z(builder, str3, string, set);
            }
        }
    }

    private static final void D(StringBuilder sb, int i3, String str, com.google.android.gms.internal.measurement.zzii zziiVar) {
        if (zziiVar == null) {
            return;
        }
        y(sb, 3);
        sb.append(str);
        sb.append(" {\n");
        if (zziiVar.zzd() != 0) {
            y(sb, 4);
            sb.append("results: ");
            int i4 = 0;
            for (Long l3 : zziiVar.zzc()) {
                int i5 = i4 + 1;
                if (i4 != 0) {
                    sb.append(", ");
                }
                sb.append(l3);
                i4 = i5;
            }
            sb.append('\n');
        }
        if (zziiVar.zzb() != 0) {
            y(sb, 4);
            sb.append("status: ");
            int i6 = 0;
            for (Long l4 : zziiVar.zza()) {
                int i7 = i6 + 1;
                if (i6 != 0) {
                    sb.append(", ");
                }
                sb.append(l4);
                i6 = i7;
            }
            sb.append('\n');
        }
        if (zziiVar.zzf() != 0) {
            y(sb, 4);
            sb.append("dynamic_filter_timestamps: {");
            int i8 = 0;
            for (com.google.android.gms.internal.measurement.zzhq zzhqVar : zziiVar.zze()) {
                int i9 = i8 + 1;
                if (i8 != 0) {
                    sb.append(", ");
                }
                sb.append(zzhqVar.zza() ? Integer.valueOf(zzhqVar.zzb()) : null);
                sb.append(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR);
                sb.append(zzhqVar.zzc() ? Long.valueOf(zzhqVar.zzd()) : null);
                i8 = i9;
            }
            sb.append("}\n");
        }
        if (zziiVar.zzh() != 0) {
            y(sb, 4);
            sb.append("sequence_filter_timestamps: {");
            int i10 = 0;
            for (com.google.android.gms.internal.measurement.zzik zzikVar : zziiVar.zzg()) {
                int i11 = i10 + 1;
                if (i10 != 0) {
                    sb.append(", ");
                }
                sb.append(zzikVar.zza() ? Integer.valueOf(zzikVar.zzb()) : null);
                sb.append(": [");
                Iterator it = zzikVar.zzc().iterator();
                int i12 = 0;
                while (it.hasNext()) {
                    long jLongValue = ((Long) it.next()).longValue();
                    int i13 = i12 + 1;
                    if (i12 != 0) {
                        sb.append(", ");
                    }
                    sb.append(jLongValue);
                    i12 = i13;
                }
                sb.append("]");
                i10 = i11;
            }
            sb.append("}\n");
        }
        y(sb, 3);
        sb.append("}\n");
    }

    private static final void E(StringBuilder sb, int i3, String str, Object obj) {
        if (obj == null) {
            return;
        }
        y(sb, i3 + 1);
        sb.append(str);
        sb.append(": ");
        sb.append(obj);
        sb.append('\n');
    }

    private static final void F(StringBuilder sb, int i3, String str, com.google.android.gms.internal.measurement.zzfl zzflVar) {
        if (zzflVar == null) {
            return;
        }
        y(sb, i3);
        sb.append(str);
        sb.append(" {\n");
        if (zzflVar.zza()) {
            int iZzm = zzflVar.zzm();
            E(sb, i3, "comparison_type", iZzm != 1 ? iZzm != 2 ? iZzm != 3 ? iZzm != 4 ? "BETWEEN" : "EQUAL" : "GREATER_THAN" : "LESS_THAN" : "UNKNOWN_COMPARISON_TYPE");
        }
        if (zzflVar.zzb()) {
            E(sb, i3, "match_as_float", Boolean.valueOf(zzflVar.zzc()));
        }
        if (zzflVar.zzd()) {
            E(sb, i3, "comparison_value", zzflVar.zze());
        }
        if (zzflVar.zzf()) {
            E(sb, i3, "min_comparison_value", zzflVar.zzg());
        }
        if (zzflVar.zzh()) {
            E(sb, i3, "max_comparison_value", zzflVar.zzi());
        }
        y(sb, i3);
        sb.append("}\n");
    }

    static boolean O(String str) {
        return str != null && str.matches("([+-])?([0-9]+\\.?[0-9]*|[0-9]*\\.?[0-9]+)") && str.length() <= 310;
    }

    static boolean P(List list, int i3) {
        if (i3 < list.size() * 64) {
            return ((1 << (i3 % 64)) & ((Long) list.get(i3 / 64)).longValue()) != 0;
        }
        return false;
    }

    static List Q(BitSet bitSet) {
        int length = (bitSet.length() + 63) / 64;
        ArrayList arrayList = new ArrayList(length);
        for (int i3 = 0; i3 < length; i3++) {
            long j3 = 0;
            for (int i4 = 0; i4 < 64; i4++) {
                int i5 = (i3 * 64) + i4;
                if (i5 >= bitSet.length()) {
                    break;
                }
                if (bitSet.get(i5)) {
                    j3 |= 1 << i4;
                }
            }
            arrayList.add(Long.valueOf(j3));
        }
        return arrayList;
    }

    static com.google.android.gms.internal.measurement.zznl W(com.google.android.gms.internal.measurement.zznl zznlVar, byte[] bArr) {
        com.google.android.gms.internal.measurement.zzlr zzlrVarZza = com.google.android.gms.internal.measurement.zzlr.zza();
        return zzlrVarZza != null ? zznlVar.zzaV(bArr, zzlrVarZza) : zznlVar.zzaW(bArr);
    }

    static int X(com.google.android.gms.internal.measurement.zzic zzicVar, String str) {
        for (int i3 = 0; i3 < zzicVar.zzl(); i3++) {
            if (str.equals(zzicVar.zzm(i3).zzc())) {
                return i3;
            }
        }
        return -1;
    }

    static Bundle[] Y(List list) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            com.google.android.gms.internal.measurement.zzhw zzhwVar = (com.google.android.gms.internal.measurement.zzhw) it.next();
            if (zzhwVar != null) {
                Bundle bundle = new Bundle();
                for (com.google.android.gms.internal.measurement.zzhw zzhwVar2 : zzhwVar.zzk()) {
                    if (zzhwVar2.zzc()) {
                        bundle.putString(zzhwVar2.zzb(), zzhwVar2.zzd());
                    } else if (zzhwVar2.zze()) {
                        bundle.putLong(zzhwVar2.zzb(), zzhwVar2.zzf());
                    } else if (zzhwVar2.zzi()) {
                        bundle.putDouble(zzhwVar2.zzb(), zzhwVar2.zzj());
                    }
                }
                if (!bundle.isEmpty()) {
                    arrayList.add(bundle);
                }
            }
        }
        return (Bundle[]) arrayList.toArray(new Bundle[arrayList.size()]);
    }

    static final void o(com.google.android.gms.internal.measurement.zzhr zzhrVar, String str, Object obj) {
        List listZza = zzhrVar.zza();
        int i3 = 0;
        while (true) {
            if (i3 >= listZza.size()) {
                i3 = -1;
                break;
            } else if (str.equals(((com.google.android.gms.internal.measurement.zzhw) listZza.get(i3)).zzb())) {
                break;
            } else {
                i3++;
            }
        }
        com.google.android.gms.internal.measurement.zzhv zzhvVarZzn = com.google.android.gms.internal.measurement.zzhw.zzn();
        zzhvVarZzn.zzb(str);
        zzhvVarZzn.zzf(((Long) obj).longValue());
        if (i3 >= 0) {
            zzhrVar.zze(i3, zzhvVarZzn);
        } else {
            zzhrVar.zzg(zzhvVarZzn);
        }
    }

    static final boolean p(zzbg zzbgVar, zzr zzrVar) {
        Preconditions.m(zzbgVar);
        Preconditions.m(zzrVar);
        return !TextUtils.isEmpty(zzrVar.f74501b);
    }

    static final Bundle q(List list) {
        Bundle bundle = new Bundle();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            com.google.android.gms.internal.measurement.zzhw zzhwVar = (com.google.android.gms.internal.measurement.zzhw) it.next();
            String strZzb = zzhwVar.zzb();
            if (zzhwVar.zzi()) {
                bundle.putDouble(strZzb, zzhwVar.zzj());
            } else if (zzhwVar.zzg()) {
                bundle.putFloat(strZzb, zzhwVar.zzh());
            } else if (zzhwVar.zzc()) {
                bundle.putString(strZzb, zzhwVar.zzd());
            } else if (zzhwVar.zze()) {
                bundle.putLong(strZzb, zzhwVar.zzf());
            }
        }
        return bundle;
    }

    static final com.google.android.gms.internal.measurement.zzhw r(com.google.android.gms.internal.measurement.zzhs zzhsVar, String str) {
        for (com.google.android.gms.internal.measurement.zzhw zzhwVar : zzhsVar.zza()) {
            if (zzhwVar.zzb().equals(str)) {
                return zzhwVar;
            }
        }
        return null;
    }

    static final Map s(com.google.android.gms.internal.measurement.zzhs zzhsVar, String... strArr) {
        Object objB;
        HashMap map = new HashMap();
        for (com.google.android.gms.internal.measurement.zzhw zzhwVar : zzhsVar.zza()) {
            if (Arrays.asList(strArr).contains(zzhwVar.zzb()) && (objB = B(zzhwVar)) != null) {
                map.put(zzhwVar.zzb(), objB);
            }
        }
        return map;
    }

    static final Map t(com.google.android.gms.internal.measurement.zzhs zzhsVar, String str) {
        Object objB;
        HashMap map = new HashMap();
        for (com.google.android.gms.internal.measurement.zzhw zzhwVar : zzhsVar.zza()) {
            if (zzhwVar.zzb().startsWith("gad_") && (objB = B(zzhwVar)) != null) {
                map.put(zzhwVar.zzb(), objB);
            }
        }
        return map;
    }

    static final Object u(com.google.android.gms.internal.measurement.zzhs zzhsVar, String str) {
        com.google.android.gms.internal.measurement.zzhw zzhwVarR = r(zzhsVar, str);
        if (zzhwVarR == null) {
            return null;
        }
        return B(zzhwVarR);
    }

    static final Object v(com.google.android.gms.internal.measurement.zzhs zzhsVar, String str, Object obj) {
        Object objU = u(zzhsVar, str);
        return objU == null ? obj : objU;
    }

    private final void w(StringBuilder sb, int i3, List list) {
        if (list == null) {
            return;
        }
        int i4 = i3 + 1;
        Iterator it = list.iterator();
        while (it.hasNext()) {
            com.google.android.gms.internal.measurement.zzhw zzhwVar = (com.google.android.gms.internal.measurement.zzhw) it.next();
            if (zzhwVar != null) {
                y(sb, i4);
                sb.append("param {\n");
                E(sb, i4, "name", zzhwVar.zza() ? this.f73997a.D().b(zzhwVar.zzb()) : null);
                E(sb, i4, "string_value", zzhwVar.zzc() ? zzhwVar.zzd() : null);
                E(sb, i4, "int_value", zzhwVar.zze() ? Long.valueOf(zzhwVar.zzf()) : null);
                E(sb, i4, "double_value", zzhwVar.zzi() ? Double.valueOf(zzhwVar.zzj()) : null);
                if (zzhwVar.zzm() > 0) {
                    w(sb, i4, zzhwVar.zzk());
                }
                y(sb, i4);
                sb.append("}\n");
            }
        }
    }

    private final void x(StringBuilder sb, int i3, com.google.android.gms.internal.measurement.zzfh zzfhVar) {
        String str;
        if (zzfhVar == null) {
            return;
        }
        y(sb, i3);
        sb.append("filter {\n");
        if (zzfhVar.zze()) {
            E(sb, i3, "complement", Boolean.valueOf(zzfhVar.zzf()));
        }
        if (zzfhVar.zzg()) {
            E(sb, i3, "param_name", this.f73997a.D().b(zzfhVar.zzh()));
        }
        if (zzfhVar.zza()) {
            int i4 = i3 + 1;
            com.google.android.gms.internal.measurement.zzfr zzfrVarZzb = zzfhVar.zzb();
            if (zzfrVarZzb != null) {
                y(sb, i4);
                sb.append("string_filter {\n");
                if (zzfrVarZzb.zza()) {
                    switch (zzfrVarZzb.zzj()) {
                        case 1:
                            str = "UNKNOWN_MATCH_TYPE";
                            break;
                        case 2:
                            str = "REGEXP";
                            break;
                        case 3:
                            str = "BEGINS_WITH";
                            break;
                        case 4:
                            str = "ENDS_WITH";
                            break;
                        case 5:
                            str = "PARTIAL";
                            break;
                        case 6:
                            str = "EXACT";
                            break;
                        default:
                            str = "IN_LIST";
                            break;
                    }
                    E(sb, i4, "match_type", str);
                }
                if (zzfrVarZzb.zzb()) {
                    E(sb, i4, "expression", zzfrVarZzb.zzc());
                }
                if (zzfrVarZzb.zzd()) {
                    E(sb, i4, "case_sensitive", Boolean.valueOf(zzfrVarZzb.zze()));
                }
                if (zzfrVarZzb.zzg() > 0) {
                    y(sb, i3 + 2);
                    sb.append("expression_list {\n");
                    for (String str2 : zzfrVarZzb.zzf()) {
                        y(sb, i3 + 3);
                        sb.append(str2);
                        sb.append("\n");
                    }
                    sb.append("}\n");
                }
                y(sb, i4);
                sb.append("}\n");
            }
        }
        if (zzfhVar.zzc()) {
            F(sb, i3 + 1, "number_filter", zzfhVar.zzd());
        }
        y(sb, i3);
        sb.append("}\n");
    }

    private static final void y(StringBuilder sb, int i3) {
        for (int i4 = 0; i4 < i3; i4++) {
            sb.append("  ");
        }
    }

    private static final void z(Uri.Builder builder, String str, String str2, Set set) {
        if (set.contains(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        builder.appendQueryParameter(str, str2);
    }

    final void G(com.google.android.gms.internal.measurement.zzit zzitVar, Object obj) {
        Preconditions.m(obj);
        zzitVar.zzd();
        zzitVar.zzf();
        zzitVar.zzh();
        if (obj instanceof String) {
            zzitVar.zzc((String) obj);
            return;
        }
        if (obj instanceof Long) {
            zzitVar.zze(((Long) obj).longValue());
        } else if (obj instanceof Double) {
            zzitVar.zzg(((Double) obj).doubleValue());
        } else {
            this.f73997a.a().o().b("Ignoring invalid (type) user attribute value", obj);
        }
    }

    final void H(com.google.android.gms.internal.measurement.zzhv zzhvVar, Object obj) {
        Preconditions.m(obj);
        zzhvVar.zze();
        zzhvVar.zzg();
        zzhvVar.zzi();
        zzhvVar.zzm();
        if (obj instanceof String) {
            zzhvVar.zzd((String) obj);
            return;
        }
        if (obj instanceof Long) {
            zzhvVar.zzf(((Long) obj).longValue());
            return;
        }
        if (obj instanceof Double) {
            zzhvVar.zzh(((Double) obj).doubleValue());
            return;
        }
        if (!(obj instanceof Bundle[])) {
            this.f73997a.a().o().b("Ignoring invalid (type) event param value", obj);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (Bundle bundle : (Bundle[]) obj) {
            if (bundle != null) {
                com.google.android.gms.internal.measurement.zzhv zzhvVarZzn = com.google.android.gms.internal.measurement.zzhw.zzn();
                for (String str : bundle.keySet()) {
                    com.google.android.gms.internal.measurement.zzhv zzhvVarZzn2 = com.google.android.gms.internal.measurement.zzhw.zzn();
                    zzhvVarZzn2.zzb(str);
                    Object obj2 = bundle.get(str);
                    if (obj2 instanceof Long) {
                        zzhvVarZzn2.zzf(((Long) obj2).longValue());
                    } else if (obj2 instanceof String) {
                        zzhvVarZzn2.zzd((String) obj2);
                    } else if (obj2 instanceof Double) {
                        zzhvVarZzn2.zzh(((Double) obj2).doubleValue());
                    }
                    zzhvVarZzn.zzk(zzhvVarZzn2);
                }
                if (zzhvVarZzn.zzj() > 0) {
                    arrayList.add((com.google.android.gms.internal.measurement.zzhw) zzhvVarZzn.zzbc());
                }
            }
        }
        zzhvVar.zzl(arrayList);
    }

    final com.google.android.gms.internal.measurement.zzhs J(zzbb zzbbVar) {
        com.google.android.gms.internal.measurement.zzhr zzhrVarZzk = com.google.android.gms.internal.measurement.zzhs.zzk();
        zzhrVarZzk.zzq(zzbbVar.f73468e);
        zzbe zzbeVar = zzbbVar.f73469f;
        zzbd zzbdVar = new zzbd(zzbeVar);
        while (zzbdVar.hasNext()) {
            String next = zzbdVar.next();
            com.google.android.gms.internal.measurement.zzhv zzhvVarZzn = com.google.android.gms.internal.measurement.zzhw.zzn();
            zzhvVarZzn.zzb(next);
            Object objM = zzbeVar.M(next);
            Preconditions.m(objM);
            H(zzhvVarZzn, objM);
            zzhrVarZzk.zzg(zzhvVarZzn);
        }
        String str = zzbbVar.f73466c;
        if (!TextUtils.isEmpty(str) && zzbeVar.M("_o") == null) {
            com.google.android.gms.internal.measurement.zzhv zzhvVarZzn2 = com.google.android.gms.internal.measurement.zzhw.zzn();
            zzhvVarZzn2.zzb("_o");
            zzhvVarZzn2.zzd(str);
            zzhrVarZzk.zzf((com.google.android.gms.internal.measurement.zzhw) zzhvVarZzn2.zzbc());
        }
        return (com.google.android.gms.internal.measurement.zzhs) zzhrVarZzk.zzbc();
    }

    final String K(com.google.android.gms.internal.measurement.zzib zzibVar) {
        com.google.android.gms.internal.measurement.zzhe zzheVarZzat;
        if (zzibVar == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("\nbatch {\n");
        if (zzibVar.zzf()) {
            E(sb, 0, "upload_subdomain", zzibVar.zzg());
        }
        if (zzibVar.zzd()) {
            E(sb, 0, "sgtm_join_id", zzibVar.zze());
        }
        for (com.google.android.gms.internal.measurement.zzid zzidVar : zzibVar.zza()) {
            if (zzidVar != null) {
                y(sb, 1);
                sb.append("bundle {\n");
                if (zzidVar.zza()) {
                    E(sb, 1, "protocol_version", Integer.valueOf(zzidVar.zzb()));
                }
                zzrb.zza();
                zzic zzicVar = this.f73997a;
                if (zzicVar.w().H(zzidVar.zzA(), zzfy.N0) && zzidVar.zzag()) {
                    E(sb, 1, "session_stitching_token", zzidVar.zzah());
                }
                E(sb, 1, "platform", zzidVar.zzt());
                if (zzidVar.zzC()) {
                    E(sb, 1, "gmp_version", Long.valueOf(zzidVar.zzD()));
                }
                if (zzidVar.zzE()) {
                    E(sb, 1, "uploading_gmp_version", Long.valueOf(zzidVar.zzF()));
                }
                if (zzidVar.zzac()) {
                    E(sb, 1, "dynamite_version", Long.valueOf(zzidVar.zzad()));
                }
                if (zzidVar.zzW()) {
                    E(sb, 1, "config_version", Long.valueOf(zzidVar.zzX()));
                }
                E(sb, 1, "gmp_app_id", zzidVar.zzP());
                E(sb, 1, "app_id", zzidVar.zzA());
                E(sb, 1, "app_version", zzidVar.zzB());
                if (zzidVar.zzU()) {
                    E(sb, 1, "app_version_major", Integer.valueOf(zzidVar.zzV()));
                }
                E(sb, 1, "firebase_instance_id", zzidVar.zzT());
                if (zzidVar.zzK()) {
                    E(sb, 1, "dev_cert_hash", Long.valueOf(zzidVar.zzL()));
                }
                E(sb, 1, "app_store", zzidVar.zzz());
                if (zzidVar.zzi()) {
                    E(sb, 1, "upload_timestamp_millis", Long.valueOf(zzidVar.zzj()));
                }
                if (zzidVar.zzk()) {
                    E(sb, 1, "start_timestamp_millis", Long.valueOf(zzidVar.zzm()));
                }
                if (zzidVar.zzn()) {
                    E(sb, 1, "end_timestamp_millis", Long.valueOf(zzidVar.zzo()));
                }
                if (zzidVar.zzp()) {
                    E(sb, 1, "previous_bundle_start_timestamp_millis", Long.valueOf(zzidVar.zzq()));
                }
                if (zzidVar.zzr()) {
                    E(sb, 1, "previous_bundle_end_timestamp_millis", Long.valueOf(zzidVar.zzs()));
                }
                E(sb, 1, "app_instance_id", zzidVar.zzJ());
                E(sb, 1, "resettable_device_id", zzidVar.zzG());
                E(sb, 1, "ds_id", zzidVar.zzZ());
                if (zzidVar.zzH()) {
                    E(sb, 1, "limited_ad_tracking", Boolean.valueOf(zzidVar.zzI()));
                }
                E(sb, 1, "os_version", zzidVar.zzu());
                E(sb, 1, "device_model", zzidVar.zzv());
                E(sb, 1, "user_default_language", zzidVar.zzw());
                if (zzidVar.zzx()) {
                    E(sb, 1, "time_zone_offset_minutes", Integer.valueOf(zzidVar.zzy()));
                }
                if (zzidVar.zzM()) {
                    E(sb, 1, "bundle_sequential_index", Integer.valueOf(zzidVar.zzN()));
                }
                if (zzidVar.zzau()) {
                    E(sb, 1, "delivery_index", Integer.valueOf(zzidVar.zzav()));
                }
                if (zzidVar.zzQ()) {
                    E(sb, 1, "service_upload", Boolean.valueOf(zzidVar.zzR()));
                }
                E(sb, 1, "health_monitor", zzidVar.zzO());
                if (zzidVar.zzaa()) {
                    E(sb, 1, "retry_counter", Integer.valueOf(zzidVar.zzab()));
                }
                if (zzidVar.zzae()) {
                    E(sb, 1, "consent_signals", zzidVar.zzaf());
                }
                if (zzidVar.zzan()) {
                    E(sb, 1, "is_dma_region", Boolean.valueOf(zzidVar.zzao()));
                }
                if (zzidVar.zzap()) {
                    E(sb, 1, "core_platform_services", zzidVar.zzaq());
                }
                if (zzidVar.zzal()) {
                    E(sb, 1, "consent_diagnostics", zzidVar.zzam());
                }
                if (zzidVar.zzai()) {
                    E(sb, 1, "target_os_version", Long.valueOf(zzidVar.zzaj()));
                }
                zzqp.zza();
                if (zzicVar.w().H(zzidVar.zzA(), zzfy.Q0)) {
                    E(sb, 1, "ad_services_version", Integer.valueOf(zzidVar.zzar()));
                    if (zzidVar.zzas() && (zzheVarZzat = zzidVar.zzat()) != null) {
                        y(sb, 2);
                        sb.append("attribution_eligibility_status {\n");
                        E(sb, 2, "eligible", Boolean.valueOf(zzheVarZzat.zza()));
                        E(sb, 2, "no_access_adservices_attribution_permission", Boolean.valueOf(zzheVarZzat.zzb()));
                        E(sb, 2, "pre_r", Boolean.valueOf(zzheVarZzat.zzc()));
                        E(sb, 2, "r_extensions_too_old", Boolean.valueOf(zzheVarZzat.zzd()));
                        E(sb, 2, "adservices_extension_too_old", Boolean.valueOf(zzheVarZzat.zze()));
                        E(sb, 2, "ad_storage_not_allowed", Boolean.valueOf(zzheVarZzat.zzf()));
                        E(sb, 2, "measurement_manager_disabled", Boolean.valueOf(zzheVarZzat.zzg()));
                        y(sb, 2);
                        sb.append("}\n");
                    }
                }
                if (zzidVar.zzaw()) {
                    com.google.android.gms.internal.measurement.zzha zzhaVarZzax = zzidVar.zzax();
                    y(sb, 2);
                    sb.append("ad_campaign_info {\n");
                    if (zzhaVarZzax.zza()) {
                        E(sb, 2, "deep_link_gclid", zzhaVarZzax.zzb());
                    }
                    if (zzhaVarZzax.zzc()) {
                        E(sb, 2, "deep_link_gbraid", zzhaVarZzax.zzd());
                    }
                    if (zzhaVarZzax.zze()) {
                        E(sb, 2, "deep_link_gad_source", zzhaVarZzax.zzf());
                    }
                    if (zzhaVarZzax.zzg()) {
                        E(sb, 2, "deep_link_session_millis", Long.valueOf(zzhaVarZzax.zzh()));
                    }
                    if (zzhaVarZzax.zzi()) {
                        E(sb, 2, "market_referrer_gclid", zzhaVarZzax.zzj());
                    }
                    if (zzhaVarZzax.zzk()) {
                        E(sb, 2, "market_referrer_gbraid", zzhaVarZzax.zzm());
                    }
                    if (zzhaVarZzax.zzn()) {
                        E(sb, 2, "market_referrer_gad_source", zzhaVarZzax.zzo());
                    }
                    if (zzhaVarZzax.zzp()) {
                        E(sb, 2, "market_referrer_click_millis", Long.valueOf(zzhaVarZzax.zzq()));
                    }
                    y(sb, 2);
                    sb.append("}\n");
                }
                if (zzidVar.zzaA()) {
                    E(sb, 1, "batching_timestamp_millis", Long.valueOf(zzidVar.zzaB()));
                }
                if (zzidVar.zzay()) {
                    com.google.android.gms.internal.measurement.zzis zzisVarZzaz = zzidVar.zzaz();
                    y(sb, 2);
                    sb.append("sgtm_diagnostics {\n");
                    int iZzf = zzisVarZzaz.zzf();
                    E(sb, 2, "upload_type", iZzf != 1 ? iZzf != 2 ? iZzf != 3 ? iZzf != 4 ? "SDK_SERVICE_UPLOAD" : "PACKAGE_SERVICE_UPLOAD" : "SDK_CLIENT_UPLOAD" : "GA_UPLOAD" : "UPLOAD_TYPE_UNKNOWN");
                    E(sb, 2, "client_upload_eligibility", zzisVarZzaz.zza().name());
                    int iZzg = zzisVarZzaz.zzg();
                    E(sb, 2, "service_upload_eligibility", iZzg != 1 ? iZzg != 2 ? iZzg != 3 ? iZzg != 4 ? iZzg != 5 ? "NON_PLAY_MISSING_SGTM_SERVER_URL" : "MISSING_SGTM_PROXY_INFO" : "MISSING_SGTM_SETTINGS" : "NOT_IN_ROLLOUT" : "SERVICE_UPLOAD_ELIGIBLE" : "SERVICE_UPLOAD_ELIGIBILITY_UNKNOWN");
                    y(sb, 2);
                    sb.append("}\n");
                }
                if (zzidVar.zzaC()) {
                    com.google.android.gms.internal.measurement.zzho zzhoVarZzaD = zzidVar.zzaD();
                    y(sb, 2);
                    sb.append("consent_info_extra {\n");
                    for (com.google.android.gms.internal.measurement.zzhl zzhlVar : zzhoVarZzaD.zza()) {
                        y(sb, 3);
                        sb.append("limited_data_modes {\n");
                        int iZzc = zzhlVar.zzc();
                        E(sb, 3, "type", iZzc != 1 ? iZzc != 2 ? iZzc != 3 ? iZzc != 4 ? "AD_PERSONALIZATION" : "AD_USER_DATA" : "ANALYTICS_STORAGE" : "AD_STORAGE" : "CONSENT_TYPE_UNSPECIFIED");
                        int iZzd = zzhlVar.zzd();
                        E(sb, 3, "mode", iZzd != 1 ? iZzd != 2 ? "NO_DATA_MODE" : "LIMITED_MODE" : "NOT_LIMITED");
                        y(sb, 3);
                        sb.append("}\n");
                    }
                    y(sb, 2);
                    sb.append("}\n");
                }
                List<com.google.android.gms.internal.measurement.zziu> listZzf = zzidVar.zzf();
                if (listZzf != null) {
                    for (com.google.android.gms.internal.measurement.zziu zziuVar : listZzf) {
                        if (zziuVar != null) {
                            y(sb, 2);
                            sb.append("user_property {\n");
                            E(sb, 2, "set_timestamp_millis", zziuVar.zza() ? Long.valueOf(zziuVar.zzb()) : null);
                            E(sb, 2, "name", zzicVar.D().c(zziuVar.zzc()));
                            E(sb, 2, "string_value", zziuVar.zze());
                            E(sb, 2, "int_value", zziuVar.zzf() ? Long.valueOf(zziuVar.zzg()) : null);
                            E(sb, 2, "double_value", zziuVar.zzj() ? Double.valueOf(zziuVar.zzk()) : null);
                            y(sb, 2);
                            sb.append("}\n");
                        }
                    }
                }
                List<com.google.android.gms.internal.measurement.zzhg> listZzS = zzidVar.zzS();
                if (listZzS != null) {
                    for (com.google.android.gms.internal.measurement.zzhg zzhgVar : listZzS) {
                        if (zzhgVar != null) {
                            y(sb, 2);
                            sb.append("audience_membership {\n");
                            if (zzhgVar.zza()) {
                                E(sb, 2, "audience_id", Integer.valueOf(zzhgVar.zzb()));
                            }
                            if (zzhgVar.zzf()) {
                                E(sb, 2, "new_audience", Boolean.valueOf(zzhgVar.zzg()));
                            }
                            D(sb, 2, "current_data", zzhgVar.zzc());
                            if (zzhgVar.zzd()) {
                                D(sb, 2, "previous_data", zzhgVar.zze());
                            }
                            y(sb, 2);
                            sb.append("}\n");
                        }
                    }
                }
                List<com.google.android.gms.internal.measurement.zzhs> listZzc = zzidVar.zzc();
                if (listZzc != null) {
                    for (com.google.android.gms.internal.measurement.zzhs zzhsVar : listZzc) {
                        if (zzhsVar != null) {
                            y(sb, 2);
                            sb.append("event {\n");
                            E(sb, 2, "name", zzicVar.D().a(zzhsVar.zzd()));
                            if (zzhsVar.zze()) {
                                E(sb, 2, "timestamp_millis", Long.valueOf(zzhsVar.zzf()));
                            }
                            if (zzhsVar.zzg()) {
                                E(sb, 2, "previous_timestamp_millis", Long.valueOf(zzhsVar.zzh()));
                            }
                            if (zzhsVar.zzi()) {
                                E(sb, 2, "count", Integer.valueOf(zzhsVar.zzj()));
                            }
                            if (zzhsVar.zzb() != 0) {
                                w(sb, 2, zzhsVar.zza());
                            }
                            y(sb, 2);
                            sb.append("}\n");
                        }
                    }
                }
                y(sb, 1);
                sb.append("}\n");
            }
        }
        sb.append("} // End-of-batch\n");
        return sb.toString();
    }

    final String L(com.google.android.gms.internal.measurement.zzff zzffVar) {
        if (zzffVar == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("\nevent_filter {\n");
        if (zzffVar.zza()) {
            E(sb, 0, "filter_id", Integer.valueOf(zzffVar.zzb()));
        }
        E(sb, 0, "event_name", this.f73997a.D().a(zzffVar.zzc()));
        String strA = A(zzffVar.zzi(), zzffVar.zzj(), zzffVar.zzm());
        if (!strA.isEmpty()) {
            E(sb, 0, "filter_type", strA);
        }
        if (zzffVar.zzg()) {
            F(sb, 1, "event_count_filter", zzffVar.zzh());
        }
        if (zzffVar.zze() > 0) {
            sb.append("  filters {\n");
            Iterator it = zzffVar.zzd().iterator();
            while (it.hasNext()) {
                x(sb, 2, (com.google.android.gms.internal.measurement.zzfh) it.next());
            }
        }
        y(sb, 1);
        sb.append("}\n}\n");
        return sb.toString();
    }

    final String M(com.google.android.gms.internal.measurement.zzfn zzfnVar) {
        if (zzfnVar == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("\nproperty_filter {\n");
        if (zzfnVar.zza()) {
            E(sb, 0, "filter_id", Integer.valueOf(zzfnVar.zzb()));
        }
        E(sb, 0, "property_name", this.f73997a.D().c(zzfnVar.zzc()));
        String strA = A(zzfnVar.zze(), zzfnVar.zzf(), zzfnVar.zzh());
        if (!strA.isEmpty()) {
            E(sb, 0, "filter_type", strA);
        }
        x(sb, 1, zzfnVar.zzd());
        sb.append("}\n");
        return sb.toString();
    }

    final Parcelable N(byte[] bArr, Parcelable.Creator creator) {
        Parcelable parcelable = null;
        if (bArr == null) {
            return null;
        }
        Parcel parcelObtain = Parcel.obtain();
        try {
            try {
                parcelObtain.unmarshall(bArr, 0, bArr.length);
                parcelObtain.setDataPosition(0);
                parcelable = (Parcelable) creator.createFromParcel(parcelObtain);
            } catch (SafeParcelReader.ParseException unused) {
                this.f73997a.a().o().a("Failed to load parcelable from buffer");
            }
            return parcelable;
        } finally {
            parcelObtain.recycle();
        }
    }

    final List R(List list, List list2) {
        int i3;
        ArrayList arrayList = new ArrayList(list);
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            Integer num = (Integer) it.next();
            if (num.intValue() < 0) {
                this.f73997a.a().r().b("Ignoring negative bit index to be cleared", num);
            } else {
                int iIntValue = num.intValue() / 64;
                if (iIntValue >= arrayList.size()) {
                    this.f73997a.a().r().c("Ignoring bit index greater than bitSet size", num, Integer.valueOf(arrayList.size()));
                } else {
                    arrayList.set(iIntValue, Long.valueOf(((Long) arrayList.get(iIntValue)).longValue() & (~(1 << (num.intValue() % 64)))));
                }
            }
        }
        int size = arrayList.size();
        int size2 = arrayList.size() - 1;
        while (true) {
            int i4 = size2;
            i3 = size;
            size = i4;
            if (size < 0 || ((Long) arrayList.get(size)).longValue() != 0) {
                break;
            }
            size2 = size - 1;
        }
        return arrayList.subList(0, i3);
    }

    final boolean S(long j3, long j4) {
        return j3 == 0 || j4 <= 0 || Math.abs(this.f73997a.e().currentTimeMillis() - j3) > j4;
    }

    final long T(byte[] bArr) {
        Preconditions.m(bArr);
        zzic zzicVar = this.f73997a;
        zzicVar.C().h();
        MessageDigest messageDigestC = zzpp.C();
        if (messageDigestC != null) {
            return zzpp.D(messageDigestC.digest(bArr));
        }
        zzicVar.a().o().a("Failed to get MD5");
        return 0L;
    }

    final long U(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0L;
        }
        return T(str.getBytes(Charset.forName(Utf8Charset.NAME)));
    }

    final byte[] V(byte[] bArr) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
            byteArrayOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e3) {
            this.f73997a.a().o().b("Failed to gzip content", e3);
            throw e3;
        }
    }

    final Map Z(Bundle bundle, boolean z2) {
        HashMap map = new HashMap();
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            boolean z3 = obj instanceof Parcelable[];
            if (z3 || (obj instanceof ArrayList) || (obj instanceof Bundle)) {
                if (z2) {
                    ArrayList arrayList = new ArrayList();
                    if (z3) {
                        for (Parcelable parcelable : (Parcelable[]) obj) {
                            if (parcelable instanceof Bundle) {
                                arrayList.add(Z((Bundle) parcelable, false));
                            }
                        }
                    } else if (obj instanceof ArrayList) {
                        ArrayList arrayList2 = (ArrayList) obj;
                        int size = arrayList2.size();
                        for (int i3 = 0; i3 < size; i3++) {
                            Object obj2 = arrayList2.get(i3);
                            if (obj2 instanceof Bundle) {
                                arrayList.add(Z((Bundle) obj2, false));
                            }
                        }
                    } else if (obj instanceof Bundle) {
                        arrayList.add(Z((Bundle) obj, false));
                    }
                    map.put(str, arrayList);
                }
            } else if (obj != null) {
                map.put(str, obj);
            }
        }
        return map;
    }

    @Override // com.google.android.gms.measurement.internal.zzos
    protected final boolean l() {
        return false;
    }

    final zzbg m(com.google.android.gms.internal.measurement.zzaa zzaaVar) {
        Object obj;
        Bundle bundleN = n(zzaaVar.zzf(), true);
        String string = (!bundleN.containsKey("_o") || (obj = bundleN.get("_o")) == null) ? "app" : obj.toString();
        String strB = zzjm.b(zzaaVar.zzb());
        if (strB == null) {
            strB = zzaaVar.zzb();
        }
        return new zzbg(strB, new zzbe(bundleN), string, zzaaVar.zza());
    }

    final Bundle n(Map map, boolean z2) {
        Bundle bundle = new Bundle();
        for (String str : map.keySet()) {
            Object obj = map.get(str);
            if (obj == null) {
                bundle.putString(str, null);
            } else if (obj instanceof Long) {
                bundle.putLong(str, ((Long) obj).longValue());
            } else if (obj instanceof Double) {
                bundle.putDouble(str, ((Double) obj).doubleValue());
            } else if (!(obj instanceof ArrayList)) {
                bundle.putString(str, obj.toString());
            } else if (z2) {
                ArrayList arrayList = (ArrayList) obj;
                ArrayList arrayList2 = new ArrayList();
                int size = arrayList.size();
                for (int i3 = 0; i3 < size; i3++) {
                    arrayList2.add(n((Map) arrayList.get(i3), false));
                }
                bundle.putParcelableArray(str, (Parcelable[]) arrayList2.toArray(new Parcelable[0]));
            }
        }
        return bundle;
    }

    final zzoh I(String str, com.google.android.gms.internal.measurement.zzic zzicVar, com.google.android.gms.internal.measurement.zzhr zzhrVar, String str2) {
        int iIndexOf;
        zzqp.zza();
        zzic zzicVar2 = this.f73997a;
        if (!zzicVar2.w().H(str, zzfy.Q0)) {
            return null;
        }
        long jCurrentTimeMillis = zzicVar2.e().currentTimeMillis();
        Set setA = g.a(zzicVar2.w().C(str, zzfy.f73674v0).split(","));
        zzpg zzpgVar = this.f74388b;
        zzou zzouVarC0 = zzpgVar.C0();
        String strX = zzouVarC0.f74388b.D0().x(str);
        Uri.Builder builder = new Uri.Builder();
        zzic zzicVar3 = zzouVarC0.f73997a;
        builder.scheme(zzicVar3.w().C(str, zzfy.f73660o0));
        if (TextUtils.isEmpty(strX)) {
            builder.authority(zzicVar3.w().C(str, zzfy.f73662p0));
        } else {
            String strC = zzicVar3.w().C(str, zzfy.f73662p0);
            StringBuilder sb = new StringBuilder(String.valueOf(strX).length() + 1 + String.valueOf(strC).length());
            sb.append(strX);
            sb.append(".");
            sb.append(strC);
            builder.authority(sb.toString());
        }
        builder.path(zzicVar3.w().C(str, zzfy.f73664q0));
        z(builder, bfIdKSjLOVjG.rcasEQgnZDL, zzicVar.zzac(), setA);
        zzicVar2.w().A();
        z(builder, "gmp_version", String.valueOf(133005L), setA);
        String strZzV = zzicVar.zzV();
        zzal zzalVarW = zzicVar2.w();
        zzfx zzfxVar = zzfy.T0;
        if (zzalVarW.H(str, zzfxVar) && zzpgVar.D0().N(str)) {
            strZzV = "";
        }
        z(builder, "app_instance_id", strZzV, setA);
        z(builder, "rdid", zzicVar.zzP(), setA);
        z(builder, "bundle_id", zzicVar.zzK(), setA);
        String strZzk = zzhrVar.zzk();
        String strA = zzjm.a(strZzk);
        if (true != TextUtils.isEmpty(strA)) {
            strZzk = strA;
        }
        z(builder, "app_event_name", strZzk, setA);
        z(builder, "app_version", String.valueOf(zzicVar.zzai()), setA);
        String strZzD = zzicVar.zzD();
        if (zzicVar2.w().H(str, zzfxVar) && zzpgVar.D0().K(str) && !TextUtils.isEmpty(strZzD) && (iIndexOf = strZzD.indexOf(".")) != -1) {
            strZzD = strZzD.substring(0, iIndexOf);
        }
        z(builder, "os_version", strZzD, setA);
        z(builder, "timestamp", String.valueOf(zzhrVar.zzn()), setA);
        boolean zZzS = zzicVar.zzS();
        String str3 = AppEventsConstants.EVENT_PARAM_VALUE_YES;
        if (zZzS) {
            z(builder, "lat", AppEventsConstants.EVENT_PARAM_VALUE_YES, setA);
        }
        z(builder, "privacy_sandbox_version", String.valueOf(zzicVar.zzaG()), setA);
        z(builder, "trigger_uri_source", AppEventsConstants.EVENT_PARAM_VALUE_YES, setA);
        z(builder, "trigger_uri_timestamp", String.valueOf(jCurrentTimeMillis), setA);
        z(builder, "request_uuid", str2, setA);
        List<com.google.android.gms.internal.measurement.zzhw> listZza = zzhrVar.zza();
        Bundle bundle = new Bundle();
        for (com.google.android.gms.internal.measurement.zzhw zzhwVar : listZza) {
            String strZzb = zzhwVar.zzb();
            if (zzhwVar.zzi()) {
                bundle.putString(strZzb, String.valueOf(zzhwVar.zzj()));
            } else if (zzhwVar.zzg()) {
                bundle.putString(strZzb, String.valueOf(zzhwVar.zzh()));
            } else if (zzhwVar.zzc()) {
                bundle.putString(strZzb, zzhwVar.zzd());
            } else if (zzhwVar.zze()) {
                bundle.putString(strZzb, String.valueOf(zzhwVar.zzf()));
            }
        }
        C(builder, zzicVar2.w().C(str, zzfy.f73672u0).split("\\|"), bundle, setA);
        List<com.google.android.gms.internal.measurement.zziu> listZzk = zzicVar.zzk();
        Bundle bundle2 = new Bundle();
        for (com.google.android.gms.internal.measurement.zziu zziuVar : listZzk) {
            String strZzc = zziuVar.zzc();
            if (zziuVar.zzj()) {
                bundle2.putString(strZzc, String.valueOf(zziuVar.zzk()));
            } else if (zziuVar.zzh()) {
                bundle2.putString(strZzc, String.valueOf(zziuVar.zzi()));
            } else if (zziuVar.zzd()) {
                bundle2.putString(strZzc, zziuVar.zze());
            } else if (zziuVar.zzf()) {
                bundle2.putString(strZzc, String.valueOf(zziuVar.zzg()));
            }
        }
        C(builder, zzicVar2.w().C(str, zzfy.f73670t0).split("\\|"), bundle2, setA);
        if (true != zzicVar.zzaC()) {
            str3 = AppEventsConstants.EVENT_PARAM_VALUE_NO;
        }
        z(builder, "dma", str3, setA);
        if (!zzicVar.zzaE().isEmpty()) {
            z(builder, "dma_cps", zzicVar.zzaE(), setA);
        }
        if (zzicVar.zzaK()) {
            com.google.android.gms.internal.measurement.zzha zzhaVarZzaL = zzicVar.zzaL();
            if (!zzhaVarZzaL.zzb().isEmpty()) {
                z(builder, "dl_gclid", zzhaVarZzaL.zzb(), setA);
            }
            if (!zzhaVarZzaL.zzd().isEmpty()) {
                z(builder, "dl_gbraid", zzhaVarZzaL.zzd(), setA);
            }
            if (!zzhaVarZzaL.zzf().isEmpty()) {
                z(builder, "dl_gs", zzhaVarZzaL.zzf(), setA);
            }
            if (zzhaVarZzaL.zzh() > 0) {
                z(builder, "dl_ss_ts", String.valueOf(zzhaVarZzaL.zzh()), setA);
            }
            if (!zzhaVarZzaL.zzj().isEmpty()) {
                z(builder, "mr_gclid", zzhaVarZzaL.zzj(), setA);
            }
            if (!zzhaVarZzaL.zzm().isEmpty()) {
                z(builder, "mr_gbraid", zzhaVarZzaL.zzm(), setA);
            }
            if (!zzhaVarZzaL.zzo().isEmpty()) {
                z(builder, "mr_gs", zzhaVarZzaL.zzo(), setA);
            }
            if (zzhaVarZzaL.zzq() > 0) {
                z(builder, "mr_click_ts", String.valueOf(zzhaVarZzaL.zzq()), setA);
            }
        }
        return new zzoh(builder.build().toString(), jCurrentTimeMillis, 1);
    }
}
