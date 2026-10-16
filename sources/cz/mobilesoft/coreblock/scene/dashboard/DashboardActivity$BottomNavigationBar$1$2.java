package cz.mobilesoft.coreblock.scene.dashboard;

import androidx.navigation.NavHostController;
import cz.mobilesoft.coreblock.scene.dashboard.DashboardActivity;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.dashboard.DashboardActivity$BottomNavigationBar$1$2", f = "DashboardActivity.kt", l = {}, m = "invokeSuspend", v = 1)
final class DashboardActivity$BottomNavigationBar$1$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f99145a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Ref.BooleanRef f99146b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ DashboardActivity f99147c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ NavHostController f99148d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ Function1 f99149f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DashboardActivity$BottomNavigationBar$1$2(Ref.BooleanRef booleanRef, DashboardActivity dashboardActivity, NavHostController navHostController, Function1 function1, Continuation continuation) {
        super(2, continuation);
        this.f99146b = booleanRef;
        this.f99147c = dashboardActivity;
        this.f99148d = navHostController;
        this.f99149f = function1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new DashboardActivity$BottomNavigationBar$1$2(this.f99146b, this.f99147c, this.f99148d, this.f99149f, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        IntrinsicsKt.f();
        if (this.f99145a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        if (!this.f99146b.f140137a) {
            this.f99147c.M2(this.f99148d, DashboardActivity.NavBarItem.Blocking.f99175i, this.f99149f);
        }
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((DashboardActivity$BottomNavigationBar$1$2) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
