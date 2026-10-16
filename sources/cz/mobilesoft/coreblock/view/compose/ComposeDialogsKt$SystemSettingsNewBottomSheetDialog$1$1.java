package cz.mobilesoft.coreblock.view.compose;

import android.content.Context;
import androidx.compose.runtime.MutableState;
import cz.mobilesoft.coreblock.scene.lockscreen.ossettings.SystemSettingsType;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.view.compose.ComposeDialogsKt$SystemSettingsNewBottomSheetDialog$1$1", f = "ComposeDialogs.kt", l = {}, m = "invokeSuspend", v = 1)
final class ComposeDialogsKt$SystemSettingsNewBottomSheetDialog$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f130446a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ CoroutineScope f130447b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Context f130448c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ Set f130449d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ MutableState f130450f;

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.view.compose.ComposeDialogsKt$SystemSettingsNewBottomSheetDialog$1$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.view.compose.ComposeDialogsKt$SystemSettingsNewBottomSheetDialog$1$1$1", f = "ComposeDialogs.kt", l = {}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f130451a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Context f130452b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Set f130453c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ MutableState f130454d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Context context, Set set, MutableState mutableState, Continuation continuation) {
            super(2, continuation);
            this.f130452b = context;
            this.f130453c = set;
            this.f130454d = mutableState;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass1(this.f130452b, this.f130453c, this.f130454d, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.f();
            if (this.f130451a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            ComposeDialogsKt.i1(this.f130454d, SystemSettingsType.Companion.b(this.f130452b, this.f130453c));
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ComposeDialogsKt$SystemSettingsNewBottomSheetDialog$1$1(CoroutineScope coroutineScope, Context context, Set set, MutableState mutableState, Continuation continuation) {
        super(2, continuation);
        this.f130447b = coroutineScope;
        this.f130448c = context;
        this.f130449d = set;
        this.f130450f = mutableState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new ComposeDialogsKt$SystemSettingsNewBottomSheetDialog$1$1(this.f130447b, this.f130448c, this.f130449d, this.f130450f, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        IntrinsicsKt.f();
        if (this.f130446a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        BuildersKt__Builders_commonKt.d(this.f130447b, null, null, new AnonymousClass1(this.f130448c, this.f130449d, this.f130450f, null), 3, null);
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((ComposeDialogsKt$SystemSettingsNewBottomSheetDialog$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
