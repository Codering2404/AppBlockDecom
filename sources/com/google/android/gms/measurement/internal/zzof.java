package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.stetho.inspector.helper.qp.sKeKFMqmvNzY;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzof {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final ImmutableList f74378a = ImmutableList.I("Version", "GoogleConsent", "VendorConsent", "VendorLegitimateInterest", "gdprApplies", "EnableAdvertiserConsentMode", "PolicyVersion", "PurposeConsents", "PurposeOneTreatment", "Purpose1", "Purpose3", sKeKFMqmvNzY.LhEo, "Purpose7", "CmpSdkID", "PublisherCC", "PublisherRestrictions1", "PublisherRestrictions3", "PublisherRestrictions4", "PublisherRestrictions7", "AuthorizePurpose1", "AuthorizePurpose3", "AuthorizePurpose4", "AuthorizePurpose7", "PurposeDiagnostics");

    static String a(SharedPreferences sharedPreferences, String str) {
        try {
            return sharedPreferences.getString(str, "");
        } catch (ClassCastException unused) {
            return "";
        }
    }

    static int b(SharedPreferences sharedPreferences, String str) {
        try {
            return sharedPreferences.getInt(str, -1);
        } catch (ClassCastException unused) {
            return -1;
        }
    }

    static final boolean c(com.google.android.gms.internal.measurement.zzkp zzkpVar, ImmutableMap immutableMap, ImmutableMap immutableMap2, ImmutableSet immutableSet, char[] cArr, int i3, int i4, int i5, int i6, int i7, String str, String str2, String str3, boolean z2, boolean z3, boolean z4) {
        int i8;
        int i9;
        ImmutableSet immutableSet2;
        String str4;
        zzoe zzoeVar;
        char c3;
        int iE = e(zzkpVar, immutableMap, immutableMap2, immutableSet, cArr, i3, i4, i5, i6, i7, str, str2, str3, z2, z3, true);
        if (iE > 0) {
            i9 = i5;
            if (i9 == 1) {
                i8 = i4;
                if (i8 != 1) {
                    i9 = 1;
                } else {
                    i8 = 1;
                    i9 = 1;
                }
            } else {
                i8 = i4;
            }
            cArr[iE] = '2';
        } else {
            i8 = i4;
            i9 = i5;
        }
        if (i(zzkpVar, immutableMap, immutableMap2, immutableSet, cArr, i3, i8, i9, i6, i7, str, str2, str3, z2, z3, true) == com.google.android.gms.internal.measurement.zzkq.PURPOSE_RESTRICTION_NOT_ALLOWED) {
            c3 = '3';
        } else {
            int i10 = i7;
            if (zzkpVar == com.google.android.gms.internal.measurement.zzkp.IAB_TCF_PURPOSE_STORE_AND_ACCESS_INFORMATION_ON_A_DEVICE) {
                immutableSet2 = immutableSet;
                str4 = str;
                if (i10 == 1) {
                    if (immutableSet2.contains(str4)) {
                        if (iE > 0 && cArr[iE] != '2') {
                            cArr[iE] = '1';
                        }
                        return true;
                    }
                    i10 = 1;
                }
            } else {
                immutableSet2 = immutableSet;
                str4 = str;
            }
            if (immutableMap.containsKey(zzkpVar) && (zzoeVar = (zzoe) immutableMap.get(zzkpVar)) != null) {
                int iOrdinal = zzoeVar.ordinal();
                if (iOrdinal != 0) {
                    if (iOrdinal != 1) {
                        if (iOrdinal == 2) {
                            return i(zzkpVar, immutableMap, immutableMap2, immutableSet, cArr, i3, i8, i9, i6, i10, str, str2, str3, z2, z3, true) == com.google.android.gms.internal.measurement.zzkq.PURPOSE_RESTRICTION_REQUIRE_LEGITIMATE_INTEREST ? h(zzkpVar, immutableMap, immutableMap2, immutableSet, cArr, i3, i8, i9, i6, i10, str, str2, str3, z2, z3, true) : g(zzkpVar, immutableMap, immutableMap2, immutableSet, cArr, i3, i8, i9, i6, i10, str, str2, str3, z2, z3, true);
                        }
                        if (iOrdinal == 3) {
                            return i(zzkpVar, immutableMap, immutableMap2, immutableSet2, cArr, i3, i8, i9, i6, i10, str4, str2, str3, z2, z3, true) == com.google.android.gms.internal.measurement.zzkq.PURPOSE_RESTRICTION_REQUIRE_CONSENT ? g(zzkpVar, immutableMap, immutableMap2, immutableSet, cArr, i3, i8, i9, i6, i10, str, str2, str3, z2, z3, true) : h(zzkpVar, immutableMap, immutableMap2, immutableSet, cArr, i3, i8, i9, i6, i10, str, str2, str3, z2, z3, true);
                        }
                        c3 = '0';
                    } else if (i(zzkpVar, immutableMap, immutableMap2, immutableSet, cArr, i3, i8, i9, i6, i10, str, str2, str3, z2, z3, true) != com.google.android.gms.internal.measurement.zzkq.PURPOSE_RESTRICTION_REQUIRE_CONSENT) {
                        return h(zzkpVar, immutableMap, immutableMap2, immutableSet, cArr, i3, i8, i9, i6, i10, str, str2, str3, z2, z3, true);
                    }
                } else if (i(zzkpVar, immutableMap, immutableMap2, immutableSet, cArr, i3, i8, i9, i6, i10, str, str2, str3, z2, z3, true) != com.google.android.gms.internal.measurement.zzkq.PURPOSE_RESTRICTION_REQUIRE_LEGITIMATE_INTEREST) {
                    return g(zzkpVar, immutableMap, immutableMap2, immutableSet, cArr, i3, i8, i9, i6, i10, str, str2, str3, z2, z3, true);
                }
                c3 = '8';
            } else {
                c3 = '0';
            }
        }
        if (iE <= 0 || cArr[iE] == '2') {
            return false;
        }
        cArr[iE] = c3;
        return false;
    }

    public static final Map d(ImmutableMap immutableMap, ImmutableMap immutableMap2, ImmutableSet immutableSet, char[] cArr, int i3, int i4, int i5, int i6, int i7, String str, String str2, String str3, boolean z2, boolean z3, boolean z4) {
        if (!z4) {
            return ImmutableMap.n();
        }
        com.google.android.gms.internal.measurement.zzkp zzkpVar = com.google.android.gms.internal.measurement.zzkp.IAB_TCF_PURPOSE_STORE_AND_ACCESS_INFORMATION_ON_A_DEVICE;
        com.google.android.gms.internal.measurement.zzkq zzkqVar = (com.google.android.gms.internal.measurement.zzkq) immutableMap2.get(zzkpVar);
        com.google.android.gms.internal.measurement.zzkp zzkpVar2 = com.google.android.gms.internal.measurement.zzkp.IAB_TCF_PURPOSE_CREATE_A_PERSONALISED_ADS_PROFILE;
        com.google.android.gms.internal.measurement.zzkq zzkqVar2 = (com.google.android.gms.internal.measurement.zzkq) immutableMap2.get(zzkpVar2);
        com.google.android.gms.internal.measurement.zzkp zzkpVar3 = com.google.android.gms.internal.measurement.zzkp.IAB_TCF_PURPOSE_SELECT_PERSONALISED_ADS;
        com.google.android.gms.internal.measurement.zzkq zzkqVar3 = (com.google.android.gms.internal.measurement.zzkq) immutableMap2.get(zzkpVar3);
        com.google.android.gms.internal.measurement.zzkp zzkpVar4 = com.google.android.gms.internal.measurement.zzkp.IAB_TCF_PURPOSE_MEASURE_AD_PERFORMANCE;
        com.google.android.gms.internal.measurement.zzkq zzkqVar4 = (com.google.android.gms.internal.measurement.zzkq) immutableMap2.get(zzkpVar4);
        ImmutableMap.Builder builderG = ImmutableMap.a().g("Version", "2");
        String str4 = AppEventsConstants.EVENT_PARAM_VALUE_YES;
        ImmutableMap.Builder builderJ = builderG.g("VendorConsent", true != z2 ? AppEventsConstants.EVENT_PARAM_VALUE_NO : AppEventsConstants.EVENT_PARAM_VALUE_YES).g("VendorLegitimateInterest", true != z3 ? AppEventsConstants.EVENT_PARAM_VALUE_NO : AppEventsConstants.EVENT_PARAM_VALUE_YES).g("gdprApplies", i5 != 1 ? AppEventsConstants.EVENT_PARAM_VALUE_NO : AppEventsConstants.EVENT_PARAM_VALUE_YES).g("EnableAdvertiserConsentMode", i4 != 1 ? AppEventsConstants.EVENT_PARAM_VALUE_NO : AppEventsConstants.EVENT_PARAM_VALUE_YES).g("PolicyVersion", String.valueOf(i6)).g("CmpSdkID", String.valueOf(i3)).g("PurposeOneTreatment", i7 != 1 ? AppEventsConstants.EVENT_PARAM_VALUE_NO : AppEventsConstants.EVENT_PARAM_VALUE_YES).g("PublisherCC", str).g("PublisherRestrictions1", String.valueOf(zzkqVar != null ? zzkqVar.zza() : com.google.android.gms.internal.measurement.zzkq.PURPOSE_RESTRICTION_UNDEFINED.zza())).g("PublisherRestrictions3", String.valueOf(zzkqVar2 != null ? zzkqVar2.zza() : com.google.android.gms.internal.measurement.zzkq.PURPOSE_RESTRICTION_UNDEFINED.zza())).g("PublisherRestrictions4", String.valueOf(zzkqVar3 != null ? zzkqVar3.zza() : com.google.android.gms.internal.measurement.zzkq.PURPOSE_RESTRICTION_UNDEFINED.zza())).g("PublisherRestrictions7", String.valueOf(zzkqVar4 != null ? zzkqVar4.zza() : com.google.android.gms.internal.measurement.zzkq.PURPOSE_RESTRICTION_UNDEFINED.zza())).j(ImmutableMap.p("Purpose1", f(zzkpVar, immutableMap, immutableMap2, immutableSet, cArr, i3, i4, i5, i6, i7, str, str2, str3, z2, z3, true), "Purpose3", f(zzkpVar2, immutableMap, immutableMap2, immutableSet, cArr, i3, i4, i5, i6, i7, str, str2, str3, z2, z3, true), "Purpose4", f(zzkpVar3, immutableMap, immutableMap2, immutableSet, cArr, i3, i4, i5, i6, i7, str, str2, str3, z2, z3, true), "Purpose7", f(zzkpVar4, immutableMap, immutableMap2, immutableSet, cArr, i3, i4, i5, i6, i7, str, str2, str3, z2, z3, true)));
        Object obj = true != c(zzkpVar, immutableMap, immutableMap2, immutableSet, cArr, i3, i4, i5, i6, i7, str, str2, str3, z2, z3, true) ? AppEventsConstants.EVENT_PARAM_VALUE_NO : AppEventsConstants.EVENT_PARAM_VALUE_YES;
        Object obj2 = true != c(zzkpVar2, immutableMap, immutableMap2, immutableSet, cArr, i3, i4, i5, i6, i7, str, str2, str3, z2, z3, true) ? AppEventsConstants.EVENT_PARAM_VALUE_NO : AppEventsConstants.EVENT_PARAM_VALUE_YES;
        Object obj3 = true != c(zzkpVar3, immutableMap, immutableMap2, immutableSet, cArr, i3, i4, i5, i6, i7, str, str2, str3, z2, z3, true) ? AppEventsConstants.EVENT_PARAM_VALUE_NO : AppEventsConstants.EVENT_PARAM_VALUE_YES;
        if (true != c(zzkpVar4, immutableMap, immutableMap2, immutableSet, cArr, i3, i4, i5, i6, i7, str, str2, str3, z2, z3, true)) {
            str4 = AppEventsConstants.EVENT_PARAM_VALUE_NO;
        }
        return builderJ.j(ImmutableMap.q("AuthorizePurpose1", obj, "AuthorizePurpose3", obj2, "AuthorizePurpose4", obj3, "AuthorizePurpose7", str4, "PurposeDiagnostics", new String(cArr))).d();
    }

    private static final int e(com.google.android.gms.internal.measurement.zzkp zzkpVar, ImmutableMap immutableMap, ImmutableMap immutableMap2, ImmutableSet immutableSet, char[] cArr, int i3, int i4, int i5, int i6, int i7, String str, String str2, String str3, boolean z2, boolean z3, boolean z4) {
        if (zzkpVar == com.google.android.gms.internal.measurement.zzkp.IAB_TCF_PURPOSE_STORE_AND_ACCESS_INFORMATION_ON_A_DEVICE) {
            return 1;
        }
        if (zzkpVar == com.google.android.gms.internal.measurement.zzkp.IAB_TCF_PURPOSE_CREATE_A_PERSONALISED_ADS_PROFILE) {
            return 2;
        }
        if (zzkpVar == com.google.android.gms.internal.measurement.zzkp.IAB_TCF_PURPOSE_SELECT_PERSONALISED_ADS) {
            return 3;
        }
        return zzkpVar == com.google.android.gms.internal.measurement.zzkp.IAB_TCF_PURPOSE_MEASURE_AD_PERFORMANCE ? 4 : -1;
    }

    private static final String f(com.google.android.gms.internal.measurement.zzkp zzkpVar, ImmutableMap immutableMap, ImmutableMap immutableMap2, ImmutableSet immutableSet, char[] cArr, int i3, int i4, int i5, int i6, int i7, String str, String str2, String str3, boolean z2, boolean z3, boolean z4) {
        boolean zIsEmpty = TextUtils.isEmpty(str2);
        String strValueOf = AppEventsConstants.EVENT_PARAM_VALUE_NO;
        String strValueOf2 = (zIsEmpty || str2.length() < zzkpVar.zza()) ? AppEventsConstants.EVENT_PARAM_VALUE_NO : String.valueOf(str2.charAt(zzkpVar.zza() - 1));
        if (!TextUtils.isEmpty(str3) && str3.length() >= zzkpVar.zza()) {
            strValueOf = String.valueOf(str3.charAt(zzkpVar.zza() - 1));
        }
        return String.valueOf(strValueOf2).concat(String.valueOf(strValueOf));
    }

    private static final boolean g(com.google.android.gms.internal.measurement.zzkp zzkpVar, ImmutableMap immutableMap, ImmutableMap immutableMap2, ImmutableSet immutableSet, char[] cArr, int i3, int i4, int i5, int i6, int i7, String str, String str2, String str3, boolean z2, boolean z3, boolean z4) {
        char c3;
        int iE = e(zzkpVar, immutableMap, immutableMap2, immutableSet, cArr, i3, i4, i5, i6, i7, str, str2, str3, z2, z3, true);
        if (!z2) {
            c3 = '4';
        } else {
            if (str2.length() >= zzkpVar.zza()) {
                char cCharAt = str2.charAt(zzkpVar.zza() - 1);
                boolean z5 = cCharAt == '1';
                if (iE > 0 && cArr[iE] != '2') {
                    cArr[iE] = cCharAt != '1' ? '6' : '1';
                }
                return z5;
            }
            c3 = '0';
        }
        if (iE > 0 && cArr[iE] != '2') {
            cArr[iE] = c3;
        }
        return false;
    }

    private static final boolean h(com.google.android.gms.internal.measurement.zzkp zzkpVar, ImmutableMap immutableMap, ImmutableMap immutableMap2, ImmutableSet immutableSet, char[] cArr, int i3, int i4, int i5, int i6, int i7, String str, String str2, String str3, boolean z2, boolean z3, boolean z4) {
        char c3;
        int iE = e(zzkpVar, immutableMap, immutableMap2, immutableSet, cArr, i3, i4, i5, i6, i7, str, str2, str3, z2, z3, true);
        if (!z3) {
            c3 = '5';
        } else {
            if (str3.length() >= zzkpVar.zza()) {
                char cCharAt = str3.charAt(zzkpVar.zza() - 1);
                boolean z5 = cCharAt == '1';
                if (iE > 0 && cArr[iE] != '2') {
                    cArr[iE] = cCharAt != '1' ? '7' : '1';
                }
                return z5;
            }
            c3 = '0';
        }
        if (iE > 0 && cArr[iE] != '2') {
            cArr[iE] = c3;
        }
        return false;
    }

    private static final com.google.android.gms.internal.measurement.zzkq i(com.google.android.gms.internal.measurement.zzkp zzkpVar, ImmutableMap immutableMap, ImmutableMap immutableMap2, ImmutableSet immutableSet, char[] cArr, int i3, int i4, int i5, int i6, int i7, String str, String str2, String str3, boolean z2, boolean z3, boolean z4) {
        return (com.google.android.gms.internal.measurement.zzkq) immutableMap2.getOrDefault(zzkpVar, com.google.android.gms.internal.measurement.zzkq.PURPOSE_RESTRICTION_UNDEFINED);
    }
}
