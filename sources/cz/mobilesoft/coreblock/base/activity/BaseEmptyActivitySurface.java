package cz.mobilesoft.coreblock.base.activity;

import android.view.LayoutInflater;
import cz.mobilesoft.coreblock.databinding.ActivityFragmentEmptyBinding;
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
public abstract class BaseEmptyActivitySurface extends BaseFragmentActivitySurface<ActivityFragmentEmptyBinding> {
    @Override // cz.mobilesoft.coreblock.base.activity.BaseAdsBaseActivity
    /* JADX INFO: renamed from: A0, reason: merged with bridge method [inline-methods] */
    public ActivityFragmentEmptyBinding o0(LayoutInflater inflater) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        ActivityFragmentEmptyBinding activityFragmentEmptyBindingC = ActivityFragmentEmptyBinding.c(inflater);
        Intrinsics.checkNotNullExpressionValue(activityFragmentEmptyBindingC, "inflate(...)");
        return activityFragmentEmptyBindingC;
    }
}
