package com.superwall.sdk.models.postback;

import java.util.Locale;
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
public final class PostbackProductIdentifier {
    public static final Companion Companion = new Companion(null);
    private final String identifier;
    private final String platform;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<PostbackProductIdentifier> serializer() {
            return PostbackProductIdentifier$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ PostbackProductIdentifier(int i3, String str, String str2, SerializationConstructorMarker serializationConstructorMarker) {
        if (3 != (i3 & 3)) {
            PluginExceptionsKt.b(i3, 3, PostbackProductIdentifier$$serializer.INSTANCE.getDescriptor());
        }
        this.identifier = str;
        this.platform = str2;
    }

    public static /* synthetic */ PostbackProductIdentifier copy$default(PostbackProductIdentifier postbackProductIdentifier, String str, String str2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = postbackProductIdentifier.identifier;
        }
        if ((i3 & 2) != 0) {
            str2 = postbackProductIdentifier.platform;
        }
        return postbackProductIdentifier.copy(str, str2);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$superwall_release(PostbackProductIdentifier postbackProductIdentifier, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        compositeEncoder.y(serialDescriptor, 0, postbackProductIdentifier.identifier);
        compositeEncoder.y(serialDescriptor, 1, postbackProductIdentifier.platform);
    }

    public final String component1() {
        return this.identifier;
    }

    public final String component2() {
        return this.platform;
    }

    public final PostbackProductIdentifier copy(String identifier, String platform) {
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        Intrinsics.checkNotNullParameter(platform, "platform");
        return new PostbackProductIdentifier(identifier, platform);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PostbackProductIdentifier)) {
            return false;
        }
        PostbackProductIdentifier postbackProductIdentifier = (PostbackProductIdentifier) obj;
        return Intrinsics.areEqual(this.identifier, postbackProductIdentifier.identifier) && Intrinsics.areEqual(this.platform, postbackProductIdentifier.platform);
    }

    public final String getIdentifier() {
        return this.identifier;
    }

    public final boolean getIsiOS() {
        String lowerCase = this.platform.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        return Intrinsics.areEqual(lowerCase, "ios");
    }

    public final String getPlatform() {
        return this.platform;
    }

    public int hashCode() {
        return (this.identifier.hashCode() * 31) + this.platform.hashCode();
    }

    public String toString() {
        return "PostbackProductIdentifier(identifier=" + this.identifier + ", platform=" + this.platform + ")";
    }

    public PostbackProductIdentifier(String identifier, String platform) {
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        Intrinsics.checkNotNullParameter(platform, "platform");
        this.identifier = identifier;
        this.platform = platform;
    }

    @SerialName
    public static /* synthetic */ void getIdentifier$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getPlatform$annotations() {
    }
}
