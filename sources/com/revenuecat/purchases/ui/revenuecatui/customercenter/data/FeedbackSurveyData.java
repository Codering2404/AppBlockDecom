package com.revenuecat.purchases.ui.revenuecatui.customercenter.data;

import com.revenuecat.purchases.customercenter.CustomerCenterConfigData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
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
public final class FeedbackSurveyData {
    public static final int $stable = 8;
    private final CustomerCenterConfigData.HelpPath.PathDetail.FeedbackSurvey feedbackSurvey;
    private final Function1<CustomerCenterConfigData.HelpPath.PathDetail.FeedbackSurvey.Option, Unit> onAnswerSubmitted;

    /* JADX WARN: Multi-variable type inference failed */
    public FeedbackSurveyData(CustomerCenterConfigData.HelpPath.PathDetail.FeedbackSurvey feedbackSurvey, Function1<? super CustomerCenterConfigData.HelpPath.PathDetail.FeedbackSurvey.Option, Unit> onAnswerSubmitted) {
        Intrinsics.checkNotNullParameter(feedbackSurvey, "feedbackSurvey");
        Intrinsics.checkNotNullParameter(onAnswerSubmitted, "onAnswerSubmitted");
        this.feedbackSurvey = feedbackSurvey;
        this.onAnswerSubmitted = onAnswerSubmitted;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FeedbackSurveyData copy$default(FeedbackSurveyData feedbackSurveyData, CustomerCenterConfigData.HelpPath.PathDetail.FeedbackSurvey feedbackSurvey, Function1 function1, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            feedbackSurvey = feedbackSurveyData.feedbackSurvey;
        }
        if ((i3 & 2) != 0) {
            function1 = feedbackSurveyData.onAnswerSubmitted;
        }
        return feedbackSurveyData.copy(feedbackSurvey, function1);
    }

    public final CustomerCenterConfigData.HelpPath.PathDetail.FeedbackSurvey component1() {
        return this.feedbackSurvey;
    }

    public final Function1<CustomerCenterConfigData.HelpPath.PathDetail.FeedbackSurvey.Option, Unit> component2() {
        return this.onAnswerSubmitted;
    }

    public final FeedbackSurveyData copy(CustomerCenterConfigData.HelpPath.PathDetail.FeedbackSurvey feedbackSurvey, Function1<? super CustomerCenterConfigData.HelpPath.PathDetail.FeedbackSurvey.Option, Unit> onAnswerSubmitted) {
        Intrinsics.checkNotNullParameter(feedbackSurvey, "feedbackSurvey");
        Intrinsics.checkNotNullParameter(onAnswerSubmitted, "onAnswerSubmitted");
        return new FeedbackSurveyData(feedbackSurvey, onAnswerSubmitted);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FeedbackSurveyData)) {
            return false;
        }
        FeedbackSurveyData feedbackSurveyData = (FeedbackSurveyData) obj;
        return Intrinsics.areEqual(this.feedbackSurvey, feedbackSurveyData.feedbackSurvey) && Intrinsics.areEqual(this.onAnswerSubmitted, feedbackSurveyData.onAnswerSubmitted);
    }

    public final /* synthetic */ CustomerCenterConfigData.HelpPath.PathDetail.FeedbackSurvey getFeedbackSurvey() {
        return this.feedbackSurvey;
    }

    public final /* synthetic */ Function1 getOnAnswerSubmitted() {
        return this.onAnswerSubmitted;
    }

    public int hashCode() {
        return (this.feedbackSurvey.hashCode() * 31) + this.onAnswerSubmitted.hashCode();
    }

    public String toString() {
        return "FeedbackSurveyData(feedbackSurvey=" + this.feedbackSurvey + ", onAnswerSubmitted=" + this.onAnswerSubmitted + ')';
    }
}
