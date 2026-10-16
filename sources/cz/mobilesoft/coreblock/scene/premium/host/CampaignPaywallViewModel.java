package cz.mobilesoft.coreblock.scene.premium.host;

import android.app.Application;
import androidx.compose.material.icons.twotone.Phg.QaXmqxvjHhxVy;
import cz.mobilesoft.coreblock.rest.response.CampaignOfferResponse;
import cz.mobilesoft.coreblock.scene.premium.PremiumScreenViewState;
import cz.mobilesoft.coreblock.scene.premium.host.PaywallHostViewModel;
import cz.mobilesoft.coreblock.scene.premium.host.PaywallTarget;
import cz.mobilesoft.coreblock.storage.sharedprefs.PrefManager;
import cz.mobilesoft.coreblock.util.Success;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class CampaignPaywallViewModel extends PaywallHostViewModel {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class CampaignScreenTypeViewState extends PremiumScreenViewState.PremiumScreenTypeViewState {

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public static final int f113124p = PremiumScreenViewState.PremiumScreenTypeViewState.f112517i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private final CampaignOfferResponse f113125j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private final boolean f113126k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private final boolean f113127l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private final boolean f113128m = true;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private final boolean f113129n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private final boolean f113130o;

        public CampaignScreenTypeViewState(CampaignOfferResponse campaignOfferResponse, boolean z2, boolean z3) {
            this.f113125j = campaignOfferResponse;
            this.f113126k = z2;
            this.f113127l = z3;
            this.f113129n = z2;
            this.f113130o = z3;
        }

        @Override // cz.mobilesoft.coreblock.scene.premium.PremiumScreenViewState.PremiumScreenTypeViewState
        public boolean c() {
            return this.f113129n;
        }

        @Override // cz.mobilesoft.coreblock.scene.premium.PremiumScreenViewState.PremiumScreenTypeViewState
        public String d(boolean z2) {
            return PrefManager.f126839a.M0();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof CampaignScreenTypeViewState)) {
                return false;
            }
            CampaignScreenTypeViewState campaignScreenTypeViewState = (CampaignScreenTypeViewState) obj;
            return Intrinsics.areEqual(this.f113125j, campaignScreenTypeViewState.f113125j) && this.f113126k == campaignScreenTypeViewState.f113126k && this.f113127l == campaignScreenTypeViewState.f113127l;
        }

        @Override // cz.mobilesoft.coreblock.scene.premium.PremiumScreenViewState.PremiumScreenTypeViewState
        public boolean g() {
            return this.f113128m;
        }

        public int hashCode() {
            CampaignOfferResponse campaignOfferResponse = this.f113125j;
            return ((((campaignOfferResponse == null ? 0 : campaignOfferResponse.hashCode()) * 31) + Boolean.hashCode(this.f113126k)) * 31) + Boolean.hashCode(this.f113127l);
        }

        @Override // cz.mobilesoft.coreblock.scene.premium.PremiumScreenViewState.PremiumScreenTypeViewState
        public boolean i() {
            return this.f113130o;
        }

        public final CampaignOfferResponse j() {
            return this.f113125j;
        }

        public String toString() {
            return "CampaignScreenTypeViewState(campaignDTO=" + this.f113125j + ", closeButton=" + this.f113126k + ", skipText=" + this.f113127l + ")";
        }
    }

    private final PaywallTarget.Campaign L2() {
        PaywallTarget paywallTargetH2 = H2();
        Intrinsics.checkNotNull(paywallTargetH2, "null cannot be cast to non-null type cz.mobilesoft.coreblock.scene.premium.host.PaywallTarget.Campaign");
        return (PaywallTarget.Campaign) paywallTargetH2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PremiumScreenViewState M2(CampaignOfferResponse campaignOfferResponse, CampaignPaywallViewModel campaignPaywallViewModel, PremiumScreenViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return PremiumScreenViewState.b(updateState, new CampaignScreenTypeViewState(campaignOfferResponse, campaignPaywallViewModel.F2().c(), campaignPaywallViewModel.F2().d()), null, null, null, Success.f128020a, null, null, null, null, false, false, null, false, false, false, false, false, false, null, null, null, null, false, false, false, null, null, null, null, null, false, false, false, -18, 1, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    @Override // cz.mobilesoft.coreblock.scene.premium.host.PaywallHostViewModel, cz.mobilesoft.coreblock.scene.premium.PremiumScreenViewModel
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object h2(kotlin.coroutines.Continuation r8) throws java.lang.Throwable {
        /*
            r7 = this;
            boolean r0 = r8 instanceof cz.mobilesoft.coreblock.scene.premium.host.CampaignPaywallViewModel$loadPlacement$1
            if (r0 == 0) goto L14
            r0 = r8
            cz.mobilesoft.coreblock.scene.premium.host.CampaignPaywallViewModel$loadPlacement$1 r0 = (cz.mobilesoft.coreblock.scene.premium.host.CampaignPaywallViewModel$loadPlacement$1) r0
            int r1 = r0.f113133c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.f113133c = r1
        L12:
            r6 = r0
            goto L1a
        L14:
            cz.mobilesoft.coreblock.scene.premium.host.CampaignPaywallViewModel$loadPlacement$1 r0 = new cz.mobilesoft.coreblock.scene.premium.host.CampaignPaywallViewModel$loadPlacement$1
            r0.<init>(r7, r8)
            goto L12
        L1a:
            java.lang.Object r8 = r6.f113131a
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r6.f113133c
            r2 = 1
            if (r1 == 0) goto L33
            if (r1 != r2) goto L2b
            kotlin.ResultKt.b(r8)
            goto L57
        L2b:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L33:
            kotlin.ResultKt.b(r8)
            cz.mobilesoft.coreblock.util.subscription.DiscountRepository r1 = r7.T1()
            cz.mobilesoft.coreblock.scene.premium.host.PaywallTarget$Campaign r8 = r7.L2()
            long r3 = r8.getCampaignId()
            cz.mobilesoft.coreblock.scene.premium.host.PaywallTarget$Campaign r8 = r7.L2()
            cz.mobilesoft.coreblock.scene.premium.dto.CampaignSource r8 = r8.getCampaignSource()
            cz.mobilesoft.coreblock.enums.RevenueCatPlacement r5 = cz.mobilesoft.coreblock.enums.RevenueCatPlacement.Campaign
            r6.f113133c = r2
            r2 = r3
            r4 = r8
            java.lang.Object r8 = r1.f(r2, r4, r5, r6)
            if (r8 != r0) goto L57
            return r0
        L57:
            cz.mobilesoft.coreblock.rest.response.CampaignOfferResponse r8 = (cz.mobilesoft.coreblock.rest.response.CampaignOfferResponse) r8
            cz.mobilesoft.coreblock.scene.premium.host.a r0 = new cz.mobilesoft.coreblock.scene.premium.host.a
            r0.<init>()
            r7.Q0(r0)
            cz.mobilesoft.coreblock.enums.RevenueCatPlacement r8 = cz.mobilesoft.coreblock.enums.RevenueCatPlacement.Campaign
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.premium.host.CampaignPaywallViewModel.h2(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CampaignPaywallViewModel(Application application, PaywallTarget.Campaign target, PaywallSpec spec, PaywallHostViewModel.Launch launch) {
        super(application, target, spec, launch);
        Intrinsics.checkNotNullParameter(application, QaXmqxvjHhxVy.TOgkoAF);
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(spec, "spec");
        Intrinsics.checkNotNullParameter(launch, "launch");
        start();
    }
}
