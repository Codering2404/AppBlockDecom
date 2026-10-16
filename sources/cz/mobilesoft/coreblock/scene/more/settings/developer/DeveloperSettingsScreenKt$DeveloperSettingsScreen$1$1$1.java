package cz.mobilesoft.coreblock.scene.more.settings.developer;

import android.content.Context;
import androidx.compose.material.ScaffoldState;
import androidx.compose.material.SnackbarHostState;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsScreenKt$DeveloperSettingsScreen$1$1$1", f = "DeveloperSettingsScreen.kt", l = {122}, m = "invokeSuspend", v = 1)
final class DeveloperSettingsScreenKt$DeveloperSettingsScreen$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f108304a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ ScaffoldState f108305b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Context f108306c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ int f108307d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DeveloperSettingsScreenKt$DeveloperSettingsScreen$1$1$1(ScaffoldState scaffoldState, Context context, int i3, Continuation continuation) {
        super(2, continuation);
        this.f108305b = scaffoldState;
        this.f108306c = context;
        this.f108307d = i3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new DeveloperSettingsScreenKt$DeveloperSettingsScreen$1$1$1(this.f108305b, this.f108306c, this.f108307d, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f108304a;
        if (i3 == 0) {
            ResultKt.b(obj);
            SnackbarHostState snackbarHostStateB = this.f108305b.b();
            String string = this.f108306c.getString(this.f108307d);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            this.f108304a = 1;
            if (SnackbarHostState.e(snackbarHostStateB, string, null, null, this, 6, null) == objF) {
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
        return ((DeveloperSettingsScreenKt$DeveloperSettingsScreen$1$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
