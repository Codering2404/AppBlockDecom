package androidx.compose.foundation.layout;

import android.os.Build;
import android.view.View;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.WindowInsetsAnimationCompat;
import androidx.core.view.WindowInsetsCompat;
import java.util.List;
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
/* JADX INFO: loaded from: classes.dex */
@Metadata
final class InsetsListener extends WindowInsetsAnimationCompat.Callback implements Runnable, OnApplyWindowInsetsListener, View.OnAttachStateChangeListener {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final WindowInsetsHolder f6960c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f6961d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f6962f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private WindowInsetsCompat f6963g;

    public InsetsListener(WindowInsetsHolder windowInsetsHolder) {
        super(!windowInsetsHolder.d() ? 1 : 0);
        this.f6960c = windowInsetsHolder;
    }

    @Override // androidx.core.view.OnApplyWindowInsetsListener
    public WindowInsetsCompat a(View view, WindowInsetsCompat windowInsetsCompat) {
        this.f6963g = windowInsetsCompat;
        this.f6960c.t(windowInsetsCompat);
        if (this.f6961d) {
            if (Build.VERSION.SDK_INT == 30) {
                view.post(this);
            }
        } else if (!this.f6962f) {
            this.f6960c.s(windowInsetsCompat);
            WindowInsetsHolder.r(this.f6960c, windowInsetsCompat, 0, 2, null);
        }
        return this.f6960c.d() ? WindowInsetsCompat.f34517b : windowInsetsCompat;
    }

    @Override // androidx.core.view.WindowInsetsAnimationCompat.Callback
    public void c(WindowInsetsAnimationCompat windowInsetsAnimationCompat) {
        this.f6961d = false;
        this.f6962f = false;
        WindowInsetsCompat windowInsetsCompat = this.f6963g;
        if (windowInsetsAnimationCompat.a() != 0 && windowInsetsCompat != null) {
            this.f6960c.s(windowInsetsCompat);
            this.f6960c.t(windowInsetsCompat);
            WindowInsetsHolder.r(this.f6960c, windowInsetsCompat, 0, 2, null);
        }
        this.f6963g = null;
        super.c(windowInsetsAnimationCompat);
    }

    @Override // androidx.core.view.WindowInsetsAnimationCompat.Callback
    public void d(WindowInsetsAnimationCompat windowInsetsAnimationCompat) {
        this.f6961d = true;
        this.f6962f = true;
        super.d(windowInsetsAnimationCompat);
    }

    @Override // androidx.core.view.WindowInsetsAnimationCompat.Callback
    public WindowInsetsCompat e(WindowInsetsCompat windowInsetsCompat, List list) {
        WindowInsetsHolder.r(this.f6960c, windowInsetsCompat, 0, 2, null);
        return this.f6960c.d() ? WindowInsetsCompat.f34517b : windowInsetsCompat;
    }

    @Override // androidx.core.view.WindowInsetsAnimationCompat.Callback
    public WindowInsetsAnimationCompat.BoundsCompat f(WindowInsetsAnimationCompat windowInsetsAnimationCompat, WindowInsetsAnimationCompat.BoundsCompat boundsCompat) {
        this.f6961d = false;
        return super.f(windowInsetsAnimationCompat, boundsCompat);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
        view.requestApplyInsets();
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f6961d) {
            this.f6961d = false;
            this.f6962f = false;
            WindowInsetsCompat windowInsetsCompat = this.f6963g;
            if (windowInsetsCompat != null) {
                this.f6960c.s(windowInsetsCompat);
                WindowInsetsHolder.r(this.f6960c, windowInsetsCompat, 0, 2, null);
                this.f6963g = null;
            }
        }
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
    }
}
