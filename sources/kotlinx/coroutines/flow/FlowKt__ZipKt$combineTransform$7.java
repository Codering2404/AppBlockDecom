package kotlinx.coroutines.flow;

import com.revenuecat.purchases.common.networking.RCHTTPStatusCodes;
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
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransform$7", f = "Zip.kt", l = {RCHTTPStatusCodes.NOT_MODIFIED}, m = "invokeSuspend")
public final class FlowKt__ZipKt$combineTransform$7 extends SuspendLambda implements Function2<FlowCollector<Object>, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f142145a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private /* synthetic */ Object f142146b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Flow[] f142147c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ Function3 f142148d;

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransform$7$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransform$7$2", f = "Zip.kt", l = {RCHTTPStatusCodes.NOT_MODIFIED}, m = "invokeSuspend")
    public static final class AnonymousClass2 extends SuspendLambda implements Function3<FlowCollector<Object>, Object[], Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f142150a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private /* synthetic */ Object f142151b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        /* synthetic */ Object f142152c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ Function3 f142153d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Function3 function3, Continuation continuation) {
            super(3, continuation);
            this.f142153d = function3;
        }

        @Override // kotlin.jvm.functions.Function3
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public final Object invoke(FlowCollector flowCollector, Object[] objArr, Continuation continuation) {
            Intrinsics.needClassReification();
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.f142153d, continuation);
            anonymousClass2.f142151b = flowCollector;
            anonymousClass2.f142152c = objArr;
            return anonymousClass2.invokeSuspend(Unit.f139807a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f142150a;
            if (i3 == 0) {
                ResultKt.b(obj);
                FlowCollector flowCollector = (FlowCollector) this.f142151b;
                Object[] objArr = (Object[]) this.f142152c;
                Function3 function3 = this.f142153d;
                this.f142151b = null;
                this.f142150a = 1;
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
    public FlowKt__ZipKt$combineTransform$7(Flow[] flowArr, Function3 function3, Continuation continuation) {
        super(2, continuation);
        this.f142147c = flowArr;
        this.f142148d = function3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        FlowKt__ZipKt$combineTransform$7 flowKt__ZipKt$combineTransform$7 = new FlowKt__ZipKt$combineTransform$7(this.f142147c, this.f142148d, continuation);
        flowKt__ZipKt$combineTransform$7.f142146b = obj;
        return flowKt__ZipKt$combineTransform$7;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f142145a;
        if (i3 == 0) {
            ResultKt.b(obj);
            FlowCollector flowCollector = (FlowCollector) this.f142146b;
            Flow[] flowArr = this.f142147c;
            Intrinsics.needClassReification();
            final Flow[] flowArr2 = this.f142147c;
            Function0<Object[]> function0 = new Function0<Object[]>() { // from class: kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransform$7.1
                @Override // kotlin.jvm.functions.Function0
                /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                public final Object[] invoke() {
                    int length = flowArr2.length;
                    Intrinsics.reifiedOperationMarker(0, "T?");
                    return new Object[length];
                }
            };
            Intrinsics.needClassReification();
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.f142148d, null);
            this.f142145a = 1;
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
        return ((FlowKt__ZipKt$combineTransform$7) create(flowCollector, continuation)).invokeSuspend(Unit.f139807a);
    }
}
