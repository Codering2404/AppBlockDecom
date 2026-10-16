package cz.mobilesoft.coreblock.repository;

import cz.mobilesoft.coreblock.rest.ApiResponse;
import cz.mobilesoft.coreblock.rest.response.ErrorBody;
import cz.mobilesoft.coreblock.util.DataState;
import kotlin.Metadata;

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
public final class StreakApiRepository {
    private final DataState.Error b() {
        return new DataState.Error(null, "Not signed in", null, 4, null);
    }

    private final DataState d(ApiResponse apiResponse) {
        if (apiResponse instanceof ApiResponse.Data) {
            return new DataState.Success(((ApiResponse.Data) apiResponse).c());
        }
        if (!(apiResponse instanceof ApiResponse.Error)) {
            return new DataState.Error(null, "Empty response", Integer.valueOf(apiResponse.a()));
        }
        ApiResponse.Error error = (ApiResponse.Error) apiResponse;
        Throwable thC = error.c();
        ErrorBody errorBodyD = error.d();
        String message = errorBodyD != null ? errorBodyD.getMessage() : null;
        ErrorBody errorBodyD2 = error.d();
        return new DataState.Error(thC, message, errorBodyD2 != null ? Integer.valueOf(errorBodyD2.getCode()) : null);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(kotlin.coroutines.Continuation r10) throws java.lang.Throwable {
        /*
            r9 = this;
            boolean r0 = r10 instanceof cz.mobilesoft.coreblock.repository.StreakApiRepository$getSnapshot$1
            if (r0 == 0) goto L13
            r0 = r10
            cz.mobilesoft.coreblock.repository.StreakApiRepository$getSnapshot$1 r0 = (cz.mobilesoft.coreblock.repository.StreakApiRepository$getSnapshot$1) r0
            int r1 = r0.f98219c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f98219c = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.repository.StreakApiRepository$getSnapshot$1 r0 = new cz.mobilesoft.coreblock.repository.StreakApiRepository$getSnapshot$1
            r0.<init>(r9, r10)
        L18:
            java.lang.Object r10 = r0.f98217a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f98219c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.ResultKt.b(r10)
            goto L56
        L29:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L31:
            kotlin.ResultKt.b(r10)
            cz.mobilesoft.coreblock.util.SessionManager r10 = cz.mobilesoft.coreblock.util.SessionManager.f127910a
            boolean r10 = r10.r()
            if (r10 != 0) goto L41
            cz.mobilesoft.coreblock.util.DataState$Error r10 = r9.b()
            return r10
        L41:
            cz.mobilesoft.coreblock.rest.RestClient r10 = cz.mobilesoft.coreblock.rest.RestClient.f98457a
            cz.mobilesoft.coreblock.rest.ApiInterface r2 = r10.t()
            cz.mobilesoft.coreblock.repository.StreakApiRepository$getSnapshot$response$1 r4 = new cz.mobilesoft.coreblock.repository.StreakApiRepository$getSnapshot$response$1
            r5 = 0
            r4.<init>(r5)
            r0.f98219c = r3
            java.lang.Object r10 = r10.H(r2, r4, r0)
            if (r10 != r1) goto L56
            return r1
        L56:
            cz.mobilesoft.coreblock.rest.ApiResponse r10 = (cz.mobilesoft.coreblock.rest.ApiResponse) r10
            boolean r0 = r10 instanceof cz.mobilesoft.coreblock.rest.ApiResponse.Error
            if (r0 == 0) goto L7a
            r0 = r10
            cz.mobilesoft.coreblock.rest.ApiResponse$Error r0 = (cz.mobilesoft.coreblock.rest.ApiResponse.Error) r0
            int r0 = r0.a()
            r1 = 404(0x194, float:5.66E-43)
            if (r0 != r1) goto L7a
            cz.mobilesoft.coreblock.util.DataState$Success r10 = new cz.mobilesoft.coreblock.util.DataState$Success
            cz.mobilesoft.coreblock.rest.response.StreakSnapshotResponse r0 = new cz.mobilesoft.coreblock.rest.response.StreakSnapshotResponse
            r7 = 0
            r8 = 0
            r1 = 0
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            r10.<init>(r0)
            return r10
        L7a:
            cz.mobilesoft.coreblock.util.DataState r10 = r9.d(r10)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.repository.StreakApiRepository.a(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object c(cz.mobilesoft.coreblock.rest.request.StreakSnapshotRequest r7, kotlin.coroutines.Continuation r8) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r8 instanceof cz.mobilesoft.coreblock.repository.StreakApiRepository$putSnapshot$1
            if (r0 == 0) goto L13
            r0 = r8
            cz.mobilesoft.coreblock.repository.StreakApiRepository$putSnapshot$1 r0 = (cz.mobilesoft.coreblock.repository.StreakApiRepository$putSnapshot$1) r0
            int r1 = r0.f98226f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f98226f = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.repository.StreakApiRepository$putSnapshot$1 r0 = new cz.mobilesoft.coreblock.repository.StreakApiRepository$putSnapshot$1
            r0.<init>(r6, r8)
        L18:
            java.lang.Object r8 = r0.f98224c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f98226f
            r3 = 1
            if (r2 == 0) goto L39
            if (r2 != r3) goto L31
            java.lang.Object r7 = r0.f98223b
            cz.mobilesoft.coreblock.repository.StreakApiRepository r7 = (cz.mobilesoft.coreblock.repository.StreakApiRepository) r7
            java.lang.Object r0 = r0.f98222a
            cz.mobilesoft.coreblock.rest.request.StreakSnapshotRequest r0 = (cz.mobilesoft.coreblock.rest.request.StreakSnapshotRequest) r0
            kotlin.ResultKt.b(r8)
            goto L67
        L31:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L39:
            kotlin.ResultKt.b(r8)
            cz.mobilesoft.coreblock.util.SessionManager r8 = cz.mobilesoft.coreblock.util.SessionManager.f127910a
            boolean r8 = r8.r()
            if (r8 != 0) goto L49
            cz.mobilesoft.coreblock.util.DataState$Error r7 = r6.b()
            return r7
        L49:
            cz.mobilesoft.coreblock.rest.RestClient r8 = cz.mobilesoft.coreblock.rest.RestClient.f98457a
            cz.mobilesoft.coreblock.rest.ApiInterface r2 = r8.t()
            cz.mobilesoft.coreblock.repository.StreakApiRepository$putSnapshot$2 r4 = new cz.mobilesoft.coreblock.repository.StreakApiRepository$putSnapshot$2
            r5 = 0
            r4.<init>(r7, r5)
            java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.a(r7)
            r0.f98222a = r7
            r0.f98223b = r6
            r0.f98226f = r3
            java.lang.Object r8 = r8.H(r2, r4, r0)
            if (r8 != r1) goto L66
            return r1
        L66:
            r7 = r6
        L67:
            cz.mobilesoft.coreblock.rest.ApiResponse r8 = (cz.mobilesoft.coreblock.rest.ApiResponse) r8
            cz.mobilesoft.coreblock.util.DataState r7 = r7.d(r8)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.repository.StreakApiRepository.c(cz.mobilesoft.coreblock.rest.request.StreakSnapshotRequest, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
