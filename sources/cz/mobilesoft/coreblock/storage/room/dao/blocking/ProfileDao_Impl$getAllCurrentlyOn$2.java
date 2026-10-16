package cz.mobilesoft.coreblock.storage.room.dao.blocking;

import cz.mobilesoft.coreblock.dto.UrlDto;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao_Impl$getAllCurrentlyOn$2", f = "ProfileDao_Impl.kt", l = {308}, m = "invokeSuspend", v = 1)
final class ProfileDao_Impl$getAllCurrentlyOn$2 extends SuspendLambda implements Function1<Continuation<? super List<? extends Profile>>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f125169a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ ProfileDao_Impl f125170b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Boolean f125171c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ Boolean f125172d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ Boolean f125173f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ String f125174g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ UrlDto f125175h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final /* synthetic */ Boolean f125176i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    final /* synthetic */ Boolean f125177j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ProfileDao_Impl$getAllCurrentlyOn$2(ProfileDao_Impl profileDao_Impl, Boolean bool, Boolean bool2, Boolean bool3, String str, UrlDto urlDto, Boolean bool4, Boolean bool5, Continuation continuation) {
        super(1, continuation);
        this.f125170b = profileDao_Impl;
        this.f125171c = bool;
        this.f125172d = bool2;
        this.f125173f = bool3;
        this.f125174g = str;
        this.f125175h = urlDto;
        this.f125176i = bool4;
        this.f125177j = bool5;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new ProfileDao_Impl$getAllCurrentlyOn$2(this.f125170b, this.f125171c, this.f125172d, this.f125173f, this.f125174g, this.f125175h, this.f125176i, this.f125177j, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f125169a;
        if (i3 != 0) {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            return obj;
        }
        ResultKt.b(obj);
        ProfileDao_Impl profileDao_Impl = this.f125170b;
        Boolean bool = this.f125171c;
        Boolean bool2 = this.f125172d;
        Boolean bool3 = this.f125173f;
        String str = this.f125174g;
        UrlDto urlDto = this.f125175h;
        Boolean bool4 = this.f125176i;
        Boolean bool5 = this.f125177j;
        this.f125169a = 1;
        Object objD0 = super/*cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao*/.D0(bool, bool2, bool3, str, urlDto, bool4, bool5, this);
        return objD0 == objF ? objF : objD0;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation continuation) {
        return ((ProfileDao_Impl$getAllCurrentlyOn$2) create(continuation)).invokeSuspend(Unit.f139807a);
    }
}
