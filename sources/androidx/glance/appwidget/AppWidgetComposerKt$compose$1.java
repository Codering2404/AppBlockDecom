package androidx.glance.appwidget;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

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
@DebugMetadata(c = "androidx.glance.appwidget.AppWidgetComposerKt", f = "AppWidgetComposer.kt", l = {56, 57, 84, 99, 99}, m = "compose-1pU2XAk")
final class AppWidgetComposerKt$compose$1 extends ContinuationImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f37694a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f37695b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object f37696c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    Object f37697d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    Object f37698f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    Object f37699g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    Object f37700h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    Object f37701i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    int f37702j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    /* synthetic */ Object f37703k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    int f37704l;

    AppWidgetComposerKt$compose$1(Continuation continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f37703k = obj;
        this.f37704l |= Integer.MIN_VALUE;
        return AppWidgetComposerKt.a(null, null, null, null, null, null, null, null, this);
    }
}
