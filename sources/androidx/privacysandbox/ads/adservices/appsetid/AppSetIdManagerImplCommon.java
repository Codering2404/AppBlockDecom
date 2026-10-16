package androidx.privacysandbox.ads.adservices.appsetid;

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
public class AppSetIdManagerImplCommon extends AppSetIdManager {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final android.adservices.appsetid.AppSetIdManager f51184b;

    public AppSetIdManagerImplCommon(android.adservices.appsetid.AppSetIdManager mAppSetIdManager) {
        Intrinsics.checkNotNullParameter(mAppSetIdManager, "mAppSetIdManager");
        this.f51184b = mAppSetIdManager;
    }

    private final AppSetId c(android.adservices.appsetid.AppSetId appSetId) {
        if (appSetId.getScope() == 1) {
            String id = appSetId.getId();
            Intrinsics.checkNotNullExpressionValue(id, "response.id");
            return new AppSetId(id, 1);
        }
        String id2 = appSetId.getId();
        Intrinsics.checkNotNullExpressionValue(id2, "response.id");
        return new AppSetId(id2, 2);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static /* synthetic */ java.lang.Object d(androidx.privacysandbox.ads.adservices.appsetid.AppSetIdManagerImplCommon r4, kotlin.coroutines.Continuation<? super androidx.privacysandbox.ads.adservices.appsetid.AppSetId> r5) throws java.lang.Throwable {
        /*
            boolean r0 = r5 instanceof androidx.privacysandbox.ads.adservices.appsetid.AppSetIdManagerImplCommon$getAppSetId$1
            if (r0 == 0) goto L13
            r0 = r5
            androidx.privacysandbox.ads.adservices.appsetid.AppSetIdManagerImplCommon$getAppSetId$1 r0 = (androidx.privacysandbox.ads.adservices.appsetid.AppSetIdManagerImplCommon$getAppSetId$1) r0
            int r1 = r0.f51188d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f51188d = r1
            goto L18
        L13:
            androidx.privacysandbox.ads.adservices.appsetid.AppSetIdManagerImplCommon$getAppSetId$1 r0 = new androidx.privacysandbox.ads.adservices.appsetid.AppSetIdManagerImplCommon$getAppSetId$1
            r0.<init>(r4, r5)
        L18:
            java.lang.Object r5 = r0.f51186b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f51188d
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r4 = r0.f51185a
            androidx.privacysandbox.ads.adservices.appsetid.AppSetIdManagerImplCommon r4 = (androidx.privacysandbox.ads.adservices.appsetid.AppSetIdManagerImplCommon) r4
            kotlin.ResultKt.b(r5)
            goto L43
        L2d:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L35:
            kotlin.ResultKt.b(r5)
            r0.f51185a = r4
            r0.f51188d = r3
            java.lang.Object r5 = r4.e(r0)
            if (r5 != r1) goto L43
            return r1
        L43:
            android.adservices.appsetid.AppSetId r5 = androidx.privacysandbox.ads.adservices.appsetid.b.a(r5)
            androidx.privacysandbox.ads.adservices.appsetid.AppSetId r4 = r4.c(r5)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.privacysandbox.ads.adservices.appsetid.AppSetIdManagerImplCommon.d(androidx.privacysandbox.ads.adservices.appsetid.AppSetIdManagerImplCommon, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final Object e(Continuation continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.c(continuation), 1);
        cancellableContinuationImpl.C();
        this.f51184b.getAppSetId(new androidx.credentials.c(), OutcomeReceiverKt.a(cancellableContinuationImpl));
        Object objV = cancellableContinuationImpl.v();
        if (objV == IntrinsicsKt.f()) {
            DebugProbesKt.c(continuation);
        }
        return objV;
    }

    @Override // androidx.privacysandbox.ads.adservices.appsetid.AppSetIdManager
    public Object a(Continuation<? super AppSetId> continuation) {
        return d(this, continuation);
    }
}
