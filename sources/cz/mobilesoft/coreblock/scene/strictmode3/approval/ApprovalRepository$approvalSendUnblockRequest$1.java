package cz.mobilesoft.coreblock.scene.strictmode3.approval;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.strictmode3.approval.ApprovalRepository$approvalSendUnblockRequest$1", f = "ApprovalRepository.kt", l = {178, 181, 181}, m = "invokeSuspend", v = 1)
final class ApprovalRepository$approvalSendUnblockRequest$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f121754a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f121755b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ ApprovalRepository f121756c;

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.strictmode3.approval.ApprovalRepository$approvalSendUnblockRequest$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    static final class AnonymousClass1<T> implements FlowCollector {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ApprovalRepository f121757a;

        AnonymousClass1(ApprovalRepository approvalRepository) {
            this.f121757a = approvalRepository;
        }

        /* JADX WARN: Code restructure failed: missing block: B:23:0x007d, code lost:
        
            if (r9.emit(r2, r0) == r1) goto L41;
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x009f, code lost:
        
            if (r9.emit(r2, r0) == r1) goto L41;
         */
        /* JADX WARN: Code restructure failed: missing block: B:40:0x00d9, code lost:
        
            if (r9.emit(r2, r0) != r1) goto L42;
         */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        @Override // kotlinx.coroutines.flow.FlowCollector
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object emit(cz.mobilesoft.coreblock.util.DataState r8, kotlin.coroutines.Continuation r9) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 229
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.strictmode3.approval.ApprovalRepository$approvalSendUnblockRequest$1.AnonymousClass1.emit(cz.mobilesoft.coreblock.util.DataState, kotlin.coroutines.Continuation):java.lang.Object");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ApprovalRepository$approvalSendUnblockRequest$1(ApprovalRepository approvalRepository, Continuation continuation) {
        super(2, continuation);
        this.f121756c = approvalRepository;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new ApprovalRepository$approvalSendUnblockRequest$1(this.f121756c, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0047, code lost:
    
        if (r6.emit(r1, r5) == r0) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0089, code lost:
    
        if (r6.collect(r1, r5) != r0) goto L25;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r6) throws java.lang.Throwable {
        /*
            r5 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r5.f121755b
            r2 = 3
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L2a
            if (r1 == r4) goto L26
            if (r1 == r3) goto L1e
            if (r1 != r2) goto L16
            kotlin.ResultKt.b(r6)
            goto L8c
        L16:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L1e:
            java.lang.Object r1 = r5.f121754a
            cz.mobilesoft.coreblock.repository.AccountabilityPartnerRepository r1 = (cz.mobilesoft.coreblock.repository.AccountabilityPartnerRepository) r1
            kotlin.ResultKt.b(r6)
            goto L60
        L26:
            kotlin.ResultKt.b(r6)
            goto L4a
        L2a:
            kotlin.ResultKt.b(r6)
            cz.mobilesoft.coreblock.util.SessionManager r6 = cz.mobilesoft.coreblock.util.SessionManager.f127910a
            boolean r6 = r6.r()
            if (r6 != 0) goto L4d
            cz.mobilesoft.coreblock.scene.strictmode3.approval.ApprovalRepository r6 = r5.f121756c
            kotlinx.coroutines.flow.MutableSharedFlow r6 = cz.mobilesoft.coreblock.scene.strictmode3.approval.ApprovalRepository.j(r6)
            cz.mobilesoft.coreblock.scene.strictmode3.approval.ApprovalRepository r1 = r5.f121756c
            cz.mobilesoft.coreblock.scene.strictmode3.approval.ApprovalEvent$Error r1 = cz.mobilesoft.coreblock.scene.strictmode3.approval.ApprovalRepository.g(r1)
            r5.f121755b = r4
            java.lang.Object r6 = r6.emit(r1, r5)
            if (r6 != r0) goto L4a
            goto L8b
        L4a:
            kotlin.Unit r6 = kotlin.Unit.f139807a
            return r6
        L4d:
            cz.mobilesoft.coreblock.scene.strictmode3.approval.ApprovalRepository r6 = r5.f121756c
            cz.mobilesoft.coreblock.repository.AccountabilityPartnerRepository r1 = cz.mobilesoft.coreblock.scene.strictmode3.approval.ApprovalRepository.d(r6)
            cz.mobilesoft.coreblock.util.runnability.DeviceIdUtils r6 = cz.mobilesoft.coreblock.util.runnability.DeviceIdUtils.f129470a
            r5.f121754a = r1
            r5.f121755b = r3
            java.lang.Object r6 = r6.b(r5)
            if (r6 != r0) goto L60
            goto L8b
        L60:
            java.lang.String r6 = (java.lang.String) r6
            cz.mobilesoft.coreblock.scene.strictmode3.approval.ApprovalRepository r3 = r5.f121756c
            android.app.Application r3 = r3.w()
            java.util.Locale r3 = cz.mobilesoft.coreblock.util.helperextension.ContextExtKt.d(r3)
            java.lang.String r3 = r3.getLanguage()
            java.lang.String r4 = "getLanguage(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            kotlinx.coroutines.flow.Flow r6 = r1.a(r6, r3)
            cz.mobilesoft.coreblock.scene.strictmode3.approval.ApprovalRepository$approvalSendUnblockRequest$1$1 r1 = new cz.mobilesoft.coreblock.scene.strictmode3.approval.ApprovalRepository$approvalSendUnblockRequest$1$1
            cz.mobilesoft.coreblock.scene.strictmode3.approval.ApprovalRepository r3 = r5.f121756c
            r1.<init>(r3)
            r3 = 0
            r5.f121754a = r3
            r5.f121755b = r2
            java.lang.Object r6 = r6.collect(r1, r5)
            if (r6 != r0) goto L8c
        L8b:
            return r0
        L8c:
            kotlin.Unit r6 = kotlin.Unit.f139807a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.strictmode3.approval.ApprovalRepository$approvalSendUnblockRequest$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((ApprovalRepository$approvalSendUnblockRequest$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
