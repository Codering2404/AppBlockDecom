package cz.mobilesoft.coreblock.scene.strictmode3.confirmation;

import cz.mobilesoft.coreblock.base.ViewState;
import cz.mobilesoft.coreblock.enums.PremiumState;
import cz.mobilesoft.coreblock.enums.StrictModeAccessMethod;
import cz.mobilesoft.coreblock.scene.strictmode3.AccessMethodConfiguration;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.collections.immutable.ExtensionsKt;
import kotlinx.collections.immutable.ImmutableList;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class StrictModeConfirmationViewState implements ViewState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final StrictModeAccessMethod f121980a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AccessMethodConfiguration f121981b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ImmutableList f121982c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final PremiumState f121983d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f121984f;

    public StrictModeConfirmationViewState(StrictModeAccessMethod strictModeAccessMethod, AccessMethodConfiguration accessMethodConfiguration, ImmutableList conditions, PremiumState premiumState, String str) {
        Intrinsics.checkNotNullParameter(accessMethodConfiguration, "accessMethodConfiguration");
        Intrinsics.checkNotNullParameter(conditions, "conditions");
        Intrinsics.checkNotNullParameter(premiumState, "premiumState");
        this.f121980a = strictModeAccessMethod;
        this.f121981b = accessMethodConfiguration;
        this.f121982c = conditions;
        this.f121983d = premiumState;
        this.f121984f = str;
    }

    public final StrictModeAccessMethod a() {
        return this.f121980a;
    }

    public final String b() {
        return this.f121984f;
    }

    public final ImmutableList c() {
        return this.f121982c;
    }

    public final PremiumState d() {
        return this.f121983d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StrictModeConfirmationViewState)) {
            return false;
        }
        StrictModeConfirmationViewState strictModeConfirmationViewState = (StrictModeConfirmationViewState) obj;
        return this.f121980a == strictModeConfirmationViewState.f121980a && Intrinsics.areEqual(this.f121981b, strictModeConfirmationViewState.f121981b) && Intrinsics.areEqual(this.f121982c, strictModeConfirmationViewState.f121982c) && Intrinsics.areEqual(this.f121983d, strictModeConfirmationViewState.f121983d) && Intrinsics.areEqual(this.f121984f, strictModeConfirmationViewState.f121984f);
    }

    public int hashCode() {
        StrictModeAccessMethod strictModeAccessMethod = this.f121980a;
        int iHashCode = (((((((strictModeAccessMethod == null ? 0 : strictModeAccessMethod.hashCode()) * 31) + this.f121981b.hashCode()) * 31) + this.f121982c.hashCode()) * 31) + this.f121983d.hashCode()) * 31;
        String str = this.f121984f;
        return iHashCode + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "StrictModeConfirmationViewState(accessMethod=" + this.f121980a + ", accessMethodConfiguration=" + this.f121981b + ", conditions=" + this.f121982c + ", premiumState=" + this.f121983d + ", approvalEmail=" + this.f121984f + ")";
    }

    public /* synthetic */ StrictModeConfirmationViewState(StrictModeAccessMethod strictModeAccessMethod, AccessMethodConfiguration accessMethodConfiguration, ImmutableList immutableList, PremiumState premiumState, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : strictModeAccessMethod, (i3 & 2) != 0 ? AccessMethodConfiguration.None.f121084c : accessMethodConfiguration, (i3 & 4) != 0 ? ExtensionsKt.a() : immutableList, (i3 & 8) != 0 ? PremiumState.None.INSTANCE : premiumState, (i3 & 16) != 0 ? null : str);
    }
}
