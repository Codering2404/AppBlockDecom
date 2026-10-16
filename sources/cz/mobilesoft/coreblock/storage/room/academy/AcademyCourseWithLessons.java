package cz.mobilesoft.coreblock.storage.room.academy;

import cz.mobilesoft.coreblock.storage.room.entity.core.AcademyCourseEntity;
import cz.mobilesoft.coreblock.storage.room.entity.core.AcademyLessonEntity;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
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
public final class AcademyCourseWithLessons {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AcademyCourseEntity f124810a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List f124811b;

    public AcademyCourseWithLessons(AcademyCourseEntity course, List lessons) {
        Intrinsics.checkNotNullParameter(course, "course");
        Intrinsics.checkNotNullParameter(lessons, "lessons");
        this.f124810a = course;
        this.f124811b = lessons;
    }

    public final AcademyCourseEntity a() {
        return this.f124810a;
    }

    public final List b() {
        return this.f124811b;
    }

    public final List c() {
        return CollectionsKt.sortedWith(this.f124811b, new Comparator() { // from class: cz.mobilesoft.coreblock.storage.room.academy.AcademyCourseWithLessons$special$$inlined$sortedBy$1
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return ComparisonsKt.d(Integer.valueOf(((AcademyLessonEntity) obj).g()), Integer.valueOf(((AcademyLessonEntity) obj2).g()));
            }
        });
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AcademyCourseWithLessons)) {
            return false;
        }
        AcademyCourseWithLessons academyCourseWithLessons = (AcademyCourseWithLessons) obj;
        return Intrinsics.areEqual(this.f124810a, academyCourseWithLessons.f124810a) && Intrinsics.areEqual(this.f124811b, academyCourseWithLessons.f124811b);
    }

    public int hashCode() {
        return (this.f124810a.hashCode() * 31) + this.f124811b.hashCode();
    }

    public String toString() {
        return "AcademyCourseWithLessons(course=" + this.f124810a + ", lessons=" + this.f124811b + ")";
    }
}
