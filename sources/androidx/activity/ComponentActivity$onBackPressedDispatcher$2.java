package androidx.activity;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
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
final class ComponentActivity$onBackPressedDispatcher$2 extends Lambda implements Function0<OnBackPressedDispatcher> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ ComponentActivity f353a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ComponentActivity$onBackPressedDispatcher$2(ComponentActivity componentActivity) {
        super(0);
        this.f353a = componentActivity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(ComponentActivity componentActivity) {
        try {
            super/*android.app.Activity*/.onBackPressed();
        } catch (IllegalStateException e3) {
            if (!Intrinsics.areEqual(e3.getMessage(), "Can not perform this action after onSaveInstanceState")) {
                throw e3;
            }
        } catch (NullPointerException e4) {
            if (!Intrinsics.areEqual(e4.getMessage(), "Attempt to invoke virtual method 'android.os.Handler android.app.FragmentHostCallback.getHandler()' on a null object reference")) {
                throw e4;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(ComponentActivity componentActivity, OnBackPressedDispatcher onBackPressedDispatcher) {
        componentActivity.D(onBackPressedDispatcher);
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public final OnBackPressedDispatcher invoke() {
        final ComponentActivity componentActivity = this.f353a;
        final OnBackPressedDispatcher onBackPressedDispatcher = new OnBackPressedDispatcher(new Runnable() { // from class: androidx.activity.j
            @Override // java.lang.Runnable
            public final void run() {
                ComponentActivity$onBackPressedDispatcher$2.h(componentActivity);
            }
        });
        final ComponentActivity componentActivity2 = this.f353a;
        if (Build.VERSION.SDK_INT >= 33) {
            if (!Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: androidx.activity.k
                    @Override // java.lang.Runnable
                    public final void run() {
                        ComponentActivity$onBackPressedDispatcher$2.m(componentActivity2, onBackPressedDispatcher);
                    }
                });
                return onBackPressedDispatcher;
            }
            componentActivity2.D(onBackPressedDispatcher);
        }
        return onBackPressedDispatcher;
    }
}
