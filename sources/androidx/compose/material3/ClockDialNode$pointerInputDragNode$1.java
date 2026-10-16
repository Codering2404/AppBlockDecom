package androidx.compose.material3;

import androidx.compose.foundation.gestures.DragGestureDetectorKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.unit.IntOffset;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
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
@DebugMetadata(c = "androidx.compose.material3.ClockDialNode$pointerInputDragNode$1", f = "TimePicker.kt", l = {1456}, m = "invokeSuspend")
final class ClockDialNode$pointerInputDragNode$1 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f16593a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private /* synthetic */ Object f16594b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ ClockDialNode f16595c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ClockDialNode$pointerInputDragNode$1(ClockDialNode clockDialNode, Continuation continuation) {
        super(2, continuation);
        this.f16595c = clockDialNode;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        ClockDialNode$pointerInputDragNode$1 clockDialNode$pointerInputDragNode$1 = new ClockDialNode$pointerInputDragNode$1(this.f16595c, continuation);
        clockDialNode$pointerInputDragNode$1.f16594b = obj;
        return clockDialNode$pointerInputDragNode$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(PointerInputScope pointerInputScope, Continuation continuation) {
        return ((ClockDialNode$pointerInputDragNode$1) create(pointerInputScope, continuation)).invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f16593a;
        if (i3 == 0) {
            ResultKt.b(obj);
            PointerInputScope pointerInputScope = (PointerInputScope) this.f16594b;
            final ClockDialNode clockDialNode = this.f16595c;
            Function0<Unit> function0 = new Function0<Unit>() { // from class: androidx.compose.material3.ClockDialNode$pointerInputDragNode$1.1

                /* JADX INFO: renamed from: androidx.compose.material3.ClockDialNode$pointerInputDragNode$1$1$1, reason: invalid class name and collision with other inner class name */
                /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
                @Metadata
                @DebugMetadata(c = "androidx.compose.material3.ClockDialNode$pointerInputDragNode$1$1$1", f = "TimePicker.kt", l = {1462}, m = "invokeSuspend")
                static final class C00501 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    int f16597a;

                    /* JADX INFO: renamed from: b, reason: collision with root package name */
                    final /* synthetic */ ClockDialNode f16598b;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    C00501(ClockDialNode clockDialNode, Continuation continuation) {
                        super(2, continuation);
                        this.f16598b = clockDialNode;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation create(Object obj, Continuation continuation) {
                        return new C00501(this.f16598b, continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) throws Throwable {
                        Object objF = IntrinsicsKt.f();
                        int i3 = this.f16597a;
                        if (i3 == 0) {
                            ResultKt.b(obj);
                            if (this.f16598b.f16586d) {
                                this.f16598b.f16585c.b(TimePickerSelectionMode.f21378b.b());
                            }
                            AnalogTimePickerState analogTimePickerState = this.f16598b.f16585c;
                            this.f16597a = 1;
                            if (analogTimePickerState.A(this) == objF) {
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
                        return ((C00501) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
                    }
                }

                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    m150invoke();
                    return Unit.f139807a;
                }

                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                public final void m150invoke() {
                    BuildersKt__Builders_commonKt.d(clockDialNode.getCoroutineScope(), null, null, new C00501(clockDialNode, null), 3, null);
                }
            };
            final ClockDialNode clockDialNode2 = this.f16595c;
            Function2<PointerInputChange, Offset, Unit> function2 = new Function2<PointerInputChange, Offset, Unit>() { // from class: androidx.compose.material3.ClockDialNode$pointerInputDragNode$1.2

                /* JADX INFO: renamed from: androidx.compose.material3.ClockDialNode$pointerInputDragNode$1$2$1, reason: invalid class name */
                /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
                @Metadata
                @DebugMetadata(c = "androidx.compose.material3.ClockDialNode$pointerInputDragNode$1$2$1", f = "TimePicker.kt", l = {1469}, m = "invokeSuspend")
                static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    int f16600a;

                    /* JADX INFO: renamed from: b, reason: collision with root package name */
                    final /* synthetic */ ClockDialNode f16601b;

                    /* JADX INFO: renamed from: c, reason: collision with root package name */
                    final /* synthetic */ long f16602c;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    AnonymousClass1(ClockDialNode clockDialNode, long j3, Continuation continuation) {
                        super(2, continuation);
                        this.f16601b = clockDialNode;
                        this.f16602c = j3;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation create(Object obj, Continuation continuation) {
                        return new AnonymousClass1(this.f16601b, this.f16602c, continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) throws Throwable {
                        Object objF = IntrinsicsKt.f();
                        int i3 = this.f16600a;
                        if (i3 == 0) {
                            ResultKt.b(obj);
                            this.f16601b.f16588g += Offset.m(this.f16602c);
                            this.f16601b.f16589h += Offset.n(this.f16602c);
                            AnalogTimePickerState analogTimePickerState = this.f16601b.f16585c;
                            float fH0 = TimePickerKt.h0(this.f16601b.f16589h - IntOffset.l(this.f16601b.f16590i), this.f16601b.f16588g - IntOffset.k(this.f16601b.f16590i));
                            this.f16600a = 1;
                            if (AnalogTimePickerState.C(analogTimePickerState, fH0, false, this, 2, null) == objF) {
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
                    super(2);
                }

                public final void c(PointerInputChange pointerInputChange, long j3) {
                    BuildersKt__Builders_commonKt.d(clockDialNode2.getCoroutineScope(), null, null, new AnonymousClass1(clockDialNode2, j3, null), 3, null);
                    TimePickerKt.m0(clockDialNode2.f16585c, clockDialNode2.f16588g, clockDialNode2.f16589h, clockDialNode2.A2(), clockDialNode2.f16590i);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                    c((PointerInputChange) obj2, ((Offset) obj3).u());
                    return Unit.f139807a;
                }
            };
            this.f16593a = 1;
            if (DragGestureDetectorKt.o(pointerInputScope, null, function0, null, function2, this, 5, null) == objF) {
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
