package androidx.compose.foundation.text.selection;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.Offset;
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
@DebugMetadata(c = "androidx.compose.foundation.text.selection.SelectionMagnifierKt$rememberAnimatedMagnifierPosition$1$1", f = "SelectionMagnifier.kt", l = {85}, m = "invokeSuspend")
final class SelectionMagnifierKt$rememberAnimatedMagnifierPosition$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f11410a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private /* synthetic */ Object f11411b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ State f11412c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ Animatable f11413d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SelectionMagnifierKt$rememberAnimatedMagnifierPosition$1$1(State state, Animatable animatable, Continuation continuation) {
        super(2, continuation);
        this.f11412c = state;
        this.f11413d = animatable;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        SelectionMagnifierKt$rememberAnimatedMagnifierPosition$1$1 selectionMagnifierKt$rememberAnimatedMagnifierPosition$1$1 = new SelectionMagnifierKt$rememberAnimatedMagnifierPosition$1$1(this.f11412c, this.f11413d, continuation);
        selectionMagnifierKt$rememberAnimatedMagnifierPosition$1$1.f11411b = obj;
        return selectionMagnifierKt$rememberAnimatedMagnifierPosition$1$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f11410a;
        if (i3 == 0) {
            ResultKt.b(obj);
            final CoroutineScope coroutineScope = (CoroutineScope) this.f11411b;
            final State state = this.f11412c;
            Flow flowQ = SnapshotStateKt.q(new Function0<Offset>() { // from class: androidx.compose.foundation.text.selection.SelectionMagnifierKt$rememberAnimatedMagnifierPosition$1$1.1
                {
                    super(0);
                }

                public final long c() {
                    return SelectionMagnifierKt.i(state);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    return Offset.d(c());
                }
            });
            final Animatable animatable = this.f11413d;
            FlowCollector flowCollector = new FlowCollector() { // from class: androidx.compose.foundation.text.selection.SelectionMagnifierKt$rememberAnimatedMagnifierPosition$1$1.2

                /* JADX INFO: renamed from: androidx.compose.foundation.text.selection.SelectionMagnifierKt$rememberAnimatedMagnifierPosition$1$1$2$1, reason: invalid class name */
                /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
                @Metadata
                @DebugMetadata(c = "androidx.compose.foundation.text.selection.SelectionMagnifierKt$rememberAnimatedMagnifierPosition$1$1$2$1", f = "SelectionMagnifier.kt", l = {98}, m = "invokeSuspend")
                static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    int f11417a;

                    /* JADX INFO: renamed from: b, reason: collision with root package name */
                    final /* synthetic */ Animatable f11418b;

                    /* JADX INFO: renamed from: c, reason: collision with root package name */
                    final /* synthetic */ long f11419c;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    AnonymousClass1(Animatable animatable, long j3, Continuation continuation) {
                        super(2, continuation);
                        this.f11418b = animatable;
                        this.f11419c = j3;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation create(Object obj, Continuation continuation) {
                        return new AnonymousClass1(this.f11418b, this.f11419c, continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) throws Throwable {
                        Object objF = IntrinsicsKt.f();
                        int i3 = this.f11417a;
                        if (i3 == 0) {
                            ResultKt.b(obj);
                            Animatable animatable = this.f11418b;
                            Offset offsetD = Offset.d(this.f11419c);
                            SpringSpec springSpecE = SelectionMagnifierKt.e();
                            this.f11417a = 1;
                            if (Animatable.f(animatable, offsetD, springSpecE, null, null, this, 12, null) == objF) {
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

                public final Object a(long j3, Continuation continuation) {
                    if ((((Offset) animatable.n()).u() & 9223372034707292159L) == 9205357640488583168L || (j3 & 9223372034707292159L) == 9205357640488583168L || Float.intBitsToFloat((int) (((Offset) animatable.n()).u() & 4294967295L)) == Float.intBitsToFloat((int) (j3 & 4294967295L))) {
                        Object objU = animatable.u(Offset.d(j3), continuation);
                        return objU == IntrinsicsKt.f() ? objU : Unit.f139807a;
                    }
                    BuildersKt__Builders_commonKt.d(coroutineScope, null, null, new AnonymousClass1(animatable, j3, null), 3, null);
                    return Unit.f139807a;
                }

                @Override // kotlinx.coroutines.flow.FlowCollector
                public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                    return a(((Offset) obj2).u(), continuation);
                }
            };
            this.f11410a = 1;
            if (flowQ.collect(flowCollector, this) == objF) {
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
        return ((SelectionMagnifierKt$rememberAnimatedMagnifierPosition$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
