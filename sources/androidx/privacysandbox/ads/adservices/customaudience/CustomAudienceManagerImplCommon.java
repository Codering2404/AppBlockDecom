package androidx.privacysandbox.ads.adservices.customaudience;

import android.adservices.customaudience.CustomAudience;
import androidx.core.os.OutcomeReceiverKt;
import androidx.privacysandbox.ads.adservices.common.AdData;
import androidx.privacysandbox.ads.adservices.common.AdSelectionSignals;
import androidx.privacysandbox.ads.adservices.internal.AdServicesInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuationImpl;

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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public class CustomAudienceManagerImplCommon extends CustomAudienceManager {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final android.adservices.customaudience.CustomAudienceManager f51219b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class Ext10Impl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Companion f51220a = new Companion(null);

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final Object a(android.adservices.customaudience.CustomAudienceManager customAudienceManager, FetchAndJoinCustomAudienceRequest fetchAndJoinCustomAudienceRequest, Continuation<? super Unit> continuation) {
                CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.c(continuation), 1);
                cancellableContinuationImpl.C();
                customAudienceManager.fetchAndJoinCustomAudience(fetchAndJoinCustomAudienceRequest.a(), new androidx.credentials.c(), OutcomeReceiverKt.a(cancellableContinuationImpl));
                Object objV = cancellableContinuationImpl.v();
                if (objV == IntrinsicsKt.f()) {
                    DebugProbesKt.c(continuation);
                }
                return objV == IntrinsicsKt.f() ? objV : Unit.f139807a;
            }

            private Companion() {
            }
        }
    }

    public CustomAudienceManagerImplCommon(android.adservices.customaudience.CustomAudienceManager customAudienceManager) {
        Intrinsics.checkNotNullParameter(customAudienceManager, "customAudienceManager");
        this.f51219b = customAudienceManager;
    }

    private final List f(List list) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((AdData) it.next()).a());
        }
        return arrayList;
    }

    private final android.adservices.customaudience.CustomAudience g(CustomAudience customAudience) {
        CustomAudience.Builder trustedBiddingData = c.a().setActivationTime(customAudience.a()).setAds(f(customAudience.b())).setBiddingLogicUri(customAudience.c()).setBuyer(customAudience.d().a()).setDailyUpdateUri(customAudience.e()).setExpirationTime(customAudience.f()).setName(customAudience.g()).setTrustedBiddingData(j(customAudience.h()));
        AdSelectionSignals adSelectionSignalsI = customAudience.i();
        android.adservices.customaudience.CustomAudience customAudienceBuild = trustedBiddingData.setUserBiddingSignals(adSelectionSignalsI != null ? adSelectionSignalsI.a() : null).build();
        Intrinsics.checkNotNullExpressionValue(customAudienceBuild, "Builder()\n            .s…s())\n            .build()");
        return customAudienceBuild;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final android.adservices.customaudience.JoinCustomAudienceRequest h(JoinCustomAudienceRequest joinCustomAudienceRequest) {
        android.adservices.customaudience.JoinCustomAudienceRequest joinCustomAudienceRequestBuild = y.a().setCustomAudience(g(joinCustomAudienceRequest.a())).build();
        Intrinsics.checkNotNullExpressionValue(joinCustomAudienceRequestBuild, "Builder()\n            .s…ce))\n            .build()");
        return joinCustomAudienceRequestBuild;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final android.adservices.customaudience.LeaveCustomAudienceRequest i(LeaveCustomAudienceRequest leaveCustomAudienceRequest) {
        android.adservices.customaudience.LeaveCustomAudienceRequest leaveCustomAudienceRequestBuild = w.a().setBuyer(leaveCustomAudienceRequest.a().a()).setName(leaveCustomAudienceRequest.b()).build();
        Intrinsics.checkNotNullExpressionValue(leaveCustomAudienceRequestBuild, "Builder()\n            .s…ame)\n            .build()");
        return leaveCustomAudienceRequestBuild;
    }

    private final android.adservices.customaudience.TrustedBiddingData j(TrustedBiddingData trustedBiddingData) {
        if (trustedBiddingData == null) {
            return null;
        }
        return x.a().setTrustedBiddingKeys(trustedBiddingData.a()).setTrustedBiddingUri(trustedBiddingData.b()).build();
    }

    static /* synthetic */ Object k(CustomAudienceManagerImplCommon customAudienceManagerImplCommon, FetchAndJoinCustomAudienceRequest fetchAndJoinCustomAudienceRequest, Continuation<? super Unit> continuation) {
        AdServicesInfo adServicesInfo = AdServicesInfo.f51231a;
        if (adServicesInfo.a() < 10 && adServicesInfo.b() < 10) {
            throw new UnsupportedOperationException("API is not available. Min version is API 31 ext 10");
        }
        Object objA = Ext10Impl.f51220a.a(customAudienceManagerImplCommon.f51219b, fetchAndJoinCustomAudienceRequest, continuation);
        return objA == IntrinsicsKt.f() ? objA : Unit.f139807a;
    }

    static /* synthetic */ Object m(CustomAudienceManagerImplCommon customAudienceManagerImplCommon, JoinCustomAudienceRequest joinCustomAudienceRequest, Continuation<? super Unit> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.c(continuation), 1);
        cancellableContinuationImpl.C();
        customAudienceManagerImplCommon.l().joinCustomAudience(customAudienceManagerImplCommon.h(joinCustomAudienceRequest), new androidx.credentials.c(), OutcomeReceiverKt.a(cancellableContinuationImpl));
        Object objV = cancellableContinuationImpl.v();
        if (objV == IntrinsicsKt.f()) {
            DebugProbesKt.c(continuation);
        }
        return objV == IntrinsicsKt.f() ? objV : Unit.f139807a;
    }

    static /* synthetic */ Object n(CustomAudienceManagerImplCommon customAudienceManagerImplCommon, LeaveCustomAudienceRequest leaveCustomAudienceRequest, Continuation<? super Unit> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.c(continuation), 1);
        cancellableContinuationImpl.C();
        customAudienceManagerImplCommon.l().leaveCustomAudience(customAudienceManagerImplCommon.i(leaveCustomAudienceRequest), new androidx.credentials.c(), OutcomeReceiverKt.a(cancellableContinuationImpl));
        Object objV = cancellableContinuationImpl.v();
        if (objV == IntrinsicsKt.f()) {
            DebugProbesKt.c(continuation);
        }
        return objV == IntrinsicsKt.f() ? objV : Unit.f139807a;
    }

    @Override // androidx.privacysandbox.ads.adservices.customaudience.CustomAudienceManager
    public Object a(FetchAndJoinCustomAudienceRequest fetchAndJoinCustomAudienceRequest, Continuation<? super Unit> continuation) {
        return k(this, fetchAndJoinCustomAudienceRequest, continuation);
    }

    @Override // androidx.privacysandbox.ads.adservices.customaudience.CustomAudienceManager
    public Object b(JoinCustomAudienceRequest joinCustomAudienceRequest, Continuation<? super Unit> continuation) {
        return m(this, joinCustomAudienceRequest, continuation);
    }

    @Override // androidx.privacysandbox.ads.adservices.customaudience.CustomAudienceManager
    public Object c(LeaveCustomAudienceRequest leaveCustomAudienceRequest, Continuation<? super Unit> continuation) {
        return n(this, leaveCustomAudienceRequest, continuation);
    }

    protected final android.adservices.customaudience.CustomAudienceManager l() {
        return this.f51219b;
    }
}
