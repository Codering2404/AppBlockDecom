package cz.mobilesoft.coreblock.scene.more.haf;

import cz.mobilesoft.coreblock.base.ViewEvent;
import cz.mobilesoft.coreblock.dto.CategoryDTO;
import cz.mobilesoft.coreblock.dto.QuestionDTO;
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
public abstract class HaFViewEvent implements ViewEvent {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ClearSearchQuery extends HaFViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final ClearSearchQuery f107593a = new ClearSearchQuery();

        private ClearSearchQuery() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof ClearSearchQuery);
        }

        public int hashCode() {
            return -1485518964;
        }

        public String toString() {
            return "ClearSearchQuery";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnCategorySelected extends HaFViewEvent {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final int f107594b = CategoryDTO.f96915a;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final CategoryDTO f107595a;

        public OnCategorySelected(CategoryDTO categoryDTO) {
            super(null);
            this.f107595a = categoryDTO;
        }

        public final CategoryDTO a() {
            return this.f107595a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnCategorySelected) && Intrinsics.areEqual(this.f107595a, ((OnCategorySelected) obj).f107595a);
        }

        public int hashCode() {
            CategoryDTO categoryDTO = this.f107595a;
            if (categoryDTO == null) {
                return 0;
            }
            return categoryDTO.hashCode();
        }

        public String toString() {
            return "OnCategorySelected(categoryDTO=" + this.f107595a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnContactSupportClicked extends HaFViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnContactSupportClicked f107596a = new OnContactSupportClicked();

        private OnContactSupportClicked() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnContactSupportClicked);
        }

        public int hashCode() {
            return -1608297792;
        }

        public String toString() {
            return "OnContactSupportClicked";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnQuestionSelected extends HaFViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final QuestionDTO f107597a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final QuestionDTO f107598b;

        public OnQuestionSelected(QuestionDTO questionDTO, QuestionDTO questionDTO2) {
            super(null);
            this.f107597a = questionDTO;
            this.f107598b = questionDTO2;
        }

        public final QuestionDTO a() {
            return this.f107598b;
        }

        public final QuestionDTO b() {
            return this.f107597a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof OnQuestionSelected)) {
                return false;
            }
            OnQuestionSelected onQuestionSelected = (OnQuestionSelected) obj;
            return Intrinsics.areEqual(this.f107597a, onQuestionSelected.f107597a) && Intrinsics.areEqual(this.f107598b, onQuestionSelected.f107598b);
        }

        public int hashCode() {
            QuestionDTO questionDTO = this.f107597a;
            int iHashCode = (questionDTO == null ? 0 : questionDTO.hashCode()) * 31;
            QuestionDTO questionDTO2 = this.f107598b;
            return iHashCode + (questionDTO2 != null ? questionDTO2.hashCode() : 0);
        }

        public String toString() {
            return "OnQuestionSelected(questionDTO=" + this.f107597a + ", previousQuestion=" + this.f107598b + ")";
        }

        public /* synthetic */ OnQuestionSelected(QuestionDTO questionDTO, QuestionDTO questionDTO2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(questionDTO, (i3 & 2) != 0 ? null : questionDTO2);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnResetPresetQuestion extends HaFViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnResetPresetQuestion f107599a = new OnResetPresetQuestion();

        private OnResetPresetQuestion() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnResetPresetQuestion);
        }

        public int hashCode() {
            return 1722309180;
        }

        public String toString() {
            return "OnResetPresetQuestion";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnRetryClicked extends HaFViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnRetryClicked f107600a = new OnRetryClicked();

        private OnRetryClicked() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnRetryClicked);
        }

        public int hashCode() {
            return 1137295927;
        }

        public String toString() {
            return "OnRetryClicked";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnSearchQueryChanged extends HaFViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f107601a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnSearchQueryChanged(String query) {
            super(null);
            Intrinsics.checkNotNullParameter(query, "query");
            this.f107601a = query;
        }

        public final String a() {
            return this.f107601a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnSearchQueryChanged) && Intrinsics.areEqual(this.f107601a, ((OnSearchQueryChanged) obj).f107601a);
        }

        public int hashCode() {
            return this.f107601a.hashCode();
        }

        public String toString() {
            return "OnSearchQueryChanged(query=" + this.f107601a + ")";
        }
    }

    public /* synthetic */ HaFViewEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private HaFViewEvent() {
    }
}
