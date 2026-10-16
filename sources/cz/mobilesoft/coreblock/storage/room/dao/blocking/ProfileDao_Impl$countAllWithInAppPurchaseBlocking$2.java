package cz.mobilesoft.coreblock.storage.room.dao.blocking;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao_Impl$countAllWithInAppPurchaseBlocking$2", f = "ProfileDao_Impl.kt", l = {292}, m = "invokeSuspend", v = 1)
final class ProfileDao_Impl$countAllWithInAppPurchaseBlocking$2 extends SuspendLambda implements Function1<Continuation<? super Long>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f125139a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ ProfileDao_Impl f125140b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ boolean f125141c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ProfileDao_Impl$countAllWithInAppPurchaseBlocking$2(ProfileDao_Impl profileDao_Impl, boolean z2, Continuation continuation) {
        super(1, continuation);
        this.f125140b = profileDao_Impl;
        this.f125141c = z2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new ProfileDao_Impl$countAllWithInAppPurchaseBlocking$2(this.f125140b, this.f125141c, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f125139a;
        if (i3 != 0) {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            return obj;
        }
        ResultKt.b(obj);
        ProfileDao_Impl profileDao_Impl = this.f125140b;
        boolean z2 = this.f125141c;
        this.f125139a = 1;
        Object objV = super/*cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao*/.V(z2, this);
        return objV == objF ? objF : objV;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation continuation) {
        return ((ProfileDao_Impl$countAllWithInAppPurchaseBlocking$2) create(continuation)).invokeSuspend(Unit.f139807a);
    }
}
