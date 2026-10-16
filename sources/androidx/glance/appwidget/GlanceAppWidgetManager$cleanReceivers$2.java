package androidx.glance.appwidget;

import androidx.datastore.preferences.core.MutablePreferences;
import androidx.datastore.preferences.core.Preferences;
import java.util.ArrayList;
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
@DebugMetadata(c = "androidx.glance.appwidget.GlanceAppWidgetManager$cleanReceivers$2", f = "GlanceAppWidgetManager.kt", l = {}, m = "invokeSuspend")
final class GlanceAppWidgetManager$cleanReceivers$2 extends SuspendLambda implements Function2<Preferences, Continuation<? super Preferences>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f37981a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    /* synthetic */ Object f37982b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Set f37983c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    GlanceAppWidgetManager$cleanReceivers$2(Set set, Continuation continuation) {
        super(2, continuation);
        this.f37983c = set;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        GlanceAppWidgetManager$cleanReceivers$2 glanceAppWidgetManager$cleanReceivers$2 = new GlanceAppWidgetManager$cleanReceivers$2(this.f37983c, continuation);
        glanceAppWidgetManager$cleanReceivers$2.f37982b = obj;
        return glanceAppWidgetManager$cleanReceivers$2;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public final Object invoke(Preferences preferences, Continuation continuation) {
        return ((GlanceAppWidgetManager$cleanReceivers$2) create(preferences, continuation)).invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        IntrinsicsKt.f();
        if (this.f37981a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        Preferences preferences = (Preferences) this.f37982b;
        Set set = (Set) preferences.c(GlanceAppWidgetManager.f37973h);
        if (set != null) {
            Set set2 = this.f37983c;
            ArrayList arrayList = new ArrayList();
            for (Object obj2 : set) {
                if (!set2.contains((String) obj2)) {
                    arrayList.add(obj2);
                }
            }
            if (!arrayList.isEmpty()) {
                MutablePreferences mutablePreferencesD = preferences.d();
                mutablePreferencesD.k(GlanceAppWidgetManager.f37973h, SetsKt.minus(set, (Iterable) arrayList));
                int size = arrayList.size();
                int i3 = 0;
                while (i3 < size) {
                    Object obj3 = arrayList.get(i3);
                    i3++;
                    mutablePreferencesD.j(GlanceAppWidgetManager.f37969d.d((String) obj3));
                }
                return mutablePreferencesD.e();
            }
        }
        return preferences;
    }
}
