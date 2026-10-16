package com.superwall.sdk.storage;

import com.superwall.sdk.store.testmode.FreeTrialOverride;
import com.superwall.sdk.store.testmode.ui.EntitlementSelection;
import com.superwall.sdk.store.testmode.ui.EntitlementSelection$$serializer;
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
public final class TestModeSettings {
    private final List<EntitlementSelection> entitlementSelections;
    private final FreeTrialOverride freeTrialOverride;
    public static final Companion Companion = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {new ArrayListSerializer(EntitlementSelection$$serializer.INSTANCE), FreeTrialOverride.Companion.serializer()};

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<TestModeSettings> serializer() {
            return TestModeSettings$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public TestModeSettings() {
        this((List) null, (FreeTrialOverride) (0 == true ? 1 : 0), 3, (DefaultConstructorMarker) (0 == true ? 1 : 0));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TestModeSettings copy$default(TestModeSettings testModeSettings, List list, FreeTrialOverride freeTrialOverride, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            list = testModeSettings.entitlementSelections;
        }
        if ((i3 & 2) != 0) {
            freeTrialOverride = testModeSettings.freeTrialOverride;
        }
        return testModeSettings.copy(list, freeTrialOverride);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$superwall_release(TestModeSettings testModeSettings, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        KSerializer<Object>[] kSerializerArr = $childSerializers;
        if (compositeEncoder.z(serialDescriptor, 0) || !Intrinsics.areEqual(testModeSettings.entitlementSelections, CollectionsKt.emptyList())) {
            compositeEncoder.C(serialDescriptor, 0, kSerializerArr[0], testModeSettings.entitlementSelections);
        }
        if (!compositeEncoder.z(serialDescriptor, 1) && testModeSettings.freeTrialOverride == FreeTrialOverride.UseDefault) {
            return;
        }
        compositeEncoder.C(serialDescriptor, 1, kSerializerArr[1], testModeSettings.freeTrialOverride);
    }

    public final List<EntitlementSelection> component1() {
        return this.entitlementSelections;
    }

    public final FreeTrialOverride component2() {
        return this.freeTrialOverride;
    }

    public final TestModeSettings copy(List<EntitlementSelection> entitlementSelections, FreeTrialOverride freeTrialOverride) {
        Intrinsics.checkNotNullParameter(entitlementSelections, "entitlementSelections");
        Intrinsics.checkNotNullParameter(freeTrialOverride, "freeTrialOverride");
        return new TestModeSettings(entitlementSelections, freeTrialOverride);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TestModeSettings)) {
            return false;
        }
        TestModeSettings testModeSettings = (TestModeSettings) obj;
        return Intrinsics.areEqual(this.entitlementSelections, testModeSettings.entitlementSelections) && this.freeTrialOverride == testModeSettings.freeTrialOverride;
    }

    public final List<EntitlementSelection> getEntitlementSelections() {
        return this.entitlementSelections;
    }

    public final FreeTrialOverride getFreeTrialOverride() {
        return this.freeTrialOverride;
    }

    public int hashCode() {
        return (this.entitlementSelections.hashCode() * 31) + this.freeTrialOverride.hashCode();
    }

    public String toString() {
        return "TestModeSettings(entitlementSelections=" + this.entitlementSelections + ", freeTrialOverride=" + this.freeTrialOverride + ")";
    }

    public /* synthetic */ TestModeSettings(int i3, List list, FreeTrialOverride freeTrialOverride, SerializationConstructorMarker serializationConstructorMarker) {
        this.entitlementSelections = (i3 & 1) == 0 ? CollectionsKt.emptyList() : list;
        if ((i3 & 2) == 0) {
            this.freeTrialOverride = FreeTrialOverride.UseDefault;
        } else {
            this.freeTrialOverride = freeTrialOverride;
        }
    }

    public TestModeSettings(List<EntitlementSelection> entitlementSelections, FreeTrialOverride freeTrialOverride) {
        Intrinsics.checkNotNullParameter(entitlementSelections, "entitlementSelections");
        Intrinsics.checkNotNullParameter(freeTrialOverride, "freeTrialOverride");
        this.entitlementSelections = entitlementSelections;
        this.freeTrialOverride = freeTrialOverride;
    }

    public /* synthetic */ TestModeSettings(List list, FreeTrialOverride freeTrialOverride, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? CollectionsKt.emptyList() : list, (i3 & 2) != 0 ? FreeTrialOverride.UseDefault : freeTrialOverride);
    }
}
