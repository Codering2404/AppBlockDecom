package cz.mobilesoft.coreblock.scene.strictmode3.approval;

import cz.mobilesoft.coreblock.scene.strictmode3.approval.ApprovalRepository;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
final class ApprovalRepository$readApprovalState$2<T> implements FlowCollector {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Ref.BooleanRef f121790a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ boolean f121791b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ ApprovalRepository f121792c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ ApprovalRepository.ApprovalCheckTrigger f121793d;

    ApprovalRepository$readApprovalState$2(Ref.BooleanRef booleanRef, boolean z2, ApprovalRepository approvalRepository, ApprovalRepository.ApprovalCheckTrigger approvalCheckTrigger) {
        this.f121790a = booleanRef;
        this.f121791b = z2;
        this.f121792c = approvalRepository;
        this.f121793d = approvalCheckTrigger;
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0090, code lost:
    
        if (r2.emit(r5, r3) == r4) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00b7, code lost:
    
        if (r2.emit(r5, r3) == r4) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0101, code lost:
    
        if (r2.emit(r5, r3) == r4) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x013a, code lost:
    
        if (r2.emit(r5, r3) == r4) goto L58;
     */
    /* JADX WARN: Removed duplicated region for block: B:54:0x011b A[PHI: r1
      0x011b: PHI (r1v15 cz.mobilesoft.coreblock.util.DataState) = 
      (r1v0 cz.mobilesoft.coreblock.util.DataState)
      (r1v0 cz.mobilesoft.coreblock.util.DataState)
      (r1v23 cz.mobilesoft.coreblock.util.DataState)
     binds: [B:50:0x0106, B:52:0x0118, B:18:0x0041] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    @Override // kotlinx.coroutines.flow.FlowCollector
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object emit(cz.mobilesoft.coreblock.util.DataState r18, kotlin.coroutines.Continuation r19) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 350
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.strictmode3.approval.ApprovalRepository$readApprovalState$2.emit(cz.mobilesoft.coreblock.util.DataState, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
