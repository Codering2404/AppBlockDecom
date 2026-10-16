package cz.mobilesoft.appblock.service;

import cz.mobilesoft.coreblock.dto.events.PackageAdditionalBlockingDTO;
import cz.mobilesoft.coreblock.storage.datastore.EventDataStore;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

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
@DebugMetadata(c = "cz.mobilesoft.appblock.service.LockAccessibilityService$blockWebsite$1", f = "LockAccessibilityService.kt", l = {1720}, m = "invokeSuspend", v = 1)
final class LockAccessibilityService$blockWebsite$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f94258a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ LockAccessibilityService f94259b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LockAccessibilityService$blockWebsite$1(LockAccessibilityService lockAccessibilityService, Continuation continuation) {
        super(1, continuation);
        this.f94259b = lockAccessibilityService;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new LockAccessibilityService$blockWebsite$1(this.f94259b, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f94258a;
        if (i3 == 0) {
            ResultKt.b(obj);
            EventDataStore eventDataStoreZ0 = this.f94259b.Z0();
            PackageAdditionalBlockingDTO packageAdditionalBlockingDTO = new PackageAdditionalBlockingDTO(null, null, null, 4, null);
            this.f94258a = 1;
            if (eventDataStoreZ0.s2(packageAdditionalBlockingDTO, this) == objF) {
                return objF;
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation continuation) {
        return ((LockAccessibilityService$blockWebsite$1) create(continuation)).invokeSuspend(Unit.f139807a);
    }
}
