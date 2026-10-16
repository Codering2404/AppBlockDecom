package androidx.window.layout;

import android.content.Context;
import androidx.core.util.Consumer;
import androidx.credentials.c;
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
@DebugMetadata(c = "androidx.window.layout.WindowInfoTrackerImpl$windowLayoutInfo$1", f = "WindowInfoTrackerImpl.kt", l = {50}, m = "invokeSuspend")
final class WindowInfoTrackerImpl$windowLayoutInfo$1 extends SuspendLambda implements Function2<ProducerScope<? super WindowLayoutInfo>, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f54353a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private /* synthetic */ Object f54354b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ WindowInfoTrackerImpl f54355c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ Context f54356d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    WindowInfoTrackerImpl$windowLayoutInfo$1(WindowInfoTrackerImpl windowInfoTrackerImpl, Context context, Continuation continuation) {
        super(2, continuation);
        this.f54355c = windowInfoTrackerImpl;
        this.f54356d = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(ProducerScope producerScope, WindowLayoutInfo windowLayoutInfo) {
        producerScope.h(windowLayoutInfo);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        WindowInfoTrackerImpl$windowLayoutInfo$1 windowInfoTrackerImpl$windowLayoutInfo$1 = new WindowInfoTrackerImpl$windowLayoutInfo$1(this.f54355c, this.f54356d, continuation);
        windowInfoTrackerImpl$windowLayoutInfo$1.f54354b = obj;
        return windowInfoTrackerImpl$windowLayoutInfo$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f54353a;
        if (i3 == 0) {
            ResultKt.b(obj);
            final ProducerScope producerScope = (ProducerScope) this.f54354b;
            final Consumer consumer = new Consumer() { // from class: androidx.window.layout.a
                @Override // androidx.core.util.Consumer
                public final void accept(Object obj2) {
                    WindowInfoTrackerImpl$windowLayoutInfo$1.y(producerScope, (WindowLayoutInfo) obj2);
                }
            };
            this.f54355c.f54352c.b(this.f54356d, new c(), consumer);
            final WindowInfoTrackerImpl windowInfoTrackerImpl = this.f54355c;
            Function0<Unit> function0 = new Function0<Unit>() { // from class: androidx.window.layout.WindowInfoTrackerImpl$windowLayoutInfo$1.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    m362invoke();
                    return Unit.f139807a;
                }

                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                public final void m362invoke() {
                    windowInfoTrackerImpl.f54352c.a(consumer);
                }
            };
            this.f54353a = 1;
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
        return ((WindowInfoTrackerImpl$windowLayoutInfo$1) create(producerScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
