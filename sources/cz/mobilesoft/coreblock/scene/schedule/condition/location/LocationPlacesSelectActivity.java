package cz.mobilesoft.coreblock.scene.schedule.condition.location;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import androidx.fragment.app.Fragment;
import cz.mobilesoft.coreblock.base.activity.BaseFragmentActivitySurface;
import cz.mobilesoft.coreblock.databinding.ActivityFragmentEmptyBinding;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class LocationPlacesSelectActivity extends BaseFragmentActivitySurface<ActivityFragmentEmptyBinding> {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final Companion f115453t = new Companion(null);

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final int f115454u = 8;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Intent a(Context context) {
            return new Intent(context, (Class<?>) LocationPlacesSelectActivity.class);
        }

        private Companion() {
        }
    }

    @Override // cz.mobilesoft.coreblock.base.activity.BaseAdsBaseActivity
    /* JADX INFO: renamed from: A0, reason: merged with bridge method [inline-methods] */
    public ActivityFragmentEmptyBinding o0(LayoutInflater inflater) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        ActivityFragmentEmptyBinding activityFragmentEmptyBindingC = ActivityFragmentEmptyBinding.c(inflater);
        Intrinsics.checkNotNullExpressionValue(activityFragmentEmptyBindingC, "inflate(...)");
        return activityFragmentEmptyBindingC;
    }

    @Override // cz.mobilesoft.coreblock.base.activity.BaseFragmentActivitySurface
    protected Fragment getFragment() {
        return LocationPlacesSelectFragment.f115455g.a();
    }
}
