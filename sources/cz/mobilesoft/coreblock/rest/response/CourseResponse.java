package cz.mobilesoft.coreblock.rest.response;

import com.google.gson.annotations.SerializedName;
import cz.mobilesoft.coreblock.scene.more.academy.AcademyCourseState;
import cz.mobilesoft.coreblock.storage.room.entity.core.AcademyCourseEntity;
import java.util.List;
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
public final class CourseResponse {
    public static final int $stable = 8;

    @SerializedName("icon")
    private final String iconUrl;

    @SerializedName("id")
    private final long id;

    @SerializedName("lead")
    private final String lead;

    @SerializedName("lessons")
    private final List<LessonResponse> lessons;

    @SerializedName("order")
    private final Integer order;

    @SerializedName("title")
    private final String title;

    public CourseResponse(long j3, Integer num, String str, String str2, String str3, List<LessonResponse> list) {
        this.id = j3;
        this.order = num;
        this.title = str;
        this.lead = str2;
        this.iconUrl = str3;
        this.lessons = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CourseResponse copy$default(CourseResponse courseResponse, long j3, Integer num, String str, String str2, String str3, List list, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            j3 = courseResponse.id;
        }
        long j4 = j3;
        if ((i3 & 2) != 0) {
            num = courseResponse.order;
        }
        Integer num2 = num;
        if ((i3 & 4) != 0) {
            str = courseResponse.title;
        }
        String str4 = str;
        if ((i3 & 8) != 0) {
            str2 = courseResponse.lead;
        }
        String str5 = str2;
        if ((i3 & 16) != 0) {
            str3 = courseResponse.iconUrl;
        }
        String str6 = str3;
        if ((i3 & 32) != 0) {
            list = courseResponse.lessons;
        }
        return courseResponse.copy(j4, num2, str4, str5, str6, list);
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
        return this.iconUrl;
    }

    public final List<LessonResponse> component6() {
        return this.lessons;
    }

    public final CourseResponse copy(long j3, Integer num, String str, String str2, String str3, List<LessonResponse> list) {
        return new CourseResponse(j3, num, str, str2, str3, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CourseResponse)) {
            return false;
        }
        CourseResponse courseResponse = (CourseResponse) obj;
        return this.id == courseResponse.id && Intrinsics.areEqual(this.order, courseResponse.order) && Intrinsics.areEqual(this.title, courseResponse.title) && Intrinsics.areEqual(this.lead, courseResponse.lead) && Intrinsics.areEqual(this.iconUrl, courseResponse.iconUrl) && Intrinsics.areEqual(this.lessons, courseResponse.lessons);
    }

    public final String getIconUrl() {
        return this.iconUrl;
    }

    public final long getId() {
        return this.id;
    }

    public final String getLead() {
        return this.lead;
    }

    public final List<LessonResponse> getLessons() {
        return this.lessons;
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
        String str3 = this.iconUrl;
        int iHashCode5 = (iHashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        List<LessonResponse> list = this.lessons;
        return iHashCode5 + (list != null ? list.hashCode() : 0);
    }

    public final AcademyCourseEntity toAcademyCourse() {
        long j3 = this.id;
        Integer num = this.order;
        int iIntValue = num != null ? num.intValue() : 0;
        String str = this.title;
        if (str == null) {
            str = "";
        }
        String str2 = this.lead;
        if (str2 == null) {
            str2 = "";
        }
        String str3 = this.iconUrl;
        return new AcademyCourseEntity(j3, iIntValue, str, str2, str3 != null ? str3 : "", AcademyCourseState.AVAILABLE);
    }

    public String toString() {
        return "CourseResponse(id=" + this.id + ", order=" + this.order + ", title=" + this.title + ", lead=" + this.lead + ", iconUrl=" + this.iconUrl + ", lessons=" + this.lessons + ")";
    }

    public final void updateTo(AcademyCourseEntity dbCourse) {
        Intrinsics.checkNotNullParameter(dbCourse, "dbCourse");
        Integer num = this.order;
        dbCourse.j(num != null ? num.intValue() : dbCourse.e());
        String strF = this.title;
        if (strF == null) {
            strF = dbCourse.f();
        }
        dbCourse.k(strF);
        String strD = this.lead;
        if (strD == null) {
            strD = dbCourse.d();
        }
        dbCourse.i(strD);
        String strB = this.iconUrl;
        if (strB == null) {
            strB = dbCourse.b();
        }
        dbCourse.h(strB);
    }
}
