package androidx.navigation.compose;

import androidx.compose.runtime.State;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.navigation.NavBackStackEntry;
import java.util.List;
import java.util.Set;
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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
@DebugMetadata(c = "androidx.navigation.compose.DialogHostKt$DialogHost$2$1", f = "DialogHost.kt", l = {}, m = "invokeSuspend")
final class DialogHostKt$DialogHost$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f49077a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ State f49078b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ DialogNavigator f49079c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ SnapshotStateList f49080d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DialogHostKt$DialogHost$2$1(State state, DialogNavigator dialogNavigator, SnapshotStateList snapshotStateList, Continuation continuation) {
        super(2, continuation);
        this.f49078b = state;
        this.f49079c = dialogNavigator;
        this.f49080d = snapshotStateList;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new DialogHostKt$DialogHost$2$1(this.f49078b, this.f49079c, this.f49080d, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        IntrinsicsKt.f();
        if (this.f49077a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        Set<NavBackStackEntry> setH = DialogHostKt.h(this.f49078b);
        DialogNavigator dialogNavigator = this.f49079c;
        SnapshotStateList snapshotStateList = this.f49080d;
        for (NavBackStackEntry navBackStackEntry : setH) {
            if (!((List) dialogNavigator.r().getValue()).contains(navBackStackEntry) && !snapshotStateList.contains(navBackStackEntry)) {
                dialogNavigator.t(navBackStackEntry);
            }
        }
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((DialogHostKt$DialogHost$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
