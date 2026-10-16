package com.superwall.sdk.store.testmode.ui;

import com.superwall.sdk.store.testmode.FreeTrialOverride;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class TestModeModalResult {
    private final List<EntitlementSelection> entitlements;
    private final FreeTrialOverride freeTrialOverride;

    public TestModeModalResult(List<EntitlementSelection> entitlements, FreeTrialOverride freeTrialOverride) {
        Intrinsics.checkNotNullParameter(entitlements, "entitlements");
        Intrinsics.checkNotNullParameter(freeTrialOverride, "freeTrialOverride");
        this.entitlements = entitlements;
        this.freeTrialOverride = freeTrialOverride;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TestModeModalResult copy$default(TestModeModalResult testModeModalResult, List list, FreeTrialOverride freeTrialOverride, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            list = testModeModalResult.entitlements;
        }
        if ((i3 & 2) != 0) {
            freeTrialOverride = testModeModalResult.freeTrialOverride;
        }
        return testModeModalResult.copy(list, freeTrialOverride);
    }

    public final List<EntitlementSelection> component1() {
        return this.entitlements;
    }

    public final FreeTrialOverride component2() {
        return this.freeTrialOverride;
    }

    public final TestModeModalResult copy(List<EntitlementSelection> entitlements, FreeTrialOverride freeTrialOverride) {
        Intrinsics.checkNotNullParameter(entitlements, "entitlements");
        Intrinsics.checkNotNullParameter(freeTrialOverride, "freeTrialOverride");
        return new TestModeModalResult(entitlements, freeTrialOverride);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TestModeModalResult)) {
            return false;
        }
        TestModeModalResult testModeModalResult = (TestModeModalResult) obj;
        return Intrinsics.areEqual(this.entitlements, testModeModalResult.entitlements) && this.freeTrialOverride == testModeModalResult.freeTrialOverride;
    }

    public final List<EntitlementSelection> getEntitlements() {
        return this.entitlements;
    }

    public final FreeTrialOverride getFreeTrialOverride() {
        return this.freeTrialOverride;
    }

    public int hashCode() {
        return (this.entitlements.hashCode() * 31) + this.freeTrialOverride.hashCode();
    }

    public String toString() {
        return "TestModeModalResult(entitlements=" + this.entitlements + ", freeTrialOverride=" + this.freeTrialOverride + ")";
    }
}
