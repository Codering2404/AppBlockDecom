package com.facebook.appevents.gps.ara;

import android.adservices.measurement.MeasurementManager;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.OutcomeReceiver;
import android.util.Log;
import androidx.privacysandbox.ads.adservices.measurement.j;
import androidx.privacysandbox.ads.adservices.measurement.k;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEvent;
import com.facebook.appevents.gps.GpsDebugLogger;
import com.facebook.appevents.internal.Constants;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.facebook.stetho.common.Utf8Charset;
import com.google.android.material.bottomsheet.lKiE.YznnJpHcAmeoW;
import java.net.URLEncoder;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class GpsAraTriggersManager {
    private static final String GPS_PREFIX = "gps";
    public static final GpsAraTriggersManager INSTANCE = new GpsAraTriggersManager();
    private static final String REPLACEMENT_STRING = "_removed_";
    private static final String TAG;
    private static boolean enabled;
    private static GpsDebugLogger gpsDebugLogger;
    private static String serverUri;

    static {
        String string = GpsAraTriggersManager.class.toString();
        Intrinsics.checkNotNullExpressionValue(string, "GpsAraTriggersManager::class.java.toString()");
        TAG = string;
    }

    private GpsAraTriggersManager() {
    }

    public static final /* synthetic */ GpsDebugLogger access$getGpsDebugLogger$p() {
        if (CrashShieldHandler.isObjectCrashing(GpsAraTriggersManager.class)) {
            return null;
        }
        try {
            return gpsDebugLogger;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, GpsAraTriggersManager.class);
            return null;
        }
    }

    public static final /* synthetic */ String access$getTAG$p() {
        if (CrashShieldHandler.isObjectCrashing(GpsAraTriggersManager.class)) {
            return null;
        }
        try {
            return TAG;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, GpsAraTriggersManager.class);
            return null;
        }
    }

    private final boolean canRegisterTrigger() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return false;
        }
        try {
            if (!enabled || Build.VERSION.SDK_INT < 33) {
                return false;
            }
            GpsDebugLogger gpsDebugLogger2 = null;
            try {
                Class.forName("android.adservices.measurement.MeasurementManager");
                Class.forName("android.os.OutcomeReceiver");
                return true;
            } catch (Error e3) {
                Log.i(TAG, "FAILURE_NO_MEASUREMENT_MANAGER_CLASS");
                GpsDebugLogger gpsDebugLogger3 = gpsDebugLogger;
                if (gpsDebugLogger3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("gpsDebugLogger");
                } else {
                    gpsDebugLogger2 = gpsDebugLogger3;
                }
                Bundle bundle = new Bundle();
                bundle.putString(Constants.GPS_ARA_FAILED_REASON, e3.toString());
                Unit unit = Unit.f139807a;
                gpsDebugLogger2.log(Constants.GPS_ARA_FAILED, bundle);
                return false;
            } catch (Exception e4) {
                Log.i(TAG, "FAILURE_NO_MEASUREMENT_MANAGER_CLASS");
                GpsDebugLogger gpsDebugLogger4 = gpsDebugLogger;
                if (gpsDebugLogger4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("gpsDebugLogger");
                } else {
                    gpsDebugLogger2 = gpsDebugLogger4;
                }
                Bundle bundle2 = new Bundle();
                bundle2.putString(Constants.GPS_ARA_FAILED_REASON, e4.toString());
                Unit unit2 = Unit.f139807a;
                gpsDebugLogger2.log(Constants.GPS_ARA_FAILED, bundle2);
                return false;
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return false;
        }
    }

    @JvmStatic
    public static final void enable() {
        if (CrashShieldHandler.isObjectCrashing(GpsAraTriggersManager.class)) {
            return;
        }
        try {
            enabled = true;
            gpsDebugLogger = new GpsDebugLogger(FacebookSdk.getApplicationContext());
            serverUri = "https://www." + FacebookSdk.getFacebookDomain() + "/privacy_sandbox/mobile/register/trigger";
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, GpsAraTriggersManager.class);
        }
    }

    private final String getEventParameters(AppEvent appEvent) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            final JSONObject jSONObject = appEvent.getJSONObject();
            if (jSONObject != null && jSONObject.length() != 0) {
                Iterator<String> itKeys = jSONObject.keys();
                Intrinsics.checkNotNullExpressionValue(itKeys, "params.keys()");
                return SequencesKt.K(SequencesKt.N(SequencesKt.e(itKeys), new Function1<String, String>() { // from class: com.facebook.appevents.gps.ara.GpsAraTriggersManager.getEventParameters.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final String invoke(String str) {
                        Object objOpt = jSONObject.opt(str);
                        if (objOpt == null) {
                            return null;
                        }
                        try {
                            return URLEncoder.encode(str, Utf8Charset.NAME) + '=' + URLEncoder.encode(objOpt.toString(), Utf8Charset.NAME);
                        } catch (Exception unused) {
                            return null;
                        }
                    }
                }), "&", null, null, 0, null, null, 62, null);
            }
            return "";
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    private final boolean isValidEvent(AppEvent appEvent) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return false;
        }
        try {
            String eventName = appEvent.getJSONObject().getString(Constants.EVENT_NAME_EVENT_KEY);
            if (!Intrinsics.areEqual(eventName, REPLACEMENT_STRING)) {
                Intrinsics.checkNotNullExpressionValue(eventName, "eventName");
                if (!StringsKt.a0(eventName, GPS_PREFIX, false, 2, null)) {
                    return true;
                }
            }
            return false;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void registerTriggerAsync$lambda$0(String applicationId, AppEvent event) {
        if (CrashShieldHandler.isObjectCrashing(GpsAraTriggersManager.class)) {
            return;
        }
        try {
            Intrinsics.checkNotNullParameter(applicationId, "$applicationId");
            Intrinsics.checkNotNullParameter(event, "$event");
            INSTANCE.registerTrigger(applicationId, event);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, GpsAraTriggersManager.class);
        }
    }

    public final void registerTrigger(String applicationId, AppEvent event) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            Intrinsics.checkNotNullParameter(applicationId, "applicationId");
            Intrinsics.checkNotNullParameter(event, "event");
            if (isValidEvent(event) && canRegisterTrigger()) {
                Context applicationContext = FacebookSdk.getApplicationContext();
                GpsDebugLogger gpsDebugLogger2 = null;
                try {
                    MeasurementManager measurementManagerA = k.a(applicationContext.getSystemService(j.a()));
                    if (measurementManagerA == null) {
                        measurementManagerA = MeasurementManager.get(applicationContext.getApplicationContext());
                    }
                    if (measurementManagerA == null) {
                        Log.w(TAG, "FAILURE_GET_MEASUREMENT_MANAGER");
                        GpsDebugLogger gpsDebugLogger3 = gpsDebugLogger;
                        if (gpsDebugLogger3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("gpsDebugLogger");
                            gpsDebugLogger3 = null;
                        }
                        Bundle bundle = new Bundle();
                        bundle.putString(Constants.GPS_ARA_FAILED_REASON, "Failed to get measurement manager");
                        Unit unit = Unit.f139807a;
                        gpsDebugLogger3.log(Constants.GPS_ARA_FAILED, bundle);
                        return;
                    }
                    String eventParameters = getEventParameters(event);
                    StringBuilder sb = new StringBuilder();
                    String str = serverUri;
                    if (str == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("serverUri");
                        str = null;
                    }
                    sb.append(str);
                    sb.append('?');
                    sb.append("app_id");
                    sb.append('=');
                    sb.append(applicationId);
                    sb.append('&');
                    sb.append(eventParameters);
                    Uri uri = Uri.parse(sb.toString());
                    Intrinsics.checkNotNullExpressionValue(uri, "parse(\"$serverUri?$appId…=$applicationId&$params\")");
                    measurementManagerA.registerTrigger(uri, FacebookSdk.getExecutor(), androidx.core.os.a.a(new OutcomeReceiver() { // from class: com.facebook.appevents.gps.ara.GpsAraTriggersManager$registerTrigger$outcomeReceiver$1
                        public void onResult(Object result) {
                            Intrinsics.checkNotNullParameter(result, "result");
                            Log.d(GpsAraTriggersManager.access$getTAG$p(), "OUTCOME_RECEIVER_TRIGGER_SUCCESS");
                            GpsDebugLogger gpsDebugLoggerAccess$getGpsDebugLogger$p = GpsAraTriggersManager.access$getGpsDebugLogger$p();
                            if (gpsDebugLoggerAccess$getGpsDebugLogger$p == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("gpsDebugLogger");
                                gpsDebugLoggerAccess$getGpsDebugLogger$p = null;
                            }
                            gpsDebugLoggerAccess$getGpsDebugLogger$p.log(Constants.GPS_ARA_SUCCEED, null);
                        }

                        public void onError(Exception error) {
                            Intrinsics.checkNotNullParameter(error, "error");
                            Log.d(GpsAraTriggersManager.access$getTAG$p(), "OUTCOME_RECEIVER_TRIGGER_FAILURE");
                            GpsDebugLogger gpsDebugLoggerAccess$getGpsDebugLogger$p = GpsAraTriggersManager.access$getGpsDebugLogger$p();
                            if (gpsDebugLoggerAccess$getGpsDebugLogger$p == null) {
                                Intrinsics.throwUninitializedPropertyAccessException(YznnJpHcAmeoW.MmLGBuJ);
                                gpsDebugLoggerAccess$getGpsDebugLogger$p = null;
                            }
                            Bundle bundle2 = new Bundle();
                            bundle2.putString(Constants.GPS_ARA_FAILED_REASON, error.toString());
                            Unit unit2 = Unit.f139807a;
                            gpsDebugLoggerAccess$getGpsDebugLogger$p.log(Constants.GPS_ARA_FAILED, bundle2);
                        }
                    }));
                } catch (Error e3) {
                    Log.w(TAG, "FAILURE_TRIGGER_REGISTRATION_FAILED");
                    GpsDebugLogger gpsDebugLogger4 = gpsDebugLogger;
                    if (gpsDebugLogger4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("gpsDebugLogger");
                    } else {
                        gpsDebugLogger2 = gpsDebugLogger4;
                    }
                    Bundle bundle2 = new Bundle();
                    bundle2.putString(Constants.GPS_ARA_FAILED_REASON, e3.toString());
                    Unit unit2 = Unit.f139807a;
                    gpsDebugLogger2.log(Constants.GPS_ARA_FAILED, bundle2);
                } catch (Exception e4) {
                    Log.w(TAG, "FAILURE_TRIGGER_REGISTRATION_FAILED");
                    GpsDebugLogger gpsDebugLogger5 = gpsDebugLogger;
                    if (gpsDebugLogger5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("gpsDebugLogger");
                    } else {
                        gpsDebugLogger2 = gpsDebugLogger5;
                    }
                    Bundle bundle3 = new Bundle();
                    bundle3.putString(Constants.GPS_ARA_FAILED_REASON, e4.toString());
                    Unit unit3 = Unit.f139807a;
                    gpsDebugLogger2.log(Constants.GPS_ARA_FAILED, bundle3);
                }
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    public final void registerTriggerAsync(final String applicationId, final AppEvent event) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            Intrinsics.checkNotNullParameter(applicationId, "applicationId");
            Intrinsics.checkNotNullParameter(event, "event");
            FacebookSdk.getExecutor().execute(new Runnable() { // from class: com.facebook.appevents.gps.ara.a
                @Override // java.lang.Runnable
                public final void run() {
                    GpsAraTriggersManager.registerTriggerAsync$lambda$0(applicationId, event);
                }
            });
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }
}
