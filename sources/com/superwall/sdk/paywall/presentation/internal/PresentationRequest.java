package com.superwall.sdk.paywall.presentation.internal;

import android.app.Activity;
import com.superwall.sdk.models.entitlements.SubscriptionStatus;
import com.superwall.sdk.paywall.presentation.internal.PresentationRequestType;
import com.superwall.sdk.paywall.presentation.internal.request.PaywallOverrides;
import com.superwall.sdk.paywall.presentation.internal.request.PresentationInfo;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.StateFlow;

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
public final class PresentationRequest {
    private Flags flags;
    private PaywallOverrides paywallOverrides;
    private final PresentationInfo presentationInfo;
    private WeakReference<Activity> presenter;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Flags {
        private StateFlow<? extends SubscriptionStatus> entitlements;
        private boolean isDebuggerLaunched;
        private boolean isPaywallPresented;
        private PresentationRequestType type;

        public Flags(boolean z2, StateFlow<? extends SubscriptionStatus> entitlements, boolean z3, PresentationRequestType type) {
            Intrinsics.checkNotNullParameter(entitlements, "entitlements");
            Intrinsics.checkNotNullParameter(type, "type");
            this.isDebuggerLaunched = z2;
            this.entitlements = entitlements;
            this.isPaywallPresented = z3;
            this.type = type;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Flags copy$default(Flags flags, boolean z2, StateFlow stateFlow, boolean z3, PresentationRequestType presentationRequestType, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                z2 = flags.isDebuggerLaunched;
            }
            if ((i3 & 2) != 0) {
                stateFlow = flags.entitlements;
            }
            if ((i3 & 4) != 0) {
                z3 = flags.isPaywallPresented;
            }
            if ((i3 & 8) != 0) {
                presentationRequestType = flags.type;
            }
            return flags.copy(z2, stateFlow, z3, presentationRequestType);
        }

        public final boolean component1() {
            return this.isDebuggerLaunched;
        }

        public final StateFlow<SubscriptionStatus> component2() {
            return this.entitlements;
        }

        public final boolean component3() {
            return this.isPaywallPresented;
        }

        public final PresentationRequestType component4() {
            return this.type;
        }

        public final Flags copy(boolean z2, StateFlow<? extends SubscriptionStatus> entitlements, boolean z3, PresentationRequestType type) {
            Intrinsics.checkNotNullParameter(entitlements, "entitlements");
            Intrinsics.checkNotNullParameter(type, "type");
            return new Flags(z2, entitlements, z3, type);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Flags)) {
                return false;
            }
            Flags flags = (Flags) obj;
            return this.isDebuggerLaunched == flags.isDebuggerLaunched && Intrinsics.areEqual(this.entitlements, flags.entitlements) && this.isPaywallPresented == flags.isPaywallPresented && Intrinsics.areEqual(this.type, flags.type);
        }

        public final StateFlow<SubscriptionStatus> getEntitlements() {
            return this.entitlements;
        }

        public final PresentationRequestType getType() {
            return this.type;
        }

        public int hashCode() {
            return (((((Boolean.hashCode(this.isDebuggerLaunched) * 31) + this.entitlements.hashCode()) * 31) + Boolean.hashCode(this.isPaywallPresented)) * 31) + this.type.hashCode();
        }

        public final boolean isDebuggerLaunched() {
            return this.isDebuggerLaunched;
        }

        public final boolean isPaywallPresented() {
            return this.isPaywallPresented;
        }

        public final void setDebuggerLaunched(boolean z2) {
            this.isDebuggerLaunched = z2;
        }

        public final void setEntitlements(StateFlow<? extends SubscriptionStatus> stateFlow) {
            Intrinsics.checkNotNullParameter(stateFlow, "<set-?>");
            this.entitlements = stateFlow;
        }

        public final void setPaywallPresented(boolean z2) {
            this.isPaywallPresented = z2;
        }

        public final void setType(PresentationRequestType presentationRequestType) {
            Intrinsics.checkNotNullParameter(presentationRequestType, "<set-?>");
            this.type = presentationRequestType;
        }

        public String toString() {
            return "Flags(isDebuggerLaunched=" + this.isDebuggerLaunched + ", entitlements=" + this.entitlements + ", isPaywallPresented=" + this.isPaywallPresented + ", type=" + this.type + ")";
        }
    }

    public PresentationRequest(PresentationInfo presentationInfo, WeakReference<Activity> weakReference, PaywallOverrides paywallOverrides, Flags flags) {
        Intrinsics.checkNotNullParameter(presentationInfo, "presentationInfo");
        Intrinsics.checkNotNullParameter(flags, "flags");
        this.presentationInfo = presentationInfo;
        this.presenter = weakReference;
        this.paywallOverrides = paywallOverrides;
        this.flags = flags;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PresentationRequest copy$default(PresentationRequest presentationRequest, PresentationInfo presentationInfo, WeakReference weakReference, PaywallOverrides paywallOverrides, Flags flags, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            presentationInfo = presentationRequest.presentationInfo;
        }
        if ((i3 & 2) != 0) {
            weakReference = presentationRequest.presenter;
        }
        if ((i3 & 4) != 0) {
            paywallOverrides = presentationRequest.paywallOverrides;
        }
        if ((i3 & 8) != 0) {
            flags = presentationRequest.flags;
        }
        return presentationRequest.copy(presentationInfo, weakReference, paywallOverrides, flags);
    }

    public final PresentationInfo component1() {
        return this.presentationInfo;
    }

    public final WeakReference<Activity> component2() {
        return this.presenter;
    }

    public final PaywallOverrides component3() {
        return this.paywallOverrides;
    }

    public final Flags component4() {
        return this.flags;
    }

    public final PresentationRequest copy(PresentationInfo presentationInfo, WeakReference<Activity> weakReference, PaywallOverrides paywallOverrides, Flags flags) {
        Intrinsics.checkNotNullParameter(presentationInfo, "presentationInfo");
        Intrinsics.checkNotNullParameter(flags, "flags");
        return new PresentationRequest(presentationInfo, weakReference, paywallOverrides, flags);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PresentationRequest)) {
            return false;
        }
        PresentationRequest presentationRequest = (PresentationRequest) obj;
        return Intrinsics.areEqual(this.presentationInfo, presentationRequest.presentationInfo) && Intrinsics.areEqual(this.presenter, presentationRequest.presenter) && Intrinsics.areEqual(this.paywallOverrides, presentationRequest.paywallOverrides) && Intrinsics.areEqual(this.flags, presentationRequest.flags);
    }

    public final Flags getFlags() {
        return this.flags;
    }

    public final PaywallOverrides getPaywallOverrides() {
        return this.paywallOverrides;
    }

    public final PresentationInfo getPresentationInfo() {
        return this.presentationInfo;
    }

    public final String getPresentationSourceType() {
        PresentationInfo presentationInfo = this.presentationInfo;
        if (presentationInfo instanceof PresentationInfo.ImplicitTrigger) {
            return "implicit";
        }
        if (!(presentationInfo instanceof PresentationInfo.ExplicitTrigger) && !(presentationInfo instanceof PresentationInfo.FromIdentifier)) {
            throw new NoWhenBranchMatchedException();
        }
        PresentationRequestType type = this.flags.getType();
        if (type instanceof PresentationRequestType.GetPaywall) {
            return "getPaywall";
        }
        if (type instanceof PresentationRequestType.Presentation) {
            return "register";
        }
        return null;
    }

    public final WeakReference<Activity> getPresenter() {
        return this.presenter;
    }

    public int hashCode() {
        int iHashCode = this.presentationInfo.hashCode() * 31;
        WeakReference<Activity> weakReference = this.presenter;
        int iHashCode2 = (iHashCode + (weakReference == null ? 0 : weakReference.hashCode())) * 31;
        PaywallOverrides paywallOverrides = this.paywallOverrides;
        return ((iHashCode2 + (paywallOverrides != null ? paywallOverrides.hashCode() : 0)) * 31) + this.flags.hashCode();
    }

    public final void setFlags(Flags flags) {
        Intrinsics.checkNotNullParameter(flags, "<set-?>");
        this.flags = flags;
    }

    public final void setPaywallOverrides(PaywallOverrides paywallOverrides) {
        this.paywallOverrides = paywallOverrides;
    }

    public final void setPresenter(WeakReference<Activity> weakReference) {
        this.presenter = weakReference;
    }

    public String toString() {
        return "PresentationRequest(presentationInfo=" + this.presentationInfo + ", presenter=" + this.presenter + ", paywallOverrides=" + this.paywallOverrides + ", flags=" + this.flags + ")";
    }

    public /* synthetic */ PresentationRequest(PresentationInfo presentationInfo, WeakReference weakReference, PaywallOverrides paywallOverrides, Flags flags, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(presentationInfo, (i3 & 2) != 0 ? null : weakReference, (i3 & 4) != 0 ? null : paywallOverrides, flags);
    }
}
