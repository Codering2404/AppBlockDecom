package androidx.compose.foundation.text.input.internal.selection;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState;
import androidx.compose.foundation.text.selection.SelectionMagnifierKt;
import androidx.compose.runtime.SnapshotStateKt;
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
@DebugMetadata(c = "androidx.compose.foundation.text.input.internal.selection.TextFieldMagnifierNodeImpl28$restartAnimationJob$1", f = "AndroidTextFieldMagnifier.android.kt", l = {144}, m = "invokeSuspend")
final class TextFieldMagnifierNodeImpl28$restartAnimationJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f10732a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private /* synthetic */ Object f10733b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ TextFieldMagnifierNodeImpl28 f10734c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TextFieldMagnifierNodeImpl28$restartAnimationJob$1(TextFieldMagnifierNodeImpl28 textFieldMagnifierNodeImpl28, Continuation continuation) {
        super(2, continuation);
        this.f10734c = textFieldMagnifierNodeImpl28;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        TextFieldMagnifierNodeImpl28$restartAnimationJob$1 textFieldMagnifierNodeImpl28$restartAnimationJob$1 = new TextFieldMagnifierNodeImpl28$restartAnimationJob$1(this.f10734c, continuation);
        textFieldMagnifierNodeImpl28$restartAnimationJob$1.f10733b = obj;
        return textFieldMagnifierNodeImpl28$restartAnimationJob$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f10732a;
        if (i3 == 0) {
            ResultKt.b(obj);
            final CoroutineScope coroutineScope = (CoroutineScope) this.f10733b;
            final TextFieldMagnifierNodeImpl28 textFieldMagnifierNodeImpl28 = this.f10734c;
            Flow flowQ = SnapshotStateKt.q(new Function0<Offset>() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldMagnifierNodeImpl28$restartAnimationJob$1.1
                {
                    super(0);
                }

                public final long c() {
                    return (textFieldMagnifierNodeImpl28.f10725g || textFieldMagnifierNodeImpl28.f10723d.X() == TextFieldSelectionState.InputType.f10777b) ? TextFieldMagnifierKt.a(textFieldMagnifierNodeImpl28.f10722c, textFieldMagnifierNodeImpl28.f10723d, textFieldMagnifierNodeImpl28.f10724f, textFieldMagnifierNodeImpl28.A2()) : Offset.f25596b.b();
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    return Offset.d(c());
                }
            });
            final TextFieldMagnifierNodeImpl28 textFieldMagnifierNodeImpl282 = this.f10734c;
            FlowCollector flowCollector = new FlowCollector() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldMagnifierNodeImpl28$restartAnimationJob$1.2

                /* JADX INFO: renamed from: androidx.compose.foundation.text.input.internal.selection.TextFieldMagnifierNodeImpl28$restartAnimationJob$1$2$1, reason: invalid class name */
                /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
                @Metadata
                @DebugMetadata(c = "androidx.compose.foundation.text.input.internal.selection.TextFieldMagnifierNodeImpl28$restartAnimationJob$1$2$1", f = "AndroidTextFieldMagnifier.android.kt", l = {160}, m = "invokeSuspend")
                static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    int f10738a;

                    /* JADX INFO: renamed from: b, reason: collision with root package name */
                    final /* synthetic */ TextFieldMagnifierNodeImpl28 f10739b;

                    /* JADX INFO: renamed from: c, reason: collision with root package name */
                    final /* synthetic */ long f10740c;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    AnonymousClass1(TextFieldMagnifierNodeImpl28 textFieldMagnifierNodeImpl28, long j3, Continuation continuation) {
                        super(2, continuation);
                        this.f10739b = textFieldMagnifierNodeImpl28;
                        this.f10740c = j3;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation create(Object obj, Continuation continuation) {
                        return new AnonymousClass1(this.f10739b, this.f10740c, continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) throws Throwable {
                        Object objF = IntrinsicsKt.f();
                        int i3 = this.f10738a;
                        if (i3 == 0) {
                            ResultKt.b(obj);
                            Animatable animatable = this.f10739b.f10727i;
                            Offset offsetD = Offset.d(this.f10740c);
                            SpringSpec springSpecE = SelectionMagnifierKt.e();
                            this.f10738a = 1;
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
                    if ((((Offset) textFieldMagnifierNodeImpl282.f10727i.n()).u() & 9223372034707292159L) == 9205357640488583168L || (j3 & 9223372034707292159L) == 9205357640488583168L || Float.intBitsToFloat((int) (((Offset) textFieldMagnifierNodeImpl282.f10727i.n()).u() & 4294967295L)) == Float.intBitsToFloat((int) (j3 & 4294967295L))) {
                        Object objU = textFieldMagnifierNodeImpl282.f10727i.u(Offset.d(j3), continuation);
                        return objU == IntrinsicsKt.f() ? objU : Unit.f139807a;
                    }
                    BuildersKt__Builders_commonKt.d(coroutineScope, null, null, new AnonymousClass1(textFieldMagnifierNodeImpl282, j3, null), 3, null);
                    return Unit.f139807a;
                }

                @Override // kotlinx.coroutines.flow.FlowCollector
                public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                    return a(((Offset) obj2).u(), continuation);
                }
            };
            this.f10732a = 1;
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
        return ((TextFieldMagnifierNodeImpl28$restartAnimationJob$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
