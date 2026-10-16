package com.facebook.internal;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
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
public final class FragmentWrapper {
    private Fragment nativeFragment;
    private androidx.fragment.app.Fragment supportFragment;

    public FragmentWrapper(androidx.fragment.app.Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        this.supportFragment = fragment;
    }

    public final Activity getActivity() {
        androidx.fragment.app.Fragment fragment = this.supportFragment;
        if (fragment != null) {
            if (fragment != null) {
                return fragment.getActivity();
            }
            return null;
        }
        Fragment fragment2 = this.nativeFragment;
        if (fragment2 != null) {
            return fragment2.getActivity();
        }
        return null;
    }

    public final Fragment getNativeFragment() {
        return this.nativeFragment;
    }

    public final androidx.fragment.app.Fragment getSupportFragment() {
        return this.supportFragment;
    }

    public final void startActivityForResult(Intent intent, int i3) {
        androidx.fragment.app.Fragment fragment = this.supportFragment;
        if (fragment != null) {
            if (fragment != null) {
                fragment.startActivityForResult(intent, i3);
            }
        } else {
            Fragment fragment2 = this.nativeFragment;
            if (fragment2 != null) {
                fragment2.startActivityForResult(intent, i3);
            }
        }
    }

    public FragmentWrapper(Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        this.nativeFragment = fragment;
    }
}
