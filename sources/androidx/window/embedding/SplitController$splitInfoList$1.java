package androidx.window.embedding;

import android.app.Activity;
import androidx.core.util.Consumer;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;

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
@DebugMetadata(c = "androidx.window.embedding.SplitController$splitInfoList$1", f = "SplitController.kt", l = {64}, m = "invokeSuspend")
final class SplitController$splitInfoList$1 extends SuspendLambda implements Function2<ProducerScope<? super List<? extends SplitInfo>>, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f54275a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private /* synthetic */ Object f54276b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ SplitController f54277c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ Activity f54278d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SplitController$splitInfoList$1(SplitController splitController, Activity activity, Continuation continuation) {
        super(2, continuation);
        this.f54277c = splitController;
        this.f54278d = activity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(ProducerScope producerScope, List list) {
        producerScope.h(list);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        SplitController$splitInfoList$1 splitController$splitInfoList$1 = new SplitController$splitInfoList$1(this.f54277c, this.f54278d, continuation);
        splitController$splitInfoList$1.f54276b = obj;
        return splitController$splitInfoList$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f54275a;
        if (i3 == 0) {
            ResultKt.b(obj);
            final ProducerScope producerScope = (ProducerScope) this.f54276b;
            final Consumer consumer = new Consumer() { // from class: androidx.window.embedding.c
                @Override // androidx.core.util.Consumer
                public final void accept(Object obj2) {
                    SplitController$splitInfoList$1.y(producerScope, (List) obj2);
                }
            };
            this.f54277c.f54269a.a(this.f54278d, new androidx.credentials.c(), consumer);
            final SplitController splitController = this.f54277c;
            Function0<Unit> function0 = new Function0<Unit>() { // from class: androidx.window.embedding.SplitController$splitInfoList$1.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    m361invoke();
                    return Unit.f139807a;
                }

                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                public final void m361invoke() {
                    splitController.f54269a.b(consumer);
                }
            };
            this.f54275a = 1;
            if (ProduceKt.a(producerScope, function0, this) == objF) {
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
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public final Object invoke(ProducerScope producerScope, Continuation continuation) {
        return ((SplitController$splitInfoList$1) create(producerScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
