package cz.mobilesoft.coreblock.storage.room.entity.core;

import cz.mobilesoft.coreblock.scene.more.academy.AcademyLessonState;
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
public final class AcademyLessonEntity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f126531a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f126532b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f126533c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f126534d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f126535e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f126536f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f126537g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f126538h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private AcademyLessonState f126539i;

    public AcademyLessonEntity(long j3, long j4, int i3, String title, String lead, String body, long j5, long j6, AcademyLessonState lessonState) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(lead, "lead");
        Intrinsics.checkNotNullParameter(body, "body");
        Intrinsics.checkNotNullParameter(lessonState, "lessonState");
        this.f126531a = j3;
        this.f126532b = j4;
        this.f126533c = i3;
        this.f126534d = title;
        this.f126535e = lead;
        this.f126536f = body;
        this.f126537g = j5;
        this.f126538h = j6;
        this.f126539i = lessonState;
    }

    public final String a() {
        return this.f126536f;
    }

    public final long b() {
        return this.f126532b;
    }

    public final long c() {
        return this.f126538h;
    }

    public final long d() {
        return this.f126531a;
    }

    public final String e() {
        return this.f126535e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AcademyLessonEntity)) {
            return false;
        }
        AcademyLessonEntity academyLessonEntity = (AcademyLessonEntity) obj;
        return this.f126531a == academyLessonEntity.f126531a && this.f126532b == academyLessonEntity.f126532b && this.f126533c == academyLessonEntity.f126533c && Intrinsics.areEqual(this.f126534d, academyLessonEntity.f126534d) && Intrinsics.areEqual(this.f126535e, academyLessonEntity.f126535e) && Intrinsics.areEqual(this.f126536f, academyLessonEntity.f126536f) && this.f126537g == academyLessonEntity.f126537g && this.f126538h == academyLessonEntity.f126538h && this.f126539i == academyLessonEntity.f126539i;
    }

    public final AcademyLessonState f() {
        return this.f126539i;
    }

    public final int g() {
        return this.f126533c;
    }

    public final String h() {
        return this.f126534d;
    }

    public int hashCode() {
        return (((((((((((((((Long.hashCode(this.f126531a) * 31) + Long.hashCode(this.f126532b)) * 31) + Integer.hashCode(this.f126533c)) * 31) + this.f126534d.hashCode()) * 31) + this.f126535e.hashCode()) * 31) + this.f126536f.hashCode()) * 31) + Long.hashCode(this.f126537g)) * 31) + Long.hashCode(this.f126538h)) * 31) + this.f126539i.hashCode();
    }

    public final long i() {
        return this.f126537g;
    }

    public final void j(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f126536f = str;
    }

    public final void k(long j3) {
        this.f126538h = j3;
    }

    public final void l(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f126535e = str;
    }

    public final void m(AcademyLessonState academyLessonState) {
        Intrinsics.checkNotNullParameter(academyLessonState, "<set-?>");
        this.f126539i = academyLessonState;
    }

    public final void n(int i3) {
        this.f126533c = i3;
    }

    public final void o(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f126534d = str;
    }

    public final void p(long j3) {
        this.f126537g = j3;
    }

    public String toString() {
        return "AcademyLessonEntity(id=" + this.f126531a + ", courseId=" + this.f126532b + ", order=" + this.f126533c + ", title=" + this.f126534d + ", lead=" + this.f126535e + ", body=" + this.f126536f + ", unlockedAt=" + this.f126537g + ", finishedAt=" + this.f126538h + ", lessonState=" + this.f126539i + ")";
    }
}
