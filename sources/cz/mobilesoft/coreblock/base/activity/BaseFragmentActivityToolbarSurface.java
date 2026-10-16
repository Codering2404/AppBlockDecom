package cz.mobilesoft.coreblock.base.activity;

import android.os.Bundle;
import android.view.LayoutInflater;
import androidx.activity.EdgeToEdge;
import cz.mobilesoft.coreblock.databinding.ActivityToolbarSurfaceBinding;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public abstract class BaseFragmentActivityToolbarSurface extends BaseFragmentActivitySurface<ActivityToolbarSurfaceBinding> {
    @Override // cz.mobilesoft.coreblock.base.activity.BaseAdsBaseActivity
    /* JADX INFO: renamed from: A0, reason: merged with bridge method [inline-methods] */
    public ActivityToolbarSurfaceBinding o0(LayoutInflater inflater) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        ActivityToolbarSurfaceBinding activityToolbarSurfaceBindingC = ActivityToolbarSurfaceBinding.c(inflater);
        Intrinsics.checkNotNullExpressionValue(activityToolbarSurfaceBindingC, "inflate(...)");
        return activityToolbarSurfaceBindingC;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cz.mobilesoft.coreblock.base.activity.BaseAdsBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        EdgeToEdge.b(this, null, null, 3, null);
    }
}
