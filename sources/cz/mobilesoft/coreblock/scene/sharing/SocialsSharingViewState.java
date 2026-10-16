package cz.mobilesoft.coreblock.scene.sharing;

import cz.mobilesoft.coreblock.base.ViewState;
import cz.mobilesoft.coreblock.scene.sharing.dto.SocialsSharePayload;
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
public final class SocialsSharingViewState implements ViewState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f119362a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final SocialsSharePayload f119363b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f119364c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f119365d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final List f119366f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final List f119367g;

    public SocialsSharingViewState(int i3, SocialsSharePayload graphPayload, String topBarDateLabel, String comparisonText, List shareableApps, List availableTemplates) {
        Intrinsics.checkNotNullParameter(graphPayload, "graphPayload");
        Intrinsics.checkNotNullParameter(topBarDateLabel, "topBarDateLabel");
        Intrinsics.checkNotNullParameter(comparisonText, "comparisonText");
        Intrinsics.checkNotNullParameter(shareableApps, "shareableApps");
        Intrinsics.checkNotNullParameter(availableTemplates, "availableTemplates");
        this.f119362a = i3;
        this.f119363b = graphPayload;
        this.f119364c = topBarDateLabel;
        this.f119365d = comparisonText;
        this.f119366f = shareableApps;
        this.f119367g = availableTemplates;
    }

    public static /* synthetic */ SocialsSharingViewState b(SocialsSharingViewState socialsSharingViewState, int i3, SocialsSharePayload socialsSharePayload, String str, String str2, List list, List list2, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i3 = socialsSharingViewState.f119362a;
        }
        if ((i4 & 2) != 0) {
            socialsSharePayload = socialsSharingViewState.f119363b;
        }
        if ((i4 & 4) != 0) {
            str = socialsSharingViewState.f119364c;
        }
        if ((i4 & 8) != 0) {
            str2 = socialsSharingViewState.f119365d;
        }
        if ((i4 & 16) != 0) {
            list = socialsSharingViewState.f119366f;
        }
        if ((i4 & 32) != 0) {
            list2 = socialsSharingViewState.f119367g;
        }
        List list3 = list;
        List list4 = list2;
        return socialsSharingViewState.a(i3, socialsSharePayload, str, str2, list3, list4);
    }

    public final SocialsSharingViewState a(int i3, SocialsSharePayload graphPayload, String topBarDateLabel, String comparisonText, List shareableApps, List availableTemplates) {
        Intrinsics.checkNotNullParameter(graphPayload, "graphPayload");
        Intrinsics.checkNotNullParameter(topBarDateLabel, "topBarDateLabel");
        Intrinsics.checkNotNullParameter(comparisonText, "comparisonText");
        Intrinsics.checkNotNullParameter(shareableApps, "shareableApps");
        Intrinsics.checkNotNullParameter(availableTemplates, "availableTemplates");
        return new SocialsSharingViewState(i3, graphPayload, topBarDateLabel, comparisonText, shareableApps, availableTemplates);
    }

    public final List c() {
        return this.f119367g;
    }

    public final String d() {
        return this.f119365d;
    }

    public final int e() {
        return this.f119362a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SocialsSharingViewState)) {
            return false;
        }
        SocialsSharingViewState socialsSharingViewState = (SocialsSharingViewState) obj;
        return this.f119362a == socialsSharingViewState.f119362a && Intrinsics.areEqual(this.f119363b, socialsSharingViewState.f119363b) && Intrinsics.areEqual(this.f119364c, socialsSharingViewState.f119364c) && Intrinsics.areEqual(this.f119365d, socialsSharingViewState.f119365d) && Intrinsics.areEqual(this.f119366f, socialsSharingViewState.f119366f) && Intrinsics.areEqual(this.f119367g, socialsSharingViewState.f119367g);
    }

    public final SocialsSharePayload f() {
        return this.f119363b;
    }

    public final List g() {
        return this.f119366f;
    }

    public final String h() {
        return this.f119364c;
    }

    public int hashCode() {
        return (((((((((Integer.hashCode(this.f119362a) * 31) + this.f119363b.hashCode()) * 31) + this.f119364c.hashCode()) * 31) + this.f119365d.hashCode()) * 31) + this.f119366f.hashCode()) * 31) + this.f119367g.hashCode();
    }

    public String toString() {
        return "SocialsSharingViewState(currentPage=" + this.f119362a + ", graphPayload=" + this.f119363b + ", topBarDateLabel=" + this.f119364c + ", comparisonText=" + this.f119365d + ", shareableApps=" + this.f119366f + ", availableTemplates=" + this.f119367g + ")";
    }

    public /* synthetic */ SocialsSharingViewState(int i3, SocialsSharePayload socialsSharePayload, String str, String str2, List list, List list2, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? 0 : i3, (i4 & 2) != 0 ? new SocialsSharePayload(SocialsSharePayload.PeriodType.Day, CollectionsKt.emptyList(), null, null, 0, null, 0, 0L, 0L, null, null, null, null, null, null, null, 65532, null) : socialsSharePayload, (i4 & 4) != 0 ? "" : str, (i4 & 8) == 0 ? str2 : "", (i4 & 16) != 0 ? CollectionsKt.emptyList() : list, (i4 & 32) != 0 ? CollectionsKt.emptyList() : list2);
    }
}
