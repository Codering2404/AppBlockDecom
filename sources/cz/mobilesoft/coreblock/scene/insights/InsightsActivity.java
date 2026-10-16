package cz.mobilesoft.coreblock.scene.insights;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import cz.mobilesoft.coreblock.base.activity.BaseComposeActivity;
import cz.mobilesoft.coreblock.enums.PremiumFeature;
import cz.mobilesoft.coreblock.scene.insights.InsightsViewState;
import cz.mobilesoft.coreblock.scene.premium.host.Paywall;
import cz.mobilesoft.coreblock.scene.premium.host.PaywallTarget;
import cz.mobilesoft.coreblock.scene.schedule.ScheduleActivity;
import cz.mobilesoft.coreblock.scene.schedule.ScheduleDescriptor;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class InsightsActivity extends BaseComposeActivity {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Companion f102590g = new Companion(null);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f102591h = 8;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f102592f;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Intent a(Context context, String packageName, InsightsViewState.InsightsPeriodType selectedInsightType) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(packageName, "packageName");
            Intrinsics.checkNotNullParameter(selectedInsightType, "selectedInsightType");
            Bundle bundle = new Bundle();
            bundle.putString("PACKAGE_NAME", packageName);
            bundle.putSerializable("SELECTED_INSIGHT_TYPE", selectedInsightType);
            Intent intent = new Intent(context, (Class<?>) InsightsActivity.class);
            intent.putExtras(bundle);
            return intent;
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n0(InsightsActivity insightsActivity, List list) {
        insightsActivity.startActivity(ScheduleActivity.Companion.b(ScheduleActivity.f114377m, insightsActivity, new ScheduleDescriptor.NewSchedule(list, null, false, true, null, null, 54, null), false, false, 12, null));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o0(InsightsActivity insightsActivity) {
        insightsActivity.startActivity(Paywall.c(Paywall.f113165a, insightsActivity, new PaywallTarget.LimitScreen(PremiumFeature.STATISTICS), "app_feel_labeling", "app_feel_exclude", false, false, false, null, 240, null));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p0(InsightsActivity insightsActivity, PaddingValues paddingValues, int i3, Composer composer, int i4) {
        insightsActivity.c0(paddingValues, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    @Override // cz.mobilesoft.coreblock.base.activity.BaseComposeActivity
    public void c0(final PaddingValues paddingValues, Composer composer, final int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        Composer composerK = composer.k(-2065000959);
        if ((i3 & 48) == 0) {
            i4 = (composerK.I(this) ? 32 : 16) | i3;
        } else {
            i4 = i3;
        }
        if (composerK.r((i4 & 17) != 16, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-2065000959, i4, -1, "cz.mobilesoft.coreblock.scene.insights.InsightsActivity.RootCompose (InsightsActivity.kt:36)");
            }
            String stringExtra = getIntent().getStringExtra("PACKAGE_NAME");
            Serializable serializableExtra = getIntent().getSerializableExtra("SELECTED_INSIGHT_TYPE");
            InsightsViewState.InsightsPeriodType insightsPeriodType = serializableExtra instanceof InsightsViewState.InsightsPeriodType ? (InsightsViewState.InsightsPeriodType) serializableExtra : null;
            if (insightsPeriodType == null) {
                insightsPeriodType = InsightsViewState.InsightsPeriodType.Day;
            }
            InsightsViewState.InsightsPeriodType insightsPeriodType2 = insightsPeriodType;
            boolean zI = composerK.I(this);
            Object objG = composerK.G();
            if (zI || objG == Composer.f23746a.a()) {
                objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.insights.g0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return InsightsActivity.n0(this.f103108a, (List) obj);
                    }
                };
                composerK.w(objG);
            }
            Function1 function1 = (Function1) objG;
            boolean zI2 = composerK.I(this);
            Object objG2 = composerK.G();
            if (zI2 || objG2 == Composer.f23746a.a()) {
                objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.insights.h0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return InsightsActivity.o0(this.f103126a);
                    }
                };
                composerK.w(objG2);
            }
            InsightsScreenKt.i0(stringExtra, insightsPeriodType2, function1, (Function0) objG2, composerK, 0, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.insights.i0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return InsightsActivity.p0(this.f103153a, paddingValues, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    @Override // cz.mobilesoft.coreblock.base.activity.BaseComposeActivity
    protected boolean f0() {
        return this.f102592f;
    }
}
