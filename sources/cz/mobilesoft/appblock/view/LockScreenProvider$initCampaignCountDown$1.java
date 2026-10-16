package cz.mobilesoft.appblock.view;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.MutableStateFlow;

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
@DebugMetadata(c = "cz.mobilesoft.appblock.view.LockScreenProvider$initCampaignCountDown$1", f = "LockScreenProvider.kt", l = {417}, m = "invokeSuspend", v = 1)
final class LockScreenProvider$initCampaignCountDown$1 extends SuspendLambda implements Function2<Long, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f95239a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    /* synthetic */ Object f95240b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ LockScreenProvider f95241c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LockScreenProvider$initCampaignCountDown$1(LockScreenProvider lockScreenProvider, Continuation continuation) {
        super(2, continuation);
        this.f95241c = lockScreenProvider;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        LockScreenProvider$initCampaignCountDown$1 lockScreenProvider$initCampaignCountDown$1 = new LockScreenProvider$initCampaignCountDown$1(this.f95241c, continuation);
        lockScreenProvider$initCampaignCountDown$1.f95240b = obj;
        return lockScreenProvider$initCampaignCountDown$1;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public final Object invoke(Long l3, Continuation continuation) {
        return ((LockScreenProvider$initCampaignCountDown$1) create(l3, continuation)).invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Long l3 = (Long) this.f95240b;
        Object objF = IntrinsicsKt.f();
        int i3 = this.f95239a;
        if (i3 == 0) {
            ResultKt.b(obj);
            MutableStateFlow mutableStateFlow = this.f95241c.f95158p;
            this.f95240b = l3;
            this.f95239a = 1;
            if (mutableStateFlow.emit(l3, this) == objF) {
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
}
