package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.internal.CombineKt;

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
/* JADX INFO: loaded from: classes9.dex */
@Metadata
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransform$6", f = "Zip.kt", l = {247}, m = "invokeSuspend")
public final class FlowKt__ZipKt$combineTransform$6 extends SuspendLambda implements Function2<FlowCollector<Object>, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f142136a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private /* synthetic */ Object f142137b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Flow[] f142138c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ Function3 f142139d;

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransform$6$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransform$6$2", f = "Zip.kt", l = {247}, m = "invokeSuspend")
    public static final class AnonymousClass2 extends SuspendLambda implements Function3<FlowCollector<Object>, Object[], Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f142141a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private /* synthetic */ Object f142142b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        /* synthetic */ Object f142143c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ Function3 f142144d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Function3 function3, Continuation continuation) {
            super(3, continuation);
            this.f142144d = function3;
        }

        @Override // kotlin.jvm.functions.Function3
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public final Object invoke(FlowCollector flowCollector, Object[] objArr, Continuation continuation) {
            Intrinsics.needClassReification();
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.f142144d, continuation);
            anonymousClass2.f142142b = flowCollector;
            anonymousClass2.f142143c = objArr;
            return anonymousClass2.invokeSuspend(Unit.f139807a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f142141a;
            if (i3 == 0) {
                ResultKt.b(obj);
                FlowCollector flowCollector = (FlowCollector) this.f142142b;
                Object[] objArr = (Object[]) this.f142143c;
                Function3 function3 = this.f142144d;
                this.f142142b = null;
                this.f142141a = 1;
                if (function3.invoke(flowCollector, objArr, this) == objF) {
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowKt__ZipKt$combineTransform$6(Flow[] flowArr, Function3 function3, Continuation continuation) {
        super(2, continuation);
        this.f142138c = flowArr;
        this.f142139d = function3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        FlowKt__ZipKt$combineTransform$6 flowKt__ZipKt$combineTransform$6 = new FlowKt__ZipKt$combineTransform$6(this.f142138c, this.f142139d, continuation);
        flowKt__ZipKt$combineTransform$6.f142137b = obj;
        return flowKt__ZipKt$combineTransform$6;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f142136a;
        if (i3 == 0) {
            ResultKt.b(obj);
            FlowCollector flowCollector = (FlowCollector) this.f142137b;
            Flow[] flowArr = this.f142138c;
            Intrinsics.needClassReification();
            final Flow[] flowArr2 = this.f142138c;
            Function0<Object[]> function0 = new Function0<Object[]>() { // from class: kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransform$6.1
                @Override // kotlin.jvm.functions.Function0
                /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                public final Object[] invoke() {
                    int length = flowArr2.length;
                    Intrinsics.reifiedOperationMarker(0, "T?");
                    return new Object[length];
                }
            };
            Intrinsics.needClassReification();
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.f142139d, null);
            this.f142136a = 1;
            if (CombineKt.a(flowCollector, flowArr, function0, anonymousClass2, this) == objF) {
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
    public final Object invoke(FlowCollector flowCollector, Continuation continuation) {
        return ((FlowKt__ZipKt$combineTransform$6) create(flowCollector, continuation)).invokeSuspend(Unit.f139807a);
    }
}
