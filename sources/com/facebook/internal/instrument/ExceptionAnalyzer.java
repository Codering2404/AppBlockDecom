package com.facebook.internal.instrument;

import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphRequestBatch;
import com.facebook.GraphResponse;
import com.facebook.internal.FeatureManager;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.ExceptionAnalyzer;
import com.facebook.internal.instrument.InstrumentData;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.json.JSONArray;
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
public final class ExceptionAnalyzer {
    public static final ExceptionAnalyzer INSTANCE = new ExceptionAnalyzer();
    private static boolean enabled;

    private ExceptionAnalyzer() {
    }

    @JvmStatic
    public static final void enable() {
        enabled = true;
        if (FacebookSdk.getAutoLogAppEventsEnabled()) {
            INSTANCE.sendExceptionAnalysisReports$facebook_core_release();
        }
    }

    @JvmStatic
    public static final void execute(Throwable th) {
        if (!enabled || isDebug$facebook_core_release() || th == null) {
            return;
        }
        HashSet hashSet = new HashSet();
        StackTraceElement[] stackTrace = th.getStackTrace();
        Intrinsics.checkNotNullExpressionValue(stackTrace, "e.stackTrace");
        for (StackTraceElement stackTraceElement : stackTrace) {
            String className = stackTraceElement.getClassName();
            Intrinsics.checkNotNullExpressionValue(className, "it.className");
            FeatureManager.Feature feature = FeatureManager.getFeature(className);
            if (feature != FeatureManager.Feature.Unknown) {
                FeatureManager.disableFeature(feature);
                hashSet.add(feature.toString());
            }
        }
        if (!FacebookSdk.getAutoLogAppEventsEnabled() || hashSet.isEmpty()) {
            return;
        }
        InstrumentData.Builder.build(new JSONArray((Collection) hashSet)).save();
    }

    @JvmStatic
    public static final boolean isDebug$facebook_core_release() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sendExceptionAnalysisReports$lambda$1(InstrumentData instrumentData, GraphResponse response) {
        JSONObject jsonObject;
        Intrinsics.checkNotNullParameter(instrumentData, "$instrumentData");
        Intrinsics.checkNotNullParameter(response, "response");
        try {
            if (response.getError() == null && (jsonObject = response.getJsonObject()) != null && jsonObject.getBoolean(GraphResponse.SUCCESS_KEY)) {
                instrumentData.clear();
            }
        } catch (JSONException unused) {
        }
    }

    public final void sendExceptionAnalysisReports$facebook_core_release() {
        if (Utility.isDataProcessingRestricted()) {
            return;
        }
        File[] fileArrListExceptionAnalysisReportFiles = InstrumentUtility.listExceptionAnalysisReportFiles();
        ArrayList arrayList = new ArrayList();
        for (File file : fileArrListExceptionAnalysisReportFiles) {
            final InstrumentData instrumentDataLoad = InstrumentData.Builder.load(file);
            if (instrumentDataLoad.isValid()) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("crash_shield", instrumentDataLoad.toString());
                    GraphRequest.Companion companion = GraphRequest.Companion;
                    StringCompanionObject stringCompanionObject = StringCompanionObject.f140150a;
                    String str = String.format("%s/instruments", Arrays.copyOf(new Object[]{FacebookSdk.getApplicationId()}, 1));
                    Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
                    arrayList.add(companion.newPostRequest(null, str, jSONObject, new GraphRequest.Callback() { // from class: o.a
                        @Override // com.facebook.GraphRequest.Callback
                        public final void onCompleted(GraphResponse graphResponse) {
                            ExceptionAnalyzer.sendExceptionAnalysisReports$lambda$1(instrumentDataLoad, graphResponse);
                        }
                    }));
                } catch (JSONException unused) {
                }
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        new GraphRequestBatch(arrayList).executeAsync();
    }
}
