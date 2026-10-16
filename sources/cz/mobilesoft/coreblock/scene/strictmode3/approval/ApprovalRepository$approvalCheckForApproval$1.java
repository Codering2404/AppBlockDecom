package cz.mobilesoft.coreblock.scene.strictmode3.approval;

import cz.mobilesoft.coreblock.scene.strictmode3.approval.ApprovalRepository;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.strictmode3.approval.ApprovalRepository$approvalCheckForApproval$1", f = "ApprovalRepository.kt", l = {242, 253, 255}, m = "invokeSuspend", v = 1)
final class ApprovalRepository$approvalCheckForApproval$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f121741a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f121742b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f121743c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f121744d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f121745f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    Object f121746g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    Object f121747h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    int f121748i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    final /* synthetic */ ApprovalRepository.ApprovalCheckTrigger f121749j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    final /* synthetic */ ApprovalRepository f121750k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ApprovalRepository$approvalCheckForApproval$1(ApprovalRepository.ApprovalCheckTrigger approvalCheckTrigger, ApprovalRepository approvalRepository, Continuation continuation) {
        super(2, continuation);
        this.f121749j = approvalCheckTrigger;
        this.f121750k = approvalRepository;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new ApprovalRepository$approvalCheckForApproval$1(this.f121749j, this.f121750k, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0076, code lost:
    
        if (r1.emit(r2, r14) == r0) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00cf, code lost:
    
        if (r15 == r0) goto L43;
     */
    /* JADX WARN: Removed duplicated region for block: B:30:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00e0  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:42:0x00cf -> B:8:0x0025). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r15) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 227
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.strictmode3.approval.ApprovalRepository$approvalCheckForApproval$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((ApprovalRepository$approvalCheckForApproval$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
