package com.revenuecat.purchases.ui.revenuecatui.customercenter.views;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import com.revenuecat.purchases.customercenter.CustomerCenterConfigData;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.data.CustomerCenterConfigTestData;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.data.FeedbackSurveyData;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
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
public final /* synthetic */ class FeedbackSurveyViewKt {
    /* JADX WARN: Removed duplicated region for block: B:50:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x01cc  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x01d7  */
    /* JADX WARN: Removed duplicated region for block: B:96:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final /* synthetic */ void FeedbackSurveyButtonsView(final java.util.List r22, final kotlin.jvm.functions.Function1 r23, final java.lang.String r24, androidx.compose.ui.Modifier r25, androidx.compose.runtime.Composer r26, final int r27, final int r28) {
        /*
            Method dump skipped, instruction units count: 482
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.FeedbackSurveyViewKt.FeedbackSurveyButtonsView(java.util.List, kotlin.jvm.functions.Function1, java.lang.String, androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int, int):void");
    }

    public static final /* synthetic */ void FeedbackSurveyPreview(Composer composer, final int i3) {
        List<CustomerCenterConfigData.HelpPath> paths;
        Composer composerK = composer.k(-1976778683);
        if (i3 == 0 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(-1976778683, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.views.FeedbackSurveyPreview (FeedbackSurveyView.kt:72)");
            }
            helpPath = null;
            CustomerCenterConfigData.Screen managementScreen = CustomerCenterConfigTestData.customerCenterData$default(CustomerCenterConfigTestData.INSTANCE, false, false, 3, null).getManagementScreen();
            if (managementScreen != null && (paths = managementScreen.getPaths()) != null) {
                for (CustomerCenterConfigData.HelpPath helpPath : paths) {
                    if (helpPath.getType() == CustomerCenterConfigData.HelpPath.PathType.CANCEL) {
                    }
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
            Intrinsics.checkNotNull(helpPath);
            CustomerCenterConfigData.HelpPath.PathDetail.FeedbackSurvey feedbackSurvey = helpPath.getFeedbackSurvey();
            Intrinsics.checkNotNull(feedbackSurvey);
            FeedbackSurveyView(new FeedbackSurveyData(feedbackSurvey, new Function1<CustomerCenterConfigData.HelpPath.PathDetail.FeedbackSurvey.Option, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.FeedbackSurveyViewKt.FeedbackSurveyPreview.2
                public final void invoke(CustomerCenterConfigData.HelpPath.PathDetail.FeedbackSurvey.Option option) {
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((CustomerCenterConfigData.HelpPath.PathDetail.FeedbackSurvey.Option) obj);
                    return Unit.f139807a;
                }
            }), composerK, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.FeedbackSurveyViewKt.FeedbackSurveyPreview.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i4) {
                    FeedbackSurveyViewKt.FeedbackSurveyPreview(composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    public static final /* synthetic */ void FeedbackSurveyView(final FeedbackSurveyData data, Composer composer, final int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(data, "data");
        Composer composerK = composer.k(1091362999);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(data) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i4 & 3) == 2 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(1091362999, i4, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.views.FeedbackSurveyView (FeedbackSurveyView.kt:27)");
            }
            composerK.a0(125160704);
            Object objG = composerK.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG == companion.a()) {
                objG = SnapshotStateKt__SnapshotStateKt.e(null, null, 2, null);
                composerK.w(objG);
            }
            final MutableState mutableState = (MutableState) objG;
            composerK.U();
            CustomerCenterConfigData.HelpPath.PathDetail.FeedbackSurvey feedbackSurvey = data.getFeedbackSurvey();
            Modifier.Companion companion2 = Modifier.b8;
            MeasurePolicy measurePolicyG = BoxKt.g(Alignment.f25072a.o(), false);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, companion2);
            ComposeUiNode.Companion companion3 = ComposeUiNode.f8;
            Function0 function0A = companion3.a();
            if (composerK.m() == null) {
                ComposablesKt.c();
            }
            composerK.L();
            if (composerK.i()) {
                composerK.P(function0A);
            } else {
                composerK.v();
            }
            Composer composerA = Updater.a(composerK);
            Updater.e(composerA, measurePolicyG, companion3.e());
            Updater.e(composerA, compositionLocalMapU, companion3.g());
            Function2 function2B = companion3.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion3.f());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
            List<CustomerCenterConfigData.HelpPath.PathDetail.FeedbackSurvey.Option> options = feedbackSurvey.getOptions();
            composerK.a0(-250247028);
            boolean zI = composerK.I(data);
            Object objG2 = composerK.G();
            if (zI || objG2 == companion.a()) {
                objG2 = new Function1<CustomerCenterConfigData.HelpPath.PathDetail.FeedbackSurvey.Option, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.FeedbackSurveyViewKt$FeedbackSurveyView$1$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((CustomerCenterConfigData.HelpPath.PathDetail.FeedbackSurvey.Option) obj);
                        return Unit.f139807a;
                    }

                    public final void invoke(CustomerCenterConfigData.HelpPath.PathDetail.FeedbackSurvey.Option option) {
                        Intrinsics.checkNotNullParameter(option, "option");
                        mutableState.setValue(option.getId());
                        data.getOnAnswerSubmitted().invoke(option);
                        mutableState.setValue(null);
                    }
                };
                composerK.w(objG2);
            }
            composerK.U();
            FeedbackSurveyButtonsView(options, (Function1) objG2, FeedbackSurveyView$lambda$1(mutableState), null, composerK, 0, 8);
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.FeedbackSurveyViewKt.FeedbackSurveyView.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i5) {
                    FeedbackSurveyViewKt.FeedbackSurveyView(data, composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    private static final String FeedbackSurveyView$lambda$1(MutableState<String> mutableState) {
        return (String) mutableState.getValue();
    }
}
