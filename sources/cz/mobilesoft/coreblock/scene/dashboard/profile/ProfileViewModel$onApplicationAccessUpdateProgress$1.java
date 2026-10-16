package cz.mobilesoft.coreblock.scene.dashboard.profile;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.dashboard.profile.ProfileViewModel$onApplicationAccessUpdateProgress$1", f = "ProfileViewModel.kt", l = {384, 390}, m = "invokeSuspend", v = 1)
final class ProfileViewModel$onApplicationAccessUpdateProgress$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f100999a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f101000b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ ProfileViewModel f101001c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ProfileViewModel$onApplicationAccessUpdateProgress$1(ProfileViewModel profileViewModel, Continuation continuation) {
        super(2, continuation);
        this.f101001c = profileViewModel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ProfileViewState q(List list, ProfileViewState profileViewState) {
        return ProfileViewState.b(profileViewState, null, null, list, false, false, null, null, null, null, null, false, false, false, null, null, false, null, null, null, false, 1048571, null);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new ProfileViewModel$onApplicationAccessUpdateProgress$1(this.f101001c, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0060, code lost:
    
        if (r1.C1(r4) == r0) goto L19;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r5) throws java.lang.Throwable {
        /*
            r4 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r4.f101000b
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L22
            if (r1 == r3) goto L1e
            if (r1 != r2) goto L16
            java.lang.Object r0 = r4.f100999a
            java.util.List r0 = (java.util.List) r0
            kotlin.ResultKt.b(r5)
            goto L63
        L16:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L1e:
            kotlin.ResultKt.b(r5)
            goto L3a
        L22:
            kotlin.ResultKt.b(r5)
            cz.mobilesoft.coreblock.scene.dashboard.profile.ProfileViewModel r5 = r4.f101001c
            cz.mobilesoft.coreblock.usecase.StatisticsPermissionsUseCase r5 = cz.mobilesoft.coreblock.scene.dashboard.profile.ProfileViewModel.e1(r5)
            cz.mobilesoft.coreblock.usecase.StatisticsPermissionsUseCase$Params r1 = cz.mobilesoft.coreblock.usecase.StatisticsPermissionsUseCase.Params.f127324a
            kotlinx.coroutines.flow.Flow r5 = r5.b(r1)
            r4.f101000b = r3
            java.lang.Object r5 = kotlinx.coroutines.flow.FlowKt.D(r5, r4)
            if (r5 != r0) goto L3a
            goto L62
        L3a:
            java.util.List r5 = (java.util.List) r5
            cz.mobilesoft.coreblock.scene.dashboard.profile.ProfileViewModel r1 = r4.f101001c
            cz.mobilesoft.coreblock.scene.dashboard.profile.b2 r3 = new cz.mobilesoft.coreblock.scene.dashboard.profile.b2
            r3.<init>()
            cz.mobilesoft.coreblock.scene.dashboard.profile.ProfileViewModel.g1(r1, r3)
            r1 = r5
            java.util.Collection r1 = (java.util.Collection) r1
            boolean r1 = r1.isEmpty()
            if (r1 != 0) goto L52
            kotlin.Unit r5 = kotlin.Unit.f139807a
            return r5
        L52:
            cz.mobilesoft.coreblock.scene.dashboard.profile.ProfileViewModel r1 = r4.f101001c
            java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.a(r5)
            r4.f100999a = r5
            r4.f101000b = r2
            java.lang.Object r5 = cz.mobilesoft.coreblock.scene.dashboard.profile.ProfileViewModel.h1(r1, r4)
            if (r5 != r0) goto L63
        L62:
            return r0
        L63:
            kotlin.Unit r5 = kotlin.Unit.f139807a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.dashboard.profile.ProfileViewModel$onApplicationAccessUpdateProgress$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((ProfileViewModel$onApplicationAccessUpdateProgress$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
