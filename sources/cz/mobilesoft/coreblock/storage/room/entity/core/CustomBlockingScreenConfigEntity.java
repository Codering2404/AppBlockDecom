package cz.mobilesoft.coreblock.storage.room.entity.core;

import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.enums.ScheduleEmoji;
import cz.mobilesoft.coreblock.scene.more.backup.dto.BlockScreenConfigDTO;
import java.io.Serializable;
import java.util.UUID;
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
public final class CustomBlockingScreenConfigEntity implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f126549a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ConfigType f126550b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f126551c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f126552d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f126553f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f126554g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f126555h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final String f126556i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final String f126557j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final String f126558k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final String f126559l;

    public CustomBlockingScreenConfigEntity(String id, ConfigType type, String blockingScreenMessage, boolean z2, int i3, boolean z3, int i4, String customTitle, String customSubtitle, String customExitButtonText, String customColorHex) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(blockingScreenMessage, "blockingScreenMessage");
        Intrinsics.checkNotNullParameter(customTitle, "customTitle");
        Intrinsics.checkNotNullParameter(customSubtitle, "customSubtitle");
        Intrinsics.checkNotNullParameter(customExitButtonText, "customExitButtonText");
        Intrinsics.checkNotNullParameter(customColorHex, "customColorHex");
        this.f126549a = id;
        this.f126550b = type;
        this.f126551c = blockingScreenMessage;
        this.f126552d = z2;
        this.f126553f = i3;
        this.f126554g = z3;
        this.f126555h = i4;
        this.f126556i = customTitle;
        this.f126557j = customSubtitle;
        this.f126558k = customExitButtonText;
        this.f126559l = customColorHex;
    }

    public static /* synthetic */ CustomBlockingScreenConfigEntity b(CustomBlockingScreenConfigEntity customBlockingScreenConfigEntity, String str, ConfigType configType, String str2, boolean z2, int i3, boolean z3, int i4, String str3, String str4, String str5, String str6, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            str = customBlockingScreenConfigEntity.f126549a;
        }
        if ((i5 & 2) != 0) {
            configType = customBlockingScreenConfigEntity.f126550b;
        }
        if ((i5 & 4) != 0) {
            str2 = customBlockingScreenConfigEntity.f126551c;
        }
        if ((i5 & 8) != 0) {
            z2 = customBlockingScreenConfigEntity.f126552d;
        }
        if ((i5 & 16) != 0) {
            i3 = customBlockingScreenConfigEntity.f126553f;
        }
        if ((i5 & 32) != 0) {
            z3 = customBlockingScreenConfigEntity.f126554g;
        }
        if ((i5 & 64) != 0) {
            i4 = customBlockingScreenConfigEntity.f126555h;
        }
        if ((i5 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0) {
            str3 = customBlockingScreenConfigEntity.f126556i;
        }
        if ((i5 & Function.MAX_NARGS) != 0) {
            str4 = customBlockingScreenConfigEntity.f126557j;
        }
        if ((i5 & 512) != 0) {
            str5 = customBlockingScreenConfigEntity.f126558k;
        }
        if ((i5 & 1024) != 0) {
            str6 = customBlockingScreenConfigEntity.f126559l;
        }
        String str7 = str5;
        String str8 = str6;
        String str9 = str3;
        String str10 = str4;
        boolean z4 = z3;
        int i6 = i4;
        int i7 = i3;
        String str11 = str2;
        return customBlockingScreenConfigEntity.a(str, configType, str11, z2, i7, z4, i6, str9, str10, str7, str8);
    }

    public final CustomBlockingScreenConfigEntity a(String id, ConfigType type, String blockingScreenMessage, boolean z2, int i3, boolean z3, int i4, String customTitle, String customSubtitle, String customExitButtonText, String customColorHex) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(blockingScreenMessage, "blockingScreenMessage");
        Intrinsics.checkNotNullParameter(customTitle, "customTitle");
        Intrinsics.checkNotNullParameter(customSubtitle, "customSubtitle");
        Intrinsics.checkNotNullParameter(customExitButtonText, "customExitButtonText");
        Intrinsics.checkNotNullParameter(customColorHex, "customColorHex");
        return new CustomBlockingScreenConfigEntity(id, type, blockingScreenMessage, z2, i3, z3, i4, customTitle, customSubtitle, customExitButtonText, customColorHex);
    }

    public final String c() {
        return this.f126551c;
    }

    public final String d() {
        return this.f126559l;
    }

    public final String e() {
        return this.f126558k;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CustomBlockingScreenConfigEntity)) {
            return false;
        }
        CustomBlockingScreenConfigEntity customBlockingScreenConfigEntity = (CustomBlockingScreenConfigEntity) obj;
        return Intrinsics.areEqual(this.f126549a, customBlockingScreenConfigEntity.f126549a) && this.f126550b == customBlockingScreenConfigEntity.f126550b && Intrinsics.areEqual(this.f126551c, customBlockingScreenConfigEntity.f126551c) && this.f126552d == customBlockingScreenConfigEntity.f126552d && this.f126553f == customBlockingScreenConfigEntity.f126553f && this.f126554g == customBlockingScreenConfigEntity.f126554g && this.f126555h == customBlockingScreenConfigEntity.f126555h && Intrinsics.areEqual(this.f126556i, customBlockingScreenConfigEntity.f126556i) && Intrinsics.areEqual(this.f126557j, customBlockingScreenConfigEntity.f126557j) && Intrinsics.areEqual(this.f126558k, customBlockingScreenConfigEntity.f126558k) && Intrinsics.areEqual(this.f126559l, customBlockingScreenConfigEntity.f126559l);
    }

    public final String f() {
        return this.f126557j;
    }

    public final String g() {
        return this.f126556i;
    }

    public final int h() {
        return this.f126555h;
    }

    public int hashCode() {
        return (((((((((((((((((((this.f126549a.hashCode() * 31) + this.f126550b.hashCode()) * 31) + this.f126551c.hashCode()) * 31) + Boolean.hashCode(this.f126552d)) * 31) + Integer.hashCode(this.f126553f)) * 31) + Boolean.hashCode(this.f126554g)) * 31) + Integer.hashCode(this.f126555h)) * 31) + this.f126556i.hashCode()) * 31) + this.f126557j.hashCode()) * 31) + this.f126558k.hashCode()) * 31) + this.f126559l.hashCode();
    }

    public final String i() {
        return this.f126549a;
    }

    public final boolean j() {
        return this.f126552d;
    }

    public final boolean k() {
        return this.f126554g;
    }

    public final int l() {
        return this.f126553f;
    }

    public final ConfigType m() {
        return this.f126550b;
    }

    public final BlockScreenConfigDTO n() {
        return new BlockScreenConfigDTO(this.f126550b.ordinal(), this.f126549a, this.f126554g, this.f126552d, this.f126557j, Integer.valueOf(this.f126555h), this.f126559l, this.f126556i, this.f126558k, null, Integer.valueOf(this.f126553f));
    }

    public String toString() {
        return "CustomBlockingScreenConfigEntity(id=" + this.f126549a + ", type=" + this.f126550b + ", blockingScreenMessage=" + this.f126551c + ", showBlockingReason=" + this.f126552d + ", timeout=" + this.f126553f + ", showCounter=" + this.f126554g + ", iconId=" + this.f126555h + ", customTitle=" + this.f126556i + ", customSubtitle=" + this.f126557j + ", customExitButtonText=" + this.f126558k + ", customColorHex=" + this.f126559l + ")";
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ CustomBlockingScreenConfigEntity(String str, ConfigType configType, String str2, boolean z2, int i3, boolean z3, int i4, String str3, String str4, String str5, String str6, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        String str7;
        if ((i5 & 1) != 0) {
            String string = UUID.randomUUID().toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            str7 = string;
        } else {
            str7 = str;
        }
        this(str7, configType, (i5 & 4) != 0 ? "" : str2, (i5 & 8) != 0 ? true : z2, (i5 & 16) != 0 ? 0 : i3, (i5 & 32) != 0 ? true : z3, (i5 & 64) != 0 ? ScheduleEmoji.CustomBlockingAppIcon.getId() : i4, (i5 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? "" : str3, (i5 & Function.MAX_NARGS) != 0 ? "" : str4, (i5 & 512) != 0 ? "" : str5, (i5 & 1024) != 0 ? "" : str6);
    }
}
