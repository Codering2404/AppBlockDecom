package com.facebook.appevents.suggestedevents;

import android.os.Bundle;
import android.view.View;
import androidx.datastore.preferences.core.SfRj.rnFwbPAQmQTnL;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.appevents.InternalAppEventsLogger;
import com.facebook.appevents.codeless.internal.ViewHierarchy;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.appevents.ml.ModelManager;
import com.facebook.appevents.suggestedevents.ViewOnClickListener;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class ViewOnClickListener implements View.OnClickListener {
    private static final String API_ENDPOINT = "%s/suggested_events";
    public static final String OTHER_EVENT = "other";
    private final String activityName;
    private final View.OnClickListener baseListener;
    private final WeakReference<View> hostViewWeakReference;
    private final WeakReference<View> rootViewWeakReference;
    public static final Companion Companion = new Companion(null);
    private static final Set<Integer> viewsAttachedListener = new HashSet();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void processPredictedResult(String str, String str2, float[] fArr) {
            if (SuggestedEventsManager.isProductionEvents$facebook_core_release(str)) {
                new InternalAppEventsLogger(FacebookSdk.getApplicationContext()).logEventFromSE(str, str2);
            } else if (SuggestedEventsManager.isEligibleEvents$facebook_core_release(str)) {
                sendPredictedResult(str, str2, fArr);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean queryHistoryAndProcess(String str, final String str2) {
            final String strQueryEvent = PredictionHistoryManager.queryEvent(str);
            if (strQueryEvent == null) {
                return false;
            }
            if (Intrinsics.areEqual(strQueryEvent, "other")) {
                return true;
            }
            Utility.runOnNonUiThread(new Runnable() { // from class: n.d
                @Override // java.lang.Runnable
                public final void run() {
                    ViewOnClickListener.Companion.queryHistoryAndProcess$lambda$0(strQueryEvent, str2);
                }
            });
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void queryHistoryAndProcess$lambda$0(String queriedEvent, String buttonText) {
            Intrinsics.checkNotNullParameter(queriedEvent, "$queriedEvent");
            Intrinsics.checkNotNullParameter(buttonText, "$buttonText");
            ViewOnClickListener.Companion.processPredictedResult(queriedEvent, buttonText, new float[0]);
        }

        @JvmStatic
        public final void attachListener$facebook_core_release(View hostView, View rootView, String activityName) {
            Intrinsics.checkNotNullParameter(hostView, "hostView");
            Intrinsics.checkNotNullParameter(rootView, "rootView");
            Intrinsics.checkNotNullParameter(activityName, "activityName");
            int iHashCode = hostView.hashCode();
            if (ViewOnClickListener.access$getViewsAttachedListener$cp().contains(Integer.valueOf(iHashCode))) {
                return;
            }
            ViewHierarchy.setOnClickListener(hostView, new ViewOnClickListener(hostView, rootView, activityName, null));
            ViewOnClickListener.access$getViewsAttachedListener$cp().add(Integer.valueOf(iHashCode));
        }

        private Companion() {
        }

        private final void sendPredictedResult(String str, String str2, float[] fArr) {
            Bundle bundle = new Bundle();
            try {
                bundle.putString("event_name", str);
                JSONObject jSONObject = new JSONObject();
                StringBuilder sb = new StringBuilder();
                for (float f3 : fArr) {
                    sb.append(f3);
                    sb.append(",");
                }
                jSONObject.put("dense", sb.toString());
                jSONObject.put("button_text", str2);
                bundle.putString("metadata", jSONObject.toString());
                GraphRequest.Companion companion = GraphRequest.Companion;
                StringCompanionObject stringCompanionObject = StringCompanionObject.f140150a;
                String str3 = String.format(Locale.US, rnFwbPAQmQTnL.hoqNhoaK, Arrays.copyOf(new Object[]{FacebookSdk.getApplicationId()}, 1));
                Intrinsics.checkNotNullExpressionValue(str3, "format(locale, format, *args)");
                GraphRequest graphRequestNewPostRequest = companion.newPostRequest(null, str3, null, null);
                graphRequestNewPostRequest.setParameters(bundle);
                graphRequestNewPostRequest.executeAndWait();
            } catch (JSONException unused) {
            }
        }
    }

    public /* synthetic */ ViewOnClickListener(View view, View view2, String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(view, view2, str);
    }

    public static final /* synthetic */ Set access$getViewsAttachedListener$cp() {
        if (CrashShieldHandler.isObjectCrashing(ViewOnClickListener.class)) {
            return null;
        }
        try {
            return viewsAttachedListener;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ViewOnClickListener.class);
            return null;
        }
    }

    @JvmStatic
    public static final void attachListener$facebook_core_release(View view, View view2, String str) {
        if (CrashShieldHandler.isObjectCrashing(ViewOnClickListener.class)) {
            return;
        }
        try {
            Companion.attachListener$facebook_core_release(view, view2, str);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ViewOnClickListener.class);
        }
    }

    private final void predictAndProcess(final String str, final String str2, final JSONObject jSONObject) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            Utility.runOnNonUiThread(new Runnable() { // from class: n.c
                @Override // java.lang.Runnable
                public final void run() {
                    ViewOnClickListener.predictAndProcess$lambda$0(jSONObject, str2, this, str);
                }
            });
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void predictAndProcess$lambda$0(JSONObject viewData, String buttonText, ViewOnClickListener this$0, String pathID) {
        String[] strArrPredict;
        if (CrashShieldHandler.isObjectCrashing(ViewOnClickListener.class)) {
            return;
        }
        try {
            Intrinsics.checkNotNullParameter(viewData, "$viewData");
            Intrinsics.checkNotNullParameter(buttonText, "$buttonText");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(pathID, "$pathID");
            try {
                String lowerCase = Utility.getAppName(FacebookSdk.getApplicationContext()).toLowerCase();
                Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase()");
                float[] denseFeatures = FeatureExtractor.getDenseFeatures(viewData, lowerCase);
                String textFeature = FeatureExtractor.getTextFeature(buttonText, this$0.activityName, lowerCase);
                if (denseFeatures != null && (strArrPredict = ModelManager.predict(ModelManager.Task.MTML_APP_EVENT_PREDICTION, new float[][]{denseFeatures}, new String[]{textFeature})) != null) {
                    String str = strArrPredict[0];
                    PredictionHistoryManager.addPrediction(pathID, str);
                    if (Intrinsics.areEqual(str, "other")) {
                        return;
                    }
                    Companion.processPredictedResult(str, buttonText, denseFeatures);
                }
            } catch (Exception unused) {
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ViewOnClickListener.class);
        }
    }

    private final void process() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            View view = this.rootViewWeakReference.get();
            View view2 = this.hostViewWeakReference.get();
            if (view == null || view2 == null) {
                return;
            }
            try {
                String textOfViewRecursively = SuggestedEventViewHierarchy.getTextOfViewRecursively(view2);
                String pathID = PredictionHistoryManager.getPathID(view2, textOfViewRecursively);
                if (pathID != null && !Companion.queryHistoryAndProcess(pathID, textOfViewRecursively)) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(ViewHierarchyConstants.VIEW_KEY, SuggestedEventViewHierarchy.getDictionaryOfView(view, view2));
                    jSONObject.put(ViewHierarchyConstants.SCREEN_NAME_KEY, this.activityName);
                    predictAndProcess(pathID, textOfViewRecursively, jSONObject);
                }
            } catch (Exception unused) {
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            Intrinsics.checkNotNullParameter(view, "view");
            View.OnClickListener onClickListener = this.baseListener;
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
            process();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    private ViewOnClickListener(View view, View view2, String str) {
        this.baseListener = ViewHierarchy.getExistingOnClickListener(view);
        this.rootViewWeakReference = new WeakReference<>(view2);
        this.hostViewWeakReference = new WeakReference<>(view);
        String lowerCase = str.toLowerCase();
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase()");
        this.activityName = StringsKt.O(lowerCase, "activity", "", false, 4, null);
    }
}
