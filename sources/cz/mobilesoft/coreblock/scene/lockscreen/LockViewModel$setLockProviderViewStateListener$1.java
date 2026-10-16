package cz.mobilesoft.coreblock.scene.lockscreen;

import android.util.Log;
import cz.mobilesoft.coreblock.scene.lockscreen.LockViewModel$setLockProviderViewStateListener$1;
import cz.mobilesoft.coreblock.scene.lockscreen.provider.LockScreenProviderV2;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.StateFlow;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.lockscreen.LockViewModel$setLockProviderViewStateListener$1", f = "LockViewModel.kt", l = {149}, m = "invokeSuspend", v = 1)
final class LockViewModel$setLockProviderViewStateListener$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f105527a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ LockViewModel f105528b;

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.lockscreen.LockViewModel$setLockProviderViewStateListener$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    static final class AnonymousClass1<T> implements FlowCollector {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ LockViewModel f105529a;

        AnonymousClass1(LockViewModel lockViewModel) {
            this.f105529a = lockViewModel;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final LockViewState f(LockViewState lockViewState, LockViewState updateState) {
            Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
            return LockViewState.b(updateState, lockViewState.h(), lockViewState.d(), lockViewState.g(), lockViewState.f(), lockViewState.E(), lockViewState.e(), lockViewState.t(), lockViewState.x(), lockViewState.v(), lockViewState.D(), lockViewState.C(), lockViewState.A(), lockViewState.w(), lockViewState.p(), lockViewState.r(), lockViewState.H(), lockViewState.I(), lockViewState.J(), lockViewState.G(), lockViewState.K(), lockViewState.L(), lockViewState.k(), lockViewState.u(), lockViewState.c(), lockViewState.j(), lockViewState.z(), lockViewState.o(), lockViewState.n(), lockViewState.m(), lockViewState.M(), lockViewState.y(), lockViewState.q(), lockViewState.s(), lockViewState.i(), lockViewState.F(), null, 0, 8, null);
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Object emit(final LockViewState lockViewState, Continuation continuation) {
            String name = LockViewModel.class.getName();
            LockScreenProviderV2 lockScreenProviderV2Z0 = this.f105529a.Z0();
            Log.d(name, "viewStateListener invoked " + (lockScreenProviderV2Z0 != null ? lockScreenProviderV2Z0.B0() : null));
            this.f105529a.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.lockscreen.q1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return LockViewModel$setLockProviderViewStateListener$1.AnonymousClass1.f(lockViewState, (LockViewState) obj);
                }
            });
            return Unit.f139807a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LockViewModel$setLockProviderViewStateListener$1(LockViewModel lockViewModel, Continuation continuation) {
        super(2, continuation);
        this.f105528b = lockViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new LockViewModel$setLockProviderViewStateListener$1(this.f105528b, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        StateFlow stateFlowB0;
        Object objF = IntrinsicsKt.f();
        int i3 = this.f105527a;
        if (i3 == 0) {
            ResultKt.b(obj);
            LockScreenProviderV2 lockScreenProviderV2Z0 = this.f105528b.Z0();
            if (lockScreenProviderV2Z0 == null || (stateFlowB0 = lockScreenProviderV2Z0.B0()) == null) {
                return Unit.f139807a;
            }
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.f105528b);
            this.f105527a = 1;
            if (stateFlowB0.collect(anonymousClass1, this) == objF) {
                return objF;
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((LockViewModel$setLockProviderViewStateListener$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
