package cz.mobilesoft.appblock.view;

import cz.mobilesoft.appblock.view.LockScreenProvider;
import cz.mobilesoft.coreblock.enums.ProfileType;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.UsageLimit;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
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
@DebugMetadata(c = "cz.mobilesoft.appblock.view.LockScreenProvider$init$2$1", f = "LockScreenProvider.kt", l = {294}, m = "invokeSuspend", v = 1)
final class LockScreenProvider$init$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f95197a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ LockScreenProvider f95198b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ String f95199c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ Long f95200d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ String f95201f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ ProfileType f95202g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ UsageLimit.PeriodType f95203h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LockScreenProvider$init$2$1(LockScreenProvider lockScreenProvider, String str, Long l3, String str2, ProfileType profileType, UsageLimit.PeriodType periodType, Continuation continuation) {
        super(2, continuation);
        this.f95198b = lockScreenProvider;
        this.f95199c = str;
        this.f95200d = l3;
        this.f95201f = str2;
        this.f95202g = profileType;
        this.f95203h = periodType;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new LockScreenProvider$init$2$1(this.f95198b, this.f95199c, this.f95200d, this.f95201f, this.f95202g, this.f95203h, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f95197a;
        if (i3 == 0) {
            ResultKt.b(obj);
            LockScreenProvider lockScreenProvider = this.f95198b;
            LockScreenProvider.LockScreenDTO lockScreenDTO = new LockScreenProvider.LockScreenDTO(this.f95199c, null, this.f95200d, this.f95201f, this.f95202g, this.f95203h, null, null, false, null, null, 1984, null);
            this.f95197a = 1;
            if (lockScreenProvider.i0(lockScreenDTO, this) == objF) {
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
        return ((LockScreenProvider$init$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
