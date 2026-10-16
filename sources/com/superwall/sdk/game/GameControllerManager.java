package com.superwall.sdk.game;

import android.view.KeyEvent;
import android.view.MotionEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class GameControllerManager {
    public static final Companion Companion = new Companion(null);
    private static GameControllerManager shared = new GameControllerManager();
    private GameControllerDelegate delegate;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final GameControllerManager getShared() {
            return GameControllerManager.shared;
        }

        public final void setShared(GameControllerManager gameControllerManager) {
            Intrinsics.checkNotNullParameter(gameControllerManager, "<set-?>");
            GameControllerManager.shared = gameControllerManager;
        }

        private Companion() {
        }
    }

    private final void valueChanged(String str, float f3, float f4, float f5, boolean z2) {
        GameControllerEvent gameControllerEvent = new GameControllerEvent((String) null, str, f3, f4, f5, z2, 1, (DefaultConstructorMarker) null);
        GameControllerDelegate gameControllerDelegate = this.delegate;
        if (gameControllerDelegate != null) {
            gameControllerDelegate.gameControllerEventOccured(gameControllerEvent);
        }
    }

    static /* synthetic */ void valueChanged$default(GameControllerManager gameControllerManager, String str, float f3, float f4, float f5, boolean z2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            f4 = 0.0f;
        }
        if ((i3 & 8) != 0) {
            f5 = 0.0f;
        }
        if ((i3 & 16) != 0) {
            z2 = false;
        }
        gameControllerManager.valueChanged(str, f3, f4, f5, z2);
    }

    public final void clearDelegate(GameControllerDelegate delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        if (Intrinsics.areEqual(this.delegate, delegate)) {
            this.delegate = null;
        }
    }

    public final boolean dispatchKeyEvent(KeyEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        String strMapToButtonName = GameControllerElementMapper.INSTANCE.mapToButtonName(event.getKeyCode());
        if (event.getAction() == 0 && event.getRepeatCount() == 0) {
            valueChanged$default(this, strMapToButtonName, 1.0f, 0.0f, 0.0f, false, 28, null);
        } else if (event.getAction() == 1) {
            valueChanged$default(this, strMapToButtonName, 0.0f, 0.0f, 0.0f, false, 28, null);
        }
        return true;
    }

    public final boolean dispatchMotionEvent(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event.getAction() == 2) {
            valueChanged("Right Thumbstick", 1.0f, event.getAxisValue(0), event.getAxisValue(1), true);
        }
        return true;
    }

    public final void setDelegate(GameControllerDelegate delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.delegate = delegate;
    }
}
