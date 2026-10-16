package cz.mobilesoft.coreblock.scene.more.changelog;

import androidx.media3.common.JBEE.bfIdKSjLOVjG;
import cz.mobilesoft.coreblock.dto.AppVersionNameDTO;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
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
public final class ChangelogVersionItem {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AppVersionNameDTO f106951a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Date f106952b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List f106953c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f106954d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f106955e;

    public ChangelogVersionItem(AppVersionNameDTO appVersionNameDTO, Date date, List features, boolean z2, boolean z3) {
        Intrinsics.checkNotNullParameter(appVersionNameDTO, bfIdKSjLOVjG.mNnHKFFkIwT);
        Intrinsics.checkNotNullParameter(features, "features");
        this.f106951a = appVersionNameDTO;
        this.f106952b = date;
        this.f106953c = features;
        this.f106954d = z2;
        this.f106955e = z3;
    }

    public final String a() {
        String str;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("LLLL yyyy", Locale.getDefault());
        Date date = this.f106952b;
        return (date == null || (str = simpleDateFormat.format(date)) == null) ? "" : str;
    }

    public final List b() {
        return this.f106953c;
    }

    public final boolean c() {
        return this.f106954d;
    }

    public final boolean d() {
        return this.f106955e;
    }

    public final AppVersionNameDTO e() {
        return this.f106951a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ChangelogVersionItem)) {
            return false;
        }
        ChangelogVersionItem changelogVersionItem = (ChangelogVersionItem) obj;
        return Intrinsics.areEqual(this.f106951a, changelogVersionItem.f106951a) && Intrinsics.areEqual(this.f106952b, changelogVersionItem.f106952b) && Intrinsics.areEqual(this.f106953c, changelogVersionItem.f106953c) && this.f106954d == changelogVersionItem.f106954d && this.f106955e == changelogVersionItem.f106955e;
    }

    public int hashCode() {
        int iHashCode = this.f106951a.hashCode() * 31;
        Date date = this.f106952b;
        return ((((((iHashCode + (date == null ? 0 : date.hashCode())) * 31) + this.f106953c.hashCode()) * 31) + Boolean.hashCode(this.f106954d)) * 31) + Boolean.hashCode(this.f106955e);
    }

    public String toString() {
        return "ChangelogVersionItem(versionName=" + this.f106951a + ", date=" + this.f106952b + ", features=" + this.f106953c + ", showCardOnDashboard=" + this.f106954d + ", showWhatsNew=" + this.f106955e + ")";
    }

    public /* synthetic */ ChangelogVersionItem(AppVersionNameDTO appVersionNameDTO, Date date, List list, boolean z2, boolean z3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(appVersionNameDTO, date, list, (i3 & 8) != 0 ? true : z2, (i3 & 16) != 0 ? false : z3);
    }
}
