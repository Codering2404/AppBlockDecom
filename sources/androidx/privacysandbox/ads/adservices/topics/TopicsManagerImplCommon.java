package androidx.privacysandbox.ads.adservices.topics;

import androidx.core.os.OutcomeReceiverKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public class TopicsManagerImplCommon extends TopicsManager {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final android.adservices.topics.TopicsManager f51371b;

    public TopicsManagerImplCommon(android.adservices.topics.TopicsManager mTopicsManager) {
        Intrinsics.checkNotNullParameter(mTopicsManager, "mTopicsManager");
        this.f51371b = mTopicsManager;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static /* synthetic */ java.lang.Object e(androidx.privacysandbox.ads.adservices.topics.TopicsManagerImplCommon r4, androidx.privacysandbox.ads.adservices.topics.GetTopicsRequest r5, kotlin.coroutines.Continuation<? super androidx.privacysandbox.ads.adservices.topics.GetTopicsResponse> r6) throws java.lang.Throwable {
        /*
            boolean r0 = r6 instanceof androidx.privacysandbox.ads.adservices.topics.TopicsManagerImplCommon$getTopics$1
            if (r0 == 0) goto L13
            r0 = r6
            androidx.privacysandbox.ads.adservices.topics.TopicsManagerImplCommon$getTopics$1 r0 = (androidx.privacysandbox.ads.adservices.topics.TopicsManagerImplCommon$getTopics$1) r0
            int r1 = r0.f51375d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f51375d = r1
            goto L18
        L13:
            androidx.privacysandbox.ads.adservices.topics.TopicsManagerImplCommon$getTopics$1 r0 = new androidx.privacysandbox.ads.adservices.topics.TopicsManagerImplCommon$getTopics$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.f51373b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f51375d
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r4 = r0.f51372a
            androidx.privacysandbox.ads.adservices.topics.TopicsManagerImplCommon r4 = (androidx.privacysandbox.ads.adservices.topics.TopicsManagerImplCommon) r4
            kotlin.ResultKt.b(r6)
            goto L47
        L2d:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L35:
            kotlin.ResultKt.b(r6)
            android.adservices.topics.GetTopicsRequest r5 = r4.c(r5)
            r0.f51372a = r4
            r0.f51375d = r3
            java.lang.Object r6 = r4.f(r5, r0)
            if (r6 != r1) goto L47
            return r1
        L47:
            android.adservices.topics.GetTopicsResponse r6 = (android.adservices.topics.GetTopicsResponse) r6
            androidx.privacysandbox.ads.adservices.topics.GetTopicsResponse r4 = r4.d(r6)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.privacysandbox.ads.adservices.topics.TopicsManagerImplCommon.e(androidx.privacysandbox.ads.adservices.topics.TopicsManagerImplCommon, androidx.privacysandbox.ads.adservices.topics.GetTopicsRequest, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final Object f(android.adservices.topics.GetTopicsRequest getTopicsRequest, Continuation continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.c(continuation), 1);
        cancellableContinuationImpl.C();
        this.f51371b.b(getTopicsRequest, new androidx.credentials.c(), OutcomeReceiverKt.a(cancellableContinuationImpl));
        Object objV = cancellableContinuationImpl.v();
        if (objV == IntrinsicsKt.f()) {
            DebugProbesKt.c(continuation);
        }
        return objV;
    }

    @Override // androidx.privacysandbox.ads.adservices.topics.TopicsManager
    public Object a(GetTopicsRequest getTopicsRequest, Continuation<? super GetTopicsResponse> continuation) {
        return e(this, getTopicsRequest, continuation);
    }

    public android.adservices.topics.GetTopicsRequest c(GetTopicsRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        return GetTopicsRequestHelper.f51361a.b(request);
    }

    public GetTopicsResponse d(android.adservices.topics.GetTopicsResponse response) {
        Intrinsics.checkNotNullParameter(response, "response");
        return GetTopicsResponseHelper.f51364a.a(response);
    }
}
