package cz.mobilesoft.coreblock.storage.room.entity.core;

import cz.mobilesoft.coreblock.scene.more.academy.AcademyCourseState;
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
public final class AcademyCourseEntity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f126525a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f126526b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f126527c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f126528d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f126529e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private AcademyCourseState f126530f;

    public AcademyCourseEntity(long j3, int i3, String title, String lead, String iconUrl, AcademyCourseState courseState) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(lead, "lead");
        Intrinsics.checkNotNullParameter(iconUrl, "iconUrl");
        Intrinsics.checkNotNullParameter(courseState, "courseState");
        this.f126525a = j3;
        this.f126526b = i3;
        this.f126527c = title;
        this.f126528d = lead;
        this.f126529e = iconUrl;
        this.f126530f = courseState;
    }

    public final AcademyCourseState a() {
        return this.f126530f;
    }

    public final String b() {
        return this.f126529e;
    }

    public final long c() {
        return this.f126525a;
    }

    public final String d() {
        return this.f126528d;
    }

    public final int e() {
        return this.f126526b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AcademyCourseEntity)) {
            return false;
        }
        AcademyCourseEntity academyCourseEntity = (AcademyCourseEntity) obj;
        return this.f126525a == academyCourseEntity.f126525a && this.f126526b == academyCourseEntity.f126526b && Intrinsics.areEqual(this.f126527c, academyCourseEntity.f126527c) && Intrinsics.areEqual(this.f126528d, academyCourseEntity.f126528d) && Intrinsics.areEqual(this.f126529e, academyCourseEntity.f126529e) && this.f126530f == academyCourseEntity.f126530f;
    }

    public final String f() {
        return this.f126527c;
    }

    public final void g(AcademyCourseState academyCourseState) {
        Intrinsics.checkNotNullParameter(academyCourseState, "<set-?>");
        this.f126530f = academyCourseState;
    }

    public final void h(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f126529e = str;
    }

    public int hashCode() {
        return (((((((((Long.hashCode(this.f126525a) * 31) + Integer.hashCode(this.f126526b)) * 31) + this.f126527c.hashCode()) * 31) + this.f126528d.hashCode()) * 31) + this.f126529e.hashCode()) * 31) + this.f126530f.hashCode();
    }

    public final void i(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f126528d = str;
    }

    public final void j(int i3) {
        this.f126526b = i3;
    }

    public final void k(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f126527c = str;
    }

    public String toString() {
        return "AcademyCourseEntity(id=" + this.f126525a + ", order=" + this.f126526b + ", title=" + this.f126527c + ", lead=" + this.f126528d + ", iconUrl=" + this.f126529e + ", courseState=" + this.f126530f + ")";
    }
}
