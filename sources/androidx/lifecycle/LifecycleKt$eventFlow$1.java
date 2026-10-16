package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
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
import kotlinx.coroutines.channels.SendChannel;

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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
@DebugMetadata(c = "androidx.lifecycle.LifecycleKt$eventFlow$1", f = "Lifecycle.kt", l = {373}, m = "invokeSuspend")
final class LifecycleKt$eventFlow$1 extends SuspendLambda implements Function2<ProducerScope<? super Lifecycle.Event>, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f39974a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private /* synthetic */ Object f39975b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Lifecycle f39976c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LifecycleKt$eventFlow$1(Lifecycle lifecycle, Continuation continuation) {
        super(2, continuation);
        this.f39976c = lifecycle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit A(Lifecycle lifecycle, LifecycleEventObserver lifecycleEventObserver) {
        lifecycle.removeObserver(lifecycleEventObserver);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(ProducerScope producerScope, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        producerScope.h(event);
        if (event == Lifecycle.Event.ON_DESTROY) {
            SendChannel.DefaultImpls.a(producerScope, null, 1, null);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        LifecycleKt$eventFlow$1 lifecycleKt$eventFlow$1 = new LifecycleKt$eventFlow$1(this.f39976c, continuation);
        lifecycleKt$eventFlow$1.f39975b = obj;
        return lifecycleKt$eventFlow$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f39974a;
        if (i3 == 0) {
            ResultKt.b(obj);
            final ProducerScope producerScope = (ProducerScope) this.f39975b;
            final LifecycleEventObserver lifecycleEventObserver = new LifecycleEventObserver() { // from class: androidx.lifecycle.g
                @Override // androidx.lifecycle.LifecycleEventObserver
                public final void j(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                    LifecycleKt$eventFlow$1.z(producerScope, lifecycleOwner, event);
                }
            };
            this.f39976c.addObserver(lifecycleEventObserver);
            final Lifecycle lifecycle = this.f39976c;
            Function0 function0 = new Function0() { // from class: androidx.lifecycle.h
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return LifecycleKt$eventFlow$1.A(lifecycle, lifecycleEventObserver);
                }
            };
            this.f39974a = 1;
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
    /* JADX INFO: renamed from: y, reason: merged with bridge method [inline-methods] */
    public final Object invoke(ProducerScope producerScope, Continuation continuation) {
        return ((LifecycleKt$eventFlow$1) create(producerScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
