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
@DebugMetadata(c = "cz.mobilesoft.coreblock.repository.AccountabilityPartnerRepository$checkAccountabilityPartnerDeactivation$1", f = "AccountabilityPartnerRepository.kt", l = {77, 79, 82, 85, 94}, m = "invokeSuspend", v = 1)
final class AccountabilityPartnerRepository$checkAccountabilityPartnerDeactivation$1 extends SuspendLambda implements Function2<FlowCollector<? super DataState<? extends Boolean>>, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f97348a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f97349b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private /* synthetic */ Object f97350c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ String f97351d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AccountabilityPartnerRepository$checkAccountabilityPartnerDeactivation$1(String str, Continuation continuation) {
        super(2, continuation);
        this.f97351d = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        AccountabilityPartnerRepository$checkAccountabilityPartnerDeactivation$1 accountabilityPartnerRepository$checkAccountabilityPartnerDeactivation$1 = new AccountabilityPartnerRepository$checkAccountabilityPartnerDeactivation$1(this.f97351d, continuation);
        accountabilityPartnerRepository$checkAccountabilityPartnerDeactivation$1.f97350c = obj;
        return accountabilityPartnerRepository$checkAccountabilityPartnerDeactivation$1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x008e, code lost:
    
        if (r0.emit(r2, r10) == r1) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00cd, code lost:
    
        if (r0.emit(r2, r10) == r1) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00f0, code lost:
    
        if (r0.emit(r2, r10) == r1) goto L42;
     */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0091  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r11) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 252
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.repository.AccountabilityPartnerRepository$checkAccountabilityPartnerDeactivation$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(FlowCollector flowCollector, Continuation continuation) {
        return ((AccountabilityPartnerRepository$checkAccountabilityPartnerDeactivation$1) create(flowCollector, continuation)).invokeSuspend(Unit.f139807a);
    }
}
