package com.facebook.appevents;

import android.os.Bundle;
import androidx.appcompat.app.jE.vxrlPPpdv;
import com.facebook.FacebookException;
import com.facebook.LoggingBehavior;
import com.facebook.appevents.eventdeactivation.EventDeactivationManager;
import com.facebook.appevents.integrity.IntegrityManager;
import com.facebook.appevents.integrity.RedactedEventsManager;
import com.facebook.appevents.internal.Constants;
import com.facebook.appevents.restrictivedatafilter.RestrictiveDataManager;
import com.facebook.internal.Logger;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.Regex;
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
public final class AppEvent implements Serializable {
    private static final int MAX_IDENTIFIER_LENGTH = 40;
    private static final long serialVersionUID = 1;
    private final boolean inBackground;
    private final boolean isImplicit;
    private final JSONObject jsonObject;
    private final String name;
    private final JSONObject operationalJsonObject;
    public static final Companion Companion = new Companion(null);
    private static final HashSet<String> validatedIdentifiers = new HashSet<>();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void validateIdentifier(String identifier) {
            boolean zContains;
            Intrinsics.checkNotNullParameter(identifier, "identifier");
            if (identifier.length() == 0 || identifier.length() > 40) {
                StringCompanionObject stringCompanionObject = StringCompanionObject.f140150a;
                String str = String.format(Locale.ROOT, "Identifier '%s' must be less than %d characters", Arrays.copyOf(new Object[]{identifier, 40}, 2));
                Intrinsics.checkNotNullExpressionValue(str, "format(locale, format, *args)");
                throw new FacebookException(str);
            }
            synchronized (AppEvent.validatedIdentifiers) {
                zContains = AppEvent.validatedIdentifiers.contains(identifier);
                Unit unit = Unit.f139807a;
            }
            if (zContains) {
                return;
            }
            if (new Regex("^[0-9a-zA-Z_]+[0-9a-zA-Z _-]*$").k(identifier)) {
                synchronized (AppEvent.validatedIdentifiers) {
                    AppEvent.validatedIdentifiers.add(identifier);
                }
            } else {
                StringCompanionObject stringCompanionObject2 = StringCompanionObject.f140150a;
                String str2 = String.format("Skipping event named '%s' due to illegal name - must be under 40 chars and alphanumeric, _, - or space, and not start with a space or hyphen.", Arrays.copyOf(new Object[]{identifier}, 1));
                Intrinsics.checkNotNullExpressionValue(str2, "format(format, *args)");
                throw new FacebookException(str2);
            }
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class SerializationProxyV2 implements Serializable {
        public static final Companion Companion = new Companion(null);
        private static final long serialVersionUID = 20160803001L;
        private final boolean inBackground;
        private final boolean isImplicit;
        private final String jsonString;
        private final String operationalJsonString;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }

        public SerializationProxyV2(String jsonString, String operationalJsonString, boolean z2, boolean z3) {
            Intrinsics.checkNotNullParameter(jsonString, "jsonString");
            Intrinsics.checkNotNullParameter(operationalJsonString, "operationalJsonString");
            this.jsonString = jsonString;
            this.operationalJsonString = operationalJsonString;
            this.isImplicit = z2;
            this.inBackground = z3;
        }

        private final Object readResolve() throws ObjectStreamException, JSONException {
            return new AppEvent(this.jsonString, this.operationalJsonString, this.isImplicit, this.inBackground, null);
        }
    }

    public /* synthetic */ AppEvent(String str, String str2, boolean z2, boolean z3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, z2, z3);
    }

    private final Map<String, String> validateParameters(Bundle bundle, boolean z2) {
        HashMap map = new HashMap();
        for (String key : bundle.keySet()) {
            Companion companion = Companion;
            Intrinsics.checkNotNullExpressionValue(key, "key");
            companion.validateIdentifier(key);
            Object obj = bundle.get(key);
            if (!(obj instanceof String) && !(obj instanceof Number)) {
                StringCompanionObject stringCompanionObject = StringCompanionObject.f140150a;
                String str = String.format("Parameter value '%s' for key '%s' should be a string or a numeric type.", Arrays.copyOf(new Object[]{obj, key}, 2));
                Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
                throw new FacebookException(str);
            }
            map.put(key, obj.toString());
        }
        if (!z2) {
            IntegrityManager.processParameters(map);
            RestrictiveDataManager.processParameters(TypeIntrinsics.d(map), this.name);
            EventDeactivationManager.processDeprecatedParameters(TypeIntrinsics.d(map), this.name);
        }
        return map;
    }

    static /* synthetic */ Map validateParameters$default(AppEvent appEvent, Bundle bundle, boolean z2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z2 = false;
        }
        return appEvent.validateParameters(bundle, z2);
    }

    private final Object writeReplace() throws ObjectStreamException {
        String string = this.jsonObject.toString();
        Intrinsics.checkNotNullExpressionValue(string, "jsonObject.toString()");
        String string2 = this.operationalJsonObject.toString();
        Intrinsics.checkNotNullExpressionValue(string2, "operationalJsonObject.toString()");
        return new SerializationProxyV2(string, string2, this.isImplicit, this.inBackground);
    }

    public final boolean getIsImplicit() {
        return this.isImplicit;
    }

    public final JSONObject getJSONObject() {
        return this.jsonObject;
    }

    public final JSONObject getJsonObject() {
        return this.jsonObject;
    }

    public final String getName() {
        return this.name;
    }

    public final JSONObject getOperationalJSONObject() {
        return this.operationalJsonObject;
    }

    public final JSONObject getOperationalJsonObject() {
        return this.operationalJsonObject;
    }

    public final boolean isImplicit() {
        return this.isImplicit;
    }

    public String toString() {
        StringCompanionObject stringCompanionObject = StringCompanionObject.f140150a;
        String str = String.format("\"%s\", implicit: %b, json: %s", Arrays.copyOf(new Object[]{this.jsonObject.optString(Constants.EVENT_NAME_EVENT_KEY), Boolean.valueOf(this.isImplicit), this.jsonObject.toString()}, 3));
        Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
        return str;
    }

    public /* synthetic */ AppEvent(String str, String str2, Double d3, Bundle bundle, boolean z2, boolean z3, UUID uuid, OperationalData operationalData, int i3, DefaultConstructorMarker defaultConstructorMarker) throws JSONException, FacebookException {
        this(str, str2, d3, bundle, z2, z3, uuid, (i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? null : operationalData);
    }

    private final JSONObject getJSONObjectForAppEvent(String str, String str2, Double d3, Bundle bundle, UUID uuid) throws JSONException {
        Companion.validateIdentifier(str2);
        JSONObject jSONObject = new JSONObject();
        String strProcessEvent = RestrictiveDataManager.processEvent(str2);
        if (Intrinsics.areEqual(strProcessEvent, str2)) {
            strProcessEvent = RedactedEventsManager.processEventsRedaction(str2);
        }
        jSONObject.put(Constants.EVENT_NAME_EVENT_KEY, strProcessEvent);
        jSONObject.put(Constants.LOG_TIME_APP_EVENT_KEY, System.currentTimeMillis() / ((long) 1000));
        jSONObject.put("_ui", str);
        if (uuid != null) {
            jSONObject.put("_session_id", uuid);
        }
        if (bundle != null) {
            Map mapValidateParameters$default = validateParameters$default(this, bundle, false, 2, null);
            for (String str3 : mapValidateParameters$default.keySet()) {
                jSONObject.put(str3, mapValidateParameters$default.get(str3));
            }
        }
        if (d3 != null) {
            jSONObject.put(AppEventsConstants.EVENT_PARAM_VALUE_TO_SUM, d3.doubleValue());
        }
        if (this.inBackground) {
            jSONObject.put(vxrlPPpdv.tDsmVgOMCx, AppEventsConstants.EVENT_PARAM_VALUE_YES);
        }
        if (this.isImplicit) {
            jSONObject.put("_implicitlyLogged", AppEventsConstants.EVENT_PARAM_VALUE_YES);
            return jSONObject;
        }
        Logger.Companion companion = Logger.Companion;
        LoggingBehavior loggingBehavior = LoggingBehavior.APP_EVENTS;
        String string = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(string, "eventObject.toString()");
        companion.log(loggingBehavior, "AppEvents", "Created app event '%s'", string);
        return jSONObject;
    }

    public final JSONObject getOperationalJSONObject(OperationalDataEnum type) {
        Intrinsics.checkNotNullParameter(type, "type");
        return this.operationalJsonObject.optJSONObject(type.getValue());
    }

    public AppEvent(String contextName, String eventName, Double d3, Bundle bundle, boolean z2, boolean z3, UUID uuid, OperationalData operationalData) throws JSONException, FacebookException {
        JSONObject json;
        Intrinsics.checkNotNullParameter(contextName, "contextName");
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        this.isImplicit = z2;
        this.inBackground = z3;
        this.name = eventName;
        this.operationalJsonObject = (operationalData == null || (json = operationalData.toJSON()) == null) ? new JSONObject() : json;
        this.jsonObject = getJSONObjectForAppEvent(contextName, eventName, d3, bundle, uuid);
    }

    private AppEvent(String str, String str2, boolean z2, boolean z3) {
        JSONObject jSONObject = new JSONObject(str);
        this.jsonObject = jSONObject;
        this.operationalJsonObject = new JSONObject(str2);
        this.isImplicit = z2;
        String strOptString = jSONObject.optString(Constants.EVENT_NAME_EVENT_KEY);
        Intrinsics.checkNotNullExpressionValue(strOptString, "jsonObject.optString(Con…nts.EVENT_NAME_EVENT_KEY)");
        this.name = strOptString;
        this.inBackground = z3;
    }
}
