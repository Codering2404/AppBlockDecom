package cz.mobilesoft.coreblock.scene.strictmode3;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.strictmode3.StrictMode3ViewModel$observeStrictModeStateFlows$1", f = "StrictMode3ViewModel.kt", l = {188}, m = "invokeSuspend", v = 1)
final class StrictMode3ViewModel$observeStrictModeStateFlows$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f121274a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ StrictMode3ViewModel f121275b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Flow f121276c;

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.strictmode3.StrictMode3ViewModel$observeStrictModeStateFlows$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    static final class AnonymousClass1<T> implements FlowCollector {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ StrictMode3ViewModel f121277a;

        AnonymousClass1(StrictMode3ViewModel strictMode3ViewModel) {
            this.f121277a = strictMode3ViewModel;
        }

        /* JADX WARN: Code restructure failed: missing block: B:43:0x0114, code lost:
        
            if (r15.M2(r14, r0) == r1) goto L44;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        /* JADX WARN: Type inference failed for: r2v3 */
        /* JADX WARN: Type inference failed for: r2v4, types: [boolean, int] */
        /* JADX WARN: Type inference failed for: r2v5 */
        @Override // kotlinx.coroutines.flow.FlowCollector
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object emit(cz.mobilesoft.coreblock.scene.strictmode3.StrictModeStateDto r14, kotlin.coroutines.Continuation r15) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 282
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.strictmode3.StrictMode3ViewModel$observeStrictModeStateFlows$1.AnonymousClass1.emit(cz.mobilesoft.coreblock.scene.strictmode3.StrictModeStateDto, kotlin.coroutines.Continuation):java.lang.Object");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StrictMode3ViewModel$observeStrictModeStateFlows$1(StrictMode3ViewModel strictMode3ViewModel, Flow flow, Continuation continuation) {
        super(2, continuation);
        this.f121275b = strictMode3ViewModel;
        this.f121276c = flow;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new StrictMode3ViewModel$observeStrictModeStateFlows$1(this.f121275b, this.f121276c, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f121274a;
        if (i3 == 0) {
            ResultKt.b(obj);
            Flow flowB = this.f121275b.t0().b(this.f121276c, this.f121275b.J);
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.f121275b);
            this.f121274a = 1;
            if (flowB.collect(anonymousClass1, this) == objF) {
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
        return ((StrictMode3ViewModel$observeStrictModeStateFlows$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
