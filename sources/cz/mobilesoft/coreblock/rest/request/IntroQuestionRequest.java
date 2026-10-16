package cz.mobilesoft.coreblock.rest.request;

import com.google.gson.annotations.SerializedName;
import java.util.Set;
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
public final class IntroQuestionRequest {
    public static final int $stable = 8;

    @SerializedName("answers")
    private final Set<Integer> answers;

    @SerializedName("questionId")
    private final int questionId;

    public IntroQuestionRequest(int i3, Set<Integer> answers) {
        Intrinsics.checkNotNullParameter(answers, "answers");
        this.questionId = i3;
        this.answers = answers;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ IntroQuestionRequest copy$default(IntroQuestionRequest introQuestionRequest, int i3, Set set, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i3 = introQuestionRequest.questionId;
        }
        if ((i4 & 2) != 0) {
            set = introQuestionRequest.answers;
        }
        return introQuestionRequest.copy(i3, set);
    }

    public final int component1() {
        return this.questionId;
    }

    public final Set<Integer> component2() {
        return this.answers;
    }

    public final IntroQuestionRequest copy(int i3, Set<Integer> answers) {
        Intrinsics.checkNotNullParameter(answers, "answers");
        return new IntroQuestionRequest(i3, answers);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof IntroQuestionRequest)) {
            return false;
        }
        IntroQuestionRequest introQuestionRequest = (IntroQuestionRequest) obj;
        return this.questionId == introQuestionRequest.questionId && Intrinsics.areEqual(this.answers, introQuestionRequest.answers);
    }

    public final Set<Integer> getAnswers() {
        return this.answers;
    }

    public final int getQuestionId() {
        return this.questionId;
    }

    public int hashCode() {
        return (Integer.hashCode(this.questionId) * 31) + this.answers.hashCode();
    }

    public String toString() {
        return "IntroQuestionRequest(questionId=" + this.questionId + ", answers=" + this.answers + ")";
    }
}
