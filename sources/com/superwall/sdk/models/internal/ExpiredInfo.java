package com.superwall.sdk.models.internal;

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
public final class ExpiredInfo {
    public static final Companion Companion = new Companion(null);
    private final String obfuscatedEmail;
    private final boolean resent;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<ExpiredInfo> serializer() {
            return ExpiredInfo$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ ExpiredInfo(int i3, boolean z2, String str, SerializationConstructorMarker serializationConstructorMarker) {
        if (1 != (i3 & 1)) {
            PluginExceptionsKt.b(i3, 1, ExpiredInfo$$serializer.INSTANCE.getDescriptor());
        }
        this.resent = z2;
        if ((i3 & 2) == 0) {
            this.obfuscatedEmail = null;
        } else {
            this.obfuscatedEmail = str;
        }
    }

    public static /* synthetic */ ExpiredInfo copy$default(ExpiredInfo expiredInfo, boolean z2, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z2 = expiredInfo.resent;
        }
        if ((i3 & 2) != 0) {
            str = expiredInfo.obfuscatedEmail;
        }
        return expiredInfo.copy(z2, str);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$superwall_release(ExpiredInfo expiredInfo, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        compositeEncoder.x(serialDescriptor, 0, expiredInfo.resent);
        if (!compositeEncoder.z(serialDescriptor, 1) && expiredInfo.obfuscatedEmail == null) {
            return;
        }
        compositeEncoder.i(serialDescriptor, 1, StringSerializer.f142891a, expiredInfo.obfuscatedEmail);
    }

    public final boolean component1() {
        return this.resent;
    }

    public final String component2() {
        return this.obfuscatedEmail;
    }

    public final ExpiredInfo copy(boolean z2, String str) {
        return new ExpiredInfo(z2, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ExpiredInfo)) {
            return false;
        }
        ExpiredInfo expiredInfo = (ExpiredInfo) obj;
        return this.resent == expiredInfo.resent && Intrinsics.areEqual(this.obfuscatedEmail, expiredInfo.obfuscatedEmail);
    }

    public final String getObfuscatedEmail() {
        return this.obfuscatedEmail;
    }

    public final boolean getResent() {
        return this.resent;
    }

    public int hashCode() {
        int iHashCode = Boolean.hashCode(this.resent) * 31;
        String str = this.obfuscatedEmail;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "ExpiredInfo(resent=" + this.resent + ", obfuscatedEmail=" + this.obfuscatedEmail + ")";
    }

    public ExpiredInfo(boolean z2, String str) {
        this.resent = z2;
        this.obfuscatedEmail = str;
    }

    public /* synthetic */ ExpiredInfo(boolean z2, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(z2, (i3 & 2) != 0 ? null : str);
    }

    @SerialName
    public static /* synthetic */ void getObfuscatedEmail$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getResent$annotations() {
    }
}
