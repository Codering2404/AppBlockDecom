package com.facebook.appevents.gps.pa;

import android.adservices.common.AdData;
import android.adservices.common.AdSelectionSignals;
import android.adservices.common.AdTechIdentifier;
import android.adservices.customaudience.CustomAudience;
import android.adservices.customaudience.CustomAudienceManager;
import android.adservices.customaudience.JoinCustomAudienceRequest;
import android.adservices.customaudience.TrustedBiddingData;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.OutcomeReceiver;
import android.util.Log;
import androidx.privacysandbox.ads.adservices.customaudience.x;
import androidx.privacysandbox.ads.adservices.customaudience.y;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEvent;
import com.facebook.appevents.gps.GpsDebugLogger;
import com.facebook.appevents.internal.Constants;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.util.concurrent.Executors;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class PACustomAudienceClient {
    private static final String BUYER = "facebook.com";
    private static final String DELIMITER = "@";
    private static final String EVENT_NAME_CONFIG_VERSION = "1";
    private static final String GPS_PREFIX = "gps";
    private static final String REPLACEMENT_STRING = "_removed_";
    private static String baseUri;
    private static CustomAudienceManager customAudienceManager;
    private static boolean enabled;
    private static GpsDebugLogger gpsDebugLogger;
    private static boolean isInitialized;
    public static final PACustomAudienceClient INSTANCE = new PACustomAudienceClient();
    private static final String TAG = "Fledge: " + PACustomAudienceClient.class.getSimpleName();

    private PACustomAudienceClient() {
    }

    public static final /* synthetic */ GpsDebugLogger access$getGpsDebugLogger$p() {
        if (CrashShieldHandler.isObjectCrashing(PACustomAudienceClient.class)) {
            return null;
        }
        try {
            return gpsDebugLogger;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, PACustomAudienceClient.class);
            return null;
        }
    }

    public static final /* synthetic */ String access$getTAG$p() {
        if (CrashShieldHandler.isObjectCrashing(PACustomAudienceClient.class)) {
            return null;
        }
        try {
            return TAG;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, PACustomAudienceClient.class);
            return null;
        }
    }

    @JvmStatic
    public static final void enable() {
        String string;
        if (CrashShieldHandler.isObjectCrashing(PACustomAudienceClient.class)) {
            return;
        }
        try {
            isInitialized = true;
            Context applicationContext = FacebookSdk.getApplicationContext();
            gpsDebugLogger = new GpsDebugLogger(applicationContext);
            baseUri = "https://www." + FacebookSdk.getFacebookDomain() + "/privacy_sandbox/pa/logic";
            GpsDebugLogger gpsDebugLogger2 = null;
            try {
                try {
                    CustomAudienceManager customAudienceManager2 = CustomAudienceManager.get(applicationContext);
                    customAudienceManager = customAudienceManager2;
                    if (customAudienceManager2 != null) {
                        enabled = true;
                    }
                    string = null;
                } catch (Exception e3) {
                    string = e3.toString();
                    Log.w(TAG, "Failed to get CustomAudienceManager: " + e3);
                }
            } catch (Error e4) {
                string = e4.toString();
                Log.w(TAG, "Failed to get CustomAudienceManager: " + e4);
            }
            if (enabled) {
                return;
            }
            GpsDebugLogger gpsDebugLogger3 = gpsDebugLogger;
            if (gpsDebugLogger3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("gpsDebugLogger");
            } else {
                gpsDebugLogger2 = gpsDebugLogger3;
            }
            Bundle bundle = new Bundle();
            bundle.putString(Constants.GPS_PA_FAILED_REASON, string);
            Unit unit = Unit.f139807a;
            gpsDebugLogger2.log(Constants.GPS_PA_FAILED, bundle);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, PACustomAudienceClient.class);
        }
    }

    private final void joinCustomAudienceImpl(String str, String str2) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            String strValidateAndCreateCAName = validateAndCreateCAName(str, str2);
            if (strValidateAndCreateCAName == null) {
                return;
            }
            GpsDebugLogger gpsDebugLogger2 = null;
            try {
                OutcomeReceiver outcomeReceiverA = androidx.core.os.a.a(new OutcomeReceiver() { // from class: com.facebook.appevents.gps.pa.PACustomAudienceClient$joinCustomAudienceImpl$callback$1
                    public void onResult(Object result) {
                        Intrinsics.checkNotNullParameter(result, "result");
                        Log.i(PACustomAudienceClient.access$getTAG$p(), "Successfully joined custom audience");
                        GpsDebugLogger gpsDebugLoggerAccess$getGpsDebugLogger$p = PACustomAudienceClient.access$getGpsDebugLogger$p();
                        if (gpsDebugLoggerAccess$getGpsDebugLogger$p == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("gpsDebugLogger");
                            gpsDebugLoggerAccess$getGpsDebugLogger$p = null;
                        }
                        gpsDebugLoggerAccess$getGpsDebugLogger$p.log(Constants.GPS_PA_SUCCEED, null);
                    }

                    public void onError(Exception error) {
                        Intrinsics.checkNotNullParameter(error, "error");
                        Log.e(PACustomAudienceClient.access$getTAG$p(), error.toString());
                        GpsDebugLogger gpsDebugLoggerAccess$getGpsDebugLogger$p = PACustomAudienceClient.access$getGpsDebugLogger$p();
                        if (gpsDebugLoggerAccess$getGpsDebugLogger$p == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("gpsDebugLogger");
                            gpsDebugLoggerAccess$getGpsDebugLogger$p = null;
                        }
                        Bundle bundle = new Bundle();
                        bundle.putString(Constants.GPS_PA_FAILED_REASON, error.toString());
                        Unit unit = Unit.f139807a;
                        gpsDebugLoggerAccess$getGpsDebugLogger$p.log(Constants.GPS_PA_FAILED, bundle);
                    }
                });
                a.a();
                AdData.Builder builderA = androidx.privacysandbox.ads.adservices.common.a.a();
                StringBuilder sb = new StringBuilder();
                String str3 = baseUri;
                if (str3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("baseUri");
                    str3 = null;
                }
                sb.append(str3);
                sb.append("/ad");
                Uri uri = Uri.parse(sb.toString());
                Intrinsics.checkExpressionValueIsNotNull(uri, "Uri.parse(this)");
                AdData adDataBuild = builderA.setRenderUri(uri).setMetadata("{'isRealAd': false}").build();
                Intrinsics.checkNotNullExpressionValue(adDataBuild, "Builder()\n              …\n                .build()");
                b.a();
                TrustedBiddingData.Builder builderA2 = x.a();
                StringBuilder sb2 = new StringBuilder();
                String str4 = baseUri;
                if (str4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("baseUri");
                    str4 = null;
                }
                sb2.append(str4);
                sb2.append("?trusted_bidding");
                Uri uri2 = Uri.parse(sb2.toString());
                Intrinsics.checkExpressionValueIsNotNull(uri2, "Uri.parse(this)");
                TrustedBiddingData trustedBiddingDataBuild = builderA2.setTrustedBiddingUri(uri2).setTrustedBiddingKeys(CollectionsKt.listOf("")).build();
                Intrinsics.checkNotNullExpressionValue(trustedBiddingDataBuild, "Builder()\n              …\n                .build()");
                c.a();
                CustomAudience.Builder buyer = androidx.privacysandbox.ads.adservices.customaudience.c.a().setName(strValidateAndCreateCAName).setBuyer(AdTechIdentifier.fromString("facebook.com"));
                StringBuilder sb3 = new StringBuilder();
                String str5 = baseUri;
                if (str5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("baseUri");
                    str5 = null;
                }
                sb3.append(str5);
                sb3.append("?daily&app_id=");
                sb3.append(str);
                Uri uri3 = Uri.parse(sb3.toString());
                Intrinsics.checkExpressionValueIsNotNull(uri3, "Uri.parse(this)");
                CustomAudience.Builder dailyUpdateUri = buyer.setDailyUpdateUri(uri3);
                StringBuilder sb4 = new StringBuilder();
                String str6 = baseUri;
                if (str6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("baseUri");
                    str6 = null;
                }
                sb4.append(str6);
                sb4.append("?bidding");
                Uri uri4 = Uri.parse(sb4.toString());
                Intrinsics.checkExpressionValueIsNotNull(uri4, "Uri.parse(this)");
                CustomAudience customAudienceBuild = dailyUpdateUri.setBiddingLogicUri(uri4).setTrustedBiddingData(trustedBiddingDataBuild).setUserBiddingSignals(AdSelectionSignals.fromString(JsonUtils.EMPTY_JSON)).setAds(CollectionsKt.listOf(adDataBuild)).build();
                Intrinsics.checkNotNullExpressionValue(customAudienceBuild, "Builder()\n              …(listOf(dummyAd)).build()");
                d.a();
                JoinCustomAudienceRequest joinCustomAudienceRequestBuild = y.a().setCustomAudience(customAudienceBuild).build();
                Intrinsics.checkNotNullExpressionValue(joinCustomAudienceRequestBuild, "Builder().setCustomAudience(ca).build()");
                CustomAudienceManager customAudienceManager2 = customAudienceManager;
                if (customAudienceManager2 != null) {
                    customAudienceManager2.joinCustomAudience(joinCustomAudienceRequestBuild, Executors.newSingleThreadExecutor(), outcomeReceiverA);
                }
            } catch (Error e3) {
                Log.w(TAG, "Failed to join Custom Audience: " + e3);
                GpsDebugLogger gpsDebugLogger3 = gpsDebugLogger;
                if (gpsDebugLogger3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("gpsDebugLogger");
                } else {
                    gpsDebugLogger2 = gpsDebugLogger3;
                }
                Bundle bundle = new Bundle();
                bundle.putString(Constants.GPS_PA_FAILED_REASON, e3.toString());
                Unit unit = Unit.f139807a;
                gpsDebugLogger2.log(Constants.GPS_PA_FAILED, bundle);
            } catch (Exception e4) {
                Log.w(TAG, "Failed to join Custom Audience: " + e4);
                GpsDebugLogger gpsDebugLogger4 = gpsDebugLogger;
                if (gpsDebugLogger4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("gpsDebugLogger");
                } else {
                    gpsDebugLogger2 = gpsDebugLogger4;
                }
                Bundle bundle2 = new Bundle();
                bundle2.putString(Constants.GPS_PA_FAILED_REASON, e4.toString());
                Unit unit2 = Unit.f139807a;
                gpsDebugLogger2.log(Constants.GPS_PA_FAILED, bundle2);
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    private final String validateAndCreateCAName(String str, String str2) {
        if (!CrashShieldHandler.isObjectCrashing(this) && str != null && str2 != null) {
            try {
                if (!Intrinsics.areEqual(str2, REPLACEMENT_STRING) && !StringsKt.a0(str2, GPS_PREFIX, false, 2, null)) {
                    return str + '@' + str2 + '@' + (System.currentTimeMillis() / ((long) 1000)) + "@1";
                }
                return null;
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
        return null;
    }

    public final void joinCustomAudience(String str, String str2) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            if (!isInitialized) {
                enable();
            }
            if (enabled) {
                joinCustomAudienceImpl(str, str2);
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    public final void joinCustomAudience(String str, AppEvent appEvent) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            if (!isInitialized) {
                enable();
            }
            if (enabled) {
                String string = null;
                if (appEvent != null) {
                    try {
                        JSONObject jSONObject = appEvent.getJSONObject();
                        if (jSONObject != null) {
                            string = jSONObject.getString(Constants.EVENT_NAME_EVENT_KEY);
                        }
                    } catch (JSONException unused) {
                        Log.w(TAG, "Failed to get event name from event.");
                    }
                }
                joinCustomAudienceImpl(str, string);
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }
}
