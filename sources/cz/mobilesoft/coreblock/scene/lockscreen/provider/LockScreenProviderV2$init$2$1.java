package cz.mobilesoft.coreblock.scene.lockscreen.provider;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.lockscreen.provider.LockScreenProviderV2$init$2$1", f = "LockScreenProviderV2.kt", l = {277}, m = "invokeSuspend", v = 1)
final class LockScreenProviderV2$init$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f105854a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f105855b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object f105856c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f105857d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ ProfileWithConfiguration f105858f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ LockScreenProviderV2 f105859g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ UrlDto f105860h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final /* synthetic */ String f105861i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    final /* synthetic */ Long f105862j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    final /* synthetic */ UsageLimit.PeriodType f105863k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    final /* synthetic */ String f105864l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    final /* synthetic */ StrictModeOption f105865m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    final /* synthetic */ boolean f105866n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    final /* synthetic */ boolean f105867o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    final /* synthetic */ boolean f105868p;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LockScreenProviderV2$init$2$1(ProfileWithConfiguration profileWithConfiguration, LockScreenProviderV2 lockScreenProviderV2, UrlDto urlDto, String str, Long l3, UsageLimit.PeriodType periodType, String str2, StrictModeOption strictModeOption, boolean z2, boolean z3, boolean z4, Continuation continuation) {
        super(2, continuation);
        this.f105858f = profileWithConfiguration;
        this.f105859g = lockScreenProviderV2;
        this.f105860h = urlDto;
        this.f105861i = str;
        this.f105862j = l3;
        this.f105863k = periodType;
        this.f105864l = str2;
        this.f105865m = strictModeOption;
        this.f105866n = z2;
        this.f105867o = z3;
        this.f105868p = z4;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new LockScreenProviderV2$init$2$1(this.f105858f, this.f105859g, this.f105860h, this.f105861i, this.f105862j, this.f105863k, this.f105864l, this.f105865m, this.f105866n, this.f105867o, this.f105868p, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x006c  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r25) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 268
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.lockscreen.provider.LockScreenProviderV2$init$2$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((LockScreenProviderV2$init$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
