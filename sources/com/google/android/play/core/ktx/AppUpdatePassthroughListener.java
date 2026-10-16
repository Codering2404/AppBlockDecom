package com.google.android.play.core.ktx;

import com.google.android.play.core.install.InstallState;
import com.google.android.play.core.install.InstallStateUpdatedListener;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
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
/* JADX INFO: loaded from: classes6.dex */
@Metadata
final class AppUpdatePassthroughListener implements InstallStateUpdatedListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final InstallStateUpdatedListener f83100a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Function1 f83101b;

    public AppUpdatePassthroughListener(InstallStateUpdatedListener listener, Function1 disposeAction) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        Intrinsics.checkNotNullParameter(disposeAction, "disposeAction");
        this.f83100a = listener;
        this.f83101b = disposeAction;
    }

    @Override // com.google.android.play.core.listener.StateUpdatedListener
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final void a(InstallState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        this.f83100a.a(state);
        int iC = state.c();
        if (iC == 0 || iC == 11 || iC == 5 || iC == 6) {
            this.f83101b.invoke(this);
        }
    }
}
