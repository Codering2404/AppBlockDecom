package cz.mobilesoft.coreblock.scene.intro.schedule;

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
public final class IntroScheduleViewState implements ViewState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ProfileViewDTO f104831a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Integer f104832b;

    public IntroScheduleViewState(ProfileViewDTO profileViewDTO, Integer num) {
        this.f104831a = profileViewDTO;
        this.f104832b = num;
    }

    public final IntroScheduleViewState a(ProfileViewDTO profileViewDTO, Integer num) {
        return new IntroScheduleViewState(profileViewDTO, num);
    }

    public final ProfileViewDTO b() {
        return this.f104831a;
    }

    public final Integer c() {
        return this.f104832b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof IntroScheduleViewState)) {
            return false;
        }
        IntroScheduleViewState introScheduleViewState = (IntroScheduleViewState) obj;
        return Intrinsics.areEqual(this.f104831a, introScheduleViewState.f104831a) && Intrinsics.areEqual(this.f104832b, introScheduleViewState.f104832b);
    }

    public int hashCode() {
        ProfileViewDTO profileViewDTO = this.f104831a;
        int iHashCode = (profileViewDTO == null ? 0 : profileViewDTO.hashCode()) * 31;
        Integer num = this.f104832b;
        return iHashCode + (num != null ? num.hashCode() : 0);
    }

    public String toString() {
        return "IntroScheduleViewState(schedule=" + this.f104831a + ", typeCombinations=" + this.f104832b + ")";
    }

    public /* synthetic */ IntroScheduleViewState(ProfileViewDTO profileViewDTO, Integer num, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : profileViewDTO, (i3 & 2) != 0 ? null : num);
    }
}
