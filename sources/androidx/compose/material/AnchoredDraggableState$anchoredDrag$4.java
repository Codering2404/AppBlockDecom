package androidx.compose.material;

import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;

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
@DebugMetadata(c = "androidx.compose.material.AnchoredDraggableState$anchoredDrag$4", f = "AnchoredDraggable.kt", l = {587}, m = "invokeSuspend")
final class AnchoredDraggableState$anchoredDrag$4 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f11727a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ AnchoredDraggableState f11728b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Object f11729c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ Function4 f11730d;

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: androidx.compose.material.AnchoredDraggableState$anchoredDrag$4$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "androidx.compose.material.AnchoredDraggableState$anchoredDrag$4$2", f = "AnchoredDraggable.kt", l = {590}, m = "invokeSuspend")
    static final class AnonymousClass2<T> extends SuspendLambda implements Function2<Pair<? extends DraggableAnchors<T>, ? extends T>, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f11732a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f11733b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Function4 f11734c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ AnchoredDraggableState f11735d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(Function4 function4, AnchoredDraggableState anchoredDraggableState, Continuation continuation) {
            super(2, continuation);
            this.f11734c = function4;
            this.f11735d = anchoredDraggableState;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.f11734c, this.f11735d, continuation);
            anonymousClass2.f11733b = obj;
            return anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public final Object invoke(Pair pair, Continuation continuation) {
            return ((AnonymousClass2) create(pair, continuation)).invokeSuspend(Unit.f139807a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f11732a;
            if (i3 == 0) {
                ResultKt.b(obj);
                Pair pair = (Pair) this.f11733b;
                DraggableAnchors draggableAnchors = (DraggableAnchors) pair.a();
                Object objB = pair.b();
                Function4 function4 = this.f11734c;
                AnchoredDragScope anchoredDragScope = this.f11735d.f11703o;
                this.f11732a = 1;
                if (function4.invoke(anchoredDragScope, draggableAnchors, objB, this) == objF) {
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
    AnchoredDraggableState$anchoredDrag$4(AnchoredDraggableState anchoredDraggableState, Object obj, Function4 function4, Continuation continuation) {
        super(1, continuation);
        this.f11728b = anchoredDraggableState;
        this.f11729c = obj;
        this.f11730d = function4;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new AnchoredDraggableState$anchoredDrag$4(this.f11728b, this.f11729c, this.f11730d, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f11727a;
        if (i3 == 0) {
            ResultKt.b(obj);
            this.f11728b.D(this.f11729c);
            final AnchoredDraggableState anchoredDraggableState = this.f11728b;
            Function0<Pair<? extends DraggableAnchors<T>, ? extends T>> function0 = new Function0<Pair<? extends DraggableAnchors<T>, ? extends T>>() { // from class: androidx.compose.material.AnchoredDraggableState$anchoredDrag$4.1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                public final Pair invoke() {
                    return TuplesKt.a(anchoredDraggableState.o(), anchoredDraggableState.x());
                }
            };
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.f11730d, this.f11728b, null);
            this.f11727a = 1;
            if (AnchoredDraggableKt.j(function0, anonymousClass2, this) == objF) {
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
        return ((AnchoredDraggableState$anchoredDrag$4) create(continuation)).invokeSuspend(Unit.f139807a);
    }
}
