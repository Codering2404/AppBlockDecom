package com.superwall.sdk.paywall.view;

import android.view.View;
import androidx.lifecycle.ViewModel;
import com.superwall.sdk.paywall.view.ViewStorage;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;

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
public final class ViewStorageViewModel extends ViewModel implements ViewStorage {
    private final ConcurrentHashMap<String, View> views = new ConcurrentHashMap<>();

    @Override // com.superwall.sdk.paywall.view.ViewStorage
    public List<View> all() {
        return ViewStorage.DefaultImpls.all(this);
    }

    @Override // com.superwall.sdk.paywall.view.ViewStorage
    public ConcurrentHashMap<String, View> getViews() {
        return this.views;
    }

    @Override // com.superwall.sdk.paywall.view.ViewStorage
    public Set<String> keys() {
        return ViewStorage.DefaultImpls.keys(this);
    }

    @Override // com.superwall.sdk.paywall.view.ViewStorage
    public void removeView(String str) {
        ViewStorage.DefaultImpls.removeView(this, str);
    }

    @Override // com.superwall.sdk.paywall.view.ViewStorage
    public View retrieveView(String str) {
        return ViewStorage.DefaultImpls.retrieveView(this, str);
    }

    @Override // com.superwall.sdk.paywall.view.ViewStorage
    public void storeView(String str, View view) {
        ViewStorage.DefaultImpls.storeView(this, str, view);
    }
}
