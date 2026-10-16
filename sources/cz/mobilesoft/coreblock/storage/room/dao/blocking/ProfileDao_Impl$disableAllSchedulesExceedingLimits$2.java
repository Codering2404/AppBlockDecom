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
@DebugMetadata(c = "cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao_Impl$disableAllSchedulesExceedingLimits$2", f = "ProfileDao_Impl.kt", l = {344}, m = "invokeSuspend", v = 1)
final class ProfileDao_Impl$disableAllSchedulesExceedingLimits$2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f125142a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ ProfileDao_Impl f125143b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ boolean f125144c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ boolean f125145d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ boolean f125146f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ boolean f125147g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ boolean f125148h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final /* synthetic */ boolean f125149i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    final /* synthetic */ boolean f125150j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    final /* synthetic */ boolean f125151k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    final /* synthetic */ boolean f125152l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    final /* synthetic */ boolean f125153m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    final /* synthetic */ boolean f125154n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ProfileDao_Impl$disableAllSchedulesExceedingLimits$2(ProfileDao_Impl profileDao_Impl, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10, boolean z11, boolean z12, Continuation continuation) {
        super(1, continuation);
        this.f125143b = profileDao_Impl;
        this.f125144c = z2;
        this.f125145d = z3;
        this.f125146f = z4;
        this.f125147g = z5;
        this.f125148h = z6;
        this.f125149i = z7;
        this.f125150j = z8;
        this.f125151k = z9;
        this.f125152l = z10;
        this.f125153m = z11;
        this.f125154n = z12;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new ProfileDao_Impl$disableAllSchedulesExceedingLimits$2(this.f125143b, this.f125144c, this.f125145d, this.f125146f, this.f125147g, this.f125148h, this.f125149i, this.f125150j, this.f125151k, this.f125152l, this.f125153m, this.f125154n, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f125142a;
        if (i3 == 0) {
            ResultKt.b(obj);
            ProfileDao_Impl profileDao_Impl = this.f125143b;
            boolean z2 = this.f125144c;
            boolean z3 = this.f125145d;
            boolean z4 = this.f125146f;
            boolean z5 = this.f125147g;
            boolean z6 = this.f125148h;
            boolean z7 = this.f125149i;
            boolean z8 = this.f125150j;
            boolean z9 = this.f125151k;
            boolean z10 = this.f125152l;
            boolean z11 = this.f125153m;
            boolean z12 = this.f125154n;
            this.f125142a = 1;
            if (super/*cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao*/.c0(z2, z3, z4, z5, z6, z7, z8, z9, z10, z11, z12, this) == objF) {
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
        return ((ProfileDao_Impl$disableAllSchedulesExceedingLimits$2) create(continuation)).invokeSuspend(Unit.f139807a);
    }
}
