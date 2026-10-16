package androidx.compose.foundation.relocation;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.relocation.BringIntoViewModifierNodeKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;

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
@DebugMetadata(c = "androidx.compose.foundation.relocation.BringIntoViewResponderNode$bringIntoView$2", f = "BringIntoViewResponder.kt", l = {}, m = "invokeSuspend")
final class BringIntoViewResponderNode$bringIntoView$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Job>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f8935a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private /* synthetic */ Object f8936b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ BringIntoViewResponderNode f8937c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ LayoutCoordinates f8938d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ Function0 f8939f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ Function0 f8940g;

    /* JADX INFO: renamed from: androidx.compose.foundation.relocation.BringIntoViewResponderNode$bringIntoView$2$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "androidx.compose.foundation.relocation.BringIntoViewResponderNode$bringIntoView$2$1", f = "BringIntoViewResponder.kt", l = {183}, m = "invokeSuspend")
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f8941a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ BringIntoViewResponderNode f8942b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ LayoutCoordinates f8943c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ Function0 f8944d;

        /* JADX INFO: renamed from: androidx.compose.foundation.relocation.BringIntoViewResponderNode$bringIntoView$2$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        /* synthetic */ class C00211 extends FunctionReferenceImpl implements Function0<Rect> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ BringIntoViewResponderNode f8945a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ LayoutCoordinates f8946b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ Function0 f8947c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00211(BringIntoViewResponderNode bringIntoViewResponderNode, LayoutCoordinates layoutCoordinates, Function0 function0) {
                super(0, Intrinsics.Kotlin.class, "localRect", "bringIntoView$localRect(Landroidx/compose/foundation/relocation/BringIntoViewResponderNode;Landroidx/compose/ui/layout/LayoutCoordinates;Lkotlin/jvm/functions/Function0;)Landroidx/compose/ui/geometry/Rect;", 0);
                this.f8945a = bringIntoViewResponderNode;
                this.f8946b = layoutCoordinates;
                this.f8947c = function0;
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
            public final Rect invoke() {
                return BringIntoViewResponderNode.n2(this.f8945a, this.f8946b, this.f8947c);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(BringIntoViewResponderNode bringIntoViewResponderNode, LayoutCoordinates layoutCoordinates, Function0 function0, Continuation continuation) {
            super(2, continuation);
            this.f8942b = bringIntoViewResponderNode;
            this.f8943c = layoutCoordinates;
            this.f8944d = function0;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass1(this.f8942b, this.f8943c, this.f8944d, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f8941a;
            if (i3 == 0) {
                ResultKt.b(obj);
                BringIntoViewResponder bringIntoViewResponderO2 = this.f8942b.o2();
                C00211 c00211 = new C00211(this.f8942b, this.f8943c, this.f8944d);
                this.f8941a = 1;
                if (bringIntoViewResponderO2.N1(c00211, this) == objF) {
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
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.relocation.BringIntoViewResponderNode$bringIntoView$2$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "androidx.compose.foundation.relocation.BringIntoViewResponderNode$bringIntoView$2$2", f = "BringIntoViewResponder.kt", l = {191}, m = "invokeSuspend")
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f8948a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ BringIntoViewResponderNode f8949b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Function0 f8950c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(BringIntoViewResponderNode bringIntoViewResponderNode, Function0 function0, Continuation continuation) {
            super(2, continuation);
            this.f8949b = bringIntoViewResponderNode;
            this.f8950c = function0;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass2(this.f8949b, this.f8950c, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f8948a;
            if (i3 == 0) {
                ResultKt.b(obj);
                BringIntoViewResponderNode bringIntoViewResponderNode = this.f8949b;
                Function0 function0 = this.f8950c;
                this.f8948a = 1;
                if (BringIntoViewModifierNodeKt.a(bringIntoViewResponderNode, function0, this) == objF) {
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
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BringIntoViewResponderNode$bringIntoView$2(BringIntoViewResponderNode bringIntoViewResponderNode, LayoutCoordinates layoutCoordinates, Function0 function0, Function0 function02, Continuation continuation) {
        super(2, continuation);
        this.f8937c = bringIntoViewResponderNode;
        this.f8938d = layoutCoordinates;
        this.f8939f = function0;
        this.f8940g = function02;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        BringIntoViewResponderNode$bringIntoView$2 bringIntoViewResponderNode$bringIntoView$2 = new BringIntoViewResponderNode$bringIntoView$2(this.f8937c, this.f8938d, this.f8939f, this.f8940g, continuation);
        bringIntoViewResponderNode$bringIntoView$2.f8936b = obj;
        return bringIntoViewResponderNode$bringIntoView$2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        IntrinsicsKt.f();
        if (this.f8935a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        CoroutineScope coroutineScope = (CoroutineScope) this.f8936b;
        BuildersKt__Builders_commonKt.d(coroutineScope, null, null, new AnonymousClass1(this.f8937c, this.f8938d, this.f8939f, null), 3, null);
        return BuildersKt__Builders_commonKt.d(coroutineScope, null, null, new AnonymousClass2(this.f8937c, this.f8940g, null), 3, null);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((BringIntoViewResponderNode$bringIntoView$2) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
