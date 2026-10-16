package com.revenuecat.purchases.ui.revenuecatui.composables;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
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
public final class SimpleSheetState {
    public static final int $stable = 0;
    private final MutableState backgroundBlur$delegate;
    private final MutableState content$delegate;
    private Function0<Unit> onDismiss;
    private final MutableState visible$delegate;

    public SimpleSheetState() {
        Boolean bool = Boolean.FALSE;
        this.backgroundBlur$delegate = SnapshotStateKt__SnapshotStateKt.e(bool, null, 2, null);
        this.content$delegate = SnapshotStateKt__SnapshotStateKt.e(ComposableSingletons$SimpleBottomSheetScaffoldKt.INSTANCE.m875getLambda1$revenuecatui_defaultsBc8Release(), null, 2, null);
        this.visible$delegate = SnapshotStateKt__SnapshotStateKt.e(bool, null, 2, null);
    }

    private final void setBackgroundBlur(boolean z2) {
        this.backgroundBlur$delegate.setValue(Boolean.valueOf(z2));
    }

    private final void setContent(Function2<? super Composer, ? super Integer, Unit> function2) {
        this.content$delegate.setValue(function2);
    }

    private final void setVisible(boolean z2) {
        this.visible$delegate.setValue(Boolean.valueOf(z2));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void show$default(SimpleSheetState simpleSheetState, boolean z2, Function2 function2, Function0 function0, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            function0 = null;
        }
        simpleSheetState.show(z2, function2, function0);
    }

    public final /* synthetic */ boolean getBackgroundBlur() {
        return ((Boolean) this.backgroundBlur$delegate.getValue()).booleanValue();
    }

    public final /* synthetic */ Function2 getContent() {
        return (Function2) this.content$delegate.getValue();
    }

    public final /* synthetic */ boolean getVisible() {
        return ((Boolean) this.visible$delegate.getValue()).booleanValue();
    }

    public final void hide() {
        setBackgroundBlur(false);
        setVisible(false);
        Function0<Unit> function0 = this.onDismiss;
        if (function0 != null) {
            function0.invoke();
        }
        this.onDismiss = null;
    }

    public final void show(boolean z2, Function2<? super Composer, ? super Integer, Unit> content, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(content, "content");
        setBackgroundBlur(z2);
        setContent(content);
        this.onDismiss = function0;
        setVisible(true);
    }
}
