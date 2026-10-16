package cz.mobilesoft.coreblock.scene.more.settings.developer;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
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
public final class DeveloperSettingsItem {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f108278h = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f108279a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f108280b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f108281c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f108282d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f108283e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final List f108284f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final SettingsItemType f108285g;

    public DeveloperSettingsItem(String id, String title, String str, String str2, String str3, List keywords, SettingsItemType itemType) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(keywords, "keywords");
        Intrinsics.checkNotNullParameter(itemType, "itemType");
        this.f108279a = id;
        this.f108280b = title;
        this.f108281c = str;
        this.f108282d = str2;
        this.f108283e = str3;
        this.f108284f = keywords;
        this.f108285g = itemType;
    }

    public final String a() {
        return this.f108279a;
    }

    public final SettingsItemType b() {
        return this.f108285g;
    }

    public final List c() {
        return this.f108284f;
    }

    public final String d() {
        return this.f108281c;
    }

    public final String e() {
        return this.f108280b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DeveloperSettingsItem)) {
            return false;
        }
        DeveloperSettingsItem developerSettingsItem = (DeveloperSettingsItem) obj;
        return Intrinsics.areEqual(this.f108279a, developerSettingsItem.f108279a) && Intrinsics.areEqual(this.f108280b, developerSettingsItem.f108280b) && Intrinsics.areEqual(this.f108281c, developerSettingsItem.f108281c) && Intrinsics.areEqual(this.f108282d, developerSettingsItem.f108282d) && Intrinsics.areEqual(this.f108283e, developerSettingsItem.f108283e) && Intrinsics.areEqual(this.f108284f, developerSettingsItem.f108284f) && this.f108285g == developerSettingsItem.f108285g;
    }

    public int hashCode() {
        int iHashCode = ((this.f108279a.hashCode() * 31) + this.f108280b.hashCode()) * 31;
        String str = this.f108281c;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f108282d;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.f108283e;
        return ((((iHashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31) + this.f108284f.hashCode()) * 31) + this.f108285g.hashCode();
    }

    public String toString() {
        return "DeveloperSettingsItem(id=" + this.f108279a + ", title=" + this.f108280b + ", subtitle=" + this.f108281c + ", description=" + this.f108282d + ", value=" + this.f108283e + ", keywords=" + this.f108284f + ", itemType=" + this.f108285g + ")";
    }

    public /* synthetic */ DeveloperSettingsItem(String str, String str2, String str3, String str4, String str5, List list, SettingsItemType settingsItemType, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i3 & 4) != 0 ? null : str3, (i3 & 8) != 0 ? null : str4, (i3 & 16) != 0 ? null : str5, (i3 & 32) != 0 ? CollectionsKt.emptyList() : list, settingsItemType);
    }
}
