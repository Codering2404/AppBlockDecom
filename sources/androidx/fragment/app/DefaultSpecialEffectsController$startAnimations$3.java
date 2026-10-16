package androidx.fragment.app;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.fragment.app.DefaultSpecialEffectsController;
import androidx.fragment.app.SpecialEffectsController;
import kotlin.Metadata;
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
public final class DefaultSpecialEffectsController$startAnimations$3 implements Animation.AnimationListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ SpecialEffectsController.Operation f37139a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ DefaultSpecialEffectsController f37140b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ View f37141c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ DefaultSpecialEffectsController.AnimationInfo f37142d;

    DefaultSpecialEffectsController$startAnimations$3(SpecialEffectsController.Operation operation, DefaultSpecialEffectsController defaultSpecialEffectsController, View view, DefaultSpecialEffectsController.AnimationInfo animationInfo) {
        this.f37139a = operation;
        this.f37140b = defaultSpecialEffectsController;
        this.f37141c = view;
        this.f37142d = animationInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(DefaultSpecialEffectsController this$0, View view, DefaultSpecialEffectsController.AnimationInfo animationInfo) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(animationInfo, "$animationInfo");
        this$0.q().endViewTransition(view);
        animationInfo.a();
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        ViewGroup viewGroupQ = this.f37140b.q();
        final DefaultSpecialEffectsController defaultSpecialEffectsController = this.f37140b;
        final View view = this.f37141c;
        final DefaultSpecialEffectsController.AnimationInfo animationInfo = this.f37142d;
        viewGroupQ.post(new Runnable() { // from class: androidx.fragment.app.h
            @Override // java.lang.Runnable
            public final void run() {
                DefaultSpecialEffectsController$startAnimations$3.b(defaultSpecialEffectsController, view, animationInfo);
            }
        });
        if (FragmentManager.R0(2)) {
            Log.v("FragmentManager", "Animation from operation " + this.f37139a + " has ended.");
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        if (FragmentManager.R0(2)) {
            Log.v("FragmentManager", "Animation from operation " + this.f37139a + " has reached onAnimationStart.");
        }
    }
}
