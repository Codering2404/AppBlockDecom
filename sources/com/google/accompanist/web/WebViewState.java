package com.google.accompanist.web;

import android.graphics.Bitmap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import com.google.accompanist.web.LoadingState;
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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class WebViewState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MutableState f68940a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final MutableState f68941b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final MutableState f68942c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final MutableState f68943d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final SnapshotStateList f68944e;

    public WebViewState(WebContent webContent) {
        Intrinsics.checkNotNullParameter(webContent, "webContent");
        this.f68940a = SnapshotStateKt__SnapshotStateKt.e(webContent, null, 2, null);
        this.f68941b = SnapshotStateKt__SnapshotStateKt.e(LoadingState.Initializing.f68872a, null, 2, null);
        this.f68942c = SnapshotStateKt__SnapshotStateKt.e(null, null, 2, null);
        this.f68943d = SnapshotStateKt__SnapshotStateKt.e(null, null, 2, null);
        this.f68944e = SnapshotStateKt.f();
    }

    public final WebContent a() {
        return (WebContent) this.f68940a.getValue();
    }

    public final SnapshotStateList b() {
        return this.f68944e;
    }

    public final LoadingState c() {
        return (LoadingState) this.f68941b.getValue();
    }

    public final void d(WebContent webContent) {
        Intrinsics.checkNotNullParameter(webContent, "<set-?>");
        this.f68940a.setValue(webContent);
    }

    public final void e(LoadingState loadingState) {
        Intrinsics.checkNotNullParameter(loadingState, "<set-?>");
        this.f68941b.setValue(loadingState);
    }

    public final void f(Bitmap bitmap) {
        this.f68943d.setValue(bitmap);
    }

    public final void g(String str) {
        this.f68942c.setValue(str);
    }
}
