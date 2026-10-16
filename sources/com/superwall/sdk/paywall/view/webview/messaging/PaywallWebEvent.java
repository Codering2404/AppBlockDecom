package com.superwall.sdk.paywall.view.webview.messaging;

import android.net.Uri;
import androidx.media3.common.JBEE.bfIdKSjLOVjG;
import com.superwall.sdk.models.paywall.LocalNotification;
import com.superwall.sdk.paywall.presentation.CustomCallbackBehavior;
import com.superwall.sdk.permissions.PermissionType;
import java.lang.annotation.Annotation;
import java.net.URI;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.comparisons.xn.YvFRmou;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SealedClassSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.json.JsonObject;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@Serializable
public abstract class PaywallWebEvent {
    public static final Companion Companion = new Companion(null);
    private static final Lazy<KSerializer<Object>> $cachedSerializer$delegate = LazyKt.a(LazyThreadSafetyMode.f139762b, new Function0() { // from class: com.superwall.sdk.paywall.view.webview.messaging.h
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return PaywallWebEvent._init_$_anonymous_();
        }
    });

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Closed extends PaywallWebEvent {
        public static final Closed INSTANCE = new Closed();

        private Closed() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        private Companion() {
        }

        private final /* synthetic */ KSerializer get$cachedSerializer() {
            return (KSerializer) PaywallWebEvent.$cachedSerializer$delegate.getValue();
        }

        public final KSerializer<PaywallWebEvent> serializer() {
            return get$cachedSerializer();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @SerialName
    @Metadata
    public static final class Custom extends PaywallWebEvent {
        private final String string;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Custom(String string) {
            super(null);
            Intrinsics.checkNotNullParameter(string, "string");
            this.string = string;
        }

        public static /* synthetic */ Custom copy$default(Custom custom, String str, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = custom.string;
            }
            return custom.copy(str);
        }

        public final String component1() {
            return this.string;
        }

        public final Custom copy(String string) {
            Intrinsics.checkNotNullParameter(string, "string");
            return new Custom(string);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Custom) && Intrinsics.areEqual(this.string, ((Custom) obj).string);
        }

        public final String getString() {
            return this.string;
        }

        public int hashCode() {
            return this.string.hashCode();
        }

        public String toString() {
            return "Custom(string=" + this.string + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @SerialName
    @Metadata
    public static final class CustomPlacement extends PaywallWebEvent {
        private final String name;
        private final JsonObject params;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CustomPlacement(String name, JsonObject params) {
            super(null);
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(params, "params");
            this.name = name;
            this.params = params;
        }

        public static /* synthetic */ CustomPlacement copy$default(CustomPlacement customPlacement, String str, JsonObject jsonObject, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = customPlacement.name;
            }
            if ((i3 & 2) != 0) {
                jsonObject = customPlacement.params;
            }
            return customPlacement.copy(str, jsonObject);
        }

        public final String component1() {
            return this.name;
        }

        public final JsonObject component2() {
            return this.params;
        }

        public final CustomPlacement copy(String name, JsonObject params) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(params, "params");
            return new CustomPlacement(name, params);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof CustomPlacement)) {
                return false;
            }
            CustomPlacement customPlacement = (CustomPlacement) obj;
            return Intrinsics.areEqual(this.name, customPlacement.name) && Intrinsics.areEqual(this.params, customPlacement.params);
        }

        public final String getName() {
            return this.name;
        }

        public final JsonObject getParams() {
            return this.params;
        }

        public int hashCode() {
            return (this.name.hashCode() * 31) + this.params.hashCode();
        }

        public String toString() {
            return "CustomPlacement(name=" + this.name + ", params=" + this.params + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @SerialName
    @Metadata
    public static final class InitiatePurchase extends PaywallWebEvent {
        private final String productId;
        private final boolean shouldDismiss;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public InitiatePurchase(String productId, boolean z2) {
            super(null);
            Intrinsics.checkNotNullParameter(productId, "productId");
            this.productId = productId;
            this.shouldDismiss = z2;
        }

        public static /* synthetic */ InitiatePurchase copy$default(InitiatePurchase initiatePurchase, String str, boolean z2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = initiatePurchase.productId;
            }
            if ((i3 & 2) != 0) {
                z2 = initiatePurchase.shouldDismiss;
            }
            return initiatePurchase.copy(str, z2);
        }

        public final String component1() {
            return this.productId;
        }

        public final boolean component2() {
            return this.shouldDismiss;
        }

        public final InitiatePurchase copy(String productId, boolean z2) {
            Intrinsics.checkNotNullParameter(productId, "productId");
            return new InitiatePurchase(productId, z2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof InitiatePurchase)) {
                return false;
            }
            InitiatePurchase initiatePurchase = (InitiatePurchase) obj;
            return Intrinsics.areEqual(this.productId, initiatePurchase.productId) && this.shouldDismiss == initiatePurchase.shouldDismiss;
        }

        public final String getProductId() {
            return this.productId;
        }

        public final boolean getShouldDismiss() {
            return this.shouldDismiss;
        }

        public int hashCode() {
            return (this.productId.hashCode() * 31) + Boolean.hashCode(this.shouldDismiss);
        }

        public String toString() {
            return "InitiatePurchase(productId=" + this.productId + ", shouldDismiss=" + this.shouldDismiss + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class InitiateRestore extends PaywallWebEvent {
        public static final InitiateRestore INSTANCE = new InitiateRestore();

        private InitiateRestore() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @SerialName
    @Metadata
    public static final class OpenedDeepLink extends PaywallWebEvent {
        private final Uri url;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OpenedDeepLink(Uri url) {
            super(null);
            Intrinsics.checkNotNullParameter(url, "url");
            this.url = url;
        }

        public static /* synthetic */ OpenedDeepLink copy$default(OpenedDeepLink openedDeepLink, Uri uri, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                uri = openedDeepLink.url;
            }
            return openedDeepLink.copy(uri);
        }

        public final Uri component1() {
            return this.url;
        }

        public final OpenedDeepLink copy(Uri url) {
            Intrinsics.checkNotNullParameter(url, "url");
            return new OpenedDeepLink(url);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OpenedDeepLink) && Intrinsics.areEqual(this.url, ((OpenedDeepLink) obj).url);
        }

        public final Uri getUrl() {
            return this.url;
        }

        public int hashCode() {
            return this.url.hashCode();
        }

        public String toString() {
            return "OpenedDeepLink(url=" + this.url + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @SerialName
    @Metadata
    public static final class OpenedURL extends PaywallWebEvent {
        private final URI url;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OpenedURL(URI url) {
            super(null);
            Intrinsics.checkNotNullParameter(url, "url");
            this.url = url;
        }

        public static /* synthetic */ OpenedURL copy$default(OpenedURL openedURL, URI uri, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                uri = openedURL.url;
            }
            return openedURL.copy(uri);
        }

        public final URI component1() {
            return this.url;
        }

        public final OpenedURL copy(URI url) {
            Intrinsics.checkNotNullParameter(url, "url");
            return new OpenedURL(url);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OpenedURL) && Intrinsics.areEqual(this.url, ((OpenedURL) obj).url);
        }

        public final URI getUrl() {
            return this.url;
        }

        public int hashCode() {
            return this.url.hashCode();
        }

        public String toString() {
            return "OpenedURL(url=" + this.url + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @SerialName
    @Metadata
    public static final class OpenedUrlInChrome extends PaywallWebEvent {
        private final URI url;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OpenedUrlInChrome(URI url) {
            super(null);
            Intrinsics.checkNotNullParameter(url, "url");
            this.url = url;
        }

        public static /* synthetic */ OpenedUrlInChrome copy$default(OpenedUrlInChrome openedUrlInChrome, URI uri, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                uri = openedUrlInChrome.url;
            }
            return openedUrlInChrome.copy(uri);
        }

        public final URI component1() {
            return this.url;
        }

        public final OpenedUrlInChrome copy(URI url) {
            Intrinsics.checkNotNullParameter(url, "url");
            return new OpenedUrlInChrome(url);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OpenedUrlInChrome) && Intrinsics.areEqual(this.url, ((OpenedUrlInChrome) obj).url);
        }

        public final URI getUrl() {
            return this.url;
        }

        public int hashCode() {
            return this.url.hashCode();
        }

        public String toString() {
            return "OpenedUrlInChrome(url=" + this.url + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @SerialName
    @Metadata
    public static final class RequestCallback extends PaywallWebEvent {
        private final CustomCallbackBehavior behavior;
        private final String name;
        private final String requestId;
        private final Map<String, Object> variables;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RequestCallback(String name, CustomCallbackBehavior behavior, String requestId, Map<String, ? extends Object> map) {
            super(null);
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(behavior, "behavior");
            Intrinsics.checkNotNullParameter(requestId, "requestId");
            this.name = name;
            this.behavior = behavior;
            this.requestId = requestId;
            this.variables = map;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ RequestCallback copy$default(RequestCallback requestCallback, String str, CustomCallbackBehavior customCallbackBehavior, String str2, Map map, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = requestCallback.name;
            }
            if ((i3 & 2) != 0) {
                customCallbackBehavior = requestCallback.behavior;
            }
            if ((i3 & 4) != 0) {
                str2 = requestCallback.requestId;
            }
            if ((i3 & 8) != 0) {
                map = requestCallback.variables;
            }
            return requestCallback.copy(str, customCallbackBehavior, str2, map);
        }

        public final String component1() {
            return this.name;
        }

        public final CustomCallbackBehavior component2() {
            return this.behavior;
        }

        public final String component3() {
            return this.requestId;
        }

        public final Map<String, Object> component4() {
            return this.variables;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof RequestCallback)) {
                return false;
            }
            RequestCallback requestCallback = (RequestCallback) obj;
            return Intrinsics.areEqual(this.name, requestCallback.name) && this.behavior == requestCallback.behavior && Intrinsics.areEqual(this.requestId, requestCallback.requestId) && Intrinsics.areEqual(this.variables, requestCallback.variables);
        }

        public final CustomCallbackBehavior getBehavior() {
            return this.behavior;
        }

        public final String getName() {
            return this.name;
        }

        public final String getRequestId() {
            return this.requestId;
        }

        public final Map<String, Object> getVariables() {
            return this.variables;
        }

        public int hashCode() {
            int iHashCode = ((((this.name.hashCode() * 31) + this.behavior.hashCode()) * 31) + this.requestId.hashCode()) * 31;
            Map<String, Object> map = this.variables;
            return iHashCode + (map == null ? 0 : map.hashCode());
        }

        public String toString() {
            return "RequestCallback(name=" + this.name + ", behavior=" + this.behavior + ", requestId=" + this.requestId + ", variables=" + this.variables + ")";
        }

        public final RequestCallback copy(String str, CustomCallbackBehavior customCallbackBehavior, String requestId, Map<String, ? extends Object> map) {
            Intrinsics.checkNotNullParameter(str, bfIdKSjLOVjG.GprK);
            Intrinsics.checkNotNullParameter(customCallbackBehavior, YvFRmou.tkHqaEE);
            Intrinsics.checkNotNullParameter(requestId, "requestId");
            return new RequestCallback(str, customCallbackBehavior, requestId, map);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @SerialName
    @Metadata
    public static final class RequestPermission extends PaywallWebEvent {
        private final PermissionType permissionType;
        private final String requestId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RequestPermission(PermissionType permissionType, String requestId) {
            super(null);
            Intrinsics.checkNotNullParameter(permissionType, "permissionType");
            Intrinsics.checkNotNullParameter(requestId, "requestId");
            this.permissionType = permissionType;
            this.requestId = requestId;
        }

        public static /* synthetic */ RequestPermission copy$default(RequestPermission requestPermission, PermissionType permissionType, String str, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                permissionType = requestPermission.permissionType;
            }
            if ((i3 & 2) != 0) {
                str = requestPermission.requestId;
            }
            return requestPermission.copy(permissionType, str);
        }

        public final PermissionType component1() {
            return this.permissionType;
        }

        public final String component2() {
            return this.requestId;
        }

        public final RequestPermission copy(PermissionType permissionType, String requestId) {
            Intrinsics.checkNotNullParameter(permissionType, "permissionType");
            Intrinsics.checkNotNullParameter(requestId, "requestId");
            return new RequestPermission(permissionType, requestId);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof RequestPermission)) {
                return false;
            }
            RequestPermission requestPermission = (RequestPermission) obj;
            return this.permissionType == requestPermission.permissionType && Intrinsics.areEqual(this.requestId, requestPermission.requestId);
        }

        public final PermissionType getPermissionType() {
            return this.permissionType;
        }

        public final String getRequestId() {
            return this.requestId;
        }

        public int hashCode() {
            return (this.permissionType.hashCode() * 31) + this.requestId.hashCode();
        }

        public String toString() {
            return "RequestPermission(permissionType=" + this.permissionType + ", requestId=" + this.requestId + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @SerialName
    public static final class RequestReview extends PaywallWebEvent {
        private final Type type;

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Type {
            private static final /* synthetic */ EnumEntries $ENTRIES;
            private static final /* synthetic */ Type[] $VALUES;
            private final String rawValue;

            @SerialName
            public static final Type INAPP = new Type("INAPP", 0, "in-app");

            @SerialName
            public static final Type EXTERNAL = new Type("EXTERNAL", 1, "external");

            private static final /* synthetic */ Type[] $values() {
                return new Type[]{INAPP, EXTERNAL};
            }

            static {
                Type[] typeArr$values = $values();
                $VALUES = typeArr$values;
                $ENTRIES = EnumEntriesKt.a(typeArr$values);
            }

            private Type(String str, int i3, String str2) {
                this.rawValue = str2;
            }

            public static EnumEntries<Type> getEntries() {
                return $ENTRIES;
            }

            public static Type valueOf(String str) {
                return (Type) Enum.valueOf(Type.class, str);
            }

            public static Type[] values() {
                return (Type[]) $VALUES.clone();
            }

            public final String getRawValue() {
                return this.rawValue;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RequestReview(Type type) {
            super(null);
            Intrinsics.checkNotNullParameter(type, "type");
            this.type = type;
        }

        public static /* synthetic */ RequestReview copy$default(RequestReview requestReview, Type type, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                type = requestReview.type;
            }
            return requestReview.copy(type);
        }

        public final Type component1() {
            return this.type;
        }

        public final RequestReview copy(Type type) {
            Intrinsics.checkNotNullParameter(type, "type");
            return new RequestReview(type);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof RequestReview) && this.type == ((RequestReview) obj).type;
        }

        public final Type getType() {
            return this.type;
        }

        public int hashCode() {
            return this.type.hashCode();
        }

        public String toString() {
            return "RequestReview(type=" + this.type + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @SerialName
    @Metadata
    public static final class ScheduleNotification extends PaywallWebEvent {
        private final LocalNotification localNotification;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ScheduleNotification(LocalNotification localNotification) {
            super(null);
            Intrinsics.checkNotNullParameter(localNotification, "localNotification");
            this.localNotification = localNotification;
        }

        public static /* synthetic */ ScheduleNotification copy$default(ScheduleNotification scheduleNotification, LocalNotification localNotification, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                localNotification = scheduleNotification.localNotification;
            }
            return scheduleNotification.copy(localNotification);
        }

        public final LocalNotification component1() {
            return this.localNotification;
        }

        public final ScheduleNotification copy(LocalNotification localNotification) {
            Intrinsics.checkNotNullParameter(localNotification, "localNotification");
            return new ScheduleNotification(localNotification);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ScheduleNotification) && Intrinsics.areEqual(this.localNotification, ((ScheduleNotification) obj).localNotification);
        }

        public final LocalNotification getLocalNotification() {
            return this.localNotification;
        }

        public int hashCode() {
            return this.localNotification.hashCode();
        }

        public String toString() {
            return "ScheduleNotification(localNotification=" + this.localNotification + ")";
        }
    }

    public /* synthetic */ PaywallWebEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _init_$_anonymous_() {
        return new SealedClassSerializer("com.superwall.sdk.paywall.view.webview.messaging.PaywallWebEvent", Reflection.b(PaywallWebEvent.class), new KClass[0], new KSerializer[0], new Annotation[0]);
    }

    private PaywallWebEvent() {
    }

    public /* synthetic */ PaywallWebEvent(int i3, SerializationConstructorMarker serializationConstructorMarker) {
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self(PaywallWebEvent paywallWebEvent, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
    }
}
