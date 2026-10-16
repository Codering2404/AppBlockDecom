package com.facebook.appevents;

import android.content.Context;
import android.os.Bundle;
import com.facebook.GraphRequest;
import com.facebook.appevents.eventdeactivation.EventDeactivationManager;
import com.facebook.appevents.internal.AppEventsLoggerUtility;
import com.facebook.internal.AttributionIdentifiers;
import com.facebook.internal.FeatureManager;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class SessionEventsState {
    private List<AppEvent> accumulatedEvents;
    private final String anonymousAppDeviceGUID;
    private final AttributionIdentifiers attributionIdentifiers;
    private final List<AppEvent> inFlightEvents;
    private int numSkippedEventsDueToFullBuffer;
    public static final Companion Companion = new Companion(null);
    private static final String TAG = SessionEventsState.class.getSimpleName();
    private static final int MAX_ACCUMULATED_LOG_EVENTS = 1000;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public SessionEventsState(AttributionIdentifiers attributionIdentifiers, String anonymousAppDeviceGUID) {
        Intrinsics.checkNotNullParameter(attributionIdentifiers, "attributionIdentifiers");
        Intrinsics.checkNotNullParameter(anonymousAppDeviceGUID, "anonymousAppDeviceGUID");
        this.attributionIdentifiers = attributionIdentifiers;
        this.anonymousAppDeviceGUID = anonymousAppDeviceGUID;
        this.accumulatedEvents = new ArrayList();
        this.inFlightEvents = new ArrayList();
    }

    public final synchronized void accumulatePersistedEvents(List<AppEvent> events) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            Intrinsics.checkNotNullParameter(events, "events");
            this.accumulatedEvents.addAll(events);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    public final synchronized void addEvent(AppEvent event) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            Intrinsics.checkNotNullParameter(event, "event");
            if (this.accumulatedEvents.size() + this.inFlightEvents.size() >= MAX_ACCUMULATED_LOG_EVENTS) {
                this.numSkippedEventsDueToFullBuffer++;
            } else {
                this.accumulatedEvents.add(event);
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    public final synchronized void clearInFlightAndStats(boolean z2) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        if (!z2) {
            this.inFlightEvents.clear();
            this.numSkippedEventsDueToFullBuffer = 0;
            return;
        }
        try {
            this.accumulatedEvents.addAll(this.inFlightEvents);
            this.inFlightEvents.clear();
            this.numSkippedEventsDueToFullBuffer = 0;
            return;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return;
        }
    }

    public final synchronized int getAccumulatedEventCount() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return 0;
        }
        try {
            return this.accumulatedEvents.size();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return 0;
        }
    }

    public final synchronized List<AppEvent> getEventsToPersist() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            List<AppEvent> list = this.accumulatedEvents;
            this.accumulatedEvents = new ArrayList();
            return list;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    public final int populateRequest(GraphRequest request, Context applicationContext, boolean z2, boolean z3) {
        Throwable th;
        Throwable th2;
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return 0;
        }
        try {
            Intrinsics.checkNotNullParameter(request, "request");
            Intrinsics.checkNotNullParameter(applicationContext, "applicationContext");
            try {
                synchronized (this) {
                    try {
                        int i3 = this.numSkippedEventsDueToFullBuffer;
                        EventDeactivationManager.processEvents(this.accumulatedEvents);
                        this.inFlightEvents.addAll(this.accumulatedEvents);
                        this.accumulatedEvents.clear();
                        JSONArray jSONArray = new JSONArray();
                        JSONArray jSONArray2 = new JSONArray();
                        for (AppEvent appEvent : this.inFlightEvents) {
                            try {
                                if (z2 || !appEvent.isImplicit()) {
                                    jSONArray.put(appEvent.getJsonObject());
                                    jSONArray2.put(appEvent.getOperationalJsonObject());
                                }
                            } catch (Throwable th3) {
                                th2 = th3;
                            }
                        }
                        if (jSONArray.length() != 0) {
                            Unit unit = Unit.f139807a;
                            populateRequest(request, applicationContext, i3, jSONArray, jSONArray2, z3);
                            return jSONArray.length();
                        }
                        try {
                            return 0;
                        } catch (Throwable th4) {
                            th = th4;
                            CrashShieldHandler.handleThrowable(th, this);
                            return 0;
                        }
                    } catch (Throwable th5) {
                        th2 = th5;
                    }
                    throw th2;
                }
            } catch (Throwable th6) {
                th = th6;
                th = th;
                CrashShieldHandler.handleThrowable(th, this);
                return 0;
            }
        } catch (Throwable th7) {
            th = th7;
        }
    }

    private final void populateRequest(GraphRequest graphRequest, Context context, int i3, JSONArray jSONArray, JSONArray jSONArray2, boolean z2) {
        JSONObject jSONObject;
        try {
            if (CrashShieldHandler.isObjectCrashing(this)) {
                return;
            }
            try {
                jSONObject = AppEventsLoggerUtility.getJSONObjectForGraphAPICall(AppEventsLoggerUtility.GraphAPIActivityType.CUSTOM_APP_EVENTS, this.attributionIdentifiers, this.anonymousAppDeviceGUID, z2, context);
                if (this.numSkippedEventsDueToFullBuffer > 0) {
                    jSONObject.put("num_skipped_events", i3);
                }
            } catch (JSONException unused) {
                jSONObject = new JSONObject();
            }
            graphRequest.setGraphObject(jSONObject);
            Bundle parameters = graphRequest.getParameters();
            String string = jSONArray.toString();
            Intrinsics.checkNotNullExpressionValue(string, "events.toString()");
            parameters.putString("custom_events", string);
            if (FeatureManager.isEnabled(FeatureManager.Feature.IapLoggingLib5To7)) {
                parameters.putString("operational_parameters", jSONArray2.toString());
            }
            graphRequest.setTag(string);
            graphRequest.setParameters(parameters);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }
}
