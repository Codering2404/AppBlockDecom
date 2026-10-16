package androidx.compose.material3;

import androidx.compose.foundation.gestures.PressGestureScope;
import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.glance.color.Tq.KqqtdetwHMIO;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

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
@DebugMetadata(c = "androidx.compose.material3.ClockDialNode$pointerInputTapNode$1", f = "TimePicker.kt", l = {1439}, m = "invokeSuspend")
final class ClockDialNode$pointerInputTapNode$1 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f16603a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private /* synthetic */ Object f16604b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ ClockDialNode f16605c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ClockDialNode$pointerInputTapNode$1(ClockDialNode clockDialNode, Continuation continuation) {
        super(2, continuation);
        this.f16605c = clockDialNode;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        ClockDialNode$pointerInputTapNode$1 clockDialNode$pointerInputTapNode$1 = new ClockDialNode$pointerInputTapNode$1(this.f16605c, continuation);
        clockDialNode$pointerInputTapNode$1.f16604b = obj;
        return clockDialNode$pointerInputTapNode$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(PointerInputScope pointerInputScope, Continuation continuation) {
        return ((ClockDialNode$pointerInputTapNode$1) create(pointerInputScope, continuation)).invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f16603a;
        if (i3 == 0) {
            ResultKt.b(obj);
            PointerInputScope pointerInputScope = (PointerInputScope) this.f16604b;
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.f16605c, null);
            final ClockDialNode clockDialNode = this.f16605c;
            Function1<Offset, Unit> function1 = new Function1<Offset, Unit>() { // from class: androidx.compose.material3.ClockDialNode$pointerInputTapNode$1.2

                /* JADX INFO: renamed from: androidx.compose.material3.ClockDialNode$pointerInputTapNode$1$2$1, reason: invalid class name */
                /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
                @Metadata
                @DebugMetadata(c = "androidx.compose.material3.ClockDialNode$pointerInputTapNode$1$2$1", f = "TimePicker.kt", l = {1446}, m = "invokeSuspend")
                static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    int f16610a;

                    /* JADX INFO: renamed from: b, reason: collision with root package name */
                    final /* synthetic */ ClockDialNode f16611b;

                    /* JADX INFO: renamed from: c, reason: collision with root package name */
                    final /* synthetic */ long f16612c;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    AnonymousClass1(ClockDialNode clockDialNode, long j3, Continuation continuation) {
                        super(2, continuation);
                        this.f16611b = clockDialNode;
                        this.f16612c = j3;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation create(Object obj, Continuation continuation) {
                        return new AnonymousClass1(this.f16611b, this.f16612c, continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) throws Throwable {
                        Object objF = IntrinsicsKt.f();
                        int i3 = this.f16610a;
                        if (i3 == 0) {
                            ResultKt.b(obj);
                            AnalogTimePickerState analogTimePickerState = this.f16611b.f16585c;
                            float fM = Offset.m(this.f16612c);
                            float fN = Offset.n(this.f16612c);
                            float fA2 = this.f16611b.A2();
                            boolean z2 = this.f16611b.f16586d;
                            long j3 = this.f16611b.f16590i;
                            this.f16610a = 1;
                            if (TimePickerKt.o0(analogTimePickerState, fM, fN, fA2, z2, j3, this) == objF) {
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

                {
                    super(1);
                }

                public final void c(long j3) {
                    BuildersKt__Builders_commonKt.d(clockDialNode.getCoroutineScope(), null, null, new AnonymousClass1(clockDialNode, j3, null), 3, null);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    c(((Offset) obj2).u());
                    return Unit.f139807a;
                }
            };
            this.f16603a = 1;
            if (TapGestureDetectorKt.m(pointerInputScope, null, null, anonymousClass1, function1, this, 3, null) == objF) {
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

    /* JADX INFO: renamed from: androidx.compose.material3.ClockDialNode$pointerInputTapNode$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes2.dex */
    @Metadata
    @DebugMetadata(c = "androidx.compose.material3.ClockDialNode$pointerInputTapNode$1$1", f = "TimePicker.kt", l = {}, m = "invokeSuspend")
    static final class AnonymousClass1 extends SuspendLambda implements Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f16606a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ long f16607b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ ClockDialNode f16608c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(ClockDialNode clockDialNode, Continuation continuation) {
            super(3, continuation);
            this.f16608c = clockDialNode;
        }

        public final Object h(PressGestureScope pressGestureScope, long j3, Continuation continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.f16608c, continuation);
            anonymousClass1.f16607b = j3;
            return anonymousClass1.invokeSuspend(Unit.f139807a);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            return h((PressGestureScope) obj, ((Offset) obj2).u(), (Continuation) obj3);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.f();
            if (this.f16606a == 0) {
                ResultKt.b(obj);
                long j3 = this.f16607b;
                this.f16608c.f16588g = Offset.m(j3);
                this.f16608c.f16589h = Offset.n(j3);
                return Unit.f139807a;
            }
            throw new IllegalStateException(KqqtdetwHMIO.mcxiwtdGlS);
        }
    }
}
