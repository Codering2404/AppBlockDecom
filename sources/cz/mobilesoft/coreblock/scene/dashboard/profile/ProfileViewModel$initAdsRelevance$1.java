package cz.mobilesoft.coreblock.scene.dashboard.profile;

import cz.mobilesoft.coreblock.util.ads.BaseAdsUtils;
import cz.mobilesoft.coreblock.util.analytics.AnswersHelper;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
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
public final class ProfileViewModel$initAdsRelevance$1 implements BaseAdsUtils.ConsentLocationCheckCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ ProfileViewModel f100998a;

    ProfileViewModel$initAdsRelevance$1(ProfileViewModel profileViewModel) {
        this.f100998a = profileViewModel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ProfileViewState d(boolean z2, ProfileViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return ProfileViewState.b(updateState, null, null, null, false, false, null, null, null, null, null, false, z2, false, null, null, false, null, null, null, false, 1046527, null);
    }

    @Override // cz.mobilesoft.coreblock.util.ads.BaseAdsUtils.ConsentLocationCheckCallback
    public void a() {
        AnswersHelper.f128199a.t5();
    }

    @Override // cz.mobilesoft.coreblock.util.ads.BaseAdsUtils.ConsentLocationCheckCallback
    public void b(final boolean z2) {
        this.f100998a.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.dashboard.profile.a2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ProfileViewModel$initAdsRelevance$1.d(z2, (ProfileViewState) obj);
            }
        });
        if (!z2) {
            AnswersHelper.f128199a.t5();
        } else {
            AnswersHelper.f128199a.u5();
            ProfileViewModel.l1(this.f100998a, null, 1, null);
        }
    }
}
