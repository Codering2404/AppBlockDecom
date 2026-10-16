package cz.mobilesoft.appblock.service;

import cz.mobilesoft.coreblock.dto.UrlDto;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.AdultContentWebsiteDao;
import cz.mobilesoft.coreblock.util.helperextension.DatabaseExtKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.appblock.service.LockAccessibilityService$getBlockedSitesAndBlock$activeProfiles$1$1", f = "LockAccessibilityService.kt", l = {1601}, m = "invokeSuspend", v = 1)
final class LockAccessibilityService$getBlockedSitesAndBlock$activeProfiles$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f94286a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ LockAccessibilityService f94287b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ UrlDto f94288c;

    /* JADX INFO: renamed from: cz.mobilesoft.appblock.service.LockAccessibilityService$getBlockedSitesAndBlock$activeProfiles$1$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.appblock.service.LockAccessibilityService$getBlockedSitesAndBlock$activeProfiles$1$1$1", f = "LockAccessibilityService.kt", l = {1601}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Boolean>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f94289a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ LockAccessibilityService f94290b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ UrlDto f94291c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(LockAccessibilityService lockAccessibilityService, UrlDto urlDto, Continuation continuation) {
            super(1, continuation);
            this.f94290b = lockAccessibilityService;
            this.f94291c = urlDto;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return new AnonymousClass1(this.f94290b, this.f94291c, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f94289a;
            if (i3 != 0) {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
                return obj;
            }
            ResultKt.b(obj);
            AdultContentWebsiteDao adultContentWebsiteDaoR0 = this.f94290b.R0();
            String domain = this.f94291c.getDomain();
            this.f94289a = 1;
            Object objM = adultContentWebsiteDaoR0.M(domain, this);
            return objM == objF ? objF : objM;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((AnonymousClass1) create(continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LockAccessibilityService$getBlockedSitesAndBlock$activeProfiles$1$1(LockAccessibilityService lockAccessibilityService, UrlDto urlDto, Continuation continuation) {
        super(2, continuation);
        this.f94287b = lockAccessibilityService;
        this.f94288c = urlDto;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new LockAccessibilityService$getBlockedSitesAndBlock$activeProfiles$1$1(this.f94287b, this.f94288c, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f94286a;
        if (i3 != 0) {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            return obj;
        }
        ResultKt.b(obj);
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.f94287b, this.f94288c, null);
        this.f94286a = 1;
        Object objB = DatabaseExtKt.b(0, 0L, anonymousClass1, this, 3, null);
        return objB == objF ? objF : objB;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((LockAccessibilityService$getBlockedSitesAndBlock$activeProfiles$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
