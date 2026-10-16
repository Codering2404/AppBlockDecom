package cz.mobilesoft.coreblock.storage.room.dao.blocking;

import cz.mobilesoft.coreblock.enums.ProfileType;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao_Impl$getAllIndefinitelyOn$2", f = "ProfileDao_Impl.kt", l = {324}, m = "invokeSuspend", v = 1)
final class ProfileDao_Impl$getAllIndefinitelyOn$2 extends SuspendLambda implements Function1<Continuation<? super List<? extends Profile>>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f125178a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ ProfileDao_Impl f125179b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ ProfileType f125180c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ List f125181d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ProfileDao_Impl$getAllIndefinitelyOn$2(ProfileDao_Impl profileDao_Impl, ProfileType profileType, List list, Continuation continuation) {
        super(1, continuation);
        this.f125179b = profileDao_Impl;
        this.f125180c = profileType;
        this.f125181d = list;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new ProfileDao_Impl$getAllIndefinitelyOn$2(this.f125179b, this.f125180c, this.f125181d, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f125178a;
        if (i3 != 0) {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            return obj;
        }
        ResultKt.b(obj);
        ProfileDao_Impl profileDao_Impl = this.f125179b;
        ProfileType profileType = this.f125180c;
        List list = this.f125181d;
        this.f125178a = 1;
        Object objL0 = super/*cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao*/.L0(profileType, list, this);
        return objL0 == objF ? objF : objL0;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation continuation) {
        return ((ProfileDao_Impl$getAllIndefinitelyOn$2) create(continuation)).invokeSuspend(Unit.f139807a);
    }
}
