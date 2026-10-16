package cz.mobilesoft.coreblock.scene.statistics.detail;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import cz.mobilesoft.coreblock.base.activity.BaseActivitySurface;
import cz.mobilesoft.coreblock.databinding.ActivityStatisticsDetailBinding;
import cz.mobilesoft.coreblock.enums.StatisticsTimeFilter;
import cz.mobilesoft.coreblock.enums.StatisticsUsageTypeFilter;
import cz.mobilesoft.coreblock.util.analytics.AnswersHelper;
import java.util.Collection;
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
public final class StatisticsDetailActivity extends BaseActivitySurface<ActivityStatisticsDetailBinding> {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private StatisticsDetailFragment f119801s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private String f119802t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private String f119803u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private Collection f119804v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private StatisticsUsageTypeFilter f119805w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private StatisticsTimeFilter f119806x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private int f119807y;

    private final StatisticsDetailFragment z0(String str, Collection collection, StatisticsUsageTypeFilter statisticsUsageTypeFilter, StatisticsTimeFilter statisticsTimeFilter, int i3) {
        return StatisticsDetailFragment.f119808o.a(str, collection, statisticsUsageTypeFilter, statisticsTimeFilter, i3);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x006e  */
    @Override // cz.mobilesoft.coreblock.base.activity.BaseActivitySurface, cz.mobilesoft.coreblock.base.activity.BaseAdsBaseActivity
    /* JADX INFO: renamed from: A0, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void l0(cz.mobilesoft.coreblock.databinding.ActivityStatisticsDetailBinding r9, android.os.Bundle r10) throws java.lang.IllegalAccessException {
        /*
            Method dump skipped, instruction units count: 242
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.statistics.detail.StatisticsDetailActivity.l0(cz.mobilesoft.coreblock.databinding.ActivityStatisticsDetailBinding, android.os.Bundle):void");
    }

    @Override // cz.mobilesoft.coreblock.base.activity.BaseAdsBaseActivity
    /* JADX INFO: renamed from: B0, reason: merged with bridge method [inline-methods] */
    public ActivityStatisticsDetailBinding o0(LayoutInflater inflater) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        ActivityStatisticsDetailBinding activityStatisticsDetailBindingC = ActivityStatisticsDetailBinding.c(inflater);
        Intrinsics.checkNotNullExpressionValue(activityStatisticsDetailBindingC, "inflate(...)");
        return activityStatisticsDetailBindingC;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int i3, int i4, Intent intent) {
        if (i3 == 947) {
            AnswersHelper.R6(false);
        } else {
            super.onActivityResult(i3, i4, intent);
        }
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        if (item.getItemId() == 16908332) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onSaveInstanceState(Bundle outState) {
        Intrinsics.checkNotNullParameter(outState, "outState");
        outState.putCharSequence("TOOLBAR_TITLE", this.f119802t);
        super.onSaveInstanceState(outState);
    }
}
