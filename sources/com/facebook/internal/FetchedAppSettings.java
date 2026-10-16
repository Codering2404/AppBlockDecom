package com.facebook.internal;

import android.net.Uri;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
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
public final class FetchedAppSettings {
    public static final Companion Companion = new Companion(null);
    private final JSONArray MACARuleMatchingSetting;
    private final boolean automaticLoggingEnabled;
    private final JSONArray bannedParams;
    private final JSONArray blocklistEvents;
    private final boolean codelessEventsEnabled;
    private final List<String> currencyDedupeParameters;
    private final Long dedupeWindow;
    private final Map<String, Map<String, DialogFeatureConfig>> dialogConfigurations;
    private final FacebookRequestErrorClassification errorClassification;
    private final JSONArray eventBindings;
    private final boolean iAPAutomaticLoggingEnabled;
    private final Map<String, Boolean> migratedAutoLogValues;
    private final boolean monitorViaDialogEnabled;
    private final String nuxContent;
    private final boolean nuxEnabled;
    private final List<Pair<String, List<String>>> prodDedupeParameters;
    private final JSONArray protectedModeStandardParamsSetting;
    private final List<String> purchaseValueDedupeParameters;
    private final String rawAamRules;
    private final JSONArray redactedEvents;
    private final String restrictiveDataSetting;
    private final JSONArray schemaRestrictions;
    private final String sdkUpdateMessage;
    private final JSONArray sensitiveParams;
    private final int sessionTimeoutInSeconds;
    private final String smartLoginBookmarkIconURL;
    private final String smartLoginMenuIconURL;
    private final EnumSet<SmartLoginOption> smartLoginOptions;
    private final String suggestedEventsSetting;
    private final boolean supportsImplicitLogging;
    private final List<Pair<String, List<String>>> testDedupeParameters;
    private final boolean trackUninstallEnabled;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final DialogFeatureConfig getDialogFeatureConfig(String applicationId, String actionName, String featureName) {
            Map<String, Map<String, DialogFeatureConfig>> dialogConfigurations;
            Intrinsics.checkNotNullParameter(applicationId, "applicationId");
            Intrinsics.checkNotNullParameter(actionName, "actionName");
            Intrinsics.checkNotNullParameter(featureName, "featureName");
            if (actionName.length() == 0 || featureName.length() == 0) {
                return null;
            }
            FetchedAppSettings appSettingsWithoutQuery = FetchedAppSettingsManager.getAppSettingsWithoutQuery(applicationId);
            Map<String, DialogFeatureConfig> map = (appSettingsWithoutQuery == null || (dialogConfigurations = appSettingsWithoutQuery.getDialogConfigurations()) == null) ? null : dialogConfigurations.get(actionName);
            if (map != null) {
                return map.get(featureName);
            }
            return null;
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class DialogFeatureConfig {
        public static final Companion Companion = new Companion(null);
        private static final String DIALOG_CONFIG_DIALOG_NAME_FEATURE_NAME_SEPARATOR = "|";
        private static final String DIALOG_CONFIG_NAME_KEY = "name";
        private static final String DIALOG_CONFIG_URL_KEY = "url";
        private static final String DIALOG_CONFIG_VERSIONS_KEY = "versions";
        private final String dialogName;
        private final Uri fallbackUrl;
        private final String featureName;
        private final int[] versionSpec;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private final int[] parseVersionSpec(JSONArray jSONArray) {
                if (jSONArray == null) {
                    return null;
                }
                int length = jSONArray.length();
                int[] iArr = new int[length];
                for (int i3 = 0; i3 < length; i3++) {
                    int i4 = -1;
                    int iOptInt = jSONArray.optInt(i3, -1);
                    if (iOptInt == -1) {
                        String versionString = jSONArray.optString(i3);
                        if (!Utility.isNullOrEmpty(versionString)) {
                            try {
                                Intrinsics.checkNotNullExpressionValue(versionString, "versionString");
                                i4 = Integer.parseInt(versionString);
                            } catch (NumberFormatException e3) {
                                Utility.logd(Utility.LOG_TAG, e3);
                            }
                            iOptInt = i4;
                        }
                    }
                    iArr[i3] = iOptInt;
                }
                return iArr;
            }

            public final DialogFeatureConfig parseDialogConfig(JSONObject dialogConfigJSON) {
                Intrinsics.checkNotNullParameter(dialogConfigJSON, "dialogConfigJSON");
                String dialogNameWithFeature = dialogConfigJSON.optString("name");
                if (Utility.isNullOrEmpty(dialogNameWithFeature)) {
                    return null;
                }
                Intrinsics.checkNotNullExpressionValue(dialogNameWithFeature, "dialogNameWithFeature");
                List listV0 = StringsKt.V0(dialogNameWithFeature, new String[]{DialogFeatureConfig.DIALOG_CONFIG_DIALOG_NAME_FEATURE_NAME_SEPARATOR}, false, 0, 6, null);
                if (listV0.size() != 2) {
                    return null;
                }
                String str = (String) CollectionsKt.first(listV0);
                String str2 = (String) CollectionsKt.last(listV0);
                if (Utility.isNullOrEmpty(str) || Utility.isNullOrEmpty(str2)) {
                    return null;
                }
                String strOptString = dialogConfigJSON.optString("url");
                return new DialogFeatureConfig(str, str2, Utility.isNullOrEmpty(strOptString) ? null : Uri.parse(strOptString), parseVersionSpec(dialogConfigJSON.optJSONArray(DialogFeatureConfig.DIALOG_CONFIG_VERSIONS_KEY)), null);
            }

            private Companion() {
            }
        }

        public /* synthetic */ DialogFeatureConfig(String str, String str2, Uri uri, int[] iArr, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, uri, iArr);
        }

        public final String getDialogName() {
            return this.dialogName;
        }

        public final Uri getFallbackUrl() {
            return this.fallbackUrl;
        }

        public final String getFeatureName() {
            return this.featureName;
        }

        public final int[] getVersionSpec() {
            return this.versionSpec;
        }

        private DialogFeatureConfig(String str, String str2, Uri uri, int[] iArr) {
            this.dialogName = str;
            this.featureName = str2;
            this.fallbackUrl = uri;
            this.versionSpec = iArr;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FetchedAppSettings(boolean z2, String nuxContent, boolean z3, int i3, EnumSet<SmartLoginOption> smartLoginOptions, Map<String, ? extends Map<String, DialogFeatureConfig>> dialogConfigurations, boolean z4, FacebookRequestErrorClassification errorClassification, String smartLoginBookmarkIconURL, String smartLoginMenuIconURL, boolean z5, boolean z6, JSONArray jSONArray, String sdkUpdateMessage, boolean z7, boolean z8, String str, String str2, String str3, JSONArray jSONArray2, JSONArray jSONArray3, Map<String, Boolean> map, JSONArray jSONArray4, JSONArray jSONArray5, JSONArray jSONArray6, JSONArray jSONArray7, JSONArray jSONArray8, List<String> list, List<String> list2, List<? extends Pair<String, ? extends List<String>>> list3, List<? extends Pair<String, ? extends List<String>>> list4, Long l3) {
        Intrinsics.checkNotNullParameter(nuxContent, "nuxContent");
        Intrinsics.checkNotNullParameter(smartLoginOptions, "smartLoginOptions");
        Intrinsics.checkNotNullParameter(dialogConfigurations, "dialogConfigurations");
        Intrinsics.checkNotNullParameter(errorClassification, "errorClassification");
        Intrinsics.checkNotNullParameter(smartLoginBookmarkIconURL, "smartLoginBookmarkIconURL");
        Intrinsics.checkNotNullParameter(smartLoginMenuIconURL, "smartLoginMenuIconURL");
        Intrinsics.checkNotNullParameter(sdkUpdateMessage, "sdkUpdateMessage");
        this.supportsImplicitLogging = z2;
        this.nuxContent = nuxContent;
        this.nuxEnabled = z3;
        this.sessionTimeoutInSeconds = i3;
        this.smartLoginOptions = smartLoginOptions;
        this.dialogConfigurations = dialogConfigurations;
        this.automaticLoggingEnabled = z4;
        this.errorClassification = errorClassification;
        this.smartLoginBookmarkIconURL = smartLoginBookmarkIconURL;
        this.smartLoginMenuIconURL = smartLoginMenuIconURL;
        this.iAPAutomaticLoggingEnabled = z5;
        this.codelessEventsEnabled = z6;
        this.eventBindings = jSONArray;
        this.sdkUpdateMessage = sdkUpdateMessage;
        this.trackUninstallEnabled = z7;
        this.monitorViaDialogEnabled = z8;
        this.rawAamRules = str;
        this.suggestedEventsSetting = str2;
        this.restrictiveDataSetting = str3;
        this.protectedModeStandardParamsSetting = jSONArray2;
        this.MACARuleMatchingSetting = jSONArray3;
        this.migratedAutoLogValues = map;
        this.blocklistEvents = jSONArray4;
        this.redactedEvents = jSONArray5;
        this.sensitiveParams = jSONArray6;
        this.schemaRestrictions = jSONArray7;
        this.bannedParams = jSONArray8;
        this.currencyDedupeParameters = list;
        this.purchaseValueDedupeParameters = list2;
        this.prodDedupeParameters = list3;
        this.testDedupeParameters = list4;
        this.dedupeWindow = l3;
    }

    @JvmStatic
    public static final DialogFeatureConfig getDialogFeatureConfig(String str, String str2, String str3) {
        return Companion.getDialogFeatureConfig(str, str2, str3);
    }

    public final boolean getAutomaticLoggingEnabled() {
        return this.automaticLoggingEnabled;
    }

    public final JSONArray getBannedParams() {
        return this.bannedParams;
    }

    public final JSONArray getBlocklistEvents() {
        return this.blocklistEvents;
    }

    public final boolean getCodelessEventsEnabled() {
        return this.codelessEventsEnabled;
    }

    public final List<String> getCurrencyDedupeParameters() {
        return this.currencyDedupeParameters;
    }

    public final Long getDedupeWindow() {
        return this.dedupeWindow;
    }

    public final Map<String, Map<String, DialogFeatureConfig>> getDialogConfigurations() {
        return this.dialogConfigurations;
    }

    public final FacebookRequestErrorClassification getErrorClassification() {
        return this.errorClassification;
    }

    public final JSONArray getEventBindings() {
        return this.eventBindings;
    }

    public final boolean getIAPAutomaticLoggingEnabled() {
        return this.iAPAutomaticLoggingEnabled;
    }

    public final JSONArray getMACARuleMatchingSetting() {
        return this.MACARuleMatchingSetting;
    }

    public final Map<String, Boolean> getMigratedAutoLogValues() {
        return this.migratedAutoLogValues;
    }

    public final boolean getMonitorViaDialogEnabled() {
        return this.monitorViaDialogEnabled;
    }

    public final String getNuxContent() {
        return this.nuxContent;
    }

    public final boolean getNuxEnabled() {
        return this.nuxEnabled;
    }

    public final List<Pair<String, List<String>>> getProdDedupeParameters() {
        return this.prodDedupeParameters;
    }

    public final JSONArray getProtectedModeStandardParamsSetting() {
        return this.protectedModeStandardParamsSetting;
    }

    public final List<String> getPurchaseValueDedupeParameters() {
        return this.purchaseValueDedupeParameters;
    }

    public final String getRawAamRules() {
        return this.rawAamRules;
    }

    public final JSONArray getRedactedEvents() {
        return this.redactedEvents;
    }

    public final String getRestrictiveDataSetting() {
        return this.restrictiveDataSetting;
    }

    public final JSONArray getSchemaRestrictions() {
        return this.schemaRestrictions;
    }

    public final String getSdkUpdateMessage() {
        return this.sdkUpdateMessage;
    }

    public final JSONArray getSensitiveParams() {
        return this.sensitiveParams;
    }

    public final int getSessionTimeoutInSeconds() {
        return this.sessionTimeoutInSeconds;
    }

    public final String getSmartLoginBookmarkIconURL() {
        return this.smartLoginBookmarkIconURL;
    }

    public final String getSmartLoginMenuIconURL() {
        return this.smartLoginMenuIconURL;
    }

    public final EnumSet<SmartLoginOption> getSmartLoginOptions() {
        return this.smartLoginOptions;
    }

    public final String getSuggestedEventsSetting() {
        return this.suggestedEventsSetting;
    }

    public final List<Pair<String, List<String>>> getTestDedupeParameters() {
        return this.testDedupeParameters;
    }

    public final boolean getTrackUninstallEnabled() {
        return this.trackUninstallEnabled;
    }

    public final boolean supportsImplicitLogging() {
        return this.supportsImplicitLogging;
    }
}
