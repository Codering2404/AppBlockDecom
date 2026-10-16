package cz.mobilesoft.coreblock.scene.intro.strictmode;

import cz.mobilesoft.coreblock.base.ViewState;
import cz.mobilesoft.coreblock.scene.dashboard.blocking.ProfileViewDTO;
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
public final class StrictModeIntroViewState implements ViewState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ProfileViewDTO f105064a;

    public StrictModeIntroViewState(ProfileViewDTO profileViewDTO) {
        this.f105064a = profileViewDTO;
    }

    public final StrictModeIntroViewState a(ProfileViewDTO profileViewDTO) {
        return new StrictModeIntroViewState(profileViewDTO);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof StrictModeIntroViewState) && Intrinsics.areEqual(this.f105064a, ((StrictModeIntroViewState) obj).f105064a);
    }

    public int hashCode() {
        ProfileViewDTO profileViewDTO = this.f105064a;
        if (profileViewDTO == null) {
            return 0;
        }
        return profileViewDTO.hashCode();
    }

    public String toString() {
        return "StrictModeIntroViewState(profileDto=" + this.f105064a + ")";
    }

    public /* synthetic */ StrictModeIntroViewState(ProfileViewDTO profileViewDTO, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : profileViewDTO);
    }
}
