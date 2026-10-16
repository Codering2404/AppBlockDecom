package androidx.compose.material;

import android.view.View;
import android.view.ViewTreeObserver;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

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
final class OnGlobalLayoutListener implements View.OnAttachStateChangeListener, ViewTreeObserver.OnGlobalLayoutListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final View f13310a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Function0 f13311b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f13312c;

    public OnGlobalLayoutListener(View view, Function0 function0) {
        this.f13310a = view;
        this.f13311b = function0;
        view.addOnAttachStateChangeListener(this);
        b();
    }

    private final void b() {
        if (this.f13312c || !this.f13310a.isAttachedToWindow()) {
            return;
        }
        this.f13310a.getViewTreeObserver().addOnGlobalLayoutListener(this);
        this.f13312c = true;
    }

    private final void c() {
        if (this.f13312c) {
            this.f13310a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            this.f13312c = false;
        }
    }

    public final void a() {
        c();
        this.f13310a.removeOnAttachStateChangeListener(this);
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        this.f13311b.invoke();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
        b();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        c();
    }
}
