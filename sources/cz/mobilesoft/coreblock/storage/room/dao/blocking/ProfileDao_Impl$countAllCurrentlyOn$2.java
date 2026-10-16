package cz.mobilesoft.coreblock.storage.room.dao.blocking;

import cz.mobilesoft.coreblock.dto.UrlDto;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao_Impl$countAllCurrentlyOn$2", f = "ProfileDao_Impl.kt", l = {320}, m = "invokeSuspend", v = 1)
final class ProfileDao_Impl$countAllCurrentlyOn$2 extends SuspendLambda implements Function1<Continuation<? super Long>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f125130a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ ProfileDao_Impl f125131b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Boolean f125132c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ Boolean f125133d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ Boolean f125134f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ String f125135g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ UrlDto f125136h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final /* synthetic */ Boolean f125137i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    final /* synthetic */ Boolean f125138j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ProfileDao_Impl$countAllCurrentlyOn$2(ProfileDao_Impl profileDao_Impl, Boolean bool, Boolean bool2, Boolean bool3, String str, UrlDto urlDto, Boolean bool4, Boolean bool5, Continuation continuation) {
        super(1, continuation);
        this.f125131b = profileDao_Impl;
        this.f125132c = bool;
        this.f125133d = bool2;
        this.f125134f = bool3;
        this.f125135g = str;
        this.f125136h = urlDto;
        this.f125137i = bool4;
        this.f125138j = bool5;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new ProfileDao_Impl$countAllCurrentlyOn$2(this.f125131b, this.f125132c, this.f125133d, this.f125134f, this.f125135g, this.f125136h, this.f125137i, this.f125138j, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f125130a;
        if (i3 != 0) {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            return obj;
        }
        ResultKt.b(obj);
        ProfileDao_Impl profileDao_Impl = this.f125131b;
        Boolean bool = this.f125132c;
        Boolean bool2 = this.f125133d;
        Boolean bool3 = this.f125134f;
        String str = this.f125135g;
        UrlDto urlDto = this.f125136h;
        Boolean bool4 = this.f125137i;
        Boolean bool5 = this.f125138j;
        this.f125130a = 1;
        Object objL = super/*cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao*/.L(bool, bool2, bool3, str, urlDto, bool4, bool5, this);
        return objL == objF ? objF : objL;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation continuation) {
        return ((ProfileDao_Impl$countAllCurrentlyOn$2) create(continuation)).invokeSuspend(Unit.f139807a);
    }
}
