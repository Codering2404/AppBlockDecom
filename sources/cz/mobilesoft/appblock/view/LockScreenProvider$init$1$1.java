package cz.mobilesoft.appblock.view;

import cz.mobilesoft.coreblock.dto.UrlDto;
import cz.mobilesoft.coreblock.enums.StrictModeOption;
import cz.mobilesoft.coreblock.storage.room.dto.blocking.ProfileWithConfiguration;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.UsageLimit;
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
@DebugMetadata(c = "cz.mobilesoft.appblock.view.LockScreenProvider$init$1$1", f = "LockScreenProvider.kt", l = {268}, m = "invokeSuspend", v = 1)
final class LockScreenProvider$init$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f95185a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f95186b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object f95187c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f95188d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ ProfileWithConfiguration f95189f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ LockScreenProvider f95190g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ UrlDto f95191h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final /* synthetic */ String f95192i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    final /* synthetic */ Long f95193j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    final /* synthetic */ UsageLimit.PeriodType f95194k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    final /* synthetic */ String f95195l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    final /* synthetic */ StrictModeOption f95196m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LockScreenProvider$init$1$1(ProfileWithConfiguration profileWithConfiguration, LockScreenProvider lockScreenProvider, UrlDto urlDto, String str, Long l3, UsageLimit.PeriodType periodType, String str2, StrictModeOption strictModeOption, Continuation continuation) {
        super(2, continuation);
        this.f95189f = profileWithConfiguration;
        this.f95190g = lockScreenProvider;
        this.f95191h = urlDto;
        this.f95192i = str;
        this.f95193j = l3;
        this.f95194k = periodType;
        this.f95195l = str2;
        this.f95196m = strictModeOption;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new LockScreenProvider$init$1$1(this.f95189f, this.f95190g, this.f95191h, this.f95192i, this.f95193j, this.f95194k, this.f95195l, this.f95196m, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x006c  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r22) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 247
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.appblock.view.LockScreenProvider$init$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((LockScreenProvider$init$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
