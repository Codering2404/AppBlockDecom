package com.google.android.play.core.ktx;

import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.google.android.play.core.common.IntentSenderForResultStarter;
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
/* JADX INFO: loaded from: classes6.dex */
@Metadata
final /* synthetic */ class AppUpdateManagerKtxKt$startUpdateFlowForResult$1 implements IntentSenderForResultStarter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Fragment f83099a;

    @Override // com.google.android.play.core.common.IntentSenderForResultStarter
    public final void a(IntentSender p02, int i3, Intent intent, int i4, int i5, int i6, Bundle bundle) throws IntentSender.SendIntentException {
        Intrinsics.checkNotNullParameter(p02, "p0");
        this.f83099a.startIntentSenderForResult(p02, i3, intent, i4, i5, i6, bundle);
    }
}
