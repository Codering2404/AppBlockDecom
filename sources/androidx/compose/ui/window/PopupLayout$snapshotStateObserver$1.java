package androidx.compose.ui.window;

import android.os.Handler;
import android.os.Looper;
import kotlin.Metadata;
import kotlin.Unit;
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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
final class PopupLayout$snapshotStateObserver$1 extends Lambda implements Function1<Function0<? extends Unit>, Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ PopupLayout f30276a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PopupLayout$snapshotStateObserver$1(PopupLayout popupLayout) {
        super(1);
        this.f30276a = popupLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(Function0 function0) {
        function0.invoke();
    }

    public final void d(final Function0 function0) {
        Handler handler = this.f30276a.getHandler();
        if ((handler != null ? handler.getLooper() : null) == Looper.myLooper()) {
            function0.invoke();
            return;
        }
        Handler handler2 = this.f30276a.getHandler();
        if (handler2 != null) {
            handler2.post(new Runnable() { // from class: androidx.compose.ui.window.b
                @Override // java.lang.Runnable
                public final void run() {
                    PopupLayout$snapshotStateObserver$1.e(function0);
                }
            });
        }
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        d((Function0) obj);
        return Unit.f139807a;
    }
}
