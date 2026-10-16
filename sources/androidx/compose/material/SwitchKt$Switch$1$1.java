package androidx.compose.material;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

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
@DebugMetadata(c = "androidx.compose.material.SwitchKt$Switch$1$1", f = "Switch.kt", l = {127}, m = "invokeSuspend")
final class SwitchKt$Switch$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f14432a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ AnchoredDraggableState f14433b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ State f14434c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ State f14435d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ MutableState f14436f;

    /* JADX INFO: renamed from: androidx.compose.material.SwitchKt$Switch$1$1$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "androidx.compose.material.SwitchKt$Switch$1$1$2", f = "Switch.kt", l = {}, m = "invokeSuspend")
    static final class AnonymousClass2 extends SuspendLambda implements Function2<Boolean, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f14438a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ boolean f14439b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ State f14440c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ State f14441d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ MutableState f14442f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(State state, State state2, MutableState mutableState, Continuation continuation) {
            super(2, continuation);
            this.f14440c = state;
            this.f14441d = state2;
            this.f14442f = mutableState;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.f14440c, this.f14441d, this.f14442f, continuation);
            anonymousClass2.f14439b = ((Boolean) obj).booleanValue();
            return anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return invoke(((Boolean) obj).booleanValue(), (Continuation) obj2);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.f();
            if (this.f14438a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            boolean z2 = this.f14439b;
            if (SwitchKt.e(this.f14440c) != z2) {
                Function1 function1D = SwitchKt.d(this.f14441d);
                if (function1D != null) {
                    function1D.invoke(Boxing.a(z2));
                }
                SwitchKt.c(this.f14442f, !SwitchKt.b(r2));
            }
            return Unit.f139807a;
        }

        public final Object invoke(boolean z2, Continuation continuation) {
            return ((AnonymousClass2) create(Boolean.valueOf(z2), continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SwitchKt$Switch$1$1(AnchoredDraggableState anchoredDraggableState, State state, State state2, MutableState mutableState, Continuation continuation) {
        super(2, continuation);
        this.f14433b = anchoredDraggableState;
        this.f14434c = state;
        this.f14435d = state2;
        this.f14436f = mutableState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new SwitchKt$Switch$1$1(this.f14433b, this.f14434c, this.f14435d, this.f14436f, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f14432a;
        if (i3 == 0) {
            ResultKt.b(obj);
            final AnchoredDraggableState anchoredDraggableState = this.f14433b;
            Flow flowQ = SnapshotStateKt.q(new Function0<Boolean>() { // from class: androidx.compose.material.SwitchKt$Switch$1$1.1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final Boolean invoke() {
                    return (Boolean) anchoredDraggableState.s();
                }
            });
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.f14434c, this.f14435d, this.f14436f, null);
            this.f14432a = 1;
            if (FlowKt.l(flowQ, anonymousClass2, this) == objF) {
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
        return ((SwitchKt$Switch$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
