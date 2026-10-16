package cz.mobilesoft.coreblock.scene.schedule.detail;

import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.collections.immutable.ExtensionsKt;
import kotlinx.collections.immutable.ImmutableList;

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
public final class Blocking {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Profile.BlockingMode f116492a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Profile.AllowlistWebBrowsingMode f116493b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f116494c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ImmutableList f116495d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ImmutableList f116496e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final ImmutableList f116497f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final ImmutableList f116498g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final ImmutableList f116499h;

    public Blocking(Profile.BlockingMode blockingMode, Profile.AllowlistWebBrowsingMode webBrowsingMode, boolean z2, ImmutableList apps, ImmutableList webs, ImmutableList subApps, ImmutableList keywords, ImmutableList selectedCategories) {
        Intrinsics.checkNotNullParameter(blockingMode, "blockingMode");
        Intrinsics.checkNotNullParameter(webBrowsingMode, "webBrowsingMode");
        Intrinsics.checkNotNullParameter(apps, "apps");
        Intrinsics.checkNotNullParameter(webs, "webs");
        Intrinsics.checkNotNullParameter(subApps, "subApps");
        Intrinsics.checkNotNullParameter(keywords, "keywords");
        Intrinsics.checkNotNullParameter(selectedCategories, "selectedCategories");
        this.f116492a = blockingMode;
        this.f116493b = webBrowsingMode;
        this.f116494c = z2;
        this.f116495d = apps;
        this.f116496e = webs;
        this.f116497f = subApps;
        this.f116498g = keywords;
        this.f116499h = selectedCategories;
    }

    public final ImmutableList a() {
        return this.f116495d;
    }

    public final Profile.BlockingMode b() {
        return this.f116492a;
    }

    public final ImmutableList c() {
        return this.f116498g;
    }

    public final ImmutableList d() {
        return this.f116499h;
    }

    public final ImmutableList e() {
        return this.f116497f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Blocking)) {
            return false;
        }
        Blocking blocking = (Blocking) obj;
        return this.f116492a == blocking.f116492a && this.f116493b == blocking.f116493b && this.f116494c == blocking.f116494c && Intrinsics.areEqual(this.f116495d, blocking.f116495d) && Intrinsics.areEqual(this.f116496e, blocking.f116496e) && Intrinsics.areEqual(this.f116497f, blocking.f116497f) && Intrinsics.areEqual(this.f116498g, blocking.f116498g) && Intrinsics.areEqual(this.f116499h, blocking.f116499h);
    }

    public final Profile.AllowlistWebBrowsingMode f() {
        return this.f116493b;
    }

    public final ImmutableList g() {
        return this.f116496e;
    }

    public final boolean h() {
        return this.f116495d.isEmpty() && this.f116496e.isEmpty() && this.f116498g.isEmpty() && this.f116499h.isEmpty() && this.f116497f.isEmpty();
    }

    public int hashCode() {
        return (((((((((((((this.f116492a.hashCode() * 31) + this.f116493b.hashCode()) * 31) + Boolean.hashCode(this.f116494c)) * 31) + this.f116495d.hashCode()) * 31) + this.f116496e.hashCode()) * 31) + this.f116497f.hashCode()) * 31) + this.f116498g.hashCode()) * 31) + this.f116499h.hashCode();
    }

    public final boolean i() {
        return this.f116494c;
    }

    public String toString() {
        return "Blocking(blockingMode=" + this.f116492a + ", webBrowsingMode=" + this.f116493b + ", isLocked=" + this.f116494c + ", apps=" + this.f116495d + ", webs=" + this.f116496e + ", subApps=" + this.f116497f + ", keywords=" + this.f116498g + ", selectedCategories=" + this.f116499h + ")";
    }

    public /* synthetic */ Blocking(Profile.BlockingMode blockingMode, Profile.AllowlistWebBrowsingMode allowlistWebBrowsingMode, boolean z2, ImmutableList immutableList, ImmutableList immutableList2, ImmutableList immutableList3, ImmutableList immutableList4, ImmutableList immutableList5, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? Profile.BlockingMode.Blocklist : blockingMode, (i3 & 2) != 0 ? Profile.AllowlistWebBrowsingMode.Allowed : allowlistWebBrowsingMode, (i3 & 4) != 0 ? false : z2, (i3 & 8) != 0 ? ExtensionsKt.a() : immutableList, (i3 & 16) != 0 ? ExtensionsKt.a() : immutableList2, (i3 & 32) != 0 ? ExtensionsKt.a() : immutableList3, (i3 & 64) != 0 ? ExtensionsKt.a() : immutableList4, (i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? ExtensionsKt.a() : immutableList5);
    }
}
