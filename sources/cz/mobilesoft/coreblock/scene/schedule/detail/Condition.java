package cz.mobilesoft.coreblock.scene.schedule.detail;

import cz.mobilesoft.coreblock.enums.ProfileType;
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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class Condition {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ProfileType f116536a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f116537b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f116538c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f116539d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f116540e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f116541f;

    public Condition(ProfileType profileType, String firstLine, String secondLine, boolean z2, boolean z3, boolean z4) {
        Intrinsics.checkNotNullParameter(profileType, "profileType");
        Intrinsics.checkNotNullParameter(firstLine, "firstLine");
        Intrinsics.checkNotNullParameter(secondLine, "secondLine");
        this.f116536a = profileType;
        this.f116537b = firstLine;
        this.f116538c = secondLine;
        this.f116539d = z2;
        this.f116540e = z3;
        this.f116541f = z4;
    }

    public final String a() {
        return this.f116537b;
    }

    public final ProfileType b() {
        return this.f116536a;
    }

    public final String c() {
        return this.f116538c;
    }

    public final boolean d() {
        return this.f116541f;
    }

    public final boolean e() {
        return this.f116540e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Condition)) {
            return false;
        }
        Condition condition = (Condition) obj;
        return this.f116536a == condition.f116536a && Intrinsics.areEqual(this.f116537b, condition.f116537b) && Intrinsics.areEqual(this.f116538c, condition.f116538c) && this.f116539d == condition.f116539d && this.f116540e == condition.f116540e && this.f116541f == condition.f116541f;
    }

    public int hashCode() {
        return (((((((((this.f116536a.hashCode() * 31) + this.f116537b.hashCode()) * 31) + this.f116538c.hashCode()) * 31) + Boolean.hashCode(this.f116539d)) * 31) + Boolean.hashCode(this.f116540e)) * 31) + Boolean.hashCode(this.f116541f);
    }

    public String toString() {
        return "Condition(profileType=" + this.f116536a + ", firstLine=" + this.f116537b + ", secondLine=" + this.f116538c + ", isEnabled=" + this.f116539d + ", isLockedForRemoving=" + this.f116540e + ", isLockedForOpening=" + this.f116541f + ")";
    }

    public /* synthetic */ Condition(ProfileType profileType, String str, String str2, boolean z2, boolean z3, boolean z4, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(profileType, str, str2, (i3 & 8) != 0 ? true : z2, (i3 & 16) != 0 ? false : z3, (i3 & 32) != 0 ? false : z4);
    }
}
