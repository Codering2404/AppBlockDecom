package com.revenuecat.purchases.common.workflows;

import com.revenuecat.purchases.paywalls.components.common.ComponentsConfig;
import com.revenuecat.purchases.paywalls.components.common.ComponentsConfig$$serializer;
import com.revenuecat.purchases.paywalls.components.common.LocaleId;
import com.revenuecat.purchases.paywalls.components.common.LocaleId$$serializer;
import com.revenuecat.purchases.paywalls.components.common.LocalizationData;
import com.revenuecat.purchases.paywalls.components.common.LocalizationKey;
import com.revenuecat.purchases.paywalls.components.common.LocalizationKey$$serializer;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.revenuecat.purchases.utils.serializers.URLSerializer;
import com.sun.jna.Function;
import java.net.URL;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.LinkedHashMapSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonObjectSerializer;

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
/* JADX INFO: loaded from: classes5.dex */
@Metadata
@Serializable
public final class WorkflowScreen {
    private final URL assetBaseURL;
    private final ComponentsConfig componentsConfig;
    private final Map<LocaleId, Map<LocalizationKey, LocalizationData>> componentsLocalizations;
    private final JsonObject config;
    private final String defaultLocaleIdentifier;
    private final String name;
    private final String offeringIdentifier;
    private final int revision;
    private final String templateName;
    public static final Companion Companion = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {null, null, null, null, null, new LinkedHashMapSerializer(LocaleId$$serializer.INSTANCE, new LinkedHashMapSerializer(LocalizationKey$$serializer.INSTANCE, LocalizationData.Companion.serializer())), null, null, null};

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<WorkflowScreen> serializer() {
            return WorkflowScreen$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    @Deprecated
    public /* synthetic */ WorkflowScreen(int i3, String str, @SerialName String str2, int i4, @SerialName @Serializable(with = URLSerializer.class) URL url, @SerialName ComponentsConfig componentsConfig, @SerialName Map map, @SerialName String str3, @SerialName JsonObject jsonObject, @SerialName String str4, SerializationConstructorMarker serializationConstructorMarker, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, str, str2, i4, url, componentsConfig, (Map<LocaleId, ? extends Map<LocalizationKey, ? extends LocalizationData>>) map, str3, jsonObject, str4, serializationConstructorMarker);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: copy-5c8MF7E$default, reason: not valid java name */
    public static /* synthetic */ WorkflowScreen m559copy5c8MF7E$default(WorkflowScreen workflowScreen, String str, String str2, int i3, URL url, ComponentsConfig componentsConfig, Map map, String str3, JsonObject jsonObject, String str4, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            str = workflowScreen.name;
        }
        if ((i4 & 2) != 0) {
            str2 = workflowScreen.templateName;
        }
        if ((i4 & 4) != 0) {
            i3 = workflowScreen.revision;
        }
        if ((i4 & 8) != 0) {
            url = workflowScreen.assetBaseURL;
        }
        if ((i4 & 16) != 0) {
            componentsConfig = workflowScreen.componentsConfig;
        }
        if ((i4 & 32) != 0) {
            map = workflowScreen.componentsLocalizations;
        }
        if ((i4 & 64) != 0) {
            str3 = workflowScreen.defaultLocaleIdentifier;
        }
        if ((i4 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0) {
            jsonObject = workflowScreen.config;
        }
        if ((i4 & Function.MAX_NARGS) != 0) {
            str4 = workflowScreen.offeringIdentifier;
        }
        JsonObject jsonObject2 = jsonObject;
        String str5 = str4;
        Map map2 = map;
        String str6 = str3;
        ComponentsConfig componentsConfig2 = componentsConfig;
        int i5 = i3;
        return workflowScreen.m562copy5c8MF7E(str, str2, i5, url, componentsConfig2, map2, str6, jsonObject2, str5);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(WorkflowScreen workflowScreen, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        KSerializer<Object>[] kSerializerArr = $childSerializers;
        if (compositeEncoder.z(serialDescriptor, 0) || workflowScreen.name != null) {
            compositeEncoder.i(serialDescriptor, 0, StringSerializer.f142891a, workflowScreen.name);
        }
        compositeEncoder.y(serialDescriptor, 1, workflowScreen.templateName);
        if (compositeEncoder.z(serialDescriptor, 2) || workflowScreen.revision != 0) {
            compositeEncoder.w(serialDescriptor, 2, workflowScreen.revision);
        }
        compositeEncoder.C(serialDescriptor, 3, URLSerializer.INSTANCE, workflowScreen.assetBaseURL);
        compositeEncoder.C(serialDescriptor, 4, ComponentsConfig$$serializer.INSTANCE, workflowScreen.componentsConfig);
        compositeEncoder.C(serialDescriptor, 5, kSerializerArr[5], workflowScreen.componentsLocalizations);
        compositeEncoder.C(serialDescriptor, 6, LocaleId$$serializer.INSTANCE, LocaleId.m612boximpl(workflowScreen.defaultLocaleIdentifier));
        if (compositeEncoder.z(serialDescriptor, 7) || !Intrinsics.areEqual(workflowScreen.config, new JsonObject(MapsKt.emptyMap()))) {
            compositeEncoder.C(serialDescriptor, 7, JsonObjectSerializer.f143027a, workflowScreen.config);
        }
        if (!compositeEncoder.z(serialDescriptor, 8) && workflowScreen.offeringIdentifier == null) {
            return;
        }
        compositeEncoder.i(serialDescriptor, 8, StringSerializer.f142891a, workflowScreen.offeringIdentifier);
    }

    public final String component1() {
        return this.name;
    }

    public final String component2() {
        return this.templateName;
    }

    public final int component3() {
        return this.revision;
    }

    public final URL component4() {
        return this.assetBaseURL;
    }

    public final ComponentsConfig component5() {
        return this.componentsConfig;
    }

    public final Map<LocaleId, Map<LocalizationKey, LocalizationData>> component6() {
        return this.componentsLocalizations;
    }

    /* JADX INFO: renamed from: component7-uqtKvyA, reason: not valid java name */
    public final String m561component7uqtKvyA() {
        return this.defaultLocaleIdentifier;
    }

    public final JsonObject component8() {
        return this.config;
    }

    public final String component9() {
        return this.offeringIdentifier;
    }

    /* JADX INFO: renamed from: copy-5c8MF7E, reason: not valid java name */
    public final WorkflowScreen m562copy5c8MF7E(String str, String templateName, int i3, URL assetBaseURL, ComponentsConfig componentsConfig, Map<LocaleId, ? extends Map<LocalizationKey, ? extends LocalizationData>> componentsLocalizations, String defaultLocaleIdentifier, JsonObject config, String str2) {
        Intrinsics.checkNotNullParameter(templateName, "templateName");
        Intrinsics.checkNotNullParameter(assetBaseURL, "assetBaseURL");
        Intrinsics.checkNotNullParameter(componentsConfig, "componentsConfig");
        Intrinsics.checkNotNullParameter(componentsLocalizations, "componentsLocalizations");
        Intrinsics.checkNotNullParameter(defaultLocaleIdentifier, "defaultLocaleIdentifier");
        Intrinsics.checkNotNullParameter(config, "config");
        return new WorkflowScreen(str, templateName, i3, assetBaseURL, componentsConfig, componentsLocalizations, defaultLocaleIdentifier, config, str2, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WorkflowScreen)) {
            return false;
        }
        WorkflowScreen workflowScreen = (WorkflowScreen) obj;
        return Intrinsics.areEqual(this.name, workflowScreen.name) && Intrinsics.areEqual(this.templateName, workflowScreen.templateName) && this.revision == workflowScreen.revision && Intrinsics.areEqual(this.assetBaseURL, workflowScreen.assetBaseURL) && Intrinsics.areEqual(this.componentsConfig, workflowScreen.componentsConfig) && Intrinsics.areEqual(this.componentsLocalizations, workflowScreen.componentsLocalizations) && LocaleId.m615equalsimpl0(this.defaultLocaleIdentifier, workflowScreen.defaultLocaleIdentifier) && Intrinsics.areEqual(this.config, workflowScreen.config) && Intrinsics.areEqual(this.offeringIdentifier, workflowScreen.offeringIdentifier);
    }

    public final URL getAssetBaseURL() {
        return this.assetBaseURL;
    }

    public final ComponentsConfig getComponentsConfig() {
        return this.componentsConfig;
    }

    public final Map<LocaleId, Map<LocalizationKey, LocalizationData>> getComponentsLocalizations() {
        return this.componentsLocalizations;
    }

    public final JsonObject getConfig() {
        return this.config;
    }

    /* JADX INFO: renamed from: getDefaultLocaleIdentifier-uqtKvyA, reason: not valid java name */
    public final String m563getDefaultLocaleIdentifieruqtKvyA() {
        return this.defaultLocaleIdentifier;
    }

    public final String getName() {
        return this.name;
    }

    public final String getOfferingIdentifier() {
        return this.offeringIdentifier;
    }

    public final int getRevision() {
        return this.revision;
    }

    public final String getTemplateName() {
        return this.templateName;
    }

    public int hashCode() {
        String str = this.name;
        int iHashCode = (((((((((((((((str == null ? 0 : str.hashCode()) * 31) + this.templateName.hashCode()) * 31) + Integer.hashCode(this.revision)) * 31) + this.assetBaseURL.hashCode()) * 31) + this.componentsConfig.hashCode()) * 31) + this.componentsLocalizations.hashCode()) * 31) + LocaleId.m616hashCodeimpl(this.defaultLocaleIdentifier)) * 31) + this.config.hashCode()) * 31;
        String str2 = this.offeringIdentifier;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "WorkflowScreen(name=" + this.name + ", templateName=" + this.templateName + ", revision=" + this.revision + ", assetBaseURL=" + this.assetBaseURL + ", componentsConfig=" + this.componentsConfig + ", componentsLocalizations=" + this.componentsLocalizations + ", defaultLocaleIdentifier=" + ((Object) LocaleId.m617toStringimpl(this.defaultLocaleIdentifier)) + ", config=" + this.config + ", offeringIdentifier=" + this.offeringIdentifier + ')';
    }

    public /* synthetic */ WorkflowScreen(String str, String str2, int i3, URL url, ComponentsConfig componentsConfig, Map map, String str3, JsonObject jsonObject, String str4, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, i3, url, componentsConfig, map, str3, jsonObject, str4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private WorkflowScreen(int i3, String str, String str2, int i4, URL url, ComponentsConfig componentsConfig, Map<LocaleId, ? extends Map<LocalizationKey, ? extends LocalizationData>> map, String str3, JsonObject jsonObject, String str4, SerializationConstructorMarker serializationConstructorMarker) {
        if (122 != (i3 & 122)) {
            PluginExceptionsKt.b(i3, 122, WorkflowScreen$$serializer.INSTANCE.getDescriptor());
        }
        if ((i3 & 1) == 0) {
            this.name = null;
        } else {
            this.name = str;
        }
        this.templateName = str2;
        if ((i3 & 4) == 0) {
            this.revision = 0;
        } else {
            this.revision = i4;
        }
        this.assetBaseURL = url;
        this.componentsConfig = componentsConfig;
        this.componentsLocalizations = map;
        this.defaultLocaleIdentifier = str3;
        if ((i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) == 0) {
            this.config = new JsonObject(MapsKt.emptyMap());
        } else {
            this.config = jsonObject;
        }
        if ((i3 & Function.MAX_NARGS) == 0) {
            this.offeringIdentifier = null;
        } else {
            this.offeringIdentifier = str4;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private WorkflowScreen(String str, String templateName, int i3, URL assetBaseURL, ComponentsConfig componentsConfig, Map<LocaleId, ? extends Map<LocalizationKey, ? extends LocalizationData>> componentsLocalizations, String defaultLocaleIdentifier, JsonObject config, String str2) {
        Intrinsics.checkNotNullParameter(templateName, "templateName");
        Intrinsics.checkNotNullParameter(assetBaseURL, "assetBaseURL");
        Intrinsics.checkNotNullParameter(componentsConfig, "componentsConfig");
        Intrinsics.checkNotNullParameter(componentsLocalizations, "componentsLocalizations");
        Intrinsics.checkNotNullParameter(defaultLocaleIdentifier, "defaultLocaleIdentifier");
        Intrinsics.checkNotNullParameter(config, "config");
        this.name = str;
        this.templateName = templateName;
        this.revision = i3;
        this.assetBaseURL = assetBaseURL;
        this.componentsConfig = componentsConfig;
        this.componentsLocalizations = componentsLocalizations;
        this.defaultLocaleIdentifier = defaultLocaleIdentifier;
        this.config = config;
        this.offeringIdentifier = str2;
    }

    @SerialName
    @Serializable(with = URLSerializer.class)
    public static /* synthetic */ void getAssetBaseURL$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getComponentsConfig$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getComponentsLocalizations$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getConfig$annotations() {
    }

    @SerialName
    /* JADX INFO: renamed from: getDefaultLocaleIdentifier-uqtKvyA$annotations, reason: not valid java name */
    public static /* synthetic */ void m560getDefaultLocaleIdentifieruqtKvyA$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getOfferingIdentifier$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getTemplateName$annotations() {
    }

    public /* synthetic */ WorkflowScreen(String str, String str2, int i3, URL url, ComponentsConfig componentsConfig, Map map, String str3, JsonObject jsonObject, String str4, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? null : str, str2, (i4 & 4) != 0 ? 0 : i3, url, componentsConfig, map, str3, (i4 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? new JsonObject(MapsKt.emptyMap()) : jsonObject, (i4 & Function.MAX_NARGS) != 0 ? null : str4, null);
    }
}
