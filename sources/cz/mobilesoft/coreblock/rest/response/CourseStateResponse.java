package cz.mobilesoft.coreblock.rest.response;

import com.facebook.internal.ServerProtocol;
import com.google.gson.annotations.SerializedName;
import cz.mobilesoft.coreblock.scene.more.academy.AcademyCourseState;
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
public final class CourseStateResponse {
    public static final int $stable = 8;

    @SerializedName("id")
    private final long id;

    @SerializedName("lessons")
    private final List<LessonStateResponse> lessons;

    @SerializedName(ServerProtocol.DIALOG_PARAM_STATE)
    private final AcademyCourseState state;

    public CourseStateResponse(long j3, AcademyCourseState state, List<LessonStateResponse> lessons) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(lessons, "lessons");
        this.id = j3;
        this.state = state;
        this.lessons = lessons;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CourseStateResponse copy$default(CourseStateResponse courseStateResponse, long j3, AcademyCourseState academyCourseState, List list, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            j3 = courseStateResponse.id;
        }
        if ((i3 & 2) != 0) {
            academyCourseState = courseStateResponse.state;
        }
        if ((i3 & 4) != 0) {
            list = courseStateResponse.lessons;
        }
        return courseStateResponse.copy(j3, academyCourseState, list);
    }

    public final long component1() {
        return this.id;
    }

    public final AcademyCourseState component2() {
        return this.state;
    }

    public final List<LessonStateResponse> component3() {
        return this.lessons;
    }

    public final CourseStateResponse copy(long j3, AcademyCourseState state, List<LessonStateResponse> lessons) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(lessons, "lessons");
        return new CourseStateResponse(j3, state, lessons);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CourseStateResponse)) {
            return false;
        }
        CourseStateResponse courseStateResponse = (CourseStateResponse) obj;
        return this.id == courseStateResponse.id && this.state == courseStateResponse.state && Intrinsics.areEqual(this.lessons, courseStateResponse.lessons);
    }

    public final long getId() {
        return this.id;
    }

    public final List<LessonStateResponse> getLessons() {
        return this.lessons;
    }

    public final AcademyCourseState getState() {
        return this.state;
    }

    public int hashCode() {
        return (((Long.hashCode(this.id) * 31) + this.state.hashCode()) * 31) + this.lessons.hashCode();
    }

    public String toString() {
        return "CourseStateResponse(id=" + this.id + ", state=" + this.state + ", lessons=" + this.lessons + ")";
    }
}
