package cz.mobilesoft.coreblock.scene.more.changelog;

import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
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
public final class ChangelogFeature {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f106924a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List f106925b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Integer f106926c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f106927d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final List f106928e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Integer f106929f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final ChangelogClickAction f106930g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Integer f106931h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final ChangelogClickAction f106932i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final ChangelogClickAction f106933j;

    public ChangelogFeature(int i3, List list, Integer num, int i4, List list2, Integer num2, ChangelogClickAction changelogClickAction, Integer num3, ChangelogClickAction changelogClickAction2, ChangelogClickAction changelogClickAction3) {
        this.f106924a = i3;
        this.f106925b = list;
        this.f106926c = num;
        this.f106927d = i4;
        this.f106928e = list2;
        this.f106929f = num2;
        this.f106930g = changelogClickAction;
        this.f106931h = num3;
        this.f106932i = changelogClickAction2;
        this.f106933j = changelogClickAction3;
    }

    public final ChangelogClickAction a() {
        return this.f106930g;
    }

    public final Integer b() {
        return this.f106929f;
    }

    public final Integer c() {
        return this.f106926c;
    }

    public final List d() {
        return this.f106925b;
    }

    public final ChangelogClickAction e() {
        return this.f106933j;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ChangelogFeature)) {
            return false;
        }
        ChangelogFeature changelogFeature = (ChangelogFeature) obj;
        return this.f106924a == changelogFeature.f106924a && Intrinsics.areEqual(this.f106925b, changelogFeature.f106925b) && Intrinsics.areEqual(this.f106926c, changelogFeature.f106926c) && this.f106927d == changelogFeature.f106927d && Intrinsics.areEqual(this.f106928e, changelogFeature.f106928e) && Intrinsics.areEqual(this.f106929f, changelogFeature.f106929f) && Intrinsics.areEqual(this.f106930g, changelogFeature.f106930g) && Intrinsics.areEqual(this.f106931h, changelogFeature.f106931h) && Intrinsics.areEqual(this.f106932i, changelogFeature.f106932i) && Intrinsics.areEqual(this.f106933j, changelogFeature.f106933j);
    }

    public final ChangelogClickAction f() {
        return this.f106932i;
    }

    public final Integer g() {
        return this.f106931h;
    }

    public final int h() {
        return this.f106927d;
    }

    public int hashCode() {
        int iHashCode = Integer.hashCode(this.f106924a) * 31;
        List list = this.f106925b;
        int iHashCode2 = (iHashCode + (list == null ? 0 : list.hashCode())) * 31;
        Integer num = this.f106926c;
        int iHashCode3 = (((iHashCode2 + (num == null ? 0 : num.hashCode())) * 31) + Integer.hashCode(this.f106927d)) * 31;
        List list2 = this.f106928e;
        int iHashCode4 = (iHashCode3 + (list2 == null ? 0 : list2.hashCode())) * 31;
        Integer num2 = this.f106929f;
        int iHashCode5 = (iHashCode4 + (num2 == null ? 0 : num2.hashCode())) * 31;
        ChangelogClickAction changelogClickAction = this.f106930g;
        int iHashCode6 = (iHashCode5 + (changelogClickAction == null ? 0 : changelogClickAction.hashCode())) * 31;
        Integer num3 = this.f106931h;
        int iHashCode7 = (iHashCode6 + (num3 == null ? 0 : num3.hashCode())) * 31;
        ChangelogClickAction changelogClickAction2 = this.f106932i;
        int iHashCode8 = (iHashCode7 + (changelogClickAction2 == null ? 0 : changelogClickAction2.hashCode())) * 31;
        ChangelogClickAction changelogClickAction3 = this.f106933j;
        return iHashCode8 + (changelogClickAction3 != null ? changelogClickAction3.hashCode() : 0);
    }

    public final List i() {
        return this.f106928e;
    }

    public final int j() {
        return this.f106924a;
    }

    public String toString() {
        return "ChangelogFeature(title=" + this.f106924a + ", labels=" + this.f106925b + ", image=" + this.f106926c + ", text=" + this.f106927d + ", textPlaceholders=" + this.f106928e + ", freeUsersButtonText=" + this.f106929f + ", freeUsersButtonAction=" + this.f106930g + ", payingUsersButtonText=" + this.f106931h + ", payingUsersButtonAction=" + this.f106932i + ", oldPremiumAction=" + this.f106933j + ")";
    }

    public /* synthetic */ ChangelogFeature(int i3, List list, Integer num, int i4, List list2, Integer num2, ChangelogClickAction changelogClickAction, Integer num3, ChangelogClickAction changelogClickAction2, ChangelogClickAction changelogClickAction3, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, (i5 & 2) != 0 ? null : list, (i5 & 4) != 0 ? null : num, i4, (i5 & 16) != 0 ? null : list2, (i5 & 32) != 0 ? null : num2, (i5 & 64) != 0 ? null : changelogClickAction, (i5 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? null : num3, (i5 & Function.MAX_NARGS) != 0 ? null : changelogClickAction2, (i5 & 512) != 0 ? null : changelogClickAction3);
    }
}
