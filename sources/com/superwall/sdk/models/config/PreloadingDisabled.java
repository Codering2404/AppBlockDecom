package com.superwall.sdk.models.config;

import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.LinkedHashSetSerializer;
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
public final class PreloadingDisabled {
    private final boolean all;
    private final Set<String> triggers;
    public static final Companion Companion = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {null, new LinkedHashSetSerializer(StringSerializer.f142891a)};

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<PreloadingDisabled> serializer() {
            return PreloadingDisabled$$serializer.INSTANCE;
        }

        public final PreloadingDisabled stub() {
            return new PreloadingDisabled(false, SetsKt.emptySet());
        }

        private Companion() {
        }
    }

    public /* synthetic */ PreloadingDisabled(int i3, boolean z2, Set set, SerializationConstructorMarker serializationConstructorMarker) {
        if (3 != (i3 & 3)) {
            PluginExceptionsKt.b(i3, 3, PreloadingDisabled$$serializer.INSTANCE.getDescriptor());
        }
        this.all = z2;
        this.triggers = set;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PreloadingDisabled copy$default(PreloadingDisabled preloadingDisabled, boolean z2, Set set, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z2 = preloadingDisabled.all;
        }
        if ((i3 & 2) != 0) {
            set = preloadingDisabled.triggers;
        }
        return preloadingDisabled.copy(z2, set);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$superwall_release(PreloadingDisabled preloadingDisabled, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        KSerializer<Object>[] kSerializerArr = $childSerializers;
        compositeEncoder.x(serialDescriptor, 0, preloadingDisabled.all);
        compositeEncoder.C(serialDescriptor, 1, kSerializerArr[1], preloadingDisabled.triggers);
    }

    public final boolean component1() {
        return this.all;
    }

    public final Set<String> component2() {
        return this.triggers;
    }

    public final PreloadingDisabled copy(boolean z2, Set<String> triggers) {
        Intrinsics.checkNotNullParameter(triggers, "triggers");
        return new PreloadingDisabled(z2, triggers);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PreloadingDisabled)) {
            return false;
        }
        PreloadingDisabled preloadingDisabled = (PreloadingDisabled) obj;
        return this.all == preloadingDisabled.all && Intrinsics.areEqual(this.triggers, preloadingDisabled.triggers);
    }

    public final boolean getAll() {
        return this.all;
    }

    public final Set<String> getTriggers() {
        return this.triggers;
    }

    public int hashCode() {
        return (Boolean.hashCode(this.all) * 31) + this.triggers.hashCode();
    }

    public String toString() {
        return "PreloadingDisabled(all=" + this.all + ", triggers=" + this.triggers + ")";
    }

    public PreloadingDisabled(boolean z2, Set<String> triggers) {
        Intrinsics.checkNotNullParameter(triggers, "triggers");
        this.all = z2;
        this.triggers = triggers;
    }

    @SerialName
    public static /* synthetic */ void getAll$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getTriggers$annotations() {
    }
}
