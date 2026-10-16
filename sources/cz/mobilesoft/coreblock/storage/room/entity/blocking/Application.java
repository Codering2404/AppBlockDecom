package cz.mobilesoft.coreblock.storage.room.entity.blocking;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.comparisons.xn.YvFRmou;
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
public final class Application implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f126386a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f126387b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f126388c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f126389d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Integer f126390f;

    public Application(String packageName, String label, String labelForSearch, boolean z2, Integer num) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        Intrinsics.checkNotNullParameter(label, "label");
        Intrinsics.checkNotNullParameter(labelForSearch, "labelForSearch");
        this.f126386a = packageName;
        this.f126387b = label;
        this.f126388c = labelForSearch;
        this.f126389d = z2;
        this.f126390f = num;
    }

    public final Integer a() {
        return this.f126390f;
    }

    public final String b() {
        return this.f126387b;
    }

    public final String c() {
        return this.f126388c;
    }

    public final String d() {
        return this.f126386a;
    }

    public final boolean e() {
        return this.f126389d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Application)) {
            return false;
        }
        Application application = (Application) obj;
        return Intrinsics.areEqual(this.f126386a, application.f126386a) && Intrinsics.areEqual(this.f126387b, application.f126387b) && Intrinsics.areEqual(this.f126388c, application.f126388c) && this.f126389d == application.f126389d && Intrinsics.areEqual(this.f126390f, application.f126390f);
    }

    public int hashCode() {
        int iHashCode = ((((((this.f126386a.hashCode() * 31) + this.f126387b.hashCode()) * 31) + this.f126388c.hashCode()) * 31) + Boolean.hashCode(this.f126389d)) * 31;
        Integer num = this.f126390f;
        return iHashCode + (num == null ? 0 : num.hashCode());
    }

    public String toString() {
        return "Application(packageName=" + this.f126386a + ", label=" + this.f126387b + ", labelForSearch=" + this.f126388c + YvFRmou.VmFS + this.f126389d + ", appCategories=" + this.f126390f + ")";
    }

    public /* synthetic */ Application(String str, String str2, String str3, boolean z2, Integer num, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, (i3 & 8) != 0 ? false : z2, (i3 & 16) != 0 ? null : num);
    }
}
