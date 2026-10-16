package androidx.window.area;

import androidx.window.extensions.area.ExtensionWindowAreaStatus;
import androidx.window.extensions.core.util.function.Consumer;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
@Metadata
@DebugMetadata(c = "androidx.window.area.WindowAreaControllerImpl$windowAreaInfos$1", f = "WindowAreaControllerImpl.kt", l = {94}, m = "invokeSuspend")
final class WindowAreaControllerImpl$windowAreaInfos$1 extends SuspendLambda implements Function2<ProducerScope<? super List<? extends WindowAreaInfo>>, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f54076a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private /* synthetic */ Object f54077b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ WindowAreaControllerImpl f54078c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    WindowAreaControllerImpl$windowAreaInfos$1(WindowAreaControllerImpl windowAreaControllerImpl, Continuation continuation) {
        super(2, continuation);
        this.f54078c = windowAreaControllerImpl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A(WindowAreaControllerImpl windowAreaControllerImpl, ProducerScope producerScope, ExtensionWindowAreaStatus extensionWindowAreaStatus) {
        Intrinsics.checkNotNullExpressionValue(extensionWindowAreaStatus, "extensionWindowAreaStatus");
        windowAreaControllerImpl.n(extensionWindowAreaStatus);
        SendChannel sendChannelN = producerScope.n();
        Collection collectionValues = windowAreaControllerImpl.f54057f.values();
        Intrinsics.checkNotNullExpressionValue(collectionValues, "currentWindowAreaInfoMap.values");
        sendChannelN.h(CollectionsKt.toList(collectionValues));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(WindowAreaControllerImpl windowAreaControllerImpl, ProducerScope producerScope, Integer status) {
        Intrinsics.checkNotNullExpressionValue(status, "status");
        windowAreaControllerImpl.m(status.intValue());
        SendChannel sendChannelN = producerScope.n();
        Collection collectionValues = windowAreaControllerImpl.f54057f.values();
        Intrinsics.checkNotNullExpressionValue(collectionValues, "currentWindowAreaInfoMap.values");
        sendChannelN.h(CollectionsKt.toList(collectionValues));
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        WindowAreaControllerImpl$windowAreaInfos$1 windowAreaControllerImpl$windowAreaInfos$1 = new WindowAreaControllerImpl$windowAreaInfos$1(this.f54078c, continuation);
        windowAreaControllerImpl$windowAreaInfos$1.f54077b = obj;
        return windowAreaControllerImpl$windowAreaInfos$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f54076a;
        if (i3 == 0) {
            ResultKt.b(obj);
            final ProducerScope producerScope = (ProducerScope) this.f54077b;
            final WindowAreaControllerImpl windowAreaControllerImpl = this.f54078c;
            final Consumer consumer = new Consumer() { // from class: androidx.window.area.e
                @Override // androidx.window.extensions.core.util.function.Consumer
                public final void accept(Object obj2) {
                    WindowAreaControllerImpl$windowAreaInfos$1.z(windowAreaControllerImpl, producerScope, (Integer) obj2);
                }
            };
            final WindowAreaControllerImpl windowAreaControllerImpl2 = this.f54078c;
            final Consumer consumer2 = new Consumer() { // from class: androidx.window.area.f
                @Override // androidx.window.extensions.core.util.function.Consumer
                public final void accept(Object obj2) {
                    WindowAreaControllerImpl$windowAreaInfos$1.A(windowAreaControllerImpl2, producerScope, (ExtensionWindowAreaStatus) obj2);
                }
            };
            this.f54078c.f54052a.addRearDisplayStatusListener(consumer);
            if (this.f54078c.f54053b > 2) {
                this.f54078c.f54052a.addRearDisplayPresentationStatusListener(consumer2);
            }
            final WindowAreaControllerImpl windowAreaControllerImpl3 = this.f54078c;
            Function0<Unit> function0 = new Function0<Unit>() { // from class: androidx.window.area.WindowAreaControllerImpl$windowAreaInfos$1.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    m360invoke();
                    return Unit.f139807a;
                }

                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                public final void m360invoke() {
                    windowAreaControllerImpl3.f54052a.removeRearDisplayStatusListener(consumer);
                    if (windowAreaControllerImpl3.f54053b > 2) {
                        windowAreaControllerImpl3.f54052a.removeRearDisplayPresentationStatusListener(consumer2);
                    }
                }
            };
            this.f54076a = 1;
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
        return ((WindowAreaControllerImpl$windowAreaInfos$1) create(producerScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
