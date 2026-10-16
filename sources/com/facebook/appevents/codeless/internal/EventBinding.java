package com.facebook.appevents.codeless.internal;

import com.facebook.GraphRequest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
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
public final class EventBinding {
    public static final Companion Companion = new Companion(null);
    private final String activityName;
    private final String appVersion;
    private final String componentId;
    private final String eventName;
    private final MappingMethod method;
    private final List<ParameterComponent> parameters;
    private final List<PathComponent> path;
    private final String pathType;
    private final ActionType type;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public enum ActionType {
        CLICK,
        SELECTED,
        TEXT_CHANGED
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final EventBinding getInstanceFromJson(JSONObject mapping) throws JSONException, IllegalArgumentException {
            Intrinsics.checkNotNullParameter(mapping, "mapping");
            String eventName = mapping.getString("event_name");
            String string = mapping.getString(GraphRequest.BATCH_METHOD_PARAM);
            Intrinsics.checkNotNullExpressionValue(string, "mapping.getString(\"method\")");
            Locale ENGLISH = Locale.ENGLISH;
            Intrinsics.checkNotNullExpressionValue(ENGLISH, "ENGLISH");
            String upperCase = string.toUpperCase(ENGLISH);
            Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(locale)");
            MappingMethod mappingMethodValueOf = MappingMethod.valueOf(upperCase);
            String string2 = mapping.getString("event_type");
            Intrinsics.checkNotNullExpressionValue(string2, "mapping.getString(\"event_type\")");
            Intrinsics.checkNotNullExpressionValue(ENGLISH, "ENGLISH");
            String upperCase2 = string2.toUpperCase(ENGLISH);
            Intrinsics.checkNotNullExpressionValue(upperCase2, "this as java.lang.String).toUpperCase(locale)");
            ActionType actionTypeValueOf = ActionType.valueOf(upperCase2);
            String appVersion = mapping.getString("app_version");
            JSONArray jSONArray = mapping.getJSONArray("path");
            ArrayList arrayList = new ArrayList();
            int length = jSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                JSONObject jsonPath = jSONArray.getJSONObject(i3);
                Intrinsics.checkNotNullExpressionValue(jsonPath, "jsonPath");
                arrayList.add(new PathComponent(jsonPath));
            }
            String pathType = mapping.optString(Constants.EVENT_MAPPING_PATH_TYPE_KEY, Constants.PATH_TYPE_ABSOLUTE);
            JSONArray jSONArrayOptJSONArray = mapping.optJSONArray("parameters");
            ArrayList arrayList2 = new ArrayList();
            if (jSONArrayOptJSONArray != null) {
                int length2 = jSONArrayOptJSONArray.length();
                for (int i4 = 0; i4 < length2; i4++) {
                    JSONObject jsonParameter = jSONArrayOptJSONArray.getJSONObject(i4);
                    Intrinsics.checkNotNullExpressionValue(jsonParameter, "jsonParameter");
                    arrayList2.add(new ParameterComponent(jsonParameter));
                }
            }
            String componentId = mapping.optString("component_id");
            String activityName = mapping.optString("activity_name");
            Intrinsics.checkNotNullExpressionValue(eventName, "eventName");
            Intrinsics.checkNotNullExpressionValue(appVersion, "appVersion");
            Intrinsics.checkNotNullExpressionValue(componentId, "componentId");
            Intrinsics.checkNotNullExpressionValue(pathType, "pathType");
            Intrinsics.checkNotNullExpressionValue(activityName, "activityName");
            return new EventBinding(eventName, mappingMethodValueOf, actionTypeValueOf, appVersion, arrayList, arrayList2, componentId, pathType, activityName);
        }

        @JvmStatic
        public final List<EventBinding> parseArray(JSONArray jSONArray) {
            ArrayList arrayList = new ArrayList();
            if (jSONArray != null) {
                try {
                    int length = jSONArray.length();
                    for (int i3 = 0; i3 < length; i3++) {
                        JSONObject jSONObject = jSONArray.getJSONObject(i3);
                        Intrinsics.checkNotNullExpressionValue(jSONObject, "array.getJSONObject(i)");
                        arrayList.add(getInstanceFromJson(jSONObject));
                    }
                } catch (IllegalArgumentException | JSONException unused) {
                }
            }
            return arrayList;
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public enum MappingMethod {
        MANUAL,
        INFERENCE
    }

    public EventBinding(String eventName, MappingMethod method, ActionType type, String appVersion, List<PathComponent> path, List<ParameterComponent> parameters, String componentId, String pathType, String activityName) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(appVersion, "appVersion");
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        Intrinsics.checkNotNullParameter(componentId, "componentId");
        Intrinsics.checkNotNullParameter(pathType, "pathType");
        Intrinsics.checkNotNullParameter(activityName, "activityName");
        this.eventName = eventName;
        this.method = method;
        this.type = type;
        this.appVersion = appVersion;
        this.path = path;
        this.parameters = parameters;
        this.componentId = componentId;
        this.pathType = pathType;
        this.activityName = activityName;
    }

    @JvmStatic
    public static final EventBinding getInstanceFromJson(JSONObject jSONObject) throws JSONException, IllegalArgumentException {
        return Companion.getInstanceFromJson(jSONObject);
    }

    @JvmStatic
    public static final List<EventBinding> parseArray(JSONArray jSONArray) {
        return Companion.parseArray(jSONArray);
    }

    public final String getActivityName() {
        return this.activityName;
    }

    public final String getAppVersion() {
        return this.appVersion;
    }

    public final String getComponentId() {
        return this.componentId;
    }

    public final String getEventName() {
        return this.eventName;
    }

    public final MappingMethod getMethod() {
        return this.method;
    }

    public final String getPathType() {
        return this.pathType;
    }

    public final ActionType getType() {
        return this.type;
    }

    public final List<ParameterComponent> getViewParameters() {
        List<ParameterComponent> listUnmodifiableList = Collections.unmodifiableList(this.parameters);
        Intrinsics.checkNotNullExpressionValue(listUnmodifiableList, "unmodifiableList(parameters)");
        return listUnmodifiableList;
    }

    public final List<PathComponent> getViewPath() {
        List<PathComponent> listUnmodifiableList = Collections.unmodifiableList(this.path);
        Intrinsics.checkNotNullExpressionValue(listUnmodifiableList, "unmodifiableList(path)");
        return listUnmodifiableList;
    }
}
