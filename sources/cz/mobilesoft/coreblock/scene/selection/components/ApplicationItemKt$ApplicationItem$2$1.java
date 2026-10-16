package cz.mobilesoft.coreblock.scene.selection.components;

import android.graphics.drawable.Drawable;
import androidx.compose.runtime.MutableState;
import cz.mobilesoft.coreblock.scene.selection.ApplicationStateDTO;
import cz.mobilesoft.coreblock.util.view.AppIconCache;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.selection.components.ApplicationItemKt$ApplicationItem$2$1", f = "ApplicationItem.kt", l = {102}, m = "invokeSuspend", v = 1)
final class ApplicationItemKt$ApplicationItem$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f118961a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ AppIconCache f118962b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ ApplicationStateDTO f118963c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ MutableState f118964d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ApplicationItemKt$ApplicationItem$2$1(AppIconCache appIconCache, ApplicationStateDTO applicationStateDTO, MutableState mutableState, Continuation continuation) {
        super(2, continuation);
        this.f118962b = appIconCache;
        this.f118963c = applicationStateDTO;
        this.f118964d = mutableState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new ApplicationItemKt$ApplicationItem$2$1(this.f118962b, this.f118963c, this.f118964d, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f118961a;
        if (i3 == 0) {
            ResultKt.b(obj);
            AppIconCache appIconCache = this.f118962b;
            String strF = this.f118963c.c().f();
            this.f118961a = 1;
            obj = appIconCache.f(strF, this);
            if (obj == objF) {
                return objF;
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        this.f118964d.setValue((Drawable) obj);
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((ApplicationItemKt$ApplicationItem$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
