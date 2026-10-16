package com.superwall.sdk.game;

import android.view.KeyEvent;
import android.view.MotionEvent;
import com.superwall.sdk.Superwall;
import com.superwall.sdk.misc.MainThreadKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class PublicGameControllerKt {
    public static final void dispatchKeyEvent(Superwall superwall, final KeyEvent keyEvent) {
        Intrinsics.checkNotNullParameter(superwall, "<this>");
        Intrinsics.checkNotNullParameter(keyEvent, "keyEvent");
        MainThreadKt.runOnUiThread(new Function0() { // from class: com.superwall.sdk.game.b
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return PublicGameControllerKt.dispatchKeyEvent$lambda$0(keyEvent);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit dispatchKeyEvent$lambda$0(KeyEvent keyEvent) {
        GameControllerManager.Companion.getShared().dispatchKeyEvent(keyEvent);
        return Unit.f139807a;
    }

    public static final void dispatchMotionEvent(Superwall superwall, final MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(superwall, "<this>");
        Intrinsics.checkNotNullParameter(motionEvent, "motionEvent");
        MainThreadKt.runOnUiThread(new Function0() { // from class: com.superwall.sdk.game.a
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return PublicGameControllerKt.dispatchMotionEvent$lambda$1(motionEvent);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit dispatchMotionEvent$lambda$1(MotionEvent motionEvent) {
        GameControllerManager.Companion.getShared().dispatchMotionEvent(motionEvent);
        return Unit.f139807a;
    }
}
