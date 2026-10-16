package cz.mobilesoft.coreblock.repository;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

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
public final class AccountabilityPartnerRepository {
    public final Flow a(String id, String language) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(language, "language");
        return FlowKt.I(new AccountabilityPartnerRepository$accountabilityPartnerDeactivationRequest$1(id, language, null));
    }

    public final Flow b(String email, String deviceId) {
        Intrinsics.checkNotNullParameter(email, "email");
        Intrinsics.checkNotNullParameter(deviceId, "deviceId");
        return FlowKt.I(new AccountabilityPartnerRepository$assignAccountabilityPartner$1(email, deviceId, null));
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object c(java.lang.String r7, java.lang.String r8, kotlin.coroutines.Continuation r9) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r9 instanceof cz.mobilesoft.coreblock.repository.AccountabilityPartnerRepository$assignAccountabilityPartnerSync$1
            if (r0 == 0) goto L13
            r0 = r9
            cz.mobilesoft.coreblock.repository.AccountabilityPartnerRepository$assignAccountabilityPartnerSync$1 r0 = (cz.mobilesoft.coreblock.repository.AccountabilityPartnerRepository$assignAccountabilityPartnerSync$1) r0
            int r1 = r0.f97343f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f97343f = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.repository.AccountabilityPartnerRepository$assignAccountabilityPartnerSync$1 r0 = new cz.mobilesoft.coreblock.repository.AccountabilityPartnerRepository$assignAccountabilityPartnerSync$1
            r0.<init>(r6, r9)
        L18:
            java.lang.Object r9 = r0.f97341c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f97343f
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L3a
            if (r2 != r3) goto L32
            java.lang.Object r7 = r0.f97340b
            java.lang.String r7 = (java.lang.String) r7
            java.lang.Object r7 = r0.f97339a
            java.lang.String r7 = (java.lang.String) r7
            kotlin.ResultKt.b(r9)
            goto L5d
        L32:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L3a:
            kotlin.ResultKt.b(r9)
            cz.mobilesoft.coreblock.rest.RestClient r9 = cz.mobilesoft.coreblock.rest.RestClient.f98457a
            cz.mobilesoft.coreblock.rest.ApiInterface r2 = r9.t()
            cz.mobilesoft.coreblock.repository.AccountabilityPartnerRepository$assignAccountabilityPartnerSync$result$1 r5 = new cz.mobilesoft.coreblock.repository.AccountabilityPartnerRepository$assignAccountabilityPartnerSync$result$1
            r5.<init>(r7, r8, r4)
            java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.a(r7)
            r0.f97339a = r7
            java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.a(r8)
            r0.f97340b = r7
            r0.f97343f = r3
            java.lang.Object r9 = r9.H(r2, r5, r0)
            if (r9 != r1) goto L5d
            return r1
        L5d:
            cz.mobilesoft.coreblock.rest.ApiResponse r9 = (cz.mobilesoft.coreblock.rest.ApiResponse) r9
            boolean r7 = r9 instanceof cz.mobilesoft.coreblock.rest.ApiResponse.Success
            if (r7 == 0) goto L6b
            cz.mobilesoft.coreblock.util.DataState$Success r7 = new cz.mobilesoft.coreblock.util.DataState$Success
            kotlin.Unit r8 = kotlin.Unit.f139807a
            r7.<init>(r8)
            return r7
        L6b:
            boolean r7 = r9 instanceof cz.mobilesoft.coreblock.rest.ApiResponse.Error
            if (r7 == 0) goto L95
            cz.mobilesoft.coreblock.util.DataState$Error r7 = new cz.mobilesoft.coreblock.util.DataState$Error
            cz.mobilesoft.coreblock.rest.ApiResponse$Error r9 = (cz.mobilesoft.coreblock.rest.ApiResponse.Error) r9
            java.lang.Throwable r8 = r9.c()
            cz.mobilesoft.coreblock.rest.response.ErrorBody r0 = r9.d()
            if (r0 == 0) goto L82
            java.lang.String r0 = r0.getMessage()
            goto L83
        L82:
            r0 = r4
        L83:
            cz.mobilesoft.coreblock.rest.response.ErrorBody r9 = r9.d()
            if (r9 == 0) goto L91
            int r9 = r9.getCode()
            java.lang.Integer r4 = kotlin.coroutines.jvm.internal.Boxing.d(r9)
        L91:
            r7.<init>(r8, r0, r4)
            return r7
        L95:
            kotlin.NoWhenBranchMatchedException r7 = new kotlin.NoWhenBranchMatchedException
            r7.<init>()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.repository.AccountabilityPartnerRepository.c(java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Flow d(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return FlowKt.I(new AccountabilityPartnerRepository$checkAccountabilityPartnerDeactivation$1(id, null));
    }
}
