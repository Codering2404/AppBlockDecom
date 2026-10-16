package com.superwall.sdk.models.paywall;

import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

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
public final class LocalNotification {
    public static final Companion Companion = new Companion(null);
    private final String body;
    private final long delay;
    private final String id;
    private final String subtitle;
    private final String title;
    private final LocalNotificationType type;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<LocalNotification> serializer() {
            return LocalNotification$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ LocalNotification(int i3, String str, LocalNotificationType localNotificationType, String str2, String str3, String str4, long j3, SerializationConstructorMarker serializationConstructorMarker) {
        if (54 != (i3 & 54)) {
            PluginExceptionsKt.b(i3, 54, LocalNotification$$serializer.INSTANCE.getDescriptor());
        }
        this.id = (i3 & 1) == 0 ? UUID.randomUUID().toString() : str;
        this.type = localNotificationType;
        this.title = str2;
        if ((i3 & 8) == 0) {
            this.subtitle = null;
        } else {
            this.subtitle = str3;
        }
        this.body = str4;
        this.delay = j3;
    }

    public static /* synthetic */ LocalNotification copy$default(LocalNotification localNotification, String str, LocalNotificationType localNotificationType, String str2, String str3, String str4, long j3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = localNotification.id;
        }
        if ((i3 & 2) != 0) {
            localNotificationType = localNotification.type;
        }
        if ((i3 & 4) != 0) {
            str2 = localNotification.title;
        }
        if ((i3 & 8) != 0) {
            str3 = localNotification.subtitle;
        }
        if ((i3 & 16) != 0) {
            str4 = localNotification.body;
        }
        if ((i3 & 32) != 0) {
            j3 = localNotification.delay;
        }
        long j4 = j3;
        String str5 = str4;
        String str6 = str2;
        return localNotification.copy(str, localNotificationType, str6, str3, str5, j4);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$superwall_release(LocalNotification localNotification, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        if (compositeEncoder.z(serialDescriptor, 0) || !Intrinsics.areEqual(localNotification.id, UUID.randomUUID().toString())) {
            compositeEncoder.y(serialDescriptor, 0, localNotification.id);
        }
        compositeEncoder.C(serialDescriptor, 1, LocalNotificationTypeSerializer.INSTANCE, localNotification.type);
        compositeEncoder.y(serialDescriptor, 2, localNotification.title);
        if (compositeEncoder.z(serialDescriptor, 3) || localNotification.subtitle != null) {
            compositeEncoder.i(serialDescriptor, 3, StringSerializer.f142891a, localNotification.subtitle);
        }
        compositeEncoder.y(serialDescriptor, 4, localNotification.body);
        compositeEncoder.F(serialDescriptor, 5, localNotification.delay);
    }

    public final String component1() {
        return this.id;
    }

    public final LocalNotificationType component2() {
        return this.type;
    }

    public final String component3() {
        return this.title;
    }

    public final String component4() {
        return this.subtitle;
    }

    public final String component5() {
        return this.body;
    }

    public final long component6() {
        return this.delay;
    }

    public final LocalNotification copy(String id, LocalNotificationType type, String title, String str, String body, long j3) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(body, "body");
        return new LocalNotification(id, type, title, str, body, j3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LocalNotification)) {
            return false;
        }
        LocalNotification localNotification = (LocalNotification) obj;
        return Intrinsics.areEqual(this.id, localNotification.id) && Intrinsics.areEqual(this.type, localNotification.type) && Intrinsics.areEqual(this.title, localNotification.title) && Intrinsics.areEqual(this.subtitle, localNotification.subtitle) && Intrinsics.areEqual(this.body, localNotification.body) && this.delay == localNotification.delay;
    }

    public final String getBody() {
        return this.body;
    }

    public final long getDelay() {
        return this.delay;
    }

    public final String getId() {
        return this.id;
    }

    public final String getSubtitle() {
        return this.subtitle;
    }

    public final String getTitle() {
        return this.title;
    }

    public final LocalNotificationType getType() {
        return this.type;
    }

    public int hashCode() {
        int iHashCode = ((((this.id.hashCode() * 31) + this.type.hashCode()) * 31) + this.title.hashCode()) * 31;
        String str = this.subtitle;
        return ((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.body.hashCode()) * 31) + Long.hashCode(this.delay);
    }

    public String toString() {
        return "LocalNotification(id=" + this.id + ", type=" + this.type + ", title=" + this.title + ", subtitle=" + this.subtitle + ", body=" + this.body + ", delay=" + this.delay + ")";
    }

    public LocalNotification(String id, LocalNotificationType type, String title, String str, String body, long j3) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(body, "body");
        this.id = id;
        this.type = type;
        this.title = title;
        this.subtitle = str;
        this.body = body;
        this.delay = j3;
    }

    public /* synthetic */ LocalNotification(String str, LocalNotificationType localNotificationType, String str2, String str3, String str4, long j3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? UUID.randomUUID().toString() : str, localNotificationType, str2, (i3 & 8) != 0 ? null : str3, str4, j3);
    }

    @SerialName
    public static /* synthetic */ void getBody$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getDelay$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getId$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getSubtitle$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getTitle$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getType$annotations() {
    }
}
