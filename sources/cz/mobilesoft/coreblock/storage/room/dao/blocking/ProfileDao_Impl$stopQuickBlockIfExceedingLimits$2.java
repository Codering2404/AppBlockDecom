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
@DebugMetadata(c = "cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao_Impl$stopQuickBlockIfExceedingLimits$2", f = "ProfileDao_Impl.kt", l = {356}, m = "invokeSuspend", v = 1)
final class ProfileDao_Impl$stopQuickBlockIfExceedingLimits$2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f125182a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ ProfileDao_Impl f125183b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ boolean f125184c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ boolean f125185d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ boolean f125186f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ boolean f125187g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ boolean f125188h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final /* synthetic */ boolean f125189i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    final /* synthetic */ boolean f125190j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ProfileDao_Impl$stopQuickBlockIfExceedingLimits$2(ProfileDao_Impl profileDao_Impl, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, Continuation continuation) {
        super(1, continuation);
        this.f125183b = profileDao_Impl;
        this.f125184c = z2;
        this.f125185d = z3;
        this.f125186f = z4;
        this.f125187g = z5;
        this.f125188h = z6;
        this.f125189i = z7;
        this.f125190j = z8;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new ProfileDao_Impl$stopQuickBlockIfExceedingLimits$2(this.f125183b, this.f125184c, this.f125185d, this.f125186f, this.f125187g, this.f125188h, this.f125189i, this.f125190j, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f125182a;
        if (i3 == 0) {
            ResultKt.b(obj);
            ProfileDao_Impl profileDao_Impl = this.f125183b;
            boolean z2 = this.f125184c;
            boolean z3 = this.f125185d;
            boolean z4 = this.f125186f;
            boolean z5 = this.f125187g;
            boolean z6 = this.f125188h;
            boolean z7 = this.f125189i;
            boolean z8 = this.f125190j;
            this.f125182a = 1;
            if (super/*cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao*/.j1(z2, z3, z4, z5, z6, z7, z8, this) == objF) {
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

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation continuation) {
        return ((ProfileDao_Impl$stopQuickBlockIfExceedingLimits$2) create(continuation)).invokeSuspend(Unit.f139807a);
    }
}
