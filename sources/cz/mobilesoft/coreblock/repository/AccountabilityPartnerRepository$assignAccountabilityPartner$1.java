package cz.mobilesoft.coreblock.repository;

import cz.mobilesoft.coreblock.util.DataState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.repository.AccountabilityPartnerRepository$assignAccountabilityPartner$1", f = "AccountabilityPartnerRepository.kt", l = {15, 17, 20, 23}, m = "invokeSuspend", v = 1)
final class AccountabilityPartnerRepository$assignAccountabilityPartner$1 extends SuspendLambda implements Function2<FlowCollector<? super DataState<? extends Unit>>, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f97330a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f97331b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private /* synthetic */ Object f97332c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ String f97333d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ String f97334f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AccountabilityPartnerRepository$assignAccountabilityPartner$1(String str, String str2, Continuation continuation) {
        super(2, continuation);
        this.f97333d = str;
        this.f97334f = str2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        AccountabilityPartnerRepository$assignAccountabilityPartner$1 accountabilityPartnerRepository$assignAccountabilityPartner$1 = new AccountabilityPartnerRepository$assignAccountabilityPartner$1(this.f97333d, this.f97334f, continuation);
        accountabilityPartnerRepository$assignAccountabilityPartner$1.f97332c = obj;
        return accountabilityPartnerRepository$assignAccountabilityPartner$1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x007d, code lost:
    
        if (r0.emit(r2, r10) == r1) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00bc, code lost:
    
        if (r0.emit(r2, r10) == r1) goto L36;
     */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0080  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r11) throws java.lang.Throwable {
        /*
            r10 = this;
            java.lang.Object r0 = r10.f97332c
            kotlinx.coroutines.flow.FlowCollector r0 = (kotlinx.coroutines.flow.FlowCollector) r0
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r10.f97331b
            r3 = 4
            r4 = 3
            r5 = 2
            r6 = 1
            r7 = 0
            if (r2 == 0) goto L33
            if (r2 == r6) goto L2f
            if (r2 == r5) goto L2b
            if (r2 == r4) goto L22
            if (r2 != r3) goto L1a
            goto L22
        L1a:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L22:
            java.lang.Object r0 = r10.f97330a
            cz.mobilesoft.coreblock.rest.ApiResponse r0 = (cz.mobilesoft.coreblock.rest.ApiResponse) r0
            kotlin.ResultKt.b(r11)
            goto Lbf
        L2b:
            kotlin.ResultKt.b(r11)
            goto L5e
        L2f:
            kotlin.ResultKt.b(r11)
            goto L44
        L33:
            kotlin.ResultKt.b(r11)
            cz.mobilesoft.coreblock.util.DataState$Loading r11 = cz.mobilesoft.coreblock.util.DataState.Loading.f127816a
            r10.f97332c = r0
            r10.f97331b = r6
            java.lang.Object r11 = r0.emit(r11, r10)
            if (r11 != r1) goto L44
            goto Lbe
        L44:
            cz.mobilesoft.coreblock.rest.RestClient r11 = cz.mobilesoft.coreblock.rest.RestClient.f98457a
            cz.mobilesoft.coreblock.rest.ApiInterface r2 = r11.t()
            cz.mobilesoft.coreblock.repository.AccountabilityPartnerRepository$assignAccountabilityPartner$1$result$1 r6 = new cz.mobilesoft.coreblock.repository.AccountabilityPartnerRepository$assignAccountabilityPartner$1$result$1
            java.lang.String r8 = r10.f97333d
            java.lang.String r9 = r10.f97334f
            r6.<init>(r8, r9, r7)
            r10.f97332c = r0
            r10.f97331b = r5
            java.lang.Object r11 = r11.H(r2, r6, r10)
            if (r11 != r1) goto L5e
            goto Lbe
        L5e:
            cz.mobilesoft.coreblock.rest.ApiResponse r11 = (cz.mobilesoft.coreblock.rest.ApiResponse) r11
            boolean r2 = r11 instanceof cz.mobilesoft.coreblock.rest.ApiResponse.Success
            if (r2 == 0) goto L80
            cz.mobilesoft.coreblock.util.DataState$Success r2 = new cz.mobilesoft.coreblock.util.DataState$Success
            kotlin.Unit r3 = kotlin.Unit.f139807a
            r2.<init>(r3)
            java.lang.Object r3 = kotlin.coroutines.jvm.internal.SpillingKt.a(r0)
            r10.f97332c = r3
            java.lang.Object r11 = kotlin.coroutines.jvm.internal.SpillingKt.a(r11)
            r10.f97330a = r11
            r10.f97331b = r4
            java.lang.Object r11 = r0.emit(r2, r10)
            if (r11 != r1) goto Lbf
            goto Lbe
        L80:
            boolean r2 = r11 instanceof cz.mobilesoft.coreblock.rest.ApiResponse.Error
            if (r2 == 0) goto Lc2
            cz.mobilesoft.coreblock.util.DataState$Error r2 = new cz.mobilesoft.coreblock.util.DataState$Error
            r4 = r11
            cz.mobilesoft.coreblock.rest.ApiResponse$Error r4 = (cz.mobilesoft.coreblock.rest.ApiResponse.Error) r4
            java.lang.Throwable r5 = r4.c()
            cz.mobilesoft.coreblock.rest.response.ErrorBody r6 = r4.d()
            if (r6 == 0) goto L98
            java.lang.String r6 = r6.getMessage()
            goto L99
        L98:
            r6 = r7
        L99:
            cz.mobilesoft.coreblock.rest.response.ErrorBody r4 = r4.d()
            if (r4 == 0) goto La7
            int r4 = r4.getCode()
            java.lang.Integer r7 = kotlin.coroutines.jvm.internal.Boxing.d(r4)
        La7:
            r2.<init>(r5, r6, r7)
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.a(r0)
            r10.f97332c = r4
            java.lang.Object r11 = kotlin.coroutines.jvm.internal.SpillingKt.a(r11)
            r10.f97330a = r11
            r10.f97331b = r3
            java.lang.Object r11 = r0.emit(r2, r10)
            if (r11 != r1) goto Lbf
        Lbe:
            return r1
        Lbf:
            kotlin.Unit r11 = kotlin.Unit.f139807a
            return r11
        Lc2:
            kotlin.NoWhenBranchMatchedException r11 = new kotlin.NoWhenBranchMatchedException
            r11.<init>()
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.repository.AccountabilityPartnerRepository$assignAccountabilityPartner$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(FlowCollector flowCollector, Continuation continuation) {
        return ((AccountabilityPartnerRepository$assignAccountabilityPartner$1) create(flowCollector, continuation)).invokeSuspend(Unit.f139807a);
    }
}
