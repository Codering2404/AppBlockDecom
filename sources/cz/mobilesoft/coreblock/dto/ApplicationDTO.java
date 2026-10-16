package cz.mobilesoft.coreblock.dto;

import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class ApplicationDTO {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f96901j = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f96902a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f96903b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f96904c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f96905d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f96906e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Integer f96907f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final String f96908g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final boolean f96909h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final List f96910i;

    public ApplicationDTO(String packageName, String label, String str, boolean z2, boolean z3, Integer num, String labelForSearch, boolean z4, List categories) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        Intrinsics.checkNotNullParameter(label, "label");
        Intrinsics.checkNotNullParameter(labelForSearch, "labelForSearch");
        Intrinsics.checkNotNullParameter(categories, "categories");
        this.f96902a = packageName;
        this.f96903b = label;
        this.f96904c = str;
        this.f96905d = z2;
        this.f96906e = z3;
        this.f96907f = num;
        this.f96908g = labelForSearch;
        this.f96909h = z4;
        this.f96910i = categories;
    }

    public static /* synthetic */ ApplicationDTO b(ApplicationDTO applicationDTO, String str, String str2, String str3, boolean z2, boolean z3, Integer num, String str4, boolean z4, List list, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = applicationDTO.f96902a;
        }
        if ((i3 & 2) != 0) {
            str2 = applicationDTO.f96903b;
        }
        if ((i3 & 4) != 0) {
            str3 = applicationDTO.f96904c;
        }
        if ((i3 & 8) != 0) {
            z2 = applicationDTO.f96905d;
        }
        if ((i3 & 16) != 0) {
            z3 = applicationDTO.f96906e;
        }
        if ((i3 & 32) != 0) {
            num = applicationDTO.f96907f;
        }
        if ((i3 & 64) != 0) {
            str4 = applicationDTO.f96908g;
        }
        if ((i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0) {
            z4 = applicationDTO.f96909h;
        }
        if ((i3 & Function.MAX_NARGS) != 0) {
            list = applicationDTO.f96910i;
        }
        boolean z5 = z4;
        List list2 = list;
        Integer num2 = num;
        String str5 = str4;
        boolean z6 = z3;
        String str6 = str3;
        return applicationDTO.a(str, str2, str6, z2, z6, num2, str5, z5, list2);
    }

    public final ApplicationDTO a(String packageName, String label, String str, boolean z2, boolean z3, Integer num, String labelForSearch, boolean z4, List categories) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        Intrinsics.checkNotNullParameter(label, "label");
        Intrinsics.checkNotNullParameter(labelForSearch, "labelForSearch");
        Intrinsics.checkNotNullParameter(categories, "categories");
        return new ApplicationDTO(packageName, label, str, z2, z3, num, labelForSearch, z4, categories);
    }

    public final List c() {
        return this.f96910i;
    }

    public final String d() {
        return this.f96903b;
    }

    public final String e() {
        return this.f96908g;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ApplicationDTO)) {
            return false;
        }
        ApplicationDTO applicationDTO = (ApplicationDTO) obj;
        return Intrinsics.areEqual(this.f96902a, applicationDTO.f96902a) && Intrinsics.areEqual(this.f96903b, applicationDTO.f96903b) && Intrinsics.areEqual(this.f96904c, applicationDTO.f96904c) && this.f96905d == applicationDTO.f96905d && this.f96906e == applicationDTO.f96906e && Intrinsics.areEqual(this.f96907f, applicationDTO.f96907f) && Intrinsics.areEqual(this.f96908g, applicationDTO.f96908g) && this.f96909h == applicationDTO.f96909h && Intrinsics.areEqual(this.f96910i, applicationDTO.f96910i);
    }

    public final String f() {
        return this.f96902a;
    }

    public final boolean g() {
        return this.f96906e;
    }

    public final boolean h() {
        return this.f96905d;
    }

    public int hashCode() {
        int iHashCode = ((this.f96902a.hashCode() * 31) + this.f96903b.hashCode()) * 31;
        String str = this.f96904c;
        int iHashCode2 = (((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + Boolean.hashCode(this.f96905d)) * 31) + Boolean.hashCode(this.f96906e)) * 31;
        Integer num = this.f96907f;
        return ((((((iHashCode2 + (num != null ? num.hashCode() : 0)) * 31) + this.f96908g.hashCode()) * 31) + Boolean.hashCode(this.f96909h)) * 31) + this.f96910i.hashCode();
    }

    public final boolean i() {
        return this.f96909h;
    }

    public String toString() {
        return "ApplicationDTO(packageName=" + this.f96902a + ", label=" + this.f96903b + ", subtitle=" + this.f96904c + ", isSelected=" + this.f96905d + ", isEnabled=" + this.f96906e + ", usageDuration=" + this.f96907f + ", labelForSearch=" + this.f96908g + ", isUninstalled=" + this.f96909h + ", categories=" + this.f96910i + ")";
    }

    public /* synthetic */ ApplicationDTO(String str, String str2, String str3, boolean z2, boolean z3, Integer num, String str4, boolean z4, List list, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i3 & 4) != 0 ? null : str3, z2, (i3 & 16) != 0 ? true : z3, (i3 & 32) != 0 ? null : num, (i3 & 64) != 0 ? str2 : str4, (i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? false : z4, (i3 & Function.MAX_NARGS) != 0 ? CollectionsKt.emptyList() : list);
    }
}
