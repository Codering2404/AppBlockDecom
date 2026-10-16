package cz.mobilesoft.coreblock.scene.dashboard.blocking;

import cz.mobilesoft.coreblock.dto.QuestionnaireConfig;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class AnnouncementCardState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f99521a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final QuestionnaireConfig f99522b;

    public AnnouncementCardState(boolean z2, QuestionnaireConfig questionnaireConfig) {
        this.f99521a = z2;
        this.f99522b = questionnaireConfig;
    }

    public final boolean a() {
        return this.f99521a;
    }

    public final QuestionnaireConfig b() {
        return this.f99522b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AnnouncementCardState)) {
            return false;
        }
        AnnouncementCardState announcementCardState = (AnnouncementCardState) obj;
        return this.f99521a == announcementCardState.f99521a && Intrinsics.areEqual(this.f99522b, announcementCardState.f99522b);
    }

    public int hashCode() {
        int iHashCode = Boolean.hashCode(this.f99521a) * 31;
        QuestionnaireConfig questionnaireConfig = this.f99522b;
        return iHashCode + (questionnaireConfig == null ? 0 : questionnaireConfig.hashCode());
    }

    public String toString() {
        return "AnnouncementCardState(isCardShown=" + this.f99521a + ", questionnaireConfig=" + this.f99522b + ")";
    }

    public /* synthetic */ AnnouncementCardState(boolean z2, QuestionnaireConfig questionnaireConfig, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? false : z2, (i3 & 2) != 0 ? null : questionnaireConfig);
    }
}
