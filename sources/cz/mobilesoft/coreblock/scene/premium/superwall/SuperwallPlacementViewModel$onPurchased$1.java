package cz.mobilesoft.coreblock.scene.premium.superwall;

import cz.mobilesoft.coreblock.enums.LoginAfterPurchase;
import cz.mobilesoft.coreblock.util.superwall.SuperwallPurchaseController;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.premium.superwall.SuperwallPlacementViewModel$onPurchased$1", f = "SuperwallPlacementViewModel.kt", l = {346, 347, 348, 349, 351}, m = "invokeSuspend", v = 1)
final class SuperwallPlacementViewModel$onPurchased$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f113825a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f113826b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    boolean f113827c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    boolean f113828d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    boolean f113829f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    int f113830g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ SuperwallPlacementViewModel f113831h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final /* synthetic */ boolean f113832i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SuperwallPlacementViewModel$onPurchased$1(SuperwallPlacementViewModel superwallPlacementViewModel, boolean z2, Continuation continuation) {
        super(1, continuation);
        this.f113831h = superwallPlacementViewModel;
        this.f113832i = z2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SuperwallPlacementViewState q(boolean z2, SuperwallPurchaseController.PurchaseInfo purchaseInfo, boolean z3, boolean z4, boolean z5, LoginAfterPurchase loginAfterPurchase, SuperwallPlacementViewState superwallPlacementViewState) {
        return SuperwallPlacementViewState.c(superwallPlacementViewState, null, false, (z2 || purchaseInfo == null || !purchaseInfo.b()) ? false : true, purchaseInfo != null ? purchaseInfo.a() : 7, z2, z3, z4, z5, loginAfterPurchase == LoginAfterPurchase.Optional, loginAfterPurchase, false, 1027, null);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new SuperwallPlacementViewModel$onPurchased$1(this.f113831h, this.f113832i, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x011b  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r15) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 309
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.premium.superwall.SuperwallPlacementViewModel$onPurchased$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation continuation) {
        return ((SuperwallPlacementViewModel$onPurchased$1) create(continuation)).invokeSuspend(Unit.f139807a);
    }
}
