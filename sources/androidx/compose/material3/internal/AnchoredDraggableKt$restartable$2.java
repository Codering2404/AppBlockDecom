package androidx.compose.material3.internal;

import androidx.compose.runtime.SnapshotStateKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
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
/* JADX INFO: loaded from: classes.dex */
@Metadata
@DebugMetadata(c = "androidx.compose.material3.internal.AnchoredDraggableKt$restartable$2", f = "AnchoredDraggable.kt", l = {715}, m = "invokeSuspend")
final class AnchoredDraggableKt$restartable$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f21811a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private /* synthetic */ Object f21812b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Function0 f21813c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ Function2 f21814d;

    /* JADX INFO: renamed from: androidx.compose.material3.internal.AnchoredDraggableKt$restartable$2$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    static final class AnonymousClass1<T> implements FlowCollector {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef f21815a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ CoroutineScope f21816b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Function2 f21817c;

        /* JADX INFO: renamed from: androidx.compose.material3.internal.AnchoredDraggableKt$restartable$2$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @DebugMetadata(c = "androidx.compose.material3.internal.AnchoredDraggableKt$restartable$2$1$2", f = "AnchoredDraggable.kt", l = {722}, m = "invokeSuspend")
        static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f21818a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ Function2 f21819b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ Object f21820c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ CoroutineScope f21821d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass2(Function2 function2, Object obj, CoroutineScope coroutineScope, Continuation continuation) {
                super(2, continuation);
                this.f21819b = function2;
                this.f21820c = obj;
                this.f21821d = coroutineScope;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Object obj, Continuation continuation) {
                return new AnonymousClass2(this.f21819b, this.f21820c, this.f21821d, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                Object objF = IntrinsicsKt.f();
                int i3 = this.f21818a;
                if (i3 == 0) {
                    ResultKt.b(obj);
                    Function2 function2 = this.f21819b;
                    Object obj2 = this.f21820c;
                    this.f21818a = 1;
                    if (function2.invoke(obj2, this) == objF) {
                        return objF;
                    }
                } else {
                    if (i3 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.b(obj);
                }
                CoroutineScopeKt.d(this.f21821d, new AnchoredDragFinishedSignal());
                return Unit.f139807a;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
                return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
            }
        }

        AnonymousClass1(Ref.ObjectRef objectRef, CoroutineScope coroutineScope, Function2 function2) {
            this.f21815a = objectRef;
            this.f21816b = coroutineScope;
            this.f21817c = function2;
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        @Override // kotlinx.coroutines.flow.FlowCollector
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object emit(java.lang.Object r8, kotlin.coroutines.Continuation r9) throws java.lang.Throwable {
            /*
                r7 = this;
                boolean r0 = r9 instanceof androidx.compose.material3.internal.AnchoredDraggableKt$restartable$2$1$emit$1
                if (r0 == 0) goto L13
                r0 = r9
                androidx.compose.material3.internal.AnchoredDraggableKt$restartable$2$1$emit$1 r0 = (androidx.compose.material3.internal.AnchoredDraggableKt$restartable$2$1$emit$1) r0
                int r1 = r0.f21827g
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.f21827g = r1
                goto L18
            L13:
                androidx.compose.material3.internal.AnchoredDraggableKt$restartable$2$1$emit$1 r0 = new androidx.compose.material3.internal.AnchoredDraggableKt$restartable$2$1$emit$1
                r0.<init>(r7, r9)
            L18:
                java.lang.Object r9 = r0.f21825d
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                int r2 = r0.f21827g
                r3 = 1
                if (r2 == 0) goto L3b
                if (r2 != r3) goto L33
                java.lang.Object r8 = r0.f21824c
                kotlinx.coroutines.Job r8 = (kotlinx.coroutines.Job) r8
                java.lang.Object r8 = r0.f21823b
                java.lang.Object r0 = r0.f21822a
                androidx.compose.material3.internal.AnchoredDraggableKt$restartable$2$1 r0 = (androidx.compose.material3.internal.AnchoredDraggableKt$restartable$2.AnonymousClass1) r0
                kotlin.ResultKt.b(r9)
                goto L5e
            L33:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r9)
                throw r8
            L3b:
                kotlin.ResultKt.b(r9)
                kotlin.jvm.internal.Ref$ObjectRef r9 = r7.f21815a
                java.lang.Object r9 = r9.f140144a
                kotlinx.coroutines.Job r9 = (kotlinx.coroutines.Job) r9
                if (r9 == 0) goto L5d
                androidx.compose.material3.internal.AnchoredDragFinishedSignal r2 = new androidx.compose.material3.internal.AnchoredDragFinishedSignal
                r2.<init>()
                r9.cancel(r2)
                r0.f21822a = r7
                r0.f21823b = r8
                r0.f21824c = r9
                r0.f21827g = r3
                java.lang.Object r9 = r9.join(r0)
                if (r9 != r1) goto L5d
                return r1
            L5d:
                r0 = r7
            L5e:
                kotlin.jvm.internal.Ref$ObjectRef r9 = r0.f21815a
                kotlinx.coroutines.CoroutineScope r1 = r0.f21816b
                kotlinx.coroutines.CoroutineStart r3 = kotlinx.coroutines.CoroutineStart.f140919d
                androidx.compose.material3.internal.AnchoredDraggableKt$restartable$2$1$2 r4 = new androidx.compose.material3.internal.AnchoredDraggableKt$restartable$2$1$2
                kotlin.jvm.functions.Function2 r0 = r0.f21817c
                r2 = 0
                r4.<init>(r0, r8, r1, r2)
                r5 = 1
                r6 = 0
                kotlinx.coroutines.Job r8 = kotlinx.coroutines.BuildersKt.d(r1, r2, r3, r4, r5, r6)
                r9.f140144a = r8
                kotlin.Unit r8 = kotlin.Unit.f139807a
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.internal.AnchoredDraggableKt$restartable$2.AnonymousClass1.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AnchoredDraggableKt$restartable$2(Function0 function0, Function2 function2, Continuation continuation) {
        super(2, continuation);
        this.f21813c = function0;
        this.f21814d = function2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        AnchoredDraggableKt$restartable$2 anchoredDraggableKt$restartable$2 = new AnchoredDraggableKt$restartable$2(this.f21813c, this.f21814d, continuation);
        anchoredDraggableKt$restartable$2.f21812b = obj;
        return anchoredDraggableKt$restartable$2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f21811a;
        if (i3 == 0) {
            ResultKt.b(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.f21812b;
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            Flow flowQ = SnapshotStateKt.q(this.f21813c);
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(objectRef, coroutineScope, this.f21814d);
            this.f21811a = 1;
            if (flowQ.collect(anonymousClass1, this) == objF) {
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
        return ((AnchoredDraggableKt$restartable$2) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
