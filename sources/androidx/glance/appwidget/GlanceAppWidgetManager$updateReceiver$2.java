package androidx.glance.appwidget;

import androidx.datastore.preferences.core.MutablePreferences;
import androidx.datastore.preferences.core.Preferences;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.SetsKt;
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
@DebugMetadata(c = "androidx.glance.appwidget.GlanceAppWidgetManager$updateReceiver$2", f = "GlanceAppWidgetManager.kt", l = {}, m = "invokeSuspend")
final class GlanceAppWidgetManager$updateReceiver$2 extends SuspendLambda implements Function2<Preferences, Continuation<? super Preferences>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f38006a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    /* synthetic */ Object f38007b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ String f38008c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ String f38009d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    GlanceAppWidgetManager$updateReceiver$2(String str, String str2, Continuation continuation) {
        super(2, continuation);
        this.f38008c = str;
        this.f38009d = str2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        GlanceAppWidgetManager$updateReceiver$2 glanceAppWidgetManager$updateReceiver$2 = new GlanceAppWidgetManager$updateReceiver$2(this.f38008c, this.f38009d, continuation);
        glanceAppWidgetManager$updateReceiver$2.f38007b = obj;
        return glanceAppWidgetManager$updateReceiver$2;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public final Object invoke(Preferences preferences, Continuation continuation) {
        return ((GlanceAppWidgetManager$updateReceiver$2) create(preferences, continuation)).invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        IntrinsicsKt.f();
        if (this.f38006a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        Preferences preferences = (Preferences) this.f38007b;
        MutablePreferences mutablePreferencesD = preferences.d();
        String str = this.f38008c;
        String str2 = this.f38009d;
        Preferences.Key key = GlanceAppWidgetManager.f37973h;
        Set setEmptySet = (Set) preferences.c(GlanceAppWidgetManager.f37973h);
        if (setEmptySet == null) {
            setEmptySet = SetsKt.emptySet();
        }
        mutablePreferencesD.k(key, SetsKt.plus((Set<? extends String>) setEmptySet, str));
        mutablePreferencesD.k(GlanceAppWidgetManager.f37969d.d(str), str2);
        return mutablePreferencesD.e();
    }
}
