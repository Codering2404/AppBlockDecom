package androidx.navigation.ui;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import androidx.appcompat.graphics.drawable.DrawerArrowDrawable;
import androidx.customview.widget.Openable;
import androidx.navigation.FloatingWindow;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

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
public abstract class AbstractAppBarOnDestinationChangedListener implements NavController.OnDestinationChangedListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f49490a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AppBarConfiguration f49491b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final WeakReference f49492c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private DrawerArrowDrawable f49493d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ValueAnimator f49494e;

    private final void b(boolean z2) {
        Pair pairA;
        DrawerArrowDrawable drawerArrowDrawable = this.f49493d;
        if (drawerArrowDrawable == null || (pairA = TuplesKt.a(drawerArrowDrawable, Boolean.TRUE)) == null) {
            DrawerArrowDrawable drawerArrowDrawable2 = new DrawerArrowDrawable(this.f49490a);
            this.f49493d = drawerArrowDrawable2;
            pairA = TuplesKt.a(drawerArrowDrawable2, Boolean.FALSE);
        }
        DrawerArrowDrawable drawerArrowDrawable3 = (DrawerArrowDrawable) pairA.a();
        boolean zBooleanValue = ((Boolean) pairA.b()).booleanValue();
        c(drawerArrowDrawable3, z2 ? R.string.f49513b : R.string.f49512a);
        float f3 = z2 ? 0.0f : 1.0f;
        if (!zBooleanValue) {
            drawerArrowDrawable3.setProgress(f3);
            return;
        }
        float fA = drawerArrowDrawable3.a();
        ValueAnimator valueAnimator = this.f49494e;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(drawerArrowDrawable3, "progress", fA, f3);
        this.f49494e = objectAnimatorOfFloat;
        Intrinsics.checkNotNull(objectAnimatorOfFloat, "null cannot be cast to non-null type android.animation.ObjectAnimator");
        objectAnimatorOfFloat.start();
    }

    @Override // androidx.navigation.NavController.OnDestinationChangedListener
    public void a(NavController controller, NavDestination destination, Bundle bundle) {
        Intrinsics.checkNotNullParameter(controller, "controller");
        Intrinsics.checkNotNullParameter(destination, "destination");
        if (destination instanceof FloatingWindow) {
            return;
        }
        WeakReference weakReference = this.f49492c;
        Openable openable = weakReference != null ? (Openable) weakReference.get() : null;
        if (this.f49492c != null && openable == null) {
            controller.W(this);
            return;
        }
        String strG = destination.g(this.f49490a, bundle);
        if (strG != null) {
            d(strG);
        }
        boolean zA = this.f49491b.a(destination);
        boolean z2 = false;
        if (openable == null && zA) {
            c(null, 0);
            return;
        }
        if (openable != null && zA) {
            z2 = true;
        }
        b(z2);
    }

    protected abstract void c(Drawable drawable, int i3);

    protected abstract void d(CharSequence charSequence);
}
