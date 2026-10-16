package cz.mobilesoft.coreblock.util.runnability;

import cz.mobilesoft.coreblock.storage.datastore.EventDataStore;
import cz.mobilesoft.coreblock.util.helperextension.TimeHelperExt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.util.runnability.ServiceHelper$isAccessibilityServiceRunningByPoll$2", f = "ServiceHelper.kt", l = {76, 77}, m = "invokeSuspend", v = 1)
final class ServiceHelper$isAccessibilityServiceRunningByPoll$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f129663a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f129664b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Ref.BooleanRef f129665c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ServiceHelper$isAccessibilityServiceRunningByPoll$2(Ref.BooleanRef booleanRef, Continuation continuation) {
        super(2, continuation);
        this.f129665c = booleanRef;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new ServiceHelper$isAccessibilityServiceRunningByPoll$2(this.f129665c, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Ref.BooleanRef booleanRef;
        boolean zBooleanValue;
        Ref.BooleanRef booleanRef2;
        Object objF = IntrinsicsKt.f();
        int i3 = this.f129664b;
        if (i3 == 0) {
            ResultKt.b(obj);
            EventDataStore eventDataStoreD = ServiceHelper.f129652a.d();
            long jF = TimeHelperExt.f128663a.f();
            this.f129664b = 1;
            if (eventDataStoreD.L1(jF, this) != objF) {
            }
            return objF;
        }
        if (i3 != 1) {
            if (i3 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            booleanRef2 = (Ref.BooleanRef) this.f129663a;
            ResultKt.b(obj);
            Ref.BooleanRef booleanRef3 = booleanRef2;
            zBooleanValue = ((Boolean) obj).booleanValue();
            booleanRef = booleanRef3;
            booleanRef.f140137a = zBooleanValue;
            return Unit.f139807a;
        }
        ResultKt.b(obj);
        booleanRef = this.f129665c;
        MutableSharedFlow mutableSharedFlow = ServiceHelper.f129654c;
        if (mutableSharedFlow == null) {
            zBooleanValue = false;
            booleanRef.f140137a = zBooleanValue;
            return Unit.f139807a;
        }
        this.f129663a = booleanRef;
        this.f129664b = 2;
        Object objD = FlowKt.D(mutableSharedFlow, this);
        if (objD != objF) {
            booleanRef2 = booleanRef;
            obj = objD;
            Ref.BooleanRef booleanRef32 = booleanRef2;
            zBooleanValue = ((Boolean) obj).booleanValue();
            booleanRef = booleanRef32;
            booleanRef.f140137a = zBooleanValue;
            return Unit.f139807a;
        }
        return objF;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((ServiceHelper$isAccessibilityServiceRunningByPoll$2) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
