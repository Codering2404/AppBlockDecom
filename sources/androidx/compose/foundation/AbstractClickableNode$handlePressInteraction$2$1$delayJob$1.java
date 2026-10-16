package androidx.compose.foundation;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.interaction.PressInteraction;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
@Metadata
@DebugMetadata(c = "androidx.compose.foundation.AbstractClickableNode$handlePressInteraction$2$1$delayJob$1", f = "Clickable.kt", l = {1257, 1260}, m = "invokeSuspend")
final class AbstractClickableNode$handlePressInteraction$2$1$delayJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f4531a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f4532b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ AbstractClickableNode f4533c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ long f4534d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ MutableInteractionSource f4535f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AbstractClickableNode$handlePressInteraction$2$1$delayJob$1(AbstractClickableNode abstractClickableNode, long j3, MutableInteractionSource mutableInteractionSource, Continuation continuation) {
        super(2, continuation);
        this.f4533c = abstractClickableNode;
        this.f4534d = j3;
        this.f4535f = mutableInteractionSource;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new AbstractClickableNode$handlePressInteraction$2$1$delayJob$1(this.f4533c, this.f4534d, this.f4535f, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        PressInteraction.Press press;
        Object objF = IntrinsicsKt.f();
        int i3 = this.f4532b;
        if (i3 == 0) {
            ResultKt.b(obj);
            if (this.f4533c.B2()) {
                long jA = Clickable_androidKt.a();
                this.f4532b = 1;
                if (DelayKt.b(jA, this) != objF) {
                }
                return objF;
            }
        } else {
            if (i3 != 1) {
                if (i3 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                press = (PressInteraction.Press) this.f4531a;
                ResultKt.b(obj);
                this.f4533c.f4510n = press;
                return Unit.f139807a;
            }
            ResultKt.b(obj);
        }
        PressInteraction.Press press2 = new PressInteraction.Press(this.f4534d, null);
        MutableInteractionSource mutableInteractionSource = this.f4535f;
        this.f4531a = press2;
        this.f4532b = 2;
        if (mutableInteractionSource.a(press2, this) != objF) {
            press = press2;
            this.f4533c.f4510n = press;
            return Unit.f139807a;
        }
        return objF;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((AbstractClickableNode$handlePressInteraction$2$1$delayJob$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
