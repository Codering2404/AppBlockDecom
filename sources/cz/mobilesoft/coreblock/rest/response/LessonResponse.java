package cz.mobilesoft.coreblock.rest.response;

import com.google.gson.annotations.SerializedName;
import cz.mobilesoft.coreblock.scene.more.academy.AcademyLessonState;
import cz.mobilesoft.coreblock.storage.room.entity.core.AcademyLessonEntity;
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
public final class LessonResponse {
    public static final int $stable = 0;

    @SerializedName("body")
    private final String body;

    @SerializedName("id")
    private final long id;

    @SerializedName("lead")
    private final String lead;

    @SerializedName("order")
    private final Integer order;

    @SerializedName("title")
    private final String title;

    public LessonResponse(long j3, Integer num, String str, String str2, String str3) {
        this.id = j3;
        this.order = num;
        this.title = str;
        this.lead = str2;
        this.body = str3;
    }

    public static /* synthetic */ LessonResponse copy$default(LessonResponse lessonResponse, long j3, Integer num, String str, String str2, String str3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            j3 = lessonResponse.id;
        }
        long j4 = j3;
        if ((i3 & 2) != 0) {
            num = lessonResponse.order;
        }
        Integer num2 = num;
        if ((i3 & 4) != 0) {
            str = lessonResponse.title;
        }
        String str4 = str;
        if ((i3 & 8) != 0) {
            str2 = lessonResponse.lead;
        }
        String str5 = str2;
        if ((i3 & 16) != 0) {
            str3 = lessonResponse.body;
        }
        return lessonResponse.copy(j4, num2, str4, str5, str3);
    }

    public final long component1() {
        return this.id;
    }

    public final Integer component2() {
        return this.order;
    }

    public final String component3() {
        return this.title;
    }

    public final String component4() {
        return this.lead;
    }

    public final String component5() {
        return this.body;
    }

    public final LessonResponse copy(long j3, Integer num, String str, String str2, String str3) {
        return new LessonResponse(j3, num, str, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LessonResponse)) {
            return false;
        }
        LessonResponse lessonResponse = (LessonResponse) obj;
        return this.id == lessonResponse.id && Intrinsics.areEqual(this.order, lessonResponse.order) && Intrinsics.areEqual(this.title, lessonResponse.title) && Intrinsics.areEqual(this.lead, lessonResponse.lead) && Intrinsics.areEqual(this.body, lessonResponse.body);
    }

    public final String getBody() {
        return this.body;
    }

    public final long getId() {
        return this.id;
    }

    public final String getLead() {
        return this.lead;
    }

    public final Integer getOrder() {
        return this.order;
    }

    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        int iHashCode = Long.hashCode(this.id) * 31;
        Integer num = this.order;
        int iHashCode2 = (iHashCode + (num == null ? 0 : num.hashCode())) * 31;
        String str = this.title;
        int iHashCode3 = (iHashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.lead;
        int iHashCode4 = (iHashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.body;
        return iHashCode4 + (str3 != null ? str3.hashCode() : 0);
    }

    public final AcademyLessonEntity toAcademyLesson(long j3) {
        long j4 = this.id;
        Integer num = this.order;
        int iIntValue = num != null ? num.intValue() : 0;
        String str = this.title;
        String str2 = str == null ? "" : str;
        String str3 = this.lead;
        String str4 = str3 == null ? "" : str3;
        String str5 = this.body;
        return new AcademyLessonEntity(j4, j3, iIntValue, str2, str4, str5 == null ? "" : str5, 0L, 0L, AcademyLessonState.AVAILABLE);
    }

    public String toString() {
        return "LessonResponse(id=" + this.id + ", order=" + this.order + ", title=" + this.title + ", lead=" + this.lead + ", body=" + this.body + ")";
    }

    public final void updateTo(AcademyLessonEntity dbLesson) {
        Intrinsics.checkNotNullParameter(dbLesson, "dbLesson");
        Integer num = this.order;
        dbLesson.n(num != null ? num.intValue() : dbLesson.g());
        String strH = this.title;
        if (strH == null) {
            strH = dbLesson.h();
        }
        dbLesson.o(strH);
        String strE = this.lead;
        if (strE == null) {
            strE = dbLesson.e();
        }
        dbLesson.l(strE);
        String strA = this.body;
        if (strA == null) {
            strA = dbLesson.a();
        }
        dbLesson.j(strA);
    }
}
