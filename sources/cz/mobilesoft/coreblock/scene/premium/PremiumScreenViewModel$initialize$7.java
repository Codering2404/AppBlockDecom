package cz.mobilesoft.coreblock.scene.premium;

import cz.mobilesoft.coreblock.scene.premium.PremiumScreenViewCommand;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.premium.PremiumScreenViewModel$initialize$7", f = "PremiumScreenViewModel.kt", l = {219}, m = "invokeSuspend", v = 1)
final class PremiumScreenViewModel$initialize$7 extends SuspendLambda implements Function2<String, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f112429a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    /* synthetic */ Object f112430b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ PremiumScreenViewModel f112431c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PremiumScreenViewModel$initialize$7(PremiumScreenViewModel premiumScreenViewModel, Continuation continuation) {
        super(2, continuation);
        this.f112431c = premiumScreenViewModel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PremiumScreenViewState q(String str, PremiumScreenViewState premiumScreenViewState) {
        return PremiumScreenViewState.b(premiumScreenViewState, null, null, null, str, null, null, null, null, null, false, false, null, false, false, false, false, false, false, null, null, null, null, false, false, false, null, null, null, null, null, false, false, false, -9, 1, null);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        PremiumScreenViewModel$initialize$7 premiumScreenViewModel$initialize$7 = new PremiumScreenViewModel$initialize$7(this.f112431c, continuation);
        premiumScreenViewModel$initialize$7.f112430b = obj;
        return premiumScreenViewModel$initialize$7;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        final String str = (String) this.f112430b;
        Object objF = IntrinsicsKt.f();
        int i3 = this.f112429a;
        if (i3 == 0) {
            ResultKt.b(obj);
            this.f112431c.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.premium.p0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return PremiumScreenViewModel$initialize$7.q(str, (PremiumScreenViewState) obj2);
                }
            });
            if (str != null) {
                PremiumScreenViewModel premiumScreenViewModel = this.f112431c;
                PremiumScreenViewCommand.ShowPurchaseFailed showPurchaseFailed = new PremiumScreenViewCommand.ShowPurchaseFailed(str);
                this.f112430b = SpillingKt.a(str);
                this.f112429a = 1;
                if (premiumScreenViewModel.P0(showPurchaseFailed, this) == objF) {
                    return objF;
                }
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
    public final Object invoke(String str, Continuation continuation) {
        return ((PremiumScreenViewModel$initialize$7) create(str, continuation)).invokeSuspend(Unit.f139807a);
    }
}
