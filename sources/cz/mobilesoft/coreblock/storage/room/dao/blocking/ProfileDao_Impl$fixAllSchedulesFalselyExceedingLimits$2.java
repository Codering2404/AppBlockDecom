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
@DebugMetadata(c = "cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao_Impl$fixAllSchedulesFalselyExceedingLimits$2", f = "ProfileDao_Impl.kt", l = {367}, m = "invokeSuspend", v = 1)
final class ProfileDao_Impl$fixAllSchedulesFalselyExceedingLimits$2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f125157a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ ProfileDao_Impl f125158b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ boolean f125159c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ boolean f125160d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ boolean f125161f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ boolean f125162g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ boolean f125163h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final /* synthetic */ boolean f125164i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ProfileDao_Impl$fixAllSchedulesFalselyExceedingLimits$2(ProfileDao_Impl profileDao_Impl, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, Continuation continuation) {
        super(1, continuation);
        this.f125158b = profileDao_Impl;
        this.f125159c = z2;
        this.f125160d = z3;
        this.f125161f = z4;
        this.f125162g = z5;
        this.f125163h = z6;
        this.f125164i = z7;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new ProfileDao_Impl$fixAllSchedulesFalselyExceedingLimits$2(this.f125158b, this.f125159c, this.f125160d, this.f125161f, this.f125162g, this.f125163h, this.f125164i, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f125157a;
        if (i3 == 0) {
            ResultKt.b(obj);
            ProfileDao_Impl profileDao_Impl = this.f125158b;
            boolean z2 = this.f125159c;
            boolean z3 = this.f125160d;
            boolean z4 = this.f125161f;
            boolean z5 = this.f125162g;
            boolean z6 = this.f125163h;
            boolean z7 = this.f125164i;
            this.f125157a = 1;
            if (super/*cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao*/.p0(z2, z3, z4, z5, z6, z7, this) == objF) {
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
        return ((ProfileDao_Impl$fixAllSchedulesFalselyExceedingLimits$2) create(continuation)).invokeSuspend(Unit.f139807a);
    }
}
