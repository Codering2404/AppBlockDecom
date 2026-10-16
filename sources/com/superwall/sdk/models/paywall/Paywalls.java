package com.superwall.sdk.models.paywall;

import com.superwall.sdk.models.SerializableEntity;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.internal.ArrayListSerializer;
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
public final class Paywalls implements SerializableEntity {
    private final List<Paywall> paywalls;
    public static final Companion Companion = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {new ArrayListSerializer(Paywall$$serializer.INSTANCE)};

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<Paywalls> serializer() {
            return Paywalls$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ Paywalls(int i3, List list, SerializationConstructorMarker serializationConstructorMarker) {
        if (1 != (i3 & 1)) {
            PluginExceptionsKt.b(i3, 1, Paywalls$$serializer.INSTANCE.getDescriptor());
        }
        this.paywalls = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Paywalls copy$default(Paywalls paywalls, List list, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            list = paywalls.paywalls;
        }
        return paywalls.copy(list);
    }

    public final List<Paywall> component1() {
        return this.paywalls;
    }

    public final Paywalls copy(List<Paywall> paywalls) {
        Intrinsics.checkNotNullParameter(paywalls, "paywalls");
        return new Paywalls(paywalls);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof Paywalls) && Intrinsics.areEqual(this.paywalls, ((Paywalls) obj).paywalls);
    }

    public final List<Paywall> getPaywalls() {
        return this.paywalls;
    }

    public int hashCode() {
        return this.paywalls.hashCode();
    }

    public String toString() {
        return "Paywalls(paywalls=" + this.paywalls + ")";
    }

    public Paywalls(List<Paywall> paywalls) {
        Intrinsics.checkNotNullParameter(paywalls, "paywalls");
        this.paywalls = paywalls;
    }
}
