package androidx.privacysandbox.ads.adservices.adselection;

import androidx.core.os.OutcomeReceiverKt;
import androidx.privacysandbox.ads.adservices.internal.AdServicesInfo;
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
public class AdSelectionManagerImplCommon extends AdSelectionManager {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final android.adservices.adselection.AdSelectionManager f51130b;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    static final class Ext10Impl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Companion f51131a = new Companion(null);

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final java.lang.Object a(android.adservices.adselection.AdSelectionManager r5, androidx.privacysandbox.ads.adservices.adselection.GetAdSelectionDataRequest r6, kotlin.coroutines.Continuation<? super androidx.privacysandbox.ads.adservices.adselection.GetAdSelectionDataOutcome> r7) throws java.lang.Throwable {
                /*
                    r4 = this;
                    boolean r0 = r7 instanceof androidx.privacysandbox.ads.adservices.adselection.AdSelectionManagerImplCommon$Ext10Impl$Companion$getAdSelectionData$1
                    if (r0 == 0) goto L13
                    r0 = r7
                    androidx.privacysandbox.ads.adservices.adselection.AdSelectionManagerImplCommon$Ext10Impl$Companion$getAdSelectionData$1 r0 = (androidx.privacysandbox.ads.adservices.adselection.AdSelectionManagerImplCommon$Ext10Impl$Companion$getAdSelectionData$1) r0
                    int r1 = r0.f51136f
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.f51136f = r1
                    goto L18
                L13:
                    androidx.privacysandbox.ads.adservices.adselection.AdSelectionManagerImplCommon$Ext10Impl$Companion$getAdSelectionData$1 r0 = new androidx.privacysandbox.ads.adservices.adselection.AdSelectionManagerImplCommon$Ext10Impl$Companion$getAdSelectionData$1
                    r0.<init>(r4, r7)
                L18:
                    java.lang.Object r7 = r0.f51134c
                    java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                    int r2 = r0.f51136f
                    r3 = 1
                    if (r2 == 0) goto L3a
                    if (r2 != r3) goto L32
                    java.lang.Object r5 = r0.f51133b
                    androidx.privacysandbox.ads.adservices.adselection.GetAdSelectionDataRequest r5 = (androidx.privacysandbox.ads.adservices.adselection.GetAdSelectionDataRequest) r5
                    java.lang.Object r5 = r0.f51132a
                    androidx.privacysandbox.ads.adservices.adselection.u.a(r5)
                    kotlin.ResultKt.b(r7)
                    goto L6f
                L32:
                    java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                    java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                    r5.<init>(r6)
                    throw r5
                L3a:
                    kotlin.ResultKt.b(r7)
                    r0.f51132a = r5
                    r0.f51133b = r6
                    r0.f51136f = r3
                    kotlinx.coroutines.CancellableContinuationImpl r7 = new kotlinx.coroutines.CancellableContinuationImpl
                    kotlin.coroutines.Continuation r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.c(r0)
                    r7.<init>(r2, r3)
                    r7.C()
                    android.adservices.adselection.GetAdSelectionDataRequest r6 = r6.a()
                    androidx.credentials.c r2 = new androidx.credentials.c
                    r2.<init>()
                    android.os.OutcomeReceiver r3 = androidx.core.os.OutcomeReceiverKt.a(r7)
                    androidx.privacysandbox.ads.adservices.adselection.v.a(r5, r6, r2, r3)
                    java.lang.Object r7 = r7.v()
                    java.lang.Object r5 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                    if (r7 != r5) goto L6c
                    kotlin.coroutines.jvm.internal.DebugProbesKt.c(r0)
                L6c:
                    if (r7 != r1) goto L6f
                    return r1
                L6f:
                    android.adservices.adselection.GetAdSelectionDataOutcome r5 = androidx.privacysandbox.ads.adservices.adselection.w.a(r7)
                    androidx.privacysandbox.ads.adservices.adselection.GetAdSelectionDataOutcome r6 = new androidx.privacysandbox.ads.adservices.adselection.GetAdSelectionDataOutcome
                    r6.<init>(r5)
                    return r6
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.privacysandbox.ads.adservices.adselection.AdSelectionManagerImplCommon.Ext10Impl.Companion.a(android.adservices.adselection.AdSelectionManager, androidx.privacysandbox.ads.adservices.adselection.GetAdSelectionDataRequest, kotlin.coroutines.Continuation):java.lang.Object");
            }

            /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final java.lang.Object b(android.adservices.adselection.AdSelectionManager r5, androidx.privacysandbox.ads.adservices.adselection.PersistAdSelectionResultRequest r6, kotlin.coroutines.Continuation<? super androidx.privacysandbox.ads.adservices.adselection.AdSelectionOutcome> r7) throws java.lang.Throwable {
                /*
                    r4 = this;
                    boolean r0 = r7 instanceof androidx.privacysandbox.ads.adservices.adselection.AdSelectionManagerImplCommon$Ext10Impl$Companion$persistAdSelectionResult$1
                    if (r0 == 0) goto L13
                    r0 = r7
                    androidx.privacysandbox.ads.adservices.adselection.AdSelectionManagerImplCommon$Ext10Impl$Companion$persistAdSelectionResult$1 r0 = (androidx.privacysandbox.ads.adservices.adselection.AdSelectionManagerImplCommon$Ext10Impl$Companion$persistAdSelectionResult$1) r0
                    int r1 = r0.f51141f
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.f51141f = r1
                    goto L18
                L13:
                    androidx.privacysandbox.ads.adservices.adselection.AdSelectionManagerImplCommon$Ext10Impl$Companion$persistAdSelectionResult$1 r0 = new androidx.privacysandbox.ads.adservices.adselection.AdSelectionManagerImplCommon$Ext10Impl$Companion$persistAdSelectionResult$1
                    r0.<init>(r4, r7)
                L18:
                    java.lang.Object r7 = r0.f51139c
                    java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                    int r2 = r0.f51141f
                    r3 = 1
                    if (r2 == 0) goto L3a
                    if (r2 != r3) goto L32
                    java.lang.Object r5 = r0.f51138b
                    androidx.privacysandbox.ads.adservices.adselection.PersistAdSelectionResultRequest r5 = (androidx.privacysandbox.ads.adservices.adselection.PersistAdSelectionResultRequest) r5
                    java.lang.Object r5 = r0.f51137a
                    androidx.privacysandbox.ads.adservices.adselection.u.a(r5)
                    kotlin.ResultKt.b(r7)
                    goto L6f
                L32:
                    java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                    java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                    r5.<init>(r6)
                    throw r5
                L3a:
                    kotlin.ResultKt.b(r7)
                    r0.f51137a = r5
                    r0.f51138b = r6
                    r0.f51141f = r3
                    kotlinx.coroutines.CancellableContinuationImpl r7 = new kotlinx.coroutines.CancellableContinuationImpl
                    kotlin.coroutines.Continuation r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.c(r0)
                    r7.<init>(r2, r3)
                    r7.C()
                    android.adservices.adselection.PersistAdSelectionResultRequest r6 = r6.a()
                    androidx.credentials.c r2 = new androidx.credentials.c
                    r2.<init>()
                    android.os.OutcomeReceiver r3 = androidx.core.os.OutcomeReceiverKt.a(r7)
                    androidx.privacysandbox.ads.adservices.adselection.x.a(r5, r6, r2, r3)
                    java.lang.Object r7 = r7.v()
                    java.lang.Object r5 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                    if (r7 != r5) goto L6c
                    kotlin.coroutines.jvm.internal.DebugProbesKt.c(r0)
                L6c:
                    if (r7 != r1) goto L6f
                    return r1
                L6f:
                    android.adservices.adselection.AdSelectionOutcome r5 = androidx.privacysandbox.ads.adservices.adselection.q.a(r7)
                    androidx.privacysandbox.ads.adservices.adselection.AdSelectionOutcome r6 = new androidx.privacysandbox.ads.adservices.adselection.AdSelectionOutcome
                    r6.<init>(r5)
                    return r6
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.privacysandbox.ads.adservices.adselection.AdSelectionManagerImplCommon.Ext10Impl.Companion.b(android.adservices.adselection.AdSelectionManager, androidx.privacysandbox.ads.adservices.adselection.PersistAdSelectionResultRequest, kotlin.coroutines.Continuation):java.lang.Object");
            }

            /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final java.lang.Object c(android.adservices.adselection.AdSelectionManager r5, androidx.privacysandbox.ads.adservices.adselection.AdSelectionFromOutcomesConfig r6, kotlin.coroutines.Continuation<? super androidx.privacysandbox.ads.adservices.adselection.AdSelectionOutcome> r7) throws java.lang.Throwable {
                /*
                    r4 = this;
                    boolean r0 = r7 instanceof androidx.privacysandbox.ads.adservices.adselection.AdSelectionManagerImplCommon$Ext10Impl$Companion$selectAds$1
                    if (r0 == 0) goto L13
                    r0 = r7
                    androidx.privacysandbox.ads.adservices.adselection.AdSelectionManagerImplCommon$Ext10Impl$Companion$selectAds$1 r0 = (androidx.privacysandbox.ads.adservices.adselection.AdSelectionManagerImplCommon$Ext10Impl$Companion$selectAds$1) r0
                    int r1 = r0.f51146f
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.f51146f = r1
                    goto L18
                L13:
                    androidx.privacysandbox.ads.adservices.adselection.AdSelectionManagerImplCommon$Ext10Impl$Companion$selectAds$1 r0 = new androidx.privacysandbox.ads.adservices.adselection.AdSelectionManagerImplCommon$Ext10Impl$Companion$selectAds$1
                    r0.<init>(r4, r7)
                L18:
                    java.lang.Object r7 = r0.f51144c
                    java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                    int r2 = r0.f51146f
                    r3 = 1
                    if (r2 == 0) goto L3a
                    if (r2 != r3) goto L32
                    java.lang.Object r5 = r0.f51143b
                    androidx.privacysandbox.ads.adservices.adselection.AdSelectionFromOutcomesConfig r5 = (androidx.privacysandbox.ads.adservices.adselection.AdSelectionFromOutcomesConfig) r5
                    java.lang.Object r5 = r0.f51142a
                    androidx.privacysandbox.ads.adservices.adselection.u.a(r5)
                    kotlin.ResultKt.b(r7)
                    goto L6f
                L32:
                    java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                    java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                    r5.<init>(r6)
                    throw r5
                L3a:
                    kotlin.ResultKt.b(r7)
                    r0.f51142a = r5
                    r0.f51143b = r6
                    r0.f51146f = r3
                    kotlinx.coroutines.CancellableContinuationImpl r7 = new kotlinx.coroutines.CancellableContinuationImpl
                    kotlin.coroutines.Continuation r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.c(r0)
                    r7.<init>(r2, r3)
                    r7.C()
                    android.adservices.adselection.AdSelectionFromOutcomesConfig r6 = r6.a()
                    androidx.credentials.c r2 = new androidx.credentials.c
                    r2.<init>()
                    android.os.OutcomeReceiver r3 = androidx.core.os.OutcomeReceiverKt.a(r7)
                    androidx.privacysandbox.ads.adservices.adselection.t.a(r5, r6, r2, r3)
                    java.lang.Object r7 = r7.v()
                    java.lang.Object r5 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                    if (r7 != r5) goto L6c
                    kotlin.coroutines.jvm.internal.DebugProbesKt.c(r0)
                L6c:
                    if (r7 != r1) goto L6f
                    return r1
                L6f:
                    android.adservices.adselection.AdSelectionOutcome r5 = androidx.privacysandbox.ads.adservices.adselection.q.a(r7)
                    androidx.privacysandbox.ads.adservices.adselection.AdSelectionOutcome r6 = new androidx.privacysandbox.ads.adservices.adselection.AdSelectionOutcome
                    r6.<init>(r5)
                    return r6
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.privacysandbox.ads.adservices.adselection.AdSelectionManagerImplCommon.Ext10Impl.Companion.c(android.adservices.adselection.AdSelectionManager, androidx.privacysandbox.ads.adservices.adselection.AdSelectionFromOutcomesConfig, kotlin.coroutines.Continuation):java.lang.Object");
            }

            private Companion() {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class Ext8Impl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Companion f51147a = new Companion(null);

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final Object a(android.adservices.adselection.AdSelectionManager adSelectionManager, ReportEventRequest reportEventRequest, Continuation<? super Unit> continuation) {
                CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.c(continuation), 1);
                cancellableContinuationImpl.C();
                adSelectionManager.reportEvent(reportEventRequest.a(), new androidx.credentials.c(), OutcomeReceiverKt.a(cancellableContinuationImpl));
                Object objV = cancellableContinuationImpl.v();
                if (objV == IntrinsicsKt.f()) {
                    DebugProbesKt.c(continuation);
                }
                return objV == IntrinsicsKt.f() ? objV : Unit.f139807a;
            }

            public final Object b(android.adservices.adselection.AdSelectionManager adSelectionManager, UpdateAdCounterHistogramRequest updateAdCounterHistogramRequest, Continuation<? super Unit> continuation) {
                CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.c(continuation), 1);
                cancellableContinuationImpl.C();
                adSelectionManager.updateAdCounterHistogram(updateAdCounterHistogramRequest.a(), new androidx.credentials.c(), OutcomeReceiverKt.a(cancellableContinuationImpl));
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

    public AdSelectionManagerImplCommon(android.adservices.adselection.AdSelectionManager mAdSelectionManager) {
        Intrinsics.checkNotNullParameter(mAdSelectionManager, "mAdSelectionManager");
        this.f51130b = mAdSelectionManager;
    }

    static /* synthetic */ Object h(AdSelectionManagerImplCommon adSelectionManagerImplCommon, GetAdSelectionDataRequest getAdSelectionDataRequest, Continuation<? super GetAdSelectionDataOutcome> continuation) {
        AdServicesInfo adServicesInfo = AdServicesInfo.f51231a;
        if (adServicesInfo.a() >= 10 || adServicesInfo.b() >= 10) {
            return Ext10Impl.f51131a.a(adSelectionManagerImplCommon.f51130b, getAdSelectionDataRequest, continuation);
        }
        throw new UnsupportedOperationException("API is not available. Min version is API 31 ext 10");
    }

    static /* synthetic */ Object j(AdSelectionManagerImplCommon adSelectionManagerImplCommon, PersistAdSelectionResultRequest persistAdSelectionResultRequest, Continuation<? super AdSelectionOutcome> continuation) {
        AdServicesInfo adServicesInfo = AdServicesInfo.f51231a;
        if (adServicesInfo.a() >= 10 || adServicesInfo.b() >= 10) {
            return Ext10Impl.f51131a.b(adSelectionManagerImplCommon.f51130b, persistAdSelectionResultRequest, continuation);
        }
        throw new UnsupportedOperationException("API is not available. Min version is API 31 ext 10");
    }

    static /* synthetic */ Object k(AdSelectionManagerImplCommon adSelectionManagerImplCommon, ReportEventRequest reportEventRequest, Continuation<? super Unit> continuation) {
        AdServicesInfo adServicesInfo = AdServicesInfo.f51231a;
        if (adServicesInfo.a() < 8 && adServicesInfo.b() < 9) {
            throw new UnsupportedOperationException("API is unsupported. Min version is API 33 ext 8 or API 31/32 ext 9");
        }
        Object objA = Ext8Impl.f51147a.a(adSelectionManagerImplCommon.f51130b, reportEventRequest, continuation);
        return objA == IntrinsicsKt.f() ? objA : Unit.f139807a;
    }

    static /* synthetic */ Object l(AdSelectionManagerImplCommon adSelectionManagerImplCommon, ReportImpressionRequest reportImpressionRequest, Continuation<? super Unit> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.c(continuation), 1);
        cancellableContinuationImpl.C();
        adSelectionManagerImplCommon.i().reportImpression(reportImpressionRequest.a(), new androidx.credentials.c(), OutcomeReceiverKt.a(cancellableContinuationImpl));
        Object objV = cancellableContinuationImpl.v();
        if (objV == IntrinsicsKt.f()) {
            DebugProbesKt.c(continuation);
        }
        return objV == IntrinsicsKt.f() ? objV : Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static /* synthetic */ java.lang.Object m(androidx.privacysandbox.ads.adservices.adselection.AdSelectionManagerImplCommon r4, androidx.privacysandbox.ads.adservices.adselection.AdSelectionConfig r5, kotlin.coroutines.Continuation<? super androidx.privacysandbox.ads.adservices.adselection.AdSelectionOutcome> r6) throws java.lang.Throwable {
        /*
            boolean r0 = r6 instanceof androidx.privacysandbox.ads.adservices.adselection.AdSelectionManagerImplCommon$selectAds$1
            if (r0 == 0) goto L13
            r0 = r6
            androidx.privacysandbox.ads.adservices.adselection.AdSelectionManagerImplCommon$selectAds$1 r0 = (androidx.privacysandbox.ads.adservices.adselection.AdSelectionManagerImplCommon$selectAds$1) r0
            int r1 = r0.f51150c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f51150c = r1
            goto L18
        L13:
            androidx.privacysandbox.ads.adservices.adselection.AdSelectionManagerImplCommon$selectAds$1 r0 = new androidx.privacysandbox.ads.adservices.adselection.AdSelectionManagerImplCommon$selectAds$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.f51148a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f51150c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.ResultKt.b(r6)
            goto L41
        L29:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L31:
            kotlin.ResultKt.b(r6)
            android.adservices.adselection.AdSelectionConfig r5 = r5.d()
            r0.f51150c = r3
            java.lang.Object r6 = r4.o(r5, r0)
            if (r6 != r1) goto L41
            return r1
        L41:
            android.adservices.adselection.AdSelectionOutcome r4 = androidx.privacysandbox.ads.adservices.adselection.q.a(r6)
            androidx.privacysandbox.ads.adservices.adselection.AdSelectionOutcome r5 = new androidx.privacysandbox.ads.adservices.adselection.AdSelectionOutcome
            r5.<init>(r4)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.privacysandbox.ads.adservices.adselection.AdSelectionManagerImplCommon.m(androidx.privacysandbox.ads.adservices.adselection.AdSelectionManagerImplCommon, androidx.privacysandbox.ads.adservices.adselection.AdSelectionConfig, kotlin.coroutines.Continuation):java.lang.Object");
    }

    static /* synthetic */ Object n(AdSelectionManagerImplCommon adSelectionManagerImplCommon, AdSelectionFromOutcomesConfig adSelectionFromOutcomesConfig, Continuation<? super AdSelectionOutcome> continuation) {
        AdServicesInfo adServicesInfo = AdServicesInfo.f51231a;
        if (adServicesInfo.a() >= 10 || adServicesInfo.b() >= 10) {
            return Ext10Impl.f51131a.c(adSelectionManagerImplCommon.f51130b, adSelectionFromOutcomesConfig, continuation);
        }
        throw new UnsupportedOperationException("API is not available. Min version is API 31 ext 10");
    }

    private final Object o(android.adservices.adselection.AdSelectionConfig adSelectionConfig, Continuation continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.c(continuation), 1);
        cancellableContinuationImpl.C();
        i().selectAds(adSelectionConfig, new androidx.credentials.c(), OutcomeReceiverKt.a(cancellableContinuationImpl));
        Object objV = cancellableContinuationImpl.v();
        if (objV == IntrinsicsKt.f()) {
            DebugProbesKt.c(continuation);
        }
        return objV;
    }

    static /* synthetic */ Object p(AdSelectionManagerImplCommon adSelectionManagerImplCommon, UpdateAdCounterHistogramRequest updateAdCounterHistogramRequest, Continuation<? super Unit> continuation) {
        AdServicesInfo adServicesInfo = AdServicesInfo.f51231a;
        if (adServicesInfo.a() < 8 && adServicesInfo.b() < 9) {
            throw new UnsupportedOperationException("API is unsupported. Min version is API 33 ext 8 or API 31/32 ext 9");
        }
        Object objB = Ext8Impl.f51147a.b(adSelectionManagerImplCommon.f51130b, updateAdCounterHistogramRequest, continuation);
        return objB == IntrinsicsKt.f() ? objB : Unit.f139807a;
    }

    @Override // androidx.privacysandbox.ads.adservices.adselection.AdSelectionManager
    public Object a(GetAdSelectionDataRequest getAdSelectionDataRequest, Continuation<? super GetAdSelectionDataOutcome> continuation) {
        return h(this, getAdSelectionDataRequest, continuation);
    }

    @Override // androidx.privacysandbox.ads.adservices.adselection.AdSelectionManager
    public Object b(PersistAdSelectionResultRequest persistAdSelectionResultRequest, Continuation<? super AdSelectionOutcome> continuation) {
        return j(this, persistAdSelectionResultRequest, continuation);
    }

    @Override // androidx.privacysandbox.ads.adservices.adselection.AdSelectionManager
    public Object c(ReportEventRequest reportEventRequest, Continuation<? super Unit> continuation) {
        return k(this, reportEventRequest, continuation);
    }

    @Override // androidx.privacysandbox.ads.adservices.adselection.AdSelectionManager
    public Object d(ReportImpressionRequest reportImpressionRequest, Continuation<? super Unit> continuation) {
        return l(this, reportImpressionRequest, continuation);
    }

    @Override // androidx.privacysandbox.ads.adservices.adselection.AdSelectionManager
    public Object e(AdSelectionConfig adSelectionConfig, Continuation<? super AdSelectionOutcome> continuation) {
        return m(this, adSelectionConfig, continuation);
    }

    @Override // androidx.privacysandbox.ads.adservices.adselection.AdSelectionManager
    public Object f(AdSelectionFromOutcomesConfig adSelectionFromOutcomesConfig, Continuation<? super AdSelectionOutcome> continuation) {
        return n(this, adSelectionFromOutcomesConfig, continuation);
    }

    @Override // androidx.privacysandbox.ads.adservices.adselection.AdSelectionManager
    public Object g(UpdateAdCounterHistogramRequest updateAdCounterHistogramRequest, Continuation<? super Unit> continuation) {
        return p(this, updateAdCounterHistogramRequest, continuation);
    }

    protected final android.adservices.adselection.AdSelectionManager i() {
        return this.f51130b;
    }
}
