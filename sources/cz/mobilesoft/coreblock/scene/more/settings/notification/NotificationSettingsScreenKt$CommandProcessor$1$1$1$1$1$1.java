package cz.mobilesoft.coreblock.scene.more.settings.notification;

import android.content.Context;
import androidx.compose.material.ScaffoldState;
import androidx.compose.material.SnackbarDuration;
import androidx.compose.material.SnackbarHostState;
import cz.mobilesoft.coreblock.enums.StrictModeTitleAlternatives;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.settings.notification.NotificationSettingsScreenKt$CommandProcessor$1$1$1$1$1$1", f = "NotificationSettingsScreen.kt", l = {108}, m = "invokeSuspend", v = 1)
final class NotificationSettingsScreenKt$CommandProcessor$1$1$1$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f109968a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ ScaffoldState f109969b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Context f109970c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    NotificationSettingsScreenKt$CommandProcessor$1$1$1$1$1$1(ScaffoldState scaffoldState, Context context, Continuation continuation) {
        super(2, continuation);
        this.f109969b = scaffoldState;
        this.f109970c = context;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new NotificationSettingsScreenKt$CommandProcessor$1$1$1$1$1$1(this.f109969b, this.f109970c, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f109968a;
        if (i3 == 0) {
            ResultKt.b(obj);
            SnackbarHostState snackbarHostStateB = this.f109969b.b();
            String string = this.f109970c.getString(StrictModeTitleAlternatives.Companion.a());
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            SnackbarDuration snackbarDuration = SnackbarDuration.Short;
            this.f109968a = 1;
            if (SnackbarHostState.e(snackbarHostStateB, string, null, snackbarDuration, this, 2, null) == objF) {
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
        return ((NotificationSettingsScreenKt$CommandProcessor$1$1$1$1$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
