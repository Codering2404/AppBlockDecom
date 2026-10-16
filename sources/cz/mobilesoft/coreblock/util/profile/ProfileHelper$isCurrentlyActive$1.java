package cz.mobilesoft.coreblock.util.profile;

import cz.mobilesoft.coreblock.storage.room.dao.blocking.IntervalDao;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile;
import java.util.List;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.util.profile.ProfileHelper$isCurrentlyActive$1", f = "ProfileHelper.kt", l = {162}, m = "invokeSuspend", v = 1)
final class ProfileHelper$isCurrentlyActive$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f129258a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f129259b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f129260c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ Profile f129261d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ProfileHelper$isCurrentlyActive$1(Profile profile, Continuation continuation) {
        super(2, continuation);
        this.f129261d = profile;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new ProfileHelper$isCurrentlyActive$1(this.f129261d, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        ProfileHelper profileHelper;
        Profile profile;
        Object objF = IntrinsicsKt.f();
        int i3 = this.f129260c;
        if (i3 == 0) {
            ResultKt.b(obj);
            ProfileHelper profileHelper2 = ProfileHelper.f129250a;
            Profile profile2 = this.f129261d;
            IntervalDao intervalDaoT = profileHelper2.t();
            long jR = this.f129261d.r();
            this.f129258a = profileHelper2;
            this.f129259b = profile2;
            this.f129260c = 1;
            Object objT = intervalDaoT.T(jR, this);
            if (objT == objF) {
                return objF;
            }
            profileHelper = profileHelper2;
            profile = profile2;
            obj = objT;
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Profile profile3 = (Profile) this.f129259b;
            ProfileHelper profileHelper3 = (ProfileHelper) this.f129258a;
            ResultKt.b(obj);
            profile = profile3;
            profileHelper = profileHelper3;
        }
        return Boxing.a(ProfileHelper.C(profileHelper, profile, (List) obj, null, 2, null));
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((ProfileHelper$isCurrentlyActive$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
