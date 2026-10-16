package cz.mobilesoft.coreblock.scene.more.academy.lesson;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import androidx.fragment.app.Fragment;
import cz.mobilesoft.coreblock.base.activity.BaseFragmentActivitySurface;
import cz.mobilesoft.coreblock.databinding.ActivityFragmentBinding;
import cz.mobilesoft.coreblock.util.analytics.AnswersHelper;
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
public final class AcademyLessonUnavailableActivity extends BaseFragmentActivitySurface<ActivityFragmentBinding> {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final Companion f106231t = new Companion(null);

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final int f106232u = 8;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Intent a(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return new Intent(context, (Class<?>) AcademyLessonUnavailableActivity.class);
        }

        private Companion() {
        }
    }

    @Override // cz.mobilesoft.coreblock.base.activity.BaseAdsBaseActivity
    /* JADX INFO: renamed from: A0, reason: merged with bridge method [inline-methods] */
    public ActivityFragmentBinding o0(LayoutInflater inflater) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        ActivityFragmentBinding activityFragmentBindingC = ActivityFragmentBinding.c(inflater);
        Intrinsics.checkNotNullExpressionValue(activityFragmentBindingC, "inflate(...)");
        return activityFragmentBindingC;
    }

    @Override // cz.mobilesoft.coreblock.base.activity.BaseFragmentActivitySurface
    protected Fragment getFragment() {
        return AcademyLessonUnavailableFragment.f106233b.a();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        AnswersHelper.f128199a.E();
    }
}
