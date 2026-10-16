package com.superwall.sdk.models.triggers;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
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
public final class Trigger {
    private String eventName;
    private List<TriggerRule> rules;
    public static final Companion Companion = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {null, new ArrayListSerializer(TriggerRule$$serializer.INSTANCE)};

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<Trigger> serializer() {
            return Trigger$$serializer.INSTANCE;
        }

        public final Trigger stub() {
            return new Trigger("an_event", CollectionsKt.emptyList());
        }

        private Companion() {
        }
    }

    public /* synthetic */ Trigger(int i3, String str, List list, SerializationConstructorMarker serializationConstructorMarker) {
        if (3 != (i3 & 3)) {
            PluginExceptionsKt.b(i3, 3, Trigger$$serializer.INSTANCE.getDescriptor());
        }
        this.eventName = str;
        this.rules = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Trigger copy$default(Trigger trigger, String str, List list, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = trigger.eventName;
        }
        if ((i3 & 2) != 0) {
            list = trigger.rules;
        }
        return trigger.copy(str, list);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$superwall_release(Trigger trigger, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        KSerializer<Object>[] kSerializerArr = $childSerializers;
        compositeEncoder.y(serialDescriptor, 0, trigger.eventName);
        compositeEncoder.C(serialDescriptor, 1, kSerializerArr[1], trigger.rules);
    }

    public final String component1() {
        return this.eventName;
    }

    public final List<TriggerRule> component2() {
        return this.rules;
    }

    public final Trigger copy(String eventName, List<TriggerRule> rules) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(rules, "rules");
        return new Trigger(eventName, rules);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Trigger)) {
            return false;
        }
        Trigger trigger = (Trigger) obj;
        return Intrinsics.areEqual(this.eventName, trigger.eventName) && Intrinsics.areEqual(this.rules, trigger.rules);
    }

    public final String getEventName() {
        return this.eventName;
    }

    public final List<TriggerRule> getRules() {
        return this.rules;
    }

    public int hashCode() {
        return (this.eventName.hashCode() * 31) + this.rules.hashCode();
    }

    public final void setEventName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.eventName = str;
    }

    public final void setRules(List<TriggerRule> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.rules = list;
    }

    public String toString() {
        return "Trigger(eventName=" + this.eventName + ", rules=" + this.rules + ")";
    }

    public Trigger(String eventName, List<TriggerRule> rules) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(rules, "rules");
        this.eventName = eventName;
        this.rules = rules;
    }
}
