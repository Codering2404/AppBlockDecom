package androidx.compose.material3.internal;

import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

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
final class AccessibilityServiceStateProvider_androidKt$ObserveState$3$1 extends Lambda implements Function1<DisposableEffectScope, DisposableEffectResult> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ LifecycleOwner f21764a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Function1 f21765b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Function0 f21766c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AccessibilityServiceStateProvider_androidKt$ObserveState$3$1(LifecycleOwner lifecycleOwner, Function1 function1, Function0 function0) {
        super(1);
        this.f21764a = lifecycleOwner;
        this.f21765b = function1;
        this.f21766c = function0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(Function1 function1, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        function1.invoke(event);
    }

    @Override // kotlin.jvm.functions.Function1
    public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
        final Function1 function1 = this.f21765b;
        final LifecycleEventObserver lifecycleEventObserver = new LifecycleEventObserver() { // from class: androidx.compose.material3.internal.a
            @Override // androidx.lifecycle.LifecycleEventObserver
            public final void j(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                AccessibilityServiceStateProvider_androidKt$ObserveState$3$1.d(function1, lifecycleOwner, event);
            }
        };
        this.f21764a.getLifecycle().addObserver(lifecycleEventObserver);
        final Function0 function0 = this.f21766c;
        final LifecycleOwner lifecycleOwner = this.f21764a;
        return new DisposableEffectResult() { // from class: androidx.compose.material3.internal.AccessibilityServiceStateProvider_androidKt$ObserveState$3$1$invoke$$inlined$onDispose$1
            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
                function0.invoke();
                lifecycleOwner.getLifecycle().removeObserver(lifecycleEventObserver);
            }
        };
    }
}
