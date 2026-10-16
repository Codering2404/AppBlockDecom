package cz.mobilesoft.coreblock.scene.more.settings.developer;

import java.util.List;
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
public final class DeveloperSettingsCategory {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f108268g = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f108269a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f108270b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Integer f108271c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final List f108272d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f108273e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f108274f;

    public DeveloperSettingsCategory(String id, String title, Integer num, List items, boolean z2, boolean z3) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(items, "items");
        this.f108269a = id;
        this.f108270b = title;
        this.f108271c = num;
        this.f108272d = items;
        this.f108273e = z2;
        this.f108274f = z3;
    }

    public static /* synthetic */ DeveloperSettingsCategory b(DeveloperSettingsCategory developerSettingsCategory, String str, String str2, Integer num, List list, boolean z2, boolean z3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = developerSettingsCategory.f108269a;
        }
        if ((i3 & 2) != 0) {
            str2 = developerSettingsCategory.f108270b;
        }
        if ((i3 & 4) != 0) {
            num = developerSettingsCategory.f108271c;
        }
        if ((i3 & 8) != 0) {
            list = developerSettingsCategory.f108272d;
        }
        if ((i3 & 16) != 0) {
            z2 = developerSettingsCategory.f108273e;
        }
        if ((i3 & 32) != 0) {
            z3 = developerSettingsCategory.f108274f;
        }
        boolean z4 = z2;
        boolean z5 = z3;
        return developerSettingsCategory.a(str, str2, num, list, z4, z5);
    }

    public final DeveloperSettingsCategory a(String id, String title, Integer num, List items, boolean z2, boolean z3) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(items, "items");
        return new DeveloperSettingsCategory(id, title, num, items, z2, z3);
    }

    public final Integer c() {
        return this.f108271c;
    }

    public final String d() {
        return this.f108269a;
    }

    public final List e() {
        return this.f108272d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DeveloperSettingsCategory)) {
            return false;
        }
        DeveloperSettingsCategory developerSettingsCategory = (DeveloperSettingsCategory) obj;
        return Intrinsics.areEqual(this.f108269a, developerSettingsCategory.f108269a) && Intrinsics.areEqual(this.f108270b, developerSettingsCategory.f108270b) && Intrinsics.areEqual(this.f108271c, developerSettingsCategory.f108271c) && Intrinsics.areEqual(this.f108272d, developerSettingsCategory.f108272d) && this.f108273e == developerSettingsCategory.f108273e && this.f108274f == developerSettingsCategory.f108274f;
    }

    public final String f() {
        return this.f108270b;
    }

    public int hashCode() {
        int iHashCode = ((this.f108269a.hashCode() * 31) + this.f108270b.hashCode()) * 31;
        Integer num = this.f108271c;
        return ((((((iHashCode + (num == null ? 0 : num.hashCode())) * 31) + this.f108272d.hashCode()) * 31) + Boolean.hashCode(this.f108273e)) * 31) + Boolean.hashCode(this.f108274f);
    }

    public String toString() {
        return "DeveloperSettingsCategory(id=" + this.f108269a + ", title=" + this.f108270b + ", iconRes=" + this.f108271c + ", items=" + this.f108272d + ", isExpanded=" + this.f108273e + ", isFiltered=" + this.f108274f + ")";
    }

    public /* synthetic */ DeveloperSettingsCategory(String str, String str2, Integer num, List list, boolean z2, boolean z3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i3 & 4) != 0 ? null : num, list, (i3 & 16) != 0 ? false : z2, (i3 & 32) != 0 ? false : z3);
    }
}
