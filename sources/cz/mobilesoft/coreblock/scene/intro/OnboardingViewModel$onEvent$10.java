package cz.mobilesoft.coreblock.scene.intro;

import cz.mobilesoft.coreblock.scene.intro.OnboardingViewCommand;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.intro.OnboardingViewModel$onEvent$10", f = "OnboardingViewModel.kt", l = {165}, m = "invokeSuspend", v = 1)
final class OnboardingViewModel$onEvent$10 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f104553a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f104554b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f104555c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ OnboardingViewModel f104556d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    OnboardingViewModel$onEvent$10(OnboardingViewModel onboardingViewModel, Continuation continuation) {
        super(1, continuation);
        this.f104556d = onboardingViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new OnboardingViewModel$onEvent$10(this.f104556d, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object obj2;
        Object objF = IntrinsicsKt.f();
        int i3 = this.f104555c;
        if (i3 == 0) {
            ResultKt.b(obj);
            Iterator<E> it = OnboardingViewModel.W0(this.f104556d).e().iterator();
            if (it.hasNext()) {
                Object next = it.next();
                if (it.hasNext()) {
                    int iD = ((OnboardingHelpItem) next).d();
                    do {
                        Object next2 = it.next();
                        int iD2 = ((OnboardingHelpItem) next2).d();
                        if (iD > iD2) {
                            next = next2;
                            iD = iD2;
                        }
                    } while (it.hasNext());
                }
                obj2 = next;
            } else {
                obj2 = null;
            }
            OnboardingHelpItem onboardingHelpItem = (OnboardingHelpItem) obj2;
            if (onboardingHelpItem != null) {
                OnboardingViewModel onboardingViewModel = this.f104556d;
                OnboardingViewCommand.NavigateToExplanation1 navigateToExplanation1 = new OnboardingViewCommand.NavigateToExplanation1(onboardingHelpItem);
                this.f104553a = SpillingKt.a(onboardingHelpItem);
                this.f104554b = 0;
                this.f104555c = 1;
                if (onboardingViewModel.P0(navigateToExplanation1, this) == objF) {
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

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation continuation) {
        return ((OnboardingViewModel$onEvent$10) create(continuation)).invokeSuspend(Unit.f139807a);
    }
}
