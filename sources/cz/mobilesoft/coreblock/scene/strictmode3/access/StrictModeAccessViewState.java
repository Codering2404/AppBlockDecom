package cz.mobilesoft.coreblock.scene.strictmode3.access;

import cz.mobilesoft.coreblock.base.ViewState;
import cz.mobilesoft.coreblock.enums.PremiumState;
import cz.mobilesoft.coreblock.enums.StrictModeAccessMethod;
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
public final class StrictModeAccessViewState implements ViewState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final StrictModeAccessMethod f121562a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ImmutableList f121563b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final PremiumState f121564c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f121565d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f121566f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f121567g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final String f121568h;

    public StrictModeAccessViewState(StrictModeAccessMethod strictModeAccessMethod, ImmutableList configurations, PremiumState premiumState, boolean z2, boolean z3, boolean z4, String approvalPresetEmail) {
        Intrinsics.checkNotNullParameter(configurations, "configurations");
        Intrinsics.checkNotNullParameter(premiumState, "premiumState");
        Intrinsics.checkNotNullParameter(approvalPresetEmail, "approvalPresetEmail");
        this.f121562a = strictModeAccessMethod;
        this.f121563b = configurations;
        this.f121564c = premiumState;
        this.f121565d = z2;
        this.f121566f = z3;
        this.f121567g = z4;
        this.f121568h = approvalPresetEmail;
    }

    public static /* synthetic */ StrictModeAccessViewState b(StrictModeAccessViewState strictModeAccessViewState, StrictModeAccessMethod strictModeAccessMethod, ImmutableList immutableList, PremiumState premiumState, boolean z2, boolean z3, boolean z4, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            strictModeAccessMethod = strictModeAccessViewState.f121562a;
        }
        if ((i3 & 2) != 0) {
            immutableList = strictModeAccessViewState.f121563b;
        }
        if ((i3 & 4) != 0) {
            premiumState = strictModeAccessViewState.f121564c;
        }
        if ((i3 & 8) != 0) {
            z2 = strictModeAccessViewState.f121565d;
        }
        if ((i3 & 16) != 0) {
            z3 = strictModeAccessViewState.f121566f;
        }
        if ((i3 & 32) != 0) {
            z4 = strictModeAccessViewState.f121567g;
        }
        if ((i3 & 64) != 0) {
            str = strictModeAccessViewState.f121568h;
        }
        boolean z5 = z4;
        String str2 = str;
        boolean z6 = z3;
        PremiumState premiumState2 = premiumState;
        return strictModeAccessViewState.a(strictModeAccessMethod, immutableList, premiumState2, z2, z6, z5, str2);
    }

    public final StrictModeAccessViewState a(StrictModeAccessMethod strictModeAccessMethod, ImmutableList configurations, PremiumState premiumState, boolean z2, boolean z3, boolean z4, String approvalPresetEmail) {
        Intrinsics.checkNotNullParameter(configurations, "configurations");
        Intrinsics.checkNotNullParameter(premiumState, "premiumState");
        Intrinsics.checkNotNullParameter(approvalPresetEmail, "approvalPresetEmail");
        return new StrictModeAccessViewState(strictModeAccessMethod, configurations, premiumState, z2, z3, z4, approvalPresetEmail);
    }

    public final StrictModeAccessMethod c() {
        return this.f121562a;
    }

    public final String d() {
        return this.f121568h;
    }

    public final ImmutableList e() {
        return this.f121563b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StrictModeAccessViewState)) {
            return false;
        }
        StrictModeAccessViewState strictModeAccessViewState = (StrictModeAccessViewState) obj;
        return this.f121562a == strictModeAccessViewState.f121562a && Intrinsics.areEqual(this.f121563b, strictModeAccessViewState.f121563b) && Intrinsics.areEqual(this.f121564c, strictModeAccessViewState.f121564c) && this.f121565d == strictModeAccessViewState.f121565d && this.f121566f == strictModeAccessViewState.f121566f && this.f121567g == strictModeAccessViewState.f121567g && Intrinsics.areEqual(this.f121568h, strictModeAccessViewState.f121568h);
    }

    public final boolean f() {
        return this.f121566f;
    }

    public final PremiumState g() {
        return this.f121564c;
    }

    public final boolean h() {
        return this.f121567g;
    }

    public int hashCode() {
        StrictModeAccessMethod strictModeAccessMethod = this.f121562a;
        return ((((((((((((strictModeAccessMethod == null ? 0 : strictModeAccessMethod.hashCode()) * 31) + this.f121563b.hashCode()) * 31) + this.f121564c.hashCode()) * 31) + Boolean.hashCode(this.f121565d)) * 31) + Boolean.hashCode(this.f121566f)) * 31) + Boolean.hashCode(this.f121567g)) * 31) + this.f121568h.hashCode();
    }

    public final boolean i() {
        return this.f121565d;
    }

    public String toString() {
        return "StrictModeAccessViewState(accessMethod=" + this.f121562a + ", configurations=" + this.f121563b + ", premiumState=" + this.f121564c + ", isTrialActive=" + this.f121565d + ", emailInputVisible=" + this.f121566f + ", isSignedIn=" + this.f121567g + ", approvalPresetEmail=" + this.f121568h + ")";
    }

    public /* synthetic */ StrictModeAccessViewState(StrictModeAccessMethod strictModeAccessMethod, ImmutableList immutableList, PremiumState premiumState, boolean z2, boolean z3, boolean z4, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : strictModeAccessMethod, (i3 & 2) != 0 ? ExtensionsKt.a() : immutableList, (i3 & 4) != 0 ? PremiumState.None.INSTANCE : premiumState, (i3 & 8) != 0 ? false : z2, (i3 & 16) != 0 ? false : z3, (i3 & 32) != 0 ? false : z4, (i3 & 64) != 0 ? "" : str);
    }
}
