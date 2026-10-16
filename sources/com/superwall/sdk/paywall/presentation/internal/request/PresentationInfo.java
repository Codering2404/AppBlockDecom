package com.superwall.sdk.paywall.presentation.internal.request;

import com.superwall.sdk.models.events.EventData;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

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
public abstract class PresentationInfo {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ExplicitTrigger extends PresentationInfo {
        private final EventData eventData;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ExplicitTrigger(EventData eventData) {
            super(null);
            Intrinsics.checkNotNullParameter(eventData, "eventData");
            this.eventData = eventData;
        }

        public static /* synthetic */ ExplicitTrigger copy$default(ExplicitTrigger explicitTrigger, EventData eventData, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                eventData = explicitTrigger.eventData;
            }
            return explicitTrigger.copy(eventData);
        }

        public final EventData component1() {
            return this.eventData;
        }

        public final ExplicitTrigger copy(EventData eventData) {
            Intrinsics.checkNotNullParameter(eventData, "eventData");
            return new ExplicitTrigger(eventData);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ExplicitTrigger) && Intrinsics.areEqual(this.eventData, ((ExplicitTrigger) obj).eventData);
        }

        @Override // com.superwall.sdk.paywall.presentation.internal.request.PresentationInfo
        public EventData getEventData() {
            return this.eventData;
        }

        public int hashCode() {
            return this.eventData.hashCode();
        }

        public String toString() {
            return "ExplicitTrigger(eventData=" + this.eventData + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class FromIdentifier extends PresentationInfo {
        private final boolean freeTrialOverride;
        private final String identifier;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FromIdentifier(String identifier, boolean z2) {
            super(null);
            Intrinsics.checkNotNullParameter(identifier, "identifier");
            this.identifier = identifier;
            this.freeTrialOverride = z2;
        }

        public static /* synthetic */ FromIdentifier copy$default(FromIdentifier fromIdentifier, String str, boolean z2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = fromIdentifier.identifier;
            }
            if ((i3 & 2) != 0) {
                z2 = fromIdentifier.freeTrialOverride;
            }
            return fromIdentifier.copy(str, z2);
        }

        public final String component1() {
            return this.identifier;
        }

        public final boolean component2() {
            return this.freeTrialOverride;
        }

        public final FromIdentifier copy(String identifier, boolean z2) {
            Intrinsics.checkNotNullParameter(identifier, "identifier");
            return new FromIdentifier(identifier, z2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof FromIdentifier)) {
                return false;
            }
            FromIdentifier fromIdentifier = (FromIdentifier) obj;
            return Intrinsics.areEqual(this.identifier, fromIdentifier.identifier) && this.freeTrialOverride == fromIdentifier.freeTrialOverride;
        }

        @Override // com.superwall.sdk.paywall.presentation.internal.request.PresentationInfo
        public Boolean getFreeTrialOverride() {
            return Boolean.valueOf(this.freeTrialOverride);
        }

        @Override // com.superwall.sdk.paywall.presentation.internal.request.PresentationInfo
        public String getIdentifier() {
            return this.identifier;
        }

        public int hashCode() {
            return (this.identifier.hashCode() * 31) + Boolean.hashCode(this.freeTrialOverride);
        }

        public String toString() {
            return "FromIdentifier(identifier=" + this.identifier + ", freeTrialOverride=" + this.freeTrialOverride + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ImplicitTrigger extends PresentationInfo {
        private final EventData eventData;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ImplicitTrigger(EventData eventData) {
            super(null);
            Intrinsics.checkNotNullParameter(eventData, "eventData");
            this.eventData = eventData;
        }

        public static /* synthetic */ ImplicitTrigger copy$default(ImplicitTrigger implicitTrigger, EventData eventData, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                eventData = implicitTrigger.eventData;
            }
            return implicitTrigger.copy(eventData);
        }

        public final EventData component1() {
            return this.eventData;
        }

        public final ImplicitTrigger copy(EventData eventData) {
            Intrinsics.checkNotNullParameter(eventData, "eventData");
            return new ImplicitTrigger(eventData);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ImplicitTrigger) && Intrinsics.areEqual(this.eventData, ((ImplicitTrigger) obj).eventData);
        }

        @Override // com.superwall.sdk.paywall.presentation.internal.request.PresentationInfo
        public EventData getEventData() {
            return this.eventData;
        }

        public int hashCode() {
            return this.eventData.hashCode();
        }

        public String toString() {
            return "ImplicitTrigger(eventData=" + this.eventData + ")";
        }
    }

    public /* synthetic */ PresentationInfo(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public EventData getEventData() {
        if (this instanceof ImplicitTrigger) {
            return ((ImplicitTrigger) this).getEventData();
        }
        if (this instanceof ExplicitTrigger) {
            return ((ExplicitTrigger) this).getEventData();
        }
        return null;
    }

    public final String getEventName() {
        if (this instanceof ImplicitTrigger) {
            return ((ImplicitTrigger) this).getEventData().getName();
        }
        if (this instanceof ExplicitTrigger) {
            return ((ExplicitTrigger) this).getEventData().getName();
        }
        return null;
    }

    public Boolean getFreeTrialOverride() {
        if (this instanceof FromIdentifier) {
            return ((FromIdentifier) this).getFreeTrialOverride();
        }
        return null;
    }

    public String getIdentifier() {
        if (this instanceof FromIdentifier) {
            return ((FromIdentifier) this).getIdentifier();
        }
        return null;
    }

    private PresentationInfo() {
    }
}
