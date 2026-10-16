package com.google.android.gms.internal.play_billing;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.android.billingclient.api.BillingFlowParams;
import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.InAppMessageResult;
import com.android.billingclient.api.Purchase;
import com.android.billingclient.api.QueryProductDetailsParams;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.revenuecat.purchases.common.Constants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzc {
    public static final int zza = Runtime.getRuntime().availableProcessors();

    public static int zza(Intent intent, String str) {
        if (intent != null) {
            return zzq(intent.getExtras(), "ProxyBillingActivity");
        }
        zzo("ProxyBillingActivity", "Got null intent!");
        return 0;
    }

    public static int zzb(Bundle bundle, String str) {
        if (bundle == null) {
            zzo(str, "Unexpected null bundle received!");
            return 6;
        }
        Object obj = bundle.get("RESPONSE_CODE");
        if (obj == null) {
            zzn(str, "getResponseCodeFromBundle() got null response code, assuming OK");
            return 0;
        }
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        }
        zzo(str, "Unexpected type for bundle response code: ".concat(obj.getClass().getName()));
        return 6;
    }

    public static Bundle zzc(Bundle bundle, String str, String str2, long j3) {
        bundle.putString("playBillingLibraryVersion", str);
        if (str2 != null) {
            bundle.putString("playBillingLibraryWrapperVersion", str2);
        }
        bundle.putLong("billingClientSessionId", j3);
        return bundle;
    }

    public static Bundle zzd(BillingResult billingResult, zzjd zzjdVar) {
        Bundle bundle = new Bundle();
        bundle.putInt("RESPONSE_CODE", billingResult.c());
        bundle.putString("DEBUG_MESSAGE", billingResult.a());
        bundle.putInt("LOG_REASON", zzjdVar.zza());
        return bundle;
    }

    public static Bundle zze(BillingResult billingResult, zzjd zzjdVar, String str) {
        Bundle bundleZzd = zzd(billingResult, zzjdVar);
        if (str != null) {
            bundleZzd.putString("ADDITIONAL_LOG_DETAILS", str);
        }
        return bundleZzd;
    }

    public static Bundle zzf(BillingFlowParams billingFlowParams, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, String str, String str2, long j3, String str3, long j4) {
        int i3;
        Bundle bundle = new Bundle();
        zzc(bundle, str, str2, j3);
        bundle.putLong("billingClientTransactionId", j4);
        if (billingFlowParams.d() != 0) {
            bundle.putInt("prorationMode", billingFlowParams.d());
        }
        if (!TextUtils.isEmpty(billingFlowParams.g())) {
            bundle.putString("accountId", billingFlowParams.g());
        }
        if (!TextUtils.isEmpty(billingFlowParams.h())) {
            bundle.putString("obfuscatedProfileId", billingFlowParams.h());
        }
        if (billingFlowParams.v()) {
            bundle.putBoolean("isOfferPersonalizedByDeveloper", true);
        }
        if (!TextUtils.isEmpty(null)) {
            bundle.putStringArrayList("skusToReplace", new ArrayList<>(Arrays.asList(null)));
        }
        if (!TextUtils.isEmpty(billingFlowParams.j())) {
            bundle.putString("oldSkuPurchaseToken", billingFlowParams.j());
        }
        billingFlowParams.i();
        if (!TextUtils.isEmpty(null)) {
            billingFlowParams.i();
            bundle.putString("oldSkuPurchaseId", null);
        }
        if (!TextUtils.isEmpty(billingFlowParams.k())) {
            bundle.putString("originalExternalTransactionId", billingFlowParams.k());
        }
        if (!TextUtils.isEmpty(null)) {
            bundle.putString("paymentsPurchaseParams", null);
        }
        if (z2 && z4) {
            bundle.putBoolean(InAppPurchaseConstants.METHOD_ENABLE_PENDING_PURCHASES, true);
        }
        if (z3 && z5) {
            bundle.putBoolean("enablePendingPurchaseForSubscriptions", true);
        }
        if (z6 || billingFlowParams.a() != null) {
            bundle.putBoolean("enableAlternativeBilling", true);
        }
        billingFlowParams.e();
        billingFlowParams.c();
        if (billingFlowParams.a() != null) {
            if (billingFlowParams.a().c() != null) {
                bundle.putString("developerBillingLinkUri", billingFlowParams.a().c().toString());
            }
            if (billingFlowParams.a().b() != 0) {
                bundle.putInt("developerBillingLaunchMode", billingFlowParams.a().b());
            }
            bundle.putInt("developerBillingProgram", billingFlowParams.a().a());
        }
        ArrayList arrayList = new ArrayList();
        for (BillingFlowParams.ProductDetailsParams productDetailsParams : billingFlowParams.m()) {
            if (productDetailsParams.a() != null) {
                String strE = productDetailsParams.c().e();
                BillingFlowParams.ProductDetailsParams.SubscriptionProductReplacementParams subscriptionProductReplacementParamsA = productDetailsParams.a();
                zzdq zzdqVarZza = zzdr.zza();
                zzea zzeaVarZza = zzeb.zza();
                zzeaVarZza.zza(zzs(strE, "subs", str3));
                zzdqVarZza.zza(zzeaVarZza);
                zzea zzeaVarZza2 = zzeb.zza();
                zzeaVarZza2.zza(zzs(subscriptionProductReplacementParamsA.b(), "subs", str3));
                zzdqVarZza.zzb(zzeaVarZza2);
                switch (subscriptionProductReplacementParamsA.c()) {
                    case 1:
                        i3 = 2;
                        break;
                    case 2:
                        i3 = 3;
                        break;
                    case 3:
                        i3 = 4;
                        break;
                    case 4:
                        i3 = 6;
                        break;
                    case 5:
                        i3 = 7;
                        break;
                    case 6:
                        i3 = 8;
                        break;
                    case 7:
                        i3 = 9;
                        break;
                    default:
                        i3 = 1;
                        break;
                }
                zzdqVarZza.zzc(i3);
                arrayList.add((zzdr) zzdqVarZza.zzi());
            }
        }
        if (!arrayList.isEmpty()) {
            zzds zzdsVarZza = zzdt.zza();
            zzdsVarZza.zza(arrayList);
            bundle.putByteArray("subscriptionProductReplacementParamsList", ((zzdt) zzdsVarZza.zzi()).zzQ());
        }
        return bundle;
    }

    public static Bundle zzg(String str, String str2, ArrayList arrayList, String str3, String str4, zza zzaVar, long j3) {
        Bundle bundle = new Bundle();
        zzc(bundle, str, str2, j3);
        bundle.putBoolean(InAppPurchaseConstants.METHOD_ENABLE_PENDING_PURCHASES, true);
        bundle.putString("SKU_DETAILS_RESPONSE_FORMAT", "PRODUCT_DETAILS");
        bundle.putStringArrayList("PRODUCT_TYPES_TO_RETURN_MULTIPLE_OFFERS", new ArrayList<>(zzbw.zzm("subs", "inapp")));
        bundle.putStringArrayList("PRODUCT_TYPES_TO_RETURN_PREORDER_OFFERS", new ArrayList<>(zzbw.zzl("inapp")));
        bundle.putStringArrayList("PRODUCT_TYPES_TO_RETURN_RENT_OFFERS", new ArrayList<>(zzbw.zzl("inapp")));
        bundle.putBoolean("SHOULD_RETURN_UNFETCHED_PRODUCTS", true);
        if (zzaVar.zza) {
            bundle.putBoolean("enablePendingPurchaseForSubscriptions", true);
        }
        ArrayList<String> arrayList2 = new ArrayList<>();
        ArrayList<String> arrayList3 = new ArrayList<>();
        ArrayList<String> arrayList4 = new ArrayList<>();
        int size = arrayList.size();
        boolean z2 = false;
        boolean z3 = false;
        for (int i3 = 0; i3 < size; i3++) {
            QueryProductDetailsParams.Product product = (QueryProductDetailsParams.Product) arrayList.get(i3);
            arrayList2.add(null);
            z2 |= !TextUtils.isEmpty(null);
            arrayList4.add(null);
            z3 |= !TextUtils.isEmpty(null);
            if (product.c().equals("first_party")) {
                zzbj.zzc(null, "Serialized DocId is required for constructing ExtraParams to query ProductDetails for all first party products.");
                arrayList3.add(null);
            }
        }
        if (z2) {
            bundle.putStringArrayList("SKU_OFFER_ID_TOKEN_LIST", arrayList2);
        }
        if (!arrayList3.isEmpty()) {
            bundle.putStringArrayList("SKU_SERIALIZED_DOCID_LIST", arrayList3);
        }
        if (!TextUtils.isEmpty(null)) {
            bundle.putString("accountName", null);
        }
        if (z3) {
            bundle.putStringArrayList("SKU_DYNAMIC_PRODUCT_TOKEN_LIST", arrayList4);
        }
        return bundle;
    }

    public static Bundle zzh(String str, String str2, long j3) {
        Bundle bundle = new Bundle();
        zzc(bundle, str, str2, j3);
        return bundle;
    }

    public static BillingResult zzi(Intent intent, String str) {
        if (intent != null) {
            BillingResult.Builder builderD = BillingResult.d();
            builderD.d(zzb(intent.getExtras(), str));
            builderD.b(zzk(intent.getExtras(), str));
            return builderD.a();
        }
        zzo("BillingHelper", "Got null intent!");
        BillingResult.Builder builderD2 = BillingResult.d();
        builderD2.d(6);
        builderD2.b("An internal error occurred.");
        return builderD2.a();
    }

    public static InAppMessageResult zzj(Bundle bundle, String str) {
        return bundle == null ? new InAppMessageResult(0, null) : new InAppMessageResult(zzq(bundle, "BillingClient"), bundle.getString("IN_APP_MESSAGE_PURCHASE_TOKEN"));
    }

    public static String zzk(Bundle bundle, String str) {
        if (bundle == null) {
            zzo(str, "Unexpected null bundle received!");
            return "";
        }
        Object obj = bundle.get("DEBUG_MESSAGE");
        if (obj == null) {
            zzn(str, "getDebugMessageFromBundle() got null response code, assuming OK");
            return "";
        }
        if (obj instanceof String) {
            return (String) obj;
        }
        zzo(str, "Unexpected type for debug message: ".concat(obj.getClass().getName()));
        return "";
    }

    public static String zzl(int i3) {
        return zzb.zza(i3).toString();
    }

    public static List zzm(Bundle bundle) {
        ArrayList<String> stringArrayList = bundle.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
        ArrayList<String> stringArrayList2 = bundle.getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
        ArrayList arrayList = new ArrayList();
        if (stringArrayList == null || stringArrayList2 == null) {
            Purchase purchaseZzr = zzr(bundle.getString("INAPP_PURCHASE_DATA"), bundle.getString("INAPP_DATA_SIGNATURE"));
            if (purchaseZzr == null) {
                zzn("BillingHelper", "Couldn't find single purchase data as well.");
                return null;
            }
            arrayList.add(purchaseZzr);
            return arrayList;
        }
        zzn("BillingHelper", "Found purchase list of " + stringArrayList.size() + " items");
        for (int i3 = 0; i3 < stringArrayList.size() && i3 < stringArrayList2.size(); i3++) {
            Purchase purchaseZzr2 = zzr(stringArrayList.get(i3), stringArrayList2.get(i3));
            if (purchaseZzr2 != null) {
                arrayList.add(purchaseZzr2);
            }
        }
        return arrayList;
    }

    public static void zzn(String str, String str2) {
        if (Log.isLoggable(str, 2)) {
            if (str2.isEmpty()) {
                Log.v(str, str2);
                return;
            }
            int i3 = 40000;
            while (!str2.isEmpty() && i3 > 0) {
                int iMin = Math.min(str2.length(), Math.min(4000, i3));
                Log.v(str, str2.substring(0, iMin));
                str2 = str2.substring(iMin);
                i3 -= iMin;
            }
        }
    }

    public static void zzo(String str, String str2) {
        if (Log.isLoggable(str, 5)) {
            Log.w(str, str2);
        }
    }

    public static void zzp(String str, String str2, Throwable th) {
        try {
            if (Log.isLoggable(str, 5)) {
                if (th == null) {
                    Log.w(str, str2);
                } else {
                    Log.w(str, str2, th);
                }
            }
        } catch (Throwable unused) {
        }
    }

    private static int zzq(Bundle bundle, String str) {
        if (bundle != null) {
            return bundle.getInt("IN_APP_MESSAGE_RESPONSE_CODE", 0);
        }
        zzo(str, "Unexpected null bundle received!");
        return 0;
    }

    private static Purchase zzr(String str, String str2) {
        if (str == null || str2 == null) {
            zzn("BillingHelper", "Received a null purchase data.");
            return null;
        }
        try {
            return new Purchase(str, str2);
        } catch (JSONException e3) {
            zzo("BillingHelper", "Got JSONException while parsing purchase data: ".concat(e3.toString()));
            return null;
        }
    }

    private static String zzs(String str, String str2, String str3) {
        return "subs:" + str3 + Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR + str;
    }
}
