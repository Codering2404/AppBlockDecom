package cz.mobilesoft.coreblock.storage.room.entity.blocking;

import java.io.Serializable;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class ApplicationProfileRelation implements Serializable {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Companion f126391g = new Companion(null);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f126392h = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f126393a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f126394b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f126395c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f126396d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f126397f;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public ApplicationProfileRelation(long j3, String packageName, long j4, boolean z2, int i3) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        this.f126393a = j3;
        this.f126394b = packageName;
        this.f126395c = j4;
        this.f126396d = z2;
        this.f126397f = i3;
    }

    public final String a() {
        return this.f126394b;
    }

    public final int b() {
        return this.f126397f;
    }

    public final long c() {
        return this.f126393a;
    }

    public final String d() {
        return this.f126394b;
    }

    public final long e() {
        return this.f126395c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ApplicationProfileRelation)) {
            return false;
        }
        ApplicationProfileRelation applicationProfileRelation = (ApplicationProfileRelation) obj;
        return this.f126393a == applicationProfileRelation.f126393a && Intrinsics.areEqual(this.f126394b, applicationProfileRelation.f126394b) && this.f126395c == applicationProfileRelation.f126395c && this.f126396d == applicationProfileRelation.f126396d && this.f126397f == applicationProfileRelation.f126397f;
    }

    public final boolean f() {
        return this.f126396d;
    }

    public final boolean g(int i3) {
        return (i3 & this.f126397f) > 0;
    }

    public final boolean h() {
        return g(1);
    }

    public int hashCode() {
        return (((((((Long.hashCode(this.f126393a) * 31) + this.f126394b.hashCode()) * 31) + Long.hashCode(this.f126395c)) * 31) + Boolean.hashCode(this.f126396d)) * 31) + Integer.hashCode(this.f126397f);
    }

    public String toString() {
        return "ApplicationProfileRelation(id=" + this.f126393a + ", packageName=" + this.f126394b + ", profileId=" + this.f126395c + ", isEnabled=" + this.f126396d + ", flags=" + this.f126397f + ")";
    }

    public /* synthetic */ ApplicationProfileRelation(long j3, String str, long j4, boolean z2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? 0L : j3, str, j4, (i4 & 8) != 0 ? true : z2, (i4 & 16) != 0 ? 0 : i3);
    }
}
