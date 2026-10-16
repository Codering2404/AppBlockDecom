package cz.mobilesoft.coreblock.scene.dashboard.profile;

import cz.mobilesoft.coreblock.dto.events.AdsConsentEventDTO;
import cz.mobilesoft.coreblock.scene.dashboard.profile.ProfileViewEvent;
import cz.mobilesoft.coreblock.storage.datastore.EventDataStore;
import cz.mobilesoft.coreblock.util.helperextension.TimeHelperExt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.dashboard.profile.ProfileViewModel$onEvent$7", f = "ProfileViewModel.kt", l = {339}, m = "invokeSuspend", v = 1)
final class ProfileViewModel$onEvent$7 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f101016a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ ProfileViewModel f101017b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ ProfileViewEvent f101018c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ProfileViewModel$onEvent$7(ProfileViewModel profileViewModel, ProfileViewEvent profileViewEvent, Continuation continuation) {
        super(2, continuation);
        this.f101017b = profileViewModel;
        this.f101018c = profileViewEvent;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new ProfileViewModel$onEvent$7(this.f101017b, this.f101018c, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f101016a;
        if (i3 == 0) {
            ResultKt.b(obj);
            EventDataStore eventDataStoreU1 = this.f101017b.u1();
            AdsConsentEventDTO adsConsentEventDTO = new AdsConsentEventDTO(Boxing.e(TimeHelperExt.f128663a.f()), ((ProfileViewEvent.OnAdsConsentUpdated) this.f101018c).a(), Boxing.a(((ProfileViewEvent.OnAdsConsentUpdated) this.f101018c).b()));
            this.f101016a = 1;
            if (eventDataStoreU1.O1(adsConsentEventDTO, this) == objF) {
                return objF;
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((ProfileViewModel$onEvent$7) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
