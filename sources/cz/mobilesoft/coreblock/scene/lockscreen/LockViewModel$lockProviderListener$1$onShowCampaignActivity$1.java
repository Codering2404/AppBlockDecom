package cz.mobilesoft.coreblock.scene.lockscreen;

import cz.mobilesoft.coreblock.scene.lockscreen.LockViewCommand;
import cz.mobilesoft.coreblock.scene.premium.dto.CampaignSource;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.lockscreen.LockViewModel$lockProviderListener$1$onShowCampaignActivity$1", f = "LockViewModel.kt", l = {66}, m = "invokeSuspend", v = 1)
final class LockViewModel$lockProviderListener$1$onShowCampaignActivity$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f105496a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ LockViewModel f105497b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ long f105498c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ CampaignSource f105499d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ String f105500f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LockViewModel$lockProviderListener$1$onShowCampaignActivity$1(LockViewModel lockViewModel, long j3, CampaignSource campaignSource, String str, Continuation continuation) {
        super(2, continuation);
        this.f105497b = lockViewModel;
        this.f105498c = j3;
        this.f105499d = campaignSource;
        this.f105500f = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new LockViewModel$lockProviderListener$1$onShowCampaignActivity$1(this.f105497b, this.f105498c, this.f105499d, this.f105500f, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f105496a;
        if (i3 == 0) {
            ResultKt.b(obj);
            LockViewModel lockViewModel = this.f105497b;
            LockViewCommand.ShowCampaignActivityCommand showCampaignActivityCommand = new LockViewCommand.ShowCampaignActivityCommand(this.f105498c, this.f105499d, this.f105500f);
            this.f105496a = 1;
            if (lockViewModel.P0(showCampaignActivityCommand, this) == objF) {
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

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((LockViewModel$lockProviderListener$1$onShowCampaignActivity$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
