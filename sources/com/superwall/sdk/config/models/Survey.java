package com.superwall.sdk.config.models;

import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import com.superwall.sdk.storage.LocalStorage;
import com.superwall.sdk.storage.SurveyAssignmentKey;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;

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
@Serializable
public final class Survey {
    private final String assignmentKey;
    private final String id;
    private final boolean includeCloseOption;
    private final boolean includeOtherOption;
    private final String message;
    private final List<SurveyOption> options;
    private final SurveyShowCondition presentationCondition;
    private final double presentationProbability;
    private final String title;
    public static final Companion Companion = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {null, null, null, null, new ArrayListSerializer(SurveyOption$$serializer.INSTANCE), null, null, null, null};

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<Survey> serializer() {
            return Survey$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ Survey(int i3, String str, String str2, String str3, String str4, List list, SurveyShowCondition surveyShowCondition, double d3, boolean z2, boolean z3, SerializationConstructorMarker serializationConstructorMarker) {
        if (511 != (i3 & 511)) {
            PluginExceptionsKt.b(i3, 511, Survey$$serializer.INSTANCE.getDescriptor());
        }
        this.id = str;
        this.assignmentKey = str2;
        this.title = str3;
        this.message = str4;
        this.options = list;
        this.presentationCondition = surveyShowCondition;
        this.presentationProbability = d3;
        this.includeOtherOption = z2;
        this.includeCloseOption = z3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Survey copy$default(Survey survey, String str, String str2, String str3, String str4, List list, SurveyShowCondition surveyShowCondition, double d3, boolean z2, boolean z3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = survey.id;
        }
        if ((i3 & 2) != 0) {
            str2 = survey.assignmentKey;
        }
        if ((i3 & 4) != 0) {
            str3 = survey.title;
        }
        if ((i3 & 8) != 0) {
            str4 = survey.message;
        }
        if ((i3 & 16) != 0) {
            list = survey.options;
        }
        if ((i3 & 32) != 0) {
            surveyShowCondition = survey.presentationCondition;
        }
        if ((i3 & 64) != 0) {
            d3 = survey.presentationProbability;
        }
        if ((i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0) {
            z2 = survey.includeOtherOption;
        }
        if ((i3 & Function.MAX_NARGS) != 0) {
            z3 = survey.includeCloseOption;
        }
        double d4 = d3;
        List list2 = list;
        SurveyShowCondition surveyShowCondition2 = surveyShowCondition;
        String str5 = str3;
        String str6 = str4;
        return survey.copy(str, str2, str5, str6, list2, surveyShowCondition2, d4, z2, z3);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$superwall_release(Survey survey, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        KSerializer<Object>[] kSerializerArr = $childSerializers;
        compositeEncoder.y(serialDescriptor, 0, survey.id);
        compositeEncoder.y(serialDescriptor, 1, survey.assignmentKey);
        compositeEncoder.y(serialDescriptor, 2, survey.title);
        compositeEncoder.y(serialDescriptor, 3, survey.message);
        compositeEncoder.C(serialDescriptor, 4, kSerializerArr[4], survey.options);
        compositeEncoder.C(serialDescriptor, 5, SurveyShowConditionSerializer.INSTANCE, survey.presentationCondition);
        compositeEncoder.E(serialDescriptor, 6, survey.presentationProbability);
        compositeEncoder.x(serialDescriptor, 7, survey.includeOtherOption);
        compositeEncoder.x(serialDescriptor, 8, survey.includeCloseOption);
    }

    public final String component1() {
        return this.id;
    }

    public final String component2() {
        return this.assignmentKey;
    }

    public final String component3() {
        return this.title;
    }

    public final String component4() {
        return this.message;
    }

    public final List<SurveyOption> component5() {
        return this.options;
    }

    public final SurveyShowCondition component6() {
        return this.presentationCondition;
    }

    public final double component7() {
        return this.presentationProbability;
    }

    public final boolean component8() {
        return this.includeOtherOption;
    }

    public final boolean component9() {
        return this.includeCloseOption;
    }

    public final Survey copy(String id, String assignmentKey, String title, String message, List<SurveyOption> options, SurveyShowCondition presentationCondition, double d3, boolean z2, boolean z3) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(assignmentKey, "assignmentKey");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(options, "options");
        Intrinsics.checkNotNullParameter(presentationCondition, "presentationCondition");
        return new Survey(id, assignmentKey, title, message, options, presentationCondition, d3, z2, z3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Survey)) {
            return false;
        }
        Survey survey = (Survey) obj;
        return Intrinsics.areEqual(this.id, survey.id) && Intrinsics.areEqual(this.assignmentKey, survey.assignmentKey) && Intrinsics.areEqual(this.title, survey.title) && Intrinsics.areEqual(this.message, survey.message) && Intrinsics.areEqual(this.options, survey.options) && this.presentationCondition == survey.presentationCondition && Double.compare(this.presentationProbability, survey.presentationProbability) == 0 && this.includeOtherOption == survey.includeOtherOption && this.includeCloseOption == survey.includeCloseOption;
    }

    public final String getAssignmentKey() {
        return this.assignmentKey;
    }

    public final String getId() {
        return this.id;
    }

    public final boolean getIncludeCloseOption() {
        return this.includeCloseOption;
    }

    public final boolean getIncludeOtherOption() {
        return this.includeOtherOption;
    }

    public final String getMessage() {
        return this.message;
    }

    public final List<SurveyOption> getOptions() {
        return this.options;
    }

    public final SurveyShowCondition getPresentationCondition() {
        return this.presentationCondition;
    }

    public final double getPresentationProbability() {
        return this.presentationProbability;
    }

    public final String getTitle() {
        return this.title;
    }

    public final boolean hasSeenSurvey(LocalStorage storage) {
        Intrinsics.checkNotNullParameter(storage, "storage");
        String str = (String) storage.read(SurveyAssignmentKey.INSTANCE);
        if (str == null) {
            return false;
        }
        return Intrinsics.areEqual(str, this.assignmentKey);
    }

    public int hashCode() {
        return (((((((((((((((this.id.hashCode() * 31) + this.assignmentKey.hashCode()) * 31) + this.title.hashCode()) * 31) + this.message.hashCode()) * 31) + this.options.hashCode()) * 31) + this.presentationCondition.hashCode()) * 31) + Double.hashCode(this.presentationProbability)) * 31) + Boolean.hashCode(this.includeOtherOption)) * 31) + Boolean.hashCode(this.includeCloseOption);
    }

    public final boolean shouldAssignHoldout(boolean z2) {
        if (z2) {
            return false;
        }
        return this.presentationProbability == 0.0d || Math.random() >= this.presentationProbability;
    }

    public String toString() {
        return "Survey(id=" + this.id + ", assignmentKey=" + this.assignmentKey + ", title=" + this.title + ", message=" + this.message + ", options=" + this.options + ", presentationCondition=" + this.presentationCondition + ", presentationProbability=" + this.presentationProbability + ", includeOtherOption=" + this.includeOtherOption + ", includeCloseOption=" + this.includeCloseOption + ")";
    }

    public Survey(String id, String assignmentKey, String title, String message, List<SurveyOption> options, SurveyShowCondition presentationCondition, double d3, boolean z2, boolean z3) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(assignmentKey, "assignmentKey");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(options, "options");
        Intrinsics.checkNotNullParameter(presentationCondition, "presentationCondition");
        this.id = id;
        this.assignmentKey = assignmentKey;
        this.title = title;
        this.message = message;
        this.options = options;
        this.presentationCondition = presentationCondition;
        this.presentationProbability = d3;
        this.includeOtherOption = z2;
        this.includeCloseOption = z3;
    }
}
