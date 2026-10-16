package coil.target;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import coil.transition.TransitionTarget;
import kotlin.Metadata;

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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public abstract class GenericViewTarget<T extends View> implements ViewTarget<T>, TransitionTarget, DefaultLifecycleObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f56187a;

    @Override // coil.target.Target
    public void c(Drawable drawable) {
        i(drawable);
    }

    @Override // coil.target.Target
    public void d(Drawable drawable) {
        i(drawable);
    }

    @Override // coil.target.Target
    public void e(Drawable drawable) {
        i(drawable);
    }

    @Override // coil.transition.TransitionTarget
    public abstract Drawable f();

    public abstract void g(Drawable drawable);

    protected final void h() {
        Object objF = f();
        Animatable animatable = objF instanceof Animatable ? (Animatable) objF : null;
        if (animatable == null) {
            return;
        }
        if (this.f56187a) {
            animatable.start();
        } else {
            animatable.stop();
        }
    }

    protected final void i(Drawable drawable) {
        Object objF = f();
        Animatable animatable = objF instanceof Animatable ? (Animatable) objF : null;
        if (animatable != null) {
            animatable.stop();
        }
        g(drawable);
        h();
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onStart(LifecycleOwner lifecycleOwner) {
        this.f56187a = true;
        h();
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onStop(LifecycleOwner lifecycleOwner) {
        this.f56187a = false;
        h();
    }
}
