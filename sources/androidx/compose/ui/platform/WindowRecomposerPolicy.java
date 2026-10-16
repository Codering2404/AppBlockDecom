package androidx.compose.ui.platform;

import android.view.View;
import androidx.compose.runtime.Recomposer;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.android.HandlerDispatcherKt;

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
public final class WindowRecomposerPolicy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final WindowRecomposerPolicy f28285a = new WindowRecomposerPolicy();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final AtomicReference f28286b = new AtomicReference(WindowRecomposerFactory.f28282a.c());

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f28287c = 8;

    private WindowRecomposerPolicy() {
    }

    public final Recomposer a(View view) {
        Recomposer recomposerA = ((WindowRecomposerFactory) f28286b.get()).a(view);
        WindowRecomposer_androidKt.i(view, recomposerA);
        final Job jobD = BuildersKt__Builders_commonKt.d(GlobalScope.f140958a, HandlerDispatcherKt.d(view.getHandler(), "windowRecomposer cleanup").w0(), null, new WindowRecomposerPolicy$createAndInstallWindowRecomposer$unsetJob$1(recomposerA, view, null), 2, null);
        view.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: androidx.compose.ui.platform.WindowRecomposerPolicy$createAndInstallWindowRecomposer$1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view2) {
                view2.removeOnAttachStateChangeListener(this);
                Job.DefaultImpls.b(jobD, null, 1, null);
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view2) {
            }
        });
        return recomposerA;
    }
}
