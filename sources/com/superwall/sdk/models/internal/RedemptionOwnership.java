package com.superwall.sdk.models.internal;

import com.superwall.sdk.models.internal.RedemptionOwnership;
import java.lang.annotation.Annotation;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
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
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.json.JsonClassDiscriminator;

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
@JsonClassDiscriminator(discriminator = "type")
@Metadata
@Serializable
public abstract class RedemptionOwnership {
    public static final Companion Companion = new Companion(null);
    private static final Lazy<KSerializer<Object>> $cachedSerializer$delegate = LazyKt.a(LazyThreadSafetyMode.f139762b, new Function0() { // from class: f0.d
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return RedemptionOwnership._init_$_anonymous_();
        }
    });

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Serializable
    @SerialName
    public static final class AppUser extends RedemptionOwnership {
        public static final Companion Companion = new Companion(null);
        private final String appUserId;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<AppUser> serializer() {
                return RedemptionOwnership$AppUser$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ AppUser(int i3, String str, SerializationConstructorMarker serializationConstructorMarker) {
            super(i3, serializationConstructorMarker);
            if (1 != (i3 & 1)) {
                PluginExceptionsKt.b(i3, 1, RedemptionOwnership$AppUser$$serializer.INSTANCE.getDescriptor());
            }
            this.appUserId = str;
        }

        public static /* synthetic */ AppUser copy$default(AppUser appUser, String str, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = appUser.appUserId;
            }
            return appUser.copy(str);
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$superwall_release(AppUser appUser, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
            RedemptionOwnership.write$Self(appUser, compositeEncoder, serialDescriptor);
            compositeEncoder.y(serialDescriptor, 0, appUser.appUserId);
        }

        public final String component1() {
            return this.appUserId;
        }

        public final AppUser copy(String appUserId) {
            Intrinsics.checkNotNullParameter(appUserId, "appUserId");
            return new AppUser(appUserId);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof AppUser) && Intrinsics.areEqual(this.appUserId, ((AppUser) obj).appUserId);
        }

        public final String getAppUserId() {
            return this.appUserId;
        }

        public int hashCode() {
            return this.appUserId.hashCode();
        }

        public String toString() {
            return "AppUser(appUserId=" + this.appUserId + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AppUser(String appUserId) {
            super(null);
            Intrinsics.checkNotNullParameter(appUserId, "appUserId");
            this.appUserId = appUserId;
        }

        @SerialName
        public static /* synthetic */ void getAppUserId$annotations() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        private Companion() {
        }

        private final /* synthetic */ KSerializer get$cachedSerializer() {
            return (KSerializer) RedemptionOwnership.$cachedSerializer$delegate.getValue();
        }

        public final KSerializer<RedemptionOwnership> serializer() {
            return get$cachedSerializer();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Serializable
    @SerialName
    public static final class Device extends RedemptionOwnership {
        public static final Companion Companion = new Companion(null);
        private final String deviceId;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<Device> serializer() {
                return RedemptionOwnership$Device$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Device(int i3, String str, SerializationConstructorMarker serializationConstructorMarker) {
            super(i3, serializationConstructorMarker);
            if (1 != (i3 & 1)) {
                PluginExceptionsKt.b(i3, 1, RedemptionOwnership$Device$$serializer.INSTANCE.getDescriptor());
            }
            this.deviceId = str;
        }

        public static /* synthetic */ Device copy$default(Device device, String str, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = device.deviceId;
            }
            return device.copy(str);
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$superwall_release(Device device, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
            RedemptionOwnership.write$Self(device, compositeEncoder, serialDescriptor);
            compositeEncoder.y(serialDescriptor, 0, device.deviceId);
        }

        public final String component1() {
            return this.deviceId;
        }

        public final Device copy(String deviceId) {
            Intrinsics.checkNotNullParameter(deviceId, "deviceId");
            return new Device(deviceId);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Device) && Intrinsics.areEqual(this.deviceId, ((Device) obj).deviceId);
        }

        public final String getDeviceId() {
            return this.deviceId;
        }

        public int hashCode() {
            return this.deviceId.hashCode();
        }

        public String toString() {
            return "Device(deviceId=" + this.deviceId + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Device(String deviceId) {
            super(null);
            Intrinsics.checkNotNullParameter(deviceId, "deviceId");
            this.deviceId = deviceId;
        }

        @SerialName
        public static /* synthetic */ void getDeviceId$annotations() {
        }
    }

    public /* synthetic */ RedemptionOwnership(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _init_$_anonymous_() {
        return new SealedClassSerializer("com.superwall.sdk.models.internal.RedemptionOwnership", Reflection.b(RedemptionOwnership.class), new KClass[]{Reflection.b(AppUser.class), Reflection.b(Device.class)}, new KSerializer[]{RedemptionOwnership$AppUser$$serializer.INSTANCE, RedemptionOwnership$Device$$serializer.INSTANCE}, new Annotation[]{new RedemptionResult$Error$$serializer$annotationImpl$kotlinx_serialization_json_JsonClassDiscriminator$0("type")});
    }

    private RedemptionOwnership() {
    }

    public /* synthetic */ RedemptionOwnership(int i3, SerializationConstructorMarker serializationConstructorMarker) {
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self(RedemptionOwnership redemptionOwnership, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
    }
}
