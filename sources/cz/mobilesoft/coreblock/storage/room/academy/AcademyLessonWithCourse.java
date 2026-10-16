package cz.mobilesoft.coreblock.storage.room.academy;

import cz.mobilesoft.coreblock.storage.room.entity.core.AcademyCourseEntity;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class AcademyLessonWithCourse {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AcademyLessonEntity f124812a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AcademyCourseEntity f124813b;

    public AcademyLessonWithCourse(AcademyLessonEntity lesson, AcademyCourseEntity course) {
        Intrinsics.checkNotNullParameter(lesson, "lesson");
        Intrinsics.checkNotNullParameter(course, "course");
        this.f124812a = lesson;
        this.f124813b = course;
    }

    public final AcademyCourseEntity a() {
        return this.f124813b;
    }

    public final AcademyLessonEntity b() {
        return this.f124812a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AcademyLessonWithCourse)) {
            return false;
        }
        AcademyLessonWithCourse academyLessonWithCourse = (AcademyLessonWithCourse) obj;
        return Intrinsics.areEqual(this.f124812a, academyLessonWithCourse.f124812a) && Intrinsics.areEqual(this.f124813b, academyLessonWithCourse.f124813b);
    }

    public int hashCode() {
        return (this.f124812a.hashCode() * 31) + this.f124813b.hashCode();
    }

    public String toString() {
        return "AcademyLessonWithCourse(lesson=" + this.f124812a + ", course=" + this.f124813b + ")";
    }
}
