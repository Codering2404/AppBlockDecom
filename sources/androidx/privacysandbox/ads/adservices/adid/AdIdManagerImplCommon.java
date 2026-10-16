package androidx.privacysandbox.ads.adservices.adid;

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
/* JADX INFO: loaded from: classes2.dex */
@Metadata
public class AdIdManagerImplCommon extends AdIdManager {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final android.adservices.adid.AdIdManager f51110b;

    public AdIdManagerImplCommon(android.adservices.adid.AdIdManager mAdIdManager) {
        Intrinsics.checkNotNullParameter(mAdIdManager, "mAdIdManager");
        this.f51110b = mAdIdManager;
    }

    private final AdId c(android.adservices.adid.AdId adId) {
        String adId2 = adId.getAdId();
        Intrinsics.checkNotNullExpressionValue(adId2, "response.adId");
        return new AdId(adId2, adId.isLimitAdTrackingEnabled());
    }

    private final Object e(Continuation continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.c(continuation), 1);
        cancellableContinuationImpl.C();
        this.f51110b.getAdId(new androidx.credentials.c(), OutcomeReceiverKt.a(cancellableContinuationImpl));
        Object objV = cancellableContinuationImpl.v();
        if (objV == IntrinsicsKt.f()) {
            DebugProbesKt.c(continuation);
        }
        return objV;
    }

    @Override // androidx.privacysandbox.ads.adservices.adid.AdIdManager
    public Object a(Continuation<? super AdId> continuation) {
        return d(this, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static /* synthetic */ java.lang.Object d(androidx.privacysandbox.ads.adservices.adid.AdIdManagerImplCommon r4, kotlin.coroutines.Continuation<? super androidx.privacysandbox.ads.adservices.adid.AdId> r5) throws java.lang.Throwable {
        /*
            boolean r0 = r5 instanceof androidx.privacysandbox.ads.adservices.adid.AdIdManagerImplCommon$getAdId$1
            if (r0 == 0) goto L13
            r0 = r5
            androidx.privacysandbox.ads.adservices.adid.AdIdManagerImplCommon$getAdId$1 r0 = (androidx.privacysandbox.ads.adservices.adid.AdIdManagerImplCommon$getAdId$1) r0
            int r1 = r0.f51114d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f51114d = r1
            goto L18
        L13:
            androidx.privacysandbox.ads.adservices.adid.AdIdManagerImplCommon$getAdId$1 r0 = new androidx.privacysandbox.ads.adservices.adid.AdIdManagerImplCommon$getAdId$1
            r0.<init>(r4, r5)
        L18:
            java.lang.Object r5 = r0.f51112b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f51114d
            r3 = 1
            if (r2 == 0) goto L36
            if (r2 != r3) goto L2d
            java.lang.Object r4 = r0.f51111a
            androidx.privacysandbox.ads.adservices.adid.AdIdManagerImplCommon r4 = (androidx.privacysandbox.ads.adservices.adid.AdIdManagerImplCommon) r4
            kotlin.ResultKt.b(r5)
            goto L44
        L2d:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            r5 = 0
            java.lang.String r5 = androidx.glance.color.Tq.KqqtdetwHMIO.NxKW
            r4.<init>(r5)
            throw r4
        L36:
            kotlin.ResultKt.b(r5)
            r0.f51111a = r4
            r0.f51114d = r3
            java.lang.Object r5 = r4.e(r0)
            if (r5 != r1) goto L44
            return r1
        L44:
            android.adservices.adid.AdId r5 = androidx.privacysandbox.ads.adservices.adid.b.a(r5)
            androidx.privacysandbox.ads.adservices.adid.AdId r4 = r4.c(r5)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.privacysandbox.ads.adservices.adid.AdIdManagerImplCommon.d(androidx.privacysandbox.ads.adservices.adid.AdIdManagerImplCommon, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
