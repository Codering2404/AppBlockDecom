package dev.doubledot.doki.extensions;

import android.view.View;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class ViewKt {
    public static final <T extends View> T gone(T receiver$0) {
        Intrinsics.checkParameterIsNotNull(receiver$0, "receiver$0");
        receiver$0.setVisibility(8);
        return receiver$0;
    }

    public static final <T extends View> T goneIf(T receiver$0, boolean z2) {
        Intrinsics.checkParameterIsNotNull(receiver$0, "receiver$0");
        return (T) visibleIf(receiver$0, !z2);
    }

    public static final <T extends View> T invisible(T receiver$0) {
        Intrinsics.checkParameterIsNotNull(receiver$0, "receiver$0");
        receiver$0.setVisibility(4);
        return receiver$0;
    }

    public static final <T extends View> T invisibleIf(T receiver$0, boolean z2) {
        Intrinsics.checkParameterIsNotNull(receiver$0, "receiver$0");
        return z2 ? (T) invisible(receiver$0) : (T) visible(receiver$0);
    }

    public static final boolean isGone(View receiver$0) {
        Intrinsics.checkParameterIsNotNull(receiver$0, "receiver$0");
        return receiver$0.getVisibility() == 8;
    }

    public static final boolean isInvisible(View receiver$0) {
        Intrinsics.checkParameterIsNotNull(receiver$0, "receiver$0");
        return receiver$0.getVisibility() == 4;
    }

    public static final boolean isVisible(View receiver$0) {
        Intrinsics.checkParameterIsNotNull(receiver$0, "receiver$0");
        return receiver$0.getVisibility() == 0;
    }

    public static final <T extends View> T visible(T receiver$0) {
        Intrinsics.checkParameterIsNotNull(receiver$0, "receiver$0");
        receiver$0.setVisibility(0);
        return receiver$0;
    }

    public static final <T extends View> T visibleIf(T receiver$0, boolean z2) {
        Intrinsics.checkParameterIsNotNull(receiver$0, "receiver$0");
        return z2 ? (T) visible(receiver$0) : (T) gone(receiver$0);
    }
}
