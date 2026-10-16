package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.PatternSyntaxException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
abstract class zzab {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final String f73370a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final int f73371b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Boolean f73372c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    Boolean f73373d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    Long f73374e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    Long f73375f;

    zzab(String str, int i3) {
        this.f73370a = str;
        this.f73371b = i3;
    }

    private static Boolean d(String str, int i3, boolean z2, String str2, List list, String str3, zzgu zzguVar) {
        if (i3 == 7) {
            if (list == null || list.isEmpty()) {
                return null;
            }
        } else if (str2 == null) {
            return null;
        }
        if (!z2 && i3 != 2) {
            str = str.toUpperCase(Locale.ENGLISH);
        }
        switch (i3 - 1) {
            case 1:
                if (str3 != null) {
                    try {
                    } catch (PatternSyntaxException unused) {
                        if (zzguVar != null) {
                            zzguVar.r().b("Invalid regular expression in REGEXP audience filter. expression", str3);
                        }
                        return null;
                    }
                    break;
                }
                break;
            case 6:
                if (list != null) {
                    break;
                }
                break;
        }
        return null;
    }

    static Boolean e(Boolean bool, boolean z2) {
        if (bool == null) {
            return null;
        }
        return Boolean.valueOf(bool.booleanValue() != z2);
    }

    static Boolean f(String str, com.google.android.gms.internal.measurement.zzfr zzfrVar, zzgu zzguVar) {
        List list;
        Preconditions.m(zzfrVar);
        if (str == null || !zzfrVar.zza() || zzfrVar.zzj() == 1 || (zzfrVar.zzj() != 7 ? !zzfrVar.zzb() : zzfrVar.zzg() == 0)) {
            return null;
        }
        int iZzj = zzfrVar.zzj();
        boolean zZze = zzfrVar.zze();
        String strZzc = (zZze || iZzj == 2 || iZzj == 7) ? zzfrVar.zzc() : zzfrVar.zzc().toUpperCase(Locale.ENGLISH);
        if (zzfrVar.zzg() == 0) {
            list = null;
        } else {
            List listZzf = zzfrVar.zzf();
            if (!zZze) {
                ArrayList arrayList = new ArrayList(listZzf.size());
                Iterator it = listZzf.iterator();
                while (it.hasNext()) {
                    arrayList.add(((String) it.next()).toUpperCase(Locale.ENGLISH));
                }
                listZzf = Collections.unmodifiableList(arrayList);
            }
            list = listZzf;
        }
        return d(str, iZzj, zZze, strZzc, list, iZzj == 2 ? strZzc : null, zzguVar);
    }

    static Boolean g(long j3, com.google.android.gms.internal.measurement.zzfl zzflVar) {
        try {
            return j(new BigDecimal(j3), zzflVar, 0.0d);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    static Boolean h(double d3, com.google.android.gms.internal.measurement.zzfl zzflVar) {
        try {
            return j(new BigDecimal(d3), zzflVar, Math.ulp(d3));
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    static Boolean i(String str, com.google.android.gms.internal.measurement.zzfl zzflVar) {
        if (!zzpk.O(str)) {
            return null;
        }
        try {
            return j(new BigDecimal(str), zzflVar, 0.0d);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    static Boolean j(BigDecimal bigDecimal, com.google.android.gms.internal.measurement.zzfl zzflVar, double d3) {
        BigDecimal bigDecimal2;
        BigDecimal bigDecimal3;
        BigDecimal bigDecimal4;
        Preconditions.m(zzflVar);
        if (zzflVar.zza()) {
            if (zzflVar.zzm() != 1) {
                if (zzflVar.zzm() == 5) {
                    if (!zzflVar.zzf() || !zzflVar.zzh()) {
                        return null;
                    }
                } else if (!zzflVar.zzd()) {
                    return null;
                }
                int iZzm = zzflVar.zzm();
                if (zzflVar.zzm() == 5) {
                    if (zzpk.O(zzflVar.zzg()) && zzpk.O(zzflVar.zzi())) {
                        try {
                            BigDecimal bigDecimal5 = new BigDecimal(zzflVar.zzg());
                            bigDecimal4 = new BigDecimal(zzflVar.zzi());
                            bigDecimal3 = bigDecimal5;
                            bigDecimal2 = null;
                        } catch (NumberFormatException unused) {
                        }
                    }
                    return null;
                }
                if (!zzpk.O(zzflVar.zze())) {
                    return null;
                }
                try {
                    bigDecimal2 = new BigDecimal(zzflVar.zze());
                    bigDecimal3 = null;
                    bigDecimal4 = null;
                } catch (NumberFormatException unused2) {
                }
                if (iZzm == 5) {
                    if (bigDecimal3 == null) {
                        return null;
                    }
                } else if (bigDecimal2 == null) {
                    return null;
                }
                int i3 = iZzm - 1;
                if (i3 == 1) {
                    if (bigDecimal2 == null) {
                        return null;
                    }
                    return Boolean.valueOf(bigDecimal.compareTo(bigDecimal2) < 0);
                }
                if (i3 == 2) {
                    if (bigDecimal2 == null) {
                        return null;
                    }
                    return Boolean.valueOf(bigDecimal.compareTo(bigDecimal2) > 0);
                }
                if (i3 != 3) {
                    if (i3 == 4 && bigDecimal3 != null) {
                        return Boolean.valueOf(bigDecimal.compareTo(bigDecimal3) >= 0 && bigDecimal.compareTo(bigDecimal4) <= 0);
                    }
                    return null;
                }
                if (bigDecimal2 == null) {
                    return null;
                }
                if (d3 != 0.0d) {
                    return Boolean.valueOf(bigDecimal.compareTo(bigDecimal2.subtract(new BigDecimal(d3).multiply(new BigDecimal(2)))) > 0 && bigDecimal.compareTo(bigDecimal2.add(new BigDecimal(d3).multiply(new BigDecimal(2)))) < 0);
                }
                return Boolean.valueOf(bigDecimal.compareTo(bigDecimal2) == 0);
            }
        }
        return null;
    }

    abstract int a();

    abstract boolean b();

    abstract boolean c();
}
