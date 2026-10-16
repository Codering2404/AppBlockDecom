package cz.mobilesoft.coreblock.rest.response;

import com.facebook.internal.ServerProtocol;
import com.google.gson.annotations.SerializedName;
import cz.mobilesoft.coreblock.scene.more.academy.AcademyLessonState;
import java.util.Date;
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
public final class LessonStateResponse {
    public static final int $stable = 8;

    @SerializedName("id")
    private final long id;

    @SerializedName(ServerProtocol.DIALOG_PARAM_STATE)
    private final AcademyLessonState state;

    @SerializedName("unlockedAt")
    private final Date unlockedAt;

    public LessonStateResponse(long j3, AcademyLessonState academyLessonState, Date date) {
        this.id = j3;
        this.state = academyLessonState;
        this.unlockedAt = date;
    }

    public static /* synthetic */ LessonStateResponse copy$default(LessonStateResponse lessonStateResponse, long j3, AcademyLessonState academyLessonState, Date date, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            j3 = lessonStateResponse.id;
        }
        if ((i3 & 2) != 0) {
            academyLessonState = lessonStateResponse.state;
        }
        if ((i3 & 4) != 0) {
            date = lessonStateResponse.unlockedAt;
        }
        return lessonStateResponse.copy(j3, academyLessonState, date);
    }

    public final long component1() {
        return this.id;
    }

    public final AcademyLessonState component2() {
        return this.state;
    }

    public final Date component3() {
        return this.unlockedAt;
    }

    public final LessonStateResponse copy(long j3, AcademyLessonState academyLessonState, Date date) {
        return new LessonStateResponse(j3, academyLessonState, date);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LessonStateResponse)) {
            return false;
        }
        LessonStateResponse lessonStateResponse = (LessonStateResponse) obj;
        return this.id == lessonStateResponse.id && this.state == lessonStateResponse.state && Intrinsics.areEqual(this.unlockedAt, lessonStateResponse.unlockedAt);
    }

    public final long getId() {
        return this.id;
    }

    public final AcademyLessonState getState() {
        return this.state;
    }

    public final Date getUnlockedAt() {
        return this.unlockedAt;
    }

    public int hashCode() {
        int iHashCode = Long.hashCode(this.id) * 31;
        AcademyLessonState academyLessonState = this.state;
        int iHashCode2 = (iHashCode + (academyLessonState == null ? 0 : academyLessonState.hashCode())) * 31;
        Date date = this.unlockedAt;
        return iHashCode2 + (date != null ? date.hashCode() : 0);
    }

    public String toString() {
        return "LessonStateResponse(id=" + this.id + ", state=" + this.state + ", unlockedAt=" + this.unlockedAt + ")";
    }
}
