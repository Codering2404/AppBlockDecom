package cz.mobilesoft.coreblock.scene.intro;

import cz.mobilesoft.coreblock.dto.AppWebWrapper;
import cz.mobilesoft.statistics.model.AggregatedItemRecord;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.intro.OnboardingViewModel$appsWebsList$1", f = "OnboardingViewModel.kt", l = {}, m = "invokeSuspend", v = 1)
final class OnboardingViewModel$appsWebsList$1 extends SuspendLambda implements Function2<List<? extends AggregatedItemRecord>, Continuation<? super List<? extends AppWebWrapper>>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f104541a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    /* synthetic */ Object f104542b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ OnboardingViewModel f104543c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    OnboardingViewModel$appsWebsList$1(OnboardingViewModel onboardingViewModel, Continuation continuation) {
        super(2, continuation);
        this.f104543c = onboardingViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        OnboardingViewModel$appsWebsList$1 onboardingViewModel$appsWebsList$1 = new OnboardingViewModel$appsWebsList$1(this.f104543c, continuation);
        onboardingViewModel$appsWebsList$1.f104542b = obj;
        return onboardingViewModel$appsWebsList$1;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0046  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r9) throws java.lang.Throwable {
        /*
            r8 = this;
            java.lang.Object r0 = r8.f104542b
            java.util.List r0 = (java.util.List) r0
            kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r8.f104541a
            if (r1 != 0) goto L67
            kotlin.ResultKt.b(r9)
            if (r0 == 0) goto L46
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.ArrayList r9 = new java.util.ArrayList
            r1 = 10
            int r1 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r0, r1)
            r9.<init>(r1)
            java.util.Iterator r0 = r0.iterator()
        L21:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L3b
            java.lang.Object r1 = r0.next()
            r3 = r1
            cz.mobilesoft.statistics.model.AggregatedItemRecord r3 = (cz.mobilesoft.statistics.model.AggregatedItemRecord) r3
            cz.mobilesoft.coreblock.dto.AppWebWrapper r2 = new cz.mobilesoft.coreblock.dto.AppWebWrapper
            r6 = 6
            r7 = 0
            r4 = 0
            r5 = 0
            r2.<init>(r3, r4, r5, r6, r7)
            r9.add(r2)
            goto L21
        L3b:
            cz.mobilesoft.coreblock.scene.intro.OnboardingViewModel$appsWebsList$1$invokeSuspend$$inlined$sortedByDescending$1 r0 = new cz.mobilesoft.coreblock.scene.intro.OnboardingViewModel$appsWebsList$1$invokeSuspend$$inlined$sortedByDescending$1
            r0.<init>()
            java.util.List r9 = kotlin.collections.CollectionsKt.sortedWith(r9, r0)
            if (r9 != 0) goto L4a
        L46:
            java.util.List r9 = kotlin.collections.CollectionsKt.emptyList()
        L4a:
            cz.mobilesoft.coreblock.scene.intro.OnboardingViewModel r0 = r8.f104543c
            r1 = 1065353216(0x3f800000, float:1.0)
            cz.mobilesoft.coreblock.scene.intro.OnboardingViewModel.i1(r0, r1)
            cz.mobilesoft.coreblock.scene.intro.OnboardingViewModel r0 = r8.f104543c
            android.os.CountDownTimer r0 = cz.mobilesoft.coreblock.scene.intro.OnboardingViewModel.Y0(r0)
            if (r0 != 0) goto L66
            cz.mobilesoft.coreblock.scene.intro.OnboardingViewModel r0 = r8.f104543c
            androidx.lifecycle.MutableLiveData r0 = r0.p1()
            java.lang.Float r1 = kotlin.coroutines.jvm.internal.Boxing.c(r1)
            r0.n(r1)
        L66:
            return r9
        L67:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.intro.OnboardingViewModel$appsWebsList$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(List list, Continuation continuation) {
        return ((OnboardingViewModel$appsWebsList$1) create(list, continuation)).invokeSuspend(Unit.f139807a);
    }
}
