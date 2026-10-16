package androidx.glance.appwidget.state;

import androidx.datastore.preferences.core.MutablePreferences;
import androidx.datastore.preferences.core.Preferences;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
@DebugMetadata(c = "androidx.glance.appwidget.state.GlanceAppWidgetStateKt$updateAppWidgetState$4", f = "GlanceAppWidgetState.kt", l = {75}, m = "invokeSuspend")
final class GlanceAppWidgetStateKt$updateAppWidgetState$4 extends SuspendLambda implements Function2<Preferences, Continuation<? super Preferences>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f39368a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    /* synthetic */ Object f39369b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Function2 f39370c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    GlanceAppWidgetStateKt$updateAppWidgetState$4(Function2 function2, Continuation continuation) {
        super(2, continuation);
        this.f39370c = function2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        GlanceAppWidgetStateKt$updateAppWidgetState$4 glanceAppWidgetStateKt$updateAppWidgetState$4 = new GlanceAppWidgetStateKt$updateAppWidgetState$4(this.f39370c, continuation);
        glanceAppWidgetStateKt$updateAppWidgetState$4.f39369b = obj;
        return glanceAppWidgetStateKt$updateAppWidgetState$4;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public final Object invoke(Preferences preferences, Continuation continuation) {
        return ((GlanceAppWidgetStateKt$updateAppWidgetState$4) create(preferences, continuation)).invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f39368a;
        if (i3 != 0) {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            MutablePreferences mutablePreferences = (MutablePreferences) this.f39369b;
            ResultKt.b(obj);
            return mutablePreferences;
        }
        ResultKt.b(obj);
        MutablePreferences mutablePreferencesD = ((Preferences) this.f39369b).d();
        Function2 function2 = this.f39370c;
        this.f39369b = mutablePreferencesD;
        this.f39368a = 1;
        return function2.invoke(mutablePreferencesD, this) == objF ? objF : mutablePreferencesD;
    }
}
