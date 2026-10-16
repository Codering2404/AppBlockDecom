package cz.mobilesoft.coreblock.scene.schedule.customcombination;

import android.content.Context;
import androidx.activity.compose.ManagedActivityResultLauncher;
import cz.mobilesoft.coreblock.enums.Permission;
import cz.mobilesoft.coreblock.scene.permission.PermissionActivity;
import cz.mobilesoft.coreblock.util.permissions.PermissionDTO;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.schedule.customcombination.CustomCombinationScreenKt$CustomCombinationScreen$1$1", f = "CustomCombinationScreen.kt", l = {}, m = "invokeSuspend", v = 1)
final class CustomCombinationScreenKt$CustomCombinationScreen$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f116254a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ CustomCombinationViewState f116255b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Context f116256c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ ManagedActivityResultLauncher f116257d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CustomCombinationScreenKt$CustomCombinationScreen$1$1(CustomCombinationViewState customCombinationViewState, Context context, ManagedActivityResultLauncher managedActivityResultLauncher, Continuation continuation) {
        super(2, continuation);
        this.f116255b = customCombinationViewState;
        this.f116256c = context;
        this.f116257d = managedActivityResultLauncher;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new CustomCombinationScreenKt$CustomCombinationScreen$1$1(this.f116255b, this.f116256c, this.f116257d, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        IntrinsicsKt.f();
        if (this.f116254a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        if (Intrinsics.areEqual(this.f116255b.e().l(), Boxing.a(true))) {
            this.f116257d.b(PermissionActivity.Companion.b(PermissionActivity.f111772j, this.f116256c, CollectionsKt.listOf(new PermissionDTO(Permission.LOCATION.f96999d, false, false, 6, null)), true, false, false, Boxing.a(false), null, 88, null));
        }
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((CustomCombinationScreenKt$CustomCombinationScreen$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
